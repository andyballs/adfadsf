//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ParenthesizedExpression extends AstNode
{
    private AstNode expression;
    
    public ParenthesizedExpression() {
        this.type = 84;
    }
    
    public ParenthesizedExpression(final int pos) {
        super(pos);
        this.type = 84;
    }
    
    public ParenthesizedExpression(final int pos, final int len) {
        super(pos, len);
        this.type = 84;
    }
    
    public ParenthesizedExpression(final AstNode expr) {
        this((expr != null) ? expr.getPosition() : 0, (expr != null) ? expr.getLength() : 1, expr);
    }
    
    public ParenthesizedExpression(final int pos, final int len, final AstNode expr) {
        super(pos, len);
        this.type = 84;
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
        return this.makeIndent(depth) + "(" + this.expression.toSource(0) + ")";
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.expression.visit(v);
        }
    }
}
