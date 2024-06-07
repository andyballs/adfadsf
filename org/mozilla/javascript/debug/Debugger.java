//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.debug;

import org.mozilla.javascript.*;

public interface Debugger
{
    void handleCompilationDone(final Context p0, final DebuggableScript p1, final String p2);
    
    DebugFrame getFrame(final Context p0, final DebuggableScript p1);
}
