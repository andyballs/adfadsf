//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.util.*;
import com.fasterxml.jackson.core.*;

public abstract class StreamReadException extends JsonProcessingException
{
    static final long serialVersionUID = 2L;
    protected transient JsonParser _processor;
    protected RequestPayload _requestPayload;
    
    protected StreamReadException(final JsonParser p, final String msg) {
        super(msg, (p == null) ? null : p.getCurrentLocation());
        this._processor = p;
    }
    
    protected StreamReadException(final JsonParser p, final String msg, final Throwable root) {
        super(msg, (p == null) ? null : p.getCurrentLocation(), root);
        this._processor = p;
    }
    
    protected StreamReadException(final JsonParser p, final String msg, final JsonLocation loc) {
        super(msg, loc, null);
        this._processor = p;
    }
    
    protected StreamReadException(final JsonParser p, final String msg, final JsonLocation loc, final Throwable rootCause) {
        super(msg, loc, rootCause);
        this._processor = p;
    }
    
    protected StreamReadException(final String msg, final JsonLocation loc, final Throwable rootCause) {
        super(msg, loc, rootCause);
    }
    
    public abstract StreamReadException withParser(final JsonParser p0);
    
    public abstract StreamReadException withRequestPayload(final RequestPayload p0);
    
    @Override
    public JsonParser getProcessor() {
        return this._processor;
    }
    
    public RequestPayload getRequestPayload() {
        return this._requestPayload;
    }
    
    public String getRequestPayloadAsString() {
        return (this._requestPayload != null) ? this._requestPayload.toString() : null;
    }
    
    @Override
    public String getMessage() {
        String msg = super.getMessage();
        if (this._requestPayload != null) {
            msg = msg + "\nRequest payload : " + this._requestPayload.toString();
        }
        return msg;
    }
}
