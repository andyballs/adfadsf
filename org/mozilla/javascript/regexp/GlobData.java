//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import org.mozilla.javascript.*;

final class GlobData
{
    int mode;
    boolean global;
    String str;
    Scriptable arrayobj;
    Function lambda;
    String repstr;
    int dollar;
    StringBuilder charBuf;
    int leftIndex;
    int fromIndex;
    
    GlobData() {
        this.dollar = -1;
    }
}
