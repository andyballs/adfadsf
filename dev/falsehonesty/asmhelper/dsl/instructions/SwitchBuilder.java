//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import kotlin.jvm.functions.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fJ\u001f\u0010\u0017\u001a\u00020\u000b2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R-\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\b\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder;", "", "()V", "cases", "", "Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;", "getCases$AsmHelper1_8_9", "()Ljava/util/List;", "defaultCase", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "getDefaultCase$AsmHelper1_8_9", "()Lkotlin/jvm/functions/Function1;", "setDefaultCase$AsmHelper1_8_9", "(Lkotlin/jvm/functions/Function1;)V", "case", "index", "", "fallthrough", "", "builder", "default", "Case", "AsmHelper1.8.9" })
public final class SwitchBuilder
{
    @NotNull
    private final List<Case> cases;
    @Nullable
    private Function1<? super InsnListBuilder, Unit> defaultCase;
    
    public SwitchBuilder() {
        this.cases = new ArrayList<Case>();
    }
    
    @NotNull
    public final List<Case> getCases$AsmHelper1_8_9() {
        return this.cases;
    }
    
    @Nullable
    public final Function1<InsnListBuilder, Unit> getDefaultCase$AsmHelper1_8_9() {
        return (Function1<InsnListBuilder, Unit>)this.defaultCase;
    }
    
    public final void setDefaultCase$AsmHelper1_8_9(@Nullable final Function1<? super InsnListBuilder, Unit> <set-?>) {
        this.defaultCase = <set-?>;
    }
    
    public final void case(final int index, final boolean fallthrough, @NotNull final Function1<? super InsnListBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)builder, "builder");
        this.cases.add(new Case(index, fallthrough, builder));
    }
    
    public final void default(@NotNull final Function1<? super InsnListBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)builder, "builder");
        this.defaultCase = builder;
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\u001a\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u00c6\u0003J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\"\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;", "", "index", "", "fallthrough", "", "builder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(IZLkotlin/jvm/functions/Function1;)V", "getBuilder", "()Lkotlin/jvm/functions/Function1;", "getFallthrough", "()Z", "getIndex", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "AsmHelper1.8.9" })
    public static final class Case
    {
        private final int index;
        private final boolean fallthrough;
        @NotNull
        private final Function1<InsnListBuilder, Unit> builder;
        
        public Case(final int index, final boolean fallthrough, @NotNull final Function1<? super InsnListBuilder, Unit> builder) {
            Intrinsics.checkNotNullParameter((Object)builder, "builder");
            this.index = index;
            this.fallthrough = fallthrough;
            this.builder = (Function1<InsnListBuilder, Unit>)builder;
        }
        
        public final int getIndex() {
            return this.index;
        }
        
        public final boolean getFallthrough() {
            return this.fallthrough;
        }
        
        @NotNull
        public final Function1<InsnListBuilder, Unit> getBuilder() {
            return this.builder;
        }
        
        public final int component1() {
            return this.index;
        }
        
        public final boolean component2() {
            return this.fallthrough;
        }
        
        @NotNull
        public final Function1<InsnListBuilder, Unit> component3() {
            return this.builder;
        }
        
        @NotNull
        public final Case copy(final int index, final boolean fallthrough, @NotNull final Function1<? super InsnListBuilder, Unit> builder) {
            Intrinsics.checkNotNullParameter((Object)builder, "builder");
            return new Case(index, fallthrough, builder);
        }
        
        @NotNull
        @Override
        public String toString() {
            return "Case(index=" + this.index + ", fallthrough=" + this.fallthrough + ", builder=" + this.builder + ')';
        }
        
        @Override
        public int hashCode() {
            int result = Integer.hashCode(this.index);
            final int n = result * 31;
            int fallthrough;
            if ((fallthrough = (this.fallthrough ? 1 : 0)) != 0) {
                fallthrough = 1;
            }
            result = n + fallthrough;
            result = result * 31 + this.builder.hashCode();
            return result;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Case)) {
                return false;
            }
            final Case case1 = (Case)other;
            return this.index == case1.index && this.fallthrough == case1.fallthrough && Intrinsics.areEqual((Object)this.builder, (Object)case1.builder);
        }
    }
}
