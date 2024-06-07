//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public final class NativeStringIterator extends ES6Iterator
{
    private static final long serialVersionUID = 1L;
    private static final String ITERATOR_TAG = "StringIterator";
    private String string;
    private int index;
    private boolean keyOnly;
    
    static void init(final ScriptableObject scope, final boolean sealed) {
        ES6Iterator.init(scope, sealed, (IdScriptableObject)new NativeStringIterator(), "StringIterator");
    }
    
    private NativeStringIterator() {
    }
    
    NativeStringIterator(final Scriptable scope, final Scriptable stringLike, final boolean keyOnly) {
        super(scope, "StringIterator");
        this.index = 0;
        this.string = ScriptRuntime.toString(stringLike);
        this.keyOnly = keyOnly;
    }
    
    public String getClassName() {
        return "String Iterator";
    }
    
    public boolean isDone(final Context cx, final Scriptable scope) {
        return this.index >= this.string.length();
    }
    
    public Object nextValue(final Context cx, final Scriptable scope) {
        if (this.keyOnly) {
            return this.index++;
        }
        final int newIndex = this.string.offsetByCodePoints(this.index, 1);
        final Object value = this.string.substring(this.index, newIndex);
        this.index = newIndex;
        return value;
    }
    
    protected String getTag() {
        return "StringIterator";
    }
}
