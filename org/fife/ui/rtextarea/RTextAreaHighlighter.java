//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;
import java.util.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.awt.*;
import javax.swing.text.*;

public class RTextAreaHighlighter extends BasicTextUI.BasicHighlighter
{
    protected RTextArea textArea;
    private List<HighlightInfo> markAllHighlights;
    
    public RTextAreaHighlighter() {
        this.markAllHighlights = new ArrayList<HighlightInfo>();
    }
    
    Object addMarkAllHighlight(final int start, final int end, final Highlighter.HighlightPainter p) throws BadLocationException {
        final Document doc = this.textArea.getDocument();
        final TextUI mapper = this.textArea.getUI();
        final HighlightInfoImpl i = new LayeredHighlightInfoImpl();
        i.setPainter(p);
        i.p0 = doc.createPosition(start);
        i.p1 = doc.createPosition(end - 1);
        this.markAllHighlights.add(i);
        mapper.damageRange((JTextComponent)this.textArea, start, end);
        return i;
    }
    
    void clearMarkAllHighlights() {
        for (final HighlightInfo info : this.markAllHighlights) {
            this.repaintListHighlight(info);
        }
        this.markAllHighlights.clear();
    }
    
    @Override
    public void deinstall(final JTextComponent c) {
        this.textArea = null;
        this.markAllHighlights.clear();
    }
    
    public int getMarkAllHighlightCount() {
        return this.markAllHighlights.size();
    }
    
    public List<DocumentRange> getMarkAllHighlightRanges() {
        final List<DocumentRange> list = new ArrayList<DocumentRange>(this.markAllHighlights.size());
        for (final HighlightInfo info : this.markAllHighlights) {
            final int start = info.getStartOffset();
            final int end = info.getEndOffset() + 1;
            final DocumentRange range = new DocumentRange(start, end);
            list.add(range);
        }
        return list;
    }
    
    @Override
    public void install(final JTextComponent c) {
        super.install(c);
        this.textArea = (RTextArea)c;
    }
    
    @Override
    public void paintLayeredHighlights(final Graphics g, final int lineStart, final int lineEnd, final Shape viewBounds, final JTextComponent editor, final View view) {
        this.paintListLayered(g, lineStart, lineEnd, viewBounds, editor, view, this.markAllHighlights);
        super.paintLayeredHighlights(g, lineStart, lineEnd, viewBounds, editor, view);
    }
    
    protected void paintListLayered(final Graphics g, final int lineStart, final int lineEnd, final Shape viewBounds, final JTextComponent editor, final View view, final List<? extends HighlightInfo> highlights) {
        for (int i = highlights.size() - 1; i >= 0; --i) {
            final HighlightInfo tag = (HighlightInfo)highlights.get(i);
            if (tag instanceof LayeredHighlightInfo) {
                final LayeredHighlightInfo lhi = (LayeredHighlightInfo)tag;
                final int highlightStart = lhi.getStartOffset();
                final int highlightEnd = lhi.getEndOffset() + 1;
                if ((lineStart < highlightStart && lineEnd > highlightStart) || (lineStart >= highlightStart && lineStart < highlightEnd)) {
                    lhi.paintLayeredHighlights(g, lineStart, lineEnd, viewBounds, editor, view);
                }
            }
        }
    }
    
    protected void repaintListHighlight(final HighlightInfo info) {
        if (info instanceof LayeredHighlightInfoImpl) {
            final LayeredHighlightInfoImpl lhi = (LayeredHighlightInfoImpl)info;
            if (lhi.width > 0 && lhi.height > 0) {
                this.textArea.repaint(lhi.x, lhi.y, lhi.width, lhi.height);
            }
        }
        else {
            final TextUI ui = this.textArea.getUI();
            ui.damageRange((JTextComponent)this.textArea, info.getStartOffset(), info.getEndOffset());
        }
    }
    
    protected static class HighlightInfoImpl implements HighlightInfo
    {
        private Position p0;
        private Position p1;
        private Highlighter.HighlightPainter painter;
        
        public Color getColor() {
            return null;
        }
        
        @Override
        public int getStartOffset() {
            return this.p0.getOffset();
        }
        
        @Override
        public int getEndOffset() {
            return this.p1.getOffset();
        }
        
        @Override
        public Highlighter.HighlightPainter getPainter() {
            return this.painter;
        }
        
        public void setStartOffset(final Position startOffset) {
            this.p0 = startOffset;
        }
        
        public void setEndOffset(final Position endOffset) {
            this.p1 = endOffset;
        }
        
        public void setPainter(final Highlighter.HighlightPainter painter) {
            this.painter = painter;
        }
    }
    
    protected static class LayeredHighlightInfoImpl extends HighlightInfoImpl implements LayeredHighlightInfo
    {
        public int x;
        public int y;
        public int width;
        public int height;
        
        void union(final Shape bounds) {
            if (bounds == null) {
                return;
            }
            final Rectangle alloc = (Rectangle)((bounds instanceof Rectangle) ? bounds : bounds.getBounds());
            if (this.width == 0 || this.height == 0) {
                this.x = alloc.x;
                this.y = alloc.y;
                this.width = alloc.width;
                this.height = alloc.height;
            }
            else {
                this.width = Math.max(this.x + this.width, alloc.x + alloc.width);
                this.height = Math.max(this.y + this.height, alloc.y + alloc.height);
                this.x = Math.min(this.x, alloc.x);
                this.width -= this.x;
                this.y = Math.min(this.y, alloc.y);
                this.height -= this.y;
            }
        }
        
        @Override
        public void paintLayeredHighlights(final Graphics g, int p0, int p1, final Shape viewBounds, final JTextComponent editor, final View view) {
            final int start = this.getStartOffset();
            int end = this.getEndOffset();
            ++end;
            p0 = Math.max(start, p0);
            p1 = Math.min(end, p1);
            if (this.getColor() != null && this.getPainter() instanceof ChangeableHighlightPainter) {
                ((ChangeableHighlightPainter)this.getPainter()).setPaint((Paint)this.getColor());
            }
            this.union(((LayerPainter)this.getPainter()).paintLayer(g, p0, p1, viewBounds, editor, view));
        }
    }
    
    public interface HighlightInfo extends Highlighter.Highlight
    {
    }
    
    public interface LayeredHighlightInfo extends HighlightInfo
    {
        void paintLayeredHighlights(final Graphics p0, final int p1, final int p2, final Shape p3, final JTextComponent p4, final View p5);
    }
}
