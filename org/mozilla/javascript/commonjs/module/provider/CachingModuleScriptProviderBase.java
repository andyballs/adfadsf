//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.net.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.commonjs.module.*;
import java.io.*;

public abstract class CachingModuleScriptProviderBase implements ModuleScriptProvider, Serializable
{
    private static final long serialVersionUID = -1L;
    private static final int loadConcurrencyLevel;
    private static final int loadLockShift;
    private static final int loadLockMask;
    private static final int loadLockCount;
    private final Object[] loadLocks;
    private final ModuleSourceProvider moduleSourceProvider;
    
    protected CachingModuleScriptProviderBase(final ModuleSourceProvider moduleSourceProvider) {
        this.loadLocks = new Object[CachingModuleScriptProviderBase.loadLockCount];
        for (int i = 0; i < this.loadLocks.length; ++i) {
            this.loadLocks[i] = new Object();
        }
        this.moduleSourceProvider = moduleSourceProvider;
    }
    
    public ModuleScript getModuleScript(final Context cx, final String moduleId, final URI moduleUri, final URI baseUri, final Scriptable paths) throws Exception {
        final CachedModuleScript cachedModule1 = this.getLoadedModule(moduleId);
        final Object validator1 = getValidator(cachedModule1);
        final ModuleSource moduleSource = (moduleUri == null) ? this.moduleSourceProvider.loadSource(moduleId, paths, validator1) : this.moduleSourceProvider.loadSource(moduleUri, baseUri, validator1);
        if (moduleSource == ModuleSourceProvider.NOT_MODIFIED) {
            return cachedModule1.getModule();
        }
        if (moduleSource == null) {
            return null;
        }
        try (final Reader reader = moduleSource.getReader()) {
            final int idHash = moduleId.hashCode();
            synchronized (this.loadLocks[idHash >>> CachingModuleScriptProviderBase.loadLockShift & CachingModuleScriptProviderBase.loadLockMask]) {
                final CachedModuleScript cachedModule2 = this.getLoadedModule(moduleId);
                if (cachedModule2 != null && !equal(validator1, getValidator(cachedModule2))) {
                    return cachedModule2.getModule();
                }
                final URI sourceUri = moduleSource.getUri();
                final ModuleScript moduleScript = new ModuleScript(cx.compileReader(reader, sourceUri.toString(), 1, moduleSource.getSecurityDomain()), sourceUri, moduleSource.getBase());
                this.putLoadedModule(moduleId, moduleScript, moduleSource.getValidator());
                return moduleScript;
            }
        }
    }
    
    protected abstract void putLoadedModule(final String p0, final ModuleScript p1, final Object p2);
    
    protected abstract CachedModuleScript getLoadedModule(final String p0);
    
    private static Object getValidator(final CachedModuleScript cachedModule) {
        return (cachedModule == null) ? null : cachedModule.getValidator();
    }
    
    private static boolean equal(final Object o1, final Object o2) {
        return (o1 == null) ? (o2 == null) : o1.equals(o2);
    }
    
    protected static int getConcurrencyLevel() {
        return CachingModuleScriptProviderBase.loadLockCount;
    }
    
    static {
        loadConcurrencyLevel = Runtime.getRuntime().availableProcessors() * 8;
        int sshift = 0;
        int ssize;
        for (ssize = 1; ssize < CachingModuleScriptProviderBase.loadConcurrencyLevel; ssize <<= 1) {
            ++sshift;
        }
        loadLockShift = 32 - sshift;
        loadLockMask = ssize - 1;
        loadLockCount = ssize;
    }
    
    public static class CachedModuleScript
    {
        private final ModuleScript moduleScript;
        private final Object validator;
        
        public CachedModuleScript(final ModuleScript moduleScript, final Object validator) {
            this.moduleScript = moduleScript;
            this.validator = validator;
        }
        
        ModuleScript getModule() {
            return this.moduleScript;
        }
        
        Object getValidator() {
            return this.validator;
        }
    }
}
