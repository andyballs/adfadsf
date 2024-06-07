//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils.console;

import kotlin.*;
import com.chattriggers.ctjs.engine.*;
import org.jetbrains.annotations.*;
import org.fife.ui.rsyntaxtextarea.*;
import javax.swing.*;
import java.awt.*;
import kotlin.jvm.*;
import java.io.*;
import com.chattriggers.ctjs.utils.*;
import java.util.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ0\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0006\u0010&\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006(" }, d2 = { "Lcom/chattriggers/ctjs/utils/console/Console;", "", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Lcom/chattriggers/ctjs/engine/ILoader;)V", "components", "", "Ljava/awt/Component;", "frame", "Ljavax/swing/JFrame;", "history", "", "", "historyOffset", "", "inputField", "Lorg/fife/ui/rsyntaxtextarea/RSyntaxTextArea;", "getLoader", "()Lcom/chattriggers/ctjs/engine/ILoader;", "textArea", "Ljavax/swing/JTextPane;", "writer", "Lcom/chattriggers/ctjs/utils/console/TextAreaWriter;", "getWriter", "()Lcom/chattriggers/ctjs/utils/console/TextAreaWriter;", "clearConsole", "", "printErrorWithColor", "error", "", "printStackTrace", "println", "obj", "logType", "Lcom/chattriggers/ctjs/utils/console/LogType;", "end", "customColor", "Ljava/awt/Color;", "showConsole", "Companion", "ctjs" })
public final class Console
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final ILoader loader;
    @NotNull
    private final JFrame frame;
    @NotNull
    private final JTextPane textArea;
    @NotNull
    private final RSyntaxTextArea inputField;
    @NotNull
    private final Set<Component> components;
    @NotNull
    private final List<String> history;
    private int historyOffset;
    @NotNull
    private final TextAreaWriter writer;
    @NotNull
    private static final Font FIRA_FONT;
    
    public Console(@Nullable final ILoader loader) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0         /* this */
        //     5: aload_1         /* loader */
        //     6: putfield        com/chattriggers/ctjs/utils/console/Console.loader:Lcom/chattriggers/ctjs/engine/ILoader;
        //     9: aload_0         /* this */
        //    10: new             Ljavax/swing/JFrame;
        //    13: dup            
        //    14: new             Ljava/lang/StringBuilder;
        //    17: dup            
        //    18: invokespecial   java/lang/StringBuilder.<init>:()V
        //    21: ldc             "ChatTriggers 2.2.0 "
        //    23: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    26: aload_0         /* this */
        //    27: getfield        com/chattriggers/ctjs/utils/console/Console.loader:Lcom/chattriggers/ctjs/engine/ILoader;
        //    30: dup            
        //    31: ifnonnull       40
        //    34: pop            
        //    35: ldc             "Default"
        //    37: goto            65
        //    40: invokeinterface com/chattriggers/ctjs/engine/ILoader.getLanguage:()Lcom/chattriggers/ctjs/engine/langs/Lang;
        //    45: dup            
        //    46: ifnonnull       55
        //    49: pop            
        //    50: ldc             "Default"
        //    52: goto            65
        //    55: invokevirtual   com/chattriggers/ctjs/engine/langs/Lang.getLangName:()Ljava/lang/String;
        //    58: dup            
        //    59: ifnonnull       65
        //    62: pop            
        //    63: ldc             "Default"
        //    65: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    68: ldc             " Console"
        //    70: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    73: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    76: invokespecial   javax/swing/JFrame.<init>:(Ljava/lang/String;)V
        //    79: putfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //    82: aload_0         /* this */
        //    83: new             Ljavax/swing/JTextPane;
        //    86: dup            
        //    87: invokespecial   javax/swing/JTextPane.<init>:()V
        //    90: putfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //    93: aload_0         /* this */
        //    94: new             Lorg/fife/ui/rsyntaxtextarea/RSyntaxTextArea;
        //    97: dup            
        //    98: iconst_5       
        //    99: iconst_1       
        //   100: invokespecial   org/fife/ui/rsyntaxtextarea/RSyntaxTextArea.<init>:(II)V
        //   103: astore_2       
        //   104: aload_2        
        //   105: astore_3       
        //   106: astore          5
        //   108: iconst_0       
        //   109: istore          $i$a$-apply-Console$inputField$1
        //   111: aload_3         /* $this$inputField_u24lambda_u2d0 */
        //   112: aload_0         /* this */
        //   113: invokevirtual   com/chattriggers/ctjs/utils/console/Console.getLoader:()Lcom/chattriggers/ctjs/engine/ILoader;
        //   116: dup            
        //   117: ifnonnull       126
        //   120: pop            
        //   121: ldc             "text/plain"
        //   123: goto            151
        //   126: invokeinterface com/chattriggers/ctjs/engine/ILoader.getLanguage:()Lcom/chattriggers/ctjs/engine/langs/Lang;
        //   131: dup            
        //   132: ifnonnull       141
        //   135: pop            
        //   136: ldc             "text/plain"
        //   138: goto            151
        //   141: invokevirtual   com/chattriggers/ctjs/engine/langs/Lang.getSyntaxStyle:()Ljava/lang/String;
        //   144: dup            
        //   145: ifnonnull       151
        //   148: pop            
        //   149: ldc             "text/plain"
        //   151: invokevirtual   org/fife/ui/rsyntaxtextarea/RSyntaxTextArea.setSyntaxEditingStyle:(Ljava/lang/String;)V
        //   154: aload_3         /* $this$inputField_u24lambda_u2d0 */
        //   155: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   158: ldc             "/org/fife/ui/rsyntaxtextarea/themes/dark.xml"
        //   160: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   163: invokestatic    org/fife/ui/rsyntaxtextarea/Theme.load:(Ljava/io/InputStream;)Lorg/fife/ui/rsyntaxtextarea/Theme;
        //   166: aload_3         /* $this$inputField_u24lambda_u2d0 */
        //   167: invokevirtual   org/fife/ui/rsyntaxtextarea/Theme.apply:(Lorg/fife/ui/rsyntaxtextarea/RSyntaxTextArea;)V
        //   170: aload_3         /* $this$inputField_u24lambda_u2d0 */
        //   171: new             Ljava/awt/Insets;
        //   174: dup            
        //   175: iconst_5       
        //   176: iconst_5       
        //   177: iconst_5       
        //   178: iconst_5       
        //   179: invokespecial   java/awt/Insets.<init>:(IIII)V
        //   182: invokevirtual   org/fife/ui/rsyntaxtextarea/RSyntaxTextArea.setMargin:(Ljava/awt/Insets;)V
        //   185: aload_3         /* $this$inputField_u24lambda_u2d0 */
        //   186: iconst_1       
        //   187: invokevirtual   org/fife/ui/rsyntaxtextarea/RSyntaxTextArea.setCodeFoldingEnabled:(Z)V
        //   190: nop            
        //   191: aload           5
        //   193: aload_2        
        //   194: putfield        com/chattriggers/ctjs/utils/console/Console.inputField:Lorg/fife/ui/rsyntaxtextarea/RSyntaxTextArea;
        //   197: aload_0         /* this */
        //   198: iconst_1       
        //   199: anewarray       Ljava/awt/Component;
        //   202: astore_2       
        //   203: aload_2        
        //   204: iconst_0       
        //   205: aload_0         /* this */
        //   206: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   209: checkcast       Ljava/awt/Component;
        //   212: aastore        
        //   213: aload_2        
        //   214: invokestatic    kotlin/collections/SetsKt.mutableSetOf:([Ljava/lang/Object;)Ljava/util/Set;
        //   217: putfield        com/chattriggers/ctjs/utils/console/Console.components:Ljava/util/Set;
        //   220: aload_0         /* this */
        //   221: new             Ljava/util/ArrayList;
        //   224: dup            
        //   225: invokespecial   java/util/ArrayList.<init>:()V
        //   228: checkcast       Ljava/util/List;
        //   231: putfield        com/chattriggers/ctjs/utils/console/Console.history:Ljava/util/List;
        //   234: aload_0         /* this */
        //   235: new             Lcom/chattriggers/ctjs/utils/console/TextAreaWriter;
        //   238: dup            
        //   239: aload_0         /* this */
        //   240: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   243: invokespecial   com/chattriggers/ctjs/utils/console/TextAreaWriter.<init>:(Ljavax/swing/JTextPane;)V
        //   246: putfield        com/chattriggers/ctjs/utils/console/Console.writer:Lcom/chattriggers/ctjs/utils/console/TextAreaWriter;
        //   249: nop            
        //   250: aload_0         /* this */
        //   251: getfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //   254: iconst_1       
        //   255: invokevirtual   javax/swing/JFrame.setDefaultCloseOperation:(I)V
        //   258: aload_0         /* this */
        //   259: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   262: iconst_0       
        //   263: invokevirtual   javax/swing/JTextPane.setEditable:(Z)V
        //   266: aload_0         /* this */
        //   267: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   270: new             Ljava/awt/Insets;
        //   273: dup            
        //   274: iconst_5       
        //   275: iconst_5       
        //   276: iconst_5       
        //   277: iconst_5       
        //   278: invokespecial   java/awt/Insets.<init>:(IIII)V
        //   281: invokevirtual   javax/swing/JTextPane.setMargin:(Ljava/awt/Insets;)V
        //   284: aload_0         /* this */
        //   285: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   288: iconst_1       
        //   289: invokevirtual   javax/swing/JTextPane.setAutoscrolls:(Z)V
        //   292: aload_0         /* this */
        //   293: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   296: invokevirtual   javax/swing/JTextPane.getCaret:()Ljavax/swing/text/Caret;
        //   299: dup            
        //   300: ifnonnull       314
        //   303: pop            
        //   304: new             Ljava/lang/NullPointerException;
        //   307: dup            
        //   308: ldc             "null cannot be cast to non-null type javax.swing.text.DefaultCaret"
        //   310: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   313: athrow         
        //   314: checkcast       Ljavax/swing/text/DefaultCaret;
        //   317: astore_2        /* caret */
        //   318: aload_2         /* caret */
        //   319: iconst_2       
        //   320: invokevirtual   javax/swing/text/DefaultCaret.setUpdatePolicy:(I)V
        //   323: aload_0         /* this */
        //   324: getfield        com/chattriggers/ctjs/utils/console/Console.inputField:Lorg/fife/ui/rsyntaxtextarea/RSyntaxTextArea;
        //   327: new             Lcom/chattriggers/ctjs/utils/console/Console$1;
        //   330: dup            
        //   331: aload_0         /* this */
        //   332: invokespecial   com/chattriggers/ctjs/utils/console/Console$1.<init>:(Lcom/chattriggers/ctjs/utils/console/Console;)V
        //   335: checkcast       Ljava/awt/event/KeyListener;
        //   338: invokevirtual   org/fife/ui/rsyntaxtextarea/RSyntaxTextArea.addKeyListener:(Ljava/awt/event/KeyListener;)V
        //   341: aload_0         /* this */
        //   342: getfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //   345: new             Ljavax/swing/JScrollPane;
        //   348: dup            
        //   349: aload_0         /* this */
        //   350: getfield        com/chattriggers/ctjs/utils/console/Console.textArea:Ljavax/swing/JTextPane;
        //   353: checkcast       Ljava/awt/Component;
        //   356: invokespecial   javax/swing/JScrollPane.<init>:(Ljava/awt/Component;)V
        //   359: checkcast       Ljava/awt/Component;
        //   362: invokevirtual   javax/swing/JFrame.add:(Ljava/awt/Component;)Ljava/awt/Component;
        //   365: pop            
        //   366: aload_0         /* this */
        //   367: getfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //   370: aload_0         /* this */
        //   371: getfield        com/chattriggers/ctjs/utils/console/Console.inputField:Lorg/fife/ui/rsyntaxtextarea/RSyntaxTextArea;
        //   374: checkcast       Ljava/awt/Component;
        //   377: ldc             "South"
        //   379: invokevirtual   javax/swing/JFrame.add:(Ljava/awt/Component;Ljava/lang/Object;)V
        //   382: aload_0         /* this */
        //   383: getfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //   386: invokevirtual   javax/swing/JFrame.pack:()V
        //   389: aload_0         /* this */
        //   390: getfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //   393: iconst_0       
        //   394: invokevirtual   javax/swing/JFrame.setVisible:(Z)V
        //   397: aload_0         /* this */
        //   398: getfield        com/chattriggers/ctjs/utils/console/Console.frame:Ljavax/swing/JFrame;
        //   401: sipush          800
        //   404: sipush          600
        //   407: invokevirtual   javax/swing/JFrame.setSize:(II)V
        //   410: nop            
        //   411: return         
        //    StackMapTable: 00 07 FF 00 28 00 02 07 00 02 07 00 56 00 05 07 00 02 08 00 0A 08 00 0A 07 00 4B 07 00 56 FF 00 0E 00 02 07 00 02 07 00 56 00 05 07 00 02 08 00 0A 08 00 0A 07 00 4B 07 00 5C FF 00 09 00 02 07 00 02 07 00 56 00 05 07 00 02 08 00 0A 08 00 0A 07 00 4B 07 00 62 FF 00 3C 00 06 07 00 02 07 00 56 07 00 73 07 00 73 01 07 00 02 00 02 07 00 73 07 00 56 FF 00 0E 00 06 07 00 02 07 00 56 07 00 73 07 00 73 01 07 00 02 00 02 07 00 73 07 00 5C FF 00 09 00 06 07 00 02 07 00 56 07 00 73 07 00 73 01 07 00 02 00 02 07 00 73 07 00 62 FF 00 A2 00 06 07 00 02 07 00 56 07 00 D3 07 00 73 01 07 00 02 00 01 07 00 D5
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public final ILoader getLoader() {
        return this.loader;
    }
    
    @NotNull
    public final TextAreaWriter getWriter() {
        return this.writer;
    }
    
    public final void clearConsole() {
        SwingUtilities.invokeLater(Console::clearConsole$lambda-1);
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object obj, @NotNull final LogType logType, @NotNull final String end, @Nullable final Color customColor) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        Intrinsics.checkNotNullParameter((Object)end, "end");
        SwingUtilities.invokeLater(Console::println$lambda-2);
    }
    
    public static /* synthetic */ void println$default(final Console console, final Object obj, LogType info, String end, Color customColor, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            info = LogType.INFO;
        }
        if ((n & 0x4) != 0x0) {
            end = "\n";
        }
        if ((n & 0x8) != 0x0) {
            customColor = null;
        }
        console.println(obj, info, end, customColor);
    }
    
    public final void printStackTrace(@NotNull final Throwable error) {
        Intrinsics.checkNotNullParameter((Object)error, "error");
        SwingUtilities.invokeLater(Console::printStackTrace$lambda-5);
    }
    
    private final void printErrorWithColor(final Throwable error) {
        final StringWriter sw = new StringWriter();
        error.printStackTrace(new PrintWriter(sw));
        final String string = sw.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "sw.toString()");
        final String stacktrace = string;
        TextAreaWriter.println$default(this.writer, stacktrace, LogType.ERROR, null, null, 12, null);
    }
    
    public final void showConsole() {
        this.frame.setVisible(true);
        Color bg = null;
        Color fg = null;
        Label_0857: {
            if (Config.INSTANCE.getCustomTheme()) {
                bg = Config.INSTANCE.getConsoleBackgroundColor();
                fg = Config.INSTANCE.getConsoleForegroundColor();
            }
            else {
                final String consoleTheme = Config.INSTANCE.getConsoleTheme();
                switch (consoleTheme) {
                    case "green": {
                        bg = new Color(6, 10, 10);
                        fg = new Color(47, 227, 149);
                        break Label_0857;
                    }
                    case "default.dark": {
                        bg = new Color(41, 49, 52);
                        fg = new Color(208, 208, 208);
                        break Label_0857;
                    }
                    case "isotope.dark": {
                        bg = new Color(0, 0, 0);
                        fg = new Color(208, 208, 208);
                        break Label_0857;
                    }
                    case "3024.light": {
                        bg = new Color(247, 247, 247);
                        fg = new Color(74, 69, 67);
                        break Label_0857;
                    }
                    case "red": {
                        bg = new Color(26, 9, 11);
                        fg = new Color(231, 210, 212);
                        break Label_0857;
                    }
                    case "codeschool.dark": {
                        bg = new Color(22, 27, 29);
                        fg = new Color(126, 162, 180);
                        break Label_0857;
                    }
                    case "hybrid": {
                        bg = new Color(29, 31, 33);
                        fg = new Color(197, 200, 198);
                        break Label_0857;
                    }
                    case "chalk.light": {
                        bg = new Color(245, 245, 245);
                        fg = new Color(48, 48, 48);
                        break Label_0857;
                    }
                    case "blue": {
                        bg = new Color(15, 18, 32);
                        fg = new Color(221, 223, 235);
                        break Label_0857;
                    }
                    case "ashes.dark": {
                        bg = new Color(28, 32, 35);
                        fg = new Color(199, 204, 209);
                        break Label_0857;
                    }
                    case "atelierforest.dark": {
                        bg = new Color(28, 32, 35);
                        fg = new Color(199, 204, 209);
                        break Label_0857;
                    }
                    case "aids": {
                        bg = new Color(251, 251, 28);
                        fg = new Color(192, 20, 214);
                        break Label_0857;
                    }
                    case "gotham": {
                        bg = new Color(10, 15, 20);
                        fg = new Color(152, 209, 206);
                        break Label_0857;
                    }
                    case "slate": {
                        bg = new Color(33, 36, 41);
                        fg = new Color(193, 199, 208);
                        break Label_0857;
                    }
                    default:
                        break;
                }
                bg = new Color(21, 21, 21);
                fg = new Color(208, 208, 208);
            }
        }
        for (final Component comp : this.components) {
            comp.setBackground(bg);
            comp.setForeground(fg);
        }
        this.frame.toFront();
        this.frame.repaint();
        final Font chosenFont = Config.INSTANCE.getConsoleFiraCodeFont() ? Console.FIRA_FONT.deriveFont((float)Config.INSTANCE.getConsoleFontSize()) : new Font("DejaVu Sans Mono", 0, 15).deriveFont((float)Config.INSTANCE.getConsoleFontSize());
        this.textArea.setFont(chosenFont);
        this.inputField.setFont(chosenFont);
        this.frame.toFront();
        this.frame.repaint();
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object obj, @NotNull final LogType logType, @NotNull final String end) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        Intrinsics.checkNotNullParameter((Object)end, "end");
        println$default(this, obj, logType, end, null, 8, null);
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object obj, @NotNull final LogType logType) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        println$default(this, obj, logType, null, null, 12, null);
    }
    
    @JvmOverloads
    public final void println(@NotNull final Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        println$default(this, obj, null, null, null, 14, null);
    }
    
    private static final void clearConsole$lambda-1(final Console this$0) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        this$0.writer.clear();
    }
    
    private static final void println$lambda-2(final Console this$0, final Object $obj, final LogType $logType, final String $end, final Color $customColor) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        Intrinsics.checkNotNullParameter($obj, "$obj");
        Intrinsics.checkNotNullParameter((Object)$logType, "$logType");
        Intrinsics.checkNotNullParameter((Object)$end, "$end");
        try {
            this$0.writer.println($obj.toString(), $logType, $end, $customColor);
        }
        catch (Exception exception) {
            this$0.println($obj.toString(), $logType, $end, $customColor);
        }
    }
    
    private static final void printStackTrace$lambda-5(final Console this$0, final Throwable $error) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "this$0"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_1         /* $error */
        //     8: ldc_w           "$error"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: nop            
        //    15: getstatic       com/chattriggers/ctjs/utils/Config.INSTANCE:Lcom/chattriggers/ctjs/utils/Config;
        //    18: invokevirtual   com/chattriggers/ctjs/utils/Config.getOpenConsoleOnError:()Z
        //    21: ifeq            28
        //    24: aload_0         /* this$0 */
        //    25: invokevirtual   com/chattriggers/ctjs/utils/console/Console.showConsole:()V
        //    28: aload_1         /* $error */
        //    29: invokevirtual   java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
        //    32: astore_3       
        //    33: aload_3        
        //    34: ldc_w           "error.stackTrace"
        //    37: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    40: aload_3        
        //    41: checkcast       [Ljava/lang/Object;
        //    44: astore_3        /* $this$indexOfFirst$iv */
        //    45: iconst_0       
        //    46: istore          $i$f$indexOfFirst
        //    48: iconst_0       
        //    49: istore          index$iv
        //    51: aload_3         /* $this$indexOfFirst$iv */
        //    52: arraylength    
        //    53: istore          6
        //    55: iload           index$iv
        //    57: iload           6
        //    59: if_icmpge       156
        //    62: aload_3         /* $this$indexOfFirst$iv */
        //    63: iload           index$iv
        //    65: aaload         
        //    66: checkcast       Ljava/lang/StackTraceElement;
        //    69: astore          it
        //    71: iconst_0       
        //    72: istore          $i$a$-indexOfFirst-Console$printStackTrace$1$index$1
        //    74: aload           it
        //    76: dup            
        //    77: ifnonnull       85
        //    80: pop            
        //    81: iconst_0       
        //    82: goto            142
        //    85: invokevirtual   java/lang/StackTraceElement.getFileName:()Ljava/lang/String;
        //    88: astore          10
        //    90: aload           10
        //    92: ifnonnull       99
        //    95: iconst_0       
        //    96: goto            142
        //    99: aload           10
        //   101: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //   104: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   107: dup            
        //   108: ldc_w           "this as java.lang.String).toLowerCase(Locale.ROOT)"
        //   111: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   114: dup            
        //   115: ifnonnull       123
        //   118: pop            
        //   119: iconst_0       
        //   120: goto            142
        //   123: checkcast       Ljava/lang/CharSequence;
        //   126: ldc_w           "jsloader"
        //   129: checkcast       Ljava/lang/CharSequence;
        //   132: iconst_0       
        //   133: iconst_2       
        //   134: aconst_null    
        //   135: invokestatic    kotlin/text/StringsKt.contains$default:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
        //   138: istore          12
        //   140: iload           12
        //   142: ifeq            150
        //   145: iload           index$iv
        //   147: goto            157
        //   150: iinc            index$iv, 1
        //   153: goto            55
        //   156: iconst_m1      
        //   157: istore_2        /* index */
        //   158: aload_1         /* $error */
        //   159: aload_1         /* $error */
        //   160: invokevirtual   java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
        //   163: astore_3       
        //   164: aload_3        
        //   165: ldc_w           "error.stackTrace"
        //   168: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   171: aload_3        
        //   172: checkcast       [Ljava/lang/Object;
        //   175: aload_1         /* $error */
        //   176: invokevirtual   java/lang/Throwable.getStackTrace:()[Ljava/lang/StackTraceElement;
        //   179: arraylength    
        //   180: iload_2         /* index */
        //   181: isub           
        //   182: iconst_1       
        //   183: isub           
        //   184: invokestatic    kotlin/collections/ArraysKt.dropLast:([Ljava/lang/Object;I)Ljava/util/List;
        //   187: checkcast       Ljava/lang/Iterable;
        //   190: astore_3       
        //   191: astore          15
        //   193: iconst_0       
        //   194: istore          $i$f$map
        //   196: aload_3         /* $this$map$iv */
        //   197: astore          5
        //   199: new             Ljava/util/ArrayList;
        //   202: dup            
        //   203: aload_3         /* $this$map$iv */
        //   204: bipush          10
        //   206: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   209: invokespecial   java/util/ArrayList.<init>:(I)V
        //   212: checkcast       Ljava/util/Collection;
        //   215: astore          destination$iv$iv
        //   217: iconst_0       
        //   218: istore          $i$f$mapTo
        //   220: aload           $this$mapTo$iv$iv
        //   222: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   227: astore          8
        //   229: aload           8
        //   231: invokeinterface java/util/Iterator.hasNext:()Z
        //   236: ifeq            438
        //   239: aload           8
        //   241: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   246: astore          item$iv$iv
        //   248: aload           destination$iv$iv
        //   250: aload           item$iv$iv
        //   252: checkcast       Ljava/lang/StackTraceElement;
        //   255: astore          10
        //   257: astore          16
        //   259: iconst_0       
        //   260: istore          $i$a$-map-Console$printStackTrace$1$1
        //   262: aload           it
        //   264: invokevirtual   java/lang/StackTraceElement.getFileName:()Ljava/lang/String;
        //   267: dup            
        //   268: ifnonnull       276
        //   271: pop            
        //   272: aconst_null    
        //   273: goto            293
        //   276: checkcast       Ljava/lang/CharSequence;
        //   279: ldc_w           "ChatTriggers/modules/"
        //   282: iconst_0       
        //   283: iconst_0       
        //   284: bipush          6
        //   286: aconst_null    
        //   287: invokestatic    kotlin/text/StringsKt.indexOf$default:(Ljava/lang/CharSequence;Ljava/lang/String;IZILjava/lang/Object;)I
        //   290: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   293: dup            
        //   294: ifnonnull       303
        //   297: pop            
        //   298: aload           it
        //   300: goto            426
        //   303: invokevirtual   java/lang/Integer.intValue:()I
        //   306: istore          fileNameIndex
        //   308: aload           it
        //   310: invokevirtual   java/lang/StackTraceElement.getClassName:()Ljava/lang/String;
        //   313: astore          12
        //   315: aload           12
        //   317: ldc_w           "it.className"
        //   320: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   323: aload           12
        //   325: checkcast       Ljava/lang/CharSequence;
        //   328: ldc_w           "ChatTriggers_modules_"
        //   331: iconst_0       
        //   332: iconst_0       
        //   333: bipush          6
        //   335: aconst_null    
        //   336: invokestatic    kotlin/text/StringsKt.indexOf$default:(Ljava/lang/CharSequence;Ljava/lang/String;IZILjava/lang/Object;)I
        //   339: istore          classNameIndex
        //   341: iload           fileNameIndex
        //   343: iconst_m1      
        //   344: if_icmpeq       423
        //   347: new             Ljava/lang/StackTraceElement;
        //   350: dup            
        //   351: aload           it
        //   353: invokevirtual   java/lang/StackTraceElement.getClassName:()Ljava/lang/String;
        //   356: astore          12
        //   358: aload           12
        //   360: ldc_w           "it.className"
        //   363: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   366: aload           12
        //   368: iload           classNameIndex
        //   370: bipush          21
        //   372: iadd           
        //   373: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   376: dup            
        //   377: ldc_w           "this as java.lang.String).substring(startIndex)"
        //   380: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   383: aload           it
        //   385: invokevirtual   java/lang/StackTraceElement.getMethodName:()Ljava/lang/String;
        //   388: aload           it
        //   390: invokevirtual   java/lang/StackTraceElement.getFileName:()Ljava/lang/String;
        //   393: dup            
        //   394: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //   397: iload           fileNameIndex
        //   399: bipush          21
        //   401: iadd           
        //   402: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   405: dup            
        //   406: ldc_w           "this as java.lang.String).substring(startIndex)"
        //   409: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   412: aload           it
        //   414: invokevirtual   java/lang/StackTraceElement.getLineNumber:()I
        //   417: invokespecial   java/lang/StackTraceElement.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
        //   420: goto            425
        //   423: aload           it
        //   425: nop            
        //   426: aload           16
        //   428: swap           
        //   429: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   434: pop            
        //   435: goto            229
        //   438: aload           destination$iv$iv
        //   440: checkcast       Ljava/util/List;
        //   443: nop            
        //   444: aload           15
        //   446: swap           
        //   447: checkcast       Ljava/util/Collection;
        //   450: astore_3       
        //   451: nop            
        //   452: iconst_0       
        //   453: istore          $i$f$toTypedArray
        //   455: aload_3         /* $this$toTypedArray$iv */
        //   456: astore          thisCollection$iv
        //   458: aload           thisCollection$iv
        //   460: iconst_0       
        //   461: anewarray       Ljava/lang/StackTraceElement;
        //   464: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   469: dup            
        //   470: ldc_w           "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
        //   473: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   476: checkcast       [Ljava/lang/StackTraceElement;
        //   479: invokevirtual   java/lang/Throwable.setStackTrace:([Ljava/lang/StackTraceElement;)V
        //   482: aload_0         /* this$0 */
        //   483: aload_1         /* $error */
        //   484: invokespecial   com/chattriggers/ctjs/utils/console/Console.printErrorWithColor:(Ljava/lang/Throwable;)V
        //   487: goto            495
        //   490: astore_2        /* ignored */
        //   491: aload_1         /* $error */
        //   492: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   495: return         
        //    StackMapTable: 00 13 1C FF 00 1A 00 07 07 00 02 07 01 4C 00 07 01 F9 01 01 01 00 00 FF 00 1D 00 09 07 00 02 07 01 4C 00 07 01 F9 01 01 01 07 01 FB 01 00 01 07 01 FB FD 00 0D 00 07 00 62 57 07 00 62 FF 00 12 00 09 07 00 02 07 01 4C 00 07 01 F9 01 01 01 07 01 FB 01 00 01 01 07 F9 00 05 40 01 FF 00 47 00 10 07 00 02 07 01 4C 01 07 02 1C 01 07 02 1C 07 02 26 01 07 01 A3 00 00 00 00 00 00 07 01 4C 00 00 FF 00 2E 00 11 07 00 02 07 01 4C 01 07 02 1C 01 07 02 1C 07 02 26 01 07 01 A3 07 00 04 07 01 FB 01 00 00 00 07 01 4C 07 02 26 00 01 07 00 62 50 07 02 2F 49 07 02 2F FF 00 77 00 11 07 00 02 07 01 4C 01 07 02 1C 01 07 02 1C 07 02 26 01 07 01 A3 07 00 04 07 01 FB 01 07 00 62 01 01 07 01 4C 07 02 26 00 00 41 07 01 FB FF 00 00 00 11 07 00 02 07 01 4C 01 07 02 1C 01 07 02 1C 07 02 26 01 07 01 A3 07 00 04 07 01 FB 01 00 00 00 07 01 4C 07 02 26 00 01 07 01 FB FF 00 0B 00 10 07 00 02 07 01 4C 01 07 02 1C 01 07 02 1C 07 02 26 01 07 01 A3 00 00 00 00 00 00 07 01 4C 00 00 FF 00 33 00 02 07 00 02 07 01 4C 00 01 07 01 4C 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     487    490    495    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final /* synthetic */ Font access$getFIRA_FONT$cp() {
        return Console.FIRA_FONT;
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aconst_null    
        //     5: invokespecial   com/chattriggers/ctjs/utils/console/Console$Companion.<init>:(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        //     8: putstatic       com/chattriggers/ctjs/utils/console/Console.Companion:Lcom/chattriggers/ctjs/utils/console/Console$Companion;
        //    11: iconst_0       
        //    12: ldc_w           "ct.firaFile"
        //    15: aconst_null    
        //    16: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    19: dup            
        //    20: ifnonnull       28
        //    23: pop            
        //    24: aconst_null    
        //    25: goto            56
        //    28: astore_2       
        //    29: istore          4
        //    31: iconst_0       
        //    32: istore_3       
        //    33: new             Ljava/io/FileInputStream;
        //    36: dup            
        //    37: new             Ljava/io/File;
        //    40: dup            
        //    41: aload_2        
        //    42: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    45: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    48: nop            
        //    49: astore          5
        //    51: iload           4
        //    53: aload           5
        //    55: nop            
        //    56: astore_1       
        //    57: aload_1        
        //    58: ifnonnull       76
        //    61: getstatic       com/chattriggers/ctjs/utils/console/Console.Companion:Lcom/chattriggers/ctjs/utils/console/Console$Companion;
        //    64: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    67: ldc_w           "/FiraCode-Regular.otf"
        //    70: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    73: goto            80
        //    76: aload_1        
        //    77: checkcast       Ljava/io/InputStream;
        //    80: invokestatic    java/awt/Font.createFont:(ILjava/io/InputStream;)Ljava/awt/Font;
        //    83: ldc_w           9.0
        //    86: invokevirtual   java/awt/Font.deriveFont:(F)Ljava/awt/Font;
        //    89: astore_0       
        //    90: aload_0        
        //    91: ldc_w           "createFont(\n            \u2026\n        ).deriveFont(9f)"
        //    94: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    97: aload_0        
        //    98: putstatic       com/chattriggers/ctjs/utils/console/Console.FIRA_FONT:Ljava/awt/Font;
        //   101: nop            
        //   102: invokestatic    java/awt/GraphicsEnvironment.getLocalGraphicsEnvironment:()Ljava/awt/GraphicsEnvironment;
        //   105: getstatic       com/chattriggers/ctjs/utils/console/Console.FIRA_FONT:Ljava/awt/Font;
        //   108: invokevirtual   java/awt/GraphicsEnvironment.registerFont:(Ljava/awt/Font;)Z
        //   111: pop            
        //   112: return         
        //    StackMapTable: 00 04 FF 00 1C 00 00 00 02 01 07 00 62 FF 00 1B 00 00 00 02 01 07 02 97 FF 00 13 00 02 00 07 02 97 00 01 01 FF 00 03 00 02 00 07 02 97 00 02 01 07 02 A1
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/utils/console/Console$Companion;", "", "()V", "FIRA_FONT", "Ljava/awt/Font;", "getFIRA_FONT", "()Ljava/awt/Font;", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final Font getFIRA_FONT() {
            return Console.access$getFIRA_FONT$cp();
        }
    }
}
