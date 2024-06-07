//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

import org.mozilla.javascript.*;
import java.util.*;
import java.io.*;

public class ClassFileWriter
{
    public static final short ACC_PUBLIC = 1;
    public static final short ACC_PRIVATE = 2;
    public static final short ACC_PROTECTED = 4;
    public static final short ACC_STATIC = 8;
    public static final short ACC_FINAL = 16;
    public static final short ACC_SUPER = 32;
    public static final short ACC_SYNCHRONIZED = 32;
    public static final short ACC_VOLATILE = 64;
    public static final short ACC_TRANSIENT = 128;
    public static final short ACC_NATIVE = 256;
    public static final short ACC_ABSTRACT = 1024;
    private int[] itsSuperBlockStarts;
    private int itsSuperBlockStartsTop;
    private static final int SuperBlockStartsSize = 4;
    private UintMap itsJumpFroms;
    private static final int LineNumberTableSize = 16;
    private static final int ExceptionTableSize = 4;
    private static final int MajorVersion;
    private static final int MinorVersion;
    private static final boolean GenerateStackMap;
    private static final int FileHeaderConstant = -889275714;
    private static final boolean DEBUGSTACK = false;
    private static final boolean DEBUGLABELS = false;
    private static final boolean DEBUGCODE = false;
    private String generatedClassName;
    private ExceptionTableEntry[] itsExceptionTable;
    private int itsExceptionTableTop;
    private int[] itsLineNumberTable;
    private int itsLineNumberTableTop;
    private byte[] itsCodeBuffer;
    private int itsCodeBufferTop;
    private ConstantPool itsConstantPool;
    private ClassFileMethod itsCurrentMethod;
    private short itsStackTop;
    private short itsMaxStack;
    private short itsMaxLocals;
    private ObjArray itsMethods;
    private ObjArray itsFields;
    private ObjArray itsInterfaces;
    private short itsFlags;
    private short itsThisClassIndex;
    private short itsSuperClassIndex;
    private short itsSourceFileNameIndex;
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private int[] itsLabelTable;
    private int itsLabelTableTop;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private long[] itsFixupTable;
    private int itsFixupTableTop;
    private ObjArray itsVarDescriptors;
    private ObjArray itsBootstrapMethods;
    private int itsBootstrapMethodsLength;
    private char[] tmpCharBuffer;
    
    public ClassFileWriter(final String className, final String superClassName, final String sourceFileName) {
        this.itsSuperBlockStarts = null;
        this.itsSuperBlockStartsTop = 0;
        this.itsJumpFroms = null;
        this.itsCodeBuffer = new byte[256];
        this.itsMethods = new ObjArray();
        this.itsFields = new ObjArray();
        this.itsInterfaces = new ObjArray();
        this.itsBootstrapMethodsLength = 0;
        this.tmpCharBuffer = new char[64];
        this.generatedClassName = className;
        this.itsConstantPool = new ConstantPool(this);
        this.itsThisClassIndex = this.itsConstantPool.addClass(className);
        this.itsSuperClassIndex = this.itsConstantPool.addClass(superClassName);
        if (sourceFileName != null) {
            this.itsSourceFileNameIndex = this.itsConstantPool.addUtf8(sourceFileName);
        }
        this.itsFlags = 33;
    }
    
    public final String getClassName() {
        return this.generatedClassName;
    }
    
    public void addInterface(final String interfaceName) {
        final short interfaceIndex = this.itsConstantPool.addClass(interfaceName);
        this.itsInterfaces.add(interfaceIndex);
    }
    
    public void setFlags(final short flags) {
        this.itsFlags = flags;
    }
    
    static String getSlashedForm(final String name) {
        return name.replace('.', '/');
    }
    
    public static String classNameToSignature(final String name) {
        final int nameLength = name.length();
        final int colonPos = 1 + nameLength;
        final char[] buf = new char[colonPos + 1];
        buf[0] = 'L';
        buf[colonPos] = ';';
        name.getChars(0, nameLength, buf, 1);
        for (int i = 1; i != colonPos; ++i) {
            if (buf[i] == '.') {
                buf[i] = '/';
            }
        }
        return new String(buf, 0, colonPos + 1);
    }
    
    public void addField(final String fieldName, final String type, final short flags) {
        final short fieldNameIndex = this.itsConstantPool.addUtf8(fieldName);
        final short typeIndex = this.itsConstantPool.addUtf8(type);
        this.itsFields.add(new ClassFileField(fieldNameIndex, typeIndex, flags));
    }
    
