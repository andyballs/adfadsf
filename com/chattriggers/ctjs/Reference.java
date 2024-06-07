//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs;

import org.jetbrains.annotations.*;
import kotlin.jvm.*;
import com.chattriggers.ctjs.minecraft.objects.display.*;
import com.chattriggers.ctjs.engine.module.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import com.chattriggers.ctjs.minecraft.objects.keybind.*;
import com.chattriggers.ctjs.triggers.*;
import com.chattriggers.ctjs.commands.*;
import kotlin.collections.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import kotlin.jvm.functions.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import java.util.*;
import kotlin.*;
import kotlin.math.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import com.chattriggers.ctjs.utils.*;
import kotlin.concurrent.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0007J\u0012\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018" }, d2 = { "Lcom/chattriggers/ctjs/Reference;", "", "()V", "DEFAULT_MODULES_FOLDER", "", "MODID", "MODNAME", "MODVERSION", "isLoaded", "", "()Z", "setLoaded", "(Z)V", "conditionalThread", "", "block", "Lkotlin/Function0;", "loadCT", "printLoadCompletionStatus", "percentComplete", "", "reloadCT", "unloadCT", "asCommand", "ctjs" })
public final class Reference
{
    @NotNull
    public static final Reference INSTANCE;
    @NotNull
    public static final String MODID = "chattriggers";
    @NotNull
    public static final String MODNAME = "ChatTriggers";
    @NotNull
    public static final String MODVERSION = "2.2.0";
    @NotNull
    public static final String DEFAULT_MODULES_FOLDER = "./config/ChatTriggers/modules";
    private static boolean isLoaded;
    
    private Reference() {
    }
    
    public final boolean isLoaded() {
        return Reference.isLoaded;
    }
    
    public final void setLoaded(final boolean <set-?>) {
        Reference.isLoaded = <set-?>;
    }
    
    @Deprecated(message = "Does not provide any additional functionality", replaceWith = @ReplaceWith(expression = "loadCT", imports = {}))
    @JvmStatic
    @java.lang.Deprecated
    public static final void reloadCT() {
        final Reference instance = Reference.INSTANCE;
        loadCT();
    }
    
    @JvmStatic
    public static final void unloadCT(final boolean asCommand) {
        TriggerType.WorldUnload.triggerAll(new Object[0]);
        TriggerType.GameUnload.triggerAll(new Object[0]);
        final Reference instance = Reference.INSTANCE;
        Reference.isLoaded = false;
        DisplayHandler.INSTANCE.clearDisplays();
        ModuleManager.INSTANCE.teardown();
        MouseListener.INSTANCE.clearListeners();
        KeyBind.Companion.clearKeyBinds();
        ForgeTrigger.Companion.unregisterTriggers();
        final Iterable $this$forEach$iv = CollectionsKt.toList((Iterable)Command.Companion.getActiveCommands$ctjs().values());
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Command p0 = (Command)element$iv;
            final int n = 0;
            p0.unregister();
        }
        Client.Companion.scheduleTask$default(Client.Companion, 0, (Function0)Reference$unloadCT.Reference$unloadCT$2.INSTANCE, 1, null);
        if (asCommand) {
            ChatLib.chat((Object)"&7Unloaded all of ChatTriggers");
        }
    }
    
    @JvmStatic
    public static final void loadCT() {
        Client.Companion.getMinecraft().gameSettings.saveOptions();
        final Reference instance = Reference.INSTANCE;
        unloadCT(false);
        ChatLib.chat((Object)"&cReloading ChatTriggers scripts...");
        Reference.INSTANCE.printLoadCompletionStatus(0.0f);
        final Reference instance2 = Reference.INSTANCE;
        conditionalThread((Function0<Unit>)Reference$loadCT.Reference$loadCT$1.INSTANCE);
    }
    
    private final void printLoadCompletionStatus(final float percentComplete) {
        final int completionInteger = MathKt.roundToInt(percentComplete * 100);
        final String prefix = completionInteger + "% [";
        final String postfix = "]";
        final int charWidth = Renderer.getStringWidth("=");
        final int availableWidth = ChatLib.getChatWidth() - Renderer.getStringWidth(Intrinsics.stringPlus(prefix, (Object)postfix));
        final int correctLength = availableWidth / charWidth;
        final int completedLength = MathKt.roundToInt(percentComplete * correctLength);
        final String fullWidth = ExtensionsKt.times("=", completedLength);
        final int spaceWidth = Renderer.getStringWidth(" ");
        final int spaceLeft = (availableWidth - completedLength * charWidth) / spaceWidth;
        final String padding = ExtensionsKt.times(" ", spaceLeft);
        final String correctLine = "&c" + prefix + fullWidth + padding + postfix;
        new Message(new Object[] { correctLine }).setChatLineId(28445).chat();
    }
    
    @JvmStatic
    public static final void conditionalThread(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        if (Config.INSTANCE.getThreadedLoading()) {
            ThreadsKt.thread$default(false, false, (ClassLoader)null, (String)null, 0, (Function0)new Reference$conditionalThread.Reference$conditionalThread$1((Function0)block), 31, (Object)null);
        }
        else {
            block.invoke();
        }
    }
    
    static {
        INSTANCE = new Reference();
        Reference.isLoaded = true;
    }
}
