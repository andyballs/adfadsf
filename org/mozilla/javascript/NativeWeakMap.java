//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.io.*;

public class NativeWeakMap extends IdScriptableObject
{
    private static final long serialVersionUID = 8670434366883930453L;
    private static final Object MAP_TAG;
    private boolean instanceOfWeakMap;
    private transient WeakHashMap<Scriptable, Object> map;
    private static final Object NULL_VALUE;
    private static final int Id_constructor = 1;
    private static final int Id_delete = 2;
    private static final int Id_get = 3;
    private static final int Id_has = 4;
    private static final int Id_set = 5;
    private static final int Id_deleteAll = 6;
    private static final int Id_upsert = 7;
    private static final int SymbolId_toStringTag = 8;
    private static final int MAX_PROTOTYPE_ID = 8;
    
    public NativeWeakMap() {
        this.instanceOfWeakMap = false;
        this.map = new WeakHashMap<Scriptable, Object>();
    }
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeWeakMap m = new NativeWeakMap();
        m.exportAsJSClass(8, scope, sealed);
    }
    
    public String getClassName() {
        return "WeakMap";
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeWeakMap.MAP_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                if (thisObj == null) {
                    final NativeWeakMap nm = new NativeWeakMap();
                    nm.instanceOfWeakMap = true;
                    if (args.length > 0) {
                        NativeMap.loadFromIterable(cx, scope, (ScriptableObject)nm, args[0]);
                    }
                    return nm;
                }
                throw ScriptRuntime.typeError1("msg.no.new", "WeakMap");
            }
            case 2: {
                return this.realThis(thisObj, f).js_delete((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 3: {
                return this.realThis(thisObj, f).js_get((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 4: {
                return this.realThis(thisObj, f).js_has((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 5: {
                return this.realThis(thisObj, f).js_set((args.length > 0) ? args[0] : Undefined.instance, (args.length > 1) ? args[1] : Undefined.instance);
            }
            case 6: {
                return this.realThis(thisObj, f).js_deleteAll(args);
            }
            case 7: {
                return this.realThis(thisObj, f).js_upsert(cx, scope, args);
            }
            default: {
                throw new IllegalArgumentException("WeakMap.prototype has no method: " + f.getFunctionName());
            }
        }
    }
    
    private boolean js_delete(final Object key) {
        if (!ScriptRuntime.isObject(key)) {
            return false;
        }
        final Object oldVal = this.map.remove(key);
        return oldVal != null;
    }
    
    private Object js_get(final Object key) {
        if (!ScriptRuntime.isObject(key)) {
            return Undefined.instance;
        }
        final Object result = this.map.get(key);
        if (result == null) {
            return Undefined.instance;
        }
        if (result == NativeWeakMap.NULL_VALUE) {
            return null;
        }
        return result;
    }
    
    private Object js_has(final Object key) {
        if (!ScriptRuntime.isObject(key)) {
            return false;
        }
        return this.map.containsKey(key);
    }
    
    private Object js_set(final Object key, final Object v) {
        if (!ScriptRuntime.isObject(key)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(key));
        }
        final Object value = (v == null) ? NativeWeakMap.NULL_VALUE : v;
        this.map.put((Scriptable)key, value);
        return this;
    }
    
    private Object js_deleteAll(final Object[] args) {
        for (final Object arg : args) {
            this.js_delete(arg);
        }
        return this;
    }
    
    private Object js_upsert(final Context cx, final Scriptable scope, final Object[] args) {
        if (args.length == 0) {
            throw ScriptRuntime.typeError("Key must be specified for upsert");
        }
        if (args.length == 1) {
            throw ScriptRuntime.typeError("Update function must be specified for upsert");
        }
        final Scriptable key = ScriptableObject.ensureScriptable(args[0]);
        final Object updateFnObj = args[1];
        final Object insertFnObj = (args.length > 2) ? args[2] : null;
        if (!(updateFnObj instanceof Callable) && !(insertFnObj instanceof Callable)) {
            throw ScriptRuntime.typeError("The updater and inserter provided to upsert are both not functions");
        }
        final Callable updateFn = (updateFnObj instanceof Callable) ? ((Callable)updateFnObj) : null;
        final Callable insertFn = (insertFnObj instanceof Callable) ? ((Callable)insertFnObj) : null;
        for (final Map.Entry<Scriptable, Object> en : this.map.entrySet()) {
            if (ScriptRuntime.sameZero(en.getKey(), key)) {
                Object value = en.getValue();
                if (updateFn != null) {
                    value = updateFn.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { value, key, this });
                    this.map.put(key, value);
                }
                return value;
            }
        }
        if (insertFn != null) {
            final Object insertionValue = insertFn.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { key, this });
            this.map.put(key, insertionValue);
            return insertionValue;
        }
        return Undefined.instance;
    }
    
    private NativeWeakMap realThis(final Scriptable thisObj, final IdFunctionObject f) {
        if (thisObj == null) {
            throw incompatibleCallError(f);
        }
        try {
            final NativeWeakMap nm = (NativeWeakMap)ScriptRuntime.unwrapProxy(thisObj);
            if (!nm.instanceOfWeakMap) {
                throw incompatibleCallError(f);
            }
            return nm;
        }
        catch (ClassCastException cce) {
            throw incompatibleCallError(f);
        }
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 8) {
            this.initPrototypeValue(8, (Symbol)SymbolKey.TO_STRING_TAG, (Object)this.getClassName(), 3);
            return;
        }
        final String fnName = null;
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 0;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 1;
                s = "delete";
                break;
            }
            case 3: {
                arity = 1;
                s = "get";
                break;
            }
            case 4: {
                arity = 1;
                s = "has";
                break;
            }
            case 5: {
                arity = 2;
                s = "set";
                break;
            }
            case 6: {
                arity = 0;
                s = "deleteAll";
                break;
            }
            case 7: {
                arity = 3;
                s = "upsert";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeWeakMap.MAP_TAG, id, s, fnName, arity);
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (SymbolKey.TO_STRING_TAG.equals(k)) {
            return 8;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 3: {
                final int c = s.charAt(0);
                if (c == 103) {
                    if (s.charAt(2) == 't' && s.charAt(1) == 'e') {
                        id = 3;
                        return id;
                    }
                    break;
                }
                else if (c == 104) {
                    if (s.charAt(2) == 's' && s.charAt(1) == 'a') {
                        id = 4;
                        return id;
                    }
                    break;
                }
                else {
                    if (c == 115 && s.charAt(2) == 't' && s.charAt(1) == 'e') {
                        id = 5;
                        return id;
                    }
                    break;
                }
                break;
            }
            case 6: {
                final int c = s.charAt(0);
                if (c == 100) {
                    X = "delete";
                    id = 2;
                    break;
                }
                if (c == 117) {
                    X = "upsert";
                    id = 7;
                    break;
                }
                break;
            }
            case 9: {
                X = "deleteAll";
                id = 6;
                break;
            }
            case 11: {
                X = "constructor";
                id = 1;
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    private void readObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.map = new WeakHashMap<Scriptable, Object>();
    }
    
    static {
        MAP_TAG = "WeakMap";
        NULL_VALUE = new Object();
    }
}
