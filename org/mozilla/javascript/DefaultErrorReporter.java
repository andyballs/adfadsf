//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

class DefaultErrorReporter implements ErrorReporter
{
    static final DefaultErrorReporter instance;
    private boolean forEval;
    private ErrorReporter chainedReporter;
    
    private DefaultErrorReporter() {
    }
    
    static ErrorReporter forEval(final ErrorReporter reporter) {
        final DefaultErrorReporter r = new DefaultErrorReporter();
        r.forEval = true;
        r.chainedReporter = reporter;
        return r;
    }
    
    @Override
    public void warning(final String message, final String sourceURI, final int line, final String lineText, final int lineOffset) {
        if (this.chainedReporter != null) {
            this.chainedReporter.warning(message, sourceURI, line, lineText, lineOffset);
        }
    }
    
    @Override
    public void error(String message, final String sourceURI, final int line, final String lineText, final int lineOffset) {
        if (this.forEval) {
            String error = "SyntaxError";
            final String TYPE_ERROR_NAME = "TypeError";
            final String DELIMETER = ": ";
            final String prefix = "TypeError: ";
            if (message.startsWith("TypeError: ")) {
                error = "TypeError";
                message = message.substring("TypeError: ".length());
            }
            throw ScriptRuntime.constructError(error, message, sourceURI, line, lineText, lineOffset);
        }
        if (this.chainedReporter != null) {
            this.chainedReporter.error(message, sourceURI, line, lineText, lineOffset);
            return;
        }
        throw this.runtimeError(message, sourceURI, line, lineText, lineOffset);
    }
    
    @Override
    public EvaluatorException runtimeError(final String message, final String sourceURI, final int line, final String lineText, final int lineOffset) {
        if (this.chainedReporter != null) {
            return this.chainedReporter.runtimeError(message, sourceURI, line, lineText, lineOffset);
        }
        return new EvaluatorException(message, sourceURI, line, lineText, lineOffset);
    }
    
    static {
        instance = new DefaultErrorReporter();
    }
}
