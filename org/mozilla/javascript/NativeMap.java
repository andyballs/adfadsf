//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class NativeMap extends IdScriptableObject
{
    private static final long serialVersionUID = 1171922614280016891L;
    private static final Object MAP_TAG;
    static final String ITERATOR_TAG = "Map Iterator";
    private static final Object NULL_VALUE;
    private final Hashtable entries;
    private boolean instanceOfMap;
    private static final int ConstructorId_groupBy = -1;
    private static final int ConstructorId_keyBy = -2;
    private static final int Id_constructor = 1;
    private static final int Id_set = 2;
    private static final int Id_get = 3;
    private static final int Id_delete = 4;
    private static final int Id_has = 5;
    private static final int Id_clear = 6;
    private static final int Id_keys = 7;
    private static final int Id_values = 8;
    private static final int Id_entries = 9;
    private static final int Id_forEach = 10;
    private static final int Id_mapKeys = 11;
    private static final int Id_mapValues = 12;
    private static final int Id_keyOf = 13;
    private static final int Id_includes = 14;
    private static final int Id_find = 15;
    private static final int Id_findKey = 16;
    private static final int Id_some = 17;
    private static final int Id_every = 18;
    private static final int Id_reduce = 19;
    private static final int Id_deleteAll = 20;
    private static final int Id_update = 21;
    private static final int Id_filter = 22;
    private static final int Id_merge = 23;
    private static final int Id_upsert = 24;
    private static final int SymbolId_getSize = 25;
    private static final int SymbolId_toStringTag = 26;
    private static final int MAX_PROTOTYPE_ID = 26;
    
    public NativeMap() {
        this.entries = new Hashtable();
        this.instanceOfMap = false;
    }
    
    static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeMap obj = new NativeMap();
        obj.exportAsJSClass(26, scope, false);
        final ScriptableObject desc = (ScriptableObject)cx.newObject(scope);
        desc.put("enumerable", desc, false);
        desc.put("configurable", desc, true);
        desc.put("get", desc, obj.get((Symbol)NativeSet.GETSIZE, (Scriptable)obj));
        obj.defineOwnProperty(cx, (Object)"size", desc);
        if (sealed) {
            obj.sealObject();
        }
    }
    
    public String getClassName() {
        return "Map";
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addIdFunctionProperty((Scriptable)ctor, NativeMap.MAP_TAG, -1, "groupBy", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeMap.MAP_TAG, -2, "keyBy", 1);
        this.addCtorSpecies(ctor);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeMap.MAP_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case -1: {
                return this.js_groupBy(cx, scope, args);
            }
            case -2: {
                return this.js_keyBy(cx, scope, args);
            }
            case 1: {
                return this.js_construct(cx, scope, thisObj, args);
            }
            case 2: {
                return this.realThis(thisObj, f).js_set((args.length > 0) ? args[0] : Undefined.instance, (args.length > 1) ? args[1] : Undefined.instance);
            }
            case 4: {
                return this.realThis(thisObj, f).js_delete((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 3: {
                return this.realThis(thisObj, f).js_get((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 5: {
                return this.realThis(thisObj, f).js_has((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 6: {
                return this.realThis(thisObj, f).js_clear();
            }
            case 7: {
                return this.realThis(thisObj, f).js_iterator(scope, NativeCollectionIterator.Type.KEYS);
            }
            case 8: {
                return this.realThis(thisObj, f).js_iterator(scope, NativeCollectionIterator.Type.VALUES);
            }
            case 9: {
                return this.realThis(thisObj, f).js_iterator(scope, NativeCollectionIterator.Type.BOTH);
            }
            case 10: {
                return this.realThis(thisObj, f).js_forEach(cx, scope, (args.length > 0) ? args[0] : Undefined.instance, (args.length > 1) ? args[1] : Undefined.instance);
            }
            case 11:
            case 12: {
                return this.realThis(thisObj, f).js_map(cx, scope, args, id == 11);
            }
            case 13: {
                return this.realThis(thisObj, f).js_keyOf(args);
            }
            case 14: {
                return this.realThis(thisObj, f).js_includes(args);
            }
            case 15:
            case 16: {
                return this.realThis(thisObj, f).js_find(cx, scope, args, id == 16);
            }
            case 17: {
                return this.realThis(thisObj, f).js_some(cx, scope, args);
            }
            case 18: {
                return this.realThis(thisObj, f).js_every(cx, scope, args);
            }
            case 19: {
                return this.realThis(thisObj, f).js_reduce(cx, scope, args);
            }
            case 20: {
                return this.realThis(thisObj, f).js_deleteAll(args);
            }
            case 21: {
                return this.realThis(thisObj, f).js_update(cx, scope, args);
            }
            case 22: {
                return this.realThis(thisObj, f).js_filter(cx, scope, args);
            }
            case 23: {
                return this.realThis(thisObj, f).js_merge(cx, scope, args);
            }
            case 24: {
                return this.realThis(thisObj, f).js_upsert(cx, scope, args);
            }
            case 25: {
                return this.realThis(thisObj, f).js_getSize();
            }
            default: {
                throw new IllegalArgumentException("Map.prototype has no method: " + f.getFunctionName());
            }
        }
    }
    
    private NativeMap js_construct(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (thisObj == null) {
            final NativeMap nm = new NativeMap();
            nm.instanceOfMap = true;
            if (args.length > 0) {
                loadFromIterable(cx, scope, (ScriptableObject)nm, args[0]);
            }
            return nm;
        }
        throw ScriptRuntime.typeError1("msg.no.new", "Map");
    }
    
    private Object js_groupBy(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeMap map = (NativeMap)species.construct(cx, scope, new Object[0]);
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg2 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg2;
        final ES6Iterator iterator = ScriptRuntime.toIterator(cx, scope, ScriptableObject.ensureScriptable(arg0), false);
        while (true) {
            final Object next = iterator.next(cx, scope);
            if (!(next instanceof Scriptable) || ScriptRuntime.toBoolean(ScriptableObject.getProperty((Scriptable)next, "done"))) {
                return map;
            }
            final Object item = ScriptableObject.getProperty((Scriptable)next, "value");
            final Object key = cb.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { item });
            boolean entryWasFound = false;
            for (final Hashtable.Entry en : map.entries) {
                if (ScriptRuntime.sameZero(en.key, key)) {
                    final Object grouped = en.value;
                    if (!(grouped instanceof NativeArray)) {
                        throw Kit.codeBug("Expected grouped to be a NativeArray");
                    }
                    ScriptableObject.callMethod((Scriptable)grouped, "push", new Object[] { item });
                    entryWasFound = true;
                }
            }
            if (entryWasFound) {
                continue;
            }
            final NativeArray groupedList = cx.newArray(scope, new Object[] { item });
            map.entries.put(key, (Object)groupedList);
        }
    }
    
    private Object js_keyBy(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeMap map = (NativeMap)species.construct(cx, scope, new Object[0]);
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg2 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg2;
        final ES6Iterator iterator = ScriptRuntime.toIterator(cx, scope, ScriptableObject.ensureScriptable(arg0), false);
        while (true) {
            final Object next = iterator.next(cx, scope);
            if (!(next instanceof Scriptable) || ScriptRuntime.toBoolean(ScriptableObject.getProperty((Scriptable)next, "done"))) {
                break;
            }
            final Object item = ScriptableObject.getProperty((Scriptable)next, "value");
            final Object key = cb.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { item });
            map.entries.put(key, item);
        }
        return map;
    }
    
    private Object js_set(final Object k, final Object v) {
        final Object value = (v == null) ? NativeMap.NULL_VALUE : v;
        Object key = k;
        if (key instanceof Number && ((Number)key).doubleValue() == ScriptRuntime.negativeZero) {
            key = 0.0;
        }
        this.entries.put(key, value);
        return this;
    }
    
    private Object js_delete(final Object arg) {
        final Object e = this.entries.delete(arg);
        return e != null;
    }
    
    private Object js_get(final Object arg) {
        final Object val = this.entries.get(arg);
        if (val == null) {
            return Undefined.instance;
        }
        if (val == NativeMap.NULL_VALUE) {
            return null;
        }
        return val;
    }
    
    private boolean js_has(final Object arg) {
        return this.entries.has(arg);
    }
    
    private Object js_getSize() {
        return this.entries.size();
    }
    
    private Object js_iterator(final Scriptable scope, final NativeCollectionIterator.Type type) {
        return new NativeCollectionIterator(scope, "Map Iterator", type, this.entries.iterator());
    }
    
    private Object js_clear() {
        this.entries.clear();
        return Undefined.instance;
    }
    
    private Object js_forEach(final Context cx, final Scriptable scope, final Object arg1, final Object arg2) {
        if (!(arg1 instanceof Callable)) {
            throw ScriptRuntime.typeError2("msg.isnt.function.it.is", arg1, ScriptRuntime.typeof(arg1));
        }
        final Callable f = (Callable)arg1;
        final boolean isStrict = cx.isStrictMode();
        final Iterator<Hashtable.Entry> i = (Iterator<Hashtable.Entry>)this.entries.iterator();
        while (i.hasNext()) {
            Scriptable thisObj = ScriptRuntime.toObjectOrNull(cx, arg2, scope);
            if (thisObj == null && !isStrict) {
                thisObj = scope;
            }
            if (thisObj == null) {
                thisObj = Undefined.SCRIPTABLE_UNDEFINED;
            }
            final Hashtable.Entry e = i.next();
            Object val = e.value;
            if (val == NativeMap.NULL_VALUE) {
                val = null;
            }
            f.call(cx, scope, thisObj, new Object[] { val, e.key, this });
        }
        return Undefined.instance;
    }
    
    private Object js_map(final Context cx, final Scriptable scope, final Object[] args, final boolean keys) {
        final Object cb = (args.length > 0) ? args[0] : null;
        if (!(cb instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable callback = (Callable)cb;
        final BaseFunction species = getSpecies((Scriptable)this);
        if (species == null) {
            throw Kit.codeBug();
        }
        final NativeMap nm = (NativeMap)species.construct(cx, scope, new Object[0]);
        for (final Hashtable.Entry en : this.entries) {
            if (keys) {
                nm.entries.put(callback.call(cx, scope, (Scriptable)this, new Object[] { en.value, en.key, this }), en.value);
            }
            else {
                nm.entries.put(en.key, callback.call(cx, scope, (Scriptable)this, new Object[] { en.value, en.key, this }));
            }
        }
        return nm;
    }
    
    private Object js_keyOf(final Object[] args) {
        final Object searchElement = (args.length > 0) ? args[0] : Undefined.instance;
        for (final Hashtable.Entry en : this.entries) {
            if (ScriptRuntime.shallowEq(searchElement, en.value)) {
                return en.key;
            }
        }
        return Undefined.instance;
    }
    
    private Object js_includes(final Object[] args) {
        final Object searchElement = (args.length > 0) ? args[0] : Undefined.instance;
        for (final Hashtable.Entry en : this.entries) {
            if (ScriptRuntime.sameZero(searchElement, en.value)) {
                return true;
            }
        }
        return false;
    }
    
    private Object js_find(final Context cx, final Scriptable scope, final Object[] args, final boolean key) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(arg0));
        }
        final Callable cb = (Callable)arg0;
        Object thisObj = (args.length > 1) ? args[1] : null;
        if (!(thisObj instanceof Scriptable)) {
            thisObj = Undefined.SCRIPTABLE_UNDEFINED;
        }
        for (final Hashtable.Entry en : this.entries) {
            final boolean result = ScriptRuntime.toBoolean(cb.call(cx, scope, (Scriptable)thisObj, new Object[] { en.value, en.key, this }));
            if (result) {
                return key ? en.key : en.value;
            }
        }
        return Undefined.instance;
    }
    
    private boolean js_some(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(arg0));
        }
        final Callable cb = (Callable)arg0;
        Object thisObj = (args.length > 1) ? args[1] : null;
        if (!(thisObj instanceof Scriptable)) {
            thisObj = Undefined.SCRIPTABLE_UNDEFINED;
        }
        for (final Hashtable.Entry en : this.entries) {
            final boolean result = ScriptRuntime.toBoolean(cb.call(cx, scope, (Scriptable)thisObj, new Object[] { en.value, en.key, this }));
            if (result) {
                return true;
            }
        }
        return false;
    }
    
    private Object js_every(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(arg0));
        }
        final Callable cb = (Callable)arg0;
        Object thisObj = (args.length > 1) ? args[1] : null;
        if (!(thisObj instanceof Scriptable)) {
            thisObj = Undefined.SCRIPTABLE_UNDEFINED;
        }
        for (final Hashtable.Entry en : this.entries) {
            final boolean result = ScriptRuntime.toBoolean(cb.call(cx, scope, (Scriptable)thisObj, new Object[] { en.value, en.key, this }));
            if (!result) {
                return false;
            }
        }
        return true;
    }
    
    private Object js_reduce(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? Undefined.instance : args[0];
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(arg0));
        }
        final Callable cb = (Callable)arg0;
        Object accumulator = (args.length > 1) ? args[1] : Undefined.instance;
        boolean first = true;
        for (final Hashtable.Entry en : this.entries) {
            if (first && Undefined.isUndefined(accumulator)) {
                accumulator = en.value;
            }
            else {
                accumulator = cb.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { accumulator, en.value, en.key, this });
            }
            first = false;
        }
        if (first && Undefined.isUndefined(accumulator)) {
            throw ScriptRuntime.typeError("Map is empty and no accumulator was provided to the reduce method");
        }
        return accumulator;
    }
    
    private Object js_deleteAll(final Object[] args) {
        for (final Object arg : args) {
            this.js_delete(arg);
        }
        return this;
    }
    
    private Object js_update(final Context cx, final Scriptable scope, final Object[] args) {
        final Object key = (args.length == 0) ? Undefined.instance : args[0];
        final Object arg1 = (args.length > 1) ? args[1] : Undefined.instance;
        final Object arg2 = (args.length > 2) ? args[2] : Undefined.instance;
        if (!(arg1 instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(arg1));
        }
        final Callable cb = (Callable)arg1;
        final Callable thunk = (arg2 instanceof Callable) ? ((Callable)arg2) : null;
        final boolean present = this.js_has(key);
        if (!present && !(arg2 instanceof Callable)) {
            throw ScriptRuntime.typeError("Key is not present in map, and no value supplier was provided");
        }
        final Object value = present ? this.js_get(key) : thunk.call(cx, scope, (Scriptable)this, new Object[] { key, this });
        final Object newValue = cb.call(cx, scope, (Scriptable)this, new Object[] { value, key, this });
        this.js_set(key, newValue);
        return this;
    }
    
    private Object js_filter(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeMap map = (NativeMap)species.construct(cx, scope, new Object[0]);
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg0;
        final Scriptable thisObj = (Scriptable)((arg2 instanceof Scriptable) ? arg2 : Undefined.SCRIPTABLE_UNDEFINED);
        for (final Hashtable.Entry en : this.entries) {
            final Object result = cb.call(cx, scope, thisObj, new Object[] { en.value, en.key, this });
            if (ScriptRuntime.toBoolean(result)) {
                map.entries.put(en.key, en.value);
            }
        }
        return map;
    }
    
    private Object js_merge(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeMap map = (NativeMap)species.construct(cx, scope, new Object[0]);
        for (final Hashtable.Entry en : this.entries) {
            map.entries.put(en.key, en.value);
        }
        for (final Object arg : args) {
            if (!(arg instanceof NativeMap)) {
                throw ScriptRuntime.typeError("Expected Map, got " + ScriptRuntime.typeof(arg));
            }
            final NativeMap other = (NativeMap)arg;
            for (final Hashtable.Entry en2 : other.entries) {
                map.entries.put(en2.key, en2.value);
            }
        }
        return map;
    }
    
    private Object js_upsert(final Context cx, final Scriptable scope, final Object[] args) {
        if (args.length == 0) {
            throw ScriptRuntime.typeError("Key must be specified for upsert");
        }
        if (args.length == 1) {
            throw ScriptRuntime.typeError("Update function must be specified for upsert");
        }
        final Object key = args[0];
        final Object updateFnObj = args[1];
        final Object insertFnObj = (args.length > 2) ? args[2] : null;
        if (!(updateFnObj instanceof Callable) && !(insertFnObj instanceof Callable)) {
            throw ScriptRuntime.typeError("The updater and inserter provided to upsert are both not functions");
        }
        final Callable updateFn = (updateFnObj instanceof Callable) ? ((Callable)updateFnObj) : null;
        final Callable insertFn = (insertFnObj instanceof Callable) ? ((Callable)insertFnObj) : null;
        for (final Hashtable.Entry en : this.entries) {
            if (ScriptRuntime.sameZero(en.key, key)) {
                Object value = en.value;
                if (updateFn != null) {
                    value = updateFn.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { value, key, this });
                    this.entries.put(key, value);
                }
                return value;
            }
        }
        if (insertFn != null) {
            final Object insertionValue = insertFn.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { key, this });
            this.entries.put(key, insertionValue);
            return insertionValue;
        }
        return Undefined.instance;
    }
    
    static void loadFromIterable(final Context cx, final Scriptable scope, final ScriptableObject map, final Object arg1) {
        if (arg1 == null || Undefined.instance.equals(arg1)) {
            return;
        }
        final Object ito = ScriptRuntime.callIterator(arg1, cx, scope);
        if (Undefined.instance.equals(ito)) {
            return;
        }
        final ScriptableObject dummy = ensureScriptableObject((Object)cx.newObject(scope, map.getClassName()));
        final Callable set = ScriptRuntime.getPropFunctionAndThis(dummy.getPrototype(), "set", cx, scope);
        ScriptRuntime.lastStoredScriptable(cx);
        try (final IteratorLikeIterable it = new IteratorLikeIterable(cx, scope, ito)) {
            for (final Object val : it) {
                final Scriptable sVal = ScriptableObject.ensureScriptable(val);
                if (sVal instanceof Symbol) {
                    throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(sVal));
                }
                Object finalKey = sVal.get(0, sVal);
                if (finalKey == NativeMap.NOT_FOUND) {
                    finalKey = Undefined.instance;
                }
                Object finalVal = sVal.get(1, sVal);
                if (finalVal == NativeMap.NOT_FOUND) {
                    finalVal = Undefined.instance;
                }
                set.call(cx, scope, (Scriptable)map, new Object[] { finalKey, finalVal });
            }
        }
    }
    
    private NativeMap realThis(final Scriptable thisObj, final IdFunctionObject f) {
        if (thisObj == null) {
            throw incompatibleCallError(f);
        }
        try {
            final NativeMap nm = (NativeMap)ScriptRuntime.unwrapProxy(thisObj);
            if (!nm.instanceOfMap) {
                throw incompatibleCallError(f);
            }
            return nm;
        }
        catch (ClassCastException cce) {
            throw incompatibleCallError(f);
        }
    }
    
    protected void initPrototypeId(final int id) {
        switch (id) {
            case 25: {
                this.initPrototypeMethod(NativeMap.MAP_TAG, id, (Symbol)NativeSet.GETSIZE, "get size", 0);
            }
            case 26: {
                this.initPrototypeValue(26, (Symbol)SymbolKey.TO_STRING_TAG, (Object)this.getClassName(), 3);
            }
            default: {
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
                        arity = 2;
                        s = "set";
                        break;
                    }
                    case 3: {
                        arity = 1;
                        s = "get";
                        break;
                    }
                    case 4: {
                        arity = 1;
                        s = "delete";
                        break;
                    }
                    case 5: {
                        arity = 1;
                        s = "has";
                        break;
                    }
                    case 6: {
                        arity = 0;
                        s = "clear";
                        break;
                    }
                    case 7: {
                        arity = 0;
                        s = "keys";
                        break;
                    }
                    case 8: {
                        arity = 0;
                        s = "values";
                        break;
                    }
                    case 9: {
                        arity = 0;
                        s = "entries";
                        break;
                    }
                    case 10: {
                        arity = 1;
                        s = "forEach";
                        break;
                    }
                    case 11: {
                        arity = 1;
                        s = "mapKeys";
                        break;
                    }
                    case 12: {
                        arity = 1;
                        s = "mapValues";
                        break;
                    }
                    case 13: {
                        arity = 1;
                        s = "keyOf";
                        break;
                    }
                    case 14: {
                        arity = 1;
                        s = "includes";
                        break;
                    }
                    case 15: {
                        arity = 1;
                        s = "find";
                        break;
                    }
                    case 16: {
                        arity = 1;
                        s = "findKey";
                        break;
                    }
                    case 17: {
                        arity = 1;
                        s = "some";
                        break;
                    }
                    case 18: {
                        arity = 1;
                        s = "every";
                        break;
                    }
                    case 19: {
                        arity = 1;
                        s = "reduce";
                        break;
                    }
                    case 20: {
                        arity = 1;
                        s = "deleteAll";
                        break;
                    }
                    case 21: {
                        arity = 1;
                        s = "update";
                        break;
                    }
                    case 22: {
                        arity = 1;
                        s = "filter";
                        break;
                    }
                    case 23: {
                        arity = 1;
                        s = "merge";
                        break;
                    }
                    case 24: {
                        arity = 3;
                        s = "upsert";
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException(String.valueOf(id));
                    }
                }
                this.initPrototypeMethod(NativeMap.MAP_TAG, id, s, fnName, arity);
            }
        }
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (NativeSet.GETSIZE.equals(k)) {
            return 25;
        }
        if (SymbolKey.ITERATOR.equals(k)) {
            return 9;
        }
        if (SymbolKey.TO_STRING_TAG.equals(k)) {
            return 26;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        Label_0603: {
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
                            id = 5;
                            return id;
                        }
                        break;
                    }
                    else {
                        if (c == 115 && s.charAt(2) == 't' && s.charAt(1) == 'e') {
                            id = 2;
                            return id;
                        }
                        break;
                    }
                    break;
                }
                case 4: {
                    final int c = s.charAt(0);
                    if (c == 102) {
                        X = "find";
                        id = 15;
                        break;
                    }
                    if (c == 107) {
                        X = "keys";
                        id = 7;
                        break;
                    }
                    if (c == 115) {
                        X = "some";
                        id = 17;
                        break;
                    }
                    break;
                }
                case 5: {
                    switch (s.charAt(0)) {
                        case 'c': {
                            X = "clear";
                            id = 6;
                            break Label_0603;
                        }
                        case 'e': {
                            X = "every";
                            id = 18;
                            break Label_0603;
                        }
                        case 'k': {
                            X = "keyOf";
                            id = 13;
                            break Label_0603;
                        }
                        case 'm': {
                            X = "merge";
                            id = 23;
                            break Label_0603;
                        }
                        default: {
                            break Label_0603;
                        }
                    }
                    break;
                }
                case 6: {
                    switch (s.charAt(0)) {
                        case 'd': {
                            X = "delete";
                            id = 4;
                            break Label_0603;
                        }
                        case 'f': {
                            X = "filter";
                            id = 22;
                            break Label_0603;
                        }
                        case 'r': {
                            X = "reduce";
                            id = 19;
                            break Label_0603;
                        }
                        case 'u': {
                            final int c = s.charAt(5);
                            if (c == 101) {
                                X = "update";
                                id = 21;
                                break Label_0603;
                            }
                            if (c == 116) {
                                X = "upsert";
                                id = 24;
                                break Label_0603;
                            }
                            break Label_0603;
                        }
                        case 'v': {
                            X = "values";
                            id = 8;
                            break Label_0603;
                        }
                        default: {
                            break Label_0603;
                        }
                    }
                    break;
                }
                case 7: {
                    switch (s.charAt(1)) {
                        case 'a': {
                            X = "mapKeys";
                            id = 11;
                            break Label_0603;
                        }
                        case 'i': {
                            X = "findKey";
                            id = 16;
                            break Label_0603;
                        }
                        case 'n': {
                            X = "entries";
                            id = 9;
                            break Label_0603;
                        }
                        case 'o': {
                            X = "forEach";
                            id = 10;
                            break Label_0603;
                        }
                        default: {
                            break Label_0603;
                        }
                    }
                    break;
                }
                case 8: {
                    X = "includes";
                    id = 14;
                    break;
                }
                case 9: {
                    final int c = s.charAt(0);
                    if (c == 100) {
                        X = "deleteAll";
                        id = 20;
                        break;
                    }
                    if (c == 109) {
                        X = "mapValues";
                        id = 12;
                        break;
                    }
                    break;
                }
                case 11: {
                    X = "constructor";
                    id = 1;
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
        MAP_TAG = "Map";
        NULL_VALUE = new Object();
    }
}
