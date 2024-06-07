//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.text.*;
import dev.falsehonesty.asmhelper.printing.*;
import org.objectweb.asm.*;
import kotlin.collections.*;
import org.objectweb.asm.tree.*;
import dev.falsehonesty.asmhelper.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedMethodModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedModifier;", "codeBlockClass", "", "targetClassNode", "Lorg/objectweb/asm/tree/ClassNode;", "codeBlockMethod", "Lorg/objectweb/asm/tree/MethodNode;", "(Ljava/lang/String;Lorg/objectweb/asm/tree/ClassNode;Lorg/objectweb/asm/tree/MethodNode;)V", "getCodeBlockMethod", "()Lorg/objectweb/asm/tree/MethodNode;", "getTargetClassNode", "()Lorg/objectweb/asm/tree/ClassNode;", "manipulateShadowedMethodCall", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "node", "Lorg/objectweb/asm/tree/FieldInsnNode;", "shadowedName", "modifyFieldNode", "AsmHelper1.8.9" })
public final class ShadowedMethodModifier extends ShadowedModifier
{
    @NotNull
    private final ClassNode targetClassNode;
    @NotNull
    private final MethodNode codeBlockMethod;
    
    public ShadowedMethodModifier(@NotNull final String codeBlockClass, @NotNull final ClassNode targetClassNode, @NotNull final MethodNode codeBlockMethod) {
        Intrinsics.checkNotNullParameter((Object)codeBlockClass, "codeBlockClass");
        Intrinsics.checkNotNullParameter((Object)targetClassNode, "targetClassNode");
        Intrinsics.checkNotNullParameter((Object)codeBlockMethod, "codeBlockMethod");
        super(codeBlockClass);
        this.targetClassNode = targetClassNode;
        this.codeBlockMethod = codeBlockMethod;
    }
    
    @NotNull
    public final ClassNode getTargetClassNode() {
        return this.targetClassNode;
    }
    
    @NotNull
    public final MethodNode getCodeBlockMethod() {
        return this.codeBlockMethod;
    }
    
