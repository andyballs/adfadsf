//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public final class NativeContinuation extends IdScriptableObject implements Function
{
    private static final long serialVersionUID = 1794167133757605367L;
    private static final Object FTAG;
    private Object implementation;
    private static final int Id_constructor = 1;
    private static final int MAX_PROTOTYPE_ID = 1;
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeContinuation obj = new NativeContinuation();
        obj.exportAsJSClass(1, scope, sealed);
    }
    
    public Object getImplementation() {
        return this.implementation;
    }
    
    public void initImplementation(final Object implementation) {
        this.implementation = implementation;
    }
    
    public String getClassName() {
        return "Continuation";
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        throw Context.reportRuntimeError("Direct call is not supported");
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return Interpreter.restartContinuation(this, cx, scope, args);
    }
    
    public static boolean isContinuationConstructor(final IdFunctionObject f) {
        return f.hasTag(NativeContinuation.FTAG) && f.methodId() == 1;
    }
    
    public static boolean equalImplementations(final NativeContinuation c1, final NativeContinuation c2) {
        return Objects.equals(c1.implementation, c2.implementation);
    }
    
    protected void initPrototypeId(final int id) {
        switch (id) {
            case 1: {
                final int arity = 0;
                final String s = "constructor";
                this.initPrototypeMethod(NativeContinuation.FTAG, id, s, arity);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeContinuation.FTAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                throw Context.reportRuntimeError("Direct call is not supported");
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        if (s.length() == 11) {
            X = "constructor";
            id = 1;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        FTAG = "Continuation";
    }
}
