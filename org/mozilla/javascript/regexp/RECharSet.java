//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import java.io.*;

final class RECharSet implements Serializable
{
    private static final long serialVersionUID = 7931787979395898394L;
    final int length;
    final int startIndex;
    final int strlength;
    final boolean sense;
    transient volatile boolean converted;
    transient volatile byte[] bits;
    
    RECharSet(final int length, final int startIndex, final int strlength, final boolean sense) {
        this.length = length;
        this.startIndex = startIndex;
        this.strlength = strlength;
        this.sense = sense;
    }
}
