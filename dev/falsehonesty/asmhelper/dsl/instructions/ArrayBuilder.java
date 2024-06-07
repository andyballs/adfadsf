//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0007\u001a\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bJ)\u0010\f\u001a\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u001f\u0010\u000e\u001a\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bJ\u001f\u0010\u000f\u001a\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bJ\u001f\u0010\u0010\u001a\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bJ\u001f\u0010\u0011\u001a\u00020\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/ArrayBuilder;", "", "insns", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "(Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;)V", "currentIndex", "", "aadd", "code", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "add", "opcode", "badd", "cadd", "dadd", "fadd", "AsmHelper1.8.9" })
public final class ArrayBuilder
{
    @NotNull
    private final InsnListBuilder insns;
    private int currentIndex;
    
    public ArrayBuilder(@NotNull final InsnListBuilder insns) {
        Intrinsics.checkNotNullParameter((Object)insns, "insns");
        this.insns = insns;
    }
    
    @NotNull
    public final ArrayBuilder aadd(@NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final ArrayBuilder $this$aadd_u24lambda_u2d0 = this;
        final int n = 0;
        $this$aadd_u24lambda_u2d0.add(code, 83);
        return this;
    }
    
    @NotNull
    public final ArrayBuilder badd(@NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final ArrayBuilder $this$badd_u24lambda_u2d1 = this;
        final int n = 0;
        $this$badd_u24lambda_u2d1.add(code, 84);
        return this;
    }
    
    @NotNull
    public final ArrayBuilder cadd(@NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final ArrayBuilder $this$cadd_u24lambda_u2d2 = this;
        final int n = 0;
        $this$cadd_u24lambda_u2d2.add(code, 85);
        return this;
    }
    
    @NotNull
    public final ArrayBuilder dadd(@NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final ArrayBuilder $this$dadd_u24lambda_u2d3 = this;
        final int n = 0;
        $this$dadd_u24lambda_u2d3.add(code, 82);
        return this;
    }
    
    @NotNull
    public final ArrayBuilder fadd(@NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final ArrayBuilder $this$fadd_u24lambda_u2d4 = this;
        final int n = 0;
        $this$fadd_u24lambda_u2d4.add(code, 81);
        return this;
    }
    
    private final ArrayBuilder add(final Function1<? super InsnListBuilder, Unit> code, final int opcode) {
        final ArrayBuilder $this$add_u24lambda_u2d5 = this;
        final int n = 0;
        $this$add_u24lambda_u2d5.insns.dup();
        $this$add_u24lambda_u2d5.insns.int($this$add_u24lambda_u2d5.currentIndex++);
        code.invoke((Object)$this$add_u24lambda_u2d5.insns);
        $this$add_u24lambda_u2d5.insns.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(opcode));
        return this;
    }
}
