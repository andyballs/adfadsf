//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeFloat32Array extends NativeTypedArrayView<Float>
{
    private static final long serialVersionUID = -8963461831950499340L;
    private static final String CLASS_NAME = "Float32Array";
    private static final int BYTES_PER_ELEMENT = 4;
    
    public NativeFloat32Array() {
    }
    
    public NativeFloat32Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len * 4);
    }
    
    public NativeFloat32Array(final int len) {
        this(new NativeArrayBuffer((double)(len * 4)), 0, len);
    }
    
    public String getClassName() {
        return "Float32Array";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeFloat32Array a = new NativeFloat32Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    @Override
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    @Override
    protected NativeFloat32Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeFloat32Array(ab, off, len);
    }
    
    @Override
    public int getBytesPerElement() {
        return 4;
    }
    
    @Override
    protected NativeFloat32Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeFloat32Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeFloat32Array)unwrappedThis;
    }
    
    @Override
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readFloat32(this.arrayBuffer.buffer, index * 4 + this.offset, useLittleEndian());
    }
    
    @Override
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final double val = ScriptRuntime.toNumber(c);
        ByteIo.writeFloat32(this.arrayBuffer.buffer, index * 4 + this.offset, val, useLittleEndian());
        return null;
    }
    
    public Float get(final int i) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Float)this.js_get(i);
    }
    
    public Float set(final int i, final Float aByte) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Float)this.js_set(i, aByte);
    }
}
