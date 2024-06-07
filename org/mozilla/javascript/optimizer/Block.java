//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.ast.*;
import java.util.*;
import org.mozilla.javascript.*;

class Block
{
    private Block[] itsSuccessors;
    private Block[] itsPredecessors;
    private int itsStartNodeIndex;
    private int itsEndNodeIndex;
    private int itsBlockID;
    private BitSet itsLiveOnEntrySet;
    private BitSet itsLiveOnExitSet;
    private BitSet itsUseBeforeDefSet;
    private BitSet itsNotDefSet;
    static final boolean DEBUG = false;
    private static int debug_blockCount;
    
    Block(final int startNodeIndex, final int endNodeIndex) {
        this.itsStartNodeIndex = startNodeIndex;
        this.itsEndNodeIndex = endNodeIndex;
    }
    
    static void runFlowAnalyzes(final OptFunctionNode fn, final Node[] statementNodes) {
        final int paramCount = fn.fnode.getParamCount();
        final int varCount = fn.fnode.getParamAndVarCount();
        final int[] varTypes = new int[varCount];
        for (int i = 0; i != paramCount; ++i) {
            varTypes[i] = 3;
        }
        for (int i = paramCount; i != varCount; ++i) {
            varTypes[i] = 0;
        }
        final Block[] theBlocks = buildBlocks(statementNodes);
        reachingDefDataFlow(fn, statementNodes, theBlocks, varTypes);
        typeFlow(fn, statementNodes, theBlocks, varTypes);
    }
    
    private static Block[] buildBlocks(final Node[] statementNodes) {
        final Map<Node, FatBlock> theTargetBlocks = new HashMap<Node, FatBlock>();
        final ObjArray theBlocks = new ObjArray();
        int beginNodeIndex = 0;
        for (int i = 0; i < statementNodes.length; ++i) {
            switch (statementNodes[i].getType()) {
                case 141: {
                    if (i != beginNodeIndex) {
                        final FatBlock fb = newFatBlock(beginNodeIndex, i - 1);
                        if (statementNodes[beginNodeIndex].getType() == 141) {
                            theTargetBlocks.put(statementNodes[beginNodeIndex], fb);
                        }
                        theBlocks.add((Object)fb);
                        beginNodeIndex = i;
                        break;
                    }
                    break;
                }
                case 5:
                case 6:
                case 7: {
                    final FatBlock fb = newFatBlock(beginNodeIndex, i);
                    if (statementNodes[beginNodeIndex].getType() == 141) {
                        theTargetBlocks.put(statementNodes[beginNodeIndex], fb);
                    }
                    theBlocks.add((Object)fb);
                    beginNodeIndex = i + 1;
                    break;
                }
            }
        }
        if (beginNodeIndex != statementNodes.length) {
            final FatBlock fb2 = newFatBlock(beginNodeIndex, statementNodes.length - 1);
            if (statementNodes[beginNodeIndex].getType() == 141) {
                theTargetBlocks.put(statementNodes[beginNodeIndex], fb2);
            }
            theBlocks.add((Object)fb2);
        }
        for (int i = 0; i < theBlocks.size(); ++i) {
            final FatBlock fb = (FatBlock)theBlocks.get(i);
            final Node blockEndNode = statementNodes[fb.realBlock.itsEndNodeIndex];
            final int blockEndNodeType = blockEndNode.getType();
            if (blockEndNodeType != 5 && i < theBlocks.size() - 1) {
                final FatBlock fallThruTarget = (FatBlock)theBlocks.get(i + 1);
                fb.addSuccessor(fallThruTarget);
                fallThruTarget.addPredecessor(fb);
            }
            if (blockEndNodeType == 7 || blockEndNodeType == 6 || blockEndNodeType == 5) {
                final Node target = ((Jump)blockEndNode).target;
                final FatBlock branchTargetBlock = theTargetBlocks.get(target);
                target.putProp(6, (Object)branchTargetBlock.realBlock);
                fb.addSuccessor(branchTargetBlock);
                branchTargetBlock.addPredecessor(fb);
            }
        }
        final Block[] result = new Block[theBlocks.size()];
        for (int j = 0; j < theBlocks.size(); ++j) {
            final FatBlock fb3 = (FatBlock)theBlocks.get(j);
            final Block b = fb3.realBlock;
            b.itsSuccessors = fb3.getSuccessors();
            b.itsPredecessors = fb3.getPredecessors();
            result[b.itsBlockID = j] = b;
        }
        return result;
    }
    
    private static FatBlock newFatBlock(final int startNodeIndex, final int endNodeIndex) {
        final FatBlock fb = new FatBlock();
        fb.realBlock = new Block(startNodeIndex, endNodeIndex);
        return fb;
    }
    
    private static String toString(final Block[] blockList, final Node[] statementNodes) {
        return null;
    }
    
