//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.util.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\r" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/CodeBlockShortcutModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "()V", "modify", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "modifyReturnShortcut", "node", "Lorg/objectweb/asm/tree/MethodInsnNode;", "returnType", "", "modifyShortcut", "AsmHelper1.8.9" })
public final class CodeBlockShortcutModifier extends Modifier
{
    @Override
    public void modify(@NotNull final InsnList instructions) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        for (final AbstractInsnNode node : instructions) {
            if (node instanceof FieldInsnNode && Intrinsics.areEqual((Object)((FieldInsnNode)node).owner, (Object)"dev/falsehonesty/asmhelper/dsl/code/CodeBlock") && Intrinsics.areEqual((Object)((FieldInsnNode)node).name, (Object)"Companion")) {
                instructions.remove(node);
            }
            else {
                if (!(node instanceof MethodInsnNode) || ((MethodInsnNode)node).getOpcode() != 182 || !Intrinsics.areEqual((Object)((MethodInsnNode)node).owner, (Object)"dev/falsehonesty/asmhelper/dsl/code/CodeBlock$Companion")) {
                    continue;
                }
                this.modifyShortcut((MethodInsnNode)node, instructions);
            }
        }
    }
    
    private final void modifyShortcut(final MethodInsnNode node, final InsnList instructions) {
        final String name = node.name;
        if (name != null) {
            switch (name) {
                case "methodReturn": {
                    this.modifyReturnShortcut(node, instructions, 177);
                    break;
                }
                case "dReturn": {
                    this.modifyReturnShortcut(node, instructions, 175);
                    break;
                }
                case "iReturn": {
                    this.modifyReturnShortcut(node, instructions, 172);
                    break;
                }
                case "lReturn": {
                    this.modifyReturnShortcut(node, instructions, 173);
                    break;
                }
                case "fReturn": {
                    this.modifyReturnShortcut(node, instructions, 174);
                    break;
                }
                case "aReturn": {
                    this.modifyReturnShortcut(node, instructions, 176);
                    break;
                }
                default:
                    break;
            }
        }
    }
    
    private final void modifyReturnShortcut(final MethodInsnNode node, final InsnList instructions, final int returnType) {
        instructions.insert((AbstractInsnNode)node, (AbstractInsnNode)new InsnNode(returnType));
        instructions.remove((AbstractInsnNode)node);
    }
}
