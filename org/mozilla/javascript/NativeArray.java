//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.regexp.*;
import org.mozilla.javascript.proxy.*;
import java.lang.reflect.*;
import java.util.*;

public class NativeArray extends IdScriptableObject implements List
{
    private static final long serialVersionUID = 7331366857676127338L;
    private static final Object ARRAY_TAG;
    private static final Long NEGATIVE_ONE;
    private static final int Id_length = 1;
    private static final int Id_lastIndex = 2;
    private static final int Id_lastItem = 3;
    private static final int MAX_INSTANCE_ID = 1;
    private static final Comparator<Object> STRING_COMPARATOR;
    private static final Comparator<Object> DEFAULT_COMPARATOR;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_join = 5;
    private static final int Id_reverse = 6;
    private static final int Id_sort = 7;
    private static final int Id_push = 8;
    private static final int Id_pop = 9;
    private static final int Id_shift = 10;
    private static final int Id_unshift = 11;
    private static final int Id_splice = 12;
    private static final int Id_concat = 13;
    private static final int Id_slice = 14;
    private static final int Id_indexOf = 15;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_every = 17;
    private static final int Id_filter = 18;
    private static final int Id_forEach = 19;
    private static final int Id_map = 20;
    private static final int Id_some = 21;
    private static final int Id_find = 22;
    private static final int Id_findIndex = 23;
    private static final int Id_reduce = 24;
    private static final int Id_reduceRight = 25;
    private static final int Id_fill = 26;
    private static final int Id_keys = 27;
    private static final int Id_values = 28;
    private static final int Id_entries = 29;
    private static final int Id_includes = 30;
    private static final int Id_copyWithin = 31;
    private static final int SymbolId_iterator = 32;
    private static final int MAX_PROTOTYPE_ID = 32;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_unshift = -11;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_find = -22;
    private static final int ConstructorId_findIndex = -23;
    private static final int ConstructorId_reduce = -24;
    private static final int ConstructorId_reduceRight = -25;
    private static final int ConstructorId_isArray = -26;
    private static final int ConstructorId_of = -27;
    private static final int ConstructorId_from = -28;
    private static final int ConstructorId_isTemplateObject = -29;
    private long length;
    private int lengthAttr;
    private Object[] dense;
    private boolean denseOnly;
    private boolean templateObj;
    private static int maximumInitialCapacity;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeArray obj = new NativeArray(0L);
        final IdFunctionObject ctor = obj.exportAsJSClass(32, scope, sealed);
    }
    
    static int getMaximumInitialCapacity() {
        return NativeArray.maximumInitialCapacity;
    }
    
    static void setMaximumInitialCapacity(final int maximumInitialCapacity) {
        NativeArray.maximumInitialCapacity = maximumInitialCapacity;
    }
    
    public NativeArray(final long lengthArg) {
        this.lengthAttr = 6;
        this.templateObj = false;
        this.denseOnly = (lengthArg <= NativeArray.maximumInitialCapacity);
        if (this.denseOnly) {
            int intLength = (int)lengthArg;
            if (intLength < 10) {
                intLength = 10;
            }
            Arrays.fill(this.dense = new Object[intLength], Scriptable.NOT_FOUND);
        }
        this.length = lengthArg;
    }
    
    public NativeArray(final Object[] array) {
        this.lengthAttr = 6;
        this.templateObj = false;
        this.denseOnly = true;
        this.dense = array;
        this.length = array.length;
    }
    
    public String getClassName() {
        return "Array";
    }
    
    protected int getMaxInstanceId() {
        return 1;
    }
    
    protected void setInstanceIdAttributes(final int id, final int attr) {
        if (id == 1) {
            this.lengthAttr = attr;
        }
    }
    
    protected int findInstanceIdInfo(final String s) {
        switch (s) {
            case "length": {
                return instanceIdInfo(this.lengthAttr, 1);
            }
            case "lastItem": {
                return instanceIdInfo(6, 3);
            }
            case "lastIndex": {
                return instanceIdInfo(7, 2);
            }
            default: {
                return super.findInstanceIdInfo(s);
            }
        }
    }
    
    protected String getInstanceIdName(final int id) {
        if (id == 1) {
            return "length";
        }
        if (id == 2) {
            return "lastIndex";
        }
        if (id == 3) {
            return "lastItem";
        }
        return super.getInstanceIdName(id);
    }
    
    protected Object getInstanceIdValue(final int id) {
        if (id == 1) {
            return ScriptRuntime.wrapNumber((double)this.length);
        }
        if (id == 2) {
            return ScriptRuntime.wrapNumber((this.length > 0L) ? ((double)(this.length - 1L)) : 0.0);
        }
        if (id != 3) {
            return super.getInstanceIdValue(id);
        }
        if (this.length == 0L) {
            return Undefined.instance;
        }
        final int index = (int)(this.length - 1L);
        return this.denseOnly ? this.dense[index] : getElem((Scriptable)this, index);
    }
    
    protected void setInstanceIdValue(final int id, final Object value) {
        if (id == 1) {
            this.setLength(value);
            return;
        }
        if (id == 2) {
            return;
        }
        if (id == 3) {
            final int index = (int)((this.length > 0L) ? (this.length - 1L) : this.length);
            if (this.denseOnly && this.ensureCapacity(index + 1)) {
                this.dense[index] = value;
            }
            setElem((Scriptable)this, index, value);
            setLengthProperty((Scriptable)this, this.length = index + 1);
            return;
        }
        super.setInstanceIdValue(id, value);
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -5, "join", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -6, "reverse", 0);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -7, "sort", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -8, "push", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -9, "pop", 0);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -10, "shift", 0);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -11, "unshift", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -12, "splice", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -13, "concat", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -14, "slice", 2);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -15, "indexOf", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -16, "lastIndexOf", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -17, "every", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -18, "filter", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -19, "forEach", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -20, "map", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -21, "some", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -22, "find", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -23, "findIndex", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -24, "reduce", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -25, "reduceRight", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -26, "isArray", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -27, "of", 0);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -28, "from", 1);
        this.addIdFunctionProperty((Scriptable)ctor, NativeArray.ARRAY_TAG, -29, "isTemplateObject", 1);
        this.addCtorSpecies(ctor);
        super.fillConstructorProperties(ctor);
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 32) {
            this.initPrototypeMethod(NativeArray.ARRAY_TAG, id, (Symbol)SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
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
                s = "toLocaleString";
                break;
            }
            case 4: {
                arity = 0;
                s = "toSource";
                break;
            }
            case 5: {
                arity = 1;
                s = "join";
                break;
            }
            case 6: {
                arity = 0;
                s = "reverse";
                break;
            }
            case 7: {
                arity = 1;
                s = "sort";
                break;
            }
            case 8: {
                arity = 1;
                s = "push";
                break;
            }
            case 9: {
                arity = 0;
                s = "pop";
                break;
            }
            case 10: {
                arity = 0;
                s = "shift";
                break;
            }
            case 11: {
                arity = 1;
                s = "unshift";
                break;
            }
            case 12: {
                arity = 2;
                s = "splice";
                break;
            }
            case 13: {
                arity = 1;
                s = "concat";
                break;
            }
            case 14: {
                arity = 2;
                s = "slice";
                break;
            }
            case 15: {
                arity = 1;
                s = "indexOf";
                break;
            }
            case 16: {
                arity = 1;
                s = "lastIndexOf";
                break;
            }
            case 17: {
                arity = 1;
                s = "every";
                break;
            }
            case 18: {
                arity = 1;
                s = "filter";
                break;
            }
            case 19: {
                arity = 1;
                s = "forEach";
                break;
            }
            case 20: {
                arity = 1;
                s = "map";
                break;
            }
            case 21: {
                arity = 1;
                s = "some";
                break;
            }
            case 22: {
                arity = 1;
                s = "find";
                break;
            }
            case 23: {
                arity = 1;
                s = "findIndex";
                break;
            }
            case 24: {
                arity = 1;
                s = "reduce";
                break;
            }
            case 25: {
                arity = 1;
                s = "reduceRight";
                break;
            }
            case 26: {
                arity = 1;
                s = "fill";
                break;
            }
            case 27: {
                arity = 0;
                s = "keys";
                break;
            }
            case 28: {
                arity = 0;
                s = "values";
                break;
            }
            case 29: {
                arity = 0;
                s = "entries";
                break;
            }
            case 30: {
                arity = 1;
                s = "includes";
                break;
            }
            case 31: {
                arity = 2;
                s = "copyWithin";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeArray.ARRAY_TAG, id, s, fnName, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, Scriptable thisObj, Object[] args) {
        if (!f.hasTag(NativeArray.ARRAY_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        int id = f.methodId();
        while (true) {
            switch (id) {
                case -25:
                case -24:
                case -23:
                case -22:
                case -21:
                case -20:
                case -19:
                case -18:
                case -17:
                case -16:
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
                        thisObj = ScriptRuntime.toObject(cx, scope, args[0]);
                        final Object[] newArgs = new Object[args.length - 1];
                        for (int i = 0; i < newArgs.length; ++i) {
                            newArgs[i] = args[i + 1];
                        }
                        args = newArgs;
                    }
                    id = -id;
                    continue;
                }
                case -26: {
                    return args.length > 0 && js_isArray(args[0]);
                }
                case -27: {
                    return js_of(cx, scope, thisObj, args);
                }
                case -28: {
                    return js_from(cx, scope, thisObj, args);
                }
                case -29: {
                    return args.length > 0 && args[0] instanceof NativeArray && ((NativeArray)args[0]).isTemplateObj();
                }
                case 1: {
                    final boolean inNewExpr = thisObj == null;
                    if (!inNewExpr) {
                        return f.construct(cx, scope, args);
                    }
                    return jsConstructor(cx, scope, args);
                }
                case 2: {
                    return toStringHelper(cx, scope, thisObj, cx.hasFeature(3), false);
                }
                case 3: {
                    return toStringHelper(cx, scope, thisObj, false, true);
                }
                case 4: {
                    return toStringHelper(cx, scope, thisObj, true, false);
                }
                case 5: {
                    return js_join(cx, thisObj, args);
                }
                case 6: {
                    return js_reverse(cx, thisObj, args);
                }
                case 7: {
                    return js_sort(cx, scope, thisObj, args);
                }
                case 8: {
                    return js_push(cx, thisObj, args);
                }
                case 9: {
                    return js_pop(cx, thisObj, args);
                }
                case 10: {
                    return js_shift(cx, thisObj, args);
                }
                case 11: {
                    return js_unshift(cx, thisObj, args);
                }
                case 12: {
                    return js_splice(cx, scope, thisObj, args);
                }
                case 13: {
                    return js_concat(cx, scope, thisObj, args);
                }
                case 14: {
                    return this.js_slice(cx, thisObj, args);
                }
                case 15: {
                    return js_indexOf(cx, scope, thisObj, args);
                }
                case 16: {
                    return js_lastIndexOf(cx, scope, thisObj, args);
                }
                case 30: {
                    return js_includes(cx, scope, thisObj, args);
                }
                case 26: {
                    return js_fill(cx, scope, thisObj, args);
                }
                case 31: {
                    return js_copyWithin(cx, scope, thisObj, args);
                }
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23: {
                    return iterativeMethod(cx, f, scope, thisObj, args);
                }
                case 24:
                case 25: {
                    return reduceMethod(cx, id, scope, thisObj, args);
                }
                case 27: {
                    thisObj = ScriptRuntime.toObject(cx, scope, thisObj);
                    return new NativeArrayIterator(scope, thisObj, NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS);
                }
                case 29: {
                    thisObj = ScriptRuntime.toObject(cx, scope, thisObj);
                    return new NativeArrayIterator(scope, thisObj, NativeArrayIterator.ARRAY_ITERATOR_TYPE.ENTRIES);
                }
                case 28:
                case 32: {
                    thisObj = ScriptRuntime.toObject(cx, scope, thisObj);
                    NativeArrayIterator.ARRAY_ITERATOR_TYPE type = NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES;
                    if (args.length > 0 && args[0] instanceof Boolean && (boolean)args[0]) {
                        type = NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS;
                    }
                    return new NativeArrayIterator(scope, thisObj, type);
                }
                default: {
                    throw new IllegalArgumentException("Array.prototype has no method: " + f.getFunctionName());
                }
            }
        }
    }
    
    public Object get(final int index, final Scriptable start) {
        if (!this.denseOnly && this.isGetterOrSetter((String)null, index, false)) {
            return super.get(index, start);
        }
        if (this.dense != null && 0 <= index && index < this.dense.length) {
            return this.dense[index];
        }
        return super.get(index, start);
    }
    
    public boolean has(final int index, final Scriptable start) {
        if (!this.denseOnly && this.isGetterOrSetter((String)null, index, false)) {
            return super.has(index, start);
        }
        if (this.dense != null && 0 <= index && index < this.dense.length) {
            return this.dense[index] != NativeArray.NOT_FOUND;
        }
        return super.has(index, start);
    }
    
    private static long toArrayIndex(final Object id) {
        if (id instanceof String) {
            return toArrayIndex((String)id);
        }
        if (id instanceof Number) {
            return toArrayIndex(((Number)id).doubleValue());
        }
        return -1L;
    }
    
    private static long toArrayIndex(final String id) {
        final long index = toArrayIndex(ScriptRuntime.toNumber(id));
        if (Long.toString(index).equals(id)) {
            return index;
        }
        return -1L;
    }
    
    private static long toArrayIndex(final double d) {
        if (!Double.isNaN(d)) {
            final long index = ScriptRuntime.toUint32(d);
            if (index == d && index != 4294967295L) {
                return index;
            }
        }
        return -1L;
    }
    
    private static int toDenseIndex(final Object id) {
        final long index = toArrayIndex(id);
        return (0L <= index && index < 2147483647L) ? ((int)index) : -1;
    }
    
    public void put(final String id, final Scriptable start, final Object value) {
        super.put(id, start, value);
        if (start == this) {
            final long index = toArrayIndex(id);
            if (index >= this.length) {
                this.length = index + 1L;
                this.denseOnly = false;
            }
        }
    }
    
    private boolean ensureCapacity(int capacity) {
        if (capacity > this.dense.length) {
            if (capacity > 1431655764) {
                return this.denseOnly = false;
            }
            capacity = Math.max(capacity, (int)(this.dense.length * 1.5));
            final Object[] newDense = new Object[capacity];
            System.arraycopy(this.dense, 0, newDense, 0, this.dense.length);
            Arrays.fill(newDense, this.dense.length, newDense.length, Scriptable.NOT_FOUND);
            this.dense = newDense;
        }
        return true;
    }
    
    public void put(final int index, final Scriptable start, final Object value) {
        if (start == this && !this.isSealed() && this.dense != null && 0 <= index && (this.denseOnly || !this.isGetterOrSetter((String)null, index, true))) {
            if (!this.isExtensible() && this.length <= index) {
                return;
            }
            if (index < this.dense.length) {
                this.dense[index] = value;
                if (this.length <= index) {
                    this.length = index + 1L;
                }
                return;
            }
            if (this.denseOnly && index < this.dense.length * 1.5 && this.ensureCapacity(index + 1)) {
                this.dense[index] = value;
                this.length = index + 1L;
                return;
            }
            this.denseOnly = false;
        }
        super.put(index, start, value);
        if (start == this && (this.lengthAttr & 0x1) == 0x0 && this.length <= index) {
            this.length = index + 1L;
        }
    }
    
    public void delete(final int index) {
        if (this.dense != null && 0 <= index && index < this.dense.length && !this.isSealed() && (this.denseOnly || !this.isGetterOrSetter((String)null, index, true))) {
            this.dense[index] = NativeArray.NOT_FOUND;
        }
        else {
            super.delete(index);
        }
    }
    
    public Object[] getIds(final boolean nonEnumerable, final boolean getSymbols) {
        final Object[] superIds = super.getIds(nonEnumerable, getSymbols);
        if (this.dense == null) {
            return superIds;
        }
        int N = this.dense.length;
        final long currentLength = this.length;
        if (N > currentLength) {
            N = (int)currentLength;
        }
        if (N == 0) {
            return superIds;
        }
        final int superLength = superIds.length;
        Object[] ids = new Object[N + superLength];
        int presentCount = 0;
        for (int i = 0; i != N; ++i) {
            if (this.dense[i] != NativeArray.NOT_FOUND) {
                ids[presentCount] = i;
                ++presentCount;
            }
        }
        if (presentCount != N) {
            final Object[] tmp = new Object[presentCount + superLength];
            System.arraycopy(ids, 0, tmp, 0, presentCount);
            ids = tmp;
        }
        System.arraycopy(superIds, 0, ids, presentCount, superLength);
        return ids;
    }
    
    public List<Integer> getIndexIds() {
        final Object[] ids = this.getIds();
        final List<Integer> indices = new ArrayList<Integer>(ids.length);
        for (final Object id : ids) {
            final int int32Id = ScriptRuntime.toInt32(id);
            if (int32Id >= 0 && ScriptRuntime.toString(int32Id).equals(ScriptRuntime.toString(id))) {
                indices.add(int32Id);
            }
        }
        return indices;
    }
    
    public Object getDefaultValue(final Class<?> hint) {
        if (hint == ScriptRuntime.NumberClass) {
            final Context cx = Context.getContext();
            if (cx.getLanguageVersion() == 120) {
                return this.length;
            }
        }
        return super.getDefaultValue((Class)hint);
    }
    
    private ScriptableObject defaultIndexPropertyDescriptor(final Object value) {
        Scriptable scope = this.getParentScope();
        if (scope == null) {
            scope = (Scriptable)this;
        }
        final ScriptableObject desc = (ScriptableObject)new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(desc, scope, TopLevel.Builtins.Object);
        desc.defineProperty("value", value, 0);
        desc.defineProperty("writable", true, 0);
        desc.defineProperty("enumerable", true, 0);
        desc.defineProperty("configurable", true, 0);
        return desc;
    }
    
    public int getAttributes(final int index) {
        if (this.dense != null && index >= 0 && index < this.dense.length && this.dense[index] != NativeArray.NOT_FOUND) {
            return 0;
        }
        return super.getAttributes(index);
    }
    
    public ScriptableObject getOwnPropertyDescriptor(final Context cx, final Object id) {
        if (this.dense != null) {
            final int index = toDenseIndex(id);
            if (0 <= index && index < this.dense.length && this.dense[index] != NativeArray.NOT_FOUND) {
                final Object value = this.dense[index];
                return this.defaultIndexPropertyDescriptor(value);
            }
        }
        return super.getOwnPropertyDescriptor(cx, id);
    }
    
    protected void defineOwnProperty(final Context cx, final Object id, final ScriptableObject desc, final boolean checkValid) {
        if (this.dense != null) {
            final Object[] values = this.dense;
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < values.length; ++i) {
                if (values[i] != NativeArray.NOT_FOUND) {
                    this.put(i, (Scriptable)this, values[i]);
                }
            }
        }
        final long index = toArrayIndex(id);
        if (index >= this.length) {
            this.length = index + 1L;
        }
        super.defineOwnProperty(cx, id, desc, checkValid);
    }
    
    protected void checkObjectPropertyRestrictions(final Object id, final ScriptableObject desc) {
        if ("length".equals(id)) {
            final Object value = desc.get("value", desc);
            if (Undefined.isUndefined(value)) {
                throw ScriptRuntime.rangeError("Invalid array length");
            }
            if (value == null) {
                ScriptableObject.putProperty(desc, "value", 0);
            }
        }
    }
    
    private static Object jsConstructor(final Context cx, final Scriptable scope, final Object[] args) {
        if (args.length == 0) {
            return new NativeArray(0L);
        }
        if (cx.getLanguageVersion() == 120) {
            return new NativeArray(args);
        }
        final Object arg0 = args[0];
        if (args.length > 1 || !(arg0 instanceof Number)) {
            return new NativeArray(args);
        }
        final long len = ScriptRuntime.toUint32(arg0);
        if (len != ((Number)arg0).doubleValue()) {
            final String msg = ScriptRuntime.getMessage0("msg.arraylength.bad");
            throw ScriptRuntime.constructError("RangeError", msg);
        }
        return new NativeArray(len);
    }
    
    private static Scriptable callConstructorOrCreateArray(final Context cx, final Scriptable scope, final Scriptable arg, final long length, final boolean lengthAlways) {
        Scriptable result = null;
        if (arg instanceof Function) {
            try {
                final Object[] args = (lengthAlways || length > 0L) ? new Object[] { length } : ScriptRuntime.emptyArgs;
                result = ((Function)arg).construct(cx, scope, args);
            }
            catch (EcmaError ee) {
                if (!"TypeError".equals(ee.getName())) {
                    throw ee;
                }
            }
        }
        if (result == null) {
            result = cx.newArray(scope, (length > 2147483647L) ? 0 : ((int)length));
        }
        return result;
    }
    
    private static Object js_from(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Scriptable items = ScriptRuntime.toObject(scope, (args.length >= 1) ? args[0] : Undefined.instance);
        final Object mapArg = (args.length >= 2) ? args[1] : Undefined.instance;
        Scriptable thisArg = Undefined.SCRIPTABLE_UNDEFINED;
        final boolean mapping = !Undefined.isUndefined(mapArg);
        Function mapFn = null;
        if (mapping) {
            if (!(mapArg instanceof Function)) {
                throw ScriptRuntime.typeError0("msg.map.function.not");
            }
            mapFn = (Function)mapArg;
            if (args.length >= 3) {
                thisArg = ensureScriptable(args[2]);
            }
        }
        final Object iteratorProp = ScriptableObject.getProperty(items, SymbolKey.ITERATOR);
        if (!(items instanceof NativeArray) && iteratorProp != Scriptable.NOT_FOUND && !Undefined.isUndefined(iteratorProp)) {
            final Object iterator = ScriptRuntime.callIterator(items, cx, scope);
            if (!Undefined.isUndefined(iterator)) {
                final Scriptable result = callConstructorOrCreateArray(cx, scope, thisObj, 0L, false);
                long k = 0L;
                try (final IteratorLikeIterable it = new IteratorLikeIterable(cx, scope, iterator)) {
                    for (Object temp : it) {
                        if (mapping) {
                            temp = mapFn.call(cx, scope, thisArg, new Object[] { temp, k });
                        }
                        defineElem(cx, result, k, temp);
                        ++k;
                    }
                }
                setLengthProperty(result, k);
                return result;
            }
        }
        final long length = getLengthProperty(items, false);
        final Scriptable result2 = callConstructorOrCreateArray(cx, scope, thisObj, length, true);
        for (long i = 0L; i < length; ++i) {
            Object temp2 = getRawElem(items, i);
            if (temp2 != Scriptable.NOT_FOUND) {
                if (mapping) {
                    temp2 = mapFn.call(cx, scope, thisArg, new Object[] { temp2, i });
                }
                defineElem(cx, result2, i, temp2);
            }
        }
        setLengthProperty(result2, length);
        return result2;
    }
    
    private static Object js_of(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Scriptable result = callConstructorOrCreateArray(cx, scope, thisObj, args.length, true);
        for (int i = 0; i < args.length; ++i) {
            defineElem(cx, result, i, args[i]);
        }
        setLengthProperty(result, args.length);
        return result;
    }
    
    public long getLength() {
        return this.length;
    }
    
    @Deprecated
    public long jsGet_length() {
        return this.getLength();
    }
    
    void setDenseOnly(final boolean denseOnly) {
        if (denseOnly && !this.denseOnly) {
            throw new IllegalArgumentException();
        }
        this.denseOnly = denseOnly;
    }
    
    private void setLength(final Object val) {
        if ((this.lengthAttr & 0x1) != 0x0) {
            return;
        }
        final double d = ScriptRuntime.toNumber(val);
        final long longVal = ScriptRuntime.toUint32(d);
        if (longVal != d) {
            final String msg = ScriptRuntime.getMessage0("msg.arraylength.bad");
            throw ScriptRuntime.constructError("RangeError", msg);
        }
        if (this.denseOnly) {
            if (longVal < this.length) {
                Arrays.fill(this.dense, (int)longVal, this.dense.length, NativeArray.NOT_FOUND);
                this.length = longVal;
                return;
            }
            if (longVal < 1431655764L && longVal < this.length * 1.5 && this.ensureCapacity((int)longVal)) {
                this.length = longVal;
                return;
            }
            this.denseOnly = false;
        }
        if (longVal < this.length) {
            if (this.length - longVal > 4096L) {
                final Object[] e = this.getIds();
                for (int i = 0; i < e.length; ++i) {
                    final Object id = e[i];
                    if (id instanceof String) {
                        final String strId = (String)id;
                        final long index = toArrayIndex(strId);
                        if (index >= longVal) {
                            this.delete(strId);
                        }
                    }
                    else {
                        final int index2 = (int)id;
                        if (index2 >= longVal) {
                            this.delete(index2);
                        }
                    }
                }
            }
            else {
                for (long j = longVal; j < this.length; ++j) {
                    deleteElem((Scriptable)this, j);
                }
            }
        }
        this.length = longVal;
    }
    
    static long getLengthProperty(final Scriptable obj, final boolean throwIfTooLarge, final boolean asUint32) {
        if (obj instanceof NativeString) {
            return ((NativeString)obj).getLength();
        }
        if (obj instanceof NativeArray) {
            return ((NativeArray)obj).getLength();
        }
        final Object len = ScriptableObject.getProperty(obj, "length");
        if (len == Scriptable.NOT_FOUND) {
            return 0L;
        }
        final double doubleLen = ScriptRuntime.toNumber(len);
        if (doubleLen > 9.007199254740991E15) {
            if (throwIfTooLarge) {
                final String msg = ScriptRuntime.getMessage0("msg.arraylength.bad");
                throw ScriptRuntime.constructError("RangeError", msg);
            }
            return 9007199254740991L;
        }
        else {
            if (doubleLen < 0.0) {
                return 0L;
            }
            if (asUint32) {
                return ScriptRuntime.toUint32(len);
            }
            return (long)ScriptRuntime.toNumber(len);
        }
    }
    
    static long getLengthProperty(final Scriptable obj, final boolean throwIfTooLarge) {
        return getLengthProperty(obj, throwIfTooLarge, true);
    }
    
    private static Object setLengthProperty(final Scriptable target, final long length) {
        final Object len = ScriptRuntime.wrapNumber((double)length);
        ScriptableObject.putProperty(target, "length", len);
        return len;
    }
    
    private static void deleteElem(final Scriptable target, final long index) {
        final int i = (int)index;
        if (i == index) {
            target.delete(i);
        }
        else {
            target.delete(Long.toString(index));
        }
    }
    
    private static Object getElem(final Scriptable target, final long index) {
        final Object elem = getRawElem(target, index);
        return (elem != Scriptable.NOT_FOUND) ? elem : Undefined.instance;
    }
    
    private static Object getRawElem(final Scriptable target, final long index) {
        if (index > 2147483647L) {
            return ScriptableObject.getProperty(target, Long.toString(index));
        }
        return ScriptableObject.getProperty(target, (int)index);
    }
    
    private static void defineElem(final Context cx, final Scriptable target, final long index, final Object value) {
        final ScriptableObject so = ScriptableObject.ensureScriptableObject(target);
        final NativeObject obj = cx.newObject(cx.topCallScope);
        ScriptableObject.putProperty((Scriptable)obj, "writable", true);
        ScriptableObject.putProperty((Scriptable)obj, "enumerable", true);
        ScriptableObject.putProperty((Scriptable)obj, "configurable", true);
        ScriptableObject.putProperty((Scriptable)obj, "value", value);
        final Object id = (index > 2147483647L) ? Long.toString(index) : Integer.valueOf((int)index);
        so.defineOwnProperty(cx, id, (ScriptableObject)obj);
    }
    
    private static void setElem(final Scriptable target, final long index, final Object value) {
        if (index > 2147483647L) {
            final String id = Long.toString(index);
            ScriptableObject.putProperty(target, id, value);
        }
        else {
            ScriptableObject.putProperty(target, (int)index, value);
        }
    }
    
    private static void setRawElem(final Scriptable target, final long index, final Object value) {
        if (value == NativeArray.NOT_FOUND) {
            deleteElem(target, index);
        }
        else {
            setElem(target, index, value);
        }
    }
    
    public static String toStringHelper(final Context cx, final Scriptable scope, final Scriptable thisObj, final boolean toSource, final boolean toLocale) {
        final long length = getLengthProperty(thisObj, false);
        final StringBuilder result = new StringBuilder(256);
        String separator;
        if (toSource) {
            result.append('[');
            separator = ", ";
        }
        else {
            separator = ",";
        }
        boolean haslast = false;
        long i = 0L;
        boolean toplevel;
        boolean iterating;
        if (cx.iterating == null) {
            toplevel = true;
            iterating = false;
            cx.iterating = new ObjToIntMap(31);
        }
        else {
            toplevel = false;
            iterating = cx.iterating.has(thisObj);
        }
        try {
            if (!iterating) {
                cx.iterating.put(thisObj, 0);
                final boolean skipUndefinedAndNull = !toSource || cx.getLanguageVersion() < 150;
                for (i = 0L; i < length; ++i) {
                    if (i > 0L) {
                        result.append(separator);
                    }
                    Object elem = getRawElem(thisObj, i);
                    if (elem == NativeArray.NOT_FOUND || (skipUndefinedAndNull && (elem == null || elem == Undefined.instance))) {
                        haslast = false;
                    }
                    else {
                        haslast = true;
                        if (toSource) {
                            result.append(ScriptRuntime.uneval(cx, scope, elem));
                        }
                        else if (elem instanceof String) {
                            final String s = (String)elem;
                            if (toSource) {
                                result.append('\"');
                                result.append(ScriptRuntime.escapeString(s));
                                result.append('\"');
                            }
                            else {
                                result.append(s);
                            }
                        }
                        else {
                            if (toLocale) {
                                final Callable fun = ScriptRuntime.getPropFunctionAndThis(elem, "toLocaleString", cx, scope);
                                final Scriptable funThis = ScriptRuntime.lastStoredScriptable(cx);
                                elem = fun.call(cx, scope, funThis, ScriptRuntime.emptyArgs);
                            }
                            result.append(ScriptRuntime.toString(elem));
                        }
                    }
                }
            }
        }
        finally {
            if (toplevel) {
                cx.iterating = null;
            }
        }
        if (toSource) {
            if (!haslast && i > 0L) {
                result.append(", ]");
            }
            else {
                result.append(']');
            }
        }
        return result.toString();
    }
    
    private static String js_join(final Context cx, final Scriptable thisObj, final Object[] args) {
        final long llength = getLengthProperty(thisObj, false);
        final int length = (int)llength;
        if (llength != length) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", (Object)String.valueOf(llength));
        }
        final String separator = (args.length < 1 || args[0] == Undefined.instance) ? "," : ScriptRuntime.toString(args[0]);
        if (thisObj instanceof NativeArray) {
            final NativeArray na = (NativeArray)thisObj;
            if (na.denseOnly) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < length; ++i) {
                    if (i != 0) {
                        sb.append(separator);
                    }
                    if (i < na.dense.length) {
                        final Object temp = na.dense[i];
                        if (temp != null && temp != Undefined.instance && temp != Scriptable.NOT_FOUND) {
                            sb.append(ScriptRuntime.toString(temp));
                        }
                    }
                }
                return sb.toString();
            }
        }
        if (length == 0) {
            return "";
        }
        final String[] buf = new String[length];
        int total_size = 0;
        for (int i = 0; i != length; ++i) {
            final Object temp = getElem(thisObj, i);
            if (temp != null && temp != Undefined.instance) {
                final String str = ScriptRuntime.toString(temp);
                total_size += str.length();
                buf[i] = str;
            }
        }
        total_size += (length - 1) * separator.length();
        final StringBuilder sb2 = new StringBuilder(total_size);
        for (int j = 0; j != length; ++j) {
            if (j != 0) {
                sb2.append(separator);
            }
            final String str = buf[j];
            if (str != null) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }
    
    private static Scriptable js_reverse(final Context cx, final Scriptable thisObj, final Object[] args) {
        if (thisObj instanceof NativeArray) {
            final NativeArray na = (NativeArray)thisObj;
            if (na.denseOnly) {
                for (int i = 0, j = (int)na.length - 1; i < j; ++i, --j) {
                    final Object temp = na.dense[i];
                    na.dense[i] = na.dense[j];
                    na.dense[j] = temp;
                }
                return thisObj;
            }
        }
        final long len = getLengthProperty(thisObj, false);
        for (long half = len / 2L, k = 0L; k < half; ++k) {
            final long l = len - k - 1L;
            final Object temp2 = getRawElem(thisObj, k);
            final Object temp3 = getRawElem(thisObj, l);
            setRawElem(thisObj, k, temp3);
            setRawElem(thisObj, l, temp2);
        }
        return thisObj;
    }
    
    private static Scriptable js_sort(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        Comparator<Object> comparator;
        if (args.length > 0 && Undefined.instance != args[0]) {
            final Callable jsCompareFunction = ScriptRuntime.getValueFunctionAndThis(args[0], cx);
            final Scriptable funThis = ScriptRuntime.lastStoredScriptable(cx);
            final Object[] cmpBuf = new Object[2];
            comparator = new ElementComparator(new Comparator<Object>() {
                @Override
                public int compare(final Object x, final Object y) {
                    cmpBuf[0] = x;
                    cmpBuf[1] = y;
                    final Object ret = jsCompareFunction.call(cx, scope, funThis, cmpBuf);
                    final double d = ScriptRuntime.toNumber(ret);
                    if (d < 0.0) {
                        return -1;
                    }
                    if (d > 0.0) {
                        return 1;
                    }
                    return 0;
                }
            });
        }
        else {
            comparator = NativeArray.DEFAULT_COMPARATOR;
        }
        final long llength = getLengthProperty(thisObj, false);
        final int length = (int)llength;
        if (llength != length) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", (Object)String.valueOf(llength));
        }
        final Object[] working = new Object[length];
        for (int i = 0; i != length; ++i) {
            working[i] = getRawElem(thisObj, i);
        }
        Sorting.get().hybridSort(working, comparator);
        for (int i = 0; i < length; ++i) {
            setRawElem(thisObj, i, working[i]);
        }
        return thisObj;
    }
    
    private static Object js_push(final Context cx, final Scriptable thisObj, final Object[] args) {
        if (thisObj instanceof NativeArray) {
            final NativeArray na = (NativeArray)thisObj;
            if (na.denseOnly && na.ensureCapacity((int)na.length + args.length)) {
                for (int i = 0; i < args.length; ++i) {
                    na.dense[(int)(na.length++)] = args[i];
                }
                return ScriptRuntime.wrapNumber((double)na.length);
            }
        }
        long length = getLengthProperty(thisObj, false);
        for (int j = 0; j < args.length; ++j) {
            setElem(thisObj, length + j, args[j]);
        }
        length += args.length;
        final Object lengthObj = setLengthProperty(thisObj, length);
        if (cx.getLanguageVersion() == 120) {
            return (args.length == 0) ? Undefined.instance : args[args.length - 1];
        }
        return lengthObj;
    }
    
    private static Object js_pop(final Context cx, final Scriptable thisObj, final Object[] args) {
        if (thisObj instanceof NativeArray) {
            final NativeArray na = (NativeArray)thisObj;
            if (na.denseOnly && na.length > 0L) {
                final NativeArray nativeArray = na;
                --nativeArray.length;
                final Object result = na.dense[(int)na.length];
                na.dense[(int)na.length] = NativeArray.NOT_FOUND;
                return result;
            }
        }
        long length = getLengthProperty(thisObj, false);
        Object result;
        if (length > 0L) {
            --length;
            result = getElem(thisObj, length);
            deleteElem(thisObj, length);
        }
        else {
            result = Undefined.instance;
        }
        setLengthProperty(thisObj, length);
        return result;
    }
    
    private static Object js_shift(final Context cx, final Scriptable thisObj, final Object[] args) {
        if (thisObj instanceof NativeArray) {
            final NativeArray na = (NativeArray)thisObj;
            if (na.denseOnly && na.length > 0L) {
                final NativeArray nativeArray = na;
                --nativeArray.length;
                final Object result = na.dense[0];
                System.arraycopy(na.dense, 1, na.dense, 0, (int)na.length);
                na.dense[(int)na.length] = NativeArray.NOT_FOUND;
                return (result == NativeArray.NOT_FOUND) ? Undefined.instance : result;
            }
        }
        long length = getLengthProperty(thisObj, false);
        Object result2;
        if (length > 0L) {
            long i = 0L;
            --length;
            result2 = getElem(thisObj, i);
            if (length > 0L) {
                for (i = 1L; i <= length; ++i) {
                    final Object temp = getRawElem(thisObj, i);
                    setRawElem(thisObj, i - 1L, temp);
                }
            }
            deleteElem(thisObj, length);
        }
        else {
            result2 = Undefined.instance;
        }
        setLengthProperty(thisObj, length);
        return result2;
    }
    
    private static Object js_unshift(final Context cx, final Scriptable thisObj, final Object[] args) {
        if (thisObj instanceof NativeArray) {
            final NativeArray na = (NativeArray)thisObj;
            if (na.denseOnly && na.ensureCapacity((int)na.length + args.length)) {
                System.arraycopy(na.dense, 0, na.dense, args.length, (int)na.length);
                for (int i = 0; i < args.length; ++i) {
                    na.dense[i] = args[i];
                }
                final NativeArray nativeArray = na;
                nativeArray.length += args.length;
                return ScriptRuntime.wrapNumber((double)na.length);
            }
        }
        long length = getLengthProperty(thisObj, false, false);
        final int argc = args.length;
        if (length + argc > 9.007199254740991E15) {
            throw ScriptRuntime.rangeError("msg.arraylength.invalid");
        }
        if (args.length > 0) {
            if (length > 0L) {
                for (long last = length - 1L; last >= 0L; --last) {
                    final Object temp = getRawElem(thisObj, last);
                    setRawElem(thisObj, last + argc, temp);
                }
            }
            for (int j = 0; j < args.length; ++j) {
                setElem(thisObj, j, args[j]);
            }
        }
        length += args.length;
        return setLengthProperty(thisObj, length);
    }
    
    private static Object js_splice(final Context cx, Scriptable scope, final Scriptable thisObj, final Object[] args) {
        NativeArray na = null;
        boolean denseMode = false;
        if (thisObj instanceof NativeArray) {
            na = (NativeArray)thisObj;
            denseMode = na.denseOnly;
        }
        scope = getTopLevelScope(scope);
        int argc = args.length;
        if (argc == 0) {
            return cx.newArray(scope, 0);
        }
        final long length = getLengthProperty(thisObj, false, false);
        if (length > 2147483647L) {
            throw ScriptRuntime.rangeError("msg.arraylength.invalid");
        }
        final long begin = toSliceIndex(ScriptRuntime.toInteger(args[0]), length);
        --argc;
        long count;
        if (args.length == 1) {
            count = length - begin;
        }
        else {
            final double dcount = ScriptRuntime.toInteger(args[1]);
            if (dcount < 0.0) {
                count = 0L;
            }
            else if (dcount > length - begin) {
                count = length - begin;
            }
            else {
                count = (long)dcount;
            }
            --argc;
        }
        final long end = begin + count;
        final BaseFunction species = getSpecies(thisObj);
        Object result;
        if (count != 0L) {
            if (count == 1L && cx.getLanguageVersion() == 120) {
                result = getElem(thisObj, begin);
            }
            else if (denseMode) {
                final int intLen = (int)(end - begin);
                final Object[] copy = new Object[intLen];
                System.arraycopy(na.dense, (int)begin, copy, 0, intLen);
                if (species == null) {
                    result = cx.newArray(scope, copy);
                }
                else {
                    result = species.construct(cx, scope, new Object[0]);
                    for (int i = 0; i < copy.length; ++i) {
                        ScriptableObject.putProperty(result, i, copy[i]);
                    }
                }
            }
            else {
                final Scriptable resultArray = (species == null) ? cx.newArray(scope, 0) : species.construct(cx, scope, new Object[0]);
                for (long last = begin; last != end; ++last) {
                    final Object temp = getRawElem(thisObj, last);
                    if (temp != NativeArray.NOT_FOUND) {
                        setElem(resultArray, last - begin, temp);
                    }
                }
                setLengthProperty(resultArray, end - begin);
                result = resultArray;
            }
        }
        else if (cx.getLanguageVersion() == 120) {
            result = Undefined.instance;
        }
        else {
            result = ((species == null) ? cx.newArray(scope, 0) : species.construct(cx, scope, new Object[0]));
        }
        final long delta = argc - count;
        if (denseMode && length + delta < 2147483647L && na.ensureCapacity((int)(length + delta))) {
            System.arraycopy(na.dense, (int)end, na.dense, (int)(begin + argc), (int)(length - end));
            if (argc > 0) {
                System.arraycopy(args, 2, na.dense, (int)begin, argc);
            }
            if (delta < 0L) {
                Arrays.fill(na.dense, (int)(length + delta), (int)length, NativeArray.NOT_FOUND);
            }
            na.length = length + delta;
            return result;
        }
        if (delta > 0L) {
            for (long last2 = length - 1L; last2 >= end; --last2) {
                final Object temp2 = getRawElem(thisObj, last2);
                setRawElem(thisObj, last2 + delta, temp2);
            }
        }
        else if (delta < 0L) {
            for (long last2 = end; last2 < length; ++last2) {
                final Object temp2 = getRawElem(thisObj, last2);
                setRawElem(thisObj, last2 + delta, temp2);
            }
            for (long k = length - 1L; k >= length + delta; --k) {
                deleteElem(thisObj, k);
            }
        }
        final int argoffset = args.length - argc;
        for (int j = 0; j < argc; ++j) {
            setElem(thisObj, begin + j, args[j + argoffset]);
        }
        setLengthProperty(thisObj, length + delta);
        return result;
    }
    
    private static boolean isConcatSpreadable(final Context cx, final Scriptable scope, final Object val) {
        if (val instanceof Scriptable) {
            final Object spreadable = ScriptableObject.getProperty((Scriptable)val, SymbolKey.IS_CONCAT_SPREADABLE);
            if (spreadable != Scriptable.NOT_FOUND && !Undefined.isUndefined(spreadable)) {
                return ScriptRuntime.toBoolean(spreadable);
            }
        }
        if (cx.getLanguageVersion() < 200) {
            final Function ctor = ScriptRuntime.getExistingCtor(cx, scope, "Array");
            if (ScriptRuntime.instanceOf(val, ctor, cx)) {
                return true;
            }
        }
        return js_isArray(val);
    }
    
    private static long concatSpreadArg(final Context cx, final Scriptable result, final Scriptable arg, final long offset) {
        final long srclen = getLengthProperty(arg, false);
        final long newlen = srclen + offset;
        if (newlen <= 2147483647L && result instanceof NativeArray) {
            final NativeArray denseResult = (NativeArray)result;
            if (denseResult.denseOnly && arg instanceof NativeArray) {
                final NativeArray denseArg = (NativeArray)arg;
                if (denseArg.denseOnly) {
                    denseResult.ensureCapacity((int)newlen);
                    System.arraycopy(denseArg.dense, 0, denseResult.dense, (int)offset, (int)srclen);
                    return newlen;
                }
            }
        }
        for (long dstpos = offset, srcpos = 0L; srcpos < srclen; ++srcpos, ++dstpos) {
            final Object temp = getRawElem(arg, srcpos);
            if (temp != Scriptable.NOT_FOUND) {
                defineElem(cx, result, dstpos, temp);
            }
        }
        return newlen;
    }
    
    private static long doConcat(final Context cx, final Scriptable scope, final Scriptable result, final Object arg, final long offset) {
        if (isConcatSpreadable(cx, scope, arg)) {
            return concatSpreadArg(cx, result, (Scriptable)arg, offset);
        }
        defineElem(cx, result, offset, arg);
        return offset + 1L;
    }
    
    private static Scriptable js_concat(final Context cx, Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final BaseFunction species = getSpecies(thisObj);
        Scriptable result;
        if (species == null) {
            scope = getTopLevelScope(scope);
            result = cx.newArray(scope, 0);
        }
        else {
            result = species.construct(cx, scope, new Object[0]);
        }
        long length = doConcat(cx, scope, result, thisObj, 0L);
        for (final Object arg : args) {
            length = doConcat(cx, scope, result, arg, length);
        }
        setLengthProperty(result, length);
        return result;
    }
    
    private Scriptable js_slice(final Context cx, final Scriptable thisObj, final Object[] args) {
        Scriptable scope = getTopLevelScope((Scriptable)this);
        final BaseFunction species = getSpecies(thisObj);
        Scriptable result;
        if (species == null) {
            scope = getTopLevelScope(scope);
            result = cx.newArray(scope, 0);
        }
        else {
            result = species.construct(cx, scope, new Object[0]);
        }
        final long len = getLengthProperty(thisObj, false, false);
        long begin;
        long end;
        if (args.length == 0) {
            begin = 0L;
            end = len;
        }
        else {
            begin = toSliceIndex(ScriptRuntime.toInteger(args[0]), len);
            if (args.length == 1 || args[1] == Undefined.instance) {
                end = len;
            }
            else {
                end = toSliceIndex(ScriptRuntime.toInteger(args[1]), len);
            }
        }
        if (len >= 2147483647L) {
            throw ScriptRuntime.rangeError("msg.arraylength.invalid");
        }
        for (long slot = begin; slot < end; ++slot) {
            final Object temp = getRawElem(thisObj, slot);
            if (temp != NativeArray.NOT_FOUND) {
                defineElem(cx, result, slot - begin, temp);
            }
        }
        setLengthProperty(result, Math.max(0L, end - begin));
        return result;
    }
    
    private static long toSliceIndex(final double value, final long length) {
        long result;
        if (value < 0.0) {
            if (value + length < 0.0) {
                result = 0L;
            }
            else {
                result = (long)(value + length);
            }
        }
        else if (value > length) {
            result = length;
        }
        else {
            result = (long)value;
        }
        return result;
    }
    
    private static Object js_indexOf(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Object compareTo = (args.length > 0) ? args[0] : Undefined.instance;
        final Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final long length = getLengthProperty(o, false);
        long start;
        if (args.length < 2) {
            start = 0L;
        }
        else {
            start = (long)ScriptRuntime.toInteger(args[1]);
            if (start < 0L) {
                start += length;
                if (start < 0L) {
                    start = 0L;
                }
            }
            if (start > length - 1L) {
                return NativeArray.NEGATIVE_ONE;
            }
        }
        if (o instanceof NativeArray) {
            final NativeArray na = (NativeArray)o;
            if (na.denseOnly) {
                final Scriptable proto = na.getPrototype();
                for (int i = (int)start; i < length; ++i) {
                    Object val = na.dense[i];
                    if (val == NativeArray.NOT_FOUND && proto != null) {
                        val = ScriptableObject.getProperty(proto, i);
                    }
                    if (val != NativeArray.NOT_FOUND && ScriptRuntime.shallowEq(val, compareTo)) {
                        return i;
                    }
                }
                return NativeArray.NEGATIVE_ONE;
            }
        }
        for (long j = start; j < length; ++j) {
            final Object val2 = getRawElem(o, j);
            if (val2 != NativeArray.NOT_FOUND && ScriptRuntime.shallowEq(val2, compareTo)) {
                return j;
            }
        }
        return NativeArray.NEGATIVE_ONE;
    }
    
    private static Object js_lastIndexOf(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Object compareTo = (args.length > 0) ? args[0] : Undefined.instance;
        final Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final long length = getLengthProperty(o, false);
        long start;
        if (args.length < 2) {
            start = length - 1L;
        }
        else {
            start = (long)ScriptRuntime.toInteger(args[1]);
            if (start >= length) {
                start = length - 1L;
            }
            else if (start < 0L) {
                start += length;
            }
            if (start < 0L) {
                return NativeArray.NEGATIVE_ONE;
            }
        }
        if (o instanceof NativeArray) {
            final NativeArray na = (NativeArray)o;
            if (na.denseOnly) {
                final Scriptable proto = na.getPrototype();
                for (int i = (int)start; i >= 0; --i) {
                    Object val = na.dense[i];
                    if (val == NativeArray.NOT_FOUND && proto != null) {
                        val = ScriptableObject.getProperty(proto, i);
                    }
                    if (val != NativeArray.NOT_FOUND && ScriptRuntime.shallowEq(val, compareTo)) {
                        return i;
                    }
                }
                return NativeArray.NEGATIVE_ONE;
            }
        }
        for (long j = start; j >= 0L; --j) {
            final Object val2 = getRawElem(o, j);
            if (val2 != NativeArray.NOT_FOUND && ScriptRuntime.shallowEq(val2, compareTo)) {
                return j;
            }
        }
        return NativeArray.NEGATIVE_ONE;
    }
    
    private static Boolean js_includes(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Object compareTo = (args.length > 0) ? args[0] : Undefined.instance;
        final Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final long len = ScriptRuntime.toLength(new Object[] { getProperty(thisObj, "length") }, 0);
        if (len == 0L) {
            return Boolean.FALSE;
        }
        long k;
        if (args.length < 2) {
            k = 0L;
        }
        else {
            k = (long)ScriptRuntime.toInteger(args[1]);
            if (k < 0L) {
                k += len;
                if (k < 0L) {
                    k = 0L;
                }
            }
            if (k > len - 1L) {
                return Boolean.FALSE;
            }
        }
        if (o instanceof NativeArray) {
            final NativeArray na = (NativeArray)o;
            if (na.denseOnly) {
                final Scriptable proto = na.getPrototype();
                for (int i = (int)k; i < len; ++i) {
                    Object elementK = na.dense[i];
                    if (elementK == NativeArray.NOT_FOUND && proto != null) {
                        elementK = ScriptableObject.getProperty(proto, i);
                    }
                    if (elementK == NativeArray.NOT_FOUND) {
                        elementK = Undefined.instance;
                    }
                    if (ScriptRuntime.sameZero(elementK, compareTo)) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        }
        while (k < len) {
            Object elementK2 = getRawElem(o, k);
            if (elementK2 == NativeArray.NOT_FOUND) {
                elementK2 = Undefined.instance;
            }
            if (ScriptRuntime.sameZero(elementK2, compareTo)) {
                return Boolean.TRUE;
            }
            ++k;
        }
        return Boolean.FALSE;
    }
    
    private static Object js_fill(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final long len = getLengthProperty(o, false);
        long relativeStart = 0L;
        if (args.length >= 2) {
            relativeStart = (long)ScriptRuntime.toInteger(args[1]);
        }
        long k;
        if (relativeStart < 0L) {
            k = Math.max(len + relativeStart, 0L);
        }
        else {
            k = Math.min(relativeStart, len);
        }
        long relativeEnd = len;
        if (args.length >= 3 && !Undefined.isUndefined(args[2])) {
            relativeEnd = (long)ScriptRuntime.toInteger(args[2]);
        }
        long fin;
        if (relativeEnd < 0L) {
            fin = Math.max(len + relativeEnd, 0L);
        }
        else {
            fin = Math.min(relativeEnd, len);
        }
        final Object value = (args.length > 0) ? args[0] : Undefined.instance;
        for (long i = k; i < fin; ++i) {
            setRawElem(thisObj, i, value);
        }
        return thisObj;
    }
    
    private static Object js_copyWithin(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final long len = getLengthProperty(o, false);
        final Object targetArg = (args.length >= 1) ? args[0] : Undefined.instance;
        final long relativeTarget = (long)ScriptRuntime.toInteger(targetArg);
        long to;
        if (relativeTarget < 0L) {
            to = Math.max(len + relativeTarget, 0L);
        }
        else {
            to = Math.min(relativeTarget, len);
        }
        final Object startArg = (args.length >= 2) ? args[1] : Undefined.instance;
        final long relativeStart = (long)ScriptRuntime.toInteger(startArg);
        long from;
        if (relativeStart < 0L) {
            from = Math.max(len + relativeStart, 0L);
        }
        else {
            from = Math.min(relativeStart, len);
        }
        long relativeEnd = len;
        if (args.length >= 3 && !Undefined.isUndefined(args[2])) {
            relativeEnd = (long)ScriptRuntime.toInteger(args[2]);
        }
        long fin;
        if (relativeEnd < 0L) {
            fin = Math.max(len + relativeEnd, 0L);
        }
        else {
            fin = Math.min(relativeEnd, len);
        }
        long count = Math.min(fin - from, len - to);
        int direction = 1;
        if (from < to && to < from + count) {
            direction = -1;
            from = from + count - 1L;
            to = to + count - 1L;
        }
        if (o instanceof NativeArray && count <= 2147483647L) {
            final NativeArray na = (NativeArray)o;
            if (na.denseOnly) {
                while (count > 0L) {
                    na.dense[(int)to] = na.dense[(int)from];
                    from += direction;
                    to += direction;
                    --count;
                }
                return thisObj;
            }
        }
        while (count > 0L) {
            final Object temp = getRawElem(o, from);
            if (temp == Scriptable.NOT_FOUND || Undefined.isUndefined(temp)) {
                deleteElem(o, to);
            }
            else {
                setElem(o, to, temp);
            }
            from += direction;
            to += direction;
            --count;
        }
        return thisObj;
    }
    
    private static Object iterativeMethod(final Context cx, final IdFunctionObject idFunctionObject, Scriptable scope, final Scriptable thisObj, final Object[] args) {
        Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final int id = Math.abs(idFunctionObject.methodId());
        if (22 == id || 23 == id) {
            o = ScriptRuntimeES6.requireObjectCoercible(cx, o, idFunctionObject);
        }
        final long length = getLengthProperty(o, id == 20);
        if (id != 17 && id != 21 && length > 2147483647L) {
            throw ScriptRuntime.rangeError("msg.arraylength.invalid");
        }
        final Object callbackArg = (args.length > 0) ? args[0] : Undefined.instance;
        if (!(callbackArg instanceof Function)) {
            throw ScriptRuntime.notFunctionError(callbackArg);
        }
        if (cx.getLanguageVersion() >= 200 && callbackArg instanceof NativeRegExp) {
            throw ScriptRuntime.notFunctionError(callbackArg);
        }
        final Function f = (Function)callbackArg;
        final Scriptable parent = ScriptableObject.getTopLevelScope((Scriptable)f);
        Scriptable thisArg;
        if (args.length < 2 || args[1] == null || args[1] == Undefined.instance) {
            thisArg = parent;
        }
        else {
            thisArg = ScriptRuntime.toObject(cx, scope, args[1]);
        }
        Scriptable array = null;
        if (id == 18 || id == 20) {
            final int resultLength = (id == 20) ? ((int)length) : 0;
            final BaseFunction species = getSpecies(thisObj);
            if (species == null) {
                scope = getTopLevelScope(scope);
                array = cx.newArray(scope, resultLength);
            }
            else {
                array = species.construct(cx, scope, new Object[0]);
            }
        }
        long j = 0L;
        for (long i = 0L; i < length; ++i) {
            final Object[] innerArgs = new Object[3];
            Object elem = getRawElem(o, i);
            if (elem == Scriptable.NOT_FOUND) {
                if (id == 20) {
                    defineElem(cx, array, i, Undefined.instance);
                    continue;
                }
                if (id != 22 && id != 23) {
                    continue;
                }
                elem = Undefined.instance;
            }
            innerArgs[0] = elem;
            innerArgs[1] = i;
            innerArgs[2] = o;
            final Object result = f.call(cx, parent, thisArg, innerArgs);
            switch (id) {
                case 17: {
                    if (!ScriptRuntime.toBoolean(result)) {
                        return Boolean.FALSE;
                    }
                    break;
                }
                case 18: {
                    if (ScriptRuntime.toBoolean(result)) {
                        defineElem(cx, array, j++, innerArgs[0]);
                        break;
                    }
                    break;
                }
                case 20: {
                    defineElem(cx, array, i, result);
                    break;
                }
                case 21: {
                    if (ScriptRuntime.toBoolean(result)) {
                        return Boolean.TRUE;
                    }
                    break;
                }
                case 22: {
                    if (ScriptRuntime.toBoolean(result)) {
                        return elem;
                    }
                    break;
                }
                case 23: {
                    if (ScriptRuntime.toBoolean(result)) {
                        return ScriptRuntime.wrapNumber((double)i);
                    }
                    break;
                }
            }
        }
        switch (id) {
            case 17: {
                return Boolean.TRUE;
            }
            case 18:
            case 20: {
                return array;
            }
            case 21: {
                return Boolean.FALSE;
            }
            case 23: {
                return ScriptRuntime.wrapNumber(-1.0);
            }
            default: {
                return Undefined.instance;
            }
        }
    }
    
    private static Object reduceMethod(final Context cx, final int id, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Scriptable o = ScriptRuntime.toObject(cx, scope, thisObj);
        final long length = getLengthProperty(o, false);
        final Object callbackArg = (args.length > 0) ? args[0] : Undefined.instance;
        if (callbackArg == null || !(callbackArg instanceof Function)) {
            throw ScriptRuntime.notFunctionError(callbackArg);
        }
        final Function f = (Function)callbackArg;
        final Scriptable parent = ScriptableObject.getTopLevelScope((Scriptable)f);
        final boolean movingLeft = id == 24;
        Object value = (args.length > 1) ? args[1] : Scriptable.NOT_FOUND;
        for (long i = 0L; i < length; ++i) {
            final long index = movingLeft ? i : (length - 1L - i);
            final Object elem = getRawElem(o, index);
            if (elem != Scriptable.NOT_FOUND) {
                if (value == Scriptable.NOT_FOUND) {
                    value = elem;
                }
                else {
                    final Object[] innerArgs = { value, elem, index, o };
                    value = f.call(cx, parent, parent, innerArgs);
                }
            }
        }
        if (value == Scriptable.NOT_FOUND) {
            throw ScriptRuntime.typeError0("msg.empty.array.reduce");
        }
        return value;
    }
    
    private static boolean js_isArray(final Object o) {
        if (!(o instanceof Scriptable)) {
            return false;
        }
        if (o instanceof NativeProxy && ((NativeProxy)o).isRevoked()) {
            throw ScriptRuntime.typeError0("msg.proxy.revocable.illegal.operation");
        }
        return "Array".equals(((Scriptable)o).getClassName());
    }
    
    public boolean contains(final Object o) {
        return this.indexOf(o) > -1;
    }
    
    public Object[] toArray() {
        return this.toArray(ScriptRuntime.emptyArgs);
    }
    
    public Object[] toArray(final Object[] a) {
        final long longLen = this.length;
        if (longLen > 2147483647L) {
            throw new IllegalStateException();
        }
        final int len = (int)longLen;
        final Object[] array = (Object[])((a.length >= len) ? a : Array.newInstance(a.getClass().getComponentType(), len));
        for (int i = 0; i < len; ++i) {
            array[i] = this.get(i);
        }
        return array;
    }
    
    public boolean containsAll(final Collection c) {
        for (final Object aC : c) {
            if (!this.contains(aC)) {
                return false;
            }
        }
        return true;
    }
    
    public int size() {
        final long longLen = this.length;
        if (longLen > 2147483647L) {
            throw new IllegalStateException();
        }
        return (int)longLen;
    }
    
    public boolean isEmpty() {
        return this.length == 0L;
    }
    
    public Object get(final long index) {
        if (index < 0L || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        final Object value = getRawElem((Scriptable)this, index);
        if (value == Scriptable.NOT_FOUND || value == Undefined.instance) {
            return null;
        }
        if (value instanceof Wrapper) {
            return ((Wrapper)value).unwrap();
        }
        return value;
    }
    
    public Object get(final int index) {
        return this.get((long)index);
    }
    
    public int indexOf(final Object o) {
        final long longLen = this.length;
        if (longLen > 2147483647L) {
            throw new IllegalStateException();
        }
        final int len = (int)longLen;
        if (o == null) {
            for (int i = 0; i < len; ++i) {
                if (this.get(i) == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < len; ++i) {
                if (o.equals(this.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int lastIndexOf(final Object o) {
        final long longLen = this.length;
        if (longLen > 2147483647L) {
            throw new IllegalStateException();
        }
        final int len = (int)longLen;
        if (o == null) {
            for (int i = len - 1; i >= 0; --i) {
                if (this.get(i) == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = len - 1; i >= 0; --i) {
                if (o.equals(this.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public Iterator iterator() {
        return this.listIterator(0);
    }
    
    public ListIterator listIterator() {
        return this.listIterator(0);
    }
    
    public ListIterator listIterator(final int start) {
        final long longLen = this.length;
        if (longLen > 2147483647L) {
            throw new IllegalStateException();
        }
        final int len = (int)longLen;
        if (start < 0 || start > len) {
            throw new IndexOutOfBoundsException("Index: " + start);
        }
        return new ListIterator() {
            int cursor = start;
            
            @Override
            public boolean hasNext() {
                return this.cursor < len;
            }
            
            @Override
            public Object next() {
                if (this.cursor == len) {
                    throw new NoSuchElementException();
                }
                return NativeArray.this.get(this.cursor++);
            }
            
            @Override
            public boolean hasPrevious() {
                return this.cursor > 0;
            }
            
            @Override
            public Object previous() {
                if (this.cursor == 0) {
                    throw new NoSuchElementException();
                }
                final NativeArray this$0 = NativeArray.this;
                final int n = this.cursor - 1;
                this.cursor = n;
                return this$0.get(n);
            }
            
            @Override
            public int nextIndex() {
                return this.cursor;
            }
            
            @Override
            public int previousIndex() {
                return this.cursor - 1;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public void add(final Object o) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public void set(final Object o) {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    public boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAll(final Collection c) {
        throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(final Collection c) {
        throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(final Collection c) {
        throw new UnsupportedOperationException();
    }
    
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    public void add(final int index, final Object element) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAll(final int index, final Collection c) {
        throw new UnsupportedOperationException();
    }
    
    public Object set(final int index, final Object element) {
        throw new UnsupportedOperationException();
    }
    
    public Object remove(final int index) {
        throw new UnsupportedOperationException();
    }
    
    public List subList(final int fromIndex, final int toIndex) {
        throw new UnsupportedOperationException();
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (SymbolKey.ITERATOR.equals(k)) {
            return 32;
        }
        return 0;
    }
    
    public boolean isTemplateObj() {
        return this.templateObj;
    }
    
    public void setTemplateObj() {
        this.templateObj = true;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        Label_0719: {
            switch (s.length()) {
                case 3: {
                    final int c = s.charAt(0);
                    if (c == 109) {
                        if (s.charAt(2) == 'p' && s.charAt(1) == 'a') {
                            id = 20;
                            return id;
                        }
                        break;
                    }
                    else {
                        if (c == 112 && s.charAt(2) == 'p' && s.charAt(1) == 'o') {
                            id = 9;
                            return id;
                        }
                        break;
                    }
                    break;
                }
                case 4: {
                    switch (s.charAt(2)) {
                        case 'i': {
                            X = "join";
                            id = 5;
                            break Label_0719;
                        }
                        case 'l': {
                            X = "fill";
                            id = 26;
                            break Label_0719;
                        }
                        case 'm': {
                            X = "some";
                            id = 21;
                            break Label_0719;
                        }
                        case 'n': {
                            X = "find";
                            id = 22;
                            break Label_0719;
                        }
                        case 'r': {
                            X = "sort";
                            id = 7;
                            break Label_0719;
                        }
                        case 's': {
                            X = "push";
                            id = 8;
                            break Label_0719;
                        }
                        case 'y': {
                            X = "keys";
                            id = 27;
                            break Label_0719;
                        }
                        default: {
                            break Label_0719;
                        }
                    }
                    break;
                }
                case 5: {
                    final int c = s.charAt(1);
                    if (c == 104) {
                        X = "shift";
                        id = 10;
                        break;
                    }
                    if (c == 108) {
                        X = "slice";
                        id = 14;
                        break;
                    }
                    if (c == 118) {
                        X = "every";
                        id = 17;
                        break;
                    }
                    break;
                }
                case 6: {
                    switch (s.charAt(0)) {
                        case 'c': {
                            X = "concat";
                            id = 13;
                            break Label_0719;
                        }
                        case 'f': {
                            X = "filter";
                            id = 18;
                            break Label_0719;
                        }
                        case 'r': {
                            X = "reduce";
                            id = 24;
                            break Label_0719;
                        }
                        case 's': {
                            X = "splice";
                            id = 12;
                            break Label_0719;
                        }
                        case 'v': {
                            X = "values";
                            id = 28;
                            break Label_0719;
                        }
                        default: {
                            break Label_0719;
                        }
                    }
                    break;
                }
                case 7: {
                    switch (s.charAt(0)) {
                        case 'e': {
                            X = "entries";
                            id = 29;
                            break Label_0719;
                        }
                        case 'f': {
                            X = "forEach";
                            id = 19;
                            break Label_0719;
                        }
                        case 'i': {
                            X = "indexOf";
                            id = 15;
                            break Label_0719;
                        }
                        case 'r': {
                            X = "reverse";
                            id = 6;
                            break Label_0719;
                        }
                        case 'u': {
                            X = "unshift";
                            id = 11;
                            break Label_0719;
                        }
                        default: {
                            break Label_0719;
                        }
                    }
                    break;
                }
                case 8: {
                    final int c = s.charAt(3);
                    if (c == 108) {
                        X = "includes";
                        id = 30;
                        break;
                    }
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
                case 9: {
                    X = "findIndex";
                    id = 23;
                    break;
                }
                case 10: {
                    X = "copyWithin";
                    id = 31;
                    break;
                }
                case 11: {
                    final int c = s.charAt(0);
                    if (c == 99) {
                        X = "constructor";
                        id = 1;
                        break;
                    }
                    if (c == 108) {
                        X = "lastIndexOf";
                        id = 16;
                        break;
                    }
                    if (c == 114) {
                        X = "reduceRight";
                        id = 25;
                        break;
                    }
                    break;
                }
                case 14: {
                    X = "toLocaleString";
                    id = 3;
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
        ARRAY_TAG = "Array";
        NEGATIVE_ONE = -1L;
        STRING_COMPARATOR = new StringLikeComparator();
        DEFAULT_COMPARATOR = new ElementComparator();
        NativeArray.maximumInitialCapacity = 10000;
    }
    
    public static final class StringLikeComparator implements Comparator<Object>
    {
        @Override
        public int compare(final Object x, final Object y) {
            final String a = ScriptRuntime.toString(x);
            final String b = ScriptRuntime.toString(y);
            return a.compareTo(b);
        }
    }
    
    public static final class ElementComparator implements Comparator<Object>
    {
        private final Comparator<Object> child;
        
        public ElementComparator() {
            this.child = NativeArray.STRING_COMPARATOR;
        }
        
        public ElementComparator(final Comparator<Object> c) {
            this.child = c;
        }
        
        @Override
        public int compare(final Object x, final Object y) {
            if (x == Undefined.instance) {
                if (y == Undefined.instance) {
                    return 0;
                }
                if (y == Scriptable.NOT_FOUND) {
                    return -1;
                }
                return 1;
            }
            else {
                if (x == Scriptable.NOT_FOUND) {
                    return (y != Scriptable.NOT_FOUND) ? 1 : 0;
                }
                if (y == Scriptable.NOT_FOUND) {
                    return -1;
                }
                if (y == Undefined.instance) {
                    return -1;
                }
                return this.child.compare(x, y);
            }
        }
    }
}
