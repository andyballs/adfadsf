//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.beans.*;

public class Gutter extends JPanel
{
    public static final Color DEFAULT_ACTIVE_LINE_RANGE_COLOR;
    private RTextArea textArea;
    private LineNumberList lineNumberList;
    private Color lineNumberColor;
    private int lineNumberingStartIndex;
    private Font lineNumberFont;
    private IconRowHeader iconArea;
    private boolean iconRowHeaderInheritsGutterBackground;
    private int spacingBetweenLineNumbersAndFoldIndicator;
    private FoldIndicator foldIndicator;
    private transient TextAreaListener listener;
    
    public Gutter(final RTextArea textArea) {
        this.listener = new TextAreaListener();
        this.lineNumberColor = Color.gray;
        this.lineNumberFont = RTextAreaBase.getDefaultFont();
        this.lineNumberingStartIndex = 1;
        this.iconRowHeaderInheritsGutterBackground = false;
        this.setTextArea(textArea);
        this.setLayout(new BorderLayout());
        if (this.textArea != null) {
            this.setLineNumbersEnabled(true);
            if (this.textArea instanceof RSyntaxTextArea) {
                final RSyntaxTextArea rsta = (RSyntaxTextArea)this.textArea;
                this.setFoldIndicatorEnabled(rsta.isCodeFoldingEnabled());
            }
        }
        this.setBorder(new GutterBorder(0, 0, 0, 1));
        Color bg = null;
        if (textArea != null) {
            bg = textArea.getBackground();
        }
        this.setBackground((bg != null) ? bg : Color.WHITE);
    }
    
    public GutterIconInfo addLineTrackingIcon(final int line, final Icon icon) throws BadLocationException {
        return this.addLineTrackingIcon(line, icon, null);
    }
    
    public GutterIconInfo addLineTrackingIcon(final int line, final Icon icon, final String tip) throws BadLocationException {
        final int offs = this.textArea.getLineStartOffset(line);
        return this.addOffsetTrackingIcon(offs, icon, tip);
    }
    
    public GutterIconInfo addOffsetTrackingIcon(final int offs, final Icon icon) throws BadLocationException {
        return this.addOffsetTrackingIcon(offs, icon, null);
    }
    
    public GutterIconInfo addOffsetTrackingIcon(final int offs, final Icon icon, final String tip) throws BadLocationException {
        return this.iconArea.addOffsetTrackingIcon(offs, icon, tip);
    }
    
    private void clearActiveLineRange() {
        this.iconArea.clearActiveLineRange();
    }
    
    public Color getActiveLineRangeColor() {
        return this.iconArea.getActiveLineRangeColor();
    }
    
    public Color getArmedFoldBackground() {
        return this.foldIndicator.getFoldIconArmedBackground();
    }
    
    public Icon getBookmarkIcon() {
        return this.iconArea.getBookmarkIcon();
    }
    
    public GutterIconInfo[] getBookmarks() {
        return this.iconArea.getBookmarks();
    }
    
    public Color getBorderColor() {
        return ((GutterBorder)this.getBorder()).getColor();
    }
    
    public Color getFoldBackground() {
        return this.foldIndicator.getFoldIconBackground();
    }
    
    public Color getFoldIndicatorForeground() {
        return this.foldIndicator.getForeground();
    }
    
    public boolean getIconRowHeaderInheritsGutterBackground() {
        return this.iconRowHeaderInheritsGutterBackground;
    }
    
    public Color getLineNumberColor() {
        return this.lineNumberColor;
    }
    
    public Font getLineNumberFont() {
        return this.lineNumberFont;
    }
    
    public int getLineNumberingStartIndex() {
        return this.lineNumberingStartIndex;
    }
    
    public boolean getLineNumbersEnabled() {
        for (int i = 0; i < this.getComponentCount(); ++i) {
            if (this.getComponent(i) == this.lineNumberList) {
                return true;
            }
        }
        return false;
    }
    
    public boolean getShowCollapsedRegionToolTips() {
        return this.foldIndicator.getShowCollapsedRegionToolTips();
    }
    
