//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs.renderer;

import kotlin.*;
import java.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.entity.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraft.entity.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J<\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J*\u0010\u001a\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016JD\u0010\u001b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0014J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000eH\u0014J.\u0010!\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\"" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/CTRenderPlayer;", "Lnet/minecraft/client/renderer/entity/RenderPlayer;", "renderManager", "Lnet/minecraft/client/renderer/entity/RenderManager;", "useSmallArms", "", "(Lnet/minecraft/client/renderer/entity/RenderManager;Z)V", "showArmor", "showArrows", "showCape", "showHeldItem", "showNametag", "canRenderName", "entity", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "renderLivingLabel", "", "entityIn", "str", "", "x", "", "y", "z", "maxDistance", "", "renderName", "renderOffsetLivingLabel", "p_177069_9_", "", "p_177069_10_", "setModelVisibilities", "clientPlayer", "setOptions", "ctjs" })
public final class CTRenderPlayer extends RenderPlayer
{
    private boolean showNametag;
    private boolean showArmor;
    private boolean showCape;
    private boolean showHeldItem;
    private boolean showArrows;
    
    public CTRenderPlayer(@Nullable final RenderManager renderManager, final boolean useSmallArms) {
        super(renderManager, useSmallArms);
        this.showNametag = true;
        this.showArmor = true;
        this.showCape = true;
        this.showHeldItem = true;
        this.showArrows = true;
    }
    
    public final void setOptions(final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem, final boolean showArrows) {
        this.showNametag = showNametag;
        this.showArmor = showArmor;
        this.showCape = showCape;
        this.showHeldItem = showHeldItem;
        this.showArrows = showArrows;
        this.layerRenderers = new ArrayList();
        if (showArmor) {
            this.addLayer((LayerRenderer)new LayerBipedArmor((RendererLivingEntity)this));
        }
        if (showHeldItem) {
            this.addLayer((LayerRenderer)new LayerHeldItem((RendererLivingEntity)this));
        }
        if (showArrows) {
            this.addLayer((LayerRenderer)new LayerArrow((RendererLivingEntity)this));
        }
        this.addLayer((LayerRenderer)new LayerDeadmau5Head((RenderPlayer)this));
        if (showCape) {
            this.addLayer((LayerRenderer)new LayerCape((RenderPlayer)this));
        }
        if (showArmor) {
            this.addLayer((LayerRenderer)new LayerCustomHead(this.getMainModel().bipedHead));
        }
    }
    
    protected void setModelVisibilities(@NotNull final AbstractClientPlayer clientPlayer) {
        Intrinsics.checkNotNullParameter((Object)clientPlayer, "clientPlayer");
        super.setModelVisibilities(clientPlayer);
        if (!this.showHeldItem) {
            this.getMainModel().heldItemRight = 0;
        }
    }
    
    protected boolean canRenderName(@Nullable final AbstractClientPlayer entity) {
        return this.showNametag;
    }
    
    protected void renderOffsetLivingLabel(@Nullable final AbstractClientPlayer entityIn, final double x, final double y, final double z, @Nullable final String str, final float p_177069_9_, final double p_177069_10_) {
        if (this.showNametag) {
            super.renderOffsetLivingLabel(entityIn, x, y, z, str, p_177069_9_, p_177069_10_);
        }
    }
    
    public void renderName(@Nullable final AbstractClientPlayer entity, final double x, final double y, final double z) {
        if (this.showNametag) {
            super.renderName((EntityLivingBase)entity, x, y, z);
        }
    }
    
    protected void renderLivingLabel(@Nullable final AbstractClientPlayer entityIn, @Nullable final String str, final double x, final double y, final double z, final int maxDistance) {
        if (this.showNametag) {
            super.renderLivingLabel((Entity)entityIn, str, x, y, z, maxDistance);
        }
    }
}
