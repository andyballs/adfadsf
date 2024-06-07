//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch.plugin;

import dev.falsehonesty.asmhelper.*;
import kotlin.*;
import net.minecraft.launchwrapper.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.engine.module.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n" }, d2 = { "Lcom/chattriggers/ctjs/launch/plugin/CTJSTransformer;", "Ldev/falsehonesty/asmhelper/BaseClassTransformer;", "()V", "transforming", "", "makeTransformers", "", "setup", "classLoader", "Lnet/minecraft/launchwrapper/LaunchClassLoader;", "ctjs" })
public final class CTJSTransformer extends BaseClassTransformer
{
    private boolean transforming;
    
    protected void setup(@NotNull final LaunchClassLoader classLoader) {
        Intrinsics.checkNotNullParameter((Object)classLoader, "classLoader");
        super.setup(classLoader);
        classLoader.addTransformerExclusion("ct.");
        classLoader.addTransformerExclusion("com.chattriggers.ctjs.");
        classLoader.addTransformerExclusion("file__");
        classLoader.addTransformerExclusion("com.google.gson.");
        classLoader.addTransformerExclusion("org.mozilla.javascript");
        classLoader.addTransformerExclusion("org.mozilla.classfile");
        classLoader.addTransformerExclusion("com.fasterxml.jackson.core.Version");
        classLoader.addTransformerExclusion("dev.falsehonesty.asmhelper.");
        classLoader.addTransformerExclusion("org.fife.");
    }
    
    public void makeTransformers() {
        if (this.transforming) {
            return;
        }
        this.transforming = true;
        try {
            CrashReportKt.injectCrashReport();
            GuiMainMenuKt.injectGuiMainMenu();
            MinecraftKt.injectMinecraft();
            ScreenshotHelperKt.injectScreenshotHelper();
            RenderManagerKt.injectRenderManager();
            EffectRendererKt.injectEffectRenderer();
            GuiScreenKt.injectGuiScreen();
            PlayerControllerMPKt.injectPlayerControllerMP();
            GuiContainerKt.injectGuiContainer();
            TileEntityRendererDispatcherKt.injectTileEntityRendererDispatcher();
            GuiIngameKt.injectGuiIngame();
            GuiIngameForgeKt.injectGuiIngameForge();
            RenderItemKt.injectRenderItem();
            EntityPlayerSPKt.injectEntityPlayerSP();
            XRayKt.injectXRay();
            ModuleManager.INSTANCE.setup();
            ModuleManager.INSTANCE.asmPass();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
