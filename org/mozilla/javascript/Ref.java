//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public abstract class Ref implements Serializable
{
    private static final long serialVersionUID = 4044540354730911424L;
    
    public boolean has(final Context cx) {
        return true;
    }
    
    public abstract Object get(final Context p0);
    
    @Deprecated
    public abstract Object set(final Context p0, final Object p1);
    
    public Object set(final Context cx, final Scriptable scope, final Object value) {
        return this.set(cx, value);
    }
    
    public boolean delete(final Context cx) {
        return false;
    }
}
