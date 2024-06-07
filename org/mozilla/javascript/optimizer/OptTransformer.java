//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import java.util.*;
import org.mozilla.javascript.ast.*;
import org.mozilla.javascript.*;

class OptTransformer extends NodeTransformer
{
    private Map<String, OptFunctionNode> possibleDirectCalls;
    private ObjArray directCallTargets;
    
    OptTransformer(final Map<String, OptFunctionNode> possibleDirectCalls, final ObjArray directCallTargets) {
        this.possibleDirectCalls = possibleDirectCalls;
        this.directCallTargets = directCallTargets;
    }
    
    protected void visitNew(final Node node, final ScriptNode tree) {
        this.detectDirectCall(node, tree);
        super.visitNew(node, tree);
    }
    
    protected void visitCall(final Node node, final ScriptNode tree) {
        this.detectDirectCall(node, tree);
        super.visitCall(node, tree);
    }
    
    private void detectDirectCall(final Node node, final ScriptNode tree) {
        if (tree.getType() == 114) {
            final Node left = node.getFirstChild();
            int argCount = 0;
            for (Node arg = left.getNext(); arg != null; arg = arg.getNext(), ++argCount) {}
            if (argCount == 0) {
                OptFunctionNode.get(tree).itsContainsCalls0 = true;
            }
            if (this.possibleDirectCalls != null) {
                String targetName = null;
                if (left.getType() == 40) {
                    targetName = left.getString();
                }
                else if (left.getType() == 34) {
                    targetName = left.getFirstChild().getNext().getString();
                }
                else if (left.getType() == 35) {
                    throw Kit.codeBug();
                }
                if (targetName != null) {
                    final OptFunctionNode ofn = this.possibleDirectCalls.get(targetName);
                    if (ofn != null && argCount == ofn.fnode.getParamCount() && !ofn.fnode.requiresActivation() && argCount <= 32) {
                        node.putProp(9, (Object)ofn);
                        if (!ofn.isTargetOfDirectCall()) {
                            final int index = this.directCallTargets.size();
                            this.directCallTargets.add((Object)ofn);
                            ofn.setDirectTargetIndex(index);
                        }
                    }
                }
            }
        }
    }
}
