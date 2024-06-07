//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.concurrent.*;
import java.lang.reflect.*;
import java.util.*;

public class NativeJavaMethod extends BaseFunction
{
    private static final long serialVersionUID = -3440381785576412928L;
    private static final int PREFERENCE_EQUAL = 0;
    private static final int PREFERENCE_FIRST_ARG = 1;
    private static final int PREFERENCE_SECOND_ARG = 2;
    private static final int PREFERENCE_AMBIGUOUS = 3;
    private static final boolean debug = false;
    MemberBox[] methods;
    private String functionName;
    private transient CopyOnWriteArrayList<ResolvedOverload> overloadCache;
    
    NativeJavaMethod(final MemberBox[] methods) {
        this.functionName = methods[0].getName();
        this.methods = methods;
    }
    
    NativeJavaMethod(final MemberBox[] methods, final String name) {
        this.functionName = name;
        this.methods = methods;
    }
    
    NativeJavaMethod(final MemberBox method, final String name) {
        this.functionName = name;
        this.methods = new MemberBox[] { method };
    }
    
    public NativeJavaMethod(final Method method, final String name) {
        this(new MemberBox(method), name);
    }
    
    public String getFunctionName() {
        return this.functionName;
    }
    
    static String scriptSignature(final Object[] values) {
        final StringBuilder sig = new StringBuilder();
        for (int i = 0; i != values.length; ++i) {
            final Object value = values[i];
            String s;
            if (value == null) {
                s = "null";
            }
            else if (value instanceof Boolean) {
                s = "boolean";
            }
            else if (value instanceof String) {
                s = "string";
            }
            else if (value instanceof Number) {
                s = "number";
            }
            else if (value instanceof Scriptable) {
                if (value instanceof Undefined) {
                    s = "undefined";
                }
                else if (value instanceof Wrapper) {
                    final Object wrapped = ((Wrapper)value).unwrap();
                    s = wrapped.getClass().getName();
                }
                else if (value instanceof Function) {
                    s = "function";
                }
                else {
                    s = "object";
                }
            }
            else {
                s = JavaMembers.javaSignature((Class)value.getClass());
            }
            if (i != 0) {
                sig.append(',');
            }
            sig.append(s);
        }
        return sig.toString();
    }
    
