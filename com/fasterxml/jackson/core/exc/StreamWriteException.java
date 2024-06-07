//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.*;

public abstract class StreamWriteException extends JsonProcessingException
{
    private static final long serialVersionUID = 2L;
    protected transient JsonGenerator _processor;
    
    protected StreamWriteException(final Throwable rootCause, final JsonGenerator g) {
        super(rootCause);
        this._processor = g;
    }
    
    protected StreamWriteException(final String msg, final JsonGenerator g) {
        super(msg, (JsonLocation)null);
        this._processor = g;
    }
    
    protected StreamWriteException(final String msg, final Throwable rootCause, final JsonGenerator g) {
        super(msg, null, rootCause);
        this._processor = g;
    }
    
    public abstract StreamWriteException withGenerator(final JsonGenerator p0);
    
    @Override
    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
