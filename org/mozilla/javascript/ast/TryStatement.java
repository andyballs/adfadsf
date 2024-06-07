//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class TryStatement extends AstNode
{
    private static final List<CatchClause> NO_CATCHES;
    private AstNode tryBlock;
    private List<CatchClause> catchClauses;
    private AstNode finallyBlock;
    private int finallyPosition;
    
    public TryStatement() {
        this.finallyPosition = -1;
        this.type = 78;
    }
    
    public TryStatement(final int pos) {
        super(pos);
        this.finallyPosition = -1;
        this.type = 78;
    }
    
    public TryStatement(final int pos, final int len) {
        super(pos, len);
        this.finallyPosition = -1;
        this.type = 78;
    }
    
    public AstNode getTryBlock() {
        return this.tryBlock;
    }
    
    public void setTryBlock(final AstNode tryBlock) {
        this.assertNotNull((Object)tryBlock);
        (this.tryBlock = tryBlock).setParent((AstNode)this);
    }
    
    public List<CatchClause> getCatchClauses() {
        return (this.catchClauses != null) ? this.catchClauses : TryStatement.NO_CATCHES;
    }
    
    public void setCatchClauses(final List<CatchClause> catchClauses) {
        if (catchClauses == null) {
            this.catchClauses = null;
        }
        else {
            if (this.catchClauses != null) {
                this.catchClauses.clear();
            }
            for (final CatchClause cc : catchClauses) {
                this.addCatchClause(cc);
            }
        }
    }
    
    public void addCatchClause(final CatchClause clause) {
        this.assertNotNull((Object)clause);
        if (this.catchClauses == null) {
            this.catchClauses = new ArrayList<CatchClause>();
        }
        this.catchClauses.add(clause);
        clause.setParent((AstNode)this);
    }
    
    public AstNode getFinallyBlock() {
        return this.finallyBlock;
    }
    
    public void setFinallyBlock(final AstNode finallyBlock) {
        this.finallyBlock = finallyBlock;
        if (finallyBlock != null) {
            finallyBlock.setParent((AstNode)this);
        }
    }
    
    public int getFinallyPosition() {
        return this.finallyPosition;
    }
    
    public void setFinallyPosition(final int finallyPosition) {
        this.finallyPosition = finallyPosition;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder(250);
        sb.append(this.makeIndent(depth));
        sb.append("try ");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth + 1)).append("\n");
        }
        sb.append(this.tryBlock.toSource(depth).trim());
        for (final CatchClause cc : this.getCatchClauses()) {
            sb.append(cc.toSource(depth));
        }
        if (this.finallyBlock != null) {
            sb.append(" finally ");
            sb.append(this.finallyBlock.toSource(depth));
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.tryBlock.visit(v);
            for (final CatchClause cc : this.getCatchClauses()) {
                cc.visit(v);
            }
            if (this.finallyBlock != null) {
                this.finallyBlock.visit(v);
            }
        }
    }
    
    static {
        NO_CATCHES = Collections.unmodifiableList((List<? extends CatchClause>)new ArrayList<CatchClause>());
    }
}