    String decompile(final int indent, final int flags) {
        final StringBuilder sb = new StringBuilder();
        final boolean justbody = 0x0 != (flags & 0x1);
        if (!justbody) {
            sb.append("function ");
            sb.append(this.getFunctionName());
            sb.append("() {");
        }
        sb.append("/*\n");
        sb.append(this.toString());
        sb.append(justbody ? "*/\n" : "*/}\n");
        return sb.toString();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0, N = this.methods.length; i != N; ++i) {
            if (this.methods[i].isMethod()) {
                final Method method = this.methods[i].method();
                sb.append(JavaMembers.javaSignature((Class)method.getReturnType()));
                sb.append(' ');
                sb.append(method.getName());
            }
            else {
                sb.append(this.methods[i].getName());
            }
            sb.append(JavaMembers.liveConnectSignature(this.methods[i].argTypes));
            sb.append('\n');
        }
        return sb.toString();
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, Object[] args) {
        if (this.methods.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        final int index = this.findCachedFunction(cx, args);
        if (index < 0) {
            final Class<?> c = this.methods[0].method().getDeclaringClass();
            final String sig = c.getName() + '.' + this.getFunctionName() + '(' + scriptSignature(args) + ')';
            throw Context.reportRuntimeError1("msg.java.no_such_method", (Object)sig);
        }
        final MemberBox meth = this.methods[index];
        final Class<?>[] argTypes = (Class<?>[])meth.argTypes;
        if (meth.vararg) {
            final Object[] newArgs = new Object[argTypes.length];
            for (int i = 0; i < argTypes.length - 1; ++i) {
                newArgs[i] = Context.jsToJava(args[i], (Class)argTypes[i]);
            }
            Object varArgs;
            if (args.length == argTypes.length && (args[args.length - 1] == null || args[args.length - 1] instanceof NativeArray || args[args.length - 1] instanceof NativeJavaArray)) {
                varArgs = Context.jsToJava(args[args.length - 1], (Class)argTypes[argTypes.length - 1]);
            }
            else {
                final Class<?> componentType = argTypes[argTypes.length - 1].getComponentType();
                varArgs = Array.newInstance(componentType, args.length - argTypes.length + 1);
                for (int j = 0; j < Array.getLength(varArgs); ++j) {
                    final Object value = Context.jsToJava(args[argTypes.length - 1 + j], (Class)componentType);
                    Array.set(varArgs, j, value);
                }
            }
            newArgs[argTypes.length - 1] = varArgs;
            args = newArgs;
        }
        else {
            final Object[] origArgs = args;
            for (int i = 0; i < args.length; ++i) {
                final Object arg = args[i];
                final Object coerced = Context.jsToJava(arg, (Class)argTypes[i]);
                if (coerced != arg) {
                    if (origArgs == args) {
                        args = args.clone();
                    }
                    args[i] = coerced;
                }
            }
        }
        Object javaObject = null;
        Label_0501: {
            if (!meth.isStatic()) {
                Scriptable o = thisObj;
                final Class<?> c2 = (Class<?>)meth.getDeclaringClass();
                while (o != null) {
                    if (o instanceof Wrapper) {
                        javaObject = ((Wrapper)o).unwrap();
                        if (c2.isInstance(javaObject)) {
                            break Label_0501;
                        }
                    }
                    o = o.getPrototype();
                }
                throw Context.reportRuntimeError3("msg.nonjava.method", (Object)this.getFunctionName(), (Object)ScriptRuntime.toString(thisObj), (Object)c2.getName());
            }
            javaObject = null;
        }
        final Object retval = meth.invoke(javaObject, args);
        final Class<?> staticType = meth.method().getReturnType();
        Object wrapped = cx.getWrapFactory().wrap(cx, scope, retval, staticType);
        if (wrapped == null && staticType == Void.TYPE) {
            wrapped = Undefined.instance;
        }
        return wrapped;
    }
    
    int findCachedFunction(final Context cx, final Object[] args) {
        if (this.methods.length > 1) {
            if (this.overloadCache != null) {
                for (final ResolvedOverload ovl : this.overloadCache) {
                    if (ovl.matches(args)) {
                        return ovl.index;
                    }
                }
            }
            else {
                this.overloadCache = new CopyOnWriteArrayList<ResolvedOverload>();
            }
            final int index = findFunction(cx, this.methods, args);
            if (this.overloadCache.size() < this.methods.length * 2) {
                synchronized (this.overloadCache) {
                    final ResolvedOverload ovl2 = new ResolvedOverload(args, index);
                    if (!this.overloadCache.contains(ovl2)) {
                        this.overloadCache.add(0, ovl2);
                    }
                }
            }
            return index;
        }
        return findFunction(cx, this.methods, args);
    }
    
    static int findFunction(final Context cx, final MemberBox[] methodsOrCtors, final Object[] args) {
        if (methodsOrCtors.length == 0) {
            return -1;
        }
        if (methodsOrCtors.length == 1) {
            final MemberBox member = methodsOrCtors[0];
            final Class<?>[] argTypes = (Class<?>[])member.argTypes;
            int alength = argTypes.length;
            if (member.vararg) {
                if (--alength > args.length) {
                    return -1;
                }
            }
            else if (alength != args.length) {
                return -1;
            }
            for (int j = 0; j != alength; ++j) {
                if (!NativeJavaObject.canConvert(args[j], argTypes[j])) {
                    return -1;
                }
            }
            return 0;
        }
        int firstBestFit = -1;
        int[] extraBestFits = null;
        int extraBestFitsCount = 0;
    Label_0455:
        for (int i = 0; i < methodsOrCtors.length; ++i) {
            final MemberBox member2 = methodsOrCtors[i];
            final Class<?>[] argTypes2 = (Class<?>[])member2.argTypes;
            int alength2 = argTypes2.length;
            if (member2.vararg) {
                if (--alength2 > args.length) {
                    continue;
                }
            }
            else if (alength2 != args.length) {
                continue;
            }
            for (int k = 0; k < alength2; ++k) {
                if (!NativeJavaObject.canConvert(args[k], argTypes2[k])) {
                    continue Label_0455;
                }
            }
            if (firstBestFit < 0) {
                firstBestFit = i;
            }
            else {
                int betterCount = 0;
                int worseCount = 0;
                for (int l = -1; l != extraBestFitsCount; ++l) {
                    int bestFitIndex;
                    if (l == -1) {
                        bestFitIndex = firstBestFit;
                    }
                    else {
                        bestFitIndex = extraBestFits[l];
                    }
                    final MemberBox bestFit = methodsOrCtors[bestFitIndex];
                    if (cx.hasFeature(12) && bestFit.isPublic() != member2.isPublic()) {
                        if (!bestFit.isPublic()) {
                            ++betterCount;
                        }
                        else {
                            ++worseCount;
                        }
                    }
                    else {
                        final int preference = preferSignature(args, argTypes2, member2.vararg, bestFit.argTypes, bestFit.vararg);
                        if (preference == 3) {
                            break;
                        }
                        if (preference == 1) {
                            ++betterCount;
                        }
                        else if (preference == 2) {
                            ++worseCount;
                        }
                        else {
                            if (preference != 0) {
                                Kit.codeBug();
                            }
                            if (!bestFit.isStatic() || !bestFit.getDeclaringClass().isAssignableFrom(member2.getDeclaringClass())) {
                                continue Label_0455;
                            }
                            if (l == -1) {
                                firstBestFit = i;
                                continue Label_0455;
                            }
                            extraBestFits[l] = i;
                            continue Label_0455;
                        }
                    }
                }
                if (betterCount == 1 + extraBestFitsCount) {
                    firstBestFit = i;
                    extraBestFitsCount = 0;
                }
                else if (worseCount != 1 + extraBestFitsCount) {
                    if (extraBestFits == null) {
                        extraBestFits = new int[methodsOrCtors.length - 1];
                    }
                    extraBestFits[extraBestFitsCount] = i;
                    ++extraBestFitsCount;
                }
            }
        }
        if (firstBestFit < 0) {
            return -1;
        }
        if (extraBestFitsCount == 0) {
            return firstBestFit;
        }
        final StringBuilder buf = new StringBuilder();
        for (int m = -1; m != extraBestFitsCount; ++m) {
            int bestFitIndex2;
            if (m == -1) {
                bestFitIndex2 = firstBestFit;
            }
            else {
                bestFitIndex2 = extraBestFits[m];
            }
            buf.append("\n    ");
            buf.append(methodsOrCtors[bestFitIndex2].toJavaDeclaration());
        }
        final MemberBox firstFitMember = methodsOrCtors[firstBestFit];
        final String memberName = firstFitMember.getName();
        final String memberClass = firstFitMember.getDeclaringClass().getName();
        if (methodsOrCtors[0].isCtor()) {
            throw Context.reportRuntimeError3("msg.constructor.ambiguous", (Object)memberName, (Object)scriptSignature(args), (Object)buf.toString());
        }
        throw Context.reportRuntimeError4("msg.method.ambiguous", (Object)memberClass, (Object)memberName, (Object)scriptSignature(args), (Object)buf.toString());
    }
    
    private static int preferSignature(final Object[] args, final Class<?>[] sig1, final boolean vararg1, final Class<?>[] sig2, final boolean vararg2) {
        int totalPreference = 0;
        for (int j = 0; j < args.length; ++j) {
            final Class<?> type1 = (vararg1 && j >= sig1.length) ? sig1[sig1.length - 1] : sig1[j];
            final Class<?> type2 = (vararg2 && j >= sig2.length) ? sig2[sig2.length - 1] : sig2[j];
            if (type1 != type2) {
                final Object arg = args[j];
                final int rank1 = NativeJavaObject.getConversionWeight(arg, type1);
                final int rank2 = NativeJavaObject.getConversionWeight(arg, type2);
                int preference;
                if (rank1 < rank2) {
                    preference = 1;
                }
                else if (rank1 > rank2) {
                    preference = 2;
                }
                else if (rank1 == 0) {
                    if (type1.isAssignableFrom(type2)) {
                        preference = 2;
                    }
                    else if (type2.isAssignableFrom(type1)) {
                        preference = 1;
                    }
                    else {
                        preference = 3;
                    }
                }
                else {
                    preference = 3;
                }
                totalPreference |= preference;
                if (totalPreference == 3) {
                    break;
                }
            }
        }
        return totalPreference;
    }
    
    private static void printDebug(final String msg, final MemberBox member, final Object[] args) {
    }
}
