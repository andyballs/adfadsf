//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.code;

import kotlin.*;
import java.util.*;
import org.jetbrains.annotations.*;
import org.objectweb.asm.tree.*;
import kotlin.jvm.internal.*;
import dev.falsehonesty.asmhelper.dsl.code.modifiers.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/code/InjectCodeBuilder;", "Ldev/falsehonesty/asmhelper/dsl/code/CodeBuilder;", "codeClassNode", "Lorg/objectweb/asm/tree/ClassNode;", "targetClassNode", "targetMethodNode", "Lorg/objectweb/asm/tree/MethodNode;", "(Lorg/objectweb/asm/tree/ClassNode;Lorg/objectweb/asm/tree/ClassNode;Lorg/objectweb/asm/tree/MethodNode;)V", "modifiers", "", "Ldev/falsehonesty/asmhelper/dsl/code/modifiers/Modifier;", "getModifiers", "()Ljava/util/List;", "AsmHelper1.8.9" })
public final class InjectCodeBuilder extends CodeBuilder
{
    @NotNull
    private final List<Modifier> modifiers;
    
    public InjectCodeBuilder(@NotNull final ClassNode codeClassNode, @NotNull final ClassNode targetClassNode, @NotNull final MethodNode targetMethodNode) {
        Intrinsics.checkNotNullParameter((Object)codeClassNode, "codeClassNode");
        Intrinsics.checkNotNullParameter((Object)targetClassNode, "targetClassNode");
        Intrinsics.checkNotNullParameter((Object)targetMethodNode, "targetMethodNode");
        super(codeClassNode);
        final Modifier[] array = new Modifier[8];
        array[0] = new RemoveReturnModifier();
        array[1] = new CodeBlockShortcutModifier();
        final Modifier[] array2 = array;
        final int n = 2;
        final MethodNode methodNode = this.getMethodNode();
        final String name = codeClassNode.name;
        Intrinsics.checkNotNullExpressionValue((Object)name, "codeClassNode.name");
        array2[n] = new MutableRefModifier(methodNode, name);
        array[3] = new LocalVarModifier(targetMethodNode);
        array[4] = new AsmBlockModifier(targetMethodNode);
        final Modifier[] array3 = array;
        final int n2 = 5;
        final String name2 = codeClassNode.name;
        Intrinsics.checkNotNullExpressionValue((Object)name2, "codeClassNode.name");
        array3[n2] = new ShadowedMethodModifier(name2, targetClassNode, this.getMethodNode());
        final Modifier[] array4 = array;
        final int n3 = 6;
        final String name3 = codeClassNode.name;
        Intrinsics.checkNotNullExpressionValue((Object)name3, "codeClassNode.name");
        array4[n3] = new ShadowedLocalModifier(name3);
        final Modifier[] array5 = array;
        final int n4 = 7;
        final String name4 = codeClassNode.name;
        Intrinsics.checkNotNullExpressionValue((Object)name4, "codeClassNode.name");
        array5[n4] = new ShadowedFieldModifier(name4, targetClassNode);
        this.modifiers = (List<Modifier>)CollectionsKt.listOf((Object[])array);
    }
    
    @NotNull
    public List<Modifier> getModifiers() {
        return this.modifiers;
    }
}
