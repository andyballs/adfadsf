//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeUint32Array extends NativeTypedArrayView<Long>
{
    private static final long serialVersionUID = -7987831421954144244L;
    private static final String CLASS_NAME = "Uint32Array";
    private static final int BYTES_PER_ELEMENT = 4;
    
    public NativeUint32Array() {
    }
    
    public NativeUint32Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len * 4);
    }
    
    public NativeUint32Array(final int len) {
        this(new NativeArrayBuffer((double)(len * 4)), 0, len);
    }
    
    public String getClassName() {
        return "Uint32Array";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeUint32Array a = new NativeUint32Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    protected NativeUint32Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeUint32Array(ab, off, len);
    }
    
    public int getBytesPerElement() {
        return 4;
    }
    
    protected NativeUint32Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeUint32Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeUint32Array)unwrappedThis;
    }
    
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readUint32(this.arrayBuffer.buffer, index * 4 + this.offset, useLittleEndian());
    }
    
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final long val = Conversions.toUint32(c);
        ByteIo.writeUint32(this.arrayBuffer.buffer, index * 4 + this.offset, val, useLittleEndian());
        return null;
    }
    
    public Long get(final int i) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long)this.js_get(i);
    }
    
    public Long set(final int i, final Long aByte) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long)this.js_set(i, aByte);
    }
}
