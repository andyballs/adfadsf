//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;
import java.io.*;

final class MemberBox implements Serializable
{
    private static final long serialVersionUID = 6358550398665688245L;
    private transient Member memberObject;
    transient Class<?>[] argTypes;
    transient Object delegateTo;
    transient boolean vararg;
    private static final Class<?>[] primitives;
    
    MemberBox(final Method method) {
        this.init(method);
    }
    
    MemberBox(final Constructor<?> constructor) {
        this.init(constructor);
    }
    
    private void init(final Method method) {
        this.memberObject = method;
        this.argTypes = method.getParameterTypes();
        this.vararg = method.isVarArgs();
    }
    
    private void init(final Constructor<?> constructor) {
        this.memberObject = constructor;
        this.argTypes = constructor.getParameterTypes();
        this.vararg = constructor.isVarArgs();
    }
    
    Method method() {
        return (Method)this.memberObject;
    }
    
    Constructor<?> ctor() {
        return (Constructor<?>)this.memberObject;
    }
    
    Member member() {
        return this.memberObject;
    }
    
    boolean isMethod() {
        return this.memberObject instanceof Method;
    }
    
    boolean isCtor() {
        return this.memberObject instanceof Constructor;
    }
    
    boolean isStatic() {
        return Modifier.isStatic(this.memberObject.getModifiers());
    }
    
    boolean isPublic() {
        return Modifier.isPublic(this.memberObject.getModifiers());
    }
    
    String getName() {
        return this.memberObject.getName();
    }
    
    Class<?> getDeclaringClass() {
        return this.memberObject.getDeclaringClass();
    }
    
    String toJavaDeclaration() {
        final StringBuilder sb = new StringBuilder();
        if (this.isMethod()) {
            final Method method = this.method();
            sb.append(method.getReturnType());
            sb.append(' ');
            sb.append(method.getName());
        }
        else {
            final Constructor<?> ctor = this.ctor();
            String name = ctor.getDeclaringClass().getName();
            final int lastDot = name.lastIndexOf(46);
            if (lastDot >= 0) {
                name = name.substring(lastDot + 1);
            }
            sb.append(name);
        }
        sb.append(JavaMembers.liveConnectSignature((Class[])this.argTypes));
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return this.memberObject.toString();
    }
    
    Object invoke(final Object target, final Object[] args) {
        Method method = this.method();
        try {
            try {
                return method.invoke(target, args);
            }
            catch (IllegalAccessException ex) {
                final Method accessible = searchAccessibleMethod(method, this.argTypes);
                if (accessible != null) {
                    this.memberObject = accessible;
                    method = accessible;
                }
                else if (!VMBridge.instance.tryToMakeAccessible(method)) {
                    throw Context.throwAsScriptRuntimeEx((Throwable)ex);
                }
                return method.invoke(target, args);
            }
        }
        catch (InvocationTargetException ite) {
            Throwable e = ite;
            do {
                e = ((InvocationTargetException)e).getTargetException();
            } while (e instanceof InvocationTargetException);
            if (e instanceof ContinuationPending) {
                throw (ContinuationPending)e;
            }
            throw Context.throwAsScriptRuntimeEx(e);
        }
        catch (Exception ex2) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex2);
        }
    }
    
    Object newInstance(final Object[] args) {
        final Constructor<?> ctor = this.ctor();
        try {
            try {
                return ctor.newInstance(args);
            }
            catch (IllegalAccessException ex) {
                if (!VMBridge.instance.tryToMakeAccessible(ctor)) {
                    throw Context.throwAsScriptRuntimeEx((Throwable)ex);
                }
                return ctor.newInstance(args);
            }
        }
        catch (Exception ex2) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex2);
        }
    }
    
    private static Method searchAccessibleMethod(final Method method, final Class<?>[] params) {
        final int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers)) {
            Class<?> c = method.getDeclaringClass();
            if (!Modifier.isPublic(c.getModifiers())) {
                final String name = method.getName();
                final Class<?>[] intfs = c.getInterfaces();
                for (int i = 0, N = intfs.length; i != N; ++i) {
                    final Class<?> intf = intfs[i];
                    if (Modifier.isPublic(intf.getModifiers())) {
                        try {
                            return intf.getMethod(name, params);
                        }
                        catch (NoSuchMethodException ex) {}
                        catch (SecurityException ex2) {}
                    }
                }
                while (true) {
                    c = c.getSuperclass();
                    if (c == null) {
                        break;
                    }
                    if (!Modifier.isPublic(c.getModifiers())) {
                        continue;
                    }
                    try {
                        final Method m = c.getMethod(name, params);
                        final int mModifiers = m.getModifiers();
                        if (Modifier.isPublic(mModifiers) && !Modifier.isStatic(mModifiers)) {
                            return m;
                        }
                        continue;
                    }
                    catch (NoSuchMethodException ex3) {}
                    catch (SecurityException ex4) {}
                }
            }
        }
        return null;
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        final Member member = readMember(in);
        if (member instanceof Method) {
            this.init((Method)member);
        }
        else {
            this.init((Constructor<?>)member);
        }
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        writeMember(out, this.memberObject);
    }
    
    private static void writeMember(final ObjectOutputStream out, final Member member) throws IOException {
        if (member == null) {
            out.writeBoolean(false);
            return;
        }
        out.writeBoolean(true);
        if (!(member instanceof Method) && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("not Method or Constructor");
        }
        out.writeBoolean(member instanceof Method);
        out.writeObject(member.getName());
        out.writeObject(member.getDeclaringClass());
        if (member instanceof Method) {
            writeParameters(out, ((Method)member).getParameterTypes());
        }
        else {
            writeParameters(out, ((Constructor)member).getParameterTypes());
        }
    }
    
    private static Member readMember(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        if (!in.readBoolean()) {
            return null;
        }
        final boolean isMethod = in.readBoolean();
        final String name = (String)in.readObject();
        final Class<?> declaring = (Class<?>)in.readObject();
        final Class<?>[] parms = readParameters(in);
        try {
            if (isMethod) {
                return declaring.getMethod(name, parms);
            }
            return declaring.getConstructor(parms);
        }
        catch (NoSuchMethodException e) {
            throw new IOException("Cannot find member: " + e);
        }
    }
    
    private static void writeParameters(final ObjectOutputStream out, final Class<?>[] parms) throws IOException {
        out.writeShort(parms.length);
    Label_0117:
        for (int i = 0; i < parms.length; ++i) {
            final Class<?> parm = parms[i];
            final boolean primitive = parm.isPrimitive();
            out.writeBoolean(primitive);
            if (primitive) {
                for (int j = 0; j < MemberBox.primitives.length; ++j) {
                    if (parm.equals(MemberBox.primitives[j])) {
                        out.writeByte(j);
                        continue Label_0117;
                    }
                }
                throw new IllegalArgumentException("Primitive " + parm + " not found");
            }
            out.writeObject(parm);
        }
    }
    
    private static Class<?>[] readParameters(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        final Class<?>[] result = (Class<?>[])new Class[in.readShort()];
        for (int i = 0; i < result.length; ++i) {
            if (!in.readBoolean()) {
                result[i] = (Class<?>)in.readObject();
            }
            else {
                result[i] = MemberBox.primitives[in.readByte()];
            }
        }
        return result;
    }
    
    static {
        primitives = new Class[] { Boolean.TYPE, Byte.TYPE, Character.TYPE, Double.TYPE, Float.TYPE, Integer.TYPE, Long.TYPE, Short.TYPE, Void.TYPE };
    }
}
