//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;

interface TokenFactory
{
    TokenImpl createToken();
    
    TokenImpl createToken(final Segment p0, final int p1, final int p2, final int p3, final int p4);
    
    TokenImpl createToken(final char[] p0, final int p1, final int p2, final int p3, final int p4);
    
    void resetAllTokens();
}
