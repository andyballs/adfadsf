//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.entity;

import kotlin.*;
import net.minecraft.scoreboard.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import java.util.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Team;", "", "team", "Lnet/minecraft/scoreboard/ScorePlayerTeam;", "(Lnet/minecraft/scoreboard/ScorePlayerTeam;)V", "getTeam", "()Lnet/minecraft/scoreboard/ScorePlayerTeam;", "canSeeInvisibleTeammates", "", "getDeathMessageVisibility", "", "getFriendlyFire", "getMembers", "", "getName", "getNameTagVisibility", "getPrefix", "getRegisteredName", "getSuffix", "setName", "name", "setPrefix", "prefix", "setSuffix", "suffix", "ctjs" })
public final class Team
{
    @NotNull
    private final ScorePlayerTeam team;
    
    public Team(@NotNull final ScorePlayerTeam team) {
        Intrinsics.checkNotNullParameter((Object)team, "team");
        this.team = team;
    }
    
    @NotNull
    public final ScorePlayerTeam getTeam() {
        return this.team;
    }
    
    @NotNull
    public final String getRegisteredName() {
        final String getRegisteredName = this.team.getRegisteredName();
        Intrinsics.checkNotNullExpressionValue((Object)getRegisteredName, "team.registeredName");
        return getRegisteredName;
    }
    
    @NotNull
    public final String getName() {
        final String getTeamName = this.team.getTeamName();
        Intrinsics.checkNotNullExpressionValue((Object)getTeamName, "team.teamName");
        return getTeamName;
    }
    
    @NotNull
    public final Team setName(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final Team $this$setName_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setName_u24lambda_u2d0.getTeam().setTeamName(ChatLib.addColor(name));
        return this;
    }
    
    @NotNull
    public final List<String> getMembers() {
        final Collection getMembershipCollection = this.team.getMembershipCollection();
        Intrinsics.checkNotNullExpressionValue((Object)getMembershipCollection, "team.membershipCollection");
        return (List<String>)CollectionsKt.toList((Iterable)getMembershipCollection);
    }
    
    @NotNull
    public final String getPrefix() {
        final String getColorPrefix = this.team.getColorPrefix();
        Intrinsics.checkNotNullExpressionValue((Object)getColorPrefix, "team.colorPrefix");
        return getColorPrefix;
    }
    
    @NotNull
    public final Team setPrefix(@NotNull final String prefix) {
        Intrinsics.checkNotNullParameter((Object)prefix, "prefix");
        final Team $this$setPrefix_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setPrefix_u24lambda_u2d1.getTeam().setNamePrefix(ChatLib.addColor(prefix));
        return this;
    }
    
    @NotNull
    public final String getSuffix() {
        final String getColorSuffix = this.team.getColorSuffix();
        Intrinsics.checkNotNullExpressionValue((Object)getColorSuffix, "team.colorSuffix");
        return getColorSuffix;
    }
    
    @NotNull
    public final Team setSuffix(@NotNull final String suffix) {
        Intrinsics.checkNotNullParameter((Object)suffix, "suffix");
        final Team $this$setSuffix_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setSuffix_u24lambda_u2d2.getTeam().setNameSuffix(ChatLib.addColor(suffix));
        return this;
    }
    
    public final boolean getFriendlyFire() {
        return this.team.getAllowFriendlyFire();
    }
    
    public final boolean canSeeInvisibleTeammates() {
        return this.team.getSeeFriendlyInvisiblesEnabled();
    }
    
    @NotNull
    public final String getNameTagVisibility() {
        final String internalName = this.team.getNameTagVisibility().internalName;
        Intrinsics.checkNotNullExpressionValue((Object)internalName, "team.nameTagVisibility.internalName");
        return internalName;
    }
    
    @NotNull
    public final String getDeathMessageVisibility() {
        final String internalName = this.team.getDeathMessageVisibility().internalName;
        Intrinsics.checkNotNullExpressionValue((Object)internalName, "team.deathMessageVisibility.internalName");
        return internalName;
    }
}
