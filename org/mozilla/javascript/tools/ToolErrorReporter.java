//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools;

import java.io.*;
import java.util.*;
import java.text.*;
import org.mozilla.javascript.*;

public class ToolErrorReporter implements ErrorReporter
{
    private static final String messagePrefix = "js: ";
    private boolean hasReportedErrorFlag;
    private boolean reportWarnings;
    private PrintStream err;
    
    public ToolErrorReporter(final boolean reportWarnings) {
        this(reportWarnings, System.err);
    }
    
    public ToolErrorReporter(final boolean reportWarnings, final PrintStream err) {
        this.reportWarnings = reportWarnings;
        this.err = err;
    }
    
    public static String getMessage(final String messageId) {
        return getMessage(messageId, (Object[])null);
    }
    
    public static String getMessage(final String messageId, final String argument) {
        final Object[] args = { argument };
        return getMessage(messageId, args);
    }
    
    public static String getMessage(final String messageId, final Object arg1, final Object arg2) {
        final Object[] args = { arg1, arg2 };
        return getMessage(messageId, args);
    }
    
    public static String getMessage(final String messageId, final Object[] args) {
        final Context cx = Context.getCurrentContext();
        final Locale locale = (cx == null) ? Locale.getDefault() : cx.getLocale();
        final ResourceBundle rb = ResourceBundle.getBundle("org.mozilla.javascript.tools.resources.Messages", locale);
        String formatString;
        try {
            formatString = rb.getString(messageId);
        }
        catch (MissingResourceException mre) {
            throw new RuntimeException("no message resource found for message property " + messageId);
        }
        if (args == null) {
            return formatString;
        }
        final MessageFormat formatter = new MessageFormat(formatString);
        return formatter.format(args);
    }
    
    private static String getExceptionMessage(final RhinoException ex) {
        String msg;
        if (ex instanceof JavaScriptException) {
            msg = getMessage("msg.uncaughtJSException", ex.details());
        }
        else if (ex instanceof EcmaError) {
            msg = getMessage("msg.uncaughtEcmaError", ex.details());
        }
        else if (ex instanceof EvaluatorException) {
            msg = ex.details();
        }
        else {
            msg = ex.toString();
        }
        return msg;
    }
    
    public void warning(final String message, final String sourceName, final int line, final String lineSource, final int lineOffset) {
        if (!this.reportWarnings) {
            return;
        }
        this.reportErrorMessage(message, sourceName, line, lineSource, lineOffset, true);
    }
    
    public void error(final String message, final String sourceName, final int line, final String lineSource, final int lineOffset) {
        this.hasReportedErrorFlag = true;
        this.reportErrorMessage(message, sourceName, line, lineSource, lineOffset, false);
    }
    
    public EvaluatorException runtimeError(final String message, final String sourceName, final int line, final String lineSource, final int lineOffset) {
        return new EvaluatorException(message, sourceName, line, lineSource, lineOffset);
    }
    
    public boolean hasReportedError() {
        return this.hasReportedErrorFlag;
    }
    
    public boolean isReportingWarnings() {
        return this.reportWarnings;
    }
    
    public void setIsReportingWarnings(final boolean reportWarnings) {
        this.reportWarnings = reportWarnings;
    }
    
    public static void reportException(final ErrorReporter er, final RhinoException ex) {
        if (er instanceof ToolErrorReporter) {
            ((ToolErrorReporter)er).reportException(ex);
        }
        else {
            final String msg = getExceptionMessage(ex);
            er.error(msg, ex.sourceName(), ex.lineNumber(), ex.lineSource(), ex.columnNumber());
        }
    }
    
    public void reportException(final RhinoException ex) {
        if (ex instanceof WrappedException) {
            final WrappedException we = (WrappedException)ex;
            we.printStackTrace(this.err);
        }
        else {
            final String lineSeparator = SecurityUtilities.getSystemProperty("line.separator");
            final String msg = getExceptionMessage(ex) + lineSeparator + ex.getScriptStackTrace();
            this.reportErrorMessage(msg, ex.sourceName(), ex.lineNumber(), ex.lineSource(), ex.columnNumber(), false);
        }
    }
    
    private void reportErrorMessage(String message, final String sourceName, final int line, final String lineSource, final int lineOffset, final boolean justWarning) {
        if (line > 0) {
            final String lineStr = String.valueOf(line);
            if (sourceName != null) {
                final Object[] args = { sourceName, lineStr, message };
                message = getMessage("msg.format3", args);
            }
            else {
                final Object[] args = { lineStr, message };
                message = getMessage("msg.format2", args);
            }
        }
        else {
            final Object[] args2 = { message };
            message = getMessage("msg.format1", args2);
        }
        if (justWarning) {
            message = getMessage("msg.warning", message);
        }
        this.err.println("js: " + message);
        if (null != lineSource) {
            this.err.println("js: " + lineSource);
            this.err.println("js: " + this.buildIndicator(lineOffset));
        }
    }
    
    private String buildIndicator(final int offset) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < offset - 1; ++i) {
            sb.append(".");
        }
        sb.append("^");
        return sb.toString();
    }
}