    public void addField(final String fieldName, final String type, final short flags, final int value) {
        final short fieldNameIndex = this.itsConstantPool.addUtf8(fieldName);
        final short typeIndex = this.itsConstantPool.addUtf8(type);
        final ClassFileField field = new ClassFileField(fieldNameIndex, typeIndex, flags);
        field.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short)0, (short)0, this.itsConstantPool.addConstant(value));
        this.itsFields.add(field);
    }
    
    public void addField(final String fieldName, final String type, final short flags, final long value) {
        final short fieldNameIndex = this.itsConstantPool.addUtf8(fieldName);
        final short typeIndex = this.itsConstantPool.addUtf8(type);
        final ClassFileField field = new ClassFileField(fieldNameIndex, typeIndex, flags);
        field.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short)0, (short)2, this.itsConstantPool.addConstant(value));
        this.itsFields.add(field);
    }
    
    public void addField(final String fieldName, final String type, final short flags, final double value) {
        final short fieldNameIndex = this.itsConstantPool.addUtf8(fieldName);
        final short typeIndex = this.itsConstantPool.addUtf8(type);
        final ClassFileField field = new ClassFileField(fieldNameIndex, typeIndex, flags);
        field.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short)0, (short)2, this.itsConstantPool.addConstant(value));
        this.itsFields.add(field);
    }
    
    public void addVariableDescriptor(final String name, final String type, final int startPC, final int register) {
        final int nameIndex = this.itsConstantPool.addUtf8(name);
        final int descriptorIndex = this.itsConstantPool.addUtf8(type);
        final int[] chunk = { nameIndex, descriptorIndex, startPC, register };
        if (this.itsVarDescriptors == null) {
            this.itsVarDescriptors = new ObjArray();
        }
        this.itsVarDescriptors.add(chunk);
    }
    
    public void startMethod(final String methodName, final String type, final short flags) {
        final short methodNameIndex = this.itsConstantPool.addUtf8(methodName);
        final short typeIndex = this.itsConstantPool.addUtf8(type);
        this.itsCurrentMethod = new ClassFileMethod(methodName, methodNameIndex, type, typeIndex, flags);
        this.itsJumpFroms = new UintMap();
        this.itsMethods.add(this.itsCurrentMethod);
        this.addSuperBlockStart(0);
    }
    
    public void stopMethod(final short maxLocals) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalStateException("No method to stop");
        }
        this.fixLabelGotos();
        this.itsMaxLocals = maxLocals;
        StackMapTable stackMap = null;
        if (ClassFileWriter.GenerateStackMap) {
            this.finalizeSuperBlockStarts();
            stackMap = new StackMapTable();
            stackMap.generate();
        }
        int lineNumberTableLength = 0;
        if (this.itsLineNumberTable != null) {
            lineNumberTableLength = 8 + this.itsLineNumberTableTop * 4;
        }
        int variableTableLength = 0;
        if (this.itsVarDescriptors != null) {
            variableTableLength = 8 + this.itsVarDescriptors.size() * 10;
        }
        int stackMapTableLength = 0;
        if (stackMap != null) {
            final int stackMapWriteSize = stackMap.computeWriteSize();
            if (stackMapWriteSize > 0) {
                stackMapTableLength = 6 + stackMapWriteSize;
            }
        }
        int attrLength = 14 + this.itsCodeBufferTop + 2 + this.itsExceptionTableTop * 8 + 2 + lineNumberTableLength + variableTableLength + stackMapTableLength;
        if (attrLength > 65536) {
            throw new ClassFileFormatException("generated bytecode for method exceeds 64K limit.");
        }
        final byte[] codeAttribute = new byte[attrLength];
        int index = 0;
        final int codeAttrIndex = this.itsConstantPool.addUtf8("Code");
        index = putInt16(codeAttrIndex, codeAttribute, index);
        attrLength -= 6;
        index = putInt32(attrLength, codeAttribute, index);
        index = putInt16(this.itsMaxStack, codeAttribute, index);
        index = putInt16(this.itsMaxLocals, codeAttribute, index);
        index = putInt32(this.itsCodeBufferTop, codeAttribute, index);
        System.arraycopy(this.itsCodeBuffer, 0, codeAttribute, index, this.itsCodeBufferTop);
        index += this.itsCodeBufferTop;
        if (this.itsExceptionTableTop > 0) {
            index = putInt16(this.itsExceptionTableTop, codeAttribute, index);
            for (int i = 0; i < this.itsExceptionTableTop; ++i) {
                final ExceptionTableEntry ete = this.itsExceptionTable[i];
                final int startPC = this.getLabelPC(ete.itsStartLabel);
                final int endPC = this.getLabelPC(ete.itsEndLabel);
                final int handlerPC = this.getLabelPC(ete.itsHandlerLabel);
                final short catchType = ete.itsCatchType;
                if (startPC == -1) {
                    throw new IllegalStateException("start label not defined");
                }
                if (endPC == -1) {
                    throw new IllegalStateException("end label not defined");
                }
                if (handlerPC == -1) {
                    throw new IllegalStateException("handler label not defined");
                }
                index = putInt16(startPC, codeAttribute, index);
                index = putInt16(endPC, codeAttribute, index);
                index = putInt16(handlerPC, codeAttribute, index);
                index = putInt16(catchType, codeAttribute, index);
            }
        }
        else {
            index = putInt16(0, codeAttribute, index);
        }
        int attributeCount = 0;
        if (this.itsLineNumberTable != null) {
            ++attributeCount;
        }
        if (this.itsVarDescriptors != null) {
            ++attributeCount;
        }
        if (stackMapTableLength > 0) {
            ++attributeCount;
        }
        index = putInt16(attributeCount, codeAttribute, index);
        if (this.itsLineNumberTable != null) {
            final int lineNumberTableAttrIndex = this.itsConstantPool.addUtf8("LineNumberTable");
            index = putInt16(lineNumberTableAttrIndex, codeAttribute, index);
            final int tableAttrLength = 2 + this.itsLineNumberTableTop * 4;
            index = putInt32(tableAttrLength, codeAttribute, index);
            index = putInt16(this.itsLineNumberTableTop, codeAttribute, index);
            for (int j = 0; j < this.itsLineNumberTableTop; ++j) {
                index = putInt32(this.itsLineNumberTable[j], codeAttribute, index);
            }
        }
        if (this.itsVarDescriptors != null) {
            final int variableTableAttrIndex = this.itsConstantPool.addUtf8("LocalVariableTable");
            index = putInt16(variableTableAttrIndex, codeAttribute, index);
            final int varCount = this.itsVarDescriptors.size();
            final int tableAttrLength2 = 2 + varCount * 10;
            index = putInt32(tableAttrLength2, codeAttribute, index);
            index = putInt16(varCount, codeAttribute, index);
            for (int k = 0; k < varCount; ++k) {
                final int[] chunk = (int[])this.itsVarDescriptors.get(k);
                final int nameIndex = chunk[0];
                final int descriptorIndex = chunk[1];
                final int startPC2 = chunk[2];
                final int register = chunk[3];
                final int length = this.itsCodeBufferTop - startPC2;
                index = putInt16(startPC2, codeAttribute, index);
                index = putInt16(length, codeAttribute, index);
                index = putInt16(nameIndex, codeAttribute, index);
                index = putInt16(descriptorIndex, codeAttribute, index);
                index = putInt16(register, codeAttribute, index);
            }
        }
        if (stackMapTableLength > 0) {
            final int stackMapTableAttrIndex = this.itsConstantPool.addUtf8("StackMapTable");
            index = putInt16(stackMapTableAttrIndex, codeAttribute, index);
            index = stackMap.write(codeAttribute, index);
        }
        this.itsCurrentMethod.setCodeAttribute(codeAttribute);
        this.itsExceptionTable = null;
        this.itsExceptionTableTop = 0;
        this.itsLineNumberTableTop = 0;
        this.itsCodeBufferTop = 0;
        this.itsCurrentMethod = null;
        this.itsMaxStack = 0;
        this.itsStackTop = 0;
        this.itsLabelTableTop = 0;
        this.itsFixupTableTop = 0;
        this.itsVarDescriptors = null;
        this.itsSuperBlockStarts = null;
        this.itsSuperBlockStartsTop = 0;
        this.itsJumpFroms = null;
    }
    
    public void add(final int theOpCode) {
        if (opcodeCount(theOpCode) != 0) {
            throw new IllegalArgumentException("Unexpected operands");
        }
        final int newStack = this.itsStackTop + stackChange(theOpCode);
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        this.addToCodeBuffer(theOpCode);
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
        if (theOpCode == 191) {
            this.addSuperBlockStart(this.itsCodeBufferTop);
        }
    }
    
    public void add(final int theOpCode, final int theOperand) {
        final int newStack = this.itsStackTop + stackChange(theOpCode);
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        switch (theOpCode) {
            case 167: {
                this.addSuperBlockStart(this.itsCodeBufferTop + 3);
            }
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 168:
            case 198:
            case 199: {
                if ((theOperand & Integer.MIN_VALUE) != Integer.MIN_VALUE && (theOperand < 0 || theOperand > 65535)) {
                    throw new IllegalArgumentException("Bad label for branch");
                }
                final int branchPC = this.itsCodeBufferTop;
                this.addToCodeBuffer(theOpCode);
                if ((theOperand & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                    this.addToCodeInt16(theOperand);
                    final int target = theOperand + branchPC;
                    this.addSuperBlockStart(target);
                    this.itsJumpFroms.put(target, branchPC);
                }
                else {
                    final int targetPC = this.getLabelPC(theOperand);
                    if (targetPC != -1) {
                        final int offset = targetPC - branchPC;
                        this.addToCodeInt16(offset);
                        this.addSuperBlockStart(targetPC);
                        this.itsJumpFroms.put(targetPC, branchPC);
                    }
                    else {
                        this.addLabelFixup(theOperand, branchPC + 1);
                        this.addToCodeInt16(0);
                    }
                }
                break;
            }
            case 16: {
                if ((byte)theOperand != theOperand) {
                    throw new IllegalArgumentException("out of range byte");
                }
                this.addToCodeBuffer(theOpCode);
                this.addToCodeBuffer((byte)theOperand);
                break;
            }
            case 17: {
                if ((short)theOperand != theOperand) {
                    throw new IllegalArgumentException("out of range short");
                }
                this.addToCodeBuffer(theOpCode);
                this.addToCodeInt16(theOperand);
                break;
            }
            case 188: {
                if (0 > theOperand || theOperand >= 256) {
                    throw new IllegalArgumentException("out of range index");
                }
                this.addToCodeBuffer(theOpCode);
                this.addToCodeBuffer(theOperand);
                break;
            }
            case 180:
            case 181: {
                if (0 > theOperand || theOperand >= 65536) {
                    throw new IllegalArgumentException("out of range field");
                }
                this.addToCodeBuffer(theOpCode);
                this.addToCodeInt16(theOperand);
                break;
            }
            case 18:
            case 19:
            case 20: {
                if (0 > theOperand || theOperand >= 65536) {
                    throw new ClassFileFormatException("out of range index");
                }
                if (theOperand >= 256 || theOpCode == 19 || theOpCode == 20) {
                    if (theOpCode == 18) {
                        this.addToCodeBuffer(19);
                    }
                    else {
                        this.addToCodeBuffer(theOpCode);
                    }
                    this.addToCodeInt16(theOperand);
                    break;
                }
                this.addToCodeBuffer(theOpCode);
                this.addToCodeBuffer(theOperand);
                break;
            }
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 169: {
                if (theOperand < 0 || 65536 <= theOperand) {
                    throw new ClassFileFormatException("out of range variable");
                }
                if (theOperand >= 256) {
                    this.addToCodeBuffer(196);
                    this.addToCodeBuffer(theOpCode);
                    this.addToCodeInt16(theOperand);
                    break;
                }
                this.addToCodeBuffer(theOpCode);
                this.addToCodeBuffer(theOperand);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unexpected opcode for 1 operand");
            }
        }
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
    }
    
    public void addLoadConstant(final int k) {
        switch (k) {
            case 0: {
                this.add(3);
                break;
            }
            case 1: {
                this.add(4);
                break;
            }
            case 2: {
                this.add(5);
                break;
            }
            case 3: {
                this.add(6);
                break;
            }
            case 4: {
                this.add(7);
                break;
            }
            case 5: {
                this.add(8);
                break;
            }
            default: {
                this.add(18, this.itsConstantPool.addConstant(k));
                break;
            }
        }
    }
    
    public void addLoadConstant(final long k) {
        this.add(20, this.itsConstantPool.addConstant(k));
    }
    
    public void addLoadConstant(final float k) {
        this.add(18, this.itsConstantPool.addConstant(k));
    }
    
    public void addLoadConstant(final double k) {
        this.add(20, this.itsConstantPool.addConstant(k));
    }
    
    public void addLoadConstant(final String k) {
        this.add(18, this.itsConstantPool.addConstant(k));
    }
    
    public void add(final int theOpCode, final int theOperand1, final int theOperand2) {
        final int newStack = this.itsStackTop + stackChange(theOpCode);
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        if (theOpCode == 132) {
            if (theOperand1 < 0 || 65536 <= theOperand1) {
                throw new ClassFileFormatException("out of range variable");
            }
            if (theOperand2 < 0 || 65536 <= theOperand2) {
                throw new ClassFileFormatException("out of range increment");
            }
            if (theOperand1 > 255 || theOperand2 < -128 || theOperand2 > 127) {
                this.addToCodeBuffer(196);
                this.addToCodeBuffer(132);
                this.addToCodeInt16(theOperand1);
                this.addToCodeInt16(theOperand2);
            }
            else {
                this.addToCodeBuffer(132);
                this.addToCodeBuffer(theOperand1);
                this.addToCodeBuffer(theOperand2);
            }
        }
        else {
            if (theOpCode != 197) {
                throw new IllegalArgumentException("Unexpected opcode for 2 operands");
            }
            if (0 > theOperand1 || theOperand1 >= 65536) {
                throw new IllegalArgumentException("out of range index");
            }
            if (0 > theOperand2 || theOperand2 >= 256) {
                throw new IllegalArgumentException("out of range dimensions");
            }
            this.addToCodeBuffer(197);
            this.addToCodeInt16(theOperand1);
            this.addToCodeBuffer(theOperand2);
        }
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
    }
    
    public void add(final int theOpCode, final String className) {
        final int newStack = this.itsStackTop + stackChange(theOpCode);
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        switch (theOpCode) {
            case 187:
            case 189:
            case 192:
            case 193: {
                final short classIndex = this.itsConstantPool.addClass(className);
                this.addToCodeBuffer(theOpCode);
                this.addToCodeInt16(classIndex);
                this.itsStackTop = (short)newStack;
                if (newStack > this.itsMaxStack) {
                    this.itsMaxStack = (short)newStack;
                }
            }
            default: {
                throw new IllegalArgumentException("bad opcode for class reference");
            }
        }
    }
    
    public void add(final int theOpCode, final String className, final String fieldName, final String fieldType) {
        int newStack = this.itsStackTop + stackChange(theOpCode);
        final char fieldTypeChar = fieldType.charAt(0);
        final int fieldSize = (fieldTypeChar == 'J' || fieldTypeChar == 'D') ? 2 : 1;
        switch (theOpCode) {
            case 178:
            case 180: {
                newStack += fieldSize;
                break;
            }
            case 179:
            case 181: {
                newStack -= fieldSize;
                break;
            }
            default: {
                throw new IllegalArgumentException("bad opcode for field reference");
            }
        }
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        final short fieldRefIndex = this.itsConstantPool.addFieldRef(className, fieldName, fieldType);
        this.addToCodeBuffer(theOpCode);
        this.addToCodeInt16(fieldRefIndex);
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
    }
    
    public void addInvoke(final int theOpCode, final String className, final String methodName, final String methodType) {
        final int parameterInfo = sizeOfParameters(methodType);
        final int parameterCount = parameterInfo >>> 16;
        final int stackDiff = (short)parameterInfo;
        int newStack = this.itsStackTop + stackDiff;
        newStack += stackChange(theOpCode);
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        switch (theOpCode) {
            case 182:
            case 183:
            case 184:
            case 185: {
                this.addToCodeBuffer(theOpCode);
                if (theOpCode == 185) {
                    final short ifMethodRefIndex = this.itsConstantPool.addInterfaceMethodRef(className, methodName, methodType);
                    this.addToCodeInt16(ifMethodRefIndex);
                    this.addToCodeBuffer(parameterCount + 1);
                    this.addToCodeBuffer(0);
                }
                else {
                    final short methodRefIndex = this.itsConstantPool.addMethodRef(className, methodName, methodType);
                    this.addToCodeInt16(methodRefIndex);
                }
                this.itsStackTop = (short)newStack;
                if (newStack > this.itsMaxStack) {
                    this.itsMaxStack = (short)newStack;
                }
            }
            default: {
                throw new IllegalArgumentException("bad opcode for method reference");
            }
        }
    }
    
    public void addInvokeDynamic(final String methodName, final String methodType, final MHandle bsm, final Object... bsmArgs) {
        if (ClassFileWriter.MajorVersion < 51) {
            throw new RuntimeException("Please build and run with JDK 1.7 for invokedynamic support");
        }
        final int parameterInfo = sizeOfParameters(methodType);
        final int stackDiff = (short)parameterInfo;
        final int newStack = this.itsStackTop + stackDiff;
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        final BootstrapEntry bsmEntry = new BootstrapEntry(bsm, bsmArgs);
        if (this.itsBootstrapMethods == null) {
            this.itsBootstrapMethods = new ObjArray();
        }
        int bootstrapIndex = this.itsBootstrapMethods.indexOf(bsmEntry);
        if (bootstrapIndex == -1) {
            bootstrapIndex = this.itsBootstrapMethods.size();
            this.itsBootstrapMethods.add(bsmEntry);
            this.itsBootstrapMethodsLength += bsmEntry.code.length;
        }
        final short invokedynamicIndex = this.itsConstantPool.addInvokeDynamic(methodName, methodType, bootstrapIndex);
        this.addToCodeBuffer(186);
        this.addToCodeInt16(invokedynamicIndex);
        this.addToCodeInt16(0);
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
    }
    
    public void addPush(final int k) {
        if ((byte)k == k) {
            if (k == -1) {
                this.add(2);
            }
            else if (0 <= k && k <= 5) {
                this.add((byte)(3 + k));
            }
            else {
                this.add(16, (byte)k);
            }
        }
        else if ((short)k == k) {
            this.add(17, (short)k);
        }
        else {
            this.addLoadConstant(k);
        }
    }
    
    public void addPush(final boolean k) {
        this.add(k ? 4 : 3);
    }
    
    public void addPush(final long k) {
        final int ik = (int)k;
        if (ik == k) {
            this.addPush(ik);
            this.add(133);
        }
        else {
            this.addLoadConstant(k);
        }
    }
    
    public void addPush(final double k) {
        if (k == 0.0) {
            this.add(14);
            if (1.0 / k < 0.0) {
                this.add(119);
            }
        }
        else if (k == 1.0 || k == -1.0) {
            this.add(15);
            if (k < 0.0) {
                this.add(119);
            }
        }
        else {
            this.addLoadConstant(k);
        }
    }
    
    public void addPush(final String k) {
        final int length = k.length();
        int limit = this.itsConstantPool.getUtfEncodingLimit(k, 0, length);
        if (limit == length) {
            this.addLoadConstant(k);
            return;
        }
        final String SB = "java/lang/StringBuilder";
        this.add(187, "java/lang/StringBuilder");
        this.add(89);
        this.addPush(length);
        this.addInvoke(183, "java/lang/StringBuilder", "<init>", "(I)V");
        int cursor = 0;
        while (true) {
            this.add(89);
            final String s = k.substring(cursor, limit);
            this.addLoadConstant(s);
            this.addInvoke(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            this.add(87);
            if (limit == length) {
                break;
            }
            cursor = limit;
            limit = this.itsConstantPool.getUtfEncodingLimit(k, limit, length);
        }
        this.addInvoke(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
    }
    
    public boolean isUnderStringSizeLimit(final String k) {
        return this.itsConstantPool.isUnderUtfEncodingLimit(k);
    }
    
    public void addIStore(final int local) {
        this.xop(59, 54, local);
    }
    
    public void addLStore(final int local) {
        this.xop(63, 55, local);
    }
    
    public void addFStore(final int local) {
        this.xop(67, 56, local);
    }
    
    public void addDStore(final int local) {
        this.xop(71, 57, local);
    }
    
    public void addAStore(final int local) {
        this.xop(75, 58, local);
    }
    
    public void addILoad(final int local) {
        this.xop(26, 21, local);
    }
    
    public void addLLoad(final int local) {
        this.xop(30, 22, local);
    }
    
    public void addFLoad(final int local) {
        this.xop(34, 23, local);
    }
    
    public void addDLoad(final int local) {
        this.xop(38, 24, local);
    }
    
    public void addALoad(final int local) {
        this.xop(42, 25, local);
    }
    
    public void addLoadThis() {
        this.add(42);
    }
    
    private void xop(final int shortOp, final int op, final int local) {
        switch (local) {
            case 0: {
                this.add(shortOp);
                break;
            }
            case 1: {
                this.add(shortOp + 1);
                break;
            }
            case 2: {
                this.add(shortOp + 2);
                break;
            }
            case 3: {
                this.add(shortOp + 3);
                break;
            }
            default: {
                this.add(op, local);
                break;
            }
        }
    }
    
    public int addTableSwitch(final int low, final int high) {
        if (low > high) {
            throw new ClassFileFormatException("Bad bounds: " + low + ' ' + high);
        }
        final int newStack = this.itsStackTop + stackChange(170);
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        final int entryCount = high - low + 1;
        int padSize = 0x3 & ~this.itsCodeBufferTop;
        final int switchStart;
        int N = switchStart = this.addReservedCodeSpace(1 + padSize + 4 * (3 + entryCount));
        this.itsCodeBuffer[N++] = -86;
        while (padSize != 0) {
            this.itsCodeBuffer[N++] = 0;
            --padSize;
        }
        N += 4;
        N = putInt32(low, this.itsCodeBuffer, N);
        putInt32(high, this.itsCodeBuffer, N);
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
        return switchStart;
    }
    
    public final void markTableSwitchDefault(final int switchStart) {
        this.addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, switchStart);
        this.setTableSwitchJump(switchStart, -1, this.itsCodeBufferTop);
    }
    
    public final void markTableSwitchCase(final int switchStart, final int caseIndex) {
        this.addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, switchStart);
        this.setTableSwitchJump(switchStart, caseIndex, this.itsCodeBufferTop);
    }
    
    public final void markTableSwitchCase(final int switchStart, final int caseIndex, final int stackTop) {
        if (0 > stackTop || stackTop > this.itsMaxStack) {
            throw new IllegalArgumentException("Bad stack index: " + stackTop);
        }
        this.itsStackTop = (short)stackTop;
        this.addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, switchStart);
        this.setTableSwitchJump(switchStart, caseIndex, this.itsCodeBufferTop);
    }
    
    public void setTableSwitchJump(final int switchStart, final int caseIndex, final int jumpTarget) {
        if (jumpTarget < 0 || this.itsCodeBufferTop < jumpTarget) {
            throw new IllegalArgumentException("Bad jump target: " + jumpTarget);
        }
        if (caseIndex < -1) {
            throw new IllegalArgumentException("Bad case index: " + caseIndex);
        }
        final int padSize = 0x3 & ~switchStart;
        int caseOffset;
        if (caseIndex < 0) {
            caseOffset = switchStart + 1 + padSize;
        }
        else {
            caseOffset = switchStart + 1 + padSize + 4 * (3 + caseIndex);
        }
        if (switchStart < 0 || this.itsCodeBufferTop - 16 - padSize - 1 < switchStart) {
            throw new IllegalArgumentException(switchStart + " is outside a possible range of tableswitch in already generated code");
        }
        if ((0xFF & this.itsCodeBuffer[switchStart]) != 0xAA) {
            throw new IllegalArgumentException(switchStart + " is not offset of tableswitch statement");
        }
        if (caseOffset < 0 || this.itsCodeBufferTop < caseOffset + 4) {
            throw new ClassFileFormatException("Too big case index: " + caseIndex);
        }
        putInt32(jumpTarget - switchStart, this.itsCodeBuffer, caseOffset);
    }
    
    public int acquireLabel() {
        final int top = this.itsLabelTableTop;
        if (this.itsLabelTable == null || top == this.itsLabelTable.length) {
            if (this.itsLabelTable == null) {
                this.itsLabelTable = new int[32];
            }
            else {
                final int[] tmp = new int[this.itsLabelTable.length * 2];
                System.arraycopy(this.itsLabelTable, 0, tmp, 0, top);
                this.itsLabelTable = tmp;
            }
        }
        this.itsLabelTableTop = top + 1;
        this.itsLabelTable[top] = -1;
        return top | Integer.MIN_VALUE;
    }
    
    public void markLabel(int label) {
        if (label >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        label &= Integer.MAX_VALUE;
        if (label > this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        if (this.itsLabelTable[label] != -1) {
            throw new IllegalStateException("Can only mark label once");
        }
        this.itsLabelTable[label] = this.itsCodeBufferTop;
    }
    
    public void markLabel(final int label, final short stackTop) {
        this.markLabel(label);
        this.itsStackTop = stackTop;
    }
    
    public void markHandler(final int theLabel) {
        this.itsStackTop = 1;
        this.markLabel(theLabel);
    }
    
    public int getLabelPC(int label) {
        if (label >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        label &= Integer.MAX_VALUE;
        if (label >= this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        return this.itsLabelTable[label];
    }
    
    private void addLabelFixup(int label, final int fixupSite) {
        if (label >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        label &= Integer.MAX_VALUE;
        if (label >= this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        final int top = this.itsFixupTableTop;
        if (this.itsFixupTable == null || top == this.itsFixupTable.length) {
            if (this.itsFixupTable == null) {
                this.itsFixupTable = new long[40];
            }
            else {
                final long[] tmp = new long[this.itsFixupTable.length * 2];
                System.arraycopy(this.itsFixupTable, 0, tmp, 0, top);
                this.itsFixupTable = tmp;
            }
        }
        this.itsFixupTableTop = top + 1;
        this.itsFixupTable[top] = ((long)label << 32 | (long)fixupSite);
    }
    
    private void fixLabelGotos() {
        final byte[] codeBuffer = this.itsCodeBuffer;
        for (int i = 0; i < this.itsFixupTableTop; ++i) {
            final long fixup = this.itsFixupTable[i];
            final int label = (int)(fixup >> 32);
            final int fixupSite = (int)fixup;
            final int pc = this.itsLabelTable[label];
            if (pc == -1) {
                throw new RuntimeException("unlocated label");
            }
            this.addSuperBlockStart(pc);
            this.itsJumpFroms.put(pc, fixupSite - 1);
            final int offset = pc - (fixupSite - 1);
            if ((short)offset != offset) {
                throw new ClassFileFormatException("Program too complex: too big jump offset");
            }
            codeBuffer[fixupSite] = (byte)(offset >> 8);
            codeBuffer[fixupSite + 1] = (byte)offset;
        }
        this.itsFixupTableTop = 0;
    }
    
    public int getCurrentCodeOffset() {
        return this.itsCodeBufferTop;
    }
    
    public short getStackTop() {
        return this.itsStackTop;
    }
    
    public void setStackTop(final short n) {
        this.itsStackTop = n;
    }
    
    public void adjustStackTop(final int delta) {
        final int newStack = this.itsStackTop + delta;
        if (newStack < 0 || 32767 < newStack) {
            badStack(newStack);
        }
        this.itsStackTop = (short)newStack;
        if (newStack > this.itsMaxStack) {
            this.itsMaxStack = (short)newStack;
        }
    }
    
    private void addToCodeBuffer(final int b) {
        final int N = this.addReservedCodeSpace(1);
        this.itsCodeBuffer[N] = (byte)b;
    }
    
    private void addToCodeInt16(final int value) {
        final int N = this.addReservedCodeSpace(2);
        putInt16(value, this.itsCodeBuffer, N);
    }
    
    private int addReservedCodeSpace(final int size) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalArgumentException("No method to add to");
        }
        final int oldTop = this.itsCodeBufferTop;
        final int newTop = oldTop + size;
        if (newTop > this.itsCodeBuffer.length) {
            int newSize = this.itsCodeBuffer.length * 2;
            if (newTop > newSize) {
                newSize = newTop;
            }
            final byte[] tmp = new byte[newSize];
            System.arraycopy(this.itsCodeBuffer, 0, tmp, 0, oldTop);
            this.itsCodeBuffer = tmp;
        }
        this.itsCodeBufferTop = newTop;
        return oldTop;
    }
    
    public void addExceptionHandler(final int startLabel, final int endLabel, final int handlerLabel, final String catchClassName) {
        if ((startLabel & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad startLabel");
        }
        if ((endLabel & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad endLabel");
        }
        if ((handlerLabel & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad handlerLabel");
        }
        final short catch_type_index = (short)((catchClassName == null) ? 0 : this.itsConstantPool.addClass(catchClassName));
        final ExceptionTableEntry newEntry = new ExceptionTableEntry(startLabel, endLabel, handlerLabel, catch_type_index);
        final int N = this.itsExceptionTableTop;
        if (N == 0) {
            this.itsExceptionTable = new ExceptionTableEntry[4];
        }
        else if (N == this.itsExceptionTable.length) {
            final ExceptionTableEntry[] tmp = new ExceptionTableEntry[N * 2];
            System.arraycopy(this.itsExceptionTable, 0, tmp, 0, N);
            this.itsExceptionTable = tmp;
        }
        this.itsExceptionTable[N] = newEntry;
        this.itsExceptionTableTop = N + 1;
    }
    
    public void addLineNumberEntry(final short lineNumber) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalArgumentException("No method to stop");
        }
        final int N = this.itsLineNumberTableTop;
        if (N == 0) {
            this.itsLineNumberTable = new int[16];
        }
        else if (N == this.itsLineNumberTable.length) {
            final int[] tmp = new int[N * 2];
            System.arraycopy(this.itsLineNumberTable, 0, tmp, 0, N);
            this.itsLineNumberTable = tmp;
        }
        this.itsLineNumberTable[N] = (this.itsCodeBufferTop << 16) + lineNumber;
        this.itsLineNumberTableTop = N + 1;
    }
    
    private static char arrayTypeToName(final int type) {
        switch (type) {
            case 4: {
                return 'Z';
            }
            case 5: {
                return 'C';
            }
            case 6: {
                return 'F';
            }
            case 7: {
                return 'D';
            }
            case 8: {
                return 'B';
            }
            case 9: {
                return 'S';
            }
            case 10: {
                return 'I';
            }
            case 11: {
                return 'J';
            }
            default: {
                throw new IllegalArgumentException("bad operand");
            }
        }
    }
    
    private static String classDescriptorToInternalName(final String descriptor) {
        return descriptor.substring(1, descriptor.length() - 1);
    }
    
    private static String descriptorToInternalName(final String descriptor) {
        switch (descriptor.charAt(0)) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'V':
            case 'Z':
            case '[': {
                return descriptor;
            }
            case 'L': {
                return classDescriptorToInternalName(descriptor);
            }
            default: {
                throw new IllegalArgumentException("bad descriptor:" + descriptor);
            }
        }
    }
    
    private int[] createInitialLocals() {
        final int[] initialLocals = new int[this.itsMaxLocals];
        int localsTop = 0;
        if ((this.itsCurrentMethod.getFlags() & 0x8) == 0x0) {
            if ("<init>".equals(this.itsCurrentMethod.getName())) {
                initialLocals[localsTop++] = 6;
            }
            else {
                initialLocals[localsTop++] = TypeInfo.OBJECT(this.itsThisClassIndex);
            }
        }
        final String type = this.itsCurrentMethod.getType();
        final int lParenIndex = type.indexOf(40);
        final int rParenIndex = type.indexOf(41);
        if (lParenIndex != 0 || rParenIndex < 0) {
            throw new IllegalArgumentException("bad method type");
        }
        int start = lParenIndex + 1;
        final StringBuilder paramType = new StringBuilder();
        while (start < rParenIndex) {
            switch (type.charAt(start)) {
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'Z': {
                    paramType.append(type.charAt(start));
                    ++start;
                    break;
                }
                case 'L': {
                    final int end = type.indexOf(59, start) + 1;
                    final String name = type.substring(start, end);
                    paramType.append(name);
                    start = end;
                    break;
                }
                case '[': {
                    paramType.append('[');
                    ++start;
                    continue;
                }
            }
            final String internalType = descriptorToInternalName(paramType.toString());
            final int typeInfo = TypeInfo.fromType(internalType, this.itsConstantPool);
            initialLocals[localsTop++] = typeInfo;
            if (TypeInfo.isTwoWords(typeInfo)) {
                ++localsTop;
            }
            paramType.setLength(0);
        }
        return initialLocals;
    }
    
    public void write(final OutputStream oStream) throws IOException {
        final byte[] array = this.toByteArray();
        oStream.write(array);
    }
    
    private int getWriteSize() {
        int size = 0;
        if (this.itsSourceFileNameIndex != 0) {
            this.itsConstantPool.addUtf8("SourceFile");
        }
        size += 8;
        size += this.itsConstantPool.getWriteSize();
        size += 2;
        size += 2;
        size += 2;
        size += 2;
        size += 2 * this.itsInterfaces.size();
        size += 2;
        for (int i = 0; i < this.itsFields.size(); ++i) {
            size += ((ClassFileField)this.itsFields.get(i)).getWriteSize();
        }
        size += 2;
        for (int i = 0; i < this.itsMethods.size(); ++i) {
            size += ((ClassFileMethod)this.itsMethods.get(i)).getWriteSize();
        }
        size += 2;
        if (this.itsSourceFileNameIndex != 0) {
            size += 2;
            size += 4;
            size += 2;
        }
        if (this.itsBootstrapMethods != null) {
            size += 2;
            size += 4;
            size += 2;
            size += this.itsBootstrapMethodsLength;
        }
        return size;
    }
    
    public byte[] toByteArray() {
        short bootstrapMethodsAttrNameIndex = 0;
        int attributeCount = 0;
        short sourceFileAttributeNameIndex = 0;
        if (this.itsBootstrapMethods != null) {
            ++attributeCount;
            bootstrapMethodsAttrNameIndex = this.itsConstantPool.addUtf8("BootstrapMethods");
        }
        if (this.itsSourceFileNameIndex != 0) {
            ++attributeCount;
            sourceFileAttributeNameIndex = this.itsConstantPool.addUtf8("SourceFile");
        }
        int offset = 0;
        final int dataSize = this.getWriteSize();
        final byte[] data = new byte[dataSize];
        offset = putInt32(-889275714, data, offset);
        offset = putInt16(ClassFileWriter.MinorVersion, data, offset);
        offset = putInt16(ClassFileWriter.MajorVersion, data, offset);
        offset = this.itsConstantPool.write(data, offset);
        offset = putInt16(this.itsFlags, data, offset);
        offset = putInt16(this.itsThisClassIndex, data, offset);
        offset = putInt16(this.itsSuperClassIndex, data, offset);
        offset = putInt16(this.itsInterfaces.size(), data, offset);
        for (int i = 0; i < this.itsInterfaces.size(); ++i) {
            final int interfaceIndex = (short)this.itsInterfaces.get(i);
            offset = putInt16(interfaceIndex, data, offset);
        }
        offset = putInt16(this.itsFields.size(), data, offset);
        for (int i = 0; i < this.itsFields.size(); ++i) {
            final ClassFileField field = (ClassFileField)this.itsFields.get(i);
            offset = field.write(data, offset);
        }
        offset = putInt16(this.itsMethods.size(), data, offset);
        for (int i = 0; i < this.itsMethods.size(); ++i) {
            final ClassFileMethod method = (ClassFileMethod)this.itsMethods.get(i);
            offset = method.write(data, offset);
        }
        offset = putInt16(attributeCount, data, offset);
        if (this.itsBootstrapMethods != null) {
            offset = putInt16(bootstrapMethodsAttrNameIndex, data, offset);
            offset = putInt32(this.itsBootstrapMethodsLength + 2, data, offset);
            offset = putInt16(this.itsBootstrapMethods.size(), data, offset);
            for (int i = 0; i < this.itsBootstrapMethods.size(); ++i) {
                final BootstrapEntry entry = (BootstrapEntry)this.itsBootstrapMethods.get(i);
                System.arraycopy(entry.code, 0, data, offset, entry.code.length);
                offset += entry.code.length;
            }
        }
        if (this.itsSourceFileNameIndex != 0) {
            offset = putInt16(sourceFileAttributeNameIndex, data, offset);
            offset = putInt32(2, data, offset);
            offset = putInt16(this.itsSourceFileNameIndex, data, offset);
        }
        if (offset != dataSize) {
            throw new RuntimeException();
        }
        return data;
    }
    
    static int putInt64(final long value, final byte[] array, int offset) {
        offset = putInt32((int)(value >>> 32), array, offset);
        return putInt32((int)value, array, offset);
    }
    
    private static void badStack(final int value) {
        String s;
        if (value < 0) {
            s = "Stack underflow: " + value;
        }
        else {
            s = "Too big stack: " + value;
        }
        throw new IllegalStateException(s);
    }
    
    private static int sizeOfParameters(final String pString) {
        final int length = pString.length();
        final int rightParenthesis = pString.lastIndexOf(41);
        if (3 <= length && pString.charAt(0) == '(' && 1 <= rightParenthesis && rightParenthesis + 1 < length) {
            boolean ok = true;
            int index = 1;
            int stackDiff = 0;
            int count = 0;
        Label_0413:
            while (index != rightParenthesis) {
                Label_0365: {
                    switch (pString.charAt(index)) {
                        default: {
                            ok = false;
                            break Label_0413;
                        }
                        case 'D':
                        case 'J': {
                            --stackDiff;
                        }
                        case 'B':
                        case 'C':
                        case 'F':
                        case 'I':
                        case 'S':
                        case 'Z': {
                            --stackDiff;
                            ++count;
                            ++index;
                            continue;
                        }
                        case '[': {
                            ++index;
                            int c;
                            for (c = pString.charAt(index); c == 91; c = pString.charAt(index)) {
                                ++index;
                            }
                            switch (c) {
                                default: {
                                    ok = false;
                                    break Label_0413;
                                }
                                case 66:
                                case 67:
                                case 68:
                                case 70:
                                case 73:
                                case 74:
                                case 83:
                                case 90: {
                                    --stackDiff;
                                    ++count;
                                    ++index;
                                    continue;
                                }
                                case 76: {
                                    break Label_0365;
                                }
                            }
                            break;
                        }
                        case 'L': {
                            --stackDiff;
                            ++count;
                            ++index;
                            final int semicolon = pString.indexOf(59, index);
                            if (index + 1 > semicolon || semicolon >= rightParenthesis) {
                                ok = false;
                                break Label_0413;
                            }
                            index = semicolon + 1;
                            continue;
                        }
                    }
                }
            }
            if (ok) {
                switch (pString.charAt(rightParenthesis + 1)) {
                    case 'D':
                    case 'J': {
                        ++stackDiff;
                    }
                    case 'B':
                    case 'C':
                    case 'F':
                    case 'I':
                    case 'L':
                    case 'S':
                    case 'Z':
                    case '[': {
                        ++stackDiff;
                    }
                    default: {
                        ok = false;
                    }
                    case 'V': {
                        if (ok) {
                            return count << 16 | (0xFFFF & stackDiff);
                        }
                        break;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Bad parameter signature: " + pString);
    }
    
    static int putInt16(final int value, final byte[] array, final int offset) {
        array[offset + 0] = (byte)(value >>> 8);
        array[offset + 1] = (byte)value;
        return offset + 2;
    }
    
    static int putInt32(final int value, final byte[] array, final int offset) {
        array[offset + 0] = (byte)(value >>> 24);
        array[offset + 1] = (byte)(value >>> 16);
        array[offset + 2] = (byte)(value >>> 8);
        array[offset + 3] = (byte)value;
        return offset + 4;
    }
    
    private static int opcodeLength(final int opcode, final boolean wide) {
        switch (opcode) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 190:
            case 191:
            case 194:
            case 195:
            case 196:
            case 202:
            case 254:
            case 255: {
                return 1;
            }
            case 16:
            case 18:
            case 188: {
                return 2;
            }
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 169: {
                return wide ? 3 : 2;
            }
            case 17:
            case 19:
            case 20:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 187:
            case 189:
            case 192:
            case 193:
            case 198:
            case 199: {
                return 3;
            }
            case 132: {
                return wide ? 5 : 3;
            }
            case 197: {
                return 4;
            }
            case 185:
            case 186:
            case 200:
            case 201: {
                return 5;
            }
            default: {
                throw new IllegalArgumentException("Bad opcode: " + opcode);
            }
        }
    }
    
    private static int opcodeCount(final int opcode) {
        switch (opcode) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 190:
            case 191:
            case 194:
            case 195:
            case 196:
            case 202:
            case 254:
            case 255: {
                return 0;
            }
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 187:
            case 188:
            case 189:
            case 192:
            case 193:
            case 198:
            case 199:
            case 200:
            case 201: {
                return 1;
            }
            case 132:
            case 197: {
                return 2;
            }
            case 170:
            case 171: {
                return -1;
            }
            default: {
                throw new IllegalArgumentException("Bad opcode: " + opcode);
            }
        }
    }
    
    private static int stackChange(final int opcode) {
        switch (opcode) {
            case 80:
            case 82: {
                return -4;
            }
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 148:
            case 151:
            case 152: {
                return -3;
            }
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case 129:
            case 131:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 173:
            case 175: {
                return -2;
            }
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 128:
            case 130:
            case 136:
            case 137:
            case 142:
            case 144:
            case 149:
            case 150:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 174:
            case 176:
            case 180:
            case 181:
            case 182:
            case 183:
            case 185:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199: {
                return -1;
            }
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case 132:
            case 134:
            case 138:
            case 139:
            case 143:
            case 145:
            case 146:
            case 147:
            case 167:
            case 169:
            case 177:
            case 178:
            case 179:
            case 184:
            case 186:
            case 188:
            case 189:
            case 190:
            case 192:
            case 193:
            case 196:
            case 200:
            case 202:
            case 254:
            case 255: {
                return 0;
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case 133:
            case 135:
            case 140:
            case 141:
            case 168:
            case 187:
            case 197:
            case 201: {
                return 1;
            }
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94: {
                return 2;
            }
            default: {
                throw new IllegalArgumentException("Bad opcode: " + opcode);
            }
        }
    }
    
    private static String bytecodeStr(final int code) {
        return "";
    }
    
    final char[] getCharBuffer(final int minimalSize) {
        if (minimalSize > this.tmpCharBuffer.length) {
            int newSize = this.tmpCharBuffer.length * 2;
            if (minimalSize > newSize) {
                newSize = minimalSize;
            }
            this.tmpCharBuffer = new char[newSize];
        }
        return this.tmpCharBuffer;
    }
    
    private void addSuperBlockStart(final int pc) {
        if (ClassFileWriter.GenerateStackMap) {
            if (this.itsSuperBlockStarts == null) {
                this.itsSuperBlockStarts = new int[4];
            }
            else if (this.itsSuperBlockStarts.length == this.itsSuperBlockStartsTop) {
                final int[] tmp = new int[this.itsSuperBlockStartsTop * 2];
                System.arraycopy(this.itsSuperBlockStarts, 0, tmp, 0, this.itsSuperBlockStartsTop);
                this.itsSuperBlockStarts = tmp;
            }
            this.itsSuperBlockStarts[this.itsSuperBlockStartsTop++] = pc;
        }
    }
    
    private void finalizeSuperBlockStarts() {
        if (ClassFileWriter.GenerateStackMap) {
            for (int i = 0; i < this.itsExceptionTableTop; ++i) {
                final ExceptionTableEntry ete = this.itsExceptionTable[i];
                final int handlerPC = this.getLabelPC(ete.itsHandlerLabel);
                this.addSuperBlockStart(handlerPC);
            }
            Arrays.sort(this.itsSuperBlockStarts, 0, this.itsSuperBlockStartsTop);
            int prev = this.itsSuperBlockStarts[0];
            int copyTo = 1;
            for (int j = 1; j < this.itsSuperBlockStartsTop; ++j) {
                final int curr = this.itsSuperBlockStarts[j];
                if (prev != curr) {
                    if (copyTo != j) {
                        this.itsSuperBlockStarts[copyTo] = curr;
                    }
                    ++copyTo;
                    prev = curr;
                }
            }
            this.itsSuperBlockStartsTop = copyTo;
            if (this.itsSuperBlockStarts[copyTo - 1] == this.itsCodeBufferTop) {
                --this.itsSuperBlockStartsTop;
            }
        }
    }
    
    static {
        InputStream is = null;
        int major = 48;
        int minor = 0;
        try {
            is = ClassFileWriter.class.getResourceAsStream("ClassFileWriter.class");
            if (is == null) {
                is = ClassLoader.getSystemResourceAsStream("org/mozilla/classfile/ClassFileWriter.class");
            }
            final byte[] header = new byte[8];
            int c;
            for (int read = 0; read < 8; read += c) {
                c = is.read(header, read, 8 - read);
                if (c < 0) {
                    throw new IOException();
                }
            }
            minor = (header[4] << 8 | (header[5] & 0xFF));
            major = (header[6] << 8 | (header[7] & 0xFF));
        }
        catch (Exception ex) {}
        finally {
            MinorVersion = minor;
            MajorVersion = major;
            GenerateStackMap = (major >= 50);
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException ex2) {}
            }
        }
    }
    
    public static class ClassFileFormatException extends RuntimeException
    {
        private static final long serialVersionUID = 1263998431033790599L;
        
        ClassFileFormatException(final String message) {
            super(message);
        }
    }
    
    final class StackMapTable
    {
        private int[] locals;
        private int localsTop;
        private int[] stack;
        private int stackTop;
        private SuperBlock[] workList;
        private int workListTop;
        private SuperBlock[] superBlocks;
        private SuperBlock[] superBlockDeps;
        private byte[] rawStackMap;
        private int rawStackMapTop;
        private boolean wide;
        static final boolean DEBUGSTACKMAP = false;
        
        StackMapTable() {
            this.superBlocks = null;
            final int[] array = null;
            this.stack = array;
            this.locals = array;
            this.workList = null;
            this.rawStackMap = null;
            this.localsTop = 0;
            this.stackTop = 0;
            this.workListTop = 0;
            this.rawStackMapTop = 0;
            this.wide = false;
        }
        
        void generate() {
            this.superBlocks = new SuperBlock[ClassFileWriter.this.itsSuperBlockStartsTop];
            final int[] initialLocals = ClassFileWriter.this.createInitialLocals();
            for (int i = 0; i < ClassFileWriter.this.itsSuperBlockStartsTop; ++i) {
                final int start = ClassFileWriter.this.itsSuperBlockStarts[i];
                int end;
                if (i == ClassFileWriter.this.itsSuperBlockStartsTop - 1) {
                    end = ClassFileWriter.this.itsCodeBufferTop;
                }
                else {
                    end = ClassFileWriter.this.itsSuperBlockStarts[i + 1];
                }
                this.superBlocks[i] = new SuperBlock(i, start, end, initialLocals);
            }
            this.superBlockDeps = this.getSuperBlockDependencies();
            this.verify();
        }
        
        private SuperBlock getSuperBlockFromOffset(final int offset) {
            for (int i = 0; i < this.superBlocks.length; ++i) {
                final SuperBlock sb = this.superBlocks[i];
                if (sb == null) {
                    break;
                }
                if (offset >= sb.getStart() && offset < sb.getEnd()) {
                    return sb;
                }
            }
            throw new IllegalArgumentException("bad offset: " + offset);
        }
        
        private boolean isSuperBlockEnd(final int opcode) {
            switch (opcode) {
                case 167:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 176:
                case 177:
                case 191:
                case 200: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        
        private SuperBlock[] getSuperBlockDependencies() {
            final SuperBlock[] deps = new SuperBlock[this.superBlocks.length];
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; ++i) {
                final ExceptionTableEntry ete = ClassFileWriter.this.itsExceptionTable[i];
                final int startPC = ClassFileWriter.this.getLabelPC(ete.itsStartLabel);
                final int handlerPC = ClassFileWriter.this.getLabelPC(ete.itsHandlerLabel);
                final SuperBlock handlerSB = this.getSuperBlockFromOffset(handlerPC);
                final SuperBlock dep = this.getSuperBlockFromOffset(startPC);
                deps[handlerSB.getIndex()] = dep;
            }
            final int[] targetPCs = ClassFileWriter.this.itsJumpFroms.getKeys();
            for (int j = 0; j < targetPCs.length; ++j) {
                final int targetPC = targetPCs[j];
                final int branchPC = ClassFileWriter.this.itsJumpFroms.getInt(targetPC, -1);
                final SuperBlock branchSB = this.getSuperBlockFromOffset(branchPC);
                final SuperBlock targetSB = this.getSuperBlockFromOffset(targetPC);
                deps[targetSB.getIndex()] = branchSB;
            }
            return deps;
        }
        
        private SuperBlock getBranchTarget(final int bci) {
            int target;
            if ((ClassFileWriter.this.itsCodeBuffer[bci] & 0xFF) == 0xC8) {
                target = bci + this.getOperand(bci + 1, 4);
            }
            else {
                target = bci + (short)this.getOperand(bci + 1, 2);
            }
            return this.getSuperBlockFromOffset(target);
        }
        
        private boolean isBranch(final int opcode) {
            switch (opcode) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 198:
                case 199:
                case 200: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        
        private int getOperand(final int offset) {
            return this.getOperand(offset, 1);
        }
        
        private int getOperand(final int start, final int size) {
            int result = 0;
            if (size > 4) {
                throw new IllegalArgumentException("bad operand size");
            }
            for (int i = 0; i < size; ++i) {
                result = (result << 8 | (ClassFileWriter.this.itsCodeBuffer[start + i] & 0xFF));
            }
            return result;
        }
        
        private void verify() {
            final int[] initialLocals = ClassFileWriter.this.createInitialLocals();
            this.superBlocks[0].merge(initialLocals, initialLocals.length, new int[0], 0, ClassFileWriter.this.itsConstantPool);
            this.workList = new SuperBlock[] { this.superBlocks[0] };
            this.workListTop = 1;
            this.executeWorkList();
            for (int i = 0; i < this.superBlocks.length; ++i) {
                final SuperBlock sb = this.superBlocks[i];
                if (!sb.isInitialized()) {
                    this.killSuperBlock(sb);
                }
            }
            this.executeWorkList();
        }
        
        private void killSuperBlock(final SuperBlock sb) {
            int[] locals = new int[0];
            final int[] stack = { TypeInfo.OBJECT("java/lang/Throwable", ClassFileWriter.this.itsConstantPool) };
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; ++i) {
                final ExceptionTableEntry ete = ClassFileWriter.this.itsExceptionTable[i];
                final int eteStart = ClassFileWriter.this.getLabelPC(ete.itsStartLabel);
                final int eteEnd = ClassFileWriter.this.getLabelPC(ete.itsEndLabel);
                final int handlerPC = ClassFileWriter.this.getLabelPC(ete.itsHandlerLabel);
                final SuperBlock handlerSB = this.getSuperBlockFromOffset(handlerPC);
                if ((sb.getStart() > eteStart && sb.getStart() < eteEnd) || (eteStart > sb.getStart() && eteStart < sb.getEnd() && handlerSB.isInitialized())) {
                    locals = handlerSB.getLocals();
                    break;
                }
            }
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; ++i) {
                final ExceptionTableEntry ete = ClassFileWriter.this.itsExceptionTable[i];
                final int eteStart = ClassFileWriter.this.getLabelPC(ete.itsStartLabel);
                if (eteStart == sb.getStart()) {
                    for (int j = i + 1; j < ClassFileWriter.this.itsExceptionTableTop; ++j) {
                        ClassFileWriter.this.itsExceptionTable[j - 1] = ClassFileWriter.this.itsExceptionTable[j];
                    }
                    ClassFileWriter.this.itsExceptionTableTop--;
                    --i;
                }
            }
            sb.merge(locals, locals.length, stack, stack.length, ClassFileWriter.this.itsConstantPool);
            final int end = sb.getEnd() - 1;
            ClassFileWriter.this.itsCodeBuffer[end] = -65;
            for (int bci = sb.getStart(); bci < end; ++bci) {
                ClassFileWriter.this.itsCodeBuffer[bci] = 0;
            }
        }
        
        private void executeWorkList() {
            while (this.workListTop > 0) {
                final SuperBlock[] workList = this.workList;
                final int workListTop = this.workListTop - 1;
                this.workListTop = workListTop;
                final SuperBlock work = workList[workListTop];
                work.setInQueue(false);
                this.locals = work.getLocals();
                this.stack = work.getStack();
                this.localsTop = this.locals.length;
                this.stackTop = this.stack.length;
                this.executeBlock(work);
            }
        }
        
        private void executeBlock(final SuperBlock work) {
            int bc = 0;
            for (int next = 0, bci = work.getStart(); bci < work.getEnd(); bci += next) {
                bc = (ClassFileWriter.this.itsCodeBuffer[bci] & 0xFF);
                next = this.execute(bci);
                if (this.isBranch(bc)) {
                    final SuperBlock targetSB = this.getBranchTarget(bci);
                    this.flowInto(targetSB);
                }
                else if (bc == 170) {
                    final int switchStart = bci + 1 + (0x3 & ~bci);
                    final int defaultOffset = this.getOperand(switchStart, 4);
                    SuperBlock targetSB2 = this.getSuperBlockFromOffset(bci + defaultOffset);
                    this.flowInto(targetSB2);
                    final int low = this.getOperand(switchStart + 4, 4);
                    final int high = this.getOperand(switchStart + 8, 4);
                    final int numCases = high - low + 1;
                    final int caseBase = switchStart + 12;
                    for (int i = 0; i < numCases; ++i) {
                        final int label = bci + this.getOperand(caseBase + 4 * i, 4);
                        targetSB2 = this.getSuperBlockFromOffset(label);
                        this.flowInto(targetSB2);
                    }
                }
                for (int j = 0; j < ClassFileWriter.this.itsExceptionTableTop; ++j) {
                    final ExceptionTableEntry ete = ClassFileWriter.this.itsExceptionTable[j];
                    final int startPC = ClassFileWriter.this.getLabelPC(ete.itsStartLabel);
                    final int endPC = ClassFileWriter.this.getLabelPC(ete.itsEndLabel);
                    if (bci >= startPC) {
                        if (bci < endPC) {
                            final int handlerPC = ClassFileWriter.this.getLabelPC(ete.itsHandlerLabel);
                            final SuperBlock sb = this.getSuperBlockFromOffset(handlerPC);
                            int exceptionType;
                            if (ete.itsCatchType == 0) {
                                exceptionType = TypeInfo.OBJECT(ClassFileWriter.this.itsConstantPool.addClass("java/lang/Throwable"));
                            }
                            else {
                                exceptionType = TypeInfo.OBJECT(ete.itsCatchType);
                            }
                            sb.merge(this.locals, this.localsTop, new int[] { exceptionType }, 1, ClassFileWriter.this.itsConstantPool);
                            this.addToWorkList(sb);
                        }
                    }
                }
            }
            if (!this.isSuperBlockEnd(bc)) {
                final int nextIndex = work.getIndex() + 1;
                if (nextIndex < this.superBlocks.length) {
                    this.flowInto(this.superBlocks[nextIndex]);
                }
            }
        }
        
        private void flowInto(final SuperBlock sb) {
            if (sb.merge(this.locals, this.localsTop, this.stack, this.stackTop, ClassFileWriter.this.itsConstantPool)) {
                this.addToWorkList(sb);
            }
        }
        
        private void addToWorkList(final SuperBlock sb) {
            if (!sb.isInQueue()) {
                sb.setInQueue(true);
                sb.setInitialized(true);
                if (this.workListTop == this.workList.length) {
                    final SuperBlock[] tmp = new SuperBlock[this.workListTop * 2];
                    System.arraycopy(this.workList, 0, tmp, 0, this.workListTop);
                    this.workList = tmp;
                }
                this.workList[this.workListTop++] = sb;
            }
        }
        
        private int execute(final int bci) {
            final int bc = ClassFileWriter.this.itsCodeBuffer[bci] & 0xFF;
            int length = 0;
            Label_2307: {
                switch (bc) {
                    case 0:
                    case 132:
                    case 167:
                    case 200: {
                        break;
                    }
                    case 192: {
                        this.pop();
                        this.push(TypeInfo.OBJECT(this.getOperand(bci + 1, 2)));
                        break;
                    }
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86: {
                        this.pop();
                    }
                    case 159:
                    case 160:
                    case 161:
                    case 162:
                    case 163:
                    case 164:
                    case 165:
                    case 166:
                    case 181: {
                        this.pop();
                    }
                    case 87:
                    case 153:
                    case 154:
                    case 155:
                    case 156:
                    case 157:
                    case 158:
                    case 179:
                    case 194:
                    case 195:
                    case 198:
                    case 199: {
                        this.pop();
                        break;
                    }
                    case 88: {
                        this.pop2();
                        break;
                    }
                    case 1: {
                        this.push(5);
                        break;
                    }
                    case 46:
                    case 51:
                    case 52:
                    case 53:
                    case 96:
                    case 100:
                    case 104:
                    case 108:
                    case 112:
                    case 120:
                    case 122:
                    case 124:
                    case 126:
                    case 128:
                    case 130:
                    case 148:
                    case 149:
                    case 150:
                    case 151:
                    case 152: {
                        this.pop();
                    }
                    case 116:
                    case 136:
                    case 139:
                    case 142:
                    case 145:
                    case 146:
                    case 147:
                    case 190:
                    case 193: {
                        this.pop();
                    }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 16:
                    case 17:
                    case 21:
                    case 26:
                    case 27:
                    case 28:
                    case 29: {
                        this.push(1);
                        break;
                    }
                    case 47:
                    case 97:
                    case 101:
                    case 105:
                    case 109:
                    case 113:
                    case 121:
                    case 123:
                    case 125:
                    case 127:
                    case 129:
                    case 131: {
                        this.pop();
                    }
                    case 117:
                    case 133:
                    case 140:
                    case 143: {
                        this.pop();
                    }
                    case 9:
                    case 10:
                    case 22:
                    case 30:
                    case 31:
                    case 32:
                    case 33: {
                        this.push(4);
                        break;
                    }
                    case 48:
                    case 98:
                    case 102:
                    case 106:
                    case 110:
                    case 114: {
                        this.pop();
                    }
                    case 118:
                    case 134:
                    case 137:
                    case 144: {
                        this.pop();
                    }
                    case 11:
                    case 12:
                    case 13:
                    case 23:
                    case 34:
                    case 35:
                    case 36:
                    case 37: {
                        this.push(2);
                        break;
                    }
                    case 49:
                    case 99:
                    case 103:
                    case 107:
                    case 111:
                    case 115: {
                        this.pop();
                    }
                    case 119:
                    case 135:
                    case 138:
                    case 141: {
                        this.pop();
                    }
                    case 14:
                    case 15:
                    case 24:
                    case 38:
                    case 39:
                    case 40:
                    case 41: {
                        this.push(3);
                        break;
                    }
                    case 54: {
                        this.executeStore(this.getOperand(bci + 1, this.wide ? 2 : 1), 1);
                        break;
                    }
                    case 59:
                    case 60:
                    case 61:
                    case 62: {
                        this.executeStore(bc - 59, 1);
                        break;
                    }
                    case 55: {
                        this.executeStore(this.getOperand(bci + 1, this.wide ? 2 : 1), 4);
                        break;
                    }
                    case 63:
                    case 64:
                    case 65:
                    case 66: {
                        this.executeStore(bc - 63, 4);
                        break;
                    }
                    case 56: {
                        this.executeStore(this.getOperand(bci + 1, this.wide ? 2 : 1), 2);
                        break;
                    }
                    case 67:
                    case 68:
                    case 69:
                    case 70: {
                        this.executeStore(bc - 67, 2);
                        break;
                    }
                    case 57: {
                        this.executeStore(this.getOperand(bci + 1, this.wide ? 2 : 1), 3);
                        break;
                    }
                    case 71:
                    case 72:
                    case 73:
                    case 74: {
                        this.executeStore(bc - 71, 3);
                        break;
                    }
                    case 25: {
                        this.executeALoad(this.getOperand(bci + 1, this.wide ? 2 : 1));
                        break;
                    }
                    case 42:
                    case 43:
                    case 44:
                    case 45: {
                        this.executeALoad(bc - 42);
                        break;
                    }
                    case 58: {
                        this.executeAStore(this.getOperand(bci + 1, this.wide ? 2 : 1));
                        break;
                    }
                    case 75:
                    case 76:
                    case 77:
                    case 78: {
                        this.executeAStore(bc - 75);
                        break;
                    }
                    case 172:
                    case 173:
                    case 174:
                    case 175:
                    case 176:
                    case 177: {
                        this.clearStack();
                        break;
                    }
                    case 191: {
                        final int type = this.pop();
                        this.clearStack();
                        this.push(type);
                        break;
                    }
                    case 95: {
                        final int type = this.pop();
                        final int type2 = this.pop();
                        this.push(type);
                        this.push(type2);
                        break;
                    }
                    case 18:
                    case 19:
                    case 20: {
                        int index;
                        if (bc == 18) {
                            index = this.getOperand(bci + 1);
                        }
                        else {
                            index = this.getOperand(bci + 1, 2);
                        }
                        final byte constType = ClassFileWriter.this.itsConstantPool.getConstantType(index);
                        switch (constType) {
                            case 6: {
                                this.push(3);
                                break Label_2307;
                            }
                            case 4: {
                                this.push(2);
                                break Label_2307;
                            }
                            case 5: {
                                this.push(4);
                                break Label_2307;
                            }
                            case 3: {
                                this.push(1);
                                break Label_2307;
                            }
                            case 8: {
                                this.push(TypeInfo.OBJECT("java/lang/String", ClassFileWriter.this.itsConstantPool));
                                break Label_2307;
                            }
                            default: {
                                throw new IllegalArgumentException("bad const type " + constType);
                            }
                        }
                        break;
                    }
                    case 187: {
                        this.push(TypeInfo.UNINITIALIZED_VARIABLE(bci));
                        break;
                    }
                    case 188: {
                        this.pop();
                        final char componentType = arrayTypeToName(ClassFileWriter.this.itsCodeBuffer[bci + 1]);
                        final int index = ClassFileWriter.this.itsConstantPool.addClass("[" + componentType);
                        this.push(TypeInfo.OBJECT((short)index));
                        break;
                    }
                    case 189: {
                        final int index = this.getOperand(bci + 1, 2);
                        final String className = (String)ClassFileWriter.this.itsConstantPool.getConstantData(index);
                        this.pop();
                        this.push(TypeInfo.OBJECT("[L" + className + ';', ClassFileWriter.this.itsConstantPool));
                        break;
                    }
                    case 182:
                    case 183:
                    case 184:
                    case 185: {
                        final int index = this.getOperand(bci + 1, 2);
                        final FieldOrMethodRef m = (FieldOrMethodRef)ClassFileWriter.this.itsConstantPool.getConstantData(index);
                        final String methodType = m.getType();
                        final String methodName = m.getName();
                        for (int parameterCount = sizeOfParameters(methodType) >>> 16, i = 0; i < parameterCount; ++i) {
                            this.pop();
                        }
                        if (bc != 184) {
                            final int instType = this.pop();
                            final int tag = TypeInfo.getTag(instType);
                            if (tag == TypeInfo.UNINITIALIZED_VARIABLE(0) || tag == 6) {
                                if (!"<init>".equals(methodName)) {
                                    throw new IllegalStateException("bad instance");
                                }
                                final int newType = TypeInfo.OBJECT(ClassFileWriter.this.itsThisClassIndex);
                                this.initializeTypeInfo(instType, newType);
                            }
                        }
                        final int rParen = methodType.indexOf(41);
                        String returnType = methodType.substring(rParen + 1);
                        returnType = descriptorToInternalName(returnType);
                        if (!returnType.equals("V")) {
                            this.push(TypeInfo.fromType(returnType, ClassFileWriter.this.itsConstantPool));
                            break;
                        }
                        break;
                    }
                    case 186: {
                        final int index = this.getOperand(bci + 1, 2);
                        final String methodType = (String)ClassFileWriter.this.itsConstantPool.getConstantData(index);
                        for (int parameterCount = sizeOfParameters(methodType) >>> 16, j = 0; j < parameterCount; ++j) {
                            this.pop();
                        }
                        final int rParen = methodType.indexOf(41);
                        String returnType = methodType.substring(rParen + 1);
                        returnType = descriptorToInternalName(returnType);
                        if (!returnType.equals("V")) {
                            this.push(TypeInfo.fromType(returnType, ClassFileWriter.this.itsConstantPool));
                            break;
                        }
                        break;
                    }
                    case 180: {
                        this.pop();
                    }
                    case 178: {
                        final int index = this.getOperand(bci + 1, 2);
                        final FieldOrMethodRef f = (FieldOrMethodRef)ClassFileWriter.this.itsConstantPool.getConstantData(index);
                        final String fieldType = descriptorToInternalName(f.getType());
                        this.push(TypeInfo.fromType(fieldType, ClassFileWriter.this.itsConstantPool));
                        break;
                    }
                    case 89: {
                        final int type = this.pop();
                        this.push(type);
                        this.push(type);
                        break;
                    }
                    case 90: {
                        final int type = this.pop();
                        final int type2 = this.pop();
                        this.push(type);
                        this.push(type2);
                        this.push(type);
                        break;
                    }
                    case 91: {
                        final int type = this.pop();
                        final long lType = this.pop2();
                        this.push(type);
                        this.push2(lType);
                        this.push(type);
                        break;
                    }
                    case 92: {
                        final long lType = this.pop2();
                        this.push2(lType);
                        this.push2(lType);
                        break;
                    }
                    case 93: {
                        final long lType = this.pop2();
                        final int type = this.pop();
                        this.push2(lType);
                        this.push(type);
                        this.push2(lType);
                        break;
                    }
                    case 94: {
                        final long lType = this.pop2();
                        final long lType2 = this.pop2();
                        this.push2(lType);
                        this.push2(lType2);
                        this.push2(lType);
                        break;
                    }
                    case 170: {
                        final int switchStart = bci + 1 + (0x3 & ~bci);
                        final int low = this.getOperand(switchStart + 4, 4);
                        final int high = this.getOperand(switchStart + 8, 4);
                        length = 4 * (high - low + 4) + switchStart - bci;
                        this.pop();
                        break;
                    }
                    case 50: {
                        this.pop();
                        int typeIndex = this.pop() >>> 8;
                        final String arrayType;
                        final String className = arrayType = (String)ClassFileWriter.this.itsConstantPool.getConstantData(typeIndex);
                        if (arrayType.charAt(0) != '[') {
                            throw new IllegalStateException("bad array type");
                        }
                        final String elementDesc = arrayType.substring(1);
                        final String elementType = descriptorToInternalName(elementDesc);
                        typeIndex = ClassFileWriter.this.itsConstantPool.addClass(elementType);
                        this.push(TypeInfo.OBJECT(typeIndex));
                        break;
                    }
                    case 196: {
                        this.wide = true;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("bad opcode: " + bc);
                    }
                }
            }
            if (length == 0) {
                length = opcodeLength(bc, this.wide);
            }
            if (this.wide && bc != 196) {
                this.wide = false;
            }
            return length;
        }
        
        private void executeALoad(final int localIndex) {
            final int type = this.getLocal(localIndex);
            final int tag = TypeInfo.getTag(type);
            if (tag == 7 || tag == 6 || tag == 8 || tag == 5) {
                this.push(type);
                return;
            }
            throw new IllegalStateException("bad local variable type: " + type + " at index: " + localIndex);
        }
        
        private void executeAStore(final int localIndex) {
            this.setLocal(localIndex, this.pop());
        }
        
        private void executeStore(final int localIndex, final int typeInfo) {
            this.pop();
            this.setLocal(localIndex, typeInfo);
        }
        
        private void initializeTypeInfo(final int prevType, final int newType) {
            this.initializeTypeInfo(prevType, newType, this.locals, this.localsTop);
            this.initializeTypeInfo(prevType, newType, this.stack, this.stackTop);
        }
        
        private void initializeTypeInfo(final int prevType, final int newType, final int[] data, final int dataTop) {
            for (int i = 0; i < dataTop; ++i) {
                if (data[i] == prevType) {
                    data[i] = newType;
                }
            }
        }
        
        private int getLocal(final int localIndex) {
            if (localIndex < this.localsTop) {
                return this.locals[localIndex];
            }
            return 0;
        }
        
        private void setLocal(final int localIndex, final int typeInfo) {
            if (localIndex >= this.localsTop) {
                final int[] tmp = new int[localIndex + 1];
                System.arraycopy(this.locals, 0, tmp, 0, this.localsTop);
                this.locals = tmp;
                this.localsTop = localIndex + 1;
            }
            this.locals[localIndex] = typeInfo;
        }
        
        private void push(final int typeInfo) {
            if (this.stackTop == this.stack.length) {
                final int[] tmp = new int[Math.max(this.stackTop * 2, 4)];
                System.arraycopy(this.stack, 0, tmp, 0, this.stackTop);
                this.stack = tmp;
            }
            this.stack[this.stackTop++] = typeInfo;
        }
        
        private int pop() {
            final int[] stack = this.stack;
            final int stackTop = this.stackTop - 1;
            this.stackTop = stackTop;
            return stack[stackTop];
        }
        
        private void push2(long typeInfo) {
            this.push((int)(typeInfo & 0xFFFFFFL));
            typeInfo >>>= 32;
            if (typeInfo != 0L) {
                this.push((int)(typeInfo & 0xFFFFFFL));
            }
        }
        
        private long pop2() {
            final long type = this.pop();
            if (TypeInfo.isTwoWords((int)type)) {
                return type;
            }
            return type << 32 | (long)(this.pop() & 0xFFFFFF);
        }
        
        private void clearStack() {
            this.stackTop = 0;
        }
        
        int computeWriteSize() {
            final int writeSize = this.getWorstCaseWriteSize();
            this.rawStackMap = new byte[writeSize];
            this.computeRawStackMap();
            return this.rawStackMapTop + 2;
        }
        
        int write(final byte[] data, int offset) {
            offset = ClassFileWriter.putInt32(this.rawStackMapTop + 2, data, offset);
            offset = ClassFileWriter.putInt16(this.superBlocks.length - 1, data, offset);
            System.arraycopy(this.rawStackMap, 0, data, offset, this.rawStackMapTop);
            return offset + this.rawStackMapTop;
        }
        
        private void computeRawStackMap() {
            SuperBlock prev = this.superBlocks[0];
            int[] prevLocals = prev.getTrimmedLocals();
            int prevOffset = -1;
            for (int i = 1; i < this.superBlocks.length; ++i) {
                final SuperBlock current = this.superBlocks[i];
                final int[] currentLocals = current.getTrimmedLocals();
                final int[] currentStack = current.getStack();
                final int offsetDelta = current.getStart() - prevOffset - 1;
                if (currentStack.length == 0) {
                    final int last = (prevLocals.length > currentLocals.length) ? currentLocals.length : prevLocals.length;
                    final int delta = Math.abs(prevLocals.length - currentLocals.length);
                    int j;
                    for (j = 0; j < last && prevLocals[j] == currentLocals[j]; ++j) {}
                    if (j == currentLocals.length && delta == 0) {
                        this.writeSameFrame(offsetDelta);
                    }
                    else if (j == currentLocals.length && delta <= 3) {
                        this.writeChopFrame(delta, offsetDelta);
                    }
                    else if (j == prevLocals.length && delta <= 3) {
                        this.writeAppendFrame(currentLocals, delta, offsetDelta);
                    }
                    else {
                        this.writeFullFrame(currentLocals, currentStack, offsetDelta);
                    }
                }
                else if (currentStack.length == 1) {
                    if (Arrays.equals(prevLocals, currentLocals)) {
                        this.writeSameLocalsOneStackItemFrame(currentStack, offsetDelta);
                    }
                    else {
                        this.writeFullFrame(currentLocals, currentStack, offsetDelta);
                    }
                }
                else {
                    this.writeFullFrame(currentLocals, currentStack, offsetDelta);
                }
                prev = current;
                prevLocals = currentLocals;
                prevOffset = current.getStart();
            }
        }
        
        private int getWorstCaseWriteSize() {
            return (this.superBlocks.length - 1) * (7 + ClassFileWriter.this.itsMaxLocals * 3 + ClassFileWriter.this.itsMaxStack * 3);
        }
        
        private void writeSameFrame(final int offsetDelta) {
            if (offsetDelta <= 63) {
                this.rawStackMap[this.rawStackMapTop++] = (byte)offsetDelta;
            }
            else {
                this.rawStackMap[this.rawStackMapTop++] = -5;
                this.rawStackMapTop = ClassFileWriter.putInt16(offsetDelta, this.rawStackMap, this.rawStackMapTop);
            }
        }
        
        private void writeSameLocalsOneStackItemFrame(final int[] stack, final int offsetDelta) {
            if (offsetDelta <= 63) {
                this.rawStackMap[this.rawStackMapTop++] = (byte)(64 + offsetDelta);
            }
            else {
                this.rawStackMap[this.rawStackMapTop++] = -9;
                this.rawStackMapTop = ClassFileWriter.putInt16(offsetDelta, this.rawStackMap, this.rawStackMapTop);
            }
            this.writeType(stack[0]);
        }
        
        private void writeFullFrame(final int[] locals, final int[] stack, final int offsetDelta) {
            this.rawStackMap[this.rawStackMapTop++] = -1;
            this.rawStackMapTop = ClassFileWriter.putInt16(offsetDelta, this.rawStackMap, this.rawStackMapTop);
            this.rawStackMapTop = ClassFileWriter.putInt16(locals.length, this.rawStackMap, this.rawStackMapTop);
            this.rawStackMapTop = this.writeTypes(locals);
            this.rawStackMapTop = ClassFileWriter.putInt16(stack.length, this.rawStackMap, this.rawStackMapTop);
            this.rawStackMapTop = this.writeTypes(stack);
        }
        
        private void writeAppendFrame(final int[] locals, final int localsDelta, final int offsetDelta) {
            final int start = locals.length - localsDelta;
            this.rawStackMap[this.rawStackMapTop++] = (byte)(251 + localsDelta);
            this.rawStackMapTop = ClassFileWriter.putInt16(offsetDelta, this.rawStackMap, this.rawStackMapTop);
            this.rawStackMapTop = this.writeTypes(locals, start);
        }
        
        private void writeChopFrame(final int localsDelta, final int offsetDelta) {
            this.rawStackMap[this.rawStackMapTop++] = (byte)(251 - localsDelta);
            this.rawStackMapTop = ClassFileWriter.putInt16(offsetDelta, this.rawStackMap, this.rawStackMapTop);
        }
        
        private int writeTypes(final int[] types) {
            return this.writeTypes(types, 0);
        }
        
        private int writeTypes(final int[] types, final int start) {
            for (int i = start; i < types.length; ++i) {
                this.rawStackMapTop = this.writeType(types[i]);
            }
            return this.rawStackMapTop;
        }
        
        private int writeType(final int type) {
            final int tag = type & 0xFF;
            this.rawStackMap[this.rawStackMapTop++] = (byte)tag;
            if (tag == 7 || tag == 8) {
                this.rawStackMapTop = ClassFileWriter.putInt16(type >>> 8, this.rawStackMap, this.rawStackMapTop);
            }
            return this.rawStackMapTop;
        }
    }
    
    final class BootstrapEntry
    {
        final byte[] code;
        
        BootstrapEntry(final MHandle bsm, final Object... bsmArgs) {
            final int length = 4 + bsmArgs.length * 2;
            this.code = new byte[length];
            ClassFileWriter.putInt16(ClassFileWriter.this.itsConstantPool.addMethodHandle(bsm), this.code, 0);
            ClassFileWriter.putInt16(bsmArgs.length, this.code, 2);
            for (int i = 0; i < bsmArgs.length; ++i) {
                ClassFileWriter.putInt16(ClassFileWriter.this.itsConstantPool.addConstant(bsmArgs[i]), this.code, 4 + i * 2);
            }
        }
        
        @Override
        public boolean equals(final Object obj) {
            return obj instanceof BootstrapEntry && Arrays.equals(this.code, ((BootstrapEntry)obj).code);
        }
        
        @Override
        public int hashCode() {
            return ~Arrays.hashCode(this.code);
        }
    }
    
    public static final class MHandle
    {
        final byte tag;
        final String owner;
        final String name;
        final String desc;
        
        public MHandle(final byte tag, final String owner, final String name, final String desc) {
            this.tag = tag;
            this.owner = owner;
            this.name = name;
            this.desc = desc;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MHandle)) {
                return false;
            }
            final MHandle mh = (MHandle)obj;
            return this.tag == mh.tag && this.owner.equals(mh.owner) && this.name.equals(mh.name) && this.desc.equals(mh.desc);
        }
        
        @Override
        public int hashCode() {
            return this.tag + this.owner.hashCode() * this.name.hashCode() * this.desc.hashCode();
        }
        
        @Override
        public String toString() {
            return this.owner + '.' + this.name + this.desc + " (" + this.tag + ')';
        }
    }
}
