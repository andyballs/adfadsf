//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.ast.*;
import org.mozilla.javascript.*;

public final class OptFunctionNode
{
    public final FunctionNode fnode;
    private boolean[] numberVarFlags;
    private int directTargetIndex;
    private boolean itsParameterNumberContext;
    boolean itsContainsCalls0;
    boolean itsContainsCalls1;
    
    OptFunctionNode(final FunctionNode fnode) {
        this.directTargetIndex = -1;
        (this.fnode = fnode).setCompilerData((Object)this);
    }
    
    public static OptFunctionNode get(final ScriptNode scriptOrFn, final int i) {
        final FunctionNode fnode = scriptOrFn.getFunctionNode(i);
        return (OptFunctionNode)fnode.getCompilerData();
    }
    
    public static OptFunctionNode get(final ScriptNode scriptOrFn) {
        return (OptFunctionNode)scriptOrFn.getCompilerData();
    }
    
    public boolean isTargetOfDirectCall() {
        return this.directTargetIndex >= 0;
    }
    
    public int getDirectTargetIndex() {
        return this.directTargetIndex;
    }
    
    void setDirectTargetIndex(final int directTargetIndex) {
        if (directTargetIndex < 0 || this.directTargetIndex >= 0) {
            Kit.codeBug();
        }
        this.directTargetIndex = directTargetIndex;
    }
    
    void setParameterNumberContext(final boolean b) {
        this.itsParameterNumberContext = b;
    }
    
    public boolean getParameterNumberContext() {
        return this.itsParameterNumberContext;
    }
    
    public int getVarCount() {
        return this.fnode.getParamAndVarCount();
    }
    
    public boolean isParameter(final int varIndex) {
        return varIndex < this.fnode.getParamCount();
    }
    
    public boolean isNumberVar(int varIndex) {
        varIndex -= this.fnode.getParamCount();
        return varIndex >= 0 && this.numberVarFlags != null && this.numberVarFlags[varIndex];
    }
    
    void setIsNumberVar(int varIndex) {
        varIndex -= this.fnode.getParamCount();
        if (varIndex < 0) {
            Kit.codeBug();
        }
        if (this.numberVarFlags == null) {
            final int size = this.fnode.getParamAndVarCount() - this.fnode.getParamCount();
            this.numberVarFlags = new boolean[size];
        }
        this.numberVarFlags[varIndex] = true;
    }
    
    public int getVarIndex(final Node n) {
        int index = n.getIntProp(7, -1);
        if (index == -1) {
            final int type = n.getType();
            Node node;
            if (type == 58) {
                node = n;
            }
            else {
                if (type != 59 && type != 161) {
                    throw Kit.codeBug();
                }
                node = n.getFirstChild();
            }
            index = this.fnode.getIndexForNameNode(node);
            if (index < 0) {
                throw Kit.codeBug();
            }
            n.putIntProp(7, index);
        }
        return index;
    }
}
