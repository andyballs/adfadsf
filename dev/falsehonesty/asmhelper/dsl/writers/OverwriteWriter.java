//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.writers;

import dev.falsehonesty.asmhelper.dsl.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.*;
import java.util.*;
import dev.falsehonesty.asmhelper.remapping.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import kotlin.collections.*;
import dev.falsehonesty.asmhelper.dsl.code.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017Bj\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/OverwriteWriter;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "className", "", "methodName", "methodDesc", "insnListBuilder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "codeBlockClassName", "fieldMaps", "", "methodMaps", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "overwriteMethod", "method", "Lorg/objectweb/asm/tree/MethodNode;", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "toString", "transform", "Builder", "AsmHelper1.8.9" })
public final class OverwriteWriter extends AsmWriter
{
    @NotNull
    private final String methodName;
    @NotNull
    private final String methodDesc;
    @Nullable
    private final Function1<InsnListBuilder, Unit> insnListBuilder;
    @Nullable
    private final String codeBlockClassName;
    @NotNull
    private final Map<String, String> fieldMaps;
    @NotNull
    private final Map<String, String> methodMaps;
    
    public OverwriteWriter(@NotNull final String className, @NotNull final String methodName, @NotNull final String methodDesc, @Nullable final Function1<? super InsnListBuilder, Unit> insnListBuilder, @Nullable final String codeBlockClassName, @NotNull final Map<String, String> fieldMaps, @NotNull final Map<String, String> methodMaps) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
        Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
        Intrinsics.checkNotNullParameter((Object)fieldMaps, "fieldMaps");
        Intrinsics.checkNotNullParameter((Object)methodMaps, "methodMaps");
        super(className);
        this.methodName = methodName;
        this.methodDesc = methodDesc;
        this.insnListBuilder = (Function1<InsnListBuilder, Unit>)insnListBuilder;
        this.codeBlockClassName = codeBlockClassName;
        this.fieldMaps = fieldMaps;
        this.methodMaps = methodMaps;
    }
    
    public void transform(@NotNull final ClassNode classNode) {
        Intrinsics.checkNotNullParameter((Object)classNode, "classNode");
        AsmHelper.INSTANCE.setFieldMaps$AsmHelper1_8_9((Map)this.fieldMaps);
        AsmHelper.INSTANCE.setMethodMaps$AsmHelper1_8_9((Map)this.methodMaps);
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
                        this.overwriteMethod(it2, classNode);
                    }
                    return;
                }
            }
            final MethodNode methodNode = null;
            continue;
        }
    }
    
    private final void overwriteMethod(final MethodNode method, final ClassNode classNode) {
        method.instructions.clear();
        method.exceptions.clear();
        method.tryCatchBlocks.clear();
        final InsnList transformToInstructions = this.transformToInstructions((Function1)this.insnListBuilder, this.codeBlockClassName, method, classNode);
        if (transformToInstructions == null) {
            return;
        }
        final InsnList instructions = transformToInstructions;
        method.maxLocals = Type.getArgumentTypes(method.desc).length + (((method.access & 0x8) == 0x0) ? 1 : 0);
        method.instructions.add(instructions);
    }
    
    @NotNull
    public String toString() {
        return "OverwriteWriter{className=" + this.getClassName() + ", methodName=" + this.methodName + '}';
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u001f\u0010 \u001a\u00020\u00132\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014J\u001f\u0010#\u001a\u00020\u00132\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011¢\u0006\u0002\b\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006%" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/OverwriteWriter$Builder;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter$AsmWriterBuilder;", "()V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "codeBlockClassName", "fieldMaps", "", "getFieldMaps", "()Ljava/util/Map;", "setFieldMaps", "(Ljava/util/Map;)V", "insnListBuilder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "methodDesc", "getMethodDesc", "setMethodDesc", "methodMaps", "getMethodMaps", "setMethodMaps", "methodName", "getMethodName", "setMethodName", "build", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "codeBlock", "code", "Ldev/falsehonesty/asmhelper/dsl/code/CodeBlock;", "insnList", "config", "AsmHelper1.8.9" })
    public static final class Builder extends AsmWriterBuilder
    {
        public String className;
        public String methodName;
        public String methodDesc;
        @Nullable
        private Function1<? super InsnListBuilder, Unit> insnListBuilder;
        @Nullable
        private String codeBlockClassName;
        @NotNull
        private Map<String, String> fieldMaps;
        @NotNull
        private Map<String, String> methodMaps;
        
        public Builder() {
            this.fieldMaps = (Map<String, String>)MapsKt.emptyMap();
            this.methodMaps = (Map<String, String>)MapsKt.emptyMap();
        }
        
        @NotNull
        public final String getClassName() {
            final String className = this.className;
            if (className != null) {
                return className;
            }
            Intrinsics.throwUninitializedPropertyAccessException("className");
            throw null;
        }
        
        public final void setClassName(@NotNull final String <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.className = <set-?>;
        }
        
        @NotNull
        public final String getMethodName() {
            final String methodName = this.methodName;
            if (methodName != null) {
                return methodName;
            }
            Intrinsics.throwUninitializedPropertyAccessException("methodName");
            throw null;
        }
        
        public final void setMethodName(@NotNull final String <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.methodName = <set-?>;
        }
        
        @NotNull
        public final String getMethodDesc() {
            final String methodDesc = this.methodDesc;
            if (methodDesc != null) {
                return methodDesc;
            }
            Intrinsics.throwUninitializedPropertyAccessException("methodDesc");
            throw null;
        }
        
        public final void setMethodDesc(@NotNull final String <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.methodDesc = <set-?>;
        }
        
        @NotNull
        public final Map<String, String> getFieldMaps() {
            return this.fieldMaps;
        }
        
        public final void setFieldMaps(@NotNull final Map<String, String> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.fieldMaps = <set-?>;
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
            return new OverwriteWriter(this.getClassName(), this.getMethodName(), this.getMethodDesc(), this.insnListBuilder, this.codeBlockClassName, this.fieldMaps, this.methodMaps);
        }
        
        public final void insnList(@NotNull final Function1<? super InsnListBuilder, Unit> config) {
            Intrinsics.checkNotNullParameter((Object)config, "config");
            this.insnListBuilder = config;
        }
        
        public final void codeBlock(@NotNull final Function1<? super CodeBlock, Unit> code) {
            Intrinsics.checkNotNullParameter((Object)code, "code");
            this.codeBlockClassName = Intrinsics.stringPlus(code.getClass().getName(), (Object)"$1");
        }
    }
}
