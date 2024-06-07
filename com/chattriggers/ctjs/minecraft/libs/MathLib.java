//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.*;
import kotlin.ranges.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0007J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0007¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/MathLib;", "", "()V", "clamp", "", "number", "min", "max", "clampFloat", "", "map", "in_min", "in_max", "out_min", "out_max", "ctjs" })
public final class MathLib
{
    @NotNull
    public static final MathLib INSTANCE;
    
    private MathLib() {
    }
    
    @JvmStatic
    public static final float map(final float number, final float in_min, final float in_max, final float out_min, final float out_max) {
        return (number - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
    @JvmStatic
    public static final float clampFloat(final float number, final float min, final float max) {
        return RangesKt.coerceIn(number, min, max);
    }
    
    @JvmStatic
    public static final int clamp(final int number, final int min, final int max) {
        return RangesKt.coerceIn(number, min, max);
    }
    
    static {
        INSTANCE = new MathLib();
    }
}
