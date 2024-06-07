//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.module;

import java.io.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import java.lang.invoke.*;
import kotlin.text.*;
import kotlin.io.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.utils.console.*;
import kotlin.collections.*;
import java.util.*;
import com.chattriggers.ctjs.engine.langs.js.*;
import java.net.*;
import com.chattriggers.ctjs.*;
import org.mozilla.javascript.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import com.chattriggers.ctjs.launch.*;
import com.chattriggers.ctjs.utils.*;
import com.chattriggers.ctjs.triggers.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018J;\u0010\u001f\u001a\u00020\u001b2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\r2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\"J\u000e\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0018J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010,\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002J\u0016\u0010-\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002J\u000e\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0010J\u000e\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u001bJ\u0006\u00103\u001a\u00020\u001bJ%\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0010\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000108¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007¨\u0006<" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/ModuleManager;", "", "()V", "cachedModules", "", "Lcom/chattriggers/ctjs/engine/module/Module;", "getCachedModules", "()Ljava/util/List;", "generalConsole", "Lcom/chattriggers/ctjs/utils/console/Console;", "getGeneralConsole", "()Lcom/chattriggers/ctjs/utils/console/Console;", "loaders", "", "Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;", "modulesFolder", "Ljava/io/File;", "getModulesFolder", "()Ljava/io/File;", "pendingOldModules", "getPendingOldModules", "asmInvokeLookup", "Ljava/lang/invoke/MethodHandle;", "moduleName", "", "functionID", "asmPass", "", "deleteModule", "", "name", "entryPass", "modules", "completionListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "percentComplete", "getConsole", "language", "getFoldersInDir", "dir", "importModule", "Lcom/chattriggers/ctjs/engine/module/ModuleManager$ImportedModule;", "loadAssets", "loadAssetsAndJars", "parseModule", "directory", "reportOldVersion", "module", "setup", "teardown", "trigger", "type", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "arguments", "", "(Lcom/chattriggers/ctjs/triggers/TriggerType;[Ljava/lang/Object;)V", "tryReportOldVersion", "ImportedModule", "ctjs" })
public final class ModuleManager
{
    @NotNull
    public static final ModuleManager INSTANCE;
    @NotNull
    private static final List<JSLoader> loaders;
    @NotNull
    private static final Console generalConsole;
    @NotNull
    private static final List<Module> cachedModules;
    @NotNull
    private static final File modulesFolder;
    @NotNull
    private static final List<Module> pendingOldModules;
    
    private ModuleManager() {
    }
    
    @NotNull
    public final Console getGeneralConsole() {
        return ModuleManager.generalConsole;
    }
    
    @NotNull
    public final List<Module> getCachedModules() {
        return ModuleManager.cachedModules;
    }
    
    @NotNull
    public final File getModulesFolder() {
        return ModuleManager.modulesFolder;
    }
    
    @NotNull
    public final List<Module> getPendingOldModules() {
        return ModuleManager.pendingOldModules;
    }
    
