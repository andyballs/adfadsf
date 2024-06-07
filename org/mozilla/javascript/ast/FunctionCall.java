//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class FunctionCall extends AstNode
{
    protected static final List<AstNode> NO_ARGS;
    protected AstNode target;
    protected List<AstNode> arguments;
    protected int lp;
    protected int rp;
    
    public FunctionCall() {
        this.lp = -1;
        this.rp = -1;
        this.type = 39;
    }
    
    public FunctionCall(final int pos) {
        super(pos);
        this.lp = -1;
        this.rp = -1;
        this.type = 39;
    }
    
    public FunctionCall(final int pos, final int len) {
        super(pos, len);
        this.lp = -1;
        this.rp = -1;
        this.type = 39;
    }
    
    public AstNode getTarget() {
        return this.target;
    }
    
    public void setTarget(final AstNode target) {
        this.assertNotNull((Object)target);
        (this.target = target).setParent((AstNode)this);
    }
    
    public List<AstNode> getArguments() {
        return (this.arguments != null) ? this.arguments : FunctionCall.NO_ARGS;
    }
    
    public void setArguments(final List<AstNode> arguments) {
        if (arguments == null) {
            this.arguments = null;
        }
        else {
            if (this.arguments != null) {
                this.arguments.clear();
            }
            for (final AstNode arg : arguments) {
                this.addArgument(arg);
            }
        }
    }
    
    public void addArgument(final AstNode arg) {
        this.assertNotNull((Object)arg);
        if (this.arguments == null) {
            this.arguments = new ArrayList<AstNode>();
        }
        this.arguments.add(arg);
        arg.setParent((AstNode)this);
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
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.target.toSource(0));
        sb.append("(");
        if (this.arguments != null) {
            this.printList((List)this.arguments, sb);
        }
        sb.append(")");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth)).append("\n");
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.target.visit(v);
            for (final AstNode arg : this.getArguments()) {
                arg.visit(v);
            }
        }
    }
    
    static {
        NO_ARGS = Collections.unmodifiableList((List<? extends AstNode>)new ArrayList<AstNode>());
    }
}
