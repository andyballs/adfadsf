//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.debug.*;
import java.lang.annotation.*;
import org.mozilla.javascript.annotations.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;

public abstract class ScriptableObject implements Scriptable, SymbolScriptable, Serializable, DebuggableObject, ConstProperties
{
    private static final long serialVersionUID = 2829861078851942586L;
    public static final int EMPTY = 0;
    public static final int NOT_WRITABLE = 1;
    public static final int NOT_ENUMERABLE = 2;
    public static final int NOT_CONFIGURABLE = 4;
    public static final int UNINITIALIZED_CONST = 8;
    public static final int INITIALIZED_CONST = 16;
    public static final int CONST = 13;
    private Scriptable prototypeObject;
    private Scriptable parentScopeObject;
    private transient SlotMapContainer slotMap;
    private transient SlotMapContainer privateSlotMap;
    private transient ExternalArrayData externalData;
    private volatile Map<Object, Object> associatedValues;
    private boolean isExtensible;
    private boolean isSealed;
    private static final Method GET_ARRAY_LENGTH;
    private static final Comparator<Object> KEY_COMPARATOR;
    
    protected static ScriptableObject buildDataDescriptor(final Scriptable scope, final Object value, final int attributes) {
        final ScriptableObject desc = (ScriptableObject)new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(desc, scope, TopLevel.Builtins.Object);
        desc.defineProperty("value", value, 0);
        desc.defineProperty("writable", (attributes & 0x1) == 0x0, 0);
        desc.defineProperty("enumerable", (attributes & 0x2) == 0x0, 0);
        desc.defineProperty("configurable", (attributes & 0x4) == 0x0, 0);
        return desc;
    }
    
    static void checkValidAttributes(final int attributes) {
        final int mask = 31;
        if ((attributes & 0xFFFFFFE0) != 0x0) {
            throw new IllegalArgumentException(String.valueOf(attributes));
        }
    }
    
    protected SlotMapContainer createSlotMap(final int initialSize) {
        final Context cx = Context.getCurrentContext();
        if (cx != null && cx.hasFeature(16)) {
            return new ThreadSafeSlotMapContainer(initialSize);
        }
        return new SlotMapContainer(initialSize);
    }
    
    public ScriptableObject() {
        this.isExtensible = true;
        this.isSealed = false;
        this.slotMap = this.createSlotMap(0);
        this.privateSlotMap = this.createSlotMap(0);
    }
    
    public ScriptableObject(final Scriptable scope, final Scriptable prototype) {
        this.isExtensible = true;
        this.isSealed = false;
        if (scope == null) {
            throw new IllegalArgumentException();
        }
        this.parentScopeObject = scope;
        this.prototypeObject = prototype;
        this.slotMap = this.createSlotMap(0);
        this.privateSlotMap = this.createSlotMap(0);
    }
    
    public String getTypeOf() {
        return this.avoidObjectDetection() ? "undefined" : "object";
    }
    
    public abstract String getClassName();
    
    public boolean has(final String name, final Scriptable start) {
        return null != this.slotMap.query(name, 0);
    }
    
    public boolean has(final int index, final Scriptable start) {
        if (this.externalData != null) {
            return index < this.externalData.getArrayLength();
        }
        return null != this.slotMap.query(null, index);
    }
    
    public boolean has(final Symbol key, final Scriptable start) {
        return null != this.slotMap.query(key, 0);
    }
    
    public Object get(final String name, final Scriptable start, final boolean isPrivate) {
        final Slot slot = this.getSlotMap(isPrivate).query(name, 0);
        if (slot == null) {
            return Scriptable.NOT_FOUND;
        }
        return slot.getValue(start);
    }
    
    public Object get(final int index, final Scriptable start) {
        if (this.externalData != null) {
            if (index < this.externalData.getArrayLength()) {
                return this.externalData.getArrayElement(index);
            }
            return Scriptable.NOT_FOUND;
        }
        else {
            final Slot slot = this.slotMap.query(null, index);
            if (slot == null) {
                return Scriptable.NOT_FOUND;
            }
            return slot.getValue(start);
        }
    }
    
    public Object get(final Symbol key, final Scriptable start) {
        final Slot slot = this.slotMap.query(key, 0);
        if (slot == null) {
            return Scriptable.NOT_FOUND;
        }
        return slot.getValue(start);
    }
    
    public void put(final String name, final Scriptable start, final Object value, final boolean isPrivate) {
        if (this.putImpl(name, 0, start, value, isPrivate)) {
            return;
        }
        if (start == this) {
            throw Kit.codeBug();
        }
        start.put(name, start, value);
    }
    
    public void put(final int index, final Scriptable start, final Object value) {
        if (this.externalData != null) {
            if (index < this.externalData.getArrayLength()) {
                this.externalData.setArrayElement(index, value);
                return;
            }
            throw new JavaScriptException((Object)ScriptRuntime.newNativeError(Context.getCurrentContext(), (Scriptable)this, TopLevel.NativeErrors.RangeError, new Object[] { "External array index out of bounds " }), (String)null, 0);
        }
        else {
            if (this.putImpl(null, index, start, value, false)) {
                return;
            }
            if (start == this) {
                throw Kit.codeBug();
            }
            start.put(index, start, value);
        }
    }
    
    public void put(final Symbol key, final Scriptable start, final Object value) {
        if (this.putImpl(key, 0, start, value, false)) {
            return;
        }
        if (start == this) {
            throw Kit.codeBug();
        }
        ensureSymbolScriptable(start).put(key, start, value);
    }
    
    public void declare(final String name, final Scriptable start) {
        this.slotMap.createSlot(name, new Slot(name, 0, 0));
    }
    
    public void declareConst(final String name, final Scriptable start) {
        this.slotMap.createSlot(name, new Slot(name, 0, 8));
    }
    
    public void delete(final String name) {
        this.checkNotSealed(name, 0);
        this.slotMap.remove(name, 0);
    }
    
    public void delete(final int index) {
        this.checkNotSealed(null, index);
        this.slotMap.remove(null, index);
    }
    
    public void delete(final Symbol key) {
        this.checkNotSealed(key, 0);
        this.slotMap.remove(key, 0);
    }
    
    public void putConst(final String name, final Scriptable start, final Object value) {
        if (this.putConstImpl(name, 0, start, value, 1)) {
            return;
        }
        if (start == this) {
            throw Kit.codeBug();
        }
        if (start instanceof ConstProperties) {
            ((ConstProperties)start).putConst(name, start, value);
        }
        else {
            start.put(name, start, value);
        }
    }
    
    public void defineConst(final String name, final Scriptable start) {
        if (this.putConstImpl(name, 0, start, Undefined.instance, 8)) {
            return;
        }
        if (start == this) {
            throw Kit.codeBug();
        }
        if (start instanceof ConstProperties) {
            ((ConstProperties)start).defineConst(name, start);
        }
    }
    
    public boolean isConst(final String name) {
        final Slot slot = this.slotMap.query(name, 0);
        return slot != null && (slot.getAttributes() & 0x5) == 0x5;
    }
    
    @Deprecated
    public final int getAttributes(final String name, final Scriptable start) {
        return this.getAttributes(name);
    }
    
    @Deprecated
    public final int getAttributes(final int index, final Scriptable start) {
        return this.getAttributes(index);
    }
    
    @Deprecated
    public final void setAttributes(final String name, final Scriptable start, final int attributes) {
        this.setAttributes(name, attributes);
    }
    
    @Deprecated
    public void setAttributes(final int index, final Scriptable start, final int attributes) {
        this.setAttributes(index, attributes);
    }
    
    public int getAttributes(final String name) {
        return this.findAttributeSlot(name, 0, SlotAccess.QUERY, false).getAttributes();
    }
    
    public int getAttributes(final int index) {
        return this.findAttributeSlot(null, index, SlotAccess.QUERY, false).getAttributes();
    }
    
    public int getAttributes(final Symbol sym) {
        return this.findAttributeSlot(sym, SlotAccess.QUERY).getAttributes();
    }
    
    public void setAttributes(final String name, final int attributes, final boolean isPrivate) {
        this.checkNotSealed(name, 0);
        this.findAttributeSlot(name, 0, SlotAccess.MODIFY, isPrivate).setAttributes(attributes);
    }
    
    public void setAttributes(final String name, final int attributes) {
        this.setAttributes(name, attributes, false);
    }
    
    public void setAttributes(final int index, final int attributes) {
        this.checkNotSealed(null, index);
        this.findAttributeSlot(null, index, SlotAccess.MODIFY, false).setAttributes(attributes);
    }
    
    public void setAttributes(final Symbol key, final int attributes) {
        this.checkNotSealed(key, 0);
        this.findAttributeSlot(key, SlotAccess.MODIFY).setAttributes(attributes);
    }
    
    public void setGetterOrSetter(final int name, final int index, final Callable getterOrSetter, final boolean isSetter) {
        this.setGetterOrSetter(name, index, getterOrSetter, isSetter, false);
    }
    
