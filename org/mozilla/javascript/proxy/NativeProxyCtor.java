//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.proxy;

import org.mozilla.javascript.*;

public class NativeProxyCtor extends BaseFunction
{
    private static final String PROXY_TAG = "Proxy";
    private static final int ConstructorId_revocable = -1;
    
    public NativeProxyCtor() {
        this.addIdFunctionProperty((Scriptable)this, (Object)"Proxy", -1, "revocable", 2);
    }
    
    public String getFunctionName() {
        return "Proxy";
    }
    
    public int getLength() {
        return 2;
    }
    
    public int getArity() {
        return 2;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        throw ScriptRuntime.typeError1("msg.builtin.no.new", "Proxy");
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag((Object)"Proxy")) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        if (id != -1) {
            throw Kit.codeBug();
        }
        if (args.length != 2) {
            throw ScriptRuntime.typeError0("msg.proxy.revocable.two.args");
        }
        if (!(args[0] instanceof ScriptableObject) || !(args[1] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError0("msg.proxy.revocable.arg.types");
        }
        final NativeProxy proxy = new NativeProxy((ScriptableObject)args[0], (ScriptableObject)args[1]);
        final Function revoke = (Function)new BaseFunction() {
            public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
                proxy.revoke();
                return null;
            }
        };
        final NativeProxyRevocableObject obj = new NativeProxyRevocableObject(proxy, revoke);
        ScriptableObject.putProperty((Scriptable)obj, "proxy", proxy);
        ScriptableObject.putProperty((Scriptable)obj, "revoke", revoke);
        return obj;
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        if (args.length == 0) {
            throw ScriptRuntime.typeError("Proxy constructor requires a target object");
        }
        if (!(args[0] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", ScriptRuntime.toString(args[0]));
        }
        if (args.length < 2 || !(args[1] instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.not.obj", (args.length > 2) ? ScriptRuntime.toString(args[1]) : "undefined");
        }
        return (Scriptable)new NativeProxy((ScriptableObject)args[0], (ScriptableObject)args[1]);
    }
    
    protected String getInstanceIdName(final int id) {
        return super.getInstanceIdName(id);
    }
}
