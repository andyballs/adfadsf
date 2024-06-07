//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.util.concurrent.*;
import java.net.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.commonjs.module.*;
import java.io.*;
import java.util.*;
import java.lang.ref.*;

public class SoftCachingModuleScriptProvider extends CachingModuleScriptProviderBase
{
    private static final long serialVersionUID = 1L;
    private transient ReferenceQueue<Script> scriptRefQueue;
    private transient ConcurrentMap<String, ScriptReference> scripts;
    
    public SoftCachingModuleScriptProvider(final ModuleSourceProvider moduleSourceProvider) {
        super(moduleSourceProvider);
        this.scriptRefQueue = new ReferenceQueue<Script>();
        this.scripts = new ConcurrentHashMap<String, ScriptReference>(16, 0.75f, getConcurrencyLevel());
    }
    
    public ModuleScript getModuleScript(final Context cx, final String moduleId, final URI uri, final URI base, final Scriptable paths) throws Exception {
        while (true) {
            final ScriptReference ref = (ScriptReference)this.scriptRefQueue.poll();
            if (ref == null) {
                break;
            }
            this.scripts.remove(ref.getModuleId(), ref);
        }
        return super.getModuleScript(cx, moduleId, uri, base, paths);
    }
    
    protected CachingModuleScriptProviderBase.CachedModuleScript getLoadedModule(final String moduleId) {
        final ScriptReference scriptRef = this.scripts.get(moduleId);
        return (scriptRef != null) ? scriptRef.getCachedModuleScript() : null;
    }
    
    protected void putLoadedModule(final String moduleId, final ModuleScript moduleScript, final Object validator) {
        this.scripts.put(moduleId, new ScriptReference(moduleScript.getScript(), moduleId, moduleScript.getUri(), moduleScript.getBase(), validator, this.scriptRefQueue));
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.scriptRefQueue = new ReferenceQueue<Script>();
        this.scripts = new ConcurrentHashMap<String, ScriptReference>();
        final Map<String, CachingModuleScriptProviderBase.CachedModuleScript> serScripts = (Map<String, CachingModuleScriptProviderBase.CachedModuleScript>)in.readObject();
        for (final Map.Entry<String, CachingModuleScriptProviderBase.CachedModuleScript> entry : serScripts.entrySet()) {
            final CachingModuleScriptProviderBase.CachedModuleScript cachedModuleScript = entry.getValue();
            this.putLoadedModule(entry.getKey(), cachedModuleScript.getModule(), cachedModuleScript.getValidator());
        }
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        final Map<String, CachingModuleScriptProviderBase.CachedModuleScript> serScripts = new HashMap<String, CachingModuleScriptProviderBase.CachedModuleScript>();
        for (final Map.Entry<String, ScriptReference> entry : this.scripts.entrySet()) {
            final CachingModuleScriptProviderBase.CachedModuleScript cachedModuleScript = entry.getValue().getCachedModuleScript();
            if (cachedModuleScript != null) {
                serScripts.put(entry.getKey(), cachedModuleScript);
            }
        }
        out.writeObject(serScripts);
    }
    
    private static class ScriptReference extends SoftReference<Script>
    {
        private final String moduleId;
        private final URI uri;
        private final URI base;
        private final Object validator;
        
        ScriptReference(final Script script, final String moduleId, final URI uri, final URI base, final Object validator, final ReferenceQueue<Script> refQueue) {
            super(script, refQueue);
            this.moduleId = moduleId;
            this.uri = uri;
            this.base = base;
            this.validator = validator;
        }
        
        CachingModuleScriptProviderBase.CachedModuleScript getCachedModuleScript() {
            final Script script = this.get();
            if (script == null) {
                return null;
            }
            return new CachingModuleScriptProviderBase.CachedModuleScript(new ModuleScript(script, this.uri, this.base), this.validator);
        }
        
        String getModuleId() {
            return this.moduleId;
        }
    }
}
