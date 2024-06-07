//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.listeners;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import com.chattriggers.ctjs.triggers.*;
import net.minecraftforge.client.event.sound.*;
import org.lwjgl.util.vector.*;
import java.lang.constant.*;
import net.minecraft.client.audio.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001dH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/WorldListener;", "", "()V", "playerList", "", "", "shouldTriggerWorldLoad", "", "attackEntityEvent", "", "event", "Lnet/minecraftforge/event/entity/player/AttackEntityEvent;", "livingDeathEvent", "Lnet/minecraftforge/event/entity/living/LivingDeathEvent;", "noteBlockEventChange", "Lnet/minecraftforge/event/world/NoteBlockEvent$Change;", "noteBlockEventPlay", "Lnet/minecraftforge/event/world/NoteBlockEvent$Play;", "onRenderGameOverlay", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;", "onRenderWorld", "Lnet/minecraftforge/client/event/RenderWorldLastEvent;", "onSoundPlay", "Lnet/minecraftforge/client/event/sound/PlaySoundEvent;", "onWorldLoad", "Lnet/minecraftforge/event/world/WorldEvent$Load;", "onWorldUnload", "Lnet/minecraftforge/event/world/WorldEvent$Unload;", "updatePlayerList", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;", "ctjs" })
public final class WorldListener
{
    @NotNull
    public static final WorldListener INSTANCE;
    private static boolean shouldTriggerWorldLoad;
    @NotNull
    private static List<String> playerList;
    
    private WorldListener() {
    }
    
    @SubscribeEvent
    public final void onWorldLoad(@NotNull final WorldEvent$Load event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        WorldListener.playerList.clear();
        WorldListener.shouldTriggerWorldLoad = true;
    }
    
