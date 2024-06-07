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
import dev.falsehonesty.asmhelper.printing.*;
import java.util.*;
import dev.falsehonesty.asmhelper.remapping.*;
import org.objectweb.asm.tree.*;
import kotlin.collections.*;
import dev.falsehonesty.asmhelper.dsl.code.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eBr\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0019\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\b\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\b\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/InjectWriter;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "className", "", "methodName", "methodDesc", "at", "Ldev/falsehonesty/asmhelper/dsl/At;", "insnListBuilder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "codeBlockClassName", "fieldMaps", "", "methodMaps", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/falsehonesty/asmhelper/dsl/At;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "injectInsnList", "method", "Lorg/objectweb/asm/tree/MethodNode;", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "insertToNode", "node", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "insnList", "Lorg/objectweb/asm/tree/InsnList;", "toString", "transform", "Builder", "AsmHelper1.8.9" })
public final class InjectWriter extends AsmWriter
{
    @NotNull
    private final String methodName;
    @NotNull
    private final String methodDesc;
    @NotNull
    private final At at;
    @Nullable
    private final Function1<InsnListBuilder, Unit> insnListBuilder;
    @Nullable
    private final String codeBlockClassName;
    @NotNull
    private final Map<String, String> fieldMaps;
    @NotNull
    private final Map<String, String> methodMaps;
    
