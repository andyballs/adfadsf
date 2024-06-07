//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.parser;

import javax.swing.event.*;
import java.net.*;

public class ToolTipInfo
{
    private String text;
    private HyperlinkListener listener;
    private URL imageBase;
    
    public ToolTipInfo(final String text, final HyperlinkListener listener) {
        this(text, listener, null);
    }
    
    public ToolTipInfo(final String text, final HyperlinkListener l, final URL imageBase) {
        this.text = text;
        this.listener = l;
        this.imageBase = imageBase;
    }
    
    public HyperlinkListener getHyperlinkListener() {
        return this.listener;
    }
    
    public URL getImageBase() {
        return this.imageBase;
    }
    
    public String getToolTipText() {
        return this.text;
    }
}
