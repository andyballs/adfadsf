//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.printing.*;
import kotlin.text.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.*;
import java.util.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/MutableRefModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "codeBlockMethodNode", "Lorg/objectweb/asm/tree/MethodNode;", "codeBlockClass", "", "(Lorg/objectweb/asm/tree/MethodNode;Ljava/lang/String;)V", "getCodeBlockClass", "()Ljava/lang/String;", "getCodeBlockMethodNode", "()Lorg/objectweb/asm/tree/MethodNode;", "copyReadWrite", "", "to", "Lorg/objectweb/asm/tree/FieldInsnNode;", "from", "getDescriptorForRefType", "refType", "locateRefWrite", "node", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "modify", "modifyRead", "readNode", "writeNode", "AsmHelper1.8.9" })
public final class MutableRefModifier extends Modifier
{
    @NotNull
    private final MethodNode codeBlockMethodNode;
    @NotNull
    private final String codeBlockClass;
    
    public MutableRefModifier(@NotNull final MethodNode codeBlockMethodNode, @NotNull final String codeBlockClass) {
        Intrinsics.checkNotNullParameter((Object)codeBlockMethodNode, "codeBlockMethodNode");
        Intrinsics.checkNotNullParameter((Object)codeBlockClass, "codeBlockClass");
        this.codeBlockMethodNode = codeBlockMethodNode;
        this.codeBlockClass = codeBlockClass;
    }
    
    @NotNull
    public final MethodNode getCodeBlockMethodNode() {
        return this.codeBlockMethodNode;
    }
    
    @NotNull
    public final String getCodeBlockClass() {
        return this.codeBlockClass;
    }
    
    public void modify(@NotNull final InsnList instructions) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        AbstractInsnNode node = instructions.getFirst();
        while (node.getNext() != null) {
            node = node.getNext();
            if (node instanceof FieldInsnNode && Intrinsics.areEqual((Object)((FieldInsnNode)node).owner, (Object)this.codeBlockClass)) {
                final String desc = ((FieldInsnNode)node).desc;
                Intrinsics.checkNotNullExpressionValue((Object)desc, "node.desc");
                if (!StringsKt.startsWith$default(desc, "Lkotlin/jvm/internal/Ref$", false, 2, (Object)null)) {
                    continue;
                }
                AbstractInsnNode next;
                int allowedActions;
                for (next = ((FieldInsnNode)node).getNext(), allowedActions = 1; next.getOpcode() == 89; next = ((FieldInsnNode)node).getNext(), ++allowedActions) {
                    instructions.remove(next);
                    instructions.insertBefore(node, next);
                }
                final String desc2 = ((FieldInsnNode)node).desc;
                Intrinsics.checkNotNullExpressionValue((Object)desc2, "node.desc");
                final String substring = desc2.substring(1, ((FieldInsnNode)node).desc.length() - 1);
                Intrinsics.checkNotNullExpressionValue((Object)substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                final String refType = substring;
                final FieldInsnNode writeNode = this.locateRefWrite((FieldInsnNode)node, instructions, refType);
                final String desc3 = ((FieldInsnNode)node).desc;
                Intrinsics.checkNotNullExpressionValue((Object)desc3, "node.desc");
                if (StringsKt.contains$default((CharSequence)desc3, (CharSequence)refType, false, 2, (Object)null)) {
                    final String descriptorForRefType = this.getDescriptorForRefType(refType);
                    Intrinsics.checkNotNull((Object)descriptorForRefType);
                    final String descriptor = descriptorForRefType;
                    ((FieldInsnNode)node).desc = descriptor;
                }
                boolean hasRead = false;
                if (next.getOpcode() == 180) {
                    final AbstractInsnNode abstractInsnNode = next;
                    if (abstractInsnNode == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.objectweb.asm.tree.FieldInsnNode");
                    }
                    if (Intrinsics.areEqual((Object)((FieldInsnNode)abstractInsnNode).owner, (Object)refType)) {
                        hasRead = true;
                        final AbstractInsnNode abstractInsnNode2 = next;
                        Intrinsics.checkNotNullExpressionValue((Object)abstractInsnNode2, "next");
                        this.modifyRead((FieldInsnNode)abstractInsnNode2, instructions, writeNode);
                        --allowedActions;
                    }
                }
                if (allowedActions <= 0) {
                    continue;
                }
                if (writeNode == null) {
                    PrintingKt.getLogger().error(Intrinsics.stringPlus("Couldn't locate write node for ", (Object)node));
                    return;
                }
                this.copyReadWrite(writeNode, (FieldInsnNode)node);
                final AbstractInsnNode next2 = writeNode.getNext();
                if (next2 == null) {
                    continue;
                }
                final AbstractInsnNode possibleRead = next2;
                if (possibleRead.getOpcode() == 180 && Intrinsics.areEqual((Object)((FieldInsnNode)possibleRead).owner, (Object)refType) && allowedActions > 0) {
                    this.copyReadWrite((FieldInsnNode)possibleRead, (FieldInsnNode)node);
                    hasRead = true;
                }
                if (hasRead) {
                    continue;
                }
                final AbstractInsnNode prev = ((FieldInsnNode)node).getPrevious();
                if (prev.getOpcode() == 25 && prev instanceof VarInsnNode) {
                    final String name = ((FieldInsnNode)node).name;
                    Intrinsics.checkNotNullExpressionValue((Object)name, "node.name");
                    final String substring2 = name.substring(1);
                    Intrinsics.checkNotNullExpressionValue((Object)substring2, "(this as java.lang.String).substring(startIndex)");
                    if (new Regex("local\\d+").matches((CharSequence)substring2)) {
                        instructions.remove(prev);
                    }
                }
                instructions.remove(node);
            }
        }
    }
    
