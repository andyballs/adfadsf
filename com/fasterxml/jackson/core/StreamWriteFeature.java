//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.*;

public enum StreamWriteFeature implements JacksonFeature
{
    AUTO_CLOSE_TARGET(JsonGenerator.Feature.AUTO_CLOSE_TARGET), 
    AUTO_CLOSE_CONTENT(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT), 
    FLUSH_PASSED_TO_STREAM(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM), 
    WRITE_BIGDECIMAL_AS_PLAIN(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN), 
    STRICT_DUPLICATE_DETECTION(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION), 
    IGNORE_UNKNOWN(JsonGenerator.Feature.IGNORE_UNKNOWN);
    
    private final boolean _defaultState;
    private final int _mask;
    private final JsonGenerator.Feature _mappedFeature;
    
    private StreamWriteFeature(final JsonGenerator.Feature mappedTo) {
        this._mappedFeature = mappedTo;
        this._mask = mappedTo.getMask();
        this._defaultState = mappedTo.enabledByDefault();
    }
    
    public static int collectDefaults() {
        int flags = 0;
        for (final StreamWriteFeature f : values()) {
            if (f.enabledByDefault()) {
                flags |= f.getMask();
            }
        }
        return flags;
    }
    
    @Override
    public boolean enabledByDefault() {
        return this._defaultState;
    }
    
    @Override
    public boolean enabledIn(final int flags) {
        return (flags & this._mask) != 0x0;
    }
    
    @Override
    public int getMask() {
        return this._mask;
    }
    
    public JsonGenerator.Feature mappedFeature() {
        return this._mappedFeature;
    }
}
