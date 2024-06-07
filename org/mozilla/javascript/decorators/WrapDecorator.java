//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.decorators;

import org.mozilla.javascript.*;

public class WrapDecorator extends Decorator
{
    public static void init(final Scriptable scope) {
        final WrapDecorator wrap = new WrapDecorator();
        ScriptableObject.defineProperty(scope, "@wrap", wrap, 2);
    }
    
    public Object consume(final Object target, final int descriptor, final DecoratorType decoratorType, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (decoratorType != DecoratorType.WRAP) {
            return target;
        }
        if ((descriptor & WrapDecorator.FIELD) != 0x0) {
            throw ScriptRuntime.typeError("@wrap cannot be applied to class fields");
        }
        if (args.length == 0 || !(args[0] instanceof Callable)) {
            return target;
        }
        return ((Callable)args[0]).call(cx, scope, thisObj, new Object[] { target });
    }
}
