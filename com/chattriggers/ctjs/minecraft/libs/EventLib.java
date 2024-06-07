//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraftforge.client.event.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.*;
import net.minecraft.util.*;
import net.minecraftforge.client.event.sound.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007J\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\tH\u0007¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/EventLib;", "", "()V", "cancel", "", "event", "getMessage", "Lnet/minecraft/util/IChatComponent;", "Lcom/chattriggers/ctjs/utils/kotlin/MCITextComponent;", "Lnet/minecraftforge/client/event/ClientChatReceivedEvent;", "getName", "", "Lnet/minecraftforge/client/event/sound/PlaySoundEvent;", "getType", "", "ctjs" })
public final class EventLib
{
    @NotNull
    public static final EventLib INSTANCE;
    
    private EventLib() {
    }
    
    @JvmStatic
    public static final int getType(@NotNull final ClientChatReceivedEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        return event.type;
    }
    
    @JvmStatic
    @NotNull
    public static final IChatComponent getMessage(@NotNull final ClientChatReceivedEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final IChatComponent message = event.message;
        Intrinsics.checkNotNullExpressionValue((Object)message, "event.message");
        return message;
    }
    
    @JvmStatic
    @NotNull
    public static final String getName(@NotNull final PlaySoundEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final String name = event.name;
        Intrinsics.checkNotNullExpressionValue((Object)name, "event.name");
        return name;
    }
    
    @JvmStatic
    public static final void cancel(@NotNull final Object event) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PlaySoundEvent) {
            ((PlaySoundEvent)event).result = null;
        }
        else if (event instanceof CancellableEvent) {
            ((CancellableEvent)event).setCanceled(true);
        }
        else {
            if (!(event instanceof Event)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("cancel() expects an Event but received ", (Object)event.getClass().getName()));
            }
            if (!((Event)event).isCancelable()) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Attempt to cancel non-cancelable event ", (Object)event.getClass().getName()));
            }
            ((Event)event).setCanceled(true);
        }
    }
    
    static {
        INSTANCE = new EventLib();
    }
}
