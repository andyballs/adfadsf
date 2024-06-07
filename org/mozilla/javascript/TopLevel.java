//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class TopLevel extends IdScriptableObject
{
    private static final long serialVersionUID = -4648046356662472260L;
    private EnumMap<Builtins, BaseFunction> ctors;
    private EnumMap<NativeErrors, BaseFunction> errors;
    
    public String getClassName() {
        return "global";
    }
    
    public void cacheBuiltins() {
        this.ctors = new EnumMap<Builtins, BaseFunction>(Builtins.class);
        for (final Builtins builtin : Builtins.values()) {
            final Object value = ScriptableObject.getProperty((Scriptable)this, builtin.name());
            if (value instanceof BaseFunction) {
                this.ctors.put(builtin, (BaseFunction)value);
            }
        }
        this.errors = new EnumMap<NativeErrors, BaseFunction>(NativeErrors.class);
        for (final NativeErrors error : NativeErrors.values()) {
            final Object value = ScriptableObject.getProperty((Scriptable)this, error.name());
            if (value instanceof BaseFunction) {
                this.errors.put(error, (BaseFunction)value);
            }
        }
    }
    
    public static Function getBuiltinCtor(final Context cx, final Scriptable scope, final Builtins type) {
        assert scope.getParentScope() == null;
        if (scope instanceof TopLevel) {
            final Function result = (Function)((TopLevel)scope).getBuiltinCtor(type);
            if (result != null) {
                return result;
            }
        }
        return ScriptRuntime.getExistingCtor(cx, scope, type.name());
    }
    
    static Function getNativeErrorCtor(final Context cx, final Scriptable scope, final NativeErrors type) {
        assert scope.getParentScope() == null;
        if (scope instanceof TopLevel) {
            final Function result = (Function)((TopLevel)scope).getNativeErrorCtor(type);
            if (result != null) {
                return result;
            }
        }
        return ScriptRuntime.getExistingCtor(cx, scope, type.name());
    }
    
    public static Scriptable getBuiltinPrototype(final Scriptable scope, final Builtins type) {
        assert scope.getParentScope() == null;
        if (scope instanceof TopLevel) {
            final Scriptable result = ((TopLevel)scope).getBuiltinPrototype(type);
            if (result != null) {
                return result;
            }
        }
        return ScriptableObject.getClassPrototype(scope, type.name());
    }
    
    public BaseFunction getBuiltinCtor(final Builtins type) {
        return (this.ctors != null) ? this.ctors.get(type) : null;
    }
    
    BaseFunction getNativeErrorCtor(final NativeErrors type) {
        return (this.errors != null) ? this.errors.get(type) : null;
    }
    
    public Scriptable getBuiltinPrototype(final Builtins type) {
        final BaseFunction func = this.getBuiltinCtor(type);
        final Object proto = (func != null) ? func.getPrototypeProperty() : null;
        return (proto instanceof Scriptable) ? ((Scriptable)proto) : null;
    }
    
    public enum Builtins
    {
        Object, 
        Array, 
        Function, 
        String, 
        Number, 
        Boolean, 
        RegExp, 
        Error, 
        Symbol;
    }
    
    enum NativeErrors
    {
        Error, 
        EvalError, 
        RangeError, 
        ReferenceError, 
        SyntaxError, 
        TypeError, 
        URIError, 
        InternalError, 
        JavaException;
    }
}
