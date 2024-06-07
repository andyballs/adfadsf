//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public interface SymbolScriptable
{
    Object get(final Symbol p0, final Scriptable p1);
    
    boolean has(final Symbol p0, final Scriptable p1);
    
    void put(final Symbol p0, final Scriptable p1, final Object p2);
    
    void delete(final Symbol p0);
}
