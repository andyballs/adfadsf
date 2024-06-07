//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.message;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraftforge.client.event.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import kotlin.jvm.functions.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.play.server.*;
import net.minecraft.client.network.*;
import net.minecraft.util.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\b\u0016\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000b¢\u0006\u0002\u0010\fB\u001b\b\u0016\u0012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\"\u00020\u0001¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001J\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0001J\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u0000J\u001f\u0010\u001f\u001a\u00020\u00192\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u000e\"\u00020\u0000¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0011J\n\u0010#\u001a\u00060\u0006j\u0002`\u0007J\u0006\u0010$\u001a\u00020%J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160'J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u0014J\b\u0010+\u001a\u00020\u0019H\u0002J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0011J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014J\u0016\u00100\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0001J\b\u00101\u001a\u00020%H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0006j\u0002`\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/message/Message;", "", "event", "Lnet/minecraftforge/client/event/ClientChatReceivedEvent;", "(Lnet/minecraftforge/client/event/ClientChatReceivedEvent;)V", "component", "Lnet/minecraft/util/IChatComponent;", "Lcom/chattriggers/ctjs/utils/kotlin/MCITextComponent;", "(Lnet/minecraft/util/IChatComponent;)V", "messageParts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "components", "", "([Ljava/lang/Object;)V", "chatLineId", "", "chatMessage", "formatted", "", "", "Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;", "recursive", "actionBar", "", "addTextComponent", "index", "chat", "clone", "copy", "edit", "replacements", "([Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "getChatLineId", "getChatMessage", "getFormattedText", "", "getMessageParts", "", "getUnformattedText", "isFormatted", "isRecursive", "parseMessage", "setChatLineId", "id", "setFormatted", "setRecursive", "setTextComponent", "toString", "ctjs" })
public final class Message
{
    private IChatComponent chatMessage;
    @NotNull
    private final List<TextComponent> messageParts;
    private int chatLineId;
    private boolean recursive;
    private boolean formatted;
    
    public Message(@NotNull final ClientChatReceivedEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        final IChatComponent message = event.message;
        Intrinsics.checkNotNullExpressionValue((Object)message, "event.message");
        this(message);
    }
    
    public Message(@NotNull final IChatComponent component) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "component"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokespecial   java/lang/Object.<init>:()V
        //    10: aload_0         /* this */
        //    11: new             Ljava/util/ArrayList;
        //    14: dup            
        //    15: invokespecial   java/util/ArrayList.<init>:()V
        //    18: checkcast       Ljava/util/List;
        //    21: putfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //    24: aload_0         /* this */
        //    25: iconst_m1      
        //    26: putfield        com/chattriggers/ctjs/minecraft/objects/message/Message.chatLineId:I
        //    29: aload_0         /* this */
        //    30: iconst_1       
        //    31: putfield        com/chattriggers/ctjs/minecraft/objects/message/Message.formatted:Z
        //    34: aload_1         /* component */
        //    35: invokeinterface net/minecraft/util/IChatComponent.getSiblings:()Ljava/util/List;
        //    40: invokeinterface java/util/List.isEmpty:()Z
        //    45: ifeq            167
        //    48: aload_1         /* component */
        //    49: instanceof      Lnet/minecraft/util/ChatComponentTranslation;
        //    52: ifne            74
        //    55: aload_0         /* this */
        //    56: getfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //    59: new             Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //    62: dup            
        //    63: aload_1         /* component */
        //    64: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/TextComponent.<init>:(Lnet/minecraft/util/IChatComponent;)V
        //    67: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    72: pop            
        //    73: return         
        //    74: aload_1         /* component */
        //    75: checkcast       Ljava/lang/Iterable;
        //    78: astore_2        /* $this$forEach$iv */
        //    79: iconst_0       
        //    80: istore_3        /* $i$f$forEach */
        //    81: aload_2         /* $this$forEach$iv */
        //    82: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    87: astore          4
        //    89: aload           4
        //    91: invokeinterface java/util/Iterator.hasNext:()Z
        //    96: ifeq            163
        //    99: aload           4
        //   101: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   106: astore          element$iv
        //   108: aload           element$iv
        //   110: checkcast       Lnet/minecraft/util/IChatComponent;
        //   113: astore          it
        //   115: iconst_0       
        //   116: istore          $i$a$-forEach-Message$1
        //   118: aload           it
        //   120: invokeinterface net/minecraft/util/IChatComponent.getSiblings:()Ljava/util/List;
        //   125: invokeinterface java/util/List.isEmpty:()Z
        //   130: ifeq            159
        //   133: aload_0         /* this */
        //   134: getfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //   137: new             Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   140: dup            
        //   141: aload           it
        //   143: ldc             "it"
        //   145: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   148: aload           it
        //   150: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/TextComponent.<init>:(Lnet/minecraft/util/IChatComponent;)V
        //   153: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   158: pop            
        //   159: nop            
        //   160: goto            89
        //   163: nop            
        //   164: goto            424
        //   167: aload_1         /* component */
        //   168: invokeinterface net/minecraft/util/IChatComponent.getFormattedText:()Ljava/lang/String;
        //   173: astore_2        /* formattedText */
        //   174: new             Lnet/minecraft/util/ChatComponentText;
        //   177: dup            
        //   178: aload_2         /* formattedText */
        //   179: ldc             "formattedText"
        //   181: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   184: aload_2         /* formattedText */
        //   185: iconst_0       
        //   186: aload_2         /* formattedText */
        //   187: checkcast       Ljava/lang/CharSequence;
        //   190: aload_1         /* component */
        //   191: invokeinterface net/minecraft/util/IChatComponent.getSiblings:()Ljava/util/List;
        //   196: iconst_0       
        //   197: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   202: checkcast       Lnet/minecraft/util/IChatComponent;
        //   205: invokeinterface net/minecraft/util/IChatComponent.getFormattedText:()Ljava/lang/String;
        //   210: astore          6
        //   212: aload           6
        //   214: ldc             "component.siblings[0].formattedText"
        //   216: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   219: aload           6
        //   221: iconst_0       
        //   222: iconst_0       
        //   223: bipush          6
        //   225: aconst_null    
        //   226: invokestatic    kotlin/text/StringsKt.indexOf$default:(Ljava/lang/CharSequence;Ljava/lang/String;IZILjava/lang/Object;)I
        //   229: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   232: dup            
        //   233: ldc             "this as java.lang.String\u2026ing(startIndex, endIndex)"
        //   235: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   238: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //   241: astore          4
        //   243: aload           4
        //   245: astore          $this$_init__u24lambda_u2d1
        //   247: iconst_0       
        //   248: istore          $i$a$-apply-Message$firstComponent$1
        //   250: aload           $this$_init__u24lambda_u2d1
        //   252: aload_1         /* component */
        //   253: invokeinterface net/minecraft/util/IChatComponent.getChatStyle:()Lnet/minecraft/util/ChatStyle;
        //   258: invokevirtual   net/minecraft/util/ChatComponentText.setChatStyle:(Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
        //   261: pop            
        //   262: aload           4
        //   264: astore_3        /* firstComponent */
        //   265: aload_0         /* this */
        //   266: getfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //   269: new             Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   272: dup            
        //   273: aload_3         /* firstComponent */
        //   274: checkcast       Lnet/minecraft/util/IChatComponent;
        //   277: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/TextComponent.<init>:(Lnet/minecraft/util/IChatComponent;)V
        //   280: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   285: pop            
        //   286: aload_0         /* this */
        //   287: getfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //   290: aload_1         /* component */
        //   291: invokeinterface net/minecraft/util/IChatComponent.getSiblings:()Ljava/util/List;
        //   296: astore          4
        //   298: aload           4
        //   300: ldc             "component.siblings"
        //   302: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   305: aload           4
        //   307: checkcast       Ljava/lang/Iterable;
        //   310: astore          4
        //   312: astore          13
        //   314: iconst_0       
        //   315: istore          $i$f$map
        //   317: aload           $this$map$iv
        //   319: astore          6
        //   321: new             Ljava/util/ArrayList;
        //   324: dup            
        //   325: aload           $this$map$iv
        //   327: bipush          10
        //   329: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   332: invokespecial   java/util/ArrayList.<init>:(I)V
        //   335: checkcast       Ljava/util/Collection;
        //   338: astore          destination$iv$iv
        //   340: iconst_0       
        //   341: istore          $i$f$mapTo
        //   343: aload           $this$mapTo$iv$iv
        //   345: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   350: astore          9
        //   352: aload           9
        //   354: invokeinterface java/util/Iterator.hasNext:()Z
        //   359: ifeq            406
        //   362: aload           9
        //   364: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   369: astore          item$iv$iv
        //   371: aload           destination$iv$iv
        //   373: aload           item$iv$iv
        //   375: checkcast       Lnet/minecraft/util/IChatComponent;
        //   378: astore          11
        //   380: astore          14
        //   382: iconst_0       
        //   383: istore          $i$a$-map-Message$2
        //   385: new             Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   388: dup            
        //   389: aload           p0
        //   391: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/TextComponent.<init>:(Lnet/minecraft/util/IChatComponent;)V
        //   394: aload           14
        //   396: swap           
        //   397: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   402: pop            
        //   403: goto            352
        //   406: aload           destination$iv$iv
        //   408: checkcast       Ljava/util/List;
        //   411: nop            
        //   412: aload           13
        //   414: swap           
        //   415: checkcast       Ljava/util/Collection;
        //   418: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   423: pop            
        //   424: return         
        //    StackMapTable: 00 08 FF 00 4A 00 02 07 00 02 07 00 69 00 00 FE 00 0E 07 00 7C 01 07 00 82 FE 00 45 07 00 04 07 00 69 01 F8 00 03 F8 00 03 FF 00 B8 00 0E 07 00 02 07 00 69 07 00 A3 07 00 91 07 00 7C 01 07 00 7C 07 00 C1 01 07 00 82 00 00 00 07 00 61 00 00 35 FF 00 11 00 05 07 00 02 07 00 69 07 00 04 00 07 00 04 00 00
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    public Message(@NotNull final ArrayList<Object> messageParts) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "messageParts"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokespecial   java/lang/Object.<init>:()V
        //    10: aload_0         /* this */
        //    11: new             Ljava/util/ArrayList;
        //    14: dup            
        //    15: invokespecial   java/util/ArrayList.<init>:()V
        //    18: checkcast       Ljava/util/List;
        //    21: putfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //    24: aload_0         /* this */
        //    25: iconst_m1      
        //    26: putfield        com/chattriggers/ctjs/minecraft/objects/message/Message.chatLineId:I
        //    29: aload_0         /* this */
        //    30: iconst_1       
        //    31: putfield        com/chattriggers/ctjs/minecraft/objects/message/Message.formatted:Z
        //    34: aload_0         /* this */
        //    35: getfield        com/chattriggers/ctjs/minecraft/objects/message/Message.messageParts:Ljava/util/List;
        //    38: aload_1         /* messageParts */
        //    39: checkcast       Ljava/lang/Iterable;
        //    42: astore_2       
        //    43: astore          12
        //    45: iconst_0       
        //    46: istore_3        /* $i$f$map */
        //    47: aload_2         /* $this$map$iv */
        //    48: astore          4
        //    50: new             Ljava/util/ArrayList;
        //    53: dup            
        //    54: aload_2         /* $this$map$iv */
        //    55: bipush          10
        //    57: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    60: invokespecial   java/util/ArrayList.<init>:(I)V
        //    63: checkcast       Ljava/util/Collection;
        //    66: astore          destination$iv$iv
        //    68: iconst_0       
        //    69: istore          $i$f$mapTo
        //    71: aload           $this$mapTo$iv$iv
        //    73: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    78: astore          7
        //    80: aload           7
        //    82: invokeinterface java/util/Iterator.hasNext:()Z
        //    87: ifeq            186
        //    90: aload           7
        //    92: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    97: astore          item$iv$iv
        //    99: aload           destination$iv$iv
        //   101: aload           item$iv$iv
        //   103: astore          9
        //   105: astore          13
        //   107: iconst_0       
        //   108: istore          $i$a$-map-Message$3
        //   110: aload           it
        //   112: astore          11
        //   114: aload           11
        //   116: instanceof      Ljava/lang/String;
        //   119: ifeq            137
        //   122: new             Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   125: dup            
        //   126: aload           it
        //   128: checkcast       Ljava/lang/String;
        //   131: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/TextComponent.<init>:(Ljava/lang/String;)V
        //   134: goto            173
        //   137: aload           11
        //   139: instanceof      Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   142: ifeq            153
        //   145: aload           it
        //   147: checkcast       Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   150: goto            173
        //   153: aload           11
        //   155: instanceof      Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;
        //   158: ifeq            172
        //   161: aload           it
        //   163: checkcast       Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Item;
        //   166: invokevirtual   com/chattriggers/ctjs/minecraft/wrappers/inventory/Item.getTextComponent:()Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;
        //   169: goto            173
        //   172: return         
        //   173: nop            
        //   174: aload           13
        //   176: swap           
        //   177: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   182: pop            
        //   183: goto            80
        //   186: aload           destination$iv$iv
        //   188: checkcast       Ljava/util/List;
        //   191: nop            
        //   192: aload           12
        //   194: swap           
        //   195: checkcast       Ljava/util/Collection;
        //   198: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   203: pop            
        //   204: return         
        //    Signature:
        //  (Ljava/util/ArrayList<Ljava/lang/Object;>;)V
        //    StackMapTable: 00 06 FF 00 50 00 0D 07 00 02 07 00 5E 07 00 7C 01 07 00 7C 07 00 C1 01 07 00 82 00 00 00 00 07 00 61 00 00 FF 00 38 00 0E 07 00 02 07 00 5E 07 00 7C 01 07 00 7C 07 00 C1 01 07 00 82 07 00 04 07 00 04 01 07 00 04 07 00 61 07 00 C1 00 00 0F 12 40 07 00 75 FF 00 0C 00 0D 07 00 02 07 00 5E 07 00 7C 01 07 00 7C 07 00 C1 01 07 00 82 00 00 00 00 07 00 61 00 00
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    public Message(@NotNull final Object... components) {
        Intrinsics.checkNotNullParameter((Object)components, "components");
        this(new ArrayList<Object>(ArraysKt.asList(components)));
    }
    
    @NotNull
    public final IChatComponent getChatMessage() {
        this.parseMessage();
        IChatComponent chatMessage;
        if ((chatMessage = this.chatMessage) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
            chatMessage = null;
        }
        return chatMessage;
    }
    
    @NotNull
    public final String getFormattedText() {
        final String getFormattedText = this.getChatMessage().getFormattedText();
        Intrinsics.checkNotNullExpressionValue((Object)getFormattedText, "getChatMessage().formattedText");
        return getFormattedText;
    }
    
    @NotNull
    public final String getUnformattedText() {
        final String getUnformattedText = this.getChatMessage().getUnformattedText();
        Intrinsics.checkNotNullExpressionValue((Object)getUnformattedText, "getChatMessage().unformattedText");
        return getUnformattedText;
    }
    
    @NotNull
    public final List<TextComponent> getMessageParts() {
        return this.messageParts;
    }
    
    public final int getChatLineId() {
        return this.chatLineId;
    }
    
    @NotNull
    public final Message setChatLineId(final int id) {
        final Message $this$setChatLineId_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setChatLineId_u24lambda_u2d3.chatLineId = id;
        return this;
    }
    
    public final boolean isRecursive() {
        return this.recursive;
    }
    
    @NotNull
    public final Message setRecursive(final boolean recursive) {
        final Message $this$setRecursive_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setRecursive_u24lambda_u2d4.recursive = recursive;
        return this;
    }
    
    public final boolean isFormatted() {
        return this.formatted;
    }
    
    @NotNull
    public final Message setFormatted(final boolean formatted) {
        final Message $this$setFormatted_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setFormatted_u24lambda_u2d5.formatted = formatted;
        return this;
    }
    
    @NotNull
    public final Message setTextComponent(final int index, @NotNull final Object component) {
        Intrinsics.checkNotNullParameter(component, "component");
        final Message $this$setTextComponent_u24lambda_u2d6 = this;
        final int n = 0;
        if (component instanceof String) {
            $this$setTextComponent_u24lambda_u2d6.messageParts.set(index, new TextComponent((String)component));
        }
        else if (component instanceof TextComponent) {
            $this$setTextComponent_u24lambda_u2d6.messageParts.set(index, (TextComponent)component);
        }
        return this;
    }
    
    @NotNull
    public final Message addTextComponent(@NotNull final Object component) {
        Intrinsics.checkNotNullParameter(component, "component");
        final Message $this$addTextComponent_u24lambda_u2d7 = this;
        final int n = 0;
        if (component instanceof String) {
            $this$addTextComponent_u24lambda_u2d7.messageParts.add(new TextComponent((String)component));
        }
        else if (component instanceof TextComponent) {
            $this$addTextComponent_u24lambda_u2d7.messageParts.add((TextComponent)component);
        }
        return this;
    }
    
    @NotNull
    public final Message addTextComponent(final int index, @NotNull final Object component) {
        Intrinsics.checkNotNullParameter(component, "component");
        final Message $this$addTextComponent_u24lambda_u2d8 = this;
        final int n = 0;
        if (component instanceof String) {
            $this$addTextComponent_u24lambda_u2d8.messageParts.add(index, new TextComponent((String)component));
        }
        else if (component instanceof TextComponent) {
            $this$addTextComponent_u24lambda_u2d8.messageParts.add(index, (TextComponent)component);
        }
        return this;
    }
    
    @NotNull
    public final Message clone() {
        return this.copy();
    }
    
    @NotNull
    public final Message copy() {
        final Message copy = new Message(new Object[] { this.messageParts }).setChatLineId(this.chatLineId);
        copy.recursive = this.recursive;
        copy.formatted = this.formatted;
        return copy;
    }
    
    public final void edit(@NotNull final Message... replacements) {
        Intrinsics.checkNotNullParameter((Object)replacements, "replacements");
        ChatLib.editChat(this, (Message[])Arrays.copyOf(replacements, replacements.length));
    }
    
    public final void chat() {
        this.parseMessage();
        final ChatLib instance = ChatLib.INSTANCE;
        final String s = "[CHAT]: ";
        IChatComponent chatMessage;
        if ((chatMessage = this.chatMessage) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
            chatMessage = null;
        }
        if (!instance.isPlayer(Intrinsics.stringPlus(s, (Object)chatMessage.getFormattedText()))) {
            return;
        }
        if (this.chatLineId != -1) {
            final GuiNewChat chatGUI = Client.Companion.getChatGUI();
            if (chatGUI != null) {
                IChatComponent chatMessage2;
                if ((chatMessage2 = this.chatMessage) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
                    chatMessage2 = null;
                }
                chatGUI.printChatMessageWithOptionalDeletion(chatMessage2, this.chatLineId);
            }
            return;
        }
        if (this.recursive) {
            Client.Companion.scheduleTask$default(Client.Companion, 0, (Function0)new Message$chat.Message$chat$1(this), 1, null);
        }
        else {
            final EntityPlayerSP player = Player.getPlayer();
            if (player != null) {
                IChatComponent chatMessage3;
                if ((chatMessage3 = this.chatMessage) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
                    chatMessage3 = null;
                }
                player.addChatMessage(chatMessage3);
            }
        }
    }
    
    public final void actionBar() {
        this.parseMessage();
        final ChatLib instance = ChatLib.INSTANCE;
        final String s = "[ACTION BAR]: ";
        IChatComponent chatMessage;
        if ((chatMessage = this.chatMessage) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
            chatMessage = null;
        }
        if (!instance.isPlayer(Intrinsics.stringPlus(s, (Object)chatMessage.getFormattedText()))) {
            return;
        }
        final NetHandlerPlayClient connection = Client.Companion.getConnection();
        if (connection != null) {
            IChatComponent chatMessage2;
            if ((chatMessage2 = this.chatMessage) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
                chatMessage2 = null;
            }
            connection.handleChat(new S02PacketChat(chatMessage2, (byte)2));
        }
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Message{formatted=" + this.formatted + ", recursive=" + this.recursive + ", chatLineId=" + this.chatLineId + ", messageParts=" + this.messageParts + '}';
    }
    
    private final void parseMessage() {
        this.chatMessage = (IChatComponent)new ChatComponentText("");
        final Iterable $this$forEach$iv = this.messageParts;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final TextComponent it = (TextComponent)element$iv;
            final int n = 0;
            IChatComponent chatMessage;
            if ((chatMessage = this.chatMessage) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatMessage");
                chatMessage = null;
            }
            chatMessage.appendSibling(it.getChatComponentText());
        }
    }
}
