//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import com.chattriggers.ctjs.triggers.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSRegister;", "Lcom/chattriggers/ctjs/engine/IRegister;", "()V", "getImplementationLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "ctjs" })
public final class JSRegister implements IRegister
{
    @NotNull
    public static final JSRegister INSTANCE;
    
    private JSRegister() {
    }
    
    @NotNull
    public ILoader getImplementationLoader() {
        return (ILoader)JSLoader.INSTANCE;
    }
    
    @NotNull
    public Trigger register(@NotNull final Object triggerType, @NotNull final Object method) {
        return IRegister.DefaultImpls.register((IRegister)this, triggerType, method);
    }
    
    @NotNull
    public ChatTrigger registerChat(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerChat((IRegister)this, method);
    }
    
    @NotNull
    public ChatTrigger registerActionBar(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerActionBar((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerWorldLoad(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerWorldLoad((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerWorldUnload(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerWorldUnload((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerClicked(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerClicked((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerScrolled(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerScrolled((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerDragged(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerDragged((IRegister)this, method);
    }
    
    @NotNull
    public SoundPlayTrigger registerSoundPlay(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerSoundPlay((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerNoteBlockPlay(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerNoteBlockPlay((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerNoteBlockChange(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerNoteBlockChange((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerTick(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerTick((IRegister)this, method);
    }
    
    @NotNull
    public StepTrigger registerStep(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerStep((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerRenderWorld(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderWorld((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderOverlay(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderOverlay((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderPlayerList(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderPlayerList((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderCrosshair(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderCrosshair((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderDebug(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderDebug((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderBossHealth(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderBossHealth((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderHealth(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderHealth((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderArmor(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderArmor((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderFood(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderFood((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderMountHealth(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderMountHealth((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderExperience(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderExperience((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderHotbar(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderHotbar((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderAir(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderAir((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderPortal(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderPortal((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderJumpBar(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderJumpBar((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderChat(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderChat((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderHelmet(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderHelmet((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderHand(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderHand((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderScoreboard(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderScoreboard((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderTitle(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderTitle((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerDrawBlockHighlight(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerDrawBlockHighlight((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerGameLoad(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGameLoad((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerGameUnload(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGameUnload((IRegister)this, method);
    }
    
    @NotNull
    public CommandTrigger registerCommand(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerCommand((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerGuiOpened(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiOpened((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerGuiClosed(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiClosed((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerPlayerJoined(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPlayerJoined((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerPlayerLeft(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPlayerLeft((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerPickupItem(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPickupItem((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerDropItem(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerDropItem((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerScreenshotTaken(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerScreenshotTaken((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerMessageSent(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerMessageSent((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerItemTooltip(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerItemTooltip((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerPlayerInteract(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPlayerInteract((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerBlockBreak(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerBlockBreak((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerEntityDamage(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerEntityDamage((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerEntityDeath(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerEntityDeath((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerGuiDrawBackground(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiDrawBackground((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerGuiRender(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiRender((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerGuiKey(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiKey((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerGuiMouseClick(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiMouseClick((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerGuiMouseRelease(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiMouseRelease((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerGuiMouseDrag(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerGuiMouseDrag((IRegister)this, method);
    }
    
    @NotNull
    public PacketTrigger registerPacketSent(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPacketSent((IRegister)this, method);
    }
    
    @NotNull
    public PacketTrigger registerPacketReceived(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPacketReceived((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerServerConnect(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerServerConnect((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerServerDisconnect(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerServerDisconnect((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerChatComponentClicked(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerChatComponentClicked((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerChatComponentHovered(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerChatComponentHovered((IRegister)this, method);
    }
    
    @NotNull
    public RenderEntityTrigger registerRenderEntity(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderEntity((IRegister)this, method);
    }
    
    @NotNull
    public RenderEntityTrigger registerPostRenderEntity(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPostRenderEntity((IRegister)this, method);
    }
    
    @NotNull
    public RenderTileEntityTrigger registerRenderTileEntity(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderTileEntity((IRegister)this, method);
    }
    
    @NotNull
    public RenderTileEntityTrigger registerPostRenderTileEntity(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPostRenderTileEntity((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerPostGuiRender(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPostGuiRender((IRegister)this, method);
    }
    
    @NotNull
    public RegularTrigger registerPreItemRender(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerPreItemRender((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderSlot(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderSlot((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderItemIntoGui(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderItemIntoGui((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderItemOverlayIntoGui(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderItemOverlayIntoGui((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerRenderSlotHighlight(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerRenderSlotHighlight((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerSpawnParticle(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerSpawnParticle((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerAttackEntity(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerAttackEntity((IRegister)this, method);
    }
    
    @NotNull
    public EventTrigger registerHitBlock(@NotNull final Object method) {
        return IRegister.DefaultImpls.registerHitBlock((IRegister)this, method);
    }
    
    static {
        INSTANCE = new JSRegister();
    }
}
