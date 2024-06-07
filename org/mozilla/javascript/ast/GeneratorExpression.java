//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class GeneratorExpression extends Scope
{
    private AstNode result;
    private List<GeneratorExpressionLoop> loops;
    private AstNode filter;
    private int ifPosition;
    private int lp;
    private int rp;
    
    public GeneratorExpression() {
        this.loops = new ArrayList<GeneratorExpressionLoop>();
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 167;
    }
    
    public GeneratorExpression(final int pos) {
        super(pos);
        this.loops = new ArrayList<GeneratorExpressionLoop>();
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 167;
    }
    
    public GeneratorExpression(final int pos, final int len) {
        super(pos, len);
        this.loops = new ArrayList<GeneratorExpressionLoop>();
        this.ifPosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 167;
    }
    
    public AstNode getResult() {
        return this.result;
    }
    
    public void setResult(final AstNode result) {
        this.assertNotNull((Object)result);
        (this.result = result).setParent((AstNode)this);
    }
    
    public List<GeneratorExpressionLoop> getLoops() {
        return this.loops;
    }
    
    public void setLoops(final List<GeneratorExpressionLoop> loops) {
        this.assertNotNull((Object)loops);
        this.loops.clear();
        for (final GeneratorExpressionLoop acl : loops) {
            this.addLoop(acl);
        }
    }
    
    public void addLoop(final GeneratorExpressionLoop acl) {
        this.assertNotNull((Object)acl);
        this.loops.add(acl);
        acl.setParent((AstNode)this);
    }
    
    public AstNode getFilter() {
        return this.filter;
    }
    
    public void setFilter(final AstNode filter) {
        this.filter = filter;
        if (filter != null) {
            filter.setParent((AstNode)this);
        }
    }
    
    public int getIfPosition() {
        return this.ifPosition;
    }
    
    public void setIfPosition(final int ifPosition) {
        this.ifPosition = ifPosition;
    }
    
    public int getFilterLp() {
        return this.lp;
    }
    
    public void setFilterLp(final int lp) {
        this.lp = lp;
    }
    
    public int getFilterRp() {
        return this.rp;
    }
    
    public void setFilterRp(final int rp) {
        this.rp = rp;
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder(250);
        sb.append("(");
        sb.append(this.result.toSource(0));
        for (final GeneratorExpressionLoop loop : this.loops) {
            sb.append(loop.toSource(0));
        }
        if (this.filter != null) {
            sb.append(" if (");
            sb.append(this.filter.toSource(0));
            sb.append(")");
        }
        sb.append(")");
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (!v.visit(this)) {
            return;
        }
        this.result.visit(v);
        for (final GeneratorExpressionLoop loop : this.loops) {
            loop.visit(v);
        }
        if (this.filter != null) {
            this.filter.visit(v);
        }
    }
}
