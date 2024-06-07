//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

class ConsoleWrite implements Runnable
{
    private ConsoleTextArea textArea;
    private String str;
    
    public ConsoleWrite(final ConsoleTextArea textArea, final String str) {
        this.textArea = textArea;
        this.str = str;
    }
    
    @Override
    public void run() {
        this.textArea.write(this.str);
    }
}
