//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils.console;

import kotlin.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/utils/console/LogType;", "", "(Ljava/lang/String;I)V", "INFO", "WARN", "ERROR", "ctjs" })
public enum LogType
{
    INFO, 
    WARN, 
    ERROR;
    
    private static final /* synthetic */ LogType[] $values() {
        return new LogType[] { LogType.INFO, LogType.WARN, LogType.ERROR };
    }
    
    static {
        $VALUES = $values();
    }
}
