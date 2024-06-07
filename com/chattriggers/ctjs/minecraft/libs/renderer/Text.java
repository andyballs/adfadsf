//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs.renderer;

import kotlin.*;
import com.chattriggers.ctjs.minecraft.objects.display.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import org.mozilla.javascript.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import kotlin.ranges.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import kotlin.text.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0005J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u00102\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\b\u00105\u001a\u00020\u0003H\u0016J\b\u00106\u001a\u000207H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Text;", "", "string", "", "x", "", "y", "(Ljava/lang/String;FF)V", "config", "Lorg/mozilla/javascript/NativeObject;", "(Ljava/lang/String;Lorg/mozilla/javascript/NativeObject;)V", "align", "Lcom/chattriggers/ctjs/minecraft/objects/display/DisplayHandler$Align;", "color", "", "formatted", "", "lines", "", "maxLines", "", "maxWidth", "scale", "shadow", "width", "draw", "(Ljava/lang/Float;Ljava/lang/Float;)Lcom/chattriggers/ctjs/minecraft/libs/renderer/Text;", "exceedsMaxLines", "getAlign", "getColor", "getFormatted", "getHeight", "getLines", "", "getMaxLines", "getMaxWidth", "getScale", "getShadow", "getString", "getWidth", "getX", "getXAlign", "getY", "setAlign", "setColor", "setFormatted", "setMaxLines", "setMaxWidth", "setScale", "setShadow", "setString", "setX", "setY", "toString", "updateFormatting", "", "ctjs" })
public final class Text
{
    private String string;
    private float x;
    private float y;
    @NotNull
    private final List<String> lines;
    private long color;
    private boolean formatted;
    private boolean shadow;
    @NotNull
    private DisplayHandler.Align align;
    private float width;
    private int maxWidth;
    private int maxLines;
    private float scale;
    
    @JvmOverloads
    public Text(@NotNull final String string, final float x, final float y) {
        Intrinsics.checkNotNullParameter((Object)string, "string");
        this.lines = new ArrayList<String>();
        this.color = 4294967295L;
        this.formatted = true;
        this.align = DisplayHandler.Align.LEFT;
        this.maxLines = Integer.MAX_VALUE;
        this.scale = 1.0f;
        this.setString(string);
        this.setX(x);
        this.setY(y);
    }
    
    public Text(@NotNull final String string, @NotNull final NativeObject config) {
        Intrinsics.checkNotNullParameter((Object)string, "string");
        Intrinsics.checkNotNullParameter((Object)config, "config");
        this.lines = new ArrayList<String>();
        this.color = 4294967295L;
        this.formatted = true;
        this.align = DisplayHandler.Align.LEFT;
        this.maxLines = Integer.MAX_VALUE;
        this.scale = 1.0f;
        this.setString(string);
        this.setColor(Long.parseLong(ExtensionsKt.getOption(config, "color", 4294967295L)));
        this.setFormatted(Boolean.parseBoolean(ExtensionsKt.getOption(config, "formatted", true)));
        this.setShadow(Boolean.parseBoolean(ExtensionsKt.getOption(config, "shadow", false)));
        this.setAlign(ExtensionsKt.getOption(config, "align", DisplayHandler.Align.LEFT));
        this.setX(Float.parseFloat(ExtensionsKt.getOption(config, "x", 0.0f)));
        this.setY(Float.parseFloat(ExtensionsKt.getOption(config, "y", 0.0f)));
        this.setMaxLines((int)Double.parseDouble(ExtensionsKt.getOption(config, "maxLines", Integer.MAX_VALUE)));
        this.setScale(Float.parseFloat(ExtensionsKt.getOption(config, "scale", 1.0f)));
        this.setMaxWidth(Integer.parseInt(ExtensionsKt.getOption(config, "maxWidth", 0)));
    }
    
    @NotNull
    public final String getString() {
        String string;
        if ((string = this.string) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("string");
            string = null;
        }
        return string;
    }
    
    @NotNull
    public final Text setString(@NotNull final String string) {
        Intrinsics.checkNotNullParameter((Object)string, "string");
        final Text $this$setString_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setString_u24lambda_u2d0.string = string;
        $this$setString_u24lambda_u2d0.updateFormatting();
        return this;
    }
    
    public final long getColor() {
        return this.color;
    }
    
