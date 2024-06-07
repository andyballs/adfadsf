//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.listeners;

import org.jetbrains.annotations.*;
import kotlin.*;
import kotlin.jvm.functions.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.triggers.*;
import org.lwjgl.input.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u000fJ(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\r\u0010\u001e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020$H\u0007J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0002Jh\u0010'\u001a\u00020\u000f2`\u0010(\u001a\\\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0005J}\u0010)\u001a\u00020\u000f2u\u0010(\u001aq\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011JS\u0010*\u001a\u00020\u000f2K\u0010(\u001aG\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000f0\u0019J\u0006\u0010+\u001a\u00020\u000fJ \u0010,\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000bH\u0002Rn\u0010\u0003\u001ab\u0012^\u0012\\\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0083\u0001\u0010\u0010\u001aw\u0012s\u0012q\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000RY\u0010\u0018\u001aM\u0012I\u0012G\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000f0\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006." }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/MouseListener;", "", "()V", "clickListeners", "", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "button", "", "pressed", "", "draggedListeners", "Lkotlin/Function5;", "deltaX", "deltaY", "draggedState", "", "Lcom/chattriggers/ctjs/minecraft/listeners/MouseListener$State;", "mouseState", "scrollListeners", "Lkotlin/Function3;", "delta", "clearListeners", "clicked", "dragged", "handleDragged", "handleDragged$ctjs", "onGuiMouseInput", "event", "Lnet/minecraftforge/client/event/GuiScreenEvent$MouseInputEvent$Pre;", "onMouseInput", "Lnet/minecraftforge/client/event/MouseEvent;", "process", "dWheel", "registerClickListener", "listener", "registerDraggedListener", "registerScrollListener", "registerTriggerListeners", "scrolled", "State", "ctjs" })
public final class MouseListener
{
    @NotNull
    public static final MouseListener INSTANCE;
    @NotNull
    private static final List<Function3<Double, Double, Integer, Unit>> scrollListeners;
    @NotNull
    private static final List<Function4<Double, Double, Integer, Boolean, Unit>> clickListeners;
    @NotNull
    private static final List<Function5<Double, Double, Double, Double, Integer, Unit>> draggedListeners;
    @NotNull
    private static final Map<Integer, Boolean> mouseState;
    @NotNull
    private static final Map<Integer, State> draggedState;
    
    private MouseListener() {
    }
    
    public final void registerScrollListener(@NotNull final Function3<? super Double, ? super Double, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter((Object)listener, "listener");
        MouseListener.scrollListeners.add((Function3<Double, Double, Integer, Unit>)listener);
    }
    
    public final void registerClickListener(@NotNull final Function4<? super Double, ? super Double, ? super Integer, ? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter((Object)listener, "listener");
        MouseListener.clickListeners.add((Function4<Double, Double, Integer, Boolean, Unit>)listener);
    }
    
    public final void registerDraggedListener(@NotNull final Function5<? super Double, ? super Double, ? super Double, ? super Double, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter((Object)listener, "listener");
        MouseListener.draggedListeners.add((Function5<Double, Double, Double, Double, Integer, Unit>)listener);
    }
    
    private final void scrolled(final double x, final double y, final int delta) {
        final Iterable $this$forEach$iv = MouseListener.scrollListeners;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Function3 it = (Function3)element$iv;
            final int n = 0;
            it.invoke((Object)x, (Object)y, (Object)delta);
        }
    }
    
    private final void clicked(final double x, final double y, final int button, final boolean pressed) {
        final Iterable $this$forEach$iv = MouseListener.clickListeners;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Function4 it = (Function4)element$iv;
            final int n = 0;
            it.invoke((Object)x, (Object)y, (Object)button, (Object)pressed);
        }
    }
    
    private final void dragged(final double deltaX, final double deltaY, final double x, final double y, final int button) {
        final Iterable $this$forEach$iv = MouseListener.draggedListeners;
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Function5 it = (Function5)element$iv;
            final int n = 0;
            it.invoke((Object)deltaX, (Object)deltaY, (Object)x, (Object)y, (Object)button);
        }
    }
    
    public final void clearListeners() {
        MouseListener.scrollListeners.clear();
        MouseListener.clickListeners.clear();
        MouseListener.draggedListeners.clear();
    }
    
    public final void registerTriggerListeners() {
        this.registerScrollListener((Function3<? super Double, ? super Double, ? super Integer, Unit>)new MouseListener$registerTriggerListeners.MouseListener$registerTriggerListeners$1((Object)TriggerType.Scrolled));
        this.registerClickListener((Function4<? super Double, ? super Double, ? super Integer, ? super Boolean, Unit>)new MouseListener$registerTriggerListeners.MouseListener$registerTriggerListeners$2((Object)TriggerType.Clicked));
        this.registerDraggedListener((Function5<? super Double, ? super Double, ? super Double, ? super Double, ? super Integer, Unit>)new MouseListener$registerTriggerListeners.MouseListener$registerTriggerListeners$3((Object)TriggerType.Dragged));
    }
    
    private final void process(final int button, final int dWheel) {
        if (dWheel != 0) {
            this.scrolled(Client.Companion.getMouseX(), Client.Companion.getMouseY(), (dWheel < 0) ? -1 : 1);
        }
        if (button == -1) {
            return;
        }
        if (Intrinsics.areEqual((Object)Mouse.isButtonDown(button), (Object)MouseListener.mouseState.get(button))) {
            return;
        }
        final double x = Client.Companion.getMouseX();
        final double y = Client.Companion.getMouseY();
        this.clicked(x, y, button, Mouse.isButtonDown(button));
        MouseListener.mouseState.put(button, Mouse.isButtonDown(button));
        if (Mouse.isButtonDown(button)) {
            MouseListener.draggedState.put(button, new State(x, y));
        }
        else if (MouseListener.draggedState.containsKey(button)) {
            MouseListener.draggedState.remove(button);
        }
    }
    
    @SubscribeEvent
    public final void onMouseInput(@NotNull final MouseEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        this.process(event.button, event.dwheel);
    }
    
    @SubscribeEvent
    public final void onGuiMouseInput(@NotNull final GuiScreenEvent$MouseInputEvent$Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (!World.isLoaded()) {
            MouseListener.mouseState.clear();
            MouseListener.draggedState.clear();
            return;
        }
        final int button = Mouse.getEventButton();
        final int dWheel = Mouse.getEventDWheel();
        this.process(button, dWheel);
    }
    
    public final void handleDragged$ctjs() {
        int i = 0;
        while (i < 5) {
            final int button = i;
            ++i;
            if (!MouseListener.draggedState.containsKey(button)) {
                continue;
            }
            final double x = Client.Companion.getMouseX();
            final double y = Client.Companion.getMouseY();
            final double n = x;
            final State state = MouseListener.draggedState.get(button);
            if (Intrinsics.areEqual(n, (state == null) ? null : Double.valueOf(state.getX()))) {
                final double n2 = y;
                final State state2 = MouseListener.draggedState.get(button);
                if (Intrinsics.areEqual(n2, (state2 == null) ? null : Double.valueOf(state2.getY()))) {
                    continue;
                }
            }
            final double n3 = x;
            final State state3 = MouseListener.draggedState.get(button);
            final double deltaX = n3 - ((state3 == null) ? 0.0 : state3.getX());
            final double n4 = y;
            final State state4 = MouseListener.draggedState.get(button);
            this.dragged(deltaX, n4 - ((state4 == null) ? 0.0 : state4.getY()), x, y, button);
            MouseListener.draggedState.put(button, new State(x, y));
        }
    }
    
    static {
        INSTANCE = new MouseListener();
        scrollListeners = new ArrayList<Function3<Double, Double, Integer, Unit>>();
        clickListeners = new ArrayList<Function4<Double, Double, Integer, Boolean, Unit>>();
        draggedListeners = new ArrayList<Function5<Double, Double, Double, Double, Integer, Unit>>();
        mouseState = new LinkedHashMap<Integer, Boolean>();
        draggedState = new LinkedHashMap<Integer, State>();
        MouseListener.INSTANCE.registerTriggerListeners();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/listeners/MouseListener$State;", "", "x", "", "y", "(DD)V", "getX", "()D", "getY", "ctjs" })
    public static final class State
    {
        private final double x;
        private final double y;
        
        public State(final double x, final double y) {
            this.x = x;
            this.y = y;
        }
        
        public final double getX() {
            return this.x;
        }
        
        public final double getY() {
            return this.y;
        }
    }
}
