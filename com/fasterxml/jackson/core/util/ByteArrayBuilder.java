//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.util;

import java.io.*;
import java.util.*;

public final class ByteArrayBuilder extends OutputStream
{
    public static final byte[] NO_BYTES;
    private static final int INITIAL_BLOCK_SIZE = 500;
    private static final int MAX_BLOCK_SIZE = 131072;
    static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
    private final BufferRecycler _bufferRecycler;
    private final LinkedList<byte[]> _pastBlocks;
    private int _pastLen;
    private byte[] _currBlock;
    private int _currBlockPtr;
    
    public ByteArrayBuilder() {
        this(null);
    }
    
    public ByteArrayBuilder(final BufferRecycler br) {
        this(br, 500);
    }
    
    public ByteArrayBuilder(final int firstBlockSize) {
        this(null, firstBlockSize);
    }
    
    public ByteArrayBuilder(final BufferRecycler br, int firstBlockSize) {
        this._pastBlocks = new LinkedList<byte[]>();
        this._bufferRecycler = br;
        if (firstBlockSize > 131072) {
            firstBlockSize = 131072;
        }
        this._currBlock = ((br == null) ? new byte[firstBlockSize] : br.allocByteBuffer(2));
    }
    
    private ByteArrayBuilder(final BufferRecycler br, final byte[] initialBlock, final int initialLen) {
        this._pastBlocks = new LinkedList<byte[]>();
        this._bufferRecycler = null;
        this._currBlock = initialBlock;
        this._currBlockPtr = initialLen;
    }
    
    public static ByteArrayBuilder fromInitial(final byte[] initialBlock, final int length) {
        return new ByteArrayBuilder(null, initialBlock, length);
    }
    
    public void reset() {
        this._pastLen = 0;
        this._currBlockPtr = 0;
        if (!this._pastBlocks.isEmpty()) {
            this._pastBlocks.clear();
        }
    }
    
    public int size() {
        return this._pastLen + this._currBlockPtr;
    }
    
    public void release() {
        this.reset();
        if (this._bufferRecycler != null && this._currBlock != null) {
            this._bufferRecycler.releaseByteBuffer(2, this._currBlock);
            this._currBlock = null;
        }
    }
    
    public void append(final int i) {
        if (this._currBlockPtr >= this._currBlock.length) {
            this._allocMore();
        }
        this._currBlock[this._currBlockPtr++] = (byte)i;
    }
    
    public void appendTwoBytes(final int b16) {
        if (this._currBlockPtr + 1 < this._currBlock.length) {
            this._currBlock[this._currBlockPtr++] = (byte)(b16 >> 8);
            this._currBlock[this._currBlockPtr++] = (byte)b16;
        }
        else {
            this.append(b16 >> 8);
            this.append(b16);
        }
    }
    
    public void appendThreeBytes(final int b24) {
        if (this._currBlockPtr + 2 < this._currBlock.length) {
            this._currBlock[this._currBlockPtr++] = (byte)(b24 >> 16);
            this._currBlock[this._currBlockPtr++] = (byte)(b24 >> 8);
            this._currBlock[this._currBlockPtr++] = (byte)b24;
        }
        else {
            this.append(b24 >> 16);
            this.append(b24 >> 8);
            this.append(b24);
        }
    }
    
    public void appendFourBytes(final int b32) {
        if (this._currBlockPtr + 3 < this._currBlock.length) {
            this._currBlock[this._currBlockPtr++] = (byte)(b32 >> 24);
            this._currBlock[this._currBlockPtr++] = (byte)(b32 >> 16);
            this._currBlock[this._currBlockPtr++] = (byte)(b32 >> 8);
            this._currBlock[this._currBlockPtr++] = (byte)b32;
        }
        else {
            this.append(b32 >> 24);
            this.append(b32 >> 16);
            this.append(b32 >> 8);
            this.append(b32);
        }
    }
    
    public byte[] toByteArray() {
        final int totalLen = this._pastLen + this._currBlockPtr;
        if (totalLen == 0) {
            return ByteArrayBuilder.NO_BYTES;
        }
        final byte[] result = new byte[totalLen];
        int offset = 0;
        for (final byte[] block : this._pastBlocks) {
            final int len = block.length;
            System.arraycopy(block, 0, result, offset, len);
            offset += len;
        }
        System.arraycopy(this._currBlock, 0, result, offset, this._currBlockPtr);
        offset += this._currBlockPtr;
        if (offset != totalLen) {
            throw new RuntimeException("Internal error: total len assumed to be " + totalLen + ", copied " + offset + " bytes");
        }
        if (!this._pastBlocks.isEmpty()) {
            this.reset();
        }
        return result;
    }
    
    public byte[] resetAndGetFirstSegment() {
        this.reset();
        return this._currBlock;
    }
    
    public byte[] finishCurrentSegment() {
        this._allocMore();
        return this._currBlock;
    }
    
    public byte[] completeAndCoalesce(final int lastBlockLength) {
        this._currBlockPtr = lastBlockLength;
        return this.toByteArray();
    }
    
    public byte[] getCurrentSegment() {
        return this._currBlock;
    }
    
    public void setCurrentSegmentLength(final int len) {
        this._currBlockPtr = len;
    }
    
    public int getCurrentSegmentLength() {
        return this._currBlockPtr;
    }
    
    @Override
    public void write(final byte[] b) {
        this.write(b, 0, b.length);
    }
    
    @Override
    public void write(final byte[] b, int off, int len) {
        while (true) {
            final int max = this._currBlock.length - this._currBlockPtr;
            final int toCopy = Math.min(max, len);
            if (toCopy > 0) {
                System.arraycopy(b, off, this._currBlock, this._currBlockPtr, toCopy);
                off += toCopy;
                this._currBlockPtr += toCopy;
                len -= toCopy;
            }
            if (len <= 0) {
                break;
            }
            this._allocMore();
        }
    }
    
    @Override
    public void write(final int b) {
        this.append(b);
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void flush() {
    }
    
    private void _allocMore() {
        final int newPastLen = this._pastLen + this._currBlock.length;
        if (newPastLen < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this._pastLen = newPastLen;
        int newSize = Math.max(this._pastLen >> 1, 1000);
        if (newSize > 131072) {
            newSize = 131072;
        }
        this._pastBlocks.add(this._currBlock);
        this._currBlock = new byte[newSize];
        this._currBlockPtr = 0;
    }
    
    static {
        NO_BYTES = new byte[0];
    }
}
