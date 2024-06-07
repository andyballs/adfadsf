//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

class RegExReplaceInfo
{
    private String matchedText;
    private int startIndex;
    private int endIndex;
    private String replacement;
    
    RegExReplaceInfo(final String matchedText, final int start, final int end, final String replacement) {
        this.matchedText = matchedText;
        this.startIndex = start;
        this.endIndex = end;
        this.replacement = replacement;
    }
    
    public int getEndIndex() {
        return this.endIndex;
    }
    
    public String getMatchedText() {
        return this.matchedText;
    }
    
    public String getReplacement() {
        return this.replacement;
    }
    
    public int getStartIndex() {
        return this.startIndex;
    }
}
