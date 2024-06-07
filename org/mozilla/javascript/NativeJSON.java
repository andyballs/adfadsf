//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.json.*;
import org.mozilla.javascript.proxy.*;
import java.util.*;

public final class NativeJSON extends IdScriptableObject
{
    private static final long serialVersionUID = -4567599697595654984L;
    private static final Object JSON_TAG;
    private static final int MAX_STRINGIFY_GAP_LENGTH = 10;
    private static final int Id_toSource = 1;
    private static final int Id_parse = 2;
    private static final int Id_stringify = 3;
    private static final int LAST_METHOD_ID = 3;
    private static final int SymbolId_toStringTag = 4;
    private static final int MAX_ID = 4;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeJSON obj = new NativeJSON();
        obj.activatePrototypeMap(4);
        obj.setPrototype(getObjectPrototype(scope));
        obj.setParentScope(scope);
        if (sealed) {
            obj.sealObject();
        }
        ScriptableObject.defineProperty(scope, "JSON", obj, 2);
    }
    
    private NativeJSON() {
    }
    
    public String getClassName() {
        return "JSON";
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 4) {
            this.initPrototypeValue(id, (Symbol)SymbolKey.TO_STRING_TAG, NativeJSON.JSON_TAG, 0);
            return;
        }
        if (id <= 3) {
            int arity = 0;
            String name = null;
            switch (id) {
                case 1: {
                    arity = 0;
                    name = "toSource";
                    break;
                }
                case 2: {
                    arity = 2;
                    name = "parse";
                    break;
                }
                case 3: {
                    arity = 3;
                    name = "stringify";
                    break;
                }
                default: {
                    throw new IllegalStateException(String.valueOf(id));
                }
            }
            this.initPrototypeMethod(NativeJSON.JSON_TAG, id, name, arity);
            return;
        }
        throw new IllegalStateException(String.valueOf(id));
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeJSON.JSON_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int methodId = f.methodId();
        switch (methodId) {
            case 1: {
                return "JSON";
            }
            case 2: {
                final String jtext = ScriptRuntime.toString(args, 0);
                Object reviver = null;
                if (args.length > 1) {
                    reviver = args[1];
                }
                if (reviver instanceof Callable) {
                    return parse(cx, scope, jtext, (Callable)reviver);
                }
                return parse(cx, scope, jtext);
            }
            case 3: {
                Object value = null;
                Object replacer = null;
                Object space = null;
                switch (args.length) {
                    case 3: {
                        space = args[2];
                    }
                    case 2: {
                        replacer = args[1];
                    }
                    case 1: {
                        value = args[0];
                        break;
                    }
                }
                return stringify(cx, scope, value, replacer, space);
            }
            default: {
                throw new IllegalStateException(String.valueOf(methodId));
            }
        }
    }
    
    private static Object parse(final Context cx, final Scriptable scope, final String jtext) {
        try {
            return new JsonParser(cx, scope).parseValue(jtext);
        }
        catch (JsonParser.ParseException ex) {
            throw ScriptRuntime.constructError("SyntaxError", ex.getMessage());
        }
    }
    
    public static Object parse(final Context cx, final Scriptable scope, final String jtext, final Callable reviver) {
        final Object unfiltered = parse(cx, scope, jtext);
        final Scriptable root = (Scriptable)cx.newObject(scope);
        root.put("", root, unfiltered);
        return walk(cx, scope, reviver, root, "");
    }
    
    private static Object walk(final Context cx, final Scriptable scope, final Callable reviver, final Scriptable holder, final Object name) {
        Object property;
        if (name instanceof Number) {
            property = holder.get(((Number)name).intValue(), holder);
        }
        else {
            property = holder.get((String)name, holder);
        }
        if (property instanceof Scriptable) {
            final Scriptable val = (Scriptable)property;
            if (ScriptRuntime.isArray(val)) {
                for (long len = ScriptRuntime.getArray(val).getLength(), i = 0L; i < len; ++i) {
                    if (i > 2147483647L) {
                        final String id = Long.toString(i);
                        final Object newElement = walk(cx, scope, reviver, val, id);
                        if (newElement == Undefined.instance) {
                            val.delete(id);
                        }
                        else {
                            val.put(id, val, newElement);
                        }
                    }
                    else {
                        final int idx = (int)i;
                        final Object newElement = walk(cx, scope, reviver, val, idx);
                        if (newElement == Undefined.instance) {
                            val.delete(idx);
                        }
                        else {
                            val.put(idx, val, newElement);
                        }
                    }
                }
            }
            else {
                final Object[] ids;
                final Object[] keys = ids = val.getIds();
                for (final Object p : ids) {
                    final Object newElement = walk(cx, scope, reviver, val, p);
                    if (newElement == Undefined.instance) {
                        if (p instanceof Number) {
                            val.delete(((Number)p).intValue());
                        }
                        else {
                            val.delete((String)p);
                        }
                    }
                    else if (p instanceof Number) {
                        val.put(((Number)p).intValue(), val, newElement);
                    }
                    else {
                        val.put((String)p, val, newElement);
                    }
                }
            }
        }
        return reviver.call(cx, scope, holder, new Object[] { name, property });
    }
    
    private static String repeat(final char c, final int count) {
        final char[] chars = new char[count];
        Arrays.fill(chars, c);
        return new String(chars);
    }
    
    public static Object stringify(final Context cx, final Scriptable scope, final Object value, final Object replacer, Object space) {
        final String indent = "";
        String gap = "";
        List<Object> propertyList = null;
        Callable replacerFunction = null;
        if (replacer instanceof Callable) {
            replacerFunction = (Callable)replacer;
        }
        else if (replacer instanceof NativeArray) {
            propertyList = new LinkedList<Object>();
            final NativeArray replacerArray = (NativeArray)replacer;
            for (final int i : replacerArray.getIndexIds()) {
                final Object v = replacerArray.get(i, (Scriptable)replacerArray);
                if (v instanceof String || v instanceof Number) {
                    propertyList.add(v);
                }
                else {
                    if (!(v instanceof NativeString) && !(v instanceof NativeNumber)) {
                        continue;
                    }
                    propertyList.add(ScriptRuntime.toString(v));
                }
            }
        }
        if (space instanceof NativeNumber) {
            space = ScriptRuntime.toNumber(space);
        }
        else if (space instanceof NativeString) {
            space = ScriptRuntime.toString(space);
        }
        if (space instanceof Number) {
            int gapLength = (int)ScriptRuntime.toInteger(space);
            gapLength = Math.min(10, gapLength);
            gap = ((gapLength > 0) ? repeat(' ', gapLength) : "");
            space = gapLength;
        }
        else if (space instanceof String) {
            gap = (String)space;
            if (gap.length() > 10) {
                gap = gap.substring(0, 10);
            }
        }
        final StringifyState state = new StringifyState(cx, scope, indent, gap, replacerFunction, propertyList, space);
        final ScriptableObject wrapper = (ScriptableObject)new NativeObject();
        wrapper.setParentScope(scope);
        if (scope != null) {
            wrapper.setPrototype(ScriptableObject.getObjectPrototype(scope));
        }
        wrapper.defineProperty("", value, 0);
        return str("", wrapper, state);
    }
    
    private static Object str(final Object key, final Scriptable holder, final StringifyState state) {
        Object value;
        if (key instanceof String) {
            value = getProperty(holder, (String)key);
        }
        else {
            value = getProperty(holder, ((Number)key).intValue());
        }
        if (ScriptRuntime.isSymbol(value)) {
            return Undefined.instance;
        }
        if (value instanceof Scriptable && hasProperty((Scriptable)value, "toJSON")) {
            final Object toJSON = getProperty((Scriptable)value, "toJSON");
            if (toJSON instanceof Callable) {
                value = callMethod(state.cx, (Scriptable)value, "toJSON", new Object[] { key });
            }
        }
        if (state.replacer != null) {
            value = state.replacer.call(state.cx, state.scope, holder, new Object[] { key, value });
        }
        if (value instanceof NativeNumber) {
            value = ScriptRuntime.toNumber(value);
        }
        else if (value instanceof NativeString) {
            value = ScriptRuntime.toString(value);
        }
        else if (value instanceof NativeBoolean) {
            value = ((NativeBoolean)value).getDefaultValue((Class)ScriptRuntime.BooleanClass);
        }
        if (value == null) {
            return "null";
        }
        if (value.equals(Boolean.TRUE)) {
            return "true";
        }
        if (value.equals(Boolean.FALSE)) {
            return "false";
        }
        if (value instanceof CharSequence) {
            return quote(value.toString());
        }
        if (value instanceof Number) {
            final double d = ((Number)value).doubleValue();
            if (!Double.isNaN(d) && d != Double.POSITIVE_INFINITY && d != Double.NEGATIVE_INFINITY) {
                return ScriptRuntime.toString(value);
            }
            return "null";
        }
        else {
            if (!(value instanceof Scriptable) || (value instanceof Callable && !(value instanceof NativeProxy))) {
                return Undefined.instance;
            }
            if (ScriptRuntime.isArray(value)) {
                return ja((Scriptable)value, state);
            }
            return jo((Scriptable)value, state);
        }
    }
    
    private static String join(final Collection<Object> objs, final String delimiter) {
        if (objs == null || objs.isEmpty()) {
            return "";
        }
        final Iterator<Object> iter = objs.iterator();
        if (!iter.hasNext()) {
            return "";
        }
        final StringBuilder builder = new StringBuilder(iter.next().toString());
        while (iter.hasNext()) {
            builder.append(delimiter).append(iter.next().toString());
        }
        return builder.toString();
    }
    
    private static String jo(final Scriptable value, final StringifyState state) {
        if (state.stack.search(value) != -1) {
            throw ScriptRuntime.typeError0("msg.cyclic.value");
        }
        state.stack.push(value);
        final String stepback = state.indent;
        state.indent += state.gap;
        Object[] k;
        if (state.propertyList != null) {
            k = state.propertyList.toArray();
        }
        else {
            k = value.getIds();
        }
        final List<Object> partial = new LinkedList<Object>();
        for (final Object p : k) {
            final Object strP = str(p, value, state);
            if (strP != Undefined.instance) {
                String member = quote(p.toString()) + ":";
                if (state.gap.length() > 0) {
                    member += " ";
                }
                member += strP;
                partial.add(member);
            }
        }
        String finalValue;
        if (partial.isEmpty()) {
            finalValue = "{}";
        }
        else if (state.gap.length() == 0) {
            finalValue = '{' + join(partial, ",") + '}';
        }
        else {
            final String separator = ",\n" + state.indent;
            final String properties = join(partial, separator);
            finalValue = "{\n" + state.indent + properties + '\n' + stepback + '}';
        }
        state.stack.pop();
        state.indent = stepback;
        return finalValue;
    }
    
    private static String ja(final Scriptable value, final StringifyState state) {
        if (state.stack.search(value) != -1) {
            throw ScriptRuntime.typeError0("msg.cyclic.value");
        }
        state.stack.push(value);
        final String stepback = state.indent;
        state.indent += state.gap;
        final List<Object> partial = new LinkedList<Object>();
        for (long len = NativeArray.getLengthProperty(value, true), index = 0L; index < len; ++index) {
            Object strP;
            if (index > 2147483647L) {
                strP = str(Long.toString(index), value, state);
            }
            else {
                strP = str((int)index, value, state);
            }
            if (strP == Undefined.instance) {
                partial.add("null");
            }
            else {
                partial.add(strP);
            }
        }
        String finalValue;
        if (partial.isEmpty()) {
            finalValue = "[]";
        }
        else if (state.gap.length() == 0) {
            finalValue = '[' + join(partial, ",") + ']';
        }
        else {
            final String separator = ",\n" + state.indent;
            final String properties = join(partial, separator);
            finalValue = "[\n" + state.indent + properties + '\n' + stepback + ']';
        }
        state.stack.pop();
        state.indent = stepback;
        return finalValue;
    }
    
    private static String quote(final String string) {
        final StringBuilder product = new StringBuilder(string.length() + 2);
        product.append('\"');
        for (int length = string.length(), i = 0; i < length; ++i) {
            final char c = string.charAt(i);
            switch (c) {
                case '\"': {
                    product.append("\\\"");
                    break;
                }
                case '\\': {
                    product.append("\\\\");
                    break;
                }
                case '\b': {
                    product.append("\\b");
                    break;
                }
                case '\f': {
                    product.append("\\f");
                    break;
                }
                case '\n': {
                    product.append("\\n");
                    break;
                }
                case '\r': {
                    product.append("\\r");
                    break;
                }
                case '\t': {
                    product.append("\\t");
                    break;
                }
                default: {
                    if (c < ' ') {
                        product.append("\\u");
                        final String hex = String.format("%04x", (int)c);
                        product.append(hex);
                        break;
                    }
                    product.append(c);
                    break;
                }
            }
        }
        product.append('\"');
        return product.toString();
    }
    
    protected int findPrototypeId(final Symbol key) {
        if (SymbolKey.TO_STRING_TAG.equals(key)) {
            return 4;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 5) {
            X = "parse";
            id = 2;
        }
        else if (s_length == 8) {
            X = "toSource";
            id = 1;
        }
        else if (s_length == 9) {
            X = "stringify";
            id = 3;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        JSON_TAG = "JSON";
    }
    
    private static class StringifyState
    {
        Stack<Scriptable> stack;
        String indent;
        String gap;
        Callable replacer;
        List<Object> propertyList;
        Object space;
        Context cx;
        Scriptable scope;
        
        StringifyState(final Context cx, final Scriptable scope, final String indent, final String gap, final Callable replacer, final List<Object> propertyList, final Object space) {
            this.stack = new Stack<Scriptable>();
            this.cx = cx;
            this.scope = scope;
            this.indent = indent;
            this.gap = gap;
            this.replacer = replacer;
            this.propertyList = propertyList;
            this.space = space;
        }
    }
}