    public final void setup() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   java/io/File.mkdirs:()Z
        //     6: pop            
        //     7: nop            
        //     8: ldc             "PolarConfigV2"
        //    10: ldc             "channel"
        //    12: invokestatic    com/chattriggers/ctjs/minecraft/libs/FileLib.exists:(Ljava/lang/String;Ljava/lang/String;)Z
        //    15: ifeq            62
        //    18: iconst_3       
        //    19: anewarray       Ljava/lang/String;
        //    22: astore_2       
        //    23: aload_2        
        //    24: iconst_0       
        //    25: ldc             "release"
        //    27: aastore        
        //    28: aload_2        
        //    29: iconst_1       
        //    30: ldc             "plus"
        //    32: aastore        
        //    33: aload_2        
        //    34: iconst_2       
        //    35: ldc             "beta"
        //    37: aastore        
        //    38: aload_2        
        //    39: ldc             "PolarConfigV2"
        //    41: ldc             "channel"
        //    43: invokestatic    com/chattriggers/ctjs/minecraft/libs/FileLib.read:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    46: invokestatic    kotlin/collections/ArraysKt.contains:([Ljava/lang/Object;Ljava/lang/Object;)Z
        //    49: ifeq            62
        //    52: ldc             "PolarConfigV2"
        //    54: ldc             "channel"
        //    56: invokestatic    com/chattriggers/ctjs/minecraft/libs/FileLib.read:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    59: goto            64
        //    62: ldc             "release"
        //    64: astore_1        /* channel */
        //    65: new             Ljava/io/File;
        //    68: dup            
        //    69: ldc             "./config/ChatTriggers/modules/PolarClient/metadata.json"
        //    71: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    74: astore_2        /* metadata */
        //    75: aload_2         /* metadata */
        //    76: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    79: invokevirtual   java/io/File.mkdirs:()Z
        //    82: pop            
        //    83: ldc             "https://polar.forkdev.xyz/scripts/version?channel="
        //    85: aload_1         /* channel */
        //    86: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //    89: aconst_null    
        //    90: iconst_2       
        //    91: aconst_null    
        //    92: invokestatic    com/chattriggers/ctjs/minecraft/libs/FileLib.getUrlContent$default:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
        //    95: astore_3        /* latestVersion */
        //    96: aload_3         /* latestVersion */
        //    97: checkcast       Ljava/lang/CharSequence;
        //   100: invokeinterface java/lang/CharSequence.length:()I
        //   105: ifle            112
        //   108: iconst_1       
        //   109: goto            113
        //   112: iconst_0       
        //   113: ifeq            308
        //   116: aload_2         /* metadata */
        //   117: invokevirtual   java/io/File.exists:()Z
        //   120: ifeq            146
        //   123: aload_2         /* metadata */
        //   124: aconst_null    
        //   125: iconst_1       
        //   126: aconst_null    
        //   127: invokestatic    kotlin/io/FilesKt.readText$default:(Ljava/io/File;Ljava/nio/charset/Charset;ILjava/lang/Object;)Ljava/lang/String;
        //   130: checkcast       Ljava/lang/CharSequence;
        //   133: aload_3         /* latestVersion */
        //   134: checkcast       Ljava/lang/CharSequence;
        //   137: iconst_0       
        //   138: iconst_2       
        //   139: aconst_null    
        //   140: invokestatic    kotlin/text/StringsKt.contains$default:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
        //   143: ifne            308
        //   146: new             Ljava/io/File;
        //   149: dup            
        //   150: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.modulesFolder:Ljava/io/File;
        //   153: ldc             "currDownload.zip"
        //   155: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   158: astore          downloadZip
        //   160: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //   163: ldc             "https://polar.forkdev.xyz/storage/PolarClient.zip"
        //   165: invokevirtual   com/chattriggers/ctjs/CTJS.makeWebRequest:(Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
        //   168: astore          connection
        //   170: aload           connection
        //   172: invokevirtual   javax/net/ssl/HttpsURLConnection.getInputStream:()Ljava/io/InputStream;
        //   175: aload           downloadZip
        //   177: invokestatic    org/apache/commons/io/FileUtils.copyInputStreamToFile:(Ljava/io/InputStream;Ljava/io/File;)V
        //   180: new             Ljava/io/File;
        //   183: dup            
        //   184: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.modulesFolder:Ljava/io/File;
        //   187: ldc             "PolarClient"
        //   189: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   192: invokestatic    kotlin/io/FilesKt.deleteRecursively:(Ljava/io/File;)Z
        //   195: pop            
        //   196: aload           downloadZip
        //   198: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //   201: astore          6
        //   203: aload           6
        //   205: ldc             "downloadZip.path"
        //   207: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   210: aload           6
        //   212: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.modulesFolder:Ljava/io/File;
        //   215: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //   218: astore          6
        //   220: aload           6
        //   222: ldc             "modulesFolder.path"
        //   224: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   227: aload           6
        //   229: invokestatic    com/chattriggers/ctjs/minecraft/libs/FileLib.unzip:(Ljava/lang/String;Ljava/lang/String;)V
        //   232: new             Lkotlin/text/Regex;
        //   235: dup            
        //   236: ldc             "\"version\": \"(\\d.+)\","
        //   238: invokespecial   kotlin/text/Regex.<init>:(Ljava/lang/String;)V
        //   241: astore          versionRegex
        //   243: aload_2         /* metadata */
        //   244: aload           versionRegex
        //   246: aload_2         /* metadata */
        //   247: aconst_null    
        //   248: iconst_1       
        //   249: aconst_null    
        //   250: invokestatic    kotlin/io/FilesKt.readText$default:(Ljava/io/File;Ljava/nio/charset/Charset;ILjava/lang/Object;)Ljava/lang/String;
        //   253: checkcast       Ljava/lang/CharSequence;
        //   256: new             Ljava/lang/StringBuilder;
        //   259: dup            
        //   260: invokespecial   java/lang/StringBuilder.<init>:()V
        //   263: ldc             "\"version\": \""
        //   265: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   268: aload_3         /* latestVersion */
        //   269: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: ldc             "\","
        //   274: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   280: invokevirtual   kotlin/text/Regex.replace:(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
        //   283: aconst_null    
        //   284: iconst_2       
        //   285: aconst_null    
        //   286: invokestatic    kotlin/io/FilesKt.writeText$default:(Ljava/io/File;Ljava/lang/String;Ljava/nio/charset/Charset;ILjava/lang/Object;)V
        //   289: aload           downloadZip
        //   291: invokevirtual   java/io/File.delete:()Z
        //   294: pop            
        //   295: goto            308
        //   298: astore_1        /* e */
        //   299: ldc             "&0[&bPolar Client&0]&r Polar Client failed to download, are the servers down?"
        //   301: invokestatic    com/chattriggers/ctjs/minecraft/libs/ChatLib.chat:(Ljava/lang/Object;)V
        //   304: aload_1         /* e */
        //   305: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   308: getstatic       com/chattriggers/ctjs/engine/module/ModuleUpdater.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;
        //   311: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleUpdater.importPendingModules:()V
        //   314: aload_0         /* this */
        //   315: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.modulesFolder:Ljava/io/File;
        //   318: invokespecial   com/chattriggers/ctjs/engine/module/ModuleManager.getFoldersInDir:(Ljava/io/File;)Ljava/util/List;
        //   321: checkcast       Ljava/lang/Iterable;
        //   324: astore_2        /* $this$map$iv */
        //   325: iconst_0       
        //   326: istore_3        /* $i$f$map */
        //   327: aload_2         /* $this$map$iv */
        //   328: astore          4
        //   330: new             Ljava/util/ArrayList;
        //   333: dup            
        //   334: aload_2         /* $this$map$iv */
        //   335: bipush          10
        //   337: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   340: invokespecial   java/util/ArrayList.<init>:(I)V
        //   343: checkcast       Ljava/util/Collection;
        //   346: astore          destination$iv$iv
        //   348: iconst_0       
        //   349: istore          $i$f$mapTo
        //   351: aload           $this$mapTo$iv$iv
        //   353: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   358: astore          7
        //   360: aload           7
        //   362: invokeinterface java/util/Iterator.hasNext:()Z
        //   367: ifeq            411
        //   370: aload           7
        //   372: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   377: astore          item$iv$iv
        //   379: aload           destination$iv$iv
        //   381: aload           item$iv$iv
        //   383: checkcast       Ljava/io/File;
        //   386: astore          9
        //   388: astore          15
        //   390: iconst_0       
        //   391: istore          $i$a$-map-ModuleManager$setup$installedModules$1
        //   393: aload_0         /* this */
        //   394: aload           p0
        //   396: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.parseModule:(Ljava/io/File;)Lcom/chattriggers/ctjs/engine/module/Module;
        //   399: aload           15
        //   401: swap           
        //   402: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   407: pop            
        //   408: goto            360
        //   411: aload           destination$iv$iv
        //   413: checkcast       Ljava/util/List;
        //   416: nop            
        //   417: checkcast       Ljava/lang/Iterable;
        //   420: astore_2       
        //   421: nop            
        //   422: iconst_0       
        //   423: istore_3        /* $i$f$distinctBy */
        //   424: new             Ljava/util/HashSet;
        //   427: dup            
        //   428: invokespecial   java/util/HashSet.<init>:()V
        //   431: astore          set$iv
        //   433: new             Ljava/util/ArrayList;
        //   436: dup            
        //   437: invokespecial   java/util/ArrayList.<init>:()V
        //   440: astore          list$iv
        //   442: aload_2         /* $this$distinctBy$iv */
        //   443: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   448: astore          6
        //   450: aload           6
        //   452: invokeinterface java/util/Iterator.hasNext:()Z
        //   457: ifeq            521
        //   460: aload           6
        //   462: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   467: astore          e$iv
        //   469: aload           e$iv
        //   471: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   474: astore          it
        //   476: iconst_0       
        //   477: istore          $i$a$-distinctBy-ModuleManager$setup$installedModules$2
        //   479: aload           it
        //   481: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getName:()Ljava/lang/String;
        //   484: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //   487: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   490: dup            
        //   491: ldc_w           "this as java.lang.String).toLowerCase(Locale.ROOT)"
        //   494: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   497: nop            
        //   498: astore          key$iv
        //   500: aload           set$iv
        //   502: aload           key$iv
        //   504: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   507: ifeq            450
        //   510: aload           list$iv
        //   512: aload           e$iv
        //   514: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   517: pop            
        //   518: goto            450
        //   521: aload           list$iv
        //   523: checkcast       Ljava/util/List;
        //   526: astore_1        /* installedModules */
        //   527: aload_1         /* installedModules */
        //   528: checkcast       Ljava/lang/Iterable;
        //   531: astore_2       
        //   532: getstatic       com/chattriggers/ctjs/engine/module/ModuleUpdater.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;
        //   535: astore_3       
        //   536: iconst_0       
        //   537: istore          $i$f$forEach
        //   539: aload_2         /* $this$forEach$iv */
        //   540: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   545: astore          5
        //   547: aload           5
        //   549: invokeinterface java/util/Iterator.hasNext:()Z
        //   554: ifeq            585
        //   557: aload           5
        //   559: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   564: astore          element$iv
        //   566: aload           element$iv
        //   568: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   571: astore          p0
        //   573: iconst_0       
        //   574: istore          $i$a$-forEach-ModuleManager$setup$1
        //   576: aload_3        
        //   577: aload           p0
        //   579: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleUpdater.updateModule:(Lcom/chattriggers/ctjs/engine/module/Module;)V
        //   582: goto            547
        //   585: nop            
        //   586: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.cachedModules:Ljava/util/List;
        //   589: aload_1         /* installedModules */
        //   590: checkcast       Ljava/util/Collection;
        //   593: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   598: pop            
        //   599: aload_1         /* installedModules */
        //   600: checkcast       Ljava/lang/Iterable;
        //   603: invokestatic    kotlin/collections/CollectionsKt.distinct:(Ljava/lang/Iterable;)Ljava/util/List;
        //   606: checkcast       Ljava/lang/Iterable;
        //   609: astore_2        /* $this$forEach$iv */
        //   610: iconst_0       
        //   611: istore_3        /* $i$f$forEach */
        //   612: aload_2         /* $this$forEach$iv */
        //   613: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   618: astore          4
        //   620: aload           4
        //   622: invokeinterface java/util/Iterator.hasNext:()Z
        //   627: ifeq            733
        //   630: aload           4
        //   632: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   637: astore          element$iv
        //   639: aload           element$iv
        //   641: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   644: astore          module
        //   646: iconst_0       
        //   647: istore          $i$a$-forEach-ModuleManager$setup$2
        //   649: aload           module
        //   651: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   654: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getRequires:()Ljava/util/ArrayList;
        //   657: dup            
        //   658: ifnonnull       665
        //   661: pop            
        //   662: goto            729
        //   665: checkcast       Ljava/lang/Iterable;
        //   668: astore          $this$forEach$iv
        //   670: iconst_0       
        //   671: istore          $i$f$forEach
        //   673: aload           $this$forEach$iv
        //   675: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   680: astore          11
        //   682: aload           11
        //   684: invokeinterface java/util/Iterator.hasNext:()Z
        //   689: ifeq            728
        //   692: aload           11
        //   694: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   699: astore          element$iv
        //   701: aload           element$iv
        //   703: checkcast       Ljava/lang/String;
        //   706: astore          it
        //   708: iconst_0       
        //   709: istore          $i$a$-forEach-ModuleManager$setup$2$1
        //   711: getstatic       com/chattriggers/ctjs/engine/module/ModuleUpdater.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleUpdater;
        //   714: aload           it
        //   716: aload           module
        //   718: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getName:()Ljava/lang/String;
        //   721: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleUpdater.importModule:(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
        //   724: pop            
        //   725: goto            682
        //   728: nop            
        //   729: nop            
        //   730: goto            620
        //   733: nop            
        //   734: aload_0         /* this */
        //   735: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.cachedModules:Ljava/util/List;
        //   738: invokespecial   com/chattriggers/ctjs/engine/module/ModuleManager.loadAssetsAndJars:(Ljava/util/List;)V
        //   741: getstatic       com/chattriggers/ctjs/launch/IndySupport.INSTANCE:Lcom/chattriggers/ctjs/launch/IndySupport;
        //   744: iconst_1       
        //   745: invokevirtual   com/chattriggers/ctjs/launch/IndySupport.invalidateInvocations:(Z)V
        //   748: return         
        //    StackMapTable: 00 13 3E 41 07 00 73 FE 00 2F 07 00 73 07 00 63 07 00 73 40 01 20 FF 00 97 00 01 07 00 02 00 01 07 00 61 FC 00 09 07 00 04 FF 00 33 00 08 07 00 02 07 00 04 07 01 13 01 07 01 13 07 01 20 01 07 01 26 00 00 32 FF 00 26 00 08 07 00 02 07 00 04 07 01 13 01 07 01 38 07 01 15 07 01 26 07 00 04 00 00 FB 00 46 FF 00 19 00 08 07 00 02 07 01 36 07 01 13 07 01 08 01 07 01 26 07 00 04 07 00 04 00 00 25 FF 00 22 00 07 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 00 04 00 00 FF 00 2C 00 08 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 01 3C 01 00 01 07 01 15 FF 00 10 00 0C 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 01 3C 01 00 07 01 13 01 07 01 26 00 00 2D FF 00 00 00 08 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 01 3C 01 00 00 FF 00 03 00 07 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 00 04 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  7      295    298    308    Ljava/lang/Exception;
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
    
