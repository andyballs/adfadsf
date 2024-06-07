//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u0001H\u0016J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u001f\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014" }, d2 = { "Lcom/chattriggers/ctjs/triggers/StepTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/engine/ILoader;)V", "delay", "", "elapsed", "fps", "systemTime", "register", "setDelay", "setFps", "trigger", "", "args", "", "([Ljava/lang/Object;)V", "ctjs" })
public final class StepTrigger extends Trigger
{
    private long fps;
    private long delay;
    private long systemTime;
    private long elapsed;
    
    public StepTrigger(@NotNull final Object method, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, TriggerType.Step, loader);
        this.fps = 60L;
        this.delay = -1L;
        this.systemTime = Client.Companion.getSystemTime();
    }
    
    @NotNull
    public final StepTrigger setFps(final long fps) {
        final StepTrigger $this$setFps_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setFps_u24lambda_u2d0.fps = ((fps < 1L) ? 1L : fps);
        $this$setFps_u24lambda_u2d0.systemTime = Client.Companion.getSystemTime() + 1000 / $this$setFps_u24lambda_u2d0.fps;
        return this;
    }
    
    @NotNull
    public final StepTrigger setDelay(final long delay) {
        final StepTrigger $this$setDelay_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setDelay_u24lambda_u2d1.delay = ((delay < 1L) ? 1L : delay);
        $this$setDelay_u24lambda_u2d1.systemTime = Client.Companion.getSystemTime() - $this$setDelay_u24lambda_u2d1.delay * 1000;
        return this;
    }
    
    @NotNull
    @Override
    public Trigger register() {
        this.systemTime = Client.Companion.getSystemTime();
        return super.register();
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        if (this.delay < 0L) {
            while (this.systemTime < Client.Companion.getSystemTime() + 1000 / this.fps) {
                final Long[] args2 = { null };
                final int n = 0;
                ++this.elapsed;
                args2[n] = this.elapsed;
                this.callMethod(args2);
                this.systemTime += 1000 / this.fps;
            }
        }
        else {
            while (Client.Companion.getSystemTime() > this.systemTime + this.delay * 1000) {
                final Long[] args3 = { null };
                final int n2 = 0;
                ++this.elapsed;
                args3[n2] = this.elapsed;
                this.callMethod(args3);
                this.systemTime += this.delay * 1000;
            }
        }
    }
}
