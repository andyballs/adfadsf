//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "codeBlockClass", "", "(Ljava/lang/String;)V", "getCodeBlockClass", "()Ljava/lang/String;", "modify", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "modifyFieldNode", "node", "Lorg/objectweb/asm/tree/FieldInsnNode;", "shadowedName", "AsmHelper1.8.9" })
public abstract class ShadowedModifier extends Modifier
{
    @NotNull
    private final String codeBlockClass;
    
    public ShadowedModifier(@NotNull final String codeBlockClass) {
        Intrinsics.checkNotNullParameter((Object)codeBlockClass, "codeBlockClass");
        this.codeBlockClass = codeBlockClass;
    }
    
    @NotNull
    public final String getCodeBlockClass() {
        return this.codeBlockClass;
    }
    
    public void modify(@NotNull final InsnList instructions) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        for (final AbstractInsnNode node : instructions) {
            if (node instanceof FieldInsnNode && Intrinsics.areEqual((Object)((FieldInsnNode)node).owner, (Object)this.codeBlockClass)) {
                final FieldInsnNode fieldInsnNode = (FieldInsnNode)node;
                final String name = ((FieldInsnNode)node).name;
                Intrinsics.checkNotNullExpressionValue((Object)name, "node.name");
                final String substring = name.substring(1);
                Intrinsics.checkNotNullExpressionValue((Object)substring, "(this as java.lang.String).substring(startIndex)");
                this.modifyFieldNode(instructions, fieldInsnNode, substring);
            }
        }
    }
    
    public abstract void modifyFieldNode(@NotNull final InsnList p0, @NotNull final FieldInsnNode p1, @NotNull final String p2);
}
