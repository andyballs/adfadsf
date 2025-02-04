//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.awt.geom.*;
import javax.swing.text.*;
import java.awt.*;

class DefaultTokenPainter implements TokenPainter
{
    private Rectangle2D.Float bgRect;
    private static char[] tabBuf;
    
    DefaultTokenPainter() {
        this.bgRect = new Rectangle2D.Float();
    }
    
    @Override
    public final float paint(final Token token, final Graphics2D g, final float x, final float y, final RSyntaxTextArea host, final TabExpander e) {
        return this.paint(token, g, x, y, host, e, 0.0f);
    }
    
    @Override
    public float paint(final Token token, final Graphics2D g, final float x, final float y, final RSyntaxTextArea host, final TabExpander e, final float clipStart) {
        return this.paintImpl(token, g, x, y, host, e, clipStart, false, false);
    }
    
    @Override
    public float paint(final Token token, final Graphics2D g, final float x, final float y, final RSyntaxTextArea host, final TabExpander e, final float clipStart, final boolean paintBG) {
        return this.paintImpl(token, g, x, y, host, e, clipStart, !paintBG, false);
    }
    
    protected void paintBackground(final float x, final float y, final float width, final float height, final Graphics2D g, final int fontAscent, final RSyntaxTextArea host, final Color color) {
        g.setColor(color);
        this.bgRect.setRect(x, y - fontAscent, width, height);
        g.fillRect((int)x, (int)(y - fontAscent), (int)width, (int)height);
    }
    
    protected float paintImpl(final Token token, final Graphics2D g, float x, final float y, final RSyntaxTextArea host, final TabExpander e, final float clipStart, final boolean selected, final boolean useSTC) {
        final int origX = (int)x;
        final int textOffs = token.getTextOffset();
        final char[] text = token.getTextArray();
        final int end = textOffs + token.length();
        float nextX = x;
        int flushLen = 0;
        int flushIndex = textOffs;
        final Color fg = useSTC ? host.getSelectedTextColor() : host.getForegroundForToken(token);
        final Color bg = selected ? null : host.getBackgroundForToken(token);
        g.setFont(host.getFontForTokenType(token.getType()));
        final FontMetrics fm = host.getFontMetricsForTokenType(token.getType());
        for (int i = textOffs; i < end; ++i) {
            switch (text[i]) {
                case '\t': {
                    nextX = e.nextTabStop(x + fm.charsWidth(text, flushIndex, flushLen), 0);
                    if (bg != null) {
                        this.paintBackground(x, y, nextX - x, (float)fm.getHeight(), g, fm.getAscent(), host, bg);
                    }
                    if (flushLen > 0) {
                        g.setColor(fg);
                        g.drawChars(text, flushIndex, flushLen, (int)x, (int)y);
                        flushLen = 0;
                    }
                    flushIndex = i + 1;
                    x = nextX;
                    break;
                }
                default: {
                    ++flushLen;
                    break;
                }
            }
        }
        nextX = x + fm.charsWidth(text, flushIndex, flushLen);
        final Rectangle r = host.getMatchRectangle();
        if (flushLen > 0 && nextX >= clipStart) {
            if (bg != null) {
                this.paintBackground(x, y, nextX - x, (float)fm.getHeight(), g, fm.getAscent(), host, bg);
                if (token.length() == 1 && r != null && r.x == x) {
                    ((RSyntaxTextAreaUI)host.getUI()).paintMatchedBracketImpl(g, host, r);
                }
            }
            g.setColor(fg);
            g.drawChars(text, flushIndex, flushLen, (int)x, (int)y);
        }
        if (host.getUnderlineForToken(token)) {
            g.setColor(fg);
            final int y2 = (int)(y + 1.0f);
            g.drawLine(origX, y2, (int)nextX, y2);
        }
        if (host.getPaintTabLines() && origX == host.getMargin().left) {
            this.paintTabLines(token, origX, (int)y, (int)nextX, g, e, host);
        }
        return nextX;
    }
    
    @Override
    public float paintSelected(final Token token, final Graphics2D g, final float x, final float y, final RSyntaxTextArea host, final TabExpander e, final boolean useSTC) {
        return this.paintSelected(token, g, x, y, host, e, 0.0f, useSTC);
    }
    
    @Override
    public float paintSelected(final Token token, final Graphics2D g, final float x, final float y, final RSyntaxTextArea host, final TabExpander e, final float clipStart, final boolean useSTC) {
        return this.paintImpl(token, g, x, y, host, e, clipStart, true, useSTC);
    }
    
    protected void paintTabLines(final Token token, final int x, final int y, int endX, final Graphics2D g, final TabExpander e, final RSyntaxTextArea host) {
        if (token.getType() != 21) {
            int offs;
            for (offs = 0; offs < token.length() && RSyntaxUtilities.isWhitespace(token.charAt(offs)); ++offs) {}
            if (offs < 2) {
                return;
            }
            endX = (int)token.getWidthUpTo(offs, host, e, 0.0f);
        }
        final FontMetrics fm = host.getFontMetricsForTokenType(token.getType());
        final int tabSize = host.getTabSize();
        if (DefaultTokenPainter.tabBuf == null || DefaultTokenPainter.tabBuf.length < tabSize) {
            DefaultTokenPainter.tabBuf = new char[tabSize];
            for (int i = 0; i < tabSize; ++i) {
                DefaultTokenPainter.tabBuf[i] = ' ';
            }
        }
        final int tabW = fm.charsWidth(DefaultTokenPainter.tabBuf, 0, tabSize);
        g.setColor(host.getTabLineColor());
        int x2 = x + tabW;
        int y2 = y - fm.getAscent();
        if ((y2 & 0x1) > 0) {
            ++y2;
        }
        final Token next = token.getNextToken();
        if (next == null || !next.isPaintable()) {
            ++endX;
        }
        while (x2 < endX) {
            for (int y3 = y2, y4 = y2 + host.getLineHeight(); y3 < y4; y3 += 2) {
                g.drawLine(x2, y3, x2, y3);
            }
            x2 += tabW;
        }
    }
}
