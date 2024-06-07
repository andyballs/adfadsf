//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import java.io.*;
import org.mozilla.javascript.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSConsole extends JFrame implements ActionListener
{
    static final long serialVersionUID = 2551225560631876300L;
    private File CWD;
    private JFileChooser dlg;
    private ConsoleTextArea consoleTextArea;
    
    public String chooseFile() {
        if (this.CWD == null) {
            final String dir = SecurityUtilities.getSystemProperty("user.dir");
            if (dir != null) {
                this.CWD = new File(dir);
            }
        }
        if (this.CWD != null) {
            this.dlg.setCurrentDirectory(this.CWD);
        }
        this.dlg.setDialogTitle("Select a file to load");
        final int returnVal = this.dlg.showOpenDialog(this);
        if (returnVal == 0) {
            final String result = this.dlg.getSelectedFile().getPath();
            this.CWD = new File(this.dlg.getSelectedFile().getParent());
            return result;
        }
        return null;
    }
    
    public static void main(final String[] args) {
        new JSConsole(args);
    }
    
    public void createFileChooser() {
        this.dlg = new JFileChooser();
        final FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(final File f) {
                if (f.isDirectory()) {
                    return true;
                }
                final String name = f.getName();
                final int i = name.lastIndexOf(46);
                if (i > 0 && i < name.length() - 1) {
                    final String ext = name.substring(i + 1).toLowerCase();
                    if (ext.equals("js")) {
                        return true;
                    }
                }
                return false;
            }
            
            @Override
            public String getDescription() {
                return "JavaScript Files (*.js)";
            }
        };
        this.dlg.addChoosableFileFilter(filter);
    }
    
    public JSConsole(final String[] args) {
        super("Rhino JavaScript Console");
        final JMenuBar menubar = new JMenuBar();
        this.createFileChooser();
        final String[] fileItems = { "Load...", "Exit" };
        final String[] fileCmds = { "Load", "Exit" };
        final char[] fileShortCuts = { 'L', 'X' };
        final String[] editItems = { "Cut", "Copy", "Paste" };
        final char[] editShortCuts = { 'T', 'C', 'P' };
        final String[] plafItems = { "Metal", "Windows", "Motif" };
        final boolean[] plafState = { true, false, false };
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        final JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        final JMenu plafMenu = new JMenu("Platform");
        plafMenu.setMnemonic('P');
        for (int i = 0; i < fileItems.length; ++i) {
            final JMenuItem item = new JMenuItem(fileItems[i], fileShortCuts[i]);
            item.setActionCommand(fileCmds[i]);
            item.addActionListener(this);
            fileMenu.add(item);
        }
        for (int i = 0; i < editItems.length; ++i) {
            final JMenuItem item = new JMenuItem(editItems[i], editShortCuts[i]);
            item.addActionListener(this);
            editMenu.add(item);
        }
        final ButtonGroup group = new ButtonGroup();
        for (int j = 0; j < plafItems.length; ++j) {
            final JRadioButtonMenuItem item2 = new JRadioButtonMenuItem(plafItems[j], plafState[j]);
            group.add(item2);
            item2.addActionListener(this);
            plafMenu.add(item2);
        }
        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(plafMenu);
        this.setJMenuBar(menubar);
        this.consoleTextArea = new ConsoleTextArea(args);
        final JScrollPane scroller = new JScrollPane((Component)this.consoleTextArea);
        this.setContentPane(scroller);
        this.consoleTextArea.setRows(24);
        this.consoleTextArea.setColumns(80);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });
        this.pack();
        this.setVisible(true);
        Main.setIn(this.consoleTextArea.getIn());
        Main.setOut(this.consoleTextArea.getOut());
        Main.setErr(this.consoleTextArea.getErr());
        Main.main(args);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        String plaf_name = null;
        if (cmd.equals("Load")) {
            String f = this.chooseFile();
            if (f != null) {
                f = f.replace('\\', '/');
                this.consoleTextArea.eval("load(\"" + f + "\");");
            }
        }
        else if (cmd.equals("Exit")) {
            System.exit(0);
        }
        else if (cmd.equals("Cut")) {
            this.consoleTextArea.cut();
        }
        else if (cmd.equals("Copy")) {
            this.consoleTextArea.copy();
        }
        else if (cmd.equals("Paste")) {
            this.consoleTextArea.paste();
        }
        else {
            if (cmd.equals("Metal")) {
                plaf_name = "javax.swing.plaf.metal.MetalLookAndFeel";
            }
            else if (cmd.equals("Windows")) {
                plaf_name = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            }
            else if (cmd.equals("Motif")) {
                plaf_name = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            }
            if (plaf_name != null) {
                try {
                    UIManager.setLookAndFeel(plaf_name);
                    SwingUtilities.updateComponentTreeUI(this);
                    this.consoleTextArea.postUpdateUI();
                    this.createFileChooser();
                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(this, exc.getMessage(), "Platform", 0);
                }
            }
        }
    }
}
