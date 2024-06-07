//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import org.fife.ui.rsyntaxtextarea.focusabletip.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class ClipboardHistoryPopup extends JWindow
{
    private RTextArea textArea;
    private ChoiceList list;
    private transient Listener listener;
    private boolean prevCaretAlwaysVisible;
    private static final int VERTICAL_SPACE = 1;
    private static final String MSG = "org.fife.ui.rtextarea.RTextArea";
    
    ClipboardHistoryPopup(final Window parent, final RTextArea textArea) {
        super(parent);
        this.textArea = textArea;
        final JPanel cp = new JPanel(new BorderLayout());
        cp.setBorder(BorderFactory.createCompoundBorder(TipUtil.getToolTipBorder(), BorderFactory.createEmptyBorder(2, 5, 5, 5)));
        cp.setBackground(TipUtil.getToolTipBackground());
        this.setContentPane(cp);
        final ResourceBundle msg = ResourceBundle.getBundle("org.fife.ui.rtextarea.RTextArea");
        final JLabel title = new JLabel(msg.getString("Action.ClipboardHistory.Popup.Label"));
        cp.add(title, "North");
        this.list = new ChoiceList();
        final JScrollPane sp = new JScrollPane(this.list);
        sp.setHorizontalScrollBarPolicy(31);
        cp.add(sp);
        this.installKeyBindings();
        this.listener = new Listener();
        this.setLocation();
    }
    
    @Override
    public Dimension getPreferredSize() {
        final Dimension size = super.getPreferredSize();
        if (size != null) {
            size.width = Math.min(size.width, 300);
            size.width = Math.max(size.width, 200);
        }
        return size;
    }
    
    private void insertSelectedItem() {
        final LabelValuePair lvp = this.list.getSelectedValue();
        if (lvp != null) {
            this.listener.uninstallAndHide();
            final String text = lvp.value;
            this.textArea.replaceSelection(text);
            ClipboardHistory.get().add(text);
        }
    }
    
    private void installKeyBindings() {
        final InputMap im = this.getRootPane().getInputMap(1);
        final ActionMap am = this.getRootPane().getActionMap();
        final KeyStroke escapeKS = KeyStroke.getKeyStroke(27, 0);
        im.put(escapeKS, "onEscape");
        am.put("onEscape", new EscapeAction());
        this.list.getInputMap().remove(escapeKS);
    }
    
    public void setContents(final List<String> contents) {
        this.list.setContents(contents);
        this.pack();
    }
    
    private void setLocation() {
        Rectangle r;
        try {
            r = this.textArea.modelToView(this.textArea.getCaretPosition());
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        final Point p = r.getLocation();
        SwingUtilities.convertPointToScreen(p, this.textArea);
        r.x = p.x;
        r.y = p.y;
        final Rectangle screenBounds = TipUtil.getScreenBoundsForPoint(r.x, r.y);
        final int totalH = this.getHeight();
        int y = r.y + r.height + 1;
        if (y + totalH > screenBounds.height) {
            y = r.y - 1 - this.getHeight();
        }
        int x = r.x;
        if (!this.textArea.getComponentOrientation().isLeftToRight()) {
            x -= this.getWidth();
        }
        if (x < screenBounds.x) {
            x = screenBounds.x;
        }
        else if (x + this.getWidth() > screenBounds.x + screenBounds.width) {
            x = screenBounds.x + screenBounds.width - this.getWidth();
        }
        this.setLocation(x, y);
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (this.list.getModel().getSize() == 0) {
            UIManager.getLookAndFeel().provideErrorFeedback(this.textArea);
            return;
        }
        super.setVisible(visible);
        this.updateTextAreaCaret(visible);
        if (visible) {
            SwingUtilities.invokeLater(() -> {
                this.requestFocus();
                if (this.list.getModel().getSize() > 0) {
                    this.list.setSelectedIndex(0);
                }
                this.list.requestFocusInWindow();
            });
        }
    }
    
    private void updateTextAreaCaret(final boolean visible) {
        final Caret caret = this.textArea.getCaret();
        if (caret instanceof ConfigurableCaret) {
            final ConfigurableCaret cc = (ConfigurableCaret)caret;
            if (visible) {
                this.prevCaretAlwaysVisible = cc.isAlwaysVisible();
                cc.setAlwaysVisible(true);
            }
            else {
                cc.setAlwaysVisible(this.prevCaretAlwaysVisible);
            }
        }
    }
    
    private class EscapeAction extends AbstractAction
    {
        @Override
        public void actionPerformed(final ActionEvent e) {
            ClipboardHistoryPopup.this.listener.uninstallAndHide();
        }
    }
    
    private class Listener extends WindowAdapter implements ComponentListener
    {
        Listener() {
            ClipboardHistoryPopup.this.addWindowFocusListener(this);
            ClipboardHistoryPopup.this.list.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        ClipboardHistoryPopup.this.insertSelectedItem();
                    }
                }
            });
            ClipboardHistoryPopup.this.list.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "onEnter");
            ClipboardHistoryPopup.this.list.getActionMap().put("onEnter", new AbstractAction() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    ClipboardHistoryPopup.this.insertSelectedItem();
                }
            });
            final Window parent = (Window)ClipboardHistoryPopup.this.getParent();
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
            if (e.getSource() == ClipboardHistoryPopup.this) {
                this.uninstallAndHide();
            }
        }
        
        @Override
        public void windowIconified(final WindowEvent e) {
            this.checkForParentWindowEvent(e);
        }
        
        private boolean checkForParentWindowEvent(final WindowEvent e) {
            if (e.getSource() == ClipboardHistoryPopup.this.getParent()) {
                this.uninstallAndHide();
                return true;
            }
            return false;
        }
        
        private void uninstallAndHide() {
            final Window parent = (Window)ClipboardHistoryPopup.this.getParent();
            parent.removeWindowFocusListener(this);
            parent.removeWindowListener(this);
            parent.removeComponentListener(this);
            ClipboardHistoryPopup.this.removeWindowFocusListener(this);
            ClipboardHistoryPopup.this.setVisible(false);
            ClipboardHistoryPopup.this.dispose();
        }
    }
    
    private static final class ChoiceList extends JList<LabelValuePair>
    {
        private ChoiceList() {
            super(new DefaultListModel());
            this.setSelectionMode(0);
            this.installKeyboardActions();
        }
        
        private void installKeyboardActions() {
            final InputMap im = this.getInputMap();
            final ActionMap am = this.getActionMap();
            im.put(KeyStroke.getKeyStroke(40, 0), "onDown");
            am.put("onDown", new AbstractAction() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    final int index = (ChoiceList.this.getSelectedIndex() + 1) % ChoiceList.this.getModel().getSize();
                    ChoiceList.this.ensureIndexIsVisible(index);
                    ChoiceList.this.setSelectedIndex(index);
                }
            });
            im.put(KeyStroke.getKeyStroke(38, 0), "onUp");
            am.put("onUp", new AbstractAction() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    int index = ChoiceList.this.getSelectedIndex() - 1;
                    if (index < 0) {
                        index += ChoiceList.this.getModel().getSize();
                    }
                    ChoiceList.this.ensureIndexIsVisible(index);
                    ChoiceList.this.setSelectedIndex(index);
                }
            });
        }
        
        private void setContents(final List<String> contents) {
            final DefaultListModel<LabelValuePair> model = (DefaultListModel<LabelValuePair>)(DefaultListModel)this.getModel();
            model.clear();
            for (final String str : contents) {
                model.addElement(new LabelValuePair(str));
            }
            this.setVisibleRowCount(Math.min(model.getSize(), 8));
        }
    }
    
    private static class LabelValuePair
    {
        private String label;
        private String value;
        private static final int LABEL_MAX_LENGTH = 50;
        
        LabelValuePair(final String value) {
            this.value = value;
            this.label = value;
            final int newline = this.label.indexOf(10);
            boolean multiLine = false;
            if (newline > -1) {
                this.label = this.label.substring(0, newline);
                multiLine = true;
            }
            if (this.label.length() > 50) {
                this.label = this.label.substring(0, 50) + "...";
            }
            else if (multiLine) {
                final int toRemove = 3 - (50 - this.label.length());
                if (toRemove > 0) {
                    this.label = this.label.substring(0, this.label.length() - toRemove);
                }
                this.label += "...";
            }
        }
        
        @Override
        public String toString() {
            return this.label;
        }
    }
}
