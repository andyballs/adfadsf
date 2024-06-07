//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import kotlin.text.*;
import kotlin.collections.*;
import java.lang.reflect.*;
import dev.falsehonesty.asmhelper.dsl.instructions.*;
import dev.falsehonesty.asmhelper.printing.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/AsmBlockModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "targetMethodNode", "Lorg/objectweb/asm/tree/MethodNode;", "(Lorg/objectweb/asm/tree/MethodNode;)V", "getTargetMethodNode", "()Lorg/objectweb/asm/tree/MethodNode;", "modify", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "modifyAsmBlock", "node", "Lorg/objectweb/asm/tree/MethodInsnNode;", "AsmHelper1.8.9" })
public final class AsmBlockModifier extends Modifier
{
    @NotNull
    private final MethodNode targetMethodNode;
    
    public AsmBlockModifier(@NotNull final MethodNode targetMethodNode) {
        Intrinsics.checkNotNullParameter((Object)targetMethodNode, "targetMethodNode");
        this.targetMethodNode = targetMethodNode;
    }
    
    @NotNull
    public final MethodNode getTargetMethodNode() {
        return this.targetMethodNode;
    }
    
    @Override
    public void modify(@NotNull final InsnList instructions) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        for (final AbstractInsnNode node : instructions) {
            if (node instanceof MethodInsnNode && ((MethodInsnNode)node).getOpcode() == 182 && Intrinsics.areEqual((Object)((MethodInsnNode)node).name, (Object)"asm") && Intrinsics.areEqual((Object)((MethodInsnNode)node).owner, (Object)"dev/falsehonesty/asmhelper/dsl/code/CodeBlock$Companion")) {
                this.modifyAsmBlock((MethodInsnNode)node, instructions);
            }
        }
    }
    
    private final void modifyAsmBlock(final MethodInsnNode node, final InsnList instructions) {
        final AbstractInsnNode lambdaValue = node.getPrevious().getPrevious();
        if (lambdaValue instanceof FieldInsnNode) {
            final String bytecodeClassName = ((FieldInsnNode)lambdaValue).owner;
            Intrinsics.checkNotNullExpressionValue((Object)bytecodeClassName, "bytecodeClassName");
            final Class bytecodeClass = Class.forName(StringsKt.replace$default(bytecodeClassName, "/", ".", false, 4, (Object)null));
            final Constructor[] declaredConstructors = bytecodeClass.getDeclaredConstructors();
            Intrinsics.checkNotNullExpressionValue((Object)declaredConstructors, "bytecodeClass.declaredConstructors");
            final Constructor constr = (Constructor)ArraysKt.first((Object[])declaredConstructors);
            constr.setAccessible(true);
            final Object asmLambda = constr.newInstance(new Object[0]);
            final Method[] declaredMethods = bytecodeClass.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue((Object)declaredMethods, "bytecodeClass.declaredMethods");
            final Object[] $this$first$iv = declaredMethods;
            final int $i$f$first = 0;
            for (Object element$iv : $this$first$iv) {
                final Method it = (Method)element$iv;
                final int n = 0;
                boolean b = false;
                Label_0252: {
                    if (it.getParameters().length == 1) {
                        final Parameter[] parameters = it.getParameters();
                        Intrinsics.checkNotNullExpressionValue((Object)parameters, "it.parameters");
                        if (Intrinsics.areEqual((Object)((Parameter)ArraysKt.first((Object[])parameters)).getType(), (Object)InsnListBuilder.class)) {
                            b = true;
                            break Label_0252;
                        }
                    }
                    b = false;
                }
                if (b) {
                    final Method invokeMethod = (Method)element$iv;
                    invokeMethod.setAccessible(true);
                    final InsnListBuilder builder = new InsnListBuilder(this.targetMethodNode);
                    invokeMethod.invoke(asmLambda, builder);
                    final InsnList insns = builder.build();
                    final String s = "- ";
                    final AbstractInsnNode previous = node.getPrevious();
                    Intrinsics.checkNotNullExpressionValue((Object)previous, "node.previous");
                    PrintingKt.verbose(Intrinsics.stringPlus(s, (Object)PrettyprintingKt.prettyString(previous)));
                    instructions.remove(node.getPrevious());
                    final String s2 = "- ";
                    final AbstractInsnNode previous2 = node.getPrevious();
                    Intrinsics.checkNotNullExpressionValue((Object)previous2, "node.previous");
                    PrintingKt.verbose(Intrinsics.stringPlus(s2, (Object)PrettyprintingKt.prettyString(previous2)));
                    instructions.remove(node.getPrevious());
                    PrintingKt.verbose(Intrinsics.stringPlus("- ", (Object)PrettyprintingKt.prettyString((AbstractInsnNode)node)));
                    final Iterable $this$forEach$iv = StringsKt.split$default((CharSequence)PrettyprintingKt.prettyString(insns), new String[] { "\n" }, false, 0, 6, (Object)null);
                    final int $i$f$forEach = 0;
                    final Iterator<Object> iterator = (Iterator<Object>)$this$forEach$iv.iterator();
                    while (iterator.hasNext()) {
                        element$iv = iterator.next();
                        final String it2 = (String)element$iv;
                        final int n2 = 0;
                        if (!StringsKt.isBlank((CharSequence)it2)) {
                            PrintingKt.verbose(Intrinsics.stringPlus("+ ", (Object)it2));
                        }
                    }
                    instructions.insertBefore((AbstractInsnNode)node, insns);
                    instructions.remove((AbstractInsnNode)node);
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        if (lambdaValue instanceof MethodInsnNode) {
            throw new IllegalArgumentException("Inline asm blocks can't capture locals");
        }
        throw new IllegalStateException(lambdaValue + " isn't expected");
    }
}
