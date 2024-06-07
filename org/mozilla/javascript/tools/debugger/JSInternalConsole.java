//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.shell.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.event.*;

class JSInternalConsole extends JInternalFrame implements ActionListener
{
    private static final long serialVersionUID = -5523468828771087292L;
    ConsoleTextArea consoleTextArea;
    
    public JSInternalConsole(final String name) {
        super(name, true, false, true, true);
        (this.consoleTextArea = new ConsoleTextArea((String[])null)).setRows(24);
        this.consoleTextArea.setColumns(80);
        final JScrollPane scroller = new JScrollPane(this.consoleTextArea);
        this.setContentPane(scroller);
        this.pack();
        this.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(final InternalFrameEvent e) {
                if (JSInternalConsole.this.consoleTextArea.hasFocus()) {
                    JSInternalConsole.this.consoleTextArea.getCaret().setVisible(false);
                    JSInternalConsole.this.consoleTextArea.getCaret().setVisible(true);
                }
            }
        });
    }
    
    public InputStream getIn() {
        return this.consoleTextArea.getIn();
    }
    
    public PrintStream getOut() {
        return this.consoleTextArea.getOut();
    }
    
    public PrintStream getErr() {
        return this.consoleTextArea.getErr();
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        if (cmd.equals("Cut")) {
            this.consoleTextArea.cut();
        }
        else if (cmd.equals("Copy")) {
            this.consoleTextArea.copy();
        }
        else if (cmd.equals("Paste")) {
            this.consoleTextArea.paste();
        }
    }
}
