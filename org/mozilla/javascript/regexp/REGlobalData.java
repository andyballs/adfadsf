//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

class REGlobalData
{
    boolean multiline;
    boolean dotAll;
    RECompiled regexp;
    int skipped;
    int cp;
    long[] parens;
    REProgState stateStackTop;
    REBackTrackData backTrackStackTop;
    
    int parensIndex(final int i) {
        return (int)this.parens[i];
    }
    
    int parensLength(final int i) {
        return (int)(this.parens[i] >>> 32);
    }
    
    void setParens(final int i, final int index, final int length) {
        if (this.backTrackStackTop != null && this.backTrackStackTop.parens == this.parens) {
            this.parens = this.parens.clone();
        }
        this.parens[i] = (((long)index & 0xFFFFFFFFL) | (long)length << 32);
    }
}
