//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ErrorNode extends AstNode
{
    private String message;
    
    public ErrorNode() {
        this.type = -1;
    }
    
    public ErrorNode(final int pos) {
        super(pos);
        this.type = -1;
    }
    
    public ErrorNode(final int pos, final int len) {
        super(pos, len);
        this.type = -1;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String toSource(final int depth) {
        return "";
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
}