    private void setGetterOrSetter(final int name, final int index, final Callable getterOrSetter, final boolean isSetter, final boolean force) {
        if (index != 0) {
            throw new IllegalArgumentException(String.valueOf(name));
        }
        if (!force) {
            this.checkNotSealed(name, index);
        }
        GetterSlot gslot;
        if (this.isExtensible()) {
            gslot = (GetterSlot)this.slotMap.get(name, index, SlotAccess.MODIFY_GETTER_SETTER);
        }
        else {
            final Slot slot = this.slotMap.query(name, index);
            if (!(slot instanceof GetterSlot)) {
                return;
            }
            gslot = (GetterSlot)slot;
        }
        if (!force) {
            final int attributes = gslot.getAttributes();
            if ((attributes & 0x1) != 0x0) {
                throw Context.reportRuntimeError1("msg.modify.readonly", (Object)name);
            }
        }
        if (isSetter) {
            gslot.setter = getterOrSetter;
        }
        else {
            gslot.getter = getterOrSetter;
        }
        gslot.setValue(Undefined.instance);
    }
    
    public void setGetterOrSetter(final Symbol name, final int index, final Callable getterOrSetter, final boolean isSetter) {
        this.setGetterOrSetter(name, index, getterOrSetter, isSetter, false);
    }
    
    private void setGetterOrSetter(final Symbol name, final int index, final Callable getterOrSetter, final boolean isSetter, final boolean force) {
        if (name != null && index != 0) {
            throw new IllegalArgumentException(name.toString());
        }
        if (!force) {
            this.checkNotSealed(name, index);
        }
        GetterSlot gslot;
        if (this.isExtensible()) {
            gslot = (GetterSlot)this.slotMap.get(name, index, SlotAccess.MODIFY_GETTER_SETTER);
        }
        else {
            final Slot slot = this.slotMap.query(name, index);
            if (!(slot instanceof GetterSlot)) {
                return;
            }
            gslot = (GetterSlot)slot;
        }
        if (!force) {
            final int attributes = gslot.getAttributes();
            if ((attributes & 0x1) != 0x0) {
                throw Context.reportRuntimeError1("msg.modify.readonly", (Object)name);
            }
        }
        if (isSetter) {
            gslot.setter = getterOrSetter;
        }
        else {
            gslot.getter = getterOrSetter;
        }
        gslot.setValue(Undefined.instance);
    }
    
    public void setGetterOrSetter(final String name, final int index, final Callable getterOrSetter, final boolean isSetter) {
        this.setGetterOrSetter(name, index, getterOrSetter, isSetter, false);
    }
    
    public void setGetterOrSetter(final String name, final int index, final Callable getterOrSetter, final boolean isSetter, final boolean force) {
        this.setGetterOrSetter(name, index, getterOrSetter, isSetter, force, false);
    }
    
    public void setGetterOrSetter(final String name, final int index, final Callable getterOrSetter, final boolean isSetter, final boolean force, final boolean isPrivate) {
        if (name != null && index != 0) {
            throw new IllegalArgumentException(name);
        }
        if (!force) {
            this.checkNotSealed(name, index);
        }
        final SlotMapContainer slotMap = this.getSlotMap(isPrivate);
        GetterSlot gslot;
        if (this.isExtensible()) {
            gslot = (GetterSlot)slotMap.get(name, index, SlotAccess.MODIFY_GETTER_SETTER);
        }
        else {
            final Slot slot = slotMap.query(name, index);
            if (!(slot instanceof GetterSlot)) {
                return;
            }
            gslot = (GetterSlot)slot;
        }
        if (!force) {
            final int attributes = gslot.getAttributes();
            if ((attributes & 0x1) != 0x0) {
                throw Context.reportRuntimeError1("msg.modify.readonly", (Object)name);
            }
        }
        if (isSetter) {
            gslot.setter = getterOrSetter;
        }
        else {
            gslot.getter = getterOrSetter;
        }
        gslot.setValue(Undefined.instance);
    }
    
    public Object getGetterOrSetter(final String name, final int index, final boolean isSetter, final boolean isPrivate) {
        if (name != null && index != 0) {
            throw new IllegalArgumentException(name);
        }
        final Slot slot = this.getSlotMap(isPrivate).query(name, index);
        if (slot == null) {
            return null;
        }
        if (slot instanceof GetterSlot) {
            final GetterSlot gslot = (GetterSlot)slot;
            final Object result = isSetter ? gslot.setter : gslot.getter;
            return (result != null) ? result : Undefined.instance;
        }
        return Undefined.instance;
    }
    
    public Object getGetterOrSetter(final String name, final int index, final boolean isSetter) {
        return this.getGetterOrSetter(name, index, isSetter, false);
    }
    
    public Object getGetterOrSetter(final Symbol key, final int index, final boolean isSetter) {
        if (key != null && index != 0) {
            throw new IllegalArgumentException(ScriptRuntime.toString(key));
        }
        final Slot slot = this.slotMap.query(key, index);
        if (slot == null) {
            return null;
        }
        if (slot instanceof GetterSlot) {
            final GetterSlot gslot = (GetterSlot)slot;
            final Object result = isSetter ? gslot.setter : gslot.getter;
            return (result != null) ? result : Undefined.instance;
        }
        return Undefined.instance;
    }
    
    protected boolean isGetterOrSetter(final String name, final int index, final boolean setter) {
        final Slot slot = this.slotMap.query(name, index);
        return slot instanceof GetterSlot && ((setter && ((GetterSlot)slot).setter != null) || (!setter && ((GetterSlot)slot).getter != null));
    }
    
    void addLazilyInitializedValue(final String name, final int index, final LazilyLoadedCtor init, final int attributes) {
        if (name != null && index != 0) {
            throw new IllegalArgumentException(name);
        }
        this.checkNotSealed(name, index);
        final GetterSlot gslot = (GetterSlot)this.slotMap.get(name, index, SlotAccess.MODIFY_GETTER_SETTER);
        gslot.setAttributes(attributes);
        gslot.getter = null;
        gslot.setter = null;
        gslot.setValue(init);
    }
    
    public void setExternalArrayData(final ExternalArrayData array) {
        this.externalData = array;
        if (array == null) {
            this.delete("length");
        }
        else {
            this.defineProperty("length", null, ScriptableObject.GET_ARRAY_LENGTH, null, 3);
        }
    }
    
    public ExternalArrayData getExternalArrayData() {
        return this.externalData;
    }
    
    public Object getExternalArrayLength() {
        return (this.externalData == null) ? 0 : this.externalData.getArrayLength();
    }
    
    public Scriptable getPrototype() {
        return this.prototypeObject;
    }
    
    public void setPrototype(final Scriptable m) {
        this.prototypeObject = m;
    }
    
    public Scriptable getParentScope() {
        return this.parentScopeObject;
    }
    
    public void setParentScope(final Scriptable m) {
        this.parentScopeObject = m;
    }
    
    public Object[] getIds() {
        return this.getIds(false, false);
    }
    
    public Object[] getAllIds() {
        return this.getIds(true, false);
    }
    
    public Object getDefaultValue(final Class<?> typeHint) {
        return getDefaultValue((Scriptable)this, typeHint);
    }
    
    public static Object getDefaultValue(final Scriptable object, final Class<?> typeHint) {
        Context cx = null;
        if (hasProperty(object, SymbolKey.TO_PRIMITIVE)) {
            final Object toPrimitive = getProperty(object, SymbolKey.TO_PRIMITIVE);
            String hint = "default";
            if (typeHint == String.class) {
                hint = "string";
            }
            else if (typeHint == Number.class) {
                hint = "number";
            }
            if (toPrimitive instanceof Callable) {
                final Context _cx = Context.getContext();
                return ((Callable)toPrimitive).call(_cx, _cx.topCallScope, object, new Object[] { hint });
            }
        }
        for (int i = 0; i < 2; ++i) {
            boolean tryToString;
            if (typeHint == ScriptRuntime.StringClass) {
                tryToString = (i == 0);
            }
            else {
                tryToString = (i == 1);
            }
            String methodName;
            if (tryToString) {
                methodName = "toString";
            }
            else {
                methodName = "valueOf";
            }
            Object v = getProperty(object, methodName);
            if (v instanceof Function) {
                final Function fun = (Function)v;
                if (cx == null) {
                    cx = Context.getContext();
                }
                v = fun.call(cx, fun.getParentScope(), object, ScriptRuntime.emptyArgs);
                if (v != null) {
                    if (ScriptRuntime.isSymbol(v)) {
                        return v;
                    }
                    if (!(v instanceof Scriptable)) {
                        return v;
                    }
                    if (typeHint == ScriptRuntime.ScriptableClass || typeHint == ScriptRuntime.FunctionClass) {
                        return v;
                    }
                    if (tryToString && v instanceof Wrapper) {
                        final Object u = ((Wrapper)v).unwrap();
                        if (u instanceof String) {
                            return u;
                        }
                    }
                }
            }
        }
        final String arg = (typeHint == null) ? "undefined" : typeHint.getName();
        throw ScriptRuntime.typeError1("msg.default.value", arg);
    }
    
