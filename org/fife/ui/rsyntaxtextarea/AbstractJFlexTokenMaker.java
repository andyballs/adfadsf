//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;

public abstract class AbstractJFlexTokenMaker extends TokenMakerBase
{
    protected Segment s;
    protected int start;
    protected int offsetShift;
    
    public abstract void yybegin(final int p0);
    
    protected void yybegin(final int state, final int languageIndex) {
        this.yybegin(state);
        this.setLanguageIndex(languageIndex);
    }
}
