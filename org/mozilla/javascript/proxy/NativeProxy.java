//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.proxy;

import java.util.*;
import org.mozilla.javascript.*;

public class NativeProxy extends IdScriptableObject implements Function
{
    private static final long serialVersionUID = -5164128569432516845L;
    private ScriptableObject target;
    private ScriptableObject handler;
    private List<Object> handlerIds;
    private boolean revoked;
    
    public static void init(final Scriptable scope, final boolean sealed) {
        final NativeProxyCtor ctor = new NativeProxyCtor();
        ctor.setParentScope(scope);
        ctor.setPrototype(getObjectPrototype(scope));
        ScriptableObject.deleteProperty((Scriptable)ctor, "prototype");
        if (sealed) {
            ctor.sealObject();
        }
        defineProperty(scope, "Proxy", (Object)ctor, 2);
    }
    
    NativeProxy(final ScriptableObject target, final ScriptableObject handler) {
        this.target = target;
        this.handler = handler;
        this.handlerIds = ((handler == null) ? Collections.emptyList() : Arrays.asList(handler.getIds()));
    }
    
    public ScriptableObject getTarget() {
        return this.target;
    }
    
    public ScriptableObject getHandler() {
        return this.handler;
    }
    
    void revoke() {
        this.revoked = true;
    }
    
    public boolean isRevoked() {
        return this.revoked;
    }
    
    private void ensureNotRevoked() {
        if (this.revoked) {
            throw ScriptRuntime.typeError0("msg.proxy.revocable.illegal.operation");
        }
    }
    
    public String getClassName() {
        return this.target.getClassName();
    }
    
    protected void initPrototypeId(final int id) {
        throw new IllegalArgumentException(String.valueOf(id));
    }
    
