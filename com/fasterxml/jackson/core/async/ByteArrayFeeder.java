//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.async;

import java.io.*;

public interface ByteArrayFeeder extends NonBlockingInputFeeder
{
    void feedInput(final byte[] p0, final int p1, final int p2) throws IOException;
}
