//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EvalWindow extends JInternalFrame implements ActionListener
{
    private static final long serialVersionUID = -2860585845212160176L;
    private EvalTextArea evalTextArea;
    
    public EvalWindow(final String name, final SwingGui debugGui) {
        super(name, true, false, true, true);
        (this.evalTextArea = new EvalTextArea(debugGui)).setRows(24);
        this.evalTextArea.setColumns(80);
        final JScrollPane scroller = new JScrollPane((Component)this.evalTextArea);
        this.setContentPane(scroller);
        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        this.evalTextArea.setEnabled(b);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        if (cmd.equals("Cut")) {
            this.evalTextArea.cut();
        }
        else if (cmd.equals("Copy")) {
            this.evalTextArea.copy();
        }
        else if (cmd.equals("Paste")) {
            this.evalTextArea.paste();
        }
    }
}
