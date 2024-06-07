//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch.plugin;

import kotlin.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.*;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004" }, d2 = { "injectRenderTileEntity", "", "injectRenderTileEntityPost", "injectTileEntityRendererDispatcher", "ctjs" })
public final class TileEntityRendererDispatcherKt
{
    public static final void injectTileEntityRendererDispatcher() {
        injectRenderTileEntity();
        injectRenderTileEntityPost();
    }
    
    public static final void injectRenderTileEntity() {
        Method.inject((Function1)TileEntityRendererDispatcherKt$injectRenderTileEntity.TileEntityRendererDispatcherKt$injectRenderTileEntity$1.INSTANCE);
    }
    
    public static final void injectRenderTileEntityPost() {
        Method.inject((Function1)TileEntityRendererDispatcherKt$injectRenderTileEntityPost.TileEntityRendererDispatcherKt$injectRenderTileEntityPost$1.INSTANCE);
    }
}
