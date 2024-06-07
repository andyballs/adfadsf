//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class Yield extends AstNode
{
    private AstNode value;
    
    public Yield() {
        this.type = 76;
    }
    
    public Yield(final int pos) {
        super(pos);
        this.type = 76;
    }
    
    public Yield(final int pos, final int len) {
        super(pos, len);
        this.type = 76;
    }
    
    public Yield(final int pos, final int len, final AstNode value) {
        super(pos, len);
        this.type = 76;
        this.setValue(value);
    }
    
    public AstNode getValue() {
        return this.value;
    }
    
    public void setValue(final AstNode expr) {
        this.value = expr;
        if (expr != null) {
            expr.setParent((AstNode)this);
        }
    }
    
    public String toSource(final int depth) {
        return (this.value == null) ? "yield" : ("yield " + this.value.toSource(0));
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this) && this.value != null) {
            this.value.visit(v);
        }
    }
}
