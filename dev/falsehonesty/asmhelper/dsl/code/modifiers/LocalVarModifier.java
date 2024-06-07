//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import kotlin.text.*;
import dev.falsehonesty.asmhelper.printing.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/LocalVarModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "targetMethodNode", "Lorg/objectweb/asm/tree/MethodNode;", "(Lorg/objectweb/asm/tree/MethodNode;)V", "getTargetMethodNode", "()Lorg/objectweb/asm/tree/MethodNode;", "modify", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "AsmHelper1.8.9" })
public final class LocalVarModifier extends Modifier
{
    @NotNull
    private final MethodNode targetMethodNode;
    
    public LocalVarModifier(@NotNull final MethodNode targetMethodNode) {
        Intrinsics.checkNotNullParameter((Object)targetMethodNode, "targetMethodNode");
        this.targetMethodNode = targetMethodNode;
    }
    
    @NotNull
    public final MethodNode getTargetMethodNode() {
        return this.targetMethodNode;
    }
    
    @Override
    public void modify(@NotNull final InsnList instructions) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        for (final AbstractInsnNode node : instructions) {
            if (node instanceof VarInsnNode && ((VarInsnNode)node).var != 0) {
                final String prettyString = PrettyprintingKt.prettyString(node);
                if (prettyString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                final String before = StringsKt.trim((CharSequence)prettyString).toString();
                final VarInsnNode varInsnNode = (VarInsnNode)node;
                varInsnNode.var += this.targetMethodNode.maxLocals - 1;
                final StringBuilder append = new StringBuilder().append(before).append(" --> ");
                final String prettyString2 = PrettyprintingKt.prettyString(node);
                if (prettyString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                PrintingKt.verbose(append.append(StringsKt.trim((CharSequence)prettyString2).toString()).toString());
            }
        }
    }
}
