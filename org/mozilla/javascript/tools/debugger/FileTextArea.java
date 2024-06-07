//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class FileTextArea extends JTextArea implements ActionListener, PopupMenuListener, KeyListener, MouseListener
{
    private static final long serialVersionUID = -25032065448563720L;
    private FileWindow w;
    private FilePopupMenu popup;
    
    public FileTextArea(final FileWindow w) {
        this.w = w;
        (this.popup = new FilePopupMenu(this)).addPopupMenuListener((PopupMenuListener)this);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFont(new Font("Monospaced", 0, 12));
    }
    
    public void select(final int pos) {
        if (pos >= 0) {
            try {
                final int line = this.getLineOfOffset(pos);
                Rectangle rect = this.modelToView(pos);
                if (rect == null) {
                    this.select(pos, pos);
                }
                else {
                    try {
                        final Rectangle nrect = this.modelToView(this.getLineStartOffset(line + 1));
                        if (nrect != null) {
                            rect = nrect;
                        }
                    }
                    catch (Exception ex) {}
                    final JViewport vp = (JViewport)this.getParent();
                    final Rectangle viewRect = vp.getViewRect();
                    if (viewRect.y + viewRect.height > rect.y) {
                        this.select(pos, pos);
                    }
                    else {
                        final Rectangle rectangle = rect;
                        rectangle.y += (viewRect.height - rect.height) / 2;
                        this.scrollRectToVisible(rect);
                        this.select(pos, pos);
                    }
                }
            }
            catch (BadLocationException exc) {
                this.select(pos, pos);
            }
        }
    }
    
    private void checkPopup(final MouseEvent e) {
        if (e.isPopupTrigger()) {
            this.popup.show((JComponent)this, e.getX(), e.getY());
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        this.checkPopup(e);
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        this.checkPopup(e);
        this.requestFocus();
        this.getCaret().setVisible(true);
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        this.checkPopup(e);
    }
    
    @Override
    public void popupMenuWillBecomeVisible(final PopupMenuEvent e) {
    }
    
    @Override
    public void popupMenuWillBecomeInvisible(final PopupMenuEvent e) {
    }
    
    @Override
    public void popupMenuCanceled(final PopupMenuEvent e) {
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final int pos = this.viewToModel(new Point(this.popup.x, this.popup.y));
        this.popup.setVisible(false);
        final String cmd = e.getActionCommand();
        int line = -1;
        try {
            line = this.getLineOfOffset(pos);
        }
        catch (Exception ex) {}
        if (cmd.equals("Set Breakpoint")) {
            this.w.setBreakPoint(line + 1);
        }
        else if (cmd.equals("Clear Breakpoint")) {
            this.w.clearBreakPoint(line + 1);
        }
        else if (cmd.equals("Run")) {
            this.w.load();
        }
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case 8:
            case 9:
            case 10:
            case 127: {
                e.consume();
                break;
            }
        }
    }
    
    @Override
    public void keyTyped(final KeyEvent e) {
        e.consume();
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
        e.consume();
    }
}
