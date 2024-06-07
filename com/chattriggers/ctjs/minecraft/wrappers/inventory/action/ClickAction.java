//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.action;

import kotlin.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/ClickAction;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "slot", "", "windowId", "(II)V", "clickType", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/ClickAction$ClickType;", "holdingShift", "", "itemInHand", "complete", "", "getClickType", "getHoldingShift", "getItemInHand", "setClickString", "", "setClickType", "setHoldingShift", "setItemInHand", "ClickType", "ctjs" })
public final class ClickAction extends Action
{
    private ClickType clickType;
    private boolean holdingShift;
    private boolean itemInHand;
    
    public ClickAction(final int slot, final int windowId) {
        super(slot, windowId);
        this.itemInHand = (Player.getHeldItem() != null);
    }
    
    @NotNull
    public final ClickType getClickType() {
        ClickType clickType;
        if ((clickType = this.clickType) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickType");
            clickType = null;
        }
        return clickType;
    }
    
    @NotNull
    public final ClickAction setClickType(@NotNull final ClickType clickType) {
        Intrinsics.checkNotNullParameter((Object)clickType, "clickType");
        final ClickAction $this$setClickType_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setClickType_u24lambda_u2d0.clickType = clickType;
        return this;
    }
    
    public final boolean getHoldingShift() {
        return this.holdingShift;
    }
    
    @NotNull
    public final ClickAction setHoldingShift(final boolean holdingShift) {
        final ClickAction $this$setHoldingShift_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setHoldingShift_u24lambda_u2d1.holdingShift = holdingShift;
        return this;
    }
    
    public final boolean getItemInHand() {
        return this.itemInHand;
    }
    
    @NotNull
    public final ClickAction setItemInHand(final boolean itemInHand) {
        final ClickAction $this$setItemInHand_u24lambda_u2d2 = this;
        final int n = 0;
        $this$setItemInHand_u24lambda_u2d2.itemInHand = itemInHand;
        return this;
    }
    
    @NotNull
    public final ClickAction setClickString(@NotNull final String clickType) {
        Intrinsics.checkNotNullParameter((Object)clickType, "clickType");
        final ClickAction $this$setClickString_u24lambda_u2d3 = this;
        final int n = 0;
        final ClickAction clickAction = $this$setClickString_u24lambda_u2d3;
        final String upperCase = clickType.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        clickAction.clickType = ClickType.valueOf(upperCase);
        return this;
    }
    
    public void complete() {
        ClickType clickType;
        if ((clickType = this.clickType) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickType");
            clickType = null;
        }
        final int mode = (clickType == ClickType.MIDDLE) ? 3 : (this.holdingShift ? 1 : 0);
        ClickType clickType2;
        if ((clickType2 = this.clickType) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickType");
            clickType2 = null;
        }
        this.doClick(clickType2.getButton(), mode);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/ClickAction$ClickType;", "", "button", "", "(Ljava/lang/String;II)V", "getButton", "()I", "LEFT", "RIGHT", "MIDDLE", "ctjs" })
    public enum ClickType
    {
        private final int button;
        
        LEFT(0), 
        RIGHT(1), 
        MIDDLE(2);
        
        private ClickType(final int button) {
            this.button = button;
        }
        
        public final int getButton() {
            return this.button;
        }
        
        private static final /* synthetic */ ClickType[] $values() {
            return new ClickType[] { ClickType.LEFT, ClickType.RIGHT, ClickType.MIDDLE };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
