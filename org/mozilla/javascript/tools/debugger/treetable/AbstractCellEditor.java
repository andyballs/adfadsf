//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger.treetable;

import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

public class AbstractCellEditor implements CellEditor
{
    protected EventListenerList listenerList;
    
    public AbstractCellEditor() {
        this.listenerList = new EventListenerList();
    }
    
    @Override
    public Object getCellEditorValue() {
        return null;
    }
    
    @Override
    public boolean isCellEditable(final EventObject e) {
        return true;
    }
    
    @Override
    public boolean shouldSelectCell(final EventObject anEvent) {
        return false;
    }
    
    @Override
    public boolean stopCellEditing() {
        return true;
    }
    
    @Override
    public void cancelCellEditing() {
    }
    
    @Override
    public void addCellEditorListener(final CellEditorListener l) {
        this.listenerList.add(CellEditorListener.class, l);
    }
    
    @Override
    public void removeCellEditorListener(final CellEditorListener l) {
        this.listenerList.remove(CellEditorListener.class, l);
    }
    
    protected void fireEditingStopped() {
        final Object[] listeners = this.listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                ((CellEditorListener)listeners[i + 1]).editingStopped(new ChangeEvent(this));
            }
        }
    }
    
    protected void fireEditingCanceled() {
        final Object[] listeners = this.listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                ((CellEditorListener)listeners[i + 1]).editingCanceled(new ChangeEvent(this));
            }
        }
    }
}
