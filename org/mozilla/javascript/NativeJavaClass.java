//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.lang.reflect.*;

public class NativeJavaClass extends NativeJavaObject implements Function
{
    private static final long serialVersionUID = -6460763940409461664L;
    static final String javaClassPropertyName = "__javaObject__";
    private Map<String, FieldAndMethods> staticFieldAndMethods;
    
    public NativeJavaClass() {
    }
    
    public NativeJavaClass(final Scriptable scope, final Class<?> cl) {
        this(scope, cl, false);
    }
    
    public NativeJavaClass(final Scriptable scope, final Class<?> cl, final boolean isAdapter) {
        super(scope, cl, null, isAdapter);
    }
    
    @Override
    protected void initMembers() {
        final Class<?> cl = (Class<?>)this.javaObject;
        this.members = JavaMembers.lookupClass(this.parent, (Class)cl, (Class)cl, this.isAdapter);
        this.staticFieldAndMethods = (Map<String, FieldAndMethods>)this.members.getFieldAndMethodsObjects((Scriptable)this, (Object)cl, true);
    }
    
    @Override
    public String getClassName() {
        return "JavaClass";
    }
    
    @Override
    public boolean has(final String name, final Scriptable start) {
        return this.members.has(name, true) || "__javaObject__".equals(name);
    }
    
    public Object get(final String name, final Scriptable start) {
        if (name.equals("prototype")) {
            return null;
        }
        if (name.equals("class")) {
            return this.getClassObject();
        }
        if (this.staticFieldAndMethods != null) {
            final Object result = this.staticFieldAndMethods.get(name);
            if (result != null) {
                return result;
            }
        }
        if (this.members.has(name, true)) {
            return this.members.get((Scriptable)this, name, this.javaObject, true);
        }
        final Context cx = Context.getContext();
        final Scriptable scope = ScriptableObject.getTopLevelScope(start);
        final WrapFactory wrapFactory = cx.getWrapFactory();
        if ("__javaObject__".equals(name)) {
            return wrapFactory.wrap(cx, scope, this.javaObject, ScriptRuntime.ClassClass);
        }
        final Class<?> nestedClass = findNestedClass(this.getClassObject(), name);
        if (nestedClass != null) {
            final Scriptable nestedValue = wrapFactory.wrapJavaClass(cx, scope, nestedClass);
            nestedValue.setParentScope(this);
            return nestedValue;
        }
        throw this.members.reportMemberNotFound(name);
    }
    
    public void put(final String name, final Scriptable start, final Object value) {
        this.members.put((Scriptable)this, name, this.javaObject, value, true);
    }
    
    @Override
    public Object[] getIds() {
        return this.members.getIds(true);
    }
    
    public Class<?> getClassObject() {
        return (Class<?>)super.unwrap();
    }
    
