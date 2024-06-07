//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.example;

import kotlin.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005" }, d2 = { "Ldev/falsehonesty/asmhelper/example/TestHelper;", "", "()V", "printMessage", "", "AsmHelper1.8.9" })
public final class TestHelper
{
    @NotNull
    public static final TestHelper INSTANCE;
    
    private TestHelper() {
    }
    
    public final void printMessage() {
        System.out.println((Object)"E");
    }
    
    static {
        INSTANCE = new TestHelper();
    }
}
