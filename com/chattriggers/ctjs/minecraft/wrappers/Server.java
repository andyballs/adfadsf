//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.multiplayer.*;
import kotlin.jvm.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.network.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Server;", "", "()V", "getIP", "", "getMOTD", "getName", "getPing", "", "ctjs" })
public final class Server
{
    @NotNull
    public static final Server INSTANCE;
    
    private Server() {
    }
    
    @JvmStatic
    @NotNull
    public static final String getIP() {
        if (Client.Companion.getMinecraft().isSingleplayer()) {
            return "localhost";
        }
        final ServerData getCurrentServerData = Client.Companion.getMinecraft().getCurrentServerData();
        String serverIP;
        if (getCurrentServerData == null) {
            serverIP = "";
        }
        else if ((serverIP = getCurrentServerData.serverIP) == null) {
            serverIP = "";
        }
        return serverIP;
    }
    
    @JvmStatic
    @NotNull
    public static final String getName() {
        if (Client.Companion.getMinecraft().isSingleplayer()) {
            return "SinglePlayer";
        }
        final ServerData getCurrentServerData = Client.Companion.getMinecraft().getCurrentServerData();
        String serverName;
        if (getCurrentServerData == null) {
            serverName = "";
        }
        else if ((serverName = getCurrentServerData.serverName) == null) {
            serverName = "";
        }
        return serverName;
    }
    
    @JvmStatic
    @NotNull
    public static final String getMOTD() {
        if (Client.Companion.getMinecraft().isSingleplayer()) {
            return "SinglePlayer";
        }
        final ServerData getCurrentServerData = Client.Companion.getMinecraft().getCurrentServerData();
        String serverMOTD;
        if (getCurrentServerData == null) {
            serverMOTD = "";
        }
        else if ((serverMOTD = getCurrentServerData.serverMOTD) == null) {
            serverMOTD = "";
        }
        return serverMOTD;
    }
    
    @JvmStatic
    public static final long getPing() {
        final EntityPlayerSP player = Player.getPlayer();
        if (player == null || Client.Companion.getMinecraft().isSingleplayer() || Client.Companion.getMinecraft().getCurrentServerData() == null) {
            return 5L;
        }
        final NetHandlerPlayClient connection = Client.Companion.getConnection();
        Long n2;
        Long n;
        if (connection == null) {
            n = (n2 = null);
        }
        else {
            final NetworkPlayerInfo getPlayerInfo = connection.getPlayerInfo(player.getUniqueID());
            n = (n2 = ((getPlayerInfo == null) ? null : Long.valueOf(getPlayerInfo.getResponseTime())));
        }
        long longValue;
        if (n2 == null) {
            final ServerData getCurrentServerData = Client.Companion.getMinecraft().getCurrentServerData();
            longValue = ((getCurrentServerData == null) ? -1L : getCurrentServerData.pingToServer);
        }
        else {
            longValue = n;
        }
        return longValue;
    }
    
    static {
        INSTANCE = new Server();
    }
}
