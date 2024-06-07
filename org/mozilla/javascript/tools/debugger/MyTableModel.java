//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.table.*;
import java.util.*;

class MyTableModel extends AbstractTableModel
{
    private static final long serialVersionUID = 2971618907207577000L;
    private SwingGui debugGui;
    private List<String> expressions;
    private List<String> values;
    
    public MyTableModel(final SwingGui debugGui) {
        this.debugGui = debugGui;
        this.expressions = Collections.synchronizedList(new ArrayList<String>());
        this.values = Collections.synchronizedList(new ArrayList<String>());
        this.expressions.add("");
        this.values.add("");
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public int getRowCount() {
        return this.expressions.size();
    }
    
    @Override
    public String getColumnName(final int column) {
        switch (column) {
            case 0: {
                return "Expression";
            }
            case 1: {
                return "Value";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public boolean isCellEditable(final int row, final int column) {
        return true;
    }
    
    @Override
    public Object getValueAt(final int row, final int column) {
        switch (column) {
            case 0: {
                return this.expressions.get(row);
            }
            case 1: {
                return this.values.get(row);
            }
            default: {
                return "";
            }
        }
    }
    
    @Override
    public void setValueAt(final Object value, final int row, final int column) {
        switch (column) {
            case 0: {
                final String expr = value.toString();
                this.expressions.set(row, expr);
                String result = "";
                if (expr.length() > 0) {
                    result = this.debugGui.dim.eval(expr);
                    if (result == null) {
                        result = "";
                    }
                }
                this.values.set(row, result);
                this.updateModel();
                if (row + 1 == this.expressions.size()) {
                    this.expressions.add("");
                    this.values.add("");
                    this.fireTableRowsInserted(row + 1, row + 1);
                    break;
                }
                break;
            }
            case 1: {
                this.fireTableDataChanged();
                break;
            }
        }
    }
    
    void updateModel() {
        for (int i = 0; i < this.expressions.size(); ++i) {
            final String expr = this.expressions.get(i);
            String result = "";
            if (expr.length() > 0) {
                result = this.debugGui.dim.eval(expr);
                if (result == null) {
                    result = "";
                }
            }
            else {
                result = "";
            }
            result = result.replace('\n', ' ');
            this.values.set(i, result);
        }
        this.fireTableDataChanged();
    }
}
