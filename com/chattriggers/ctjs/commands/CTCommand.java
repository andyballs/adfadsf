//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.commands;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraft.command.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import com.chattriggers.ctjs.minecraft.objects.gui.*;
import net.minecraft.client.gui.*;
import com.chattriggers.ctjs.utils.*;
import kotlin.collections.*;
import gg.essential.api.utils.*;
import gg.essential.vigilance.gui.*;
import com.chattriggers.ctjs.engine.module.*;
import kotlin.text.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import java.util.*;
import java.io.*;
import com.chattriggers.ctjs.*;
import com.chattriggers.ctjs.utils.console.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import java.awt.*;
import java.awt.datatransfer.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010\fJ\u0012\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J%\u0010\u001f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010 J\u001b\u0010!\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\"" }, d2 = { "Lcom/chattriggers/ctjs/commands/CTCommand;", "Lnet/minecraft/command/CommandBase;", "()V", "idFixed", "", "idFixedOffset", "clearOldDump", "", "copyArgsToClipboard", "args", "", "", "([Ljava/lang/String;)V", "dump", "dumpActionBar", "lines", "dumpChat", "dumpList", "messages", "", "getCommandAliases", "", "getCommandName", "getCommandUsage", "sender", "Lnet/minecraft/command/ICommandSender;", "getRequiredPermissionLevel", "getUsage", "import", "moduleName", "openFileLocation", "processCommand", "(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;)V", "run", "ctjs" })
public final class CTCommand extends CommandBase
{
    @NotNull
    public static final CTCommand INSTANCE;
    private static final int idFixed = 90123;
    private static int idFixedOffset;
    
    private CTCommand() {
    }
    
    @NotNull
    public String getCommandUsage(@Nullable final ICommandSender sender) {
        return this.getUsage();
    }
    
    @NotNull
    public String getCommandName() {
        return "chattriggers";
    }
    
    @NotNull
    public List<String> getCommandAliases() {
        return (List<String>)CollectionsKt.mutableListOf((Object[])new String[] { "ct" });
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public void processCommand(@Nullable final ICommandSender sender, @NotNull final String[] args) throws CommandException {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        this.run(args);
    }
    
    private final void run(final String[] args) {
        if (args.length == 0) {
            ChatLib.chat(this.getUsage());
            return;
        }
        final String lowerCase = args[0].toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        final String s = lowerCase;
        Label_0588: {
            Label_0533: {
                Label_0511: {
                    Label_0387: {
                        switch (s) {
                            case "console": {
                                if (args.length == 1) {
                                    ModuleManager.INSTANCE.getGeneralConsole().showConsole();
                                    return;
                                }
                                ModuleManager.INSTANCE.getConsole(args[1]).showConsole();
                                return;
                            }
                            case "settings": {
                                break Label_0511;
                            }
                            case "import": {
                                if (args.length == 1) {
                                    ChatLib.chat("&c/ct import [module name]");
                                    return;
                                }
                                this.import(args[1]);
                                return;
                            }
                            case "delete": {
                                if (args.length == 1) {
                                    ChatLib.chat("&c/ct delete [module name]");
                                    return;
                                }
                                ChatLib.chat(Intrinsics.stringPlus(ModuleManager.INSTANCE.deleteModule(args[1]) ? "&aDeleted " : "&cFailed to delete ", (Object)args[1]));
                                return;
                            }
                            case "modules": {
                                GuiHandler.INSTANCE.openGui(ModulesGui.INSTANCE);
                                return;
                            }
                            case "setting": {
                                break Label_0511;
                            }
                            case "reload": {
                                break;
                            }
                            case "file": {
                                break Label_0387;
                            }
                            case "load": {
                                break;
                            }
                            case "sim": {
                                break Label_0533;
                            }
                            case "unload": {
                                Reference.unloadCT$default(false, 1, null);
                                return;
                            }
                            case "files": {
                                break Label_0387;
                            }
                            case "dump": {
                                this.dump(args);
                                return;
                            }
                            case "copy": {
                                this.copyArgsToClipboard(args);
                                return;
                            }
                            case "config": {
                                break Label_0511;
                            }
                            case "simulate": {
                                break Label_0533;
                            }
                            default:
                                break Label_0588;
                        }
                        Reference.loadCT();
                        return;
                    }
                    this.openFileLocation();
                    return;
                }
                final GuiUtil$Companion companion = GuiUtil.Companion;
                final SettingsGui gui = Config.INSTANCE.gui();
                Intrinsics.checkNotNull((Object)gui);
                companion.open((GuiScreen)gui);
                return;
            }
            ChatLib.simulateChat(ArraysKt.joinToString$default(ArraysKt.copyOfRange((Object[])args, 1, args.length), (CharSequence)" ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
            return;
        }
        ChatLib.chat(this.getUsage());
    }
    
    private final void import(final String moduleName) {
        final Iterable $this$any$iv = ModuleManager.INSTANCE.getCachedModules();
        final int $i$f$any = 0;
        boolean b = false;
        Label_0090: {
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                b = false;
            }
            else {
                for (final Object element$iv : $this$any$iv) {
                    final Module it = (Module)element$iv;
                    final int n = 0;
                    if (StringsKt.equals(it.getName(), moduleName, true)) {
                        b = true;
                        break Label_0090;
                    }
                }
                b = false;
            }
        }
        if (b) {
            ChatLib.chat("&cModule " + moduleName + " is already installed!");
        }
        else {
            ChatLib.chat("&cImporting " + moduleName + "...");
            Reference.conditionalThread((Function0<Unit>)new CTCommand$import.CTCommand$import$2(moduleName));
        }
    }
    
    private final String getUsage() {
        return StringsKt.trimIndent("\n        &b&m" + ChatLib.getChatBreak$default(null, 1, null) + "\n        &c/ct load &7- &oReloads all of the ChatTriggers modules.\n        &c/ct import [module] &7- &oImports a module.\n        &c/ct delete [module] &7- &oDeletes a module.\n        &c/ct files &7- &oOpens the ChatTriggers folder.\n        &c/ct modules &7- &oOpens the modules GUI.\n        &c/ct console [language] &7- &oOpens the ChatTriggers console.\n        &c/ct simulate [message] &7- &oSimulates a received chat message.\n        &c/ct dump &7- &oDumps previous chat messages into chat.\n        &c/ct settings &7- &oOpens the ChatTriggers settings.\n        &c/ct &7- &oDisplays this help dialog.\n        &b&m" + ChatLib.getChatBreak$default(null, 1, null) + "\n    ");
    }
    
    private final void openFileLocation() {
        try {
            Desktop.getDesktop().open(new File("./config/ChatTriggers"));
        }
        catch (IOException exception) {
            ReferenceKt.printTraceToConsole$default(exception, null, 1, null);
            ChatLib.chat("&cCould not open file location");
        }
    }
    
    private final void dump(final String[] args) {
        if (args.length == 1) {
            dumpChat$default(this, 0, 1, null);
            return;
        }
        final String lowerCase = args[1].toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        final String s = lowerCase;
        if (Intrinsics.areEqual((Object)s, (Object)"chat")) {
            if (args.length == 2) {
                dumpChat$default(this, 0, 1, null);
            }
            else {
                this.dumpChat(Integer.parseInt(args[2]));
            }
        }
        else if (Intrinsics.areEqual((Object)s, (Object)"actionbar")) {
            if (args.length == 2) {
                dumpActionBar$default(this, 0, 1, null);
            }
            else {
                this.dumpActionBar(Integer.parseInt(args[2]));
            }
        }
    }
    
    private final void dumpChat(final int lines) {
        this.dumpList(ClientListener.INSTANCE.getChatHistory(), lines);
    }
    
    static /* synthetic */ void dumpChat$default(final CTCommand ctCommand, int lines, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            lines = 100;
        }
        ctCommand.dumpChat(lines);
    }
    
    private final void dumpActionBar(final int lines) {
        this.dumpList(ClientListener.INSTANCE.getActionBarHistory(), lines);
    }
    
    static /* synthetic */ void dumpActionBar$default(final CTCommand ctCommand, int lines, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            lines = 100;
        }
        ctCommand.dumpActionBar(lines);
    }
    
