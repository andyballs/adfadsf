//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.nio.charset.*;
import java.io.*;

final class RtfToText
{
    private Reader r;
    private StringBuilder sb;
    private StringBuilder controlWord;
    private int blockCount;
    private boolean inControlWord;
    
    private RtfToText(final Reader r) {
        this.r = r;
        this.sb = new StringBuilder();
        this.controlWord = new StringBuilder();
        this.blockCount = 0;
        this.inControlWord = false;
    }
    
    private String convert() throws IOException {
        int i = this.r.read();
        if (i != 123) {
            throw new IOException("Invalid RTF file");
        }
        while ((i = this.r.read()) != -1) {
            final char ch = (char)i;
            switch (ch) {
                case '{': {
                    if (this.inControlWord && this.controlWord.length() == 0) {
                        this.sb.append('{');
                        this.controlWord.setLength(0);
                        this.inControlWord = false;
                        continue;
                    }
                    ++this.blockCount;
                    continue;
                }
                case '}': {
                    if (this.inControlWord && this.controlWord.length() == 0) {
                        this.sb.append('}');
                        this.controlWord.setLength(0);
                        this.inControlWord = false;
                        continue;
                    }
                    --this.blockCount;
                    continue;
                }
                case '\\': {
                    if (this.blockCount != 0) {
                        continue;
                    }
                    if (!this.inControlWord) {
                        this.inControlWord = true;
                        continue;
                    }
                    if (this.controlWord.length() == 0) {
                        this.sb.append('\\');
                        this.controlWord.setLength(0);
                        this.inControlWord = false;
                        continue;
                    }
                    this.endControlWord();
                    this.inControlWord = true;
                    continue;
                }
                case ' ': {
                    if (this.blockCount != 0) {
                        continue;
                    }
                    if (this.inControlWord) {
                        this.endControlWord();
                        continue;
                    }
                    this.sb.append(' ');
                    continue;
                }
                case '\n':
                case '\r': {
                    if (this.blockCount == 0 && this.inControlWord) {
                        this.endControlWord();
                        continue;
                    }
                    continue;
                }
                default: {
                    if (this.blockCount != 0) {
                        continue;
                    }
                    if (this.inControlWord) {
                        this.controlWord.append(ch);
                        continue;
                    }
                    this.sb.append(ch);
                    continue;
                }
            }
        }
        return this.sb.toString();
    }
    
    private void endControlWord() {
        final String word = this.controlWord.toString();
        if ("par".equals(word) || "line".equals(word)) {
            this.sb.append('\n');
        }
        else if ("tab".equals(word)) {
            this.sb.append('\t');
        }
        else if (isUnicodeEscape(word)) {
            this.sb.append((char)(int)Integer.valueOf(word.substring(1)));
        }
        this.controlWord.setLength(0);
        this.inControlWord = false;
    }
    
    private static boolean isUnicodeEscape(final String controlWord) {
        if (controlWord.startsWith("u") && controlWord.length() > 1) {
            for (int i = 1; i < controlWord.length(); ++i) {
                final char ch = controlWord.charAt(i);
                if (ch < '0' || ch > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static String getPlainText(final byte[] rtf) throws IOException {
        return getPlainText(new ByteArrayInputStream(rtf));
    }
    
    public static String getPlainText(final File file) throws IOException {
        return getPlainText(new BufferedReader(new FileReader(file)));
    }
    
    public static String getPlainText(final InputStream in) throws IOException {
        return getPlainText(new InputStreamReader(in, StandardCharsets.US_ASCII));
    }
    
    private static String getPlainText(final Reader r) throws IOException {
        try {
            final RtfToText converter = new RtfToText(r);
            return converter.convert();
        }
        finally {
            r.close();
        }
    }
    
    public static String getPlainText(final String rtf) throws IOException {
        return getPlainText(new StringReader(rtf));
    }
}