    public Object get(final String name, final Scriptable start) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("get")) {
            return this.target.get(name, this.target);
        }
        final Object get = this.handler.get("get");
        if (get == null) {
            return null;
        }
        if (!(get instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "get");
        }
        final Function fn = (Function)get;
        final Object result = fn.call(Context.getContext(), (Scriptable)this, start, new Object[] { this.target, name, start });
        if (this.target.has(name, this.target)) {
            final int attributes = this.target.getAttributes(name);
            if ((attributes & 0x4) != 0x0 && (attributes & 0x1) != 0x0) {
                final Object targetRes = this.target.get(name);
                if (result != targetRes) {
                    throw ScriptRuntime.typeError1("msg.proxy.invariant.get", name);
                }
            }
        }
        return result;
    }
    
    public Object get(final int index, final Scriptable start) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("get")) {
            return this.target.get(index, this.target);
        }
        final Object get = this.handler.get("get");
        if (get == null) {
            return null;
        }
        if (!(get instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "get");
        }
        final Function fn = (Function)get;
        final Object result = fn.call(Context.getContext(), (Scriptable)this, start, new Object[] { this.target, ScriptRuntime.toString(index), start });
        if (this.target.has(index, this.target)) {
            final int attributes = this.target.getAttributes(index);
            if ((attributes & 0x4) != 0x0 && (attributes & 0x1) != 0x0) {
                final Object targetRes = this.target.get(index);
                if (result != targetRes) {
                    throw ScriptRuntime.typeError1("msg.proxy.invariant.get", index);
                }
            }
        }
        return result;
    }
    
    public Object get(final Symbol key, final Scriptable start) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("get")) {
            return this.target.get(key, this.target);
        }
        final Object get = this.handler.get("get");
        if (get == null) {
            return null;
        }
        if (!(get instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "get");
        }
        final Function fn = (Function)get;
        final Object result = fn.call(Context.getContext(), (Scriptable)this, start, new Object[] { this.target, key, start });
        if (this.target.has(key, this.target)) {
            final int attributes = this.target.getAttributes(key);
            if ((attributes & 0x4) != 0x0 && (attributes & 0x1) != 0x0) {
                final Object targetRes = this.target.get(key);
                if (result != targetRes) {
                    throw ScriptRuntime.typeError1("msg.proxy.invariant.get", key);
                }
            }
        }
        return result;
    }
    
    public void put(final String name, final Scriptable start, final Object value) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("set")) {
            this.target.put(name, this.target, value);
            return;
        }
        if (this.target.has(name, this.target)) {
            final int attributes = this.target.getAttributes(name);
            final Object getter = this.target.getGetterOrSetter(name, 0, false);
            if ((attributes & 0x4) != 0x0 && (getter != null || getter != Undefined.instance) && ScriptableObject.hasProperty(this.target, "set")) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.set.accessor", name);
            }
            if ((attributes & 0x4) != 0x0 && (attributes & 0x1) != 0x0) {
                final Object oldVal = this.target.get(name);
                if (oldVal != value) {
                    throw ScriptRuntime.typeError1("msg.proxy.invariant.set.property", name);
                }
            }
        }
        final Object setter = this.handler.get("set");
        if (setter == null) {
            return;
        }
        if (!(setter instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "set");
        }
        ((Function)setter).call(Context.getContext(), (Scriptable)this, start, new Object[] { this.target, name, value, start });
    }
    
    public void put(final int index, final Scriptable start, final Object value) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("set")) {
            this.target.put(index, this.target, value);
            return;
        }
        if (this.target.has(index, this.target)) {
            final int attributes = this.target.getAttributes(index);
            final Object getter = this.target.getGetterOrSetter((String)null, index, false);
            if ((attributes & 0x4) != 0x0 && (getter != null || getter != Undefined.instance) && ScriptableObject.hasProperty(this.target, "set")) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.set.accessor", index);
            }
            if ((attributes & 0x4) != 0x0 && (attributes & 0x1) != 0x0) {
                final Object oldVal = this.target.get(index);
                if (oldVal != value) {
                    throw ScriptRuntime.typeError1("msg.proxy.invariant.set.property", index);
                }
            }
        }
        final Object setter = this.handler.get("set");
        if (setter == null) {
            return;
        }
        if (!(setter instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "set");
        }
        ((Function)setter).call(Context.getContext(), (Scriptable)this, start, new Object[] { this.target, index, value, start });
    }
    
    public void put(final Symbol key, final Scriptable start, final Object value) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("set")) {
            this.target.put(key, this.target, value);
        }
        if (this.target.has(key, this.target)) {
            final int attributes = this.target.getAttributes(key);
            final Object getter = this.target.getGetterOrSetter(key, 0, false);
            if ((attributes & 0x4) != 0x0 && (getter != null || getter != Undefined.instance) && ScriptableObject.hasProperty(this.target, "set")) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.set.accessor", key);
            }
            if ((attributes & 0x4) != 0x0 && (attributes & 0x1) != 0x0) {
                final Object oldVal = this.target.get(key);
                if (oldVal != value) {
                    throw ScriptRuntime.typeError1("msg.proxy.invariant.set.property", key);
                }
            }
        }
        final Object setter = this.handler.get("set");
        if (setter == null) {
            return;
        }
        if (!(setter instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "put");
        }
        ((Function)setter).call(Context.getContext(), (Scriptable)this, start, new Object[] { this.target, key, value, start });
    }
    
    public boolean has(final String name, final Scriptable start) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("has")) {
            return this.target.has(name, this.target);
        }
        final Object handlerHas = this.handler.get("has");
        if (handlerHas == null) {
            return false;
        }
        if (!(handlerHas instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "has");
        }
        final Function fn = (Function)handlerHas;
        final Object _handlerResult = fn.call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target, name });
        if (!(_handlerResult instanceof Boolean) && _handlerResult != Undefined.instance) {
            throw Kit.codeBug();
        }
        final boolean handlerResult = _handlerResult != Undefined.instance && (boolean)_handlerResult;
        if (this.target.has(name, this.target)) {
            final int attributes = this.target.getAttributes(name);
            if ((attributes & 0x4) != 0x0 && !handlerResult) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.has.non.configurable", name);
            }
            if (!this.target.isExtensible() && !handlerResult) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.has.non.extensible", name);
            }
        }
        return handlerResult;
    }
    
    public boolean has(final int index, final Scriptable start) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("has")) {
            return this.target.has(index, this.target);
        }
        final Object handlerHas = this.handler.get("has");
        if (handlerHas == null) {
            return false;
        }
        if (!(handlerHas instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "has");
        }
        final Function fn = (Function)handlerHas;
        final Object _handlerResult = fn.call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target, index });
        if (!(_handlerResult instanceof Boolean) && _handlerResult != Undefined.instance) {
            throw Kit.codeBug();
        }
        final boolean handlerResult = _handlerResult != Undefined.instance && (boolean)_handlerResult;
        if (this.target.has(index, this.target)) {
            final int attributes = this.target.getAttributes(index);
            if ((attributes & 0x4) != 0x0 && !handlerResult) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.has.non.configurable", index);
            }
            if (!this.target.isExtensible() && !handlerResult) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.has.non.extensible", index);
            }
        }
        return handlerResult;
    }
    
    public boolean has(final Symbol key, final Scriptable start) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("has")) {
            return this.target.has(key, this.target);
        }
        final Object handlerHas = this.handler.get("has");
        if (handlerHas == null) {
            return false;
        }
        if (!(handlerHas instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "has");
        }
        final Function fn = (Function)handlerHas;
        final Object _handlerResult = fn.call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target, key });
        if (!(_handlerResult instanceof Boolean) && _handlerResult != Undefined.instance) {
            throw Kit.codeBug();
        }
        final boolean handlerResult = _handlerResult != Undefined.instance && (boolean)_handlerResult;
        if (this.target.has(key, this.target)) {
            final int attributes = this.target.getAttributes(key);
            if ((attributes & 0x4) != 0x0 && !handlerResult) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.has.non.configurable", key);
            }
            if (!this.target.isExtensible() && !handlerResult) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.has.non.extensible", key);
            }
        }
        return handlerResult;
    }
    
    public void delete(final String name) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("deleteProperty")) {
            this.target.delete(name);
            return;
        }
        final Object deleteProperty = this.handler.get("deleteProperty");
        if (deleteProperty == null) {
            return;
        }
        if (!(deleteProperty instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "deleteProperty");
        }
        final Object _result = ((Function)deleteProperty).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target, name });
        if (!(_result instanceof Boolean) && _result != Undefined.instance) {
            throw Kit.codeBug();
        }
        final boolean result = _result != Undefined.instance && (boolean)_result;
        if (result && this.target.has(name, this.target)) {
            final int attributes = this.target.getAttributes(name);
            if ((attributes & 0x4) != 0x0) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.delete", name);
            }
        }
    }
    
    public void delete(final Symbol key) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("deleteProperty")) {
            this.target.delete(key);
            return;
        }
        final Object deleteProperty = this.handler.get("deleteProperty");
        if (deleteProperty == null) {
            return;
        }
        if (!(deleteProperty instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "deleteProperty");
        }
        final Object _result = ((Function)deleteProperty).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target, key });
        if (!(_result instanceof Boolean) && _result != Undefined.instance) {
            throw Kit.codeBug();
        }
        final boolean result = _result != Undefined.instance && (boolean)_result;
        if (result && this.target.has(key, this.target)) {
            final int attributes = this.target.getAttributes(key);
            if ((attributes & 0x4) != 0x0) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.delete", key);
            }
        }
    }
    
    public ScriptableObject getOwnPropertyDescriptor(final Context cx, final Object id) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("getOwnPropertyDescriptor")) {
            return this.target.getOwnPropertyDescriptor(cx, id);
        }
        final Object getOwnPropertyDescriptor = this.handler.get("getOwnPropertyDescriptor");
        if (getOwnPropertyDescriptor == null) {
            return null;
        }
        if (!(getOwnPropertyDescriptor instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "getOwnPropertyDescriptor");
        }
        final Object _result = ((Function)getOwnPropertyDescriptor).call(cx, (Scriptable)this, (Scriptable)this, new Object[] { this.target, id });
        if (_result != Undefined.instance && !(_result instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.proxy.invariant.getdescriptor.inv1", ScriptRuntime.toString(id));
        }
        boolean exists;
        int targetDesc;
        if (id instanceof String) {
            exists = this.target.has((String)id, this.target);
            targetDesc = (exists ? this.target.getAttributes((String)id) : -1);
        }
        else {
            if (!ScriptRuntime.isSymbol(id)) {
                throw Kit.codeBug();
            }
            exists = this.target.has((Symbol)id, this.target);
            targetDesc = (exists ? this.target.getAttributes((Symbol)id) : -1);
        }
        if (_result == Undefined.instance && exists && (targetDesc & 0x4) != 0x0) {
            throw ScriptRuntime.typeError1("msg.proxy.invariant.getdescriptor.inv2", ScriptRuntime.toString(id));
        }
        if (_result == Undefined.instance && exists && !this.target.isExtensible()) {
            throw ScriptRuntime.typeError1("msg.proxy.invariant.getdescriptor.inv3", ScriptRuntime.toString(id));
        }
        if (_result == Undefined.instance) {
            return null;
        }
        if (!exists && !this.target.isExtensible()) {
            throw ScriptRuntime.typeError1("msg.proxy.invariant.getdescriptor.inv4", ScriptRuntime.toString(id));
        }
        final ScriptableObject handlerDesc = (ScriptableObject)_result;
        final boolean configurable = isConfigurable(handlerDesc);
        if (!configurable) {
            if (!exists) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.getdescriptor.inv5.non.existant", ScriptRuntime.toString(id));
            }
            if ((targetDesc & 0x4) == 0x0) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.getdescriptor.inv5.existant", ScriptRuntime.toString(id));
            }
        }
        if (!handlerDesc.has("configurable", handlerDesc)) {
            putProperty((Scriptable)handlerDesc, "configurable", (Object)false);
        }
        if (!handlerDesc.has("writable", handlerDesc)) {
            putProperty((Scriptable)handlerDesc, "writable", (Object)false);
        }
        if (!handlerDesc.has("enumerable", handlerDesc)) {
            putProperty((Scriptable)handlerDesc, "enumerable", (Object)false);
        }
        return handlerDesc;
    }
    
    public void defineOwnProperty(final Context cx, final Object id, final ScriptableObject desc) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("defineProperty")) {
            this.target.defineOwnProperty(cx, id, desc);
            return;
        }
        final Object defineProperty = this.handler.get("defineProperty");
        if (defineProperty == null) {
            return;
        }
        if (!(defineProperty instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "defineOwnProperty");
        }
        final Object result = ((Function)defineProperty).call(cx, (Scriptable)this, (Scriptable)this, new Object[] { this.target, id, desc });
        if (result instanceof Boolean && !(boolean)result) {
            throw ScriptRuntime.typeError1("msg.proxy.invariant.defineprop.returned.false", ScriptRuntime.toString(id));
        }
        if (!this.target.isExtensible()) {
            throw ScriptRuntime.typeError1("msg.proxy.invariant.defineprop.not.extensible", ScriptRuntime.toString(id));
        }
        final boolean isConfigurable = isConfigurable(desc);
        if (!isConfigurable) {
            final int attributes = getAttributes(this.target, id);
            if (attributes != -1 && (attributes & 0x4) == 0x0) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.defineprop.non.configurable", ScriptRuntime.toString(id));
            }
        }
    }
    
    public Scriptable getPrototype() {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("getPrototypeOf")) {
            return this.target.getPrototype();
        }
        final Object getPrototypeOf = this.handler.get("getPrototypeOf");
        if (getPrototypeOf == null) {
            return null;
        }
        if (!(getPrototypeOf instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "getPrototypeOf");
        }
        final Object result = ((Function)getPrototypeOf).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target });
        if (result != null && !(result instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError0("msg.proxy.invariant.getproto.invalid.return");
        }
        if (!this.target.isExtensible() && result != this.target.getPrototype()) {
            throw ScriptRuntime.typeError0("msg.proxy.invariant.getproto.non.extensible");
        }
        return (ScriptableObject)result;
    }
    
    public void setPrototype(final Scriptable m) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("setPrototypeOf")) {
            this.target.setPrototype(m);
            return;
        }
        final Object setPrototypeOf = this.handler.get("setPrototypeOf");
        if (setPrototypeOf == null) {
            return;
        }
        if (!(setPrototypeOf instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "setPrototypeOf");
        }
        final Object result = ((Function)setPrototypeOf).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target, m });
        if (result instanceof Boolean && (boolean)result && !this.target.isExtensible() && m != this.target.getPrototype()) {
            throw ScriptRuntime.typeError0("msg.proxy.invariant.setproto.invalid.parameter");
        }
    }
    
    public boolean isExtensible() {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("isExtensible")) {
            return this.target.isExtensible();
        }
        final Object isExtensible = this.handler.get("isExtensible");
        if (isExtensible == null) {
            return false;
        }
        if (!(isExtensible instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "isExtensible");
        }
        final Object result = ((Function)isExtensible).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target });
        if (!(result instanceof Boolean) || (boolean)result != this.target.isExtensible()) {
            throw ScriptRuntime.typeError0("msg.proxy.invariant.isextensible");
        }
        return (boolean)result;
    }
    
    public void preventExtensions() {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("preventExtensions")) {
            this.target.preventExtensions();
        }
        final Object preventExtensions = this.handler.get("preventExtensions");
        if (preventExtensions == null) {
            return;
        }
        if (!(preventExtensions instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "preventExtensions");
        }
        final Object result = ((Function)preventExtensions).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target });
        if (result instanceof Boolean && (boolean)result && this.isExtensible()) {
            throw ScriptRuntime.typeError0("msg.proxy.invariant.prevent.extensible");
        }
    }
    
    public Object[] getIds(final boolean getNonEnumerable, final boolean getSymbols) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("ownKeys")) {
            return this.target.getIds(getNonEnumerable, getSymbols);
        }
        final Object ownKeys = this.handler.get("ownKeys");
        if (!(ownKeys instanceof Function)) {
            throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "setPrototypeOf");
        }
        final Object result = ((Function)ownKeys).call(Context.getContext(), (Scriptable)this, (Scriptable)this, new Object[] { this.target });
        if (!(result instanceof NativeArray)) {
            throw ScriptRuntime.typeError0("msg.proxy.invariant.ownkeys.invalid.array");
        }
        final Object[] resultIds = ((NativeArray)result).toArray();
        final boolean extensible = this.target.isExtensible();
        final List<Object> targetIds = Arrays.asList(this.target.getIds());
        for (final Object resultId : resultIds) {
            if (!(resultId instanceof String) && !ScriptRuntime.isSymbol(resultId)) {
                throw ScriptRuntime.typeError0("msg.proxy.invariant.ownkeys.invalid.array");
            }
            if (!extensible && !targetIds.contains(resultId)) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.ownkeys.invalid.element", ScriptRuntime.toString(resultId));
            }
            targetIds.remove(resultId);
        }
        for (final Object targetId : targetIds) {
            final int attributes = getAttributes(this.target, targetId);
            if (attributes != -1 && (attributes & 0x4) != 0x0) {
                throw ScriptRuntime.typeError1("msg.proxy.invariant.ownkeys.skip.prop", ScriptRuntime.toString(targetId));
            }
        }
        return resultIds;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("apply")) {
            if (this.target instanceof Callable) {
                return ((Callable)this.target).call(cx, scope, (Scriptable)this.target, args);
            }
            throw ScriptRuntime.typeError0("msg.proxy.not.callable");
        }
        else {
            if (!(this.target instanceof Callable)) {
                throw ScriptRuntime.typeError0("msg.proxy.target.not.callable");
            }
            final Object apply = this.handler.get("apply");
            if (!(apply instanceof Function)) {
                throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "call");
            }
            return ((Function)apply).call(cx, scope, thisObj, new Object[] { this.target, thisObj, cx.newArray(scope, args) });
        }
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        this.ensureNotRevoked();
        if (!this.handlerIds.contains("construct")) {
            if (this.target instanceof BaseFunction) {
                return ((BaseFunction)this.target).construct(cx, scope, args);
            }
            throw ScriptRuntime.typeError0("msg.proxy.not.constructable");
        }
        else {
            if (!(this.target instanceof Function)) {
                throw ScriptRuntime.typeError0("msg.proxy.target.not.constructable");
            }
            final Object construct = this.handler.get("construct");
            if (construct == null) {
                return null;
            }
            if (!(construct instanceof Function)) {
                throw ScriptRuntime.typeError1("msg.proxy.invalid.handler", "preventExtensions");
            }
            final Object result = ((Function)construct).call(cx, scope, (Scriptable)this, new Object[] { this.target, cx.newArray(scope, args), this });
            if (!(result instanceof ScriptableObject)) {
                throw ScriptRuntime.typeError0("msg.proxy.result.not.constructable");
            }
            return (ScriptableObject)result;
        }
    }
    
    public int getArity() {
        this.ensureNotRevoked();
        if (this.handlerIds.contains("construct")) {
            return ((BaseFunction)this.handler.get("construct")).getArity();
        }
        if (this.handlerIds.contains("apply")) {
            return ((BaseFunction)this.handler.get("apply")).getArity();
        }
        if (this.target instanceof BaseFunction) {
            return ((BaseFunction)this.target).getArity();
        }
        throw ScriptRuntime.typeError0("msg.proxy.not.callable");
    }
    
    private static int getAttributes(final ScriptableObject obj, final Object id) {
        if (id instanceof String) {
            final String s = (String)id;
            if (!obj.has(s, obj)) {
                return -1;
            }
            return obj.getAttributes(s);
        }
        else {
            if (!ScriptRuntime.isSymbol(id)) {
                throw Kit.codeBug();
            }
            final Symbol s2 = (Symbol)id;
            if (!obj.has(s2, obj)) {
                return -1;
            }
            return obj.getAttributes(s2);
        }
    }
    
    private static boolean isConfigurable(final ScriptableObject desc) {
        final Object result = hasProperty((Scriptable)desc, "configurable") ? getProperty((Scriptable)desc, "configurable") : Boolean.valueOf(false);
        return result instanceof Boolean && (boolean)result;
    }
}
