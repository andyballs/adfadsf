//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.listeners;

import kotlin.*;
import kotlin.jvm.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0007J\u0012\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/CancellableEvent;", "", "()V", "cancelled", "", "isCancelable", "isCanceled", "isCancellable", "isCancelled", "setCanceled", "", "newVal", "setCancelled", "ctjs" })
public final class CancellableEvent
{
    private boolean cancelled;
    
    @JvmOverloads
    public final void setCanceled(final boolean newVal) {
        this.cancelled = newVal;
    }
    
    public static /* synthetic */ void setCanceled$default(final CancellableEvent cancellableEvent, boolean canceled, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            canceled = true;
        }
        cancellableEvent.setCanceled(canceled);
    }
    
    @JvmOverloads
    public final void setCancelled(final boolean newVal) {
        this.cancelled = newVal;
    }
    
    public static /* synthetic */ void setCancelled$default(final CancellableEvent cancellableEvent, boolean cancelled, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            cancelled = true;
        }
        cancellableEvent.setCancelled(cancelled);
    }
    
    public final boolean isCancelable() {
        return true;
    }
    
    public final boolean isCancellable() {
        return true;
    }
    
    public final boolean isCancelled() {
        return this.cancelled;
    }
    
    public final boolean isCanceled() {
        return this.cancelled;
    }
    
    @JvmOverloads
    public final void setCanceled() {
        setCanceled$default(this, false, 1, null);
    }
    
    @JvmOverloads
    public final void setCancelled() {
        setCancelled$default(this, false, 1, null);
    }
}
