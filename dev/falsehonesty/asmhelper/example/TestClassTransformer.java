//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.example;

import dev.falsehonesty.asmhelper.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.functions.*;
import dev.falsehonesty.asmhelper.dsl.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006+" }, d2 = { "Ldev/falsehonesty/asmhelper/example/TestClassTransformer;", "Ldev/falsehonesty/asmhelper/BaseClassTransformer;", "()V", "CANCELLABLE_EVENT", "", "getCANCELLABLE_EVENT", "()Ljava/lang/String;", "CLIENT_LISTENER", "getCLIENT_LISTENER", "CRASH_REPORT_CATEGORY", "getCRASH_REPORT_CATEGORY", "EFFECT_RENDERER", "getEFFECT_RENDERER", "ENTITY", "getENTITY", "ENTITY_FX", "getENTITY_FX", "ENTITY_ITEM", "getENTITY_ITEM", "ENTITY_PLAYER", "getENTITY_PLAYER", "FILE", "getFILE", "FRAME_BUFFER", "getFRAME_BUFFER", "ICHAT_COMPONENT", "getICHAT_COMPONENT", "INVENTORY_PLAYER", "getINVENTORY_PLAYER", "ITEM_STACK", "getITEM_STACK", "PACKET", "getPACKET", "TRIGGER_TYPE", "getTRIGGER_TYPE", "injectCountField", "", "injectCountPrint", "injectDrawSplashScreen", "injectEntityPlayer", "injectPrintInGameLoop", "injectSuper", "makeTransformers", "AsmHelper1.8.9" })
public final class TestClassTransformer extends BaseClassTransformer
{
    @NotNull
    private final String CANCELLABLE_EVENT;
    @NotNull
    private final String CLIENT_LISTENER;
    @NotNull
    private final String CRASH_REPORT_CATEGORY;
    @NotNull
    private final String EFFECT_RENDERER;
    @NotNull
    private final String ENTITY;
    @NotNull
    private final String ENTITY_FX;
    @NotNull
    private final String ENTITY_ITEM;
    @NotNull
    private final String ENTITY_PLAYER;
    @NotNull
    private final String FILE;
    @NotNull
    private final String FRAME_BUFFER;
    @NotNull
    private final String ICHAT_COMPONENT;
    @NotNull
    private final String INVENTORY_PLAYER;
    @NotNull
    private final String ITEM_STACK;
    @NotNull
    private final String PACKET;
    @NotNull
    private final String TRIGGER_TYPE;
    
    public TestClassTransformer() {
        this.CANCELLABLE_EVENT = "com/chattriggers/ctjs/minecraft/listeners/CancellableEvent";
        this.CLIENT_LISTENER = "com/chattriggers/ctjs/minecraft/listeners/ClientListener";
        this.CRASH_REPORT_CATEGORY = "net/minecraft/crash/CrashReportCategory";
        this.EFFECT_RENDERER = "net/minecraft/client/particle/EffectRenderer";
        this.ENTITY = "net/minecraft/entity/Entity";
        this.ENTITY_FX = "net/minecraft/client/particle/EntityFX";
        this.ENTITY_ITEM = "net/minecraft/entity/item/EntityItem";
        this.ENTITY_PLAYER = "net/minecraft/entity/player/EntityPlayer";
        this.FILE = "java/io/File";
        this.FRAME_BUFFER = "net/minecraft/client/shader/Framebuffer";
        this.ICHAT_COMPONENT = "net/minecraft/util/IChatComponent";
        this.INVENTORY_PLAYER = "net/minecraft/entity/player/InventoryPlayer";
        this.ITEM_STACK = "net/minecraft/item/ItemStack";
        this.PACKET = "net/minecraft/network/Packet";
        this.TRIGGER_TYPE = "com/chattriggers/ctjs/triggers/TriggerType";
    }
    
    @NotNull
    public final String getCANCELLABLE_EVENT() {
        return this.CANCELLABLE_EVENT;
    }
    
    @NotNull
    public final String getCLIENT_LISTENER() {
        return this.CLIENT_LISTENER;
    }
    
    @NotNull
    public final String getCRASH_REPORT_CATEGORY() {
        return this.CRASH_REPORT_CATEGORY;
    }
    
    @NotNull
    public final String getEFFECT_RENDERER() {
        return this.EFFECT_RENDERER;
    }
    
    @NotNull
    public final String getENTITY() {
        return this.ENTITY;
    }
    
    @NotNull
    public final String getENTITY_FX() {
        return this.ENTITY_FX;
    }
    
    @NotNull
    public final String getENTITY_ITEM() {
        return this.ENTITY_ITEM;
    }
    
    @NotNull
    public final String getENTITY_PLAYER() {
        return this.ENTITY_PLAYER;
    }
    
    @NotNull
    public final String getFILE() {
        return this.FILE;
    }
    
    @NotNull
    public final String getFRAME_BUFFER() {
        return this.FRAME_BUFFER;
    }
    
    @NotNull
    public final String getICHAT_COMPONENT() {
        return this.ICHAT_COMPONENT;
    }
    
    @NotNull
    public final String getINVENTORY_PLAYER() {
        return this.INVENTORY_PLAYER;
    }
    
    @NotNull
    public final String getITEM_STACK() {
        return this.ITEM_STACK;
    }
    
    @NotNull
    public final String getPACKET() {
        return this.PACKET;
    }
    
    @NotNull
    public final String getTRIGGER_TYPE() {
        return this.TRIGGER_TYPE;
    }
    
    public void makeTransformers() {
        this.injectCountField();
        this.injectCountPrint();
        this.injectEntityPlayer();
        this.injectPrintInGameLoop();
    }
    
    private final void injectCountPrint() {
        Method.inject((Function1)TestClassTransformer$injectCountPrint.TestClassTransformer$injectCountPrint$1.INSTANCE);
    }
    
    private final void injectCountField() {
        Method.applyField((Function1)TestClassTransformer$injectCountField.TestClassTransformer$injectCountField$1.INSTANCE);
    }
    
    private final void injectEntityPlayer() {
        Method.inject((Function1)new TestClassTransformer$injectEntityPlayer.TestClassTransformer$injectEntityPlayer$1(this));
    }
    
    private final void injectSuper() {
        Method.inject((Function1)TestClassTransformer$injectSuper.TestClassTransformer$injectSuper$1.INSTANCE);
    }
    
    private final void injectDrawSplashScreen() {
        Method.overwrite((Function1)TestClassTransformer$injectDrawSplashScreen.TestClassTransformer$injectDrawSplashScreen$1.INSTANCE);
    }
    
    private final void injectPrintInGameLoop() {
        Method.inject((Function1)TestClassTransformer$injectPrintInGameLoop.TestClassTransformer$injectPrintInGameLoop$1.INSTANCE);
    }
}
