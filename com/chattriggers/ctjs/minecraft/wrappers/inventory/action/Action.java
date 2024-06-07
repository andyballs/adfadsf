//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.inventory.action;

import org.jetbrains.annotations.*;
import net.minecraft.entity.player.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import com.chattriggers.ctjs.minecraft.wrappers.inventory.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import java.util.*;
import kotlin.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0013" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "", "slot", "", "windowId", "(II)V", "getSlot", "()I", "setSlot", "(I)V", "getWindowId", "setWindowId", "complete", "", "doClick", "button", "mode", "Companion", "Type", "ctjs" })
public abstract class Action
{
    @NotNull
    public static final Companion Companion;
    private int slot;
    private int windowId;
    
    public Action(final int slot, final int windowId) {
        this.slot = slot;
        this.windowId = windowId;
    }
    
    public final int getSlot() {
        return this.slot;
    }
    
    public final void setSlot(final int <set-?>) {
        this.slot = <set-?>;
    }
    
    public final int getWindowId() {
        return this.windowId;
    }
    
    public final void setWindowId(final int <set-?>) {
        this.windowId = <set-?>;
    }
    
    @NotNull
    public final Action setSlot(final int slot) {
        final Action $this$setSlot_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setSlot_u24lambda_u2d0.setSlot(slot);
        return this;
    }
    
    @NotNull
    public final Action setWindowId(final int windowId) {
        final Action $this$setWindowId_u24lambda_u2d1 = this;
        final int n = 0;
        $this$setWindowId_u24lambda_u2d1.setWindowId(windowId);
        return this;
    }
    
    public abstract void complete();
    
    protected final void doClick(final int button, final int mode) {
        Client.Companion.getMinecraft().playerController.windowClick(this.windowId, this.slot, button, mode, (EntityPlayer)Player.getPlayer());
    }
    
    @JvmStatic
    @NotNull
    public static final Action of(@NotNull final Inventory inventory, final int slot, @NotNull final String typeString) {
        return Action.Companion.of(inventory, slot, typeString);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action$Companion;", "", "()V", "of", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action;", "inventory", "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/Inventory;", "slot", "", "typeString", "", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        @NotNull
        public final Action of(@NotNull final Inventory inventory, final int slot, @NotNull final String typeString) {
            Intrinsics.checkNotNullParameter((Object)inventory, "inventory");
            Intrinsics.checkNotNullParameter((Object)typeString, "typeString");
            final String upperCase = typeString.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Action action = null;
            switch (WhenMappings.$EnumSwitchMapping$0[Type.valueOf(upperCase).ordinal()]) {
                case 1: {
                    action = new ClickAction(slot, inventory.getWindowId());
                    break;
                }
                case 2: {
                    action = new DragAction(slot, inventory.getWindowId());
                    break;
                }
                case 3: {
                    action = new KeyAction(slot, inventory.getWindowId());
                    break;
                }
                case 4: {
                    action = new DropAction(slot, inventory.getWindowId());
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return action;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/inventory/action/Action$Type;", "", "(Ljava/lang/String;I)V", "CLICK", "DRAG", "KEY", "DROP", "ctjs" })
    public enum Type
    {
        CLICK, 
        DRAG, 
        KEY, 
        DROP;
        
        private static final /* synthetic */ Type[] $values() {
            return new Type[] { Type.CLICK, Type.DRAG, Type.KEY, Type.DROP };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
