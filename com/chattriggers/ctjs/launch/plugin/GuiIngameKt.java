//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch.plugin;

import kotlin.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.*;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003" }, d2 = { "injectGuiIngame", "", "injectRenderScoreboard", "ctjs" })
public final class GuiIngameKt
{
    public static final void injectGuiIngame() {
        injectRenderScoreboard();
    }
    
    public static final void injectRenderScoreboard() {
        Method.inject((Function1)GuiIngameKt$injectRenderScoreboard.GuiIngameKt$injectRenderScoreboard$1.INSTANCE);
    }
}
