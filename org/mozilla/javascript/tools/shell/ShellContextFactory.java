//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.*;

public class ShellContextFactory extends ContextFactory
{
    private boolean strictMode;
    private boolean warningAsError;
    private int languageVersion;
    private int optimizationLevel;
    private boolean generatingDebug;
    private boolean allowReservedKeywords;
    private ErrorReporter errorReporter;
    private String characterEncoding;
    
    public ShellContextFactory() {
        this.languageVersion = 180;
        this.allowReservedKeywords = true;
    }
    
    protected boolean hasFeature(final Context cx, final int featureIndex) {
        switch (featureIndex) {
            case 7:
            case 8:
            case 10: {
                return this.strictMode;
            }
            case 2: {
                return this.allowReservedKeywords;
            }
            case 11: {
                return this.warningAsError;
            }
            case 9: {
                return this.generatingDebug;
            }
            default: {
                return super.hasFeature(cx, featureIndex);
            }
        }
    }
    
    protected void onContextCreated(final Context cx) {
        cx.setLanguageVersion(this.languageVersion);
        cx.setOptimizationLevel(this.optimizationLevel);
        if (this.errorReporter != null) {
            cx.setErrorReporter(this.errorReporter);
        }
        cx.setGeneratingDebug(this.generatingDebug);
        super.onContextCreated(cx);
    }
    
    public void setStrictMode(final boolean flag) {
        this.checkNotSealed();
        this.strictMode = flag;
    }
    
    public void setWarningAsError(final boolean flag) {
        this.checkNotSealed();
        this.warningAsError = flag;
    }
    
    public void setLanguageVersion(final int version) {
        Context.checkLanguageVersion(version);
        this.checkNotSealed();
        this.languageVersion = version;
    }
    
    public void setOptimizationLevel(final int optimizationLevel) {
        Context.checkOptimizationLevel(optimizationLevel);
        this.checkNotSealed();
        this.optimizationLevel = optimizationLevel;
    }
    
    public void setErrorReporter(final ErrorReporter errorReporter) {
        if (errorReporter == null) {
            throw new IllegalArgumentException();
        }
        this.errorReporter = errorReporter;
    }
    
    public void setGeneratingDebug(final boolean generatingDebug) {
        this.generatingDebug = generatingDebug;
    }
    
    public String getCharacterEncoding() {
        return this.characterEncoding;
    }
    
    public void setCharacterEncoding(final String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }
    
    public void setAllowReservedKeywords(final boolean allowReservedKeywords) {
        this.allowReservedKeywords = allowReservedKeywords;
    }
}
