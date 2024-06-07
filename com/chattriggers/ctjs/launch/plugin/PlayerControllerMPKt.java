//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch.plugin;

import kotlin.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.*;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005" }, d2 = { "injectAttackEntity", "", "injectBreakBlock", "injectHitBlock", "injectPlayerControllerMP", "ctjs" })
public final class PlayerControllerMPKt
{
    public static final void injectPlayerControllerMP() {
        injectAttackEntity();
        injectHitBlock();
        injectBreakBlock();
    }
    
    public static final void injectAttackEntity() {
        Method.inject((Function1)PlayerControllerMPKt$injectAttackEntity.PlayerControllerMPKt$injectAttackEntity$1.INSTANCE);
    }
    
    public static final void injectHitBlock() {
        Method.inject((Function1)PlayerControllerMPKt$injectHitBlock.PlayerControllerMPKt$injectHitBlock$1.INSTANCE);
    }
    
    public static final void injectBreakBlock() {
        Method.inject((Function1)PlayerControllerMPKt$injectBreakBlock.PlayerControllerMPKt$injectBreakBlock$1.INSTANCE);
    }
}
