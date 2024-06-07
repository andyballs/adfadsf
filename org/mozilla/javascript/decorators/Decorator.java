//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.decorators;

import org.mozilla.javascript.*;

public abstract class Decorator extends BaseFunction
{
    public static int CLASS;
    public static int METHOD;
    public static int FIELD;
    public static int PUBLIC;
    public static int PRIVATE;
    public static int STATIC;
    public static final Object NAME_KEY;
    public static final Object VALUE_KEY;
    public static final Object HAS_INITIALIZE;
    
    public static void init(final Scriptable scope) {
        WrapDecorator.init(scope);
        RegisterDecorator.init(scope);
        NumericTemplateDecorator.init(scope);
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final DecoratorType type = (DecoratorType)args[2];
        if (args[0] instanceof Number && type == DecoratorType.NUMERICTEMPLATE) {
            throw ScriptRuntime.typeError("Numeric literal decorator can only have @numericTemplate decorators");
        }
        return this.consume(args[0], (int)args[1], type, cx, scope, thisObj, (Object[])args[3]);
    }
    
    public abstract Object consume(final Object p0, final int p1, final DecoratorType p2, final Context p3, final Scriptable p4, final Scriptable p5, final Object[] p6);
    
    static {
        Decorator.CLASS = 1;
        Decorator.METHOD = 2;
        Decorator.FIELD = 4;
        Decorator.PUBLIC = 8;
        Decorator.PRIVATE = 16;
        Decorator.STATIC = 32;
        NAME_KEY = new Object();
        VALUE_KEY = new Object();
        HAS_INITIALIZE = new Object();
    }
}
