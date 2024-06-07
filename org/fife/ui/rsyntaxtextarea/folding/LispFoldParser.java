//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.folding;

import org.fife.ui.rsyntaxtextarea.*;

public class LispFoldParser extends CurlyFoldParser
{
    public boolean isLeftCurly(final Token t) {
        return t.isSingleChar(22, '(');
    }
    
    public boolean isRightCurly(final Token t) {
        return t.isSingleChar(22, ')');
    }
}
