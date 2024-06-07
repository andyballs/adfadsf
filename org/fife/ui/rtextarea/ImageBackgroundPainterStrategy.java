//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import java.awt.*;
import java.net.*;
import javax.imageio.*;
import java.awt.image.*;

public abstract class ImageBackgroundPainterStrategy implements BackgroundPainterStrategy
{
    protected MediaTracker tracker;
    private RTextAreaBase textArea;
    private Image master;
    private int oldWidth;
    private int oldHeight;
    private int scalingHint;
    
    public ImageBackgroundPainterStrategy(final RTextAreaBase textArea) {
        this.textArea = textArea;
        this.tracker = new MediaTracker(textArea);
        this.scalingHint = 2;
    }
    
    public RTextAreaBase getRTextAreaBase() {
        return this.textArea;
    }
    
    public Image getMasterImage() {
        return this.master;
    }
    
    public int getScalingHint() {
        return this.scalingHint;
    }
    
    public final void paint(final Graphics g, final Rectangle bounds) {
        if (bounds.width != this.oldWidth || bounds.height != this.oldHeight) {
            this.rescaleImage(bounds.width, bounds.height, this.getScalingHint());
            this.oldWidth = bounds.width;
            this.oldHeight = bounds.height;
        }
        this.paintImage(g, bounds.x, bounds.y);
    }
    
    protected abstract void paintImage(final Graphics p0, final int p1, final int p2);
    
    protected abstract void rescaleImage(final int p0, final int p1, final int p2);
    
    public void setImage(final URL imageURL) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageURL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.setImage(image);
    }
    
    public void setImage(final Image image) {
        this.master = image;
        this.oldWidth = -1;
    }
    
    public void setScalingHint(final int hint) {
        this.scalingHint = hint;
    }
}
