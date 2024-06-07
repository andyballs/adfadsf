//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

final class ConstantEntry
{
    private int type;
    private int intval;
    private long longval;
    private String str1;
    private String str2;
    private int hashcode;
    
    ConstantEntry(final int type, final int intval, final String str1, final String str2) {
        this.type = type;
        this.intval = intval;
        this.str1 = str1;
        this.str2 = str2;
        this.hashcode = (type ^ intval + str1.hashCode() * str2.hashCode());
    }
    
    @Override
    public int hashCode() {
        return this.hashcode;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof ConstantEntry)) {
            return false;
        }
        final ConstantEntry entry = (ConstantEntry)obj;
        if (this.type != entry.type) {
            return false;
        }
        switch (this.type) {
            case 3:
            case 4: {
                return this.intval == entry.intval;
            }
            case 5:
            case 6: {
                return this.longval == entry.longval;
            }
            case 12: {
                return this.str1.equals(entry.str1) && this.str2.equals(entry.str2);
            }
            case 18: {
                return this.intval == entry.intval && this.str1.equals(entry.str1) && this.str2.equals(entry.str2);
            }
            default: {
                throw new RuntimeException("unsupported constant type");
            }
        }
    }
}