    private static void reachingDefDataFlow(final OptFunctionNode fn, final Node[] statementNodes, final Block[] theBlocks, final int[] varTypes) {
        for (int i = 0; i < theBlocks.length; ++i) {
            theBlocks[i].initLiveOnEntrySets(fn, statementNodes);
        }
        final boolean[] visit = new boolean[theBlocks.length];
        final boolean[] doneOnce = new boolean[theBlocks.length];
        int vIndex = theBlocks.length - 1;
        boolean needRescan = false;
        visit[vIndex] = true;
        while (true) {
            if (visit[vIndex] || !doneOnce[vIndex]) {
                doneOnce[vIndex] = true;
                visit[vIndex] = false;
                if (theBlocks[vIndex].doReachedUseDataFlow()) {
                    final Block[] pred = theBlocks[vIndex].itsPredecessors;
                    if (pred != null) {
                        for (int j = 0; j < pred.length; ++j) {
                            final int index = pred[j].itsBlockID;
                            visit[index] = true;
                            needRescan |= (index > vIndex);
                        }
                    }
                }
            }
            if (vIndex == 0) {
                if (!needRescan) {
                    break;
                }
                vIndex = theBlocks.length - 1;
                needRescan = false;
            }
            else {
                --vIndex;
            }
        }
        theBlocks[0].markAnyTypeVariables(varTypes);
    }
    
    private static void typeFlow(final OptFunctionNode fn, final Node[] statementNodes, final Block[] theBlocks, final int[] varTypes) {
        final boolean[] visit = new boolean[theBlocks.length];
        final boolean[] doneOnce = new boolean[theBlocks.length];
        int vIndex = 0;
        boolean needRescan = false;
        visit[vIndex] = true;
        while (true) {
            if (visit[vIndex] || !doneOnce[vIndex]) {
                doneOnce[vIndex] = true;
                visit[vIndex] = false;
                if (theBlocks[vIndex].doTypeFlow(fn, statementNodes, varTypes)) {
                    final Block[] succ = theBlocks[vIndex].itsSuccessors;
                    if (succ != null) {
                        for (int i = 0; i < succ.length; ++i) {
                            final int index = succ[i].itsBlockID;
                            visit[index] = true;
                            needRescan |= (index < vIndex);
                        }
                    }
                }
            }
            if (vIndex == theBlocks.length - 1) {
                if (!needRescan) {
                    break;
                }
                vIndex = 0;
                needRescan = false;
            }
            else {
                ++vIndex;
            }
        }
    }
    
    private static boolean assignType(final int[] varTypes, final int index, final int type) {
        final int n;
        final int prev = n = varTypes[index];
        final int n2 = varTypes[index] | type;
        varTypes[index] = n2;
        return n != n2;
    }
    
    private void markAnyTypeVariables(final int[] varTypes) {
        for (int i = 0; i != varTypes.length; ++i) {
            if (this.itsLiveOnEntrySet.get(i)) {
                assignType(varTypes, i, 3);
            }
        }
    }
    
    private void lookForVariableAccess(final OptFunctionNode fn, final Node n) {
        switch (n.getType()) {
            case 147: {
                final int varIndex = fn.fnode.getIndexForNameNode(n);
                if (varIndex > -1 && !this.itsNotDefSet.get(varIndex)) {
                    this.itsUseBeforeDefSet.set(varIndex);
                }
                break;
            }
            case 107:
            case 108: {
                final Node child = n.getFirstChild();
                if (child.getType() == 58) {
                    final int varIndex2 = fn.getVarIndex(child);
                    if (!this.itsNotDefSet.get(varIndex2)) {
                        this.itsUseBeforeDefSet.set(varIndex2);
                    }
                    this.itsNotDefSet.set(varIndex2);
                }
                else {
                    this.lookForVariableAccess(fn, child);
                }
                break;
            }
            case 59:
            case 161: {
                final Node lhs = n.getFirstChild();
                final Node rhs = lhs.getNext();
                this.lookForVariableAccess(fn, rhs);
                this.itsNotDefSet.set(fn.getVarIndex(n));
                break;
            }
            case 58: {
                final int varIndex = fn.getVarIndex(n);
                if (!this.itsNotDefSet.get(varIndex)) {
                    this.itsUseBeforeDefSet.set(varIndex);
                }
                break;
            }
            default: {
                for (Node child = n.getFirstChild(); child != null; child = child.getNext()) {
                    this.lookForVariableAccess(fn, child);
                }
                break;
            }
        }
    }
    
