//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import javax.swing.plaf.basic.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.*;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.event.*;

public class RTextAreaUI extends BasicTextAreaUI
{
    private static final String SHARED_ACTION_MAP_NAME = "RTextAreaUI.actionMap";
    private static final String SHARED_INPUT_MAP_NAME = "RTextAreaUI.inputMap";
    protected RTextArea textArea;
    private static final EditorKit DEFAULT_KIT;
    private static final TransferHandler DEFAULT_TRANSFER_HANDLER;
    private static final String RTEXTAREA_KEYMAP_NAME = "RTextAreaKeymap";
    
    public static ComponentUI createUI(final JComponent textArea) {
        return new RTextAreaUI(textArea);
    }
    
    public RTextAreaUI(final JComponent textArea) {
        if (!(textArea instanceof RTextArea)) {
            throw new IllegalArgumentException("RTextAreaUI is for instances of RTextArea only!");
        }
        this.textArea = (RTextArea)textArea;
    }
    
    private void correctNimbusDefaultProblems(final JTextComponent editor) {
        Color c = editor.getCaretColor();
        if (c == null) {
            editor.setCaretColor(RTextArea.getDefaultCaretColor());
        }
        c = editor.getSelectionColor();
        if (c == null) {
            c = UIManager.getColor("nimbusSelectionBackground");
            if (c == null) {
                c = UIManager.getColor("textHighlight");
                if (c == null) {
                    c = new ColorUIResource(Color.BLUE);
                }
            }
            editor.setSelectionColor(c);
        }
        c = editor.getSelectedTextColor();
        if (c == null) {
            c = UIManager.getColor("nimbusSelectedText");
            if (c == null) {
                c = UIManager.getColor("textHighlightText");
                if (c == null) {
                    c = new ColorUIResource(Color.WHITE);
                }
            }
            editor.setSelectedTextColor(c);
        }
        c = editor.getDisabledTextColor();
        if (c == null) {
            c = UIManager.getColor("nimbusDisabledText");
            if (c == null) {
                c = UIManager.getColor("textInactiveText");
                if (c == null) {
                    c = new ColorUIResource(Color.DARK_GRAY);
                }
            }
            editor.setDisabledTextColor(c);
        }
        final Border border = editor.getBorder();
        if (border == null) {
            editor.setBorder(new BasicBorders.MarginBorder());
        }
        final Insets margin = editor.getMargin();
        if (margin == null) {
            editor.setMargin(new InsetsUIResource(2, 2, 2, 2));
        }
    }
    
    @Override
    public View create(final Element elem) {
        if (this.textArea.getLineWrap()) {
            return new WrappedPlainView(elem, this.textArea.getWrapStyleWord());
        }
        return new PlainView(elem);
    }
    
    @Override
    protected Caret createCaret() {
        final Caret caret = (Caret)new ConfigurableCaret();
        caret.setBlinkRate(500);
        return caret;
    }
    
    @Override
    protected Highlighter createHighlighter() {
        return (Highlighter)new RTextAreaHighlighter();
    }
    
    @Override
    protected Keymap createKeymap() {
        Keymap map = JTextComponent.getKeymap("RTextAreaKeymap");
        if (map == null) {
            final Keymap parent = JTextComponent.getKeymap("default");
            map = JTextComponent.addKeymap("RTextAreaKeymap", parent);
            map.setDefaultAction((Action)new RTextAreaEditorKit.DefaultKeyTypedAction());
        }
        return map;
    }
    
    protected ActionMap createRTextAreaActionMap() {
        final ActionMap map = new ActionMapUIResource();
        final Action[] actions = this.textArea.getActions();
        final int n = actions.length;
        for (final Action a : actions) {
            map.put(a.getValue("Name"), a);
        }
        map.put(TransferHandler.getCutAction().getValue("Name"), TransferHandler.getCutAction());
        map.put(TransferHandler.getCopyAction().getValue("Name"), TransferHandler.getCopyAction());
        map.put(TransferHandler.getPasteAction().getValue("Name"), TransferHandler.getPasteAction());
        return map;
    }
    
    protected String getActionMapName() {
        return "RTextAreaUI.actionMap";
    }
    
    @Override
    public EditorKit getEditorKit(final JTextComponent tc) {
        return RTextAreaUI.DEFAULT_KIT;
    }
    
    public RTextArea getRTextArea() {
        return this.textArea;
    }
    
    private ActionMap getRTextAreaActionMap() {
        ActionMap map = (ActionMap)UIManager.get(this.getActionMapName());
        if (map == null) {
            map = this.createRTextAreaActionMap();
            UIManager.put(this.getActionMapName(), map);
        }
        final ActionMap componentMap = new ActionMapUIResource();
        componentMap.put("requestFocus", new FocusAction());
        if (map != null) {
            componentMap.setParent(map);
        }
        return componentMap;
    }
    
    protected InputMap getRTextAreaInputMap() {
        final InputMap map = new InputMapUIResource();
        InputMap shared = (InputMap)UIManager.get("RTextAreaUI.inputMap");
        if (shared == null) {
            shared = (InputMap)new RTADefaultInputMap();
            UIManager.put("RTextAreaUI.inputMap", shared);
        }
        map.setParent(shared);
        return map;
    }
    
