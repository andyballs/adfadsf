//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.focusabletip;

import org.fife.ui.rsyntaxtextarea.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

class TipWindow extends JWindow implements ActionListener
{
    private FocusableTip ft;
    private JEditorPane textArea;
    private String text;
    private transient TipListener tipListener;
    private transient HyperlinkListener userHyperlinkListener;
    private static TipWindow visibleInstance;
    
    TipWindow(final Window owner, final FocusableTip ft, String msg) {
        super(owner);
        this.ft = ft;
        if (msg != null && msg.length() >= 6 && !msg.substring(0, 6).equalsIgnoreCase("<html>")) {
            msg = "<html>" + HtmlUtil.escapeForHtml(msg, "<br>", false);
        }
        this.text = msg;
        this.tipListener = new TipListener();
        final JPanel cp = new JPanel(new BorderLayout());
        cp.setBorder(TipUtil.getToolTipBorder());
        cp.setBackground(TipUtil.getToolTipBackground());
        TipUtil.tweakTipEditorPane(this.textArea = new JEditorPane("text/html", this.text));
        if (ft.getImageBase() != null) {
            ((HTMLDocument)this.textArea.getDocument()).setBase(ft.getImageBase());
        }
        this.textArea.addMouseListener(this.tipListener);
        this.textArea.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                this.ft.possiblyDisposeOfTipWindow();
            }
            return;
        });
        cp.add(this.textArea);
        this.setFocusableWindowState(false);
        this.setContentPane(cp);
        this.setBottomPanel();
        this.pack();
        final KeyAdapter ka = new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == 27) {
                    TipWindow.this.ft.possiblyDisposeOfTipWindow();
                }
            }
        };
        this.addKeyListener(ka);
        this.textArea.addKeyListener(ka);
        synchronized (TipWindow.class) {
            if (TipWindow.visibleInstance != null) {
                TipWindow.visibleInstance.dispose();
            }
            TipWindow.visibleInstance = this;
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (!this.getFocusableWindowState()) {
            this.setFocusableWindowState(true);
            this.setBottomPanel();
            this.textArea.removeMouseListener(this.tipListener);
            this.pack();
            this.addWindowFocusListener(new WindowAdapter() {
                @Override
                public void windowLostFocus(final WindowEvent e) {
                    TipWindow.this.ft.possiblyDisposeOfTipWindow();
                }
            });
            this.ft.removeListeners();
            if (e == null) {
                this.requestFocus();
            }
        }
    }
    
    @Override
    public void dispose() {
        final Container cp = this.getContentPane();
        for (int i = 0; i < cp.getComponentCount(); ++i) {
            cp.getComponent(i).removeMouseListener(this.tipListener);
        }
        this.ft.removeListeners();
        super.dispose();
    }
    
    void fixSize() {
        Dimension d = this.textArea.getPreferredSize();
        Rectangle r = null;
        try {
            r = this.textArea.modelToView(this.textArea.getDocument().getLength() - 1);
            final Dimension preferredSize;
            d = (preferredSize = this.textArea.getPreferredSize());
            preferredSize.width += 25;
            final int maxWindowW = (this.ft.getMaxSize() != null) ? this.ft.getMaxSize().width : 600;
            final int maxWindowH = (this.ft.getMaxSize() != null) ? this.ft.getMaxSize().height : 400;
            d.width = Math.min(d.width, maxWindowW);
            d.height = Math.min(d.height, maxWindowH);
            this.textArea.setPreferredSize(d);
            this.textArea.setSize(d);
            r = this.textArea.modelToView(this.textArea.getDocument().getLength() - 1);
            if (r.y + r.height > d.height) {
                d.height = r.y + r.height + 5;
                if (this.ft.getMaxSize() != null) {
                    d.height = Math.min(d.height, maxWindowH);
                }
                this.textArea.setPreferredSize(d);
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
        }
        this.pack();
    }
    
    public String getText() {
        return this.text;
    }
    
    private void setBottomPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JSeparator(), "North");
        final boolean focusable = this.getFocusableWindowState();
        if (focusable) {
            final SizeGrip sg = new SizeGrip();
            sg.applyComponentOrientation(sg.getComponentOrientation());
            panel.add((Component)sg, "After");
            final MouseInputAdapter adapter = new MouseInputAdapter() {
                private Point lastPoint;
                
                @Override
                public void mouseDragged(final MouseEvent e) {
                    final Point p = e.getPoint();
                    SwingUtilities.convertPointToScreen(p, panel);
                    if (this.lastPoint == null) {
                        this.lastPoint = p;
                    }
                    else {
                        final int dx = p.x - this.lastPoint.x;
                        final int dy = p.y - this.lastPoint.y;
                        TipWindow.this.setLocation(TipWindow.this.getX() + dx, TipWindow.this.getY() + dy);
                        this.lastPoint = p;
                    }
                }
                
                @Override
                public void mousePressed(final MouseEvent e) {
                    SwingUtilities.convertPointToScreen(this.lastPoint = e.getPoint(), panel);
                }
            };
            panel.addMouseListener(adapter);
            panel.addMouseMotionListener(adapter);
        }
        else {
            panel.setOpaque(false);
            final JLabel label = new JLabel(FocusableTip.getString("FocusHotkey"));
            Color fg = UIManager.getColor("Label.disabledForeground");
            Font font = this.textArea.getFont();
            font = font.deriveFont(font.getSize2D() - 1.0f);
            label.setFont(font);
            if (fg == null) {
                fg = Color.GRAY;
            }
            label.setOpaque(true);
            final Color bg = TipUtil.getToolTipBackground();
            label.setBackground(bg);
            label.setForeground(fg);
            label.setHorizontalAlignment(11);
            label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
            panel.add(label);
            panel.addMouseListener(this.tipListener);
        }
        final Container cp = this.getContentPane();
        if (cp.getComponentCount() == 2) {
            final Component comp = cp.getComponent(0);
            cp.remove(0);
            final JScrollPane sp = new JScrollPane(comp);
            final Border emptyBorder = BorderFactory.createEmptyBorder();
            sp.setBorder(emptyBorder);
            sp.setViewportBorder(emptyBorder);
            sp.setBackground(this.textArea.getBackground());
            sp.getViewport().setBackground(this.textArea.getBackground());
            cp.add(sp);
            cp.getComponent(0).removeMouseListener(this.tipListener);
            cp.remove(0);
        }
        cp.add(panel, "South");
    }
    
    public void setHyperlinkListener(final HyperlinkListener listener) {
        if (this.userHyperlinkListener != null) {
            this.textArea.removeHyperlinkListener(this.userHyperlinkListener);
        }
        this.userHyperlinkListener = listener;
        if (this.userHyperlinkListener != null) {
            this.textArea.addHyperlinkListener(this.userHyperlinkListener);
        }
    }
    
    private final class TipListener extends MouseAdapter
    {
        @Override
        public void mousePressed(final MouseEvent e) {
            TipWindow.this.actionPerformed(null);
        }
        
        @Override
        public void mouseExited(final MouseEvent e) {
            final Component source = (Component)e.getSource();
            final Point p = e.getPoint();
            SwingUtilities.convertPointToScreen(p, source);
            if (!TipWindow.this.getBounds().contains(p)) {
                TipWindow.this.ft.possiblyDisposeOfTipWindow();
            }
        }
    }
}
