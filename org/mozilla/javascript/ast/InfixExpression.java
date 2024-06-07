//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class InfixExpression extends AstNode
{
    protected AstNode left;
    protected AstNode right;
    protected int operatorPosition;
    
    public InfixExpression() {
        this.operatorPosition = -1;
    }
    
    public InfixExpression(final int pos) {
        super(pos);
        this.operatorPosition = -1;
    }
    
    public InfixExpression(final int pos, final int len) {
        super(pos, len);
        this.operatorPosition = -1;
    }
    
    public InfixExpression(final int pos, final int len, final AstNode left, final AstNode right) {
        super(pos, len);
        this.operatorPosition = -1;
        this.setLeft(left);
        this.setRight(right);
    }
    
    public InfixExpression(final AstNode left, final AstNode right) {
        this.operatorPosition = -1;
        this.setLeftAndRight(left, right);
    }
    
    public InfixExpression(final int operator, final AstNode left, final AstNode right, final int operatorPos) {
        this.operatorPosition = -1;
        this.setType(operator);
        this.setOperatorPosition(operatorPos - left.getPosition());
        this.setLeftAndRight(left, right);
    }
    
    public void setLeftAndRight(final AstNode left, final AstNode right) {
        this.assertNotNull((Object)left);
        this.assertNotNull((Object)right);
        final int beg = left.getPosition();
        final int end = right.getPosition() + right.getLength();
        this.setBounds(beg, end);
        this.setLeft(left);
        this.setRight(right);
    }
    
    public int getOperator() {
        return this.getType();
    }
    
    public void setOperator(final int operator) {
        if (!Token.isValidToken(operator)) {
            throw new IllegalArgumentException("Invalid token: " + operator);
        }
        this.setType(operator);
    }
    
    public AstNode getLeft() {
        return this.left;
    }
    
    public void setLeft(final AstNode left) {
        this.assertNotNull((Object)left);
        this.left = left;
        this.setLineno(left.getLineno());
        left.setParent((AstNode)this);
    }
    
    public AstNode getRight() {
        return this.right;
    }
    
    public void setRight(final AstNode right) {
        this.assertNotNull((Object)right);
        (this.right = right).setParent((AstNode)this);
    }
    
    public int getOperatorPosition() {
        return this.operatorPosition;
    }
    
    public void setOperatorPosition(final int operatorPosition) {
        this.operatorPosition = operatorPosition;
    }
    
    public boolean hasSideEffects() {
        switch (this.getType()) {
            case 86: {
                return this.right != null && this.right.hasSideEffects();
            }
            case 105:
            case 106: {
                return (this.left != null && this.left.hasSideEffects()) || (this.right != null && this.right.hasSideEffects());
            }
            default: {
                return super.hasSideEffects();
            }
        }
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.left.toSource());
        sb.append(" ");
        sb.append(operatorToString(this.getType()));
        sb.append(" ");
        sb.append(this.right.toSource());
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.left.visit(v);
            this.right.visit(v);
        }
    }
}