    @SubscribeEvent
    public final void onRenderGameOverlay(@NotNull final RenderGameOverlayEvent$Pre event) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "event"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: getstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.shouldTriggerWorldLoad:Z
        //     9: ifne            13
        //    12: return         
        //    13: getstatic       com/chattriggers/ctjs/triggers/TriggerType.WorldLoad:Lcom/chattriggers/ctjs/triggers/TriggerType;
        //    16: iconst_0       
        //    17: anewarray       Ljava/lang/Object;
        //    20: invokevirtual   com/chattriggers/ctjs/triggers/TriggerType.triggerAll:([Ljava/lang/Object;)V
        //    23: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //    26: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getPendingOldModules:()Ljava/util/List;
        //    29: checkcast       Ljava/lang/Iterable;
        //    32: astore_2       
        //    33: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //    36: astore_3       
        //    37: iconst_0       
        //    38: istore          $i$f$forEach
        //    40: aload_2         /* $this$forEach$iv */
        //    41: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    46: astore          5
        //    48: aload           5
        //    50: invokeinterface java/util/Iterator.hasNext:()Z
        //    55: ifeq            86
        //    58: aload           5
        //    60: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    65: astore          element$iv
        //    67: aload           element$iv
        //    69: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //    72: astore          p0
        //    74: iconst_0       
        //    75: istore          $i$a$-forEach-WorldListener$onRenderGameOverlay$1
        //    77: aload_3        
        //    78: aload           p0
        //    80: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.reportOldVersion:(Lcom/chattriggers/ctjs/engine/module/Module;)V
        //    83: goto            48
        //    86: nop            
        //    87: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //    90: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getPendingOldModules:()Ljava/util/List;
        //    93: invokeinterface java/util/List.clear:()V
        //    98: iconst_0       
        //    99: putstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.shouldTriggerWorldLoad:Z
        //   102: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //   105: invokevirtual   com/chattriggers/ctjs/CTJS.getSounds:()Ljava/util/List;
        //   108: checkcast       Ljava/lang/Iterable;
        //   111: astore_2       
        //   112: nop            
        //   113: iconst_0       
        //   114: istore_3        /* $i$f$filter */
        //   115: aload_2         /* $this$filter$iv */
        //   116: astore          4
        //   118: new             Ljava/util/ArrayList;
        //   121: dup            
        //   122: invokespecial   java/util/ArrayList.<init>:()V
        //   125: checkcast       Ljava/util/Collection;
        //   128: astore          destination$iv$iv
        //   130: iconst_0       
        //   131: istore          $i$f$filterTo
        //   133: aload           $this$filterTo$iv$iv
        //   135: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   140: astore          7
        //   142: aload           7
        //   144: invokeinterface java/util/Iterator.hasNext:()Z
        //   149: ifeq            192
        //   152: aload           7
        //   154: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   159: astore          element$iv$iv
        //   161: aload           element$iv$iv
        //   163: checkcast       Lcom/chattriggers/ctjs/minecraft/objects/Sound;
        //   166: astore          it
        //   168: iconst_0       
        //   169: istore          $i$a$-filter-WorldListener$onRenderGameOverlay$2
        //   171: aload           it
        //   173: invokevirtual   com/chattriggers/ctjs/minecraft/objects/Sound.isListening:()Z
        //   176: ifeq            142
        //   179: aload           destination$iv$iv
        //   181: aload           element$iv$iv
        //   183: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   188: pop            
        //   189: goto            142
        //   192: aload           destination$iv$iv
        //   194: checkcast       Ljava/util/List;
        //   197: nop            
        //   198: checkcast       Ljava/lang/Iterable;
        //   201: astore_2       
        //   202: nop            
        //   203: iconst_0       
        //   204: istore_3        /* $i$f$forEach */
        //   205: aload_2         /* $this$forEach$iv */
        //   206: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   211: astore          4
        //   213: aload           4
        //   215: invokeinterface java/util/Iterator.hasNext:()Z
        //   220: ifeq            250
        //   223: aload           4
        //   225: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   230: astore          element$iv
        //   232: aload           element$iv
        //   234: checkcast       Lcom/chattriggers/ctjs/minecraft/objects/Sound;
        //   237: astore          it
        //   239: iconst_0       
        //   240: istore          $i$a$-forEach-WorldListener$onRenderGameOverlay$3
        //   242: aload           it
        //   244: invokevirtual   com/chattriggers/ctjs/minecraft/objects/Sound.onWorldLoad:()V
        //   247: goto            213
        //   250: nop            
        //   251: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //   254: invokevirtual   com/chattriggers/ctjs/CTJS.getSounds:()Ljava/util/List;
        //   257: invokeinterface java/util/List.clear:()V
        //   262: return         
        //    StackMapTable: 00 07 0D FF 00 22 00 06 07 00 02 07 00 62 07 00 5C 07 00 53 01 07 00 64 00 00 25 FF 00 37 00 08 07 00 02 07 00 62 07 00 5C 01 07 00 5C 07 00 7F 01 07 00 64 00 00 31 FF 00 14 00 06 07 00 02 07 00 62 07 00 5C 01 07 00 64 07 00 04 00 00 24
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
    
    @SubscribeEvent
    public final void onRenderWorld(@NotNull final RenderWorldLastEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        Tessellator.setPartialTicks$ctjs(event.partialTicks);
        TriggerType.RenderWorld.triggerAll(event.partialTicks);
    }
    
    @SubscribeEvent
    public final void onWorldUnload(@NotNull final WorldEvent$Unload event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        TriggerType.WorldUnload.triggerAll(new Object[0]);
    }
    
    @SubscribeEvent
    public final void onSoundPlay(@NotNull final PlaySoundEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final Vector3f position = new Vector3f(event.sound.getXPosF(), event.sound.getYPosF(), event.sound.getZPosF());
        Constable constable;
        try {
            constable = event.sound.getVolume();
        }
        catch (Exception ignored) {
            constable = 0;
        }
        final Object vol = constable;
        Constable constable2;
        try {
            constable2 = event.sound.getPitch();
        }
        catch (Exception ignored2) {
            constable2 = 1;
        }
        final Object pitch = constable2;
        final TriggerType soundPlay = TriggerType.SoundPlay;
        final Object[] array;
        final Object[] args = array = new Object[] { position, event.name, vol, pitch, null, null };
        final int n = 4;
        Object category;
        if ((category = event.category) == null) {
            final SoundCategory category2 = event.category;
            category = ((category2 == null) ? null : category2.getCategoryName());
        }
        array[n] = category;
        args[5] = event;
        soundPlay.triggerAll(args);
    }
    
