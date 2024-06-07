//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class NumberLiteral extends AstNode
{
    private String value;
    private double number;
    private DecoratorNode decoratorNode;
    
    public NumberLiteral() {
        this.decoratorNode = null;
        this.type = 41;
    }
    
    public NumberLiteral(final int pos) {
        super(pos);
        this.decoratorNode = null;
        this.type = 41;
    }
    
    public NumberLiteral(final int pos, final int len) {
        super(pos, len);
        this.decoratorNode = null;
        this.type = 41;
    }
    
    public NumberLiteral(final int pos, final String value) {
        super(pos);
        this.decoratorNode = null;
        this.type = 41;
        this.setValue(value);
        this.setLength(value.length());
    }
    
    public NumberLiteral(final int pos, final String value, final double number) {
        this(pos, value);
        this.setDouble(number);
    }
    
    public NumberLiteral(final double number) {
        this.decoratorNode = null;
        this.type = 41;
        this.setDouble(number);
        this.setValue(Double.toString(number));
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.assertNotNull((Object)value);
        this.value = value;
    }
    
    public double getNumber() {
        return this.number;
    }
    
    public void setNumber(final double value) {
        this.number = value;
    }
    
    public String toSource(final int depth) {
        return this.makeIndent(depth) + ((this.value == null) ? "<null>" : this.value);
    }
    
    public void visit(final NodeVisitor v) {
        v.visit((AstNode)this);
    }
    
    public DecoratorNode getDecoratorNode() {
        return this.decoratorNode;
    }
    
    public void setDecoratorNode(final DecoratorNode decoratorNode) {
        this.decoratorNode = decoratorNode;
    }
}
