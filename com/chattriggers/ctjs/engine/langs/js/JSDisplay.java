//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import kotlin.*;
import org.mozilla.javascript.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.objects.display.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0010¢\u0006\u0002\b\n¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSDisplay;", "Lcom/chattriggers/ctjs/minecraft/objects/display/Display;", "()V", "config", "Lorg/mozilla/javascript/NativeObject;", "(Lorg/mozilla/javascript/NativeObject;)V", "createDisplayLine", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;", "text", "", "createDisplayLine$ctjs", "ctjs" })
public final class JSDisplay extends Display
{
    public JSDisplay() {
    }
    
    public JSDisplay(@Nullable final NativeObject config) {
        super(config);
    }
    
    @NotNull
    @Override
    public DisplayLine createDisplayLine$ctjs(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        return new JSDisplayLine(text);
    }
}
