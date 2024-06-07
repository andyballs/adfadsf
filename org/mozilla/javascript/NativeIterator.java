//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public final class NativeIterator extends IdScriptableObject
{
    private static final long serialVersionUID = -4136968203581667681L;
    private static final Object ITERATOR_TAG;
    private static final String STOP_ITERATION = "StopIteration";
    public static final String ITERATOR_PROPERTY_NAME = "__iterator__";
    private static final int Id_constructor = 1;
    private static final int Id_next = 2;
    private static final int Id___iterator__ = 3;
    private static final int MAX_PROTOTYPE_ID = 3;
    private Object objectIterator;
    
    static void init(final ScriptableObject scope, final boolean sealed) {
        final NativeIterator iterator = new NativeIterator();
        iterator.exportAsJSClass(3, (Scriptable)scope, sealed);
        final NativeObject obj = new StopIteration();
        obj.setPrototype(getObjectPrototype((Scriptable)scope));
        obj.setParentScope((Scriptable)scope);
        if (sealed) {
            obj.sealObject();
        }
        ScriptableObject.defineProperty(scope, "StopIteration", obj, 2);
        scope.associateValue(NativeIterator.ITERATOR_TAG, obj);
    }
    
    private NativeIterator() {
    }
    
    private NativeIterator(final Object objectIterator) {
        this.objectIterator = objectIterator;
    }
    
    public static Object getStopIterationObject(final Scriptable scope) {
        final Scriptable top = ScriptableObject.getTopLevelScope(scope);
        return ScriptableObject.getTopScopeValue(top, NativeIterator.ITERATOR_TAG);
    }
    
    public String getClassName() {
        return "Iterator";
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 2;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 0;
                s = "next";
                break;
            }
            case 3: {
                arity = 1;
                s = "__iterator__";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeIterator.ITERATOR_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeIterator.ITERATOR_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        if (id == 1) {
            return jsConstructor(cx, scope, thisObj, args);
        }
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeIterator)) {
            throw incompatibleCallError(f);
        }
        final NativeIterator iterator = (NativeIterator)unwrappedThis;
        switch (id) {
            case 2: {
                return iterator.next(cx, scope);
            }
            case 3: {
                return thisObj;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private static Object jsConstructor(final Context cx, Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (args.length == 0 || args[0] == null || args[0] == Undefined.instance) {
            final Object argument = (args.length == 0) ? Undefined.instance : args[0];
            throw ScriptRuntime.typeError1("msg.no.properties", ScriptRuntime.toString(argument));
        }
        final Scriptable obj = ScriptRuntime.toObject(cx, scope, args[0]);
        final boolean keyOnly = args.length > 1 && ScriptRuntime.toBoolean(args[1]);
        if (thisObj != null) {
            final Iterator<?> iterator = getJavaIterator(obj);
            if (iterator != null) {
                scope = ScriptableObject.getTopLevelScope(scope);
                return cx.getWrapFactory().wrap(cx, scope, new WrappedJavaIterator(iterator, scope), WrappedJavaIterator.class);
            }
            final Scriptable jsIterator = (Scriptable)ScriptRuntime.toIterator(cx, scope, obj, keyOnly);
            if (jsIterator != null) {
                return jsIterator;
            }
        }
        final Object objectIterator = ScriptRuntime.enumInit(obj, cx, scope, keyOnly ? 3 : 5);
        ScriptRuntime.setEnumNumbers(objectIterator, true);
        final NativeIterator result = new NativeIterator(objectIterator);
        result.setPrototype(ScriptableObject.getClassPrototype(scope, result.getClassName()));
        result.setParentScope(scope);
        return result;
    }
    
    private Object next(final Context cx, final Scriptable scope) {
        final Boolean b = ScriptRuntime.enumNext(this.objectIterator);
        if (!b) {
            throw new JavaScriptException(getStopIterationObject(scope), (String)null, 0);
        }
        return ScriptRuntime.enumId(this.objectIterator, cx);
    }
    
    private static Iterator<?> getJavaIterator(final Object obj) {
        if (obj instanceof Wrapper) {
            final Object unwrapped = ((Wrapper)obj).unwrap();
            Iterator<?> iterator = null;
            if (unwrapped instanceof Iterator) {
                iterator = (Iterator<?>)unwrapped;
            }
            if (unwrapped instanceof Iterable) {
                iterator = ((Iterable)unwrapped).iterator();
            }
            return iterator;
        }
        return null;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 4) {
            X = "next";
            id = 2;
        }
        else if (s_length == 11) {
            X = "constructor";
            id = 1;
        }
        else if (s_length == 12) {
            X = "__iterator__";
            id = 3;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        ITERATOR_TAG = "Iterator";
    }
    
    static class StopIteration extends NativeObject
    {
        private static final long serialVersionUID = 2485151085722377663L;
        
        @Override
        public String getClassName() {
            return "StopIteration";
        }
        
        public boolean hasInstance(final Scriptable instance) {
            return instance instanceof StopIteration;
        }
    }
    
    public static class WrappedJavaIterator
    {
        private Iterator<?> iterator;
        private Scriptable scope;
        
        WrappedJavaIterator(final Iterator<?> iterator, final Scriptable scope) {
            this.iterator = iterator;
            this.scope = scope;
        }
        
        public Object next() {
            if (!this.iterator.hasNext()) {
                throw new JavaScriptException(NativeIterator.getStopIterationObject(this.scope), (String)null, 0);
            }
            return this.iterator.next();
        }
        
        public Object __iterator__(final boolean b) {
            return this;
        }
    }
}
