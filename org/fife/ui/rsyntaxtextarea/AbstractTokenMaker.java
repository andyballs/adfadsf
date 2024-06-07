//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

public abstract class AbstractTokenMaker extends TokenMakerBase
{
    protected TokenMap wordsToHighlight;
    
    public AbstractTokenMaker() {
        this.wordsToHighlight = this.getWordsToHighlight();
    }
    
    public abstract TokenMap getWordsToHighlight();
    
    public void removeLastToken() {
        if (this.previousToken == null) {
            final TokenImpl tokenImpl = null;
            this.currentToken = tokenImpl;
            this.firstToken = tokenImpl;
        }
        else {
            (this.currentToken = this.previousToken).setNextToken(null);
        }
    }
}
