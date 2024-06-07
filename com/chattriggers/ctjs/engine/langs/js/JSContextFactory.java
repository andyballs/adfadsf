//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import kotlin.*;
import kotlin.jvm.internal.*;
import org.mozilla.javascript.*;
import org.jetbrains.annotations.*;
import net.minecraft.launchwrapper.*;
import java.net.*;
import kotlin.collections.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSContextFactory;", "Lorg/mozilla/javascript/ContextFactory;", "()V", "classLoader", "Lcom/chattriggers/ctjs/engine/langs/js/JSContextFactory$ModifiedURLClassLoader;", "optimize", "", "getOptimize", "()Z", "setOptimize", "(Z)V", "addAllURLs", "", "urls", "", "Ljava/net/URL;", "hasFeature", "cx", "Lorg/mozilla/javascript/Context;", "featureIndex", "", "onContextCreated", "ModifiedURLClassLoader", "ctjs" })
public final class JSContextFactory extends ContextFactory
{
    @NotNull
    public static final JSContextFactory INSTANCE;
    @NotNull
    private static final ModifiedURLClassLoader classLoader;
    private static boolean optimize;
    
    private JSContextFactory() {
    }
    
    public final boolean getOptimize() {
        return JSContextFactory.optimize;
    }
    
    public final void setOptimize(final boolean <set-?>) {
        JSContextFactory.optimize = <set-?>;
    }
    
    public final void addAllURLs(@NotNull final List<URL> urls) {
        Intrinsics.checkNotNullParameter((Object)urls, "urls");
        JSContextFactory.classLoader.addAllURLs(urls);
    }
    
    protected void onContextCreated(@NotNull final Context cx) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "cx"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: aload_1         /* cx */
        //     8: invokespecial   org/mozilla/javascript/ContextFactory.onContextCreated:(Lorg/mozilla/javascript/Context;)V
        //    11: aload_1         /* cx */
        //    12: new             Ljava/io/File;
        //    15: dup            
        //    16: ldc             "."
        //    18: ldc             "DEBUG"
        //    20: invokespecial   java/io/File.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    23: invokevirtual   org/mozilla/javascript/Context.setDebugOutputPath:(Ljava/io/File;)V
        //    26: aload_1         /* cx */
        //    27: getstatic       com/chattriggers/ctjs/engine/langs/js/JSContextFactory.classLoader:Lcom/chattriggers/ctjs/engine/langs/js/JSContextFactory$ModifiedURLClassLoader;
        //    30: checkcast       Ljava/lang/ClassLoader;
        //    33: invokevirtual   org/mozilla/javascript/Context.setApplicationClassLoader:(Ljava/lang/ClassLoader;)V
        //    36: aload_1         /* cx */
        //    37: getstatic       com/chattriggers/ctjs/engine/langs/js/JSContextFactory.optimize:Z
        //    40: ifeq            48
        //    43: bipush          9
        //    45: goto            49
        //    48: iconst_0       
        //    49: invokevirtual   org/mozilla/javascript/Context.setOptimizationLevel:(I)V
        //    52: aload_1         /* cx */
        //    53: sipush          200
        //    56: invokevirtual   org/mozilla/javascript/Context.setLanguageVersion:(I)V
        //    59: aload_1         /* cx */
        //    60: new             Lcom/chattriggers/ctjs/engine/langs/js/JSErrorReporter;
        //    63: dup            
        //    64: getstatic       com/chattriggers/ctjs/engine/langs/js/JSLoader.INSTANCE:Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;
        //    67: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSLoader.getConsole:()Lcom/chattriggers/ctjs/utils/console/Console;
        //    70: invokevirtual   com/chattriggers/ctjs/utils/console/Console.getWriter:()Lcom/chattriggers/ctjs/utils/console/TextAreaWriter;
        //    73: invokevirtual   com/chattriggers/ctjs/utils/console/TextAreaWriter.getPrintWriter:()Ljava/io/PrintWriter;
        //    76: invokespecial   com/chattriggers/ctjs/engine/langs/js/JSErrorReporter.<init>:(Ljava/io/PrintWriter;)V
        //    79: checkcast       Lorg/mozilla/javascript/ErrorReporter;
        //    82: invokevirtual   org/mozilla/javascript/Context.setErrorReporter:(Lorg/mozilla/javascript/ErrorReporter;)Lorg/mozilla/javascript/ErrorReporter;
        //    85: pop            
        //    86: aload_1         /* cx */
        //    87: new             Lcom/chattriggers/ctjs/engine/langs/js/JSContextFactory$onContextCreated$1;
        //    90: dup            
        //    91: invokespecial   com/chattriggers/ctjs/engine/langs/js/JSContextFactory$onContextCreated$1.<init>:()V
        //    94: astore_2       
        //    95: aload_2        
        //    96: astore_3       
        //    97: astore          5
        //    99: iconst_0       
        //   100: istore          $i$a$-apply-JSContextFactory$onContextCreated$2
        //   102: aload_3         /* $this$onContextCreated_u24lambda_u2d0 */
        //   103: iconst_0       
        //   104: invokevirtual   com/chattriggers/ctjs/engine/langs/js/JSContextFactory$onContextCreated$1.setJavaPrimitiveWrap:(Z)V
        //   107: aload           5
        //   109: aload_2        
        //   110: checkcast       Lorg/mozilla/javascript/WrapFactory;
        //   113: invokevirtual   org/mozilla/javascript/Context.setWrapFactory:(Lorg/mozilla/javascript/WrapFactory;)V
        //   116: return         
        //    StackMapTable: 00 02 70 07 00 4F FF 00 00 00 02 07 00 02 07 00 4F 00 02 07 00 4F 01
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
    
    protected boolean hasFeature(@Nullable final Context cx, final int featureIndex) {
        switch (featureIndex) {
            case 9: {
                return true;
            }
            case 19: {
                final Boolean orDefault = Launch.blackboard.getOrDefault("fml.deobfuscatedEnvironment", false);
                if (orDefault == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                return orDefault;
            }
            default: {
                return super.hasFeature(cx, featureIndex);
            }
        }
    }
    
    static {
        INSTANCE = new JSContextFactory();
        classLoader = new ModifiedURLClassLoader();
        JSContextFactory.optimize = true;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSContextFactory$ModifiedURLClassLoader;", "Ljava/net/URLClassLoader;", "()V", "sources", "", "Ljava/net/URL;", "getSources", "()Ljava/util/List;", "addAllURLs", "", "urls", "", "addURL", "url", "ctjs" })
    private static final class ModifiedURLClassLoader extends URLClassLoader
    {
        @NotNull
        private final List<URL> sources;
        
        public ModifiedURLClassLoader() {
            super(new URL[0], JSContextFactory.INSTANCE.getClass().getClassLoader());
            this.sources = new ArrayList<URL>();
        }
        
        @NotNull
        public final List<URL> getSources() {
            return this.sources;
        }
        
        public final void addAllURLs(@NotNull final List<URL> urls) {
            Intrinsics.checkNotNullParameter((Object)urls, "urls");
            final Iterable $this$forEach$iv = CollectionsKt.minus((Iterable)urls, (Iterable)this.sources);
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final URL p0 = (URL)element$iv;
                final int n = 0;
                this.addURL(p0);
            }
        }
        
        public void addURL(@NotNull final URL url) {
            Intrinsics.checkNotNullParameter((Object)url, "url");
            super.addURL(url);
            this.sources.add(url);
        }
    }
}
