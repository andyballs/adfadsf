//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.io.*;

public class NativeJavaPackage extends ScriptableObject
{
    private static final long serialVersionUID = 7445054382212031523L;
    private String packageName;
    private transient ClassLoader classLoader;
    private Set<String> negativeCache;
    
    NativeJavaPackage(final boolean internalUsage, final String packageName, final ClassLoader classLoader) {
        this.negativeCache = null;
        this.packageName = packageName;
        this.classLoader = classLoader;
    }
    
    @Deprecated
    public NativeJavaPackage(final String packageName, final ClassLoader classLoader) {
        this(false, packageName, classLoader);
    }
    
    @Deprecated
    public NativeJavaPackage(final String packageName) {
        this(false, packageName, Context.getCurrentContext().getApplicationClassLoader());
    }
    
    @Override
    public String getClassName() {
        return "JavaPackage";
    }
    
    @Override
    public boolean has(final String id, final Scriptable start) {
        return true;
    }
    
    @Override
    public boolean has(final int index, final Scriptable start) {
        return false;
    }
    
    @Override
    public void put(final String id, final Scriptable start, final Object value) {
    }
    
    @Override
    public void put(final int index, final Scriptable start, final Object value) {
        throw Context.reportRuntimeError0("msg.pkg.int");
    }
    
    @Override
    public Object get(final String id, final Scriptable start) {
        return this.getPkgProperty(id, start, true);
    }
    
    @Override
    public Object get(final int index, final Scriptable start) {
        return NativeJavaPackage.NOT_FOUND;
    }
    
    NativeJavaPackage forcePackage(final String name, final Scriptable scope) {
        final Object cached = super.get(name, this);
        if (cached != null && cached instanceof NativeJavaPackage) {
            return (NativeJavaPackage)cached;
        }
        final String newPackage = (this.packageName.length() == 0) ? name : (this.packageName + "." + name);
        final NativeJavaPackage pkg = new NativeJavaPackage(true, newPackage, this.classLoader);
        ScriptRuntime.setObjectProtoAndParent(pkg, scope);
        super.put(name, this, pkg);
        return pkg;
    }
    
    synchronized Object getPkgProperty(final String name, final Scriptable start, final boolean createPkg) {
        final Object cached = super.get(name, start);
        if (cached != NativeJavaPackage.NOT_FOUND) {
            return cached;
        }
        if (this.negativeCache != null && this.negativeCache.contains(name)) {
            return null;
        }
        final String className = (this.packageName.length() == 0) ? name : (this.packageName + '.' + name);
        final Context cx = Context.getContext();
        final ClassShutter shutter = cx.getClassShutter();
        Scriptable newValue = null;
        if (shutter == null || shutter.visibleToScripts(className)) {
            Class<?> cl = null;
            if (this.classLoader != null) {
                cl = (Class<?>)Kit.classOrNull(this.classLoader, className);
            }
            else {
                cl = (Class<?>)Kit.classOrNull(className);
            }
            if (cl != null) {
                final WrapFactory wrapFactory = cx.getWrapFactory();
                newValue = wrapFactory.wrapJavaClass(cx, ScriptableObject.getTopLevelScope(this), cl);
                newValue.setPrototype(this.getPrototype());
            }
        }
        if (newValue == null) {
            if (createPkg) {
                final NativeJavaPackage pkg = new NativeJavaPackage(true, className, this.classLoader);
                ScriptRuntime.setObjectProtoAndParent(pkg, this.getParentScope());
                newValue = pkg;
            }
            else {
                if (this.negativeCache == null) {
                    this.negativeCache = new HashSet<String>();
                }
                this.negativeCache.add(name);
            }
        }
        if (newValue != null) {
            super.put(name, start, newValue);
        }
        return newValue;
    }
    
    @Override
    public Object getDefaultValue(final Class<?> ignored) {
        return this.toString();
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.classLoader = Context.getCurrentContext().getApplicationClassLoader();
    }
    
    @Override
    public String toString() {
        return "[JavaPackage " + this.packageName + "]";
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof NativeJavaPackage) {
            final NativeJavaPackage njp = (NativeJavaPackage)obj;
            return this.packageName.equals(njp.packageName) && this.classLoader == njp.classLoader;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.packageName.hashCode() ^ ((this.classLoader == null) ? 0 : this.classLoader.hashCode());
    }
}
