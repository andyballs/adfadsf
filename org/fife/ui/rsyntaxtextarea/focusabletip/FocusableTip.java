//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.focusabletip;

import java.net.*;
import java.util.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class FocusableTip
{
    private JTextArea textArea;
    private TipWindow tipWindow;
    private URL imageBase;
    private TextAreaListener textAreaListener;
    private HyperlinkListener hyperlinkListener;
    private String lastText;
    private Dimension maxSize;
    private Rectangle tipVisibleBounds;
    private static final int X_MARGIN = 18;
    private static final int Y_MARGIN = 12;
    private static final ResourceBundle MSG;
    
    public FocusableTip(final JTextArea textArea, final HyperlinkListener listener) {
        this.setTextArea(textArea);
        this.hyperlinkListener = listener;
        this.textAreaListener = new TextAreaListener();
        this.tipVisibleBounds = new Rectangle();
    }
    
    private void computeTipVisibleBounds() {
        final Rectangle r = this.tipWindow.getBounds();
        final Point p = r.getLocation();
        SwingUtilities.convertPointFromScreen(p, this.textArea);
        r.setLocation(p);
        this.tipVisibleBounds.setBounds(r.x, r.y - 15, r.width, r.height + 30);
    }
    
    private void createAndShowTipWindow(final MouseEvent e, final String text) {
        final Window owner = SwingUtilities.getWindowAncestor(this.textArea);
        (this.tipWindow = new TipWindow(owner, this, text)).setHyperlinkListener(this.hyperlinkListener);
        final PopupWindowDecorator decorator = PopupWindowDecorator.get();
        if (decorator != null) {
            decorator.decorate(this.tipWindow);
        }
        ComponentOrientation o;
        Point p;
        Rectangle sb;
        int y;
        int x;
        SwingUtilities.invokeLater(() -> {
            if (this.tipWindow != null) {
                this.tipWindow.fixSize();
                o = this.textArea.getComponentOrientation();
                p = e.getPoint();
                SwingUtilities.convertPointToScreen(p, this.textArea);
                sb = TipUtil.getScreenBoundsForPoint(p.x, p.y);
                y = p.y + 12;
                if (y + this.tipWindow.getHeight() >= sb.y + sb.height) {
                    y = p.y - 12 - this.tipWindow.getHeight();
                    if (y < sb.y) {
                        y = sb.y + 12;
                    }
                }
                x = p.x - 18;
                if (!o.isLeftToRight()) {
                    x = p.x - this.tipWindow.getWidth() + 18;
                }
                if (x < sb.x) {
                    x = sb.x;
                }
                else if (x + this.tipWindow.getWidth() > sb.x + sb.width) {
                    x = sb.x + sb.width - this.tipWindow.getWidth();
                }
                this.tipWindow.setLocation(x, y);
                this.tipWindow.setVisible(true);
                this.computeTipVisibleBounds();
                this.textAreaListener.install(this.textArea);
                this.lastText = text;
            }
        });
    }
    
    public URL getImageBase() {
        return this.imageBase;
    }
    
    public Dimension getMaxSize() {
        return this.maxSize;
    }
    
    static String getString(final String key) {
        return FocusableTip.MSG.getString(key);
    }
    
    public void possiblyDisposeOfTipWindow() {
        if (this.tipWindow != null) {
            this.tipWindow.dispose();
            this.tipWindow = null;
            this.textAreaListener.uninstall();
            this.tipVisibleBounds.setBounds(-1, -1, 0, 0);
            this.lastText = null;
            this.textArea.requestFocus();
        }
    }
    
    void removeListeners() {
        this.textAreaListener.uninstall();
    }
    
    public void setImageBase(final URL url) {
        this.imageBase = url;
    }
    
    public void setMaxSize(final Dimension maxSize) {
        this.maxSize = maxSize;
    }
    
    private void setTextArea(final JTextArea textArea) {
        this.textArea = textArea;
        ToolTipManager.sharedInstance().registerComponent(textArea);
    }
    
    public void toolTipRequested(final MouseEvent e, final String text) {
        if (text == null || text.length() == 0) {
            this.possiblyDisposeOfTipWindow();
            this.lastText = text;
            return;
        }
        if (this.lastText == null || text.length() != this.lastText.length() || !text.equals(this.lastText)) {
            this.possiblyDisposeOfTipWindow();
            this.createAndShowTipWindow(e, text);
        }
    }
    
    static {
        MSG = ResourceBundle.getBundle("org.fife.ui.rsyntaxtextarea.focusabletip.FocusableTip");
    }
    
    private class TextAreaListener extends MouseInputAdapter implements CaretListener, ComponentListener, FocusListener, KeyListener
    {
        @Override
        public void caretUpdate(final CaretEvent e) {
            final Object source = e.getSource();
            if (source == FocusableTip.this.textArea) {
                FocusableTip.this.possiblyDisposeOfTipWindow();
            }
        }
        
        @Override
        public void componentHidden(final ComponentEvent e) {
            this.handleComponentEvent(e);
        }
        
        @Override
        public void componentMoved(final ComponentEvent e) {
            this.handleComponentEvent(e);
        }
        
        @Override
        public void componentResized(final ComponentEvent e) {
            this.handleComponentEvent(e);
        }
        
        @Override
        public void componentShown(final ComponentEvent e) {
            this.handleComponentEvent(e);
        }
        
        @Override
        public void focusGained(final FocusEvent e) {
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            final Component c = e.getOppositeComponent();
            final boolean tipClicked = c instanceof TipWindow || (c != null && SwingUtilities.getWindowAncestor(c) instanceof TipWindow);
            if (!tipClicked) {
                FocusableTip.this.possiblyDisposeOfTipWindow();
            }
        }
        
        private void handleComponentEvent(final ComponentEvent e) {
            FocusableTip.this.possiblyDisposeOfTipWindow();
        }
        
        public void install(final JTextArea textArea) {
            textArea.addCaretListener(this);
            textArea.addComponentListener(this);
            textArea.addFocusListener(this);
            textArea.addKeyListener(this);
            textArea.addMouseListener(this);
            textArea.addMouseMotionListener(this);
        }
        
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == 27) {
                FocusableTip.this.possiblyDisposeOfTipWindow();
            }
            else if (e.getKeyCode() == 113 && FocusableTip.this.tipWindow != null && !FocusableTip.this.tipWindow.getFocusableWindowState()) {
                FocusableTip.this.tipWindow.actionPerformed(null);
                e.consume();
            }
        }
        
        @Override
        public void keyReleased(final KeyEvent e) {
        }
        
        @Override
        public void keyTyped(final KeyEvent e) {
        }
        
        @Override
        public void mouseExited(final MouseEvent e) {
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
            if (FocusableTip.this.tipVisibleBounds == null || !FocusableTip.this.tipVisibleBounds.contains(e.getPoint())) {
                FocusableTip.this.possiblyDisposeOfTipWindow();
            }
        }
        
        public void uninstall() {
            FocusableTip.this.textArea.removeCaretListener(this);
            FocusableTip.this.textArea.removeComponentListener(this);
            FocusableTip.this.textArea.removeFocusListener(this);
            FocusableTip.this.textArea.removeKeyListener(this);
            FocusableTip.this.textArea.removeMouseListener(this);
            FocusableTip.this.textArea.removeMouseMotionListener(this);
        }
    }
}
