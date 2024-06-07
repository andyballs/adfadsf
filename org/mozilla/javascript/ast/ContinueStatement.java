//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ContinueStatement extends Jump
{
    private Name label;
    private Loop target;
    
    public ContinueStatement() {
        this.type = 130;
    }
    
    public ContinueStatement(final int pos) {
        this(pos, -1);
    }
    
    public ContinueStatement(final int pos, final int len) {
        this.type = 130;
        this.position = pos;
        this.length = len;
    }
    
    public ContinueStatement(final Name label) {
        this.type = 130;
        this.setLabel(label);
    }
    
    public ContinueStatement(final int pos, final Name label) {
        this(pos);
        this.setLabel(label);
    }
    
    public ContinueStatement(final int pos, final int len, final Name label) {
        this(pos, len);
        this.setLabel(label);
    }
    
    public Loop getTarget() {
        return this.target;
    }
    
    public void setTarget(final Loop target) {
        this.assertNotNull((Object)target);
        this.setJumpStatement(this.target = target);
    }
    
    public Name getLabel() {
        return this.label;
    }
    
    public void setLabel(final Name label) {
        this.label = label;
        if (label != null) {
            label.setParent((AstNode)this);
        }
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("continue");
        if (this.label != null) {
            sb.append(" ");
            sb.append(this.label.toSource(0));
        }
        sb.append(";\n");
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this) && this.label != null) {
            this.label.visit(v);
        }
    }
}
