//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.parser;

import java.util.*;

public interface ParseResult
{
    Exception getError();
    
    int getFirstLineParsed();
    
    int getLastLineParsed();
    
    List<ParserNotice> getNotices();
    
    Parser getParser();
    
    long getParseTime();
}
