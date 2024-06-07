//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.dsl.code.modifiers.*;
import java.util.*;
import org.objectweb.asm.tree.*;
import dev.falsehonesty.asmhelper.printing.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0004J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/CodeBuilder;", "", "codeClassNode", "Lorg/objectweb/asm/tree/ClassNode;", "(Lorg/objectweb/asm/tree/ClassNode;)V", "getCodeClassNode", "()Lorg/objectweb/asm/tree/ClassNode;", "modifiers", "", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "getModifiers", "()Ljava/util/List;", "getMethodNode", "Lorg/objectweb/asm/tree/MethodNode;", "transformToInstructions", "Lorg/objectweb/asm/tree/InsnList;", "AsmHelper1.8.9" })
public abstract class CodeBuilder
{
    @NotNull
    private final ClassNode codeClassNode;
    
    public CodeBuilder(@NotNull final ClassNode codeClassNode) {
        Intrinsics.checkNotNullParameter((Object)codeClassNode, "codeClassNode");
        this.codeClassNode = codeClassNode;
    }
    
    @NotNull
    public final ClassNode getCodeClassNode() {
        return this.codeClassNode;
    }
    
    @NotNull
    public abstract List<Modifier> getModifiers();
    
    @NotNull
    protected final MethodNode getMethodNode() {
        final List methods = this.codeClassNode.methods;
        Intrinsics.checkNotNullExpressionValue((Object)methods, "codeClassNode.methods");
        while (true) {
            for (final MethodNode next : (List<Object>)methods) {
                final MethodNode it = next;
                final int n = 0;
                if (Intrinsics.areEqual((Object)it.name, (Object)"invoke") && Intrinsics.areEqual((Object)it.desc, (Object)"()V")) {
                    final MethodNode methodNode2;
                    final MethodNode methodNode = methodNode2 = next;
                    Intrinsics.checkNotNull((Object)methodNode2);
                    return methodNode;
                }
            }
            MethodNode methodNode2;
            final MethodNode methodNode = methodNode2 = null;
            continue;
        }
    }
    
    @NotNull
    public final InsnList transformToInstructions() {
        final InsnList instructions = this.getMethodNode().instructions;
        PrintingKt.verbose(Intrinsics.stringPlus("Transforming code class ", (Object)this.codeClassNode.name));
        PrintingKt.verbose("Initial instruction list:");
        final String s = "\n";
        Intrinsics.checkNotNullExpressionValue((Object)instructions, "instructions");
        PrintingKt.verbose(Intrinsics.stringPlus(s, (Object)PrettyprintingKt.prettyString(instructions)));
        PrintingKt.verbose("-----------------");
        final Iterable $this$forEach$iv = this.getModifiers();
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Modifier it = (Modifier)element$iv;
            final int n = 0;
            PrintingKt.verbose(Intrinsics.stringPlus("Running cycle ", (Object)it));
            PrintingKt.verbose("-----------------");
            it.modify(instructions);
            PrintingKt.verbose("-----------------");
            PrintingKt.verbose(Intrinsics.stringPlus("After cycle ", (Object)it));
            PrintingKt.verbose(Intrinsics.stringPlus("\n", (Object)PrettyprintingKt.prettyString(instructions)));
        }
        return instructions;
    }
}
