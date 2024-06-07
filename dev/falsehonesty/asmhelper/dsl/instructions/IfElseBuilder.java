//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import org.jetbrains.annotations.*;
import org.objectweb.asm.tree.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import kotlin.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00002\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014J\u001f\u0010\u000b\u001a\u00020\u00002\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/IfElseBuilder;", "", "methodNode", "Lorg/objectweb/asm/tree/MethodNode;", "(Lorg/objectweb/asm/tree/MethodNode;)V", "elseCode", "Lorg/objectweb/asm/tree/InsnList;", "getElseCode", "()Lorg/objectweb/asm/tree/InsnList;", "setElseCode", "(Lorg/objectweb/asm/tree/InsnList;)V", "ifCode", "getIfCode", "setIfCode", "getMethodNode", "()Lorg/objectweb/asm/tree/MethodNode;", "builder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "AsmHelper1.8.9" })
public final class IfElseBuilder
{
    @NotNull
    private final MethodNode methodNode;
    @NotNull
    private InsnList ifCode;
    @NotNull
    private InsnList elseCode;
    
    public IfElseBuilder(@NotNull final MethodNode methodNode) {
        Intrinsics.checkNotNullParameter((Object)methodNode, "methodNode");
        this.methodNode = methodNode;
        this.ifCode = new InsnList();
        this.elseCode = new InsnList();
    }
    
    @NotNull
    public final MethodNode getMethodNode() {
        return this.methodNode;
    }
    
    @NotNull
    public final InsnList getIfCode() {
        return this.ifCode;
    }
    
    public final void setIfCode(@NotNull final InsnList <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.ifCode = <set-?>;
    }
    
    @NotNull
    public final InsnList getElseCode() {
        return this.elseCode;
    }
    
    public final void setElseCode(@NotNull final InsnList <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.elseCode = <set-?>;
    }
    
    @NotNull
    public final IfElseBuilder ifCode(@NotNull final Function1<? super InsnListBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)builder, "builder");
        final IfElseBuilder $this$ifCode_u24lambda_u2d0 = this;
        final int n = 0;
        final InsnListBuilder insn = new InsnListBuilder($this$ifCode_u24lambda_u2d0.getMethodNode());
        builder.invoke((Object)insn);
        $this$ifCode_u24lambda_u2d0.setIfCode(insn.build());
        return this;
    }
    
    @NotNull
    public final IfElseBuilder elseCode(@NotNull final Function1<? super InsnListBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)builder, "builder");
        final IfElseBuilder $this$elseCode_u24lambda_u2d1 = this;
        final int n = 0;
        final InsnListBuilder insn = new InsnListBuilder($this$elseCode_u24lambda_u2d1.getMethodNode());
        builder.invoke((Object)insn);
        $this$elseCode_u24lambda_u2d1.setElseCode(insn.build());
        return this;
    }
}
