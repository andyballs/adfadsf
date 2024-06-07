//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.display;

import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.common.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000fH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler;", "", "()V", "displays", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/chattriggers/ctjs/minecraft/objects/display/Display;", "clearDisplays", "", "registerDisplay", "", "display", "renderDisplayGui", "event", "Lnet/minecraftforge/client/event/GuiScreenEvent$DrawScreenEvent$Post;", "renderDisplayOverlay", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Text;", "Align", "Background", "Order", "RegisterType", "ctjs" })
public final class DisplayHandler
{
    @NotNull
    public static final DisplayHandler INSTANCE;
    @NotNull
    private static final CopyOnWriteArrayList<Display> displays;
    
    private DisplayHandler() {
    }
    
    public final boolean registerDisplay(@NotNull final Display display) {
        Intrinsics.checkNotNullParameter((Object)display, "display");
        return DisplayHandler.displays.add(display);
    }
    
    public final void clearDisplays() {
        DisplayHandler.displays.clear();
    }
    
    @SubscribeEvent
    public final void renderDisplayOverlay(@NotNull final RenderGameOverlayEvent$Text event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        GlStateManager.pushMatrix();
        final Iterable $this$forEach$iv = DisplayHandler.displays;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Display it = (Display)element$iv;
            final int n = 0;
            if (it.getRegisterType$ctjs() == RegisterType.RENDER_OVERLAY) {
                it.render();
            }
        }
        GlStateManager.popMatrix();
    }
    
    @SubscribeEvent
    public final void renderDisplayGui(@NotNull final GuiScreenEvent$DrawScreenEvent$Post event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        GlStateManager.pushMatrix();
        final Iterable $this$forEach$iv = DisplayHandler.displays;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Display it = (Display)element$iv;
            final int n = 0;
            if (it.getRegisterType$ctjs() == RegisterType.POST_GUI_RENDER) {
                it.render();
            }
        }
        GlStateManager.popMatrix();
    }
    
    static {
        INSTANCE = new DisplayHandler();
        displays = new CopyOnWriteArrayList<Display>();
        MinecraftForge.EVENT_BUS.register((Object)DisplayHandler.INSTANCE);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$RegisterType;", "", "(Ljava/lang/String;I)V", "RENDER_OVERLAY", "POST_GUI_RENDER", "ctjs" })
    public enum RegisterType
    {
        RENDER_OVERLAY, 
        POST_GUI_RENDER;
        
        private static final /* synthetic */ RegisterType[] $values() {
            return new RegisterType[] { RegisterType.RENDER_OVERLAY, RegisterType.POST_GUI_RENDER };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Background;", "", "(Ljava/lang/String;I)V", "NONE", "FULL", "PER_LINE", "ctjs" })
    public enum Background
    {
        NONE, 
        FULL, 
        PER_LINE;
        
        private static final /* synthetic */ Background[] $values() {
            return new Background[] { Background.NONE, Background.FULL, Background.PER_LINE };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Align;", "", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "ctjs" })
    public enum Align
    {
        LEFT, 
        CENTER, 
        RIGHT;
        
        private static final /* synthetic */ Align[] $values() {
            return new Align[] { Align.LEFT, Align.CENTER, Align.RIGHT };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Order;", "", "(Ljava/lang/String;I)V", "UP", "DOWN", "ctjs" })
    public enum Order
    {
        UP, 
        DOWN;
        
        private static final /* synthetic */ Order[] $values() {
            return new Order[] { Order.UP, Order.DOWN };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
