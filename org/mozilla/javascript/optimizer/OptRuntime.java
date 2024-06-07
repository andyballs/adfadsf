//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.*;
import org.mozilla.javascript.generator.*;

public final class OptRuntime extends ScriptRuntime
{
    public static final Double zeroObj;
    public static final Double oneObj;
    public static final Double minusOneObj;
    
    public static Object call0(final Callable fun, final Scriptable thisObj, final Context cx, final Scriptable scope) {
        return fun.call(cx, scope, thisObj, ScriptRuntime.emptyArgs);
    }
    
    public static Object call1(final Callable fun, final Scriptable thisObj, final Object arg0, final Context cx, final Scriptable scope) {
        return fun.call(cx, scope, thisObj, new Object[] { arg0 });
    }
    
    public static Object call2(final Callable fun, final Scriptable thisObj, final Object arg0, final Object arg1, final Context cx, final Scriptable scope) {
        return fun.call(cx, scope, thisObj, new Object[] { arg0, arg1 });
    }
    
    public static Object callN(final Callable fun, final Scriptable thisObj, final Object[] args, final Context cx, final Scriptable scope) {
        return fun.call(cx, scope, thisObj, args);
    }
    
    public static Object optionalCall0(final Object fun, final Context cx, final Scriptable scope) {
        return optionalCallN(fun, ScriptRuntime.emptyArgs, cx, scope);
    }
    
    public static Object optionalCallN(final Object fun, final Object[] args, final Context cx, final Scriptable scope) {
        if (ScriptRuntime.isNullOrUndefined(fun)) {
            return Undefined.instance;
        }
        return callN(ScriptRuntime.getValueFunctionAndThis(fun, cx), ScriptRuntime.lastStoredScriptable(cx), args, cx, scope);
    }
    
    public static Object callName(final Object[] args, final String name, final Context cx, final Scriptable scope) {
        final Callable f = ScriptRuntime.getNameFunctionAndThis(name, cx, scope);
        final Scriptable thisObj = ScriptRuntime.lastStoredScriptable(cx);
        return f.call(cx, scope, thisObj, args);
    }
    
    public static Object callName0(final String name, final Context cx, final Scriptable scope) {
        final Callable f = ScriptRuntime.getNameFunctionAndThis(name, cx, scope);
        final Scriptable thisObj = ScriptRuntime.lastStoredScriptable(cx);
        return f.call(cx, scope, thisObj, ScriptRuntime.emptyArgs);
    }
    
    public static Object callProp0(final Object value, final String property, final Context cx, final Scriptable scope) {
        final Callable f = ScriptRuntime.getPropFunctionAndThis(value, property, cx, scope, false);
        final Scriptable thisObj = ScriptRuntime.lastStoredScriptable(cx);
        return f.call(cx, scope, thisObj, ScriptRuntime.emptyArgs);
    }
    
    public static Object privateCallProp0(final Object value, final String property, final Context cx, final Scriptable scope) {
        final Callable f = ScriptRuntime.getPropFunctionAndThis(value, property, cx, scope, true);
        final Scriptable thisObj = ScriptRuntime.lastStoredScriptable(cx);
        return f.call(cx, scope, thisObj, ScriptRuntime.emptyArgs);
    }
    
    public static Object optionalAccessCallProp0(final Object value, final String property, final Context cx, final Scriptable scope) {
        return optionalAccessCallN(value, property, ScriptRuntime.emptyArgs, cx, scope);
    }
    
    public static Object optionalCallProp0(final Object value, final String property, final Context cx, final Scriptable scope) {
        return optionalCallPropN(value, property, ScriptRuntime.emptyArgs, cx, scope);
    }
    
