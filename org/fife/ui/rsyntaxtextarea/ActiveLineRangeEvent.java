//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.util.*;

public class ActiveLineRangeEvent extends EventObject
{
    private int min;
    private int max;
    
    public ActiveLineRangeEvent(final RSyntaxTextArea source, final int min, final int max) {
        super(source);
        this.min = min;
        this.max = max;
    }
    
    public int getMax() {
        return this.max;
    }
    
    public int getMin() {
        return this.min;
    }
}
