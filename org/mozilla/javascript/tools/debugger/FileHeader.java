//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

class FileHeader extends JPanel implements MouseListener
{
    private static final long serialVersionUID = -2858905404778259127L;
    private int pressLine;
    private FileWindow fileWindow;
    
    public FileHeader(final FileWindow fileWindow) {
        this.pressLine = -1;
        this.fileWindow = fileWindow;
        this.addMouseListener(this);
        this.update();
    }
    
    public void update() {
        final FileTextArea textArea = this.fileWindow.textArea;
        final Font font = textArea.getFont();
        this.setFont(font);
        final FontMetrics metrics = this.getFontMetrics(font);
        final int h = metrics.getHeight();
        final int lineCount = textArea.getLineCount() + 1;
        String dummy = Integer.toString(lineCount);
        if (dummy.length() < 2) {
            dummy = "99";
        }
        final Dimension d = new Dimension();
        d.width = metrics.stringWidth(dummy) + 16;
        d.height = lineCount * h + 100;
        this.setPreferredSize(d);
        this.setSize(d);
    }
    
    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        final FileTextArea textArea = this.fileWindow.textArea;
        final Font font = textArea.getFont();
        g.setFont(font);
        final FontMetrics metrics = this.getFontMetrics(font);
        final Rectangle clip = g.getClipBounds();
        g.setColor(this.getBackground());
        g.fillRect(clip.x, clip.y, clip.width, clip.height);
        final int ascent = metrics.getMaxAscent();
        final int h = metrics.getHeight();
        final int lineCount = textArea.getLineCount() + 1;
        String dummy = Integer.toString(lineCount);
        if (dummy.length() < 2) {
            dummy = "99";
        }
        final int startLine = clip.y / h;
        int endLine = (clip.y + clip.height) / h + 1;
        final int width = this.getWidth();
        if (endLine > lineCount) {
            endLine = lineCount;
        }
        for (int i = startLine; i < endLine; ++i) {
            int pos = -2;
            try {
                pos = textArea.getLineStartOffset(i);
            }
            catch (BadLocationException ex) {}
            final boolean isBreakPoint = this.fileWindow.isBreakPoint(i + 1);
            final String text = Integer.toString(i + 1) + " ";
            int y = i * h;
            g.setColor(Color.blue);
            g.drawString(text, 0, y + ascent);
            int x = width - ascent;
            if (isBreakPoint) {
                g.setColor(new Color(128, 0, 0));
                final int dy = y + ascent - 9;
                g.fillOval(x, dy, 9, 9);
                g.drawOval(x, dy, 8, 8);
                g.drawOval(x, dy, 9, 9);
            }
            if (pos == this.fileWindow.currentPos) {
                final Polygon arrow = new Polygon();
                final int dx = x;
                final int dy2;
                y = (dy2 = y + (ascent - 10));
                arrow.addPoint(dx, dy2 + 3);
                arrow.addPoint(dx + 5, dy2 + 3);
                for (x = dx + 5; x <= dx + 10; ++x, ++y) {
                    arrow.addPoint(x, y);
                }
                for (x = dx + 9; x >= dx + 5; --x, ++y) {
                    arrow.addPoint(x, y);
                }
                arrow.addPoint(dx + 5, dy2 + 7);
                arrow.addPoint(dx, dy2 + 7);
                g.setColor(Color.yellow);
                g.fillPolygon(arrow);
                g.setColor(Color.black);
                g.drawPolygon(arrow);
            }
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        final Font font = this.fileWindow.textArea.getFont();
        final FontMetrics metrics = this.getFontMetrics(font);
        final int h = metrics.getHeight();
        this.pressLine = e.getY() / h;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        if (e.getComponent() == this && (e.getModifiers() & 0x10) != 0x0) {
            final int y = e.getY();
            final Font font = this.fileWindow.textArea.getFont();
            final FontMetrics metrics = this.getFontMetrics(font);
            final int h = metrics.getHeight();
            final int line = y / h;
            if (line == this.pressLine) {
                this.fileWindow.toggleBreakPoint(line + 1);
            }
            else {
                this.pressLine = -1;
            }
        }
    }
}
