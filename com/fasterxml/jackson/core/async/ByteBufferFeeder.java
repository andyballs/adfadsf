//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.async;

import java.nio.*;
import java.io.*;

public interface ByteBufferFeeder extends NonBlockingInputFeeder
{
    void feedInput(final ByteBuffer p0) throws IOException;
}
