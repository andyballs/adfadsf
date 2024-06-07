//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.engine.module.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\bN\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bT¨\u0006U" }, d2 = { "Lcom/chattriggers/ctjs/triggers/TriggerType;", "", "(Ljava/lang/String;I)V", "triggerAll", "", "args", "", "", "([Ljava/lang/Object;)V", "Chat", "ActionBar", "Tick", "Step", "GameUnload", "GameLoad", "Clicked", "Scrolled", "Dragged", "GuiOpened", "ScreenshotTaken", "PickupItem", "DropItem", "MessageSent", "Tooltip", "PlayerInteract", "AttackEntity", "HitBlock", "GuiRender", "GuiKey", "GuiMouseClick", "GuiMouseRelease", "GuiMouseDrag", "ChatComponentClicked", "ChatComponentHovered", "PacketSent", "PacketReceived", "ServerConnect", "ServerDisconnect", "GuiClosed", "RenderSlot", "GuiDrawBackground", "RenderWorld", "BlockHighlight", "RenderOverlay", "RenderPlayerList", "RenderBossHealth", "RenderDebug", "RenderCrosshair", "RenderHotbar", "RenderExperience", "RenderArmor", "RenderHealth", "RenderFood", "RenderMountHealth", "RenderAir", "RenderPortal", "RenderJumpBar", "RenderChat", "RenderHelmet", "RenderHand", "RenderScoreboard", "RenderTitle", "RenderEntity", "PostGuiRender", "PreItemRender", "RenderItemIntoGui", "RenderItemOverlayIntoGui", "RenderSlotHighlight", "PostRenderEntity", "RenderTileEntity", "PostRenderTileEntity", "PlayerJoin", "PlayerLeave", "SoundPlay", "NoteBlockPlay", "NoteBlockChange", "WorldLoad", "WorldUnload", "BlockBreak", "SpawnParticle", "EntityDeath", "EntityDamage", "Forge", "Command", "Other", "ctjs" })
public enum TriggerType
{
    Chat, 
    ActionBar, 
    Tick, 
    Step, 
    GameUnload, 
    GameLoad, 
    Clicked, 
    Scrolled, 
    Dragged, 
    GuiOpened, 
    ScreenshotTaken, 
    PickupItem, 
    DropItem, 
    MessageSent, 
    Tooltip, 
    PlayerInteract, 
    AttackEntity, 
    HitBlock, 
    GuiRender, 
    GuiKey, 
    GuiMouseClick, 
    GuiMouseRelease, 
    GuiMouseDrag, 
    ChatComponentClicked, 
    ChatComponentHovered, 
    PacketSent, 
    PacketReceived, 
    ServerConnect, 
    ServerDisconnect, 
    GuiClosed, 
    RenderSlot, 
    GuiDrawBackground, 
    RenderWorld, 
    BlockHighlight, 
    RenderOverlay, 
    RenderPlayerList, 
    RenderBossHealth, 
    RenderDebug, 
    RenderCrosshair, 
    RenderHotbar, 
    RenderExperience, 
    RenderArmor, 
    RenderHealth, 
    RenderFood, 
    RenderMountHealth, 
    RenderAir, 
    RenderPortal, 
    RenderJumpBar, 
    RenderChat, 
    RenderHelmet, 
    RenderHand, 
    RenderScoreboard, 
    RenderTitle, 
    RenderEntity, 
    PostGuiRender, 
    PreItemRender, 
    RenderItemIntoGui, 
    RenderItemOverlayIntoGui, 
    RenderSlotHighlight, 
    PostRenderEntity, 
    RenderTileEntity, 
    PostRenderTileEntity, 
    PlayerJoin, 
    PlayerLeave, 
    SoundPlay, 
    NoteBlockPlay, 
    NoteBlockChange, 
    WorldLoad, 
    WorldUnload, 
    BlockBreak, 
    SpawnParticle, 
    EntityDeath, 
    EntityDamage, 
    Forge, 
    Command, 
    Other;
    
    public final void triggerAll(@NotNull final Object... args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        ModuleManager.INSTANCE.trigger(this, args);
    }
    
    private static final /* synthetic */ TriggerType[] $values() {
        return new TriggerType[] { TriggerType.Chat, TriggerType.ActionBar, TriggerType.Tick, TriggerType.Step, TriggerType.GameUnload, TriggerType.GameLoad, TriggerType.Clicked, TriggerType.Scrolled, TriggerType.Dragged, TriggerType.GuiOpened, TriggerType.ScreenshotTaken, TriggerType.PickupItem, TriggerType.DropItem, TriggerType.MessageSent, TriggerType.Tooltip, TriggerType.PlayerInteract, TriggerType.AttackEntity, TriggerType.HitBlock, TriggerType.GuiRender, TriggerType.GuiKey, TriggerType.GuiMouseClick, TriggerType.GuiMouseRelease, TriggerType.GuiMouseDrag, TriggerType.ChatComponentClicked, TriggerType.ChatComponentHovered, TriggerType.PacketSent, TriggerType.PacketReceived, TriggerType.ServerConnect, TriggerType.ServerDisconnect, TriggerType.GuiClosed, TriggerType.RenderSlot, TriggerType.GuiDrawBackground, TriggerType.RenderWorld, TriggerType.BlockHighlight, TriggerType.RenderOverlay, TriggerType.RenderPlayerList, TriggerType.RenderBossHealth, TriggerType.RenderDebug, TriggerType.RenderCrosshair, TriggerType.RenderHotbar, TriggerType.RenderExperience, TriggerType.RenderArmor, TriggerType.RenderHealth, TriggerType.RenderFood, TriggerType.RenderMountHealth, TriggerType.RenderAir, TriggerType.RenderPortal, TriggerType.RenderJumpBar, TriggerType.RenderChat, TriggerType.RenderHelmet, TriggerType.RenderHand, TriggerType.RenderScoreboard, TriggerType.RenderTitle, TriggerType.RenderEntity, TriggerType.PostGuiRender, TriggerType.PreItemRender, TriggerType.RenderItemIntoGui, TriggerType.RenderItemOverlayIntoGui, TriggerType.RenderSlotHighlight, TriggerType.PostRenderEntity, TriggerType.RenderTileEntity, TriggerType.PostRenderTileEntity, TriggerType.PlayerJoin, TriggerType.PlayerLeave, TriggerType.SoundPlay, TriggerType.NoteBlockPlay, TriggerType.NoteBlockChange, TriggerType.WorldLoad, TriggerType.WorldUnload, TriggerType.BlockBreak, TriggerType.SpawnParticle, TriggerType.EntityDeath, TriggerType.EntityDamage, TriggerType.Forge, TriggerType.Command, TriggerType.Other };
    }
    
    static {
        $VALUES = $values();
    }
}
