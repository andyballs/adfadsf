//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.util.*;
import java.net.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.commonjs.module.*;

public class MultiModuleScriptProvider implements ModuleScriptProvider
{
    private final ModuleScriptProvider[] providers;
    
    public MultiModuleScriptProvider(final Iterable<? extends ModuleScriptProvider> providers) {
        final List<ModuleScriptProvider> l = new LinkedList<ModuleScriptProvider>();
        for (final ModuleScriptProvider provider : providers) {
            l.add(provider);
        }
        this.providers = l.toArray(new ModuleScriptProvider[l.size()]);
    }
    
    public ModuleScript getModuleScript(final Context cx, final String moduleId, final URI uri, final URI base, final Scriptable paths) throws Exception {
        for (final ModuleScriptProvider provider : this.providers) {
            final ModuleScript script = provider.getModuleScript(cx, moduleId, uri, base, paths);
            if (script != null) {
                return script;
            }
        }
        return null;
    }
}
