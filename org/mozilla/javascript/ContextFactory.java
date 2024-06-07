//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.security.*;

public class ContextFactory
{
    private static volatile boolean hasCustomGlobal;
    private static ContextFactory global;
    private volatile boolean sealed;
    private final Object listenersLock;
    private volatile Object listeners;
    private boolean disabledListening;
    private ClassLoader applicationClassLoader;
    
    public ContextFactory() {
        this.listenersLock = new Object();
    }
    
    public static ContextFactory getGlobal() {
        return ContextFactory.global;
    }
    
    public static boolean hasExplicitGlobal() {
        return ContextFactory.hasCustomGlobal;
    }
    
    public static synchronized void initGlobal(final ContextFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException();
        }
        if (ContextFactory.hasCustomGlobal) {
            throw new IllegalStateException();
        }
        ContextFactory.hasCustomGlobal = true;
        ContextFactory.global = factory;
    }
    
    public static synchronized GlobalSetter getGlobalSetter() {
        if (ContextFactory.hasCustomGlobal) {
            throw new IllegalStateException();
        }
        ContextFactory.hasCustomGlobal = true;
        class 1GlobalSetterImpl implements GlobalSetter
        {
            @Override
            public void setContextFactoryGlobal(final ContextFactory factory) {
                ContextFactory.global = ((factory == null) ? new ContextFactory() : factory);
            }
            
            @Override
            public ContextFactory getContextFactoryGlobal() {
                return ContextFactory.global;
            }
        }
        return new 1GlobalSetterImpl();
    }
    
    protected Context makeContext() {
        return new Context(this);
    }
    
    protected boolean hasFeature(final Context cx, final int featureIndex) {
        switch (featureIndex) {
            case 1: {
                final int version = cx.getLanguageVersion();
                return version == 100 || version == 110 || version == 120;
            }
            case 2:
            case 4:
            case 13: {
                return true;
            }
            case 3: {
                final int version = cx.getLanguageVersion();
                return version == 120;
            }
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 16:
            case 17:
            case 18:
            case 19: {
                return false;
            }
            case 14: {
                return cx.getLanguageVersion() <= 170;
            }
            case 15: {
                return cx.getLanguageVersion() >= 200;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(featureIndex));
            }
        }
    }
    
    private boolean isDom3Present() {
        final Class<?> nodeClass = Kit.classOrNull("org.w3c.dom.Node");
        if (nodeClass == null) {
            return false;
        }
        try {
            nodeClass.getMethod("getUserData", String.class);
            return true;
        }
        catch (NoSuchMethodException e) {
            return false;
        }
    }
    
    protected GeneratedClassLoader createClassLoader(final ClassLoader parent) {
        return AccessController.doPrivileged((PrivilegedAction<GeneratedClassLoader>)new PrivilegedAction<DefiningClassLoader>() {
            @Override
            public DefiningClassLoader run() {
                return new DefiningClassLoader(parent);
            }
        });
    }
    
    public final ClassLoader getApplicationClassLoader() {
        return this.applicationClassLoader;
    }
    
    public final void initApplicationClassLoader(final ClassLoader loader) {
        if (loader == null) {
            throw new IllegalArgumentException("loader is null");
        }
        if (!Kit.testIfCanLoadRhinoClasses(loader)) {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        }
        if (this.applicationClassLoader != null) {
            throw new IllegalStateException("applicationClassLoader can only be set once");
        }
        this.checkNotSealed();
        this.applicationClassLoader = loader;
    }
    
    protected Object doTopCall(final Callable callable, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Object result = callable.call(cx, scope, thisObj, args);
        return (result instanceof ConsString) ? result.toString() : result;
    }
    
    protected void observeInstructionCount(final Context cx, final int instructionCount) {
    }
    
    protected void onContextCreated(final Context cx) {
        final Object listeners = this.listeners;
        int i = 0;
        while (true) {
            final Listener l = (Listener)Kit.getListener(listeners, i);
            if (l == null) {
                break;
            }
            l.contextCreated(cx);
            ++i;
        }
    }
    
    protected void onContextReleased(final Context cx) {
        final Object listeners = this.listeners;
        int i = 0;
        while (true) {
            final Listener l = (Listener)Kit.getListener(listeners, i);
            if (l == null) {
                break;
            }
            l.contextReleased(cx);
            ++i;
        }
    }
    
    public final void addListener(final Listener listener) {
        this.checkNotSealed();
        synchronized (this.listenersLock) {
            if (this.disabledListening) {
                throw new IllegalStateException();
            }
            this.listeners = Kit.addListener(this.listeners, listener);
        }
    }
    
    public final void removeListener(final Listener listener) {
        this.checkNotSealed();
        synchronized (this.listenersLock) {
            if (this.disabledListening) {
                throw new IllegalStateException();
            }
            this.listeners = Kit.removeListener(this.listeners, listener);
        }
    }
    
    final void disableContextListening() {
        this.checkNotSealed();
        synchronized (this.listenersLock) {
            this.disabledListening = true;
            this.listeners = null;
        }
    }
    
    public final boolean isSealed() {
        return this.sealed;
    }
    
    public final void seal() {
        this.checkNotSealed();
        this.sealed = true;
    }
    
    protected final void checkNotSealed() {
        if (this.sealed) {
            throw new IllegalStateException();
        }
    }
    
    public final <T> T call(final ContextAction<T> action) {
        return (T)Context.call(this, (ContextAction)action);
    }
    
    public Context enterContext() {
        return this.enterContext(null);
    }
    
    @Deprecated
    public final Context enter() {
        return this.enterContext(null);
    }
    
    @Deprecated
    public final void exit() {
        Context.exit();
    }
    
    public final Context enterContext(final Context cx) {
        return Context.enter(cx, this);
    }
    
    static {
        ContextFactory.global = new ContextFactory();
    }
    
    public interface GlobalSetter
    {
        void setContextFactoryGlobal(final ContextFactory p0);
        
        ContextFactory getContextFactoryGlobal();
    }
    
    public interface Listener
    {
        void contextCreated(final Context p0);
        
        void contextReleased(final Context p0);
    }
}
