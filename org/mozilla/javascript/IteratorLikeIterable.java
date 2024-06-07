//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import java.util.*;

public class IteratorLikeIterable implements Iterable<Object>, Closeable
{
    private final Context cx;
    private final Scriptable scope;
    private final Callable next;
    private final Callable returnFunc;
    private final Scriptable iterator;
    private boolean closed;
    
    public IteratorLikeIterable(final Context cx, final Scriptable scope, final Object target) {
        this.cx = cx;
        this.scope = scope;
        this.next = ScriptRuntime.getPropFunctionAndThis(target, "next", cx, scope);
        this.iterator = ScriptRuntime.lastStoredScriptable(cx);
        final Scriptable st = ScriptableObject.ensureScriptable(target);
        if (st.has("return", st) && !ScriptRuntime.isNullOrUndefined(ScriptableObject.getProperty(st, "return"))) {
            this.returnFunc = ScriptRuntime.getPropFunctionAndThis(target, "return", cx, scope);
            ScriptRuntime.lastStoredScriptable(cx);
        }
        else {
            this.returnFunc = null;
        }
    }
    
    @Override
    public void close() {
        if (!this.closed) {
            this.closed = true;
            if (this.returnFunc != null) {
                this.returnFunc.call(this.cx, this.scope, this.iterator, ScriptRuntime.emptyArgs);
            }
        }
    }
    
    @Override
    public Itr iterator() {
        return new Itr();
    }
    
    public final class Itr implements Iterator<Object>
    {
        private Object nextVal;
        
        @Override
        public boolean hasNext() {
            final Object val = IteratorLikeIterable.this.next.call(IteratorLikeIterable.this.cx, IteratorLikeIterable.this.scope, IteratorLikeIterable.this.iterator, ScriptRuntime.emptyArgs);
            Object doneval = ScriptRuntime.getObjectProp(val, "done", IteratorLikeIterable.this.cx, IteratorLikeIterable.this.scope, false);
            if (Undefined.instance.equals(doneval)) {
                doneval = false;
            }
            if (ScriptRuntime.toBoolean(doneval)) {
                return false;
            }
            this.nextVal = ScriptRuntime.getObjectProp(val, "value", IteratorLikeIterable.this.cx, IteratorLikeIterable.this.scope, false);
            return true;
        }
        
        @Override
        public Object next() {
            return this.nextVal;
        }
    }
}