    private final void modifyRead(final FieldInsnNode readNode, final InsnList instructions, final FieldInsnNode writeNode) {
        if (Intrinsics.areEqual((Object)readNode.owner, (Object)"kotlin/jvm/internal/Ref$ObjectRef")) {
            final AbstractInsnNode cast = readNode.getNext();
            if (cast instanceof TypeInsnNode && ((TypeInsnNode)cast).getOpcode() == 192) {
                final AbstractInsnNode previous = readNode.getPrevious();
                if (previous == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.objectweb.asm.tree.FieldInsnNode");
                }
                ((FieldInsnNode)previous).desc = ((TypeInsnNode)cast).desc;
                instructions.remove(cast);
            }
        }
        instructions.remove((AbstractInsnNode)readNode);
    }
    
    private final String getDescriptorForRefType(final String refType) {
        switch (refType) {
            case "IntRef": {
                return "I";
            }
            case "LongRef": {
                return "L";
            }
            case "DoubleRef": {
                return "D";
            }
            case "ShortRef": {
                return "S";
            }
            case "CharRef": {
                return "C";
            }
            case "BooleanRef": {
                return "Z";
            }
            case "ObjectRef": {
                return "Ljava/lang/Object;";
            }
            case "ByteRef": {
                return "B";
            }
            case "FloatRef": {
                return "F";
            }
            default:
                break;
        }
        return null;
    }
    
    private final FieldInsnNode locateRefWrite(final FieldInsnNode node, final InsnList instructions, final String refType) {
        final Analyzer analyzer = new Analyzer(instructions, this.codeBlockMethodNode);
        AbstractInsnNode currentNode = (AbstractInsnNode)node;
        while (currentNode.getNext() != null) {
            final AbstractInsnNode next = currentNode.getNext();
            Intrinsics.checkNotNullExpressionValue((Object)next, "currentNode.next");
            currentNode = next;
            if (currentNode instanceof FieldInsnNode && ((FieldInsnNode)currentNode).getOpcode() == 181 && Intrinsics.areEqual((Object)((FieldInsnNode)currentNode).owner, (Object)refType)) {
                final Deque analyzed = analyzer.analyze((AbstractInsnNode)node, currentNode);
                if (analyzed.size() == 1) {
                    final String descriptor = analyzed.getFirst().getDescriptor();
                    final int beginIndex = 24;
                    if (refType == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    final String substring = refType.substring(beginIndex);
                    Intrinsics.checkNotNullExpressionValue((Object)substring, "(this as java.lang.String).substring(startIndex)");
                    if (Intrinsics.areEqual((Object)descriptor, (Object)this.getDescriptorForRefType(substring))) {
                        return (FieldInsnNode)currentNode;
                    }
                }
                if (analyzed.size() != 2) {
                    continue;
                }
                final String descriptor2 = analyzed.getLast().getDescriptor();
                Intrinsics.checkNotNullExpressionValue((Object)descriptor2, "analyzed.last.descriptor");
                if (StringsKt.contains$default((CharSequence)descriptor2, (CharSequence)refType, false, 2, (Object)null)) {
                    if (Intrinsics.areEqual((Object)refType, (Object)"kotlin/jvm/internal/Ref$ObjectRef")) {
                        node.desc = analyzed.getFirst().getDescriptor();
                    }
                    return (FieldInsnNode)currentNode;
                }
                continue;
            }
        }
        return null;
    }
    
    private final void copyReadWrite(final FieldInsnNode to, final FieldInsnNode from) {
        to.owner = from.owner;
        to.name = from.name;
        to.desc = from.desc;
    }
}
