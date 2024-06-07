//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

public class ParseProblem
{
    private Type type;
    private String message;
    private String sourceName;
    private int offset;
    private int length;
    
    public ParseProblem(final Type type, final String message, final String sourceName, final int offset, final int length) {
        this.setType(type);
        this.setMessage(message);
        this.setSourceName(sourceName);
        this.setFileOffset(offset);
        this.setLength(length);
    }
    
    public Type getType() {
        return this.type;
    }
    
    public void setType(final Type type) {
        this.type = type;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String msg) {
        this.message = msg;
    }
    
    public String getSourceName() {
        return this.sourceName;
    }
    
    public void setSourceName(final String name) {
        this.sourceName = name;
    }
    
    public int getFileOffset() {
        return this.offset;
    }
    
    public void setFileOffset(final int offset) {
        this.offset = offset;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setLength(final int length) {
        this.length = length;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(200);
        sb.append(this.sourceName).append(":");
        sb.append("offset=").append(this.offset).append(",");
        sb.append("length=").append(this.length).append(",");
        sb.append((this.type == Type.Error) ? "error: " : "warning: ");
        sb.append(this.message);
        return sb.toString();
    }
    
    public enum Type
    {
        Error, 
        Warning;
    }
}
