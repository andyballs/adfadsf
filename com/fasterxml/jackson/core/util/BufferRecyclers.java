//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.util;

import java.lang.ref.*;
import com.fasterxml.jackson.core.io.*;

public class BufferRecyclers
{
    public static final String SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS = "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers";
    private static final ThreadLocalBufferManager _bufferRecyclerTracker;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;
    
    public static BufferRecycler getBufferRecycler() {
        SoftReference<BufferRecycler> ref = BufferRecyclers._recyclerRef.get();
        BufferRecycler br = (ref == null) ? null : ref.get();
        if (br == null) {
            br = new BufferRecycler();
            if (BufferRecyclers._bufferRecyclerTracker != null) {
                ref = BufferRecyclers._bufferRecyclerTracker.wrapAndTrack(br);
            }
            else {
                ref = new SoftReference<BufferRecycler>(br);
            }
            BufferRecyclers._recyclerRef.set(ref);
        }
        return br;
    }
    
    public static int releaseBuffers() {
        if (BufferRecyclers._bufferRecyclerTracker != null) {
            return BufferRecyclers._bufferRecyclerTracker.releaseBuffers();
        }
        return -1;
    }
    
    @Deprecated
    public static JsonStringEncoder getJsonStringEncoder() {
        return JsonStringEncoder.getInstance();
    }
    
    @Deprecated
    public static byte[] encodeAsUTF8(final String text) {
        return JsonStringEncoder.getInstance().encodeAsUTF8(text);
    }
    
    @Deprecated
    public static char[] quoteAsJsonText(final String rawText) {
        return JsonStringEncoder.getInstance().quoteAsString(rawText);
    }
    
    @Deprecated
    public static void quoteAsJsonText(final CharSequence input, final StringBuilder output) {
        JsonStringEncoder.getInstance().quoteAsString(input, output);
    }
    
    @Deprecated
    public static byte[] quoteAsJsonUTF8(final String rawText) {
        return JsonStringEncoder.getInstance().quoteAsUTF8(rawText);
    }
    
    static {
        boolean trackReusableBuffers = false;
        try {
            trackReusableBuffers = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        }
        catch (SecurityException ex) {}
        _bufferRecyclerTracker = (trackReusableBuffers ? ThreadLocalBufferManager.instance() : null);
        _recyclerRef = new ThreadLocal<SoftReference<BufferRecycler>>();
    }
}
