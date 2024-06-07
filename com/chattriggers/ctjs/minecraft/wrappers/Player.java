//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import net.minecraft.client.entity.*;
import org.jetbrains.annotations.*;
import net.minecraft.scoreboard.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.*;
import net.minecraft.block.*;
import com.chattriggers.ctjs.minecraft.wrappers.world.block.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import kotlin.*;
import net.minecraft.inventory.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import kotlin.jvm.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001LB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007JT\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007J\b\u0010\u0015\u001a\u00020\u0007H\u0007J\b\u0010\u0016\u001a\u00020\u0007H\u0007J\b\u0010\u0017\u001a\u00020\u0011H\u0007J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\b\u0010 \u001a\u00020\u0007H\u0007J\b\u0010!\u001a\u00020\u0007H\u0007J\n\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020$H\u0007J\b\u0010&\u001a\u00020$H\u0007J\b\u0010'\u001a\u00020\u0007H\u0007J\b\u0010(\u001a\u00020$H\u0007J\b\u0010)\u001a\u00020$H\u0007J\b\u0010*\u001a\u00020$H\u0007J\b\u0010+\u001a\u00020\u0011H\u0007J\n\u0010,\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010-\u001a\u00020\u001dH\u0007J\n\u0010.\u001a\u0004\u0018\u00010/H\u0007J\b\u00100\u001a\u00020\u001dH\u0007J\b\u00101\u001a\u00020$H\u0007J\b\u00102\u001a\u00020$H\u0007J\b\u00103\u001a\u00020$H\u0007J\b\u00104\u001a\u00020\u001dH\u0007J\n\u00105\u001a\u0004\u0018\u000106H\u0007J\b\u00107\u001a\u00020\u0011H\u0007J\b\u00108\u001a\u000209H\u0007J\b\u0010:\u001a\u00020$H\u0007J\b\u0010;\u001a\u00020\u0007H\u0007J\b\u0010<\u001a\u00020\u001dH\u0007J\b\u0010=\u001a\u00020$H\u0007J\b\u0010>\u001a\u00020\u001dH\u0007J\b\u0010?\u001a\u00020$H\u0007J\b\u0010@\u001a\u00020\nH\u0007J\b\u0010A\u001a\u00020\nH\u0007J\b\u0010B\u001a\u00020\nH\u0007J\b\u0010C\u001a\u00020\nH\u0007J\b\u0010D\u001a\u00020\nH\u0007J\b\u0010E\u001a\u00020\u0001H\u0007J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0007H\u0007J\u0010\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u00020\u001bH\u0007J\u0010\u0010K\u001a\u00020G2\u0006\u0010J\u001a\u00020\u001bH\u0007¨\u0006M" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Player;", "", "()V", "asPlayerMP", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/PlayerMP;", "draw", "x", "", "y", "rotate", "", "showNametag", "showArmor", "showCape", "showHeldItem", "showArrows", "facing", "", "getActivePotionEffects", "", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;", "getAirLevel", "getArmorPoints", "getBiome", "getContainer", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Inventory;", "getDisplayName", "Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;", "getHP", "", "getHeldItem", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "getHeldItemIndex", "getHunger", "getInventory", "getLastX", "", "getLastY", "getLastZ", "getLightLevel", "getMotionX", "getMotionY", "getMotionZ", "getName", "getOpenedInventory", "getPitch", "getPlayer", "Lnet/minecraft/client/entity/EntityPlayerSP;", "getRawYaw", "getRenderX", "getRenderY", "getRenderZ", "getSaturation", "getTeam", "Lcom/chattriggers/ctjs/minecraft/wrappers/entity/Team;", "getUUID", "getUUIDObj", "Ljava/util/UUID;", "getX", "getXPLevel", "getXPProgress", "getY", "getYaw", "getZ", "isFlying", "isMoving", "isSleeping", "isSneaking", "isSprinting", "lookingAt", "setHeldItemIndex", "", "index", "setNametagName", "textComponent", "setTabDisplayName", "armor", "ctjs" })
public final class Player
{
    @NotNull
    public static final Player INSTANCE;
    
