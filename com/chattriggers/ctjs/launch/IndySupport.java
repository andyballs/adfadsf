//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.launch;

import kotlin.*;
import kotlin.jvm.internal.*;
import java.lang.invoke.*;
import kotlin.jvm.*;
import com.chattriggers.ctjs.engine.module.*;
import org.jetbrains.annotations.*;
import org.mozilla.javascript.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0007J7\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "Lcom/chattriggers/ctjs/launch/IndySupport;", "", "()V", "DUMMY_INVOKE_HANDLE", "Ljava/lang/invoke/MethodHandle;", "getDUMMY_INVOKE_HANDLE", "()Ljava/lang/invoke/MethodHandle;", "areLoadersConfigured", "", "invocationInvalidator", "Ljava/lang/invoke/SwitchPoint;", "bootstrapInvokeJS", "Ljava/lang/invoke/CallSite;", "lookup", "Ljava/lang/invoke/MethodHandles$Lookup;", "name", "", "type", "Ljava/lang/invoke/MethodType;", "moduleName", "functionID", "initInvokeJS", "callSite", "Ljava/lang/invoke/MutableCallSite;", "args", "", "(Ljava/lang/invoke/MutableCallSite;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "invalidateInvocations", "", "ctjs" })
public final class IndySupport
{
    @NotNull
    public static final IndySupport INSTANCE;
    @NotNull
    private static SwitchPoint invocationInvalidator;
    private static boolean areLoadersConfigured;
    @NotNull
    private static final MethodHandle DUMMY_INVOKE_HANDLE;
    
    private IndySupport() {
    }
    
    @NotNull
    public final MethodHandle getDUMMY_INVOKE_HANDLE() {
        return IndySupport.DUMMY_INVOKE_HANDLE;
    }
    
    @JvmStatic
    @NotNull
    public static final CallSite bootstrapInvokeJS(@NotNull final MethodHandles.Lookup lookup, @NotNull final String name, @NotNull final MethodType type, @NotNull final String moduleName, @NotNull final String functionID) {
        Intrinsics.checkNotNullParameter((Object)lookup, "lookup");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)moduleName, "moduleName");
        Intrinsics.checkNotNullParameter((Object)functionID, "functionID");
        final MutableCallSite callSite = new MutableCallSite(type);
        final MethodHandle initHandle = MethodHandles.insertArguments(lookup.findStatic(IndySupport.class, "initInvokeJS", MethodType.methodType(Object.class, MutableCallSite.class, String.class, String.class, Object[].class)), 0, callSite, moduleName, functionID);
        callSite.setTarget(initHandle.asType(type));
        return callSite;
    }
    
    @JvmStatic
    @Nullable
    public static final Object initInvokeJS(@NotNull final MutableCallSite callSite, @NotNull final String moduleName, @NotNull final String functionID, @NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)callSite, "callSite");
        Intrinsics.checkNotNullParameter((Object)moduleName, "moduleName");
        Intrinsics.checkNotNullParameter((Object)functionID, "functionID");
        Intrinsics.checkNotNullParameter((Object)args, "args");
        MethodHandle methodHandle;
        if (IndySupport.areLoadersConfigured) {
            methodHandle = ModuleManager.INSTANCE.asmInvokeLookup(moduleName, functionID);
        }
        else {
            final IndySupport instance = IndySupport.INSTANCE;
            methodHandle = IndySupport.DUMMY_INVOKE_HANDLE;
        }
        final MethodHandle targetHandle = methodHandle;
        final MethodHandle initTarget = callSite.getTarget();
        final MethodHandle guardedTarget = IndySupport.invocationInvalidator.guardWithTest(targetHandle, initTarget);
        callSite.setTarget(guardedTarget);
        return targetHandle.invoke(args);
    }
    
    public final void invalidateInvocations(final boolean areLoadersConfigured) {
        IndySupport.areLoadersConfigured = areLoadersConfigured;
        SwitchPoint.invalidateAll(new SwitchPoint[] { IndySupport.invocationInvalidator });
        IndySupport.invocationInvalidator = new SwitchPoint();
    }
    
    static {
        INSTANCE = new IndySupport();
        IndySupport.invocationInvalidator = new SwitchPoint();
        final MethodHandle dropArguments = MethodHandles.dropArguments(MethodHandles.constant(Object.class, Undefined.instance), 0, Object[].class);
        Intrinsics.checkNotNullExpressionValue((Object)dropArguments, "dropArguments(\n        M\u2026<Any?>::class.java,\n    )");
        DUMMY_INVOKE_HANDLE = dropArguments;
    }
}
