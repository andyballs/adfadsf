//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.*;

public class JsonEOFException extends JsonParseException
{
    private static final long serialVersionUID = 1L;
    protected final JsonToken _token;
    
    public JsonEOFException(final JsonParser p, final JsonToken token, final String msg) {
        super(p, msg);
        this._token = token;
    }
    
    public JsonToken getTokenBeingDecoded() {
        return this._token;
    }
}
