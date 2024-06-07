//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public final class ScriptStackElement implements Serializable
{
    private static final long serialVersionUID = -6416688260860477449L;
    public final String fileName;
    public final String functionName;
    public final int lineNumber;
    
    public ScriptStackElement(final String fileName, final String functionName, final int lineNumber) {
        this.fileName = fileName;
        this.functionName = functionName;
        this.lineNumber = lineNumber;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        this.renderMozillaStyle(sb);
        return sb.toString();
    }
    
    public void renderJavaStyle(final StringBuilder sb) {
        sb.append("\tat ").append(this.fileName);
        if (this.lineNumber > -1) {
            sb.append(':').append(this.lineNumber);
        }
        if (this.functionName != null) {
            sb.append(" (").append(this.functionName).append(')');
        }
    }
    
    public void renderMozillaStyle(final StringBuilder sb) {
        if (this.functionName != null) {
            sb.append(this.functionName).append("()");
        }
        sb.append('@').append(this.fileName);
        if (this.lineNumber > -1) {
            sb.append(':').append(this.lineNumber);
        }
    }
    
    public void renderV8Style(final StringBuilder sb) {
        sb.append("    at ");
        if (this.functionName == null || "anonymous".equals(this.functionName) || "undefined".equals(this.functionName)) {
            this.appendV8Location(sb);
        }
        else {
            sb.append(this.functionName).append(" (");
            this.appendV8Location(sb);
            sb.append(')');
        }
    }
    
    private void appendV8Location(final StringBuilder sb) {
        sb.append(this.fileName).append(':');
        sb.append((this.lineNumber > -1) ? this.lineNumber : 0).append(":0");
    }
}
