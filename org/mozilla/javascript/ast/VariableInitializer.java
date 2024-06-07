//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class VariableInitializer extends AstNode
{
    private AstNode target;
    private AstNode initializer;
    private boolean hasExplicitInitializer;
    
    public void setNodeType(final int nodeType) {
        if (nodeType != 131 && nodeType != 159 && nodeType != 158) {
            throw new IllegalArgumentException("invalid node type");
        }
        this.setType(nodeType);
    }
    
    public VariableInitializer() {
        this.type = 131;
    }
    
    public VariableInitializer(final int pos) {
        super(pos);
        this.type = 131;
    }
    
    public VariableInitializer(final int pos, final int len) {
        super(pos, len);
        this.type = 131;
    }
    
    public boolean isDestructuring() {
        return !(this.target instanceof Name);
    }
    
    public AstNode getTarget() {
        return this.target;
    }
    
    public void setTarget(final AstNode target) {
        if (target == null) {
            throw new IllegalArgumentException("invalid target arg");
        }
        (this.target = target).setParent((AstNode)this);
    }
    
    public AstNode getInitializer() {
        return this.initializer;
    }
    
    public boolean hasExplicitInitializer() {
        return this.hasExplicitInitializer;
    }
    
    public void setInitializer(final AstNode initializer) {
        this.initializer = initializer;
        if (initializer != null) {
            initializer.setParent((AstNode)this);
        }
    }
    
    public void setHasExplicitInitializer() {
        this.hasExplicitInitializer = true;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.target.toSource(0));
        if (this.initializer != null) {
            sb.append(" = ");
            sb.append(this.initializer.toSource(0));
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.target.visit(v);
            if (this.initializer != null) {
                this.initializer.visit(v);
            }
        }
    }
}
