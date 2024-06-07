//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.ast.*;
import org.mozilla.javascript.*;

class Optimizer
{
    static final int NoType = 0;
    static final int NumberType = 1;
    static final int AnyType = 3;
    private boolean inDirectCallFunction;
    OptFunctionNode theFunction;
    private boolean parameterUsedInNumberContext;
    
    void optimize(final ScriptNode scriptOrFn) {
        for (int functionCount = scriptOrFn.getFunctionCount(), i = 0; i != functionCount; ++i) {
            final OptFunctionNode f = OptFunctionNode.get(scriptOrFn, i);
            this.optimizeFunction(f);
        }
    }
    
    private void optimizeFunction(final OptFunctionNode theFunction) {
        if (theFunction.fnode.requiresActivation()) {
            return;
        }
        this.inDirectCallFunction = theFunction.isTargetOfDirectCall();
        this.theFunction = theFunction;
        final ObjArray statementsArray = new ObjArray();
        buildStatementList_r((Node)theFunction.fnode, statementsArray);
        final Node[] theStatementNodes = new Node[statementsArray.size()];
        statementsArray.toArray((Object[])theStatementNodes);
        Block.runFlowAnalyzes(theFunction, theStatementNodes);
        if (!theFunction.fnode.requiresActivation()) {
            theFunction.setParameterNumberContext(this.parameterUsedInNumberContext = true);
        }
    }
    
    private void markDCPNumberContext(final Node n) {
        if (this.inDirectCallFunction && n.getType() == 58) {
            final int varIndex = this.theFunction.getVarIndex(n);
            if (this.theFunction.isParameter(varIndex)) {
                this.parameterUsedInNumberContext = true;
            }
        }
    }
    
    private boolean convertParameter(final Node n) {
        if (this.inDirectCallFunction && n.getType() == 58) {
            final int varIndex = this.theFunction.getVarIndex(n);
            if (this.theFunction.isParameter(varIndex)) {
                n.removeProp(8);
                return true;
            }
        }
        return false;
    }
    
