//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeUint8ClampedArray extends NativeTypedArrayView<Integer>
{
    private static final long serialVersionUID = -3349419704390398895L;
    private static final String CLASS_NAME = "Uint8ClampedArray";
    
    public NativeUint8ClampedArray() {
    }
    
    public NativeUint8ClampedArray(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len);
    }
    
    public NativeUint8ClampedArray(final int len) {
        this(new NativeArrayBuffer((double)len), 0, len);
    }
    
    public String getClassName() {
        return "Uint8ClampedArray";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeUint8ClampedArray a = new NativeUint8ClampedArray();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    protected NativeUint8ClampedArray construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeUint8ClampedArray(ab, off, len);
    }
    
    public int getBytesPerElement() {
        return 1;
    }
    
    protected NativeUint8ClampedArray realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeUint8ClampedArray)) {
            throw incompatibleCallError(f);
        }
        return (NativeUint8ClampedArray)unwrappedThis;
    }
    
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readUint8(this.arrayBuffer.buffer, index + this.offset);
    }
    
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final int val = Conversions.toUint8Clamp(c);
        ByteIo.writeUint8(this.arrayBuffer.buffer, index + this.offset, val);
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
