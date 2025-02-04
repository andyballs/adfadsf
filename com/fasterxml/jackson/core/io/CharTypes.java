//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import java.util.*;

public final class CharTypes
{
    protected static final char[] HC;
    protected static final byte[] HB;
    protected static final int[] sInputCodes;
    protected static final int[] sInputCodesUTF8;
    protected static final int[] sInputCodesJsNames;
    protected static final int[] sInputCodesUtf8JsNames;
    protected static final int[] sInputCodesComment;
    protected static final int[] sInputCodesWS;
    protected static final int[] sOutputEscapes128;
    protected static final int[] sHexValues;
    
    public static int[] getInputCodeLatin1() {
        return CharTypes.sInputCodes;
    }
    
    public static int[] getInputCodeUtf8() {
        return CharTypes.sInputCodesUTF8;
    }
    
    public static int[] getInputCodeLatin1JsNames() {
        return CharTypes.sInputCodesJsNames;
    }
    
    public static int[] getInputCodeUtf8JsNames() {
        return CharTypes.sInputCodesUtf8JsNames;
    }
    
    public static int[] getInputCodeComment() {
        return CharTypes.sInputCodesComment;
    }
    
    public static int[] getInputCodeWS() {
        return CharTypes.sInputCodesWS;
    }
    
    public static int[] get7BitOutputEscapes() {
        return CharTypes.sOutputEscapes128;
    }
    
    public static int[] get7BitOutputEscapes(final int quoteChar) {
        if (quoteChar == 34) {
            return CharTypes.sOutputEscapes128;
        }
        return AltEscapes.instance.escapesFor(quoteChar);
    }
    
    public static int charToHex(final int ch) {
        return CharTypes.sHexValues[ch & 0xFF];
    }
    
    public static char hexToChar(final int ch) {
        return CharTypes.HC[ch];
    }
    
    public static void appendQuoted(final StringBuilder sb, final String content) {
        final int[] escCodes = CharTypes.sOutputEscapes128;
        final int escLen = escCodes.length;
        for (int i = 0, len = content.length(); i < len; ++i) {
            final char c = content.charAt(i);
            if (c >= escLen || escCodes[c] == 0) {
                sb.append(c);
            }
            else {
                sb.append('\\');
                final int escCode = escCodes[c];
                if (escCode < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    final int value = c;
                    sb.append(CharTypes.HC[value >> 4]);
                    sb.append(CharTypes.HC[value & 0xF]);
                }
                else {
                    sb.append((char)escCode);
                }
            }
        }
    }
    
    public static char[] copyHexChars() {
        return CharTypes.HC.clone();
    }
    
    public static byte[] copyHexBytes() {
        return CharTypes.HB.clone();
    }
    
    static {
        HC = "0123456789ABCDEF".toCharArray();
        final int len = CharTypes.HC.length;
        HB = new byte[len];
        for (int i = 0; i < len; ++i) {
            CharTypes.HB[i] = (byte)CharTypes.HC[i];
        }
        int[] table = new int[256];
        for (int i = 0; i < 32; ++i) {
            table[i] = -1;
        }
        table[92] = (table[34] = 1);
        sInputCodes = table;
        table = new int[CharTypes.sInputCodes.length];
        System.arraycopy(CharTypes.sInputCodes, 0, table, 0, table.length);
        for (int c = 128; c < 256; ++c) {
            int code;
            if ((c & 0xE0) == 0xC0) {
                code = 2;
            }
            else if ((c & 0xF0) == 0xE0) {
                code = 3;
            }
            else if ((c & 0xF8) == 0xF0) {
                code = 4;
            }
            else {
                code = -1;
            }
            table[c] = code;
        }
        sInputCodesUTF8 = table;
        table = new int[256];
        Arrays.fill(table, -1);
        for (int i = 33; i < 256; ++i) {
            if (Character.isJavaIdentifierPart((char)i)) {
                table[i] = 0;
            }
        }
        table[64] = 0;
        table[42] = (table[35] = 0);
        table[43] = (table[45] = 0);
        sInputCodesJsNames = table;
        table = new int[256];
        System.arraycopy(CharTypes.sInputCodesJsNames, 0, table, 0, table.length);
        Arrays.fill(table, 128, 128, 0);
        sInputCodesUtf8JsNames = table;
        int[] buf = new int[256];
        System.arraycopy(CharTypes.sInputCodesUTF8, 128, buf, 128, 128);
        Arrays.fill(buf, 0, 32, -1);
        buf[9] = 0;
        buf[10] = 10;
        buf[13] = 13;
        buf[42] = 42;
        sInputCodesComment = buf;
        buf = new int[256];
        System.arraycopy(CharTypes.sInputCodesUTF8, 128, buf, 128, 128);
        Arrays.fill(buf, 0, 32, -1);
        buf[9] = (buf[32] = 1);
        buf[10] = 10;
        buf[13] = 13;
        buf[47] = 47;
        buf[35] = 35;
        sInputCodesWS = buf;
        table = new int[128];
        for (int i = 0; i < 32; ++i) {
            table[i] = -1;
        }
        table[34] = 34;
        table[92] = 92;
        table[8] = 98;
        table[9] = 116;
        table[12] = 102;
        table[10] = 110;
        table[13] = 114;
        sOutputEscapes128 = table;
        Arrays.fill(sHexValues = new int[256], -1);
        for (int j = 0; j < 10; ++j) {
            CharTypes.sHexValues[48 + j] = j;
        }
        for (int j = 0; j < 6; ++j) {
            CharTypes.sHexValues[97 + j] = 10 + j;
            CharTypes.sHexValues[65 + j] = 10 + j;
        }
    }
    
    private static class AltEscapes
    {
        public static final AltEscapes instance;
        private int[][] _altEscapes;
        
        private AltEscapes() {
            this._altEscapes = new int[128][];
        }
        
        public int[] escapesFor(final int quoteChar) {
            int[] esc = this._altEscapes[quoteChar];
            if (esc == null) {
                esc = Arrays.copyOf(CharTypes.sOutputEscapes128, 128);
                if (esc[quoteChar] == 0) {
                    esc[quoteChar] = -1;
                }
                this._altEscapes[quoteChar] = esc;
            }
            return esc;
        }
        
        static {
            instance = new AltEscapes();
        }
    }
}
