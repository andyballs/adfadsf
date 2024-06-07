//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

public class JsonProcessingException extends JacksonException
{
    private static final long serialVersionUID = 123L;
    protected JsonLocation _location;
    
    protected JsonProcessingException(final String msg, final JsonLocation loc, final Throwable rootCause) {
        super(msg, rootCause);
        this._location = loc;
    }
    
    protected JsonProcessingException(final String msg) {
        super(msg);
    }
    
    protected JsonProcessingException(final String msg, final JsonLocation loc) {
        this(msg, loc, null);
    }
    
    protected JsonProcessingException(final String msg, final Throwable rootCause) {
        this(msg, null, rootCause);
    }
    
    protected JsonProcessingException(final Throwable rootCause) {
        this(null, null, rootCause);
    }
    
    public JsonLocation getLocation() {
        return this._location;
    }
    
    public void clearLocation() {
        this._location = null;
    }
    
    public String getOriginalMessage() {
        return super.getMessage();
    }
    
    public Object getProcessor() {
        return null;
    }
    
    protected String getMessageSuffix() {
        return null;
    }
    
    public String getMessage() {
        String msg = super.getMessage();
        if (msg == null) {
            msg = "N/A";
        }
        final JsonLocation loc = this.getLocation();
        final String suffix = this.getMessageSuffix();
        if (loc != null || suffix != null) {
            final StringBuilder sb = new StringBuilder(100);
            sb.append(msg);
            if (suffix != null) {
                sb.append(suffix);
            }
            if (loc != null) {
                sb.append('\n');
                sb.append(" at ");
                sb.append(loc.toString());
            }
            msg = sb.toString();
        }
        return msg;
    }
    
    public String toString() {
        return this.getClass().getName() + ": " + this.getMessage();
    }
}
