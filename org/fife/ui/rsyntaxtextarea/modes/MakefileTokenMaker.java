//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.modes;

import java.util.*;
import javax.swing.text.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.io.*;

public class MakefileTokenMaker extends AbstractJFlexTokenMaker
{
    public static final int YYEOF = -1;
    public static final int VAR = 1;
    public static final int YYINITIAL = 0;
    private static final String ZZ_CMAP_PACKED = "\t\u0000\u0001\b\u0001\u0007\u0001\u0000\u0001\b\u0013\u0000\u0001\b\u0001\u0000\u0001\u000b\u0001\r\u0001\u0004\u0002\u0000\u0001\t\u0001\u0006\u0001'\u0001\u0000\u0001\u000e\u0001\u0000\u0001\u001f\u0001\u0001\u0001\u0000\n\u0002\u0001\u0003\u0002\u0000\u0001\u000f\u0001\u0000\u0001\u000e\u0001\u0000\u001a\u0001\u0001\u0000\u0001\n\u0002\u0000\u0001\u0001\u0001\f\u0001\u0010\u0001\u001a\u0001#\u0001\u0011\u0001\u0014\u0001\u0015\u0001!\u0001$\u0001\u0016\u0001%\u0001\u0001\u0001\u001d\u0001\u001c\u0001\u001b\u0001 \u0001\u0012\u0001&\u0001\u0013\u0001\u0018\u0001\u001e\u0001\u0019\u0001\u0001\u0001\"\u0001\u0017\u0002\u0001\u0001\u0005\u0001\u0000\u0001(\uff82\u0000";
    private static final char[] ZZ_CMAP;
    private static final int[] ZZ_ACTION;
    private static final String ZZ_ACTION_PACKED_0 = "\u0002\u0000\u0002\u0001\u0001\u0002\u0002\u0001\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0001\u0001\u0007\u0001\b\f\u0001\u0002\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0005\u0001\u0006\u0001\u0011\u0002\u0000\u0001\u0012\u0013\u0001\u0001\u0013\u0001\u0014\u0001\u0010\u0001\u0011\u0001\u0012\u0002\u0001\u0001\u0015#\u0001\u0001\u0015\f\u0001\u0001\u0015\u0005\u0001\u0001\u0000\u0002\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0015";
    private static final int[] ZZ_ROWMAP;
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000)\u0000R\u0000{\u0000�\u0000\u00cd\u0000\u00f6\u0000R\u0000\u011f\u0000\u0148\u0000\u0171\u0000\u019a\u0000\u01c3\u0000R\u0000\u01ec\u0000\u0215\u0000\u023e\u0000\u0267\u0000\u0290\u0000\u02b9\u0000\u02e2\u0000\u030b\u0000\u0334\u0000\u035d\u0000\u0386\u0000\u03af\u0000\u03d8\u0000\u0401\u0000\u042a\u0000R\u0000R\u0000R\u0000R\u0000R\u0000R\u0000\u0453\u0000\u047c\u0000R\u0000\u019a\u0000\u04a5\u0000R\u0000\u04ce\u0000\u04f7\u0000\u0520\u0000\u0549\u0000\u0572\u0000\u059b\u0000\u05c4\u0000\u05ed\u0000\u0616\u0000\u063f\u0000\u0668\u0000\u0691\u0000\u06ba\u0000\u06e3\u0000\u070c\u0000\u0735\u0000\u075e\u0000\u0787\u0000\u07b0\u0000R\u0000R\u0000\u0148\u0000\u0171\u0000\u019a\u0000\u07d9\u0000\u0802\u0000{\u0000\u082b\u0000\u0854\u0000\u087d\u0000\u08a6\u0000\u08cf\u0000\u08f8\u0000\u0921\u0000\u094a\u0000\u0973\u0000\u099c\u0000\u09c5\u0000\u09ee\u0000\u0a17\u0000\u0a40\u0000\u0a69\u0000\u0a92\u0000\u0abb\u0000\u0ae4\u0000\u0b0d\u0000\u0b36\u0000\u0b5f\u0000\u0b88\u0000\u0bb1\u0000\u0bda\u0000\u0c03\u0000\u0c2c\u0000\u0c55\u0000\u0c7e\u0000\u0ca7\u0000\u0cd0\u0000\u0cf9\u0000\u0d22\u0000\u0d4b\u0000\u0d74\u0000\u0d9d\u0000\u0dc6\u0000\u0def\u0000\u0e18\u0000\u0e41\u0000\u0e6a\u0000\u0e93\u0000\u0ebc\u0000\u0ee5\u0000\u0f0e\u0000\u0f37\u0000\u0f60\u0000\u0f89\u0000\u0fb2\u0000\u0fdb\u0000\u1004\u0000\u102d\u0000\u1056\u0000\u107f\u0000\u10a8\u0000\u10d1\u0000\u10fa\u0000\u1123\u0000\u114c\u0000\u1175\u0000\u119e\u0000R";
    private static final int[] ZZ_TRANS;
    private static final String ZZ_TRANS_PACKED_0 = "\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0002\u0003\u0001\b\u0001\t\u0001\n\u0001\u0003\u0001\u000b\u0001\f\u0001\r\u0001\u0006\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0004\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0004\u0001\u0015\u0001\u0004\u0001\u0016\u0001\u0017\u0003\u0004\u0001\u0003\u0001\u0018\u0001\u0004\u0001\u0019\u0002\u0004\u0001\u001a\u0001\u0004\u0002\u0003\u0004\u001b\u0001\u001c\b\u001b\u0001\u001d\u0019\u001b\u0001\u001e\u0001\u001f*\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0007\u0004\u0004\u0000\u0001\u00055\u0000\u0001\u000e\u001e\u0000\u0001!\u0001\"*\u0000\u0001\t \u0000\u0007\n\u0001\u0000\u0001\n\u0001#\u0001$\u001e\n\u0007\u000b\u0001\u0000\u0002\u000b\u0001%\u0001&\u001d\u000b\u0007'\u0001\u0000\u0002'\u0001(\u0001'\u0001)\u001c'\u0007\r\u0001\u0000!\r\u0001\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001*\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001+\u0001\u0004\u0001,\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001-\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001.\u0001\u0004\u0001/\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u00010\b\u0004\u0001\u0000\u00011\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u00012\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\t\u0004\u00013\u0004\u0004\u00014\u0001\u0000\u00015\u0003\u0004\u00016\u0002\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u00017\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u00018\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u00019\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001:\b\u0004\u0001\u0000\u0001;\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001<\u0006\u0004\u0002\u0000\u0004\u001b\u0001\u0000\b\u001b\u0001\u0000\u0019\u001b\u0007\u0000\u0001=\u0001>\"\u0000\u0007\u001d\u0001\u0000!\u001d\u0007\n\u0001\u0000\u0001\n\u0001?\u0001$\u001e\n\u0007\u000b\u0001\u0000\u0002\u000b\u0001%\u0001@\u001d\u000b\u0007'\u0001\u0000\u0002'\u0001(\u0001'\u0001A\u001c'\u0001\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001B\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001C\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001D\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001E\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001F\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001G\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001H\u0007\u0004\u0001I\u0001\u0004\u0001J\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001K\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001L\u0002\u0004\u0001M\u0006\u0004\u0001N\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001O\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001P\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001Q\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001R\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001S\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001T\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001U\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\r\u0004\u0001V\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001W\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001X\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0002\u0004\u0001Y\u0005\u0004\u0001Z\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001[\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0004\u0004\u0001\\\u0002\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001]\u0001\u0004\u0001]\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001D\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001^\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001_\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001`\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001a\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001]\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0006\u0004\u0001D\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001L\u0002\u0004\u0001M\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001b\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001c\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001D\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\r\u0004\u0001d\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001e\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001f\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001\u0004\u0001<\u0005\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001g\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001h\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001D\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001i\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\t\u0004\u00013\u0005\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001G\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001j\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001D\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001k\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001l\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001m\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001n\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001o\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0002\u0004\u0001D\f\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\r\u0004\u0001D\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001p\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001,\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0003\u0004\u0001q\u0003\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001D\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001O\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\t\u0004\u0001r\u0005\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0002\u0004\u0001s\u0004\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001t\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001u\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0003\u0004\u0001v\u0003\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0007\u0004\u0001D\u0007\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001w\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001x\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\n\u0004\u0001y\u0004\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001x\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001z\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001{\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0004\u0004\u0001D\u0002\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\f\u0004\u0001G\u0002\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001|\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001Q\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001}\b\u0004\u0001\u0000\u0007\u0004\"\u0000\u0001~\t\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001D\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001\u007f\u0003\u0004\u0001\u0000\u0007\u0004\u001b\u0000\u0001\u0080\u0010\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001\u0004\u0001D\u0005\u0004 \u0000\u0001\u0081\n\u0000";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_ATTRIBUTE;
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0002\u0000\u0001\t\u0004\u0001\u0001\t\u0005\u0001\u0001\t\u000f\u0001\u0006\t\u0002\u0001\u0001\t\u0002\u0000\u0001\t\u0013\u0001\u0002\t<\u0001\u0001\u0000\u0002\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\t";
    private Reader zzReader;
    private int zzState;
    private int zzLexicalState;
    private char[] zzBuffer;
    private int zzMarkedPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private boolean zzAtEOF;
    private Stack<Boolean> varDepths;
    
    private static int[] zzUnpackAction() {
        final int[] result = new int[129];
        int offset = 0;
        offset = zzUnpackAction("\u0002\u0000\u0002\u0001\u0001\u0002\u0002\u0001\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0001\u0001\u0007\u0001\b\f\u0001\u0002\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0005\u0001\u0006\u0001\u0011\u0002\u0000\u0001\u0012\u0013\u0001\u0001\u0013\u0001\u0014\u0001\u0010\u0001\u0011\u0001\u0012\u0002\u0001\u0001\u0015#\u0001\u0001\u0015\f\u0001\u0001\u0015\u0005\u0001\u0001\u0000\u0002\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0015", offset, result);
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
        final int[] result = new int[129];
        int offset = 0;
        offset = zzUnpackRowMap("\u0000\u0000\u0000)\u0000R\u0000{\u0000�\u0000\u00cd\u0000\u00f6\u0000R\u0000\u011f\u0000\u0148\u0000\u0171\u0000\u019a\u0000\u01c3\u0000R\u0000\u01ec\u0000\u0215\u0000\u023e\u0000\u0267\u0000\u0290\u0000\u02b9\u0000\u02e2\u0000\u030b\u0000\u0334\u0000\u035d\u0000\u0386\u0000\u03af\u0000\u03d8\u0000\u0401\u0000\u042a\u0000R\u0000R\u0000R\u0000R\u0000R\u0000R\u0000\u0453\u0000\u047c\u0000R\u0000\u019a\u0000\u04a5\u0000R\u0000\u04ce\u0000\u04f7\u0000\u0520\u0000\u0549\u0000\u0572\u0000\u059b\u0000\u05c4\u0000\u05ed\u0000\u0616\u0000\u063f\u0000\u0668\u0000\u0691\u0000\u06ba\u0000\u06e3\u0000\u070c\u0000\u0735\u0000\u075e\u0000\u0787\u0000\u07b0\u0000R\u0000R\u0000\u0148\u0000\u0171\u0000\u019a\u0000\u07d9\u0000\u0802\u0000{\u0000\u082b\u0000\u0854\u0000\u087d\u0000\u08a6\u0000\u08cf\u0000\u08f8\u0000\u0921\u0000\u094a\u0000\u0973\u0000\u099c\u0000\u09c5\u0000\u09ee\u0000\u0a17\u0000\u0a40\u0000\u0a69\u0000\u0a92\u0000\u0abb\u0000\u0ae4\u0000\u0b0d\u0000\u0b36\u0000\u0b5f\u0000\u0b88\u0000\u0bb1\u0000\u0bda\u0000\u0c03\u0000\u0c2c\u0000\u0c55\u0000\u0c7e\u0000\u0ca7\u0000\u0cd0\u0000\u0cf9\u0000\u0d22\u0000\u0d4b\u0000\u0d74\u0000\u0d9d\u0000\u0dc6\u0000\u0def\u0000\u0e18\u0000\u0e41\u0000\u0e6a\u0000\u0e93\u0000\u0ebc\u0000\u0ee5\u0000\u0f0e\u0000\u0f37\u0000\u0f60\u0000\u0f89\u0000\u0fb2\u0000\u0fdb\u0000\u1004\u0000\u102d\u0000\u1056\u0000\u107f\u0000\u10a8\u0000\u10d1\u0000\u10fa\u0000\u1123\u0000\u114c\u0000\u1175\u0000\u119e\u0000R", offset, result);
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
        final int[] result = new int[4551];
        int offset = 0;
        offset = zzUnpackTrans("\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0002\u0003\u0001\b\u0001\t\u0001\n\u0001\u0003\u0001\u000b\u0001\f\u0001\r\u0001\u0006\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0004\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0004\u0001\u0015\u0001\u0004\u0001\u0016\u0001\u0017\u0003\u0004\u0001\u0003\u0001\u0018\u0001\u0004\u0001\u0019\u0002\u0004\u0001\u001a\u0001\u0004\u0002\u0003\u0004\u001b\u0001\u001c\b\u001b\u0001\u001d\u0019\u001b\u0001\u001e\u0001\u001f*\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0007\u0004\u0004\u0000\u0001\u00055\u0000\u0001\u000e\u001e\u0000\u0001!\u0001\"*\u0000\u0001\t \u0000\u0007\n\u0001\u0000\u0001\n\u0001#\u0001$\u001e\n\u0007\u000b\u0001\u0000\u0002\u000b\u0001%\u0001&\u001d\u000b\u0007'\u0001\u0000\u0002'\u0001(\u0001'\u0001)\u001c'\u0007\r\u0001\u0000!\r\u0001\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001*\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001+\u0001\u0004\u0001,\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001-\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001.\u0001\u0004\u0001/\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u00010\b\u0004\u0001\u0000\u00011\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u00012\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\t\u0004\u00013\u0004\u0004\u00014\u0001\u0000\u00015\u0003\u0004\u00016\u0002\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u00017\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u00018\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u00019\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001:\b\u0004\u0001\u0000\u0001;\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001<\u0006\u0004\u0002\u0000\u0004\u001b\u0001\u0000\b\u001b\u0001\u0000\u0019\u001b\u0007\u0000\u0001=\u0001>\"\u0000\u0007\u001d\u0001\u0000!\u001d\u0007\n\u0001\u0000\u0001\n\u0001?\u0001$\u001e\n\u0007\u000b\u0001\u0000\u0002\u000b\u0001%\u0001@\u001d\u000b\u0007'\u0001\u0000\u0002'\u0001(\u0001'\u0001A\u001c'\u0001\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001B\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001C\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001D\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001E\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001F\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001G\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001H\u0007\u0004\u0001I\u0001\u0004\u0001J\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001K\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001L\u0002\u0004\u0001M\u0006\u0004\u0001N\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001O\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001P\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001Q\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001R\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001S\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001T\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001U\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\r\u0004\u0001V\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001W\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001X\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0002\u0004\u0001Y\u0005\u0004\u0001Z\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001[\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0004\u0004\u0001\\\u0002\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001]\u0001\u0004\u0001]\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001D\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001^\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001_\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001`\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001a\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001]\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0006\u0004\u0001D\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001L\u0002\u0004\u0001M\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001b\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001c\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001D\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\r\u0004\u0001d\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001e\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001f\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001\u0004\u0001<\u0005\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001g\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001h\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001D\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001i\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\t\u0004\u00013\u0005\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001G\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001j\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0005\u0004\u0001D\t\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001k\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001l\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001m\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001n\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001o\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0002\u0004\u0001D\f\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\r\u0004\u0001D\u0001\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001p\u0003\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001,\b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0003\u0004\u0001q\u0003\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001D\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0004\u0004\u0001O\n\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\t\u0004\u0001r\u0005\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0002\u0004\u0001s\u0004\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000e\u0004\u0001t\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001u\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0003\u0004\u0001v\u0003\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0007\u0004\u0001D\u0007\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001w\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0001x\u000e\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\n\u0004\u0001y\u0004\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001x\u0006\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001z\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001{\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0004\u0004\u0001D\u0002\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\f\u0004\u0001G\u0002\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0003\u0004\u0001|\u000b\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\b\u0004\u0001Q\u0006\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u0006\u0004\u0001}\b\u0004\u0001\u0000\u0007\u0004\"\u0000\u0001~\t\u0000\u0002\u0004\u0001 \f\u0000\u0001\u0004\u0001D\r\u0004\u0001\u0000\u0007\u0004\u0003\u0000\u0002\u0004\u0001 \f\u0000\u000b\u0004\u0001\u007f\u0003\u0004\u0001\u0000\u0007\u0004\u001b\u0000\u0001\u0080\u0010\u0000\u0002\u0004\u0001 \f\u0000\u000f\u0004\u0001\u0000\u0001\u0004\u0001D\u0005\u0004 \u0000\u0001\u0081\n\u0000", offset, result);
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
        final int[] result = new int[129];
        int offset = 0;
        offset = zzUnpackAttribute("\u0002\u0000\u0001\t\u0004\u0001\u0001\t\u0005\u0001\u0001\t\u000f\u0001\u0006\t\u0002\u0001\u0001\t\u0002\u0000\u0001\t\u0013\u0001\u0002\t<\u0001\u0001\u0000\u0002\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\t", offset, result);
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
    
    public MakefileTokenMaker() {
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
        return type == 20 || type == 17;
    }
    
    public Token getTokenList(final Segment text, final int initialTokenType, final int startOffset) {
        this.resetTokenList();
        this.offsetShift = -text.offset + startOffset;
        this.s = text;
        try {
            this.yyreset(this.zzReader);
            this.yybegin(0);
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
    
    public MakefileTokenMaker(final Reader in) {
        this.zzLexicalState = 0;
        this.zzReader = in;
    }
    
    public MakefileTokenMaker(final InputStream in) {
        this(new InputStreamReader(in));
    }
    
    private static char[] zzUnpackCMap(final String packed) {
        final char[] map = new char[65536];
        int i = 0;
        int j = 0;
        while (i < 126) {
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
            message = MakefileTokenMaker.ZZ_ERROR_MSG[errorCode];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            message = MakefileTokenMaker.ZZ_ERROR_MSG[0];
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
        final char[] zzCMapL = MakefileTokenMaker.ZZ_CMAP;
        final int[] zzTransL = MakefileTokenMaker.ZZ_TRANS;
        final int[] zzRowMapL = MakefileTokenMaker.ZZ_ROWMAP;
        final int[] zzAttrL = MakefileTokenMaker.ZZ_ATTRIBUTE;
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
            switch ((zzAction < 0) ? zzAction : MakefileTokenMaker.ZZ_ACTION[zzAction]) {
                case 13: {
                    this.addToken(24);
                }
                case 22: {
                    continue;
                }
                case 15: {
                    if (this.varDepths == null) {
                        this.varDepths = new Stack<Boolean>();
                    }
                    else {
                        this.varDepths.clear();
                    }
                    this.varDepths.push(Boolean.FALSE);
                    this.start = this.zzMarkedPos - 2;
                    this.yybegin(1);
                }
                case 23: {
                    continue;
                }
                case 3: {
                    this.addNullToken();
                    return this.firstToken;
                }
                case 24: {
                    continue;
                }
                case 16: {
                    this.addToken(14);
                }
                case 25: {
                    continue;
                }
                case 12: {
                    if (this.varDepths.empty() || !Boolean.TRUE.equals(this.varDepths.peek())) {
                        continue;
                    }
                    this.varDepths.pop();
                    if (this.varDepths.empty()) {
                        this.addToken(this.start, this.zzStartRead, 17);
                        this.yybegin(0);
                        continue;
                    }
                    continue;
                }
                case 26: {
                    continue;
                }
                case 11: {
                    if (this.varDepths.empty() || !Boolean.FALSE.equals(this.varDepths.peek())) {
                        continue;
                    }
                    this.varDepths.pop();
                    if (this.varDepths.empty()) {
                        this.addToken(this.start, this.zzStartRead, 17);
                        this.yybegin(0);
                        continue;
                    }
                    continue;
                }
                case 27: {
                    continue;
                }
                case 4: {
                    this.addToken(21);
                }
                case 28: {
                    continue;
                }
                case 21: {
                    this.addToken(6);
                }
                case 29: {
                    continue;
                }
                case 20: {
                    this.varDepths.push(Boolean.FALSE);
                }
                case 30: {
                    continue;
                }
                case 18: {
                    this.addToken(15);
                }
                case 31: {
                    continue;
                }
                case 19: {
                    this.varDepths.push(Boolean.TRUE);
                }
                case 32: {
                    continue;
                }
                case 1: {
                    this.addToken(20);
                }
                case 33: {
                    continue;
                }
                case 14: {
                    if (this.varDepths == null) {
                        this.varDepths = new Stack<Boolean>();
                    }
                    else {
                        this.varDepths.clear();
                    }
                    this.varDepths.push(Boolean.TRUE);
                    this.start = this.zzMarkedPos - 2;
                    this.yybegin(1);
                }
                case 34: {
                    continue;
                }
                case 5: {
                    this.addToken(38);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 35: {
                    continue;
                }
                case 6: {
                    this.addToken(37);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 36: {
                    continue;
                }
                case 10: {
                    final int temp1 = this.zzStartRead;
                    final int temp2 = this.zzMarkedPos;
                    this.addToken(this.start, this.zzStartRead - 1, 17);
                    this.addToken(temp1, temp2 - 1, 1);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 37: {
                    continue;
                }
                case 17: {
                    this.addToken(13);
                }
                case 38: {
                    continue;
                }
                case 7: {
                    this.addToken(1);
                    this.addNullToken();
                    return this.firstToken;
                }
                case 39: {
                    continue;
                }
                case 2: {
                    this.addToken(10);
                }
                case 40: {
                    continue;
                }
                case 8: {
                    this.addToken(23);
                }
                case 41: {
                    continue;
                }
                case 9:
                case 42: {
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
                            this.addToken(this.start, this.zzStartRead - 1, 17);
                            this.addNullToken();
                            return this.firstToken;
                        }
                        case 130: {
                            continue;
                        }
                        case 0: {
                            this.addNullToken();
                            return this.firstToken;
                        }
                        case 131: {
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
        ZZ_CMAP = zzUnpackCMap("\t\u0000\u0001\b\u0001\u0007\u0001\u0000\u0001\b\u0013\u0000\u0001\b\u0001\u0000\u0001\u000b\u0001\r\u0001\u0004\u0002\u0000\u0001\t\u0001\u0006\u0001'\u0001\u0000\u0001\u000e\u0001\u0000\u0001\u001f\u0001\u0001\u0001\u0000\n\u0002\u0001\u0003\u0002\u0000\u0001\u000f\u0001\u0000\u0001\u000e\u0001\u0000\u001a\u0001\u0001\u0000\u0001\n\u0002\u0000\u0001\u0001\u0001\f\u0001\u0010\u0001\u001a\u0001#\u0001\u0011\u0001\u0014\u0001\u0015\u0001!\u0001$\u0001\u0016\u0001%\u0001\u0001\u0001\u001d\u0001\u001c\u0001\u001b\u0001 \u0001\u0012\u0001&\u0001\u0013\u0001\u0018\u0001\u001e\u0001\u0019\u0001\u0001\u0001\"\u0001\u0017\u0002\u0001\u0001\u0005\u0001\u0000\u0001(\uff82\u0000");
        ZZ_ACTION = zzUnpackAction();
        ZZ_ROWMAP = zzUnpackRowMap();
        ZZ_TRANS = zzUnpackTrans();
        ZZ_ERROR_MSG = new String[] { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
        ZZ_ATTRIBUTE = zzUnpackAttribute();
    }
}
