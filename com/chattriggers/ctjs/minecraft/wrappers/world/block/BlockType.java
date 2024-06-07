//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world.block;

import kotlin.*;
import net.minecraft.block.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import kotlin.jvm.internal.*;
import net.minecraft.block.state.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0011\u0012\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0014J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u0015\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;", "", "block", "(Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;)V", "blockName", "", "(Ljava/lang/String;)V", "blockID", "", "(I)V", "item", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "(Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;)V", "mcBlock", "Lnet/minecraft/block/Block;", "Lcom/chattriggers/ctjs/utils/kotlin/MCBlock;", "(Lnet/minecraft/block/Block;)V", "getMcBlock", "()Lnet/minecraft/block/Block;", "canProvidePower", "", "getDefaultMetadata", "getDefaultState", "Lnet/minecraft/block/state/IBlockState;", "getHarvestLevel", "getID", "getLightValue", "getName", "getRegistryName", "getUnlocalizedName", "isTranslucent", "toString", "withBlockPos", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Block;", "blockPos", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockPos;", "ctjs" })
public final class BlockType
{
    @NotNull
    private final Block mcBlock;
    
    public BlockType(@NotNull final Block mcBlock) {
        Intrinsics.checkNotNullParameter((Object)mcBlock, "mcBlock");
        this.mcBlock = mcBlock;
    }
    
    @NotNull
    public final Block getMcBlock() {
        return this.mcBlock;
    }
    
    public BlockType(@NotNull final BlockType block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        this(block.mcBlock);
    }
    
    public BlockType(@NotNull final String blockName) {
        Intrinsics.checkNotNullParameter((Object)blockName, "blockName");
        final Block getBlockFromName = Block.getBlockFromName(blockName);
        Intrinsics.checkNotNull((Object)getBlockFromName);
        this(getBlockFromName);
    }
    
    public BlockType(final int blockID) {
        final Block getBlockById = Block.getBlockById(blockID);
        Intrinsics.checkNotNullExpressionValue((Object)getBlockById, "getBlockById(blockID)");
        this(getBlockById);
    }
    
    public BlockType(@NotNull final Item item) {
        Intrinsics.checkNotNullParameter((Object)item, "item");
        final Block getBlockFromItem = Block.getBlockFromItem(item.getItem());
        Intrinsics.checkNotNullExpressionValue((Object)getBlockFromItem, "getBlockFromItem(item.item)");
        this(getBlockFromItem);
    }
    
    @NotNull
    public final com.chattriggers.ctjs.minecraft.wrappers.world.block.Block withBlockPos(@NotNull final BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, "blockPos");
        return new com.chattriggers.ctjs.minecraft.wrappers.world.block.Block(this, blockPos, (BlockFace)null, 4, (DefaultConstructorMarker)null);
    }
    
    public final int getID() {
        return Block.getIdFromBlock(this.mcBlock);
    }
    
    @NotNull
    public final String getRegistryName() {
        final String registryName = this.mcBlock.getRegistryName();
        Intrinsics.checkNotNullExpressionValue((Object)registryName, "mcBlock.registryName");
        return registryName;
    }
    
    @NotNull
    public final String getUnlocalizedName() {
        final String getUnlocalizedName = this.mcBlock.getUnlocalizedName();
        Intrinsics.checkNotNullExpressionValue((Object)getUnlocalizedName, "mcBlock.unlocalizedName");
        return getUnlocalizedName;
    }
    
    @NotNull
    public final String getName() {
        final String getLocalizedName = this.mcBlock.getLocalizedName();
        Intrinsics.checkNotNullExpressionValue((Object)getLocalizedName, "mcBlock.localizedName");
        return getLocalizedName;
    }
    
    public final int getLightValue() {
        return this.mcBlock.getLightValue();
    }
    
    @NotNull
    public final IBlockState getDefaultState() {
        final IBlockState getDefaultState = this.mcBlock.getDefaultState();
        Intrinsics.checkNotNullExpressionValue((Object)getDefaultState, "mcBlock.defaultState");
        return getDefaultState;
    }
    
    public final int getDefaultMetadata() {
        return this.mcBlock.getMetaFromState(this.getDefaultState());
    }
    
    public final boolean canProvidePower() {
        return this.mcBlock.canProvidePower();
    }
    
    public final int getHarvestLevel() {
        return this.mcBlock.getHarvestLevel(this.getDefaultState());
    }
    
    public final boolean isTranslucent() {
        return this.mcBlock.isTranslucent();
    }
    
    @NotNull
    @Override
    public String toString() {
        return "BlockType{name=" + (Object)this.mcBlock.getRegistryName() + '}';
    }
}
