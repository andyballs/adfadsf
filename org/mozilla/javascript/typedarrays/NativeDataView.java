//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.*;

public class NativeDataView extends NativeArrayBufferView
{
    private static final long serialVersionUID = 1427967607557438968L;
    public static final String CLASS_NAME = "DataView";
    private static final int Id_constructor = 1;
    private static final int Id_getInt8 = 2;
    private static final int Id_getUint8 = 3;
    private static final int Id_getInt16 = 4;
    private static final int Id_getUint16 = 5;
    private static final int Id_getInt32 = 6;
    private static final int Id_getUint32 = 7;
    private static final int Id_getFloat32 = 8;
    private static final int Id_getFloat64 = 9;
    private static final int Id_setInt8 = 10;
    private static final int Id_setUint8 = 11;
    private static final int Id_setInt16 = 12;
    private static final int Id_setUint16 = 13;
    private static final int Id_setInt32 = 14;
    private static final int Id_setUint32 = 15;
    private static final int Id_setFloat32 = 16;
    private static final int Id_setFloat64 = 17;
    private static final int MAX_PROTOTYPE_ID = 17;
    
    public NativeDataView() {
    }
    
    public NativeDataView(final NativeArrayBuffer ab, final int offset, final int length) {
        super(ab, offset, length);
    }
    
    public String getClassName() {
        return "DataView";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeDataView dv = new NativeDataView();
        dv.exportAsJSClass(17, scope, sealed);
    }
    
    private int determinePos(final Object[] args) {
        if (!isArg(args, 0)) {
            return 0;
        }
        final double doublePos = ScriptRuntime.toNumber(args[0]);
        if (Double.isInfinite(doublePos)) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        return ScriptRuntime.toInt32(doublePos);
    }
    
    private void rangeCheck(final int pos, final int len) {
        if (pos < 0 || pos + len > this.byteLength) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
    }
    
    private static NativeDataView realThis(final Scriptable thisObj, final IdFunctionObject f) {
        final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
        if (!(unwrappedThis instanceof NativeDataView)) {
            throw incompatibleCallError(f);
        }
        return (NativeDataView)unwrappedThis;
    }
    
    private NativeDataView js_constructor(final Object[] args) {
        if (!isArg(args, 0) || !(args[0] instanceof NativeArrayBuffer)) {
            throw ScriptRuntime.constructError("TypeError", "Missing parameters");
        }
        final NativeArrayBuffer ab = (NativeArrayBuffer)args[0];
        int pos;
        if (isArg(args, 1)) {
            final double doublePos = ScriptRuntime.toNumber(args[1]);
            if (Double.isInfinite(doublePos)) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            pos = ScriptRuntime.toInt32(doublePos);
        }
        else {
            pos = 0;
        }
        int len;
        if (isArg(args, 2)) {
            final double doublePos2 = ScriptRuntime.toNumber(args[2]);
            if (Double.isInfinite(doublePos2)) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            len = ScriptRuntime.toInt32(doublePos2);
        }
        else {
            len = ab.getLength() - pos;
        }
        if (len < 0) {
            throw ScriptRuntime.constructError("RangeError", "length out of range");
        }
        if (pos < 0 || pos + len > ab.getLength()) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        return new NativeDataView(ab, pos, len);
    }
    
