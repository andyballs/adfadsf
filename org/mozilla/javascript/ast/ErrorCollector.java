//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class ErrorCollector implements IdeErrorReporter
{
    private List<ParseProblem> errors;
    
    public ErrorCollector() {
        this.errors = new ArrayList<ParseProblem>();
    }
    
    @Override
    public void warning(final String message, final String sourceName, final int line, final String lineSource, final int lineOffset) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void warning(final String message, final String sourceName, final int offset, final int length) {
        this.errors.add(new ParseProblem(ParseProblem.Type.Warning, message, sourceName, offset, length));
    }
    
    @Override
    public void error(final String message, final String sourceName, final int line, final String lineSource, final int lineOffset) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void error(final String message, final String sourceName, final int fileOffset, final int length) {
        this.errors.add(new ParseProblem(ParseProblem.Type.Error, message, sourceName, fileOffset, length));
    }
    
    @Override
    public EvaluatorException runtimeError(final String message, final String sourceName, final int line, final String lineSource, final int lineOffset) {
        throw new UnsupportedOperationException();
    }
    
    public List<ParseProblem> getErrors() {
        return this.errors;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.errors.size() * 100);
        for (final ParseProblem pp : this.errors) {
            sb.append(pp.toString()).append("\n");
        }
        return sb.toString();
    }
}
