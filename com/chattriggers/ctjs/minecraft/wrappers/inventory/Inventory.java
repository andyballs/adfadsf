//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory;

import com.chattriggers.ctjs.engine.langs.js.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraft.item.*;
import kotlin.jvm.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.action.*;
import java.util.*;
import net.minecraft.inventory.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00122\n\u0010\u001d\u001a\u00020\u001e\"\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0012J\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150#J\u0006\u0010$\u001a\u00020\u0012J\u0006\u0010%\u001a\u00020\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u0010J\u0016\u0010*\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010+\u001a\u00020\u0012H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006," }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Inventory;", "Lcom/chattriggers/ctjs/engine/langs/js/JSONImpl;", "inventory", "Lnet/minecraft/inventory/IInventory;", "(Lnet/minecraft/inventory/IInventory;)V", "container", "Lnet/minecraft/inventory/Container;", "(Lnet/minecraft/inventory/Container;)V", "getContainer", "()Lnet/minecraft/inventory/Container;", "getInventory", "()Lnet/minecraft/inventory/IInventory;", "click", "slot", "", "shift", "", "button", "", "contains", "item", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "id", "doAction", "", "action", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "drag", "type", "slots", "", "drop", "ctrl", "getClassName", "getItems", "", "getName", "getSize", "getStackInSlot", "getWindowId", "indexOf", "isContainer", "isItemValidForSlot", "toString", "ctjs" })
public final class Inventory implements JSONImpl
{
    @Nullable
    private final IInventory inventory;
    @Nullable
    private final Container container;
    
    @Nullable
    public final IInventory getInventory() {
        return this.inventory;
    }
    
    @Nullable
    public final Container getContainer() {
        return this.container;
    }
    
    public Inventory(@NotNull final IInventory inventory) {
        Intrinsics.checkNotNullParameter((Object)inventory, "inventory");
        this.inventory = inventory;
        this.container = null;
    }
    
    public Inventory(@NotNull final Container container) {
        Intrinsics.checkNotNullParameter((Object)container, "container");
        this.container = container;
        this.inventory = null;
    }
    
    public final int getSize() {
        final IInventory inventory = this.inventory;
        final Integer n = (inventory == null) ? null : Integer.valueOf(inventory.getSizeInventory());
        int n2;
        if (n == null) {
            final Container container = this.container;
            Intrinsics.checkNotNull((Object)container);
            n2 = container.inventorySlots.size();
        }
        else {
            n2 = n;
        }
        return n2;
    }
    
    @Nullable
    public final Item getStackInSlot(final int slot) {
        Item item;
        if (this.inventory == null) {
            final Container container = this.container;
            Intrinsics.checkNotNull((Object)container);
            final ItemStack getStack = container.getSlot(slot).getStack();
            if (getStack == null) {
                item = null;
            }
            else {
                final ItemStack p0 = getStack;
                final int n = 0;
                item = new Item(p0);
            }
        }
        else {
            final ItemStack getStackInSlot = this.inventory.getStackInSlot(slot);
            if (getStackInSlot == null) {
                item = null;
            }
            else {
                final ItemStack p0 = getStackInSlot;
                final int n2 = 0;
                item = new Item(p0);
            }
        }
        return item;
    }
    
    public final int getWindowId() {
        final Container container = this.container;
        return (container == null) ? -1 : container.windowId;
    }
    
