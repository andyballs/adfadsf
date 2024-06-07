//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.entity;

import kotlin.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.utils.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import org.jetbrains.annotations.*;
import kotlin.collections.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.block.*;
import net.minecraft.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011J\u001e\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0000J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020\u0011J\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0011J\u0006\u0010.\u001a\u00020\u001bJ\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\nJ\b\u00102\u001a\u00020!H\u0016J\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\nJ\u0006\u00107\u001a\u00020\nJ\u0006\u00108\u001a\u00020\nJ\b\u00109\u001a\u0004\u0018\u00010\u0000J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00000;J\b\u0010<\u001a\u0004\u0018\u00010\u0000J\u0006\u0010=\u001a\u00020\u0011J\u0006\u0010>\u001a\u00020\u001bJ\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020\nJ\u0006\u0010E\u001a\u00020\nJ\u0006\u0010F\u001a\u00020\nJ\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u00020\u000eJ\u0006\u0010I\u001a\u00020\u000eJ\u0006\u0010J\u001a\u00020\u000eJ\u0006\u0010K\u001a\u00020\u000eJ\u0006\u0010L\u001a\u00020\u000eJ\u0006\u0010M\u001a\u00020\u000eJ\u0006\u0010N\u001a\u00020\u000eJ\u0006\u0010O\u001a\u00020\u000eJ\u0006\u0010P\u001a\u00020\u000eJ\u0006\u0010Q\u001a\u00020\u000eJ\u0006\u0010R\u001a\u00020\u000eJ\u0006\u0010S\u001a\u00020\u000eJ\u0006\u0010T\u001a\u00020\u000eJ\u0006\u0010U\u001a\u00020\u000eJ\u0006\u0010V\u001a\u00020\u000eJ\u0006\u0010W\u001a\u00020\u000eJ\u001e\u0010X\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\u001bJ\u0016\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u0011J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\u000eJ\u000e\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020\u000eJ\u000e\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u000eJ\u000e\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\u000eJ\u000e\u0010f\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\u000eJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010i\u001a\u00020\u000eJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u001bJ\u001e\u0010l\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\b\u0010m\u001a\u00020!H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006n" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "", "entity", "Lnet/minecraft/entity/Entity;", "Lcom/chattriggers/ctjs/utils/kotlin/MCEntity;", "(Lnet/minecraft/entity/Entity;)V", "getEntity", "()Lnet/minecraft/entity/Entity;", "addVelocity", "x", "", "y", "z", "canBeCollidedWith", "", "canBePushed", "distanceTo", "", "other", "blockPos", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "dropItem", "Lnet/minecraft/entity/item/EntityItem;", "kotlin.jvm.PlatformType", "item", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "size", "", "extinguish", "getAir", "getChunk", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/Chunk;", "getClassName", "", "getDimension", "getDistanceWalked", "getEyeHeight", "getEyePosition", "Lnet/minecraft/util/Vec3;", "partialTicks", "getFireResistance", "getHeight", "getLastX", "getLastY", "getLastZ", "getLookVector", "getMaxInPortalTime", "getMotionX", "getMotionY", "getMotionZ", "getName", "getPitch", "getPos", "Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;", "getRenderX", "getRenderY", "getRenderZ", "getRider", "getRiders", "", "getRiding", "getStepHeight", "getTicksExisted", "getUUID", "Ljava/util/UUID;", "getWidth", "getWorld", "Lnet/minecraft/world/World;", "getX", "getY", "getYaw", "getZ", "hasNoClip", "isAirborne", "isBurning", "isCollided", "isDead", "isEating", "isImmuneToFire", "isInLava", "isInWater", "isInvisible", "isOnGround", "isOutsideBorder", "isSilent", "isSneaking", "isSprinting", "isWet", "move", "setAir", "air", "setAngles", "yaw", "pitch", "setIsEating", "eating", "setIsInvisible", "invisible", "setIsOutsideBorder", "outside", "setIsSilent", "silent", "setIsSneaking", "sneaking", "setIsSprinting", "sprinting", "setOnFire", "seconds", "setPosition", "toString", "ctjs" })
public class Entity
{
    @NotNull
    private final net.minecraft.entity.Entity entity;
    
