//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import kotlin.*;
import net.minecraft.client.network.*;
import kotlin.jvm.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.jvm.internal.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.scoreboard.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0007J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0007J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0007R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/TabList;", "", "()V", "playerComparator", "Lcom/google/common/collect/Ordering;", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "kotlin.jvm.PlatformType", "clearFooter", "", "clearHeader", "getFooter", "", "getFooterMessage", "Lcom/chattriggers/ctjs/minecraft/objects/message/Message;", "getHeader", "getHeaderMessage", "getNames", "", "getNamesByObjectives", "getUnformattedNames", "setFooter", "footer", "setHeader", "header", "PlayerComparator", "ctjs" })
public final class TabList
{
    @NotNull
    public static final TabList INSTANCE;
    private static final Ordering<NetworkPlayerInfo> playerComparator;
    
    private TabList() {
    }
    
    @JvmStatic
    @NotNull
    public static final List<String> getNamesByObjectives() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ifnonnull       12
        //     7: pop            
        //     8: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    11: areturn        
        //    12: astore_0        /* scoreboard */
        //    13: aload_0         /* scoreboard */
        //    14: iconst_0       
        //    15: invokevirtual   net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot:(I)Lnet/minecraft/scoreboard/ScoreObjective;
        //    18: dup            
        //    19: ifnonnull       27
        //    22: pop            
        //    23: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    26: areturn        
        //    27: astore_1        /* sidebarObjective */
        //    28: aload_0         /* scoreboard */
        //    29: aload_1         /* sidebarObjective */
        //    30: invokevirtual   net/minecraft/scoreboard/Scoreboard.getSortedScores:(Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
        //    33: astore_3       
        //    34: aload_3        
        //    35: ldc             "scoreboard.getSortedScores(sidebarObjective)"
        //    37: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    40: aload_3        
        //    41: astore_2        /* scores */
        //    42: aload_2         /* scores */
        //    43: checkcast       Ljava/lang/Iterable;
        //    46: astore_3        /* $this$map$iv */
        //    47: iconst_0       
        //    48: istore          $i$f$map
        //    50: aload_3         /* $this$map$iv */
        //    51: astore          5
        //    53: new             Ljava/util/ArrayList;
        //    56: dup            
        //    57: aload_3         /* $this$map$iv */
        //    58: bipush          10
        //    60: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    63: invokespecial   java/util/ArrayList.<init>:(I)V
        //    66: checkcast       Ljava/util/Collection;
        //    69: astore          destination$iv$iv
        //    71: iconst_0       
        //    72: istore          $i$f$mapTo
        //    74: aload           $this$mapTo$iv$iv
        //    76: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    81: astore          8
        //    83: aload           8
        //    85: invokeinterface java/util/Iterator.hasNext:()Z
        //    90: ifeq            152
        //    93: aload           8
        //    95: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   100: astore          item$iv$iv
        //   102: aload           destination$iv$iv
        //   104: aload           item$iv$iv
        //   106: checkcast       Lnet/minecraft/scoreboard/Score;
        //   109: astore          10
        //   111: astore          13
        //   113: iconst_0       
        //   114: istore          $i$a$-map-TabList$getNamesByObjectives$1
        //   116: aload_0         /* scoreboard */
        //   117: aload           it
        //   119: invokevirtual   net/minecraft/scoreboard/Score.getPlayerName:()Ljava/lang/String;
        //   122: invokevirtual   net/minecraft/scoreboard/Scoreboard.getPlayersTeam:(Ljava/lang/String;)Lnet/minecraft/scoreboard/ScorePlayerTeam;
        //   125: astore          team
        //   127: aload           team
        //   129: checkcast       Lnet/minecraft/scoreboard/Team;
        //   132: aload           it
        //   134: invokevirtual   net/minecraft/scoreboard/Score.getPlayerName:()Ljava/lang/String;
        //   137: invokestatic    net/minecraft/scoreboard/ScorePlayerTeam.formatPlayerName:(Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
        //   140: aload           13
        //   142: swap           
        //   143: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   148: pop            
        //   149: goto            83
        //   152: aload           destination$iv$iv
        //   154: checkcast       Ljava/util/List;
        //   157: nop            
        //   158: areturn        
        //    Signature:
        //  ()Ljava/util/List<Ljava/lang/String;>;
        //    StackMapTable: 00 04 4C 07 00 3F FF 00 0E 00 01 07 00 3F 00 01 07 00 45 FF 00 37 00 09 07 00 3F 07 00 45 07 00 5E 07 00 53 01 07 00 53 07 00 5E 01 07 00 64 00 00 FB 00 44
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
    public static final List<String> getNames() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/Client$Companion.getTabGui:()Lnet/minecraft/client/gui/GuiPlayerTabOverlay;
        //     6: ifnonnull       13
        //     9: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    12: areturn        
        //    13: getstatic       com/chattriggers/ctjs/minecraft/wrappers/TabList.playerComparator:Lcom/google/common/collect/Ordering;
        //    16: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Player.getPlayer:()Lnet/minecraft/client/entity/EntityPlayerSP;
        //    19: dup            
        //    20: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //    23: getfield        net/minecraft/client/entity/EntityPlayerSP.sendQueue:Lnet/minecraft/client/network/NetHandlerPlayClient;
        //    26: invokevirtual   net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfoMap:()Ljava/util/Collection;
        //    29: checkcast       Ljava/lang/Iterable;
        //    32: invokevirtual   com/google/common/collect/Ordering.sortedCopy:(Ljava/lang/Iterable;)Ljava/util/List;
        //    35: astore_0        /* playerList */
        //    36: aload_0         /* playerList */
        //    37: ldc             "playerList"
        //    39: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    42: aload_0         /* playerList */
        //    43: checkcast       Ljava/lang/Iterable;
        //    46: astore_1       
        //    47: getstatic       com/chattriggers/ctjs/minecraft/wrappers/Client.Companion:Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion;
        //    50: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/Client$Companion.getTabGui:()Lnet/minecraft/client/gui/GuiPlayerTabOverlay;
        //    53: dup            
        //    54: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //    57: astore_2       
        //    58: iconst_0       
        //    59: istore_3        /* $i$f$map */
        //    60: aload_1         /* $this$map$iv */
        //    61: astore          4
        //    63: new             Ljava/util/ArrayList;
        //    66: dup            
        //    67: aload_1         /* $this$map$iv */
        //    68: bipush          10
        //    70: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    73: invokespecial   java/util/ArrayList.<init>:(I)V
        //    76: checkcast       Ljava/util/Collection;
        //    79: astore          destination$iv$iv
        //    81: iconst_0       
        //    82: istore          $i$f$mapTo
        //    84: aload           $this$mapTo$iv$iv
        //    86: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    91: astore          7
        //    93: aload           7
        //    95: invokeinterface java/util/Iterator.hasNext:()Z
        //   100: ifeq            144
        //   103: aload           7
        //   105: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   110: astore          item$iv$iv
        //   112: aload           destination$iv$iv
        //   114: aload           item$iv$iv
        //   116: checkcast       Lnet/minecraft/client/network/NetworkPlayerInfo;
        //   119: astore          9
        //   121: astore          11
        //   123: iconst_0       
        //   124: istore          $i$a$-map-TabList$getNames$1
        //   126: aload_2        
        //   127: aload           p0
        //   129: invokevirtual   net/minecraft/client/gui/GuiPlayerTabOverlay.getPlayerName:(Lnet/minecraft/client/network/NetworkPlayerInfo;)Ljava/lang/String;
        //   132: aload           11
        //   134: swap           
        //   135: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   140: pop            
        //   141: goto            93
        //   144: aload           destination$iv$iv
        //   146: checkcast       Ljava/util/List;
        //   149: nop            
        //   150: areturn        
        //    Signature:
        //  ()Ljava/util/List<Ljava/lang/String;>;
        //    StackMapTable: 00 03 0D FF 00 4F 00 08 07 00 84 07 00 53 07 00 C6 01 07 00 53 07 00 5E 01 07 00 64 00 00 32
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
    public static final List<String> getUnformattedNames() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifnonnull       10
        //     6: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //     9: areturn        
        //    10: getstatic       com/chattriggers/ctjs/minecraft/wrappers/Client.Companion:Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion;
        //    13: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/Client$Companion.getConnection:()Lnet/minecraft/client/network/NetHandlerPlayClient;
        //    16: astore_1       
        //    17: aload_1        
        //    18: ifnonnull       25
        //    21: aconst_null    
        //    22: goto            169
        //    25: aload_1        
        //    26: invokevirtual   net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfoMap:()Ljava/util/Collection;
        //    29: astore_2       
        //    30: aload_2        
        //    31: ifnonnull       38
        //    34: aconst_null    
        //    35: goto            169
        //    38: aload_2        
        //    39: astore          it
        //    41: iconst_0       
        //    42: istore          $i$a$-let-TabList$getUnformattedNames$1
        //    44: getstatic       com/chattriggers/ctjs/minecraft/wrappers/TabList.playerComparator:Lcom/google/common/collect/Ordering;
        //    47: aload           it
        //    49: checkcast       Ljava/lang/Iterable;
        //    52: invokevirtual   com/google/common/collect/Ordering.sortedCopy:(Ljava/lang/Iterable;)Ljava/util/List;
        //    55: nop            
        //    56: astore_3       
        //    57: aload_3        
        //    58: ifnonnull       65
        //    61: aconst_null    
        //    62: goto            169
        //    65: aload_3        
        //    66: checkcast       Ljava/lang/Iterable;
        //    69: astore          4
        //    71: nop            
        //    72: iconst_0       
        //    73: istore          $i$f$map
        //    75: aload           $this$map$iv
        //    77: astore          6
        //    79: new             Ljava/util/ArrayList;
        //    82: dup            
        //    83: aload           $this$map$iv
        //    85: bipush          10
        //    87: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    90: invokespecial   java/util/ArrayList.<init>:(I)V
        //    93: checkcast       Ljava/util/Collection;
        //    96: astore          destination$iv$iv
        //    98: iconst_0       
        //    99: istore          $i$f$mapTo
        //   101: aload           $this$mapTo$iv$iv
        //   103: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   108: astore          9
        //   110: aload           9
        //   112: invokeinterface java/util/Iterator.hasNext:()Z
        //   117: ifeq            163
        //   120: aload           9
        //   122: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   127: astore          item$iv$iv
        //   129: aload           destination$iv$iv
        //   131: aload           item$iv$iv
        //   133: checkcast       Lnet/minecraft/client/network/NetworkPlayerInfo;
        //   136: astore          11
        //   138: astore          13
        //   140: iconst_0       
        //   141: istore          $i$a$-map-TabList$getUnformattedNames$2
        //   143: aload           it
        //   145: invokevirtual   net/minecraft/client/network/NetworkPlayerInfo.getGameProfile:()Lcom/mojang/authlib/GameProfile;
        //   148: invokevirtual   com/mojang/authlib/GameProfile.getName:()Ljava/lang/String;
        //   151: aload           13
        //   153: swap           
        //   154: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   159: pop            
        //   160: goto            110
        //   163: aload           destination$iv$iv
        //   165: checkcast       Ljava/util/List;
        //   168: nop            
        //   169: astore_0       
        //   170: aload_0        
        //   171: ifnonnull       180
        //   174: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   177: goto            181
        //   180: aload_0        
        //   181: areturn        
        //    Signature:
        //  ()Ljava/util/List<Ljava/lang/String;>;
        //    StackMapTable: 00 09 0A FD 00 0E 00 07 00 B8 FC 00 0C 07 00 5E FF 00 1A 00 07 00 07 00 B8 07 00 5E 07 00 84 00 07 00 5E 01 00 00 FF 00 2C 00 0A 00 07 00 B8 07 00 5E 07 00 84 07 00 53 01 07 00 53 07 00 5E 01 07 00 64 00 00 34 FF 00 05 00 02 00 07 00 B8 00 01 07 00 84 FF 00 0A 00 02 07 00 84 07 00 B8 00 00 40 07 00 84
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
    public static final Message getHeaderMessage() {
        final GuiPlayerTabOverlay tabGui = Client.Companion.getTabGui();
        Message message;
        if (tabGui == null) {
            message = null;
        }
        else {
            final IChatComponent header = tabGui.header;
            if (header == null) {
                message = null;
            }
            else {
                final IChatComponent p0 = header;
                final int n = 0;
                message = new Message(p0);
            }
        }
        return message;
    }
    
