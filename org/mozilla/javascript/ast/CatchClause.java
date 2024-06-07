//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class CatchClause extends AstNode
{
    private Name varName;
    private Block body;
    private int ifPosition;
    private int lp;
    private int rp;
    
    public CatchClause() {
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 133;
    }
    
    public CatchClause(final int pos) {
        super(pos);
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 133;
    }
    
    public CatchClause(final int pos, final int len) {
        super(pos, len);
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 133;
    }
    
    public Name getVarName() {
        return this.varName;
    }
    
    public void setVarName(final Name varName) {
        this.assertNotNull((Object)varName);
        (this.varName = varName).setParent((AstNode)this);
    }
    
    public Block getBody() {
        return this.body;
    }
    
    public void setBody(final Block body) {
        this.assertNotNull((Object)body);
        (this.body = body).setParent((AstNode)this);
    }
    
    public int getLp() {
        return this.lp;
    }
    
    public void setLp(final int lp) {
        this.lp = lp;
    }
    
    public int getRp() {
        return this.rp;
    }
    
    public void setRp(final int rp) {
        this.rp = rp;
    }
    
    public void setParens(final int lp, final int rp) {
        this.lp = lp;
        this.rp = rp;
    }
    
    public int getIfPosition() {
        return this.ifPosition;
    }
    
    public void setIfPosition(final int ifPosition) {
        this.ifPosition = ifPosition;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("catch (");
        sb.append(this.varName.toSource(0));
        sb.append(") ");
        sb.append(this.body.toSource(0));
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.varName.visit(v);
            this.body.visit(v);
        }
    }
}
