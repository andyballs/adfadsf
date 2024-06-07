//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ObjectProperty extends InfixExpression
{
    private AstNode defaultValue;
    private AstNode spread;
    
    public void setDefaultValue(final AstNode node) {
        this.defaultValue = node;
    }
    
    public AstNode getDefaultValue() {
        return this.defaultValue;
    }
    
    public void setSpread(final AstNode node) {
        this.spread = node;
    }
    
    public AstNode getSpread() {
        return this.spread;
    }
    
    public void setNodeType(final int nodeType) {
        if (nodeType != 104 && nodeType != 156 && nodeType != 157 && nodeType != 168) {
            throw new IllegalArgumentException("invalid node type: " + nodeType);
        }
        this.setType(nodeType);
    }
    
    public ObjectProperty() {
        this.spread = null;
        this.type = 104;
    }
    
    public ObjectProperty(final int pos) {
        super(pos);
        this.spread = null;
        this.type = 104;
    }
    
    public ObjectProperty(final int pos, final int len) {
        super(pos, len);
        this.spread = null;
        this.type = 104;
    }
    
    public void setIsGetterMethod() {
        this.type = 156;
    }
    
    public boolean isGetterMethod() {
        return this.type == 156;
    }
    
    public void setIsSetterMethod() {
        this.type = 157;
    }
    
    public boolean isSetterMethod() {
        return this.type == 157;
    }
    
    public void setIsNormalMethod() {
        this.type = 168;
    }
    
    public boolean isNormalMethod() {
        return this.type == 168;
    }
    
    public boolean isMethod() {
        return this.isGetterMethod() || this.isSetterMethod() || this.isNormalMethod();
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(this.makeIndent(depth + 1));
        if (this.isGetterMethod()) {
            sb.append("get ");
        }
        else if (this.isSetterMethod()) {
            sb.append("set ");
        }
        sb.append(this.left.toSource((this.getType() == 104) ? 0 : depth));
        if (this.type == 104) {
            sb.append(": ");
        }
        sb.append(this.right.toSource((this.getType() == 104) ? 0 : (depth + 1)));
        return sb.toString();
    }
}
