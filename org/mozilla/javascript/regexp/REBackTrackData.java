//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

class REBackTrackData
{
    final REBackTrackData previous;
    final int op;
    final int pc;
    final int cp;
    final int continuationOp;
    final int continuationPc;
    final long[] parens;
    final REProgState stateStackTop;
    
    REBackTrackData(final REGlobalData gData, final int op, final int pc, final int cp, final int continuationOp, final int continuationPc) {
        this.previous = gData.backTrackStackTop;
        this.op = op;
        this.pc = pc;
        this.cp = cp;
        this.continuationOp = continuationOp;
        this.continuationPc = continuationPc;
        this.parens = gData.parens;
        this.stateStackTop = gData.stateStackTop;
    }
}