    private Player() {
    }
    
    @JvmStatic
    @Nullable
    public static final EntityPlayerSP getPlayer() {
        return Client.Companion.getMinecraft().thePlayer;
    }
    
    @JvmStatic
    @Nullable
    public static final Team getTeam() {
        final net.minecraft.scoreboard.Scoreboard scoreboard = Scoreboard.getScoreboard();
        Team team;
        if (scoreboard == null) {
            team = null;
        }
        else {
            final Player instance = Player.INSTANCE;
            final ScorePlayerTeam getPlayersTeam = scoreboard.getPlayersTeam(getName());
            if (getPlayersTeam == null) {
                team = null;
            }
            else {
                final ScorePlayerTeam p0 = getPlayersTeam;
                final int n = 0;
                team = new Team(p0);
            }
        }
        return team;
    }
    
    @JvmStatic
    @Nullable
    public static final PlayerMP asPlayerMP() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        PlayerMP playerMP;
        if (player == null) {
            playerMP = null;
        }
        else {
            final EntityPlayer p0 = (EntityPlayer)player;
            final int n = 0;
            playerMP = new PlayerMP(p0);
        }
        return playerMP;
    }
    
    @JvmStatic
    public static final double getX() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.posX;
    }
    
    @JvmStatic
    public static final double getY() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.posY;
    }
    
    @JvmStatic
    public static final double getZ() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.posZ;
    }
    
    @JvmStatic
    public static final double getLastX() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.lastTickPosX;
    }
    
    @JvmStatic
    public static final double getLastY() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.lastTickPosY;
    }
    
    @JvmStatic
    public static final double getLastZ() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.lastTickPosZ;
    }
    
    @JvmStatic
    public static final double getRenderX() {
        final Player instance = Player.INSTANCE;
        final double lastX = getLastX();
        final Player instance2 = Player.INSTANCE;
        final double x = getX();
        final Player instance3 = Player.INSTANCE;
        return lastX + (x - getLastX()) * Tessellator.getPartialTicks();
    }
    
    @JvmStatic
    public static final double getRenderY() {
        final Player instance = Player.INSTANCE;
        final double lastY = getLastY();
        final Player instance2 = Player.INSTANCE;
        final double y = getY();
        final Player instance3 = Player.INSTANCE;
        return lastY + (y - getLastY()) * Tessellator.getPartialTicks();
    }
    
    @JvmStatic
    public static final double getRenderZ() {
        final Player instance = Player.INSTANCE;
        final double lastZ = getLastZ();
        final Player instance2 = Player.INSTANCE;
        final double z = getZ();
        final Player instance3 = Player.INSTANCE;
        return lastZ + (z - getLastZ()) * Tessellator.getPartialTicks();
    }
    
    @JvmStatic
    public static final double getMotionX() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.motionX;
    }
    
    @JvmStatic
    public static final double getMotionY() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.motionY;
    }
    
    @JvmStatic
    public static final double getMotionZ() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0 : player.motionZ;
    }
    
    @JvmStatic
    public static final float getPitch() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return MathHelper.wrapAngleTo180_float((player == null) ? 0.0f : player.rotationPitch);
    }
    
    @JvmStatic
    public static final float getYaw() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return MathHelper.wrapAngleTo180_float((player == null) ? 0.0f : player.rotationYaw);
    }
    
    @JvmStatic
    public static final float getRawYaw() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0f : player.rotationYaw;
    }
    
    @JvmStatic
    @NotNull
    public static final String getName() {
        final String getUsername = Client.Companion.getMinecraft().getSession().getUsername();
        Intrinsics.checkNotNullExpressionValue((Object)getUsername, "Client.getMinecraft().session.username");
        return getUsername;
    }
    
    @JvmStatic
    @NotNull
    public static final String getUUID() {
        final Player instance = Player.INSTANCE;
        final String string = getUUIDObj().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "getUUIDObj().toString()");
        return string;
    }
    
    @JvmStatic
    @NotNull
    public static final UUID getUUIDObj() {
        final UUID id = Client.Companion.getMinecraft().getSession().getProfile().getId();
        Intrinsics.checkNotNullExpressionValue((Object)id, "Client.getMinecraft().session.profile.id");
        return id;
    }
    
    @JvmStatic
    public static final float getHP() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0f : player.getHealth();
    }
    
    @JvmStatic
    public static final int getHunger() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        int n;
        if (player == null) {
            n = 0;
        }
        else {
            final FoodStats getFoodStats = player.getFoodStats();
            n = ((getFoodStats == null) ? 0 : getFoodStats.getFoodLevel());
        }
        return n;
    }
    
    @JvmStatic
    public static final float getSaturation() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        float n;
        if (player == null) {
            n = 0.0f;
        }
        else {
            final FoodStats getFoodStats = player.getFoodStats();
            n = ((getFoodStats == null) ? 0.0f : getFoodStats.getSaturationLevel());
        }
        return n;
    }
    
    @JvmStatic
    public static final int getArmorPoints() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0 : player.getTotalArmorValue();
    }
    
    @JvmStatic
    public static final int getAirLevel() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0 : player.getAir();
    }
    
    @JvmStatic
    public static final int getXPLevel() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0 : player.experienceLevel;
    }
    
    @JvmStatic
    public static final float getXPProgress() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return (player == null) ? 0.0f : player.experience;
    }
    
    @JvmStatic
    @NotNull
    public static final String getBiome() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player2 = getPlayer();
        if (player2 == null) {
            return "";
        }
        final EntityPlayerSP player = player2;
        final WorldClient world2 = World.getWorld();
        if (world2 == null) {
            return "";
        }
        final WorldClient world = world2;
        final Chunk chunk = world.getChunkFromBlockCoords(player.getPosition());
        final BiomeGenBase biome = chunk.getBiome(player.getPosition(), world.getWorldChunkManager());
        final String biomeName = biome.biomeName;
        Intrinsics.checkNotNullExpressionValue((Object)biomeName, "biome.biomeName");
        return biomeName;
    }
    
    @JvmStatic
    public static final int getLightLevel() {
        final WorldClient world = World.getWorld();
        int getLight;
        if (world == null) {
            getLight = 0;
        }
        else {
            final Player instance = Player.INSTANCE;
            final EntityPlayerSP player = getPlayer();
            getLight = world.getLight((player == null) ? null : player.getPosition());
        }
        return getLight;
    }
    
    @JvmStatic
    public static final boolean isMoving() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        boolean b;
        if (player == null) {
            b = false;
        }
        else {
            final MovementInput movementInput = player.movementInput;
            if (movementInput == null) {
                b = false;
            }
            else {
                final MovementInput it = movementInput;
                final int n = 0;
                b = (it.moveForward != 0.0f || it.moveStrafe != 0.0f);
            }
        }
        return b;
    }
    
    @JvmStatic
    public static final boolean isSneaking() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return player != null && player.isSneaking();
    }
    
    @JvmStatic
    public static final boolean isSprinting() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return player != null && player.isSprinting();
    }
    
    @JvmStatic
    public static final boolean isFlying() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return player != null && !player.isPushedByWater();
    }
    
    @JvmStatic
    public static final boolean isSleeping() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        return player != null && player.isPlayerSleeping();
    }
    
    @JvmStatic
    @NotNull
    public static final String facing() {
        final Player instance = Player.INSTANCE;
        if (getPlayer() == null) {
            return "";
        }
        final Player instance2 = Player.INSTANCE;
        final float yaw = getYaw();
        final double n = yaw;
        String s;
        if (-22.5 <= n && n <= 22.5) {
            s = "South";
        }
        else {
            final double n2 = yaw;
            if (22.5 <= n2 && n2 <= 67.5) {
                s = "South West";
            }
            else {
                final double n3 = yaw;
                if (67.5 <= n3 && n3 <= 112.5) {
                    s = "West";
                }
                else {
                    final double n4 = yaw;
                    if (112.5 <= n4 && n4 <= 157.5) {
                        s = "North West";
                    }
                    else if (yaw < -157.5 || yaw > 157.5) {
                        s = "North";
                    }
                    else {
                        final double n5 = yaw;
                        if (-157.5 <= n5 && n5 <= -112.5) {
                            s = "North East";
                        }
                        else {
                            final double n6 = yaw;
                            if (-112.5 <= n6 && n6 <= -67.5) {
                                s = "East";
                            }
                            else {
                                final double n7 = yaw;
                                s = ((-67.5 <= n7 && n7 <= -22.5) ? "South East" : "");
                            }
                        }
                    }
                }
            }
        }
        return s;
    }
    
    @JvmStatic
    @NotNull
    public static final List<PotionEffect> getActivePotionEffects() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: pop            
        //     4: invokestatic    com/chattriggers/ctjs/minecraft/wrappers/Player.getPlayer:()Lnet/minecraft/client/entity/EntityPlayerSP;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ifnonnull       16
        //    12: aconst_null    
        //    13: goto            131
        //    16: aload_1        
        //    17: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffects:()Ljava/util/Collection;
        //    20: astore_2       
        //    21: aload_2        
        //    22: ifnonnull       29
        //    25: aconst_null    
        //    26: goto            131
        //    29: aload_2        
        //    30: checkcast       Ljava/lang/Iterable;
        //    33: astore_3       
        //    34: nop            
        //    35: iconst_0       
        //    36: istore          $i$f$map
        //    38: aload_3         /* $this$map$iv */
        //    39: astore          5
        //    41: new             Ljava/util/ArrayList;
        //    44: dup            
        //    45: aload_3         /* $this$map$iv */
        //    46: bipush          10
        //    48: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    51: invokespecial   java/util/ArrayList.<init>:(I)V
        //    54: checkcast       Ljava/util/Collection;
        //    57: astore          destination$iv$iv
        //    59: iconst_0       
        //    60: istore          $i$f$mapTo
        //    62: aload           $this$mapTo$iv$iv
        //    64: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    69: astore          8
        //    71: aload           8
        //    73: invokeinterface java/util/Iterator.hasNext:()Z
        //    78: ifeq            125
        //    81: aload           8
        //    83: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    88: astore          item$iv$iv
        //    90: aload           destination$iv$iv
        //    92: aload           item$iv$iv
        //    94: checkcast       Lnet/minecraft/potion/PotionEffect;
        //    97: astore          10
        //    99: astore          12
        //   101: iconst_0       
        //   102: istore          $i$a$-map-Player$getActivePotionEffects$1
        //   104: new             Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;
        //   107: dup            
        //   108: aload           p0
        //   110: invokespecial   com/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect.<init>:(Lnet/minecraft/potion/PotionEffect;)V
        //   113: aload           12
        //   115: swap           
        //   116: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   121: pop            
        //   122: goto            71
        //   125: aload           destination$iv$iv
        //   127: checkcast       Ljava/util/List;
        //   130: nop            
        //   131: astore_0       
        //   132: aload_0        
        //   133: ifnonnull       142
        //   136: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   139: goto            143
        //   142: aload_0        
        //   143: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/wrappers/world/PotionEffect;>;
        //    StackMapTable: 00 07 FD 00 10 00 07 00 98 FC 00 0C 07 01 96 FF 00 29 00 09 00 07 00 98 07 01 96 07 01 98 01 07 01 98 07 01 96 01 07 01 A9 00 00 35 FF 00 05 00 02 00 07 00 98 00 01 07 01 BD FF 00 0A 00 02 07 01 BD 07 00 98 00 00 40 07 01 BD
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Cannot read field "references" because "newVariable" is null
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
        //     at java.base/java.lang.Thread.run(Thread.java:842)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @JvmStatic
    @NotNull
    public static final Object lookingAt() {
        final MovingObjectPosition objectMouseOver = Client.Companion.getMinecraft().objectMouseOver;
        if (objectMouseOver == null) {
            return new BlockType(0);
        }
        final MovingObjectPosition mop = objectMouseOver;
        final WorldClient world2 = World.getWorld();
        if (world2 == null) {
            return new BlockType(0);
        }
        final WorldClient world = world2;
        final MovingObjectPosition$MovingObjectType typeOfHit = mop.typeOfHit;
        Object o = null;
        switch ((typeOfHit == null) ? -1 : WhenMappings.$EnumSwitchMapping$0[typeOfHit.ordinal()]) {
            case 1: {
                final net.minecraft.block.Block getBlock = world.getBlockState(mop.getBlockPos()).getBlock();
                Intrinsics.checkNotNullExpressionValue((Object)getBlock, "world.getBlockState(mop.blockPos).block");
                final BlockType type = new BlockType(getBlock);
                final net.minecraft.util.BlockPos getBlockPos = mop.getBlockPos();
                Intrinsics.checkNotNullExpressionValue((Object)getBlockPos, "mop.blockPos");
                final BlockPos pos = new BlockPos(getBlockPos);
                final BlockFace.Companion companion = BlockFace.Companion;
                final EnumFacing sideHit = mop.sideHit;
                Intrinsics.checkNotNullExpressionValue((Object)sideHit, "mop.sideHit");
                final Block block = new Block(type, pos, companion.fromMCEnumFacing(sideHit));
                o = ((block.getType().getMcBlock() instanceof BlockSign) ? ((Sign)new Sign(block)) : block);
                break;
            }
            case 2: {
                final net.minecraft.entity.Entity entityHit;
                o = new Entity(entityHit);
                entityHit = mop.entityHit;
                Intrinsics.checkNotNullExpressionValue((Object)entityHit, "mop.entityHit");
                break;
            }
            default: {
                o = new BlockType(0);
                break;
            }
        }
        return o;
    }
    
    @JvmStatic
    @Nullable
    public static final Item getHeldItem() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        Item item;
        if (player == null) {
            item = null;
        }
        else {
            final InventoryPlayer inventory = player.inventory;
            if (inventory == null) {
                item = null;
            }
            else {
                final ItemStack getCurrentItem = inventory.getCurrentItem();
                if (getCurrentItem == null) {
                    item = null;
                }
                else {
                    final ItemStack p0 = getCurrentItem;
                    final int n = 0;
                    item = new Item(p0);
                }
            }
        }
        return item;
    }
    
    @JvmStatic
    public static final void setHeldItemIndex(final int index) {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        final InventoryPlayer inventoryPlayer = (player == null) ? null : player.inventory;
        if (inventoryPlayer != null) {
            inventoryPlayer.currentItem = index;
        }
    }
    
    @JvmStatic
    public static final int getHeldItemIndex() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        int n;
        if (player == null) {
            n = -1;
        }
        else {
            final InventoryPlayer inventory = player.inventory;
            n = ((inventory == null) ? -1 : inventory.currentItem);
        }
        return n;
    }
    
    @JvmStatic
    @Nullable
    public static final Inventory getInventory() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        Inventory inventory;
        if (player == null) {
            inventory = null;
        }
        else {
            final InventoryPlayer inventory = player.inventory;
            if (inventory == null) {
                inventory = null;
            }
            else {
                final IInventory p0 = (IInventory)inventory;
                final int n = 0;
                inventory = new Inventory(p0);
            }
        }
        return inventory;
    }
    
    @JvmStatic
    @NotNull
    public static final TextComponent getDisplayName() {
        final Player instance = Player.INSTANCE;
        final PlayerMP playerMP = asPlayerMP();
        TextComponent textComponent = (playerMP == null) ? null : playerMP.getDisplayName();
        if (textComponent == null) {
            textComponent = new TextComponent("");
        }
        return textComponent;
    }
    
    @JvmStatic
    public static final void setTabDisplayName(@NotNull final TextComponent textComponent) {
        Intrinsics.checkNotNullParameter((Object)textComponent, "textComponent");
        final Player instance = Player.INSTANCE;
        final PlayerMP playerMP = asPlayerMP();
        if (playerMP != null) {
            playerMP.setTabDisplayName(textComponent);
        }
    }
    
    @JvmStatic
    public static final void setNametagName(@NotNull final TextComponent textComponent) {
        Intrinsics.checkNotNullParameter((Object)textComponent, "textComponent");
        final Player instance = Player.INSTANCE;
        final PlayerMP playerMP = asPlayerMP();
        if (playerMP != null) {
            playerMP.setNametagName(textComponent);
        }
    }
    
    @Deprecated(message = "Use the better named method", replaceWith = @ReplaceWith(expression = "getContainer()", imports = {}))
    @JvmStatic
    @Nullable
    @java.lang.Deprecated
    public static final Inventory getOpenedInventory() {
        final Player instance = Player.INSTANCE;
        return getContainer();
    }
    
    @JvmStatic
    @Nullable
    public static final Inventory getContainer() {
        final Player instance = Player.INSTANCE;
        final EntityPlayerSP player = getPlayer();
        Inventory inventory;
        if (player == null) {
            inventory = null;
        }
        else {
            final Container openContainer = player.openContainer;
            if (openContainer == null) {
                inventory = null;
            }
            else {
                final Container p0 = openContainer;
                final int n = 0;
                inventory = new Inventory(p0);
            }
        }
        return inventory;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem, final boolean showArrows) {
        final Player $this$draw_u24lambda_u2d6 = Player.INSTANCE;
        final int n = 0;
        Renderer.drawPlayer((Object)$this$draw_u24lambda_u2d6, x, y, rotate, showNametag, showArmor, showCape, showHeldItem, showArrows);
        return $this$draw_u24lambda_u2d6;
    }
    
    public static /* synthetic */ Player draw$default(final int x, final int y, boolean rotate, boolean showNametag, boolean showArmor, boolean showCape, boolean showHeldItem, boolean showArrows, final int n, final Object o) {
        if ((n & 0x4) != 0x0) {
            rotate = false;
        }
        if ((n & 0x8) != 0x0) {
            showNametag = false;
        }
        if ((n & 0x10) != 0x0) {
            showArmor = true;
        }
        if ((n & 0x20) != 0x0) {
            showCape = true;
        }
        if ((n & 0x40) != 0x0) {
            showHeldItem = true;
        }
        if ((n & 0x80) != 0x0) {
            showArrows = true;
        }
        return draw(x, y, rotate, showNametag, showArmor, showCape, showHeldItem, showArrows);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem) {
        return draw$default(x, y, rotate, showNametag, showArmor, showCape, showHeldItem, false, 128, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape) {
        return draw$default(x, y, rotate, showNametag, showArmor, showCape, false, false, 192, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor) {
        return draw$default(x, y, rotate, showNametag, showArmor, false, false, false, 224, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y, final boolean rotate, final boolean showNametag) {
        return draw$default(x, y, rotate, showNametag, false, false, false, false, 240, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y, final boolean rotate) {
        return draw$default(x, y, rotate, false, false, false, false, false, 248, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Player draw(final int x, final int y) {
        return draw$default(x, y, false, false, false, false, false, false, 252, null);
    }
    
    static {
        INSTANCE = new Player();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/Player$armor;", "", "()V", "getBoots", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;", "getChestplate", "getHelmet", "getLeggings", "ctjs" })
    public static final class armor
    {
        @NotNull
        public static final armor INSTANCE;
        
        private armor() {
        }
        
        @JvmStatic
        @Nullable
        public static final Item getHelmet() {
            final Inventory inventory = Player.getInventory();
            return (inventory == null) ? null : inventory.getStackInSlot(39);
        }
        
        @JvmStatic
        @Nullable
        public static final Item getChestplate() {
            final Inventory inventory = Player.getInventory();
            return (inventory == null) ? null : inventory.getStackInSlot(38);
        }
        
        @JvmStatic
        @Nullable
        public static final Item getLeggings() {
            final Inventory inventory = Player.getInventory();
            return (inventory == null) ? null : inventory.getStackInSlot(37);
        }
        
        @JvmStatic
        @Nullable
        public static final Item getBoots() {
            final Inventory inventory = Player.getInventory();
            return (inventory == null) ? null : inventory.getStackInSlot(36);
        }
        
        static {
            INSTANCE = new armor();
        }
    }
}
