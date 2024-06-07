//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tJ\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/Chunk;", "", "chunk", "Lnet/minecraft/world/chunk/Chunk;", "Lcom/chattriggers/ctjs/utils/kotlin/MCChunk;", "(Lnet/minecraft/world/chunk/Chunk;)V", "getChunk", "()Lnet/minecraft/world/chunk/Chunk;", "getAllEntities", "", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "getAllEntitiesOfType", "clazz", "Ljava/lang/Class;", "getAllTileEntities", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;", "getAllTileEntitiesOfType", "getBlockLightLevel", "", "x", "y", "z", "getMinBlockX", "getMinBlockZ", "getSkyLightLevel", "getX", "getZ", "ctjs" })
public final class Chunk
{
    @NotNull
    private final net.minecraft.world.chunk.Chunk chunk;
    
    public Chunk(@NotNull final net.minecraft.world.chunk.Chunk chunk) {
        Intrinsics.checkNotNullParameter((Object)chunk, "chunk");
        this.chunk = chunk;
    }
    
    @NotNull
    public final net.minecraft.world.chunk.Chunk getChunk() {
        return this.chunk;
    }
    
    public final int getX() {
        return this.chunk.xPosition;
    }
    
    public final int getZ() {
        return this.chunk.zPosition;
    }
    
    public final int getMinBlockX() {
        return this.getX() * 16;
    }
    
    public final int getMinBlockZ() {
        return this.getZ() * 16;
    }
    
    public final int getSkyLightLevel(final int x, final int y, final int z) {
        return this.chunk.getLightFor(EnumSkyBlock.SKY, new BlockPos(x, y, z));
    }
    
    public final int getBlockLightLevel(final int x, final int y, final int z) {
        return this.chunk.getLightFor(EnumSkyBlock.BLOCK, new BlockPos(x, y, z));
    }
    
    @NotNull
    public final List<Entity> getAllEntities() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/world/Chunk.chunk:Lnet/minecraft/world/chunk/Chunk;
        //     4: invokevirtual   net/minecraft/world/chunk/Chunk.getEntityLists:()[Lnet/minecraft/util/ClassInheritanceMultiMap;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc             "chunk.entityLists"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_1        
        //    15: checkcast       [Ljava/lang/Object;
        //    18: invokestatic    kotlin/collections/ArraysKt.toList:([Ljava/lang/Object;)Ljava/util/List;
        //    21: checkcast       Ljava/lang/Iterable;
        //    24: invokestatic    kotlin/collections/CollectionsKt.flatten:(Ljava/lang/Iterable;)Ljava/util/List;
        //    27: checkcast       Ljava/lang/Iterable;
        //    30: astore_1        /* $this$map$iv */
        //    31: iconst_0       
        //    32: istore_2        /* $i$f$map */
        //    33: aload_1         /* $this$map$iv */
        //    34: astore_3       
        //    35: new             Ljava/util/ArrayList;
        //    38: dup            
        //    39: aload_1         /* $this$map$iv */
        //    40: bipush          10
        //    42: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    45: invokespecial   java/util/ArrayList.<init>:(I)V
        //    48: checkcast       Ljava/util/Collection;
        //    51: astore          destination$iv$iv
        //    53: iconst_0       
        //    54: istore          $i$f$mapTo
        //    56: aload_3         /* $this$mapTo$iv$iv */
        //    57: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    62: astore          6
        //    64: aload           6
        //    66: invokeinterface java/util/Iterator.hasNext:()Z
        //    71: ifeq            118
        //    74: aload           6
        //    76: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    81: astore          item$iv$iv
        //    83: aload           destination$iv$iv
        //    85: aload           item$iv$iv
        //    87: checkcast       Lnet/minecraft/entity/Entity;
        //    90: astore          8
        //    92: astore          10
        //    94: iconst_0       
        //    95: istore          $i$a$-map-Chunk$getAllEntities$1
        //    97: new             Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;
        //   100: dup            
        //   101: aload           p0
        //   103: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/entity/Entity.<init>:(Lnet/minecraft/entity/Entity;)V
        //   106: aload           10
        //   108: swap           
        //   109: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   114: pop            
        //   115: goto            64
        //   118: aload           destination$iv$iv
        //   120: checkcast       Ljava/util/List;
        //   123: nop            
        //   124: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;>;
        //    StackMapTable: 00 02 FF 00 40 00 07 07 00 02 07 00 6E 01 07 00 6E 07 00 7F 01 07 00 85 00 00 35
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
    
