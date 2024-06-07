//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;
import java.util.*;

class JavaMembers
{
    private Class<?> cl;
    private Map<String, Object> members;
    private Map<String, FieldAndMethods> fieldAndMethods;
    private Map<String, Object> staticMembers;
    private Map<String, FieldAndMethods> staticFieldAndMethods;
    NativeJavaMethod ctors;
    
    JavaMembers(final Scriptable scope, final Class<?> cl) {
        this(scope, cl, false);
    }
    
    JavaMembers(final Scriptable scope, final Class<?> cl, final boolean includeProtected) {
        try {
            final Context cx = ContextFactory.getGlobal().enterContext();
            final ClassShutter shutter = cx.getClassShutter();
            if (shutter != null && !shutter.visibleToScripts(cl.getName())) {
                throw Context.reportRuntimeError1("msg.access.prohibited", (Object)cl.getName());
            }
            this.members = new HashMap<String, Object>();
            this.staticMembers = new HashMap<String, Object>();
            this.cl = cl;
            final boolean includePrivate = cx.hasFeature(12);
            this.reflect(scope, includeProtected, includePrivate);
        }
        finally {
            Context.exit();
        }
    }
    
    boolean has(final String name, final boolean isStatic) {
        final Map<String, Object> ht = isStatic ? this.staticMembers : this.members;
        final Object obj = ht.get(name);
        return obj != null || this.findExplicitFunction(name, isStatic) != null;
    }
    
