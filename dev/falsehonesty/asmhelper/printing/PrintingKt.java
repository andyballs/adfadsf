//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.printing;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.*;
import org.apache.logging.log4j.*;

@Metadata(mv = { 1, 5, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000b" }, d2 = { "logger", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "log", "", "message", "", "level", "Ldev/falsehonesty/asmhelper/printing/LogLevel;", "verbose", "AsmHelper1.8.9" })
public final class PrintingKt
{
    @NotNull
    private static final Logger logger;
    
    @NotNull
    public static final Logger getLogger() {
        return PrintingKt.logger;
    }
    
    public static final void log(@NotNull final String message, @NotNull final LogLevel level) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        Intrinsics.checkNotNullParameter((Object)level, "level");
        if (level == LogLevel.NORMAL || AsmHelper.INSTANCE.getVerbose()) {
            PrintingKt.logger.info(message);
        }
    }
    
    public static final void verbose(@NotNull final String message) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        log(message, LogLevel.VERBOSE);
    }
    
    static {
        final Logger logger2 = LogManager.getLogger("AsmHelper");
        Intrinsics.checkNotNull((Object)logger2);
        logger = logger2;
    }
}
