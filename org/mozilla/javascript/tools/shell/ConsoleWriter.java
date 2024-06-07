//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import java.io.*;
import javax.swing.*;

class ConsoleWriter extends OutputStream
{
    private ConsoleTextArea textArea;
    private StringBuffer buffer;
    
    public ConsoleWriter(final ConsoleTextArea textArea) {
        this.textArea = textArea;
        this.buffer = new StringBuffer();
    }
    
    @Override
    public synchronized void write(final int ch) {
        this.buffer.append((char)ch);
        if (ch == 10) {
            this.flushBuffer();
        }
    }
    
    public synchronized void write(final char[] data, final int off, final int len) {
        for (int i = off; i < len; ++i) {
            this.buffer.append(data[i]);
            if (data[i] == '\n') {
                this.flushBuffer();
            }
        }
    }
    
    @Override
    public synchronized void flush() {
        if (this.buffer.length() > 0) {
            this.flushBuffer();
        }
    }
    
    @Override
    public void close() {
        this.flush();
    }
    
    private void flushBuffer() {
        final String str = this.buffer.toString();
        this.buffer.setLength(0);
        SwingUtilities.invokeLater((Runnable)new ConsoleWrite(this.textArea, str));
    }
}
