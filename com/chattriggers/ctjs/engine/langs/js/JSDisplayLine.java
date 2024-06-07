//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import com.chattriggers.ctjs.minecraft.objects.display.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.mozilla.javascript.*;
import com.chattriggers.ctjs.engine.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0010¢\u0006\u0002\b\n¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSDisplayLine;", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;", "text", "", "(Ljava/lang/String;)V", "config", "Lorg/mozilla/javascript/NativeObject;", "(Ljava/lang/String;Lorg/mozilla/javascript/NativeObject;)V", "getLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "getLoader$ctjs", "ctjs" })
public final class JSDisplayLine extends DisplayLine
{
    public JSDisplayLine(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        super(text);
    }
    
    public JSDisplayLine(@NotNull final String text, @NotNull final NativeObject config) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        Intrinsics.checkNotNullParameter((Object)config, "config");
        super(text, config);
    }
    
    @NotNull
    @Override
    public ILoader getLoader$ctjs() {
        return (ILoader)JSLoader.INSTANCE;
    }
}
