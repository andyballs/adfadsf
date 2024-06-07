//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.proxy.*;
import java.util.*;

public class NativeObject extends IdScriptableObject implements Map
{
    private static final long serialVersionUID = -6345305608474346996L;
    private static final Object OBJECT_TAG;
    private static final int ConstructorId_getPrototypeOf = -1;
    private static final int ConstructorId_keys = -2;
    private static final int ConstructorId_getOwnPropertyNames = -3;
    private static final int ConstructorId_getOwnPropertyDescriptor = -4;
    private static final int ConstructorId_defineProperty = -5;
    private static final int ConstructorId_isExtensible = -6;
    private static final int ConstructorId_preventExtensions = -7;
    private static final int ConstructorId_defineProperties = -8;
    private static final int ConstructorId_create = -9;
    private static final int ConstructorId_isSealed = -10;
    private static final int ConstructorId_isFrozen = -11;
    private static final int ConstructorId_seal = -12;
    private static final int ConstructorId_freeze = -13;
    private static final int ConstructorId_getOwnPropertySymbols = -14;
    private static final int ConstructorId_assign = -15;
    private static final int ConstructorId_is = -16;
    private static final int ConstructorId_setPrototypeOf = -17;
    private static final int ConstructorId_values = -18;
    private static final int ConstructorId_entries = -19;
    private static final int ConstructorId_getOwnPropertyDescriptors = -20;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toLocaleString = 3;
    private static final int Id_valueOf = 4;
    private static final int Id_hasOwnProperty = 5;
    private static final int Id_propertyIsEnumerable = 6;
    private static final int Id_isPrototypeOf = 7;
    private static final int Id_toSource = 8;
    private static final int Id___defineGetter__ = 9;
    private static final int Id___defineSetter__ = 10;
    private static final int Id___lookupGetter__ = 11;
    private static final int Id___lookupSetter__ = 12;
    private static final int MAX_PROTOTYPE_ID = 12;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeObject obj = new NativeObject();
        obj.exportAsJSClass(12, scope, sealed);
    }
    
    public String getClassName() {
        return "Object";
    }
    
    public String toString() {
        return ScriptRuntime.defaultObjectToString((Scriptable)this);
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        if (Context.getCurrentContext().version >= 200) {
            this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -17, "setPrototypeOf", 2);
        }
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -1, "getPrototypeOf", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -2, "keys", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -3, "getOwnPropertyNames", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -14, "getOwnPropertySymbols", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -4, "getOwnPropertyDescriptor", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -20, "getOwnPropertyDescriptors", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -5, "defineProperty", 3);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -6, "isExtensible", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -7, "preventExtensions", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -8, "defineProperties", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -9, "create", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -10, "isSealed", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -11, "isFrozen", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -12, "seal", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -13, "freeze", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -15, "assign", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -16, "is", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -18, "values", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeObject.OBJECT_TAG, -19, "entries", 1);
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
                arity = 0;
                s = "toString";
                break;
            }
            case 3: {
                arity = 0;
                s = "toLocaleString";
                break;
            }
            case 4: {
                arity = 0;
                s = "valueOf";
                break;
            }
            case 5: {
                arity = 1;
                s = "hasOwnProperty";
                break;
            }
            case 6: {
                arity = 1;
                s = "propertyIsEnumerable";
                break;
            }
            case 7: {
                arity = 1;
                s = "isPrototypeOf";
                break;
            }
            case 8: {
                arity = 0;
                s = "toSource";
                break;
            }
            case 9: {
                arity = 2;
                s = "__defineGetter__";
                break;
            }
            case 10: {
                arity = 2;
                s = "__defineSetter__";
                break;
            }
            case 11: {
                arity = 1;
                s = "__lookupGetter__";
                break;
            }
            case 12: {
                arity = 1;
                s = "__lookupSetter__";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeObject.OBJECT_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeObject.OBJECT_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                if (thisObj != null) {
                    return f.construct(cx, scope, args);
                }
                if (args.length == 0 || args[0] == null || args[0] == Undefined.instance) {
                    return new NativeObject();
                }
                return ScriptRuntime.toObject(cx, scope, args[0]);
            }
            case 3: {
                final Object toString = ScriptableObject.getProperty(thisObj, "toString");
                if (!(toString instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(toString);
                }
                final Callable fun = (Callable)toString;
                return fun.call(cx, scope, thisObj, ScriptRuntime.emptyArgs);
            }
            case 2: {
                if (cx.hasFeature(3)) {
                    String s = ScriptRuntime.defaultObjectToSource(cx, scope, thisObj, args);
                    final int L = s.length();
                    if (L != 0 && s.charAt(0) == '(' && s.charAt(L - 1) == ')') {
                        s = s.substring(1, L - 1);
                    }
                    return s;
                }
                return ScriptRuntime.defaultObjectToString(thisObj);
            }
            case 4: {
                if (cx.getLanguageVersion() >= 180 && (thisObj == null || Undefined.isUndefined(thisObj))) {
                    throw ScriptRuntime.typeError0("msg." + ((thisObj == null) ? "null" : "undef") + ".to.object");
                }
                return thisObj;
            }
            case 5: {
                if (cx.getLanguageVersion() >= 180 && (thisObj == null || Undefined.isUndefined(thisObj))) {
                    throw ScriptRuntime.typeError0("msg." + ((thisObj == null) ? "null" : "undef") + ".to.object");
                }
                final Object arg = (args.length < 1) ? Undefined.instance : args[0];
                boolean result;
                if (arg instanceof Symbol) {
                    result = ensureSymbolScriptable((Object)thisObj).has((Symbol)arg, thisObj);
                }
                else {
                    final String s2 = ScriptRuntime.toStringIdOrIndex(cx, arg);
                    if (s2 == null) {
                        final int index = ScriptRuntime.lastIndexResult(cx);
                        result = thisObj.has(index, thisObj);
                    }
                    else {
                        result = thisObj.has(s2, thisObj);
                    }
                }
                return ScriptRuntime.wrapBoolean(result);
            }
            case 6: {
                if (cx.getLanguageVersion() >= 180 && (thisObj == null || Undefined.isUndefined(thisObj))) {
                    throw ScriptRuntime.typeError0("msg." + ((thisObj == null) ? "null" : "undef") + ".to.object");
                }
                final Object arg = (args.length < 1) ? Undefined.instance : args[0];
                boolean result;
                if (arg instanceof Symbol) {
                    result = ((SymbolScriptable)thisObj).has((Symbol)arg, thisObj);
                    if (result && thisObj instanceof ScriptableObject) {
                        final ScriptableObject so = (ScriptableObject)thisObj;
                        final int attrs = so.getAttributes((Symbol)arg);
                        result = ((attrs & 0x2) == 0x0);
                    }
                }
                else {
                    String s2 = ScriptRuntime.toStringIdOrIndex(cx, arg);
                    try {
                        if (s2 == null) {
                            final int index = ScriptRuntime.lastIndexResult(cx);
                            result = thisObj.has(index, thisObj);
                            s2 = Integer.toString(index);
                            if (result && thisObj instanceof ScriptableObject) {
                                final ScriptableObject so2 = (ScriptableObject)thisObj;
                                final int attrs2 = so2.getAttributes(index);
                                result = ((attrs2 & 0x2) == 0x0);
                            }
                        }
                        else {
                            result = thisObj.has(s2, thisObj);
                            if (result && thisObj instanceof ScriptableObject) {
                                final ScriptableObject so3 = (ScriptableObject)thisObj;
                                final int attrs3 = so3.getAttributes(s2);
                                result = ((attrs3 & 0x2) == 0x0);
                            }
                        }
                    }
                    catch (EvaluatorException ee) {
                        if (!ee.getMessage().startsWith(ScriptRuntime.getMessage1("msg.prop.not.found", s2))) {
                            throw ee;
                        }
                        result = false;
                    }
                }
                return ScriptRuntime.wrapBoolean(result);
            }
            case 7: {
                if (cx.getLanguageVersion() >= 180 && (thisObj == null || Undefined.isUndefined(thisObj))) {
                    throw ScriptRuntime.typeError0("msg." + ((thisObj == null) ? "null" : "undef") + ".to.object");
                }
                boolean result = false;
                if (args.length != 0 && args[0] instanceof Scriptable) {
                    Scriptable v = (Scriptable)args[0];
                    do {
                        v = v.getPrototype();
                        if (v == thisObj) {
                            result = true;
                            break;
                        }
                    } while (v != null);
                }
                return ScriptRuntime.wrapBoolean(result);
            }
            case 8: {
                return ScriptRuntime.defaultObjectToSource(cx, scope, thisObj, args);
            }
            case 9:
            case 10: {
                if (args.length < 2 || !(args[1] instanceof Callable)) {
                    final Object badArg = (args.length >= 2) ? args[1] : Undefined.instance;
                    throw ScriptRuntime.notFunctionError(badArg);
                }
                if (!(thisObj instanceof ScriptableObject)) {
                    throw Context.reportRuntimeError3("msg.extend.scriptable", (Object)((thisObj == null) ? "null" : thisObj.getClass().getName()), (Object)"define", (Object)String.valueOf(args[0]));
                }
                final ScriptableObject so4 = (ScriptableObject)thisObj;
                if (ScriptRuntime.isSymbol(args[0])) {
                    final Callable getterOrSetter = (Callable)args[1];
                    final boolean isSetter = id == 10;
                    so4.setGetterOrSetter((Symbol)args[0], 0, getterOrSetter, isSetter);
                }
                else {
                    final String name = ScriptRuntime.toStringIdOrIndex(cx, args[0]);
                    final int index2 = (name != null) ? 0 : ScriptRuntime.lastIndexResult(cx);
                    final Callable getterOrSetter2 = (Callable)args[1];
                    final boolean isSetter2 = id == 10;
                    so4.setGetterOrSetter(name, index2, getterOrSetter2, isSetter2);
                }
                if (so4 instanceof NativeArray) {
                    ((NativeArray)so4).setDenseOnly(false);
                }
                return Undefined.instance;
            }
            case 11:
            case 12: {
                if (args.length < 1) {
                    return Undefined.instance;
                }
                if (!(thisObj instanceof ScriptableObject)) {
                    throw Context.reportRuntimeError3("msg.extend.scriptable", (Object)((thisObj == null) ? "null" : thisObj.getClass().getName()), (Object)"lookup", (Object)String.valueOf(args[0]));
                }
                ScriptableObject so4 = (ScriptableObject)thisObj;
                final boolean isSetter3 = id == 12;
                if (ScriptRuntime.isSymbol(args[0])) {
                    final Symbol symbol = (Symbol)args[0];
                    while (true) {
                        final Object gs = so4.getGetterOrSetter(symbol, 0, isSetter3);
                        if (gs != null) {
                            return gs;
                        }
                        final Scriptable v2 = so4.getPrototype();
                        if (v2 == null) {
                            break;
                        }
                        if (!(v2 instanceof ScriptableObject)) {
                            break;
                        }
                        so4 = (ScriptableObject)v2;
                    }
                }
                else {
                    final String name2 = ScriptRuntime.toStringIdOrIndex(cx, args[0]);
                    final int index = (name2 != null) ? 0 : ScriptRuntime.lastIndexResult(cx);
                    while (true) {
                        final Object gs2 = so4.getGetterOrSetter(name2, index, isSetter3);
                        if (gs2 != null) {
                            return gs2;
                        }
                        final Scriptable v3 = so4.getPrototype();
                        if (v3 == null) {
                            break;
                        }
                        if (!(v3 instanceof ScriptableObject)) {
                            break;
                        }
                        so4 = (ScriptableObject)v3;
                    }
                }
                return Undefined.instance;
            }
            case -1: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable obj = getCompatibleObject(cx, scope, arg2);
                return obj.getPrototype();
            }
            case -17: {
                if (args.length < 2) {
                    throw ScriptRuntime.typeError1("msg.incompat.call", "setPrototypeOf");
                }
                final Scriptable proto = (args[1] == null) ? null : ensureScriptable(args[1]);
                if (proto instanceof Symbol) {
                    throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(proto));
                }
                if (!(args[0] instanceof ScriptableObject)) {
                    return args[0];
                }
                final ScriptableObject obj2 = (ScriptableObject)args[0];
                if (!obj2.isExtensible() && !(obj2 instanceof NativeProxy)) {
                    throw ScriptRuntime.typeError0("msg.not.extensible");
                }
                for (Scriptable prototypeProto = proto; prototypeProto != null; prototypeProto = prototypeProto.getPrototype()) {
                    if (prototypeProto == obj2) {
                        throw ScriptRuntime.typeError1("msg.object.cyclic.prototype", obj2.getClass().getSimpleName());
                    }
                }
                obj2.setPrototype(proto);
                return obj2;
            }
            case -2: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable obj = getCompatibleObject(cx, scope, arg2);
                final Object[] ids = obj.getIds();
                for (int i = 0; i < ids.length; ++i) {
                    ids[i] = ScriptRuntime.toString(ids[i]);
                }
                return cx.newArray(scope, ids);
            }
            case -3: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable s3 = getCompatibleObject(cx, scope, arg2);
                final ScriptableObject obj3 = ensureScriptableObject((Object)s3);
                final Object[] ids2 = obj3.getIds(true, false);
                for (int j = 0; j < ids2.length; ++j) {
                    ids2[j] = ScriptRuntime.toString(ids2[j]);
                }
                return cx.newArray(scope, ids2);
            }
            case -14: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable s3 = getCompatibleObject(cx, scope, arg2);
                final ScriptableObject obj3 = ensureScriptableObject((Object)s3);
                final Object[] ids2 = obj3.getIds(true, true);
                final ArrayList<Object> syms = new ArrayList<Object>();
                for (int k = 0; k < ids2.length; ++k) {
                    if (ids2[k] instanceof Symbol) {
                        syms.add(ids2[k]);
                    }
                }
                return cx.newArray(scope, syms.toArray());
            }
            case -4: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable s3 = getCompatibleObject(cx, scope, arg2);
                final ScriptableObject obj3 = ensureScriptableObject((Object)s3);
                final Object nameArg = (args.length < 2) ? Undefined.instance : args[1];
                final Scriptable desc = obj3.getOwnPropertyDescriptor(cx, nameArg);
                return (desc == null) ? Undefined.instance : desc;
            }
            case -20: {
                final Object argObj = (args.length < 1) ? Undefined.instance : args[0];
                final NativeObject descriptors = cx.newObject(scope);
                if (argObj instanceof ScriptableObject) {
                    final ScriptableObject arg3 = (ScriptableObject)argObj;
                    final Object[] ids3;
                    final Object[] keys = ids3 = arg3.getIds(true, true);
                    for (final Object key : ids3) {
                        ScriptableObject.putProperty(descriptors, key, arg3.getOwnPropertyDescriptor(cx, key));
                    }
                }
                return descriptors;
            }
            case -5: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                final Object name3 = (args.length < 2) ? Undefined.instance : args[1];
                final Object descArg = (args.length < 3) ? Undefined.instance : args[2];
                final ScriptableObject desc2 = ensureScriptableObject(descArg);
                obj2.defineOwnProperty(cx, name3, desc2);
                return obj2;
            }
            case -6: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                if (cx.getLanguageVersion() >= 200 && !(arg2 instanceof ScriptableObject)) {
                    return Boolean.FALSE;
                }
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                return obj2.isExtensible();
            }
            case -7: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                if (cx.getLanguageVersion() >= 200 && !(arg2 instanceof ScriptableObject)) {
                    return arg2;
                }
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                obj2.preventExtensions();
                return obj2;
            }
            case -8: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                final Object propsObj = (args.length < 2) ? Undefined.instance : args[1];
                final Scriptable props = Context.toObject(propsObj, this.getParentScope());
                obj2.defineOwnProperties(cx, ensureScriptableObject((Object)props));
                return obj2;
            }
            case -9: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable obj = (arg2 == null) ? null : ensureScriptable(arg2);
                final ScriptableObject newObject = (ScriptableObject)new NativeObject();
                newObject.setParentScope(this.getParentScope());
                newObject.setPrototype(obj);
                if (args.length > 1 && args[1] != Undefined.instance) {
                    final Scriptable props = Context.toObject(args[1], this.getParentScope());
                    newObject.defineOwnProperties(cx, ensureScriptableObject((Object)props));
                }
                return newObject;
            }
            case -10: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                if (cx.getLanguageVersion() >= 200 && !(arg2 instanceof ScriptableObject)) {
                    return Boolean.TRUE;
                }
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                if (obj2.isExtensible()) {
                    return Boolean.FALSE;
                }
                for (final Object name4 : obj2.getAllIds()) {
                    final Object configurable = obj2.getOwnPropertyDescriptor(cx, name4).get("configurable");
                    if (Boolean.TRUE.equals(configurable)) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            case -11: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                if (cx.getLanguageVersion() >= 200 && !(arg2 instanceof ScriptableObject)) {
                    return Boolean.TRUE;
                }
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                if (obj2.isExtensible()) {
                    return Boolean.FALSE;
                }
                for (final Object name4 : obj2.getAllIds()) {
                    final ScriptableObject desc3 = obj2.getOwnPropertyDescriptor(cx, name4);
                    if (Boolean.TRUE.equals(desc3.get("configurable"))) {
                        return Boolean.FALSE;
                    }
                    if (this.isDataDescriptor(desc3) && Boolean.TRUE.equals(desc3.get("writable"))) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            case -12: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                if (cx.getLanguageVersion() >= 200 && !(arg2 instanceof ScriptableObject)) {
                    return arg2;
                }
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                for (final Object name4 : obj2.getAllIds()) {
                    final ScriptableObject desc3 = obj2.getOwnPropertyDescriptor(cx, name4);
                    if (Boolean.TRUE.equals(desc3.get("configurable"))) {
                        desc3.put("configurable", desc3, Boolean.FALSE);
                        obj2.defineOwnProperty(cx, name4, desc3, false);
                    }
                }
                obj2.preventExtensions();
                return obj2;
            }
            case -13: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                if (cx.getLanguageVersion() >= 200 && !(arg2 instanceof ScriptableObject)) {
                    return arg2;
                }
                final ScriptableObject obj2 = ensureScriptableObject(arg2);
                for (final Object name4 : obj2.getAllIds()) {
                    final ScriptableObject desc3 = obj2.getOwnPropertyDescriptor(cx, name4);
                    if (this.isDataDescriptor(desc3) && Boolean.TRUE.equals(desc3.get("writable"))) {
                        desc3.put("writable", desc3, Boolean.FALSE);
                    }
                    if (Boolean.TRUE.equals(desc3.get("configurable"))) {
                        desc3.put("configurable", desc3, Boolean.FALSE);
                    }
                    obj2.defineOwnProperty(cx, name4, desc3, false);
                }
                obj2.preventExtensions();
                return obj2;
            }
            case -15: {
                if (args.length < 1) {
                    throw ScriptRuntime.typeError1("msg.incompat.call", "assign");
                }
                final Scriptable t = ScriptRuntime.toObject(cx, thisObj, args[0]);
                for (int l = 1; l < args.length; ++l) {
                    if (args[l] != null) {
                        if (!Undefined.instance.equals(args[l])) {
                            final Scriptable s4 = ScriptRuntime.toObject(cx, thisObj, args[l]);
                            final Object[] ids4;
                            final Object[] ids2 = ids4 = s4.getIds();
                            for (final Object key : ids4) {
                                if (key instanceof String) {
                                    final Object val = s4.get((String)key, t);
                                    if (val != Scriptable.NOT_FOUND && val != Undefined.instance) {
                                        t.put((String)key, t, val);
                                    }
                                }
                                else if (key instanceof Number) {
                                    final int ii = ScriptRuntime.toInt32(key);
                                    final Object val2 = s4.get(ii, t);
                                    if (val2 != Scriptable.NOT_FOUND && val2 != Undefined.instance) {
                                        t.put(ii, t, val2);
                                    }
                                }
                            }
                        }
                    }
                }
                return t;
            }
            case -16: {
                final Object a1 = (args.length < 1) ? Undefined.instance : args[0];
                final Object a2 = (args.length < 2) ? Undefined.instance : args[1];
                return ScriptRuntime.wrapBoolean(ScriptRuntime.same(a1, a2));
            }
            case -18: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable obj = getCompatibleObject(cx, scope, arg2);
                final Object[] ids = obj.getIds();
                for (int i = 0; i < ids.length; ++i) {
                    ids[i] = ScriptableObject.getProperty(obj, ids[i]);
                }
                return cx.newArray(scope, ids);
            }
            case -19: {
                final Object arg2 = (args.length < 1) ? Undefined.instance : args[0];
                final Scriptable obj = getCompatibleObject(cx, scope, arg2);
                final Object[] ids = obj.getIds();
                for (int i = 0; i < ids.length; ++i) {
                    ids[i] = cx.newArray(scope, new Object[] { ids[i], ScriptableObject.getProperty(obj, ids[i]) });
                }
                return cx.newArray(scope, ids);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    public static Scriptable getCompatibleObject(final Context cx, final Scriptable scope, final Object arg) {
        if (cx.getLanguageVersion() >= 200) {
            final Scriptable s = ScriptRuntime.toObject(cx, scope, arg);
            return ensureScriptable((Object)s);
        }
        return ensureScriptable(arg);
    }
    
    public boolean containsKey(final Object key) {
        if (key instanceof String) {
            return this.has((String)key, (Scriptable)this);
        }
        return key instanceof Number && this.has(((Number)key).intValue(), (Scriptable)this);
    }
    
    public boolean containsValue(final Object value) {
        for (final Object obj : this.values()) {
            if (value == obj || (value != null && value.equals(obj))) {
                return true;
            }
        }
        return false;
    }
    
    public Object remove(final Object key) {
        final Object value = this.get(key);
        if (key instanceof String) {
            this.delete((String)key);
        }
        else if (key instanceof Number) {
            this.delete(((Number)key).intValue());
        }
        return value;
    }
    
    public Set<Object> keySet() {
        return new KeySet();
    }
    
    public Collection<Object> values() {
        return new ValueCollection();
    }
    
    public Set<Entry<Object, Object>> entrySet() {
        return new EntrySet();
    }
    
    public Object put(final Object key, final Object value) {
        throw new UnsupportedOperationException();
    }
    
    public void putAll(final Map m) {
        throw new UnsupportedOperationException();
    }
    
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 7: {
                X = "valueOf";
                id = 4;
                break;
            }
            case 8: {
                final int c = s.charAt(3);
                if (c == 111) {
                    X = "toSource";
                    id = 8;
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
                X = "constructor";
                id = 1;
                break;
            }
            case 13: {
                X = "isPrototypeOf";
                id = 7;
                break;
            }
            case 14: {
                final int c = s.charAt(0);
                if (c == 104) {
                    X = "hasOwnProperty";
                    id = 5;
                    break;
                }
                if (c == 116) {
                    X = "toLocaleString";
                    id = 3;
                    break;
                }
                break;
            }
            case 16: {
                int c = s.charAt(2);
                if (c == 100) {
                    c = s.charAt(8);
                    if (c == 71) {
                        X = "__defineGetter__";
                        id = 9;
                        break;
                    }
                    if (c == 83) {
                        X = "__defineSetter__";
                        id = 10;
                        break;
                    }
                    break;
                }
                else {
                    if (c != 108) {
                        break;
                    }
                    c = s.charAt(8);
                    if (c == 71) {
                        X = "__lookupGetter__";
                        id = 11;
                        break;
                    }
                    if (c == 83) {
                        X = "__lookupSetter__";
                        id = 12;
                        break;
                    }
                    break;
                }
                break;
            }
            case 20: {
                X = "propertyIsEnumerable";
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
        OBJECT_TAG = "Object";
    }
    
    class EntrySet extends AbstractSet<Entry<Object, Object>>
    {
        @Override
        public Iterator<Entry<Object, Object>> iterator() {
            return new Iterator<Entry<Object, Object>>() {
                Object[] ids = NativeObject.this.getIds();
                Object key = null;
                int index = 0;
                
                @Override
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }
                
                @Override
                public Entry<Object, Object> next() {
                    final Object key = this.ids[this.index++];
                    this.key = key;
                    final Object ekey = key;
                    final Object value = NativeObject.this.get(this.key);
                    return new Entry<Object, Object>() {
                        @Override
                        public Object getKey() {
                            return ekey;
                        }
                        
                        @Override
                        public Object getValue() {
                            return value;
                        }
                        
                        @Override
                        public Object setValue(final Object value) {
                            throw new UnsupportedOperationException();
                        }
                        
                        @Override
                        public boolean equals(final Object other) {
                            if (!(other instanceof Entry)) {
                                return false;
                            }
                            final Entry<?, ?> e = (Entry<?, ?>)other;
                            if (ekey == null) {
                                if (e.getKey() != null) {
                                    return false;
                                }
                            }
                            else if (!ekey.equals(e.getKey())) {
                                return false;
                            }
                            if ((value != null) ? value.equals(e.getValue()) : (e.getValue() == null)) {
                                return true;
                            }
                            return false;
                        }
                        
                        @Override
                        public int hashCode() {
                            return ((ekey == null) ? 0 : ekey.hashCode()) ^ ((value == null) ? 0 : value.hashCode());
                        }
                        
                        @Override
                        public String toString() {
                            return ekey + "=" + value;
                        }
                    };
                }
                
                @Override
                public void remove() {
                    if (this.key == null) {
                        throw new IllegalStateException();
                    }
                    NativeObject.this.remove(this.key);
                    this.key = null;
                }
            };
        }
        
        @Override
        public int size() {
            return NativeObject.this.size();
        }
    }
    
    class KeySet extends AbstractSet<Object>
    {
        @Override
        public boolean contains(final Object key) {
            return NativeObject.this.containsKey(key);
        }
        
        @Override
        public Iterator<Object> iterator() {
            return new Iterator<Object>() {
                Object[] ids = NativeObject.this.getIds();
                Object key;
                int index = 0;
                
                @Override
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }
                
                @Override
                public Object next() {
                    try {
                        return this.key = this.ids[this.index++];
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        this.key = null;
                        throw new NoSuchElementException();
                    }
                }
                
                @Override
                public void remove() {
                    if (this.key == null) {
                        throw new IllegalStateException();
                    }
                    NativeObject.this.remove(this.key);
                    this.key = null;
                }
            };
        }
        
        @Override
        public int size() {
            return NativeObject.this.size();
        }
    }
    
    class ValueCollection extends AbstractCollection<Object>
    {
        @Override
        public Iterator<Object> iterator() {
            return new Iterator<Object>() {
                Object[] ids = NativeObject.this.getIds();
                Object key;
                int index = 0;
                
                @Override
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }
                
                @Override
                public Object next() {
                    final NativeObject this$0 = NativeObject.this;
                    final Object key = this.ids[this.index++];
                    this.key = key;
                    return this$0.get(key);
                }
                
                @Override
                public void remove() {
                    if (this.key == null) {
                        throw new IllegalStateException();
                    }
                    NativeObject.this.remove(this.key);
                    this.key = null;
                }
            };
        }
        
        @Override
        public int size() {
            return NativeObject.this.size();
        }
    }
}
