//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import kotlin.*;
import net.minecraft.client.multiplayer.*;
import kotlin.jvm.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.functions.*;
import net.minecraft.world.storage.*;
import net.minecraft.world.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.block.*;
import kotlin.jvm.internal.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.entity.player.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.particle.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003345B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0007J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H\u0007J\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u001aH\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\u001cH\u0007J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020#H\u0007J\b\u0010%\u001a\u00020\u001cH\u0007J\n\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u001cH\u0007J\b\u0010*\u001a\u00020)H\u0007J\b\u0010+\u001a\u00020)H\u0007J*\u0010,\u001a\u00020-2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0012\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020.H\u0007J \u0010/\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020!H\u0007J\b\u00102\u001a\u00020-H\u0007¨\u00066" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/World;", "", "()V", "getAllEntities", "", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "getAllEntitiesOfType", "clazz", "Ljava/lang/Class;", "getAllPlayers", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;", "getAllTileEntities", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;", "getAllTileEntitiesOfType", "getBlockAt", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Block;", "pos", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "x", "", "y", "z", "getBlockStateAt", "Lnet/minecraft/block/state/IBlockState;", "getChunk", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/Chunk;", "", "getDifficulty", "", "getMoonPhase", "getPlayerByName", "name", "getRainingStrength", "", "getSeed", "", "getTime", "getType", "getWorld", "Lnet/minecraft/client/multiplayer/WorldClient;", "hasPlayer", "", "isLoaded", "isRaining", "playRecord", "", "", "playSound", "volume", "pitch", "stopAllSounds", "border", "particle", "spawn", "ctjs" })
public final class World
{
    @NotNull
    public static final World INSTANCE;
    
    private World() {
    }
    
    @JvmStatic
    @Nullable
    public static final WorldClient getWorld() {
        return Client.Companion.getMinecraft().theWorld;
    }
    
    @JvmStatic
    public static final boolean isLoaded() {
        final World instance = World.INSTANCE;
        return getWorld() != null;
    }
    
