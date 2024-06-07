//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory;

import kotlin.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Slot;", "", "mcSlot", "Lnet/minecraft/inventory/Slot;", "Lcom/chattriggers/ctjs/utils/kotlin/MCSlot;", "(Lnet/minecraft/inventory/Slot;)V", "getMcSlot", "()Lnet/minecraft/inventory/Slot;", "getDisplayX", "", "getDisplayY", "getIndex", "getInventory", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Inventory;", "getItem", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "toString", "", "ctjs" })
public final class Slot
{
    @NotNull
    private final net.minecraft.inventory.Slot mcSlot;
    
    public Slot(@NotNull final net.minecraft.inventory.Slot mcSlot) {
        Intrinsics.checkNotNullParameter((Object)mcSlot, "mcSlot");
        this.mcSlot = mcSlot;
    }
    
    @NotNull
    public final net.minecraft.inventory.Slot getMcSlot() {
        return this.mcSlot;
    }
    
    public final int getIndex() {
        return (this.mcSlot instanceof GuiContainerCreative$CreativeSlot) ? ((GuiContainerCreative$CreativeSlot)this.mcSlot).getSlotIndex() : this.mcSlot.slotNumber;
    }
    
    public final int getDisplayX() {
        return this.mcSlot.xDisplayPosition;
    }
    
    public final int getDisplayY() {
        return this.mcSlot.yDisplayPosition;
    }
    
    @NotNull
    public final Inventory getInventory() {
        final IInventory inventory = this.mcSlot.inventory;
        Intrinsics.checkNotNullExpressionValue((Object)inventory, "mcSlot.inventory");
        return new Inventory(inventory);
    }
    
    @Nullable
    public final Item getItem() {
        final ItemStack getStack = this.mcSlot.getStack();
        Item item;
        if (getStack == null) {
            item = null;
        }
        else {
            final ItemStack p0 = getStack;
            final int n = 0;
            item = new Item(p0);
        }
        return item;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Slot " + this.getIndex() + " of (" + this.getInventory().getClassName() + ": " + this.getInventory().getName() + "): " + this.getItem();
    }
}
