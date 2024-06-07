//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public final class NativeArrayIterator extends ES6Iterator
{
    private static final long serialVersionUID = 1L;
    private static final String ITERATOR_TAG = "ArrayIterator";
    private ARRAY_ITERATOR_TYPE type;
    private Scriptable arrayLike;
    private int index;
    
    static void init(final ScriptableObject scope, final boolean sealed) {
        ES6Iterator.init(scope, sealed, (IdScriptableObject)new NativeArrayIterator(), "ArrayIterator");
    }
    
    private NativeArrayIterator() {
    }
    
    public NativeArrayIterator(final Scriptable scope, final Scriptable arrayLike, final ARRAY_ITERATOR_TYPE type) {
        super(scope, "ArrayIterator");
        this.index = 0;
        this.arrayLike = arrayLike;
        this.type = type;
    }
    
    public String getClassName() {
        return "Array Iterator";
    }
    
    public boolean isDone(final Context cx, final Scriptable scope) {
        return this.arrayLike == null || this.index >= NativeArray.getLengthProperty(this.arrayLike, false);
    }
    
    public Object nextValue(final Context cx, final Scriptable scope) {
        if (this.type == ARRAY_ITERATOR_TYPE.KEYS) {
            return this.index++;
        }
        Object value = this.arrayLike.get(this.index, this.arrayLike);
        if (value == ScriptableObject.NOT_FOUND) {
            value = Undefined.instance;
        }
        if (this.type == ARRAY_ITERATOR_TYPE.ENTRIES) {
            value = cx.newArray(scope, new Object[] { this.index, value });
        }
        ++this.index;
        return value;
    }
    
    protected String getTag() {
        return "ArrayIterator";
    }
    
    public enum ARRAY_ITERATOR_TYPE
    {
        ENTRIES, 
        KEYS, 
        VALUES;
    }
}