    public final void doAction(@NotNull final Action action) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        action.complete();
    }
    
    public final boolean isItemValidForSlot(final int slot, @NotNull final Item item) {
        Intrinsics.checkNotNullParameter((Object)item, "item");
        return this.inventory == null || this.inventory.isItemValidForSlot(slot, item.getItemStack());
    }
    
    @NotNull
    public final List<Item> getItems() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* this */
        //     2: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/inventory/Inventory.getSize:()I
        //     5: invokestatic    kotlin/ranges/RangesKt.until:(II)Lkotlin/ranges/IntRange;
        //     8: checkcast       Ljava/lang/Iterable;
        //    11: astore_1        /* $this$map$iv */
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$map */
        //    14: aload_1         /* $this$map$iv */
        //    15: astore_3       
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: aload_1         /* $this$map$iv */
        //    21: bipush          10
        //    23: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    26: invokespecial   java/util/ArrayList.<init>:(I)V
        //    29: checkcast       Ljava/util/Collection;
        //    32: astore          destination$iv$iv
        //    34: iconst_0       
        //    35: istore          $i$f$mapTo
        //    37: aload_3         /* $this$mapTo$iv$iv */
        //    38: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    43: astore          6
        //    45: aload           6
        //    47: invokeinterface java/util/Iterator.hasNext:()Z
        //    52: ifeq            94
        //    55: aload           6
        //    57: checkcast       Lkotlin/collections/IntIterator;
        //    60: invokevirtual   kotlin/collections/IntIterator.nextInt:()I
        //    63: istore          item$iv$iv
        //    65: aload           destination$iv$iv
        //    67: iload           item$iv$iv
        //    69: istore          8
        //    71: astore          10
        //    73: iconst_0       
        //    74: istore          $i$a$-map-Inventory$getItems$1
        //    76: aload_0         /* this */
        //    77: iload           p0
        //    79: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/inventory/Inventory.getStackInSlot:(I)Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;
        //    82: aload           10
        //    84: swap           
        //    85: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    90: pop            
        //    91: goto            45
        //    94: aload           destination$iv$iv
        //    96: checkcast       Ljava/util/List;
        //    99: nop            
        //   100: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;>;
        //    StackMapTable: 00 02 FF 00 2D 00 07 07 00 02 07 00 A4 01 07 00 A4 07 00 B1 01 07 00 B7 00 00 30
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Cannot read field "references" because "newVariable" is null
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
        //     at java.base/java.lang.Thread.run(Thread.java:842)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final boolean contains(@NotNull final Item item) {
        Intrinsics.checkNotNullParameter((Object)item, "item");
        return this.getItems().contains(item);
    }
    
    public final boolean contains(final int id) {
        final Iterable $this$any$iv = this.getItems();
        final int $i$f$any = 0;
        boolean b;
        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
            b = false;
        }
        else {
            for (final Object element$iv : $this$any$iv) {
                final Item it = (Item)element$iv;
                final int n = 0;
                final Item item = it;
                if (item != null && item.getID() == id) {
                    b = true;
                    return b;
                }
            }
            b = false;
        }
        return b;
    }
    
    public final int indexOf(@NotNull final Item item) {
        Intrinsics.checkNotNullParameter((Object)item, "item");
        return this.getItems().indexOf(item);
    }
    
    public final int indexOf(final int id) {
        final List $this$indexOfFirst$iv = this.getItems();
        final int $i$f$indexOfFirst = 0;
        int index$iv = 0;
        for (final Object item$iv : $this$indexOfFirst$iv) {
            final Item it = (Item)item$iv;
            final int n = 0;
            final Item item = it;
            if (item != null && item.getID() == id) {
                return index$iv;
            }
            ++index$iv;
        }
        return -1;
    }
    
    public final boolean isContainer() {
        return this.container != null;
    }
    
    @JvmOverloads
    @NotNull
    public final Inventory click(final int slot, final boolean shift, @NotNull final String button) {
        Intrinsics.checkNotNullParameter((Object)button, "button");
        final Inventory $this$click_u24lambda_u2d4 = this;
        final int n = 0;
        new ClickAction(slot, $this$click_u24lambda_u2d4.getWindowId()).setClickString(button).setHoldingShift(shift).complete();
        return this;
    }
    
    public static /* synthetic */ Inventory click$default(final Inventory inventory, final int slot, boolean shift, String button, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            shift = false;
        }
        if ((n & 0x4) != 0x0) {
            button = "LEFT";
        }
        return inventory.click(slot, shift, button);
    }
    
    @NotNull
    public final Inventory drop(final int slot, final boolean ctrl) {
        final Inventory $this$drop_u24lambda_u2d5 = this;
        final int n = 0;
        new DropAction(slot, $this$drop_u24lambda_u2d5.getWindowId()).setHoldingCtrl(ctrl).complete();
        return this;
    }
    
    @NotNull
    public final Inventory drag(@NotNull final String type, @NotNull final int... slots) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)slots, "slots");
        final Inventory $this$drag_u24lambda_u2d8 = this;
        final int n = 0;
        final DragAction $this$drag_u24lambda_u2d8_u24lambda_u2d7 = new DragAction(-999, $this$drag_u24lambda_u2d8.getWindowId());
        final int n2 = 0;
        final DragAction setStage = $this$drag_u24lambda_u2d8_u24lambda_u2d7.setStage(DragAction.Stage.BEGIN);
        final String upperCase = type.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        setStage.setClickType(DragAction.ClickType.valueOf(upperCase)).complete();
        $this$drag_u24lambda_u2d8_u24lambda_u2d7.setStage(DragAction.Stage.SLOT);
        final int[] $this$forEach$iv = slots;
        final int $i$f$forEach = 0;
        for (int i = 0; i < $this$forEach$iv.length; ++i) {
            final int it;
            final int element$iv = it = $this$forEach$iv[i];
            final int n3 = 0;
            $this$drag_u24lambda_u2d8_u24lambda_u2d7.setSlot(it).complete();
        }
        $this$drag_u24lambda_u2d8_u24lambda_u2d7.setStage(DragAction.Stage.END).setSlot(-999).complete();
        return this;
    }
    
    @NotNull
    public final String getName() {
        String getName2;
        if (this.container instanceof ContainerChest) {
            final String getName = ((ContainerChest)this.container).getLowerChestInventory().getName();
            Intrinsics.checkNotNullExpressionValue((Object)getName, "container.lowerChestInventory.name");
            getName2 = getName;
        }
        else {
            final IInventory inventory = this.inventory;
            if (inventory == null) {
                getName2 = "container";
            }
            else if ((getName2 = inventory.getName()) == null) {
                getName2 = "container";
            }
        }
        return getName2;
    }
    
    @NotNull
    public final String getClassName() {
        final IInventory inventory = this.inventory;
        String s2;
        String s;
        if (inventory == null) {
            s = (s2 = null);
        }
        else {
            final Class<? extends IInventory> class1 = inventory.getClass();
            s = (s2 = ((class1 == null) ? null : class1.getSimpleName()));
        }
        if (s2 == null) {
            final Container container = this.container;
            Intrinsics.checkNotNull((Object)container);
            final String simpleName = container.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue((Object)simpleName, "container!!.javaClass.simpleName");
            s = simpleName;
        }
        return s;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Inventory{name=" + this.getName() + ", size=" + this.getSize() + ", type=" + (this.isContainer() ? "container" : "inventory") + '}';
    }
    
    @NotNull
    public String toJSON(@NotNull final String key) {
        return JSONImpl.DefaultImpls.toJSON((JSONImpl)this, key);
    }
    
    @JvmOverloads
    @NotNull
    public final Inventory click(final int slot, final boolean shift) {
        return click$default(this, slot, shift, null, 4, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Inventory click(final int slot) {
        return click$default(this, slot, false, null, 6, null);
    }
}
