//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class RegExpLiteral extends AstNode
{
    private String value;
    private String flags;
    
    public RegExpLiteral() {
        this.type = 51;
    }
    
    public RegExpLiteral(final int pos) {
        super(pos);
        this.type = 51;
    }
    
    public RegExpLiteral(final int pos, final int len) {
        super(pos, len);
        this.type = 51;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.assertNotNull((Object)value);
        this.value = value;
    }
    
    public String getFlags() {
        return this.flags;
    }
    
    public void setFlags(final String flags) {
        this.flags = flags;
    }
    
    public String toSource(final int depth) {
        return this.makeIndent(depth) + "/" + this.value + "/" + ((this.flags == null) ? "" : this.flags);
    }
    
    public void visit(final NodeVisitor v) {
        v.visit((AstNode)this);
    }
}
