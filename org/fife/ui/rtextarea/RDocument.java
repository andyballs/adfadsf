//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import javax.swing.text.*;

public class RDocument extends PlainDocument
{
    public RDocument() {
        super(new RGapContent());
    }
    
    public char charAt(final int offset) throws BadLocationException {
        return ((RGapContent)this.getContent()).charAt(offset);
    }
    
    private static class RGapContent extends GapContent
    {
        public char charAt(final int offset) throws BadLocationException {
            if (offset < 0 || offset >= this.length()) {
                throw new BadLocationException("Invalid offset", offset);
            }
            final int g0 = this.getGapStart();
            final char[] array = (char[])this.getArray();
            if (offset < g0) {
                return array[offset];
            }
            return array[this.getGapEnd() + offset - g0];
        }
    }
}
