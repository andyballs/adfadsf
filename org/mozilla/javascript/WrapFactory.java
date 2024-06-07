//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class WrapFactory
{
    private boolean javaPrimitiveWrap;
    
    public WrapFactory() {
        this.javaPrimitiveWrap = true;
    }
    
    public Object wrap(final Context cx, final Scriptable scope, final Object obj, final Class<?> staticType) {
        if (obj == null || obj == Undefined.instance || obj instanceof Scriptable) {
            return obj;
        }
        if (staticType != null && staticType.isPrimitive()) {
            if (staticType == Void.TYPE) {
                return Undefined.instance;
            }
            if (staticType == Character.TYPE) {
                return obj;
            }
            return obj;
        }
        else {
            if (!this.isJavaPrimitiveWrap()) {
                if (obj instanceof String || obj instanceof Boolean || obj instanceof Integer || obj instanceof Short || obj instanceof Long || obj instanceof Float || obj instanceof Double) {
                    return obj;
                }
                if (obj instanceof Character) {
                    return String.valueOf((char)obj);
                }
            }
            final Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                return NativeJavaArray.wrap(scope, obj);
            }
            return this.wrapAsJavaObject(cx, scope, obj, staticType);
        }
    }
    
    public Scriptable wrapNewObject(final Context cx, final Scriptable scope, final Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable)obj;
        }
        final Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            return (Scriptable)NativeJavaArray.wrap(scope, obj);
        }
        return this.wrapAsJavaObject(cx, scope, obj, null);
    }
    
    public Scriptable wrapAsJavaObject(final Context cx, final Scriptable scope, final Object javaObject, final Class<?> staticType) {
        return (Scriptable)new NativeJavaObject(scope, javaObject, (Class)staticType);
    }
    
    public Scriptable wrapJavaClass(final Context cx, final Scriptable scope, final Class<?> javaClass) {
        return (Scriptable)new NativeJavaClass(scope, (Class)javaClass);
    }
    
    public final boolean isJavaPrimitiveWrap() {
        return this.javaPrimitiveWrap;
    }
    
    public final void setJavaPrimitiveWrap(final boolean value) {
        final Context cx = Context.getCurrentContext();
        if (cx != null && cx.isSealed()) {
            Context.onSealedMutation();
        }
        this.javaPrimitiveWrap = value;
    }
}
