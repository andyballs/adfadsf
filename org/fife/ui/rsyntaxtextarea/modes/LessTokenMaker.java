//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.modes;

public class LessTokenMaker extends CSSTokenMaker
{
    public LessTokenMaker() {
        this.setHighlightingLess(true);
    }
    
    public String[] getLineCommentStartAndEnd(final int languageIndex) {
        return new String[] { "//", null };
    }
    
    public boolean getMarkOccurrencesOfTokenType(final int type) {
        return type == 17 || super.getMarkOccurrencesOfTokenType(type);
    }
}
