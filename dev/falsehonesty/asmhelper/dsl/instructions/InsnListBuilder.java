//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.instructions;

import kotlin.jvm.internal.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import kotlin.jvm.*;
import dev.falsehonesty.asmhelper.*;
import org.objectweb.asm.*;
import java.util.*;
import org.objectweb.asm.tree.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b(\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0000J/\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J\u0006\u0010!\u001a\u00020\u0000J\u0006\u0010\"\u001a\u00020#J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u0017\u0010)\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\u0000J\u0006\u0010.\u001a\u00020\u0000J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0018J\u0017\u00101\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J3\u00102\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00182\u0019\b\u0002\u00104\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b H\u0007J\u0006\u00105\u001a\u00020\u0000J\u0006\u00106\u001a\u00020\u0000J\u0006\u00107\u001a\u00020\u0000J\u0006\u00108\u001a\u00020\u0000J\u0006\u00109\u001a\u00020\u0000J\u0006\u0010:\u001a\u00020\u0000J\u0006\u0010;\u001a\u00020\u0000J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0017\u0010C\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020\u0000J\u0006\u0010H\u001a\u00020\u0000J\u0006\u0010I\u001a\u00020#J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010J\u001a\u00020\u0000J\u0006\u0010K\u001a\u00020\u0000J\u0006\u0010L\u001a\u00020\u0000J\u0006\u0010M\u001a\u00020\u0000J\u0006\u0010N\u001a\u00020\u0000J\u0006\u0010O\u001a\u00020\u0000J\u0006\u0010P\u001a\u00020\u0000J\u0006\u0010Q\u001a\u00020\u0000J\u0006\u0010R\u001a\u00020\u0000J\u0006\u0010S\u001a\u00020\u0000J\u0006\u0010T\u001a\u00020\u0000J\u0006\u0010U\u001a\u00020\u0000J\u0006\u0010V\u001a\u00020\u0000J\u0006\u0010W\u001a\u00020\u0000J\u0006\u0010X\u001a\u00020\u0000J\u0006\u0010Y\u001a\u00020\u0000J\u0006\u0010Z\u001a\u00020\u0000J\u0006\u0010[\u001a\u00020\u0000J\u0006\u0010\\\u001a\u00020\u0000J\u0016\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aJ&\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J\u0013\u0010e\u001a\u00070f¢\u0006\u0002\bg2\u0006\u0010h\u001a\u00020\u0006J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010j\u001a\u00020\u00002\u0006\u0010E\u001a\u00020kJ\u0006\u0010l\u001a\u00020\u0000J\u0006\u0010m\u001a\u00020\u0000J\u0017\u0010n\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J\u0006\u0010o\u001a\u00020\u0000J\u0006\u0010p\u001a\u00020\u0000J\u0006\u0010q\u001a\u00020#J\u000e\u0010q\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010r\u001a\u00020\u0000J\u001e\u0010s\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J\u000e\u0010t\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0018J\u000e\u0010v\u001a\u00020\u00002\u0006\u0010`\u001a\u00020aJ\u001e\u0010v\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J\u001e\u0010w\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J&\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J\u0006\u0010{\u001a\u00020\u0000J\u0006\u0010|\u001a\u00020\u0000J\u0006\u0010}\u001a\u00020\u0000J\u0006\u0010~\u001a\u00020\u0000J\u0006\u0010\u007f\u001a\u00020\u0000J\u0007\u0010\u0080\u0001\u001a\u00020\u0000J\u0007\u0010\u0081\u0001\u001a\u00020\u0000J\u0007\u0010\u0082\u0001\u001a\u00020\u0000J\u0007\u0010\u0083\u0001\u001a\u00020\u0000J\u0007\u0010\u0084\u0001\u001a\u00020\u0000J\u0007\u0010\u0085\u0001\u001a\u00020\u0000J\u0007\u0010\u0086\u0001\u001a\u00020\u0000J\u0007\u0010\u0087\u0001\u001a\u00020\u0000J\u0007\u0010\u0088\u0001\u001a\u00020\u0000J\u0007\u0010\u0089\u0001\u001a\u00020\u0000J\u0007\u0010\u008a\u0001\u001a\u00020\u0000J\u0007\u0010\u008b\u0001\u001a\u00020\u0000J\u0007\u0010\u008c\u0001\u001a\u00020\u0000J>\u0010\u008d\u0001\u001a\u00020\u00002\u0016\u0010\u008e\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0090\u00010\u008f\u0001\"\u00030\u0090\u00012\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b ¢\u0006\u0003\u0010\u0091\u0001J@\u0010\u0092\u0001\u001a\u00020\u00002\u0016\u0010\u008e\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0090\u00010\u008f\u0001\"\u00030\u0090\u00012\u0019\u0010\u0093\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0094\u0001\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b ¢\u0006\u0003\u0010\u0091\u0001J\u0007\u0010\u0095\u0001\u001a\u00020\u0000J\u000f\u0010\u0096\u0001\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u0007\u0010\u0097\u0001\u001a\u00020\u0000J\u0007\u0010\u0098\u0001\u001a\u00020\u0000J\u0018\u0010\u0099\u0001\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J\u0010\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\fJ\u0019\u0010\u009c\u0001\u001a\u00020\u00002\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0000¢\u0006\u0003\b\u009f\u0001J\u0010\u0010 \u0001\u001a\u00020\u00002\u0007\u0010¡\u0001\u001a\u00020\u0018J\u000f\u0010¢\u0001\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0006J8\u0010£\u0001\u001a\u00020\u00002\u0007\u00100\u001a\u00030¤\u00012\u0006\u0010`\u001a\u00020a2\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007JH\u0010£\u0001\u001a\u00020\u00002\u0007\u00100\u001a\u00030¤\u00012\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007Jf\u0010¦\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u0007\u0010§\u0001\u001a\u00020y2\u0016\u0010¨\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030©\u00010\u008f\u0001\"\u00030©\u00012\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007¢\u0006\u0003\u0010ª\u0001J?\u0010«\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007JA\u0010¬\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u00182\u0007\u0010\u00ad\u0001\u001a\u00020\u00182\u0007\u0010®\u0001\u001a\u00020\u00182\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007J?\u0010¯\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007J?\u0010°\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007J?\u0010±\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u001c\b\u0002\u0010¥\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\u0002\b H\u0007J\u0007\u0010²\u0001\u001a\u00020\u0000J\u0007\u0010³\u0001\u001a\u00020\u0000J\u0007\u0010´\u0001\u001a\u00020\u0000J\u0007\u0010µ\u0001\u001a\u00020\u0000J\u0007\u0010¶\u0001\u001a\u00020\u0000J\u0007\u0010·\u0001\u001a\u00020#J\u000f\u0010·\u0001\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u0007\u0010¸\u0001\u001a\u00020\u0000J\u0007\u0010¹\u0001\u001a\u00020\u0000J\u0007\u0010º\u0001\u001a\u00020\u0000J\u001a\u0010»\u0001\u001a\u00020\u00002\b\u0010¼\u0001\u001a\u00030\u0090\u00012\u0007\u0010½\u0001\u001a\u00020fJ\u0007\u0010¾\u0001\u001a\u00020\u0000J\u0007\u0010¿\u0001\u001a\u00020\u0000J\u0007\u0010\u00c0\u0001\u001a\u00020\u0000J\u0007\u0010\u00c1\u0001\u001a\u00020\u0000J\u0007\u0010\u00c2\u0001\u001a\u00020\u0000J\u0007\u0010\u00c3\u0001\u001a\u00020\u0000J\u0007\u0010\u00c4\u0001\u001a\u00020\u0000J\u0007\u0010\u00c5\u0001\u001a\u00020\u0000J\u0007\u0010\u00c6\u0001\u001a\u00020\u0000J\u0007\u0010\u00c7\u0001\u001a\u00020\u0000J\u0011\u0010\u00c8\u0001\u001a\u00020\u00002\b\u0010\u00c9\u0001\u001a\u00030©\u0001J\u0007\u0010\u00ca\u0001\u001a\u00020\u0000J\u000f\u0010\u00cb\u0001\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u0007\u0010\u00cc\u0001\u001a\u00020\u0000J\u0007\u0010\u00cd\u0001\u001a\u00020\u0000J\u0018\u0010\u00ce\u0001\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J\u0010\u0010\u00cf\u0001\u001a\u00020\u00002\u0007\u0010\u00d0\u0001\u001a\u00020#J\u0010\u0010\u00d1\u0001\u001a\u00020\u00002\u0007\u0010E\u001a\u00030\u00d2\u0001J\"\u0010\u00d3\u0001\u001a\u00020\u001f2\u0019\u0010\u0093\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00d4\u0001\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J\u0007\u0010\u00d5\u0001\u001a\u00020\u0000J\u0007\u0010\u00d6\u0001\u001a\u00020\u0000J\u0007\u0010\u00d7\u0001\u001a\u00020\u0000J\u0007\u0010\u00d8\u0001\u001a\u00020\u0000J\u0007\u0010\u00d9\u0001\u001a\u00020\u0000J\u0007\u0010\u00da\u0001\u001a\u00020#J\u000f\u0010\u00da\u0001\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u0007\u0010\u00db\u0001\u001a\u00020\u0000J\u0007\u0010\u00dc\u0001\u001a\u00020\u0000J\u0007\u0010\u00dd\u0001\u001a\u00020\u0000J\u0007\u0010\u00de\u0001\u001a\u00020fJ\u0007\u0010\u00df\u0001\u001a\u00020\u0000J\u0007\u0010\u00e0\u0001\u001a\u00020\u0000J\u0007\u0010\u00e1\u0001\u001a\u00020\u0000J\u0018\u0010\u00e2\u0001\u001a\u00020\u00002\u0006\u0010`\u001a\u00020\u00182\u0007\u0010\u00e3\u0001\u001a\u00020\u0006J\u000f\u0010\u00e4\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J!\u0010\u00e5\u0001\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u00e6\u0001J\u0007\u0010\u00e7\u0001\u001a\u00020\u0000J\u0010\u0010\u00e8\u0001\u001a\u00020\u00002\u0007\u0010½\u0001\u001a\u00020fJ\u0007\u0010\u00e9\u0001\u001a\u00020\u0000J\u0007\u0010\u00ea\u0001\u001a\u00020\u0000J\u001f\u0010\u00eb\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J\u001f\u0010\u00ec\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u0018J\u0007\u0010\u00ed\u0001\u001a\u00020\u0000J\u0007\u0010\u00ee\u0001\u001a\u00020\u0000J)\u0010\u00ef\u0001\u001a\u00020\u00002\u0006\u0010`\u001a\u00020a2\u0018\u0010\u00f0\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J9\u0010\u00ef\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u0018\u0010\u00f0\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J\u000f\u0010\u00f1\u0001\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u0018\u0010\u00f2\u0001\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+J\u0007\u0010\u00f3\u0001\u001a\u00020\u0000J \u0010\u00f4\u0001\u001a\u00020\u00002\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J\"\u0010\u00f5\u0001\u001a\u00020\u001f2\u0019\u0010\u0093\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00d4\u0001\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J)\u0010\u00f6\u0001\u001a\u00020\u00002\u0006\u0010`\u001a\u00020a2\u0018\u0010\u00f7\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J9\u0010\u00f6\u0001\u001a\u00020\u00002\u0006\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u00182\u0018\u0010\u00f7\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b J\u0018\u0010\u00f8\u0001\u001a\u00020\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010+R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u00f9\u0001" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "Lorg/objectweb/asm/Opcodes;", "toInjectInto", "Lorg/objectweb/asm/tree/MethodNode;", "(Lorg/objectweb/asm/tree/MethodNode;)V", "currentLocalIndex", "", "getCurrentLocalIndex", "()I", "setCurrentLocalIndex", "(I)V", "insnList", "Lorg/objectweb/asm/tree/InsnList;", "getInsnList", "()Lorg/objectweb/asm/tree/InsnList;", "getToInjectInto", "()Lorg/objectweb/asm/tree/MethodNode;", "aaload", "aastore", "aconst_null", "aload", "index", "anewarray", "className", "", "areturn", "array", "size", "code", "Lkotlin/Function1;", "Ldev/falsehonesty/asmhelper/dsl/instructions/ArrayBuilder;", "", "Lkotlin/ExtensionFunctionType;", "arraylength", "astore", "Ldev/falsehonesty/asmhelper/dsl/instructions/Local;", "athrow", "baload", "bastore", "bipush", "value", "bnewarray", "length", "(Ljava/lang/Integer;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "build", "caload", "castore", "checkcast", "type", "cnewarray", "createInstance", "constructorDescription", "parameters", "d2f", "d2i", "d2l", "dadd", "daload", "dastore", "dcmpg", "dcmpl", "dconst_0", "dconst_1", "ddiv", "dload", "dmul", "dneg", "dnewarray", "double", "number", "", "drem", "dreturn", "dstore", "dsub", "dup", "dup2", "dup2_x1", "dup2_x2", "dup_x1", "dup_x2", "f2d", "f2i", "f2l", "fadd", "faload", "fastore", "fcmpg", "fcmpl", "fconst_0", "fconst_1", "fconst_2", "fdiv", "field", "action", "Ldev/falsehonesty/asmhelper/dsl/instructions/FieldAction;", "descriptor", "Ldev/falsehonesty/asmhelper/dsl/instructions/Descriptor;", "owner", "name", "desc", "findLabel", "Lorg/objectweb/asm/tree/LabelNode;", "Lkotlin/internal/NoInfer;", "n", "fload", "float", "", "fmul", "fneg", "fnewarray", "frem", "freturn", "fstore", "fsub", "getField", "getKObjectInstance", "objectClassName", "getLocalField", "getStatic", "handle", "Lorg/objectweb/asm/Handle;", "tag", "i2b", "i2c", "i2d", "i2f", "i2l", "i2s", "iadd", "iaload", "iand", "iastore", "iconst_0", "iconst_1", "iconst_2", "iconst_3", "iconst_4", "iconst_5", "iconst_m1", "idiv", "ifClause", "conditions", "", "Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;", "([Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;Lkotlin/jvm/functions/Function1;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "ifElseClause", "builder", "Ldev/falsehonesty/asmhelper/dsl/instructions/IfElseBuilder;", "iinc", "iload", "imul", "ineg", "inewarray", "insertInsns", "list", "insn", "node", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "insn$AsmHelper1_8_9", "instanceof", "clazzName", "int", "invoke", "Ldev/falsehonesty/asmhelper/dsl/instructions/InvokeType;", "arguments", "invokeDynamic", "bootstrapMethod", "bootstrapConstantArgs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/objectweb/asm/Handle;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "invokeInterface", "invokeKObjectFunction", "methodName", "methodDesc", "invokeSpecial", "invokeStatic", "invokeVirtual", "ior", "irem", "ireturn", "ishl", "ishr", "istore", "isub", "iushr", "ixor", "jump", "condition", "label", "l2d", "l2f", "l2i", "ladd", "laload", "land", "lastore", "lcmp", "lconst_0", "lconst_1", "ldc", "constant", "ldiv", "lload", "lmul", "lneg", "lnewarray", "load", "local", "long", "", "lookupswitch", "Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder;", "lor", "lrem", "lreturn", "lshl", "lshr", "lstore", "lsub", "lushr", "lxor", "makeLabel", "methodReturn", "monitorenter", "monitorexit", "multianewarray", "dimensions", "new", "newarray", "(ILjava/lang/Integer;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;", "nop", "placeLabel", "pop", "pop2", "putField", "putStatic", "saload", "sastore", "setLocalField", "newValue", "sipush", "snewarray", "swap", "synchronized", "tableswitch", "updateLocalField", "updater", "znewarray", "AsmHelper1.8.9" })
public class InsnListBuilder implements Opcodes
{
    @NotNull
    private final MethodNode toInjectInto;
    @NotNull
    private final InsnList insnList;
    private int currentLocalIndex;
    
    public InsnListBuilder(@NotNull final MethodNode toInjectInto) {
        Intrinsics.checkNotNullParameter((Object)toInjectInto, "toInjectInto");
        this.toInjectInto = toInjectInto;
        this.insnList = new InsnList();
        this.currentLocalIndex = this.toInjectInto.maxLocals;
    }
    
    @NotNull
    public final MethodNode getToInjectInto() {
        return this.toInjectInto;
    }
    
    @NotNull
    public final InsnList getInsnList() {
        return this.insnList;
    }
    
    public final int getCurrentLocalIndex() {
        return this.currentLocalIndex;
    }
    
    public final void setCurrentLocalIndex(final int <set-?>) {
        this.currentLocalIndex = <set-?>;
    }
    
    @NotNull
    public final InsnListBuilder aaload() {
        final InsnListBuilder $this$aaload_u24lambda_u2d0 = this;
        final int n = 0;
        $this$aaload_u24lambda_u2d0.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(50));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder aastore() {
        final InsnListBuilder $this$aastore_u24lambda_u2d1 = this;
        final int n = 0;
        $this$aastore_u24lambda_u2d1.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(83));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder aconst_null() {
        final InsnListBuilder $this$aconst_null_u24lambda_u2d2 = this;
        final int n = 0;
        $this$aconst_null_u24lambda_u2d2.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(1));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder aload(final int index) {
        final InsnListBuilder $this$aload_u24lambda_u2d3 = this;
        final int n = 0;
        $this$aload_u24lambda_u2d3.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(25, index));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder anewarray(@NotNull final String className) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        final InsnListBuilder $this$anewarray_u24lambda_u2d4 = this;
        final int n = 0;
        $this$anewarray_u24lambda_u2d4.insn$AsmHelper1_8_9((AbstractInsnNode)new TypeInsnNode(189, className));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder areturn() {
        final InsnListBuilder $this$areturn_u24lambda_u2d5 = this;
        final int n = 0;
        $this$areturn_u24lambda_u2d5.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(176));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder arraylength() {
        final InsnListBuilder $this$arraylength_u24lambda_u2d6 = this;
        final int n = 0;
        $this$arraylength_u24lambda_u2d6.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(190));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder astore(final int index) {
        final InsnListBuilder $this$astore_u24lambda_u2d7 = this;
        final int n = 0;
        $this$astore_u24lambda_u2d7.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(58, index));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder athrow() {
        final InsnListBuilder $this$athrow_u24lambda_u2d8 = this;
        final int n = 0;
        $this$athrow_u24lambda_u2d8.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(191));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder baload() {
        final InsnListBuilder $this$baload_u24lambda_u2d9 = this;
        final int n = 0;
        $this$baload_u24lambda_u2d9.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(51));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder bastore() {
        final InsnListBuilder $this$bastore_u24lambda_u2d10 = this;
        final int n = 0;
        $this$bastore_u24lambda_u2d10.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(51));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder bipush(final int value) {
        final InsnListBuilder $this$bipush_u24lambda_u2d11 = this;
        final int n = 0;
        $this$bipush_u24lambda_u2d11.insn$AsmHelper1_8_9((AbstractInsnNode)new IntInsnNode(16, value));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder bnewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$bnewarray_u24lambda_u2d12 = this;
        final int n = 0;
        $this$bnewarray_u24lambda_u2d12.newarray(8, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder caload() {
        final InsnListBuilder $this$caload_u24lambda_u2d13 = this;
        final int n = 0;
        $this$caload_u24lambda_u2d13.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(52));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder castore() {
        final InsnListBuilder $this$castore_u24lambda_u2d14 = this;
        final int n = 0;
        $this$castore_u24lambda_u2d14.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(52));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder checkcast(@NotNull final String type) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        final InsnListBuilder $this$checkcast_u24lambda_u2d15 = this;
        final int n = 0;
        $this$checkcast_u24lambda_u2d15.insn$AsmHelper1_8_9((AbstractInsnNode)new TypeInsnNode(192, type));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder cnewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$cnewarray_u24lambda_u2d16 = this;
        final int n = 0;
        $this$cnewarray_u24lambda_u2d16.newarray(5, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder d2f() {
        final InsnListBuilder $this$d2f_u24lambda_u2d17 = this;
        final int n = 0;
        $this$d2f_u24lambda_u2d17.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(144));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder d2i() {
        final InsnListBuilder $this$d2i_u24lambda_u2d18 = this;
        final int n = 0;
        $this$d2i_u24lambda_u2d18.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(142));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder d2l() {
        final InsnListBuilder $this$d2l_u24lambda_u2d19 = this;
        final int n = 0;
        $this$d2l_u24lambda_u2d19.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(143));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dadd() {
        final InsnListBuilder $this$dadd_u24lambda_u2d20 = this;
        final int n = 0;
        $this$dadd_u24lambda_u2d20.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(99));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder daload() {
        final InsnListBuilder $this$daload_u24lambda_u2d21 = this;
        final int n = 0;
        $this$daload_u24lambda_u2d21.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(49));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dastore() {
        final InsnListBuilder $this$dastore_u24lambda_u2d22 = this;
        final int n = 0;
        $this$dastore_u24lambda_u2d22.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(49));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dcmpg() {
        final InsnListBuilder $this$dcmpg_u24lambda_u2d23 = this;
        final int n = 0;
        $this$dcmpg_u24lambda_u2d23.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(152));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dcmpl() {
        final InsnListBuilder $this$dcmpl_u24lambda_u2d24 = this;
        final int n = 0;
        $this$dcmpl_u24lambda_u2d24.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(151));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dconst_0() {
        final InsnListBuilder $this$dconst_0_u24lambda_u2d25 = this;
        final int n = 0;
        $this$dconst_0_u24lambda_u2d25.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(14));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dconst_1() {
        final InsnListBuilder $this$dconst_1_u24lambda_u2d26 = this;
        final int n = 0;
        $this$dconst_1_u24lambda_u2d26.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(15));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ddiv() {
        final InsnListBuilder $this$ddiv_u24lambda_u2d27 = this;
        final int n = 0;
        $this$ddiv_u24lambda_u2d27.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(111));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dload(final int index) {
        final InsnListBuilder $this$dload_u24lambda_u2d28 = this;
        final int n = 0;
        $this$dload_u24lambda_u2d28.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(24, index));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dmul() {
        final InsnListBuilder $this$dmul_u24lambda_u2d29 = this;
        final int n = 0;
        $this$dmul_u24lambda_u2d29.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(107));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dneg() {
        final InsnListBuilder $this$dneg_u24lambda_u2d30 = this;
        final int n = 0;
        $this$dneg_u24lambda_u2d30.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(119));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dnewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$dnewarray_u24lambda_u2d31 = this;
        final int n = 0;
        $this$dnewarray_u24lambda_u2d31.newarray(7, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder drem() {
        final InsnListBuilder $this$drem_u24lambda_u2d32 = this;
        final int n = 0;
        $this$drem_u24lambda_u2d32.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(115));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dreturn() {
        final InsnListBuilder $this$dreturn_u24lambda_u2d33 = this;
        final int n = 0;
        $this$dreturn_u24lambda_u2d33.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(175));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dstore(final int index) {
        final InsnListBuilder $this$dstore_u24lambda_u2d34 = this;
        final int n = 0;
        $this$dstore_u24lambda_u2d34.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(57, index));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dsub() {
        final InsnListBuilder $this$dsub_u24lambda_u2d35 = this;
        final int n = 0;
        $this$dsub_u24lambda_u2d35.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(103));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dup() {
        final InsnListBuilder $this$dup_u24lambda_u2d36 = this;
        final int n = 0;
        $this$dup_u24lambda_u2d36.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(89));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dup_x1() {
        final InsnListBuilder $this$dup_x1_u24lambda_u2d37 = this;
        final int n = 0;
        $this$dup_x1_u24lambda_u2d37.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(90));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dup_x2() {
        final InsnListBuilder $this$dup_x2_u24lambda_u2d38 = this;
        final int n = 0;
        $this$dup_x2_u24lambda_u2d38.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(91));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dup2() {
        final InsnListBuilder $this$dup2_u24lambda_u2d39 = this;
        final int n = 0;
        $this$dup2_u24lambda_u2d39.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(92));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dup2_x1() {
        final InsnListBuilder $this$dup2_x1_u24lambda_u2d40 = this;
        final int n = 0;
        $this$dup2_x1_u24lambda_u2d40.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(93));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder dup2_x2() {
        final InsnListBuilder $this$dup2_x2_u24lambda_u2d41 = this;
        final int n = 0;
        $this$dup2_x2_u24lambda_u2d41.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(94));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder f2d() {
        final InsnListBuilder $this$f2d_u24lambda_u2d42 = this;
        final int n = 0;
        $this$f2d_u24lambda_u2d42.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(141));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder f2i() {
        final InsnListBuilder $this$f2i_u24lambda_u2d43 = this;
        final int n = 0;
        $this$f2i_u24lambda_u2d43.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(139));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder f2l() {
        final InsnListBuilder $this$f2l_u24lambda_u2d44 = this;
        final int n = 0;
        $this$f2l_u24lambda_u2d44.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(140));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fadd() {
        final InsnListBuilder $this$fadd_u24lambda_u2d45 = this;
        final int n = 0;
        $this$fadd_u24lambda_u2d45.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(98));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder faload() {
        final InsnListBuilder $this$faload_u24lambda_u2d46 = this;
        final int n = 0;
        $this$faload_u24lambda_u2d46.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(48));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fastore() {
        final InsnListBuilder $this$fastore_u24lambda_u2d47 = this;
        final int n = 0;
        $this$fastore_u24lambda_u2d47.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(48));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fcmpg() {
        final InsnListBuilder $this$fcmpg_u24lambda_u2d48 = this;
        final int n = 0;
        $this$fcmpg_u24lambda_u2d48.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(150));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fcmpl() {
        final InsnListBuilder $this$fcmpl_u24lambda_u2d49 = this;
        final int n = 0;
        $this$fcmpl_u24lambda_u2d49.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(149));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fconst_0() {
        final InsnListBuilder $this$fconst_0_u24lambda_u2d50 = this;
        final int n = 0;
        $this$fconst_0_u24lambda_u2d50.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(11));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fconst_1() {
        final InsnListBuilder $this$fconst_1_u24lambda_u2d51 = this;
        final int n = 0;
        $this$fconst_1_u24lambda_u2d51.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(12));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fconst_2() {
        final InsnListBuilder $this$fconst_2_u24lambda_u2d52 = this;
        final int n = 0;
        $this$fconst_2_u24lambda_u2d52.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(13));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fdiv() {
        final InsnListBuilder $this$fdiv_u24lambda_u2d53 = this;
        final int n = 0;
        $this$fdiv_u24lambda_u2d53.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(110));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fload(final int index) {
        final InsnListBuilder $this$fload_u24lambda_u2d54 = this;
        final int n = 0;
        $this$fload_u24lambda_u2d54.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(23, index));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fmul() {
        final InsnListBuilder $this$fmul_u24lambda_u2d55 = this;
        final int n = 0;
        $this$fmul_u24lambda_u2d55.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(106));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fneg() {
        final InsnListBuilder $this$fneg_u24lambda_u2d56 = this;
        final int n = 0;
        $this$fneg_u24lambda_u2d56.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(118));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fnewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$fnewarray_u24lambda_u2d57 = this;
        final int n = 0;
        $this$fnewarray_u24lambda_u2d57.newarray(6, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder frem() {
        final InsnListBuilder $this$frem_u24lambda_u2d58 = this;
        final int n = 0;
        $this$frem_u24lambda_u2d58.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(114));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder freturn() {
        final InsnListBuilder $this$freturn_u24lambda_u2d59 = this;
        final int n = 0;
        $this$freturn_u24lambda_u2d59.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(174));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fstore(final int index) {
        final InsnListBuilder $this$fstore_u24lambda_u2d60 = this;
        final int n = 0;
        $this$fstore_u24lambda_u2d60.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(56, index));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder fsub() {
        final InsnListBuilder $this$fsub_u24lambda_u2d61 = this;
        final int n = 0;
        $this$fsub_u24lambda_u2d61.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(102));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder i2b() {
        final InsnListBuilder $this$i2b_u24lambda_u2d62 = this;
        final int n = 0;
        $this$i2b_u24lambda_u2d62.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(145));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder i2c() {
        final InsnListBuilder $this$i2c_u24lambda_u2d63 = this;
        final int n = 0;
        $this$i2c_u24lambda_u2d63.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(146));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder i2d() {
        final InsnListBuilder $this$i2d_u24lambda_u2d64 = this;
        final int n = 0;
        $this$i2d_u24lambda_u2d64.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(135));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder i2f() {
        final InsnListBuilder $this$i2f_u24lambda_u2d65 = this;
        final int n = 0;
        $this$i2f_u24lambda_u2d65.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(134));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder i2l() {
        final InsnListBuilder $this$i2l_u24lambda_u2d66 = this;
        final int n = 0;
        $this$i2l_u24lambda_u2d66.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(133));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder i2s() {
        final InsnListBuilder $this$i2s_u24lambda_u2d67 = this;
        final int n = 0;
        $this$i2s_u24lambda_u2d67.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(147));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iadd() {
        final InsnListBuilder $this$iadd_u24lambda_u2d68 = this;
        final int n = 0;
        $this$iadd_u24lambda_u2d68.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(96));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iaload() {
        final InsnListBuilder $this$iaload_u24lambda_u2d69 = this;
        final int n = 0;
        $this$iaload_u24lambda_u2d69.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(46));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iand() {
        final InsnListBuilder $this$iand_u24lambda_u2d70 = this;
        final int n = 0;
        $this$iand_u24lambda_u2d70.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(126));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iastore() {
        final InsnListBuilder $this$iastore_u24lambda_u2d71 = this;
        final int n = 0;
        $this$iastore_u24lambda_u2d71.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(79));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_m1() {
        final InsnListBuilder $this$iconst_m1_u24lambda_u2d72 = this;
        final int n = 0;
        $this$iconst_m1_u24lambda_u2d72.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(2));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_0() {
        final InsnListBuilder $this$iconst_0_u24lambda_u2d73 = this;
        final int n = 0;
        $this$iconst_0_u24lambda_u2d73.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(3));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_1() {
        final InsnListBuilder $this$iconst_1_u24lambda_u2d74 = this;
        final int n = 0;
        $this$iconst_1_u24lambda_u2d74.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(4));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_2() {
        final InsnListBuilder $this$iconst_2_u24lambda_u2d75 = this;
        final int n = 0;
        $this$iconst_2_u24lambda_u2d75.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(5));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_3() {
        final InsnListBuilder $this$iconst_3_u24lambda_u2d76 = this;
        final int n = 0;
        $this$iconst_3_u24lambda_u2d76.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(6));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_4() {
        final InsnListBuilder $this$iconst_4_u24lambda_u2d77 = this;
        final int n = 0;
        $this$iconst_4_u24lambda_u2d77.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(7));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iconst_5() {
        final InsnListBuilder $this$iconst_5_u24lambda_u2d78 = this;
        final int n = 0;
        $this$iconst_5_u24lambda_u2d78.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(8));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder idiv() {
        final InsnListBuilder $this$idiv_u24lambda_u2d79 = this;
        final int n = 0;
        $this$idiv_u24lambda_u2d79.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(108));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iinc() {
        final InsnListBuilder $this$iinc_u24lambda_u2d80 = this;
        final int n = 0;
        $this$iinc_u24lambda_u2d80.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(132));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iload(final int value) {
        final InsnListBuilder $this$iload_u24lambda_u2d81 = this;
        final int n = 0;
        $this$iload_u24lambda_u2d81.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(21, value));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder imul() {
        final InsnListBuilder $this$imul_u24lambda_u2d82 = this;
        final int n = 0;
        $this$imul_u24lambda_u2d82.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(104));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ineg() {
        final InsnListBuilder $this$ineg_u24lambda_u2d83 = this;
        final int n = 0;
        $this$ineg_u24lambda_u2d83.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(116));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder inewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$inewarray_u24lambda_u2d84 = this;
        final int n = 0;
        $this$inewarray_u24lambda_u2d84.newarray(10, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder instanceof(@NotNull final String clazzName) {
        Intrinsics.checkNotNullParameter((Object)clazzName, "clazzName");
        final InsnListBuilder $this$instanceof_u24lambda_u2d85 = this;
        final int n = 0;
        $this$instanceof_u24lambda_u2d85.insn$AsmHelper1_8_9((AbstractInsnNode)new TypeInsnNode(193, clazzName));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ior() {
        final InsnListBuilder $this$ior_u24lambda_u2d86 = this;
        final int n = 0;
        $this$ior_u24lambda_u2d86.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(128));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder irem() {
        final InsnListBuilder $this$irem_u24lambda_u2d87 = this;
        final int n = 0;
        $this$irem_u24lambda_u2d87.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(112));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ireturn() {
        final InsnListBuilder $this$ireturn_u24lambda_u2d88 = this;
        final int n = 0;
        $this$ireturn_u24lambda_u2d88.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(172));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ishl() {
        final InsnListBuilder $this$ishl_u24lambda_u2d89 = this;
        final int n = 0;
        $this$ishl_u24lambda_u2d89.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(120));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ishr() {
        final InsnListBuilder $this$ishr_u24lambda_u2d90 = this;
        final int n = 0;
        $this$ishr_u24lambda_u2d90.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(122));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder istore(final int value) {
        final InsnListBuilder $this$istore_u24lambda_u2d91 = this;
        final int n = 0;
        $this$istore_u24lambda_u2d91.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(54, value));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder isub() {
        final InsnListBuilder $this$isub_u24lambda_u2d92 = this;
        final int n = 0;
        $this$isub_u24lambda_u2d92.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(100));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder iushr() {
        final InsnListBuilder $this$iushr_u24lambda_u2d93 = this;
        final int n = 0;
        $this$iushr_u24lambda_u2d93.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(124));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ixor() {
        final InsnListBuilder $this$ixor_u24lambda_u2d94 = this;
        final int n = 0;
        $this$ixor_u24lambda_u2d94.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(130));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder l2d() {
        final InsnListBuilder $this$l2d_u24lambda_u2d95 = this;
        final int n = 0;
        $this$l2d_u24lambda_u2d95.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(138));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder l2f() {
        final InsnListBuilder $this$l2f_u24lambda_u2d96 = this;
        final int n = 0;
        $this$l2f_u24lambda_u2d96.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(137));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder l2i() {
        final InsnListBuilder $this$l2i_u24lambda_u2d97 = this;
        final int n = 0;
        $this$l2i_u24lambda_u2d97.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(136));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ladd() {
        final InsnListBuilder $this$ladd_u24lambda_u2d98 = this;
        final int n = 0;
        $this$ladd_u24lambda_u2d98.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(97));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder laload() {
        final InsnListBuilder $this$laload_u24lambda_u2d99 = this;
        final int n = 0;
        $this$laload_u24lambda_u2d99.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(47));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder land() {
        final InsnListBuilder $this$land_u24lambda_u2d100 = this;
        final int n = 0;
        $this$land_u24lambda_u2d100.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(127));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lastore() {
        final InsnListBuilder $this$lastore_u24lambda_u2d101 = this;
        final int n = 0;
        $this$lastore_u24lambda_u2d101.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(80));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lcmp() {
        final InsnListBuilder $this$lcmp_u24lambda_u2d102 = this;
        final int n = 0;
        $this$lcmp_u24lambda_u2d102.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(148));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lconst_0() {
        final InsnListBuilder $this$lconst_0_u24lambda_u2d103 = this;
        final int n = 0;
        $this$lconst_0_u24lambda_u2d103.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(9));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lconst_1() {
        final InsnListBuilder $this$lconst_1_u24lambda_u2d104 = this;
        final int n = 0;
        $this$lconst_1_u24lambda_u2d104.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(10));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ldc(@NotNull final Object constant) {
        Intrinsics.checkNotNullParameter(constant, "constant");
        final InsnListBuilder $this$ldc_u24lambda_u2d105 = this;
        final int n = 0;
        $this$ldc_u24lambda_u2d105.insn$AsmHelper1_8_9((AbstractInsnNode)new LdcInsnNode(constant));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ldiv() {
        final InsnListBuilder $this$ldiv_u24lambda_u2d106 = this;
        final int n = 0;
        $this$ldiv_u24lambda_u2d106.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(109));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lload(final int value) {
        final InsnListBuilder $this$lload_u24lambda_u2d107 = this;
        final int n = 0;
        $this$lload_u24lambda_u2d107.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(22, value));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lmul() {
        final InsnListBuilder $this$lmul_u24lambda_u2d108 = this;
        final int n = 0;
        $this$lmul_u24lambda_u2d108.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(105));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lneg() {
        final InsnListBuilder $this$lneg_u24lambda_u2d109 = this;
        final int n = 0;
        $this$lneg_u24lambda_u2d109.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(117));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lnewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$lnewarray_u24lambda_u2d110 = this;
        final int n = 0;
        $this$lnewarray_u24lambda_u2d110.newarray(11, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lor() {
        final InsnListBuilder $this$lor_u24lambda_u2d111 = this;
        final int n = 0;
        $this$lor_u24lambda_u2d111.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(129));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lrem() {
        final InsnListBuilder $this$lrem_u24lambda_u2d112 = this;
        final int n = 0;
        $this$lrem_u24lambda_u2d112.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(113));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lreturn() {
        final InsnListBuilder $this$lreturn_u24lambda_u2d113 = this;
        final int n = 0;
        $this$lreturn_u24lambda_u2d113.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(173));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lshl() {
        final InsnListBuilder $this$lshl_u24lambda_u2d114 = this;
        final int n = 0;
        $this$lshl_u24lambda_u2d114.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(121));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lshr() {
        final InsnListBuilder $this$lshr_u24lambda_u2d115 = this;
        final int n = 0;
        $this$lshr_u24lambda_u2d115.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(123));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lstore(final int value) {
        final InsnListBuilder $this$lstore_u24lambda_u2d116 = this;
        final int n = 0;
        $this$lstore_u24lambda_u2d116.insn$AsmHelper1_8_9((AbstractInsnNode)new VarInsnNode(55, value));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lsub() {
        final InsnListBuilder $this$lsub_u24lambda_u2d117 = this;
        final int n = 0;
        $this$lsub_u24lambda_u2d117.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(101));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lushr() {
        final InsnListBuilder $this$lushr_u24lambda_u2d118 = this;
        final int n = 0;
        $this$lushr_u24lambda_u2d118.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(125));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder lxor() {
        final InsnListBuilder $this$lxor_u24lambda_u2d119 = this;
        final int n = 0;
        $this$lxor_u24lambda_u2d119.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(131));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder monitorenter() {
        final InsnListBuilder $this$monitorenter_u24lambda_u2d120 = this;
        final int n = 0;
        $this$monitorenter_u24lambda_u2d120.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(194));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder monitorexit() {
        final InsnListBuilder $this$monitorexit_u24lambda_u2d121 = this;
        final int n = 0;
        $this$monitorexit_u24lambda_u2d121.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(195));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder multianewarray(@NotNull final String descriptor, final int dimensions) {
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        final InsnListBuilder $this$multianewarray_u24lambda_u2d122 = this;
        final int n = 0;
        $this$multianewarray_u24lambda_u2d122.insn$AsmHelper1_8_9((AbstractInsnNode)new MultiANewArrayInsnNode(descriptor, dimensions));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder new(@NotNull final String className) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        final InsnListBuilder $this$new_u24lambda_u2d123 = this;
        final int n = 0;
        $this$new_u24lambda_u2d123.insn$AsmHelper1_8_9((AbstractInsnNode)new TypeInsnNode(187, className));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder newarray(final int type, @Nullable final Integer length) {
        final InsnListBuilder $this$newarray_u24lambda_u2d124 = this;
        final int n = 0;
        if (length != null) {
            $this$newarray_u24lambda_u2d124.ldc(length);
        }
        $this$newarray_u24lambda_u2d124.insn$AsmHelper1_8_9((AbstractInsnNode)new IntInsnNode(188, type));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder nop() {
        final InsnListBuilder $this$nop_u24lambda_u2d125 = this;
        final int n = 0;
        $this$nop_u24lambda_u2d125.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(0));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder pop() {
        final InsnListBuilder $this$pop_u24lambda_u2d126 = this;
        final int n = 0;
        $this$pop_u24lambda_u2d126.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(87));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder pop2() {
        final InsnListBuilder $this$pop2_u24lambda_u2d127 = this;
        final int n = 0;
        $this$pop2_u24lambda_u2d127.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(88));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder methodReturn() {
        final InsnListBuilder $this$methodReturn_u24lambda_u2d128 = this;
        final int n = 0;
        $this$methodReturn_u24lambda_u2d128.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(177));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder saload() {
        final InsnListBuilder $this$saload_u24lambda_u2d129 = this;
        final int n = 0;
        $this$saload_u24lambda_u2d129.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(53));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder sastore() {
        final InsnListBuilder $this$sastore_u24lambda_u2d130 = this;
        final int n = 0;
        $this$sastore_u24lambda_u2d130.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(86));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder sipush(final int value) {
        final InsnListBuilder $this$sipush_u24lambda_u2d131 = this;
        final int n = 0;
        $this$sipush_u24lambda_u2d131.insn$AsmHelper1_8_9((AbstractInsnNode)new IntInsnNode(17, value));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder snewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$snewarray_u24lambda_u2d132 = this;
        final int n = 0;
        $this$snewarray_u24lambda_u2d132.newarray(9, length);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder swap() {
        final InsnListBuilder $this$swap_u24lambda_u2d133 = this;
        final int n = 0;
        $this$swap_u24lambda_u2d133.insn$AsmHelper1_8_9((AbstractInsnNode)new InsnNode(95));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder znewarray(@Nullable final Integer length) {
        final InsnListBuilder $this$znewarray_u24lambda_u2d134 = this;
        final int n = 0;
        $this$znewarray_u24lambda_u2d134.newarray(4, length);
        return this;
    }
    
    @NotNull
    public final LabelNode makeLabel() {
        return new LabelNode();
    }
    
    @NotNull
    public final LabelNode findLabel(final int n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.toInjectInto:Lorg/objectweb/asm/tree/MethodNode;
        //     4: getfield        org/objectweb/asm/tree/MethodNode.instructions:Lorg/objectweb/asm/tree/InsnList;
        //     7: invokevirtual   org/objectweb/asm/tree/InsnList.iterator:()Ljava/util/ListIterator;
        //    10: astore_2       
        //    11: aload_2        
        //    12: ldc_w           "toInjectInto.instructions\n        .iterator()"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: aload_2        
        //    19: checkcast       Ljava/util/Iterator;
        //    22: invokestatic    kotlin/sequences/SequencesKt.asSequence:(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;
        //    25: invokestatic    kotlin/sequences/SequencesKt.toList:(Lkotlin/sequences/Sequence;)Ljava/util/List;
        //    28: checkcast       Ljava/lang/Iterable;
        //    31: astore_2       
        //    32: nop            
        //    33: iconst_0       
        //    34: istore_3        /* $i$f$filterIsInstance */
        //    35: aload_2         /* $this$filterIsInstance$iv */
        //    36: astore          4
        //    38: new             Ljava/util/ArrayList;
        //    41: dup            
        //    42: invokespecial   java/util/ArrayList.<init>:()V
        //    45: checkcast       Ljava/util/Collection;
        //    48: astore          destination$iv$iv
        //    50: iconst_0       
        //    51: istore          $i$f$filterIsInstanceTo
        //    53: aload           $this$filterIsInstanceTo$iv$iv
        //    55: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    60: astore          7
        //    62: aload           7
        //    64: invokeinterface java/util/Iterator.hasNext:()Z
        //    69: ifeq            102
        //    72: aload           7
        //    74: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    79: astore          element$iv$iv
        //    81: aload           element$iv$iv
        //    83: instanceof      Lorg/objectweb/asm/tree/LabelNode;
        //    86: ifeq            62
        //    89: aload           destination$iv$iv
        //    91: aload           element$iv$iv
        //    93: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    98: pop            
        //    99: goto            62
        //   102: aload           destination$iv$iv
        //   104: checkcast       Ljava/util/List;
        //   107: nop            
        //   108: checkcast       Ljava/lang/Iterable;
        //   111: astore_2       
        //   112: nop            
        //   113: iconst_0       
        //   114: istore_3        /* $i$f$sortedBy */
        //   115: aload_2         /* $this$sortedBy$iv */
        //   116: iconst_0       
        //   117: istore          4
        //   119: new             Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder$findLabel$$inlined$sortedBy$1;
        //   122: dup            
        //   123: invokespecial   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder$findLabel$$inlined$sortedBy$1.<init>:()V
        //   126: checkcast       Ljava/util/Comparator;
        //   129: invokestatic    kotlin/collections/CollectionsKt.sortedWith:(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;
        //   132: astore_2        /* $this$sortedBy$iv */
        //   133: iconst_0       
        //   134: istore_3       
        //   135: aload_2        
        //   136: iload_1         /* n */
        //   137: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   142: checkcast       Lorg/objectweb/asm/tree/LabelNode;
        //   145: areturn        
        //    StackMapTable: 00 02 FF 00 3E 00 08 07 00 02 01 07 02 B9 01 07 02 B9 07 02 BE 01 07 02 AD 00 00 27
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public final InsnListBuilder placeLabel(@NotNull final LabelNode label) {
        Intrinsics.checkNotNullParameter((Object)label, "label");
        final InsnListBuilder $this$placeLabel_u24lambda_u2d136 = this;
        final int n = 0;
        $this$placeLabel_u24lambda_u2d136.insn$AsmHelper1_8_9((AbstractInsnNode)label);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder jump(@NotNull final JumpCondition condition, @NotNull final LabelNode label) {
        Intrinsics.checkNotNullParameter((Object)condition, "condition");
        Intrinsics.checkNotNullParameter((Object)label, "label");
        final InsnListBuilder $this$jump_u24lambda_u2d137 = this;
        final int n = 0;
        $this$jump_u24lambda_u2d137.insn$AsmHelper1_8_9((AbstractInsnNode)new JumpInsnNode(condition.getOpcode(), label));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder array(final int size, @NotNull final String className, @NotNull final Function1<? super ArrayBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final InsnListBuilder $this$array_u24lambda_u2d138 = this;
        final int n = 0;
        $this$array_u24lambda_u2d138.int(size);
        $this$array_u24lambda_u2d138.anewarray(className);
        final ArrayBuilder array = new ArrayBuilder($this$array_u24lambda_u2d138);
        code.invoke((Object)array);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder getKObjectInstance(@NotNull final String objectClassName) {
        Intrinsics.checkNotNullParameter((Object)objectClassName, "objectClassName");
        final InsnListBuilder $this$getKObjectInstance_u24lambda_u2d139 = this;
        final int n = 0;
        $this$getKObjectInstance_u24lambda_u2d139.field(FieldAction.GET_STATIC, objectClassName, "INSTANCE", 'L' + objectClassName + ';');
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeKObjectFunction(@NotNull final String objectClassName, @NotNull final String methodName, @NotNull final String methodDesc, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)objectClassName, "objectClassName");
        Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
        Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
        final InsnListBuilder $this$invokeKObjectFunction_u24lambda_u2d140 = this;
        final int n = 0;
        $this$invokeKObjectFunction_u24lambda_u2d140.getKObjectInstance(objectClassName);
        $this$invokeKObjectFunction_u24lambda_u2d140.invoke(InvokeType.VIRTUAL, objectClassName, methodName, methodDesc, arguments);
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invokeKObjectFunction$default(final InsnListBuilder insnListBuilder, final String objectClassName, final String methodName, final String methodDesc, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeKObjectFunction");
        }
        if ((n & 0x8) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invokeKObjectFunction(objectClassName, methodName, methodDesc, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @NotNull
    public final InsnListBuilder int(final int number) {
        final InsnListBuilder $this$int_u24lambda_u2d141 = this;
        final int n = 0;
        if (number == -1) {
            $this$int_u24lambda_u2d141.iconst_m1();
        }
        else if (number == 0) {
            $this$int_u24lambda_u2d141.iconst_0();
        }
        else if (number == 1) {
            $this$int_u24lambda_u2d141.iconst_1();
        }
        else if (number == 2) {
            $this$int_u24lambda_u2d141.iconst_2();
        }
        else if (number == 3) {
            $this$int_u24lambda_u2d141.iconst_3();
        }
        else if (number == 4) {
            $this$int_u24lambda_u2d141.iconst_4();
        }
        else if (number == 5) {
            $this$int_u24lambda_u2d141.iconst_5();
        }
        else if (6 <= number && number <= 127) {
            $this$int_u24lambda_u2d141.bipush(number);
        }
        else if (-127 <= number && number <= -2) {
            $this$int_u24lambda_u2d141.bipush(number);
        }
        else if (128 <= number && number <= 32768) {
            $this$int_u24lambda_u2d141.sipush(number);
        }
        else if (-32768 <= number && number <= -128) {
            $this$int_u24lambda_u2d141.sipush(number);
        }
        else {
            $this$int_u24lambda_u2d141.ldc(number);
        }
        return this;
    }
    
    @NotNull
    public final InsnListBuilder double(final double number) {
        final InsnListBuilder $this$double_u24lambda_u2d142 = this;
        final int n = 0;
        if (number == 0.0) {
            $this$double_u24lambda_u2d142.dconst_0();
        }
        else if (number == 1.0) {
            $this$double_u24lambda_u2d142.dconst_1();
        }
        else {
            $this$double_u24lambda_u2d142.ldc(number);
        }
        return this;
    }
    
    @NotNull
    public final InsnListBuilder float(final float number) {
        final InsnListBuilder $this$float_u24lambda_u2d143 = this;
        final int n = 0;
        if (number == 0.0f) {
            $this$float_u24lambda_u2d143.fconst_0();
        }
        else if (number == 1.0f) {
            $this$float_u24lambda_u2d143.fconst_1();
        }
        else if (number == 2.0f) {
            $this$float_u24lambda_u2d143.fconst_2();
        }
        else {
            $this$float_u24lambda_u2d143.ldc(number);
        }
        return this;
    }
    
    @NotNull
    public final InsnListBuilder long(final long number) {
        final InsnListBuilder $this$long_u24lambda_u2d144 = this;
        final int n = 0;
        if (number == 0L) {
            $this$long_u24lambda_u2d144.lconst_0();
        }
        else if (number == 1L) {
            $this$long_u24lambda_u2d144.lconst_1();
        }
        else {
            $this$long_u24lambda_u2d144.ldc(number);
        }
        return this;
    }
    
    @NotNull
    public final InsnListBuilder synchronized(@NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final InsnListBuilder $this$synchronized_u24lambda_u2d145 = this;
        final int n = 0;
        $this$synchronized_u24lambda_u2d145.dup();
        final Local syncObj = $this$synchronized_u24lambda_u2d145.astore();
        $this$synchronized_u24lambda_u2d145.monitorenter();
        code.invoke((Object)$this$synchronized_u24lambda_u2d145);
        $this$synchronized_u24lambda_u2d145.load(syncObj);
        $this$synchronized_u24lambda_u2d145.monitorexit();
        return this;
    }
    
    @NotNull
    public final InsnListBuilder ifClause(@NotNull final JumpCondition[] conditions, @NotNull final Function1<? super InsnListBuilder, Unit> code) {
        Intrinsics.checkNotNullParameter((Object)conditions, "conditions");
        Intrinsics.checkNotNullParameter((Object)code, "code");
        final InsnListBuilder $this$ifClause_u24lambda_u2d146 = this;
        final int n = 0;
        final LabelNode label = $this$ifClause_u24lambda_u2d146.makeLabel();
        int i = 0;
        while (i < conditions.length) {
            final JumpCondition condition = conditions[i];
            ++i;
            $this$ifClause_u24lambda_u2d146.jump(condition, label);
        }
        code.invoke((Object)$this$ifClause_u24lambda_u2d146);
        $this$ifClause_u24lambda_u2d146.placeLabel(label);
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder createInstance(@NotNull final String className, @NotNull final String constructorDescription, @NotNull final Function1<? super InsnListBuilder, Unit> parameters) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)constructorDescription, "constructorDescription");
        Intrinsics.checkNotNullParameter((Object)parameters, "parameters");
        final InsnListBuilder $this$createInstance_u24lambda_u2d147 = this;
        final int n = 0;
        $this$createInstance_u24lambda_u2d147.new(className);
        $this$createInstance_u24lambda_u2d147.dup();
        parameters.invoke((Object)$this$createInstance_u24lambda_u2d147);
        invoke$default($this$createInstance_u24lambda_u2d147, InvokeType.SPECIAL, className, "<init>", constructorDescription, null, 16, null);
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder createInstance$default(final InsnListBuilder insnListBuilder, final String className, final String constructorDescription, Function1 parameters, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createInstance");
        }
        if ((n & 0x4) != 0x0) {
            parameters = (Function1)InsnListBuilder$createInstance.InsnListBuilder$createInstance$1.INSTANCE;
        }
        return insnListBuilder.createInstance(className, constructorDescription, (Function1<? super InsnListBuilder, Unit>)parameters);
    }
    
    @NotNull
    public final InsnListBuilder ifElseClause(@NotNull final JumpCondition[] conditions, @NotNull final Function1<? super IfElseBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)conditions, "conditions");
        Intrinsics.checkNotNullParameter((Object)builder, "builder");
        final InsnListBuilder $this$ifElseClause_u24lambda_u2d148 = this;
        final int n = 0;
        final IfElseBuilder ifElse = new IfElseBuilder($this$ifElseClause_u24lambda_u2d148.getToInjectInto());
        builder.invoke((Object)ifElse);
        final LabelNode ifLabel = $this$ifElseClause_u24lambda_u2d148.makeLabel();
        final LabelNode endLabel = $this$ifElseClause_u24lambda_u2d148.makeLabel();
        int i = 0;
        while (i < conditions.length) {
            final JumpCondition cond = conditions[i];
            ++i;
            $this$ifElseClause_u24lambda_u2d148.jump(cond, ifLabel);
        }
        $this$ifElseClause_u24lambda_u2d148.insertInsns(ifElse.getElseCode());
        $this$ifElseClause_u24lambda_u2d148.jump(JumpCondition.GOTO, endLabel);
        $this$ifElseClause_u24lambda_u2d148.placeLabel(ifLabel);
        $this$ifElseClause_u24lambda_u2d148.insertInsns(ifElse.getIfCode());
        $this$ifElseClause_u24lambda_u2d148.placeLabel(endLabel);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder getStatic(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$getStatic_u24lambda_u2d149 = this;
        final int n = 0;
        $this$getStatic_u24lambda_u2d149.field(FieldAction.GET_STATIC, owner, name, desc);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder getField(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$getField_u24lambda_u2d150 = this;
        final int n = 0;
        $this$getField_u24lambda_u2d150.field(FieldAction.GET_FIELD, owner, name, desc);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder putStatic(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$putStatic_u24lambda_u2d151 = this;
        final int n = 0;
        $this$putStatic_u24lambda_u2d151.field(FieldAction.PUT_STATIC, owner, name, desc);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder putField(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$putField_u24lambda_u2d152 = this;
        final int n = 0;
        $this$putField_u24lambda_u2d152.field(FieldAction.PUT_FIELD, owner, name, desc);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder field(@NotNull final FieldAction action, @NotNull final Descriptor descriptor) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        return this.field(action, descriptor.getOwner(), descriptor.getName(), descriptor.getDesc());
    }
    
    @NotNull
    public final InsnListBuilder field(@NotNull final FieldAction action, @NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)action, "action");
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$field_u24lambda_u2d153 = this;
        final int n = 0;
        final String realName = AsmHelper.INSTANCE.getRemapper().mapFieldAccess(name);
        $this$field_u24lambda_u2d153.getInsnList().add((AbstractInsnNode)new FieldInsnNode(action.getOpcode(), owner, realName, desc));
        return this;
    }
    
    @NotNull
    public final InsnListBuilder getLocalField(@NotNull final Descriptor descriptor) {
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        final InsnListBuilder $this$getLocalField_u24lambda_u2d154 = this;
        final int n = 0;
        $this$getLocalField_u24lambda_u2d154.aload(0);
        $this$getLocalField_u24lambda_u2d154.field(FieldAction.GET_FIELD, descriptor);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder updateLocalField(@NotNull final Descriptor descriptor, @NotNull final Function1<? super InsnListBuilder, Unit> updater) {
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        Intrinsics.checkNotNullParameter((Object)updater, "updater");
        final InsnListBuilder $this$updateLocalField_u24lambda_u2d155 = this;
        final int n = 0;
        $this$updateLocalField_u24lambda_u2d155.aload(0);
        $this$updateLocalField_u24lambda_u2d155.getLocalField(descriptor);
        updater.invoke((Object)$this$updateLocalField_u24lambda_u2d155);
        $this$updateLocalField_u24lambda_u2d155.field(FieldAction.PUT_FIELD, descriptor);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder setLocalField(@NotNull final Descriptor descriptor, @NotNull final Function1<? super InsnListBuilder, Unit> newValue) {
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        Intrinsics.checkNotNullParameter((Object)newValue, "newValue");
        final InsnListBuilder $this$setLocalField_u24lambda_u2d156 = this;
        final int n = 0;
        $this$setLocalField_u24lambda_u2d156.aload(0);
        newValue.invoke((Object)$this$setLocalField_u24lambda_u2d156);
        $this$setLocalField_u24lambda_u2d156.field(FieldAction.PUT_FIELD, descriptor);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder getLocalField(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$getLocalField_u24lambda_u2d157 = this;
        final int n = 0;
        $this$getLocalField_u24lambda_u2d157.aload(0);
        $this$getLocalField_u24lambda_u2d157.field(FieldAction.GET_FIELD, owner, name, desc);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder updateLocalField(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @NotNull final Function1<? super InsnListBuilder, Unit> updater) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        Intrinsics.checkNotNullParameter((Object)updater, "updater");
        final InsnListBuilder $this$updateLocalField_u24lambda_u2d158 = this;
        final int n = 0;
        $this$updateLocalField_u24lambda_u2d158.aload(0);
        $this$updateLocalField_u24lambda_u2d158.getLocalField(owner, name, desc);
        updater.invoke((Object)$this$updateLocalField_u24lambda_u2d158);
        $this$updateLocalField_u24lambda_u2d158.field(FieldAction.PUT_FIELD, owner, name, desc);
        return this;
    }
    
    @NotNull
    public final InsnListBuilder setLocalField(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @NotNull final Function1<? super InsnListBuilder, Unit> newValue) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        Intrinsics.checkNotNullParameter((Object)newValue, "newValue");
        final InsnListBuilder $this$setLocalField_u24lambda_u2d159 = this;
        final int n = 0;
        $this$setLocalField_u24lambda_u2d159.aload(0);
        newValue.invoke((Object)$this$setLocalField_u24lambda_u2d159);
        $this$setLocalField_u24lambda_u2d159.field(FieldAction.PUT_FIELD, owner, name, desc);
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invoke(@NotNull final InvokeType type, @NotNull final Descriptor descriptor, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        return this.invoke(type, descriptor.getOwner(), descriptor.getName(), descriptor.getDesc(), arguments);
    }
    
    public static /* synthetic */ InsnListBuilder invoke$default(final InsnListBuilder insnListBuilder, final InvokeType type, final Descriptor descriptor, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((n & 0x4) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invoke(type, descriptor, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeStatic(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$invokeStatic_u24lambda_u2d160 = this;
        final int n = 0;
        $this$invokeStatic_u24lambda_u2d160.invoke(InvokeType.STATIC, owner, name, desc, arguments);
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invokeStatic$default(final InsnListBuilder insnListBuilder, final String owner, final String name, final String desc, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeStatic");
        }
        if ((n & 0x8) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invokeStatic(owner, name, desc, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeVirtual(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$invokeVirtual_u24lambda_u2d161 = this;
        final int n = 0;
        $this$invokeVirtual_u24lambda_u2d161.invoke(InvokeType.VIRTUAL, owner, name, desc, arguments);
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invokeVirtual$default(final InsnListBuilder insnListBuilder, final String owner, final String name, final String desc, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeVirtual");
        }
        if ((n & 0x8) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invokeVirtual(owner, name, desc, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeSpecial(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$invokeSpecial_u24lambda_u2d162 = this;
        final int n = 0;
        $this$invokeSpecial_u24lambda_u2d162.invoke(InvokeType.SPECIAL, owner, name, desc, arguments);
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invokeSpecial$default(final InsnListBuilder insnListBuilder, final String owner, final String name, final String desc, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeSpecial");
        }
        if ((n & 0x8) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invokeSpecial(owner, name, desc, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeInterface(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$invokeInterface_u24lambda_u2d163 = this;
        final int n = 0;
        $this$invokeInterface_u24lambda_u2d163.invoke(InvokeType.INTERFACE, owner, name, desc, arguments);
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invokeInterface$default(final InsnListBuilder insnListBuilder, final String owner, final String name, final String desc, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeInterface");
        }
        if ((n & 0x8) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invokeInterface(owner, name, desc, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @NotNull
    public final Handle handle(final int tag, @NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final String realName = AsmHelper.INSTANCE.getRemapper().mapInvocation(name);
        return new Handle(tag, owner, realName, desc);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeDynamic(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @NotNull final Handle bootstrapMethod, @NotNull final Object[] bootstrapConstantArgs, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        Intrinsics.checkNotNullParameter((Object)bootstrapMethod, "bootstrapMethod");
        Intrinsics.checkNotNullParameter((Object)bootstrapConstantArgs, "bootstrapConstantArgs");
        final InsnListBuilder $this$invokeDynamic_u24lambda_u2d164 = this;
        final int n = 0;
        final String realName = AsmHelper.INSTANCE.getRemapper().mapInvocation(name);
        if (arguments != null) {
            final InsnListBuilder insns = new InsnListBuilder($this$invokeDynamic_u24lambda_u2d164.getToInjectInto());
            arguments.invoke((Object)insns);
            $this$invokeDynamic_u24lambda_u2d164.getInsnList().add(insns.build());
        }
        $this$invokeDynamic_u24lambda_u2d164.getInsnList().add((AbstractInsnNode)new InvokeDynamicInsnNode(realName, desc, bootstrapMethod, Arrays.copyOf(bootstrapConstantArgs, bootstrapConstantArgs.length)));
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invokeDynamic$default(final InsnListBuilder insnListBuilder, final String owner, final String name, final String desc, final Handle bootstrapMethod, final Object[] bootstrapConstantArgs, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeDynamic");
        }
        if ((n & 0x20) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invokeDynamic(owner, name, desc, bootstrapMethod, bootstrapConstantArgs, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invoke(@NotNull final InvokeType type, @NotNull final String owner, @NotNull final String name, @NotNull final String desc, @Nullable final Function1<? super InsnListBuilder, Unit> arguments) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        final InsnListBuilder $this$invoke_u24lambda_u2d165 = this;
        final int n = 0;
        final String realName = AsmHelper.INSTANCE.getRemapper().mapInvocation(name);
        if (arguments != null) {
            final InsnListBuilder insns = new InsnListBuilder($this$invoke_u24lambda_u2d165.getToInjectInto());
            arguments.invoke((Object)insns);
            $this$invoke_u24lambda_u2d165.getInsnList().add(insns.build());
        }
        $this$invoke_u24lambda_u2d165.getInsnList().add((AbstractInsnNode)new MethodInsnNode(type.getOpcode(), owner, realName, desc, type == InvokeType.INTERFACE));
        return this;
    }
    
    public static /* synthetic */ InsnListBuilder invoke$default(final InsnListBuilder insnListBuilder, final InvokeType type, final String owner, final String name, final String desc, Function1 arguments, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((n & 0x10) != 0x0) {
            arguments = null;
        }
        return insnListBuilder.invoke(type, owner, name, desc, (Function1<? super InsnListBuilder, Unit>)arguments);
    }
    
    public final void tableswitch(@NotNull final Function1<? super SwitchBuilder, Unit> builder) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "builder"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: new             Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder;
        //    10: dup            
        //    11: invokespecial   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder.<init>:()V
        //    14: astore_3       
        //    15: iconst_0       
        //    16: istore          4
        //    18: iconst_0       
        //    19: istore          5
        //    21: aload_1         /* builder */
        //    22: aload_3        
        //    23: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    28: pop            
        //    29: aload_3        
        //    30: astore_2        /* tableBuilder */
        //    31: aload_2         /* tableBuilder */
        //    32: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder.getCases$AsmHelper1_8_9:()Ljava/util/List;
        //    35: astore_3        /* cases */
        //    36: aload_3         /* cases */
        //    37: invokeinterface java/util/List.isEmpty:()Z
        //    42: ifeq            56
        //    45: new             Ljava/lang/IllegalStateException;
        //    48: dup            
        //    49: ldc_w           "tableswitch builder must have at least one case."
        //    52: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    55: athrow         
        //    56: aload_3         /* cases */
        //    57: checkcast       Ljava/lang/Iterable;
        //    60: astore          $this$groupBy$iv
        //    62: iconst_0       
        //    63: istore          $i$f$groupBy
        //    65: aload           $this$groupBy$iv
        //    67: astore          6
        //    69: new             Ljava/util/LinkedHashMap;
        //    72: dup            
        //    73: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    76: checkcast       Ljava/util/Map;
        //    79: astore          destination$iv$iv
        //    81: iconst_0       
        //    82: istore          $i$f$groupByTo
        //    84: aload           $this$groupByTo$iv$iv
        //    86: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    91: astore          9
        //    93: aload           9
        //    95: invokeinterface java/util/Iterator.hasNext:()Z
        //   100: ifeq            208
        //   103: aload           9
        //   105: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   110: astore          element$iv$iv
        //   112: aload           element$iv$iv
        //   114: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   117: astore          it
        //   119: iconst_0       
        //   120: istore          $i$a$-groupBy-InsnListBuilder$tableswitch$1
        //   122: aload           it
        //   124: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   127: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   130: astore          key$iv$iv
        //   132: aload           destination$iv$iv
        //   134: astore          $this$getOrPut$iv$iv$iv
        //   136: iconst_0       
        //   137: istore          $i$f$getOrPut
        //   139: aload           $this$getOrPut$iv$iv$iv
        //   141: aload           key$iv$iv
        //   143: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: astore          value$iv$iv$iv
        //   150: aload           value$iv$iv$iv
        //   152: ifnonnull       187
        //   155: iconst_0       
        //   156: istore          $i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1$iv$iv
        //   158: new             Ljava/util/ArrayList;
        //   161: dup            
        //   162: invokespecial   java/util/ArrayList.<init>:()V
        //   165: checkcast       Ljava/util/List;
        //   168: astore          answer$iv$iv$iv
        //   170: aload           $this$getOrPut$iv$iv$iv
        //   172: aload           key$iv$iv
        //   174: aload           answer$iv$iv$iv
        //   176: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   181: pop            
        //   182: aload           answer$iv$iv$iv
        //   184: goto            190
        //   187: aload           value$iv$iv$iv
        //   189: nop            
        //   190: checkcast       Ljava/util/List;
        //   193: astore          list$iv$iv
        //   195: aload           list$iv$iv
        //   197: aload           element$iv$iv
        //   199: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   204: pop            
        //   205: goto            93
        //   208: aload           destination$iv$iv
        //   210: nop            
        //   211: astore          $this$any$iv
        //   213: iconst_0       
        //   214: istore          $i$f$any
        //   216: aload           $this$any$iv
        //   218: invokeinterface java/util/Map.isEmpty:()Z
        //   223: ifeq            230
        //   226: iconst_0       
        //   227: goto            312
        //   230: aload           $this$any$iv
        //   232: astore          6
        //   234: iconst_0       
        //   235: istore          7
        //   237: aload           6
        //   239: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   244: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   249: astore          8
        //   251: aload           8
        //   253: invokeinterface java/util/Iterator.hasNext:()Z
        //   258: ifeq            311
        //   261: aload           8
        //   263: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   268: checkcast       Ljava/util/Map$Entry;
        //   271: astore          element$iv
        //   273: aload           element$iv
        //   275: astore          it
        //   277: iconst_0       
        //   278: istore          $i$a$-any-InsnListBuilder$tableswitch$2
        //   280: aload           it
        //   282: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   287: checkcast       Ljava/util/List;
        //   290: invokeinterface java/util/List.size:()I
        //   295: iconst_1       
        //   296: if_icmpeq       303
        //   299: iconst_1       
        //   300: goto            304
        //   303: iconst_0       
        //   304: ifeq            251
        //   307: iconst_1       
        //   308: goto            312
        //   311: iconst_0       
        //   312: ifeq            326
        //   315: new             Ljava/lang/IllegalStateException;
        //   318: dup            
        //   319: ldc_w           "tableswitch builder cannot contain duplicate cases."
        //   322: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   325: athrow         
        //   326: aload_3         /* cases */
        //   327: checkcast       Ljava/lang/Iterable;
        //   330: astore          5
        //   332: iconst_0       
        //   333: istore          6
        //   335: aload           5
        //   337: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   342: astore          7
        //   344: aload           7
        //   346: invokeinterface java/util/Iterator.hasNext:()Z
        //   351: ifne            365
        //   354: new             Ljava/util/NoSuchElementException;
        //   357: dup            
        //   358: invokespecial   java/util/NoSuchElementException.<init>:()V
        //   361: checkcast       Ljava/lang/Throwable;
        //   364: athrow         
        //   365: aload           7
        //   367: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   372: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   375: astore          it
        //   377: iconst_0       
        //   378: istore          $i$a$-minOf-InsnListBuilder$tableswitch$min$1
        //   380: aload           it
        //   382: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   385: istore          null
        //   387: aload           7
        //   389: invokeinterface java/util/Iterator.hasNext:()Z
        //   394: ifeq            433
        //   397: aload           7
        //   399: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   404: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   407: astore          it
        //   409: iconst_0       
        //   410: istore          $i$a$-minOf-InsnListBuilder$tableswitch$min$1
        //   412: aload           it
        //   414: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   417: istore          null
        //   419: iload           8
        //   421: iload           9
        //   423: if_icmple       387
        //   426: iload           9
        //   428: istore          8
        //   430: goto            387
        //   433: iload           8
        //   435: istore          min
        //   437: aload_3         /* cases */
        //   438: checkcast       Ljava/lang/Iterable;
        //   441: astore          6
        //   443: iconst_0       
        //   444: istore          7
        //   446: aload           6
        //   448: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   453: astore          8
        //   455: aload           8
        //   457: invokeinterface java/util/Iterator.hasNext:()Z
        //   462: ifne            476
        //   465: new             Ljava/util/NoSuchElementException;
        //   468: dup            
        //   469: invokespecial   java/util/NoSuchElementException.<init>:()V
        //   472: checkcast       Ljava/lang/Throwable;
        //   475: athrow         
        //   476: aload           8
        //   478: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   483: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   486: astore          it
        //   488: iconst_0       
        //   489: istore          $i$a$-maxOf-InsnListBuilder$tableswitch$max$1
        //   491: aload           it
        //   493: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   496: istore          null
        //   498: aload           8
        //   500: invokeinterface java/util/Iterator.hasNext:()Z
        //   505: ifeq            544
        //   508: aload           8
        //   510: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   515: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   518: astore          it
        //   520: iconst_0       
        //   521: istore          $i$a$-maxOf-InsnListBuilder$tableswitch$max$1
        //   523: aload           it
        //   525: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   528: istore          null
        //   530: iload           9
        //   532: iload           10
        //   534: if_icmpge       498
        //   537: iload           10
        //   539: istore          9
        //   541: goto            498
        //   544: iload           9
        //   546: istore          max
        //   548: new             Lkotlin/ranges/IntRange;
        //   551: dup            
        //   552: iload           min
        //   554: iload           max
        //   556: invokespecial   kotlin/ranges/IntRange.<init>:(II)V
        //   559: checkcast       Ljava/lang/Iterable;
        //   562: astore          $this$map$iv
        //   564: iconst_0       
        //   565: istore          $i$f$map
        //   567: aload           $this$map$iv
        //   569: astore          9
        //   571: new             Ljava/util/ArrayList;
        //   574: dup            
        //   575: aload           $this$map$iv
        //   577: bipush          10
        //   579: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   582: invokespecial   java/util/ArrayList.<init>:(I)V
        //   585: checkcast       Ljava/util/Collection;
        //   588: astore          destination$iv$iv
        //   590: iconst_0       
        //   591: istore          $i$f$mapTo
        //   593: aload           $this$mapTo$iv$iv
        //   595: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   600: astore          12
        //   602: aload           12
        //   604: invokeinterface java/util/Iterator.hasNext:()Z
        //   609: ifeq            652
        //   612: aload           12
        //   614: checkcast       Lkotlin/collections/IntIterator;
        //   617: invokevirtual   kotlin/collections/IntIterator.nextInt:()I
        //   620: istore          item$iv$iv
        //   622: aload           destination$iv$iv
        //   624: iload           item$iv$iv
        //   626: istore          14
        //   628: astore          21
        //   630: iconst_0       
        //   631: istore          $i$a$-map-InsnListBuilder$tableswitch$labels$1
        //   633: aload_0         /* this */
        //   634: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.makeLabel:()Lorg/objectweb/asm/tree/LabelNode;
        //   637: astore          22
        //   639: aload           21
        //   641: aload           22
        //   643: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   648: pop            
        //   649: goto            602
        //   652: aload           destination$iv$iv
        //   654: checkcast       Ljava/util/List;
        //   657: nop            
        //   658: astore          labels
        //   660: aload_0         /* this */
        //   661: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.makeLabel:()Lorg/objectweb/asm/tree/LabelNode;
        //   664: astore          defaultLabel
        //   666: aload_0         /* this */
        //   667: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.makeLabel:()Lorg/objectweb/asm/tree/LabelNode;
        //   670: astore          endLabel
        //   672: aload_0         /* this */
        //   673: new             Lorg/objectweb/asm/tree/TableSwitchInsnNode;
        //   676: dup            
        //   677: iload           min
        //   679: iload           max
        //   681: aload           defaultLabel
        //   683: aload           labels
        //   685: checkcast       Ljava/util/Collection;
        //   688: astore          $this$toTypedArray$iv
        //   690: iconst_0       
        //   691: istore          $i$f$toTypedArray
        //   693: aload           $this$toTypedArray$iv
        //   695: astore          thisCollection$iv
        //   697: aload           thisCollection$iv
        //   699: iconst_0       
        //   700: anewarray       Lorg/objectweb/asm/tree/LabelNode;
        //   703: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   708: dup            
        //   709: ifnonnull       723
        //   712: new             Ljava/lang/NullPointerException;
        //   715: dup            
        //   716: ldc_w           "null cannot be cast to non-null type kotlin.Array<T>"
        //   719: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   722: athrow         
        //   723: checkcast       [Lorg/objectweb/asm/tree/LabelNode;
        //   726: astore          9
        //   728: aload           9
        //   730: aload           9
        //   732: arraylength    
        //   733: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   736: checkcast       [Lorg/objectweb/asm/tree/LabelNode;
        //   739: invokespecial   org/objectweb/asm/tree/TableSwitchInsnNode.<init>:(IILorg/objectweb/asm/tree/LabelNode;[Lorg/objectweb/asm/tree/LabelNode;)V
        //   742: checkcast       Lorg/objectweb/asm/tree/AbstractInsnNode;
        //   745: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.insn$AsmHelper1_8_9:(Lorg/objectweb/asm/tree/AbstractInsnNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   748: pop            
        //   749: iconst_0       
        //   750: istore          10
        //   752: new             Ljava/util/ArrayList;
        //   755: dup            
        //   756: invokespecial   java/util/ArrayList.<init>:()V
        //   759: checkcast       Ljava/util/List;
        //   762: astore          usedLabels
        //   764: aload_3         /* cases */
        //   765: checkcast       Ljava/lang/Iterable;
        //   768: astore          $this$forEach$iv
        //   770: iconst_0       
        //   771: istore          $i$f$forEach
        //   773: aload           $this$forEach$iv
        //   775: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   780: astore          12
        //   782: aload           12
        //   784: invokeinterface java/util/Iterator.hasNext:()Z
        //   789: ifeq            896
        //   792: aload           12
        //   794: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   799: astore          element$iv
        //   801: aload           element$iv
        //   803: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   806: astore          case
        //   808: iconst_0       
        //   809: istore          $i$a$-forEach-InsnListBuilder$tableswitch$3
        //   811: aload           labels
        //   813: aload           case
        //   815: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   818: iload           min
        //   820: isub           
        //   821: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   826: checkcast       Lorg/objectweb/asm/tree/LabelNode;
        //   829: astore          label
        //   831: aload           usedLabels
        //   833: aload           label
        //   835: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   840: pop            
        //   841: aload_0         /* this */
        //   842: aload           label
        //   844: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   847: pop            
        //   848: aload_0         /* this */
        //   849: astore          17
        //   851: aload           case
        //   853: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getBuilder:()Lkotlin/jvm/functions/Function1;
        //   856: astore          18
        //   858: iconst_0       
        //   859: istore          19
        //   861: iconst_0       
        //   862: istore          20
        //   864: aload           18
        //   866: aload           17
        //   868: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   873: pop            
        //   874: aload           case
        //   876: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getFallthrough:()Z
        //   879: ifne            892
        //   882: aload_0         /* this */
        //   883: getstatic       dev/falsehonesty/asmhelper/dsl/instructions/JumpCondition.GOTO:Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;
        //   886: aload           endLabel
        //   888: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.jump:(Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   891: pop            
        //   892: nop            
        //   893: goto            782
        //   896: nop            
        //   897: aload_0         /* this */
        //   898: aload           defaultLabel
        //   900: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   903: pop            
        //   904: aload           labels
        //   906: checkcast       Ljava/lang/Iterable;
        //   909: astore          $this$filter$iv
        //   911: iconst_0       
        //   912: istore          $i$f$filter
        //   914: aload           $this$filter$iv
        //   916: astore          12
        //   918: new             Ljava/util/ArrayList;
        //   921: dup            
        //   922: invokespecial   java/util/ArrayList.<init>:()V
        //   925: checkcast       Ljava/util/Collection;
        //   928: astore          destination$iv$iv
        //   930: iconst_0       
        //   931: istore          $i$f$filterTo
        //   933: aload           $this$filterTo$iv$iv
        //   935: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   940: astore          15
        //   942: aload           15
        //   944: invokeinterface java/util/Iterator.hasNext:()Z
        //   949: ifeq            1004
        //   952: aload           15
        //   954: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   959: astore          element$iv$iv
        //   961: aload           element$iv$iv
        //   963: checkcast       Lorg/objectweb/asm/tree/LabelNode;
        //   966: astore          it
        //   968: iconst_0       
        //   969: istore          $i$a$-filter-InsnListBuilder$tableswitch$4
        //   971: aload           usedLabels
        //   973: aload           it
        //   975: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   980: ifne            987
        //   983: iconst_1       
        //   984: goto            988
        //   987: iconst_0       
        //   988: ifeq            942
        //   991: aload           destination$iv$iv
        //   993: aload           element$iv$iv
        //   995: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //  1000: pop            
        //  1001: goto            942
        //  1004: aload           destination$iv$iv
        //  1006: checkcast       Ljava/util/List;
        //  1009: nop            
        //  1010: checkcast       Ljava/lang/Iterable;
        //  1013: astore          10
        //  1015: nop            
        //  1016: iconst_0       
        //  1017: istore          $i$f$forEach
        //  1019: aload           $this$forEach$iv
        //  1021: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //  1026: astore          12
        //  1028: aload           12
        //  1030: invokeinterface java/util/Iterator.hasNext:()Z
        //  1035: ifeq            1067
        //  1038: aload           12
        //  1040: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //  1045: astore          element$iv
        //  1047: aload           element$iv
        //  1049: checkcast       Lorg/objectweb/asm/tree/LabelNode;
        //  1052: astore          it
        //  1054: iconst_0       
        //  1055: istore          $i$a$-forEach-InsnListBuilder$tableswitch$5
        //  1057: aload_0         /* this */
        //  1058: aload           it
        //  1060: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //  1063: pop            
        //  1064: goto            1028
        //  1067: nop            
        //  1068: aload_2         /* tableBuilder */
        //  1069: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder.getDefaultCase$AsmHelper1_8_9:()Lkotlin/jvm/functions/Function1;
        //  1072: astore          10
        //  1074: aload           10
        //  1076: ifnonnull       1082
        //  1079: goto            1091
        //  1082: aload           10
        //  1084: aload_0         /* this */
        //  1085: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1090: pop            
        //  1091: aload_0         /* this */
        //  1092: aload           endLabel
        //  1094: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //  1097: pop            
        //  1098: return         
        //    Signature:
        //  (Lkotlin/jvm/functions/Function1<-Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder;Lkotlin/Unit;>;)V
        //    StackMapTable: 00 20 FF 00 38 00 06 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 00 00 FF 00 24 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 B9 01 07 02 B9 07 04 8F 01 07 02 AD 00 00 FF 00 5D 00 11 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 B9 01 07 02 B9 07 04 8F 01 07 02 AD 07 00 04 07 04 91 01 07 02 76 07 04 8F 01 07 00 04 00 00 42 07 00 04 FF 00 11 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 B9 01 07 02 B9 07 04 8F 01 07 02 AD 00 00 FF 00 15 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 02 B9 07 04 8F 01 07 02 AD 00 00 FF 00 14 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 04 8F 01 07 02 AD 07 00 04 00 00 FF 00 33 00 0C 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 04 8F 01 07 02 AD 07 04 A5 07 04 A5 01 00 00 40 01 FF 00 06 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 04 8F 01 07 02 AD 07 00 04 00 00 FF 00 00 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 00 04 00 00 07 00 04 00 01 01 0D FF 00 26 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 07 02 B9 01 07 02 AD 00 07 00 04 00 00 FF 00 15 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 07 02 B9 01 07 02 AD 01 01 00 00 2D FF 00 2A 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 01 07 02 B9 07 02 B9 01 07 02 AD 01 00 00 FC 00 15 01 2D FF 00 39 00 0D 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 B9 07 02 B9 01 07 02 B9 07 02 BE 01 07 02 AD 00 00 31 FF 00 46 00 0D 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 B9 07 02 BE 01 07 02 BE 00 07 07 00 02 08 02 A1 08 02 A1 01 01 07 02 9D 07 04 5E FF 00 3A 00 0D 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 CF 07 02 B9 01 07 02 AD 00 00 FF 00 6D 00 15 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 CF 07 02 B9 01 07 02 AD 07 00 04 07 04 91 01 07 02 9D 07 00 02 07 03 07 01 01 00 00 FF 00 03 00 0D 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 CF 07 02 B9 01 07 02 AD 00 00 FF 00 2D 00 10 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 CF 07 02 B9 01 07 02 B9 07 02 BE 01 07 02 AD 00 00 FE 00 2C 07 00 04 07 02 9D 01 40 01 F8 00 0F FF 00 17 00 0E 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 CF 07 02 B9 01 07 02 AD 07 00 04 00 00 26 FF 00 0E 00 0E 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 07 02 CF 07 02 9D 07 02 9D 07 02 CF 07 03 07 01 07 02 AD 07 00 04 00 00 08
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final void lookupswitch(@NotNull final Function1<? super SwitchBuilder, Unit> builder) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "builder"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: new             Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder;
        //    10: dup            
        //    11: invokespecial   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder.<init>:()V
        //    14: astore_3       
        //    15: iconst_0       
        //    16: istore          4
        //    18: iconst_0       
        //    19: istore          5
        //    21: aload_1         /* builder */
        //    22: aload_3        
        //    23: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    28: pop            
        //    29: aload_3        
        //    30: astore_2        /* tableBuilder */
        //    31: aload_2         /* tableBuilder */
        //    32: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder.getCases$AsmHelper1_8_9:()Ljava/util/List;
        //    35: astore_3        /* cases */
        //    36: aload_3         /* cases */
        //    37: invokeinterface java/util/List.isEmpty:()Z
        //    42: ifeq            56
        //    45: new             Ljava/lang/IllegalStateException;
        //    48: dup            
        //    49: ldc_w           "lookupswitch builder must have at least one case."
        //    52: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    55: athrow         
        //    56: aload_3         /* cases */
        //    57: checkcast       Ljava/lang/Iterable;
        //    60: astore          $this$groupBy$iv
        //    62: iconst_0       
        //    63: istore          $i$f$groupBy
        //    65: aload           $this$groupBy$iv
        //    67: astore          6
        //    69: new             Ljava/util/LinkedHashMap;
        //    72: dup            
        //    73: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    76: checkcast       Ljava/util/Map;
        //    79: astore          destination$iv$iv
        //    81: iconst_0       
        //    82: istore          $i$f$groupByTo
        //    84: aload           $this$groupByTo$iv$iv
        //    86: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    91: astore          9
        //    93: aload           9
        //    95: invokeinterface java/util/Iterator.hasNext:()Z
        //   100: ifeq            208
        //   103: aload           9
        //   105: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   110: astore          element$iv$iv
        //   112: aload           element$iv$iv
        //   114: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   117: astore          it
        //   119: iconst_0       
        //   120: istore          $i$a$-groupBy-InsnListBuilder$lookupswitch$1
        //   122: aload           it
        //   124: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   127: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   130: astore          key$iv$iv
        //   132: aload           destination$iv$iv
        //   134: astore          $this$getOrPut$iv$iv$iv
        //   136: iconst_0       
        //   137: istore          $i$f$getOrPut
        //   139: aload           $this$getOrPut$iv$iv$iv
        //   141: aload           key$iv$iv
        //   143: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: astore          value$iv$iv$iv
        //   150: aload           value$iv$iv$iv
        //   152: ifnonnull       187
        //   155: iconst_0       
        //   156: istore          $i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1$iv$iv
        //   158: new             Ljava/util/ArrayList;
        //   161: dup            
        //   162: invokespecial   java/util/ArrayList.<init>:()V
        //   165: checkcast       Ljava/util/List;
        //   168: astore          answer$iv$iv$iv
        //   170: aload           $this$getOrPut$iv$iv$iv
        //   172: aload           key$iv$iv
        //   174: aload           answer$iv$iv$iv
        //   176: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   181: pop            
        //   182: aload           answer$iv$iv$iv
        //   184: goto            190
        //   187: aload           value$iv$iv$iv
        //   189: nop            
        //   190: checkcast       Ljava/util/List;
        //   193: astore          list$iv$iv
        //   195: aload           list$iv$iv
        //   197: aload           element$iv$iv
        //   199: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   204: pop            
        //   205: goto            93
        //   208: aload           destination$iv$iv
        //   210: nop            
        //   211: astore          $this$any$iv
        //   213: iconst_0       
        //   214: istore          $i$f$any
        //   216: aload           $this$any$iv
        //   218: invokeinterface java/util/Map.isEmpty:()Z
        //   223: ifeq            230
        //   226: iconst_0       
        //   227: goto            312
        //   230: aload           $this$any$iv
        //   232: astore          6
        //   234: iconst_0       
        //   235: istore          7
        //   237: aload           6
        //   239: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   244: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   249: astore          8
        //   251: aload           8
        //   253: invokeinterface java/util/Iterator.hasNext:()Z
        //   258: ifeq            311
        //   261: aload           8
        //   263: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   268: checkcast       Ljava/util/Map$Entry;
        //   271: astore          element$iv
        //   273: aload           element$iv
        //   275: astore          it
        //   277: iconst_0       
        //   278: istore          $i$a$-any-InsnListBuilder$lookupswitch$2
        //   280: aload           it
        //   282: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   287: checkcast       Ljava/util/List;
        //   290: invokeinterface java/util/List.size:()I
        //   295: iconst_1       
        //   296: if_icmpeq       303
        //   299: iconst_1       
        //   300: goto            304
        //   303: iconst_0       
        //   304: ifeq            251
        //   307: iconst_1       
        //   308: goto            312
        //   311: iconst_0       
        //   312: ifeq            326
        //   315: new             Ljava/lang/IllegalStateException;
        //   318: dup            
        //   319: ldc_w           "lookupswitch builder cannot contain duplicate cases."
        //   322: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   325: athrow         
        //   326: aload_3         /* cases */
        //   327: checkcast       Ljava/util/Collection;
        //   330: invokestatic    kotlin/collections/CollectionsKt.getIndices:(Ljava/util/Collection;)Lkotlin/ranges/IntRange;
        //   333: checkcast       Ljava/lang/Iterable;
        //   336: astore          $this$map$iv
        //   338: iconst_0       
        //   339: istore          $i$f$map
        //   341: aload           $this$map$iv
        //   343: astore          7
        //   345: new             Ljava/util/ArrayList;
        //   348: dup            
        //   349: aload           $this$map$iv
        //   351: bipush          10
        //   353: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   356: invokespecial   java/util/ArrayList.<init>:(I)V
        //   359: checkcast       Ljava/util/Collection;
        //   362: astore          destination$iv$iv
        //   364: iconst_0       
        //   365: istore          $i$f$mapTo
        //   367: aload           $this$mapTo$iv$iv
        //   369: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   374: astore          10
        //   376: aload           10
        //   378: invokeinterface java/util/Iterator.hasNext:()Z
        //   383: ifeq            426
        //   386: aload           10
        //   388: checkcast       Lkotlin/collections/IntIterator;
        //   391: invokevirtual   kotlin/collections/IntIterator.nextInt:()I
        //   394: istore          item$iv$iv
        //   396: aload           destination$iv$iv
        //   398: iload           item$iv$iv
        //   400: istore          12
        //   402: astore          22
        //   404: iconst_0       
        //   405: istore          $i$a$-map-InsnListBuilder$lookupswitch$labels$1
        //   407: aload_0         /* this */
        //   408: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.makeLabel:()Lorg/objectweb/asm/tree/LabelNode;
        //   411: astore          23
        //   413: aload           22
        //   415: aload           23
        //   417: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   422: pop            
        //   423: goto            376
        //   426: aload           destination$iv$iv
        //   428: checkcast       Ljava/util/List;
        //   431: nop            
        //   432: astore          labels
        //   434: aload_0         /* this */
        //   435: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.makeLabel:()Lorg/objectweb/asm/tree/LabelNode;
        //   438: astore          defaultLabel
        //   440: aload_0         /* this */
        //   441: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.makeLabel:()Lorg/objectweb/asm/tree/LabelNode;
        //   444: astore          endLabel
        //   446: aload_0         /* this */
        //   447: aload           defaultLabel
        //   449: aload_3         /* cases */
        //   450: checkcast       Ljava/lang/Iterable;
        //   453: astore          7
        //   455: astore          25
        //   457: astore          22
        //   459: iconst_0       
        //   460: istore          $i$f$map
        //   462: aload           $this$map$iv
        //   464: astore          9
        //   466: new             Ljava/util/ArrayList;
        //   469: dup            
        //   470: aload           $this$map$iv
        //   472: bipush          10
        //   474: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   477: invokespecial   java/util/ArrayList.<init>:(I)V
        //   480: checkcast       Ljava/util/Collection;
        //   483: astore          destination$iv$iv
        //   485: iconst_0       
        //   486: istore          $i$f$mapTo
        //   488: aload           $this$mapTo$iv$iv
        //   490: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   495: astore          12
        //   497: aload           12
        //   499: invokeinterface java/util/Iterator.hasNext:()Z
        //   504: ifeq            553
        //   507: aload           12
        //   509: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   514: astore          item$iv$iv
        //   516: aload           destination$iv$iv
        //   518: aload           item$iv$iv
        //   520: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   523: astore          14
        //   525: astore          26
        //   527: iconst_0       
        //   528: istore          $i$a$-map-InsnListBuilder$lookupswitch$3
        //   530: aload           it
        //   532: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getIndex:()I
        //   535: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   538: astore          27
        //   540: aload           26
        //   542: aload           27
        //   544: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   549: pop            
        //   550: goto            497
        //   553: aload           destination$iv$iv
        //   555: checkcast       Ljava/util/List;
        //   558: nop            
        //   559: astore          26
        //   561: aload           22
        //   563: aload           25
        //   565: aload           26
        //   567: checkcast       Ljava/util/Collection;
        //   570: invokestatic    kotlin/collections/CollectionsKt.toIntArray:(Ljava/util/Collection;)[I
        //   573: aload           labels
        //   575: checkcast       Ljava/util/Collection;
        //   578: astore          $this$toTypedArray$iv
        //   580: iconst_0       
        //   581: istore          $i$f$toTypedArray
        //   583: aload           $this$toTypedArray$iv
        //   585: astore          thisCollection$iv
        //   587: aload           thisCollection$iv
        //   589: iconst_0       
        //   590: anewarray       Lorg/objectweb/asm/tree/LabelNode;
        //   593: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   598: dup            
        //   599: ifnonnull       613
        //   602: new             Ljava/lang/NullPointerException;
        //   605: dup            
        //   606: ldc_w           "null cannot be cast to non-null type kotlin.Array<T>"
        //   609: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   612: athrow         
        //   613: checkcast       [Lorg/objectweb/asm/tree/LabelNode;
        //   616: astore          28
        //   618: astore          29
        //   620: astore          30
        //   622: new             Lorg/objectweb/asm/tree/LookupSwitchInsnNode;
        //   625: dup            
        //   626: aload           30
        //   628: aload           29
        //   630: aload           28
        //   632: invokespecial   org/objectweb/asm/tree/LookupSwitchInsnNode.<init>:(Lorg/objectweb/asm/tree/LabelNode;[I[Lorg/objectweb/asm/tree/LabelNode;)V
        //   635: checkcast       Lorg/objectweb/asm/tree/AbstractInsnNode;
        //   638: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.insn$AsmHelper1_8_9:(Lorg/objectweb/asm/tree/AbstractInsnNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   641: pop            
        //   642: aload_3         /* cases */
        //   643: checkcast       Ljava/lang/Iterable;
        //   646: astore          $this$forEachIndexed$iv
        //   648: iconst_0       
        //   649: istore          $i$f$forEachIndexed
        //   651: iconst_0       
        //   652: istore          index$iv
        //   654: aload           $this$forEachIndexed$iv
        //   656: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   661: astore          10
        //   663: aload           10
        //   665: invokeinterface java/util/Iterator.hasNext:()Z
        //   670: ifeq            783
        //   673: aload           10
        //   675: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   680: astore          item$iv
        //   682: iload           index$iv
        //   684: iinc            index$iv, 1
        //   687: istore          12
        //   689: iconst_0       
        //   690: istore          13
        //   692: iload           12
        //   694: ifge            700
        //   697: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //   700: iload           12
        //   702: aload           item$iv
        //   704: checkcast       Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case;
        //   707: astore          14
        //   709: istore          index
        //   711: iconst_0       
        //   712: istore          $i$a$-forEachIndexed-InsnListBuilder$lookupswitch$4
        //   714: aload           labels
        //   716: iload           index
        //   718: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   723: checkcast       Lorg/objectweb/asm/tree/LabelNode;
        //   726: astore          label
        //   728: aload_0         /* this */
        //   729: aload           label
        //   731: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   734: pop            
        //   735: aload_0         /* this */
        //   736: astore          18
        //   738: aload           case
        //   740: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getBuilder:()Lkotlin/jvm/functions/Function1;
        //   743: astore          19
        //   745: iconst_0       
        //   746: istore          20
        //   748: iconst_0       
        //   749: istore          21
        //   751: aload           19
        //   753: aload           18
        //   755: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   760: pop            
        //   761: aload           case
        //   763: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder$Case.getFallthrough:()Z
        //   766: ifne            779
        //   769: aload_0         /* this */
        //   770: getstatic       dev/falsehonesty/asmhelper/dsl/instructions/JumpCondition.GOTO:Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;
        //   773: aload           endLabel
        //   775: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.jump:(Ldev/falsehonesty/asmhelper/dsl/instructions/JumpCondition;Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   778: pop            
        //   779: nop            
        //   780: goto            663
        //   783: nop            
        //   784: aload_0         /* this */
        //   785: aload           defaultLabel
        //   787: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   790: pop            
        //   791: aload_2         /* tableBuilder */
        //   792: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder.getDefaultCase$AsmHelper1_8_9:()Lkotlin/jvm/functions/Function1;
        //   795: astore          7
        //   797: aload           7
        //   799: ifnonnull       805
        //   802: goto            814
        //   805: aload           7
        //   807: aload_0         /* this */
        //   808: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   813: pop            
        //   814: aload_0         /* this */
        //   815: aload           endLabel
        //   817: invokevirtual   dev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder.placeLabel:(Lorg/objectweb/asm/tree/LabelNode;)Ldev/falsehonesty/asmhelper/dsl/instructions/InsnListBuilder;
        //   820: pop            
        //   821: return         
        //    Signature:
        //  (Lkotlin/jvm/functions/Function1<-Ldev/falsehonesty/asmhelper/dsl/instructions/SwitchBuilder;Lkotlin/Unit;>;)V
        //    StackMapTable: 00 17 FF 00 38 00 06 07 00 02 07 03 07 07 04 7D 07 02 CF 01 01 00 00 FF 00 24 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 B9 01 07 02 B9 07 04 8F 01 07 02 AD 00 00 FF 00 5D 00 11 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 B9 01 07 02 B9 07 04 8F 01 07 02 AD 07 00 04 07 04 91 01 07 02 76 07 04 8F 01 07 00 04 00 00 42 07 00 04 FF 00 11 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 B9 01 07 02 B9 07 04 8F 01 07 02 AD 00 00 FF 00 15 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 02 B9 07 04 8F 01 07 02 AD 00 00 FF 00 14 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 04 8F 01 07 02 AD 07 00 04 00 00 FF 00 33 00 0C 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 04 8F 01 07 02 AD 07 04 A5 07 04 A5 01 00 00 40 01 FF 00 06 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 04 8F 01 07 02 AD 07 00 04 00 00 FF 00 00 00 0A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 01 07 00 04 00 00 07 00 04 00 01 01 0D FF 00 31 00 0B 07 00 02 07 03 07 07 04 7D 07 02 CF 07 04 8F 07 02 B9 01 07 02 B9 07 02 BE 01 07 02 AD 00 00 31 FF 00 46 00 1A 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 02 B9 01 07 02 B9 07 02 BE 01 07 02 AD 00 00 00 00 00 00 00 00 00 07 00 02 00 00 07 02 9D 00 00 37 FF 00 3B 00 1B 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 02 BE 01 07 02 BE 07 02 BE 01 07 02 AD 00 00 00 00 00 00 00 00 00 07 00 02 00 00 07 02 9D 07 02 CF 00 04 07 00 02 07 02 9D 07 05 1A 07 04 5E FF 00 31 00 1F 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 02 B9 01 01 07 02 AD 00 00 00 00 00 00 00 00 00 00 00 07 00 02 00 00 07 02 9D 07 02 CF 00 07 04 CB 07 05 1A 07 02 9D 00 00 FF 00 24 00 1F 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 02 B9 01 01 07 02 AD 07 00 04 01 01 00 00 00 00 00 00 00 00 07 00 02 00 00 07 02 9D 07 02 CF 00 07 04 CB 07 05 1A 07 02 9D 00 00 FF 00 4E 00 1F 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 02 B9 01 01 07 02 AD 07 00 04 01 01 07 04 91 01 01 07 02 9D 07 00 02 07 03 07 01 01 07 00 02 00 00 07 02 9D 07 02 CF 00 07 04 CB 07 05 1A 07 02 9D 00 00 FF 00 03 00 1F 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 02 B9 01 01 07 02 AD 00 00 00 00 00 00 00 00 00 00 00 07 00 02 00 00 07 02 9D 07 02 CF 00 07 04 CB 07 05 1A 07 02 9D 00 00 FF 00 15 00 1F 07 00 02 07 03 07 07 04 7D 07 02 CF 07 02 CF 07 02 9D 07 02 9D 07 03 07 01 01 07 02 AD 00 00 00 00 00 00 00 00 00 00 00 07 00 02 00 00 07 02 9D 07 02 CF 00 07 04 CB 07 05 1A 07 02 9D 00 00 08
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public final Local astore() {
        this.astore(this.currentLocalIndex);
        return new Local(this.currentLocalIndex++, LocalType.OBJECT);
    }
    
    @NotNull
    public final Local fstore() {
        this.fstore(this.currentLocalIndex);
        return new Local(this.currentLocalIndex++, LocalType.FLOAT);
    }
    
    @NotNull
    public final Local istore() {
        this.istore(this.currentLocalIndex);
        return new Local(this.currentLocalIndex++, LocalType.INT);
    }
    
    @NotNull
    public final Local dstore() {
        this.dstore(this.currentLocalIndex);
        return new Local(this.currentLocalIndex++, LocalType.DOUBLE);
    }
    
    @NotNull
    public final Local lstore() {
        this.lstore(this.currentLocalIndex);
        return new Local(this.currentLocalIndex++, LocalType.LONG);
    }
    
    @NotNull
    public final InsnListBuilder load(@NotNull final Local local) {
        Intrinsics.checkNotNullParameter((Object)local, "local");
        final InsnListBuilder $this$load_u24lambda_u2d179 = this;
        final int n = 0;
        switch (WhenMappings.$EnumSwitchMapping$0[local.getType().ordinal()]) {
            case 1: {
                $this$load_u24lambda_u2d179.aload(local.getIndex());
                break;
            }
            case 2: {
                $this$load_u24lambda_u2d179.fload(local.getIndex());
                break;
            }
            case 3: {
                $this$load_u24lambda_u2d179.iload(local.getIndex());
                break;
            }
            case 4: {
                $this$load_u24lambda_u2d179.dload(local.getIndex());
                break;
            }
            case 5: {
                $this$load_u24lambda_u2d179.lload(local.getIndex());
                break;
            }
        }
        return this;
    }
    
    @NotNull
    public final InsnListBuilder insertInsns(@NotNull final InsnList list) {
        Intrinsics.checkNotNullParameter((Object)list, "list");
        final InsnListBuilder $this$insertInsns_u24lambda_u2d180 = this;
        final int n = 0;
        $this$insertInsns_u24lambda_u2d180.getInsnList().add(list);
        return this;
    }
    
    @NotNull
    public final InsnList build() {
        return this.insnList;
    }
    
    @NotNull
    public final InsnListBuilder insn$AsmHelper1_8_9(@NotNull final AbstractInsnNode node) {
        Intrinsics.checkNotNullParameter((Object)node, "node");
        final InsnListBuilder $this$insn_u24lambda_u2d181 = this;
        final int n = 0;
        $this$insn_u24lambda_u2d181.getInsnList().add(node);
        return this;
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeKObjectFunction(@NotNull final String objectClassName, @NotNull final String methodName, @NotNull final String methodDesc) {
        Intrinsics.checkNotNullParameter((Object)objectClassName, "objectClassName");
        Intrinsics.checkNotNullParameter((Object)methodName, "methodName");
        Intrinsics.checkNotNullParameter((Object)methodDesc, "methodDesc");
        return invokeKObjectFunction$default(this, objectClassName, methodName, methodDesc, null, 8, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder createInstance(@NotNull final String className, @NotNull final String constructorDescription) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)constructorDescription, "constructorDescription");
        return createInstance$default(this, className, constructorDescription, null, 4, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invoke(@NotNull final InvokeType type, @NotNull final Descriptor descriptor) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)descriptor, "descriptor");
        return invoke$default(this, type, descriptor, null, 4, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeStatic(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return invokeStatic$default(this, owner, name, desc, null, 8, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeVirtual(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return invokeVirtual$default(this, owner, name, desc, null, 8, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeSpecial(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return invokeSpecial$default(this, owner, name, desc, null, 8, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeInterface(@NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return invokeInterface$default(this, owner, name, desc, null, 8, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invokeDynamic(@NotNull final String owner, @NotNull final String name, @NotNull final String desc, @NotNull final Handle bootstrapMethod, @NotNull final Object... bootstrapConstantArgs) {
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        Intrinsics.checkNotNullParameter((Object)bootstrapMethod, "bootstrapMethod");
        Intrinsics.checkNotNullParameter((Object)bootstrapConstantArgs, "bootstrapConstantArgs");
        return invokeDynamic$default(this, owner, name, desc, bootstrapMethod, bootstrapConstantArgs, null, 32, null);
    }
    
    @JvmOverloads
    @NotNull
    public final InsnListBuilder invoke(@NotNull final InvokeType type, @NotNull final String owner, @NotNull final String name, @NotNull final String desc) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        Intrinsics.checkNotNullParameter((Object)owner, "owner");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)desc, "desc");
        return invoke$default(this, type, owner, name, desc, null, 16, null);
    }
}
