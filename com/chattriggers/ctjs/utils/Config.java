//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils;

import gg.essential.vigilance.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import java.awt.*;
import com.chattriggers.ctjs.*;
import java.io.*;
import gg.essential.vigilance.data.*;
import kotlin.jvm.internal.*;
import java.lang.reflect.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b \b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\b¨\u0006E" }, d2 = { "Lcom/chattriggers/ctjs/utils/Config;", "Lgg/essential/vigilance/Vigilant;", "()V", "autoUpdateModules", "", "getAutoUpdateModules", "()Z", "setAutoUpdateModules", "(Z)V", "clearConsoleOnLoad", "getClearConsoleOnLoad", "setClearConsoleOnLoad", "consoleBackgroundColor", "Ljava/awt/Color;", "getConsoleBackgroundColor", "()Ljava/awt/Color;", "setConsoleBackgroundColor", "(Ljava/awt/Color;)V", "consoleErrorAndWarningColors", "getConsoleErrorAndWarningColors", "setConsoleErrorAndWarningColors", "consoleErrorColor", "getConsoleErrorColor", "setConsoleErrorColor", "consoleFiraCodeFont", "getConsoleFiraCodeFont", "setConsoleFiraCodeFont", "consoleFontSize", "", "getConsoleFontSize", "()I", "setConsoleFontSize", "(I)V", "consoleForegroundColor", "getConsoleForegroundColor", "setConsoleForegroundColor", "consoleTheme", "", "getConsoleTheme", "()Ljava/lang/String;", "setConsoleTheme", "(Ljava/lang/String;)V", "consoleWarningColor", "getConsoleWarningColor", "setConsoleWarningColor", "customTheme", "getCustomTheme", "setCustomTheme", "moduleChangelog", "getModuleChangelog", "setModuleChangelog", "moduleImportHelp", "getModuleImportHelp", "setModuleImportHelp", "modulesFolder", "getModulesFolder", "setModulesFolder", "openConsoleOnError", "getOpenConsoleOnError", "setOpenConsoleOnError", "printChatToConsole", "getPrintChatToConsole", "setPrintChatToConsole", "showUpdatesInChat", "getShowUpdatesInChat", "setShowUpdatesInChat", "threadedLoading", "getThreadedLoading", "setThreadedLoading", "ctjs" })
public final class Config extends Vigilant
{
    @NotNull
    public static final Config INSTANCE;
    @Property(type = PropertyType.TEXT, name = "Modules Folders", category = "General", description = "Folder where CT modules are stored")
    @NotNull
    private static String modulesFolder;
    @Property(type = PropertyType.SWITCH, name = "Threaded loading", category = "General", description = "Load CT modules in a background thread")
    private static boolean threadedLoading;
    @Property(type = PropertyType.SWITCH, name = "Show module help on import", category = "General", description = "If a module is imported and it has a help message, display it in chat")
    private static boolean moduleImportHelp;
    @Property(type = PropertyType.SWITCH, name = "Show module changelog on update", category = "General", description = "If a module is updated and it has a changelog, display it in chat")
    private static boolean moduleChangelog;
    @Property(type = PropertyType.SWITCH, name = "Print chat to console", category = "Console", description = "Prints the user's chat messages (with explicit color codes) to the general console for easy copy-pasting")
    private static boolean printChatToConsole;
    @Property(type = PropertyType.SWITCH, name = "Show updates in chat", category = "General", description = "Show CT module import/update messages in the chat")
    private static boolean showUpdatesInChat;
    @Property(type = PropertyType.SWITCH, name = "Auto-update modules", category = "General", description = "Check for and download module updates every time CT loads")
    private static boolean autoUpdateModules;
    @Property(type = PropertyType.SWITCH, name = "Clear console on CT load", category = "Console")
    private static boolean clearConsoleOnLoad;
    @Property(type = PropertyType.SWITCH, name = "Open console on error", category = "Console", description = "Opens the language-specific console if there is an error in a module")
    private static boolean openConsoleOnError;
    @Property(type = PropertyType.SWITCH, name = "Use Fira Code font for console", category = "Console")
    private static boolean consoleFiraCodeFont;
    @Property(type = PropertyType.NUMBER, name = "Console font size", category = "Console", min = 6, max = 32)
    private static int consoleFontSize;
    @Property(type = PropertyType.SWITCH, name = "Use custom console theme", category = "Console")
    private static boolean customTheme;
    @Property(type = PropertyType.TEXT, name = "Console custom theme", category = "Console")
    @NotNull
    private static String consoleTheme;
    @Property(type = PropertyType.COLOR, name = "Console foreground color", category = "Console")
    @NotNull
    private static Color consoleForegroundColor;
    @Property(type = PropertyType.COLOR, name = "Console background color", category = "Console")
    @NotNull
    private static Color consoleBackgroundColor;
    @Property(type = PropertyType.SWITCH, name = "Use custom console colors for errors or warnings", category = "Console")
    private static boolean consoleErrorAndWarningColors;
    @Property(type = PropertyType.COLOR, name = "Console error color", category = "Console")
    @NotNull
    private static Color consoleErrorColor;
    @Property(type = PropertyType.COLOR, name = "Console warning color", category = "Console")
    @NotNull
    private static Color consoleWarningColor;
    
