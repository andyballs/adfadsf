//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.math.*;

class DToA
{
    static final int DTOSTR_STANDARD = 0;
    static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    static final int DTOSTR_FIXED = 2;
    static final int DTOSTR_EXPONENTIAL = 3;
    static final int DTOSTR_PRECISION = 4;
    private static final int Frac_mask = 1048575;
    private static final int Exp_shift = 20;
    private static final int Exp_msk1 = 1048576;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Exp_shiftL = 52;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Bias = 1023;
    private static final int P = 53;
    private static final int Exp_shift1 = 20;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Bndry_mask = 1048575;
    private static final int Log2P = 1;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Exp_11 = 1072693248;
    private static final int Ten_pmax = 22;
    private static final int Quick_max = 14;
    private static final int Bletch = 16;
    private static final int Frac_mask1 = 1048575;
    private static final int Int_max = 14;
    private static final int n_bigtens = 5;
    private static final double[] tens;
    private static final double[] bigtens;
    private static final int[] dtoaModes;
    
    private static char BASEDIGIT(final int digit) {
        return (char)((digit >= 10) ? (87 + digit) : (48 + digit));
    }
    
    private static int lo0bits(final int y) {
        int x = y;
        if ((x & 0x7) == 0x0) {
            int k = 0;
            if ((x & 0xFFFF) == 0x0) {
                k = 16;
                x >>>= 16;
            }
            if ((x & 0xFF) == 0x0) {
                k += 8;
                x >>>= 8;
            }
            if ((x & 0xF) == 0x0) {
                k += 4;
                x >>>= 4;
            }
            if ((x & 0x3) == 0x0) {
                k += 2;
                x >>>= 2;
            }
            if ((x & 0x1) == 0x0) {
                ++k;
                x >>>= 1;
                if ((x & 0x1) == 0x0) {
                    return 32;
                }
            }
            return k;
        }
        if ((x & 0x1) != 0x0) {
            return 0;
        }
        if ((x & 0x2) != 0x0) {
            return 1;
        }
        return 2;
    }
    
    private static int hi0bits(int x) {
        int k = 0;
        if ((x & 0xFFFF0000) == 0x0) {
            k = 16;
            x <<= 16;
        }
        if ((x & 0xFF000000) == 0x0) {
            k += 8;
            x <<= 8;
        }
        if ((x & 0xF0000000) == 0x0) {
            k += 4;
            x <<= 4;
        }
        if ((x & 0xC0000000) == 0x0) {
            k += 2;
            x <<= 2;
        }
        if ((x & Integer.MIN_VALUE) == 0x0) {
            ++k;
            if ((x & 0x40000000) == 0x0) {
                return 32;
            }
        }
        return k;
    }
    
    private static void stuffBits(final byte[] bits, final int offset, final int val) {
        bits[offset] = (byte)(val >> 24);
        bits[offset + 1] = (byte)(val >> 16);
        bits[offset + 2] = (byte)(val >> 8);
        bits[offset + 3] = (byte)val;
    }
    
    private static BigInteger d2b(final double d, final int[] e, final int[] bits) {
        final long dBits = Double.doubleToLongBits(d);
        int d2 = (int)(dBits >>> 32);
        final int d3 = (int)dBits;
        int z = d2 & 0xFFFFF;
        d2 &= Integer.MAX_VALUE;
        final int de;
        if ((de = d2 >>> 20) != 0) {
            z |= 0x100000;
        }
        int y;
        byte[] dbl_bits;
        int k;
        int i;
        if ((y = d3) != 0) {
            dbl_bits = new byte[8];
            k = lo0bits(y);
            y >>>= k;
            if (k != 0) {
                stuffBits(dbl_bits, 4, y | z << 32 - k);
                z >>= k;
            }
            else {
                stuffBits(dbl_bits, 4, y);
            }
            stuffBits(dbl_bits, 0, z);
            i = ((z != 0) ? 2 : 1);
        }
        else {
            dbl_bits = new byte[4];
            k = lo0bits(z);
            z >>>= k;
            stuffBits(dbl_bits, 0, z);
            k += 32;
            i = 1;
        }
        if (de != 0) {
            e[0] = de - 1023 - 52 + k;
            bits[0] = 53 - k;
        }
        else {
            e[0] = de - 1023 - 52 + 1 + k;
            bits[0] = 32 * i - hi0bits(z);
        }
        return new BigInteger(dbl_bits);
    }
    
