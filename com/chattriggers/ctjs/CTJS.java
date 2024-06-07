//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs;

import net.minecraftforge.fml.common.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import com.google.gson.*;
import java.io.*;
import com.chattriggers.ctjs.minecraft.objects.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import net.minecraftforge.fml.common.event.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.utils.*;
import kotlin.concurrent.*;
import com.chattriggers.ctjs.engine.module.*;
import kotlin.jvm.functions.*;
import javax.net.ssl.*;
import java.net.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import com.chattriggers.ctjs.commands.*;
import com.chattriggers.ctjs.triggers.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import kotlin.text.*;
import java.security.*;
import java.util.*;

@Mod(modid = "chattriggers", name = "ChatTriggers", version = "2.2.0", clientSideOnly = true, modLanguage = "Kotlin", modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter", acceptedMinecraftVersions = "[1.8.9]")
@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$" }, d2 = { "Lcom/chattriggers/ctjs/CTJS;", "", "()V", "WEBSITE_ROOT", "", "assetsDir", "Ljava/io/File;", "getAssetsDir", "()Ljava/io/File;", "configLocation", "getConfigLocation", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "images", "", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Image;", "getImages", "()Ljava/util/Set;", "sounds", "", "Lcom/chattriggers/ctjs/minecraft/objects/Sound;", "getSounds", "()Ljava/util/List;", "init", "", "event", "Lnet/minecraftforge/fml/common/event/FMLInitializationEvent;", "makeWebRequest", "Ljavax/net/ssl/HttpsURLConnection;", "url", "preInit", "Lnet/minecraftforge/fml/common/event/FMLPreInitializationEvent;", "registerHooks", "reportHashedUUID", "ctjs" })
public final class CTJS
{
    @NotNull
    public static final CTJS INSTANCE;
    @NotNull
    public static final String WEBSITE_ROOT = "https://www.chattriggers.com";
    @NotNull
    private static final Gson gson;
    @NotNull
    private static final File configLocation;
    @NotNull
    private static final File assetsDir;
    @NotNull
    private static final List<Sound> sounds;
    @NotNull
    private static final Set<Image> images;
    
    private CTJS() {
    }
    
    @NotNull
    public final Gson getGson() {
        return CTJS.gson;
    }
    
    @NotNull
    public final File getConfigLocation() {
        return CTJS.configLocation;
    }
    
    @NotNull
    public final File getAssetsDir() {
        return CTJS.assetsDir;
    }
    
    @NotNull
    public final List<Sound> getSounds() {
        return CTJS.sounds;
    }
    
    @NotNull
    public final Set<Image> getImages() {
        return CTJS.images;
    }
    
    @Mod.EventHandler
    public final void preInit(@NotNull final FMLPreInitializationEvent event) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "event"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: bipush          8
        //     8: anewarray       Ljava/lang/Object;
        //    11: astore_2       
        //    12: aload_2        
        //    13: iconst_0       
        //    14: getstatic       com/chattriggers/ctjs/minecraft/listeners/WorldListener.INSTANCE:Lcom/chattriggers/ctjs/minecraft/listeners/WorldListener;
        //    17: aastore        
        //    18: aload_2        
        //    19: iconst_1       
        //    20: getstatic       com/chattriggers/ctjs/minecraft/wrappers/CPS.INSTANCE:Lcom/chattriggers/ctjs/minecraft/wrappers/CPS;
        //    23: aastore        
        //    24: aload_2        
        //    25: iconst_2       
        //    26: getstatic       com/chattriggers/ctjs/minecraft/objects/gui/GuiHandler.INSTANCE:Lcom/chattriggers/ctjs/minecraft/objects/gui/GuiHandler;
        //    29: aastore        
        //    30: aload_2        
        //    31: iconst_3       
        //    32: getstatic       com/chattriggers/ctjs/minecraft/listeners/ClientListener.INSTANCE:Lcom/chattriggers/ctjs/minecraft/listeners/ClientListener;
        //    35: aastore        
        //    36: aload_2        
        //    37: iconst_4       
        //    38: getstatic       com/chattriggers/ctjs/utils/UpdateChecker.INSTANCE:Lcom/chattriggers/ctjs/utils/UpdateChecker;
        //    41: aastore        
        //    42: aload_2        
        //    43: iconst_5       
        //    44: getstatic       com/chattriggers/ctjs/minecraft/listeners/MouseListener.INSTANCE:Lcom/chattriggers/ctjs/minecraft/listeners/MouseListener;
        //    47: aastore        
        //    48: aload_2        
        //    49: bipush          6
        //    51: getstatic       com/chattriggers/ctjs/engine/module/ModuleUpdater.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;
        //    54: aastore        
        //    55: aload_2        
        //    56: bipush          7
        //    58: getstatic       com/chattriggers/ctjs/triggers/ForgeTrigger.Companion:Lcom/chattriggers/ctjs/triggers/ForgeTrigger$Companion;
        //    61: aastore        
        //    62: aload_2        
        //    63: invokestatic    kotlin/collections/CollectionsKt.listOf:([Ljava/lang/Object;)Ljava/util/List;
        //    66: checkcast       Ljava/lang/Iterable;
        //    69: astore_2       
        //    70: getstatic       net/minecraftforge/common/MinecraftForge.EVENT_BUS:Lnet/minecraftforge/fml/common/eventhandler/EventBus;
        //    73: astore_3       
        //    74: aload_3        
        //    75: ldc             "EVENT_BUS"
        //    77: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    80: aload_3        
        //    81: astore_3       
        //    82: iconst_0       
        //    83: istore          $i$f$forEach
        //    85: aload_2         /* $this$forEach$iv */
        //    86: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    91: astore          5
        //    93: aload           5
        //    95: invokeinterface java/util/Iterator.hasNext:()Z
        //   100: ifeq            128
        //   103: aload           5
        //   105: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   110: astore          element$iv
        //   112: aload           element$iv
        //   114: astore          p0
        //   116: iconst_0       
        //   117: istore          $i$a$-forEach-CTJS$preInit$1
        //   119: aload_3        
        //   120: aload           p0
        //   122: invokevirtual   net/minecraftforge/fml/common/eventhandler/EventBus.register:(Ljava/lang/Object;)V
        //   125: goto            93
        //   128: nop            
        //   129: invokestatic    com/chattriggers/ctjs/loader/UriScheme.installUriScheme:()V
        //   132: invokestatic    com/chattriggers/ctjs/loader/UriScheme.createSocketListener:()V
        //   135: return         
        //    StackMapTable: 00 02 FF 00 5D 00 06 07 00 02 07 00 A9 07 00 99 07 00 AB 01 07 00 AD 00 00 22
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
    
