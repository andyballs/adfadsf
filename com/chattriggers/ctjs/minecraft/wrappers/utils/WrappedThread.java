//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.wrappers.utils;

import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import org.mozilla.javascript.*;
import com.chattriggers.ctjs.engine.langs.js.*;
import com.chattriggers.ctjs.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/utils/WrappedThread;", "", "task", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "destroy", "", "getId", "", "interrupt", "isAlive", "", "isInterrupted", "resume", "run", "start", "stop", "suspend", "Companion", "ctjs" })
public final class WrappedThread
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Runnable task;
    
    public WrappedThread(@NotNull final Runnable task) {
        Intrinsics.checkNotNullParameter((Object)task, "task");
        this.task = task;
    }
    
    public final void start() {
        ForkJoinPool.commonPool().execute(WrappedThread::start$lambda-0);
    }
    
    public final void run() {
    }
    
    public final void stop() {
    }
    
    public final void interrupt() {
    }
    
    public final boolean isInterrupted() {
        return false;
    }
    
    public final void destroy() {
    }
    
    public final boolean isAlive() {
        return true;
    }
    
    public final void suspend() {
    }
    
    public final void resume() {
    }
    
    public final long getId() {
        return 0L;
    }
    
    private static final void start$lambda-0(final WrappedThread this$0) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        try {
            JSContextFactory.INSTANCE.enterContext();
            this$0.task.run();
            Context.exit();
        }
        catch (Throwable e) {
            ReferenceKt.printTraceToConsole(e, JSLoader.INSTANCE.getConsole());
        }
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void sleep(final long millis, final int nanos) {
        WrappedThread.Companion.sleep(millis, nanos);
    }
    
    @JvmStatic
    @NotNull
    public static final Thread currentThread() {
        return WrappedThread.Companion.currentThread();
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void sleep(final long millis) {
        WrappedThread.Companion.sleep(millis);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/wrappers/utils/WrappedThread$Companion;", "", "()V", "currentThread", "Ljava/lang/Thread;", "sleep", "", "millis", "", "nanos", "", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        @JvmOverloads
        public final void sleep(final long millis, final int nanos) {
            Thread.sleep(millis, nanos);
        }
        
        public static /* synthetic */ void sleep$default(final Companion companion, final long millis, int nanos, final int n, final Object o) {
            if ((n & 0x2) != 0x0) {
                nanos = 0;
            }
            companion.sleep(millis, nanos);
        }
        
        @JvmStatic
        @NotNull
        public final Thread currentThread() {
            final Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue((Object)currentThread, "currentThread()");
            return currentThread;
        }
        
        @JvmStatic
        @JvmOverloads
        public final void sleep(final long millis) {
            sleep$default(this, millis, 0, 2, null);
        }
    }
}
