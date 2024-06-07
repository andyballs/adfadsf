//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;
import org.mozilla.javascript.*;

public class VariableDeclaration extends AstNode
{
    private List<VariableInitializer> variables;
    private boolean isStatement;
    
    public VariableDeclaration() {
        this.variables = new ArrayList<VariableInitializer>();
        this.type = 131;
    }
    
    public VariableDeclaration(final int pos) {
        super(pos);
        this.variables = new ArrayList<VariableInitializer>();
        this.type = 131;
    }
    
    public VariableDeclaration(final int pos, final int len) {
        super(pos, len);
        this.variables = new ArrayList<VariableInitializer>();
        this.type = 131;
    }
    
    public List<VariableInitializer> getVariables() {
        return this.variables;
    }
    
    public void setVariables(final List<VariableInitializer> variables) {
        this.assertNotNull((Object)variables);
        this.variables.clear();
        for (final VariableInitializer vi : variables) {
            this.addVariable(vi);
        }
    }
    
    public void addVariable(final VariableInitializer v) {
        this.assertNotNull((Object)v);
        this.variables.add(v);
        v.setParent((AstNode)this);
    }
    
    public Node setType(final int type) {
        if (type != 131 && type != 159 && type != 158 && type != 84) {
            throw new IllegalArgumentException("invalid decl type: " + type);
        }
        return super.setType(type);
    }
    
    public boolean isVar() {
        return this.type == 131;
    }
    
    public boolean isConst() {
        return this.type == 159;
    }
    
    public boolean isLet() {
        return this.type == 158;
    }
    
    public boolean isStatement() {
        return this.isStatement;
    }
    
    public void setIsStatement(final boolean isStatement) {
        this.isStatement = isStatement;
    }
    
    private String declTypeName() {
        return Token.typeToName(this.type).toLowerCase();
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.declTypeName());
        sb.append(" ");
        this.printList((List)this.variables, sb);
        if (this.isStatement()) {
            sb.append(";");
        }
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth)).append("\n");
        }
        else if (this.isStatement()) {
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            for (final AstNode var : this.variables) {
                var.visit(v);
            }
        }
    }
}
