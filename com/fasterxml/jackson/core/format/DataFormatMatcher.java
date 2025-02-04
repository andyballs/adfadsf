//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;

public class DataFormatMatcher
{
    protected final InputStream _originalStream;
    protected final byte[] _bufferedData;
    protected final int _bufferedStart;
    protected final int _bufferedLength;
    protected final JsonFactory _match;
    protected final MatchStrength _matchStrength;
    
    protected DataFormatMatcher(final InputStream in, final byte[] buffered, final int bufferedStart, final int bufferedLength, final JsonFactory match, final MatchStrength strength) {
        this._originalStream = in;
        this._bufferedData = buffered;
        this._bufferedStart = bufferedStart;
        this._bufferedLength = bufferedLength;
        this._match = match;
        this._matchStrength = strength;
        if ((bufferedStart | bufferedLength) < 0 || bufferedStart + bufferedLength > buffered.length) {
            throw new IllegalArgumentException(String.format("Illegal start/length (%d/%d) wrt input array of %d bytes", bufferedStart, bufferedLength, buffered.length));
        }
    }
    
    public boolean hasMatch() {
        return this._match != null;
    }
    
    public MatchStrength getMatchStrength() {
        return (this._matchStrength == null) ? MatchStrength.INCONCLUSIVE : this._matchStrength;
    }
    
    public JsonFactory getMatch() {
        return this._match;
    }
    
    public String getMatchedFormatName() {
        return this.hasMatch() ? this.getMatch().getFormatName() : null;
    }
    
    public JsonParser createParserWithMatch() throws IOException {
        if (this._match == null) {
            return null;
        }
        if (this._originalStream == null) {
            return this._match.createParser(this._bufferedData, this._bufferedStart, this._bufferedLength);
        }
        return this._match.createParser(this.getDataStream());
    }
    
    public InputStream getDataStream() {
        if (this._originalStream == null) {
            return new ByteArrayInputStream(this._bufferedData, this._bufferedStart, this._bufferedLength);
        }
        return new MergedStream(null, this._originalStream, this._bufferedData, this._bufferedStart, this._bufferedLength);
    }
}
