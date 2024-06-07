//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.gui;

import kotlin.*;
import net.minecraft.client.gui.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraftforge.fml.common.gameevent.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/gui/GuiHandler;", "", "()V", "pendingGui", "Lnet/minecraft/client/gui/GuiScreen;", "onTick", "", "event", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;", "openGui", "gui", "ctjs" })
public final class GuiHandler
{
    @NotNull
    public static final GuiHandler INSTANCE;
    @Nullable
    private static GuiScreen pendingGui;
    
    private GuiHandler() {
    }
    
    public final void openGui(@NotNull final GuiScreen gui) {
        Intrinsics.checkNotNullParameter((Object)gui, "gui");
        GuiHandler.pendingGui = gui;
    }
    
    @SubscribeEvent
    public final void onTick(@NotNull final TickEvent$ClientTickEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (event.phase == TickEvent$Phase.END) {
            return;
        }
        if (GuiHandler.pendingGui != null) {
            final Minecraft minecraft = Client.Companion.getMinecraft();
            final GuiScreen pendingGui = GuiHandler.pendingGui;
            Intrinsics.checkNotNull((Object)pendingGui);
            minecraft.displayGuiScreen(pendingGui);
            GuiHandler.pendingGui = null;
        }
    }
    
    static {
        INSTANCE = new GuiHandler();
    }
}
