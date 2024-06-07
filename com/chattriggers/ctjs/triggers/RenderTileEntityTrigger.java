//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import net.minecraft.tileentity.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/triggers/RenderTileEntityTrigger;", "Lcom/chattriggers/ctjs/triggers/ClassFilterTrigger;", "method", "", "triggerType", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V", "evalTriggerType", "Lnet/minecraft/tileentity/TileEntity;", "Lcom/chattriggers/ctjs/utils/kotlin/MCTileEntity;", "args", "", "([Ljava/lang/Object;)Lnet/minecraft/tileentity/TileEntity;", "ctjs" })
public final class RenderTileEntityTrigger extends ClassFilterTrigger
{
    public RenderTileEntityTrigger(@NotNull final Object method, @NotNull final TriggerType triggerType, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)triggerType, "triggerType");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, triggerType, loader);
    }
    
    @NotNull
    public TileEntity evalTriggerType(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final Object orNull = ArraysKt.getOrNull(args, 0);
        final com.chattriggers.ctjs.minecraft.wrappers.entity.TileEntity tileEntity = (orNull instanceof com.chattriggers.ctjs.minecraft.wrappers.entity.TileEntity) ? ((com.chattriggers.ctjs.minecraft.wrappers.entity.TileEntity)orNull) : null;
        if (tileEntity == null) {
            throw new IllegalStateException(("Expected first argument of " + this.getTriggerType() + " trigger to be instance of net.minecraft.tileentity.TileEntity").toString());
        }
        return tileEntity.getTileEntity();
    }
}
