//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects;

import kotlin.*;
import org.mozilla.javascript.*;
import paulscode.sound.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.*;
import net.minecraftforge.fml.relauncher.*;
import java.io.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import java.net.*;
import java.util.*;
import net.minecraft.client.audio.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011J\u001e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/Sound;", "", "config", "Lorg/mozilla/javascript/NativeObject;", "(Lorg/mozilla/javascript/NativeObject;)V", "isListening", "", "()Z", "setListening", "(Z)V", "sndSystem", "Lpaulscode/sound/SoundSystem;", "source", "", "bootstrap", "", "getPitch", "", "getVolume", "loadSndSystem", "onWorldLoad", "pause", "play", "rewind", "setAttenuation", "model", "", "setCategory", "category", "setPitch", "pitch", "setPosition", "x", "y", "z", "setVolume", "volume", "stop", "ctjs" })
public final class Sound
{
    @NotNull
    private final NativeObject config;
    @Nullable
    private SoundSystem sndSystem;
    @NotNull
    private final String source;
    private boolean isListening;
    
    public Sound(@NotNull final NativeObject config) {
        Intrinsics.checkNotNullParameter((Object)config, "config");
        this.config = config;
        final Object value = this.config.get((Object)"source");
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        this.source = (String)value;
        if (World.isLoaded()) {
            this.loadSndSystem();
            try {
                this.bootstrap();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else {
            this.isListening = true;
        }
        CTJS.INSTANCE.getSounds().add(this);
    }
    
    public final boolean isListening() {
        return this.isListening;
    }
    
    public final void setListening(final boolean <set-?>) {
        this.isListening = <set-?>;
    }
    
    public final void onWorldLoad() {
        this.isListening = false;
        this.loadSndSystem();
        try {
            this.bootstrap();
        }
        catch (MalformedURLException exc) {
            exc.printStackTrace();
        }
    }
    
    private final void loadSndSystem() {
        final SoundManager sndManager = Client.Companion.getMinecraft().getSoundHandler().sndManager;
        this.sndSystem = (SoundSystem)ReflectionHelper.getPrivateValue((Class)SoundManager.class, (Object)sndManager, new String[] { "sndSystem", "sndSystem" });
    }
    
    private final void bootstrap() throws MalformedURLException {
        final Object value = this.config.get((Object)"source");
        final String s = (value == null) ? null : value.toString();
        if (s == null) {
            throw new IllegalArgumentException("Sound source is null.");
        }
        final String source = s;
        final Object orDefault = this.config.getOrDefault((Object)"priority", (Object)false);
        if (orDefault == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean priority = (boolean)orDefault;
        final Object orDefault2 = this.config.getOrDefault((Object)"loop", (Object)false);
        if (orDefault2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean loop = (boolean)orDefault2;
        final Object orDefault3 = this.config.getOrDefault((Object)"stream", (Object)false);
        if (orDefault3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean stream = (boolean)orDefault3;
        final URL url = new File(CTJS.INSTANCE.getAssetsDir(), source).toURI().toURL();
        final Object orDefault4 = this.config.getOrDefault((Object)"x", (Object)Player.getX());
        if (orDefault4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
        }
        final float x = ((Number)orDefault4).floatValue();
        final Object orDefault5 = this.config.getOrDefault((Object)"y", (Object)Player.getY());
        if (orDefault5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
        }
        final float y = ((Number)orDefault5).floatValue();
        final Object orDefault6 = this.config.getOrDefault((Object)"z", (Object)Player.getZ());
        if (orDefault6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
        }
        final float z = ((Number)orDefault6).floatValue();
        final Object orDefault7 = this.config.getOrDefault((Object)"attenuation", (Object)1);
        if (orDefault7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
        }
        final int attModel = ((Number)orDefault7).intValue();
        final int distOrRoll = 16;
        if (stream) {
            final SoundSystem sndSystem = this.sndSystem;
            Intrinsics.checkNotNull((Object)sndSystem);
            sndSystem.newStreamingSource(priority, source, url, source, loop, x, y, z, attModel, (float)distOrRoll);
        }
        else {
            final SoundSystem sndSystem2 = this.sndSystem;
            Intrinsics.checkNotNull((Object)sndSystem2);
            sndSystem2.newSource(priority, source, url, source, loop, x, y, z, attModel, (float)distOrRoll);
        }
        if (this.config.get((Object)"volume") != null) {
            final Object value2 = this.config.get((Object)"volume");
            if (value2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
            }
            this.setVolume(((Number)value2).floatValue());
        }
        if (this.config.get((Object)"pitch") != null) {
            final Object value3 = this.config.get((Object)"pitch");
            if (value3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
            }
            this.setPitch(((Number)value3).floatValue());
        }
        if (this.config.get((Object)"category") != null) {
            final Object value4 = this.config.get((Object)"category");
            if (value4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.setCategory((String)value4);
        }
    }
    
    @NotNull
    public final Sound setCategory(@NotNull final String category) {
        Intrinsics.checkNotNullParameter((Object)category, "category");
        final Sound $this$setCategory_u24lambda_u2d0 = this;
        final int n = 0;
        final String lowerCase = category.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        final SoundCategory category2 = SoundCategory.getCategory(lowerCase);
        $this$setCategory_u24lambda_u2d0.setVolume(Client.Companion.getMinecraft().gameSettings.getSoundLevel(category2));
        return this;
    }
    
    @NotNull
    public final Sound setVolume(final float volume) {
        final Sound $this$setVolume_u24lambda_u2d1 = this;
        final int n = 0;
        final SoundSystem sndSystem = $this$setVolume_u24lambda_u2d1.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.setVolume($this$setVolume_u24lambda_u2d1.source, volume);
        return this;
    }
    
    public final float getVolume() {
        final SoundSystem sndSystem = this.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        return sndSystem.getVolume(this.source);
    }
    
    @NotNull
    public final Sound setPosition(final float x, final float y, final float z) {
        final Sound $this$setPosition_u24lambda_u2d2 = this;
        final int n = 0;
        final SoundSystem sndSystem = $this$setPosition_u24lambda_u2d2.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.setPosition($this$setPosition_u24lambda_u2d2.source, x, y, z);
        return this;
    }
    
    @NotNull
    public final Sound setPitch(final float pitch) {
        final Sound $this$setPitch_u24lambda_u2d3 = this;
        final int n = 0;
        final SoundSystem sndSystem = $this$setPitch_u24lambda_u2d3.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.setPitch($this$setPitch_u24lambda_u2d3.source, pitch);
        return this;
    }
    
    public final float getPitch() {
        final SoundSystem sndSystem = this.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        return sndSystem.getPitch(this.source);
    }
    
    @NotNull
    public final Sound setAttenuation(final int model) {
        final Sound $this$setAttenuation_u24lambda_u2d4 = this;
        final int n = 0;
        final SoundSystem sndSystem = $this$setAttenuation_u24lambda_u2d4.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.setAttenuation($this$setAttenuation_u24lambda_u2d4.source, model);
        return this;
    }
    
    public final void play() {
        final SoundSystem sndSystem = this.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.play(this.source);
    }
    
    public final void pause() {
        final SoundSystem sndSystem = this.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.pause(this.source);
    }
    
    public final void stop() {
        final SoundSystem sndSystem = this.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.stop(this.source);
    }
    
    public final void rewind() {
        final SoundSystem sndSystem = this.sndSystem;
        Intrinsics.checkNotNull((Object)sndSystem);
        sndSystem.rewind(this.source);
    }
}
