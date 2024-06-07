//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world.block;

import com.chattriggers.ctjs.minecraft.wrappers.utils.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import kotlin.jvm.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003B\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001d\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001J\u001e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0012\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\u0002J\u0012\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u001a\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0011\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\u0002J\u0012\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001J\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u0005J\u0012\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006 " }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;", "pos", "(Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;)V", "Lnet/minecraft/util/BlockPos;", "Lcom/chattriggers/ctjs/utils/kotlin/MCBlockPos;", "(Lnet/minecraft/util/BlockPos;)V", "source", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "(Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;)V", "x", "", "y", "z", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "add", "other", "down", "n", "", "east", "minus", "north", "offset", "facing", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "plus", "south", "subtract", "toMCBlock", "up", "west", "ctjs" })
public final class BlockPos extends Vec3i
{
    public BlockPos(@NotNull final Number x, @NotNull final Number y, @NotNull final Number z) {
        Intrinsics.checkNotNullParameter((Object)x, "x");
        Intrinsics.checkNotNullParameter((Object)y, "y");
        Intrinsics.checkNotNullParameter((Object)z, "z");
        super(x, y, z);
    }
    
    public BlockPos(@NotNull final Vec3i pos) {
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        this(pos.getX(), pos.getY(), pos.getZ());
    }
    
    public BlockPos(@NotNull final net.minecraft.util.BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        this(pos.getX(), pos.getY(), pos.getZ());
    }
    
    public BlockPos(@NotNull final Entity source) {
        Intrinsics.checkNotNullParameter((Object)source, "source");
        this(source.getPos());
    }
    
    @NotNull
    public final BlockPos add(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return new BlockPos(this.getX() + other.getX(), this.getY() + other.getY(), this.getZ() + other.getZ());
    }
    
    @NotNull
    public final BlockPos add(@NotNull final Number x, @NotNull final Number y, @NotNull final Number z) {
        Intrinsics.checkNotNullParameter((Object)x, "x");
        Intrinsics.checkNotNullParameter((Object)y, "y");
        Intrinsics.checkNotNullParameter((Object)z, "z");
        return this.add(new Vec3i(x, y, z));
    }
    
    @NotNull
    public final BlockPos plus(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return this.add(other);
    }
    
    @NotNull
    public final BlockPos subtract(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return new BlockPos(this.getX() - other.getX(), this.getY() - other.getY(), this.getZ() - other.getZ());
    }
    
    @NotNull
    public final BlockPos subtract(@NotNull final Number x, @NotNull final Number y, @NotNull final Number z) {
        Intrinsics.checkNotNullParameter((Object)x, "x");
        Intrinsics.checkNotNullParameter((Object)y, "y");
        Intrinsics.checkNotNullParameter((Object)z, "z");
        return this.subtract(new Vec3i(x, y, z));
    }
    
    @NotNull
    public final BlockPos minus(@NotNull final Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return this.subtract(other);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos up(final int n) {
        return this.offset(BlockFace.Up, n);
    }
    
    public static /* synthetic */ BlockPos up$default(final BlockPos blockPos, int n, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 1;
        }
        return blockPos.up(n);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos down(final int n) {
        return this.offset(BlockFace.Down, n);
    }
    
    public static /* synthetic */ BlockPos down$default(final BlockPos blockPos, int n, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 1;
        }
        return blockPos.down(n);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos north(final int n) {
        return this.offset(BlockFace.North, n);
    }
    
    public static /* synthetic */ BlockPos north$default(final BlockPos blockPos, int n, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 1;
        }
        return blockPos.north(n);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos south(final int n) {
        return this.offset(BlockFace.South, n);
    }
    
    public static /* synthetic */ BlockPos south$default(final BlockPos blockPos, int n, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 1;
        }
        return blockPos.south(n);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos east(final int n) {
        return this.offset(BlockFace.East, n);
    }
    
    public static /* synthetic */ BlockPos east$default(final BlockPos blockPos, int n, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 1;
        }
        return blockPos.east(n);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos west(final int n) {
        return this.offset(BlockFace.West, n);
    }
    
    public static /* synthetic */ BlockPos west$default(final BlockPos blockPos, int n, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 1;
        }
        return blockPos.west(n);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos offset(@NotNull final BlockFace facing, final int n) {
        Intrinsics.checkNotNullParameter((Object)facing, "facing");
        return new BlockPos(this.getX() + facing.getOffsetX() * n, this.getY() + facing.getOffsetY() * n, this.getZ() + facing.getOffsetZ() * n);
    }
    
    public static /* synthetic */ BlockPos offset$default(final BlockPos blockPos, final BlockFace facing, int n, final int n2, final Object o) {
        if ((n2 & 0x2) != 0x0) {
            n = 1;
        }
        return blockPos.offset(facing, n);
    }
    
    @NotNull
    public final net.minecraft.util.BlockPos toMCBlock() {
        return new net.minecraft.util.BlockPos(this.getX(), this.getY(), this.getZ());
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos up() {
        return up$default(this, 0, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos down() {
        return down$default(this, 0, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos north() {
        return north$default(this, 0, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos south() {
        return south$default(this, 0, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos east() {
        return east$default(this, 0, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos west() {
        return west$default(this, 0, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final BlockPos offset(@NotNull final BlockFace facing) {
        Intrinsics.checkNotNullParameter((Object)facing, "facing");
        return offset$default(this, facing, 0, 2, null);
    }
}
