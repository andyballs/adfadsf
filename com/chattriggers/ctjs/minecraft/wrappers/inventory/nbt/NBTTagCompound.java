//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.nbt;

import kotlin.jvm.internal.*;
import java.util.*;
import org.jetbrains.annotations.*;
import net.minecraft.nbt.*;
import kotlin.*;
import org.mozilla.javascript.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001CB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0086\u0002J'\u0010\u0013\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010'\u001a\n !*\u0004\u0018\u00010(0(2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010,\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010.\u001a\n !*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010/\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u00100\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\bJ\u001e\u00101\u001a\n !*\u0004\u0018\u000102022\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0019J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u0019\u00104\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0015H\u0086\u0002J\u0016\u00106\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020\u001cJ\u0016\u00107\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020\u001eJ\u0016\u00108\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020 J\u0016\u00109\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020$J\u0016\u0010:\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020&J\u0016\u0010;\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020(J\u0016\u0010<\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0019J\u0016\u0010=\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020+J\u0016\u0010>\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0001J\u001a\u0010>\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\n\u00105\u001a\u00060\u000fj\u0002`\u0010J\u0016\u0010?\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020-J\u0016\u0010@\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ\u0006\u0010A\u001a\u00020BR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006D" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTBase;", "rawNBT", "Lnet/minecraft/nbt/NBTTagCompound;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTTagCompound;", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "keySet", "", "", "getKeySet", "()Ljava/util/Set;", "getRawNBT", "()Lnet/minecraft/nbt/NBTTagCompound;", "tagMap", "", "Lnet/minecraft/nbt/NBTBase;", "Lcom/chattriggers/ctjs/utils/kotlin/MCNBTBase;", "getTagMap", "()Ljava/util/Map;", "get", "key", "", "type", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound$NBTDataType;", "tagType", "", "(Ljava/lang/String;Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound$NBTDataType;Ljava/lang/Integer;)Ljava/lang/Object;", "getBoolean", "", "getByte", "", "getByteArray", "", "kotlin.jvm.PlatformType", "getCompoundTag", "getDouble", "", "getFloat", "", "getIntArray", "", "getInteger", "getLong", "", "getShort", "", "getString", "getTag", "getTagId", "getTagList", "Lnet/minecraft/nbt/NBTTagList;", "removeTag", "set", "value", "setBoolean", "setByte", "setByteArray", "setDouble", "setFloat", "setIntArray", "setInteger", "setLong", "setNBTBase", "setShort", "setString", "toObject", "Lorg/mozilla/javascript/NativeObject;", "NBTDataType", "ctjs" })
public final class NBTTagCompound extends NBTBase
{
    @NotNull
    private final net.minecraft.nbt.NBTTagCompound rawNBT;
    
    public NBTTagCompound(@NotNull final net.minecraft.nbt.NBTTagCompound rawNBT) {
        Intrinsics.checkNotNullParameter((Object)rawNBT, "rawNBT");
        super((net.minecraft.nbt.NBTBase)rawNBT);
        this.rawNBT = rawNBT;
    }
    
    @NotNull
    public net.minecraft.nbt.NBTTagCompound getRawNBT() {
        return this.rawNBT;
    }
    
    @NotNull
    public final Map<String, net.minecraft.nbt.NBTBase> getTagMap() {
        final Map tagMap = this.getRawNBT().tagMap;
        Intrinsics.checkNotNullExpressionValue((Object)tagMap, "rawNBT.tagMap");
        return (Map<String, net.minecraft.nbt.NBTBase>)tagMap;
    }
    
    @NotNull
    public final Set<String> getKeySet() {
        final Set getKeySet = this.getRawNBT().getKeySet();
        Intrinsics.checkNotNullExpressionValue((Object)getKeySet, "rawNBT.keySet");
        return (Set<String>)getKeySet;
    }
    
    @Nullable
    public final NBTBase getTag(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final net.minecraft.nbt.NBTBase tag = this.getRawNBT().getTag(key);
        return (tag instanceof net.minecraft.nbt.NBTTagCompound) ? ((NBTTagCompound)new NBTTagCompound((net.minecraft.nbt.NBTTagCompound)tag)) : ((tag != null) ? new NBTBase(tag) : null);
    }
    
    public final byte getTagId(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getTagId(key);
    }
    
    public final byte getByte(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getByte(key);
    }
    
    public final short getShort(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getShort(key);
    }
    
    public final int getInteger(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getInteger(key);
    }
    
    public final long getLong(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getLong(key);
    }
    
    public final float getFloat(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getFloat(key);
    }
    
    public final double getDouble(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getDouble(key);
    }
    
    public final String getString(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getString(key);
    }
    
    public final byte[] getByteArray(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getByteArray(key);
    }
    
    public final int[] getIntArray(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getIntArray(key);
    }
    
    public final boolean getBoolean(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getBoolean(key);
    }
    
    @NotNull
    public final NBTTagCompound getCompoundTag(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final net.minecraft.nbt.NBTTagCompound getCompoundTag = this.getRawNBT().getCompoundTag(key);
        Intrinsics.checkNotNullExpressionValue((Object)getCompoundTag, "rawNBT.getCompoundTag(key)");
        return new NBTTagCompound(getCompoundTag);
    }
    
    public final NBTTagList getTagList(@NotNull final String key, final int type) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getRawNBT().getTagList(key, type);
    }
    
    @Nullable
    public final Object get(@NotNull final String key, @NotNull final NBTDataType type, @Nullable final Integer tagType) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Object o = null;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1: {
                o = this.getByte(key);
                break;
            }
            case 2: {
                o = this.getShort(key);
                break;
            }
            case 3: {
                o = this.getInteger(key);
                break;
            }
            case 4: {
                o = this.getLong(key);
                break;
            }
            case 5: {
                o = this.getFloat(key);
                break;
            }
            case 6: {
                o = this.getDouble(key);
                break;
            }
            case 7: {
                if (!this.getRawNBT().hasKey(key, 8)) {
                    o = null;
                    break;
                }
                final net.minecraft.nbt.NBTBase nbtBase = this.getTagMap().get(key);
                if (nbtBase == null) {
                    o = null;
                    break;
                }
                final net.minecraft.nbt.NBTBase it = nbtBase;
                final int n = 0;
                o = new NBTBase(it).toString();
                break;
            }
            case 8: {
                if (!this.getRawNBT().hasKey(key, 7)) {
                    o = null;
                    break;
                }
                final net.minecraft.nbt.NBTBase value = this.getTagMap().get(key);
                if (value == null) {
                    throw new NullPointerException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagByteArray");
                }
                o = ((NBTTagByteArray)value).getByteArray();
                break;
            }
            case 9: {
                if (!this.getRawNBT().hasKey(key, 11)) {
                    o = null;
                    break;
                }
                final net.minecraft.nbt.NBTBase value2 = this.getTagMap().get(key);
                if (value2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagIntArray");
                }
                o = ((NBTTagIntArray)value2).getIntArray();
                break;
            }
            case 10: {
                o = this.getBoolean(key);
                break;
            }
            case 11: {
                o = this.getCompoundTag(key);
                break;
            }
            case 12: {
                if (tagType == null) {
                    throw new IllegalArgumentException("For accessing a tag list you need to provide the tagType argument");
                }
                o = this.getTagList(key, tagType);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return o;
    }
    
    @Nullable
    public final NBTBase get(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.getTag(key);
    }
    
    @NotNull
    public final NBTTagCompound setNBTBase(@NotNull final String key, @NotNull final NBTBase value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        return this.setNBTBase(key, value.getRawNBT());
    }
    
    @NotNull
    public final NBTTagCompound setNBTBase(@NotNull final String key, @NotNull final net.minecraft.nbt.NBTBase value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final NBTTagCompound $this$setNBTBase_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setNBTBase_u24lambda_u2d1.getRawNBT().setTag(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setByte(@NotNull final String key, final byte value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setByte_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setByte_u24lambda_u2d2.getRawNBT().setByte(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setShort(@NotNull final String key, final short value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setShort_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setShort_u24lambda_u2d3.getRawNBT().setShort(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setInteger(@NotNull final String key, final int value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setInteger_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setInteger_u24lambda_u2d4.getRawNBT().setInteger(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setLong(@NotNull final String key, final long value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setLong_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setLong_u24lambda_u2d5.getRawNBT().setLong(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setFloat(@NotNull final String key, final float value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setFloat_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setFloat_u24lambda_u2d6.getRawNBT().setFloat(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setDouble(@NotNull final String key, final double value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setDouble_u24lambda_u2d7 = this;
        final int n = 0;
        $this$setDouble_u24lambda_u2d7.getRawNBT().setDouble(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setString(@NotNull final String key, @NotNull final String value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final NBTTagCompound $this$setString_u24lambda_u2d8 = this;
        final int n = 0;
        $this$setString_u24lambda_u2d8.getRawNBT().setString(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setByteArray(@NotNull final String key, @NotNull final byte[] value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final NBTTagCompound $this$setByteArray_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setByteArray_u24lambda_u2d9.getRawNBT().setByteArray(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setIntArray(@NotNull final String key, @NotNull final int[] value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final NBTTagCompound $this$setIntArray_u24lambda_u2d10 = this;
        final int n = 0;
        $this$setIntArray_u24lambda_u2d10.getRawNBT().setIntArray(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound setBoolean(@NotNull final String key, final boolean value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$setBoolean_u24lambda_u2d11 = this;
        final int n = 0;
        $this$setBoolean_u24lambda_u2d11.getRawNBT().setBoolean(key, value);
        return this;
    }
    
    @NotNull
    public final NBTTagCompound set(@NotNull final String key, @NotNull final Object value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        final NBTTagCompound $this$set_u24lambda_u2d12 = this;
        final int n = 0;
        if (value instanceof NBTBase) {
            $this$set_u24lambda_u2d12.setNBTBase(key, (NBTBase)value);
        }
        else if (value instanceof net.minecraft.nbt.NBTBase) {
            $this$set_u24lambda_u2d12.setNBTBase(key, (net.minecraft.nbt.NBTBase)value);
        }
        else if (value instanceof Byte) {
            $this$set_u24lambda_u2d12.setByte(key, ((Number)value).byteValue());
        }
        else if (value instanceof Short) {
            $this$set_u24lambda_u2d12.setShort(key, ((Number)value).shortValue());
        }
        else if (value instanceof Integer) {
            $this$set_u24lambda_u2d12.setInteger(key, ((Number)value).intValue());
        }
        else if (value instanceof Long) {
            $this$set_u24lambda_u2d12.setLong(key, ((Number)value).longValue());
        }
        else if (value instanceof Float) {
            $this$set_u24lambda_u2d12.setFloat(key, ((Number)value).floatValue());
        }
        else if (value instanceof Double) {
            $this$set_u24lambda_u2d12.setDouble(key, ((Number)value).doubleValue());
        }
        else if (value instanceof String) {
            $this$set_u24lambda_u2d12.setString(key, (String)value);
        }
        else if (value instanceof byte[]) {
            $this$set_u24lambda_u2d12.setByteArray(key, (byte[])value);
        }
        else if (value instanceof int[]) {
            $this$set_u24lambda_u2d12.setIntArray(key, (int[])value);
        }
        else {
            if (!(value instanceof Boolean)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported NBT type: ", (Object)value.getClass().getSimpleName()));
            }
            $this$set_u24lambda_u2d12.setBoolean(key, (boolean)value);
        }
        return this;
    }
    
    @NotNull
    public final NBTTagCompound removeTag(@NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final NBTTagCompound $this$removeTag_u24lambda_u2d13 = this;
        final int n = 0;
        $this$removeTag_u24lambda_u2d13.getRawNBT().removeTag(key);
        return this;
    }
    
    @NotNull
    public final NativeObject toObject() {
        return NBTBase.Companion.toObject(this.getRawNBT());
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/nbt/NBTTagCompound$NBTDataType;", "", "(Ljava/lang/String;I)V", "BYTE", "SHORT", "INTEGER", "LONG", "FLOAT", "DOUBLE", "STRING", "BYTE_ARRAY", "INT_ARRAY", "BOOLEAN", "COMPOUND_TAG", "TAG_LIST", "ctjs" })
    public enum NBTDataType
    {
        BYTE, 
        SHORT, 
        INTEGER, 
        LONG, 
        FLOAT, 
        DOUBLE, 
        STRING, 
        BYTE_ARRAY, 
        INT_ARRAY, 
        BOOLEAN, 
        COMPOUND_TAG, 
        TAG_LIST;
        
        private static final /* synthetic */ NBTDataType[] $values() {
            return new NBTDataType[] { NBTDataType.BYTE, NBTDataType.SHORT, NBTDataType.INTEGER, NBTDataType.LONG, NBTDataType.FLOAT, NBTDataType.DOUBLE, NBTDataType.STRING, NBTDataType.BYTE_ARRAY, NBTDataType.INT_ARRAY, NBTDataType.BOOLEAN, NBTDataType.COMPOUND_TAG, NBTDataType.TAG_LIST };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
