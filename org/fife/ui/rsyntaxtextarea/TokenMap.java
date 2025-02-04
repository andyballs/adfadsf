//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.text.*;

public class TokenMap
{
    private int size;
    private TokenMapToken[] tokenMap;
    private boolean ignoreCase;
    private static final int DEFAULT_TOKEN_MAP_SIZE = 52;
    
    public TokenMap() {
        this(52);
    }
    
    public TokenMap(final int size) {
        this(size, false);
    }
    
    public TokenMap(final boolean ignoreCase) {
        this(52, ignoreCase);
    }
    
    public TokenMap(final int size, final boolean ignoreCase) {
        this.size = size;
        this.tokenMap = new TokenMapToken[size];
        this.ignoreCase = ignoreCase;
    }
    
    private void addTokenToBucket(final int bucket, final TokenMapToken token) {
        final TokenMapToken old = this.tokenMap[bucket];
        token.nextToken = old;
        this.tokenMap[bucket] = token;
    }
    
    public int get(final Segment text, final int start, final int end) {
        return this.get(text.array, start, end);
    }
    
    public int get(final char[] array1, final int start, final int end) {
        final int length1 = end - start + 1;
        final int hash = this.getHashCode(array1, start, length1);
        TokenMapToken token = this.tokenMap[hash];
        if (!this.ignoreCase) {
        Label_0033:
            while (token != null) {
                if (token.length == length1) {
                    final char[] array2 = token.text;
                    int offset2 = token.offset;
                    int offset3 = start;
                    int length2 = length1;
                    while (length2-- > 0) {
                        if (array1[offset3++] != array2[offset2++]) {
                            token = token.nextToken;
                            continue Label_0033;
                        }
                    }
                    return token.tokenType;
                }
                token = token.nextToken;
            }
        }
        else {
        Label_0121:
            while (token != null) {
                if (token.length == length1) {
                    final char[] array2 = token.text;
                    int offset2 = token.offset;
                    int offset3 = start;
                    int length2 = length1;
                    while (length2-- > 0) {
                        if (RSyntaxUtilities.toLowerCase(array1[offset3++]) != array2[offset2++]) {
                            token = token.nextToken;
                            continue Label_0121;
                        }
                    }
                    return token.tokenType;
                }
                token = token.nextToken;
            }
        }
        return -1;
    }
    
    private int getHashCode(final char[] text, final int offset, final int length) {
        return (RSyntaxUtilities.toLowerCase(text[offset]) + RSyntaxUtilities.toLowerCase(text[offset + length - 1])) % this.size;
    }
    
    protected boolean isIgnoringCase() {
        return this.ignoreCase;
    }
    
    public void put(final String string, final int tokenType) {
        if (this.isIgnoringCase()) {
            this.put(string.toLowerCase().toCharArray(), tokenType);
        }
        else {
            this.put(string.toCharArray(), tokenType);
        }
    }
    
    private void put(final char[] string, final int tokenType) {
        final int hashCode = this.getHashCode(string, 0, string.length);
        this.addTokenToBucket(hashCode, new TokenMapToken(string, tokenType));
    }
    
    private static final class TokenMapToken
    {
        private char[] text;
        private int offset;
        private int length;
        private int tokenType;
        private TokenMapToken nextToken;
        
        private TokenMapToken(final char[] text, final int tokenType) {
            this.text = text;
            this.offset = 0;
            this.length = text.length;
            this.tokenType = tokenType;
        }
        
        @Override
        public String toString() {
            return "[TokenMapToken: " + new String(this.text, this.offset, this.length) + "]";
        }
    }
}
