//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.message;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.text.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import net.minecraft.event.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import net.minecraft.util.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\b\u0016\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010%\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0014\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010,\u001a\u00020\u0003H\u0002J\b\u0010-\u001a\u00020\u0003H\u0016R\u001e\u0010\t\u001a\u00060\u0006j\u0002`\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent;", "", "text", "", "(Ljava/lang/String;)V", "chatComponent", "Lnet/minecraft/util/IChatComponent;", "Lcom/chattriggers/ctjs/utils/kotlin/MCITextComponent;", "(Lnet/minecraft/util/IChatComponent;)V", "chatComponentText", "getChatComponentText", "()Lnet/minecraft/util/IChatComponent;", "setChatComponentText", "clickAction", "clickValue", "formatted", "", "hoverAction", "hoverValue", "actionBar", "", "chat", "getClickAction", "getClickValue", "getHoverAction", "getHoverValue", "getText", "isFormatted", "reInstance", "reInstanceClick", "reInstanceHover", "setClick", "action", "value", "setClickAction", "setClickValue", "setFormatted", "setHover", "setHoverAction", "setHoverValue", "setText", "stringToComponent", "Lnet/minecraft/util/ChatComponentText;", "Lcom/chattriggers/ctjs/utils/kotlin/MCBaseTextComponent;", "string", "toString", "Companion", "ctjs" })
public final class TextComponent
{
    @NotNull
    public static final Companion Companion;
    public IChatComponent chatComponentText;
    @NotNull
    private String text;
    private boolean formatted;
    @Nullable
    private String clickAction;
    @Nullable
    private String clickValue;
    @Nullable
    private String hoverAction;
    @Nullable
    private String hoverValue;
    @NotNull
    private static final Regex URL_REGEX;
    @NotNull
    private static final Regex formatRegex;
    
    @NotNull
    public final IChatComponent getChatComponentText() {
        final IChatComponent chatComponentText = this.chatComponentText;
        if (chatComponentText != null) {
            return chatComponentText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatComponentText");
        return null;
    }
    
    public final void setChatComponentText(@NotNull final IChatComponent <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.chatComponentText = <set-?>;
    }
    
    public TextComponent(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        this.formatted = true;
        this.hoverAction = "show_text";
        this.text = text;
        this.reInstance();
    }
    
    public TextComponent(@NotNull final IChatComponent chatComponent) {
        Intrinsics.checkNotNullParameter((Object)chatComponent, "chatComponent");
        this.formatted = true;
        this.hoverAction = "show_text";
        this.setChatComponentText(chatComponent);
        final String getFormattedText = this.getChatComponentText().getFormattedText();
        Intrinsics.checkNotNullExpressionValue((Object)getFormattedText, "chatComponentText.formattedText");
        this.text = getFormattedText;
        final ChatStyle chatStyle = ExtensionsKt.getStyling(chatComponent);
        final ClickEvent click;
        final ClickEvent clickEvent = click = ExtensionsKt.getClick(chatStyle);
        String clickAction;
        if (click == null) {
            clickAction = null;
        }
        else {
            final ClickEvent$Action getAction = click.getAction();
            clickAction = ((getAction == null) ? null : getAction.getCanonicalName());
        }
        this.clickAction = clickAction;
        final ClickEvent clickEvent2 = clickEvent;
        this.clickValue = ((clickEvent2 == null) ? null : clickEvent2.getValue());
        final HoverEvent hover;
        final HoverEvent hoverEvent = hover = ExtensionsKt.getHover(chatStyle);
        String hoverAction;
        if (hover == null) {
            hoverAction = null;
        }
        else {
            final HoverEvent$Action getAction = hover.getAction();
            hoverAction = ((getAction == null) ? null : getAction.getCanonicalName());
        }
        this.hoverAction = hoverAction;
        final HoverEvent hoverEvent2 = hoverEvent;
        String hoverValue;
        if (hoverEvent2 == null) {
            hoverValue = null;
        }
        else {
            final IChatComponent getValue = hoverEvent2.getValue();
            hoverValue = ((getValue == null) ? null : getValue.getFormattedText());
        }
        this.hoverValue = hoverValue;
    }
    
    @NotNull
    public final String getText() {
        return this.text;
    }
    
    @NotNull
    public final TextComponent setText(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final TextComponent $this$setText_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setText_u24lambda_u2d0.text = text;
        $this$setText_u24lambda_u2d0.reInstance();
        return this;
    }
    
    public final boolean isFormatted() {
        return this.formatted;
    }
    
    @NotNull
    public final TextComponent setFormatted(final boolean formatted) {
        final TextComponent $this$setFormatted_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setFormatted_u24lambda_u2d1.formatted = formatted;
        $this$setFormatted_u24lambda_u2d1.reInstance();
        return this;
    }
    
    @NotNull
    public final TextComponent setClick(@NotNull final String action, @NotNull final String value) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final TextComponent $this$setClick_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setClick_u24lambda_u2d2.clickAction = action;
        $this$setClick_u24lambda_u2d2.clickValue = value;
        $this$setClick_u24lambda_u2d2.reInstanceClick();
        return this;
    }
    
