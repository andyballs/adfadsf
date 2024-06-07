//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public interface ErrorReporter
{
    void warning(final String p0, final String p1, final int p2, final String p3, final int p4);
    
    void error(final String p0, final String p1, final int p2, final String p3, final int p4);
    
    EvaluatorException runtimeError(final String p0, final String p1, final int p2, final String p3, final int p4);
}
