//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.generator;

import org.mozilla.javascript.*;

public class NativeGeneratorIterator extends ES6Iterator
{
    private static final String GEN_ITERATOR_TAG = "GeneratorIterator";
    private NativeGenerator generator;
    private Object prevValue;
    private boolean done;
    
    public static void init(final ScriptableObject scope, final boolean sealed) {
        ES6Iterator.init(scope, sealed, (IdScriptableObject)new NativeGeneratorIterator(), "GeneratorIterator");
    }
    
    private NativeGeneratorIterator() {
    }
    
    public NativeGeneratorIterator(final Context cx, final Scriptable scope, final NativeGenerator generator) {
        super(scope, "GeneratorIterator");
        this.generator = generator;
        final Object value = this.getNext(cx, scope);
        if (this.isDone(value)) {
            this.done = true;
        }
        else {
            this.prevValue = value;
        }
    }
    
    public boolean isDone(final Context cx, final Scriptable scope) {
        return this.done;
    }
    
    public Object nextValue(final Context cx, final Scriptable scope) {
        if (this.done) {
            return Undefined.instance;
        }
        final Object toRet = this.prevValue;
        this.prevValue = this.getNext(cx, scope);
        if (this.isDone(this.prevValue)) {
            this.done = true;
        }
        return ScriptableObject.getProperty((Scriptable)toRet, "value");
    }
    
    private Object getNext(final Context cx, final Scriptable scope) {
        return this.generator.resume(cx, scope, 0, Undefined.instance);
    }
    
    private boolean isDone(final Object obj) {
        if (!(obj instanceof NativeObject)) {
            throw Kit.codeBug();
        }
        return (boolean)ScriptableObject.getProperty((Scriptable)obj, "done");
    }
    
    public String getClassName() {
        return "Generator Iterator";
    }
    
    protected String getTag() {
        return "GeneratorIterator";
    }
}
