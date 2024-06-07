//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import kotlin.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/FieldAction;", "", "opcode", "", "(Ljava/lang/String;II)V", "getOpcode", "()I", "GET_STATIC", "PUT_STATIC", "GET_FIELD", "PUT_FIELD", "AsmHelper1.8.9" })
public enum FieldAction
{
    private final int opcode;
    
    GET_STATIC(178), 
    PUT_STATIC(179), 
    GET_FIELD(180), 
    PUT_FIELD(181);
    
    private FieldAction(final int opcode) {
        this.opcode = opcode;
    }
    
    public final int getOpcode() {
        return this.opcode;
    }
    
    private static final /* synthetic */ FieldAction[] $values() {
        return new FieldAction[] { FieldAction.GET_STATIC, FieldAction.PUT_STATIC, FieldAction.GET_FIELD, FieldAction.PUT_FIELD };
    }
    
    static {
        $VALUES = $values();
    }
}
