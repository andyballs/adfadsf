//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.reflect.*;
import java.util.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.triggers.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 [2\u00020\u0001:\u0001[J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010-\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00100\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00104\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00106\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u00109\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010>\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010A\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010E\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010H\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010M\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010N\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010O\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010P\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010Q\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010R\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010S\u001a\u00020T2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010U\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010V\u001a\u00020W2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010X\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010Y\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010Z\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016¨\u0006\\" }, d2 = { "Lcom/chattriggers/ctjs/engine/IRegister;", "", "getImplementationLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "register", "Lcom/chattriggers/ctjs/triggers/Trigger;", "triggerType", "method", "registerActionBar", "Lcom/chattriggers/ctjs/triggers/ChatTrigger;", "registerAttackEntity", "Lcom/chattriggers/ctjs/triggers/EventTrigger;", "registerBlockBreak", "Lcom/chattriggers/ctjs/triggers/RegularTrigger;", "registerChat", "registerChatComponentClicked", "registerChatComponentHovered", "registerClicked", "registerCommand", "Lcom/chattriggers/ctjs/triggers/CommandTrigger;", "registerDragged", "registerDrawBlockHighlight", "registerDropItem", "registerEntityDamage", "registerEntityDeath", "registerGameLoad", "registerGameUnload", "registerGuiClosed", "registerGuiDrawBackground", "registerGuiKey", "registerGuiMouseClick", "registerGuiMouseDrag", "registerGuiMouseRelease", "registerGuiOpened", "registerGuiRender", "registerHitBlock", "registerItemTooltip", "registerMessageSent", "registerNoteBlockChange", "registerNoteBlockPlay", "registerPacketReceived", "Lcom/chattriggers/ctjs/triggers/PacketTrigger;", "registerPacketSent", "registerPickupItem", "registerPlayerInteract", "registerPlayerJoined", "registerPlayerLeft", "registerPostGuiRender", "registerPostRenderEntity", "Lcom/chattriggers/ctjs/triggers/RenderEntityTrigger;", "registerPostRenderTileEntity", "Lcom/chattriggers/ctjs/triggers/RenderTileEntityTrigger;", "registerPreItemRender", "registerRenderAir", "registerRenderArmor", "registerRenderBossHealth", "registerRenderChat", "registerRenderCrosshair", "registerRenderDebug", "registerRenderEntity", "registerRenderExperience", "registerRenderFood", "registerRenderHand", "registerRenderHealth", "registerRenderHelmet", "registerRenderHotbar", "registerRenderItemIntoGui", "registerRenderItemOverlayIntoGui", "registerRenderJumpBar", "registerRenderMountHealth", "registerRenderOverlay", "registerRenderPlayerList", "registerRenderPortal", "registerRenderScoreboard", "registerRenderSlot", "registerRenderSlotHighlight", "registerRenderTileEntity", "registerRenderTitle", "registerRenderWorld", "registerScreenshotTaken", "registerScrolled", "registerServerConnect", "registerServerDisconnect", "registerSoundPlay", "Lcom/chattriggers/ctjs/triggers/SoundPlayTrigger;", "registerSpawnParticle", "registerStep", "Lcom/chattriggers/ctjs/triggers/StepTrigger;", "registerTick", "registerWorldLoad", "registerWorldUnload", "Companion", "ctjs" })
public interface IRegister
{
    @NotNull
    public static final Companion Companion = IRegister.Companion.$$INSTANCE;
    
    @NotNull
    Trigger register(@NotNull final Object p0, @NotNull final Object p1);
    
    @NotNull
    ChatTrigger registerChat(@NotNull final Object p0);
    
