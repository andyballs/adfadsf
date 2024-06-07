//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import kotlin.*;
import net.minecraft.client.multiplayer.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import kotlin.jvm.*;
import net.minecraftforge.client.*;
import java.util.*;
import net.minecraft.scoreboard.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0007J\b\u0010\u0015\u001a\u00020\tH\u0007J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u0010\u0019\u001a\u00020\tH\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\tH\u0007J\b\u0010#\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard;", "", "()V", "needsUpdate", "", "scoreboardNames", "", "Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score;", "scoreboardTitle", "", "getLineByIndex", "index", "", "getLines", "", "descending", "getLinesByScore", "score", "getScoreboard", "Lnet/minecraft/scoreboard/Scoreboard;", "Lcom/chattriggers/ctjs/utils/kotlin/MCScoreboard;", "getScoreboardTitle", "getShouldRender", "getSidebar", "Lnet/minecraft/scoreboard/ScoreObjective;", "getTitle", "resetCache", "", "setLine", "line", "override", "setShouldRender", "shouldRender", "setTitle", "title", "updateNames", "Score", "ctjs" })
public final class Scoreboard
{
    @NotNull
    public static final Scoreboard INSTANCE;
    private static boolean needsUpdate;
    @NotNull
    private static List<Score> scoreboardNames;
    @NotNull
    private static String scoreboardTitle;
    
    private Scoreboard() {
    }
    
    @JvmStatic
    @Nullable
    public static final net.minecraft.scoreboard.Scoreboard getScoreboard() {
        final WorldClient world = World.getWorld();
        return (world == null) ? null : world.getScoreboard();
    }
    
    @JvmStatic
    @Nullable
    public static final ScoreObjective getSidebar() {
        final Scoreboard instance = Scoreboard.INSTANCE;
        final net.minecraft.scoreboard.Scoreboard scoreboard = getScoreboard();
        return (scoreboard == null) ? null : scoreboard.getObjectiveInDisplaySlot(1);
    }
    
    @JvmStatic
    @NotNull
    public static final String getScoreboardTitle() {
        final Scoreboard instance = Scoreboard.INSTANCE;
        return getTitle();
    }
    
    @JvmStatic
    @NotNull
    public static final String getTitle() {
        if (Scoreboard.needsUpdate) {
            Scoreboard.INSTANCE.updateNames();
            final Scoreboard instance = Scoreboard.INSTANCE;
            Scoreboard.needsUpdate = false;
        }
        return Scoreboard.scoreboardTitle;
    }
    
    @JvmStatic
    public static final void setTitle(@NotNull final String title) {
        Intrinsics.checkNotNullParameter((Object)title, "title");
        final Scoreboard instance = Scoreboard.INSTANCE;
        final ScoreObjective sidebar = getSidebar();
        if (sidebar != null) {
            sidebar.setDisplayName(title);
        }
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<Score> getLines(final boolean descending) {
        if (Scoreboard.needsUpdate) {
            Scoreboard.INSTANCE.updateNames();
            final Scoreboard instance = Scoreboard.INSTANCE;
            Scoreboard.needsUpdate = false;
        }
        return descending ? Scoreboard.scoreboardNames : CollectionsKt.asReversedMutable((List)Scoreboard.scoreboardNames);
    }
    
    public static /* synthetic */ List getLines$default(boolean descending, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            descending = true;
        }
        return getLines(descending);
    }
    
    @JvmStatic
    @NotNull
    public static final Score getLineByIndex(final int index) {
        final Scoreboard instance = Scoreboard.INSTANCE;
        return getLines$default(false, 1, null).get(index);
    }
    
