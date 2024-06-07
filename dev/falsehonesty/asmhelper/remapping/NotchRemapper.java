//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.remapping;

import org.jetbrains.annotations.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;
import kotlin.jvm.internal.*;
import kotlin.io.*;
import kotlin.text.*;
import java.net.*;
import java.util.*;
import kotlin.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Ldev/falsehonesty/asmhelper/remapping/NotchRemapper;", "Ldev/falsehonesty/asmhelper/remapping/Remapper;", "()V", "classMappings", "", "", "fieldMappings", "Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "methodMappings", "remapClassName", "className", "remapDesc", "desc", "remapFieldName", "fieldDescriptor", "remapMethodName", "methodDescriptor", "AsmHelper1.8.9" })
public final class NotchRemapper implements Remapper
{
    @NotNull
    private final Map<String, String> classMappings;
    @NotNull
    private final Map<Descriptor, Descriptor> fieldMappings;
    @NotNull
    private final Map<Descriptor, Descriptor> methodMappings;
    
    public NotchRemapper() {
        this.classMappings = new LinkedHashMap<String, String>();
        this.fieldMappings = new LinkedHashMap<Descriptor, Descriptor>();
        this.methodMappings = new LinkedHashMap<Descriptor, Descriptor>();
        final URL resource = this.getClass().getResource("/mcp-notch.srg");
        Intrinsics.checkNotNullExpressionValue((Object)resource, "javaClass.getResource(\"/mcp-notch.srg\")");
        final String mappings = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        final Iterable $this$forEach$iv = StringsKt.split$default((CharSequence)mappings, new String[] { "\n" }, false, 0, 6, (Object)null);
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final String it = (String)element$iv;
            final int n = 0;
            if (StringsKt.startsWith$default(it, "CL: ", false, 2, (Object)null)) {
                final String s = it;
                final int beginIndex = 4;
                final String s2 = s;
                if (s2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring = s2.substring(beginIndex);
                Intrinsics.checkNotNullExpressionValue((Object)substring, "(this as java.lang.String).substring(startIndex)");
                final List split$default = StringsKt.split$default((CharSequence)substring, new String[] { " " }, false, 0, 6, (Object)null);
                final String deobf = split$default.get(0);
                final String obf = split$default.get(1);
                this.classMappings.put(deobf, obf);
            }
            else if (StringsKt.startsWith$default(it, "FD: ", false, 2, (Object)null)) {
                final String s3 = it;
                final int beginIndex2 = 4;
                final String s4 = s3;
                if (s4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring2 = s4.substring(beginIndex2);
                Intrinsics.checkNotNullExpressionValue((Object)substring2, "(this as java.lang.String).substring(startIndex)");
                final List split$default2 = StringsKt.split$default((CharSequence)substring2, new String[] { " " }, false, 0, 6, (Object)null);
                final String deobf = split$default2.get(0);
                final String obf = split$default2.get(1);
                final String s5 = deobf;
                final int beginIndex3 = 0;
                final int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence)deobf, "/", 0, false, 6, (Object)null);
                final String s6 = s5;
                if (s6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring3 = s6.substring(beginIndex3, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue((Object)substring3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                final String s7 = deobf;
                final int beginIndex4 = StringsKt.lastIndexOf$default((CharSequence)deobf, "/", 0, false, 6, (Object)null) + 1;
                final String s8 = s7;
                if (s8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring4 = s8.substring(beginIndex4);
                Intrinsics.checkNotNullExpressionValue((Object)substring4, "(this as java.lang.String).substring(startIndex)");
                final Descriptor deobfDescriptor = new Descriptor(substring3, substring4, "");
                final String s9 = obf;
                final int beginIndex5 = 0;
                final int lastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence)obf, "/", 0, false, 6, (Object)null);
                final String s10 = s9;
                if (s10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring5 = s10.substring(beginIndex5, lastIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue((Object)substring5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                final String s11 = obf;
                final int beginIndex6 = StringsKt.lastIndexOf$default((CharSequence)obf, "/", 0, false, 6, (Object)null) + 1;
                final String s12 = s11;
                if (s12 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring6 = s12.substring(beginIndex6);
                Intrinsics.checkNotNullExpressionValue((Object)substring6, "(this as java.lang.String).substring(startIndex)");
                final Descriptor obfDescriptor = new Descriptor(substring5, substring6, "");
                this.fieldMappings.put(deobfDescriptor, obfDescriptor);
            }
            else {
                if (!StringsKt.startsWith$default(it, "MD: ", false, 2, (Object)null)) {
                    continue;
                }
                final String s13 = it;
                final int beginIndex7 = 4;
                final String s14 = s13;
                if (s14 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring7 = s14.substring(beginIndex7);
                Intrinsics.checkNotNullExpressionValue((Object)substring7, "(this as java.lang.String).substring(startIndex)");
                final List split$default3 = StringsKt.split$default((CharSequence)substring7, new String[] { " " }, false, 0, 6, (Object)null);
                final String deobf = split$default3.get(0);
                final String deobfDesc = split$default3.get(1);
                final String obf2 = split$default3.get(2);
                final String obfDesc = split$default3.get(3);
                final String s15 = deobf;
                final int beginIndex8 = 0;
                final int lastIndexOf$default3 = StringsKt.lastIndexOf$default((CharSequence)deobf, "/", 0, false, 6, (Object)null);
                final String s16 = s15;
                if (s16 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring8 = s16.substring(beginIndex8, lastIndexOf$default3);
                Intrinsics.checkNotNullExpressionValue((Object)substring8, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                final String s17 = deobf;
                final int beginIndex9 = StringsKt.lastIndexOf$default((CharSequence)deobf, "/", 0, false, 6, (Object)null) + 1;
                final String s18 = s17;
                if (s18 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring9 = s18.substring(beginIndex9);
                Intrinsics.checkNotNullExpressionValue((Object)substring9, "(this as java.lang.String).substring(startIndex)");
                final Descriptor deobfDescriptor2 = new Descriptor(substring8, substring9, deobfDesc);
                final String s19 = obf2;
                final int beginIndex10 = 0;
                final int lastIndexOf$default4 = StringsKt.lastIndexOf$default((CharSequence)obf2, "/", 0, false, 6, (Object)null);
                final String s20 = s19;
                if (s20 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring10 = s20.substring(beginIndex10, lastIndexOf$default4);
                Intrinsics.checkNotNullExpressionValue((Object)substring10, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                final String s21 = obf2;
                final int beginIndex11 = StringsKt.lastIndexOf$default((CharSequence)obf2, "/", 0, false, 6, (Object)null) + 1;
                final String s22 = s21;
                if (s22 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                final String substring11 = s22.substring(beginIndex11);
                Intrinsics.checkNotNullExpressionValue((Object)substring11, "(this as java.lang.String).substring(startIndex)");
                final Descriptor obfDescriptor2 = new Descriptor(substring10, substring11, obfDesc);
                this.methodMappings.put(deobfDescriptor2, obfDescriptor2);
            }
        }
    }
    
    @NotNull
    @Override
    public String remapClassName(@NotNull final String className) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        final String s = this.classMappings.get(className);
        return (s == null) ? className : s;
    }
    
    @NotNull
    @Override
    public String remapMethodName(@NotNull final Descriptor methodDescriptor) {
        Intrinsics.checkNotNullParameter((Object)methodDescriptor, "methodDescriptor");
        final Descriptor descriptor = this.methodMappings.get(methodDescriptor);
        final String s = (descriptor == null) ? null : descriptor.getName();
        return (s == null) ? methodDescriptor.getName() : s;
    }
    
    @NotNull
    @Override
    public String remapFieldName(@NotNull final Descriptor fieldDescriptor) {
        Intrinsics.checkNotNullParameter((Object)fieldDescriptor, "fieldDescriptor");
        final Descriptor descriptor = this.fieldMappings.get(Descriptor.copy$default(fieldDescriptor, (String)null, (String)null, "", 3, (Object)null));
        final String s = (descriptor == null) ? null : descriptor.getName();
        return (s == null) ? fieldDescriptor.getName() : s;
    }
    
    @NotNull
    @Override
    public String remapDesc(@NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        throw (Throwable)new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
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
