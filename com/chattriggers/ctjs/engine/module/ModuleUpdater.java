//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.module;

import kotlin.*;
import net.minecraftforge.event.world.*;
import kotlin.jvm.internal.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import org.jetbrains.annotations.*;
import org.apache.commons.io.*;
import kotlin.collections.*;
import kotlin.text.*;
import java.util.function.*;
import kotlin.io.*;
import java.io.*;
import com.chattriggers.ctjs.*;
import com.chattriggers.ctjs.utils.console.*;
import javax.net.ssl.*;
import java.nio.file.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;", "", "()V", "changelogs", "", "Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;", "shouldReportChangelog", "", "downloadModule", "Lcom/chattriggers/ctjs/engine/module/ModuleUpdater$DownloadResult;", "name", "", "importModule", "", "Lcom/chattriggers/ctjs/engine/module/Module;", "moduleName", "requiredBy", "importPendingModules", "", "onRenderGameOverlay", "event", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Text;", "onWorldLoad", "Lnet/minecraftforge/event/world/WorldEvent$Load;", "reportChangelog", "module", "tryReportChangelog", "updateModule", "DownloadResult", "ctjs" })
public final class ModuleUpdater
{
    @NotNull
    public static final ModuleUpdater INSTANCE;
    @NotNull
    private static final List<ModuleMetadata> changelogs;
    private static boolean shouldReportChangelog;
    
    private ModuleUpdater() {
    }
    
    @SubscribeEvent
    public final void onWorldLoad(@NotNull final WorldEvent$Load event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        ModuleUpdater.shouldReportChangelog = true;
    }
    
