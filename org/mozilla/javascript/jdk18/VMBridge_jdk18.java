//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.jdk18;

import org.mozilla.javascript.*;
import java.lang.reflect.*;

public class VMBridge_jdk18 extends VMBridge
{
    private ThreadLocal<Object[]> contextLocal;
    
    public VMBridge_jdk18() {
        this.contextLocal = new ThreadLocal<Object[]>();
    }
    
    @Override
    protected Object getThreadContextHelper() {
        Object[] storage = this.contextLocal.get();
        if (storage == null) {
            storage = new Object[] { null };
            this.contextLocal.set(storage);
        }
        return storage;
    }
    
    @Override
    protected Context getContext(final Object contextHelper) {
        final Object[] storage = (Object[])contextHelper;
        return (Context)storage[0];
    }
    
    @Override
    protected void setContext(final Object contextHelper, final Context cx) {
        final Object[] storage = (Object[])contextHelper;
        storage[0] = cx;
    }
    
    @Override
    protected boolean tryToMakeAccessible(final AccessibleObject accessible) {
        if (accessible.isAccessible()) {
            return true;
        }
        try {
            accessible.setAccessible(true);
        }
        catch (Exception ex) {}
        return accessible.isAccessible();
    }
    
    @Override
    protected Object getInterfaceProxyHelper(final ContextFactory cf, final Class<?>[] interfaces) {
        final ClassLoader loader = interfaces[0].getClassLoader();
        final Class<?> cl = Proxy.getProxyClass(loader, interfaces);
        Constructor<?> c;
        try {
            c = cl.getConstructor(InvocationHandler.class);
        }
        catch (NoSuchMethodException ex) {
            throw new IllegalStateException(ex);
        }
        return c;
    }
    
    @Override
    protected Object newInterfaceProxy(final Object proxyHelper, final ContextFactory cf, final InterfaceAdapter adapter, final Object target, final Scriptable topScope) {
        final Constructor<?> c = (Constructor<?>)proxyHelper;
        final InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) {
                if (method.getDeclaringClass() == Object.class) {
                    final String methodName = method.getName();
                    if (methodName.equals("equals")) {
                        final Object other = args[0];
                        return proxy == other;
                    }
                    if (methodName.equals("hashCode")) {
                        return target.hashCode();
                    }
                    if (methodName.equals("toString")) {
                        return "Proxy[" + target.toString() + "]";
                    }
                }
                return adapter.invoke(cf, target, topScope, proxy, method, args);
            }
        };
        Object proxy;
        try {
            proxy = c.newInstance(handler);
        }
        catch (InvocationTargetException ex) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex);
        }
        catch (IllegalAccessException ex2) {
            throw new IllegalStateException(ex2);
        }
        catch (InstantiationException ex3) {
            throw new IllegalStateException(ex3);
        }
        return proxy;
    }
}
