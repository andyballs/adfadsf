//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class GeneratorExpressionLoop extends ForInLoop
{
    public GeneratorExpressionLoop() {
    }
    
    public GeneratorExpressionLoop(final int pos) {
        super(pos);
    }
    
    public GeneratorExpressionLoop(final int pos, final int len) {
        super(pos, len);
    }
    
    public String toSource(final int depth) {
        return this.makeIndent(depth) + " for (" + this.iterator.toSource(0) + (this.isForOf() ? " of " : " in ") + this.iteratedObject.toSource(0) + ")";
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.iterator.visit(v);
            this.iteratedObject.visit(v);
        }
    }
}
