//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.generator;

import org.mozilla.javascript.*;

public final class NativeGenerator extends IdScriptableObject
{
    private static final long serialVersionUID = 1645892441041347273L;
    private static final Object GENERATOR_TAG;
    public static final int GENERATOR_SEND = 0;
    public static final int GENERATOR_THROW = 1;
    public static final int GENERATOR_CLOSE = 2;
    private static final int Id_next = 1;
    private static final int Id_return = 2;
    private static final int Id_throw = 3;
    private static final int Id___iterator__ = 4;
    private static final int SymbolId_iterator = 5;
    private static final int MAX_PROTOTYPE_ID = 5;
    private NativeFunction function;
    private Object savedState;
    private String lineSource;
    private int lineNumber;
    private boolean firstTime;
    private boolean locked;
    
    public static NativeGenerator init(final ScriptableObject scope, final boolean sealed) {
        final NativeGenerator prototype = new NativeGenerator();
        if (scope != null) {
            prototype.setParentScope(scope);
            prototype.setPrototype(ScriptableObject.getObjectPrototype(scope));
        }
        prototype.activatePrototypeMap(5);
        if (sealed) {
            prototype.sealObject();
        }
        if (scope != null) {
            scope.associateValue(NativeGenerator.GENERATOR_TAG, prototype);
        }
        return prototype;
    }
    
    private NativeGenerator() {
        this.firstTime = true;
    }
    
    public NativeGenerator(final Scriptable scope, final NativeFunction function, final Object savedState) {
        this.firstTime = true;
        this.function = function;
        this.savedState = savedState;
        final Scriptable top = ScriptableObject.getTopLevelScope(scope);
        this.setParentScope(top);
        final NativeGenerator prototype = (NativeGenerator)ScriptableObject.getTopScopeValue(top, NativeGenerator.GENERATOR_TAG);
        this.setPrototype(prototype);
    }
    
    @Override
    public String getClassName() {
        return "Generator";
    }
    
    @Override
    protected void initPrototypeId(final int id) {
        if (id == 5) {
            this.initPrototypeMethod(NativeGenerator.GENERATOR_TAG, id, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 1;
                s = "next";
                break;
            }
            case 2: {
                arity = 1;
                s = "return";
                break;
            }
            case 3: {
                arity = 0;
                s = "throw";
                break;
            }
            case 4: {
                arity = 1;
                s = "__iterator__";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeGenerator.GENERATOR_TAG, id, s, arity);
    }
    
    @Override
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeGenerator.GENERATOR_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        if (!(thisObj instanceof NativeGenerator)) {
            throw IdScriptableObject.incompatibleCallError(f);
        }
        final NativeGenerator generator = (NativeGenerator)thisObj;
        switch (id) {
            case 1: {
                generator.firstTime = false;
                final Object arg = (args.length > 0) ? args[0] : Undefined.instance;
                return generator.resume(cx, scope, 0, arg);
            }
            case 2: {
                final Object arg = (args.length > 0) ? args[0] : Undefined.instance;
                return generator.resume(cx, scope, 2, arg);
            }
            case 3: {
                return generator.resume(cx, scope, 1, (args.length > 0) ? args[0] : Undefined.instance);
            }
            case 4:
            case 5: {
                return new NativeGeneratorIterator(cx, scope, (NativeGenerator)thisObj);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    Object resume(final Context cx, final Scriptable scope, final int operation, final Object value) {
        if (this.savedState == null) {
            throw new JavaScriptException(value, this.lineSource, this.lineNumber);
        }
        try {
            synchronized (this) {
                if (this.locked) {
                    throw ScriptRuntime.typeError0("msg.already.exec.gen");
                }
                this.locked = true;
            }
            return this.function.resumeGenerator(cx, scope, operation, this.savedState, value);
        }
        catch (GeneratorClosedException e2) {
            return Undefined.instance;
        }
        catch (RhinoException e) {
            this.lineNumber = e.lineNumber();
            this.lineSource = e.lineSource();
            this.savedState = null;
            throw e;
        }
        finally {
            synchronized (this) {
                this.locked = false;
            }
        }
    }
    
    @Override
    protected int findPrototypeId(final Symbol key) {
        if (SymbolKey.ITERATOR.equals(key)) {
            return 5;
        }
        return 0;
    }
    
    @Override
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 4: {
                X = "next";
                id = 1;
                break;
            }
            case 5: {
                X = "throw";
                id = 3;
                break;
            }
            case 6: {
                X = "return";
                id = 2;
                break;
            }
            case 12: {
                X = "__iterator__";
                id = 4;
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        GENERATOR_TAG = "Generator";
    }
    
    public static class GeneratorClosedException extends RuntimeException
    {
        private static final long serialVersionUID = 2561315658662379681L;
    }
}
