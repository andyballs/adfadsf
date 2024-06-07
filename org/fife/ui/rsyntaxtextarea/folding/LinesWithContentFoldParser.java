//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.folding;

import java.util.*;
import javax.swing.text.*;
import org.fife.ui.rsyntaxtextarea.*;

public class LinesWithContentFoldParser implements FoldParser
{
    public List<Fold> getFolds(final RSyntaxTextArea textArea) {
        final List<Fold> folds = new ArrayList<Fold>();
        Fold fold = null;
        final int lineCount = textArea.getLineCount();
        try {
            for (int line = 0; line < lineCount; ++line) {
                final Token t = textArea.getTokenListForLine(line);
                if (!TokenUtils.isBlankOrAllWhiteSpaceWithoutComments(t)) {
                    if (fold == null) {
                        fold = new Fold(0, textArea, t.getOffset());
                        folds.add(fold);
                    }
                }
                else if (fold != null) {
                    fold.setEndOffset(textArea.getLineStartOffset(line) - 1);
                    if (fold.isOnSingleLine()) {
                        folds.remove(folds.size() - 1);
                    }
                    fold = null;
                }
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
        }
        return folds;
    }
}
