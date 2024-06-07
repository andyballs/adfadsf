//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world.block;

import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.wrappers.utils.*;
import kotlin.*;
import java.util.function.*;
import kotlin.jvm.internal.markers.*;
import java.util.*;
import kotlin.jvm.internal.*;
import net.minecraft.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0004$%&'B'\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0000J\u0006\u0010\u001d\u001a\u00020\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013j\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006(" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "", "Lnet/minecraft/util/IStringSerializable;", "oppositeIndex", "", "axisDirection", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$AxisDirection;", "axis", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Axis;", "directionVec", "Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;", "(Ljava/lang/String;IILcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$AxisDirection;Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Axis;Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;)V", "getAxis", "()Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Axis;", "getAxisDirection", "()Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$AxisDirection;", "getDirectionVec", "()Lcom/chattriggers/ctjs/minecraft/wrappers/utils/Vec3i;", "getOppositeIndex", "()I", "getName", "", "getOffsetX", "getOffsetY", "getOffsetZ", "getOpposite", "rotateAround", "rotateX", "rotateY", "rotateZ", "Down", "Up", "North", "South", "West", "East", "Axis", "AxisDirection", "Companion", "Plane", "ctjs" })
public enum BlockFace implements IStringSerializable
{
    @NotNull
    public static final Companion Companion;
    private final int oppositeIndex;
    @NotNull
    private final AxisDirection axisDirection;
    @NotNull
    private final Axis axis;
    @NotNull
    private final Vec3i directionVec;
    
    Down(1, AxisDirection.Negative, Axis.Y, new Vec3i(0, -1, 0)), 
    Up(0, AxisDirection.Positive, Axis.Y, new Vec3i(0, 1, 0)), 
    North(3, AxisDirection.Negative, Axis.Z, new Vec3i(0, 0, -1)), 
    South(2, AxisDirection.Positive, Axis.Z, new Vec3i(0, 0, 1)), 
    West(5, AxisDirection.Negative, Axis.X, new Vec3i(-1, 0, 0)), 
    East(4, AxisDirection.Positive, Axis.X, new Vec3i(1, 0, 0));
    
    private BlockFace(final int oppositeIndex, final AxisDirection axisDirection, final Axis axis, final Vec3i directionVec) {
        this.oppositeIndex = oppositeIndex;
        this.axisDirection = axisDirection;
        this.axis = axis;
        this.directionVec = directionVec;
    }
    
    public final int getOppositeIndex() {
        return this.oppositeIndex;
    }
    
    @NotNull
    public final AxisDirection getAxisDirection() {
        return this.axisDirection;
    }
    
    @NotNull
    public final Axis getAxis() {
        return this.axis;
    }
    
    @NotNull
    public final Vec3i getDirectionVec() {
        return this.directionVec;
    }
    
    @NotNull
    public final BlockFace getOpposite() {
        return values()[this.oppositeIndex];
    }
    
    public final int getOffsetX() {
        return this.directionVec.getX();
    }
    
    public final int getOffsetY() {
        return this.directionVec.getY();
    }
    
    public final int getOffsetZ() {
        return this.directionVec.getZ();
    }
    
    @NotNull
    public final BlockFace rotateAround(@NotNull final Axis axis) {
        Intrinsics.checkNotNullParameter((Object)axis, "axis");
        BlockFace blockFace = null;
        switch (WhenMappings.$EnumSwitchMapping$0[axis.ordinal()]) {
            case 1: {
                blockFace = ((this != BlockFace.West && this != BlockFace.East) ? this.rotateX() : this);
                break;
            }
            case 2: {
                blockFace = ((this != BlockFace.Up && this != BlockFace.Down) ? this.rotateY() : this);
                break;
            }
            case 3: {
                blockFace = ((this != BlockFace.North && this != BlockFace.South) ? this.rotateZ() : this);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return blockFace;
    }
    
    @NotNull
    public final BlockFace rotateX() {
        BlockFace blockFace = null;
        switch (WhenMappings.$EnumSwitchMapping$1[this.ordinal()]) {
            case 1: {
                blockFace = BlockFace.South;
                break;
            }
            case 2: {
                blockFace = BlockFace.North;
                break;
            }
            case 3: {
                blockFace = BlockFace.Down;
                break;
            }
            case 4: {
                blockFace = BlockFace.Up;
                break;
            }
            default: {
                throw new IllegalStateException("Cannot rotate " + this + " around x-axis");
            }
        }
        return blockFace;
    }
    
    @NotNull
    public final BlockFace rotateY() {
        BlockFace blockFace = null;
        switch (WhenMappings.$EnumSwitchMapping$1[this.ordinal()]) {
            case 3: {
                blockFace = BlockFace.East;
                break;
            }
            case 4: {
                blockFace = BlockFace.West;
                break;
            }
            case 5: {
                blockFace = BlockFace.North;
                break;
            }
            case 6: {
                blockFace = BlockFace.South;
                break;
            }
            default: {
                throw new IllegalStateException("Cannot rotate " + this + " around y-axis");
            }
        }
        return blockFace;
    }
    
    @NotNull
    public final BlockFace rotateZ() {
        BlockFace blockFace = null;
        switch (WhenMappings.$EnumSwitchMapping$1[this.ordinal()]) {
            case 1: {
                blockFace = BlockFace.West;
                break;
            }
            case 2: {
                blockFace = BlockFace.East;
                break;
            }
            case 5: {
                blockFace = BlockFace.Up;
                break;
            }
            case 6: {
                blockFace = BlockFace.Down;
                break;
            }
            default: {
                throw new IllegalStateException("Cannot rotate " + this + " around z-axis");
            }
        }
        return blockFace;
    }
    
    @NotNull
    public String getName() {
        final String lowerCase = this.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }
    
    private static final /* synthetic */ BlockFace[] $values() {
        return new BlockFace[] { BlockFace.Down, BlockFace.Up, BlockFace.North, BlockFace.South, BlockFace.West, BlockFace.East };
    }
    
    static {
        $VALUES = $values();
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016j\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Plane;", "", "Ljava/util/function/Predicate;", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "", "(Ljava/lang/String;I)V", "facings", "", "()[Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "iterator", "", "test", "", "t", "Horizontal", "Vertical", "ctjs" })
    public enum Plane implements Predicate<BlockFace>, Iterable<BlockFace>, KMappedMarker
    {
        Horizontal, 
        Vertical;
        
        @Override
        public boolean test(@NotNull final BlockFace t) {
            Intrinsics.checkNotNullParameter((Object)t, "t");
            return t.getAxis().getPlane() == this;
        }
        
        @NotNull
        public final BlockFace[] facings() {
            BlockFace[] array = null;
            switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: {
                    array = new BlockFace[] { BlockFace.North, BlockFace.East, BlockFace.West, BlockFace.South };
                    break;
                }
                case 2: {
                    array = new BlockFace[] { BlockFace.Up, BlockFace.Down };
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return array;
        }
        
        @NotNull
        @Override
        public Iterator<BlockFace> iterator() {
            return (Iterator<BlockFace>)ArrayIteratorKt.iterator((Object[])this.facings());
        }
        
        private static final /* synthetic */ Plane[] $values() {
            return new Plane[] { Plane.Horizontal, Plane.Vertical };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$AxisDirection;", "", "offset", "", "(Ljava/lang/String;II)V", "getOffset", "()I", "Positive", "Negative", "ctjs" })
    public enum AxisDirection
    {
        private final int offset;
        
        Positive(1), 
        Negative(-1);
        
        private AxisDirection(final int offset) {
            this.offset = offset;
        }
        
        public final int getOffset() {
            return this.offset;
        }
        
        private static final /* synthetic */ AxisDirection[] $values() {
            return new AxisDirection[] { AxisDirection.Positive, AxisDirection.Negative };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Axis;", "", "Ljava/util/function/Predicate;", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "Lnet/minecraft/util/IStringSerializable;", "plane", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Plane;", "(Ljava/lang/String;ILcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Plane;)V", "getPlane", "()Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Plane;", "getName", "", "isHorizontal", "", "isVertical", "test", "t", "X", "Y", "Z", "ctjs" })
    public enum Axis implements Predicate<BlockFace>, IStringSerializable
    {
        @NotNull
        private final Plane plane;
        
        X(Plane.Horizontal), 
        Y(Plane.Vertical), 
        Z(Plane.Horizontal);
        
        private Axis(final Plane plane) {
            this.plane = plane;
        }
        
        @NotNull
        public final Plane getPlane() {
            return this.plane;
        }
        
        public final boolean isHorizontal() {
            return this.plane == Plane.Horizontal;
        }
        
        public final boolean isVertical() {
            return this.plane == Plane.Vertical;
        }
        
        @Override
        public boolean test(@NotNull final BlockFace t) {
            Intrinsics.checkNotNullParameter((Object)t, "t");
            return t.getAxis() == this;
        }
        
        @NotNull
        public String getName() {
            final String lowerCase = this.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
        
        private static final /* synthetic */ Axis[] $values() {
            return new Axis[] { Axis.X, Axis.Y, Axis.Z };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¨\u0006\b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace$Companion;", "", "()V", "fromMCEnumFacing", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "facing", "Lnet/minecraft/util/EnumFacing;", "Lcom/chattriggers/ctjs/utils/kotlin/MCEnumFacing;", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final BlockFace fromMCEnumFacing(@NotNull final EnumFacing facing) {
            Intrinsics.checkNotNullParameter((Object)facing, "facing");
            BlockFace blockFace = null;
            switch (WhenMappings.$EnumSwitchMapping$0[facing.ordinal()]) {
                case 1: {
                    blockFace = BlockFace.Down;
                    break;
                }
                case 2: {
                    blockFace = BlockFace.Up;
                    break;
                }
                case 3: {
                    blockFace = BlockFace.North;
                    break;
                }
                case 4: {
                    blockFace = BlockFace.South;
                    break;
                }
                case 5: {
                    blockFace = BlockFace.West;
                    break;
                }
                case 6: {
                    blockFace = BlockFace.East;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return blockFace;
        }
    }
}
