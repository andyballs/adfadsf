//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import java.io.*;

public abstract class InputDecorator implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public abstract InputStream decorate(final IOContext p0, final InputStream p1) throws IOException;
    
    public abstract InputStream decorate(final IOContext p0, final byte[] p1, final int p2, final int p3) throws IOException;
    
    public DataInput decorate(final IOContext ctxt, final DataInput input) throws IOException {
        throw new UnsupportedOperationException();
    }
    
    public abstract Reader decorate(final IOContext p0, final Reader p1) throws IOException;
}
