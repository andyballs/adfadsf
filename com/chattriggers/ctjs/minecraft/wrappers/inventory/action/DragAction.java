//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.action;

import kotlin.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/DragAction;", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "slot", "", "windowId", "(II)V", "clickType", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/DragAction$ClickType;", "stage", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/DragAction$Stage;", "complete", "", "getClickType", "getStage", "setClickString", "", "setClickType", "setStage", "setStageString", "ClickType", "Stage", "ctjs" })
public final class DragAction extends Action
{
    private ClickType clickType;
    private Stage stage;
    
    public DragAction(final int slot, final int windowId) {
        super(slot, windowId);
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
    public final DragAction setClickType(@NotNull final ClickType clickType) {
        Intrinsics.checkNotNullParameter((Object)clickType, "clickType");
        final DragAction $this$setClickType_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setClickType_u24lambda_u2d0.clickType = clickType;
        return this;
    }
    
    @NotNull
    public final Stage getStage() {
        Stage stage;
        if ((stage = this.stage) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stage");
            stage = null;
        }
        return stage;
    }
    
    @NotNull
    public final DragAction setStage(@NotNull final Stage stage) {
        Intrinsics.checkNotNullParameter((Object)stage, "stage");
        final DragAction $this$setStage_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setStage_u24lambda_u2d1.stage = stage;
        return this;
    }
    
    @NotNull
    public final DragAction setClickString(@NotNull final String clickType) {
        Intrinsics.checkNotNullParameter((Object)clickType, "clickType");
        final DragAction $this$setClickString_u24lambda_u2d2 = this;
        final int n = 0;
        final DragAction dragAction = $this$setClickString_u24lambda_u2d2;
        final String upperCase = clickType.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        dragAction.clickType = ClickType.valueOf(upperCase);
        return this;
    }
    
    @NotNull
    public final DragAction setStageString(@NotNull final String stage) {
        Intrinsics.checkNotNullParameter((Object)stage, "stage");
        final DragAction $this$setStageString_u24lambda_u2d3 = this;
        final int n = 0;
        final DragAction dragAction = $this$setStageString_u24lambda_u2d3;
        final String upperCase = stage.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        dragAction.stage = Stage.valueOf(upperCase);
        return this;
    }
    
    public void complete() {
        Stage stage;
        if ((stage = this.stage) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stage");
            stage = null;
        }
        final int n = stage.getStage() & 0x3;
        ClickType clickType;
        if ((clickType = this.clickType) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickType");
            clickType = null;
        }
        final int button = (n | (clickType.getButton() & 0x3)) << 2;
        Stage stage2;
        if ((stage2 = this.stage) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stage");
            stage2 = null;
        }
        if (stage2 != Stage.SLOT) {
            this.setSlot(-999);
            System.out.println((Object)"Enforcing slot of -999");
        }
        this.doClick(button, 5);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/DragAction$ClickType;", "", "button", "", "(Ljava/lang/String;II)V", "getButton", "()I", "LEFT", "RIGHT", "MIDDLE", "ctjs" })
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
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/DragAction$Stage;", "", "stage", "", "(Ljava/lang/String;II)V", "getStage", "()I", "BEGIN", "SLOT", "END", "ctjs" })
    public enum Stage
    {
        private final int stage;
        
        BEGIN(0), 
        SLOT(1), 
        END(2);
        
        private Stage(final int stage) {
            this.stage = stage;
        }
        
        public final int getStage() {
            return this.stage;
        }
        
        private static final /* synthetic */ Stage[] $values() {
            return new Stage[] { Stage.BEGIN, Stage.SLOT, Stage.END };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
