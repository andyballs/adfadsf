//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class PropertyGet extends InfixExpression
{
    public PropertyGet() {
        this.type = 34;
    }
    
    public PropertyGet(final int pos) {
        super(pos);
        this.type = 34;
    }
    
    public PropertyGet(final int pos, final int len) {
        super(pos, len);
        this.type = 34;
    }
    
    public PropertyGet(final int pos, final int len, final AstNode target, final Name property) {
        super(pos, len, target, (AstNode)property);
        this.type = 34;
    }
    
    public PropertyGet(final AstNode target, final Name property) {
        super(target, (AstNode)property);
        this.type = 34;
    }
    
    public PropertyGet(final AstNode target, final Name property, final int dotPosition) {
        super(34, target, (AstNode)property, dotPosition);
        this.type = 34;
    }
    
    public AstNode getTarget() {
        return this.getLeft();
    }
    
    public void setTarget(final AstNode target) {
        this.setLeft(target);
    }
    
    public Name getProperty() {
        return (Name)this.getRight();
    }
    
    public void setProperty(final Name property) {
        this.setRight((AstNode)property);
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.getLeft().toSource(0));
        sb.append(".");
        sb.append(this.getRight().toSource(0));
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.getTarget().visit(v);
            this.getProperty().visit(v);
        }
    }
}
