//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public interface DestructuringForm
{
    void setIsDestructuring(final boolean p0);
    
    boolean isDestructuring();
    
    void putDefaultValue(final String p0, final AstNode p1);
    
    AstNode getDefaultValue(final String p0);
}
