//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class WrappedException extends EvaluatorException
{
    private static final long serialVersionUID = -1551979216966520648L;
    private Throwable exception;
    
    public WrappedException(final Throwable exception) {
        super("Wrapped " + exception.toString());
        this.initCause(this.exception = exception);
        final int[] linep = { 0 };
        final String sourceName = Context.getSourcePositionFromStack(linep);
        final int lineNumber = linep[0];
        if (sourceName != null) {
            this.initSourceName(sourceName);
        }
        if (lineNumber != 0) {
            this.initLineNumber(lineNumber);
        }
    }
    
    public Throwable getWrappedException() {
        return this.exception;
    }
    
    @Deprecated
    public Object unwrap() {
        return this.getWrappedException();
    }
}
