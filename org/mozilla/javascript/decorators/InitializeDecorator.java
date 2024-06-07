//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.decorators;

import org.mozilla.javascript.*;

public class InitializeDecorator extends Decorator
{
    public static void init(final Scriptable scope) {
        final InitializeDecorator initialize = new InitializeDecorator();
        ScriptableObject.defineProperty(scope, "@initialize", initialize, 2);
    }
    
    public Object consume(final Object target, final int descriptor, final DecoratorType decoratorType, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (decoratorType != DecoratorType.INITIALIZE) {
            return target;
        }
        if ((descriptor & InitializeDecorator.STATIC) != 0x0) {
            throw ScriptRuntime.typeError("@initialize is not allowed on static class members");
        }
        if (args.length == 0 || !(args[0] instanceof Callable)) {
            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(args[0]));
        }
        final Callable cb = (Callable)args[0];
        final ScriptableObject sTarget = ScriptableObject.ensureScriptableObject(target);
        Object key = Undefined.instance;
        Object value = Undefined.instance;
        if ((descriptor & InitializeDecorator.PUBLIC) != 0x0 && (descriptor & InitializeDecorator.CLASS) == 0x0) {
            key = (sTarget.hasAssociatedValue(InitializeDecorator.NAME_KEY) ? sTarget.getAssociatedValue(InitializeDecorator.NAME_KEY) : Undefined.instance);
            if ((descriptor & InitializeDecorator.METHOD) == 0x0) {
                value = (sTarget.hasAssociatedValue(InitializeDecorator.VALUE_KEY) ? sTarget.getAssociatedValue(InitializeDecorator.VALUE_KEY) : Undefined.instance);
            }
        }
        final Object result = cb.call(cx, scope, thisObj, new Object[] { target, key, value });
        if (!Undefined.isUndefined(result)) {
            throw ScriptRuntime.typeError("The function provided to @initialize must return undefined");
        }
        return target;
    }
}