    private final void dumpList(final List<String> messages, final int lines) {
        this.clearOldDump();
        int toDump = lines;
        if (toDump > messages.size()) {
            toDump = messages.size();
        }
        new Message(new Object[] { Intrinsics.stringPlus("&6&m", (Object)ChatLib.getChatBreak$default(null, 1, null)) }).setChatLineId(90123).chat();
        String msg = null;
        int j = 0;
        while (j < toDump) {
            final int i = j;
            ++j;
            msg = ChatLib.replaceFormatting(messages.get(messages.size() - toDump + i));
            new Message(new Object[] { new TextComponent(msg).setClick("run_command", Intrinsics.stringPlus("/ct copy ", (Object)msg)).setHoverValue(ChatLib.addColor("&eClick here to copy this message.")).setFormatted(false) }).setFormatted(false).setChatLineId(90123 + i + 1).chat();
        }
        new Message(new Object[] { Intrinsics.stringPlus("&6&m", (Object)ChatLib.getChatBreak$default(null, 1, null)) }).setChatLineId(90123 + lines + 1).chat();
        CTCommand.idFixedOffset = 90123 + lines + 1;
    }
    
    private final void clearOldDump() {
        if (CTCommand.idFixedOffset == -1) {
            return;
        }
        while (CTCommand.idFixedOffset >= 90123) {
            final int[] chatLineIDs = { 0 };
            final int n = 0;
            final int idFixedOffset = CTCommand.idFixedOffset;
            CTCommand.idFixedOffset = idFixedOffset - 1;
            chatLineIDs[n] = idFixedOffset;
            ChatLib.clearChat(chatLineIDs);
        }
        CTCommand.idFixedOffset = -1;
    }
    
    private final void copyArgsToClipboard(final String[] args) {
        this.clearOldDump();
        final String toCopy = ArraysKt.joinToString$default(ArraysKt.copyOfRange((Object[])args, 1, args.length), (CharSequence)" ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(toCopy), null);
    }
    
    static {
        INSTANCE = new CTCommand();
        CTCommand.idFixedOffset = -1;
    }
}