    @Override
    protected Rectangle getVisibleEditorRect() {
        final Rectangle alloc = this.textArea.getBounds();
        if (alloc.width > 0 && alloc.height > 0) {
            final Rectangle rectangle = alloc;
            final Rectangle rectangle2 = alloc;
            final int n = 0;
            rectangle2.y = n;
            rectangle.x = n;
            final Insets insets = this.textArea.getInsets();
            final Rectangle rectangle3 = alloc;
            rectangle3.x += insets.left;
            final Rectangle rectangle4 = alloc;
            rectangle4.y += insets.top;
            final Rectangle rectangle5 = alloc;
            rectangle5.width -= insets.left + insets.right;
            final Rectangle rectangle6 = alloc;
            rectangle6.height -= insets.top + insets.bottom;
            return alloc;
        }
        return null;
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        final JTextComponent editor = this.getComponent();
        editor.setFont(RTextAreaBase.getDefaultFont());
        this.correctNimbusDefaultProblems(editor);
        editor.setTransferHandler(RTextAreaUI.DEFAULT_TRANSFER_HANDLER);
    }
    
    @Override
    protected void installKeyboardActions() {
        final RTextArea textArea = this.getRTextArea();
        textArea.setKeymap(this.createKeymap());
        final InputMap map = this.getRTextAreaInputMap();
        SwingUtilities.replaceUIInputMap((JComponent)textArea, 0, map);
        final ActionMap am = this.getRTextAreaActionMap();
        if (am != null) {
            SwingUtilities.replaceUIActionMap((JComponent)textArea, am);
        }
    }
    
    @Override
    public void installUI(final JComponent c) {
        if (!(c instanceof RTextArea)) {
            throw new Error("RTextAreaUI needs an instance of RTextArea!");
        }
        super.installUI(c);
    }
    
    @Override
    protected void paintBackground(final Graphics g) {
        final Color bg = this.textArea.getBackground();
        if (bg != null) {
            g.setColor(bg);
            final Rectangle r = g.getClipBounds();
            g.fillRect(r.x, r.y, r.width, r.height);
        }
        this.paintEditorAugmentations(g);
    }
    
    protected void paintCurrentLineHighlight(final Graphics g, final Rectangle visibleRect) {
        if (this.textArea.getHighlightCurrentLine()) {
            final Caret caret = this.textArea.getCaret();
            if (caret.getDot() == caret.getMark()) {
                final Color highlight = this.textArea.getCurrentLineHighlightColor();
                final int height = this.textArea.getLineHeight();
                if (this.textArea.getFadeCurrentLineHighlight()) {
                    final Graphics2D g2d = (Graphics2D)g;
                    final Color bg = this.textArea.getBackground();
                    final GradientPaint paint = new GradientPaint((float)visibleRect.x, 0.0f, highlight, (float)(visibleRect.x + visibleRect.width), 0.0f, (bg == null) ? Color.WHITE : bg);
                    g2d.setPaint(paint);
                    g2d.fillRect(visibleRect.x, this.textArea.currentCaretY, visibleRect.width, height);
                }
                else {
                    g.setColor(highlight);
                    g.fillRect(visibleRect.x, this.textArea.currentCaretY, visibleRect.width, height);
                }
            }
        }
    }
    
    protected void paintEditorAugmentations(final Graphics g) {
        final Rectangle visibleRect = this.textArea.getVisibleRect();
        this.paintLineHighlights(g);
        this.paintCurrentLineHighlight(g, visibleRect);
        this.paintMarginLine(g, visibleRect);
    }
    
    protected void paintLineHighlights(final Graphics g) {
        final LineHighlightManager lhm = this.textArea.getLineHighlightManager();
        if (lhm != null) {
            lhm.paintLineHighlights(g);
        }
    }
    
    protected void paintMarginLine(final Graphics g, final Rectangle visibleRect) {
        if (this.textArea.isMarginLineEnabled()) {
            g.setColor(this.textArea.getMarginLineColor());
            final Insets insets = this.textArea.getInsets();
            final int marginLineX = this.textArea.getMarginLinePixelLocation() + ((insets == null) ? 0 : insets.left);
            g.drawLine(marginLineX, visibleRect.y, marginLineX, visibleRect.y + visibleRect.height);
        }
    }
    
    @Override
    protected void paintSafely(final Graphics g) {
        if (!this.textArea.isOpaque()) {
            this.paintEditorAugmentations(g);
        }
        super.paintSafely(g);
    }
    
    public int yForLine(final int line) throws BadLocationException {
        final int startOffs = this.textArea.getLineStartOffset(line);
        return this.yForLineContaining(startOffs);
    }
    
    public int yForLineContaining(final int offs) throws BadLocationException {
        final Rectangle r = this.modelToView((JTextComponent)this.textArea, offs);
        return (r != null) ? r.y : -1;
    }
    
    static {
        DEFAULT_KIT = (EditorKit)new RTextAreaEditorKit();
        DEFAULT_TRANSFER_HANDLER = (TransferHandler)new RTATextTransferHandler();
    }
    
    class FocusAction extends AbstractAction
    {
        @Override
        public void actionPerformed(final ActionEvent e) {
            RTextAreaUI.this.textArea.requestFocus();
        }
        
        @Override
        public boolean isEnabled() {
            return RTextAreaUI.this.textArea.isEditable();
        }
    }
}
