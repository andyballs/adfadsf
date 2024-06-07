//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import com.chattriggers.ctjs.minecraft.objects.keybind.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.settings.*;
import com.chattriggers.ctjs.engine.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\r¨\u0006\u000e" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSKeyBind;", "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind;", "category", "", "key", "", "description", "(Ljava/lang/String;ILjava/lang/String;)V", "keyBinding", "Lnet/minecraft/client/settings/KeyBinding;", "(Lnet/minecraft/client/settings/KeyBinding;)V", "getLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "getLoader$ctjs", "ctjs" })
public final class JSKeyBind extends KeyBind
{
    @JvmOverloads
    public JSKeyBind(@NotNull final String category, final int key, @NotNull final String description) {
        Intrinsics.checkNotNullParameter((Object)category, "category");
        Intrinsics.checkNotNullParameter((Object)description, "description");
        super(category, key, description);
    }
    
    public JSKeyBind(@NotNull final KeyBinding keyBinding) {
        Intrinsics.checkNotNullParameter((Object)keyBinding, "keyBinding");
        super(keyBinding);
    }
    
    @NotNull
    @Override
    public ILoader getLoader$ctjs() {
        return (ILoader)JSLoader.INSTANCE;
    }
    
    @JvmOverloads
    public JSKeyBind(@NotNull final String category, final int key) {
        Intrinsics.checkNotNullParameter((Object)category, "category");
        this(category, key, null, 4, null);
    }
}
