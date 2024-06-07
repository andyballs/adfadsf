//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper;

import java.lang.instrument.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import java.security.*;
import kotlin.jvm.internal.*;
import kotlin.io.*;
import java.io.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH\u0002J@\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015" }, d2 = { "Ldev/falsehonesty/asmhelper/InstrumentationClassTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "calledSetup", "", "loadClassResource", "", "name", "", "makeTransformers", "", "setup", "transform", "classLoader", "Ljava/lang/ClassLoader;", "className", "p2", "Ljava/lang/Class;", "p3", "Ljava/security/ProtectionDomain;", "basicClass", "AsmHelper1.8.9" })
public abstract class InstrumentationClassTransformer implements ClassFileTransformer
{
    private boolean calledSetup;
    
    private final void setup() {
        this.makeTransformers();
    }
    
    public abstract void makeTransformers();
    
    @Nullable
    @Override
    public byte[] transform(@Nullable final ClassLoader classLoader, @Nullable final String className, @Nullable final Class<?> p2, @Nullable final ProtectionDomain p3, @Nullable final byte[] basicClass) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ifnull          9
        //     5: aload_2         /* className */
        //     6: ifnonnull       11
        //     9: aconst_null    
        //    10: areturn        
        //    11: aload_2         /* className */
        //    12: ldc             "kotlin."
        //    14: iconst_0       
        //    15: iconst_2       
        //    16: aconst_null    
        //    17: invokestatic    kotlin/text/StringsKt.startsWith$default:(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
        //    20: ifne            63
        //    23: aload_2         /* className */
        //    24: ldc             "dev.falsehonesty.asmhelper."
        //    26: iconst_0       
        //    27: iconst_2       
        //    28: aconst_null    
        //    29: invokestatic    kotlin/text/StringsKt.startsWith$default:(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
        //    32: ifne            63
        //    35: aload_2         /* className */
        //    36: aload_0         /* this */
        //    37: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    40: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //    43: astore          6
        //    45: aload           6
        //    47: ldc             "this.javaClass.name"
        //    49: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    52: aload           6
        //    54: iconst_0       
        //    55: iconst_2       
        //    56: aconst_null    
        //    57: invokestatic    kotlin/text/StringsKt.startsWith$default:(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
        //    60: ifeq            66
        //    63: aload           basicClass
        //    65: areturn        
        //    66: aload_0         /* this */
        //    67: getfield        dev/falsehonesty/asmhelper/InstrumentationClassTransformer.calledSetup:Z
        //    70: ifne            82
        //    73: aload_0         /* this */
        //    74: invokespecial   dev/falsehonesty/asmhelper/InstrumentationClassTransformer.setup:()V
        //    77: aload_0         /* this */
        //    78: iconst_1       
        //    79: putfield        dev/falsehonesty/asmhelper/InstrumentationClassTransformer.calledSetup:Z
        //    82: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //    85: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getClassReplacers:()Ljava/util/Map;
        //    88: aload_2         /* className */
        //    89: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    94: checkcast       Ljava/lang/String;
        //    97: astore          6
        //    99: aload           6
        //   101: ifnonnull       107
        //   104: goto            171
        //   107: aload           6
        //   109: astore          7
        //   111: iconst_0       
        //   112: istore          8
        //   114: iconst_0       
        //   115: istore          9
        //   117: aload           7
        //   119: astore          classFile
        //   121: iconst_0       
        //   122: istore          $i$a$-let-InstrumentationClassTransformer$transform$1
        //   124: new             Ljava/lang/StringBuilder;
        //   127: dup            
        //   128: invokespecial   java/lang/StringBuilder.<init>:()V
        //   131: ldc             "Completely replacing "
        //   133: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   136: aload_2         /* className */
        //   137: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   140: ldc             " with data from "
        //   142: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: aload           classFile
        //   147: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: bipush          46
        //   152: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   155: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   158: aconst_null    
        //   159: iconst_2       
        //   160: aconst_null    
        //   161: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   164: aload_0         /* this */
        //   165: aload           classFile
        //   167: invokespecial   dev/falsehonesty/asmhelper/InstrumentationClassTransformer.loadClassResource:(Ljava/lang/String;)[B
        //   170: areturn        
        //   171: nop            
        //   172: getstatic       dev/falsehonesty/asmhelper/AsmHelper.INSTANCE:Ldev/falsehonesty/asmhelper/AsmHelper;
        //   175: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getAsmWriters:()Ljava/util/List;
        //   178: checkcast       Ljava/lang/Iterable;
        //   181: astore          7
        //   183: nop            
        //   184: iconst_0       
        //   185: istore          $i$f$filter
        //   187: aload           $this$filter$iv
        //   189: astore          9
        //   191: new             Ljava/util/ArrayList;
        //   194: dup            
        //   195: invokespecial   java/util/ArrayList.<init>:()V
        //   198: checkcast       Ljava/util/Collection;
        //   201: astore          destination$iv$iv
        //   203: iconst_0       
        //   204: istore          $i$f$filterTo
        //   206: aload           $this$filterTo$iv$iv
        //   208: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   213: astore          12
        //   215: aload           12
        //   217: invokeinterface java/util/Iterator.hasNext:()Z
        //   222: ifeq            279
        //   225: aload           12
        //   227: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   232: astore          element$iv$iv
        //   234: aload           element$iv$iv
        //   236: checkcast       Ldev/falsehonesty/asmhelper/dsl/AsmWriter;
        //   239: astore          it
        //   241: iconst_0       
        //   242: istore          $i$a$-filter-InstrumentationClassTransformer$transform$writers$1
        //   244: aload           it
        //   246: invokevirtual   dev/falsehonesty/asmhelper/dsl/AsmWriter.getClassName:()Ljava/lang/String;
        //   249: bipush          47
        //   251: bipush          46
        //   253: iconst_0       
        //   254: iconst_4       
        //   255: aconst_null    
        //   256: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;CCZILjava/lang/Object;)Ljava/lang/String;
        //   259: aload_2         /* className */
        //   260: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   263: ifeq            215
        //   266: aload           destination$iv$iv
        //   268: aload           element$iv$iv
        //   270: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   275: pop            
        //   276: goto            215
        //   279: aload           destination$iv$iv
        //   281: checkcast       Ljava/util/List;
        //   284: nop            
        //   285: checkcast       Ljava/util/Collection;
        //   288: astore          7
        //   290: iconst_0       
        //   291: istore          8
        //   293: aload           7
        //   295: invokeinterface java/util/Collection.isEmpty:()Z
        //   300: ifeq            309
        //   303: iconst_0       
        //   304: istore          $i$a$-ifEmpty-InstrumentationClassTransformer$transform$writers$2
        //   306: aload           basicClass
        //   308: areturn        
        //   309: aload           7
        //   311: checkcast       Ljava/util/List;
        //   314: astore          writers
        //   316: ldc             "Transforming class "
        //   318: aload_2         /* className */
        //   319: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //   322: aconst_null    
        //   323: iconst_2       
        //   324: aconst_null    
        //   325: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   328: new             Lorg/objectweb/asm/ClassReader;
        //   331: dup            
        //   332: aload           basicClass
        //   334: invokespecial   org/objectweb/asm/ClassReader.<init>:([B)V
        //   337: astore          classReader
        //   339: new             Lorg/objectweb/asm/tree/ClassNode;
        //   342: dup            
        //   343: invokespecial   org/objectweb/asm/tree/ClassNode.<init>:()V
        //   346: astore          classNode
        //   348: aload           classReader
        //   350: aload           classNode
        //   352: checkcast       Lorg/objectweb/asm/ClassVisitor;
        //   355: bipush          8
        //   357: invokevirtual   org/objectweb/asm/ClassReader.accept:(Lorg/objectweb/asm/ClassVisitor;I)V
        //   360: aload           writers
        //   362: checkcast       Ljava/lang/Iterable;
        //   365: astore          $this$forEach$iv
        //   367: iconst_0       
        //   368: istore          $i$f$forEach
        //   370: aload           $this$forEach$iv
        //   372: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   377: astore          11
        //   379: aload           11
        //   381: invokeinterface java/util/Iterator.hasNext:()Z
        //   386: ifeq            454
        //   389: aload           11
        //   391: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   396: astore          element$iv
        //   398: aload           element$iv
        //   400: checkcast       Ldev/falsehonesty/asmhelper/dsl/AsmWriter;
        //   403: astore          it
        //   405: iconst_0       
        //   406: istore          $i$a$-forEach-InstrumentationClassTransformer$transform$2
        //   408: new             Ljava/lang/StringBuilder;
        //   411: dup            
        //   412: invokespecial   java/lang/StringBuilder.<init>:()V
        //   415: ldc             "Applying AsmWriter "
        //   417: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   420: aload           it
        //   422: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   425: ldc             " to class "
        //   427: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   430: aload_2         /* className */
        //   431: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   434: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   437: aconst_null    
        //   438: iconst_2       
        //   439: aconst_null    
        //   440: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   443: aload           it
        //   445: aload           classNode
        //   447: invokevirtual   dev/falsehonesty/asmhelper/dsl/AsmWriter.transform:(Lorg/objectweb/asm/tree/ClassNode;)V
        //   450: nop            
        //   451: goto            379
        //   454: nop            
        //   455: new             Lorg/objectweb/asm/ClassWriter;
        //   458: dup            
        //   459: iconst_3       
        //   460: invokespecial   org/objectweb/asm/ClassWriter.<init>:(I)V
        //   463: astore          classWriter
        //   465: nop            
        //   466: aload           classNode
        //   468: aload           classWriter
        //   470: checkcast       Lorg/objectweb/asm/ClassVisitor;
        //   473: invokevirtual   org/objectweb/asm/tree/ClassNode.accept:(Lorg/objectweb/asm/ClassVisitor;)V
        //   476: goto            527
        //   479: astore          e
        //   481: new             Ljava/lang/StringBuilder;
        //   484: dup            
        //   485: invokespecial   java/lang/StringBuilder.<init>:()V
        //   488: ldc             "Exception when transforming "
        //   490: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   493: aload_2         /* className */
        //   494: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   497: ldc             " : "
        //   499: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   502: aload           e
        //   504: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   507: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //   510: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   513: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   516: aconst_null    
        //   517: iconst_2       
        //   518: aconst_null    
        //   519: invokestatic    dev/falsehonesty/asmhelper/printing/PrintingKt.log$default:(Ljava/lang/String;Ldev/falsehonesty/asmhelper/printing/LogLevel;ILjava/lang/Object;)V
        //   522: aload           e
        //   524: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   527: aload           classWriter
        //   529: invokevirtual   org/objectweb/asm/ClassWriter.toByteArray:()[B
        //   532: areturn        
        //    Signature:
        //  (Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/Class<*>;Ljava/security/ProtectionDomain;[B)[B
        //    StackMapTable: 00 0E 09 01 33 FC 00 02 07 00 4D 0F 18 3F FF 00 2B 00 0D 07 00 02 07 00 8F 07 00 4D 07 00 3F 07 00 91 07 00 93 07 00 4D 07 00 84 01 07 00 84 07 00 89 01 07 00 95 00 00 3F FF 00 1D 00 0D 07 00 02 07 00 8F 07 00 4D 07 00 3F 07 00 91 07 00 93 07 00 4D 07 00 89 01 07 00 84 07 00 89 01 07 00 95 00 00 FF 00 45 00 0D 07 00 02 07 00 8F 07 00 4D 07 00 3F 07 00 91 07 00 93 07 00 B0 07 00 BB 07 00 C0 07 00 84 01 07 00 95 07 00 04 00 00 FB 00 4A FF 00 18 00 0D 07 00 02 07 00 8F 07 00 4D 07 00 3F 07 00 91 07 00 93 07 00 B0 07 00 BB 07 00 C0 07 00 D0 01 07 00 95 07 00 04 00 01 07 00 2F FF 00 2F 00 0D 07 00 02 07 00 8F 07 00 4D 07 00 3F 07 00 91 07 00 93 07 00 B0 07 00 BB 07 00 C0 07 00 D0 00 07 00 95 07 00 04 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  465    476    479    527    Ljava/lang/Throwable;
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