    @NotNull
    ChatTrigger registerActionBar(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerWorldLoad(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerWorldUnload(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerClicked(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerScrolled(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerDragged(@NotNull final Object p0);
    
    @NotNull
    SoundPlayTrigger registerSoundPlay(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerNoteBlockPlay(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerNoteBlockChange(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerTick(@NotNull final Object p0);
    
    @NotNull
    StepTrigger registerStep(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerRenderWorld(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderOverlay(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderPlayerList(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderCrosshair(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderDebug(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderBossHealth(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderHealth(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderArmor(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderFood(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderMountHealth(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderExperience(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderHotbar(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderAir(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderPortal(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderJumpBar(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderChat(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderHelmet(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderHand(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderScoreboard(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderTitle(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerDrawBlockHighlight(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerGameLoad(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerGameUnload(@NotNull final Object p0);
    
    @NotNull
    CommandTrigger registerCommand(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerGuiOpened(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerGuiClosed(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerPlayerJoined(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerPlayerLeft(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerPickupItem(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerDropItem(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerScreenshotTaken(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerMessageSent(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerItemTooltip(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerPlayerInteract(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerBlockBreak(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerEntityDamage(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerEntityDeath(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerGuiDrawBackground(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerGuiRender(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerGuiKey(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerGuiMouseClick(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerGuiMouseRelease(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerGuiMouseDrag(@NotNull final Object p0);
    
    @NotNull
    PacketTrigger registerPacketSent(@NotNull final Object p0);
    
    @NotNull
    PacketTrigger registerPacketReceived(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerServerConnect(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerServerDisconnect(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerChatComponentClicked(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerChatComponentHovered(@NotNull final Object p0);
    
    @NotNull
    RenderEntityTrigger registerRenderEntity(@NotNull final Object p0);
    
    @NotNull
    RenderEntityTrigger registerPostRenderEntity(@NotNull final Object p0);
    
    @NotNull
    RenderTileEntityTrigger registerRenderTileEntity(@NotNull final Object p0);
    
    @NotNull
    RenderTileEntityTrigger registerPostRenderTileEntity(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerPostGuiRender(@NotNull final Object p0);
    
    @NotNull
    RegularTrigger registerPreItemRender(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderSlot(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderItemIntoGui(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderItemOverlayIntoGui(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerRenderSlotHighlight(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerSpawnParticle(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerAttackEntity(@NotNull final Object p0);
    
    @NotNull
    EventTrigger registerHitBlock(@NotNull final Object p0);
    
    @NotNull
    ILoader getImplementationLoader();
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/engine/IRegister$Companion;", "", "()V", "methodMap", "", "", "Lkotlin/reflect/KFunction;", "ctjs" })
    public static final class Companion
    {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final Map<String, KFunction<?>> methodMap;
        
        private Companion() {
        }
        
        static {
            $$INSTANCE = new Companion();
            methodMap = new LinkedHashMap<String, KFunction<?>>();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        @NotNull
        public static Trigger register(@NotNull final IRegister this, @NotNull final Object triggerType, @NotNull final Object method) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "this"
            //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //     6: aload_1         /* triggerType */
            //     7: ldc             "triggerType"
            //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //    12: aload_2         /* method */
            //    13: ldc             "method"
            //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //    18: aload_1         /* triggerType */
            //    19: instanceof      Ljava/lang/Class;
            //    22: ifeq            47
            //    25: new             Lcom/chattriggers/ctjs/triggers/ForgeTrigger;
            //    28: dup            
            //    29: aload_2         /* method */
            //    30: aload_1         /* triggerType */
            //    31: checkcast       Ljava/lang/Class;
            //    34: aload_0         /* this */
            //    35: invokeinterface com/chattriggers/ctjs/engine/IRegister.getImplementationLoader:()Lcom/chattriggers/ctjs/engine/ILoader;
            //    40: invokespecial   com/chattriggers/ctjs/triggers/ForgeTrigger.<init>:(Ljava/lang/Object;Ljava/lang/Class;Lcom/chattriggers/ctjs/engine/ILoader;)V
            //    43: checkcast       Lcom/chattriggers/ctjs/triggers/Trigger;
            //    46: areturn        
            //    47: aload_1         /* triggerType */
            //    48: instanceof      Ljava/lang/String;
            //    51: ifne            74
            //    54: iconst_0       
            //    55: istore          $i$a$-require-IRegister$register$1
            //    57: ldc             "register() expects a String or Class as its first argument"
            //    59: astore          null
            //    61: new             Ljava/lang/IllegalArgumentException;
            //    64: dup            
            //    65: aload           4
            //    67: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
            //    70: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //    73: athrow         
            //    74: invokestatic    com/chattriggers/ctjs/engine/IRegister$Companion.access$getMethodMap$p:()Ljava/util/Map;
            //    77: astore          4
            //    79: aload_1         /* triggerType */
            //    80: astore          key$iv
            //    82: iconst_0       
            //    83: istore          $i$f$getOrPut
            //    85: aload           $this$getOrPut$iv
            //    87: aload           key$iv
            //    89: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //    94: astore          value$iv
            //    96: aload           value$iv
            //    98: ifnonnull       279
            //   101: iconst_0       
            //   102: istore          $i$a$-getOrPut-IRegister$register$func$1
            //   104: aload_1         /* triggerType */
            //   105: checkcast       Ljava/lang/String;
            //   108: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
            //   111: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
            //   114: dup            
            //   115: ldc             "this as java.lang.String).toLowerCase(Locale.ROOT)"
            //   117: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
            //   120: astore          name
            //   122: aload_0         /* this */
            //   123: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //   126: invokestatic    kotlin/jvm/internal/Reflection.getOrCreateKotlinClass:(Ljava/lang/Class;)Lkotlin/reflect/KClass;
            //   129: invokestatic    kotlin/reflect/full/KClasses.getMemberFunctions:(Lkotlin/reflect/KClass;)Ljava/util/Collection;
            //   132: checkcast       Ljava/lang/Iterable;
            //   135: astore          $this$firstOrNull$iv
            //   137: iconst_0       
            //   138: istore          $i$f$firstOrNull
            //   140: aload           $this$firstOrNull$iv
            //   142: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
            //   147: astore          12
            //   149: aload           12
            //   151: invokeinterface java/util/Iterator.hasNext:()Z
            //   156: ifeq            215
            //   159: aload           12
            //   161: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   166: astore          element$iv
            //   168: aload           element$iv
            //   170: checkcast       Lkotlin/reflect/KFunction;
            //   173: astore          it
            //   175: iconst_0       
            //   176: istore          $i$a$-firstOrNull-IRegister$register$func$1$1
            //   178: aload           it
            //   180: invokeinterface kotlin/reflect/KFunction.getName:()Ljava/lang/String;
            //   185: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
            //   188: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
            //   191: dup            
            //   192: ldc             "this as java.lang.String).toLowerCase(Locale.ROOT)"
            //   194: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
            //   197: ldc             "register"
            //   199: aload           name
            //   201: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
            //   204: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
            //   207: ifeq            149
            //   210: aload           element$iv
            //   212: goto            216
            //   215: aconst_null    
            //   216: checkcast       Lkotlin/reflect/KFunction;
            //   219: astore          16
            //   221: aload           16
            //   223: ifnonnull       258
            //   226: new             Ljava/lang/NoSuchMethodException;
            //   229: dup            
            //   230: new             Ljava/lang/StringBuilder;
            //   233: dup            
            //   234: invokespecial   java/lang/StringBuilder.<init>:()V
            //   237: ldc             "No trigger type named '"
            //   239: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   242: aload_1         /* triggerType */
            //   243: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   246: bipush          39
            //   248: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
            //   251: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   254: invokespecial   java/lang/NoSuchMethodException.<init>:(Ljava/lang/String;)V
            //   257: athrow         
            //   258: aload           16
            //   260: astore          answer$iv
            //   262: aload           $this$getOrPut$iv
            //   264: aload           key$iv
            //   266: aload           answer$iv
            //   268: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   273: pop            
            //   274: aload           answer$iv
            //   276: goto            281
            //   279: aload           value$iv
            //   281: nop            
            //   282: checkcast       Lkotlin/reflect/KFunction;
            //   285: astore_3        /* func */
            //   286: aload_3         /* func */
            //   287: iconst_2       
            //   288: anewarray       Ljava/lang/Object;
            //   291: astore          5
            //   293: aload           5
            //   295: iconst_0       
            //   296: aload_0         /* this */
            //   297: aastore        
            //   298: aload           5
            //   300: iconst_1       
            //   301: aload_2         /* method */
            //   302: aastore        
            //   303: aload           5
            //   305: invokeinterface kotlin/reflect/KFunction.call:([Ljava/lang/Object;)Ljava/lang/Object;
            //   310: dup            
            //   311: ifnonnull       325
            //   314: pop            
            //   315: new             Ljava/lang/NullPointerException;
            //   318: dup            
            //   319: ldc             "null cannot be cast to non-null type com.chattriggers.ctjs.triggers.Trigger"
            //   321: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
            //   324: athrow         
            //   325: checkcast       Lcom/chattriggers/ctjs/triggers/Trigger;
            //   328: areturn        
            //    StackMapTable: 00 09 2F 1A FF 00 4A 00 0D 07 00 10 07 00 04 07 00 04 00 07 00 43 07 00 04 01 07 00 04 01 07 00 30 07 00 68 01 07 00 6E 00 00 FB 00 41 40 07 00 04 FF 00 29 00 11 07 00 10 07 00 04 07 00 04 00 07 00 43 07 00 04 01 07 00 04 01 07 00 30 07 00 68 01 07 00 6E 00 00 00 07 00 78 00 00 FF 00 14 00 08 07 00 10 07 00 04 07 00 04 00 07 00 43 07 00 04 01 07 00 04 00 00 41 07 00 04 FF 00 2B 00 08 07 00 10 07 00 04 07 00 04 07 00 78 07 00 43 07 00 A8 01 07 00 04 00 01 07 00 04
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
        
        @NotNull
        public static ChatTrigger registerChat(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new ChatTrigger(method, TriggerType.Chat, this.getImplementationLoader());
        }
        
        @NotNull
        public static ChatTrigger registerActionBar(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new ChatTrigger(method, TriggerType.ActionBar, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerWorldLoad(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.WorldLoad, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerWorldUnload(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.WorldUnload, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerClicked(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.Clicked, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerScrolled(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.Scrolled, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerDragged(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.Dragged, this.getImplementationLoader());
        }
        
        @NotNull
        public static SoundPlayTrigger registerSoundPlay(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new SoundPlayTrigger(method, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerNoteBlockPlay(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.NoteBlockPlay, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerNoteBlockChange(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.NoteBlockChange, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerTick(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.Tick, this.getImplementationLoader());
        }
        
        @NotNull
        public static StepTrigger registerStep(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new StepTrigger(method, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerRenderWorld(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.RenderWorld, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderOverlay(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderOverlay, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderPlayerList(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderPlayerList, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderCrosshair(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderCrosshair, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderDebug(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderDebug, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderBossHealth(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderBossHealth, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderHealth(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderHealth, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderArmor(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderArmor, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderFood(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderFood, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderMountHealth(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderMountHealth, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderExperience(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderExperience, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderHotbar(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderHotbar, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderAir(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderAir, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderPortal(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderPortal, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderJumpBar(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderJumpBar, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderChat(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderChat, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderHelmet(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderHelmet, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderHand(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderHand, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderScoreboard(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderScoreboard, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderTitle(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderTitle, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerDrawBlockHighlight(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.BlockHighlight, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerGameLoad(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.GameLoad, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerGameUnload(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.GameUnload, this.getImplementationLoader());
        }
        
        @NotNull
        public static CommandTrigger registerCommand(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new CommandTrigger(method, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerGuiOpened(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.GuiOpened, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerGuiClosed(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.GuiClosed, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerPlayerJoined(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.PlayerJoin, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerPlayerLeft(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.PlayerLeave, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerPickupItem(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.PickupItem, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerDropItem(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.DropItem, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerScreenshotTaken(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.ScreenshotTaken, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerMessageSent(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.MessageSent, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerItemTooltip(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.Tooltip, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerPlayerInteract(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.PlayerInteract, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerBlockBreak(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.BlockBreak, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerEntityDamage(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.EntityDamage, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerEntityDeath(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.EntityDeath, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerGuiDrawBackground(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.GuiDrawBackground, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerGuiRender(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.GuiRender, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerGuiKey(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.GuiKey, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerGuiMouseClick(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.GuiMouseClick, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerGuiMouseRelease(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.GuiMouseRelease, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerGuiMouseDrag(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.GuiMouseDrag, this.getImplementationLoader());
        }
        
        @NotNull
        public static PacketTrigger registerPacketSent(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new PacketTrigger(method, TriggerType.PacketSent, this.getImplementationLoader());
        }
        
        @NotNull
        public static PacketTrigger registerPacketReceived(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new PacketTrigger(method, TriggerType.PacketReceived, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerServerConnect(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.ServerConnect, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerServerDisconnect(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.ServerDisconnect, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerChatComponentClicked(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.ChatComponentClicked, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerChatComponentHovered(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.ChatComponentHovered, this.getImplementationLoader());
        }
        
        @NotNull
        public static RenderEntityTrigger registerRenderEntity(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RenderEntityTrigger(method, TriggerType.RenderEntity, this.getImplementationLoader());
        }
        
        @NotNull
        public static RenderEntityTrigger registerPostRenderEntity(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RenderEntityTrigger(method, TriggerType.PostRenderEntity, this.getImplementationLoader());
        }
        
        @NotNull
        public static RenderTileEntityTrigger registerRenderTileEntity(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RenderTileEntityTrigger(method, TriggerType.RenderTileEntity, this.getImplementationLoader());
        }
        
        @NotNull
        public static RenderTileEntityTrigger registerPostRenderTileEntity(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RenderTileEntityTrigger(method, TriggerType.PostRenderTileEntity, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerPostGuiRender(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.PostGuiRender, this.getImplementationLoader());
        }
        
        @NotNull
        public static RegularTrigger registerPreItemRender(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new RegularTrigger(method, TriggerType.PreItemRender, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderSlot(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderSlot, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderItemIntoGui(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderItemIntoGui, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderItemOverlayIntoGui(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderItemOverlayIntoGui, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerRenderSlotHighlight(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.RenderSlotHighlight, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerSpawnParticle(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.SpawnParticle, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerAttackEntity(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.AttackEntity, this.getImplementationLoader());
        }
        
        @NotNull
        public static EventTrigger registerHitBlock(@NotNull final IRegister this, @NotNull final Object method) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter(method, "method");
            return new EventTrigger(method, TriggerType.HitBlock, this.getImplementationLoader());
        }
    }
}
