//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.awt.*;
import javax.swing.text.*;

interface TokenPainter
{
    float paint(final Token p0, final Graphics2D p1, final float p2, final float p3, final RSyntaxTextArea p4, final TabExpander p5);
    
    float paint(final Token p0, final Graphics2D p1, final float p2, final float p3, final RSyntaxTextArea p4, final TabExpander p5, final float p6);
    
    float paint(final Token p0, final Graphics2D p1, final float p2, final float p3, final RSyntaxTextArea p4, final TabExpander p5, final float p6, final boolean p7);
    
    float paintSelected(final Token p0, final Graphics2D p1, final float p2, final float p3, final RSyntaxTextArea p4, final TabExpander p5, final boolean p6);
    
    float paintSelected(final Token p0, final Graphics2D p1, final float p2, final float p3, final RSyntaxTextArea p4, final TabExpander p5, final float p6, final boolean p7);
}
