//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class NativeReflect extends IdScriptableObject
{
    private static final Object REFLECT_TAG;
    private static final int Id_apply = 1;
    private static final int Id_construct = 2;
    private static final int Id_defineProperty = 3;
    private static final int Id_deleteProperty = 4;
    private static final int Id_get = 5;
    private static final int Id_getOwnPropertyDescriptor = 6;
    private static final int Id_getPrototypeOf = 7;
    private static final int Id_has = 8;
    private static final int Id_isExtensible = 9;
    private static final int Id_ownKeys = 10;
    private static final int Id_preventExtensions = 11;
    private static final int Id_set = 12;
    private static final int Id_setPrototypeOf = 13;
    private static final int Id_isCallable = 14;
    private static final int Id_isConstructor = 15;
    private static final int LAST_METHOD_ID = 15;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeReflect obj = new NativeReflect();
        obj.activatePrototypeMap(15);
        obj.setPrototype(getObjectPrototype(scope));
        obj.setParentScope(scope);
        if (sealed) {
            obj.sealObject();
        }
        ScriptableObject.defineProperty(scope, "Reflect", obj, 2);
    }
    
    public String getClassName() {
        return (String)NativeReflect.REFLECT_TAG;
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String name = null;
        switch (id) {
            case 1: {
                arity = 3;
                name = "apply";
                break;
            }
            case 2: {
                arity = 3;
                name = "construct";
                break;
            }
            case 3: {
                arity = 3;
                name = "defineProperty";
                break;
            }
            case 4: {
                arity = 2;
                name = "deleteProperty";
                break;
            }
            case 5: {
                arity = 3;
                name = "get";
                break;
            }
            case 6: {
                arity = 2;
                name = "getOwnPropertyDescriptor";
                break;
            }
            case 7: {
                arity = 1;
                name = "getPrototypeOf";
                break;
            }
            case 8: {
                arity = 2;
                name = "has";
                break;
            }
            case 9: {
                arity = 1;
                name = "isExtensible";
                break;
            }
            case 10: {
                arity = 1;
                name = "ownKeys";
                break;
            }
            case 11: {
                arity = 1;
                name = "preventExtensions";
                break;
            }
            case 12: {
                arity = 4;
                name = "set";
                break;
            }
            case 13: {
                arity = 2;
                name = "setPrototypeOf";
                break;
            }
            case 14: {
                arity = 1;
                name = "isCallable";
                break;
            }
            case 15: {
                arity = 1;
                name = "isConstructor";
                break;
            }
            default: {
                throw new IllegalStateException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeReflect.REFLECT_TAG, id, name, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeReflect.REFLECT_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        switch (f.methodId()) {
            case 1: {
                return this.js_apply(args, cx, scope);
            }
            case 2: {
                return this.js_construct(args, cx, scope);
            }
            case 3: {
                return this.js_defineProperty(args, cx);
            }
            case 4: {
                return this.js_deleteProperty(args, cx, scope);
            }
            case 5: {
                return this.js_get(args);
            }
            case 6: {
                return this.js_getOwnPropertyDescriptor(args, cx, scope);
            }
            case 7: {
                return this.js_getPrototypeOf(args, cx, scope);
            }
            case 8: {
                return this.js_has(args, cx);
            }
            case 9: {
                return this.js_isExtensible(args, cx, scope);
            }
            case 10: {
                return this.js_ownKeys(args, cx, scope);
            }
            case 11: {
                return this.js_preventExtensions(args);
            }
            case 12: {
                return this.js_set(args);
            }
            case 13: {
                return this.js_setPrototypeOf(args, cx, scope);
            }
            case 14: {
                return args.length > 0 && args[0] instanceof BaseFunction && ((BaseFunction)args[0]).isCallable();
            }
            case 15: {
                return args.length > 0 && args[0] instanceof BaseFunction && ((BaseFunction)args[0]).isConstructable();
            }
            default: {
                return null;
            }
        }
    }
    
    private Object js_apply(final Object[] args, final Context cx, final Scriptable scope) {
        if (args.length > 0 && !(args[0] instanceof Function)) {
            throw ScriptRuntime.typeError4("msg.reflect.bad.args", "target", "Reflect.apply", "function", args[0].getClass().getSimpleName());
        }
        if (args.length > 2 && !(args[2] instanceof NativeArray)) {
            throw ScriptRuntime.typeError4("msg.reflect.bad.args", "argumentsList", "Reflect.apply", "array", args[2].getClass().getSimpleName());
        }
        final Function target = (Function)args[0];
        final Scriptable thisObj = (args[1] == Undefined.instance) ? null : ScriptRuntime.toObject(cx, scope, args[1]);
        final NativeArray targetArgs = (NativeArray)args[2];
        return target.call(cx, scope, thisObj, targetArgs.toArray());
    }
    
    private Object js_construct(final Object[] args, final Context cx, final Scriptable scope) {
        if (args.length < 1 || !(args[0] instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length < 1) ? Undefined.instance : args[0]);
        }
        if (args.length < 2 || !(args[1] instanceof Scriptable) || !ScriptRuntime.isArrayLike((Scriptable)args[1])) {
            throw ScriptRuntime.typeError("Expected argumentsList to be an array");
        }
        final Function target = (Function)args[0];
        final Object[] argumentsList = ScriptRuntime.createArrFromArrayLike(cx, args[1]);
        Function newTarget = null;
        if (args.length > 2) {
            newTarget = (Function)args[2];
        }
        if (target instanceof BaseFunction) {
            ((BaseFunction)target).setForcedNewTarget((Object)newTarget);
        }
        final Scriptable val = ScriptRuntime.newObject(target, cx, scope, argumentsList);
        if (newTarget != null) {
            final Scriptable obj = ScriptRuntime.newObject(newTarget, cx, scope, new Object[0]);
            val.setPrototype(obj.getPrototype());
        }
        return val;
    }
    
    private boolean js_defineProperty(final Object[] args, final Context cx) {
        final ScriptableObject target = ensureScriptableObject((args.length > 0) ? args[0] : Undefined.instance);
        final Object propKey = args[1];
        final ScriptableObject desc = ensureScriptableObject((args.length > 2) ? args[2] : Undefined.instance);
        try {
            target.defineOwnProperty(cx, propKey, desc);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private boolean js_deleteProperty(final Object[] args, final Context cx, final Scriptable scope) {
        final ScriptableObject target = ensureScriptableObject((args.length > 0) ? args[0] : Undefined.instance);
        final Object propKey = args[1];
        try {
            final Object res = ScriptRuntime.delete(target, propKey, cx, scope, true);
            if (res instanceof Boolean) {
                return (boolean)res;
            }
            throw Kit.codeBug();
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private Object js_get(final Object[] args) {
        if (args.length < 1 || !(args[0] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length < 1) ? Undefined.instance : args[0]);
        }
        final Scriptable target = ensureScriptable(args[0]);
        final Object key = (args.length > 1) ? args[1] : Undefined.instance;
        if (key instanceof String) {
            return ScriptableObject.getProperty(target, (String)key);
        }
        if (key instanceof Integer) {
            return ScriptableObject.getProperty(target, key);
        }
        if (key instanceof Double) {
            return ScriptableObject.getProperty(target, ((Double)key).intValue());
        }
        throw Kit.codeBug();
    }
    
    private Object js_getOwnPropertyDescriptor(final Object[] args, final Context cx, final Scriptable scope) {
        final Object arg = (args.length < 1) ? Undefined.instance : args[0];
        final Scriptable s = NativeObject.getCompatibleObject(cx, scope, arg);
        final ScriptableObject obj = ensureScriptableObject((Object)s);
        final Object nameArg = (args.length < 2) ? Undefined.instance : args[1];
        final Scriptable desc = obj.getOwnPropertyDescriptor(cx, nameArg);
        return (desc == null) ? Undefined.instance : desc;
    }
    
    private Object js_getPrototypeOf(final Object[] args, final Context cx, final Scriptable scope) {
        if (args.length < 1) {
            return null;
        }
        return NativeObject.getCompatibleObject(cx, scope, args[0]).getPrototype();
    }
    
    private boolean js_has(final Object[] args, final Context cx) {
        if (args.length < 2) {
            Kit.codeBug();
        }
        return ScriptRuntime.in(args[1], args[0], cx);
    }
    
    private boolean js_isExtensible(final Object[] args, final Context cx, final Scriptable scope) {
        if (args.length < 1 || !(args[0] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length < 1) ? Undefined.instance : args[0]);
        }
        final ScriptableObject obj = (ScriptableObject)args[0];
        return obj.isExtensible();
    }
    
    private Object js_ownKeys(final Object[] args, final Context cx, final Scriptable scope) {
        if (args.length < 1 || !(args[0] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length < 1) ? Undefined.instance : args[0]);
        }
        final ScriptableObject obj = ensureScriptableObject((Object)NativeObject.getCompatibleObject(cx, scope, args[0]));
        final Object[] ownKeys = obj.getIds(true, true);
        for (int i = 0; i < ownKeys.length; ++i) {
            final Object key = ownKeys[i];
            if (!(key instanceof Symbol)) {
                ownKeys[i] = ScriptRuntime.toString(ownKeys[i]);
            }
        }
        return cx.newArray(scope, ownKeys);
    }
    
    private Object js_preventExtensions(final Object[] args) {
        if (args.length < 1 || !(args[0] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length < 1) ? Undefined.instance : args[0]);
        }
        try {
            final ScriptableObject obj = ensureScriptableObject(args[0]);
            obj.preventExtensions();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private boolean js_set(final Object[] args) {
        if (args.length < 1 || !(args[0] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length < 1) ? Undefined.instance : args[0]);
        }
        final Scriptable target = ensureScriptable(args[0]);
        final Object key = (args.length > 1) ? args[1] : Undefined.instance;
        final Object value = (args.length > 2) ? args[2] : Undefined.instance;
        try {
            if (key instanceof String) {
                ScriptableObject.putProperty(target, (String)key, value);
            }
            else if (key instanceof Integer) {
                ScriptableObject.putProperty(target, key, value);
            }
            else if (key instanceof Double) {
                ScriptableObject.putProperty(target, ((Double)key).intValue(), value);
            }
            else {
                if (!(key instanceof Undefined)) {
                    return false;
                }
                ScriptableObject.putProperty(target, "undefined", value);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private Object js_setPrototypeOf(final Object[] args, final Context cx, final Scriptable scope) {
        if (args.length < 2 || (args[1] != null && !(args[1] instanceof ScriptableObject))) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof((args.length < 2) ? Undefined.instance : args[1]));
        }
        final Object target = args[0];
        final ScriptableObject key = (ScriptableObject)args[1];
        if (key instanceof Symbol) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(target));
        }
        if (!(target instanceof ScriptableObject)) {
            return target;
        }
        final ScriptableObject scriptTarget = (ScriptableObject)target;
        if (!scriptTarget.isExtensible()) {
            return false;
        }
        for (Scriptable prototypeProto = key; prototypeProto != null; prototypeProto = prototypeProto.getPrototype()) {
            if (prototypeProto == scriptTarget) {
                return false;
            }
        }
        scriptTarget.setPrototype(key);
        return true;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 3: {
                final int c = s.charAt(0);
                if (c == 103) {
                    if (s.charAt(2) == 't' && s.charAt(1) == 'e') {
                        id = 5;
                        return id;
                    }
                    break;
                }
                else if (c == 104) {
                    if (s.charAt(2) == 's' && s.charAt(1) == 'a') {
                        id = 8;
                        return id;
                    }
                    break;
                }
                else {
                    if (c == 115 && s.charAt(2) == 't' && s.charAt(1) == 'e') {
                        id = 12;
                        return id;
                    }
                    break;
                }
                break;
            }
            case 5: {
                X = "apply";
                id = 1;
                break;
            }
            case 7: {
                X = "ownKeys";
                id = 10;
                break;
            }
            case 9: {
                X = "construct";
                id = 2;
                break;
            }
            case 10: {
                X = "isCallable";
                id = 14;
                break;
            }
            case 12: {
                X = "isExtensible";
                id = 9;
                break;
            }
            case 13: {
                X = "isConstructor";
                id = 15;
                break;
            }
            case 14: {
                int c = s.charAt(0);
                if (c == 100) {
                    c = s.charAt(2);
                    if (c == 102) {
                        X = "defineProperty";
                        id = 3;
                        break;
                    }
                    if (c == 108) {
                        X = "deleteProperty";
                        id = 4;
                        break;
                    }
                    break;
                }
                else {
                    if (c == 103) {
                        X = "getPrototypeOf";
                        id = 7;
                        break;
                    }
                    if (c == 115) {
                        X = "setPrototypeOf";
                        id = 13;
                        break;
                    }
                    break;
                }
                break;
            }
            case 17: {
                X = "preventExtensions";
                id = 11;
                break;
            }
            case 24: {
                X = "getOwnPropertyDescriptor";
                id = 6;
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        REFLECT_TAG = "Reflect";
    }
}
