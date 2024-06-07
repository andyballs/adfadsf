//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.idswitch;

import java.io.*;

public class FileBody
{
    private char[] buffer;
    private int bufferEnd;
    private int lineBegin;
    private int lineEnd;
    private int nextLineStart;
    private int lineNumber;
    ReplaceItem firstReplace;
    ReplaceItem lastReplace;
    
    public FileBody() {
        this.buffer = new char[16384];
    }
    
    public char[] getBuffer() {
        return this.buffer;
    }
    
    public void readData(final Reader r) throws IOException {
        int capacity = this.buffer.length;
        int offset = 0;
        while (true) {
            final int n_read = r.read(this.buffer, offset, capacity - offset);
            if (n_read < 0) {
                break;
            }
            offset += n_read;
            if (capacity != offset) {
                continue;
            }
            capacity *= 2;
            final char[] tmp = new char[capacity];
            System.arraycopy(this.buffer, 0, tmp, 0, offset);
            this.buffer = tmp;
        }
        this.bufferEnd = offset;
    }
    
    public void writeInitialData(final Writer w) throws IOException {
        w.write(this.buffer, 0, this.bufferEnd);
    }
    
    public void writeData(final Writer w) throws IOException {
        int offset = 0;
        for (ReplaceItem x = this.firstReplace; x != null; x = x.next) {
            final int before_replace = x.begin - offset;
            if (before_replace > 0) {
                w.write(this.buffer, offset, before_replace);
            }
            w.write(x.replacement);
            offset = x.end;
        }
        final int tail = this.bufferEnd - offset;
        if (tail != 0) {
            w.write(this.buffer, offset, tail);
        }
    }
    
    public boolean wasModified() {
        return this.firstReplace != null;
    }
    
    public boolean setReplacement(final int begin, final int end, final String text) {
        if (equals(text, this.buffer, begin, end)) {
            return false;
        }
        final ReplaceItem item = new ReplaceItem(begin, end, text);
        if (this.firstReplace == null) {
            final ReplaceItem replaceItem = item;
            this.lastReplace = replaceItem;
            this.firstReplace = replaceItem;
        }
        else if (begin < this.firstReplace.begin) {
            item.next = this.firstReplace;
            this.firstReplace = item;
        }
        else {
            ReplaceItem cursor = this.firstReplace;
            ReplaceItem next;
            for (next = cursor.next; next != null; next = next.next) {
                if (begin < next.begin) {
                    item.next = next;
                    cursor.next = item;
                    break;
                }
                cursor = next;
            }
            if (next == null) {
                this.lastReplace.next = item;
            }
        }
        return true;
    }
    
    public int getLineNumber() {
        return this.lineNumber;
    }
    
    public int getLineBegin() {
        return this.lineBegin;
    }
    
    public int getLineEnd() {
        return this.lineEnd;
    }
    
    public void startLineLoop() {
        this.lineNumber = 0;
        final int lineBegin = 0;
        this.nextLineStart = lineBegin;
        this.lineEnd = lineBegin;
        this.lineBegin = lineBegin;
    }
    
    public boolean nextLine() {
        if (this.nextLineStart == this.bufferEnd) {
            this.lineNumber = 0;
            return false;
        }
        int c = 0;
        int i;
        for (i = this.nextLineStart; i != this.bufferEnd; ++i) {
            c = this.buffer[i];
            if (c == 10) {
                break;
            }
            if (c == 13) {
                break;
            }
        }
        this.lineBegin = this.nextLineStart;
        if ((this.lineEnd = i) == this.bufferEnd) {
            this.nextLineStart = i;
        }
        else if (c == 13 && i + 1 != this.bufferEnd && this.buffer[i + 1] == '\n') {
            this.nextLineStart = i + 2;
        }
        else {
            this.nextLineStart = i + 1;
        }
        ++this.lineNumber;
        return true;
    }
    
    private static boolean equals(final String str, final char[] array, final int begin, final int end) {
        if (str.length() == end - begin) {
            for (int i = begin, j = 0; i != end; ++i, ++j) {
                if (array[i] != str.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private static class ReplaceItem
    {
        ReplaceItem next;
        int begin;
        int end;
        String replacement;
        
        ReplaceItem(final int begin, final int end, final String text) {
            this.begin = begin;
            this.end = end;
            this.replacement = text;
        }
    }
}
