//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.io.*;
import java.util.*;

public final class ParsedContentType implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final String contentType;
    private final String encoding;
    
    public ParsedContentType(final String mimeType) {
        String contentType = null;
        String encoding = null;
        if (mimeType != null) {
            final StringTokenizer tok = new StringTokenizer(mimeType, ";");
            if (tok.hasMoreTokens()) {
                contentType = tok.nextToken().trim();
                while (tok.hasMoreTokens()) {
                    final String param = tok.nextToken().trim();
                    if (param.startsWith("charset=")) {
                        encoding = param.substring(8).trim();
                        final int l = encoding.length();
                        if (l <= 0) {
                            break;
                        }
                        if (encoding.charAt(0) == '\"') {
                            encoding = encoding.substring(1);
                        }
                        if (encoding.charAt(l - 1) == '\"') {
                            encoding = encoding.substring(0, l - 1);
                            break;
                        }
                        break;
                    }
                }
            }
        }
        this.contentType = contentType;
        this.encoding = encoding;
    }
    
    public String getContentType() {
        return this.contentType;
    }
    
    public String getEncoding() {
        return this.encoding;
    }
}
