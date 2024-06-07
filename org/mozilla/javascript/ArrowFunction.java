//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class ArrowFunction extends BaseFunction
{
    private static final long serialVersionUID = -7377989503697220633L;
    protected final Callable targetFunction;
    protected final Scriptable boundThis;
    
    public ArrowFunction(final Context cx, final Scriptable scope, final Callable targetFunction, final Scriptable boundThis) {
        this.targetFunction = targetFunction;
        this.boundThis = boundThis;
        ScriptRuntime.setFunctionProtoAndParent(this, scope);
        final Function thrower = ScriptRuntime.typeErrorThrower(cx);
        final NativeObject throwing = new NativeObject();
        throwing.put("get", throwing, thrower);
        throwing.put("set", throwing, thrower);
        throwing.put("enumerable", throwing, false);
        throwing.put("configurable", throwing, false);
        throwing.preventExtensions();
        this.defineOwnProperty(cx, "caller", throwing, false);
        this.defineOwnProperty(cx, "arguments", throwing, false);
    }
    
    @Override
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Scriptable callThis = (this.boundThis != null) ? this.boundThis : ScriptRuntime.getTopCallScope(cx);
        return this.targetFunction.call(cx, scope, callThis, args);
    }
    
    @Override
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        throw ScriptRuntime.typeError1("msg.not.ctor", this.decompile(0, 0));
    }
    
    @Override
    public boolean isConstructable() {
        return false;
    }
    
    @Override
    public boolean hasInstance(final Scriptable instance) {
        if (this.targetFunction instanceof Function) {
            return ((Function)this.targetFunction).hasInstance(instance);
        }
        throw ScriptRuntime.typeError0("msg.not.ctor");
    }
    
    @Override
    public int getLength() {
        if (this.targetFunction instanceof BaseFunction) {
            return ((BaseFunction)this.targetFunction).getLength();
        }
        return 0;
    }
    
    @Override
    public int getArity() {
        return this.getLength();
    }
    
    @Override
    String decompile(final int indent, final int flags) {
        if (this.targetFunction instanceof BaseFunction) {
            return ((BaseFunction)this.targetFunction).decompile(indent, flags);
        }
        return super.decompile(indent, flags);
    }
    
    public Callable getTargetFunction() {
        return this.targetFunction;
    }
    
    static boolean equalObjectGraphs(final ArrowFunction f1, final ArrowFunction f2, final EqualObjectGraphs eq) {
        return eq.equalGraphs(f1.boundThis, f2.boundThis) && eq.equalGraphs(f1.targetFunction, f2.targetFunction);
    }
}
