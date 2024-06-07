//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs.renderer;

import kotlin.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.entity.*;
import kotlin.jvm.internal.*;
import com.chattriggers.ctjs.minecraft.libs.*;
import kotlin.jvm.*;
import net.minecraft.client.renderer.vertex.*;
import kotlin.collections.*;
import kotlin.text.*;
import java.util.*;
import com.chattriggers.ctjs.minecraft.wrappers.entity.*;
import com.chattriggers.ctjs.minecraft.wrappers.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.entity.*;
import com.chattriggers.ctjs.utils.kotlin.*;
import net.minecraft.client.gui.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0093\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010K\u001a\u00020L2\u0014\u0010M\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020L0O0NH\u0002¢\u0006\u0002\u0010PJ*\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\b\b\u0002\u0010U\u001a\u00020\u0004H\u0007J*\u0010V\u001a\u00020W2\u0006\u0010R\u001a\u00020L2\u0006\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020L2\b\b\u0002\u0010U\u001a\u00020LH\u0007J\u0015\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u0004H\u0000¢\u0006\u0002\bZJ:\u0010[\u001a\u00020W2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020L2\u0006\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020<2\b\b\u0002\u0010;\u001a\u00020<H\u0007J0\u0010`\u001a\u00020W2\u0006\u0010a\u001a\u00020b2\u0006\u0010\\\u001a\u00020c2\u0006\u0010]\u001a\u00020c2\u0006\u0010d\u001a\u00020c2\u0006\u0010e\u001a\u00020cH\u0007JB\u0010f\u001a\u00020W2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020L2\u0006\u0010i\u001a\u00020L2\u0006\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007J\\\u0010l\u001a\u00020W2\u0006\u0010m\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u00020<2\b\b\u0002\u0010n\u001a\u00020C2\b\b\u0002\u0010o\u001a\u00020C2\b\b\u0002\u0010p\u001a\u00020C2\b\b\u0002\u0010q\u001a\u00020C2\b\b\u0002\u0010r\u001a\u00020C2\b\b\u0002\u0010s\u001a\u00020CH\u0007J0\u0010t\u001a\u00020W2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020L2\u0006\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020LH\u0007J?\u0010u\u001a\u00020W2\u0006\u0010Q\u001a\u00020\u00042\u001e\u0010v\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020L0O0N\"\b\u0012\u0004\u0012\u00020L0O2\b\b\u0002\u0010;\u001a\u00020<H\u0007¢\u0006\u0002\u0010wJ*\u0010x\u001a\u00020W2\u0006\u0010y\u001a\u00020z2\u0006\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020L2\b\b\u0002\u0010{\u001a\u00020CH\u0007J \u0010|\u001a\u00020W2\u0006\u0010y\u001a\u00020z2\u0006\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020LH\u0007J\b\u0010}\u001a\u00020WH\u0007J\u0010\u0010~\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004H\u0007J\u0010\u0010\u007f\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020<H\u0007J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010<H\u0007¢\u0006\u0003\u0010\u0081\u0001J\n\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0007J\u001d\u0010\u0084\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020L2\t\b\u0002\u0010\u0086\u0001\u001a\u00020LH\u0007J\u001e\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0085\u0001\u001a\u00020L2\t\b\u0002\u0010\u0086\u0001\u001a\u00020LH\u0007J\t\u0010\u0089\u0001\u001a\u00020AH\u0007J\u0011\u0010\u008a\u0001\u001a\u00020<2\u0006\u0010y\u001a\u00020zH\u0007J\u0011\u0010B\u001a\u00020W2\u0007\u0010\u008b\u0001\u001a\u00020CH\u0007J\u0011\u0010n\u001a\u00020W2\u0007\u0010\u008c\u0001\u001a\u00020LH\u0007J\u001d\u0010\u008d\u0001\u001a\u00020W2\u0007\u0010\u008e\u0001\u001a\u00020L2\t\b\u0002\u0010\u008f\u0001\u001a\u00020LH\u0007J\u0011\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<H\u0007J$\u0010\u0091\u0001\u001a\u00020W2\u0006\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020L2\t\b\u0002\u0010\u0092\u0001\u001a\u00020LH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u0007R\u001c\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0007R\u001c\u0010)\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0002\u001a\u0004\b+\u0010\u0007R\u001c\u0010,\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\u0007R\u001c\u0010/\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\u0007R\u001c\u00102\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0002\u001a\u0004\b4\u0010\u0007R\u001e\u00105\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0012\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0004\n\u0002\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\n G*\u0004\u0018\u00010F0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u00060Ij\u0002`JX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Renderer;", "", "()V", "AQUA", "", "getAQUA$annotations", "getAQUA", "()J", "BLACK", "getBLACK$annotations", "getBLACK", "BLUE", "getBLUE$annotations", "getBLUE", "DARK_AQUA", "getDARK_AQUA$annotations", "getDARK_AQUA", "DARK_BLUE", "getDARK_BLUE$annotations", "getDARK_BLUE", "DARK_GRAY", "getDARK_GRAY$annotations", "getDARK_GRAY", "DARK_GREEN", "getDARK_GREEN$annotations", "getDARK_GREEN", "DARK_PURPLE", "getDARK_PURPLE$annotations", "getDARK_PURPLE", "DARK_RED", "getDARK_RED$annotations", "getDARK_RED", "GOLD", "getGOLD$annotations", "getGOLD", "GRAY", "getGRAY$annotations", "getGRAY", "GREEN", "getGREEN$annotations", "getGREEN", "LIGHT_PURPLE", "getLIGHT_PURPLE$annotations", "getLIGHT_PURPLE", "RED", "getRED$annotations", "getRED", "WHITE", "getWHITE$annotations", "getWHITE", "YELLOW", "getYELLOW$annotations", "getYELLOW", "colorized", "getColorized", "()Ljava/lang/Long;", "setColorized", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "drawMode", "", "Ljava/lang/Integer;", "normalCTRenderPlayer", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/CTRenderPlayer;", "renderManager", "Lnet/minecraft/client/renderer/entity/RenderManager;", "retainTransforms", "", "slimCTRenderPlayer", "tessellator", "Lnet/minecraft/client/renderer/Tessellator;", "kotlin.jvm.PlatformType", "worldRenderer", "Lnet/minecraft/client/renderer/WorldRenderer;", "Lcom/chattriggers/ctjs/utils/kotlin/MCWorldRenderer;", "area", "", "points", "", "", "([Ljava/util/List;)F", "color", "red", "green", "blue", "alpha", "colorize", "", "doColor", "longColor", "doColor$ctjs", "drawCircle", "x", "y", "radius", "steps", "drawImage", "image", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Image;", "", "width", "height", "drawLine", "x1", "y1", "x2", "y2", "thickness", "drawPlayer", "player", "rotate", "showNametag", "showArmor", "showCape", "showHeldItem", "showArrows", "drawRect", "drawShape", "vertexes", "(J[Ljava/util/List;I)V", "drawString", "text", "", "shadow", "drawStringWithShadow", "finishDraw", "fixAlpha", "getColor", "getDrawMode", "()Ljava/lang/Integer;", "getFontRenderer", "Lnet/minecraft/client/gui/FontRenderer;", "getRainbow", "step", "speed", "getRainbowColors", "", "getRenderManager", "getStringWidth", "retain", "angle", "scale", "scaleX", "scaleY", "setDrawMode", "translate", "z", "screen", "ctjs" })
public final class Renderer
{
    @NotNull
    public static final Renderer INSTANCE;
    @Nullable
    private static Long colorized;
    private static boolean retainTransforms;
    @Nullable
    private static Integer drawMode;
    private static final Tessellator tessellator;
    @NotNull
    private static final WorldRenderer worldRenderer;
    private static final long BLACK;
    private static final long DARK_BLUE;
    private static final long DARK_GREEN;
    private static final long DARK_AQUA;
    private static final long DARK_RED;
    private static final long DARK_PURPLE;
    private static final long GOLD;
    private static final long GRAY;
    private static final long DARK_GRAY;
    private static final long BLUE;
    private static final long GREEN;
    private static final long AQUA;
    private static final long RED;
    private static final long LIGHT_PURPLE;
    private static final long YELLOW;
    private static final long WHITE;
    @NotNull
    private static final RenderManager renderManager;
    @NotNull
    private static final CTRenderPlayer slimCTRenderPlayer;
    @NotNull
    private static final CTRenderPlayer normalCTRenderPlayer;
    
    private Renderer() {
    }
    
    @Nullable
    public final Long getColorized() {
        return Renderer.colorized;
    }
    
    public final void setColorized(@Nullable final Long <set-?>) {
        Renderer.colorized = <set-?>;
    }
    
    public static final long getBLACK() {
        return Renderer.BLACK;
    }
    
    public static final long getDARK_BLUE() {
        return Renderer.DARK_BLUE;
    }
    
    public static final long getDARK_GREEN() {
        return Renderer.DARK_GREEN;
    }
    
    public static final long getDARK_AQUA() {
        return Renderer.DARK_AQUA;
    }
    
    public static final long getDARK_RED() {
        return Renderer.DARK_RED;
    }
    
    public static final long getDARK_PURPLE() {
        return Renderer.DARK_PURPLE;
    }
    
    public static final long getGOLD() {
        return Renderer.GOLD;
    }
    
    public static final long getGRAY() {
        return Renderer.GRAY;
    }
    
    public static final long getDARK_GRAY() {
        return Renderer.DARK_GRAY;
    }
    
    public static final long getBLUE() {
        return Renderer.BLUE;
    }
    
    public static final long getGREEN() {
        return Renderer.GREEN;
    }
    
    public static final long getAQUA() {
        return Renderer.AQUA;
    }
    
    public static final long getRED() {
        return Renderer.RED;
    }
    
    public static final long getLIGHT_PURPLE() {
        return Renderer.LIGHT_PURPLE;
    }
    
    public static final long getYELLOW() {
        return Renderer.YELLOW;
    }
    
    public static final long getWHITE() {
        return Renderer.WHITE;
    }
    
    @JvmStatic
    public static final long getColor(final int color) {
        long n = 0L;
        switch (color) {
            case 0: {
                final Renderer instance = Renderer.INSTANCE;
                n = Renderer.BLACK;
                break;
            }
            case 1: {
                final Renderer instance2 = Renderer.INSTANCE;
                n = Renderer.DARK_BLUE;
                break;
            }
            case 2: {
                final Renderer instance3 = Renderer.INSTANCE;
                n = Renderer.DARK_GREEN;
                break;
            }
            case 3: {
                final Renderer instance4 = Renderer.INSTANCE;
                n = Renderer.DARK_AQUA;
                break;
            }
            case 4: {
                final Renderer instance5 = Renderer.INSTANCE;
                n = Renderer.DARK_RED;
                break;
            }
            case 5: {
                final Renderer instance6 = Renderer.INSTANCE;
                n = Renderer.DARK_PURPLE;
                break;
            }
            case 6: {
                final Renderer instance7 = Renderer.INSTANCE;
                n = Renderer.GOLD;
                break;
            }
            case 7: {
                final Renderer instance8 = Renderer.INSTANCE;
                n = Renderer.GRAY;
                break;
            }
            case 8: {
                final Renderer instance9 = Renderer.INSTANCE;
                n = Renderer.DARK_GRAY;
                break;
            }
            case 9: {
                final Renderer instance10 = Renderer.INSTANCE;
                n = Renderer.BLUE;
                break;
            }
            case 10: {
                final Renderer instance11 = Renderer.INSTANCE;
                n = Renderer.GREEN;
                break;
            }
            case 11: {
                final Renderer instance12 = Renderer.INSTANCE;
                n = Renderer.AQUA;
                break;
            }
            case 12: {
                final Renderer instance13 = Renderer.INSTANCE;
                n = Renderer.RED;
                break;
            }
            case 13: {
                final Renderer instance14 = Renderer.INSTANCE;
                n = Renderer.LIGHT_PURPLE;
                break;
            }
            case 14: {
                final Renderer instance15 = Renderer.INSTANCE;
                n = Renderer.YELLOW;
                break;
            }
            default: {
                final Renderer instance16 = Renderer.INSTANCE;
                n = Renderer.WHITE;
                break;
            }
        }
        return n;
    }
    
    @JvmStatic
    @NotNull
    public static final FontRenderer getFontRenderer() {
        final FontRenderer fontRendererObj = Client.Companion.getMinecraft().fontRendererObj;
        Intrinsics.checkNotNullExpressionValue((Object)fontRendererObj, "Client.getMinecraft().fontRendererObj");
        return fontRendererObj;
    }
    
    @JvmStatic
    @NotNull
    public static final RenderManager getRenderManager() {
        final RenderManager getRenderManager = Client.Companion.getMinecraft().getRenderManager();
        Intrinsics.checkNotNullExpressionValue((Object)getRenderManager, "Client.getMinecraft().renderManager");
        return getRenderManager;
    }
    
    @JvmStatic
    public static final int getStringWidth(@NotNull final String text) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final Renderer instance = Renderer.INSTANCE;
        return getFontRenderer().getStringWidth(ChatLib.addColor(text));
    }
    
    @JvmStatic
    @JvmOverloads
    public static final long color(final long red, final long green, final long blue, final long alpha) {
        return MathLib.clamp((int)alpha, 0, 255) * 16777216 + MathLib.clamp((int)red, 0, 255) * 65536 + MathLib.clamp((int)green, 0, 255) * 256 + MathLib.clamp((int)blue, 0, 255);
    }
    
    public static /* synthetic */ long color$default(final long red, final long green, final long blue, long alpha, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            alpha = 255L;
        }
        return color(red, green, blue, alpha);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final long getRainbow(final float step, final float speed) {
        final long red = (long)(((float)Math.sin(step / speed) + 0.75) * 170);
        final long green = (long)((Math.sin(step / speed + 2.0943951023931953) + 0.75) * 170);
        final long blue = (long)((Math.sin(step / speed + 4.1887902047863905) + 0.75) * 170);
        final Renderer instance = Renderer.INSTANCE;
        return color(red, green, blue, 255L);
    }
    
    public static /* synthetic */ long getRainbow$default(final float step, float speed, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            speed = 1.0f;
        }
        return getRainbow(step, speed);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final int[] getRainbowColors(final float step, final float speed) {
        final int red = (int)(((float)Math.sin(step / speed) + 0.75) * 170);
        final int green = (int)((Math.sin(step / speed + 2.0943951023931953) + 0.75) * 170);
        final int blue = (int)((Math.sin(step / speed + 4.1887902047863905) + 0.75) * 170);
        return new int[] { red, green, blue };
    }
    
    public static /* synthetic */ int[] getRainbowColors$default(final float step, float speed, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            speed = 1.0f;
        }
        return getRainbowColors(step, speed);
    }
    
    @JvmStatic
    public static final void retainTransforms(final boolean retain) {
        final Renderer instance = Renderer.INSTANCE;
        Renderer.retainTransforms = retain;
        final Renderer instance2 = Renderer.INSTANCE;
        finishDraw();
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void translate(final float x, final float y, final float z) {
        GlStateManager.translate(x, y, z);
    }
    
    public static /* synthetic */ void translate$default(final float x, final float y, float z, final int n, final Object o) {
        if ((n & 0x4) != 0x0) {
            z = 0.0f;
        }
        translate(x, y, z);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void scale(final float scaleX, final float scaleY) {
        GlStateManager.scale(scaleX, scaleY, 1.0f);
    }
    
    public static /* synthetic */ void scale$default(final float scaleX, float scaleY, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            scaleY = scaleX;
        }
        scale(scaleX, scaleY);
    }
    
    @JvmStatic
    public static final void rotate(final float angle) {
        GlStateManager.rotate(angle, 0.0f, 0.0f, 1.0f);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void colorize(final float red, final float green, final float blue, final float alpha) {
        final Renderer instance = Renderer.INSTANCE;
        final Renderer instance2 = Renderer.INSTANCE;
        final Renderer instance3 = Renderer.INSTANCE;
        Renderer.colorized = fixAlpha(color((long)red, (long)green, (long)blue, (long)alpha));
        GlStateManager.color(MathLib.clampFloat(red, 0.0f, 1.0f), MathLib.clampFloat(green, 0.0f, 1.0f), MathLib.clampFloat(blue, 0.0f, 1.0f), MathLib.clampFloat(alpha, 0.0f, 1.0f));
    }
    
    public static /* synthetic */ void colorize$default(final float red, final float green, final float blue, float alpha, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            alpha = 1.0f;
        }
        colorize(red, green, blue, alpha);
    }
    
    @JvmStatic
    @NotNull
    public static final Renderer setDrawMode(final int drawMode) {
        final Renderer $this$setDrawMode_u24lambda_u2d0 = Renderer.INSTANCE;
        final int n = 0;
        Renderer.drawMode = drawMode;
        return $this$setDrawMode_u24lambda_u2d0;
    }
    
    @JvmStatic
    @Nullable
    public static final Integer getDrawMode() {
        return Renderer.drawMode;
    }
    
    @JvmStatic
    public static final long fixAlpha(final long color) {
        final long alpha = color >> 24 & 0xFFL;
        return (alpha < 10L) ? ((color & 0xFFFFFFL) | 0xAFFFFFFL) : color;
    }
    
    @JvmStatic
    public static final void drawRect(final long color, final float x, final float y, final float width, final float height) {
        final List pos = CollectionsKt.mutableListOf((Object[])new Float[] { x, y, x + width, y + height });
        if (pos.get(0).floatValue() > pos.get(2).floatValue()) {
            Collections.swap(pos, 0, 2);
        }
        if (pos.get(1).floatValue() > pos.get(3).floatValue()) {
            Collections.swap(pos, 1, 3);
        }
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        Renderer.INSTANCE.doColor$ctjs(color);
        final WorldRenderer worldRenderer = Renderer.worldRenderer;
        final Integer drawMode = Renderer.drawMode;
        worldRenderer.begin((drawMode == null) ? 7 : ((int)drawMode), DefaultVertexFormats.POSITION);
        Renderer.worldRenderer.pos((double)pos.get(0).floatValue(), (double)pos.get(3).floatValue(), 0.0).endVertex();
        Renderer.worldRenderer.pos((double)pos.get(2).floatValue(), (double)pos.get(3).floatValue(), 0.0).endVertex();
        Renderer.worldRenderer.pos((double)pos.get(2).floatValue(), (double)pos.get(1).floatValue(), 0.0).endVertex();
        Renderer.worldRenderer.pos((double)pos.get(0).floatValue(), (double)pos.get(1).floatValue(), 0.0).endVertex();
        Renderer.tessellator.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        final Renderer instance = Renderer.INSTANCE;
        finishDraw();
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawShape(final long color, @NotNull final List<Float>[] vertexes, final int drawMode) {
        Intrinsics.checkNotNullParameter((Object)vertexes, "vertexes");
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        Renderer.INSTANCE.doColor$ctjs(color);
        final WorldRenderer worldRenderer = Renderer.worldRenderer;
        final Integer drawMode2 = Renderer.drawMode;
        worldRenderer.begin((drawMode2 == null) ? drawMode : ((int)drawMode2), DefaultVertexFormats.POSITION);
        if (Renderer.INSTANCE.area(vertexes) >= 0.0f) {
            ArraysKt.reverse((Object[])vertexes);
        }
        final Object[] $this$forEach$iv = vertexes;
        final int $i$f$forEach = 0;
        for (int i = 0; i < $this$forEach$iv.length; ++i) {
            final List it;
            final Object element$iv = it = (List)$this$forEach$iv[i];
            final int n = 0;
            Renderer.worldRenderer.pos((double)it.get(0).floatValue(), (double)it.get(1).floatValue(), 0.0).endVertex();
        }
        Renderer.tessellator.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        final Renderer instance = Renderer.INSTANCE;
        finishDraw();
    }
    
    public static /* synthetic */ void drawShape$default(final long color, final List[] vertexes, int drawMode, final int n, final Object o) {
        if ((n & 0x4) != 0x0) {
            drawMode = 9;
        }
        drawShape(color, vertexes, drawMode);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawLine(final long color, final float x1, final float y1, final float x2, final float y2, final float thickness, final int drawMode) {
        final float theta = -(float)Math.atan2(y2 - y1, x2 - x1);
        final float i = (float)Math.sin(theta) * (thickness / 2);
        final float j = (float)Math.cos(theta) * (thickness / 2);
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        Renderer.INSTANCE.doColor$ctjs(color);
        final WorldRenderer worldRenderer = Renderer.worldRenderer;
        final Integer drawMode2 = Renderer.drawMode;
        worldRenderer.begin((drawMode2 == null) ? drawMode : ((int)drawMode2), DefaultVertexFormats.POSITION);
        Renderer.worldRenderer.pos((double)(x1 + i), (double)(y1 + j), 0.0).endVertex();
        Renderer.worldRenderer.pos((double)(x2 + i), (double)(y2 + j), 0.0).endVertex();
        Renderer.worldRenderer.pos((double)(x2 - i), (double)(y2 - j), 0.0).endVertex();
        Renderer.worldRenderer.pos((double)(x1 - i), (double)(y1 - j), 0.0).endVertex();
        Renderer.tessellator.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        final Renderer instance = Renderer.INSTANCE;
        finishDraw();
    }
    
    public static /* synthetic */ void drawLine$default(final long color, final float x1, final float y1, final float x2, final float y2, final float thickness, int drawMode, final int n, final Object o) {
        if ((n & 0x40) != 0x0) {
            drawMode = 7;
        }
        drawLine(color, x1, y1, x2, y2, thickness, drawMode);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawCircle(final long color, final float x, final float y, final float radius, final int steps, final int drawMode) {
        final double theta = 6.283185307179586 / steps;
        final float cos = (float)Math.cos(theta);
        final float sin = (float)Math.sin(theta);
        float xHolder = 0.0f;
        float circleX = 1.0f;
        float circleY = 0.0f;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        Renderer.INSTANCE.doColor$ctjs(color);
        final WorldRenderer worldRenderer = Renderer.worldRenderer;
        final Integer drawMode2 = Renderer.drawMode;
        worldRenderer.begin((drawMode2 == null) ? drawMode : ((int)drawMode2), DefaultVertexFormats.POSITION);
        int n = 0;
        if (n <= steps) {
            int i;
            do {
                i = n;
                ++n;
                Renderer.worldRenderer.pos((double)x, (double)y, 0.0).endVertex();
                Renderer.worldRenderer.pos((double)(circleX * radius + x), (double)(circleY * radius + y), 0.0).endVertex();
                xHolder = circleX;
                circleX = cos * circleX - sin * circleY;
                circleY = sin * xHolder + cos * circleY;
                Renderer.worldRenderer.pos((double)(circleX * radius + x), (double)(circleY * radius + y), 0.0).endVertex();
            } while (i != steps);
        }
        Renderer.tessellator.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        final Renderer instance = Renderer.INSTANCE;
        finishDraw();
    }
    
    public static /* synthetic */ void drawCircle$default(final long color, final float x, final float y, final float radius, final int steps, int drawMode, final int n, final Object o) {
        if ((n & 0x20) != 0x0) {
            drawMode = 5;
        }
        drawCircle(color, x, y, radius, steps, drawMode);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y, final boolean shadow) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final Renderer instance = Renderer.INSTANCE;
        final FontRenderer fr = getFontRenderer();
        float newY = 0.0f;
        newY = y;
        final Iterable $this$forEach$iv = StringsKt.split$default((CharSequence)ChatLib.addColor(text), new String[] { "\n" }, false, 0, 6, (Object)null);
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final String it = (String)element$iv;
            final int n = 0;
            final FontRenderer fontRenderer = fr;
            final String s = it;
            final float n2 = newY;
            final Long colorized = Renderer.INSTANCE.getColorized();
            final Integer n3 = (colorized == null) ? null : Integer.valueOf((int)(long)colorized);
            fontRenderer.drawString(s, x, n2, (n3 == null) ? ((int)getWHITE()) : ((int)n3), shadow);
            newY += fr.FONT_HEIGHT;
        }
        final Renderer instance2 = Renderer.INSTANCE;
        finishDraw();
    }
    
    public static /* synthetic */ void drawString$default(final String text, final float x, final float y, boolean shadow, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            shadow = false;
        }
        drawString(text, x, y, shadow);
    }
    
    @JvmStatic
    public static final void drawStringWithShadow(@NotNull final String text, final float x, final float y) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        final Renderer instance = Renderer.INSTANCE;
        drawString(text, x, y, true);
    }
    
    @JvmStatic
    public static final void drawImage(@NotNull final Image image, final double x, final double y, final double width, final double height) {
        Intrinsics.checkNotNullParameter((Object)image, "image");
        final Renderer instance = Renderer.INSTANCE;
        if (Renderer.colorized == null) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        GlStateManager.enableBlend();
        GlStateManager.scale(1.0f, 1.0f, 50.0f);
        GlStateManager.bindTexture(image.getTexture().getGlTextureId());
        GlStateManager.enableTexture2D();
        final WorldRenderer worldRenderer = Renderer.worldRenderer;
        final Integer drawMode = Renderer.drawMode;
        worldRenderer.begin((drawMode == null) ? 7 : ((int)drawMode), DefaultVertexFormats.POSITION_TEX);
        Renderer.worldRenderer.pos(x, y + height, 0.0).tex(0.0, 1.0).endVertex();
        Renderer.worldRenderer.pos(x + width, y + height, 0.0).tex(1.0, 1.0).endVertex();
        Renderer.worldRenderer.pos(x + width, y, 0.0).tex(1.0, 0.0).endVertex();
        Renderer.worldRenderer.pos(x, y, 0.0).tex(0.0, 0.0).endVertex();
        Renderer.tessellator.draw();
        final Renderer instance2 = Renderer.INSTANCE;
        finishDraw();
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem, final boolean showArrows) {
        Intrinsics.checkNotNullParameter(player, "player");
        final float mouseX = -30.0f;
        final float mouseY = 0.0f;
        EntityPlayer player2;
        if (player instanceof PlayerMP) {
            player2 = ((PlayerMP)player).getPlayer();
        }
        else {
            final EntityPlayerSP player3 = Player.getPlayer();
            Intrinsics.checkNotNull((Object)player3);
            player2 = (EntityPlayer)player3;
        }
        final EntityPlayer ent = player2;
        GlStateManager.enableColorMaterial();
        RenderHelper.enableStandardItemLighting();
        final float f = ent.renderYawOffset;
        final float f2 = ent.rotationYaw;
        final float f3 = ent.rotationPitch;
        final float f4 = ent.prevRotationYawHead;
        final float f5 = ent.rotationYawHead;
        final Renderer instance = Renderer.INSTANCE;
        translate((float)x, (float)y, 50.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-45.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(mouseY / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        final Renderer instance2 = Renderer.INSTANCE;
        scale(-1.0f, 1.0f);
        if (!rotate) {
            ent.renderYawOffset = (float)Math.atan(mouseX / 40.0f) * 20.0f;
            ent.rotationYaw = (float)Math.atan(mouseX / 40.0f) * 40.0f;
            ent.rotationPitch = -(float)Math.atan(mouseY / 40.0f) * 20.0f;
            ent.rotationYawHead = ent.rotationYaw;
            ent.prevRotationYawHead = ent.rotationYaw;
        }
        Renderer.renderManager.playerViewY = 180.0f;
        Renderer.renderManager.setRenderShadow(false);
        final boolean isSmall = Intrinsics.areEqual((Object)((AbstractClientPlayer)ent).getSkinType(), (Object)"slim");
        final CTRenderPlayer ctRenderPlayer = isSmall ? Renderer.slimCTRenderPlayer : Renderer.normalCTRenderPlayer;
        ctRenderPlayer.setOptions(showNametag, showArmor, showCape, showHeldItem, showArrows);
        ctRenderPlayer.doRender((AbstractClientPlayer)ent, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        Renderer.renderManager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f2;
        ent.rotationPitch = f3;
        ent.prevRotationYawHead = f4;
        ent.rotationYawHead = f5;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        final Renderer instance3 = Renderer.INSTANCE;
        finishDraw();
    }
    
    public static /* synthetic */ void drawPlayer$default(final Object player, final int x, final int y, boolean rotate, boolean showNametag, boolean showArmor, boolean showCape, boolean showHeldItem, boolean showArrows, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            rotate = false;
        }
        if ((n & 0x10) != 0x0) {
            showNametag = false;
        }
        if ((n & 0x20) != 0x0) {
            showArmor = true;
        }
        if ((n & 0x40) != 0x0) {
            showCape = true;
        }
        if ((n & 0x80) != 0x0) {
            showHeldItem = true;
        }
        if ((n & 0x100) != 0x0) {
            showArrows = true;
        }
        drawPlayer(player, x, y, rotate, showNametag, showArmor, showCape, showHeldItem, showArrows);
    }
    
    public final void doColor$ctjs(final long longColor) {
        final int color = (int)longColor;
        if (Renderer.colorized == null) {
            final float a = (color >> 24 & 0xFF) / 255.0f;
            final float r = (color >> 16 & 0xFF) / 255.0f;
            final float g = (color >> 8 & 0xFF) / 255.0f;
            final float b = (color & 0xFF) / 255.0f;
            GlStateManager.color(r, g, b, a);
        }
    }
    
    @JvmStatic
    public static final void finishDraw() {
        if (!Renderer.retainTransforms) {
            final Renderer instance = Renderer.INSTANCE;
            Renderer.colorized = null;
            final Renderer instance2 = Renderer.INSTANCE;
            Renderer.drawMode = null;
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
        }
    }
    
    private final float area(final List<Float>[] points) {
        float area = 0.0f;
        int i;
        List<Float> list;
        float x1;
        float y1;
        List<Float> list2;
        float x2;
        float y2;
        for (int j = 0; j < points.length; ++j, list = points[i], x1 = list.get(0).floatValue(), y1 = list.get(1).floatValue(), list2 = points[(i + 1) % points.length], x2 = list2.get(0).floatValue(), y2 = list2.get(1).floatValue(), area += x1 * y2 - x2 * y1) {
            i = j;
        }
        return area / 2;
    }
    
    @JvmStatic
    @JvmOverloads
    public static final long color(final long red, final long green, final long blue) {
        return color$default(red, green, blue, 0L, 8, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final long getRainbow(final float step) {
        return getRainbow$default(step, 0.0f, 2, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final int[] getRainbowColors(final float step) {
        return getRainbowColors$default(step, 0.0f, 2, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void translate(final float x, final float y) {
        translate$default(x, y, 0.0f, 4, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void scale(final float scaleX) {
        scale$default(scaleX, 0.0f, 2, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void colorize(final float red, final float green, final float blue) {
        colorize$default(red, green, blue, 0.0f, 8, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawShape(final long color, @NotNull final List<Float>... vertexes) {
        Intrinsics.checkNotNullParameter((Object)vertexes, "vertexes");
        drawShape$default(color, vertexes, 0, 4, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawLine(final long color, final float x1, final float y1, final float x2, final float y2, final float thickness) {
        drawLine$default(color, x1, y1, x2, y2, thickness, 0, 64, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawCircle(final long color, final float x, final float y, final float radius, final int steps) {
        drawCircle$default(color, x, y, radius, steps, 0, 32, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawString(@NotNull final String text, final float x, final float y) {
        Intrinsics.checkNotNullParameter((Object)text, "text");
        drawString$default(text, x, y, false, 8, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape, final boolean showHeldItem) {
        Intrinsics.checkNotNullParameter(player, "player");
        drawPlayer$default(player, x, y, rotate, showNametag, showArmor, showCape, showHeldItem, false, 256, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor, final boolean showCape) {
        Intrinsics.checkNotNullParameter(player, "player");
        drawPlayer$default(player, x, y, rotate, showNametag, showArmor, showCape, false, false, 384, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag, final boolean showArmor) {
        Intrinsics.checkNotNullParameter(player, "player");
        drawPlayer$default(player, x, y, rotate, showNametag, showArmor, false, false, false, 448, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y, final boolean rotate, final boolean showNametag) {
        Intrinsics.checkNotNullParameter(player, "player");
        drawPlayer$default(player, x, y, rotate, showNametag, false, false, false, false, 480, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y, final boolean rotate) {
        Intrinsics.checkNotNullParameter(player, "player");
        drawPlayer$default(player, x, y, rotate, false, false, false, false, false, 496, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void drawPlayer(@NotNull final Object player, final int x, final int y) {
        Intrinsics.checkNotNullParameter(player, "player");
        drawPlayer$default(player, x, y, false, false, false, false, false, false, 504, null);
    }
    
    static {
        INSTANCE = new Renderer();
        tessellator = Tessellator.getInstance();
        final Tessellator tessellator2 = Renderer.tessellator;
        Intrinsics.checkNotNullExpressionValue((Object)tessellator2, "tessellator");
        worldRenderer = ExtensionsKt.getRenderer(tessellator2);
        BLACK = color(0L, 0L, 0L, 255L);
        DARK_BLUE = color(0L, 0L, 190L, 255L);
        DARK_GREEN = color(0L, 190L, 0L, 255L);
        DARK_AQUA = color(0L, 190L, 190L, 255L);
        DARK_RED = color(190L, 0L, 0L, 255L);
        DARK_PURPLE = color(190L, 0L, 190L, 255L);
        GOLD = color(217L, 163L, 52L, 255L);
        GRAY = color(190L, 190L, 190L, 255L);
        DARK_GRAY = color(63L, 63L, 63L, 255L);
        BLUE = color(63L, 63L, 254L, 255L);
        GREEN = color(63L, 254L, 63L, 255L);
        AQUA = color(63L, 254L, 254L, 255L);
        RED = color(254L, 63L, 63L, 255L);
        LIGHT_PURPLE = color(254L, 63L, 254L, 255L);
        YELLOW = color(254L, 254L, 63L, 255L);
        WHITE = color(255L, 255L, 255L, 255L);
        renderManager = getRenderManager();
        slimCTRenderPlayer = new CTRenderPlayer(Renderer.renderManager, true);
        normalCTRenderPlayer = new CTRenderPlayer(Renderer.renderManager, false);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Renderer$screen;", "", "()V", "getHeight", "", "getScale", "getWidth", "ctjs" })
    public static final class screen
    {
        @NotNull
        public static final screen INSTANCE;
        
        private screen() {
        }
        
        @JvmStatic
        public static final int getWidth() {
            return new ScaledResolution(Client.Companion.getMinecraft()).getScaledWidth();
        }
        
        @JvmStatic
        public static final int getHeight() {
            return new ScaledResolution(Client.Companion.getMinecraft()).getScaledHeight();
        }
        
        @JvmStatic
        public static final int getScale() {
            return new ScaledResolution(Client.Companion.getMinecraft()).getScaleFactor();
        }
        
        static {
            INSTANCE = new screen();
        }
    }
}
