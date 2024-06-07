//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import kotlin.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0001H\u0016J\u001f\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0001H\u0016R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lcom/chattriggers/ctjs/triggers/ForgeTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "eventClass", "Ljava/lang/Class;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Ljava/lang/Class;Lcom/chattriggers/ctjs/engine/ILoader;)V", "register", "trigger", "", "args", "", "([Ljava/lang/Object;)V", "unregister", "Companion", "ctjs" })
public final class ForgeTrigger extends Trigger
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Class<?> eventClass;
    @NotNull
    private static final Map<Class<?>, SortedSet<ForgeTrigger>> forgeTriggers;
    
    public ForgeTrigger(@NotNull final Object method, @NotNull final Class<?> eventClass, @NotNull final ILoader loader) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "method"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* eventClass */
        //     7: ldc             "eventClass"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_3         /* loader */
        //    13: ldc             "loader"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: aload_0         /* this */
        //    19: aload_1         /* method */
        //    20: getstatic       com/chattriggers/ctjs/triggers/TriggerType.Forge:Lcom/chattriggers/ctjs/triggers/TriggerType;
        //    23: aload_3         /* loader */
        //    24: invokespecial   com/chattriggers/ctjs/triggers/Trigger.<init>:(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V
        //    27: aload_0         /* this */
        //    28: aload_2         /* eventClass */
        //    29: putfield        com/chattriggers/ctjs/triggers/ForgeTrigger.eventClass:Ljava/lang/Class;
        //    32: ldc             Lnet/minecraftforge/fml/common/eventhandler/Event;.class
        //    34: aload_0         /* this */
        //    35: getfield        com/chattriggers/ctjs/triggers/ForgeTrigger.eventClass:Ljava/lang/Class;
        //    38: invokevirtual   java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
        //    41: ifne            74
        //    44: iconst_0       
        //    45: istore          $i$a$-require-ForgeTrigger$1
        //    47: ldc             "ForgeTrigger expects an Event class, but found "
        //    49: aload_0         /* this */
        //    50: getfield        com/chattriggers/ctjs/triggers/ForgeTrigger.eventClass:Ljava/lang/Class;
        //    53: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //    56: invokestatic    kotlin/jvm/internal/Intrinsics.stringPlus:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
        //    59: astore          null
        //    61: new             Ljava/lang/IllegalArgumentException;
        //    64: dup            
        //    65: aload           5
        //    67: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    70: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    73: athrow         
        //    74: getstatic       com/chattriggers/ctjs/triggers/ForgeTrigger.forgeTriggers:Ljava/util/Map;
        //    77: astore          4
        //    79: aload_0         /* this */
        //    80: getfield        com/chattriggers/ctjs/triggers/ForgeTrigger.eventClass:Ljava/lang/Class;
        //    83: astore          key$iv
        //    85: iconst_0       
        //    86: istore          $i$f$getOrPut
        //    88: aload           $this$getOrPut$iv
        //    90: aload           key$iv
        //    92: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    97: astore          value$iv
        //    99: aload           value$iv
        //   101: ifnonnull       136
        //   104: iconst_0       
        //   105: istore          $i$a$-getOrPut-ForgeTrigger$2
        //   107: iconst_0       
        //   108: anewarray       Lcom/chattriggers/ctjs/triggers/ForgeTrigger;
        //   111: invokestatic    kotlin/collections/SetsKt.sortedSetOf:([Ljava/lang/Object;)Ljava/util/TreeSet;
        //   114: checkcast       Ljava/util/SortedSet;
        //   117: astore          answer$iv
        //   119: aload           $this$getOrPut$iv
        //   121: aload           key$iv
        //   123: aload           answer$iv
        //   125: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   130: pop            
        //   131: aload           answer$iv
        //   133: goto            138
        //   136: aload           value$iv
        //   138: nop            
        //   139: checkcast       Ljava/util/SortedSet;
        //   142: aload_0         /* this */
        //   143: invokeinterface java/util/SortedSet.add:(Ljava/lang/Object;)Z
        //   148: pop            
        //   149: nop            
        //   150: return         
        //    Signature:
        //  (Ljava/lang/Object;Ljava/lang/Class<*>;Lcom/chattriggers/ctjs/engine/ILoader;)V
        //    StackMapTable: 00 03 FF 00 4A 00 04 07 00 02 07 00 53 07 00 41 07 00 5B 00 00 FF 00 3D 00 08 07 00 02 07 00 53 07 00 41 07 00 5B 07 00 5F 07 00 41 01 07 00 53 00 00 41 07 00 53
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    @Override
    public Trigger register() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_1       
        //     4: aload_0         /* this */
        //     5: getfield        com/chattriggers/ctjs/triggers/ForgeTrigger.eventClass:Ljava/lang/Class;
        //     8: astore_2        /* key$iv */
        //     9: iconst_0       
        //    10: istore_3        /* $i$f$getOrPut */
        //    11: aload_1         /* $this$getOrPut$iv */
        //    12: aload_2         /* key$iv */
        //    13: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    18: astore          value$iv
        //    20: aload           value$iv
        //    22: ifnonnull       55
        //    25: iconst_0       
        //    26: istore          $i$a$-getOrPut-ForgeTrigger$register$1
        //    28: iconst_0       
        //    29: anewarray       Lcom/chattriggers/ctjs/triggers/ForgeTrigger;
        //    32: invokestatic    kotlin/collections/SetsKt.sortedSetOf:([Ljava/lang/Object;)Ljava/util/TreeSet;
        //    35: checkcast       Ljava/util/SortedSet;
        //    38: astore          answer$iv
        //    40: aload_1         /* $this$getOrPut$iv */
        //    41: aload_2         /* key$iv */
        //    42: aload           answer$iv
        //    44: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    49: pop            
        //    50: aload           answer$iv
        //    52: goto            57
        //    55: aload           value$iv
        //    57: nop            
        //    58: checkcast       Ljava/util/SortedSet;
        //    61: aload_0         /* this */
        //    62: invokeinterface java/util/SortedSet.add:(Ljava/lang/Object;)Z
        //    67: pop            
        //    68: aload_0         /* this */
        //    69: invokespecial   com/chattriggers/ctjs/triggers/Trigger.register:()Lcom/chattriggers/ctjs/triggers/Trigger;
        //    72: areturn        
        //    StackMapTable: 00 02 FF 00 37 00 05 07 00 02 07 00 5F 07 00 41 01 07 00 53 00 00 41 07 00 53
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
    @Override
    public Trigger unregister() {
        final SortedSet<ForgeTrigger> set = ForgeTrigger.forgeTriggers.get(this.eventClass);
        if (set != null) {
            set.remove(this);
        }
        return super.unregister();
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        this.callMethod(args);
    }
    
    public static final /* synthetic */ Map access$getForgeTriggers$cp() {
        return ForgeTrigger.forgeTriggers;
    }
    
    static {
        Companion = new Companion(null);
        forgeTriggers = new LinkedHashMap<Class<?>, SortedSet<ForgeTrigger>>();
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\tR$\u0010\u0003\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lcom/chattriggers/ctjs/triggers/ForgeTrigger$Companion;", "", "()V", "forgeTriggers", "", "Ljava/lang/Class;", "Ljava/util/SortedSet;", "Lcom/chattriggers/ctjs/triggers/ForgeTrigger;", "onEvent", "", "event", "Lnet/minecraftforge/fml/common/eventhandler/Event;", "unregisterTriggers", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        public final void unregisterTriggers() {
            final Iterable $this$forEach$iv = CollectionsKt.flatten((Iterable)ForgeTrigger.access$getForgeTriggers$cp().values());
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final ForgeTrigger it = (ForgeTrigger)element$iv;
                final int n = 0;
                it.unregister();
            }
            ForgeTrigger.access$getForgeTriggers$cp().clear();
        }
        
        @SubscribeEvent
        public final void onEvent(@NotNull final Event event) {
            Intrinsics.checkNotNullParameter((Object)event, "event");
            if (Intrinsics.areEqual((Object)Thread.currentThread().getName(), (Object)"Server thread")) {
                return;
            }
            final SortedSet set = ForgeTrigger.access$getForgeTriggers$cp().get(event.getClass());
            if (set != null) {
                final Iterable $this$forEach$iv = set;
                final int $i$f$forEach = 0;
                for (final Object element$iv : $this$forEach$iv) {
                    final ForgeTrigger it = (ForgeTrigger)element$iv;
                    final int n = 0;
                    it.trigger(new Event[] { event });
                }
            }
        }
    }
}
