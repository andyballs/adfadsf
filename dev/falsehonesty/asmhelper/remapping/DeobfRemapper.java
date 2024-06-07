//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.remapping;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\r" }, d2 = { "Ldev/falsehonesty/asmhelper/remapping/DeobfRemapper;", "Ldev/falsehonesty/asmhelper/remapping/Remapper;", "()V", "remapClassName", "", "className", "remapDesc", "desc", "remapFieldName", "fieldDescriptor", "Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "remapMethodName", "methodDescriptor", "AsmHelper1.8.9" })
public final class DeobfRemapper implements Remapper
{
    @NotNull
    @Override
    public String remapClassName(@NotNull final String className) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        return className;
    }
    
    @NotNull
    @Override
    public String remapMethodName(@NotNull final Descriptor methodDescriptor) {
        Intrinsics.checkNotNullParameter((Object)methodDescriptor, "methodDescriptor");
        return methodDescriptor.getName();
    }
    
    @NotNull
    @Override
    public String remapFieldName(@NotNull final Descriptor fieldDescriptor) {
        Intrinsics.checkNotNullParameter((Object)fieldDescriptor, "fieldDescriptor");
        return fieldDescriptor.getName();
    }
    
    @NotNull
    @Override
    public String remapDesc(@NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return desc;
    }
    
    @NotNull
    @Override
    public String mapFieldAccess(@NotNull final String fieldName) {
        return DefaultImpls.mapFieldAccess(this, fieldName);
    }
    
    @NotNull
    @Override
    public String mapInvocation(@NotNull final String methodName) {
        return DefaultImpls.mapInvocation(this, methodName);
    }
    
    @NotNull
    @Override
    public String remapFieldName(@NotNull final String owner, @NotNull final String fieldName, @NotNull final String fieldDesc) {
        return DefaultImpls.remapFieldName(this, owner, fieldName, fieldDesc);
    }
    
    @NotNull
    @Override
    public String remapMethodName(@NotNull final String owner, @NotNull final String methodName, @NotNull final String methodDesc) {
        return DefaultImpls.remapMethodName(this, owner, methodName, methodDesc);
    }
}
