//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class Jump extends AstNode
{
    public Node target;
    private Node target2;
    private Jump jumpNode;
    
    public Jump() {
        this.type = -1;
    }
    
    public Jump(final int nodeType) {
        this.type = nodeType;
    }
    
    public Jump(final int type, final int lineno) {
        this(type);
        this.setLineno(lineno);
    }
    
    public Jump(final int type, final Node child) {
        this(type);
        this.addChildToBack(child);
    }
    
    public Jump(final int type, final Node child, final int lineno) {
        this(type, child);
        this.setLineno(lineno);
    }
    
    public Jump getJumpStatement() {
        if (this.type != 129 && this.type != 130) {
            codeBug();
        }
        return this.jumpNode;
    }
    
    public void setJumpStatement(final Jump jumpStatement) {
        if (this.type != 129 && this.type != 130) {
            codeBug();
        }
        if (jumpStatement == null) {
            codeBug();
        }
        if (this.jumpNode != null) {
            codeBug();
        }
        this.jumpNode = jumpStatement;
    }
    
    public Node getDefault() {
        if (this.type != 123) {
            codeBug();
        }
        return this.target2;
    }
    
    public void setDefault(final Node defaultTarget) {
        if (this.type != 123) {
            codeBug();
        }
        if (defaultTarget.getType() != 141) {
            codeBug();
        }
        if (this.target2 != null) {
            codeBug();
        }
        this.target2 = defaultTarget;
    }
    
    public Node getFinally() {
        if (this.type != 78) {
            codeBug();
        }
        return this.target2;
    }
    
    public void setFinally(final Node finallyTarget) {
        if (this.type != 78) {
            codeBug();
        }
        if (finallyTarget.getType() != 141) {
            codeBug();
        }
        if (this.target2 != null) {
            codeBug();
        }
        this.target2 = finallyTarget;
    }
    
    public Jump getLoop() {
        if (this.type != 140) {
            codeBug();
        }
        return this.jumpNode;
    }
    
    public void setLoop(final Jump loop) {
        if (this.type != 140) {
            codeBug();
        }
        if (loop == null) {
            codeBug();
        }
        if (this.jumpNode != null) {
            codeBug();
        }
        this.jumpNode = loop;
    }
    
    public Node getContinue() {
        if (this.type != 142) {
            codeBug();
        }
        return this.target2;
    }
    
    public void setContinue(final Node continueTarget) {
        if (this.type != 142) {
            codeBug();
        }
        if (continueTarget.getType() != 141) {
            codeBug();
        }
        if (this.target2 != null) {
            codeBug();
        }
        this.target2 = continueTarget;
    }
    
    public void visit(final NodeVisitor visitor) {
        throw new UnsupportedOperationException(this.toString());
    }
    
    public String toSource(final int depth) {
        throw new UnsupportedOperationException(this.toString());
    }
}
