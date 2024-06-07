//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import java.lang.reflect.*;

public class Undefined implements Serializable
{
    private static final long serialVersionUID = 9195680630202616767L;
    public static final Object instance;
    public static final Scriptable SCRIPTABLE_UNDEFINED;
    
    private Undefined() {
    }
    
    public Object readResolve() {
        return Undefined.instance;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return isUndefined(obj) || super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    public static boolean isUndefined(final Object obj) {
        return Undefined.instance == obj || Undefined.SCRIPTABLE_UNDEFINED == obj;
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   org/mozilla/javascript/Undefined.<init>:()V
        //     7: putstatic       org/mozilla/javascript/Undefined.instance:Ljava/lang/Object;
        //    10: ldc             Lorg/mozilla/javascript/Undefined;.class
        //    12: invokevirtual   java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
        //    15: iconst_1       
        //    16: anewarray       Ljava/lang/Class;
        //    19: dup            
        //    20: iconst_0       
        //    21: ldc             Lorg/mozilla/javascript/Scriptable;.class
        //    23: aastore        
        //    24: invokedynamic   BootstrapMethod #0, invoke:()Ljava/lang/reflect/InvocationHandler;
        //    29: invokestatic    java/lang/reflect/Proxy.newProxyInstance:(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
        //    32: checkcast       Lorg/mozilla/javascript/Scriptable;
        //    35: putstatic       org/mozilla/javascript/Undefined.SCRIPTABLE_UNDEFINED:Lorg/mozilla/javascript/Scriptable;
        //    38: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Could not infer any expression.
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
}
