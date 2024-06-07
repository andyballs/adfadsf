//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;
import javax.swing.*;

public interface TokenMaker
{
    void addNullToken();
    
    void addToken(final char[] p0, final int p1, final int p2, final int p3, final int p4);
    
    int getClosestStandardTokenTypeForInternalType(final int p0);
    
    boolean getCurlyBracesDenoteCodeBlocks(final int p0);
    
    int getLastTokenTypeOnLine(final Segment p0, final int p1);
    
    String[] getLineCommentStartAndEnd(final int p0);
    
    Action getInsertBreakAction();
    
    boolean getMarkOccurrencesOfTokenType(final int p0);
    
    OccurrenceMarker getOccurrenceMarker();
    
    boolean getShouldIndentNextLineAfter(final Token p0);
    
    Token getTokenList(final Segment p0, final int p1, final int p2);
    
    boolean isIdentifierChar(final int p0, final char p1);
    
    boolean isMarkupLanguage();
}
