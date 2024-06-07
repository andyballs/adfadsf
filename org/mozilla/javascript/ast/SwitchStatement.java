//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class SwitchStatement extends Jump
{
    private static final List<SwitchCase> NO_CASES;
    private AstNode expression;
    private List<SwitchCase> cases;
    private int lp;
    private int rp;
    
    public SwitchStatement() {
        this.lp = -1;
        this.rp = -1;
        this.type = 123;
    }
    
    public SwitchStatement(final int pos) {
        this.lp = -1;
        this.rp = -1;
        this.type = 123;
        this.position = pos;
    }
    
    public SwitchStatement(final int pos, final int len) {
        this.lp = -1;
        this.rp = -1;
        this.type = 123;
        this.position = pos;
        this.length = len;
    }
    
    public AstNode getExpression() {
        return this.expression;
    }
    
    public void setExpression(final AstNode expression) {
        this.assertNotNull((Object)expression);
        (this.expression = expression).setParent((AstNode)this);
    }
    
    public List<SwitchCase> getCases() {
        return (this.cases != null) ? this.cases : SwitchStatement.NO_CASES;
    }
    
    public void setCases(final List<SwitchCase> cases) {
        if (cases == null) {
            this.cases = null;
        }
        else {
            if (this.cases != null) {
                this.cases.clear();
            }
            for (final SwitchCase sc : cases) {
                this.addCase(sc);
            }
        }
    }
    
    public void addCase(final SwitchCase switchCase) {
        this.assertNotNull((Object)switchCase);
        if (this.cases == null) {
            this.cases = new ArrayList<SwitchCase>();
        }
        this.cases.add(switchCase);
        switchCase.setParent((AstNode)this);
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
    
    public String toSource(final int depth) {
        final String pad = this.makeIndent(depth);
        final StringBuilder sb = new StringBuilder();
        sb.append(pad);
        sb.append("switch (");
        sb.append(this.expression.toSource(0));
        sb.append(") {\n");
        if (this.cases != null) {
            for (final SwitchCase sc : this.cases) {
                sb.append(sc.toSource(depth + 1));
            }
        }
        sb.append(pad);
        sb.append("}\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.expression.visit(v);
            for (final SwitchCase sc : this.getCases()) {
                sc.visit(v);
            }
        }
    }
    
    static {
        NO_CASES = Collections.unmodifiableList((List<? extends SwitchCase>)new ArrayList<SwitchCase>());
    }
}
