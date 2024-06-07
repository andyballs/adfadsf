//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import java.io.*;

public abstract class OutputDecorator implements Serializable
{
    public abstract OutputStream decorate(final IOContext p0, final OutputStream p1) throws IOException;
    
    public abstract Writer decorate(final IOContext p0, final Writer p1) throws IOException;
}
