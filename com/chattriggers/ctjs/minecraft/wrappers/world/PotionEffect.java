//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.resources.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;", "", "effect", "Lnet/minecraft/potion/PotionEffect;", "Lcom/chattriggers/ctjs/utils/kotlin/MCPotionEffect;", "(Lnet/minecraft/potion/PotionEffect;)V", "getEffect", "()Lnet/minecraft/potion/PotionEffect;", "getAmplifier", "", "getDuration", "getID", "getLocalizedName", "", "getName", "isAmbient", "", "isDurationMax", "showsParticles", "toString", "ctjs" })
public final class PotionEffect
{
    @NotNull
    private final net.minecraft.potion.PotionEffect effect;
    
    public PotionEffect(@NotNull final net.minecraft.potion.PotionEffect effect) {
        Intrinsics.checkNotNullParameter((Object)effect, "effect");
        this.effect = effect;
    }
    
    @NotNull
    public final net.minecraft.potion.PotionEffect getEffect() {
        return this.effect;
    }
    
    @NotNull
    public final String getName() {
        final String getEffectName = this.effect.getEffectName();
        Intrinsics.checkNotNullExpressionValue((Object)getEffectName, "effect.effectName");
        return getEffectName;
    }
    
    @NotNull
    public final String getLocalizedName() {
        final String format = I18n.format(this.getName(), new Object[] { "%s" });
        Intrinsics.checkNotNullExpressionValue((Object)format, "format(getName(), \"%s\")");
        return format;
    }
    
    public final int getAmplifier() {
        return this.effect.getAmplifier();
    }
    
    public final int getDuration() {
        return this.effect.getDuration();
    }
    
    public final int getID() {
        return this.effect.getPotionID();
    }
    
    public final boolean isAmbient() {
        return this.effect.getIsAmbient();
    }
    
    public final boolean isDurationMax() {
        return this.effect.getIsPotionDurationMax();
    }
    
    public final boolean showsParticles() {
        return this.effect.getIsShowParticles();
    }
    
    @NotNull
    @Override
    public String toString() {
        final String string = this.effect.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "effect.toString()");
        return string;
    }
}
