//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory;

import net.minecraft.item.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.block.*;
import net.minecraft.entity.item.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import net.minecraft.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.*;
import kotlin.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import java.util.*;
import net.minecraft.entity.player.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import net.minecraft.client.renderer.entity.*;
import kotlin.jvm.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u000f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fJ0\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007J\u0013\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0,J\u0006\u0010-\u001a\u00020\tJ\b\u0010.\u001a\u00020/H\u0007J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000601J\u0006\u00102\u001a\u00020\tJ\u0006\u00103\u001a\u00020\tJ\u0006\u00104\u001a\u00020/J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u0006\u00107\u001a\u00020\u0006J\u0006\u00108\u001a\u00020\tJ\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020\u0006J\b\u0010<\u001a\u00020\tH\u0016J\u0006\u0010=\u001a\u00020\u001dJ\u0006\u0010>\u001a\u00020\u001dJ\u0006\u0010?\u001a\u00020\u001dJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\tJ\u001f\u0010B\u001a\u00020\u00002\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060D\"\u00020\u0006¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0006J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\tJ\b\u0010J\u001a\u00020\u0006H\u0016R\u0015\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0004¨\u0006K" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "", "itemStack", "Lnet/minecraft/item/ItemStack;", "(Lnet/minecraft/item/ItemStack;)V", "itemName", "", "(Ljava/lang/String;)V", "itemID", "", "(I)V", "block", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;", "(Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/BlockType;)V", "entityItem", "Lnet/minecraft/entity/item/EntityItem;", "(Lnet/minecraft/entity/item/EntityItem;)V", "entity", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "(Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;)V", "item", "Lnet/minecraft/item/Item;", "Lcom/chattriggers/ctjs/utils/kotlin/MCItem;", "getItem", "()Lnet/minecraft/item/Item;", "getItemStack", "()Lnet/minecraft/item/ItemStack;", "setItemStack", "canDestroy", "", "canHarvest", "canPlaceOn", "draw", "", "x", "", "y", "scale", "z", "equals", "other", "getDamage", "getDurability", "getEnchantments", "", "getID", "getItemNBT", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound;", "getLore", "", "getMaxDamage", "getMetadata", "getNBT", "getName", "getRawNBT", "getRegistryName", "getStackSize", "getTextComponent", "Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;", "getUnlocalizedName", "hashCode", "isDamagable", "isEnchantable", "isEnchanted", "setDamage", "damage", "setLore", "loreLines", "", "([Ljava/lang/String;)Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "setName", "name", "setStackSize", "stackSize", "toString", "ctjs" })
public final class Item
{
    @NotNull
    private final net.minecraft.item.Item item;
    @NotNull
    private ItemStack itemStack;
    
    @NotNull
    public final net.minecraft.item.Item getItem() {
        return this.item;
    }
    
    @NotNull
    public final ItemStack getItemStack() {
        return this.itemStack;
    }
    
    public final void setItemStack(@NotNull final ItemStack <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.itemStack = <set-?>;
    }
    
    public Item(@NotNull final ItemStack itemStack) {
        Intrinsics.checkNotNullParameter((Object)itemStack, "itemStack");
        final net.minecraft.item.Item getItem = itemStack.getItem();
        Intrinsics.checkNotNullExpressionValue((Object)getItem, "itemStack.item");
        this.item = getItem;
        this.itemStack = itemStack;
    }
    
    public Item(@NotNull final String itemName) {
        Intrinsics.checkNotNullParameter((Object)itemName, "itemName");
        final net.minecraft.item.Item getByNameOrId = net.minecraft.item.Item.getByNameOrId(itemName);
        if (getByNameOrId == null) {
            throw new IllegalArgumentException("Item with name or id " + itemName + " does not exist");
        }
        this.item = getByNameOrId;
        this.itemStack = new ItemStack(this.item);
    }
    
    public Item(final int itemID) {
        final net.minecraft.item.Item getItemById = net.minecraft.item.Item.getItemById(itemID);
        if (getItemById == null) {
            throw new IllegalArgumentException("Item with id " + itemID + " does not exist");
        }
        this.item = getItemById;
        this.itemStack = new ItemStack(this.item);
    }
    
