//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.writers;

import kotlin.*;
import dev.falsehonesty.asmhelper.dsl.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.*;
import java.util.*;
import dev.falsehonesty.asmhelper.remapping.*;
import org.objectweb.asm.tree.*;
import org.jetbrains.annotations.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/RemoveWriter;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "className", "", "methodName", "methodDesc", "at", "Ldev/falsehonesty/asmhelper/dsl/At;", "numberToRemove", "", "methodMaps", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/falsehonesty/asmhelper/dsl/At;ILjava/util/Map;)V", "removeInsns", "", "method", "Lorg/objectweb/asm/tree/MethodNode;", "toString", "transform", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "Builder", "AsmHelper1.8.9" })
public final class RemoveWriter extends AsmWriter
{
    @NotNull
    private final String methodName;
    @NotNull
    private final String methodDesc;
    @NotNull
    private final At at;
    private final int numberToRemove;
    @NotNull
    private final Map<String, String> methodMaps;
    
    public RemoveWriter(@NotNull final String className, @NotNull final String methodName, @NotNull final String methodDesc, @NotNull final At at, final int numberToRemove, @NotNull final Map<String, String> methodMaps) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
        Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
        Intrinsics.checkNotNullParameter((Object)at, "at");
        Intrinsics.checkNotNullParameter((Object)methodMaps, "methodMaps");
        super(className);
        this.methodName = methodName;
        this.methodDesc = methodDesc;
        this.at = at;
        this.numberToRemove = numberToRemove;
        this.methodMaps = methodMaps;
    }
    
    public void transform(@NotNull final ClassNode classNode) {
        Intrinsics.checkNotNullParameter((Object)classNode, "classNode");
        final List methods = classNode.methods;
        Intrinsics.checkNotNullExpressionValue((Object)methods, "classNode.methods");
        while (true) {
            for (final MethodNode next : (List<Object>)methods) {
                final MethodNode it = next;
                final int n = 0;
                final Remapper remapper = AsmHelper.INSTANCE.getRemapper();
                final String name = classNode.name;
                Intrinsics.checkNotNullExpressionValue((Object)name, "classNode.name");
                final String s = name;
                final String name2 = it.name;
                Intrinsics.checkNotNullExpressionValue((Object)name2, "it.name");
                final String s2 = name2;
                final String desc = it.desc;
                Intrinsics.checkNotNullExpressionValue((Object)desc, "it.desc");
                final String remapped = remapper.remapMethodName(s, s2, desc);
                final Remapper remapper2 = AsmHelper.INSTANCE.getRemapper();
                final String desc2 = it.desc;
                Intrinsics.checkNotNullExpressionValue((Object)desc2, "it.desc");
                final String remappedDesc = remapper2.remapDesc(desc2);
                if (Intrinsics.areEqual((Object)remappedDesc, (Object)this.methodDesc) && (Intrinsics.areEqual((Object)remapped, (Object)this.methodName) || Intrinsics.areEqual((Object)this.methodMaps.get(remapped), (Object)this.methodName))) {
                    final MethodNode methodNode = next;
                    final MethodNode methodNode2 = methodNode;
                    if (methodNode2 != null) {
                        final MethodNode it2 = methodNode2;
                        final int n2 = 0;
                        this.removeInsns(it2);
                    }
                    return;
                }
            }
            final MethodNode methodNode = null;
            continue;
        }
    }
    
    private final void removeInsns(final MethodNode method) {
        final List nodes = this.at.getTargetedNodes(method);
        final Iterable $this$forEach$iv = nodes;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final AbstractInsnNode node = (AbstractInsnNode)element$iv;
            final int n = 0;
            Object toDelete = null;
            toDelete = node;
            if (this.at.getShift() < 0) {
                for (int n2 = -this.at.getShift(), i = 0; i < n2; ++i) {
                    final int it = i;
                    final int n3 = 0;
                    final AbstractInsnNode previous = ((AbstractInsnNode)toDelete).getPrevious();
                    Intrinsics.checkNotNullExpressionValue((Object)previous, "toDelete.previous");
                    toDelete = previous;
                }
            }
            else if (this.at.getShift() > 0) {
                for (int shift = this.at.getShift(), j = 0; j < shift; ++j) {
                    final int it = j;
                    final int n4 = 0;
                    final AbstractInsnNode next = ((AbstractInsnNode)toDelete).getNext();
                    Intrinsics.checkNotNullExpressionValue((Object)next, "toDelete.next");
                    toDelete = next;
                }
            }
            for (int numberToRemove = this.numberToRemove, k = 0; k < numberToRemove; ++k) {
                final int it = k;
                final int n5 = 0;
                final AbstractInsnNode tmpNode = ((AbstractInsnNode)toDelete).getNext();
                method.instructions.remove((AbstractInsnNode)toDelete);
                final AbstractInsnNode abstractInsnNode = tmpNode;
                if (abstractInsnNode == null) {
                    break;
                }
                toDelete = abstractInsnNode;
            }
        }
    }
    
    @NotNull
    public String toString() {
        return "RemoveWriter{className=" + this.getClassName() + ",at=" + this.at + ",numToRem=" + this.numberToRemove + '}';
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/RemoveWriter$Builder;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter$AsmWriterBuilder;", "()V", "at", "Ldev/falsehonesty/asmhelper/dsl/At;", "getAt", "()Ldev/falsehonesty/asmhelper/dsl/At;", "setAt", "(Ldev/falsehonesty/asmhelper/dsl/At;)V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "methodDesc", "getMethodDesc", "setMethodDesc", "methodMaps", "", "getMethodMaps", "()Ljava/util/Map;", "setMethodMaps", "(Ljava/util/Map;)V", "methodName", "getMethodName", "setMethodName", "numberToRemove", "", "getNumberToRemove", "()I", "setNumberToRemove", "(I)V", "build", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "AsmHelper1.8.9" })
    public static final class Builder extends AsmWriterBuilder
    {
        @Nullable
        private String className;
        @Nullable
        private String methodName;
        @Nullable
        private String methodDesc;
        @Nullable
        private At at;
        private int numberToRemove;
        @NotNull
        private Map<String, String> methodMaps;
        
        public Builder() {
            this.numberToRemove = 1;
            this.methodMaps = (Map<String, String>)MapsKt.emptyMap();
        }
        
        @Nullable
        public final String getClassName() {
            return this.className;
        }
        
        public final void setClassName(@Nullable final String <set-?>) {
            this.className = <set-?>;
        }
        
        @Nullable
        public final String getMethodName() {
            return this.methodName;
        }
        
        public final void setMethodName(@Nullable final String <set-?>) {
            this.methodName = <set-?>;
        }
        
        @Nullable
        public final String getMethodDesc() {
            return this.methodDesc;
        }
        
        public final void setMethodDesc(@Nullable final String <set-?>) {
            this.methodDesc = <set-?>;
        }
        
        @Nullable
        public final At getAt() {
            return this.at;
        }
        
        public final void setAt(@Nullable final At <set-?>) {
            this.at = <set-?>;
        }
        
        public final int getNumberToRemove() {
            return this.numberToRemove;
        }
        
        public final void setNumberToRemove(final int <set-?>) {
            this.numberToRemove = <set-?>;
        }
        
        @NotNull
        public final Map<String, String> getMethodMaps() {
            return this.methodMaps;
        }
        
        public final void setMethodMaps(@NotNull final Map<String, String> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.methodMaps = <set-?>;
        }
        
        @NotNull
        public final AsmWriter build() throws IllegalStateException {
            final String className = this.className;
            if (className == null) {
                throw new IllegalStateException("className must NOT be null.");
            }
            final String className2 = className;
            final String methodName = this.methodName;
            if (methodName == null) {
                throw new IllegalStateException("methodName must NOT be null.");
            }
            final String methodName2 = methodName;
            final String methodDesc = this.methodDesc;
            if (methodDesc == null) {
                throw new IllegalStateException("methodDesc must NOT be null.");
            }
            final String methodDesc2 = methodDesc;
            final At at = this.at;
            if (at == null) {
                throw new IllegalStateException("at must NOT be null.");
            }
            return new RemoveWriter(className2, methodName2, methodDesc2, at, this.numberToRemove, this.methodMaps);
        }
    }
}
