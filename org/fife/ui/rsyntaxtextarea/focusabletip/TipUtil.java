//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.focusabletip;

import org.fife.ui.rtextarea.*;
import javax.swing.border.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;
import java.awt.*;
import javax.swing.text.html.*;
import org.fife.ui.rsyntaxtextarea.*;

public final class TipUtil
{
    private TipUtil() {
    }
    
    public static Rectangle getScreenBoundsForPoint(final int x, final int y) {
        final GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice[] screenDevices;
        final GraphicsDevice[] devices = screenDevices = env.getScreenDevices();
        for (final GraphicsDevice device : screenDevices) {
            final GraphicsConfiguration[] configurations;
            final GraphicsConfiguration[] configs = configurations = device.getConfigurations();
            for (final GraphicsConfiguration config : configurations) {
                final Rectangle gcBounds = config.getBounds();
                if (gcBounds.contains(x, y)) {
                    return gcBounds;
                }
            }
        }
        return env.getMaximumWindowBounds();
    }
    
    public static Color getToolTipBackground() {
        return getToolTipBackground(null);
    }
    
    public static Color getToolTipBackground(final RTextArea textArea) {
        if (textArea != null && !Color.WHITE.equals(textArea.getBackground())) {
            return textArea.getBackground();
        }
        Color c = UIManager.getColor("ToolTip.background");
        final boolean isNimbus = isNimbusLookAndFeel();
        if (c == null || isNimbus) {
            c = UIManager.getColor("info");
            if (c == null || (isNimbus && isDerivedColor(c))) {
                c = SystemColor.info;
            }
        }
        if (c instanceof ColorUIResource) {
            c = new Color(c.getRGB());
        }
        return c;
    }
    
    public static Border getToolTipBorder() {
        return getToolTipBorder(null);
    }
    
    public static Border getToolTipBorder(final RTextArea textArea) {
        if (textArea != null && !Color.WHITE.equals(textArea.getBackground())) {
            final Color color = textArea.getBackground();
            if (color != null) {
                return BorderFactory.createLineBorder(color.brighter());
            }
        }
        Border border = UIManager.getBorder("ToolTip.border");
        if (border == null || isNimbusLookAndFeel()) {
            border = UIManager.getBorder("nimbusBorder");
            if (border == null) {
                border = BorderFactory.createLineBorder(SystemColor.controlDkShadow);
            }
        }
        return border;
    }
    
    private static boolean isDerivedColor(final Color c) {
        return c != null && c.getClass().getName().endsWith(".DerivedColor");
    }
    
    private static boolean isNimbusLookAndFeel() {
        return UIManager.getLookAndFeel().getName().equals("Nimbus");
    }
    
    public static void tweakTipEditorPane(final JEditorPane textArea) {
        final boolean isNimbus = isNimbusLookAndFeel();
        if (isNimbus) {
            final Color selBG = textArea.getSelectionColor();
            final Color selFG = textArea.getSelectedTextColor();
            textArea.setUI(new BasicEditorPaneUI());
            textArea.setSelectedTextColor(selFG);
            textArea.setSelectionColor(selBG);
        }
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textArea.getCaret().setSelectionVisible(true);
        Color fg = UIManager.getColor("Label.foreground");
        if (fg == null || (isNimbus && isDerivedColor(fg))) {
            fg = SystemColor.textText;
        }
        textArea.setForeground(fg);
        textArea.setBackground(getToolTipBackground());
        Font font = UIManager.getFont("Label.font");
        if (font == null) {
            font = new Font("SansSerif", 0, 12);
        }
        final HTMLDocument doc = (HTMLDocument)textArea.getDocument();
        setFont(doc, font, fg);
        final Color linkFG = RSyntaxUtilities.getHyperlinkForeground();
        doc.getStyleSheet().addRule("a { color: " + HtmlUtil.getHexString(linkFG) + "; }");
    }
    
    public static void setFont(final HTMLDocument doc, final Font font, final Color fg) {
        doc.getStyleSheet().addRule("body { font-family: " + font.getFamily() + "; font-size: " + font.getSize() + "pt" + "; color: " + HtmlUtil.getHexString(fg) + "; }");
    }
}
