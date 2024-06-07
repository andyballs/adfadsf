//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.entity;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.block.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/TileEntity;", "", "tileEntity", "Lnet/minecraft/tileentity/TileEntity;", "Lcom/chattriggers/ctjs/utils/kotlin/MCTileEntity;", "(Lnet/minecraft/tileentity/TileEntity;)V", "getTileEntity", "()Lnet/minecraft/tileentity/TileEntity;", "getBlock", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Block;", "getBlockPos", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "getBlockType", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;", "getMetadata", "", "getX", "getY", "getZ", "toString", "", "ctjs" })
public final class TileEntity
{
    @NotNull
    private final net.minecraft.tileentity.TileEntity tileEntity;
    
    public TileEntity(@NotNull final net.minecraft.tileentity.TileEntity tileEntity) {
        Intrinsics.checkNotNullParameter((Object)tileEntity, "tileEntity");
        this.tileEntity = tileEntity;
    }
    
    @NotNull
    public final net.minecraft.tileentity.TileEntity getTileEntity() {
        return this.tileEntity;
    }
    
    public final int getX() {
        return this.getBlock().getX();
    }
    
    public final int getY() {
        return this.getBlock().getY();
    }
    
    public final int getZ() {
        return this.getBlock().getZ();
    }
    
    @NotNull
    public final Block getBlock() {
        return new Block(this.getBlockType(), this.getBlockPos(), null, 4, null);
    }
    
    @NotNull
    public final BlockType getBlockType() {
        final net.minecraft.block.Block getBlockType = this.tileEntity.getBlockType();
        Intrinsics.checkNotNullExpressionValue((Object)getBlockType, "tileEntity.blockType");
        return new BlockType(getBlockType);
    }
    
    @NotNull
    public final BlockPos getBlockPos() {
        final net.minecraft.util.BlockPos getPos = this.tileEntity.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)getPos, "tileEntity.pos");
        return new BlockPos(getPos);
    }
    
    public final int getMetadata() {
        return this.tileEntity.getBlockMetadata();
    }
    
    @NotNull
    @Override
    public String toString() {
        return "TileEntity{x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.getZ() + ", blockType=" + this.getBlockType() + '}';
    }
}
