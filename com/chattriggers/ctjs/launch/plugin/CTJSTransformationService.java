//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch.plugin;

import dev.falsehonesty.asmhelper.*;
import kotlin.*;
import java.util.*;
import kotlin.collections.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/launch/plugin/CTJSTransformationService;", "Ldev/falsehonesty/asmhelper/ClassTransformationService;", "()V", "transformerClasses", "", "", "ctjs" })
public final class CTJSTransformationService implements ClassTransformationService
{
    @NotNull
    public List<String> transformerClasses() {
        return (List<String>)CollectionsKt.listOf((Object)"com.chattriggers.ctjs.launch.plugin.CTJSTransformer");
    }
}