    @Nullable
    public final String getClickAction() {
        return this.clickAction;
    }
    
    @NotNull
    public final TextComponent setClickAction(@NotNull final String action) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        final TextComponent $this$setClickAction_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setClickAction_u24lambda_u2d3.clickAction = action;
        $this$setClickAction_u24lambda_u2d3.reInstanceClick();
        return this;
    }
    
    @Nullable
    public final String getClickValue() {
        return this.clickValue;
    }
    
    @NotNull
    public final TextComponent setClickValue(@NotNull final String value) {
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final TextComponent $this$setClickValue_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setClickValue_u24lambda_u2d4.clickValue = value;
        $this$setClickValue_u24lambda_u2d4.reInstanceClick();
        return this;
    }
    
    @NotNull
    public final TextComponent setHover(@NotNull final String action, @NotNull final String value) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final TextComponent $this$setHover_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setHover_u24lambda_u2d5.hoverAction = action;
        $this$setHover_u24lambda_u2d5.hoverValue = value;
        $this$setHover_u24lambda_u2d5.reInstanceHover();
        return this;
    }
    
    @Nullable
    public final String getHoverAction() {
        return this.hoverAction;
    }
    
    @NotNull
    public final TextComponent setHoverAction(@NotNull final String action) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        final TextComponent $this$setHoverAction_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setHoverAction_u24lambda_u2d6.hoverAction = action;
        $this$setHoverAction_u24lambda_u2d6.reInstanceHover();
        return this;
    }
    
    @Nullable
    public final String getHoverValue() {
        return this.hoverValue;
    }
    
    @NotNull
    public final TextComponent setHoverValue(@NotNull final String value) {
        Intrinsics.checkNotNullParameter((Object)value, "value");
        final TextComponent $this$setHoverValue_u24lambda_u2d7 = this;
        final int n = 0;
        $this$setHoverValue_u24lambda_u2d7.hoverValue = value;
        $this$setHoverValue_u24lambda_u2d7.reInstanceHover();
        return this;
    }
    
    public final void chat() {
        new Message(new Object[] { this }).chat();
    }
    
    public final void actionBar() {
        new Message(new Object[] { this }).actionBar();
    }
    
    @NotNull
    @Override
    public String toString() {
        return "TextComponent{text:" + this.text + ", formatted:" + this.formatted + ", hoverAction:" + (Object)this.hoverAction + ", hoverValue:" + (Object)this.hoverValue + ", clickAction:" + (Object)this.clickAction + ", clickValue:" + (Object)this.clickValue + '}';
    }
    
    private final void reInstance() {
        final String string = this.formatted ? ChatLib.addColor(this.text) : this.text;
        this.setChatComponentText((IChatComponent)this.stringToComponent(string));
        this.reInstanceClick();
        this.reInstanceHover();
    }
    
    private final void reInstanceClick() {
        if (this.clickAction == null || this.clickValue == null) {
            return;
        }
        ExtensionsKt.getStyling(this.getChatComponentText()).setChatClickEvent(new ClickEvent(ClickEvent$Action.getValueByCanonicalName(this.clickAction), this.formatted ? ChatLib.addColor(this.clickValue) : this.clickValue));
    }
    
    private final void reInstanceHover() {
        if (this.hoverAction == null || this.hoverValue == null) {
            return;
        }
        ExtensionsKt.getStyling(this.getChatComponentText()).setChatHoverEvent(new HoverEvent(HoverEvent$Action.getValueByCanonicalName(this.hoverAction), (IChatComponent)new ChatComponentText(this.formatted ? ChatLib.addColor(this.hoverValue) : this.hoverValue)));
    }
    
    private final ChatComponentText stringToComponent(final String string) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: astore_2        /* buffer */
        //     8: new             Lnet/minecraft/util/ChatComponentText;
        //    11: dup            
        //    12: ldc_w           ""
        //    15: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //    18: astore_3        /* comp */
        //    19: aconst_null    
        //    20: astore          style
        //    22: new             Lnet/minecraft/util/ChatStyle;
        //    25: dup            
        //    26: invokespecial   net/minecraft/util/ChatStyle.<init>:()V
        //    29: astore          style
        //    31: iconst_0       
        //    32: istore          i
        //    34: iload           i
        //    36: aload_1         /* string */
        //    37: invokevirtual   java/lang/String.length:()I
        //    40: if_icmpge       577
        //    43: iload           i
        //    45: aload_1         /* string */
        //    46: invokevirtual   java/lang/String.length:()I
        //    49: iconst_1       
        //    50: isub           
        //    51: if_icmpge       353
        //    54: getstatic       com/chattriggers/ctjs/minecraft/objects/message/TextComponent.formatRegex:Lkotlin/text/Regex;
        //    57: aload_1         /* string */
        //    58: astore          6
        //    60: iload           i
        //    62: iconst_1       
        //    63: iadd           
        //    64: istore          7
        //    66: aload           6
        //    68: iload           i
        //    70: iload           7
        //    72: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //    75: dup            
        //    76: ldc_w           "this as java.lang.String\u2026ing(startIndex, endIndex)"
        //    79: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    82: checkcast       Ljava/lang/CharSequence;
        //    85: invokevirtual   kotlin/text/Regex.matches:(Ljava/lang/CharSequence;)Z
        //    88: ifeq            353
        //    91: new             Lnet/minecraft/util/ChatComponentText;
        //    94: dup            
        //    95: aload_2         /* buffer */
        //    96: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    99: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //   102: astore          7
        //   104: aload           7
        //   106: astore          $this$stringToComponent_u24lambda_u2d8
        //   108: iconst_0       
        //   109: istore          $i$a$-apply-TextComponent$stringToComponent$prevText$1
        //   111: aload           $this$stringToComponent_u24lambda_u2d8
        //   113: aload           style
        //   115: invokevirtual   net/minecraft/util/ChatStyle.createDeepCopy:()Lnet/minecraft/util/ChatStyle;
        //   118: invokevirtual   net/minecraft/util/ChatComponentText.setChatStyle:(Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
        //   121: pop            
        //   122: aload           7
        //   124: astore          prevText
        //   126: aload_2         /* buffer */
        //   127: invokestatic    kotlin/text/StringsKt.clear:(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
        //   130: pop            
        //   131: aload_3         /* comp */
        //   132: aload           prevText
        //   134: checkcast       Lnet/minecraft/util/IChatComponent;
        //   137: invokevirtual   net/minecraft/util/ChatComponentText.appendSibling:(Lnet/minecraft/util/IChatComponent;)Lnet/minecraft/util/IChatComponent;
        //   140: pop            
        //   141: iload           i
        //   143: istore          7
        //   145: iload           7
        //   147: iconst_1       
        //   148: iadd           
        //   149: istore          i
        //   151: nop            
        //   152: aload_1         /* string */
        //   153: iload           i
        //   155: invokevirtual   java/lang/String.charAt:(I)C
        //   158: istore          7
        //   160: bipush          48
        //   162: iload           7
        //   164: if_icmpgt       182
        //   167: iload           7
        //   169: bipush          103
        //   171: if_icmpge       178
        //   174: iconst_1       
        //   175: goto            183
        //   178: iconst_0       
        //   179: goto            183
        //   182: iconst_0       
        //   183: ifeq            210
        //   186: aload           style
        //   188: invokestatic    net/minecraft/util/EnumChatFormatting.values:()[Lnet/minecraft/util/EnumChatFormatting;
        //   191: aload_1         /* string */
        //   192: iload           i
        //   194: invokevirtual   java/lang/String.charAt:(I)C
        //   197: bipush          16
        //   199: invokestatic    kotlin/text/CharsKt.digitToInt:(CI)I
        //   202: aaload         
        //   203: invokevirtual   net/minecraft/util/ChatStyle.setColor:(Lnet/minecraft/util/EnumChatFormatting;)Lnet/minecraft/util/ChatStyle;
        //   206: pop            
        //   207: goto            564
        //   210: aload_1         /* string */
        //   211: iload           i
        //   213: invokevirtual   java/lang/String.charAt:(I)C
        //   216: bipush          107
        //   218: if_icmpne       234
        //   221: aload           style
        //   223: iconst_1       
        //   224: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   227: invokevirtual   net/minecraft/util/ChatStyle.setObfuscated:(Ljava/lang/Boolean;)Lnet/minecraft/util/ChatStyle;
        //   230: pop            
        //   231: goto            564
        //   234: aload_1         /* string */
        //   235: iload           i
        //   237: invokevirtual   java/lang/String.charAt:(I)C
        //   240: bipush          108
        //   242: if_icmpne       258
        //   245: aload           style
        //   247: iconst_1       
        //   248: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   251: invokevirtual   net/minecraft/util/ChatStyle.setBold:(Ljava/lang/Boolean;)Lnet/minecraft/util/ChatStyle;
        //   254: pop            
        //   255: goto            564
        //   258: aload_1         /* string */
        //   259: iload           i
        //   261: invokevirtual   java/lang/String.charAt:(I)C
        //   264: bipush          109
        //   266: if_icmpne       282
        //   269: aload           style
        //   271: iconst_1       
        //   272: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   275: invokevirtual   net/minecraft/util/ChatStyle.setStrikethrough:(Ljava/lang/Boolean;)Lnet/minecraft/util/ChatStyle;
        //   278: pop            
        //   279: goto            564
        //   282: aload_1         /* string */
        //   283: iload           i
        //   285: invokevirtual   java/lang/String.charAt:(I)C
        //   288: bipush          110
        //   290: if_icmpne       306
        //   293: aload           style
        //   295: iconst_1       
        //   296: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   299: invokevirtual   net/minecraft/util/ChatStyle.setUnderlined:(Ljava/lang/Boolean;)Lnet/minecraft/util/ChatStyle;
        //   302: pop            
        //   303: goto            564
        //   306: aload_1         /* string */
        //   307: iload           i
        //   309: invokevirtual   java/lang/String.charAt:(I)C
        //   312: bipush          111
        //   314: if_icmpne       330
        //   317: aload           style
        //   319: iconst_1       
        //   320: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   323: invokevirtual   net/minecraft/util/ChatStyle.setItalic:(Ljava/lang/Boolean;)Lnet/minecraft/util/ChatStyle;
        //   326: pop            
        //   327: goto            564
        //   330: aload_1         /* string */
        //   331: iload           i
        //   333: invokevirtual   java/lang/String.charAt:(I)C
        //   336: bipush          114
        //   338: if_icmpne       564
        //   341: new             Lnet/minecraft/util/ChatStyle;
        //   344: dup            
        //   345: invokespecial   net/minecraft/util/ChatStyle.<init>:()V
        //   348: astore          style
        //   350: goto            564
        //   353: getstatic       com/chattriggers/ctjs/minecraft/objects/message/TextComponent.URL_REGEX:Lkotlin/text/Regex;
        //   356: aload_1         /* string */
        //   357: checkcast       Ljava/lang/CharSequence;
        //   360: iload           i
        //   362: invokevirtual   kotlin/text/Regex.matchesAt:(Ljava/lang/CharSequence;I)Z
        //   365: ifeq            553
        //   368: new             Lnet/minecraft/util/ChatComponentText;
        //   371: dup            
        //   372: aload_2         /* buffer */
        //   373: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   376: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //   379: astore          7
        //   381: aload           7
        //   383: astore          $this$stringToComponent_u24lambda_u2d9
        //   385: iconst_0       
        //   386: istore          $i$a$-apply-TextComponent$stringToComponent$prevText$2
        //   388: aload           $this$stringToComponent_u24lambda_u2d9
        //   390: aload           style
        //   392: invokevirtual   net/minecraft/util/ChatStyle.createDeepCopy:()Lnet/minecraft/util/ChatStyle;
        //   395: invokevirtual   net/minecraft/util/ChatComponentText.setChatStyle:(Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
        //   398: pop            
        //   399: aload           7
        //   401: astore          prevText
        //   403: aload_2         /* buffer */
        //   404: invokestatic    kotlin/text/StringsKt.clear:(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
        //   407: pop            
        //   408: aload_3         /* comp */
        //   409: aload           prevText
        //   411: checkcast       Lnet/minecraft/util/IChatComponent;
        //   414: invokevirtual   net/minecraft/util/ChatComponentText.appendSibling:(Lnet/minecraft/util/IChatComponent;)Lnet/minecraft/util/IChatComponent;
        //   417: pop            
        //   418: getstatic       com/chattriggers/ctjs/minecraft/objects/message/TextComponent.URL_REGEX:Lkotlin/text/Regex;
        //   421: aload_1         /* string */
        //   422: checkcast       Ljava/lang/CharSequence;
        //   425: iload           i
        //   427: invokevirtual   kotlin/text/Regex.matchAt:(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;
        //   430: dup            
        //   431: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //   434: invokeinterface kotlin/text/MatchResult.getValue:()Ljava/lang/String;
        //   439: astore          link
        //   441: iload           i
        //   443: aload           link
        //   445: invokevirtual   java/lang/String.length:()I
        //   448: iconst_1       
        //   449: isub           
        //   450: iadd           
        //   451: istore          i
        //   453: new             Lnet/minecraft/util/ChatComponentText;
        //   456: dup            
        //   457: aload           link
        //   459: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //   462: astore          9
        //   464: aload           9
        //   466: astore          $this$stringToComponent_u24lambda_u2d10
        //   468: iconst_0       
        //   469: istore          $i$a$-apply-TextComponent$stringToComponent$linkComponent$1
        //   471: aload           $this$stringToComponent_u24lambda_u2d10
        //   473: aload           style
        //   475: invokevirtual   net/minecraft/util/ChatStyle.createDeepCopy:()Lnet/minecraft/util/ChatStyle;
        //   478: invokevirtual   net/minecraft/util/ChatComponentText.setChatStyle:(Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
        //   481: pop            
        //   482: nop            
        //   483: aload           $this$stringToComponent_u24lambda_u2d10
        //   485: invokevirtual   net/minecraft/util/ChatComponentText.getChatStyle:()Lnet/minecraft/util/ChatStyle;
        //   488: new             Lnet/minecraft/event/ClickEvent;
        //   491: dup            
        //   492: getstatic       net/minecraft/event/ClickEvent$Action.OPEN_URL:Lnet/minecraft/event/ClickEvent$Action;
        //   495: new             Ljava/net/URI;
        //   498: dup            
        //   499: aload           link
        //   501: invokespecial   java/net/URI.<init>:(Ljava/lang/String;)V
        //   504: invokevirtual   java/net/URI.getScheme:()Ljava/lang/String;
        //   507: ifnonnull       521
        //   510: ldc_w           "http://"
        //   513: aload           link
        //   515: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //   518: goto            523
        //   521: aload           link
        //   523: invokespecial   net/minecraft/event/ClickEvent.<init>:(Lnet/minecraft/event/ClickEvent$Action;Ljava/lang/String;)V
        //   526: invokevirtual   net/minecraft/util/ChatStyle.setChatClickEvent:(Lnet/minecraft/event/ClickEvent;)Lnet/minecraft/util/ChatStyle;
        //   529: pop            
        //   530: goto            535
        //   533: astore          12
        //   535: nop            
        //   536: aload           9
        //   538: astore          linkComponent
        //   540: aload_3         /* comp */
        //   541: aload           linkComponent
        //   543: checkcast       Lnet/minecraft/util/IChatComponent;
        //   546: invokevirtual   net/minecraft/util/ChatComponentText.appendSibling:(Lnet/minecraft/util/IChatComponent;)Lnet/minecraft/util/IChatComponent;
        //   549: pop            
        //   550: goto            564
        //   553: aload_2         /* buffer */
        //   554: aload_1         /* string */
        //   555: iload           i
        //   557: invokevirtual   java/lang/String.charAt:(I)C
        //   560: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   563: pop            
        //   564: iload           i
        //   566: istore          6
        //   568: iload           6
        //   570: iconst_1       
        //   571: iadd           
        //   572: istore          i
        //   574: goto            34
        //   577: aload_2         /* buffer */
        //   578: checkcast       Ljava/lang/CharSequence;
        //   581: invokeinterface java/lang/CharSequence.length:()I
        //   586: ifle            593
        //   589: iconst_1       
        //   590: goto            594
        //   593: iconst_0       
        //   594: ifeq            642
        //   597: aload_3         /* comp */
        //   598: new             Lnet/minecraft/util/ChatComponentText;
        //   601: dup            
        //   602: aload_2         /* buffer */
        //   603: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   606: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //   609: astore          6
        //   611: aload           6
        //   613: astore          7
        //   615: astore          13
        //   617: iconst_0       
        //   618: istore          $i$a$-apply-TextComponent$stringToComponent$1
        //   620: aload           $this$stringToComponent_u24lambda_u2d11
        //   622: aload           style
        //   624: invokevirtual   net/minecraft/util/ChatStyle.createDeepCopy:()Lnet/minecraft/util/ChatStyle;
        //   627: invokevirtual   net/minecraft/util/ChatComponentText.setChatStyle:(Lnet/minecraft/util/ChatStyle;)Lnet/minecraft/util/IChatComponent;
        //   630: pop            
        //   631: aload           13
        //   633: aload           6
        //   635: checkcast       Lnet/minecraft/util/IChatComponent;
        //   638: invokevirtual   net/minecraft/util/ChatComponentText.appendSibling:(Lnet/minecraft/util/IChatComponent;)Lnet/minecraft/util/IChatComponent;
        //   641: pop            
        //   642: aload_3         /* comp */
        //   643: areturn        
        //    StackMapTable: 00 15 FF 00 22 00 06 07 00 02 07 00 8E 07 00 D5 07 01 0B 07 00 81 01 00 00 FF 00 8F 00 0A 07 00 02 07 00 8E 07 00 D5 07 01 0B 07 00 81 01 07 01 0B 01 07 01 0B 01 00 00 03 40 01 1A 17 17 17 17 17 FF 00 16 00 06 07 00 02 07 00 8E 07 00 D5 07 01 0B 07 00 81 01 00 00 FF 00 A7 00 0C 07 00 02 07 00 8E 07 00 D5 07 01 0B 07 00 81 01 07 01 0B 07 00 8E 07 01 0B 07 01 0B 07 01 0B 01 00 04 07 00 81 08 01 E8 08 01 E8 07 00 89 FF 00 01 00 0C 07 00 02 07 00 8E 07 00 D5 07 01 0B 07 00 81 01 07 01 0B 07 00 8E 07 01 0B 07 01 0B 07 01 0B 01 00 05 07 00 81 08 01 E8 08 01 E8 07 00 89 07 00 8E 49 07 01 16 01 FF 00 11 00 06 07 00 02 07 00 8E 07 00 D5 07 01 0B 07 00 81 01 00 00 0A 0C 0F 40 01 2F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                         
        //  -----  -----  -----  -----  -----------------------------
        //  482    530    533    535    Ljava/net/URISyntaxException;
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
    
    static {
        Companion = new Companion(null);
        URL_REGEX = new Regex("((?:[a-z\\d]{2,}://)?[-\\w.]+\\.[a-z]{2,}?(?::\\d{1,5})?.*?(?=[!\"§ \n]|$))");
        formatRegex = new Regex("[§&][\\da-fk-or]");
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/message/TextComponent$Companion;", "", "()V", "URL_REGEX", "Lkotlin/text/Regex;", "formatRegex", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
