//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.engine;

import kotlin.*;
import com.chattriggers.ctjs.utils.console.*;
import java.util.*;
import com.chattriggers.ctjs.engine.module.*;
import java.net.*;
import java.lang.invoke.*;
import com.chattriggers.ctjs.triggers.*;
import com.chattriggers.ctjs.engine.langs.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.text.*;
import kotlin.io.*;
import org.apache.commons.io.*;
import java.io.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0007H&J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000fH&J\b\u0010\u0016\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H&J'\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001eH&¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\"\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\u00020\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H&J/\u0010\b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00012\u0010\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001eH&¢\u0006\u0002\u0010.R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006/" }, d2 = { "Lcom/chattriggers/ctjs/engine/ILoader;", "", "console", "Lcom/chattriggers/ctjs/utils/console/Console;", "getConsole", "()Lcom/chattriggers/ctjs/utils/console/Console;", "addTrigger", "", "trigger", "Lcom/chattriggers/ctjs/triggers/Trigger;", "asmInvokeLookup", "Ljava/lang/invoke/MethodHandle;", "module", "Lcom/chattriggers/ctjs/engine/module/Module;", "functionURI", "Ljava/net/URI;", "asmPass", "asmURI", "asmSetup", "clearTriggers", "entryPass", "entryURI", "entrySetup", "eval", "", "code", "exec", "type", "Lcom/chattriggers/ctjs/triggers/TriggerType;", "args", "", "(Lcom/chattriggers/ctjs/triggers/TriggerType;[Ljava/lang/Object;)V", "getLanguage", "Lcom/chattriggers/ctjs/engine/langs/Lang;", "removeTrigger", "saveResource", "resourceName", "outputFile", "Ljava/io/File;", "replace", "", "setup", "jars", "", "Ljava/net/URL;", "method", "(Lcom/chattriggers/ctjs/triggers/Trigger;Ljava/lang/Object;[Ljava/lang/Object;)V", "ctjs" })
public interface ILoader
{
    @NotNull
    Console getConsole();
    
    void setup(@NotNull final List<URL> p0);
    
    void asmSetup();
    
    void asmPass(@NotNull final Module p0, @NotNull final URI p1);
    
    void entrySetup();
    
    void entryPass(@NotNull final Module p0, @NotNull final URI p1);
    
    @NotNull
    MethodHandle asmInvokeLookup(@NotNull final Module p0, @NotNull final URI p1);
    
    void exec(@NotNull final TriggerType p0, @NotNull final Object[] p1);
    
    @NotNull
    String eval(@NotNull final String p0);
    
    void addTrigger(@NotNull final Trigger p0);
    
    void clearTriggers();
    
    @NotNull
    Lang getLanguage();
    
    void trigger(@NotNull final Trigger p0, @NotNull final Object p1, @NotNull final Object[] p2);
    
    void removeTrigger(@NotNull final Trigger p0);
    
    @NotNull
    String saveResource(@Nullable final String p0, @NotNull final File p1, final boolean p2);
    
    @Metadata(mv = { 1, 6, 0 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        @NotNull
        public static String saveResource(@NotNull final ILoader this, @Nullable final String resourceName, @NotNull final File outputFile, final boolean replace) {
            Intrinsics.checkNotNullParameter((Object)this, "this");
            Intrinsics.checkNotNullParameter((Object)outputFile, "outputFile");
            if (resourceName == null || Intrinsics.areEqual((Object)resourceName, (Object)"")) {
                final int n = 0;
                throw new IllegalArgumentException("ResourcePath cannot be null or empty".toString());
            }
            final String parsedResourceName = StringsKt.replace$default(resourceName, '\\', '/', false, 4, (Object)null);
            final InputStream resourceAsStream = this.getClass().getResourceAsStream(parsedResourceName);
            if (resourceAsStream == null) {
                throw new IllegalArgumentException("The embedded resource '" + parsedResourceName + "' cannot be found.");
            }
            final InputStream resource = resourceAsStream;
            final InputStreamReader in = new InputStreamReader(resource, Charsets.UTF_8);
            final int sz = 8192;
            final String res = TextStreamsKt.readText((Reader)((in instanceof BufferedReader) ? in : new BufferedReader(in, sz)));
            FileUtils.write(outputFile, (CharSequence)res);
            return res;
        }
    }
}