    @Override
    public void modifyFieldNode(@NotNull final InsnList instructions, @NotNull final FieldInsnNode node, @NotNull final String shadowedName) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        Intrinsics.checkNotNullParameter((Object)node, "node");
        Intrinsics.checkNotNullParameter((Object)shadowedName, "shadowedName");
        final String desc = node.desc;
        Intrinsics.checkNotNullExpressionValue((Object)desc, "node.desc");
        if (StringsKt.contains$default((CharSequence)desc, (CharSequence)"kotlin/jvm/functions/", false, 2, (Object)null)) {
            this.manipulateShadowedMethodCall(instructions, node, shadowedName);
        }
    }
    
    private final void manipulateShadowedMethodCall(final InsnList instructions, final FieldInsnNode node, final String shadowedName) {
        PrintingKt.verbose(Intrinsics.stringPlus(PrettyprintingKt.prettyString((AbstractInsnNode)node), (Object)" looks to be a shadowed method. Transforming now..."));
        AbstractInsnNode searchNode = node.getNext();
        MethodInsnNode finalCall = null;
        while (true) {
            if (searchNode instanceof MethodInsnNode && ((MethodInsnNode)searchNode).itf && Intrinsics.areEqual((Object)((MethodInsnNode)searchNode).name, (Object)"invoke")) {
                final String desc = node.desc;
                Intrinsics.checkNotNullExpressionValue((Object)desc, "node.desc");
                final String substring = desc.substring(1, node.desc.length() - 1);
                Intrinsics.checkNotNullExpressionValue((Object)substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                if (Intrinsics.areEqual((Object)substring, (Object)((MethodInsnNode)searchNode).owner)) {
                    break;
                }
            }
            if (searchNode instanceof MethodInsnNode) {
                final String owner = ((MethodInsnNode)searchNode).owner;
                Intrinsics.checkNotNullExpressionValue((Object)owner, "searchNode.owner");
                if (StringsKt.startsWith$default(owner, "java/lang", false, 2, (Object)null) && Intrinsics.areEqual((Object)((MethodInsnNode)searchNode).name, (Object)"valueOf")) {
                    PrintingKt.verbose("Found primitive -> wrapper call, likely an artifact from Kotlin's boxing, so let's toss it.");
                    PrintingKt.verbose(PrettyprintingKt.prettyString(searchNode));
                    final AbstractInsnNode tmp = ((MethodInsnNode)searchNode).getNext();
                    instructions.remove(searchNode);
                    searchNode = tmp;
                    continue;
                }
            }
            searchNode = searchNode.getNext();
        }
        finalCall = (MethodInsnNode)searchNode;
        final int numberOfArguments = Type.getArgumentTypes(finalCall.desc).length;
        final Analyzer analyzer = new Analyzer(instructions, this.codeBlockMethod);
        final AbstractInsnNode next = node.getNext();
        Intrinsics.checkNotNullExpressionValue((Object)next, "node.next");
        final Deque analyzedFrame = analyzer.analyze(next, (AbstractInsnNode)finalCall);
        final Type[] argumentTypes = new Type[numberOfArguments];
        for (int i = 0; i < numberOfArguments; ++i) {
            final int index = i;
            final int n = 0;
            argumentTypes[index] = analyzedFrame.pop();
        }
        ArraysKt.reverse((Object[])argumentTypes);
        PrintingKt.verbose(Intrinsics.stringPlus("Theoretically, the stack would look like this when the method is called: ", (Object)ArraysKt.toList((Object[])argumentTypes)));
        PrintingKt.verbose("We want the top " + numberOfArguments + " from it.");
        final AbstractInsnNode returnTypeIndicator = finalCall.getNext();
        Type type;
        if (returnTypeIndicator instanceof TypeInsnNode) {
            final Type rawType = Type.getObjectType(((TypeInsnNode)returnTypeIndicator).desc);
            Intrinsics.checkNotNullExpressionValue((Object)rawType, "rawType");
            type = this.wrappedTypeToPrimitive(rawType);
        }
        else {
            type = Type.VOID_TYPE;
        }
        final Type returnType = type;
        PrintingKt.verbose(Intrinsics.stringPlus("The return type is believed to be ", (Object)returnType));
        final String syntheticMethodDesc = Type.getMethodDescriptor(returnType, (Type[])Arrays.copyOf(argumentTypes, argumentTypes.length));
        PrintingKt.verbose(Intrinsics.stringPlus("Synthetic method description has been formed: ", (Object)syntheticMethodDesc));
        MethodInsnNode methodInsnNode;
        if (StringsKt.startsWith$default(shadowedName, "super", false, 2, (Object)null)) {
            final int beginIndex = 5;
            if (shadowedName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            final String substring2 = shadowedName.substring(beginIndex);
            Intrinsics.checkNotNullExpressionValue((Object)substring2, "(this as java.lang.String).substring(startIndex)");
            final String it = substring2;
            final int n2 = 0;
            String s3;
            if (StringsKt.startsWith$default(it, "_", false, 2, (Object)null)) {
                final String s = it;
                final int beginIndex2 = 1;
                final String s2 = s;
                if (s2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Intrinsics.checkNotNullExpressionValue((Object)(s3 = s2.substring(beginIndex2)), "(this as java.lang.String).substring(startIndex)");
            }
            else {
                s3 = StringsKt.decapitalize(it);
            }
            final String methodName = s3;
            final String mappedMethodName = AsmHelper.INSTANCE.getRemapper().mapInvocation(methodName);
            methodInsnNode = new MethodInsnNode(183, this.targetClassNode.superName, mappedMethodName, syntheticMethodDesc, false);
        }
        else {
            String substring3;
            if (StringsKt.startsWith$default(shadowedName, "_super", false, 2, (Object)null)) {
                final int beginIndex3 = 1;
                if (shadowedName == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Intrinsics.checkNotNullExpressionValue((Object)(substring3 = shadowedName.substring(beginIndex3)), "(this as java.lang.String).substring(startIndex)");
            }
            else {
                substring3 = shadowedName;
            }
            final String methodName = substring3;
            final String mappedMethodName = AsmHelper.INSTANCE.getRemapper().mapInvocation(methodName);
            methodInsnNode = new MethodInsnNode(182, this.targetClassNode.name, mappedMethodName, syntheticMethodDesc, false);
        }
        final MethodInsnNode methodCall = methodInsnNode;
        PrintingKt.verbose(Intrinsics.stringPlus("- ", (Object)PrettyprintingKt.prettyString((AbstractInsnNode)node)));
        instructions.remove((AbstractInsnNode)node);
        instructions.insertBefore((AbstractInsnNode)finalCall, (AbstractInsnNode)methodCall);
        instructions.remove((AbstractInsnNode)finalCall);
        PrintingKt.verbose(Intrinsics.stringPlus("- ", (Object)PrettyprintingKt.prettyString((AbstractInsnNode)finalCall)));
        PrintingKt.verbose(Intrinsics.stringPlus("+ ", (Object)PrettyprintingKt.prettyString((AbstractInsnNode)methodCall)));
        final AbstractInsnNode possibleWrapperToPrim = returnTypeIndicator.getNext();
        final String s4 = "- ";
        Intrinsics.checkNotNullExpressionValue((Object)returnTypeIndicator, "returnTypeIndicator");
        PrintingKt.verbose(Intrinsics.stringPlus(s4, (Object)PrettyprintingKt.prettyString(returnTypeIndicator)));
        instructions.remove(returnTypeIndicator);
        if (possibleWrapperToPrim instanceof MethodInsnNode) {
            final String owner2 = ((MethodInsnNode)possibleWrapperToPrim).owner;
            Intrinsics.checkNotNullExpressionValue((Object)owner2, "possibleWrapperToPrim.owner");
            if (StringsKt.startsWith$default(owner2, "java/lang/", false, 2, (Object)null)) {
                final String name = ((MethodInsnNode)possibleWrapperToPrim).name;
                Intrinsics.checkNotNullExpressionValue((Object)name, "possibleWrapperToPrim.name");
                if (StringsKt.endsWith$default(name, "Value", false, 2, (Object)null)) {
                    final String desc2 = ((MethodInsnNode)possibleWrapperToPrim).desc;
                    Intrinsics.checkNotNullExpressionValue((Object)desc2, "possibleWrapperToPrim.desc");
                    if (StringsKt.startsWith$default(desc2, "()", false, 2, (Object)null)) {
                        PrintingKt.verbose(Intrinsics.stringPlus("- ", (Object)PrettyprintingKt.prettyString(possibleWrapperToPrim)));
                        instructions.remove(possibleWrapperToPrim);
                    }
                }
            }
        }
    }
}
