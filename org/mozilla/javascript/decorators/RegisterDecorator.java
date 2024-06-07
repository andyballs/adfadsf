//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.decorators;

import org.mozilla.javascript.*;

public class RegisterDecorator extends Decorator
{
    public static void init(final Scriptable scope) {
        final RegisterDecorator register = new RegisterDecorator();
        ScriptableObject.defineProperty(scope, "@register", register, 2);
    }
    
    public Object consume(final Object target, final int descriptor, final DecoratorType decoratorType, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (decoratorType != DecoratorType.REGISTER) {
            return target;
        }
        Object realTarget = target;
        if ((descriptor & RegisterDecorator.STATIC) == 0x0 && (descriptor & RegisterDecorator.CLASS) == 0x0) {
            realTarget = ScriptableObject.getProperty(target, "prototype");
        }
        Object[] callArgs;
        if ((descriptor & RegisterDecorator.CLASS) != 0x0 || (descriptor & RegisterDecorator.PRIVATE) != 0x0) {
            callArgs = new Object[] { realTarget };
        }
        else {
            callArgs = new Object[] { realTarget, ((ScriptableObject)target).getAssociatedValue(RegisterDecorator.NAME_KEY) };
        }
        final Object result = ((Callable)args[0]).call(cx, scope, thisObj, callArgs);
        if (!Undefined.isUndefined(result)) {
            throw ScriptRuntime.typeError("The function provided to @register must return undefined");
        }
        return target;
    }
}