    private final void loadAssetsAndJars(final List<Module> modules) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* modules */
        //     2: invokespecial   com/chattriggers/ctjs/engine/module/ModuleManager.loadAssets:(Ljava/util/List;)V
        //     5: aload_1         /* modules */
        //     6: checkcast       Ljava/lang/Iterable;
        //     9: astore_2        /* $this$forEach$iv */
        //    10: iconst_0       
        //    11: istore_3        /* $i$f$forEach */
        //    12: aload_2         /* $this$forEach$iv */
        //    13: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    18: astore          4
        //    20: aload           4
        //    22: invokeinterface java/util/Iterator.hasNext:()Z
        //    27: ifeq            109
        //    30: aload           4
        //    32: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    37: astore          element$iv
        //    39: aload           element$iv
        //    41: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //    44: astore          it
        //    46: iconst_0       
        //    47: istore          $i$a$-forEach-ModuleManager$loadAssetsAndJars$1
        //    49: aload           it
        //    51: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //    54: aload           it
        //    56: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //    59: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getEntry:()Ljava/lang/String;
        //    62: dup            
        //    63: ifnonnull       71
        //    66: pop            
        //    67: aconst_null    
        //    68: goto            102
        //    71: bipush          47
        //    73: getstatic       java/io/File.separatorChar:C
        //    76: iconst_0       
        //    77: iconst_4       
        //    78: aconst_null    
        //    79: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;CCZILjava/lang/Object;)Ljava/lang/String;
        //    82: dup            
        //    83: ifnonnull       91
        //    86: pop            
        //    87: aconst_null    
        //    88: goto            102
        //    91: bipush          92
        //    93: getstatic       java/io/File.separatorChar:C
        //    96: iconst_0       
        //    97: iconst_4       
        //    98: aconst_null    
        //    99: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;CCZILjava/lang/Object;)Ljava/lang/String;
        //   102: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.setEntry:(Ljava/lang/String;)V
        //   105: nop            
        //   106: goto            20
        //   109: nop            
        //   110: aload_1         /* modules */
        //   111: checkcast       Ljava/lang/Iterable;
        //   114: astore_3        /* $this$map$iv */
        //   115: iconst_0       
        //   116: istore          $i$f$map
        //   118: aload_3         /* $this$map$iv */
        //   119: astore          5
        //   121: new             Ljava/util/ArrayList;
        //   124: dup            
        //   125: aload_3         /* $this$map$iv */
        //   126: bipush          10
        //   128: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   131: invokespecial   java/util/ArrayList.<init>:(I)V
        //   134: checkcast       Ljava/util/Collection;
        //   137: astore          destination$iv$iv
        //   139: iconst_0       
        //   140: istore          $i$f$mapTo
        //   142: aload           $this$mapTo$iv$iv
        //   144: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   149: astore          8
        //   151: aload           8
        //   153: invokeinterface java/util/Iterator.hasNext:()Z
        //   158: ifeq            231
        //   161: aload           8
        //   163: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   168: astore          item$iv$iv
        //   170: aload           destination$iv$iv
        //   172: aload           item$iv$iv
        //   174: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   177: astore          10
        //   179: astore          12
        //   181: iconst_0       
        //   182: istore          $i$a$-map-ModuleManager$loadAssetsAndJars$jars$1
        //   184: aload           module
        //   186: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //   189: aconst_null    
        //   190: iconst_1       
        //   191: aconst_null    
        //   192: invokestatic    kotlin/io/FilesKt.walk$default:(Ljava/io/File;Lkotlin/io/FileWalkDirection;ILjava/lang/Object;)Lkotlin/io/FileTreeWalk;
        //   195: checkcast       Lkotlin/sequences/Sequence;
        //   198: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager$loadAssetsAndJars$jars$1$1.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager$loadAssetsAndJars$jars$1$1;
        //   201: checkcast       Lkotlin/jvm/functions/Function1;
        //   204: invokestatic    kotlin/sequences/SequencesKt.filter:(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
        //   207: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager$loadAssetsAndJars$jars$1$2.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager$loadAssetsAndJars$jars$1$2;
        //   210: checkcast       Lkotlin/jvm/functions/Function1;
        //   213: invokestatic    kotlin/sequences/SequencesKt.map:(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
        //   216: invokestatic    kotlin/sequences/SequencesKt.toList:(Lkotlin/sequences/Sequence;)Ljava/util/List;
        //   219: aload           12
        //   221: swap           
        //   222: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   227: pop            
        //   228: goto            151
        //   231: aload           destination$iv$iv
        //   233: checkcast       Ljava/util/List;
        //   236: nop            
        //   237: checkcast       Ljava/lang/Iterable;
        //   240: invokestatic    kotlin/collections/CollectionsKt.flatten:(Ljava/lang/Iterable;)Ljava/util/List;
        //   243: astore_2        /* jars */
        //   244: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.loaders:Ljava/util/List;
        //   247: checkcast       Ljava/lang/Iterable;
        //   250: astore_3        /* $this$forEach$iv */
        //   251: iconst_0       
        //   252: istore          $i$f$forEach
        //   254: aload_3         /* $this$forEach$iv */
        //   255: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   260: astore          5
        //   262: aload           5
        //   264: invokeinterface java/util/Iterator.hasNext:()Z
        //   269: ifeq            301
        //   272: aload           5
        //   274: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   279: astore          element$iv
        //   281: aload           element$iv
        //   283: checkcast       Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;
        //   286: astore          it
        //   288: iconst_0       
        //   289: istore          $i$a$-forEach-ModuleManager$loadAssetsAndJars$2
        //   291: aload           it
        //   293: aload_2         /* jars */
        //   294: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSLoader.setup:(Ljava/util/List;)V
        //   297: nop            
        //   298: goto            262
        //   301: nop            
        //   302: return         
        //    Signature:
        //  (Ljava/util/List<Lcom/chattriggers/ctjs/engine/module/Module;>;)V
        //    StackMapTable: 00 09 FE 00 14 07 01 13 01 07 01 26 FF 00 32 00 08 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 01 3C 01 00 02 07 01 5F 07 00 73 FF 00 13 00 08 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 01 3C 01 00 02 07 01 5F 07 00 73 FF 00 0A 00 08 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 07 01 3C 01 00 02 07 01 5F 07 00 73 F8 00 06 FF 00 29 00 09 07 00 02 07 01 36 07 01 13 07 01 13 01 07 01 13 07 01 20 01 07 01 26 00 00 FB 00 4F FF 00 1E 00 07 07 00 02 07 01 36 07 01 36 07 01 13 01 07 01 26 07 00 04 00 00 26
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
    
