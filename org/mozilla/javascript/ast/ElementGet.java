//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ElementGet extends AstNode
{
    private AstNode target;
    private AstNode element;
    private int lb;
    private int rb;
    
    public ElementGet() {
        this.lb = -1;
        this.rb = -1;
        this.type = 37;
    }
    
    public ElementGet(final int pos) {
        super(pos);
        this.lb = -1;
        this.rb = -1;
        this.type = 37;
    }
    
    public ElementGet(final int pos, final int len) {
        super(pos, len);
        this.lb = -1;
        this.rb = -1;
        this.type = 37;
    }
    
    public ElementGet(final AstNode target, final AstNode element) {
        this.lb = -1;
        this.rb = -1;
        this.type = 37;
        this.setTarget(target);
        this.setElement(element);
    }
    
    public AstNode getTarget() {
        return this.target;
    }
    
    public void setTarget(final AstNode target) {
        this.assertNotNull((Object)target);
        (this.target = target).setParent((AstNode)this);
    }
    
    public AstNode getElement() {
        return this.element;
    }
    
    public void setElement(final AstNode element) {
        this.assertNotNull((Object)element);
        (this.element = element).setParent((AstNode)this);
    }
    
    public int getLb() {
        return this.lb;
    }
    
    public void setLb(final int lb) {
        this.lb = lb;
    }
    
    public int getRb() {
        return this.rb;
    }
    
    public void setRb(final int rb) {
        this.rb = rb;
    }
    
    public void setParens(final int lb, final int rb) {
        this.lb = lb;
        this.rb = rb;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.target.toSource(0));
        sb.append("[");
        sb.append(this.element.toSource(0));
        sb.append("]");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.target.visit(v);
            this.element.visit(v);
        }
    }
}