    public InjectWriter(@NotNull final String className, @NotNull final String methodName, @NotNull final String methodDesc, @NotNull final At at, @Nullable final Function1<? super InsnListBuilder, Unit> insnListBuilder, @Nullable final String codeBlockClassName, @NotNull final Map<String, String> fieldMaps, @NotNull final Map<String, String> methodMaps) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
        Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
        Intrinsics.checkNotNullParameter((Object)at, "at");
        Intrinsics.checkNotNullParameter((Object)fieldMaps, "fieldMaps");
        Intrinsics.checkNotNullParameter((Object)methodMaps, "methodMaps");
        super(className);
        this.methodName = methodName;
        this.methodDesc = methodDesc;
        this.at = at;
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
                    Unit instance;
                    if (methodNode2 == null) {
                        instance = null;
                    }
                    else {
                        final MethodNode it2 = methodNode2;
                        final int n2 = 0;
                        this.injectInsnList(it2, classNode);
                        instance = Unit.INSTANCE;
                    }
                    if (instance == null) {
                        PrintingKt.getLogger().error(Intrinsics.stringPlus("No methods found for target ", (Object)this.methodName));
                    }
                    return;
                }
            }
            final MethodNode methodNode = null;
            continue;
        }
    }
    
    private final void injectInsnList(final MethodNode method, final ClassNode classNode) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        dev/falsehonesty/asmhelper/dsl/writers/InjectWriter.at:Ldev/falsehonesty/asmhelper/dsl/At;
        //     4: aload_1         /* method */
        //     5: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getTargetedNodes:(Lorg/objectweb/asm/tree/MethodNode;)Ljava/util/List;
        //     8: astore_3        /* nodes */
        //     9: aload_0         /* this */
        //    10: aload_0         /* this */
        //    11: getfield        dev/falsehonesty/asmhelper/dsl/writers/InjectWriter.insnListBuilder:Lkotlin/jvm/functions/Function1;
        //    14: aload_0         /* this */
        //    15: getfield        dev/falsehonesty/asmhelper/dsl/writers/InjectWriter.codeBlockClassName:Ljava/lang/String;
        //    18: aload_1         /* method */
        //    19: aload_2         /* classNode */
        //    20: invokevirtual   dev/falsehonesty/asmhelper/dsl/writers/InjectWriter.transformToInstructions:(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lorg/objectweb/asm/tree/MethodNode;Lorg/objectweb/asm/tree/ClassNode;)Lorg/objectweb/asm/tree/InsnList;
        //    23: astore          5
        //    25: aload           5
        //    27: ifnonnull       31
        //    30: return         
        //    31: aload           5
        //    33: astore          instructions
        //    35: aload_3         /* nodes */
        //    36: invokeinterface java/util/List.isEmpty:()Z
        //    41: ifeq            61
        //    44: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.getLogger:()Lorg/apache/logging/log4j/Logger;
        //    47: ldc             "Couldn't find any matching nodes for "
        //    49: aload_0         /* this */
        //    50: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //    53: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;)V
        //    58: goto            97
        //    61: new             Ljava/lang/StringBuilder;
        //    64: dup            
        //    65: invokespecial   java/lang/StringBuilder.<init>:()V
        //    68: aload_0         /* this */
        //    69: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    72: ldc             " matched the following "
        //    74: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    77: aload_3         /* nodes */
        //    78: invokeinterface java/util/List.size:()I
        //    83: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    86: ldc             " targets"
        //    88: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    91: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    94: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.verbose:(Ljava/lang/String;)V
        //    97: aload_3         /* nodes */
        //    98: checkcast       Ljava/lang/Iterable;
        //   101: astore          $this$forEachIndexed$iv
        //   103: iconst_0       
        //   104: istore          $i$f$forEachIndexed
        //   106: iconst_0       
        //   107: istore          index$iv
        //   109: aload           $this$forEachIndexed$iv
        //   111: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   116: astore          8
        //   118: aload           8
        //   120: invokeinterface java/util/Iterator.hasNext:()Z
        //   125: ifeq            214
        //   128: aload           8
        //   130: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   135: astore          item$iv
        //   137: iload           index$iv
        //   139: iinc            index$iv, 1
        //   142: istore          10
        //   144: iconst_0       
        //   145: istore          11
        //   147: iload           10
        //   149: ifge            155
        //   152: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //   155: iload           10
        //   157: aload           item$iv
        //   159: checkcast       Lorg/objectweb/asm/tree/AbstractInsnNode;
        //   162: astore          12
        //   164: istore          i
        //   166: iconst_0       
        //   167: istore          $i$a$-forEachIndexed-InjectWriter$injectInsnList$1
        //   169: new             Ljava/lang/StringBuilder;
        //   172: dup            
        //   173: invokespecial   java/lang/StringBuilder.<init>:()V
        //   176: iload           i
        //   178: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   181: ldc_w           ".    "
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: aload           node
        //   189: invokestatic    dev/falsehonesty/asmhelper/printing/PrettyprintingKt.prettyString:(Lorg/objectweb/asm/tree/AbstractInsnNode;)Ljava/lang/String;
        //   192: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   195: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   198: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.verbose:(Ljava/lang/String;)V
        //   201: aload_0         /* this */
        //   202: aload_1         /* method */
        //   203: aload           node
        //   205: aload           instructions
        //   207: invokespecial   dev/falsehonesty/asmhelper/dsl/writers/InjectWriter.insertToNode:(Lorg/objectweb/asm/tree/MethodNode;Lorg/objectweb/asm/tree/AbstractInsnNode;Lorg/objectweb/asm/tree/InsnList;)V
        //   210: nop            
        //   211: goto            118
        //   214: nop            
        //   215: return         
        //    StackMapTable: 00 06 FE 00 1F 07 00 D5 00 07 00 D7 FF 00 1D 00 06 07 00 02 07 00 81 07 00 66 07 00 D5 07 00 D7 07 00 D7 00 00 23 FF 00 14 00 09 07 00 02 07 00 81 07 00 66 07 00 D5 07 00 D7 07 00 71 01 01 07 00 77 00 00 FE 00 24 07 00 A8 01 01 F8 00 3A
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final void insertToNode(final MethodNode method, final AbstractInsnNode node, final InsnList insnList) {
        Object target = null;
        target = node;
        if (this.at.getShift() < 0) {
            for (int n = -this.at.getShift(), i = 0; i < n; ++i) {
                final int it = i;
                final int n2 = 0;
                final AbstractInsnNode previous = ((AbstractInsnNode)target).getPrevious();
                Intrinsics.checkNotNullExpressionValue((Object)previous, "target.previous");
                target = previous;
            }
        }
        else if (this.at.getShift() > 0) {
            for (int shift = this.at.getShift(), j = 0; j < shift; ++j) {
                final int it = j;
                final int n3 = 0;
                final AbstractInsnNode next = ((AbstractInsnNode)target).getNext();
                Intrinsics.checkNotNullExpressionValue((Object)next, "target.next");
                target = next;
            }
        }
        if (this.at.getBefore()) {
            method.instructions.insertBefore((AbstractInsnNode)target, insnList);
        }
        else {
            method.instructions.insert((AbstractInsnNode)target, insnList);
        }
    }
    
    @NotNull
    public String toString() {
        return "InjectWriter{className=" + this.getClassName() + ", methodName=" + this.methodName + ", methodDesc=" + this.methodDesc + ", at=" + this.at + '}';
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\u001f\u0010&\u001a\u00020\u00192\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aJ\u001f\u0010)\u001a\u00020\u00192\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017¢\u0006\u0002\b\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001a\u0010!\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006+" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/InjectWriter$Builder;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter$AsmWriterBuilder;", "()V", "at", "Ldev/falsehonesty/asmhelper/dsl/At;", "getAt", "()Ldev/falsehonesty/asmhelper/dsl/At;", "setAt", "(Ldev/falsehonesty/asmhelper/dsl/At;)V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "codeBlockClassName", "fieldMaps", "", "getFieldMaps", "()Ljava/util/Map;", "setFieldMaps", "(Ljava/util/Map;)V", "insnListBuilder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "", "Lkotlin/ExtensionFunctionType;", "methodDesc", "getMethodDesc", "setMethodDesc", "methodMaps", "getMethodMaps", "setMethodMaps", "methodName", "getMethodName", "setMethodName", "build", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "codeBlock", "code", "Ldev/falsehonesty/asmhelper/dsl/code/CodeBlock;", "insnList", "config", "AsmHelper1.8.9" })
    public static final class Builder extends AsmWriterBuilder
    {
        public String className;
        public String methodName;
        public String methodDesc;
        public At at;
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
        public final At getAt() {
            final At at = this.at;
            if (at != null) {
                return at;
            }
            Intrinsics.throwUninitializedPropertyAccessException("at");
            throw null;
        }
        
        public final void setAt(@NotNull final At <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.at = <set-?>;
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
            return new InjectWriter(this.getClassName(), this.getMethodName(), this.getMethodDesc(), this.getAt(), this.insnListBuilder, this.codeBlockClassName, this.fieldMaps, this.methodMaps);
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
