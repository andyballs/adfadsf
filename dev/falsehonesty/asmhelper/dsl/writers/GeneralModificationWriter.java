//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.writers;

import dev.falsehonesty.asmhelper.dsl.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import dev.falsehonesty.asmhelper.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016R\u001f\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/GeneralModificationWriter;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "className", "", "modifyAction", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/writers/GeneralModificationWriter$GeneralModificationDSL;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "toString", "transform", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "GeneralModificationDSL", "AsmHelper1.8.9" })
public final class GeneralModificationWriter extends AsmWriter
{
    @NotNull
    private final Function1<GeneralModificationDSL, Unit> modifyAction;
    
    public GeneralModificationWriter(@NotNull final String className, @NotNull final Function1<? super GeneralModificationDSL, Unit> modifyAction) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)modifyAction, "modifyAction");
        super(className);
        this.modifyAction = (Function1<GeneralModificationDSL, Unit>)modifyAction;
    }
    
    public void transform(@NotNull final ClassNode classNode) {
        Intrinsics.checkNotNullParameter((Object)classNode, "classNode");
        this.modifyAction.invoke((Object)new GeneralModificationDSL(this.getClassName(), classNode));
    }
    
    @NotNull
    public String toString() {
        return "ModifyWriter{className=" + this.getClassName() + '}';
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\u0016\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003J\u0016\u00107\u001a\u0002062\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003J\u0016\u00108\u001a\u0002062\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\u0016\u00109\u001a\u0002062\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\u001e\u0010:\u001a\u0002062\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\bJ\u001e\u0010<\u001a\u0002062\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\bR\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0014\u0010\u001d\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0014\u0010\u001f\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0014\u0010!\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\nR\u0014\u0010#\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\nR\u0014\u0010'\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\nR\u0014\u0010)\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\nR\u0014\u0010+\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\n¨\u0006=" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/GeneralModificationWriter$GeneralModificationDSL;", "", "className", "", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "(Ljava/lang/String;Lorg/objectweb/asm/tree/ClassNode;)V", "abstract", "", "getAbstract", "()I", "annotation", "getAnnotation", "getClassName", "()Ljava/lang/String;", "getClassNode", "()Lorg/objectweb/asm/tree/ClassNode;", "enum", "getEnum", "final", "getFinal", "interface_", "getInterface_", "native", "getNative", "private", "getPrivate", "protected", "getProtected", "public", "getPublic", "static", "getStatic", "strict", "getStrict", "super_", "getSuper_", "synchronized", "getSynchronized", "synthetic", "getSynthetic", "transient", "getTransient", "volatile", "getVolatile", "findField", "Lorg/objectweb/asm/tree/FieldNode;", "fieldName", "fieldDesc", "findMethod", "Lorg/objectweb/asm/tree/MethodNode;", "methodName", "methodDesc", "makeFieldNonFinal", "", "makeFieldPublic", "makeMethodNonFinal", "makeMethodPublic", "setFieldAccess", "visibility", "setMethodAccess", "AsmHelper1.8.9" })
    public static final class GeneralModificationDSL
    {
        @NotNull
        private final String className;
        @NotNull
        private final ClassNode classNode;
        private final int public;
        private final int private;
        private final int protected;
        private final int static;
        private final int final;
        private final int super_;
        private final int synchronized;
        private final int volatile;
        private final int transient;
        private final int native;
        private final int interface_;
        private final int abstract;
        private final int strict;
        private final int synthetic;
        private final int annotation;
        private final int enum;
        
        public GeneralModificationDSL(@NotNull final String className, @NotNull final ClassNode classNode) {
            Intrinsics.checkNotNullParameter((Object)className, "className");
            Intrinsics.checkNotNullParameter((Object)classNode, "classNode");
            this.className = className;
            this.classNode = classNode;
            this.public = 1;
            this.private = 1;
            this.protected = 1;
            this.static = 1;
            this.final = 1;
            this.super_ = 1;
            this.synchronized = 1;
            this.volatile = 1;
            this.transient = 1;
            this.native = 1;
            this.interface_ = 1;
            this.abstract = 1;
            this.strict = 1;
            this.synthetic = 1;
            this.annotation = 1;
            this.enum = 1;
        }
        
        @NotNull
        public final String getClassName() {
            return this.className;
        }
        
        @NotNull
        public final ClassNode getClassNode() {
            return this.classNode;
        }
        
        public final int getPublic() {
            return this.public;
        }
        
        public final int getPrivate() {
            return this.private;
        }
        
        public final int getProtected() {
            return this.protected;
        }
        
        public final int getStatic() {
            return this.static;
        }
        
        public final int getFinal() {
            return this.final;
        }
        
        public final int getSuper_() {
            return this.super_;
        }
        
        public final int getSynchronized() {
            return this.synchronized;
        }
        
        public final int getVolatile() {
            return this.volatile;
        }
        
        public final int getTransient() {
            return this.transient;
        }
        
        public final int getNative() {
            return this.native;
        }
        
        public final int getInterface_() {
            return this.interface_;
        }
        
        public final int getAbstract() {
            return this.abstract;
        }
        
        public final int getStrict() {
            return this.strict;
        }
        
        public final int getSynthetic() {
            return this.synthetic;
        }
        
        public final int getAnnotation() {
            return this.annotation;
        }
        
        public final int getEnum() {
            return this.enum;
        }
        
        public final void setFieldAccess(@NotNull final String fieldName, @NotNull final String fieldDesc, final int visibility) {
            Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
            Intrinsics.checkNotNullParameter((Object)fieldDesc, "fieldDesc");
            this.findField(fieldName, fieldDesc).access = visibility;
        }
        
        public final void setMethodAccess(@NotNull final String methodName, @NotNull final String methodDesc, final int visibility) {
            Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
            Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
            this.findMethod(methodName, methodDesc).access = visibility;
        }
        
        public final void makeFieldPublic(@NotNull final String fieldName, @NotNull final String fieldDesc) {
            Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
            Intrinsics.checkNotNullParameter((Object)fieldDesc, "fieldDesc");
            final FieldNode field = this.findField(fieldName, fieldDesc);
            field.access |= this.public;
            field.access &= ~(this.private | this.protected);
        }
        
        public final void makeFieldNonFinal(@NotNull final String fieldName, @NotNull final String fieldDesc) {
            Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
            Intrinsics.checkNotNullParameter((Object)fieldDesc, "fieldDesc");
            final FieldNode it = this.findField(fieldName, fieldDesc);
            final int n = 0;
            it.access &= ~this.getFinal();
        }
        
        public final void makeMethodPublic(@NotNull final String methodName, @NotNull final String methodDesc) {
            Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
            Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
            final MethodNode method = this.findMethod(methodName, methodDesc);
            method.access |= this.public;
            method.access &= ~(this.private | this.protected);
        }
        
        public final void makeMethodNonFinal(@NotNull final String methodName, @NotNull final String methodDesc) {
            Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
            Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
            final MethodNode it = this.findMethod(methodName, methodDesc);
            final int n = 0;
            it.access &= ~this.getFinal();
        }
        
        @NotNull
        public final FieldNode findField(@NotNull final String fieldName, @NotNull final String fieldDesc) {
            Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
            Intrinsics.checkNotNullParameter((Object)fieldDesc, "fieldDesc");
            final String mappedName = AsmHelper.INSTANCE.getRemapper().remapFieldName(this.className, fieldName, fieldDesc);
            final List fields = this.classNode.fields;
            Intrinsics.checkNotNullExpressionValue((Object)fields, "classNode.fields");
            final Iterable $this$firstOrNull$iv = fields;
            final int $i$f$firstOrNull = 0;
            while (true) {
                for (final Object element$iv : $this$firstOrNull$iv) {
                    final FieldNode it = (FieldNode)element$iv;
                    final int n = 0;
                    if (Intrinsics.areEqual((Object)it.name, (Object)mappedName)) {
                        final Object o = element$iv;
                        final FieldNode fieldNode = (FieldNode)o;
                        if (fieldNode == null) {
                            throw new IllegalArgumentException("No field named " + fieldName + " (" + mappedName + ") found in class " + this.className);
                        }
                        return fieldNode;
                    }
                }
                final Object o = null;
                continue;
            }
        }
        
        @NotNull
        public final MethodNode findMethod(@NotNull final String methodName, @NotNull final String methodDesc) {
            Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
            Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
            final String mappedName = AsmHelper.INSTANCE.getRemapper().remapMethodName(this.className, methodName, methodDesc);
            final List methods = this.classNode.methods;
            Intrinsics.checkNotNullExpressionValue((Object)methods, "classNode.methods");
            final Iterable $this$firstOrNull$iv = methods;
            final int $i$f$firstOrNull = 0;
            while (true) {
                for (final Object element$iv : $this$firstOrNull$iv) {
                    final MethodNode it = (MethodNode)element$iv;
                    final int n = 0;
                    if (Intrinsics.areEqual((Object)it.name, (Object)mappedName)) {
                        final Object o = element$iv;
                        final MethodNode methodNode = (MethodNode)o;
                        if (methodNode == null) {
                            throw new IllegalArgumentException("No field named " + methodName + " (" + mappedName + ") found in class " + this.className);
                        }
                        return methodNode;
                    }
                }
                final Object o = null;
                continue;
            }
        }
    }
}
