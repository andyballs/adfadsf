//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;

public class InputCoercionException extends StreamReadException
{
    private static final long serialVersionUID = 1L;
    protected final JsonToken _inputType;
    protected final Class<?> _targetType;
    
    public InputCoercionException(final JsonParser p, final String msg, final JsonToken inputType, final Class<?> targetType) {
        super(p, msg);
        this._inputType = inputType;
        this._targetType = targetType;
    }
    
    @Override
    public InputCoercionException withParser(final JsonParser p) {
        this._processor = p;
        return this;
    }
    
    @Override
    public InputCoercionException withRequestPayload(final RequestPayload p) {
        this._requestPayload = p;
        return this;
    }
    
    public JsonToken getInputType() {
        return this._inputType;
    }
    
    public Class<?> getTargetType() {
        return this._targetType;
    }
}