    @JvmStatic
    @Nullable
    public static final String getHeader() {
        final GuiPlayerTabOverlay tabGui = Client.Companion.getTabGui();
        String s;
        if (tabGui == null) {
            s = null;
        }
        else {
            final IChatComponent header = tabGui.header;
            s = ((header == null) ? null : header.getFormattedText());
        }
        return s;
    }
    
    @JvmStatic
    public static final void setHeader(@Nullable final Object header) {
        if (header instanceof String) {
            final GuiPlayerTabOverlay tabGui = Client.Companion.getTabGui();
            if (tabGui != null) {
                tabGui.header = new Message(new Object[] { header }).getChatMessage();
            }
        }
        else if (header instanceof Message) {
            final GuiPlayerTabOverlay tabGui2 = Client.Companion.getTabGui();
            if (tabGui2 != null) {
                tabGui2.header = ((Message)header).getChatMessage();
            }
        }
        else if (header instanceof IChatComponent) {
            final GuiPlayerTabOverlay tabGui3 = Client.Companion.getTabGui();
            if (tabGui3 != null) {
                tabGui3.header = (IChatComponent)header;
            }
        }
        else if (header == null) {
            final GuiPlayerTabOverlay tabGui4 = Client.Companion.getTabGui();
            if (tabGui4 != null) {
                tabGui4.header = (IChatComponent)header;
            }
        }
    }
    
