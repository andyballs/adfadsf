//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.keybind;

import kotlin.*;
import net.minecraft.client.settings.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.client.resources.*;
import net.minecraftforge.fml.client.registry.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.triggers.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.*;
import org.apache.commons.lang3.*;
import java.util.concurrent.*;
import kotlin.collections.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000 &2\u00020\u0001:\u0001&B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0005J\r\u0010\u0014\u001a\u00020\u0015H ¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\fJ\r\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u0001J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u0001J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u0001J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\fJ\b\u0010\"\u001a\u00020\u0003H\u0016J\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind;", "", "description", "", "keyCode", "", "category", "(Ljava/lang/String;ILjava/lang/String;)V", "keyBinding", "Lnet/minecraft/client/settings/KeyBinding;", "(Lnet/minecraft/client/settings/KeyBinding;)V", "down", "", "onKeyDown", "Lcom/chattriggers/ctjs/triggers/RegularTrigger;", "onKeyPress", "onKeyRelease", "getCategory", "getDescription", "getKeyCode", "getLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "getLoader$ctjs", "isKeyDown", "isPressed", "onTick", "", "onTick$ctjs", "registerKeyDown", "method", "registerKeyPress", "registerKeyRelease", "setState", "pressed", "toString", "unregisterKeyDown", "unregisterKeyPress", "unregisterKeyRelease", "Companion", "ctjs" })
public abstract class KeyBind
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final KeyBinding keyBinding;
    @Nullable
    private RegularTrigger onKeyPress;
    @Nullable
    private RegularTrigger onKeyRelease;
    @Nullable
    private RegularTrigger onKeyDown;
    private boolean down;
    @NotNull
    private static final List<KeyBinding> customKeyBindings;
    @NotNull
    private static final Map<String, Integer> uniqueCategories;
    
    @JvmOverloads
    public KeyBind(@NotNull final String description, final int keyCode, @NotNull final String category) {
        Intrinsics.checkNotNullParameter((Object)description, "description");
        Intrinsics.checkNotNullParameter((Object)category, "category");
        KeyBindHandler.INSTANCE.registerKeyBind(this);
        final KeyBinding[] keyBindings = Client.Companion.getMinecraft().gameSettings.keyBindings;
        Intrinsics.checkNotNullExpressionValue((Object)keyBindings, "Client.getMinecraft().gameSettings.keyBindings");
        final KeyBinding[] array = keyBindings;
        while (true) {
            for (int i = 0; i < array.length; ++i) {
                final KeyBinding keyBinding = array[i];
                final KeyBinding it = keyBinding;
                final int n = 0;
                if (Intrinsics.areEqual((Object)I18n.format(it.getKeyDescription(), new Object[0]), (Object)I18n.format(description, new Object[0])) && Intrinsics.areEqual((Object)I18n.format(it.getKeyCategory(), new Object[0]), (Object)I18n.format(category, new Object[0]))) {
                    final KeyBinding keyBinding2 = keyBinding;
                    final KeyBinding possibleDuplicate = keyBinding2;
                    if (possibleDuplicate != null) {
                        if (!KeyBind.customKeyBindings.contains(possibleDuplicate)) {
                            final int n2 = 0;
                            throw new IllegalArgumentException("KeyBind already exists! To get a KeyBind from an existing Minecraft KeyBinding, use the other KeyBind constructor or Client.getKeyBindFromKey.".toString());
                        }
                        this.keyBinding = possibleDuplicate;
                    }
                    else {
                        if (!KeyBinding.getKeybinds().contains(category)) {
                            KeyBind.uniqueCategories.put(category, 0);
                        }
                        final Map<String, Integer> uniqueCategories = KeyBind.uniqueCategories;
                        final Integer value = KeyBind.uniqueCategories.get(category);
                        Intrinsics.checkNotNull((Object)value);
                        uniqueCategories.put(category, value.intValue() + 1);
                        ClientRegistry.registerKeyBinding(this.keyBinding = new KeyBinding(description, keyCode, category));
                        KeyBind.customKeyBindings.add(this.keyBinding);
                    }
                    return;
                }
            }
            final KeyBinding keyBinding2 = null;
            continue;
        }
    }
    
    public KeyBind(@NotNull final KeyBinding keyBinding) {
        Intrinsics.checkNotNullParameter((Object)keyBinding, "keyBinding");
        KeyBindHandler.INSTANCE.registerKeyBind(this);
        this.keyBinding = keyBinding;
    }
    
    @Nullable
    public final RegularTrigger registerKeyPress(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final KeyBind $this$registerKeyPress_u24lambda_u2d2 = this;
        final int n = 0;
        return $this$registerKeyPress_u24lambda_u2d2.onKeyPress = new RegularTrigger(method, TriggerType.Other, $this$registerKeyPress_u24lambda_u2d2.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerKeyRelease(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final KeyBind $this$registerKeyRelease_u24lambda_u2d3 = this;
        final int n = 0;
        return $this$registerKeyRelease_u24lambda_u2d3.onKeyRelease = new RegularTrigger(method, TriggerType.Other, $this$registerKeyRelease_u24lambda_u2d3.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerKeyDown(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final KeyBind $this$registerKeyDown_u24lambda_u2d4 = this;
        final int n = 0;
        return $this$registerKeyDown_u24lambda_u2d4.onKeyDown = new RegularTrigger(method, TriggerType.Other, $this$registerKeyDown_u24lambda_u2d4.getLoader$ctjs());
    }
    
    @NotNull
    public final KeyBind unregisterKeyPress() {
        final KeyBind $this$unregisterKeyPress_u24lambda_u2d5 = this;
        final int n = 0;
        final RegularTrigger onKeyPress = $this$unregisterKeyPress_u24lambda_u2d5.onKeyPress;
        if (onKeyPress != null) {
            onKeyPress.unregister();
        }
        $this$unregisterKeyPress_u24lambda_u2d5.onKeyPress = null;
        return this;
    }
    
    @NotNull
    public final KeyBind unregisterKeyRelease() {
        final KeyBind $this$unregisterKeyRelease_u24lambda_u2d6 = this;
        final int n = 0;
        final RegularTrigger onKeyRelease = $this$unregisterKeyRelease_u24lambda_u2d6.onKeyRelease;
        if (onKeyRelease != null) {
            onKeyRelease.unregister();
        }
        $this$unregisterKeyRelease_u24lambda_u2d6.onKeyRelease = null;
        return this;
    }
    
    @NotNull
    public final KeyBind unregisterKeyDown() {
        final KeyBind $this$unregisterKeyDown_u24lambda_u2d7 = this;
        final int n = 0;
        final RegularTrigger onKeyDown = $this$unregisterKeyDown_u24lambda_u2d7.onKeyDown;
        if (onKeyDown != null) {
            onKeyDown.unregister();
        }
        $this$unregisterKeyDown_u24lambda_u2d7.onKeyDown = null;
        return this;
    }
    
    public final void onTick$ctjs() {
        if (this.isPressed()) {
            final RegularTrigger onKeyPress = this.onKeyPress;
            if (onKeyPress != null) {
                onKeyPress.trigger(new Object[0]);
            }
            this.down = true;
        }
        if (this.isKeyDown()) {
            final RegularTrigger onKeyDown = this.onKeyDown;
            if (onKeyDown != null) {
                onKeyDown.trigger(new Object[0]);
            }
            this.down = true;
        }
        if (this.down && !this.isKeyDown()) {
            final RegularTrigger onKeyRelease = this.onKeyRelease;
            if (onKeyRelease != null) {
                onKeyRelease.trigger(new Object[0]);
            }
            this.down = false;
        }
    }
    
    public final boolean isKeyDown() {
        return this.keyBinding.isKeyDown();
    }
    
    public final boolean isPressed() {
        return this.keyBinding.isPressed();
    }
    
    @NotNull
    public final String getDescription() {
        final String getKeyDescription = this.keyBinding.getKeyDescription();
        Intrinsics.checkNotNullExpressionValue((Object)getKeyDescription, "keyBinding.keyDescription");
        return getKeyDescription;
    }
    
    public final int getKeyCode() {
        return this.keyBinding.getKeyCode();
    }
    
    @NotNull
    public final String getCategory() {
        final String getKeyCategory = this.keyBinding.getKeyCategory();
        Intrinsics.checkNotNullExpressionValue((Object)getKeyCategory, "keyBinding.keyCategory");
        return getKeyCategory;
    }
    
    public final void setState(final boolean pressed) {
        KeyBinding.setKeyBindState(this.keyBinding.getKeyCode(), pressed);
    }
    
    @NotNull
    public abstract ILoader getLoader$ctjs();
    
    @NotNull
    @Override
    public String toString() {
        return "KeyBind{description=" + this.getDescription() + ", keyCode=" + this.getKeyCode() + ", category=" + this.getCategory() + '}';
    }
    
    @JvmOverloads
    public KeyBind(@NotNull final String description, final int keyCode) {
        Intrinsics.checkNotNullParameter((Object)description, "description");
        this(description, keyCode, null, 4, null);
    }
    
    @JvmStatic
    public static final void removeKeyBind(@NotNull final KeyBind keyBind) {
        KeyBind.Companion.removeKeyBind(keyBind);
    }
    
    @JvmStatic
    public static final void clearKeyBinds() {
        KeyBind.Companion.clearKeyBinds();
    }
    
    public static final /* synthetic */ Map access$getUniqueCategories$cp() {
        return KeyBind.uniqueCategories;
    }
    
    public static final /* synthetic */ KeyBinding access$getKeyBinding$p(final KeyBind $this) {
        return $this.keyBinding;
    }
    
    public static final /* synthetic */ List access$getCustomKeyBindings$cp() {
        return KeyBind.customKeyBindings;
    }
    
    static {
        Companion = new Companion(null);
        customKeyBindings = new ArrayList<KeyBinding>();
        uniqueCategories = new LinkedHashMap<String, Integer>();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind$Companion;", "", "()V", "customKeyBindings", "", "Lnet/minecraft/client/settings/KeyBinding;", "uniqueCategories", "", "", "", "clearKeyBinds", "", "removeKeyBind", "keyBind", "Lcom/chattriggers/ctjs/minecraft/objects/keybind/KeyBind;", "removeKeyBinding", "keyBinding", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        private final void removeKeyBinding(final KeyBinding keyBinding) {
            Client.Companion.getMinecraft().gameSettings.keyBindings = (KeyBinding[])ArrayUtils.removeElement((Object[])Client.Companion.getMinecraft().gameSettings.keyBindings, (Object)keyBinding);
            final String category = keyBinding.getKeyCategory();
            if (KeyBind.access$getUniqueCategories$cp().containsKey(category)) {
                final Map access$getUniqueCategories$cp = KeyBind.access$getUniqueCategories$cp();
                Intrinsics.checkNotNullExpressionValue((Object)category, "category");
                final String s = category;
                final Number value = KeyBind.access$getUniqueCategories$cp().get(category);
                Intrinsics.checkNotNull((Object)value);
                access$getUniqueCategories$cp.put(s, value.intValue() - 1);
                final Integer n = KeyBind.access$getUniqueCategories$cp().get(category);
                if (n != null) {
                    if (n == 0) {
                        KeyBind.access$getUniqueCategories$cp().remove(category);
                        KeyBinding.getKeybinds().remove(category);
                    }
                }
            }
        }
        
        @JvmStatic
        public final void removeKeyBind(@NotNull final KeyBind keyBind) {
            Intrinsics.checkNotNullParameter((Object)keyBind, "keyBind");
            final KeyBinding keyBinding = KeyBind.access$getKeyBinding$p(keyBind);
            if (!KeyBind.access$getCustomKeyBindings$cp().contains(keyBinding)) {
                return;
            }
            this.removeKeyBinding(keyBinding);
            KeyBind.access$getCustomKeyBindings$cp().remove(keyBinding);
            KeyBindHandler.INSTANCE.unregisterKeyBind(keyBind);
        }
        
        @JvmStatic
        public final void clearKeyBinds() {
            final List copy = CollectionsKt.toList((Iterable)KeyBindHandler.INSTANCE.getKeyBinds());
            final Iterable $this$forEach$iv = copy;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final KeyBind p0 = (KeyBind)element$iv;
                final int n = 0;
                this.removeKeyBind(p0);
            }
            KeyBind.access$getCustomKeyBindings$cp().clear();
            KeyBindHandler.INSTANCE.clearKeyBinds();
        }
    }
}
