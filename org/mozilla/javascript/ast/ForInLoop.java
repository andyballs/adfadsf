//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ForInLoop extends Loop
{
    protected AstNode iterator;
    protected AstNode iteratedObject;
    protected int inPosition;
    protected int eachPosition;
    protected boolean isForOf;
    
    public ForInLoop() {
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 128;
    }
    
    public ForInLoop(final int pos) {
        super(pos);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 128;
    }
    
    public ForInLoop(final int pos, final int len) {
        super(pos, len);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 128;
    }
    
    public AstNode getIterator() {
        return this.iterator;
    }
    
    public void setIterator(final AstNode iterator) {
        this.assertNotNull((Object)iterator);
        (this.iterator = iterator).setParent((AstNode)this);
    }
    
    public AstNode getIteratedObject() {
        return this.iteratedObject;
    }
    
    public void setIteratedObject(final AstNode object) {
        this.assertNotNull((Object)object);
        (this.iteratedObject = object).setParent((AstNode)this);
    }
    
    public boolean isForOf() {
        return this.isForOf;
    }
    
    public void setIsForOf(final boolean isForOf) {
        this.isForOf = isForOf;
    }
    
    public int getInPosition() {
        return this.inPosition;
    }
    
    public void setInPosition(final int inPosition) {
        this.inPosition = inPosition;
    }
    
    public int getEachPosition() {
        return this.eachPosition;
    }
    
    public void setEachPosition(final int eachPosition) {
        this.eachPosition = eachPosition;
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("for ");
        sb.append("(");
        sb.append(this.iterator.toSource(0));
        if (this.isForOf) {
            sb.append(" of ");
        }
        else {
            sb.append(" in ");
        }
        sb.append(this.iteratedObject.toSource(0));
        sb.append(") ");
        if (this.body.getType() == 139) {
            sb.append(this.body.toSource(depth).trim()).append("\n");
        }
        else {
            sb.append("\n").append(this.body.toSource(depth + 1));
        }
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            this.iterator.visit(v);
            this.iteratedObject.visit(v);
            this.body.visit(v);
        }
    }
}
