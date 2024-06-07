//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeFloat64Array extends NativeTypedArrayView<Double>
{
    private static final long serialVersionUID = -1255405650050639335L;
    private static final String CLASS_NAME = "Float64Array";
    private static final int BYTES_PER_ELEMENT = 8;
    
    public NativeFloat64Array() {
    }
    
    public NativeFloat64Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len * 8);
    }
    
    public NativeFloat64Array(final int len) {
        this(new NativeArrayBuffer((double)(len * 8)), 0, len);
    }
    
    public String getClassName() {
        return "Float64Array";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeFloat64Array a = new NativeFloat64Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    @Override
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    @Override
    protected NativeFloat64Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeFloat64Array(ab, off, len);
    }
    
    @Override
    public int getBytesPerElement() {
        return 8;
    }
    
    @Override
    protected NativeFloat64Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeFloat64Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeFloat64Array)unwrappedThis;
    }
    
    @Override
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final long base = ByteIo.readUint64Primitive(this.arrayBuffer.buffer, index * 8 + this.offset, useLittleEndian());
        return Double.longBitsToDouble(base);
    }
    
    @Override
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final double val = ScriptRuntime.toNumber(c);
        final long base = Double.doubleToLongBits(val);
        ByteIo.writeUint64(this.arrayBuffer.buffer, index * 8 + this.offset, base, useLittleEndian());
        return null;
    }
    
    public Double get(final int i) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Double)this.js_get(i);
    }
    
    public Double set(final int i, final Double aByte) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Double)this.js_set(i, aByte);
    }
}