    @NotNull
    public final List<Entity> getAllEntitiesOfType(@NotNull final Class<?> clazz) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "clazz"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/world/Chunk.getAllEntities:()Ljava/util/List;
        //    10: checkcast       Ljava/lang/Iterable;
        //    13: astore_2        /* $this$filter$iv */
        //    14: iconst_0       
        //    15: istore_3        /* $i$f$filter */
        //    16: aload_2         /* $this$filter$iv */
        //    17: astore          4
        //    19: new             Ljava/util/ArrayList;
        //    22: dup            
        //    23: invokespecial   java/util/ArrayList.<init>:()V
        //    26: checkcast       Ljava/util/Collection;
        //    29: astore          destination$iv$iv
        //    31: iconst_0       
        //    32: istore          $i$f$filterTo
        //    34: aload           $this$filterTo$iv$iv
        //    36: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    41: astore          7
        //    43: aload           7
        //    45: invokeinterface java/util/Iterator.hasNext:()Z
        //    50: ifeq            97
        //    53: aload           7
        //    55: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    60: astore          element$iv$iv
        //    62: aload           element$iv$iv
        //    64: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;
        //    67: astore          it
        //    69: iconst_0       
        //    70: istore          $i$a$-filter-Chunk$getAllEntitiesOfType$1
        //    72: aload_1         /* clazz */
        //    73: aload           it
        //    75: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/entity/Entity.getEntity:()Lnet/minecraft/entity/Entity;
        //    78: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //    81: ifeq            43
        //    84: aload           destination$iv$iv
        //    86: aload           element$iv$iv
        //    88: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    93: pop            
        //    94: goto            43
        //    97: aload           destination$iv$iv
        //    99: checkcast       Ljava/util/List;
        //   102: nop            
        //   103: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;)Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;>;
        //    StackMapTable: 00 02 FF 00 2B 00 08 07 00 02 07 00 AD 07 00 6E 01 07 00 6E 07 00 7F 01 07 00 85 00 00 35
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
    
    @NotNull
    public final List<TileEntity> getAllTileEntities() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/world/Chunk.chunk:Lnet/minecraft/world/chunk/Chunk;
        //     4: invokevirtual   net/minecraft/world/chunk/Chunk.getTileEntityMap:()Ljava/util/Map;
        //     7: invokeinterface java/util/Map.values:()Ljava/util/Collection;
        //    12: checkcast       Ljava/lang/Iterable;
        //    15: astore_1        /* $this$map$iv */
        //    16: iconst_0       
        //    17: istore_2        /* $i$f$map */
        //    18: aload_1         /* $this$map$iv */
        //    19: astore_3       
        //    20: new             Ljava/util/ArrayList;
        //    23: dup            
        //    24: aload_1         /* $this$map$iv */
        //    25: bipush          10
        //    27: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    30: invokespecial   java/util/ArrayList.<init>:(I)V
        //    33: checkcast       Ljava/util/Collection;
        //    36: astore          destination$iv$iv
        //    38: iconst_0       
        //    39: istore          $i$f$mapTo
        //    41: aload_3         /* $this$mapTo$iv$iv */
        //    42: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    47: astore          6
        //    49: aload           6
        //    51: invokeinterface java/util/Iterator.hasNext:()Z
        //    56: ifeq            103
        //    59: aload           6
        //    61: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    66: astore          item$iv$iv
        //    68: aload           destination$iv$iv
        //    70: aload           item$iv$iv
        //    72: checkcast       Lnet/minecraft/tileentity/TileEntity;
        //    75: astore          8
        //    77: astore          10
        //    79: iconst_0       
        //    80: istore          $i$a$-map-Chunk$getAllTileEntities$1
        //    82: new             Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;
        //    85: dup            
        //    86: aload           p0
        //    88: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity.<init>:(Lnet/minecraft/tileentity/TileEntity;)V
        //    91: aload           10
        //    93: swap           
        //    94: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    99: pop            
        //   100: goto            49
        //   103: aload           destination$iv$iv
        //   105: checkcast       Ljava/util/List;
        //   108: nop            
        //   109: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;>;
        //    StackMapTable: 00 02 FF 00 31 00 07 07 00 02 07 00 6E 01 07 00 6E 07 00 7F 01 07 00 85 00 00 35
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
    
    @NotNull
    public final List<TileEntity> getAllTileEntitiesOfType(@NotNull final Class<?> clazz) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "clazz"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/world/Chunk.getAllTileEntities:()Ljava/util/List;
        //    10: checkcast       Ljava/lang/Iterable;
        //    13: astore_2        /* $this$filter$iv */
        //    14: iconst_0       
        //    15: istore_3        /* $i$f$filter */
        //    16: aload_2         /* $this$filter$iv */
        //    17: astore          4
        //    19: new             Ljava/util/ArrayList;
        //    22: dup            
        //    23: invokespecial   java/util/ArrayList.<init>:()V
        //    26: checkcast       Ljava/util/Collection;
        //    29: astore          destination$iv$iv
        //    31: iconst_0       
        //    32: istore          $i$f$filterTo
        //    34: aload           $this$filterTo$iv$iv
        //    36: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    41: astore          7
        //    43: aload           7
        //    45: invokeinterface java/util/Iterator.hasNext:()Z
        //    50: ifeq            97
        //    53: aload           7
        //    55: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    60: astore          element$iv$iv
        //    62: aload           element$iv$iv
        //    64: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;
        //    67: astore          it
        //    69: iconst_0       
        //    70: istore          $i$a$-filter-Chunk$getAllTileEntitiesOfType$1
        //    72: aload_1         /* clazz */
        //    73: aload           it
        //    75: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity.getTileEntity:()Lnet/minecraft/tileentity/TileEntity;
        //    78: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //    81: ifeq            43
        //    84: aload           destination$iv$iv
        //    86: aload           element$iv$iv
        //    88: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    93: pop            
        //    94: goto            43
        //    97: aload           destination$iv$iv
        //    99: checkcast       Ljava/util/List;
        //   102: nop            
        //   103: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;)Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;>;
        //    StackMapTable: 00 02 FF 00 2B 00 08 07 00 02 07 00 AD 07 00 6E 01 07 00 6E 07 00 7F 01 07 00 85 00 00 35
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
}
