//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.printing;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.*;
import java.util.*;
import kotlin.text.*;
import java.io.*;
import org.objectweb.asm.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0007\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t" }, d2 = { "methodTracer", "Lorg/objectweb/asm/util/TraceMethodVisitor;", "textifier", "Lorg/objectweb/asm/util/Textifier;", "textifierToString", "", "prettyString", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "Lorg/objectweb/asm/tree/InsnList;", "AsmHelper1.8.9" })
public final class PrettyprintingKt
{
    @NotNull
    private static final Textifier textifier;
    @NotNull
    private static final TraceMethodVisitor methodTracer;
    
    @NotNull
    public static final String prettyString(@NotNull final InsnList $this$prettyString) {
        Intrinsics.checkNotNullParameter((Object)$this$prettyString, "<this>");
        final ListIterator iterator = $this$prettyString.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, "iterator()");
        final Iterator $this$forEach$iv = iterator;
        final int $i$f$forEach = 0;
        final Iterator iterator2 = $this$forEach$iv;
        while (iterator2.hasNext()) {
            final Object element$iv = iterator2.next();
            final AbstractInsnNode it = (AbstractInsnNode)element$iv;
            final int n = 0;
            it.accept((MethodVisitor)PrettyprintingKt.methodTracer);
        }
        return textifierToString();
    }
    
    @NotNull
    public static final String prettyString(@NotNull final AbstractInsnNode $this$prettyString) {
        Intrinsics.checkNotNullParameter((Object)$this$prettyString, "<this>");
        $this$prettyString.accept((MethodVisitor)PrettyprintingKt.methodTracer);
        final String textifierToString = textifierToString();
        if (textifierToString == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        return StringsKt.trim((CharSequence)textifierToString).toString();
    }
    
    private static final String textifierToString() {
        final StringWriter stringWriter = new StringWriter();
        PrettyprintingKt.textifier.print(new PrintWriter(stringWriter));
        PrettyprintingKt.textifier.getText().clear();
        final String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "stringWriter.toString()");
        return string;
    }
    
    static {
        textifier = new Textifier();
        methodTracer = new TraceMethodVisitor((Printer)PrettyprintingKt.textifier);
    }
}
