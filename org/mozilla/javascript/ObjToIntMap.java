//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public class ObjToIntMap implements Serializable
{
    private static final long serialVersionUID = -1542220580748809402L;
    private static final int A = -1640531527;
    private static final Object DELETED;
    private transient Object[] keys;
    private transient int[] values;
    private int power;
    private int keyCount;
    private transient int occupiedCount;
    private static final boolean check = false;
    
    public ObjToIntMap() {
        this(4);
    }
    
    public ObjToIntMap(final int keyCountHint) {
        if (keyCountHint < 0) {
            Kit.codeBug();
        }
        int minimalCapacity;
        int i;
        for (minimalCapacity = keyCountHint * 4 / 3, i = 2; 1 << i < minimalCapacity; ++i) {}
        this.power = i;
    }
    
    public boolean isEmpty() {
        return this.keyCount == 0;
    }
    
    public int size() {
        return this.keyCount;
    }
    
    public boolean has(Object key) {
        if (key == null) {
            key = UniqueTag.NULL_VALUE;
        }
        return 0 <= this.findIndex(key);
    }
    
    public int get(Object key, final int defaultValue) {
        if (key == null) {
            key = UniqueTag.NULL_VALUE;
        }
        final int index = this.findIndex(key);
        if (0 <= index) {
            return this.values[index];
        }
        return defaultValue;
    }
    
    public int getExisting(Object key) {
        if (key == null) {
            key = UniqueTag.NULL_VALUE;
        }
        final int index = this.findIndex(key);
        if (0 <= index) {
            return this.values[index];
        }
        Kit.codeBug();
        return 0;
    }
    
    public void put(Object key, final int value) {
        if (key == null) {
            key = UniqueTag.NULL_VALUE;
        }
        final int index = this.ensureIndex(key);
        this.values[index] = value;
    }
    
    public Object intern(Object keyArg) {
        boolean nullKey = false;
        if (keyArg == null) {
            nullKey = true;
            keyArg = UniqueTag.NULL_VALUE;
        }
        final int index = this.ensureIndex(keyArg);
        this.values[index] = 0;
        return nullKey ? null : this.keys[index];
    }
    
    public void remove(Object key) {
        if (key == null) {
            key = UniqueTag.NULL_VALUE;
        }
        final int index = this.findIndex(key);
        if (0 <= index) {
            this.keys[index] = ObjToIntMap.DELETED;
            --this.keyCount;
        }
    }
    
    public void clear() {
        for (int i = this.keys.length; i != 0; this.keys[--i] = null) {}
        this.keyCount = 0;
        this.occupiedCount = 0;
    }
    
    public Iterator newIterator() {
        return new Iterator(this);
    }
    
    final void initIterator(final Iterator i) {
        i.init(this.keys, this.values, this.keyCount);
    }
    
    public Object[] getKeys() {
        final Object[] array = new Object[this.keyCount];
        this.getKeys(array, 0);
        return array;
    }
    
    public void getKeys(final Object[] array, int offset) {
        int count = this.keyCount;
        int i = 0;
        while (count != 0) {
            Object key = this.keys[i];
            if (key != null && key != ObjToIntMap.DELETED) {
                if (key == UniqueTag.NULL_VALUE) {
                    key = null;
                }
                array[offset] = key;
                ++offset;
                --count;
            }
            ++i;
        }
    }
    
    private static int tableLookupStep(final int fraction, final int mask, final int power) {
        final int shift = 32 - 2 * power;
        if (shift >= 0) {
            return (fraction >>> shift & mask) | 0x1;
        }
        return (fraction & mask >>> -shift) | 0x1;
    }
    
    private int findIndex(final Object key) {
        if (this.keys != null) {
            final int hash = key.hashCode();
            final int fraction = hash * -1640531527;
            int index = fraction >>> 32 - this.power;
            Object test = this.keys[index];
            if (test != null) {
                final int N = 1 << this.power;
                if (test == key || (this.values[N + index] == hash && test.equals(key))) {
                    return index;
                }
                final int mask = N - 1;
                final int step = tableLookupStep(fraction, mask, this.power);
                final int n = 0;
                do {
                    index = (index + step & mask);
                    test = this.keys[index];
                    if (test == null) {
                        return -1;
                    }
                } while (test != key && (this.values[N + index] != hash || !test.equals(key)));
                return index;
            }
        }
        return -1;
    }
    
    private int insertNewKey(final Object key, final int hash) {
        final int fraction = hash * -1640531527;
        int index = fraction >>> 32 - this.power;
        final int N = 1 << this.power;
        if (this.keys[index] != null) {
            final int mask = N - 1;
            final int step = tableLookupStep(fraction, mask, this.power);
            final int firstIndex = index;
            do {
                index = (index + step & mask);
            } while (this.keys[index] != null);
        }
        this.keys[index] = key;
        this.values[N + index] = hash;
        ++this.occupiedCount;
        ++this.keyCount;
        return index;
    }
    
    private void rehashTable() {
        if (this.keys == null) {
            final int N = 1 << this.power;
            this.keys = new Object[N];
            this.values = new int[2 * N];
        }
        else {
            if (this.keyCount * 2 >= this.occupiedCount) {
                ++this.power;
            }
            final int N = 1 << this.power;
            final Object[] oldKeys = this.keys;
            final int[] oldValues = this.values;
            final int oldN = oldKeys.length;
            this.keys = new Object[N];
            this.values = new int[2 * N];
            int remaining = this.keyCount;
            final int n = 0;
            this.keyCount = n;
            this.occupiedCount = n;
            int i = 0;
            while (remaining != 0) {
                final Object key = oldKeys[i];
                if (key != null && key != ObjToIntMap.DELETED) {
                    final int keyHash = oldValues[oldN + i];
                    final int index = this.insertNewKey(key, keyHash);
                    this.values[index] = oldValues[i];
                    --remaining;
                }
                ++i;
            }
        }
    }
    
    private int ensureIndex(final Object key) {
        final int hash = key.hashCode();
        int index = -1;
        int firstDeleted = -1;
        if (this.keys != null) {
            final int fraction = hash * -1640531527;
            index = fraction >>> 32 - this.power;
            Object test = this.keys[index];
            if (test != null) {
                final int N = 1 << this.power;
                if (test == key || (this.values[N + index] == hash && test.equals(key))) {
                    return index;
                }
                if (test == ObjToIntMap.DELETED) {
                    firstDeleted = index;
                }
                final int mask = N - 1;
                final int step = tableLookupStep(fraction, mask, this.power);
                final int n = 0;
                while (true) {
                    index = (index + step & mask);
                    test = this.keys[index];
                    if (test == null) {
                        break;
                    }
                    if (test == key || (this.values[N + index] == hash && test.equals(key))) {
                        return index;
                    }
                    if (test != ObjToIntMap.DELETED || firstDeleted >= 0) {
                        continue;
                    }
                    firstDeleted = index;
                }
            }
        }
        if (firstDeleted >= 0) {
            index = firstDeleted;
        }
        else {
            if (this.keys == null || this.occupiedCount * 4 >= (1 << this.power) * 3) {
                this.rehashTable();
                return this.insertNewKey(key, hash);
            }
            ++this.occupiedCount;
        }
        this.keys[index] = key;
        this.values[(1 << this.power) + index] = hash;
        ++this.keyCount;
        return index;
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int count = this.keyCount;
        int i = 0;
        while (count != 0) {
            final Object key = this.keys[i];
            if (key != null && key != ObjToIntMap.DELETED) {
                --count;
                out.writeObject(key);
                out.writeInt(this.values[i]);
            }
            ++i;
        }
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        final int writtenKeyCount = this.keyCount;
        if (writtenKeyCount != 0) {
            this.keyCount = 0;
            final int N = 1 << this.power;
            this.keys = new Object[N];
            this.values = new int[2 * N];
            for (int i = 0; i != writtenKeyCount; ++i) {
                final Object key = in.readObject();
                final int hash = key.hashCode();
                final int index = this.insertNewKey(key, hash);
                this.values[index] = in.readInt();
            }
        }
    }
    
    static {
        DELETED = new Object();
    }
    
    public static class Iterator
    {
        ObjToIntMap master;
        private int cursor;
        private int remaining;
        private Object[] keys;
        private int[] values;
        
        Iterator(final ObjToIntMap master) {
            this.master = master;
        }
        
        final void init(final Object[] keys, final int[] values, final int keyCount) {
            this.keys = keys;
            this.values = values;
            this.cursor = -1;
            this.remaining = keyCount;
        }
        
        public void start() {
            this.master.initIterator(this);
            this.next();
        }
        
        public boolean done() {
            return this.remaining < 0;
        }
        
        public void next() {
            if (this.remaining == -1) {
                Kit.codeBug();
            }
            if (this.remaining == 0) {
                this.remaining = -1;
                this.cursor = -1;
            }
            else {
                ++this.cursor;
                while (true) {
                    final Object key = this.keys[this.cursor];
                    if (key != null && key != ObjToIntMap.DELETED) {
                        break;
                    }
                    ++this.cursor;
                }
                --this.remaining;
            }
        }
        
        public Object getKey() {
            Object key = this.keys[this.cursor];
            if (key == UniqueTag.NULL_VALUE) {
                key = null;
            }
            return key;
        }
        
        public int getValue() {
            return this.values[this.cursor];
        }
        
        public void setValue(final int value) {
            this.values[this.cursor] = value;
        }
    }
}