    @Mod.EventHandler
    public final void init(@NotNull final FMLInitializationEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        Config.INSTANCE.loadData();
        if (Config.INSTANCE.getThreadedLoading()) {
            ThreadsKt.thread$default(false, false, (ClassLoader)null, (String)null, 0, (Function0)CTJS$init.CTJS$init$1.INSTANCE, 31, (Object)null);
        }
        else {
            ModuleManager.entryPass$default(ModuleManager.INSTANCE, null, null, 3, null);
            ThreadsKt.thread$default(false, false, (ClassLoader)null, (String)null, 0, (Function0)CTJS$init.CTJS$init$2.INSTANCE, 31, (Object)null);
        }
        this.registerHooks();
    }
    
    @NotNull
    public final HttpsURLConnection makeWebRequest(@NotNull final String url) {
        Intrinsics.checkNotNullParameter((Object)url, "url");
        final URLConnection openConnection = new URL(url).openConnection();
        if (openConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        }
        final HttpsURLConnection $this$makeWebRequest_u24lambda_u2d1;
        final HttpsURLConnection httpsURLConnection = $this$makeWebRequest_u24lambda_u2d1 = (HttpsURLConnection)openConnection;
        final int n = 0;
        $this$makeWebRequest_u24lambda_u2d1.setRequestProperty("User-Agent", "Mozilla/5.0 (ChatTriggers)");
        $this$makeWebRequest_u24lambda_u2d1.setConnectTimeout(3000);
        $this$makeWebRequest_u24lambda_u2d1.setReadTimeout(3000);
        return httpsURLConnection;
    }
    
    private final void registerHooks() {
        ClientCommandHandler.instance.registerCommand((ICommand)CTCommand.INSTANCE);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> TriggerType.GameUnload.triggerAll(new Object[0])));
    }
    
    private final void reportHashedUUID() {
        final byte[] uuid = StringsKt.encodeToByteArray(Player.getUUID());
        String property;
        if ((property = System.getProperty("user.name")) == null) {
            property = "";
        }
        final byte[] salt = StringsKt.encodeToByteArray(property);
        final MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        final byte[] hashedUUID = md.digest(uuid);
        final String hash = Base64.getUrlEncoder().encodeToString(hashedUUID);
        final String url = "https://www.chattriggers.com/api/statistics/track?hash=" + (Object)hash + "&version=2.2.0";
        final HttpsURLConnection connection = this.makeWebRequest(url);
        connection.getInputStream();
    }
    
    static {
        INSTANCE = new CTJS();
        gson = new Gson();
        configLocation = new File("./config");
        final CTJS instance = CTJS.INSTANCE;
        final File $this$assetsDir_u24lambda_u2d0 = new File(CTJS.configLocation, "ChatTriggers/images/");
        final int n = 0;
        $this$assetsDir_u24lambda_u2d0.mkdirs();
        assetsDir = $this$assetsDir_u24lambda_u2d0;
        sounds = new ArrayList<Sound>();
        images = new LinkedHashSet<Image>();
    }
}
