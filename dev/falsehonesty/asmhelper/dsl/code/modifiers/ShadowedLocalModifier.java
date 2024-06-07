//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code.modifiers;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.printing.*;
import kotlin.text.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedLocalModifier;", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/ShadowedModifier;", "codeBlockClass", "", "(Ljava/lang/String;)V", "modifyFieldNode", "", "instructions", "Lorg/objectweb/asm/tree/InsnList;", "node", "Lorg/objectweb/asm/tree/FieldInsnNode;", "shadowedName", "AsmHelper1.8.9" })
public final class ShadowedLocalModifier extends ShadowedModifier
{
    public ShadowedLocalModifier(@NotNull final String codeBlockClass) {
        Intrinsics.checkNotNullParameter((Object)codeBlockClass, "codeBlockClass");
        super(codeBlockClass);
    }
    
    @Override
    public void modifyFieldNode(@NotNull final InsnList instructions, @NotNull final FieldInsnNode node, @NotNull final String shadowedName) {
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        Intrinsics.checkNotNullParameter((Object)node, "node");
        Intrinsics.checkNotNullParameter((Object)shadowedName, "shadowedName");
        if (new Regex("local\\d+").matches((CharSequence)shadowedName)) {
            final String substring = shadowedName.substring("local".length());
            Intrinsics.checkNotNullExpressionValue((Object)substring, "(this as java.lang.String).substring(startIndex)");
            final int localNumber = Integer.parseInt(substring);
            PrintingKt.verbose(Intrinsics.stringPlus("Found shadowed local referencing local ", (Object)localNumber));
            final AbstractInsnNode prev = node.getPrevious();
            if (!(prev instanceof VarInsnNode)) {
                return;
            }
            if (node.getOpcode() == 180) {
                final String desc = node.desc;
                int n = 0;
                Label_0366: {
                    if (desc != null) {
                        switch (desc) {
                            case "B": {
                                n = 21;
                                break Label_0366;
                            }
                            case "S": {
                                n = 21;
                                break Label_0366;
                            }
                            case "C": {
                                n = 21;
                                break Label_0366;
                            }
                            case "D": {
                                n = 24;
                                break Label_0366;
                            }
                            case "F": {
                                n = 23;
                                break Label_0366;
                            }
                            case "I": {
                                n = 21;
                                break Label_0366;
                            }
                            case "Z": {
                                n = 21;
                                break Label_0366;
                            }
                            case "L": {
                                n = 22;
                                break Label_0366;
                            }
                            default:
                                break;
                        }
                    }
                    n = 25;
                }
                final int opcode = n;
                final String prettyString = PrettyprintingKt.prettyString(prev);
                if (prettyString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                final String prevString = StringsKt.trim((CharSequence)prettyString).toString();
                ((VarInsnNode)prev).var = localNumber;
                ((VarInsnNode)prev).setOpcode(opcode);
                final AbstractInsnNode previous = ((VarInsnNode)prev).getPrevious();
                Intrinsics.checkNotNullExpressionValue((Object)previous, "prev.previous");
                PrintingKt.verbose(PrettyprintingKt.prettyString(previous));
                final StringBuilder append = new StringBuilder().append(prevString).append(" --> ");
                final String prettyString2 = PrettyprintingKt.prettyString(prev);
                if (prettyString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                PrintingKt.verbose(append.append(StringsKt.trim((CharSequence)prettyString2).toString()).toString());
                PrintingKt.verbose(Intrinsics.stringPlus("- ", (Object)PrettyprintingKt.prettyString((AbstractInsnNode)node)));
                instructions.remove((AbstractInsnNode)node);
            }
            else if (node.getOpcode() == 181) {
                final String desc2 = node.desc;
                int n2 = 0;
                Label_0782: {
                    if (desc2 != null) {
                        switch (desc2) {
                            case "B": {
                                n2 = 54;
                                break Label_0782;
                            }
                            case "S": {
                                n2 = 54;
                                break Label_0782;
                            }
                            case "C": {
                                n2 = 54;
                                break Label_0782;
                            }
                            case "D": {
                                n2 = 57;
                                break Label_0782;
                            }
                            case "F": {
                                n2 = 56;
                                break Label_0782;
                            }
                            case "I": {
                                n2 = 54;
                                break Label_0782;
                            }
                            case "Z": {
                                n2 = 54;
                                break Label_0782;
                            }
                            case "L": {
                                n2 = 55;
                                break Label_0782;
                            }
                            default:
                                break;
                        }
                    }
                    n2 = 58;
                }
                final int opcode = n2;
                instructions.insert((AbstractInsnNode)node, (AbstractInsnNode)new VarInsnNode(opcode, localNumber));
                instructions.remove((AbstractInsnNode)node);
            }
        }
    }
}
