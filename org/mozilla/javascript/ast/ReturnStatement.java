//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ReturnStatement extends AstNode
{
    private AstNode returnValue;
    
    public ReturnStatement() {
        this.type = 4;
    }
    
    public ReturnStatement(final int pos) {
        super(pos);
        this.type = 4;
    }
    
    public ReturnStatement(final int pos, final int len) {
        super(pos, len);
        this.type = 4;
    }
    
    public ReturnStatement(final int pos, final int len, final AstNode returnValue) {
        super(pos, len);
        this.type = 4;
        this.setReturnValue(returnValue);
    }
    
    public AstNode getReturnValue() {
        return this.returnValue;
    }
    
    public void setReturnValue(final AstNode returnValue) {
        this.returnValue = returnValue;
        if (returnValue != null) {
            returnValue.setParent((AstNode)this);
        }
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("return");
        if (this.returnValue != null) {
            sb.append(" ");
            sb.append(this.returnValue.toSource(0));
        }
        sb.append(";\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this) && this.returnValue != null) {
            this.returnValue.visit(v);
        }
    }
}
