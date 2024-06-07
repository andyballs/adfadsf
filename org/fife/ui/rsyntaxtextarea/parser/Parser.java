//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.parser;

import java.net.*;
import org.fife.ui.rsyntaxtextarea.*;

public interface Parser
{
    ExtendedHyperlinkListener getHyperlinkListener();
    
    URL getImageBase();
    
    boolean isEnabled();
    
    ParseResult parse(final RSyntaxDocument p0, final String p1);
}
