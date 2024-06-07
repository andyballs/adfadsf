//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ForLoop extends Loop
{
    private AstNode initializer;
    private AstNode condition;
    private AstNode increment;
    
    public ForLoop() {
        this.type = 128;
    }
    
    public ForLoop(final int pos) {
        super(pos);
        this.type = 128;
    }
    
    public ForLoop(final int pos, final int len) {
        super(pos, len);
        this.type = 128;
    }
    
    public AstNode getInitializer() {
        return this.initializer;
    }
    
    public void setInitializer(final AstNode initializer) {
        this.assertNotNull((Object)initializer);
        (this.initializer = initializer).setParent((AstNode)this);
    }
    
    public AstNode getCondition() {
        return this.condition;
    }
    
    public void setCondition(final AstNode condition) {
        this.assertNotNull((Object)condition);
        (this.condition = condition).setParent((AstNode)this);
    }
    
    public AstNode getIncrement() {
        return this.increment;
    }
    
    public void setIncrement(final AstNode increment) {
        this.assertNotNull((Object)increment);
        (this.increment = increment).setParent((AstNode)this);
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("for (");
        sb.append(this.initializer.toSource(0));
        sb.append("; ");
        sb.append(this.condition.toSource(0));
        sb.append("; ");
        sb.append(this.increment.toSource(0));
        sb.append(") ");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource()).append("\n");
        }
        if (this.body.getType() == 139) {
            String bodySource = this.body.toSource(depth);
            if (this.getInlineComment() == null) {
                bodySource = bodySource.trim();
            }
            sb.append(bodySource).append("\n");
        }
        else {
            if (this.getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(this.body.toSource(depth + 1));
        }
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.initializer.visit(v);
            this.condition.visit(v);
            this.increment.visit(v);
            this.body.visit(v);
        }
    }
}
