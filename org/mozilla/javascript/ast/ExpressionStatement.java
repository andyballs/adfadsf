//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ExpressionStatement extends AstNode
{
    private AstNode expr;
    
    public void setHasResult() {
        this.type = 144;
    }
    
    public ExpressionStatement() {
        this.type = 143;
    }
    
    public ExpressionStatement(final AstNode expr, final boolean hasResult) {
        this(expr);
        if (hasResult) {
            this.setHasResult();
        }
    }
    
    public ExpressionStatement(final AstNode expr) {
        this(expr.getPosition(), expr.getLength(), expr);
    }
    
    public ExpressionStatement(final int pos, final int len) {
        super(pos, len);
        this.type = 143;
    }
    
    public ExpressionStatement(final int pos, final int len, final AstNode expr) {
        super(pos, len);
        this.type = 143;
        this.setExpression(expr);
    }
    
    public AstNode getExpression() {
        return this.expr;
    }
    
    public void setExpression(final AstNode expression) {
        this.assertNotNull((Object)expression);
        (this.expr = expression).setParent((AstNode)this);
        this.setLineno(expression.getLineno());
    }
    
    public boolean hasSideEffects() {
        return this.type == 144 || this.expr.hasSideEffects();
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.expr.toSource(depth));
        sb.append(";");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth));
        }
        sb.append("\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.expr.visit(v);
        }
    }
}
