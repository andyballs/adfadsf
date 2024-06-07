//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;
import java.io.*;

public class FunctionObject extends BaseFunction
{
    private static final long serialVersionUID = -5332312783643935019L;
    private static final short VARARGS_METHOD = -1;
    private static final short VARARGS_CTOR = -2;
    private static boolean sawSecurityException;
    public static final int JAVA_UNSUPPORTED_TYPE = 0;
    public static final int JAVA_STRING_TYPE = 1;
    public static final int JAVA_INT_TYPE = 2;
    public static final int JAVA_BOOLEAN_TYPE = 3;
    public static final int JAVA_DOUBLE_TYPE = 4;
    public static final int JAVA_SCRIPTABLE_TYPE = 5;
    public static final int JAVA_OBJECT_TYPE = 6;
    MemberBox member;
    private String functionName;
    private transient byte[] typeTags;
    private int parmsLength;
    private transient boolean hasVoidReturn;
    private transient int returnTypeTag;
    private boolean isStatic;
    
    public FunctionObject(final String name, final Member methodOrConstructor, final Scriptable scope) {
        if (methodOrConstructor instanceof Constructor) {
            this.member = new MemberBox((Constructor<?>)methodOrConstructor);
            this.isStatic = true;
        }
        else {
            this.member = new MemberBox((Method)methodOrConstructor);
            this.isStatic = this.member.isStatic();
        }
        final String methodName = this.member.getName();
        this.functionName = name;
        final Class<?>[] types = this.member.argTypes;
        final int arity = types.length;
        if (arity == 4 && (types[1].isArray() || types[2].isArray())) {
            if (types[1].isArray()) {
                if (!this.isStatic || types[0] != ScriptRuntime.ContextClass || types[1].getComponentType() != ScriptRuntime.ObjectClass || types[2] != ScriptRuntime.FunctionClass || types[3] != Boolean.TYPE) {
                    throw Context.reportRuntimeError1("msg.varargs.ctor", (Object)methodName);
                }
                this.parmsLength = -2;
            }
            else {
                if (!this.isStatic || types[0] != ScriptRuntime.ContextClass || types[1] != ScriptRuntime.ScriptableClass || types[2].getComponentType() != ScriptRuntime.ObjectClass || types[3] != ScriptRuntime.FunctionClass) {
                    throw Context.reportRuntimeError1("msg.varargs.fun", (Object)methodName);
                }
                this.parmsLength = -1;
            }
        }
        else if ((this.parmsLength = arity) > 0) {
            this.typeTags = new byte[arity];
            for (int i = 0; i != arity; ++i) {
                final int tag = getTypeTag(types[i]);
                if (tag == 0) {
                    throw Context.reportRuntimeError2("msg.bad.parms", (Object)types[i].getName(), (Object)methodName);
                }
                this.typeTags[i] = (byte)tag;
            }
        }
        if (this.member.isMethod()) {
            final Method method = this.member.method();
            final Class<?> returnType = method.getReturnType();
            if (returnType == Void.TYPE) {
                this.hasVoidReturn = true;
            }
            else {
                this.returnTypeTag = getTypeTag(returnType);
            }
        }
        else {
            final Class<?> ctorType = this.member.getDeclaringClass();
            if (!ScriptRuntime.ScriptableClass.isAssignableFrom(ctorType)) {
                throw Context.reportRuntimeError1("msg.bad.ctor.return", (Object)ctorType.getName());
            }
        }
        ScriptRuntime.setFunctionProtoAndParent(this, scope);
    }
    
