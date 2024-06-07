//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.parser;

import java.awt.*;

public interface ParserNotice extends Comparable<ParserNotice>
{
    boolean containsPosition(final int p0);
    
    Color getColor();
    
    int getLength();
    
    Level getLevel();
    
    int getLine();
    
    boolean getKnowsOffsetAndLength();
    
    String getMessage();
    
    int getOffset();
    
    Parser getParser();
    
    boolean getShowInEditor();
    
    String getToolTipText();
    
    public enum Level
    {
        INFO(2), 
        WARNING(1), 
        ERROR(0);
        
        private int value;
        
        private Level(final int value) {
            this.value = value;
        }
        
        public int getNumericValue() {
            return this.value;
        }
        
        public boolean isEqualToOrWorseThan(final Level other) {
            return this.value <= other.getNumericValue();
        }
    }
}
