//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import org.mozilla.javascript.*;

public class NativeRegExp extends IdScriptableObject implements Function
{
    private static final long serialVersionUID = 4965263491464903264L;
    private static final Object REGEXP_TAG;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_MULTILINE = 4;
    public static final int JSREG_STICKY = 8;
    public static final int JSREG_UNICODE = 16;
    public static final int JSREG_DOTALL = 32;
    public static final int TEST = 0;
    public static final int MATCH = 1;
    public static final int PREFIX = 2;
    private static final boolean debug = false;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_END = 57;
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_lastIndex = 1;
    private static final int Id_source = 2;
    private static final int Id_global = 3;
    private static final int Id_ignoreCase = 4;
    private static final int Id_multiline = 5;
    private static final int Id_sticky = 6;
    private static final int Id_dotAll = 7;
    private static final int Id_flags = 8;
    private static final int MAX_INSTANCE_ID = 8;
    private static final int Id_compile = 1;
    private static final int Id_toString = 2;
    private static final int Id_toSource = 3;
    private static final int Id_exec = 4;
    private static final int Id_test = 5;
    private static final int Id_prefix = 6;
    private static final int MAX_PROTOTYPE_ID = 6;
    private RECompiled re;
    Object lastIndex;
    private int lastIndexAttr;
    public boolean isInstance;
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeRegExp proto = new NativeRegExp();
        proto.re = compileRE(cx, "", null, false);
        proto.activatePrototypeMap(6);
        proto.setParentScope(scope);
        proto.setPrototype(getObjectPrototype(scope));
        final NativeRegExpCtor ctor = new NativeRegExpCtor();
        proto.defineProperty("constructor", (Object)ctor, 2);
        ScriptRuntime.setFunctionProtoAndParent(ctor, scope);
        ctor.setImmunePrototypeProperty((Object)proto);
        if (sealed) {
            proto.sealObject();
            ctor.sealObject();
        }
        defineProperty(scope, "RegExp", (Object)ctor, 2);
    }
    
    NativeRegExp(final Scriptable scope, final RECompiled regexpCompiled) {
        this.lastIndex = 0.0;
        this.lastIndexAttr = 6;
        this.isInstance = false;
        this.re = regexpCompiled;
        this.lastIndex = 0.0;
        ScriptRuntime.setBuiltinProtoAndParent((ScriptableObject)this, scope, TopLevel.Builtins.RegExp);
    }
    
    public String getClassName() {
        return "RegExp";
    }
    
    public String getTypeOf() {
        return "object";
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return this.execSub(cx, scope, args, 1);
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        return (Scriptable)this.execSub(cx, scope, args, 1);
    }
    
    Scriptable compile(final Context cx, final Scriptable scope, final Object[] args) {
        if (args.length > 0 && args[0] instanceof NativeRegExp) {
            final NativeRegExp thatObj = (NativeRegExp)args[0];
            if (args.length > 1 && args[1] != Undefined.instance) {
                final String flags = ScriptRuntime.toString(args[1]);
                thatObj.setFlags(parseREFlags(flags));
            }
            this.re = thatObj.re;
            this.lastIndex = thatObj.lastIndex;
            return (Scriptable)this;
        }
        final String s = (args.length == 0 || args[0] instanceof Undefined) ? "" : escapeRegExp(args[0]);
        final String global = (args.length > 1 && args[1] != Undefined.instance) ? ScriptRuntime.toString(args[1]) : null;
        this.re = compileRE(cx, s, global, false);
        this.lastIndex = 0.0;
        return (Scriptable)this;
    }
    
    public String toString() {
        return toString(new String(this.re.source), flagsToString(this.re.flags));
    }
    
    NativeRegExp() {
        this.lastIndex = 0.0;
        this.lastIndexAttr = 6;
        this.isInstance = false;
    }
    
    private static RegExpImpl getImpl(final Context cx) {
        return (RegExpImpl)ScriptRuntime.getRegExpProxy(cx);
    }
    
    private static String escapeRegExp(final Object src) {
        String s = ScriptRuntime.toString(src);
        StringBuilder sb = null;
        int start = 0;
        for (int slash = s.indexOf(47); slash > -1; slash = s.indexOf(47, slash + 1)) {
            if (slash == start || s.charAt(slash - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(s, start, slash);
                sb.append("\\/");
                start = slash + 1;
            }
        }
        if (sb != null) {
            sb.append(s, start, s.length());
            s = sb.toString();
        }
        return s;
    }
    
    private Object execSub(final Context cx, final Scriptable scopeObj, final Object[] args, final int matchType) {
        final RegExpImpl reImpl = getImpl(cx);
        String str;
        if (args.length == 0) {
            str = reImpl.input;
            if (str == null) {
                str = ScriptRuntime.toString(Undefined.instance);
            }
        }
        else {
            str = ScriptRuntime.toString(args[0]);
        }
        double d = 0.0;
        if ((this.re.flags & 0x1) != 0x0 || (this.re.flags & 0x8) != 0x0) {
            d = ScriptRuntime.toInteger(this.lastIndex);
        }
        Object rval;
        if (d < 0.0 || str.length() < d) {
            this.lastIndex = 0.0;
            rval = null;
        }
        else {
            final int[] indexp = { (int)d };
            rval = this.executeRegExp(cx, scopeObj, reImpl, str, indexp, matchType);
            if ((this.re.flags & 0x1) != 0x0 || (this.re.flags & 0x8) != 0x0) {
                this.lastIndex = ((rval == null || rval == Undefined.instance) ? 0.0 : indexp[0]);
            }
        }
        return rval;
    }
    
    private static String toString(final String source, final String flags) {
        final StringBuilder buf = new StringBuilder();
        buf.append('/');
        if (source.length() != 0) {
            buf.append(source);
        }
        else {
            buf.append("(?:)");
        }
        buf.append('/');
        buf.append(flags);
        return buf.toString();
    }
    
    private static String flagsToString(final int flags) {
        final StringBuilder buf = new StringBuilder();
        if ((flags & 0x1) != 0x0) {
            buf.append('g');
        }
        if ((flags & 0x2) != 0x0) {
            buf.append('i');
        }
        if ((flags & 0x4) != 0x0) {
            buf.append('m');
        }
        if ((flags & 0x8) != 0x0) {
            buf.append('y');
        }
        if ((flags & 0x20) != 0x0) {
            buf.append('s');
        }
        if ((flags & 0x10) != 0x0) {
            buf.append('u');
        }
        return buf.toString();
    }
    
    private static int parseREFlags(final String descriptor) {
        int flags = 0;
        for (int i = 0; i < descriptor.length(); ++i) {
            final char c = descriptor.charAt(i);
            int f = 0;
            if (c == 'g') {
                f = 1;
            }
            else if (c == 'i') {
                f = 2;
            }
            else if (c == 'm') {
                f = 4;
            }
            else if (c == 'y') {
                f = 8;
            }
            else if (c == 's') {
                f = 32;
            }
            else {
                reportError("msg.invalid.re.flag", String.valueOf(c));
            }
            if ((flags & f) != 0x0) {
                reportError("msg.invalid.re.flag", String.valueOf(c));
            }
            flags |= f;
        }
        return flags;
    }
    
    static RECompiled compileRE(final Context cx, final String str, final String global, final boolean flat) {
        final RECompiled regexp = new RECompiled(str);
        final int length = str.length();
        int flags = 0;
        if (global != null) {
            flags = parseREFlags(global);
            regexp.flags = flags;
        }
        CompilerState state = new CompilerState(cx, regexp.source, length, flags);
        if (flat && length > 0) {
            state.result = new RENode((byte)14);
            state.result.chr = state.cpbegin[0];
            state.result.length = length;
            state.result.flatIndex = 0;
            final CompilerState compilerState = state;
            compilerState.progLength += 5;
        }
        else {
            if (!parseDisjunction(state)) {
                return null;
            }
            if (state.maxBackReference > state.parenCount) {
                state = new CompilerState(cx, regexp.source, length, flags);
                state.backReferenceLimit = state.parenCount;
                if (!parseDisjunction(state)) {
                    return null;
                }
            }
        }
        regexp.program = new byte[state.progLength + 1];
        if (state.classCount != 0) {
            regexp.classList = new RECharSet[state.classCount];
            regexp.classCount = state.classCount;
        }
        int endPC = emitREBytecode(state, regexp, 0, state.result);
        regexp.program[endPC++] = 57;
        regexp.parenCount = state.parenCount;
        switch (regexp.program[0]) {
            case 18:
            case 19: {
                regexp.anchorCh = (char)getIndex(regexp.program, 1);
                break;
            }
            case 15:
            case 17: {
                regexp.anchorCh = (char)(regexp.program[1] & 0xFF);
                break;
            }
            case 14:
            case 16: {
                final int k = getIndex(regexp.program, 1);
                regexp.anchorCh = regexp.source[k];
                break;
            }
            case 2: {
                regexp.anchorCh = -2;
                break;
            }
            case 31: {
                final RENode n = state.result;
                if (n.kid.op == 2 && n.kid2.op == 2) {
                    regexp.anchorCh = -2;
                    break;
                }
                break;
            }
        }
        return regexp;
    }
    
    static boolean isDigit(final char c) {
        return '0' <= c && c <= '9';
    }
    
    private static boolean isWord(final char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
    }
    
    private static boolean isControlLetter(final char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
    
    private static boolean isLineTerm(final char c) {
        return ScriptRuntime.isJSLineTerminator(c);
    }
    
    private static boolean isREWhiteSpace(final int c) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(c);
    }
    
    private static char upcase(final char ch) {
        if (ch >= '\u0080') {
            final char cu = Character.toUpperCase(ch);
            return (cu < '\u0080') ? ch : cu;
        }
        if ('a' <= ch && ch <= 'z') {
            return (char)(ch - 32);
        }
        return ch;
    }
    
    private static char downcase(final char ch) {
        if (ch >= '\u0080') {
            final char cl = Character.toLowerCase(ch);
            return (cl < '\u0080') ? ch : cl;
        }
        if ('A' <= ch && ch <= 'Z') {
            return (char)(ch + ' ');
        }
        return ch;
    }
    
    private static int toASCIIHexDigit(int c) {
        if (c < 48) {
            return -1;
        }
        if (c <= 57) {
            return c - 48;
        }
        c |= 0x20;
        if (97 <= c && c <= 102) {
            return c - 97 + 10;
        }
        return -1;
    }
    
    private static boolean parseDisjunction(final CompilerState state) {
        if (!parseAlternative(state)) {
            return false;
        }
        final char[] source = state.cpbegin;
        final int index = state.cp;
        if (index != source.length && source[index] == '|') {
            ++state.cp;
            final RENode result = new RENode((byte)31);
            result.kid = state.result;
            if (!parseDisjunction(state)) {
                return false;
            }
            result.kid2 = state.result;
            state.result = result;
            if (result.kid.op == 14 && result.kid2.op == 14) {
                result.op = (byte)(((state.flags & 0x2) == 0x0) ? 53 : 54);
                result.chr = result.kid.chr;
                result.index = result.kid2.chr;
                state.progLength += 13;
            }
            else if (result.kid.op == 22 && result.kid.index < 256 && result.kid2.op == 14 && (state.flags & 0x2) == 0x0) {
                result.op = 55;
                result.chr = result.kid2.chr;
                result.index = result.kid.index;
                state.progLength += 13;
            }
            else if (result.kid.op == 14 && result.kid2.op == 22 && result.kid2.index < 256 && (state.flags & 0x2) == 0x0) {
                result.op = 55;
                result.chr = result.kid.chr;
                result.index = result.kid2.index;
                state.progLength += 13;
            }
            else {
                state.progLength += 9;
            }
        }
        return true;
    }
    
    private static boolean parseAlternative(final CompilerState state) {
        RENode headTerm = null;
        RENode tailTerm = null;
        final char[] source = state.cpbegin;
        while (state.cp != state.cpend && source[state.cp] != '|' && (state.parenNesting == 0 || source[state.cp] != ')')) {
            if (!parseTerm(state)) {
                return false;
            }
            if (headTerm == null) {
                headTerm = (tailTerm = state.result);
            }
            else {
                tailTerm.next = state.result;
            }
            while (tailTerm.next != null) {
                tailTerm = tailTerm.next;
            }
        }
        if (headTerm == null) {
            state.result = new RENode((byte)1);
        }
        else {
            state.result = headTerm;
        }
        return true;
    }
    
    private static boolean calculateBitmapSize(final CompilerState state, final RENode target, final char[] src, int index, final int end) {
        char rangeStart = '\0';
        int max = 0;
        boolean inRange = false;
        target.bmsize = 0;
        target.sense = true;
        if (index == end) {
            return true;
        }
        if (src[index] == '^') {
            ++index;
            target.sense = false;
        }
        while (index != end) {
            int localMax = 0;
            int nDigits = 2;
            Label_0712: {
                switch (src[index]) {
                    case '\\': {
                        ++index;
                        char c = src[index++];
                        switch (c) {
                            case 'b': {
                                localMax = 8;
                                break Label_0712;
                            }
                            case 'f': {
                                localMax = 12;
                                break Label_0712;
                            }
                            case 'n': {
                                localMax = 10;
                                break Label_0712;
                            }
                            case 'r': {
                                localMax = 13;
                                break Label_0712;
                            }
                            case 't': {
                                localMax = 9;
                                break Label_0712;
                            }
                            case 'v': {
                                localMax = 11;
                                break Label_0712;
                            }
                            case 'c': {
                                if (index < end && isControlLetter(src[index])) {
                                    localMax = (char)(src[index++] & '\u001f');
                                }
                                else {
                                    --index;
                                }
                                localMax = 92;
                                break Label_0712;
                            }
                            case 'u': {
                                nDigits += 2;
                            }
                            case 'x': {
                                int n = 0;
                                for (int i = 0; i < nDigits && index < end; ++i) {
                                    c = src[index++];
                                    n = Kit.xDigitToInt((int)c, n);
                                    if (n < 0) {
                                        index -= i + 1;
                                        n = 92;
                                        break;
                                    }
                                }
                                localMax = n;
                                break Label_0712;
                            }
                            case 'd': {
                                if (inRange) {
                                    reportError("msg.bad.range", "");
                                    return false;
                                }
                                localMax = 57;
                                break Label_0712;
                            }
                            case 'D':
                            case 'S':
                            case 'W':
                            case 's':
                            case 'w': {
                                if (inRange) {
                                    reportError("msg.bad.range", "");
                                    return false;
                                }
                                target.bmsize = 65536;
                                return true;
                            }
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7': {
                                int n = c - '0';
                                c = src[index];
                                if ('0' <= c && c <= '7') {
                                    ++index;
                                    n = 8 * n + (c - '0');
                                    c = src[index];
                                    if ('0' <= c && c <= '7') {
                                        ++index;
                                        final int i = 8 * n + (c - '0');
                                        if (i <= 255) {
                                            n = i;
                                        }
                                        else {
                                            --index;
                                        }
                                    }
                                }
                                localMax = n;
                                break Label_0712;
                            }
                            default: {
                                localMax = c;
                                break Label_0712;
                            }
                        }
                        break;
                    }
                    default: {
                        localMax = src[index++];
                        break;
                    }
                }
            }
            if (inRange) {
                if (rangeStart > localMax) {
                    reportError("msg.bad.range", "");
                    return false;
                }
                inRange = false;
            }
            else if (index < end - 1 && src[index] == '-') {
                ++index;
                inRange = true;
                rangeStart = (char)localMax;
                continue;
            }
            if ((state.flags & 0x2) != 0x0) {
                final char cu = upcase((char)localMax);
                final char cd = downcase((char)localMax);
                localMax = ((cu >= cd) ? cu : cd);
            }
            if (localMax > max) {
                max = localMax;
            }
        }
        target.bmsize = max + 1;
        return true;
    }
    
    private static void doFlat(final CompilerState state, final char c) {
        state.result = new RENode((byte)14);
        state.result.chr = c;
        state.result.length = 1;
        state.result.flatIndex = -1;
        state.progLength += 3;
    }
    
    private static int getDecimalValue(char c, final CompilerState state, final int maxValue, final String overflowMessageId) {
        boolean overflow = false;
        final int start = state.cp;
        final char[] src = state.cpbegin;
        int value = c - '0';
        while (state.cp != state.cpend) {
            c = src[state.cp];
            if (!isDigit(c)) {
                break;
            }
            if (!overflow) {
                final int v = value * 10 + (c - '0');
                if (v < maxValue) {
                    value = v;
                }
                else {
                    overflow = true;
                    value = maxValue;
                }
            }
            ++state.cp;
        }
        if (overflow) {
            reportError(overflowMessageId, String.valueOf(src, start, state.cp - start));
        }
        return value;
    }
    
    private static boolean parseTerm(final CompilerState state) {
        final char[] src = state.cpbegin;
        char c = src[state.cp++];
        int nDigits = 2;
        final int parenBaseCount = state.parenCount;
        Label_1837: {
            switch (c) {
                case '^': {
                    state.result = new RENode((byte)2);
                    ++state.progLength;
                    return true;
                }
                case '$': {
                    state.result = new RENode((byte)3);
                    ++state.progLength;
                    return true;
                }
                case '\\': {
                    if (state.cp >= state.cpend) {
                        reportError("msg.trail.backslash", "");
                        return false;
                    }
                    c = src[state.cp++];
                    switch (c) {
                        case 'b': {
                            state.result = new RENode((byte)4);
                            ++state.progLength;
                            return true;
                        }
                        case 'B': {
                            state.result = new RENode((byte)5);
                            ++state.progLength;
                            return true;
                        }
                        case '0': {
                            reportWarning(state.cx, "msg.bad.backref", "");
                            int num;
                            for (num = 0; num < 32 && state.cp < state.cpend; num = 8 * num + (c - '0')) {
                                c = src[state.cp];
                                if (c < '0' || c > '7') {
                                    break;
                                }
                                ++state.cp;
                            }
                            c = (char)num;
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9': {
                            final int termStart = state.cp - 1;
                            int num = getDecimalValue(c, state, 65535, "msg.overlarge.backref");
                            if (num > state.backReferenceLimit) {
                                reportWarning(state.cx, "msg.bad.backref", "");
                            }
                            if (num > state.backReferenceLimit) {
                                state.cp = termStart;
                                if (c >= '8') {
                                    c = '\\';
                                    doFlat(state, c);
                                    break Label_1837;
                                }
                                ++state.cp;
                                for (num = c - '0'; num < 32 && state.cp < state.cpend; num = 8 * num + (c - '0')) {
                                    c = src[state.cp];
                                    if (c < '0' || c > '7') {
                                        break;
                                    }
                                    ++state.cp;
                                }
                                c = (char)num;
                                doFlat(state, c);
                                break Label_1837;
                            }
                            else {
                                state.result = new RENode((byte)13);
                                state.result.parenIndex = num - 1;
                                state.progLength += 3;
                                if (state.maxBackReference < num) {
                                    state.maxBackReference = num;
                                    break Label_1837;
                                }
                                break Label_1837;
                            }
                            break;
                        }
                        case 'f': {
                            c = '\f';
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 'n': {
                            c = '\n';
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 'r': {
                            c = '\r';
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 't': {
                            c = '\t';
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 'v': {
                            c = '\u000b';
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 'c': {
                            if (state.cp < state.cpend && isControlLetter(src[state.cp])) {
                                c = (char)(src[state.cp++] & '\u001f');
                            }
                            else {
                                --state.cp;
                                c = '\\';
                            }
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 'u': {
                            nDigits += 2;
                        }
                        case 'x': {
                            int n = 0;
                            for (int i = 0; i < nDigits && state.cp < state.cpend; ++i) {
                                c = src[state.cp++];
                                n = Kit.xDigitToInt((int)c, n);
                                if (n < 0) {
                                    state.cp -= i + 2;
                                    n = src[state.cp++];
                                    break;
                                }
                            }
                            c = (char)n;
                            doFlat(state, c);
                            break Label_1837;
                        }
                        case 'd': {
                            state.result = new RENode((byte)7);
                            ++state.progLength;
                            break Label_1837;
                        }
                        case 'D': {
                            state.result = new RENode((byte)8);
                            ++state.progLength;
                            break Label_1837;
                        }
                        case 's': {
                            state.result = new RENode((byte)11);
                            ++state.progLength;
                            break Label_1837;
                        }
                        case 'S': {
                            state.result = new RENode((byte)12);
                            ++state.progLength;
                            break Label_1837;
                        }
                        case 'w': {
                            state.result = new RENode((byte)9);
                            ++state.progLength;
                            break Label_1837;
                        }
                        case 'W': {
                            state.result = new RENode((byte)10);
                            ++state.progLength;
                            break Label_1837;
                        }
                        default: {
                            state.result = new RENode((byte)14);
                            state.result.chr = c;
                            state.result.length = 1;
                            state.result.flatIndex = state.cp - 1;
                            state.progLength += 3;
                            break Label_1837;
                        }
                    }
                    break;
                }
                case '(': {
                    RENode result = null;
                    final int termStart = state.cp;
                    if (state.cp + 1 < state.cpend && src[state.cp] == '?' && ((c = src[state.cp + 1]) == '=' || c == '!' || c == ':')) {
                        state.cp += 2;
                        if (c == '=') {
                            result = new RENode((byte)41);
                            state.progLength += 4;
                        }
                        else if (c == '!') {
                            result = new RENode((byte)42);
                            state.progLength += 4;
                        }
                    }
                    else {
                        result = new RENode((byte)29);
                        state.progLength += 6;
                        result.parenIndex = state.parenCount++;
                    }
                    ++state.parenNesting;
                    if (!parseDisjunction(state)) {
                        return false;
                    }
                    if (state.cp == state.cpend || src[state.cp] != ')') {
                        reportError("msg.unterm.paren", "");
                        return false;
                    }
                    ++state.cp;
                    --state.parenNesting;
                    if (result != null) {
                        result.kid = state.result;
                        state.result = result;
                        break;
                    }
                    break;
                }
                case ')': {
                    reportError("msg.re.unmatched.right.paren", "");
                    return false;
                }
                case '[': {
                    state.result = new RENode((byte)22);
                    final int termStart = state.cp;
                    state.result.startIndex = termStart;
                    while (state.cp != state.cpend) {
                        if (src[state.cp] == '\\') {
                            ++state.cp;
                        }
                        else if (src[state.cp] == ']') {
                            state.result.kidlen = state.cp - termStart;
                            state.result.index = state.classCount++;
                            if (!calculateBitmapSize(state, state.result, src, termStart, state.cp++)) {
                                return false;
                            }
                            state.progLength += 3;
                            break Label_1837;
                        }
                        ++state.cp;
                    }
                    reportError("msg.unterm.class", "");
                    return false;
                }
                case '.': {
                    state.result = new RENode((byte)6);
                    ++state.progLength;
                    break;
                }
                case '*':
                case '+':
                case '?': {
                    reportError("msg.bad.quant", String.valueOf(src[state.cp - 1]));
                    return false;
                }
                default: {
                    state.result = new RENode((byte)14);
                    state.result.chr = c;
                    state.result.length = 1;
                    state.result.flatIndex = state.cp - 1;
                    state.progLength += 3;
                    break;
                }
            }
        }
        final RENode term = state.result;
        if (state.cp == state.cpend) {
            return true;
        }
        boolean hasQ = false;
        switch (src[state.cp]) {
            case '+': {
                state.result = new RENode((byte)25);
                state.result.min = 1;
                state.result.max = -1;
                state.progLength += 8;
                hasQ = true;
                break;
            }
            case '*': {
                state.result = new RENode((byte)25);
                state.result.min = 0;
                state.result.max = -1;
                state.progLength += 8;
                hasQ = true;
                break;
            }
            case '?': {
                state.result = new RENode((byte)25);
                state.result.min = 0;
                state.result.max = 1;
                state.progLength += 8;
                hasQ = true;
                break;
            }
            case '{': {
                int min = 0;
                int max = -1;
                final int leftCurl = state.cp;
                if (++state.cp < src.length && isDigit(c = src[state.cp])) {
                    ++state.cp;
                    min = getDecimalValue(c, state, 65535, "msg.overlarge.min");
                    if (state.cp < src.length) {
                        c = src[state.cp];
                        if (c == ',' && ++state.cp < src.length) {
                            c = src[state.cp];
                            if (isDigit(c) && ++state.cp < src.length) {
                                max = getDecimalValue(c, state, 65535, "msg.overlarge.max");
                                c = src[state.cp];
                                if (min > max) {
                                    reportError("msg.max.lt.min", String.valueOf(src[state.cp]));
                                    return false;
                                }
                            }
                        }
                        else {
                            max = min;
                        }
                        if (c == '}') {
                            state.result = new RENode((byte)25);
                            state.result.min = min;
                            state.result.max = max;
                            state.progLength += 12;
                            hasQ = true;
                        }
                    }
                }
                if (!hasQ) {
                    state.cp = leftCurl;
                    break;
                }
                break;
            }
        }
        if (!hasQ) {
            return true;
        }
        ++state.cp;
        state.result.kid = term;
        state.result.parenIndex = parenBaseCount;
        state.result.parenCount = state.parenCount - parenBaseCount;
        if (state.cp < state.cpend && src[state.cp] == '?') {
            ++state.cp;
            state.result.greedy = false;
        }
        else {
            state.result.greedy = true;
        }
        return true;
    }
    
    private static void resolveForwardJump(final byte[] array, final int from, final int pc) {
        if (from > pc) {
            throw Kit.codeBug();
        }
        addIndex(array, from, pc - from);
    }
    
    private static int getOffset(final byte[] array, final int pc) {
        return getIndex(array, pc);
    }
    
    private static int addIndex(final byte[] array, final int pc, final int index) {
        if (index < 0) {
            throw Kit.codeBug();
        }
        if (index > 65535) {
            throw Context.reportRuntimeError("Too complex regexp");
        }
        array[pc] = (byte)(index >> 8);
        array[pc + 1] = (byte)index;
        return pc + 2;
    }
    
    private static int getIndex(final byte[] array, final int pc) {
        return (array[pc] & 0xFF) << 8 | (array[pc + 1] & 0xFF);
    }
    
    private static int emitREBytecode(final CompilerState state, final RECompiled re, int pc, RENode t) {
        final byte[] program = re.program;
        while (t != null) {
            program[pc++] = t.op;
            switch (t.op) {
                case 1: {
                    --pc;
                    break;
                }
                case 53:
                case 54:
                case 55: {
                    final boolean ignoreCase = t.op == 54;
                    addIndex(program, pc, ignoreCase ? upcase(t.chr) : t.chr);
                    pc += 2;
                    addIndex(program, pc, ignoreCase ? upcase((char)t.index) : t.index);
                    pc += 2;
                }
                case 31: {
                    final RENode nextAlt = t.kid2;
                    int nextAltFixup = pc;
                    pc += 2;
                    pc = emitREBytecode(state, re, pc, t.kid);
                    program[pc++] = 32;
                    final int nextTermFixup = pc;
                    pc += 2;
                    resolveForwardJump(program, nextAltFixup, pc);
                    pc = emitREBytecode(state, re, pc, nextAlt);
                    program[pc++] = 32;
                    nextAltFixup = pc;
                    pc += 2;
                    resolveForwardJump(program, nextTermFixup, pc);
                    resolveForwardJump(program, nextAltFixup, pc);
                    break;
                }
                case 14: {
                    if (t.flatIndex != -1) {
                        while (t.next != null && t.next.op == 14 && t.flatIndex + t.length == t.next.flatIndex) {
                            final RENode reNode = t;
                            reNode.length += t.next.length;
                            t.next = t.next.next;
                        }
                    }
                    if (t.flatIndex != -1 && t.length > 1) {
                        if ((state.flags & 0x2) != 0x0) {
                            program[pc - 1] = 16;
                        }
                        else {
                            program[pc - 1] = 14;
                        }
                        pc = addIndex(program, pc, t.flatIndex);
                        pc = addIndex(program, pc, t.length);
                        break;
                    }
                    if (t.chr < '\u0100') {
                        if ((state.flags & 0x2) != 0x0) {
                            program[pc - 1] = 17;
                        }
                        else {
                            program[pc - 1] = 15;
                        }
                        program[pc++] = (byte)t.chr;
                        break;
                    }
                    if ((state.flags & 0x2) != 0x0) {
                        program[pc - 1] = 19;
                    }
                    else {
                        program[pc - 1] = 18;
                    }
                    pc = addIndex(program, pc, t.chr);
                    break;
                }
                case 29: {
                    pc = addIndex(program, pc, t.parenIndex);
                    pc = emitREBytecode(state, re, pc, t.kid);
                    program[pc++] = 30;
                    pc = addIndex(program, pc, t.parenIndex);
                    break;
                }
                case 13: {
                    pc = addIndex(program, pc, t.parenIndex);
                    break;
                }
                case 41: {
                    final int nextTermFixup = pc;
                    pc += 2;
                    pc = emitREBytecode(state, re, pc, t.kid);
                    program[pc++] = 43;
                    resolveForwardJump(program, nextTermFixup, pc);
                    break;
                }
                case 42: {
                    final int nextTermFixup = pc;
                    pc += 2;
                    pc = emitREBytecode(state, re, pc, t.kid);
                    program[pc++] = 44;
                    resolveForwardJump(program, nextTermFixup, pc);
                    break;
                }
                case 25: {
                    if (t.min == 0 && t.max == -1) {
                        program[pc - 1] = (byte)(t.greedy ? 26 : 45);
                    }
                    else if (t.min == 0 && t.max == 1) {
                        program[pc - 1] = (byte)(t.greedy ? 28 : 47);
                    }
                    else if (t.min == 1 && t.max == -1) {
                        program[pc - 1] = (byte)(t.greedy ? 27 : 46);
                    }
                    else {
                        if (!t.greedy) {
                            program[pc - 1] = 48;
                        }
                        pc = addIndex(program, pc, t.min);
                        pc = addIndex(program, pc, t.max + 1);
                    }
                    pc = addIndex(program, pc, t.parenCount);
                    final int nextTermFixup;
                    pc = (nextTermFixup = addIndex(program, pc, t.parenIndex));
                    pc += 2;
                    pc = emitREBytecode(state, re, pc, t.kid);
                    program[pc++] = 49;
                    resolveForwardJump(program, nextTermFixup, pc);
                    break;
                }
                case 22: {
                    if (!t.sense) {
                        program[pc - 1] = 23;
                    }
                    pc = addIndex(program, pc, t.index);
                    re.classList[t.index] = new RECharSet(t.bmsize, t.startIndex, t.kidlen, t.sense);
                    break;
                }
            }
            t = t.next;
        }
        return pc;
    }
    
    private static void pushProgState(final REGlobalData gData, final int min, final int max, final int cp, final REBackTrackData backTrackLastToSave, final int continuationOp, final int continuationPc) {
        gData.stateStackTop = new REProgState(gData.stateStackTop, min, max, cp, backTrackLastToSave, continuationOp, continuationPc);
    }
    
    private static REProgState popProgState(final REGlobalData gData) {
        final REProgState state = gData.stateStackTop;
        gData.stateStackTop = state.previous;
        return state;
    }
    
    private static void pushBackTrackState(final REGlobalData gData, final byte op, final int pc) {
        final REProgState state = gData.stateStackTop;
        gData.backTrackStackTop = new REBackTrackData(gData, op, pc, gData.cp, state.continuationOp, state.continuationPc);
    }
    
    private static void pushBackTrackState(final REGlobalData gData, final byte op, final int pc, final int cp, final int continuationOp, final int continuationPc) {
        gData.backTrackStackTop = new REBackTrackData(gData, op, pc, cp, continuationOp, continuationPc);
    }
    
    private static boolean flatNMatcher(final REGlobalData gData, final int matchChars, final int length, final String input, final int end) {
        if (gData.cp + length > end) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (gData.regexp.source[matchChars + i] != input.charAt(gData.cp + i)) {
                return false;
            }
        }
        gData.cp += length;
        return true;
    }
    
    private static boolean flatNIMatcher(final REGlobalData gData, final int matchChars, final int length, final String input, final int end) {
        if (gData.cp + length > end) {
            return false;
        }
        final char[] source = gData.regexp.source;
        for (int i = 0; i < length; ++i) {
            final char c1 = source[matchChars + i];
            final char c2 = input.charAt(gData.cp + i);
            if (c1 != c2 && upcase(c1) != upcase(c2)) {
                return false;
            }
        }
        gData.cp += length;
        return true;
    }
    
    private static boolean backrefMatcher(final REGlobalData gData, final int parenIndex, final String input, final int end) {
        if (gData.parens == null || parenIndex >= gData.parens.length) {
            return false;
        }
        final int parenContent = gData.parensIndex(parenIndex);
        if (parenContent == -1) {
            return true;
        }
        final int len = gData.parensLength(parenIndex);
        if (gData.cp + len > end) {
            return false;
        }
        if ((gData.regexp.flags & 0x2) != 0x0) {
            for (int i = 0; i < len; ++i) {
                final char c1 = input.charAt(parenContent + i);
                final char c2 = input.charAt(gData.cp + i);
                if (c1 != c2 && upcase(c1) != upcase(c2)) {
                    return false;
                }
            }
        }
        else if (!input.regionMatches(parenContent, input, gData.cp, len)) {
            return false;
        }
        gData.cp += len;
        return true;
    }
    
    private static void addCharacterToCharSet(final RECharSet cs, final char c) {
        final int byteIndex = c / '\b';
        if (c >= cs.length) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        final byte[] bits = cs.bits;
        final int n = byteIndex;
        bits[n] |= (byte)(1 << (c & '\u0007'));
    }
    
    private static void addCharacterRangeToCharSet(final RECharSet cs, char c1, char c2) {
        final int byteIndex1 = c1 / '\b';
        final int byteIndex2 = c2 / '\b';
        if (c2 >= cs.length || c1 > c2) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        c1 &= '\u0007';
        c2 &= '\u0007';
        if (byteIndex1 == byteIndex2) {
            final byte[] bits = cs.bits;
            final int n = byteIndex1;
            bits[n] |= (byte)(255 >> 7 - (c2 - c1) << c1);
        }
        else {
            final byte[] bits2 = cs.bits;
            final int n2 = byteIndex1;
            bits2[n2] |= (byte)(255 << c1);
            for (int i = byteIndex1 + 1; i < byteIndex2; ++i) {
                cs.bits[i] = -1;
            }
            final byte[] bits3 = cs.bits;
            final int n3 = byteIndex2;
            bits3[n3] |= (byte)(255 >> '\u0007' - c2);
        }
    }
    
    private static void processCharSet(final REGlobalData gData, final RECharSet charSet) {
        synchronized (charSet) {
            if (!charSet.converted) {
                processCharSetImpl(gData, charSet);
                charSet.converted = true;
            }
        }
    }
    
    private static void processCharSetImpl(final REGlobalData gData, final RECharSet charSet) {
        int src = charSet.startIndex;
        final int end = src + charSet.strlength;
        char rangeStart = '\0';
        boolean inRange = false;
        final int byteLength = (charSet.length + 7) / 8;
        charSet.bits = new byte[byteLength];
        if (src == end) {
            return;
        }
        if (gData.regexp.source[src] == '^') {
            assert !charSet.sense;
            ++src;
        }
        else {
            assert charSet.sense;
        }
        while (src != end) {
            int nDigits = 2;
            char thisCh = '\0';
            Label_0949: {
                switch (gData.regexp.source[src]) {
                    case '\\': {
                        ++src;
                        char c = gData.regexp.source[src++];
                        switch (c) {
                            case 'b': {
                                thisCh = '\b';
                                break Label_0949;
                            }
                            case 'f': {
                                thisCh = '\f';
                                break Label_0949;
                            }
                            case 'n': {
                                thisCh = '\n';
                                break Label_0949;
                            }
                            case 'r': {
                                thisCh = '\r';
                                break Label_0949;
                            }
                            case 't': {
                                thisCh = '\t';
                                break Label_0949;
                            }
                            case 'v': {
                                thisCh = '\u000b';
                                break Label_0949;
                            }
                            case 'c': {
                                if (src < end && isControlLetter(gData.regexp.source[src])) {
                                    thisCh = (char)(gData.regexp.source[src++] & '\u001f');
                                    break Label_0949;
                                }
                                --src;
                                thisCh = '\\';
                                break Label_0949;
                            }
                            case 'u': {
                                nDigits += 2;
                            }
                            case 'x': {
                                int n = 0;
                                for (int i = 0; i < nDigits && src < end; ++i) {
                                    c = gData.regexp.source[src++];
                                    final int digit = toASCIIHexDigit(c);
                                    if (digit < 0) {
                                        src -= i + 1;
                                        n = 92;
                                        break;
                                    }
                                    n = (n << 4 | digit);
                                }
                                thisCh = (char)n;
                                break Label_0949;
                            }
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7': {
                                int n = c - '0';
                                c = gData.regexp.source[src];
                                if ('0' <= c && c <= '7') {
                                    ++src;
                                    n = 8 * n + (c - '0');
                                    c = gData.regexp.source[src];
                                    if ('0' <= c && c <= '7') {
                                        ++src;
                                        final int i = 8 * n + (c - '0');
                                        if (i <= 255) {
                                            n = i;
                                        }
                                        else {
                                            --src;
                                        }
                                    }
                                }
                                thisCh = (char)n;
                                break Label_0949;
                            }
                            case 'd': {
                                addCharacterRangeToCharSet(charSet, '0', '9');
                                continue;
                            }
                            case 'D': {
                                addCharacterRangeToCharSet(charSet, '\0', '/');
                                addCharacterRangeToCharSet(charSet, ':', (char)(charSet.length - 1));
                                continue;
                            }
                            case 's': {
                                for (int i = charSet.length - 1; i >= 0; --i) {
                                    if (isREWhiteSpace(i)) {
                                        addCharacterToCharSet(charSet, (char)i);
                                    }
                                }
                                continue;
                            }
                            case 'S': {
                                for (int i = charSet.length - 1; i >= 0; --i) {
                                    if (!isREWhiteSpace(i)) {
                                        addCharacterToCharSet(charSet, (char)i);
                                    }
                                }
                                continue;
                            }
                            case 'w': {
                                for (int i = charSet.length - 1; i >= 0; --i) {
                                    if (isWord((char)i)) {
                                        addCharacterToCharSet(charSet, (char)i);
                                    }
                                }
                                continue;
                            }
                            case 'W': {
                                for (int i = charSet.length - 1; i >= 0; --i) {
                                    if (!isWord((char)i)) {
                                        addCharacterToCharSet(charSet, (char)i);
                                    }
                                }
                                continue;
                            }
                            default: {
                                thisCh = c;
                                break Label_0949;
                            }
                        }
                        break;
                    }
                    default: {
                        thisCh = gData.regexp.source[src++];
                        break;
                    }
                }
            }
            if (inRange) {
                if ((gData.regexp.flags & 0x2) != 0x0) {
                    assert rangeStart <= thisCh;
                    char c = rangeStart;
                    while (c <= thisCh) {
                        addCharacterToCharSet(charSet, c);
                        final char uch = upcase(c);
                        final char dch = downcase(c);
                        if (c != uch) {
                            addCharacterToCharSet(charSet, uch);
                        }
                        if (c != dch) {
                            addCharacterToCharSet(charSet, dch);
                        }
                        ++c;
                        if (c == '\0') {
                            break;
                        }
                    }
                }
                else {
                    addCharacterRangeToCharSet(charSet, rangeStart, thisCh);
                }
                inRange = false;
            }
            else {
                if ((gData.regexp.flags & 0x2) != 0x0) {
                    addCharacterToCharSet(charSet, upcase(thisCh));
                    addCharacterToCharSet(charSet, downcase(thisCh));
                }
                else {
                    addCharacterToCharSet(charSet, thisCh);
                }
                if (src >= end - 1 || gData.regexp.source[src] != '-') {
                    continue;
                }
                ++src;
                inRange = true;
                rangeStart = thisCh;
            }
        }
    }
    
    private static boolean classMatcher(final REGlobalData gData, final RECharSet charSet, final char ch) {
        if (!charSet.converted) {
            processCharSet(gData, charSet);
        }
        final int byteIndex = ch >> 3;
        return (charSet.length == 0 || ch >= charSet.length || (charSet.bits[byteIndex] & 1 << (ch & '\u0007')) == 0x0) ^ charSet.sense;
    }
    
    private static boolean reopIsSimple(final int op) {
        return op >= 1 && op <= 23;
    }
    
    private static int simpleMatch(final REGlobalData gData, final String input, final int op, final byte[] program, int pc, final int end, final boolean updatecp) {
        boolean result = false;
        final int startcp = gData.cp;
        switch (op) {
            case 1: {
                result = true;
                break;
            }
            case 2: {
                if (gData.cp != 0) {
                    if (!gData.multiline) {
                        break;
                    }
                    if (!isLineTerm(input.charAt(gData.cp - 1))) {
                        break;
                    }
                }
                result = true;
                break;
            }
            case 3: {
                if (gData.cp != end) {
                    if (!gData.multiline) {
                        break;
                    }
                    if (!isLineTerm(input.charAt(gData.cp))) {
                        break;
                    }
                }
                result = true;
                break;
            }
            case 4: {
                result = ((gData.cp == 0 || !isWord(input.charAt(gData.cp - 1))) ^ (gData.cp >= end || !isWord(input.charAt(gData.cp))));
                break;
            }
            case 5: {
                result = ((gData.cp == 0 || !isWord(input.charAt(gData.cp - 1))) ^ (gData.cp < end && isWord(input.charAt(gData.cp))));
                break;
            }
            case 6: {
                if (gData.cp != end && (gData.dotAll || !isLineTerm(input.charAt(gData.cp)))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 7: {
                if (gData.cp != end && isDigit(input.charAt(gData.cp))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 8: {
                if (gData.cp != end && !isDigit(input.charAt(gData.cp))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 9: {
                if (gData.cp != end && isWord(input.charAt(gData.cp))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 10: {
                if (gData.cp != end && !isWord(input.charAt(gData.cp))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 11: {
                if (gData.cp != end && isREWhiteSpace(input.charAt(gData.cp))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 12: {
                if (gData.cp != end && !isREWhiteSpace(input.charAt(gData.cp))) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 13: {
                final int parenIndex = getIndex(program, pc);
                pc += 2;
                result = backrefMatcher(gData, parenIndex, input, end);
                break;
            }
            case 14: {
                final int offset = getIndex(program, pc);
                pc += 2;
                final int length = getIndex(program, pc);
                pc += 2;
                result = flatNMatcher(gData, offset, length, input, end);
                break;
            }
            case 15: {
                final char matchCh = (char)(program[pc++] & 0xFF);
                if (gData.cp != end && input.charAt(gData.cp) == matchCh) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 16: {
                final int offset = getIndex(program, pc);
                pc += 2;
                final int length = getIndex(program, pc);
                pc += 2;
                result = flatNIMatcher(gData, offset, length, input, end);
                break;
            }
            case 17: {
                final char matchCh = (char)(program[pc++] & 0xFF);
                if (gData.cp != end) {
                    final char c = input.charAt(gData.cp);
                    if (matchCh == c || upcase(matchCh) == upcase(c)) {
                        result = true;
                        ++gData.cp;
                    }
                    break;
                }
                break;
            }
            case 18: {
                final char matchCh = (char)getIndex(program, pc);
                pc += 2;
                if (gData.cp != end && input.charAt(gData.cp) == matchCh) {
                    result = true;
                    ++gData.cp;
                    break;
                }
                break;
            }
            case 19: {
                final char matchCh = (char)getIndex(program, pc);
                pc += 2;
                if (gData.cp != end) {
                    final char c = input.charAt(gData.cp);
                    if (matchCh == c || upcase(matchCh) == upcase(c)) {
                        result = true;
                        ++gData.cp;
                    }
                    break;
                }
                break;
            }
            case 22:
            case 23: {
                final int index = getIndex(program, pc);
                pc += 2;
                if (gData.cp != end && classMatcher(gData, gData.regexp.classList[index], input.charAt(gData.cp))) {
                    ++gData.cp;
                    result = true;
                    break;
                }
                break;
            }
            default: {
                throw Kit.codeBug();
            }
        }
        if (result) {
            if (!updatecp) {
                gData.cp = startcp;
            }
            return pc;
        }
        gData.cp = startcp;
        return -1;
    }
    
    private static boolean executeREBytecode(final REGlobalData gData, final String input, final int end) {
        int pc = 0;
        final byte[] program = gData.regexp.program;
        int continuationOp = 57;
        int continuationPc = 0;
        boolean result = false;
        int op = program[pc++];
        if (gData.regexp.anchorCh < 0 && reopIsSimple(op)) {
            boolean anchor = false;
            while (gData.cp <= end) {
                final int match = simpleMatch(gData, input, op, program, pc, end, true);
                if (match >= 0) {
                    anchor = true;
                    pc = match;
                    op = program[pc++];
                    break;
                }
                ++gData.skipped;
                ++gData.cp;
            }
            if (!anchor) {
                return false;
            }
        }
        while (true) {
            Label_1964: {
                if (reopIsSimple(op)) {
                    final int match2 = simpleMatch(gData, input, op, program, pc, end, true);
                    result = (match2 >= 0);
                    if (result) {
                        pc = match2;
                    }
                }
                else {
                    Label_0441: {
                        switch (op) {
                            case 53:
                            case 54:
                            case 55: {
                                final char matchCh1 = (char)getIndex(program, pc);
                                pc += 2;
                                final char matchCh2 = (char)getIndex(program, pc);
                                pc += 2;
                                if (gData.cp == end) {
                                    result = false;
                                    break;
                                }
                                char c = input.charAt(gData.cp);
                                if (op == 55) {
                                    if (c != matchCh1 && !classMatcher(gData, gData.regexp.classList[matchCh2], c)) {
                                        result = false;
                                        break;
                                    }
                                    break Label_0441;
                                }
                                else {
                                    if (op == 54) {
                                        c = upcase(c);
                                    }
                                    if (c != matchCh1 && c != matchCh2) {
                                        result = false;
                                        break;
                                    }
                                    break Label_0441;
                                }
                                break;
                            }
                            case 31: {
                                int nextpc = pc + getOffset(program, pc);
                                pc += 2;
                                op = program[pc++];
                                final int startcp = gData.cp;
                                if (reopIsSimple(op)) {
                                    final int match3 = simpleMatch(gData, input, op, program, pc, end, true);
                                    if (match3 < 0) {
                                        op = program[nextpc++];
                                        pc = nextpc;
                                        continue;
                                    }
                                    result = true;
                                    pc = match3;
                                    op = program[pc++];
                                }
                                final byte nextop = program[nextpc++];
                                pushBackTrackState(gData, nextop, nextpc, startcp, continuationOp, continuationPc);
                                continue;
                            }
                            case 32: {
                                final int offset = getOffset(program, pc);
                                pc += offset;
                                op = program[pc++];
                                continue;
                            }
                            case 29: {
                                final int parenIndex = getIndex(program, pc);
                                pc += 2;
                                gData.setParens(parenIndex, gData.cp, 0);
                                op = program[pc++];
                                continue;
                            }
                            case 30: {
                                final int parenIndex = getIndex(program, pc);
                                pc += 2;
                                final int cap_index = gData.parensIndex(parenIndex);
                                gData.setParens(parenIndex, cap_index, gData.cp - cap_index);
                                op = program[pc++];
                                continue;
                            }
                            case 41: {
                                final int nextpc = pc + getIndex(program, pc);
                                pc += 2;
                                op = program[pc++];
                                if (reopIsSimple(op) && simpleMatch(gData, input, op, program, pc, end, false) < 0) {
                                    result = false;
                                    break;
                                }
                                pushProgState(gData, 0, 0, gData.cp, gData.backTrackStackTop, continuationOp, continuationPc);
                                pushBackTrackState(gData, (byte)43, nextpc);
                                continue;
                            }
                            case 42: {
                                final int nextpc = pc + getIndex(program, pc);
                                pc += 2;
                                op = program[pc++];
                                if (reopIsSimple(op)) {
                                    final int match = simpleMatch(gData, input, op, program, pc, end, false);
                                    if (match >= 0 && program[match] == 44) {
                                        result = false;
                                        break;
                                    }
                                }
                                pushProgState(gData, 0, 0, gData.cp, gData.backTrackStackTop, continuationOp, continuationPc);
                                pushBackTrackState(gData, (byte)44, nextpc);
                                continue;
                            }
                            case 43:
                            case 44: {
                                final REProgState state = popProgState(gData);
                                gData.cp = state.index;
                                gData.backTrackStackTop = state.backTrack;
                                continuationPc = state.continuationPc;
                                continuationOp = state.continuationOp;
                                if (op == 44) {
                                    result = !result;
                                }
                                break;
                            }
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 45:
                            case 46:
                            case 47:
                            case 48: {
                                boolean greedy = false;
                                int min = 0;
                                int max = 0;
                                switch (op) {
                                    case 26: {
                                        greedy = true;
                                    }
                                    case 45: {
                                        min = 0;
                                        max = -1;
                                        break;
                                    }
                                    case 27: {
                                        greedy = true;
                                    }
                                    case 46: {
                                        min = 1;
                                        max = -1;
                                        break;
                                    }
                                    case 28: {
                                        greedy = true;
                                    }
                                    case 47: {
                                        min = 0;
                                        max = 1;
                                        break;
                                    }
                                    case 25: {
                                        greedy = true;
                                    }
                                    case 48: {
                                        min = getOffset(program, pc);
                                        pc += 2;
                                        max = getOffset(program, pc) - 1;
                                        pc += 2;
                                        break;
                                    }
                                    default: {
                                        throw Kit.codeBug();
                                    }
                                }
                                pushProgState(gData, min, max, gData.cp, null, continuationOp, continuationPc);
                                if (greedy) {
                                    pushBackTrackState(gData, (byte)51, pc);
                                    continuationOp = 51;
                                    continuationPc = pc;
                                    pc += 6;
                                    op = program[pc++];
                                }
                                else if (min != 0) {
                                    continuationOp = 52;
                                    continuationPc = pc;
                                    pc += 6;
                                    op = program[pc++];
                                }
                                else {
                                    pushBackTrackState(gData, (byte)52, pc);
                                    popProgState(gData);
                                    pc += 4;
                                    pc += getOffset(program, pc);
                                    op = program[pc++];
                                }
                                continue;
                            }
                            case 49: {
                                result = true;
                                pc = continuationPc;
                                op = continuationOp;
                                continue;
                            }
                            case 51: {
                                int nextpc;
                                do {
                                    final REProgState state2 = popProgState(gData);
                                    if (!result) {
                                        if (state2.min == 0) {
                                            result = true;
                                        }
                                        continuationPc = state2.continuationPc;
                                        continuationOp = state2.continuationOp;
                                        pc += 4;
                                        pc += getOffset(program, pc);
                                        break Label_1964;
                                    }
                                    if (state2.min == 0 && gData.cp == state2.index) {
                                        result = false;
                                        continuationPc = state2.continuationPc;
                                        continuationOp = state2.continuationOp;
                                        pc += 4;
                                        pc += getOffset(program, pc);
                                        break Label_1964;
                                    }
                                    int new_min = state2.min;
                                    int new_max = state2.max;
                                    if (new_min != 0) {
                                        --new_min;
                                    }
                                    if (new_max != -1) {
                                        --new_max;
                                    }
                                    if (new_max == 0) {
                                        result = true;
                                        continuationPc = state2.continuationPc;
                                        continuationOp = state2.continuationOp;
                                        pc += 4;
                                        pc += getOffset(program, pc);
                                        break Label_1964;
                                    }
                                    nextpc = pc + 6;
                                    final int nextop2 = program[nextpc];
                                    final int startcp2 = gData.cp;
                                    if (reopIsSimple(nextop2)) {
                                        ++nextpc;
                                        final int match4 = simpleMatch(gData, input, nextop2, program, nextpc, end, true);
                                        if (match4 < 0) {
                                            result = (new_min == 0);
                                            continuationPc = state2.continuationPc;
                                            continuationOp = state2.continuationOp;
                                            pc += 4;
                                            pc += getOffset(program, pc);
                                            break Label_1964;
                                        }
                                        result = true;
                                        nextpc = match4;
                                    }
                                    continuationOp = 51;
                                    continuationPc = pc;
                                    pushProgState(gData, new_min, new_max, startcp2, null, state2.continuationOp, state2.continuationPc);
                                    if (new_min != 0) {
                                        continue;
                                    }
                                    pushBackTrackState(gData, (byte)51, pc, startcp2, state2.continuationOp, state2.continuationPc);
                                    final int parenCount = getIndex(program, pc);
                                    final int parenIndex2 = getIndex(program, pc + 2);
                                    for (int k = 0; k < parenCount; ++k) {
                                        gData.setParens(parenIndex2 + k, -1, 0);
                                    }
                                } while (program[nextpc] == 49);
                                pc = nextpc;
                                op = program[pc++];
                                continue;
                            }
                            case 52: {
                                final REProgState state = popProgState(gData);
                                if (!result) {
                                    if (state.max == -1 || state.max > 0) {
                                        pushProgState(gData, state.min, state.max, gData.cp, null, state.continuationOp, state.continuationPc);
                                        continuationOp = 52;
                                        continuationPc = pc;
                                        final int parenCount2 = getIndex(program, pc);
                                        pc += 2;
                                        final int parenIndex3 = getIndex(program, pc);
                                        pc += 4;
                                        for (int i = 0; i < parenCount2; ++i) {
                                            gData.setParens(parenIndex3 + i, -1, 0);
                                        }
                                        op = program[pc++];
                                        continue;
                                    }
                                    continuationPc = state.continuationPc;
                                    continuationOp = state.continuationOp;
                                    break;
                                }
                                else {
                                    if (state.min == 0 && gData.cp == state.index) {
                                        result = false;
                                        continuationPc = state.continuationPc;
                                        continuationOp = state.continuationOp;
                                        break;
                                    }
                                    int new_min2 = state.min;
                                    int new_max2 = state.max;
                                    if (new_min2 != 0) {
                                        --new_min2;
                                    }
                                    if (new_max2 != -1) {
                                        --new_max2;
                                    }
                                    pushProgState(gData, new_min2, new_max2, gData.cp, null, state.continuationOp, state.continuationPc);
                                    if (new_min2 != 0) {
                                        continuationOp = 52;
                                        continuationPc = pc;
                                        final int parenCount3 = getIndex(program, pc);
                                        pc += 2;
                                        final int parenIndex4 = getIndex(program, pc);
                                        pc += 4;
                                        for (int j = 0; j < parenCount3; ++j) {
                                            gData.setParens(parenIndex4 + j, -1, 0);
                                        }
                                        op = program[pc++];
                                        continue;
                                    }
                                    continuationPc = state.continuationPc;
                                    continuationOp = state.continuationOp;
                                    pushBackTrackState(gData, (byte)52, pc);
                                    popProgState(gData);
                                    pc += 4;
                                    pc += getOffset(program, pc);
                                    op = program[pc++];
                                    continue;
                                }
                                break;
                            }
                            case 57: {
                                return true;
                            }
                            default: {
                                throw Kit.codeBug("invalid bytecode");
                            }
                        }
                    }
                }
            }
            if (!result) {
                final REBackTrackData backTrackData = gData.backTrackStackTop;
                if (backTrackData == null) {
                    return false;
                }
                gData.backTrackStackTop = backTrackData.previous;
                gData.parens = backTrackData.parens;
                gData.cp = backTrackData.cp;
                gData.stateStackTop = backTrackData.stateStackTop;
                continuationOp = backTrackData.continuationOp;
                continuationPc = backTrackData.continuationPc;
                pc = backTrackData.pc;
                op = backTrackData.op;
            }
            else {
                op = program[pc++];
            }
        }
    }
    
    private static boolean matchRegExp(final REGlobalData gData, final RECompiled re, final String input, final int start, final int end, final boolean multiline) {
        if (re.parenCount != 0) {
            gData.parens = new long[re.parenCount];
        }
        else {
            gData.parens = null;
        }
        gData.backTrackStackTop = null;
        gData.stateStackTop = null;
        gData.multiline = (multiline || (re.flags & 0x4) != 0x0);
        gData.dotAll = ((re.flags & 0x20) != 0x0);
        gData.regexp = re;
        final int anchorCh = gData.regexp.anchorCh;
        for (int i = start; i <= end; i = start + gData.skipped, ++i) {
            Label_0165: {
                if (anchorCh >= 0) {
                    while (i != end) {
                        final char matchCh = input.charAt(i);
                        if (matchCh == anchorCh) {
                            break Label_0165;
                        }
                        if ((gData.regexp.flags & 0x2) != 0x0 && upcase(matchCh) == upcase((char)anchorCh)) {
                            break Label_0165;
                        }
                        ++i;
                    }
                    return false;
                }
            }
            gData.cp = i;
            gData.skipped = i - start;
            for (int j = 0; j < re.parenCount; ++j) {
                gData.parens[j] = -1L;
            }
            final boolean result = executeREBytecode(gData, input, end);
            gData.backTrackStackTop = null;
            gData.stateStackTop = null;
            if (result) {
                return true;
            }
            if (anchorCh == -2 && !gData.multiline) {
                gData.skipped = end;
                return false;
            }
        }
        return false;
    }
    
    Object executeRegExp(final Context cx, final Scriptable scope, final RegExpImpl res, final String str, final int[] indexp, final int matchType) {
        final REGlobalData gData = new REGlobalData();
        int start = indexp[0];
        final int end = str.length();
        if (start > end) {
            start = end;
        }
        final boolean matches = matchRegExp(gData, this.re, str, start, end, res.multiline);
        if (matches) {
            int index = gData.cp;
            final int n = 0;
            final int n2 = index;
            indexp[n] = n2;
            final int ep = n2;
            final int matchlen = ep - (start + gData.skipped);
            index -= matchlen;
            Object result;
            Scriptable obj;
            if (matchType == 0) {
                result = Boolean.TRUE;
                obj = null;
            }
            else {
                result = cx.newArray(scope, 0);
                obj = (Scriptable)result;
                final String matchstr = str.substring(index, index + matchlen);
                obj.put(0, obj, matchstr);
            }
            if (this.re.parenCount == 0) {
                res.parens = null;
                res.lastParen = new SubString();
            }
            else {
                SubString parsub = null;
                res.parens = new SubString[this.re.parenCount];
                for (int num = 0; num < this.re.parenCount; ++num) {
                    final int cap_index = gData.parensIndex(num);
                    if (cap_index != -1) {
                        final int cap_length = gData.parensLength(num);
                        parsub = new SubString(str, cap_index, cap_length);
                        res.parens[num] = parsub;
                        if (matchType != 0) {
                            obj.put(num + 1, obj, parsub.toString());
                        }
                    }
                    else if (matchType != 0) {
                        obj.put(num + 1, obj, Undefined.instance);
                    }
                }
                res.lastParen = parsub;
            }
            if (matchType != 0) {
                obj.put("index", obj, start + gData.skipped);
                obj.put("input", obj, str);
            }
            if (res.lastMatch == null) {
                res.lastMatch = new SubString();
                res.leftContext = new SubString();
                res.rightContext = new SubString();
                res.prevContext = new SubString(str, 0, 0);
            }
            res.lastMatch.str = str;
            res.lastMatch.index = index;
            res.lastMatch.length = matchlen;
            res.leftContext.str = str;
            if (cx.getLanguageVersion() == 120) {
                res.leftContext.index = start;
                res.leftContext.length = gData.skipped;
                res.prevContext.length = gData.skipped;
            }
            else {
                res.leftContext.index = 0;
                res.leftContext.length = start + gData.skipped;
                res.prevContext.length = start + gData.skipped;
            }
            res.rightContext.str = str;
            res.rightContext.index = ep;
            res.rightContext.length = end - ep;
            return result;
        }
        if (matchType != 2) {
            return null;
        }
        return Undefined.instance;
    }
    
    int getFlags() {
        return this.re.flags;
    }
    
    void setFlags(final int flags) {
        this.re.flags = flags;
    }
    
    private static void reportWarning(final Context cx, final String messageId, final String arg) {
        if (cx.hasFeature(10)) {
            final String msg = ScriptRuntime.getMessage1(messageId, arg);
            Context.reportWarning(msg);
        }
    }
    
    private static void reportError(final String messageId, final String arg) {
        final String msg = ScriptRuntime.getMessage1(messageId, arg);
        throw ScriptRuntime.constructError("SyntaxError", msg);
    }
    
    protected int getMaxInstanceId() {
        return 8;
    }
    
    protected int findInstanceIdInfo(final String s) {
        int id = 0;
        String X = null;
        Label_0193: {
            switch (s.length()) {
                case 5: {
                    X = "flags";
                    id = 8;
                    break;
                }
                case 6: {
                    switch (s.charAt(2)) {
                        case 'i': {
                            X = "sticky";
                            id = 6;
                            break Label_0193;
                        }
                        case 'o': {
                            X = "global";
                            id = 3;
                            break Label_0193;
                        }
                        case 't': {
                            X = "dotAll";
                            id = 7;
                            break Label_0193;
                        }
                        case 'u': {
                            X = "source";
                            id = 2;
                            break Label_0193;
                        }
                        default: {
                            break Label_0193;
                        }
                    }
                    break;
                }
                case 9: {
                    final int c = s.charAt(0);
                    if (c == 108) {
                        X = "lastIndex";
                        id = 1;
                        break;
                    }
                    if (c == 109) {
                        X = "multiline";
                        id = 5;
                        break;
                    }
                    break;
                }
                case 10: {
                    X = "ignoreCase";
                    id = 4;
                    break;
                }
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        if (id == 0) {
            return super.findInstanceIdInfo(s);
        }
        int attr = 0;
        switch (id) {
            case 1: {
                attr = this.lastIndexAttr;
                break;
            }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                attr = 7;
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        return instanceIdInfo(attr, id);
    }
    
    protected String getInstanceIdName(final int id) {
        switch (id) {
            case 1: {
                return "lastIndex";
            }
            case 2: {
                return "source";
            }
            case 3: {
                return "global";
            }
            case 4: {
                return "ignoreCase";
            }
            case 5: {
                return "multiline";
            }
            case 6: {
                return "sticky";
            }
            case 7: {
                return "dotAll";
            }
            case 8: {
                return "flags";
            }
            default: {
                return super.getInstanceIdName(id);
            }
        }
    }
    
    protected Object getInstanceIdValue(final int id) {
        switch (id) {
            case 1: {
                return this.lastIndex;
            }
            case 2: {
                return new String(this.re.source);
            }
            case 8: {
                return flagsToString(this.re.flags);
            }
            case 3: {
                return ScriptRuntime.wrapBoolean((this.re.flags & 0x1) != 0x0);
            }
            case 4: {
                return ScriptRuntime.wrapBoolean((this.re.flags & 0x2) != 0x0);
            }
            case 5: {
                return ScriptRuntime.wrapBoolean((this.re.flags & 0x4) != 0x0);
            }
            case 6: {
                return ScriptRuntime.wrapBoolean((this.re.flags & 0x8) != 0x0);
            }
            case 7: {
                return ScriptRuntime.wrapBoolean((this.re.flags & 0x20) != 0x0);
            }
            default: {
                return super.getInstanceIdValue(id);
            }
        }
    }
    
    protected void setInstanceIdValue(final int id, final Object value) {
        switch (id) {
            case 1: {
                this.lastIndex = value;
            }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {}
            default: {
                super.setInstanceIdValue(id, value);
            }
        }
    }
    
    protected void setInstanceIdAttributes(final int id, final int attr) {
        switch (id) {
            case 1: {
                this.lastIndexAttr = attr;
            }
            default: {
                super.setInstanceIdAttributes(id, attr);
            }
        }
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 2;
                s = "compile";
                break;
            }
            case 2: {
                arity = 0;
                s = "toString";
                break;
            }
            case 3: {
                arity = 0;
                s = "toSource";
                break;
            }
            case 4: {
                arity = 1;
                s = "exec";
                break;
            }
            case 5: {
                arity = 1;
                s = "test";
                break;
            }
            case 6: {
                arity = 1;
                s = "prefix";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeRegExp.REGEXP_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeRegExp.REGEXP_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                return realThis(thisObj, f).compile(cx, scope, args);
            }
            case 2:
            case 3: {
                final String source = ScriptableObject.getProperty(thisObj, "source").toString();
                final String flags = ScriptableObject.getProperty(thisObj, "flags").toString();
                return toString(source, flags);
            }
            case 4: {
                return realThis(thisObj, f).execSub(cx, scope, args, 1);
            }
            case 5: {
                final Object x = realThis(thisObj, f).execSub(cx, scope, args, 0);
                return Boolean.TRUE.equals(x) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 6: {
                return realThis(thisObj, f).execSub(cx, scope, args, 2);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private static NativeRegExp realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeRegExp) || !((NativeRegExp)unwrappedThis).isInstance) {
            throw incompatibleCallError(f);
        }
        return (NativeRegExp)unwrappedThis;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 4: {
                final int c = s.charAt(0);
                if (c == 101) {
                    X = "exec";
                    id = 4;
                    break;
                }
                if (c == 116) {
                    X = "test";
                    id = 5;
                    break;
                }
                break;
            }
            case 6: {
                X = "prefix";
                id = 6;
                break;
            }
            case 7: {
                X = "compile";
                id = 1;
                break;
            }
            case 8: {
                final int c = s.charAt(3);
                if (c == 111) {
                    X = "toSource";
                    id = 3;
                    break;
                }
                if (c == 116) {
                    X = "toString";
                    id = 2;
                    break;
                }
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        REGEXP_TAG = new Object();
    }
}
