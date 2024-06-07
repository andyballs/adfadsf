//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import java.util.*;

public class ConsString implements CharSequence, Serializable
{
    private static final long serialVersionUID = -8432806714471372570L;
    private CharSequence left;
    private CharSequence right;
    private final int length;
    private boolean isFlat;
    
    public ConsString(final CharSequence str1, final CharSequence str2) {
        this.left = str1;
        this.right = str2;
        this.length = this.left.length() + this.right.length();
        this.isFlat = false;
    }
    
    private Object writeReplace() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return (String)(this.isFlat ? this.left : this.flatten());
    }
    
    private synchronized String flatten() {
        if (!this.isFlat) {
            final char[] chars = new char[this.length];
            int charPos = this.length;
            final ArrayDeque<CharSequence> stack = new ArrayDeque<CharSequence>();
            stack.addFirst(this.left);
            CharSequence next = this.right;
            do {
                if (next instanceof ConsString) {
                    final ConsString casted = (ConsString)next;
                    if (!casted.isFlat) {
                        stack.addFirst(casted.left);
                        next = casted.right;
                        continue;
                    }
                    next = casted.left;
                }
                final String str = (String)next;
                charPos -= str.length();
                str.getChars(0, str.length(), chars, charPos);
                next = (stack.isEmpty() ? null : stack.removeFirst());
            } while (next != null);
            this.left = new String(chars);
            this.right = "";
            this.isFlat = true;
        }
        return (String)this.left;
    }
    
    @Override
    public int length() {
        return this.length;
    }
    
    @Override
    public char charAt(final int index) {
        final String str = (String)(this.isFlat ? this.left : this.flatten());
        return str.charAt(index);
    }
    
    @Override
    public CharSequence subSequence(final int start, final int end) {
        final String str = (String)(this.isFlat ? this.left : this.flatten());
        return str.substring(start, end);
    }
}
