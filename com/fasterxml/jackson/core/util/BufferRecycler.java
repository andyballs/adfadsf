//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.util;

import java.util.concurrent.atomic.*;

public class BufferRecycler
{
    public static final int BYTE_READ_IO_BUFFER = 0;
    public static final int BYTE_WRITE_ENCODING_BUFFER = 1;
    public static final int BYTE_WRITE_CONCAT_BUFFER = 2;
    public static final int BYTE_BASE64_CODEC_BUFFER = 3;
    public static final int CHAR_TOKEN_BUFFER = 0;
    public static final int CHAR_CONCAT_BUFFER = 1;
    public static final int CHAR_TEXT_BUFFER = 2;
    public static final int CHAR_NAME_COPY_BUFFER = 3;
    private static final int[] BYTE_BUFFER_LENGTHS;
    private static final int[] CHAR_BUFFER_LENGTHS;
    protected final AtomicReferenceArray<byte[]> _byteBuffers;
    protected final AtomicReferenceArray<char[]> _charBuffers;
    
    public BufferRecycler() {
        this(4, 4);
    }
    
    protected BufferRecycler(final int bbCount, final int cbCount) {
        this._byteBuffers = new AtomicReferenceArray<byte[]>(bbCount);
        this._charBuffers = new AtomicReferenceArray<char[]>(cbCount);
    }
    
    public final byte[] allocByteBuffer(final int ix) {
        return this.allocByteBuffer(ix, 0);
    }
    
    public byte[] allocByteBuffer(final int ix, int minSize) {
        final int DEF_SIZE = this.byteBufferLength(ix);
        if (minSize < DEF_SIZE) {
            minSize = DEF_SIZE;
        }
        byte[] buffer = this._byteBuffers.getAndSet(ix, null);
        if (buffer == null || buffer.length < minSize) {
            buffer = this.balloc(minSize);
        }
        return buffer;
    }
    
    public void releaseByteBuffer(final int ix, final byte[] buffer) {
        this._byteBuffers.set(ix, buffer);
    }
    
    public final char[] allocCharBuffer(final int ix) {
        return this.allocCharBuffer(ix, 0);
    }
    
    public char[] allocCharBuffer(final int ix, int minSize) {
        final int DEF_SIZE = this.charBufferLength(ix);
        if (minSize < DEF_SIZE) {
            minSize = DEF_SIZE;
        }
        char[] buffer = this._charBuffers.getAndSet(ix, null);
        if (buffer == null || buffer.length < minSize) {
            buffer = this.calloc(minSize);
        }
        return buffer;
    }
    
    public void releaseCharBuffer(final int ix, final char[] buffer) {
        this._charBuffers.set(ix, buffer);
    }
    
    protected int byteBufferLength(final int ix) {
        return BufferRecycler.BYTE_BUFFER_LENGTHS[ix];
    }
    
    protected int charBufferLength(final int ix) {
        return BufferRecycler.CHAR_BUFFER_LENGTHS[ix];
    }
    
    protected byte[] balloc(final int size) {
        return new byte[size];
    }
    
    protected char[] calloc(final int size) {
        return new char[size];
    }
    
    static {
        BYTE_BUFFER_LENGTHS = new int[] { 8000, 8000, 2000, 2000 };
        CHAR_BUFFER_LENGTHS = new int[] { 4000, 4000, 200, 200 };
    }
}
