//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.awt.*;

public final class HtmlUtil
{
    private HtmlUtil() {
    }
    
    public static String escapeForHtml(final String s, String newlineReplacement, final boolean inPreBlock) {
        if (s == null) {
            return null;
        }
        if (newlineReplacement == null) {
            newlineReplacement = "";
        }
        final String tabString = inPreBlock ? "    " : "&nbsp;&nbsp;&nbsp;&nbsp;";
        boolean lastWasSpace = false;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            switch (ch) {
                case ' ': {
                    if (inPreBlock || !lastWasSpace) {
                        sb.append(' ');
                    }
                    else {
                        sb.append("&nbsp;");
                    }
                    lastWasSpace = true;
                    break;
                }
                case '\n': {
                    sb.append(newlineReplacement);
                    lastWasSpace = false;
                    break;
                }
                case '&': {
                    sb.append("&amp;");
                    lastWasSpace = false;
                    break;
                }
                case '\t': {
                    sb.append(tabString);
                    lastWasSpace = true;
                    break;
                }
                case '<': {
                    sb.append("&lt;");
                    lastWasSpace = false;
                    break;
                }
                case '>': {
                    sb.append("&gt;");
                    lastWasSpace = false;
                    break;
                }
                case '\'': {
                    sb.append("&#39;");
                    lastWasSpace = false;
                    break;
                }
                case '\"': {
                    sb.append("&#34;");
                    lastWasSpace = false;
                    break;
                }
                case '/': {
                    sb.append("&#47;");
                    lastWasSpace = false;
                    break;
                }
                default: {
                    sb.append(ch);
                    lastWasSpace = false;
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    public static String getHexString(final Color c) {
        if (c == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder("#");
        final int r = c.getRed();
        if (r < 16) {
            sb.append('0');
        }
        sb.append(Integer.toHexString(r));
        final int g = c.getGreen();
        if (g < 16) {
            sb.append('0');
        }
        sb.append(Integer.toHexString(g));
        final int b = c.getBlue();
        if (b < 16) {
            sb.append('0');
        }
        sb.append(Integer.toHexString(b));
        return sb.toString();
    }
    
    public static String getTextAsHtml(final RSyntaxTextArea textArea, final int start, final int end) {
        final StringBuilder sb = new StringBuilder("<pre style='").append("font-family: \"").append(textArea.getFont().getFamily()).append("\", courier;");
        if (textArea.getBackground() != null) {
            sb.append(" background: ").append(getHexString(textArea.getBackground())).append("'>");
        }
        Token t;
        for (Token token = t = textArea.getTokenListFor(start, end); t != null; t = t.getNextToken()) {
            if (t.isPaintable()) {
                if (t.isSingleChar('\n')) {
                    sb.append("<br>");
                }
                else {
                    sb.append(TokenUtils.tokenToHtml(textArea, t));
                }
            }
        }
        sb.append("</pre>");
        return sb.toString();
    }
}