    public int getSpacingBetweenLineNumbersAndFoldIndicator() {
        return this.spacingBetweenLineNumbersAndFoldIndicator;
    }
    
    public GutterIconInfo[] getTrackingIcons(final Point p) throws BadLocationException {
        final int offs = this.textArea.viewToModel(new Point(0, p.y));
        final int line = this.textArea.getLineOfOffset(offs);
        return this.iconArea.getTrackingIcons(line);
    }
    
    public boolean isFoldIndicatorEnabled() {
        for (int i = 0; i < this.getComponentCount(); ++i) {
            if (this.getComponent(i) == this.foldIndicator) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isBookmarkingEnabled() {
        return this.iconArea.isBookmarkingEnabled();
    }
    
    public boolean isIconRowHeaderEnabled() {
        for (int i = 0; i < this.getComponentCount(); ++i) {
            if (this.getComponent(i) == this.iconArea) {
                return true;
            }
        }
        return false;
    }
    
    public void removeAllTrackingIcons() {
        this.iconArea.removeAllTrackingIcons();
    }
    
    public void removeTrackingIcon(final GutterIconInfo tag) {
        this.iconArea.removeTrackingIcon(tag);
    }
    
    public void setActiveLineRangeColor(final Color color) {
        this.iconArea.setActiveLineRangeColor(color);
    }
    
    private void setActiveLineRange(final int startLine, final int endLine) {
        this.iconArea.setActiveLineRange(startLine, endLine);
    }
    
    public void setArmedFoldBackground(final Color bg) {
        this.foldIndicator.setFoldIconArmedBackground(bg);
    }
    
    public void setBookmarkIcon(final Icon icon) {
        this.iconArea.setBookmarkIcon(icon);
    }
    
    public void setBookmarkingEnabled(final boolean enabled) {
        this.iconArea.setBookmarkingEnabled(enabled);
        if (enabled && !this.isIconRowHeaderEnabled()) {
            this.setIconRowHeaderEnabled(true);
        }
    }
    
    public void setBorderColor(final Color color) {
        ((GutterBorder)this.getBorder()).setColor(color);
        this.repaint();
    }
    
    @Override
    public void setComponentOrientation(final ComponentOrientation o) {
        if (this.getBorder() instanceof GutterBorder) {
            if (o.isLeftToRight()) {
                ((GutterBorder)this.getBorder()).setEdges(0, 0, 0, 1);
            }
            else {
                ((GutterBorder)this.getBorder()).setEdges(0, 1, 0, 0);
            }
        }
        super.setComponentOrientation(o);
    }
    
    public void setFoldIcons(final Icon collapsedIcon, final Icon expandedIcon) {
        if (this.foldIndicator != null) {
            this.foldIndicator.setFoldIcons(collapsedIcon, expandedIcon);
        }
    }
    
    public void setFoldIndicatorEnabled(final boolean enabled) {
        if (this.foldIndicator != null) {
            if (enabled) {
                this.add((Component)this.foldIndicator, "After");
            }
            else {
                this.remove((Component)this.foldIndicator);
            }
            this.revalidate();
        }
    }
    
    public void setFoldBackground(Color bg) {
        if (bg == null) {
            bg = FoldIndicator.DEFAULT_FOLD_BACKGROUND;
        }
        this.foldIndicator.setFoldIconBackground(bg);
    }
    
    public void setFoldIndicatorForeground(Color fg) {
        if (fg == null) {
            fg = FoldIndicator.DEFAULT_FOREGROUND;
        }
        this.foldIndicator.setForeground(fg);
    }
    
    void setIconRowHeaderEnabled(final boolean enabled) {
        if (this.iconArea != null) {
            if (enabled) {
                this.add((Component)this.iconArea, "Before");
            }
            else {
                this.remove((Component)this.iconArea);
            }
            this.revalidate();
        }
    }
    
    public void setIconRowHeaderInheritsGutterBackground(final boolean inherits) {
        if (inherits != this.iconRowHeaderInheritsGutterBackground) {
            this.iconRowHeaderInheritsGutterBackground = inherits;
            if (this.iconArea != null) {
                this.iconArea.setInheritsGutterBackground(inherits);
            }
        }
    }
    
    public void setLineNumberColor(final Color color) {
        if (color != null && !color.equals(this.lineNumberColor)) {
            this.lineNumberColor = color;
            if (this.lineNumberList != null) {
                this.lineNumberList.setForeground(color);
            }
        }
    }
    
    public void setLineNumberFont(final Font font) {
        if (font == null) {
            throw new IllegalArgumentException("font cannot be null");
        }
        if (!font.equals(this.lineNumberFont)) {
            this.lineNumberFont = font;
            if (this.lineNumberList != null) {
                this.lineNumberList.setFont(font);
            }
        }
    }
    
    public void setLineNumberingStartIndex(final int index) {
        if (index != this.lineNumberingStartIndex) {
            this.lineNumberingStartIndex = index;
            this.lineNumberList.setLineNumberingStartIndex(index);
        }
    }
    
    void setLineNumbersEnabled(final boolean enabled) {
        if (this.lineNumberList != null) {
            if (enabled) {
                this.add((Component)this.lineNumberList);
            }
            else {
                this.remove((Component)this.lineNumberList);
            }
            this.revalidate();
        }
    }
    
    public void setShowCollapsedRegionToolTips(final boolean show) {
        if (this.foldIndicator != null) {
            this.foldIndicator.setShowCollapsedRegionToolTips(show);
        }
    }
    
    public void setSpacingBetweenLineNumbersAndFoldIndicator(final int spacing) {
        if (spacing != this.spacingBetweenLineNumbersAndFoldIndicator) {
            this.spacingBetweenLineNumbersAndFoldIndicator = spacing;
            this.foldIndicator.setAdditionalLeftMargin(spacing);
            this.revalidate();
            this.repaint();
        }
    }
    
    void setTextArea(final RTextArea textArea) {
        if (this.textArea != null) {
            this.listener.uninstall();
        }
        if (textArea != null) {
            final RTextAreaEditorKit kit = (RTextAreaEditorKit)textArea.getUI().getEditorKit(textArea);
            if (this.lineNumberList == null) {
                (this.lineNumberList = kit.createLineNumberList(textArea)).setFont(this.getLineNumberFont());
                this.lineNumberList.setForeground(this.getLineNumberColor());
                this.lineNumberList.setLineNumberingStartIndex(this.getLineNumberingStartIndex());
            }
            else {
                this.lineNumberList.setTextArea(textArea);
            }
            if (this.iconArea == null) {
                (this.iconArea = kit.createIconRowHeader(textArea)).setInheritsGutterBackground(this.getIconRowHeaderInheritsGutterBackground());
            }
            else {
                this.iconArea.setTextArea(textArea);
            }
            if (this.foldIndicator == null) {
                this.foldIndicator = new FoldIndicator(textArea);
            }
            else {
                this.foldIndicator.setTextArea(textArea);
            }
            this.listener.install(textArea);
        }
        this.textArea = textArea;
    }
    
    public boolean toggleBookmark(final int line) throws BadLocationException {
        return this.iconArea.toggleBookmark(line);
    }
    
    @Override
    public void setBorder(final Border border) {
        if (border instanceof GutterBorder) {
            super.setBorder(border);
        }
    }
    
    static {
        DEFAULT_ACTIVE_LINE_RANGE_COLOR = new Color(51, 153, 255);
    }
    
    public static class GutterBorder extends EmptyBorder
    {
        private Color color;
        private Rectangle visibleRect;
        
        public GutterBorder(final int top, final int left, final int bottom, final int right) {
            super(top, left, bottom, right);
            this.color = new Color(221, 221, 221);
            this.visibleRect = new Rectangle();
        }
        
        public Color getColor() {
            return this.color;
        }
        
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            this.visibleRect = g.getClipBounds(this.visibleRect);
            if (this.visibleRect == null) {
                this.visibleRect = ((JComponent)c).getVisibleRect();
            }
            g.setColor(this.color);
            if (this.left == 1) {
                g.drawLine(0, this.visibleRect.y, 0, this.visibleRect.y + this.visibleRect.height);
            }
            else {
                g.drawLine(width - 1, this.visibleRect.y, width - 1, this.visibleRect.y + this.visibleRect.height);
            }
        }
        
        public void setColor(final Color color) {
            this.color = color;
        }
        
        public void setEdges(final int top, final int left, final int bottom, final int right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }
    }
    
    private class TextAreaListener extends ComponentAdapter implements DocumentListener, PropertyChangeListener, ActiveLineRangeListener
    {
        private boolean installed;
        
        public void activeLineRangeChanged(final ActiveLineRangeEvent e) {
            if (e.getMin() == -1) {
                Gutter.this.clearActiveLineRange();
            }
            else {
                Gutter.this.setActiveLineRange(e.getMin(), e.getMax());
            }
        }
        
        @Override
        public void changedUpdate(final DocumentEvent e) {
        }
        
        @Override
        public void componentResized(final ComponentEvent e) {
            Gutter.this.revalidate();
        }
        
        protected void handleDocumentEvent(final DocumentEvent e) {
            for (int i = 0; i < Gutter.this.getComponentCount(); ++i) {
                final AbstractGutterComponent agc = (AbstractGutterComponent)Gutter.this.getComponent(i);
                agc.handleDocumentEvent(e);
            }
        }
        
        @Override
        public void insertUpdate(final DocumentEvent e) {
            this.handleDocumentEvent(e);
        }
        
        public void install(final RTextArea textArea) {
            if (this.installed) {
                this.uninstall();
            }
            textArea.addComponentListener(this);
            textArea.getDocument().addDocumentListener(this);
            textArea.addPropertyChangeListener(this);
            if (textArea instanceof RSyntaxTextArea) {
                final RSyntaxTextArea rsta = (RSyntaxTextArea)textArea;
                rsta.addActiveLineRangeListener((ActiveLineRangeListener)this);
                rsta.getFoldManager().addPropertyChangeListener((PropertyChangeListener)this);
            }
            this.installed = true;
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            final String name = e.getPropertyName();
            if ("font".equals(name) || "RSTA.syntaxScheme".equals(name)) {
                for (int i = 0; i < Gutter.this.getComponentCount(); ++i) {
                    final AbstractGutterComponent agc = (AbstractGutterComponent)Gutter.this.getComponent(i);
                    agc.lineHeightsChanged();
                }
            }
            else if ("RSTA.codeFolding".equals(name)) {
                final boolean foldingEnabled = (boolean)e.getNewValue();
                if (Gutter.this.lineNumberList != null) {
                    Gutter.this.lineNumberList.updateCellWidths();
                }
                Gutter.this.setFoldIndicatorEnabled(foldingEnabled);
            }
            else if ("FoldsUpdated".equals(name)) {
                Gutter.this.repaint();
            }
            else if ("document".equals(name)) {
                final RDocument old = (RDocument)e.getOldValue();
                if (old != null) {
                    old.removeDocumentListener(this);
                }
                final RDocument newDoc = (RDocument)e.getNewValue();
                if (newDoc != null) {
                    newDoc.addDocumentListener(this);
                }
            }
        }
        
        @Override
        public void removeUpdate(final DocumentEvent e) {
            this.handleDocumentEvent(e);
        }
        
        public void uninstall() {
            if (this.installed) {
                Gutter.this.textArea.removeComponentListener(this);
                Gutter.this.textArea.getDocument().removeDocumentListener(this);
                Gutter.this.textArea.removePropertyChangeListener(this);
                if (Gutter.this.textArea instanceof RSyntaxTextArea) {
                    final RSyntaxTextArea rsta = (RSyntaxTextArea)Gutter.this.textArea;
                    rsta.removeActiveLineRangeListener((ActiveLineRangeListener)this);
                    rsta.getFoldManager().removePropertyChangeListener((PropertyChangeListener)this);
                }
                this.installed = false;
            }
        }
    }
}
