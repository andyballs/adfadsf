//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class BreakStatement extends Jump
{
    private Name breakLabel;
    private AstNode target;
    
    public BreakStatement() {
        this.type = 129;
    }
    
    public BreakStatement(final int pos) {
        this.type = 129;
        this.position = pos;
    }
    
    public BreakStatement(final int pos, final int len) {
        this.type = 129;
        this.position = pos;
        this.length = len;
    }
    
    public Name getBreakLabel() {
        return this.breakLabel;
    }
    
    public void setBreakLabel(final Name label) {
        this.breakLabel = label;
        if (label != null) {
            label.setParent((AstNode)this);
        }
    }
    
    public AstNode getBreakTarget() {
        return this.target;
    }
    
    public void setBreakTarget(final Jump target) {
        this.assertNotNull((Object)target);
        this.setJumpStatement((Jump)(this.target = target));
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("break");
        if (this.breakLabel != null) {
            sb.append(" ");
            sb.append(this.breakLabel.toSource(0));
        }
        sb.append(";\n");
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this) && this.breakLabel != null) {
            this.breakLabel.visit(v);
        }
    }
}
