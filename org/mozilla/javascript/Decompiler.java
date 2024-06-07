//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class Decompiler
{
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int INDENT_GAP_PROP = 2;
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 171;
    private char[] sourceBuffer;
    private int sourceTop;
    private static final boolean printSource = false;
    
    public Decompiler() {
        this.sourceBuffer = new char[128];
    }
    
    String getEncodedSource() {
        return this.sourceToString(0);
    }
    
    int getCurrentOffset() {
        return this.sourceTop;
    }
    
    int markFunctionStart(final int functionType) {
        final int savedOffset = this.getCurrentOffset();
        if (functionType != 4) {
            this.addToken(114);
            this.append((char)functionType);
        }
        return savedOffset;
    }
    
    int markFunctionEnd(final int functionStart) {
        final int offset = this.getCurrentOffset();
        this.append('«');
        return offset;
    }
    
    void addToken(final int token) {
        if (0 > token || token > 170) {
            throw new IllegalArgumentException();
        }
        this.append((char)token);
    }
    
    void addEOL(final int token) {
        if (0 > token || token > 170) {
            throw new IllegalArgumentException();
        }
        this.append((char)token);
        this.append('\u0001');
    }
    
    void addName(final String str) {
        this.addToken(40);
        this.appendString(str);
    }
    
    void addString(final String str) {
        this.addToken(42);
        this.appendString(str);
    }
    
    void addRegexp(final String regexp, final String flags) {
        this.addToken(51);
        this.appendString('/' + regexp + '/' + flags);
    }
    
    void addNumber(final double n) {
        this.addToken(41);
        long lbits = (long)n;
        if (lbits != n) {
            lbits = Double.doubleToLongBits(n);
            this.append('D');
            this.append((char)(lbits >> 48));
            this.append((char)(lbits >> 32));
            this.append((char)(lbits >> 16));
            this.append((char)lbits);
        }
        else {
            if (lbits < 0L) {
                Kit.codeBug();
            }
            if (lbits <= 65535L) {
                this.append('S');
                this.append((char)lbits);
            }
            else {
                this.append('J');
                this.append((char)(lbits >> 48));
                this.append((char)(lbits >> 32));
                this.append((char)(lbits >> 16));
                this.append((char)lbits);
            }
        }
    }
    
    private void appendString(final String str) {
        final int L = str.length();
        int lengthEncodingSize = 1;
        if (L >= 32768) {
            lengthEncodingSize = 2;
        }
        final int nextTop = this.sourceTop + lengthEncodingSize + L;
        if (nextTop > this.sourceBuffer.length) {
            this.increaseSourceCapacity(nextTop);
        }
        if (L >= 32768) {
            this.sourceBuffer[this.sourceTop] = (char)(0x8000 | L >>> 16);
            ++this.sourceTop;
        }
        this.sourceBuffer[this.sourceTop] = (char)L;
        ++this.sourceTop;
        str.getChars(0, L, this.sourceBuffer, this.sourceTop);
        this.sourceTop = nextTop;
    }
    
    private void append(final char c) {
        if (this.sourceTop == this.sourceBuffer.length) {
            this.increaseSourceCapacity(this.sourceTop + 1);
        }
        this.sourceBuffer[this.sourceTop] = c;
        ++this.sourceTop;
    }
    
    private void increaseSourceCapacity(final int minimalCapacity) {
        if (minimalCapacity <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        int newCapacity = this.sourceBuffer.length * 2;
        if (newCapacity < minimalCapacity) {
            newCapacity = minimalCapacity;
        }
        final char[] tmp = new char[newCapacity];
        System.arraycopy(this.sourceBuffer, 0, tmp, 0, this.sourceTop);
        this.sourceBuffer = tmp;
    }
    
    private String sourceToString(final int offset) {
        if (offset < 0 || this.sourceTop < offset) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, offset, this.sourceTop - offset);
    }
    
    public static String decompile(final String source, final int flags, final UintMap properties) {
        final int length = source.length();
        if (length == 0) {
            return "";
        }
        int indent = properties.getInt(1, 0);
        if (indent < 0) {
            throw new IllegalArgumentException();
        }
        final int indentGap = properties.getInt(2, 4);
        if (indentGap < 0) {
            throw new IllegalArgumentException();
        }
        final int caseGap = properties.getInt(3, 2);
        if (caseGap < 0) {
            throw new IllegalArgumentException();
        }
        final StringBuilder result = new StringBuilder();
        final boolean justFunctionBody = 0x0 != (flags & 0x1);
        final boolean toSource = 0x0 != (flags & 0x2);
        int braceNesting = 0;
        boolean afterFirstEOL = false;
        int i = 0;
        int topFunctionType;
        if (source.charAt(i) == '\u0092') {
            ++i;
            topFunctionType = -1;
        }
        else {
            topFunctionType = source.charAt(i + 1);
        }
        if (!toSource) {
            result.append('\n');
            for (int j = 0; j < indent; ++j) {
                result.append(' ');
            }
        }
        else if (topFunctionType == 2) {
            result.append('(');
        }
        while (i < length) {
            switch (source.charAt(i)) {
                case '\u009c':
                case '\u009d':
                case '¨': {
                    if (source.charAt(i) == '\u009c') {
                        result.append("get ");
                    }
                    else if (source.charAt(i) == '\u009d') {
                        result.append("set ");
                    }
                    ++i;
                    i = printSourceString(source, i + 1, false, result);
                    ++i;
                    break;
                }
                case '(':
                case '3': {
                    i = printSourceString(source, i + 1, false, result);
                    continue;
                }
                case '*': {
                    i = printSourceString(source, i + 1, true, result);
                    continue;
                }
                case ')': {
                    i = printSourceNumber(source, i + 1, result);
                    continue;
                }
                case '0': {
                    result.append("true");
                    break;
                }
                case '/': {
                    result.append("false");
                    break;
                }
                case '-': {
                    result.append("null");
                    break;
                }
                case '.': {
                    result.append("this");
                    break;
                }
                case 'r': {
                    ++i;
                    result.append("function ");
                    break;
                }
                case '«': {
                    break;
                }
                case 's': {
                    result.append("class ");
                    break;
                }
                case 't': {
                    result.append("extends ");
                    break;
                }
                case 'u': {
                    result.append("static ");
                    break;
                }
                case 'v': {
                    result.append("super");
                    break;
                }
                case 'V': {
                    result.append(", ");
                    break;
                }
                case 'R': {
                    ++braceNesting;
                    if (1 == getNext(source, length, i)) {
                        indent += indentGap;
                    }
                    result.append('{');
                    break;
                }
                case 'S': {
                    --braceNesting;
                    if (justFunctionBody && braceNesting == 0) {
                        break;
                    }
                    result.append('}');
                    switch (getNext(source, length, i)) {
                        case 1:
                        case 171: {
                            indent -= indentGap;
                            break;
                        }
                        case 122:
                        case 126: {
                            indent -= indentGap;
                            result.append(' ');
                            break;
                        }
                    }
                    break;
                }
                case 'T': {
                    result.append('(');
                    break;
                }
                case 'U': {
                    result.append(')');
                    if (82 == getNext(source, length, i)) {
                        result.append(' ');
                        break;
                    }
                    break;
                }
                case 'P': {
                    result.append('[');
                    break;
                }
                case 'Q': {
                    result.append(']');
                    break;
                }
                case '\u0001': {
                    if (toSource) {
                        break;
                    }
                    boolean newLine = true;
                    if (!afterFirstEOL) {
                        afterFirstEOL = true;
                        if (justFunctionBody) {
                            result.setLength(0);
                            indent -= indentGap;
                            newLine = false;
                        }
                    }
                    if (newLine) {
                        result.append('\n');
                    }
                    if (i + 1 < length) {
                        int less = 0;
                        final int nextToken = source.charAt(i + 1);
                        if (nextToken == 124 || nextToken == 125) {
                            less = indentGap - caseGap;
                        }
                        else if (nextToken == 83) {
                            less = indentGap;
                        }
                        else if (nextToken == 40) {
                            final int afterName = getSourceStringEnd(source, i + 2);
                            if (source.charAt(afterName) == 'h') {
                                less = indentGap;
                            }
                        }
                        while (less < indent) {
                            result.append(' ');
                            ++less;
                        }
                        break;
                    }
                    break;
                }
                case 'm': {
                    result.append('.');
                    break;
                }
                case 'o': {
                    result.append("?.");
                    break;
                }
                case 'ª': {
                    result.append("#");
                    break;
                }
                case 'n': {
                    result.append("...");
                    break;
                }
                case 'q': {
                    result.append(" ?? ");
                    break;
                }
                case 'p': {
                    result.append(" |> ");
                    break;
                }
                case '+': {
                    result.append("`");
                    break;
                }
                case ',': {
                    result.append("${");
                    break;
                }
                case '\u001f': {
                    result.append("new ");
                    break;
                }
                case ' ': {
                    result.append("delete ");
                    break;
                }
                case 'y': {
                    result.append("if ");
                    break;
                }
                case 'z': {
                    result.append("else ");
                    break;
                }
                case '\u0080': {
                    result.append("for ");
                    break;
                }
                case '7': {
                    result.append(" in ");
                    break;
                }
                case '\u0084': {
                    result.append("with ");
                    break;
                }
                case '~': {
                    result.append("while ");
                    break;
                }
                case '\u007f': {
                    result.append("do ");
                    break;
                }
                case 'N': {
                    result.append("try ");
                    break;
                }
                case '\u0085': {
                    result.append("catch ");
                    break;
                }
                case '\u0086': {
                    result.append("finally ");
                    break;
                }
                case '5': {
                    result.append("throw ");
                    break;
                }
                case '{': {
                    result.append("switch ");
                    break;
                }
                case '\u0081': {
                    result.append("break");
                    if (40 == getNext(source, length, i)) {
                        result.append(' ');
                        break;
                    }
                    break;
                }
                case '\u0082': {
                    result.append("continue");
                    if (40 == getNext(source, length, i)) {
                        result.append(' ');
                        break;
                    }
                    break;
                }
                case '|': {
                    result.append("case ");
                    break;
                }
                case '}': {
                    result.append("default");
                    break;
                }
                case '\u0004': {
                    result.append("return");
                    if (79 != getNext(source, length, i)) {
                        result.append(' ');
                        break;
                    }
                    break;
                }
                case '\u0083': {
                    result.append("var ");
                    break;
                }
                case '\u009e': {
                    result.append("let ");
                    break;
                }
                case 'O': {
                    result.append(';');
                    if (1 != getNext(source, length, i)) {
                        result.append(' ');
                        break;
                    }
                    break;
                }
                case 'W': {
                    result.append(" = ");
                    break;
                }
                case '^': {
                    result.append(" += ");
                    break;
                }
                case '_': {
                    result.append(" -= ");
                    break;
                }
                case '`': {
                    result.append(" *= ");
                    break;
                }
                case 'a': {
                    result.append(" /= ");
                    break;
                }
                case 'b': {
                    result.append(" %= ");
                    break;
                }
                case 'c': {
                    result.append(" **= ");
                    break;
                }
                case 'X': {
                    result.append(" |= ");
                    break;
                }
                case 'Y': {
                    result.append(" ^= ");
                    break;
                }
                case 'Z': {
                    result.append(" &= ");
                    break;
                }
                case '[': {
                    result.append(" <<= ");
                    break;
                }
                case '\\': {
                    result.append(" >>= ");
                    break;
                }
                case ']': {
                    result.append(" >>>= ");
                    break;
                }
                case 'd': {
                    result.append(" ||= ");
                    break;
                }
                case 'e': {
                    result.append(" &&=");
                    break;
                }
                case 'f': {
                    result.append(" ??= ");
                    break;
                }
                case 'g': {
                    result.append(" ? ");
                    break;
                }
                case 'F': {
                    result.append(": ");
                    break;
                }
                case 'h': {
                    if (1 == getNext(source, length, i)) {
                        result.append(':');
                        break;
                    }
                    result.append(" : ");
                    break;
                }
                case 'i': {
                    result.append(" || ");
                    break;
                }
                case 'j': {
                    result.append(" && ");
                    break;
                }
                case '\t': {
                    result.append(" | ");
                    break;
                }
                case '\n': {
                    result.append(" ^ ");
                    break;
                }
                case '\u000b': {
                    result.append(" & ");
                    break;
                }
                case '1': {
                    result.append(" === ");
                    break;
                }
                case '2': {
                    result.append(" !== ");
                    break;
                }
                case '\f': {
                    result.append(" == ");
                    break;
                }
                case '\r': {
                    result.append(" != ");
                    break;
                }
                case '\u000f': {
                    result.append(" <= ");
                    break;
                }
                case '\u000e': {
                    result.append(" < ");
                    break;
                }
                case '\u0011': {
                    result.append(" >= ");
                    break;
                }
                case '\u0010': {
                    result.append(" > ");
                    break;
                }
                case '8': {
                    result.append(" instanceof ");
                    break;
                }
                case '\u0012': {
                    result.append(" << ");
                    break;
                }
                case '\u0013': {
                    result.append(" >> ");
                    break;
                }
                case '\u0014': {
                    result.append(" >>> ");
                    break;
                }
                case '!': {
                    result.append("typeof ");
                    break;
                }
                case '\u0088': {
                    result.append("void ");
                    break;
                }
                case '\u009f': {
                    result.append("const ");
                    break;
                }
                case 'L': {
                    result.append("yield ");
                    break;
                }
                case '\u001b': {
                    result.append('!');
                    break;
                }
                case '\u001c': {
                    result.append('~');
                    break;
                }
                case '\u001d': {
                    result.append('+');
                    break;
                }
                case '\u001e': {
                    result.append('-');
                    break;
                }
                case 'k': {
                    result.append("++");
                    break;
                }
                case 'l': {
                    result.append("--");
                    break;
                }
                case '\u0015': {
                    result.append(" + ");
                    break;
                }
                case '\u0016': {
                    result.append(" - ");
                    break;
                }
                case '\u0017': {
                    result.append(" * ");
                    break;
                }
                case '\u001a': {
                    result.append(" ** ");
                    break;
                }
                case '\u0018': {
                    result.append(" / ");
                    break;
                }
                case '\u0019': {
                    result.append(" % ");
                    break;
                }
                case '\u0099': {
                    result.append('@');
                    break;
                }
                case '¥': {
                    result.append("debugger;\n");
                    break;
                }
                case '©': {
                    result.append(" => ");
                    break;
                }
                case '\b': {
                    break;
                }
                default: {
                    throw new RuntimeException("Token: " + Token.name(source.charAt(i)));
                }
            }
            ++i;
        }
        if (!toSource) {
            if (!justFunctionBody) {
                result.append('\n');
            }
        }
        else if (topFunctionType == 2) {
            result.append(')');
        }
        return result.toString();
    }
    
    private static int getNext(final String source, final int length, final int i) {
        return (i + 1 < length) ? source.charAt(i + 1) : '\0';
    }
    
    private static int getSourceStringEnd(final String source, final int offset) {
        return printSourceString(source, offset, false, null);
    }
    
    public static int printSourceString(final String source, int offset, final boolean asQuotedString, final StringBuilder sb) {
        int length = source.charAt(offset);
        ++offset;
        if ((0x8000 & length) != 0x0) {
            length = ((0x7FFF & length) << 16 | source.charAt(offset));
            ++offset;
        }
        if (sb != null) {
            final String str = source.substring(offset, offset + length);
            if (!asQuotedString) {
                sb.append(str);
            }
            else {
                sb.append('\"');
                sb.append(ScriptRuntime.escapeString(str));
                sb.append('\"');
            }
        }
        return offset + length;
    }
    
    private static int printSourceNumber(final String source, int offset, final StringBuilder sb) {
        double number = 0.0;
        final char type = source.charAt(offset);
        ++offset;
        if (type == 'S') {
            if (sb != null) {
                final int ival = source.charAt(offset);
                number = ival;
            }
            ++offset;
        }
        else {
            if (type != 'J' && type != 'D') {
                throw new RuntimeException();
            }
            if (sb != null) {
                long lbits = (long)source.charAt(offset) << 48;
                lbits |= (long)source.charAt(offset + 1) << 32;
                lbits |= (long)source.charAt(offset + 2) << 16;
                lbits |= source.charAt(offset + 3);
                if (type == 'J') {
                    number = (double)lbits;
                }
                else {
                    number = Double.longBitsToDouble(lbits);
                }
            }
            offset += 4;
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(number, 10));
        }
        return offset;
    }
}
