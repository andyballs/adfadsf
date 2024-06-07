//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;

public class InterfaceAdapter
{
    private final Object proxyHelper;
    
    static Object create(final Context cx, final Class<?> cl, final ScriptableObject object) {
        if (!cl.isInterface()) {
            throw new IllegalArgumentException();
        }
        final Scriptable topScope = ScriptRuntime.getTopCallScope(cx);
        final ClassCache cache = ClassCache.get(topScope);
        InterfaceAdapter adapter = (InterfaceAdapter)cache.getInterfaceAdapter((Class)cl);
        final ContextFactory cf = cx.getFactory();
        if (adapter == null) {
            final Method[] methods = cl.getMethods();
            if (object instanceof Callable) {
                final int length = methods.length;
                if (length == 0) {
                    throw Context.reportRuntimeError1("msg.no.empty.interface.conversion", (Object)cl.getName());
                }
                if (length > 1) {
                    String methodName = null;
                    for (final Method method : methods) {
                        if (isFunctionalMethodCandidate(method)) {
                            if (methodName == null) {
                                methodName = method.getName();
                            }
                            else if (!methodName.equals(method.getName())) {
                                throw Context.reportRuntimeError1("msg.no.function.interface.conversion", (Object)cl.getName());
                            }
                        }
                    }
                }
            }
            adapter = new InterfaceAdapter(cf, cl);
            cache.cacheInterfaceAdapter((Class)cl, (Object)adapter);
        }
        return VMBridge.instance.newInterfaceProxy(adapter.proxyHelper, cf, adapter, object, topScope);
    }
    
    private static boolean isFunctionalMethodCandidate(final Method method) {
        return !method.getName().equals("equals") && !method.getName().equals("hashCode") && !method.getName().equals("toString") && Modifier.isAbstract(method.getModifiers());
    }
    
    private InterfaceAdapter(final ContextFactory cf, final Class<?> cl) {
        this.proxyHelper = VMBridge.instance.getInterfaceProxyHelper(cf, new Class[] { cl });
    }
    
    public Object invoke(final ContextFactory cf, final Object target, final Scriptable topScope, final Object thisObject, final Method method, final Object[] args) {
        return cf.call(cx -> this.invokeImpl(cx, target, topScope, thisObject, method, args));
    }
    
    Object invokeImpl(final Context cx, final Object target, final Scriptable topScope, final Object thisObject, final Method method, Object[] args) {
        Callable function;
        if (target instanceof Callable) {
            function = (Callable)target;
        }
        else {
            final Scriptable s = (Scriptable)target;
            final String methodName = method.getName();
            final Object value = ScriptableObject.getProperty(s, methodName);
            if (value == ScriptableObject.NOT_FOUND) {
                Context.reportWarning(ScriptRuntime.getMessage1("msg.undefined.function.interface", methodName));
                final Class<?> resultType = method.getReturnType();
                if (resultType == Void.TYPE) {
                    return null;
                }
                return Context.jsToJava((Object)null, (Class)resultType);
            }
            else {
                if (!(value instanceof Callable)) {
                    throw Context.reportRuntimeError1("msg.not.function.interface", (Object)methodName);
                }
                function = (Callable)value;
            }
        }
        final WrapFactory wf = cx.getWrapFactory();
        if (args == null) {
            args = ScriptRuntime.emptyArgs;
        }
        else {
            for (int i = 0, N = args.length; i != N; ++i) {
                final Object arg = args[i];
                if (!(arg instanceof String) && !(arg instanceof Number) && !(arg instanceof Boolean)) {
                    args[i] = wf.wrap(cx, topScope, arg, null);
                }
            }
        }
        final Scriptable thisObj = wf.wrapAsJavaObject(cx, topScope, thisObject, null);
        Object result = function.call(cx, topScope, thisObj, args);
        final Class<?> javaResultType = method.getReturnType();
        if (javaResultType == Void.TYPE) {
            result = null;
        }
        else {
            result = Context.jsToJava(result, (Class)javaResultType);
        }
        return result;
    }
}
