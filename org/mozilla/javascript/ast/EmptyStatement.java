//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class EmptyStatement extends AstNode
{
    public EmptyStatement() {
        this.type = 138;
    }
    
    public EmptyStatement(final int pos) {
        super(pos);
        this.type = 138;
    }
    
    public EmptyStatement(final int pos, final int len) {
        super(pos, len);
        this.type = 138;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth)).append(";\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
}
