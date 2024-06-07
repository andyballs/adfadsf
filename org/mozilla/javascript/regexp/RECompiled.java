//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import java.io.*;

class RECompiled implements Serializable
{
    private static final long serialVersionUID = -6144956577595844213L;
    final char[] source;
    int parenCount;
    int flags;
    byte[] program;
    int classCount;
    RECharSet[] classList;
    int anchorCh;
    
    RECompiled(final String str) {
        this.anchorCh = -1;
        this.source = str.toCharArray();
    }
}
