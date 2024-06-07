//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.util.*;
import java.util.concurrent.*;
import org.mozilla.javascript.commonjs.module.*;

public class StrongCachingModuleScriptProvider extends CachingModuleScriptProviderBase
{
    private static final long serialVersionUID = 1L;
    private final Map<String, CachingModuleScriptProviderBase.CachedModuleScript> modules;
    
    public StrongCachingModuleScriptProvider(final ModuleSourceProvider moduleSourceProvider) {
        super(moduleSourceProvider);
        this.modules = new ConcurrentHashMap<String, CachingModuleScriptProviderBase.CachedModuleScript>(16, 0.75f, getConcurrencyLevel());
    }
    
    protected CachingModuleScriptProviderBase.CachedModuleScript getLoadedModule(final String moduleId) {
        return this.modules.get(moduleId);
    }
    
    protected void putLoadedModule(final String moduleId, final ModuleScript moduleScript, final Object validator) {
        this.modules.put(moduleId, new CachingModuleScriptProviderBase.CachedModuleScript(moduleScript, validator));
    }
}
