//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class UnaryExpression extends AstNode
{
    private AstNode operand;
    private boolean isPostfix;
    
    public UnaryExpression() {
    }
    
    public UnaryExpression(final int pos) {
        super(pos);
    }
    
    public UnaryExpression(final int pos, final int len) {
        super(pos, len);
    }
    
    public UnaryExpression(final int operator, final int operatorPosition, final AstNode operand) {
        this(operator, operatorPosition, operand, false);
    }
    
    public UnaryExpression(final int operator, final int operatorPosition, final AstNode operand, final boolean postFix) {
        this.assertNotNull((Object)operand);
        final int beg = postFix ? operand.getPosition() : operatorPosition;
        final int end = postFix ? (operatorPosition + 2) : (operand.getPosition() + operand.getLength());
        this.setBounds(beg, end);
        this.setOperator(operator);
        this.setOperand(operand);
        this.isPostfix = postFix;
    }
    
    public int getOperator() {
        return this.type;
    }
    
    public void setOperator(final int operator) {
        if (!Token.isValidToken(operator)) {
            throw new IllegalArgumentException("Invalid token: " + operator);
        }
        this.setType(operator);
    }
    
    public AstNode getOperand() {
        return this.operand;
    }
    
    public void setOperand(final AstNode operand) {
        this.assertNotNull((Object)operand);
        (this.operand = operand).setParent((AstNode)this);
    }
    
    public boolean isPostfix() {
        return this.isPostfix;
    }
    
    public boolean isPrefix() {
        return !this.isPostfix;
    }
    
    public void setIsPostfix(final boolean isPostfix) {
        this.isPostfix = isPostfix;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        final int type = this.getType();
        if (!this.isPostfix) {
            sb.append(operatorToString(type));
            if (type == 33 || type == 32 || type == 136) {
                sb.append(" ");
            }
        }
        sb.append(this.operand.toSource());
        if (this.isPostfix) {
            sb.append(operatorToString(type));
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.operand.visit(v);
        }
    }
}
