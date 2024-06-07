//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class IdFunctionObject extends BaseFunction
{
    private static final long serialVersionUID = -5332312783643935019L;
    private final IdFunctionCall idcall;
    private final Object tag;
    private final int methodId;
    private int arity;
    private boolean useCallAsConstructor;
    private String functionName;
    
    public IdFunctionObject(final IdFunctionCall idcall, final Object tag, final int id, final int arity) {
        if (arity < 0) {
            throw new IllegalArgumentException();
        }
        this.idcall = idcall;
        this.tag = tag;
        this.methodId = id;
        this.arity = arity;
    }
    
    public IdFunctionObject(final IdFunctionCall idcall, final Object tag, final int id, final String name, final int arity, final Scriptable scope) {
        super(scope, (Scriptable)null);
        if (arity < 0) {
            throw new IllegalArgumentException();
        }
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.idcall = idcall;
        this.tag = tag;
        this.methodId = id;
        this.arity = arity;
        this.functionName = name;
    }
    
    public void initFunction(final String name, final Scriptable scope) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (scope == null) {
            throw new IllegalArgumentException();
        }
        this.functionName = name;
        this.setParentScope(scope);
    }
    
    public final boolean hasTag(final Object tag) {
        return Objects.equals(tag, this.tag);
    }
    
    public Object getTag() {
        return this.tag;
    }
    
    public final int methodId() {
        return this.methodId;
    }
    
    public final void markAsConstructor(final Scriptable prototypeProperty) {
        this.useCallAsConstructor = true;
        this.setImmunePrototypeProperty((Object)prototypeProperty);
    }
    
    public final void addAsProperty(final Scriptable target) {
        ScriptableObject.defineProperty(target, this.functionName, this, 2);
    }
    
    public void exportAsScopeProperty() {
        this.addAsProperty(this.getParentScope());
    }
    
    public Scriptable getPrototype() {
        Scriptable proto = super.getPrototype();
        if (proto == null) {
            proto = getFunctionPrototype(this.getParentScope());
            this.setPrototype(proto);
        }
        return proto;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return this.idcall.execIdCall(this, cx, scope, thisObj, args);
    }
    
    public Scriptable createObject(final Context cx, final Scriptable scope) {
        if (this.useCallAsConstructor) {
            return null;
        }
        throw ScriptRuntime.typeError1("msg.not.ctor", this.functionName);
    }
    
    String decompile(final int indent, final int flags) {
        final StringBuilder sb = new StringBuilder();
        final boolean justbody = 0x0 != (flags & 0x1);
        if (!justbody) {
            sb.append("function ");
            sb.append(this.getFunctionName());
            sb.append("() { ");
        }
        sb.append("[native code for ");
        if (this.idcall instanceof Scriptable) {
            final Scriptable sobj = (Scriptable)this.idcall;
            sb.append(sobj.getClassName());
            sb.append('.');
        }
        sb.append(this.getFunctionName());
        sb.append(", arity=");
        sb.append(this.getArity());
        sb.append(justbody ? "]\n" : "] }\n");
        return sb.toString();
    }
    
    public int getArity() {
        return this.arity;
    }
    
    public int getLength() {
        return this.getArity();
    }
    
    public String getFunctionName() {
        return (this.functionName == null) ? "" : this.functionName;
    }
    
    public final RuntimeException unknown() {
        return new IllegalArgumentException("BAD FUNCTION ID=" + this.methodId + " MASTER=" + this.idcall);
    }
    
    static boolean equalObjectGraphs(final IdFunctionObject f1, final IdFunctionObject f2, final EqualObjectGraphs eq) {
        return f1.methodId == f2.methodId && f1.hasTag(f2.tag) && eq.equalGraphs((Object)f1.idcall, (Object)f2.idcall);
    }
}
