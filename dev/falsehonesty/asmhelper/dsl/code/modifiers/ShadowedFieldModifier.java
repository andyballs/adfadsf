//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import dev.falsehonesty.asmhelper.printing.*;
import kotlin.text.*;
import dev.falsehonesty.asmhelper.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedFieldModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedModifier;", "codeBlockClass", "", "targetClassNode", "Lorg/objectweb/asm/tree/ClassNode;", "(Ljava/lang/String;Lorg/objectweb/asm/tree/ClassNode;)V", "getTargetClassNode", "()Lorg/objectweb/asm/tree/ClassNode;", "modifyFieldNode", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "node", "Lorg/objectweb/asm/tree/FieldInsnNode;", "shadowedName", "AsmHelper1.8.9" })
public final class ShadowedFieldModifier extends ShadowedModifier
{
    @NotNull
    private final ClassNode targetClassNode;
    
    public ShadowedFieldModifier(@NotNull final String codeBlockClass, @NotNull final ClassNode targetClassNode) {
        Intrinsics.checkNotNullParameter((Object)codeBlockClass, "codeBlockClass");
        Intrinsics.checkNotNullParameter((Object)targetClassNode, "targetClassNode");
        super(codeBlockClass);
        this.targetClassNode = targetClassNode;
    }
    
    @NotNull
    public final ClassNode getTargetClassNode() {
        return this.targetClassNode;
    }
    
    @Override
    public void modifyFieldNode(@NotNull final InsnList instructions, @NotNull final FieldInsnNode node, @NotNull final String shadowedName) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        Intrinsics.checkNotNullParameter((Object)node, "node");
        Intrinsics.checkNotNullParameter((Object)shadowedName, "shadowedName");
        PrintingKt.verbose("Any fields referencing the code block class at this point must be a normal field.");
        final String prettyString = PrettyprintingKt.prettyString((AbstractInsnNode)node);
        if (prettyString == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        final String prevString = StringsKt.trim((CharSequence)prettyString).toString();
        node.owner = this.targetClassNode.name;
        node.name = AsmHelper.INSTANCE.getRemapper().mapFieldAccess(shadowedName);
        final StringBuilder append = new StringBuilder().append(prevString).append(" --> ");
        final String prettyString2 = PrettyprintingKt.prettyString((AbstractInsnNode)node);
        if (prettyString2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        PrintingKt.verbose(append.append(StringsKt.trim((CharSequence)prettyString2).toString()).toString());
    }
}
