//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.triggers;

import com.chattriggers.ctjs.engine.*;
import kotlin.jvm.internal.*;
import kotlin.collections.*;
import org.jetbrains.annotations.*;
import kotlin.*;
import java.util.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00032\u0010\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0010H&¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00002\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nJ\u0016\u0010\u0016\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u001a\u0010\u0017\u001a\u00020\u00002\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nH\u0007J\u001f\u0010\u0018\u001a\u00020\u00192\u0010\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0010H\u0016¢\u0006\u0002\u0010\u001aR\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b" }, d2 = { "Lcom/chattriggers/ctjs/triggers/ClassFilterTrigger;", "Lcom/chattriggers/ctjs/triggers/Trigger;", "method", "", "triggerType", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "loader", "Lcom/chattriggers/ctjs/engine/ILoader;", "(Ljava/lang/Object;Lcom/chattriggers/ctjs/triggers/TriggerType;Lcom/chattriggers/ctjs/engine/ILoader;)V", "triggerClasses", "", "Ljava/lang/Class;", "getTriggerType", "()Lcom/chattriggers/ctjs/triggers/TriggerType;", "evalTriggerType", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "setFilteredClass", "clazz", "setFilteredClasses", "classes", "setPacketClass", "setPacketClasses", "trigger", "", "([Ljava/lang/Object;)V", "ctjs" })
public abstract class ClassFilterTrigger extends Trigger
{
    @NotNull
    private final TriggerType triggerType;
    @NotNull
    private List<? extends Class<?>> triggerClasses;
    
    public ClassFilterTrigger(@NotNull final Object method, @NotNull final TriggerType triggerType, @NotNull final ILoader loader) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter((Object)triggerType, "triggerType");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        super(method, triggerType, loader);
        this.triggerType = triggerType;
        this.triggerClasses = (List<? extends Class<?>>)CollectionsKt.emptyList();
    }
    
    @NotNull
    public final TriggerType getTriggerType() {
        return this.triggerType;
    }
    
    @Deprecated(message = "Prefer setFilteredClass", replaceWith = @ReplaceWith(expression = "setFilteredClass(MyClass.class)", imports = {}))
    @NotNull
    @java.lang.Deprecated
    public final ClassFilterTrigger setPacketClass(@Nullable final Class<?> clazz) {
        return this.setFilteredClasses(CollectionsKt.listOfNotNull((Object)clazz));
    }
    
    @Deprecated(message = "Prefer setFilteredClasses", replaceWith = @ReplaceWith(expression = "setFilteredClasses([A.class, B.class, C.class])", imports = {}))
    @NotNull
    @java.lang.Deprecated
    public final ClassFilterTrigger setPacketClasses(@NotNull final List<? extends Class<?>> classes) {
        Intrinsics.checkNotNullParameter((Object)classes, "classes");
        return this.setFilteredClasses(classes);
    }
    
    @NotNull
    public final ClassFilterTrigger setFilteredClass(@Nullable final Class<?> clazz) {
        return this.setFilteredClasses(CollectionsKt.listOfNotNull((Object)clazz));
    }
    
    @NotNull
    public final ClassFilterTrigger setFilteredClasses(@NotNull final List<? extends Class<?>> classes) {
        Intrinsics.checkNotNullParameter((Object)classes, "classes");
        final ClassFilterTrigger $this$setFilteredClasses_u24lambda_u2d0 = this;
        final int n = 0;
        $this$setFilteredClasses_u24lambda_u2d0.triggerClasses = classes;
        return this;
    }
    
    @Override
    public void trigger(@NotNull final Object[] args) {
        Intrinsics.checkNotNullParameter((Object)args, "args");
        final Object placeholder = this.evalTriggerType(args);
        if (!this.triggerClasses.isEmpty()) {
            final Iterable $this$any$iv = this.triggerClasses;
            final int $i$f$any = 0;
            boolean b = false;
            Label_0109: {
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    b = false;
                }
                else {
                    for (final Object element$iv : $this$any$iv) {
                        final Class it = (Class)element$iv;
                        final int n = 0;
                        if (it.isInstance(placeholder)) {
                            b = true;
                            break Label_0109;
                        }
                    }
                    b = false;
                }
            }
            if (!b) {
                return;
            }
        }
        this.callMethod(args);
    }
    
    @NotNull
    public abstract Object evalTriggerType(@NotNull final Object[] p0);
}
