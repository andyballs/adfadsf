//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class BoundFunction extends BaseFunction
{
    private static final long serialVersionUID = 2118137342826470729L;
    private final Callable targetFunction;
    private final Scriptable boundThis;
    private final Object[] boundArgs;
    private final int length;
    
    public BoundFunction(final Context cx, final Scriptable scope, final Callable targetFunction, final Scriptable boundThis, final Object[] boundArgs) {
        this.targetFunction = targetFunction;
        this.boundThis = boundThis;
        this.boundArgs = boundArgs;
        if (targetFunction instanceof BaseFunction) {
            this.length = Math.max(0, ((BaseFunction)targetFunction).getLength() - boundArgs.length);
        }
        else {
            this.length = 0;
        }
        ScriptRuntime.setFunctionProtoAndParent(this, scope);
        if (targetFunction instanceof Scriptable) {
            this.setPrototype(((Scriptable)targetFunction).getPrototype());
        }
        final Function thrower = (Function)ScriptRuntime.typeErrorThrower(cx);
        final NativeObject throwing = new NativeObject();
        throwing.put("get", throwing, thrower);
        throwing.put("set", throwing, thrower);
        throwing.put("enumerable", throwing, false);
        throwing.put("configurable", throwing, false);
        throwing.preventExtensions();
        this.defineOwnProperty(cx, (Object)"caller", (ScriptableObject)throwing, false);
        this.defineOwnProperty(cx, (Object)"arguments", (ScriptableObject)throwing, false);
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] extraArgs) {
        final Scriptable callThis = (this.boundThis != null) ? this.boundThis : ScriptRuntime.getTopCallScope(cx);
        return this.targetFunction.call(cx, scope, callThis, this.concat(this.boundArgs, extraArgs));
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] extraArgs) {
        if (this.targetFunction instanceof Function) {
            return ((Function)this.targetFunction).construct(cx, scope, this.concat(this.boundArgs, extraArgs));
        }
        throw ScriptRuntime.typeError0("msg.not.ctor");
    }
    
    public Object getForcedNewTarget() {
        if (this.targetFunction instanceof BaseFunction) {
            return ((BaseFunction)this.targetFunction).getForcedNewTarget();
        }
        throw ScriptRuntime.typeError0("msg.not.ctor");
    }
    
    public void setForcedNewTarget(final Object forcedNewTarget) {
        if (this.targetFunction instanceof BaseFunction) {
            ((BaseFunction)this.targetFunction).setForcedNewTarget(forcedNewTarget);
            return;
        }
        throw ScriptRuntime.typeError0("msg.not.ctor");
    }
    
    public boolean hasInstance(final Scriptable instance) {
        if (this.targetFunction instanceof Function) {
            return ((Function)this.targetFunction).hasInstance(instance);
        }
        throw ScriptRuntime.typeError0("msg.not.ctor");
    }
    
    public int getLength() {
        return this.length;
    }
    
    public String getFunctionName() {
        if (this.targetFunction instanceof BaseFunction) {
            return "bound " + ((BaseFunction)this.targetFunction).getFunctionName();
        }
        return "";
    }
    
    private Object[] concat(final Object[] first, final Object[] second) {
        final Object[] args = new Object[first.length + second.length];
        System.arraycopy(first, 0, args, 0, first.length);
        System.arraycopy(second, 0, args, first.length, second.length);
        return args;
    }
    
    static boolean equalObjectGraphs(final BoundFunction f1, final BoundFunction f2, final EqualObjectGraphs eq) {
        return eq.equalGraphs(f1.boundThis, f2.boundThis) && eq.equalGraphs(f1.targetFunction, f2.targetFunction) && eq.equalGraphs(f1.boundArgs, f2.boundArgs);
    }
}
