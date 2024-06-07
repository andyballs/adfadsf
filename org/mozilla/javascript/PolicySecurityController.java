//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.ref.*;
import java.util.*;
import java.lang.reflect.*;
import org.mozilla.classfile.*;
import java.security.*;

public class PolicySecurityController extends SecurityController
{
    private static final byte[] secureCallerImplBytecode;
    private static final Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> callers;
    
    @Override
    public Class<?> getStaticSecurityDomainClassInternal() {
        return CodeSource.class;
    }
    
    @Override
    public GeneratedClassLoader createClassLoader(final ClassLoader parent, final Object securityDomain) {
        return (GeneratedClassLoader)AccessController.doPrivileged((PrivilegedAction<Loader>)new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                return new Loader(parent, (CodeSource)securityDomain);
            }
        });
    }
    
    @Override
    public Object getDynamicSecurityDomain(final Object securityDomain) {
        return securityDomain;
    }
    
    @Override
    public Object callWithDomain(final Object securityDomain, final Context cx, final Callable callable, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final ClassLoader classLoader = AccessController.doPrivileged((PrivilegedAction<ClassLoader>)new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                return cx.getApplicationClassLoader();
            }
        });
        final CodeSource codeSource = (CodeSource)securityDomain;
        Map<ClassLoader, SoftReference<SecureCaller>> classLoaderMap;
        synchronized (PolicySecurityController.callers) {
            classLoaderMap = PolicySecurityController.callers.get(codeSource);
            if (classLoaderMap == null) {
                classLoaderMap = new WeakHashMap<ClassLoader, SoftReference<SecureCaller>>();
                PolicySecurityController.callers.put(codeSource, classLoaderMap);
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
                            final Loader loader = new Loader(classLoader, codeSource);
                            final Class<?> c = loader.defineClass(SecureCaller.class.getName() + "Impl", PolicySecurityController.secureCallerImplBytecode);
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
        final String secureCallerClassName = SecureCaller.class.getName();
        final ClassFileWriter cfw = new ClassFileWriter(secureCallerClassName + "Impl", secureCallerClassName, "<generated>");
        cfw.startMethod("<init>", "()V", (short)1);
        cfw.addALoad(0);
        cfw.addInvoke(183, secureCallerClassName, "<init>", "()V");
        cfw.add(177);
        cfw.stopMethod((short)1);
        final String callableCallSig = "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;";
        cfw.startMethod("call", "(Lorg/mozilla/javascript/Callable;" + callableCallSig, (short)17);
        for (int i = 1; i < 6; ++i) {
            cfw.addALoad(i);
        }
        cfw.addInvoke(185, "org/mozilla/javascript/Callable", "call", "(" + callableCallSig);
        cfw.add(176);
        cfw.stopMethod((short)6);
        return cfw.toByteArray();
    }
    
    static {
        secureCallerImplBytecode = loadBytecode();
        callers = new WeakHashMap<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>>();
    }
    
    private static class Loader extends SecureClassLoader implements GeneratedClassLoader
    {
        private final CodeSource codeSource;
        
        Loader(final ClassLoader parent, final CodeSource codeSource) {
            super(parent);
            this.codeSource = codeSource;
        }
        
        public Class<?> defineClass(final String name, final byte[] data) {
            return this.defineClass(name, data, 0, data.length, this.codeSource);
        }
        
        public void linkClass(final Class<?> cl) {
            this.resolveClass(cl);
        }
    }
    
    public abstract static class SecureCaller
    {
        public abstract Object call(final Callable p0, final Context p1, final Scriptable p2, final Scriptable p3, final Object[] p4);
    }
}
