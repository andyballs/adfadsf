//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.core;

import net.minecraftforge.fml.relauncher.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¨\u0006\u000f" }, d2 = { "Ldev/falsehonesty/asmhelper/core/AsmHelperLoadingPlugin;", "Lnet/minecraftforge/fml/relauncher/IFMLLoadingPlugin;", "()V", "getASMTransformerClass", "", "", "()[Ljava/lang/String;", "getAccessTransformerClass", "getModContainerClass", "getSetupClass", "injectData", "", "data", "", "", "AsmHelper1.8.9" })
public final class AsmHelperLoadingPlugin implements IFMLLoadingPlugin
{
    @NotNull
    public String[] getASMTransformerClass() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   dev/falsehonesty/asmhelper/AsmHelper.getServiceLoader$AsmHelper1_8_9:()Ljava/util/ServiceLoader;
        //     6: astore_1       
        //     7: aload_1        
        //     8: ldc             "AsmHelper.serviceLoader"
        //    10: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    13: aload_1        
        //    14: checkcast       Ljava/lang/Iterable;
        //    17: astore_1        /* $this$flatMap$iv */
        //    18: iconst_0       
        //    19: istore_2        /* $i$f$flatMap */
        //    20: aload_1         /* $this$flatMap$iv */
        //    21: astore_3       
        //    22: new             Ljava/util/ArrayList;
        //    25: dup            
        //    26: invokespecial   java/util/ArrayList.<init>:()V
        //    29: checkcast       Ljava/util/Collection;
        //    32: astore          destination$iv$iv
        //    34: iconst_0       
        //    35: istore          $i$f$flatMapTo
        //    37: aload_3         /* $this$flatMapTo$iv$iv */
        //    38: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    43: astore          6
        //    45: aload           6
        //    47: invokeinterface java/util/Iterator.hasNext:()Z
        //    52: ifeq            97
        //    55: aload           6
        //    57: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    62: astore          element$iv$iv
        //    64: aload           element$iv$iv
        //    66: checkcast       Ldev/falsehonesty/asmhelper/ClassTransformationService;
        //    69: astore          it
        //    71: iconst_0       
        //    72: istore          $i$a$-flatMap-AsmHelperLoadingPlugin$getASMTransformerClass$1
        //    74: aload           it
        //    76: invokeinterface dev/falsehonesty/asmhelper/ClassTransformationService.transformerClasses:()Ljava/util/List;
        //    81: checkcast       Ljava/lang/Iterable;
        //    84: astore          list$iv$iv
        //    86: aload           destination$iv$iv
        //    88: aload           list$iv$iv
        //    90: invokestatic    kotlin/collections/CollectionsKt.addAll:(Ljava/util/Collection;Ljava/lang/Iterable;)Z
        //    93: pop            
        //    94: goto            45
        //    97: aload           destination$iv$iv
        //    99: checkcast       Ljava/util/List;
        //   102: nop            
        //   103: checkcast       Ljava/util/Collection;
        //   106: astore_1       
        //   107: nop            
        //   108: iconst_0       
        //   109: istore_2        /* $i$f$toTypedArray */
        //   110: aload_1         /* $this$toTypedArray$iv */
        //   111: astore_3        /* thisCollection$iv */
        //   112: aload_3         /* thisCollection$iv */
        //   113: iconst_0       
        //   114: anewarray       Ljava/lang/String;
        //   117: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   122: dup            
        //   123: ifnonnull       136
        //   126: new             Ljava/lang/NullPointerException;
        //   129: dup            
        //   130: ldc             "null cannot be cast to non-null type kotlin.Array<T>"
        //   132: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   135: athrow         
        //   136: checkcast       [Ljava/lang/String;
        //   139: areturn        
        //    StackMapTable: 00 03 FF 00 2D 00 07 07 00 02 07 00 36 01 07 00 36 07 00 3B 01 07 00 41 00 00 33 FF 00 26 00 07 07 00 02 07 00 3B 01 07 00 3B 07 00 3B 01 07 00 41 00 01 07 00 66
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public String getModContainerClass() {
        return null;
    }
    
    @Nullable
    public String getSetupClass() {
        return null;
    }
    
    public void injectData(@Nullable final Map<String, Object> data) {
    }
    
    @Nullable
    public String getAccessTransformerClass() {
        return null;
    }
}
