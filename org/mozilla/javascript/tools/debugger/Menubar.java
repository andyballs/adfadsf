//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Menubar extends JMenuBar implements ActionListener
{
    private static final long serialVersionUID = 3217170497245911461L;
    private List<JMenuItem> interruptOnlyItems;
    private List<JMenuItem> runOnlyItems;
    private SwingGui debugGui;
    private JMenu windowMenu;
    private JCheckBoxMenuItem breakOnExceptions;
    private JCheckBoxMenuItem breakOnEnter;
    private JCheckBoxMenuItem breakOnReturn;
    
    Menubar(final SwingGui debugGui) {
        this.interruptOnlyItems = Collections.synchronizedList(new ArrayList<JMenuItem>());
        this.runOnlyItems = Collections.synchronizedList(new ArrayList<JMenuItem>());
        this.debugGui = debugGui;
        final String[] fileItems = { "Open...", "Run...", "", "Exit" };
        final String[] fileCmds = { "Open", "Load", "", "Exit" };
        final char[] fileShortCuts = { '0', 'N', '\0', 'X' };
        final int[] fileAccelerators = { 79, 78, 0, 81 };
        final String[] editItems = { "Cut", "Copy", "Paste", "Go to function...", "Go to line..." };
        final char[] editShortCuts = { 'T', 'C', 'P', 'F', 'L' };
        final int[] editAccelerators = { 0, 0, 0, 0, 76 };
        final String[] debugItems = { "Break", "Go", "Step Into", "Step Over", "Step Out" };
        final char[] debugShortCuts = { 'B', 'G', 'I', 'O', 'T' };
        final String[] plafItems = { "Metal", "Windows", "Motif" };
        final char[] plafShortCuts = { 'M', 'W', 'F' };
        final int[] debugAccelerators = { 19, 116, 122, 118, 119, 0, 0 };
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        final JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        final JMenu plafMenu = new JMenu("Platform");
        plafMenu.setMnemonic('P');
        final JMenu debugMenu = new JMenu("Debug");
        debugMenu.setMnemonic('D');
        (this.windowMenu = new JMenu("Window")).setMnemonic('W');
        for (int i = 0; i < fileItems.length; ++i) {
            if (fileItems[i].length() == 0) {
                fileMenu.addSeparator();
            }
            else {
                final JMenuItem item = new JMenuItem(fileItems[i], fileShortCuts[i]);
                item.setActionCommand(fileCmds[i]);
                item.addActionListener(this);
                fileMenu.add(item);
                if (fileAccelerators[i] != 0) {
                    final KeyStroke k = KeyStroke.getKeyStroke(fileAccelerators[i], 2);
                    item.setAccelerator(k);
                }
            }
        }
        for (int i = 0; i < editItems.length; ++i) {
            final JMenuItem item = new JMenuItem(editItems[i], editShortCuts[i]);
            item.addActionListener(this);
            editMenu.add(item);
            if (editAccelerators[i] != 0) {
                final KeyStroke k = KeyStroke.getKeyStroke(editAccelerators[i], 2);
                item.setAccelerator(k);
            }
        }
        for (int i = 0; i < plafItems.length; ++i) {
            final JMenuItem item = new JMenuItem(plafItems[i], plafShortCuts[i]);
            item.addActionListener(this);
            plafMenu.add(item);
        }
        for (int i = 0; i < debugItems.length; ++i) {
            final JMenuItem item = new JMenuItem(debugItems[i], debugShortCuts[i]);
            item.addActionListener(this);
            if (debugAccelerators[i] != 0) {
                final KeyStroke k = KeyStroke.getKeyStroke(debugAccelerators[i], 0);
                item.setAccelerator(k);
            }
            if (i != 0) {
                this.interruptOnlyItems.add(item);
            }
            else {
                this.runOnlyItems.add(item);
            }
            debugMenu.add(item);
        }
        (this.breakOnExceptions = new JCheckBoxMenuItem("Break on Exceptions")).setMnemonic('X');
        this.breakOnExceptions.addActionListener(this);
        this.breakOnExceptions.setSelected(false);
        debugMenu.add(this.breakOnExceptions);
        (this.breakOnEnter = new JCheckBoxMenuItem("Break on Function Enter")).setMnemonic('E');
        this.breakOnEnter.addActionListener(this);
        this.breakOnEnter.setSelected(false);
        debugMenu.add(this.breakOnEnter);
        (this.breakOnReturn = new JCheckBoxMenuItem("Break on Function Return")).setMnemonic('R');
        this.breakOnReturn.addActionListener(this);
        this.breakOnReturn.setSelected(false);
        debugMenu.add(this.breakOnReturn);
        this.add(fileMenu);
        this.add(editMenu);
        this.add(debugMenu);
        JMenuItem item2;
        this.windowMenu.add(item2 = new JMenuItem("Cascade", 65));
        item2.addActionListener(this);
        this.windowMenu.add(item2 = new JMenuItem("Tile", 84));
        item2.addActionListener(this);
        this.windowMenu.addSeparator();
        this.windowMenu.add(item2 = new JMenuItem("Console", 67));
        item2.addActionListener(this);
        this.add(this.windowMenu);
        this.updateEnabled(false);
    }
    
    public JCheckBoxMenuItem getBreakOnExceptions() {
        return this.breakOnExceptions;
    }
    
    public JCheckBoxMenuItem getBreakOnEnter() {
        return this.breakOnEnter;
    }
    
    public JCheckBoxMenuItem getBreakOnReturn() {
        return this.breakOnReturn;
    }
    
    public JMenu getDebugMenu() {
        return this.getMenu(2);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        String plaf_name = null;
        if (cmd.equals("Metal")) {
            plaf_name = "javax.swing.plaf.metal.MetalLookAndFeel";
        }
        else if (cmd.equals("Windows")) {
            plaf_name = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        }
        else {
            if (!cmd.equals("Motif")) {
                final Object source = e.getSource();
                if (source == this.breakOnExceptions) {
                    this.debugGui.dim.setBreakOnExceptions(this.breakOnExceptions.isSelected());
                }
                else if (source == this.breakOnEnter) {
                    this.debugGui.dim.setBreakOnEnter(this.breakOnEnter.isSelected());
                }
                else if (source == this.breakOnReturn) {
                    this.debugGui.dim.setBreakOnReturn(this.breakOnReturn.isSelected());
                }
                else {
                    this.debugGui.actionPerformed(e);
                }
                return;
            }
            plaf_name = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(plaf_name);
            SwingUtilities.updateComponentTreeUI(this.debugGui);
            SwingUtilities.updateComponentTreeUI(this.debugGui.dlg);
        }
        catch (Exception ex) {}
    }
    
    public void addFile(final String url) {
        int count = this.windowMenu.getItemCount();
        if (count == 4) {
            this.windowMenu.addSeparator();
            ++count;
        }
        final JMenuItem lastItem = this.windowMenu.getItem(count - 1);
        boolean hasMoreWin = false;
        int maxWin = 5;
        if (lastItem != null && lastItem.getText().equals("More Windows...")) {
            hasMoreWin = true;
            ++maxWin;
        }
        if (!hasMoreWin && count - 4 == 5) {
            final JMenuItem item;
            this.windowMenu.add(item = new JMenuItem("More Windows...", 77));
            item.setActionCommand("More Windows...");
            item.addActionListener(this);
            return;
        }
        if (count - 4 <= maxWin) {
            if (hasMoreWin) {
                --count;
                this.windowMenu.remove(lastItem);
            }
            final String shortName = SwingGui.getShortName(url);
            final JMenuItem item;
            this.windowMenu.add(item = new JMenuItem((char)(48 + (count - 4)) + " " + shortName, 48 + (count - 4)));
            if (hasMoreWin) {
                this.windowMenu.add(lastItem);
            }
            item.setActionCommand(url);
            item.addActionListener(this);
        }
    }
    
    public void updateEnabled(final boolean interrupted) {
        for (int i = 0; i != this.interruptOnlyItems.size(); ++i) {
            final JMenuItem item = this.interruptOnlyItems.get(i);
            item.setEnabled(interrupted);
        }
        for (int i = 0; i != this.runOnlyItems.size(); ++i) {
            final JMenuItem item = this.runOnlyItems.get(i);
            item.setEnabled(!interrupted);
        }
    }
}
