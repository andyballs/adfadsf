//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class Conversions
{
    public static int toInt8(final Object arg) {
        return (byte)ScriptRuntime.toInt32(arg);
    }
    
    public static int toUint8(final Object arg) {
        return ScriptRuntime.toInt32(arg) & 0xFF;
    }
    
    public static int toUint8Clamp(final Object arg) {
        final double d = ScriptRuntime.toNumber(arg);
        if (d <= 0.0) {
            return 0;
        }
        if (d >= 255.0) {
            return 255;
        }
        final double f = Math.floor(d);
        if (f + 0.5 < d) {
            return (int)(f + 1.0);
        }
        if (d < f + 0.5) {
            return (int)f;
        }
        if ((int)f % 2 != 0) {
            return (int)f + 1;
        }
        return (int)f;
    }
    
    public static int toInt16(final Object arg) {
        return (short)ScriptRuntime.toInt32(arg);
    }
    
    public static int toUint16(final Object arg) {
        return ScriptRuntime.toInt32(arg) & 0xFFFF;
    }
    
    public static int toInt32(final Object arg) {
        return ScriptRuntime.toInt32(arg);
    }
    
    public static long toUint32(final Object arg) {
        return ScriptRuntime.toUint32(arg);
    }
}
