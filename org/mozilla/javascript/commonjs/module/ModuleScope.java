//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module;

import java.net.*;
import org.mozilla.javascript.*;

public class ModuleScope extends TopLevel
{
    private static final long serialVersionUID = 1L;
    private final URI uri;
    private final URI base;
    
    public ModuleScope(final Scriptable prototype, final URI uri, final URI base) {
        this.uri = uri;
        this.base = base;
        this.setPrototype(prototype);
        this.cacheBuiltins();
    }
    
    public URI getUri() {
        return this.uri;
    }
    
    public URI getBase() {
        return this.base;
    }
}
