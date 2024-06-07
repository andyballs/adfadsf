//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.*;
import java.io.*;

class PipeThread extends Thread
{
    private boolean fromProcess;
    private InputStream from;
    private OutputStream to;
    
    PipeThread(final boolean fromProcess, final InputStream from, final OutputStream to) {
        this.setDaemon(true);
        this.fromProcess = fromProcess;
        this.from = from;
        this.to = to;
    }
    
    @Override
    public void run() {
        try {
            Global.pipe(this.fromProcess, this.from, this.to);
        }
        catch (IOException ex) {
            throw Context.throwAsScriptRuntimeEx((Throwable)ex);
        }
    }
}
