//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.mozilla.javascript.*;
import kotlin.jvm.*;
import net.minecraft.nbt.*;
import java.util.*;
import kotlin.text.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u00060\u000bj\u0002`\f*\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT;", "", "()V", "numberNBTFormat", "Lkotlin/text/Regex;", "parse", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTBase;", "nbt", "options", "Lorg/mozilla/javascript/NativeObject;", "parseString", "Lnet/minecraft/nbt/NBTBase;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTBase;", "nbtData", "", "coerceNumericStrings", "", "toArray", "Lorg/mozilla/javascript/NativeArray;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagList;", "toObject", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound;", "toNBT", "ctjs" })
public final class NBT
{
    @NotNull
    public static final NBT INSTANCE;
    @NotNull
    private static final Regex numberNBTFormat;
    
    private NBT() {
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final NBTBase parse(@NotNull final Object nbt, @Nullable final NativeObject options) throws NBTException {
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        NBTBase nbtBase;
        if (nbt instanceof NativeObject) {
            nbtBase = new NBTTagCompound((net.minecraft.nbt.NBTTagCompound)NBT.INSTANCE.toNBT(nbt, options));
        }
        else if (nbt instanceof NativeArray) {
            final net.minecraft.nbt.NBTBase it = NBT.INSTANCE.toNBT(nbt, options);
            final int n = 0;
            nbtBase = ((it instanceof NBTTagList) ? ((com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList)new com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList((NBTTagList)it)) : new NBTBase(it));
        }
        else {
            nbtBase = new NBTBase(NBT.INSTANCE.toNBT(nbt, options));
        }
        return nbtBase;
    }
    
    public static /* synthetic */ NBTBase parse$default(final Object nbt, NativeObject options, final int n, final Object o) throws NBTException {
        if ((n & 0x2) != 0x0) {
            options = null;
        }
        return parse(nbt, options);
    }
    
    @JvmStatic
    @NotNull
    public static final NativeObject toObject(@NotNull final NBTTagCompound nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        return nbt.toObject();
    }
    
    @JvmStatic
    @NotNull
    public static final NativeArray toArray(@NotNull final com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagList nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        return nbt.toArray();
    }
    
    private final net.minecraft.nbt.NBTBase toNBT(final Object $this$toNBT, final NativeObject options) throws NBTException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "preferArraysOverLists"
        //     3: iconst_0       
        //     4: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //     7: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.getOption:(Lorg/mozilla/javascript/NativeObject;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //    10: invokestatic    java/lang/Boolean.parseBoolean:(Ljava/lang/String;)Z
        //    13: istore_3        /* preferArraysOverLists */
        //    14: aload_2         /* options */
        //    15: ldc             "coerceNumericStrings"
        //    17: iconst_0       
        //    18: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    21: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.getOption:(Lorg/mozilla/javascript/NativeObject;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //    24: invokestatic    java/lang/Boolean.parseBoolean:(Ljava/lang/String;)Z
        //    27: istore          coerceNumericStrings
        //    29: aload_1         /* $this$toNBT */
        //    30: astore          5
        //    32: aload           5
        //    34: instanceof      Lorg/mozilla/javascript/NativeObject;
        //    37: ifeq            191
        //    40: new             Lnet/minecraft/nbt/NBTTagCompound;
        //    43: dup            
        //    44: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //    47: astore          6
        //    49: aload           6
        //    51: astore          $this$toNBT_u24lambda_u2d2
        //    53: iconst_0       
        //    54: istore          $i$a$-apply-NBT$toNBT$1
        //    56: aload_1         /* $this$toNBT */
        //    57: checkcast       Lorg/mozilla/javascript/NativeObject;
        //    60: invokevirtual   org/mozilla/javascript/NativeObject.entrySet:()Ljava/util/Set;
        //    63: astore          9
        //    65: aload           9
        //    67: ldc             "entries"
        //    69: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    72: aload           9
        //    74: checkcast       Ljava/lang/Iterable;
        //    77: astore          $this$forEach$iv
        //    79: iconst_0       
        //    80: istore          $i$f$forEach
        //    82: aload           $this$forEach$iv
        //    84: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    89: astore          11
        //    91: aload           11
        //    93: invokeinterface java/util/Iterator.hasNext:()Z
        //    98: ifeq            181
        //   101: aload           11
        //   103: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   108: astore          element$iv
        //   110: aload           element$iv
        //   112: checkcast       Ljava/util/Map$Entry;
        //   115: astore          entry
        //   117: iconst_0       
        //   118: istore          $i$a$-forEach-NBT$toNBT$1$1
        //   120: aload           $this$toNBT_u24lambda_u2d2
        //   122: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //   125: astore          15
        //   127: aload           15
        //   129: ldc             "tagMap"
        //   131: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   134: aload           15
        //   136: aload           entry
        //   138: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   143: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   146: getstatic       com/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT;
        //   149: aload           entry
        //   151: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   156: astore          16
        //   158: aload           16
        //   160: ldc             "entry.value"
        //   162: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   165: aload           16
        //   167: aload_2         /* options */
        //   168: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT.toNBT:(Ljava/lang/Object;Lorg/mozilla/javascript/NativeObject;)Lnet/minecraft/nbt/NBTBase;
        //   171: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   176: pop            
        //   177: nop            
        //   178: goto            91
        //   181: nop            
        //   182: nop            
        //   183: aload           6
        //   185: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   188: goto            1093
        //   191: aload           5
        //   193: instanceof      Lorg/mozilla/javascript/NativeArray;
        //   196: ifeq            853
        //   199: aload_1         /* $this$toNBT */
        //   200: checkcast       Ljava/lang/Iterable;
        //   203: astore          $this$map$iv
        //   205: iconst_0       
        //   206: istore          $i$f$map
        //   208: aload           $this$map$iv
        //   210: astore          9
        //   212: new             Ljava/util/ArrayList;
        //   215: dup            
        //   216: aload           $this$map$iv
        //   218: bipush          10
        //   220: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   223: invokespecial   java/util/ArrayList.<init>:(I)V
        //   226: checkcast       Ljava/util/Collection;
        //   229: astore          destination$iv$iv
        //   231: iconst_0       
        //   232: istore          $i$f$mapTo
        //   234: aload           $this$mapTo$iv$iv
        //   236: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   241: astore          12
        //   243: aload           12
        //   245: invokeinterface java/util/Iterator.hasNext:()Z
        //   250: ifeq            304
        //   253: aload           12
        //   255: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   260: astore          item$iv$iv
        //   262: aload           destination$iv$iv
        //   264: aload           item$iv$iv
        //   266: astore          14
        //   268: astore          17
        //   270: iconst_0       
        //   271: istore          $i$a$-map-NBT$toNBT$normalized$1
        //   273: aload           it
        //   275: dup            
        //   276: ifnonnull       284
        //   279: pop            
        //   280: aconst_null    
        //   281: goto            292
        //   284: getstatic       com/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT;
        //   287: swap           
        //   288: aload_2         /* options */
        //   289: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT.toNBT:(Ljava/lang/Object;Lorg/mozilla/javascript/NativeObject;)Lnet/minecraft/nbt/NBTBase;
        //   292: aload           17
        //   294: swap           
        //   295: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   300: pop            
        //   301: goto            243
        //   304: aload           destination$iv$iv
        //   306: checkcast       Ljava/util/List;
        //   309: nop            
        //   310: astore          normalized
        //   312: iload_3         /* preferArraysOverLists */
        //   313: ifeq            326
        //   316: aload           normalized
        //   318: invokeinterface java/util/List.isEmpty:()Z
        //   323: ifeq            355
        //   326: new             Lnet/minecraft/nbt/NBTTagList;
        //   329: dup            
        //   330: invokespecial   net/minecraft/nbt/NBTTagList.<init>:()V
        //   333: astore          7
        //   335: aload           7
        //   337: astore          $this$toNBT_u24lambda_u2d4
        //   339: iconst_0       
        //   340: istore          $i$a$-apply-NBT$toNBT$2
        //   342: aload           $this$toNBT_u24lambda_u2d4
        //   344: aload           normalized
        //   346: putfield        net/minecraft/nbt/NBTTagList.tagList:Ljava/util/List;
        //   349: aload           7
        //   351: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   354: areturn        
        //   355: nop            
        //   356: aload           normalized
        //   358: checkcast       Ljava/lang/Iterable;
        //   361: astore          $this$all$iv
        //   363: iconst_0       
        //   364: istore          $i$f$all
        //   366: aload           $this$all$iv
        //   368: instanceof      Ljava/util/Collection;
        //   371: ifeq            391
        //   374: aload           $this$all$iv
        //   376: checkcast       Ljava/util/Collection;
        //   379: invokeinterface java/util/Collection.isEmpty:()Z
        //   384: ifeq            391
        //   387: iconst_1       
        //   388: goto            442
        //   391: aload           $this$all$iv
        //   393: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   398: astore          9
        //   400: aload           9
        //   402: invokeinterface java/util/Iterator.hasNext:()Z
        //   407: ifeq            441
        //   410: aload           9
        //   412: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   417: astore          element$iv
        //   419: aload           element$iv
        //   421: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   424: astore          it
        //   426: iconst_0       
        //   427: istore          $i$a$-all-NBT$toNBT$3
        //   429: aload           it
        //   431: instanceof      Lnet/minecraft/nbt/NBTTagByte;
        //   434: ifne            400
        //   437: iconst_0       
        //   438: goto            442
        //   441: iconst_1       
        //   442: ifeq            590
        //   445: aload           normalized
        //   447: checkcast       Ljava/lang/Iterable;
        //   450: astore          $this$map$iv
        //   452: iconst_0       
        //   453: istore          $i$f$map
        //   455: aload           $this$map$iv
        //   457: astore          9
        //   459: new             Ljava/util/ArrayList;
        //   462: dup            
        //   463: aload           $this$map$iv
        //   465: bipush          10
        //   467: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   470: invokespecial   java/util/ArrayList.<init>:(I)V
        //   473: checkcast       Ljava/util/Collection;
        //   476: astore          destination$iv$iv
        //   478: iconst_0       
        //   479: istore          $i$f$mapTo
        //   481: aload           $this$mapTo$iv$iv
        //   483: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   488: astore          12
        //   490: aload           12
        //   492: invokeinterface java/util/Iterator.hasNext:()Z
        //   497: ifeq            561
        //   500: aload           12
        //   502: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   507: astore          item$iv$iv
        //   509: aload           destination$iv$iv
        //   511: aload           item$iv$iv
        //   513: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   516: astore          14
        //   518: astore          18
        //   520: iconst_0       
        //   521: istore          $i$a$-map-NBT$toNBT$4
        //   523: aload           it
        //   525: dup            
        //   526: ifnonnull       540
        //   529: pop            
        //   530: new             Ljava/lang/NullPointerException;
        //   533: dup            
        //   534: ldc             "null cannot be cast to non-null type net.minecraft.nbt.NBTTagByte"
        //   536: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   539: athrow         
        //   540: checkcast       Lnet/minecraft/nbt/NBTTagByte;
        //   543: invokevirtual   net/minecraft/nbt/NBTTagByte.getByte:()B
        //   546: invokestatic    java/lang/Byte.valueOf:(B)Ljava/lang/Byte;
        //   549: aload           18
        //   551: swap           
        //   552: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   557: pop            
        //   558: goto            490
        //   561: aload           destination$iv$iv
        //   563: checkcast       Ljava/util/List;
        //   566: nop            
        //   567: checkcast       Ljava/util/Collection;
        //   570: invokestatic    kotlin/collections/CollectionsKt.toByteArray:(Ljava/util/Collection;)[B
        //   573: astore          19
        //   575: new             Lnet/minecraft/nbt/NBTTagByteArray;
        //   578: dup            
        //   579: aload           19
        //   581: invokespecial   net/minecraft/nbt/NBTTagByteArray.<init>:([B)V
        //   584: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   587: goto            852
        //   590: aload           normalized
        //   592: checkcast       Ljava/lang/Iterable;
        //   595: astore          $this$all$iv
        //   597: iconst_0       
        //   598: istore          $i$f$all
        //   600: aload           $this$all$iv
        //   602: instanceof      Ljava/util/Collection;
        //   605: ifeq            625
        //   608: aload           $this$all$iv
        //   610: checkcast       Ljava/util/Collection;
        //   613: invokeinterface java/util/Collection.isEmpty:()Z
        //   618: ifeq            625
        //   621: iconst_1       
        //   622: goto            676
        //   625: aload           $this$all$iv
        //   627: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   632: astore          9
        //   634: aload           9
        //   636: invokeinterface java/util/Iterator.hasNext:()Z
        //   641: ifeq            675
        //   644: aload           9
        //   646: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   651: astore          element$iv
        //   653: aload           element$iv
        //   655: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   658: astore          it
        //   660: iconst_0       
        //   661: istore          $i$a$-all-NBT$toNBT$5
        //   663: aload           it
        //   665: instanceof      Lnet/minecraft/nbt/NBTTagInt;
        //   668: ifne            634
        //   671: iconst_0       
        //   672: goto            676
        //   675: iconst_1       
        //   676: ifeq            824
        //   679: aload           normalized
        //   681: checkcast       Ljava/lang/Iterable;
        //   684: astore          $this$map$iv
        //   686: iconst_0       
        //   687: istore          $i$f$map
        //   689: aload           $this$map$iv
        //   691: astore          9
        //   693: new             Ljava/util/ArrayList;
        //   696: dup            
        //   697: aload           $this$map$iv
        //   699: bipush          10
        //   701: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   704: invokespecial   java/util/ArrayList.<init>:(I)V
        //   707: checkcast       Ljava/util/Collection;
        //   710: astore          destination$iv$iv
        //   712: iconst_0       
        //   713: istore          $i$f$mapTo
        //   715: aload           $this$mapTo$iv$iv
        //   717: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   722: astore          12
        //   724: aload           12
        //   726: invokeinterface java/util/Iterator.hasNext:()Z
        //   731: ifeq            795
        //   734: aload           12
        //   736: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   741: astore          item$iv$iv
        //   743: aload           destination$iv$iv
        //   745: aload           item$iv$iv
        //   747: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   750: astore          14
        //   752: astore          18
        //   754: iconst_0       
        //   755: istore          $i$a$-map-NBT$toNBT$6
        //   757: aload           it
        //   759: dup            
        //   760: ifnonnull       774
        //   763: pop            
        //   764: new             Ljava/lang/NullPointerException;
        //   767: dup            
        //   768: ldc             "null cannot be cast to non-null type net.minecraft.nbt.NBTTagInt"
        //   770: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   773: athrow         
        //   774: checkcast       Lnet/minecraft/nbt/NBTTagInt;
        //   777: invokevirtual   net/minecraft/nbt/NBTTagInt.getInt:()I
        //   780: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   783: aload           18
        //   785: swap           
        //   786: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   791: pop            
        //   792: goto            724
        //   795: aload           destination$iv$iv
        //   797: checkcast       Ljava/util/List;
        //   800: nop            
        //   801: checkcast       Ljava/util/Collection;
        //   804: invokestatic    kotlin/collections/CollectionsKt.toIntArray:(Ljava/util/Collection;)[I
        //   807: astore          20
        //   809: new             Lnet/minecraft/nbt/NBTTagIntArray;
        //   812: dup            
        //   813: aload           20
        //   815: invokespecial   net/minecraft/nbt/NBTTagIntArray.<init>:([I)V
        //   818: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   821: goto            852
        //   824: new             Lnet/minecraft/nbt/NBTTagList;
        //   827: dup            
        //   828: invokespecial   net/minecraft/nbt/NBTTagList.<init>:()V
        //   831: astore          7
        //   833: aload           7
        //   835: astore          $this$toNBT_u24lambda_u2d9
        //   837: iconst_0       
        //   838: istore          $i$a$-apply-NBT$toNBT$7
        //   840: aload           $this$toNBT_u24lambda_u2d9
        //   842: aload           normalized
        //   844: putfield        net/minecraft/nbt/NBTTagList.tagList:Ljava/util/List;
        //   847: aload           7
        //   849: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   852: areturn        
        //   853: aload           5
        //   855: instanceof      Ljava/lang/Boolean;
        //   858: ifeq            889
        //   861: new             Lnet/minecraft/nbt/NBTTagByte;
        //   864: dup            
        //   865: aload_1         /* $this$toNBT */
        //   866: checkcast       Ljava/lang/Boolean;
        //   869: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   872: ifeq            879
        //   875: iconst_1       
        //   876: goto            880
        //   879: iconst_0       
        //   880: invokespecial   net/minecraft/nbt/NBTTagByte.<init>:(B)V
        //   883: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   886: goto            1093
        //   889: aload           5
        //   891: instanceof      Ljava/lang/String;
        //   894: ifeq            910
        //   897: aload_0         /* this */
        //   898: aload_1         /* $this$toNBT */
        //   899: checkcast       Ljava/lang/String;
        //   902: iload           coerceNumericStrings
        //   904: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBT.parseString:(Ljava/lang/String;Z)Lnet/minecraft/nbt/NBTBase;
        //   907: goto            1093
        //   910: aload           5
        //   912: instanceof      Ljava/lang/Byte;
        //   915: ifeq            938
        //   918: new             Lnet/minecraft/nbt/NBTTagByte;
        //   921: dup            
        //   922: aload_1         /* $this$toNBT */
        //   923: checkcast       Ljava/lang/Number;
        //   926: invokevirtual   java/lang/Number.byteValue:()B
        //   929: invokespecial   net/minecraft/nbt/NBTTagByte.<init>:(B)V
        //   932: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   935: goto            1093
        //   938: aload           5
        //   940: instanceof      Ljava/lang/Short;
        //   943: ifeq            966
        //   946: new             Lnet/minecraft/nbt/NBTTagShort;
        //   949: dup            
        //   950: aload_1         /* $this$toNBT */
        //   951: checkcast       Ljava/lang/Number;
        //   954: invokevirtual   java/lang/Number.shortValue:()S
        //   957: invokespecial   net/minecraft/nbt/NBTTagShort.<init>:(S)V
        //   960: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   963: goto            1093
        //   966: aload           5
        //   968: instanceof      Ljava/lang/Integer;
        //   971: ifeq            994
        //   974: new             Lnet/minecraft/nbt/NBTTagInt;
        //   977: dup            
        //   978: aload_1         /* $this$toNBT */
        //   979: checkcast       Ljava/lang/Number;
        //   982: invokevirtual   java/lang/Number.intValue:()I
        //   985: invokespecial   net/minecraft/nbt/NBTTagInt.<init>:(I)V
        //   988: checkcast       Lnet/minecraft/nbt/NBTBase;
        //   991: goto            1093
        //   994: aload           5
        //   996: instanceof      Ljava/lang/Long;
        //   999: ifeq            1022
        //  1002: new             Lnet/minecraft/nbt/NBTTagLong;
        //  1005: dup            
        //  1006: aload_1         /* $this$toNBT */
        //  1007: checkcast       Ljava/lang/Number;
        //  1010: invokevirtual   java/lang/Number.longValue:()J
        //  1013: invokespecial   net/minecraft/nbt/NBTTagLong.<init>:(J)V
        //  1016: checkcast       Lnet/minecraft/nbt/NBTBase;
        //  1019: goto            1093
        //  1022: aload           5
        //  1024: instanceof      Ljava/lang/Float;
        //  1027: ifeq            1050
        //  1030: new             Lnet/minecraft/nbt/NBTTagFloat;
        //  1033: dup            
        //  1034: aload_1         /* $this$toNBT */
        //  1035: checkcast       Ljava/lang/Number;
        //  1038: invokevirtual   java/lang/Number.floatValue:()F
        //  1041: invokespecial   net/minecraft/nbt/NBTTagFloat.<init>:(F)V
        //  1044: checkcast       Lnet/minecraft/nbt/NBTBase;
        //  1047: goto            1093
        //  1050: aload           5
        //  1052: instanceof      Ljava/lang/Double;
        //  1055: ifeq            1078
        //  1058: new             Lnet/minecraft/nbt/NBTTagDouble;
        //  1061: dup            
        //  1062: aload_1         /* $this$toNBT */
        //  1063: checkcast       Ljava/lang/Number;
        //  1066: invokevirtual   java/lang/Number.doubleValue:()D
        //  1069: invokespecial   net/minecraft/nbt/NBTTagDouble.<init>:(D)V
        //  1072: checkcast       Lnet/minecraft/nbt/NBTBase;
        //  1075: goto            1093
        //  1078: new             Lnet/minecraft/nbt/NBTException;
        //  1081: dup            
        //  1082: ldc_w           "Invalid NBT. Value provided: "
        //  1085: aload_1         /* $this$toNBT */
        //  1086: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //  1089: invokespecial   net/minecraft/nbt/NBTException.<init>:(Ljava/lang/String;)V
        //  1092: athrow         
        //  1093: areturn        
        //    Exceptions:
        //  throws net.minecraft.nbt.NBTException
        //    StackMapTable: 00 26 FF 00 5B 00 0C 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 44 07 00 44 01 07 00 86 01 07 00 8C 00 00 FB 00 59 FF 00 09 00 06 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 00 FF 00 33 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 FF 00 28 00 12 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 07 00 04 07 00 04 01 00 07 00 BB 00 01 07 00 04 47 07 00 54 FF 00 0B 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 FF 00 15 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 1C 23 FF 00 08 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 8C 07 00 04 00 00 28 FF 00 00 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 04 07 00 04 00 01 01 FF 00 2F 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 FF 00 31 00 13 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 07 00 04 07 00 54 01 00 00 07 00 BB 00 01 07 00 54 FF 00 14 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 FF 00 1C 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 04 07 00 04 00 00 22 FF 00 08 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 8C 07 00 04 00 00 28 FF 00 00 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 04 07 00 04 00 01 01 FF 00 2F 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 FF 00 31 00 13 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 07 00 04 07 00 54 01 00 00 07 00 BB 00 01 07 00 54 FF 00 14 00 0D 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 86 07 00 BB 01 07 00 8C 00 00 FF 00 1C 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 86 01 07 00 04 07 00 04 00 00 FF 00 1B 00 0B 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 07 00 C1 07 00 04 00 00 07 00 04 00 01 07 00 54 FF 00 00 00 06 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 00 FF 00 19 00 06 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 02 08 03 5D 08 03 5D FF 00 00 00 06 07 00 02 07 00 04 07 00 3B 01 01 07 00 04 00 03 08 03 5D 08 03 5D 01 08 14 1B 1B 1B 1B 1B 1B 4E 07 00 54
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Cannot read field "references" because "newVariable" is null
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
        //     at java.base/java.lang.Thread.run(Thread.java:842)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final net.minecraft.nbt.NBTBase parseString(final String nbtData, final boolean coerceNumericStrings) {
        if (!coerceNumericStrings) {
            return (net.minecraft.nbt.NBTBase)new NBTTagString(nbtData);
        }
        final MatchResult matchEntire = NBT.numberNBTFormat.matchEntire((CharSequence)nbtData);
        final List list = (matchEntire == null) ? null : matchEntire.getGroupValues();
        if (list == null) {
            return (net.minecraft.nbt.NBTBase)new NBTTagString(nbtData);
        }
        final List res = list;
        final String number = res.get(1);
        final String suffix = res.get(2);
        final String lowerCase = suffix.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        final String s = lowerCase;
        switch (s) {
            case "": {
                return (net.minecraft.nbt.NBTBase)(StringsKt.contains$default((CharSequence)number, (CharSequence)".", false, 2, (Object)null) ? new NBTTagDouble(Double.parseDouble(number)) : ((NBTBase$NBTPrimitive)new NBTTagInt(Integer.parseInt(number))));
            }
            case "b": {
                return (net.minecraft.nbt.NBTBase)new NBTTagByte(Byte.parseByte(number));
            }
            case "s": {
                return (net.minecraft.nbt.NBTBase)new NBTTagShort(Short.parseShort(number));
            }
            case "d": {
                return (net.minecraft.nbt.NBTBase)new NBTTagDouble(Double.parseDouble(number));
            }
            case "f": {
                return (net.minecraft.nbt.NBTBase)new NBTTagFloat(Float.parseFloat(number));
            }
            case "l": {
                return (net.minecraft.nbt.NBTBase)new NBTTagLong(Long.parseLong(number));
            }
            default:
                break;
        }
        return (net.minecraft.nbt.NBTBase)new NBTTagString(nbtData);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final NBTBase parse(@NotNull final Object nbt) throws NBTException {
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        return parse$default(nbt, null, 2, null);
    }
    
    static {
        INSTANCE = new NBT();
        numberNBTFormat = new Regex("^([+-]?\\d+\\.?\\d*)([bslfd])?$", RegexOption.IGNORE_CASE);
    }
}
