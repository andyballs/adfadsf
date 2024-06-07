//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.settings.*;
import net.minecraft.world.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0005R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0018" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Settings;", "", "()V", "chat", "getChat", "()Ljava/lang/Object;", "skin", "getSkin", "sound", "getSound", "video", "getVideo", "getDifficulty", "", "getFOV", "", "getSettings", "Lnet/minecraft/client/settings/GameSettings;", "kotlin.jvm.PlatformType", "setDifficulty", "", "difficulty", "setFOV", "fov", "ctjs" })
public final class Settings
{
    @NotNull
    private final Object skin;
    @NotNull
    private final Object sound;
    @NotNull
    private final Object video;
    @NotNull
    private final Object chat;
    
    public Settings() {
        this.skin = new Settings$skin.Settings$skin$1(this);
        this.sound = new Settings$sound.Settings$sound$1(this);
        this.video = new Settings$video.Settings$video$1(this);
        this.chat = new Settings$chat.Settings$chat$1(this);
    }
    
    public final GameSettings getSettings() {
        return Client.Companion.getMinecraft().gameSettings;
    }
    
    public final float getFOV() {
        return this.getSettings().fovSetting;
    }
    
    public final void setFOV(final float fov) {
        this.getSettings().fovSetting = fov;
    }
    
    public final int getDifficulty() {
        return this.getSettings().difficulty.getDifficultyId();
    }
    
    public final void setDifficulty(final int difficulty) {
        this.getSettings().difficulty = EnumDifficulty.getDifficultyEnum(difficulty);
    }
    
    @NotNull
    public final Object getSkin() {
        return this.skin;
    }
    
    @NotNull
    public final Object getSound() {
        return this.sound;
    }
    
    @NotNull
    public final Object getVideo() {
        return this.video;
    }
    
    @NotNull
    public final Object getChat() {
        return this.chat;
    }
}
