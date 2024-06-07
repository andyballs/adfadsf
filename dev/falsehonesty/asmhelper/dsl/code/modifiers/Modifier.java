//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import org.objectweb.asm.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¨\u0006\u0013" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "", "()V", "getAnalyzedFrame", "Lorg/objectweb/asm/tree/analysis/Frame;", "Lorg/objectweb/asm/tree/analysis/BasicValue;", "node", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "methodNode", "Lorg/objectweb/asm/tree/MethodNode;", "className", "", "modify", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "wrappedTypeToPrimitive", "Lorg/objectweb/asm/Type;", "type", "AsmHelper1.8.9" })
public abstract class Modifier
{
    public abstract void modify(@NotNull final InsnList p0);
    
    @NotNull
    protected final Type wrappedTypeToPrimitive(@NotNull final Type type) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        final String descriptor = type.getDescriptor();
        if (descriptor != null) {
            switch (descriptor) {
                case "Ljava/lang/Integer;": {
                    final Type int_TYPE = Type.INT_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)int_TYPE, "INT_TYPE");
                    return int_TYPE;
                }
                case "Ljava/lang/Boolean;": {
                    final Type boolean_TYPE = Type.BOOLEAN_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)boolean_TYPE, "BOOLEAN_TYPE");
                    return boolean_TYPE;
                }
                case "Ljava/lang/Short;": {
                    final Type short_TYPE = Type.SHORT_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)short_TYPE, "SHORT_TYPE");
                    return short_TYPE;
                }
                case "Ljava/lang/Double;": {
                    final Type double_TYPE = Type.DOUBLE_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)double_TYPE, "DOUBLE_TYPE");
                    return double_TYPE;
                }
                case "Ljava/lang/Long;": {
                    final Type long_TYPE = Type.LONG_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)long_TYPE, "LONG_TYPE");
                    return long_TYPE;
                }
                case "Ljava/lang/Character;": {
                    final Type char_TYPE = Type.CHAR_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)char_TYPE, "CHAR_TYPE");
                    return char_TYPE;
                }
                case "Ljava/lang/Byte;": {
                    final Type byte_TYPE = Type.BYTE_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)byte_TYPE, "BYTE_TYPE");
                    return byte_TYPE;
                }
                case "Ljava/lang/Float;": {
                    final Type float_TYPE = Type.FLOAT_TYPE;
                    Intrinsics.checkNotNullExpressionValue((Object)float_TYPE, "FLOAT_TYPE");
                    return float_TYPE;
                }
                default:
                    break;
            }
        }
        return type;
    }
    
    @NotNull
    protected final Frame<BasicValue> getAnalyzedFrame(@NotNull final AbstractInsnNode node, @NotNull final MethodNode methodNode, @NotNull final String className) {
        Intrinsics.checkNotNullParameter((Object)node, "node");
        Intrinsics.checkNotNullParameter((Object)methodNode, "methodNode");
        Intrinsics.checkNotNullParameter((Object)className, "className");
        final Analyzer analyzer = new Analyzer((Interpreter)new BasicInterpreter());
        analyzer.analyze(className, methodNode);
        int i = -1;
        final Frame[] frames = analyzer.getFrames();
        Intrinsics.checkNotNullExpressionValue((Object)frames, "analyzer.frames");
        final Frame[] array = frames;
        int j = 0;
        while (j < array.length) {
            final Frame frame = array[j];
            ++j;
            ++i;
            if (methodNode.instructions.get(i) == node) {
                Intrinsics.checkNotNullExpressionValue((Object)frame, "frame");
                return (Frame<BasicValue>)frame;
            }
        }
        throw new IllegalArgumentException("Node " + node + " not found in analyzed method " + className + '.' + (Object)methodNode.name + '.');
    }
}