    private Config() {
        super(new File(CTJS.INSTANCE.getConfigLocation(), "ChatTriggers.toml"), (String)null, (PropertyCollector)null, (SortingBehavior)CategorySorting.INSTANCE, 6, (DefaultConstructorMarker)null);
    }
    
    @NotNull
    public final String getModulesFolder() {
        return Config.modulesFolder;
    }
    
    public final void setModulesFolder(@NotNull final String <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        Config.modulesFolder = <set-?>;
    }
    
    public final boolean getThreadedLoading() {
        return Config.threadedLoading;
    }
    
    public final void setThreadedLoading(final boolean <set-?>) {
        Config.threadedLoading = <set-?>;
    }
    
    public final boolean getModuleImportHelp() {
        return Config.moduleImportHelp;
    }
    
    public final void setModuleImportHelp(final boolean <set-?>) {
        Config.moduleImportHelp = <set-?>;
    }
    
    public final boolean getModuleChangelog() {
        return Config.moduleChangelog;
    }
    
    public final void setModuleChangelog(final boolean <set-?>) {
        Config.moduleChangelog = <set-?>;
    }
    
    public final boolean getPrintChatToConsole() {
        return Config.printChatToConsole;
    }
    
    public final void setPrintChatToConsole(final boolean <set-?>) {
        Config.printChatToConsole = <set-?>;
    }
    
    public final boolean getShowUpdatesInChat() {
        return Config.showUpdatesInChat;
    }
    
    public final void setShowUpdatesInChat(final boolean <set-?>) {
        Config.showUpdatesInChat = <set-?>;
    }
    
    public final boolean getAutoUpdateModules() {
        return Config.autoUpdateModules;
    }
    
    public final void setAutoUpdateModules(final boolean <set-?>) {
        Config.autoUpdateModules = <set-?>;
    }
    
    public final boolean getClearConsoleOnLoad() {
        return Config.clearConsoleOnLoad;
    }
    
    public final void setClearConsoleOnLoad(final boolean <set-?>) {
        Config.clearConsoleOnLoad = <set-?>;
    }
    
    public final boolean getOpenConsoleOnError() {
        return Config.openConsoleOnError;
    }
    
    public final void setOpenConsoleOnError(final boolean <set-?>) {
        Config.openConsoleOnError = <set-?>;
    }
    
    public final boolean getConsoleFiraCodeFont() {
        return Config.consoleFiraCodeFont;
    }
    
    public final void setConsoleFiraCodeFont(final boolean <set-?>) {
        Config.consoleFiraCodeFont = <set-?>;
    }
    
    public final int getConsoleFontSize() {
        return Config.consoleFontSize;
    }
    
