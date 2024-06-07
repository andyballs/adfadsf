//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.proxy.*;
import org.mozilla.javascript.decorators.*;
import org.mozilla.javascript.generator.*;
import org.mozilla.javascript.v8dtoa.*;
import org.mozilla.javascript.optimizer.*;
import java.util.function.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class ScriptRuntime
{
    public static final Class<?> BooleanClass;
    public static final Class<?> ByteClass;
    public static final Class<?> CharacterClass;
    public static final Class<?> ClassClass;
    public static final Class<?> DoubleClass;
    public static final Class<?> FloatClass;
    public static final Class<?> IntegerClass;
    public static final Class<?> LongClass;
    public static final Class<?> NumberClass;
    public static final Class<?> ObjectClass;
    public static final Class<?> ShortClass;
    public static final Class<?> StringClass;
    public static final Class<?> DateClass;
    public static final Class<?> ContextClass;
    public static final Class<?> ContextFactoryClass;
    public static final Class<?> FunctionClass;
    public static final Class<?> ScriptableObjectClass;
    public static final Class<Scriptable> ScriptableClass;
    public static Locale ROOT_LOCALE;
    private static final Object LIBRARY_SCOPE_KEY;
    public static final double NaN;
    public static final double negativeZero;
    public static final Double NaNobj;
    public static final Object SUPER_KEY;
    public static final int ENUMERATE_KEYS = 0;
    public static final int ENUMERATE_VALUES = 1;
    public static final int ENUMERATE_ARRAY = 2;
    public static final int ENUMERATE_KEYS_NO_ITERATOR = 3;
    public static final int ENUMERATE_VALUES_NO_ITERATOR = 4;
    public static final int ENUMERATE_ARRAY_NO_ITERATOR = 5;
    public static final int ENUMERATE_VALUES_IN_ORDER = 6;
    public static MessageProvider messageProvider;
    public static final Object[] emptyArgs;
    public static final String[] emptyStrings;
    
    protected ScriptRuntime() {
    }
    
    @Deprecated
    public static BaseFunction typeErrorThrower() {
        return typeErrorThrower(Context.getCurrentContext());
    }
    
    public static BaseFunction typeErrorThrower(final Context cx) {
        if (cx.typeErrorThrower == null) {
            final BaseFunction thrower = new BaseFunction() {
                private static final long serialVersionUID = -5891740962154902286L;
                
                public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
                    throw ScriptRuntime.typeError0("msg.op.not.allowed");
                }
                
                public int getLength() {
                    return 0;
                }
            };
            setFunctionProtoAndParent(thrower, cx.topCallScope);
            thrower.preventExtensions();
            cx.typeErrorThrower = thrower;
        }
        return cx.typeErrorThrower;
    }
    
    public static boolean isRhinoRuntimeType(final Class<?> cl) {
        if (cl.isPrimitive()) {
            return cl != Character.TYPE;
        }
        return cl == ScriptRuntime.StringClass || cl == ScriptRuntime.BooleanClass || ScriptRuntime.NumberClass.isAssignableFrom(cl) || ScriptRuntime.ScriptableClass.isAssignableFrom(cl);
    }
    
    public static ScriptableObject initSafeStandardObjects(final Context cx, ScriptableObject scope, final boolean sealed) {
        if (scope == null) {
            scope = (ScriptableObject)new NativeObject();
        }
        scope.associateValue(ScriptRuntime.LIBRARY_SCOPE_KEY, (Object)scope);
        new ClassCache().associate(scope);
        BaseFunction.init((Scriptable)scope, sealed);
        NativeObject.init((Scriptable)scope, sealed);
        final Scriptable objectProto = ScriptableObject.getObjectPrototype((Scriptable)scope);
        final Scriptable functionProto = ScriptableObject.getClassPrototype((Scriptable)scope, "Function");
        functionProto.setPrototype(objectProto);
        if (scope.getPrototype() == null) {
            scope.setPrototype(objectProto);
        }
        NativeError.init((Scriptable)scope, sealed);
        NativeGlobal.init(cx, (Scriptable)scope, sealed);
        NativeArray.init((Scriptable)scope, sealed);
        if (cx.getOptimizationLevel() > 0) {
            NativeArray.setMaximumInitialCapacity(200000);
        }
        NativeString.init((Scriptable)scope, sealed);
        NativeBoolean.init((Scriptable)scope, sealed);
        NativeNumber.init((Scriptable)scope, sealed);
        NativeDate.init((Scriptable)scope, sealed);
        NativeMath.init((Scriptable)scope, sealed);
        NativeJSON.init((Scriptable)scope, sealed);
        NativeReflect.init((Scriptable)scope, sealed);
        NativeProxy.init((Scriptable)scope, sealed);
        DecoratorType.init((Scriptable)scope);
        NativeWith.init((Scriptable)scope, sealed);
        NativeCall.init((Scriptable)scope, sealed);
        NativeScript.init((Scriptable)scope, sealed);
        NativeIterator.init(scope, sealed);
        NativeGenerator.init(scope, sealed);
        NativeArrayIterator.init(scope, sealed);
        NativeStringIterator.init(scope, sealed);
        NativeGeneratorIterator.init(scope, sealed);
        new LazilyLoadedCtor(scope, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp", sealed, true);
        new LazilyLoadedCtor(scope, "Continuation", "org.mozilla.javascript.NativeContinuation", sealed, true);
        if ((cx.getLanguageVersion() >= 180 && cx.hasFeature(13)) || cx.getLanguageVersion() >= 200) {
            new LazilyLoadedCtor(scope, "ArrayBuffer", "org.mozilla.javascript.typedarrays.NativeArrayBuffer", sealed, true);
            new LazilyLoadedCtor(scope, "Int8Array", "org.mozilla.javascript.typedarrays.NativeInt8Array", sealed, true);
            new LazilyLoadedCtor(scope, "Uint8Array", "org.mozilla.javascript.typedarrays.NativeUint8Array", sealed, true);
            new LazilyLoadedCtor(scope, "Uint8ClampedArray", "org.mozilla.javascript.typedarrays.NativeUint8ClampedArray", sealed, true);
            new LazilyLoadedCtor(scope, "Int16Array", "org.mozilla.javascript.typedarrays.NativeInt16Array", sealed, true);
            new LazilyLoadedCtor(scope, "Uint16Array", "org.mozilla.javascript.typedarrays.NativeUint16Array", sealed, true);
            new LazilyLoadedCtor(scope, "Int32Array", "org.mozilla.javascript.typedarrays.NativeInt32Array", sealed, true);
            new LazilyLoadedCtor(scope, "Uint32Array", "org.mozilla.javascript.typedarrays.NativeUint32Array", sealed, true);
            new LazilyLoadedCtor(scope, "Float32Array", "org.mozilla.javascript.typedarrays.NativeFloat32Array", sealed, true);
            new LazilyLoadedCtor(scope, "Float64Array", "org.mozilla.javascript.typedarrays.NativeFloat64Array", sealed, true);
            new LazilyLoadedCtor(scope, "DataView", "org.mozilla.javascript.typedarrays.NativeDataView", sealed, true);
        }
        if (cx.getLanguageVersion() >= 200) {
            NativeSymbol.init(cx, (Scriptable)scope, sealed);
            NativeCollectionIterator.init(scope, "Set Iterator", sealed);
            NativeCollectionIterator.init(scope, "Map Iterator", sealed);
            NativeMap.init(cx, (Scriptable)scope, sealed);
            NativeSet.init(cx, (Scriptable)scope, sealed);
            NativeWeakMap.init((Scriptable)scope, sealed);
            NativeWeakSet.init((Scriptable)scope, sealed);
        }
        if (scope instanceof TopLevel) {
            ((TopLevel)scope).cacheBuiltins();
        }
        return scope;
    }
    
    public static ScriptableObject initStandardObjects(final Context cx, final ScriptableObject scope, final boolean sealed) {
        final ScriptableObject s = initSafeStandardObjects(cx, scope, sealed);
        new LazilyLoadedCtor(s, "Packages", "org.mozilla.javascript.NativeJavaTopPackage", sealed, true);
        new LazilyLoadedCtor(s, "getClass", "org.mozilla.javascript.NativeJavaTopPackage", sealed, true);
        new LazilyLoadedCtor(s, "JavaAdapter", "org.mozilla.javascript.JavaAdapter", sealed, true);
        new LazilyLoadedCtor(s, "JavaImporter", "org.mozilla.javascript.ImporterTopLevel", sealed, true);
        for (final String packageName : getTopPackageNames()) {
            new LazilyLoadedCtor(s, packageName, "org.mozilla.javascript.NativeJavaTopPackage", sealed, true);
        }
        return s;
    }
    
    static String[] getTopPackageNames() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[] { "java", "javax", "org", "com", "edu", "net", "android" } : new String[] { "java", "javax", "org", "com", "edu", "net" };
    }
    
    public static ScriptableObject getLibraryScopeOrNull(final Scriptable scope) {
        final ScriptableObject libScope = (ScriptableObject)ScriptableObject.getTopScopeValue(scope, ScriptRuntime.LIBRARY_SCOPE_KEY);
        return libScope;
    }
    
    public static boolean isJSLineTerminator(final int c) {
        return (c & 0xDFD0) == 0x0 && (c == 10 || c == 13 || c == 8232 || c == 8233);
    }
    
    public static boolean isJSWhitespaceOrLineTerminator(final int c) {
        return isStrWhiteSpaceChar(c) || isJSLineTerminator(c);
    }
    
    static boolean isStrWhiteSpaceChar(final int c) {
        switch (c) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 32:
            case 160:
            case 8232:
            case 8233:
            case 65279: {
                return true;
            }
            default: {
                return Character.getType(c) == 12;
            }
        }
    }
    
    public static Boolean wrapBoolean(final boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static Integer wrapInt(final int i) {
        return i;
    }
    
    public static Number wrapNumber(final double x) {
        if (Double.isNaN(x)) {
            return ScriptRuntime.NaNobj;
        }
        return x;
    }
    
    public static boolean toBoolean(Object val) {
        while (!(val instanceof Boolean)) {
            if (val == null || val == Undefined.instance) {
                return false;
            }
            if (val instanceof CharSequence) {
                return ((CharSequence)val).length() != 0;
            }
            if (val instanceof Number) {
                final double d = ((Number)val).doubleValue();
                return !Double.isNaN(d) && d != 0.0;
            }
            if (!(val instanceof Scriptable)) {
                warnAboutNonJSObject(val);
                return true;
            }
            if (val instanceof ScriptableObject && ((ScriptableObject)val).avoidObjectDetection()) {
                return false;
            }
            if (Context.getContext().isVersionECMA1()) {
                return true;
            }
            val = ((Scriptable)val).getDefaultValue((Class)ScriptRuntime.BooleanClass);
            if (val instanceof Scriptable && !isSymbol(val)) {
                throw errorWithClassName("msg.primitive.expected", val);
            }
        }
        return (boolean)val;
    }
    
    public static double toNumber(Object val) {
        while (!(val instanceof Number)) {
            if (val == null) {
                return 0.0;
            }
            if (val == Undefined.instance) {
                return ScriptRuntime.NaN;
            }
            if (val instanceof String) {
                return toNumber((String)val);
            }
            if (val instanceof CharSequence) {
                return toNumber(val.toString());
            }
            if (val instanceof Boolean) {
                return val ? 1.0 : 0.0;
            }
            if (val instanceof Symbol) {
                throw typeError0("msg.not.a.number");
            }
            if (!(val instanceof Scriptable)) {
                warnAboutNonJSObject(val);
                return ScriptRuntime.NaN;
            }
            val = ((Scriptable)val).getDefaultValue((Class)ScriptRuntime.NumberClass);
            if (val instanceof Scriptable && !isSymbol(val)) {
                throw errorWithClassName("msg.primitive.expected", val);
            }
        }
        return ((Number)val).doubleValue();
    }
    
    public static double toNumber(final Object[] args, final int index) {
        return (index < args.length) ? toNumber(args[index]) : ScriptRuntime.NaN;
    }
    
    static double stringPrefixToNumber(final String s, final int start, final int radix) {
        return stringToNumber(s, start, s.length() - 1, radix, true);
    }
    
    static double stringToNumber(final String s, final int start, final int end, final int radix) {
        return stringToNumber(s, start, end, radix, false);
    }
    
    private static double stringToNumber(final String source, final int sourceStart, final int sourceEnd, final int radix, final boolean isPrefix) {
        char digitMax = '9';
        char lowerCaseBound = 'a';
        char upperCaseBound = 'A';
        if (radix < 10) {
            digitMax = (char)(48 + radix - 1);
        }
        if (radix > 10) {
            lowerCaseBound = (char)(97 + radix - 10);
            upperCaseBound = (char)(65 + radix - 10);
        }
        double sum = 0.0;
        int end;
        for (end = sourceStart; end <= sourceEnd; ++end) {
            final char c = source.charAt(end);
            int newDigit;
            if ('0' <= c && c <= digitMax) {
                newDigit = c - '0';
            }
            else if ('a' <= c && c < lowerCaseBound) {
                newDigit = c - 'a' + 10;
            }
            else if ('A' <= c && c < upperCaseBound) {
                newDigit = c - 'A' + 10;
            }
            else {
                if (!isPrefix) {
                    return ScriptRuntime.NaN;
                }
                break;
            }
            sum = sum * radix + newDigit;
        }
        if (sourceStart == end) {
            return ScriptRuntime.NaN;
        }
        if (sum > 9.007199254740991E15) {
            if (radix == 10) {
                try {
                    return Double.parseDouble(source.substring(sourceStart, end));
                }
                catch (NumberFormatException nfe) {
                    return ScriptRuntime.NaN;
                }
            }
            if (radix == 2 || radix == 4 || radix == 8 || radix == 16 || radix == 32) {
                int bitShiftInChar = 1;
                int digit = 0;
                final int SKIP_LEADING_ZEROS = 0;
                final int FIRST_EXACT_53_BITS = 1;
                final int AFTER_BIT_53 = 2;
                final int ZEROS_AFTER_54 = 3;
                final int MIXED_AFTER_54 = 4;
                int state = 0;
                int exactBitsLimit = 53;
                double factor = 0.0;
                boolean bit53 = false;
                boolean bit54 = false;
                int pos = sourceStart;
                while (true) {
                    if (bitShiftInChar == 1) {
                        if (pos == end) {
                            break;
                        }
                        digit = source.charAt(pos++);
                        if (48 <= digit && digit <= 57) {
                            digit -= 48;
                        }
                        else if (97 <= digit && digit <= 122) {
                            digit -= 87;
                        }
                        else {
                            digit -= 55;
                        }
                        bitShiftInChar = radix;
                    }
                    bitShiftInChar >>= 1;
                    final boolean bit55 = (digit & bitShiftInChar) != 0x0;
                    switch (state) {
                        case 0: {
                            if (bit55) {
                                --exactBitsLimit;
                                sum = 1.0;
                                state = 1;
                                continue;
                            }
                            continue;
                        }
                        case 1: {
                            sum *= 2.0;
                            if (bit55) {
                                ++sum;
                            }
                            if (--exactBitsLimit == 0) {
                                bit53 = bit55;
                                state = 2;
                                continue;
                            }
                            continue;
                        }
                        case 2: {
                            bit54 = bit55;
                            factor = 2.0;
                            state = 3;
                            continue;
                        }
                        case 3: {
                            if (bit55) {
                                state = 4;
                            }
                        }
                        case 4: {
                            factor *= 2.0;
                            continue;
                        }
                    }
                }
                switch (state) {
                    case 0: {
                        sum = 0.0;
                    }
                    case 3: {
                        if (bit54 & bit53) {
                            ++sum;
                        }
                        sum *= factor;
                        break;
                    }
                    case 4: {
                        if (bit54) {
                            ++sum;
                        }
                        sum *= factor;
                        break;
                    }
                }
            }
        }
        return sum;
    }
    
    public static double toNumber(final String s) {
        final int len = s.length();
        int start = 0;
        while (start != len) {
            final char startChar = s.charAt(start);
            if (!isStrWhiteSpaceChar(startChar)) {
                int end;
                char endChar;
                for (end = len - 1; isStrWhiteSpaceChar(endChar = s.charAt(end)); --end) {}
                final Context cx = Context.getCurrentContext();
                final boolean oldParsingMode = cx == null || cx.getLanguageVersion() < 200;
                if (startChar == '0') {
                    if (start + 2 <= end) {
                        final char radixC = s.charAt(start + 1);
                        int radix = -1;
                        if (radixC == 'x' || radixC == 'X') {
                            radix = 16;
                        }
                        else if (!oldParsingMode && (radixC == 'o' || radixC == 'O')) {
                            radix = 8;
                        }
                        else if (!oldParsingMode && (radixC == 'b' || radixC == 'B')) {
                            radix = 2;
                        }
                        if (radix != -1) {
                            if (oldParsingMode) {
                                return stringPrefixToNumber(s, start + 2, radix);
                            }
                            return stringToNumber(s, start + 2, end, radix);
                        }
                    }
                }
                else if (oldParsingMode && (startChar == '+' || startChar == '-') && start + 3 <= end && s.charAt(start + 1) == '0') {
                    final char radixC = s.charAt(start + 2);
                    if (radixC == 'x' || radixC == 'X') {
                        final double val = stringPrefixToNumber(s, start + 3, 16);
                        return (startChar == '-') ? (-val) : val;
                    }
                }
                if (endChar == 'y') {
                    if (startChar == '+' || startChar == '-') {
                        ++start;
                    }
                    if (start + 7 == end && s.regionMatches(start, "Infinity", 0, 8)) {
                        return (startChar == '-') ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                    }
                    return ScriptRuntime.NaN;
                }
                else {
                    final String sub = s.substring(start, end + 1);
                    for (int i = sub.length() - 1; i >= 0; --i) {
                        final char c = sub.charAt(i);
                        if (('0' > c || c > '9') && c != '.' && c != 'e' && c != 'E' && c != '+' && c != '-') {
                            return ScriptRuntime.NaN;
                        }
                    }
                    try {
                        return Double.parseDouble(sub);
                    }
                    catch (NumberFormatException ex) {
                        return ScriptRuntime.NaN;
                    }
                }
            }
            else {
                ++start;
            }
        }
        return 0.0;
    }
    
    public static Object handleObjectRest(final Object destructured, final Object[] alreadyTaken) {
        final ScriptableObject obj = ScriptableObject.ensureScriptableObject(destructured);
        final Object[] ids = obj.getIds();
        final List<Object> taken = Arrays.asList(alreadyTaken);
        final NativeObject newObj = new NativeObject();
        for (final Object id : ids) {
            if (!taken.contains(id)) {
                if (id instanceof String) {
                    ScriptableObject.putProperty((Scriptable)newObj, (String)id, ScriptableObject.getProperty((Object)obj, id));
                }
                else if (id instanceof Integer) {
                    ScriptableObject.putProperty((Scriptable)newObj, (int)id, ScriptableObject.getProperty((Object)obj, id));
                }
            }
        }
        return newObj;
    }
    
    public static Object handleRestDestructure(final Context cx, final Scriptable scope, final int startIndex, final Object right) {
        if (right instanceof NativeArray) {
            final Object[] target = new Object[((NativeArray)right).size() - startIndex];
            System.arraycopy(((NativeArray)right).toArray(), startIndex, target, 0, target.length);
            return cx.newArray(scope, target);
        }
        final ES6Iterator it = toIterator(cx, scope, ScriptableObject.ensureScriptable(right), false);
        if (it == null) {
            return cx.newArray(scope, 0);
        }
        final List<Object> objects = new ArrayList<Object>();
        while (!it.isDone(cx, scope)) {
            objects.add(it.nextValue(cx, scope));
        }
        return cx.newArray(scope, objects.toArray());
    }
    
    public static Object[] lengthenObjArray(final Object[] arr, final int minLength) {
        if (arr.length >= minLength) {
            return arr;
        }
        final Object[] newArr = new Object[minLength];
        for (int i = 0; i < newArr.length; ++i) {
            newArr[i] = ((i < arr.length) ? arr[i] : Undefined.instance);
        }
        return newArr;
    }
    
    public static Object mixDefaultArgument(final Object arg, final Object defaultArg) {
        if (arg == Undefined.instance) {
            return defaultArg;
        }
        return arg;
    }
    
    public static void handleImport(final Object requireObj, final Object[] namedImports, final String defaultImport, final String moduleImport, final Scriptable scope) {
        if (requireObj instanceof Scriptable) {
            final Scriptable require = (Scriptable)requireObj;
            if (defaultImport != null) {
                if (!ScriptableObject.hasProperty(require, "default")) {
                    throw typeError0("msg.file.has.no.default.export");
                }
                ScriptableObject.putProperty(scope, defaultImport, ScriptableObject.getProperty(require, "default"));
            }
            if (moduleImport != null) {
                ScriptableObject.putProperty(scope, moduleImport, (Object)require);
            }
            for (final Object _namedImport : namedImports) {
                final String[] namedImport = (String[])_namedImport;
                if (!ScriptableObject.hasProperty(require, namedImport[0])) {
                    throw typeError1("msg.file.has.no.named.export", namedImport[0]);
                }
                ScriptableObject.putProperty(scope, namedImport[1], ScriptableObject.getProperty(require, namedImport[0]));
            }
            return;
        }
        if (defaultImport == null) {
            throw typeError0("msg.import.from.non.module");
        }
        if (namedImports != null) {
            throw typeError0("msg.file.has.no.named.exports");
        }
        ScriptableObject.putProperty(scope, defaultImport, requireObj);
    }
    
    public static void handleExport(final Scriptable fromRequire, final Scriptable scope) {
        final Object[] propertyIds;
        final Object[] ids = propertyIds = ScriptableObject.getPropertyIds(fromRequire);
        for (final Object id : propertyIds) {
            if (id instanceof String) {
                handleExport((String)id, (String)id, fromRequire, scope);
            }
        }
    }
    
    public static void handleExport(final String targetName, final String scopeName, final Scriptable fromRequire, final Scriptable scope) {
        final Object exports = getExports(scope);
        if (ScriptableObject.hasProperty(exports, (Object)scopeName)) {
            throw typeError1("msg.export.duplicate.identifier", scopeName);
        }
        ScriptableObject.putProperty(exports, (Object)scopeName, ScriptableObject.getProperty(fromRequire, targetName));
    }
    
    public static void handleExport(final String targetName, final String scopeName, final Scriptable scope) {
        if (!ScriptableObject.hasProperty(scope, targetName)) {
            throw typeError1("msg.export.no.target", targetName);
        }
        final Object value = ScriptableObject.getProperty(scope, targetName);
        final Object exports = getExports(scope);
        if ("default".equals(scopeName)) {
            if (ScriptableObject.hasProperty(exports, (Object)"default")) {
                throw typeError0("msg.export.inline.multiple.defaults");
            }
            ScriptableObject.putProperty(exports, (Object)"default", value);
        }
        else {
            if (ScriptableObject.hasProperty(exports, (Object)scopeName)) {
                throw typeError1("msg.export.duplicate.identifier", scopeName);
            }
            ScriptableObject.putProperty(exports, (Object)scopeName, value);
        }
    }
    
    public static void handleExport(final Object value, final Scriptable scope) {
        final Object exports = getExports(scope);
        if (ScriptableObject.hasProperty(exports, (Object)"default")) {
            throw typeError0("msg.export.inline.multiple.defaults");
        }
        ScriptableObject.putConstProperty(exports, "default", value);
    }
    
    private static Object getExports(final Scriptable scope) {
        return ScriptableObject.getProperty(ScriptableObject.getProperty(scope, "module"), (Object)"exports");
    }
    
    public static Object getRestParams(final Object[] _args, final int index, final Context cx, final Scriptable scope) {
        final Object[] args = new Object[_args.length - index];
        for (int i = index; i < _args.length; ++i) {
            args[i - index] = _args[i];
        }
        return cx.newArray(scope, args);
    }
    
    public static Object[] paramsToRestParams(final Object[] in, final int spreadIndex, final Context cx, final Scriptable scope) {
        if (spreadIndex >= in.length) {
            return in;
        }
        final Object[] params = new Object[spreadIndex + 1];
        System.arraycopy(in, 0, params, 0, spreadIndex);
        params[spreadIndex] = getRestParams(in, spreadIndex, cx, scope);
        return params;
    }
    
    public static Object getNewTarget(final Object constructor, final Object thisObj) {
        final Scriptable obj = ScriptableObject.ensureScriptable(thisObj);
        if (obj.has("new.target", obj)) {
            return obj.get("new.target", obj);
        }
        return Undefined.instance;
    }
    
    public static void debug(final Object obj) {
        System.out.println("test");
    }
    
    public static Object addClassMethod(final Object clazzObj, final Object name, final Object method, final Context cx, final boolean instance, final int getterSetter, final boolean isPrivate) {
        ScriptableObject clazz = ScriptableObject.ensureScriptableObject(clazzObj);
        if (instance) {
            clazz = ScriptableObject.ensureScriptableObject(ScriptableObject.getProperty((Scriptable)clazz, "prototype"));
            if (method instanceof ScriptableObject) {
                final Object extended = ScriptableObject.ensureScriptableObject(clazzObj).getAssociatedValue(ScriptRuntime.SUPER_KEY);
                if (extended != null) {
                    ((ScriptableObject)method).associateValue(ScriptRuntime.SUPER_KEY, extended);
                }
            }
        }
        if (name instanceof String) {
            final String nameString = (String)name;
            if (getterSetter == 0) {
                setFunctionNameIfApplicable(method, nameString);
                if (nameString.equals("name") && clazz instanceof BaseFunction) {
                    ((BaseFunction)clazz).setForcedName(method);
                }
                clazz.put(nameString, (Scriptable)clazz, method, isPrivate);
                clazz.setAttributes(nameString, clazz.getAttributes(nameString) | 0x2, isPrivate);
            }
            else {
                final Callable getterOrSetter = (Callable)method;
                final boolean isSetter = getterSetter == 1;
                setFunctionNameIfApplicable(method, (isSetter ? "set " : "get ") + nameString);
                clazz.setGetterOrSetter(nameString, 0, getterOrSetter, isSetter, false, isPrivate);
                clazz.setAttributes(nameString, clazz.getAttributes(nameString) | 0x2, isPrivate);
            }
        }
        else if (name instanceof Integer) {
            if (isPrivate) {
                throw Kit.codeBug("Unexpected private integer method");
            }
            final int nameInt = (int)name;
            if (getterSetter == 0) {
                setFunctionNameIfApplicable(method, String.valueOf(nameInt));
                clazz.put(nameInt, (Scriptable)clazz, method);
            }
            else {
                final Callable getterOrSetter = (Callable)method;
                final boolean isSetter = getterSetter == 1;
                setFunctionNameIfApplicable(method, (isSetter ? "set " : "get ") + nameInt);
                clazz.setGetterOrSetter(nameInt, 0, getterOrSetter, isSetter);
            }
            clazz.setAttributes(nameInt, clazz.getAttributes(nameInt) | 0x2);
        }
        else {
            if (!isSymbol(name)) {
                throw throwError(cx, (Scriptable)clazz, "msg.object.invalid.key.type");
            }
            if (isPrivate) {
                throw Kit.codeBug("Unexpected private symbol method");
            }
            final Symbol nameSymbol = (Symbol)name;
            if (getterSetter == 0) {
                setFunctionNameIfApplicable(method, nameSymbol.toSymbolString());
                clazz.put(nameSymbol, (Scriptable)clazz, method);
                clazz.setAttributes(nameSymbol, clazz.getAttributes(nameSymbol) | 0x2);
            }
            else {
                final Callable getterOrSetter = (Callable)method;
                final boolean isSetter = getterSetter == 1;
                setFunctionNameIfApplicable(method, (isSetter ? "set " : "get ") + nameSymbol.toSymbolString());
                clazz.setGetterOrSetter(nameSymbol, 0, getterOrSetter, isSetter);
                clazz.setAttributes(nameSymbol, clazz.getAttributes(nameSymbol) | 0x2);
            }
        }
        return clazzObj;
    }
    
    public static Object addClassProperty(final Object clazzObj, final Object name, final Object defaultValue, final Context cx, final boolean isPrivate) {
        final ScriptableObject clazz = ScriptableObject.ensureScriptableObject(clazzObj);
        if (name instanceof String) {
            final String s = toStringIdOrIndex(cx, name);
            if (s == null) {
                if (isPrivate) {
                    throw Kit.codeBug("Unexpected private integer class property");
                }
                clazz.put(lastIndexResult(cx), (Scriptable)clazz, defaultValue);
            }
            else {
                clazz.put(s, (Scriptable)clazz, defaultValue, isPrivate);
            }
        }
        else if (isSymbol(name)) {
            if (isPrivate) {
                throw Kit.codeBug("Unexpected private symbol class property");
            }
            clazz.put((Symbol)name, (Scriptable)clazz, defaultValue);
        }
        else {
            if (!(name instanceof Integer)) {
                throw throwError(cx, (Scriptable)clazz, "msg.object.invalid.key.type");
            }
            if (isPrivate) {
                throw Kit.codeBug("Unexpected private integer class property");
            }
            clazz.put((int)name, (Scriptable)clazz, defaultValue);
        }
        return clazzObj;
    }
    
    public static Object callSuper(Object[] args, final boolean isReturned, final NativeFunction clazz, final Scriptable thisObj, final Scriptable scope, final Context cx) {
        if (args == null) {
            args = new Object[0];
        }
        if (isReturned) {
            final Scriptable extended = clazz.getPrototype();
            if (!(extended instanceof BaseFunction)) {
                throw Kit.codeBug();
            }
            return ((BaseFunction)extended).construct(cx, scope, args);
        }
        else {
            final Scriptable proto = clazz.getPrototype();
            if (!(proto instanceof Function)) {
                throw Kit.codeBug();
            }
            final Object newTarget = thisObj.get("new.target", thisObj);
            final BoundFunction ctor = new BoundFunction(cx, scope, (Callable)proto, (Scriptable)null, args);
            ctor.setForcedNewTarget(newTarget);
            final Scriptable instance = ctor.construct(cx, scope, new Object[0]);
            instance.setPrototype(ScriptableObject.ensureScriptable(ScriptableObject.getProperty((Scriptable)clazz, "prototype")));
            instance.put("new.target", instance, newTarget);
            return instance;
        }
    }
    
    public static Object setSuperElem(final Object prop, final Object value, final Scriptable thisObj, final NativeFunction method) {
        final Object superObj = method.getAssociatedValue(ScriptRuntime.SUPER_KEY);
        if (superObj == null) {
            throw typeError0("msg.class.no.super");
        }
        if (prop instanceof String) {
            ScriptableObject.putProperty(superObj, (Object)prop, value);
        }
        else if (prop instanceof Integer) {
            ScriptableObject.putProperty(superObj, (Object)prop, value);
        }
        else if (isSymbol(prop)) {
            ScriptableObject.putProperty(superObj, (Object)prop, value);
        }
        return value;
    }
    
    public static Object setSuperProp(final String prop, final Object value, final Scriptable thisObj, final NativeFunction method) {
        final Object superObj = method.getAssociatedValue(ScriptRuntime.SUPER_KEY);
        if (superObj == null) {
            throw typeError0("msg.class.no.super");
        }
        ScriptableObject.putProperty(superObj, (Object)prop, value);
        return value;
    }
    
    public static Object accessSuper(final Object prop, final Scriptable thisObj, final NativeFunction method) {
        final Object superObj = method.getAssociatedValue(ScriptRuntime.SUPER_KEY);
        if (superObj == null) {
            throw typeError0("msg.class.no.super");
        }
        Object result = ScriptableObject.getProperty(superObj, prop);
        if (result == Scriptable.NOT_FOUND) {
            result = Undefined.instance;
        }
        return result;
    }
    
    public static Object callSuperProp(final Object prop, final Object[] args, final Scriptable scope, final Scriptable thisObj, final NativeFunction nativeFunction, final Context cx) {
        final Object method = accessSuper(prop, thisObj, nativeFunction);
        if (!(method instanceof Callable)) {
            throw Kit.codeBug();
        }
        return ((Callable)method).call(cx, scope, thisObj, args);
    }
    
    public static Scriptable coerceClassCtorReturnValue(final Object returnValue, final Scriptable thisObj) {
        if (returnValue instanceof NativeString || returnValue instanceof NativeNumber || returnValue instanceof NativeSymbol || returnValue instanceof NativeBoolean || Undefined.isUndefined(returnValue) || !(returnValue instanceof Scriptable)) {
            return thisObj;
        }
        return (Scriptable)returnValue;
    }
    
    public static Scriptable endClassCtor(final Scriptable obj) {
        obj.delete("new.target");
        return obj;
    }
    
    public static Object setClassExtends(final Object clazzObj, final Object extendedObj, final Context cx, final Scriptable scope) {
        final ScriptableObject clazz = ScriptableObject.ensureScriptableObject(clazzObj);
        if (extendedObj == null) {
            final ScriptableObject newObject = (ScriptableObject)new NativeObject();
            newObject.defineProperty("constructor", (Object)clazz, 2);
            ScriptableObject.putProperty((Scriptable)clazz, "prototype", (Object)newObject);
            return clazz;
        }
        final ScriptableObject extended = ScriptableObject.ensureScriptableObject(extendedObj);
        final Scriptable extendedProto = (Scriptable)ScriptableObject.ensureScriptableObject(ScriptableObject.getProperty((Scriptable)extended, "prototype"));
        final ScriptableObject newObject2 = (ScriptableObject)new NativeObject();
        newObject2.setParentScope(scope);
        newObject2.setPrototype(extendedProto);
        newObject2.defineProperty("constructor", (Object)clazz, 2);
        ScriptableObject.putProperty((Scriptable)clazz, "prototype", (Object)newObject2);
        clazz.associateValue(ScriptRuntime.SUPER_KEY, (Object)extendedProto);
        clazz.setPrototype((Scriptable)extended);
        final NativeObject desc = new NativeObject();
        ScriptableObject.defineProperty((Scriptable)desc, "configurable", (Object)true, 0);
        ScriptableObject.defineProperty((Scriptable)desc, "enumerable", (Object)false, 0);
        ScriptableObject.defineProperty((Scriptable)desc, "get", (Object)BaseFunction.wrap(() -> clazz), 0);
        clazz.defineOwnProperty(Context.getContext(), (Object)SymbolKey.SPECIES, (ScriptableObject)desc, true);
        return clazz;
    }
    
    public static void addSpreadObject(final Scriptable obj, final Scriptable spread) {
        final Object[] ids2;
        final Object[] ids = ids2 = spread.getIds();
        for (final Object key : ids2) {
            if (key instanceof String) {
                final Object val = spread.get((String)key, obj);
                if (val != Scriptable.NOT_FOUND && val != Undefined.instance) {
                    obj.put((String)key, obj, val);
                }
            }
            else if (key instanceof Number) {
                final int i = toInt32(key);
                final Object val2 = spread.get(i, obj);
                if (val2 != Scriptable.NOT_FOUND && val2 != Undefined.instance) {
                    obj.put(i, obj, val2);
                }
            }
        }
    }
    
    public static Object[] combineSpreadArgs(final Object[] args, final Context cx, final Scriptable scope) {
        int totalArgs = 0;
        for (int i = 0; i < args.length; ++i) {
            final Object arg = args[i];
            if (arg instanceof Object[]) {
                totalArgs += ((Object[])arg).length;
            }
            else {
                if (!(arg instanceof Scriptable)) {
                    throw typeError1("msg.not.iterable", toString(arg));
                }
                final ES6Iterator it = toIterator(cx, scope, (Scriptable)arg, false);
                if (it == null) {
                    throw typeError0("msg.invalid.iterator");
                }
                final LinkedList<Object> ll = new LinkedList<Object>();
                while (!it.isDone(cx, scope)) {
                    ll.add(it.nextValue(cx, scope));
                }
                args[i] = ll.toArray();
                totalArgs += ll.size();
            }
        }
        final Object[] targetArgs = new Object[totalArgs];
        int abs = 0;
        for (final Object o : args) {
            final Object[] arg2 = (Object[])o;
            System.arraycopy(arg2, 0, targetArgs, abs, arg2.length);
            abs += arg2.length;
        }
        return targetArgs;
    }
    
    public static Object templateConcat(final Object[] elements) {
        if (elements.length == 0) {
            return Undefined.instance;
        }
        if (elements.length == 1) {
            return toString(elements[0]);
        }
        ConsString str = new ConsString((CharSequence)toString(elements[0]), (CharSequence)toString(elements[1]));
        for (int i = 2; i < elements.length; ++i) {
            str = new ConsString((CharSequence)str, (CharSequence)toString(elements[i]));
        }
        return str;
    }
    
    public static Object callWithTemplateLiteral(final Object[] args, final int boundary, final Object[] rawStrings, final Object target, final Context cx, final Scriptable scope, final Scriptable thisObj) {
        if (!(target instanceof Callable)) {
            throw typeError1("msg.isnt.function", toString(target));
        }
        final Callable fn = (Callable)target;
        final NativeArray parts = cx.newArray(scope, Arrays.copyOfRange(args, 0, boundary));
        parts.setTemplateObj();
        final ScriptableObject raw = ScriptableObject.ensureScriptableObject((Object)cx.newArray(scope, rawStrings));
        freeze(raw, cx);
        ScriptableObject.putProperty((Scriptable)parts, "raw", (Object)raw);
        freeze((ScriptableObject)parts, cx);
        final Object[] fnArgs = new Object[args.length - boundary + 1];
        fnArgs[0] = parts;
        System.arraycopy(args, boundary, fnArgs, 1, fnArgs.length - 1);
        return fn.call(cx, scope, thisObj, fnArgs);
    }
    
    private static void freeze(final ScriptableObject obj, final Context cx) {
        for (final Object name : obj.getAllIds()) {
            final ScriptableObject desc = obj.getOwnPropertyDescriptor(cx, name);
            if (desc.isDataDescriptor(desc) && Boolean.TRUE.equals(desc.get((Object)"writable"))) {
                desc.put("writable", (Scriptable)desc, (Object)Boolean.FALSE);
            }
            if (Boolean.TRUE.equals(desc.get((Object)"configurable"))) {
                desc.put("configurable", (Scriptable)desc, (Object)Boolean.FALSE);
            }
            obj.defineOwnProperty(cx, name, desc, false);
        }
        obj.preventExtensions();
    }
    
    public static Object[] padArguments(final Object[] args, final int count) {
        if (count < args.length) {
            return args;
        }
        final Object[] result = new Object[count];
        int i;
        for (i = 0; i < args.length; ++i) {
            result[i] = args[i];
        }
        while (i < count) {
            result[i] = Undefined.instance;
            ++i;
        }
        return result;
    }
    
    public static String escapeString(final String s) {
        return escapeString(s, '\"');
    }
    
    public static String escapeString(final String s, final char escapeQuote) {
        if (escapeQuote != '\"' && escapeQuote != '\'' && escapeQuote != '`') {
            Kit.codeBug();
        }
        StringBuilder sb = null;
        for (int i = 0, L = s.length(); i != L; ++i) {
            final int c = s.charAt(i);
            if (32 <= c && c <= 126 && c != escapeQuote && c != 92) {
                if (sb != null) {
                    sb.append((char)c);
                }
            }
            else {
                if (sb == null) {
                    sb = new StringBuilder(L + 3);
                    sb.append(s);
                    sb.setLength(i);
                }
                int escape = -1;
                switch (c) {
                    case 8: {
                        escape = 98;
                        break;
                    }
                    case 12: {
                        escape = 102;
                        break;
                    }
                    case 10: {
                        escape = 110;
                        break;
                    }
                    case 13: {
                        escape = 114;
                        break;
                    }
                    case 9: {
                        escape = 116;
                        break;
                    }
                    case 11: {
                        escape = 118;
                        break;
                    }
                    case 32: {
                        escape = 32;
                        break;
                    }
                    case 92: {
                        escape = 92;
                        break;
                    }
                }
                if (escape >= 0) {
                    sb.append('\\');
                    sb.append((char)escape);
                }
                else if (c == escapeQuote) {
                    sb.append('\\');
                    sb.append(escapeQuote);
                }
                else {
                    int hexSize;
                    if (c < 256) {
                        sb.append("\\x");
                        hexSize = 2;
                    }
                    else {
                        sb.append("\\u");
                        hexSize = 4;
                    }
                    for (int shift = (hexSize - 1) * 4; shift >= 0; shift -= 4) {
                        final int digit = 0xF & c >> shift;
                        final int hc = (digit < 10) ? (48 + digit) : (87 + digit);
                        sb.append((char)hc);
                    }
                }
            }
        }
        return (sb == null) ? s : sb.toString();
    }
    
    static boolean isValidIdentifierName(final String s, final Context cx, final boolean isStrict) {
        final int L = s.length();
        if (L == 0) {
            return false;
        }
        if (!Character.isJavaIdentifierStart(s.charAt(0))) {
            return false;
        }
        for (int i = 1; i != L; ++i) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) {
                return false;
            }
        }
        return !TokenStream.isKeyword(s, cx.getLanguageVersion(), isStrict);
    }
    
    public static CharSequence toCharSequence(final Object val) {
        if (val instanceof NativeString) {
            return ((NativeString)val).toCharSequence();
        }
        return (val instanceof CharSequence) ? ((CharSequence)val) : toString(val);
    }
    
    public static String toString(Object val) {
        while (val != null) {
            if (val == Undefined.instance || val == Undefined.SCRIPTABLE_UNDEFINED) {
                return "undefined";
            }
            if (val instanceof String) {
                return (String)val;
            }
            if (val instanceof CharSequence) {
                return val.toString();
            }
            if (val instanceof Number) {
                return numberToString(((Number)val).doubleValue(), 10);
            }
            if (val instanceof Symbol) {
                throw typeError0("msg.not.a.string");
            }
            if (!(val instanceof Scriptable)) {
                return val.toString();
            }
            val = ((Scriptable)val).getDefaultValue((Class)ScriptRuntime.StringClass);
            if (val instanceof Scriptable && !isSymbol(val)) {
                throw errorWithClassName("msg.primitive.expected", val);
            }
        }
        return "null";
    }
    
    public static String toStringPretty(Object val) {
        boolean quoteString = true;
        while (val != null) {
            if (val == Undefined.instance || val == Undefined.SCRIPTABLE_UNDEFINED) {
                return "undefined";
            }
            if (val instanceof String) {
                if (quoteString) {
                    return '\"' + (String)val + '\"';
                }
                return (String)val;
            }
            else {
                if (val instanceof CharSequence) {
                    return val.toString();
                }
                if (val instanceof Number) {
                    return numberToString(((Number)val).doubleValue(), 10);
                }
                if (val instanceof Symbol) {
                    throw typeError0("msg.not.a.string");
                }
                if (!(val instanceof Scriptable)) {
                    return val.toString();
                }
                if (val instanceof NativeArray) {
                    return NativeArray.toStringHelper(Context.getContext(), Context.getContext().topCallScope, (Scriptable)val, true, false);
                }
                if (val instanceof NativeObject) {
                    return NativeJSON.stringify(Context.getContext(), Context.getScope(), val, (Object)null, (Object)2).toString();
                }
                val = ((Scriptable)val).getDefaultValue((Class)ScriptRuntime.StringClass);
                quoteString = false;
                if (val instanceof Scriptable && !isSymbol(val)) {
                    throw errorWithClassName("msg.primitive.expected", val);
                }
                continue;
            }
        }
        return "null";
    }
    
    static String defaultObjectToString(final Scriptable obj) {
        if (obj == null) {
            return "[object Null]";
        }
        if (Undefined.isUndefined(obj)) {
            return "[object Undefined]";
        }
        if (ScriptableObject.hasProperty(obj, (Symbol)SymbolKey.TO_STRING_TAG)) {
            final Object toStringTag = ScriptableObject.getProperty(obj, (Symbol)SymbolKey.TO_STRING_TAG);
            if (toStringTag instanceof String) {
                return "[object " + toStringTag + "]";
            }
        }
        return "[object " + obj.getClassName() + ']';
    }
    
    public static String toString(final Object[] args, final int index) {
        return (index < args.length) ? toString(args[index]) : "undefined";
    }
    
    public static String toString(final double val) {
        return numberToString(val, 10);
    }
    
    public static String numberToString(final double d, final int base) {
        if (base < 2 || base > 36) {
            throw Context.reportRuntimeError1("msg.bad.radix", (Object)Integer.toString(base));
        }
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d == 0.0) {
            return "0";
        }
        if (base != 10) {
            return DToA.JS_dtobasestr(base, d);
        }
        final String result = FastDtoa.numberToString(d);
        if (result != null) {
            return result;
        }
        final StringBuilder buffer = new StringBuilder();
        DToA.JS_dtostr(buffer, 0, 0, d);
        return buffer.toString();
    }
    
    static String uneval(final Context cx, final Scriptable scope, final Object value) {
        if (value == null) {
            return "null";
        }
        if (value == Undefined.instance) {
            return "undefined";
        }
        if (value instanceof CharSequence) {
            final String escaped = escapeString(value.toString());
            final StringBuilder sb = new StringBuilder(escaped.length() + 2);
            sb.append('\"');
            sb.append(escaped);
            sb.append('\"');
            return sb.toString();
        }
        if (value instanceof Number) {
            final double d = ((Number)value).doubleValue();
            if (d == 0.0 && 1.0 / d < 0.0) {
                return "-0";
            }
            return toString(d);
        }
        else {
            if (value instanceof Boolean) {
                return toString(value);
            }
            if (value instanceof Scriptable) {
                final Scriptable obj = (Scriptable)value;
                if (ScriptableObject.hasProperty(obj, "toSource")) {
                    final Object v = ScriptableObject.getProperty(obj, "toSource");
                    if (v instanceof Function) {
                        final Function f = (Function)v;
                        return toString(f.call(cx, scope, obj, ScriptRuntime.emptyArgs));
                    }
                }
                return toString(value);
            }
            warnAboutNonJSObject(value);
            return value.toString();
        }
    }
    
    static String defaultObjectToSource(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        boolean toplevel;
        boolean iterating;
        if (cx.iterating == null) {
            toplevel = true;
            iterating = false;
            cx.iterating = new ObjToIntMap(31);
        }
        else {
            toplevel = false;
            iterating = cx.iterating.has((Object)thisObj);
        }
        final StringBuilder result = new StringBuilder(128);
        if (toplevel) {
            result.append("(");
        }
        result.append('{');
        try {
            if (!iterating) {
                cx.iterating.intern((Object)thisObj);
                final Object[] ids = thisObj.getIds();
                for (int i = 0; i < ids.length; ++i) {
                    final Object id = ids[i];
                    Object value;
                    if (id instanceof Integer) {
                        final int intId = (int)id;
                        value = thisObj.get(intId, thisObj);
                        if (value == Scriptable.NOT_FOUND) {
                            continue;
                        }
                        if (i > 0) {
                            result.append(", ");
                        }
                        result.append(intId);
                    }
                    else {
                        final String strId = (String)id;
                        value = thisObj.get(strId, thisObj);
                        if (value == Scriptable.NOT_FOUND) {
                            continue;
                        }
                        if (i > 0) {
                            result.append(", ");
                        }
                        if (isValidIdentifierName(strId, cx, cx.isStrictMode())) {
                            result.append(strId);
                        }
                        else {
                            result.append('\'');
                            result.append(escapeString(strId, '\''));
                            result.append('\'');
                        }
                    }
                    result.append(':');
                    result.append(uneval(cx, scope, value));
                }
            }
        }
        finally {
            if (toplevel) {
                cx.iterating = null;
            }
        }
        result.append('}');
        if (toplevel) {
            result.append(')');
        }
        return result.toString();
    }
    
    public static Scriptable toObject(final Scriptable scope, final Object val) {
        if (val instanceof Scriptable) {
            return (Scriptable)val;
        }
        return toObject(Context.getContext(), scope, val);
    }
    
    @Deprecated
    public static Scriptable toObjectOrNull(final Context cx, final Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable)obj;
        }
        if (obj != null && obj != Undefined.instance) {
            return toObject(cx, getTopCallScope(cx), obj);
        }
        return null;
    }
    
    public static Scriptable toObjectOrNull(final Context cx, final Object obj, final Scriptable scope) {
        if (obj instanceof Scriptable) {
            return (Scriptable)obj;
        }
        if (obj != null && obj != Undefined.instance) {
            return toObject(cx, scope, obj);
        }
        return null;
    }
    
    @Deprecated
    public static Scriptable toObject(final Scriptable scope, final Object val, final Class<?> staticClass) {
        if (val instanceof Scriptable) {
            return (Scriptable)val;
        }
        return toObject(Context.getContext(), scope, val);
    }
    
    public static Scriptable toObject(final Context cx, final Scriptable scope, final Object val) {
        if (val == null) {
            throw typeError0("msg.null.to.object");
        }
        if (Undefined.isUndefined(val)) {
            throw typeError0("msg.undef.to.object");
        }
        if (isSymbol(val)) {
            final NativeSymbol result = (val instanceof NativeSymbol) ? new NativeSymbol((NativeSymbol)val) : new NativeSymbol((SymbolKey)val);
            setBuiltinProtoAndParent((ScriptableObject)result, scope, TopLevel.Builtins.Symbol);
            return (Scriptable)result;
        }
        if (val instanceof Scriptable) {
            return (Scriptable)val;
        }
        if (val instanceof CharSequence) {
            final NativeString result2 = new NativeString((CharSequence)val);
            setBuiltinProtoAndParent((ScriptableObject)result2, scope, TopLevel.Builtins.String);
            return (Scriptable)result2;
        }
        if (val instanceof Number) {
            final NativeNumber result3 = new NativeNumber(((Number)val).doubleValue());
            setBuiltinProtoAndParent((ScriptableObject)result3, scope, TopLevel.Builtins.Number);
            return (Scriptable)result3;
        }
        if (val instanceof Boolean) {
            final NativeBoolean result4 = new NativeBoolean((boolean)val);
            setBuiltinProtoAndParent((ScriptableObject)result4, scope, TopLevel.Builtins.Boolean);
            return (Scriptable)result4;
        }
        final Object wrapped = cx.getWrapFactory().wrap(cx, scope, val, null);
        if (wrapped instanceof Scriptable) {
            return (Scriptable)wrapped;
        }
        throw errorWithClassName("msg.invalid.type", val);
    }
    
    @Deprecated
    public static Scriptable toObject(final Context cx, final Scriptable scope, final Object val, final Class<?> staticClass) {
        return toObject(cx, scope, val);
    }
    
    @Deprecated
    public static Object call(final Context cx, final Object fun, final Object thisArg, final Object[] args, final Scriptable scope) {
        if (!(fun instanceof Function)) {
            throw notFunctionError(toString(fun));
        }
        final Function function = (Function)fun;
        final Scriptable thisObj = toObjectOrNull(cx, thisArg, scope);
        if (thisObj == null) {
            throw undefCallError(thisObj, "function");
        }
        return function.call(cx, scope, thisObj, args);
    }
    
    public static Scriptable newObject(final Context cx, Scriptable scope, final String constructorName, Object[] args) {
        scope = ScriptableObject.getTopLevelScope(scope);
        final Function ctor = getExistingCtor(cx, scope, constructorName);
        if (args == null) {
            args = ScriptRuntime.emptyArgs;
        }
        return ctor.construct(cx, scope, args);
    }
    
    public static Scriptable newBuiltinObject(final Context cx, Scriptable scope, final TopLevel.Builtins type, Object[] args) {
        scope = ScriptableObject.getTopLevelScope(scope);
        final Function ctor = TopLevel.getBuiltinCtor(cx, scope, type);
        if (args == null) {
            args = ScriptRuntime.emptyArgs;
        }
        return ctor.construct(cx, scope, args);
    }
    
    static Scriptable newNativeError(final Context cx, Scriptable scope, final TopLevel.NativeErrors type, Object[] args) {
        scope = ScriptableObject.getTopLevelScope(scope);
        final Function ctor = TopLevel.getNativeErrorCtor(cx, scope, type);
        if (args == null) {
            args = ScriptRuntime.emptyArgs;
        }
        return ctor.construct(cx, scope, args);
    }
    
    public static double toInteger(final Object val) {
        return toInteger(toNumber(val));
    }
    
    public static double toInteger(final double d) {
        if (Double.isNaN(d)) {
            return 0.0;
        }
        if (d == 0.0 || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return d;
        }
        if (d > 0.0) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }
    
    public static double toInteger(final Object[] args, final int index) {
        return (index < args.length) ? toInteger(args[index]) : 0.0;
    }
    
    public static long toLength(final Object[] args, final int index) {
        final double len = toInteger(args, index);
        if (len <= 0.0) {
            return 0L;
        }
        return (long)Math.min(len, 9.007199254740991E15);
    }
    
    public static int toInt32(final Object val) {
        if (val instanceof Integer) {
            return (int)val;
        }
        return toInt32(toNumber(val));
    }
    
    public static int toInt32(final Object[] args, final int index) {
        return (index < args.length) ? toInt32(args[index]) : 0;
    }
    
    public static int toInt32(final double d) {
        return DoubleConversion.doubleToInt32(d);
    }
    
    public static long toUint32(final double d) {
        return (long)DoubleConversion.doubleToInt32(d) & 0xFFFFFFFFL;
    }
    
    public static long toUint32(final Object val) {
        return toUint32(toNumber(val));
    }
    
    public static char toUint16(final Object val) {
        final double d = toNumber(val);
        return (char)DoubleConversion.doubleToInt32(d);
    }
    
    public static Object getTopLevelProp(Scriptable scope, final String id) {
        scope = ScriptableObject.getTopLevelScope(scope);
        return ScriptableObject.getProperty(scope, id);
    }
    
    static Function getExistingCtor(final Context cx, final Scriptable scope, final String constructorName) {
        final Object ctorVal = ScriptableObject.getProperty(scope, constructorName);
        if (ctorVal instanceof Function) {
            return (Function)ctorVal;
        }
        if (ctorVal == Scriptable.NOT_FOUND) {
            throw Context.reportRuntimeError1("msg.ctor.not.found", (Object)constructorName);
        }
        throw Context.reportRuntimeError1("msg.not.ctor", (Object)constructorName);
    }
    
    public static long indexFromString(final String str) {
        final int MAX_VALUE_LENGTH = 10;
        final int len = str.length();
        if (len > 0) {
            int i = 0;
            boolean negate = false;
            int c = str.charAt(0);
            if (c == 45 && len > 1) {
                c = str.charAt(1);
                if (c == 48) {
                    return -1L;
                }
                i = 1;
                negate = true;
            }
            c -= 48;
            if (0 <= c && c <= 9 && len <= (negate ? 11 : 10)) {
                int index = -c;
                int oldIndex = 0;
                ++i;
                if (index != 0) {
                    while (i != len && 0 <= (c = str.charAt(i) - '0') && c <= 9) {
                        oldIndex = index;
                        index = 10 * index - c;
                        ++i;
                    }
                }
                if (i == len && (oldIndex > -214748364 || (oldIndex == -214748364 && c <= (negate ? 8 : 7)))) {
                    return 0xFFFFFFFFL & (long)(negate ? index : (-index));
                }
            }
        }
        return -1L;
    }
    
    public static long testUint32String(final String str) {
        final int MAX_VALUE_LENGTH = 10;
        final int len = str.length();
        if (1 <= len && len <= 10) {
            int c = str.charAt(0);
            c -= 48;
            if (c == 0) {
                return (len == 1) ? 0L : -1L;
            }
            if (1 <= c && c <= 9) {
                long v = c;
                for (int i = 1; i != len; ++i) {
                    c = str.charAt(i) - '0';
                    if (0 > c || c > 9) {
                        return -1L;
                    }
                    v = 10L * v + c;
                }
                if (v >>> 32 == 0L) {
                    return v;
                }
            }
        }
        return -1L;
    }
    
    static Object getIndexObject(final String s) {
        final long indexTest = indexFromString(s);
        if (indexTest >= 0L) {
            return (int)indexTest;
        }
        return s;
    }
    
    static Object getIndexObject(final double d) {
        final int i = (int)d;
        if (i == d) {
            return i;
        }
        return toString(d);
    }
    
    static String toStringIdOrIndex(final Context cx, final Object id) {
        if (id instanceof Number) {
            final double d = ((Number)id).doubleValue();
            final int index = (int)d;
            if (index == d) {
                storeIndexResult(cx, index);
                return null;
            }
            return toString(id);
        }
        else {
            String s;
            if (id instanceof String) {
                s = (String)id;
            }
            else {
                s = toString(id);
            }
            final long indexTest = indexFromString(s);
            if (indexTest >= 0L) {
                storeIndexResult(cx, (int)indexTest);
                return null;
            }
            return s;
        }
    }
    
    @Deprecated
    public static Object getObjectElem(final Object obj, final Object elem, final Context cx) {
        return getObjectElem(obj, elem, cx, getTopCallScope(cx));
    }
    
    public static Object getObjectElem(final Object obj, final Object elem, final Context cx, final Scriptable scope) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefReadError(obj, elem);
        }
        return getObjectElem(sobj, elem, cx);
    }
    
    public static Object getObjectElem(final Scriptable obj, final Object elem, final Context cx) {
        Object result;
        if (isSymbol(elem)) {
            result = ScriptableObject.getProperty(obj, (Symbol)elem);
        }
        else {
            if (obj instanceof NativeGenerator) {
                final NativeGenerator gen = (NativeGenerator)obj;
                final Object o = ScriptableObject.callMethod((Scriptable)gen, "next", new Object[0]);
                return ScriptableObject.getProperty(o, (Object)"value");
            }
            final String s = toStringIdOrIndex(cx, elem);
            if (s == null) {
                final int index = lastIndexResult(cx);
                result = ScriptableObject.getProperty(obj, index);
            }
            else {
                result = ScriptableObject.getProperty(obj, s);
            }
        }
        if (result == Scriptable.NOT_FOUND) {
            result = Undefined.instance;
        }
        return result;
    }
    
    public static Object getObjectProp(final Object obj, final String property, final Context cx, final Scriptable scope, final boolean isPrivate) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefReadError(obj, property);
        }
        return getObjectProp(sobj, property, cx, isPrivate);
    }
    
    public static Object getObjectProp(final Scriptable obj, final String property, final Context cx, final boolean isPrivate) {
        Object result = ScriptableObject.getProperty(obj, property, isPrivate);
        if (result == Scriptable.NOT_FOUND) {
            if (cx.hasFeature(10)) {
                Context.reportWarning(getMessage1("msg.ref.undefined.prop", property));
            }
            result = Undefined.instance;
        }
        return result;
    }
    
    public static Object getObjectPropNoWarn(final Object obj, final String property, final Context cx, final Scriptable scope, final boolean isPrivate) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefReadError(obj, property);
        }
        final Object result = ScriptableObject.getProperty(sobj, property, isPrivate);
        if (result == Scriptable.NOT_FOUND) {
            return Undefined.instance;
        }
        return result;
    }
    
    @Deprecated
    public static Object getObjectIndex(final Object obj, final double dblIndex, final Context cx) {
        return getObjectIndex(obj, dblIndex, cx, getTopCallScope(cx));
    }
    
    public static Object getObjectIndex(final Object obj, final double dblIndex, final Context cx, final Scriptable scope) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefReadError(obj, toString(dblIndex));
        }
        final int index = (int)dblIndex;
        if (index == dblIndex) {
            return getObjectIndex(sobj, index, cx);
        }
        final String s = toString(dblIndex);
        return getObjectProp(sobj, s, cx, scope, false);
    }
    
    public static Object getObjectIndex(final Scriptable obj, final int index, final Context cx) {
        Object result = ScriptableObject.getProperty(obj, index);
        if (result == Scriptable.NOT_FOUND) {
            result = Undefined.instance;
        }
        return result;
    }
    
    @Deprecated
    public static Object setObjectElem(final Object obj, final Object elem, final Object value, final Context cx) {
        return setObjectElem(obj, elem, value, cx, getTopCallScope(cx));
    }
    
    public static Object setObjectElem(final Object obj, final Object elem, final Object value, final Context cx, final Scriptable scope) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefWriteError(obj, elem, value);
        }
        return setObjectElem(sobj, elem, value, cx);
    }
    
    public static Object setObjectElem(final Scriptable obj, final Object elem, final Object value, final Context cx) {
        if (isSymbol(elem)) {
            ScriptableObject.putProperty(obj, (Symbol)elem, value);
        }
        else {
            final String s = toStringIdOrIndex(cx, elem);
            if (s == null) {
                final int index = lastIndexResult(cx);
                ScriptableObject.putProperty(obj, index, value);
            }
            else {
                ScriptableObject.putProperty(obj, s, value);
            }
        }
        return value;
    }
    
    public static Object setObjectProp(final Object obj, final String property, final Object value, final Context cx, final Scriptable scope, final boolean isPrivate) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefWriteError(obj, property, value);
        }
        return setObjectProp(sobj, property, value, cx, isPrivate);
    }
    
    public static Object setObjectProp(final Scriptable obj, final String property, final Object value, final Context cx, final boolean isPrivate) {
        ScriptableObject.putProperty(obj, property, value, isPrivate);
        return value;
    }
    
    @Deprecated
    public static Object setObjectIndex(final Object obj, final double dblIndex, final Object value, final Context cx) {
        return setObjectIndex(obj, dblIndex, value, cx, getTopCallScope(cx));
    }
    
    public static Object setObjectIndex(final Object obj, final double dblIndex, final Object value, final Context cx, final Scriptable scope) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefWriteError(obj, String.valueOf(dblIndex), value);
        }
        final int index = (int)dblIndex;
        if (index == dblIndex) {
            return setObjectIndex(sobj, index, value, cx);
        }
        final String s = toString(dblIndex);
        return setObjectProp(sobj, s, value, cx, false);
    }
    
    public static Object setObjectIndex(final Scriptable obj, final int index, final Object value, final Context cx) {
        ScriptableObject.putProperty(obj, index, value);
        return value;
    }
    
    public static boolean deleteObjectElem(final Scriptable target, final Object elem, final Context cx) {
        if (isSymbol(elem)) {
            final SymbolScriptable so = ScriptableObject.ensureSymbolScriptable((Object)target);
            final Symbol s = (Symbol)elem;
            so.delete(s);
            return !so.has(s, target);
        }
        final String s2 = toStringIdOrIndex(cx, elem);
        if (s2 == null) {
            final int index = lastIndexResult(cx);
            target.delete(index);
            return !target.has(index, target);
        }
        target.delete(s2);
        return !target.has(s2, target);
    }
    
    public static boolean hasObjectElem(final Scriptable target, final Object elem, final Context cx) {
        boolean result;
        if (isSymbol(elem)) {
            result = ScriptableObject.hasProperty(target, (Symbol)elem);
        }
        else {
            final String s = toStringIdOrIndex(cx, elem);
            if (s == null) {
                final int index = lastIndexResult(cx);
                result = ScriptableObject.hasProperty(target, index);
            }
            else {
                result = ScriptableObject.hasProperty(target, s);
            }
        }
        return result;
    }
    
    public static Object refGet(final Ref ref, final Context cx) {
        return ref.get(cx);
    }
    
    @Deprecated
    public static Object refSet(final Ref ref, final Object value, final Context cx) {
        return refSet(ref, value, cx, getTopCallScope(cx));
    }
    
    public static Object refSet(final Ref ref, final Object value, final Context cx, final Scriptable scope) {
        return ref.set(cx, scope, value);
    }
    
    public static Object refDel(final Ref ref, final Context cx) {
        return wrapBoolean(ref.delete(cx));
    }
    
    static boolean isSpecialProperty(final String s) {
        return s.equals("__proto__") || s.equals("__parent__");
    }
    
    @Deprecated
    public static Ref specialRef(final Object obj, final String specialProperty, final Context cx) {
        return specialRef(obj, specialProperty, cx, getTopCallScope(cx));
    }
    
    public static Ref specialRef(final Object obj, final String specialProperty, final Context cx, final Scriptable scope) {
        return SpecialRef.createSpecial(cx, scope, obj, specialProperty);
    }
    
    @Deprecated
    public static Object delete(final Object obj, final Object id, final Context cx) {
        return delete(obj, id, cx, false);
    }
    
    @Deprecated
    public static Object delete(final Object obj, final Object id, final Context cx, final boolean isName) {
        return delete(obj, id, cx, getTopCallScope(cx), isName);
    }
    
    public static Object delete(final Object obj, final Object id, final Context cx, final Scriptable scope, final boolean isName) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            if (isName) {
                return Boolean.TRUE;
            }
            throw undefDeleteError(obj, id);
        }
        else {
            final boolean result = deleteObjectElem(sobj, id, cx);
            if (!result && (cx.isStrictMode() || cx.hasFeature(10))) {
                throw typeError1("msg.delete.failed.strict", toString(id));
            }
            return wrapBoolean(result);
        }
    }
    
    public static Object name(final Context cx, final Scriptable scope, final String name) {
        final Scriptable parent = scope.getParentScope();
        if (parent != null) {
            return nameOrFunction(cx, scope, parent, name, false);
        }
        final Object result = topScopeName(cx, scope, name);
        if (result == Scriptable.NOT_FOUND) {
            throw notFoundError(scope, name);
        }
        return result;
    }
    
    private static Object nameOrFunction(final Context cx, Scriptable scope, Scriptable parentScope, final String name, final boolean asFunctionCall) {
        Scriptable thisObj = scope;
    Label_0145:
        while (true) {
            do {
                if (scope instanceof NativeWith) {
                    final Scriptable withObj = scope.getPrototype();
                    final Object result = ScriptableObject.getProperty(withObj, name);
                    if (result != Scriptable.NOT_FOUND) {
                        thisObj = withObj;
                        break Label_0145;
                    }
                }
                else if (scope instanceof NativeCall) {
                    final Object result = scope.get(name, scope);
                    if (result != Scriptable.NOT_FOUND) {
                        if (asFunctionCall) {
                            thisObj = ScriptableObject.getTopLevelScope(parentScope);
                        }
                        break Label_0145;
                    }
                }
                else {
                    final Object result = ScriptableObject.getProperty(scope, name);
                    if (result != Scriptable.NOT_FOUND) {
                        thisObj = scope;
                        break Label_0145;
                    }
                }
                scope = parentScope;
                parentScope = parentScope.getParentScope();
                continue;
                Object result = null;
                if (asFunctionCall) {
                    if (!(result instanceof Callable)) {
                        throw notFunctionError(result, name);
                    }
                    storeScriptable(cx, thisObj);
                }
                return result;
            } while (parentScope != null);
            final Object result = topScopeName(cx, scope, name);
            if (result == Scriptable.NOT_FOUND) {
                throw notFoundError(scope, name);
            }
            thisObj = scope;
            continue Label_0145;
        }
    }
    
    private static Object topScopeName(final Context cx, Scriptable scope, final String name) {
        if (cx.useDynamicScope) {
            scope = checkDynamicScope(cx.topCallScope, scope);
        }
        return ScriptableObject.getProperty(scope, name);
    }
    
    public static Scriptable bind(final Context cx, Scriptable scope, final String id) {
        Scriptable parent = scope.getParentScope();
        Label_0083: {
            if (parent != null) {
                while (scope instanceof NativeWith) {
                    final Scriptable withObj = scope.getPrototype();
                    if (ScriptableObject.hasProperty(withObj, id)) {
                        return withObj;
                    }
                    scope = parent;
                    parent = parent.getParentScope();
                    if (parent == null) {
                        break Label_0083;
                    }
                }
                while (!ScriptableObject.hasProperty(scope, id)) {
                    scope = parent;
                    parent = parent.getParentScope();
                    if (parent == null) {
                        break Label_0083;
                    }
                }
                return scope;
            }
        }
        if (cx.useDynamicScope) {
            scope = checkDynamicScope(cx.topCallScope, scope);
        }
        if (ScriptableObject.hasProperty(scope, id)) {
            return scope;
        }
        return null;
    }
    
    public static Object setName(Scriptable bound, final Object value, final Context cx, final Scriptable scope, final String id) {
        setFunctionNameIfApplicable(value, id);
        if (bound != null) {
            ScriptableObject.putProperty(bound, id, value);
        }
        else {
            if (cx.hasFeature(10) || cx.hasFeature(7)) {
                Context.reportWarning(getMessage1("msg.assn.create.strict", id));
            }
            bound = ScriptableObject.getTopLevelScope(scope);
            if (cx.useDynamicScope) {
                bound = checkDynamicScope(cx.topCallScope, bound);
            }
            bound.put(id, bound, value);
        }
        return value;
    }
    
    public static Object strictSetName(final Scriptable bound, final Object value, final Context cx, final Scriptable scope, final String id) {
        if (bound != null) {
            ScriptableObject.putProperty(bound, id, value);
            return value;
        }
        final String msg = "Assignment to undefined \"" + id + "\" in strict mode";
        throw constructError("ReferenceError", msg);
    }
    
    public static Object setConst(final Scriptable bound, final Object value, final Context cx, final String id) {
        ScriptableObject.putConstProperty((Object)bound, id, value);
        return value;
    }
    
    public static ES6Iterator toIterator(final Context cx, final Scriptable scope, final Scriptable obj, final boolean keyOnly) {
        Object key = null;
        if (ScriptableObject.hasProperty(obj, (Symbol)SymbolKey.ITERATOR)) {
            key = SymbolKey.ITERATOR;
        }
        else if (ScriptableObject.hasProperty(obj, "__iterator__")) {
            key = "__iterator__";
        }
        if (key == null) {
            return null;
        }
        final Object v = ScriptableObject.getProperty((Object)obj, key);
        if (!(v instanceof Callable)) {
            throw typeError0("msg.invalid.iterator");
        }
        final Callable f = (Callable)v;
        final Object[] args = { keyOnly ? Boolean.TRUE : Boolean.FALSE };
        Object result;
        try {
            result = f.call(cx, scope, obj, args);
        }
        catch (Exception e) {
            return null;
        }
        if (result instanceof ES6Iterator) {
            return (ES6Iterator)result;
        }
        if (result instanceof NativeObject) {
            return (ES6Iterator)ES6LikeIterator.from(cx, scope, result);
        }
        throw typeError0("msg.iterator.primitive");
    }
    
    @Deprecated
    public static Object enumInit(final Object value, final Context cx, final boolean enumValues) {
        return enumInit(value, cx, enumValues ? 1 : 0);
    }
    
    @Deprecated
    public static Object enumInit(final Object value, final Context cx, final int enumType) {
        return enumInit(value, cx, getTopCallScope(cx), enumType);
    }
    
    public static Object enumInit(final Object value, final Context cx, final Scriptable scope, final int enumType) {
        final IdEnumeration x = new IdEnumeration();
        x.obj = toObjectOrNull(cx, value, scope);
        if (enumType == 6) {
            x.enumType = enumType;
            x.iterator = null;
            return enumInitInOrder(cx, x);
        }
        if (x.obj == null) {
            return x;
        }
        x.enumType = enumType;
        x.iterator = null;
        if (enumType != 3 && enumType != 4 && enumType != 5) {
            x.iterator = (Scriptable)toIterator(cx, x.obj.getParentScope(), x.obj, enumType == 0);
        }
        if (x.iterator == null) {
            enumChangeObject(x);
        }
        return x;
    }
    
    private static Object enumInitInOrder(final Context cx, final IdEnumeration x) {
        if (!(x.obj instanceof SymbolScriptable) || !ScriptableObject.hasProperty(x.obj, (Symbol)SymbolKey.ITERATOR)) {
            throw typeError1("msg.not.iterable", toString(x.obj));
        }
        final Object iterator = ScriptableObject.getProperty(x.obj, (Symbol)SymbolKey.ITERATOR);
        if (!(iterator instanceof Callable)) {
            throw typeError1("msg.not.iterable", toString(x.obj));
        }
        final Callable f = (Callable)iterator;
        final Scriptable scope = x.obj.getParentScope();
        final Object[] args = new Object[0];
        final Object v = f.call(cx, scope, x.obj, args);
        if (!(v instanceof Scriptable)) {
            throw typeError1("msg.not.iterable", toString(x.obj));
        }
        x.iterator = (Scriptable)v;
        return x;
    }
    
    public static void setEnumNumbers(final Object enumObj, final boolean enumNumbers) {
        ((IdEnumeration)enumObj).enumNumbers = enumNumbers;
    }
    
    public static Boolean enumNext(final Object enumObj) {
        final IdEnumeration x = (IdEnumeration)enumObj;
        if (x.iterator != null) {
            if (x.enumType == 6) {
                return enumNextInOrder(x);
            }
            final Object v = ScriptableObject.getProperty(x.iterator, "next");
            if (!(v instanceof Callable)) {
                return Boolean.FALSE;
            }
            final Callable f = (Callable)v;
            final Context cx = Context.getContext();
            try {
                final Object result = f.call(cx, x.iterator.getParentScope(), x.iterator, ScriptRuntime.emptyArgs);
                if (result instanceof Scriptable && ScriptableObject.hasProperty((Scriptable)result, "done")) {
                    x.currentId = toString(ScriptableObject.getProperty((Scriptable)result, "value"));
                    final Object done = ScriptableObject.getProperty((Scriptable)result, "done");
                    return !(done instanceof Boolean) || !(boolean)done;
                }
                x.currentId = result;
                return Boolean.TRUE;
            }
            catch (JavaScriptException e) {
                if (e.getValue() instanceof NativeIterator.StopIteration) {
                    return Boolean.FALSE;
                }
                throw e;
            }
        }
        while (x.obj != null) {
            if (x.index == x.ids.length) {
                x.obj = x.obj.getPrototype();
                enumChangeObject(x);
            }
            else {
                final Object id = x.ids[x.index++];
                if (x.used != null && x.used.has(id)) {
                    continue;
                }
                if (id instanceof Symbol) {
                    continue;
                }
                if (id instanceof String) {
                    final String strId = (String)id;
                    if (!x.obj.has(strId, x.obj)) {
                        continue;
                    }
                    x.currentId = strId;
                }
                else {
                    final int intId = ((Number)id).intValue();
                    if (!x.obj.has(intId, x.obj)) {
                        continue;
                    }
                    x.currentId = (x.enumNumbers ? Integer.valueOf(intId) : String.valueOf(intId));
                }
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    
    private static Boolean enumNextInOrder(final IdEnumeration enumObj) {
        final Object v = ScriptableObject.getProperty(enumObj.iterator, "next");
        if (!(v instanceof Callable)) {
            throw notFunctionError(enumObj.iterator, "next");
        }
        final Callable f = (Callable)v;
        final Context cx = Context.getContext();
        final Scriptable scope = enumObj.iterator.getParentScope();
        final Object r = f.call(cx, scope, enumObj.iterator, ScriptRuntime.emptyArgs);
        final Scriptable iteratorResult = toObject(cx, scope, r);
        final Object done = ScriptableObject.getProperty(iteratorResult, "done");
        if (done != ScriptableObject.NOT_FOUND && toBoolean(done)) {
            return Boolean.FALSE;
        }
        enumObj.currentId = ScriptableObject.getProperty(iteratorResult, "value");
        return Boolean.TRUE;
    }
    
    public static Object enumId(final Object enumObj, final Context cx) {
        final IdEnumeration x = (IdEnumeration)enumObj;
        if (x.iterator != null) {
            return x.currentId;
        }
        switch (x.enumType) {
            case 0:
            case 3: {
                return x.currentId;
            }
            case 1:
            case 4: {
                return enumValue(enumObj, cx);
            }
            case 2:
            case 5: {
                final Object[] elements = { x.currentId, enumValue(enumObj, cx) };
                return cx.newArray(ScriptableObject.getTopLevelScope(x.obj), elements);
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    public static Object enumValue(final Object enumObj, final Context cx) {
        final IdEnumeration x = (IdEnumeration)enumObj;
        Object result;
        if (isSymbol(x.currentId)) {
            final SymbolScriptable so = ScriptableObject.ensureSymbolScriptable((Object)x.obj);
            result = so.get((Symbol)x.currentId, x.obj);
        }
        else {
            final String s = toStringIdOrIndex(cx, x.currentId);
            if (s == null) {
                final int index = lastIndexResult(cx);
                result = x.obj.get(index, x.obj);
            }
            else {
                result = x.obj.get(s, x.obj);
            }
        }
        return result;
    }
    
    private static void enumChangeObject(final IdEnumeration x) {
        Object[] ids = null;
        while (x.obj != null) {
            ids = x.obj.getIds();
            if (ids.length != 0) {
                break;
            }
            x.obj = x.obj.getPrototype();
        }
        if (x.obj != null && x.ids != null) {
            final Object[] previous = x.ids;
            final int L = previous.length;
            if (x.used == null) {
                x.used = new ObjToIntMap(L);
            }
            for (int i = 0; i != L; ++i) {
                x.used.intern(previous[i]);
            }
        }
        x.ids = ids;
        x.index = 0;
    }
    
    public static Callable getNameFunctionAndThis(final String name, final Context cx, final Scriptable scope) {
        final Scriptable parent = scope.getParentScope();
        if (parent != null) {
            return (Callable)nameOrFunction(cx, scope, parent, name, true);
        }
        final Object result = topScopeName(cx, scope, name);
        if (result instanceof Callable) {
            final Scriptable thisObj = scope;
            storeScriptable(cx, thisObj);
            return (Callable)result;
        }
        if (result == Scriptable.NOT_FOUND) {
            throw notFoundError(scope, name);
        }
        throw notFunctionError(result, name);
    }
    
    @Deprecated
    public static Callable getElemFunctionAndThis(final Object obj, final Object elem, final Context cx) {
        return getElemFunctionAndThis(obj, elem, cx, getTopCallScope(cx));
    }
    
    public static Callable getElemFunctionAndThis(final Object obj, final Object elem, final Context cx, final Scriptable scope) {
        Scriptable thisObj;
        Object value;
        if (isSymbol(elem)) {
            thisObj = toObjectOrNull(cx, obj, scope);
            if (thisObj == null) {
                throw undefCallError(obj, String.valueOf(elem));
            }
            value = ScriptableObject.getProperty(thisObj, (Symbol)elem);
        }
        else {
            final String str = toStringIdOrIndex(cx, elem);
            if (str != null) {
                return getPropFunctionAndThis(obj, str, cx, scope);
            }
            final int index = lastIndexResult(cx);
            thisObj = toObjectOrNull(cx, obj, scope);
            if (thisObj == null) {
                throw undefCallError(obj, String.valueOf(elem));
            }
            value = ScriptableObject.getProperty(thisObj, index);
        }
        if (!(value instanceof Callable)) {
            throw notFunctionError(value, elem);
        }
        storeScriptable(cx, thisObj);
        return (Callable)value;
    }
    
    public static Callable getPropFunctionAndThis(final Object obj, final String property, final Context cx, final Scriptable scope, final boolean isPrivate) {
        final Scriptable thisObj = toObjectOrNull(cx, obj, scope);
        if (thisObj == null) {
            throw undefCallError(obj, property);
        }
        final Object value = ScriptableObject.getProperty(thisObj, property, isPrivate);
        if (!(value instanceof Callable)) {
            throw notFunctionError(thisObj, value, "#" + property);
        }
        storeScriptable(cx, thisObj);
        return (Callable)value;
    }
    
    public static Callable getPropFunctionAndThis(final Object obj, final String property, final Context cx, final Scriptable scope) {
        return getPropFunctionAndThis(obj, property, cx, scope, false);
    }
    
    public static Callable getValueFunctionAndThis(final Object value, final Context cx) {
        if (!(value instanceof Callable)) {
            throw notFunctionError(value);
        }
        final Callable f = (Callable)value;
        Scriptable thisObj = null;
        if (f instanceof Scriptable) {
            thisObj = ((Scriptable)f).getParentScope();
        }
        if (thisObj == null) {
            if (cx.topCallScope == null) {
                throw new IllegalStateException();
            }
            thisObj = cx.topCallScope;
        }
        if (thisObj.getParentScope() != null) {
            if (!(thisObj instanceof NativeWith)) {
                if (thisObj instanceof NativeCall) {
                    thisObj = ScriptableObject.getTopLevelScope(thisObj);
                }
            }
        }
        storeScriptable(cx, thisObj);
        return f;
    }
    
    public static Object callIterator(final Object obj, final Context cx, final Scriptable scope) {
        final Callable getIterator = getElemFunctionAndThis(obj, SymbolKey.ITERATOR, cx, scope);
        final Scriptable iterable = lastStoredScriptable(cx);
        return getIterator.call(cx, scope, iterable, ScriptRuntime.emptyArgs);
    }
    
    public static Ref callRef(final Callable function, final Scriptable thisObj, final Object[] args, final Context cx) {
        if (!(function instanceof RefCallable)) {
            final String msg = getMessage1("msg.no.ref.from.function", toString(function));
            throw constructError("ReferenceError", msg);
        }
        final RefCallable rfunction = (RefCallable)function;
        final Ref ref = rfunction.refCall(cx, thisObj, args);
        if (ref == null) {
            throw new IllegalStateException(rfunction.getClass().getName() + ".refCall() returned null");
        }
        return ref;
    }
    
    public static Scriptable newObject(final Object fun, final Context cx, final Scriptable scope, final Object[] args) {
        if (!(fun instanceof Function)) {
            throw notFunctionError(fun);
        }
        final Function function = (Function)fun;
        return function.construct(cx, scope, args);
    }
    
    public static Object callSpecial(final Context cx, final Callable fun, final Scriptable thisObj, final Object[] args, final Scriptable scope, final Scriptable callerThis, final int callType, final String filename, final int lineNumber) {
        if (callType == 1) {
            if (thisObj.getParentScope() == null && NativeGlobal.isEvalFunction((Object)fun)) {
                return evalSpecial(cx, scope, callerThis, args, filename, lineNumber);
            }
        }
        else {
            if (callType != 2) {
                throw Kit.codeBug();
            }
            if (NativeWith.isWithFunction((Object)fun)) {
                throw Context.reportRuntimeError1("msg.only.from.new", (Object)"With");
            }
        }
        return fun.call(cx, scope, thisObj, args);
    }
    
    public static Object newSpecial(final Context cx, final Object fun, final Object[] args, final Scriptable scope, final int callType) {
        if (callType == 1) {
            if (NativeGlobal.isEvalFunction(fun)) {
                throw typeError1("msg.not.ctor", "eval");
            }
        }
        else {
            if (callType != 2) {
                throw Kit.codeBug();
            }
            if (NativeWith.isWithFunction(fun)) {
                return NativeWith.newWithSpecial(cx, scope, args);
            }
        }
        return newObject(fun, cx, scope, args);
    }
    
    public static Object applyOrCall(final boolean isApply, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final int L = args.length;
        final Callable function = getCallable(thisObj);
        Scriptable callThis = null;
        if (L != 0) {
            if (cx.hasFeature(14)) {
                callThis = toObjectOrNull(cx, args[0], scope);
            }
            else {
                callThis = ((args[0] == Undefined.instance) ? Undefined.SCRIPTABLE_UNDEFINED : toObjectOrNull(cx, args[0], scope));
            }
        }
        if (callThis == null && cx.hasFeature(14)) {
            callThis = getTopCallScope(cx);
        }
        Object[] callArgs;
        if (isApply) {
            callArgs = ((L <= 1) ? ScriptRuntime.emptyArgs : createArrFromArrayLike(cx, args[1]));
        }
        else if (L <= 1) {
            callArgs = ScriptRuntime.emptyArgs;
        }
        else {
            callArgs = new Object[L - 1];
            System.arraycopy(args, 1, callArgs, 0, L - 1);
        }
        return function.call(cx, scope, callThis, callArgs);
    }
    
    public static boolean isArrayLike(final Scriptable obj) {
        return obj != null && (obj instanceof NativeArray || obj instanceof Arguments || ScriptableObject.hasProperty(obj, "length"));
    }
    
    public static Object[] createArrFromArrayLike(final Context cx, final Object arg1) {
        if (arg1 == null || arg1 == Undefined.instance) {
            return ScriptRuntime.emptyArgs;
        }
        if (arg1 instanceof Scriptable && isArrayLike((Scriptable)arg1)) {
            return cx.getElements((Scriptable)arg1);
        }
        if (arg1 instanceof ScriptableObject) {
            return ScriptRuntime.emptyArgs;
        }
        throw typeError0("msg.arg.isnt.array");
    }
    
    static Callable getCallable(final Scriptable thisObj) {
        Callable function;
        if (thisObj instanceof Callable) {
            function = (Callable)thisObj;
        }
        else {
            final Object value = thisObj.getDefaultValue((Class)ScriptRuntime.FunctionClass);
            if (!(value instanceof Callable)) {
                throw notFunctionError(value, thisObj);
            }
            function = (Callable)value;
        }
        return function;
    }
    
    public static Object evalSpecial(final Context cx, final Scriptable scope, final Object thisArg, final Object[] args, String filename, int lineNumber) {
        if (args.length < 1) {
            return Undefined.instance;
        }
        final Object x = args[0];
        if (x instanceof CharSequence) {
            if (filename == null) {
                final int[] linep = { 0 };
                filename = Context.getSourcePositionFromStack(linep);
                if (filename != null) {
                    lineNumber = linep[0];
                }
                else {
                    filename = "";
                }
            }
            final String sourceName = makeUrlForGeneratedScript(true, filename, lineNumber);
            final ErrorReporter reporter = DefaultErrorReporter.forEval(cx.getErrorReporter());
            final Script script = cx.compileString(x.toString(), (Evaluator)new Codegen(), reporter, sourceName, 1, (Object)null);
            final Callable c = (Callable)script;
            return c.call(cx, scope, (Scriptable)thisArg, ScriptRuntime.emptyArgs);
        }
        if (cx.hasFeature(10) || cx.hasFeature(8)) {
            throw Context.reportRuntimeError0("msg.eval.nonstring.strict");
        }
        final String message = getMessage0("msg.eval.nonstring");
        Context.reportWarning(message);
        return x;
    }
    
    public static String typeof(final Object value) {
        return typeof(value, true);
    }
    
    public static String typeof(final Object value, final boolean checkForOperator) {
        if (checkForOperator) {
            final Object opResult = applyUnaryOperator(value, "typeof", Context.getContext());
            if (opResult != UniqueTag.NOT_FOUND) {
                return toString(opResult);
            }
        }
        if (value == null) {
            return "object";
        }
        if (value == Undefined.instance || value == Undefined.SCRIPTABLE_UNDEFINED) {
            return "undefined";
        }
        if (value instanceof ScriptableObject) {
            return ((ScriptableObject)value).getTypeOf();
        }
        if (value instanceof Scriptable) {
            return (value instanceof Callable) ? "function" : "object";
        }
        if (value instanceof CharSequence) {
            return "string";
        }
        if (value instanceof Number) {
            return "number";
        }
        if (value instanceof Boolean) {
            return "boolean";
        }
        if (value instanceof Symbol) {
            return "symbol";
        }
        throw errorWithClassName("msg.invalid.type", value);
    }
    
    public static String typeofName(final Scriptable scope, final String id) {
        final Context cx = Context.getContext();
        final Scriptable val = bind(cx, scope, id);
        if (val == null) {
            return "undefined";
        }
        return typeof(getObjectProp(val, id, cx, false));
    }
    
    public static boolean isObject(final Object value) {
        if (value == null) {
            return false;
        }
        if (Undefined.instance.equals(value)) {
            return false;
        }
        if (value instanceof ScriptableObject) {
            final String type = ((ScriptableObject)value).getTypeOf();
            return "object".equals(type) || "function".equals(type);
        }
        return value instanceof Scriptable && !(value instanceof Callable);
    }
    
    public static Object add(Object val1, Object val2, final Context cx) {
        final Object opResult = applyOperator(val1, val2, "+", cx);
        if (opResult != UniqueTag.NOT_FOUND) {
            return opResult;
        }
        if (val1 instanceof Number && val2 instanceof Number) {
            return wrapNumber(((Number)val1).doubleValue() + ((Number)val2).doubleValue());
        }
        if (val1 instanceof Symbol || val2 instanceof Symbol) {
            throw typeError0("msg.not.a.number");
        }
        if (val1 instanceof Scriptable) {
            val1 = ((Scriptable)val1).getDefaultValue((Class)null);
        }
        if (val2 instanceof Scriptable) {
            val2 = ((Scriptable)val2).getDefaultValue((Class)null);
        }
        if (val1 instanceof CharSequence || val2 instanceof CharSequence) {
            return new ConsString(toCharSequence(val1), toCharSequence(val2));
        }
        if (val1 instanceof Number && val2 instanceof Number) {
            return wrapNumber(((Number)val1).doubleValue() + ((Number)val2).doubleValue());
        }
        return wrapNumber(toNumber(val1) + toNumber(val2));
    }
    
    public static CharSequence add(final CharSequence val1, final Object val2) {
        return (CharSequence)new ConsString(val1, toCharSequence(val2));
    }
    
    public static CharSequence add(final Object val1, final CharSequence val2) {
        return (CharSequence)new ConsString(toCharSequence(val1), val2);
    }
    
    public static Object binaryOperator(final Object val1, final Object val2, final int op, final Context cx) {
        switch (op) {
            case 22: {
                return doArithmetic(val1, val2, "-", () -> OptRuntime.wrapDouble(toNumber(val1) - toNumber(val2)), cx);
            }
            case 23: {
                return doArithmetic(val1, val2, "*", () -> OptRuntime.wrapDouble(toNumber(val1) * toNumber(val2)), cx);
            }
            case 24: {
                return doArithmetic(val1, val2, "/", () -> OptRuntime.wrapDouble(toNumber(val1) / toNumber(val2)), cx);
            }
            case 25: {
                return doArithmetic(val1, val2, "%", () -> OptRuntime.wrapDouble(toNumber(val1) % toNumber(val2)), cx);
            }
            case 26: {
                return doArithmetic(val1, val2, "**", () -> OptRuntime.wrapDouble(Math.pow(toNumber(val1), toNumber(val2))), cx);
            }
            case 18: {
                return doArithmetic(val1, val2, "<<", () -> OptRuntime.wrapDouble((double)(toInt32(val1) << toInt32(val2))), cx);
            }
            case 19: {
                return doArithmetic(val1, val2, ">>", () -> OptRuntime.wrapDouble((double)(toInt32(val1) >> toInt32(val2))), cx);
            }
            case 20: {
                return doArithmetic(val1, val2, ">>>", () -> OptRuntime.wrapDouble((double)(toInt32(val1) >>> toInt32(val2))), cx);
            }
            case 11: {
                return doArithmetic(val1, val2, "&", () -> OptRuntime.wrapDouble((double)(toInt32(val1) & toInt32(val2))), cx);
            }
            case 9: {
                return doArithmetic(val1, val2, "|", () -> OptRuntime.wrapDouble((double)(toInt32(val1) | toInt32(val2))), cx);
            }
            case 10: {
                return doArithmetic(val1, val2, "^", () -> OptRuntime.wrapDouble((double)(toInt32(val1) ^ toInt32(val2))), cx);
            }
            case 14: {
                if (isNaN(val1) || isNaN(val2)) {
                    return false;
                }
                return doArithmetic(val1, val2, "<", () -> cmp_LT(val1, val2), cx);
            }
            case 15: {
                if (isNaN(val1) || isNaN(val2)) {
                    return false;
                }
                return doArithmetic(val1, val2, "<=", () -> cmp_LE(val1, val2), cx);
            }
            case 16: {
                if (isNaN(val1) || isNaN(val2)) {
                    return false;
                }
                return doArithmetic(val1, val2, ">", () -> !cmp_LE(val1, val2), cx);
            }
            case 17: {
                if (isNaN(val1) || isNaN(val2)) {
                    return false;
                }
                return doArithmetic(val1, val2, ">=", () -> !cmp_LT(val1, val2), cx);
            }
            default: {
                throw Kit.codeBug("Unexpected binary operator token: " + op);
            }
        }
    }
    
    public static Object unaryOperator(final Object val, final int op, final Context cx) {
        switch (op) {
            case 28: {
                return doArithmetic(val, "~", () -> OptRuntime.wrapDouble((double)~toInt32(val)), cx);
            }
            case 29: {
                return doArithmetic(val, "+", () -> OptRuntime.wrapDouble(toNumber(val)), cx);
            }
            case 30: {
                return doArithmetic(val, "-", () -> OptRuntime.wrapDouble(-toNumber(val)), cx);
            }
            case 27: {
                return doArithmetic(val, "!", () -> !toBoolean(val), cx);
            }
            default: {
                throw Kit.codeBug("Unexpected unary operator token: " + op);
            }
        }
    }
    
    private static Object doArithmetic(final Object val1, final Object val2, final String op, final Supplier<Object> fn, final Context cx) {
        final Object opResult = applyOperator(val1, val2, op, cx);
        if (opResult != UniqueTag.NOT_FOUND) {
            return opResult;
        }
        return fn.get();
    }
    
    private static Object doArithmetic(final Object val, final String op, final Supplier<Object> fn, final Context cx) {
        final Object opResult = applyUnaryOperator(val, op, cx);
        if (opResult != UniqueTag.NOT_FOUND) {
            return opResult;
        }
        return fn.get();
    }
    
    private static Object applyOperator(final Object lho, final Object rho, final String operator, final Context cx) {
        if (cx.getLanguageVersion() >= 200) {
            final NativeSymbol sym = NativeSymbol.operator(cx, operator);
            if (lho instanceof Scriptable && ScriptableObject.hasProperty((Scriptable)lho, (Symbol)sym)) {
                final Object fn = ScriptableObject.getProperty((Scriptable)lho, (Symbol)sym);
                if (!(fn instanceof Callable)) {
                    throw typeError2("msg.invalid.operator", operator, toString(lho));
                }
                return ((Callable)fn).call(cx, cx.topCallScope, (Scriptable)lho, new Object[] { rho });
            }
        }
        return UniqueTag.NOT_FOUND;
    }
    
    private static Object applyUnaryOperator(final Object lho, final String operator, final Context cx) {
        if (cx.getLanguageVersion() >= 200) {
            final NativeSymbol sym = NativeSymbol.unaryOperator(cx, operator);
            if (lho instanceof Scriptable && ScriptableObject.hasProperty((Scriptable)lho, (Symbol)sym)) {
                final Object fn = ScriptableObject.getProperty((Scriptable)lho, (Symbol)sym);
                if (!(fn instanceof Callable)) {
                    throw typeError2("msg.invalid.operator", operator, toString(lho));
                }
                return ((Callable)fn).call(cx, cx.topCallScope, (Scriptable)lho, new Object[0]);
            }
        }
        return UniqueTag.NOT_FOUND;
    }
    
    @Deprecated
    public static Object nameIncrDecr(final Scriptable scopeChain, final String id, final int incrDecrMask) {
        return nameIncrDecr(scopeChain, id, Context.getContext(), incrDecrMask);
    }
    
    public static Object nameIncrDecr(Scriptable scopeChain, final String id, final Context cx, final int incrDecrMask) {
        do {
            if (cx.useDynamicScope && scopeChain.getParentScope() == null) {
                scopeChain = checkDynamicScope(cx.topCallScope, scopeChain);
            }
            Scriptable target = scopeChain;
            do {
                final Object value = target.get(id, scopeChain);
                if (value != Scriptable.NOT_FOUND) {
                    return doScriptableIncrDecr(target, id, scopeChain, value, incrDecrMask);
                }
                target = target.getPrototype();
            } while (target != null);
            scopeChain = scopeChain.getParentScope();
        } while (scopeChain != null);
        throw notFoundError(scopeChain, id);
    }
    
    @Deprecated
    public static Object propIncrDecr(final Object obj, final String id, final Context cx, final int incrDecrMask) {
        return propIncrDecr(obj, id, cx, getTopCallScope(cx), incrDecrMask);
    }
    
    public static Object propIncrDecr(final Object obj, final String id, final Context cx, final Scriptable scope, final int incrDecrMask) {
        final Scriptable start = toObjectOrNull(cx, obj, scope);
        if (start == null) {
            throw undefReadError(obj, id);
        }
        Scriptable target = start;
        do {
            final Object value = target.get(id, start);
            if (value != Scriptable.NOT_FOUND) {
                return doScriptableIncrDecr(target, id, start, value, incrDecrMask);
            }
            target = target.getPrototype();
        } while (target != null);
        start.put(id, start, (Object)ScriptRuntime.NaNobj);
        return ScriptRuntime.NaNobj;
    }
    
    private static Object doScriptableIncrDecr(final Scriptable target, final String id, final Scriptable protoChainStart, Object value, final int incrDecrMask) {
        final Object opResult = applyUnaryOperator(value, ((incrDecrMask & 0x1) == 0x0) ? "++" : "--", Context.getContext());
        if (opResult != UniqueTag.NOT_FOUND) {
            return opResult;
        }
        final boolean post = (incrDecrMask & 0x2) != 0x0;
        double number;
        if (value instanceof Number) {
            number = ((Number)value).doubleValue();
        }
        else {
            number = toNumber(value);
            if (post) {
                value = wrapNumber(number);
            }
        }
        if ((incrDecrMask & 0x1) == 0x0) {
            ++number;
        }
        else {
            --number;
        }
        final Number result = wrapNumber(number);
        target.put(id, protoChainStart, (Object)result);
        if (post) {
            return value;
        }
        return result;
    }
    
    @Deprecated
    public static Object elemIncrDecr(final Object obj, final Object index, final Context cx, final int incrDecrMask) {
        return elemIncrDecr(obj, index, cx, getTopCallScope(cx), incrDecrMask);
    }
    
    public static Object elemIncrDecr(final Object obj, final Object index, final Context cx, final Scriptable scope, final int incrDecrMask) {
        Object value = getObjectElem(obj, index, cx, scope);
        final boolean post = (incrDecrMask & 0x2) != 0x0;
        double number;
        if (value instanceof Number) {
            number = ((Number)value).doubleValue();
        }
        else {
            number = toNumber(value);
            if (post) {
                value = wrapNumber(number);
            }
        }
        if ((incrDecrMask & 0x1) == 0x0) {
            ++number;
        }
        else {
            --number;
        }
        final Number result = wrapNumber(number);
        setObjectElem(obj, index, result, cx, scope);
        if (post) {
            return value;
        }
        return result;
    }
    
    @Deprecated
    public static Object refIncrDecr(final Ref ref, final Context cx, final int incrDecrMask) {
        return refIncrDecr(ref, cx, getTopCallScope(cx), incrDecrMask);
    }
    
    public static Object refIncrDecr(final Ref ref, final Context cx, final Scriptable scope, final int incrDecrMask) {
        Object value = ref.get(cx);
        final boolean post = (incrDecrMask & 0x2) != 0x0;
        double number;
        if (value instanceof Number) {
            number = ((Number)value).doubleValue();
        }
        else {
            number = toNumber(value);
            if (post) {
                value = wrapNumber(number);
            }
        }
        if ((incrDecrMask & 0x1) == 0x0) {
            ++number;
        }
        else {
            --number;
        }
        final Number result = wrapNumber(number);
        ref.set(cx, scope, (Object)result);
        if (post) {
            return value;
        }
        return result;
    }
    
    public static Object toPrimitive(final Object val) {
        return toPrimitive(val, null);
    }
    
    public static Object toPrimitive(final Object val, final Class<?> typeHint) {
        if (!(val instanceof Scriptable)) {
            return val;
        }
        final Scriptable s = (Scriptable)val;
        final Object result = s.getDefaultValue((Class)typeHint);
        if (result instanceof Scriptable && !isSymbol(result)) {
            throw typeError0("msg.bad.default.value");
        }
        return result;
    }
    
    public static boolean eq(final Object x, final Object y) {
        final Object opResult = applyOperator(x, y, "==", Context.getContext());
        if (opResult != UniqueTag.NOT_FOUND) {
            return toBoolean(opResult);
        }
        if (x == null || x == Undefined.instance) {
            if (y == null || y == Undefined.instance) {
                return true;
            }
            if (y instanceof ScriptableObject) {
                final Object test = ((ScriptableObject)y).equivalentValues(x);
                if (test != Scriptable.NOT_FOUND) {
                    return (boolean)test;
                }
            }
            return false;
        }
        else {
            if (x instanceof Number) {
                return eqNumber(((Number)x).doubleValue(), y);
            }
            if (x == y) {
                return true;
            }
            if (x instanceof CharSequence) {
                return eqString((CharSequence)x, y);
            }
            if (x instanceof Boolean) {
                final boolean b = (boolean)x;
                if (y instanceof Boolean) {
                    return b == (boolean)y;
                }
                if (y instanceof ScriptableObject) {
                    final Object test2 = ((ScriptableObject)y).equivalentValues(x);
                    if (test2 != Scriptable.NOT_FOUND) {
                        return (boolean)test2;
                    }
                }
                return eqNumber(b ? 1.0 : 0.0, y);
            }
            else {
                if (isSymbol(x)) {
                    return y instanceof Scriptable && isSymbol(y) && toPrimitive(x) == y;
                }
                if (!(x instanceof Scriptable) || isSymbol(x)) {
                    warnAboutNonJSObject(x);
                    return x == y;
                }
                if (isSymbol(y)) {
                    return toPrimitive(x) == y;
                }
                if (y instanceof Scriptable) {
                    if (x instanceof ScriptableObject) {
                        final Object test = ((ScriptableObject)x).equivalentValues(y);
                        if (test != Scriptable.NOT_FOUND) {
                            return (boolean)test;
                        }
                    }
                    if (y instanceof ScriptableObject) {
                        final Object test = ((ScriptableObject)y).equivalentValues(x);
                        if (test != Scriptable.NOT_FOUND) {
                            return (boolean)test;
                        }
                    }
                    if (x instanceof Wrapper && y instanceof Wrapper) {
                        final Object unwrappedX = ((Wrapper)x).unwrap();
                        final Object unwrappedY = ((Wrapper)y).unwrap();
                        return unwrappedX == unwrappedY || (isPrimitive(unwrappedX) && isPrimitive(unwrappedY) && eq(unwrappedX, unwrappedY));
                    }
                    return false;
                }
                else {
                    if (y instanceof Boolean) {
                        if (x instanceof ScriptableObject) {
                            final Object test = ((ScriptableObject)x).equivalentValues(y);
                            if (test != Scriptable.NOT_FOUND) {
                                return (boolean)test;
                            }
                        }
                        final double d = y ? 1.0 : 0.0;
                        return eqNumber(d, x);
                    }
                    if (y instanceof Number) {
                        return eqNumber(((Number)y).doubleValue(), x);
                    }
                    if (y instanceof CharSequence) {
                        return eqString((CharSequence)y, x);
                    }
                    return isSymbol(y) && toPrimitive(x) == y;
                }
            }
        }
    }
    
    public static boolean same(final Object x, final Object y) {
        if (!typeof(x).equals(typeof(y))) {
            return false;
        }
        if (x instanceof Number) {
            return (isNaN(x) && isNaN(y)) || x.equals(y);
        }
        return eq(x, y);
    }
    
    public static boolean sameZero(final Object x, final Object y) {
        if (!typeof(x).equals(typeof(y))) {
            return false;
        }
        if (!(x instanceof Number)) {
            return eq(x, y);
        }
        if (isNaN(x) && isNaN(y)) {
            return true;
        }
        final double dx = ((Number)x).doubleValue();
        if (y instanceof Number) {
            final double dy = ((Number)y).doubleValue();
            if ((dx == ScriptRuntime.negativeZero && dy == 0.0) || (dx == 0.0 && dy == ScriptRuntime.negativeZero)) {
                return true;
            }
        }
        return eqNumber(dx, y);
    }
    
    public static boolean isNaN(final Object n) {
        if (n == ScriptRuntime.NaNobj) {
            return true;
        }
        if (n instanceof Double) {
            final Double d = (Double)n;
            return d == ScriptRuntime.NaN || Double.isNaN(d);
        }
        if (n instanceof Float) {
            final Float f = (Float)n;
            return f == ScriptRuntime.NaN || Float.isNaN(f);
        }
        return false;
    }
    
    public static boolean isPrimitive(final Object obj) {
        return obj == null || obj == Undefined.instance || obj instanceof Number || obj instanceof String || obj instanceof Boolean;
    }
    
    static boolean eqNumber(final double x, Object y) {
        while (y != null && y != Undefined.instance) {
            if (y instanceof Number) {
                return x == ((Number)y).doubleValue();
            }
            if (y instanceof CharSequence) {
                return x == toNumber(y);
            }
            if (y instanceof Boolean) {
                return x == (y ? 1.0 : 0.0);
            }
            if (isSymbol(y)) {
                return false;
            }
            if (!(y instanceof Scriptable)) {
                warnAboutNonJSObject(y);
                return false;
            }
            if (y instanceof ScriptableObject) {
                final Object xval = wrapNumber(x);
                final Object test = ((ScriptableObject)y).equivalentValues(xval);
                if (test != Scriptable.NOT_FOUND) {
                    return (boolean)test;
                }
            }
            y = toPrimitive(y);
        }
        return false;
    }
    
    private static boolean eqString(final CharSequence x, Object y) {
        while (y != null && y != Undefined.instance) {
            if (y instanceof CharSequence) {
                final CharSequence c = (CharSequence)y;
                return x.length() == c.length() && x.toString().equals(c.toString());
            }
            if (y instanceof Number) {
                return toNumber(x.toString()) == ((Number)y).doubleValue();
            }
            if (y instanceof Boolean) {
                return toNumber(x.toString()) == (y ? 1.0 : 0.0);
            }
            if (isSymbol(y)) {
                return false;
            }
            if (!(y instanceof Scriptable)) {
                warnAboutNonJSObject(y);
                return false;
            }
            if (y instanceof ScriptableObject) {
                final Object test = ((ScriptableObject)y).equivalentValues((Object)x.toString());
                if (test != Scriptable.NOT_FOUND) {
                    return (boolean)test;
                }
            }
            y = toPrimitive(y);
        }
        return false;
    }
    
    public static boolean shallowEq(final Object x, final Object y) {
        if (x instanceof Symbol && y instanceof Symbol) {
            if (x == y) {
                return true;
            }
            if (x instanceof SymbolKey && y instanceof SymbolKey) {
                return false;
            }
            if (x instanceof NativeSymbol && y instanceof NativeSymbol) {
                return false;
            }
            if (x instanceof SymbolKey) {
                return x == ((NativeSymbol)y).getKey();
            }
            if (y instanceof SymbolKey) {
                return y == ((NativeSymbol)x).getKey();
            }
        }
        else if (x == y) {
            if (!(x instanceof Number)) {
                return true;
            }
            final double d = ((Number)x).doubleValue();
            return !Double.isNaN(d);
        }
        if (x == null || x == Undefined.instance || x == Undefined.SCRIPTABLE_UNDEFINED) {
            return (x == Undefined.instance && y == Undefined.SCRIPTABLE_UNDEFINED) || (x == Undefined.SCRIPTABLE_UNDEFINED && y == Undefined.instance);
        }
        if (x instanceof Number) {
            if (y instanceof Number) {
                return ((Number)x).doubleValue() == ((Number)y).doubleValue();
            }
        }
        else if (x instanceof CharSequence) {
            if (y instanceof CharSequence) {
                return x.toString().equals(y.toString());
            }
        }
        else if (x instanceof Boolean) {
            if (y instanceof Boolean) {
                return x.equals(y);
            }
        }
        else if (x instanceof Scriptable) {
            if (x instanceof Wrapper && y instanceof Wrapper) {
                return ((Wrapper)x).unwrap() == ((Wrapper)y).unwrap();
            }
        }
        else {
            warnAboutNonJSObject(x);
        }
        return false;
    }
    
    public static boolean instanceOf(final Object a, final Object b, final Context cx) {
        if (b instanceof Scriptable) {
            final Scriptable sb = (Scriptable)b;
            if (ScriptableObject.hasProperty(sb, (Symbol)SymbolKey.HAS_INSTANCE)) {
                final Object hasInstance = ScriptableObject.getProperty(sb, (Symbol)SymbolKey.HAS_INSTANCE);
                if (!(hasInstance instanceof Callable)) {
                    throw typeError1("msg.object.not.callable", toString(hasInstance));
                }
                final Object result = ((Callable)hasInstance).call(cx, getTopCallScope(cx), (Scriptable)b, new Object[] { a });
                return result != null && result != Undefined.instance && (!(result instanceof Boolean) || (boolean)result);
            }
        }
        if (!(b instanceof Scriptable)) {
            throw typeError0("msg.instanceof.not.object");
        }
        if (!(a instanceof Scriptable)) {
            return b instanceof NativeJavaClass && ((NativeJavaClass)b).getClassObject().isInstance(a);
        }
        return ((Scriptable)b).hasInstance((Scriptable)a);
    }
    
    public static boolean jsDelegatesTo(final Scriptable lhs, final Scriptable rhs) {
        for (Scriptable proto = lhs.getPrototype(); proto != null; proto = proto.getPrototype()) {
            if (proto.equals(rhs)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean in(final Object a, final Object b, final Context cx) {
        if (!(b instanceof Scriptable)) {
            throw typeError0("msg.in.not.object");
        }
        final Object opResult = applyOperator(b, a, "in", cx);
        if (opResult != UniqueTag.NOT_FOUND) {
            return toBoolean(opResult);
        }
        return hasObjectElem((Scriptable)b, a, cx);
    }
    
    public static boolean cmp_LT(Object val1, Object val2) {
        double d1;
        double d2;
        if (val1 instanceof Number && val2 instanceof Number) {
            d1 = ((Number)val1).doubleValue();
            d2 = ((Number)val2).doubleValue();
        }
        else {
            if (val1 instanceof Symbol || val2 instanceof Symbol) {
                throw typeError0("msg.compare.symbol");
            }
            if (val1 instanceof Scriptable) {
                val1 = ((Scriptable)val1).getDefaultValue((Class)ScriptRuntime.NumberClass);
            }
            if (val2 instanceof Scriptable) {
                val2 = ((Scriptable)val2).getDefaultValue((Class)ScriptRuntime.NumberClass);
            }
            if (val1 instanceof CharSequence && val2 instanceof CharSequence) {
                return val1.toString().compareTo(val2.toString()) < 0;
            }
            d1 = toNumber(val1);
            d2 = toNumber(val2);
        }
        return d1 < d2;
    }
    
    public static boolean cmp_LE(Object val1, Object val2) {
        double d1;
        double d2;
        if (val1 instanceof Number && val2 instanceof Number) {
            d1 = ((Number)val1).doubleValue();
            d2 = ((Number)val2).doubleValue();
        }
        else {
            if (val1 instanceof Symbol || val2 instanceof Symbol) {
                throw typeError0("msg.compare.symbol");
            }
            if (val1 instanceof Scriptable) {
                val1 = ((Scriptable)val1).getDefaultValue((Class)ScriptRuntime.NumberClass);
            }
            if (val2 instanceof Scriptable) {
                val2 = ((Scriptable)val2).getDefaultValue((Class)ScriptRuntime.NumberClass);
            }
            if (val1 instanceof CharSequence && val2 instanceof CharSequence) {
                return val1.toString().compareTo(val2.toString()) <= 0;
            }
            d1 = toNumber(val1);
            d2 = toNumber(val2);
        }
        return d1 <= d2;
    }
    
    public static ScriptableObject getGlobal(final Context cx) {
        final String GLOBAL_CLASS = "org.mozilla.javascript.tools.shell.Global";
        final Class<?> globalClass = (Class<?>)Kit.classOrNull("org.mozilla.javascript.tools.shell.Global");
        if (globalClass != null) {
            try {
                final Class<?>[] parm = (Class<?>[])new Class[] { ScriptRuntime.ContextClass };
                final Constructor<?> globalClassCtor = globalClass.getConstructor(parm);
                final Object[] arg = { cx };
                return (ScriptableObject)globalClassCtor.newInstance(arg);
            }
            catch (RuntimeException e) {
                throw e;
            }
            catch (Exception ex) {}
        }
        return (ScriptableObject)new ImporterTopLevel(cx);
    }
    
    public static boolean hasTopCall(final Context cx) {
        return cx.topCallScope != null;
    }
    
    public static Scriptable getTopCallScope(final Context cx) {
        final Scriptable scope = cx.topCallScope;
        if (scope == null) {
            throw new IllegalStateException();
        }
        return scope;
    }
    
    @Deprecated
    public static Object doTopCall(final Callable callable, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return doTopCall(callable, cx, scope, thisObj, args, cx.isTopLevelStrict);
    }
    
    public static Object doTopCall(final Callable callable, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args, final boolean isTopLevelStrict) {
        if (scope == null) {
            throw new IllegalArgumentException();
        }
        if (cx.topCallScope != null) {
            throw new IllegalStateException();
        }
        cx.topCallScope = ScriptableObject.getTopLevelScope(scope);
        cx.useDynamicScope = cx.hasFeature(6);
        final boolean previousTopLevelStrict = cx.isTopLevelStrict;
        cx.isTopLevelStrict = isTopLevelStrict;
        final ContextFactory f = cx.getFactory();
        Object result;
        try {
            result = f.doTopCall(callable, cx, scope, thisObj, args);
        }
        finally {
            cx.topCallScope = null;
            cx.isTopLevelStrict = previousTopLevelStrict;
            if (cx.currentActivationCall != null) {
                throw new IllegalStateException();
            }
        }
        return result;
    }
    
    static Scriptable checkDynamicScope(final Scriptable possibleDynamicScope, final Scriptable staticTopScope) {
        if (possibleDynamicScope == staticTopScope) {
            return possibleDynamicScope;
        }
        Scriptable proto = possibleDynamicScope;
        do {
            proto = proto.getPrototype();
            if (proto == staticTopScope) {
                return possibleDynamicScope;
            }
        } while (proto != null);
        return staticTopScope;
    }
    
    public static void addInstructionCount(final Context cx, final int instructionsToAdd) {
        cx.instructionCount += instructionsToAdd;
        if (cx.instructionCount > cx.instructionThreshold) {
            cx.observeInstructionCount(cx.instructionCount);
            cx.instructionCount = 0;
        }
    }
    
    public static void initScript(final NativeFunction funObj, final Scriptable thisObj, final Context cx, final Scriptable scope) {
        if (cx.topCallScope == null) {
            throw new IllegalStateException();
        }
        final int varCount = funObj.getParamAndVarCount();
        if (varCount != 0) {
            Scriptable varScope;
            for (varScope = scope; varScope instanceof NativeWith; varScope = varScope.getParentScope()) {}
            int i = varCount;
            while (i-- != 0) {
                final String name = funObj.getParamOrVarName(i);
                final boolean isConst = funObj.getParamOrVarConst(i);
                final boolean isLexical = funObj.isVarLexical(i);
                if (!ScriptableObject.hasProperty(scope, name)) {
                    if (isConst) {
                        varScope.declareConst(name, varScope);
                    }
                    else if (isLexical) {
                        varScope.declare(name, varScope);
                    }
                    else {
                        varScope.put(name, varScope, Undefined.instance);
                    }
                }
                else {
                    ScriptableObject.redefineProperty(scope, name, isConst);
                }
            }
        }
    }
    
    public static Scriptable createFunctionActivation(final NativeFunction funObj, final Scriptable scope, final Object[] args, final boolean isStrict, final boolean syncArgumentsObj) {
        return (Scriptable)new NativeCall(funObj, scope, args, args, false, isStrict, syncArgumentsObj);
    }
    
    public static Scriptable createFunctionActivation(final NativeFunction funObj, final Scriptable scope, final Object[] callArgs, final Object[] effectiveArgs, final boolean isStrict, final boolean syncArgumentsObj) {
        return (Scriptable)new NativeCall(funObj, scope, callArgs, effectiveArgs, false, isStrict, syncArgumentsObj);
    }
    
    public static Scriptable createArrowFunctionActivation(final NativeFunction funObj, final Scriptable scope, final Object[] args, final boolean isStrict, final boolean syncArgumentsObj) {
        return (Scriptable)new NativeCall(funObj, scope, args, args, true, isStrict, syncArgumentsObj);
    }
    
    public static Scriptable createArrowFunctionActivation(final NativeFunction funObj, final Scriptable scope, final Object[] callArgs, final Object[] effectiveArgs, final boolean isStrict, final boolean syncArgumentsObj) {
        return (Scriptable)new NativeCall(funObj, scope, callArgs, effectiveArgs, true, isStrict, syncArgumentsObj);
    }
    
    public static void enterActivationFunction(final Context cx, final Scriptable scope) {
        if (cx.topCallScope == null) {
            throw new IllegalStateException();
        }
        final NativeCall call = (NativeCall)scope;
        call.parentActivationCall = cx.currentActivationCall;
        (cx.currentActivationCall = call).defineAttributesForArguments();
    }
    
    public static void exitActivationFunction(final Context cx) {
        final NativeCall call = cx.currentActivationCall;
        cx.currentActivationCall = call.parentActivationCall;
        call.parentActivationCall = null;
    }
    
    static NativeCall findFunctionActivation(final Context cx, final Function f) {
        for (NativeCall call = cx.currentActivationCall; call != null; call = call.parentActivationCall) {
            if (call.function == f) {
                return call;
            }
        }
        return null;
    }
    
    public static Scriptable newCatchScope(final Throwable t, final Scriptable lastCatchScope, final String exceptionName, final Context cx, final Scriptable scope) {
        boolean cacheObj;
        Object obj;
        if (t instanceof JavaScriptException) {
            cacheObj = false;
            obj = ((JavaScriptException)t).getValue();
        }
        else {
            cacheObj = true;
            if (lastCatchScope != null) {
                final NativeObject last = (NativeObject)lastCatchScope;
                obj = last.getAssociatedValue((Object)t);
                if (obj == null) {
                    Kit.codeBug();
                }
            }
            else {
                Throwable javaException = null;
                RhinoException re;
                TopLevel.NativeErrors type;
                String errorMsg;
                if (t instanceof EcmaError) {
                    final EcmaError ee = (EcmaError)(re = (RhinoException)t);
                    type = TopLevel.NativeErrors.valueOf(ee.getName());
                    errorMsg = ee.getErrorMessage();
                }
                else if (t instanceof WrappedException) {
                    final WrappedException we = (WrappedException)(re = (RhinoException)t);
                    javaException = we.getWrappedException();
                    type = TopLevel.NativeErrors.JavaException;
                    errorMsg = javaException.getClass().getName() + ": " + javaException.getMessage();
                }
                else if (t instanceof EvaluatorException) {
                    final EvaluatorException ee2 = (EvaluatorException)(re = (RhinoException)t);
                    type = TopLevel.NativeErrors.InternalError;
                    errorMsg = ee2.getMessage();
                }
                else {
                    if (!cx.hasFeature(12)) {
                        throw Kit.codeBug();
                    }
                    re = (RhinoException)new WrappedException(t);
                    type = TopLevel.NativeErrors.JavaException;
                    errorMsg = t.toString();
                }
                String sourceUri = re.sourceName();
                if (sourceUri == null) {
                    sourceUri = "";
                }
                final int line = re.lineNumber();
                Object[] args;
                if (line > 0) {
                    args = new Object[] { errorMsg, sourceUri, line };
                }
                else {
                    args = new Object[] { errorMsg, sourceUri };
                }
                final Scriptable errorObject = newNativeError(cx, scope, type, args);
                if (errorObject instanceof NativeError) {
                    ((NativeError)errorObject).setStackProvider(re);
                }
                if (javaException != null && isVisible(cx, javaException)) {
                    final Object wrap = cx.getWrapFactory().wrap(cx, scope, javaException, null);
                    ScriptableObject.defineProperty(errorObject, "javaException", wrap, 7);
                }
                if (isVisible(cx, re)) {
                    final Object wrap = cx.getWrapFactory().wrap(cx, scope, re, null);
                    ScriptableObject.defineProperty(errorObject, "rhinoException", wrap, 7);
                }
                obj = errorObject;
            }
        }
        final NativeObject catchScopeObject = new NativeObject();
        catchScopeObject.defineProperty(exceptionName, obj, 4);
        if (isVisible(cx, t)) {
            catchScopeObject.defineProperty("__exception__", Context.javaToJS((Object)t, scope), 6);
        }
        if (cacheObj) {
            catchScopeObject.associateValue((Object)t, obj);
        }
        return (Scriptable)catchScopeObject;
    }
    
    public static Scriptable wrapException(final Throwable t, final Scriptable scope, final Context cx) {
        Throwable javaException = null;
        RhinoException re;
        String errorName;
        String errorMsg;
        if (t instanceof EcmaError) {
            final EcmaError ee = (EcmaError)(re = (RhinoException)t);
            errorName = ee.getName();
            errorMsg = ee.getErrorMessage();
        }
        else if (t instanceof WrappedException) {
            final WrappedException we = (WrappedException)(re = (RhinoException)t);
            javaException = we.getWrappedException();
            errorName = "JavaException";
            errorMsg = javaException.getClass().getName() + ": " + javaException.getMessage();
        }
        else if (t instanceof EvaluatorException) {
            final EvaluatorException ee2 = (EvaluatorException)(re = (RhinoException)t);
            errorName = "InternalError";
            errorMsg = ee2.getMessage();
        }
        else {
            if (!cx.hasFeature(12)) {
                throw Kit.codeBug();
            }
            re = (RhinoException)new WrappedException(t);
            errorName = "JavaException";
            errorMsg = t.toString();
        }
        String sourceUri = re.sourceName();
        if (sourceUri == null) {
            sourceUri = "";
        }
        final int line = re.lineNumber();
        Object[] args;
        if (line > 0) {
            args = new Object[] { errorMsg, sourceUri, line };
        }
        else {
            args = new Object[] { errorMsg, sourceUri };
        }
        final Scriptable errorObject = cx.newObject(scope, errorName, args);
        ScriptableObject.putProperty(errorObject, "name", (Object)errorName);
        if (errorObject instanceof NativeError) {
            ((NativeError)errorObject).setStackProvider(re);
        }
        if (javaException != null && isVisible(cx, javaException)) {
            final Object wrap = cx.getWrapFactory().wrap(cx, scope, javaException, null);
            ScriptableObject.defineProperty(errorObject, "javaException", wrap, 7);
        }
        if (isVisible(cx, re)) {
            final Object wrap = cx.getWrapFactory().wrap(cx, scope, re, null);
            ScriptableObject.defineProperty(errorObject, "rhinoException", wrap, 7);
        }
        return errorObject;
    }
    
    private static boolean isVisible(final Context cx, final Object obj) {
        final ClassShutter shutter = cx.getClassShutter();
        return shutter == null || shutter.visibleToScripts(obj.getClass().getName());
    }
    
    public static Scriptable enterWith(final Object obj, final Context cx, final Scriptable scope) {
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw typeError1("msg.undef.with", toString(obj));
        }
        return (Scriptable)new NativeWith(scope, sobj);
    }
    
    public static Scriptable leaveWith(final Scriptable scope) {
        final NativeWith nw = (NativeWith)scope;
        return nw.getParentScope();
    }
    
    public static void setFunctionProtoAndParent(final BaseFunction fn, final Scriptable scope) {
        fn.setParentScope(scope);
        fn.setPrototype(ScriptableObject.getFunctionPrototype(scope));
    }
    
    public static void setObjectProtoAndParent(final ScriptableObject object, Scriptable scope) {
        scope = ScriptableObject.getTopLevelScope(scope);
        object.setParentScope(scope);
        final Scriptable proto = ScriptableObject.getClassPrototype(scope, object.getClassName());
        object.setPrototype(proto);
    }
    
    public static void setBuiltinProtoAndParent(final ScriptableObject object, Scriptable scope, final TopLevel.Builtins type) {
        scope = ScriptableObject.getTopLevelScope(scope);
        object.setParentScope(scope);
        object.setPrototype(TopLevel.getBuiltinPrototype(scope, type));
    }
    
    public static void initFunction(final Context cx, Scriptable scope, final NativeFunction function, final int type, final boolean fromEvalCode) {
        if (type == 1) {
            final String name = function.getFunctionName();
            if (name != null && name.length() != 0) {
                if (!fromEvalCode) {
                    ScriptableObject.defineProperty(scope, name, (Object)function, 4);
                }
                else {
                    scope.put(name, scope, (Object)function);
                }
            }
        }
        else {
            if (type != 3) {
                throw Kit.codeBug();
            }
            final String name = function.getFunctionName();
            if (name != null && name.length() != 0) {
                while (scope instanceof NativeWith) {
                    scope = scope.getParentScope();
                }
                scope.put(name, scope, (Object)function);
            }
        }
    }
    
    public static Scriptable newArrayLiteral(final Object[] objects, final int[] skipIndices, final Context cx, final Scriptable scope) {
        final int SKIP_DENSITY = 2;
        final int count = objects.length;
        int skipCount = 0;
        if (skipIndices != null) {
            skipCount = skipIndices.length;
        }
        final int length = count + skipCount;
        if (length > 1 && skipCount * 2 < length) {
            Object[] sparse;
            if (skipCount == 0) {
                sparse = objects;
            }
            else {
                sparse = new Object[length];
                int skip = 0;
                int i = 0;
                int j = 0;
                while (i != length) {
                    if (skip != skipCount && skipIndices[skip] == i) {
                        sparse[i] = Scriptable.NOT_FOUND;
                        ++skip;
                    }
                    else {
                        sparse[i] = objects[j];
                        ++j;
                    }
                    ++i;
                }
            }
            return (Scriptable)cx.newArray(scope, sparse);
        }
        final Scriptable array = cx.newArray(scope, length);
        int skip = 0;
        int i = 0;
        int j = 0;
        while (i != length) {
            if (skip != skipCount && skipIndices[skip] == i) {
                ++skip;
            }
            else {
                array.put(i, array, objects[j]);
                ++j;
            }
            ++i;
        }
        return array;
    }
    
    @Deprecated
    public static Scriptable newObjectLiteral(final Object[] propertyIds, final Object[] propertyValues, final Context cx, final Scriptable scope) {
        return newObjectLiteral(propertyIds, propertyValues, null, cx, scope);
    }
    
    public static Scriptable newObjectLiteral(final Object[] propertyIds, final Object[] propertyValues, final int[] getterSetters, final Context cx, final Scriptable scope) {
        final Scriptable object = (Scriptable)cx.newObject(scope);
        for (int i = 0, end = propertyIds.length; i != end; ++i) {
            final Object id = propertyIds[i];
            if (id == null) {
                addSpreadObject(object, ScriptableObject.ensureScriptable(propertyValues[i]));
            }
            else {
                final int getterSetter = (getterSetters == null) ? 0 : getterSetters[i];
                final Object value = propertyValues[i];
                if (id instanceof String) {
                    if (getterSetter == 0) {
                        if (isSpecialProperty((String)id)) {
                            final Ref ref = specialRef(object, (String)id, cx, scope);
                            ref.set(cx, scope, value);
                        }
                        else {
                            setFunctionNameIfApplicable(value, id);
                            object.put((String)id, object, value);
                        }
                    }
                    else {
                        final ScriptableObject so = (ScriptableObject)object;
                        final Callable getterOrSetter = (Callable)value;
                        final boolean isSetter = getterSetter == 1;
                        setFunctionNameIfApplicable(value, (isSetter ? "set " : "get ") + id);
                        so.setGetterOrSetter((String)id, 0, getterOrSetter, isSetter);
                    }
                }
                else if (id instanceof Integer) {
                    final int index = (int)id;
                    if (getterSetter == 0) {
                        setFunctionNameIfApplicable(value, String.valueOf(index));
                        object.put(index, object, value);
                    }
                    else {
                        final ScriptableObject so2 = (ScriptableObject)object;
                        final Callable getterOrSetter2 = (Callable)value;
                        final boolean isSetter2 = getterSetter == 1;
                        setFunctionNameIfApplicable(value, (isSetter2 ? "set " : "get ") + index);
                        so2.setGetterOrSetter((String)null, index, getterOrSetter2, isSetter2);
                    }
                }
                else {
                    if (!isSymbol(id)) {
                        throw throwError(cx, scope, "msg.object.invalid.key.type");
                    }
                    final Symbol symbol = (Symbol)id;
                    if (getterSetter == 0) {
                        setFunctionNameIfApplicable(value, symbol.toSymbolString());
                        ScriptableObject.putProperty(object, symbol, value);
                    }
                    else {
                        final ScriptableObject so2 = (ScriptableObject)object;
                        final Callable getterOrSetter2 = (Callable)value;
                        final boolean isSetter2 = getterSetter == 1;
                        setFunctionNameIfApplicable(value, (isSetter2 ? "set " : "get ") + symbol.toSymbolString());
                        so2.setGetterOrSetter(symbol, 0, getterOrSetter2, isSetter2);
                    }
                }
            }
        }
        return object;
    }
    
    private static void setFunctionNameIfApplicable(final Object fn, final Object name) {
        if (fn instanceof BaseFunction && ((BaseFunction)fn).getFunctionName().equals("") && ((BaseFunction)fn).getForcedName() == null) {
            ((BaseFunction)fn).setForcedName(name);
        }
    }
    
    public static boolean isArray(final Object obj) {
        if (obj instanceof NativeProxy) {
            return isArray(((NativeProxy)obj).getTarget());
        }
        return obj instanceof NativeArray;
    }
    
    public static NativeArray getArray(final Object obj) {
        if (!isArray(obj)) {
            throw Kit.codeBug();
        }
        if (obj instanceof NativeProxy) {
            return getArray(((NativeProxy)obj).getTarget());
        }
        return (NativeArray)obj;
    }
    
    public static Scriptable unwrapProxy(Scriptable object) {
        if (object == null) {
            return null;
        }
        while (object instanceof NativeProxy) {
            object = (Scriptable)((NativeProxy)object).getTarget();
        }
        return object;
    }
    
    public static Object[] getArrayElements(final Scriptable object) {
        final long longLen = NativeArray.getLengthProperty(object, false);
        if (longLen > 2147483647L) {
            throw new IllegalArgumentException();
        }
        final int len = (int)longLen;
        if (len == 0) {
            return ScriptRuntime.emptyArgs;
        }
        final Object[] result = new Object[len];
        for (int i = 0; i < len; ++i) {
            final Object elem = ScriptableObject.getProperty(object, i);
            result[i] = ((elem == Scriptable.NOT_FOUND) ? Undefined.instance : elem);
        }
        return result;
    }
    
    static void checkDeprecated(final Context cx, final String name) {
        final int version = cx.getLanguageVersion();
        if (version >= 140 || version == 0) {
            final String msg = getMessage1("msg.deprec.ctor", name);
            if (version != 0) {
                throw Context.reportRuntimeError(msg);
            }
            Context.reportWarning(msg);
        }
    }
    
    public static String getMessage0(final String messageId) {
        return getMessage(messageId, null);
    }
    
    public static String getMessage1(final String messageId, final Object arg1) {
        final Object[] arguments = { arg1 };
        return getMessage(messageId, arguments);
    }
    
    public static String getMessage2(final String messageId, final Object arg1, final Object arg2) {
        final Object[] arguments = { arg1, arg2 };
        return getMessage(messageId, arguments);
    }
    
    public static String getMessage3(final String messageId, final Object arg1, final Object arg2, final Object arg3) {
        final Object[] arguments = { arg1, arg2, arg3 };
        return getMessage(messageId, arguments);
    }
    
    public static String getMessage4(final String messageId, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        final Object[] arguments = { arg1, arg2, arg3, arg4 };
        return getMessage(messageId, arguments);
    }
    
    public static String getMessage(final String messageId, final Object[] arguments) {
        return ScriptRuntime.messageProvider.getMessage(messageId, arguments);
    }
    
    public static EcmaError constructError(final String error, final String message) {
        final int[] linep = { 0 };
        final String filename = Context.getSourcePositionFromStack(linep);
        return constructError(error, message, filename, linep[0], null, 0);
    }
    
    public static EcmaError constructError(final String error, final String message, final int lineNumberDelta) {
        final int[] linep = { 0 };
        final String filename = Context.getSourcePositionFromStack(linep);
        if (linep[0] != 0) {
            final int[] array = linep;
            final int n = 0;
            array[n] += lineNumberDelta;
        }
        return constructError(error, message, filename, linep[0], null, 0);
    }
    
    public static EcmaError constructError(final String error, final String message, final String sourceName, final int lineNumber, final String lineSource, final int columnNumber) {
        return new EcmaError(error, message, sourceName, lineNumber, lineSource, columnNumber);
    }
    
    public static EcmaError rangeError(final String message) {
        return constructError("RangeError", message);
    }
    
    public static EcmaError typeError(final String message) {
        return constructError("TypeError", message);
    }
    
    public static EcmaError typeError0(final String messageId) {
        final String msg = getMessage0(messageId);
        return typeError(msg);
    }
    
    public static EcmaError typeError1(final String messageId, final Object arg1) {
        final String msg = getMessage1(messageId, arg1);
        return typeError(msg);
    }
    
    public static EcmaError typeError2(final String messageId, final Object arg1, final Object arg2) {
        final String msg = getMessage2(messageId, arg1, arg2);
        return typeError(msg);
    }
    
    public static EcmaError typeError3(final String messageId, final String arg1, final String arg2, final String arg3) {
        final String msg = getMessage3(messageId, arg1, arg2, arg3);
        return typeError(msg);
    }
    
    public static EcmaError typeError4(final String messageId, final String arg1, final String arg2, final String arg3, final String arg4) {
        final String msg = getMessage4(messageId, arg1, arg2, arg3, arg4);
        return typeError(msg);
    }
    
    public static RuntimeException undefReadError(final Object object, final Object id) {
        return (RuntimeException)typeError2("msg.undef.prop.read", toString(object), toString(id));
    }
    
    public static RuntimeException undefCallError(final Object object, final Object id) {
        return (RuntimeException)typeError2("msg.undef.method.call", toString(object), toString(id));
    }
    
    public static RuntimeException undefWriteError(final Object object, final Object id, final Object value) {
        return (RuntimeException)typeError3("msg.undef.prop.write", toString(object), toString(id), toString(value));
    }
    
    private static RuntimeException undefDeleteError(final Object object, final Object id) {
        throw typeError2("msg.undef.prop.delete", toString(object), toString(id));
    }
    
    public static RuntimeException notFoundError(final Scriptable object, final String property) {
        final String msg = getMessage1("msg.is.not.defined", property);
        throw constructError("ReferenceError", msg);
    }
    
    public static RuntimeException notFunctionError(final Object value) {
        return notFunctionError(value, value);
    }
    
    public static RuntimeException notFunctionError(final Object value, final Object messageHelper) {
        final String msg = (messageHelper == null) ? "null" : messageHelper.toString();
        if (value == Scriptable.NOT_FOUND) {
            return (RuntimeException)typeError1("msg.function.not.found", msg);
        }
        return (RuntimeException)typeError2("msg.isnt.function.it.is", msg, typeof(value));
    }
    
    public static RuntimeException notFunctionError(final Object obj, final Object value, final String propertyName) {
        String objString = toString(obj);
        if (obj instanceof NativeFunction) {
            final int paren = objString.indexOf(41);
            final int curly = objString.indexOf(123, paren);
            if (curly > -1) {
                objString = objString.substring(0, curly + 1) + "...}";
            }
        }
        if (value == Scriptable.NOT_FOUND) {
            return (RuntimeException)typeError2("msg.function.not.found.in", propertyName, objString);
        }
        return (RuntimeException)typeError3("msg.isnt.function.in", propertyName, objString, typeof(value));
    }
    
    private static RuntimeException notXmlError(final Object value) {
        throw typeError1("msg.isnt.xml.object", toString(value));
    }
    
    private static void warnAboutNonJSObject(final Object nonJSObject) {
        final String omitParam = getMessage0("params.omit.non.js.object.warning");
        if (!"true".equals(omitParam)) {
            final String message = getMessage2("msg.non.js.object.warning", nonJSObject, nonJSObject.getClass().getName());
            Context.reportWarning(message);
            System.err.println(message);
        }
    }
    
    public static RegExpProxy getRegExpProxy(final Context cx) {
        return cx.getRegExpProxy();
    }
    
    public static void setRegExpProxy(final Context cx, final RegExpProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        cx.regExpProxy = proxy;
    }
    
    public static RegExpProxy checkRegExpProxy(final Context cx) {
        final RegExpProxy result = getRegExpProxy(cx);
        if (result == null) {
            throw Context.reportRuntimeError0("msg.no.regexp");
        }
        return result;
    }
    
    public static Scriptable wrapRegExp(final Context cx, final Scriptable scope, final Object compiled) {
        return cx.getRegExpProxy().wrapRegExp(cx, scope, compiled);
    }
    
    private static void storeIndexResult(final Context cx, final int index) {
        cx.scratchIndex = index;
    }
    
    static int lastIndexResult(final Context cx) {
        return cx.scratchIndex;
    }
    
    public static void storeUint32Result(final Context cx, final long value) {
        if (value >>> 32 != 0L) {
            throw new IllegalArgumentException();
        }
        cx.scratchUint32 = value;
    }
    
    public static long lastUint32Result(final Context cx) {
        final long value = cx.scratchUint32;
        if (value >>> 32 != 0L) {
            throw new IllegalStateException();
        }
        return value;
    }
    
    private static void storeScriptable(final Context cx, final Scriptable value) {
        if (cx.scratchScriptable != null) {
            throw new IllegalStateException();
        }
        cx.scratchScriptable = value;
    }
    
    public static Scriptable lastStoredScriptable(final Context cx) {
        final Scriptable result = cx.scratchScriptable;
        cx.scratchScriptable = null;
        return result;
    }
    
    static String makeUrlForGeneratedScript(final boolean isEval, final String masterScriptUrl, final int masterScriptLine) {
        if (isEval) {
            return masterScriptUrl + '#' + masterScriptLine + "(eval)";
        }
        return masterScriptUrl + '#' + masterScriptLine + "(Function)";
    }
    
    static boolean isGeneratedScript(final String sourceUrl) {
        return sourceUrl.indexOf("(eval)") >= 0 || sourceUrl.indexOf("(Function)") >= 0;
    }
    
    public static boolean isSymbol(final Object obj) {
        return (obj instanceof NativeSymbol && ((NativeSymbol)obj).isSymbol()) || obj instanceof SymbolKey;
    }
    
    public static boolean isNullOrUndefined(final Object prop) {
        return prop == null || prop == Undefined.instance || prop == UniqueTag.NOT_FOUND;
    }
    
    public static Object optionalGetObjectProp(final Object obj, final String property, final Context cx, final Scriptable scope, final boolean isPrivate) {
        if (isPrivate) {
            throw Kit.codeBug();
        }
        if (isNullOrUndefined(obj)) {
            return Undefined.instance;
        }
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefReadError(obj, property);
        }
        return optionalGetObjectProp(sobj, property, cx, false);
    }
    
    public static Object optionalGetObjectProp(final Scriptable obj, final String property, final Context cx, final boolean isPrivate) {
        if (isPrivate) {
            throw Kit.codeBug();
        }
        if (isNullOrUndefined(obj)) {
            return Undefined.instance;
        }
        return getObjectProp(obj, property, cx, false);
    }
    
    public static Object optionalGetObjectIndex(final Object obj, final double dblIndex, final Context cx) {
        if (isNullOrUndefined(obj)) {
            return Undefined.instance;
        }
        return getObjectIndex(obj, dblIndex, cx, getTopCallScope(cx));
    }
    
    public static Object optionalGetObjectElem(final Object obj, final Object elem, final Context cx, final Scriptable scope) {
        if (isNullOrUndefined(obj)) {
            return Undefined.instance;
        }
        final Scriptable sobj = toObjectOrNull(cx, obj, scope);
        if (sobj == null) {
            throw undefReadError(obj, elem);
        }
        return getObjectElem(sobj, elem, cx);
    }
    
    private static RuntimeException errorWithClassName(final String msg, final Object val) {
        return (RuntimeException)Context.reportRuntimeError1(msg, (Object)val.getClass().getName());
    }
    
    public static JavaScriptException throwError(final Context cx, final Scriptable scope, final String message) {
        final int[] linep = { 0 };
        final String filename = Context.getSourcePositionFromStack(linep);
        final Scriptable error = newBuiltinObject(cx, scope, TopLevel.Builtins.Error, new Object[] { message, filename, linep[0] });
        return new JavaScriptException((Object)error, filename, linep[0]);
    }
    
    public static JavaScriptException throwCustomError(final Context cx, final Scriptable scope, final String constructorName, final String message) {
        final int[] linep = { 0 };
        final String filename = Context.getSourcePositionFromStack(linep);
        final Scriptable error = cx.newObject(scope, constructorName, new Object[] { message, filename, linep[0] });
        return new JavaScriptException((Object)error, filename, linep[0]);
    }
    
    static {
        BooleanClass = Kit.classOrNull("java.lang.Boolean");
        ByteClass = Kit.classOrNull("java.lang.Byte");
        CharacterClass = Kit.classOrNull("java.lang.Character");
        ClassClass = Kit.classOrNull("java.lang.Class");
        DoubleClass = Kit.classOrNull("java.lang.Double");
        FloatClass = Kit.classOrNull("java.lang.Float");
        IntegerClass = Kit.classOrNull("java.lang.Integer");
        LongClass = Kit.classOrNull("java.lang.Long");
        NumberClass = Kit.classOrNull("java.lang.Number");
        ObjectClass = Kit.classOrNull("java.lang.Object");
        ShortClass = Kit.classOrNull("java.lang.Short");
        StringClass = Kit.classOrNull("java.lang.String");
        DateClass = Kit.classOrNull("java.util.Date");
        ContextClass = Kit.classOrNull("org.mozilla.javascript.Context");
        ContextFactoryClass = Kit.classOrNull("org.mozilla.javascript.ContextFactory");
        FunctionClass = Kit.classOrNull("org.mozilla.javascript.Function");
        ScriptableObjectClass = Kit.classOrNull("org.mozilla.javascript.ScriptableObject");
        ScriptableClass = Scriptable.class;
        ScriptRuntime.ROOT_LOCALE = new Locale("");
        LIBRARY_SCOPE_KEY = "LIBRARY_SCOPE";
        NaN = Double.longBitsToDouble(9221120237041090560L);
        negativeZero = Double.longBitsToDouble(Long.MIN_VALUE);
        NaNobj = new Double(ScriptRuntime.NaN);
        SUPER_KEY = new Object();
        ScriptRuntime.messageProvider = new DefaultMessageProvider();
        emptyArgs = new Object[0];
        emptyStrings = new String[0];
    }
    
    private static class IdEnumeration implements Serializable
    {
        private static final long serialVersionUID = 1L;
        Scriptable obj;
        Object[] ids;
        ObjToIntMap used;
        Object currentId;
        int index;
        int enumType;
        boolean enumNumbers;
        Scriptable iterator;
    }
    
    private static class DefaultMessageProvider implements MessageProvider
    {
        @Override
        public String getMessage(final String messageId, final Object[] arguments) {
            final String defaultResource = "Messages";
            final Context cx = Context.getCurrentContext();
            final Locale locale = (cx != null) ? cx.getLocale() : Locale.getDefault();
            final ResourceBundle rb = ResourceBundle.getBundle("Messages", locale);
            String formatString;
            try {
                formatString = rb.getString(messageId);
            }
            catch (MissingResourceException mre) {
                throw new RuntimeException("no message resource found for message property " + messageId);
            }
            final MessageFormat formatter = new MessageFormat(formatString);
            return formatter.format(arguments);
        }
    }
    
    public interface MessageProvider
    {
        String getMessage(final String p0, final Object[] p1);
    }
}
