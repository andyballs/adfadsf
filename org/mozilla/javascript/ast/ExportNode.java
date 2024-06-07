//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ExportNode extends ImportNode
{
    private AstNode exportedValue;
    private String identifier;
    private boolean defaultExport;
    
    public ExportNode() {
        this.exportedValue = null;
        this.identifier = null;
        this.defaultExport = false;
    }
    
    public AstNode getExportedValue() {
        return this.exportedValue;
    }
    
    public String getIdentifier() {
        return this.identifier;
    }
    
    public void setExportedValue(final AstNode node, final String identifier) {
        this.exportedValue = node;
        this.identifier = identifier;
    }
    
    public void setExportedValue(final AstNode node) {
        this.exportedValue = node;
        this.defaultExport = true;
    }
    
    public boolean isDefaultExport() {
        return this.defaultExport;
    }
}
