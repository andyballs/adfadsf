//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class NewExpression extends FunctionCall
{
    private ObjectLiteral initializer;
    
    public NewExpression() {
        this.type = 31;
    }
    
    public NewExpression(final int pos) {
        super(pos);
        this.type = 31;
    }
    
    public NewExpression(final int pos, final int len) {
        super(pos, len);
        this.type = 31;
    }
    
    public ObjectLiteral getInitializer() {
        return this.initializer;
    }
    
    public void setInitializer(final ObjectLiteral initializer) {
        this.initializer = initializer;
        if (initializer != null) {
            initializer.setParent((AstNode)this);
        }
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("new ");
        sb.append(this.target.toSource(0));
        sb.append("(");
        if (this.arguments != null) {
            this.printList(this.arguments, sb);
        }
        sb.append(")");
        if (this.initializer != null) {
            sb.append(" ");
            sb.append(this.initializer.toSource(0));
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.target.visit(v);
            for (final AstNode arg : this.getArguments()) {
                arg.visit(v);
            }
            if (this.initializer != null) {
                this.initializer.visit(v);
            }
        }
    }
}
