//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import org.mozilla.classfile.*;
import java.lang.reflect.*;
import java.security.*;
import java.util.*;

public final class JavaAdapter implements IdFunctionCall
{
    private static final Object FTAG;
    private static final int Id_JavaAdapter = 1;
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final JavaAdapter obj = new JavaAdapter();
        final IdFunctionObject ctor = new IdFunctionObject((IdFunctionCall)obj, JavaAdapter.FTAG, 1, "JavaAdapter", 1, scope);
        ctor.markAsConstructor((Scriptable)null);
        if (sealed) {
            ctor.sealObject();
        }
        ctor.exportAsScopeProperty();
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (f.hasTag(JavaAdapter.FTAG) && f.methodId() == 1) {
            return js_createAdapter(cx, scope, args);
        }
        throw f.unknown();
    }
    
    public static Object convertResult(final Object result, final Class<?> c) {
        if (result == Undefined.instance && c != ScriptRuntime.ObjectClass && c != ScriptRuntime.StringClass) {
            return null;
        }
        return Context.jsToJava(result, (Class)c);
    }
    
    public static Scriptable createAdapterWrapper(final Scriptable obj, final Object adapter) {
        final Scriptable scope = ScriptableObject.getTopLevelScope(obj);
        final NativeJavaObject res = new NativeJavaObject(scope, adapter, null, true);
        res.setPrototype(obj);
        return res;
    }
    
    public static Object getAdapterSelf(final Class<?> adapterClass, final Object adapter) throws NoSuchFieldException, IllegalAccessException {
        final Field self = adapterClass.getDeclaredField("self");
        return self.get(adapter);
    }
    
    static Object js_createAdapter(final Context cx, final Scriptable scope, final Object[] args) {
        final int N = args.length;
        if (N == 0) {
            throw ScriptRuntime.typeError0("msg.adapter.zero.args");
        }
        int classCount;
        for (classCount = 0; classCount < N - 1; ++classCount) {
            final Object arg = args[classCount];
            if (arg instanceof NativeObject) {
                break;
            }
            if (!(arg instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(classCount), ScriptRuntime.toString(arg));
            }
        }
        Class<?> superClass = null;
        final Class<?>[] intfs = (Class<?>[])new Class[classCount];
        int interfaceCount = 0;
        for (int i = 0; i < classCount; ++i) {
            final Class<?> c = ((NativeJavaClass)args[i]).getClassObject();
            if (!c.isInterface()) {
                if (superClass != null) {
                    throw ScriptRuntime.typeError2("msg.only.one.super", superClass.getName(), c.getName());
                }
                superClass = c;
            }
            else {
                intfs[interfaceCount++] = c;
            }
        }
        if (superClass == null) {
            superClass = ScriptRuntime.ObjectClass;
        }
        final Class<?>[] interfaces = (Class<?>[])new Class[interfaceCount];
        System.arraycopy(intfs, 0, interfaces, 0, interfaceCount);
        final Scriptable obj = ScriptableObject.ensureScriptable(args[classCount]);
        final Class<?> adapterClass = getAdapterClass(scope, superClass, interfaces, obj);
        final int argsCount = N - classCount - 1;
        try {
            Object adapter;
            if (argsCount > 0) {
                final Object[] ctorArgs = new Object[argsCount + 2];
                ctorArgs[0] = obj;
                ctorArgs[1] = cx.getFactory();
                System.arraycopy(args, classCount + 1, ctorArgs, 2, argsCount);
                final NativeJavaClass classWrapper = new NativeJavaClass(scope, adapterClass, true);
                final NativeJavaMethod ctors = classWrapper.members.ctors;
                final int index = ctors.findCachedFunction(cx, ctorArgs);
                if (index < 0) {
                    final String sig = NativeJavaMethod.scriptSignature(args);
                    throw Context.reportRuntimeError2("msg.no.java.ctor", (Object)adapterClass.getName(), (Object)sig);
                }
                adapter = NativeJavaClass.constructInternal(ctorArgs, ctors.methods[index]);
            }
            else {
                final Class<?>[] ctorParms = (Class<?>[])new Class[] { ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass };
                final Object[] ctorArgs2 = { obj, cx.getFactory() };
                adapter = adapterClass.getConstructor(ctorParms).newInstance(ctorArgs2);
            }
            final Object self = getAdapterSelf(adapterClass, adapter);
            if (self instanceof Wrapper) {
                final Object unwrapped = ((Wrapper)self).unwrap();
                if (unwrapped instanceof Scriptable) {
                    if (unwrapped instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject)unwrapped, scope);
                    }
                    return unwrapped;
                }
            }
            return self;
        }
        catch (Exception ex) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex);
        }
    }
    
    public static void writeAdapterObject(final Object javaObject, final ObjectOutputStream out) throws IOException {
        final Class<?> cl = javaObject.getClass();
        out.writeObject(cl.getSuperclass().getName());
        final Class<?>[] interfaces = cl.getInterfaces();
        final String[] interfaceNames = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; ++i) {
            interfaceNames[i] = interfaces[i].getName();
        }
        out.writeObject(interfaceNames);
        try {
            final Object delegee = cl.getField("delegee").get(javaObject);
            out.writeObject(delegee);
            return;
        }
        catch (IllegalAccessException ex) {}
        catch (NoSuchFieldException ex2) {}
        throw new IOException();
    }
    
    public static Object readAdapterObject(final Scriptable self, final ObjectInputStream in) throws IOException, ClassNotFoundException {
        final Context cx = Context.getCurrentContext();
        ContextFactory factory;
        if (cx != null) {
            factory = cx.getFactory();
        }
        else {
            factory = null;
        }
        final Class<?> superClass = Class.forName((String)in.readObject());
        final String[] interfaceNames = (String[])in.readObject();
        final Class<?>[] interfaces = (Class<?>[])new Class[interfaceNames.length];
        for (int i = 0; i < interfaceNames.length; ++i) {
            interfaces[i] = Class.forName(interfaceNames[i]);
        }
        final Scriptable delegee = (Scriptable)in.readObject();
        final Class<?> adapterClass = getAdapterClass(self, superClass, interfaces, delegee);
        final Class<?>[] ctorParms = (Class<?>[])new Class[] { ScriptRuntime.ContextFactoryClass, ScriptRuntime.ScriptableClass, ScriptRuntime.ScriptableClass };
        final Object[] ctorArgs = { factory, delegee, self };
        try {
            return adapterClass.getConstructor(ctorParms).newInstance(ctorArgs);
        }
        catch (InstantiationException ex) {}
        catch (IllegalAccessException ex2) {}
        catch (InvocationTargetException ex3) {}
        catch (NoSuchMethodException ex4) {}
        throw new ClassNotFoundException("adapter");
    }
    
    private static ObjToIntMap getObjectFunctionNames(final Scriptable obj) {
        final Object[] ids = ScriptableObject.getPropertyIds(obj);
        final ObjToIntMap map = new ObjToIntMap(ids.length);
        for (int i = 0; i != ids.length; ++i) {
            if (ids[i] instanceof String) {
                final String id = (String)ids[i];
                final Object value = ScriptableObject.getProperty(obj, id);
                if (value instanceof Function) {
                    final Function f = (Function)value;
                    int length = ScriptRuntime.toInt32(ScriptableObject.getProperty((Scriptable)f, "length"));
                    if (length < 0) {
                        length = 0;
                    }
                    map.put(id, length);
                }
            }
        }
        return map;
    }
    
    private static Class<?> getAdapterClass(final Scriptable scope, final Class<?> superClass, final Class<?>[] interfaces, final Scriptable obj) {
        final ClassCache cache = ClassCache.get(scope);
        final Map<JavaAdapterSignature, Class<?>> generated = (Map<JavaAdapterSignature, Class<?>>)cache.getInterfaceAdapterCacheMap();
        final ObjToIntMap names = getObjectFunctionNames(obj);
        final JavaAdapterSignature sig = new JavaAdapterSignature(superClass, interfaces, names);
        Class<?> adapterClass = generated.get(sig);
        if (adapterClass == null) {
            final String adapterName = "adapter" + cache.newClassSerialNumber();
            final byte[] code = createAdapterCode(names, adapterName, superClass, interfaces, null);
            adapterClass = loadAdapterClass(adapterName, code);
            if (cache.isCachingEnabled()) {
                generated.put(sig, adapterClass);
            }
        }
        return adapterClass;
    }
    
    public static byte[] createAdapterCode(final ObjToIntMap functionNames, final String adapterName, final Class<?> superClass, final Class<?>[] interfaces, final String scriptClassName) {
        final ClassFileWriter cfw = new ClassFileWriter(adapterName, superClass.getName(), "<adapter>");
        cfw.addField("factory", "Lorg/mozilla/javascript/ContextFactory;", (short)17);
        cfw.addField("delegee", "Lorg/mozilla/javascript/Scriptable;", (short)17);
        cfw.addField("self", "Lorg/mozilla/javascript/Scriptable;", (short)17);
        final int interfacesCount = (interfaces == null) ? 0 : interfaces.length;
        for (int i = 0; i < interfacesCount; ++i) {
            if (interfaces[i] != null) {
                cfw.addInterface(interfaces[i].getName());
            }
        }
        final String superName = superClass.getName().replace('.', '/');
        final Constructor<?>[] declaredConstructors;
        final Constructor<?>[] ctors = declaredConstructors = superClass.getDeclaredConstructors();
        for (final Constructor<?> ctor : declaredConstructors) {
            final int mod = ctor.getModifiers();
            if (Modifier.isPublic(mod) || Modifier.isProtected(mod)) {
                generateCtor(cfw, adapterName, superName, ctor);
            }
        }
        generateSerialCtor(cfw, adapterName, superName);
        if (scriptClassName != null) {
            generateEmptyCtor(cfw, adapterName, superName, scriptClassName);
        }
        final ObjToIntMap generatedOverrides = new ObjToIntMap();
        final ObjToIntMap generatedMethods = new ObjToIntMap();
        for (int j = 0; j < interfacesCount; ++j) {
            final Method[] methods = interfaces[j].getMethods();
            for (int k = 0; k < methods.length; ++k) {
                final Method method = methods[k];
                final int mods = method.getModifiers();
                if (!Modifier.isStatic(mods) && !Modifier.isFinal(mods)) {
                    if (!method.isDefault()) {
                        final String methodName = method.getName();
                        final Class<?>[] argTypes = method.getParameterTypes();
                        if (!functionNames.has(methodName)) {
                            try {
                                superClass.getMethod(methodName, argTypes);
                                continue;
                            }
                            catch (NoSuchMethodException ex) {}
                        }
                        final String methodSignature = getMethodSignature(method, argTypes);
                        final String methodKey = methodName + methodSignature;
                        if (!generatedOverrides.has(methodKey)) {
                            generateMethod(cfw, adapterName, methodName, argTypes, method.getReturnType(), true);
                            generatedOverrides.put(methodKey, 0);
                            generatedMethods.put(methodName, 0);
                        }
                    }
                }
            }
        }
        final Method[] methods2 = getOverridableMethods(superClass);
        for (int l = 0; l < methods2.length; ++l) {
            final Method method2 = methods2[l];
            final int mods2 = method2.getModifiers();
            final boolean isAbstractMethod = Modifier.isAbstract(mods2);
            final String methodName = method2.getName();
            if (isAbstractMethod || functionNames.has(methodName)) {
                final Class<?>[] argTypes = method2.getParameterTypes();
                final String methodSignature = getMethodSignature(method2, argTypes);
                final String methodKey = methodName + methodSignature;
                if (!generatedOverrides.has(methodKey)) {
                    generateMethod(cfw, adapterName, methodName, argTypes, method2.getReturnType(), true);
                    generatedOverrides.put(methodKey, 0);
                    generatedMethods.put(methodName, 0);
                    if (!isAbstractMethod) {
                        generateSuper(cfw, adapterName, superName, methodName, methodSignature, argTypes, method2.getReturnType());
                    }
                }
            }
        }
        final ObjToIntMap.Iterator iter = new ObjToIntMap.Iterator(functionNames);
        iter.start();
        while (!iter.done()) {
            final String functionName = (String)iter.getKey();
            if (!generatedMethods.has(functionName)) {
                final int length = iter.getValue();
                final Class<?>[] parms = (Class<?>[])new Class[length];
                for (int m = 0; m < length; ++m) {
                    parms[m] = ScriptRuntime.ObjectClass;
                }
                generateMethod(cfw, adapterName, functionName, parms, ScriptRuntime.ObjectClass, false);
            }
            iter.next();
        }
        return cfw.toByteArray();
    }
    
    static Method[] getOverridableMethods(final Class<?> clazz) {
        final ArrayList<Method> list = new ArrayList<Method>();
        final HashSet<String> skip = new HashSet<String>();
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            appendOverridableMethods(c, list, skip);
        }
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            for (final Class<?> intf : c.getInterfaces()) {
                appendOverridableMethods(intf, list, skip);
            }
        }
        return list.toArray(new Method[list.size()]);
    }
    
    private static void appendOverridableMethods(final Class<?> c, final ArrayList<Method> list, final HashSet<String> skip) {
        final Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; ++i) {
            final String methodKey = methods[i].getName() + getMethodSignature(methods[i], methods[i].getParameterTypes());
            if (!skip.contains(methodKey)) {
                final int mods = methods[i].getModifiers();
                if (!Modifier.isStatic(mods)) {
                    if (Modifier.isFinal(mods)) {
                        skip.add(methodKey);
                    }
                    else if (Modifier.isPublic(mods) || Modifier.isProtected(mods)) {
                        list.add(methods[i]);
                        skip.add(methodKey);
                    }
                }
            }
        }
    }
    
    static Class<?> loadAdapterClass(final String className, final byte[] classBytes) {
        final Class<?> domainClass = SecurityController.getStaticSecurityDomainClass();
        Object staticDomain;
        if (domainClass == CodeSource.class || domainClass == ProtectionDomain.class) {
            ProtectionDomain protectionDomain = SecurityUtilities.getScriptProtectionDomain();
            if (protectionDomain == null) {
                protectionDomain = JavaAdapter.class.getProtectionDomain();
            }
            if (domainClass == CodeSource.class) {
                staticDomain = ((protectionDomain == null) ? null : protectionDomain.getCodeSource());
            }
            else {
                staticDomain = protectionDomain;
            }
        }
        else {
            staticDomain = null;
        }
        final GeneratedClassLoader loader = SecurityController.createLoader(null, staticDomain);
        final Class<?> result = (Class<?>)loader.defineClass(className, classBytes);
        loader.linkClass((Class)result);
        return result;
    }
    
    public static Function getFunction(final Scriptable obj, final String functionName) {
        final Object x = ScriptableObject.getProperty(obj, functionName);
        if (x == Scriptable.NOT_FOUND) {
            return null;
        }
        if (!(x instanceof Function)) {
            throw ScriptRuntime.notFunctionError(x, functionName);
        }
        return (Function)x;
    }
    
    public static Object callMethod(ContextFactory factory, final Scriptable thisObj, final Function f, final Object[] args, final long argsToWrap) {
        if (f == null) {
            return null;
        }
        if (factory == null) {
            factory = ContextFactory.getGlobal();
        }
        final Scriptable scope = f.getParentScope();
        if (argsToWrap == 0L) {
            return Context.call(factory, (Callable)f, scope, thisObj, args);
        }
        final Context cx = Context.getCurrentContext();
        if (cx != null) {
            return doCall(cx, scope, thisObj, f, args, argsToWrap);
        }
        return factory.call(cx2 -> doCall(cx2, scope, thisObj, f, args, argsToWrap));
    }
    
    private static Object doCall(final Context cx, final Scriptable scope, final Scriptable thisObj, final Function f, final Object[] args, final long argsToWrap) {
        for (int i = 0; i != args.length; ++i) {
            if (0x0L != (argsToWrap & (long)(1 << i))) {
                final Object arg = args[i];
                if (!(arg instanceof Scriptable)) {
                    args[i] = cx.getWrapFactory().wrap(cx, scope, arg, null);
                }
            }
        }
        return f.call(cx, scope, thisObj, args);
    }
    
    public static Scriptable runScript(final Script script) {
        return (Scriptable)ContextFactory.getGlobal().call(cx -> {
            final ScriptableObject global = ScriptRuntime.getGlobal(cx);
            script.exec(cx, global);
            return global;
        });
    }
    
    private static void generateCtor(final ClassFileWriter cfw, final String adapterName, final String superName, final Constructor<?> superCtor) {
        short locals = 3;
        final Class<?>[] parameters = superCtor.getParameterTypes();
        if (parameters.length == 0) {
            cfw.startMethod("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short)1);
            cfw.add(42);
            cfw.addInvoke(183, superName, "<init>", "()V");
        }
        else {
            final StringBuilder sig = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            final int marker = sig.length();
            for (final Class<?> c : parameters) {
                appendTypeString(sig, c);
            }
            sig.append(")V");
            cfw.startMethod("<init>", sig.toString(), (short)1);
            cfw.add(42);
            short paramOffset = 3;
            for (final Class<?> parameter : parameters) {
                paramOffset += (short)generatePushParam(cfw, paramOffset, parameter);
            }
            locals = paramOffset;
            sig.delete(1, marker);
            cfw.addInvoke(183, superName, "<init>", sig.toString());
        }
        cfw.add(42);
        cfw.add(43);
        cfw.add(181, adapterName, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(42);
        cfw.add(44);
        cfw.add(181, adapterName, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cfw.add(42);
        cfw.add(43);
        cfw.add(42);
        cfw.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cfw.add(181, adapterName, "self", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(177);
        cfw.stopMethod(locals);
    }
    
    private static void generateSerialCtor(final ClassFileWriter cfw, final String adapterName, final String superName) {
        cfw.startMethod("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short)1);
        cfw.add(42);
        cfw.addInvoke(183, superName, "<init>", "()V");
        cfw.add(42);
        cfw.add(43);
        cfw.add(181, adapterName, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cfw.add(42);
        cfw.add(44);
        cfw.add(181, adapterName, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(42);
        cfw.add(45);
        cfw.add(181, adapterName, "self", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(177);
        cfw.stopMethod((short)4);
    }
    
    private static void generateEmptyCtor(final ClassFileWriter cfw, final String adapterName, final String superName, final String scriptClassName) {
        cfw.startMethod("<init>", "()V", (short)1);
        cfw.add(42);
        cfw.addInvoke(183, superName, "<init>", "()V");
        cfw.add(42);
        cfw.add(1);
        cfw.add(181, adapterName, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cfw.add(187, scriptClassName);
        cfw.add(89);
        cfw.addInvoke(183, scriptClassName, "<init>", "()V");
        cfw.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        cfw.add(76);
        cfw.add(42);
        cfw.add(43);
        cfw.add(181, adapterName, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(42);
        cfw.add(43);
        cfw.add(42);
        cfw.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cfw.add(181, adapterName, "self", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(177);
        cfw.stopMethod((short)2);
    }
    
    static void generatePushWrappedArgs(final ClassFileWriter cfw, final Class<?>[] argTypes, final int arrayLength) {
        cfw.addPush(arrayLength);
        cfw.add(189, "java/lang/Object");
        int paramOffset = 1;
        for (int i = 0; i != argTypes.length; ++i) {
            cfw.add(89);
            cfw.addPush(i);
            paramOffset += generateWrapArg(cfw, paramOffset, argTypes[i]);
            cfw.add(83);
        }
    }
    
    private static int generateWrapArg(final ClassFileWriter cfw, final int paramOffset, final Class<?> argType) {
        int size = 1;
        if (!argType.isPrimitive()) {
            cfw.add(25, paramOffset);
        }
        else if (argType == Boolean.TYPE) {
            cfw.add(187, "java/lang/Boolean");
            cfw.add(89);
            cfw.add(21, paramOffset);
            cfw.addInvoke(183, "java/lang/Boolean", "<init>", "(Z)V");
        }
        else if (argType == Character.TYPE) {
            cfw.add(21, paramOffset);
            cfw.addInvoke(184, "java/lang/String", "valueOf", "(C)Ljava/lang/String;");
        }
        else {
            cfw.add(187, "java/lang/Double");
            cfw.add(89);
            final String typeName = argType.getName();
            switch (typeName.charAt(0)) {
                case 'b':
                case 'i':
                case 's': {
                    cfw.add(21, paramOffset);
                    cfw.add(135);
                    break;
                }
                case 'l': {
                    cfw.add(22, paramOffset);
                    cfw.add(138);
                    size = 2;
                    break;
                }
                case 'f': {
                    cfw.add(23, paramOffset);
                    cfw.add(141);
                    break;
                }
                case 'd': {
                    cfw.add(24, paramOffset);
                    size = 2;
                    break;
                }
            }
            cfw.addInvoke(183, "java/lang/Double", "<init>", "(D)V");
        }
        return size;
    }
    
    static void generateReturnResult(final ClassFileWriter cfw, final Class<?> retType, final boolean callConvertResult) {
        if (retType == Void.TYPE) {
            cfw.add(87);
            cfw.add(177);
        }
        else if (retType == Boolean.TYPE) {
            cfw.addInvoke(184, "org/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            cfw.add(172);
        }
        else if (retType == Character.TYPE) {
            cfw.addInvoke(184, "org/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
            cfw.add(3);
            cfw.addInvoke(182, "java/lang/String", "charAt", "(I)C");
            cfw.add(172);
        }
        else if (retType.isPrimitive()) {
            cfw.addInvoke(184, "org/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
            final String typeName = retType.getName();
            switch (typeName.charAt(0)) {
                case 'b':
                case 'i':
                case 's': {
                    cfw.add(142);
                    cfw.add(172);
                    break;
                }
                case 'l': {
                    cfw.add(143);
                    cfw.add(173);
                    break;
                }
                case 'f': {
                    cfw.add(144);
                    cfw.add(174);
                    break;
                }
                case 'd': {
                    cfw.add(175);
                    break;
                }
                default: {
                    throw new RuntimeException("Unexpected return type " + retType.toString());
                }
            }
        }
        else {
            final String retTypeStr = retType.getName();
            if (callConvertResult) {
                cfw.addLoadConstant(retTypeStr);
                cfw.addInvoke(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                cfw.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
            }
            cfw.add(192, retTypeStr);
            cfw.add(176);
        }
    }
    
    private static void generateMethod(final ClassFileWriter cfw, final String genName, final String methodName, final Class<?>[] parms, final Class<?> returnType, final boolean convertResult) {
        final StringBuilder sb = new StringBuilder();
        final int paramsEnd = appendMethodSignature(parms, returnType, sb);
        final String methodSignature = sb.toString();
        cfw.startMethod(methodName, methodSignature, (short)1);
        cfw.add(42);
        cfw.add(180, genName, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        cfw.add(42);
        cfw.add(180, genName, "self", "Lorg/mozilla/javascript/Scriptable;");
        cfw.add(42);
        cfw.add(180, genName, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        cfw.addPush(methodName);
        cfw.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(cfw, parms, parms.length);
        if (parms.length > 64) {
            throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
        }
        long convertionMask = 0L;
        for (int i = 0; i != parms.length; ++i) {
            if (!parms[i].isPrimitive()) {
                convertionMask |= 1 << i;
            }
        }
        cfw.addPush(convertionMask);
        cfw.addInvoke(184, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(cfw, returnType, convertResult);
        cfw.stopMethod((short)paramsEnd);
    }
    
    private static int generatePushParam(final ClassFileWriter cfw, final int paramOffset, final Class<?> paramType) {
        if (!paramType.isPrimitive()) {
            cfw.addALoad(paramOffset);
            return 1;
        }
        final String typeName = paramType.getName();
        switch (typeName.charAt(0)) {
            case 'b':
            case 'c':
            case 'i':
            case 's':
            case 'z': {
                cfw.addILoad(paramOffset);
                return 1;
            }
            case 'l': {
                cfw.addLLoad(paramOffset);
                return 2;
            }
            case 'f': {
                cfw.addFLoad(paramOffset);
                return 1;
            }
            case 'd': {
                cfw.addDLoad(paramOffset);
                return 2;
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    private static void generatePopResult(final ClassFileWriter cfw, final Class<?> retType) {
        if (retType.isPrimitive()) {
            final String typeName = retType.getName();
            switch (typeName.charAt(0)) {
                case 'b':
                case 'c':
                case 'i':
                case 's':
                case 'z': {
                    cfw.add(172);
                    break;
                }
                case 'l': {
                    cfw.add(173);
                    break;
                }
                case 'f': {
                    cfw.add(174);
                    break;
                }
                case 'd': {
                    cfw.add(175);
                    break;
                }
            }
        }
        else {
            cfw.add(176);
        }
    }
    
    private static void generateSuper(final ClassFileWriter cfw, final String genName, final String superName, final String methodName, final String methodSignature, final Class<?>[] parms, final Class<?> returnType) {
        cfw.startMethod("super$" + methodName, methodSignature, (short)1);
        cfw.add(25, 0);
        int paramOffset = 1;
        for (final Class<?> parm : parms) {
            paramOffset += generatePushParam(cfw, paramOffset, parm);
        }
        cfw.addInvoke(183, superName, methodName, methodSignature);
        final Class<?> retType = returnType;
        if (!retType.equals(Void.TYPE)) {
            generatePopResult(cfw, retType);
        }
        else {
            cfw.add(177);
        }
        cfw.stopMethod((short)(paramOffset + 1));
    }
    
    private static String getMethodSignature(final Method method, final Class<?>[] argTypes) {
        final StringBuilder sb = new StringBuilder();
        appendMethodSignature(argTypes, method.getReturnType(), sb);
        return sb.toString();
    }
    
    static int appendMethodSignature(final Class<?>[] argTypes, final Class<?> returnType, final StringBuilder sb) {
        sb.append('(');
        int firstLocal = 1 + argTypes.length;
        for (final Class<?> type : argTypes) {
            appendTypeString(sb, type);
            if (type == Long.TYPE || type == Double.TYPE) {
                ++firstLocal;
            }
        }
        sb.append(')');
        appendTypeString(sb, returnType);
        return firstLocal;
    }
    
    private static StringBuilder appendTypeString(final StringBuilder sb, Class<?> type) {
        while (type.isArray()) {
            sb.append('[');
            type = type.getComponentType();
        }
        if (type.isPrimitive()) {
            char typeLetter;
            if (type == Boolean.TYPE) {
                typeLetter = 'Z';
            }
            else if (type == Long.TYPE) {
                typeLetter = 'J';
            }
            else {
                final String typeName = type.getName();
                typeLetter = Character.toUpperCase(typeName.charAt(0));
            }
            sb.append(typeLetter);
        }
        else {
            sb.append('L');
            sb.append(type.getName().replace('.', '/'));
            sb.append(';');
        }
        return sb;
    }
    
    static int[] getArgsToConvert(final Class<?>[] argTypes) {
        int count = 0;
        for (int i = 0; i != argTypes.length; ++i) {
            if (!argTypes[i].isPrimitive()) {
                ++count;
            }
        }
        if (count == 0) {
            return null;
        }
        final int[] array = new int[count];
        count = 0;
        for (int j = 0; j != argTypes.length; ++j) {
            if (!argTypes[j].isPrimitive()) {
                array[count++] = j;
            }
        }
        return array;
    }
    
    static {
        FTAG = "JavaAdapter";
    }
    
    static class JavaAdapterSignature
    {
        Class<?> superClass;
        Class<?>[] interfaces;
        ObjToIntMap names;
        
        JavaAdapterSignature(final Class<?> superClass, final Class<?>[] interfaces, final ObjToIntMap names) {
            this.superClass = superClass;
            this.interfaces = interfaces;
            this.names = names;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            final JavaAdapterSignature sig = (JavaAdapterSignature)obj;
            if (this.superClass != sig.superClass) {
                return false;
            }
            if (this.interfaces != sig.interfaces) {
                if (this.interfaces.length != sig.interfaces.length) {
                    return false;
                }
                for (int i = 0; i < this.interfaces.length; ++i) {
                    if (this.interfaces[i] != sig.interfaces[i]) {
                        return false;
                    }
                }
            }
            if (this.names.size() != sig.names.size()) {
                return false;
            }
            final ObjToIntMap.Iterator iter = new ObjToIntMap.Iterator(this.names);
            iter.start();
            while (!iter.done()) {
                final String name = (String)iter.getKey();
                final int arity = iter.getValue();
                if (arity != sig.names.get(name, arity + 1)) {
                    return false;
                }
                iter.next();
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            return this.superClass.hashCode() + Arrays.hashCode(this.interfaces) ^ this.names.size();
        }
    }
}
