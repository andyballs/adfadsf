//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ConditionalExpression extends AstNode
{
    private AstNode testExpression;
    private AstNode trueExpression;
    private AstNode falseExpression;
    private int questionMarkPosition;
    private int colonPosition;
    
    public ConditionalExpression() {
        this.questionMarkPosition = -1;
        this.colonPosition = -1;
        this.type = 103;
    }
    
    public ConditionalExpression(final int pos) {
        super(pos);
        this.questionMarkPosition = -1;
        this.colonPosition = -1;
        this.type = 103;
    }
    
    public ConditionalExpression(final int pos, final int len) {
        super(pos, len);
        this.questionMarkPosition = -1;
        this.colonPosition = -1;
        this.type = 103;
    }
    
    public AstNode getTestExpression() {
        return this.testExpression;
    }
    
    public void setTestExpression(final AstNode testExpression) {
        this.assertNotNull((Object)testExpression);
        (this.testExpression = testExpression).setParent((AstNode)this);
    }
    
    public AstNode getTrueExpression() {
        return this.trueExpression;
    }
    
    public void setTrueExpression(final AstNode trueExpression) {
        this.assertNotNull((Object)trueExpression);
        (this.trueExpression = trueExpression).setParent((AstNode)this);
    }
    
    public AstNode getFalseExpression() {
        return this.falseExpression;
    }
    
    public void setFalseExpression(final AstNode falseExpression) {
        this.assertNotNull((Object)falseExpression);
        (this.falseExpression = falseExpression).setParent((AstNode)this);
    }
    
    public int getQuestionMarkPosition() {
        return this.questionMarkPosition;
    }
    
    public void setQuestionMarkPosition(final int questionMarkPosition) {
        this.questionMarkPosition = questionMarkPosition;
    }
    
    public int getColonPosition() {
        return this.colonPosition;
    }
    
    public void setColonPosition(final int colonPosition) {
        this.colonPosition = colonPosition;
    }
    
    public boolean hasSideEffects() {
        if (this.testExpression == null || this.trueExpression == null || this.falseExpression == null) {
            codeBug();
        }
        return this.trueExpression.hasSideEffects() && this.falseExpression.hasSideEffects();
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.testExpression.toSource(depth));
        sb.append(" ? ");
        sb.append(this.trueExpression.toSource(0));
        sb.append(" : ");
        sb.append(this.falseExpression.toSource(0));
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.testExpression.visit(v);
            this.trueExpression.visit(v);
            this.falseExpression.visit(v);
        }
    }
}
