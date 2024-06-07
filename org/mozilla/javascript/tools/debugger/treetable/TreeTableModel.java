//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger.treetable;

import javax.swing.tree.*;

public interface TreeTableModel extends TreeModel
{
    int getColumnCount();
    
    String getColumnName(final int p0);
    
    Class<?> getColumnClass(final int p0);
    
    Object getValueAt(final Object p0, final int p1);
    
    boolean isCellEditable(final Object p0, final int p1);
    
    void setValueAt(final Object p0, final Object p1, final int p2);
}
