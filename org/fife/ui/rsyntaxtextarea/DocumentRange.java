//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

public class DocumentRange implements Comparable<DocumentRange>
{
    private int startOffs;
    private int endOffs;
    
    public DocumentRange(final int startOffs, final int endOffs) {
        this.set(startOffs, endOffs);
    }
    
    @Override
    public int compareTo(final DocumentRange other) {
        if (other == null) {
            return 1;
        }
        final int diff = this.startOffs - other.startOffs;
        if (diff != 0) {
            return diff;
        }
        return this.endOffs - other.endOffs;
    }
    
    @Override
    public boolean equals(final Object other) {
        return other == this || (other instanceof DocumentRange && this.compareTo((DocumentRange)other) == 0);
    }
    
    public int getEndOffset() {
        return this.endOffs;
    }
    
    public int getStartOffset() {
        return this.startOffs;
    }
    
    @Override
    public int hashCode() {
        return this.startOffs + this.endOffs;
    }
    
    public boolean isZeroLength() {
        return this.startOffs == this.endOffs;
    }
    
    public void set(final int start, final int end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("start and end must be >= 0 (" + start + "-" + end + ")");
        }
        if (end < start) {
            throw new IllegalArgumentException("'end' cannot be less than 'start' (" + start + "-" + end + ")");
        }
        this.startOffs = start;
        this.endOffs = end;
    }
    
    @Override
    public String toString() {
        return "[DocumentRange: " + this.startOffs + "-" + this.endOffs + "]";
    }
    
    public DocumentRange translate(final int amount) {
        this.startOffs += amount;
        this.endOffs += amount;
        return this;
    }
}
