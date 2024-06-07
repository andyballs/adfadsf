//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import kotlin.text.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u001f\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/triggers/SoundPlayTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/engine/ILoader;)V", "soundNameCriteria", "", "setCriteria", "trigger", "", "args", "", "([Ljava/lang/Object;)V", "ctjs" })
public final class SoundPlayTrigger extends Trigger
{
    @NotNull
    private String soundNameCriteria;
    
    public SoundPlayTrigger(@NotNull final Object method, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, TriggerType.SoundPlay, loader);
        this.soundNameCriteria = "";
    }
    
    @NotNull
    public final SoundPlayTrigger setCriteria(@NotNull final String soundNameCriteria) {
        Intrinsics.checkNotNullParameter((Object)soundNameCriteria, "soundNameCriteria");
        final SoundPlayTrigger $this$setCriteria_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setCriteria_u24lambda_u2d0.soundNameCriteria = soundNameCriteria;
        return this;
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        if (args[1] instanceof String && !Intrinsics.areEqual((Object)this.soundNameCriteria, (Object)"")) {
            final Object o = args[1];
            if (o == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (!StringsKt.equals((String)o, this.soundNameCriteria, true)) {
                return;
            }
        }
        this.callMethod(args);
    }
}
