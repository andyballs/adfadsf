//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rtextarea;

import java.util.*;

public final class ClipboardHistory
{
    private static ClipboardHistory instance;
    private List<String> history;
    private int maxSize;
    private static final int DEFAULT_MAX_SIZE = 12;
    
    private ClipboardHistory() {
        this.history = new ArrayList<String>();
        this.maxSize = 12;
    }
    
    public void add(final String str) {
        final int size = this.history.size();
        if (size == 0) {
            this.history.add(str);
        }
        else {
            final int index = this.history.indexOf(str);
            if (index != size - 1) {
                if (index > -1) {
                    this.history.remove(index);
                }
                this.history.add(str);
            }
            this.trim();
        }
    }
    
    public static ClipboardHistory get() {
        if (ClipboardHistory.instance == null) {
            ClipboardHistory.instance = new ClipboardHistory();
        }
        return ClipboardHistory.instance;
    }
    
    public List<String> getHistory() {
        final List<String> copy = new ArrayList<String>(this.history);
        Collections.reverse(copy);
        return copy;
    }
    
    public int getMaxSize() {
        return this.maxSize;
    }
    
    public void setMaxSize(final int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Maximum size must be >= 0");
        }
        this.maxSize = maxSize;
        this.trim();
    }
    
    private void trim() {
        while (this.history.size() > this.maxSize) {
            this.history.remove(0);
        }
    }
}
