//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.idswitch;

public class IdValuePair
{
    public final int idLength;
    public final String id;
    public final String value;
    private int lineNumber;
    
    public IdValuePair(final String id, final String value) {
        this.idLength = id.length();
        this.id = id;
        this.value = value;
    }
    
    public int getLineNumber() {
        return this.lineNumber;
    }
    
    public void setLineNumber(final int value) {
        this.lineNumber = value;
    }
}
