//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;
import java.lang.reflect.*;
import java.util.*;

public abstract class NativeTypedArrayView<T extends Comparable<T>> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData
{
    private static final long serialVersionUID = -4963053773152251274L;
    protected final int length;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_get = 3;
    private static final int Id_set = 4;
    private static final int Id_subarray = 5;
    private static final int Id_join = 6;
    private static final int Id_indexOf = 7;
    private static final int Id_lastIndexOf = 8;
    private static final int Id_slice = 9;
    private static final int Id_every = 10;
    private static final int Id_filter = 11;
    private static final int Id_forEach = 12;
    private static final int Id_map = 13;
    private static final int Id_reduce = 14;
    private static final int Id_reduceRight = 15;
    private static final int Id_reverse = 16;
    private static final int Id_some = 17;
    private static final int Id_copyWithin = 18;
    private static final int Id_find = 19;
    private static final int Id_findIndex = 20;
    private static final int Id_fill = 21;
    private static final int Id_keys = 22;
    private static final int Id_values = 23;
    private static final int Id_entries = 24;
    private static final int Id_sort = 25;
    private static final int Id_includes = 26;
    private static final int SymbolId_iterator = 27;
    protected static final int MAX_PROTOTYPE_ID = 27;
    private static final int Id_length = 4;
    private static final int Id_BYTES_PER_ELEMENT = 5;
    private static final int MAX_INSTANCE_ID = 5;
    
    protected NativeTypedArrayView() {
        this.length = 0;
    }
    