    @JvmStatic
    @NotNull
    public static final List<Score> getLinesByScore(final int score) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        //     4: iconst_0       
        //     5: iconst_1       
        //     6: aconst_null    
        //     7: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.getLines$default:(ZILjava/lang/Object;)Ljava/util/List;
        //    10: checkcast       Ljava/lang/Iterable;
        //    13: astore_1        /* $this$filter$iv */
        //    14: iconst_0       
        //    15: istore_2        /* $i$f$filter */
        //    16: aload_1         /* $this$filter$iv */
        //    17: astore_3       
        //    18: new             Ljava/util/ArrayList;
        //    21: dup            
        //    22: invokespecial   java/util/ArrayList.<init>:()V
        //    25: checkcast       Ljava/util/Collection;
        //    28: astore          destination$iv$iv
        //    30: iconst_0       
        //    31: istore          $i$f$filterTo
        //    33: aload_3         /* $this$filterTo$iv$iv */
        //    34: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    39: astore          6
        //    41: aload           6
        //    43: invokeinterface java/util/Iterator.hasNext:()Z
        //    48: ifeq            100
        //    51: aload           6
        //    53: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    58: astore          element$iv$iv
        //    60: aload           element$iv$iv
        //    62: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score;
        //    65: astore          it
        //    67: iconst_0       
        //    68: istore          $i$a$-filter-Scoreboard$getLinesByScore$1
        //    70: aload           it
        //    72: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score.getPoints:()I
        //    75: iload_0         /* score */
        //    76: if_icmpne       83
        //    79: iconst_1       
        //    80: goto            84
        //    83: iconst_0       
        //    84: ifeq            41
        //    87: aload           destination$iv$iv
        //    89: aload           element$iv$iv
        //    91: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    96: pop            
        //    97: goto            41
        //   100: aload           destination$iv$iv
        //   102: checkcast       Ljava/util/List;
        //   105: nop            
        //   106: areturn        
        //    Signature:
        //  (I)Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score;>;
        //    StackMapTable: 00 04 FF 00 29 00 07 01 07 00 88 01 07 00 88 07 00 8D 01 07 00 93 00 00 FE 00 29 07 00 04 07 00 32 01 40 01 F8 00 0F
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
    public static final void setLine(final int score, @NotNull final String line, final boolean override) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "line"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: getstatic       com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard;
        //     9: pop            
        //    10: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.getScoreboard:()Lnet/minecraft/scoreboard/Scoreboard;
        //    13: dup            
        //    14: ifnonnull       19
        //    17: pop            
        //    18: return         
        //    19: astore_3        /* scoreboard */
        //    20: getstatic       com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard;
        //    23: pop            
        //    24: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.getSidebar:()Lnet/minecraft/scoreboard/ScoreObjective;
        //    27: dup            
        //    28: ifnonnull       33
        //    31: pop            
        //    32: return         
        //    33: astore          sidebarObjective
        //    35: aload_3         /* scoreboard */
        //    36: aload           sidebarObjective
        //    38: invokevirtual   net/minecraft/scoreboard/Scoreboard.getSortedScores:(Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
        //    41: astore          6
        //    43: aload           6
        //    45: ldc             "scoreboard.getSortedScores(sidebarObjective)"
        //    47: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    50: aload           6
        //    52: astore          scores
        //    54: iload_2         /* override */
        //    55: ifeq            224
        //    58: aload           scores
        //    60: checkcast       Ljava/lang/Iterable;
        //    63: astore          $this$filter$iv
        //    65: iconst_0       
        //    66: istore          $i$f$filter
        //    68: aload           $this$filter$iv
        //    70: astore          8
        //    72: new             Ljava/util/ArrayList;
        //    75: dup            
        //    76: invokespecial   java/util/ArrayList.<init>:()V
        //    79: checkcast       Ljava/util/Collection;
        //    82: astore          destination$iv$iv
        //    84: iconst_0       
        //    85: istore          $i$f$filterTo
        //    87: aload           $this$filterTo$iv$iv
        //    89: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    94: astore          11
        //    96: aload           11
        //    98: invokeinterface java/util/Iterator.hasNext:()Z
        //   103: ifeq            155
        //   106: aload           11
        //   108: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   113: astore          element$iv$iv
        //   115: aload           element$iv$iv
        //   117: checkcast       Lnet/minecraft/scoreboard/Score;
        //   120: astore          it
        //   122: iconst_0       
        //   123: istore          $i$a$-filter-Scoreboard$setLine$1
        //   125: aload           it
        //   127: invokevirtual   net/minecraft/scoreboard/Score.getScorePoints:()I
        //   130: iload_0         /* score */
        //   131: if_icmpne       138
        //   134: iconst_1       
        //   135: goto            139
        //   138: iconst_0       
        //   139: ifeq            96
        //   142: aload           destination$iv$iv
        //   144: aload           element$iv$iv
        //   146: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   151: pop            
        //   152: goto            96
        //   155: aload           destination$iv$iv
        //   157: checkcast       Ljava/util/List;
        //   160: nop            
        //   161: checkcast       Ljava/lang/Iterable;
        //   164: astore          6
        //   166: nop            
        //   167: iconst_0       
        //   168: istore          $i$f$forEach
        //   170: aload           $this$forEach$iv
        //   172: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   177: astore          8
        //   179: aload           8
        //   181: invokeinterface java/util/Iterator.hasNext:()Z
        //   186: ifeq            223
        //   189: aload           8
        //   191: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   196: astore          element$iv
        //   198: aload           element$iv
        //   200: checkcast       Lnet/minecraft/scoreboard/Score;
        //   203: astore          it
        //   205: iconst_0       
        //   206: istore          $i$a$-forEach-Scoreboard$setLine$2
        //   208: aload_3         /* scoreboard */
        //   209: aload           it
        //   211: invokevirtual   net/minecraft/scoreboard/Score.getPlayerName:()Ljava/lang/String;
        //   214: aload           sidebarObjective
        //   216: invokevirtual   net/minecraft/scoreboard/Scoreboard.removeObjectiveFromEntity:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)V
        //   219: nop            
        //   220: goto            179
        //   223: nop            
        //   224: aload_3         /* scoreboard */
        //   225: aload_1         /* line */
        //   226: aload           sidebarObjective
        //   228: invokevirtual   net/minecraft/scoreboard/Scoreboard.getValueFromObjective:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Lnet/minecraft/scoreboard/Score;
        //   231: dup            
        //   232: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //   235: astore          theScore
        //   237: aload           theScore
        //   239: iload_0         /* score */
        //   240: invokevirtual   net/minecraft/scoreboard/Score.setScorePoints:(I)V
        //   243: return         
        //    StackMapTable: 00 09 53 07 00 4C FF 00 0D 00 04 01 07 00 B2 01 07 00 4C 00 01 07 00 57 FF 00 3E 00 0C 01 07 00 B2 01 07 00 4C 07 00 57 07 00 8D 07 00 88 01 07 00 88 07 00 8D 01 07 00 93 00 00 FE 00 29 07 00 04 07 00 BD 01 40 01 F8 00 0F FF 00 17 00 0A 01 07 00 B2 01 07 00 4C 07 00 57 07 00 8D 07 00 88 01 07 00 93 07 00 04 00 00 2B FF 00 00 00 07 01 07 00 B2 01 07 00 4C 07 00 57 07 00 8D 07 00 04 00 00
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
    public static final void setShouldRender(final boolean shouldRender) {
        GuiIngameForge.renderObjective = shouldRender;
    }
    
