//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.folding;

import java.util.*;
import javax.swing.text.*;
import org.fife.ui.rsyntaxtextarea.*;

public class PythonFoldParser implements FoldParser
{
    public List<Fold> getFolds(final RSyntaxTextArea textArea) {
        final List<Fold> folds = new ArrayList<Fold>();
        Fold currentFold = null;
        final int lineCount = textArea.getLineCount();
        final int tabSize = textArea.getTabSize();
        final Stack<Integer> foldStartLeadingWhiteSpaceCounts = new Stack<Integer>();
        int currentNextFoldStart = 0;
        int currentLeadingWhiteSpaceCount = 0;
        try {
            for (int line = 0; line < lineCount; ++line) {
                Token t = textArea.getTokenListForLine(line);
                final int leadingWhiteSpaceCount = getLeadingWhiteSpaceCount(t, tabSize);
                if (leadingWhiteSpaceCount != -1) {
                    if (leadingWhiteSpaceCount == currentLeadingWhiteSpaceCount) {
                        currentNextFoldStart = t.getOffset() + leadingWhiteSpaceCount;
                    }
                    else if (leadingWhiteSpaceCount > currentLeadingWhiteSpaceCount) {
                        if (currentFold != null) {
                            currentFold = currentFold.createChild(0, currentNextFoldStart);
                        }
                        else {
                            currentFold = new Fold(0, textArea, currentNextFoldStart);
                            folds.add(currentFold);
                        }
                        foldStartLeadingWhiteSpaceCounts.push(currentLeadingWhiteSpaceCount);
                        currentNextFoldStart = t.getOffset() + leadingWhiteSpaceCount;
                    }
                    else {
                        currentNextFoldStart = t.getOffset() + leadingWhiteSpaceCount;
                        int prevLine = line - 1;
                        do {
                            t = textArea.getTokenListForLine(prevLine--);
                        } while (TokenUtils.isBlankOrAllWhiteSpace(t));
                        final int endOffs = t.getEndOffset() - 1;
                        boolean foundBlock = false;
                        while (!foldStartLeadingWhiteSpaceCounts.isEmpty() && foldStartLeadingWhiteSpaceCounts.peek() >= leadingWhiteSpaceCount) {
                            currentFold.setEndOffset(endOffs);
                            currentFold = currentFold.getParent();
                            foldStartLeadingWhiteSpaceCounts.pop();
                            foundBlock = true;
                        }
                        if (!foundBlock && currentFold != null && !currentFold.removeFromParent()) {
                            folds.remove(folds.size() - 1);
                        }
                    }
                    currentLeadingWhiteSpaceCount = leadingWhiteSpaceCount;
                }
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
        }
        return folds;
    }
    
    private static int getLeadingWhiteSpaceCount(Token t, final int tabSize) {
        if (t == null || t.getType() == 13 || t.getType() == 14) {
            return -1;
        }
        int count = 0;
        while (t != null && t.isPaintable()) {
            if (!t.isWhitespace()) {
                return (t.getType() == 1) ? -1 : count;
            }
            count += TokenUtils.getWhiteSpaceTokenLength(t, tabSize, count);
            t = t.getNextToken();
        }
        return -1;
    }
}
