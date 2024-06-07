//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import org.fife.ui.rtextarea.*;
import javax.swing.*;

public class RSyntaxTextAreaDefaultInputMap extends RTADefaultInputMap
{
    public RSyntaxTextAreaDefaultInputMap() {
        final int defaultMod = RTextArea.getDefaultModifier();
        final int shift = 64;
        final int defaultShift = defaultMod | shift;
        this.put(KeyStroke.getKeyStroke(9, shift), "RSTA.DecreaseIndentAction");
        this.put(KeyStroke.getKeyStroke('}'), "RSTA.CloseCurlyBraceAction");
        this.put(KeyStroke.getKeyStroke('/'), "RSTA.CloseMarkupTagAction");
        final int os = RSyntaxUtilities.getOS();
        if (os == 1 || os == 2) {
            this.put(KeyStroke.getKeyStroke(47, defaultMod), "RSTA.ToggleCommentAction");
        }
        this.put(KeyStroke.getKeyStroke(91, defaultMod), "RSTA.GoToMatchingBracketAction");
        this.put(KeyStroke.getKeyStroke(109, defaultMod), "RSTA.CollapseFoldAction");
        this.put(KeyStroke.getKeyStroke(107, defaultMod), "RSTA.ExpandFoldAction");
        this.put(KeyStroke.getKeyStroke(111, defaultMod), "RSTA.CollapseAllFoldsAction");
        this.put(KeyStroke.getKeyStroke(106, defaultMod), "RSTA.ExpandAllFoldsAction");
        this.put(KeyStroke.getKeyStroke(32, defaultShift), "RSTA.TemplateAction");
    }
}
