//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import kotlin.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSONImpl;", "", "toJSON", "", "key", "ctjs" })
public interface JSONImpl
{
    @NotNull
    String toJSON(@NotNull final String p0);
    
    @Metadata(mv = { 1, 6, 0 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        @NotNull
        public static String toJSON(@NotNull final JSONImpl this, @NotNull final String key) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "this"
            //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //     6: aload_1         /* key */
            //     7: ldc             "key"
            //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //    12: new             Ljava/lang/StringBuilder;
            //    15: dup            
            //    16: invokespecial   java/lang/StringBuilder.<init>:()V
            //    19: astore_2        /* sb */
            //    20: aload_2         /* sb */
            //    21: ldc             "{"
            //    23: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    26: pop            
            //    27: aload_2         /* sb */
            //    28: aload_0         /* this */
            //    29: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //    32: invokestatic    kotlin/jvm/JvmClassMappingKt.getKotlinClass:(Ljava/lang/Class;)Lkotlin/reflect/KClass;
            //    35: invokestatic    kotlin/reflect/full/KClasses.getMemberProperties:(Lkotlin/reflect/KClass;)Ljava/util/Collection;
            //    38: checkcast       Ljava/lang/Iterable;
            //    41: astore_3       
            //    42: astore          12
            //    44: iconst_0       
            //    45: istore          $i$f$filter
            //    47: aload_3         /* $this$filter$iv */
            //    48: astore          5
            //    50: new             Ljava/util/ArrayList;
            //    53: dup            
            //    54: invokespecial   java/util/ArrayList.<init>:()V
            //    57: checkcast       Ljava/util/Collection;
            //    60: astore          destination$iv$iv
            //    62: iconst_0       
            //    63: istore          $i$f$filterTo
            //    65: aload           $this$filterTo$iv$iv
            //    67: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
            //    72: astore          8
            //    74: aload           8
            //    76: invokeinterface java/util/Iterator.hasNext:()Z
            //    81: ifeq            137
            //    84: aload           8
            //    86: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //    91: astore          element$iv$iv
            //    93: aload           element$iv$iv
            //    95: checkcast       Lkotlin/reflect/KProperty1;
            //    98: astore          it
            //   100: iconst_0       
            //   101: istore          $i$a$-filter-JSONImpl$toJSON$1
            //   103: aload           it
            //   105: invokeinterface kotlin/reflect/KProperty1.getVisibility:()Lkotlin/reflect/KVisibility;
            //   110: getstatic       kotlin/reflect/KVisibility.PUBLIC:Lkotlin/reflect/KVisibility;
            //   113: if_acmpne       120
            //   116: iconst_1       
            //   117: goto            121
            //   120: iconst_0       
            //   121: ifeq            74
            //   124: aload           destination$iv$iv
            //   126: aload           element$iv$iv
            //   128: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
            //   133: pop            
            //   134: goto            74
            //   137: aload           destination$iv$iv
            //   139: checkcast       Ljava/util/List;
            //   142: nop            
            //   143: aload           12
            //   145: swap           
            //   146: checkcast       Ljava/lang/Iterable;
            //   149: ldc             ",\n"
            //   151: checkcast       Ljava/lang/CharSequence;
            //   154: aconst_null    
            //   155: aconst_null    
            //   156: iconst_0       
            //   157: aconst_null    
            //   158: new             Lcom/chattriggers/ctjs/engine/langs/js/JSONImpl$toJSON$2;
            //   161: dup            
            //   162: aload_0         /* this */
            //   163: invokespecial   com/chattriggers/ctjs/engine/langs/js/JSONImpl$toJSON$2.<init>:(Lcom/chattriggers/ctjs/engine/langs/js/JSONImpl;)V
            //   166: checkcast       Lkotlin/jvm/functions/Function1;
            //   169: bipush          30
            //   171: aconst_null    
            //   172: invokestatic    kotlin/collections/CollectionsKt.joinToString$default:(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;
            //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   178: pop            
            //   179: aload_2         /* sb */
            //   180: invokevirtual   java/lang/StringBuilder.length:()I
            //   183: iconst_1       
            //   184: if_icmple       194
            //   187: aload_2         /* sb */
            //   188: ldc             ",\n"
            //   190: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   193: pop            
            //   194: aload_2         /* sb */
            //   195: new             Ljava/lang/StringBuilder;
            //   198: dup            
            //   199: invokespecial   java/lang/StringBuilder.<init>:()V
            //   202: ldc             "\"toString\": \""
            //   204: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   207: aload_0         /* this */
            //   208: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   211: bipush          34
            //   213: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
            //   216: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   219: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   222: pop            
            //   223: aload_2         /* sb */
            //   224: ldc             "}"
            //   226: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   229: pop            
            //   230: aload_2         /* sb */
            //   231: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   234: astore_3       
            //   235: aload_3        
            //   236: ldc             "sb.toString()"
            //   238: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
            //   241: aload_3        
            //   242: areturn        
            //    StackMapTable: 00 05 FF 00 4A 00 0D 07 00 12 07 00 49 07 00 22 07 00 3E 01 07 00 3E 07 00 43 01 07 00 4B 00 00 00 07 00 22 00 00 FF 00 2D 00 0D 07 00 12 07 00 49 07 00 22 07 00 3E 01 07 00 3E 07 00 43 01 07 00 4B 07 00 04 07 00 55 01 07 00 22 00 00 40 01 FF 00 0F 00 0D 07 00 12 07 00 49 07 00 22 07 00 3E 01 07 00 3E 07 00 43 01 07 00 4B 00 00 00 07 00 22 00 00 38
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException: Cannot read field "references" because "newVariable" is null
            //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
            //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
            //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
            //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
            //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
            //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
            //     at java.base/java.lang.Thread.run(Thread.java:842)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
}
