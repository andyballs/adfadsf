//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import java.io.*;

public class DataOutputAsStream extends OutputStream
{
    protected final DataOutput _output;
    
    public DataOutputAsStream(final DataOutput out) {
        this._output = out;
    }
    
    @Override
    public void write(final int b) throws IOException {
        this._output.write(b);
    }
    
    @Override
    public void write(final byte[] b) throws IOException {
        this._output.write(b, 0, b.length);
    }
    
    @Override
    public void write(final byte[] b, final int offset, final int length) throws IOException {
        this._output.write(b, offset, length);
    }
}