    public static int getTypeTag(final Class<?> type) {
        if (type == ScriptRuntime.StringClass) {
            return 1;
        }
        if (type == ScriptRuntime.IntegerClass || type == Integer.TYPE) {
            return 2;
        }
        if (type == ScriptRuntime.BooleanClass || type == Boolean.TYPE) {
            return 3;
        }
        if (type == ScriptRuntime.DoubleClass || type == Double.TYPE) {
            return 4;
        }
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(type)) {
            return 5;
        }
        if (type == ScriptRuntime.ObjectClass) {
            return 6;
        }
        return 0;
    }
    
    public static Object convertArg(final Context cx, final Scriptable scope, final Object arg, final int typeTag) {
        switch (typeTag) {
            case 1: {
                if (arg instanceof String) {
                    return arg;
                }
                return ScriptRuntime.toString(arg);
            }
            case 2: {
                if (arg instanceof Integer) {
                    return arg;
                }
                return ScriptRuntime.toInt32(arg);
            }
            case 3: {
                if (arg instanceof Boolean) {
                    return arg;
                }
                return ScriptRuntime.toBoolean(arg) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 4: {
                if (arg instanceof Double) {
                    return arg;
                }
                return ScriptRuntime.toNumber(arg);
            }
            case 5: {
                return ScriptRuntime.toObjectOrNull(cx, arg, scope);
            }
            case 6: {
                return arg;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public int getArity() {
        return (this.parmsLength < 0) ? 1 : this.parmsLength;
    }
    
    public int getLength() {
        return this.getArity();
    }
    
    public String getFunctionName() {
        return (this.functionName == null) ? "" : this.functionName;
    }
    
    public Member getMethodOrConstructor() {
        if (this.member.isMethod()) {
            return this.member.method();
        }
        return this.member.ctor();
    }
    
    static Method findSingleMethod(final Method[] methods, final String name) {
        Method found = null;
        for (int i = 0, N = methods.length; i != N; ++i) {
            final Method method = methods[i];
            if (method != null && name.equals(method.getName())) {
                if (found != null) {
                    throw Context.reportRuntimeError2("msg.no.overload", (Object)name, (Object)method.getDeclaringClass().getName());
                }
                found = method;
            }
        }
        return found;
    }
    
    static Method[] getMethodList(final Class<?> clazz) {
        Method[] methods = null;
        try {
            if (!FunctionObject.sawSecurityException) {
                methods = clazz.getDeclaredMethods();
            }
        }
        catch (SecurityException e) {
            FunctionObject.sawSecurityException = true;
        }
        if (methods == null) {
            methods = clazz.getMethods();
        }
        int count = 0;
        for (int i = 0; i < methods.length; ++i) {
            Label_0078: {
                if (FunctionObject.sawSecurityException) {
                    if (methods[i].getDeclaringClass() == clazz) {
                        break Label_0078;
                    }
                }
                else if (Modifier.isPublic(methods[i].getModifiers())) {
                    break Label_0078;
                }
                methods[i] = null;
                continue;
            }
            ++count;
        }
        final Method[] result = new Method[count];
        int j = 0;
        for (int k = 0; k < methods.length; ++k) {
            if (methods[k] != null) {
                result[j++] = methods[k];
            }
        }
        return result;
    }
    
    public void addAsConstructor(final Scriptable scope, final Scriptable prototype) {
        this.initAsConstructor(scope, prototype);
        defineProperty(scope, prototype.getClassName(), (Object)this, 2);
    }
    
    void initAsConstructor(final Scriptable scope, final Scriptable prototype) {
        ScriptRuntime.setFunctionProtoAndParent(this, scope);
        this.setImmunePrototypeProperty((Object)prototype);
        prototype.setParentScope((Scriptable)this);
        defineProperty(prototype, "constructor", (Object)this, 7);
        this.setParentScope(scope);
    }
    
    @Deprecated
    public static Object convertArg(final Context cx, final Scriptable scope, final Object arg, final Class<?> desired) {
        final int tag = getTypeTag(desired);
        if (tag == 0) {
            throw Context.reportRuntimeError1("msg.cant.convert", (Object)desired.getName());
        }
        return convertArg(cx, scope, arg, tag);
    }
    
    public Object call(final Context cx, final Scriptable scope, Scriptable thisObj, final Object[] args) {
        boolean checkMethodResult = false;
        final int argsLength = args.length;
        for (int i = 0; i < argsLength; ++i) {
            if (args[i] instanceof ConsString) {
                args[i] = args[i].toString();
            }
        }
        Object result;
        if (this.parmsLength < 0) {
            if (this.parmsLength == -1) {
                final Object[] invokeArgs = { cx, thisObj, args, this };
                result = this.member.invoke(null, invokeArgs);
                checkMethodResult = true;
            }
            else {
                final boolean inNewExpr = thisObj == null;
                final Boolean b = inNewExpr ? Boolean.TRUE : Boolean.FALSE;
                final Object[] invokeArgs2 = { cx, args, this, b };
                result = (this.member.isCtor() ? this.member.newInstance(invokeArgs2) : this.member.invoke(null, invokeArgs2));
            }
        }
        else {
            if (!this.isStatic) {
                final Class<?> clazz = this.member.getDeclaringClass();
                if (!clazz.isInstance(thisObj)) {
                    boolean compatible = false;
                    if (thisObj == scope) {
                        final Scriptable parentScope = this.getParentScope();
                        if (scope != parentScope) {
                            compatible = clazz.isInstance(parentScope);
                            if (compatible) {
                                thisObj = parentScope;
                            }
                        }
                    }
                    if (!compatible) {
                        throw ScriptRuntime.typeError1("msg.incompat.call", this.functionName);
                    }
                }
            }
            Object[] invokeArgs;
            if (this.parmsLength == argsLength) {
                invokeArgs = args;
                for (int j = 0; j != this.parmsLength; ++j) {
                    final Object arg = args[j];
                    final Object converted = convertArg(cx, scope, arg, this.typeTags[j]);
                    if (arg != converted) {
                        if (invokeArgs == args) {
                            invokeArgs = args.clone();
                        }
                        invokeArgs[j] = converted;
                    }
                }
            }
            else if (this.parmsLength == 0) {
                invokeArgs = ScriptRuntime.emptyArgs;
            }
            else {
                invokeArgs = new Object[this.parmsLength];
                for (int j = 0; j != this.parmsLength; ++j) {
                    final Object arg = (j < argsLength) ? args[j] : Undefined.instance;
                    invokeArgs[j] = convertArg(cx, scope, arg, this.typeTags[j]);
                }
            }
            if (this.member.isMethod()) {
                result = this.member.invoke(thisObj, invokeArgs);
                checkMethodResult = true;
            }
            else {
                result = this.member.newInstance(invokeArgs);
            }
        }
        if (checkMethodResult) {
            if (this.hasVoidReturn) {
                result = Undefined.instance;
            }
            else if (this.returnTypeTag == 0) {
                result = cx.getWrapFactory().wrap(cx, scope, result, null);
            }
        }
        return result;
    }
    
    public Scriptable createObject(final Context cx, final Scriptable scope) {
        if (this.member.isCtor() || this.parmsLength == -2) {
            return null;
        }
        Scriptable result;
        try {
            result = (Scriptable)this.member.getDeclaringClass().newInstance();
        }
        catch (Exception ex) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex);
        }
        result.setPrototype(this.getClassPrototype());
        result.setParentScope(this.getParentScope());
        return result;
    }
    
    boolean isVarArgsMethod() {
        return this.parmsLength == -1;
    }
    
    boolean isVarArgsConstructor() {
        return this.parmsLength == -2;
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (this.parmsLength > 0) {
            final Class<?>[] types = this.member.argTypes;
            this.typeTags = new byte[this.parmsLength];
            for (int i = 0; i != this.parmsLength; ++i) {
                this.typeTags[i] = (byte)getTypeTag(types[i]);
            }
        }
        if (this.member.isMethod()) {
            final Method method = this.member.method();
            final Class<?> returnType = method.getReturnType();
            if (returnType == Void.TYPE) {
                this.hasVoidReturn = true;
            }
            else {
                this.returnTypeTag = getTypeTag(returnType);
            }
        }
    }
}
