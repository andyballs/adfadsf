//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeUint16Array extends NativeTypedArrayView<Integer>
{
    private static final long serialVersionUID = 7700018949434240321L;
    private static final String CLASS_NAME = "Uint16Array";
    private static final int BYTES_PER_ELEMENT = 2;
    
    public NativeUint16Array() {
    }
    
    public NativeUint16Array(final NativeArrayBuffer ab, final int off, final int len) {
        super(ab, off, len, len * 2);
    }
    
    public NativeUint16Array(final int len) {
        this(new NativeArrayBuffer((double)(len * 2)), 0, len);
    }
    
    public String getClassName() {
        return "Uint16Array";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeUint16Array a = new NativeUint16Array();
        a.exportAsJSClass(27, scope, sealed);
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addCtorSpecies(ctor);
    }
    
    protected NativeUint16Array construct(final NativeArrayBuffer ab, final int off, final int len) {
        return new NativeUint16Array(ab, off, len);
    }
    
    public int getBytesPerElement() {
        return 2;
    }
    
    protected NativeUint16Array realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeUint16Array)) {
            throw incompatibleCallError(f);
        }
        return (NativeUint16Array)unwrappedThis;
    }
    
    protected Object js_get(final int index) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        return ByteIo.readUint16(this.arrayBuffer.buffer, index * 2 + this.offset, useLittleEndian());
    }
    
    protected Object js_set(final int index, final Object c) {
        if (this.checkIndex(index)) {
            return Undefined.instance;
        }
        final int val = Conversions.toUint16(c);
        ByteIo.writeUint16(this.arrayBuffer.buffer, index * 2 + this.offset, val, useLittleEndian());
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