    @Override
    public Object getDefaultValue(final Class<?> hint) {
        if (hint == null || hint == ScriptRuntime.StringClass) {
            return this.toString();
        }
        if (hint == ScriptRuntime.BooleanClass) {
            return Boolean.TRUE;
        }
        if (hint == ScriptRuntime.NumberClass) {
            return ScriptRuntime.NaNobj;
        }
        return this;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        throw ScriptRuntime.typeError0("msg.no.java.new");
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        final Class<?> classObject = this.getClassObject();
        final int modifiers = classObject.getModifiers();
        if (!Modifier.isInterface(modifiers) && !Modifier.isAbstract(modifiers)) {
            final NativeJavaMethod ctors = this.members.ctors;
            final int index = ctors.findCachedFunction(cx, args);
            if (index < 0) {
                final String sig = NativeJavaMethod.scriptSignature(args);
                throw Context.reportRuntimeError2("msg.no.java.ctor", (Object)classObject.getName(), (Object)sig);
            }
            return constructSpecific(cx, scope, args, ctors.methods[index]);
        }
        else {
            if (args.length == 0) {
                throw Context.reportRuntimeError0("msg.adapter.zero.args");
            }
            final Scriptable topLevel = ScriptableObject.getTopLevelScope(this);
            String msg = "";
            try {
                if ("Dalvik".equals(System.getProperty("java.vm.name")) && classObject.isInterface()) {
                    final Object obj = NativeJavaObject.createInterfaceAdapter(classObject, ScriptableObject.ensureScriptableObject(args[0]));
                    return cx.getWrapFactory().wrapAsJavaObject(cx, scope, obj, null);
                }
                final Object v = topLevel.get("JavaAdapter", topLevel);
                if (v != NativeJavaClass.NOT_FOUND) {
                    final Function f = (Function)v;
                    final Object[] adapterArgs = { this, args[0] };
                    return f.construct(cx, topLevel, adapterArgs);
                }
            }
            catch (Exception ex) {
                final String m = ex.getMessage();
                if (m != null) {
                    msg = m;
                }
            }
            throw Context.reportRuntimeError2("msg.cant.instantiate", (Object)msg, (Object)classObject.getName());
        }
    }
    
    static Scriptable constructSpecific(final Context cx, final Scriptable scope, final Object[] args, final MemberBox ctor) {
        final Object instance = constructInternal(args, ctor);
        final Scriptable topLevel = ScriptableObject.getTopLevelScope(scope);
        return cx.getWrapFactory().wrapNewObject(cx, topLevel, instance);
    }
    
    static Object constructInternal(Object[] args, final MemberBox ctor) {
        final Class<?>[] argTypes = (Class<?>[])ctor.argTypes;
        if (ctor.vararg) {
            final Object[] newArgs = new Object[argTypes.length];
            for (int i = 0; i < argTypes.length - 1; ++i) {
                newArgs[i] = Context.jsToJava(args[i], (Class)argTypes[i]);
            }
            Object varArgs;
            if (args.length == argTypes.length && (args[args.length - 1] == null || args[args.length - 1] instanceof NativeArray || args[args.length - 1] instanceof NativeJavaArray)) {
                varArgs = Context.jsToJava(args[args.length - 1], (Class)argTypes[argTypes.length - 1]);
            }
            else {
                final Class<?> componentType = argTypes[argTypes.length - 1].getComponentType();
                varArgs = Array.newInstance(componentType, args.length - argTypes.length + 1);
                for (int j = 0; j < Array.getLength(varArgs); ++j) {
                    final Object value = Context.jsToJava(args[argTypes.length - 1 + j], (Class)componentType);
                    Array.set(varArgs, j, value);
                }
            }
            newArgs[argTypes.length - 1] = varArgs;
            args = newArgs;
        }
        else {
            final Object[] origArgs = args;
            for (int i = 0; i < args.length; ++i) {
                final Object arg = args[i];
                final Object x = Context.jsToJava(arg, (Class)argTypes[i]);
                if (x != arg) {
                    if (args == origArgs) {
                        args = origArgs.clone();
                    }
                    args[i] = x;
                }
            }
        }
        return ctor.newInstance(args);
    }
    
    public String toString() {
        return "[JavaClass " + this.getClassObject().getName() + "]";
    }
    
    @Override
    public boolean hasInstance(final Scriptable value) {
        if (value instanceof Wrapper && !(value instanceof NativeJavaClass)) {
            final Object instance = ((Wrapper)value).unwrap();
            return this.getClassObject().isInstance(instance);
        }
        return false;
    }
    
    private static Class<?> findNestedClass(final Class<?> parentClass, final String name) {
        final String nestedClassName = parentClass.getName() + '$' + name;
        final ClassLoader loader = parentClass.getClassLoader();
        if (loader == null) {
            return (Class<?>)Kit.classOrNull(nestedClassName);
        }
        return (Class<?>)Kit.classOrNull(loader, nestedClassName);
    }
}
