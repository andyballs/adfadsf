//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeInt8Array extends NativeTypedArrayView<Byte>
{
    private static final long serialVersionUID = -3349419704390398895L;
    private static final String CLASS_NAME = "Int8Array";
    
    public NativeInt8Array() {
    }
    
    public NativeInt8Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len);
    }
    
    public NativeInt8Array(final int len) {
        this(new NativeArrayBuffer((double)len), 0, len);
    }
    
    public String getClassName() {
        return "Int8Array";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeInt8Array a = new NativeInt8Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    @Override
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    @Override
    protected NativeInt8Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeInt8Array(ab, off, len);
    }
    
    @Override
    public int getBytesPerElement() {
        return 1;
    }
    
    @Override
    protected NativeInt8Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeInt8Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeInt8Array)unwrappedThis;
    }
    
    @Override
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readInt8(this.arrayBuffer.buffer, index + this.offset);
    }
    
    @Override
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final int val = Conversions.toInt8(c);
        ByteIo.writeInt8(this.arrayBuffer.buffer, index + this.offset, val);
        return null;
    }
    
    public Byte get(final int i) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Byte)this.js_get(i);
    }
    
    public Byte set(final int i, final Byte aByte) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Byte)this.js_set(i, aByte);
    }
}