    @JvmStatic
    public static final void playSound(@NotNull final String name, final float volume, final float pitch) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Client.Companion.scheduleTask$default(Client.Companion, 0, (Function0)new World$playSound.World$playSound$1(name, volume, pitch), 1, null);
    }
    
    @JvmStatic
    public static final void playRecord(@Nullable final String name, final double x, final double y, final double z) {
        Client.Companion.scheduleTask$default(Client.Companion, 0, (Function0)new World$playRecord.World$playRecord$1(x, y, z, name), 1, null);
    }
    
    @JvmStatic
    public static final void stopAllSounds() {
        Client.Companion.getMinecraft().getSoundHandler().stopSounds();
    }
    
    @JvmStatic
    public static final boolean isRaining() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        boolean b;
        if (world == null) {
            b = false;
        }
        else {
            final WorldInfo getWorldInfo = world.getWorldInfo();
            b = (getWorldInfo != null && getWorldInfo.isRaining());
        }
        return b;
    }
    
    @JvmStatic
    public static final float getRainingStrength() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        return (world == null) ? -1.0f : world.rainingStrength;
    }
    
    @JvmStatic
    public static final long getTime() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        return (world == null) ? -1L : world.getWorldTime();
    }
    
    @JvmStatic
    @NotNull
    public static final String getDifficulty() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        return String.valueOf((world == null) ? null : world.getDifficulty());
    }
    
    @JvmStatic
    public static final int getMoonPhase() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        return (world == null) ? -1 : world.getMoonPhase();
    }
    
    @JvmStatic
    public static final long getSeed() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        return (world == null) ? -1L : world.getSeed();
    }
    
    @JvmStatic
    @NotNull
    public static final String getType() {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        String obj;
        if (world == null) {
            obj = null;
        }
        else {
            final WorldType getWorldType = world.getWorldType();
            obj = ((getWorldType == null) ? null : getWorldType.getWorldTypeName());
        }
        return String.valueOf(obj);
    }
    
    @JvmStatic
    @NotNull
    public static final Block getBlockAt(@NotNull final Number x, @NotNull final Number y, @NotNull final Number z) {
        Intrinsics.checkNotNullParameter((Object)x, "x");
        Intrinsics.checkNotNullParameter((Object)y, "y");
        Intrinsics.checkNotNullParameter((Object)z, "z");
        final World instance = World.INSTANCE;
        return getBlockAt(new BlockPos(x, y, z));
    }
    
    @JvmStatic
    @NotNull
    public static final Block getBlockAt(@NotNull final BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        final World instance = World.INSTANCE;
        final net.minecraft.block.Block getBlock = getBlockStateAt(pos).getBlock();
        Intrinsics.checkNotNullExpressionValue((Object)getBlock, "getBlockStateAt(pos).block");
        return new Block(new BlockType(getBlock), pos, (BlockFace)null, 4, (DefaultConstructorMarker)null);
    }
    
    @JvmStatic
    @NotNull
    public static final IBlockState getBlockStateAt(@NotNull final BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        Intrinsics.checkNotNull((Object)world);
        final IBlockState getBlockState = world.getBlockState(pos.toMCBlock());
        Intrinsics.checkNotNullExpressionValue((Object)getBlockState, "getWorld()!!.getBlockState(pos.toMCBlock())");
        return getBlockState;
    }
    
    @JvmStatic
    @NotNull
    public static final List<PlayerMP> getAllPlayers() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        //     4: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getWorld:()Lnet/minecraft/client/multiplayer/WorldClient;
        //     7: dup            
        //     8: ifnonnull       16
        //    11: pop            
        //    12: aconst_null    
        //    13: goto            125
        //    16: getfield        net/minecraft/client/multiplayer/WorldClient.playerEntities:Ljava/util/List;
        //    19: dup            
        //    20: ifnonnull       28
        //    23: pop            
        //    24: aconst_null    
        //    25: goto            125
        //    28: checkcast       Ljava/lang/Iterable;
        //    31: astore_1        /* $this$map$iv */
        //    32: iconst_0       
        //    33: istore_2        /* $i$f$map */
        //    34: aload_1         /* $this$map$iv */
        //    35: astore_3       
        //    36: new             Ljava/util/ArrayList;
        //    39: dup            
        //    40: aload_1         /* $this$map$iv */
        //    41: bipush          10
        //    43: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    46: invokespecial   java/util/ArrayList.<init>:(I)V
        //    49: checkcast       Ljava/util/Collection;
        //    52: astore          destination$iv$iv
        //    54: iconst_0       
        //    55: istore          $i$f$mapTo
        //    57: aload_3         /* $this$mapTo$iv$iv */
        //    58: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    63: astore          6
        //    65: aload           6
        //    67: invokeinterface java/util/Iterator.hasNext:()Z
        //    72: ifeq            119
        //    75: aload           6
        //    77: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    82: astore          item$iv$iv
        //    84: aload           destination$iv$iv
        //    86: aload           item$iv$iv
        //    88: checkcast       Lnet/minecraft/entity/player/EntityPlayer;
        //    91: astore          8
        //    93: astore          10
        //    95: iconst_0       
        //    96: istore          $i$a$-map-World$getAllPlayers$1
        //    98: new             Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;
        //   101: dup            
        //   102: aload           p0
        //   104: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP.<init>:(Lnet/minecraft/entity/player/EntityPlayer;)V
        //   107: aload           10
        //   109: swap           
        //   110: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   115: pop            
        //   116: goto            65
        //   119: aload           destination$iv$iv
        //   121: checkcast       Ljava/util/List;
        //   124: nop            
        //   125: astore_0       
        //   126: aload_0        
        //   127: ifnonnull       136
        //   130: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   133: goto            137
        //   136: aload_0        
        //   137: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;>;
        //    StackMapTable: 00 07 50 07 00 89 4B 07 00 F5 FF 00 24 00 07 00 07 00 F7 01 07 00 F7 07 01 04 01 07 01 0A 00 00 35 FF 00 05 00 00 00 01 07 00 F5 FC 00 0A 07 00 F5 40 07 00 F5
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
    
    @JvmStatic
    @Nullable
    public static final PlayerMP getPlayerByName(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        PlayerMP playerMP;
        if (world == null) {
            playerMP = null;
        }
        else {
            final EntityPlayer getPlayerEntityByName = world.getPlayerEntityByName(name);
            if (getPlayerEntityByName == null) {
                playerMP = null;
            }
            else {
                final EntityPlayer p0 = getPlayerEntityByName;
                final int n = 0;
                playerMP = new PlayerMP(p0);
            }
        }
        return playerMP;
    }
    
    @JvmStatic
    public static final boolean hasPlayer(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        return ((world == null) ? null : world.getPlayerEntityByName(name)) != null;
    }
    
    @JvmStatic
    @NotNull
    public static final Chunk getChunk(final int x, final int y, final int z) {
        final World instance = World.INSTANCE;
        final WorldClient world = getWorld();
        Intrinsics.checkNotNull((Object)world);
        final net.minecraft.world.chunk.Chunk getChunkFromBlockCoords = world.getChunkFromBlockCoords(new net.minecraft.util.BlockPos(x, y, z));
        Intrinsics.checkNotNullExpressionValue((Object)getChunkFromBlockCoords, "getWorld()!!.getChunkFro\u2026os(x, y, z)\n            )");
        return new Chunk(getChunkFromBlockCoords);
    }
    
    @JvmStatic
    @NotNull
    public static final List<Entity> getAllEntities() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        //     4: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getWorld:()Lnet/minecraft/client/multiplayer/WorldClient;
        //     7: dup            
        //     8: ifnonnull       16
        //    11: pop            
        //    12: aconst_null    
        //    13: goto            125
        //    16: getfield        net/minecraft/client/multiplayer/WorldClient.loadedEntityList:Ljava/util/List;
        //    19: dup            
        //    20: ifnonnull       28
        //    23: pop            
        //    24: aconst_null    
        //    25: goto            125
        //    28: checkcast       Ljava/lang/Iterable;
        //    31: astore_1        /* $this$map$iv */
        //    32: iconst_0       
        //    33: istore_2        /* $i$f$map */
        //    34: aload_1         /* $this$map$iv */
        //    35: astore_3       
        //    36: new             Ljava/util/ArrayList;
        //    39: dup            
        //    40: aload_1         /* $this$map$iv */
        //    41: bipush          10
        //    43: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    46: invokespecial   java/util/ArrayList.<init>:(I)V
        //    49: checkcast       Ljava/util/Collection;
        //    52: astore          destination$iv$iv
        //    54: iconst_0       
        //    55: istore          $i$f$mapTo
        //    57: aload_3         /* $this$mapTo$iv$iv */
        //    58: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    63: astore          6
        //    65: aload           6
        //    67: invokeinterface java/util/Iterator.hasNext:()Z
        //    72: ifeq            119
        //    75: aload           6
        //    77: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    82: astore          item$iv$iv
        //    84: aload           destination$iv$iv
        //    86: aload           item$iv$iv
        //    88: checkcast       Lnet/minecraft/entity/Entity;
        //    91: astore          8
        //    93: astore          10
        //    95: iconst_0       
        //    96: istore          $i$a$-map-World$getAllEntities$1
        //    98: new             Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;
        //   101: dup            
        //   102: aload           p0
        //   104: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/entity/Entity.<init>:(Lnet/minecraft/entity/Entity;)V
        //   107: aload           10
        //   109: swap           
        //   110: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   115: pop            
        //   116: goto            65
        //   119: aload           destination$iv$iv
        //   121: checkcast       Ljava/util/List;
        //   124: nop            
        //   125: astore_0       
        //   126: aload_0        
        //   127: ifnonnull       136
        //   130: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   133: goto            137
        //   136: aload_0        
        //   137: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;>;
        //    StackMapTable: 00 07 50 07 00 89 4B 07 00 F5 FF 00 24 00 07 00 07 00 F7 01 07 00 F7 07 01 04 01 07 01 0A 00 00 35 FF 00 05 00 00 00 01 07 00 F5 FC 00 0A 07 00 F5 40 07 00 F5
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
    
    @JvmStatic
    @NotNull
    public static final List<Entity> getAllEntitiesOfType(@NotNull final Class<?> clazz) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "clazz"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: getstatic       com/chattriggers/ctjs/minecraft/wrappers/World.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/World;
        //    10: pop            
        //    11: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getAllEntities:()Ljava/util/List;
        //    14: checkcast       Ljava/lang/Iterable;
        //    17: astore_1        /* $this$filter$iv */
        //    18: iconst_0       
        //    19: istore_2        /* $i$f$filter */
        //    20: aload_1         /* $this$filter$iv */
        //    21: astore_3       
        //    22: new             Ljava/util/ArrayList;
        //    25: dup            
        //    26: invokespecial   java/util/ArrayList.<init>:()V
        //    29: checkcast       Ljava/util/Collection;
        //    32: astore          destination$iv$iv
        //    34: iconst_0       
        //    35: istore          $i$f$filterTo
        //    37: aload_3         /* $this$filterTo$iv$iv */
        //    38: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    43: astore          6
        //    45: aload           6
        //    47: invokeinterface java/util/Iterator.hasNext:()Z
        //    52: ifeq            99
        //    55: aload           6
        //    57: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    62: astore          element$iv$iv
        //    64: aload           element$iv$iv
        //    66: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;
        //    69: astore          it
        //    71: iconst_0       
        //    72: istore          $i$a$-filter-World$getAllEntitiesOfType$1
        //    74: aload_0         /* clazz */
        //    75: aload           it
        //    77: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/entity/Entity.getEntity:()Lnet/minecraft/entity/Entity;
        //    80: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //    83: ifeq            45
        //    86: aload           destination$iv$iv
        //    88: aload           element$iv$iv
        //    90: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    95: pop            
        //    96: goto            45
        //    99: aload           destination$iv$iv
        //   101: checkcast       Ljava/util/List;
        //   104: nop            
        //   105: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;)Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;>;
        //    StackMapTable: 00 02 FF 00 2D 00 07 07 01 57 07 00 F7 01 07 00 F7 07 01 04 01 07 01 0A 00 00 35
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
    
    @JvmStatic
    @NotNull
    public static final List<TileEntity> getAllTileEntities() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        //     4: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getWorld:()Lnet/minecraft/client/multiplayer/WorldClient;
        //     7: dup            
        //     8: ifnonnull       16
        //    11: pop            
        //    12: aconst_null    
        //    13: goto            125
        //    16: getfield        net/minecraft/client/multiplayer/WorldClient.loadedTileEntityList:Ljava/util/List;
        //    19: dup            
        //    20: ifnonnull       28
        //    23: pop            
        //    24: aconst_null    
        //    25: goto            125
        //    28: checkcast       Ljava/lang/Iterable;
        //    31: astore_1        /* $this$map$iv */
        //    32: iconst_0       
        //    33: istore_2        /* $i$f$map */
        //    34: aload_1         /* $this$map$iv */
        //    35: astore_3       
        //    36: new             Ljava/util/ArrayList;
        //    39: dup            
        //    40: aload_1         /* $this$map$iv */
        //    41: bipush          10
        //    43: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    46: invokespecial   java/util/ArrayList.<init>:(I)V
        //    49: checkcast       Ljava/util/Collection;
        //    52: astore          destination$iv$iv
        //    54: iconst_0       
        //    55: istore          $i$f$mapTo
        //    57: aload_3         /* $this$mapTo$iv$iv */
        //    58: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    63: astore          6
        //    65: aload           6
        //    67: invokeinterface java/util/Iterator.hasNext:()Z
        //    72: ifeq            119
        //    75: aload           6
        //    77: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    82: astore          item$iv$iv
        //    84: aload           destination$iv$iv
        //    86: aload           item$iv$iv
        //    88: checkcast       Lnet/minecraft/tileentity/TileEntity;
        //    91: astore          8
        //    93: astore          10
        //    95: iconst_0       
        //    96: istore          $i$a$-map-World$getAllTileEntities$1
        //    98: new             Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;
        //   101: dup            
        //   102: aload           p0
        //   104: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity.<init>:(Lnet/minecraft/tileentity/TileEntity;)V
        //   107: aload           10
        //   109: swap           
        //   110: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   115: pop            
        //   116: goto            65
        //   119: aload           destination$iv$iv
        //   121: checkcast       Ljava/util/List;
        //   124: nop            
        //   125: astore_0       
        //   126: aload_0        
        //   127: ifnonnull       136
        //   130: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   133: goto            137
        //   136: aload_0        
        //   137: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;>;
        //    StackMapTable: 00 07 50 07 00 89 4B 07 00 F5 FF 00 24 00 07 00 07 00 F7 01 07 00 F7 07 01 04 01 07 01 0A 00 00 35 FF 00 05 00 00 00 01 07 00 F5 FC 00 0A 07 00 F5 40 07 00 F5
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
    
    @JvmStatic
    @NotNull
    public static final List<TileEntity> getAllTileEntitiesOfType(@NotNull final Class<?> clazz) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "clazz"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: getstatic       com/chattriggers/ctjs/minecraft/wrappers/World.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/World;
        //    10: pop            
        //    11: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getAllTileEntities:()Ljava/util/List;
        //    14: checkcast       Ljava/lang/Iterable;
        //    17: astore_1        /* $this$filter$iv */
        //    18: iconst_0       
        //    19: istore_2        /* $i$f$filter */
        //    20: aload_1         /* $this$filter$iv */
        //    21: astore_3       
        //    22: new             Ljava/util/ArrayList;
        //    25: dup            
        //    26: invokespecial   java/util/ArrayList.<init>:()V
        //    29: checkcast       Ljava/util/Collection;
        //    32: astore          destination$iv$iv
        //    34: iconst_0       
        //    35: istore          $i$f$filterTo
        //    37: aload_3         /* $this$filterTo$iv$iv */
        //    38: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    43: astore          6
        //    45: aload           6
        //    47: invokeinterface java/util/Iterator.hasNext:()Z
        //    52: ifeq            99
        //    55: aload           6
        //    57: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    62: astore          element$iv$iv
        //    64: aload           element$iv$iv
        //    66: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;
        //    69: astore          it
        //    71: iconst_0       
        //    72: istore          $i$a$-filter-World$getAllTileEntitiesOfType$1
        //    74: aload_0         /* clazz */
        //    75: aload           it
        //    77: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity.getTileEntity:()Lnet/minecraft/tileentity/TileEntity;
        //    80: invokevirtual   java/lang/Class.isInstance:(Ljava/lang/Object;)Z
        //    83: ifeq            45
        //    86: aload           destination$iv$iv
        //    88: aload           element$iv$iv
        //    90: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    95: pop            
        //    96: goto            45
        //    99: aload           destination$iv$iv
        //   101: checkcast       Ljava/util/List;
        //   104: nop            
        //   105: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;)Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;>;
        //    StackMapTable: 00 02 FF 00 2D 00 07 07 01 57 07 00 F7 01 07 00 F7 07 01 04 01 07 01 0A 00 00 35
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
    
    static {
        INSTANCE = new World();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/World$border;", "", "()V", "getCenterX", "", "getCenterZ", "getSize", "", "getTargetSize", "getTimeUntilTarget", "", "ctjs" })
    public static final class border
    {
        @NotNull
        public static final border INSTANCE;
        
        private border() {
        }
        
        @JvmStatic
        public static final double getCenterX() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getWorldBorder().getCenterX();
        }
        
        @JvmStatic
        public static final double getCenterZ() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getWorldBorder().getCenterZ();
        }
        
        @JvmStatic
        public static final int getSize() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getWorldBorder().getSize();
        }
        
        @JvmStatic
        public static final double getTargetSize() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getWorldBorder().getTargetSize();
        }
        
        @JvmStatic
        public static final long getTimeUntilTarget() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getWorldBorder().getTimeUntilTarget();
        }
        
        static {
            INSTANCE = new border();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/World$spawn;", "", "()V", "getX", "", "getY", "getZ", "ctjs" })
    public static final class spawn
    {
        @NotNull
        public static final spawn INSTANCE;
        
        private spawn() {
        }
        
        @JvmStatic
        public static final int getX() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getSpawnPoint().getX();
        }
        
        @JvmStatic
        public static final int getY() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getSpawnPoint().getY();
        }
        
        @JvmStatic
        public static final int getZ() {
            final WorldClient world = World.getWorld();
            Intrinsics.checkNotNull((Object)world);
            return world.getSpawnPoint().getZ();
        }
        
        static {
            INSTANCE = new spawn();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0007J@\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0007¨\u0006\u0013" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/World$particle;", "", "()V", "getParticleNames", "", "", "spawnParticle", "", "particle", "Lnet/minecraft/client/particle/EntityFX;", "Lcom/chattriggers/ctjs/utils/kotlin/MCParticle;", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Particle;", "x", "", "y", "z", "xSpeed", "ySpeed", "zSpeed", "ctjs" })
    public static final class particle
    {
        @NotNull
        public static final particle INSTANCE;
        
        private particle() {
        }
        
        @JvmStatic
        @NotNull
        public static final List<String> getParticleNames() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: astore_0        /* $this$map$iv */
            //     4: iconst_0       
            //     5: istore_1        /* $i$f$map */
            //     6: aload_0         /* $this$map$iv */
            //     7: astore_2       
            //     8: new             Ljava/util/ArrayList;
            //    11: dup            
            //    12: aload_0         /* $this$map$iv */
            //    13: arraylength    
            //    14: invokespecial   java/util/ArrayList.<init>:(I)V
            //    17: checkcast       Ljava/util/Collection;
            //    20: astore_3        /* destination$iv$iv */
            //    21: iconst_0       
            //    22: istore          $i$f$mapTo
            //    24: iconst_0       
            //    25: istore          5
            //    27: aload_2         /* $this$mapTo$iv$iv */
            //    28: arraylength    
            //    29: istore          6
            //    31: iload           5
            //    33: iload           6
            //    35: if_icmpge       74
            //    38: aload_2         /* $this$mapTo$iv$iv */
            //    39: iload           5
            //    41: aaload         
            //    42: astore          item$iv$iv
            //    44: aload_3         /* destination$iv$iv */
            //    45: aload           item$iv$iv
            //    47: astore          8
            //    49: astore          10
            //    51: iconst_0       
            //    52: istore          $i$a$-map-World$particle$getParticleNames$1
            //    54: aload           it
            //    56: invokevirtual   net/minecraft/util/EnumParticleTypes.name:()Ljava/lang/String;
            //    59: aload           10
            //    61: swap           
            //    62: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
            //    67: pop            
            //    68: iinc            5, 1
            //    71: goto            31
            //    74: aload_3         /* destination$iv$iv */
            //    75: checkcast       Ljava/util/List;
            //    78: nop            
            //    79: checkcast       Ljava/lang/Iterable;
            //    82: invokestatic    kotlin/collections/CollectionsKt.toList:(Ljava/lang/Iterable;)Ljava/util/List;
            //    85: areturn        
            //    Signature:
            //  ()Ljava/util/List<Ljava/lang/String;>;
            //    StackMapTable: 00 02 FF 00 1F 00 07 07 00 39 01 07 00 39 07 00 37 01 01 01 00 00 2A
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        @JvmStatic
        @NotNull
        public static final Particle spawnParticle(@NotNull final String particle, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            Intrinsics.checkNotNullParameter((Object)particle, "particle");
            final EnumParticleTypes particleType = EnumParticleTypes.valueOf(particle);
            final EntityFX fx = Client.Companion.getMinecraft().renderGlobal.spawnEntityFX(particleType.getParticleID(), particleType.getShouldIgnoreRange(), x, y, z, xSpeed, ySpeed, zSpeed, new int[0]);
            Intrinsics.checkNotNullExpressionValue((Object)fx, "fx");
            return new Particle(fx);
        }
        
        @JvmStatic
        public static final void spawnParticle(@NotNull final EntityFX particle) {
            Intrinsics.checkNotNullParameter((Object)particle, "particle");
            Client.Companion.getMinecraft().effectRenderer.addEffect(particle);
        }
        
        static {
            INSTANCE = new particle();
        }
    }
}
