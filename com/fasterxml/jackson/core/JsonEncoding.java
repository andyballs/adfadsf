//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

public enum JsonEncoding
{
    UTF8("UTF-8", false, 8), 
    UTF16_BE("UTF-16BE", true, 16), 
    UTF16_LE("UTF-16LE", false, 16), 
    UTF32_BE("UTF-32BE", true, 32), 
    UTF32_LE("UTF-32LE", false, 32);
    
    private final String _javaName;
    private final boolean _bigEndian;
    private final int _bits;
    
    private JsonEncoding(final String javaName, final boolean bigEndian, final int bits) {
        this._javaName = javaName;
        this._bigEndian = bigEndian;
        this._bits = bits;
    }
    
    public String getJavaName() {
        return this._javaName;
    }
    
    public boolean isBigEndian() {
        return this._bigEndian;
    }
    
    public int bits() {
        return this._bits;
    }
}
