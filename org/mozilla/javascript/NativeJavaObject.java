//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.lang.reflect.*;
import java.io.*;

public class NativeJavaObject implements Scriptable, SymbolScriptable, Wrapper, Serializable
{
    private static final long serialVersionUID = -6948590651130498591L;
    private static final int JSTYPE_UNDEFINED = 0;
    private static final int JSTYPE_NULL = 1;
    private static final int JSTYPE_BOOLEAN = 2;
    private static final int JSTYPE_NUMBER = 3;
    private static final int JSTYPE_STRING = 4;
    private static final int JSTYPE_JAVA_CLASS = 5;
    private static final int JSTYPE_JAVA_OBJECT = 6;
    private static final int JSTYPE_JAVA_ARRAY = 7;
    private static final int JSTYPE_OBJECT = 8;
    static final byte CONVERSION_TRIVIAL = 1;
    static final byte CONVERSION_NONTRIVIAL = 0;
    static final byte CONVERSION_NONE = 99;
    protected Scriptable prototype;
    protected Scriptable parent;
    protected transient Object javaObject;
    protected transient Class<?> staticType;
    protected transient JavaMembers members;
    private transient Map<String, FieldAndMethods> fieldAndMethods;
    protected transient boolean isAdapter;
    private static final Object COERCED_INTERFACE_KEY;
    private static Method adapter_writeAdapterObject;
    private static Method adapter_readAdapterObject;
    
    public NativeJavaObject() {
    }
    
    public NativeJavaObject(final Scriptable scope, final Object javaObject, final Class<?> staticType) {
        this(scope, javaObject, staticType, false);
    }
    
    public NativeJavaObject(final Scriptable scope, final Object javaObject, final Class<?> staticType, final boolean isAdapter) {
        this.parent = scope;
        this.javaObject = javaObject;
        this.staticType = staticType;
        this.isAdapter = isAdapter;
        this.initMembers();
    }
    
    protected void initMembers() {
        Class<?> dynamicType;
        if (this.javaObject != null) {
            dynamicType = this.javaObject.getClass();
        }
        else {
            dynamicType = this.staticType;
        }
        this.members = JavaMembers.lookupClass(this.parent, (Class)dynamicType, (Class)this.staticType, this.isAdapter);
        this.fieldAndMethods = (Map<String, FieldAndMethods>)this.members.getFieldAndMethodsObjects((Scriptable)this, this.javaObject, false);
    }
    
    @Override
    public boolean has(final String name, final Scriptable start) {
        return this.members.has(name, false);
    }
    
    @Override
    public boolean has(final int index, final Scriptable start) {
        return false;
    }
    
    @Override
    public boolean has(final Symbol key, final Scriptable start) {
        return false;
    }
    
    @Override
    public Object get(final String name, final Scriptable start, final boolean isPrivate) {
        if (isPrivate) {
            throw ScriptRuntime.typeError1("msg.java.private.access", name);
        }
        if (this.fieldAndMethods != null) {
            final Object result = this.fieldAndMethods.get(name);
            if (result != null) {
                return result;
            }
        }
        return this.members.get((Scriptable)this, name, this.javaObject, false);
    }
    
    @Override
    public Object get(final Symbol key, final Scriptable start) {
        return Scriptable.NOT_FOUND;
    }
    
    @Override
    public Object get(final int index, final Scriptable start) {
        throw this.members.reportMemberNotFound(Integer.toString(index));
    }
    
    @Override
    public void put(final String name, final Scriptable start, final Object value, final boolean isPrivate) {
        if (isPrivate) {
            throw ScriptRuntime.typeError1("msg.java.private.access", name);
        }
        if (this.prototype == null || this.members.has(name, false)) {
            this.members.put((Scriptable)this, name, this.javaObject, value, false);
        }
        else {
            this.prototype.put(name, this.prototype, value);
        }
    }
    
    @Override
    public void put(final Symbol symbol, final Scriptable start, final Object value) {
        final String name = symbol.toString();
        if (this.prototype == null || this.members.has(name, false)) {
            this.members.put((Scriptable)this, name, this.javaObject, value, false);
        }
        else if (this.prototype instanceof SymbolScriptable) {
            ((SymbolScriptable)this.prototype).put(symbol, this.prototype, value);
        }
    }
    
