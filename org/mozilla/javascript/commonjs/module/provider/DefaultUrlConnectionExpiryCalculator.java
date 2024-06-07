//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.io.*;
import java.net.*;

public class DefaultUrlConnectionExpiryCalculator implements UrlConnectionExpiryCalculator, Serializable
{
    private static final long serialVersionUID = 1L;
    private final long relativeExpiry;
    
    public DefaultUrlConnectionExpiryCalculator() {
        this(60000L);
    }
    
    public DefaultUrlConnectionExpiryCalculator(final long relativeExpiry) {
        if (relativeExpiry < 0L) {
            throw new IllegalArgumentException("relativeExpiry < 0");
        }
        this.relativeExpiry = relativeExpiry;
    }
    
    @Override
    public long calculateExpiry(final URLConnection urlConnection) {
        return System.currentTimeMillis() + this.relativeExpiry;
    }
}
