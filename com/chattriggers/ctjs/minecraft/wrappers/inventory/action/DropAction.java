//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.action;

import kotlin.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/DropAction;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "slot", "", "windowId", "(II)V", "holdingCtrl", "", "complete", "", "getHoldingCtrl", "setHoldingCtrl", "ctjs" })
public final class DropAction extends Action
{
    private boolean holdingCtrl;
    
    public DropAction(final int slot, final int windowId) {
        super(slot, windowId);
    }
    
    public final boolean getHoldingCtrl() {
        return this.holdingCtrl;
    }
    
    @NotNull
    public final DropAction setHoldingCtrl(final boolean holdingCtrl) {
        final DropAction $this$setHoldingCtrl_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setHoldingCtrl_u24lambda_u2d0.holdingCtrl = holdingCtrl;
        return this;
    }
    
    public void complete() {
        this.doClick((int)(this.holdingCtrl ? 1 : 0), 4);
    }
}
