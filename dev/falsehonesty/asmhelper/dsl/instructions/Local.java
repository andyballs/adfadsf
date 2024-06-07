//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import kotlin.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/Local;", "", "index", "", "type", "Ldev/falsehonesty/asmhelper/dsl/instructions/LocalType;", "(ILdev/falsehonesty/asmhelper/dsl/instructions/LocalType;)V", "getIndex", "()I", "getType", "()Ldev/falsehonesty/asmhelper/dsl/instructions/LocalType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "AsmHelper1.8.9" })
public final class Local
{
    private final int index;
    @NotNull
    private final LocalType type;
    
    public Local(final int index, @NotNull final LocalType type) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        this.index = index;
        this.type = type;
    }
    
    public final int getIndex() {
        return this.index;
    }
    
    @NotNull
    public final LocalType getType() {
        return this.type;
    }
    
    public final int component1() {
        return this.index;
    }
    
    @NotNull
    public final LocalType component2() {
        return this.type;
    }
    
    @NotNull
    public final Local copy(final int index, @NotNull final LocalType type) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        return new Local(index, type);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Local(index=" + this.index + ", type=" + this.type + ')';
    }
    
    @Override
    public int hashCode() {
        int result = Integer.hashCode(this.index);
        result = result * 31 + this.type.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Local)) {
            return false;
        }
        final Local local = (Local)other;
        return this.index == local.index && this.type == local.type;
    }
}