    public Entity(@NotNull final net.minecraft.entity.Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, "entity");
        this.entity = entity;
    }
    
    @NotNull
    public final net.minecraft.entity.Entity getEntity() {
        return this.entity;
    }
    
    public final double getX() {
        return this.entity.posX;
    }
    
    public final double getY() {
        return this.entity.posY;
    }
    
    public final double getZ() {
        return this.entity.posZ;
    }
    
    @NotNull
    public final Vec3i getPos() {
        return new Vec3i(this.getX(), this.getY(), this.getZ());
    }
    
    public final double getLastX() {
        return this.entity.lastTickPosX;
    }
    
    public final double getLastY() {
        return this.entity.lastTickPosY;
    }
    
    public final double getLastZ() {
        return this.entity.lastTickPosZ;
    }
    
    public final double getRenderX() {
        return this.getLastX() + (this.getX() - this.getLastX()) * Tessellator.getPartialTicks();
    }
    
    public final double getRenderY() {
        return this.getLastY() + (this.getY() - this.getLastY()) * Tessellator.getPartialTicks();
    }
    
    public final double getRenderZ() {
        return this.getLastZ() + (this.getZ() - this.getLastZ()) * Tessellator.getPartialTicks();
    }
    
    public final double getPitch() {
        return MathHelper.wrapAngleTo180_float(this.entity.rotationPitch);
    }
    
    public final double getYaw() {
        return MathHelper.wrapAngleTo180_float(this.entity.rotationYaw);
    }
    
    public final double getMotionX() {
        return this.entity.motionX;
    }
    
    public final double getMotionY() {
        return this.entity.motionY;
    }
    
    public final double getMotionZ() {
        return this.entity.motionZ;
    }
    
    @Nullable
    public final Entity getRiding() {
        final net.minecraft.entity.Entity ridingEntity = this.entity.ridingEntity;
        Entity entity;
        if (ridingEntity == null) {
            entity = null;
        }
        else {
            final net.minecraft.entity.Entity p0 = ridingEntity;
            final int n = 0;
            entity = new Entity(p0);
        }
        return entity;
    }
    
    @Nullable
    public final Entity getRider() {
        final net.minecraft.entity.Entity riddenByEntity = this.entity.riddenByEntity;
        Entity entity;
        if (riddenByEntity == null) {
            entity = null;
        }
        else {
            final net.minecraft.entity.Entity p0 = riddenByEntity;
            final int n = 0;
            entity = new Entity(p0);
        }
        return entity;
    }
    
    @NotNull
    public final List<Entity> getRiders() {
        return (List<Entity>)CollectionsKt.emptyList();
    }
    
    public final boolean isDead() {
        return this.entity.isDead;
    }
    
    public final float getWidth() {
        return this.entity.width;
    }
    
    public final float getHeight() {
        return this.entity.height;
    }
    
    public final float getEyeHeight() {
        return this.entity.getEyeHeight();
    }
    
    @NotNull
    public String getName() {
        final String getName = this.entity.getName();
        Intrinsics.checkNotNullExpressionValue((Object)getName, "entity.name");
        return getName;
    }
    
    @NotNull
    public final String getClassName() {
        final String simpleName = this.entity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)simpleName, "entity.javaClass.simpleName");
        return simpleName;
    }
    
    @NotNull
    public final UUID getUUID() {
        final UUID getUniqueID = this.entity.getUniqueID();
        Intrinsics.checkNotNullExpressionValue((Object)getUniqueID, "entity.uniqueID");
        return getUniqueID;
    }
    
    public final int getAir() {
        return this.entity.getAir();
    }
    
    @NotNull
    public final Entity setAir(final int air) {
        final Entity $this$setAir_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setAir_u24lambda_u2d1.getEntity().setAir(air);
        return this;
    }
    
    public final float distanceTo(@NotNull final Entity other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return this.distanceTo(other.entity);
    }
    
    public final float distanceTo(@NotNull final net.minecraft.entity.Entity other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return this.entity.getDistanceToEntity(other);
    }
    
    public final float distanceTo(@NotNull final BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, "blockPos");
        return (float)this.entity.getDistance((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ());
    }
    
    public final float distanceTo(final float x, final float y, final float z) {
        return (float)this.entity.getDistance((double)x, (double)y, (double)z);
    }
    
    public final boolean isOnGround() {
        return this.entity.onGround;
    }
    
    public final boolean isCollided() {
        return this.entity.isCollided;
    }
    
    public final float getDistanceWalked() {
        return this.entity.distanceWalkedModified / 0.6f;
    }
    
    public final float getStepHeight() {
        return this.entity.stepHeight;
    }
    
    public final boolean hasNoClip() {
        return this.entity.noClip;
    }
    
    public final int getTicksExisted() {
        return this.entity.ticksExisted;
    }
    
    public final int getFireResistance() {
        return this.entity.fireResistance;
    }
    
    public final boolean isImmuneToFire() {
        return this.entity.isImmuneToFire();
    }
    
    public final boolean isInWater() {
        return this.entity.isInWater();
    }
    
    public final boolean isWet() {
        return this.entity.isWet();
    }
    
    public final boolean isAirborne() {
        return this.entity.isAirBorne;
    }
    
    public final int getDimension() {
        return this.entity.dimension;
    }
    
    @NotNull
    public final Entity setPosition(final double x, final double y, final double z) {
        final Entity $this$setPosition_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setPosition_u24lambda_u2d2.getEntity().setPosition(x, y, z);
        return this;
    }
    
    @NotNull
    public final Entity setAngles(final float yaw, final float pitch) {
        final Entity $this$setAngles_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setAngles_u24lambda_u2d3.getEntity().setAngles(yaw, pitch);
        return this;
    }
    
    public final int getMaxInPortalTime() {
        return this.entity.getMaxInPortalTime();
    }
    
    @NotNull
    public final Entity setOnFire(final int seconds) {
        final Entity $this$setOnFire_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setOnFire_u24lambda_u2d4.getEntity().setFire(seconds);
        return this;
    }
    
    @NotNull
    public final Entity extinguish() {
        final Entity $this$extinguish_u24lambda_u2d5 = this;
        final int n = 0;
        $this$extinguish_u24lambda_u2d5.getEntity().extinguish();
        return this;
    }
    
    @NotNull
    public final Entity move(final double x, final double y, final double z) {
        final Entity $this$move_u24lambda_u2d6 = this;
        final int n = 0;
        $this$move_u24lambda_u2d6.getEntity().moveEntity(x, y, z);
        return this;
    }
    
    public final boolean isSilent() {
        return this.entity.isSilent();
    }
    
    @NotNull
    public final Entity setIsSilent(final boolean silent) {
        final Entity $this$setIsSilent_u24lambda_u2d7 = this;
        final int n = 0;
        $this$setIsSilent_u24lambda_u2d7.getEntity().setSilent(silent);
        return this;
    }
    
    public final boolean isInLava() {
        return this.entity.isInLava();
    }
    
    @NotNull
    public final Entity addVelocity(final double x, final double y, final double z) {
        final Entity $this$addVelocity_u24lambda_u2d8 = this;
        final int n = 0;
        $this$addVelocity_u24lambda_u2d8.getEntity().addVelocity(x, y, z);
        return this;
    }
    
    @NotNull
    public final Vec3 getLookVector(final float partialTicks) {
        final Vec3 getLook = this.entity.getLook(partialTicks);
        Intrinsics.checkNotNullExpressionValue((Object)getLook, "entity.getLook(partialTicks)");
        return getLook;
    }
    
    @NotNull
    public final Vec3 getEyePosition(final float partialTicks) {
        final Vec3 getPositionEyes = this.entity.getPositionEyes(partialTicks);
        Intrinsics.checkNotNullExpressionValue((Object)getPositionEyes, "entity.getPositionEyes(partialTicks)");
        return getPositionEyes;
    }
    
    public final boolean canBeCollidedWith() {
        return this.entity.canBeCollidedWith();
    }
    
    public final boolean canBePushed() {
        return this.entity.canBePushed();
    }
    
    public final EntityItem dropItem(@NotNull final Item item, final int size) {
        Intrinsics.checkNotNullParameter((Object)item, "item");
        return this.entity.dropItem(item.getItem(), size);
    }
    
    public final boolean isSneaking() {
        return this.entity.isSneaking();
    }
    
    @NotNull
    public final Entity setIsSneaking(final boolean sneaking) {
        final Entity $this$setIsSneaking_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setIsSneaking_u24lambda_u2d9.getEntity().setSneaking(sneaking);
        return this;
    }
    
    public final boolean isSprinting() {
        return this.entity.isSprinting();
    }
    
    @NotNull
    public final Entity setIsSprinting(final boolean sprinting) {
        final Entity $this$setIsSprinting_u24lambda_u2d10 = this;
        final int n = 0;
        $this$setIsSprinting_u24lambda_u2d10.getEntity().setSprinting(sprinting);
        return this;
    }
    
    public final boolean isInvisible() {
        return this.entity.isInvisible();
    }
    
    @NotNull
    public final Entity setIsInvisible(final boolean invisible) {
        final Entity $this$setIsInvisible_u24lambda_u2d11 = this;
        final int n = 0;
        $this$setIsInvisible_u24lambda_u2d11.getEntity().setInvisible(invisible);
        return this;
    }
    
    public final boolean isEating() {
        return this.entity.isEating();
    }
    
    @NotNull
    public final Entity setIsEating(final boolean eating) {
        final Entity $this$setIsEating_u24lambda_u2d12 = this;
        final int n = 0;
        $this$setIsEating_u24lambda_u2d12.getEntity().setEating(eating);
        return this;
    }
    
    public final boolean isOutsideBorder() {
        return this.entity.isOutsideBorder();
    }
    
    @NotNull
    public final Entity setIsOutsideBorder(final boolean outside) {
        final Entity $this$setIsOutsideBorder_u24lambda_u2d13 = this;
        final int n = 0;
        $this$setIsOutsideBorder_u24lambda_u2d13.getEntity().setOutsideBorder(outside);
        return this;
    }
    
    public final boolean isBurning() {
        return this.entity.isBurning();
    }
    
    @NotNull
    public final World getWorld() {
        final World getEntityWorld = this.entity.getEntityWorld();
        Intrinsics.checkNotNullExpressionValue((Object)getEntityWorld, "entity.entityWorld");
        return getEntityWorld;
    }
    
    @NotNull
    public final Chunk getChunk() {
        final net.minecraft.world.chunk.Chunk getChunkFromChunkCoords = this.getWorld().getChunkFromChunkCoords(this.entity.chunkCoordX, this.entity.chunkCoordZ);
        Intrinsics.checkNotNullExpressionValue((Object)getChunkFromChunkCoords, "getWorld().getChunkFromC\u2026ordX, entity.chunkCoordZ)");
        return new Chunk(getChunkFromChunkCoords);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Entity{name=" + this.getName() + ", x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.getZ() + '}';
    }
}