    public Item(@NotNull final BlockType block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final net.minecraft.item.Item getItemFromBlock = net.minecraft.item.Item.getItemFromBlock(block.getMcBlock());
        if (getItemFromBlock == null) {
            throw new IllegalArgumentException("BlockType " + block + " does not exist");
        }
        this.item = getItemFromBlock;
        this.itemStack = new ItemStack(this.item);
    }
    
    public Item(@NotNull final EntityItem entityItem) {
        Intrinsics.checkNotNullParameter((Object)entityItem, "entityItem");
        final net.minecraft.item.Item getItem = entityItem.getEntityItem().getItem();
        Intrinsics.checkNotNullExpressionValue((Object)getItem, "entityItem.entityItem.item");
        this.item = getItem;
        final ItemStack getEntityItem = entityItem.getEntityItem();
        Intrinsics.checkNotNullExpressionValue((Object)getEntityItem, "entityItem.entityItem");
        this.itemStack = getEntityItem;
    }
    
    public Item(@NotNull final Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, "entity");
        if (!(entity.getEntity() instanceof EntityItem)) {
            final int n = 0;
            throw new IllegalArgumentException("Entity is not of type EntityItem".toString());
        }
        final net.minecraft.item.Item getItem = ((EntityItem)entity.getEntity()).getEntityItem().getItem();
        Intrinsics.checkNotNullExpressionValue((Object)getItem, "entity.entity.entityItem.item");
        this.item = getItem;
        final ItemStack getEntityItem = ((EntityItem)entity.getEntity()).getEntityItem();
        Intrinsics.checkNotNullExpressionValue((Object)getEntityItem, "entity.entity.entityItem");
        this.itemStack = getEntityItem;
    }
    
    @NotNull
    public final TextComponent getTextComponent() {
        final IChatComponent getChatComponent = this.itemStack.getChatComponent();
        Intrinsics.checkNotNullExpressionValue((Object)getChatComponent, "itemStack.chatComponent");
        return new TextComponent(getChatComponent);
    }
    
    @NotNull
    public final String getRawNBT() {
        final String string = this.itemStack.serializeNBT().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "itemStack.serializeNBT().toString()");
        return string;
    }
    
    @NotNull
    public final NBTTagCompound getNBT() {
        final net.minecraft.nbt.NBTTagCompound serializeNBT = this.itemStack.serializeNBT();
        Intrinsics.checkNotNullExpressionValue((Object)serializeNBT, "itemStack.serializeNBT()");
        return new NBTTagCompound(serializeNBT);
    }
    
    @Deprecated(message = "Use the better-named method", replaceWith = @ReplaceWith(expression = "getNBT", imports = {}))
    @NotNull
    @java.lang.Deprecated
    public final NBTTagCompound getItemNBT() {
        return this.getNBT();
    }
    
    public final int getID() {
        return net.minecraft.item.Item.getIdFromItem(this.item);
    }
    
    @NotNull
    public final Item setStackSize(final int stackSize) {
        final Item $this$setStackSize_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setStackSize_u24lambda_u2d1.getItemStack().stackSize = stackSize;
        return this;
    }
    
    public final int getStackSize() {
        return this.itemStack.stackSize;
    }
    
    @NotNull
    public final String getUnlocalizedName() {
        final String getUnlocalizedName = this.item.getUnlocalizedName();
        Intrinsics.checkNotNullExpressionValue((Object)getUnlocalizedName, "item.unlocalizedName");
        return getUnlocalizedName;
    }
    
    @NotNull
    public final String getRegistryName() {
        return this.item.getRegistryName().toString();
    }
    
    @NotNull
    public final String getName() {
        final String getDisplayName = this.itemStack.getDisplayName();
        Intrinsics.checkNotNullExpressionValue((Object)getDisplayName, "itemStack.displayName");
        return getDisplayName;
    }
    
    @NotNull
    public final Item setName(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final Item $this$setName_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setName_u24lambda_u2d2.getItemStack().setStackDisplayName(ChatLib.addColor(name));
        return this;
    }
    
    @NotNull
    public final Map<String, Integer> getEnchantments() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/inventory/Item.itemStack:Lnet/minecraft/item/ItemStack;
        //     4: invokestatic    net/minecraft/enchantment/EnchantmentHelper.getEnchantments:(Lnet/minecraft/item/ItemStack;)Ljava/util/Map;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc_w           "getEnchantments(itemStack)"
        //    12: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    15: aload_1        
        //    16: astore_1        /* $this$mapKeys$iv */
        //    17: iconst_0       
        //    18: istore_2        /* $i$f$mapKeys */
        //    19: aload_1         /* $this$mapKeys$iv */
        //    20: astore_3       
        //    21: new             Ljava/util/LinkedHashMap;
        //    24: dup            
        //    25: aload_1         /* $this$mapKeys$iv */
        //    26: invokeinterface java/util/Map.size:()I
        //    31: invokestatic    kotlin/collections/MapsKt.mapCapacity:(I)I
        //    34: invokespecial   java/util/LinkedHashMap.<init>:(I)V
        //    37: checkcast       Ljava/util/Map;
        //    40: astore          destination$iv$iv
        //    42: iconst_0       
        //    43: istore          $i$f$mapKeysTo
        //    45: aload_3         /* $this$mapKeysTo$iv$iv */
        //    46: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    51: checkcast       Ljava/lang/Iterable;
        //    54: astore          $this$associateByTo$iv$iv$iv
        //    56: iconst_0       
        //    57: istore          $i$f$associateByTo
        //    59: aload           $this$associateByTo$iv$iv$iv
        //    61: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    66: astore          8
        //    68: aload           8
        //    70: invokeinterface java/util/Iterator.hasNext:()Z
        //    75: ifeq            197
        //    78: aload           8
        //    80: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    85: astore          element$iv$iv$iv
        //    87: aload           destination$iv$iv
        //    89: aload           element$iv$iv$iv
        //    91: checkcast       Ljava/util/Map$Entry;
        //    94: astore          10
        //    96: astore          18
        //    98: iconst_0       
        //    99: istore          $i$a$-mapKeys-Item$getEnchantments$1
        //   101: aload           it
        //   103: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   108: astore          12
        //   110: aload           12
        //   112: ldc_w           "it.key"
        //   115: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   118: aload           12
        //   120: checkcast       Ljava/lang/Number;
        //   123: invokevirtual   java/lang/Number.intValue:()I
        //   126: invokestatic    net/minecraft/enchantment/Enchantment.getEnchantmentById:(I)Lnet/minecraft/enchantment/Enchantment;
        //   129: invokevirtual   net/minecraft/enchantment/Enchantment.getName:()Ljava/lang/String;
        //   132: astore          13
        //   134: aload           13
        //   136: ldc_w           "getEnchantmentById(\n    \u2026dif\n                .name"
        //   139: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   142: aload           13
        //   144: ldc_w           "enchantment."
        //   147: ldc_w           ""
        //   150: iconst_0       
        //   151: iconst_4       
        //   152: aconst_null    
        //   153: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
        //   156: aload           18
        //   158: swap           
        //   159: aload           element$iv$iv$iv
        //   161: checkcast       Ljava/util/Map$Entry;
        //   164: astore          14
        //   166: astore          15
        //   168: astore          16
        //   170: iconst_0       
        //   171: istore          $i$a$-associateByTo-MapsKt__MapsKt$mapKeysTo$1$iv$iv
        //   173: aload           it$iv$iv
        //   175: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   180: astore          10
        //   182: aload           16
        //   184: aload           15
        //   186: aload           10
        //   188: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   193: pop            
        //   194: goto            68
        //   197: aload           destination$iv$iv
        //   199: nop            
        //   200: nop            
        //   201: areturn        
        //    Signature:
        //  ()Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;
        //    StackMapTable: 00 02 FF 00 44 00 09 07 00 02 07 01 1E 01 07 01 1E 07 01 1E 01 07 01 2F 01 07 01 35 00 00 FB 00 80
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
    
    public final boolean isEnchantable() {
        return this.itemStack.isItemEnchantable();
    }
    
    public final boolean isEnchanted() {
        return this.itemStack.isItemEnchanted();
    }
    
    public final int getMetadata() {
        return this.itemStack.getMetadata();
    }
    
    public final boolean canPlaceOn(@NotNull final BlockType block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        return this.itemStack.canPlaceOn(block.getMcBlock());
    }
    
    public final boolean canHarvest(@NotNull final BlockType block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        return this.itemStack.canHarvestBlock(block.getMcBlock());
    }
    
    public final boolean canDestroy(@NotNull final BlockType block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        return this.itemStack.canDestroy(block.getMcBlock());
    }
    
    public final int getDurability() {
        return this.getMaxDamage() - this.getDamage();
    }
    
    public final int getDamage() {
        return this.itemStack.getItemDamage();
    }
    
    @NotNull
    public final Item setDamage(final int damage) {
        final Item $this$setDamage_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setDamage_u24lambda_u2d4.getItemStack().setItemDamage(damage);
        return this;
    }
    
    public final int getMaxDamage() {
        return this.itemStack.getMaxDamage();
    }
    
    public final boolean isDamagable() {
        return this.itemStack.isItemStackDamageable();
    }
    
    @NotNull
    public final List<String> getLore() {
        final List getTooltip = this.itemStack.getTooltip((EntityPlayer)Player.getPlayer(), Client.Companion.getMinecraft().gameSettings.advancedItemTooltips);
        Intrinsics.checkNotNullExpressionValue((Object)getTooltip, "itemStack.getTooltip(Pla\u2026ngs.advancedItemTooltips)");
        return (List<String>)getTooltip;
    }
    
    @NotNull
    public final Item setLore(@NotNull final String... loreLines) {
        Intrinsics.checkNotNullParameter((Object)loreLines, "loreLines");
        final Item $this$setLore_u24lambda_u2d8 = this;
        final int n = 0;
        if ($this$setLore_u24lambda_u2d8.getItemStack().getTagCompound() == null) {
            $this$setLore_u24lambda_u2d8.getItemStack().setTagCompound(new net.minecraft.nbt.NBTTagCompound());
        }
        NBTTagCompound it = $this$setLore_u24lambda_u2d8.getNBT().getCompoundTag("tag");
        final int n2 = 0;
        if (!it.getRawNBT().hasKey("display")) {
            it.set("display", new net.minecraft.nbt.NBTTagCompound());
        }
        it = it.getCompoundTag("display");
        final int n3 = 0;
        if (!it.getRawNBT().hasKey("display")) {
            it.set("Lore", new NBTTagList());
        }
        final NBTTagList lore = it.getTagList("Lore", 8);
        lore.tagList.clear();
        final Object[] $this$forEach$iv = loreLines;
        final int $i$f$forEach = 0;
        for (int i = 0; i < $this$forEach$iv.length; ++i) {
            final String it2;
            final Object element$iv = it2 = (String)$this$forEach$iv[i];
            final int n4 = 0;
            lore.appendTag((NBTBase)new NBTTagString(ChatLib.addColor(it2)));
        }
        return this;
    }
    
    @JvmOverloads
    public final void draw(final float x, final float y, final float scale, final float z) {
        final RenderItem itemRenderer = Client.Companion.getMinecraft().getRenderItem();
        GlStateManager.scale(scale, scale, 1.0f);
        GlStateManager.translate(x / scale, y / scale, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        RenderHelper.enableStandardItemLighting();
        RenderHelper.enableGUIStandardItemLighting();
        itemRenderer.zLevel = z;
        itemRenderer.renderItemIntoGUI(this.itemStack, 0, 0);
        Renderer.finishDraw();
    }
    
    public static /* synthetic */ void draw$default(final Item item, float x, float y, float scale, float z, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            x = 0.0f;
        }
        if ((n & 0x2) != 0x0) {
            y = 0.0f;
        }
        if ((n & 0x4) != 0x0) {
            scale = 1.0f;
        }
        if ((n & 0x8) != 0x0) {
            z = 200.0f;
        }
        item.draw(x, y, scale, z);
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof Item && this.getID() == ((Item)other).getID() && this.getStackSize() == ((Item)other).getStackSize() && this.getDamage() == ((Item)other).getDamage();
    }
    
    @Override
    public int hashCode() {
        int result = this.item.hashCode();
        result = 31 * result + this.itemStack.hashCode();
        return result;
    }
    
    @NotNull
    @Override
    public String toString() {
        final String string = this.itemStack.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "itemStack.toString()");
        return string;
    }
    
    @JvmOverloads
    public final void draw(final float x, final float y, final float scale) {
        draw$default(this, x, y, scale, 0.0f, 8, null);
    }
    
    @JvmOverloads
    public final void draw(final float x, final float y) {
        draw$default(this, x, y, 0.0f, 0.0f, 12, null);
    }
    
    @JvmOverloads
    public final void draw(final float x) {
        draw$default(this, x, 0.0f, 0.0f, 0.0f, 14, null);
    }
    
    @JvmOverloads
    public final void draw() {
        draw$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }
}
