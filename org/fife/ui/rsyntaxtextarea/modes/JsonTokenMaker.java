//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.modes;

import javax.swing.text.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.io.*;

public class JsonTokenMaker extends AbstractJFlexCTokenMaker
{
    public static final int YYEOF = -1;
    private static final int ZZ_BUFFERSIZE = 16384;
    public static final int EOL_COMMENT = 1;
    public static final int YYINITIAL = 0;
    private static final String ZZ_CMAP_PACKED = "\t\u0000\u0001\u0001\u0001\b\u0001\u0000\u0001\u0001\u0013\u0000\u0001\u0001\u0001\u0003\u0001\t\u0001\u0003\u0001\u0002\u0001\u0003\u0005\u0003\u0001\u0011\u0001\u0006\u0001\u0007\u0001\u000f\u0001\u000e\n\u0004\u0001\u001a\u0001\u0003\u0001\u0000\u0001\u0003\u0001\u0000\u0002\u0003\u0004\u0005\u0001\u0010\u0001\u0005\u0014\u0002\u0001\u001b\u0001\u000b\u0001\u001b\u0001\u0000\u0001\u0003\u0001\u0000\u0001\u0016\u0001\r\u0002\u0005\u0001\u0014\u0001\u0015\u0001\u0002\u0001\u001c\u0001\u001e\u0002\u0002\u0001\u0017\u0001\u0002\u0001\f\u0001\u0002\u0001\u001d\u0001\u0002\u0001\u0013\u0001\u0018\u0001\u0012\u0001\n\u0001\u0002\u0001\u001f\u0003\u0002\u0001\u0019\u0001\u0000\u0001\u0019\u0001\u0003\uff81\u0000";
    private static final char[] ZZ_CMAP;
    private static final int[] ZZ_ACTION;
    private static final String ZZ_ACTION_PACKED_0 = "\u0002\u0000\u0001\u0001\u0001\u0002\u0001\u0003\u0002\u0001\u0001\u0004\u0004\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0003\u0006\u0002\u0000\u0001\u0004\u0001\b\u0001\u0004\u0001\u0001\u0001\t\u0002\u0001\u0004\u0000\u0002\n\u0001\u0000\u0001\u000b\u0001\u0004\u0001\u0000\u0001\f\u0001\u0004\u0003\u0001\u0004\u0000\u0001\u0004\u0001\r\u0001\u000e\u0002\u0000\u0001\u000f\u0001\u0004\u0002\u0000\u0001\u0004";
    private static final int[] ZZ_ROWMAP;
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000 \u0000@\u0000`\u0000\u0080\u0000 \u0000\u00c0\u0000\u00e0\u0000\u0100\u0000\u0120\u0000\u0140\u0000\u0160\u0000 \u0000\u0180\u0000 \u0000\u01a0\u0000\u01c0\u0000\u01e0\u0000\u0200\u0000\u0220\u0000\u0240\u0000\u0260\u0000\u0280\u0000\u02a0\u0000 \u0000\u02c0\u0000\u02e0\u0000\u0300\u0000\u0320\u0000\u0340\u0000\u0360\u0000\u0380\u0000\u03a0\u0000\u03a0\u0000 \u0000\u03c0\u0000\u0260\u0000 \u0000\u03e0\u0000\u0400\u0000\u0420\u0000\u0440\u0000\u0460\u0000\u0480\u0000\u04a0\u0000\u04c0\u0000\u04e0\u0000@\u0000@\u0000\u0500\u0000\u0520\u0000\u0540\u0000\u0560\u0000\u0580\u0000\u0540\u0000\u05a0";
    private static final int[] ZZ_TRANS;
    private static final String ZZ_TRANS_PACKED_0 = "\u0001\u0003\u0001\u0004\u0002\u0003\u0001\u0005\u0001\u0003\u0001\u0006\u0001\u0007\u0001\u0003\u0001\b\u0002\u0003\u0001\t\u0001\u0003\u0001\n\u0003\u0003\u0001\u000b\u0002\u0003\u0001\f\u0003\u0003\u0001\r\u0001\u0006\u0001\r\u0004\u0003\b\u000e\u0001\u000f\f\u000e\u0001\u0010\u0006\u000e\u0001\u0011\u0002\u000e\u0001\u0012\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\n\u0003\u0003\u0000\u0004\u0003\u0001\u0000\u0001\u0004\"\u0000\u0001\u0005\n\u0000\u0001\u0013\u0001\u0014\u0003\u0000\u0001\u0014/\u0000\u0001\u0005\u001b\u0000\b\b\u0001\u0015\u0001\u0016\u0001\b\u0001\u0017\u0014\b\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0001\u0018\u0003\u0003\u0001\u0000\n\u0003\u0003\u0000\u0004\u0003\u000e\u0000\u0001\u0019\u0011\u0000\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0004\u0003\u0001\u001a\u0005\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0007\u0003\u0001\u001b\u0002\u0003\u0003\u0000\u0004\u0003\b\u000e\u0001\u0000\f\u000e\u0001\u0000\u0006\u000e\u0001\u0000\u0002\u000e\u0013\u0000\u0001\u001c\u000b\u0000\u0001\u001d\u0013\u0000\u0001\u001e,\u0000\u0001\u001f\u0004\u0000\u0001 \u001f\u0000\u0001!\u0002\u0000\u0001\"\t\u0000\u0001\"\u000e\u0000\t\u0015\u0001#\u0001\u0015\u0001$\u0014\u0015\u0001\u0000\u0001%\u0018\u0000\u0001&\u0005\u0000\b\u0015\u0001\u0000\u0001\b\u0001'\u0004\b\u0003\u0015\u0002\b\u0001\u0015\u0001\b\n\u0015\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\b\u0003\u0001(\u0001\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0001)\u0003\u0003\u0001\u0000\n\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\b\u0003\u0001*\u0001\u0003\u0003\u0000\u0004\u0003\u001d\u0000\u0001+\u0019\u0000\u0001,\u001a\u0000\u0001-,\u0000\u0001.\u0004\u0000\u0001 \u000b\u0000\u0001\u0014\u0003\u0000\u0001\u0014\u000f\u0000\u0001!\u001b\u0000\b\u0015\u0001\u0000\u001b\u0015\u0002/\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u0001/\u0002\u0015\u0001/\u0003\u0015\u0003/\t\u0015\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\b\u0003\u00010\u0001\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0005\u0003\u00011\u0004\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\t\u0003\u0001)\u0003\u0000\u0004\u0003\u001a\u0000\u00012\u0019\u0000\u0001+(\u0000\u00013\u0011\u0000\u00014\u0010\u0000\u0004\u0015\u00025\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u00015\u0002\u0015\u00015\u0003\u0015\u00035\t\u0015\u000e\u0000\u00016)\u0000\u0001+\u0001\u0000\u00012\u0007\u0000\u00014\u00017\u00024\u00027\u0002\u0000\u00014\u0001\u0000\u00034\u00017\u00014\u00017\u00074\u0001\u0000\u00027\u00044\u0004\u0015\u00028\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u00018\u0002\u0015\u00018\u0003\u0015\u00038\t\u0015\u000e\u0000\u00014\u0011\u0000\u0004\u0015\u0002\b\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u0001\b\u0002\u0015\u0001\b\u0003\u0015\u0003\b\t\u0015";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_ATTRIBUTE;
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0002\u0000\u0003\u0001\u0001\t\u0006\u0001\u0001\t\u0001\u0001\u0001\t\u0003\u0001\u0002\u0000\u0001\u0001\u0001\u0003\u0002\u0001\u0001\t\u0002\u0001\u0004\u0000\u0002\u0001\u0001\u0000\u0001\t\u0001\u0001\u0001\u0000\u0001\r\u0004\u0001\u0004\u0000\u0003\u0001\u0002\u0000\u0002\u0001\u0002\u0000\u0001\u0001";
    private Reader zzReader;
    private int zzState;
    private int zzLexicalState;
    private char[] zzBuffer;
    private int zzMarkedPos;
    private int zzPushbackPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private boolean zzAtEOF;
    private boolean highlightEolComments;
    
    private static int[] zzUnpackAction() {
        final int[] result = new int[56];
        int offset = 0;
        offset = zzUnpackAction("\u0002\u0000\u0001\u0001\u0001\u0002\u0001\u0003\u0002\u0001\u0001\u0004\u0004\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0003\u0006\u0002\u0000\u0001\u0004\u0001\b\u0001\u0004\u0001\u0001\u0001\t\u0002\u0001\u0004\u0000\u0002\n\u0001\u0000\u0001\u000b\u0001\u0004\u0001\u0000\u0001\f\u0001\u0004\u0003\u0001\u0004\u0000\u0001\u0004\u0001\r\u0001\u000e\u0002\u0000\u0001\u000f\u0001\u0004\u0002\u0000\u0001\u0004", offset, result);
        return result;
    }
    
    private static int zzUnpackAction(final String packed, final int offset, final int[] result) {
        int i = 0;
        int j = offset;
        final int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            final int value = packed.charAt(i++);
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }
    
    private static int[] zzUnpackRowMap() {
        final int[] result = new int[56];
        int offset = 0;
        offset = zzUnpackRowMap("\u0000\u0000\u0000 \u0000@\u0000`\u0000\u0080\u0000 \u0000\u00c0\u0000\u00e0\u0000\u0100\u0000\u0120\u0000\u0140\u0000\u0160\u0000 \u0000\u0180\u0000 \u0000\u01a0\u0000\u01c0\u0000\u01e0\u0000\u0200\u0000\u0220\u0000\u0240\u0000\u0260\u0000\u0280\u0000\u02a0\u0000 \u0000\u02c0\u0000\u02e0\u0000\u0300\u0000\u0320\u0000\u0340\u0000\u0360\u0000\u0380\u0000\u03a0\u0000\u03a0\u0000 \u0000\u03c0\u0000\u0260\u0000 \u0000\u03e0\u0000\u0400\u0000\u0420\u0000\u0440\u0000\u0460\u0000\u0480\u0000\u04a0\u0000\u04c0\u0000\u04e0\u0000@\u0000@\u0000\u0500\u0000\u0520\u0000\u0540\u0000\u0560\u0000\u0580\u0000\u0540\u0000\u05a0", offset, result);
        return result;
    }
    
    private static int zzUnpackRowMap(final String packed, final int offset, final int[] result) {
        int i = 0;
        int j = offset;
        int high;
        for (int l = packed.length(); i < l; high = packed.charAt(i++) << 16, result[j++] = (high | packed.charAt(i++))) {}
        return j;
    }
    
    private static int[] zzUnpackTrans() {
        final int[] result = new int[1472];
        int offset = 0;
        offset = zzUnpackTrans("\u0001\u0003\u0001\u0004\u0002\u0003\u0001\u0005\u0001\u0003\u0001\u0006\u0001\u0007\u0001\u0003\u0001\b\u0002\u0003\u0001\t\u0001\u0003\u0001\n\u0003\u0003\u0001\u000b\u0002\u0003\u0001\f\u0003\u0003\u0001\r\u0001\u0006\u0001\r\u0004\u0003\b\u000e\u0001\u000f\f\u000e\u0001\u0010\u0006\u000e\u0001\u0011\u0002\u000e\u0001\u0012\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\n\u0003\u0003\u0000\u0004\u0003\u0001\u0000\u0001\u0004\"\u0000\u0001\u0005\n\u0000\u0001\u0013\u0001\u0014\u0003\u0000\u0001\u0014/\u0000\u0001\u0005\u001b\u0000\b\b\u0001\u0015\u0001\u0016\u0001\b\u0001\u0017\u0014\b\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0001\u0018\u0003\u0003\u0001\u0000\n\u0003\u0003\u0000\u0004\u0003\u000e\u0000\u0001\u0019\u0011\u0000\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0004\u0003\u0001\u001a\u0005\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0007\u0003\u0001\u001b\u0002\u0003\u0003\u0000\u0004\u0003\b\u000e\u0001\u0000\f\u000e\u0001\u0000\u0006\u000e\u0001\u0000\u0002\u000e\u0013\u0000\u0001\u001c\u000b\u0000\u0001\u001d\u0013\u0000\u0001\u001e,\u0000\u0001\u001f\u0004\u0000\u0001 \u001f\u0000\u0001!\u0002\u0000\u0001\"\t\u0000\u0001\"\u000e\u0000\t\u0015\u0001#\u0001\u0015\u0001$\u0014\u0015\u0001\u0000\u0001%\u0018\u0000\u0001&\u0005\u0000\b\u0015\u0001\u0000\u0001\b\u0001'\u0004\b\u0003\u0015\u0002\b\u0001\u0015\u0001\b\n\u0015\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\b\u0003\u0001(\u0001\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0001)\u0003\u0003\u0001\u0000\n\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\b\u0003\u0001*\u0001\u0003\u0003\u0000\u0004\u0003\u001d\u0000\u0001+\u0019\u0000\u0001,\u001a\u0000\u0001-,\u0000\u0001.\u0004\u0000\u0001 \u000b\u0000\u0001\u0014\u0003\u0000\u0001\u0014\u000f\u0000\u0001!\u001b\u0000\b\u0015\u0001\u0000\u001b\u0015\u0002/\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u0001/\u0002\u0015\u0001/\u0003\u0015\u0003/\t\u0015\u0001\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\b\u0003\u00010\u0001\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0005\u0003\u00011\u0004\u0003\u0003\u0000\u0005\u0003\u0001\u0000\u0004\u0003\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0003\u0001\u0000\t\u0003\u0001)\u0003\u0000\u0004\u0003\u001a\u0000\u00012\u0019\u0000\u0001+(\u0000\u00013\u0011\u0000\u00014\u0010\u0000\u0004\u0015\u00025\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u00015\u0002\u0015\u00015\u0003\u0015\u00035\t\u0015\u000e\u0000\u00016)\u0000\u0001+\u0001\u0000\u00012\u0007\u0000\u00014\u00017\u00024\u00027\u0002\u0000\u00014\u0001\u0000\u00034\u00017\u00014\u00017\u00074\u0001\u0000\u00027\u00044\u0004\u0015\u00028\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u00018\u0002\u0015\u00018\u0003\u0015\u00038\t\u0015\u000e\u0000\u00014\u0011\u0000\u0004\u0015\u0002\b\u0003\u0015\u0001#\u0001\u0015\u0001$\u0001\u0015\u0001\b\u0002\u0015\u0001\b\u0003\u0015\u0003\b\t\u0015", offset, result);
        return result;
    }
    
    private static int zzUnpackTrans(final String packed, final int offset, final int[] result) {
        int i = 0;
        int j = offset;
        final int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            --value;
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }
    
    private static int[] zzUnpackAttribute() {
        final int[] result = new int[56];
        int offset = 0;
        offset = zzUnpackAttribute("\u0002\u0000\u0003\u0001\u0001\t\u0006\u0001\u0001\t\u0001\u0001\u0001\t\u0003\u0001\u0002\u0000\u0001\u0001\u0001\u0003\u0002\u0001\u0001\t\u0002\u0001\u0004\u0000\u0002\u0001\u0001\u0000\u0001\t\u0001\u0001\u0001\u0000\u0001\r\u0004\u0001\u0004\u0000\u0003\u0001\u0002\u0000\u0002\u0001\u0002\u0000\u0001\u0001", offset, result);
        return result;
    }
    
    private static int zzUnpackAttribute(final String packed, final int offset, final int[] result) {
        int i = 0;
        int j = offset;
        final int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            final int value = packed.charAt(i++);
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }
    
    public JsonTokenMaker() {
        this.zzLexicalState = 0;
        this.zzBuffer = new char[16384];
    }
    
    private void addHyperlinkToken(final int start, final int end, final int tokenType) {
        final int so = start + this.offsetShift;
        this.addToken(this.zzBuffer, start, end, tokenType, so, true);
    }
    
    private void addToken(final int tokenType) {
        this.addToken(this.zzStartRead, this.zzMarkedPos - 1, tokenType);
    }
    
    private void addToken(final int start, final int end, final int tokenType) {
        final int so = start + this.offsetShift;
        this.addToken(this.zzBuffer, start, end, tokenType, so, false);
    }
    
    public void addToken(final char[] array, final int start, final int end, final int tokenType, final int startOffset, final boolean hyperlink) {
        super.addToken(array, start, end, tokenType, startOffset, hyperlink);
        this.zzStartRead = this.zzMarkedPos;
    }
    
    public boolean getCurlyBracesDenoteCodeBlocks() {
        return true;
    }
    
    public boolean getMarkOccurrencesOfTokenType(final int type) {
        return false;
    }
    
    public boolean getShouldIndentNextLineAfter(final Token t) {
        if (t != null && t.length() == 1) {
            final char ch = t.charAt(0);
            return ch == '{' || ch == '[';
        }
        return false;
    }
    
    public Token getTokenList(final Segment text, final int initialTokenType, final int startOffset) {
        this.resetTokenList();
        this.offsetShift = -text.offset + startOffset;
        final int state = 0;
        this.start = text.offset;
        this.s = text;
        try {
            this.yyreset(this.zzReader);
            this.yybegin(state);
            return this.yylex();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            return new TokenImpl();
        }
    }
    
    protected void setHighlightEolComments(final boolean highlightEolComments) {
        this.highlightEolComments = highlightEolComments;
    }
    
    private boolean zzRefill() {
        return this.zzCurrentPos >= this.s.offset + this.s.count;
    }
    
    public final void yyreset(final Reader reader) {
        this.zzBuffer = this.s.array;
        this.zzStartRead = this.s.offset;
        this.zzEndRead = this.zzStartRead + this.s.count - 1;
        final int offset = this.s.offset;
        this.zzMarkedPos = offset;
        this.zzCurrentPos = offset;
        this.zzLexicalState = 0;
        this.zzReader = reader;
        this.zzAtEOF = false;
    }
    
    public JsonTokenMaker(final Reader in) {
        this.zzLexicalState = 0;
        this.zzBuffer = new char[16384];
        this.zzReader = in;
    }
    
    public JsonTokenMaker(final InputStream in) {
        this(new InputStreamReader(in));
    }
    
    private static char[] zzUnpackCMap(final String packed) {
        final char[] map = new char[65536];
        int i = 0;
        int j = 0;
        while (i < 124) {
            int count = packed.charAt(i++);
            final char value = packed.charAt(i++);
            do {
                map[j++] = value;
            } while (--count > 0);
        }
        return map;
    }
    
    public final void yyclose() throws IOException {
        this.zzAtEOF = true;
        this.zzEndRead = this.zzStartRead;
        if (this.zzReader != null) {
            this.zzReader.close();
        }
    }
    
    public final int yystate() {
        return this.zzLexicalState;
    }
    
    public final void yybegin(final int newState) {
        this.zzLexicalState = newState;
    }
    
    public final String yytext() {
        return new String(this.zzBuffer, this.zzStartRead, this.zzMarkedPos - this.zzStartRead);
    }
    
    public final char yycharat(final int pos) {
        return this.zzBuffer[this.zzStartRead + pos];
    }
    
    public final int yylength() {
        return this.zzMarkedPos - this.zzStartRead;
    }
    
    private void zzScanError(final int errorCode) {
        String message;
        try {
            message = JsonTokenMaker.ZZ_ERROR_MSG[errorCode];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            message = JsonTokenMaker.ZZ_ERROR_MSG[0];
        }
        throw new Error(message);
    }
    
    public void yypushback(final int number) {
        if (number > this.yylength()) {
            this.zzScanError(2);
        }
        this.zzMarkedPos -= number;
    }
    
    public Token yylex() throws IOException {
        int zzEndReadL = this.zzEndRead;
        char[] zzBufferL = this.zzBuffer;
        final char[] zzCMapL = JsonTokenMaker.ZZ_CMAP;
        final int[] zzTransL = JsonTokenMaker.ZZ_TRANS;
        final int[] zzRowMapL = JsonTokenMaker.ZZ_ROWMAP;
        final int[] zzAttrL = JsonTokenMaker.ZZ_ATTRIBUTE;
        final int zzPushbackPos = -1;
        this.zzPushbackPos = zzPushbackPos;
        int zzPushbackPosL = zzPushbackPos;
        while (true) {
            int zzMarkedPosL = this.zzMarkedPos;
            int zzAction = -1;
            final int n = zzMarkedPosL;
            this.zzStartRead = n;
            this.zzCurrentPos = n;
            int zzCurrentPosL = n;
            this.zzState = this.zzLexicalState;
            boolean zzWasPushback = false;
            int zzInput;
            while (true) {
                if (zzCurrentPosL < zzEndReadL) {
                    zzInput = zzBufferL[zzCurrentPosL++];
                }
                else {
                    if (this.zzAtEOF) {
                        zzInput = -1;
                        break;
                    }
                    this.zzCurrentPos = zzCurrentPosL;
                    this.zzMarkedPos = zzMarkedPosL;
                    this.zzPushbackPos = zzPushbackPosL;
                    final boolean eof = this.zzRefill();
                    zzCurrentPosL = this.zzCurrentPos;
                    zzMarkedPosL = this.zzMarkedPos;
                    zzBufferL = this.zzBuffer;
                    zzEndReadL = this.zzEndRead;
                    zzPushbackPosL = this.zzPushbackPos;
                    if (eof) {
                        zzInput = -1;
                        break;
                    }
                    zzInput = zzBufferL[zzCurrentPosL++];
                }
                final int zzNext = zzTransL[zzRowMapL[this.zzState] + zzCMapL[zzInput]];
                if (zzNext == -1) {
                    break;
                }
                this.zzState = zzNext;
                final int zzAttributes = zzAttrL[this.zzState];
                if ((zzAttributes & 0x2) == 0x2) {
                    zzPushbackPosL = zzCurrentPosL;
                }
                if ((zzAttributes & 0x1) != 0x1) {
                    continue;
                }
                zzWasPushback = ((zzAttributes & 0x4) == 0x4);
                zzAction = this.zzState;
                zzMarkedPosL = zzCurrentPosL;
                if ((zzAttributes & 0x8) == 0x8) {
                    break;
                }
            }
            this.zzMarkedPos = zzMarkedPosL;
            if (zzWasPushback) {
                this.zzMarkedPos = zzPushbackPosL;
            }
            switch ((zzAction < 0) ? zzAction : JsonTokenMaker.ZZ_ACTION[zzAction]) {
                case 13: {
                    this.addToken(6);
                }
                case 16: {
                    continue;
                }
                case 1: {
                    this.addToken(20);
                }
                case 17: {
                    continue;
                }
                case 10: {
                    this.addToken(11);
                }
                case 18: {
                    continue;
                }
                case 8: {
                    this.addToken(13);
                }
                case 19: {
                    continue;
                }
                case 12: {
                    this.addToken(17);
                }
                case 20: {
                    continue;
                }
                case 2: {
                    this.addToken(21);
                }
                case 21: {
                    continue;
                }
                case 15: {
                    final int temp = this.zzStartRead;
                    this.addToken(this.start, this.zzStartRead - 1, 1);
                    this.addHyperlinkToken(temp, this.zzMarkedPos - 1, 1);
                    this.start = this.zzMarkedPos;
                }
                case 22: {
                    continue;
                }
                case 3: {
                    this.addToken(10);
                }
                case 23: {
                    continue;
                }
                case 14: {
                    this.addToken(9);
                }
                case 24: {
                    continue;
                }
                case 9: {
                    if (this.highlightEolComments) {
                        this.start = this.zzMarkedPos - 2;
                        this.yybegin(1);
                        continue;
                    }
                    this.addToken(20);
                    continue;
                }
                case 25: {
                    continue;
                }
                case 4: {
                    this.addToken(37);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 26: {
                    continue;
                }
                case 7: {
                    this.addToken(this.start, this.zzStartRead - 1, 1);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 27: {
                    continue;
                }
                case 11: {
                    this.addToken(37);
                }
                case 28: {
                    continue;
                }
                case 6:
                case 29: {
                    continue;
                }
                case 5: {
                    this.addToken(22);
                }
                case 30: {
                    continue;
                }
                default: {
                    if (zzInput != -1 || this.zzStartRead != this.zzCurrentPos) {
                        this.zzScanError(1);
                        continue;
                    }
                    this.zzAtEOF = true;
                    switch (this.zzLexicalState) {
                        case 1: {
                            this.addToken(this.start, this.zzStartRead - 1, 1);
                            this.addNullToken();
                            return this.firstToken;
                        }
                        case 57: {
                            continue;
                        }
                        case 0: {
                            this.addNullToken();
                            return this.firstToken;
                        }
                        case 58: {
                            continue;
                        }
                        default: {
                            return null;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    static {
        ZZ_CMAP = zzUnpackCMap("\t\u0000\u0001\u0001\u0001\b\u0001\u0000\u0001\u0001\u0013\u0000\u0001\u0001\u0001\u0003\u0001\t\u0001\u0003\u0001\u0002\u0001\u0003\u0005\u0003\u0001\u0011\u0001\u0006\u0001\u0007\u0001\u000f\u0001\u000e\n\u0004\u0001\u001a\u0001\u0003\u0001\u0000\u0001\u0003\u0001\u0000\u0002\u0003\u0004\u0005\u0001\u0010\u0001\u0005\u0014\u0002\u0001\u001b\u0001\u000b\u0001\u001b\u0001\u0000\u0001\u0003\u0001\u0000\u0001\u0016\u0001\r\u0002\u0005\u0001\u0014\u0001\u0015\u0001\u0002\u0001\u001c\u0001\u001e\u0002\u0002\u0001\u0017\u0001\u0002\u0001\f\u0001\u0002\u0001\u001d\u0001\u0002\u0001\u0013\u0001\u0018\u0001\u0012\u0001\n\u0001\u0002\u0001\u001f\u0003\u0002\u0001\u0019\u0001\u0000\u0001\u0019\u0001\u0003\uff81\u0000");
        ZZ_ACTION = zzUnpackAction();
        ZZ_ROWMAP = zzUnpackRowMap();
        ZZ_TRANS = zzUnpackTrans();
        ZZ_ERROR_MSG = new String[] { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
        ZZ_ATTRIBUTE = zzUnpackAttribute();
    }
}
