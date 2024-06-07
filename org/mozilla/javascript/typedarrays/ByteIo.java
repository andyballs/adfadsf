//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

public class ByteIo
{
    public static Object readInt8(final byte[] buf, final int offset) {
        return buf[offset];
    }
    
    public static void writeInt8(final byte[] buf, final int offset, final int val) {
        buf[offset] = (byte)val;
    }
    
    public static Object readUint8(final byte[] buf, final int offset) {
        return buf[offset] & 0xFF;
    }
    
    public static void writeUint8(final byte[] buf, final int offset, final int val) {
        buf[offset] = (byte)(val & 0xFF);
    }
    
    private static short doReadInt16(final byte[] buf, final int offset, final boolean littleEndian) {
        if (littleEndian) {
            return (short)((buf[offset] & 0xFF) | (buf[offset + 1] & 0xFF) << 8);
        }
        return (short)((buf[offset] & 0xFF) << 8 | (buf[offset + 1] & 0xFF));
    }
    
    private static void doWriteInt16(final byte[] buf, final int offset, final int val, final boolean littleEndian) {
        if (littleEndian) {
            buf[offset] = (byte)(val & 0xFF);
            buf[offset + 1] = (byte)(val >>> 8 & 0xFF);
        }
        else {
            buf[offset] = (byte)(val >>> 8 & 0xFF);
            buf[offset + 1] = (byte)(val & 0xFF);
        }
    }
    
    public static Object readInt16(final byte[] buf, final int offset, final boolean littleEndian) {
        return doReadInt16(buf, offset, littleEndian);
    }
    
    public static void writeInt16(final byte[] buf, final int offset, final int val, final boolean littleEndian) {
        doWriteInt16(buf, offset, val, littleEndian);
    }
    
    public static Object readUint16(final byte[] buf, final int offset, final boolean littleEndian) {
        return doReadInt16(buf, offset, littleEndian) & 0xFFFF;
    }
    
    public static void writeUint16(final byte[] buf, final int offset, final int val, final boolean littleEndian) {
        doWriteInt16(buf, offset, val & 0xFFFF, littleEndian);
    }
    
    public static Object readInt32(final byte[] buf, final int offset, final boolean littleEndian) {
        if (littleEndian) {
            return (buf[offset] & 0xFF) | (buf[offset + 1] & 0xFF) << 8 | (buf[offset + 2] & 0xFF) << 16 | (buf[offset + 3] & 0xFF) << 24;
        }
        return (buf[offset] & 0xFF) << 24 | (buf[offset + 1] & 0xFF) << 16 | (buf[offset + 2] & 0xFF) << 8 | (buf[offset + 3] & 0xFF);
    }
    
    public static void writeInt32(final byte[] buf, final int offset, final int val, final boolean littleEndian) {
        if (littleEndian) {
            buf[offset] = (byte)(val & 0xFF);
            buf[offset + 1] = (byte)(val >>> 8 & 0xFF);
            buf[offset + 2] = (byte)(val >>> 16 & 0xFF);
            buf[offset + 3] = (byte)(val >>> 24 & 0xFF);
        }
        else {
            buf[offset] = (byte)(val >>> 24 & 0xFF);
            buf[offset + 1] = (byte)(val >>> 16 & 0xFF);
            buf[offset + 2] = (byte)(val >>> 8 & 0xFF);
            buf[offset + 3] = (byte)(val & 0xFF);
        }
    }
    
    public static long readUint32Primitive(final byte[] buf, final int offset, final boolean littleEndian) {
        if (littleEndian) {
            return (((long)buf[offset] & 0xFFL) | ((long)buf[offset + 1] & 0xFFL) << 8 | ((long)buf[offset + 2] & 0xFFL) << 16 | ((long)buf[offset + 3] & 0xFFL) << 24) & 0xFFFFFFFFL;
        }
        return (((long)buf[offset] & 0xFFL) << 24 | ((long)buf[offset + 1] & 0xFFL) << 16 | ((long)buf[offset + 2] & 0xFFL) << 8 | ((long)buf[offset + 3] & 0xFFL)) & 0xFFFFFFFFL;
    }
    
