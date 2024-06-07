//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.*;
import com.fasterxml.jackson.core.util.*;

public class JsonParseException extends StreamReadException
{
    private static final long serialVersionUID = 2L;
    
    @Deprecated
    public JsonParseException(final String msg, final JsonLocation loc) {
        super(msg, loc, (Throwable)null);
    }
    
    @Deprecated
    public JsonParseException(final String msg, final JsonLocation loc, final Throwable root) {
        super(msg, loc, root);
    }
    
    public JsonParseException(final JsonParser p, final String msg) {
        super(p, msg);
    }
    
    public JsonParseException(final JsonParser p, final String msg, final Throwable root) {
        super(p, msg, root);
    }
    
    public JsonParseException(final JsonParser p, final String msg, final JsonLocation loc) {
        super(p, msg, loc);
    }
    
    public JsonParseException(final JsonParser p, final String msg, final JsonLocation loc, final Throwable root) {
        super(msg, loc, root);
    }
    
    public JsonParseException withParser(final JsonParser p) {
        this._processor = p;
        return this;
    }
    
    public JsonParseException withRequestPayload(final RequestPayload payload) {
        this._requestPayload = payload;
        return this;
    }
    
    public JsonParser getProcessor() {
        return super.getProcessor();
    }
    
    public RequestPayload getRequestPayload() {
        return super.getRequestPayload();
    }
    
    public String getRequestPayloadAsString() {
        return super.getRequestPayloadAsString();
    }
    
    public String getMessage() {
        return super.getMessage();
    }
}
