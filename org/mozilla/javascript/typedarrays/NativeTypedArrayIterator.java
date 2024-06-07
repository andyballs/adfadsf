//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.typedarrays;

import java.util.*;

public class NativeTypedArrayIterator<T extends Comparable<T>> implements ListIterator<T>
{
    private final NativeTypedArrayView<T> view;
    private int position;
    private int lastPosition;
    
    NativeTypedArrayIterator(final NativeTypedArrayView<T> view, final int start) {
        this.lastPosition = -1;
        this.view = view;
        this.position = start;
    }
    
    @Override
    public boolean hasNext() {
        return this.position < this.view.length;
    }
    
    @Override
    public boolean hasPrevious() {
        return this.position > 0;
    }
    
    @Override
    public int nextIndex() {
        return this.position;
    }
    
    @Override
    public int previousIndex() {
        return this.position - 1;
    }
    
    @Override
    public T next() {
        if (this.hasNext()) {
            final T ret = this.view.get(this.position);
            this.lastPosition = this.position;
            ++this.position;
            return ret;
        }
        throw new NoSuchElementException();
    }
    
    @Override
    public T previous() {
        if (this.hasPrevious()) {
            --this.position;
            this.lastPosition = this.position;
            return this.view.get(this.position);
        }
        throw new NoSuchElementException();
    }
    
    @Override
    public void set(final T t) {
        if (this.lastPosition < 0) {
            throw new IllegalStateException();
        }
        this.view.js_set(this.lastPosition, t);
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void add(final T t) {
        throw new UnsupportedOperationException();
    }
}
