//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeArrayBuffer extends IdScriptableObject
{
    private static final long serialVersionUID = 3110411773054879549L;
    public static final String CLASS_NAME = "ArrayBuffer";
    private static final byte[] EMPTY_BUF;
    public static final NativeArrayBuffer EMPTY_BUFFER;
    byte[] buffer;
    private static final int Id_constructor = 1;
    private static final int Id_slice = 2;
    private static final int Id_transfer = 3;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final int ConstructorId_isView = -1;
    private static final int Id_byteLength = 1;
    private static final int MAX_INSTANCE_ID = 1;
    
    public String getClassName() {
        return "ArrayBuffer";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeArrayBuffer na = new NativeArrayBuffer();
        na.exportAsJSClass(3, scope, sealed);
    }
    
    public NativeArrayBuffer() {
        this.buffer = NativeArrayBuffer.EMPTY_BUF;
    }
    
    public NativeArrayBuffer(final double len) {
        if (len >= 2.147483647E9) {
            throw ScriptRuntime.constructError("RangeError", "length parameter (" + len + ") is too large ");
        }
        if (len == Double.NEGATIVE_INFINITY) {
            throw ScriptRuntime.constructError("RangeError", "Negative array length " + len);
        }
        final int intLen = ScriptRuntime.toInt32(len);
        if (intLen < 0) {
            throw ScriptRuntime.constructError("RangeError", "Negative array length " + len);
        }
        if (intLen == 0) {
            this.buffer = NativeArrayBuffer.EMPTY_BUF;
        }
        else {
            this.buffer = new byte[intLen];
        }
    }
    
    private NativeArrayBuffer(final byte[] buffer) {
        this.buffer = buffer;
    }
    
    public int getLength() {
        return this.buffer.length;
    }
    
    public byte[] getBuffer() {
        return this.buffer;
    }
    
    public NativeArrayBuffer slice(final double s, final double e) {
        final int end = ScriptRuntime.toInt32(Math.max(0.0, Math.min(this.buffer.length, (e < 0.0) ? (this.buffer.length + e) : e)));
        final int start = ScriptRuntime.toInt32(Math.min(end, Math.max(0.0, (s < 0.0) ? (this.buffer.length + s) : s)));
        final int len = end - start;
        final NativeArrayBuffer newBuf = new NativeArrayBuffer(len);
        System.arraycopy(this.buffer, start, newBuf.buffer, 0, len);
        return newBuf;
    }
    
    public NativeArrayBuffer transfer() {
        final NativeArrayBuffer newBuf = new NativeArrayBuffer(this.buffer);
        this.buffer = NativeArrayBuffer.EMPTY_BUF;
        return newBuf;
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag((Object)"ArrayBuffer")) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case -1: {
                return isArg(args, 0) && args[0] instanceof NativeArrayBufferView;
            }
            case 1: {
                if (thisObj != null) {
                    throw ScriptRuntime.typeError1("msg.builtin.no.new", (Object)"ArrayBuffer");
                }
                final double length = isArg(args, 0) ? ScriptRuntime.toNumber(args[0]) : 0.0;
                return new NativeArrayBuffer(length);
            }
            case 2: {
                final NativeArrayBuffer self = realThis(thisObj, f);
                final double start = isArg(args, 0) ? ScriptRuntime.toNumber(args[0]) : 0.0;
                final double end = isArg(args, 1) ? ScriptRuntime.toNumber(args[1]) : self.buffer.length;
                return self.slice(start, end);
            }
            case 3: {
                final NativeArrayBuffer self = realThis(thisObj, f);
                return self.transfer();
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private static NativeArrayBuffer realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeArrayBuffer)) {
            throw incompatibleCallError(f);
        }
        return (NativeArrayBuffer)unwrappedThis;
    }
    
    private static boolean isArg(final Object[] args, final int i) {
        return args.length > i && !Undefined.instance.equals(args[i]);
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 1;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 1;
                s = "slice";
                break;
            }
            case 3: {
                arity = 0;
                s = "transfer";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod((Object)"ArrayBuffer", id, s, arity);
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 5) {
            X = "slice";
            id = 2;
        }
        else if (s_length == 8) {
            X = "transfer";
            id = 3;
        }
        else if (s_length == 11) {
            X = "constructor";
            id = 1;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addIdFunctionProperty((Scriptable)ctor, (Object)"ArrayBuffer", -1, "isView", 1);
        this.addCtorSpecies(ctor);
    }
    
    protected int getMaxInstanceId() {
        return 1;
    }
    
    protected String getInstanceIdName(final int id) {
        if (id == 1) {
            return "byteLength";
        }
        return super.getInstanceIdName(id);
    }
    
    protected Object getInstanceIdValue(final int id) {
        if (id == 1) {
            return ScriptRuntime.wrapInt(this.buffer.length);
        }
        return super.getInstanceIdValue(id);
    }
    
    protected int findInstanceIdInfo(final String s) {
        if ("byteLength".equals(s)) {
            return instanceIdInfo(5, 1);
        }
        return super.findInstanceIdInfo(s);
    }
    
    static {
        EMPTY_BUF = new byte[0];
        EMPTY_BUFFER = new NativeArrayBuffer();
    }
}
