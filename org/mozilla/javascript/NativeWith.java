//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import java.util.*;

public class NativeWith implements Scriptable, SymbolScriptable, IdFunctionCall, Serializable
{
    private static final long serialVersionUID = 1L;
    private static final Object FTAG;
    private static final int Id_constructor = 1;
    protected Scriptable prototype;
    protected Scriptable parent;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeWith obj = new NativeWith();
        obj.setParentScope(scope);
        obj.setPrototype(ScriptableObject.getObjectPrototype(scope));
        final IdFunctionObject ctor = new IdFunctionObject((IdFunctionCall)obj, NativeWith.FTAG, 1, "With", 0, scope);
        ctor.markAsConstructor((Scriptable)obj);
        if (sealed) {
            ctor.sealObject();
        }
        ctor.exportAsScopeProperty();
    }
    
    private NativeWith() {
    }
    
    protected NativeWith(final Scriptable parent, final Scriptable prototype) {
        this.parent = parent;
        if (ScriptableObject.hasProperty(prototype, SymbolKey.UNSCOPABLES)) {
            final Object unscopables = ScriptableObject.getProperty(prototype, SymbolKey.UNSCOPABLES);
            if (unscopables instanceof NativeObject) {
                final NativeObject obj = (NativeObject)unscopables;
                for (final Map.Entry<Object, Object> element : obj.entrySet()) {
                    final Object k = element.getKey();
                    final Object v = element.getValue();
                    if (v instanceof Boolean && (boolean)v) {
                        if (k instanceof String) {
                            ScriptableObject.deleteProperty(prototype, (String)k);
                        }
                        else {
                            if (!(k instanceof Integer)) {
                                continue;
                            }
                            ScriptableObject.deleteProperty(prototype, (int)k);
                        }
                    }
                }
            }
        }
        this.prototype = prototype;
    }
    
    @Override
    public String getClassName() {
        return "With";
    }
    
    @Override
    public boolean has(final String id, final Scriptable start) {
        return this.prototype.has(id, this.prototype);
    }
    
    @Override
    public boolean has(final Symbol key, final Scriptable start) {
        return this.prototype instanceof SymbolScriptable && ((SymbolScriptable)this.prototype).has(key, this.prototype);
    }
    
    @Override
    public boolean has(final int index, final Scriptable start) {
        return this.prototype.has(index, this.prototype);
    }
    
    @Override
    public Object get(final String id, Scriptable start, final boolean isPrivate) {
        if (isPrivate) {
            throw Kit.codeBug("Unexpected private get from with statement");
        }
        if (start == this) {
            start = this.prototype;
        }
        return this.prototype.get(id, start);
    }
    
    @Override
    public Object get(final Symbol key, Scriptable start) {
        if (start == this) {
            start = this.prototype;
        }
        if (this.prototype instanceof SymbolScriptable) {
            return ((SymbolScriptable)this.prototype).get(key, start);
        }
        return Scriptable.NOT_FOUND;
    }
    
    @Override
    public Object get(final int index, Scriptable start) {
        if (start == this) {
            start = this.prototype;
        }
        return this.prototype.get(index, start);
    }
    
    @Override
    public void put(final String id, Scriptable start, final Object value, final boolean isPrivate) {
        if (isPrivate) {
            throw Kit.codeBug("Unexpected private put from with statement");
        }
        if (start == this) {
            start = this.prototype;
        }
        this.prototype.put(id, start, value);
    }
    
    @Override
    public void put(final Symbol symbol, Scriptable start, final Object value) {
        if (start == this) {
            start = this.prototype;
        }
        if (this.prototype instanceof SymbolScriptable) {
            ((SymbolScriptable)this.prototype).put(symbol, start, value);
        }
    }
    
    @Override
    public void put(final int index, Scriptable start, final Object value) {
        if (start == this) {
            start = this.prototype;
        }
        this.prototype.put(index, start, value);
    }
    
    @Override
    public void declare(final String name, Scriptable start) {
        if (start == this) {
            start = this.prototype;
        }
        this.prototype.declare(name, start);
    }
    
    @Override
    public void declareConst(final String name, Scriptable start) {
        if (start == this) {
            start = this.prototype;
        }
        this.prototype.declare(name, start);
    }
    
    @Override
    public void delete(final String id) {
        this.prototype.delete(id);
    }
    
    @Override
    public void delete(final Symbol key) {
        if (this.prototype instanceof SymbolScriptable) {
            ((SymbolScriptable)this.prototype).delete(key);
        }
    }
    
    @Override
    public void delete(final int index) {
        this.prototype.delete(index);
    }
    
    @Override
    public Scriptable getPrototype() {
        return this.prototype;
    }
    
    @Override
    public void setPrototype(final Scriptable prototype) {
        this.prototype = prototype;
    }
    
    @Override
    public Scriptable getParentScope() {
        return this.parent;
    }
    
    @Override
    public void setParentScope(final Scriptable parent) {
        this.parent = parent;
    }
    
    @Override
    public Object[] getIds() {
        return this.prototype.getIds();
    }
    
    @Override
    public Object getDefaultValue(final Class<?> typeHint) {
        return this.prototype.getDefaultValue(typeHint);
    }
    
    @Override
    public boolean hasInstance(final Scriptable value) {
        return this.prototype.hasInstance(value);
    }
    
    protected Object updateDotQuery(final boolean value) {
        throw new IllegalStateException();
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (f.hasTag(NativeWith.FTAG) && f.methodId() == 1) {
            throw Context.reportRuntimeError1("msg.cant.call.indirect", (Object)"With");
        }
        throw f.unknown();
    }
    
    static boolean isWithFunction(final Object functionObj) {
        if (functionObj instanceof IdFunctionObject) {
            final IdFunctionObject f = (IdFunctionObject)functionObj;
            return f.hasTag(NativeWith.FTAG) && f.methodId() == 1;
        }
        return false;
    }
    
    static Object newWithSpecial(final Context cx, Scriptable scope, final Object[] args) {
        ScriptRuntime.checkDeprecated(cx, "With");
        scope = ScriptableObject.getTopLevelScope(scope);
        final NativeWith thisObj = new NativeWith();
        thisObj.setPrototype((args.length == 0) ? ScriptableObject.getObjectPrototype(scope) : ScriptRuntime.toObject(cx, scope, args[0]));
        thisObj.setParentScope(scope);
        return thisObj;
    }
    
    static {
        FTAG = "With";
    }
}
