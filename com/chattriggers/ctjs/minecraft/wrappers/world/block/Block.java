//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world.block;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraft.block.state.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0018J\b\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006&" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Block;", "", "type", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;", "pos", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "face", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "(Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;)V", "getFace", "()Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockFace;", "getPos", "()Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "getType", "()Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;", "x", "", "getX", "()I", "y", "getY", "z", "getZ", "canBeHarvested", "", "canBeHarvestedWith", "item", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "getMetadata", "getRedstoneStrength", "getState", "Lnet/minecraft/block/state/IBlockState;", "isPowered", "toString", "", "withFace", "withPos", "withType", "ctjs" })
public class Block
{
    @NotNull
    private final BlockType type;
    @NotNull
    private final BlockPos pos;
    @Nullable
    private final BlockFace face;
    
    public Block(@NotNull final BlockType type, @NotNull final BlockPos pos, @Nullable final BlockFace face) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        this.type = type;
        this.pos = pos;
        this.face = face;
    }
    
    @NotNull
    public final BlockType getType() {
        return this.type;
    }
    
    @NotNull
    public final BlockPos getPos() {
        return this.pos;
    }
    
    @Nullable
    public final BlockFace getFace() {
        return this.face;
    }
    
    public final int getX() {
        return this.pos.getX();
    }
    
    public final int getY() {
        return this.pos.getY();
    }
    
    public final int getZ() {
        return this.pos.getZ();
    }
    
    @NotNull
    public final Block withType(@NotNull final BlockType type) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        return new Block(type, this.pos, this.face);
    }
    
    @NotNull
    public final Block withPos(@NotNull final BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, "pos");
        return new Block(this.type, pos, this.face);
    }
    
    @NotNull
    public final Block withFace(@NotNull final BlockFace face) {
        Intrinsics.checkNotNullParameter((Object)face, "face");
        return new Block(this.type, this.pos, face);
    }
    
    @NotNull
    public final IBlockState getState() {
        return World.getBlockStateAt(this.pos);
    }
    
    public final int getMetadata() {
        return this.type.getMcBlock().getMetaFromState(this.getState());
    }
    
    public final boolean isPowered() {
        final WorldClient world = World.getWorld();
        Intrinsics.checkNotNull((Object)world);
        return world.isBlockPowered(this.pos.toMCBlock());
    }
    
    public final int getRedstoneStrength() {
        final WorldClient world = World.getWorld();
        Intrinsics.checkNotNull((Object)world);
        return world.getStrongPower(this.pos.toMCBlock());
    }
    
    public final boolean canBeHarvested() {
        return this.type.getMcBlock().canHarvestBlock((IBlockAccess)World.getWorld(), this.pos.toMCBlock(), (EntityPlayer)Player.getPlayer());
    }
    
    public final boolean canBeHarvestedWith(@NotNull final Item item) {
        Intrinsics.checkNotNullParameter((Object)item, "item");
        return item.canHarvest(this.type);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Block{type=" + (Object)this.type.getMcBlock().getRegistryName() + ", x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.getZ() + '}';
    }
}
