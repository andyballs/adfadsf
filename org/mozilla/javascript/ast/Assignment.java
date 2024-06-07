//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class Assignment extends InfixExpression
{
    public Assignment() {
    }
    
    public Assignment(final int pos) {
        super(pos);
    }
    
    public Assignment(final int pos, final int len) {
        super(pos, len);
    }
    
    public Assignment(final int pos, final int len, final AstNode left, final AstNode right) {
        super(pos, len, left, right);
    }
    
    public Assignment(final AstNode left, final AstNode right) {
        super(left, right);
    }
    
    public Assignment(final int operator, final AstNode left, final AstNode right, final int operatorPos) {
        super(operator, left, right, operatorPos);
    }
}