    public boolean hasInstance(final Scriptable instance) {
        return ScriptRuntime.jsDelegatesTo(instance, (Scriptable)this);
    }
    
    public boolean avoidObjectDetection() {
        return false;
    }
    
    protected Object equivalentValues(final Object value) {
        return (this == value) ? Boolean.TRUE : Scriptable.NOT_FOUND;
    }
    
    public static <T extends Scriptable> void defineClass(final Scriptable scope, final Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        defineClass(scope, clazz, false, false);
    }
    
    public static <T extends Scriptable> void defineClass(final Scriptable scope, final Class<T> clazz, final boolean sealed) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        defineClass(scope, clazz, sealed, false);
    }
    
    public static <T extends Scriptable> String defineClass(final Scriptable scope, final Class<T> clazz, final boolean sealed, final boolean mapInheritance) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final BaseFunction ctor = buildClassCtor(scope, clazz, sealed, mapInheritance);
        if (ctor == null) {
            return null;
        }
        final String name = ctor.getClassPrototype().getClassName();
        defineProperty(scope, name, ctor, 2);
        return name;
    }
    
    static <T extends Scriptable> BaseFunction buildClassCtor(final Scriptable scope, final Class<T> clazz, final boolean sealed, final boolean mapInheritance) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Method[] methods = FunctionObject.getMethodList((Class)clazz);
        for (int i = 0; i < methods.length; ++i) {
            final Method method = methods[i];
            if (method.getName().equals("init")) {
                final Class<?>[] parmTypes = method.getParameterTypes();
                if (parmTypes.length == 3 && parmTypes[0] == ScriptRuntime.ContextClass && parmTypes[1] == ScriptRuntime.ScriptableClass && parmTypes[2] == Boolean.TYPE && Modifier.isStatic(method.getModifiers())) {
                    final Object[] args = { Context.getContext(), scope, sealed ? Boolean.TRUE : Boolean.FALSE };
                    method.invoke(null, args);
                    return null;
                }
                if (parmTypes.length == 1 && parmTypes[0] == ScriptRuntime.ScriptableClass && Modifier.isStatic(method.getModifiers())) {
                    final Object[] args = { scope };
                    method.invoke(null, args);
                    return null;
                }
            }
        }
        final Constructor<?>[] ctors = clazz.getConstructors();
        Constructor<?> protoCtor = null;
        for (int j = 0; j < ctors.length; ++j) {
            if (ctors[j].getParameterTypes().length == 0) {
                protoCtor = ctors[j];
                break;
            }
        }
        if (protoCtor == null) {
            throw Context.reportRuntimeError1("msg.zero.arg.ctor", (Object)clazz.getName());
        }
        final Scriptable proto = (Scriptable)protoCtor.newInstance(ScriptRuntime.emptyArgs);
        final String className = proto.getClassName();
        final Object existing = getProperty(getTopLevelScope(scope), className);
        if (existing instanceof BaseFunction) {
            final Object existingProto = ((BaseFunction)existing).getPrototypeProperty();
            if (existingProto != null && clazz.equals(existingProto.getClass())) {
                return (BaseFunction)existing;
            }
        }
        Scriptable superProto = null;
        if (mapInheritance) {
            final Class<? super T> superClass = clazz.getSuperclass();
            if (ScriptRuntime.ScriptableClass.isAssignableFrom(superClass) && !Modifier.isAbstract(superClass.getModifiers())) {
                final Class<? extends Scriptable> superScriptable = extendsScriptable(superClass);
                final String name = defineClass(scope, superScriptable, sealed, mapInheritance);
                if (name != null) {
                    superProto = getClassPrototype(scope, name);
                }
            }
        }
        if (superProto == null) {
            superProto = getObjectPrototype(scope);
        }
        proto.setPrototype(superProto);
        final String functionPrefix = "jsFunction_";
        final String staticFunctionPrefix = "jsStaticFunction_";
        final String getterPrefix = "jsGet_";
        final String setterPrefix = "jsSet_";
        final String ctorName = "jsConstructor";
        Member ctorMember = findAnnotatedMember(methods, (Class<? extends Annotation>)JSConstructor.class);
        if (ctorMember == null) {
            ctorMember = findAnnotatedMember(ctors, (Class<? extends Annotation>)JSConstructor.class);
        }
        if (ctorMember == null) {
            ctorMember = FunctionObject.findSingleMethod(methods, "jsConstructor");
        }
        if (ctorMember == null) {
            if (ctors.length == 1) {
                ctorMember = ctors[0];
            }
            else if (ctors.length == 2) {
                if (ctors[0].getParameterTypes().length == 0) {
                    ctorMember = ctors[1];
                }
                else if (ctors[1].getParameterTypes().length == 0) {
                    ctorMember = ctors[0];
                }
            }
            if (ctorMember == null) {
                throw Context.reportRuntimeError1("msg.ctor.multiple.parms", (Object)clazz.getName());
            }
        }
        final FunctionObject ctor = new FunctionObject(className, ctorMember, scope);
        if (ctor.isVarArgsMethod()) {
            throw Context.reportRuntimeError1("msg.varargs.ctor", (Object)ctorMember.getName());
        }
        ctor.initAsConstructor(scope, proto);
        Method finishInit = null;
        final HashSet<String> staticNames = new HashSet<String>();
        final HashSet<String> instanceNames = new HashSet<String>();
        for (final Method method2 : methods) {
            Label_1187: {
                if (method2 != ctorMember) {
                    String name2 = method2.getName();
                    if (name2.equals("finishInit")) {
                        final Class<?>[] parmTypes2 = method2.getParameterTypes();
                        if (parmTypes2.length == 3 && parmTypes2[0] == ScriptRuntime.ScriptableClass && parmTypes2[1] == FunctionObject.class && parmTypes2[2] == ScriptRuntime.ScriptableClass && Modifier.isStatic(method2.getModifiers())) {
                            finishInit = method2;
                            break Label_1187;
                        }
                    }
                    if (name2.indexOf(36) == -1) {
                        if (!name2.equals("jsConstructor")) {
                            Annotation annotation = null;
                            String prefix = null;
                            if (method2.isAnnotationPresent((Class<? extends Annotation>)JSFunction.class)) {
                                annotation = method2.getAnnotation((Class<Annotation>)JSFunction.class);
                            }
                            else if (method2.isAnnotationPresent((Class<? extends Annotation>)JSStaticFunction.class)) {
                                annotation = method2.getAnnotation((Class<Annotation>)JSStaticFunction.class);
                            }
                            else if (method2.isAnnotationPresent((Class<? extends Annotation>)JSGetter.class)) {
                                annotation = method2.getAnnotation((Class<Annotation>)JSGetter.class);
                            }
                            else if (method2.isAnnotationPresent((Class<? extends Annotation>)JSSetter.class)) {
                                break Label_1187;
                            }
                            if (annotation == null) {
                                if (name2.startsWith("jsFunction_")) {
                                    prefix = "jsFunction_";
                                }
                                else if (name2.startsWith("jsStaticFunction_")) {
                                    prefix = "jsStaticFunction_";
                                }
                                else {
                                    if (!name2.startsWith("jsGet_")) {
                                        break Label_1187;
                                    }
                                    prefix = "jsGet_";
                                }
                            }
                            final boolean isStatic = annotation instanceof JSStaticFunction || prefix == "jsStaticFunction_";
                            final HashSet<String> names = isStatic ? staticNames : instanceNames;
                            final String propName = getPropertyName(name2, prefix, annotation);
                            if (names.contains(propName)) {
                                throw Context.reportRuntimeError2("duplicate.defineClass.name", (Object)name2, (Object)propName);
                            }
                            names.add(propName);
                            name2 = propName;
                            if (annotation instanceof JSGetter || prefix.equals("jsGet_")) {
                                if (!(proto instanceof ScriptableObject)) {
                                    throw Context.reportRuntimeError3("msg.extend.scriptable", (Object)proto.getClass().toString(), (Object)"define", (Object)name2);
                                }
                                final Method setter = findSetterMethod(methods, name2, "jsSet_");
                                final int attr = 0x6 | ((setter == null) ? 1 : 0);
                                ((ScriptableObject)proto).defineProperty(name2, null, method2, setter, attr);
                            }
                            else {
                                if (isStatic && !Modifier.isStatic(method2.getModifiers())) {
                                    throw Context.reportRuntimeError("jsStaticFunction must be used with static method.");
                                }
                                final FunctionObject f = new FunctionObject(name2, (Member)method2, proto);
                                if (f.isVarArgsConstructor()) {
                                    throw Context.reportRuntimeError1("msg.varargs.fun", (Object)ctorMember.getName());
                                }
                                defineProperty((Scriptable)(isStatic ? ctor : proto), name2, f, 2);
                                if (sealed) {
                                    f.sealObject();
                                }
                            }
                        }
                    }
                }
            }
        }
        if (finishInit != null) {
            final Object[] finishArgs = { scope, ctor, proto };
            finishInit.invoke(null, finishArgs);
        }
        if (sealed) {
            ctor.sealObject();
            if (proto instanceof ScriptableObject) {
                ((ScriptableObject)proto).sealObject();
            }
        }
        return (BaseFunction)ctor;
    }
    
    private static Member findAnnotatedMember(final AccessibleObject[] members, final Class<? extends Annotation> annotation) {
        for (final AccessibleObject member : members) {
            if (member.isAnnotationPresent(annotation)) {
                return (Member)member;
            }
        }
        return null;
    }
    
    private static Method findSetterMethod(final Method[] methods, final String name, final String prefix) {
        final String newStyleName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
        for (final Method method : methods) {
            final JSSetter annotation = method.getAnnotation(JSSetter.class);
            if (annotation != null && (name.equals(annotation.value()) || ("".equals(annotation.value()) && newStyleName.equals(method.getName())))) {
                return method;
            }
        }
        final String oldStyleName = prefix + name;
        for (final Method method2 : methods) {
            if (oldStyleName.equals(method2.getName())) {
                return method2;
            }
        }
        return null;
    }
    
    private static String getPropertyName(final String methodName, final String prefix, final Annotation annotation) {
        if (prefix != null) {
            return methodName.substring(prefix.length());
        }
        String propName = null;
        if (annotation instanceof JSGetter) {
            propName = ((JSGetter)annotation).value();
            if ((propName == null || propName.length() == 0) && methodName.length() > 3 && methodName.startsWith("get")) {
                propName = methodName.substring(3);
                if (Character.isUpperCase(propName.charAt(0))) {
                    if (propName.length() == 1) {
                        propName = propName.toLowerCase();
                    }
                    else if (!Character.isUpperCase(propName.charAt(1))) {
                        propName = Character.toLowerCase(propName.charAt(0)) + propName.substring(1);
                    }
                }
            }
        }
        else if (annotation instanceof JSFunction) {
            propName = ((JSFunction)annotation).value();
        }
        else if (annotation instanceof JSStaticFunction) {
            propName = ((JSStaticFunction)annotation).value();
        }
        if (propName == null || propName.length() == 0) {
            propName = methodName;
        }
        return propName;
    }
    
    private static <T extends Scriptable> Class<T> extendsScriptable(final Class<?> c) {
        if (ScriptRuntime.ScriptableClass.isAssignableFrom(c)) {
            return (Class<T>)c;
        }
        return null;
    }
    
    public void defineProperty(final String propertyName, final Object value, final int attributes) {
        this.checkNotSealed(propertyName, 0);
        this.put(propertyName, (Scriptable)this, value);
        this.setAttributes(propertyName, attributes);
    }
    
    public void defineProperty(final int propertyIndex, final Object value, final int attributes) {
        this.checkNotSealed(propertyIndex, 0);
        this.put(propertyIndex, (Scriptable)this, value);
        this.setAttributes(propertyIndex, attributes);
    }
    
    public void defineProperty(final Symbol key, final Object value, final int attributes) {
        this.checkNotSealed(key, 0);
        this.put(key, (Scriptable)this, value);
        this.setAttributes(key, attributes);
    }
    
    public static void defineProperty(final Scriptable destination, final String propertyName, final Object value, final int attributes) {
        if (!(destination instanceof ScriptableObject)) {
            destination.put(propertyName, destination, value);
            return;
        }
        final ScriptableObject so = (ScriptableObject)destination;
        so.defineProperty(propertyName, value, attributes);
    }
    
    public static void defineProperty(final Scriptable destination, final int propertyIndex, final Object value, final int attributes) {
        if (!(destination instanceof ScriptableObject)) {
            destination.put(propertyIndex, destination, value);
            return;
        }
        final ScriptableObject so = (ScriptableObject)destination;
        so.defineProperty(propertyIndex, value, attributes);
    }
    
    public static void defineConstProperty(final Scriptable destination, final String propertyName) {
        if (destination instanceof ConstProperties) {
            final ConstProperties cp = (ConstProperties)destination;
            cp.defineConst(propertyName, destination);
        }
        else {
            defineProperty(destination, propertyName, Undefined.instance, 13);
        }
    }
    
    public void defineProperty(final String propertyName, final Class<?> clazz, int attributes) {
        final int length = propertyName.length();
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        final char[] buf = new char[3 + length];
        propertyName.getChars(0, length, buf, 3);
        buf[3] = Character.toUpperCase(buf[3]);
        buf[0] = 'g';
        buf[1] = 'e';
        buf[2] = 't';
        final String getterName = new String(buf);
        buf[0] = 's';
        final String setterName = new String(buf);
        final Method[] methods = FunctionObject.getMethodList((Class)clazz);
        final Method getter = FunctionObject.findSingleMethod(methods, getterName);
        final Method setter = FunctionObject.findSingleMethod(methods, setterName);
        if (setter == null) {
            attributes |= 0x1;
        }
        this.defineProperty(propertyName, null, getter, setter, attributes);
    }
    
    public void defineProperty(final String propertyName, final Object delegateTo, final Method getter, final Method setter, final int attributes) {
        MemberBox getterBox = null;
        if (getter != null) {
            getterBox = new MemberBox(getter);
            boolean delegatedForm;
            if (!Modifier.isStatic(getter.getModifiers())) {
                delegatedForm = (delegateTo != null);
                getterBox.delegateTo = delegateTo;
            }
            else {
                delegatedForm = true;
                getterBox.delegateTo = Void.TYPE;
            }
            String errorId = null;
            final Class<?>[] parmTypes = getter.getParameterTypes();
            if (parmTypes.length == 0) {
                if (delegatedForm) {
                    errorId = "msg.obj.getter.parms";
                }
            }
            else if (parmTypes.length == 1) {
                final Object argType = parmTypes[0];
                if (argType != ScriptRuntime.ScriptableClass && argType != ScriptRuntime.ScriptableObjectClass) {
                    errorId = "msg.bad.getter.parms";
                }
                else if (!delegatedForm) {
                    errorId = "msg.bad.getter.parms";
                }
            }
            else {
                errorId = "msg.bad.getter.parms";
            }
            if (errorId != null) {
                throw Context.reportRuntimeError1(errorId, (Object)getter.toString());
            }
        }
        MemberBox setterBox = null;
        if (setter != null) {
            if (setter.getReturnType() != Void.TYPE) {
                throw Context.reportRuntimeError1("msg.setter.return", (Object)setter.toString());
            }
            setterBox = new MemberBox(setter);
            boolean delegatedForm2;
            if (!Modifier.isStatic(setter.getModifiers())) {
                delegatedForm2 = (delegateTo != null);
                setterBox.delegateTo = delegateTo;
            }
            else {
                delegatedForm2 = true;
                setterBox.delegateTo = Void.TYPE;
            }
            String errorId2 = null;
            final Class<?>[] parmTypes2 = setter.getParameterTypes();
            if (parmTypes2.length == 1) {
                if (delegatedForm2) {
                    errorId2 = "msg.setter2.expected";
                }
            }
            else if (parmTypes2.length == 2) {
                final Object argType2 = parmTypes2[0];
                if (argType2 != ScriptRuntime.ScriptableClass && argType2 != ScriptRuntime.ScriptableObjectClass) {
                    errorId2 = "msg.setter2.parms";
                }
                else if (!delegatedForm2) {
                    errorId2 = "msg.setter1.parms";
                }
            }
            else {
                errorId2 = "msg.setter.parms";
            }
            if (errorId2 != null) {
                throw Context.reportRuntimeError1(errorId2, (Object)setter.toString());
            }
        }
        final GetterSlot gslot = (GetterSlot)this.slotMap.get(propertyName, 0, SlotAccess.MODIFY_GETTER_SETTER);
        gslot.setAttributes(attributes);
        gslot.getter = getterBox;
        gslot.setter = setterBox;
    }
    
    public void defineOwnProperties(final Context cx, final ScriptableObject props) {
        final Object[] ids = props.getIds(false, false);
        final ScriptableObject[] descs = new ScriptableObject[ids.length];
        for (int i = 0, len = ids.length; i < len; ++i) {
            final Object descObj = ScriptRuntime.getObjectElem((Scriptable)props, ids[i], cx);
            final ScriptableObject desc = ensureScriptableObject(descObj);
            this.checkPropertyDefinition(desc);
            this.checkObjectPropertyRestrictions(ids[i], desc);
            descs[i] = desc;
        }
        for (int i = 0, len = ids.length; i < len; ++i) {
            this.defineOwnProperty(cx, ids[i], descs[i]);
        }
    }
    
    public void defineOwnProperty(final Context cx, final Object id, final ScriptableObject desc) {
        this.checkPropertyDefinition(desc);
        this.checkObjectPropertyRestrictions(id, desc);
        this.defineOwnProperty(cx, id, desc, true);
    }
    
    protected void defineOwnProperty(final Context cx, final Object id, final ScriptableObject desc, final boolean checkValid) {
        Slot slot = this.getSlot(cx, id, SlotAccess.QUERY);
        final boolean isNew = slot == null;
        if (checkValid) {
            final ScriptableObject current = (slot == null) ? null : slot.getPropertyDescriptor(cx, (Scriptable)this);
            this.checkPropertyChange(id, current, desc);
        }
        final boolean isAccessor = this.isAccessorDescriptor(desc);
        int attributes;
        if (slot == null) {
            slot = this.getSlot(cx, id, isAccessor ? SlotAccess.MODIFY_GETTER_SETTER : SlotAccess.MODIFY);
            attributes = this.applyDescriptorToAttributeBitset(7, desc);
        }
        else {
            attributes = this.applyDescriptorToAttributeBitset(slot.getAttributes(), desc);
        }
        if (isAccessor) {
            if (!(slot instanceof GetterSlot)) {
                slot = this.getSlot(cx, id, SlotAccess.MODIFY_GETTER_SETTER);
            }
            final GetterSlot gslot = (GetterSlot)slot;
            final Object getter = getProperty((Scriptable)desc, "get");
            if (getter != ScriptableObject.NOT_FOUND) {
                gslot.getter = getter;
            }
            final Object setter = getProperty((Scriptable)desc, "set");
            if (setter != ScriptableObject.NOT_FOUND) {
                gslot.setter = setter;
            }
            gslot.setValue(Undefined.instance);
            gslot.setAttributes(attributes);
        }
        else {
            if (slot instanceof GetterSlot && this.isDataDescriptor(desc)) {
                slot = this.getSlot(cx, id, SlotAccess.CONVERT_ACCESSOR_TO_DATA);
            }
            final Object value = getProperty((Scriptable)desc, "value");
            if (value != ScriptableObject.NOT_FOUND) {
                slot.setValue(value);
            }
            else if (isNew) {
                slot.setValue(Undefined.instance);
            }
            slot.setAttributes(attributes);
        }
    }
    
    protected void checkPropertyDefinition(final ScriptableObject desc) {
        final Object getter = getProperty((Scriptable)desc, "get");
        if (getter != ScriptableObject.NOT_FOUND && getter != Undefined.instance && !(getter instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(getter);
        }
        final Object setter = getProperty((Scriptable)desc, "set");
        if (setter != ScriptableObject.NOT_FOUND && setter != Undefined.instance && !(setter instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(setter);
        }
        if (this.isDataDescriptor(desc) && this.isAccessorDescriptor(desc)) {
            throw ScriptRuntime.typeError0("msg.both.data.and.accessor.desc");
        }
    }
    
    protected void checkObjectPropertyRestrictions(final Object id, final ScriptableObject desc) {
    }
    
    protected void checkPropertyChange(final Object id, final ScriptableObject current, final ScriptableObject desc) {
        if (current == null) {
            if (!this.isExtensible()) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
        }
        else if (isFalse(current.get("configurable", (Scriptable)current))) {
            if (isTrue(getProperty((Scriptable)desc, "configurable"))) {
                throw ScriptRuntime.typeError1("msg.change.configurable.false.to.true", id);
            }
            if (isTrue(current.get("enumerable", (Scriptable)current)) != isTrue(getProperty((Scriptable)desc, "enumerable"))) {
                throw ScriptRuntime.typeError1("msg.change.enumerable.with.configurable.false", id);
            }
            final boolean isData = this.isDataDescriptor(desc);
            final boolean isAccessor = this.isAccessorDescriptor(desc);
            if (isData || isAccessor) {
                if (isData && this.isDataDescriptor(current)) {
                    if (isFalse(current.get("writable", (Scriptable)current))) {
                        if (isTrue(getProperty((Scriptable)desc, "writable"))) {
                            throw ScriptRuntime.typeError1("msg.change.writable.false.to.true.with.configurable.false", id);
                        }
                        if (!this.sameValue(getProperty((Scriptable)desc, "value"), current.get("value", (Scriptable)current))) {
                            throw ScriptRuntime.typeError1("msg.change.value.with.writable.false", id);
                        }
                    }
                }
                else if (isAccessor && this.isAccessorDescriptor(current)) {
                    if (!this.sameValue(getProperty((Scriptable)desc, "set"), current.get("set", (Scriptable)current))) {
                        throw ScriptRuntime.typeError1("msg.change.setter.with.configurable.false", id);
                    }
                    if (!this.sameValue(getProperty((Scriptable)desc, "get"), current.get("get", (Scriptable)current))) {
                        throw ScriptRuntime.typeError1("msg.change.getter.with.configurable.false", id);
                    }
                }
                else {
                    if (this.isDataDescriptor(current)) {
                        throw ScriptRuntime.typeError1("msg.change.property.data.to.accessor.with.configurable.false", id);
                    }
                    throw ScriptRuntime.typeError1("msg.change.property.accessor.to.data.with.configurable.false", id);
                }
            }
        }
    }
    
    protected static boolean isTrue(final Object value) {
        return value != ScriptableObject.NOT_FOUND && ScriptRuntime.toBoolean(value);
    }
    
    protected static boolean isFalse(final Object value) {
        return !isTrue(value);
    }
    
    protected boolean sameValue(final Object newValue, Object currentValue) {
        if (newValue == ScriptableObject.NOT_FOUND) {
            return true;
        }
        if (currentValue == ScriptableObject.NOT_FOUND) {
            currentValue = Undefined.instance;
        }
        if (currentValue instanceof Number && newValue instanceof Number) {
            final double d1 = ((Number)currentValue).doubleValue();
            final double d2 = ((Number)newValue).doubleValue();
            if (Double.isNaN(d1) && Double.isNaN(d2)) {
                return true;
            }
            if (d1 == 0.0 && Double.doubleToLongBits(d1) != Double.doubleToLongBits(d2)) {
                return false;
            }
        }
        return ScriptRuntime.shallowEq(currentValue, newValue);
    }
    
    protected int applyDescriptorToAttributeBitset(int attributes, final ScriptableObject desc) {
        final Object enumerable = getProperty((Scriptable)desc, "enumerable");
        if (enumerable != ScriptableObject.NOT_FOUND) {
            attributes = (ScriptRuntime.toBoolean(enumerable) ? (attributes & 0xFFFFFFFD) : (attributes | 0x2));
        }
        final Object writable = getProperty((Scriptable)desc, "writable");
        if (writable != ScriptableObject.NOT_FOUND) {
            attributes = (ScriptRuntime.toBoolean(writable) ? (attributes & 0xFFFFFFFE) : (attributes | 0x1));
        }
        final Object configurable = getProperty((Scriptable)desc, "configurable");
        if (configurable != ScriptableObject.NOT_FOUND) {
            attributes = (ScriptRuntime.toBoolean(configurable) ? (attributes & 0xFFFFFFFB) : (attributes | 0x4));
        }
        return attributes;
    }
    
    boolean isDataDescriptor(final ScriptableObject desc) {
        return hasProperty((Scriptable)desc, "value") || hasProperty((Scriptable)desc, "writable");
    }
    
    protected boolean isAccessorDescriptor(final ScriptableObject desc) {
        return hasProperty((Scriptable)desc, "get") || hasProperty((Scriptable)desc, "set");
    }
    
    protected boolean isGenericDescriptor(final ScriptableObject desc) {
        return !this.isDataDescriptor(desc) && !this.isAccessorDescriptor(desc);
    }
    
    protected static Scriptable ensureScriptable(final Object arg) {
        if (!(arg instanceof Scriptable)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(arg));
        }
        return (Scriptable)arg;
    }
    
    protected static SymbolScriptable ensureSymbolScriptable(final Object arg) {
        if (!(arg instanceof SymbolScriptable)) {
            throw ScriptRuntime.typeError1("msg.object.not.symbolscriptable", ScriptRuntime.typeof(arg, false));
        }
        return (SymbolScriptable)arg;
    }
    
    protected static ScriptableObject ensureScriptableObject(final Object arg) {
        if (!(arg instanceof ScriptableObject)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(arg));
        }
        return (ScriptableObject)arg;
    }
    
    public void defineFunctionProperties(final String[] names, final Class<?> clazz, final int attributes) {
        final Method[] methods = FunctionObject.getMethodList((Class)clazz);
        for (int i = 0; i < names.length; ++i) {
            final String name = names[i];
            final Method m = FunctionObject.findSingleMethod(methods, name);
            if (m == null) {
                throw Context.reportRuntimeError2("msg.method.not.found", (Object)name, (Object)clazz.getName());
            }
            final FunctionObject f = new FunctionObject(name, (Member)m, (Scriptable)this);
            this.defineProperty(name, f, attributes);
        }
    }
    
    public static Scriptable getObjectPrototype(final Scriptable scope) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scope), TopLevel.Builtins.Object);
    }
    
    public static Scriptable getFunctionPrototype(final Scriptable scope) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scope), TopLevel.Builtins.Function);
    }
    
    public static Scriptable getArrayPrototype(final Scriptable scope) {
        return TopLevel.getBuiltinPrototype(getTopLevelScope(scope), TopLevel.Builtins.Array);
    }
    
    public static Scriptable getClassPrototype(Scriptable scope, final String className) {
        scope = getTopLevelScope(scope);
        final Object ctor = getProperty(scope, className);
        Object proto;
        if (ctor instanceof BaseFunction) {
            proto = ((BaseFunction)ctor).getPrototypeProperty();
        }
        else {
            if (!(ctor instanceof Scriptable)) {
                return null;
            }
            final Scriptable ctorObj = (Scriptable)ctor;
            proto = ctorObj.get("prototype", ctorObj);
        }
        if (proto instanceof Scriptable) {
            return (Scriptable)proto;
        }
        return null;
    }
    
    public static Scriptable getTopLevelScope(Scriptable obj) {
        while (true) {
            final Scriptable parent = obj.getParentScope();
            if (parent == null) {
                break;
            }
            obj = parent;
        }
        return obj;
    }
    
    public boolean isExtensible() {
        return this.isExtensible;
    }
    
    public void preventExtensions() {
        this.isExtensible = false;
    }
    
    public void sealObject() {
        if (!this.isSealed) {
            final long stamp = this.slotMap.readLock();
            try {
                for (final Slot slot : this.slotMap) {
                    final Object value = slot.value;
                    if (value instanceof LazilyLoadedCtor) {
                        final LazilyLoadedCtor initializer = (LazilyLoadedCtor)value;
                        try {
                            initializer.init();
                        }
                        finally {
                            slot.setValue(initializer.getValue());
                        }
                    }
                }
                this.isSealed = true;
            }
            finally {
                this.slotMap.unlockRead(stamp);
            }
        }
    }
    
    public final boolean isSealed() {
        return this.isSealed;
    }
    
    private void checkNotSealed(final Object key, final int index) {
        if (!this.isSealed()) {
            return;
        }
        final String str = (key != null) ? key.toString() : Integer.toString(index);
        throw Context.reportRuntimeError1("msg.modify.sealed", (Object)str);
    }
    
    public static Object getProperty(final Object obj, final Object key) {
        final Scriptable scriptable = ensureScriptable(obj);
        if (key instanceof String) {
            return getProperty(scriptable, (String)key);
        }
        if (key instanceof Integer) {
            return getProperty(scriptable, (int)key);
        }
        if (key instanceof Symbol) {
            return getProperty(scriptable, (Symbol)key);
        }
        throw Kit.codeBug();
    }
    
    public static Object getProperty(Scriptable obj, final String name) {
        final Scriptable start = obj;
        Object result;
        do {
            result = obj.get(name, start);
            if (result != Scriptable.NOT_FOUND) {
                break;
            }
            obj = obj.getPrototype();
        } while (obj != null);
        return result;
    }
    
    public static Object getProperty(final Scriptable obj, final String name, final boolean isPrivate) {
        if (isPrivate) {
            return obj.get(name, obj, true);
        }
        return getProperty(obj, name);
    }
    
    public static Object getProperty(Scriptable obj, final Symbol key) {
        final Scriptable start = obj;
        Object result;
        do {
            result = ensureSymbolScriptable(obj).get(key, start);
            if (result != Scriptable.NOT_FOUND) {
                break;
            }
            obj = obj.getPrototype();
        } while (obj != null);
        return result;
    }
    
    public static Object getProperty(Scriptable obj, final int index) {
        final Scriptable start = obj;
        Object result;
        do {
            result = obj.get(index, start);
            if (result != Scriptable.NOT_FOUND) {
                break;
            }
            obj = obj.getPrototype();
        } while (obj != null);
        return result;
    }
    
    public static <T> T getTypedProperty(final Scriptable s, final int index, final Class<T> type) {
        Object val = getProperty(s, index);
        if (val == Scriptable.NOT_FOUND) {
            val = null;
        }
        return type.cast(Context.jsToJava(val, (Class)type));
    }
    
    public static <T> T getTypedProperty(final Scriptable s, final String name, final Class<T> type) {
        Object val = getProperty(s, name);
        if (val == Scriptable.NOT_FOUND) {
            val = null;
        }
        return type.cast(Context.jsToJava(val, (Class)type));
    }
    
    public static boolean hasProperty(final Scriptable obj, final String name) {
        return null != getBase(obj, name);
    }
    
    public static boolean hasProperty(final Scriptable obj, final int index) {
        return null != getBase(obj, index);
    }
    
    public static boolean hasProperty(final Scriptable obj, final Symbol key) {
        return null != getBase(obj, key);
    }
    
    public static boolean hasProperty(final Object obj, final Object key) {
        final Scriptable scriptable = ensureScriptable(obj);
        if (key instanceof String) {
            return hasProperty(scriptable, (String)key);
        }
        if (key instanceof Symbol) {
            return hasProperty(scriptable, (Symbol)key);
        }
        if (key instanceof Integer) {
            return hasProperty(scriptable, (int)key);
        }
        throw Kit.codeBug();
    }
    
    public static void redefineProperty(final Scriptable obj, final String name, final boolean isConst) {
        final Scriptable base = getBase(obj, name);
        if (base == null) {
            return;
        }
        if (base instanceof ConstProperties) {
            final ConstProperties cp = (ConstProperties)base;
            if (cp.isConst(name)) {
                throw ScriptRuntime.typeError1("msg.const.redecl", name);
            }
        }
        if (isConst) {
            throw ScriptRuntime.typeError1("msg.var.redecl", name);
        }
    }
    
    public static void putProperty(final Scriptable obj, final String name, final Object value) {
        Scriptable base = getBase(obj, name);
        if (base == null) {
            base = obj;
        }
        base.put(name, obj, value);
    }
    
    public static void putProperty(final Scriptable obj, final String name, final Object value, final boolean isPrivate) {
        if (isPrivate) {
            obj.put(name, obj, value, true);
        }
        else {
            putProperty(obj, name, value);
        }
    }
    
    public static void putProperty(final Scriptable obj, final Symbol key, final Object value) {
        Scriptable base = getBase(obj, key);
        if (base == null) {
            base = obj;
        }
        ensureSymbolScriptable(base).put(key, obj, value);
    }
    
    public static void putProperty(final Scriptable obj, final int index, final Object value) {
        Scriptable base = getBase(obj, index);
        if (base == null) {
            base = obj;
        }
        base.put(index, obj, value);
    }
    
    public static void putProperty(final Object obj, final Object key, final Object value) {
        final Scriptable scriptable = ensureScriptable(obj);
        if (key instanceof String) {
            putProperty(scriptable, (String)key, value);
        }
        else if (key instanceof Integer) {
            putProperty(scriptable, (int)key, value);
        }
        else {
            if (!(key instanceof Symbol)) {
                throw Kit.codeBug();
            }
            putProperty(scriptable, (Symbol)key, value);
        }
    }
    
    public static void putConstProperty(final Object obj, final String name, final Object value) {
        final Scriptable scriptable = ensureScriptable(obj);
        Scriptable base = getBase(scriptable, name);
        if (base == null) {
            base = scriptable;
        }
        if (base instanceof ConstProperties) {
            ((ConstProperties)base).putConst(name, scriptable, value);
        }
    }
    
    public static boolean deleteProperty(final Scriptable obj, final String name) {
        final Scriptable base = getBase(obj, name);
        if (base == null) {
            return true;
        }
        base.delete(name);
        return !base.has(name, obj);
    }
    
    public static boolean deleteProperty(final Scriptable obj, final int index) {
        final Scriptable base = getBase(obj, index);
        if (base == null) {
            return true;
        }
        base.delete(index);
        return !base.has(index, obj);
    }
    
    public static Object[] getPropertyIds(Scriptable obj) {
        if (obj == null) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] result = obj.getIds();
        ObjToIntMap map = null;
        while (true) {
            obj = obj.getPrototype();
            if (obj == null) {
                break;
            }
            final Object[] ids = obj.getIds();
            if (ids.length == 0) {
                continue;
            }
            if (map == null) {
                if (result.length == 0) {
                    result = ids;
                    continue;
                }
                map = new ObjToIntMap(result.length + ids.length);
                for (int i = 0; i != result.length; ++i) {
                    map.intern(result[i]);
                }
                result = null;
            }
            for (int i = 0; i != ids.length; ++i) {
                map.intern(ids[i]);
            }
        }
        if (map != null) {
            result = map.getKeys();
        }
        return result;
    }
    
    public static Object callMethod(final Scriptable obj, final String methodName, final Object[] args) {
        return callMethod(null, obj, methodName, args);
    }
    
    public static Object callMethod(final Context cx, final Scriptable obj, final String methodName, final Object[] args) {
        final Object funObj = getProperty(obj, methodName);
        if (!(funObj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj, methodName);
        }
        final Function fun = (Function)funObj;
        final Scriptable scope = getTopLevelScope(obj);
        if (cx != null) {
            return fun.call(cx, scope, obj, args);
        }
        return Context.call((ContextFactory)null, (Callable)fun, scope, obj, args);
    }
    
    private static Scriptable getBase(Scriptable obj, final String name) {
        while (!obj.has(name, obj)) {
            obj = obj.getPrototype();
            if (obj == null) {
                return obj;
            }
        }
        return obj;
    }
    
    private static Scriptable getBase(Scriptable obj, final int index) {
        while (!obj.has(index, obj)) {
            obj = obj.getPrototype();
            if (obj == null) {
                return obj;
            }
        }
        return obj;
    }
    
    private static Scriptable getBase(Scriptable obj, final Symbol key) {
        while (!Undefined.isUndefined(obj) && obj != null) {
            if (!ensureSymbolScriptable(obj).has(key, obj)) {
                obj = obj.getPrototype();
                if (obj != null) {
                    continue;
                }
            }
            return obj;
        }
        return null;
    }
    
    public final Object getAssociatedValue(final Object key) {
        final Map<Object, Object> h = this.associatedValues;
        if (h == null) {
            return null;
        }
        return h.get(key);
    }
    
    public final boolean hasAssociatedValue(final Object key) {
        return this.associatedValues != null && this.associatedValues.containsKey(key);
    }
    
    public static Object getTopScopeValue(Scriptable scope, final Object key) {
        scope = getTopLevelScope(scope);
        do {
            if (scope instanceof ScriptableObject) {
                final ScriptableObject so = (ScriptableObject)scope;
                final Object value = so.getAssociatedValue(key);
                if (value != null) {
                    return value;
                }
            }
            scope = scope.getPrototype();
        } while (scope != null);
        return null;
    }
    
    public final synchronized Object associateValue(final Object key, final Object value) {
        return this.associateValue(key, value, false);
    }
    
    public final synchronized Object associateValue(final Object key, final Object value, final boolean override) {
        Map<Object, Object> h = this.associatedValues;
        if (h == null) {
            h = new HashMap<Object, Object>();
            this.associatedValues = h;
        }
        return Kit.initHash((Map)h, key, value, override);
    }
    
    private boolean putImpl(final Object key, final int index, final Scriptable start, final Object value, final boolean isPrivate) {
        final SlotMapContainer slotMap = this.getSlotMap(isPrivate);
        Slot slot;
        if (this != start) {
            slot = slotMap.query(key, index);
            if (!this.isExtensible && Context.getContext().isStrictMode() && (slot == null || !(slot instanceof GetterSlot))) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
            if (slot == null) {
                return false;
            }
        }
        else if (!this.isExtensible) {
            slot = slotMap.query(key, index);
            if (Context.getContext().isStrictMode() && !(slot instanceof GetterSlot)) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
            if (slot == null) {
                return true;
            }
        }
        else {
            if (this.isSealed) {
                this.checkNotSealed(key, index);
            }
            slot = slotMap.get(key, index, SlotAccess.MODIFY);
        }
        return slot.setValue(value, (Scriptable)this, start);
    }
    
    private SlotMapContainer getSlotMap(final boolean isPrivate) {
        return isPrivate ? this.privateSlotMap : this.slotMap;
    }
    
    private boolean putConstImpl(final String name, final int index, final Scriptable start, final Object value, final int constFlag) {
        assert constFlag != 0;
        if (!this.isExtensible) {
            final Context cx = Context.getContext();
            if (cx.isStrictMode()) {
                throw ScriptRuntime.typeError0("msg.not.extensible");
            }
        }
        Slot slot;
        if (this != start) {
            slot = this.slotMap.query(name, index);
            if (slot == null) {
                return false;
            }
        }
        else {
            if (this.isExtensible()) {
                this.checkNotSealed(name, index);
                slot = this.slotMap.get(name, index, SlotAccess.MODIFY_CONST);
                final int attr = slot.getAttributes();
                if ((attr & 0x8) != 0x0) {
                    slot.setValue(value);
                    if (constFlag != 8) {
                        slot.setAttributes((attr & 0xFFFFFFF7) | 0x10);
                    }
                }
                else if ((attr & 0x18) == 0x0) {
                    slot.setValue(value);
                    slot.setAttributes(attr | 0x10);
                }
                return true;
            }
            slot = this.slotMap.query(name, index);
            if (slot == null) {
                return true;
            }
        }
        return slot.setValue(value, (Scriptable)this, start);
    }
    
    private Slot findAttributeSlot(final String name, final int index, final SlotAccess accessType, final boolean isPrivate) {
        final Slot slot = this.getSlotMap(isPrivate).get(name, index, accessType);
        if (slot == null) {
            final String str = (name != null) ? name : Integer.toString(index);
            throw Context.reportRuntimeError1("msg.prop.not.found", (Object)str);
        }
        return slot;
    }
    
    private Slot findAttributeSlot(final Symbol key, final SlotAccess accessType) {
        final Slot slot = this.slotMap.get(key, 0, accessType);
        if (slot == null) {
            throw Context.reportRuntimeError1("msg.prop.not.found", (Object)key);
        }
        return slot;
    }
    
    public Object[] getIds(final boolean getNonEnumerable, final boolean getSymbols) {
        final int externalLen = (this.externalData == null) ? 0 : this.externalData.getArrayLength();
        Object[] a;
        if (externalLen == 0) {
            a = ScriptRuntime.emptyArgs;
        }
        else {
            a = new Object[externalLen];
            for (int i = 0; i < externalLen; ++i) {
                a[i] = i;
            }
        }
        if (this.slotMap.isEmpty()) {
            return a;
        }
        int c = externalLen;
        final long stamp = this.slotMap.readLock();
        try {
            for (final Slot slot : this.slotMap) {
                if ((getNonEnumerable || (slot.getAttributes() & 0x2) == 0x0) && (getSymbols || !(slot.name instanceof Symbol))) {
                    if (c == externalLen) {
                        final Object[] oldA = a;
                        a = new Object[this.slotMap.dirtySize() + externalLen];
                        if (oldA != null) {
                            System.arraycopy(oldA, 0, a, 0, externalLen);
                        }
                    }
                    a[c++] = ((slot.name != null) ? slot.name : Integer.valueOf(slot.indexOrHash));
                }
            }
        }
        finally {
            this.slotMap.unlockRead(stamp);
        }
        Object[] result;
        if (c == a.length + externalLen) {
            result = a;
        }
        else {
            result = new Object[c];
            System.arraycopy(a, 0, result, 0, c);
        }
        final Context cx = Context.getCurrentContext();
        if (cx != null && cx.hasFeature(15)) {
            Arrays.sort(result, ScriptableObject.KEY_COMPARATOR);
        }
        return result;
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        this.writeSlotMap(out, this.slotMap);
        this.writeSlotMap(out, this.privateSlotMap);
    }
    
    private void writeSlotMap(final ObjectOutputStream out, final SlotMapContainer slotMap) throws IOException {
        final long stamp = slotMap.readLock();
        try {
            final int objectsCount = slotMap.dirtySize();
            if (objectsCount == 0) {
                out.writeInt(0);
            }
            else {
                out.writeInt(objectsCount);
                for (final Slot slot : slotMap) {
                    out.writeObject(slot);
                }
            }
        }
        finally {
            slotMap.unlockRead(stamp);
        }
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.slotMap = this.readSlotMap(in);
        this.privateSlotMap = this.readSlotMap(in);
    }
    
    private SlotMapContainer readSlotMap(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        final int tableSize = in.readInt();
        final SlotMapContainer slotMap = this.createSlotMap(tableSize);
        for (int i = 0; i < tableSize; ++i) {
            final Slot slot = (Slot)in.readObject();
            slotMap.addSlot(slot);
        }
        return slotMap;
    }
    
    public ScriptableObject getOwnPropertyDescriptor(final Context cx, final Object id) {
        final Slot slot = this.getSlot(cx, id, SlotAccess.QUERY);
        if (slot == null) {
            return null;
        }
        final Scriptable scope = this.getParentScope();
        return slot.getPropertyDescriptor(cx, (Scriptable)((scope == null) ? this : scope));
    }
    
    protected Slot getSlot(final Context cx, final Object id, final SlotAccess accessType) {
        if (id instanceof Symbol) {
            return this.slotMap.get(id, 0, accessType);
        }
        final String name = ScriptRuntime.toStringIdOrIndex(cx, id);
        if (name == null) {
            return this.slotMap.get(null, ScriptRuntime.lastIndexResult(cx), accessType);
        }
        return this.slotMap.get(name, 0, accessType);
    }
    
    public int size() {
        return this.slotMap.size();
    }
    
    public boolean isEmpty() {
        return this.slotMap.isEmpty();
    }
    
    public Object get(final Object key, final Scriptable start) {
        Object value = null;
        if (key instanceof String) {
            value = this.get((String)key, start);
        }
        else if (key instanceof Symbol) {
            value = this.get((Symbol)key, start);
        }
        else if (key instanceof Number) {
            value = this.get(((Number)key).intValue(), start);
        }
        if (value == Scriptable.NOT_FOUND || value == Undefined.instance) {
            return null;
        }
        if (value instanceof Wrapper) {
            return ((Wrapper)value).unwrap();
        }
        return value;
    }
    
    public Object get(final Object key) {
        return this.get(key, (Scriptable)this);
    }
    
    public static BaseFunction getSpecies(Scriptable obj) {
        if (obj instanceof NativeFunction) {
            obj = obj.getPrototype();
        }
        if (hasProperty(obj, "constructor")) {
            if (obj instanceof ScriptableObject) {
                final ScriptableObject ctorDesc = ((ScriptableObject)obj).getOwnPropertyDescriptor(Context.getContext(), "constructor");
                if (ctorDesc != null && hasProperty((Scriptable)ctorDesc, "get") && !Undefined.isUndefined(getProperty((Scriptable)ctorDesc, "get"))) {
                    return null;
                }
            }
            final Object ctorObj = getProperty(obj, "constructor");
            if (Undefined.isUndefined(ctorObj)) {
                return null;
            }
            final Scriptable ctor = ensureScriptable(ctorObj);
            if (hasProperty(ctor, SymbolKey.SPECIES)) {
                final Object species = getProperty(ctor, SymbolKey.SPECIES);
                if (Undefined.isUndefined(species) || species == null) {
                    return null;
                }
                if (!(species instanceof BaseFunction)) {
                    throw Kit.codeBug();
                }
                return (BaseFunction)species;
            }
        }
        return null;
    }
    
    static {
        try {
            GET_ARRAY_LENGTH = ScriptableObject.class.getMethod("getExternalArrayLength", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException nsm) {
            throw new RuntimeException(nsm);
        }
        KEY_COMPARATOR = new KeyComparator();
    }
    
    enum SlotAccess
    {
        QUERY, 
        MODIFY, 
        MODIFY_CONST, 
        MODIFY_GETTER_SETTER, 
        CONVERT_ACCESSOR_TO_DATA;
    }
    
    static class Slot implements Serializable
    {
        private static final long serialVersionUID = -6090581677123995491L;
        Object name;
        int indexOrHash;
        private short attributes;
        protected Object value;
        transient Slot next;
        transient Slot orderedNext;
        private boolean initialized;
        
        Slot(final Object name, final int indexOrHash, final int attributes) {
            this.initialized = false;
            this.name = name;
            this.indexOrHash = indexOrHash;
            this.attributes = (short)attributes;
        }
        
        private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            if (this.name != null) {
                this.indexOrHash = this.name.hashCode();
            }
        }
        
        void setValue(final Object value) {
            this.initialized = true;
            this.value = value;
        }
        
        boolean setValue(final Object value, final Scriptable owner, final Scriptable start) {
            if ((this.attributes & 0x1) != 0x0) {
                final Context cx = Context.getContext();
                if ((this.attributes & 0x10) != 0x0) {
                    throw ScriptRuntime.typeError1("msg.const.inval.assign", this.name);
                }
                if (cx.isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.modify.readonly", this.name);
                }
                return this.initialized = true;
            }
            else {
                if (owner == start) {
                    this.setValue(value);
                    return true;
                }
                return false;
            }
        }
        
        Object getValue(final Scriptable start) {
            if (!this.initialized) {
                throw ScriptRuntime.throwCustomError(Context.getContext(), Context.getScope(), "ReferenceError", "can't access lexical declaration '" + this.name + "' before initialization");
            }
            return this.value;
        }
        
        int getAttributes() {
            return this.attributes;
        }
        
        synchronized void setAttributes(final int value) {
            ScriptableObject.checkValidAttributes(value);
            this.attributes = (short)value;
        }
        
        ScriptableObject getPropertyDescriptor(final Context cx, final Scriptable scope) {
            return ScriptableObject.buildDataDescriptor(scope, this.value, this.attributes);
        }
    }
    
    static final class GetterSlot extends Slot
    {
        private static final long serialVersionUID = -4900574849788797588L;
        Object getter;
        Object setter;
        
        GetterSlot(final Object name, final int indexOrHash, final int attributes) {
            super(name, indexOrHash, attributes);
        }
        
        @Override
        ScriptableObject getPropertyDescriptor(final Context cx, final Scriptable scope) {
            final int attr = this.getAttributes();
            final ScriptableObject desc = (ScriptableObject)new NativeObject();
            ScriptRuntime.setBuiltinProtoAndParent(desc, scope, TopLevel.Builtins.Object);
            desc.defineProperty("enumerable", (attr & 0x2) == 0x0, 0);
            desc.defineProperty("configurable", (attr & 0x4) == 0x0, 0);
            if (this.getter == null && this.setter == null) {
                desc.defineProperty("writable", (attr & 0x1) == 0x0, 0);
            }
            final String fName = (this.name == null) ? "f" : this.name.toString();
            if (this.getter != null) {
                if (this.getter instanceof MemberBox) {
                    desc.defineProperty("get", new FunctionObject(fName, ((MemberBox)this.getter).member(), scope), 0);
                }
                else if (this.getter instanceof Member) {
                    desc.defineProperty("get", new FunctionObject(fName, (Member)this.getter, scope), 0);
                }
                else {
                    desc.defineProperty("get", this.getter, 0);
                }
            }
            if (this.setter != null) {
                if (this.setter instanceof MemberBox) {
                    desc.defineProperty("set", new FunctionObject(fName, ((MemberBox)this.setter).member(), scope), 0);
                }
                else if (this.setter instanceof Member) {
                    desc.defineProperty("set", new FunctionObject(fName, (Member)this.setter, scope), 0);
                }
                else {
                    desc.defineProperty("set", this.setter, 0);
                }
            }
            return desc;
        }
        
        @Override
        boolean setValue(final Object value, final Scriptable owner, final Scriptable start) {
            if (this.setter != null) {
                final Context cx = Context.getContext();
                if (this.setter instanceof MemberBox) {
                    final MemberBox nativeSetter = (MemberBox)this.setter;
                    final Class<?>[] pTypes = (Class<?>[])nativeSetter.argTypes;
                    final Class<?> valueType = pTypes[pTypes.length - 1];
                    final int tag = FunctionObject.getTypeTag((Class)valueType);
                    final Object actualArg = FunctionObject.convertArg(cx, start, value, tag);
                    Object setterThis;
                    Object[] args;
                    if (nativeSetter.delegateTo == null) {
                        setterThis = start;
                        args = new Object[] { actualArg };
                    }
                    else {
                        setterThis = nativeSetter.delegateTo;
                        args = new Object[] { start, actualArg };
                    }
                    nativeSetter.invoke(setterThis, args);
                }
                else if (this.setter instanceof Function) {
                    final Function f = (Function)this.setter;
                    f.call(cx, f.getParentScope(), start, new Object[] { value });
                }
                return true;
            }
            if (this.getter == null) {
                return super.setValue(value, owner, start);
            }
            final Context cx = Context.getContext();
            if (cx.isStrictMode() || cx.hasFeature(10)) {
                String prop = "";
                if (this.name != null) {
                    prop = "[" + start.getClassName() + "]." + this.name.toString();
                }
                throw ScriptRuntime.typeError2("msg.set.prop.no.setter", prop, Context.toString(value));
            }
            return true;
        }
        
        @Override
        Object getValue(final Scriptable start) {
            if (this.getter != null) {
                if (this.getter instanceof MemberBox) {
                    final MemberBox nativeGetter = (MemberBox)this.getter;
                    Object getterThis;
                    Object[] args;
                    if (nativeGetter.delegateTo == null) {
                        getterThis = start;
                        args = ScriptRuntime.emptyArgs;
                    }
                    else {
                        getterThis = nativeGetter.delegateTo;
                        args = new Object[] { start };
                    }
                    return nativeGetter.invoke(getterThis, args);
                }
                if (this.getter instanceof Function) {
                    final Function f = (Function)this.getter;
                    final Context cx = Context.getContext();
                    return f.call(cx, f.getParentScope(), start, ScriptRuntime.emptyArgs);
                }
            }
            Object val = this.value;
            if (val instanceof LazilyLoadedCtor) {
                final LazilyLoadedCtor initializer = (LazilyLoadedCtor)val;
                try {
                    initializer.init();
                }
                finally {
                    val = initializer.getValue();
                    this.setValue(val);
                }
            }
            return val;
        }
    }
    
    public static final class KeyComparator implements Comparator<Object>
    {
        @Override
        public int compare(final Object o1, final Object o2) {
            if (ScriptRuntime.isSymbol(o1)) {
                if (ScriptRuntime.isSymbol(o2)) {
                    return 0;
                }
                return 1;
            }
            else {
                if (ScriptRuntime.isSymbol(o2)) {
                    return -1;
                }
                if (o1 instanceof Integer && (int)o1 >= 0) {
                    if (o2 instanceof Integer && (int)o2 >= 0) {
                        final int i1 = (int)o1;
                        final int i2 = (int)o2;
                        return Integer.compare(i1, i2);
                    }
                    return -1;
                }
                else {
                    if (o2 instanceof Integer && (int)o2 >= 0) {
                        return 1;
                    }
                    return 0;
                }
            }
        }
    }
}