    @JvmStatic
    public static final boolean getShouldRender() {
        return GuiIngameForge.renderObjective;
    }
    
    private final void updateNames() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokeinterface java/util/List.clear:()V
        //     8: ldc             ""
        //    10: putstatic       com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.scoreboardTitle:Ljava/lang/String;
        //    13: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.getScoreboard:()Lnet/minecraft/scoreboard/Scoreboard;
        //    16: dup            
        //    17: ifnonnull       22
        //    20: pop            
        //    21: return         
        //    22: astore_1        /* scoreboard */
        //    23: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.getSidebar:()Lnet/minecraft/scoreboard/ScoreObjective;
        //    26: dup            
        //    27: ifnonnull       32
        //    30: pop            
        //    31: return         
        //    32: astore_2        /* sidebarObjective */
        //    33: aload_2         /* sidebarObjective */
        //    34: invokevirtual   net/minecraft/scoreboard/ScoreObjective.getDisplayName:()Ljava/lang/String;
        //    37: astore_3       
        //    38: aload_3        
        //    39: ldc             "sidebarObjective.displayName"
        //    41: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    44: aload_3        
        //    45: putstatic       com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.scoreboardTitle:Ljava/lang/String;
        //    48: aload_1         /* scoreboard */
        //    49: aload_2         /* sidebarObjective */
        //    50: invokevirtual   net/minecraft/scoreboard/Scoreboard.getSortedScores:(Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
        //    53: astore          4
        //    55: aload           4
        //    57: ldc             "scoreboard.getSortedScores(sidebarObjective)"
        //    59: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    62: aload           4
        //    64: astore_3        /* scores */
        //    65: aload_3         /* scores */
        //    66: checkcast       Ljava/lang/Iterable;
        //    69: astore          $this$map$iv
        //    71: iconst_0       
        //    72: istore          $i$f$map
        //    74: aload           $this$map$iv
        //    76: astore          6
        //    78: new             Ljava/util/ArrayList;
        //    81: dup            
        //    82: aload           $this$map$iv
        //    84: bipush          10
        //    86: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    89: invokespecial   java/util/ArrayList.<init>:(I)V
        //    92: checkcast       Ljava/util/Collection;
        //    95: astore          destination$iv$iv
        //    97: iconst_0       
        //    98: istore          $i$f$mapTo
        //   100: aload           $this$mapTo$iv$iv
        //   102: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   107: astore          9
        //   109: aload           9
        //   111: invokeinterface java/util/Iterator.hasNext:()Z
        //   116: ifeq            163
        //   119: aload           9
        //   121: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   126: astore          item$iv$iv
        //   128: aload           destination$iv$iv
        //   130: aload           item$iv$iv
        //   132: checkcast       Lnet/minecraft/scoreboard/Score;
        //   135: astore          11
        //   137: astore          13
        //   139: iconst_0       
        //   140: istore          $i$a$-map-Scoreboard$updateNames$1
        //   142: new             Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score;
        //   145: dup            
        //   146: aload           p0
        //   148: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score.<init>:(Lnet/minecraft/scoreboard/Score;)V
        //   151: aload           13
        //   153: swap           
        //   154: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   159: pop            
        //   160: goto            109
        //   163: aload           destination$iv$iv
        //   165: checkcast       Ljava/util/List;
        //   168: nop            
        //   169: checkcast       Ljava/util/Collection;
        //   172: invokestatic    kotlin/collections/CollectionsKt.toMutableList:(Ljava/util/Collection;)Ljava/util/List;
        //   175: putstatic       com/chattriggers/ctjs/minecraft/wrappers/Scoreboard.scoreboardNames:Ljava/util/List;
        //   178: return         
        //    StackMapTable: 00 04 56 07 00 4C FF 00 09 00 02 07 00 02 07 00 4C 00 01 07 00 57 FF 00 4C 00 0A 07 00 02 07 00 4C 07 00 57 07 00 8D 07 00 88 01 07 00 88 07 00 8D 01 07 00 93 00 00 35
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
    public static final void resetCache() {
        final Scoreboard instance = Scoreboard.INSTANCE;
        Scoreboard.needsUpdate = true;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final List<Score> getLines() {
        return (List<Score>)getLines$default(false, 1, null);
    }
    
    static {
        INSTANCE = new Scoreboard();
        Scoreboard.needsUpdate = true;
        Scoreboard.scoreboardNames = new ArrayList<Score>();
        Scoreboard.scoreboardTitle = "";
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Scoreboard$Score;", "", "score", "Lnet/minecraft/scoreboard/Score;", "Lcom/chattriggers/ctjs/utils/kotlin/MCScore;", "(Lnet/minecraft/scoreboard/Score;)V", "getScore", "()Lnet/minecraft/scoreboard/Score;", "getName", "", "getPoints", "", "toString", "ctjs" })
    public static final class Score
    {
        @NotNull
        private final net.minecraft.scoreboard.Score score;
        
        public Score(@NotNull final net.minecraft.scoreboard.Score score) {
            Intrinsics.checkNotNullParameter((Object)score, "score");
            this.score = score;
        }
        
        @NotNull
        public final net.minecraft.scoreboard.Score getScore() {
            return this.score;
        }
        
        public final int getPoints() {
            return this.score.getScorePoints();
        }
        
        @NotNull
        public final String getName() {
            final net.minecraft.scoreboard.Scoreboard scoreboard = Scoreboard.getScoreboard();
            Intrinsics.checkNotNull((Object)scoreboard);
            final String formatPlayerName = ScorePlayerTeam.formatPlayerName((Team)scoreboard.getPlayersTeam(this.score.getPlayerName()), this.score.getPlayerName());
            Intrinsics.checkNotNullExpressionValue((Object)formatPlayerName, "formatPlayerName(\n      \u2026core.playerName\n        )");
            return formatPlayerName;
        }
        
        @NotNull
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
