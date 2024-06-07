//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import org.fife.ui.rsyntaxtextarea.focusabletip.*;
import org.fife.ui.rtextarea.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MatchedBracketPopup extends JWindow
{
    public static final String PROPERTY_CONSIDER_TEXTAREA_BACKGROUND = "rsta.matchedBracket.considerTextAreaBackground";
    private RSyntaxTextArea textArea;
    private transient Listener listener;
    private static final int LEFT_EMPTY_BORDER = 5;
    private static final boolean CONSIDER_TEXTAREA_BG;
    
    MatchedBracketPopup(final Window parent, final RSyntaxTextArea textArea, final int offsToRender) {
        super(parent);
        this.textArea = textArea;
        final JPanel cp = new JPanel(new BorderLayout());
        final RSyntaxTextArea toolTipParam = MatchedBracketPopup.CONSIDER_TEXTAREA_BG ? textArea : null;
        cp.setBorder(BorderFactory.createCompoundBorder(TipUtil.getToolTipBorder((RTextArea)toolTipParam), BorderFactory.createEmptyBorder(2, 5, 5, 5)));
        cp.setBackground(TipUtil.getToolTipBackground((RTextArea)toolTipParam));
        this.setContentPane(cp);
        cp.add(new JLabel(this.getText(offsToRender)));
        this.installKeyBindings();
        this.listener = new Listener();
        this.setLocation();
    }
    
    @Override
    public Dimension getPreferredSize() {
        final Dimension size = super.getPreferredSize();
        if (size != null) {
            size.width = Math.min(size.width, 800);
        }
        return size;
    }
    
    private String getText(final int offsToRender) {
        int line = 0;
        try {
            line = this.textArea.getLineOfOffset(offsToRender);
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
            return null;
        }
        final int lastLine = line + 1;
        if (line > 0) {
            try {
                final int startOffs = this.textArea.getLineStartOffset(line);
                final int length = this.textArea.getLineEndOffset(line) - startOffs;
                final String text = this.textArea.getText(startOffs, length);
                if (text.trim().length() == 1) {
                    --line;
                }
            }
            catch (BadLocationException ble2) {
                UIManager.getLookAndFeel().provideErrorFeedback(this.textArea);
                ble2.printStackTrace();
            }
        }
        final Font font = this.textArea.getFontForTokenType(20);
        final StringBuilder sb = new StringBuilder("<html>");
        sb.append("<style>body { font-size:\"").append(font.getSize());
        sb.append("pt\" }</style><nobr>");
        while (line < lastLine) {
            for (Token t = this.textArea.getTokenListForLine(line); t != null && t.isPaintable(); t = t.getNextToken()) {
                t.appendHTMLRepresentation(sb, this.textArea, true, true);
            }
            sb.append("<br>");
            ++line;
        }
        return sb.toString();
    }
    
    private void installKeyBindings() {
        final InputMap im = this.getRootPane().getInputMap(1);
        final ActionMap am = this.getRootPane().getActionMap();
        final KeyStroke escapeKS = KeyStroke.getKeyStroke(27, 0);
        im.put(escapeKS, "onEscape");
        am.put("onEscape", new EscapeAction());
    }
    
    private void setLocation() {
        final Point topLeft = this.textArea.getVisibleRect().getLocation();
        SwingUtilities.convertPointToScreen(topLeft, this.textArea);
        topLeft.y = Math.max(topLeft.y - 24, 0);
        this.setLocation(topLeft.x - 5, topLeft.y);
    }
    
    static {
        CONSIDER_TEXTAREA_BG = Boolean.getBoolean("rsta.matchedBracket.considerTextAreaBackground");
    }
    
    private class EscapeAction extends AbstractAction
    {
        @Override
        public void actionPerformed(final ActionEvent e) {
            MatchedBracketPopup.this.listener.uninstallAndHide();
        }
    }
    
    private class Listener extends WindowAdapter implements ComponentListener
    {
        Listener() {
            MatchedBracketPopup.this.addWindowFocusListener(this);
            final Window parent = (Window)MatchedBracketPopup.this.getParent();
            parent.addWindowFocusListener(this);
            parent.addWindowListener(this);
            parent.addComponentListener(this);
        }
        
        @Override
        public void componentResized(final ComponentEvent e) {
            this.uninstallAndHide();
        }
        
        @Override
        public void componentMoved(final ComponentEvent e) {
            this.uninstallAndHide();
        }
        
        @Override
        public void componentShown(final ComponentEvent e) {
            this.uninstallAndHide();
        }
        
        @Override
        public void componentHidden(final ComponentEvent e) {
            this.uninstallAndHide();
        }
        
        @Override
        public void windowActivated(final WindowEvent e) {
            this.checkForParentWindowEvent(e);
        }
        
        @Override
        public void windowLostFocus(final WindowEvent e) {
            this.uninstallAndHide();
        }
        
        @Override
        public void windowIconified(final WindowEvent e) {
            this.checkForParentWindowEvent(e);
        }
        
        private boolean checkForParentWindowEvent(final WindowEvent e) {
            if (e.getSource() == MatchedBracketPopup.this.getParent()) {
                this.uninstallAndHide();
                return true;
            }
            return false;
        }
        
        private void uninstallAndHide() {
            final Window parent = (Window)MatchedBracketPopup.this.getParent();
            parent.removeWindowFocusListener(this);
            parent.removeWindowListener(this);
            parent.removeComponentListener(this);
            MatchedBracketPopup.this.removeWindowFocusListener(this);
            MatchedBracketPopup.this.setVisible(false);
            MatchedBracketPopup.this.dispose();
        }
    }
}
