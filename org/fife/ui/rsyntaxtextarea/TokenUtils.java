//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;
import java.awt.*;

public final class TokenUtils
{
    private TokenUtils() {
    }
    
    public static TokenSubList getSubTokenList(final Token tokenList, final int pos, final TabExpander e, final RSyntaxTextArea textArea, final float x0) {
        return getSubTokenList(tokenList, pos, e, textArea, x0, null);
    }
    
    public static TokenSubList getSubTokenList(final Token tokenList, final int pos, final TabExpander e, final RSyntaxTextArea textArea, float x0, TokenImpl tempToken) {
        if (tempToken == null) {
            tempToken = new TokenImpl();
        }
        Token t;
        for (t = tokenList; t != null && t.isPaintable() && !t.containsPosition(pos); t = t.getNextToken()) {
            x0 += t.getWidth(textArea, e, x0);
        }
        if (t == null || !t.isPaintable()) {
            return new TokenSubList(tokenList, x0);
        }
        if (t.getOffset() != pos) {
            final int difference = pos - t.getOffset();
            x0 += t.getWidthUpTo(t.length() - difference + 1, textArea, e, x0);
            tempToken.copyFrom(t);
            tempToken.makeStartAt(pos);
            return new TokenSubList((Token)tempToken, x0);
        }
        return new TokenSubList(t, x0);
    }
    
    public static int getWhiteSpaceTokenLength(final Token t, final int tabSize, int curOffs) {
        int length = 0;
        for (int i = 0; i < t.length(); ++i) {
            final char ch = t.charAt(i);
            if (ch == '\t') {
                final int newCurOffs = (curOffs + tabSize) / tabSize * tabSize;
                length += newCurOffs - curOffs;
                curOffs = newCurOffs;
            }
            else {
                ++length;
                ++curOffs;
            }
        }
        return length;
    }
    
    public static boolean isBlankOrAllWhiteSpace(Token t) {
        while (t != null && t.isPaintable()) {
            if (!t.isCommentOrWhitespace()) {
                return false;
            }
            t = t.getNextToken();
        }
        return true;
    }
    
    public static boolean isBlankOrAllWhiteSpaceWithoutComments(Token t) {
        while (t != null && t.isPaintable()) {
            if (!t.isWhitespace()) {
                return false;
            }
            t = t.getNextToken();
        }
        return true;
    }
    
    public static String tokenToHtml(final RSyntaxTextArea textArea, final Token token) {
        final StringBuilder style = new StringBuilder();
        final Font font = textArea.getFontForTokenType(token.getType());
        if (font.isBold()) {
            style.append("font-weight: bold;");
        }
        if (font.isItalic()) {
            style.append("font-style: italic;");
        }
        final Color c = textArea.getForegroundForToken(token);
        style.append("color: ").append(HtmlUtil.getHexString(c)).append(";");
        return "<span style=\"" + (Object)style + "\">" + HtmlUtil.escapeForHtml(token.getLexeme(), "\n", true) + "</span>";
    }
    
    public static class TokenSubList
    {
        public Token tokenList;
        public float x;
        
        public TokenSubList(final Token tokenList, final float x) {
            this.tokenList = tokenList;
            this.x = x;
        }
    }
}
