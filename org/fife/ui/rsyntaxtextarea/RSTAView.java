//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.awt.*;
import javax.swing.text.*;

interface RSTAView
{
    int yForLine(final Rectangle p0, final int p1) throws BadLocationException;
    
    int yForLineContaining(final Rectangle p0, final int p1) throws BadLocationException;
}
