//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.v8dtoa;

public final class DoubleConversion
{
    private static final long kSignMask = Long.MIN_VALUE;
    private static final long kExponentMask = 9218868437227405312L;
    private static final long kSignificandMask = 4503599627370495L;
    private static final long kHiddenBit = 4503599627370496L;
    private static final int kPhysicalSignificandSize = 52;
    private static final int kSignificandSize = 53;
    private static final int kExponentBias = 1075;
    private static final int kDenormalExponent = -1074;
    
    private DoubleConversion() {
    }
    
    private static int exponent(final long d64) {
        if (isDenormal(d64)) {
            return -1074;
        }
        final int biased_e = (int)((d64 & 0x7FF0000000000000L) >> 52);
        return biased_e - 1075;
    }
    
    private static long significand(final long d64) {
        final long significand = d64 & 0xFFFFFFFFFFFFFL;
        if (!isDenormal(d64)) {
            return significand + 4503599627370496L;
        }
        return significand;
    }
    
    private static boolean isDenormal(final long d64) {
        return (d64 & 0x7FF0000000000000L) == 0x0L;
    }
    
    private static int sign(final long d64) {
        return ((d64 & Long.MIN_VALUE) == 0x0L) ? 1 : -1;
    }
    
    public static int doubleToInt32(final double x) {
        final int i = (int)x;
        if (i == x) {
            return i;
        }
        final long d64 = Double.doubleToLongBits(x);
        final int exponent = exponent(d64);
        if (exponent <= -53 || exponent > 31) {
            return 0;
        }
        final long s = significand(d64);
        return sign(d64) * (int)((exponent < 0) ? (s >> -exponent) : (s << exponent));
    }
}
