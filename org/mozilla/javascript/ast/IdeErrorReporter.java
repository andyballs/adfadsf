//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public interface IdeErrorReporter extends ErrorReporter
{
    void warning(final String p0, final String p1, final int p2, final int p3);
    
    void error(final String p0, final String p1, final int p2, final int p3);
}
