//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

public interface GuiCallback
{
    void updateSourceText(final Dim.SourceInfo p0);
    
    void enterInterrupt(final Dim.StackFrame p0, final String p1, final String p2);
    
    boolean isGuiEventThread();
    
    void dispatchNextGuiEvent() throws InterruptedException;
}
