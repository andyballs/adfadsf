//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.*;
import java.io.*;
import java.math.*;

public class TokenFilter
{
    public static final TokenFilter INCLUDE_ALL;
    
    protected TokenFilter() {
    }
    
    public TokenFilter filterStartObject() {
        return this;
    }
    
    public TokenFilter filterStartArray() {
        return this;
    }
    
    public void filterFinishObject() {
    }
    
    public void filterFinishArray() {
    }
    
    public TokenFilter includeProperty(final String name) {
        return this;
    }
    
    public TokenFilter includeElement(final int index) {
        return this;
    }
    
    public TokenFilter includeRootValue(final int index) {
        return this;
    }
    
    public boolean includeValue(final JsonParser p) throws IOException {
        return this._includeScalar();
    }
    
    public boolean includeBoolean(final boolean value) {
        return this._includeScalar();
    }
    
    public boolean includeNull() {
        return this._includeScalar();
    }
    
    public boolean includeString(final String value) {
        return this._includeScalar();
    }
    
    public boolean includeString(final Reader r, final int maxLen) {
        return this._includeScalar();
    }
    
    public boolean includeNumber(final int value) {
        return this._includeScalar();
    }
    
    public boolean includeNumber(final long value) {
        return this._includeScalar();
    }
    
    public boolean includeNumber(final float value) {
        return this._includeScalar();
    }
    
    public boolean includeNumber(final double value) {
        return this._includeScalar();
    }
    
    public boolean includeNumber(final BigDecimal value) {
        return this._includeScalar();
    }
    
    public boolean includeNumber(final BigInteger value) {
        return this._includeScalar();
    }
    
    public boolean includeBinary() {
        return this._includeScalar();
    }
    
    public boolean includeRawValue() {
        return this._includeScalar();
    }
    
    public boolean includeEmbeddedValue(final Object value) {
        return this._includeScalar();
    }
    
    @Override
    public String toString() {
        if (this == TokenFilter.INCLUDE_ALL) {
            return "TokenFilter.INCLUDE_ALL";
        }
        return super.toString();
    }
    
    protected boolean _includeScalar() {
        return true;
    }
    
    static {
        INCLUDE_ALL = new TokenFilter();
    }
    
    public enum Inclusion
    {
        ONLY_INCLUDE_ALL, 
        INCLUDE_ALL_AND_PATH, 
        INCLUDE_NON_NULL;
    }
}
