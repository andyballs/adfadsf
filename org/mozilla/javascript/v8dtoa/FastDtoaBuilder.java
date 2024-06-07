//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.v8dtoa;

import java.util.*;

public class FastDtoaBuilder
{
    final char[] chars;
    int end;
    int point;
    boolean formatted;
    static final char[] digits;
    
    public FastDtoaBuilder() {
        this.chars = new char[25];
        this.end = 0;
        this.formatted = false;
    }
    
    void append(final char c) {
        this.chars[this.end++] = c;
    }
    
    void decreaseLast() {
        final char[] chars = this.chars;
        final int n = this.end - 1;
        --chars[n];
    }
    
    public void reset() {
        this.end = 0;
        this.formatted = false;
    }
    
    @Override
    public String toString() {
        return "[chars:" + new String(this.chars, 0, this.end) + ", point:" + this.point + "]";
    }
    
    public String format() {
        if (!this.formatted) {
            final int firstDigit = (this.chars[0] == '-') ? 1 : 0;
            final int decPoint = this.point - firstDigit;
            if (decPoint < -5 || decPoint > 21) {
                this.toExponentialFormat(firstDigit, decPoint);
            }
            else {
                this.toFixedFormat(firstDigit, decPoint);
            }
            this.formatted = true;
        }
        return new String(this.chars, 0, this.end);
    }
    
    private void toFixedFormat(final int firstDigit, final int decPoint) {
        if (this.point < this.end) {
            if (decPoint > 0) {
                System.arraycopy(this.chars, this.point, this.chars, this.point + 1, this.end - this.point);
                this.chars[this.point] = '.';
                ++this.end;
            }
            else {
                final int target = firstDigit + 2 - decPoint;
                System.arraycopy(this.chars, firstDigit, this.chars, target, this.end - firstDigit);
                this.chars[firstDigit] = '0';
                this.chars[firstDigit + 1] = '.';
                if (decPoint < 0) {
                    Arrays.fill(this.chars, firstDigit + 2, target, '0');
                }
                this.end += 2 - decPoint;
            }
        }
        else if (this.point > this.end) {
            Arrays.fill(this.chars, this.end, this.point, '0');
            this.end += this.point - this.end;
        }
    }
    
    private void toExponentialFormat(final int firstDigit, final int decPoint) {
        if (this.end - firstDigit > 1) {
            final int dot = firstDigit + 1;
            System.arraycopy(this.chars, dot, this.chars, dot + 1, this.end - dot);
            this.chars[dot] = '.';
            ++this.end;
        }
        this.chars[this.end++] = 'e';
        char sign = '+';
        int exp = decPoint - 1;
        if (exp < 0) {
            sign = '-';
            exp = -exp;
        }
        this.chars[this.end++] = sign;
        int charPos = (exp > 99) ? (this.end + 2) : ((exp > 9) ? (this.end + 1) : this.end);
        this.end = charPos + 1;
        do {
            final int r = exp % 10;
            this.chars[charPos--] = FastDtoaBuilder.digits[r];
            exp /= 10;
        } while (exp != 0);
    }
    
    static {
        digits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    }
}
