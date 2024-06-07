//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs.renderer;

import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.common.*;
import com.chattriggers.ctjs.*;
import kotlin.*;
import kotlin.jvm.internal.*;
import java.io.*;
import javax.imageio.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import kotlin.jvm.*;
import java.awt.image.*;
import javax.net.ssl.*;
import java.net.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J,\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0018H\u0007J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0012J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Image;", "", "name", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "image", "Ljava/awt/image/BufferedImage;", "(Ljava/awt/image/BufferedImage;)V", "getImage", "()Ljava/awt/image/BufferedImage;", "setImage", "texture", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "textureHeight", "", "textureWidth", "destroy", "", "draw", "x", "", "y", "width", "height", "getTexture", "getTextureHeight", "getTextureWidth", "onRender", "event", "Lnet/minecraftforge/client/event/RenderGameOverlayEvent$Pre;", "Companion", "ctjs" })
public final class Image
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private BufferedImage image;
    private DynamicTexture texture;
    private final int textureWidth;
    private final int textureHeight;
    
    public Image(@Nullable final BufferedImage image) {
        this.image = image;
        final BufferedImage image2 = this.image;
        this.textureWidth = ((image2 == null) ? 0 : image2.getWidth());
        final BufferedImage image3 = this.image;
        this.textureHeight = ((image3 == null) ? 0 : image3.getHeight());
        MinecraftForge.EVENT_BUS.register((Object)this);
        CTJS.INSTANCE.getImages().add(this);
    }
    
    @Nullable
    public final BufferedImage getImage() {
        return this.image;
    }
    
    public final void setImage(@Nullable final BufferedImage <set-?>) {
        this.image = <set-?>;
    }
    
    @Deprecated(message = "API is ambiguous, especially when called from JavaScript, and is relative to the assets directory", replaceWith = @ReplaceWith(expression = "Image.fromFile() /* or Image.fromUrl() */", imports = {}))
    @JvmOverloads
    @java.lang.Deprecated
    public Image(@NotNull final String name, @Nullable final String url) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        this(Image.Companion.getBufferedImage(name, url));
    }
    
    @Deprecated(message = "Use static method for consistency", replaceWith = @ReplaceWith(expression = "Image.fromFile()", imports = {}))
    @java.lang.Deprecated
    public Image(@NotNull final File file) {
        Intrinsics.checkNotNullParameter((Object)file, "file");
        this(ImageIO.read(file));
    }
    
    public final int getTextureWidth() {
        return this.textureWidth;
    }
    
    public final int getTextureHeight() {
        return this.textureHeight;
    }
    
    @NotNull
    public final DynamicTexture getTexture() {
        if (this.texture == null) {
            try {
                this.texture = new DynamicTexture(this.image);
                this.image = null;
                MinecraftForge.EVENT_BUS.unregister((Object)this);
            }
            catch (Exception e) {
                System.out.println((Object)"Trying to bake texture in a non-rendering context.");
                throw e;
            }
        }
        DynamicTexture texture;
        if ((texture = this.texture) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("texture");
            texture = null;
        }
        return texture;
    }
    
    public final void destroy() {
        DynamicTexture texture;
        if ((texture = this.texture) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("texture");
            texture = null;
        }
        texture.deleteGlTexture();
        CTJS.INSTANCE.getImages().remove(this);
    }
    
    @SubscribeEvent
    public final void onRender(@NotNull final RenderGameOverlayEvent$Pre event) {
        Intrinsics.checkNotNullParameter((Object)event, "event");
        if (this.image != null) {
            this.texture = new DynamicTexture(this.image);
            this.image = null;
            MinecraftForge.EVENT_BUS.unregister((Object)this);
        }
    }
    
    @JvmOverloads
    @NotNull
    public final Image draw(final double x, final double y, final double width, final double height) {
        final Image $this$draw_u24lambda_u2d0 = this;
        final int n = 0;
        if ($this$draw_u24lambda_u2d0.getImage() == null) {
            Renderer.drawImage($this$draw_u24lambda_u2d0, x, y, width, height);
        }
        return this;
    }
    
    public static /* synthetic */ Image draw$default(final Image image, final double x, final double y, double width, double height, final int n, final Object o) {
        if ((n & 0x4) != 0x0) {
            width = image.textureWidth;
        }
        if ((n & 0x8) != 0x0) {
            height = image.textureHeight;
        }
        return image.draw(x, y, width, height);
    }
    
    @Deprecated(message = "API is ambiguous, especially when called from JavaScript, and is relative to the assets directory", replaceWith = @ReplaceWith(expression = "Image.fromFile() /* or Image.fromUrl() */", imports = {}))
    @JvmOverloads
    @java.lang.Deprecated
    public Image(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        this(name, null, 2, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Image draw(final double x, final double y, final double width) {
        return draw$default(this, x, y, width, 0.0, 8, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Image draw(final double x, final double y) {
        return draw$default(this, x, y, 0.0, 0.0, 12, null);
    }
    
    @JvmStatic
    @NotNull
    public static final Image fromFile(@NotNull final File file) {
        return Image.Companion.fromFile(file);
    }
    
    @JvmStatic
    @NotNull
    public static final Image fromFile(@NotNull final String file) {
        return Image.Companion.fromFile(file);
    }
    
    @JvmStatic
    @NotNull
    public static final Image fromAsset(@NotNull final String name) {
        return Image.Companion.fromAsset(name);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Image fromUrl(@NotNull final String url, @Nullable final String cachedImageName) {
        return Image.Companion.fromUrl(url, cachedImageName);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Image fromUrl(@NotNull final String url) {
        return Image.Companion.fromUrl(url);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\u0010" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Image$Companion;", "", "()V", "fromAsset", "Lcom/chattriggers/ctjs/minecraft/libs/renderer/Image;", "name", "", "fromFile", "file", "Ljava/io/File;", "fromUrl", "url", "cachedImageName", "getBufferedImage", "Ljava/awt/image/BufferedImage;", "getImageFromUrl", "ctjs" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        @NotNull
        public final Image fromFile(@NotNull final File file) {
            Intrinsics.checkNotNullParameter((Object)file, "file");
            return new Image(file);
        }
        
        @JvmStatic
        @NotNull
        public final Image fromFile(@NotNull final String file) {
            Intrinsics.checkNotNullParameter((Object)file, "file");
            return new Image(new File(file));
        }
        
        @JvmStatic
        @NotNull
        public final Image fromAsset(@NotNull final String name) {
            Intrinsics.checkNotNullParameter((Object)name, "name");
            return new Image(new File(CTJS.INSTANCE.getAssetsDir(), name));
        }
        
        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Image fromUrl(@NotNull final String url, @Nullable final String cachedImageName) {
            Intrinsics.checkNotNullParameter((Object)url, "url");
            if (cachedImageName == null) {
                return new Image(this.getImageFromUrl(url));
            }
            return new Image(cachedImageName, url);
        }
        
        public static /* synthetic */ Image fromUrl$default(final Companion companion, final String url, String cachedImageName, final int n, final Object o) {
            if ((n & 0x2) != 0x0) {
                cachedImageName = null;
            }
            return companion.fromUrl(url, cachedImageName);
        }
        
        private final BufferedImage getBufferedImage(final String name, final String url) {
            final File resourceFile = new File(CTJS.INSTANCE.getAssetsDir(), name);
            if (resourceFile.exists()) {
                return ImageIO.read(resourceFile);
            }
            Intrinsics.checkNotNull((Object)url);
            final BufferedImage image = this.getImageFromUrl(url);
            ImageIO.write(image, "png", resourceFile);
            return image;
        }
        
        private final BufferedImage getImageFromUrl(final String url) {
            final HttpURLConnection $this$getImageFromUrl_u24lambda_u2d0;
            final HttpURLConnection httpURLConnection = $this$getImageFromUrl_u24lambda_u2d0 = CTJS.INSTANCE.makeWebRequest(url);
            final int n = 0;
            $this$getImageFromUrl_u24lambda_u2d0.setRequestMethod("GET");
            $this$getImageFromUrl_u24lambda_u2d0.setDoOutput(true);
            final HttpURLConnection conn = httpURLConnection;
            final BufferedImage read = ImageIO.read(conn.getInputStream());
            Intrinsics.checkNotNullExpressionValue((Object)read, "read(conn.inputStream)");
            return read;
        }
        
        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Image fromUrl(@NotNull final String url) {
            Intrinsics.checkNotNullParameter((Object)url, "url");
            return fromUrl$default(this, url, null, 2, null);
        }
    }
}