    @SubscribeEvent
    public final void noteBlockEventPlay(@NotNull final NoteBlockEvent$Play event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final Vector3f position = new Vector3f((float)event.pos.getX(), (float)event.pos.getY(), (float)event.pos.getZ());
        TriggerType.NoteBlockPlay.triggerAll(position, event.getNote().name(), event.getOctave(), event);
    }
    
    @SubscribeEvent
    public final void noteBlockEventChange(@NotNull final NoteBlockEvent$Change event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final Vector3f position = new Vector3f((float)event.pos.getX(), (float)event.pos.getY(), (float)event.pos.getZ());
        TriggerType.NoteBlockChange.triggerAll(position, event.getNote().name(), event.getOctave(), event);
    }
    
    @SubscribeEvent
    public final void updatePlayerList(@NotNull final TickEvent$ClientTickEvent event) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "event"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* event */
        //     7: getfield        net/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent.phase:Lnet/minecraftforge/fml/common/gameevent/TickEvent$Phase;
        //    10: getstatic       net/minecraftforge/fml/common/gameevent/TickEvent$Phase.END:Lnet/minecraftforge/fml/common/gameevent/TickEvent$Phase;
        //    13: if_acmpne       17
        //    16: return         
        //    17: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getAllPlayers:()Ljava/util/List;
        //    20: checkcast       Ljava/lang/Iterable;
        //    23: astore_2        /* $this$filter$iv */
        //    24: iconst_0       
        //    25: istore_3        /* $i$f$filter */
        //    26: aload_2         /* $this$filter$iv */
        //    27: astore          4
        //    29: new             Ljava/util/ArrayList;
        //    32: dup            
        //    33: invokespecial   java/util/ArrayList.<init>:()V
        //    36: checkcast       Ljava/util/Collection;
        //    39: astore          destination$iv$iv
        //    41: iconst_0       
        //    42: istore          $i$f$filterTo
        //    44: aload           $this$filterTo$iv$iv
        //    46: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    51: astore          7
        //    53: aload           7
        //    55: invokeinterface java/util/Iterator.hasNext:()Z
        //    60: ifeq            119
        //    63: aload           7
        //    65: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    70: astore          element$iv$iv
        //    72: aload           element$iv$iv
        //    74: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;
        //    77: astore          it
        //    79: iconst_0       
        //    80: istore          $i$a$-filter-WorldListener$updatePlayerList$1
        //    82: getstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.playerList:Ljava/util/List;
        //    85: aload           it
        //    87: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP.getName:()Ljava/lang/String;
        //    90: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //    95: ifne            102
        //    98: iconst_1       
        //    99: goto            103
        //   102: iconst_0       
        //   103: ifeq            53
        //   106: aload           destination$iv$iv
        //   108: aload           element$iv$iv
        //   110: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   115: pop            
        //   116: goto            53
        //   119: aload           destination$iv$iv
        //   121: checkcast       Ljava/util/List;
        //   124: nop            
        //   125: checkcast       Ljava/lang/Iterable;
        //   128: astore_2       
        //   129: nop            
        //   130: iconst_0       
        //   131: istore_3        /* $i$f$forEach */
        //   132: aload_2         /* $this$forEach$iv */
        //   133: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   138: astore          4
        //   140: aload           4
        //   142: invokeinterface java/util/Iterator.hasNext:()Z
        //   147: ifeq            207
        //   150: aload           4
        //   152: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   157: astore          element$iv
        //   159: aload           element$iv
        //   161: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;
        //   164: astore          it
        //   166: iconst_0       
        //   167: istore          $i$a$-forEach-WorldListener$updatePlayerList$2
        //   169: getstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.playerList:Ljava/util/List;
        //   172: aload           it
        //   174: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP.getName:()Ljava/lang/String;
        //   177: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   182: pop            
        //   183: getstatic       com/chattriggers/ctjs/triggers/TriggerType.PlayerJoin:Lcom/chattriggers/ctjs/triggers/TriggerType;
        //   186: iconst_1       
        //   187: anewarray       Ljava/lang/Object;
        //   190: astore          8
        //   192: aload           8
        //   194: iconst_0       
        //   195: aload           it
        //   197: aastore        
        //   198: aload           8
        //   200: invokevirtual   com/chattriggers/ctjs/triggers/TriggerType.triggerAll:([Ljava/lang/Object;)V
        //   203: nop            
        //   204: goto            140
        //   207: nop            
        //   208: getstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.playerList:Ljava/util/List;
        //   211: invokeinterface java/util/List.listIterator:()Ljava/util/ListIterator;
        //   216: astore_2        /* ite */
        //   217: aload_2         /* ite */
        //   218: invokeinterface java/util/ListIterator.hasNext:()Z
        //   223: ifeq            275
        //   226: aload_2         /* ite */
        //   227: invokeinterface java/util/ListIterator.next:()Ljava/lang/Object;
        //   232: checkcast       Ljava/lang/String;
        //   235: astore_3        /* it */
        //   236: aload_3         /* it */
        //   237: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/World.getPlayerByName:(Ljava/lang/String;)Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;
        //   240: ifnonnull       217
        //   243: getstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.playerList:Ljava/util/List;
        //   246: aload_3         /* it */
        //   247: invokeinterface java/util/List.remove:(Ljava/lang/Object;)Z
        //   252: pop            
        //   253: getstatic       com/chattriggers/ctjs/triggers/TriggerType.PlayerLeave:Lcom/chattriggers/ctjs/triggers/TriggerType;
        //   256: iconst_1       
        //   257: anewarray       Ljava/lang/Object;
        //   260: astore          4
        //   262: aload           4
        //   264: iconst_0       
        //   265: aload_3         /* it */
        //   266: aastore        
        //   267: aload           4
        //   269: invokevirtual   com/chattriggers/ctjs/triggers/TriggerType.triggerAll:([Ljava/lang/Object;)V
        //   272: goto            275
        //   275: return         
        //    StackMapTable: 00 09 11 FF 00 23 00 08 07 00 02 07 01 24 07 00 5C 01 07 00 5C 07 00 7F 01 07 00 64 00 00 FE 00 30 07 00 04 07 01 34 01 40 01 F8 00 0F FF 00 14 00 06 07 00 02 07 01 24 07 00 5C 01 07 00 64 07 00 04 00 00 FB 00 42 FF 00 09 00 06 07 00 02 07 01 24 07 01 44 00 07 00 64 07 00 04 00 00 FF 00 39 00 06 07 00 02 07 01 24 07 01 44 00 07 00 04 07 00 04 00 00
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
    
