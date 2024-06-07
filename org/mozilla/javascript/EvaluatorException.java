//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class EvaluatorException extends RhinoException
{
    private static final long serialVersionUID = -8743165779676009808L;
    
    public EvaluatorException(final String detail) {
        super(detail);
    }
    
    public EvaluatorException(final String detail, final String sourceName, final int lineNumber) {
        this(detail, sourceName, lineNumber, null, 0);
    }
    
    public EvaluatorException(final String detail, final String sourceName, final int lineNumber, final String lineSource, final int columnNumber) {
        super(detail);
        this.recordErrorOrigin(sourceName, lineNumber, lineSource, columnNumber);
    }
    
    @Deprecated
    public String getSourceName() {
        return this.sourceName();
    }
    
    @Deprecated
    public int getLineNumber() {
        return this.lineNumber();
    }
    
    @Deprecated
    public int getColumnNumber() {
        return this.columnNumber();
    }
    
    @Deprecated
    public String getLineSource() {
        return this.lineSource();
    }
}
