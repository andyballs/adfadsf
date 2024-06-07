//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class Name extends AstNode
{
    private String identifier;
    private Scope scope;
    
    public Name() {
        this.type = 40;
    }
    
    public Name(final int pos) {
        super(pos);
        this.type = 40;
    }
    
    public Name(final int pos, final int len) {
        super(pos, len);
        this.type = 40;
    }
    
    public Name(final int pos, final int len, final String name) {
        super(pos, len);
        this.type = 40;
        this.setIdentifier(name);
    }
    
    public Name(final int pos, final String name) {
        super(pos);
        this.type = 40;
        this.setIdentifier(name);
        this.setLength(name.length());
    }
    
    public static boolean sameIdentifier(final Node name1, final Node name2) {
        return name1 instanceof Name && name2 instanceof Name && ((Name)name1).getIdentifier().equals(((Name)name2).getIdentifier());
    }
    
    public String getIdentifier() {
        return this.identifier;
    }
    
    public void setIdentifier(final String identifier) {
        this.assertNotNull((Object)identifier);
        this.identifier = identifier;
        this.setLength(identifier.length());
    }
    
    public void setScope(final Scope s) {
        this.scope = s;
    }
    
    public Scope getScope() {
        return this.scope;
    }
    
    public Scope getDefiningScope() {
        final Scope enclosing = this.getEnclosingScope();
        final String name = this.getIdentifier();
        return (enclosing == null) ? null : enclosing.getDefiningScope(name);
    }
    
    public boolean isLocalName() {
        final Scope scope = this.getDefiningScope();
        return scope != null && scope.getParentScope() != null;
    }
    
    public int length() {
        return (this.identifier == null) ? 0 : this.identifier.length();
    }
    
    public String toSource(final int depth) {
        return this.makeIndent(depth) + ((this.identifier == null) ? "<null>" : this.identifier);
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
}
