//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class Delegator implements Function, SymbolScriptable
{
    protected Scriptable obj;
    
    public Delegator() {
        this.obj = null;
    }
    
    public Delegator(final Scriptable obj) {
        this.obj = null;
        this.obj = obj;
    }
    
    protected Delegator newInstance() {
        try {
            return (Delegator)this.getClass().newInstance();
        }
        catch (Exception ex) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex);
        }
    }
    
    public Scriptable getDelegee() {
        return this.obj;
    }
    
    public void setDelegee(final Scriptable obj) {
        this.obj = obj;
    }
    
    @Override
    public String getClassName() {
        return this.getDelegee().getClassName();
    }
    
    @Override
    public Object get(final String name, final Scriptable start, final boolean isPrivate) {
        return this.getDelegee().get(name, start, isPrivate);
    }
    
    @Override
    public Object get(final Symbol key, final Scriptable start) {
        final Scriptable delegee = this.getDelegee();
        if (delegee instanceof SymbolScriptable) {
            return ((SymbolScriptable)delegee).get(key, start);
        }
        return Scriptable.NOT_FOUND;
    }
    
    @Override
    public Object get(final int index, final Scriptable start) {
        return this.getDelegee().get(index, start);
    }
    
    @Override
    public boolean has(final String name, final Scriptable start) {
        return this.getDelegee().has(name, start);
    }
    
    @Override
    public boolean has(final Symbol key, final Scriptable start) {
        final Scriptable delegee = this.getDelegee();
        return delegee instanceof SymbolScriptable && ((SymbolScriptable)delegee).has(key, start);
    }
    
    @Override
    public boolean has(final int index, final Scriptable start) {
        return this.getDelegee().has(index, start);
    }
    
    @Override
    public void put(final String name, final Scriptable start, final Object value, final boolean isPrivate) {
        this.getDelegee().put(name, start, value, isPrivate);
    }
    
    @Override
    public void put(final Symbol symbol, final Scriptable start, final Object value) {
        final Scriptable delegee = this.getDelegee();
        if (delegee instanceof SymbolScriptable) {
            ((SymbolScriptable)delegee).put(symbol, start, value);
        }
    }
    
    @Override
    public void put(final int index, final Scriptable start, final Object value) {
        this.getDelegee().put(index, start, value);
    }
    
    @Override
    public void delete(final String name) {
        this.getDelegee().delete(name);
    }
    
    @Override
    public void delete(final Symbol key) {
        final Scriptable delegee = this.getDelegee();
        if (delegee instanceof SymbolScriptable) {
            ((SymbolScriptable)delegee).delete(key);
        }
    }
    
    @Override
    public void delete(final int index) {
        this.getDelegee().delete(index);
    }
    
    @Override
    public Scriptable getPrototype() {
        return this.getDelegee().getPrototype();
    }
    
    @Override
    public void setPrototype(final Scriptable prototype) {
        this.getDelegee().setPrototype(prototype);
    }
    
    @Override
    public Scriptable getParentScope() {
        return this.getDelegee().getParentScope();
    }
    
    @Override
    public void setParentScope(final Scriptable parent) {
        this.getDelegee().setParentScope(parent);
    }
    
    @Override
    public Object[] getIds() {
        return this.getDelegee().getIds();
    }
    
    @Override
    public Object getDefaultValue(final Class<?> hint) {
        return (hint == null || hint == ScriptRuntime.ScriptableClass || hint == ScriptRuntime.FunctionClass) ? this : this.getDelegee().getDefaultValue(hint);
    }
    
    @Override
    public boolean hasInstance(final Scriptable instance) {
        return this.getDelegee().hasInstance(instance);
    }
    
    @Override
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return ((Function)this.getDelegee()).call(cx, scope, thisObj, args);
    }
    
    @Override
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        final Scriptable myDelegee = this.getDelegee();
        if (myDelegee == null) {
            final Delegator n = this.newInstance();
            Scriptable delegee;
            if (args.length == 0) {
                delegee = new NativeObject();
            }
            else {
                delegee = ScriptRuntime.toObject(cx, scope, args[0]);
            }
            n.setDelegee(delegee);
            return n;
        }
        return ((Function)myDelegee).construct(cx, scope, args);
    }
    
    @Override
    public void declare(final String name, final Scriptable start) {
        this.getDelegee().declare(name, start);
    }
    
    @Override
    public void declareConst(final String name, final Scriptable start) {
        this.getDelegee().declare(name, start);
    }
}
