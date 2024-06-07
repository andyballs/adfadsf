//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import kotlin.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "", "owner", "", "name", "desc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getName", "getOwner", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AsmHelper1.8.9" })
public final class Descriptor
{
    @NotNull
    private final String owner;
    @NotNull
    private final String name;
    @NotNull
    private final String desc;
    
    public Descriptor(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        this.owner = owner;
        this.name = name;
        this.desc = desc;
    }
    
    @NotNull
    public final String getOwner() {
        return this.owner;
    }
    
    @NotNull
    public final String getName() {
        return this.name;
    }
    
    @NotNull
    public final String getDesc() {
        return this.desc;
    }
    
    @NotNull
    public final String component1() {
        return this.owner;
    }
    
    @NotNull
    public final String component2() {
        return this.name;
    }
    
    @NotNull
    public final String component3() {
        return this.desc;
    }
    
    @NotNull
    public final Descriptor copy(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return new Descriptor(owner, name, desc);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Descriptor(owner=" + this.owner + ", name=" + this.name + ", desc=" + this.desc + ')';
    }
    
    @Override
    public int hashCode() {
        int result = this.owner.hashCode();
        result = result * 31 + this.name.hashCode();
        result = result * 31 + this.desc.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Descriptor)) {
            return false;
        }
        final Descriptor descriptor = (Descriptor)other;
        return Intrinsics.areEqual((Object)this.owner, (Object)descriptor.owner) && Intrinsics.areEqual((Object)this.name, (Object)descriptor.name) && Intrinsics.areEqual((Object)this.desc, (Object)descriptor.desc);
    }
}
