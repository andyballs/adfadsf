//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl;

import kotlin.*;
import kotlin.jvm.internal.*;
import java.util.*;
import org.objectweb.asm.tree.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/At;", "", "value", "Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "before", "", "shift", "", "(Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;ZI)V", "getBefore", "()Z", "getShift", "()I", "getValue", "()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;", "component1", "component2", "component3", "copy", "equals", "other", "getTargetedNodes", "", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "method", "Lorg/objectweb/asm/tree/MethodNode;", "hashCode", "toString", "", "AsmHelper1.8.9" })
public final class At
{
    @NotNull
    private final InjectionPoint value;
    private final boolean before;
    private final int shift;
    
    public At(@NotNull final InjectionPoint value, final boolean before, final int shift) {
        Intrinsics.checkNotNullParameter((Object)value, "value");
        this.value = value;
        this.before = before;
        this.shift = shift;
    }
    
    @NotNull
    public final InjectionPoint getValue() {
        return this.value;
    }
    
    public final boolean getBefore() {
        return this.before;
    }
    
    public final int getShift() {
        return this.shift;
    }
    
    @NotNull
    public final List<AbstractInsnNode> getTargetedNodes(@NotNull final MethodNode method) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "method"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: getfield        dev/falsehonesty/asmhelper/dsl/At.value:Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //    10: astore_2       
        //    11: aload_2        
        //    12: instanceof      Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$HEAD;
        //    15: ifeq            31
        //    18: aload_1         /* method */
        //    19: getfield        org/objectweb/asm/tree/MethodNode.instructions:Lorg/objectweb/asm/tree/InsnList;
        //    22: invokevirtual   org/objectweb/asm/tree/InsnList.getFirst:()Lorg/objectweb/asm/tree/AbstractInsnNode;
        //    25: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //    28: goto            750
        //    31: aload_2        
        //    32: instanceof      Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$TAIL;
        //    35: ifeq            54
        //    38: aload_1         /* method */
        //    39: getfield        org/objectweb/asm/tree/MethodNode.instructions:Lorg/objectweb/asm/tree/InsnList;
        //    42: invokevirtual   org/objectweb/asm/tree/InsnList.getLast:()Lorg/objectweb/asm/tree/AbstractInsnNode;
        //    45: invokevirtual   org/objectweb/asm/tree/AbstractInsnNode.getPrevious:()Lorg/objectweb/asm/tree/AbstractInsnNode;
        //    48: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //    51: goto            750
        //    54: aload_2        
        //    55: instanceof      Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN;
        //    58: ifeq            259
        //    61: aload_1         /* method */
        //    62: getfield        org/objectweb/asm/tree/MethodNode.instructions:Lorg/objectweb/asm/tree/InsnList;
        //    65: invokevirtual   org/objectweb/asm/tree/InsnList.iterator:()Ljava/util/ListIterator;
        //    68: astore_3       
        //    69: aload_3        
        //    70: ldc             "method.instructions.iterator()"
        //    72: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    75: aload_3        
        //    76: checkcast       Ljava/util/Iterator;
        //    79: invokestatic    kotlin/sequences/SequencesKt.asSequence:(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;
        //    82: invokestatic    kotlin/sequences/SequencesKt.toList:(Lkotlin/sequences/Sequence;)Ljava/util/List;
        //    85: checkcast       Ljava/lang/Iterable;
        //    88: astore_3        /* $this$filter$iv */
        //    89: iconst_0       
        //    90: istore          $i$f$filter
        //    92: aload_3         /* $this$filter$iv */
        //    93: astore          5
        //    95: new             Ljava/util/ArrayList;
        //    98: dup            
        //    99: invokespecial   java/util/ArrayList.<init>:()V
        //   102: checkcast       Ljava/util/Collection;
        //   105: astore          destination$iv$iv
        //   107: iconst_0       
        //   108: istore          $i$f$filterTo
        //   110: aload           $this$filterTo$iv$iv
        //   112: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   117: astore          8
        //   119: aload           8
        //   121: invokeinterface java/util/Iterator.hasNext:()Z
        //   126: ifeq            196
        //   129: aload           8
        //   131: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   136: astore          element$iv$iv
        //   138: aload           element$iv$iv
        //   140: checkcast       Lorg/objectweb/asm/tree/AbstractInsnNode;
        //   143: astore          it
        //   145: iconst_0       
        //   146: istore          $i$a$-filter-At$getTargetedNodes$1
        //   148: aload           it
        //   150: invokevirtual   org/objectweb/asm/tree/AbstractInsnNode.getOpcode:()I
        //   153: istore          12
        //   155: sipush          172
        //   158: iload           12
        //   160: if_icmpgt       179
        //   163: iload           12
        //   165: sipush          177
        //   168: if_icmpgt       175
        //   171: iconst_1       
        //   172: goto            180
        //   175: iconst_0       
        //   176: goto            180
        //   179: iconst_0       
        //   180: ifeq            119
        //   183: aload           destination$iv$iv
        //   185: aload           element$iv$iv
        //   187: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   192: pop            
        //   193: goto            119
        //   196: aload           destination$iv$iv
        //   198: checkcast       Ljava/util/List;
        //   201: nop            
        //   202: astore_3        /* $this$filter$iv */
        //   203: iconst_0       
        //   204: istore          4
        //   206: iconst_0       
        //   207: istore          5
        //   209: aload_3        
        //   210: astore          it
        //   212: iconst_0       
        //   213: istore          $i$a$-let-At$getTargetedNodes$2
        //   215: aload_0         /* this */
        //   216: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getValue:()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   219: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN;
        //   222: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN.getOrdinal:()Ljava/lang/Integer;
        //   225: ifnull          254
        //   228: aload           it
        //   230: aload_0         /* this */
        //   231: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getValue:()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   234: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN;
        //   237: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$RETURN.getOrdinal:()Ljava/lang/Integer;
        //   240: invokevirtual   java/lang/Integer.intValue:()I
        //   243: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   248: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //   251: goto            256
        //   254: aload           it
        //   256: goto            750
        //   259: aload_2        
        //   260: instanceof      Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;
        //   263: ifeq            713
        //   266: aload_1         /* method */
        //   267: getfield        org/objectweb/asm/tree/MethodNode.instructions:Lorg/objectweb/asm/tree/InsnList;
        //   270: invokevirtual   org/objectweb/asm/tree/InsnList.iterator:()Ljava/util/ListIterator;
        //   273: astore_3       
        //   274: aload_3        
        //   275: ldc             "method.instructions.iterator()"
        //   277: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   280: aload_3        
        //   281: checkcast       Ljava/util/Iterator;
        //   284: invokestatic    kotlin/sequences/SequencesKt.asSequence:(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;
        //   287: invokestatic    kotlin/sequences/SequencesKt.toList:(Lkotlin/sequences/Sequence;)Ljava/util/List;
        //   290: checkcast       Ljava/lang/Iterable;
        //   293: astore_3        /* $this$filter$iv */
        //   294: iconst_0       
        //   295: istore          $i$f$filter
        //   297: aload_3         /* $this$filter$iv */
        //   298: astore          5
        //   300: new             Ljava/util/ArrayList;
        //   303: dup            
        //   304: invokespecial   java/util/ArrayList.<init>:()V
        //   307: checkcast       Ljava/util/Collection;
        //   310: astore          destination$iv$iv
        //   312: iconst_0       
        //   313: istore          $i$f$filterTo
        //   315: aload           $this$filterTo$iv$iv
        //   317: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   322: astore          8
        //   324: aload           8
        //   326: invokeinterface java/util/Iterator.hasNext:()Z
        //   331: ifeq            620
        //   334: aload           8
        //   336: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   341: astore          element$iv$iv
        //   343: aload           element$iv$iv
        //   345: checkcast       Lorg/objectweb/asm/tree/AbstractInsnNode;
        //   348: astore          it
        //   350: iconst_0       
        //   351: istore          $i$a$-filter-At$getTargetedNodes$3
        //   353: aload_0         /* this */
        //   354: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getValue:()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   357: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;
        //   360: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE.getDescriptor:()Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;
        //   363: astore          descriptor
        //   365: aload           it
        //   367: instanceof      Lorg/objectweb/asm/tree/MethodInsnNode;
        //   370: ifeq            602
        //   373: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   376: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getRemapper:()Ldev/falsehonesty/asmhelper/remapping/Remapper;
        //   379: aload           it
        //   381: checkcast       Lorg/objectweb/asm/tree/MethodInsnNode;
        //   384: getfield        org/objectweb/asm/tree/MethodInsnNode.owner:Ljava/lang/String;
        //   387: astore          13
        //   389: aload           13
        //   391: ldc             "it.owner"
        //   393: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   396: aload           13
        //   398: aload           it
        //   400: checkcast       Lorg/objectweb/asm/tree/MethodInsnNode;
        //   403: getfield        org/objectweb/asm/tree/MethodInsnNode.name:Ljava/lang/String;
        //   406: astore          13
        //   408: aload           13
        //   410: ldc             "it.name"
        //   412: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   415: aload           13
        //   417: aload           it
        //   419: checkcast       Lorg/objectweb/asm/tree/MethodInsnNode;
        //   422: getfield        org/objectweb/asm/tree/MethodInsnNode.desc:Ljava/lang/String;
        //   425: astore          13
        //   427: aload           13
        //   429: ldc             "it.desc"
        //   431: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   434: aload           13
        //   436: invokeinterface dev/falsehonesty/asmhelper/remapping/Remapper.remapMethodName:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   441: astore          remappedName
        //   443: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   446: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getRemapper:()Ldev/falsehonesty/asmhelper/remapping/Remapper;
        //   449: aload           it
        //   451: checkcast       Lorg/objectweb/asm/tree/MethodInsnNode;
        //   454: getfield        org/objectweb/asm/tree/MethodInsnNode.desc:Ljava/lang/String;
        //   457: astore          15
        //   459: aload           15
        //   461: ldc             "it.desc"
        //   463: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   466: aload           15
        //   468: invokeinterface dev/falsehonesty/asmhelper/remapping/Remapper.remapDesc:(Ljava/lang/String;)Ljava/lang/String;
        //   473: astore          remappedDesc
        //   475: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   478: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getRemapper:()Ldev/falsehonesty/asmhelper/remapping/Remapper;
        //   481: aload           it
        //   483: checkcast       Lorg/objectweb/asm/tree/MethodInsnNode;
        //   486: getfield        org/objectweb/asm/tree/MethodInsnNode.owner:Ljava/lang/String;
        //   489: astore          16
        //   491: aload           16
        //   493: ldc             "it.owner"
        //   495: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   498: aload           16
        //   500: invokeinterface dev/falsehonesty/asmhelper/remapping/Remapper.remapClassName:(Ljava/lang/String;)Ljava/lang/String;
        //   505: astore          remappedClassName
        //   507: aload           remappedClassName
        //   509: aload           descriptor
        //   511: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/Descriptor.getOwner:()Ljava/lang/String;
        //   514: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   517: ifeq            598
        //   520: aload           remappedName
        //   522: aload           descriptor
        //   524: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/Descriptor.getName:()Ljava/lang/String;
        //   527: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   530: ifne            581
        //   533: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   536: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getMethodMaps$AsmHelper1_8_9:()Ljava/util/Map;
        //   539: aload           remappedName
        //   541: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   546: aload           descriptor
        //   548: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/Descriptor.getName:()Ljava/lang/String;
        //   551: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   554: ifne            581
        //   557: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   560: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getMethodMaps$AsmHelper1_8_9:()Ljava/util/Map;
        //   563: aload           descriptor
        //   565: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/Descriptor.getName:()Ljava/lang/String;
        //   568: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   573: aload           remappedName
        //   575: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   578: ifeq            598
        //   581: aload           remappedDesc
        //   583: aload           descriptor
        //   585: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/Descriptor.getDesc:()Ljava/lang/String;
        //   588: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   591: ifeq            598
        //   594: iconst_1       
        //   595: goto            603
        //   598: iconst_0       
        //   599: goto            603
        //   602: iconst_0       
        //   603: nop            
        //   604: ifeq            324
        //   607: aload           destination$iv$iv
        //   609: aload           element$iv$iv
        //   611: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   616: pop            
        //   617: goto            324
        //   620: aload           destination$iv$iv
        //   622: checkcast       Ljava/util/List;
        //   625: nop            
        //   626: astore_3        /* $this$filter$iv */
        //   627: iconst_0       
        //   628: istore          4
        //   630: iconst_0       
        //   631: istore          5
        //   633: aload_3        
        //   634: astore          it
        //   636: iconst_0       
        //   637: istore          $i$a$-let-At$getTargetedNodes$4
        //   639: aload_0         /* this */
        //   640: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getValue:()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   643: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;
        //   646: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE.getOrdinal:()Ljava/lang/Integer;
        //   649: ifnull          707
        //   652: aload_0         /* this */
        //   653: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getValue:()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   656: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;
        //   659: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE.getOrdinal:()Ljava/lang/Integer;
        //   662: invokevirtual   java/lang/Integer.intValue:()I
        //   665: aload           it
        //   667: invokeinterface java/util/List.size:()I
        //   672: if_icmplt       681
        //   675: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   678: goto            709
        //   681: aload           it
        //   683: aload_0         /* this */
        //   684: invokevirtual   dev/falsehonesty/asmhelper/dsl/At.getValue:()Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   687: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE;
        //   690: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$INVOKE.getOrdinal:()Ljava/lang/Integer;
        //   693: invokevirtual   java/lang/Integer.intValue:()I
        //   696: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   701: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //   704: goto            709
        //   707: aload           it
        //   709: nop            
        //   710: goto            750
        //   713: aload_2        
        //   714: instanceof      Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$CUSTOM;
        //   717: ifeq            742
        //   720: aload_0         /* this */
        //   721: getfield        dev/falsehonesty/asmhelper/dsl/At.value:Ldev/falsehonesty/asmhelper/dsl/InjectionPoint;
        //   724: checkcast       Ldev/falsehonesty/asmhelper/dsl/InjectionPoint$CUSTOM;
        //   727: invokevirtual   dev/falsehonesty/asmhelper/dsl/InjectionPoint$CUSTOM.getFinder:()Lkotlin/jvm/functions/Function1;
        //   730: aload_1         /* method */
        //   731: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   736: checkcast       Ljava/util/List;
        //   739: goto            750
        //   742: new             Lkotlin/NoWhenBranchMatchedException;
        //   745: dup            
        //   746: invokespecial   kotlin/NoWhenBranchMatchedException.<init>:()V
        //   749: athrow         
        //   750: areturn        
        //    Signature:
        //  (Lorg/objectweb/asm/tree/MethodNode;)Ljava/util/List<Lorg/objectweb/asm/tree/AbstractInsnNode;>;
        //    StackMapTable: 00 16 FC 00 1F 07 00 59 16 FF 00 40 00 09 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 00 00 FF 00 37 00 0D 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 07 00 04 07 00 60 01 01 00 00 03 40 01 FF 00 0F 00 09 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 00 00 FF 00 39 00 09 07 00 02 07 00 47 07 00 59 07 00 94 01 01 07 00 94 01 07 00 70 00 00 41 07 00 94 FF 00 02 00 03 07 00 02 07 00 47 07 00 59 00 00 FF 00 40 00 09 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 00 00 FF 01 00 00 11 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 07 00 04 07 00 60 01 07 00 D4 07 00 EA 07 00 EA 07 00 EA 07 00 EA 00 00 10 FF 00 03 00 0D 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 07 00 04 07 00 60 01 07 00 D4 00 00 40 01 FF 00 10 00 09 07 00 02 07 00 47 07 00 59 07 00 7C 01 07 00 7C 07 00 81 01 07 00 70 00 00 FF 00 3C 00 09 07 00 02 07 00 47 07 00 59 07 00 94 01 01 07 00 94 01 07 00 70 00 00 19 41 07 00 94 FF 00 03 00 03 07 00 02 07 00 47 07 00 59 00 00 1C 47 07 00 94
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public final InjectionPoint component1() {
        return this.value;
    }
    
    public final boolean component2() {
        return this.before;
    }
    
    public final int component3() {
        return this.shift;
    }
    
    @NotNull
    public final At copy(@NotNull final InjectionPoint value, final boolean before, final int shift) {
        Intrinsics.checkNotNullParameter((Object)value, "value");
        return new At(value, before, shift);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "At(value=" + this.value + ", before=" + this.before + ", shift=" + this.shift + ')';
    }
    
    @Override
    public int hashCode() {
        int result = this.value.hashCode();
        final int n = result * 31;
        int before;
        if ((before = (this.before ? 1 : 0)) != 0) {
            before = 1;
        }
        result = n + before;
        result = result * 31 + Integer.hashCode(this.shift);
        return result;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof At)) {
            return false;
        }
        final At at = (At)other;
        return Intrinsics.areEqual((Object)this.value, (Object)at.value) && this.before == at.before && this.shift == at.shift;
    }
}
