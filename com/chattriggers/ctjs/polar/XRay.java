//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.polar;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraft.block.*;
import kotlin.jvm.internal.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0014\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u0006\u0010\u0015\u001a\u00020\u0010R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016" }, d2 = { "Lcom/chattriggers/ctjs/polar/XRay;", "", "()V", "blocks", "Ljava/util/HashSet;", "Lnet/minecraft/block/Block;", "Lkotlin/collections/HashSet;", "getBlocks", "()Ljava/util/HashSet;", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "addBlock", "", "block", "addBlocks", "list", "", "clear", "ctjs" })
public final class XRay
{
    @NotNull
    public static final XRay INSTANCE;
    private static boolean enabled;
    @NotNull
    private static final HashSet<Block> blocks;
    
    private XRay() {
    }
    
    public final boolean getEnabled() {
        return XRay.enabled;
    }
    
    public final void setEnabled(final boolean <set-?>) {
        XRay.enabled = <set-?>;
    }
    
    @NotNull
    public final HashSet<Block> getBlocks() {
        return XRay.blocks;
    }
    
    public final void addBlock(@NotNull final Block block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        XRay.blocks.add(block);
    }
    
    public final void addBlocks(@NotNull final List<? extends Block> list) {
        Intrinsics.checkNotNullParameter((Object)list, "list");
        XRay.blocks.addAll((Collection<?>)list);
    }
    
    public final void clear() {
        XRay.blocks.clear();
    }
    
    static {
        INSTANCE = new XRay();
        blocks = new HashSet<Block>();
    }
}
