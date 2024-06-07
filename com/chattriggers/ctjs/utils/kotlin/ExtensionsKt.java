//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.utils.kotlin;

import kotlin.*;
import net.minecraft.util.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;
import net.minecraft.event.*;
import net.minecraft.client.renderer.*;
import com.fasterxml.jackson.core.*;
import org.mozilla.javascript.*;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00060\u0003j\u0002`\u0004\u001a\u0016\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007*\u00060\u0003j\u0002`\u0004\u001a\u001c\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010*\u00060\u0011j\u0002`\u0012\u001a\u0012\u0010\u0013\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0014j\u0002`\u0015\u001a\u0015\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0002\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\t¨\u0006\u001a" }, d2 = { "getClick", "Lnet/minecraft/event/ClickEvent;", "Lcom/chattriggers/ctjs/utils/kotlin/MCTextClickEvent;", "Lnet/minecraft/util/ChatStyle;", "Lcom/chattriggers/ctjs/utils/kotlin/MCTextStyle;", "getHover", "Lnet/minecraft/event/HoverEvent;", "Lcom/chattriggers/ctjs/utils/kotlin/MCTextHoverEvent;", "getOption", "", "Lorg/mozilla/javascript/NativeObject;", "key", "default", "", "getRenderer", "Lnet/minecraft/client/renderer/WorldRenderer;", "Lcom/chattriggers/ctjs/utils/kotlin/MCWorldRenderer;", "Lnet/minecraft/client/renderer/Tessellator;", "Lcom/chattriggers/ctjs/utils/kotlin/MCTessellator;", "getStyling", "Lnet/minecraft/util/IChatComponent;", "Lcom/chattriggers/ctjs/utils/kotlin/MCITextComponent;", "times", "", "toVersion", "Lcom/fasterxml/jackson/core/Version;", "ctjs" })
public final class ExtensionsKt
{
    @NotNull
    public static final ChatStyle getStyling(@NotNull final IChatComponent $this$getStyling) {
        Intrinsics.checkNotNullParameter((Object)$this$getStyling, "<this>");
        final ChatStyle getChatStyle = $this$getStyling.getChatStyle();
        Intrinsics.checkNotNullExpressionValue((Object)getChatStyle, "this.chatStyle");
        return getChatStyle;
    }
    
    @Nullable
    public static final ClickEvent getClick(@NotNull final ChatStyle $this$getClick) {
        Intrinsics.checkNotNullParameter((Object)$this$getClick, "<this>");
        return $this$getClick.getChatClickEvent();
    }
    
    @Nullable
    public static final HoverEvent getHover(@NotNull final ChatStyle $this$getHover) {
        Intrinsics.checkNotNullParameter((Object)$this$getHover, "<this>");
        return $this$getHover.getChatHoverEvent();
    }
    
    @NotNull
    public static final WorldRenderer getRenderer(@NotNull final Tessellator $this$getRenderer) {
        Intrinsics.checkNotNullParameter((Object)$this$getRenderer, "<this>");
        final WorldRenderer getWorldRenderer = $this$getRenderer.getWorldRenderer();
        Intrinsics.checkNotNullExpressionValue((Object)getWorldRenderer, "worldRenderer");
        return getWorldRenderer;
    }
    
