//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils.console;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.utils.*;
import kotlin.*;
import javax.swing.text.*;
import kotlin.jvm.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J0\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "Lcom/chattriggers/ctjs/utils/console/TextAreaWriter;", "Ljava/io/Writer;", "textArea", "Ljavax/swing/JTextPane;", "(Ljavax/swing/JTextPane;)V", "currentLogType", "Lcom/chattriggers/ctjs/utils/console/LogType;", "customColor", "Ljava/awt/Color;", "printWriter", "Ljava/io/PrintWriter;", "getPrintWriter", "()Ljava/io/PrintWriter;", "clear", "", "close", "flush", "println", "s", "", "logType", "end", "", "write", "cbuf", "", "off", "", "len", "ctjs" })
public final class TextAreaWriter extends Writer
{
    @NotNull
    private final JTextPane textArea;
    @NotNull
    private final PrintWriter printWriter;
    @NotNull
    private LogType currentLogType;
    @Nullable
    private Color customColor;
    
    public TextAreaWriter(@NotNull final JTextPane textArea) {
        Intrinsics.checkNotNullParameter((Object)textArea, "textArea");
        this.textArea = textArea;
        this.printWriter = new PrintWriter(this);
        this.currentLogType = LogType.INFO;
    }
    
    @NotNull
    public final PrintWriter getPrintWriter() {
        return this.printWriter;
    }
    
    @Override
    public void write(@NotNull final char[] cbuf, final int off, final int len) {
        Intrinsics.checkNotNullParameter((Object)cbuf, "cbuf");
        final String s = new String(cbuf, off, len);
        final StyleContext defaultStyleContext = StyleContext.getDefaultStyleContext();
        Intrinsics.checkNotNullExpressionValue((Object)defaultStyleContext, "getDefaultStyleContext()");
        final StyleContext sc = defaultStyleContext;
        final Color customColor = this.customColor;
        Color color2 = null;
        if (customColor == null) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.currentLogType.ordinal()]) {
                case 1: {
                    color2 = Config.INSTANCE.getConsoleForegroundColor();
                    break;
                }
                case 2: {
                    color2 = Config.INSTANCE.getConsoleWarningColor();
                    break;
                }
                case 3: {
                    color2 = Config.INSTANCE.getConsoleErrorColor();
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        else {
            color2 = customColor;
        }
        final Color color = color2;
        final AttributeSet addAttribute = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        Intrinsics.checkNotNullExpressionValue((Object)addAttribute, "sc.addAttribute(\n       \u2026         color,\n        )");
        final AttributeSet attributes = addAttribute;
        this.textArea.getDocument().insertString(this.textArea.getDocument().getLength(), s, attributes);
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
        this.currentLogType = LogType.INFO;
        this.customColor = null;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void close() {
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object s, @NotNull final LogType logType, @NotNull final String end, @Nullable final Color customColor) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        Intrinsics.checkNotNullParameter((Object)end, "end");
        if (Config.INSTANCE.getConsoleErrorAndWarningColors()) {
            this.currentLogType = logType;
            this.customColor = customColor;
        }
        this.printWriter.print(s);
        this.printWriter.print(end);
    }
    
    public static /* synthetic */ void println$default(final TextAreaWriter textAreaWriter, final Object s, LogType info, String end, Color customColor, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            info = LogType.INFO;
        }
        if ((n & 0x4) != 0x0) {
            end = "\n";
        }
        if ((n & 0x8) != 0x0) {
            customColor = null;
        }
        textAreaWriter.println(s, info, end, customColor);
    }
    
    public final void clear() {
        this.textArea.setText("");
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object s, @NotNull final LogType logType, @NotNull final String end) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        Intrinsics.checkNotNullParameter((Object)end, "end");
        println$default(this, s, logType, end, null, 8, null);
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object s, @NotNull final LogType logType) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        println$default(this, s, logType, null, null, 12, null);
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object s) {
        Intrinsics.checkNotNullParameter(s, "s");
        println$default(this, s, null, null, null, 14, null);
    }
}
