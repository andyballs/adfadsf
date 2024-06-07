//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import org.fife.ui.rsyntaxtextarea.focusabletip.*;
import org.fife.ui.rsyntaxtextarea.folding.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.awt.*;
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.beans.*;

public class FoldIndicator extends AbstractGutterComponent
{
    private Insets textAreaInsets;
    private Rectangle visibleRect;
    private Fold foldWithOutlineShowing;
    private Color foldIconBackground;
    private Color foldIconArmedBackground;
    private Icon collapsedFoldIcon;
    private Icon expandedFoldIcon;
    private boolean mouseOverFoldIcon;
    private boolean paintFoldArmed;
    private boolean showFoldRegionTips;
    private int additionalLeftMargin;
    public static final Color DEFAULT_FOREGROUND;
    public static final Color DEFAULT_FOLD_BACKGROUND;
    private Listener listener;
    private static final int WIDTH = 12;
    
    public FoldIndicator(final RTextArea textArea) {
        super(textArea);
    }
    
    public JToolTip createToolTip() {
        final JToolTip tip = super.createToolTip();
        tip.setBackground(TipUtil.getToolTipBackground(this.textArea));
        tip.setBorder(TipUtil.getToolTipBorder(this.textArea));
        return tip;
    }
    
    public int getAdditionalLeftMargin() {
        return this.additionalLeftMargin;
    }
    
    private Fold findOpenFoldClosestTo(final Point p) {
        Fold fold = null;
        this.mouseOverFoldIcon = false;
        final RSyntaxTextArea rsta = (RSyntaxTextArea)this.textArea;
        if (rsta.isCodeFoldingEnabled()) {
            final int offs = rsta.viewToModel(p);
            if (offs > -1) {
                try {
                    final int line = rsta.getLineOfOffset(offs);
                    final FoldManager fm = rsta.getFoldManager();
                    fold = fm.getFoldForLine(line);
                    if (fold != null) {
                        this.mouseOverFoldIcon = true;
                    }
                    else {
                        fold = fm.getDeepestOpenFoldContaining(offs);
                    }
                }
                catch (BadLocationException ble) {
                    ble.printStackTrace();
                }
            }
        }
        return fold;
    }
    
    public Color getFoldIconArmedBackground() {
        return this.foldIconArmedBackground;
    }
    
    public Color getFoldIconBackground() {
        return this.foldIconBackground;
    }
    
    public Dimension getPreferredSize() {
        final int h = (this.textArea != null) ? this.textArea.getHeight() : 100;
        return new Dimension(12 + this.additionalLeftMargin, h);
    }
    
    public boolean getShowCollapsedRegionToolTips() {
        return this.showFoldRegionTips;
    }
    
    public Point getToolTipLocation(final MouseEvent e) {
        final String text = this.getToolTipText(e);
        if (text == null) {
            return null;
        }
        final Point p = e.getPoint();
        p.y = p.y / this.textArea.getLineHeight() * this.textArea.getLineHeight();
        p.x = this.getWidth() + this.textArea.getMargin().left;
        final Gutter gutter = this.getGutter();
        final int gutterMargin = gutter.getInsets().right;
        final Point point = p;
        point.x += gutterMargin;
        final JToolTip tempTip = this.createToolTip();
        final Point point2 = p;
        point2.x -= tempTip.getInsets().left;
        final Point point3 = p;
        point3.y += 16;
        return p;
    }
    
    public String getToolTipText(final MouseEvent e) {
        String text = null;
        final RSyntaxTextArea rsta = (RSyntaxTextArea)this.textArea;
        if (rsta.isCodeFoldingEnabled()) {
            final FoldManager fm = rsta.getFoldManager();
            final int pos = rsta.viewToModel(new Point(0, e.getY()));
            if (pos >= 0) {
                int line = 0;
                try {
                    line = rsta.getLineOfOffset(pos);
                }
                catch (BadLocationException ble) {
                    ble.printStackTrace();
                    return null;
                }
                final Fold fold = fm.getFoldForLine(line);
                if (fold != null && fold.isCollapsed()) {
                    int endLine = fold.getEndLine();
                    if (fold.getLineCount() > 25) {
                        endLine = fold.getStartLine() + 25;
                    }
                    final StringBuilder sb = new StringBuilder("<html><nobr>");
                    while (line <= endLine && line < rsta.getLineCount()) {
                        for (Token t = rsta.getTokenListForLine(line); t != null && t.isPaintable(); t = t.getNextToken()) {
                            t.appendHTMLRepresentation(sb, rsta, true, true);
                        }
                        sb.append("<br>");
                        ++line;
                    }
                    text = sb.toString();
                }
            }
        }
        return text;
    }
    