    @JvmStatic
    public static final void clearHeader() {
        final TabList instance = TabList.INSTANCE;
        setHeader(null);
    }
    
    @JvmStatic
    @Nullable
    public static final Message getFooterMessage() {
        final GuiPlayerTabOverlay tabGui = Client.Companion.getTabGui();
        Message message;
        if (tabGui == null) {
            message = null;
        }
        else {
            final IChatComponent footer = tabGui.footer;
            if (footer == null) {
                message = null;
            }
            else {
                final IChatComponent p0 = footer;
                final int n = 0;
                message = new Message(p0);
            }
        }
        return message;
    }
    
    @JvmStatic
    @Nullable
    public static final String getFooter() {
        final GuiPlayerTabOverlay tabGui = Client.Companion.getTabGui();
        String s;
        if (tabGui == null) {
            s = null;
        }
        else {
            final IChatComponent footer = tabGui.footer;
            s = ((footer == null) ? null : footer.getFormattedText());
        }
        return s;
    }
    
    @JvmStatic
    public static final void setFooter(@Nullable final Object footer) {
        if (footer instanceof String) {
            final GuiPlayerTabOverlay tabGui = Client.Companion.getTabGui();
            if (tabGui != null) {
                tabGui.footer = new Message(new Object[] { footer }).getChatMessage();
            }
        }
        else if (footer instanceof Message) {
            final GuiPlayerTabOverlay tabGui2 = Client.Companion.getTabGui();
            if (tabGui2 != null) {
                tabGui2.footer = ((Message)footer).getChatMessage();
            }
        }
        else if (footer instanceof IChatComponent) {
            final GuiPlayerTabOverlay tabGui3 = Client.Companion.getTabGui();
            if (tabGui3 != null) {
                tabGui3.footer = (IChatComponent)footer;
            }
        }
        else if (footer == null) {
            final GuiPlayerTabOverlay tabGui4 = Client.Companion.getTabGui();
            if (tabGui4 != null) {
                tabGui4.footer = (IChatComponent)footer;
            }
        }
    }
    
