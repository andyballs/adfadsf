//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.listeners;

import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import com.chattriggers.ctjs.triggers.*;
import com.chattriggers.ctjs.utils.*;
import com.chattriggers.ctjs.*;
import com.chattriggers.ctjs.utils.console.*;
import net.minecraftforge.fml.common.eventhandler.*;
import kotlin.jvm.functions.*;
import kotlin.collections.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraftforge.fml.common.network.*;
import io.netty.channel.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.util.vector.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import net.minecraft.entity.player.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.block.*;
import net.minecraftforge.event.entity.item.*;
import kotlin.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.client.event.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002:;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020%H\u0007J\u001a\u0010&\u001a\u00020'2\n\u0010(\u001a\u00060)j\u0002`*2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u000202H\u0007J\u0010\u00103\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u00106\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u000207H\u0007J\u0010\u00108\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u000209H\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/ClientListener;", "", "()V", "actionBarHistory", "", "", "getActionBarHistory", "()Ljava/util/List;", "chatHistory", "getChatHistory", "tasks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/chattriggers/ctjs/minecraft/listeners/ClientListener$Task;", "ticksPassed", "", "addTask", "", "delay", "callback", "Lkotlin/Function0;", "handleOverlayTriggers", "event", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;", "onBlockHighlight", "Lnet/minecraftforge/client/event/DrawBlockHighlightEvent;", "onClientDisconnect", "Lnet/minecraftforge/fml/common/network/FMLNetworkEvent$ClientDisconnectionFromServerEvent;", "onDrawScreenEvent", "Lnet/minecraftforge/client/event/GuiScreenEvent$DrawScreenEvent$Post;", "onDropItem", "Lnet/minecraftforge/event/entity/item/ItemTossEvent;", "onGuiOpened", "Lnet/minecraftforge/client/event/GuiOpenEvent;", "onGuiRender", "e", "Lnet/minecraftforge/client/event/GuiScreenEvent$BackgroundDrawnEvent;", "onHandRender", "Lnet/minecraftforge/client/event/RenderHandEvent;", "onHitBlock", "", "pos", "Lnet/minecraft/util/BlockPos;", "Lcom/chattriggers/ctjs/utils/kotlin/MCBlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "onInteract", "Lnet/minecraftforge/event/entity/player/PlayerInteractEvent;", "onNetworkEvent", "Lnet/minecraftforge/fml/common/network/FMLNetworkEvent$ClientConnectedToServerEvent;", "onPickupItem", "Lnet/minecraftforge/event/entity/player/EntityItemPickupEvent;", "onReceiveChat", "Lnet/minecraftforge/client/event/ClientChatReceivedEvent;", "onRenderGameOverlay", "onRenderTick", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$RenderTickEvent;", "onTick", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;", "PlayerInteractAction", "Task", "ctjs" })
public final class ClientListener
{
    @NotNull
    public static final ClientListener INSTANCE;
    private static int ticksPassed;
    @NotNull
    private static final List<String> chatHistory;
    @NotNull
    private static final List<String> actionBarHistory;
    @NotNull
    private static final CopyOnWriteArrayList<Task> tasks;
    
    private ClientListener() {
    }
    
    @NotNull
    public final List<String> getChatHistory() {
        return ClientListener.chatHistory;
    }
    
    @NotNull
    public final List<String> getActionBarHistory() {
        return ClientListener.actionBarHistory;
    }
    
    @SubscribeEvent
    public final void onReceiveChat(@NotNull final ClientChatReceivedEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final int type = EventLib.getType(event);
        if (0 <= type && type < 2) {
            ClientListener.chatHistory.add(ChatLib.getChatMessage(event, true));
            if (ClientListener.chatHistory.size() > 1000) {
                ClientListener.chatHistory.remove(0);
            }
            TriggerType.Chat.triggerAll(ChatLib.getChatMessage(event, false), event);
            if (Config.INSTANCE.getPrintChatToConsole()) {
                ReferenceKt.printToConsole$default(Intrinsics.stringPlus("[CHAT] ", (Object)ChatLib.replaceFormatting(ChatLib.getChatMessage(event, true))), null, null, 3, null);
            }
        }
        else if (type == 2) {
            ClientListener.actionBarHistory.add(ChatLib.getChatMessage(event, true));
            if (ClientListener.actionBarHistory.size() > 1000) {
                ClientListener.actionBarHistory.remove(0);
            }
            TriggerType.ActionBar.triggerAll(ChatLib.getChatMessage(event, false), event);
        }
    }
    