    @Override
    public void put(final int index, final Scriptable start, final Object value) {
        throw this.members.reportMemberNotFound(Integer.toString(index));
    }
    
    @Override
    public boolean hasInstance(final Scriptable value) {
        return false;
    }
    
    @Override
    public void declare(final String name, final Scriptable start) {
    }
    
    @Override
    public void declareConst(final String name, final Scriptable start) {
    }
    
    @Override
    public void delete(final String name) {
    }
    
    @Override
    public void delete(final Symbol key) {
    }
    
    @Override
    public void delete(final int index) {
    }
    
    @Override
    public Scriptable getPrototype() {
        if (this.prototype == null && this.javaObject instanceof String) {
            return TopLevel.getBuiltinPrototype(ScriptableObject.getTopLevelScope(this.parent), TopLevel.Builtins.String);
        }
        return this.prototype;
    }
    
    @Override
    public void setPrototype(final Scriptable m) {
        this.prototype = m;
    }
    
    @Override
    public Scriptable getParentScope() {
        return this.parent;
    }
    
    @Override
    public void setParentScope(final Scriptable m) {
        this.parent = m;
    }
    
    @Override
    public Object[] getIds() {
        return this.members.getIds(false);
    }
    
    @Deprecated
    public static Object wrap(final Scriptable scope, final Object obj, final Class<?> staticType) {
        final Context cx = Context.getContext();
        return cx.getWrapFactory().wrap(cx, scope, obj, staticType);
    }
    
    @Override
    public Object unwrap() {
        return this.javaObject;
    }
    
    @Override
    public String getClassName() {
        return "JavaObject";
    }
    
    @Override
    public Object getDefaultValue(Class<?> hint) {
        if (hint == null) {
            if (this.javaObject instanceof Boolean) {
                hint = ScriptRuntime.BooleanClass;
            }
            if (this.javaObject instanceof Number) {
                hint = ScriptRuntime.NumberClass;
            }
        }
        Object value;
        if (hint == null || hint == ScriptRuntime.StringClass) {
            value = this.javaObject.toString();
        }
        else {
            String converterName;
            if (hint == ScriptRuntime.BooleanClass) {
                converterName = "booleanValue";
            }
            else {
                if (hint != ScriptRuntime.NumberClass) {
                    throw Context.reportRuntimeError0("msg.default.value");
                }
                converterName = "doubleValue";
            }
            final Object converterObject = this.get(converterName, this);
            if (converterObject instanceof Function) {
                final Function f = (Function)converterObject;
                value = f.call(Context.getContext(), f.getParentScope(), (Scriptable)this, ScriptRuntime.emptyArgs);
            }
            else if (hint == ScriptRuntime.NumberClass && this.javaObject instanceof Boolean) {
                final boolean b = (boolean)this.javaObject;
                value = ScriptRuntime.wrapNumber(b ? 1.0 : 0.0);
            }
            else {
                value = this.javaObject.toString();
            }
        }
        return value;
    }
    
    public static boolean canConvert(final Object fromObj, final Class<?> to) {
        final int weight = getConversionWeight(fromObj, to);
        return weight < 99;
    }
    
