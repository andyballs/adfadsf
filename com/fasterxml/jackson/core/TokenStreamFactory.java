//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import java.net.*;
import com.fasterxml.jackson.core.io.*;
import java.io.*;

public abstract class TokenStreamFactory implements Versioned, Serializable
{
    private static final long serialVersionUID = 2L;
    
    public abstract boolean requiresPropertyOrdering();
    
    public abstract boolean canHandleBinaryNatively();
    
    public abstract boolean canParseAsync();
    
    public abstract Class<? extends FormatFeature> getFormatReadFeatureType();
    
    public abstract Class<? extends FormatFeature> getFormatWriteFeatureType();
    
    public abstract boolean canUseSchema(final FormatSchema p0);
    
    public abstract String getFormatName();
    
    public abstract boolean isEnabled(final JsonParser.Feature p0);
    
    public abstract boolean isEnabled(final JsonGenerator.Feature p0);
    
    public abstract int getParserFeatures();
    
    public abstract int getGeneratorFeatures();
    
    public abstract int getFormatParserFeatures();
    
    public abstract int getFormatGeneratorFeatures();
    
    public abstract JsonParser createParser(final byte[] p0) throws IOException;
    
    public abstract JsonParser createParser(final byte[] p0, final int p1, final int p2) throws IOException;
    
    public abstract JsonParser createParser(final char[] p0) throws IOException;
    
    public abstract JsonParser createParser(final char[] p0, final int p1, final int p2) throws IOException;
    
    public abstract JsonParser createParser(final DataInput p0) throws IOException;
    
    public abstract JsonParser createParser(final File p0) throws IOException;
    
    public abstract JsonParser createParser(final InputStream p0) throws IOException;
    
    public abstract JsonParser createParser(final Reader p0) throws IOException;
    
    public abstract JsonParser createParser(final String p0) throws IOException;
    
    public abstract JsonParser createParser(final URL p0) throws IOException;
    
    public abstract JsonParser createNonBlockingByteArrayParser() throws IOException;
    
    public abstract JsonGenerator createGenerator(final DataOutput p0, final JsonEncoding p1) throws IOException;
    
    public abstract JsonGenerator createGenerator(final DataOutput p0) throws IOException;
    
    public abstract JsonGenerator createGenerator(final File p0, final JsonEncoding p1) throws IOException;
    
    public abstract JsonGenerator createGenerator(final OutputStream p0) throws IOException;
    
    public abstract JsonGenerator createGenerator(final OutputStream p0, final JsonEncoding p1) throws IOException;
    
    public abstract JsonGenerator createGenerator(final Writer p0) throws IOException;
    
    protected OutputStream _createDataOutputWrapper(final DataOutput out) {
        return (OutputStream)new DataOutputAsStream(out);
    }
    
    protected InputStream _optimizedStreamFromURL(final URL url) throws IOException {
        if ("file".equals(url.getProtocol())) {
            final String host = url.getHost();
            if (host == null || host.length() == 0) {
                final String path = url.getPath();
                if (path.indexOf(37) < 0) {
                    return new FileInputStream(url.getPath());
                }
            }
        }
        return url.openStream();
    }
}
