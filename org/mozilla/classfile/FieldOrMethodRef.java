//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

final class FieldOrMethodRef
{
    private String className;
    private String name;
    private String type;
    private int hashCode;
    
    FieldOrMethodRef(final String className, final String name, final String type) {
        this.hashCode = -1;
        this.className = className;
        this.name = name;
        this.type = type;
    }
    
    public String getClassName() {
        return this.className;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getType() {
        return this.type;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof FieldOrMethodRef)) {
            return false;
        }
        final FieldOrMethodRef x = (FieldOrMethodRef)obj;
        return this.className.equals(x.className) && this.name.equals(x.name) && this.type.equals(x.type);
    }
    
    @Override
    public int hashCode() {
        if (this.hashCode == -1) {
            final int h1 = this.className.hashCode();
            final int h2 = this.name.hashCode();
            final int h3 = this.type.hashCode();
            this.hashCode = (h1 ^ h2 ^ h3);
        }
        return this.hashCode;
    }
}
