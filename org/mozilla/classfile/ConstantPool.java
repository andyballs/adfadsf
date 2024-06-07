//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

import org.mozilla.javascript.*;

final class ConstantPool
{
    private static final int ConstantPoolSize = 256;
    static final byte CONSTANT_Class = 7;
    static final byte CONSTANT_Fieldref = 9;
    static final byte CONSTANT_Methodref = 10;
    static final byte CONSTANT_InterfaceMethodref = 11;
    static final byte CONSTANT_String = 8;
    static final byte CONSTANT_Integer = 3;
    static final byte CONSTANT_Float = 4;
    static final byte CONSTANT_Long = 5;
    static final byte CONSTANT_Double = 6;
    static final byte CONSTANT_NameAndType = 12;
    static final byte CONSTANT_Utf8 = 1;
    static final byte CONSTANT_MethodType = 16;
    static final byte CONSTANT_MethodHandle = 15;
    static final byte CONSTANT_InvokeDynamic = 18;
    private ClassFileWriter cfw;
    private static final int MAX_UTF_ENCODING_SIZE = 65535;
    private UintMap itsStringConstHash;
    private ObjToIntMap itsUtf8Hash;
    private ObjToIntMap itsFieldRefHash;
    private ObjToIntMap itsMethodRefHash;
    private ObjToIntMap itsClassHash;
    private ObjToIntMap itsConstantHash;
    private int itsTop;
    private int itsTopIndex;
    private UintMap itsConstantData;
    private UintMap itsPoolTypes;
    private byte[] itsPool;
    
    ConstantPool(final ClassFileWriter cfw) {
        this.itsStringConstHash = new UintMap();
        this.itsUtf8Hash = new ObjToIntMap();
        this.itsFieldRefHash = new ObjToIntMap();
        this.itsMethodRefHash = new ObjToIntMap();
        this.itsClassHash = new ObjToIntMap();
        this.itsConstantHash = new ObjToIntMap();
        this.itsConstantData = new UintMap();
        this.itsPoolTypes = new UintMap();
        this.cfw = cfw;
        this.itsTopIndex = 1;
        this.itsPool = new byte[256];
        this.itsTop = 0;
    }
    
    int write(final byte[] data, int offset) {
        offset = ClassFileWriter.putInt16((int)(short)this.itsTopIndex, data, offset);
        System.arraycopy(this.itsPool, 0, data, offset, this.itsTop);
        offset += this.itsTop;
        return offset;
    }
    
    int getWriteSize() {
        return 2 + this.itsTop;
    }
    
    int addConstant(final int k) {
        this.ensure(5);
        this.itsPool[this.itsTop++] = 3;
        this.itsTop = ClassFileWriter.putInt32(k, this.itsPool, this.itsTop);
        this.itsPoolTypes.put(this.itsTopIndex, 3);
        return (short)(this.itsTopIndex++);
    }
    
    int addConstant(final long k) {
        this.ensure(9);
        this.itsPool[this.itsTop++] = 5;
        this.itsTop = ClassFileWriter.putInt64(k, this.itsPool, this.itsTop);
        final int index = this.itsTopIndex;
        this.itsTopIndex += 2;
        this.itsPoolTypes.put(index, 5);
        return index;
    }
    
    int addConstant(final float k) {
        this.ensure(5);
        this.itsPool[this.itsTop++] = 4;
        final int bits = Float.floatToIntBits(k);
        this.itsTop = ClassFileWriter.putInt32(bits, this.itsPool, this.itsTop);
        this.itsPoolTypes.put(this.itsTopIndex, 4);
        return this.itsTopIndex++;
    }
    
    int addConstant(final double k) {
        this.ensure(9);
        this.itsPool[this.itsTop++] = 6;
        final long bits = Double.doubleToLongBits(k);
        this.itsTop = ClassFileWriter.putInt64(bits, this.itsPool, this.itsTop);
        final int index = this.itsTopIndex;
        this.itsTopIndex += 2;
        this.itsPoolTypes.put(index, 6);
        return index;
    }
    
    int addConstant(final String k) {
        final int utf8Index = 0xFFFF & this.addUtf8(k);
        int theIndex = this.itsStringConstHash.getInt(utf8Index, -1);
        if (theIndex == -1) {
            theIndex = this.itsTopIndex++;
            this.ensure(3);
            this.itsPool[this.itsTop++] = 8;
            this.itsTop = ClassFileWriter.putInt16(utf8Index, this.itsPool, this.itsTop);
            this.itsStringConstHash.put(utf8Index, theIndex);
        }
        this.itsPoolTypes.put(theIndex, 8);
        return theIndex;
    }
    