    static int getConversionWeight(final Object fromObj, final Class<?> to) {
        final int fromCode = getJSTypeCode(fromObj);
        switch (fromCode) {
            case 0: {
                if (to == ScriptRuntime.StringClass || to == ScriptRuntime.ObjectClass) {
                    return 1;
                }
                break;
            }
            case 1: {
                if (!to.isPrimitive()) {
                    return 1;
                }
                break;
            }
            case 2: {
                if (to == Boolean.TYPE) {
                    return 1;
                }
                if (to == ScriptRuntime.BooleanClass) {
                    return 2;
                }
                if (to == ScriptRuntime.ObjectClass) {
                    return 3;
                }
                if (to == ScriptRuntime.StringClass) {
                    return 4;
                }
                break;
            }
            case 3: {
                if (to.isPrimitive()) {
                    if (to == Double.TYPE) {
                        return 1;
                    }
                    if (to != Boolean.TYPE) {
                        return 1 + getSizeRank(to);
                    }
                    break;
                }
                else {
                    if (to == ScriptRuntime.StringClass) {
                        return 9;
                    }
                    if (to == ScriptRuntime.ObjectClass) {
                        return 10;
                    }
                    if (ScriptRuntime.NumberClass.isAssignableFrom(to)) {
                        return 2;
                    }
                    break;
                }
                break;
            }
            case 4: {
                if (to == ScriptRuntime.StringClass) {
                    return 1;
                }
                if (to.isInstance(fromObj)) {
                    return 2;
                }
                if (!to.isPrimitive()) {
                    break;
                }
                if (to == Character.TYPE) {
                    return 3;
                }
                if (to != Boolean.TYPE) {
                    return 4;
                }
                break;
            }
            case 5: {
                if (to == ScriptRuntime.ClassClass) {
                    return 1;
                }
                if (to == ScriptRuntime.ObjectClass) {
                    return 3;
                }
                if (to == ScriptRuntime.StringClass) {
                    return 4;
                }
                break;
            }
            case 6:
            case 7: {
                Object javaObj = fromObj;
                if (javaObj instanceof Wrapper) {
                    javaObj = ((Wrapper)javaObj).unwrap();
                }
                if (to.isInstance(javaObj)) {
                    return 0;
                }
                if (to == ScriptRuntime.StringClass) {
                    return 2;
                }
                if (to.isPrimitive() && to != Boolean.TYPE) {
                    return (fromCode == 7) ? 99 : (2 + getSizeRank(to));
                }
                break;
            }
            case 8: {
                if (to != ScriptRuntime.ObjectClass && to.isInstance(fromObj)) {
                    return 1;
                }
                if (to.isArray()) {
                    if (fromObj instanceof NativeArray) {
                        return 2;
                    }
                    break;
                }
                else {
                    if (to == ScriptRuntime.ObjectClass) {
                        return 3;
                    }
                    if (to == ScriptRuntime.StringClass) {
                        return 4;
                    }
                    if (to == ScriptRuntime.DateClass) {
                        if (fromObj instanceof NativeDate) {
                            return 1;
                        }
                        break;
                    }
                    else if (to.isInterface()) {
                        if (fromObj instanceof BaseFunction) {
                            return 1;
                        }
                        if (fromObj instanceof NativeObject) {
                            return 2;
                        }
                        return 12;
                    }
                    else {
                        if (to.isPrimitive() && to != Boolean.TYPE) {
                            return 4 + getSizeRank(to);
                        }
                        break;
                    }
                }
                break;
            }
        }
        return 99;
    }
    
    static int getSizeRank(final Class<?> aType) {
        if (aType == Double.TYPE) {
            return 1;
        }
        if (aType == Float.TYPE) {
            return 2;
        }
        if (aType == Long.TYPE) {
            return 3;
        }
        if (aType == Integer.TYPE) {
            return 4;
        }
        if (aType == Short.TYPE) {
            return 5;
        }
        if (aType == Character.TYPE) {
            return 6;
        }
        if (aType == Byte.TYPE) {
            return 7;
        }
        if (aType == Boolean.TYPE) {
            return 99;
        }
        return 8;
    }
    
    private static int getJSTypeCode(final Object value) {
        if (value == null) {
            return 1;
        }
        if (value == Undefined.instance) {
            return 0;
        }
        if (value instanceof CharSequence) {
            return 4;
        }
        if (value instanceof Number) {
            return 3;
        }
        if (value instanceof Boolean) {
            return 2;
        }
        if (value instanceof Scriptable) {
            if (value instanceof NativeJavaClass) {
                return 5;
            }
            if (value instanceof NativeJavaArray) {
                return 7;
            }
            if (value instanceof Wrapper) {
                return 6;
            }
            return 8;
        }
        else {
            if (value instanceof Class) {
                return 5;
            }
            final Class<?> valueClass = value.getClass();
            if (valueClass.isArray()) {
                return 7;
            }
            return 6;
        }
    }
    
