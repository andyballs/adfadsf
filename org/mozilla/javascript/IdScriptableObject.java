//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public abstract class IdScriptableObject extends ScriptableObject implements IdFunctionCall
{
    private static final long serialVersionUID = -3744239272168621609L;
    private transient PrototypeValues prototypeValues;
    
    public IdScriptableObject() {
    }
    
    public IdScriptableObject(final Scriptable scope, final Scriptable prototype) {
        super(scope, prototype);
    }
    
    protected final boolean defaultHas(final String name) {
        return super.has(name, this);
    }
    
    protected final Object defaultGet(final String name) {
        return super.get(name, this);
    }
    
    protected final void defaultPut(final String name, final Object value) {
        super.put(name, this, value);
    }
    
    @Override
    public boolean has(final String name, final Scriptable start) {
        final int info = this.findInstanceIdInfo(name);
        if (info == 0) {
            if (this.prototypeValues != null) {
                final int id = this.prototypeValues.findId(name);
                if (id != 0) {
                    return this.prototypeValues.has(id);
                }
            }
            return super.has(name, start);
        }
        final int attr = info >>> 16;
        if ((attr & 0x4) != 0x0) {
            return true;
        }
        final int id2 = info & 0xFFFF;
        return IdScriptableObject.NOT_FOUND != this.getInstanceIdValue(id2);
    }
    
    @Override
    public boolean has(final Symbol key, final Scriptable start) {
        final int info = this.findInstanceIdInfo(key);
        if (info == 0) {
            if (this.prototypeValues != null) {
                final int id = this.prototypeValues.findId(key);
                if (id != 0) {
                    return this.prototypeValues.has(id);
                }
            }
            return super.has(key, start);
        }
        final int attr = info >>> 16;
        if ((attr & 0x4) != 0x0) {
            return true;
        }
        final int id2 = info & 0xFFFF;
        return IdScriptableObject.NOT_FOUND != this.getInstanceIdValue(id2);
    }
    
    @Override
    public Object get(final String name, final Scriptable start, final boolean isPrivate) {
        Object value = super.get(name, start, isPrivate);
        if (value != IdScriptableObject.NOT_FOUND) {
            return value;
        }
        if (isPrivate) {
            return Scriptable.NOT_FOUND;
        }
        final int info = this.findInstanceIdInfo(name);
        if (info != 0) {
            final int id = info & 0xFFFF;
            value = this.getInstanceIdValue(id);
            if (value != IdScriptableObject.NOT_FOUND) {
                return value;
            }
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(name);
            if (id != 0) {
                value = this.prototypeValues.get(id);
                return value;
            }
        }
        return IdScriptableObject.NOT_FOUND;
    }
    
    @Override
    public Object get(final Symbol key, final Scriptable start) {
        Object value = super.get(key, start);
        if (value != IdScriptableObject.NOT_FOUND) {
            return value;
        }
        final int info = this.findInstanceIdInfo(key);
        if (info != 0) {
            final int id = info & 0xFFFF;
            value = this.getInstanceIdValue(id);
            if (value != IdScriptableObject.NOT_FOUND) {
                return value;
            }
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(key);
            if (id != 0) {
                value = this.prototypeValues.get(id);
                return value;
            }
        }
        return IdScriptableObject.NOT_FOUND;
    }
    
    @Override
    public void put(final String name, final Scriptable start, final Object value, final boolean isPrivate) {
        final int info = this.findInstanceIdInfo(name);
        if (info == 0) {
            if (this.prototypeValues != null) {
                final int id = this.prototypeValues.findId(name);
                if (id != 0) {
                    if (start == this && this.isSealed()) {
                        throw Context.reportRuntimeError1("msg.modify.sealed", (Object)name);
                    }
                    this.prototypeValues.set(id, start, value);
                    return;
                }
            }
            super.put(name, start, value, isPrivate);
            return;
        }
        if (start == this && this.isSealed()) {
            throw Context.reportRuntimeError1("msg.modify.sealed", (Object)name);
        }
        final int attr = info >>> 16;
        if ((attr & 0x1) == 0x0) {
            if (start == this) {
                final int id2 = info & 0xFFFF;
                this.setInstanceIdValue(id2, value);
            }
            else {
                start.put(name, start, value, isPrivate);
            }
        }
    }
    
    @Override
    public void put(final Symbol key, final Scriptable start, final Object value) {
        final int info = this.findInstanceIdInfo(key);
        if (info == 0) {
            if (this.prototypeValues != null) {
                final int id = this.prototypeValues.findId(key);
                if (id != 0) {
                    if (start == this && this.isSealed()) {
                        throw Context.reportRuntimeError0("msg.modify.sealed");
                    }
                    this.prototypeValues.set(id, start, value);
                    return;
                }
            }
            super.put(key, start, value);
            return;
        }
        if (start == this && this.isSealed()) {
            throw Context.reportRuntimeError0("msg.modify.sealed");
        }
        final int attr = info >>> 16;
        if ((attr & 0x1) == 0x0) {
            if (start == this) {
                final int id2 = info & 0xFFFF;
                this.setInstanceIdValue(id2, value);
            }
            else {
                ScriptableObject.ensureSymbolScriptable(start).put(key, start, value);
            }
        }
    }
    
    @Override
    public void delete(final String name) {
        final int info = this.findInstanceIdInfo(name);
        if (info != 0 && !this.isSealed()) {
            final int attr = info >>> 16;
            if ((attr & 0x4) != 0x0) {
                final Context cx = Context.getContext();
                if (cx.isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", name);
                }
            }
            else {
                final int id = info & 0xFFFF;
                this.setInstanceIdValue(id, IdScriptableObject.NOT_FOUND);
            }
            return;
        }
        if (this.prototypeValues != null) {
            final int id2 = this.prototypeValues.findId(name);
            if (id2 != 0) {
                if (!this.isSealed()) {
                    this.prototypeValues.delete(id2);
                }
                return;
            }
        }
        super.delete(name);
    }
    
    @Override
    public void delete(final Symbol key) {
        final int info = this.findInstanceIdInfo(key);
        if (info != 0 && !this.isSealed()) {
            final int attr = info >>> 16;
            if ((attr & 0x4) != 0x0) {
                final Context cx = Context.getContext();
                if (cx.isStrictMode()) {
                    throw ScriptRuntime.typeError0("msg.delete.property.with.configurable.false");
                }
            }
            else {
                final int id = info & 0xFFFF;
                this.setInstanceIdValue(id, IdScriptableObject.NOT_FOUND);
            }
            return;
        }
        if (this.prototypeValues != null) {
            final int id2 = this.prototypeValues.findId(key);
            if (id2 != 0) {
                if (!this.isSealed()) {
                    this.prototypeValues.delete(id2);
                }
                return;
            }
        }
        super.delete(key);
    }
    
    @Override
    public int getAttributes(final String name) {
        final int info = this.findInstanceIdInfo(name);
        if (info != 0) {
            final int attr = info >>> 16;
            return attr;
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(name);
            if (id != 0) {
                return this.prototypeValues.getAttributes(id);
            }
        }
        return super.getAttributes(name);
    }
    
    @Override
    public int getAttributes(final Symbol key) {
        final int info = this.findInstanceIdInfo(key);
        if (info != 0) {
            final int attr = info >>> 16;
            return attr;
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(key);
            if (id != 0) {
                return this.prototypeValues.getAttributes(id);
            }
        }
        return super.getAttributes(key);
    }
    
    @Override
    public void setAttributes(final String name, final int attributes) {
        ScriptableObject.checkValidAttributes(attributes);
        final int info = this.findInstanceIdInfo(name);
        if (info != 0) {
            final int id = info & 0xFFFF;
            final int currentAttributes = info >>> 16;
            if (attributes != currentAttributes) {
                this.setInstanceIdAttributes(id, attributes);
            }
            return;
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(name);
            if (id != 0) {
                this.prototypeValues.setAttributes(id, attributes);
                return;
            }
        }
        super.setAttributes(name, attributes);
    }
    
    @Override
    public Object[] getIds(final boolean getNonEnumerable, final boolean getSymbols) {
        Object[] result = super.getIds(getNonEnumerable, getSymbols);
        if (this.prototypeValues != null) {
            result = this.prototypeValues.getNames(getNonEnumerable, getSymbols, result);
        }
        final int maxInstanceId = this.getMaxInstanceId();
        if (maxInstanceId != 0) {
            Object[] ids = null;
            int count = 0;
            for (int id = maxInstanceId; id != 0; --id) {
                final String name = this.getInstanceIdName(id);
                final int info = this.findInstanceIdInfo(name);
                if (info != 0) {
                    final int attr = info >>> 16;
                    if ((attr & 0x4) != 0x0 || IdScriptableObject.NOT_FOUND != this.getInstanceIdValue(id)) {
                        if (getNonEnumerable || (attr & 0x2) == 0x0) {
                            if (count == 0) {
                                ids = new Object[id];
                            }
                            ids[count++] = name;
                        }
                    }
                }
            }
            if (count != 0) {
                if (result.length == 0 && ids.length == count) {
                    result = ids;
                }
                else {
                    final Object[] tmp = new Object[result.length + count];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    System.arraycopy(ids, 0, tmp, result.length, count);
                    result = tmp;
                }
            }
        }
        return result;
    }
    
    protected int getMaxInstanceId() {
        return 0;
    }
    
    protected static int instanceIdInfo(final int attributes, final int id) {
        return attributes << 16 | id;
    }
    
    protected int findInstanceIdInfo(final String name) {
        return 0;
    }
    
    protected int findInstanceIdInfo(final Symbol key) {
        return 0;
    }
    
    protected String getInstanceIdName(final int id) {
        throw new IllegalArgumentException(String.valueOf(id));
    }
    
    protected Object getInstanceIdValue(final int id) {
        throw new IllegalStateException(String.valueOf(id));
    }
    
    protected void setInstanceIdValue(final int id, final Object value) {
        throw new IllegalStateException(String.valueOf(id));
    }
    
    protected void setInstanceIdAttributes(final int id, final int attr) {
        throw ScriptRuntime.constructError("InternalError", "Changing attributes not supported for " + this.getClassName() + " " + this.getInstanceIdName(id) + " property");
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        throw f.unknown();
    }
    
    public final IdFunctionObject exportAsJSClass(final int maxPrototypeId, final Scriptable scope, final boolean sealed) {
        return this.exportAsJSClass(maxPrototypeId, scope, sealed, true);
    }
    
    public final IdFunctionObject exportAsJSClass(final int maxPrototypeId, final Scriptable scope, final boolean sealed, final boolean initPrototype) {
        if (scope != this && scope != null) {
            this.setParentScope(scope);
            if (initPrototype) {
                this.setPrototype(ScriptableObject.getObjectPrototype(scope));
            }
        }
        this.activatePrototypeMap(maxPrototypeId);
        final IdFunctionObject ctor = this.prototypeValues.createPrecachedConstructor();
        if (sealed) {
            this.sealObject();
        }
        this.fillConstructorProperties(ctor);
        if (sealed) {
            ctor.sealObject();
        }
        ctor.exportAsScopeProperty();
        return ctor;
    }
    
    public final boolean hasPrototypeMap() {
        return this.prototypeValues != null;
    }
    
    public final void activatePrototypeMap(final int maxPrototypeId) {
        final PrototypeValues values = new PrototypeValues(this, maxPrototypeId);
        synchronized (this) {
            if (this.prototypeValues != null) {
                throw new IllegalStateException();
            }
            this.prototypeValues = values;
        }
    }
    
    public final IdFunctionObject initPrototypeMethod(final Object tag, final int id, final String name, final int arity) {
        return this.initPrototypeMethod(tag, id, name, name, arity);
    }
    
    public final IdFunctionObject initPrototypeMethod(final Object tag, final int id, final String propertyName, final String functionName, final int arity) {
        final Scriptable scope = ScriptableObject.getTopLevelScope(this);
        final IdFunctionObject function = this.newIdFunction(tag, id, (functionName != null) ? functionName : propertyName, arity, scope);
        this.prototypeValues.initValue(id, propertyName, function, 2);
        return function;
    }
    
    public final IdFunctionObject initPrototypeMethod(final Object tag, final int id, final Symbol key, final String functionName, final int arity) {
        final Scriptable scope = ScriptableObject.getTopLevelScope(this);
        final IdFunctionObject function = this.newIdFunction(tag, id, functionName, arity, scope);
        this.prototypeValues.initValue(id, key, function, 2);
        return function;
    }
    
    public final void initPrototypeConstructor(final IdFunctionObject f) {
        final int id = this.prototypeValues.constructorId;
        if (id == 0) {
            throw new IllegalStateException();
        }
        if (f.methodId() != id) {
            throw new IllegalArgumentException();
        }
        if (this.isSealed()) {
            f.sealObject();
        }
        this.prototypeValues.initValue(id, "constructor", f, 2);
    }
    
    public final void initPrototypeValue(final int id, final String name, final Object value, final int attributes) {
        this.prototypeValues.initValue(id, name, value, attributes);
    }
    
    public final void initPrototypeValue(final int id, final Symbol key, final Object value, final int attributes) {
        this.prototypeValues.initValue(id, key, value, attributes);
    }
    
    protected void initPrototypeId(final int id) {
        throw new IllegalStateException(String.valueOf(id));
    }
    
    protected int findPrototypeId(final String name) {
        throw new IllegalStateException(name);
    }
    
    protected int findPrototypeId(final Symbol key) {
        return 0;
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
    }
    
    protected void addCtorSpecies(final IdFunctionObject ctor) {
        final NativeObject desc = new NativeObject();
        ScriptableObject.defineProperty(desc, "configurable", true, 0);
        ScriptableObject.defineProperty(desc, "enumerable", false, 0);
        ScriptableObject.defineProperty(desc, "get", new BaseFunction() {
            public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
                return ctor;
            }
        }, 0);
        ctor.defineOwnProperty(Context.getContext(), (Object)SymbolKey.SPECIES, (ScriptableObject)desc, true);
    }
    
    protected void addIdFunctionProperty(final Scriptable obj, final Object tag, final int id, final String name, final int arity) {
        final Scriptable scope = ScriptableObject.getTopLevelScope(obj);
        final IdFunctionObject f = this.newIdFunction(tag, id, name, arity, scope);
        f.addAsProperty(obj);
    }
    
    protected static EcmaError incompatibleCallError(final IdFunctionObject f) {
        throw ScriptRuntime.typeError1("msg.incompat.call", f.getFunctionName());
    }
    
    private IdFunctionObject newIdFunction(final Object tag, final int id, final String name, final int arity, final Scriptable scope) {
        IdFunctionObject function = null;
        if (Context.getContext().getLanguageVersion() < 200) {
            function = new IdFunctionObject((IdFunctionCall)this, tag, id, name, arity, scope);
        }
        else {
            function = (IdFunctionObject)new IdFunctionObjectES6((IdFunctionCall)this, tag, id, name, arity, scope);
        }
        if (this.isSealed()) {
            function.sealObject();
        }
        return function;
    }
    
    @Override
    public void defineOwnProperty(final Context cx, final Object key, final ScriptableObject desc) {
        if (key instanceof String) {
            final String name = (String)key;
            final int info = this.findInstanceIdInfo(name);
            if (info != 0) {
                final int id = info & 0xFFFF;
                if (!this.isAccessorDescriptor(desc)) {
                    this.checkPropertyDefinition(desc);
                    this.checkObjectPropertyRestrictions(key, desc);
                    final ScriptableObject current = this.getOwnPropertyDescriptor(cx, key);
                    this.checkPropertyChange(name, current, desc);
                    final int attr = info >>> 16;
                    final Object value = ScriptableObject.getProperty(desc, "value");
                    if (value != IdScriptableObject.NOT_FOUND && ((attr & 0x4) == 0x0 || (attr & 0x1) == 0x0)) {
                        final Object currentValue = this.getInstanceIdValue(id);
                        if (!this.sameValue(value, currentValue)) {
                            this.setInstanceIdValue(id, value);
                        }
                    }
                    this.setAttributes(name, this.applyDescriptorToAttributeBitset(attr, desc));
                    return;
                }
                this.delete(id);
            }
            if (this.prototypeValues != null) {
                final int id = this.prototypeValues.findId(name);
                if (id != 0) {
                    if (!this.isAccessorDescriptor(desc)) {
                        this.checkPropertyDefinition(desc);
                        this.checkObjectPropertyRestrictions(key, desc);
                        final ScriptableObject current = this.getOwnPropertyDescriptor(cx, key);
                        this.checkPropertyChange(name, current, desc);
                        final int attr = this.prototypeValues.getAttributes(id);
                        final Object value = ScriptableObject.getProperty(desc, "value");
                        if (value != IdScriptableObject.NOT_FOUND && (attr & 0x1) == 0x0) {
                            final Object currentValue = this.prototypeValues.get(id);
                            if (!this.sameValue(value, currentValue)) {
                                this.prototypeValues.set(id, this, value);
                            }
                        }
                        this.prototypeValues.setAttributes(id, this.applyDescriptorToAttributeBitset(attr, desc));
                        if (super.has(name, this)) {
                            super.delete(name);
                        }
                        return;
                    }
                    this.prototypeValues.delete(id);
                }
            }
        }
        super.defineOwnProperty(cx, key, desc);
    }
    
    @Override
    public ScriptableObject getOwnPropertyDescriptor(final Context cx, final Object id) {
        ScriptableObject desc = super.getOwnPropertyDescriptor(cx, id);
        if (desc == null) {
            if (id instanceof String) {
                desc = this.getBuiltInDescriptor((String)id);
            }
            else if (ScriptRuntime.isSymbol(id)) {
                desc = this.getBuiltInDescriptor(((NativeSymbol)id).getKey());
            }
        }
        return desc;
    }
    
    private ScriptableObject getBuiltInDescriptor(final String name) {
        Object value = null;
        int attr = 0;
        Scriptable scope = this.getParentScope();
        if (scope == null) {
            scope = this;
        }
        final int info = this.findInstanceIdInfo(name);
        if (info != 0) {
            final int id = info & 0xFFFF;
            value = this.getInstanceIdValue(id);
            attr = info >>> 16;
            return ScriptableObject.buildDataDescriptor(scope, value, attr);
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(name);
            if (id != 0) {
                value = this.prototypeValues.get(id);
                attr = this.prototypeValues.getAttributes(id);
                return ScriptableObject.buildDataDescriptor(scope, value, attr);
            }
        }
        return null;
    }
    
    private ScriptableObject getBuiltInDescriptor(final Symbol key) {
        Object value = null;
        int attr = 0;
        Scriptable scope = this.getParentScope();
        if (scope == null) {
            scope = this;
        }
        if (this.prototypeValues != null) {
            final int id = this.prototypeValues.findId(key);
            if (id != 0) {
                value = this.prototypeValues.get(id);
                attr = this.prototypeValues.getAttributes(id);
                return ScriptableObject.buildDataDescriptor(scope, value, attr);
            }
        }
        return null;
    }
    
    private void readObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        final int maxPrototypeId = stream.readInt();
        if (maxPrototypeId != 0) {
            this.activatePrototypeMap(maxPrototypeId);
        }
    }
    
    private void writeObject(final ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        int maxPrototypeId = 0;
        if (this.prototypeValues != null) {
            maxPrototypeId = this.prototypeValues.getMaxId();
        }
        stream.writeInt(maxPrototypeId);
    }
    
    private static final class PrototypeValues implements Serializable
    {
        private static final long serialVersionUID = 3038645279153854371L;
        private static final int NAME_SLOT = 1;
        private static final int SLOT_SPAN = 2;
        private IdScriptableObject obj;
        private int maxId;
        private Object[] valueArray;
        private short[] attributeArray;
        int constructorId;
        private IdFunctionObject constructor;
        private short constructorAttrs;
        
        PrototypeValues(final IdScriptableObject obj, final int maxId) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
            if (maxId < 1) {
                throw new IllegalArgumentException();
            }
            this.obj = obj;
            this.maxId = maxId;
        }
        
        final int getMaxId() {
            return this.maxId;
        }
        
        final void initValue(final int id, final String name, final Object value, final int attributes) {
            if (1 > id || id > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (name == null) {
                throw new IllegalArgumentException();
            }
            if (value == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ScriptableObject.checkValidAttributes(attributes);
            if (this.obj.findPrototypeId(name) != id) {
                throw new IllegalArgumentException(name);
            }
            if (id != this.constructorId) {
                this.initSlot(id, name, value, attributes);
                return;
            }
            if (!(value instanceof IdFunctionObject)) {
                throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
            }
            this.constructor = (IdFunctionObject)value;
            this.constructorAttrs = (short)attributes;
        }
        
        final void initValue(final int id, final Symbol key, final Object value, final int attributes) {
            if (1 > id || id > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (key == null) {
                throw new IllegalArgumentException();
            }
            if (value == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ScriptableObject.checkValidAttributes(attributes);
            if (this.obj.findPrototypeId(key) != id) {
                throw new IllegalArgumentException(key.toString());
            }
            if (id != this.constructorId) {
                this.initSlot(id, key, value, attributes);
                return;
            }
            if (!(value instanceof IdFunctionObject)) {
                throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
            }
            this.constructor = (IdFunctionObject)value;
            this.constructorAttrs = (short)attributes;
        }
        
        private void initSlot(final int id, final Object name, Object value, final int attributes) {
            final Object[] array = this.valueArray;
            if (array == null) {
                throw new IllegalStateException();
            }
            if (value == null) {
                value = UniqueTag.NULL_VALUE;
            }
            final int index = (id - 1) * 2;
            synchronized (this) {
                final Object value2 = array[index];
                if (value2 == null) {
                    array[index] = value;
                    array[index + 1] = name;
                    this.attributeArray[id - 1] = (short)attributes;
                }
                else if (!name.equals(array[index + 1])) {
                    throw new IllegalStateException();
                }
            }
        }
        
        final IdFunctionObject createPrecachedConstructor() {
            if (this.constructorId != 0) {
                throw new IllegalStateException();
            }
            this.constructorId = this.obj.findPrototypeId("constructor");
            if (this.constructorId == 0) {
                throw new IllegalStateException("No id for constructor property");
            }
            this.obj.initPrototypeId(this.constructorId);
            if (this.constructor == null) {
                throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId() did not initialize id=" + this.constructorId);
            }
            this.constructor.initFunction(this.obj.getClassName(), ScriptableObject.getTopLevelScope(this.obj));
            this.constructor.markAsConstructor((Scriptable)this.obj);
            return this.constructor;
        }
        
        final int findId(final String name) {
            return this.obj.findPrototypeId(name);
        }
        
        final int findId(final Symbol key) {
            return this.obj.findPrototypeId(key);
        }
        
        final boolean has(final int id) {
            final Object[] array = this.valueArray;
            if (array == null) {
                return true;
            }
            final int valueSlot = (id - 1) * 2;
            final Object value = array[valueSlot];
            return value == null || value != Scriptable.NOT_FOUND;
        }
        
        final Object get(final int id) {
            Object value = this.ensureId(id);
            if (value == UniqueTag.NULL_VALUE) {
                value = null;
            }
            return value;
        }
        
        final void set(final int id, final Scriptable start, Object value) {
            if (value == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            this.ensureId(id);
            final int attr = this.attributeArray[id - 1];
            if ((attr & 0x1) == 0x0) {
                if (start == this.obj) {
                    if (value == null) {
                        value = UniqueTag.NULL_VALUE;
                    }
                    final int valueSlot = (id - 1) * 2;
                    synchronized (this) {
                        this.valueArray[valueSlot] = value;
                    }
                }
                else {
                    final int nameSlot = (id - 1) * 2 + 1;
                    final Object name = this.valueArray[nameSlot];
                    if (name instanceof Symbol) {
                        if (start instanceof SymbolScriptable) {
                            ((SymbolScriptable)start).put((Symbol)name, start, value);
                        }
                    }
                    else {
                        start.put((String)name, start, value);
                    }
                }
            }
        }
        
        final void delete(final int id) {
            this.ensureId(id);
            final int attr = this.attributeArray[id - 1];
            if ((attr & 0x4) != 0x0) {
                final Context cx = Context.getContext();
                if (cx.isStrictMode()) {
                    final int nameSlot = (id - 1) * 2 + 1;
                    final String name = (String)this.valueArray[nameSlot];
                    throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", name);
                }
            }
            else {
                final int valueSlot = (id - 1) * 2;
                synchronized (this) {
                    this.valueArray[valueSlot] = Scriptable.NOT_FOUND;
                    this.attributeArray[id - 1] = 0;
                }
            }
        }
        
        final int getAttributes(final int id) {
            this.ensureId(id);
            return this.attributeArray[id - 1];
        }
        
        final void setAttributes(final int id, final int attributes) {
            ScriptableObject.checkValidAttributes(attributes);
            this.ensureId(id);
            synchronized (this) {
                this.attributeArray[id - 1] = (short)attributes;
            }
        }
        
        final Object[] getNames(final boolean getAll, final boolean getSymbols, final Object[] extraEntries) {
            Object[] names = null;
            int count = 0;
            for (int id = 1; id <= this.maxId; ++id) {
                final Object value = this.ensureId(id);
                if ((getAll || (this.attributeArray[id - 1] & 0x2) == 0x0) && value != Scriptable.NOT_FOUND) {
                    final int nameSlot = (id - 1) * 2 + 1;
                    final Object name = this.valueArray[nameSlot];
                    if (name instanceof String) {
                        if (names == null) {
                            names = new Object[this.maxId];
                        }
                        names[count++] = name;
                    }
                    else if (getSymbols && name instanceof Symbol) {
                        if (names == null) {
                            names = new Object[this.maxId];
                        }
                        names[count++] = name.toString();
                    }
                }
            }
            if (count == 0) {
                return extraEntries;
            }
            if (extraEntries == null || extraEntries.length == 0) {
                if (count != names.length) {
                    final Object[] tmp = new Object[count];
                    System.arraycopy(names, 0, tmp, 0, count);
                    names = tmp;
                }
                return names;
            }
            final int extra = extraEntries.length;
            final Object[] tmp2 = new Object[extra + count];
            System.arraycopy(extraEntries, 0, tmp2, 0, extra);
            System.arraycopy(names, 0, tmp2, extra, count);
            return tmp2;
        }
        
        private Object ensureId(final int id) {
            Object[] array = this.valueArray;
            if (array == null) {
                synchronized (this) {
                    array = this.valueArray;
                    if (array == null) {
                        array = new Object[this.maxId * 2];
                        this.valueArray = array;
                        this.attributeArray = new short[this.maxId];
                    }
                }
            }
            final int valueSlot = (id - 1) * 2;
            Object value = array[valueSlot];
            if (value == null) {
                if (id == this.constructorId) {
                    this.initSlot(this.constructorId, "constructor", this.constructor, this.constructorAttrs);
                    this.constructor = null;
                }
                else {
                    this.obj.initPrototypeId(id);
                }
                value = array[valueSlot];
                if (value == null) {
                    throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId(int id) did not initialize id=" + id);
                }
            }
            return value;
        }
    }
}
