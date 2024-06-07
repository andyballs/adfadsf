//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.debugger.treetable.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.util.*;

class VariableModel implements TreeTableModel
{
    private static final String[] cNames;
    private static final Class<?>[] cTypes;
    private static final VariableNode[] CHILDLESS;
    private Dim debugger;
    private VariableNode root;
    
    public VariableModel() {
    }
    
    public VariableModel(final Dim debugger, final Object scope) {
        this.debugger = debugger;
        this.root = new VariableNode(scope, "this");
    }
    
    public Object getRoot() {
        if (this.debugger == null) {
            return null;
        }
        return this.root;
    }
    
    public int getChildCount(final Object nodeObj) {
        if (this.debugger == null) {
            return 0;
        }
        final VariableNode node = (VariableNode)nodeObj;
        return this.children(node).length;
    }
    
    public Object getChild(final Object nodeObj, final int i) {
        if (this.debugger == null) {
            return null;
        }
        final VariableNode node = (VariableNode)nodeObj;
        return this.children(node)[i];
    }
    
    public boolean isLeaf(final Object nodeObj) {
        if (this.debugger == null) {
            return true;
        }
        final VariableNode node = (VariableNode)nodeObj;
        return this.children(node).length == 0;
    }
    
    public int getIndexOfChild(final Object parentObj, final Object childObj) {
        if (this.debugger == null) {
            return -1;
        }
        final VariableNode parent = (VariableNode)parentObj;
        final VariableNode child = (VariableNode)childObj;
        final VariableNode[] children = this.children(parent);
        for (int i = 0; i != children.length; ++i) {
            if (children[i] == child) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isCellEditable(final Object node, final int column) {
        return column == 0;
    }
    
    public void setValueAt(final Object value, final Object node, final int column) {
    }
    
    public void addTreeModelListener(final TreeModelListener l) {
    }
    
    public void removeTreeModelListener(final TreeModelListener l) {
    }
    
    public void valueForPathChanged(final TreePath path, final Object newValue) {
    }
    
    public int getColumnCount() {
        return VariableModel.cNames.length;
    }
    
    public String getColumnName(final int column) {
        return VariableModel.cNames[column];
    }
    
    public Class<?> getColumnClass(final int column) {
        return VariableModel.cTypes[column];
    }
    
    public Object getValueAt(final Object nodeObj, final int column) {
        if (this.debugger == null) {
            return null;
        }
        final VariableNode node = (VariableNode)nodeObj;
        switch (column) {
            case 0: {
                return node.toString();
            }
            case 1: {
                String result;
                try {
                    result = this.debugger.objectToString(this.getValue(node));
                }
                catch (RuntimeException exc) {
                    result = exc.getMessage();
                }
                final StringBuilder buf = new StringBuilder();
                for (int len = result.length(), i = 0; i < len; ++i) {
                    char ch = result.charAt(i);
                    if (Character.isISOControl(ch)) {
                        ch = ' ';
                    }
                    buf.append(ch);
                }
                return buf.toString();
            }
            default: {
                return null;
            }
        }
    }
    
    private VariableNode[] children(final VariableNode node) {
        if (node.children != null) {
            return node.children;
        }
        final Object value = this.getValue(node);
        final Object[] ids = this.debugger.getObjectIds(value);
        VariableNode[] children;
        if (ids == null || ids.length == 0) {
            children = VariableModel.CHILDLESS;
        }
        else {
            Arrays.sort(ids, new Comparator<Object>() {
                @Override
                public int compare(final Object l, final Object r) {
                    if (l instanceof String) {
                        if (r instanceof Integer) {
                            return -1;
                        }
                        return ((String)l).compareToIgnoreCase((String)r);
                    }
                    else {
                        if (r instanceof String) {
                            return 1;
                        }
                        final int lint = (int)l;
                        final int rint = (int)r;
                        return lint - rint;
                    }
                }
            });
            children = new VariableNode[ids.length];
            for (int i = 0; i != ids.length; ++i) {
                children[i] = new VariableNode(value, ids[i]);
            }
        }
        node.children = children;
        return children;
    }
    
    public Object getValue(final VariableNode node) {
        try {
            return this.debugger.getObjectProperty(node.object, node.id);
        }
        catch (Exception exc) {
            return "undefined";
        }
    }
    
    static {
        cNames = new String[] { " Name", " Value" };
        cTypes = new Class[] { TreeTableModel.class, String.class };
        CHILDLESS = new VariableNode[0];
    }
    
    private static class VariableNode
    {
        private Object object;
        private Object id;
        private VariableNode[] children;
        
        public VariableNode(final Object object, final Object id) {
            this.object = object;
            this.id = id;
        }
        
        @Override
        public String toString() {
            return (String)((this.id instanceof String) ? this.id : ("[" + (int)this.id + "]"));
        }
    }
}
