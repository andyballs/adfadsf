//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger.treetable;

import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTable extends JTable
{
    private static final long serialVersionUID = -2103973006456695515L;
    protected TreeTableCellRenderer tree;
    
    public JTreeTable(final TreeTableModel treeTableModel) {
        this.tree = new TreeTableCellRenderer(treeTableModel);
        super.setModel(new TreeTableModelAdapter(treeTableModel, this.tree));
        final ListToTreeSelectionModelWrapper selectionWrapper = new ListToTreeSelectionModelWrapper();
        this.tree.setSelectionModel(selectionWrapper);
        this.setSelectionModel(selectionWrapper.getListSelectionModel());
        this.setDefaultRenderer(TreeTableModel.class, this.tree);
        this.setDefaultEditor(TreeTableModel.class, new TreeTableCellEditor());
        this.setShowGrid(false);
        this.setIntercellSpacing(new Dimension(0, 0));
        if (this.tree.getRowHeight() < 1) {
            this.setRowHeight(18);
        }
    }
    
    @Override
    public void updateUI() {
        super.updateUI();
        if (this.tree != null) {
            this.tree.updateUI();
        }
        LookAndFeel.installColorsAndFont(this, "Tree.background", "Tree.foreground", "Tree.font");
    }
    
    @Override
    public int getEditingRow() {
        return (this.getColumnClass(this.editingColumn) == TreeTableModel.class) ? -1 : this.editingRow;
    }
    
    @Override
    public void setRowHeight(final int rowHeight) {
        super.setRowHeight(rowHeight);
        if (this.tree != null && this.tree.getRowHeight() != rowHeight) {
            this.tree.setRowHeight(this.getRowHeight());
        }
    }
    
    public JTree getTree() {
        return this.tree;
    }
    
    public class TreeTableCellRenderer extends JTree implements TableCellRenderer
    {
        private static final long serialVersionUID = -193867880014600717L;
        protected int visibleRow;
        
        public TreeTableCellRenderer(final TreeModel model) {
            super(model);
        }
        
        @Override
        public void updateUI() {
            super.updateUI();
            final TreeCellRenderer tcr = this.getCellRenderer();
            if (tcr instanceof DefaultTreeCellRenderer) {
                final DefaultTreeCellRenderer dtcr = (DefaultTreeCellRenderer)tcr;
                dtcr.setTextSelectionColor(UIManager.getColor("Table.selectionForeground"));
                dtcr.setBackgroundSelectionColor(UIManager.getColor("Table.selectionBackground"));
            }
        }
        
        @Override
        public void setRowHeight(final int rowHeight) {
            if (rowHeight > 0) {
                super.setRowHeight(rowHeight);
                if (JTreeTable.this.getRowHeight() != rowHeight) {
                    JTreeTable.this.setRowHeight(this.getRowHeight());
                }
            }
        }
        
        @Override
        public void setBounds(final int x, final int y, final int w, final int h) {
            super.setBounds(x, 0, w, JTreeTable.this.getHeight());
        }
        
        @Override
        public void paint(final Graphics g) {
            g.translate(0, -this.visibleRow * this.getRowHeight());
            super.paint(g);
        }
        
        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
            if (isSelected) {
                this.setBackground(table.getSelectionBackground());
            }
            else {
                this.setBackground(table.getBackground());
            }
            this.visibleRow = row;
            return this;
        }
    }
    
    public class TreeTableCellEditor extends AbstractCellEditor implements TableCellEditor
    {
        public Component getTableCellEditorComponent(final JTable table, final Object value, final boolean isSelected, final int r, final int c) {
            return JTreeTable.this.tree;
        }
        
        public boolean isCellEditable(final EventObject e) {
            if (e instanceof MouseEvent) {
                for (int counter = JTreeTable.this.getColumnCount() - 1; counter >= 0; --counter) {
                    if (JTreeTable.this.getColumnClass(counter) == TreeTableModel.class) {
                        final MouseEvent me = (MouseEvent)e;
                        final MouseEvent newME = new MouseEvent(JTreeTable.this.tree, me.getID(), me.getWhen(), me.getModifiers(), me.getX() - JTreeTable.this.getCellRect(0, counter, true).x, me.getY(), me.getClickCount(), me.isPopupTrigger());
                        JTreeTable.this.tree.dispatchEvent(newME);
                        break;
                    }
                }
            }
            return false;
        }
    }
    
    public class ListToTreeSelectionModelWrapper extends DefaultTreeSelectionModel
    {
        private static final long serialVersionUID = 8168140829623071131L;
        protected boolean updatingListSelectionModel;
        
        public ListToTreeSelectionModelWrapper() {
            this.getListSelectionModel().addListSelectionListener(this.createListSelectionListener());
        }
        
        public ListSelectionModel getListSelectionModel() {
            return this.listSelectionModel;
        }
        
        @Override
        public void resetRowSelection() {
            if (!this.updatingListSelectionModel) {
                this.updatingListSelectionModel = true;
                try {
                    super.resetRowSelection();
                }
                finally {
                    this.updatingListSelectionModel = false;
                }
            }
        }
        
        protected ListSelectionListener createListSelectionListener() {
            return new ListSelectionHandler();
        }
        
        protected void updateSelectedPathsFromSelectedRows() {
            if (!this.updatingListSelectionModel) {
                this.updatingListSelectionModel = true;
                try {
                    final int min = this.listSelectionModel.getMinSelectionIndex();
                    final int max = this.listSelectionModel.getMaxSelectionIndex();
                    this.clearSelection();
                    if (min != -1 && max != -1) {
                        for (int counter = min; counter <= max; ++counter) {
                            if (this.listSelectionModel.isSelectedIndex(counter)) {
                                final TreePath selPath = JTreeTable.this.tree.getPathForRow(counter);
                                if (selPath != null) {
                                    this.addSelectionPath(selPath);
                                }
                            }
                        }
                    }
                }
                finally {
                    this.updatingListSelectionModel = false;
                }
            }
        }
        
        class ListSelectionHandler implements ListSelectionListener
        {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                ListToTreeSelectionModelWrapper.this.updateSelectedPathsFromSelectedRows();
            }
        }
    }
}
