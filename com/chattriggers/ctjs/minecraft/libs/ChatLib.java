//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs;

import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;
import kotlin.*;
import net.minecraft.client.entity.*;
import org.jetbrains.annotations.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import kotlin.jvm.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import kotlin.text.*;
import kotlin.math.*;
import org.mozilla.javascript.regexp.*;
import java.util.regex.*;
import kotlin.jvm.functions.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import kotlin.collections.*;
import java.util.*;
import net.minecraftforge.client.event.*;
import com.chattriggers.ctjs.*;
import com.chattriggers.ctjs.utils.console.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u001a\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007J\u0014\u0010\r\u001a\u00020\u00042\n\u0010\u000e\u001a\u00020\u000f\"\u00020\u000bH\u0007J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u001c\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0015H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0016H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J*\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0015H\u0002J5\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160!\"\u00020\u0016H\u0002¢\u0006\u0002\u0010\"J)\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00162\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160!\"\u00020\u0016H\u0007¢\u0006\u0002\u0010#J)\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160!\"\u00020\u0016H\u0007¢\u0006\u0002\u0010$J)\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160!\"\u00020\u0016H\u0007¢\u0006\u0002\u0010%J)\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160!\"\u00020\u0016H\u0007¢\u0006\u0002\u0010&JC\u0010'\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160!\"\u00020\u0016H\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0012\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u0007H\u0007J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-H\u0007J\u001a\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u0012H\u0007J\b\u00102\u001a\u00020\u000bH\u0007J\u000e\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0007J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0010\u00106\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0017\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¨\u0006:" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/ChatLib;", "", "()V", "actionBar", "", "text", "addColor", "", "message", "addToSentMessageHistory", "index", "", "chat", "clearChat", "chatLineIDs", "", "command", "clientSide", "", "deleteChat", "toDelete", "Lkotlin/Function1;", "Lcom/chattriggers/ctjs/minecraft/objects/message/Message;", "chatLineId", "regexp", "Lorg/mozilla/javascript/regexp/NativeRegExp;", "deleteChatLineList", "lineList", "", "Lnet/minecraft/client/gui/ChatLine;", "editChat", "toReplace", "replacements", "", "(Lkotlin/jvm/functions/Function1;[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "(Lcom/chattriggers/ctjs/minecraft/objects/message/Message;[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "(I[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "(Ljava/lang/String;[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "(Lorg/mozilla/javascript/regexp/NativeRegExp;[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "editChatLineList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V", "getCenteredText", "getChatBreak", "separator", "getChatLines", "", "getChatMessage", "event", "Lnet/minecraftforge/client/event/ClientChatReceivedEvent;", "formatted", "getChatWidth", "isPlayer", "out", "removeFormatting", "replaceFormatting", "say", "(Ljava/lang/String;)Lkotlin/Unit;", "simulateChat", "ctjs" })
public final class ChatLib
{
    @NotNull
    public static final ChatLib INSTANCE;
    
    private ChatLib() {
    }
    
    @JvmStatic
    public static final void chat(@NotNull final Object text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text instanceof String) {
            new Message(new Object[] { text }).chat();
        }
        else if (text instanceof Message) {
            ((Message)text).chat();
        }
        else if (text instanceof TextComponent) {
            ((TextComponent)text).chat();
        }
        else {
            new Message(new Object[] { text.toString() }).chat();
        }
    }
    
    @JvmStatic
    public static final void actionBar(@NotNull final Object text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text instanceof String) {
            new Message(new Object[] { text }).actionBar();
        }
        else if (text instanceof Message) {
            ((Message)text).actionBar();
        }
        else if (text instanceof TextComponent) {
            ((TextComponent)text).actionBar();
        }
        else {
            new Message(new Object[] { text.toString() }).actionBar();
        }
    }
    
    @JvmStatic
    public static final void simulateChat(@NotNull final Object text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text instanceof String) {
            new Message(new Object[] { text }).setRecursive(true).chat();
        }
        else if (text instanceof Message) {
            ((Message)text).setRecursive(true).chat();
        }
        else if (text instanceof TextComponent) {
            new Message(new Object[] { text }).setRecursive(true).chat();
        }
        else {
            new Message(new Object[] { text.toString() }).setRecursive(true).chat();
        }
    }
    
    @JvmStatic
    @Nullable
    public static final Unit say(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final EntityPlayerSP player = Player.getPlayer();
        Unit instance;
        if (player == null) {
            instance = null;
        }
        else {
            player.sendChatMessage(text);
            instance = Unit.INSTANCE;
        }
        return instance;
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void command(@NotNull final String text, final boolean clientSide) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        if (clientSide) {
            ClientCommandHandler.instance.executeCommand((ICommandSender)Player.getPlayer(), Intrinsics.stringPlus("/", (Object)text));
        }
        else {
            final ChatLib instance = ChatLib.INSTANCE;
            say(Intrinsics.stringPlus("/", (Object)text));
        }
    }
    
    public static /* synthetic */ void command$default(final String text, boolean clientSide, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            clientSide = false;
        }
        command(text, clientSide);
    }
    
    @JvmStatic
    public static final void clearChat(@NotNull final int... chatLineIDs) {
        Intrinsics.checkNotNullParameter((Object)chatLineIDs, "chatLineIDs");
        if (chatLineIDs.length == 0) {
            final GuiNewChat chatGUI = Client.Companion.getChatGUI();
            if (chatGUI != null) {
                chatGUI.clearChatMessages();
            }
            return;
        }
        int i = 0;
        while (i < chatLineIDs.length) {
            final int chatLineID = chatLineIDs[i];
            ++i;
            final GuiNewChat chatGUI2 = Client.Companion.getChatGUI();
            if (chatGUI2 == null) {
                continue;
            }
            chatGUI2.deleteChatLine(chatLineID);
        }
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String getChatBreak(@NotNull final String separator) {
        Intrinsics.checkNotNullParameter((Object)separator, "separator");
        final int len = Renderer.getStringWidth(separator);
        final ChatLib instance = ChatLib.INSTANCE;
        final int times = getChatWidth() / len;
        return ExtensionsKt.times(separator, times);
    }
    
    public static /* synthetic */ String getChatBreak$default(String separator, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            separator = "-";
        }
        return getChatBreak(separator);
    }
    
    @JvmStatic
    public static final int getChatWidth() {
        final GuiNewChat chatGUI = Client.Companion.getChatGUI();
        return (chatGUI == null) ? 0 : chatGUI.getChatWidth();
    }
    
    @JvmStatic
    @NotNull
    public static final String removeFormatting(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        return new Regex("[§&][0-9a-fk-or]").replace((CharSequence)text, "");
    }
    
    @JvmStatic
    @NotNull
    public static final String replaceFormatting(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        return new Regex("§(?![^0-9a-fk-or]|$)").replace((CharSequence)text, "&");
    }
    
    @JvmStatic
    @NotNull
    public static final String getCenteredText(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final ChatLib instance = ChatLib.INSTANCE;
        final int textWidth = Renderer.getStringWidth(addColor(text));
        final ChatLib instance2 = ChatLib.INSTANCE;
        final int chatWidth = getChatWidth();
        if (textWidth >= chatWidth) {
            return text;
        }
        final float spaceWidth = (chatWidth - textWidth) / 2.0f;
        final StringBuilder $this$getCenteredText_u24lambda_u2d1 = new StringBuilder();
        final int n = 0;
        for (int roundToInt = MathKt.roundToInt(spaceWidth / Renderer.getStringWidth(" ")), i = 0; i < roundToInt; ++i) {
            final int it = i;
            final int n2 = 0;
            $this$getCenteredText_u24lambda_u2d1.append(' ');
        }
        final StringBuilder spaceBuilder = $this$getCenteredText_u24lambda_u2d1;
        final String string = spaceBuilder.append(text).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "spaceBuilder.append(text).toString()");
        return string;
    }
    
    @JvmStatic
    public static final void editChat(@NotNull final NativeRegExp regexp, @NotNull final Message... replacements) {
        Intrinsics.checkNotNullParameter((Object)regexp, "regexp");
        Intrinsics.checkNotNullParameter((Object)replacements, "replacements");
        final Object value = regexp.get((Object)"global");
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean global = (boolean)value;
        final Object value2 = regexp.get((Object)"ignoreCase");
        if (value2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean ignoreCase = (boolean)value2;
        final Object value3 = regexp.get((Object)"multiline");
        if (value3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean multiline = (boolean)value3;
        final int flags = (ignoreCase ? 2 : 0) | (multiline ? 8 : 0);
        final Object value4 = regexp.get((Object)"source");
        if (value4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        final Pattern pattern = Pattern.compile((String)value4, flags);
        ChatLib.INSTANCE.editChat((Function1<? super Message, Boolean>)new ChatLib$editChat.ChatLib$editChat$1(pattern, global), (Message[])Arrays.copyOf(replacements, replacements.length));
    }
    
    @JvmStatic
    public static final void editChat(@NotNull final String toReplace, @NotNull final Message... replacements) {
        Intrinsics.checkNotNullParameter((Object)toReplace, "toReplace");
        Intrinsics.checkNotNullParameter((Object)replacements, "replacements");
        ChatLib.INSTANCE.editChat((Function1<? super Message, Boolean>)new ChatLib$editChat.ChatLib$editChat$2(toReplace), (Message[])Arrays.copyOf(replacements, replacements.length));
    }
    
    @JvmStatic
    public static final void editChat(@NotNull final Message toReplace, @NotNull final Message... replacements) {
        Intrinsics.checkNotNullParameter((Object)toReplace, "toReplace");
        Intrinsics.checkNotNullParameter((Object)replacements, "replacements");
        ChatLib.INSTANCE.editChat((Function1<? super Message, Boolean>)new ChatLib$editChat.ChatLib$editChat$3(toReplace), (Message[])Arrays.copyOf(replacements, replacements.length));
    }
    
    @JvmStatic
    public static final void editChat(final int chatLineId, @NotNull final Message... replacements) {
        Intrinsics.checkNotNullParameter((Object)replacements, "replacements");
        ChatLib.INSTANCE.editChat((Function1<? super Message, Boolean>)new ChatLib$editChat.ChatLib$editChat$4(chatLineId), (Message[])Arrays.copyOf(replacements, replacements.length));
    }
    
    private final void editChat(final Function1<? super Message, Boolean> toReplace, final Message... replacements) {
        final GuiNewChat chatGUI = Client.Companion.getChatGUI();
        Intrinsics.checkNotNull((Object)chatGUI);
        final List chatLines = chatGUI.chatLines;
        Intrinsics.checkNotNullExpressionValue((Object)chatLines, "chatLines");
        this.editChatLineList(chatLines, toReplace, (Message[])Arrays.copyOf(replacements, replacements.length));
        final GuiNewChat chatGUI2 = Client.Companion.getChatGUI();
        Intrinsics.checkNotNull((Object)chatGUI2);
        chatGUI2.refreshChat();
    }
    
    private final void editChatLineList(final List<ChatLine> lineList, final Function1<? super Message, Boolean> toReplace, final Message... replacements) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface java/util/List.listIterator:()Ljava/util/ListIterator;
        //     6: astore          chatLineIterator
        //     8: aload           chatLineIterator
        //    10: invokeinterface java/util/ListIterator.hasNext:()Z
        //    15: ifeq            275
        //    18: aload           chatLineIterator
        //    20: invokeinterface java/util/ListIterator.next:()Ljava/lang/Object;
        //    25: checkcast       Lnet/minecraft/client/gui/ChatLine;
        //    28: astore          chatLine
        //    30: aload_2         /* toReplace */
        //    31: new             Lcom/chattriggers/ctjs/minecraft/objects/message/Message;
        //    34: dup            
        //    35: aload           chatLine
        //    37: invokevirtual   net/minecraft/client/gui/ChatLine.getChatComponent:()Lnet/minecraft/util/IChatComponent;
        //    40: astore          7
        //    42: aload           7
        //    44: ldc_w           "chatLine.chatComponent"
        //    47: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    50: aload           7
        //    52: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/Message.<init>:(Lnet/minecraft/util/IChatComponent;)V
        //    55: aload           chatLine
        //    57: invokevirtual   net/minecraft/client/gui/ChatLine.getChatLineID:()I
        //    60: invokevirtual   com/chattriggers/ctjs/minecraft/objects/message/Message.setChatLineId:(I)Lcom/chattriggers/ctjs/minecraft/objects/message/Message;
        //    63: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: checkcast       Ljava/lang/Boolean;
        //    71: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    74: istore          result
        //    76: iload           result
        //    78: ifne            84
        //    81: goto            8
        //    84: aload           chatLineIterator
        //    86: invokeinterface java/util/ListIterator.remove:()V
        //    91: aload_3         /* replacements */
        //    92: astore          $this$map$iv
        //    94: iconst_0       
        //    95: istore          $i$f$map
        //    97: aload           $this$map$iv
        //    99: astore          9
        //   101: new             Ljava/util/ArrayList;
        //   104: dup            
        //   105: aload           $this$map$iv
        //   107: arraylength    
        //   108: invokespecial   java/util/ArrayList.<init>:(I)V
        //   111: checkcast       Ljava/util/Collection;
        //   114: astore          destination$iv$iv
        //   116: iconst_0       
        //   117: istore          $i$f$mapTo
        //   119: iconst_0       
        //   120: istore          12
        //   122: aload           $this$mapTo$iv$iv
        //   124: arraylength    
        //   125: istore          13
        //   127: iload           12
        //   129: iload           13
        //   131: if_icmpge       206
        //   134: aload           $this$mapTo$iv$iv
        //   136: iload           12
        //   138: aaload         
        //   139: astore          item$iv$iv
        //   141: aload           destination$iv$iv
        //   143: aload           item$iv$iv
        //   145: astore          15
        //   147: astore          18
        //   149: iconst_0       
        //   150: istore          $i$a$-map-ChatLib$editChatLineList$1
        //   152: aload           it
        //   154: invokevirtual   com/chattriggers/ctjs/minecraft/objects/message/Message.getChatLineId:()I
        //   157: iconst_m1      
        //   158: if_icmpne       165
        //   161: iconst_0       
        //   162: goto            170
        //   165: aload           it
        //   167: invokevirtual   com/chattriggers/ctjs/minecraft/objects/message/Message.getChatLineId:()I
        //   170: istore          lineId
        //   172: new             Lnet/minecraft/client/gui/ChatLine;
        //   175: dup            
        //   176: aload           chatLine
        //   178: invokevirtual   net/minecraft/client/gui/ChatLine.getUpdatedCounter:()I
        //   181: aload           it
        //   183: invokevirtual   com/chattriggers/ctjs/minecraft/objects/message/Message.getChatMessage:()Lnet/minecraft/util/IChatComponent;
        //   186: iload           lineId
        //   188: invokespecial   net/minecraft/client/gui/ChatLine.<init>:(ILnet/minecraft/util/IChatComponent;I)V
        //   191: aload           18
        //   193: swap           
        //   194: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   199: pop            
        //   200: iinc            12, 1
        //   203: goto            127
        //   206: aload           destination$iv$iv
        //   208: checkcast       Ljava/util/List;
        //   211: nop            
        //   212: checkcast       Ljava/lang/Iterable;
        //   215: astore          7
        //   217: nop            
        //   218: iconst_0       
        //   219: istore          $i$f$forEach
        //   221: aload           $this$forEach$iv
        //   223: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   228: astore          9
        //   230: aload           9
        //   232: invokeinterface java/util/Iterator.hasNext:()Z
        //   237: ifeq            271
        //   240: aload           9
        //   242: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   247: astore          element$iv
        //   249: aload           element$iv
        //   251: checkcast       Lnet/minecraft/client/gui/ChatLine;
        //   254: astore          p0
        //   256: iconst_0       
        //   257: istore          $i$a$-forEach-ChatLib$editChatLineList$2
        //   259: aload           chatLineIterator
        //   261: aload           p0
        //   263: invokeinterface java/util/ListIterator.add:(Ljava/lang/Object;)V
        //   268: goto            230
        //   271: nop            
        //   272: goto            8
        //   275: return         
        //    Signature:
        //  (Ljava/util/List<Lnet/minecraft/client/gui/ChatLine;>;Lkotlin/jvm/functions/Function1<-Lcom/chattriggers/ctjs/minecraft/objects/message/Message;Ljava/lang/Boolean;>;[Lcom/chattriggers/ctjs/minecraft/objects/message/Message;)V
        //    StackMapTable: 00 09 FC 00 08 07 01 70 FE 00 4B 07 01 79 01 07 01 8E FF 00 2A 00 0E 07 00 02 07 01 6A 07 01 47 07 01 36 07 01 70 07 01 79 01 07 01 36 01 07 01 36 07 01 96 01 01 01 00 00 FF 00 25 00 13 07 00 02 07 01 6A 07 01 47 07 01 36 07 01 70 07 01 79 01 07 01 36 01 07 01 36 07 01 96 01 01 01 07 00 66 07 00 66 01 00 07 01 96 00 00 44 01 FF 00 23 00 0E 07 00 02 07 01 6A 07 01 47 07 01 36 07 01 70 07 01 79 01 07 01 36 01 07 01 36 07 01 96 01 01 01 00 00 FF 00 17 00 0E 07 00 02 07 01 6A 07 01 47 07 01 36 07 01 70 07 01 79 01 07 01 A7 01 07 01 AD 07 00 04 00 01 01 00 00 28 FF 00 03 00 05 07 00 02 07 01 6A 07 01 47 07 01 36 07 01 70 00 00
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
    public static final void deleteChat(@NotNull final NativeRegExp regexp) {
        Intrinsics.checkNotNullParameter((Object)regexp, "regexp");
        final Object value = regexp.get((Object)"global");
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean global = (boolean)value;
        final Object value2 = regexp.get((Object)"ignoreCase");
        if (value2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean ignoreCase = (boolean)value2;
        final Object value3 = regexp.get((Object)"multiline");
        if (value3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        final boolean multiline = (boolean)value3;
        final int flags = (ignoreCase ? 2 : 0) | (multiline ? 8 : 0);
        final Object value4 = regexp.get((Object)"source");
        if (value4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        final Pattern pattern = Pattern.compile((String)value4, flags);
        ChatLib.INSTANCE.deleteChat((Function1<? super Message, Boolean>)new ChatLib$deleteChat.ChatLib$deleteChat$1(pattern, global));
    }
    
    @JvmStatic
    public static final void deleteChat(@NotNull final String toDelete) {
        Intrinsics.checkNotNullParameter((Object)toDelete, "toDelete");
        ChatLib.INSTANCE.deleteChat((Function1<? super Message, Boolean>)new ChatLib$deleteChat.ChatLib$deleteChat$2(toDelete));
    }
    
    @JvmStatic
    public static final void deleteChat(@NotNull final Message toDelete) {
        Intrinsics.checkNotNullParameter((Object)toDelete, "toDelete");
        ChatLib.INSTANCE.deleteChat((Function1<? super Message, Boolean>)new ChatLib$deleteChat.ChatLib$deleteChat$3(toDelete));
    }
    
    @JvmStatic
    public static final void deleteChat(final int chatLineId) {
        ChatLib.INSTANCE.deleteChat((Function1<? super Message, Boolean>)new ChatLib$deleteChat.ChatLib$deleteChat$4(chatLineId));
    }
    
    private final void deleteChat(final Function1<? super Message, Boolean> toDelete) {
        final GuiNewChat chatGUI = Client.Companion.getChatGUI();
        Intrinsics.checkNotNull((Object)chatGUI);
        final List chatLines = chatGUI.chatLines;
        Intrinsics.checkNotNullExpressionValue((Object)chatLines, "chatLines");
        this.deleteChatLineList(chatLines, toDelete);
        final GuiNewChat chatGUI2 = Client.Companion.getChatGUI();
        Intrinsics.checkNotNull((Object)chatGUI2);
        chatGUI2.refreshChat();
    }
    
    private final void deleteChatLineList(final List<ChatLine> lineList, final Function1<? super Message, Boolean> toDelete) {
        final ListIterator chatLineIterator = lineList.listIterator();
        while (chatLineIterator.hasNext()) {
            final ChatLine chatLine = chatLineIterator.next();
            final IChatComponent getChatComponent = chatLine.getChatComponent();
            Intrinsics.checkNotNullExpressionValue((Object)getChatComponent, "chatLine.chatComponent");
            if (toDelete.invoke((Object)new Message(getChatComponent).setChatLineId(chatLine.getChatLineID()))) {
                chatLineIterator.remove();
            }
        }
    }
    
    @JvmStatic
    @NotNull
    public static final List<String> getChatLines() {
        final List hist = CollectionsKt.toMutableList((Collection)ClientListener.INSTANCE.getChatHistory());
        CollectionsKt.reverse(hist);
        return (List<String>)hist;
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void addToSentMessageHistory(final int index, @NotNull final String message) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        final GuiNewChat chatGUI = Client.Companion.getChatGUI();
        Intrinsics.checkNotNull((Object)chatGUI);
        final List sentMessages = chatGUI.getSentMessages();
        if (index == -1) {
            sentMessages.add(message);
        }
        else {
            sentMessages.add(index, message);
        }
    }
    
    public static /* synthetic */ void addToSentMessageHistory$default(int index, final String message, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            index = -1;
        }
        addToSentMessageHistory(index, message);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String getChatMessage(@NotNull final ClientChatReceivedEvent event, final boolean formatted) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        String replaceFormatting;
        if (formatted) {
            final ChatLib instance = ChatLib.INSTANCE;
            final String getFormattedText = EventLib.getMessage(event).getFormattedText();
            Intrinsics.checkNotNullExpressionValue((Object)getFormattedText, "getMessage(event).formattedText");
            replaceFormatting = replaceFormatting(getFormattedText);
        }
        else {
            final String getUnformattedText = EventLib.getMessage(event).getUnformattedText();
            Intrinsics.checkNotNullExpressionValue((Object)getUnformattedText, "{\n            EventLib.g\u2026unformattedText\n        }");
            replaceFormatting = getUnformattedText;
        }
        return replaceFormatting;
    }
    
    public static /* synthetic */ String getChatMessage$default(final ClientChatReceivedEvent event, boolean formatted, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            formatted = false;
        }
        return getChatMessage(event, formatted);
    }
    
    @JvmStatic
    @NotNull
    public static final String addColor(@Nullable final String message) {
        return new Regex("(?<!\\\\)&(?![^0-9a-fk-or]|$)").replace((CharSequence)String.valueOf(message), "§");
    }
    
    public final boolean isPlayer(@NotNull final String out) {
        Intrinsics.checkNotNullParameter((Object)out, "out");
        if (Player.getPlayer() == null) {
            ReferenceKt.printToConsole$default(out, null, null, 3, null);
            return false;
        }
        return true;
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void command(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        command$default(text, false, 2, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String getChatBreak() {
        return getChatBreak$default(null, 1, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void addToSentMessageHistory(@NotNull final String message) {
        Intrinsics.checkNotNullParameter((Object)message, "message");
        addToSentMessageHistory$default(0, message, 1, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String getChatMessage(@NotNull final ClientChatReceivedEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        return getChatMessage$default(event, false, 2, null);
    }
    
    static {
        INSTANCE = new ChatLib();
    }
}
