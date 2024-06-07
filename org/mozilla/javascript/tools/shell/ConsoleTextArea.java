//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class ConsoleTextArea extends JTextArea implements KeyListener, DocumentListener
{
    static final long serialVersionUID = 8557083244830872961L;
    private ConsoleWriter console1;
    private ConsoleWriter console2;
    private PrintStream out;
    private PrintStream err;
    private PrintWriter inPipe;
    private PipedInputStream in;
    private List<String> history;
    private int historyIndex;
    private int outputMark;
    
    @Override
    public void select(final int start, final int end) {
        this.requestFocus();
        super.select(start, end);
    }
    
    public ConsoleTextArea(final String[] argv) {
        this.historyIndex = -1;
        this.outputMark = 0;
        this.history = new ArrayList<String>();
        this.console1 = new ConsoleWriter(this);
        this.console2 = new ConsoleWriter(this);
        this.out = new PrintStream(this.console1, true);
        this.err = new PrintStream(this.console2, true);
        final PipedOutputStream outPipe = new PipedOutputStream();
        this.inPipe = new PrintWriter(outPipe);
        this.in = new PipedInputStream();
        try {
            outPipe.connect(this.in);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        this.getDocument().addDocumentListener(this);
        this.addKeyListener(this);
        this.setLineWrap(true);
        this.setFont(new Font("Monospaced", 0, 12));
    }
    
    synchronized void returnPressed() {
        final Document doc = this.getDocument();
        final int len = doc.getLength();
        final Segment segment = new Segment();
        try {
            doc.getText(this.outputMark, len - this.outputMark, segment);
        }
        catch (BadLocationException ignored) {
            ignored.printStackTrace();
        }
        if (segment.count > 0) {
            this.history.add(segment.toString());
        }
        this.historyIndex = this.history.size();
        this.inPipe.write(segment.array, segment.offset, segment.count);
        this.append("\n");
        this.outputMark = doc.getLength();
        this.inPipe.write("\n");
        this.inPipe.flush();
        this.console1.flush();
    }
    
    public void eval(final String str) {
        this.inPipe.write(str);
        this.inPipe.write("\n");
        this.inPipe.flush();
        this.console1.flush();
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        final int code = e.getKeyCode();
        if (code == 8 || code == 37) {
            if (this.outputMark == this.getCaretPosition()) {
                e.consume();
            }
        }
        else if (code == 36) {
            final int caretPos = this.getCaretPosition();
            if (caretPos == this.outputMark) {
                e.consume();
            }
            else if (caretPos > this.outputMark && !e.isControlDown()) {
                if (e.isShiftDown()) {
                    this.moveCaretPosition(this.outputMark);
                }
                else {
                    this.setCaretPosition(this.outputMark);
                }
                e.consume();
            }
        }
        else if (code == 10) {
            this.returnPressed();
            e.consume();
        }
        else if (code == 38) {
            --this.historyIndex;
            if (this.historyIndex >= 0) {
                if (this.historyIndex >= this.history.size()) {
                    this.historyIndex = this.history.size() - 1;
                }
                if (this.historyIndex >= 0) {
                    final String str = this.history.get(this.historyIndex);
                    final int len = this.getDocument().getLength();
                    this.replaceRange(str, this.outputMark, len);
                    final int caretPos2 = this.outputMark + str.length();
                    this.select(caretPos2, caretPos2);
                }
                else {
                    ++this.historyIndex;
                }
            }
            else {
                ++this.historyIndex;
            }
            e.consume();
        }
        else if (code == 40) {
            int caretPos = this.outputMark;
            if (this.history.size() > 0) {
                ++this.historyIndex;
                if (this.historyIndex < 0) {
                    this.historyIndex = 0;
                }
                final int len = this.getDocument().getLength();
                if (this.historyIndex < this.history.size()) {
                    final String str2 = this.history.get(this.historyIndex);
                    this.replaceRange(str2, this.outputMark, len);
                    caretPos = this.outputMark + str2.length();
                }
                else {
                    this.historyIndex = this.history.size();
                    this.replaceRange("", this.outputMark, len);
                }
            }
            this.select(caretPos, caretPos);
            e.consume();
        }
    }
    
    @Override
    public void keyTyped(final KeyEvent e) {
        final int keyChar = e.getKeyChar();
        if (keyChar == 8) {
            if (this.outputMark == this.getCaretPosition()) {
                e.consume();
            }
        }
        else if (this.getCaretPosition() < this.outputMark) {
            this.setCaretPosition(this.outputMark);
        }
    }
    
    @Override
    public synchronized void keyReleased(final KeyEvent e) {
    }
    
    public synchronized void write(final String str) {
        this.insert(str, this.outputMark);
        final int len = str.length();
        this.select(this.outputMark += len, this.outputMark);
    }
    
    @Override
    public synchronized void insertUpdate(final DocumentEvent e) {
        final int len = e.getLength();
        final int off = e.getOffset();
        if (this.outputMark > off) {
            this.outputMark += len;
        }
    }
    
    @Override
    public synchronized void removeUpdate(final DocumentEvent e) {
        final int len = e.getLength();
        final int off = e.getOffset();
        if (this.outputMark > off) {
            if (this.outputMark >= off + len) {
                this.outputMark -= len;
            }
            else {
                this.outputMark = off;
            }
        }
    }
    
    public synchronized void postUpdateUI() {
        this.requestFocus();
        this.setCaret(this.getCaret());
        this.select(this.outputMark, this.outputMark);
    }
    
    @Override
    public synchronized void changedUpdate(final DocumentEvent e) {
    }
    
    public InputStream getIn() {
        return this.in;
    }
    
    public PrintStream getOut() {
        return this.out;
    }
    
    public PrintStream getErr() {
        return this.err;
    }
}
