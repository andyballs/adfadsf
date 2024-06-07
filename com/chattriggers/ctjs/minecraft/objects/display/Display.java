//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.display;

import kotlin.*;
import java.util.concurrent.*;
import kotlin.jvm.internal.*;
import org.mozilla.javascript.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import kotlin.text.*;
import kotlin.jvm.*;
import java.util.*;
import kotlin.ranges.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0001H\u0007J\u001f\u0010$\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010%\"\u00020\u0001¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u0000J\u0015\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H ¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\tJ\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\rJ\u000e\u00100\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001002J\u0006\u00103\u001a\u00020\rJ\u0006\u00104\u001a\u00020\u0013J\u0006\u00105\u001a\u00020\u0015J\u0006\u00106\u001a\u00020\rJ\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u00020\u001dJ\u0006\u00109\u001a\u00020\u000bJ\u0006\u0010:\u001a\u00020\rJ\u0006\u0010;\u001a\u00020\u0000J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010B\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0001J\u0014\u0010C\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100DJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0001J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0001J\u0016\u0010H\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010M\u001a\u00020\u0000J\b\u0010N\u001a\u00020*H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/Display;", "", "config", "Lorg/mozilla/javascript/NativeObject;", "(Lorg/mozilla/javascript/NativeObject;)V", "()V", "align", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Align;", "background", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Background;", "backgroundColor", "", "height", "", "lines", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;", "minWidth", "order", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Order;", "registerType", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$RegisterType;", "getRegisterType$ctjs", "()Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$RegisterType;", "setRegisterType$ctjs", "(Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$RegisterType;)V", "renderX", "renderY", "shouldRender", "", "textColor", "width", "addLine", "index", "", "line", "addLines", "", "([Ljava/lang/Object;)Lcom/chattriggers/ctjs/minecraft/objects/display/Display;", "clearLines", "createDisplayLine", "text", "", "createDisplayLine$ctjs", "getAlign", "getBackground", "getBackgroundColor", "getHeight", "getLine", "getLines", "", "getMinWidth", "getOrder", "getRegisterType", "getRenderX", "getRenderY", "getShouldRender", "getTextColor", "getWidth", "hide", "removeLine", "render", "", "setAlign", "setBackground", "setBackgroundColor", "setLine", "setLines", "", "setMinWidth", "setOrder", "setRegisterType", "setRenderLoc", "setRenderX", "setRenderY", "setShouldRender", "setTextColor", "show", "toString", "ctjs" })
public abstract class Display
{
    @NotNull
    private CopyOnWriteArrayList<DisplayLine> lines;
    private float renderX;
    private float renderY;
    private boolean shouldRender;
    @NotNull
    private DisplayHandler.Order order;
    private long backgroundColor;
    private long textColor;
    @NotNull
    private DisplayHandler.Background background;
    @NotNull
    private DisplayHandler.Align align;
    private float minWidth;
    private float width;
    private float height;
    @NotNull
    private DisplayHandler.RegisterType registerType;
    
    public Display() {
        this.lines = new CopyOnWriteArrayList<DisplayLine>();
        this.shouldRender = true;
        this.order = DisplayHandler.Order.DOWN;
        this.backgroundColor = 1342177280L;
        this.textColor = 4294967295L;
        this.background = DisplayHandler.Background.NONE;
        this.align = DisplayHandler.Align.LEFT;
        this.registerType = DisplayHandler.RegisterType.RENDER_OVERLAY;
        DisplayHandler.INSTANCE.registerDisplay(this);
    }
    
    @NotNull
    public final DisplayHandler.RegisterType getRegisterType$ctjs() {
        return this.registerType;
    }
    
    public final void setRegisterType$ctjs(@NotNull final DisplayHandler.RegisterType <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.registerType = <set-?>;
    }
    
    public Display(@Nullable final NativeObject config) {
        this();
        this.setBackgroundColor(Long.parseLong(ExtensionsKt.getOption(config, "backgroundColor", 1342177280)));
        this.setTextColor(Long.parseLong(ExtensionsKt.getOption(config, "textColor", 4294967295L)));
        this.setBackground(ExtensionsKt.getOption(config, "background", DisplayHandler.Background.NONE));
        this.setAlign(ExtensionsKt.getOption(config, "align", DisplayHandler.Align.LEFT));
        this.setOrder(ExtensionsKt.getOption(config, "order", DisplayHandler.Order.DOWN));
        this.setRenderX(Float.parseFloat(ExtensionsKt.getOption(config, "renderX", 0.0f)));
        this.setRenderY(Float.parseFloat(ExtensionsKt.getOption(config, "renderY", 0.0f)));
        this.setShouldRender(Boolean.parseBoolean(ExtensionsKt.getOption(config, "shouldRender", true)));
        this.setMinWidth(Float.parseFloat(ExtensionsKt.getOption(config, "minWidth", 0.0f)));
        this.setRegisterType(ExtensionsKt.getOption(config, "registerType", DisplayHandler.RegisterType.RENDER_OVERLAY));
    }
    
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }
    
    @NotNull
    public final Display setBackgroundColor(final long backgroundColor) {
        final Display $this$setBackgroundColor_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setBackgroundColor_u24lambda_u2d0.backgroundColor = backgroundColor;
        return this;
    }
    
    public final long getTextColor() {
        return this.textColor;
    }
    
    @NotNull
    public final Display setTextColor(final long textColor) {
        final Display $this$setTextColor_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setTextColor_u24lambda_u2d1.textColor = textColor;
        return this;
    }
    
    @NotNull
    public final DisplayHandler.Background getBackground() {
        return this.background;
    }
    
    @NotNull
    public final Display setBackground(@NotNull final Object background) {
        Intrinsics.checkNotNullParameter(background, "background");
        final Display $this$setBackground_u24lambda_u2d2 = this;
        final int n = 0;
        final Display display = $this$setBackground_u24lambda_u2d2;
        Enum<DisplayHandler.Background> value;
        if (background instanceof String) {
            final String upperCase = ((String)background).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.Background.valueOf(StringsKt.replace$default(upperCase, " ", "_", false, 4, (Object)null));
        }
        else {
            value = ((background instanceof DisplayHandler.Background) ? ((DisplayHandler.Background)background) : DisplayHandler.Background.NONE);
        }
        display.background = (DisplayHandler.Background)value;
        return this;
    }
    
    @NotNull
    public final DisplayHandler.Align getAlign() {
        return this.align;
    }
    
    @NotNull
    public final Display setAlign(@NotNull final Object align) {
        Intrinsics.checkNotNullParameter(align, "align");
        final Display $this$setAlign_u24lambda_u2d3 = this;
        final int n = 0;
        final Display display = $this$setAlign_u24lambda_u2d3;
        Enum<DisplayHandler.Align> value;
        if (align instanceof String) {
            final String upperCase = ((String)align).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.Align.valueOf(upperCase);
        }
        else {
            value = ((align instanceof DisplayHandler.Align) ? ((DisplayHandler.Align)align) : DisplayHandler.Align.LEFT);
        }
        display.align = (DisplayHandler.Align)value;
        return this;
    }
    
    @NotNull
    public final DisplayHandler.Order getOrder() {
        return this.order;
    }
    
    @NotNull
    public final Display setOrder(@NotNull final Object order) {
        Intrinsics.checkNotNullParameter(order, "order");
        final Display $this$setOrder_u24lambda_u2d4 = this;
        final int n = 0;
        final Display display = $this$setOrder_u24lambda_u2d4;
        Enum<DisplayHandler.Order> value;
        if (order instanceof String) {
            final String upperCase = ((String)order).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.Order.valueOf(upperCase);
        }
        else {
            value = ((order instanceof DisplayHandler.Order) ? ((DisplayHandler.Order)order) : DisplayHandler.Order.DOWN);
        }
        display.order = (DisplayHandler.Order)value;
        return this;
    }
    
    @NotNull
    public final Display setLine(final int index, @NotNull final Object line) {
        Intrinsics.checkNotNullParameter(line, "line");
        final Display $this$setLine_u24lambda_u2d5 = this;
        final int n = 0;
        while ($this$setLine_u24lambda_u2d5.lines.size() - 1 < index) {
            $this$setLine_u24lambda_u2d5.lines.add($this$setLine_u24lambda_u2d5.createDisplayLine$ctjs(""));
        }
        $this$setLine_u24lambda_u2d5.lines.set(index, (line instanceof String) ? $this$setLine_u24lambda_u2d5.createDisplayLine$ctjs((String)line) : ((line instanceof DisplayLine) ? line : $this$setLine_u24lambda_u2d5.createDisplayLine$ctjs("")));
        return this;
    }
    
    @NotNull
    public final DisplayLine getLine(final int index) {
        final DisplayLine value = this.lines.get(index);
        Intrinsics.checkNotNullExpressionValue((Object)value, "lines[index]");
        return value;
    }
    
    @NotNull
    public final List<DisplayLine> getLines() {
        return this.lines;
    }
    
    @NotNull
    public final Display setLines(@NotNull final List<DisplayLine> lines) {
        Intrinsics.checkNotNullParameter((Object)lines, "lines");
        final Display $this$setLines_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setLines_u24lambda_u2d6.lines = new CopyOnWriteArrayList<DisplayLine>(lines);
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final Display addLine(final int index, @NotNull final Object line) {
        Intrinsics.checkNotNullParameter(line, "line");
        final Display $this$addLine_u24lambda_u2d7 = this;
        final int n = 0;
        final DisplayLine toAdd = (line instanceof String) ? $this$addLine_u24lambda_u2d7.createDisplayLine$ctjs((String)line) : ((line instanceof DisplayLine) ? line : $this$addLine_u24lambda_u2d7.createDisplayLine$ctjs(""));
        if (index == -1) {
            $this$addLine_u24lambda_u2d7.lines.add(toAdd);
        }
        else {
            $this$addLine_u24lambda_u2d7.lines.add(index, toAdd);
        }
        return this;
    }
    
    public static /* synthetic */ Display addLine$default(final Display display, int index, final Object line, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLine");
        }
        if ((n & 0x1) != 0x0) {
            index = -1;
        }
        return display.addLine(index, line);
    }
    
    @NotNull
    public final Display addLines(@NotNull final Object... lines) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "lines"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_0         /* this */
        //     8: astore_2       
        //     9: aload_2        
        //    10: checkcast       Lcom/chattriggers/ctjs/minecraft/objects/display/Display;
        //    13: astore_3        /* $this$addLines_u24lambda_u2d9 */
        //    14: iconst_0       
        //    15: istore          $i$a$-apply-Display$addLines$1
        //    17: aload_3         /* $this$addLines_u24lambda_u2d9 */
        //    18: getfield        com/chattriggers/ctjs/minecraft/objects/display/Display.lines:Ljava/util/concurrent/CopyOnWriteArrayList;
        //    21: aload_1         /* lines */
        //    22: astore          5
        //    24: astore          6
        //    26: iconst_0       
        //    27: istore          $i$f$map
        //    29: aload           $this$map$iv
        //    31: astore          8
        //    33: new             Ljava/util/ArrayList;
        //    36: dup            
        //    37: aload           $this$map$iv
        //    39: arraylength    
        //    40: invokespecial   java/util/ArrayList.<init>:(I)V
        //    43: checkcast       Ljava/util/Collection;
        //    46: astore          destination$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$f$mapTo
        //    51: iconst_0       
        //    52: istore          11
        //    54: aload           $this$mapTo$iv$iv
        //    56: arraylength    
        //    57: istore          12
        //    59: iload           11
        //    61: iload           12
        //    63: if_icmpge       147
        //    66: aload           $this$mapTo$iv$iv
        //    68: iload           11
        //    70: aaload         
        //    71: astore          item$iv$iv
        //    73: aload           destination$iv$iv
        //    75: aload           item$iv$iv
        //    77: astore          14
        //    79: astore          15
        //    81: iconst_0       
        //    82: istore          $i$a$-map-Display$addLines$1$1
        //    84: aload           it
        //    86: astore          17
        //    88: aload           17
        //    90: instanceof      Ljava/lang/String;
        //    93: ifeq            108
        //    96: aload_3         /* $this$addLines_u24lambda_u2d9 */
        //    97: aload           it
        //    99: checkcast       Ljava/lang/String;
        //   102: invokevirtual   com/chattriggers/ctjs/minecraft/objects/display/Display.createDisplayLine$ctjs:(Ljava/lang/String;)Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;
        //   105: goto            131
        //   108: aload           17
        //   110: instanceof      Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;
        //   113: ifeq            124
        //   116: aload           it
        //   118: checkcast       Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;
        //   121: goto            131
        //   124: aload_3         /* $this$addLines_u24lambda_u2d9 */
        //   125: ldc_w           ""
        //   128: invokevirtual   com/chattriggers/ctjs/minecraft/objects/display/Display.createDisplayLine$ctjs:(Ljava/lang/String;)Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;
        //   131: nop            
        //   132: aload           15
        //   134: swap           
        //   135: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   140: pop            
        //   141: iinc            11, 1
        //   144: goto            59
        //   147: aload           destination$iv$iv
        //   149: checkcast       Ljava/util/List;
        //   152: nop            
        //   153: aload           6
        //   155: swap           
        //   156: checkcast       Ljava/util/Collection;
        //   159: invokevirtual   java/util/concurrent/CopyOnWriteArrayList.addAll:(Ljava/util/Collection;)Z
        //   162: pop            
        //   163: nop            
        //   164: aload_2        
        //   165: checkcast       Lcom/chattriggers/ctjs/minecraft/objects/display/Display;
        //   168: areturn        
        //    StackMapTable: 00 05 FF 00 3B 00 0D 07 00 02 07 01 63 07 00 02 07 00 02 01 07 01 63 07 00 64 01 07 01 63 07 01 44 01 01 01 00 00 FF 00 30 00 12 07 00 02 07 01 63 07 00 02 07 00 02 01 07 01 63 07 00 64 01 07 01 63 07 01 44 01 01 01 07 00 04 07 00 04 07 01 44 01 07 00 04 00 00 0F 46 07 01 30 FF 00 0F 00 0D 07 00 02 07 01 63 07 00 02 07 00 02 01 07 01 63 07 00 64 01 07 01 63 07 01 44 01 01 01 00 00
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
    public final Display removeLine(final int index) {
        final Display $this$removeLine_u24lambda_u2d10 = this;
        final int n = 0;
        $this$removeLine_u24lambda_u2d10.lines.remove(index);
        return this;
    }
    
    @NotNull
    public final Display clearLines() {
        final Display $this$clearLines_u24lambda_u2d11 = this;
        final int n = 0;
        $this$clearLines_u24lambda_u2d11.lines.clear();
        return this;
    }
    
    public final float getRenderX() {
        return this.renderX;
    }
    
    @NotNull
    public final Display setRenderX(final float renderX) {
        final Display $this$setRenderX_u24lambda_u2d12 = this;
        final int n = 0;
        $this$setRenderX_u24lambda_u2d12.renderX = renderX;
        return this;
    }
    
    public final float getRenderY() {
        return this.renderY;
    }
    
    @NotNull
    public final Display setRenderY(final float renderY) {
        final Display $this$setRenderY_u24lambda_u2d13 = this;
        final int n = 0;
        $this$setRenderY_u24lambda_u2d13.renderY = renderY;
        return this;
    }
    
    @NotNull
    public final Display setRenderLoc(final float renderX, final float renderY) {
        final Display $this$setRenderLoc_u24lambda_u2d14 = this;
        final int n = 0;
        $this$setRenderLoc_u24lambda_u2d14.renderX = renderX;
        $this$setRenderLoc_u24lambda_u2d14.renderY = renderY;
        return this;
    }
    
    public final boolean getShouldRender() {
        return this.shouldRender;
    }
    
    @NotNull
    public final Display setShouldRender(final boolean shouldRender) {
        final Display $this$setShouldRender_u24lambda_u2d16 = this;
        final int n = 0;
        $this$setShouldRender_u24lambda_u2d16.shouldRender = shouldRender;
        final Iterable $this$forEach$iv = $this$setShouldRender_u24lambda_u2d16.lines;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final DisplayLine it = (DisplayLine)element$iv;
            final int n2 = 0;
            it.setShouldRender$ctjs(shouldRender);
        }
        return this;
    }
    
    @NotNull
    public final Display show() {
        final Display $this$show_u24lambda_u2d17 = this;
        final int n = 0;
        $this$show_u24lambda_u2d17.setShouldRender(true);
        return this;
    }
    
    @NotNull
    public final Display hide() {
        final Display $this$hide_u24lambda_u2d18 = this;
        final int n = 0;
        $this$hide_u24lambda_u2d18.setShouldRender(false);
        return this;
    }
    
    public final float getWidth() {
        return this.width;
    }
    
    public final float getHeight() {
        return this.height;
    }
    
    public final float getMinWidth() {
        return this.minWidth;
    }
    
    @NotNull
    public final Display setMinWidth(final float minWidth) {
        final Display $this$setMinWidth_u24lambda_u2d19 = this;
        final int n = 0;
        $this$setMinWidth_u24lambda_u2d19.minWidth = minWidth;
        return this;
    }
    
    @NotNull
    public final DisplayHandler.RegisterType getRegisterType() {
        return this.registerType;
    }
    
    @NotNull
    public final Display setRegisterType(@NotNull final Object registerType) {
        Intrinsics.checkNotNullParameter(registerType, "registerType");
        final Display $this$setRegisterType_u24lambda_u2d20 = this;
        final int n = 0;
        final Display display = $this$setRegisterType_u24lambda_u2d20;
        Enum<DisplayHandler.RegisterType> value;
        if (registerType instanceof String) {
            final String upperCase = ((String)registerType).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.RegisterType.valueOf(StringsKt.replace$default(upperCase, " ", "_", false, 4, (Object)null));
        }
        else {
            value = ((registerType instanceof DisplayHandler.RegisterType) ? ((DisplayHandler.RegisterType)registerType) : DisplayHandler.RegisterType.RENDER_OVERLAY);
        }
        display.setRegisterType$ctjs((DisplayHandler.RegisterType)value);
        return this;
    }
    
    public final void render() {
        if (!this.shouldRender) {
            return;
        }
        final Iterator<Object> iterator = this.lines.iterator();
        Float value;
        if (!iterator.hasNext()) {
            final Float n = value = null;
        }
        else {
            final DisplayLine it = iterator.next();
            final int n2 = 0;
            float n3 = it.getTextWidth();
            while (iterator.hasNext()) {
                final DisplayLine it2 = iterator.next();
                final int n4 = 0;
                n3 = Math.max(n3, it2.getTextWidth());
            }
            final Float n = value = n3;
        }
        Float n;
        final Float n5 = (value == null) ? null : Float.valueOf(RangesKt.coerceAtLeast((float)n, this.minWidth));
        this.width = ((n5 == null) ? this.minWidth : n5);
        float i = 0.0f;
        final Iterable $this$forEach$iv = this.lines;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final DisplayLine it2 = (DisplayLine)element$iv;
            final int n6 = 0;
            it2.draw(this.renderX, this.renderY + i, this.width, this.background, this.backgroundColor, this.textColor, this.align);
            switch (WhenMappings.$EnumSwitchMapping$0[this.order.ordinal()]) {
                case 1: {
                    i += it2.getText().getHeight();
                    continue;
                }
                case 2: {
                    i -= it2.getText().getHeight();
                    continue;
                }
            }
        }
        this.height = i;
    }
    
    @NotNull
    public abstract DisplayLine createDisplayLine$ctjs(@NotNull final String p0);
    
    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Display{shouldRender=").append(this.shouldRender).append(", registerType=").append(this.registerType).append(", renderX=").append(this.renderX).append(", renderY=").append(this.renderY).append(", background=").append(this.background).append(", backgroundColor=").append(this.backgroundColor).append(", textColor=").append(this.textColor).append(", align=").append(this.align).append(", order=").append(this.order).append(", minWidth=").append(this.minWidth).append(", width=").append(this.width).append(", height=");
        sb.append(this.height).append(", lines=").append(this.lines).append('}');
        return sb.toString();
    }
    
    @JvmOverloads
    @NotNull
    public final Display addLine(@NotNull final Object line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return addLine$default(this, 0, line, 1, null);
    }
}
