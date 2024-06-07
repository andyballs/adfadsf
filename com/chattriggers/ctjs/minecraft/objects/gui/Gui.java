//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.objects.gui;

import net.minecraft.client.gui.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.minecraft.listeners.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.client.entity.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.triggers.*;
import net.minecraft.client.renderer.*;
import kotlin.jvm.*;
import java.util.*;
import com.chattriggers.ctjs.engine.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0014\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0014J<\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0000J\u0006\u0010!\u001a\u00020\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u001e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ$\u0010%\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0&2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tJ \u0010'\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010(\u001a\u00020)H\u0016J&\u0010*\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tJ\u0010\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010/\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u00100\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u00101\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u00102\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\r\u00103\u001a\u000204H ¢\u0006\u0002\b5J\b\u00106\u001a\u00020\u0016H\u0016J\u0006\u00107\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u0007J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\tH\u0014J(\u0010?\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020BH\u0014J \u0010C\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0014J \u0010D\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0014J\b\u0010E\u001a\u00020\u0016H\u0016J\u0006\u0010F\u001a\u00020\u0016J\u0010\u0010G\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010K\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010L\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010M\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010N\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010O\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010P\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u0010\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020IJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tJ\u0016\u0010S\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010T\u001a\u00020\u0007J\u0016\u0010U\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ\u001e\u0010V\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tJ\u0016\u0010W\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u0007J\u0016\u0010Y\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tJ\u0016\u0010Z\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tJ\u0016\u0010[\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/objects/gui/Gui;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "buttons", "", "Lnet/minecraft/client/gui/GuiButton;", "doesPauseGame", "", "mouseX", "", "mouseY", "onActionPerformed", "Lcom/chattriggers/ctjs/triggers/RegularTrigger;", "onClick", "onClosed", "onDraw", "onKeyTyped", "onMouseDragged", "onMouseReleased", "onOpened", "onScroll", "actionPerformed", "", "button", "addButton", "buttonId", "x", "y", "width", "height", "buttonText", "", "clearButtons", "close", "doesGuiPauseGame", "drawCreativeTabHoveringString", "text", "drawHoveringString", "", "drawScreen", "partialTicks", "", "drawString", "color", "getButton", "getButtonEnabled", "getButtonHeight", "getButtonVisibility", "getButtonWidth", "getButtonX", "getButtonY", "getLoader", "Lcom/chattriggers/ctjs/engine/ILoader;", "getLoader$ctjs", "initGui", "isAltDown", "isControlDown", "isOpen", "isShiftDown", "keyTyped", "typedChar", "", "keyCode", "mouseClickMove", "clickedMouseButton", "timeSinceLastClick", "", "mouseClicked", "mouseReleased", "onGuiClosed", "open", "registerActionPerformed", "method", "", "registerClicked", "registerClosed", "registerDraw", "registerKeyTyped", "registerMouseDragged", "registerMouseReleased", "registerOpened", "registerScrolled", "removeButton", "setButtonEnabled", "enabled", "setButtonHeight", "setButtonLoc", "setButtonVisibility", "visible", "setButtonWidth", "setButtonX", "setButtonY", "setDoesPauseGame", "ctjs" })
public abstract class Gui extends GuiScreen
{
    @Nullable
    private RegularTrigger onDraw;
    @Nullable
    private RegularTrigger onClick;
    @Nullable
    private RegularTrigger onScroll;
    @Nullable
    private RegularTrigger onKeyTyped;
    @Nullable
    private RegularTrigger onMouseReleased;
    @Nullable
    private RegularTrigger onMouseDragged;
    @Nullable
    private RegularTrigger onActionPerformed;
    @Nullable
    private RegularTrigger onOpened;
    @Nullable
    private RegularTrigger onClosed;
    private int mouseX;
    private int mouseY;
    @NotNull
    private final List<GuiButton> buttons;
    private boolean doesPauseGame;
    
    public Gui() {
        this.buttons = new ArrayList<GuiButton>();
        this.mc = Client.Companion.getMinecraft();
        MouseListener.INSTANCE.registerScrollListener((Function3)new Function3<Double, Double, Integer, Unit>() {
            final /* synthetic */ Gui this$0;
            
            public final void invoke(final double x, final double y, final int delta) {
                if (this.this$0.isOpen()) {
                    final RegularTrigger access$getOnScroll$p = Gui.access$getOnScroll$p(this.this$0);
                    if (access$getOnScroll$p != null) {
                        access$getOnScroll$p.trigger(new Object[] { x, y, delta });
                    }
                }
            }
        });
    }
    
