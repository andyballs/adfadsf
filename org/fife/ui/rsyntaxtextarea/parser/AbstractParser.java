//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.parser;

import java.net.*;

public abstract class AbstractParser implements Parser
{
    private boolean enabled;
    private ExtendedHyperlinkListener linkListener;
    
    protected AbstractParser() {
        this.setEnabled(true);
    }
    
    @Override
    public ExtendedHyperlinkListener getHyperlinkListener() {
        return this.linkListener;
    }
    
    @Override
    public URL getImageBase() {
        return null;
    }
    
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
    
    public void setHyperlinkListener(final ExtendedHyperlinkListener listener) {
        this.linkListener = listener;
    }
}
