//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.modes;

import javax.swing.text.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.io.*;

public class DockerTokenMaker extends AbstractJFlexTokenMaker
{
    public static final int YYEOF = -1;
    public static final int STRING = 1;
    public static final int CHAR_LITERAL = 2;
    public static final int YYINITIAL = 0;
    private static final String ZZ_CMAP_PACKED = "\t\u0000\u0001\u0002\u0001\u001f\u0001\u0000\u0001\u0002\u0013\u0000\u0001\u0002\u0001\u0000\u0001\u001c\u0001\u001e\u0003\u0000\u0001\u001d\u0005\u0000\u0002\u0001\u0001\u0000\n\u0001\u0004\u0000\u0001\u001b\u0002\u0000\u0001\u0004\u0001\f\u0001\u0014\u0001\u000f\u0001\b\u0001\n\u0001\u0018\u0001\u0001\u0001\u0005\u0001\u0001\u0001\u0017\u0001\u000e\u0001\u0003\u0001\u0006\u0001\u000b\u0001\u0011\u0001\u0001\u0001\t\u0001\u0012\u0001\u0007\u0001\r\u0001\u0013\u0001\u0016\u0001\u0010\u0001\u0015\u0001\u0001\u0001\u0019\u0001 \u0001\u0019\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0004\u0001\f\u0001\u0014\u0001\u000f\u0001\b\u0001\n\u0001\u0018\u0001\u0001\u0001\u0005\u0001\u0001\u0001\u0017\u0001\u000e\u0001\u0003\u0001\u0006\u0001\u000b\u0001\u0011\u0001\u0001\u0001\t\u0001\u0012\u0001\u0007\u0001\r\u0001\u0013\u0001\u0016\u0001\u0010\u0001\u0015\u0001\u0001\u0001\u0000\u0001\u001a\uff83\u0000";
    private static final char[] ZZ_CMAP;
    private static final int[] ZZ_ACTION;
    private static final String ZZ_ACTION_PACKED_0 = "\u0001\u0001\u0002\u0000\u0002\u0001\u0001\u0002\f\u0001\u0001\u0003\u0002\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\t\u0001\r\u0001\u000e\u0001\u000f\u000e\u0001\u0001\f\u0001\u000f\u0001\u0001\u0001\u0010!\u0001";
    private static final int[] ZZ_ROWMAP;
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000!\u0000B\u0000c\u0000\u0084\u0000¥\u0000\u00c6\u0000\u00e7\u0000\u0108\u0000\u0129\u0000\u014a\u0000\u016b\u0000\u018c\u0000\u01ad\u0000\u01ce\u0000\u01ef\u0000\u0210\u0000\u0231\u0000c\u0000c\u0000\u0252\u0000c\u0000c\u0000\u0273\u0000c\u0000\u0294\u0000c\u0000c\u0000\u02b5\u0000\u02d6\u0000c\u0000c\u0000\u02f7\u0000\u0318\u0000\u0339\u0000\u035a\u0000\u037b\u0000\u039c\u0000\u03bd\u0000\u03de\u0000\u03ff\u0000\u0420\u0000\u0441\u0000\u0462\u0000\u0483\u0000\u04a4\u0000\u04c5\u0000c\u0000c\u0000\u04e6\u0000\u0084\u0000\u0507\u0000\u0528\u0000\u0549\u0000\u056a\u0000\u058b\u0000\u05ac\u0000\u05cd\u0000\u05ee\u0000\u060f\u0000\u0630\u0000\u0651\u0000\u0672\u0000\u0693\u0000\u06b4\u0000\u06d5\u0000\u06f6\u0000\u0717\u0000\u0738\u0000\u0759\u0000\u077a\u0000\u079b\u0000\u07bc\u0000\u07dd\u0000\u07fe\u0000\u081f\u0000\u0840\u0000\u0861\u0000\u0882\u0000\u08a3\u0000\u08c4\u0000\u08e5\u0000\u0906\u0000\u0927";
    private static final int[] ZZ_TRANS;
    private static final String ZZ_TRANS_PACKED_0 = "\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0003\u0005\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\u0005\u0001\r\u0001\u000e\u0003\u0005\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0005\u0001\u0012\u0002\u0005\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0018\u0001\u0019\u0001\u0004\u001c\u001a\u0001\u001b\u0002\u001a\u0001\u001c\u0001\u001d\u001d\u001e\u0001\u001f\u0001\u001e\u0001 \u0001!\"\u0000\u0001\u0005\u0001\u0000\u0016\u0005\n\u0000\u0001\u0006\u001f\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001\"\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001#\u0005\u0005\u0001$\t\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001%\t\u0005\u0001&\b\u0005\t\u0000\u0001\u0005\u0001\u0000\n\u0005\u0001'\u000b\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001(\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001)\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u000f\u0005\u0001*\u0006\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001+\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u0001,\u0011\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001-\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001$\u0007\u0005\u0001.\r\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001/\r\u0005#\u0000\u0001\u0014\u0005\u0000\u001f\u0018\u0001\u0000\u0001\u0018\u001c\u001a\u0001\u0000\u0002\u001a\u0002\u0000\u001f0\u0001\u0000\u00010\u001d\u001e\u0001\u0000\u0001\u001e\u0002\u0000\u001f1\u0001\u0000\u00011\u0001\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u00012\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0015\u0005\u00013\t\u0000\u0001\u0005\u0001\u0000\f\u0005\u00013\t\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u00014\u000b\u0005\u00013\u0005\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u00015\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u00013\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u00016\r\u0005\t\u0000\u0001\u0005\u0001\u0000\t\u0005\u00017\f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0005\u0005\u00018\u0010\u0005\t\u0000\u0001\u0005\u0001\u0000\t\u0005\u00019\f\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001:\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u000b\u0005\u0001;\n\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u0001<\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001=\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001>\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001?\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001@\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u00013\u0015\u0005\t\u0000\u0001\u0005\u0001\u0000\n\u0005\u0001A\u000b\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u00013\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0005\u0005\u0001B\u0010\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u0001C\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\n\u0005\u0001D\u000b\u0005\t\u0000\u0001\u0005\u0001\u0000\u0012\u0005\u00013\u0003\u0005\t\u0000\u0001\u0005\u0001\u0000\u0014\u0005\u0001E\u0001\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u0001F\u0011\u0005\t\u0000\u0001\u0005\u0001\u0000\u0012\u0005\u0001G\u0003\u0005\t\u0000\u0001\u0005\u0001\u0000\u000f\u0005\u0001H\u0006\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001I\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u000b\u0005\u00013\n\u0005\t\u0000\u0001\u0005\u0001\u0000\u000f\u0005\u0001J\u0006\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001H\u0015\u0005\t\u0000\u0001\u0005\u0001\u0000\f\u0005\u0001K\t\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001L\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u0001M\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\u0005\u0005\u00013\u0010\u0005\t\u0000\u0001\u0005\u0001\u0000\u000b\u0005\u0001$\n\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001N\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u00018\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001O\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001P\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u0015\u0005\u0001Q\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001*\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001R\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001S\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001T\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001B\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u00013\u0011\u0005\b\u0000";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_ATTRIBUTE;
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0001\u0001\u0002\u0000\u0001\t\u000e\u0001\u0002\t\u0001\u0001\u0002\t\u0001\u0001\u0001\t\u0001\u0001\u0002\t\u0002\u0001\u0002\t\u000f\u0001\u0002\t#\u0001";
    private Reader zzReader;
    private int zzState;
    private int zzLexicalState;
    private char[] zzBuffer;
    private int zzMarkedPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private boolean zzAtEOF;
    
