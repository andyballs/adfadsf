//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class IfStatement extends AstNode
{
    private AstNode condition;
    private AstNode thenPart;
    private int elsePosition;
    private AstNode elsePart;
    private AstNode elseKeyWordInlineComment;
    private int lp;
    private int rp;
    
    public IfStatement() {
        this.elsePosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 121;
    }
    
    public IfStatement(final int pos) {
        super(pos);
        this.elsePosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 121;
    }
    
    public IfStatement(final int pos, final int len) {
        super(pos, len);
        this.elsePosition = -1;
        this.lp = -1;
        this.rp = -1;
        this.type = 121;
    }
    
    public AstNode getCondition() {
        return this.condition;
    }
    
    public void setCondition(final AstNode condition) {
        this.assertNotNull((Object)condition);
        (this.condition = condition).setParent((AstNode)this);
    }
    
    public AstNode getThenPart() {
        return this.thenPart;
    }
    
    public void setThenPart(final AstNode thenPart) {
        this.assertNotNull((Object)thenPart);
        (this.thenPart = thenPart).setParent((AstNode)this);
    }
    
    public AstNode getElsePart() {
        return this.elsePart;
    }
    
    public void setElsePart(final AstNode elsePart) {
        this.elsePart = elsePart;
        if (elsePart != null) {
            elsePart.setParent((AstNode)this);
        }
    }
    
    public int getElsePosition() {
        return this.elsePosition;
    }
    
    public void setElsePosition(final int elsePosition) {
        this.elsePosition = elsePosition;
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
        final StringBuilder sb = new StringBuilder(32);
        sb.append(pad);
        sb.append("if (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (this.getInlineComment() != null) {
            sb.append("    ").append(this.getInlineComment().toSource()).append("\n");
        }
        if (this.thenPart.getType() != 139) {
            if (this.getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(this.makeIndent(depth + 1));
        }
        sb.append(this.thenPart.toSource(depth).trim());
        if (this.elsePart != null) {
            if (this.thenPart.getType() != 139) {
                sb.append("\n").append(pad).append("else ");
            }
            else {
                sb.append(" else ");
            }
            if (this.getElseKeyWordInlineComment() != null) {
                sb.append("    ").append(this.getElseKeyWordInlineComment().toSource()).append("\n");
            }
            if (this.elsePart.getType() != 139 && this.elsePart.getType() != 121) {
                if (this.getElseKeyWordInlineComment() == null) {
                    sb.append("\n");
                }
                sb.append(this.makeIndent(depth + 1));
            }
            sb.append(this.elsePart.toSource(depth).trim());
        }
        sb.append("\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.condition.visit(v);
            this.thenPart.visit(v);
            if (this.elsePart != null) {
                this.elsePart.visit(v);
            }
        }
    }
    
    public AstNode getElseKeyWordInlineComment() {
        return this.elseKeyWordInlineComment;
    }
    
    public void setElseKeyWordInlineComment(final AstNode elseKeyWordInlineComment) {
        this.elseKeyWordInlineComment = elseKeyWordInlineComment;
    }
}
