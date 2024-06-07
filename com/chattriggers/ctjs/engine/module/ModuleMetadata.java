//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.module;

import kotlin.*;
import java.util.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ed\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001d\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001d\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bH\u00c6\u0003J\t\u00100\u001a\u00020\u0014H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0017\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u00c6\u0003J\u001d\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bH\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00f1\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u00c6\u0001J\u0013\u0010:\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010<\u001a\u00020=H\u00d6\u0001J\t\u0010>\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R%\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010#\"\u0004\b$\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017¨\u0006?" }, d2 = { "Lcom/chattriggers/ctjs/engine/module/ModuleMetadata;", "", "name", "", "version", "entry", "asmEntry", "asmExposedFunctions", "", "tags", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pictureLink", "creator", "description", "requires", "helpMessage", "changelog", "ignored", "isRequired", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Z)V", "getAsmEntry", "()Ljava/lang/String;", "getAsmExposedFunctions", "()Ljava/util/Map;", "getChangelog", "getCreator", "getDescription", "getEntry", "setEntry", "(Ljava/lang/String;)V", "getHelpMessage", "getIgnored", "()Ljava/util/ArrayList;", "()Z", "setRequired", "(Z)V", "getName", "getPictureLink", "getRequires", "getTags", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ctjs" })
public final class ModuleMetadata
{
    @Nullable
    private final String name;
    @Nullable
    private final String version;
    @Nullable
    private String entry;
    @Nullable
    private final String asmEntry;
    @Nullable
    private final Map<String, String> asmExposedFunctions;
    @Nullable
    private final ArrayList<String> tags;
    @Nullable
    private final String pictureLink;
    @Nullable
    private final String creator;
    @Nullable
    private final String description;
    @Nullable
    private final ArrayList<String> requires;
    @Nullable
    private final String helpMessage;
    @Nullable
    private final String changelog;
    @Nullable
    private final ArrayList<String> ignored;
    private boolean isRequired;
    
    public ModuleMetadata(@Nullable final String name, @Nullable final String version, @Nullable final String entry, @Nullable final String asmEntry, @Nullable final Map<String, String> asmExposedFunctions, @Nullable final ArrayList<String> tags, @Nullable final String pictureLink, @Nullable final String creator, @Nullable final String description, @Nullable final ArrayList<String> requires, @Nullable final String helpMessage, @Nullable final String changelog, @Nullable final ArrayList<String> ignored, final boolean isRequired) {
        this.name = name;
        this.version = version;
        this.entry = entry;
        this.asmEntry = asmEntry;
        this.asmExposedFunctions = asmExposedFunctions;
        this.tags = tags;
        this.pictureLink = pictureLink;
        this.creator = creator;
        this.description = description;
        this.requires = requires;
        this.helpMessage = helpMessage;
        this.changelog = changelog;
        this.ignored = ignored;
        this.isRequired = isRequired;
    }
    
    @Nullable
    public final String getName() {
        return this.name;
    }
    
    @Nullable
    public final String getVersion() {
        return this.version;
    }
    
    @Nullable
    public final String getEntry() {
        return this.entry;
    }
    
    public final void setEntry(@Nullable final String <set-?>) {
        this.entry = <set-?>;
    }
    
    @Nullable
    public final String getAsmEntry() {
        return this.asmEntry;
    }
    
    @Nullable
    public final Map<String, String> getAsmExposedFunctions() {
        return this.asmExposedFunctions;
    }
    
    @Nullable
    public final ArrayList<String> getTags() {
        return this.tags;
    }
    
    @Nullable
    public final String getPictureLink() {
        return this.pictureLink;
    }
    
    @Nullable
    public final String getCreator() {
        return this.creator;
    }
    
    @Nullable
    public final String getDescription() {
        return this.description;
    }
    
    @Nullable
    public final ArrayList<String> getRequires() {
        return this.requires;
    }
    
    @Nullable
    public final String getHelpMessage() {
        return this.helpMessage;
    }
    
    @Nullable
    public final String getChangelog() {
        return this.changelog;
    }
    
    @Nullable
    public final ArrayList<String> getIgnored() {
        return this.ignored;
    }
    
    public final boolean isRequired() {
        return this.isRequired;
    }
    
    public final void setRequired(final boolean <set-?>) {
        this.isRequired = <set-?>;
    }
    
    @Nullable
    public final String component1() {
        return this.name;
    }
    
    @Nullable
    public final String component2() {
        return this.version;
    }
    
    @Nullable
    public final String component3() {
        return this.entry;
    }
    
    @Nullable
    public final String component4() {
        return this.asmEntry;
    }
    
    @Nullable
    public final Map<String, String> component5() {
        return this.asmExposedFunctions;
    }
    
    @Nullable
    public final ArrayList<String> component6() {
        return this.tags;
    }
    
    @Nullable
    public final String component7() {
        return this.pictureLink;
    }
    
