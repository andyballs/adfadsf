//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl;

import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import org.objectweb.asm.tree.*;
import dev.falsehonesty.asmhelper.printing.*;
import kotlin.text.*;
import org.objectweb.asm.*;
import dev.falsehonesty.asmhelper.dsl.code.*;
import java.io.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J?\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0019\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\b\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "", "className", "", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "transform", "", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "transformToInstructions", "Lorg/objectweb/asm/tree/InsnList;", "insnListBuilder", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "Lkotlin/ExtensionFunctionType;", "codeBlockClassName", "method", "Lorg/objectweb/asm/tree/MethodNode;", "AsmWriterBuilder", "AsmHelper1.8.9" })
public abstract class AsmWriter
{
    @NotNull
    private final String className;
    
    public AsmWriter(@NotNull final String className) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        this.className = className;
    }
    
    @NotNull
    public final String getClassName() {
        return this.className;
    }
    
    public abstract void transform(@NotNull final ClassNode p0);
    
    @Nullable
    protected final InsnList transformToInstructions(@Nullable final Function1<? super InsnListBuilder, Unit> insnListBuilder, @Nullable final String codeBlockClassName, @NotNull final MethodNode method, @NotNull final ClassNode classNode) {
        Intrinsics.checkNotNullParameter((Object)method, "method");
        Intrinsics.checkNotNullParameter((Object)classNode, "classNode");
        InsnList list;
        if (insnListBuilder != null && codeBlockClassName != null) {
            PrintingKt.getLogger().error(this + " specifies both an insnList and a codeBlock, please pick one or the other.");
            list = null;
        }
        else if (insnListBuilder != null) {
            final InsnListBuilder builder = new InsnListBuilder(method);
            final Function1 it = insnListBuilder;
            final int n = 0;
            it.invoke((Object)builder);
            list = builder.build();
        }
        else if (codeBlockClassName != null) {
            final String clazzPath = Intrinsics.stringPlus(StringsKt.replace$default(codeBlockClassName, '.', '/', false, 4, (Object)null), (Object)".class");
            final InputStream clazzInputStream = this.getClass().getClassLoader().getResourceAsStream(clazzPath);
            final ClassReader clazzReader = new ClassReader(clazzInputStream);
            final ClassNode codeClassNode = new ClassNode();
            clazzReader.accept((ClassVisitor)codeClassNode, 4);
            final InjectCodeBuilder codeBuilder = new InjectCodeBuilder(codeClassNode, classNode, method);
            list = codeBuilder.transformToInstructions();
        }
        else {
            PrintingKt.getLogger().error(this + " does not have instructions to inject. You must specify an insnList or codeBlock.");
            list = null;
        }
        return list;
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/AsmWriter$AsmWriterBuilder;", "", "()V", "fullMcVersion", "", "getFullMcVersion", "()I", "mcVersion", "getMcVersion", "AsmHelper1.8.9" })
    public abstract static class AsmWriterBuilder
    {
        private final int fullMcVersion;
        private final int mcVersion;
        
        public AsmWriterBuilder() {
            this.fullMcVersion = 10809;
            this.mcVersion = 8;
        }
        
        public final int getFullMcVersion() {
            return this.fullMcVersion;
        }
        
        public final int getMcVersion() {
            return this.mcVersion;
        }
    }
}
