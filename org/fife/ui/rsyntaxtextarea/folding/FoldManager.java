//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.folding;

import java.beans.*;
import java.util.*;

public interface FoldManager
{
    public static final String PROPERTY_FOLDS_UPDATED = "FoldsUpdated";
    
    void addPropertyChangeListener(final PropertyChangeListener p0);
    
    void clear();
    
    boolean ensureOffsetNotInClosedFold(final int p0);
    
    Fold getDeepestFoldContaining(final int p0);
    
    Fold getDeepestOpenFoldContaining(final int p0);
    
    Fold getFold(final int p0);
    
    int getFoldCount();
    
    Fold getFoldForLine(final int p0);
    
    int getHiddenLineCount();
    
    int getHiddenLineCountAbove(final int p0);
    
    int getHiddenLineCountAbove(final int p0, final boolean p1);
    
    int getLastVisibleLine();
    
    int getVisibleLineAbove(final int p0);
    
    int getVisibleLineBelow(final int p0);
    
    boolean isCodeFoldingEnabled();
    
    boolean isCodeFoldingSupportedAndEnabled();
    
    boolean isFoldStartLine(final int p0);
    
    boolean isLineHidden(final int p0);
    
    void removePropertyChangeListener(final PropertyChangeListener p0);
    
    void reparse();
    
    void setCodeFoldingEnabled(final boolean p0);
    
    void setFolds(final List<Fold> p0);
}
