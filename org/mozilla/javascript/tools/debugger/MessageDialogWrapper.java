//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import java.awt.*;
import javax.swing.*;

class MessageDialogWrapper
{
    public static void showMessageDialog(final Component parent, String msg, final String title, final int flags) {
        if (msg.length() > 60) {
            final StringBuilder buf = new StringBuilder();
            for (int len = msg.length(), j = 0, i = 0; i < len; ++i, ++j) {
                final char c = msg.charAt(i);
                buf.append(c);
                if (Character.isWhitespace(c)) {
                    int k;
                    for (k = i + 1; k < len && !Character.isWhitespace(msg.charAt(k)); ++k) {}
                    if (k < len) {
                        final int nextWordLen = k - i;
                        if (j + nextWordLen > 60) {
                            buf.append('\n');
                            j = 0;
                        }
                    }
                }
            }
            msg = buf.toString();
        }
        JOptionPane.showMessageDialog(parent, msg, title, flags);
    }
}
