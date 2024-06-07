//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public abstract class Loop extends Scope
{
    protected AstNode body;
    protected int lp;
    protected int rp;
    
    public Loop() {
        this.lp = -1;
        this.rp = -1;
    }
    
    public Loop(final int pos) {
        super(pos);
        this.lp = -1;
        this.rp = -1;
    }
    
    public Loop(final int pos, final int len) {
        super(pos, len);
        this.lp = -1;
        this.rp = -1;
    }
    
    public AstNode getBody() {
        return this.body;
    }
    
    public void setBody(final AstNode body) {
        this.body = body;
        final int end = body.getPosition() + body.getLength();
        this.setLength(end - this.getPosition());
        body.setParent((AstNode)this);
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
}
