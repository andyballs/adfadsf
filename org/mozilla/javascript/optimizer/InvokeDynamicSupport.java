//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import java.lang.invoke.*;
import org.mozilla.javascript.*;
import java.util.*;

public class InvokeDynamicSupport
{
    private static final MethodHandle INIT_GET_OBJ_PROP;
    private static final MethodHandle REAL_GET_OBJ_PROP;
    private static final MethodHandle INIT_CALL_WITH_TEMPLATE;
    private static final MethodHandle REAL_CALL_WITH_TEMPLATE;
    private static final MethodHandle ARRAY_EQUALS;
    
    public static CallSite bootstrapGetObjectProp(final MethodHandles.Lookup lookup, final String name, final MethodType type) {
        final MutableCallSite callSite = new MutableCallSite(type);
        final MethodHandle check = InvokeDynamicSupport.INIT_GET_OBJ_PROP.bindTo(callSite);
        callSite.setTarget(check.asType(type));
        return callSite;
    }
    
    public static Object getObjectProp(final MutableCallSite callSite, final Object value, final String property, final Context cx, final Scriptable scope) throws Throwable {
        callSite.setTarget(InvokeDynamicSupport.REAL_GET_OBJ_PROP);
        return InvokeDynamicSupport.REAL_GET_OBJ_PROP.invoke(value, property, cx, scope);
    }
    
    public static CallSite bootstrapCallWithTemplateLiteral(final MethodHandles.Lookup lookup, final String name, final MethodType type) {
        final MutableCallSite callSite = new MutableCallSite(type);
        final MethodHandle check = InvokeDynamicSupport.INIT_CALL_WITH_TEMPLATE.bindTo(callSite);
        callSite.setTarget(check.asType(type));
        return callSite;
    }
    
    public static Object callWithTemplateLiteral(final MutableCallSite callSite, final Object[] args, final int boundary, final Object[] rawStrings, final Object target, final Context cx, final Scriptable scope, final Scriptable thisObj) {
        final Object value = ScriptRuntime.callWithTemplateLiteral(args, boundary, rawStrings, target, cx, scope, thisObj);
        MethodHandle constant = MethodHandles.constant(Object.class, value);
        constant = MethodHandles.dropArguments(constant, 0, Object[].class, Integer.TYPE, Object[].class, Object.class, Context.class, Scriptable.class, Scriptable.class);
        final MethodHandle guarded = MethodHandles.guardWithTest(MethodHandles.insertArguments(InvokeDynamicSupport.ARRAY_EQUALS, 0, args), constant, InvokeDynamicSupport.INIT_CALL_WITH_TEMPLATE.bindTo(callSite));
        callSite.setTarget(guarded);
        return value;
    }
    
    static {
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            REAL_GET_OBJ_PROP = lookup.findStatic(ScriptRuntime.class, "getObjectProp", MethodType.methodType(Object.class, Object.class, String.class, Context.class, Scriptable.class));
            INIT_GET_OBJ_PROP = lookup.findStatic(InvokeDynamicSupport.class, "getObjectProp", MethodType.methodType(Object.class, MutableCallSite.class, Object.class, String.class, Context.class, Scriptable.class));
            REAL_CALL_WITH_TEMPLATE = lookup.findStatic(ScriptRuntime.class, "callWithTemplateLiteral", MethodType.methodType(Object.class, Object[].class, Integer.TYPE, Object[].class, Object.class, Context.class, Scriptable.class, Scriptable.class));
            INIT_CALL_WITH_TEMPLATE = lookup.findStatic(InvokeDynamicSupport.class, "callWithTemplateLiteral", MethodType.methodType(Object.class, MutableCallSite.class, Object[].class, Integer.TYPE, Object[].class, Object.class, Context.class, Scriptable.class, Scriptable.class));
            ARRAY_EQUALS = lookup.findStatic(Arrays.class, "equals", MethodType.methodType(Boolean.TYPE, Object[].class, Object[].class));
        }
        catch (NoSuchMethodException | IllegalAccessException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException e = ex;
            throw new RuntimeException(e);
        }
    }
}
