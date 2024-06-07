//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import org.fife.ui.rtextarea.*;

public interface OccurrenceMarker
{
    Token getTokenToMark(final RSyntaxTextArea p0);
    
    boolean isValidType(final RSyntaxTextArea p0, final Token p1);
    
    void markOccurrences(final RSyntaxDocument p0, final Token p1, final RSyntaxTextAreaHighlighter p2, final SmartHighlightPainter p3);
}