    private void initLiveOnEntrySets(final OptFunctionNode fn, final Node[] statementNodes) {
        final int listLength = fn.getVarCount();
        this.itsUseBeforeDefSet = new BitSet(listLength);
        this.itsNotDefSet = new BitSet(listLength);
        this.itsLiveOnEntrySet = new BitSet(listLength);
        this.itsLiveOnExitSet = new BitSet(listLength);
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; ++i) {
            final Node n = statementNodes[i];
            this.lookForVariableAccess(fn, n);
        }
        this.itsNotDefSet.flip(0, listLength);
    }
    
    private boolean doReachedUseDataFlow() {
        this.itsLiveOnExitSet.clear();
        if (this.itsSuccessors != null) {
            for (int i = 0; i < this.itsSuccessors.length; ++i) {
                this.itsLiveOnExitSet.or(this.itsSuccessors[i].itsLiveOnEntrySet);
            }
        }
        return updateEntrySet(this.itsLiveOnEntrySet, this.itsLiveOnExitSet, this.itsUseBeforeDefSet, this.itsNotDefSet);
    }
    
    private static boolean updateEntrySet(final BitSet entrySet, final BitSet exitSet, final BitSet useBeforeDef, final BitSet notDef) {
        final int card = entrySet.cardinality();
        entrySet.or(exitSet);
        entrySet.and(notDef);
        entrySet.or(useBeforeDef);
        return entrySet.cardinality() != card;
    }
    
    private static int findExpressionType(final OptFunctionNode fn, final Node n, final int[] varTypes) {
        switch (n.getType()) {
            case 41: {
                return 1;
            }
            case 31:
            case 39:
            case 74: {
                return 3;
            }
            case 34:
            case 37:
            case 40:
            case 46: {
                return 3;
            }
            case 58: {
                return varTypes[fn.getVarIndex(n)];
            }
            case 9:
            case 10:
            case 11:
            case 18:
            case 19:
            case 20:
            case 22:
            case 23:
            case 24:
            case 25:
            case 28:
            case 29:
            case 30:
            case 107:
            case 108: {
                return 1;
            }
            case 136: {
                return 3;
            }
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 27:
            case 32:
            case 47:
            case 48:
            case 49:
            case 50:
            case 55:
            case 56:
            case 73: {
                return 3;
            }
            case 33:
            case 42:
            case 147: {
                return 3;
            }
            case 45:
            case 51:
            case 69:
            case 70:
            case 162: {
                return 3;
            }
            case 21: {
                final Node child = n.getFirstChild();
                final int lType = findExpressionType(fn, child, varTypes);
                final int rType = findExpressionType(fn, child.getNext(), varTypes);
                return lType | rType;
            }
            case 103: {
                final Node ifTrue = n.getFirstChild().getNext();
                final Node ifFalse = ifTrue.getNext();
                final int ifTrueType = findExpressionType(fn, ifTrue, varTypes);
                final int ifFalseType = findExpressionType(fn, ifFalse, varTypes);
                return ifTrueType | ifFalseType;
            }
            case 8:
            case 36:
            case 38:
            case 59:
            case 86:
            case 161: {
                return findExpressionType(fn, n.getLastChild(), varTypes);
            }
            case 105:
            case 106: {
                final Node child = n.getFirstChild();
                final int lType = findExpressionType(fn, child, varTypes);
                final int rType = findExpressionType(fn, child.getNext(), varTypes);
                return lType | rType;
            }
            default: {
                return 3;
            }
        }
    }
    
    private static boolean findDefPoints(final OptFunctionNode fn, final Node n, final int[] varTypes) {
        boolean result = false;
        Node next;
        Node first;
        for (first = (next = n.getFirstChild()); next != null; next = next.getNext()) {
            result |= findDefPoints(fn, next, varTypes);
        }
        switch (n.getType()) {
            case 107:
            case 108: {
                if (first.getType() == 58) {
                    final int i = fn.getVarIndex(first);
                    if (!fn.fnode.getParamAndVarConst()[i]) {
                        result |= assignType(varTypes, i, 1);
                    }
                    break;
                }
                break;
            }
            case 59:
            case 161: {
                final Node rValue = first.getNext();
                final int theType = findExpressionType(fn, rValue, varTypes);
                final int j = fn.getVarIndex(n);
                if (n.getType() != 59 || !fn.fnode.getParamAndVarConst()[j]) {
                    result |= assignType(varTypes, j, theType);
                    break;
                }
                break;
            }
        }
        return result;
    }
    
    private boolean doTypeFlow(final OptFunctionNode fn, final Node[] statementNodes, final int[] varTypes) {
        boolean changed = false;
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; ++i) {
            final Node n = statementNodes[i];
            if (n != null) {
                changed |= findDefPoints(fn, n, varTypes);
            }
        }
        return changed;
    }
    
    private void printLiveOnEntrySet(final OptFunctionNode fn) {
    }
    
    private static class FatBlock
    {
        private ObjToIntMap successors;
        private ObjToIntMap predecessors;
        Block realBlock;
        
        private FatBlock() {
            this.successors = new ObjToIntMap();
            this.predecessors = new ObjToIntMap();
        }
        
        private static Block[] reduceToArray(final ObjToIntMap map) {
            Block[] result = null;
            if (!map.isEmpty()) {
                result = new Block[map.size()];
                int i = 0;
                final ObjToIntMap.Iterator iter = map.newIterator();
                iter.start();
                while (!iter.done()) {
                    final FatBlock fb = (FatBlock)iter.getKey();
                    result[i++] = fb.realBlock;
                    iter.next();
                }
            }
            return result;
        }
        
        void addSuccessor(final FatBlock b) {
            this.successors.put((Object)b, 0);
        }
        
        void addPredecessor(final FatBlock b) {
            this.predecessors.put((Object)b, 0);
        }
        
        Block[] getSuccessors() {
            return reduceToArray(this.successors);
        }
        
        Block[] getPredecessors() {
            return reduceToArray(this.predecessors);
        }
    }
}
