//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;
import java.util.*;

public class NativeJavaArray extends NativeJavaObject implements SymbolScriptable
{
    private static final long serialVersionUID = -924022554283675333L;
    Object array;
    int length;
    Class<?> cls;
    
    @Override
    public String getClassName() {
        return "JavaArray";
    }
    
    public static NativeJavaArray wrap(final Scriptable scope, final Object array) {
        return new NativeJavaArray(scope, array);
    }
    
    @Override
    public Object unwrap() {
        return this.array;
    }
    
    public NativeJavaArray(final Scriptable scope, final Object array) {
        super(scope, null, ScriptRuntime.ObjectClass);
        final Class<?> cl = array.getClass();
        if (!cl.isArray()) {
            throw new RuntimeException("Array expected");
        }
        this.array = array;
        this.length = Array.getLength(array);
        this.cls = cl.getComponentType();
    }
    
    @Override
    public boolean has(final String id, final Scriptable start) {
        return id.equals("length") || super.has(id, start);
    }
    
    @Override
    public boolean has(final int index, final Scriptable start) {
        return 0 <= index && index < this.length;
    }
    
    @Override
    public boolean has(final Symbol key, final Scriptable start) {
        return SymbolKey.IS_CONCAT_SPREADABLE.equals(key);
    }
    
    @Override
    public Object get(final String id, final Scriptable start) {
        if (id.equals("length")) {
            return this.length;
        }
        final Object result = super.get(id, start);
        if (result == NativeJavaArray.NOT_FOUND && !ScriptableObject.hasProperty(this.getPrototype(), id)) {
            throw Context.reportRuntimeError2("msg.java.member.not.found", (Object)this.array.getClass().getName(), (Object)id);
        }
        return result;
    }
    
    @Override
    public Object get(final int index, final Scriptable start) {
        if (0 <= index && index < this.length) {
            final Context cx = Context.getContext();
            final Object obj = Array.get(this.array, index);
            return cx.getWrapFactory().wrap(cx, this, obj, this.cls);
        }
        return Undefined.instance;
    }
    
    @Override
    public Object get(final Symbol key, final Scriptable start) {
        if (SymbolKey.IS_CONCAT_SPREADABLE.equals(key)) {
            return true;
        }
        return Scriptable.NOT_FOUND;
    }
    
    @Override
    public void put(final String id, final Scriptable start, final Object value) {
        if (!id.equals("length")) {
            throw Context.reportRuntimeError1("msg.java.array.member.not.found", (Object)id);
        }
    }
    
    @Override
    public void put(final int index, final Scriptable start, final Object value) {
        if (0 <= index && index < this.length) {
            Array.set(this.array, index, Context.jsToJava(value, (Class)this.cls));
            return;
        }
        throw Context.reportRuntimeError2("msg.java.array.index.out.of.bounds", (Object)String.valueOf(index), (Object)String.valueOf(this.length - 1));
    }
    
    @Override
    public void delete(final Symbol key) {
    }
    
    @Override
    public Object getDefaultValue(final Class<?> hint) {
        if (hint == null || hint == ScriptRuntime.StringClass) {
            final Class<?> eClass = this.array.getClass();
            if (eClass == byte[].class) {
                return Arrays.toString((byte[])this.array);
            }
            if (eClass == short[].class) {
                return Arrays.toString((short[])this.array);
            }
            if (eClass == int[].class) {
                return Arrays.toString((int[])this.array);
            }
            if (eClass == long[].class) {
                return Arrays.toString((long[])this.array);
            }
            if (eClass == char[].class) {
                return Arrays.toString((char[])this.array);
            }
            if (eClass == float[].class) {
                return Arrays.toString((float[])this.array);
            }
            if (eClass == double[].class) {
                return Arrays.toString((double[])this.array);
            }
            if (eClass == boolean[].class) {
                return Arrays.toString((boolean[])this.array);
            }
            return Arrays.deepToString((Object[])this.array);
        }
        else {
            if (hint == ScriptRuntime.BooleanClass) {
                return Boolean.TRUE;
            }
            if (hint == ScriptRuntime.NumberClass) {
                return ScriptRuntime.NaNobj;
            }
            return this;
        }
    }
    
    @Override
    public Object[] getIds() {
        final Object[] result = new Object[this.length];
        int i = this.length;
        while (--i >= 0) {
            result[i] = i;
        }
        return result;
    }
    
    @Override
    public boolean hasInstance(final Scriptable value) {
        if (!(value instanceof Wrapper)) {
            return false;
        }
        final Object instance = ((Wrapper)value).unwrap();
        return this.cls.isInstance(instance);
    }
    
    @Override
    public Scriptable getPrototype() {
        if (this.prototype == null) {
            this.prototype = ScriptableObject.getArrayPrototype(this.getParentScope());
        }
        return this.prototype;
    }
}