    @SubscribeEvent
    public final void onRenderGameOverlay(@NotNull final RenderGameOverlayEvent$Text event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (!ModuleUpdater.shouldReportChangelog) {
            return;
        }
        final Iterable $this$forEach$iv = ModuleUpdater.changelogs;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final ModuleMetadata p0 = (ModuleMetadata)element$iv;
            final int n = 0;
            this.reportChangelog(p0);
        }
        ModuleUpdater.changelogs.clear();
    }
    
    private final void tryReportChangelog(final ModuleMetadata module) {
        if (ModuleUpdater.shouldReportChangelog) {
            this.reportChangelog(module);
        }
        else {
            ModuleUpdater.changelogs.add(module);
        }
    }
    
    private final void reportChangelog(final ModuleMetadata module) {
        ChatLib.chat("&a[ChatTriggers] " + (Object)module.getName() + " has updated to version " + (Object)module.getVersion());
        ChatLib.chat(Intrinsics.stringPlus("&aChangelog: &r", (Object)module.getChangelog()));
    }
    
    public final void importPendingModules() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //     7: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getModulesFolder:()Ljava/io/File;
        //    10: ldc             ".to_download.txt"
        //    12: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    15: astore_1        /* toDownload */
        //    16: aload_1         /* toDownload */
        //    17: invokevirtual   java/io/File.exists:()Z
        //    20: ifne            24
        //    23: return         
        //    24: aload_1         /* toDownload */
        //    25: aconst_null    
        //    26: iconst_1       
        //    27: aconst_null    
        //    28: invokestatic    kotlin/io/FilesKt.readText$default:(Ljava/io/File;Ljava/nio/charset/Charset;ILjava/lang/Object;)Ljava/lang/String;
        //    31: checkcast       Ljava/lang/CharSequence;
        //    34: iconst_1       
        //    35: anewarray       Ljava/lang/String;
        //    38: astore_2       
        //    39: aload_2        
        //    40: iconst_0       
        //    41: ldc             ","
        //    43: aastore        
        //    44: aload_2        
        //    45: iconst_0       
        //    46: iconst_0       
        //    47: bipush          6
        //    49: aconst_null    
        //    50: invokestatic    kotlin/text/StringsKt.split$default:(Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
        //    53: checkcast       Ljava/lang/Iterable;
        //    56: astore_2        /* $this$filter$iv */
        //    57: iconst_0       
        //    58: istore_3        /* $i$f$filter */
        //    59: aload_2         /* $this$filter$iv */
        //    60: astore          4
        //    62: new             Ljava/util/ArrayList;
        //    65: dup            
        //    66: invokespecial   java/util/ArrayList.<init>:()V
        //    69: checkcast       Ljava/util/Collection;
        //    72: astore          destination$iv$iv
        //    74: iconst_0       
        //    75: istore          $i$f$filterTo
        //    77: aload           $this$filterTo$iv$iv
        //    79: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    84: astore          7
        //    86: aload           7
        //    88: invokeinterface java/util/Iterator.hasNext:()Z
        //    93: ifeq            139
        //    96: aload           7
        //    98: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   103: astore          element$iv$iv
        //   105: aload           element$iv$iv
        //   107: checkcast       Ljava/lang/String;
        //   110: astore          p0
        //   112: iconst_0       
        //   113: istore          $i$a$-filter-ModuleUpdater$importPendingModules$1
        //   115: aload           p0
        //   117: checkcast       Ljava/lang/CharSequence;
        //   120: invokestatic    kotlin/text/StringsKt.isBlank:(Ljava/lang/CharSequence;)Z
        //   123: ifeq            86
        //   126: aload           destination$iv$iv
        //   128: aload           element$iv$iv
        //   130: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   135: pop            
        //   136: goto            86
        //   139: aload           destination$iv$iv
        //   141: checkcast       Ljava/util/List;
        //   144: nop            
        //   145: checkcast       Ljava/lang/Iterable;
        //   148: astore_2       
        //   149: nop            
        //   150: iconst_0       
        //   151: istore_3        /* $i$f$forEach */
        //   152: aload_2         /* $this$forEach$iv */
        //   153: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   158: astore          4
        //   160: aload           4
        //   162: invokeinterface java/util/Iterator.hasNext:()Z
        //   167: ifeq            202
        //   170: aload           4
        //   172: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   177: astore          element$iv
        //   179: aload           element$iv
        //   181: checkcast       Ljava/lang/String;
        //   184: astore          p0
        //   186: iconst_0       
        //   187: istore          $i$a$-forEach-ModuleUpdater$importPendingModules$2
        //   189: aload_0         /* this */
        //   190: aload           p0
        //   192: aconst_null    
        //   193: iconst_2       
        //   194: aconst_null    
        //   195: invokestatic    com/chattriggers/ctjs/engine/module/ModuleUpdater.importModule$default:(Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/util/List;
        //   198: pop            
        //   199: goto            160
        //   202: nop            
        //   203: aload_1         /* toDownload */
        //   204: invokevirtual   java/io/File.delete:()Z
        //   207: pop            
        //   208: return         
        //    StackMapTable: 00 05 FC 00 18 07 00 91 FF 00 3D 00 08 07 00 02 07 00 91 07 00 44 01 07 00 44 07 00 B9 01 07 00 4A 00 00 34 FF 00 14 00 06 07 00 02 07 00 91 07 00 44 01 07 00 4A 07 00 04 00 00 29
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
    
    public final void updateModule(@NotNull final Module module) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "module"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: getstatic       com/chattriggers/ctjs/utils/Config.INSTANCE:Lcom/chattriggers/ctjs/utils/Config;
        //     9: invokevirtual   com/chattriggers/ctjs/utils/Config.getAutoUpdateModules:()Z
        //    12: ifne            16
        //    15: return         
        //    16: aload_1         /* module */
        //    17: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //    20: astore_2        /* metadata */
        //    21: nop            
        //    22: aload_2         /* metadata */
        //    23: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //    26: ifnonnull       30
        //    29: return         
        //    30: ldc             "Checking for update in "
        //    32: aload_2         /* metadata */
        //    33: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //    36: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //    39: aconst_null    
        //    40: aconst_null    
        //    41: iconst_3       
        //    42: aconst_null    
        //    43: invokestatic    com/chattriggers/ctjs/ReferenceKt.printToConsole$default:(Ljava/lang/Object;Lcom/chattriggers/ctjs/utils/console/Console;Lcom/chattriggers/ctjs/utils/console/LogType;ILjava/lang/Object;)V
        //    46: new             Ljava/lang/StringBuilder;
        //    49: dup            
        //    50: invokespecial   java/lang/StringBuilder.<init>:()V
        //    53: ldc             "https://www.chattriggers.com/api/modules/"
        //    55: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    58: aload_2         /* metadata */
        //    59: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //    62: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    65: ldc             "/metadata?modVersion=2.2.0"
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    73: astore_3        /* url */
        //    74: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //    77: aload_3         /* url */
        //    78: invokevirtual   com/chattriggers/ctjs/CTJS.makeWebRequest:(Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
        //    81: astore          connection
        //    83: aload           connection
        //    85: invokevirtual   javax/net/ssl/HttpsURLConnection.getInputStream:()Ljava/io/InputStream;
        //    88: astore          6
        //    90: aload           6
        //    92: ldc_w           "connection.getInputStream()"
        //    95: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    98: aload           6
        //   100: astore          6
        //   102: getstatic       kotlin/text/Charsets.UTF_8:Ljava/nio/charset/Charset;
        //   105: astore          7
        //   107: new             Ljava/io/InputStreamReader;
        //   110: dup            
        //   111: aload           6
        //   113: aload           7
        //   115: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   118: checkcast       Ljava/io/Reader;
        //   121: astore          8
        //   123: sipush          8192
        //   126: istore          9
        //   128: aload           8
        //   130: instanceof      Ljava/io/BufferedReader;
        //   133: ifeq            144
        //   136: aload           8
        //   138: checkcast       Ljava/io/BufferedReader;
        //   141: goto            155
        //   144: new             Ljava/io/BufferedReader;
        //   147: dup            
        //   148: aload           8
        //   150: iload           9
        //   152: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;I)V
        //   155: checkcast       Ljava/io/Reader;
        //   158: invokestatic    kotlin/io/TextStreamsKt.readText:(Ljava/io/Reader;)Ljava/lang/String;
        //   161: astore          newMetadataText
        //   163: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //   166: invokevirtual   com/chattriggers/ctjs/CTJS.getGson:()Lcom/google/gson/Gson;
        //   169: aload           newMetadataText
        //   171: ldc             Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;.class
        //   173: invokevirtual   com/google/gson/Gson.fromJson:(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: checkcast       Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   179: astore          newMetadata
        //   181: aload           newMetadata
        //   183: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getVersion:()Ljava/lang/String;
        //   186: ifnonnull       228
        //   189: new             Ljava/lang/StringBuilder;
        //   192: dup            
        //   193: invokespecial   java/lang/StringBuilder.<init>:()V
        //   196: ldc_w           "Remote version of module "
        //   199: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   202: aload_2         /* metadata */
        //   203: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //   206: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   209: ldc_w           " has no version numbers, so it will not be updated!"
        //   212: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   215: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   218: aconst_null    
        //   219: getstatic       com/chattriggers/ctjs/utils/console/LogType.WARN:Lcom/chattriggers/ctjs/utils/console/LogType;
        //   222: iconst_1       
        //   223: aconst_null    
        //   224: invokestatic    com/chattriggers/ctjs/ReferenceKt.printToConsole$default:(Ljava/lang/Object;Lcom/chattriggers/ctjs/utils/console/Console;Lcom/chattriggers/ctjs/utils/console/LogType;ILjava/lang/Object;)V
        //   227: return         
        //   228: aload_2         /* metadata */
        //   229: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getVersion:()Ljava/lang/String;
        //   232: ifnull          257
        //   235: aload_2         /* metadata */
        //   236: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getVersion:()Ljava/lang/String;
        //   239: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.toVersion:(Ljava/lang/String;)Lcom/fasterxml/jackson/core/Version;
        //   242: aload           newMetadata
        //   244: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getVersion:()Ljava/lang/String;
        //   247: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.toVersion:(Ljava/lang/String;)Lcom/fasterxml/jackson/core/Version;
        //   250: invokevirtual   com/fasterxml/jackson/core/Version.compareTo:(Lcom/fasterxml/jackson/core/Version;)I
        //   253: iflt            257
        //   256: return         
        //   257: aload_0         /* this */
        //   258: aload_2         /* metadata */
        //   259: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //   262: invokespecial   com/chattriggers/ctjs/engine/module/ModuleUpdater.downloadModule:(Ljava/lang/String;)Lcom/chattriggers/ctjs/engine/module/ModuleUpdater$DownloadResult;
        //   265: pop            
        //   266: ldc_w           "Updated module "
        //   269: aload_2         /* metadata */
        //   270: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //   273: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //   276: aconst_null    
        //   277: aconst_null    
        //   278: iconst_3       
        //   279: aconst_null    
        //   280: invokestatic    com/chattriggers/ctjs/ReferenceKt.printToConsole$default:(Ljava/lang/Object;Lcom/chattriggers/ctjs/utils/console/Console;Lcom/chattriggers/ctjs/utils/console/LogType;ILjava/lang/Object;)V
        //   283: aload_1         /* module */
        //   284: new             Ljava/io/File;
        //   287: dup            
        //   288: aload_1         /* module */
        //   289: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //   292: ldc_w           "metadata.json"
        //   295: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   298: astore          9
        //   300: astore          11
        //   302: iconst_0       
        //   303: istore          $i$a$-let-ModuleUpdater$updateModule$1
        //   305: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //   308: invokevirtual   com/chattriggers/ctjs/CTJS.getGson:()Lcom/google/gson/Gson;
        //   311: aload           it
        //   313: aconst_null    
        //   314: iconst_1       
        //   315: aconst_null    
        //   316: invokestatic    kotlin/io/FilesKt.readText$default:(Ljava/io/File;Ljava/nio/charset/Charset;ILjava/lang/Object;)Ljava/lang/String;
        //   319: ldc             Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;.class
        //   321: invokevirtual   com/google/gson/Gson.fromJson:(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
        //   324: checkcast       Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   327: aload           11
        //   329: swap           
        //   330: nop            
        //   331: astore          7
        //   333: aload           7
        //   335: ldc_w           "File(module.folder, \"met\u2026class.java)\n            }"
        //   338: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   341: aload           7
        //   343: invokevirtual   com/chattriggers/ctjs/engine/module/Module.setMetadata:(Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;)V
        //   346: getstatic       com/chattriggers/ctjs/utils/Config.INSTANCE:Lcom/chattriggers/ctjs/utils/Config;
        //   349: invokevirtual   com/chattriggers/ctjs/utils/Config.getModuleChangelog:()Z
        //   352: ifeq            396
        //   355: aload_1         /* module */
        //   356: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   359: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getChangelog:()Ljava/lang/String;
        //   362: ifnull          396
        //   365: aload_0         /* this */
        //   366: aload_1         /* module */
        //   367: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   370: invokespecial   com/chattriggers/ctjs/engine/module/ModuleUpdater.tryReportChangelog:(Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;)V
        //   373: goto            396
        //   376: astore_3        /* e */
        //   377: ldc_w           "Can't find page for "
        //   380: aload_2         /* metadata */
        //   381: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getName:()Ljava/lang/String;
        //   384: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //   387: aconst_null    
        //   388: getstatic       com/chattriggers/ctjs/utils/console/LogType.WARN:Lcom/chattriggers/ctjs/utils/console/LogType;
        //   391: iconst_1       
        //   392: aconst_null    
        //   393: invokestatic    com/chattriggers/ctjs/ReferenceKt.printToConsole$default:(Ljava/lang/Object;Lcom/chattriggers/ctjs/utils/console/Console;Lcom/chattriggers/ctjs/utils/console/LogType;ILjava/lang/Object;)V
        //   396: return         
        //    StackMapTable: 00 08 10 FC 00 0D 07 00 54 FF 00 71 00 0A 07 00 02 07 00 DF 07 00 54 07 00 AC 07 00 FA 00 07 01 14 07 01 16 07 01 10 01 00 00 4A 07 01 12 FF 00 48 00 0A 07 00 02 07 00 DF 07 00 54 07 00 AC 07 00 FA 07 00 AC 07 00 54 07 01 16 07 01 10 01 00 00 1C FF 00 76 00 03 07 00 02 07 00 DF 07 00 54 00 01 07 00 D4 FC 00 13 07 00 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     373    376    396    Ljava/lang/Exception;
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
    
    @NotNull
    public final List<Module> importModule(@NotNull final String moduleName, @Nullable final String requiredBy) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "moduleName"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //    10: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getCachedModules:()Ljava/util/List;
        //    13: checkcast       Ljava/lang/Iterable;
        //    16: astore          $this$any$iv
        //    18: iconst_0       
        //    19: istore          $i$f$any
        //    21: aload           $this$any$iv
        //    23: instanceof      Ljava/util/Collection;
        //    26: ifeq            46
        //    29: aload           $this$any$iv
        //    31: checkcast       Ljava/util/Collection;
        //    34: invokeinterface java/util/Collection.isEmpty:()Z
        //    39: ifeq            46
        //    42: iconst_0       
        //    43: goto            136
        //    46: aload           $this$any$iv
        //    48: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    53: astore          6
        //    55: aload           6
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifeq            135
        //    65: aload           6
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: astore          element$iv
        //    74: aload           element$iv
        //    76: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //    79: astore          it
        //    81: iconst_0       
        //    82: istore          $i$a$-any-ModuleUpdater$importModule$alreadyImported$1
        //    84: aload           it
        //    86: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getName:()Ljava/lang/String;
        //    89: aload_1         /* moduleName */
        //    90: iconst_1       
        //    91: invokestatic    kotlin/text/StringsKt.equals:(Ljava/lang/String;Ljava/lang/String;Z)Z
        //    94: ifeq            126
        //    97: aload_2         /* requiredBy */
        //    98: ifnull          122
        //   101: aload           it
        //   103: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   106: iconst_1       
        //   107: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.setRequired:(Z)V
        //   110: aload           it
        //   112: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getRequiredBy:()Ljava/util/Set;
        //   115: aload_2         /* requiredBy */
        //   116: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   121: pop            
        //   122: iconst_1       
        //   123: goto            127
        //   126: iconst_0       
        //   127: nop            
        //   128: ifeq            55
        //   131: iconst_1       
        //   132: goto            136
        //   135: iconst_0       
        //   136: istore_3        /* alreadyImported */
        //   137: iload_3         /* alreadyImported */
        //   138: ifeq            145
        //   141: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   144: areturn        
        //   145: aload_0         /* this */
        //   146: aload_1         /* moduleName */
        //   147: invokespecial   com/chattriggers/ctjs/engine/module/ModuleUpdater.downloadModule:(Ljava/lang/String;)Lcom/chattriggers/ctjs/engine/module/ModuleUpdater$DownloadResult;
        //   150: dup            
        //   151: ifnonnull       159
        //   154: pop            
        //   155: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   158: areturn        
        //   159: astore          4
        //   161: aload           4
        //   163: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleUpdater$DownloadResult.component1:()Ljava/lang/String;
        //   166: astore          realName
        //   168: aload           4
        //   170: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleUpdater$DownloadResult.component2:()Ljava/lang/String;
        //   173: astore          modVersion
        //   175: new             Ljava/io/File;
        //   178: dup            
        //   179: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //   182: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getModulesFolder:()Ljava/io/File;
        //   185: aload           realName
        //   187: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   190: astore          moduleDir
        //   192: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //   195: aload           moduleDir
        //   197: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.parseModule:(Ljava/io/File;)Lcom/chattriggers/ctjs/engine/module/Module;
        //   200: astore          module
        //   202: aload           module
        //   204: aload           modVersion
        //   206: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.toVersion:(Ljava/lang/String;)Lcom/fasterxml/jackson/core/Version;
        //   209: invokevirtual   com/chattriggers/ctjs/engine/module/Module.setTargetModVersion:(Lcom/fasterxml/jackson/core/Version;)V
        //   212: aload_2         /* requiredBy */
        //   213: ifnull          237
        //   216: aload           module
        //   218: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   221: iconst_1       
        //   222: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.setRequired:(Z)V
        //   225: aload           module
        //   227: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getRequiredBy:()Ljava/util/Set;
        //   230: aload_2         /* requiredBy */
        //   231: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   236: pop            
        //   237: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //   240: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getCachedModules:()Ljava/util/List;
        //   243: aload           module
        //   245: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   250: pop            
        //   251: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //   254: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getCachedModules:()Ljava/util/List;
        //   257: invokedynamic   BootstrapMethod #0, compare:()Ljava/util/Comparator;
        //   262: invokestatic    kotlin/collections/CollectionsKt.sortWith:(Ljava/util/List;Ljava/util/Comparator;)V
        //   265: aload           module
        //   267: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //   270: checkcast       Ljava/util/Collection;
        //   273: aload           module
        //   275: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   278: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getRequires:()Ljava/util/ArrayList;
        //   281: astore          10
        //   283: aload           10
        //   285: ifnonnull       292
        //   288: aconst_null    
        //   289: goto            416
        //   292: aload           10
        //   294: checkcast       Ljava/lang/Iterable;
        //   297: astore          12
        //   299: astore          21
        //   301: iconst_0       
        //   302: istore          $i$f$map
        //   304: aload           $this$map$iv
        //   306: astore          14
        //   308: new             Ljava/util/ArrayList;
        //   311: dup            
        //   312: aload           $this$map$iv
        //   314: bipush          10
        //   316: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   319: invokespecial   java/util/ArrayList.<init>:(I)V
        //   322: checkcast       Ljava/util/Collection;
        //   325: astore          destination$iv$iv
        //   327: iconst_0       
        //   328: istore          $i$f$mapTo
        //   330: aload           $this$mapTo$iv$iv
        //   332: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   337: astore          17
        //   339: aload           17
        //   341: invokeinterface java/util/Iterator.hasNext:()Z
        //   346: ifeq            397
        //   349: aload           17
        //   351: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   356: astore          item$iv$iv
        //   358: aload           destination$iv$iv
        //   360: aload           item$iv$iv
        //   362: checkcast       Ljava/lang/String;
        //   365: astore          19
        //   367: astore          22
        //   369: iconst_0       
        //   370: istore          $i$a$-map-ModuleUpdater$importModule$2
        //   372: getstatic       com/chattriggers/ctjs/engine/module/ModuleUpdater.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;
        //   375: aload           it
        //   377: aload           module
        //   379: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getName:()Ljava/lang/String;
        //   382: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleUpdater.importModule:(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
        //   385: aload           22
        //   387: swap           
        //   388: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   393: pop            
        //   394: goto            339
        //   397: aload           destination$iv$iv
        //   399: checkcast       Ljava/util/List;
        //   402: nop            
        //   403: aload           21
        //   405: swap           
        //   406: astore          11
        //   408: aload           11
        //   410: checkcast       Ljava/lang/Iterable;
        //   413: invokestatic    kotlin/collections/CollectionsKt.flatten:(Ljava/lang/Iterable;)Ljava/util/List;
        //   416: astore          9
        //   418: aload           9
        //   420: ifnonnull       432
        //   423: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   426: checkcast       Ljava/lang/Iterable;
        //   429: goto            437
        //   432: aload           9
        //   434: checkcast       Ljava/lang/Iterable;
        //   437: invokestatic    kotlin/collections/CollectionsKt.plus:(Ljava/util/Collection;Ljava/lang/Iterable;)Ljava/util/List;
        //   440: areturn        
        //    Signature:
        //  (Ljava/lang/String;Ljava/lang/String;)Ljava/util/List<Lcom/chattriggers/ctjs/engine/module/Module;>;
        //    StackMapTable: 00 10 FE 00 2E 00 07 00 44 01 FC 00 08 07 00 4A FE 00 42 07 00 04 07 00 DF 01 03 40 01 F8 00 07 FF 00 00 00 06 07 00 02 07 00 AC 07 00 AC 00 07 00 44 01 00 01 01 FF 00 08 00 06 07 00 02 07 00 AC 07 00 AC 01 07 00 44 01 00 00 4D 07 00 2B FF 00 4D 00 09 07 00 02 07 00 AC 07 00 AC 01 07 00 2B 07 00 AC 07 00 AC 07 00 91 07 00 DF 00 00 FF 00 36 00 0B 07 00 02 07 00 AC 07 00 AC 01 07 00 2B 07 00 AC 07 00 AC 07 00 91 07 00 DF 00 07 00 B6 00 01 07 00 B9 FF 00 2E 00 16 07 00 02 07 00 AC 07 00 AC 01 07 00 2B 07 00 AC 07 00 AC 07 00 91 07 00 DF 00 07 00 B6 00 07 00 44 01 07 00 44 07 00 B9 01 07 00 4A 00 00 00 07 00 B9 00 00 39 FF 00 12 00 0B 07 00 02 07 00 AC 07 00 AC 01 07 00 2B 07 00 AC 07 00 AC 07 00 91 07 00 DF 00 07 00 B6 00 02 07 00 B9 07 00 59 FF 00 0F 00 0B 07 00 02 07 00 AC 07 00 AC 01 07 00 2B 07 00 AC 07 00 AC 07 00 91 07 00 DF 07 00 59 07 00 B6 00 01 07 00 B9 FF 00 04 00 0B 07 00 02 07 00 AC 07 00 AC 01 07 00 2B 07 00 AC 07 00 AC 07 00 91 07 00 DF 07 00 59 07 00 B6 00 02 07 00 B9 07 00 44
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
    
    private final DownloadResult downloadModule(final String name) {
        final File downloadZip = new File(ModuleManager.INSTANCE.getModulesFolder(), "currDownload.zip");
        try {
            final String url = "https://www.chattriggers.com/api/modules/" + name + "/scripts?modVersion=2.2.0";
            final HttpsURLConnection connection = CTJS.INSTANCE.makeWebRequest(url);
            FileUtils.copyInputStreamToFile(connection.getInputStream(), downloadZip);
            final FileSystem fileSystem = FileSystems.newFileSystem(downloadZip.toPath(), (ClassLoader)null);
            Throwable t = null;
            try {
                final FileSystem it = fileSystem;
                final int n = 0;
                final Iterable<Path> rootDirectories = it.getRootDirectories();
                Intrinsics.checkNotNullExpressionValue((Object)rootDirectories, "it.rootDirectories");
                final Iterator<Path> iterator = Files.newDirectoryStream((Path)CollectionsKt.first((Iterable)rootDirectories)).iterator();
                Intrinsics.checkNotNullExpressionValue((Object)iterator, "newDirectoryStream(it.ro\u2026ories.first()).iterator()");
                final Iterator rootFolder = iterator;
                if (!rootFolder.hasNext()) {
                    throw new Exception("Too small");
                }
                final Path moduleFolder = rootFolder.next();
                if (rootFolder.hasNext()) {
                    throw new Exception("Too big");
                }
                final String realName = StringsKt.trimEnd(moduleFolder.getFileName().toString(), new char[] { File.separatorChar });
                final File $this$downloadModule_u24lambda_u2d7_u24lambda_u2d5 = new File(ModuleManager.INSTANCE.getModulesFolder(), realName);
                final int n2 = 0;
                $this$downloadModule_u24lambda_u2d7_u24lambda_u2d5.mkdir();
                Files.walk(moduleFolder, new FileVisitOption[0]).forEach(ModuleUpdater::downloadModule$lambda-7$lambda-6);
                final String name2 = realName;
                final String headerField = connection.getHeaderField("CT-Version");
                Intrinsics.checkNotNullExpressionValue((Object)headerField, "connection.getHeaderField(\"CT-Version\")");
                final DownloadResult downloadResult = new DownloadResult(name2, headerField);
                CloseableKt.closeFinally((Closeable)fileSystem, t);
                return downloadResult;
            }
            catch (Throwable t2) {
                t = t2;
                throw t2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)fileSystem, t);
            }
        }
        catch (Exception exception) {
            ReferenceKt.printTraceToConsole$default(exception, null, 1, null);
        }
        finally {
            downloadZip.delete();
        }
        return null;
    }
    
    private static final int importModule$lambda-3(final Module a, final Module b) {
        return a.getName().compareTo(b.getName());
    }
    
    private static final void downloadModule$lambda-7$lambda-6(final Path path) {
        final Path resolvedPath = Paths.get(ModuleManager.INSTANCE.getModulesFolder().toString(), path.toString());
        if (Files.isDirectory(resolvedPath, new LinkOption[0])) {
            return;
        }
        Files.copy(path, resolvedPath, StandardCopyOption.REPLACE_EXISTING);
    }
    
    static {
        INSTANCE = new ModuleUpdater();
        changelogs = new ArrayList<ModuleMetadata>();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/ModuleUpdater$DownloadResult;", "", "name", "", "modVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getModVersion", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ctjs" })
    public static final class DownloadResult
    {
        @NotNull
        private final String name;
        @NotNull
        private final String modVersion;
        
        public DownloadResult(@NotNull final String name, @NotNull final String modVersion) {
            Intrinsics.checkNotNullParameter((Object)name, "name");
            Intrinsics.checkNotNullParameter((Object)modVersion, "modVersion");
            this.name = name;
            this.modVersion = modVersion;
        }
        
        @NotNull
        public final String getName() {
            return this.name;
        }
        
        @NotNull
        public final String getModVersion() {
            return this.modVersion;
        }
        
        @NotNull
        public final String component1() {
            return this.name;
        }
        
        @NotNull
        public final String component2() {
            return this.modVersion;
        }
        
        @NotNull
        public final DownloadResult copy(@NotNull final String name, @NotNull final String modVersion) {
            Intrinsics.checkNotNullParameter((Object)name, "name");
            Intrinsics.checkNotNullParameter((Object)modVersion, "modVersion");
            return new DownloadResult(name, modVersion);
        }
        
        @NotNull
        @Override
        public String toString() {
            return "DownloadResult(name=" + this.name + ", modVersion=" + this.modVersion + ')';
        }
        
        @Override
        public int hashCode() {
            int result = this.name.hashCode();
            result = result * 31 + this.modVersion.hashCode();
            return result;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadResult)) {
                return false;
            }
            final DownloadResult downloadResult = (DownloadResult)other;
            return Intrinsics.areEqual((Object)this.name, (Object)downloadResult.name) && Intrinsics.areEqual((Object)this.modVersion, (Object)downloadResult.modVersion);
        }
    }
}
