//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public abstract class ES6Iterator extends IdScriptableObject
{
    private static final long serialVersionUID = 2438373029140003950L;
    protected boolean exhausted;
    private String tag;
    private static final int Id_next = 1;
    private static final int SymbolId_iterator = 2;
    private static final int SymbolId_toStringTag = 3;
    private static final int MAX_PROTOTYPE_ID = 3;
    public static final String NEXT_METHOD = "next";
    public static final String DONE_PROPERTY = "done";
    public static final String VALUE_PROPERTY = "value";
    
    public static void init(final ScriptableObject scope, final boolean sealed, final IdScriptableObject prototype, final String tag) {
        if (scope != null) {
            prototype.setParentScope(scope);
            prototype.setPrototype(ScriptableObject.getObjectPrototype(scope));
        }
        prototype.activatePrototypeMap(3);
        if (sealed) {
            prototype.sealObject();
        }
        if (scope != null) {
            scope.associateValue(tag, prototype);
        }
    }
    
    public ES6Iterator() {
        this.exhausted = false;
    }
    
    public ES6Iterator(final Scriptable scope, final String tag) {
        this.exhausted = false;
        this.tag = tag;
        final Scriptable top = ScriptableObject.getTopLevelScope(scope);
        this.setParentScope(top);
        final IdScriptableObject prototype = (IdScriptableObject)ScriptableObject.getTopScopeValue(top, tag);
        this.setPrototype(prototype);
    }
    
    @Override
    protected void initPrototypeId(final int id) {
        switch (id) {
            case 1: {
                this.initPrototypeMethod(this.getTag(), id, "next", 0);
            }
            case 2: {
                this.initPrototypeMethod(this.getTag(), id, SymbolKey.ITERATOR, "[Symbol.iterator]", 3);
            }
            case 3: {
                this.initPrototypeValue(3, SymbolKey.TO_STRING_TAG, this.getClassName(), 3);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    @Override
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(this.getTag())) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof ES6Iterator)) {
            throw IdScriptableObject.incompatibleCallError(f);
        }
        final ES6Iterator iterator = (ES6Iterator)unwrappedThis;
        switch (id) {
            case 1: {
                return iterator.next(cx, scope);
            }
            case 2: {
                return iterator;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    @Override
    protected int findPrototypeId(final Symbol k) {
        if (SymbolKey.ITERATOR.equals(k)) {
            return 2;
        }
        if (SymbolKey.TO_STRING_TAG.equals(k)) {
            return 3;
        }
        return 0;
    }
    
    @Override
    protected int findPrototypeId(final String s) {
        if ("next".equals(s)) {
            return 1;
        }
        return 0;
    }
    
    public abstract boolean isDone(final Context p0, final Scriptable p1);
    
    public abstract Object nextValue(final Context p0, final Scriptable p1);
    
    protected Object next(final Context cx, final Scriptable scope) {
        Object value = Undefined.instance;
        final boolean done = this.isDone(cx, scope) || this.exhausted;
        if (!done) {
            value = this.nextValue(cx, scope);
        }
        else {
            this.exhausted = true;
        }
        return this.makeIteratorResult(cx, scope, done, value);
    }
    
    protected String getTag() {
        return this.tag;
    }
    
    private Scriptable makeIteratorResult(final Context cx, final Scriptable scope, final boolean done, final Object value) {
        final Scriptable iteratorResult = cx.newObject(scope);
        ScriptableObject.putProperty(iteratorResult, "value", value);
        ScriptableObject.putProperty(iteratorResult, "done", done);
        return iteratorResult;
    }
}
