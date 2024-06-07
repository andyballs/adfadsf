//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class DoLoop extends Loop
{
    private AstNode condition;
    private int whilePosition;
    
    public DoLoop() {
        this.whilePosition = -1;
        this.type = 127;
    }
    
    public DoLoop(final int pos) {
        super(pos);
        this.whilePosition = -1;
        this.type = 127;
    }
    
    public DoLoop(final int pos, final int len) {
        super(pos, len);
        this.whilePosition = -1;
        this.type = 127;
    }
    
    public AstNode getCondition() {
        return this.condition;
    }
    
    public void setCondition(final AstNode condition) {
        this.assertNotNull((Object)condition);
        (this.condition = condition).setParent((AstNode)this);
    }
    
    public int getWhilePosition() {
        return this.whilePosition;
    }
    
    public void setWhilePosition(final int whilePosition) {
        this.whilePosition = whilePosition;
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("do ");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth + 1)).append("\n");
        }
        sb.append(this.body.toSource(depth).trim());
        sb.append(" while (");
        sb.append(this.condition.toSource(0));
        sb.append(");\n");
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.body.visit(v);
            this.condition.visit(v);
        }
    }
}
