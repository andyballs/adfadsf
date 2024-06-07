//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.remapping;

import kotlin.*;
import org.jetbrains.annotations.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¨\u0006\u0013" }, d2 = { "Ldev/falsehonesty/asmhelper/remapping/Remapper;", "", "mapFieldAccess", "", "fieldName", "mapInvocation", "methodName", "remapClassName", "className", "remapDesc", "desc", "remapFieldName", "fieldDescriptor", "Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "owner", "fieldDesc", "remapMethodName", "methodDescriptor", "methodDesc", "AsmHelper1.8.9" })
public interface Remapper
{
    @NotNull
    String remapClassName(@NotNull final String p0);
    
    @NotNull
    String remapMethodName(@NotNull final String p0, @NotNull final String p1, @NotNull final String p2);
    
    @NotNull
    String remapMethodName(@NotNull final Descriptor p0);
    
    @NotNull
    String remapFieldName(@NotNull final String p0, @NotNull final String p1, @NotNull final String p2);
    
    @NotNull
    String remapFieldName(@NotNull final Descriptor p0);
    
    @NotNull
    String remapDesc(@NotNull final String p0);
    
    @NotNull
    String mapInvocation(@NotNull final String p0);
    
    @NotNull
    String mapFieldAccess(@NotNull final String p0);
    
    @Metadata(mv = { 1, 5, 1 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        @NotNull
        public static String remapMethodName(@NotNull final Remapper this, @NotNull final String owner, @NotNull final String methodName, @NotNull final String methodDesc) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter((Object)owner, "owner");
            Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
            Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
            return this.remapMethodName(new Descriptor(owner, methodName, methodDesc));
        }
        
        @NotNull
        public static String remapFieldName(@NotNull final Remapper this, @NotNull final String owner, @NotNull final String fieldName, @NotNull final String fieldDesc) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter((Object)owner, "owner");
            Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
            Intrinsics.checkNotNullParameter((Object)fieldDesc, "fieldDesc");
            return this.remapFieldName(new Descriptor(owner, fieldName, fieldDesc));
        }
        
        @NotNull
        public static String mapInvocation(@NotNull final Remapper this, @NotNull final String methodName) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
            return methodName;
        }
        
        @NotNull
        public static String mapFieldAccess(@NotNull final Remapper this, @NotNull final String fieldName) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
            return fieldName;
        }
    }
}