    public final void open() {
        GuiHandler.INSTANCE.openGui(this);
        final RegularTrigger onOpened = this.onOpened;
        if (onOpened != null) {
            onOpened.trigger(new Gui[] { this });
        }
    }
    
    public final void close() {
        if (this.isOpen()) {
            final EntityPlayerSP player = Player.getPlayer();
            if (player != null) {
                player.closeScreen();
            }
        }
    }
    
    public final boolean isOpen() {
        return Client.Companion.getMinecraft().currentScreen == this;
    }
    
    public final boolean isControlDown() {
        return GuiScreen.isCtrlKeyDown();
    }
    
    public final boolean isShiftDown() {
        return GuiScreen.isShiftKeyDown();
    }
    
    public final boolean isAltDown() {
        return GuiScreen.isAltKeyDown();
    }
    
    @Nullable
    public final RegularTrigger registerDraw(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerDraw_u24lambda_u2d0 = this;
        final int n = 0;
        return $this$registerDraw_u24lambda_u2d0.onDraw = new RegularTrigger(method, TriggerType.Other, $this$registerDraw_u24lambda_u2d0.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerClicked(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerClicked_u24lambda_u2d1 = this;
        final int n = 0;
        return $this$registerClicked_u24lambda_u2d1.onClick = new RegularTrigger(method, TriggerType.Other, $this$registerClicked_u24lambda_u2d1.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerScrolled(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerScrolled_u24lambda_u2d2 = this;
        final int n = 0;
        return $this$registerScrolled_u24lambda_u2d2.onScroll = new RegularTrigger(method, TriggerType.Other, $this$registerScrolled_u24lambda_u2d2.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerKeyTyped(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerKeyTyped_u24lambda_u2d3 = this;
        final int n = 0;
        return $this$registerKeyTyped_u24lambda_u2d3.onKeyTyped = new RegularTrigger(method, TriggerType.Other, $this$registerKeyTyped_u24lambda_u2d3.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerMouseDragged(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerMouseDragged_u24lambda_u2d4 = this;
        final int n = 0;
        return $this$registerMouseDragged_u24lambda_u2d4.onMouseDragged = new RegularTrigger(method, TriggerType.Other, $this$registerMouseDragged_u24lambda_u2d4.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerMouseReleased(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerMouseReleased_u24lambda_u2d5 = this;
        final int n = 0;
        return $this$registerMouseReleased_u24lambda_u2d5.onMouseReleased = new RegularTrigger(method, TriggerType.Other, $this$registerMouseReleased_u24lambda_u2d5.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerActionPerformed(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerActionPerformed_u24lambda_u2d6 = this;
        final int n = 0;
        return $this$registerActionPerformed_u24lambda_u2d6.onActionPerformed = new RegularTrigger(method, TriggerType.Other, $this$registerActionPerformed_u24lambda_u2d6.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerOpened(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerOpened_u24lambda_u2d7 = this;
        final int n = 0;
        return $this$registerOpened_u24lambda_u2d7.onOpened = new RegularTrigger(method, TriggerType.Other, $this$registerOpened_u24lambda_u2d7.getLoader$ctjs());
    }
    
    @Nullable
    public final RegularTrigger registerClosed(@NotNull final Object method) {
        Intrinsics.checkNotNullParameter(method, "method");
        final Gui $this$registerClosed_u24lambda_u2d8 = this;
        final int n = 0;
        return $this$registerClosed_u24lambda_u2d8.onClosed = new RegularTrigger(method, TriggerType.Other, $this$registerClosed_u24lambda_u2d8.getLoader$ctjs());
    }
    
    public void onGuiClosed() {
        super.onGuiClosed();
        final RegularTrigger onClosed = this.onClosed;
        if (onClosed != null) {
            onClosed.trigger(new Gui[] { this });
        }
    }
    
    protected void mouseClicked(final int mouseX, final int mouseY, final int button) {
        super.mouseClicked(mouseX, mouseY, button);
        final RegularTrigger onClick = this.onClick;
        if (onClick != null) {
            onClick.trigger(new Integer[] { mouseX, mouseY, button });
        }
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int button) {
        super.mouseReleased(mouseX, mouseY, button);
        final RegularTrigger onMouseReleased = this.onMouseReleased;
        if (onMouseReleased != null) {
            onMouseReleased.trigger(new Integer[] { mouseX, mouseY, button });
        }
    }
    
    protected void actionPerformed(@NotNull final GuiButton button) {
        Intrinsics.checkNotNullParameter((Object)button, "button");
        super.actionPerformed(button);
        final RegularTrigger onActionPerformed = this.onActionPerformed;
        if (onActionPerformed != null) {
            onActionPerformed.trigger(new Integer[] { button.id });
        }
    }
    
    protected void mouseClickMove(final int mouseX, final int mouseY, final int clickedMouseButton, final long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
        final RegularTrigger onMouseDragged = this.onMouseDragged;
        if (onMouseDragged != null) {
            onMouseDragged.trigger(new Object[] { mouseX, mouseY, clickedMouseButton, timeSinceLastClick });
        }
    }
    
    public void initGui() {
        super.initGui();
        this.buttonList.addAll(this.buttons);
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.pushMatrix();
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        final RegularTrigger onDraw = this.onDraw;
        if (onDraw != null) {
            onDraw.trigger(new Object[] { mouseX, mouseY, partialTicks });
        }
        GlStateManager.popMatrix();
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) {
        super.keyTyped(typedChar, keyCode);
        final RegularTrigger onKeyTyped = this.onKeyTyped;
        if (onKeyTyped != null) {
            onKeyTyped.trigger(new Object[] { typedChar, keyCode });
        }
    }
    
    public boolean doesGuiPauseGame() {
        return this.doesPauseGame;
    }
    
    @NotNull
    public final Gui setDoesPauseGame(final boolean doesPauseGame) {
        final Gui $this$setDoesPauseGame_u24lambda_u2d9 = this;
        final int n = 0;
        $this$setDoesPauseGame_u24lambda_u2d9.doesPauseGame = doesPauseGame;
        return this;
    }
    
    @NotNull
    public final Gui addButton(@NotNull final GuiButton button) {
        Intrinsics.checkNotNullParameter((Object)button, "button");
        final Gui $this$addButton_u24lambda_u2d10 = this;
        final int n = 0;
        $this$addButton_u24lambda_u2d10.buttons.add(button);
        $this$addButton_u24lambda_u2d10.onResize($this$addButton_u24lambda_u2d10.mc, $this$addButton_u24lambda_u2d10.width, $this$addButton_u24lambda_u2d10.height);
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final Gui addButton(final int buttonId, final int x, final int y, final int width, final int height, @NotNull final String buttonText) {
        Intrinsics.checkNotNullParameter((Object)buttonText, "buttonText");
        final Gui $this$addButton_u24lambda_u2d11 = this;
        final int n = 0;
        $this$addButton_u24lambda_u2d11.addButton(new GuiButton(buttonId, x, y, width, height, buttonText));
        return this;
    }
    
    public static /* synthetic */ Gui addButton$default(final Gui gui, final int buttonId, final int x, final int y, int width, int height, final String buttonText, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addButton");
        }
        if ((n & 0x8) != 0x0) {
            width = 200;
        }
        if ((n & 0x10) != 0x0) {
            height = 20;
        }
        return gui.addButton(buttonId, x, y, width, height, buttonText);
    }
    
    @NotNull
    public final Gui removeButton(final int buttonId) {
        final Gui $this$removeButton_u24lambda_u2d13 = this;
        final int n = 0;
        $this$removeButton_u24lambda_u2d13.buttons.removeIf(Gui::removeButton$lambda-13$lambda-12);
        $this$removeButton_u24lambda_u2d13.onResize($this$removeButton_u24lambda_u2d13.mc, $this$removeButton_u24lambda_u2d13.width, $this$removeButton_u24lambda_u2d13.height);
        return this;
    }
    
    @NotNull
    public final Gui clearButtons() {
        final Gui $this$clearButtons_u24lambda_u2d14 = this;
        final int n = 0;
        $this$clearButtons_u24lambda_u2d14.buttons.clear();
        $this$clearButtons_u24lambda_u2d14.onResize($this$clearButtons_u24lambda_u2d14.mc, $this$clearButtons_u24lambda_u2d14.width, $this$clearButtons_u24lambda_u2d14.height);
        return this;
    }
    
    @Nullable
    public final GuiButton getButton(final int buttonId) {
        final Iterable $this$firstOrNull$iv = this.buttons;
        final int $i$f$firstOrNull = 0;
        for (final Object element$iv : $this$firstOrNull$iv) {
            final GuiButton it = (GuiButton)element$iv;
            final int n = 0;
            if (it.id == buttonId) {
                final Object o = element$iv;
                return (GuiButton)o;
            }
        }
        final Object o = null;
        return (GuiButton)o;
    }
    
    public final boolean getButtonVisibility(final int buttonId) {
        final GuiButton button = this.getButton(buttonId);
        return button != null && button.visible;
    }
    
    @NotNull
    public final Gui setButtonVisibility(final int buttonId, final boolean visible) {
        final Gui $this$setButtonVisibility_u24lambda_u2d16 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonVisibility_u24lambda_u2d16.getButton(buttonId);
        if (button != null) {
            button.visible = visible;
        }
        return this;
    }
    
    public final boolean getButtonEnabled(final int buttonId) {
        final GuiButton button = this.getButton(buttonId);
        return button != null && button.enabled;
    }
    
    @NotNull
    public final Gui setButtonEnabled(final int buttonId, final boolean enabled) {
        final Gui $this$setButtonEnabled_u24lambda_u2d17 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonEnabled_u24lambda_u2d17.getButton(buttonId);
        if (button != null) {
            button.enabled = enabled;
        }
        return this;
    }
    
    public final int getButtonWidth(final int buttonId) {
        final GuiButton button = this.getButton(buttonId);
        return (button == null) ? 0 : button.width;
    }
    
    @NotNull
    public final Gui setButtonWidth(final int buttonId, final int width) {
        final Gui $this$setButtonWidth_u24lambda_u2d18 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonWidth_u24lambda_u2d18.getButton(buttonId);
        if (button != null) {
            button.width = width;
        }
        return this;
    }
    
    public final int getButtonHeight(final int buttonId) {
        final GuiButton button = this.getButton(buttonId);
        return (button == null) ? 0 : button.height;
    }
    
    @NotNull
    public final Gui setButtonHeight(final int buttonId, final int height) {
        final Gui $this$setButtonHeight_u24lambda_u2d19 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonHeight_u24lambda_u2d19.getButton(buttonId);
        if (button != null) {
            button.height = height;
        }
        return this;
    }
    
    public final int getButtonX(final int buttonId) {
        final GuiButton button = this.getButton(buttonId);
        return (button == null) ? 0 : button.xPosition;
    }
    
    @NotNull
    public final Gui setButtonX(final int buttonId, final int x) {
        final Gui $this$setButtonX_u24lambda_u2d20 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonX_u24lambda_u2d20.getButton(buttonId);
        if (button != null) {
            button.xPosition = x;
        }
        return this;
    }
    
    public final int getButtonY(final int buttonId) {
        final GuiButton button = this.getButton(buttonId);
        return (button == null) ? 0 : button.yPosition;
    }
    
    @NotNull
    public final Gui setButtonY(final int buttonId, final int y) {
        final Gui $this$setButtonY_u24lambda_u2d21 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonY_u24lambda_u2d21.getButton(buttonId);
        if (button != null) {
            button.yPosition = y;
        }
        return this;
    }
    
    @NotNull
    public final Gui setButtonLoc(final int buttonId, final int x, final int y) {
        final Gui $this$setButtonLoc_u24lambda_u2d23 = this;
        final int n = 0;
        final GuiButton button = $this$setButtonLoc_u24lambda_u2d23.getButton(buttonId);
        if (button != null) {
            final GuiButton $this$setButtonLoc_u24lambda_u2d23_u24lambda_u2d22 = button;
            final int n2 = 0;
            $this$setButtonLoc_u24lambda_u2d23_u24lambda_u2d22.xPosition = x;
            $this$setButtonLoc_u24lambda_u2d23_u24lambda_u2d22.yPosition = y;
        }
        return this;
    }
    
    public final void drawString(@NotNull final String text, final int x, final int y, final int color) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        this.drawString(this.mc.fontRendererObj, text, x, y, color);
    }
    
    public final void drawCreativeTabHoveringString(@NotNull final String text, final int mouseX, final int mouseY) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        this.drawCreativeTabHoveringText(text, mouseX, mouseY);
    }
    
    public final void drawHoveringString(@NotNull final List<String> text, final int x, final int y) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        this.drawHoveringText((List)text, x, y, this.mc.fontRendererObj);
    }
    
    @NotNull
    public abstract ILoader getLoader$ctjs();
    
    @JvmOverloads
    @NotNull
    public final Gui addButton(final int buttonId, final int x, final int y, final int width, @NotNull final String buttonText) {
        Intrinsics.checkNotNullParameter((Object)buttonText, "buttonText");
        return addButton$default(this, buttonId, x, y, width, 0, buttonText, 16, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Gui addButton(final int buttonId, final int x, final int y, @NotNull final String buttonText) {
        Intrinsics.checkNotNullParameter((Object)buttonText, "buttonText");
        return addButton$default(this, buttonId, x, y, 0, 0, buttonText, 24, null);
    }
    
    private static final boolean removeButton$lambda-13$lambda-12(final int $buttonId, final GuiButton it) {
        Intrinsics.checkNotNullParameter((Object)it, "it");
        return it.id == $buttonId;
    }
    
    public static final /* synthetic */ RegularTrigger access$getOnScroll$p(final Gui $this) {
        return $this.onScroll;
    }
}
