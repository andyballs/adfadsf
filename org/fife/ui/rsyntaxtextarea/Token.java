//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;
import java.awt.*;

public interface Token extends TokenTypes
{
    StringBuilder appendHTMLRepresentation(final StringBuilder p0, final RSyntaxTextArea p1, final boolean p2);
    
    StringBuilder appendHTMLRepresentation(final StringBuilder p0, final RSyntaxTextArea p1, final boolean p2, final boolean p3);
    
    char charAt(final int p0);
    
    boolean containsPosition(final int p0);
    
    int documentToToken(final int p0);
    
    boolean endsWith(final char[] p0);
    
    int getEndOffset();
    
    String getHTMLRepresentation(final RSyntaxTextArea p0);
    
    int getLanguageIndex();
    
    Token getLastNonCommentNonWhitespaceToken();
    
    Token getLastPaintableToken();
    
    String getLexeme();
    
    int getListOffset(final RSyntaxTextArea p0, final TabExpander p1, final float p2, final float p3);
    
    Token getNextToken();
    
    int getOffset();
    
    int getOffsetBeforeX(final RSyntaxTextArea p0, final TabExpander p1, final float p2, final float p3);
    
    char[] getTextArray();
    
    int getTextOffset();
    
    int getType();
    
    float getWidth(final RSyntaxTextArea p0, final TabExpander p1, final float p2);
    
    float getWidthUpTo(final int p0, final RSyntaxTextArea p1, final TabExpander p2, final float p3);
    
    boolean is(final char[] p0);
    
    boolean is(final int p0, final char[] p1);
    
    boolean is(final int p0, final String p1);
    
    boolean isComment();
    
    boolean isCommentOrWhitespace();
    
    boolean isHyperlink();
    
    boolean isIdentifier();
    
    boolean isLeftCurly();
    
    boolean isRightCurly();
    
    boolean isPaintable();
    
    boolean isSingleChar(final char p0);
    
    boolean isSingleChar(final int p0, final char p1);
    
    boolean isWhitespace();
    
    int length();
    
    Rectangle listOffsetToView(final RSyntaxTextArea p0, final TabExpander p1, final int p2, final int p3, final Rectangle p4);
    
    void setHyperlink(final boolean p0);
    
    void setLanguageIndex(final int p0);
    
    void setType(final int p0);
    
    boolean startsWith(final char[] p0);
    
    int tokenToDocument(final int p0);
}
