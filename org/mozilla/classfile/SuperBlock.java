//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

final class SuperBlock
{
    private int index;
    private int start;
    private int end;
    private int[] locals;
    private int[] stack;
    private boolean isInitialized;
    private boolean isInQueue;
    
    SuperBlock(final int index, final int start, final int end, final int[] initialLocals) {
        this.index = index;
        this.start = start;
        this.end = end;
        System.arraycopy(initialLocals, 0, this.locals = new int[initialLocals.length], 0, initialLocals.length);
        this.stack = new int[0];
        this.isInitialized = false;
        this.isInQueue = false;
    }
    
    int getIndex() {
        return this.index;
    }
    
    int[] getLocals() {
        final int[] copy = new int[this.locals.length];
        System.arraycopy(this.locals, 0, copy, 0, this.locals.length);
        return copy;
    }
    
    int[] getTrimmedLocals() {
        int last;
        for (last = this.locals.length - 1; last >= 0 && this.locals[last] == 0 && !TypeInfo.isTwoWords(this.locals[last - 1]); --last) {}
        int size = ++last;
        for (int i = 0; i < last; ++i) {
            if (TypeInfo.isTwoWords(this.locals[i])) {
                --size;
            }
        }
        final int[] copy = new int[size];
        for (int j = 0, k = 0; j < size; ++j, ++k) {
            copy[j] = this.locals[k];
            if (TypeInfo.isTwoWords(this.locals[k])) {
                ++k;
            }
        }
        return copy;
    }
    
    int[] getStack() {
        final int[] copy = new int[this.stack.length];
        System.arraycopy(this.stack, 0, copy, 0, this.stack.length);
        return copy;
    }
    
    boolean merge(final int[] locals, final int localsTop, final int[] stack, final int stackTop, final ConstantPool pool) {
        if (!this.isInitialized) {
            System.arraycopy(locals, 0, this.locals, 0, localsTop);
            System.arraycopy(stack, 0, this.stack = new int[stackTop], 0, stackTop);
            return this.isInitialized = true;
        }
        if (this.locals.length == localsTop && this.stack.length == stackTop) {
            final boolean localsChanged = this.mergeState(this.locals, locals, localsTop, pool);
            final boolean stackChanged = this.mergeState(this.stack, stack, stackTop, pool);
            return localsChanged || stackChanged;
        }
        throw new IllegalArgumentException("bad merge attempt");
    }
    
    private boolean mergeState(final int[] current, final int[] incoming, final int size, final ConstantPool pool) {
        boolean changed = false;
        for (int i = 0; i < size; ++i) {
            final int currentType = current[i];
            current[i] = TypeInfo.merge(current[i], incoming[i], pool);
            if (currentType != current[i]) {
                changed = true;
            }
        }
        return changed;
    }
    
    int getStart() {
        return this.start;
    }
    
    int getEnd() {
        return this.end;
    }
    
    @Override
    public String toString() {
        return "sb " + this.index;
    }
    
    boolean isInitialized() {
        return this.isInitialized;
    }
    
    void setInitialized(final boolean b) {
        this.isInitialized = b;
    }
    
    boolean isInQueue() {
        return this.isInQueue;
    }
    
    void setInQueue(final boolean b) {
        this.isInQueue = b;
    }
}