    private static int[] zzUnpackAction() {
        final int[] result = new int[84];
        int offset = 0;
        offset = zzUnpackAction("\u0001\u0001\u0002\u0000\u0002\u0001\u0001\u0002\f\u0001\u0001\u0003\u0002\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\t\u0001\r\u0001\u000e\u0001\u000f\u000e\u0001\u0001\f\u0001\u000f\u0001\u0001\u0001\u0010!\u0001", offset, result);
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
        final int[] result = new int[84];
        int offset = 0;
        offset = zzUnpackRowMap("\u0000\u0000\u0000!\u0000B\u0000c\u0000\u0084\u0000¥\u0000\u00c6\u0000\u00e7\u0000\u0108\u0000\u0129\u0000\u014a\u0000\u016b\u0000\u018c\u0000\u01ad\u0000\u01ce\u0000\u01ef\u0000\u0210\u0000\u0231\u0000c\u0000c\u0000\u0252\u0000c\u0000c\u0000\u0273\u0000c\u0000\u0294\u0000c\u0000c\u0000\u02b5\u0000\u02d6\u0000c\u0000c\u0000\u02f7\u0000\u0318\u0000\u0339\u0000\u035a\u0000\u037b\u0000\u039c\u0000\u03bd\u0000\u03de\u0000\u03ff\u0000\u0420\u0000\u0441\u0000\u0462\u0000\u0483\u0000\u04a4\u0000\u04c5\u0000c\u0000c\u0000\u04e6\u0000\u0084\u0000\u0507\u0000\u0528\u0000\u0549\u0000\u056a\u0000\u058b\u0000\u05ac\u0000\u05cd\u0000\u05ee\u0000\u060f\u0000\u0630\u0000\u0651\u0000\u0672\u0000\u0693\u0000\u06b4\u0000\u06d5\u0000\u06f6\u0000\u0717\u0000\u0738\u0000\u0759\u0000\u077a\u0000\u079b\u0000\u07bc\u0000\u07dd\u0000\u07fe\u0000\u081f\u0000\u0840\u0000\u0861\u0000\u0882\u0000\u08a3\u0000\u08c4\u0000\u08e5\u0000\u0906\u0000\u0927", offset, result);
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
        final int[] result = new int[2376];
        int offset = 0;
        offset = zzUnpackTrans("\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0003\u0005\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\u0005\u0001\r\u0001\u000e\u0003\u0005\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0005\u0001\u0012\u0002\u0005\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0018\u0001\u0019\u0001\u0004\u001c\u001a\u0001\u001b\u0002\u001a\u0001\u001c\u0001\u001d\u001d\u001e\u0001\u001f\u0001\u001e\u0001 \u0001!\"\u0000\u0001\u0005\u0001\u0000\u0016\u0005\n\u0000\u0001\u0006\u001f\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001\"\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001#\u0005\u0005\u0001$\t\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001%\t\u0005\u0001&\b\u0005\t\u0000\u0001\u0005\u0001\u0000\n\u0005\u0001'\u000b\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001(\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001)\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u000f\u0005\u0001*\u0006\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001+\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u0001,\u0011\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001-\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001$\u0007\u0005\u0001.\r\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001/\r\u0005#\u0000\u0001\u0014\u0005\u0000\u001f\u0018\u0001\u0000\u0001\u0018\u001c\u001a\u0001\u0000\u0002\u001a\u0002\u0000\u001f0\u0001\u0000\u00010\u001d\u001e\u0001\u0000\u0001\u001e\u0002\u0000\u001f1\u0001\u0000\u00011\u0001\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u00012\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0015\u0005\u00013\t\u0000\u0001\u0005\u0001\u0000\f\u0005\u00013\t\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u00014\u000b\u0005\u00013\u0005\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u00015\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u00013\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u00016\r\u0005\t\u0000\u0001\u0005\u0001\u0000\t\u0005\u00017\f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0005\u0005\u00018\u0010\u0005\t\u0000\u0001\u0005\u0001\u0000\t\u0005\u00019\f\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001:\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u000b\u0005\u0001;\n\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u0001<\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001=\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001>\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u0001?\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001@\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u00013\u0015\u0005\t\u0000\u0001\u0005\u0001\u0000\n\u0005\u0001A\u000b\u0005\t\u0000\u0001\u0005\u0001\u0000\u0006\u0005\u00013\u000f\u0005\t\u0000\u0001\u0005\u0001\u0000\u0005\u0005\u0001B\u0010\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u0001C\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\n\u0005\u0001D\u000b\u0005\t\u0000\u0001\u0005\u0001\u0000\u0012\u0005\u00013\u0003\u0005\t\u0000\u0001\u0005\u0001\u0000\u0014\u0005\u0001E\u0001\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u0001F\u0011\u0005\t\u0000\u0001\u0005\u0001\u0000\u0012\u0005\u0001G\u0003\u0005\t\u0000\u0001\u0005\u0001\u0000\u000f\u0005\u0001H\u0006\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001I\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u000b\u0005\u00013\n\u0005\t\u0000\u0001\u0005\u0001\u0000\u000f\u0005\u0001J\u0006\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001H\u0015\u0005\t\u0000\u0001\u0005\u0001\u0000\f\u0005\u0001K\t\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001L\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u000e\u0005\u0001M\u0007\u0005\t\u0000\u0001\u0005\u0001\u0000\u0005\u0005\u00013\u0010\u0005\t\u0000\u0001\u0005\u0001\u0000\u000b\u0005\u0001$\n\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001N\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u00018\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001O\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\b\u0005\u0001P\r\u0005\t\u0000\u0001\u0005\u0001\u0000\u0015\u0005\u0001Q\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001*\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0002\u0005\u0001R\u0013\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001S\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0003\u0005\u0001T\u0012\u0005\t\u0000\u0001\u0005\u0001\u0000\u0001\u0005\u0001B\u0014\u0005\t\u0000\u0001\u0005\u0001\u0000\u0004\u0005\u00013\u0011\u0005\b\u0000", offset, result);
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
        final int[] result = new int[84];
        int offset = 0;
        offset = zzUnpackAttribute("\u0001\u0001\u0002\u0000\u0001\t\u000e\u0001\u0002\t\u0001\u0001\u0002\t\u0001\u0001\u0001\t\u0001\u0001\u0002\t\u0002\u0001\u0002\t\u000f\u0001\u0002\t#\u0001", offset, result);
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
    
    public DockerTokenMaker() {
        this.zzLexicalState = 0;
    }
    
    private void addToken(final int tokenType) {
        this.addToken(this.zzStartRead, this.zzMarkedPos - 1, tokenType);
    }
    
    private void addToken(final int start, final int end, final int tokenType) {
        final int so = start + this.offsetShift;
        this.addToken(this.zzBuffer, start, end, tokenType, so);
    }
    
    public void addToken(final char[] array, final int start, final int end, final int tokenType, final int startOffset) {
        super.addToken(array, start, end, tokenType, startOffset);
        this.zzStartRead = this.zzMarkedPos;
    }
    
    public String[] getLineCommentStartAndEnd(final int languageIndex) {
        return new String[] { "#", null };
    }
    
    public boolean getMarkOccurrencesOfTokenType(final int type) {
        return type == 20 || type == 6;
    }
    
    public Token getTokenList(final Segment text, final int initialTokenType, final int startOffset) {
        this.resetTokenList();
        this.offsetShift = -text.offset + startOffset;
        final int state = 0;
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
    
    public DockerTokenMaker(final Reader in) {
        this.zzLexicalState = 0;
        this.zzReader = in;
    }
    
    public DockerTokenMaker(final InputStream in) {
        this(new InputStreamReader(in));
    }
    
    private static char[] zzUnpackCMap(final String packed) {
        final char[] map = new char[65536];
        int i = 0;
        int j = 0;
        while (i < 160) {
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
            message = DockerTokenMaker.ZZ_ERROR_MSG[errorCode];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            message = DockerTokenMaker.ZZ_ERROR_MSG[0];
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
        final char[] zzCMapL = DockerTokenMaker.ZZ_CMAP;
        final int[] zzTransL = DockerTokenMaker.ZZ_TRANS;
        final int[] zzRowMapL = DockerTokenMaker.ZZ_ROWMAP;
        final int[] zzAttrL = DockerTokenMaker.ZZ_ATTRIBUTE;
        while (true) {
            int zzMarkedPosL = this.zzMarkedPos;
            int zzAction = -1;
            final int n = zzMarkedPosL;
            this.zzStartRead = n;
            this.zzCurrentPos = n;
            int zzCurrentPosL = n;
            this.zzState = this.zzLexicalState;
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
                    final boolean eof = this.zzRefill();
                    zzCurrentPosL = this.zzCurrentPos;
                    zzMarkedPosL = this.zzMarkedPos;
                    zzBufferL = this.zzBuffer;
                    zzEndReadL = this.zzEndRead;
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
                if ((zzAttributes & 0x1) != 0x1) {
                    continue;
                }
                zzAction = this.zzState;
                zzMarkedPosL = zzCurrentPosL;
                if ((zzAttributes & 0x8) == 0x8) {
                    break;
                }
            }
            this.zzMarkedPos = zzMarkedPosL;
            switch ((zzAction < 0) ? zzAction : DockerTokenMaker.ZZ_ACTION[zzAction]) {
                case 16: {
                    this.addToken(6);
                }
                case 17: {
                    continue;
                }
                case 1: {
                    this.addToken(20);
                }
                case 18: {
                    continue;
                }
                case 7: {
                    this.addToken(1);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 19: {
                    continue;
                }
                case 2: {
                    this.addToken(21);
                }
                case 20: {
                    continue;
                }
                case 11: {
                    this.addToken(this.start, this.zzStartRead - 1, 13);
                    return this.firstToken;
                }
                case 21: {
                    continue;
                }
                case 14: {
                    this.addToken(this.start, this.zzStartRead - 1, 14);
                    return this.firstToken;
                }
                case 22: {
                    continue;
                }
                case 12:
                case 23: {
                    continue;
                }
                case 4: {
                    this.addToken(23);
                }
                case 24: {
                    continue;
                }
                case 15:
                case 25: {
                    continue;
                }
                case 5: {
                    this.start = this.zzMarkedPos - 1;
                    this.yybegin(1);
                }
                case 26: {
                    continue;
                }
                case 13: {
                    this.yybegin(0);
                    this.addToken(this.start, this.zzStartRead, 14);
                }
                case 27: {
                    continue;
                }
                case 10: {
                    this.yybegin(0);
                    this.addToken(this.start, this.zzStartRead, 13);
                }
                case 28: {
                    continue;
                }
                case 8: {
                    this.addNullToken();
                    return this.firstToken;
                }
                case 29: {
                    continue;
                }
                case 9:
                case 30: {
                    continue;
                }
                case 3: {
                    this.addToken(22);
                }
                case 31: {
                    continue;
                }
                case 6: {
                    this.start = this.zzMarkedPos - 1;
                    this.yybegin(2);
                }
                case 32: {
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
                            this.addToken(this.start, this.zzStartRead - 1, 13);
                            return this.firstToken;
                        }
                        case 85: {
                            continue;
                        }
                        case 2: {
                            this.addToken(this.start, this.zzStartRead - 1, 14);
                            return this.firstToken;
                        }
                        case 86: {
                            continue;
                        }
                        case 0: {
                            this.addNullToken();
                            return this.firstToken;
                        }
                        case 87: {
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
        ZZ_CMAP = zzUnpackCMap("\t\u0000\u0001\u0002\u0001\u001f\u0001\u0000\u0001\u0002\u0013\u0000\u0001\u0002\u0001\u0000\u0001\u001c\u0001\u001e\u0003\u0000\u0001\u001d\u0005\u0000\u0002\u0001\u0001\u0000\n\u0001\u0004\u0000\u0001\u001b\u0002\u0000\u0001\u0004\u0001\f\u0001\u0014\u0001\u000f\u0001\b\u0001\n\u0001\u0018\u0001\u0001\u0001\u0005\u0001\u0001\u0001\u0017\u0001\u000e\u0001\u0003\u0001\u0006\u0001\u000b\u0001\u0011\u0001\u0001\u0001\t\u0001\u0012\u0001\u0007\u0001\r\u0001\u0013\u0001\u0016\u0001\u0010\u0001\u0015\u0001\u0001\u0001\u0019\u0001 \u0001\u0019\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0004\u0001\f\u0001\u0014\u0001\u000f\u0001\b\u0001\n\u0001\u0018\u0001\u0001\u0001\u0005\u0001\u0001\u0001\u0017\u0001\u000e\u0001\u0003\u0001\u0006\u0001\u000b\u0001\u0011\u0001\u0001\u0001\t\u0001\u0012\u0001\u0007\u0001\r\u0001\u0013\u0001\u0016\u0001\u0010\u0001\u0015\u0001\u0001\u0001\u0000\u0001\u001a\uff83\u0000");
        ZZ_ACTION = zzUnpackAction();
        ZZ_ROWMAP = zzUnpackRowMap();
        ZZ_TRANS = zzUnpackTrans();
        ZZ_ERROR_MSG = new String[] { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
        ZZ_ATTRIBUTE = zzUnpackAttribute();
    }
}
