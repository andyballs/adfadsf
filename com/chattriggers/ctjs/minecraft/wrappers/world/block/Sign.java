//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.world.block;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.tileentity.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.objects.message.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\f\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Sign;", "Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Block;", "block", "(Lcom/chattriggers/ctjs/minecraft/wrappers/world/block/Block;)V", "sign", "Lnet/minecraft/tileentity/TileEntitySign;", "getFormattedLines", "", "", "getLines", "Lcom/chattriggers/ctjs/minecraft/objects/message/Message;", "getUnformattedLines", "toString", "ctjs" })
public final class Sign extends Block
{
    @NotNull
    private final TileEntitySign sign;
    
    public Sign(@NotNull final Block block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        super(block.getType(), block.getPos(), block.getFace());
        final WorldClient world = World.getWorld();
        Intrinsics.checkNotNull((Object)world);
        final TileEntity getTileEntity = world.getTileEntity(this.getPos().toMCBlock());
        if (getTileEntity == null) {
            throw new NullPointerException("null cannot be cast to non-null type net.minecraft.tileentity.TileEntitySign");
        }
        this.sign = (TileEntitySign)getTileEntity;
    }
    
    @NotNull
    public final List<Message> getLines() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/world/block/Sign.sign:Lnet/minecraft/tileentity/TileEntitySign;
        //     4: getfield        net/minecraft/tileentity/TileEntitySign.signText:[Lnet/minecraft/util/IChatComponent;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc             "sign.signText"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_1        
        //    15: checkcast       [Ljava/lang/Object;
        //    18: astore_1        /* $this$map$iv */
        //    19: iconst_0       
        //    20: istore_2        /* $i$f$map */
        //    21: aload_1         /* $this$map$iv */
        //    22: astore_3       
        //    23: new             Ljava/util/ArrayList;
        //    26: dup            
        //    27: aload_1         /* $this$map$iv */
        //    28: arraylength    
        //    29: invokespecial   java/util/ArrayList.<init>:(I)V
        //    32: checkcast       Ljava/util/Collection;
        //    35: astore          destination$iv$iv
        //    37: iconst_0       
        //    38: istore          $i$f$mapTo
        //    40: iconst_0       
        //    41: istore          6
        //    43: aload_3         /* $this$mapTo$iv$iv */
        //    44: arraylength    
        //    45: istore          7
        //    47: iload           6
        //    49: iload           7
        //    51: if_icmpge       141
        //    54: aload_3         /* $this$mapTo$iv$iv */
        //    55: iload           6
        //    57: aaload         
        //    58: astore          item$iv$iv
        //    60: aload           destination$iv$iv
        //    62: aload           item$iv$iv
        //    64: checkcast       Lnet/minecraft/util/IChatComponent;
        //    67: astore          9
        //    69: astore          14
        //    71: iconst_0       
        //    72: istore          $i$a$-map-Sign$getLines$1
        //    74: aload           it
        //    76: dup            
        //    77: ifnonnull       85
        //    80: pop            
        //    81: aconst_null    
        //    82: goto            100
        //    85: astore          p0
        //    87: iconst_0       
        //    88: istore          $i$a$-let-Sign$getLines$1$1
        //    90: new             Lcom/chattriggers/ctjs/minecraft/objects/message/Message;
        //    93: dup            
        //    94: aload           p0
        //    96: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/Message.<init>:(Lnet/minecraft/util/IChatComponent;)V
        //    99: nop            
        //   100: dup            
        //   101: ifnonnull       126
        //   104: pop            
        //   105: new             Lcom/chattriggers/ctjs/minecraft/objects/message/Message;
        //   108: dup            
        //   109: iconst_1       
        //   110: anewarray       Ljava/lang/Object;
        //   113: astore          11
        //   115: aload           11
        //   117: iconst_0       
        //   118: ldc             ""
        //   120: aastore        
        //   121: aload           11
        //   123: invokespecial   com/chattriggers/ctjs/minecraft/objects/message/Message.<init>:([Ljava/lang/Object;)V
        //   126: aload           14
        //   128: swap           
        //   129: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   134: pop            
        //   135: iinc            6, 1
        //   138: goto            47
        //   141: aload           destination$iv$iv
        //   143: checkcast       Ljava/util/List;
        //   146: nop            
        //   147: areturn        
        //    Signature:
        //  ()Ljava/util/List<Lcom/chattriggers/ctjs/minecraft/objects/message/Message;>;
        //    StackMapTable: 00 05 FF 00 2F 00 08 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 00 00 FF 00 25 00 0F 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 07 00 71 07 00 6F 01 00 00 00 07 00 6D 00 01 07 00 6F 4E 07 00 73 59 07 00 73 FF 00 0E 00 08 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 00 00
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
    
