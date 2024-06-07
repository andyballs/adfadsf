//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt;

import kotlin.*;
import kotlin.jvm.internal.*;
import net.minecraft.nbt.*;
import org.jetbrains.annotations.*;
import org.mozilla.javascript.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u0012\u0010\f\u001a\u00020\u00002\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\u0019\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0086\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\tJ\u0016\u0010\u001c\u001a\n \u0011*\u0004\u0018\u00010\u001d0\u001d2\u0006\u0010\u0012\u001a\u00020\tJ\u0016\u0010\u001e\u001a\n \u0011*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010\u0012\u001a\u00020\tJ\u0016\u0010 \u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0001J\u001a\u0010 \u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\u0016\u0010!\u001a\n \u0011*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\u0012\u001a\u00020\tJ\u0019\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0001H\u0086\u0002J\u001d\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0086\u0002J\u0006\u0010$\u001a\u00020%R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006&" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagList;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTBase;", "rawNBT", "Lnet/minecraft/nbt/NBTTagList;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTTagList;", "(Lnet/minecraft/nbt/NBTTagList;)V", "getRawNBT", "()Lnet/minecraft/nbt/NBTTagList;", "tagCount", "", "getTagCount", "()I", "appendTag", "nbt", "Lnet/minecraft/nbt/NBTBase;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTBase;", "get", "kotlin.jvm.PlatformType", "index", "", "type", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound$NBTDataType;", "getCompoundTagAt", "Lnet/minecraft/nbt/NBTTagCompound;", "getDoubleAt", "", "getFloatAt", "", "getIntArrayAt", "", "getStringTagAt", "", "insertTag", "removeTag", "set", "id", "toArray", "Lorg/mozilla/javascript/NativeArray;", "ctjs" })
public final class NBTTagList extends NBTBase
{
    @NotNull
    private final net.minecraft.nbt.NBTTagList rawNBT;
    
    public NBTTagList(@NotNull final net.minecraft.nbt.NBTTagList rawNBT) {
        Intrinsics.checkNotNullParameter((Object)rawNBT, "rawNBT");
        super((net.minecraft.nbt.NBTBase)rawNBT);
        this.rawNBT = rawNBT;
    }
    
    @NotNull
    public net.minecraft.nbt.NBTTagList getRawNBT() {
        return this.rawNBT;
    }
    
    public final int getTagCount() {
        return this.getRawNBT().tagCount();
    }
    
    @NotNull
    public final NBTTagList appendTag(@NotNull final NBTBase nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        return this.appendTag(nbt.getRawNBT());
    }
    
    @NotNull
    public final NBTTagList appendTag(@NotNull final net.minecraft.nbt.NBTBase nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        final NBTTagList $this$appendTag_u24lambda_u2d0 = this;
        final int n = 0;
        $this$appendTag_u24lambda_u2d0.getRawNBT().appendTag(nbt);
        return this;
    }
    
    @NotNull
    public final NBTTagList set(final int id, @NotNull final NBTBase nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        return this.set(id, nbt.getRawNBT());
    }
    
    @NotNull
    public final NBTTagList set(final int id, @NotNull final net.minecraft.nbt.NBTBase nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        final NBTTagList $this$set_u24lambda_u2d1 = this;
        final int n = 0;
        $this$set_u24lambda_u2d1.getRawNBT().set(id, nbt);
        return this;
    }
    
    @NotNull
    public final NBTTagList insertTag(final int index, @NotNull final NBTBase nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        return this.insertTag(index, nbt.getRawNBT());
    }
    
    @NotNull
    public final NBTTagList insertTag(final int index, @NotNull final net.minecraft.nbt.NBTBase nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, "nbt");
        final NBTTagList $this$insertTag_u24lambda_u2d2 = this;
        final int n = 0;
        $this$insertTag_u24lambda_u2d2.getRawNBT().tagList.add(index, nbt);
        return this;
    }
    
    public final net.minecraft.nbt.NBTBase removeTag(final int index) {
        return this.getRawNBT().removeTag(index);
    }
    
    public final NBTTagCompound getCompoundTagAt(final int index) {
        return this.getRawNBT().getCompoundTagAt(index);
    }
    
    public final int[] getIntArrayAt(final int index) {
        return this.getRawNBT().getIntArrayAt(index);
    }
    
    public final double getDoubleAt(final int index) {
        return this.getRawNBT().getDoubleAt(index);
    }
    
    public final float getFloatAt(final int index) {
        return this.getRawNBT().getFloatAt(index);
    }
    
    public final String getStringTagAt(final int index) {
        return this.getRawNBT().getStringTagAt(index);
    }
    
    public final net.minecraft.nbt.NBTBase get(final int index) {
        return this.getRawNBT().get(index);
    }
    
    @Nullable
    public final Object get(final int index, @NotNull final com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt.NBTTagCompound.NBTDataType type) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Object o = null;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1: {
                o = this.getFloatAt(index);
                break;
            }
            case 2: {
                o = this.getDoubleAt(index);
                break;
            }
            case 3: {
                o = this.getStringTagAt(index);
                break;
            }
            case 4: {
                o = this.getIntArrayAt(index);
                break;
            }
            case 5: {
                o = this.getCompoundTagAt(index);
                break;
            }
            default: {
                o = this.get(index);
                break;
            }
        }
        return o;
    }
    
    @NotNull
    public final NativeArray toArray() {
        return NBTBase.Companion.toObject(this.getRawNBT());
    }
}
