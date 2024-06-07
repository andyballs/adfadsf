//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.debug;

import org.mozilla.javascript.*;

public interface DebugFrame
{
    void onEnter(final Context p0, final Scriptable p1, final Scriptable p2, final Object[] p3);
    
    void onLineChange(final Context p0, final int p1);
    
    void onExceptionThrown(final Context p0, final Throwable p1);
    
    void onExit(final Context p0, final boolean p1, final Object p2);
    
    void onDebuggerStatement(final Context p0);
}
