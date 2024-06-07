//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.v8dtoa;

public class DoubleHelper
{
    static final long kSignMask = Long.MIN_VALUE;
    static final long kExponentMask = 9218868437227405312L;
    static final long kSignificandMask = 4503599627370495L;
    static final long kHiddenBit = 4503599627370496L;
    private static final int kSignificandSize = 52;
    private static final int kExponentBias = 1075;
    private static final int kDenormalExponent = -1074;
    
    static DiyFp asDiyFp(final long d64) {
        assert !isSpecial(d64);
        return new DiyFp(significand(d64), exponent(d64));
    }
    
    static DiyFp asNormalizedDiyFp(final long d64) {
        long f = significand(d64);
        int e = exponent(d64);
        assert f != 0L;
        while ((f & 0x10000000000000L) == 0x0L) {
            f <<= 1;
            --e;
        }
        f <<= 11;
        e -= 11;
        return new DiyFp(f, e);
    }
    
    static int exponent(final long d64) {
        if (isDenormal(d64)) {
            return -1074;
        }
        final int biased_e = (int)((d64 & 0x7FF0000000000000L) >>> 52 & 0xFFFFFFFFL);
        return biased_e - 1075;
    }
    
    static long significand(final long d64) {
        final long significand = d64 & 0xFFFFFFFFFFFFFL;
        if (!isDenormal(d64)) {
            return significand + 4503599627370496L;
        }
        return significand;
    }
    
    static boolean isDenormal(final long d64) {
        return (d64 & 0x7FF0000000000000L) == 0x0L;
    }
    
    static boolean isSpecial(final long d64) {
        return (d64 & 0x7FF0000000000000L) == 0x7FF0000000000000L;
    }
    
    static boolean isNan(final long d64) {
        return (d64 & 0x7FF0000000000000L) == 0x7FF0000000000000L && (d64 & 0xFFFFFFFFFFFFFL) != 0x0L;
    }
    
    static boolean isInfinite(final long d64) {
        return (d64 & 0x7FF0000000000000L) == 0x7FF0000000000000L && (d64 & 0xFFFFFFFFFFFFFL) == 0x0L;
    }
    
    static int sign(final long d64) {
        return ((d64 & Long.MIN_VALUE) == 0x0L) ? 1 : -1;
    }
    
    static void normalizedBoundaries(final long d64, final DiyFp m_minus, final DiyFp m_plus) {
        final DiyFp v = asDiyFp(d64);
        final boolean significand_is_zero = v.f() == 4503599627370496L;
        m_plus.setF((v.f() << 1) + 1L);
        m_plus.setE(v.e() - 1);
        m_plus.normalize();
        if (significand_is_zero && v.e() != -1074) {
            m_minus.setF((v.f() << 2) - 1L);
            m_minus.setE(v.e() - 2);
        }
        else {
            m_minus.setF((v.f() << 1) - 1L);
            m_minus.setE(v.e() - 1);
        }
        m_minus.setF(m_minus.f() << m_minus.e() - m_plus.e());
        m_minus.setE(m_plus.e());
    }
}
