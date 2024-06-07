//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public final class NativeCall extends IdScriptableObject
{
    private static final long serialVersionUID = -7471457301304454454L;
    private static final Object CALL_TAG;
    private static final int Id_constructor = 1;
    private static final int MAX_PROTOTYPE_ID = 1;
    NativeFunction function;
    Object[] callArgs;
    Object[] effectiveArgs;
    boolean isStrict;
    boolean syncArgumentsObj;
    private Arguments arguments;
    transient NativeCall parentActivationCall;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeCall obj = new NativeCall();
        obj.exportAsJSClass(1, scope, sealed);
    }
    
    NativeCall() {
    }
    
    NativeCall(final NativeFunction function, final Scriptable scope, final Object[] callArgs, final Object[] effectiveArgs, final boolean isArrow, final boolean isStrict, final boolean syncArgumentsObj) {
        this.function = function;
        this.setParentScope(scope);
        this.syncArgumentsObj = (!isStrict && syncArgumentsObj);
        this.callArgs = ((callArgs == null) ? ScriptRuntime.emptyArgs : callArgs);
        this.effectiveArgs = ((effectiveArgs == null) ? ScriptRuntime.emptyArgs : effectiveArgs);
        this.isStrict = isStrict;
        final int paramAndVarCount = function.getParamAndVarCount();
        final int paramCount = function.getParamCount();
        if (paramAndVarCount != 0) {
            for (int i = 0; i < paramCount; ++i) {
                final String name = function.getParamOrVarName(i);
                final Object val = (i < this.effectiveArgs.length) ? this.effectiveArgs[i] : Undefined.instance;
                this.defineProperty(name, val, 4);
            }
        }
        if (!super.has("arguments", (Scriptable)this) && !isArrow) {
            this.defineProperty("arguments", (Object)(this.arguments = new Arguments(this)), 4);
        }
        if (paramAndVarCount != 0) {
            for (int i = paramCount; i < paramAndVarCount; ++i) {
                final String name = function.getParamOrVarName(i);
                if (!super.has(name, (Scriptable)this)) {
                    if (function.getParamOrVarConst(i)) {
                        this.defineProperty(name, Undefined.instance, 13);
                    }
                    else if (!(function instanceof InterpretedFunction) || ((InterpretedFunction)function).hasFunctionNamed(name)) {
                        this.defineProperty(name, Undefined.instance, 4);
                    }
                }
            }
        }
    }
    
    public String getClassName() {
        return "Call";
    }
    
    protected int findPrototypeId(final String s) {
        return s.equals("constructor") ? 1 : 0;
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 1) {
            final int arity = 1;
            final String s = "constructor";
            this.initPrototypeMethod(NativeCall.CALL_TAG, id, s, arity);
            return;
        }
        throw new IllegalArgumentException(String.valueOf(id));
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeCall.CALL_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        if (id != 1) {
            throw new IllegalArgumentException(String.valueOf(id));
        }
        if (thisObj != null) {
            throw Context.reportRuntimeError1("msg.only.from.new", (Object)"Call");
        }
        ScriptRuntime.checkDeprecated(cx, "Call");
        final NativeCall result = new NativeCall();
        result.setPrototype(getObjectPrototype(scope));
        return result;
    }
    
    public void putRaw(final String name, final Scriptable start, final Object value) {
        super.put(name, start, value);
    }
    
    public void put(final String name, final Scriptable start, final Object value) {
        if (this.syncArgumentsObj && this.arguments != null) {
            int index = -1;
            for (int i = 0; i < this.function.getParamCount() && index == -1; ++i) {
                if (this.function.getParamOrVarName(i).equals(name)) {
                    index = i;
                }
            }
            if (index != -1) {
                ScriptableObject.putProperty((Scriptable)this.arguments, index, value);
            }
        }
        super.put(name, start, value);
    }
    
    public void defineAttributesForArguments() {
        if (this.arguments != null) {
            this.arguments.defineAttributesForStrictMode();
        }
    }
    
    static {
        CALL_TAG = "Call";
    }
}
