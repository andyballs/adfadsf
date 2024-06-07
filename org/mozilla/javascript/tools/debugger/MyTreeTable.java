//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.debugger.treetable.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

class MyTreeTable extends JTreeTable
{
    private static final long serialVersionUID = 3457265548184453049L;
    
    public MyTreeTable(final VariableModel model) {
        super(model);
    }
    
    public JTree resetTree(final TreeTableModel treeTableModel) {
        this.tree = new TreeTableCellRenderer(treeTableModel);
        super.setModel(new TreeTableModelAdapter(treeTableModel, this.tree));
        final ListToTreeSelectionModelWrapper selectionWrapper = new ListToTreeSelectionModelWrapper();
        this.tree.setSelectionModel(selectionWrapper);
        this.setSelectionModel(selectionWrapper.getListSelectionModel());
        if (this.tree.getRowHeight() < 1) {
            this.setRowHeight(18);
        }
        this.setDefaultRenderer(TreeTableModel.class, this.tree);
        this.setDefaultEditor(TreeTableModel.class, new TreeTableCellEditor());
        this.setShowGrid(true);
        this.setIntercellSpacing(new Dimension(1, 1));
        this.tree.setRootVisible(false);
        this.tree.setShowsRootHandles(true);
        final DefaultTreeCellRenderer r = (DefaultTreeCellRenderer)this.tree.getCellRenderer();
        r.setOpenIcon(null);
        r.setClosedIcon(null);
        r.setLeafIcon(null);
        return this.tree;
    }
    
    public boolean isCellEditable(final EventObject e) {
        if (e instanceof MouseEvent) {
            final MouseEvent me = (MouseEvent)e;
            if (me.getModifiers() == 0 || ((me.getModifiers() & 0x410) != 0x0 && (me.getModifiers() & 0x1ACF) == 0x0)) {
                final int row = this.rowAtPoint(me.getPoint());
                for (int counter = this.getColumnCount() - 1; counter >= 0; --counter) {
                    if (TreeTableModel.class == this.getColumnClass(counter)) {
                        final MouseEvent newME = new MouseEvent(this.tree, me.getID(), me.getWhen(), me.getModifiers(), me.getX() - this.getCellRect(row, counter, true).x, me.getY(), me.getClickCount(), me.isPopupTrigger());
                        this.tree.dispatchEvent(newME);
                        break;
                    }
                }
            }
            return me.getClickCount() >= 3;
        }
        return e == null;
    }
}