    private Object js_getInt(final int bytes, final boolean signed, final Object[] args) {
        final int pos = this.determinePos(args);
        this.rangeCheck(pos, bytes);
        final boolean littleEndian = isArg(args, 1) && bytes > 1 && ScriptRuntime.toBoolean(args[1]);
        switch (bytes) {
            case 1: {
                return signed ? ByteIo.readInt8(this.arrayBuffer.buffer, this.offset + pos) : ByteIo.readUint8(this.arrayBuffer.buffer, this.offset + pos);
            }
            case 2: {
                return signed ? ByteIo.readInt16(this.arrayBuffer.buffer, this.offset + pos, littleEndian) : ByteIo.readUint16(this.arrayBuffer.buffer, this.offset + pos, littleEndian);
            }
            case 4: {
                return signed ? ByteIo.readInt32(this.arrayBuffer.buffer, this.offset + pos, littleEndian) : ByteIo.readUint32(this.arrayBuffer.buffer, this.offset + pos, littleEndian);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    private Object js_getFloat(final int bytes, final Object[] args) {
        final int pos = this.determinePos(args);
        this.rangeCheck(pos, bytes);
        final boolean littleEndian = isArg(args, 1) && bytes > 1 && ScriptRuntime.toBoolean(args[1]);
        switch (bytes) {
            case 4: {
                return ByteIo.readFloat32(this.arrayBuffer.buffer, this.offset + pos, littleEndian);
            }
            case 8: {
                return ByteIo.readFloat64(this.arrayBuffer.buffer, this.offset + pos, littleEndian);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    private void js_setInt(final int bytes, final boolean signed, final Object[] args) {
        final int pos = this.determinePos(args);
        if (pos < 0) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        final boolean littleEndian = isArg(args, 2) && bytes > 1 && ScriptRuntime.toBoolean(args[2]);
        Object val = 0;
        if (args.length > 1) {
            val = args[1];
        }
        switch (bytes) {
            case 1: {
                if (signed) {
                    final int value = Conversions.toInt8(val);
                    if (pos + bytes > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeInt8(this.arrayBuffer.buffer, this.offset + pos, value);
                    break;
                }
                else {
                    final int value = Conversions.toUint8(val);
                    if (pos + bytes > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeUint8(this.arrayBuffer.buffer, this.offset + pos, value);
                    break;
                }
                break;
            }
            case 2: {
                if (signed) {
                    final int value = Conversions.toInt16(val);
                    if (pos + bytes > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeInt16(this.arrayBuffer.buffer, this.offset + pos, value, littleEndian);
                    break;
                }
                else {
                    final int value = Conversions.toUint16(val);
                    if (pos + bytes > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeUint16(this.arrayBuffer.buffer, this.offset + pos, value, littleEndian);
                    break;
                }
                break;
            }
            case 4: {
                if (signed) {
                    final int value = Conversions.toInt32(val);
                    if (pos + bytes > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeInt32(this.arrayBuffer.buffer, this.offset + pos, value, littleEndian);
                    break;
                }
                else {
                    final long value2 = Conversions.toUint32(val);
                    if (pos + bytes > this.byteLength) {
                        throw ScriptRuntime.constructError("RangeError", "offset out of range");
                    }
                    ByteIo.writeUint32(this.arrayBuffer.buffer, this.offset + pos, value2, littleEndian);
                    break;
                }
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    private void js_setFloat(final int bytes, final Object[] args) {
        final int pos = this.determinePos(args);
        if (pos < 0) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        final boolean littleEndian = isArg(args, 2) && bytes > 1 && ScriptRuntime.toBoolean(args[2]);
        double val = Double.NaN;
        if (args.length > 1) {
            val = ScriptRuntime.toNumber(args[1]);
        }
        if (pos + bytes > this.byteLength) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        switch (bytes) {
            case 4: {
                ByteIo.writeFloat32(this.arrayBuffer.buffer, this.offset + pos, val, littleEndian);
                break;
            }
            case 8: {
                ByteIo.writeFloat64(this.arrayBuffer.buffer, this.offset + pos, val, littleEndian);
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag((Object)this.getClassName())) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                if (thisObj != null) {
                    throw ScriptRuntime.typeError1("msg.builtin.no.new", (Object)"ArrayBuffer");
                }
                return this.js_constructor(args);
            }
            case 2: {
                return realThis(thisObj, f).js_getInt(1, true, args);
            }
            case 3: {
                return realThis(thisObj, f).js_getInt(1, false, args);
            }
            case 4: {
                return realThis(thisObj, f).js_getInt(2, true, args);
            }
            case 5: {
                return realThis(thisObj, f).js_getInt(2, false, args);
            }
            case 6: {
                return realThis(thisObj, f).js_getInt(4, true, args);
            }
            case 7: {
                return realThis(thisObj, f).js_getInt(4, false, args);
            }
            case 8: {
                return realThis(thisObj, f).js_getFloat(4, args);
            }
            case 9: {
                return realThis(thisObj, f).js_getFloat(8, args);
            }
            case 10: {
                realThis(thisObj, f).js_setInt(1, true, args);
                return Undefined.instance;
            }
            case 11: {
                realThis(thisObj, f).js_setInt(1, false, args);
                return Undefined.instance;
            }
            case 12: {
                realThis(thisObj, f).js_setInt(2, true, args);
                return Undefined.instance;
            }
            case 13: {
                realThis(thisObj, f).js_setInt(2, false, args);
                return Undefined.instance;
            }
            case 14: {
                realThis(thisObj, f).js_setInt(4, true, args);
                return Undefined.instance;
            }
            case 15: {
                realThis(thisObj, f).js_setInt(4, false, args);
                return Undefined.instance;
            }
            case 16: {
                realThis(thisObj, f).js_setFloat(4, args);
                return Undefined.instance;
            }
            case 17: {
                realThis(thisObj, f).js_setFloat(8, args);
                return Undefined.instance;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 3;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 1;
                s = "getInt8";
                break;
            }
            case 3: {
                arity = 1;
                s = "getUint8";
                break;
            }
            case 4: {
                arity = 1;
                s = "getInt16";
                break;
            }
            case 5: {
                arity = 1;
                s = "getUint16";
                break;
            }
            case 6: {
                arity = 1;
                s = "getInt32";
                break;
            }
            case 7: {
                arity = 1;
                s = "getUint32";
                break;
            }
            case 8: {
                arity = 1;
                s = "getFloat32";
                break;
            }
            case 9: {
                arity = 1;
                s = "getFloat64";
                break;
            }
            case 10: {
                arity = 2;
                s = "setInt8";
                break;
            }
            case 11: {
                arity = 2;
                s = "setUint8";
                break;
            }
            case 12: {
                arity = 2;
                s = "setInt16";
                break;
            }
            case 13: {
                arity = 2;
                s = "setUint16";
                break;
            }
            case 14: {
                arity = 2;
                s = "setInt32";
                break;
            }
            case 15: {
                arity = 2;
                s = "setUint32";
                break;
            }
            case 16: {
                arity = 2;
                s = "setFloat32";
                break;
            }
            case 17: {
                arity = 2;
                s = "setFloat64";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod((Object)this.getClassName(), id, s, arity);
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 7: {
                final int c = s.charAt(0);
                if (c == 103) {
                    X = "getInt8";
                    id = 2;
                    break;
                }
                if (c == 115) {
                    X = "setInt8";
                    id = 10;
                    break;
                }
                break;
            }
            case 8: {
                int c = s.charAt(6);
                if (c == 49) {
                    c = s.charAt(0);
                    if (c == 103) {
                        X = "getInt16";
                        id = 4;
                        break;
                    }
                    if (c == 115) {
                        X = "setInt16";
                        id = 12;
                        break;
                    }
                    break;
                }
                else if (c == 51) {
                    c = s.charAt(0);
                    if (c == 103) {
                        X = "getInt32";
                        id = 6;
                        break;
                    }
                    if (c == 115) {
                        X = "setInt32";
                        id = 14;
                        break;
                    }
                    break;
                }
                else {
                    if (c != 116) {
                        break;
                    }
                    c = s.charAt(0);
                    if (c == 103) {
                        X = "getUint8";
                        id = 3;
                        break;
                    }
                    if (c == 115) {
                        X = "setUint8";
                        id = 11;
                        break;
                    }
                    break;
                }
                break;
            }
            case 9: {
                int c = s.charAt(0);
                if (c == 103) {
                    c = s.charAt(8);
                    if (c == 50) {
                        X = "getUint32";
                        id = 7;
                        break;
                    }
                    if (c == 54) {
                        X = "getUint16";
                        id = 5;
                        break;
                    }
                    break;
                }
                else {
                    if (c != 115) {
                        break;
                    }
                    c = s.charAt(8);
                    if (c == 50) {
                        X = "setUint32";
                        id = 15;
                        break;
                    }
                    if (c == 54) {
                        X = "setUint16";
                        id = 13;
                        break;
                    }
                    break;
                }
                break;
            }
            case 10: {
                int c = s.charAt(0);
                if (c == 103) {
                    c = s.charAt(9);
                    if (c == 50) {
                        X = "getFloat32";
                        id = 8;
                        break;
                    }
                    if (c == 52) {
                        X = "getFloat64";
                        id = 9;
                        break;
                    }
                    break;
                }
                else {
                    if (c != 115) {
                        break;
                    }
                    c = s.charAt(9);
                    if (c == 50) {
                        X = "setFloat32";
                        id = 16;
                        break;
                    }
                    if (c == 52) {
                        X = "setFloat64";
                        id = 17;
                        break;
                    }
                    break;
                }
                break;
            }
            case 11: {
                X = "constructor";
                id = 1;
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
}
