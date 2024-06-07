//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import org.mozilla.javascript.debug.*;
import java.util.*;

final class InterpreterData implements Serializable, DebuggableScript
{
    private static final long serialVersionUID = 5067677351589230234L;
    static final int INITIAL_MAX_ICODE_LENGTH = 1024;
    static final int INITIAL_STRINGTABLE_SIZE = 64;
    static final int INITIAL_NUMBERTABLE_SIZE = 64;
    String itsName;
    String itsSourceFile;
    boolean itsNeedsActivation;
    int itsFunctionType;
    String[] itsStringTable;
    double[] itsDoubleTable;
    InterpreterData[] itsNestedFunctions;
    Object[] itsRegExpLiterals;
    byte[] itsICode;
    int[] itsExceptionTable;
    int itsMaxVars;
    int itsMaxLocals;
    int itsMaxStack;
    int itsMaxFrameArray;
    String[] argNames;
    boolean[] argIsConst;
    int argCount;
    int itsMaxCalleeArgs;
    String encodedSource;
    int encodedSourceStart;
    int encodedSourceEnd;
    int languageVersion;
    boolean isStrict;
    boolean topLevel;
    Object[] literalIds;
    UintMap longJumps;
    int firstLinePC;
    InterpreterData parentData;
    boolean evalScriptFlag;
    private int icodeHashCode;
    boolean declaredAsVar;
    boolean declaredAsFunctionExpression;
    
    InterpreterData(final int languageVersion, final String sourceFile, final String encodedSource, final boolean isStrict) {
        this.firstLinePC = -1;
        this.icodeHashCode = 0;
        this.languageVersion = languageVersion;
        this.itsSourceFile = sourceFile;
        this.encodedSource = encodedSource;
        this.isStrict = isStrict;
        this.init();
    }
    
    InterpreterData(final InterpreterData parent) {
        this.firstLinePC = -1;
        this.icodeHashCode = 0;
        this.parentData = parent;
        this.languageVersion = parent.languageVersion;
        this.itsSourceFile = parent.itsSourceFile;
        this.encodedSource = parent.encodedSource;
        this.isStrict = parent.isStrict;
        this.init();
    }
    
    private void init() {
        this.itsICode = new byte[1024];
        this.itsStringTable = new String[64];
    }
    
    public boolean isTopLevel() {
        return this.topLevel;
    }
    
    public boolean isFunction() {
        return this.itsFunctionType != 0;
    }
    
    public String getFunctionName() {
        return this.itsName;
    }
    
    public int getParamCount() {
        return this.argCount;
    }
    
    public int getParamAndVarCount() {
        return this.argNames.length;
    }
    
    public String getParamOrVarName(final int index) {
        return this.argNames[index];
    }
    
    public boolean getParamOrVarConst(final int index) {
        return this.argIsConst[index];
    }
    
    public String getSourceName() {
        return this.itsSourceFile;
    }
    
    public boolean isGeneratedScript() {
        return ScriptRuntime.isGeneratedScript(this.itsSourceFile);
    }
    
    public int[] getLineNumbers() {
        return Interpreter.getLineNumbers(this);
    }
    
    public int getFunctionCount() {
        return (this.itsNestedFunctions == null) ? 0 : this.itsNestedFunctions.length;
    }
    
    public DebuggableScript getFunction(final int index) {
        return (DebuggableScript)this.itsNestedFunctions[index];
    }
    
    public DebuggableScript getParent() {
        return (DebuggableScript)this.parentData;
    }
    
    public int icodeHashCode() {
        int h = this.icodeHashCode;
        if (h == 0) {
            h = (this.icodeHashCode = Arrays.hashCode(this.itsICode));
        }
        return h;
    }
}
