//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.commands;

import kotlin.*;
import com.chattriggers.ctjs.triggers.*;
import kotlin.jvm.functions.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import net.minecraft.util.*;
import net.minecraftforge.client.*;
import com.chattriggers.ctjs.utils.console.*;
import com.chattriggers.ctjs.*;
import net.minecraft.command.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dJ#\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u001fR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$" }, d2 = { "Lcom/chattriggers/ctjs/commands/Command;", "Lnet/minecraft/command/CommandBase;", "trigger", "Lcom/chattriggers/ctjs/triggers/Trigger;", "name", "", "usage", "tabCompletionOptions", "", "aliases", "overrideExisting", "", "callback", "Lkotlin/Function1;", "", "(Lcom/chattriggers/ctjs/triggers/Trigger;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLkotlin/jvm/functions/Function1;)V", "addTabCompletionOptions", "sender", "Lnet/minecraft/command/ICommandSender;", "args", "pos", "Lnet/minecraft/util/BlockPos;", "(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;Lnet/minecraft/util/BlockPos;)Ljava/util/List;", "getCommandAliases", "getCommandName", "getCommandUsage", "getRequiredPermissionLevel", "", "getTriggers", "", "processCommand", "", "(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;)V", "register", "unregister", "Companion", "ctjs" })
public final class Command extends CommandBase
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Trigger trigger;
    @NotNull
    private final String name;
    @NotNull
    private final String usage;
    @NotNull
    private final List<String> tabCompletionOptions;
    @NotNull
    private List<String> aliases;
    private final boolean overrideExisting;
    @Nullable
    private final Function1<String[], List<String>> callback;
    @NotNull
    private static final Map<String, Command> activeCommands;
    
    public Command(@NotNull final Trigger trigger, @NotNull final String name, @NotNull final String usage, @NotNull final List<String> tabCompletionOptions, @NotNull final List<String> aliases, final boolean overrideExisting, @Nullable final Function1<? super String[], ? extends List<String>> callback) {
        Intrinsics.checkNotNullParameter((Object)trigger, "trigger");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)usage, "usage");
        Intrinsics.checkNotNullParameter((Object)tabCompletionOptions, "tabCompletionOptions");
        Intrinsics.checkNotNullParameter((Object)aliases, "aliases");
        this.trigger = trigger;
        this.name = name;
        this.usage = usage;
        this.tabCompletionOptions = tabCompletionOptions;
        this.aliases = aliases;
        this.overrideExisting = overrideExisting;
        this.callback = (Function1<String[], List<String>>)callback;
    }
    
    @NotNull
    public final List<Trigger> getTriggers() {
        return (List<Trigger>)CollectionsKt.listOf((Object)this.trigger);
    }
    
    @NotNull
    public String getCommandName() {
        return this.name;
    }
    
    @NotNull
    public List<String> getCommandAliases() {
        return this.aliases;
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @NotNull
    public String getCommandUsage(@NotNull final ICommandSender sender) {
        Intrinsics.checkNotNullParameter((Object)sender, "sender");
        return this.usage;
    }
    
    @NotNull
    public List<String> addTabCompletionOptions(@Nullable final ICommandSender sender, @Nullable final String[] args, @Nullable final BlockPos pos) {
        final Function1<String[], List<String>> callback = this.callback;
        List list;
        List<String> tabCompletionOptions;
        if (callback == null) {
            tabCompletionOptions = (List<String>)(list = null);
        }
        else {
            String[] array;
            if ((array = args) == null) {
                array = new String[0];
            }
            final List list2 = (List)callback.invoke((Object)array);
            tabCompletionOptions = (List<String>)(list = ((list2 == null) ? null : CollectionsKt.toMutableList((Collection)list2)));
        }
        if (list == null) {
            tabCompletionOptions = this.tabCompletionOptions;
        }
        return tabCompletionOptions;
    }
    
    public void processCommand(@NotNull final ICommandSender sender, @NotNull final String[] args) throws CommandException {
        Intrinsics.checkNotNullParameter((Object)sender, "sender");
        Intrinsics.checkNotNullParameter((Object)args, "args");
        this.trigger.trigger(args);
    }
    
    public final void register() {
        if (ClientCommandHandler.instance.getCommands().keySet().contains(this.name) && !this.overrideExisting) {
            ReferenceKt.printToConsole("Command with name " + this.name + " already exists! This will not override the other command with the same name. To override conflicting commands, set the 2nd argument in setName() to true.", this.trigger.getLoader$ctjs().getConsole(), LogType.WARN);
            return;
        }
        ClientCommandHandler.instance.registerCommand((ICommand)this);
        Command.activeCommands.put(this.name, this);
    }
    
    public final void unregister() {
        ClientCommandHandler.instance.commandSet.remove(this);
        ClientCommandHandler.instance.getCommands().remove(this.name);
        Command.activeCommands.remove(this.name);
    }
    
    public static final /* synthetic */ Map access$getActiveCommands$cp() {
        return Command.activeCommands;
    }
    
    static {
        Companion = new Companion(null);
        activeCommands = new LinkedHashMap<String, Command>();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t" }, d2 = { "Lcom/chattriggers/ctjs/commands/Command$Companion;", "", "()V", "activeCommands", "", "", "Lcom/chattriggers/ctjs/commands/Command;", "getActiveCommands$ctjs", "()Ljava/util/Map;", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final Map<String, Command> getActiveCommands$ctjs() {
            return (Map<String, Command>)Command.access$getActiveCommands$cp();
        }
    }
}
