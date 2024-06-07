//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.regexp.*;
import java.text.*;
import java.util.*;

final class NativeString extends IdScriptableObject
{
    private static final long serialVersionUID = 920268368584188687L;
    private static final Object STRING_TAG;
    private static final int Id_length = 1;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int ConstructorId_fromCharCode = -1;
    private static final int ConstructorId_fromCodePoint = -2;
    private static final int ConstructorId_raw = -3;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toSource = 3;
    private static final int Id_valueOf = 4;
    private static final int Id_charAt = 5;
    private static final int Id_charCodeAt = 6;
    private static final int Id_indexOf = 7;
    private static final int Id_lastIndexOf = 8;
    private static final int Id_split = 9;
    private static final int Id_substring = 10;
    private static final int Id_toLowerCase = 11;
    private static final int Id_toUpperCase = 12;
    private static final int Id_substr = 13;
    private static final int Id_concat = 14;
    private static final int Id_slice = 15;
    private static final int Id_bold = 16;
    private static final int Id_italics = 17;
    private static final int Id_fixed = 18;
    private static final int Id_strike = 19;
    private static final int Id_small = 20;
    private static final int Id_big = 21;
    private static final int Id_blink = 22;
    private static final int Id_sup = 23;
    private static final int Id_sub = 24;
    private static final int Id_fontsize = 25;
    private static final int Id_fontcolor = 26;
    private static final int Id_link = 27;
    private static final int Id_anchor = 28;
    private static final int Id_equals = 29;
    private static final int Id_equalsIgnoreCase = 30;
    private static final int Id_match = 31;
    private static final int Id_search = 32;
    private static final int Id_replace = 33;
    private static final int Id_replaceAll = 34;
    private static final int Id_localeCompare = 35;
    private static final int Id_toLocaleLowerCase = 36;
    private static final int Id_toLocaleUpperCase = 37;
    private static final int Id_trim = 38;
    private static final int Id_trimLeft = 39;
    private static final int Id_trimRight = 40;
    private static final int Id_includes = 41;
    private static final int Id_startsWith = 42;
    private static final int Id_endsWith = 43;
    private static final int Id_normalize = 44;
    private static final int Id_repeat = 45;
    private static final int Id_codePointAt = 46;
    private static final int Id_padStart = 47;
    private static final int Id_padEnd = 48;
    private static final int SymbolId_iterator = 49;
    private static final int MAX_PROTOTYPE_ID = 49;
    private static final int ConstructorId_charAt = -5;
    private static final int ConstructorId_charCodeAt = -6;
    private static final int ConstructorId_indexOf = -7;
    private static final int ConstructorId_lastIndexOf = -8;
    private static final int ConstructorId_split = -9;
    private static final int ConstructorId_substring = -10;
    private static final int ConstructorId_toLowerCase = -11;
    private static final int ConstructorId_toUpperCase = -12;
    private static final int ConstructorId_substr = -13;
    private static final int ConstructorId_concat = -14;
    private static final int ConstructorId_slice = -15;
    private static final int ConstructorId_equalsIgnoreCase = -30;
    private static final int ConstructorId_match = -31;
    private static final int ConstructorId_search = -32;
    private static final int ConstructorId_replace = -33;
    private static final int ConstructorId_replaceAll = -34;
    private static final int ConstructorId_localeCompare = -35;
    private static final int ConstructorId_toLocaleLowerCase = -36;
    private CharSequence string;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeString obj = new NativeString("");
        obj.exportAsJSClass(49, scope, sealed);
    }
    
    NativeString(final CharSequence s) {
        this.string = s;
    }
    
    public String getClassName() {
        return "String";
    }
    
    protected int getMaxInstanceId() {
        return 1;
    }
    
    protected int findInstanceIdInfo(final String s) {
        if ("length".equals(s)) {
            return instanceIdInfo(7, 1);
        }
        return super.findInstanceIdInfo(s);
    }
    
    protected String getInstanceIdName(final int id) {
        if (id == 1) {
            return "length";
        }
        return super.getInstanceIdName(id);
    }
    
    protected Object getInstanceIdValue(final int id) {
        if (id == 1) {
            return ScriptRuntime.wrapInt(this.string.length());
        }
        return super.getInstanceIdValue(id);
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -3, "raw", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -1, "fromCharCode", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -2, "fromCodePoint", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -5, "charAt", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -6, "charCodeAt", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -7, "indexOf", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -8, "lastIndexOf", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -9, "split", 3);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -10, "substring", 3);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -11, "toLowerCase", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -12, "toUpperCase", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -13, "substr", 3);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -14, "concat", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -15, "slice", 3);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -30, "equalsIgnoreCase", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -31, "match", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -32, "search", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -33, "replace", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -34, "replaceAll", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -35, "localeCompare", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeString.STRING_TAG, -36, "toLocaleLowerCase", 1);
        super.fillConstructorProperties(ctor);
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 49) {
            this.initPrototypeMethod(NativeString.STRING_TAG, id, (Symbol)SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        final String fnName = null;
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 1;
                s = "constructor";
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
                arity = 0;
                s = "valueOf";
                break;
            }
            case 5: {
                arity = 1;
                s = "charAt";
                break;
            }
            case 6: {
                arity = 1;
                s = "charCodeAt";
                break;
            }
            case 7: {
                arity = 1;
                s = "indexOf";
                break;
            }
            case 8: {
                arity = 1;
                s = "lastIndexOf";
                break;
            }
            case 9: {
                arity = 2;
                s = "split";
                break;
            }
            case 10: {
                arity = 2;
                s = "substring";
                break;
            }
            case 11: {
                arity = 0;
                s = "toLowerCase";
                break;
            }
            case 12: {
                arity = 0;
                s = "toUpperCase";
                break;
            }
            case 13: {
                arity = 2;
                s = "substr";
                break;
            }
            case 14: {
                arity = 1;
                s = "concat";
                break;
            }
            case 15: {
                arity = 2;
                s = "slice";
                break;
            }
            case 16: {
                arity = 0;
                s = "bold";
                break;
            }
            case 17: {
                arity = 0;
                s = "italics";
                break;
            }
            case 18: {
                arity = 0;
                s = "fixed";
                break;
            }
            case 19: {
                arity = 0;
                s = "strike";
                break;
            }
            case 20: {
                arity = 0;
                s = "small";
                break;
            }
            case 21: {
                arity = 0;
                s = "big";
                break;
            }
            case 22: {
                arity = 0;
                s = "blink";
                break;
            }
            case 23: {
                arity = 0;
                s = "sup";
                break;
            }
            case 24: {
                arity = 0;
                s = "sub";
                break;
            }
            case 25: {
                arity = 0;
                s = "fontsize";
                break;
            }
            case 26: {
                arity = 0;
                s = "fontcolor";
                break;
            }
            case 27: {
                arity = 0;
                s = "link";
                break;
            }
            case 28: {
                arity = 0;
                s = "anchor";
                break;
            }
            case 29: {
                arity = 1;
                s = "equals";
                break;
            }
            case 30: {
                arity = 1;
                s = "equalsIgnoreCase";
                break;
            }
            case 31: {
                arity = 1;
                s = "match";
                break;
            }
            case 32: {
                arity = 1;
                s = "search";
                break;
            }
            case 33: {
                arity = 2;
                s = "replace";
                break;
            }
            case 34: {
                arity = 2;
                s = "replaceAll";
                break;
            }
            case 35: {
                arity = 1;
                s = "localeCompare";
                break;
            }
            case 36: {
                arity = 0;
                s = "toLocaleLowerCase";
                break;
            }
            case 37: {
                arity = 0;
                s = "toLocaleUpperCase";
                break;
            }
            case 38: {
                arity = 0;
                s = "trim";
                break;
            }
            case 39: {
                arity = 0;
                s = "trimLeft";
                break;
            }
            case 40: {
                arity = 0;
                s = "trimRight";
                break;
            }
            case 41: {
                arity = 1;
                s = "includes";
                break;
            }
            case 42: {
                arity = 1;
                s = "startsWith";
                break;
            }
            case 43: {
                arity = 1;
                s = "endsWith";
                break;
            }
            case 44: {
                arity = 0;
                s = "normalize";
                break;
            }
            case 45: {
                arity = 1;
                s = "repeat";
                break;
            }
            case 46: {
                arity = 1;
                s = "codePointAt";
                break;
            }
            case 47: {
                arity = 1;
                s = "padStart";
                break;
            }
            case 48: {
                arity = 1;
                s = "padEnd";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeString.STRING_TAG, id, s, fnName, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, Scriptable thisObj, Object[] args) {
        if (!f.hasTag(NativeString.STRING_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        int id = f.methodId();
        while (true) {
            switch (id) {
                case -36:
                case -35:
                case -34:
                case -33:
                case -32:
                case -31:
                case -30:
                case -15:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -6:
                case -5: {
                    if (args.length > 0) {
                        thisObj = ScriptRuntime.toObject(cx, scope, ScriptRuntime.toCharSequence(args[0]));
                        final Object[] newArgs = new Object[args.length - 1];
                        for (int i = 0; i < newArgs.length; ++i) {
                            newArgs[i] = args[i + 1];
                        }
                        args = newArgs;
                    }
                    else {
                        thisObj = ScriptRuntime.toObject(cx, scope, ScriptRuntime.toCharSequence(thisObj));
                    }
                    id = -id;
                    continue;
                }
                case -1: {
                    final int N = args.length;
                    if (N < 1) {
                        return "";
                    }
                    final StringBuilder sb = new StringBuilder(N);
                    for (int j = 0; j != N; ++j) {
                        sb.append(ScriptRuntime.toUint16(args[j]));
                    }
                    return sb.toString();
                }
                case -2: {
                    return this.js_fromCodePoint(args);
                }
                case -3: {
                    return js_raw(cx, scope, thisObj, args);
                }
                case 1: {
                    CharSequence s;
                    if (args.length == 0) {
                        s = "";
                    }
                    else if (ScriptRuntime.isSymbol(args[0]) && thisObj != null) {
                        s = args[0].toString();
                    }
                    else {
                        s = ScriptRuntime.toCharSequence(args[0]);
                    }
                    if (thisObj == null) {
                        return new NativeString(s);
                    }
                    return (s instanceof String) ? s : s.toString();
                }
                case 2:
                case 4: {
                    final CharSequence cs = realThis(thisObj, f).string;
                    return (cs instanceof String) ? cs : cs.toString();
                }
                case 3: {
                    final CharSequence s2 = realThis(thisObj, f).string;
                    return "(new String(\"" + ScriptRuntime.escapeString(s2.toString()) + "\"))";
                }
                case 5:
                case 6: {
                    final CharSequence target = ScriptRuntime.toCharSequence(thisObj);
                    final double pos = ScriptRuntime.toInteger(args, 0);
                    if (pos < 0.0 || pos >= target.length()) {
                        if (id == 5) {
                            return "";
                        }
                        return ScriptRuntime.NaNobj;
                    }
                    else {
                        final char c = target.charAt((int)pos);
                        if (id == 5) {
                            return String.valueOf(c);
                        }
                        return ScriptRuntime.wrapInt(c);
                    }
                    break;
                }
                case 7: {
                    return ScriptRuntime.wrapInt(js_indexOf(7, ScriptRuntime.toString(thisObj), args));
                }
                case 41:
                case 42:
                case 43: {
                    final String s3 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(cx, thisObj, f));
                    if (args.length > 0 && args[0] instanceof NativeRegExp) {
                        throw ScriptRuntime.typeError2("msg.first.arg.not.regexp", String.class.getSimpleName(), f.getFunctionName());
                    }
                    final int idx = js_indexOf(id, s3, args);
                    if (id == 41) {
                        return idx != -1;
                    }
                    if (id == 42) {
                        return idx == 0;
                    }
                    return idx != -1;
                }
                case 47:
                case 48: {
                    return js_pad(cx, thisObj, f, args, id == 47);
                }
                case 8: {
                    return ScriptRuntime.wrapInt(js_lastIndexOf(ScriptRuntime.toString(thisObj), args));
                }
                case 9: {
                    return ScriptRuntime.checkRegExpProxy(cx).js_split(cx, scope, ScriptRuntime.toString(thisObj), args);
                }
                case 10: {
                    return js_substring(cx, ScriptRuntime.toCharSequence(thisObj), args);
                }
                case 11: {
                    return ScriptRuntime.toString(thisObj).toLowerCase(ScriptRuntime.ROOT_LOCALE);
                }
                case 12: {
                    return ScriptRuntime.toString(thisObj).toUpperCase(ScriptRuntime.ROOT_LOCALE);
                }
                case 13: {
                    return js_substr(ScriptRuntime.toCharSequence(thisObj), args);
                }
                case 14: {
                    return js_concat(ScriptRuntime.toString(thisObj), args);
                }
                case 15: {
                    return js_slice(ScriptRuntime.toCharSequence(thisObj), args);
                }
                case 16: {
                    return tagify(thisObj, "b", null, null);
                }
                case 17: {
                    return tagify(thisObj, "i", null, null);
                }
                case 18: {
                    return tagify(thisObj, "tt", null, null);
                }
                case 19: {
                    return tagify(thisObj, "strike", null, null);
                }
                case 20: {
                    return tagify(thisObj, "small", null, null);
                }
                case 21: {
                    return tagify(thisObj, "big", null, null);
                }
                case 22: {
                    return tagify(thisObj, "blink", null, null);
                }
                case 23: {
                    return tagify(thisObj, "sup", null, null);
                }
                case 24: {
                    return tagify(thisObj, "sub", null, null);
                }
                case 25: {
                    return tagify(thisObj, "font", "size", args);
                }
                case 26: {
                    return tagify(thisObj, "font", "color", args);
                }
                case 27: {
                    return tagify(thisObj, "a", "href", args);
                }
                case 28: {
                    return tagify(thisObj, "a", "name", args);
                }
                case 29:
                case 30: {
                    final String s4 = ScriptRuntime.toString(thisObj);
                    final String s5 = ScriptRuntime.toString(args, 0);
                    return ScriptRuntime.wrapBoolean((id == 29) ? s4.equals(s5) : s4.equalsIgnoreCase(s5));
                }
                case 31:
                case 32:
                case 33:
                case 34: {
                    int actionType;
                    if (id == 31) {
                        actionType = 1;
                    }
                    else if (id == 33) {
                        actionType = 2;
                    }
                    else if (id == 34) {
                        actionType = 3;
                    }
                    else {
                        actionType = 4;
                    }
                    return ScriptRuntime.checkRegExpProxy(cx).action(cx, scope, thisObj, args, actionType);
                }
                case 35: {
                    final Collator collator = Collator.getInstance(cx.getLocale());
                    collator.setStrength(3);
                    collator.setDecomposition(1);
                    return ScriptRuntime.wrapNumber(collator.compare(ScriptRuntime.toString(thisObj), ScriptRuntime.toString(args, 0)));
                }
                case 36: {
                    return ScriptRuntime.toString(thisObj).toLowerCase(cx.getLocale());
                }
                case 37: {
                    return ScriptRuntime.toString(thisObj).toUpperCase(cx.getLocale());
                }
                case 38: {
                    final String str = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(cx, thisObj, f));
                    char[] chars;
                    int start;
                    for (chars = str.toCharArray(), start = 0; start < chars.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(chars[start]); ++start) {}
                    int end;
                    for (end = chars.length; end > start && ScriptRuntime.isJSWhitespaceOrLineTerminator(chars[end - 1]); --end) {}
                    return str.substring(start, end);
                }
                case 39: {
                    final String str = ScriptRuntime.toString(thisObj);
                    char[] chars;
                    int start;
                    for (chars = str.toCharArray(), start = 0; start < chars.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(chars[start]); ++start) {}
                    final int end = chars.length;
                    return str.substring(start, end);
                }
                case 40: {
                    final String str = ScriptRuntime.toString(thisObj);
                    char[] chars;
                    int start;
                    int end;
                    for (chars = str.toCharArray(), start = 0, end = chars.length; end > start && ScriptRuntime.isJSWhitespaceOrLineTerminator(chars[end - 1]); --end) {}
                    return str.substring(start, end);
                }
                case 44: {
                    final String formStr = ScriptRuntime.toString(args, 0);
                    Normalizer.Form form;
                    if (Normalizer.Form.NFD.name().equals(formStr)) {
                        form = Normalizer.Form.NFD;
                    }
                    else if (Normalizer.Form.NFKC.name().equals(formStr)) {
                        form = Normalizer.Form.NFKC;
                    }
                    else if (Normalizer.Form.NFKD.name().equals(formStr)) {
                        form = Normalizer.Form.NFKD;
                    }
                    else {
                        if (!Normalizer.Form.NFC.name().equals(formStr) && args.length != 0) {
                            throw ScriptRuntime.rangeError("The normalization form should be one of NFC, NFD, NFKC, NFKD");
                        }
                        form = Normalizer.Form.NFC;
                    }
                    return Normalizer.normalize(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(cx, thisObj, f)), form);
                }
                case 45: {
                    return js_repeat(cx, thisObj, f, args);
                }
                case 46: {
                    final String str = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(cx, thisObj, f));
                    final double cnt = ScriptRuntime.toInteger(args, 0);
                    return (cnt < 0.0 || cnt >= str.length()) ? Undefined.instance : Integer.valueOf(str.codePointAt((int)cnt));
                }
                case 49: {
                    return new NativeStringIterator(scope, thisObj, args.length > 0 && ScriptRuntime.toBoolean(args[0]));
                }
                default: {
                    throw new IllegalArgumentException("String.prototype has no method: " + f.getFunctionName());
                }
            }
        }
    }
    
    private static NativeString realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeString)) {
            throw incompatibleCallError(f);
        }
        return (NativeString)unwrappedThis;
    }
    
    private static String tagify(final Object thisObj, final String tag, final String attribute, final Object[] args) {
        final String str = ScriptRuntime.toString(thisObj);
        final StringBuilder result = new StringBuilder();
        result.append('<');
        result.append(tag);
        if (attribute != null) {
            result.append(' ');
            result.append(attribute);
            result.append("=\"");
            result.append(ScriptRuntime.toString(args, 0).replace("\"", "&quot;"));
            result.append('\"');
        }
        result.append('>');
        result.append(str);
        result.append("</");
        result.append(tag);
        result.append('>');
        return result.toString();
    }
    
    public CharSequence toCharSequence() {
        return this.string;
    }
    
    public String toString() {
        return (String)((this.string instanceof String) ? this.string : this.string.toString());
    }
    
    public Object get(final int index, final Scriptable start) {
        if (0 <= index && index < this.string.length()) {
            return String.valueOf(this.string.charAt(index));
        }
        return super.get(index, start);
    }
    
    public void put(final int index, final Scriptable start, final Object value) {
        if (0 <= index && index < this.string.length()) {
            return;
        }
        super.put(index, start, value);
    }
    
    public boolean has(final int index, final Scriptable start) {
        return (0 <= index && index < this.string.length()) || super.has(index, start);
    }
    
    public int getAttributes(final int index) {
        if (0 <= index && index < this.string.length()) {
            int attribs = 5;
            if (Context.getContext().getLanguageVersion() < 200) {
                attribs |= 0x2;
            }
            return attribs;
        }
        return super.getAttributes(index);
    }
    
    public Object[] getIds(final boolean nonEnumerable, final boolean getSymbols) {
        final Context cx = Context.getCurrentContext();
        if (cx != null && cx.getLanguageVersion() >= 200) {
            final Object[] sids = super.getIds(nonEnumerable, getSymbols);
            final Object[] a = new Object[sids.length + this.string.length()];
            int i;
            for (i = 0; i < this.string.length(); ++i) {
                a[i] = i;
            }
            System.arraycopy(sids, 0, a, i, sids.length);
            return a;
        }
        return super.getIds(nonEnumerable, getSymbols);
    }
    
    private static int js_indexOf(final int methodId, final String target, final Object[] args) {
        final String searchStr = ScriptRuntime.toString(args, 0);
        double position = ScriptRuntime.toInteger(args, 1);
        if (position > target.length() && methodId != 42 && methodId != 43) {
            return -1;
        }
        if (position < 0.0) {
            position = 0.0;
        }
        else if (position > target.length()) {
            position = target.length();
        }
        else if (methodId == 43 && (Double.isNaN(position) || position > target.length())) {
            position = target.length();
        }
        if (43 == methodId) {
            if (args.length == 0 || args.length == 1 || (args.length == 2 && args[1] == Undefined.instance)) {
                position = target.length();
            }
            return target.substring(0, (int)position).endsWith(searchStr) ? 0 : -1;
        }
        return (methodId == 42) ? (target.startsWith(searchStr, (int)position) ? 0 : -1) : target.indexOf(searchStr, (int)position);
    }
    
    private static int js_lastIndexOf(final String target, final Object[] args) {
        final String search = ScriptRuntime.toString(args, 0);
        double end = ScriptRuntime.toNumber(args, 1);
        if (Double.isNaN(end) || end > target.length()) {
            end = target.length();
        }
        else if (end < 0.0) {
            end = 0.0;
        }
        return target.lastIndexOf(search, (int)end);
    }
    
    private static CharSequence js_substring(final Context cx, final CharSequence target, final Object[] args) {
        final int length = target.length();
        double start = ScriptRuntime.toInteger(args, 0);
        if (start < 0.0) {
            start = 0.0;
        }
        else if (start > length) {
            start = length;
        }
        double end;
        if (args.length <= 1 || args[1] == Undefined.instance) {
            end = length;
        }
        else {
            end = ScriptRuntime.toInteger(args[1]);
            if (end < 0.0) {
                end = 0.0;
            }
            else if (end > length) {
                end = length;
            }
            if (end < start) {
                if (cx.getLanguageVersion() != 120) {
                    final double temp = start;
                    start = end;
                    end = temp;
                }
                else {
                    end = start;
                }
            }
        }
        return target.subSequence((int)start, (int)end);
    }
    
    int getLength() {
        return this.string.length();
    }
    
    private static CharSequence js_substr(final CharSequence target, final Object[] args) {
        if (args.length < 1) {
            return target;
        }
        double begin = ScriptRuntime.toInteger(args[0]);
        final int length = target.length();
        if (begin < 0.0) {
            begin += length;
            if (begin < 0.0) {
                begin = 0.0;
            }
        }
        else if (begin > length) {
            begin = length;
        }
        double end;
        if (args.length == 1) {
            end = length;
        }
        else {
            end = ScriptRuntime.toInteger(args[1]);
            if (end < 0.0) {
                end = 0.0;
            }
            end += begin;
            if (end > length) {
                end = length;
            }
        }
        return target.subSequence((int)begin, (int)end);
    }
    
    private static String js_concat(final String target, final Object[] args) {
        final int N = args.length;
        if (N == 0) {
            return target;
        }
        if (N == 1) {
            final String arg = ScriptRuntime.toString(args[0]);
            return target.concat(arg);
        }
        int size = target.length();
        final String[] argsAsStrings = new String[N];
        for (int i = 0; i != N; ++i) {
            final String s = ScriptRuntime.toString(args[i]);
            argsAsStrings[i] = s;
            size += s.length();
        }
        final StringBuilder result = new StringBuilder(size);
        result.append(target);
        for (int j = 0; j != N; ++j) {
            result.append(argsAsStrings[j]);
        }
        return result.toString();
    }
    
    private static CharSequence js_slice(final CharSequence target, final Object[] args) {
        double begin = (args.length < 1) ? 0.0 : ScriptRuntime.toInteger(args[0]);
        final int length = target.length();
        if (begin < 0.0) {
            begin += length;
            if (begin < 0.0) {
                begin = 0.0;
            }
        }
        else if (begin > length) {
            begin = length;
        }
        double end;
        if (args.length < 2 || args[1] == Undefined.instance) {
            end = length;
        }
        else {
            end = ScriptRuntime.toInteger(args[1]);
            if (end < 0.0) {
                end += length;
                if (end < 0.0) {
                    end = 0.0;
                }
            }
            else if (end > length) {
                end = length;
            }
            if (end < begin) {
                end = begin;
            }
        }
        return target.subSequence((int)begin, (int)end);
    }
    
    private static String js_repeat(final Context cx, final Scriptable thisObj, final IdFunctionObject f, final Object[] args) {
        final String str = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(cx, thisObj, f));
        final double cnt = ScriptRuntime.toInteger(args, 0);
        if (cnt < 0.0 || cnt == Double.POSITIVE_INFINITY) {
            throw ScriptRuntime.rangeError("Invalid count value");
        }
        if (cnt == 0.0 || str.length() == 0) {
            return "";
        }
        final long size = str.length() * (long)cnt;
        if (cnt > 2.147483647E9 || size > 2147483647L) {
            throw ScriptRuntime.rangeError("Invalid size or count value");
        }
        final StringBuilder retval = new StringBuilder((int)size);
        retval.append(str);
        int i;
        int icnt;
        for (i = 1, icnt = (int)cnt; i <= icnt / 2; i *= 2) {
            retval.append((CharSequence)retval);
        }
        if (i < icnt) {
            retval.append(retval.substring(0, str.length() * (icnt - i)));
        }
        return retval.toString();
    }
    
    private static String js_pad(final Context cx, final Scriptable thisObj, final IdFunctionObject f, final Object[] args, final Boolean atStart) {
        final String pad = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(cx, thisObj, f));
        final long intMaxLength = ScriptRuntime.toLength(args, 0);
        if (intMaxLength <= pad.length()) {
            return pad;
        }
        String filler = " ";
        if (args.length >= 2 && !Undefined.isUndefined(args[1])) {
            filler = ScriptRuntime.toString(args[1]);
            if (filler.length() < 1) {
                return pad;
            }
        }
        final int fillLen = (int)(intMaxLength - pad.length());
        final StringBuilder concat = new StringBuilder();
        do {
            concat.append(filler);
        } while (concat.length() < fillLen);
        concat.setLength(fillLen);
        if (atStart) {
            return concat.append(pad).toString();
        }
        return concat.insert(0, pad).toString();
    }
    
    private static String js_raw(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (args.length == 0 || !(args[0] instanceof Scriptable)) {
            throw ScriptRuntime.typeError0("msg.undef.to.object");
        }
        final Object[] substitutions = (args.length > 1) ? Arrays.copyOfRange(args, 1, args.length) : new Object[0];
        final Object cooked = ScriptRuntime.toObject(cx, scope, args[0]);
        final Object rawObj = ScriptRuntime.toObject(cx, scope, ScriptableObject.getProperty(cooked, "raw"));
        final Scriptable raw = ScriptableObject.ensureScriptable(rawObj);
        final long literalSegments = NativeArray.getLengthProperty(raw, false);
        if (literalSegments <= 0L) {
            return "";
        }
        final StringBuilder stringElements = new StringBuilder();
        int nextIndex = 0;
        while (true) {
            stringElements.append(ScriptRuntime.toString(ScriptableObject.getProperty(raw, nextIndex)));
            if (nextIndex + 1 == literalSegments) {
                break;
            }
            final Object next = (nextIndex < substitutions.length) ? substitutions[nextIndex] : "";
            stringElements.append(ScriptRuntime.toString(next));
            ++nextIndex;
        }
        return stringElements.toString();
    }
    
    private String js_fromCodePoint(final Object[] args) {
        final StringBuilder sb = new StringBuilder();
        for (final Object arg : args) {
            final double codePointD = ScriptRuntime.toNumber(arg);
            if (codePointD < 0.0 || codePointD > 1114111.0 || Math.floor(codePointD) != codePointD) {
                throw ScriptRuntime.rangeError(codePointD + " is not a valid code point");
            }
            int codePoint = (int)codePointD;
            if (codePoint <= 65535) {
                sb.append((char)codePoint);
            }
            else {
                codePoint -= 65536;
                sb.append((char)((codePoint >> 10) + 55296));
                sb.append((char)(codePoint % 1024 + 56320));
            }
        }
        return sb.toString();
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (SymbolKey.ITERATOR.equals(k)) {
            return 49;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        Label_1205: {
            switch (s.length()) {
                case 3: {
                    final int c = s.charAt(2);
                    if (c == 98) {
                        if (s.charAt(0) == 's' && s.charAt(1) == 'u') {
                            id = 24;
                            return id;
                        }
                        break;
                    }
                    else if (c == 103) {
                        if (s.charAt(0) == 'b' && s.charAt(1) == 'i') {
                            id = 21;
                            return id;
                        }
                        break;
                    }
                    else {
                        if (c == 112 && s.charAt(0) == 's' && s.charAt(1) == 'u') {
                            id = 23;
                            return id;
                        }
                        break;
                    }
                    break;
                }
                case 4: {
                    final int c = s.charAt(0);
                    if (c == 98) {
                        X = "bold";
                        id = 16;
                        break;
                    }
                    if (c == 108) {
                        X = "link";
                        id = 27;
                        break;
                    }
                    if (c == 116) {
                        X = "trim";
                        id = 38;
                        break;
                    }
                    break;
                }
                case 5: {
                    switch (s.charAt(4)) {
                        case 'd': {
                            X = "fixed";
                            id = 18;
                            break Label_1205;
                        }
                        case 'e': {
                            X = "slice";
                            id = 15;
                            break Label_1205;
                        }
                        case 'h': {
                            X = "match";
                            id = 31;
                            break Label_1205;
                        }
                        case 'k': {
                            X = "blink";
                            id = 22;
                            break Label_1205;
                        }
                        case 'l': {
                            X = "small";
                            id = 20;
                            break Label_1205;
                        }
                        case 't': {
                            X = "split";
                            id = 9;
                            break Label_1205;
                        }
                        default: {
                            break Label_1205;
                        }
                    }
                    break;
                }
                case 6: {
                    switch (s.charAt(1)) {
                        case 'a': {
                            X = "padEnd";
                            id = 48;
                            break Label_1205;
                        }
                        case 'e': {
                            final int c = s.charAt(0);
                            if (c == 114) {
                                X = "repeat";
                                id = 45;
                                break Label_1205;
                            }
                            if (c == 115) {
                                X = "search";
                                id = 32;
                                break Label_1205;
                            }
                            break Label_1205;
                        }
                        case 'h': {
                            X = "charAt";
                            id = 5;
                            break Label_1205;
                        }
                        case 'n': {
                            X = "anchor";
                            id = 28;
                            break Label_1205;
                        }
                        case 'o': {
                            X = "concat";
                            id = 14;
                            break Label_1205;
                        }
                        case 'q': {
                            X = "equals";
                            id = 29;
                            break Label_1205;
                        }
                        case 't': {
                            X = "strike";
                            id = 19;
                            break Label_1205;
                        }
                        case 'u': {
                            X = "substr";
                            id = 13;
                            break Label_1205;
                        }
                        default: {
                            break Label_1205;
                        }
                    }
                    break;
                }
                case 7: {
                    switch (s.charAt(1)) {
                        case 'a': {
                            X = "valueOf";
                            id = 4;
                            break Label_1205;
                        }
                        case 'e': {
                            X = "replace";
                            id = 33;
                            break Label_1205;
                        }
                        case 'n': {
                            X = "indexOf";
                            id = 7;
                            break Label_1205;
                        }
                        case 't': {
                            X = "italics";
                            id = 17;
                            break Label_1205;
                        }
                        default: {
                            break Label_1205;
                        }
                    }
                    break;
                }
                case 8: {
                    switch (s.charAt(6)) {
                        case 'c': {
                            X = "toSource";
                            id = 3;
                            break Label_1205;
                        }
                        case 'e': {
                            X = "includes";
                            id = 41;
                            break Label_1205;
                        }
                        case 'f': {
                            X = "trimLeft";
                            id = 39;
                            break Label_1205;
                        }
                        case 'n': {
                            X = "toString";
                            id = 2;
                            break Label_1205;
                        }
                        case 'r': {
                            X = "padStart";
                            id = 47;
                            break Label_1205;
                        }
                        case 't': {
                            X = "endsWith";
                            id = 43;
                            break Label_1205;
                        }
                        case 'z': {
                            X = "fontsize";
                            id = 25;
                            break Label_1205;
                        }
                        default: {
                            break Label_1205;
                        }
                    }
                    break;
                }
                case 9: {
                    switch (s.charAt(0)) {
                        case 'f': {
                            X = "fontcolor";
                            id = 26;
                            break Label_1205;
                        }
                        case 'n': {
                            X = "normalize";
                            id = 44;
                            break Label_1205;
                        }
                        case 's': {
                            X = "substring";
                            id = 10;
                            break Label_1205;
                        }
                        case 't': {
                            X = "trimRight";
                            id = 40;
                            break Label_1205;
                        }
                        default: {
                            break Label_1205;
                        }
                    }
                    break;
                }
                case 10: {
                    final int c = s.charAt(0);
                    if (c == 99) {
                        X = "charCodeAt";
                        id = 6;
                        break;
                    }
                    if (c == 114) {
                        X = "replaceAll";
                        id = 34;
                        break;
                    }
                    if (c == 115) {
                        X = "startsWith";
                        id = 42;
                        break;
                    }
                    break;
                }
                case 11: {
                    switch (s.charAt(2)) {
                        case 'L': {
                            X = "toLowerCase";
                            id = 11;
                            break Label_1205;
                        }
                        case 'U': {
                            X = "toUpperCase";
                            id = 12;
                            break Label_1205;
                        }
                        case 'd': {
                            X = "codePointAt";
                            id = 46;
                            break Label_1205;
                        }
                        case 'n': {
                            X = "constructor";
                            id = 1;
                            break Label_1205;
                        }
                        case 's': {
                            X = "lastIndexOf";
                            id = 8;
                            break Label_1205;
                        }
                        default: {
                            break Label_1205;
                        }
                    }
                    break;
                }
                case 13: {
                    X = "localeCompare";
                    id = 35;
                    break;
                }
                case 16: {
                    X = "equalsIgnoreCase";
                    id = 30;
                    break;
                }
                case 17: {
                    final int c = s.charAt(8);
                    if (c == 76) {
                        X = "toLocaleLowerCase";
                        id = 36;
                        break;
                    }
                    if (c == 85) {
                        X = "toLocaleUpperCase";
                        id = 37;
                        break;
                    }
                    break;
                }
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        STRING_TAG = "String";
    }
}
