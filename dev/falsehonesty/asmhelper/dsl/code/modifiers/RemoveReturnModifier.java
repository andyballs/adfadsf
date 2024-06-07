//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/RemoveReturnModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "()V", "modify", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "AsmHelper1.8.9" })
public final class RemoveReturnModifier extends Modifier
{
    public void modify(@NotNull final InsnList instructions) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        for (final AbstractInsnNode node : instructions) {
            if (node.getOpcode() == 177) {
                instructions.remove(node);
            }
        }
    }
}
