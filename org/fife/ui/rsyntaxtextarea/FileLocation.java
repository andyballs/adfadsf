//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.net.*;
import java.io.*;

public abstract class FileLocation
{
    public static FileLocation create(final String fileFullPath) {
        if (!fileFullPath.startsWith("http://") && !fileFullPath.startsWith("https://")) {
            if (!fileFullPath.startsWith("ftp://")) {
                return (FileLocation)new FileFileLocation(new File(fileFullPath));
            }
        }
        try {
            return new URLFileLocation(new URL(fileFullPath));
        }
        catch (MalformedURLException mue) {
            throw new IllegalArgumentException("Not a valid URL: " + fileFullPath, mue);
        }
        return (FileLocation)new FileFileLocation(new File(fileFullPath));
    }
    
    public static FileLocation create(final File file) {
        return (FileLocation)new FileFileLocation(file);
    }
    
    public static FileLocation create(final URL url) {
        if ("file".equalsIgnoreCase(url.getProtocol())) {
            return (FileLocation)new FileFileLocation(new File(url.getPath()));
        }
        return new URLFileLocation(url);
    }
    
    protected abstract long getActualLastModified();
    
    public abstract String getFileFullPath();
    
    public abstract String getFileName();
    
    protected abstract InputStream getInputStream() throws IOException;
    
    protected abstract OutputStream getOutputStream() throws IOException;
    
    public abstract boolean isLocal();
    
    public abstract boolean isLocalAndExists();
    
    public boolean isRemote() {
        return !this.isLocal();
    }
}
