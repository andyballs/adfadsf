//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public class NativeGlobal implements Serializable, IdFunctionCall
{
    static final long serialVersionUID = 6080442165748707530L;
    private static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    private static final int INVALID_UTF8 = Integer.MAX_VALUE;
    private static final Object FTAG;
    private static final int Id_decodeURI = 1;
    private static final int Id_decodeURIComponent = 2;
    private static final int Id_encodeURI = 3;
    private static final int Id_encodeURIComponent = 4;
    private static final int Id_escape = 5;
    private static final int Id_eval = 6;
    private static final int Id_isFinite = 7;
    private static final int Id_isNaN = 8;
    private static final int Id_parseFloat = 9;
    private static final int Id_parseInt = 10;
    private static final int Id_unescape = 11;
    private static final int Id_uneval = 12;
    private static final int LAST_SCOPE_FUNCTION_ID = 12;
    private static final int Id_new_CommonError = 13;
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeGlobal obj = new NativeGlobal();
        for (int id = 1; id <= 12; ++id) {
            int arity = 1;
            String name = null;
            switch (id) {
                case 1: {
                    name = "decodeURI";
                    break;
                }
                case 2: {
                    name = "decodeURIComponent";
                    break;
                }
                case 3: {
                    name = "encodeURI";
                    break;
                }
                case 4: {
                    name = "encodeURIComponent";
                    break;
                }
                case 5: {
                    name = "escape";
                    break;
                }
                case 6: {
                    name = "eval";
                    break;
                }
                case 7: {
                    name = "isFinite";
                    break;
                }
                case 8: {
                    name = "isNaN";
                    break;
                }
                case 9: {
                    name = "parseFloat";
                    break;
                }
                case 10: {
                    name = "parseInt";
                    arity = 2;
                    break;
                }
                case 11: {
                    name = "unescape";
                    break;
                }
                case 12: {
                    name = "uneval";
                    break;
                }
                default: {
                    throw Kit.codeBug();
                }
            }
            final IdFunctionObject f = new IdFunctionObject((IdFunctionCall)obj, NativeGlobal.FTAG, id, name, arity, scope);
            if (sealed) {
                f.sealObject();
            }
            f.exportAsScopeProperty();
        }
        ScriptableObject.defineProperty(scope, "NaN", ScriptRuntime.NaNobj, 7);
        ScriptableObject.defineProperty(scope, "Infinity", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        ScriptableObject.defineProperty(scope, "undefined", Undefined.instance, 7);
        for (final TopLevel.NativeErrors error : TopLevel.NativeErrors.values()) {
            if (error != TopLevel.NativeErrors.Error) {
                final String name2 = error.name();
                final ScriptableObject errorProto = (ScriptableObject)ScriptRuntime.newBuiltinObject(cx, scope, TopLevel.Builtins.Error, ScriptRuntime.emptyArgs);
                errorProto.put("name", errorProto, name2);
                errorProto.put("message", errorProto, "");
                final IdFunctionObject ctor = new IdFunctionObject((IdFunctionCall)obj, NativeGlobal.FTAG, 13, name2, 1, scope);
                ctor.markAsConstructor((Scriptable)errorProto);
                errorProto.put("constructor", errorProto, ctor);
                errorProto.setAttributes("constructor", 2);
                if (sealed) {
                    errorProto.sealObject();
                    ctor.sealObject();
                }
                ctor.exportAsScopeProperty();
            }
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (f.hasTag(NativeGlobal.FTAG)) {
            final int methodId = f.methodId();
            switch (methodId) {
                case 1:
                case 2: {
                    final String str = ScriptRuntime.toString(args, 0);
                    return decode(str, methodId == 1);
                }
                case 3:
                case 4: {
                    final String str = ScriptRuntime.toString(args, 0);
                    return encode(str, methodId == 3);
                }
                case 5: {
                    return this.js_escape(args);
                }
                case 6: {
                    return this.js_eval(cx, scope, args);
                }
                case 7: {
                    if (args.length < 1) {
                        return Boolean.FALSE;
                    }
                    return NativeNumber.isFinite(args[0]);
                }
                case 8: {
                    boolean result;
                    if (args.length < 1) {
                        result = true;
                    }
                    else {
                        final double d = ScriptRuntime.toNumber(args[0]);
                        result = Double.isNaN(d);
                    }
                    return ScriptRuntime.wrapBoolean(result);
                }
                case 9: {
                    return js_parseFloat(args);
                }
                case 10: {
                    return js_parseInt(args);
                }
                case 11: {
                    return this.js_unescape(args);
                }
                case 12: {
                    final Object value = (args.length != 0) ? args[0] : Undefined.instance;
                    return ScriptRuntime.uneval(cx, scope, value);
                }
                case 13: {
                    return NativeError.make(cx, scope, f, args);
                }
            }
        }
        throw f.unknown();
    }
    
    static Object js_parseInt(final Object[] args) {
        final String s = ScriptRuntime.toString(args, 0);
        int radix = ScriptRuntime.toInt32(args, 1);
        final int len = s.length();
        if (len == 0) {
            return ScriptRuntime.NaNobj;
        }
        boolean negative = false;
        int start = 0;
        char c;
        do {
            c = s.charAt(start);
            if (!ScriptRuntime.isStrWhiteSpaceChar(c)) {
                break;
            }
        } while (++start < len);
        if (c == '+' || (negative = (c == '-'))) {
            ++start;
        }
        final int NO_RADIX = -1;
        if (radix == 0) {
            radix = -1;
        }
        else {
            if (radix < 2 || radix > 36) {
                return ScriptRuntime.NaNobj;
            }
            if (radix == 16 && len - start > 1 && s.charAt(start) == '0') {
                c = s.charAt(start + 1);
                if (c == 'x' || c == 'X') {
                    start += 2;
                }
            }
        }
        if (radix == -1) {
            radix = 10;
            if (len - start > 1 && s.charAt(start) == '0') {
                c = s.charAt(start + 1);
                if (c == 'x' || c == 'X') {
                    radix = 16;
                    start += 2;
                }
                else if ('0' <= c && c <= '9') {
                    final Context cx = Context.getCurrentContext();
                    if (cx == null || cx.getLanguageVersion() < 150) {
                        radix = 8;
                        ++start;
                    }
                }
            }
        }
        final double d = ScriptRuntime.stringPrefixToNumber(s, start, radix);
        return ScriptRuntime.wrapNumber(negative ? (-d) : d);
    }
    
    static Object js_parseFloat(final Object[] args) {
        if (args.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        String s = ScriptRuntime.toString(args[0]);
        final int len = s.length();
        int start = 0;
        while (start != len) {
            char c = s.charAt(start);
            if (!ScriptRuntime.isStrWhiteSpaceChar(c)) {
                int i = start;
                if (c == '+' || c == '-') {
                    if (++i == len) {
                        return ScriptRuntime.NaNobj;
                    }
                    c = s.charAt(i);
                }
                if (c == 'I') {
                    if (i + 8 <= len && s.regionMatches(i, "Infinity", 0, 8)) {
                        double d;
                        if (s.charAt(start) == '-') {
                            d = Double.NEGATIVE_INFINITY;
                        }
                        else {
                            d = Double.POSITIVE_INFINITY;
                        }
                        return ScriptRuntime.wrapNumber(d);
                    }
                    return ScriptRuntime.NaNobj;
                }
                else {
                    int decimal = -1;
                    int exponent = -1;
                    boolean exponentValid = false;
                Label_0518:
                    while (i < len) {
                        switch (s.charAt(i)) {
                            case '.': {
                                if (decimal != -1) {
                                    break Label_0518;
                                }
                                decimal = i;
                                break;
                            }
                            case 'E':
                            case 'e': {
                                if (exponent != -1) {
                                    break Label_0518;
                                }
                                if (i == len - 1) {
                                    break Label_0518;
                                }
                                exponent = i;
                                break;
                            }
                            case '+':
                            case '-': {
                                if (exponent != i - 1) {
                                    break Label_0518;
                                }
                                if (i == len - 1) {
                                    --i;
                                    break Label_0518;
                                }
                                break;
                            }
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9': {
                                if (exponent != -1) {
                                    exponentValid = true;
                                    break;
                                }
                                break;
                            }
                            default: {
                                break Label_0518;
                            }
                        }
                        ++i;
                    }
                    if (exponent != -1 && !exponentValid) {
                        i = exponent;
                    }
                    s = s.substring(start, i);
                    try {
                        return Double.valueOf(s);
                    }
                    catch (NumberFormatException ex) {
                        return ScriptRuntime.NaNobj;
                    }
                }
            }
            else {
                ++start;
            }
        }
        return ScriptRuntime.NaNobj;
    }
    
    private Object js_escape(final Object[] args) {
        final int URL_XALPHAS = 1;
        final int URL_XPALPHAS = 2;
        final int URL_PATH = 4;
        final String s = ScriptRuntime.toString(args, 0);
        int mask = 7;
        if (args.length > 1) {
            final double d = ScriptRuntime.toNumber(args[1]);
            if (Double.isNaN(d) || (mask = (int)d) != d || 0x0 != (mask & 0xFFFFFFF8)) {
                throw Context.reportRuntimeError0("msg.bad.esc.mask");
            }
        }
        StringBuilder sb = null;
        for (int k = 0, L = s.length(); k != L; ++k) {
            final int c = s.charAt(k);
            if (mask != 0 && ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 64 || c == 42 || c == 95 || c == 45 || c == 46 || (0x0 != (mask & 0x4) && (c == 47 || c == 43)))) {
                if (sb != null) {
                    sb.append((char)c);
                }
            }
            else {
                if (sb == null) {
                    sb = new StringBuilder(L + 3);
                    sb.append(s);
                    sb.setLength(k);
                }
                int hexSize;
                if (c < 256) {
                    if (c == 32 && mask == 2) {
                        sb.append('+');
                        continue;
                    }
                    sb.append('%');
                    hexSize = 2;
                }
                else {
                    sb.append('%');
                    sb.append('u');
                    hexSize = 4;
                }
                for (int shift = (hexSize - 1) * 4; shift >= 0; shift -= 4) {
                    final int digit = 0xF & c >> shift;
                    final int hc = (digit < 10) ? (48 + digit) : (55 + digit);
                    sb.append((char)hc);
                }
            }
        }
        return (sb == null) ? s : sb.toString();
    }
    
    private Object js_unescape(final Object[] args) {
        String s = ScriptRuntime.toString(args, 0);
        final int firstEscapePos = s.indexOf(37);
        if (firstEscapePos >= 0) {
            final int L = s.length();
            final char[] buf = s.toCharArray();
            int destination = firstEscapePos;
            int k = firstEscapePos;
            while (k != L) {
                char c = buf[k];
                ++k;
                if (c == '%' && k != L) {
                    int start;
                    int end;
                    if (buf[k] == 'u') {
                        start = k + 1;
                        end = k + 5;
                    }
                    else {
                        start = k;
                        end = k + 2;
                    }
                    if (end <= L) {
                        int x = 0;
                        for (int i = start; i != end; ++i) {
                            x = Kit.xDigitToInt((int)buf[i], x);
                        }
                        if (x >= 0) {
                            c = (char)x;
                            k = end;
                        }
                    }
                }
                buf[destination] = c;
                ++destination;
            }
            s = new String(buf, 0, destination);
        }
        return s;
    }
    
    private Object js_eval(final Context cx, final Scriptable scope, final Object[] args) {
        final Scriptable global = ScriptableObject.getTopLevelScope(scope);
        return ScriptRuntime.evalSpecial(cx, global, global, args, "eval code", 1);
    }
    
    static boolean isEvalFunction(final Object functionObj) {
        if (functionObj instanceof IdFunctionObject) {
            final IdFunctionObject function = (IdFunctionObject)functionObj;
            return function.hasTag(NativeGlobal.FTAG) && function.methodId() == 6;
        }
        return false;
    }
    
    @Deprecated
    public static EcmaError constructError(final Context cx, final String error, final String message, final Scriptable scope) {
        return ScriptRuntime.constructError(error, message);
    }
    
    @Deprecated
    public static EcmaError constructError(final Context cx, final String error, final String message, final Scriptable scope, final String sourceName, final int lineNumber, final int columnNumber, final String lineSource) {
        return ScriptRuntime.constructError(error, message, sourceName, lineNumber, lineSource, columnNumber);
    }
    
    private static String encode(final String str, final boolean fullUri) {
        byte[] utf8buf = null;
        StringBuilder sb = null;
        for (int k = 0, length = str.length(); k != length; ++k) {
            final char C = str.charAt(k);
            if (encodeUnescaped(C, fullUri)) {
                if (sb != null) {
                    sb.append(C);
                }
            }
            else {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(str);
                    sb.setLength(k);
                    utf8buf = new byte[6];
                }
                if ('\udc00' <= C && C <= '\udfff') {
                    throw uriError();
                }
                int V;
                if (C < '\ud800' || '\udbff' < C) {
                    V = C;
                }
                else {
                    if (++k == length) {
                        throw uriError();
                    }
                    final char C2 = str.charAt(k);
                    if ('\udc00' > C2 || C2 > '\udfff') {
                        throw uriError();
                    }
                    V = (C - '\ud800' << 10) + (C2 - '\udc00') + 65536;
                }
                for (int L = oneUcs4ToUtf8Char(utf8buf, V), j = 0; j < L; ++j) {
                    final int d = 0xFF & utf8buf[j];
                    sb.append('%');
                    sb.append(toHexChar(d >>> 4));
                    sb.append(toHexChar(d & 0xF));
                }
            }
        }
        return (sb == null) ? str : sb.toString();
    }
    
    private static char toHexChar(final int i) {
        if (i >> 4 != 0) {
            Kit.codeBug();
        }
        return (char)((i < 10) ? (i + 48) : (i - 10 + 65));
    }
    
    private static int unHex(final char c) {
        if ('A' <= c && c <= 'F') {
            return c - 'A' + 10;
        }
        if ('a' <= c && c <= 'f') {
            return c - 'a' + 10;
        }
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        return -1;
    }
    
    private static int unHex(final char c1, final char c2) {
        final int i1 = unHex(c1);
        final int i2 = unHex(c2);
        if (i1 >= 0 && i2 >= 0) {
            return i1 << 4 | i2;
        }
        return -1;
    }
    
    private static String decode(final String str, final boolean fullUri) {
        char[] buf = null;
        int bufTop = 0;
        int k = 0;
        final int length = str.length();
        while (k != length) {
            char C = str.charAt(k);
            if (C != '%') {
                if (buf != null) {
                    buf[bufTop++] = C;
                }
                ++k;
            }
            else {
                if (buf == null) {
                    buf = new char[length];
                    str.getChars(0, k, buf, 0);
                    bufTop = k;
                }
                final int start = k;
                if (k + 3 > length) {
                    throw uriError();
                }
                int B = unHex(str.charAt(k + 1), str.charAt(k + 2));
                if (B < 0) {
                    throw uriError();
                }
                k += 3;
                if ((B & 0x80) == 0x0) {
                    C = (char)B;
                }
                else {
                    if ((B & 0xC0) == 0x80) {
                        throw uriError();
                    }
                    int utf8Tail;
                    int ucs4Char;
                    int minUcs4Char;
                    if ((B & 0x20) == 0x0) {
                        utf8Tail = 1;
                        ucs4Char = (B & 0x1F);
                        minUcs4Char = 128;
                    }
                    else if ((B & 0x10) == 0x0) {
                        utf8Tail = 2;
                        ucs4Char = (B & 0xF);
                        minUcs4Char = 2048;
                    }
                    else if ((B & 0x8) == 0x0) {
                        utf8Tail = 3;
                        ucs4Char = (B & 0x7);
                        minUcs4Char = 65536;
                    }
                    else if ((B & 0x4) == 0x0) {
                        utf8Tail = 4;
                        ucs4Char = (B & 0x3);
                        minUcs4Char = 2097152;
                    }
                    else {
                        if ((B & 0x2) != 0x0) {
                            throw uriError();
                        }
                        utf8Tail = 5;
                        ucs4Char = (B & 0x1);
                        minUcs4Char = 67108864;
                    }
                    if (k + 3 * utf8Tail > length) {
                        throw uriError();
                    }
                    for (int j = 0; j != utf8Tail; ++j) {
                        if (str.charAt(k) != '%') {
                            throw uriError();
                        }
                        B = unHex(str.charAt(k + 1), str.charAt(k + 2));
                        if (B < 0 || (B & 0xC0) != 0x80) {
                            throw uriError();
                        }
                        ucs4Char = (ucs4Char << 6 | (B & 0x3F));
                        k += 3;
                    }
                    if (ucs4Char < minUcs4Char || (ucs4Char >= 55296 && ucs4Char <= 57343)) {
                        ucs4Char = Integer.MAX_VALUE;
                    }
                    else if (ucs4Char == 65534 || ucs4Char == 65535) {
                        ucs4Char = 65533;
                    }
                    if (ucs4Char >= 65536) {
                        ucs4Char -= 65536;
                        if (ucs4Char > 1048575) {
                            throw uriError();
                        }
                        final char H = (char)((ucs4Char >>> 10) + 55296);
                        C = (char)((ucs4Char & 0x3FF) + 56320);
                        buf[bufTop++] = H;
                    }
                    else {
                        C = (char)ucs4Char;
                    }
                }
                if (fullUri && ";/?:@&=+$,#".indexOf(C) >= 0) {
                    for (int x = start; x != k; ++x) {
                        buf[bufTop++] = str.charAt(x);
                    }
                }
                else {
                    buf[bufTop++] = C;
                }
            }
        }
        return (buf == null) ? str : new String(buf, 0, bufTop);
    }
    
    private static boolean encodeUnescaped(final char c, final boolean fullUri) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || "-_.!~*'()".indexOf(c) >= 0 || (fullUri && ";/?:@&=+$,#".indexOf(c) >= 0);
    }
    
    private static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessage0("msg.bad.uri"));
    }
    
    private static int oneUcs4ToUtf8Char(final byte[] utf8Buffer, int ucs4Char) {
        int utf8Length = 1;
        if ((ucs4Char & 0xFFFFFF80) == 0x0) {
            utf8Buffer[0] = (byte)ucs4Char;
        }
        else {
            int a;
            for (a = ucs4Char >>> 11, utf8Length = 2; a != 0; a >>>= 5, ++utf8Length) {}
            int i = utf8Length;
            while (--i > 0) {
                utf8Buffer[i] = (byte)((ucs4Char & 0x3F) | 0x80);
                ucs4Char >>>= 6;
            }
            utf8Buffer[0] = (byte)(256 - (1 << 8 - utf8Length) + ucs4Char);
        }
        return utf8Length;
    }
    
    static {
        FTAG = "Global";
    }
}
