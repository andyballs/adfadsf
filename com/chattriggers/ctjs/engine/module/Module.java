//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.module;

import kotlin.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.libs.renderer.*;
import com.chattriggers.ctjs.minecraft.libs.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\u00020&2\u0006\u0010\"\u001a\u00020&2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020&J\b\u0010(\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/Module;", "", "name", "", "metadata", "Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;", "folder", "Ljava/io/File;", "(Ljava/lang/String;Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;Ljava/io/File;)V", "getFolder", "()Ljava/io/File;", "gui", "com/chattriggers/ctjs/engine/module/Module$gui$1", "Lcom/chattriggers/ctjs/engine/module/Module$gui$1;", "getMetadata", "()Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;", "setMetadata", "(Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;)V", "getName", "()Ljava/lang/String;", "requiredBy", "", "getRequiredBy", "()Ljava/util/Set;", "setRequiredBy", "(Ljava/util/Set;)V", "targetModVersion", "Lcom/fasterxml/jackson/core/Version;", "getTargetModVersion", "()Lcom/fasterxml/jackson/core/Version;", "setTargetModVersion", "(Lcom/fasterxml/jackson/core/Version;)V", "click", "", "x", "", "y", "width", "", "draw", "toString", "ctjs" })
public final class Module
{
    @NotNull
    private final String name;
    @NotNull
    private ModuleMetadata metadata;
    @NotNull
    private final File folder;
    @Nullable
    private Version targetModVersion;
    @NotNull
    private Set<String> requiredBy;
    @NotNull
    private final Module$gui.Module$gui$1 gui;
    
    public Module(@NotNull final String name, @NotNull final ModuleMetadata metadata, @NotNull final File folder) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)metadata, "metadata");
        Intrinsics.checkNotNullParameter((Object)folder, "folder");
        this.name = name;
        this.metadata = metadata;
        this.folder = folder;
        this.requiredBy = new LinkedHashSet<String>();
        this.gui = new Module$gui.Module$gui$1(this);
    }
    
    @NotNull
    public final String getName() {
        return this.name;
    }
    
    @NotNull
    public final ModuleMetadata getMetadata() {
        return this.metadata;
    }
    
    public final void setMetadata(@NotNull final ModuleMetadata <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.metadata = <set-?>;
    }
    
    @NotNull
    public final File getFolder() {
        return this.folder;
    }
    
    @Nullable
    public final Version getTargetModVersion() {
        return this.targetModVersion;
    }
    
    public final void setTargetModVersion(@Nullable final Version <set-?>) {
        this.targetModVersion = <set-?>;
    }
    
    @NotNull
    public final Set<String> getRequiredBy() {
        return this.requiredBy;
    }
    
    public final void setRequiredBy(@NotNull final Set<String> <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.requiredBy = <set-?>;
    }
    
    public final float draw(final float x, final float y, final float width) {
        this.gui.setX(x);
        this.gui.setY(y);
        Renderer.drawRect(2852126720L, x, y, width, 13.0f);
        String text;
        if ((text = this.metadata.getName()) == null) {
            text = this.name;
        }
        Renderer.drawStringWithShadow(text, x + 3, y + 3);
        float n;
        if (this.gui.getCollapsed()) {
            Renderer.translate$default(x + width - 5, y + 8, 0.0f, 4, null);
            Renderer.rotate(180.0f);
            Renderer.drawString$default("^", 0.0f, 0.0f, false, 8, null);
            n = 15.0f;
        }
        else {
            this.gui.getDescription().setMaxWidth((int)width - 5);
            Renderer.drawRect(1342177280L, x, y + 13, width, this.gui.getDescription().getHeight() + 12);
            Renderer.drawString$default("^", x + width - 10, y + 5, false, 8, null);
            this.gui.getDescription().draw(x + 3, y + 15);
            if (this.metadata.getVersion() != null) {
                Renderer.drawStringWithShadow(ChatLib.addColor(Intrinsics.stringPlus("&8v", (Object)this.metadata.getVersion())), x + width - Renderer.getStringWidth(ChatLib.addColor(Intrinsics.stringPlus("&8v", (Object)this.metadata.getVersion()))), y + this.gui.getDescription().getHeight() + 15);
            }
            Renderer.drawStringWithShadow(ChatLib.addColor((this.metadata.isRequired() && !this.requiredBy.isEmpty()) ? Intrinsics.stringPlus("&8required by ", (Object)this.requiredBy) : "&4[delete]"), x + 3, y + this.gui.getDescription().getHeight() + 15);
            n = this.gui.getDescription().getHeight() + 27;
        }
        return n;
    }
    
    public final void click(final int x, final int y, final float width) {
        if (x > this.gui.getX() && x < this.gui.getX() + width && y > this.gui.getY() && y < this.gui.getY() + 13) {
            this.gui.setCollapsed(!this.gui.getCollapsed());
            return;
        }
        if (this.gui.getCollapsed() || (this.metadata.isRequired() && !this.requiredBy.isEmpty())) {
            return;
        }
        if (x > this.gui.getX() && x < this.gui.getX() + 45 && y > this.gui.getY() + this.gui.getDescription().getHeight() + 15 && y < this.gui.getY() + this.gui.getDescription().getHeight() + 25) {
            ModuleManager.INSTANCE.deleteModule(this.name);
        }
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Module{name=" + this.name + ",version=" + (Object)this.metadata.getVersion() + '}';
    }
}
