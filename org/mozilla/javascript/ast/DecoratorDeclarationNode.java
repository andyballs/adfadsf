//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class DecoratorDeclarationNode extends FunctionNode
{
    private List<DecoratorNode> decoratorNodes;
    
    public DecoratorDeclarationNode() {
        this.decoratorNodes = new ArrayList<DecoratorNode>();
        this.type = 135;
        this.putProp(33, (Object)true);
        this.setRequiresActivation();
    }
    
    public List<DecoratorNode> getDecoratorNodes() {
        return this.decoratorNodes;
    }
    
    public void setDecoratorNodes(final List<DecoratorNode> decoratorNodes) {
        this.decoratorNodes = decoratorNodes;
    }
    
    public void addDecoratorNode(final DecoratorNode node) {
        this.decoratorNodes.add(node);
    }
}
