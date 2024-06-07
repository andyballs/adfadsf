//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.v8dtoa;

class DiyFp
{
    private long f;
    private int e;
    static final int kSignificandSize = 64;
    static final long kUint64MSB = Long.MIN_VALUE;
    
    DiyFp() {
        this.f = 0L;
        this.e = 0;
    }
    
    DiyFp(final long f, final int e) {
        this.f = f;
        this.e = e;
    }
    
    private static boolean uint64_gte(final long a, final long b) {
        return a == b || (a > b ^ a < 0L ^ b < 0L);
    }
    
    void subtract(final DiyFp other) {
        assert this.e == other.e;
        assert uint64_gte(this.f, other.f);
        this.f -= other.f;
    }
    
    static DiyFp minus(final DiyFp a, final DiyFp b) {
        final DiyFp result = new DiyFp(a.f, a.e);
        result.subtract(b);
        return result;
    }
    
    void multiply(final DiyFp other) {
        final long kM32 = 4294967295L;
        final long a = this.f >>> 32;
        final long b = this.f & 0xFFFFFFFFL;
        final long c = other.f >>> 32;
        final long d = other.f & 0xFFFFFFFFL;
        final long ac = a * c;
        final long bc = b * c;
        final long ad = a * d;
        final long bd = b * d;
        long tmp = (bd >>> 32) + (ad & 0xFFFFFFFFL) + (bc & 0xFFFFFFFFL);
        tmp += 2147483648L;
        final long result_f = ac + (ad >>> 32) + (bc >>> 32) + (tmp >>> 32);
        this.e += other.e + 64;
        this.f = result_f;
    }
    
    static DiyFp times(final DiyFp a, final DiyFp b) {
        final DiyFp result = new DiyFp(a.f, a.e);
        result.multiply(b);
        return result;
    }
    
    void normalize() {
        assert this.f != 0L;
        long f = this.f;
        int e = this.e;
        final long k10MSBits = -18014398509481984L;
        while ((f & 0xFFC0000000000000L) == 0x0L) {
            f <<= 10;
            e -= 10;
        }
        while ((f & Long.MIN_VALUE) == 0x0L) {
            f <<= 1;
            --e;
        }
        this.f = f;
        this.e = e;
    }
    
    static DiyFp normalize(final DiyFp a) {
        final DiyFp result = new DiyFp(a.f, a.e);
        result.normalize();
        return result;
    }
    
    long f() {
        return this.f;
    }
    
    int e() {
        return this.e;
    }
    
    void setF(final long new_value) {
        this.f = new_value;
    }
    
    void setE(final int new_value) {
        this.e = new_value;
    }
    
    @Override
    public String toString() {
        return "[DiyFp f:" + this.f + ", e:" + this.e + "]";
    }
}