    Object get(Scriptable scope, final String name, final Object javaObject, final boolean isStatic) {
        final Map<String, Object> ht = isStatic ? this.staticMembers : this.members;
        Object member = ht.get(name);
        if (!isStatic && member == null) {
            member = this.staticMembers.get(name);
        }
        if (member == null) {
            member = this.getExplicitFunction(scope, name, javaObject, isStatic);
            if (member == null) {
                return Scriptable.NOT_FOUND;
            }
        }
        if (member instanceof Scriptable) {
            return member;
        }
        final Context cx = Context.getContext();
        Object rval;
        Class<?> type;
        try {
            if (member instanceof BeanProperty) {
                final BeanProperty bp = (BeanProperty)member;
                if (bp.getter == null) {
                    return Scriptable.NOT_FOUND;
                }
                rval = bp.getter.invoke(javaObject, Context.emptyArgs);
                type = bp.getter.method().getReturnType();
            }
            else {
                final Field field = (Field)member;
                rval = field.get(isStatic ? null : javaObject);
                type = field.getType();
            }
        }
        catch (Exception ex) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex);
        }
        scope = ScriptableObject.getTopLevelScope(scope);
        return cx.getWrapFactory().wrap(cx, scope, rval, type);
    }
    
    void put(final Scriptable scope, final String name, final Object javaObject, final Object value, final boolean isStatic) {
        final Map<String, Object> ht = isStatic ? this.staticMembers : this.members;
        Object member = ht.get(name);
        if (!isStatic && member == null) {
            member = this.staticMembers.get(name);
        }
        if (member == null) {
            throw this.reportMemberNotFound(name);
        }
        if (member instanceof FieldAndMethods) {
            final FieldAndMethods fam = ht.get(name);
            member = fam.field;
        }
        if (member instanceof BeanProperty) {
            final BeanProperty bp = (BeanProperty)member;
            if (bp.setter == null) {
                throw this.reportMemberNotFound(name);
            }
            if (bp.setters == null || value == null) {
                final Class<?> setType = bp.setter.argTypes[0];
                final Object[] args = { Context.jsToJava(value, (Class)setType) };
                try {
                    bp.setter.invoke(javaObject, args);
                }
                catch (Exception ex) {
                    throw Context.throwAsScriptRuntimeEx((Throwable)ex);
                }
            }
            else {
                final Object[] args2 = { value };
                bp.setters.call(Context.getContext(), ScriptableObject.getTopLevelScope(scope), scope, args2);
            }
        }
        else {
            if (!(member instanceof Field)) {
                final String str = (member == null) ? "msg.java.internal.private" : "msg.java.method.assign";
                throw Context.reportRuntimeError1(str, (Object)name);
            }
            final Field field = (Field)member;
            final Object javaValue = Context.jsToJava(value, (Class)field.getType());
            try {
                field.set(javaObject, javaValue);
            }
            catch (IllegalAccessException accessEx) {
                if ((field.getModifiers() & 0x10) != 0x0) {
                    return;
                }
                throw Context.throwAsScriptRuntimeEx((Throwable)accessEx);
            }
            catch (IllegalArgumentException argEx) {
                throw Context.reportRuntimeError3("msg.java.internal.field.type", (Object)value.getClass().getName(), (Object)field, (Object)javaObject.getClass().getName());
            }
        }
    }
    
    Object[] getIds(final boolean isStatic) {
        final Map<String, Object> map = isStatic ? this.staticMembers : this.members;
        return map.keySet().toArray(new Object[map.size()]);
    }
    
    static String javaSignature(Class<?> type) {
        if (!type.isArray()) {
            return type.getName();
        }
        int arrayDimension = 0;
        do {
            ++arrayDimension;
            type = type.getComponentType();
        } while (type.isArray());
        final String name = type.getName();
        final String suffix = "[]";
        if (arrayDimension == 1) {
            return name.concat(suffix);
        }
        final int length = name.length() + arrayDimension * suffix.length();
        final StringBuilder sb = new StringBuilder(length);
        sb.append(name);
        while (arrayDimension != 0) {
            --arrayDimension;
            sb.append(suffix);
        }
        return sb.toString();
    }
    
    static String liveConnectSignature(final Class<?>[] argTypes) {
        final int N = argTypes.length;
        if (N == 0) {
            return "()";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (int i = 0; i != N; ++i) {
            if (i != 0) {
                sb.append(',');
            }
            sb.append(javaSignature(argTypes[i]));
        }
        sb.append(')');
        return sb.toString();
    }
    
    private MemberBox findExplicitFunction(final String name, final boolean isStatic) {
        final int sigStart = name.indexOf(40);
        if (sigStart < 0) {
            return null;
        }
        final Map<String, Object> ht = isStatic ? this.staticMembers : this.members;
        MemberBox[] methodsOrCtors = null;
        final boolean isCtor = isStatic && sigStart == 0;
        if (isCtor) {
            methodsOrCtors = this.ctors.methods;
        }
        else {
            final String trueName = name.substring(0, sigStart);
            Object obj = ht.get(trueName);
            if (!isStatic && obj == null) {
                obj = this.staticMembers.get(trueName);
            }
            if (obj instanceof NativeJavaMethod) {
                final NativeJavaMethod njm = (NativeJavaMethod)obj;
                methodsOrCtors = njm.methods;
            }
        }
        if (methodsOrCtors != null) {
            for (final MemberBox methodsOrCtor : methodsOrCtors) {
                final Class<?>[] type = methodsOrCtor.argTypes;
                final String sig = liveConnectSignature(type);
                if (sigStart + sig.length() == name.length() && name.regionMatches(sigStart, sig, 0, sig.length())) {
                    return methodsOrCtor;
                }
            }
        }
        return null;
    }
    
    private Object getExplicitFunction(final Scriptable scope, final String name, final Object javaObject, final boolean isStatic) {
        final Map<String, Object> ht = isStatic ? this.staticMembers : this.members;
        Object member = null;
        final MemberBox methodOrCtor = this.findExplicitFunction(name, isStatic);
        if (methodOrCtor != null) {
            final Scriptable prototype = ScriptableObject.getFunctionPrototype(scope);
            if (methodOrCtor.isCtor()) {
                final NativeJavaConstructor fun = new NativeJavaConstructor(methodOrCtor);
                fun.setPrototype(prototype);
                member = fun;
                ht.put(name, fun);
            }
            else {
                final String trueName = methodOrCtor.getName();
                member = ht.get(trueName);
                if (member instanceof NativeJavaMethod && ((NativeJavaMethod)member).methods.length > 1) {
                    final NativeJavaMethod fun2 = new NativeJavaMethod(methodOrCtor, name);
                    fun2.setPrototype(prototype);
                    ht.put(name, fun2);
                    member = fun2;
                }
            }
        }
        return member;
    }
    
    private static Method[] discoverAccessibleMethods(final Class<?> clazz, final boolean includeProtected, final boolean includePrivate) {
        final Map<MethodSignature, Method> map = new HashMap<MethodSignature, Method>();
        discoverAccessibleMethods(clazz, map, includeProtected, includePrivate);
        return map.values().toArray(new Method[map.size()]);
    }
    
    private static void discoverAccessibleMethods(Class<?> clazz, final Map<MethodSignature, Method> map, final boolean includeProtected, final boolean includePrivate) {
        Label_0378: {
            if (!Modifier.isPublic(clazz.getModifiers())) {
                if (!includePrivate) {
                    break Label_0378;
                }
            }
            try {
                Label_0272: {
                    if (includeProtected || includePrivate) {
                        while (clazz != null) {
                            try {
                                final Method[] declaredMethods;
                                final Method[] methods = declaredMethods = clazz.getDeclaredMethods();
                                for (final Method method : declaredMethods) {
                                    final int mods = method.getModifiers();
                                    if (Modifier.isPublic(mods) || Modifier.isProtected(mods) || includePrivate) {
                                        final MethodSignature sig = new MethodSignature(method);
                                        if (!map.containsKey(sig)) {
                                            if (includePrivate && !method.isAccessible()) {
                                                method.setAccessible(true);
                                            }
                                            map.put(sig, method);
                                        }
                                    }
                                }
                                final Class<?>[] interfaces3;
                                final Class<?>[] interfaces = interfaces3 = clazz.getInterfaces();
                                for (final Class<?> intface : interfaces3) {
                                    discoverAccessibleMethods(intface, map, includeProtected, includePrivate);
                                }
                                clazz = clazz.getSuperclass();
                                continue;
                            }
                            catch (SecurityException e) {
                                final Method[] methods3;
                                final Method[] methods2 = methods3 = clazz.getMethods();
                                for (final Method method2 : methods3) {
                                    final MethodSignature sig = new MethodSignature(method2);
                                    if (!map.containsKey(sig)) {
                                        map.put(sig, method2);
                                    }
                                }
                                break;
                            }
                            break Label_0272;
                        }
                        return;
                    }
                }
                final Method[] methods4;
                final Method[] methods = methods4 = clazz.getMethods();
                for (final Method method : methods4) {
                    final MethodSignature sig2 = new MethodSignature(method);
                    if (!map.containsKey(sig2)) {
                        map.put(sig2, method);
                    }
                }
                return;
            }
            catch (SecurityException e) {
                Context.reportWarning("Could not discover accessible methods of class " + clazz.getName() + " due to lack of privileges, attemping superclasses/interfaces.");
            }
        }
        final Class<?>[] interfaces4;
        final Class<?>[] interfaces2 = interfaces4 = clazz.getInterfaces();
        for (final Class<?> intface2 : interfaces4) {
            discoverAccessibleMethods(intface2, map, includeProtected, includePrivate);
        }
        final Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            discoverAccessibleMethods(superclass, map, includeProtected, includePrivate);
        }
    }
    
    private void reflect(final Scriptable scope, final boolean includeProtected, final boolean includePrivate) {
        final Method[] discoverAccessibleMethods;
        final Method[] methods = discoverAccessibleMethods = discoverAccessibleMethods(this.cl, includeProtected, includePrivate);
        for (final Method method : discoverAccessibleMethods) {
            final int mods = method.getModifiers();
            final boolean isStatic = Modifier.isStatic(mods);
            final Map<String, Object> ht = isStatic ? this.staticMembers : this.members;
            final String name = method.getName();
            final Object value = ht.get(name);
            if (value == null) {
                ht.put(name, method);
            }
            else {
                ObjArray overloadedMethods;
                if (value instanceof ObjArray) {
                    overloadedMethods = (ObjArray)value;
                }
                else {
                    if (!(value instanceof Method)) {
                        Kit.codeBug();
                    }
                    overloadedMethods = new ObjArray();
                    overloadedMethods.add(value);
                    ht.put(name, overloadedMethods);
                }
                overloadedMethods.add(method);
            }
        }
        for (int tableCursor = 0; tableCursor != 2; ++tableCursor) {
            final boolean isStatic2 = tableCursor == 0;
            final Map<String, Object> ht2 = isStatic2 ? this.staticMembers : this.members;
            for (final Map.Entry<String, Object> entry : ht2.entrySet()) {
                final Object value2 = entry.getValue();
                MemberBox[] methodBoxes;
                if (value2 instanceof Method) {
                    methodBoxes = new MemberBox[] { new MemberBox((Method)value2) };
                }
                else {
                    final ObjArray overloadedMethods2 = (ObjArray)value2;
                    final int N = overloadedMethods2.size();
                    if (N < 2) {
                        Kit.codeBug();
                    }
                    methodBoxes = new MemberBox[N];
                    for (int i = 0; i != N; ++i) {
                        final Method method2 = (Method)overloadedMethods2.get(i);
                        methodBoxes[i] = new MemberBox(method2);
                    }
                }
                final NativeJavaMethod fun = new NativeJavaMethod(methodBoxes);
                if (scope != null) {
                    ScriptRuntime.setFunctionProtoAndParent(fun, scope);
                }
                ht2.put(entry.getKey(), fun);
            }
        }
        final Field[] accessibleFields;
        final Field[] fields = accessibleFields = this.getAccessibleFields(includeProtected, includePrivate);
        for (final Field field : accessibleFields) {
            final String name2 = field.getName();
            final int mods2 = field.getModifiers();
            try {
                final boolean isStatic3 = Modifier.isStatic(mods2);
                final Map<String, Object> ht3 = isStatic3 ? this.staticMembers : this.members;
                final Object member = ht3.get(name2);
                if (member == null) {
                    ht3.put(name2, field);
                }
                else if (member instanceof NativeJavaMethod) {
                    final NativeJavaMethod method3 = (NativeJavaMethod)member;
                    final FieldAndMethods fam = new FieldAndMethods(scope, method3.methods, field);
                    Map<String, FieldAndMethods> fmht = isStatic3 ? this.staticFieldAndMethods : this.fieldAndMethods;
                    if (fmht == null) {
                        fmht = new HashMap<String, FieldAndMethods>();
                        if (isStatic3) {
                            this.staticFieldAndMethods = fmht;
                        }
                        else {
                            this.fieldAndMethods = fmht;
                        }
                    }
                    fmht.put(name2, fam);
                    ht3.put(name2, fam);
                }
                else if (member instanceof Field) {
                    final Field oldField = (Field)member;
                    if (oldField.getDeclaringClass().isAssignableFrom(field.getDeclaringClass())) {
                        ht3.put(name2, field);
                    }
                }
                else {
                    Kit.codeBug();
                }
            }
            catch (SecurityException e) {
                Context.reportWarning("Could not access field " + name2 + " of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        for (int tableCursor2 = 0; tableCursor2 != 2; ++tableCursor2) {
            final boolean isStatic4 = tableCursor2 == 0;
            final Map<String, Object> ht4 = isStatic4 ? this.staticMembers : this.members;
            final Map<String, BeanProperty> toAdd = new HashMap<String, BeanProperty>();
            for (final String name3 : ht4.keySet()) {
                final boolean memberIsGetMethod = name3.startsWith("get");
                final boolean memberIsSetMethod = name3.startsWith("set");
                final boolean memberIsIsMethod = name3.startsWith("is");
                if (memberIsGetMethod || memberIsIsMethod || memberIsSetMethod) {
                    final String nameComponent = name3.substring(memberIsIsMethod ? 2 : 3);
                    if (nameComponent.length() == 0) {
                        continue;
                    }
                    String beanPropertyName = nameComponent;
                    final char ch0 = nameComponent.charAt(0);
                    if (Character.isUpperCase(ch0)) {
                        if (nameComponent.length() == 1) {
                            beanPropertyName = nameComponent.toLowerCase();
                        }
                        else {
                            final char ch2 = nameComponent.charAt(1);
                            if (!Character.isUpperCase(ch2)) {
                                beanPropertyName = Character.toLowerCase(ch0) + nameComponent.substring(1);
                            }
                        }
                    }
                    if (toAdd.containsKey(beanPropertyName)) {
                        continue;
                    }
                    final Object v = ht4.get(beanPropertyName);
                    if (v != null) {
                        if (!includePrivate || !(v instanceof Member)) {
                            continue;
                        }
                        if (!Modifier.isPrivate(((Member)v).getModifiers())) {
                            continue;
                        }
                    }
                    MemberBox getter = null;
                    getter = this.findGetter(isStatic4, ht4, "get", nameComponent);
                    if (getter == null) {
                        getter = this.findGetter(isStatic4, ht4, "is", nameComponent);
                    }
                    MemberBox setter = null;
                    NativeJavaMethod setters = null;
                    final String setterName = "set".concat(nameComponent);
                    if (ht4.containsKey(setterName)) {
                        final Object member2 = ht4.get(setterName);
                        if (member2 instanceof NativeJavaMethod) {
                            final NativeJavaMethod njmSet = (NativeJavaMethod)member2;
                            if (getter != null) {
                                final Class<?> type = getter.method().getReturnType();
                                setter = extractSetMethod(type, njmSet.methods, isStatic4);
                            }
                            else {
                                setter = extractSetMethod(njmSet.methods, isStatic4);
                            }
                            if (njmSet.methods.length > 1) {
                                setters = njmSet;
                            }
                        }
                    }
                    final BeanProperty bp = new BeanProperty(getter, setter, setters);
                    toAdd.put(beanPropertyName, bp);
                }
            }
            for (final String key : toAdd.keySet()) {
                final Object value3 = toAdd.get(key);
                ht4.put(key, value3);
            }
        }
        final Constructor<?>[] constructors = this.getAccessibleConstructors(includePrivate);
        final MemberBox[] ctorMembers = new MemberBox[constructors.length];
        for (int j = 0; j != constructors.length; ++j) {
            ctorMembers[j] = new MemberBox(constructors[j]);
        }
        this.ctors = new NativeJavaMethod(ctorMembers, this.cl.getSimpleName());
    }
    
    private Constructor<?>[] getAccessibleConstructors(final boolean includePrivate) {
        if (includePrivate && this.cl != ScriptRuntime.ClassClass) {
            try {
                final Constructor<?>[] cons = this.cl.getDeclaredConstructors();
                AccessibleObject.setAccessible(cons, true);
                return cons;
            }
            catch (SecurityException e) {
                Context.reportWarning("Could not access constructor  of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        return this.cl.getConstructors();
    }
    
    private Field[] getAccessibleFields(final boolean includeProtected, final boolean includePrivate) {
        if (!includePrivate) {
            if (!includeProtected) {
                return this.cl.getFields();
            }
        }
        try {
            final List<Field> fieldsList = new ArrayList<Field>();
            for (Class<?> currentClass = this.cl; currentClass != null; currentClass = currentClass.getSuperclass()) {
                final Field[] declaredFields;
                final Field[] declared = declaredFields = currentClass.getDeclaredFields();
                for (final Field field : declaredFields) {
                    final int mod = field.getModifiers();
                    if (includePrivate || Modifier.isPublic(mod) || Modifier.isProtected(mod)) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        fieldsList.add(field);
                    }
                }
            }
            return fieldsList.toArray(new Field[fieldsList.size()]);
        }
        catch (SecurityException ex) {}
        return this.cl.getFields();
    }
    
    private MemberBox findGetter(final boolean isStatic, final Map<String, Object> ht, final String prefix, final String propertyName) {
        final String getterName = prefix.concat(propertyName);
        if (ht.containsKey(getterName)) {
            final Object member = ht.get(getterName);
            if (member instanceof NativeJavaMethod) {
                final NativeJavaMethod njmGet = (NativeJavaMethod)member;
                return extractGetMethod(njmGet.methods, isStatic);
            }
        }
        return null;
    }
    
    private static MemberBox extractGetMethod(final MemberBox[] methods, final boolean isStatic) {
        final int length = methods.length;
        int i = 0;
        while (i < length) {
            final MemberBox method = methods[i];
            if (method.argTypes.length == 0 && (!isStatic || method.isStatic())) {
                final Class<?> type = method.method().getReturnType();
                if (type != Void.TYPE) {
                    return method;
                }
                break;
            }
            else {
                ++i;
            }
        }
        return null;
    }
    
    private static MemberBox extractSetMethod(final Class<?> type, final MemberBox[] methods, final boolean isStatic) {
        for (int pass = 1; pass <= 2; ++pass) {
            for (final MemberBox method : methods) {
                if (!isStatic || method.isStatic()) {
                    final Class<?>[] params = method.argTypes;
                    if (params.length == 1) {
                        if (pass == 1) {
                            if (params[0] == type) {
                                return method;
                            }
                        }
                        else {
                            if (pass != 2) {
                                Kit.codeBug();
                            }
                            if (params[0].isAssignableFrom(type)) {
                                return method;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    private static MemberBox extractSetMethod(final MemberBox[] methods, final boolean isStatic) {
        for (final MemberBox method : methods) {
            if ((!isStatic || method.isStatic()) && method.method().getReturnType() == Void.TYPE && method.argTypes.length == 1) {
                return method;
            }
        }
        return null;
    }
    
    Map<String, FieldAndMethods> getFieldAndMethodsObjects(final Scriptable scope, final Object javaObject, final boolean isStatic) {
        final Map<String, FieldAndMethods> ht = isStatic ? this.staticFieldAndMethods : this.fieldAndMethods;
        if (ht == null) {
            return null;
        }
        final int len = ht.size();
        final Map<String, FieldAndMethods> result = new HashMap<String, FieldAndMethods>(len);
        for (final FieldAndMethods fam : ht.values()) {
            final FieldAndMethods famNew = new FieldAndMethods(scope, fam.methods, fam.field);
            famNew.javaObject = javaObject;
            result.put(fam.field.getName(), famNew);
        }
        return result;
    }
    
    static JavaMembers lookupClass(final Scriptable scope, final Class<?> dynamicType, Class<?> staticType, final boolean includeProtected) {
        final ClassCache cache = ClassCache.get(scope);
        final Map<Class<?>, JavaMembers> ct = (Map<Class<?>, JavaMembers>)cache.getClassCacheMap();
        Class<?> cl = dynamicType;
        while (true) {
            JavaMembers members = ct.get(cl);
            if (members != null) {
                if (cl != dynamicType) {
                    ct.put(dynamicType, members);
                }
                return members;
            }
            try {
                members = new JavaMembers(cache.getAssociatedScope(), cl, includeProtected);
            }
            catch (SecurityException e) {
                if (staticType != null && staticType.isInterface()) {
                    cl = staticType;
                    staticType = null;
                }
                else {
                    Class<?> parent = cl.getSuperclass();
                    if (parent == null) {
                        if (!cl.isInterface()) {
                            throw e;
                        }
                        parent = ScriptRuntime.ObjectClass;
                    }
                    cl = parent;
                }
                continue;
            }
            if (cache.isCachingEnabled()) {
                ct.put(cl, members);
                if (cl != dynamicType) {
                    ct.put(dynamicType, members);
                }
            }
            return members;
        }
    }
    
    RuntimeException reportMemberNotFound(final String memberName) {
        return (RuntimeException)Context.reportRuntimeError2("msg.java.member.not.found", (Object)this.cl.getName(), (Object)memberName);
    }
    
    private static final class MethodSignature
    {
        private final String name;
        private final Class<?>[] args;
        
        private MethodSignature(final String name, final Class<?>[] args) {
            this.name = name;
            this.args = args;
        }
        
        MethodSignature(final Method method) {
            this(method.getName(), method.getParameterTypes());
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o instanceof MethodSignature) {
                final MethodSignature ms = (MethodSignature)o;
                return ms.name.equals(this.name) && Arrays.equals(this.args, ms.args);
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.name.hashCode() ^ this.args.length;
        }
    }
}
