//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class Label extends Jump
{
    private String name;
    
    public Label() {
        this.type = 140;
    }
    
    public Label(final int pos) {
        this(pos, -1);
    }
    
    public Label(final int pos, final int len) {
        this.type = 140;
        this.position = pos;
        this.length = len;
    }
    
    public Label(final int pos, final int len, final String name) {
        this(pos, len);
        this.setName(name);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        name = ((name == null) ? null : name.trim());
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("invalid label name");
        }
        this.name = name;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append(this.name);
        sb.append(":\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        v.visit((AstNode)this);
    }
}
