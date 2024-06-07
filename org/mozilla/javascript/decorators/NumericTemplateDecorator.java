//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.decorators;

import org.mozilla.javascript.*;

public class NumericTemplateDecorator extends Decorator
{
    public static void init(final Scriptable scope) {
        final NumericTemplateDecorator numericTemplate = new NumericTemplateDecorator();
        ScriptableObject.defineProperty(scope, "@numericTemplate", numericTemplate, 2);
    }
    
    public Object consume(final Object target, final int descriptor, final DecoratorType decoratorType, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (decoratorType != DecoratorType.NUMERICTEMPLATE) {
            throw ScriptRuntime.typeError("@numericTemplate decorator expected numeric literal, got " + ScriptRuntime.toString(target));
        }
        if (args.length == 0 || !(args[0] instanceof Callable)) {
            return target;
        }
        final Scriptable obj = ScriptRuntime.newObjectLiteral(new Object[] { "number", "string" }, new Object[] { target, ScriptRuntime.toString(target) }, null, cx, scope);
        return ((Callable)args[0]).call(cx, scope, thisObj, new Object[] { obj });
    }
}
