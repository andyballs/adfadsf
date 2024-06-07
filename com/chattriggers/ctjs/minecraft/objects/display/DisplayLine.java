//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.display;

import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import kotlin.jvm.functions.*;
import org.mozilla.javascript.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import java.util.*;
import kotlin.text.*;
import com.chattriggers.ctjs.triggers.*;
import kotlin.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.engine.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J>\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\b\u0010,\u001a\u0004\u0018\u00010\tJ\b\u0010-\u001a\u0004\u0018\u00010\u000bJ\r\u0010.\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010/J\r\u00100\u001a\u000201H ¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020 J\r\u00104\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010/J\u0006\u00105\u001a\u00020#J\u0010\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\u0001J\u0010\u00108\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\u0001J\u0010\u00109\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\u0001J\u0010\u0010:\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\u0001J\u0010\u0010;\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\u0010\u0010<\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0015\u0010=\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020#J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0015J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0015\u0010D\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010>J\b\u0010F\u001a\u00020\u0003H\u0016J\u0006\u0010G\u001a\u00020\u0000J\u0006\u0010H\u001a\u00020\u0000J\u0006\u0010I\u001a\u00020\u0000J\u0006\u0010J\u001a\u00020\u0000J\"\u0010K\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00062\u0006\u0010L\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0001H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;", "", "text", "", "(Ljava/lang/String;)V", "config", "Lorg/mozilla/javascript/NativeObject;", "(Ljava/lang/String;Lorg/mozilla/javascript/NativeObject;)V", "align", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Align;", "background", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Background;", "backgroundColor", "", "Ljava/lang/Long;", "cachedHeight", "", "cachedWidth", "cachedX", "cachedY", "hovered", "", "onClicked", "Lcom/chattriggers/ctjs/triggers/RegularTrigger;", "onDragged", "onHovered", "onMouseLeave", "shouldRender", "getShouldRender$ctjs", "()Z", "setShouldRender$ctjs", "(Z)V", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Text;", "textColor", "textWidth", "", "draw", "", "x", "y", "totalWidth", "background_", "backgroundColor_", "textColor_", "getAlign", "getBackground", "getBackgroundColor", "()Ljava/lang/Long;", "getLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "getLoader$ctjs", "getText", "getTextColor", "getTextWidth", "registerClicked", "method", "registerDragged", "registerHovered", "registerMouseLeave", "setAlign", "setBackground", "setBackgroundColor", "(Ljava/lang/Long;)Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayLine;", "setScale", "scale", "setShadow", "shadow", "setText", "setTextColor", "color", "toString", "unregisterClicked", "unregisterDragged", "unregisterHovered", "unregisterMouseLeave", "getOption", "key", "default", "ctjs" })
public abstract class DisplayLine
{
    private Text text;
    private float textWidth;
    @Nullable
    private Long textColor;
    @Nullable
    private Long backgroundColor;
    @Nullable
    private DisplayHandler.Background background;
    @Nullable
    private DisplayHandler.Align align;
    @Nullable
    private RegularTrigger onClicked;
    @Nullable
    private RegularTrigger onHovered;
    @Nullable
    private RegularTrigger onDragged;
    @Nullable
    private RegularTrigger onMouseLeave;
    private boolean shouldRender;
    private boolean hovered;
    private double cachedX;
    private double cachedY;
    private double cachedWidth;
    private double cachedHeight;
    
    public final boolean getShouldRender$ctjs() {
        return this.shouldRender;
    }
    
    public final void setShouldRender$ctjs(final boolean <set-?>) {
        this.shouldRender = <set-?>;
    }
    
