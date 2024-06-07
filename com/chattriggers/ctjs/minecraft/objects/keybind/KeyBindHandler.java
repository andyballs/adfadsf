//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.keybind;

import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraftforge.fml.common.gameevent.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.common.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBindHandler;", "", "()V", "keyBinds", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind;", "clearKeyBinds", "", "getKeyBinds", "onTick", "event", "Lnet/minecraftforge/fml/common/gameevent/TickEvent$ClientTickEvent;", "registerKeyBind", "keyBind", "unregisterKeyBind", "ctjs" })
public final class KeyBindHandler
{
    @NotNull
    public static final KeyBindHandler INSTANCE;
    @NotNull
    private static final CopyOnWriteArrayList<KeyBind> keyBinds;
    
    private KeyBindHandler() {
    }
    
    public final void registerKeyBind(@NotNull final KeyBind keyBind) {
        Intrinsics.checkNotNullParameter((Object)keyBind, "keyBind");
        KeyBindHandler.keyBinds.add(keyBind);
    }
    
    public final void unregisterKeyBind(@NotNull final KeyBind keyBind) {
        Intrinsics.checkNotNullParameter((Object)keyBind, "keyBind");
        KeyBindHandler.keyBinds.remove(keyBind);
    }
    
    public final void clearKeyBinds() {
        KeyBindHandler.keyBinds.clear();
    }
    
    @NotNull
    public final CopyOnWriteArrayList<KeyBind> getKeyBinds() {
        return KeyBindHandler.keyBinds;
    }
    
    @SubscribeEvent
    public final void onTick(@NotNull final TickEvent$ClientTickEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (!World.isLoaded() || event.phase == TickEvent$Phase.END) {
            return;
        }
        final Iterable $this$forEach$iv = KeyBindHandler.keyBinds;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final KeyBind it = (KeyBind)element$iv;
            final int n = 0;
            try {
                it.onTick$ctjs();
            }
            catch (Exception ex) {}
        }
    }
    
    static {
        INSTANCE = new KeyBindHandler();
        MinecraftForge.EVENT_BUS.register((Object)KeyBindHandler.INSTANCE);
        keyBinds = new CopyOnWriteArrayList<KeyBind>();
    }
}
