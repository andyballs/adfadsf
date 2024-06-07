//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

class REProgState
{
    final REProgState previous;
    final int min;
    final int max;
    final int index;
    final int continuationOp;
    final int continuationPc;
    final REBackTrackData backTrack;
    
    REProgState(final REProgState previous, final int min, final int max, final int index, final REBackTrackData backTrack, final int continuationOp, final int continuationPc) {
        this.previous = previous;
        this.min = min;
        this.max = max;
        this.index = index;
        this.continuationOp = continuationOp;
        this.continuationPc = continuationPc;
        this.backTrack = backTrack;
    }
}
