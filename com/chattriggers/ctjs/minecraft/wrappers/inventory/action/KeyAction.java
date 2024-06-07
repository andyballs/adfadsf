//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.action;

import kotlin.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/KeyAction;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "slot", "", "windowId", "(II)V", "key", "complete", "", "getKey", "setKey", "ctjs" })
public final class KeyAction extends Action
{
    private int key;
    
    public KeyAction(final int slot, final int windowId) {
        super(slot, windowId);
        this.key = -1;
    }
    
    public final int getKey() {
        return this.key;
    }
    
    @NotNull
    public final KeyAction setKey(final int key) {
        final KeyAction $this$setKey_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setKey_u24lambda_u2d0.key = key;
        return this;
    }
    
    public void complete() {
        this.doClick(this.key, 2);
    }
}
