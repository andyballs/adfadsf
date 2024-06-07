//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ThrowStatement extends AstNode
{
    private AstNode expression;
    
    public ThrowStatement() {
        this.type = 53;
    }
    
    public ThrowStatement(final int pos) {
        super(pos);
        this.type = 53;
    }
    
    public ThrowStatement(final int pos, final int len) {
        super(pos, len);
        this.type = 53;
    }
    
    public ThrowStatement(final AstNode expr) {
        this.type = 53;
        this.setExpression(expr);
    }
    
    public ThrowStatement(final int pos, final AstNode expr) {
        super(pos, expr.getLength());
        this.type = 53;
        this.setExpression(expr);
    }
    
    public ThrowStatement(final int pos, final int len, final AstNode expr) {
        super(pos, len);
        this.type = 53;
        this.setExpression(expr);
    }
    
    public AstNode getExpression() {
        return this.expression;
    }
    
    public void setExpression(final AstNode expression) {
        this.assertNotNull((Object)expression);
        (this.expression = expression).setParent((AstNode)this);
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("throw");
        sb.append(" ");
        sb.append(this.expression.toSource(0));
        sb.append(";\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.expression.visit(v);
        }
    }
}
