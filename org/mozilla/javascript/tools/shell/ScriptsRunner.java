//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import java.io.*;
import java.util.*;
import java.net.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.commonjs.module.*;

public class ScriptsRunner extends Main
{
    public static void main(final String[] _args) {
        final File scriptIndex = new File("./scripts/index.js");
        final ContextFactory cxFactory = new ScriptsRunnerContextFactory();
        final Context cx = cxFactory.enterContext();
        final Global global = new Global();
        global.init(cx);
        final List<String> modulePath = new ArrayList<String>();
        modulePath.add(scriptIndex.toURI().getPath());
        final Require require = global.installRequire(cx, (List)modulePath, false);
        require.getExportedModuleInterface(cx, "index", scriptIndex.toURI(), (URI)null, false);
        Context.exit();
    }
    
    private static class ScriptsRunnerContextFactory extends ContextFactory
    {
        protected void onContextCreated(final Context cx) {
            super.onContextCreated(cx);
            cx.setLanguageVersion(200);
            cx.setDebugOutputPath(new File(".", "DEBUG"));
        }
        
        protected boolean hasFeature(final Context cx, final int featureIndex) {
            return featureIndex == 19 || featureIndex == 9 || super.hasFeature(cx, featureIndex);
        }
    }
}
