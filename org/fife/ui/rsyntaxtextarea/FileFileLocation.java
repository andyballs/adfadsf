//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.io.*;

class FileFileLocation extends FileLocation
{
    private File file;
    
    FileFileLocation(final File file) {
        try {
            this.file = file.getCanonicalFile();
        }
        catch (IOException ioe) {
            this.file = file;
        }
    }
    
    @Override
    protected long getActualLastModified() {
        return this.file.lastModified();
    }
    
    @Override
    public String getFileFullPath() {
        return this.file.getAbsolutePath();
    }
    
    @Override
    public String getFileName() {
        return this.file.getName();
    }
    
    @Override
    protected InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
    
    @Override
    protected OutputStream getOutputStream() throws IOException {
        return new FileOutputStream(this.file);
    }
    
    @Override
    public boolean isLocal() {
        return true;
    }
    
    @Override
    public boolean isLocalAndExists() {
        return this.file.exists();
    }
}
