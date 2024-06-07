//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraftforge.event.world.*;
import kotlin.jvm.internal.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import net.minecraft.client.renderer.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import com.chattriggers.ctjs.*;
import com.chattriggers.ctjs.utils.console.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/utils/UpdateChecker;", "", "()V", "updateAvailable", "", "warned", "worldLoaded", "drawUpdateMessage", "", "getUpdate", "renderOverlay", "event", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;", "worldLoad", "Lnet/minecraftforge/event/world/WorldEvent$Load;", "ctjs" })
public final class UpdateChecker
{
    @NotNull
    public static final UpdateChecker INSTANCE;
    private static boolean worldLoaded;
    private static boolean updateAvailable;
    private static boolean warned;
    
    private UpdateChecker() {
    }
    
    private final void getUpdate() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   com/chattriggers/ctjs/CTJS.getGson:()Lcom/google/gson/Gson;
        //     6: ldc             "https://www.chattriggers.com/api/versions"
        //     8: aconst_null    
        //     9: iconst_2       
        //    10: aconst_null    
        //    11: invokestatic    com/chattriggers/ctjs/minecraft/libs/FileLib.getUrlContent$default:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
        //    14: new             Lcom/chattriggers/ctjs/utils/UpdateChecker$getUpdate$versions$1;
        //    17: dup            
        //    18: invokespecial   com/chattriggers/ctjs/utils/UpdateChecker$getUpdate$versions$1.<init>:()V
        //    21: invokevirtual   com/chattriggers/ctjs/utils/UpdateChecker$getUpdate$versions$1.getType:()Ljava/lang/reflect/Type;
        //    24: invokevirtual   com/google/gson/Gson.fromJson:(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //    27: checkcast       Ljava/util/Map;
        //    30: astore_1        /* versions */
        //    31: aload_1         /* versions */
        //    32: ldc             "versions"
        //    34: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    37: aload_1         /* versions */
        //    38: astore          $this$flatMap$iv
        //    40: iconst_0       
        //    41: istore          $i$f$flatMap
        //    43: aload           $this$flatMap$iv
        //    45: astore          6
        //    47: new             Ljava/util/ArrayList;
        //    50: dup            
        //    51: invokespecial   java/util/ArrayList.<init>:()V
        //    54: checkcast       Ljava/util/Collection;
        //    57: astore          destination$iv$iv
        //    59: iconst_0       
        //    60: istore          $i$f$flatMapTo
        //    62: aload           $this$flatMapTo$iv$iv
        //    64: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    69: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    74: astore          9
        //    76: aload           9
        //    78: invokeinterface java/util/Iterator.hasNext:()Z
        //    83: ifeq            259
        //    86: aload           9
        //    88: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    93: checkcast       Ljava/util/Map$Entry;
        //    96: astore          element$iv$iv
        //    98: aload           element$iv$iv
        //   100: astore          entry
        //   102: iconst_0       
        //   103: istore          $i$a$-flatMap-UpdateChecker$getUpdate$latestVersion$1
        //   105: aload           entry
        //   107: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   112: checkcast       Ljava/lang/Iterable;
        //   115: astore          $this$map$iv
        //   117: iconst_0       
        //   118: istore          $i$f$map
        //   120: aload           $this$map$iv
        //   122: astore          15
        //   124: new             Ljava/util/ArrayList;
        //   127: dup            
        //   128: aload           $this$map$iv
        //   130: bipush          10
        //   132: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   135: invokespecial   java/util/ArrayList.<init>:(I)V
        //   138: checkcast       Ljava/util/Collection;
        //   141: astore          destination$iv$iv
        //   143: iconst_0       
        //   144: istore          $i$f$mapTo
        //   146: aload           $this$mapTo$iv$iv
        //   148: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   153: astore          18
        //   155: aload           18
        //   157: invokeinterface java/util/Iterator.hasNext:()Z
        //   162: ifeq            236
        //   165: aload           18
        //   167: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   172: astore          item$iv$iv
        //   174: aload           destination$iv$iv
        //   176: aload           item$iv$iv
        //   178: checkcast       Ljava/lang/String;
        //   181: astore          20
        //   183: astore          21
        //   185: iconst_0       
        //   186: istore          $i$a$-map-UpdateChecker$getUpdate$latestVersion$1$1
        //   188: new             Ljava/lang/StringBuilder;
        //   191: dup            
        //   192: invokespecial   java/lang/StringBuilder.<init>:()V
        //   195: aload           entry
        //   197: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   202: checkcast       Ljava/lang/String;
        //   205: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   208: bipush          46
        //   210: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   213: aload           it
        //   215: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   218: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   221: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.toVersion:(Ljava/lang/String;)Lcom/fasterxml/jackson/core/Version;
        //   224: aload           21
        //   226: swap           
        //   227: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   232: pop            
        //   233: goto            155
        //   236: aload           destination$iv$iv
        //   238: checkcast       Ljava/util/List;
        //   241: nop            
        //   242: nop            
        //   243: checkcast       Ljava/lang/Iterable;
        //   246: astore          list$iv$iv
        //   248: aload           destination$iv$iv
        //   250: aload           list$iv$iv
        //   252: invokestatic    kotlin/collections/CollectionsKt.addAll:(Ljava/util/Collection;Ljava/lang/Iterable;)Z
        //   255: pop            
        //   256: goto            76
        //   259: aload           destination$iv$iv
        //   261: checkcast       Ljava/util/List;
        //   264: nop            
        //   265: checkcast       Ljava/lang/Iterable;
        //   268: invokestatic    kotlin/collections/CollectionsKt.maxOrNull:(Ljava/lang/Iterable;)Ljava/lang/Comparable;
        //   271: checkcast       Lcom/fasterxml/jackson/core/Version;
        //   274: astore_3       
        //   275: aload_3        
        //   276: ifnonnull       280
        //   279: return         
        //   280: aload_3        
        //   281: astore_2        /* latestVersion */
        //   282: aload_2         /* latestVersion */
        //   283: ldc             "2.2.0"
        //   285: invokestatic    com/chattriggers/ctjs/utils/kotlin/ExtensionsKt.toVersion:(Ljava/lang/String;)Lcom/fasterxml/jackson/core/Version;
        //   288: invokevirtual   com/fasterxml/jackson/core/Version.compareTo:(Lcom/fasterxml/jackson/core/Version;)I
        //   291: ifle            298
        //   294: iconst_1       
        //   295: goto            299
        //   298: iconst_0       
        //   299: putstatic       com/chattriggers/ctjs/utils/UpdateChecker.updateAvailable:Z
        //   302: return         
        //    StackMapTable: 00 07 FF 00 4C 00 0A 07 00 02 07 00 45 00 00 07 00 45 01 07 00 45 07 00 52 01 07 00 5E 00 00 FF 00 4E 00 13 07 00 02 07 00 45 00 00 07 00 45 01 07 00 45 07 00 52 01 07 00 5E 07 00 68 07 00 68 01 07 00 6D 01 07 00 6D 07 00 52 01 07 00 5E 00 00 FB 00 50 FF 00 16 00 0A 07 00 02 07 00 45 00 00 07 00 45 01 07 00 45 07 00 52 01 07 00 5E 00 00 FF 00 14 00 0A 07 00 02 07 00 45 00 07 00 A0 07 00 45 01 07 00 45 07 00 52 01 07 00 5E 00 00 FF 00 11 00 0A 07 00 02 07 00 45 07 00 A0 07 00 A0 07 00 45 01 07 00 45 07 00 52 01 07 00 5E 00 00 40 01
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SubscribeEvent
    public final void worldLoad(@NotNull final WorldEvent$Load event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        UpdateChecker.worldLoaded = true;
    }
    
