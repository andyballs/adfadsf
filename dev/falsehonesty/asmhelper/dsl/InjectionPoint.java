//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;
import kotlin.jvm.functions.*;
import java.util.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "", "()V", "CUSTOM", "HEAD", "INVOKE", "RETURN", "TAIL", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$HEAD;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$TAIL;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$CUSTOM;", "AsmHelper1.8.9" })
public abstract class InjectionPoint
{
    private InjectionPoint() {
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$HEAD;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "()V", "AsmHelper1.8.9" })
    public static final class HEAD extends InjectionPoint
    {
        @NotNull
        public static final HEAD INSTANCE;
        
        private HEAD() {
            super(null);
        }
        
        static {
            INSTANCE = new HEAD();
        }
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "ordinal", "", "(Ljava/lang/Integer;)V", "getOrdinal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN;", "equals", "", "other", "", "hashCode", "toString", "", "AsmHelper1.8.9" })
    public static final class RETURN extends InjectionPoint
    {
        @Nullable
        private final Integer ordinal;
        
        public RETURN(@Nullable final Integer ordinal) {
            super(null);
            this.ordinal = ordinal;
        }
        
        @Nullable
        public final Integer getOrdinal() {
            return this.ordinal;
        }
        
        @Nullable
        public final Integer component1() {
            return this.ordinal;
        }
        
        @NotNull
        public final RETURN copy(@Nullable final Integer ordinal) {
            return new RETURN(ordinal);
        }
        
        @NotNull
        @Override
        public String toString() {
            return "RETURN(ordinal=" + this.ordinal + ')';
        }
        
        @Override
        public int hashCode() {
            return (this.ordinal == null) ? 0 : this.ordinal.hashCode();
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            return this == other || (other instanceof RETURN && Intrinsics.areEqual((Object)this.ordinal, (Object)((RETURN)other).ordinal));
        }
        
        public RETURN() {
            this(null, 1, null);
        }
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "descriptor", "Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "ordinal", "", "(Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;Ljava/lang/Integer;)V", "getDescriptor", "()Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "getOrdinal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;Ljava/lang/Integer;)Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;", "equals", "", "other", "", "hashCode", "toString", "", "AsmHelper1.8.9" })
    public static final class INVOKE extends InjectionPoint
    {
        @NotNull
        private final Descriptor descriptor;
        @Nullable
        private final Integer ordinal;
        
        public INVOKE(@NotNull final Descriptor descriptor, @Nullable final Integer ordinal) {
            Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
            super(null);
            this.descriptor = descriptor;
            this.ordinal = ordinal;
        }
        
        @NotNull
        public final Descriptor getDescriptor() {
            return this.descriptor;
        }
        
        @Nullable
        public final Integer getOrdinal() {
            return this.ordinal;
        }
        
        @NotNull
        public final Descriptor component1() {
            return this.descriptor;
        }
        
        @Nullable
        public final Integer component2() {
            return this.ordinal;
        }
        
        @NotNull
        public final INVOKE copy(@NotNull final Descriptor descriptor, @Nullable final Integer ordinal) {
            Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
            return new INVOKE(descriptor, ordinal);
        }
        
        @NotNull
        @Override
        public String toString() {
            return "INVOKE(descriptor=" + this.descriptor + ", ordinal=" + this.ordinal + ')';
        }
        
        @Override
        public int hashCode() {
            int result = this.descriptor.hashCode();
            result = result * 31 + ((this.ordinal == null) ? 0 : this.ordinal.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof INVOKE)) {
                return false;
            }
            final INVOKE invoke = (INVOKE)other;
            return Intrinsics.areEqual((Object)this.descriptor, (Object)invoke.descriptor) && Intrinsics.areEqual((Object)this.ordinal, (Object)invoke.ordinal);
        }
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$TAIL;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "()V", "AsmHelper1.8.9" })
    public static final class TAIL extends InjectionPoint
    {
        @NotNull
        public static final TAIL INSTANCE;
        
        private TAIL() {
            super(null);
        }
        
        static {
            INSTANCE = new TAIL();
        }
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\u0010\u0007R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$CUSTOM;", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "finder", "Lkotlin/Function1;", "Lorg/objectweb/asm/tree/MethodNode;", "", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "(Lkotlin/jvm/functions/Function1;)V", "getFinder", "()Lkotlin/jvm/functions/Function1;", "AsmHelper1.8.9" })
    public static final class CUSTOM extends InjectionPoint
    {
        @NotNull
        private final Function1<MethodNode, List<AbstractInsnNode>> finder;
        
        public CUSTOM(@NotNull final Function1<? super MethodNode, ? extends List<? extends AbstractInsnNode>> finder) {
            Intrinsics.checkNotNullParameter((Object)finder, "finder");
            super(null);
            this.finder = (Function1<MethodNode, List<AbstractInsnNode>>)finder;
        }
        
        @NotNull
        public final Function1<MethodNode, List<AbstractInsnNode>> getFinder() {
            return this.finder;
        }
    }
}