    private int rewriteForNumberVariables(final Node n, final int desired) {
        switch (n.getType()) {
            case 143: {
                final Node child = n.getFirstChild();
                final int type = this.rewriteForNumberVariables(child, 1);
                if (type == 1) {
                    n.putIntProp(8, 0);
                }
                return 0;
            }
            case 41: {
                n.putIntProp(8, 0);
                return 1;
            }
            case 58: {
                final int varIndex = this.theFunction.getVarIndex(n);
                if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex) && desired == 1) {
                    n.putIntProp(8, 0);
                    return 1;
                }
                if (this.theFunction.isNumberVar(varIndex)) {
                    n.putIntProp(8, 0);
                    return 1;
                }
                return 0;
            }
            case 107:
            case 108: {
                final Node child = n.getFirstChild();
                final int type = this.rewriteForNumberVariables(child, 1);
                if (child.getType() == 58) {
                    if (type == 1 && !this.convertParameter(child)) {
                        n.putIntProp(8, 0);
                        this.markDCPNumberContext(child);
                        return 1;
                    }
                    return 0;
                }
                else {
                    if (child.getType() == 37 || child.getType() == 34) {
                        return type;
                    }
                    return 0;
                }
                break;
            }
            case 59:
            case 161: {
                final Node lChild = n.getFirstChild();
                final Node rChild = lChild.getNext();
                final int rType = this.rewriteForNumberVariables(rChild, 1);
                final int varIndex2 = this.theFunction.getVarIndex(n);
                if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex2)) {
                    if (rType != 1) {
                        return rType;
                    }
                    if (!this.convertParameter(rChild)) {
                        n.putIntProp(8, 0);
                        return 1;
                    }
                    this.markDCPNumberContext(rChild);
                    return 0;
                }
                else {
                    if (this.theFunction.isNumberVar(varIndex2)) {
                        if (rType != 1) {
                            n.removeChild(rChild);
                            n.addChildToBack(new Node(155, rChild));
                        }
                        n.putIntProp(8, 0);
                        this.markDCPNumberContext(rChild);
                        return 1;
                    }
                    if (rType == 1 && !this.convertParameter(rChild)) {
                        n.removeChild(rChild);
                        n.addChildToBack(new Node(154, rChild));
                    }
                    return 0;
                }
                break;
            }
            case 14:
            case 15:
            case 16:
            case 17: {
                final Node lChild = n.getFirstChild();
                final Node rChild = lChild.getNext();
                final int lType = this.rewriteForNumberVariables(lChild, 1);
                final int rType2 = this.rewriteForNumberVariables(rChild, 1);
                this.markDCPNumberContext(lChild);
                this.markDCPNumberContext(rChild);
                if (this.convertParameter(lChild)) {
                    if (this.convertParameter(rChild)) {
                        return 0;
                    }
                    if (rType2 == 1) {
                        n.putIntProp(8, 2);
                    }
                }
                else if (this.convertParameter(rChild)) {
                    if (lType == 1) {
                        n.putIntProp(8, 1);
                    }
                }
                else if (lType == 1) {
                    if (rType2 == 1) {
                        n.putIntProp(8, 0);
                    }
                    else {
                        n.putIntProp(8, 1);
                    }
                }
                else if (rType2 == 1) {
                    n.putIntProp(8, 2);
                }
                return 0;
            }
            case 21: {
                final Node lChild = n.getFirstChild();
                final Node rChild = lChild.getNext();
                final int lType = this.rewriteForNumberVariables(lChild, 1);
                final int rType2 = this.rewriteForNumberVariables(rChild, 1);
                if (this.convertParameter(lChild)) {
                    if (this.convertParameter(rChild)) {
                        return 0;
                    }
                    if (rType2 == 1) {
                        n.putIntProp(8, 2);
                    }
                }
                else if (this.convertParameter(rChild)) {
                    if (lType == 1) {
                        n.putIntProp(8, 1);
                    }
                }
                else if (lType == 1) {
                    if (rType2 == 1) {
                        n.putIntProp(8, 0);
                        return 1;
                    }
                    n.putIntProp(8, 1);
                }
                else if (rType2 == 1) {
                    n.putIntProp(8, 2);
                }
                return 0;
            }
            case 9:
            case 10:
            case 11:
            case 18:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25: {
                final Node lChild = n.getFirstChild();
                final Node rChild = lChild.getNext();
                final int lType = this.rewriteForNumberVariables(lChild, 1);
                final int rType2 = this.rewriteForNumberVariables(rChild, 1);
                this.markDCPNumberContext(lChild);
                this.markDCPNumberContext(rChild);
                if (lType == 1) {
                    if (rType2 == 1) {
                        n.putIntProp(8, 0);
                        return 1;
                    }
                    if (!this.convertParameter(rChild)) {
                        n.removeChild(rChild);
                        n.addChildToBack(new Node(155, rChild));
                        n.putIntProp(8, 0);
                    }
                    return 1;
                }
                else {
                    if (rType2 == 1) {
                        if (!this.convertParameter(lChild)) {
                            n.removeChild(lChild);
                            n.addChildToFront(new Node(155, lChild));
                            n.putIntProp(8, 0);
                        }
                        return 1;
                    }
                    if (!this.convertParameter(lChild)) {
                        n.removeChild(lChild);
                        n.addChildToFront(new Node(155, lChild));
                    }
                    if (!this.convertParameter(rChild)) {
                        n.removeChild(rChild);
                        n.addChildToBack(new Node(155, rChild));
                    }
                    n.putIntProp(8, 0);
                    return 1;
                }
                break;
            }
            case 38:
            case 150: {
                final Node arrayBase = n.getFirstChild();
                final Node arrayIndex = arrayBase.getNext();
                final Node rValue = arrayIndex.getNext();
                final int baseType = this.rewriteForNumberVariables(arrayBase, 1);
                if (baseType == 1 && !this.convertParameter(arrayBase)) {
                    n.removeChild(arrayBase);
                    n.addChildToFront(new Node(154, arrayBase));
                }
                final int indexType = this.rewriteForNumberVariables(arrayIndex, 1);
                if (indexType == 1 && !this.convertParameter(arrayIndex)) {
                    n.putIntProp(8, 1);
                }
                final int rValueType = this.rewriteForNumberVariables(rValue, 1);
                if (rValueType == 1 && !this.convertParameter(rValue)) {
                    n.removeChild(rValue);
                    n.addChildToBack(new Node(154, rValue));
                }
                return 0;
            }
            case 37: {
                final Node arrayBase = n.getFirstChild();
                final Node arrayIndex = arrayBase.getNext();
                final int baseType2 = this.rewriteForNumberVariables(arrayBase, 1);
                if (baseType2 == 1 && !this.convertParameter(arrayBase)) {
                    n.removeChild(arrayBase);
                    n.addChildToFront(new Node(154, arrayBase));
                }
                final int indexType2 = this.rewriteForNumberVariables(arrayIndex, 1);
                if (indexType2 == 1 && !this.convertParameter(arrayIndex)) {
                    n.putIntProp(8, 2);
                }
                return 0;
            }
            case 39: {
                Node child = n.getFirstChild();
                this.rewriteAsObjectChildren(child, child.getFirstChild());
                child = child.getNext();
                final OptFunctionNode target = (OptFunctionNode)n.getProp(9);
                if (target != null) {
                    while (child != null) {
                        final int type2 = this.rewriteForNumberVariables(child, 1);
                        if (type2 == 1) {
                            this.markDCPNumberContext(child);
                        }
                        child = child.getNext();
                    }
                }
                else {
                    this.rewriteAsObjectChildren(n, child);
                }
                return 0;
            }
            default: {
                this.rewriteAsObjectChildren(n, n.getFirstChild());
                return 0;
            }
        }
    }
    
    private void rewriteAsObjectChildren(final Node n, Node child) {
        while (child != null) {
            final Node nextChild = child.getNext();
            final int type = this.rewriteForNumberVariables(child, 0);
            if (type == 1 && !this.convertParameter(child)) {
                n.removeChild(child);
                final Node nuChild = new Node(154, child);
                if (nextChild == null) {
                    n.addChildToBack(nuChild);
                }
                else {
                    n.addChildBefore(nuChild, nextChild);
                }
            }
            child = nextChild;
        }
    }
    
    private static void buildStatementList_r(final Node node, final ObjArray statements) {
        final int type = node.getType();
        if (type == 139 || type == 151 || type == 142 || type == 114) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNext()) {
                buildStatementList_r(child, statements);
            }
        }
        else {
            statements.add((Object)node);
        }
    }
}
