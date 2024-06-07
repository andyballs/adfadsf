//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import kotlin.*;
import java.io.*;
import org.jetbrains.annotations.*;
import org.mozilla.javascript.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J6\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J>\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J6\u0010\u0016\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSErrorReporter;", "Lorg/mozilla/javascript/ErrorReporter;", "outputStream", "Ljava/io/PrintWriter;", "(Ljava/io/PrintWriter;)V", "buildIndicator", "", "offset", "", "error", "", "message", "sourceName", "line", "lineSource", "lineOffset", "reportErrorMessage", "inputMessage", "isWarning", "", "runtimeError", "Lorg/mozilla/javascript/EvaluatorException;", "warning", "Companion", "ctjs" })
public final class JSErrorReporter implements ErrorReporter
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final PrintWriter outputStream;
    @NotNull
    public static final String MESSAGE_PREFIX = "js: ";
    
    public JSErrorReporter(@NotNull final PrintWriter outputStream) {
        Intrinsics.checkNotNullParameter((Object)outputStream, "outputStream");
        this.outputStream = outputStream;
    }
    
    public void warning(@Nullable final String message, @Nullable final String sourceName, final int line, @Nullable final String lineSource, final int lineOffset) {
        this.reportErrorMessage(message, sourceName, line, lineSource, lineOffset, true);
    }
    
    public void error(@Nullable final String message, @Nullable final String sourceName, final int line, @Nullable final String lineSource, final int lineOffset) {
        this.reportErrorMessage(message, sourceName, line, lineSource, lineOffset, false);
    }
    
    private final void reportErrorMessage(final String inputMessage, final String sourceName, final int line, final String lineSource, final int lineOffset, final boolean isWarning) {
        String message = (line > 0) ? ((sourceName == null) ? ("line " + line + ": " + (Object)inputMessage) : new StringBuilder().append('\"').append((Object)sourceName).append("\", line ").append(line).append(": ").append((Object)inputMessage).toString()) : inputMessage;
        if (isWarning) {
            message = Intrinsics.stringPlus("warning: ", (Object)message);
        }
        this.outputStream.println(Intrinsics.stringPlus("js: ", (Object)message));
        if (lineSource != null) {
            this.outputStream.println(Intrinsics.stringPlus("js: ", (Object)lineSource));
            this.outputStream.println(Intrinsics.stringPlus("js: ", (Object)this.buildIndicator(lineOffset)));
        }
    }
    
    private final String buildIndicator(final int offset) {
        final StringBuilder $this$buildIndicator_u24lambda_u2d1;
        final StringBuilder sb = $this$buildIndicator_u24lambda_u2d1 = new StringBuilder();
        final int n = 0;
        for (int i = 0; i < offset; ++i) {
            final int it = i;
            final int n2 = 0;
            $this$buildIndicator_u24lambda_u2d1.append('.');
        }
        $this$buildIndicator_u24lambda_u2d1.append('^');
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
    
    @NotNull
    public EvaluatorException runtimeError(@Nullable final String message, @Nullable final String sourceName, final int line, @Nullable final String lineSource, final int lineOffset) {
        return new EvaluatorException(message, sourceName, line, lineSource, lineOffset);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSErrorReporter$Companion;", "", "()V", "MESSAGE_PREFIX", "", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
