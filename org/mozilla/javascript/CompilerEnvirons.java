//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import org.mozilla.javascript.ast.*;

public class CompilerEnvirons
{
    private ErrorReporter errorReporter;
    private int languageVersion;
    private boolean generateDebugInfo;
    private boolean reservedKeywordAsIdentifier;
    private int optimizationLevel;
    private boolean generatingSource;
    private boolean strictMode;
    private boolean warningAsError;
    private boolean generateObserverCount;
    private boolean recordingComments;
    private boolean recordingLocalJsDocComments;
    private boolean recoverFromErrors;
    private boolean warnTrailingComma;
    private boolean ideMode;
    private boolean allowSharpComments;
    Set<String> activationNames;
    
    public CompilerEnvirons() {
        this.errorReporter = DefaultErrorReporter.instance;
        this.languageVersion = 0;
        this.generateDebugInfo = true;
        this.reservedKeywordAsIdentifier = true;
        this.optimizationLevel = 0;
        this.generatingSource = true;
        this.strictMode = false;
        this.warningAsError = false;
        this.generateObserverCount = false;
        this.allowSharpComments = false;
    }
    
    public void initFromContext(final Context cx) {
        this.setErrorReporter(cx.getErrorReporter());
        this.languageVersion = cx.getLanguageVersion();
        this.generateDebugInfo = (!cx.isGeneratingDebugChanged() || cx.isGeneratingDebug());
        this.reservedKeywordAsIdentifier = cx.hasFeature(2);
        this.strictMode = cx.hasFeature(10);
        this.warningAsError = cx.hasFeature(11);
        this.optimizationLevel = cx.getOptimizationLevel();
        this.generatingSource = cx.isGeneratingSource();
        this.activationNames = cx.activationNames;
        this.generateObserverCount = cx.generateObserverCount;
    }
    
    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }
    
    public void setErrorReporter(final ErrorReporter errorReporter) {
        if (errorReporter == null) {
            throw new IllegalArgumentException();
        }
        this.errorReporter = errorReporter;
    }
    
    public final int getLanguageVersion() {
        return this.languageVersion;
    }
    
    public void setLanguageVersion(final int languageVersion) {
        Context.checkLanguageVersion(languageVersion);
        this.languageVersion = languageVersion;
    }
    
    public final boolean isGenerateDebugInfo() {
        return this.generateDebugInfo;
    }
    
    public void setGenerateDebugInfo(final boolean flag) {
        this.generateDebugInfo = flag;
    }
    
    public final boolean isReservedKeywordAsIdentifier() {
        return this.reservedKeywordAsIdentifier;
    }
    
    public void setReservedKeywordAsIdentifier(final boolean flag) {
        this.reservedKeywordAsIdentifier = flag;
    }
    
    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }
    
    public void setOptimizationLevel(final int level) {
        Context.checkOptimizationLevel(level);
        this.optimizationLevel = level;
    }
    
    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }
    
    public boolean getWarnTrailingComma() {
        return this.warnTrailingComma;
    }
    
    public void setWarnTrailingComma(final boolean warn) {
        this.warnTrailingComma = warn;
    }
    
    public final boolean isStrictMode() {
        return this.strictMode;
    }
    
    public void setStrictMode(final boolean strict) {
        this.strictMode = strict;
    }
    
    public final boolean reportWarningAsError() {
        return this.warningAsError;
    }
    
    public void setGeneratingSource(final boolean generatingSource) {
        this.generatingSource = generatingSource;
    }
    
    public boolean isGenerateObserverCount() {
        return this.generateObserverCount;
    }
    
    public void setGenerateObserverCount(final boolean generateObserverCount) {
        this.generateObserverCount = generateObserverCount;
    }
    
    public boolean isRecordingComments() {
        return this.recordingComments;
    }
    
    public void setRecordingComments(final boolean record) {
        this.recordingComments = record;
    }
    
    public boolean isRecordingLocalJsDocComments() {
        return this.recordingLocalJsDocComments;
    }
    
    public void setRecordingLocalJsDocComments(final boolean record) {
        this.recordingLocalJsDocComments = record;
    }
    
    public void setRecoverFromErrors(final boolean recover) {
        this.recoverFromErrors = recover;
    }
    
    public boolean recoverFromErrors() {
        return this.recoverFromErrors;
    }
    
    public void setIdeMode(final boolean ide) {
        this.ideMode = ide;
    }
    
    public boolean isIdeMode() {
        return this.ideMode;
    }
    
    public Set<String> getActivationNames() {
        return this.activationNames;
    }
    
    public void setActivationNames(final Set<String> activationNames) {
        this.activationNames = activationNames;
    }
    
    public void setAllowSharpComments(final boolean allow) {
        this.allowSharpComments = allow;
    }
    
    public boolean getAllowSharpComments() {
        return this.allowSharpComments;
    }
    
    public void setXmlAvailable(final boolean available) {
    }
    
    public static CompilerEnvirons ideEnvirons() {
        final CompilerEnvirons env = new CompilerEnvirons();
        env.setRecoverFromErrors(true);
        env.setRecordingComments(true);
        env.setStrictMode(true);
        env.setWarnTrailingComma(true);
        env.setLanguageVersion(170);
        env.setReservedKeywordAsIdentifier(true);
        env.setIdeMode(true);
        env.setErrorReporter((ErrorReporter)new ErrorCollector());
        return env;
    }
}
