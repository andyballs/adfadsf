//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeInt16Array extends NativeTypedArrayView<Short>
{
    private static final long serialVersionUID = -8592870435287581398L;
    private static final String CLASS_NAME = "Int16Array";
    private static final int BYTES_PER_ELEMENT = 2;
    
    public NativeInt16Array() {
    }
    
    public NativeInt16Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len * 2);
    }
    
    public NativeInt16Array(final int len) {
        this(new NativeArrayBuffer((double)(len * 2)), 0, len);
    }
    
    public String getClassName() {
        return "Int16Array";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeInt16Array a = new NativeInt16Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    @Override
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    @Override
    protected NativeInt16Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeInt16Array(ab, off, len);
    }
    
    @Override
    public int getBytesPerElement() {
        return 2;
    }
    
    @Override
    protected NativeInt16Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeInt16Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeInt16Array)unwrappedThis;
    }
    
    @Override
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readInt16(this.arrayBuffer.buffer, index * 2 + this.offset, useLittleEndian());
    }
    
    @Override
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final int val = Conversions.toInt16(c);
        ByteIo.writeInt16(this.arrayBuffer.buffer, index * 2 + this.offset, val, useLittleEndian());
        return null;
    }
    
    public Short get(final int i) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Short)this.js_get(i);
    }
    
    public Short set(final int i, final Short aByte) {
        if (this.checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Short)this.js_set(i, aByte);
    }
}
