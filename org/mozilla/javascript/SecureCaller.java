//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.ref.*;
import java.util.*;
import java.lang.reflect.*;
import java.net.*;
import java.io.*;
import java.security.*;

public abstract class SecureCaller
{
    private static final byte[] secureCallerImplBytecode;
    private static final Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> callers;
    
    public abstract Object call(final Callable p0, final Context p1, final Scriptable p2, final Scriptable p3, final Object[] p4);
    
    static Object callSecurely(final CodeSource codeSource, final Callable callable, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Thread thread = Thread.currentThread();
        final ClassLoader classLoader = AccessController.doPrivileged((PrivilegedAction<ClassLoader>)new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                return thread.getContextClassLoader();
            }
        });
        Map<ClassLoader, SoftReference<SecureCaller>> classLoaderMap;
        synchronized (SecureCaller.callers) {
            classLoaderMap = SecureCaller.callers.get(codeSource);
            if (classLoaderMap == null) {
                classLoaderMap = new WeakHashMap<ClassLoader, SoftReference<SecureCaller>>();
                SecureCaller.callers.put(codeSource, classLoaderMap);
            }
        }
        SecureCaller caller;
        synchronized (classLoaderMap) {
            final SoftReference<SecureCaller> ref = classLoaderMap.get(classLoader);
            if (ref != null) {
                caller = ref.get();
            }
            else {
                caller = null;
            }
            if (caller == null) {
                try {
                    caller = AccessController.doPrivileged((PrivilegedExceptionAction<SecureCaller>)new PrivilegedExceptionAction<Object>() {
                        @Override
                        public Object run() throws Exception {
                            final Class<?> thisClass = this.getClass();
                            ClassLoader effectiveClassLoader;
                            if (classLoader.loadClass(thisClass.getName()) != thisClass) {
                                effectiveClassLoader = thisClass.getClassLoader();
                            }
                            else {
                                effectiveClassLoader = classLoader;
                            }
                            final SecureClassLoaderImpl secCl = new SecureClassLoaderImpl(effectiveClassLoader);
                            final Class<?> c = secCl.defineAndLinkClass(SecureCaller.class.getName() + "Impl", SecureCaller.secureCallerImplBytecode, codeSource);
                            return c.newInstance();
                        }
                    });
                    classLoaderMap.put(classLoader, new SoftReference<SecureCaller>(caller));
                }
                catch (PrivilegedActionException ex) {
                    throw new UndeclaredThrowableException(ex.getCause());
                }
            }
        }
        return caller.call(callable, cx, scope, thisObj, args);
    }
    
    private static byte[] loadBytecode() {
        return AccessController.doPrivileged((PrivilegedAction<byte[]>)new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                return loadBytecodePrivileged();
            }
        });
    }
    
    private static byte[] loadBytecodePrivileged() {
        final URL url = SecureCaller.class.getResource("SecureCallerImpl.clazz");
        try {
            final InputStream in = url.openStream();
            try {
                final ByteArrayOutputStream bout = new ByteArrayOutputStream();
                while (true) {
                    final int r = in.read();
                    if (r == -1) {
                        break;
                    }
                    bout.write(r);
                }
                return bout.toByteArray();
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new UndeclaredThrowableException(e);
        }
    }
    
    static {
        secureCallerImplBytecode = loadBytecode();
        callers = new WeakHashMap<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>>();
    }
    
    private static class SecureClassLoaderImpl extends SecureClassLoader
    {
        SecureClassLoaderImpl(final ClassLoader parent) {
            super(parent);
        }
        
        Class<?> defineAndLinkClass(final String name, final byte[] bytes, final CodeSource cs) {
            final Class<?> cl = this.defineClass(name, bytes, 0, bytes.length, cs);
            this.resolveClass(cl);
            return cl;
        }
    }
}