    @SubscribeEvent
    public final void livingDeathEvent(@NotNull final LivingDeathEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final TriggerType entityDeath = TriggerType.EntityDeath;
        final Object[] args = { null };
        final int n = 0;
        final net.minecraft.entity.Entity entity = event.entity;
        Intrinsics.checkNotNullExpressionValue((Object)entity, "event.entity");
        args[n] = new Entity(entity);
        entityDeath.triggerAll(args);
    }
    
    @SubscribeEvent
    public final void attackEntityEvent(@NotNull final AttackEntityEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final TriggerType entityDamage = TriggerType.EntityDamage;
        final Object[] array;
        final Object[] args = array = new Object[2];
        final int n = 0;
        final net.minecraft.entity.Entity target = event.target;
        Intrinsics.checkNotNullExpressionValue((Object)target, "event.target");
        array[n] = new Entity(target);
        final Object[] array2 = args;
        final int n2 = 1;
        final EntityPlayer entityPlayer = event.entityPlayer;
        Intrinsics.checkNotNullExpressionValue((Object)entityPlayer, "event.entityPlayer");
        array2[n2] = new PlayerMP(entityPlayer);
        entityDamage.triggerAll(args);
    }
    
    static {
        INSTANCE = new WorldListener();
        WorldListener.playerList = new ArrayList<String>();
    }
}