    void handleDocumentEvent(final DocumentEvent e) {
        final int newLineCount = this.textArea.getLineCount();
        if (newLineCount != this.currentLineCount) {
            this.currentLineCount = newLineCount;
            this.repaint();
        }
    }
    
    protected void init() {
        super.init();
        this.setForeground(FoldIndicator.DEFAULT_FOREGROUND);
        this.setFoldIconBackground(FoldIndicator.DEFAULT_FOLD_BACKGROUND);
        this.collapsedFoldIcon = new FoldIcon(true);
        this.expandedFoldIcon = new FoldIcon(false);
        this.listener = new Listener(this);
        this.visibleRect = new Rectangle();
        this.setShowCollapsedRegionToolTips(true);
    }
    
    void lineHeightsChanged() {
    }
    
    protected void paintComponent(final Graphics g) {
        if (this.textArea == null) {
            return;
        }
        this.visibleRect = g.getClipBounds(this.visibleRect);
        if (this.visibleRect == null) {
            this.visibleRect = this.getVisibleRect();
        }
        if (this.visibleRect == null) {
            return;
        }
        Color bg = this.getBackground();
        if (this.getGutter() != null) {
            bg = this.getGutter().getBackground();
        }
        g.setColor(bg);
        g.fillRect(0, this.visibleRect.y, this.getWidth(), this.visibleRect.height);
        final RSyntaxTextArea rsta = (RSyntaxTextArea)this.textArea;
        if (!rsta.isCodeFoldingEnabled()) {
            return;
        }
        if (this.textArea.getLineWrap()) {
            this.paintComponentWrapped(g);
            return;
        }
        this.textAreaInsets = this.textArea.getInsets(this.textAreaInsets);
        if (this.visibleRect.y < this.textAreaInsets.top) {
            final Rectangle visibleRect = this.visibleRect;
            visibleRect.height -= this.textAreaInsets.top - this.visibleRect.y;
            this.visibleRect.y = this.textAreaInsets.top;
        }
        final int cellHeight = this.textArea.getLineHeight();
        int topLine = (this.visibleRect.y - this.textAreaInsets.top) / cellHeight;
        int y = topLine * cellHeight + (cellHeight - this.collapsedFoldIcon.getIconHeight()) / 2;
        y += this.textAreaInsets.top;
        final FoldManager fm = rsta.getFoldManager();
        topLine += fm.getHiddenLineCountAbove(topLine, true);
        final int width = this.getWidth();
        final int x = width - 10;
        int line = topLine;
        boolean paintingOutlineLine = this.foldWithOutlineShowing != null && this.foldWithOutlineShowing.containsLine(line);
        while (y < this.visibleRect.y + this.visibleRect.height) {
            if (paintingOutlineLine) {
                g.setColor(this.getForeground());
                final int w2 = width - 6;
                if (line == this.foldWithOutlineShowing.getEndLine()) {
                    final int y2 = y + cellHeight / 2;
                    g.drawLine(w2, y, w2, y2);
                    g.drawLine(w2, y2, width - 2, y2);
                    paintingOutlineLine = false;
                }
                else {
                    g.drawLine(w2, y, w2, y + cellHeight);
                }
            }
            Fold fold = fm.getFoldForLine(line);
            if (fold != null) {
                if (fold == this.foldWithOutlineShowing) {
                    if (!fold.isCollapsed()) {
                        g.setColor(this.getForeground());
                        final int w3 = width - 6;
                        g.drawLine(w3, y + cellHeight / 2, w3, y + cellHeight);
                        paintingOutlineLine = true;
                    }
                    if (this.mouseOverFoldIcon) {
                        this.paintFoldArmed = true;
                    }
                }
                if (fold.isCollapsed()) {
                    this.collapsedFoldIcon.paintIcon((Component)this, g, x, y);
                    do {
                        final int hiddenLineCount = fold.getLineCount();
                        if (hiddenLineCount == 0) {
                            break;
                        }
                        line += hiddenLineCount;
                        fold = fm.getFoldForLine(line);
                        if (fold != null) {
                            continue;
                        }
                        break;
                    } while (fold.isCollapsed());
                }
                else {
                    this.expandedFoldIcon.paintIcon((Component)this, g, x, y);
                }
                this.paintFoldArmed = false;
            }
            ++line;
            y += cellHeight;
        }
    }
    
