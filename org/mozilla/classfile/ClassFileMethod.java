//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

final class ClassFileMethod
{
    private String itsName;
    private String itsType;
    private short itsNameIndex;
    private short itsTypeIndex;
    private short itsFlags;
    private byte[] itsCodeAttribute;
    
    ClassFileMethod(final String name, final short nameIndex, final String type, final short typeIndex, final short flags) {
        this.itsName = name;
        this.itsNameIndex = nameIndex;
        this.itsType = type;
        this.itsTypeIndex = typeIndex;
        this.itsFlags = flags;
    }
    
    void setCodeAttribute(final byte[] codeAttribute) {
        this.itsCodeAttribute = codeAttribute;
    }
    
    int write(final byte[] data, int offset) {
        offset = ClassFileWriter.putInt16(this.itsFlags, data, offset);
        offset = ClassFileWriter.putInt16(this.itsNameIndex, data, offset);
        offset = ClassFileWriter.putInt16(this.itsTypeIndex, data, offset);
        offset = ClassFileWriter.putInt16(1, data, offset);
        System.arraycopy(this.itsCodeAttribute, 0, data, offset, this.itsCodeAttribute.length);
        offset += this.itsCodeAttribute.length;
        return offset;
    }
    
    int getWriteSize() {
        return 8 + this.itsCodeAttribute.length;
    }
    
    String getName() {
        return this.itsName;
    }
    
    String getType() {
        return this.itsType;
    }
    
    short getFlags() {
        return this.itsFlags;
    }
}
