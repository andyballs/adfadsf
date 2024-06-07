//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs.renderer;

import kotlin.*;
import org.jetbrains.annotations.*;
import org.lwjgl.util.vector.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0002,-B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0012J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0012J\u001e\u0010#\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010%\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006." }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;", "", "color", "", "x", "", "y", "width", "height", "(JFFFF)V", "outline", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle$Outline;", "shadow", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle$Shadow;", "draw", "getColor", "getHeight", "getOutline", "", "getOutlineColor", "getShadowColor", "getShadowOffset", "Lorg/lwjgl/util/vector/Vector2f;", "getShadowOffsetX", "getShadowOffsetY", "getThickness", "getWidth", "getX", "getY", "isShadow", "setColor", "setHeight", "setOutline", "thickness", "setOutlineColor", "setShadow", "setShadowColor", "setShadowOffset", "setShadowOffsetX", "setShadowOffsetY", "setThickness", "setWidth", "setX", "setY", "Outline", "Shadow", "ctjs" })
public final class Rectangle
{
    private long color;
    private float x;
    private float y;
    private float width;
    private float height;
    @NotNull
    private final Shadow shadow;
    @NotNull
    private final Outline outline;
    
    public Rectangle(final long color, final float x, final float y, final float width, final float height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shadow = new Shadow(this, false, 0L, null, 14, null);
        this.outline = new Outline(this, false, 0L, 0.0f, 14, null);
    }
    
    public final long getColor() {
        return this.color;
    }
    
    @NotNull
    public final Rectangle setColor(final long color) {
        final Rectangle $this$setColor_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setColor_u24lambda_u2d0.color = Renderer.fixAlpha(color);
        return this;
    }
    
    public final float getX() {
        return this.x;
    }
    
    @NotNull
    public final Rectangle setX(final float x) {
        final Rectangle $this$setX_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setX_u24lambda_u2d1.x = x;
        return this;
    }
    
    public final float getY() {
        return this.y;
    }
    
    @NotNull
    public final Rectangle setY(final float y) {
        final Rectangle $this$setY_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setY_u24lambda_u2d2.y = y;
        return this;
    }
    
    public final float getWidth() {
        return this.width;
    }
    
    @NotNull
    public final Rectangle setWidth(final float width) {
        final Rectangle $this$setWidth_u24lambda_u2d3 = this;
        final int n = 0;
        $this$setWidth_u24lambda_u2d3.width = width;
        return this;
    }
    
    public final float getHeight() {
        return this.height;
    }
    
    @NotNull
    public final Rectangle setHeight(final float height) {
        final Rectangle $this$setHeight_u24lambda_u2d4 = this;
        final int n = 0;
        $this$setHeight_u24lambda_u2d4.height = height;
        return this;
    }
    
    public final boolean isShadow() {
        return this.shadow.getOn();
    }
    
    @NotNull
    public final Rectangle setShadow(final boolean shadow) {
        final Rectangle $this$setShadow_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setShadow_u24lambda_u2d5.shadow.setOn(shadow);
        return this;
    }
    
    @NotNull
    public final Vector2f getShadowOffset() {
        return this.shadow.getOffset();
    }
    
    public final float getShadowOffsetX() {
        return this.shadow.getOffset().x;
    }
    
    public final float getShadowOffsetY() {
        return this.shadow.getOffset().y;
    }
    
    @NotNull
    public final Rectangle setShadowOffset(final float x, final float y) {
        final Rectangle $this$setShadowOffset_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setShadowOffset_u24lambda_u2d6.shadow.getOffset().x = x;
        $this$setShadowOffset_u24lambda_u2d6.shadow.getOffset().y = y;
        return this;
    }
    
    @NotNull
    public final Rectangle setShadowOffsetX(final float x) {
        final Rectangle $this$setShadowOffsetX_u24lambda_u2d7 = this;
        final int n = 0;
        $this$setShadowOffsetX_u24lambda_u2d7.shadow.getOffset().x = x;
        return this;
    }
    
    @NotNull
    public final Rectangle setShadowOffsetY(final float y) {
        final Rectangle $this$setShadowOffsetY_u24lambda_u2d8 = this;
        final int n = 0;
        $this$setShadowOffsetY_u24lambda_u2d8.shadow.getOffset().y = y;
        return this;
    }
    
    public final long getShadowColor() {
        return this.shadow.getColor();
    }
    
    @NotNull
    public final Rectangle setShadowColor(final long color) {
        final Rectangle $this$setShadowColor_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setShadowColor_u24lambda_u2d9.shadow.setColor(color);
        return this;
    }
    
    @NotNull
    public final Rectangle setShadow(final long color, final float x, final float y) {
        final Rectangle $this$setShadow_u24lambda_u2d10 = this;
        final int n = 0;
        $this$setShadow_u24lambda_u2d10.setShadow(true);
        $this$setShadow_u24lambda_u2d10.setShadowColor(color);
        $this$setShadow_u24lambda_u2d10.setShadowOffset(x, y);
        return this;
    }
    
    public final boolean getOutline() {
        return this.outline.getOn();
    }
    
    @NotNull
    public final Rectangle setOutline(final boolean outline) {
        final Rectangle $this$setOutline_u24lambda_u2d11 = this;
        final int n = 0;
        $this$setOutline_u24lambda_u2d11.outline.setOn(outline);
        return this;
    }
    
    public final long getOutlineColor() {
        return this.outline.getColor();
    }
    
    @NotNull
    public final Rectangle setOutlineColor(final long color) {
        final Rectangle $this$setOutlineColor_u24lambda_u2d12 = this;
        final int n = 0;
        $this$setOutlineColor_u24lambda_u2d12.outline.setColor(color);
        return this;
    }
    
    public final float getThickness() {
        return this.outline.getThickness();
    }
    