    @Deprecated
    public static Object coerceType(final Class<?> type, final Object value) {
        return coerceTypeImpl(type, value);
    }
    
    static Object coerceTypeImpl(final Class<?> type, Object value) {
        if (value != null && value.getClass() == type) {
            return value;
        }
        switch (getJSTypeCode(value)) {
            case 1: {
                if (type.isPrimitive()) {
                    reportConversionError(value, type);
                }
                return null;
            }
            case 0: {
                if (type == ScriptRuntime.StringClass || type == ScriptRuntime.ObjectClass) {
                    return "undefined";
                }
                reportConversionError("undefined", type);
                break;
            }
            case 2: {
                if (type == Boolean.TYPE || type == ScriptRuntime.BooleanClass || type == ScriptRuntime.ObjectClass) {
                    return value;
                }
                if (type == ScriptRuntime.StringClass) {
                    return value.toString();
                }
                reportConversionError(value, type);
                break;
            }
            case 3: {
                if (type == ScriptRuntime.StringClass) {
                    return ScriptRuntime.toString(value);
                }
                if (type == ScriptRuntime.ObjectClass) {
                    final Context context = Context.getCurrentContext();
                    if (context != null && context.hasFeature(17)) {
                        final long roundedValue = Math.round(toDouble(value));
                        if (roundedValue == toDouble(value)) {
                            return coerceToNumber(Long.TYPE, value);
                        }
                    }
                    return coerceToNumber(Double.TYPE, value);
                }
                if ((type.isPrimitive() && type != Boolean.TYPE) || ScriptRuntime.NumberClass.isAssignableFrom(type)) {
                    return coerceToNumber(type, value);
                }
                reportConversionError(value, type);
                break;
            }
            case 4: {
                if (type == ScriptRuntime.StringClass || type.isInstance(value)) {
                    return value.toString();
                }
                if (type == Character.TYPE || type == ScriptRuntime.CharacterClass) {
                    if (((CharSequence)value).length() == 1) {
                        return ((CharSequence)value).charAt(0);
                    }
                    return coerceToNumber(type, value);
                }
                else {
                    if ((type.isPrimitive() && type != Boolean.TYPE) || ScriptRuntime.NumberClass.isAssignableFrom(type)) {
                        return coerceToNumber(type, value);
                    }
                    reportConversionError(value, type);
                    break;
                }
                break;
            }
            case 5: {
                if (value instanceof Wrapper) {
                    value = ((Wrapper)value).unwrap();
                }
                if (type == ScriptRuntime.ClassClass || type == ScriptRuntime.ObjectClass) {
                    return value;
                }
                if (type == ScriptRuntime.StringClass) {
                    return value.toString();
                }
                reportConversionError(value, type);
                break;
            }
            case 6:
            case 7: {
                if (value instanceof Wrapper) {
                    value = ((Wrapper)value).unwrap();
                }
                if (type.isPrimitive()) {
                    if (type == Boolean.TYPE) {
                        reportConversionError(value, type);
                    }
                    return coerceToNumber(type, value);
                }
                if (type == ScriptRuntime.StringClass) {
                    return value.toString();
                }
                if (type.isInstance(value)) {
                    return value;
                }
                reportConversionError(value, type);
                break;
            }
            case 8: {
                if (type == ScriptRuntime.StringClass) {
                    return ScriptRuntime.toString(value);
                }
                if (type.isPrimitive()) {
                    if (type == Boolean.TYPE) {
                        reportConversionError(value, type);
                    }
                    return coerceToNumber(type, value);
                }
                if (type.isInstance(value)) {
                    return value;
                }
                if (type == ScriptRuntime.DateClass && value instanceof NativeDate) {
                    final double time = ((NativeDate)value).getJSTimeValue();
                    return new Date((long)time);
                }
                if (type.isArray() && value instanceof NativeArray) {
                    final NativeArray array = (NativeArray)value;
                    final long length = array.getLength();
                    final Class<?> arrayType = type.getComponentType();
                    final Object Result = Array.newInstance(arrayType, (int)length);
                    for (int i = 0; i < length; ++i) {
                        try {
                            Array.set(Result, i, coerceTypeImpl(arrayType, array.get(i, (Scriptable)array)));
                        }
                        catch (EvaluatorException ee) {
                            reportConversionError(value, type);
                        }
                    }
                    return Result;
                }
                if (value instanceof Wrapper) {
                    value = ((Wrapper)value).unwrap();
                    if (type.isInstance(value)) {
                        return value;
                    }
                    reportConversionError(value, type);
                    break;
                }
                else {
                    if (type.isInterface() && (value instanceof NativeObject || value instanceof NativeFunction || value instanceof ArrowFunction || value instanceof BoundFunction || value instanceof NativeJavaMethod)) {
                        return createInterfaceAdapter(type, (ScriptableObject)value);
                    }
                    reportConversionError(value, type);
                    break;
                }
                break;
            }
        }
        return value;
    }
    
