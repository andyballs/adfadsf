//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import com.chattriggers.ctjs.minecraft.objects.gui.*;
import kotlin.*;
import com.chattriggers.ctjs.engine.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0010¢\u0006\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSGui;", "Lcom/chattriggers/ctjs/minecraft/objects/gui/Gui;", "()V", "getLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "getLoader$ctjs", "ctjs" })
public final class JSGui extends Gui
{
    @NotNull
    @Override
    public ILoader getLoader$ctjs() {
        return (ILoader)JSLoader.INSTANCE;
    }
}
