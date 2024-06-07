//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.utils.console.*;
import kotlin.jvm.internal.*;
import java.awt.*;
import com.chattriggers.ctjs.engine.module.*;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\t" }, d2 = { "printToConsole", "", "", "console", "Lcom/chattriggers/ctjs/utils/console/Console;", "logType", "Lcom/chattriggers/ctjs/utils/console/LogType;", "printTraceToConsole", "", "ctjs" })
public final class ReferenceKt
{
    public static final void printToConsole(@NotNull final Object $this$printToConsole, @NotNull final Console console, @NotNull final LogType logType) {
        Intrinsics.checkNotNullParameter($this$printToConsole, "<this>");
        Intrinsics.checkNotNullParameter((Object)console, "console");
        Intrinsics.checkNotNullParameter((Object)logType, "logType");
        Console.println$default(console, $this$printToConsole, logType, null, null, 12, null);
    }
    
    public static final void printTraceToConsole(@NotNull final Throwable $this$printTraceToConsole, @NotNull final Console console) {
        Intrinsics.checkNotNullParameter((Object)$this$printTraceToConsole, "<this>");
        Intrinsics.checkNotNullParameter((Object)console, "console");
        console.printStackTrace($this$printTraceToConsole);
    }
}
