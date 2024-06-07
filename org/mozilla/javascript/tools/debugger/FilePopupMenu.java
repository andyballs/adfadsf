//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class FilePopupMenu extends JPopupMenu
{
    private static final long serialVersionUID = 3589525009546013565L;
    int x;
    int y;
    
    public FilePopupMenu(final FileTextArea w) {
        JMenuItem item;
        this.add(item = new JMenuItem("Set Breakpoint"));
        item.addActionListener(w);
        this.add(item = new JMenuItem("Clear Breakpoint"));
        item.addActionListener(w);
        this.add(item = new JMenuItem("Run"));
        item.addActionListener(w);
    }
    
    public void show(final JComponent comp, final int x, final int y) {
        super.show(comp, this.x = x, this.y = y);
    }
}
