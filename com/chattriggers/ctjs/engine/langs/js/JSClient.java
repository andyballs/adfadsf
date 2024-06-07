//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import com.chattriggers.ctjs.minecraft.wrappers.*;
import kotlin.*;
import java.util.concurrent.*;
import com.chattriggers.ctjs.minecraft.objects.keybind.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.settings.*;
import java.util.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSClient;", "Lcom/chattriggers/ctjs/minecraft/wrappers/Client;", "()V", "camera", "Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion$camera;", "getCamera", "()Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion$camera;", "currentGui", "Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion$currentGui;", "getCurrentGui", "()Lcom/chattriggers/ctjs/minecraft/wrappers/Client$Companion$currentGui;", "getKeyBindFromDescription", "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind;", "description", "", "getKeyBindFromKey", "keyCode", "", "category", "ctjs" })
public final class JSClient extends Client
{
    @NotNull
    public static final JSClient INSTANCE;
    @NotNull
    private static final Companion.currentGui currentGui;
    @NotNull
    private static final Companion.camera camera;
    
    private JSClient() {
    }
    
    @Nullable
    @Override
    public KeyBind getKeyBindFromKey(final int keyCode) {
        while (true) {
            for (final KeyBind next : KeyBindHandler.INSTANCE.getKeyBinds()) {
                final KeyBind it = next;
                final int n = 0;
                if (it.getKeyCode() == keyCode) {
                    final KeyBind keyBind = next;
                    final KeyBind keyBind2 = keyBind;
                    if (keyBind2 == null) {
                        final KeyBinding[] keyBindings = Client.Companion.getMinecraft().gameSettings.keyBindings;
                        Intrinsics.checkNotNullExpressionValue((Object)keyBindings, "getMinecraft().gameSettings.keyBindings");
                        final KeyBinding[] array = keyBindings;
                        while (true) {
                            for (int i = 0; i < array.length; ++i) {
                                final KeyBinding keyBinding = array[i];
                                final KeyBinding it2 = keyBinding;
                                final int n2 = 0;
                                if (it2.getKeyCode() == keyCode) {
                                    final KeyBinding keyBinding2 = keyBinding;
                                    final KeyBinding keyBinding3 = keyBinding2;
                                    JSKeyBind jsKeyBind;
                                    if (keyBinding3 == null) {
                                        jsKeyBind = null;
                                    }
                                    else {
                                        final KeyBinding p0 = keyBinding3;
                                        final int n3 = 0;
                                        jsKeyBind = new JSKeyBind(p0);
                                    }
                                    return jsKeyBind;
                                }
                            }
                            final KeyBinding keyBinding2 = null;
                            continue;
                        }
                    }
                    return keyBind2;
                }
            }
            final KeyBind keyBind = null;
            continue;
        }
    }
    
    @NotNull
    @Override
    public KeyBind getKeyBindFromKey(final int keyCode, @NotNull final String description, @NotNull final String category) {
        Intrinsics.checkNotNullParameter((Object)description, "description");
        Intrinsics.checkNotNullParameter((Object)category, "category");
        KeyBind keyBindFromKey;
        if ((keyBindFromKey = this.getKeyBindFromKey(keyCode)) == null) {
            keyBindFromKey = new JSKeyBind(description, keyCode, category);
        }
        return keyBindFromKey;
    }
    
    @NotNull
    @Override
    public KeyBind getKeyBindFromKey(final int keyCode, @NotNull final String description) {
        Intrinsics.checkNotNullParameter((Object)description, "description");
        return this.getKeyBindFromKey(keyCode, description, "ChatTriggers");
    }
    
    @Nullable
    @Override
    public KeyBind getKeyBindFromDescription(@NotNull final String description) {
        Intrinsics.checkNotNullParameter((Object)description, "description");
        while (true) {
            for (final KeyBind next : KeyBindHandler.INSTANCE.getKeyBinds()) {
                final KeyBind it = next;
                final int n = 0;
                if (Intrinsics.areEqual((Object)it.getDescription(), (Object)description)) {
                    final KeyBind keyBind = next;
                    final KeyBind keyBind2 = keyBind;
                    if (keyBind2 == null) {
                        final KeyBinding[] keyBindings = Client.Companion.getMinecraft().gameSettings.keyBindings;
                        Intrinsics.checkNotNullExpressionValue((Object)keyBindings, "getMinecraft().gameSettings.keyBindings");
                        final KeyBinding[] array = keyBindings;
                        while (true) {
                            for (int i = 0; i < array.length; ++i) {
                                final KeyBinding keyBinding = array[i];
                                final KeyBinding it2 = keyBinding;
                                final int n2 = 0;
                                if (Intrinsics.areEqual((Object)it2.getKeyDescription(), (Object)description)) {
                                    final KeyBinding keyBinding2 = keyBinding;
                                    final KeyBinding keyBinding3 = keyBinding2;
                                    JSKeyBind jsKeyBind;
                                    if (keyBinding3 == null) {
                                        jsKeyBind = null;
                                    }
                                    else {
                                        final KeyBinding p0 = keyBinding3;
                                        final int n3 = 0;
                                        jsKeyBind = new JSKeyBind(p0);
                                    }
                                    return jsKeyBind;
                                }
                            }
                            final KeyBinding keyBinding2 = null;
                            continue;
                        }
                    }
                    return keyBind2;
                }
            }
            final KeyBind keyBind = null;
            continue;
        }
    }
    
    @NotNull
    public final Companion.currentGui getCurrentGui() {
        return JSClient.currentGui;
    }
    
    @NotNull
    public final Companion.camera getCamera() {
        return JSClient.camera;
    }
    
    static {
        INSTANCE = new JSClient();
        currentGui = Client.Companion.currentGui.INSTANCE;
        camera = Client.Companion.camera.INSTANCE;
    }
}
