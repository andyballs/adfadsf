//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeInt32Array extends NativeTypedArrayView<Integer>
{
    private static final long serialVersionUID = -8963461831950499340L;
    private static final String CLASS_NAME = "Int32Array";
    private static final int BYTES_PER_ELEMENT = 4;
    
    public NativeInt32Array() {
    }
    
    public NativeInt32Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len * 4);
    }
    
    public NativeInt32Array(final int len) {
        this(new NativeArrayBuffer((double)(len * 4)), 0, len);
    }
    
    public String getClassName() {
        return "Int32Array";
    }
    
    @Override
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeInt32Array a = new NativeInt32Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    @Override
    protected NativeInt32Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeInt32Array(ab, off, len);
    }
    
    @Override
    public int getBytesPerElement() {
        return 4;
    }
    
    @Override
    protected NativeInt32Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeInt32Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeInt32Array)unwrappedThis;
    }
    
    @Override
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readInt32(this.arrayBuffer.buffer, index * 4 + this.offset, useLittleEndian());
    }
    
    @Override
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final int val = ScriptRuntime.toInt32(c);
        ByteIo.writeInt32(this.arrayBuffer.buffer, index * 4 + this.offset, val, useLittleEndian());
        return null;
    }
    
    public Integer get(final int i) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer)this.js_get(i);
    }
    
    public Integer set(final int i, final Integer aByte) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer)this.js_set(i, aByte);
    }
}
