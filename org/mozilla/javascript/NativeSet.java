//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class NativeSet extends IdScriptableObject
{
    private static final long serialVersionUID = -8442212766987072986L;
    private static final Object SET_TAG;
    static final String ITERATOR_TAG = "Set Iterator";
    static final SymbolKey GETSIZE;
    private final Hashtable entries;
    private boolean instanceOfSet;
    private static final int Id_constructor = 1;
    private static final int Id_add = 2;
    private static final int Id_delete = 3;
    private static final int Id_has = 4;
    private static final int Id_clear = 5;
    private static final int Id_keys = 6;
    private static final int Id_values = 6;
    private static final int Id_entries = 7;
    private static final int Id_forEach = 8;
    private static final int Id_addAll = 9;
    private static final int Id_deleteAll = 10;
    private static final int Id_every = 11;
    private static final int Id_filter = 12;
    private static final int Id_find = 13;
    private static final int Id_join = 14;
    private static final int Id_map = 15;
    private static final int Id_reduce = 16;
    private static final int Id_some = 17;
    private static final int Id_intersection = 18;
    private static final int Id_union = 19;
    private static final int Id_difference = 20;
    private static final int Id_symmetricDifference = 21;
    private static final int Id_isDisjointFrom = 22;
    private static final int Id_isSubsetOf = 23;
    private static final int Id_isSupersetOf = 24;
    private static final int SymbolId_getSize = 25;
    private static final int SymbolId_toStringTag = 26;
    private static final int MAX_PROTOTYPE_ID = 26;
    
    public NativeSet() {
        this.entries = new Hashtable();
        this.instanceOfSet = false;
    }
    
    static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeSet obj = new NativeSet();
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
        return "Set";
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeSet.SET_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                return this.js_constructor(cx, scope, thisObj, (args.length > 0) ? args[0] : Undefined.instance);
            }
            case 2: {
                return this.realThis(thisObj, f).js_add((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 3: {
                return this.realThis(thisObj, f).js_delete((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 4: {
                return this.realThis(thisObj, f).js_has((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 5: {
                return this.realThis(thisObj, f).js_clear();
            }
            case 6: {
                return this.realThis(thisObj, f).js_iterator(scope, NativeCollectionIterator.Type.VALUES);
            }
            case 7: {
                return this.realThis(thisObj, f).js_iterator(scope, NativeCollectionIterator.Type.BOTH);
            }
            case 8: {
                return this.realThis(thisObj, f).js_forEach(cx, scope, (args.length > 0) ? args[0] : Undefined.instance, (args.length > 1) ? args[1] : Undefined.instance);
            }
            case 9: {
                return this.realThis(thisObj, f).js_addAll(args);
            }
            case 10: {
                return this.realThis(thisObj, f).js_deleteAll(args);
            }
            case 11: {
                return this.realThis(thisObj, f).js_every(cx, scope, args);
            }
            case 12: {
                return this.realThis(thisObj, f).js_filter(cx, scope, args);
            }
            case 13: {
                return this.realThis(thisObj, f).js_find(cx, scope, args);
            }
            case 14: {
                return this.realThis(thisObj, f).js_join(args);
            }
            case 15: {
                return this.realThis(thisObj, f).js_map(cx, scope, args);
            }
            case 16: {
                return this.realThis(thisObj, f).js_reduce(cx, scope, args);
            }
            case 17: {
                return this.realThis(thisObj, f).js_some(cx, scope, args);
            }
            case 18: {
                return this.realThis(thisObj, f).js_intersection(cx, scope, args);
            }
            case 19: {
                return this.realThis(thisObj, f).js_union(cx, scope, args);
            }
            case 20: {
                return this.realThis(thisObj, f).js_difference(cx, scope, args);
            }
            case 21: {
                return this.realThis(thisObj, f).js_symmetricDifference(cx, scope, args);
            }
            case 22: {
                return this.realThis(thisObj, f).js_isDisjointFrom(cx, scope, args);
            }
            case 23: {
                return this.realThis(thisObj, f).js_isSubsetOf(cx, scope, args);
            }
            case 24: {
                return this.realThis(thisObj, f).js_isSupersetOf(cx, scope, args);
            }
            case 25: {
                return this.realThis(thisObj, f).js_getSize();
            }
            default: {
                throw new IllegalArgumentException("Set.prototype has no method: " + f.getFunctionName());
            }
        }
    }
    
    private NativeSet js_constructor(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object arg) {
        if (thisObj == null) {
            final NativeSet ns = new NativeSet();
            ns.instanceOfSet = true;
            loadFromIterable(cx, scope, (ScriptableObject)ns, arg);
            return ns;
        }
        throw ScriptRuntime.typeError1("msg.no.new", "Set");
    }
    
    private Object js_add(final Object k) {
        Object key = k;
        if (key instanceof Number && ((Number)key).doubleValue() == ScriptRuntime.negativeZero) {
            key = 0.0;
        }
        this.entries.put(key, key);
        return this;
    }
    
    private boolean js_delete(final Object arg) {
        final Object ov = this.entries.delete(arg);
        return ov != null;
    }
    
    private boolean js_has(final Object arg) {
        return this.entries.has(arg);
    }
    
    private Object js_clear() {
        this.entries.clear();
        return Undefined.instance;
    }
    
    private Object js_getSize() {
        return this.entries.size();
    }
    
    private NativeCollectionIterator js_iterator(final Scriptable scope, final NativeCollectionIterator.Type type) {
        return new NativeCollectionIterator(scope, "Set Iterator", type, this.entries.iterator());
    }
    
    private Object js_forEach(final Context cx, final Scriptable scope, final Object arg1, final Object arg2) {
        if (!(arg1 instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(arg1);
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
            f.call(cx, scope, thisObj, new Object[] { e.value, e.value, this });
        }
        return Undefined.instance;
    }
    
    private Object js_addAll(final Object[] args) {
        for (final Object arg : args) {
            this.js_add(arg);
        }
        return this;
    }
    
    private Object js_deleteAll(final Object[] args) {
        boolean allDeleted = true;
        for (final Object arg : args) {
            allDeleted &= this.js_delete(arg);
        }
        return allDeleted;
    }
    
    private Object js_every(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg0;
        final Scriptable thisObj = (Scriptable)((arg2 instanceof Scriptable) ? arg2 : Undefined.SCRIPTABLE_UNDEFINED);
        for (final Hashtable.Entry en : this.entries) {
            final Object result = cb.call(cx, scope, thisObj, new Object[] { en.key, en.key, this });
            if (!ScriptRuntime.toBoolean(result)) {
                return false;
            }
        }
        return true;
    }
    
    private Object js_filter(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeSet set = (NativeSet)species.construct(cx, scope, new Object[0]);
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg0;
        final Scriptable thisObj = (Scriptable)((arg2 instanceof Scriptable) ? arg2 : Undefined.SCRIPTABLE_UNDEFINED);
        for (final Hashtable.Entry en : this.entries) {
            final Object result = cb.call(cx, scope, thisObj, new Object[] { en.key, en.key, this });
            if (ScriptRuntime.toBoolean(result)) {
                set.entries.put(en.key, en.key);
            }
        }
        return set;
    }
    
    private Object js_find(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg0;
        final Scriptable thisObj = (Scriptable)((arg2 instanceof Scriptable) ? arg2 : Undefined.SCRIPTABLE_UNDEFINED);
        for (final Hashtable.Entry en : this.entries) {
            final Object result = cb.call(cx, scope, thisObj, new Object[] { en.key, en.key, this });
            if (ScriptRuntime.toBoolean(result)) {
                return en.key;
            }
        }
        return Undefined.instance;
    }
    
    private Object js_join(final Object[] args) {
        final String separator = (args.length > 0) ? ScriptRuntime.toString(args[0]) : ",";
        final StringBuilder sb = new StringBuilder();
        for (final Hashtable.Entry en : this.entries) {
            sb.append(ScriptRuntime.toString(en.key)).append(separator);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private Object js_map(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeSet set = (NativeSet)species.construct(cx, scope, new Object[0]);
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg0;
        final Scriptable thisObj = (Scriptable)((arg2 instanceof Scriptable) ? arg2 : Undefined.SCRIPTABLE_UNDEFINED);
        for (final Hashtable.Entry en : this.entries) {
            final Object result = cb.call(cx, scope, thisObj, new Object[] { en.key, en.key, this });
            set.entries.put(result, result);
        }
        return set;
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
                accumulator = cb.call(cx, scope, Undefined.SCRIPTABLE_UNDEFINED, new Object[] { accumulator, en.key, en.key, this });
            }
            first = false;
        }
        if (first && Undefined.isUndefined(accumulator)) {
            throw ScriptRuntime.typeError("Map is empty and no accumulator was provided to the reduce method");
        }
        return accumulator;
    }
    
    private Object js_some(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        final Object arg2 = (args.length > 1) ? args[1] : null;
        if (!(arg0 instanceof Callable)) {
            throw ScriptRuntime.typeError("Callback is not callable");
        }
        final Callable cb = (Callable)arg0;
        final Scriptable thisObj = (Scriptable)((arg2 instanceof Scriptable) ? arg2 : Undefined.SCRIPTABLE_UNDEFINED);
        for (final Hashtable.Entry en : this.entries) {
            final Object result = cb.call(cx, scope, thisObj, new Object[] { en.key, en.key, this });
            if (ScriptRuntime.toBoolean(result)) {
                return true;
            }
        }
        return false;
    }
    
    private Object js_intersection(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeSet set = (NativeSet)species.construct(cx, scope, new Object[0]);
        final Object arg0 = (args.length == 0) ? null : args[0];
        final ES6Iterator it = ScriptRuntime.toIterator(cx, scope, ScriptableObject.ensureScriptable(arg0), false);
        while (!it.isDone(cx, scope)) {
            final Object value = it.nextValue(cx, scope);
            if (this.js_has(value)) {
                set.js_add(value);
            }
        }
        return set;
    }
    
    private Object js_union(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeSet set = (NativeSet)species.construct(cx, scope, new Object[0]);
        final ES6Iterator it = ScriptRuntime.toIterator(cx, scope, (args.length > 0) ? ScriptableObject.ensureScriptable(args[0]) : null, false);
        for (final Hashtable.Entry en : this.entries) {
            set.entries.put(en.key, en.key);
        }
        while (!it.isDone(cx, scope)) {
            final Object value = it.nextValue(cx, scope);
            set.entries.put(value, value);
        }
        return set;
    }
    
    private Object js_difference(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeSet set = (NativeSet)species.construct(cx, scope, new Object[0]);
        for (final Hashtable.Entry en : this.entries) {
            set.entries.put(en.key, en.key);
        }
        final Object arg0 = (args.length == 0) ? null : args[0];
        final ES6Iterator it = ScriptRuntime.toIterator(cx, scope, ScriptableObject.ensureScriptable(arg0), false);
        while (!it.isDone(cx, scope)) {
            final Object value = it.nextValue(cx, scope);
            set.js_delete(value);
        }
        return set;
    }
    
    private Object js_symmetricDifference(final Context cx, final Scriptable scope, final Object[] args) {
        final Function species = (Function)getSpecies((Scriptable)this);
        if (species == null) {
            throw ScriptRuntime.typeError("'this' is not constructable");
        }
        final NativeSet set = (NativeSet)species.construct(cx, scope, new Object[0]);
        for (final Hashtable.Entry en : this.entries) {
            set.entries.put(en.key, en.key);
        }
        final Object arg0 = (args.length == 0) ? null : args[0];
        final ES6Iterator it = ScriptRuntime.toIterator(cx, scope, ScriptableObject.ensureScriptable(arg0), false);
        while (!it.isDone(cx, scope)) {
            final Object value = it.nextValue(cx, scope);
            final boolean removed = set.js_delete(value);
            if (!removed) {
                set.js_add(value);
            }
        }
        return set;
    }
    
    private Object js_isDisjointFrom(final Context cx, final Scriptable scope, final Object[] args) {
        final Object arg0 = (args.length == 0) ? null : args[0];
        final ES6Iterator it = ScriptRuntime.toIterator(cx, scope, ScriptableObject.ensureScriptable(arg0), false);
        while (!it.isDone(cx, scope)) {
            final Object value = it.nextValue(cx, scope);
            if (this.js_has(value)) {
                return false;
            }
        }
        return true;
    }
    
    private Object js_isSubsetOf(final Context cx, final Scriptable scope, final Object[] args) {
        Object arg0 = (args.length == 0) ? null : args[0];
        if (!(arg0 instanceof NativeSet)) {
            arg0 = this.js_constructor(cx, scope, null, arg0);
        }
        final NativeSet other = (NativeSet)arg0;
        for (final Hashtable.Entry en : this.entries) {
            if (!other.entries.has(en.key)) {
                return false;
            }
        }
        return true;
    }
    
    private Object js_isSupersetOf(final Context cx, final Scriptable scope, final Object[] args) {
        Object arg0 = (args.length == 0) ? null : args[0];
        if (!(arg0 instanceof NativeSet)) {
            arg0 = this.js_constructor(cx, scope, null, arg0);
        }
        final NativeSet other = (NativeSet)arg0;
        for (final Hashtable.Entry en : other.entries) {
            if (!this.entries.has(en.key)) {
                return false;
            }
        }
        return true;
    }
    
    static void loadFromIterable(final Context cx, final Scriptable scope, final ScriptableObject set, final Object arg1) {
        if (arg1 == null || Undefined.instance.equals(arg1)) {
            return;
        }
        final Object ito = ScriptRuntime.callIterator(arg1, cx, scope);
        if (Undefined.instance.equals(ito)) {
            return;
        }
        final ScriptableObject dummy = ensureScriptableObject((Object)cx.newObject(scope, set.getClassName()));
        final Callable add = ScriptRuntime.getPropFunctionAndThis(dummy.getPrototype(), "add", cx, scope);
        ScriptRuntime.lastStoredScriptable(cx);
        try (final IteratorLikeIterable it = new IteratorLikeIterable(cx, scope, ito)) {
            for (final Object val : it) {
                final Object finalVal = (val == Scriptable.NOT_FOUND) ? Undefined.instance : val;
                add.call(cx, scope, (Scriptable)set, new Object[] { finalVal });
            }
        }
    }
    
    private NativeSet realThis(final Scriptable thisObj, final IdFunctionObject f) {
        if (thisObj == null) {
            throw incompatibleCallError(f);
        }
        try {
            final NativeSet ns = (NativeSet)ScriptRuntime.unwrapProxy(thisObj);
            if (!ns.instanceOfSet) {
                throw incompatibleCallError(f);
            }
            return ns;
        }
        catch (ClassCastException cce) {
            throw incompatibleCallError(f);
        }
    }
    
    protected void initPrototypeId(final int id) {
        switch (id) {
            case 25: {
                this.initPrototypeMethod(NativeSet.SET_TAG, id, (Symbol)NativeSet.GETSIZE, "get size", 0);
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
                        arity = 1;
                        s = "add";
                        break;
                    }
                    case 3: {
                        arity = 1;
                        s = "delete";
                        break;
                    }
                    case 4: {
                        arity = 1;
                        s = "has";
                        break;
                    }
                    case 5: {
                        arity = 0;
                        s = "clear";
                        break;
                    }
                    case 7: {
                        arity = 0;
                        s = "entries";
                        break;
                    }
                    case 6: {
                        arity = 0;
                        s = "values";
                        break;
                    }
                    case 8: {
                        arity = 1;
                        s = "forEach";
                        break;
                    }
                    case 9: {
                        arity = 0;
                        s = "addAll";
                        break;
                    }
                    case 10: {
                        arity = 1;
                        s = "deleteAll";
                        break;
                    }
                    case 11: {
                        arity = 1;
                        s = "every";
                        break;
                    }
                    case 12: {
                        arity = 1;
                        s = "filter";
                        break;
                    }
                    case 13: {
                        arity = 1;
                        s = "find";
                        break;
                    }
                    case 14: {
                        arity = 1;
                        s = "join";
                        break;
                    }
                    case 15: {
                        arity = 1;
                        s = "map";
                        break;
                    }
                    case 16: {
                        arity = 1;
                        s = "reduce";
                        break;
                    }
                    case 17: {
                        arity = 1;
                        s = "some";
                        break;
                    }
                    case 18: {
                        arity = 1;
                        s = "intersection";
                        break;
                    }
                    case 19: {
                        arity = 1;
                        s = "union";
                        break;
                    }
                    case 20: {
                        arity = 1;
                        s = "difference";
                        break;
                    }
                    case 21: {
                        arity = 1;
                        s = "symmetricDifference";
                        break;
                    }
                    case 22: {
                        arity = 1;
                        s = "isDisjointFrom";
                        break;
                    }
                    case 23: {
                        arity = 1;
                        s = "isSubsetOf";
                        break;
                    }
                    case 24: {
                        arity = 1;
                        s = "isSupersetOf";
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException(String.valueOf(id));
                    }
                }
                this.initPrototypeMethod(NativeSet.SET_TAG, id, s, fnName, arity);
            }
        }
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (NativeSet.GETSIZE.equals(k)) {
            return 25;
        }
        if (SymbolKey.ITERATOR.equals(k)) {
            return 6;
        }
        if (SymbolKey.TO_STRING_TAG.equals(k)) {
            return 26;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        Label_0614: {
            switch (s.length()) {
                case 3: {
                    final int c = s.charAt(0);
                    if (c == 97) {
                        if (s.charAt(2) == 'd' && s.charAt(1) == 'd') {
                            id = 2;
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
                        if (c == 109 && s.charAt(2) == 'p' && s.charAt(1) == 'a') {
                            id = 15;
                            return id;
                        }
                        break;
                    }
                    break;
                }
                case 4: {
                    switch (s.charAt(0)) {
                        case 'f': {
                            X = "find";
                            id = 13;
                            break Label_0614;
                        }
                        case 'j': {
                            X = "join";
                            id = 14;
                            break Label_0614;
                        }
                        case 'k': {
                            X = "keys";
                            id = 6;
                            break Label_0614;
                        }
                        case 's': {
                            X = "some";
                            id = 17;
                            break Label_0614;
                        }
                        default: {
                            break Label_0614;
                        }
                    }
                    break;
                }
                case 5: {
                    final int c = s.charAt(0);
                    if (c == 99) {
                        X = "clear";
                        id = 5;
                        break;
                    }
                    if (c == 101) {
                        X = "every";
                        id = 11;
                        break;
                    }
                    if (c == 117) {
                        X = "union";
                        id = 19;
                        break;
                    }
                    break;
                }
                case 6: {
                    switch (s.charAt(0)) {
                        case 'a': {
                            X = "addAll";
                            id = 9;
                            break Label_0614;
                        }
                        case 'd': {
                            X = "delete";
                            id = 3;
                            break Label_0614;
                        }
                        case 'f': {
                            X = "filter";
                            id = 12;
                            break Label_0614;
                        }
                        case 'r': {
                            X = "reduce";
                            id = 16;
                            break Label_0614;
                        }
                        case 'v': {
                            X = "values";
                            id = 6;
                            break Label_0614;
                        }
                        default: {
                            break Label_0614;
                        }
                    }
                    break;
                }
                case 7: {
                    final int c = s.charAt(0);
                    if (c == 101) {
                        X = "entries";
                        id = 7;
                        break;
                    }
                    if (c == 102) {
                        X = "forEach";
                        id = 8;
                        break;
                    }
                    break;
                }
                case 9: {
                    X = "deleteAll";
                    id = 10;
                    break;
                }
                case 10: {
                    final int c = s.charAt(0);
                    if (c == 100) {
                        X = "difference";
                        id = 20;
                        break;
                    }
                    if (c == 105) {
                        X = "isSubsetOf";
                        id = 23;
                        break;
                    }
                    break;
                }
                case 11: {
                    X = "constructor";
                    id = 1;
                    break;
                }
                case 12: {
                    final int c = s.charAt(1);
                    if (c == 110) {
                        X = "intersection";
                        id = 18;
                        break;
                    }
                    if (c == 115) {
                        X = "isSupersetOf";
                        id = 24;
                        break;
                    }
                    break;
                }
                case 14: {
                    X = "isDisjointFrom";
                    id = 22;
                    break;
                }
                case 19: {
                    X = "symmetricDifference";
                    id = 21;
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
        SET_TAG = "Set";
        GETSIZE = new SymbolKey("[Symbol.getSize]");
    }
}
