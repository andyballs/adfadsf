//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class EmptyExpression extends AstNode
{
    public EmptyExpression() {
        this.type = 138;
    }
    
    public EmptyExpression(final int pos) {
        super(pos);
        this.type = 138;
    }
    
    public EmptyExpression(final int pos, final int len) {
        super(pos, len);
        this.type = 138;
    }
    
    public String toSource(final int depth) {
        return this.makeIndent(depth);
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
}