    public final void setConsoleFontSize(final int <set-?>) {
        Config.consoleFontSize = <set-?>;
    }
    
    public final boolean getCustomTheme() {
        return Config.customTheme;
    }
    
    public final void setCustomTheme(final boolean <set-?>) {
        Config.customTheme = <set-?>;
    }
    
    @NotNull
    public final String getConsoleTheme() {
        return Config.consoleTheme;
    }
    
    public final void setConsoleTheme(@NotNull final String <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        Config.consoleTheme = <set-?>;
    }
    
    @NotNull
    public final Color getConsoleForegroundColor() {
        return Config.consoleForegroundColor;
    }
    
    public final void setConsoleForegroundColor(@NotNull final Color <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        Config.consoleForegroundColor = <set-?>;
    }
    
    @NotNull
    public final Color getConsoleBackgroundColor() {
        return Config.consoleBackgroundColor;
    }
    
    public final void setConsoleBackgroundColor(@NotNull final Color <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        Config.consoleBackgroundColor = <set-?>;
    }
    
    public final boolean getConsoleErrorAndWarningColors() {
        return Config.consoleErrorAndWarningColors;
    }
    
    public final void setConsoleErrorAndWarningColors(final boolean <set-?>) {
        Config.consoleErrorAndWarningColors = <set-?>;
    }
    
    @NotNull
    public final Color getConsoleErrorColor() {
        return Config.consoleErrorColor;
    }
    
    public final void setConsoleErrorColor(@NotNull final Color <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        Config.consoleErrorColor = <set-?>;
    }
    
    @NotNull
    public final Color getConsoleWarningColor() {
        return Config.consoleWarningColor;
    }
    
    public final void setConsoleWarningColor(@NotNull final Color <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        Config.consoleWarningColor = <set-?>;
    }
    
    static {
        INSTANCE = new Config();
        Config.modulesFolder = "./config/ChatTriggers/modules";
        Config.threadedLoading = true;
        Config.moduleImportHelp = true;
        Config.moduleChangelog = true;
        Config.printChatToConsole = true;
        Config.showUpdatesInChat = true;
        Config.autoUpdateModules = true;
        Config.clearConsoleOnLoad = true;
        Config.consoleFiraCodeFont = true;
        Config.consoleFontSize = 9;
        Config.consoleTheme = "default.dark";
        Config.consoleForegroundColor = new Color(208, 208, 208);
        Config.consoleBackgroundColor = new Color(21, 21, 21);
        Config.consoleErrorAndWarningColors = true;
        Config.consoleErrorColor = new Color(225, 65, 73);
        Config.consoleWarningColor = new Color(248, 191, 84);
        final Config instance = Config.INSTANCE;
        final Field declaredField = Config.INSTANCE.getClass().getDeclaredField("consoleErrorColor");
        Intrinsics.checkNotNullExpressionValue((Object)declaredField, "javaClass.getDeclaredField(\"consoleErrorColor\")");
        final Field field = declaredField;
        final Field declaredField2 = Config.INSTANCE.getClass().getDeclaredField("consoleErrorAndWarningColors");
        Intrinsics.checkNotNullExpressionValue((Object)declaredField2, "javaClass.getDeclaredFie\u2026leErrorAndWarningColors\")");
        instance.addDependency(field, declaredField2);
        final Config instance2 = Config.INSTANCE;
        final Field declaredField3 = Config.INSTANCE.getClass().getDeclaredField("consoleWarningColor");
        Intrinsics.checkNotNullExpressionValue((Object)declaredField3, "javaClass.getDeclaredField(\"consoleWarningColor\")");
        final Field field2 = declaredField3;
        final Field declaredField4 = Config.INSTANCE.getClass().getDeclaredField("consoleErrorAndWarningColors");
        Intrinsics.checkNotNullExpressionValue((Object)declaredField4, "javaClass.getDeclaredFie\u2026leErrorAndWarningColors\")");
        instance2.addDependency(field2, declaredField4);
    }
}