    int addConstant(final Object value) {
        if (value instanceof Integer || value instanceof Byte || value instanceof Short) {
            return this.addConstant(((Number)value).intValue());
        }
        if (value instanceof Character) {
            return this.addConstant((char)value);
        }
        if (value instanceof Boolean) {
            return this.addConstant(((boolean)value) ? 1 : 0);
        }
        if (value instanceof Float) {
            return this.addConstant((float)value);
        }
        if (value instanceof Long) {
            return this.addConstant((long)value);
        }
        if (value instanceof Double) {
            return this.addConstant((double)value);
        }
        if (value instanceof String) {
            return this.addConstant((String)value);
        }
        if (value instanceof ClassFileWriter.MHandle) {
            return this.addMethodHandle((ClassFileWriter.MHandle)value);
        }
        throw new IllegalArgumentException("value " + value);
    }
    
    boolean isUnderUtfEncodingLimit(final String s) {
        final int strLen = s.length();
        return strLen * 3 <= 65535 || (strLen <= 65535 && strLen == this.getUtfEncodingLimit(s, 0, strLen));
    }
    
    int getUtfEncodingLimit(final String s, final int start, final int end) {
        if ((end - start) * 3 <= 65535) {
            return end;
        }
        int limit = 65535;
        for (int i = start; i != end; ++i) {
            final int c = s.charAt(i);
            if (0 != c && c <= 127) {
                --limit;
            }
            else if (c < 2047) {
                limit -= 2;
            }
            else {
                limit -= 3;
            }
            if (limit < 0) {
                return i;
            }
        }
        return end;
    }
    
    short addUtf8(final String k) {
        int theIndex = this.itsUtf8Hash.get(k, -1);
        if (theIndex == -1) {
            final int strLen = k.length();
            boolean tooBigString;
            if (strLen > 65535) {
                tooBigString = true;
            }
            else {
                tooBigString = false;
                this.ensure(3 + strLen * 3);
                int top = this.itsTop;
                this.itsPool[top++] = 1;
                top += 2;
                final char[] chars = this.cfw.getCharBuffer(strLen);
                k.getChars(0, strLen, chars, 0);
                for (int i = 0; i != strLen; ++i) {
                    final int c = chars[i];
                    if (c != 0 && c <= 127) {
                        this.itsPool[top++] = (byte)c;
                    }
                    else if (c > 2047) {
                        this.itsPool[top++] = (byte)(0xE0 | c >> 12);
                        this.itsPool[top++] = (byte)(0x80 | (c >> 6 & 0x3F));
                        this.itsPool[top++] = (byte)(0x80 | (c & 0x3F));
                    }
                    else {
                        this.itsPool[top++] = (byte)(0xC0 | c >> 6);
                        this.itsPool[top++] = (byte)(0x80 | (c & 0x3F));
                    }
                }
                final int utfLen = top - (this.itsTop + 1 + 2);
                if (utfLen > 65535) {
                    tooBigString = true;
                }
                else {
                    this.itsPool[this.itsTop + 1] = (byte)(utfLen >>> 8);
                    this.itsPool[this.itsTop + 2] = (byte)utfLen;
                    this.itsTop = top;
                    theIndex = this.itsTopIndex++;
                    this.itsUtf8Hash.put(k, theIndex);
                }
            }
            if (tooBigString) {
                throw new IllegalArgumentException("Too big string");
            }
        }
        this.setConstantData(theIndex, k);
        this.itsPoolTypes.put(theIndex, 1);
        return (short)theIndex;
    }
    
    private short addNameAndType(final String name, final String type) {
        final short nameIndex = this.addUtf8(name);
        final short typeIndex = this.addUtf8(type);
        this.ensure(5);
        this.itsPool[this.itsTop++] = 12;
        this.itsTop = ClassFileWriter.putInt16((int)nameIndex, this.itsPool, this.itsTop);
        this.itsTop = ClassFileWriter.putInt16((int)typeIndex, this.itsPool, this.itsTop);
        this.itsPoolTypes.put(this.itsTopIndex, 12);
        return (short)(this.itsTopIndex++);
    }
    
    short addClass(final String className) {
        int theIndex = this.itsClassHash.get(className, -1);
        if (theIndex == -1) {
            String slashed = className;
            if (className.indexOf(46) > 0) {
                slashed = ClassFileWriter.getSlashedForm(className);
                theIndex = this.itsClassHash.get(slashed, -1);
                if (theIndex != -1) {
                    this.itsClassHash.put(className, theIndex);
                }
            }
            if (theIndex == -1) {
                final int utf8Index = this.addUtf8(slashed);
                this.ensure(3);
                this.itsPool[this.itsTop++] = 7;
                this.itsTop = ClassFileWriter.putInt16(utf8Index, this.itsPool, this.itsTop);
                theIndex = this.itsTopIndex++;
                this.itsClassHash.put(slashed, theIndex);
                if (!className.equals(slashed)) {
                    this.itsClassHash.put(className, theIndex);
                }
            }
        }
        this.setConstantData(theIndex, className);
        this.itsPoolTypes.put(theIndex, 7);
        return (short)theIndex;
    }
    
