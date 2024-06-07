//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\u0017\u001a\u00020\u00182\u0010\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u001aH\u0004¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u001f\u0010!\u001a\u00020\u00182\u0010\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u001aH&¢\u0006\u0002\u0010\u001bJ\b\u0010\"\u001a\u00020\u0000H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$" }, d2 = { "Lcom/chattriggers/ctjs/triggers/Trigger;", "", "method", "", "type", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V", "getLoader$ctjs", "()Lcom/chattriggers/ctjs/engine/ILoader;", "setLoader$ctjs", "(Lcom/chattriggers/ctjs/engine/ILoader;)V", "getMethod", "()Ljava/lang/Object;", "setMethod", "(Ljava/lang/Object;)V", "priority", "Lcom/chattriggers/ctjs/triggers/Trigger$Priority;", "getType", "()Lcom/chattriggers/ctjs/triggers/TriggerType;", "setType", "(Lcom/chattriggers/ctjs/triggers/TriggerType;)V", "callMethod", "", "args", "", "([Ljava/lang/Object;)V", "compareTo", "", "other", "register", "setPriority", "trigger", "unregister", "Priority", "ctjs" })
public abstract class Trigger implements Comparable<Trigger>
{
    @NotNull
    private Object method;
    @NotNull
    private TriggerType type;
    @NotNull
    private ILoader loader;
    @NotNull
    private Priority priority;
    
    protected Trigger(@NotNull final Object method, @NotNull final TriggerType type, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        this.method = method;
        this.type = type;
        this.loader = loader;
        this.priority = Priority.NORMAL;
        this.register();
    }
    
    @NotNull
    public final Object getMethod() {
        return this.method;
    }
    
    public final void setMethod(@NotNull final Object <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.method = <set-?>;
    }
    
    @NotNull
    public final TriggerType getType() {
        return this.type;
    }
    
    public final void setType(@NotNull final TriggerType <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.type = <set-?>;
    }
    
    @NotNull
    public final ILoader getLoader$ctjs() {
        return this.loader;
    }
    
    public final void setLoader$ctjs(@NotNull final ILoader <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.loader = <set-?>;
    }
    
    @NotNull
    public final Trigger setPriority(@NotNull final Priority priority) {
        Intrinsics.checkNotNullParameter((Object)priority, "priority");
        final Trigger $this$setPriority_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setPriority_u24lambda_u2d0.priority = priority;
        $this$setPriority_u24lambda_u2d0.unregister();
        $this$setPriority_u24lambda_u2d0.register();
        return this;
    }
    
    @NotNull
    public Trigger register() {
        final Trigger $this$register_u24lambda_u2d1 = this;
        final int n = 0;
        $this$register_u24lambda_u2d1.getLoader$ctjs().addTrigger($this$register_u24lambda_u2d1);
        return this;
    }
    
    @NotNull
    public Trigger unregister() {
        final Trigger $this$unregister_u24lambda_u2d2 = this;
        final int n = 0;
        $this$unregister_u24lambda_u2d2.getLoader$ctjs().removeTrigger($this$unregister_u24lambda_u2d2);
        return this;
    }
    
    protected final void callMethod(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        this.loader.trigger(this, this.method, args);
    }
    
    public abstract void trigger(@NotNull final Object[] p0);
    
    @Override
    public int compareTo(@NotNull final Trigger other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        final int ordCmp = this.priority.ordinal() - other.priority.ordinal();
        return (ordCmp == 0) ? (this.hashCode() - other.hashCode()) : ordCmp;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b" }, d2 = { "Lcom/chattriggers/ctjs/triggers/Trigger$Priority;", "", "(Ljava/lang/String;I)V", "HIGHEST", "HIGH", "NORMAL", "LOW", "LOWEST", "ctjs" })
    public enum Priority
    {
        HIGHEST, 
        HIGH, 
        NORMAL, 
        LOW, 
        LOWEST;
        
        private static final /* synthetic */ Priority[] $values() {
            return new Priority[] { Priority.HIGHEST, Priority.HIGH, Priority.NORMAL, Priority.LOW, Priority.LOWEST };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
