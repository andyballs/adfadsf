//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.entity;

import kotlin.*;
import net.minecraft.entity.player.*;
import java.lang.reflect.*;
import net.minecraft.scoreboard.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import kotlin.jvm.*;
import net.minecraft.util.*;
import com.mojang.authlib.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.client.network.*;
import kotlin.jvm.internal.*;
import net.minecraftforge.fml.relauncher.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\\\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\nJ\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014J\b\u0010#\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006%" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/EntityLivingBase;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "draw", "", "x", "", "y", "rotate", "", "showNametag", "showArmor", "showCape", "showHeldItem", "showArrows", "getDisplayName", "Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;", "getName", "", "getPing", "getPlayerInfo", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "getPlayerName", "networkPlayerInfoIn", "getTeam", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Team;", "isSpectator", "setNametagName", "", "textComponent", "setTabDisplayName", "toString", "Companion", "ctjs" })
public final class PlayerMP extends EntityLivingBase
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final EntityPlayer player;
    private static final Field displayNameField;
    
    public PlayerMP(@NotNull final EntityPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, "player");
        super((net.minecraft.entity.EntityLivingBase)player);
        this.player = player;
    }
    
    @NotNull
    public final EntityPlayer getPlayer() {
        return this.player;
    }
    
    public final boolean isSpectator() {
        return this.player.isSpectator();
    }
    
    public final int getPing() {
        final NetworkPlayerInfo playerInfo = this.getPlayerInfo();
        return (playerInfo == null) ? -1 : playerInfo.getResponseTime();
    }
    
    @Nullable
    public final Team getTeam() {
        final NetworkPlayerInfo playerInfo = this.getPlayerInfo();
        Team team;
        if (playerInfo == null) {
            team = null;
        }
        else {
            final ScorePlayerTeam getPlayerTeam = playerInfo.getPlayerTeam();
            if (getPlayerTeam == null) {
                team = null;
            }
            else {
                final ScorePlayerTeam p0 = getPlayerTeam;
                final int n = 0;
                team = new Team(p0);
            }
        }
        return team;
    }
    
    @NotNull
    public final TextComponent getDisplayName() {
        return new TextComponent(this.getPlayerName(this.getPlayerInfo()));
    }
    
    public final void setTabDisplayName(@NotNull final TextComponent textComponent) {
        Intrinsics.checkNotNullParameter((Object)textComponent, "textComponent");
        final NetworkPlayerInfo playerInfo = this.getPlayerInfo();
        if (playerInfo != null) {
            playerInfo.setDisplayName(textComponent.getChatComponentText());
        }
    }
    
    public final void setNametagName(@NotNull final TextComponent textComponent) {
        Intrinsics.checkNotNullParameter((Object)textComponent, "textComponent");
        PlayerMP.displayNameField.set(this.player, textComponent.getChatComponentText().getFormattedText());
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem, final boolean showArrows) {
        Intrinsics.checkNotNullParameter(player, "player");
        final PlayerMP $this$draw_u24lambda_u2d0 = this;
        final int n = 0;
        Renderer.drawPlayer(player, x, y, rotate, showNametag, showArmor, showCape, showHeldItem, showArrows);
        return this;
    }
    
    public static /* synthetic */ PlayerMP draw$default(final PlayerMP playerMP, final Object player, final int x, final int y, boolean rotate, boolean showNametag, boolean showArmor, boolean showCape, boolean showHeldItem, boolean showArrows, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            rotate = false;
        }
        if ((n & 0x10) != 0x0) {
            showNametag = false;
        }
        if ((n & 0x20) != 0x0) {
            showArmor = true;
        }
        if ((n & 0x40) != 0x0) {
            showCape = true;
        }
        if ((n & 0x80) != 0x0) {
            showHeldItem = true;
        }
        if ((n & 0x100) != 0x0) {
            showArrows = true;
        }
        return playerMP.draw(player, x, y, rotate, showNametag, showArmor, showCape, showHeldItem, showArrows);
    }
    
    private final String getPlayerName(final NetworkPlayerInfo networkPlayerInfoIn) {
        String s;
        if (networkPlayerInfoIn == null) {
            s = null;
        }
        else {
            final IChatComponent getDisplayName = networkPlayerInfoIn.getDisplayName();
            s = ((getDisplayName == null) ? null : getDisplayName.getFormattedText());
        }
        final String s2 = s;
        String formatPlayerName;
        if (s2 == null) {
            final net.minecraft.scoreboard.Team team = (net.minecraft.scoreboard.Team)((networkPlayerInfoIn == null) ? null : networkPlayerInfoIn.getPlayerTeam());
            String s3;
            if (networkPlayerInfoIn == null) {
                s3 = null;
            }
            else {
                final GameProfile getGameProfile = networkPlayerInfoIn.getGameProfile();
                s3 = ((getGameProfile == null) ? null : getGameProfile.getName());
            }
            formatPlayerName = ScorePlayerTeam.formatPlayerName(team, s3);
        }
        else {
            formatPlayerName = s2;
        }
        final String s4 = formatPlayerName;
        return (s4 == null) ? "" : s4;
    }
    
    private final NetworkPlayerInfo getPlayerInfo() {
        final NetHandlerPlayClient connection = Client.Companion.getConnection();
        return (connection == null) ? null : connection.getPlayerInfo(this.player.getUniqueID());
    }
    
    @NotNull
    public String toString() {
        return "PlayerMP{name=" + this.getName() + ", ping=" + this.getPing() + ", entityLivingBase=" + super.toString() + '}';
    }
    
    @NotNull
    public String getName() {
        final String getName = this.player.getName();
        Intrinsics.checkNotNullExpressionValue((Object)getName, "player.name");
        return getName;
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem) {
        Intrinsics.checkNotNullParameter(player, "player");
        return draw$default(this, player, x, y, rotate, showNametag, showArmor, showCape, showHeldItem, false, 256, null);
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape) {
        Intrinsics.checkNotNullParameter(player, "player");
        return draw$default(this, player, x, y, rotate, showNametag, showArmor, showCape, false, false, 384, null);
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor) {
        Intrinsics.checkNotNullParameter(player, "player");
        return draw$default(this, player, x, y, rotate, showNametag, showArmor, false, false, false, 448, null);
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag) {
        Intrinsics.checkNotNullParameter(player, "player");
        return draw$default(this, player, x, y, rotate, showNametag, false, false, false, false, 480, null);
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y, final boolean rotate) {
        Intrinsics.checkNotNullParameter(player, "player");
        return draw$default(this, player, x, y, rotate, false, false, false, false, false, 496, null);
    }
    
    @JvmOverloads
    @NotNull
    public final PlayerMP draw(@NotNull final Object player, final int x, final int y) {
        Intrinsics.checkNotNullParameter(player, "player");
        return draw$default(this, player, x, y, false, false, false, false, false, false, 504, null);
    }
    
    static {
        Companion = new Companion(null);
        displayNameField = ReflectionHelper.findField((Class)EntityPlayer.class, new String[] { "displayname" });
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP$Companion;", "", "()V", "displayNameField", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