    short addFieldRef(final String className, final String fieldName, final String fieldType) {
        final FieldOrMethodRef ref = new FieldOrMethodRef(className, fieldName, fieldType);
        int theIndex = this.itsFieldRefHash.get(ref, -1);
        if (theIndex == -1) {
            final short ntIndex = this.addNameAndType(fieldName, fieldType);
            final short classIndex = this.addClass(className);
            this.ensure(5);
            this.itsPool[this.itsTop++] = 9;
            this.itsTop = ClassFileWriter.putInt16((int)classIndex, this.itsPool, this.itsTop);
            this.itsTop = ClassFileWriter.putInt16((int)ntIndex, this.itsPool, this.itsTop);
            theIndex = this.itsTopIndex++;
            this.itsFieldRefHash.put(ref, theIndex);
        }
        this.setConstantData(theIndex, ref);
        this.itsPoolTypes.put(theIndex, 9);
        return (short)theIndex;
    }
    
    short addMethodRef(final String className, final String methodName, final String methodType) {
        final FieldOrMethodRef ref = new FieldOrMethodRef(className, methodName, methodType);
        int theIndex = this.itsMethodRefHash.get(ref, -1);
        if (theIndex == -1) {
            final short ntIndex = this.addNameAndType(methodName, methodType);
            final short classIndex = this.addClass(className);
            this.ensure(5);
            this.itsPool[this.itsTop++] = 10;
            this.itsTop = ClassFileWriter.putInt16((int)classIndex, this.itsPool, this.itsTop);
            this.itsTop = ClassFileWriter.putInt16((int)ntIndex, this.itsPool, this.itsTop);
            theIndex = this.itsTopIndex++;
            this.itsMethodRefHash.put(ref, theIndex);
        }
        this.setConstantData(theIndex, ref);
        this.itsPoolTypes.put(theIndex, 10);
        return (short)theIndex;
    }
    
    short addInterfaceMethodRef(final String className, final String methodName, final String methodType) {
        final short ntIndex = this.addNameAndType(methodName, methodType);
        final short classIndex = this.addClass(className);
        this.ensure(5);
        this.itsPool[this.itsTop++] = 11;
        this.itsTop = ClassFileWriter.putInt16((int)classIndex, this.itsPool, this.itsTop);
        this.itsTop = ClassFileWriter.putInt16((int)ntIndex, this.itsPool, this.itsTop);
        final FieldOrMethodRef r = new FieldOrMethodRef(className, methodName, methodType);
        this.setConstantData(this.itsTopIndex, r);
        this.itsPoolTypes.put(this.itsTopIndex, 11);
        return (short)(this.itsTopIndex++);
    }
    
    short addInvokeDynamic(final String methodName, final String methodType, final int bootstrapIndex) {
        final ConstantEntry entry = new ConstantEntry(18, bootstrapIndex, methodName, methodType);
        int theIndex = this.itsConstantHash.get(entry, -1);
        if (theIndex == -1) {
            final short nameTypeIndex = this.addNameAndType(methodName, methodType);
            this.ensure(5);
            this.itsPool[this.itsTop++] = 18;
            this.itsTop = ClassFileWriter.putInt16(bootstrapIndex, this.itsPool, this.itsTop);
            this.itsTop = ClassFileWriter.putInt16((int)nameTypeIndex, this.itsPool, this.itsTop);
            theIndex = this.itsTopIndex++;
            this.itsConstantHash.put(entry, theIndex);
            this.setConstantData(theIndex, methodType);
            this.itsPoolTypes.put(theIndex, 18);
        }
        return (short)theIndex;
    }
    
    short addMethodHandle(final ClassFileWriter.MHandle mh) {
        int theIndex = this.itsConstantHash.get(mh, -1);
        if (theIndex == -1) {
            short ref;
            if (mh.tag <= 4) {
                ref = this.addFieldRef(mh.owner, mh.name, mh.desc);
            }
            else if (mh.tag == 9) {
                ref = this.addInterfaceMethodRef(mh.owner, mh.name, mh.desc);
            }
            else {
                ref = this.addMethodRef(mh.owner, mh.name, mh.desc);
            }
            this.ensure(4);
            this.itsPool[this.itsTop++] = 15;
            this.itsPool[this.itsTop++] = mh.tag;
            this.itsTop = ClassFileWriter.putInt16((int)ref, this.itsPool, this.itsTop);
            theIndex = this.itsTopIndex++;
            this.itsConstantHash.put(mh, theIndex);
            this.itsPoolTypes.put(theIndex, 15);
        }
        return (short)theIndex;
    }
    
    Object getConstantData(final int index) {
        return this.itsConstantData.getObject(index);
    }
    
    void setConstantData(final int index, final Object data) {
        this.itsConstantData.put(index, data);
    }
    
    byte getConstantType(final int index) {
        return (byte)this.itsPoolTypes.getInt(index, 0);
    }
    
    private void ensure(final int howMuch) {
        if (this.itsTop + howMuch > this.itsPool.length) {
            int newCapacity = this.itsPool.length * 2;
            if (this.itsTop + howMuch > newCapacity) {
                newCapacity = this.itsTop + howMuch;
            }
            final byte[] tmp = new byte[newCapacity];
            System.arraycopy(this.itsPool, 0, tmp, 0, this.itsTop);
            this.itsPool = tmp;
        }
    }
}
