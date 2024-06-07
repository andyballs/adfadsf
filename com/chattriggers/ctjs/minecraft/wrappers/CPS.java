//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import kotlin.jvm.*;
import kotlin.math.*;
import java.util.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0007J\b\u0010\u0018\u001a\u00020\u0005H\u0007J\b\u0010\u0019\u001a\u00020\u0005H\u0007J\b\u0010\u001a\u001a\u00020\u0005H\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u0005H\u0007J\u0016\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020 H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/CPS;", "", "()V", "leftClicks", "", "", "leftClicksAverage", "", "leftClicksMax", "rightClicks", "rightClicksAverage", "rightClicksMax", "sysTime", "", "clearOldLeft", "", "clearOldRight", "click", "event", "Lnet/minecraftforge/client/event/MouseEvent;", "decreaseClicks", "clicks", "findMax", "getLeftClicks", "getLeftClicksAverage", "getLeftClicksMax", "getRightClicks", "getRightClicksAverage", "getRightClicksMax", "limitAverage", "average", "update", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;", "ctjs" })
public final class CPS
{
    @NotNull
    public static final CPS INSTANCE;
    private static long sysTime;
    @NotNull
    private static List<Integer> leftClicks;
    @NotNull
    private static List<Integer> rightClicks;
    @NotNull
    private static List<Double> leftClicksAverage;
    @NotNull
    private static List<Double> rightClicksAverage;
    private static int leftClicksMax;
    private static int rightClicksMax;
    
    private CPS() {
    }
    
    @SubscribeEvent
    public final void update(@NotNull final RenderGameOverlayEvent$Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        while (Client.Companion.getSystemTime() > CPS.sysTime + 50L) {
            CPS.sysTime += 50L;
            this.decreaseClicks(CPS.leftClicks);
            this.decreaseClicks(CPS.rightClicks);
            CPS.leftClicksAverage.add((double)CPS.leftClicks.size());
            CPS.rightClicksAverage.add((double)CPS.rightClicks.size());
            this.limitAverage(CPS.leftClicksAverage);
            this.limitAverage(CPS.rightClicksAverage);
            this.clearOldLeft();
            this.clearOldRight();
            this.findMax();
        }
    }
    
    @SubscribeEvent
    public final void click(@NotNull final MouseEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (event.buttonstate) {
            switch (event.button) {
                case 0: {
                    CPS.leftClicks.add(20);
                    break;
                }
                case 1: {
                    CPS.rightClicks.add(20);
                    break;
                }
            }
        }
    }
    
    @JvmStatic
    public static final int getLeftClicksMax() {
        return CPS.leftClicksMax;
    }
    
    @JvmStatic
    public static final int getRightClicksMax() {
        return CPS.rightClicksMax;
    }
    
    @JvmStatic
    public static final int getLeftClicks() {
        return CPS.leftClicks.size();
    }
    
    @JvmStatic
    public static final int getRightClicks() {
        return CPS.rightClicks.size();
    }
    
    @JvmStatic
    public static final int getLeftClicksAverage() {
        if (CPS.leftClicksAverage.isEmpty()) {
            return 0;
        }
        double clicks = 0.0;
        final Iterator<Double> iterator = CPS.leftClicksAverage.iterator();
        while (iterator.hasNext()) {
            final double click = iterator.next().doubleValue();
            clicks += click;
        }
        return MathKt.roundToInt(clicks / CPS.leftClicksAverage.size());
    }
    
    @JvmStatic
    public static final int getRightClicksAverage() {
        if (CPS.rightClicksAverage.isEmpty()) {
            return 0;
        }
        double clicks = 0.0;
        final Iterator<Double> iterator = CPS.rightClicksAverage.iterator();
        while (iterator.hasNext()) {
            final double click = iterator.next().doubleValue();
            clicks += click;
        }
        return MathKt.roundToInt(clicks / CPS.rightClicksAverage.size());
    }
    
    private final void limitAverage(final List<Double> average) {
        if (average.size() > 100) {
            average.remove(0);
        }
    }
    
    private final void clearOldLeft() {
        if (!CPS.leftClicksAverage.isEmpty() && CPS.leftClicksAverage.get(CPS.leftClicksAverage.size() - 1).doubleValue() == 0.0) {
            CPS.leftClicksAverage.clear();
            CPS.leftClicksMax = 0;
        }
    }
    
    private final void clearOldRight() {
        if (!CPS.rightClicksAverage.isEmpty() && CPS.rightClicksAverage.get(CPS.rightClicksAverage.size() - 1).doubleValue() == 0.0) {
            CPS.rightClicksAverage.clear();
            CPS.rightClicksMax = 0;
        }
    }
    
    private final void findMax() {
        if (CPS.leftClicks.size() > CPS.leftClicksMax) {
            CPS.leftClicksMax = CPS.leftClicks.size();
        }
        if (CPS.rightClicks.size() > CPS.rightClicksMax) {
            CPS.rightClicksMax = CPS.rightClicks.size();
        }
    }
    
    private final void decreaseClicks(final List<Integer> clicks) {
        if (!clicks.isEmpty()) {
            final List toRemove = new ArrayList();
            int j = 0;
            while (j < clicks.size()) {
                final int i = j;
                ++j;
                clicks.set(i, clicks.get(i).intValue() - 1);
                if (clicks.get(i).intValue() == 0) {
                    toRemove.add(i);
                }
            }
            final Iterable $this$forEach$iv = CollectionsKt.sortedDescending((Iterable)toRemove);
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final int p0 = ((Number)element$iv).intValue();
                final int n = 0;
                clicks.remove(p0);
            }
        }
    }
    
    static {
        INSTANCE = new CPS();
        CPS.sysTime = Client.Companion.getSystemTime();
        CPS.leftClicks = new ArrayList<Integer>();
        CPS.rightClicks = new ArrayList<Integer>();
        CPS.leftClicksAverage = new ArrayList<Double>();
        CPS.rightClicksAverage = new ArrayList<Double>();
    }
}
