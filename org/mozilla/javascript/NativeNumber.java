//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

final class NativeNumber extends IdScriptableObject
{
    private static final long serialVersionUID = 3504516769741512101L;
    public static final double MAX_SAFE_INTEGER = 9.007199254740991E15;
    public static final double EPSILON = 2.220446049250313E-16;
    private static final Object NUMBER_TAG;
    private static final int MAX_PRECISION = 100;
    private static final double MIN_SAFE_INTEGER = -9.007199254740991E15;
    private static final int ConstructorId_isFinite = -1;
    private static final int ConstructorId_isNaN = -2;
    private static final int ConstructorId_isInteger = -3;
    private static final int ConstructorId_isSafeInteger = -4;
    private static final int ConstructorId_fromString = -5;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_valueOf = 5;
    private static final int Id_toFixed = 6;
    private static final int Id_toExponential = 7;
    private static final int Id_toPrecision = 8;
    private static final int MAX_PROTOTYPE_ID = 8;
    private double doubleValue;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeNumber obj = new NativeNumber(0.0);
        obj.exportAsJSClass(8, scope, sealed);
    }
    
    NativeNumber(final double number) {
        this.doubleValue = number;
    }
    
    public String getClassName() {
        return "Number";
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        final int attr = 7;
        ctor.defineProperty("NaN", (Object)ScriptRuntime.NaNobj, 7);
        ctor.defineProperty("POSITIVE_INFINITY", (Object)ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        ctor.defineProperty("NEGATIVE_INFINITY", (Object)ScriptRuntime.wrapNumber(Double.NEGATIVE_INFINITY), 7);
        ctor.defineProperty("MAX_VALUE", (Object)ScriptRuntime.wrapNumber(Double.MAX_VALUE), 7);
        ctor.defineProperty("MIN_VALUE", (Object)ScriptRuntime.wrapNumber(Double.MIN_VALUE), 7);
        ctor.defineProperty("MAX_SAFE_INTEGER", (Object)ScriptRuntime.wrapNumber(9.007199254740991E15), 7);
        ctor.defineProperty("MIN_SAFE_INTEGER", (Object)ScriptRuntime.wrapNumber(-9.007199254740991E15), 7);
        ctor.defineProperty("EPSILON", (Object)ScriptRuntime.wrapNumber(2.220446049250313E-16), 7);
        this.addIdFunctionProperty((Scriptable)ctor, NativeNumber.NUMBER_TAG, -1, "isFinite", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeNumber.NUMBER_TAG, -2, "isNaN", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeNumber.NUMBER_TAG, -3, "isInteger", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeNumber.NUMBER_TAG, -4, "isSafeInteger", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeNumber.NUMBER_TAG, -5, "fromString", 1);
        final Scriptable global = ScriptableObject.getTopLevelScope((Scriptable)this);
        final Object parseFloat = ScriptableObject.getProperty(global, "parseFloat");
        final Object parseInt = ScriptableObject.getProperty(global, "parseInt");
        ctor.defineProperty("parseFloat", parseFloat, 2);
        ctor.defineProperty("parseInt", parseInt, 2);
        super.fillConstructorProperties(ctor);
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 1;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 1;
                s = "toString";
                break;
            }
            case 3: {
                arity = 1;
                s = "toLocaleString";
                break;
            }
            case 4: {
                arity = 0;
                s = "toSource";
                break;
            }
            case 5: {
                arity = 0;
                s = "valueOf";
                break;
            }
            case 6: {
                arity = 1;
                s = "toFixed";
                break;
            }
            case 7: {
                arity = 1;
                s = "toExponential";
                break;
            }
            case 8: {
                arity = 1;
                s = "toPrecision";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeNumber.NUMBER_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeNumber.NUMBER_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        if (id == 1) {
            final double val = (args.length >= 1) ? ScriptRuntime.toNumber(args[0]) : 0.0;
            if (thisObj == null) {
                return new NativeNumber(val);
            }
            return ScriptRuntime.wrapNumber(val);
        }
        else {
            if (id < 1) {
                return this.execConstructorCall(id, args);
            }
            final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
            if (!(unwrappedThis instanceof NativeNumber)) {
                throw incompatibleCallError(f);
            }
            final double value = ((NativeNumber)unwrappedThis).doubleValue;
            switch (id) {
                case 2:
                case 3: {
                    final int base = (args.length == 0 || args[0] == Undefined.instance) ? 10 : ScriptRuntime.toInt32(args[0]);
                    return ScriptRuntime.numberToString(value, base);
                }
                case 4: {
                    return "(new Number(" + ScriptRuntime.toString(value) + "))";
                }
                case 5: {
                    return ScriptRuntime.wrapNumber(value);
                }
                case 6: {
                    final int precisionMin = (cx.version < 200) ? -20 : 0;
                    return num_to(value, args, 2, 2, precisionMin, 0);
                }
                case 7: {
                    if (Double.isNaN(value)) {
                        return "NaN";
                    }
                    if (!Double.isInfinite(value)) {
                        return num_to(value, args, 1, 3, 0, 1);
                    }
                    if (value >= 0.0) {
                        return "Infinity";
                    }
                    return "-Infinity";
                }
                case 8: {
                    if (args.length == 0 || args[0] == Undefined.instance) {
                        return ScriptRuntime.numberToString(value, 10);
                    }
                    if (Double.isNaN(value)) {
                        return "NaN";
                    }
                    if (!Double.isInfinite(value)) {
                        return num_to(value, args, 0, 4, 1, 0);
                    }
                    if (value >= 0.0) {
                        return "Infinity";
                    }
                    return "-Infinity";
                }
                default: {
                    throw new IllegalArgumentException(String.valueOf(id));
                }
            }
        }
    }
    
    private Object execConstructorCall(final int id, final Object[] args) {
        switch (id) {
            case -1: {
                if (args.length == 0 || Undefined.instance == args[0]) {
                    return false;
                }
                if (args[0] instanceof Number) {
                    return isFinite(args[0]);
                }
                return false;
            }
            case -2: {
                if (args.length == 0 || Undefined.instance == args[0]) {
                    return false;
                }
                if (args[0] instanceof Number) {
                    return this.isNaN((Number)args[0]);
                }
                return false;
            }
            case -3: {
                if (args.length == 0 || Undefined.instance == args[0]) {
                    return false;
                }
                if (args[0] instanceof Number) {
                    return this.isInteger((Number)args[0]);
                }
                return false;
            }
            case -4: {
                if (args.length == 0 || Undefined.instance == args[0]) {
                    return false;
                }
                if (args[0] instanceof Number) {
                    return this.isSafeInteger((Number)args[0]);
                }
                return false;
            }
            case -5: {
                return this.fromString(args);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private Object fromString(final Object[] args) {
        if (args.length < 1 || !(args[0] instanceof CharSequence)) {
            throw ScriptRuntime.typeError("1st argument to fromString must be a string");
        }
        final String s = args[0].toString();
        final int radix = (1 < args.length) ? ScriptRuntime.toInt32(args[1]) : 10;
        final int len = s.length();
        if (len == 0) {
            throw ScriptRuntime.typeError("Illegal number of length 0");
        }
        boolean negative = false;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (ScriptRuntime.isStrWhiteSpaceChar(c)) {
                throw ScriptRuntime.typeError("String passed to fromString has invalid whitespace");
            }
            if (c >= 'A' && c <= 'Z') {
                throw ScriptRuntime.typeError("String passed to fromString has capital letters");
            }
        }
        char c = s.charAt(0);
        if (c == '+' || (negative = (c == '-'))) {
            ++start;
        }
        if (radix < 2 || radix > 36) {
            throw ScriptRuntime.rangeError("Illegal radix: " + radix);
        }
        if (radix == 16 && len - start > 1 && s.charAt(start) == '0') {
            c = s.charAt(start + 1);
            if (c == 'x' || c == 'X') {
                throw ScriptRuntime.typeError("Illegal prefix '0x' in fromString");
            }
        }
        if (len - start > 1 && s.charAt(start) == '0') {
            c = s.charAt(start + 1);
            if (c == 'x' || c == 'X') {
                throw ScriptRuntime.typeError("Illegal prefix '0x' in fromString");
            }
            if (c == 'o' || c == 'O') {
                throw ScriptRuntime.typeError("Illegal prefix '0o' in fromString");
            }
            if (c == 'b' || c == 'B') {
                throw ScriptRuntime.typeError("Illegal prefix '0b' in fromString");
            }
        }
        final double d = ScriptRuntime.stringPrefixToNumber(s, start, radix);
        if (Double.isNaN(d)) {
            throw ScriptRuntime.typeError("Illegal string passed to fromString");
        }
        return ScriptRuntime.wrapNumber(negative ? (-d) : d);
    }
    
    public String toString() {
        return ScriptRuntime.numberToString(this.doubleValue, 10);
    }
    
    private static String num_to(final double val, final Object[] args, final int zeroArgMode, int oneArgMode, final int precisionMin, final int precisionOffset) {
        int precision;
        if (args.length == 0) {
            precision = 0;
            oneArgMode = zeroArgMode;
        }
        else {
            final double p = ScriptRuntime.toInteger(args[0]);
            if (p < precisionMin || p > 100.0) {
                final String msg = ScriptRuntime.getMessage1("msg.bad.precision", ScriptRuntime.toString(args[0]));
                throw ScriptRuntime.constructError("RangeError", msg);
            }
            precision = ScriptRuntime.toInt32(p);
        }
        final StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, oneArgMode, precision + precisionOffset, val);
        return sb.toString();
    }
    
    static Object isFinite(final Object val) {
        final double d = ScriptRuntime.toNumber(val);
        final Double nd = d;
        return ScriptRuntime.wrapBoolean(!nd.isInfinite() && !nd.isNaN());
    }
    
    private Object isNaN(final Number val) {
        final Double nd = this.doubleVal(val);
        return ScriptRuntime.toBoolean(this.isDoubleNan(nd));
    }
    
    private boolean isDoubleNan(final Double d) {
        return d.isNaN();
    }
    
    private boolean isInteger(final Number val) {
        final Double nd = this.doubleVal(val);
        return ScriptRuntime.toBoolean(this.isDoubleInteger(nd));
    }
    
    private boolean isDoubleInteger(final Double d) {
        return !d.isInfinite() && !d.isNaN() && Math.floor(d) == d;
    }
    
    private boolean isSafeInteger(final Number val) {
        final Double nd = this.doubleVal(val);
        return ScriptRuntime.toBoolean(this.isDoubleSafeInteger(nd));
    }
    
    private boolean isDoubleSafeInteger(final Double d) {
        return this.isDoubleInteger(d) && d <= 9.007199254740991E15 && d >= -9.007199254740991E15;
    }
    
    private Double doubleVal(final Number val) {
        if (val instanceof Double) {
            return (Double)val;
        }
        final double d = val.doubleValue();
        return d;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 7: {
                final int c = s.charAt(0);
                if (c == 116) {
                    X = "toFixed";
                    id = 6;
                    break;
                }
                if (c == 118) {
                    X = "valueOf";
                    id = 5;
                    break;
                }
                break;
            }
            case 8: {
                final int c = s.charAt(3);
                if (c == 111) {
                    X = "toSource";
                    id = 4;
                    break;
                }
                if (c == 116) {
                    X = "toString";
                    id = 2;
                    break;
                }
                break;
            }
            case 11: {
                final int c = s.charAt(0);
                if (c == 99) {
                    X = "constructor";
                    id = 1;
                    break;
                }
                if (c == 116) {
                    X = "toPrecision";
                    id = 8;
                    break;
                }
                break;
            }
            case 13: {
                X = "toExponential";
                id = 7;
                break;
            }
            case 14: {
                X = "toLocaleString";
                id = 3;
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        NUMBER_TAG = "Number";
    }
}
