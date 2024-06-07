//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public abstract class SecurityController
{
    private static SecurityController global;
    
    static SecurityController global() {
        return SecurityController.global;
    }
    
    public static boolean hasGlobal() {
        return SecurityController.global != null;
    }
    
    public static void initGlobal(final SecurityController controller) {
        if (controller == null) {
            throw new IllegalArgumentException();
        }
        if (SecurityController.global != null) {
            throw new SecurityException("Cannot overwrite already installed global SecurityController");
        }
        SecurityController.global = controller;
    }
    
    public abstract GeneratedClassLoader createClassLoader(final ClassLoader p0, final Object p1);
    
    public static GeneratedClassLoader createLoader(ClassLoader parent, final Object staticDomain) {
        final Context cx = Context.getContext();
        if (parent == null) {
            parent = cx.getApplicationClassLoader();
        }
        final SecurityController sc = cx.getSecurityController();
        GeneratedClassLoader loader;
        if (sc == null) {
            loader = cx.createClassLoader(parent);
        }
        else {
            final Object dynamicDomain = sc.getDynamicSecurityDomain(staticDomain);
            loader = sc.createClassLoader(parent, dynamicDomain);
        }
        return loader;
    }
    
    public static Class<?> getStaticSecurityDomainClass() {
        final SecurityController sc = Context.getContext().getSecurityController();
        return (sc == null) ? null : sc.getStaticSecurityDomainClassInternal();
    }
    
    public Class<?> getStaticSecurityDomainClassInternal() {
        return null;
    }
    
    public abstract Object getDynamicSecurityDomain(final Object p0);
    
    public Object callWithDomain(final Object securityDomain, final Context cx, final Callable callable, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return this.execWithDomain(cx, scope, (Script)new Script() {
            public Object exec(final Context cx, final Scriptable scope) {
                return callable.call(cx, scope, thisObj, args);
            }
        }, securityDomain);
    }
    
    @Deprecated
    public Object execWithDomain(final Context cx, final Scriptable scope, final Script script, final Object securityDomain) {
        throw new IllegalStateException("callWithDomain should be overridden");
    }
}
