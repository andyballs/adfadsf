//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import java.security.*;
import java.lang.reflect.*;

public final class LazilyLoadedCtor implements Serializable
{
    private static final long serialVersionUID = 1L;
    private static final int STATE_BEFORE_INIT = 0;
    private static final int STATE_INITIALIZING = 1;
    private static final int STATE_WITH_VALUE = 2;
    private final ScriptableObject scope;
    private final String propertyName;
    private final String className;
    private final boolean sealed;
    private final boolean privileged;
    private Object initializedValue;
    private int state;
    
    public LazilyLoadedCtor(final ScriptableObject scope, final String propertyName, final String className, final boolean sealed) {
        this(scope, propertyName, className, sealed, false);
    }
    
    LazilyLoadedCtor(final ScriptableObject scope, final String propertyName, final String className, final boolean sealed, final boolean privileged) {
        this.scope = scope;
        this.propertyName = propertyName;
        this.className = className;
        this.sealed = sealed;
        this.privileged = privileged;
        scope.addLazilyInitializedValue(propertyName, this.state = 0, this, 2);
    }
    
    void init() {
        synchronized (this) {
            if (this.state == 1) {
                throw new IllegalStateException("Recursive initialization for " + this.propertyName);
            }
            if (this.state == 0) {
                this.state = 1;
                Object value = Scriptable.NOT_FOUND;
                try {
                    value = this.buildValue();
                }
                finally {
                    this.initializedValue = value;
                    this.state = 2;
                }
            }
        }
    }
    
    Object getValue() {
        if (this.state != 2) {
            throw new IllegalStateException(this.propertyName);
        }
        return this.initializedValue;
    }
    
    private Object buildValue() {
        if (this.privileged) {
            return AccessController.doPrivileged((PrivilegedAction<Object>)new PrivilegedAction<Object>() {
                @Override
                public Object run() {
                    return LazilyLoadedCtor.this.buildValue0();
                }
            });
        }
        return this.buildValue0();
    }
    
    private Object buildValue0() {
        final Class<? extends Scriptable> cl = this.cast(Kit.classOrNull(this.className));
        if (cl != null) {
            try {
                Object value = ScriptableObject.buildClassCtor(this.scope, cl, this.sealed, false);
                if (value != null) {
                    return value;
                }
                value = this.scope.get(this.propertyName, this.scope);
                if (value != Scriptable.NOT_FOUND) {
                    return value;
                }
            }
            catch (InvocationTargetException ex) {
                final Throwable target = ex.getTargetException();
                if (target instanceof RuntimeException) {
                    throw (RuntimeException)target;
                }
            }
            catch (RhinoException ex2) {}
            catch (InstantiationException ex3) {}
            catch (IllegalAccessException ex4) {}
            catch (SecurityException ex5) {}
        }
        return Scriptable.NOT_FOUND;
    }
    
    private Class<? extends Scriptable> cast(final Class<?> cl) {
        return (Class<? extends Scriptable>)cl;
    }
}
