//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.utils;

import kotlin.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0000J\u001e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0011J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u001a" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;", "", "x", "", "y", "z", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "", "(III)V", "getX", "()I", "getY", "getZ", "compareTo", "other", "crossProduct", "distance", "", "distanceSq", "distanceSqToCenter", "equals", "", "", "hashCode", "toString", "", "ctjs" })
public class Vec3i implements Comparable<Vec3i>
{
    private final int x;
    private final int y;
    private final int z;
    
    public Vec3i(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public final int getX() {
        return this.x;
    }
    
    public final int getY() {
        return this.y;
    }
    
    public final int getZ() {
        return this.z;
    }
    
    public Vec3i(@NotNull final Number x, @NotNull final Number y, @NotNull final Number z) {
        Intrinsics.checkNotNullParameter((Object)x, "x");
        Intrinsics.checkNotNullParameter((Object)y, "y");
        Intrinsics.checkNotNullParameter((Object)z, "z");
        this(x.intValue(), y.intValue(), z.intValue());
    }
    
    @NotNull
    public final Vec3i crossProduct(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return new Vec3i(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x);
    }
    
    public final double distanceSq(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        final double dx = this.x - other.x;
        final double dy = this.y - other.y;
        final double dz = this.z - other.z;
        return dx * dx + dy * dy + dz * dz;
    }
    
    public final double distance(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return Math.sqrt(this.distanceSq(other));
    }
    
    public final double distanceSqToCenter(final double x, final double y, final double z) {
        final double dx = this.x + 0.5 - x;
        final double dy = this.y + 0.5 - y;
        final double dz = this.z + 0.5 - z;
        return dx * dx + dy * dy + dz * dz;
    }
    
    @Override
    public int compareTo(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return (this.y == other.y) ? ((this.z == other.z) ? (this.x - other.x) : (this.z - other.z)) : (this.y - other.y);
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof Vec3i && this.compareTo((Vec3i)other) == 0;
    }
    
    @Override
    public int hashCode() {
        return (this.y + this.z * 31) * 31 + this.x;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Vec3i{x=" + this.x + ",y=" + this.y + ",z=" + this.z + '}';
    }
}
