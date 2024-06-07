//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper;

import kotlin.*;
import net.minecraft.launchwrapper.*;
import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;
import kotlin.io.*;
import java.io.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0014J(\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Ldev/falsehonesty/asmhelper/BaseClassTransformer;", "Lnet/minecraft/launchwrapper/IClassTransformer;", "()V", "calledSetup", "", "debugClassLoading", "", "loadClassResource", "", "name", "", "makeTransformers", "setup", "classLoader", "Lnet/minecraft/launchwrapper/LaunchClassLoader;", "transform", "transformedName", "basicClass", "AsmHelper1.8.9" })
public abstract class BaseClassTransformer implements IClassTransformer
{
    private boolean calledSetup;
    
    public abstract void makeTransformers();
    
    private final void setup() {
        final ClassLoader classLoader2 = this.getClass().getClassLoader();
        if (classLoader2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type net.minecraft.launchwrapper.LaunchClassLoader");
        }
        final LaunchClassLoader classLoader = (LaunchClassLoader)classLoader2;
        classLoader.addTransformerExclusion("kotlin.");
        classLoader.addTransformerExclusion("dev.falsehonesty.asmhelper.");
        classLoader.addTransformerExclusion("org.objenesis.");
        classLoader.addTransformerExclusion(this.getClass().getName());
        this.setup(classLoader);
        this.makeTransformers();
    }
    
    protected final void debugClassLoading() {
        System.setProperty("legacy.debugClassLoading", "true");
        System.setProperty("legacy.debugClassLoadingSave", "true");
    }
    
    protected void setup(@NotNull final LaunchClassLoader classLoader) {
        Intrinsics.checkNotNullParameter((Object)classLoader, "classLoader");
    }
    
    @Nullable
    public byte[] transform(@Nullable final String name, @Nullable final String transformedName, @Nullable final byte[] basicClass) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: aload_0         /* this */
        //     7: getfield        dev/falsehonesty/asmhelper/BaseClassTransformer.calledSetup:Z
        //    10: ifne            22
        //    13: aload_0         /* this */
        //    14: invokespecial   dev/falsehonesty/asmhelper/BaseClassTransformer.setup:()V
        //    17: aload_0         /* this */
        //    18: iconst_1       
        //    19: putfield        dev/falsehonesty/asmhelper/BaseClassTransformer.calledSetup:Z
        //    22: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //    25: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getClassReplacers:()Ljava/util/Map;
        //    28: astore          5
        //    30: iconst_0       
        //    31: istore          6
        //    33: aload           5
        //    35: aload_2         /* transformedName */
        //    36: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    41: checkcast       Ljava/lang/String;
        //    44: astore          4
        //    46: aload           4
        //    48: ifnonnull       54
        //    51: goto            118
        //    54: aload           4
        //    56: astore          5
        //    58: iconst_0       
        //    59: istore          6
        //    61: iconst_0       
        //    62: istore          7
        //    64: aload           5
        //    66: astore          classFile
        //    68: iconst_0       
        //    69: istore          $i$a$-let-BaseClassTransformer$transform$1
        //    71: new             Ljava/lang/StringBuilder;
        //    74: dup            
        //    75: invokespecial   java/lang/StringBuilder.<init>:()V
        //    78: ldc             "Completely replacing "
        //    80: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    83: aload_2         /* transformedName */
        //    84: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    87: ldc             " with data from "
        //    89: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    92: aload           classFile
        //    94: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    97: bipush          46
        //    99: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   102: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   105: aconst_null    
        //   106: iconst_2       
        //   107: aconst_null    
        //   108: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   111: aload_0         /* this */
        //   112: aload           classFile
        //   114: invokespecial   dev/falsehonesty/asmhelper/BaseClassTransformer.loadClassResource:(Ljava/lang/String;)[B
        //   117: areturn        
        //   118: nop            
        //   119: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   122: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getAsmWriters:()Ljava/util/List;
        //   125: checkcast       Ljava/lang/Iterable;
        //   128: astore          5
        //   130: nop            
        //   131: iconst_0       
        //   132: istore          $i$f$filter
        //   134: aload           $this$filter$iv
        //   136: astore          7
        //   138: new             Ljava/util/ArrayList;
        //   141: dup            
        //   142: invokespecial   java/util/ArrayList.<init>:()V
        //   145: checkcast       Ljava/util/Collection;
        //   148: astore          destination$iv$iv
        //   150: iconst_0       
        //   151: istore          $i$f$filterTo
        //   153: aload           $this$filterTo$iv$iv
        //   155: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   160: astore          10
        //   162: aload           10
        //   164: invokeinterface java/util/Iterator.hasNext:()Z
        //   169: ifeq            226
        //   172: aload           10
        //   174: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   179: astore          element$iv$iv
        //   181: aload           element$iv$iv
        //   183: checkcast       Ldev/falsehonesty/asmhelper/dsl/AsmWriter;
        //   186: astore          it
        //   188: iconst_0       
        //   189: istore          $i$a$-filter-BaseClassTransformer$transform$writers$1
        //   191: aload           it
        //   193: invokevirtual   dev/falsehonesty/asmhelper/dsl/AsmWriter.getClassName:()Ljava/lang/String;
        //   196: bipush          47
        //   198: bipush          46
        //   200: iconst_0       
        //   201: iconst_4       
        //   202: aconst_null    
        //   203: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;CCZILjava/lang/Object;)Ljava/lang/String;
        //   206: aload_2         /* transformedName */
        //   207: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   210: ifeq            162
        //   213: aload           destination$iv$iv
        //   215: aload           element$iv$iv
        //   217: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   222: pop            
        //   223: goto            162
        //   226: aload           destination$iv$iv
        //   228: checkcast       Ljava/util/List;
        //   231: nop            
        //   232: checkcast       Ljava/util/Collection;
        //   235: astore          5
        //   237: iconst_0       
        //   238: istore          6
        //   240: aload           5
        //   242: invokeinterface java/util/Collection.isEmpty:()Z
        //   247: ifeq            255
        //   250: iconst_0       
        //   251: istore          $i$a$-ifEmpty-BaseClassTransformer$transform$writers$2
        //   253: aload_3         /* basicClass */
        //   254: areturn        
        //   255: aload           5
        //   257: checkcast       Ljava/util/List;
        //   260: astore          writers
        //   262: ldc             "Transforming class "
        //   264: aload_2         /* transformedName */
        //   265: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //   268: aconst_null    
        //   269: iconst_2       
        //   270: aconst_null    
        //   271: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   274: new             Lorg/objectweb/asm/ClassReader;
        //   277: dup            
        //   278: aload_3         /* basicClass */
        //   279: invokespecial   org/objectweb/asm/ClassReader.<init>:([B)V
        //   282: astore          classReader
        //   284: new             Lorg/objectweb/asm/tree/ClassNode;
        //   287: dup            
        //   288: invokespecial   org/objectweb/asm/tree/ClassNode.<init>:()V
        //   291: astore          classNode
        //   293: aload           classReader
        //   295: aload           classNode
        //   297: checkcast       Lorg/objectweb/asm/ClassVisitor;
        //   300: iconst_4       
        //   301: invokevirtual   org/objectweb/asm/ClassReader.accept:(Lorg/objectweb/asm/ClassVisitor;I)V
        //   304: aload           classNode
        //   306: bipush          52
        //   308: putfield        org/objectweb/asm/tree/ClassNode.version:I
        //   311: aload           writers
        //   313: checkcast       Ljava/lang/Iterable;
        //   316: astore          $this$forEach$iv
        //   318: iconst_0       
        //   319: istore          $i$f$forEach
        //   321: aload           $this$forEach$iv
        //   323: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   328: astore          9
        //   330: aload           9
        //   332: invokeinterface java/util/Iterator.hasNext:()Z
        //   337: ifeq            405
        //   340: aload           9
        //   342: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   347: astore          element$iv
        //   349: aload           element$iv
        //   351: checkcast       Ldev/falsehonesty/asmhelper/dsl/AsmWriter;
        //   354: astore          it
        //   356: iconst_0       
        //   357: istore          $i$a$-forEach-BaseClassTransformer$transform$2
        //   359: new             Ljava/lang/StringBuilder;
        //   362: dup            
        //   363: invokespecial   java/lang/StringBuilder.<init>:()V
        //   366: ldc             "Applying AsmWriter "
        //   368: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   371: aload           it
        //   373: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   376: ldc             " to class "
        //   378: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   381: aload_2         /* transformedName */
        //   382: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   385: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   388: aconst_null    
        //   389: iconst_2       
        //   390: aconst_null    
        //   391: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   394: aload           it
        //   396: aload           classNode
        //   398: invokevirtual   dev/falsehonesty/asmhelper/dsl/AsmWriter.transform:(Lorg/objectweb/asm/tree/ClassNode;)V
        //   401: nop            
        //   402: goto            330
        //   405: nop            
        //   406: new             Lorg/objectweb/asm/ClassWriter;
        //   409: dup            
        //   410: iconst_3       
        //   411: invokespecial   org/objectweb/asm/ClassWriter.<init>:(I)V
        //   414: astore          classWriter
        //   416: nop            
        //   417: aload           classNode
        //   419: aload           classWriter
        //   421: checkcast       Lorg/objectweb/asm/ClassVisitor;
        //   424: invokevirtual   org/objectweb/asm/tree/ClassNode.accept:(Lorg/objectweb/asm/ClassVisitor;)V
        //   427: goto            477
        //   430: astore          e
        //   432: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.getLogger:()Lorg/apache/logging/log4j/Logger;
        //   435: new             Ljava/lang/StringBuilder;
        //   438: dup            
        //   439: invokespecial   java/lang/StringBuilder.<init>:()V
        //   442: ldc             "Exception when transforming "
        //   444: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   447: aload_2         /* transformedName */
        //   448: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   451: ldc             " : "
        //   453: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   456: aload           e
        //   458: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   461: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //   464: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   467: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   470: aload           e
        //   472: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   477: aload           classWriter
        //   479: invokevirtual   org/objectweb/asm/ClassWriter.toByteArray:()[B
        //   482: areturn        
        //    StackMapTable: 00 0B 06 0F FE 00 1F 07 00 7B 07 00 75 01 3F FF 00 2B 00 0B 07 00 02 07 00 7B 07 00 7B 07 00 A9 07 00 7B 07 00 9E 01 07 00 9E 07 00 A3 01 07 00 AB 00 00 3F FF 00 1C 00 0B 07 00 02 07 00 7B 07 00 7B 07 00 A9 07 00 7B 07 00 A3 01 07 00 9E 07 00 A3 01 07 00 AB 00 00 FF 00 4A 00 0B 07 00 02 07 00 7B 07 00 7B 07 00 A9 07 00 C8 07 00 D3 07 00 D8 07 00 9E 01 07 00 AB 07 00 04 00 00 FB 00 4A FF 00 18 00 0B 07 00 02 07 00 7B 07 00 7B 07 00 A9 07 00 C8 07 00 D3 07 00 D8 07 00 EC 01 07 00 AB 07 00 04 00 01 07 00 65 FF 00 2E 00 0B 07 00 02 07 00 7B 07 00 7B 07 00 A9 07 00 C8 07 00 D3 07 00 D8 07 00 EC 00 07 00 AB 07 00 04 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  416    427    430    477    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final byte[] loadClassResource(final String name) {
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(name);
        Intrinsics.checkNotNullExpressionValue((Object)resourceAsStream, "this::class.java.classLoader.getResourceAsStream(name)");
        return ByteStreamsKt.readBytes(resourceAsStream);
    }
}