    @NotNull
    public final List<String> getFormattedLines() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/world/block/Sign.sign:Lnet/minecraft/tileentity/TileEntitySign;
        //     4: getfield        net/minecraft/tileentity/TileEntitySign.signText:[Lnet/minecraft/util/IChatComponent;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc             "sign.signText"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_1        
        //    15: checkcast       [Ljava/lang/Object;
        //    18: astore_1        /* $this$map$iv */
        //    19: iconst_0       
        //    20: istore_2        /* $i$f$map */
        //    21: aload_1         /* $this$map$iv */
        //    22: astore_3       
        //    23: new             Ljava/util/ArrayList;
        //    26: dup            
        //    27: aload_1         /* $this$map$iv */
        //    28: arraylength    
        //    29: invokespecial   java/util/ArrayList.<init>:(I)V
        //    32: checkcast       Ljava/util/Collection;
        //    35: astore          destination$iv$iv
        //    37: iconst_0       
        //    38: istore          $i$f$mapTo
        //    40: iconst_0       
        //    41: istore          6
        //    43: aload_3         /* $this$mapTo$iv$iv */
        //    44: arraylength    
        //    45: istore          7
        //    47: iload           6
        //    49: iload           7
        //    51: if_icmpge       113
        //    54: aload_3         /* $this$mapTo$iv$iv */
        //    55: iload           6
        //    57: aaload         
        //    58: astore          item$iv$iv
        //    60: aload           destination$iv$iv
        //    62: aload           item$iv$iv
        //    64: checkcast       Lnet/minecraft/util/IChatComponent;
        //    67: astore          9
        //    69: astore          11
        //    71: iconst_0       
        //    72: istore          $i$a$-map-Sign$getFormattedLines$1
        //    74: aload           it
        //    76: dup            
        //    77: ifnonnull       86
        //    80: pop            
        //    81: ldc             ""
        //    83: goto            98
        //    86: invokeinterface net/minecraft/util/IChatComponent.getFormattedText:()Ljava/lang/String;
        //    91: dup            
        //    92: ifnonnull       98
        //    95: pop            
        //    96: ldc             ""
        //    98: aload           11
        //   100: swap           
        //   101: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   106: pop            
        //   107: iinc            6, 1
        //   110: goto            47
        //   113: aload           destination$iv$iv
        //   115: checkcast       Ljava/util/List;
        //   118: nop            
        //   119: areturn        
        //    Signature:
        //  ()Ljava/util/List<Ljava/lang/String;>;
        //    StackMapTable: 00 04 FF 00 2F 00 08 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 00 00 FF 00 26 00 0C 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 07 00 71 07 00 6F 01 07 00 6D 00 01 07 00 6F 4B 07 00 94 FF 00 0E 00 08 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 00 00
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
    
    @NotNull
    public final List<String> getUnformattedLines() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/chattriggers/ctjs/minecraft/wrappers/world/block/Sign.sign:Lnet/minecraft/tileentity/TileEntitySign;
        //     4: getfield        net/minecraft/tileentity/TileEntitySign.signText:[Lnet/minecraft/util/IChatComponent;
        //     7: astore_1       
        //     8: aload_1        
        //     9: ldc             "sign.signText"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_1        
        //    15: checkcast       [Ljava/lang/Object;
        //    18: astore_1        /* $this$map$iv */
        //    19: iconst_0       
        //    20: istore_2        /* $i$f$map */
        //    21: aload_1         /* $this$map$iv */
        //    22: astore_3       
        //    23: new             Ljava/util/ArrayList;
        //    26: dup            
        //    27: aload_1         /* $this$map$iv */
        //    28: arraylength    
        //    29: invokespecial   java/util/ArrayList.<init>:(I)V
        //    32: checkcast       Ljava/util/Collection;
        //    35: astore          destination$iv$iv
        //    37: iconst_0       
        //    38: istore          $i$f$mapTo
        //    40: iconst_0       
        //    41: istore          6
        //    43: aload_3         /* $this$mapTo$iv$iv */
        //    44: arraylength    
        //    45: istore          7
        //    47: iload           6
        //    49: iload           7
        //    51: if_icmpge       113
        //    54: aload_3         /* $this$mapTo$iv$iv */
        //    55: iload           6
        //    57: aaload         
        //    58: astore          item$iv$iv
        //    60: aload           destination$iv$iv
        //    62: aload           item$iv$iv
        //    64: checkcast       Lnet/minecraft/util/IChatComponent;
        //    67: astore          9
        //    69: astore          11
        //    71: iconst_0       
        //    72: istore          $i$a$-map-Sign$getUnformattedLines$1
        //    74: aload           it
        //    76: dup            
        //    77: ifnonnull       86
        //    80: pop            
        //    81: ldc             ""
        //    83: goto            98
        //    86: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText:()Ljava/lang/String;
        //    91: dup            
        //    92: ifnonnull       98
        //    95: pop            
        //    96: ldc             ""
        //    98: aload           11
        //   100: swap           
        //   101: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   106: pop            
        //   107: iinc            6, 1
        //   110: goto            47
        //   113: aload           destination$iv$iv
        //   115: checkcast       Ljava/util/List;
        //   118: nop            
        //   119: areturn        
        //    Signature:
        //  ()Ljava/util/List<Ljava/lang/String;>;
        //    StackMapTable: 00 04 FF 00 2F 00 08 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 00 00 FF 00 26 00 0C 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 07 00 71 07 00 6F 01 07 00 6D 00 01 07 00 6F 4B 07 00 94 FF 00 0E 00 08 07 00 02 07 00 66 01 07 00 66 07 00 6D 01 01 01 00 00
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
    
    @NotNull
    public String toString() {
        return "Sign{lines=" + this.getLines() + ", name=" + (Object)this.getType().getMcBlock().getRegistryName() + ", x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.getZ() + '}';
    }
}