    @NotNull
    public final Rectangle setThickness(final float thickness) {
        final Rectangle $this$setThickness_u24lambda_u2d13 = this;
        final int n = 0;
        $this$setThickness_u24lambda_u2d13.outline.setThickness(thickness);
        return this;
    }
    
    @NotNull
    public final Rectangle setOutline(final long color, final float thickness) {
        final Rectangle $this$setOutline_u24lambda_u2d14 = this;
        final int n = 0;
        $this$setOutline_u24lambda_u2d14.setOutline(true);
        $this$setOutline_u24lambda_u2d14.setOutlineColor(color);
        $this$setOutline_u24lambda_u2d14.setThickness(thickness);
        return this;
    }
    
    @NotNull
    public final Rectangle draw() {
        final Rectangle $this$draw_u24lambda_u2d15 = this;
        final int n = 0;
        $this$draw_u24lambda_u2d15.shadow.draw();
        $this$draw_u24lambda_u2d15.outline.draw();
        Renderer.drawRect($this$draw_u24lambda_u2d15.color, $this$draw_u24lambda_u2d15.x, $this$draw_u24lambda_u2d15.y, $this$draw_u24lambda_u2d15.width, $this$draw_u24lambda_u2d15.height);
        return this;
    }
    
    public static final /* synthetic */ float access$getX$p(final Rectangle $this) {
        return $this.x;
    }
    
    public static final /* synthetic */ float access$getY$p(final Rectangle $this) {
        return $this.y;
    }
    
    public static final /* synthetic */ float access$getHeight$p(final Rectangle $this) {
        return $this.height;
    }
    
    public static final /* synthetic */ float access$getWidth$p(final Rectangle $this) {
        return $this.width;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle$Shadow;", "", "rect", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;", "on", "", "color", "", "offset", "Lorg/lwjgl/util/vector/Vector2f;", "(Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;ZJLorg/lwjgl/util/vector/Vector2f;)V", "getColor", "()J", "setColor", "(J)V", "getOffset", "()Lorg/lwjgl/util/vector/Vector2f;", "setOffset", "(Lorg/lwjgl/util/vector/Vector2f;)V", "getOn", "()Z", "setOn", "(Z)V", "getRect", "()Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;", "draw", "", "ctjs" })
    private static final class Shadow
    {
        @NotNull
        private final Rectangle rect;
        private boolean on;
        private long color;
        @NotNull
        private Vector2f offset;
        
        public Shadow(@NotNull final Rectangle rect, final boolean on, final long color, @NotNull final Vector2f offset) {
            Intrinsics.checkNotNullParameter((Object)rect, "rect");
            Intrinsics.checkNotNullParameter((Object)offset, "offset");
            this.rect = rect;
            this.on = on;
            this.color = color;
            this.offset = offset;
        }
        
        @NotNull
        public final Rectangle getRect() {
            return this.rect;
        }
        
        public final boolean getOn() {
            return this.on;
        }
        
        public final void setOn(final boolean <set-?>) {
            this.on = <set-?>;
        }
        
        public final long getColor() {
            return this.color;
        }
        
        public final void setColor(final long <set-?>) {
            this.color = <set-?>;
        }
        
        @NotNull
        public final Vector2f getOffset() {
            return this.offset;
        }
        
        public final void setOffset(@NotNull final Vector2f <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.offset = <set-?>;
        }
        
        public final void draw() {
            if (!this.on) {
                return;
            }
            Renderer.drawRect(this.color, Rectangle.access$getX$p(this.rect) + this.offset.x, Rectangle.access$getY$p(this.rect) + Rectangle.access$getHeight$p(this.rect), Rectangle.access$getWidth$p(this.rect), this.offset.y);
            Renderer.drawRect(this.color, Rectangle.access$getX$p(this.rect) + Rectangle.access$getWidth$p(this.rect), Rectangle.access$getY$p(this.rect) + this.offset.y, this.offset.x, Rectangle.access$getHeight$p(this.rect) - this.offset.y);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle$Outline;", "", "rect", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;", "on", "", "color", "", "thickness", "", "(Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;ZJF)V", "getColor", "()J", "setColor", "(J)V", "getOn", "()Z", "setOn", "(Z)V", "getRect", "()Lcom/chattriggers/ctjs/minecraft/libs/renderer/Rectangle;", "getThickness", "()F", "setThickness", "(F)V", "draw", "", "ctjs" })
    private static final class Outline
    {
        @NotNull
        private final Rectangle rect;
        private boolean on;
        private long color;
        private float thickness;
        
        public Outline(@NotNull final Rectangle rect, final boolean on, final long color, final float thickness) {
            Intrinsics.checkNotNullParameter((Object)rect, "rect");
            this.rect = rect;
            this.on = on;
            this.color = color;
            this.thickness = thickness;
        }
        
        @NotNull
        public final Rectangle getRect() {
            return this.rect;
        }
        
        public final boolean getOn() {
            return this.on;
        }
        
        public final void setOn(final boolean <set-?>) {
            this.on = <set-?>;
        }
        
        public final long getColor() {
            return this.color;
        }
        
        public final void setColor(final long <set-?>) {
            this.color = <set-?>;
        }
        
        public final float getThickness() {
            return this.thickness;
        }
        
        public final void setThickness(final float <set-?>) {
            this.thickness = <set-?>;
        }
        
        public final void draw() {
            if (!this.on) {
                return;
            }
            Renderer.drawRect(this.color, Rectangle.access$getX$p(this.rect) - this.thickness, Rectangle.access$getY$p(this.rect) - this.thickness, Rectangle.access$getWidth$p(this.rect) + this.thickness * 2, Rectangle.access$getHeight$p(this.rect) + this.thickness * 2);
        }
    }
}
