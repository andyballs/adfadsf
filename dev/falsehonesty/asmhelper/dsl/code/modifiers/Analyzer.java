//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.*;
import java.util.*;
import dev.falsehonesty.asmhelper.printing.*;
import kotlin.text.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Analyzer;", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "methodNode", "Lorg/objectweb/asm/tree/MethodNode;", "(Lorg/objectweb/asm/tree/InsnList;Lorg/objectweb/asm/tree/MethodNode;)V", "getInstructions", "()Lorg/objectweb/asm/tree/InsnList;", "getMethodNode", "()Lorg/objectweb/asm/tree/MethodNode;", "analyze", "Ljava/util/Deque;", "Lorg/objectweb/asm/Type;", "startInsn", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "endInsn", "AsmHelper1.8.9" })
public final class Analyzer
{
    @NotNull
    private final InsnList instructions;
    @NotNull
    private final MethodNode methodNode;
    
    public Analyzer(@NotNull final InsnList instructions, @NotNull final MethodNode methodNode) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        Intrinsics.checkNotNullParameter((Object)methodNode, "methodNode");
        this.instructions = instructions;
        this.methodNode = methodNode;
    }
    
    @NotNull
    public final InsnList getInstructions() {
        return this.instructions;
    }
    
    @NotNull
    public final MethodNode getMethodNode() {
        return this.methodNode;
    }
    
    @NotNull
    public final Deque<Type> analyze(@NotNull final AbstractInsnNode startInsn, @NotNull final AbstractInsnNode endInsn) {
        Intrinsics.checkNotNullParameter((Object)startInsn, "startInsn");
        Intrinsics.checkNotNullParameter((Object)endInsn, "endInsn");
        final ArrayDeque stack = new ArrayDeque();
        AbstractInsnNode next;
        for (AbstractInsnNode node = startInsn; !Intrinsics.areEqual((Object)node, (Object)endInsn); node = next) {
            PrintingKt.verbose(Intrinsics.stringPlus("Analyzing ", (Object)PrettyprintingKt.prettyString(node)));
            final AbstractInsnNode abstractInsnNode = node;
            if (abstractInsnNode instanceof MethodInsnNode) {
                for (int length = Type.getArgumentTypes(((MethodInsnNode)node).desc).length, i = 0; i < length; ++i) {
                    final int it = i;
                    final int n = 0;
                    PrintingKt.verbose("Popping " + stack.poll() + " off the stack because it is an argument");
                }
                if (((MethodInsnNode)node).getOpcode() != 184) {
                    PrintingKt.verbose(Intrinsics.stringPlus("Popping receiver ", stack.poll()));
                }
                final Type returnType = Type.getReturnType(((MethodInsnNode)node).desc);
                if (!Intrinsics.areEqual((Object)returnType, (Object)Type.VOID_TYPE)) {
                    stack.push(returnType);
                }
                PrintingKt.verbose(Intrinsics.stringPlus("Pushed return type ", (Object)returnType));
            }
            else if (abstractInsnNode instanceof VarInsnNode) {
                if (((VarInsnNode)node).getOpcode() <= 53) {
                    stack.push(Type.getObjectType(this.methodNode.localVariables.get(((VarInsnNode)node).var).desc));
                }
                else {
                    stack.pop();
                }
            }
            else if (abstractInsnNode instanceof FieldInsnNode) {
                switch (((FieldInsnNode)node).getOpcode()) {
                    case 178: {
                        stack.push(Type.getType(((FieldInsnNode)node).desc));
                        break;
                    }
                    case 179: {
                        stack.pop();
                        break;
                    }
                    case 180: {
                        stack.poll();
                        stack.push(Type.getType(((FieldInsnNode)node).desc));
                        break;
                    }
                    case 181: {
                        stack.poll();
                        stack.pop();
                        break;
                    }
                }
            }
            else if (abstractInsnNode instanceof IntInsnNode) {
                stack.push(Type.INT_TYPE);
            }
            else if (abstractInsnNode instanceof LdcInsnNode) {
                final Object cst = ((LdcInsnNode)node).cst;
                if (cst instanceof String) {
                    final ArrayDeque arrayDeque = stack;
                    final String name = String.class.getName();
                    Intrinsics.checkNotNullExpressionValue((Object)name, "String::class.java.name");
                    arrayDeque.push(Type.getObjectType(StringsKt.replace$default(name, ".", "/", false, 4, (Object)null)));
                }
                else if (cst instanceof Integer) {
                    stack.push(Type.INT_TYPE);
                }
                else if (cst instanceof Long) {
                    stack.push(Type.LONG_TYPE);
                }
                else if (cst instanceof Double) {
                    stack.push(Type.DOUBLE_TYPE);
                }
                else if (cst instanceof Float) {
                    stack.push(Type.FLOAT_TYPE);
                }
                else if (cst instanceof Type) {
                    final ArrayDeque arrayDeque2 = stack;
                    final Object cst2 = ((LdcInsnNode)node).cst;
                    if (cst2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.objectweb.asm.Type");
                    }
                    arrayDeque2.push(cst2);
                }
            }
            else if (abstractInsnNode instanceof InsnNode) {
                final int opcode = ((InsnNode)node).getOpcode();
                if (2 <= opcode && opcode <= 8) {
                    stack.push(Type.INT_TYPE);
                }
                else if (9 <= opcode && opcode <= 10) {
                    stack.push(Type.LONG_TYPE);
                }
                else if (11 <= opcode && opcode <= 13) {
                    stack.push(Type.FLOAT_TYPE);
                }
                else if (14 <= opcode && opcode <= 15) {
                    stack.push(Type.DOUBLE_TYPE);
                }
                else if (96 <= opcode && opcode <= 115) {
                    stack.pop();
                }
                else if (opcode == 89) {
                    stack.push(stack.peek());
                }
            }
            else if (abstractInsnNode instanceof TypeInsnNode) {
                switch (((TypeInsnNode)node).getOpcode()) {
                    case 187: {
                        stack.push(Type.getObjectType(((TypeInsnNode)node).desc));
                        break;
                    }
                    case 192: {
                        stack.pop();
                        stack.push(Type.getObjectType(((TypeInsnNode)node).desc));
                        break;
                    }
                }
            }
            PrintingKt.verbose(Intrinsics.stringPlus("Stack after analyzation frame looks like ", (Object)stack));
            next = node.getNext();
            Intrinsics.checkNotNullExpressionValue((Object)next, "node.next");
        }
        return (Deque<Type>)stack;
    }
}