    @NotNull
    public static final String times(@NotNull final String $this$times, @NotNull final Number times) {
        Intrinsics.checkNotNullParameter((Object)$this$times, "<this>");
        Intrinsics.checkNotNullParameter((Object)times, "times");
        final StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        while (j < times.intValue()) {
            final int i = j;
            ++j;
            stringBuilder.append($this$times);
        }
        final String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "stringBuilder.toString()");
        return string;
    }
    
    @NotNull
    public static final Version toVersion(@NotNull final String $this$toVersion) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$toVersion */
        //     7: checkcast       Ljava/lang/CharSequence;
        //    10: iconst_1       
        //    11: anewarray       Ljava/lang/String;
        //    14: astore_2       
        //    15: aload_2        
        //    16: iconst_0       
        //    17: ldc             "."
        //    19: aastore        
        //    20: aload_2        
        //    21: iconst_0       
        //    22: iconst_0       
        //    23: bipush          6
        //    25: aconst_null    
        //    26: invokestatic    kotlin/text/StringsKt.split$default:(Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
        //    29: checkcast       Ljava/lang/Iterable;
        //    32: astore_2        /* $this$map$iv */
        //    33: iconst_0       
        //    34: istore_3        /* $i$f$map */
        //    35: aload_2         /* $this$map$iv */
        //    36: astore          4
        //    38: new             Ljava/util/ArrayList;
        //    41: dup            
        //    42: aload_2         /* $this$map$iv */
        //    43: bipush          10
        //    45: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    48: invokespecial   java/util/ArrayList.<init>:(I)V
        //    51: checkcast       Ljava/util/Collection;
        //    54: astore          destination$iv$iv
        //    56: iconst_0       
        //    57: istore          $i$f$mapTo
        //    59: aload           $this$mapTo$iv$iv
        //    61: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    66: astore          7
        //    68: aload           7
        //    70: invokeinterface java/util/Iterator.hasNext:()Z
        //    75: ifeq            121
        //    78: aload           7
        //    80: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    85: astore          item$iv$iv
        //    87: aload           destination$iv$iv
        //    89: aload           item$iv$iv
        //    91: checkcast       Ljava/lang/String;
        //    94: astore          9
        //    96: astore          11
        //    98: iconst_0       
        //    99: istore          $i$a$-map-ExtensionsKt$toVersion$split$1
        //   101: aload           p0
        //   103: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   106: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   109: aload           11
        //   111: swap           
        //   112: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   117: pop            
        //   118: goto            68
        //   121: aload           destination$iv$iv
        //   123: checkcast       Ljava/util/List;
        //   126: nop            
        //   127: astore_1        /* split */
        //   128: new             Lcom/fasterxml/jackson/core/Version;
        //   131: dup            
        //   132: aload_1         /* split */
        //   133: iconst_0       
        //   134: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   137: checkcast       Ljava/lang/Integer;
        //   140: dup            
        //   141: ifnonnull       149
        //   144: pop            
        //   145: iconst_0       
        //   146: goto            152
        //   149: invokevirtual   java/lang/Integer.intValue:()I
        //   152: aload_1         /* split */
        //   153: iconst_1       
        //   154: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   157: checkcast       Ljava/lang/Integer;
        //   160: dup            
        //   161: ifnonnull       169
        //   164: pop            
        //   165: iconst_0       
        //   166: goto            172
        //   169: invokevirtual   java/lang/Integer.intValue:()I
        //   172: aload_1         /* split */
        //   173: iconst_2       
        //   174: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   177: checkcast       Ljava/lang/Integer;
        //   180: dup            
        //   181: ifnonnull       189
        //   184: pop            
        //   185: iconst_0       
        //   186: goto            192
        //   189: invokevirtual   java/lang/Integer.intValue:()I
        //   192: aconst_null    
        //   193: aconst_null    
        //   194: aconst_null    
        //   195: invokespecial   com/fasterxml/jackson/core/Version.<init>:(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   198: areturn        
        //    StackMapTable: 00 08 FF 00 44 00 08 07 00 7D 00 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 00 34 FF 00 1B 00 08 07 00 7D 07 00 B2 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 03 08 00 80 08 00 80 07 00 A4 FF 00 02 00 08 07 00 7D 07 00 B2 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 03 08 00 80 08 00 80 01 FF 00 10 00 08 07 00 7D 07 00 B2 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 04 08 00 80 08 00 80 01 07 00 A4 FF 00 02 00 08 07 00 7D 07 00 B2 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 04 08 00 80 08 00 80 01 01 FF 00 10 00 08 07 00 7D 07 00 B2 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 05 08 00 80 08 00 80 01 01 07 00 A4 FF 00 02 00 08 07 00 7D 07 00 B2 07 00 87 01 07 00 87 07 00 94 01 07 00 9A 00 05 08 00 80 08 00 80 01 01 01
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final String getOption(@Nullable final NativeObject $this$getOption, @NotNull final String key, @NotNull final Object default) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter(default, "default");
        Object value;
        if ($this$getOption == null) {
            value = default;
        }
        else if ((value = $this$getOption.get((Object)key)) == null) {
            value = default;
        }
        return value.toString();
    }
}
