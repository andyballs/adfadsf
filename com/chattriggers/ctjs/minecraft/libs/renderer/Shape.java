//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs.renderer;

import kotlin.*;
import org.lwjgl.util.vector.*;
import org.jetbrains.annotations.*;
import kotlin.collections.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\bJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\bJ&\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ.\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006J\b\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Shape;", "", "color", "", "(J)V", "area", "", "drawMode", "", "reversedVertexes", "", "Lorg/lwjgl/util/vector/Vector2f;", "vertexes", "addVertex", "x", "y", "clone", "copy", "draw", "getColor", "getDrawMode", "getVertexes", "", "insertVertex", "index", "removeVertex", "setCircle", "radius", "steps", "setColor", "setDrawMode", "setLine", "x1", "y1", "x2", "y2", "thickness", "updateArea", "", "ctjs" })
public final class Shape
{
    private long color;
    @NotNull
    private final List<Vector2f> vertexes;
    @NotNull
    private final List<Vector2f> reversedVertexes;
    private int drawMode;
    private float area;
    
    public Shape(final long color) {
        this.color = color;
        this.vertexes = new ArrayList<Vector2f>();
        this.reversedVertexes = (List<Vector2f>)CollectionsKt.asReversedMutable((List)this.vertexes);
        this.drawMode = 9;
    }
    
    @NotNull
    public final Shape copy() {
        return this.clone();
    }
    
    @NotNull
    public final Shape clone() {
        final Shape clone = new Shape(this.color);
        clone.vertexes.addAll(this.vertexes);
        clone.setDrawMode(this.drawMode);
        return clone;
    }
    
    public final long getColor() {
        return this.color;
    }
    
    @NotNull
    public final Shape setColor(final long color) {
        final Shape $this$setColor_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setColor_u24lambda_u2d0.color = Renderer.fixAlpha(color);
        return this;
    }
    
    public final int getDrawMode() {
        return this.drawMode;
    }
    
    @NotNull
    public final Shape setDrawMode(final int drawMode) {
        final Shape $this$setDrawMode_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setDrawMode_u24lambda_u2d1.drawMode = drawMode;
        return this;
    }
    
    @NotNull
    public final List<Vector2f> getVertexes() {
        return this.vertexes;
    }
    
    @NotNull
    public final Shape addVertex(final float x, final float y) {
        final Shape $this$addVertex_u24lambda_u2d2 = this;
        final int n = 0;
        $this$addVertex_u24lambda_u2d2.vertexes.add(new Vector2f(x, y));
        $this$addVertex_u24lambda_u2d2.updateArea();
        return this;
    }
    
    @NotNull
    public final Shape insertVertex(final int index, final float x, final float y) {
        final Shape $this$insertVertex_u24lambda_u2d3 = this;
        final int n = 0;
        $this$insertVertex_u24lambda_u2d3.vertexes.add(index, new Vector2f(x, y));
        $this$insertVertex_u24lambda_u2d3.updateArea();
        return this;
    }
    
    @NotNull
    public final Shape removeVertex(final int index) {
        final Shape $this$removeVertex_u24lambda_u2d4 = this;
        final int n = 0;
        $this$removeVertex_u24lambda_u2d4.vertexes.remove(index);
        $this$removeVertex_u24lambda_u2d4.updateArea();
        return this;
    }
    
    @NotNull
    public final Shape setLine(final float x1, final float y1, final float x2, final float y2, final float thickness) {
        final Shape $this$setLine_u24lambda_u2d5 = this;
        final int n = 0;
        $this$setLine_u24lambda_u2d5.vertexes.clear();
        final float theta = -(float)Math.atan2(y2 - y1, x2 - x1);
        final float i = (float)Math.sin(theta) * (thickness / 2);
        final float j = (float)Math.cos(theta) * (thickness / 2);
        $this$setLine_u24lambda_u2d5.addVertex(x1 + i, y1 + j);
        $this$setLine_u24lambda_u2d5.addVertex(x2 + i, y2 + j);
        $this$setLine_u24lambda_u2d5.addVertex(x2 - i, y2 - j);
        $this$setLine_u24lambda_u2d5.addVertex(x1 - i, y1 - j);
        $this$setLine_u24lambda_u2d5.drawMode = 7;
        return this;
    }
    
    @NotNull
    public final Shape setCircle(final float x, final float y, final float radius, final int steps) {
        final Shape $this$setCircle_u24lambda_u2d6 = this;
        final int n = 0;
        $this$setCircle_u24lambda_u2d6.vertexes.clear();
        final double theta = 6.283185307179586 / steps;
        final float cos = (float)Math.cos(theta);
        final float sin = (float)Math.sin(theta);
        float xHolder = 0.0f;
        float circleX = 1.0f;
        float circleY = 0.0f;
        int n2 = 0;
        if (n2 <= steps) {
            int i;
            do {
                i = n2;
                ++n2;
                $this$setCircle_u24lambda_u2d6.addVertex(x, y);
                $this$setCircle_u24lambda_u2d6.addVertex(circleX * radius + x, circleY * radius + y);
                xHolder = circleX;
                circleX = cos * circleX - sin * circleY;
                circleY = sin * xHolder + cos * circleY;
                $this$setCircle_u24lambda_u2d6.addVertex(circleX * radius + x, circleY * radius + y);
            } while (i != steps);
        }
        $this$setCircle_u24lambda_u2d6.drawMode = 5;
        return this;
    }
    
    @NotNull
    public final Shape draw() {
        final Shape $this$draw_u24lambda_u2d9 = this;
        final int n = 0;
        final Tessellator tessellator = Tessellator.getInstance();
        Intrinsics.checkNotNullExpressionValue((Object)tessellator, "tessellator");
        final WorldRenderer worldRenderer = ExtensionsKt.getRenderer(tessellator);
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        Renderer.INSTANCE.doColor$ctjs($this$draw_u24lambda_u2d9.color);
        worldRenderer.begin($this$draw_u24lambda_u2d9.drawMode, DefaultVertexFormats.POSITION);
        if ($this$draw_u24lambda_u2d9.area < 0.0f) {
            final Iterable $this$forEach$iv = $this$draw_u24lambda_u2d9.vertexes;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final Vector2f it = (Vector2f)element$iv;
                final int n2 = 0;
                worldRenderer.pos((double)it.x, (double)it.y, 0.0).endVertex();
            }
        }
        else {
            final Iterable $this$forEach$iv = $this$draw_u24lambda_u2d9.reversedVertexes;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final Vector2f it = (Vector2f)element$iv;
                final int n3 = 0;
                worldRenderer.pos((double)it.x, (double)it.y, 0.0).endVertex();
            }
        }
        tessellator.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        Renderer.finishDraw();
        return this;
    }
    
    private final void updateArea() {
        this.area = 0.0f;
        int i;
        Vector2f p1;
        Vector2f p2;
        for (int j = 0; j < this.vertexes.size(); ++j, p1 = this.vertexes.get(i), p2 = this.vertexes.get((i + 1) % this.vertexes.size()), this.area += p1.x * p2.y - p2.x * p1.y) {
            i = j;
        }
        this.area /= 2;
    }
}
