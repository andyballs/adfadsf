//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl;

import kotlin.jvm.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.*;
import dev.falsehonesty.asmhelper.dsl.writers.*;

@Metadata(mv = { 1, 5, 1 }, k = 2, xi = 48, d1 = { "\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005\u001a'\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005\u001a\u001f\u0010\r\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¨\u0006\u0011" }, d2 = { "applyField", "", "config", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/writers/FieldWriter$Builder;", "Lkotlin/ExtensionFunctionType;", "inject", "Ldev/falsehonesty/asmhelper/dsl/writers/InjectWriter$Builder;", "modify", "className", "", "modifyAction", "Ldev/falsehonesty/asmhelper/dsl/writers/GeneralModificationWriter$GeneralModificationDSL;", "overwrite", "Ldev/falsehonesty/asmhelper/dsl/writers/OverwriteWriter$Builder;", "remove", "Ldev/falsehonesty/asmhelper/dsl/writers/RemoveWriter$Builder;", "AsmHelper1.8.9" })
@JvmName(name = "Method")
public final class Method
{
    public static final void inject(@NotNull final Function1<? super InjectWriter.Builder, Unit> config) {
        Intrinsics.checkNotNullParameter((Object)config, "config");
        final InjectWriter.Builder writer = new InjectWriter.Builder();
        config.invoke((Object)writer);
        AsmHelper.INSTANCE.getAsmWriters().add(writer.build());
    }
    
    public static final void overwrite(@NotNull final Function1<? super OverwriteWriter.Builder, Unit> config) {
        Intrinsics.checkNotNullParameter((Object)config, "config");
        final OverwriteWriter.Builder writer = new OverwriteWriter.Builder();
        config.invoke((Object)writer);
        AsmHelper.INSTANCE.getAsmWriters().add(writer.build());
    }
    
    public static final void applyField(@NotNull final Function1<? super FieldWriter.Builder, Unit> config) {
        Intrinsics.checkNotNullParameter((Object)config, "config");
        final FieldWriter.Builder writer = new FieldWriter.Builder();
        config.invoke((Object)writer);
        AsmHelper.INSTANCE.getAsmWriters().add(writer.build());
    }
    
    public static final void remove(@NotNull final Function1<? super RemoveWriter.Builder, Unit> config) {
        Intrinsics.checkNotNullParameter((Object)config, "config");
        final RemoveWriter.Builder writer = new RemoveWriter.Builder();
        config.invoke((Object)writer);
        AsmHelper.INSTANCE.getAsmWriters().add(writer.build());
    }
    
    public static final void modify(@NotNull final String className, @NotNull final Function1<? super GeneralModificationWriter.GeneralModificationDSL, Unit> modifyAction) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)modifyAction, "modifyAction");
        AsmHelper.INSTANCE.getAsmWriters().add(new GeneralModificationWriter(className, modifyAction));
    }
}