    public final void asmPass() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: checkcast       Ljava/lang/Iterable;
        //     6: astore_1        /* $this$forEach$iv */
        //     7: iconst_0       
        //     8: istore_2        /* $i$f$forEach */
        //     9: aload_1         /* $this$forEach$iv */
        //    10: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    15: astore_3       
        //    16: aload_3        
        //    17: invokeinterface java/util/Iterator.hasNext:()Z
        //    22: ifeq            53
        //    25: aload_3        
        //    26: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    31: astore          element$iv
        //    33: aload           element$iv
        //    35: checkcast       Lcom/chattriggers/ctjs/engine/ILoader;
        //    38: astore          p0
        //    40: iconst_0       
        //    41: istore          $i$a$-forEach-ModuleManager$asmPass$1
        //    43: aload           p0
        //    45: invokeinterface com/chattriggers/ctjs/engine/ILoader.asmSetup:()V
        //    50: goto            16
        //    53: nop            
        //    54: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.loaders:Ljava/util/List;
        //    57: checkcast       Ljava/lang/Iterable;
        //    60: astore_1        /* $this$forEach$iv */
        //    61: iconst_0       
        //    62: istore_2        /* $i$f$forEach */
        //    63: aload_1         /* $this$forEach$iv */
        //    64: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    69: astore_3       
        //    70: aload_3        
        //    71: invokeinterface java/util/Iterator.hasNext:()Z
        //    76: ifeq            348
        //    79: aload_3        
        //    80: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    85: astore          element$iv
        //    87: aload           element$iv
        //    89: checkcast       Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;
        //    92: astore          loader
        //    94: iconst_0       
        //    95: istore          $i$a$-forEach-ModuleManager$asmPass$2
        //    97: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //   100: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleManager.getCachedModules:()Ljava/util/List;
        //   103: checkcast       Ljava/lang/Iterable;
        //   106: astore          $this$filter$iv
        //   108: iconst_0       
        //   109: istore          $i$f$filter
        //   111: aload           $this$filter$iv
        //   113: astore          9
        //   115: new             Ljava/util/ArrayList;
        //   118: dup            
        //   119: invokespecial   java/util/ArrayList.<init>:()V
        //   122: checkcast       Ljava/util/Collection;
        //   125: astore          destination$iv$iv
        //   127: iconst_0       
        //   128: istore          $i$f$filterTo
        //   130: aload           $this$filterTo$iv$iv
        //   132: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   137: astore          12
        //   139: aload           12
        //   141: invokeinterface java/util/Iterator.hasNext:()Z
        //   146: ifeq            240
        //   149: aload           12
        //   151: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   156: astore          element$iv$iv
        //   158: aload           element$iv$iv
        //   160: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   163: astore          it
        //   165: iconst_0       
        //   166: istore          $i$a$-filter-ModuleManager$asmPass$2$1
        //   168: aload           it
        //   170: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //   173: aload           it
        //   175: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   178: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getAsmEntry:()Ljava/lang/String;
        //   181: dup            
        //   182: ifnonnull       195
        //   185: pop            
        //   186: iconst_0       
        //   187: istore          16
        //   189: pop            
        //   190: iload           16
        //   192: goto            224
        //   195: astore          17
        //   197: astore          18
        //   199: new             Ljava/io/File;
        //   202: dup            
        //   203: aload           18
        //   205: aload           17
        //   207: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   210: invokestatic    kotlin/io/FilesKt.getExtension:(Ljava/io/File;)Ljava/lang/String;
        //   213: aload           loader
        //   215: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSLoader.getLanguage:()Lcom/chattriggers/ctjs/engine/langs/Lang;
        //   218: invokevirtual   com/chattriggers/ctjs/engine/langs/Lang.getExtension:()Ljava/lang/String;
        //   221: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   224: ifeq            139
        //   227: aload           destination$iv$iv
        //   229: aload           element$iv$iv
        //   231: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   236: pop            
        //   237: goto            139
        //   240: aload           destination$iv$iv
        //   242: checkcast       Ljava/util/List;
        //   245: nop            
        //   246: checkcast       Ljava/lang/Iterable;
        //   249: astore          7
        //   251: nop            
        //   252: iconst_0       
        //   253: istore          $i$f$forEach
        //   255: aload           $this$forEach$iv
        //   257: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   262: astore          9
        //   264: aload           9
        //   266: invokeinterface java/util/Iterator.hasNext:()Z
        //   271: ifeq            343
        //   274: aload           9
        //   276: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   281: astore          element$iv
        //   283: aload           element$iv
        //   285: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   288: astore          it
        //   290: iconst_0       
        //   291: istore          $i$a$-forEach-ModuleManager$asmPass$2$2
        //   293: aload           loader
        //   295: aload           it
        //   297: new             Ljava/io/File;
        //   300: dup            
        //   301: aload           it
        //   303: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //   306: aload           it
        //   308: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   311: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getAsmEntry:()Ljava/lang/String;
        //   314: dup            
        //   315: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //   318: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   321: invokevirtual   java/io/File.toURI:()Ljava/net/URI;
        //   324: astore          13
        //   326: aload           13
        //   328: ldc_w           "File(it.folder, it.metadata.asmEntry!!).toURI()"
        //   331: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   334: aload           13
        //   336: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSLoader.asmPass:(Lcom/chattriggers/ctjs/engine/module/Module;Ljava/net/URI;)V
        //   339: nop            
        //   340: goto            264
        //   343: nop            
        //   344: nop            
        //   345: goto            70
        //   348: nop            
        //   349: return         
        //    StackMapTable: 00 0A FE 00 10 07 01 13 01 07 01 26 24 10 FF 00 44 00 0D 07 00 02 07 01 13 01 07 01 26 07 00 04 07 01 CE 01 07 01 13 01 07 01 13 07 01 20 01 07 01 26 00 00 FF 00 37 00 10 07 00 02 07 01 13 01 07 01 26 07 00 04 07 01 CE 01 07 01 13 01 07 01 13 07 01 20 01 07 01 26 07 00 04 07 01 3C 01 00 02 07 00 63 07 00 73 5C 01 F8 00 0F FF 00 17 00 0B 07 00 02 07 01 13 01 07 01 26 07 00 04 07 01 CE 01 07 01 13 01 07 01 26 07 00 04 00 00 FB 00 4E FF 00 04 00 04 07 00 02 07 01 13 01 07 01 26 00 00
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
    