    @Nullable
    public final String component8() {
        return this.creator;
    }
    
    @Nullable
    public final String component9() {
        return this.description;
    }
    
    @Nullable
    public final ArrayList<String> component10() {
        return this.requires;
    }
    
    @Nullable
    public final String component11() {
        return this.helpMessage;
    }
    
    @Nullable
    public final String component12() {
        return this.changelog;
    }
    
    @Nullable
    public final ArrayList<String> component13() {
        return this.ignored;
    }
    
    public final boolean component14() {
        return this.isRequired;
    }
    
    @NotNull
    public final ModuleMetadata copy(@Nullable final String name, @Nullable final String version, @Nullable final String entry, @Nullable final String asmEntry, @Nullable final Map<String, String> asmExposedFunctions, @Nullable final ArrayList<String> tags, @Nullable final String pictureLink, @Nullable final String creator, @Nullable final String description, @Nullable final ArrayList<String> requires, @Nullable final String helpMessage, @Nullable final String changelog, @Nullable final ArrayList<String> ignored, final boolean isRequired) {
        return new ModuleMetadata(name, version, entry, asmEntry, asmExposedFunctions, tags, pictureLink, creator, description, requires, helpMessage, changelog, ignored, isRequired);
    }
    
    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ModuleMetadata(name=").append((Object)this.name).append(", version=").append((Object)this.version).append(", entry=").append((Object)this.entry).append(", asmEntry=").append((Object)this.asmEntry).append(", asmExposedFunctions=").append(this.asmExposedFunctions).append(", tags=").append(this.tags).append(", pictureLink=").append((Object)this.pictureLink).append(", creator=").append((Object)this.creator).append(", description=").append((Object)this.description).append(", requires=").append(this.requires).append(", helpMessage=").append((Object)this.helpMessage).append(", changelog=");
        sb.append((Object)this.changelog).append(", ignored=").append(this.ignored).append(", isRequired=").append(this.isRequired).append(')');
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        int result = (this.name == null) ? 0 : this.name.hashCode();
        result = result * 31 + ((this.version == null) ? 0 : this.version.hashCode());
        result = result * 31 + ((this.entry == null) ? 0 : this.entry.hashCode());
        result = result * 31 + ((this.asmEntry == null) ? 0 : this.asmEntry.hashCode());
        result = result * 31 + ((this.asmExposedFunctions == null) ? 0 : this.asmExposedFunctions.hashCode());
        result = result * 31 + ((this.tags == null) ? 0 : this.tags.hashCode());
        result = result * 31 + ((this.pictureLink == null) ? 0 : this.pictureLink.hashCode());
        result = result * 31 + ((this.creator == null) ? 0 : this.creator.hashCode());
        result = result * 31 + ((this.description == null) ? 0 : this.description.hashCode());
        result = result * 31 + ((this.requires == null) ? 0 : this.requires.hashCode());
        result = result * 31 + ((this.helpMessage == null) ? 0 : this.helpMessage.hashCode());
        result = result * 31 + ((this.changelog == null) ? 0 : this.changelog.hashCode());
        result = result * 31 + ((this.ignored == null) ? 0 : this.ignored.hashCode());
        final int n = result * 31;
        int isRequired;
        if ((isRequired = (this.isRequired ? 1 : 0)) != 0) {
            isRequired = 1;
        }
        result = n + isRequired;
        return result;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModuleMetadata)) {
            return false;
        }
        final ModuleMetadata moduleMetadata = (ModuleMetadata)other;
        return Intrinsics.areEqual((Object)this.name, (Object)moduleMetadata.name) && Intrinsics.areEqual((Object)this.version, (Object)moduleMetadata.version) && Intrinsics.areEqual((Object)this.entry, (Object)moduleMetadata.entry) && Intrinsics.areEqual((Object)this.asmEntry, (Object)moduleMetadata.asmEntry) && Intrinsics.areEqual((Object)this.asmExposedFunctions, (Object)moduleMetadata.asmExposedFunctions) && Intrinsics.areEqual((Object)this.tags, (Object)moduleMetadata.tags) && Intrinsics.areEqual((Object)this.pictureLink, (Object)moduleMetadata.pictureLink) && Intrinsics.areEqual((Object)this.creator, (Object)moduleMetadata.creator) && Intrinsics.areEqual((Object)this.description, (Object)moduleMetadata.description) && Intrinsics.areEqual((Object)this.requires, (Object)moduleMetadata.requires) && Intrinsics.areEqual((Object)this.helpMessage, (Object)moduleMetadata.helpMessage) && Intrinsics.areEqual((Object)this.changelog, (Object)moduleMetadata.changelog) && Intrinsics.areEqual((Object)this.ignored, (Object)moduleMetadata.ignored) && this.isRequired == moduleMetadata.isRequired;
    }
    
    public ModuleMetadata() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, 16383, null);
    }
}