    protected static Object createInterfaceAdapter(final Class<?> type, final ScriptableObject so) {
        final Object key = Kit.makeHashKeyFromPair(NativeJavaObject.COERCED_INTERFACE_KEY, (Object)type);
        final Object old = so.getAssociatedValue(key);
        if (old != null) {
            return old;
        }
        final Context cx = Context.getContext();
        Object glue = InterfaceAdapter.create(cx, (Class)type, so);
        glue = so.associateValue(key, glue);
        return glue;
    }
    
    private static Object coerceToNumber(final Class<?> type, final Object value) {
        final Class<?> valueClass = value.getClass();
        if (type == Character.TYPE || type == ScriptRuntime.CharacterClass) {
            if (valueClass == ScriptRuntime.CharacterClass) {
                return value;
            }
            return (char)toInteger(value, ScriptRuntime.CharacterClass, 0.0, 65535.0);
        }
        else {
            if (type == ScriptRuntime.ObjectClass || type == ScriptRuntime.DoubleClass || type == Double.TYPE) {
                return (valueClass == ScriptRuntime.DoubleClass) ? value : Double.valueOf(toDouble(value));
            }
            if (type == ScriptRuntime.FloatClass || type == Float.TYPE) {
                if (valueClass == ScriptRuntime.FloatClass) {
                    return value;
                }
                final double number = toDouble(value);
                if (Double.isInfinite(number) || Double.isNaN(number) || number == 0.0) {
                    return (float)number;
                }
                final double absNumber = Math.abs(number);
                if (absNumber < 1.401298464324817E-45) {
                    return (number > 0.0) ? 0.0f : -0.0f;
                }
                if (absNumber > 3.4028234663852886E38) {
                    return (number > 0.0) ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
                }
                return (float)number;
            }
            else if (type == ScriptRuntime.IntegerClass || type == Integer.TYPE) {
                if (valueClass == ScriptRuntime.IntegerClass) {
                    return value;
                }
                return (int)toInteger(value, ScriptRuntime.IntegerClass, -2.147483648E9, 2.147483647E9);
            }
            else if (type == ScriptRuntime.LongClass || type == Long.TYPE) {
                if (valueClass == ScriptRuntime.LongClass) {
                    return value;
                }
                final double max = Double.longBitsToDouble(4890909195324358655L);
                final double min = Double.longBitsToDouble(-4332462841530417152L);
                return toInteger(value, ScriptRuntime.LongClass, min, max);
            }
            else if (type == ScriptRuntime.ShortClass || type == Short.TYPE) {
                if (valueClass == ScriptRuntime.ShortClass) {
                    return value;
                }
                return (short)toInteger(value, ScriptRuntime.ShortClass, -32768.0, 32767.0);
            }
            else {
                if (type != ScriptRuntime.ByteClass && type != Byte.TYPE) {
                    return toDouble(value);
                }
                if (valueClass == ScriptRuntime.ByteClass) {
                    return value;
                }
                return (byte)toInteger(value, ScriptRuntime.ByteClass, -128.0, 127.0);
            }
        }
    }
    
