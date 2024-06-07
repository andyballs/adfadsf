//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;

class FieldAndMethods extends NativeJavaMethod
{
    private static final long serialVersionUID = -9222428244284796755L;
    Field field;
    Object javaObject;
    
    FieldAndMethods(final Scriptable scope, final MemberBox[] methods, final Field field) {
        super(methods);
        this.field = field;
        this.setParentScope(scope);
        this.setPrototype(ScriptableObject.getFunctionPrototype(scope));
    }
    
    public Object getDefaultValue(final Class<?> hint) {
        if (hint == ScriptRuntime.FunctionClass) {
            return this;
        }
        Object rval;
        Class<?> type;
        try {
            rval = this.field.get(this.javaObject);
            type = this.field.getType();
        }
        catch (IllegalAccessException accEx) {
            throw Context.reportRuntimeError1("msg.java.internal.private", (Object)this.field.getName());
        }
        final Context cx = Context.getContext();
        rval = cx.getWrapFactory().wrap(cx, (Scriptable)this, rval, type);
        if (rval instanceof Scriptable) {
            rval = ((Scriptable)rval).getDefaultValue(hint);
        }
        return rval;
    }
}
