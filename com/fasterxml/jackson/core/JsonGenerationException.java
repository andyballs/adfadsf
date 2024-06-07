//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.*;

public class JsonGenerationException extends StreamWriteException
{
    private static final long serialVersionUID = 123L;
    
    @Deprecated
    public JsonGenerationException(final Throwable rootCause) {
        super(rootCause, (JsonGenerator)null);
    }
    
    @Deprecated
    public JsonGenerationException(final String msg) {
        super(msg, (JsonGenerator)null);
    }
    
    @Deprecated
    public JsonGenerationException(final String msg, final Throwable rootCause) {
        super(msg, rootCause, (JsonGenerator)null);
    }
    
    public JsonGenerationException(final Throwable rootCause, final JsonGenerator g) {
        super(rootCause, g);
    }
    
    public JsonGenerationException(final String msg, final JsonGenerator g) {
        super(msg, g);
        this._processor = g;
    }
    
    public JsonGenerationException(final String msg, final Throwable rootCause, final JsonGenerator g) {
        super(msg, rootCause, g);
        this._processor = g;
    }
    
    public JsonGenerationException withGenerator(final JsonGenerator g) {
        this._processor = g;
        return this;
    }
    
    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