    private static double toDouble(final Object value) {
        if (value instanceof Number) {
            return ((Number)value).doubleValue();
        }
        if (value instanceof String) {
            return ScriptRuntime.toNumber((String)value);
        }
        if (!(value instanceof Scriptable)) {
            Method meth;
            try {
                meth = value.getClass().getMethod("doubleValue", (Class<?>[])null);
            }
            catch (NoSuchMethodException | SecurityException ex3) {
                final Exception ex;
                final Exception e = ex;
                meth = null;
            }
            if (meth != null) {
                try {
                    return ((Number)meth.invoke(value, (Object[])null)).doubleValue();
                }
                catch (IllegalAccessException | InvocationTargetException ex4) {
                    final ReflectiveOperationException ex2;
                    final ReflectiveOperationException e2 = ex2;
                    reportConversionError(value, Double.TYPE);
                }
            }
            return ScriptRuntime.toNumber(value.toString());
        }
        if (value instanceof Wrapper) {
            return toDouble(((Wrapper)value).unwrap());
        }
        return ScriptRuntime.toNumber(value);
    }
    
    private static long toInteger(final Object value, final Class<?> type, final double min, final double max) {
        double d = toDouble(value);
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            reportConversionError(ScriptRuntime.toString(value), type);
        }
        if (d > 0.0) {
            d = Math.floor(d);
        }
        else {
            d = Math.ceil(d);
        }
        if (d < min || d > max) {
            reportConversionError(ScriptRuntime.toString(value), type);
        }
        return (long)d;
    }
    
    static void reportConversionError(final Object value, final Class<?> type) {
        throw Context.reportRuntimeError2("msg.conversion.not.allowed", (Object)String.valueOf(value), (Object)JavaMembers.javaSignature((Class)type));
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeBoolean(this.isAdapter);
        if (this.isAdapter) {
            if (NativeJavaObject.adapter_writeAdapterObject == null) {
                throw new IOException();
            }
            final Object[] args = { this.javaObject, out };
            try {
                NativeJavaObject.adapter_writeAdapterObject.invoke(null, args);
            }
            catch (Exception ex) {
                throw new IOException();
            }
        }
        else {
            out.writeObject(this.javaObject);
        }
        if (this.staticType != null) {
            out.writeObject(this.staticType.getName());
        }
        else {
            out.writeObject(null);
        }
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.isAdapter = in.readBoolean();
        if (this.isAdapter) {
            if (NativeJavaObject.adapter_readAdapterObject == null) {
                throw new ClassNotFoundException();
            }
            final Object[] args = { this, in };
            try {
                this.javaObject = NativeJavaObject.adapter_readAdapterObject.invoke(null, args);
            }
            catch (Exception ex) {
                throw new IOException();
            }
        }
        else {
            this.javaObject = in.readObject();
        }
        final String className = (String)in.readObject();
        if (className != null) {
            this.staticType = Class.forName(className);
        }
        else {
            this.staticType = null;
        }
        this.initMembers();
    }
    
    static {
        COERCED_INTERFACE_KEY = "Coerced Interface";
        final Class<?>[] sig2 = (Class<?>[])new Class[2];
        final Class<?> cl = (Class<?>)Kit.classOrNull("org.mozilla.javascript.JavaAdapter");
        if (cl != null) {
            try {
                sig2[0] = ScriptRuntime.ObjectClass;
                sig2[1] = (Class<?>)Kit.classOrNull("java.io.ObjectOutputStream");
                NativeJavaObject.adapter_writeAdapterObject = cl.getMethod("writeAdapterObject", sig2);
                sig2[0] = ScriptRuntime.ScriptableClass;
                sig2[1] = (Class<?>)Kit.classOrNull("java.io.ObjectInputStream");
                NativeJavaObject.adapter_readAdapterObject = cl.getMethod("readAdapterObject", sig2);
            }
            catch (NoSuchMethodException e) {
                NativeJavaObject.adapter_writeAdapterObject = null;
                NativeJavaObject.adapter_readAdapterObject = null;
            }
        }
    }
}
