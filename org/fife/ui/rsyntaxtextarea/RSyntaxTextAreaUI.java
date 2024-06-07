//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import org.fife.ui.rtextarea.*;
import javax.swing.plaf.*;
import javax.swing.*;
import java.awt.*;
import java.beans.*;
import javax.swing.text.*;

public class RSyntaxTextAreaUI extends RTextAreaUI
{
    private static final String SHARED_ACTION_MAP_NAME = "RSyntaxTextAreaUI.actionMap";
    private static final String SHARED_INPUT_MAP_NAME = "RSyntaxTextAreaUI.inputMap";
    private static final EditorKit DEFAULT_KIT;
    
    public static ComponentUI createUI(final JComponent ta) {
        return new RSyntaxTextAreaUI(ta);
    }
    
    public RSyntaxTextAreaUI(final JComponent rSyntaxTextArea) {
        super(rSyntaxTextArea);
    }
    
    @Override
    public View create(final Element elem) {
        final RTextArea c = this.getRTextArea();
        if (c instanceof RSyntaxTextArea) {
            final RSyntaxTextArea area = (RSyntaxTextArea)c;
            View v;
            if (area.getLineWrap()) {
                v = new WrappedSyntaxView(elem);
            }
            else {
                v = new SyntaxView(elem);
            }
            return v;
        }
        return null;
    }
    
    @Override
    protected Highlighter createHighlighter() {
        return (Highlighter)new RSyntaxTextAreaHighlighter();
    }
    
    @Override
    protected String getActionMapName() {
        return "RSyntaxTextAreaUI.actionMap";
    }
    
    @Override
    public EditorKit getEditorKit(final JTextComponent tc) {
        return RSyntaxTextAreaUI.DEFAULT_KIT;
    }
    
    @Override
    protected InputMap getRTextAreaInputMap() {
        final InputMap map = new InputMapUIResource();
        InputMap shared = (InputMap)UIManager.get("RSyntaxTextAreaUI.inputMap");
        if (shared == null) {
            shared = (InputMap)new RSyntaxTextAreaDefaultInputMap();
            UIManager.put("RSyntaxTextAreaUI.inputMap", shared);
        }
        map.setParent(shared);
        return map;
    }
    
    @Override
    protected void paintEditorAugmentations(final Graphics g) {
        super.paintEditorAugmentations(g);
        this.paintMatchedBracket(g);
    }
    
    protected void paintMatchedBracket(final Graphics g) {
        final RSyntaxTextArea rsta = (RSyntaxTextArea)this.textArea;
        if (rsta.isBracketMatchingEnabled()) {
            final Rectangle match = rsta.getMatchRectangle();
            if (match != null) {
                this.paintMatchedBracketImpl(g, rsta, match);
            }
            if (rsta.getPaintMatchedBracketPair()) {
                final Rectangle dotRect = rsta.getDotRectangle();
                if (dotRect != null) {
                    this.paintMatchedBracketImpl(g, rsta, dotRect);
                }
            }
        }
    }
    
    protected void paintMatchedBracketImpl(final Graphics g, final RSyntaxTextArea rsta, final Rectangle r) {
        if (rsta.getAnimateBracketMatching()) {
            final Color bg = rsta.getMatchedBracketBGColor();
            final int arcWH = 5;
            if (bg != null) {
                g.setColor(bg);
                g.fillRoundRect(r.x, r.y, r.width, r.height - 1, 5, 5);
            }
            g.setColor(rsta.getMatchedBracketBorderColor());
            g.drawRoundRect(r.x, r.y, r.width, r.height - 1, 5, 5);
        }
        else {
            final Color bg = rsta.getMatchedBracketBGColor();
            if (bg != null) {
                g.setColor(bg);
                g.fillRect(r.x, r.y, r.width, r.height - 1);
            }
            g.setColor(rsta.getMatchedBracketBorderColor());
            g.drawRect(r.x, r.y, r.width, r.height - 1);
        }
    }
    
    @Override
    protected void propertyChange(final PropertyChangeEvent e) {
        final String name = e.getPropertyName();
        if (name.equals("RSTA.syntaxScheme")) {
            this.modelChanged();
        }
        else {
            super.propertyChange(e);
        }
    }
    
    public void refreshSyntaxHighlighting() {
        this.modelChanged();
    }
    
    @Override
    public int yForLine(final int line) throws BadLocationException {
        final Rectangle alloc = this.getVisibleEditorRect();
        if (alloc != null) {
            final RSTAView view = (RSTAView)this.getRootView(this.textArea).getView(0);
            return view.yForLine(alloc, line);
        }
        return -1;
    }
    
    @Override
    public int yForLineContaining(final int offs) throws BadLocationException {
        final Rectangle alloc = this.getVisibleEditorRect();
        if (alloc != null) {
            final RSTAView view = (RSTAView)this.getRootView(this.textArea).getView(0);
            return view.yForLineContaining(alloc, offs);
        }
        return -1;
    }
    
    static {
        DEFAULT_KIT = (EditorKit)new RSyntaxTextAreaEditorKit();
    }
}
