//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public abstract class NativeArrayBufferView extends IdScriptableObject
{
    private static final long serialVersionUID = 6884475582973958419L;
    private static Boolean useLittleEndian;
    protected final NativeArrayBuffer arrayBuffer;
    protected final int offset;
    protected final int byteLength;
    private static final int Id_buffer = 1;
    private static final int Id_byteOffset = 2;
    private static final int Id_byteLength = 3;
    protected static final int MAX_INSTANCE_ID = 3;
    
    public NativeArrayBufferView() {
        this.arrayBuffer = NativeArrayBuffer.EMPTY_BUFFER;
        this.offset = 0;
        this.byteLength = 0;
    }
    
    protected NativeArrayBufferView(final NativeArrayBuffer ab, final int offset, final int byteLength) {
        this.offset = offset;
        this.byteLength = byteLength;
        this.arrayBuffer = ab;
    }
    
    public NativeArrayBuffer getBuffer() {
        return this.arrayBuffer;
    }
    
    public int getByteOffset() {
        return this.offset;
    }
    
    public int getByteLength() {
        return this.byteLength;
    }
    
    protected static boolean useLittleEndian() {
        if (NativeArrayBufferView.useLittleEndian == null) {
            final Context ctx = Context.getCurrentContext();
            if (ctx == null) {
                return false;
            }
            NativeArrayBufferView.useLittleEndian = ctx.hasFeature(18);
        }
        return NativeArrayBufferView.useLittleEndian;
    }
    
    protected static boolean isArg(final Object[] args, final int i) {
        return args.length > i && !Undefined.instance.equals(args[i]);
    }
    
    protected int getMaxInstanceId() {
        return 3;
    }
    
    protected String getInstanceIdName(final int id) {
        switch (id) {
            case 1: {
                return "buffer";
            }
            case 2: {
                return "byteOffset";
            }
            case 3: {
                return "byteLength";
            }
            default: {
                return super.getInstanceIdName(id);
            }
        }
    }
    
    protected Object getInstanceIdValue(final int id) {
        switch (id) {
            case 1: {
                return this.arrayBuffer;
            }
            case 2: {
                return ScriptRuntime.wrapInt(this.offset);
            }
            case 3: {
                return ScriptRuntime.wrapInt(this.byteLength);
            }
            default: {
                return super.getInstanceIdValue(id);
            }
        }
    }
    
    protected int findInstanceIdInfo(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 6) {
            X = "buffer";
            id = 1;
        }
        else if (s_length == 10) {
            final int c = s.charAt(4);
            if (c == 76) {
                X = "byteLength";
                id = 3;
            }
            else if (c == 79) {
                X = "byteOffset";
                id = 2;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        if (id == 0) {
            return super.findInstanceIdInfo(s);
        }
        return instanceIdInfo(5, id);
    }
    
    static {
        NativeArrayBufferView.useLittleEndian = null;
    }
}
