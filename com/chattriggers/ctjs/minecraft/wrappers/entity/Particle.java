//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.entity;

import kotlin.*;
import net.minecraft.client.particle.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.awt.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fJ&\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001cJ\b\u0010!\u001a\u00020\"H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006#" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Particle;", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "underlyingEntity", "Lnet/minecraft/client/particle/EntityFX;", "Lcom/chattriggers/ctjs/utils/kotlin/MCParticle;", "(Lnet/minecraft/client/particle/EntityFX;)V", "getUnderlyingEntity", "()Lnet/minecraft/client/particle/EntityFX;", "getColor", "Ljava/awt/Color;", "multiplyVelocity", "multiplier", "", "remove", "scale", "setAlpha", "alpha", "setColor", "red", "green", "blue", "color", "", "setMaxAge", "maxAge", "", "setX", "x", "", "setY", "y", "setZ", "z", "toString", "", "ctjs" })
public final class Particle extends Entity
{
    @NotNull
    private final EntityFX underlyingEntity;
    
    public Particle(@NotNull final EntityFX underlyingEntity) {
        Intrinsics.checkNotNullParameter((Object)underlyingEntity, "underlyingEntity");
        super((net.minecraft.entity.Entity)underlyingEntity);
        this.underlyingEntity = underlyingEntity;
    }
    
    @NotNull
    public final EntityFX getUnderlyingEntity() {
        return this.underlyingEntity;
    }
    
    @NotNull
    public final Particle setX(final double x) {
        final Particle $this$setX_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setX_u24lambda_u2d0.getUnderlyingEntity().setPosition(x, $this$setX_u24lambda_u2d0.getY(), $this$setX_u24lambda_u2d0.getZ());
        return this;
    }
    
    @NotNull
    public final Particle setY(final double y) {
        final Particle $this$setY_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setY_u24lambda_u2d1.getUnderlyingEntity().setPosition($this$setY_u24lambda_u2d1.getX(), y, $this$setY_u24lambda_u2d1.getZ());
        return this;
    }
    
    @NotNull
    public final Particle setZ(final double z) {
        final Particle $this$setZ_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setZ_u24lambda_u2d2.getUnderlyingEntity().setPosition($this$setZ_u24lambda_u2d2.getX(), $this$setZ_u24lambda_u2d2.getY(), z);
        return this;
    }
    
    @NotNull
    public final Particle scale(final float scale) {
        final Particle $this$scale_u24lambda_u2d3 = this;
        final int n = 0;
        $this$scale_u24lambda_u2d3.getUnderlyingEntity().multipleParticleScaleBy(scale);
        return this;
    }
    
    @NotNull
    public final Particle multiplyVelocity(final float multiplier) {
        final Particle $this$multiplyVelocity_u24lambda_u2d4 = this;
        final int n = 0;
        $this$multiplyVelocity_u24lambda_u2d4.getUnderlyingEntity().multiplyVelocity(multiplier);
        return this;
    }
    
    @NotNull
    public final Particle setColor(final float red, final float green, final float blue) {
        final Particle $this$setColor_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setColor_u24lambda_u2d5.getUnderlyingEntity().setRBGColorF(red, green, blue);
        return this;
    }
    
    @NotNull
    public final Particle setColor(final float red, final float green, final float blue, final float alpha) {
        final Particle $this$setColor_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setColor_u24lambda_u2d6.setColor(red, green, blue);
        $this$setColor_u24lambda_u2d6.setAlpha(alpha);
        return this;
    }
    
    @NotNull
    public final Particle setColor(final long color) {
        final Particle $this$setColor_u24lambda_u2d7 = this;
        final int n = 0;
        final float red = (color >> 16 & 0xFFL) / 255.0f;
        final float blue = (color >> 8 & 0xFFL) / 255.0f;
        final float green = (color & 0xFFL) / 255.0f;
        final float alpha = (color >> 24 & 0xFFL) / 255.0f;
        $this$setColor_u24lambda_u2d7.setColor(red, green, blue, alpha);
        return this;
    }
    
    @NotNull
    public final Particle setAlpha(final float alpha) {
        final Particle $this$setAlpha_u24lambda_u2d8 = this;
        final int n = 0;
        $this$setAlpha_u24lambda_u2d8.getUnderlyingEntity().setAlphaF(alpha);
        return this;
    }
    
    @NotNull
    public final Color getColor() {
        return new Color(this.underlyingEntity.getRedColorF(), this.underlyingEntity.getGreenColorF(), this.underlyingEntity.getBlueColorF(), this.underlyingEntity.getAlpha());
    }
    
    @NotNull
    public final Particle setMaxAge(final int maxAge) {
        final Particle $this$setMaxAge_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setMaxAge_u24lambda_u2d9.getUnderlyingEntity().particleMaxAge = maxAge;
        return this;
    }
    
    @NotNull
    public final Particle remove() {
        final Particle $this$remove_u24lambda_u2d10 = this;
        final int n = 0;
        $this$remove_u24lambda_u2d10.getUnderlyingEntity().setDead();
        return this;
    }
    
    @NotNull
    public String toString() {
        final String string = this.underlyingEntity.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "underlyingEntity.toString()");
        return string;
    }
}
