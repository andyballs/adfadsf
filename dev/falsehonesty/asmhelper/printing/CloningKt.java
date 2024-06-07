//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.printing;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.util.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001b\u0010\u0003\u001a\u0013\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0002¨\u0006\u0007" }, d2 = { "clone", "", "Lorg/objectweb/asm/tree/InsnList;", "cloneLabels", "", "Lorg/objectweb/asm/tree/LabelNode;", "Lkotlin/internal/NoInfer;", "AsmHelper1.8.9" })
public final class CloningKt
{
    public static final void clone(@NotNull final InsnList $this$clone) {
        Intrinsics.checkNotNullParameter((Object)$this$clone, "<this>");
        final InsnList list = new InsnList();
        final int n = 0;
        final Map labels = cloneLabels($this$clone);
        final ListIterator iterator = $this$clone.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, "this.iterator()");
        final Iterator $this$forEach$iv = iterator;
        final int $i$f$forEach = 0;
        final Iterator iterator2 = $this$forEach$iv;
        while (iterator2.hasNext()) {
            final Object element$iv = iterator2.next();
            final AbstractInsnNode it = (AbstractInsnNode)element$iv;
            final int n2 = 0;
            list.add(it.clone(labels));
        }
    }
    
    @NotNull
    public static final Map<LabelNode, LabelNode> cloneLabels(@NotNull final InsnList $this$cloneLabels) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$cloneLabels */
        //     7: invokevirtual   org/objectweb/asm/tree/InsnList.toArray:()[Lorg/objectweb/asm/tree/AbstractInsnNode;
        //    10: astore_1       
        //    11: aload_1        
        //    12: ldc             "toArray()"
        //    14: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    17: aload_1        
        //    18: checkcast       [Ljava/lang/Object;
        //    21: invokestatic    kotlin/collections/ArraysKt.toList:([Ljava/lang/Object;)Ljava/util/List;
        //    24: checkcast       Ljava/lang/Iterable;
        //    27: astore_1       
        //    28: nop            
        //    29: iconst_0       
        //    30: istore_2        /* $i$f$filterIsInstance */
        //    31: aload_1         /* $this$filterIsInstance$iv */
        //    32: astore_3       
        //    33: new             Ljava/util/ArrayList;
        //    36: dup            
        //    37: invokespecial   java/util/ArrayList.<init>:()V
        //    40: checkcast       Ljava/util/Collection;
        //    43: astore          destination$iv$iv
        //    45: iconst_0       
        //    46: istore          $i$f$filterIsInstanceTo
        //    48: aload_3         /* $this$filterIsInstanceTo$iv$iv */
        //    49: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    54: astore          6
        //    56: aload           6
        //    58: invokeinterface java/util/Iterator.hasNext:()Z
        //    63: ifeq            96
        //    66: aload           6
        //    68: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    73: astore          element$iv$iv
        //    75: aload           element$iv$iv
        //    77: instanceof      Lorg/objectweb/asm/tree/LabelNode;
        //    80: ifeq            56
        //    83: aload           destination$iv$iv
        //    85: aload           element$iv$iv
        //    87: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    92: pop            
        //    93: goto            56
        //    96: aload           destination$iv$iv
        //    98: checkcast       Ljava/util/List;
        //   101: nop            
        //   102: checkcast       Ljava/lang/Iterable;
        //   105: astore_1       
        //   106: nop            
        //   107: iconst_0       
        //   108: istore_2        /* $i$f$associateWith */
        //   109: new             Ljava/util/LinkedHashMap;
        //   112: dup            
        //   113: aload_1         /* $this$associateWith$iv */
        //   114: bipush          10
        //   116: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   119: invokestatic    kotlin/collections/MapsKt.mapCapacity:(I)I
        //   122: bipush          16
        //   124: invokestatic    kotlin/ranges/RangesKt.coerceAtLeast:(II)I
        //   127: invokespecial   java/util/LinkedHashMap.<init>:(I)V
        //   130: astore_3        /* result$iv */
        //   131: aload_1         /* $this$associateWith$iv */
        //   132: astore          $this$associateWithTo$iv$iv
        //   134: iconst_0       
        //   135: istore          $i$f$associateWithTo
        //   137: aload           $this$associateWithTo$iv$iv
        //   139: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   144: astore          6
        //   146: aload           6
        //   148: invokeinterface java/util/Iterator.hasNext:()Z
        //   153: ifeq            209
        //   156: aload           6
        //   158: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   163: astore          element$iv$iv
        //   165: aload_3         /* result$iv */
        //   166: checkcast       Ljava/util/Map;
        //   169: aload           element$iv$iv
        //   171: aload           element$iv$iv
        //   173: checkcast       Lorg/objectweb/asm/tree/LabelNode;
        //   176: astore          8
        //   178: astore          11
        //   180: astore          10
        //   182: iconst_0       
        //   183: istore          $i$a$-associateWith-CloningKt$cloneLabels$1
        //   185: new             Lorg/objectweb/asm/tree/LabelNode;
        //   188: dup            
        //   189: invokespecial   org/objectweb/asm/tree/LabelNode.<init>:()V
        //   192: astore          12
        //   194: aload           10
        //   196: aload           11
        //   198: aload           12
        //   200: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   205: pop            
        //   206: goto            146
        //   209: aload_3         /* result$iv */
        //   210: checkcast       Ljava/util/Map;
        //   213: nop            
        //   214: areturn        
        //    Signature:
        //  (Lorg/objectweb/asm/tree/InsnList;)Ljava/util/Map<Lorg/objectweb/asm/tree/LabelNode;Lorg/objectweb/asm/tree/LabelNode;>;
        //    StackMapTable: 00 04 FF 00 38 00 07 07 00 23 07 00 66 01 07 00 66 07 00 6B 01 07 00 35 00 00 27 FF 00 31 00 07 07 00 23 07 00 66 01 07 00 77 07 00 66 01 07 00 35 00 00 3E
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
