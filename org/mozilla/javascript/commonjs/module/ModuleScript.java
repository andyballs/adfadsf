//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module;

import java.io.*;
import org.mozilla.javascript.*;
import java.net.*;

public class ModuleScript implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final Script script;
    private final URI uri;
    private final URI base;
    
    public ModuleScript(final Script script, final URI uri, final URI base) {
        this.script = script;
        this.uri = uri;
        this.base = base;
    }
    
    public Script getScript() {
        return this.script;
    }
    
    public URI getUri() {
        return this.uri;
    }
    
    public URI getBase() {
        return this.base;
    }
    
    public boolean isSandboxed() {
        return this.base != null && this.uri != null && !this.base.relativize(this.uri).isAbsolute();
    }
}