    public final void entryPass(@NotNull final List<Module> modules, @NotNull final Function1<? super Float, Unit> completionListener) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "modules"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2         /* completionListener */
        //     8: ldc_w           "completionListener"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.loaders:Ljava/util/List;
        //    17: checkcast       Ljava/lang/Iterable;
        //    20: astore_3        /* $this$forEach$iv */
        //    21: iconst_0       
        //    22: istore          $i$f$forEach
        //    24: aload_3         /* $this$forEach$iv */
        //    25: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    30: astore          5
        //    32: aload           5
        //    34: invokeinterface java/util/Iterator.hasNext:()Z
        //    39: ifeq            71
        //    42: aload           5
        //    44: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    49: astore          element$iv
        //    51: aload           element$iv
        //    53: checkcast       Lcom/chattriggers/ctjs/engine/ILoader;
        //    56: astore          p0
        //    58: iconst_0       
        //    59: istore          $i$a$-forEach-ModuleManager$entryPass$2
        //    61: aload           p0
        //    63: invokeinterface com/chattriggers/ctjs/engine/ILoader.entrySetup:()V
        //    68: goto            32
        //    71: nop            
        //    72: aload_1         /* modules */
        //    73: checkcast       Ljava/lang/Iterable;
        //    76: astore          $this$count$iv
        //    78: iconst_0       
        //    79: istore          $i$f$count
        //    81: aload           $this$count$iv
        //    83: instanceof      Ljava/util/Collection;
        //    86: ifeq            106
        //    89: aload           $this$count$iv
        //    91: checkcast       Ljava/util/Collection;
        //    94: invokeinterface java/util/Collection.isEmpty:()Z
        //    99: ifeq            106
        //   102: iconst_0       
        //   103: goto            182
        //   106: iconst_0       
        //   107: istore          count$iv
        //   109: aload           $this$count$iv
        //   111: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   116: astore          7
        //   118: aload           7
        //   120: invokeinterface java/util/Iterator.hasNext:()Z
        //   125: ifeq            180
        //   128: aload           7
        //   130: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   135: astore          element$iv
        //   137: aload           element$iv
        //   139: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   142: astore          it
        //   144: iconst_0       
        //   145: istore          $i$a$-count-ModuleManager$entryPass$total$1
        //   147: aload           it
        //   149: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   152: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getEntry:()Ljava/lang/String;
        //   155: ifnull          162
        //   158: iconst_1       
        //   159: goto            163
        //   162: iconst_0       
        //   163: ifeq            118
        //   166: iinc            count$iv, 1
        //   169: iload           count$iv
        //   171: ifge            118
        //   174: invokestatic    kotlin/collections/CollectionsKt.throwCountOverflow:()V
        //   177: goto            118
        //   180: iload           count$iv
        //   182: istore_3        /* total */
        //   183: iconst_0       
        //   184: istore          completed
        //   186: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.loaders:Ljava/util/List;
        //   189: checkcast       Ljava/lang/Iterable;
        //   192: astore          $this$forEach$iv
        //   194: iconst_0       
        //   195: istore          $i$f$forEach
        //   197: aload           $this$forEach$iv
        //   199: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   204: astore          7
        //   206: aload           7
        //   208: invokeinterface java/util/Iterator.hasNext:()Z
        //   213: ifeq            507
        //   216: aload           7
        //   218: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   223: astore          element$iv
        //   225: aload           element$iv
        //   227: checkcast       Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;
        //   230: astore          loader
        //   232: iconst_0       
        //   233: istore          $i$a$-forEach-ModuleManager$entryPass$3
        //   235: aload_1         /* modules */
        //   236: checkcast       Ljava/lang/Iterable;
        //   239: astore          $this$filter$iv
        //   241: iconst_0       
        //   242: istore          $i$f$filter
        //   244: aload           $this$filter$iv
        //   246: astore          13
        //   248: new             Ljava/util/ArrayList;
        //   251: dup            
        //   252: invokespecial   java/util/ArrayList.<init>:()V
        //   255: checkcast       Ljava/util/Collection;
        //   258: astore          destination$iv$iv
        //   260: iconst_0       
        //   261: istore          $i$f$filterTo
        //   263: aload           $this$filterTo$iv$iv
        //   265: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   270: astore          16
        //   272: aload           16
        //   274: invokeinterface java/util/Iterator.hasNext:()Z
        //   279: ifeq            373
        //   282: aload           16
        //   284: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   289: astore          element$iv$iv
        //   291: aload           element$iv$iv
        //   293: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   296: astore          it
        //   298: iconst_0       
        //   299: istore          $i$a$-filter-ModuleManager$entryPass$3$1
        //   301: aload           it
        //   303: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //   306: aload           it
        //   308: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   311: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getEntry:()Ljava/lang/String;
        //   314: dup            
        //   315: ifnonnull       328
        //   318: pop            
        //   319: iconst_0       
        //   320: istore          20
        //   322: pop            
        //   323: iload           20
        //   325: goto            357
        //   328: astore          21
        //   330: astore          22
        //   332: new             Ljava/io/File;
        //   335: dup            
        //   336: aload           22
        //   338: aload           21
        //   340: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   343: invokestatic    kotlin/io/FilesKt.getExtension:(Ljava/io/File;)Ljava/lang/String;
        //   346: aload           loader
        //   348: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSLoader.getLanguage:()Lcom/chattriggers/ctjs/engine/langs/Lang;
        //   351: invokevirtual   com/chattriggers/ctjs/engine/langs/Lang.getExtension:()Ljava/lang/String;
        //   354: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   357: ifeq            272
        //   360: aload           destination$iv$iv
        //   362: aload           element$iv$iv
        //   364: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   369: pop            
        //   370: goto            272
        //   373: aload           destination$iv$iv
        //   375: checkcast       Ljava/util/List;
        //   378: nop            
        //   379: checkcast       Ljava/lang/Iterable;
        //   382: astore          11
        //   384: nop            
        //   385: iconst_0       
        //   386: istore          $i$f$forEach
        //   388: aload           $this$forEach$iv
        //   390: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   395: astore          13
        //   397: aload           13
        //   399: invokeinterface java/util/Iterator.hasNext:()Z
        //   404: ifeq            502
        //   407: aload           13
        //   409: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   414: astore          element$iv
        //   416: aload           element$iv
        //   418: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //   421: astore          it
        //   423: iconst_0       
        //   424: istore          $i$a$-forEach-ModuleManager$entryPass$3$2
        //   426: aload           loader
        //   428: aload           it
        //   430: new             Ljava/io/File;
        //   433: dup            
        //   434: aload           it
        //   436: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //   439: aload           it
        //   441: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getMetadata:()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;
        //   444: invokevirtual   com/chattriggers/ctjs/engine/module/ModuleMetadata.getEntry:()Ljava/lang/String;
        //   447: dup            
        //   448: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //   451: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   454: invokevirtual   java/io/File.toURI:()Ljava/net/URI;
        //   457: astore          17
        //   459: aload           17
        //   461: ldc_w           "File(it.folder, it.metadata.entry!!).toURI()"
        //   464: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   467: aload           17
        //   469: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSLoader.entryPass:(Lcom/chattriggers/ctjs/engine/module/Module;Ljava/net/URI;)V
        //   472: iload           completed
        //   474: istore          17
        //   476: iload           17
        //   478: iconst_1       
        //   479: iadd           
        //   480: istore          completed
        //   482: aload_2         /* completionListener */
        //   483: iload           completed
        //   485: i2f            
        //   486: iload_3         /* total */
        //   487: i2f            
        //   488: fdiv           
        //   489: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
        //   492: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   497: pop            
        //   498: nop            
        //   499: goto            397
        //   502: nop            
        //   503: nop            
        //   504: goto            206
        //   507: nop            
        //   508: return         
        //    Signature:
        //  (Ljava/util/List<Lcom/chattriggers/ctjs/engine/module/Module;>;Lkotlin/jvm/functions/Function1<-Ljava/lang/Float;Lkotlin/Unit;>;)V
        //    StackMapTable: 00 10 FE 00 20 07 01 13 01 07 01 26 26 FF 00 22 00 06 07 00 02 07 01 36 07 01 B7 07 01 13 07 01 13 01 00 00 FD 00 0B 01 07 01 26 FE 00 2B 07 00 04 07 01 3C 01 40 01 F8 00 10 FF 00 01 00 06 07 00 02 07 01 36 07 01 B7 07 01 13 07 01 13 01 00 01 01 FF 00 17 00 08 07 00 02 07 01 36 07 01 B7 01 01 07 01 13 01 07 01 26 00 00 FF 00 41 00 11 07 00 02 07 01 36 07 01 B7 01 01 07 01 13 01 07 01 26 07 00 04 07 01 CE 01 07 01 13 01 07 01 13 07 01 20 01 07 01 26 00 00 FF 00 37 00 14 07 00 02 07 01 36 07 01 B7 01 01 07 01 13 01 07 01 26 07 00 04 07 01 CE 01 07 01 13 01 07 01 13 07 01 20 01 07 01 26 07 00 04 07 01 3C 01 00 02 07 00 63 07 00 73 5C 01 F8 00 0F FF 00 17 00 0F 07 00 02 07 01 36 07 01 B7 01 01 07 01 13 01 07 01 26 07 00 04 07 01 CE 01 07 01 13 01 07 01 26 07 00 04 00 00 FB 00 68 FF 00 04 00 08 07 00 02 07 01 36 07 01 B7 01 01 07 01 13 01 07 01 26 00 00
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
    
