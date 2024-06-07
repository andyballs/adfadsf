//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import org.mozilla.javascript.*;
import java.net.*;
import java.io.*;

public interface ModuleSourceProvider
{
    public static final ModuleSource NOT_MODIFIED = new ModuleSource((Reader)null, (Object)null, (URI)null, (URI)null, (Object)null);
    
    ModuleSource loadSource(final String p0, final Scriptable p1, final Object p2) throws IOException, URISyntaxException;
    
    ModuleSource loadSource(final URI p0, final URI p1, final Object p2) throws IOException, URISyntaxException;
}
