//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger.treetable;

import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.*;

public class TreeTableModelAdapter extends AbstractTableModel
{
    private static final long serialVersionUID = 48741114609209052L;
    JTree tree;
    TreeTableModel treeTableModel;
    
    public TreeTableModelAdapter(final TreeTableModel treeTableModel, final JTree tree) {
        this.tree = tree;
        this.treeTableModel = treeTableModel;
        tree.addTreeExpansionListener(new TreeExpansionListener() {
            @Override
            public void treeExpanded(final TreeExpansionEvent event) {
                TreeTableModelAdapter.this.fireTableDataChanged();
            }
            
            @Override
            public void treeCollapsed(final TreeExpansionEvent event) {
                TreeTableModelAdapter.this.fireTableDataChanged();
            }
        });
        treeTableModel.addTreeModelListener((TreeModelListener)new TreeModelListener() {
            @Override
            public void treeNodesChanged(final TreeModelEvent e) {
                TreeTableModelAdapter.this.delayedFireTableDataChanged();
            }
            
            @Override
            public void treeNodesInserted(final TreeModelEvent e) {
                TreeTableModelAdapter.this.delayedFireTableDataChanged();
            }
            
            @Override
            public void treeNodesRemoved(final TreeModelEvent e) {
                TreeTableModelAdapter.this.delayedFireTableDataChanged();
            }
            
            @Override
            public void treeStructureChanged(final TreeModelEvent e) {
                TreeTableModelAdapter.this.delayedFireTableDataChanged();
            }
        });
    }
    
    @Override
    public int getColumnCount() {
        return this.treeTableModel.getColumnCount();
    }
    
    @Override
    public String getColumnName(final int column) {
        return this.treeTableModel.getColumnName(column);
    }
    
    @Override
    public Class<?> getColumnClass(final int column) {
        return (Class<?>)this.treeTableModel.getColumnClass(column);
    }
    
    @Override
    public int getRowCount() {
        return this.tree.getRowCount();
    }
    
    protected Object nodeForRow(final int row) {
        final TreePath treePath = this.tree.getPathForRow(row);
        return treePath.getLastPathComponent();
    }
    
    @Override
    public Object getValueAt(final int row, final int column) {
        return this.treeTableModel.getValueAt(this.nodeForRow(row), column);
    }
    
    @Override
    public boolean isCellEditable(final int row, final int column) {
        return this.treeTableModel.isCellEditable(this.nodeForRow(row), column);
    }
    
    @Override
    public void setValueAt(final Object value, final int row, final int column) {
        this.treeTableModel.setValueAt(value, this.nodeForRow(row), column);
    }
    
    protected void delayedFireTableDataChanged() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TreeTableModelAdapter.this.fireTableDataChanged();
            }
        });
    }
}
