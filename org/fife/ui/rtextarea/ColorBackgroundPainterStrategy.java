//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import java.awt.*;

public class ColorBackgroundPainterStrategy implements BackgroundPainterStrategy
{
    private Color color;
    
    public ColorBackgroundPainterStrategy(final Color color) {
        this.setColor(color);
    }
    
    @Override
    public boolean equals(final Object o2) {
        return o2 instanceof ColorBackgroundPainterStrategy && this.color.equals(((ColorBackgroundPainterStrategy)o2).getColor());
    }
    
    public Color getColor() {
        return this.color;
    }
    
    @Override
    public int hashCode() {
        return this.color.hashCode();
    }
    
    public void paint(final Graphics g, final Rectangle bounds) {
        final Color temp = g.getColor();
        g.setColor(this.color);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(temp);
    }
    
    public void setColor(final Color color) {
        this.color = color;
    }
}
