//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class WhileLoop extends Loop
{
    private AstNode condition;
    
    public WhileLoop() {
        this.type = 126;
    }
    
    public WhileLoop(final int pos) {
        super(pos);
        this.type = 126;
    }
    
    public WhileLoop(final int pos, final int len) {
        super(pos, len);
        this.type = 126;
    }
    
    public AstNode getCondition() {
        return this.condition;
    }
    
    public void setCondition(final AstNode condition) {
        this.assertNotNull((Object)condition);
        (this.condition = condition).setParent((AstNode)this);
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("while (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth + 1)).append("\n");
        }
        if (this.body.getType() == 139) {
            sb.append(this.body.toSource(depth).trim());
            sb.append("\n");
        }
        else {
            if (this.getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(this.body.toSource(depth + 1));
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            this.condition.visit(v);
            this.body.visit(v);
        }
    }
}
