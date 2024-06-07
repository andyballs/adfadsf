//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class LetNode extends Scope
{
    private VariableDeclaration variables;
    private AstNode body;
    private int lp;
    private int rp;
    
    public LetNode() {
        this.lp = -1;
        this.rp = -1;
        this.type = 163;
    }
    
    public LetNode(final int pos) {
        super(pos);
        this.lp = -1;
        this.rp = -1;
        this.type = 163;
    }
    
    public LetNode(final int pos, final int len) {
        super(pos, len);
        this.lp = -1;
        this.rp = -1;
        this.type = 163;
    }
    
    public VariableDeclaration getVariables() {
        return this.variables;
    }
    
    public void setVariables(final VariableDeclaration variables) {
        this.assertNotNull((Object)variables);
        (this.variables = variables).setParent((AstNode)this);
    }
    
    public AstNode getBody() {
        return this.body;
    }
    
    public void setBody(final AstNode body) {
        this.body = body;
        if (body != null) {
            body.setParent((AstNode)this);
        }
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
    
    @Override
    public String toSource(final int depth) {
        final String pad = this.makeIndent(depth);
        final StringBuilder sb = new StringBuilder();
        sb.append(pad);
        sb.append("let (");
        this.printList((List)this.variables.getVariables(), sb);
        sb.append(") ");
        if (this.body != null) {
            sb.append(this.body.toSource(depth));
        }
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.variables.visit(v);
            if (this.body != null) {
                this.body.visit(v);
            }
        }
    }
}
