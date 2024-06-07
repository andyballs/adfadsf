//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.module;

import net.minecraft.client.gui.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import kotlin.collections.*;
import net.minecraft.client.entity.*;
import org.lwjgl.input.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0012" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/ModulesGui;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "window", "com/chattriggers/ctjs/engine/module/ModulesGui$window$1", "Lcom/chattriggers/ctjs/engine/module/ModulesGui$window$1;", "doesGuiPauseGame", "", "drawScreen", "", "mouseX", "", "mouseY", "partialTicks", "", "handleMouseInput", "mouseClicked", "button", "ctjs" })
public final class ModulesGui extends GuiScreen
{
    @NotNull
    public static final ModulesGui INSTANCE;
    @NotNull
    private static final ModulesGui$window.ModulesGui$window$1 window;
    
    private ModulesGui() {
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.pushMatrix();
        final float middle = Renderer.screen.getWidth() / 2.0f;
        float width = 0.0f;
        width = Renderer.screen.getWidth() - 100.0f;
        if (width > 500.0f) {
            width = 500.0f;
        }
        Renderer.drawRect(1342177280L, 0.0f, 0.0f, (float)Renderer.screen.getWidth(), (float)Renderer.screen.getHeight());
        if (-ModulesGui.window.getScroll() > ModulesGui.window.getHeight() - Renderer.screen.getHeight() + 20) {
            ModulesGui.window.setScroll(-ModulesGui.window.getHeight() + Renderer.screen.getHeight() - 20);
        }
        if (-ModulesGui.window.getScroll() < 0.0f) {
            ModulesGui.window.setScroll(0.0f);
        }
        if (-ModulesGui.window.getScroll() > 0.0f) {
            Renderer.drawRect(2852126720L, Renderer.screen.getWidth() - 20.0f, Renderer.screen.getHeight() - 20.0f, 20.0f, 20.0f);
            Renderer.drawString$default("^", Renderer.screen.getWidth() - 12.0f, Renderer.screen.getHeight() - 12.0f, false, 8, null);
        }
        Renderer.drawRect(1342177280L, middle - width / 2.0f, ModulesGui.window.getScroll() + 95.0f, width, ModulesGui.window.getHeight() - 90);
        Renderer.drawRect(2852126720L, middle - width / 2.0f, ModulesGui.window.getScroll() + 95.0f, width, 25.0f);
        ModulesGui.window.getTitle().draw(middle - width / 2.0f + 5, ModulesGui.window.getScroll() + 100.0f);
        ModulesGui.window.getExit().setString(ChatLib.addColor("&cx")).draw(middle + width / 2.0f - 17, ModulesGui.window.getScroll() + 99.0f);
        ModulesGui.window.setHeight(125.0f);
        final Iterable $this$forEach$iv = ModuleManager.INSTANCE.getCachedModules();
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Module it = (Module)element$iv;
            final int n = 0;
            final ModulesGui$window.ModulesGui$window$1 window = ModulesGui.window;
            window.setHeight(window.getHeight() + it.draw(middle - width / 2.0f, ModulesGui.window.getScroll() + ModulesGui.window.getHeight(), width));
        }
        GlStateManager.popMatrix();
    }
    
    protected void mouseClicked(final int mouseX, final int mouseY, final int button) {
        super.mouseClicked(mouseX, mouseY, button);
        float width = 0.0f;
        width = Renderer.screen.getWidth() - 100.0f;
        if (width > 500.0f) {
            width = 500.0f;
        }
        if (mouseX > Renderer.screen.getWidth() - 20 && mouseY > Renderer.screen.getHeight() - 20) {
            ModulesGui.window.setScroll(0.0f);
            return;
        }
        if (mouseX > Renderer.screen.getWidth() / 2.0f + width / 2.0f - 25 && mouseX < Renderer.screen.getWidth() / 2.0f + width / 2.0f && mouseY > ModulesGui.window.getScroll() + 95 && mouseY < ModulesGui.window.getScroll() + 120) {
            final EntityPlayerSP player = Player.getPlayer();
            if (player != null) {
                player.closeScreen();
            }
            return;
        }
        final Iterable $this$forEach$iv = CollectionsKt.toList((Iterable)ModuleManager.INSTANCE.getCachedModules());
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Module it = (Module)element$iv;
            final int n = 0;
            it.click(mouseX, mouseY, width);
        }
    }
    
    public void handleMouseInput() {
        super.handleMouseInput();
        final int i = Mouse.getEventDWheel();
        final ModulesGui$window.ModulesGui$window$1 window = ModulesGui.window;
        window.setScroll(window.getScroll() + i / 10);
    }
    
    static {
        INSTANCE = new ModulesGui();
        window = new ModulesGui$window.ModulesGui$window$1();
    }
}
