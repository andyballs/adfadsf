//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class EcmaError extends RhinoException
{
    private static final long serialVersionUID = -6261226256957286699L;
    private String errorName;
    private String errorMessage;
    
    EcmaError(final String errorName, final String errorMessage, final String sourceName, final int lineNumber, final String lineSource, final int columnNumber) {
        this.recordErrorOrigin(sourceName, lineNumber, lineSource, columnNumber);
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }
    
    @Deprecated
    public EcmaError(final Scriptable nativeError, final String sourceName, final int lineNumber, final int columnNumber, final String lineSource) {
        this("InternalError", ScriptRuntime.toString(nativeError), sourceName, lineNumber, lineSource, columnNumber);
    }
    
    @Override
    public String details() {
        return this.errorName + ": " + this.errorMessage;
    }
    
    public String getName() {
        return this.errorName;
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
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
    
    @Deprecated
    public Scriptable getErrorObject() {
        return null;
    }
}
