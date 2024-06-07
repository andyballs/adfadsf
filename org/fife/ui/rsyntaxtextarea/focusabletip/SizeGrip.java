//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.focusabletip;

import javax.imageio.*;
import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class SizeGrip extends JPanel
{
    private transient Image osxSizeGrip;
    
    SizeGrip() {
        final MouseHandler adapter = new MouseHandler();
        this.addMouseListener(adapter);
        this.addMouseMotionListener(adapter);
        this.setPreferredSize(new Dimension(16, 16));
    }
    
    @Override
    public void applyComponentOrientation(final ComponentOrientation o) {
        this.possiblyFixCursor(o.isLeftToRight());
        super.applyComponentOrientation(o);
    }
    
    private Image createOSXSizeGrip() {
        final ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource("org/fife/ui/rsyntaxtextarea/focusabletip/osx_sizegrip.png");
        Label_0058: {
            if (url == null) {
                final File f = new File("../RSyntaxTextArea/src/org/fife/ui/rsyntaxtextarea/focusabletip/osx_sizegrip.png");
                if (f.isFile()) {
                    try {
                        url = f.toURI().toURL();
                        break Label_0058;
                    }
                    catch (MalformedURLException mue) {
                        mue.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }
        Image image = null;
        try {
            image = ImageIO.read(url);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return image;
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Dimension dim = this.getSize();
        if (this.osxSizeGrip != null) {
            g.drawImage(this.osxSizeGrip, dim.width - 16, dim.height - 16, null);
            return;
        }
        final Color c1 = UIManager.getColor("Label.disabledShadow");
        final Color c2 = UIManager.getColor("Label.disabledForeground");
        final ComponentOrientation orientation = this.getComponentOrientation();
        if (orientation.isLeftToRight()) {
            final Dimension dimension = dim;
            final int width2 = dimension.width - 3;
            dimension.width = width2;
            final int width = width2;
            final Dimension dimension2 = dim;
            final int height3 = dimension2.height - 3;
            dimension2.height = height3;
            final int height = height3;
            g.setColor(c1);
            g.fillRect(width - 9, height - 1, 3, 3);
            g.fillRect(width - 5, height - 1, 3, 3);
            g.fillRect(width - 1, height - 1, 3, 3);
            g.fillRect(width - 5, height - 5, 3, 3);
            g.fillRect(width - 1, height - 5, 3, 3);
            g.fillRect(width - 1, height - 9, 3, 3);
            g.setColor(c2);
            g.fillRect(width - 9, height - 1, 2, 2);
            g.fillRect(width - 5, height - 1, 2, 2);
            g.fillRect(width - 1, height - 1, 2, 2);
            g.fillRect(width - 5, height - 5, 2, 2);
            g.fillRect(width - 1, height - 5, 2, 2);
            g.fillRect(width - 1, height - 9, 2, 2);
        }
        else {
            final Dimension dimension3 = dim;
            final int height4 = dimension3.height - 3;
            dimension3.height = height4;
            final int height2 = height4;
            g.setColor(c1);
            g.fillRect(10, height2 - 1, 3, 3);
            g.fillRect(6, height2 - 1, 3, 3);
            g.fillRect(2, height2 - 1, 3, 3);
            g.fillRect(6, height2 - 5, 3, 3);
            g.fillRect(2, height2 - 5, 3, 3);
            g.fillRect(2, height2 - 9, 3, 3);
            g.setColor(c2);
            g.fillRect(10, height2 - 1, 2, 2);
            g.fillRect(6, height2 - 1, 2, 2);
            g.fillRect(2, height2 - 1, 2, 2);
            g.fillRect(6, height2 - 5, 2, 2);
            g.fillRect(2, height2 - 5, 2, 2);
            g.fillRect(2, height2 - 9, 2, 2);
        }
    }
    
    protected void possiblyFixCursor(final boolean ltr) {
        int cursor = 7;
        if (ltr) {
            cursor = 6;
        }
        if (cursor != this.getCursor().getType()) {
            this.setCursor(Cursor.getPredefinedCursor(cursor));
        }
    }
    
    @Override
    public void updateUI() {
        super.updateUI();
        if (System.getProperty("os.name").contains("OS X")) {
            if (this.osxSizeGrip == null) {
                this.osxSizeGrip = this.createOSXSizeGrip();
            }
        }
        else {
            this.osxSizeGrip = null;
        }
    }
    
    private class MouseHandler extends MouseInputAdapter
    {
        private Point origPos;
        
        @Override
        public void mouseDragged(final MouseEvent e) {
            final Point newPos = e.getPoint();
            SwingUtilities.convertPointToScreen(newPos, SizeGrip.this);
            final int xDelta = newPos.x - this.origPos.x;
            final int yDelta = newPos.y - this.origPos.y;
            final Window wind = SwingUtilities.getWindowAncestor(SizeGrip.this);
            if (wind != null) {
                if (SizeGrip.this.getComponentOrientation().isLeftToRight()) {
                    int w = wind.getWidth();
                    if (newPos.x >= wind.getX()) {
                        w += xDelta;
                    }
                    int h = wind.getHeight();
                    if (newPos.y >= wind.getY()) {
                        h += yDelta;
                    }
                    wind.setSize(w, h);
                }
                else {
                    final int newW = Math.max(1, wind.getWidth() - xDelta);
                    final int newH = Math.max(1, wind.getHeight() + yDelta);
                    wind.setBounds(newPos.x, wind.getY(), newW, newH);
                }
                wind.invalidate();
                wind.validate();
            }
            this.origPos.setLocation(newPos);
        }
        
        @Override
        public void mousePressed(final MouseEvent e) {
            SwingUtilities.convertPointToScreen(this.origPos = e.getPoint(), SizeGrip.this);
        }
        
        @Override
        public void mouseReleased(final MouseEvent e) {
            this.origPos = null;
        }
    }
}