    @NotNull
    public final Text setColor(final long color) {
        final Text $this$setColor_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setColor_u24lambda_u2d1.color = Renderer.fixAlpha(color);
        return this;
    }
    
    public final boolean getFormatted() {
        return this.formatted;
    }
    
    @NotNull
    public final Text setFormatted(final boolean formatted) {
        final Text $this$setFormatted_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setFormatted_u24lambda_u2d2.formatted = formatted;
        $this$setFormatted_u24lambda_u2d2.updateFormatting();
        return this;
    }
    
    public final boolean getShadow() {
        return this.shadow;
    }
    
    @NotNull
    public final Text setShadow(final boolean shadow) {
        final Text $this$setShadow_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setShadow_u24lambda_u2d3.shadow = shadow;
        return this;
    }
    
    @NotNull
    public final DisplayHandler.Align getAlign() {
        return this.align;
    }
    
    @NotNull
    public final Text setAlign(@NotNull final Object align) {
        Intrinsics.checkNotNullParameter(align, "align");
        final Text $this$setAlign_u24lambda_u2d4 = this;
        final int n = 0;
        final Text text = $this$setAlign_u24lambda_u2d4;
        Enum<DisplayHandler.Align> value;
        if (align instanceof String) {
            final String upperCase = ((String)align).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            value = DisplayHandler.Align.valueOf(upperCase);
        }
        else {
            value = ((align instanceof DisplayHandler.Align) ? ((DisplayHandler.Align)align) : DisplayHandler.Align.LEFT);
        }
        text.align = (DisplayHandler.Align)value;
        return this;
    }
    
    public final float getX() {
        return this.x;
    }
    
    @NotNull
    public final Text setX(final float x) {
        final Text $this$setX_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setX_u24lambda_u2d5.x = x;
        return this;
    }
    
    public final float getY() {
        return this.y;
    }
    
    @NotNull
    public final Text setY(final float y) {
        final Text $this$setY_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setY_u24lambda_u2d6.y = y;
        return this;
    }
    
    public final float getWidth() {
        return this.width;
    }
    
    @NotNull
    public final List<String> getLines() {
        return this.lines;
    }
    
    public final int getMaxLines() {
        return this.maxLines;
    }
    
    @NotNull
    public final Text setMaxLines(final int maxLines) {
        final Text $this$setMaxLines_u24lambda_u2d7 = this;
        final int n = 0;
        $this$setMaxLines_u24lambda_u2d7.maxLines = maxLines;
        return this;
    }
    
    public final float getScale() {
        return this.scale;
    }
    
    @NotNull
    public final Text setScale(final float scale) {
        final Text $this$setScale_u24lambda_u2d8 = this;
        final int n = 0;
        $this$setScale_u24lambda_u2d8.scale = scale;
        return this;
    }
    
    @NotNull
    public final Text setMaxWidth(final int maxWidth) {
        final Text $this$setMaxWidth_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setMaxWidth_u24lambda_u2d9.maxWidth = maxWidth;
        $this$setMaxWidth_u24lambda_u2d9.updateFormatting();
        return this;
    }
    
    public final int getMaxWidth() {
        return this.maxWidth;
    }
    
    public final float getHeight() {
        return (this.lines.size() > 1) ? (RangesKt.coerceAtMost(this.lines.size(), this.maxLines) * this.scale * 10) : (this.scale * 10);
    }
    
    public final boolean exceedsMaxLines() {
        return this.lines.size() > this.maxLines;
    }
    