    static String JS_dtobasestr(final int base, double d) {
        if (2 > base || base > 36) {
            throw new IllegalArgumentException("Bad base: " + base);
        }
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (Double.isInfinite(d)) {
            return (d > 0.0) ? "Infinity" : "-Infinity";
        }
        if (d == 0.0) {
            return "0";
        }
        boolean negative;
        if (d >= 0.0) {
            negative = false;
        }
        else {
            negative = true;
            d = -d;
        }
        final double dfloor = Math.floor(d);
        final long lfloor = (long)dfloor;
        String intDigits;
        if (lfloor == dfloor) {
            intDigits = Long.toString(negative ? (-lfloor) : lfloor, base);
        }
        else {
            final long floorBits = Double.doubleToLongBits(dfloor);
            int exp = (int)(floorBits >> 52) & 0x7FF;
            long mantissa;
            if (exp == 0) {
                mantissa = (floorBits & 0xFFFFFFFFFFFFFL) << 1;
            }
            else {
                mantissa = ((floorBits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L);
            }
            if (negative) {
                mantissa = -mantissa;
            }
            exp -= 1075;
            BigInteger x = BigInteger.valueOf(mantissa);
            if (exp > 0) {
                x = x.shiftLeft(exp);
            }
            else if (exp < 0) {
                x = x.shiftRight(-exp);
            }
            intDigits = x.toString(base);
        }
        if (d == dfloor) {
            return intDigits;
        }
        final StringBuilder buffer = new StringBuilder();
        buffer.append(intDigits).append('.');
        final double df = d - dfloor;
        final long dBits = Double.doubleToLongBits(d);
        final int word0 = (int)(dBits >> 32);
        final int word2 = (int)dBits;
        final int[] e = { 0 };
        final int[] bbits = { 0 };
        BigInteger b = d2b(df, e, bbits);
        int s2 = -(word0 >>> 20 & 0x7FF);
        if (s2 == 0) {
            s2 = -1;
        }
        s2 += 1076;
        BigInteger mhi;
        BigInteger mlo = mhi = BigInteger.valueOf(1L);
        if (word2 == 0 && (word0 & 0xFFFFF) == 0x0 && (word0 & 0x7FE00000) != 0x0) {
            ++s2;
            mhi = BigInteger.valueOf(2L);
        }
        b = b.shiftLeft(e[0] + s2);
        BigInteger s3 = BigInteger.valueOf(1L);
        s3 = s3.shiftLeft(s2);
        final BigInteger bigBase = BigInteger.valueOf(base);
        boolean done = false;
        do {
            b = b.multiply(bigBase);
            final BigInteger[] divResult = b.divideAndRemainder(s3);
            b = divResult[1];
            int digit = (char)divResult[0].intValue();
            if (mlo == mhi) {
                mhi = (mlo = mlo.multiply(bigBase));
            }
            else {
                mlo = mlo.multiply(bigBase);
                mhi = mhi.multiply(bigBase);
            }
            final int j = b.compareTo(mlo);
            final BigInteger delta = s3.subtract(mhi);
            int j2 = (delta.signum() <= 0) ? 1 : b.compareTo(delta);
            if (j2 == 0 && (word2 & 0x1) == 0x0) {
                if (j > 0) {
                    ++digit;
                }
                done = true;
            }
            else if (j < 0 || (j == 0 && (word2 & 0x1) == 0x0)) {
                if (j2 > 0) {
                    b = b.shiftLeft(1);
                    j2 = b.compareTo(s3);
                    if (j2 > 0) {
                        ++digit;
                    }
                }
                done = true;
            }
            else if (j2 > 0) {
                ++digit;
                done = true;
            }
            buffer.append(BASEDIGIT(digit));
        } while (!done);
        return buffer.toString();
    }
    
    static int word0(final double d) {
        final long dBits = Double.doubleToLongBits(d);
        return (int)(dBits >> 32);
    }
    
    static double setWord0(final double d, final int i) {
        long dBits = Double.doubleToLongBits(d);
        dBits = ((long)i << 32 | (dBits & 0xFFFFFFFFL));
        return Double.longBitsToDouble(dBits);
    }
    
    static int word1(final double d) {
        final long dBits = Double.doubleToLongBits(d);
        return (int)dBits;
    }
    
    static BigInteger pow5mult(final BigInteger b, final int k) {
        return b.multiply(BigInteger.valueOf(5L).pow(k));
    }
    
    static boolean roundOff(final StringBuilder buf) {
        int i = buf.length();
        while (i != 0) {
            --i;
            final char c = buf.charAt(i);
            if (c != '9') {
                buf.setCharAt(i, (char)(c + '\u0001'));
                buf.setLength(i + 1);
                return false;
            }
        }
        buf.setLength(0);
        return true;
    }
    
    static int JS_dtoa(double d, int mode, final boolean biasUp, int ndigits, final boolean[] sign, final StringBuilder buf) {
        final int[] be = { 0 };
        final int[] bbits = { 0 };
        if ((word0(d) & Integer.MIN_VALUE) != 0x0) {
            sign[0] = true;
            d = setWord0(d, word0(d) & Integer.MAX_VALUE);
        }
        else {
            sign[0] = false;
        }
        if ((word0(d) & 0x7FF00000) == 0x7FF00000) {
            buf.append((word1(d) == 0 && (word0(d) & 0xFFFFF) == 0x0) ? "Infinity" : "NaN");
            return 9999;
        }
        if (d == 0.0) {
            buf.setLength(0);
            buf.append('0');
            return 1;
        }
        BigInteger b = d2b(d, be, bbits);
        int i;
        double d2;
        boolean denorm;
        if ((i = (word0(d) >>> 20 & 0x7FF)) != 0) {
            d2 = setWord0(d, (word0(d) & 0xFFFFF) | 0x3FF00000);
            i -= 1023;
            denorm = false;
        }
        else {
            i = bbits[0] + be[0] + 1074;
            final long x = (i > 32) ? ((long)word0(d) << 64 - i | (long)(word1(d) >>> i - 32)) : ((long)word1(d) << 32 - i);
            d2 = setWord0((double)x, word0((double)x) - 32505856);
            i -= 1075;
            denorm = true;
        }
        double ds = (d2 - 1.5) * 0.289529654602168 + 0.1760912590558 + i * 0.301029995663981;
        int k = (int)ds;
        if (ds < 0.0 && ds != k) {
            --k;
        }
        boolean k_check = true;
        if (k >= 0 && k <= 22) {
            if (d < DToA.tens[k]) {
                --k;
            }
            k_check = false;
        }
        int j = bbits[0] - i - 1;
        int b2;
        int s2;
        if (j >= 0) {
            b2 = 0;
            s2 = j;
        }
        else {
            b2 = -j;
            s2 = 0;
        }
        int b3;
        int s3;
        if (k >= 0) {
            b3 = 0;
            s3 = k;
            s2 += k;
        }
        else {
            b2 -= k;
            b3 = -k;
            s3 = 0;
        }
        if (mode < 0 || mode > 9) {
            mode = 0;
        }
        boolean try_quick = true;
        if (mode > 5) {
            mode -= 4;
            try_quick = false;
        }
        boolean leftright = true;
        int ilim2;
        int ilim1 = ilim2 = 0;
        switch (mode) {
            case 0:
            case 1: {
                ilim1 = (ilim2 = -1);
                i = 18;
                ndigits = 0;
                break;
            }
            case 2: {
                leftright = false;
            }
            case 4: {
                if (ndigits <= 0) {
                    ndigits = 1;
                }
                ilim1 = (ilim2 = (i = ndigits));
                break;
            }
            case 3: {
                leftright = false;
            }
            case 5: {
                i = (ilim2 = ndigits + k + 1);
                ilim1 = i - 1;
                if (i <= 0) {
                    i = 1;
                    break;
                }
                break;
            }
        }
        boolean fast_failed = false;
        if (ilim2 >= 0 && ilim2 <= 14 && try_quick) {
            i = 0;
            d2 = d;
            final int k2 = k;
            final int ilim3 = ilim2;
            int ieps = 2;
            if (k > 0) {
                ds = DToA.tens[k & 0xF];
                j = k >> 4;
                if ((j & 0x10) != 0x0) {
                    j &= 0xF;
                    d /= DToA.bigtens[4];
                    ++ieps;
                }
                while (j != 0) {
                    if ((j & 0x1) != 0x0) {
                        ++ieps;
                        ds *= DToA.bigtens[i];
                    }
                    j >>= 1;
                    ++i;
                }
                d /= ds;
            }
            else {
                final int j2;
                if ((j2 = -k) != 0) {
                    d *= DToA.tens[j2 & 0xF];
                    for (j = j2 >> 4; j != 0; j >>= 1, ++i) {
                        if ((j & 0x1) != 0x0) {
                            ++ieps;
                            d *= DToA.bigtens[i];
                        }
                    }
                }
            }
            if (k_check && d < 1.0 && ilim2 > 0) {
                if (ilim1 <= 0) {
                    fast_failed = true;
                }
                else {
                    ilim2 = ilim1;
                    --k;
                    d *= 10.0;
                    ++ieps;
                }
            }
            double eps = ieps * d + 7.0;
            eps = setWord0(eps, word0(eps) - 54525952);
            if (ilim2 == 0) {
                final BigInteger S;
                final BigInteger mhi = S = null;
                d -= 5.0;
                if (d > eps) {
                    buf.append('1');
                    return ++k + 1;
                }
                if (d < -eps) {
                    buf.setLength(0);
                    buf.append('0');
                    return 1;
                }
                fast_failed = true;
            }
            if (!fast_failed) {
                fast_failed = true;
                if (leftright) {
                    eps = 0.5 / DToA.tens[ilim2 - 1] - eps;
                    i = 0;
                    Block_41: {
                        while (true) {
                            final long L = (long)d;
                            d -= L;
                            buf.append((char)(48L + L));
                            if (d < eps) {
                                return k + 1;
                            }
                            if (1.0 - d < eps) {
                                break;
                            }
                            if (++i >= ilim2) {
                                break Block_41;
                            }
                            eps *= 10.0;
                            d *= 10.0;
                        }
                        while (true) {
                            do {
                                final char lastCh = buf.charAt(buf.length() - 1);
                                buf.setLength(buf.length() - 1);
                                if (lastCh != '9') {
                                    buf.append((char)(lastCh + '\u0001'));
                                    return k + 1;
                                }
                            } while (buf.length() != 0);
                            ++k;
                            final char lastCh = '0';
                            continue;
                        }
                    }
                }
                else {
                    eps *= DToA.tens[ilim2 - 1];
                    i = 1;
                    while (true) {
                        final long L = (long)d;
                        d -= L;
                        buf.append((char)(48L + L));
                        if (i == ilim2) {
                            break;
                        }
                        ++i;
                        d *= 10.0;
                    }
                    if (d > 0.5 + eps) {
                        while (true) {
                            do {
                                final char lastCh = buf.charAt(buf.length() - 1);
                                buf.setLength(buf.length() - 1);
                                if (lastCh != '9') {
                                    buf.append((char)(lastCh + '\u0001'));
                                    return k + 1;
                                }
                            } while (buf.length() != 0);
                            ++k;
                            final char lastCh = '0';
                            continue;
                        }
                    }
                    if (d < 0.5 - eps) {
                        stripTrailingZeroes(buf);
                        return k + 1;
                    }
                }
            }
            if (fast_failed) {
                buf.setLength(0);
                d = d2;
                k = k2;
                ilim2 = ilim3;
            }
        }
        if (be[0] >= 0 && k <= 14) {
            ds = DToA.tens[k];
            if (ndigits >= 0 || ilim2 > 0) {
                i = 1;
            Label_1503:
                while (true) {
                    final long L = (long)(d / ds);
                    d -= L * ds;
                    buf.append((char)(48L + L));
                    if (i == ilim2) {
                        d += d;
                        if (d > ds || (d == ds && ((L & 0x1L) != 0x0L || biasUp))) {
                            while (true) {
                                do {
                                    final char lastCh = buf.charAt(buf.length() - 1);
                                    buf.setLength(buf.length() - 1);
                                    if (lastCh != '9') {
                                        buf.append((char)(lastCh + '\u0001'));
                                        break Label_1503;
                                    }
                                } while (buf.length() != 0);
                                ++k;
                                final char lastCh = '0';
                                continue;
                            }
                        }
                        break;
                    }
                    else {
                        d *= 10.0;
                        if (d == 0.0) {
                            break;
                        }
                        ++i;
                    }
                }
                return k + 1;
            }
            final BigInteger S;
            final BigInteger mhi = S = null;
            if (ilim2 < 0 || d < 5.0 * ds || (!biasUp && d == 5.0 * ds)) {
                buf.setLength(0);
                buf.append('0');
                return 1;
            }
            buf.append('1');
            return ++k + 1;
        }
        else {
            int m2 = b2;
            int m3 = b3;
            BigInteger mhi;
            BigInteger mlo = mhi = null;
            if (leftright) {
                if (mode < 2) {
                    i = (denorm ? (be[0] + 1075) : (54 - bbits[0]));
                }
                else {
                    j = ilim2 - 1;
                    if (m3 >= j) {
                        m3 -= j;
                    }
                    else {
                        s3 += (j -= m3);
                        b3 += j;
                        m3 = 0;
                    }
                    if ((i = ilim2) < 0) {
                        m2 -= i;
                        i = 0;
                    }
                }
                b2 += i;
                s2 += i;
                mhi = BigInteger.valueOf(1L);
            }
            if (m2 > 0 && s2 > 0) {
                i = ((m2 < s2) ? m2 : s2);
                b2 -= i;
                m2 -= i;
                s2 -= i;
            }
            if (b3 > 0) {
                if (leftright) {
                    if (m3 > 0) {
                        mhi = pow5mult(mhi, m3);
                        final BigInteger b4 = b = mhi.multiply(b);
                    }
                    if ((j = b3 - m3) != 0) {
                        b = pow5mult(b, j);
                    }
                }
                else {
                    b = pow5mult(b, b3);
                }
            }
            BigInteger S = BigInteger.valueOf(1L);
            if (s3 > 0) {
                S = pow5mult(S, s3);
            }
            boolean spec_case = false;
            if (mode < 2 && word1(d) == 0 && (word0(d) & 0xFFFFF) == 0x0 && (word0(d) & 0x7FE00000) != 0x0) {
                ++b2;
                ++s2;
                spec_case = true;
            }
            final byte[] S_bytes = S.toByteArray();
            int S_hiWord = 0;
            for (int idx = 0; idx < 4; ++idx) {
                S_hiWord <<= 8;
                if (idx < S_bytes.length) {
                    S_hiWord |= (S_bytes[idx] & 0xFF);
                }
            }
            if ((i = (((s3 != 0) ? (32 - hi0bits(S_hiWord)) : 1) + s2 & 0x1F)) != 0) {
                i = 32 - i;
            }
            if (i > 4) {
                i -= 4;
                b2 += i;
                m2 += i;
                s2 += i;
            }
            else if (i < 4) {
                i += 28;
                b2 += i;
                m2 += i;
                s2 += i;
            }
            if (b2 > 0) {
                b = b.shiftLeft(b2);
            }
            if (s2 > 0) {
                S = S.shiftLeft(s2);
            }
            if (k_check && b.compareTo(S) < 0) {
                --k;
                b = b.multiply(BigInteger.valueOf(10L));
                if (leftright) {
                    mhi = mhi.multiply(BigInteger.valueOf(10L));
                }
                ilim2 = ilim1;
            }
            if (ilim2 > 0 || mode <= 2) {
                char dig;
                if (leftright) {
                    if (m2 > 0) {
                        mhi = mhi.shiftLeft(m2);
                    }
                    mlo = mhi;
                    if (spec_case) {
                        mhi = mlo;
                        mhi = mhi.shiftLeft(1);
                    }
                    i = 1;
                    while (true) {
                        final BigInteger[] divResult = b.divideAndRemainder(S);
                        b = divResult[1];
                        dig = (char)(divResult[0].intValue() + 48);
                        j = b.compareTo(mlo);
                        final BigInteger delta = S.subtract(mhi);
                        int j2 = (delta.signum() <= 0) ? 1 : b.compareTo(delta);
                        if (j2 == 0 && mode == 0 && (word1(d) & 0x1) == 0x0) {
                            if (dig == '9') {
                                buf.append('9');
                                if (roundOff(buf)) {
                                    ++k;
                                    buf.append('1');
                                }
                                return k + 1;
                            }
                            if (j > 0) {
                                ++dig;
                            }
                            buf.append(dig);
                            return k + 1;
                        }
                        else {
                            if (j < 0 || (j == 0 && mode == 0 && (word1(d) & 0x1) == 0x0)) {
                                if (j2 > 0) {
                                    b = b.shiftLeft(1);
                                    j2 = b.compareTo(S);
                                    if (j2 > 0 || (j2 == 0 && ((dig & '\u0001') == 0x1 || biasUp))) {
                                        final char c = dig;
                                        ++dig;
                                        if (c == '9') {
                                            buf.append('9');
                                            if (roundOff(buf)) {
                                                ++k;
                                                buf.append('1');
                                            }
                                            return k + 1;
                                        }
                                    }
                                }
                                buf.append(dig);
                                return k + 1;
                            }
                            if (j2 > 0) {
                                if (dig == '9') {
                                    buf.append('9');
                                    if (roundOff(buf)) {
                                        ++k;
                                        buf.append('1');
                                    }
                                    return k + 1;
                                }
                                buf.append((char)(dig + '\u0001'));
                                return k + 1;
                            }
                            else {
                                buf.append(dig);
                                if (i == ilim2) {
                                    break;
                                }
                                b = b.multiply(BigInteger.valueOf(10L));
                                if (mlo == mhi) {
                                    mhi = (mlo = mhi.multiply(BigInteger.valueOf(10L)));
                                }
                                else {
                                    mlo = mlo.multiply(BigInteger.valueOf(10L));
                                    mhi = mhi.multiply(BigInteger.valueOf(10L));
                                }
                                ++i;
                            }
                        }
                    }
                }
                else {
                    i = 1;
                    while (true) {
                        final BigInteger[] divResult = b.divideAndRemainder(S);
                        b = divResult[1];
                        dig = (char)(divResult[0].intValue() + 48);
                        buf.append(dig);
                        if (i >= ilim2) {
                            break;
                        }
                        b = b.multiply(BigInteger.valueOf(10L));
                        ++i;
                    }
                }
                b = b.shiftLeft(1);
                j = b.compareTo(S);
                if (j > 0 || (j == 0 && ((dig & '\u0001') == 0x1 || biasUp))) {
                    if (roundOff(buf)) {
                        ++k;
                        buf.append('1');
                        return k + 1;
                    }
                }
                else {
                    stripTrailingZeroes(buf);
                }
                return k + 1;
            }
            if (ilim2 < 0 || (i = b.compareTo(S = S.multiply(BigInteger.valueOf(5L)))) < 0 || (i == 0 && !biasUp)) {
                buf.setLength(0);
                buf.append('0');
                return 1;
            }
            buf.append('1');
            return ++k + 1;
        }
    }
    
    private static void stripTrailingZeroes(final StringBuilder buf) {
        int bl = buf.length();
        while (bl-- > 0 && buf.charAt(bl) == '0') {}
        buf.setLength(bl + 1);
    }
    
    static void JS_dtostr(final StringBuilder buffer, int mode, final int precision, final double d) {
        final boolean[] sign = { false };
        if (mode == 2 && (d >= 1.0E21 || d <= -1.0E21)) {
            mode = 0;
        }
        final int decPt = JS_dtoa(d, DToA.dtoaModes[mode], mode >= 2, precision, sign, buffer);
        int nDigits = buffer.length();
        if (decPt != 9999) {
            boolean exponentialNotation = false;
            int minNDigits = 0;
            switch (mode) {
                case 0: {
                    if (decPt < -5 || decPt > 21) {
                        exponentialNotation = true;
                        break;
                    }
                    minNDigits = decPt;
                    break;
                }
                case 2: {
                    if (precision >= 0) {
                        minNDigits = decPt + precision;
                        break;
                    }
                    minNDigits = decPt;
                    break;
                }
                case 3: {
                    minNDigits = precision;
                }
                case 1: {
                    exponentialNotation = true;
                    break;
                }
                case 4: {
                    minNDigits = precision;
                    if (decPt < -5 || decPt > precision) {
                        exponentialNotation = true;
                        break;
                    }
                    break;
                }
            }
            if (nDigits < minNDigits) {
                final int p = minNDigits;
                nDigits = minNDigits;
                do {
                    buffer.append('0');
                } while (buffer.length() != p);
            }
            if (exponentialNotation) {
                if (nDigits != 1) {
                    buffer.insert(1, '.');
                }
                buffer.append('e');
                if (decPt - 1 >= 0) {
                    buffer.append('+');
                }
                buffer.append(decPt - 1);
            }
            else if (decPt != nDigits) {
                if (decPt > 0) {
                    buffer.insert(decPt, '.');
                }
                else {
                    for (int i = 0; i < 1 - decPt; ++i) {
                        buffer.insert(0, '0');
                    }
                    buffer.insert(1, '.');
                }
            }
        }
        if (sign[0] && (word0(d) != Integer.MIN_VALUE || word1(d) != 0) && ((word0(d) & 0x7FF00000) != 0x7FF00000 || (word1(d) == 0 && (word0(d) & 0xFFFFF) == 0x0))) {
            buffer.insert(0, '-');
        }
    }
    
    static {
        tens = new double[] { 1.0, 10.0, 100.0, 1000.0, 10000.0, 100000.0, 1000000.0, 1.0E7, 1.0E8, 1.0E9, 1.0E10, 1.0E11, 1.0E12, 1.0E13, 1.0E14, 1.0E15, 1.0E16, 1.0E17, 1.0E18, 1.0E19, 1.0E20, 1.0E21, 1.0E22 };
        bigtens = new double[] { 1.0E16, 1.0E32, 1.0E64, 1.0E128, 1.0E256 };
        dtoaModes = new int[] { 0, 0, 3, 2, 2 };
    }
}