    public DisplayLine(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        this.shouldRender = true;
        MouseListener.INSTANCE.registerClickListener((Function4)new Function4<Double, Double, Integer, Boolean, Unit>() {
            final /* synthetic */ DisplayLine this$0;
            
            public final void invoke(final double x, final double y, final int button, final boolean pressed) {
                if (this.this$0.getShouldRender$ctjs()) {
                    final double access$getCachedX$p = DisplayLine.access$getCachedX$p(this.this$0);
                    if (x <= DisplayLine.access$getCachedX$p(this.this$0) + DisplayLine.access$getCachedWidth$p(this.this$0) && access$getCachedX$p <= x) {
                        final double access$getCachedY$p = DisplayLine.access$getCachedY$p(this.this$0);
                        if (y <= DisplayLine.access$getCachedY$p(this.this$0) + DisplayLine.access$getCachedHeight$p(this.this$0) && access$getCachedY$p <= y) {
                            final RegularTrigger access$getOnClicked$p = DisplayLine.access$getOnClicked$p(this.this$0);
                            if (access$getOnClicked$p != null) {
                                access$getOnClicked$p.trigger(new Object[] { x, y, button, pressed });
                            }
                        }
                    }
                }
            }
        });
        MouseListener.INSTANCE.registerDraggedListener((Function5)new Function5<Double, Double, Double, Double, Integer, Unit>() {
            final /* synthetic */ DisplayLine this$0;
            
            public final void invoke(final double deltaX, final double deltaY, final double x, final double y, final int button) {
                if (this.this$0.getShouldRender$ctjs()) {
                    final RegularTrigger access$getOnDragged$p = DisplayLine.access$getOnDragged$p(this.this$0);
                    if (access$getOnDragged$p != null) {
                        access$getOnDragged$p.trigger(new Object[] { deltaX, deltaY, x, y, button });
                    }
                }
            }
        });
        this.setText(text);
    }
    
