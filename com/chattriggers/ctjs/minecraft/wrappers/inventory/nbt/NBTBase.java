//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.io.*;
import kotlin.collections.*;
import net.minecraft.nbt.*;
import org.mozilla.javascript.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTBase;", "", "rawNBT", "Lnet/minecraft/nbt/NBTBase;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTBase;", "(Lnet/minecraft/nbt/NBTBase;)V", "id", "", "getId", "()B", "getRawNBT", "()Lnet/minecraft/nbt/NBTBase;", "copy", "kotlin.jvm.PlatformType", "equals", "", "other", "hasNoTags", "hasTags", "hashCode", "", "toString", "", "Companion", "ctjs" })
public class NBTBase
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final net.minecraft.nbt.NBTBase rawNBT;
    
    public NBTBase(@NotNull final net.minecraft.nbt.NBTBase rawNBT) {
        Intrinsics.checkNotNullParameter((Object)rawNBT, "rawNBT");
        this.rawNBT = rawNBT;
    }
    
    @NotNull
    public net.minecraft.nbt.NBTBase getRawNBT() {
        return this.rawNBT;
    }
    
    public final byte getId() {
        return this.getRawNBT().getId();
    }
    
    public final net.minecraft.nbt.NBTBase copy() {
        return this.getRawNBT().copy();
    }
    
    public final boolean hasNoTags() {
        return this.getRawNBT().hasNoTags();
    }
    
    public final boolean hasTags() {
        return !this.getRawNBT().hasNoTags();
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return Intrinsics.areEqual((Object)this.getRawNBT(), other);
    }
    
    @Override
    public int hashCode() {
        return this.getRawNBT().hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        final String string = this.getRawNBT().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "rawNBT.toString()");
        return string;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0003\u001a\u00020\u0005*\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00060\u0007j\u0002`\bJ\u000e\u0010\u0006\u001a\u00020\u0005*\u00060\tj\u0002`\nJ\u000e\u0010\u0006\u001a\u00020\u0004*\u00060\u000bj\u0002`\f¨\u0006\r" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTBase$Companion;", "", "()V", "expose", "Lorg/mozilla/javascript/NativeArray;", "Lorg/mozilla/javascript/NativeObject;", "toObject", "Lnet/minecraft/nbt/NBTBase;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTBase;", "Lnet/minecraft/nbt/NBTTagCompound;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTTagCompound;", "Lnet/minecraft/nbt/NBTTagList;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTTagList;", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @Nullable
        public final Object toObject(@NotNull final net.minecraft.nbt.NBTBase $this$toObject) {
            Intrinsics.checkNotNullParameter((Object)$this$toObject, "<this>");
            Serializable s;
            if ($this$toObject instanceof NBTTagString) {
                s = ((NBTTagString)$this$toObject).getString();
            }
            else if ($this$toObject instanceof NBTTagByte) {
                s = ((NBTTagByte)$this$toObject).getByte();
            }
            else if ($this$toObject instanceof NBTTagShort) {
                s = ((NBTTagShort)$this$toObject).getShort();
            }
            else if ($this$toObject instanceof NBTTagInt) {
                s = ((NBTTagInt)$this$toObject).getInt();
            }
            else if ($this$toObject instanceof NBTTagLong) {
                s = ((NBTTagLong)$this$toObject).getLong();
            }
            else if ($this$toObject instanceof NBTTagFloat) {
                s = ((NBTTagFloat)$this$toObject).getFloat();
            }
            else if ($this$toObject instanceof NBTTagDouble) {
                s = ((NBTTagDouble)$this$toObject).getDouble();
            }
            else if ($this$toObject instanceof NBTTagCompound) {
                s = (Serializable)this.toObject((NBTTagCompound)$this$toObject);
            }
            else if ($this$toObject instanceof NBTTagList) {
                s = (Serializable)this.toObject((NBTTagList)$this$toObject);
            }
            else if ($this$toObject instanceof NBTTagByteArray) {
                final byte[] getByteArray = ((NBTTagByteArray)$this$toObject).getByteArray();
                Intrinsics.checkNotNullExpressionValue((Object)getByteArray, "byteArray");
                s = (Serializable)this.expose(new NativeArray((Object[])ArraysKt.toTypedArray(getByteArray)));
            }
            else {
                if (!($this$toObject instanceof NBTTagIntArray)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Unknown tag type ", (Object)$this$toObject.getClass()).toString());
                }
                final int[] getIntArray = ((NBTTagIntArray)$this$toObject).getIntArray();
                Intrinsics.checkNotNullExpressionValue((Object)getIntArray, "intArray");
                s = (Serializable)this.expose(new NativeArray((Object[])ArraysKt.toTypedArray(getIntArray)));
            }
            return s;
        }
        
        @NotNull
        public final NativeObject toObject(@NotNull final NBTTagCompound $this$toObject) {
            Intrinsics.checkNotNullParameter((Object)$this$toObject, "<this>");
            final NativeObject o = new NativeObject();
            this.expose(o);
            for (final String key : $this$toObject.getKeySet()) {
                final net.minecraft.nbt.NBTBase value = $this$toObject.tagMap.get(key);
                if (value != null) {
                    o.put(key, (Scriptable)o, this.toObject(value));
                }
            }
            return o;
        }
        
        @NotNull
        public final NativeArray toObject(@NotNull final NBTTagList $this$toObject) {
            Intrinsics.checkNotNullParameter((Object)$this$toObject, "<this>");
            final List tags = new ArrayList();
            int j = 0;
            while (j < $this$toObject.tagCount()) {
                final int i = j;
                ++j;
                final List list = tags;
                final net.minecraft.nbt.NBTBase get = $this$toObject.get(i);
                Intrinsics.checkNotNullExpressionValue((Object)get, "get(i)");
                list.add(this.toObject(get));
            }
            final Collection $this$toTypedArray$iv = tags;
            final int $i$f$toTypedArray = 0;
            final Collection thisCollection$iv = $this$toTypedArray$iv;
            final Object[] array2 = thisCollection$iv.toArray(new Object[0]);
            Intrinsics.checkNotNull((Object)array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            final NativeArray array = new NativeArray(array2);
            this.expose(array);
            return array;
        }
        
        private final NativeArray expose(final NativeArray $this$expose) {
            final NativeArray $this$expose_u24lambda_u2d0 = $this$expose;
            final int n = 0;
            $this$expose_u24lambda_u2d0.exportAsJSClass(32, (Scriptable)$this$expose_u24lambda_u2d0, false);
            return $this$expose;
        }
        
        private final NativeObject expose(final NativeObject $this$expose) {
            final NativeObject $this$expose_u24lambda_u2d1 = $this$expose;
            final int n = 0;
            $this$expose_u24lambda_u2d1.exportAsJSClass(12, (Scriptable)$this$expose_u24lambda_u2d1, false);
            return $this$expose;
        }
    }
}
