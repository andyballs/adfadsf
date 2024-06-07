//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import java.math.*;
import java.util.*;

public final class BigDecimalParser
{
    private final char[] chars;
    
    BigDecimalParser(final char[] chars) {
        this.chars = chars;
    }
    
    public static BigDecimal parse(final String valueStr) {
        return parse(valueStr.toCharArray());
    }
    
    public static BigDecimal parse(char[] chars, final int off, final int len) {
        if (off > 0 || len != chars.length) {
            chars = Arrays.copyOfRange(chars, off, off + len);
        }
        return parse(chars);
    }
    
    public static BigDecimal parse(final char[] chars) {
        final int len = chars.length;
        try {
            if (len < 500) {
                return new BigDecimal(chars);
            }
            return new BigDecimalParser(chars).parseBigDecimal(len / 10);
        }
        catch (NumberFormatException e) {
            String desc = e.getMessage();
            if (desc == null) {
                desc = "Not a valid number representation";
            }
            throw new NumberFormatException("Value \"" + new String(chars) + "\" can not be represented as `java.math.BigDecimal`, reason: " + desc);
        }
    }
    
    private BigDecimal parseBigDecimal(final int splitLen) {
        boolean numHasSign = false;
        boolean expHasSign = false;
        boolean neg = false;
        int numIdx = 0;
        int expIdx = -1;
        int dotIdx = -1;
        int scale = 0;
        final int len = this.chars.length;
        for (int i = 0; i < len; ++i) {
            final char c = this.chars[i];
            switch (c) {
                case '+': {
                    if (expIdx >= 0) {
                        if (expHasSign) {
                            throw new NumberFormatException("Multiple signs in exponent");
                        }
                        expHasSign = true;
                        break;
                    }
                    else {
                        if (numHasSign) {
                            throw new NumberFormatException("Multiple signs in number");
                        }
                        numHasSign = true;
                        numIdx = i + 1;
                        break;
                    }
                    break;
                }
                case '-': {
                    if (expIdx >= 0) {
                        if (expHasSign) {
                            throw new NumberFormatException("Multiple signs in exponent");
                        }
                        expHasSign = true;
                        break;
                    }
                    else {
                        if (numHasSign) {
                            throw new NumberFormatException("Multiple signs in number");
                        }
                        numHasSign = true;
                        neg = true;
                        numIdx = i + 1;
                        break;
                    }
                    break;
                }
                case 'E':
                case 'e': {
                    if (expIdx >= 0) {
                        throw new NumberFormatException("Multiple exponent markers");
                    }
                    expIdx = i;
                    break;
                }
                case '.': {
                    if (dotIdx >= 0) {
                        throw new NumberFormatException("Multiple decimal points");
                    }
                    dotIdx = i;
                    break;
                }
                default: {
                    if (dotIdx >= 0 && expIdx == -1) {
                        ++scale;
                        break;
                    }
                    break;
                }
            }
        }
        int exp = 0;
        int numEndIdx;
        if (expIdx >= 0) {
            numEndIdx = expIdx;
            final String expStr = new String(this.chars, expIdx + 1, len - expIdx - 1);
            exp = Integer.parseInt(expStr);
            scale = this.adjustScale(scale, exp);
        }
        else {
            numEndIdx = len;
        }
        BigDecimal res;
        if (dotIdx >= 0) {
            final int leftLen = dotIdx - numIdx;
            final BigDecimal left = this.toBigDecimalRec(numIdx, leftLen, exp, splitLen);
            final int rightLen = numEndIdx - dotIdx - 1;
            final BigDecimal right = this.toBigDecimalRec(dotIdx + 1, rightLen, exp - rightLen, splitLen);
            res = left.add(right);
        }
        else {
            res = this.toBigDecimalRec(numIdx, numEndIdx - numIdx, exp, splitLen);
        }
        if (scale != 0) {
            res = res.setScale(scale);
        }
        if (neg) {
            res = res.negate();
        }
        return res;
    }
    
    private int adjustScale(final int scale, final long exp) {
        final long adjScale = scale - exp;
        if (adjScale > 2147483647L || adjScale < -2147483648L) {
            throw new NumberFormatException("Scale out of range: " + adjScale + " while adjusting scale " + scale + " to exponent " + exp);
        }
        return (int)adjScale;
    }
    
    private BigDecimal toBigDecimalRec(final int off, final int len, final int scale, final int splitLen) {
        if (len > splitLen) {
            final int mid = len / 2;
            final BigDecimal left = this.toBigDecimalRec(off, mid, scale + len - mid, splitLen);
            final BigDecimal right = this.toBigDecimalRec(off + mid, len - mid, scale, splitLen);
            return left.add(right);
        }
        return (len == 0) ? BigDecimal.ZERO : new BigDecimal(this.chars, off, len).movePointRight(scale);
    }
}
