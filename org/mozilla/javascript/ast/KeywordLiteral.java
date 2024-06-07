//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;

public class KeywordLiteral extends AstNode
{
    public KeywordLiteral() {
    }
    
    public KeywordLiteral(final int pos) {
        super(pos);
    }
    
    public KeywordLiteral(final int pos, final int len) {
        super(pos, len);
    }
    
    public KeywordLiteral(final int pos, final int len, final int nodeType) {
        super(pos, len);
        this.setType(nodeType);
    }
    
    public KeywordLiteral setType(final int nodeType) {
        if (nodeType != 46 && nodeType != 45 && nodeType != 48 && nodeType != 47 && nodeType != 165) {
            throw new IllegalArgumentException("Invalid node type: " + nodeType);
        }
        this.type = nodeType;
        return this;
    }
    
    public boolean isBooleanLiteral() {
        return this.type == 48 || this.type == 47;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        switch (this.getType()) {
            case 46: {
                sb.append("this");
                break;
            }
            case 45: {
                sb.append("null");
                break;
            }
            case 48: {
                sb.append("true");
                break;
            }
            case 47: {
                sb.append("false");
                break;
            }
            case 165: {
                sb.append("debugger;\n");
                break;
            }
            default: {
                throw new IllegalStateException("Invalid keyword literal type: " + this.getType());
            }
        }
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
}