    public static Object optionalCallPropN(final Object value, final String property, final Object[] args, final Context cx, final Scriptable scope) {
        final Scriptable thisObj = ScriptRuntime.toObjectOrNull(cx, value, scope);
        if (thisObj == null) {
            throw ScriptRuntime.undefCallError(value, property);
        }
        final Object prop = ScriptableObject.getProperty(thisObj, property);
        if (ScriptRuntime.isNullOrUndefined(prop)) {
            return Undefined.instance;
        }
        if (!(prop instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(thisObj, prop, property);
        }
        return ((Callable)prop).call(cx, scope, thisObj, args);
    }
    
    public static Object optionalAccessCallN(final Object value, final String property, final Object[] args, final Context cx, final Scriptable scope) {
        if (ScriptRuntime.isNullOrUndefined(value)) {
            return Undefined.instance;
        }
        return optionalCallPropN(value, property, args, cx, scope);
    }
    
    public static Object add(Object val1, final double val2) {
        if (val1 instanceof Scriptable) {
            val1 = ((Scriptable)val1).getDefaultValue(null);
        }
        if (!(val1 instanceof CharSequence)) {
            return wrapDouble(ScriptRuntime.toNumber(val1) + val2);
        }
        return new ConsString((CharSequence)val1, (CharSequence)ScriptRuntime.toString(val2));
    }
    
    public static Object add(final double val1, Object val2) {
        if (val2 instanceof Scriptable) {
            val2 = ((Scriptable)val2).getDefaultValue(null);
        }
        if (!(val2 instanceof CharSequence)) {
            return wrapDouble(ScriptRuntime.toNumber(val2) + val1);
        }
        return new ConsString((CharSequence)ScriptRuntime.toString(val1), (CharSequence)val2);
    }
    
    @Deprecated
    public static Object elemIncrDecr(final Object obj, final double index, final Context cx, final int incrDecrMask) {
        return elemIncrDecr(obj, index, cx, ScriptRuntime.getTopCallScope(cx), incrDecrMask);
    }
    
    public static Object elemIncrDecr(final Object obj, final double index, final Context cx, final Scriptable scope, final int incrDecrMask) {
        return ScriptRuntime.elemIncrDecr(obj, index, cx, scope, incrDecrMask);
    }
    
    public static Object[] padStart(final Object[] currentArgs, final int count) {
        final Object[] result = new Object[currentArgs.length + count];
        System.arraycopy(currentArgs, 0, result, count, currentArgs.length);
        return result;
    }
    
    public static void initFunction(final NativeFunction fn, final int functionType, final Scriptable scope, final Context cx) {
        ScriptRuntime.initFunction(cx, scope, fn, functionType, false);
    }
    
    public static Function bindThis(final NativeFunction fn, final Context cx, final Scriptable scope, final Scriptable thisObj) {
        return (Function)new ArrowFunction(cx, scope, (Callable)fn, thisObj);
    }
    
    public static Object callSpecial(final Context cx, final Callable fun, final Scriptable thisObj, final Object[] args, final Scriptable scope, final Scriptable callerThis, final int callType, final String fileName, final int lineNumber) {
        return ScriptRuntime.callSpecial(cx, fun, thisObj, args, scope, callerThis, callType, fileName, lineNumber);
    }
    
    public static Object newObjectSpecial(final Context cx, final Object fun, final Object[] args, final Scriptable scope, final Scriptable callerThis, final int callType) {
        return ScriptRuntime.newSpecial(cx, fun, args, scope, callType);
    }
    
    public static Double wrapDouble(final double num) {
        if (num == 0.0) {
            if (1.0 / num > 0.0) {
                return OptRuntime.zeroObj;
            }
        }
        else {
            if (num == 1.0) {
                return OptRuntime.oneObj;
            }
            if (num == -1.0) {
                return OptRuntime.minusOneObj;
            }
            if (Double.isNaN(num)) {
                return OptRuntime.NaNobj;
            }
        }
        return num;
    }
    
    static String encodeIntArray(final int[] array) {
        if (array == null) {
            return null;
        }
        final int n = array.length;
        final char[] buffer = new char[1 + n * 2];
        buffer[0] = '\u0001';
        for (int i = 0; i != n; ++i) {
            final int value = array[i];
            final int shift = 1 + i * 2;
            buffer[shift] = (char)(value >>> 16);
            buffer[shift + 1] = (char)value;
        }
        return new String(buffer);
    }
    
    private static int[] decodeIntArray(final String str, final int arraySize) {
        if (arraySize == 0) {
            if (str != null) {
                throw new IllegalArgumentException();
            }
            return null;
        }
        else {
            if (str.length() != 1 + arraySize * 2 && str.charAt(0) != '\u0001') {
                throw new IllegalArgumentException();
            }
            final int[] array = new int[arraySize];
            for (int i = 0; i != arraySize; ++i) {
                final int shift = 1 + i * 2;
                array[i] = (str.charAt(shift) << 16 | str.charAt(shift + 1));
            }
            return array;
        }
    }
    
    public static Scriptable newArrayLiteral(final Object[] objects, final String encodedInts, final int skipCount, final Context cx, final Scriptable scope) {
        final int[] skipIndexces = decodeIntArray(encodedInts, skipCount);
        return ScriptRuntime.newArrayLiteral(objects, skipIndexces, cx, scope);
    }
    
    public static void main(final Script script, final String[] args) {
        ContextFactory.getGlobal().call(cx -> {
            final ScriptableObject global = ScriptRuntime.getGlobal(cx);
            final Object[] argsCopy = new Object[args.length];
            System.arraycopy(args, 0, argsCopy, 0, args.length);
            final Scriptable argsObj = (Scriptable)cx.newArray((Scriptable)global, argsCopy);
            global.defineProperty("arguments", argsObj, 2);
            script.exec(cx, global);
            return null;
        });
    }
    
    public static void throwStopIteration(final Object obj) {
        throw new JavaScriptException(NativeIterator.getStopIterationObject((Scriptable)obj), "", 0);
    }
    
    public static Scriptable createNativeGenerator(final NativeFunction funObj, final Scriptable scope, final Scriptable thisObj, final int maxLocals, final int maxStack) {
        return (Scriptable)new NativeGenerator(scope, funObj, (Object)new GeneratorState(thisObj, maxLocals, maxStack));
    }
    
    public static Object[] getGeneratorStackState(final Object obj) {
        final GeneratorState rgs = (GeneratorState)obj;
        if (rgs.stackState == null) {
            rgs.stackState = new Object[rgs.maxStack];
        }
        return rgs.stackState;
    }
    
    public static Object[] getGeneratorLocalsState(final Object obj) {
        final GeneratorState rgs = (GeneratorState)obj;
        if (rgs.localsState == null) {
            rgs.localsState = new Object[rgs.maxLocals];
        }
        return rgs.localsState;
    }
    
    static {
        zeroObj = new Double(0.0);
        oneObj = new Double(1.0);
        minusOneObj = new Double(-1.0);
    }
    
    public static class GeneratorState
    {
        static final String CLASS_NAME = "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState";
        static final String resumptionPoint_NAME = "resumptionPoint";
        static final String resumptionPoint_TYPE = "I";
        static final String thisObj_NAME = "thisObj";
        static final String thisObj_TYPE = "Lorg/mozilla/javascript/Scriptable;";
        public int resumptionPoint;
        public Scriptable thisObj;
        Object[] stackState;
        Object[] localsState;
        int maxLocals;
        int maxStack;
        
        GeneratorState(final Scriptable thisObj, final int maxLocals, final int maxStack) {
            this.thisObj = thisObj;
            this.maxLocals = maxLocals;
            this.maxStack = maxStack;
        }
    }
}
