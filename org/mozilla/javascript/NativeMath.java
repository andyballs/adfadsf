//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

final class NativeMath extends IdScriptableObject
{
    private static final long serialVersionUID = -8838847185801131569L;
    private static final Object MATH_TAG;
    private static final double LOG2E = 1.4426950408889634;
    private static final double DEG_PER_RAD = 0.017453292519943295;
    private static final double RAD_PER_DEG = 57.29577951308232;
    private static final int Id_toSource = 1;
    private static final int Id_abs = 2;
    private static final int Id_acos = 3;
    private static final int Id_asin = 4;
    private static final int Id_atan = 5;
    private static final int Id_atan2 = 6;
    private static final int Id_ceil = 7;
    private static final int Id_cos = 8;
    private static final int Id_exp = 9;
    private static final int Id_floor = 10;
    private static final int Id_log = 11;
    private static final int Id_max = 12;
    private static final int Id_min = 13;
    private static final int Id_pow = 14;
    private static final int Id_random = 15;
    private static final int Id_round = 16;
    private static final int Id_sin = 17;
    private static final int Id_sqrt = 18;
    private static final int Id_tan = 19;
    private static final int Id_cbrt = 20;
    private static final int Id_cosh = 21;
    private static final int Id_expm1 = 22;
    private static final int Id_hypot = 23;
    private static final int Id_log1p = 24;
    private static final int Id_log10 = 25;
    private static final int Id_sinh = 26;
    private static final int Id_tanh = 27;
    private static final int Id_imul = 28;
    private static final int Id_trunc = 29;
    private static final int Id_acosh = 30;
    private static final int Id_asinh = 31;
    private static final int Id_atanh = 32;
    private static final int Id_sign = 33;
    private static final int Id_log2 = 34;
    private static final int Id_fround = 35;
    private static final int Id_clz32 = 36;
    private static final int Id_clamp = 37;
    private static final int Id_degrees = 38;
    private static final int Id_fscale = 39;
    private static final int Id_radians = 40;
    private static final int Id_scale = 41;
    private static final int Id_signbit = 42;
    private static final int LAST_METHOD_ID = 42;
    private static final int Id_E = 43;
    private static final int Id_PI = 44;
    private static final int Id_LN10 = 45;
    private static final int Id_LN2 = 46;
    private static final int Id_LOG2E = 47;
    private static final int Id_LOG10E = 48;
    private static final int Id_SQRT1_2 = 49;
    private static final int Id_SQRT2 = 50;
    private static final int Id_DEG_PER_RAD = 51;
    private static final int Id_RAD_PER_DEG = 52;
    private static final int SymbolId_toStringTag = 53;
    private static final int MAX_ID = 53;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeMath obj = new NativeMath();
        obj.activatePrototypeMap(53);
        obj.setPrototype(getObjectPrototype(scope));
        obj.setParentScope(scope);
        if (sealed) {
            obj.sealObject();
        }
        ScriptableObject.defineProperty(scope, "Math", obj, 2);
    }
    
    private NativeMath() {
    }
    
    public String getClassName() {
        return (String)NativeMath.MATH_TAG;
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 53) {
            this.initPrototypeValue(id, (Symbol)SymbolKey.TO_STRING_TAG, NativeMath.MATH_TAG, 0);
            return;
        }
        if (id <= 42) {
            int arity = 0;
            String name = null;
            switch (id) {
                case 1: {
                    arity = 0;
                    name = "toSource";
                    break;
                }
                case 2: {
                    arity = 1;
                    name = "abs";
                    break;
                }
                case 3: {
                    arity = 1;
                    name = "acos";
                    break;
                }
                case 30: {
                    arity = 1;
                    name = "acosh";
                    break;
                }
                case 4: {
                    arity = 1;
                    name = "asin";
                    break;
                }
                case 31: {
                    arity = 1;
                    name = "asinh";
                    break;
                }
                case 5: {
                    arity = 1;
                    name = "atan";
                    break;
                }
                case 32: {
                    arity = 1;
                    name = "atanh";
                    break;
                }
                case 6: {
                    arity = 2;
                    name = "atan2";
                    break;
                }
                case 20: {
                    arity = 1;
                    name = "cbrt";
                    break;
                }
                case 7: {
                    arity = 1;
                    name = "ceil";
                    break;
                }
                case 36: {
                    arity = 1;
                    name = "clz32";
                    break;
                }
                case 8: {
                    arity = 1;
                    name = "cos";
                    break;
                }
                case 21: {
                    arity = 1;
                    name = "cosh";
                    break;
                }
                case 9: {
                    arity = 1;
                    name = "exp";
                    break;
                }
                case 22: {
                    arity = 1;
                    name = "expm1";
                    break;
                }
                case 10: {
                    arity = 1;
                    name = "floor";
                    break;
                }
                case 35: {
                    arity = 1;
                    name = "fround";
                    break;
                }
                case 23: {
                    arity = 2;
                    name = "hypot";
                    break;
                }
                case 28: {
                    arity = 2;
                    name = "imul";
                    break;
                }
                case 11: {
                    arity = 1;
                    name = "log";
                    break;
                }
                case 24: {
                    arity = 1;
                    name = "log1p";
                    break;
                }
                case 25: {
                    arity = 1;
                    name = "log10";
                    break;
                }
                case 34: {
                    arity = 1;
                    name = "log2";
                    break;
                }
                case 12: {
                    arity = 2;
                    name = "max";
                    break;
                }
                case 13: {
                    arity = 2;
                    name = "min";
                    break;
                }
                case 14: {
                    arity = 2;
                    name = "pow";
                    break;
                }
                case 15: {
                    arity = 0;
                    name = "random";
                    break;
                }
                case 16: {
                    arity = 1;
                    name = "round";
                    break;
                }
                case 33: {
                    arity = 1;
                    name = "sign";
                    break;
                }
                case 17: {
                    arity = 1;
                    name = "sin";
                    break;
                }
                case 26: {
                    arity = 1;
                    name = "sinh";
                    break;
                }
                case 18: {
                    arity = 1;
                    name = "sqrt";
                    break;
                }
                case 19: {
                    arity = 1;
                    name = "tan";
                    break;
                }
                case 27: {
                    arity = 1;
                    name = "tanh";
                    break;
                }
                case 29: {
                    arity = 1;
                    name = "trunc";
                    break;
                }
                case 37: {
                    arity = 3;
                    name = "clamp";
                    break;
                }
                case 39: {
                    arity = 5;
                    name = "fscale";
                    break;
                }
                case 41: {
                    arity = 5;
                    name = "scale";
                    break;
                }
                case 38: {
                    arity = 1;
                    name = "degrees";
                    break;
                }
                case 40: {
                    arity = 1;
                    name = "radians";
                    break;
                }
                case 42: {
                    arity = 1;
                    name = "signbit";
                    break;
                }
                default: {
                    throw new IllegalStateException(String.valueOf(id));
                }
            }
            this.initPrototypeMethod(NativeMath.MATH_TAG, id, name, arity);
        }
        else {
            String name = null;
            double x = 0.0;
            switch (id) {
                case 43: {
                    x = 2.718281828459045;
                    name = "E";
                    break;
                }
                case 44: {
                    x = 3.141592653589793;
                    name = "PI";
                    break;
                }
                case 45: {
                    x = 2.302585092994046;
                    name = "LN10";
                    break;
                }
                case 46: {
                    x = 0.6931471805599453;
                    name = "LN2";
                    break;
                }
                case 47: {
                    x = 1.4426950408889634;
                    name = "LOG2E";
                    break;
                }
                case 48: {
                    x = 0.4342944819032518;
                    name = "LOG10E";
                    break;
                }
                case 49: {
                    x = 0.7071067811865476;
                    name = "SQRT1_2";
                    break;
                }
                case 50: {
                    x = 1.4142135623730951;
                    name = "SQRT2";
                    break;
                }
                case 52: {
                    x = 57.29577951308232;
                    name = "RAD_PER_DEG";
                    break;
                }
                case 51: {
                    x = 0.017453292519943295;
                    name = "DEG_PER_RAD";
                    break;
                }
                default: {
                    throw new IllegalStateException(String.valueOf(id));
                }
            }
            this.initPrototypeValue(id, name, (Object)ScriptRuntime.wrapNumber(x), 7);
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeMath.MATH_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int methodId = f.methodId();
        double x = 0.0;
        switch (methodId) {
            case 1: {
                return "Math";
            }
            case 2: {
                x = ScriptRuntime.toNumber(args, 0);
                x = ((x == 0.0) ? 0.0 : ((x < 0.0) ? (-x) : x));
                break;
            }
            case 3:
            case 4: {
                x = ScriptRuntime.toNumber(args, 0);
                if (!Double.isNaN(x) && -1.0 <= x && x <= 1.0) {
                    x = ((methodId == 3) ? Math.acos(x) : Math.asin(x));
                    break;
                }
                x = Double.NaN;
                break;
            }
            case 30: {
                x = ScriptRuntime.toNumber(args, 0);
                if (!Double.isNaN(x)) {
                    return Math.log(x + Math.sqrt(x * x - 1.0));
                }
                return Double.NaN;
            }
            case 31: {
                x = ScriptRuntime.toNumber(args, 0);
                if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) {
                    return x;
                }
                if (Double.isNaN(x)) {
                    return Double.NaN;
                }
                if (x != 0.0) {
                    return Math.log(x + Math.sqrt(x * x + 1.0));
                }
                if (1.0 / x > 0.0) {
                    return 0.0;
                }
                return -0.0;
            }
            case 5: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.atan(x);
                break;
            }
            case 32: {
                x = ScriptRuntime.toNumber(args, 0);
                if (Double.isNaN(x) || -1.0 > x || x > 1.0) {
                    return Double.NaN;
                }
                if (x != 0.0) {
                    return 0.5 * Math.log((x + 1.0) / (x - 1.0));
                }
                if (1.0 / x > 0.0) {
                    return 0.0;
                }
                return -0.0;
            }
            case 6: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.atan2(x, ScriptRuntime.toNumber(args, 1));
                break;
            }
            case 20: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.cbrt(x);
                break;
            }
            case 7: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.ceil(x);
                break;
            }
            case 36: {
                x = ScriptRuntime.toNumber(args, 0);
                if (x == 0.0 || Double.isNaN(x) || x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) {
                    return 32;
                }
                final long n = ScriptRuntime.toUint32(x);
                if (n == 0L) {
                    return 32;
                }
                return 31.0 - Math.floor(Math.log((double)(n >>> 0)) * 1.4426950408889634);
            }
            case 8: {
                x = ScriptRuntime.toNumber(args, 0);
                x = ((x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) ? Double.NaN : Math.cos(x));
                break;
            }
            case 21: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.cosh(x);
                break;
            }
            case 23: {
                x = js_hypot(args);
                break;
            }
            case 9: {
                x = ScriptRuntime.toNumber(args, 0);
                x = ((x == Double.POSITIVE_INFINITY) ? x : ((x == Double.NEGATIVE_INFINITY) ? 0.0 : Math.exp(x)));
                break;
            }
            case 22: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.expm1(x);
                break;
            }
            case 10: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.floor(x);
                break;
            }
            case 35: {
                x = ScriptRuntime.toNumber(args, 0);
                x = (float)x;
                break;
            }
            case 28: {
                return js_imul(args);
            }
            case 11: {
                x = ScriptRuntime.toNumber(args, 0);
                x = ((x < 0.0) ? Double.NaN : Math.log(x));
                break;
            }
            case 24: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.log1p(x);
                break;
            }
            case 25: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.log10(x);
                break;
            }
            case 34: {
                x = ScriptRuntime.toNumber(args, 0);
                x = ((x < 0.0) ? Double.NaN : (Math.log(x) * 1.4426950408889634));
                break;
            }
            case 12:
            case 13: {
                x = ((methodId == 12) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                for (int i = 0; i != args.length; ++i) {
                    final double d = ScriptRuntime.toNumber(args[i]);
                    if (Double.isNaN(d)) {
                        x = d;
                        break;
                    }
                    if (methodId == 12) {
                        x = Math.max(x, d);
                    }
                    else {
                        x = Math.min(x, d);
                    }
                }
                break;
            }
            case 14: {
                x = ScriptRuntime.toNumber(args, 0);
                x = js_pow(x, ScriptRuntime.toNumber(args, 1));
                break;
            }
            case 15: {
                x = Math.random();
                break;
            }
            case 16: {
                x = ScriptRuntime.toNumber(args, 0);
                if (!Double.isNaN(x) && x != Double.POSITIVE_INFINITY && x != Double.NEGATIVE_INFINITY) {
                    final long l = Math.round(x);
                    if (l != 0L) {
                        x = (double)l;
                    }
                    else if (x < 0.0) {
                        x = ScriptRuntime.negativeZero;
                    }
                    else if (x != 0.0) {
                        x = 0.0;
                    }
                    break;
                }
                break;
            }
            case 33: {
                x = ScriptRuntime.toNumber(args, 0);
                if (Double.isNaN(x)) {
                    return Double.NaN;
                }
                if (x != 0.0) {
                    return Math.signum(x);
                }
                if (1.0 / x > 0.0) {
                    return 0.0;
                }
                return -0.0;
            }
            case 17: {
                x = ScriptRuntime.toNumber(args, 0);
                x = ((x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) ? Double.NaN : Math.sin(x));
                break;
            }
            case 26: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.sinh(x);
                break;
            }
            case 18: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.sqrt(x);
                break;
            }
            case 19: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.tan(x);
                break;
            }
            case 27: {
                x = ScriptRuntime.toNumber(args, 0);
                x = Math.tanh(x);
                break;
            }
            case 29: {
                x = ScriptRuntime.toNumber(args, 0);
                x = js_trunc(x);
                break;
            }
            case 41: {
                x = js_scale(ScriptRuntime.toNumber(args, 0), ScriptRuntime.toNumber(args, 1), ScriptRuntime.toNumber(args, 2), ScriptRuntime.toNumber(args, 3), ScriptRuntime.toNumber(args, 4));
                break;
            }
            case 39: {
                x = js_fscale(ScriptRuntime.toNumber(args, 0), ScriptRuntime.toNumber(args, 1), ScriptRuntime.toNumber(args, 2), ScriptRuntime.toNumber(args, 3), ScriptRuntime.toNumber(args, 4));
                break;
            }
            case 38: {
                x = ScriptRuntime.toNumber(args, 0);
                x = js_degrees(x);
                break;
            }
            case 40: {
                x = ScriptRuntime.toNumber(args, 0);
                x = js_radians(x);
                break;
            }
            case 37: {
                x = js_clamp(ScriptRuntime.toNumber(args, 0), ScriptRuntime.toNumber(args, 1), ScriptRuntime.toNumber(args, 2));
                break;
            }
            case 42: {
                return js_signbit(ScriptRuntime.toNumber(args, 0));
            }
            default: {
                throw new IllegalStateException(String.valueOf(methodId));
            }
        }
        return ScriptRuntime.wrapNumber(x);
    }
    
    private static double js_pow(final double x, final double y) {
        double result;
        if (Double.isNaN(y)) {
            result = y;
        }
        else if (y == 0.0) {
            result = 1.0;
        }
        else if (x == 0.0) {
            if (1.0 / x > 0.0) {
                result = ((y > 0.0) ? 0.0 : Double.POSITIVE_INFINITY);
            }
            else {
                final long y_long = (long)y;
                if (y_long == y && (y_long & 0x1L) != 0x0L) {
                    result = ((y > 0.0) ? -0.0 : Double.NEGATIVE_INFINITY);
                }
                else {
                    result = ((y > 0.0) ? 0.0 : Double.POSITIVE_INFINITY);
                }
            }
        }
        else {
            result = Math.pow(x, y);
            if (Double.isNaN(result)) {
                if (y == Double.POSITIVE_INFINITY) {
                    if (x < -1.0 || 1.0 < x) {
                        result = Double.POSITIVE_INFINITY;
                    }
                    else if (-1.0 < x && x < 1.0) {
                        result = 0.0;
                    }
                }
                else if (y == Double.NEGATIVE_INFINITY) {
                    if (x < -1.0 || 1.0 < x) {
                        result = 0.0;
                    }
                    else if (-1.0 < x && x < 1.0) {
                        result = Double.POSITIVE_INFINITY;
                    }
                }
                else if (x == Double.POSITIVE_INFINITY) {
                    result = ((y > 0.0) ? Double.POSITIVE_INFINITY : 0.0);
                }
                else if (x == Double.NEGATIVE_INFINITY) {
                    final long y_long = (long)y;
                    if (y_long == y && (y_long & 0x1L) != 0x0L) {
                        result = ((y > 0.0) ? Double.NEGATIVE_INFINITY : -0.0);
                    }
                    else {
                        result = ((y > 0.0) ? Double.POSITIVE_INFINITY : 0.0);
                    }
                }
            }
        }
        return result;
    }
    
    private static double js_hypot(final Object[] args) {
        if (args == null) {
            return 0.0;
        }
        double y = 0.0;
        for (final Object o : args) {
            final double d = ScriptRuntime.toNumber(o);
            if (d == ScriptRuntime.NaN) {
                return d;
            }
            if (d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            y += d * d;
        }
        return Math.sqrt(y);
    }
    
    private static double js_trunc(final double d) {
        return (d < 0.0) ? Math.ceil(d) : Math.floor(d);
    }
    
    private static int js_imul(final Object[] args) {
        if (args == null) {
            return 0;
        }
        final int x = ScriptRuntime.toInt32(args, 0);
        final int y = ScriptRuntime.toInt32(args, 1);
        return x * y;
    }
    
    private static double js_fscale(final double x, final double inLow, final double inHigh, final double outLow, final double outHigh) {
        if (Double.isNaN(x) || Double.isNaN(inLow) || Double.isNaN(inHigh) || Double.isNaN(outLow) || Double.isNaN(outHigh)) {
            return Double.NaN;
        }
        if (Double.isInfinite(x)) {
            return x;
        }
        return (float)((x - inLow) * (outHigh - outLow) / (inHigh - inLow) + outLow);
    }
    
    private static double js_scale(final double x, final double inLow, final double inHigh, final double outLow, final double outHigh) {
        if (Double.isNaN(x) || Double.isNaN(inLow) || Double.isNaN(inHigh) || Double.isNaN(outLow) || Double.isNaN(outHigh)) {
            return Double.NaN;
        }
        if (Double.isInfinite(x)) {
            return x;
        }
        final int ix = (int)x;
        final int iinLow = (int)inLow;
        final int iinHigh = (int)inHigh;
        final int ioutLow = (int)outLow;
        final int ioutHigh = (int)outHigh;
        return (ix - iinLow) * (ioutHigh - ioutLow) / (iinHigh - iinLow) + ioutLow;
    }
    
    private static double js_degrees(final double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return x;
        }
        return x * 57.29577951308232;
    }
    
    private static double js_radians(final double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return x;
        }
        return x * 0.017453292519943295;
    }
    
    private static double js_clamp(final double x, final double lower, final double upper) {
        if (Double.isNaN(x) || Double.isNaN(lower) || Double.isNaN(upper)) {
            return Double.NaN;
        }
        return Math.min(Math.max(x, lower), upper);
    }
    
    private static boolean js_signbit(final double x) {
        return !Double.isNaN(x) && (x < 0.0 || ScriptRuntime.same(x, -0.0));
    }
    
    protected int findPrototypeId(final Symbol key) {
        if (SymbolKey.TO_STRING_TAG.equals(key)) {
            return 53;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        Label_1552: {
            switch (s.length()) {
                case 1: {
                    if (s.charAt(0) == 'E') {
                        id = 43;
                        return id;
                    }
                    break;
                }
                case 2: {
                    if (s.charAt(0) == 'P' && s.charAt(1) == 'I') {
                        id = 44;
                        return id;
                    }
                    break;
                }
                case 3: {
                    switch (s.charAt(0)) {
                        case 'L': {
                            if (s.charAt(2) == '2' && s.charAt(1) == 'N') {
                                id = 46;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 'a': {
                            if (s.charAt(2) == 's' && s.charAt(1) == 'b') {
                                id = 2;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 'c': {
                            if (s.charAt(2) == 's' && s.charAt(1) == 'o') {
                                id = 8;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 'e': {
                            if (s.charAt(2) == 'p' && s.charAt(1) == 'x') {
                                id = 9;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 'l': {
                            if (s.charAt(2) == 'g' && s.charAt(1) == 'o') {
                                id = 11;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 'm': {
                            final int c = s.charAt(2);
                            if (c == 110) {
                                if (s.charAt(1) == 'i') {
                                    id = 13;
                                    return id;
                                }
                                break Label_1552;
                            }
                            else {
                                if (c == 120 && s.charAt(1) == 'a') {
                                    id = 12;
                                    return id;
                                }
                                break Label_1552;
                            }
                            break;
                        }
                        case 'p': {
                            if (s.charAt(2) == 'w' && s.charAt(1) == 'o') {
                                id = 14;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 's': {
                            if (s.charAt(2) == 'n' && s.charAt(1) == 'i') {
                                id = 17;
                                return id;
                            }
                            break Label_1552;
                        }
                        case 't': {
                            if (s.charAt(2) == 'n' && s.charAt(1) == 'a') {
                                id = 19;
                                return id;
                            }
                            break Label_1552;
                        }
                        default: {
                            break Label_1552;
                        }
                    }
                    break;
                }
                case 4: {
                    switch (s.charAt(1)) {
                        case 'N': {
                            X = "LN10";
                            id = 45;
                            break Label_1552;
                        }
                        case 'a': {
                            X = "tanh";
                            id = 27;
                            break Label_1552;
                        }
                        case 'b': {
                            X = "cbrt";
                            id = 20;
                            break Label_1552;
                        }
                        case 'c': {
                            X = "acos";
                            id = 3;
                            break Label_1552;
                        }
                        case 'e': {
                            X = "ceil";
                            id = 7;
                            break Label_1552;
                        }
                        case 'i': {
                            final int c = s.charAt(3);
                            if (c == 104) {
                                if (s.charAt(0) == 's' && s.charAt(2) == 'n') {
                                    id = 26;
                                    return id;
                                }
                                break Label_1552;
                            }
                            else {
                                if (c == 110 && s.charAt(0) == 's' && s.charAt(2) == 'g') {
                                    id = 33;
                                    return id;
                                }
                                break Label_1552;
                            }
                            break;
                        }
                        case 'm': {
                            X = "imul";
                            id = 28;
                            break Label_1552;
                        }
                        case 'o': {
                            final int c = s.charAt(0);
                            if (c == 99) {
                                if (s.charAt(2) == 's' && s.charAt(3) == 'h') {
                                    id = 21;
                                    return id;
                                }
                                break Label_1552;
                            }
                            else {
                                if (c == 108 && s.charAt(2) == 'g' && s.charAt(3) == '2') {
                                    id = 34;
                                    return id;
                                }
                                break Label_1552;
                            }
                            break;
                        }
                        case 'q': {
                            X = "sqrt";
                            id = 18;
                            break Label_1552;
                        }
                        case 's': {
                            X = "asin";
                            id = 4;
                            break Label_1552;
                        }
                        case 't': {
                            X = "atan";
                            id = 5;
                            break Label_1552;
                        }
                        default: {
                            break Label_1552;
                        }
                    }
                    break;
                }
                case 5: {
                    switch (s.charAt(0)) {
                        case 'L': {
                            X = "LOG2E";
                            id = 47;
                            break Label_1552;
                        }
                        case 'S': {
                            X = "SQRT2";
                            id = 50;
                            break Label_1552;
                        }
                        case 'a': {
                            int c = s.charAt(1);
                            if (c == 99) {
                                X = "acosh";
                                id = 30;
                                break Label_1552;
                            }
                            if (c == 115) {
                                X = "asinh";
                                id = 31;
                                break Label_1552;
                            }
                            if (c != 116) {
                                break Label_1552;
                            }
                            c = s.charAt(4);
                            if (c == 50) {
                                if (s.charAt(2) == 'a' && s.charAt(3) == 'n') {
                                    id = 6;
                                    return id;
                                }
                                break Label_1552;
                            }
                            else {
                                if (c == 104 && s.charAt(2) == 'a' && s.charAt(3) == 'n') {
                                    id = 32;
                                    return id;
                                }
                                break Label_1552;
                            }
                            break;
                        }
                        case 'c': {
                            final int c = s.charAt(4);
                            if (c == 50) {
                                X = "clz32";
                                id = 36;
                                break Label_1552;
                            }
                            if (c == 112) {
                                X = "clamp";
                                id = 37;
                                break Label_1552;
                            }
                            break Label_1552;
                        }
                        case 'e': {
                            X = "expm1";
                            id = 22;
                            break Label_1552;
                        }
                        case 'f': {
                            X = "floor";
                            id = 10;
                            break Label_1552;
                        }
                        case 'h': {
                            X = "hypot";
                            id = 23;
                            break Label_1552;
                        }
                        case 'l': {
                            final int c = s.charAt(4);
                            if (c == 48) {
                                X = "log10";
                                id = 25;
                                break Label_1552;
                            }
                            if (c == 112) {
                                X = "log1p";
                                id = 24;
                                break Label_1552;
                            }
                            break Label_1552;
                        }
                        case 'r': {
                            X = "round";
                            id = 16;
                            break Label_1552;
                        }
                        case 's': {
                            X = "scale";
                            id = 41;
                            break Label_1552;
                        }
                        case 't': {
                            X = "trunc";
                            id = 29;
                            break Label_1552;
                        }
                        default: {
                            break Label_1552;
                        }
                    }
                    break;
                }
                case 6: {
                    switch (s.charAt(1)) {
                        case 'O': {
                            X = "LOG10E";
                            id = 48;
                            break Label_1552;
                        }
                        case 'a': {
                            X = "random";
                            id = 15;
                            break Label_1552;
                        }
                        case 'r': {
                            X = "fround";
                            id = 35;
                            break Label_1552;
                        }
                        case 's': {
                            X = "fscale";
                            id = 39;
                            break Label_1552;
                        }
                        default: {
                            break Label_1552;
                        }
                    }
                    break;
                }
                case 7: {
                    switch (s.charAt(0)) {
                        case 'S': {
                            X = "SQRT1_2";
                            id = 49;
                            break Label_1552;
                        }
                        case 'd': {
                            X = "degrees";
                            id = 38;
                            break Label_1552;
                        }
                        case 'r': {
                            X = "radians";
                            id = 40;
                            break Label_1552;
                        }
                        case 's': {
                            X = "signbit";
                            id = 42;
                            break Label_1552;
                        }
                        default: {
                            break Label_1552;
                        }
                    }
                    break;
                }
                case 8: {
                    X = "toSource";
                    id = 1;
                    break;
                }
                case 11: {
                    final int c = s.charAt(0);
                    if (c == 68) {
                        X = "DEG_PER_RAD";
                        id = 51;
                        break;
                    }
                    if (c == 82) {
                        X = "RAD_PER_DEG";
                        id = 52;
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
        MATH_TAG = "Math";
    }
}
