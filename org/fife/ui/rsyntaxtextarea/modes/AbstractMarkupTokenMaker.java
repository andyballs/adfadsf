//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.modes;

import org.fife.ui.rsyntaxtextarea.*;

public abstract class AbstractMarkupTokenMaker extends AbstractJFlexTokenMaker
{
    public abstract boolean getCompleteCloseTags();
    
    public String[] getLineCommentStartAndEnd(final int languageIndex) {
        return new String[] { "<!--", "-->" };
    }
    
    public final boolean isMarkupLanguage() {
        return true;
    }
}
