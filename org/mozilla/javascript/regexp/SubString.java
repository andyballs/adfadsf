//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

public class SubString
{
    String str;
    int index;
    int length;
    
    public SubString() {
    }
    
    public SubString(final String str) {
        this.str = str;
        this.index = 0;
        this.length = str.length();
    }
    
    public SubString(final String source, final int start, final int len) {
        this.str = source;
        this.index = start;
        this.length = len;
    }
    
    @Override
    public String toString() {
        return (this.str == null) ? "" : this.str.substring(this.index, this.index + this.length);
    }
}
