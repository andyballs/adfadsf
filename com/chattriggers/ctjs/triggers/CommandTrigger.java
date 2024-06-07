//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import com.chattriggers.ctjs.commands.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.functions.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import java.util.*;
import kotlin.jvm.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001f\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\t¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J(\u0010\u001a\u001a\u00020\u00002 \u0010\n\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bJ\u001f\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\t¢\u0006\u0002\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00142\u0010\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\fH\u0016¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "Lcom/chattriggers/ctjs/triggers/CommandTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/engine/ILoader;)V", "aliases", "", "", "callback", "Lkotlin/Function1;", "", "command", "Lcom/chattriggers/ctjs/commands/Command;", "commandName", "overrideExisting", "", "tabCompletions", "reInstance", "", "setAliases", "args", "([Ljava/lang/String;)Lcom/chattriggers/ctjs/triggers/CommandTrigger;", "setCommandName", "setName", "setTabCompletions", "trigger", "([Ljava/lang/Object;)V", "ctjs" })
public final class CommandTrigger extends Trigger
{
    private String commandName;
    private boolean overrideExisting;
    @NotNull
    private final List<String> tabCompletions;
    @NotNull
    private final List<String> aliases;
    @Nullable
    private Command command;
    @Nullable
    private Function1<? super String[], ? extends List<String>> callback;
    
    public CommandTrigger(@NotNull final Object method, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, TriggerType.Command, loader);
        this.tabCompletions = new ArrayList<String>();
        this.aliases = new ArrayList<String>();
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        this.callMethod(args);
    }
    
    @NotNull
    public final CommandTrigger setTabCompletions(@NotNull final String... args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final CommandTrigger $this$setTabCompletions_u24lambda_u2d0 = this;
        final int n = 0;
        CollectionsKt.addAll((Collection)$this$setTabCompletions_u24lambda_u2d0.tabCompletions, (Object[])args);
        return this;
    }
    
    @NotNull
    public final CommandTrigger setTabCompletions(@NotNull final Function1<? super String[], ? extends List<String>> callback) {
        Intrinsics.checkNotNullParameter((Object)callback, "callback");
        final CommandTrigger $this$setTabCompletions_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setTabCompletions_u24lambda_u2d1.callback = callback;
        return this;
    }
    
    @NotNull
    public final CommandTrigger setAliases(@NotNull final String... args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final CommandTrigger $this$setAliases_u24lambda_u2d3 = this;
        final int n = 0;
        if ($this$setAliases_u24lambda_u2d3.commandName == null) {
            final int n2 = 0;
            throw new IllegalStateException("Command name must be set before aliases!".toString());
        }
        CollectionsKt.addAll((Collection)$this$setAliases_u24lambda_u2d3.aliases, (Object[])args);
        $this$setAliases_u24lambda_u2d3.reInstance();
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final CommandTrigger setCommandName(@NotNull final String commandName, final boolean overrideExisting) {
        Intrinsics.checkNotNullParameter((Object)commandName, "commandName");
        final CommandTrigger $this$setCommandName_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setCommandName_u24lambda_u2d4.commandName = commandName;
        $this$setCommandName_u24lambda_u2d4.overrideExisting = overrideExisting;
        $this$setCommandName_u24lambda_u2d4.reInstance();
        return this;
    }
    
    public static /* synthetic */ CommandTrigger setCommandName$default(final CommandTrigger commandTrigger, final String commandName, boolean overrideExisting, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            overrideExisting = false;
        }
        return commandTrigger.setCommandName(commandName, overrideExisting);
    }
    
    @JvmOverloads
    @NotNull
    public final CommandTrigger setName(@NotNull final String commandName, final boolean overrideExisting) {
        Intrinsics.checkNotNullParameter((Object)commandName, "commandName");
        return this.setCommandName(commandName, overrideExisting);
    }
    
    public static /* synthetic */ CommandTrigger setName$default(final CommandTrigger commandTrigger, final String commandName, boolean overrideExisting, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            overrideExisting = false;
        }
        return commandTrigger.setName(commandName, overrideExisting);
    }
    
    private final void reInstance() {
        final Command command = this.command;
        if (command != null) {
            command.unregister();
        }
        final CommandTrigger commandTrigger = this;
        String commandName;
        if ((commandName = this.commandName) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandName");
            commandName = null;
        }
        final String s = "/";
        String commandName2;
        if ((commandName2 = this.commandName) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandName");
            commandName2 = null;
        }
        this.command = new Command((Trigger)commandTrigger, commandName, Intrinsics.stringPlus(s, (Object)commandName2), (List)this.tabCompletions, (List)this.aliases, this.overrideExisting, (Function1)this.callback);
        final Command command2 = this.command;
        Intrinsics.checkNotNull((Object)command2);
        command2.register();
    }
    
    @JvmOverloads
    @NotNull
    public final CommandTrigger setCommandName(@NotNull final String commandName) {
        Intrinsics.checkNotNullParameter((Object)commandName, "commandName");
        return setCommandName$default(this, commandName, false, 2, null);
    }
    
    @JvmOverloads
    @NotNull
    public final CommandTrigger setName(@NotNull final String commandName) {
        Intrinsics.checkNotNullParameter((Object)commandName, "commandName");
        return setName$default(this, commandName, false, 2, null);
    }
}
