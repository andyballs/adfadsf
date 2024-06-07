//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import java.awt.*;
import javax.swing.text.*;
import java.util.*;

class LineHighlightManager
{
    private RTextArea textArea;
    private List<LineHighlightInfo> lineHighlights;
    private LineHighlightInfoComparator comparator;
    
    LineHighlightManager(final RTextArea textArea) {
        this.textArea = textArea;
        this.comparator = new LineHighlightInfoComparator();
    }
    
    public Object addLineHighlight(final int line, final Color color) throws BadLocationException {
        final int offs = this.textArea.getLineStartOffset(line);
        final LineHighlightInfo lhi = new LineHighlightInfo(this.textArea.getDocument().createPosition(offs), color);
        if (this.lineHighlights == null) {
            this.lineHighlights = new ArrayList<LineHighlightInfo>(1);
        }
        int index = Collections.binarySearch(this.lineHighlights, lhi, this.comparator);
        if (index < 0) {
            index = -(index + 1);
        }
        this.lineHighlights.add(index, lhi);
        this.repaintLine(lhi);
        return lhi;
    }
    
    protected List<Object> getCurrentLineHighlightTags() {
        return (this.lineHighlights == null) ? Collections.emptyList() : new ArrayList<Object>(this.lineHighlights);
    }
    
    protected int getLineHighlightCount() {
        return (this.lineHighlights == null) ? 0 : this.lineHighlights.size();
    }
    
    public void paintLineHighlights(final Graphics g) {
        final int count = (this.lineHighlights == null) ? 0 : this.lineHighlights.size();
        if (count > 0) {
            final int docLen = this.textArea.getDocument().getLength();
            final Rectangle vr = this.textArea.getVisibleRect();
            final int lineHeight = this.textArea.getLineHeight();
            try {
                for (int i = 0; i < count; ++i) {
                    final LineHighlightInfo lhi = this.lineHighlights.get(i);
                    final int offs = lhi.getOffset();
                    if (offs >= 0 && offs <= docLen) {
                        final int y = this.textArea.yForLineContaining(offs);
                        if (y > vr.y - lineHeight) {
                            if (y >= vr.y + vr.height) {
                                break;
                            }
                            g.setColor(lhi.getColor());
                            g.fillRect(0, y, this.textArea.getWidth(), lineHeight);
                        }
                    }
                }
            }
            catch (BadLocationException ble) {
                ble.printStackTrace();
            }
        }
    }
    
    public void removeAllLineHighlights() {
        if (this.lineHighlights != null) {
            this.lineHighlights.clear();
            this.textArea.repaint();
        }
    }
    
    public void removeLineHighlight(final Object tag) {
        if (tag instanceof LineHighlightInfo) {
            this.lineHighlights.remove(tag);
            this.repaintLine((LineHighlightInfo)tag);
        }
    }
    
    private void repaintLine(final LineHighlightInfo lhi) {
        final int offs = lhi.getOffset();
        if (offs >= 0 && offs <= this.textArea.getDocument().getLength()) {
            try {
                final int y = this.textArea.yForLineContaining(offs);
                if (y > -1) {
                    this.textArea.repaint(0, y, this.textArea.getWidth(), this.textArea.getLineHeight());
                }
            }
            catch (BadLocationException ble) {
                ble.printStackTrace();
            }
        }
    }
    
    private static class LineHighlightInfo
    {
        private Position offs;
        private Color color;
        
        LineHighlightInfo(final Position offs, final Color c) {
            this.offs = offs;
            this.color = c;
        }
        
        @Override
        public boolean equals(final Object other) {
            if (other instanceof LineHighlightInfo) {
                final LineHighlightInfo lhi2 = (LineHighlightInfo)other;
                return this.getOffset() == lhi2.getOffset() && Objects.equals(this.getColor(), lhi2.getColor());
            }
            return false;
        }
        
        public Color getColor() {
            return this.color;
        }
        
        public int getOffset() {
            return this.offs.getOffset();
        }
        
        @Override
        public int hashCode() {
            return this.getOffset();
        }
    }
    
    private static class LineHighlightInfoComparator implements Comparator<LineHighlightInfo>
    {
        @Override
        public int compare(final LineHighlightInfo lhi1, final LineHighlightInfo lhi2) {
            if (lhi1.getOffset() < lhi2.getOffset()) {
                return -1;
            }
            return (lhi1.getOffset() != lhi2.getOffset()) ? 1 : 0;
        }
    }
}
