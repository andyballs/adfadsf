//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import kotlin.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;", "", "opcode", "", "(Ljava/lang/String;II)V", "getOpcode", "()I", "TRUE", "FALSE", "EQUAL", "NOT_EQUAL", "LESS_THAN", "GREATER_OR_EQUAL", "GREATER_THAN", "LESS_OR_EQUAL", "NULL", "NON_NULL", "GOTO", "REFS_EQUAL", "REFS_NOT_EQUAL", "AsmHelper1.8.9" })
public enum JumpCondition
{
    private final int opcode;
    
    TRUE(154), 
    FALSE(153), 
    EQUAL(153), 
    NOT_EQUAL(154), 
    LESS_THAN(155), 
    GREATER_OR_EQUAL(156), 
    GREATER_THAN(157), 
    LESS_OR_EQUAL(158), 
    NULL(198), 
    NON_NULL(199), 
    GOTO(167), 
    REFS_EQUAL(165), 
    REFS_NOT_EQUAL(166);
    
    private JumpCondition(final int opcode) {
        this.opcode = opcode;
    }
    
    public final int getOpcode() {
        return this.opcode;
    }
    
    private static final /* synthetic */ JumpCondition[] $values() {
        return new JumpCondition[] { JumpCondition.TRUE, JumpCondition.FALSE, JumpCondition.EQUAL, JumpCondition.NOT_EQUAL, JumpCondition.LESS_THAN, JumpCondition.GREATER_OR_EQUAL, JumpCondition.GREATER_THAN, JumpCondition.LESS_OR_EQUAL, JumpCondition.NULL, JumpCondition.NON_NULL, JumpCondition.GOTO, JumpCondition.REFS_EQUAL, JumpCondition.REFS_NOT_EQUAL };
    }
    
    static {
        $VALUES = $values();
    }
}
