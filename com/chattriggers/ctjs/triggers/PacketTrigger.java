//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import net.minecraft.network.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e" }, d2 = { "Lcom/chattriggers/ctjs/triggers/PacketTrigger;", "Lcom/chattriggers/ctjs/triggers/ClassFilterTrigger;", "method", "", "triggerType", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V", "evalTriggerType", "Lnet/minecraft/network/Packet;", "args", "", "([Ljava/lang/Object;)Lnet/minecraft/network/Packet;", "ctjs" })
public final class PacketTrigger extends ClassFilterTrigger
{
    public PacketTrigger(@NotNull final Object method, @NotNull final TriggerType triggerType, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)triggerType, "triggerType");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, triggerType, loader);
    }
    
    @NotNull
    public Packet<?> evalTriggerType(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final Object orNull = ArraysKt.getOrNull(args, 0);
        final Packet packet = (orNull instanceof Packet) ? ((Packet)orNull) : null;
        if (packet == null) {
            throw new IllegalStateException(("Expected first argument of " + this.getTriggerType() + " trigger to be instance of Paket<*> class").toString());
        }
        return (Packet<?>)packet;
    }
}