    @SubscribeEvent
    public final void renderOverlay(@NotNull final RenderGameOverlayEvent$Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (!UpdateChecker.worldLoaded) {
            return;
        }
        UpdateChecker.worldLoaded = false;
        if (!UpdateChecker.updateAvailable || UpdateChecker.warned) {
            return;
        }
        World.playSound("note.bass", 1000.0f, 1.0f);
        new Message(new Object[] { Intrinsics.stringPlus("&c&m", (Object)ChatLib.getChatBreak("-")), "\n", "&cChatTriggers requires an update to work properly!", "\n", new TextComponent("&a[Download]").setClick("open_url", "https://www.chattriggers.com/#download"), " ", new TextComponent("&e[Changelog]").setClick("open_url", "https://github.com/ChatTriggers/ChatTriggers/releases"), "\n", Intrinsics.stringPlus("&c&m", (Object)ChatLib.getChatBreak("-")) }).chat();
        UpdateChecker.warned = true;
    }
    
    public final void drawUpdateMessage() {
        if (!UpdateChecker.updateAvailable) {
            return;
        }
        GlStateManager.pushMatrix();
        Renderer.getFontRenderer().drawString(ChatLib.addColor("&cChatTriggers requires an update to work properly!"), 2.0f, 2.0f, -1, false);
        GlStateManager.popMatrix();
    }
    
    static {
        INSTANCE = new UpdateChecker();
        try {
            UpdateChecker.INSTANCE.getUpdate();
        }
        catch (Exception exception) {
            ReferenceKt.printTraceToConsole$default((Throwable)exception, (Console)null, 1, (Object)null);
        }
        final UpdateChecker instance = UpdateChecker.INSTANCE;
        UpdateChecker.warned = !Config.INSTANCE.getShowUpdatesInChat();
    }
}
