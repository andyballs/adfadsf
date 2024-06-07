//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import java.net.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.security.*;
import java.io.*;
import java.awt.image.*;

public class IconGroup
{
    private String path;
    private boolean separateLargeIcons;
    private String largeIconSubDir;
    private String extension;
    private String name;
    private String jarFile;
    private static final String DEFAULT_EXTENSION = "gif";
    
    public IconGroup(final String name, final String path) {
        this(name, path, null);
    }
    
    public IconGroup(final String name, final String path, final String largeIconSubDir) {
        this(name, path, largeIconSubDir, "gif");
    }
    
    public IconGroup(final String name, final String path, final String largeIconSubDir, final String extension) {
        this(name, path, largeIconSubDir, extension, null);
    }
    
    public IconGroup(final String name, final String path, final String largeIconSubDir, final String extension, final String jar) {
        this.name = name;
        this.path = path;
        if (path != null && path.length() > 0 && !path.endsWith("/")) {
            this.path += "/";
        }
        this.separateLargeIcons = (largeIconSubDir != null);
        this.largeIconSubDir = largeIconSubDir;
        this.extension = ((extension != null) ? extension : "gif");
        this.jarFile = jar;
    }
    
    @Override
    public boolean equals(final Object o2) {
        if (o2 instanceof IconGroup) {
            final IconGroup ig2 = (IconGroup)o2;
            if (ig2.getName().equals(this.getName()) && this.separateLargeIcons == ig2.hasSeparateLargeIcons()) {
                return (!this.separateLargeIcons || this.largeIconSubDir.equals(ig2.largeIconSubDir)) && this.path.equals(ig2.path);
            }
        }
        return false;
    }
    
    public Icon getFileTypeIcon(final String rstaSyntax) {
        final int slash = rstaSyntax.indexOf(47);
        if (slash > -1) {
            final String fileType = rstaSyntax.substring(slash + 1).toLowerCase();
            final String path = "fileTypes/" + fileType + '.' + this.extension;
            Icon icon = this.getIconImpl(path);
            if (icon == null) {
                icon = this.getIconImpl("fileTypes/default." + this.extension);
            }
            return icon;
        }
        return null;
    }
    
    public Icon getIcon(final String name) {
        Icon icon = this.getIconImpl(this.path + name + "." + this.extension);
        if (icon != null && (icon.getIconWidth() < 1 || icon.getIconHeight() < 1)) {
            icon = null;
        }
        return icon;
    }
    
    protected Icon getIconImpl(final String iconFullPath) {
        try {
            if (this.jarFile != null) {
                final URL url = new URL("jar:file:///" + this.jarFile + "!/" + iconFullPath);
                final Icon icon = new ImageIcon(url);
                return (icon.getIconWidth() == -1) ? null : icon;
            }
            final URL url = this.getClass().getClassLoader().getResource(iconFullPath);
            if (url != null) {
                return new ImageIcon(url);
            }
            final BufferedImage image = ImageIO.read(new File(iconFullPath));
            return (image != null) ? new ImageIcon(image) : null;
        }
        catch (AccessControlException | IOException ex2) {
            final Exception ex;
            final Exception ace = ex;
            return null;
        }
    }
    
    public Icon getLargeIcon(final String name) {
        return this.getIconImpl(this.path + this.largeIconSubDir + "/" + name + "." + this.extension);
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean hasSeparateLargeIcons() {
        return this.separateLargeIcons;
    }
    
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
