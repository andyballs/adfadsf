//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.text.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class FileWindow extends JInternalFrame implements ActionListener
{
    private static final long serialVersionUID = -6212382604952082370L;
    private SwingGui debugGui;
    private Dim.SourceInfo sourceInfo;
    FileTextArea textArea;
    private FileHeader fileHeader;
    private JScrollPane p;
    int currentPos;
    
    void load() {
        final String url = this.getUrl();
        if (url != null) {
            final RunProxy proxy = new RunProxy(this.debugGui, 2);
            proxy.fileName = url;
            proxy.text = this.sourceInfo.source();
            new Thread(proxy).start();
        }
    }
    
    public int getPosition(final int line) {
        int result = -1;
        try {
            result = this.textArea.getLineStartOffset(line);
        }
        catch (BadLocationException ex) {}
        return result;
    }
    
    public boolean isBreakPoint(final int line) {
        return this.sourceInfo.breakableLine(line) && this.sourceInfo.breakpoint(line);
    }
    
    public void toggleBreakPoint(final int line) {
        if (!this.isBreakPoint(line)) {
            this.setBreakPoint(line);
        }
        else {
            this.clearBreakPoint(line);
        }
    }
    
    public void setBreakPoint(final int line) {
        if (this.sourceInfo.breakableLine(line)) {
            final boolean changed = this.sourceInfo.breakpoint(line, true);
            if (changed) {
                this.fileHeader.repaint();
            }
        }
    }
    
    public void clearBreakPoint(final int line) {
        if (this.sourceInfo.breakableLine(line)) {
            final boolean changed = this.sourceInfo.breakpoint(line, false);
            if (changed) {
                this.fileHeader.repaint();
            }
        }
    }
    
    public FileWindow(final SwingGui debugGui, final Dim.SourceInfo sourceInfo) {
        super(SwingGui.getShortName(sourceInfo.url()), true, true, true, true);
        this.debugGui = debugGui;
        this.sourceInfo = sourceInfo;
        this.updateToolTip();
        this.currentPos = -1;
        (this.textArea = new FileTextArea(this)).setRows(24);
        this.textArea.setColumns(80);
        this.p = new JScrollPane();
        this.fileHeader = new FileHeader(this);
        this.p.setViewportView((Component)this.textArea);
        this.p.setRowHeaderView((Component)this.fileHeader);
        this.setContentPane(this.p);
        this.pack();
        this.updateText(sourceInfo);
        this.textArea.select(0);
    }
    
    private void updateToolTip() {
        int n = this.getComponentCount() - 1;
        if (n > 1) {
            n = 1;
        }
        else if (n < 0) {
            return;
        }
        final Component c = this.getComponent(n);
        if (c != null && c instanceof JComponent) {
            ((JComponent)c).setToolTipText(this.getUrl());
        }
    }
    
    public String getUrl() {
        return this.sourceInfo.url();
    }
    
    public void updateText(final Dim.SourceInfo sourceInfo) {
        this.sourceInfo = sourceInfo;
        final String newText = sourceInfo.source();
        if (!this.textArea.getText().equals(newText)) {
            this.textArea.setText(newText);
            int pos = 0;
            if (this.currentPos != -1) {
                pos = this.currentPos;
            }
            this.textArea.select(pos);
        }
        this.fileHeader.update();
        this.fileHeader.repaint();
    }
    
    public void setPosition(final int pos) {
        this.textArea.select(pos);
        this.currentPos = pos;
        this.fileHeader.repaint();
    }
    
    public void select(final int start, final int end) {
        final int docEnd = this.textArea.getDocument().getLength();
        this.textArea.select(docEnd, docEnd);
        this.textArea.select(start, end);
    }
    
    @Override
    public void dispose() {
        this.debugGui.removeWindow(this);
        super.dispose();
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        if (!cmd.equals("Cut")) {
            if (cmd.equals("Copy")) {
                this.textArea.copy();
            }
            else if (cmd.equals("Paste")) {}
        }
    }
}
