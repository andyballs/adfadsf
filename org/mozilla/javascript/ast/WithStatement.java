//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class WithStatement extends AstNode
{
    private AstNode expression;
    private AstNode statement;
    private int lp;
    private int rp;
    
    public WithStatement() {
        this.lp = -1;
        this.rp = -1;
        this.type = 132;
    }
    
    public WithStatement(final int pos) {
        super(pos);
        this.lp = -1;
        this.rp = -1;
        this.type = 132;
    }
    
    public WithStatement(final int pos, final int len) {
        super(pos, len);
        this.lp = -1;
        this.rp = -1;
        this.type = 132;
    }
    
    public AstNode getExpression() {
        return this.expression;
    }
    
    public void setExpression(final AstNode expression) {
        this.assertNotNull((Object)expression);
        (this.expression = expression).setParent((AstNode)this);
    }
    
    public AstNode getStatement() {
        return this.statement;
    }
    
    public void setStatement(final AstNode statement) {
        this.assertNotNull((Object)statement);
        (this.statement = statement).setParent((AstNode)this);
    }
    
    public int getLp() {
        return this.lp;
    }
    
    public void setLp(final int lp) {
        this.lp = lp;
    }
    
    public int getRp() {
        return this.rp;
    }
    
    public void setRp(final int rp) {
        this.rp = rp;
    }
    
    public void setParens(final int lp, final int rp) {
        this.lp = lp;
        this.rp = rp;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("with (");
        sb.append(this.expression.toSource(0));
        sb.append(") ");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth + 1));
        }
        if (this.statement.getType() == 139) {
            if (this.getInlineComment() != null) {
                sb.append("\n");
            }
            sb.append(this.statement.toSource(depth).trim());
            sb.append("\n");
        }
        else {
            sb.append("\n").append(this.statement.toSource(depth + 1));
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.expression.visit(v);
            this.statement.visit(v);
        }
    }
}
