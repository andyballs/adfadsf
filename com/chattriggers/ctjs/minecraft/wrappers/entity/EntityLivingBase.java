//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.entity;

import kotlin.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import net.minecraft.item.*;
import org.jetbrains.annotations.*;
import net.minecraft.potion.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013J\b\u0010'\u001a\u00020(H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006)" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/EntityLivingBase;", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Entity;", "entityLivingBase", "Lnet/minecraft/entity/EntityLivingBase;", "Lcom/chattriggers/ctjs/utils/kotlin/MCEntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)V", "getEntityLivingBase", "()Lnet/minecraft/entity/EntityLivingBase;", "addPotionEffect", "", "effect", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;", "canSeeEntity", "", "other", "Lnet/minecraft/entity/Entity;", "Lcom/chattriggers/ctjs/utils/kotlin/MCEntity;", "clearPotionEffects", "getAbsorption", "", "getActivePotionEffects", "", "getAge", "", "getArmorValue", "getHP", "getItemInSlot", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "slot", "getMaxHP", "isPotionActive", "potionEffect", "id", "potion", "Lnet/minecraft/potion/Potion;", "setAbsorption", "absorption", "setHP", "health", "toString", "", "ctjs" })
public class EntityLivingBase extends Entity
{
    @NotNull
    private final net.minecraft.entity.EntityLivingBase entityLivingBase;
    
    public EntityLivingBase(@NotNull final net.minecraft.entity.EntityLivingBase entityLivingBase) {
        Intrinsics.checkNotNullParameter((Object)entityLivingBase, "entityLivingBase");
        super((net.minecraft.entity.Entity)entityLivingBase);
        this.entityLivingBase = entityLivingBase;
    }
    
    @NotNull
    public final net.minecraft.entity.EntityLivingBase getEntityLivingBase() {
        return this.entityLivingBase;
    }
    
    public final void addPotionEffect(@NotNull final PotionEffect effect) {
        Intrinsics.checkNotNullParameter((Object)effect, "effect");
        this.entityLivingBase.addPotionEffect(effect.getEffect());
    }
    
    public final void clearPotionEffects() {
        this.entityLivingBase.clearActivePotions();
    }
    
    @NotNull
    public final List<PotionEffect> getActivePotionEffects() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/entity/EntityLivingBase.entityLivingBase:Lnet/minecraft/entity/EntityLivingBase;
        //     4: invokevirtual   net/minecraft/entity/EntityLivingBase.getActivePotionEffects:()Ljava/util/Collection;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc             "entityLivingBase.activePotionEffects"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_1        
        //    15: checkcast       Ljava/lang/Iterable;
        //    18: astore_1        /* $this$map$iv */
        //    19: iconst_0       
        //    20: istore_2        /* $i$f$map */
        //    21: aload_1         /* $this$map$iv */
        //    22: astore_3       
        //    23: new             Ljava/util/ArrayList;
        //    26: dup            
        //    27: aload_1         /* $this$map$iv */
        //    28: bipush          10
        //    30: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    33: invokespecial   java/util/ArrayList.<init>:(I)V
        //    36: checkcast       Ljava/util/Collection;
        //    39: astore          destination$iv$iv
        //    41: iconst_0       
        //    42: istore          $i$f$mapTo
        //    44: aload_3         /* $this$mapTo$iv$iv */
        //    45: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    50: astore          6
        //    52: aload           6
        //    54: invokeinterface java/util/Iterator.hasNext:()Z
        //    59: ifeq            106
        //    62: aload           6
        //    64: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    69: astore          item$iv$iv
        //    71: aload           destination$iv$iv
        //    73: aload           item$iv$iv
        //    75: checkcast       Lnet/minecraft/potion/PotionEffect;
        //    78: astore          8
        //    80: astore          10
        //    82: iconst_0       
        //    83: istore          $i$a$-map-EntityLivingBase$getActivePotionEffects$1
        //    85: new             Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;
        //    88: dup            
        //    89: aload           p0
        //    91: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect.<init>:(Lnet/minecraft/potion/PotionEffect;)V
        //    94: aload           10
        //    96: swap           
        //    97: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   102: pop            
        //   103: goto            52
        //   106: aload           destination$iv$iv
        //   108: checkcast       Ljava/util/List;
        //   111: nop            
        //   112: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;>;
        //    StackMapTable: 00 02 FF 00 34 00 07 07 00 02 07 00 64 01 07 00 64 07 00 71 01 07 00 77 00 00 35
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
    
    public final boolean canSeeEntity(@NotNull final net.minecraft.entity.Entity other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return this.entityLivingBase.canEntityBeSeen(other);
    }
    
    public final boolean canSeeEntity(@NotNull final Entity other) {
        Intrinsics.checkNotNullParameter((Object)other, "other");
        return this.canSeeEntity(other.getEntity());
    }
    
    @Nullable
    public final Item getItemInSlot(final int slot) {
        final ItemStack getEquipmentInSlot = this.entityLivingBase.getEquipmentInSlot(slot);
        Item item;
        if (getEquipmentInSlot == null) {
            item = null;
        }
        else {
            final ItemStack p0 = getEquipmentInSlot;
            final int n = 0;
            item = new Item(p0);
        }
        return item;
    }
    
    public final float getHP() {
        return this.entityLivingBase.getHealth();
    }
    
    @NotNull
    public final EntityLivingBase setHP(final float health) {
        final EntityLivingBase $this$setHP_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setHP_u24lambda_u2d1.getEntityLivingBase().setHealth(health);
        return this;
    }
    
    public final float getMaxHP() {
        return this.entityLivingBase.getMaxHealth();
    }
    
    public final float getAbsorption() {
        return this.entityLivingBase.getAbsorptionAmount();
    }
    
    @NotNull
    public final EntityLivingBase setAbsorption(final float absorption) {
        final EntityLivingBase $this$setAbsorption_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setAbsorption_u24lambda_u2d2.getEntityLivingBase().setAbsorptionAmount(absorption);
        return this;
    }
    
    public final int getAge() {
        return this.entityLivingBase.getAge();
    }
    
    public final int getArmorValue() {
        return this.entityLivingBase.getTotalArmorValue();
    }
    
    public final boolean isPotionActive(final int id) {
        return this.entityLivingBase.isPotionActive(id);
    }
    
    public final boolean isPotionActive(@NotNull final Potion potion) {
        Intrinsics.checkNotNullParameter((Object)potion, "potion");
        return this.isPotionActive(potion.id);
    }
    
    public final boolean isPotionActive(@NotNull final PotionEffect potionEffect) {
        Intrinsics.checkNotNullParameter((Object)potionEffect, "potionEffect");
        return this.isPotionActive(potionEffect.getEffect().getPotionID());
    }
    
    @NotNull
    public String toString() {
        return "EntityLivingBase{name=" + this.getName() + ", entity=" + super.toString() + '}';
    }
}
