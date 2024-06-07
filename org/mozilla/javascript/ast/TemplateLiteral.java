//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class TemplateLiteral extends AstNode
{
    private List<AstNode> elements;
    private String[] rawElements;
    private Set<Integer> isExpr;
    private AstNode target;
    private Node transformedTarget;
    
    public TemplateLiteral() {
        this.elements = new ArrayList<AstNode>();
        this.rawElements = null;
        this.isExpr = new HashSet<Integer>();
        this.target = null;
        this.transformedTarget = null;
        this.type = 43;
    }
    
    public void addString(final String literal) {
        final StringLiteral lit = new StringLiteral();
        lit.setValue(literal);
        this.elements.add((AstNode)lit);
    }
    
    public void addExpr(final AstNode expr) {
        this.isExpr.add(this.elements.size());
        this.elements.add(expr);
    }
    
    public void setRawElements(final String[] rawElements) {
        this.rawElements = rawElements;
    }
    
    public String[] getRawElements() {
        return this.rawElements;
    }
    
    public List<AstNode> getElements() {
        return this.elements;
    }
    
    public boolean isExpr(final int index) {
        return this.isExpr.contains(index);
    }
    
    public String toSource(final int depth) {
        return "";
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            for (final AstNode e : this.elements) {
                e.visit(v);
            }
        }
    }
    
    public void setTarget(final AstNode target) {
        this.target = target;
    }
    
    public AstNode getTarget() {
        return this.target;
    }
    
    public void setTransformedTarget(final Node transformedTarget) {
        this.transformedTarget = transformedTarget;
    }
    
    public Node getTransformedTarget() {
        return this.transformedTarget;
    }
}