    public static void writeUint32(final byte[] buf, final int offset, final long val, final boolean littleEndian) {
        if (littleEndian) {
            buf[offset] = (byte)(val & 0xFFL);
            buf[offset + 1] = (byte)(val >>> 8 & 0xFFL);
            buf[offset + 2] = (byte)(val >>> 16 & 0xFFL);
            buf[offset + 3] = (byte)(val >>> 24 & 0xFFL);
        }
        else {
            buf[offset] = (byte)(val >>> 24 & 0xFFL);
            buf[offset + 1] = (byte)(val >>> 16 & 0xFFL);
            buf[offset + 2] = (byte)(val >>> 8 & 0xFFL);
            buf[offset + 3] = (byte)(val & 0xFFL);
        }
    }
    
    public static Object readUint32(final byte[] buf, final int offset, final boolean littleEndian) {
        return readUint32Primitive(buf, offset, littleEndian);
    }
    
    public static long readUint64Primitive(final byte[] buf, final int offset, final boolean littleEndian) {
        if (littleEndian) {
            return ((long)buf[offset] & 0xFFL) | ((long)buf[offset + 1] & 0xFFL) << 8 | ((long)buf[offset + 2] & 0xFFL) << 16 | ((long)buf[offset + 3] & 0xFFL) << 24 | ((long)buf[offset + 4] & 0xFFL) << 32 | ((long)buf[offset + 5] & 0xFFL) << 40 | ((long)buf[offset + 6] & 0xFFL) << 48 | ((long)buf[offset + 7] & 0xFFL) << 56;
        }
        return ((long)buf[offset] & 0xFFL) << 56 | ((long)buf[offset + 1] & 0xFFL) << 48 | ((long)buf[offset + 2] & 0xFFL) << 40 | ((long)buf[offset + 3] & 0xFFL) << 32 | ((long)buf[offset + 4] & 0xFFL) << 24 | ((long)buf[offset + 5] & 0xFFL) << 16 | ((long)buf[offset + 6] & 0xFFL) << 8 | ((long)buf[offset + 7] & 0xFFL) << 0;
    }
    
    public static void writeUint64(final byte[] buf, final int offset, final long val, final boolean littleEndian) {
        if (littleEndian) {
            buf[offset] = (byte)(val & 0xFFL);
            buf[offset + 1] = (byte)(val >>> 8 & 0xFFL);
            buf[offset + 2] = (byte)(val >>> 16 & 0xFFL);
            buf[offset + 3] = (byte)(val >>> 24 & 0xFFL);
            buf[offset + 4] = (byte)(val >>> 32 & 0xFFL);
            buf[offset + 5] = (byte)(val >>> 40 & 0xFFL);
            buf[offset + 6] = (byte)(val >>> 48 & 0xFFL);
            buf[offset + 7] = (byte)(val >>> 56 & 0xFFL);
        }
        else {
            buf[offset] = (byte)(val >>> 56 & 0xFFL);
            buf[offset + 1] = (byte)(val >>> 48 & 0xFFL);
            buf[offset + 2] = (byte)(val >>> 40 & 0xFFL);
            buf[offset + 3] = (byte)(val >>> 32 & 0xFFL);
            buf[offset + 4] = (byte)(val >>> 24 & 0xFFL);
            buf[offset + 5] = (byte)(val >>> 16 & 0xFFL);
            buf[offset + 6] = (byte)(val >>> 8 & 0xFFL);
            buf[offset + 7] = (byte)(val & 0xFFL);
        }
    }
    
    public static Object readFloat32(final byte[] buf, final int offset, final boolean littleEndian) {
        final long base = readUint32Primitive(buf, offset, littleEndian);
        return Float.intBitsToFloat((int)base);
    }
    
    public static void writeFloat32(final byte[] buf, final int offset, final double val, final boolean littleEndian) {
        final long base = Float.floatToIntBits((float)val);
        writeUint32(buf, offset, base, littleEndian);
    }
    
    public static Object readFloat64(final byte[] buf, final int offset, final boolean littleEndian) {
        final long base = readUint64Primitive(buf, offset, littleEndian);
        return Double.longBitsToDouble(base);
    }
    
    public static void writeFloat64(final byte[] buf, final int offset, final double val, final boolean littleEndian) {
        final long base = Double.doubleToLongBits(val);
        writeUint64(buf, offset, base, littleEndian);
    }
}
