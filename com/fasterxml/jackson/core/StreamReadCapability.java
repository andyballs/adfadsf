//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.*;

public enum StreamReadCapability implements JacksonFeature
{
    DUPLICATE_PROPERTIES(false), 
    SCALARS_AS_OBJECTS(false), 
    UNTYPED_SCALARS(false);
    
    private final boolean _defaultState;
    private final int _mask;
    
    private StreamReadCapability(final boolean defaultState) {
        this._defaultState = defaultState;
        this._mask = 1 << this.ordinal();
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
}
