//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine.langs.js;

import com.chattriggers.ctjs.engine.*;
import java.util.concurrent.*;
import com.chattriggers.ctjs.triggers.*;
import org.jetbrains.annotations.*;
import com.chattriggers.ctjs.utils.console.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.engine.module.*;
import java.net.*;
import kotlin.jvm.*;
import java.util.*;
import dev.falsehonesty.asmhelper.dsl.*;
import dev.falsehonesty.asmhelper.dsl.writers.*;
import com.chattriggers.ctjs.engine.langs.*;
import com.chattriggers.ctjs.*;
import java.io.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import java.lang.invoke.*;
import org.mozilla.javascript.commonjs.module.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.commonjs.module.provider.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001[B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J8\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0007Jd\u0010#\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0)2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00180,H\u0007J%\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000402H\u0007¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020\u00182\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u000208H\u0016JD\u0010;\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0)2\u0006\u0010<\u001a\u00020=H\u0007J\b\u0010>\u001a\u00020\u0018H\u0016J\b\u0010?\u001a\u00020\u0018H\u0016J\u0018\u0010@\u001a\u00020\u00182\u0006\u00105\u001a\u0002062\u0006\u0010A\u001a\u000208H\u0016J\b\u0010B\u001a\u00020\u0018H\u0016J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u001cH\u0016J'\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00142\u0010\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000402H\u0016¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020IH\u0016J\u0016\u0010J\u001a\u00020\u00182\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0!H\u0002J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010N\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0016\u0010O\u001a\u00020\u00182\f\u0010P\u001a\b\u0012\u0004\u0012\u00020L0!H\u0016J/\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u00042\u0010\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000402H\u0016¢\u0006\u0002\u0010RJC\u0010S\u001a\u0002HT\"\u0004\b\u0000\u0010T2!\u0010U\u001a\u001d\u0012\u0013\u0012\u00110V¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(Y\u0012\u0004\u0012\u0002HT0,H\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010ZR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSLoader;", "Lcom/chattriggers/ctjs/engine/ILoader;", "()V", "ASMLib", "", "INVOKE_JS_CALL", "Ljava/lang/invoke/MethodHandle;", "kotlin.jvm.PlatformType", "console", "Lcom/chattriggers/ctjs/utils/console/Console;", "getConsole", "()Lcom/chattriggers/ctjs/utils/console/Console;", "console$delegate", "Lkotlin/Lazy;", "require", "Lcom/chattriggers/ctjs/engine/langs/js/JSLoader$CTRequire;", "scope", "Lorg/mozilla/javascript/Scriptable;", "triggers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "addTrigger", "", "trigger", "asmFieldHelper", "_className", "", "_fieldName", "_fieldDesc", "_initialValue", "_accessTypes", "", "Ldev/falsehonesty/asmhelper/dsl/writers/AccessType;", "asmInjectHelper", "_at", "Ldev/falsehonesty/asmhelper/dsl/At;", "_methodName", "_methodDesc", "_fieldMaps", "", "_methodMaps", "_insnList", "Lkotlin/Function1;", "Lorg/mozilla/javascript/Wrapper;", "asmInvoke", "func", "Lorg/mozilla/javascript/Callable;", "args", "", "(Lorg/mozilla/javascript/Callable;[Ljava/lang/Object;)Ljava/lang/Object;", "asmInvokeLookup", "module", "Lcom/chattriggers/ctjs/engine/module/Module;", "functionURI", "Ljava/net/URI;", "asmPass", "asmURI", "asmRemoveHelper", "_numberToRemove", "", "asmSetup", "clearTriggers", "entryPass", "entryURI", "entrySetup", "eval", "code", "exec", "type", "(Lcom/chattriggers/ctjs/triggers/TriggerType;[Ljava/lang/Object;)V", "getLanguage", "Lcom/chattriggers/ctjs/engine/langs/Lang;", "instanceContexts", "files", "Ljava/net/URL;", "newTriggerSet", "removeTrigger", "setup", "jars", "method", "(Lcom/chattriggers/ctjs/triggers/Trigger;Ljava/lang/Object;[Ljava/lang/Object;)V", "wrapInContext", "T", "block", "Lorg/mozilla/javascript/Context;", "Lkotlin/ParameterName;", "name", "cx", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "CTRequire", "ctjs" })
public final class JSLoader implements ILoader
{
    @NotNull
    public static final JSLoader INSTANCE;
    @NotNull
    private static final ConcurrentHashMap<TriggerType, ConcurrentSkipListSet<Trigger>> triggers;
    @NotNull
    private static final Lazy console$delegate;
    private static Scriptable scope;
    private static CTRequire require;
    @Nullable
    private static Object ASMLib;
    private static final MethodHandle INVOKE_JS_CALL;
    
    private JSLoader() {
    }
    
    @NotNull
    public Console getConsole() {
        return (Console)JSLoader.console$delegate.getValue();
    }
    
    public void exec(@NotNull final TriggerType type, @NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)args, "args");
        if (!Reference.INSTANCE.isLoaded()) {
            return;
        }
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)new JSLoader$exec.JSLoader$exec$1(type, args));
    }
    
    public void addTrigger(@NotNull final Trigger trigger) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "trigger"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: getstatic       com/chattriggers/ctjs/engine/langs/js/JSLoader.triggers:Ljava/util/concurrent/ConcurrentHashMap;
        //     9: checkcast       Ljava/util/concurrent/ConcurrentMap;
        //    12: astore_2       
        //    13: aload_1         /* trigger */
        //    14: invokevirtual   com/chattriggers/ctjs/triggers/Trigger.getType:()Lcom/chattriggers/ctjs/triggers/TriggerType;
        //    17: astore_3        /* key$iv */
        //    18: iconst_0       
        //    19: istore          $i$f$getOrPut
        //    21: aload_2         /* $this$getOrPut$iv */
        //    22: aload_3         /* key$iv */
        //    23: invokeinterface java/util/concurrent/ConcurrentMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    28: dup            
        //    29: ifnonnull       62
        //    32: pop            
        //    33: iconst_0       
        //    34: istore          $i$a$-getOrPut-JSLoader$addTrigger$1
        //    36: aload_0         /* this */
        //    37: invokespecial   com/chattriggers/ctjs/engine/langs/js/JSLoader.newTriggerSet:()Ljava/util/concurrent/ConcurrentSkipListSet;
        //    40: astore          default$iv
        //    42: iconst_0       
        //    43: istore          $i$a$-let-MapsKt__MapsJVMKt$getOrPut$1$iv
        //    45: aload_2         /* $this$getOrPut$iv */
        //    46: aload_3         /* key$iv */
        //    47: aload           default$iv
        //    49: invokeinterface java/util/concurrent/ConcurrentMap.putIfAbsent:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    54: dup            
        //    55: ifnonnull       61
        //    58: pop            
        //    59: aload           default$iv
        //    61: nop            
        //    62: nop            
        //    63: checkcast       Ljava/util/concurrent/ConcurrentSkipListSet;
        //    66: aload_1         /* trigger */
        //    67: invokevirtual   java/util/concurrent/ConcurrentSkipListSet.add:(Ljava/lang/Object;)Z
        //    70: pop            
        //    71: return         
        //    StackMapTable: 00 02 FF 00 3D 00 08 07 00 02 07 00 BA 07 00 B8 07 00 CB 01 01 07 00 CD 01 00 01 07 00 04 FF 00 00 00 05 07 00 02 07 00 BA 07 00 B8 07 00 CB 01 00 01 07 00 04
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
    
    public void clearTriggers() {
        JSLoader.triggers.clear();
    }
    
    public void removeTrigger(@NotNull final Trigger trigger) {
        Intrinsics.checkNotNullParameter((Object)trigger, "trigger");
        final ConcurrentSkipListSet<Trigger> set = JSLoader.triggers.get(trigger.getType());
        if (set != null) {
            set.remove(trigger);
        }
    }
    
    private final ConcurrentSkipListSet<Trigger> newTriggerSet() {
        return new ConcurrentSkipListSet<Trigger>();
    }
    
    public void setup(@NotNull final List<URL> jars) {
        Intrinsics.checkNotNullParameter((Object)jars, "jars");
        this.instanceContexts(jars);
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)JSLoader$setup.JSLoader$setup$1.INSTANCE);
    }
    
    public void asmSetup() {
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)JSLoader$asmSetup.JSLoader$asmSetup$1.INSTANCE);
    }
    
    public void asmPass(@NotNull final Module module, @NotNull final URI asmURI) {
        Intrinsics.checkNotNullParameter((Object)module, "module");
        Intrinsics.checkNotNullParameter((Object)asmURI, "asmURI");
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)new JSLoader$asmPass.JSLoader$asmPass$1(module, asmURI));
    }
    
    public void entrySetup() {
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)JSLoader$entrySetup.JSLoader$entrySetup$1.INSTANCE);
    }
    
    public void entryPass(@NotNull final Module module, @NotNull final URI entryURI) {
        Intrinsics.checkNotNullParameter((Object)module, "module");
        Intrinsics.checkNotNullParameter((Object)entryURI, "entryURI");
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)new JSLoader$entryPass.JSLoader$entryPass$1(module, entryURI));
    }
    
    @NotNull
    public MethodHandle asmInvokeLookup(@NotNull final Module module, @NotNull final URI functionURI) {
        Intrinsics.checkNotNullParameter((Object)module, "module");
        Intrinsics.checkNotNullParameter((Object)functionURI, "functionURI");
        final MethodHandle wrapInContext = this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ? extends MethodHandle>)new JSLoader$asmInvokeLookup.JSLoader$asmInvokeLookup$1(module, functionURI));
        Intrinsics.checkNotNullExpressionValue((Object)wrapInContext, "module: Module, function\u2026E\n            }\n        }");
        return wrapInContext;
    }
    
    @JvmStatic
    @NotNull
    public static final Object asmInvoke(@NotNull final Callable func, @NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)func, "func");
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final Object wrapInContext = JSLoader.INSTANCE.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)new JSLoader$asmInvoke.JSLoader$asmInvoke$1(func, args));
        Intrinsics.checkNotNullExpressionValue(wrapInContext, "func: Callable, args: Ar\u2026e, scope, args)\n        }");
        return wrapInContext;
    }
    
    private final <T> T wrapInContext(final Function1<? super Context, ? extends T> block) {
        return (T)JSContextFactory.INSTANCE.call(JSLoader::wrapInContext$lambda-1);
    }
    
    @JvmStatic
    public static final void asmInjectHelper(@NotNull final String _className, @NotNull final At _at, @NotNull final String _methodName, @NotNull final String _methodDesc, @NotNull final Map<String, String> _fieldMaps, @NotNull final Map<String, String> _methodMaps, @NotNull final Function1<? super Wrapper, Unit> _insnList) {
        Intrinsics.checkNotNullParameter((Object)_className, "_className");
        Intrinsics.checkNotNullParameter((Object)_at, "_at");
        Intrinsics.checkNotNullParameter((Object)_methodName, "_methodName");
        Intrinsics.checkNotNullParameter((Object)_methodDesc, "_methodDesc");
        Intrinsics.checkNotNullParameter((Object)_fieldMaps, "_fieldMaps");
        Intrinsics.checkNotNullParameter((Object)_methodMaps, "_methodMaps");
        Intrinsics.checkNotNullParameter((Object)_insnList, "_insnList");
        Method.inject((Function1)new JSLoader$asmInjectHelper.JSLoader$asmInjectHelper$1(_className, _methodName, _methodDesc, _at, (Map)_fieldMaps, (Map)_methodMaps, (Function1)_insnList));
    }
    
    @JvmStatic
    public static final void asmRemoveHelper(@NotNull final String _className, @NotNull final At _at, @NotNull final String _methodName, @NotNull final String _methodDesc, @NotNull final Map<String, String> _methodMaps, final int _numberToRemove) {
        Intrinsics.checkNotNullParameter((Object)_className, "_className");
        Intrinsics.checkNotNullParameter((Object)_at, "_at");
        Intrinsics.checkNotNullParameter((Object)_methodName, "_methodName");
        Intrinsics.checkNotNullParameter((Object)_methodDesc, "_methodDesc");
        Intrinsics.checkNotNullParameter((Object)_methodMaps, "_methodMaps");
        Method.remove((Function1)new JSLoader$asmRemoveHelper.JSLoader$asmRemoveHelper$1(_className, _methodName, _methodDesc, _at, (Map)_methodMaps, _numberToRemove));
    }
    
    @JvmStatic
    public static final void asmFieldHelper(@NotNull final String _className, @NotNull final String _fieldName, @NotNull final String _fieldDesc, @Nullable final Object _initialValue, @NotNull final List<? extends AccessType> _accessTypes) {
        Intrinsics.checkNotNullParameter((Object)_className, "_className");
        Intrinsics.checkNotNullParameter((Object)_fieldName, "_fieldName");
        Intrinsics.checkNotNullParameter((Object)_fieldDesc, "_fieldDesc");
        Intrinsics.checkNotNullParameter((Object)_accessTypes, "_accessTypes");
        Method.applyField((Function1)new JSLoader$asmFieldHelper.JSLoader$asmFieldHelper$1(_className, _fieldName, _fieldDesc, _initialValue, (List)_accessTypes));
    }
    
    @NotNull
    public String eval(@NotNull final String code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final String wrapInContext = this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ? extends String>)new JSLoader$eval.JSLoader$eval$1(code));
        Intrinsics.checkNotNullExpressionValue((Object)wrapInContext, "code: String): String {\n\u2026t\n            }\n        }");
        return wrapInContext;
    }
    
    @NotNull
    public Lang getLanguage() {
        return Lang.JS;
    }
    
    public void trigger(@NotNull final Trigger trigger, @NotNull final Object method, @NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)trigger, "trigger");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)args, "args");
        try {
            if (!(method instanceof Function)) {
                final int n = 0;
                throw new IllegalArgumentException("Need to pass actual function to the register function, not the name!".toString());
            }
            final Function function = (Function)method;
            final Context currentContext = Context.getCurrentContext();
            Scriptable scope;
            if ((scope = JSLoader.scope) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
                scope = null;
            }
            Scriptable scope2;
            if ((scope2 = JSLoader.scope) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
                scope2 = null;
            }
            function.call(currentContext, scope, scope2, args);
        }
        catch (Throwable e) {
            ReferenceKt.printTraceToConsole(e, this.getConsole());
            this.removeTrigger(trigger);
        }
    }
    
    private final void instanceContexts(final List<URL> files) {
        JSContextFactory.INSTANCE.addAllURLs((List)files);
        this.wrapInContext((kotlin.jvm.functions.Function1<? super Context, ?>)JSLoader$instanceContexts.JSLoader$instanceContexts$1.INSTANCE);
    }
    
    @NotNull
    public String saveResource(@Nullable final String resourceName, @NotNull final File outputFile, final boolean replace) {
        return ILoader.DefaultImpls.saveResource((ILoader)this, resourceName, outputFile, replace);
    }
    
    private static final Object wrapInContext$lambda-1(final Function1 $tmp0, final Context p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, "$tmp0");
        return $tmp0.invoke((Object)p0);
    }
    
    public static final /* synthetic */ Scriptable access$getScope$p() {
        return JSLoader.scope;
    }
    
    static {
        INSTANCE = new JSLoader();
        triggers = new ConcurrentHashMap<TriggerType, ConcurrentSkipListSet<Trigger>>();
        console$delegate = LazyKt.lazy((Function0)JSLoader$console.JSLoader$console$2.INSTANCE);
        INVOKE_JS_CALL = MethodHandles.lookup().findStatic(JSLoader.class, "asmInvoke", MethodType.methodType(Object.class, Callable.class, Object[].class));
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f" }, d2 = { "Lcom/chattriggers/ctjs/engine/langs/js/JSLoader$CTRequire;", "Lorg/mozilla/javascript/commonjs/module/Require;", "moduleProvider", "Lorg/mozilla/javascript/commonjs/module/provider/StrongCachingModuleScriptProvider;", "(Lorg/mozilla/javascript/commonjs/module/provider/StrongCachingModuleScriptProvider;)V", "cx", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/commonjs/module/ModuleScriptProvider;", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/commonjs/module/ModuleScriptProvider;)V", "loadCTModule", "Lorg/mozilla/javascript/Scriptable;", "cachedName", "", "uri", "Ljava/net/URI;", "ctjs" })
    public static final class CTRequire extends Require
    {
        public CTRequire(@NotNull final Context cx, @NotNull final ModuleScriptProvider moduleProvider) {
            Intrinsics.checkNotNullParameter((Object)cx, "cx");
            Intrinsics.checkNotNullParameter((Object)moduleProvider, "moduleProvider");
            Scriptable access$getScope$p;
            if ((access$getScope$p = JSLoader.access$getScope$p()) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
                access$getScope$p = null;
            }
            super(cx, access$getScope$p, moduleProvider, (Script)null, (Script)null, false);
        }
        
        public CTRequire(@NotNull final StrongCachingModuleScriptProvider moduleProvider) {
            Intrinsics.checkNotNullParameter((Object)moduleProvider, "moduleProvider");
            final Context enterContext = JSContextFactory.INSTANCE.enterContext();
            Intrinsics.checkNotNullExpressionValue((Object)enterContext, "JSContextFactory.enterContext()");
            this(enterContext, (ModuleScriptProvider)moduleProvider);
        }
        
        @NotNull
        public final Scriptable loadCTModule(@NotNull final String cachedName, @NotNull final URI uri) {
            Intrinsics.checkNotNullParameter((Object)cachedName, "cachedName");
            Intrinsics.checkNotNullParameter((Object)uri, "uri");
            final Scriptable exportedModuleInterface = this.getExportedModuleInterface(JSContextFactory.INSTANCE.enterContext(), cachedName, uri, (URI)null, false);
            Intrinsics.checkNotNullExpressionValue((Object)exportedModuleInterface, "getExportedModuleInterfa\u2026edName, uri, null, false)");
            return exportedModuleInterface;
        }
    }
}
