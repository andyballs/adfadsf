//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools;

import org.mozilla.javascript.commonjs.module.provider.*;
import org.mozilla.javascript.*;
import java.net.*;
import java.io.*;

public class SourceReader
{
    public static URL toUrl(final String path) {
        if (path.indexOf(58) >= 2) {
            try {
                return new URL(path);
            }
            catch (MalformedURLException ex) {}
        }
        return null;
    }
    
    public static Object readFileOrUrl(final String path, final boolean convertToString, final String defaultEncoding) throws IOException {
        final URL url = toUrl(path);
        InputStream is = null;
        int capacityHint = 0;
        String contentType;
        String encoding;
        byte[] data;
        try {
            if (url == null) {
                final File file = new File(path);
                encoding = (contentType = null);
                capacityHint = (int)file.length();
                is = new FileInputStream(file);
            }
            else {
                final URLConnection uc = url.openConnection();
                is = uc.getInputStream();
                if (convertToString) {
                    final ParsedContentType pct = new ParsedContentType(uc.getContentType());
                    contentType = pct.getContentType();
                    encoding = pct.getEncoding();
                }
                else {
                    encoding = (contentType = null);
                }
                capacityHint = uc.getContentLength();
                if (capacityHint > 1048576) {
                    capacityHint = -1;
                }
            }
            if (capacityHint <= 0) {
                capacityHint = 4096;
            }
            data = Kit.readStream(is, capacityHint);
        }
        finally {
            if (is != null) {
                is.close();
            }
        }
        Object result;
        if (!convertToString) {
            result = data;
        }
        else {
            if (encoding == null) {
                if (data.length > 3 && data[0] == -1 && data[1] == -2 && data[2] == 0 && data[3] == 0) {
                    encoding = "UTF-32LE";
                }
                else if (data.length > 3 && data[0] == 0 && data[1] == 0 && data[2] == -2 && data[3] == -1) {
                    encoding = "UTF-32BE";
                }
                else if (data.length > 2 && data[0] == -17 && data[1] == -69 && data[2] == -65) {
                    encoding = "UTF-8";
                }
                else if (data.length > 1 && data[0] == -1 && data[1] == -2) {
                    encoding = "UTF-16LE";
                }
                else if (data.length > 1 && data[0] == -2 && data[1] == -1) {
                    encoding = "UTF-16BE";
                }
                else {
                    encoding = defaultEncoding;
                    if (encoding == null) {
                        if (url == null) {
                            encoding = System.getProperty("file.encoding");
                        }
                        else if (contentType != null && contentType.startsWith("application/")) {
                            encoding = "UTF-8";
                        }
                        else {
                            encoding = "US-ASCII";
                        }
                    }
                }
            }
            String strResult = new String(data, encoding);
            if (strResult.length() > 0 && strResult.charAt(0) == '\ufeff') {
                strResult = strResult.substring(1);
            }
            result = strResult;
        }
        return result;
    }
}