    private void paintComponentWrapped(final Graphics g) {
        final int width = this.getWidth();
        final RTextAreaUI ui = (RTextAreaUI)this.textArea.getUI();
        final View v = ui.getRootView(this.textArea).getView(0);
        final Document doc = this.textArea.getDocument();
        final Element root = doc.getDefaultRootElement();
        final int topPosition = this.textArea.viewToModel(new Point(this.visibleRect.x, this.visibleRect.y));
        final int topLine = root.getElementIndex(topPosition);
        final int cellHeight = this.textArea.getLineHeight();
        final FoldManager fm = ((RSyntaxTextArea)this.textArea).getFoldManager();
        final Rectangle visibleEditorRect = ui.getVisibleEditorRect();
        final Rectangle r = LineNumberList.getChildViewBounds(v, topLine, visibleEditorRect);
        int y = r.y;
        y += (cellHeight - this.collapsedFoldIcon.getIconHeight()) / 2;
        final int visibleBottom = this.visibleRect.y + this.visibleRect.height;
        final int x = width - 10;
        int line = topLine;
        boolean paintingOutlineLine = this.foldWithOutlineShowing != null && this.foldWithOutlineShowing.containsLine(line);
        final int lineCount = root.getElementCount();
        while (y < visibleBottom && line < lineCount) {
            final int curLineH = LineNumberList.getChildViewBounds(v, line, visibleEditorRect).height;
            if (paintingOutlineLine) {
                g.setColor(this.getForeground());
                final int w2 = width - 6;
                if (line == this.foldWithOutlineShowing.getEndLine()) {
                    final int y2 = y + curLineH - cellHeight / 2;
                    g.drawLine(w2, y, w2, y2);
                    g.drawLine(w2, y2, width - 2, y2);
                    paintingOutlineLine = false;
                }
                else {
                    g.drawLine(w2, y, w2, y + curLineH);
                }
            }
            final Fold fold = fm.getFoldForLine(line);
            if (fold != null) {
                if (fold == this.foldWithOutlineShowing) {
                    if (!fold.isCollapsed()) {
                        g.setColor(this.getForeground());
                        final int w3 = width - 6;
                        g.drawLine(w3, y + cellHeight / 2, w3, y + curLineH);
                        paintingOutlineLine = true;
                    }
                    if (this.mouseOverFoldIcon) {
                        this.paintFoldArmed = true;
                    }
                }
                if (fold.isCollapsed()) {
                    this.collapsedFoldIcon.paintIcon((Component)this, g, x, y);
                    y += LineNumberList.getChildViewBounds(v, line, visibleEditorRect).height;
                    line += fold.getLineCount() + 1;
                }
                else {
                    this.expandedFoldIcon.paintIcon((Component)this, g, x, y);
                    y += curLineH;
                    ++line;
                }
                this.paintFoldArmed = false;
            }
            else {
                y += curLineH;
                ++line;
            }
        }
    }
    
