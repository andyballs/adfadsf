//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.io;

import java.nio.charset.*;
import java.io.*;

public class UnicodeWriter extends Writer
{
    public static final String PROPERTY_WRITE_UTF8_BOM = "UnicodeWriter.writeUtf8BOM";
    private OutputStreamWriter internalOut;
    private static final byte[] UTF8_BOM;
    private static final byte[] UTF16LE_BOM;
    private static final byte[] UTF16BE_BOM;
    private static final byte[] UTF32LE_BOM;
    private static final byte[] UTF32BE_BOM;
    
    public UnicodeWriter(final String fileName, final Charset charset) throws IOException {
        this(new FileOutputStream(fileName), charset.name());
    }
    
    public UnicodeWriter(final String fileName, final String encoding) throws IOException {
        this(new FileOutputStream(fileName), encoding);
    }
    
    public UnicodeWriter(final File file, final Charset charset) throws IOException {
        this(new FileOutputStream(file), charset.name());
    }
    
    public UnicodeWriter(final File file, final String encoding) throws IOException {
        this(new FileOutputStream(file), encoding);
    }
    
    public UnicodeWriter(final OutputStream out, final Charset charset) throws IOException {
        this.init(out, charset.name());
    }
    
    public UnicodeWriter(final OutputStream out, final String encoding) throws IOException {
        this.init(out, encoding);
    }
    
    @Override
    public void close() throws IOException {
        this.internalOut.close();
    }
    
    @Override
    public void flush() throws IOException {
        this.internalOut.flush();
    }
    
    public String getEncoding() {
        return this.internalOut.getEncoding();
    }
    
    public static boolean getWriteUtf8BOM() {
        return Boolean.getBoolean("UnicodeWriter.writeUtf8BOM");
    }
    
    private void init(final OutputStream out, final String encoding) throws IOException {
        this.internalOut = new OutputStreamWriter(out, encoding);
        switch (encoding) {
            case "UTF-8": {
                if (getWriteUtf8BOM()) {
                    out.write(UnicodeWriter.UTF8_BOM, 0, UnicodeWriter.UTF8_BOM.length);
                    break;
                }
                break;
            }
            case "UTF-16LE": {
                out.write(UnicodeWriter.UTF16LE_BOM, 0, UnicodeWriter.UTF16LE_BOM.length);
                break;
            }
            case "UTF-16BE": {
                out.write(UnicodeWriter.UTF16BE_BOM, 0, UnicodeWriter.UTF16BE_BOM.length);
                break;
            }
            case "UTF-32LE": {
                out.write(UnicodeWriter.UTF32LE_BOM, 0, UnicodeWriter.UTF32LE_BOM.length);
                break;
            }
            case "UTF-32":
            case "UTF-32BE": {
                out.write(UnicodeWriter.UTF32BE_BOM, 0, UnicodeWriter.UTF32BE_BOM.length);
                break;
            }
        }
    }
    
    public static void setWriteUtf8BOM(final boolean write) {
        System.setProperty("UnicodeWriter.writeUtf8BOM", Boolean.toString(write));
    }
    
    @Override
    public void write(final char[] cbuf, final int off, final int len) throws IOException {
        this.internalOut.write(cbuf, off, len);
    }
    
    @Override
    public void write(final int c) throws IOException {
        this.internalOut.write(c);
    }
    
    @Override
    public void write(final String str, final int off, final int len) throws IOException {
        this.internalOut.write(str, off, len);
    }
    
    static {
        UTF8_BOM = new byte[] { -17, -69, -65 };
        UTF16LE_BOM = new byte[] { -1, -2 };
        UTF16BE_BOM = new byte[] { -2, -1 };
        UTF32LE_BOM = new byte[] { -1, -2, 0, 0 };
        UTF32BE_BOM = new byte[] { 0, 0, -2, -1 };
    }
}