    public static /* synthetic */ void entryPass$default(final ModuleManager moduleManager, List cachedModules, Function1 completionListener, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            cachedModules = ModuleManager.cachedModules;
        }
        if ((n & 0x2) != 0x0) {
            completionListener = (Function1)ModuleManager$entryPass.ModuleManager$entryPass$1.INSTANCE;
        }
        moduleManager.entryPass(cachedModules, (Function1<? super Float, Unit>)completionListener);
    }
    
    @NotNull
    public final MethodHandle asmInvokeLookup(@NotNull final String moduleName, @NotNull final String functionID) {
        Intrinsics.checkNotNullParameter((Object)moduleName, "moduleName");
        Intrinsics.checkNotNullParameter((Object)functionID, "functionID");
        final Iterable $this$first$iv = ModuleManager.cachedModules;
        final int $i$f$first = 0;
        for (final Object element$iv : $this$first$iv) {
            final Module it = (Module)element$iv;
            final int n = 0;
            if (Intrinsics.areEqual((Object)it.getName(), (Object)moduleName)) {
                final Module module = (Module)element$iv;
                final Map<String, String> asmExposedFunctions = module.getMetadata().getAsmExposedFunctions();
                final String s = (asmExposedFunctions == null) ? null : asmExposedFunctions.get(functionID);
                if (s == null) {
                    throw new IllegalArgumentException("Module " + module + " contains no asm exported function with id " + functionID);
                }
                final String funcPath = s;
                final File funcFile = new File(module.getFolder(), StringsKt.replace$default(StringsKt.replace$default(funcPath, '/', File.separatorChar, false, 4, (Object)null), '\\', File.separatorChar, false, 4, (Object)null));
                final Iterable $this$first$iv2 = ModuleManager.loaders;
                final int $i$f$first2 = 0;
                for (final Object element$iv2 : $this$first$iv2) {
                    final JSLoader it2 = (JSLoader)element$iv2;
                    final int n2 = 0;
                    if (Intrinsics.areEqual((Object)it2.getLanguage().getExtension(), (Object)FilesKt.getExtension(funcFile))) {
                        final JSLoader jsLoader = (JSLoader)element$iv2;
                        final Module module2 = module;
                        final URI uri = funcFile.toURI();
                        Intrinsics.checkNotNullExpressionValue((Object)uri, "funcFile.toURI()");
                        return jsLoader.asmInvokeLookup(module2, uri);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
    
    private final List<File> getFoldersInDir(final File dir) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/io/File.isDirectory:()Z
        //     4: ifne            11
        //     7: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    10: areturn        
        //    11: aload_1         /* dir */
        //    12: invokevirtual   java/io/File.listFiles:()[Ljava/io/File;
        //    15: dup            
        //    16: ifnonnull       24
        //    19: pop            
        //    20: aconst_null    
        //    21: goto            105
        //    24: astore_3        /* $this$filter$iv */
        //    25: iconst_0       
        //    26: istore          $i$f$filter
        //    28: aload_3         /* $this$filter$iv */
        //    29: astore          5
        //    31: new             Ljava/util/ArrayList;
        //    34: dup            
        //    35: invokespecial   java/util/ArrayList.<init>:()V
        //    38: checkcast       Ljava/util/Collection;
        //    41: astore          destination$iv$iv
        //    43: iconst_0       
        //    44: istore          $i$f$filterTo
        //    46: iconst_0       
        //    47: istore          8
        //    49: aload           $this$filterTo$iv$iv
        //    51: arraylength    
        //    52: istore          9
        //    54: iload           8
        //    56: iload           9
        //    58: if_icmpge       99
        //    61: aload           $this$filterTo$iv$iv
        //    63: iload           8
        //    65: aaload         
        //    66: astore          element$iv$iv
        //    68: aload           element$iv$iv
        //    70: astore          it
        //    72: iconst_0       
        //    73: istore          $i$a$-filter-ModuleManager$getFoldersInDir$1
        //    75: aload           it
        //    77: invokevirtual   java/io/File.isDirectory:()Z
        //    80: ifeq            93
        //    83: aload           destination$iv$iv
        //    85: aload           element$iv$iv
        //    87: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    92: pop            
        //    93: iinc            8, 1
        //    96: goto            54
        //    99: aload           destination$iv$iv
        //   101: checkcast       Ljava/util/List;
        //   104: nop            
        //   105: astore_2       
        //   106: aload_2        
        //   107: ifnonnull       116
        //   110: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   113: goto            117
        //   116: aload_2        
        //   117: areturn        
        //    Signature:
        //  (Ljava/io/File;)Ljava/util/List<Ljava/io/File;>;
        //    StackMapTable: 00 08 0B 4C 07 02 68 FF 00 1D 00 0A 07 00 02 07 00 63 00 07 02 68 01 07 02 68 07 01 20 01 01 01 00 00 FE 00 26 07 00 63 07 00 63 01 F8 00 05 FF 00 05 00 02 07 00 02 07 00 63 00 01 07 01 36 FC 00 0A 07 01 36 40 07 01 36
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
    public final Module parseModule(@NotNull final File directory) {
        Intrinsics.checkNotNullParameter((Object)directory, "directory");
        final File metadataFile = new File(directory, "metadata.json");
        ModuleMetadata metadata = new ModuleMetadata(null, null, null, null, null, null, null, null, null, null, null, null, null, false, 16383, null);
        if (metadataFile.exists()) {
            try {
                final Object fromJson = CTJS.INSTANCE.getGson().fromJson(FileLib.read(metadataFile), (Class)ModuleMetadata.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "CTJS.gson.fromJson(FileL\u2026duleMetadata::class.java)");
                metadata = (ModuleMetadata)fromJson;
            }
            catch (Exception exception) {
                ReferenceKt.printToConsole$default("Module " + directory + " has invalid metadata.json", null, LogType.ERROR, 1, null);
            }
        }
        final String name = directory.getName();
        Intrinsics.checkNotNullExpressionValue((Object)name, "directory.name");
        return new Module(name, metadata, directory);
    }
    
    @NotNull
    public final ImportedModule importModule(@NotNull final String moduleName) {
        Intrinsics.checkNotNullParameter((Object)moduleName, "moduleName");
        final List newModules = ModuleUpdater.importModule$default(ModuleUpdater.INSTANCE, moduleName, null, 2, null);
        this.loadAssetsAndJars(newModules);
        entryPass$default(this, newModules, null, 2, null);
        return new ImportedModule((Module)CollectionsKt.getOrNull(newModules, 0), CollectionsKt.drop((Iterable)newModules, 1));
    }
    
    public final boolean deleteModule(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        while (true) {
            for (final Module next : ModuleManager.cachedModules) {
                final Module it = next;
                final int n = 0;
                final String lowerCase = it.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                final String lowerCase2 = name.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (Intrinsics.areEqual((Object)lowerCase, (Object)lowerCase2)) {
                    final Module module2 = next;
                    final Module module3 = module2;
                    if (module3 == null) {
                        return false;
                    }
                    final Module module = module3;
                    final File file = new File(ModuleManager.modulesFolder, module.getName());
                    if (!file.exists()) {
                        final int n2 = 0;
                        throw new IllegalStateException("Expected module to have an existing folder!".toString());
                    }
                    final Context context = JSContextFactory.INSTANCE.enterContext();
                    try {
                        final ClassLoader applicationClassLoader = context.getApplicationClassLoader();
                        if (applicationClassLoader == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.net.URLClassLoader");
                        }
                        final URLClassLoader classLoader = (URLClassLoader)applicationClassLoader;
                        classLoader.close();
                        if (FilesKt.deleteRecursively(file)) {
                            Reference.loadCT();
                            return true;
                        }
                    }
                    finally {
                        Context.exit();
                    }
                    return false;
                }
            }
            final Module module2 = null;
            continue;
        }
    }
    
    public final void tryReportOldVersion(@NotNull final Module module) {
        Intrinsics.checkNotNullParameter((Object)module, "module");
        if (World.isLoaded()) {
            this.reportOldVersion(module);
        }
        else {
            ModuleManager.pendingOldModules.add(module);
        }
    }
    
    public final void reportOldVersion(@NotNull final Module module) {
        Intrinsics.checkNotNullParameter((Object)module, "module");
        ChatLib.chat("&cWarning: the module \"" + module.getName() + "\" was made for an older version of CT, so it may not work correctly.");
    }
    
    private final void loadAssets(final List<Module> modules) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: checkcast       Ljava/lang/Iterable;
        //     4: astore_2        /* $this$map$iv */
        //     5: iconst_0       
        //     6: istore_3        /* $i$f$map */
        //     7: aload_2         /* $this$map$iv */
        //     8: astore          4
        //    10: new             Ljava/util/ArrayList;
        //    13: dup            
        //    14: aload_2         /* $this$map$iv */
        //    15: bipush          10
        //    17: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    20: invokespecial   java/util/ArrayList.<init>:(I)V
        //    23: checkcast       Ljava/util/Collection;
        //    26: astore          destination$iv$iv
        //    28: iconst_0       
        //    29: istore          $i$f$mapTo
        //    31: aload           $this$mapTo$iv$iv
        //    33: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    38: astore          7
        //    40: aload           7
        //    42: invokeinterface java/util/Iterator.hasNext:()Z
        //    47: ifeq            100
        //    50: aload           7
        //    52: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    57: astore          item$iv$iv
        //    59: aload           destination$iv$iv
        //    61: aload           item$iv$iv
        //    63: checkcast       Lcom/chattriggers/ctjs/engine/module/Module;
        //    66: astore          9
        //    68: astore          11
        //    70: iconst_0       
        //    71: istore          $i$a$-map-ModuleManager$loadAssets$1
        //    73: new             Ljava/io/File;
        //    76: dup            
        //    77: aload           it
        //    79: invokevirtual   com/chattriggers/ctjs/engine/module/Module.getFolder:()Ljava/io/File;
        //    82: ldc_w           "assets"
        //    85: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    88: aload           11
        //    90: swap           
        //    91: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    96: pop            
        //    97: goto            40
        //   100: aload           destination$iv$iv
        //   102: checkcast       Ljava/util/List;
        //   105: nop            
        //   106: checkcast       Ljava/lang/Iterable;
        //   109: astore_2       
        //   110: nop            
        //   111: iconst_0       
        //   112: istore_3        /* $i$f$filter */
        //   113: aload_2         /* $this$filter$iv */
        //   114: astore          4
        //   116: new             Ljava/util/ArrayList;
        //   119: dup            
        //   120: invokespecial   java/util/ArrayList.<init>:()V
        //   123: checkcast       Ljava/util/Collection;
        //   126: astore          destination$iv$iv
        //   128: iconst_0       
        //   129: istore          $i$f$filterTo
        //   131: aload           $this$filterTo$iv$iv
        //   133: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   138: astore          7
        //   140: aload           7
        //   142: invokeinterface java/util/Iterator.hasNext:()Z
        //   147: ifeq            206
        //   150: aload           7
        //   152: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   157: astore          element$iv$iv
        //   159: aload           element$iv$iv
        //   161: checkcast       Ljava/io/File;
        //   164: astore          it
        //   166: iconst_0       
        //   167: istore          $i$a$-filter-ModuleManager$loadAssets$2
        //   169: aload           it
        //   171: invokevirtual   java/io/File.exists:()Z
        //   174: ifeq            189
        //   177: aload           it
        //   179: invokevirtual   java/io/File.isFile:()Z
        //   182: ifne            189
        //   185: iconst_1       
        //   186: goto            190
        //   189: iconst_0       
        //   190: ifeq            140
        //   193: aload           destination$iv$iv
        //   195: aload           element$iv$iv
        //   197: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   202: pop            
        //   203: goto            140
        //   206: aload           destination$iv$iv
        //   208: checkcast       Ljava/util/List;
        //   211: nop            
        //   212: checkcast       Ljava/lang/Iterable;
        //   215: astore_2       
        //   216: nop            
        //   217: iconst_0       
        //   218: istore_3        /* $i$f$map */
        //   219: aload_2         /* $this$map$iv */
        //   220: astore          4
        //   222: new             Ljava/util/ArrayList;
        //   225: dup            
        //   226: aload_2         /* $this$map$iv */
        //   227: bipush          10
        //   229: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   232: invokespecial   java/util/ArrayList.<init>:(I)V
        //   235: checkcast       Ljava/util/Collection;
        //   238: astore          destination$iv$iv
        //   240: iconst_0       
        //   241: istore          $i$f$mapTo
        //   243: aload           $this$mapTo$iv$iv
        //   245: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   250: astore          7
        //   252: aload           7
        //   254: invokeinterface java/util/Iterator.hasNext:()Z
        //   259: ifeq            322
        //   262: aload           7
        //   264: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   269: astore          item$iv$iv
        //   271: aload           destination$iv$iv
        //   273: aload           item$iv$iv
        //   275: checkcast       Ljava/io/File;
        //   278: astore          9
        //   280: astore          11
        //   282: iconst_0       
        //   283: istore          $i$a$-map-ModuleManager$loadAssets$3
        //   285: aload           it
        //   287: invokevirtual   java/io/File.listFiles:()[Ljava/io/File;
        //   290: dup            
        //   291: ifnonnull       299
        //   294: pop            
        //   295: aconst_null    
        //   296: goto            302
        //   299: invokestatic    kotlin/collections/ArraysKt.toList:([Ljava/lang/Object;)Ljava/util/List;
        //   302: dup            
        //   303: ifnonnull       310
        //   306: pop            
        //   307: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   310: aload           11
        //   312: swap           
        //   313: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   318: pop            
        //   319: goto            252
        //   322: aload           destination$iv$iv
        //   324: checkcast       Ljava/util/List;
        //   327: nop            
        //   328: checkcast       Ljava/lang/Iterable;
        //   331: invokestatic    kotlin/collections/CollectionsKt.flatten:(Ljava/lang/Iterable;)Ljava/util/List;
        //   334: checkcast       Ljava/lang/Iterable;
        //   337: astore_2        /* $this$forEach$iv */
        //   338: iconst_0       
        //   339: istore_3        /* $i$f$forEach */
        //   340: aload_2         /* $this$forEach$iv */
        //   341: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   346: astore          4
        //   348: aload           4
        //   350: invokeinterface java/util/Iterator.hasNext:()Z
        //   355: ifeq            392
        //   358: aload           4
        //   360: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   365: astore          element$iv
        //   367: aload           element$iv
        //   369: checkcast       Ljava/io/File;
        //   372: astore          it
        //   374: iconst_0       
        //   375: istore          $i$a$-forEach-ModuleManager$loadAssets$4
        //   377: aload           it
        //   379: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //   382: invokevirtual   com/chattriggers/ctjs/CTJS.getAssetsDir:()Ljava/io/File;
        //   385: invokestatic    org/apache/commons/io/FileUtils.copyFileToDirectory:(Ljava/io/File;Ljava/io/File;)V
        //   388: nop            
        //   389: goto            348
        //   392: nop            
        //   393: return         
        //    Signature:
        //  (Ljava/util/List<Lcom/chattriggers/ctjs/engine/module/Module;>;)V
        //    StackMapTable: 00 0D FF 00 28 00 08 07 00 02 07 01 36 07 01 13 01 07 01 13 07 01 20 01 07 01 26 00 00 3B 27 FE 00 30 07 00 04 07 00 63 01 40 01 F8 00 0F 2D FF 00 2E 00 0C 07 00 02 07 01 36 07 01 13 01 07 01 13 07 01 20 01 07 01 26 07 00 04 07 00 63 01 07 01 20 00 01 07 02 68 42 07 01 36 47 07 01 36 FF 00 0B 00 08 07 00 02 07 01 36 07 01 13 01 07 01 13 07 01 20 01 07 01 26 00 00 FF 00 19 00 06 07 00 02 07 01 36 07 01 13 01 07 01 26 07 00 04 00 00 2B
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
    
    public final void teardown() {
        IndySupport.INSTANCE.invalidateInvocations(false);
        ModuleManager.cachedModules.clear();
        final Iterable $this$forEach$iv = ModuleManager.loaders;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final JSLoader it = (JSLoader)element$iv;
            final int n = 0;
            it.clearTriggers();
            if (Config.INSTANCE.getClearConsoleOnLoad()) {
                it.getConsole().clearConsole();
            }
        }
        if (Config.INSTANCE.getClearConsoleOnLoad()) {
            ModuleManager.generalConsole.clearConsole();
        }
    }
    
    public final void trigger(@NotNull final TriggerType type, @NotNull final Object[] arguments) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)arguments, "arguments");
        final Iterable $this$forEach$iv = ModuleManager.loaders;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final JSLoader it = (JSLoader)element$iv;
            final int n = 0;
            it.exec(type, arguments);
        }
    }
    
    @NotNull
    public final Console getConsole(@NotNull final String language) {
        Intrinsics.checkNotNullParameter((Object)language, "language");
        final Iterable $this$firstOrNull$iv = ModuleManager.loaders;
        final int $i$f$firstOrNull = 0;
        while (true) {
            for (final Object element$iv : $this$firstOrNull$iv) {
                final JSLoader it = (JSLoader)element$iv;
                final int n = 0;
                if (Intrinsics.areEqual((Object)it.getLanguage().getLangName(), (Object)language)) {
                    final Object o = element$iv;
                    final JSLoader jsLoader = (JSLoader)o;
                    final Console console = (jsLoader == null) ? null : jsLoader.getConsole();
                    return (console == null) ? ModuleManager.generalConsole : console;
                }
            }
            final Object o = null;
            continue;
        }
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   com/chattriggers/ctjs/engine/module/ModuleManager.<init>:()V
        //     7: putstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //    10: getstatic       com/chattriggers/ctjs/engine/langs/js/JSLoader.INSTANCE:Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;
        //    13: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //    16: putstatic       com/chattriggers/ctjs/engine/module/ModuleManager.loaders:Ljava/util/List;
        //    19: new             Lcom/chattriggers/ctjs/utils/console/Console;
        //    22: dup            
        //    23: aconst_null    
        //    24: invokespecial   com/chattriggers/ctjs/utils/console/Console.<init>:(Lcom/chattriggers/ctjs/engine/ILoader;)V
        //    27: putstatic       com/chattriggers/ctjs/engine/module/ModuleManager.generalConsole:Lcom/chattriggers/ctjs/utils/console/Console;
        //    30: new             Ljava/util/ArrayList;
        //    33: dup            
        //    34: invokespecial   java/util/ArrayList.<init>:()V
        //    37: checkcast       Ljava/util/List;
        //    40: putstatic       com/chattriggers/ctjs/engine/module/ModuleManager.cachedModules:Ljava/util/List;
        //    43: getstatic       com/chattriggers/ctjs/engine/module/ModuleManager.INSTANCE:Lcom/chattriggers/ctjs/engine/module/ModuleManager;
        //    46: astore_0        /* $this$modulesFolder_u24lambda_u2d1 */
        //    47: iconst_0       
        //    48: istore_1        /* $i$a$-run-ModuleManager$modulesFolder$1 */
        //    49: new             Ljava/io/File;
        //    52: dup            
        //    53: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //    56: invokevirtual   com/chattriggers/ctjs/CTJS.getConfigLocation:()Ljava/io/File;
        //    59: ldc_w           "ChatTriggers.toml"
        //    62: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    65: astore_2        /* configFile */
        //    66: aload_2         /* configFile */
        //    67: invokevirtual   java/io/File.exists:()Z
        //    70: ifeq            160
        //    73: nop            
        //    74: aload_2         /* configFile */
        //    75: invokestatic    gg/essential/vigilance/impl/nightconfig/core/file/FileConfig.of:(Ljava/io/File;)Lgg/essential/vigilance/impl/nightconfig/core/file/FileConfig;
        //    78: checkcast       Ljava/lang/AutoCloseable;
        //    81: astore_3       
        //    82: aconst_null    
        //    83: astore          4
        //    85: nop            
        //    86: aload_3        
        //    87: checkcast       Lgg/essential/vigilance/impl/nightconfig/core/file/FileConfig;
        //    90: astore          it
        //    92: iconst_0       
        //    93: istore          $i$a$-use-ModuleManager$modulesFolder$1$1
        //    95: aload           it
        //    97: invokeinterface gg/essential/vigilance/impl/nightconfig/core/file/FileConfig.load:()V
        //   102: new             Ljava/io/File;
        //   105: dup            
        //   106: aload           it
        //   108: ldc_w           "general.modules_folders"
        //   111: invokeinterface gg/essential/vigilance/impl/nightconfig/core/file/FileConfig.get:(Ljava/lang/String;)Ljava/lang/Object;
        //   116: checkcast       Ljava/lang/String;
        //   119: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   122: astore          7
        //   124: aload_3        
        //   125: aload           4
        //   127: invokestatic    kotlin/jdk7/AutoCloseableKt.closeFinally:(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
        //   130: aload           7
        //   132: goto            170
        //   135: astore          5
        //   137: aload           5
        //   139: astore          4
        //   141: aload           5
        //   143: athrow         
        //   144: astore          5
        //   146: aload_3        
        //   147: aload           4
        //   149: invokestatic    kotlin/jdk7/AutoCloseableKt.closeFinally:(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
        //   152: aload           5
        //   154: athrow         
        //   155: astore_3        /* e */
        //   156: aload_3         /* e */
        //   157: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   160: new             Ljava/io/File;
        //   163: dup            
        //   164: ldc_w           "./config/ChatTriggers/modules"
        //   167: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   170: nop            
        //   171: putstatic       com/chattriggers/ctjs/engine/module/ModuleManager.modulesFolder:Ljava/io/File;
        //   174: new             Ljava/util/ArrayList;
        //   177: dup            
        //   178: invokespecial   java/util/ArrayList.<init>:()V
        //   181: checkcast       Ljava/util/List;
        //   184: putstatic       com/chattriggers/ctjs/engine/module/ModuleManager.pendingOldModules:Ljava/util/List;
        //   187: return         
        //    StackMapTable: 00 05 FF 00 87 00 05 07 00 02 01 07 00 63 07 03 38 05 00 01 07 02 D5 FF 00 08 00 05 07 00 02 01 07 00 63 07 03 38 07 02 D5 00 01 07 02 D5 FF 00 0A 00 03 07 00 02 01 07 00 63 00 01 07 00 61 04 49 07 00 63
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  85     124    135    144    Ljava/lang/Throwable;
        //  85     124    144    155    Any
        //  135    144    144    155    Any
        //  144    146    144    155    Any
        //  73     155    155    160    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0170 (coming from #0154).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
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
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J%\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/ModuleManager$ImportedModule;", "", "module", "Lcom/chattriggers/ctjs/engine/module/Module;", "dependencies", "", "(Lcom/chattriggers/ctjs/engine/module/Module;Ljava/util/List;)V", "getDependencies", "()Ljava/util/List;", "getModule", "()Lcom/chattriggers/ctjs/engine/module/Module;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ctjs" })
    public static final class ImportedModule
    {
        @Nullable
        private final Module module;
        @NotNull
        private final List<Module> dependencies;
        
        public ImportedModule(@Nullable final Module module, @NotNull final List<Module> dependencies) {
            Intrinsics.checkNotNullParameter((Object)dependencies, "dependencies");
            this.module = module;
            this.dependencies = dependencies;
        }
        
        @Nullable
        public final Module getModule() {
            return this.module;
        }
        
        @NotNull
        public final List<Module> getDependencies() {
            return this.dependencies;
        }
        
        @Nullable
        public final Module component1() {
            return this.module;
        }
        
        @NotNull
        public final List<Module> component2() {
            return this.dependencies;
        }
        
        @NotNull
        public final ImportedModule copy(@Nullable final Module module, @NotNull final List<Module> dependencies) {
            Intrinsics.checkNotNullParameter((Object)dependencies, "dependencies");
            return new ImportedModule(module, dependencies);
        }
        
        @NotNull
        @Override
        public String toString() {
            return "ImportedModule(module=" + this.module + ", dependencies=" + this.dependencies + ')';
        }
        
        @Override
        public int hashCode() {
            int result = (this.module == null) ? 0 : this.module.hashCode();
            result = result * 31 + this.dependencies.hashCode();
            return result;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImportedModule)) {
                return false;
            }
            final ImportedModule importedModule = (ImportedModule)other;
            return Intrinsics.areEqual((Object)this.module, (Object)importedModule.module) && Intrinsics.areEqual((Object)this.dependencies, (Object)importedModule.dependencies);
        }
    }
}