    private int rowAtPoint(final Point p) {
        int line = 0;
        try {
            final int offs = this.textArea.viewToModel(p);
            if (offs > -1) {
                line = this.textArea.getLineOfOffset(offs);
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
        }
        return line;
    }
    
    public void setAdditionalLeftMargin(final int leftMargin) {
        if (leftMargin < 0) {
            throw new IllegalArgumentException("leftMargin must be >= 0");
        }
        this.additionalLeftMargin = leftMargin;
        this.revalidate();
    }
    
    public void setFoldIconArmedBackground(final Color bg) {
        this.foldIconArmedBackground = bg;
    }
    
    public void setFoldIconBackground(final Color bg) {
        this.foldIconBackground = bg;
    }
    
    public void setFoldIcons(final Icon collapsedIcon, final Icon expandedIcon) {
        this.collapsedFoldIcon = collapsedIcon;
        this.expandedFoldIcon = expandedIcon;
        this.revalidate();
        this.repaint();
    }
    
    public void setShowCollapsedRegionToolTips(final boolean show) {
        if (show != this.showFoldRegionTips) {
            if (show) {
                ToolTipManager.sharedInstance().registerComponent((JComponent)this);
            }
            else {
                ToolTipManager.sharedInstance().unregisterComponent((JComponent)this);
            }
            this.showFoldRegionTips = show;
        }
    }
    
    public void setTextArea(final RTextArea textArea) {
        if (this.textArea != null) {
            this.textArea.removePropertyChangeListener("RSTA.codeFolding", this.listener);
        }
        super.setTextArea(textArea);
        if (this.textArea != null) {
            this.textArea.addPropertyChangeListener("RSTA.codeFolding", this.listener);
        }
    }
    
    static {
        DEFAULT_FOREGROUND = Color.GRAY;
        DEFAULT_FOLD_BACKGROUND = Color.WHITE;
    }
    
    private class FoldIcon implements Icon
    {
        private boolean collapsed;
        
        FoldIcon(final boolean collapsed) {
            this.collapsed = collapsed;
        }
        
        @Override
        public int getIconHeight() {
            return 8;
        }
        
        @Override
        public int getIconWidth() {
            return 8;
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            Color bg = FoldIndicator.this.foldIconBackground;
            if (FoldIndicator.this.paintFoldArmed && FoldIndicator.this.foldIconArmedBackground != null) {
                bg = FoldIndicator.this.foldIconArmedBackground;
            }
            g.setColor(bg);
            g.fillRect(x, y, 8, 8);
            g.setColor(FoldIndicator.this.getForeground());
            g.drawRect(x, y, 8, 8);
            g.drawLine(x + 2, y + 4, x + 2 + 4, y + 4);
            if (this.collapsed) {
                g.drawLine(x + 4, y + 2, x + 4, y + 6);
            }
        }
    }
    
    private class Listener extends MouseInputAdapter implements PropertyChangeListener
    {
        Listener(final FoldIndicator fgc) {
            fgc.addMouseListener((MouseListener)this);
            fgc.addMouseMotionListener((MouseMotionListener)this);
        }
        
        @Override
        public void mouseClicked(final MouseEvent e) {
            final Point p = e.getPoint();
            final int line = FoldIndicator.this.rowAtPoint(p);
            final RSyntaxTextArea rsta = (RSyntaxTextArea)FoldIndicator.this.textArea;
            final FoldManager fm = rsta.getFoldManager();
            final Fold fold = fm.getFoldForLine(line);
            if (fold != null) {
                fold.toggleCollapsedState();
                FoldIndicator.this.getGutter().repaint();
                FoldIndicator.this.textArea.repaint();
            }
        }
        
        @Override
        public void mouseExited(final MouseEvent e) {
            if (FoldIndicator.this.foldWithOutlineShowing != null) {
                FoldIndicator.this.foldWithOutlineShowing = null;
                FoldIndicator.this.mouseOverFoldIcon = false;
                FoldIndicator.this.repaint();
            }
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
            final boolean oldMouseOverFoldIcon = FoldIndicator.this.mouseOverFoldIcon;
            final Fold newSelectedFold = FoldIndicator.this.findOpenFoldClosestTo(e.getPoint());
            if (newSelectedFold != FoldIndicator.this.foldWithOutlineShowing && newSelectedFold != null && !newSelectedFold.isOnSingleLine()) {
                FoldIndicator.this.foldWithOutlineShowing = newSelectedFold;
                FoldIndicator.this.repaint();
            }
            else if (FoldIndicator.this.mouseOverFoldIcon != oldMouseOverFoldIcon) {
                FoldIndicator.this.repaint();
            }
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            FoldIndicator.this.repaint();
        }
    }
}
