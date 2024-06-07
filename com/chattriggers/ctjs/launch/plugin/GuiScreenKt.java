//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch.plugin;

import kotlin.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.*;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a\u0006\u0010\t\u001a\u00020\u0001¨\u0006\n" }, d2 = { "injectGuiScreen", "", "injectHandleKeyboardInput", "injectMouseClick", "injectMouseDrag", "injectMouseRelease", "injectPreBackground", "injectRenderTooltip", "injectTextComponentClick", "injectTextComponentHover", "ctjs" })
public final class GuiScreenKt
{
    public static final void injectGuiScreen() {
        injectHandleKeyboardInput();
        injectMouseClick();
        injectMouseRelease();
        injectMouseDrag();
        injectTextComponentClick();
        injectTextComponentHover();
        injectRenderTooltip();
        injectPreBackground();
    }
    
    public static final void injectHandleKeyboardInput() {
        Method.inject((Function1)GuiScreenKt$injectHandleKeyboardInput.GuiScreenKt$injectHandleKeyboardInput$1.INSTANCE);
    }
    
    public static final void injectMouseClick() {
        Method.inject((Function1)GuiScreenKt$injectMouseClick.GuiScreenKt$injectMouseClick$1.INSTANCE);
    }
    
    public static final void injectMouseRelease() {
        Method.inject((Function1)GuiScreenKt$injectMouseRelease.GuiScreenKt$injectMouseRelease$1.INSTANCE);
    }
    
    public static final void injectMouseDrag() {
        Method.inject((Function1)GuiScreenKt$injectMouseDrag.GuiScreenKt$injectMouseDrag$1.INSTANCE);
    }
    
    public static final void injectTextComponentClick() {
        Method.inject((Function1)GuiScreenKt$injectTextComponentClick.GuiScreenKt$injectTextComponentClick$1.INSTANCE);
    }
    
    public static final void injectTextComponentHover() {
        Method.inject((Function1)GuiScreenKt$injectTextComponentHover.GuiScreenKt$injectTextComponentHover$1.INSTANCE);
    }
    
    public static final void injectRenderTooltip() {
        Method.inject((Function1)GuiScreenKt$injectRenderTooltip.GuiScreenKt$injectRenderTooltip$1.INSTANCE);
    }
    
    public static final void injectPreBackground() {
        Method.inject((Function1)GuiScreenKt$injectPreBackground.GuiScreenKt$injectPreBackground$1.INSTANCE);
    }
}
