//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.folding;

import org.fife.ui.rsyntaxtextarea.*;
import java.util.*;
import javax.swing.text.*;

public class YamlFoldParser implements FoldParser
{
    private static boolean isSpaces(final Token t) {
        final String lexeme = t.getLexeme();
        return lexeme.trim().isEmpty();
    }
    
    public List<Fold> getFolds(final RSyntaxTextArea textArea) {
        final List<Fold> folds = new ArrayList<Fold>();
        final Stack<Integer> indentStack = new Stack<Integer>();
        Fold currentFold = null;
        final int lineCount = textArea.getLineCount();
        int lastOffset = 0;
        try {
            for (int line = 0; line < lineCount; ++line) {
                Token t = textArea.getTokenListForLine(line);
                if (t.isPaintable()) {
                    final Token startLine = t;
                    int offset = t.getOffset();
                    int indent = 0;
                    while (t != null && t.isPaintable() && isSpaces(t)) {
                        indent += t.length();
                        t = t.getNextToken();
                    }
                    if (t != null && t.isPaintable() && t.isSingleChar('-')) {
                        ++indent;
                        t = t.getNextToken();
                    }
                    while (!indentStack.empty()) {
                        final int outer = indentStack.peek();
                        if (outer < indent || currentFold == null) {
                            break;
                        }
                        currentFold.setEndOffset(lastOffset);
                        final Fold parentFold = currentFold.getParent();
                        if (currentFold.isOnSingleLine()) {
                            removeFold(currentFold, folds);
                        }
                        currentFold = parentFold;
                        indentStack.pop();
                    }
                    while (t != null && t.isPaintable()) {
                        offset = t.getOffset();
                        t = t.getNextToken();
                    }
                    lastOffset = offset;
                    if (currentFold == null) {
                        currentFold = new Fold(0, textArea, startLine.getOffset());
                        folds.add(currentFold);
                    }
                    else {
                        currentFold = currentFold.createChild(0, startLine.getOffset());
                    }
                    indentStack.push(indent);
                }
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
        }
        return folds;
    }
    
    private static void removeFold(final Fold fold, final List<Fold> folds) {
        if (!fold.removeFromParent()) {
            folds.remove(folds.size() - 1);
        }
    }
}
