//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class Comment extends AstNode
{
    private String value;
    private Token.CommentType commentType;
    
    public Comment(final int pos, final int len, final Token.CommentType type, final String value) {
        super(pos, len);
        this.type = 166;
        this.commentType = type;
        this.value = value;
    }
    
    public Token.CommentType getCommentType() {
        return this.commentType;
    }
    
    public void setCommentType(final Token.CommentType type) {
        this.commentType = type;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String commentString) {
        this.value = commentString;
        this.setLength(this.value.length());
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder(this.getLength() + 10);
        sb.append(this.makeIndent(depth));
        sb.append(this.value);
        if (Token.CommentType.BLOCK_COMMENT == this.getCommentType()) {
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
}