    protected NativeTypedArrayView(final NativeArrayBuffer ab, final int off, final int len, final int byteLen) {
        super(ab, off, byteLen);
        this.length = len;
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 27) {
            this.initPrototypeMethod((Object)this.getClassName(), id, (Symbol)SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
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
                arity = 1;
                s = "get";
                break;
            }
            case 4: {
                arity = 2;
                s = "set";
                break;
            }
            case 5: {
                arity = 2;
                s = "subarray";
                break;
            }
            case 6: {
                arity = 1;
                s = "join";
                break;
            }
            case 7: {
                arity = 1;
                s = "indexOf";
                break;
            }
            case 8: {
                arity = 1;
                s = "lastIndexOf";
                break;
            }
            case 9: {
                arity = 2;
                s = "slice";
                break;
            }
            case 10: {
                arity = 2;
                s = "every";
                break;
            }
            case 11: {
                arity = 2;
                s = "filter";
                break;
            }
            case 12: {
                arity = 2;
                s = "forEach";
                break;
            }
            case 13: {
                arity = 2;
                s = "map";
                break;
            }
            case 14: {
                arity = 2;
                s = "reduce";
                break;
            }
            case 15: {
                arity = 2;
                s = "reduceRight";
                break;
            }
            case 16: {
                arity = 0;
                s = "reverse";
                break;
            }
            case 17: {
                arity = 2;
                s = "some";
                break;
            }
            case 18: {
                arity = 3;
                s = "copyWithin";
                break;
            }
            case 19: {
                arity = 2;
                s = "find";
                break;
            }
            case 20: {
                arity = 2;
                s = "findIndex";
                break;
            }
            case 21: {
                arity = 3;
                s = "fill";
                break;
            }
            case 22: {
                arity = 0;
                s = "keys";
                break;
            }
            case 23: {
                arity = 0;
                s = "values";
                break;
            }
            case 24: {
                arity = 0;
                s = "entries";
                break;
            }
            case 25: {
                arity = 1;
                s = "sort";
                break;
            }
            case 26: {
                arity = 1;
                s = "includes";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod((Object)this.getClassName(), id, s, fnName, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag((Object)this.getClassName())) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                if (thisObj != null) {
                    throw ScriptRuntime.typeError1("msg.builtin.no.new", (Object)"TypedArray");
                }
                return this.js_constructor(cx, scope, args);
            }
            case 2: {
                final NativeTypedArrayView<T> realThis = this.realThis(thisObj, f);
                final int arrayLength = realThis.getArrayLength();
                final StringBuilder builder = new StringBuilder();
                if (arrayLength > 0) {
                    builder.append(ScriptRuntime.toString(realThis.js_get(0)));
                }
                for (int i = 1; i < arrayLength; ++i) {
                    builder.append(',');
                    builder.append(ScriptRuntime.toString(realThis.js_get(i)));
                }
                return builder.toString();
            }
            case 3: {
                if (args.length > 0) {
                    return this.realThis(thisObj, f).js_get(ScriptRuntime.toInt32(args[0]));
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            }
            case 4: {
                if (args.length > 0) {
                    final NativeTypedArrayView<T> self = this.realThis(thisObj, f);
                    if (args[0] instanceof NativeTypedArrayView) {
                        final int offset = isArg(args, 1) ? ScriptRuntime.toInt32(args[1]) : 0;
                        self.setRange((NativeTypedArrayView)args[0], offset);
                        return Undefined.instance;
                    }
                    if (args[0] instanceof NativeArray) {
                        final int offset = isArg(args, 1) ? ScriptRuntime.toInt32(args[1]) : 0;
                        self.setRange((NativeArray)args[0], offset);
                        return Undefined.instance;
                    }
                    if (args[0] instanceof Scriptable) {
                        return Undefined.instance;
                    }
                    if (isArg(args, 2)) {
                        return self.js_set(ScriptRuntime.toInt32(args[0]), args[1]);
                    }
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            }
            case 5: {
                if (args.length > 0) {
                    final NativeTypedArrayView<T> self = this.realThis(thisObj, f);
                    final int start = ScriptRuntime.toInt32(args[0]);
                    final int end = isArg(args, 1) ? ScriptRuntime.toInt32(args[1]) : self.length;
                    return self.js_subarray(cx, scope, start, end);
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            }
            case 6: {
                return this.realThis(thisObj, f).js_join((args.length > 0) ? args[0] : null);
            }
            case 7: {
                return this.realThis(thisObj, f).js_indexOf((args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : Integer.valueOf(0));
            }
            case 8: {
                return this.realThis(thisObj, f).js_lastIndexOf((args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : Integer.valueOf(0));
            }
            case 9: {
                return this.realThis(thisObj, f).js_slice(cx, scope, (args.length > 0) ? args[0] : Integer.valueOf(0), (args.length > 1) ? args[1] : Integer.valueOf(((NativeTypedArrayView)thisObj).length));
            }
            case 10: {
                return this.realThis(thisObj, f).js_every(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
            }
            case 11: {
                return this.realThis(thisObj, f).js_filter(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
            }
            case 12: {
                this.realThis(thisObj, f).js_forEach(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
                return Undefined.instance;
            }
            case 13: {
                return this.realThis(thisObj, f).js_map(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
            }
            case 14: {
                return this.realThis(thisObj, f).js_reduce(cx, scope, (args.length > 0) ? args[0] : null, thisObj, (args.length > 1) ? args[1] : null);
            }
            case 15: {
                return this.realThis(thisObj, f).js_reduceRight(cx, scope, (args.length > 0) ? args[0] : null, thisObj, (args.length > 1) ? args[1] : null);
            }
            case 16: {
                return this.realThis(thisObj, f).js_reverse(cx, scope);
            }
            case 17: {
                return this.realThis(thisObj, f).js_some(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
            }
            case 18: {
                return this.realThis(thisObj, f).js_copyWithin((args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : Integer.valueOf(0), (args.length > 2) ? args[2] : Integer.valueOf(((NativeTypedArrayView)thisObj).length));
            }
            case 19: {
                return this.realThis(thisObj, f).js_find(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
            }
            case 20: {
                return this.realThis(thisObj, f).js_findIndex(cx, scope, (args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : thisObj);
            }
            case 21: {
                return this.realThis(thisObj, f).js_fill((args.length > 0) ? args[0] : null, (args.length > 1) ? args[1] : Integer.valueOf(0), (args.length > 2) ? args[2] : Integer.valueOf(((NativeTypedArrayView)thisObj).length));
            }
            case 25: {
                return this.realThis(thisObj, f).js_sort(cx, scope, thisObj, (args.length > 0) ? args[0] : null);
            }
            case 26: {
                return this.realThis(thisObj, f).js_includes((args.length >= 1) ? args[0] : Undefined.instance, (args.length >= 2) ? ((int)ScriptRuntime.toNumber(args[1])) : 0);
            }
            case 22: {
                return new NativeArrayIterator(scope, thisObj, NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS);
            }
            case 23:
            case 27: {
                return new NativeArrayIterator(scope, thisObj, NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
            }
            case 24: {
                return new NativeArrayIterator(scope, thisObj, NativeArrayIterator.ARRAY_ITERATOR_TYPE.ENTRIES);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    public Object get(final int index, final Scriptable start) {
        return this.js_get(index);
    }
    
    public boolean has(final int index, final Scriptable start) {
        return !this.checkIndex(index);
    }
    
    public void put(final int index, final Scriptable start, final Object val) {
        this.js_set(index, val);
    }
    
    public void delete(final int index) {
    }
    
    public Object[] getIds() {
        final Object[] ret = new Object[this.length];
        for (int i = 0; i < this.length; ++i) {
            ret[i] = i;
        }
        return ret;
    }
    
    protected boolean checkIndex(final int index) {
        return index < 0 || index >= this.length;
    }
    
    public abstract int getBytesPerElement();
    
    protected abstract NativeTypedArrayView<T> construct(final NativeArrayBuffer p0, final int p1, final int p2);
    
    protected abstract Object js_get(final int p0);
    
    protected abstract Object js_set(final int p0, final Object p1);
    
    protected abstract NativeTypedArrayView<T> realThis(final Scriptable p0, final IdFunctionObject p1);
    
    private NativeArrayBuffer makeArrayBuffer(final Context cx, final Scriptable scope, final int length) {
        return (NativeArrayBuffer)cx.newObject(scope, "ArrayBuffer", new Object[] { length });
    }
    
    private NativeTypedArrayView<T> js_constructor(final Context cx, final Scriptable scope, final Object[] args) {
        if (!isArg(args, 0)) {
            return this.construct(NativeArrayBuffer.EMPTY_BUFFER, 0, 0);
        }
        final Object arg0 = args[0];
        if (arg0 == null) {
            return this.construct(NativeArrayBuffer.EMPTY_BUFFER, 0, 0);
        }
        if (arg0 instanceof Number || arg0 instanceof String) {
            final int length = ScriptRuntime.toInt32(arg0);
            final NativeArrayBuffer buffer = this.makeArrayBuffer(cx, scope, length * this.getBytesPerElement());
            return this.construct(buffer, 0, length);
        }
        if (arg0 instanceof NativeTypedArrayView) {
            final NativeTypedArrayView<T> src = (NativeTypedArrayView<T>)arg0;
            final NativeArrayBuffer na = this.makeArrayBuffer(cx, scope, src.length * this.getBytesPerElement());
            final NativeTypedArrayView<T> v = this.construct(na, 0, src.length);
            for (int i = 0; i < src.length; ++i) {
                v.js_set(i, src.js_get(i));
            }
            return v;
        }
        if (arg0 instanceof NativeArrayBuffer) {
            final NativeArrayBuffer na2 = (NativeArrayBuffer)arg0;
            final int byteOff = isArg(args, 1) ? ScriptRuntime.toInt32(args[1]) : 0;
            int byteLen;
            if (isArg(args, 2)) {
                byteLen = ScriptRuntime.toInt32(args[2]) * this.getBytesPerElement();
            }
            else {
                byteLen = na2.getLength() - byteOff;
            }
            if (byteOff < 0 || byteOff > na2.buffer.length) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            if (byteLen < 0 || byteOff + byteLen > na2.buffer.length) {
                throw ScriptRuntime.constructError("RangeError", "length out of range");
            }
            if (byteOff % this.getBytesPerElement() != 0) {
                throw ScriptRuntime.constructError("RangeError", "offset must be a multiple of the byte size");
            }
            if (byteLen % this.getBytesPerElement() != 0) {
                throw ScriptRuntime.constructError("RangeError", "offset and buffer must be a multiple of the byte size");
            }
            return this.construct(na2, byteOff, byteLen / this.getBytesPerElement());
        }
        else {
            if (arg0 instanceof NativeArray) {
                final NativeArray array = (NativeArray)arg0;
                final NativeArrayBuffer na = this.makeArrayBuffer(cx, scope, array.size() * this.getBytesPerElement());
                final NativeTypedArrayView<T> v = this.construct(na, 0, array.size());
                for (int i = 0; i < array.size(); ++i) {
                    final Object value = array.get(i, (Scriptable)array);
                    if (value == Scriptable.NOT_FOUND || value == Undefined.instance) {
                        v.js_set(i, Double.NaN);
                    }
                    else if (value instanceof Wrapper) {
                        v.js_set(i, ((Wrapper)value).unwrap());
                    }
                    else {
                        v.js_set(i, value);
                    }
                }
                return v;
            }
            if (ScriptRuntime.isArray(arg0)) {
                final Object[] arrayElements = ScriptRuntime.getArrayElements((Scriptable)arg0);
                final NativeArrayBuffer na = this.makeArrayBuffer(cx, scope, arrayElements.length * this.getBytesPerElement());
                final NativeTypedArrayView<T> v = this.construct(na, 0, arrayElements.length);
                for (int i = 0; i < arrayElements.length; ++i) {
                    v.js_set(i, arrayElements[i]);
                }
                return v;
            }
            throw ScriptRuntime.constructError("Error", "invalid argument");
        }
    }
    
    private void setRange(final NativeTypedArrayView<T> v, final int off) {
        if (off >= this.length) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        if (v.length > this.length - off) {
            throw ScriptRuntime.constructError("RangeError", "source array too long");
        }
        if (v.arrayBuffer == this.arrayBuffer) {
            final Object[] tmp = new Object[v.length];
            for (int i = 0; i < v.length; ++i) {
                tmp[i] = v.js_get(i);
            }
            for (int i = 0; i < v.length; ++i) {
                this.js_set(i + off, tmp[i]);
            }
        }
        else {
            for (int j = 0; j < v.length; ++j) {
                this.js_set(j + off, v.js_get(j));
            }
        }
    }
    
    private void setRange(final NativeArray a, final int off) {
        if (off > this.length) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        if (off + a.size() > this.length) {
            throw ScriptRuntime.constructError("RangeError", "offset + length out of range");
        }
        int pos = off;
        for (final Object val : a) {
            this.js_set(pos, val);
            ++pos;
        }
    }
    
    private Object js_subarray(final Context cx, final Scriptable scope, final int s, final int e) {
        int start = (s < 0) ? (this.length + s) : s;
        int end = (e < 0) ? (this.length + e) : e;
        start = Math.max(0, start);
        end = Math.min(this.length, end);
        final int len = Math.max(0, end - start);
        final int byteOff = Math.min(start * this.getBytesPerElement(), this.arrayBuffer.getLength());
        return cx.newObject(scope, this.getClassName(), new Object[] { this.arrayBuffer, byteOff, len });
    }
    
    private String js_join(Object separator) {
        if (separator == null) {
            separator = ",";
        }
        else if (!(separator instanceof String)) {
            separator = ScriptRuntime.toString(separator);
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.length; ++i) {
            sb.append(ScriptRuntime.toString(this.getArrayElement(i)));
            if (i != this.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
    
    private int js_indexOf(final Object object, Object start) {
        if (!(start instanceof Number)) {
            start = ScriptRuntime.toNumber(start);
        }
        for (int i = (int)start; i < this.length; ++i) {
            if (ScriptRuntime.shallowEq(this.getArrayElement(i), object)) {
                return i;
            }
        }
        return -1;
    }
    
    private int js_lastIndexOf(final Object object, Object start) {
        if (!(start instanceof Number)) {
            start = ScriptRuntime.toNumber(start);
        }
        for (int i = this.length; i > (int)start; --i) {
            if (ScriptRuntime.shallowEq(this.getArrayElement(i), object)) {
                return i;
            }
        }
        return -1;
    }
    
    private NativeTypedArrayView<T> js_slice(final Context cx, final Scriptable scope, Object _start, Object _end) {
        if (!(_start instanceof Number)) {
            _start = (int)ScriptRuntime.toNumber(_start);
        }
        else if (_start instanceof Double) {
            _start = ((Double)_start).intValue();
        }
        if (!(_end instanceof Number)) {
            _end = (int)ScriptRuntime.toNumber(_end);
        }
        else if (_end instanceof Double) {
            _end = ((Double)_end).intValue();
        }
        int start = (int)_start;
        int end = (int)_end;
        if (start < 0) {
            start += this.length;
        }
        if (end < 0) {
            end += this.length;
        }
        final int length = Math.max(end - start, 0);
        final NativeArrayBuffer na = this.makeArrayBuffer(cx, scope, length);
        final NativeTypedArrayView<T> view = this.construct(na, 0, length);
        for (int i = start; i < end; ++i) {
            view.js_set(start - i, this.getArrayElement(i));
        }
        return view;
    }
    
    private boolean isFalsey(final Object obj) {
        return obj == null || obj == Undefined.instance || (obj instanceof Boolean && !(boolean)obj);
    }
    
    private boolean js_every(final Context cx, final Scriptable scope, final Object cb, final Object _thisObj) {
        this.validateFunctionalArgs(cb, _thisObj, "%TypedArray%.prototype.every");
        final Callable fn = (Callable)cb;
        final Scriptable thisObj = (Scriptable)_thisObj;
        for (int i = 0; i < this.length; ++i) {
            final Object result = fn.call(cx, scope, thisObj, new Object[] { this.getArrayElement(i), i, _thisObj });
            if (this.isFalsey(result)) {
                return false;
            }
        }
        return true;
    }
    
    private NativeTypedArrayView<T> js_filter(final Context cx, final Scriptable scope, final Object cb, final Object thisObj) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.filter");
        final Callable fn = (Callable)cb;
        final LinkedList<T> ll = new LinkedList<T>();
        for (int i = 0; i < this.length; ++i) {
            final T el = (T)this.getArrayElement(i);
            final Object result = fn.call(cx, scope, (Scriptable)thisObj, new Object[] { el, i, thisObj });
            if (!this.isFalsey(result)) {
                ll.add(el);
            }
        }
        final int length = ll.size();
        final NativeArrayBuffer na = this.makeArrayBuffer(cx, scope, length);
        final NativeTypedArrayView<T> view = this.construct(na, 0, length);
        final Iterator<T> ite = ll.iterator();
        int index = 0;
        while (ite.hasNext()) {
            view.setArrayElement(index, ite.next());
            ++index;
        }
        return view;
    }
    
    private void js_forEach(final Context cx, final Scriptable scope, final Object cb, final Object thisObj) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.forEach");
        final Callable fn = (Callable)cb;
        for (int i = 0; i < this.length; ++i) {
            fn.call(cx, scope, (Scriptable)thisObj, new Object[] { this.getArrayElement(i), i, thisObj });
        }
    }
    
    private NativeTypedArrayView<T> js_map(final Context cx, final Scriptable scope, final Object cb, final Object thisObj) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.map");
        final Callable fn = (Callable)cb;
        for (int i = 0; i < this.length; ++i) {
            final Object[] args = { this.getArrayElement(i), i, thisObj };
            this.setArrayElement(i, fn.call(cx, scope, (Scriptable)thisObj, args));
        }
        return this;
    }
    
    private Object js_reduce(final Context cx, final Scriptable scope, final Object cb, final Object thisObj, Object initialValue) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.reduce");
        int start = 0;
        if (initialValue == null) {
            start = 1;
            initialValue = this.getArrayElement(0);
        }
        final Callable fn = (Callable)cb;
        for (int i = start; i < this.length; ++i) {
            final Object[] args = { initialValue, this.getArrayElement(i), i, thisObj };
            initialValue = fn.call(cx, scope, (Scriptable)thisObj, args);
        }
        return initialValue;
    }
    
    private Object js_reduceRight(final Context cx, final Scriptable scope, final Object cb, final Object thisObj, Object initialValue) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.reduceRight");
        int start = this.length - 1;
        if (initialValue == null) {
            --start;
            initialValue = this.getArrayElement(0);
        }
        final Callable fn = (Callable)cb;
        for (int i = start; i >= 0; --i) {
            final Object[] args = { initialValue, this.getArrayElement(i), i, thisObj };
            initialValue = fn.call(cx, scope, (Scriptable)thisObj, args);
        }
        return initialValue;
    }
    
    private NativeTypedArrayView<T> js_reverse(final Context cx, final Scriptable scope) {
        final NativeArrayBuffer na = this.makeArrayBuffer(cx, scope, this.length);
        final NativeTypedArrayView<T> view = this.construct(na, 0, this.length);
        for (int i = 0; i < this.length; ++i) {
            view.setArrayElement(i, this.getArrayElement(this.length - i - 1));
        }
        return view;
    }
    
    private boolean js_some(final Context cx, final Scriptable scope, final Object cb, final Object thisObj) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.some");
        final Callable fn = (Callable)cb;
        for (int i = 0; i < this.length; ++i) {
            final Object result = fn.call(cx, scope, (Scriptable)thisObj, new Object[] { this.getArrayElement(i), i, thisObj });
            if (!this.isFalsey(result)) {
                return true;
            }
        }
        return false;
    }
    
    private NativeTypedArrayView<T> js_copyWithin(final Object _target, final Object _start, final Object _end) {
        if (_target == null) {
            return this;
        }
        final int target = (int)ScriptRuntime.toNumber(_target);
        final int start = (int)ScriptRuntime.toNumber(_start);
        final int end = (int)ScriptRuntime.toNumber(_end);
        int copyLength = Math.max(end - start, 0);
        if (copyLength == 0) {
            return this;
        }
        if (target + copyLength >= this.length) {
            copyLength = this.length - target;
        }
        final LinkedList<Object> ll = new LinkedList<Object>();
        for (int i = 0; i < copyLength; ++i) {
            ll.add(this.getArrayElement(start + i));
        }
        int i = 0;
        for (final Object el : ll) {
            this.setArrayElement(target + i++, el);
        }
        return this;
    }
    
    private Object js_find(final Context cx, final Scriptable scope, final Object cb, final Object thisObj) {
        final int index = this.js_findIndex(cx, scope, cb, thisObj);
        if (index == -1) {
            return Undefined.instance;
        }
        return this.getArrayElement(index);
    }
    
    private int js_findIndex(final Context cx, final Scriptable scope, final Object cb, final Object thisObj) {
        this.validateFunctionalArgs(cb, thisObj, "%TypedArray%.prototype.findIndex");
        final Callable fn = (Callable)cb;
        for (int i = 0; i < this.length; ++i) {
            final Object el = this.getArrayElement(i);
            final Object[] args = { el, i, thisObj };
            final Object result = fn.call(cx, scope, (Scriptable)thisObj, args);
            if (!this.isFalsey(result)) {
                return i;
            }
        }
        return -1;
    }
    
    private NativeTypedArrayView<T> js_fill(final Object value, final Object _start, final Object _end) {
        if (value == null) {
            return this;
        }
        final int start = (int)ScriptRuntime.toNumber(_start);
        for (int end = (int)ScriptRuntime.toNumber(_end), i = start; i < end; ++i) {
            this.setArrayElement(i, value);
        }
        return this;
    }
    
    private NativeTypedArrayView<T> js_sort(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object sorter) {
        Comparator<T> cmp;
        if (sorter == null) {
            cmp = Comparable::compareTo;
        }
        else {
            if (!(sorter instanceof Callable)) {
                throw ScriptRuntime.typeError1("msg.isnt.function", (Object)ScriptRuntime.toString(sorter));
            }
            final Callable fn = (Callable)sorter;
            final Object result;
            cmp = ((a, b) -> {
                result = fn.call(cx, scope, thisObj, new Object[] { a, b });
                if (result instanceof Scriptable) {
                    return this.isFalsey(result) ? 0 : 1;
                }
                else {
                    return (int)ScriptRuntime.toNumber(result);
                }
            });
        }
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < this.length - 1; ++i) {
                final Object el1 = this.getArrayElement(i);
                final Object el2 = this.getArrayElement(i + 1);
                final int res = cmp.compare((T)el1, (T)el2);
                if (res > 0) {
                    sorted = false;
                    this.setArrayElement(i, el2);
                    this.setArrayElement(i + 1, el1);
                }
            }
        } while (!sorted);
        return this;
    }
    
    private boolean js_includes(final Object searchElement, final int fromIndex) {
        if (this.length <= 0) {
            return false;
        }
        int k = (fromIndex >= 0) ? fromIndex : (this.length + fromIndex);
        if (k < 0) {
            k = 0;
        }
        while (k < this.length) {
            if (ScriptRuntime.shallowEq(this.getArrayElement(k), searchElement)) {
                return true;
            }
            ++k;
        }
        return false;
    }
    
    private void validateFunctionalArgs(final Object cb, final Object thisObj, final String errorStr) {
        if (cb == null) {
            throw ScriptRuntime.typeError2("msg.typed.array.missing.argument", (Object)"0", (Object)errorStr);
        }
        if (!(cb instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.isnt.function", (Object)ScriptRuntime.toString(cb));
        }
        if (!(thisObj instanceof Scriptable)) {
            throw ScriptRuntime.typeError2("msg.typed.array.invalid.argument", (Object)"1", (Object)errorStr);
        }
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (SymbolKey.ITERATOR.equals((Object)k)) {
            return 27;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        Label_0616: {
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
                    else if (c == 109) {
                        if (s.charAt(2) == 'p' && s.charAt(1) == 'a') {
                            id = 13;
                            return id;
                        }
                        break;
                    }
                    else {
                        if (c == 115 && s.charAt(2) == 't' && s.charAt(1) == 'e') {
                            id = 4;
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
                            id = 6;
                            break Label_0616;
                        }
                        case 'l': {
                            X = "fill";
                            id = 21;
                            break Label_0616;
                        }
                        case 'm': {
                            X = "some";
                            id = 17;
                            break Label_0616;
                        }
                        case 'n': {
                            X = "find";
                            id = 19;
                            break Label_0616;
                        }
                        case 'r': {
                            X = "sort";
                            id = 25;
                            break Label_0616;
                        }
                        case 'y': {
                            X = "keys";
                            id = 22;
                            break Label_0616;
                        }
                        default: {
                            break Label_0616;
                        }
                    }
                    break;
                }
                case 5: {
                    final int c = s.charAt(0);
                    if (c == 101) {
                        X = "every";
                        id = 10;
                        break;
                    }
                    if (c == 115) {
                        X = "slice";
                        id = 9;
                        break;
                    }
                    break;
                }
                case 6: {
                    final int c = s.charAt(0);
                    if (c == 102) {
                        X = "filter";
                        id = 11;
                        break;
                    }
                    if (c == 114) {
                        X = "reduce";
                        id = 14;
                        break;
                    }
                    if (c == 118) {
                        X = "values";
                        id = 23;
                        break;
                    }
                    break;
                }
                case 7: {
                    switch (s.charAt(0)) {
                        case 'e': {
                            X = "entries";
                            id = 24;
                            break Label_0616;
                        }
                        case 'f': {
                            X = "forEach";
                            id = 12;
                            break Label_0616;
                        }
                        case 'i': {
                            X = "indexOf";
                            id = 7;
                            break Label_0616;
                        }
                        case 'r': {
                            X = "reverse";
                            id = 16;
                            break Label_0616;
                        }
                        default: {
                            break Label_0616;
                        }
                    }
                    break;
                }
                case 8: {
                    final int c = s.charAt(0);
                    if (c == 105) {
                        X = "includes";
                        id = 26;
                        break;
                    }
                    if (c == 115) {
                        X = "subarray";
                        id = 5;
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
                    id = 20;
                    break;
                }
                case 10: {
                    X = "copyWithin";
                    id = 18;
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
                        id = 8;
                        break;
                    }
                    if (c == 114) {
                        X = "reduceRight";
                        id = 15;
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
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        ctor.put("BYTES_PER_ELEMENT", (Scriptable)ctor, (Object)ScriptRuntime.wrapInt(this.getBytesPerElement()));
    }
    
    protected int getMaxInstanceId() {
        return 5;
    }
    
    protected String getInstanceIdName(final int id) {
        switch (id) {
            case 4: {
                return "length";
            }
            case 5: {
                return "BYTES_PER_ELEMENT";
            }
            default: {
                return super.getInstanceIdName(id);
            }
        }
    }
    
    protected Object getInstanceIdValue(final int id) {
        switch (id) {
            case 4: {
                return ScriptRuntime.wrapInt(this.length);
            }
            case 5: {
                return ScriptRuntime.wrapInt(this.getBytesPerElement());
            }
            default: {
                return super.getInstanceIdValue(id);
            }
        }
    }
    
    protected int findInstanceIdInfo(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 6) {
            X = "length";
            id = 4;
        }
        else if (s_length == 17) {
            X = "BYTES_PER_ELEMENT";
            id = 5;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        if (id == 0) {
            return super.findInstanceIdInfo(s);
        }
        return instanceIdInfo(5, id);
    }
    
    public Object getArrayElement(final int index) {
        return this.js_get(index);
    }
    
    public void setArrayElement(final int index, final Object value) {
        this.js_set(index, value);
    }
    
    public int getArrayLength() {
        return this.length;
    }
    
    public boolean containsAll(final Collection<?> objects) {
        for (final Object o : objects) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }
    
    public int indexOf(final Object o) {
        for (int i = 0; i < this.length; ++i) {
            if (o.equals(this.js_get(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public int lastIndexOf(final Object o) {
        for (int i = this.length - 1; i >= 0; --i) {
            if (o.equals(this.js_get(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public Object[] toArray() {
        final Object[] a = new Object[this.length];
        for (int i = 0; i < this.length; ++i) {
            a[i] = this.js_get(i);
        }
        return a;
    }
    
    public <U> U[] toArray(final U[] ts) {
        U[] a;
        if (ts.length >= this.length) {
            a = ts;
        }
        else {
            a = (U[])Array.newInstance(ts.getClass().getComponentType(), this.length);
        }
        for (int i = 0; i < this.length; ++i) {
            try {
                a[i] = (U)this.js_get(i);
            }
            catch (ClassCastException cce) {
                throw new ArrayStoreException();
            }
        }
        return a;
    }
    
    public int size() {
        return this.length;
    }
    
    public boolean isEmpty() {
        return this.length == 0;
    }
    
    public boolean contains(final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    public boolean equals(final Object o) {
        try {
            final NativeTypedArrayView<T> v = (NativeTypedArrayView<T>)o;
            if (this.length != v.length) {
                return false;
            }
            for (int i = 0; i < this.length; ++i) {
                if (!this.js_get(i).equals(v.js_get(i))) {
                    return false;
                }
            }
            return true;
        }
        catch (ClassCastException cce) {
            return false;
        }
    }
    
    public int hashCode() {
        int hc = 0;
        for (int i = 0; i < this.length; ++i) {
            hc += this.js_get(i).hashCode();
        }
        return hc;
    }
    
    public Iterator<T> iterator() {
        return (Iterator<T>)new NativeTypedArrayIterator(this, 0);
    }
    
    public ListIterator<T> listIterator() {
        return (ListIterator<T>)new NativeTypedArrayIterator(this, 0);
    }
    
    public ListIterator<T> listIterator(final int start) {
        if (this.checkIndex(start)) {
            throw new IndexOutOfBoundsException();
        }
        return (ListIterator<T>)new NativeTypedArrayIterator(this, start);
    }
    
    public List<T> subList(final int i, final int i2) {
        throw new UnsupportedOperationException();
    }
    
    public boolean add(final T aByte) {
        throw new UnsupportedOperationException();
    }
    
    public void add(final int i, final T aByte) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAll(final Collection<? extends T> bytes) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAll(final int i, final Collection<? extends T> bytes) {
        throw new UnsupportedOperationException();
    }
    
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    public T remove(final int i) {
        throw new UnsupportedOperationException();
    }
    
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(final Collection<?> objects) {
        throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(final Collection<?> objects) {
        throw new UnsupportedOperationException();
    }
}
