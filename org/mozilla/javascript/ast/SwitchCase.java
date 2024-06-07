//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;
import org.mozilla.javascript.*;

public class SwitchCase extends AstNode
{
    private AstNode expression;
    private List<AstNode> statements;
    
    public SwitchCase() {
        this.type = 124;
    }
    
    public SwitchCase(final int pos) {
        super(pos);
        this.type = 124;
    }
    
    public SwitchCase(final int pos, final int len) {
        super(pos, len);
        this.type = 124;
    }
    
    public AstNode getExpression() {
        return this.expression;
    }
    
    public void setExpression(final AstNode expression) {
        this.expression = expression;
        if (expression != null) {
            expression.setParent((AstNode)this);
        }
    }
    
    public boolean isDefault() {
        return this.expression == null;
    }
    
    public List<AstNode> getStatements() {
        return this.statements;
    }
    
    public void setStatements(final List<AstNode> statements) {
        if (this.statements != null) {
            this.statements.clear();
        }
        for (final AstNode s : statements) {
            this.addStatement(s);
        }
    }
    
    public void addStatement(final AstNode statement) {
        this.assertNotNull((Object)statement);
        if (this.statements == null) {
            this.statements = new ArrayList<AstNode>();
        }
        final int end = statement.getPosition() + statement.getLength();
        this.setLength(end - this.getPosition());
        this.statements.add(statement);
        statement.setParent((AstNode)this);
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        if (this.expression == null) {
            sb.append("default:\n");
        }
        else {
            sb.append("case ");
            sb.append(this.expression.toSource(0));
            sb.append(":");
            if (this.getInlineComment() != null) {
                sb.append(this.getInlineComment().toSource(depth + 1));
            }
            sb.append("\n");
        }
        if (this.statements != null) {
            for (final AstNode s : this.statements) {
                sb.append(s.toSource(depth + 1));
                if (s.getType() == 166 && ((Comment)s).getCommentType() == Token.CommentType.LINE) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            if (this.expression != null) {
                this.expression.visit(v);
            }
            if (this.statements != null) {
                for (final AstNode s : this.statements) {
                    s.visit(v);
                }
            }
        }
    }
}
