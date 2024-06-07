//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.modes;

import javax.swing.text.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.io.*;

public class CsvTokenMaker extends AbstractJFlexCTokenMaker
{
    public static final int YYEOF = -1;
    public static final int STRING = 1;
    public static final int YYINITIAL = 0;
    private static final String ZZ_CMAP_PACKED = "\n\u0000\u0001\u0003\u0017\u0000\u0001\u0001\t\u0000\u0001\u0002\uffd3\u0000";
    private static final char[] ZZ_CMAP;
    private static final int[] ZZ_ACTION;
    private static final String ZZ_ACTION_PACKED_0 = "\u0002\u0000\u0001\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0005";
    private static final int[] ZZ_ROWMAP;
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000\u0004\u0000\b\u0000\f\u0000\f\u0000\f\u0000\u0010\u0000\u0014\u0000\f\u0000\f";
    private static final int[] ZZ_TRANS;
    private static final String ZZ_TRANS_PACKED_0 = "\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\u0007\u0001\t\u0001\u0003\u0007\u0000\u0001\u0007\u0001\u0000\u0001\u0007\u0002\u0000\u0001\n\u0002\u0000";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_ATTRIBUTE;
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0002\u0000\u0001\u0001\u0003\t\u0002\u0001\u0002\t";
    private Reader zzReader;
    private int zzState;
    private int zzLexicalState;
    private char[] zzBuffer;
    private int zzMarkedPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private boolean zzAtEOF;
    public static final int INTERNAL_STRING = -2048;
    private int evenOdd;
    
    private static int[] zzUnpackAction() {
        final int[] result = new int[10];
        int offset = 0;
        offset = zzUnpackAction("\u0002\u0000\u0001\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0005", offset, result);
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
        final int[] result = new int[10];
        int offset = 0;
        offset = zzUnpackRowMap("\u0000\u0000\u0000\u0004\u0000\b\u0000\f\u0000\f\u0000\f\u0000\u0010\u0000\u0014\u0000\f\u0000\f", offset, result);
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
        final int[] result = new int[24];
        int offset = 0;
        offset = zzUnpackTrans("\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\u0007\u0001\t\u0001\u0003\u0007\u0000\u0001\u0007\u0001\u0000\u0001\u0007\u0002\u0000\u0001\n\u0002\u0000", offset, result);
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
        final int[] result = new int[10];
        int offset = 0;
        offset = zzUnpackAttribute("\u0002\u0000\u0001\u0001\u0003\t\u0002\u0001\u0002\t", offset, result);
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
    
    public CsvTokenMaker() {
        this.zzLexicalState = 0;
    }
    
    private void addEndToken(final int tokenType) {
        this.addToken(this.zzMarkedPos, this.zzMarkedPos, tokenType);
    }
    
    private void addEvenOrOddColumnToken() {
        this.addEvenOrOddColumnToken(this.zzStartRead, this.zzMarkedPos - 1);
    }
    
    private void addEvenOrOddColumnToken(final int start, final int end) {
        this.addToken(start, end, (this.evenOdd == 0) ? 20 : 16);
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
    
    public int getClosestStandardTokenTypeForInternalType(final int type) {
        return (type == -2048) ? 13 : type;
    }
    
    public boolean getMarkOccurrencesOfTokenType(final int type) {
        return type == 20 || type == 16;
    }
    
    public Token getTokenList(final Segment text, final int initialTokenType, final int startOffset) {
        this.resetTokenList();
        this.offsetShift = -text.offset + startOffset;
        int state = 0;
        this.evenOdd = 0;
        if (initialTokenType < -1024) {
            state = 1;
            this.evenOdd = (initialTokenType & 0x1);
            this.start = text.offset;
        }
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
    
    public boolean isIdentifierChar(final int languageIndex, final char ch) {
        return Character.isLetterOrDigit(ch) || ch == '-' || ch == '.' || ch == '_';
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
    
    public CsvTokenMaker(final Reader in) {
        this.zzLexicalState = 0;
        this.zzReader = in;
    }
    
    public CsvTokenMaker(final InputStream in) {
        this(new InputStreamReader(in));
    }
    
    private static char[] zzUnpackCMap(final String packed) {
        final char[] map = new char[65536];
        int i = 0;
        int j = 0;
        while (i < 14) {
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
            message = CsvTokenMaker.ZZ_ERROR_MSG[errorCode];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            message = CsvTokenMaker.ZZ_ERROR_MSG[0];
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
        final char[] zzCMapL = CsvTokenMaker.ZZ_CMAP;
        final int[] zzTransL = CsvTokenMaker.ZZ_TRANS;
        final int[] zzRowMapL = CsvTokenMaker.ZZ_ROWMAP;
        final int[] zzAttrL = CsvTokenMaker.ZZ_ATTRIBUTE;
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
            switch ((zzAction < 0) ? zzAction : CsvTokenMaker.ZZ_ACTION[zzAction]) {
                case 6: {
                    this.yybegin(0);
                    this.addEvenOrOddColumnToken(this.start, this.zzStartRead);
                }
                case 8: {
                    continue;
                }
                case 4: {
                    this.addNullToken();
                    return this.firstToken;
                }
                case 9: {
                    continue;
                }
                case 7: {
                    this.addEvenOrOddColumnToken(this.start, this.zzEndRead);
                    this.addEndToken(0xFFFFF800 | this.evenOdd);
                    return this.firstToken;
                }
                case 10: {
                    continue;
                }
                case 3: {
                    this.addToken(23);
                    this.evenOdd = (this.evenOdd + 1 & 0x1);
                }
                case 11: {
                    continue;
                }
                case 1: {
                    this.addEvenOrOddColumnToken();
                }
                case 12: {
                    continue;
                }
                case 2: {
                    this.start = this.zzMarkedPos - 1;
                    this.yybegin(1);
                }
                case 13: {
                    continue;
                }
                case 5:
                case 14: {
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
                            this.addEvenOrOddColumnToken(this.start, this.zzEndRead);
                            this.addEndToken(0xFFFFF800 | this.evenOdd);
                            return this.firstToken;
                        }
                        case 11: {
                            continue;
                        }
                        case 0: {
                            this.addNullToken();
                            return this.firstToken;
                        }
                        case 12: {
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
        ZZ_CMAP = zzUnpackCMap("\n\u0000\u0001\u0003\u0017\u0000\u0001\u0001\t\u0000\u0001\u0002\uffd3\u0000");
        ZZ_ACTION = zzUnpackAction();
        ZZ_ROWMAP = zzUnpackRowMap();
        ZZ_TRANS = zzUnpackTrans();
        ZZ_ERROR_MSG = new String[] { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
        ZZ_ATTRIBUTE = zzUnpackAttribute();
    }
}