    public DisplayLine(@NotNull final String text, @NotNull final NativeObject config) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        Intrinsics.checkNotNullParameter((Object)config, "config");
        this.shouldRender = true;
        MouseListener.INSTANCE.registerClickListener((Function4)new Function4<Double, Double, Integer, Boolean, Unit>() {
            final /* synthetic */ DisplayLine this$0;
            
            public final void invoke(final double x, final double y, final int button, final boolean pressed) {
                if (this.this$0.getShouldRender$ctjs()) {
                    final double access$getCachedX$p = DisplayLine.access$getCachedX$p(this.this$0);
                    if (x <= DisplayLine.access$getCachedX$p(this.this$0) + DisplayLine.access$getCachedWidth$p(this.this$0) && access$getCachedX$p <= x) {
                        final double access$getCachedY$p = DisplayLine.access$getCachedY$p(this.this$0);
                        if (y <= DisplayLine.access$getCachedY$p(this.this$0) + DisplayLine.access$getCachedHeight$p(this.this$0) && access$getCachedY$p <= y) {
                            final RegularTrigger access$getOnClicked$p = DisplayLine.access$getOnClicked$p(this.this$0);
                            if (access$getOnClicked$p != null) {
                                access$getOnClicked$p.trigger(new Object[] { x, y, button, pressed });
                            }
                        }
                    }
                }
            }
        });
        MouseListener.INSTANCE.registerDraggedListener((Function5)new Function5<Double, Double, Double, Double, Integer, Unit>() {
            final /* synthetic */ DisplayLine this$0;
            
            public final void invoke(final double deltaX, final double deltaY, final double x, final double y, final int button) {
                if (this.this$0.getShouldRender$ctjs()) {
                    final RegularTrigger access$getOnDragged$p = DisplayLine.access$getOnDragged$p(this.this$0);
                    if (access$getOnDragged$p != null) {
                        access$getOnDragged$p.trigger(new Object[] { deltaX, deltaY, x, y, button });
                    }
                }
            }
        });
        this.setText(text);
        final String option = this.getOption(config, "textColor", null);
        this.textColor = ((option == null) ? null : Long.valueOf(Long.parseLong(option)));
        final String option2 = this.getOption(config, "backgroundColor", null);
        this.backgroundColor = ((option2 == null) ? null : Long.valueOf(Long.parseLong(option2)));
        this.setAlign(this.getOption(config, "align", null));
        this.setBackground(this.getOption(config, "background", null));
    }
    
    private final String getOption(final NativeObject $this$getOption, final String key, final Object default) {
        Object o;
        if ($this$getOption == null) {
            final Object value = default;
            o = default;
        }
        else {
            Object value;
            if ((o = (value = $this$getOption.get((Object)key))) == null) {
                value = default;
                o = default;
            }
        }
        Object value;
        return (o == null) ? null : value.toString();
    }
    
    @NotNull
    public final Text getText() {
        Text text;
        if ((text = this.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text = null;
        }
        return text;
    }
    
    @NotNull
    public final DisplayLine setText(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final DisplayLine $this$setText_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setText_u24lambda_u2d0.text = new Text(text, 0.0f, 0.0f, 6, (DefaultConstructorMarker)null);
        final DisplayLine displayLine = $this$setText_u24lambda_u2d0;
        final float n2 = (float)Renderer.getStringWidth(text);
        Text text2;
        if ((text2 = $this$setText_u24lambda_u2d0.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text2 = null;
        }
        displayLine.textWidth = n2 * text2.getScale();
        return this;
    }
    
    @Nullable
    public final Long getTextColor() {
        return this.textColor;
    }
    
    @NotNull
    public final DisplayLine setTextColor(@Nullable final Long color) {
        final DisplayLine $this$setTextColor_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setTextColor_u24lambda_u2d1.textColor = color;
        return this;
    }
    
    public final float getTextWidth() {
        return this.textWidth;
    }
    
    @NotNull
    public final DisplayLine setShadow(final boolean shadow) {
        final DisplayLine $this$setShadow_u24lambda_u2d2 = this;
        final int n = 0;
        Text text;
        if ((text = $this$setShadow_u24lambda_u2d2.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text = null;
        }
        text.setShadow(shadow);
        return this;
    }
    
    @NotNull
    public final DisplayLine setScale(final float scale) {
        final DisplayLine $this$setScale_u24lambda_u2d3 = this;
        final int n = 0;
        Text text;
        if ((text = $this$setScale_u24lambda_u2d3.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text = null;
        }
        text.setScale(scale);
        final DisplayLine displayLine = $this$setScale_u24lambda_u2d3;
        Text text2;
        if ((text2 = $this$setScale_u24lambda_u2d3.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text2 = null;
        }
        displayLine.textWidth = Renderer.getStringWidth(text2.getString()) * scale;
        return this;
    }
    
    @Nullable
    public final DisplayHandler.Align getAlign() {
        return this.align;
    }
    
    @NotNull
    public final DisplayLine setAlign(@Nullable final Object align) {
        final DisplayLine $this$setAlign_u24lambda_u2d4 = this;
        final int n = 0;
        final DisplayLine displayLine = $this$setAlign_u24lambda_u2d4;
        Object value;
        if (align instanceof String) {
            final String upperCase = ((String)align).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.Align.valueOf(upperCase);
        }
        else {
            value = ((align instanceof DisplayHandler.Align) ? ((DisplayHandler.Align)align) : null);
        }
        displayLine.align = (DisplayHandler.Align)value;
        return this;
    }
    
    @Nullable
    public final DisplayHandler.Background getBackground() {
        return this.background;
    }
    
    @NotNull
    public final DisplayLine setBackground(@Nullable final Object background) {
        final DisplayLine $this$setBackground_u24lambda_u2d5 = this;
        final int n = 0;
        final DisplayLine displayLine = $this$setBackground_u24lambda_u2d5;
        Object value;
        if (background instanceof String) {
            final String upperCase = ((String)background).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.Background.valueOf(StringsKt.replace$default(upperCase, " ", "_", false, 4, (Object)null));
        }
        else {
            value = ((background instanceof DisplayHandler.Background) ? ((DisplayHandler.Background)background) : null);
        }
        displayLine.background = (DisplayHandler.Background)value;
        return this;
    }
    
    @Nullable
    public final Long getBackgroundColor() {
        return this.backgroundColor;
    }
    
    @NotNull
    public final DisplayLine setBackgroundColor(@Nullable final Long backgroundColor) {
        final DisplayLine $this$setBackgroundColor_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setBackgroundColor_u24lambda_u2d6.backgroundColor = backgroundColor;
        return this;
    }
    
    @Nullable
    public final RegularTrigger registerClicked(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final DisplayLine $this$registerClicked_u24lambda_u2d7 = this;
        final int n = 0;
        return $this$registerClicked_u24lambda_u2d7.onClicked = new RegularTrigger(method, TriggerType.Other, $this$registerClicked_u24lambda_u2d7.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerHovered(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final DisplayLine $this$registerHovered_u24lambda_u2d8 = this;
        final int n = 0;
        return $this$registerHovered_u24lambda_u2d8.onHovered = new RegularTrigger(method, TriggerType.Other, $this$registerHovered_u24lambda_u2d8.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerMouseLeave(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final DisplayLine $this$registerMouseLeave_u24lambda_u2d9 = this;
        final int n = 0;
        return $this$registerMouseLeave_u24lambda_u2d9.onMouseLeave = new RegularTrigger(method, TriggerType.Other, $this$registerMouseLeave_u24lambda_u2d9.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerDragged(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final DisplayLine $this$registerDragged_u24lambda_u2d10 = this;
        final int n = 0;
        return $this$registerDragged_u24lambda_u2d10.onDragged = new RegularTrigger(method, TriggerType.Other, $this$registerDragged_u24lambda_u2d10.getLoader$ctjs());
    }
    
    @NotNull
    public final DisplayLine unregisterClicked() {
        final DisplayLine $this$unregisterClicked_u24lambda_u2d11 = this;
        final int n = 0;
        final RegularTrigger onClicked = $this$unregisterClicked_u24lambda_u2d11.onClicked;
        if (onClicked != null) {
            onClicked.unregister();
        }
        $this$unregisterClicked_u24lambda_u2d11.onClicked = null;
        return this;
    }
    
    @NotNull
    public final DisplayLine unregisterHovered() {
        final DisplayLine $this$unregisterHovered_u24lambda_u2d12 = this;
        final int n = 0;
        final RegularTrigger onHovered = $this$unregisterHovered_u24lambda_u2d12.onHovered;
        if (onHovered != null) {
            onHovered.unregister();
        }
        $this$unregisterHovered_u24lambda_u2d12.onHovered = null;
        return this;
    }
    
    @NotNull
    public final DisplayLine unregisterMouseLeave() {
        final DisplayLine $this$unregisterMouseLeave_u24lambda_u2d13 = this;
        final int n = 0;
        final RegularTrigger onMouseLeave = $this$unregisterMouseLeave_u24lambda_u2d13.onMouseLeave;
        if (onMouseLeave != null) {
            onMouseLeave.unregister();
        }
        $this$unregisterMouseLeave_u24lambda_u2d13.onMouseLeave = null;
        return this;
    }
    
    @NotNull
    public final DisplayLine unregisterDragged() {
        final DisplayLine $this$unregisterDragged_u24lambda_u2d14 = this;
        final int n = 0;
        final RegularTrigger onDragged = $this$unregisterDragged_u24lambda_u2d14.onDragged;
        if (onDragged != null) {
            onDragged.unregister();
        }
        $this$unregisterDragged_u24lambda_u2d14.onDragged = null;
        return this;
    }
    
    public final void draw(final float x, final float y, final float totalWidth, @NotNull final DisplayHandler.Background background_, final long backgroundColor_, final long textColor_, @NotNull final DisplayHandler.Align align) {
        Intrinsics.checkNotNullParameter((Object)background_, "background_");
        Intrinsics.checkNotNullParameter((Object)align, "align");
        DisplayHandler.Background background2;
        if ((background2 = this.background) == null) {
            background2 = background_;
        }
        final DisplayHandler.Background background = background2;
        final Long backgroundColor2 = this.backgroundColor;
        final long backgroundColor = (backgroundColor2 == null) ? backgroundColor_ : backgroundColor2;
        final Long textColor2 = this.textColor;
        final long textColor = (textColor2 == null) ? textColor_ : textColor2;
        float n = 0.0f;
        switch (WhenMappings.$EnumSwitchMapping$0[align.ordinal()]) {
            case 1: {
                n = x;
                break;
            }
            case 2: {
                n = x - totalWidth / 2;
                break;
            }
            case 3: {
                n = x - totalWidth;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        final float baseX = n;
        if (background == DisplayHandler.Background.FULL) {
            final long n2 = backgroundColor;
            final float n3 = baseX - 1;
            final float n4 = y - 1;
            final float n5 = totalWidth + 1;
            Text text;
            if ((text = this.text) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("text");
                text = null;
            }
            Renderer.drawRect(n2, n3, n4, n5, text.getHeight());
        }
        Text text2;
        if ((text2 = this.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text2 = null;
        }
        if (text2.getString().length() == 0) {
            return;
        }
        DisplayHandler.Align align2;
        if ((align2 = this.align) == null) {
            align2 = align;
        }
        float n6 = 0.0f;
        switch (WhenMappings.$EnumSwitchMapping$0[align2.ordinal()]) {
            case 1: {
                n6 = baseX;
                break;
            }
            case 2: {
                n6 = baseX + (totalWidth - this.textWidth) / 2;
                break;
            }
            case 3: {
                n6 = baseX + (totalWidth - this.textWidth);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        final float xOffset = n6;
        if (background == DisplayHandler.Background.PER_LINE) {
            final long n7 = backgroundColor;
            final float n8 = xOffset - 1;
            final float n9 = y - 1;
            final float n10 = this.textWidth + 1;
            Text text3;
            if ((text3 = this.text) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("text");
                text3 = null;
            }
            Renderer.drawRect(n7, n8, n9, n10, text3.getHeight());
        }
        Text text4;
        if ((text4 = this.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text4 = null;
        }
        Text.draw$default(text4.setX(xOffset).setY(y).setColor(textColor), (Float)null, (Float)null, 3, (Object)null);
        this.cachedX = baseX - 1.0;
        this.cachedY = y - 2.0;
        this.cachedWidth = totalWidth + 1.0;
        Text text5;
        if ((text5 = this.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text5 = null;
        }
        this.cachedHeight = text5.getHeight() + 1.0;
        if (!this.shouldRender) {
            return;
        }
        final double cachedX = this.cachedX;
        final double n11 = this.cachedX + this.cachedWidth;
        final double n12 = Client.Companion.getMouseX();
        if (cachedX <= n12 && n12 <= n11) {
            final double cachedY = this.cachedY;
            final double n13 = this.cachedY + this.cachedHeight;
            final double n14 = Client.Companion.getMouseY();
            if (cachedY <= n14 && n14 <= n13) {
                this.hovered = true;
                final RegularTrigger onHovered = this.onHovered;
                if (onHovered == null) {
                    return;
                }
                onHovered.trigger(new Float[] { Client.Companion.getMouseX(), Client.Companion.getMouseY() });
                return;
            }
        }
        if (this.hovered) {
            final RegularTrigger onMouseLeave = this.onMouseLeave;
            if (onMouseLeave != null) {
                onMouseLeave.trigger(new Float[] { Client.Companion.getMouseX(), Client.Companion.getMouseY() });
            }
        }
        this.hovered = false;
    }
    
    @NotNull
    public abstract ILoader getLoader$ctjs();
    
    @NotNull
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append("DisplayLine{text=");
        Text text;
        if ((text = this.text) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("text");
            text = null;
        }
        return append.append(text).append(", textColor=").append(this.textColor).append(", align=").append(this.align).append(", background=").append(this.background).append(", backgroundColor=").append(this.backgroundColor).append('}').toString();
    }
    
    public static final /* synthetic */ double access$getCachedX$p(final DisplayLine $this) {
        return $this.cachedX;
    }
    
    public static final /* synthetic */ double access$getCachedWidth$p(final DisplayLine $this) {
        return $this.cachedWidth;
    }
    
    public static final /* synthetic */ double access$getCachedY$p(final DisplayLine $this) {
        return $this.cachedY;
    }
    
    public static final /* synthetic */ double access$getCachedHeight$p(final DisplayLine $this) {
        return $this.cachedHeight;
    }
    
    public static final /* synthetic */ RegularTrigger access$getOnClicked$p(final DisplayLine $this) {
        return $this.onClicked;
    }
    
    public static final /* synthetic */ RegularTrigger access$getOnDragged$p(final DisplayLine $this) {
        return $this.onDragged;
    }
}
