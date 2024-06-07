//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class Symbol
{
    private int declType;
    private int index;
    private String name;
    private Node node;
    private Scope containingTable;
    
    public Symbol() {
        this.index = -1;
    }
    
    public Symbol(final int declType, final String name) {
        this.index = -1;
        this.setName(name);
        this.setDeclType(declType);
    }
    
    public int getDeclType() {
        return this.declType;
    }
    
    public void setDeclType(final int declType) {
        if (declType != 114 && declType != 84 && declType != 131 && declType != 158 && declType != 159 && declType != 115) {
            throw new IllegalArgumentException("Invalid declType: " + declType);
        }
        this.declType = declType;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public Node getNode() {
        return this.node;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public void setNode(final Node node) {
        this.node = node;
    }
    
    public Scope getContainingTable() {
        return this.containingTable;
    }
    
    public void setContainingTable(final Scope containingTable) {
        this.containingTable = containingTable;
    }
    
    public String getDeclTypeName() {
        return Token.typeToName(this.declType);
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("Symbol (");
        result.append(this.getDeclTypeName());
        result.append(") name=");
        result.append(this.name);
        if (this.node != null) {
            result.append(" line=");
            result.append(this.node.getLineno());
        }
        return result.toString();
    }
}