    public final void addTask(final int delay, @NotNull final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)callback, "callback");
        ClientListener.tasks.add(new Task(delay, callback));
    }
    
    @SubscribeEvent
    public final void onTick(@NotNull final TickEvent$ClientTickEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (event.phase == TickEvent$Phase.END) {
            return;
        }
        CollectionsKt.removeAll((List)ClientListener.tasks, (Function1)ClientListener$onTick.ClientListener$onTick$1.INSTANCE);
        if (!World.isLoaded()) {
            return;
        }
        TriggerType.Tick.triggerAll(ClientListener.ticksPassed);
        ++ClientListener.ticksPassed;
        Scoreboard.resetCache();
    }
    
    @SubscribeEvent
    public final void onClientDisconnect(@NotNull final FMLNetworkEvent$ClientDisconnectionFromServerEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        TriggerType.ServerDisconnect.triggerAll(event);
    }
    
    @SubscribeEvent
    public final void onNetworkEvent(@NotNull final FMLNetworkEvent$ClientConnectedToServerEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        TriggerType.ServerConnect.triggerAll(event);
        event.manager.channel().pipeline().addAfter("fml:packet_handler", "CT_packet_handler", (ChannelHandler)new ClientListener$onNetworkEvent.ClientListener$onNetworkEvent$1());
    }
    
    @SubscribeEvent
    public final void onDrawScreenEvent(@NotNull final GuiScreenEvent$DrawScreenEvent$Post event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        TriggerType.PostGuiRender.triggerAll(event.mouseX, event.mouseY, event.gui);
    }
    
    @SubscribeEvent
    public final void onRenderTick(@NotNull final TickEvent$RenderTickEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        TriggerType.Step.triggerAll(new Object[0]);
        if (World.isLoaded()) {
            MouseListener.INSTANCE.handleDragged$ctjs();
        }
    }
    
    @SubscribeEvent
    public final void onRenderGameOverlay(@NotNull final RenderGameOverlayEvent$Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        GlStateManager.pushMatrix();
        this.handleOverlayTriggers(event);
        GlStateManager.popMatrix();
    }
    
    private final void handleOverlayTriggers(final RenderGameOverlayEvent$Pre event) {
        final RenderGameOverlayEvent$ElementType type = event.type;
        switch ((type == null) ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1: {
                TriggerType.RenderPlayerList.triggerAll(event);
                break;
            }
            case 2: {
                TriggerType.RenderCrosshair.triggerAll(event);
                break;
            }
            case 3: {
                TriggerType.RenderDebug.triggerAll(event);
                break;
            }
            case 4: {
                TriggerType.RenderBossHealth.triggerAll(event);
                break;
            }
            case 5: {
                TriggerType.RenderHealth.triggerAll(event);
                break;
            }
            case 6: {
                TriggerType.RenderArmor.triggerAll(event);
                break;
            }
            case 7: {
                TriggerType.RenderFood.triggerAll(event);
                break;
            }
            case 8: {
                TriggerType.RenderMountHealth.triggerAll(event);
                break;
            }
            case 9: {
                TriggerType.RenderExperience.triggerAll(event);
                break;
            }
            case 10: {
                TriggerType.RenderHotbar.triggerAll(event);
                break;
            }
            case 11: {
                TriggerType.RenderAir.triggerAll(event);
                break;
            }
            case 12: {
                TriggerType.RenderOverlay.triggerAll(event);
                break;
            }
            case 13: {
                TriggerType.RenderPortal.triggerAll(event);
                break;
            }
            case 14: {
                TriggerType.RenderJumpBar.triggerAll(event);
                break;
            }
            case 15: {
                TriggerType.RenderChat.triggerAll(event);
                break;
            }
            case 16: {
                TriggerType.RenderHelmet.triggerAll(event);
                break;
            }
        }
    }
    
    @SubscribeEvent
    public final void onGuiOpened(@NotNull final GuiOpenEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (event.gui != null) {
            TriggerType.GuiOpened.triggerAll(event);
        }
    }
    
    @SubscribeEvent
    public final void onBlockHighlight(@NotNull final DrawBlockHighlightEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (event.target == null || event.target.getBlockPos() == null) {
            return;
        }
        final Vector3f position = new Vector3f((float)event.target.getBlockPos().getX(), (float)event.target.getBlockPos().getY(), (float)event.target.getBlockPos().getZ());
        TriggerType.BlockHighlight.triggerAll(position, event);
    }
    
    @SubscribeEvent
    public final void onPickupItem(@NotNull final EntityItemPickupEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (!(event.entityPlayer instanceof EntityPlayerMP)) {
            return;
        }
        final EntityPlayer entityPlayer = event.entityPlayer;
        if (entityPlayer == null) {
            throw new NullPointerException("null cannot be cast to non-null type net.minecraft.entity.player.EntityPlayerMP");
        }
        final EntityPlayerMP player = (EntityPlayerMP)entityPlayer;
        final EntityItem item = event.item;
        final Vector3f position = new Vector3f((float)item.posX, (float)item.posY, (float)item.posZ);
        final Vector3f motion = new Vector3f((float)item.motionX, (float)item.motionY, (float)item.motionZ);
        final TriggerType pickupItem = TriggerType.PickupItem;
        final Object[] array;
        final Object[] args = array = new Object[5];
        final int n = 0;
        final ItemStack getEntityItem = item.getEntityItem();
        Intrinsics.checkNotNullExpressionValue((Object)getEntityItem, "item.entityItem");
        array[n] = new Item(getEntityItem);
        args[1] = new PlayerMP((EntityPlayer)player);
        args[2] = position;
        args[3] = motion;
        args[4] = event;
        pickupItem.triggerAll(args);
    }
    
    public final boolean onHitBlock(@NotNull final BlockPos pos, @NotNull final EnumFacing facing) {
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        Intrinsics.checkNotNullParameter((Object)facing, "facing");
        final CancellableEvent event = new CancellableEvent();
        TriggerType.HitBlock.triggerAll(World.getBlockAt(pos.getX(), pos.getY(), pos.getZ()).withFace(BlockFace.Companion.fromMCEnumFacing(facing)), event);
        return event.isCancelled();
    }
    
    @SubscribeEvent
    public final void onDropItem(@NotNull final ItemTossEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final EntityItem item = event.entityItem;
        final Vector3f position = new Vector3f((float)item.posX, (float)item.posY, (float)item.posZ);
        final Vector3f motion = new Vector3f((float)item.motionX, (float)item.motionY, (float)item.motionZ);
        final TriggerType dropItem = TriggerType.DropItem;
        final Object[] array;
        final Object[] args = array = new Object[5];
        final int n = 0;
        Intrinsics.checkNotNullExpressionValue((Object)item, "item");
        array[n] = new Item(item);
        final Object[] array2 = args;
        final int n2 = 1;
        final EntityPlayer player = event.player;
        Intrinsics.checkNotNullExpressionValue((Object)player, "event.player");
        array2[n2] = new PlayerMP(player);
        args[2] = position;
        args[3] = motion;
        args[4] = event;
        dropItem.triggerAll(args);
    }
    
    @SubscribeEvent
    public final void onGuiRender(@NotNull final GuiScreenEvent$BackgroundDrawnEvent e) {
        Intrinsics.checkNotNullParameter((Object)e, "e");
        GlStateManager.pushMatrix();
        TriggerType.GuiRender.triggerAll(e.getMouseX(), e.getMouseY(), e.gui);
        GlStateManager.popMatrix();
    }
    
    @SubscribeEvent
    public final void onInteract(@NotNull final PlayerInteractEvent e) {
        Intrinsics.checkNotNullParameter((Object)e, "e");
        final PlayerInteractEvent$Action action2 = e.action;
        PlayerInteractAction playerInteractAction = null;
        switch ((action2 == null) ? -1 : WhenMappings.$EnumSwitchMapping$1[action2.ordinal()]) {
            case 1: {
                return;
            }
            case 2: {
                playerInteractAction = PlayerInteractAction.RIGHT_CLICK_EMPTY;
                break;
            }
            case 3: {
                playerInteractAction = PlayerInteractAction.RIGHT_CLICK_BLOCK;
                break;
            }
            case -1: {
                playerInteractAction = PlayerInteractAction.UNKNOWN;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        final PlayerInteractAction action = playerInteractAction;
        final TriggerType playerInteract = TriggerType.PlayerInteract;
        final Object[] array;
        final Object[] args = array = new Object[] { action, null, null };
        final int n = 1;
        final BlockPos pos = e.pos;
        final float n2 = (float)((pos == null) ? 0 : pos.getX());
        final BlockPos pos2 = e.pos;
        final float n3 = (float)((pos2 == null) ? 0 : pos2.getY());
        final BlockPos pos3 = e.pos;
        array[n] = new Vector3f(n2, n3, (float)((pos3 == null) ? 0 : pos3.getZ()));
        args[2] = e;
        playerInteract.triggerAll(args);
    }
    
    @SubscribeEvent
    public final void onHandRender(@NotNull final RenderHandEvent e) {
        Intrinsics.checkNotNullParameter((Object)e, "e");
        TriggerType.RenderHand.triggerAll(e);
    }
    
    static {
        INSTANCE = new ClientListener();
        chatHistory = new ArrayList<String>();
        actionBarHistory = new ArrayList<String>();
        tasks = new CopyOnWriteArrayList<Task>();
        final ClientListener instance = ClientListener.INSTANCE;
        ClientListener.ticksPassed = 0;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/ClientListener$Task;", "", "delay", "", "callback", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "getDelay", "()I", "setDelay", "(I)V", "ctjs" })
    public static final class Task
    {
        private int delay;
        @NotNull
        private final Function0<Unit> callback;
        
        public Task(final int delay, @NotNull final Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter((Object)callback, "callback");
            this.delay = delay;
            this.callback = callback;
        }
        
        public final int getDelay() {
            return this.delay;
        }
        
        public final void setDelay(final int <set-?>) {
            this.delay = <set-?>;
        }
        
        @NotNull
        public final Function0<Unit> getCallback() {
            return this.callback;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/ClientListener$PlayerInteractAction;", "", "(Ljava/lang/String;I)V", "RIGHT_CLICK_BLOCK", "RIGHT_CLICK_EMPTY", "UNKNOWN", "ctjs" })
    public enum PlayerInteractAction
    {
        RIGHT_CLICK_BLOCK, 
        RIGHT_CLICK_EMPTY, 
        UNKNOWN;
        
        private static final /* synthetic */ PlayerInteractAction[] $values() {
            return new PlayerInteractAction[] { PlayerInteractAction.RIGHT_CLICK_BLOCK, PlayerInteractAction.RIGHT_CLICK_EMPTY, PlayerInteractAction.UNKNOWN };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
