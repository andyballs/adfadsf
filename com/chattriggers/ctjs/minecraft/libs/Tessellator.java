//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import kotlin.jvm.internal.*;
import net.minecraft.client.renderer.vertex.*;
import kotlin.jvm.*;
import org.lwjgl.util.vector.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import com.chattriggers.ctjs.utils.kotlin.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u001c\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u0004H\u0007J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0007J*\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u0007H\u0007J\u0010\u0010(\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0018H\u0007J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0004H\u0007J\b\u0010,\u001a\u00020\u0000H\u0007J\b\u0010-\u001a\u00020\u0000H\u0007J\b\u0010.\u001a\u00020\u0000H\u0007J\b\u0010/\u001a\u00020\u0000H\u0007J\b\u00100\u001a\u00020\u0000H\u0007J\b\u00101\u001a\u000202H\u0007JP\u00103\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020\u00182\b\b\u0002\u0010:\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u00072\b\b\u0002\u0010<\u001a\u00020\u0004H\u0007J\b\u0010=\u001a\u00020\u0000H\u0007J\b\u0010>\u001a\u00020\u0000H\u0007J\b\u0010?\u001a\u00020\u0000H\u0007J\b\u0010@\u001a\u00020\u0000H\u0007J\b\u0010A\u001a\u00020\u0000H\u0007J \u0010B\u001a\u00020C2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0007J\b\u0010D\u001a\u00020\u0000H\u0007J \u0010E\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0007J\b\u0010F\u001a\u00020\u0000H\u0007J(\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0007J$\u0010;\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\u00072\b\b\u0002\u00108\u001a\u00020\u0007H\u0007J\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0007J \u0010L\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0007J(\u0010M\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078\u0006@@X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/Tessellator;", "", "()V", "began", "", "firstVertex", "<set-?>", "", "partialTicks", "getPartialTicks$annotations", "getPartialTicks", "()F", "setPartialTicks$ctjs", "(F)V", "renderManager", "Lnet/minecraft/client/renderer/entity/RenderManager;", "tessellator", "Lnet/minecraft/client/renderer/Tessellator;", "kotlin.jvm.PlatformType", "worldRenderer", "Lnet/minecraft/client/renderer/WorldRenderer;", "Lcom/chattriggers/ctjs/utils/kotlin/MCWorldRenderer;", "alphaFunc", "func", "", "ref", "begin", "drawMode", "textured", "bindTexture", "texture", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Image;", "blendFunc", "sourceFactor", "destFactor", "colorize", "red", "green", "blue", "alpha", "deleteTexture", "depthFunc", "depthMask", "flagIn", "disableAlpha", "disableBlend", "disableDepth", "disableLighting", "disableTexture2D", "draw", "", "drawString", "text", "", "x", "y", "z", "color", "renderBlackBox", "scale", "increase", "enableAlpha", "enableBlend", "enableDepth", "enableLighting", "enableTexture2D", "getRenderPos", "Lorg/lwjgl/util/vector/Vector3f;", "popMatrix", "pos", "pushMatrix", "rotate", "angle", "tex", "u", "v", "translate", "tryBlendFuncSeparate", "sourceFactorAlpha", "destFactorAlpha", "ctjs" })
public final class Tessellator
{
    @NotNull
    public static final Tessellator INSTANCE;
    private static float partialTicks;
    private static net.minecraft.client.renderer.Tessellator tessellator;
    @NotNull
    private static WorldRenderer worldRenderer;
    @NotNull
    private static final RenderManager renderManager;
    private static boolean firstVertex;
    private static boolean began;
    
    private Tessellator() {
    }
    
    public static final float getPartialTicks() {
        return Tessellator.partialTicks;
    }
    
    public static final void setPartialTicks$ctjs(final float <set-?>) {
        Tessellator.partialTicks = <set-?>;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator disableAlpha() {
        final Tessellator $this$disableAlpha_u24lambda_u2d0 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.disableAlpha();
        return $this$disableAlpha_u24lambda_u2d0;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator enableAlpha() {
        final Tessellator $this$enableAlpha_u24lambda_u2d1 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.enableAlpha();
        return $this$enableAlpha_u24lambda_u2d1;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator alphaFunc(final int func, final float ref) {
        final Tessellator $this$alphaFunc_u24lambda_u2d2 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.alphaFunc(func, ref);
        return $this$alphaFunc_u24lambda_u2d2;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator enableLighting() {
        final Tessellator $this$enableLighting_u24lambda_u2d3 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.enableLighting();
        return $this$enableLighting_u24lambda_u2d3;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator disableLighting() {
        final Tessellator $this$disableLighting_u24lambda_u2d4 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.disableLighting();
        return $this$disableLighting_u24lambda_u2d4;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator disableDepth() {
        final Tessellator $this$disableDepth_u24lambda_u2d5 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.disableDepth();
        return $this$disableDepth_u24lambda_u2d5;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator enableDepth() {
        final Tessellator $this$enableDepth_u24lambda_u2d6 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.enableDepth();
        return $this$enableDepth_u24lambda_u2d6;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator depthFunc(final int depthFunc) {
        final Tessellator $this$depthFunc_u24lambda_u2d7 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.depthFunc(depthFunc);
        return $this$depthFunc_u24lambda_u2d7;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator depthMask(final boolean flagIn) {
        final Tessellator $this$depthMask_u24lambda_u2d8 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.depthMask(flagIn);
        return $this$depthMask_u24lambda_u2d8;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator disableBlend() {
        final Tessellator $this$disableBlend_u24lambda_u2d9 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.disableBlend();
        return $this$disableBlend_u24lambda_u2d9;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator enableBlend() {
        final Tessellator $this$enableBlend_u24lambda_u2d10 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.enableBlend();
        return $this$enableBlend_u24lambda_u2d10;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator blendFunc(final int sourceFactor, final int destFactor) {
        final Tessellator $this$blendFunc_u24lambda_u2d11 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.blendFunc(sourceFactor, destFactor);
        return $this$blendFunc_u24lambda_u2d11;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator tryBlendFuncSeparate(final int sourceFactor, final int destFactor, final int sourceFactorAlpha, final int destFactorAlpha) {
        final Tessellator $this$tryBlendFuncSeparate_u24lambda_u2d12 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.tryBlendFuncSeparate(sourceFactor, destFactor, sourceFactorAlpha, destFactorAlpha);
        return $this$tryBlendFuncSeparate_u24lambda_u2d12;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator enableTexture2D() {
        final Tessellator $this$enableTexture2D_u24lambda_u2d13 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.enableTexture2D();
        return $this$enableTexture2D_u24lambda_u2d13;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator disableTexture2D() {
        final Tessellator $this$disableTexture2D_u24lambda_u2d14 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.disableTexture2D();
        return $this$disableTexture2D_u24lambda_u2d14;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator bindTexture(@NotNull final Image texture) {
        Intrinsics.checkNotNullParameter((Object)texture, "texture");
        final Tessellator $this$bindTexture_u24lambda_u2d15 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.bindTexture(texture.getTexture().getGlTextureId());
        return $this$bindTexture_u24lambda_u2d15;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator deleteTexture(@NotNull final Image texture) {
        Intrinsics.checkNotNullParameter((Object)texture, "texture");
        final Tessellator $this$deleteTexture_u24lambda_u2d16 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.deleteTexture(texture.getTexture().getGlTextureId());
        return $this$deleteTexture_u24lambda_u2d16;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator pushMatrix() {
        final Tessellator $this$pushMatrix_u24lambda_u2d17 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.pushMatrix();
        return $this$pushMatrix_u24lambda_u2d17;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator popMatrix() {
        final Tessellator $this$popMatrix_u24lambda_u2d18 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.popMatrix();
        return $this$popMatrix_u24lambda_u2d18;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator begin(final int drawMode, final boolean textured) {
        final Tessellator $this$begin_u24lambda_u2d19 = Tessellator.INSTANCE;
        final int n = 0;
        pushMatrix();
        enableBlend();
        tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.translate(-Tessellator.renderManager.viewerPosX, -Tessellator.renderManager.viewerPosY, -Tessellator.renderManager.viewerPosZ);
        Tessellator.worldRenderer.begin(drawMode, textured ? DefaultVertexFormats.POSITION_TEX : DefaultVertexFormats.POSITION);
        Tessellator.firstVertex = true;
        Tessellator.began = true;
        return $this$begin_u24lambda_u2d19;
    }
    
    public static /* synthetic */ Tessellator begin$default(int drawMode, boolean textured, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            drawMode = 7;
        }
        if ((n & 0x2) != 0x0) {
            textured = true;
        }
        return begin(drawMode, textured);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator colorize(final float red, final float green, final float blue, final float alpha) {
        final Tessellator $this$colorize_u24lambda_u2d20 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.color(red, green, blue, alpha);
        return $this$colorize_u24lambda_u2d20;
    }
    
    public static /* synthetic */ Tessellator colorize$default(final float red, final float green, final float blue, float alpha, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            alpha = 1.0f;
        }
        return colorize(red, green, blue, alpha);
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator rotate(final float angle, final float x, final float y, final float z) {
        final Tessellator $this$rotate_u24lambda_u2d21 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.rotate(angle, x, y, z);
        return $this$rotate_u24lambda_u2d21;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator translate(final float x, final float y, final float z) {
        final Tessellator $this$translate_u24lambda_u2d22 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.translate(x, y, z);
        return $this$translate_u24lambda_u2d22;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator scale(final float x, final float y, final float z) {
        final Tessellator $this$scale_u24lambda_u2d23 = Tessellator.INSTANCE;
        final int n = 0;
        GlStateManager.scale(x, y, z);
        return $this$scale_u24lambda_u2d23;
    }
    
    public static /* synthetic */ Tessellator scale$default(final float x, float y, float z, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            y = x;
        }
        if ((n & 0x4) != 0x0) {
            z = x;
        }
        return scale(x, y, z);
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator pos(final float x, final float y, final float z) {
        final Tessellator $this$pos_u24lambda_u2d24 = Tessellator.INSTANCE;
        final int n = 0;
        if (!Tessellator.began) {
            begin$default(0, false, 3, null);
        }
        if (!Tessellator.firstVertex) {
            Tessellator.worldRenderer.endVertex();
        }
        Tessellator.worldRenderer.pos((double)x, (double)y, (double)z);
        Tessellator.firstVertex = false;
        return $this$pos_u24lambda_u2d24;
    }
    
    @JvmStatic
    @NotNull
    public static final Tessellator tex(final float u, final float v) {
        final Tessellator $this$tex_u24lambda_u2d25 = Tessellator.INSTANCE;
        final int n = 0;
        Tessellator.worldRenderer.tex((double)u, (double)v);
        return $this$tex_u24lambda_u2d25;
    }
    
    @JvmStatic
    public static final void draw() {
        if (!Tessellator.began) {
            return;
        }
        Tessellator.worldRenderer.endVertex();
        Tessellator.tessellator.draw();
        final Tessellator instance = Tessellator.INSTANCE;
        colorize(1.0f, 1.0f, 1.0f, 1.0f);
        final Tessellator instance2 = Tessellator.INSTANCE;
        Tessellator.began = false;
        final Tessellator instance3 = Tessellator.INSTANCE;
        disableBlend();
        final Tessellator instance4 = Tessellator.INSTANCE;
        popMatrix();
    }
    
    @JvmStatic
    @NotNull
    public static final Vector3f getRenderPos(final float x, final float y, final float z) {
        return new Vector3f(x - (float)Player.getRenderX(), y - (float)Player.getRenderY(), z - (float)Player.getRenderZ());
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y, final float z, final int color, final boolean renderBlackBox, final float scale, final boolean increase) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        float lScale = scale;
        final FontRenderer fontRenderer = Renderer.getFontRenderer();
        final Tessellator instance = Tessellator.INSTANCE;
        final Vector3f renderPos = getRenderPos(x, y, z);
        if (increase) {
            final float distance = (float)Math.sqrt(renderPos.x * renderPos.x + renderPos.y * renderPos.y + renderPos.z * renderPos.z);
            final float multiplier = distance / 120.0f;
            lScale *= 0.45f * multiplier;
        }
        final int xMultiplier = (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) ? -1 : 1;
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
        final Tessellator instance2 = Tessellator.INSTANCE;
        pushMatrix();
        final Tessellator instance3 = Tessellator.INSTANCE;
        translate(renderPos.x, renderPos.y, renderPos.z);
        final Tessellator instance4 = Tessellator.INSTANCE;
        rotate(-Tessellator.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        final Tessellator instance5 = Tessellator.INSTANCE;
        rotate(Tessellator.renderManager.playerViewX * xMultiplier, 1.0f, 0.0f, 0.0f);
        final Tessellator instance6 = Tessellator.INSTANCE;
        scale(-lScale, -lScale, lScale);
        final Tessellator instance7 = Tessellator.INSTANCE;
        disableLighting();
        final Tessellator instance8 = Tessellator.INSTANCE;
        depthMask(false);
        final Tessellator instance9 = Tessellator.INSTANCE;
        disableDepth();
        final Tessellator instance10 = Tessellator.INSTANCE;
        enableBlend();
        final Tessellator instance11 = Tessellator.INSTANCE;
        blendFunc(770, 771);
        final int textWidth = fontRenderer.getStringWidth(text);
        if (renderBlackBox) {
            final int j = textWidth / 2;
            final Tessellator instance12 = Tessellator.INSTANCE;
            disableTexture2D();
            Tessellator.worldRenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
            Tessellator.worldRenderer.pos((double)(-j - 1), -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            Tessellator.worldRenderer.pos((double)(-j - 1), 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            Tessellator.worldRenderer.pos((double)(j + 1), 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            Tessellator.worldRenderer.pos((double)(j + 1), -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
            Tessellator.tessellator.draw();
            final Tessellator instance13 = Tessellator.INSTANCE;
            enableTexture2D();
        }
        fontRenderer.drawString(text, -textWidth / 2, 0, color);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final Tessellator instance14 = Tessellator.INSTANCE;
        depthMask(true);
        final Tessellator instance15 = Tessellator.INSTANCE;
        enableDepth();
        final Tessellator instance16 = Tessellator.INSTANCE;
        popMatrix();
    }
    
    public static /* synthetic */ void drawString$default(final String text, final float x, final float y, final float z, int color, boolean renderBlackBox, float scale, boolean increase, final int n, final Object o) {
        if ((n & 0x10) != 0x0) {
            color = -1;
        }
        if ((n & 0x20) != 0x0) {
            renderBlackBox = true;
        }
        if ((n & 0x40) != 0x0) {
            scale = 1.0f;
        }
        if ((n & 0x80) != 0x0) {
            increase = true;
        }
        drawString(text, x, y, z, color, renderBlackBox, scale, increase);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator begin(final int drawMode) {
        return begin$default(drawMode, false, 2, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator begin() {
        return begin$default(0, false, 3, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator colorize(final float red, final float green, final float blue) {
        return colorize$default(red, green, blue, 0.0f, 8, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator scale(final float x, final float y) {
        return scale$default(x, y, 0.0f, 4, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Tessellator scale(final float x) {
        return scale$default(x, 0.0f, 0.0f, 6, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y, final float z, final int color, final boolean renderBlackBox, final float scale) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        drawString$default(text, x, y, z, color, renderBlackBox, scale, false, 128, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y, final float z, final int color, final boolean renderBlackBox) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        drawString$default(text, x, y, z, color, renderBlackBox, 0.0f, false, 192, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y, final float z, final int color) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        drawString$default(text, x, y, z, color, false, 0.0f, false, 224, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y, final float z) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        drawString$default(text, x, y, z, 0, false, 0.0f, false, 240, null);
    }
    
    static {
        INSTANCE = new Tessellator();
        Tessellator.tessellator = net.minecraft.client.renderer.Tessellator.getInstance();
        final net.minecraft.client.renderer.Tessellator tessellator = Tessellator.tessellator;
        Intrinsics.checkNotNullExpressionValue((Object)tessellator, "tessellator");
        Tessellator.worldRenderer = ExtensionsKt.getRenderer(tessellator);
        renderManager = Renderer.getRenderManager();
        Tessellator.firstVertex = true;
    }
}
