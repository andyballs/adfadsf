//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper;

import kotlin.*;
import org.jetbrains.annotations.*;
import dev.falsehonesty.asmhelper.dsl.*;
import kotlin.jvm.internal.*;
import java.util.*;
import kotlin.collections.*;
import net.minecraft.launchwrapper.*;
import dev.falsehonesty.asmhelper.remapping.*;
import dev.falsehonesty.asmhelper.printing.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR8\u0010\u001d\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u001e0\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010&¨\u0006'" }, d2 = { "Ldev/falsehonesty/asmhelper/AsmHelper;", "", "()V", "asmWriters", "", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "getAsmWriters", "()Ljava/util/List;", "classReplacers", "", "", "getClassReplacers", "()Ljava/util/Map;", "fieldMaps", "", "getFieldMaps$AsmHelper1_8_9", "setFieldMaps$AsmHelper1_8_9", "(Ljava/util/Map;)V", "<set-?>", "", "isDeobf", "()Z", "methodMaps", "getMethodMaps$AsmHelper1_8_9", "setMethodMaps$AsmHelper1_8_9", "remapper", "Ldev/falsehonesty/asmhelper/remapping/Remapper;", "getRemapper", "()Ldev/falsehonesty/asmhelper/remapping/Remapper;", "serviceLoader", "Ljava/util/ServiceLoader;", "Ldev/falsehonesty/asmhelper/ClassTransformationService;", "kotlin.jvm.PlatformType", "getServiceLoader$AsmHelper1_8_9", "()Ljava/util/ServiceLoader;", "verbose", "getVerbose", "setVerbose", "(Z)V", "AsmHelper1.8.9" })
public final class AsmHelper
{
    @NotNull
    public static final AsmHelper INSTANCE;
    @NotNull
    private static final Map<String, String> classReplacers;
    @NotNull
    private static final List<AsmWriter> asmWriters;
    @NotNull
    private static final Remapper remapper;
    private static boolean verbose;
    private static boolean isDeobf;
    @NotNull
    private static Map<String, String> fieldMaps;
    @NotNull
    private static Map<String, String> methodMaps;
    private static final ServiceLoader<ClassTransformationService> serviceLoader;
    
    private AsmHelper() {
    }
    
    @NotNull
    public final Map<String, String> getClassReplacers() {
        return AsmHelper.classReplacers;
    }
    
    @NotNull
    public final List<AsmWriter> getAsmWriters() {
        return AsmHelper.asmWriters;
    }
    
    @NotNull
    public final Remapper getRemapper() {
        return AsmHelper.remapper;
    }
    
    public final boolean getVerbose() {
        return AsmHelper.verbose;
    }
    
    public final void setVerbose(final boolean <set-?>) {
        AsmHelper.verbose = <set-?>;
    }
    
    public final boolean isDeobf() {
        return AsmHelper.isDeobf;
    }
    
    @NotNull
    public final Map<String, String> getFieldMaps$AsmHelper1_8_9() {
        return AsmHelper.fieldMaps;
    }
    
    public final void setFieldMaps$AsmHelper1_8_9(@NotNull final Map<String, String> <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        AsmHelper.fieldMaps = <set-?>;
    }
    
    @NotNull
    public final Map<String, String> getMethodMaps$AsmHelper1_8_9() {
        return AsmHelper.methodMaps;
    }
    
    public final void setMethodMaps$AsmHelper1_8_9(@NotNull final Map<String, String> <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        AsmHelper.methodMaps = <set-?>;
    }
    
    public final ServiceLoader<ClassTransformationService> getServiceLoader$AsmHelper1_8_9() {
        return AsmHelper.serviceLoader;
    }
    
    static {
        INSTANCE = new AsmHelper();
        classReplacers = new LinkedHashMap<String, String>();
        asmWriters = new ArrayList<AsmWriter>();
        AsmHelper.verbose = Boolean.parseBoolean(System.getProperty("asmhelper.verbose", "false"));
        AsmHelper.fieldMaps = (Map<String, String>)MapsKt.emptyMap();
        AsmHelper.methodMaps = (Map<String, String>)MapsKt.emptyMap();
        serviceLoader = ServiceLoader.load(ClassTransformationService.class);
        Boolean value2;
        try {
            final Boolean value = Launch.blackboard.get("fml.deobfuscatedEnvironment");
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            value2 = value;
        }
        catch (Exception e) {
            value2 = null;
        }
        final Boolean fmlDeobf = value2;
        final AsmHelper instance = AsmHelper.INSTANCE;
        AsmHelper.isDeobf = Intrinsics.areEqual((Object)fmlDeobf, (Object)true);
        Remapper remapper2;
        if (Intrinsics.areEqual((Object)fmlDeobf, (Object)true)) {
            remapper2 = new DeobfRemapper();
        }
        else if (Intrinsics.areEqual((Object)fmlDeobf, (Object)false)) {
            remapper2 = new ForgeRemapper();
        }
        else {
            final String property = System.getProperty("asmhelper.deobf", "false");
            Intrinsics.checkNotNull((Object)property);
            if (Boolean.parseBoolean(property)) {
                final AsmHelper instance2 = AsmHelper.INSTANCE;
                AsmHelper.isDeobf = true;
                remapper2 = new DeobfRemapper();
            }
            else {
                remapper2 = new NotchRemapper();
            }
        }
        remapper = remapper2;
        final StringBuilder append = new StringBuilder().append("Selected the ");
        final AsmHelper instance3 = AsmHelper.INSTANCE;
        PrintingKt.log$default(append.append(AsmHelper.remapper).append(" remapper").toString(), null, 2, null);
    }
}
