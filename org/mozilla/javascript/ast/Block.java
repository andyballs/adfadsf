//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class Block extends AstNode
{
    public Block() {
        this.type = 139;
    }
    
    public Block(final int pos) {
        super(pos);
        this.type = 139;
    }
    
    public Block(final int pos, final int len) {
        super(pos, len);
        this.type = 139;
    }
    
    public void addStatement(final AstNode statement) {
        this.addChild(statement);
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("{\n");
        for (final Node kid : this) {
            final AstNode astNodeKid = (AstNode)kid;
            sb.append(astNodeKid.toSource(depth + 1));
            if (astNodeKid.getType() == 166) {
                sb.append("\n");
            }
        }
        sb.append(this.makeIndent(depth));
        sb.append("}");
        if (this.getInlineComment() != null) {
            sb.append(this.getInlineComment().toSource(depth));
        }
        sb.append("\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            for (final Node kid : this) {
                ((AstNode)kid).visit(v);
            }
        }
    }
}
