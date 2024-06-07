//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class StringLiteral extends AstNode
{
    private String value;
    private char quoteChar;
    
    public StringLiteral() {
        this.type = 42;
    }
    
    public StringLiteral(final int pos) {
        super(pos);
        this.type = 42;
    }
    
    public StringLiteral(final int pos, final int len) {
        super(pos, len);
        this.type = 42;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public String getValue(final boolean includeQuotes) {
        if (!includeQuotes) {
            return this.value;
        }
        return this.quoteChar + this.value + this.quoteChar;
    }
    
    public void setValue(final String value) {
        this.assertNotNull((Object)value);
        this.value = value;
    }
    
    public char getQuoteCharacter() {
        return this.quoteChar;
    }
    
    public void setQuoteCharacter(final char c) {
        this.quoteChar = c;
    }
    
    public String toSource(final int depth) {
        return this.makeIndent(depth) + this.quoteChar + ScriptRuntime.escapeString(this.value, this.quoteChar) + this.quoteChar;
    }
    
    public void visit(final NodeVisitor v) {
        v.visit((AstNode)this);
    }
}
