//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import org.mozilla.javascript.*;

class CompilerState
{
    Context cx;
    char[] cpbegin;
    int cpend;
    int cp;
    int flags;
    int backReferenceLimit;
    int maxBackReference;
    int parenCount;
    int parenNesting;
    int classCount;
    int progLength;
    RENode result;
    
    CompilerState(final Context cx, final char[] source, final int length, final int flags) {
        this.cx = cx;
        this.cpbegin = source;
        this.cp = 0;
        this.cpend = length;
        this.flags = flags;
        this.backReferenceLimit = Integer.MAX_VALUE;
        this.maxBackReference = 0;
        this.parenCount = 0;
        this.classCount = 0;
        this.progLength = 0;
    }
}