    @JvmOverloads
    @NotNull
    public final Text draw(@Nullable final Float x, @Nullable final Float y) {
        final Text $this$draw_u24lambda_u2d11 = this;
        final int n = 0;
        GlStateManager.enableBlend();
        GlStateManager.scale($this$draw_u24lambda_u2d11.scale, $this$draw_u24lambda_u2d11.scale, $this$draw_u24lambda_u2d11.scale);
        final Iterator<String> iterator = (Iterator<String>)$this$draw_u24lambda_u2d11.lines.iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        final String it = iterator.next();
        final int n2 = 0;
        float max = Renderer.getStringWidth(it) * $this$draw_u24lambda_u2d11.scale;
        while (iterator.hasNext()) {
            final String it2 = iterator.next();
            final int n3 = 0;
            max = Math.max(max, Renderer.getStringWidth(it2) * $this$draw_u24lambda_u2d11.scale);
        }
        float longestLine = max;
        if ($this$draw_u24lambda_u2d11.maxWidth != 0) {
            longestLine = RangesKt.coerceAtMost(longestLine, (float)$this$draw_u24lambda_u2d11.maxWidth);
        }
        $this$draw_u24lambda_u2d11.width = longestLine;
        float yHolder = (y == null) ? $this$draw_u24lambda_u2d11.y : y;
        int j = 0;
        while (j < $this$draw_u24lambda_u2d11.maxLines) {
            final int i = j;
            ++j;
            if (i >= $this$draw_u24lambda_u2d11.lines.size()) {
                break;
            }
            Renderer.getFontRenderer().drawString((String)$this$draw_u24lambda_u2d11.lines.get(i), $this$draw_u24lambda_u2d11.getXAlign($this$draw_u24lambda_u2d11.lines.get(i), (x == null) ? $this$draw_u24lambda_u2d11.x : ((float)x)), yHolder / $this$draw_u24lambda_u2d11.scale, (int)$this$draw_u24lambda_u2d11.color, $this$draw_u24lambda_u2d11.shadow);
            yHolder += $this$draw_u24lambda_u2d11.scale * 10;
        }
        GlStateManager.disableBlend();
        Renderer.finishDraw();
        return this;
    }
    
    public static /* synthetic */ Text draw$default(final Text text, Float x, Float y, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            x = null;
        }
        if ((n & 0x2) != 0x0) {
            y = null;
        }
        return text.draw(x, y);
    }
    
    private final void updateFormatting() {
        String string2;
        if (this.formatted) {
            String string;
            if ((string = this.string) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("string");
                string = null;
            }
            string2 = ChatLib.addColor(string);
        }
        else {
            String string3;
            if ((string3 = this.string) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("string");
                string3 = null;
            }
            string2 = ChatLib.replaceFormatting(string3);
        }
        this.string = string2;
        this.lines.clear();
        String string4;
        if ((string4 = this.string) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("string");
            string4 = null;
        }
        final Iterable $this$forEach$iv = StringsKt.split$default((CharSequence)string4, new String[] { "\n" }, false, 0, 6, (Object)null);
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final String it = (String)element$iv;
            final int n = 0;
            if (this.maxWidth > 0) {
                final List<String> lines = this.lines;
                final List listFormattedStringToWidth = Renderer.getFontRenderer().listFormattedStringToWidth(it, this.maxWidth);
                Intrinsics.checkNotNullExpressionValue((Object)listFormattedStringToWidth, "getFontRenderer().listFo\u2026ringToWidth(it, maxWidth)");
                lines.addAll(listFormattedStringToWidth);
            }
            else {
                this.lines.add(it);
            }
        }
    }
    
    private final float getXAlign(final String string, final float x) {
        final float newX = x / this.scale;
        float n = 0.0f;
        switch (WhenMappings.$EnumSwitchMapping$0[this.align.ordinal()]) {
            case 1: {
                n = newX - Renderer.getStringWidth(string) / 2;
                break;
            }
            case 2: {
                n = newX - Renderer.getStringWidth(string);
                break;
            }
            default: {
                n = newX;
                break;
            }
        }
        return n;
    }
    
    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final StringBuilder append = sb.append("Text{string=");
        String string;
        if ((string = this.string) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("string");
            string = null;
        }
        append.append(string).append(", x=").append(this.x).append(", y=").append(this.y).append(", lines=").append(this.lines).append(", color=").append(this.color).append(", scale=").append(this.scale).append(", formatted=").append(this.formatted).append(", shadow=").append(this.shadow).append(", align=").append(this.align).append(", width=").append(this.width).append(", maxWidth=").append(this.maxWidth).append(", maxLines=");
        sb.append(this.maxLines).append('}');
        return sb.toString();
    }
    
    @JvmOverloads
    public Text(@NotNull final String string, final float x) {
        Intrinsics.checkNotNullParameter((Object)string, "string");
        this(string, x, 0.0f, 4, null);
    }
    
    @JvmOverloads
    public Text(@NotNull final String string) {
        Intrinsics.checkNotNullParameter((Object)string, "string");
        this(string, 0.0f, 0.0f, 6, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Text draw(@Nullable final Float x) {
        return draw$default(this, x, null, 2, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Text draw() {
        return draw$default(this, null, null, 3, null);
    }
}
