//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;
import javax.swing.*;

public abstract class TokenMakerBase implements TokenMaker
{
    protected TokenImpl firstToken;
    protected TokenImpl currentToken;
    protected TokenImpl previousToken;
    private TokenFactory tokenFactory;
    private OccurrenceMarker occurrenceMarker;
    private int languageIndex;
    
    public TokenMakerBase() {
        final TokenImpl firstToken = null;
        this.previousToken = firstToken;
        this.currentToken = firstToken;
        this.firstToken = firstToken;
        this.tokenFactory = (TokenFactory)new DefaultTokenFactory();
    }
    
    public void addNullToken() {
        if (this.firstToken == null) {
            this.firstToken = this.tokenFactory.createToken();
            this.currentToken = this.firstToken;
        }
        else {
            final TokenImpl next = this.tokenFactory.createToken();
            this.currentToken.setNextToken((Token)next);
            this.previousToken = this.currentToken;
            this.currentToken = next;
        }
        this.currentToken.setLanguageIndex(this.languageIndex);
    }
    
    public void addToken(final Segment segment, final int start, final int end, final int tokenType, final int startOffset) {
        this.addToken(segment.array, start, end, tokenType, startOffset);
    }
    
    public void addToken(final char[] array, final int start, final int end, final int tokenType, final int startOffset) {
        this.addToken(array, start, end, tokenType, startOffset, false);
    }
    
    public void addToken(final char[] array, final int start, final int end, final int tokenType, final int startOffset, final boolean hyperlink) {
        if (this.firstToken == null) {
            this.firstToken = this.tokenFactory.createToken(array, start, end, startOffset, tokenType);
            this.currentToken = this.firstToken;
        }
        else {
            final TokenImpl next = this.tokenFactory.createToken(array, start, end, startOffset, tokenType);
            this.currentToken.setNextToken((Token)next);
            this.previousToken = this.currentToken;
            this.currentToken = next;
        }
        this.currentToken.setLanguageIndex(this.languageIndex);
        this.currentToken.setHyperlink(hyperlink);
    }
    
    protected OccurrenceMarker createOccurrenceMarker() {
        return (OccurrenceMarker)new DefaultOccurrenceMarker();
    }
    
    public int getClosestStandardTokenTypeForInternalType(final int type) {
        return type;
    }
    
    public boolean getCurlyBracesDenoteCodeBlocks(final int languageIndex) {
        return false;
    }
    
    public Action getInsertBreakAction() {
        return null;
    }
    
    protected int getLanguageIndex() {
        return this.languageIndex;
    }
    
    public int getLastTokenTypeOnLine(final Segment text, final int initialTokenType) {
        Token t;
        for (t = this.getTokenList(text, initialTokenType, 0); t.getNextToken() != null; t = t.getNextToken()) {}
        return t.getType();
    }
    
    public String[] getLineCommentStartAndEnd(final int languageIndex) {
        return null;
    }
    
    public boolean getMarkOccurrencesOfTokenType(final int type) {
        return type == 20;
    }
    
    protected boolean getNoTokensIdentifiedYet() {
        return this.firstToken == null;
    }
    
    public OccurrenceMarker getOccurrenceMarker() {
        if (this.occurrenceMarker == null) {
            this.occurrenceMarker = this.createOccurrenceMarker();
        }
        return this.occurrenceMarker;
    }
    
    public boolean getShouldIndentNextLineAfter(final Token token) {
        return false;
    }
    
    public boolean isIdentifierChar(final int languageIndex, final char ch) {
        return Character.isLetterOrDigit(ch) || ch == '_' || ch == '$';
    }
    
    public boolean isMarkupLanguage() {
        return false;
    }
    
    protected void resetTokenList() {
        final TokenImpl firstToken = null;
        this.previousToken = firstToken;
        this.currentToken = firstToken;
        this.firstToken = firstToken;
        this.tokenFactory.resetAllTokens();
    }
    
    protected void setLanguageIndex(final int languageIndex) {
        this.languageIndex = Math.max(0, languageIndex);
    }
}
