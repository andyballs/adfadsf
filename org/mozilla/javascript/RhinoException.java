//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public abstract class RhinoException extends RuntimeException
{
    private static final Pattern JAVA_STACK_PATTERN;
    private static final long serialVersionUID = 1883500631321581169L;
    private static StackStyle stackStyle;
    private String sourceName;
    private int lineNumber;
    private String lineSource;
    private int columnNumber;
    Object interpreterStackInfo;
    int[] interpreterLineData;
    
    RhinoException() {
        final Evaluator e = Context.createInterpreter();
        if (e != null) {
            e.captureStackInfo(this);
        }
    }
    
    RhinoException(final String details) {
        super(details);
        final Evaluator e = Context.createInterpreter();
        if (e != null) {
            e.captureStackInfo(this);
        }
    }
    
    @Override
    public final String getMessage() {
        final String details = this.details();
        if (this.sourceName == null || this.lineNumber <= 0) {
            return details;
        }
        final StringBuilder buf = new StringBuilder(details);
        buf.append(" (");
        if (this.sourceName != null) {
            buf.append(this.sourceName);
        }
        if (this.lineNumber > 0) {
            buf.append('#');
            buf.append(this.lineNumber);
        }
        buf.append(')');
        return buf.toString();
    }
    
    public String details() {
        return super.getMessage();
    }
    
    public final String sourceName() {
        return this.sourceName;
    }
    
    public final void initSourceName(final String sourceName) {
        if (sourceName == null) {
            throw new IllegalArgumentException();
        }
        if (this.sourceName != null) {
            throw new IllegalStateException();
        }
        this.sourceName = sourceName;
    }
    
    public final int lineNumber() {
        return this.lineNumber;
    }
    
    public final void initLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException(String.valueOf(lineNumber));
        }
        if (this.lineNumber > 0) {
            throw new IllegalStateException();
        }
        this.lineNumber = lineNumber;
    }
    
    public final int columnNumber() {
        return this.columnNumber;
    }
    
    public final void initColumnNumber(final int columnNumber) {
        if (columnNumber <= 0) {
            throw new IllegalArgumentException(String.valueOf(columnNumber));
        }
        if (this.columnNumber > 0) {
            throw new IllegalStateException();
        }
        this.columnNumber = columnNumber;
    }
    
    public final String lineSource() {
        return this.lineSource;
    }
    
    public final void initLineSource(final String lineSource) {
        if (lineSource == null) {
            throw new IllegalArgumentException();
        }
        if (this.lineSource != null) {
            throw new IllegalStateException();
        }
        this.lineSource = lineSource;
    }
    
    final void recordErrorOrigin(final String sourceName, int lineNumber, final String lineSource, final int columnNumber) {
        if (lineNumber == -1) {
            lineNumber = 0;
        }
        if (sourceName != null) {
            this.initSourceName(sourceName);
        }
        if (lineNumber != 0) {
            this.initLineNumber(lineNumber);
        }
        if (lineSource != null) {
            this.initLineSource(lineSource);
        }
        if (columnNumber != 0) {
            this.initColumnNumber(columnNumber);
        }
    }
    
    private String generateStackTrace() {
        final CharArrayWriter writer = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(writer));
        final String origStackTrace = writer.toString();
        final Evaluator e = Context.createInterpreter();
        if (e != null) {
            return e.getPatchedStack(this, origStackTrace);
        }
        return null;
    }
    
    public String getScriptStackTrace() {
        return this.getScriptStackTrace(-1, null);
    }
    
    public String getScriptStackTrace(final int limit, final String functionName) {
        final ScriptStackElement[] stack = this.getScriptStack(limit, functionName);
        return formatStackTrace(stack, this.details());
    }
    
    static String formatStackTrace(final ScriptStackElement[] stack, final String message) {
        final StringBuilder buffer = new StringBuilder();
        final String lineSeparator = SecurityUtilities.getSystemProperty("line.separator");
        if (RhinoException.stackStyle == StackStyle.V8 && !"null".equals(message)) {
            buffer.append(message);
            buffer.append(lineSeparator);
        }
        for (final ScriptStackElement elem : stack) {
            switch (RhinoException.stackStyle) {
                case MOZILLA: {
                    elem.renderMozillaStyle(buffer);
                    break;
                }
                case V8: {
                    elem.renderV8Style(buffer);
                    break;
                }
                case RHINO: {
                    elem.renderJavaStyle(buffer);
                    break;
                }
            }
            buffer.append(lineSeparator);
        }
        return buffer.toString();
    }
    
    @Deprecated
    public String getScriptStackTrace(final FilenameFilter filter) {
        return this.getScriptStackTrace();
    }
    
    public ScriptStackElement[] getScriptStack() {
        return this.getScriptStack(-1, null);
    }
    
    public ScriptStackElement[] getScriptStack(final int limit, final String hideFunction) {
        final List<ScriptStackElement> list = new ArrayList<ScriptStackElement>();
        ScriptStackElement[][] interpreterStack = null;
        if (this.interpreterStackInfo != null) {
            final Evaluator interpreter = Context.createInterpreter();
            if (interpreter instanceof Interpreter) {
                interpreterStack = ((Interpreter)interpreter).getScriptStackElements(this);
            }
        }
        int interpreterStackIndex = 0;
        final StackTraceElement[] stack = this.getStackTrace();
        int count = 0;
        boolean printStarted = hideFunction == null;
        for (final StackTraceElement e : stack) {
            final String fileName = e.getFileName();
            if (e.getMethodName().startsWith("_c_") && e.getLineNumber() > -1 && fileName != null && !fileName.endsWith(".java")) {
                String methodName = e.getMethodName();
                final Matcher match = RhinoException.JAVA_STACK_PATTERN.matcher(methodName);
                methodName = ((!"_c_script_0".equals(methodName) && match.find()) ? match.group(1) : null);
                if (!printStarted && hideFunction.equals(methodName)) {
                    printStarted = true;
                }
                else if (printStarted && (limit < 0 || count < limit)) {
                    list.add(new ScriptStackElement(fileName, methodName, e.getLineNumber()));
                    ++count;
                }
            }
            else if ("org.mozilla.javascript.Interpreter".equals(e.getClassName()) && "interpretLoop".equals(e.getMethodName()) && interpreterStack != null && interpreterStack.length > interpreterStackIndex) {
                for (final ScriptStackElement elem : interpreterStack[interpreterStackIndex++]) {
                    if (!printStarted && hideFunction.equals(elem.functionName)) {
                        printStarted = true;
                    }
                    else if (printStarted && (limit < 0 || count < limit)) {
                        list.add(elem);
                        ++count;
                    }
                }
            }
        }
        return list.toArray(new ScriptStackElement[list.size()]);
    }
    
    @Override
    public void printStackTrace(final PrintWriter s) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(s);
        }
        else {
            s.print(this.generateStackTrace());
        }
    }
    
    @Override
    public void printStackTrace(final PrintStream s) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(s);
        }
        else {
            s.print(this.generateStackTrace());
        }
    }
    
    public static boolean usesMozillaStackStyle() {
        return RhinoException.stackStyle == StackStyle.MOZILLA;
    }
    
    public static void useMozillaStackStyle(final boolean flag) {
        RhinoException.stackStyle = (flag ? StackStyle.MOZILLA : StackStyle.RHINO);
    }
    
    public static void setStackStyle(final StackStyle style) {
        RhinoException.stackStyle = style;
    }
    
    public static StackStyle getStackStyle() {
        return RhinoException.stackStyle;
    }
    
    static {
        JAVA_STACK_PATTERN = Pattern.compile("_c_(.*)_\\d+");
        RhinoException.stackStyle = StackStyle.RHINO;
        final String style = System.getProperty("rhino.stack.style");
        if (style != null) {
            if ("Rhino".equalsIgnoreCase(style)) {
                RhinoException.stackStyle = StackStyle.RHINO;
            }
            else if ("Mozilla".equalsIgnoreCase(style)) {
                RhinoException.stackStyle = StackStyle.MOZILLA;
            }
            else if ("V8".equalsIgnoreCase(style)) {
                RhinoException.stackStyle = StackStyle.V8;
            }
        }
    }
}
