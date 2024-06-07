//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lcom/chattriggers/ctjs/triggers/EventTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "triggerType", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V", "triggerIfCanceled", "", "trigger", "", "args", "", "([Ljava/lang/Object;)V", "bool", "ctjs" })
public final class EventTrigger extends Trigger
{
    private boolean triggerIfCanceled;
    
    public EventTrigger(@NotNull final Object method, @NotNull final TriggerType triggerType, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)triggerType, "triggerType");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, triggerType, loader);
        this.triggerIfCanceled = true;
    }
    
    @NotNull
    public final EventTrigger triggerIfCanceled(final boolean bool) {
        final EventTrigger $this$triggerIfCanceled_u24lambda_u2d0 = this;
        final int n = 0;
        $this$triggerIfCanceled_u24lambda_u2d0.triggerIfCanceled = bool;
        return this;
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final Object event = ArraysKt.lastOrNull(args);
        boolean b;
        if (event instanceof CancellableEvent) {
            b = ((CancellableEvent)event).isCanceled();
        }
        else {
            if (!(event instanceof Event)) {
                final StringBuilder append = new StringBuilder().append("Expected last argument of ").append(this.getType().name()).append(" trigger to be an Event, got ");
                final Object o = event;
                String name;
                if (o == null) {
                    name = "null";
                }
                else {
                    final Class<?> class1 = o.getClass();
                    if (class1 == null) {
                        name = "null";
                    }
                    else if ((name = class1.getName()) == null) {
                        name = "null";
                    }
                }
                throw new IllegalArgumentException(append.append(name).toString());
            }
            b = ((Event)event).isCanceled();
        }
        final boolean isCanceled = b;
        if (this.triggerIfCanceled || !isCanceled) {
            this.callMethod(args);
        }
    }
}
