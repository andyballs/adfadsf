//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs;

import kotlin.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003�\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003�\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003�\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003�\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000b�\u0006\f" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/Lang;", "", "langName", "", "extension", "syntaxStyle", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "getLangName", "getSyntaxStyle", "JS", "ctjs" })
public enum Lang
{
    @NotNull
    private final String langName;
    @NotNull
    private final String extension;
    @NotNull
    private final String syntaxStyle;
    
    JS("js", "js", "text/javascript");
    
    private Lang(final String langName, final String extension, final String syntaxStyle) {
        this.langName = langName;
        this.extension = extension;
        this.syntaxStyle = syntaxStyle;
    }
    
    @NotNull
    public final String getLangName() {
        return this.langName;
    }
    
    @NotNull
    public final String getExtension() {
        return this.extension;
    }
    
    @NotNull
    public final String getSyntaxStyle() {
        return this.syntaxStyle;
    }
    
    private static final /* synthetic */ Lang[] $values() {
        return new Lang[] { Lang.JS };
    }
    
    static {
        $VALUES = $values();
    }
}
