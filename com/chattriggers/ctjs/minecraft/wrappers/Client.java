//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import com.chattriggers.ctjs.minecraft.objects.keybind.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.*;
import net.minecraft.client.network.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import kotlin.math.*;
import org.lwjgl.input.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import net.minecraft.network.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.entity.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&¨\u0006\f" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Client;", "", "()V", "getKeyBindFromDescription", "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind;", "description", "", "getKeyBindFromKey", "keyCode", "", "category", "Companion", "ctjs" })
public abstract class Client
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Settings settings;
    
    @Nullable
    public abstract KeyBind getKeyBindFromKey(final int p0);
    
    @NotNull
    public abstract KeyBind getKeyBindFromKey(final int p0, @NotNull final String p1, @NotNull final String p2);
    
    @NotNull
    public abstract KeyBind getKeyBindFromKey(final int p0, @NotNull final String p1);
    
    @Nullable
    public abstract KeyBind getKeyBindFromDescription(@NotNull final String p0);
    
    @NotNull
    public static final Settings getSettings() {
        return Client.Companion.getSettings();
    }
    
    @JvmStatic
    @NotNull
    public static final Minecraft getMinecraft() {
        return Client.Companion.getMinecraft();
    }
    
    @JvmStatic
    @Nullable
    public static final NetHandlerPlayClient getConnection() {
        return Client.Companion.getConnection();
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void scheduleTask(final int delay, @NotNull final Function0<Unit> callback) {
        Client.Companion.scheduleTask(delay, callback);
    }
    
    @JvmStatic
    public static final void disconnect() {
        Client.Companion.disconnect();
    }
    
    @JvmStatic
    public static final void connect(@NotNull final String ip) {
        Client.Companion.connect(ip);
    }
    
    @JvmStatic
    @Nullable
    public static final GuiNewChat getChatGUI() {
        return Client.Companion.getChatGUI();
    }
    
    @JvmStatic
    public static final boolean isInChat() {
        return Client.Companion.isInChat();
    }
    
    @JvmStatic
    @Nullable
    public static final GuiPlayerTabOverlay getTabGui() {
        return Client.Companion.getTabGui();
    }
    
    @JvmStatic
    public static final boolean isInTab() {
        return Client.Companion.isInTab();
    }
    
    @JvmStatic
    public static final boolean isTabbedIn() {
        return Client.Companion.isTabbedIn();
    }
    
    @JvmStatic
    public static final boolean isControlDown() {
        return Client.Companion.isControlDown();
    }
    
    @JvmStatic
    public static final boolean isShiftDown() {
        return Client.Companion.isShiftDown();
    }
    
    @JvmStatic
    public static final boolean isAltDown() {
        return Client.Companion.isAltDown();
    }
    
    @JvmStatic
    public static final int getFPS() {
        return Client.Companion.getFPS();
    }
    
    @JvmStatic
    @NotNull
    public static final String getVersion() {
        return Client.Companion.getVersion();
    }
    
    @JvmStatic
    public static final long getMaxMemory() {
        return Client.Companion.getMaxMemory();
    }
    
    @JvmStatic
    public static final long getTotalMemory() {
        return Client.Companion.getTotalMemory();
    }
    
    @JvmStatic
    public static final long getFreeMemory() {
        return Client.Companion.getFreeMemory();
    }
    
    @JvmStatic
    public static final int getMemoryUsage() {
        return Client.Companion.getMemoryUsage();
    }
    
    @JvmStatic
    public static final long getSystemTime() {
        return Client.Companion.getSystemTime();
    }
    
    @JvmStatic
    public static final float getMouseX() {
        return Client.Companion.getMouseX();
    }
    
    @JvmStatic
    public static final float getMouseY() {
        return Client.Companion.getMouseY();
    }
    
    @JvmStatic
    public static final boolean isInGui() {
        return Client.Companion.isInGui();
    }
    
    @JvmStatic
    @NotNull
    public static final String getCurrentChatMessage() {
        return Client.Companion.getCurrentChatMessage();
    }
    
    @JvmStatic
    public static final void setCurrentChatMessage(@NotNull final String message) {
        Client.Companion.setCurrentChatMessage(message);
    }
    
    @JvmStatic
    public static final <T extends INetHandler> void sendPacket(@NotNull final Packet<T> packet) {
        Client.Companion.sendPacket((net.minecraft.network.Packet<INetHandler>)packet);
    }
    
    @JvmStatic
    public static final void showTitle(@NotNull final String title, @NotNull final String subtitle, final int fadeIn, final int time, final int fadeOut) {
        Client.Companion.showTitle(title, subtitle, fadeIn, time, fadeOut);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void scheduleTask(@NotNull final Function0<Unit> callback) {
        Client.Companion.scheduleTask(callback);
    }
    
    public static final /* synthetic */ Settings access$getSettings$cp() {
        return Client.settings;
    }
    
    static {
        Companion = new Companion(null);
        settings = new Settings();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002;<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0013H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0007J\b\u0010\u001d\u001a\u00020\u0015H\u0007J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\b\u0010 \u001a\u00020\u0015H\u0007J\b\u0010!\u001a\u00020\u000bH\u0007J\b\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020#H\u0007J\b\u0010%\u001a\u00020#H\u0007J\b\u0010&\u001a\u00020#H\u0007J\b\u0010'\u001a\u00020#H\u0007J\b\u0010(\u001a\u00020#H\u0007J\b\u0010)\u001a\u00020#H\u0007J \u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0-H\u0007J \u0010.\u001a\u00020\t\"\b\b\u0000\u0010/*\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H/02H\u0007J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u000bH\u0007J0\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u0013H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006=" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion;", "", "()V", "settings", "Lcom/chattriggers/ctjs/minecraft/wrappers/Settings;", "getSettings$annotations", "getSettings", "()Lcom/chattriggers/ctjs/minecraft/wrappers/Settings;", "connect", "", "ip", "", "disconnect", "getChatGUI", "Lnet/minecraft/client/gui/GuiNewChat;", "getConnection", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "getCurrentChatMessage", "getFPS", "", "getFreeMemory", "", "getMaxMemory", "getMemoryUsage", "getMinecraft", "Lnet/minecraft/client/Minecraft;", "getMouseX", "", "getMouseY", "getSystemTime", "getTabGui", "Lnet/minecraft/client/gui/GuiPlayerTabOverlay;", "getTotalMemory", "getVersion", "isAltDown", "", "isControlDown", "isInChat", "isInGui", "isInTab", "isShiftDown", "isTabbedIn", "scheduleTask", "delay", "callback", "Lkotlin/Function0;", "sendPacket", "T", "Lnet/minecraft/network/INetHandler;", "packet", "Lnet/minecraft/network/Packet;", "setCurrentChatMessage", "message", "showTitle", "title", "subtitle", "fadeIn", "time", "fadeOut", "camera", "currentGui", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final Settings getSettings() {
            return Client.access$getSettings$cp();
        }
        
        @JvmStatic
        @NotNull
        public final Minecraft getMinecraft() {
            final Minecraft getMinecraft = Minecraft.getMinecraft();
            Intrinsics.checkNotNullExpressionValue((Object)getMinecraft, "getMinecraft()");
            return getMinecraft;
        }
        
        @JvmStatic
        @Nullable
        public final NetHandlerPlayClient getConnection() {
            return this.getMinecraft().getNetHandler();
        }
        
        @JvmStatic
        @JvmOverloads
        public final void scheduleTask(final int delay, @NotNull final Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter((Object)callback, "callback");
            ClientListener.INSTANCE.addTask(delay, (Function0)callback);
        }
        
        public static /* synthetic */ void scheduleTask$default(final Companion companion, int delay, final Function0 callback, final int n, final Object o) {
            if ((n & 0x1) != 0x0) {
                delay = 0;
            }
            companion.scheduleTask(delay, (Function0<Unit>)callback);
        }
        
        @JvmStatic
        public final void disconnect() {
            scheduleTask$default(this, 0, (Function0)Client$Companion$disconnect.Client$Companion$disconnect$1.INSTANCE, 1, null);
        }
        
        @JvmStatic
        public final void connect(@NotNull final String ip) {
            Intrinsics.checkNotNullParameter((Object)ip, "ip");
            scheduleTask$default(this, 0, (Function0)new Client$Companion$connect.Client$Companion$connect$1(ip), 1, null);
        }
        
        @JvmStatic
        @Nullable
        public final GuiNewChat getChatGUI() {
            final GuiIngame ingameGUI = this.getMinecraft().ingameGUI;
            return (ingameGUI == null) ? null : ingameGUI.getChatGUI();
        }
        
        @JvmStatic
        public final boolean isInChat() {
            return this.getMinecraft().currentScreen instanceof GuiChat;
        }
        
        @JvmStatic
        @Nullable
        public final GuiPlayerTabOverlay getTabGui() {
            final GuiIngame ingameGUI = this.getMinecraft().ingameGUI;
            return (ingameGUI == null) ? null : ingameGUI.getTabList();
        }
        
        @JvmStatic
        public final boolean isInTab() {
            return this.getMinecraft().gameSettings.keyBindPlayerList.isKeyDown();
        }
        
        @JvmStatic
        public final boolean isTabbedIn() {
            return Display.isActive();
        }
        
        @JvmStatic
        public final boolean isControlDown() {
            return GuiScreen.isCtrlKeyDown();
        }
        
        @JvmStatic
        public final boolean isShiftDown() {
            return GuiScreen.isShiftKeyDown();
        }
        
        @JvmStatic
        public final boolean isAltDown() {
            return GuiScreen.isAltKeyDown();
        }
        
        @JvmStatic
        public final int getFPS() {
            return Minecraft.getDebugFPS();
        }
        
        @JvmStatic
        @NotNull
        public final String getVersion() {
            final String getVersion = this.getMinecraft().getVersion();
            Intrinsics.checkNotNullExpressionValue((Object)getVersion, "getMinecraft().version");
            return getVersion;
        }
        
        @JvmStatic
        public final long getMaxMemory() {
            return Runtime.getRuntime().maxMemory();
        }
        
        @JvmStatic
        public final long getTotalMemory() {
            return Runtime.getRuntime().totalMemory();
        }
        
        @JvmStatic
        public final long getFreeMemory() {
            return Runtime.getRuntime().freeMemory();
        }
        
        @JvmStatic
        public final int getMemoryUsage() {
            return MathKt.roundToInt((this.getTotalMemory() - this.getFreeMemory()) * 100 / (float)this.getMaxMemory());
        }
        
        @JvmStatic
        public final long getSystemTime() {
            return Minecraft.getSystemTime();
        }
        
        @JvmStatic
        public final float getMouseX() {
            final float mx = (float)Mouse.getX();
            final float rw = (float)Renderer.screen.getWidth();
            final float dw = (float)this.getMinecraft().displayWidth;
            return mx * rw / dw;
        }
        
        @JvmStatic
        public final float getMouseY() {
            final float my = (float)Mouse.getY();
            final float rh = (float)Renderer.screen.getHeight();
            final float dh = (float)this.getMinecraft().displayHeight;
            return rh - my * rh / dh - 1.0f;
        }
        
        @JvmStatic
        public final boolean isInGui() {
            return currentGui.get() != null;
        }
        
        @JvmStatic
        @NotNull
        public final String getCurrentChatMessage() {
            String s;
            if (this.isInChat()) {
                final GuiScreen currentScreen = this.getMinecraft().currentScreen;
                if (currentScreen == null) {
                    throw new NullPointerException("null cannot be cast to non-null type net.minecraft.client.gui.GuiChat");
                }
                final GuiChat chatGui = (GuiChat)currentScreen;
                final String getText = chatGui.inputField.getText();
                Intrinsics.checkNotNullExpressionValue((Object)getText, "{\n                val ch\u2026tField.text\n            }");
                s = getText;
            }
            else {
                s = "";
            }
            return s;
        }
        
        @JvmStatic
        public final void setCurrentChatMessage(@NotNull final String message) {
            Intrinsics.checkNotNullParameter((Object)message, "message");
            if (this.isInChat()) {
                final GuiScreen currentScreen = this.getMinecraft().currentScreen;
                if (currentScreen == null) {
                    throw new NullPointerException("null cannot be cast to non-null type net.minecraft.client.gui.GuiChat");
                }
                final GuiChat chatGui = (GuiChat)currentScreen;
                chatGui.inputField.setText(message);
            }
            else {
                this.getMinecraft().displayGuiScreen((GuiScreen)new GuiChat(message));
            }
        }
        
        @JvmStatic
        public final <T extends INetHandler> void sendPacket(@NotNull final Packet<T> packet) {
            Intrinsics.checkNotNullParameter((Object)packet, "packet");
            final NetHandlerPlayClient connection = this.getConnection();
            if (connection != null) {
                final NetworkManager getNetworkManager = connection.getNetworkManager();
                if (getNetworkManager != null) {
                    getNetworkManager.sendPacket((Packet)packet);
                }
            }
        }
        
        @JvmStatic
        public final void showTitle(@NotNull final String title, @NotNull final String subtitle, final int fadeIn, final int time, final int fadeOut) {
            Intrinsics.checkNotNullParameter((Object)title, "title");
            Intrinsics.checkNotNullParameter((Object)subtitle, "subtitle");
            final GuiIngame gui = this.getMinecraft().ingameGUI;
            gui.displayTitle(ChatLib.addColor(title), (String)null, fadeIn, time, fadeOut);
            gui.displayTitle((String)null, ChatLib.addColor(subtitle), fadeIn, time, fadeOut);
            gui.displayTitle((String)null, (String)null, fadeIn, time, fadeOut);
        }
        
        @JvmStatic
        @JvmOverloads
        public final void scheduleTask(@NotNull final Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter((Object)callback, "callback");
            scheduleTask$default(this, 0, callback, 1, null);
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion$currentGui;", "", "()V", "close", "", "get", "Lnet/minecraft/client/gui/GuiScreen;", "getClassName", "", "getSlotUnderMouse", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Slot;", "ctjs" })
        public static final class currentGui
        {
            @NotNull
            public static final currentGui INSTANCE;
            
            private currentGui() {
            }
            
            @JvmStatic
            @NotNull
            public static final String getClassName() {
                final currentGui instance = currentGui.INSTANCE;
                final GuiScreen value = get();
                String simpleName;
                if (value == null) {
                    simpleName = "null";
                }
                else {
                    final Class<? extends GuiScreen> class1 = value.getClass();
                    if (class1 == null) {
                        simpleName = "null";
                    }
                    else if ((simpleName = class1.getSimpleName()) == null) {
                        simpleName = "null";
                    }
                }
                return simpleName;
            }
            
            @JvmStatic
            @Nullable
            public static final GuiScreen get() {
                return Client.Companion.getMinecraft().currentScreen;
            }
            
            @JvmStatic
            @Nullable
            public static final Slot getSlotUnderMouse() {
                final currentGui instance = currentGui.INSTANCE;
                final GuiScreen screen = get();
                Slot slot;
                if (screen instanceof GuiContainer && ((GuiContainer)screen).getSlotUnderMouse() != null) {
                    final net.minecraft.inventory.Slot slotUnderMouse;
                    slot = new Slot(slotUnderMouse);
                    slotUnderMouse = ((GuiContainer)screen).getSlotUnderMouse();
                    Intrinsics.checkNotNullExpressionValue((Object)slotUnderMouse, "screen.slotUnderMouse");
                }
                else {
                    slot = null;
                }
                return slot;
            }
            
            @JvmStatic
            public static final void close() {
                final EntityPlayerSP player = Player.getPlayer();
                if (player != null) {
                    player.closeScreen();
                }
            }
            
            static {
                INSTANCE = new currentGui();
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion$camera;", "", "()V", "getX", "", "getY", "getZ", "ctjs" })
        public static final class camera
        {
            @NotNull
            public static final camera INSTANCE;
            
            private camera() {
            }
            
            @JvmStatic
            public static final double getX() {
                return Client.Companion.getMinecraft().getRenderManager().viewerPosX;
            }
            
            @JvmStatic
            public static final double getY() {
                return Client.Companion.getMinecraft().getRenderManager().viewerPosY;
            }
            
            @JvmStatic
            public static final double getZ() {
                return Client.Companion.getMinecraft().getRenderManager().viewerPosZ;
            }
            
            static {
                INSTANCE = new camera();
            }
        }
    }
}