    @JvmStatic
    public static final void clearFooter() {
        final TabList instance = TabList.INSTANCE;
        setFooter(null);
    }
    
    static {
        INSTANCE = new TabList();
        playerComparator = Ordering.from((Comparator)new PlayerComparator());
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/TabList$PlayerComparator;", "Ljava/util/Comparator;", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "Lkotlin/Comparator;", "()V", "compare", "", "playerOne", "playerTwo", "ctjs" })
    public static final class PlayerComparator implements Comparator<NetworkPlayerInfo>
    {
        @Override
        public int compare(@NotNull final NetworkPlayerInfo playerOne, @NotNull final NetworkPlayerInfo playerTwo) {
            Intrinsics.checkNotNullParameter((Object)playerOne, "playerOne");
            Intrinsics.checkNotNullParameter((Object)playerTwo, "playerTwo");
            final ScorePlayerTeam teamOne = playerOne.getPlayerTeam();
            final ScorePlayerTeam teamTwo = playerTwo.getPlayerTeam();
            final ComparisonChain compareTrueFirst = ComparisonChain.start().compareTrueFirst(playerOne.getGameType() != WorldSettings$GameType.SPECTATOR, playerTwo.getGameType() != WorldSettings$GameType.SPECTATOR);
            final ScorePlayerTeam scorePlayerTeam = teamOne;
            String getRegisteredName;
            if (scorePlayerTeam == null) {
                getRegisteredName = "";
            }
            else if ((getRegisteredName = scorePlayerTeam.getRegisteredName()) == null) {
                getRegisteredName = "";
            }
            final String s = getRegisteredName;
            final ScorePlayerTeam scorePlayerTeam2 = teamTwo;
            String getRegisteredName2;
            if (scorePlayerTeam2 == null) {
                getRegisteredName2 = "";
            }
            else if ((getRegisteredName2 = scorePlayerTeam2.getRegisteredName()) == null) {
                getRegisteredName2 = "";
            }
            return compareTrueFirst.compare((Comparable)s, (Comparable)getRegisteredName2).compare((Comparable)playerOne.getGameProfile().getName(), (Comparable)playerTwo.getGameProfile().getName()).result();
        }
    }
}
