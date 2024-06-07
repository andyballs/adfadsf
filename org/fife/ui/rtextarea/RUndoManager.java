//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import java.util.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import javax.swing.*;

public class RUndoManager extends UndoManager
{
    private RCompoundEdit compoundEdit;
    private RTextArea textArea;
    private int lastOffset;
    private String cantUndoText;
    private String cantRedoText;
    private int internalAtomicEditDepth;
    private static final String MSG = "org.fife.ui.rtextarea.RTextArea";
    
    public RUndoManager(final RTextArea textArea) {
        this.textArea = textArea;
        final ResourceBundle msg = ResourceBundle.getBundle("org.fife.ui.rtextarea.RTextArea");
        this.cantUndoText = msg.getString("Action.CantUndo.Name");
        this.cantRedoText = msg.getString("Action.CantRedo.Name");
    }
    
    public void beginInternalAtomicEdit() {
        if (++this.internalAtomicEditDepth == 1) {
            if (this.compoundEdit != null) {
                this.compoundEdit.end();
            }
            this.compoundEdit = new RCompoundEdit();
        }
    }
    
    public void endInternalAtomicEdit() {
        if (this.internalAtomicEditDepth > 0 && --this.internalAtomicEditDepth == 0) {
            this.addEdit(this.compoundEdit);
            this.compoundEdit.end();
            this.compoundEdit = null;
            this.updateActions();
        }
    }
    
    public String getCantRedoText() {
        return this.cantRedoText;
    }
    
    public String getCantUndoText() {
        return this.cantUndoText;
    }
    
    @Override
    public void redo() {
        super.redo();
        this.updateActions();
    }
    
    private RCompoundEdit startCompoundEdit(final UndoableEdit edit) {
        this.lastOffset = this.textArea.getCaretPosition();
        (this.compoundEdit = new RCompoundEdit()).addEdit(edit);
        this.addEdit(this.compoundEdit);
        return this.compoundEdit;
    }
    
    @Override
    public void undo() {
        super.undo();
        this.updateActions();
    }
    
    @Override
    public void undoableEditHappened(final UndoableEditEvent e) {
        if (this.compoundEdit == null) {
            this.compoundEdit = this.startCompoundEdit(e.getEdit());
            this.updateActions();
            return;
        }
        if (this.internalAtomicEditDepth > 0) {
            this.compoundEdit.addEdit(e.getEdit());
            return;
        }
        final int diff = this.textArea.getCaretPosition() - this.lastOffset;
        if (Math.abs(diff) <= 1) {
            this.compoundEdit.addEdit(e.getEdit());
            this.lastOffset += diff;
            return;
        }
        this.compoundEdit.end();
        this.compoundEdit = this.startCompoundEdit(e.getEdit());
    }
    
    public void updateActions() {
        javax.swing.Action a = (javax.swing.Action)RTextArea.getAction(6);
        if (this.canUndo()) {
            a.setEnabled(true);
            final String text = this.getUndoPresentationName();
            a.putValue("Name", text);
            a.putValue("ShortDescription", text);
        }
        else if (a.isEnabled()) {
            a.setEnabled(false);
            final String text = this.cantUndoText;
            a.putValue("Name", text);
            a.putValue("ShortDescription", text);
        }
        a = (javax.swing.Action)RTextArea.getAction(4);
        if (this.canRedo()) {
            a.setEnabled(true);
            final String text = this.getRedoPresentationName();
            a.putValue("Name", text);
            a.putValue("ShortDescription", text);
        }
        else if (a.isEnabled()) {
            a.setEnabled(false);
            final String text = this.cantRedoText;
            a.putValue("Name", text);
            a.putValue("ShortDescription", text);
        }
    }
    
    class RCompoundEdit extends CompoundEdit
    {
        @Override
        public String getUndoPresentationName() {
            return UIManager.getString("AbstractUndoableEdit.undoText");
        }
        
        @Override
        public String getRedoPresentationName() {
            return UIManager.getString("AbstractUndoableEdit.redoText");
        }
        
        @Override
        public boolean isInProgress() {
            return false;
        }
        
        @Override
        public void undo() {
            if (RUndoManager.this.compoundEdit != null) {
                RUndoManager.this.compoundEdit.end();
            }
            super.undo();
            RUndoManager.this.compoundEdit = null;
        }
    }
}
