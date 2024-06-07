//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public class UintMap implements Serializable
{
    private static final long serialVersionUID = 4242698212885848444L;
    private static final int A = -1640531527;
    private static final int EMPTY = -1;
    private static final int DELETED = -2;
    private transient int[] keys;
    private transient Object[] values;
    private int power;
    private int keyCount;
    private transient int occupiedCount;
    private transient int ivaluesShift;
    private static final boolean check = false;
    
    public UintMap() {
        this(4);
    }
    
    public UintMap(final int initialCapacity) {
        if (initialCapacity < 0) {
            Kit.codeBug();
        }
        int minimalCapacity;
        int i;
        for (minimalCapacity = initialCapacity * 4 / 3, i = 2; 1 << i < minimalCapacity; ++i) {}
        this.power = i;
    }
    
    public boolean isEmpty() {
        return this.keyCount == 0;
    }
    
    public int size() {
        return this.keyCount;
    }
    
    public boolean has(final int key) {
        if (key < 0) {
            Kit.codeBug();
        }
        return 0 <= this.findIndex(key);
    }
    
    public Object getObject(final int key) {
        if (key < 0) {
            Kit.codeBug();
        }
        if (this.values != null) {
            final int index = this.findIndex(key);
            if (0 <= index) {
                return this.values[index];
            }
        }
        return null;
    }
    
    public int getInt(final int key, final int defaultValue) {
        if (key < 0) {
            Kit.codeBug();
        }
        final int index = this.findIndex(key);
        if (0 > index) {
            return defaultValue;
        }
        if (this.ivaluesShift != 0) {
            return this.keys[this.ivaluesShift + index];
        }
        return 0;
    }
    
    public int getExistingInt(final int key) {
        if (key < 0) {
            Kit.codeBug();
        }
        final int index = this.findIndex(key);
        if (0 > index) {
            Kit.codeBug();
            return 0;
        }
        if (this.ivaluesShift != 0) {
            return this.keys[this.ivaluesShift + index];
        }
        return 0;
    }
    
    public void put(final int key, final Object value) {
        if (key < 0) {
            Kit.codeBug();
        }
        final int index = this.ensureIndex(key, false);
        if (this.values == null) {
            this.values = new Object[1 << this.power];
        }
        this.values[index] = value;
    }
    
    public void put(final int key, final int value) {
        if (key < 0) {
            Kit.codeBug();
        }
        final int index = this.ensureIndex(key, true);
        if (this.ivaluesShift == 0) {
            final int N = 1 << this.power;
            if (this.keys.length != N * 2) {
                final int[] tmp = new int[N * 2];
                System.arraycopy(this.keys, 0, tmp, 0, N);
                this.keys = tmp;
            }
            this.ivaluesShift = N;
        }
        this.keys[this.ivaluesShift + index] = value;
    }
    
    public void remove(final int key) {
        if (key < 0) {
            Kit.codeBug();
        }
        final int index = this.findIndex(key);
        if (0 <= index) {
            this.keys[index] = -2;
            --this.keyCount;
            if (this.values != null) {
                this.values[index] = null;
            }
            if (this.ivaluesShift != 0) {
                this.keys[this.ivaluesShift + index] = 0;
            }
        }
    }
    
    public void clear() {
        final int N = 1 << this.power;
        if (this.keys != null) {
            for (int i = 0; i != N; ++i) {
                this.keys[i] = -1;
            }
            if (this.values != null) {
                for (int i = 0; i != N; ++i) {
                    this.values[i] = null;
                }
            }
        }
        this.ivaluesShift = 0;
        this.keyCount = 0;
        this.occupiedCount = 0;
    }
    
    public int[] getKeys() {
        final int[] keys = this.keys;
        int n = this.keyCount;
        final int[] result = new int[n];
        int i = 0;
        while (n != 0) {
            final int entry = keys[i];
            if (entry != -1 && entry != -2) {
                result[--n] = entry;
            }
            ++i;
        }
        return result;
    }
    
    private static int tableLookupStep(final int fraction, final int mask, final int power) {
        final int shift = 32 - 2 * power;
        if (shift >= 0) {
            return (fraction >>> shift & mask) | 0x1;
        }
        return (fraction & mask >>> -shift) | 0x1;
    }
    
    private int findIndex(final int key) {
        final int[] keys = this.keys;
        if (keys != null) {
            final int fraction = key * -1640531527;
            int index = fraction >>> 32 - this.power;
            int entry = keys[index];
            if (entry == key) {
                return index;
            }
            if (entry != -1) {
                final int mask = (1 << this.power) - 1;
                final int step = tableLookupStep(fraction, mask, this.power);
                final int n = 0;
                do {
                    index = (index + step & mask);
                    entry = keys[index];
                    if (entry == key) {
                        return index;
                    }
                } while (entry != -1);
            }
        }
        return -1;
    }
    
    private int insertNewKey(final int key) {
        final int[] keys = this.keys;
        final int fraction = key * -1640531527;
        int index = fraction >>> 32 - this.power;
        if (keys[index] != -1) {
            final int mask = (1 << this.power) - 1;
            final int step = tableLookupStep(fraction, mask, this.power);
            final int firstIndex = index;
            do {
                index = (index + step & mask);
            } while (keys[index] != -1);
        }
        keys[index] = key;
        ++this.occupiedCount;
        ++this.keyCount;
        return index;
    }
    
    private void rehashTable(final boolean ensureIntSpace) {
        if (this.keys != null && this.keyCount * 2 >= this.occupiedCount) {
            ++this.power;
        }
        final int N = 1 << this.power;
        final int[] old = this.keys;
        final int oldShift = this.ivaluesShift;
        if (oldShift == 0 && !ensureIntSpace) {
            this.keys = new int[N];
        }
        else {
            this.ivaluesShift = N;
            this.keys = new int[N * 2];
        }
        for (int i = 0; i != N; ++i) {
            this.keys[i] = -1;
        }
        final Object[] oldValues = this.values;
        if (oldValues != null) {
            this.values = new Object[N];
        }
        final int oldCount = this.keyCount;
        this.occupiedCount = 0;
        if (oldCount != 0) {
            this.keyCount = 0;
            int j = 0;
            int remaining = oldCount;
            while (remaining != 0) {
                final int key = old[j];
                if (key != -1 && key != -2) {
                    final int index = this.insertNewKey(key);
                    if (oldValues != null) {
                        this.values[index] = oldValues[j];
                    }
                    if (oldShift != 0) {
                        this.keys[this.ivaluesShift + index] = old[oldShift + j];
                    }
                    --remaining;
                }
                ++j;
            }
        }
    }
    
    private int ensureIndex(final int key, final boolean intType) {
        int index = -1;
        int firstDeleted = -1;
        final int[] keys = this.keys;
        if (keys != null) {
            final int fraction = key * -1640531527;
            index = fraction >>> 32 - this.power;
            int entry = keys[index];
            if (entry == key) {
                return index;
            }
            if (entry != -1) {
                if (entry == -2) {
                    firstDeleted = index;
                }
                final int mask = (1 << this.power) - 1;
                final int step = tableLookupStep(fraction, mask, this.power);
                final int n = 0;
                do {
                    index = (index + step & mask);
                    entry = keys[index];
                    if (entry == key) {
                        return index;
                    }
                    if (entry != -2 || firstDeleted >= 0) {
                        continue;
                    }
                    firstDeleted = index;
                } while (entry != -1);
            }
        }
        if (firstDeleted >= 0) {
            index = firstDeleted;
        }
        else {
            if (keys == null || this.occupiedCount * 4 >= (1 << this.power) * 3) {
                this.rehashTable(intType);
                return this.insertNewKey(key);
            }
            ++this.occupiedCount;
        }
        keys[index] = key;
        ++this.keyCount;
        return index;
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int count = this.keyCount;
        if (count != 0) {
            final boolean hasIntValues = this.ivaluesShift != 0;
            final boolean hasObjectValues = this.values != null;
            out.writeBoolean(hasIntValues);
            out.writeBoolean(hasObjectValues);
            int i = 0;
            while (count != 0) {
                final int key = this.keys[i];
                if (key != -1 && key != -2) {
                    --count;
                    out.writeInt(key);
                    if (hasIntValues) {
                        out.writeInt(this.keys[this.ivaluesShift + i]);
                    }
                    if (hasObjectValues) {
                        out.writeObject(this.values[i]);
                    }
                }
                ++i;
            }
        }
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        final int writtenKeyCount = this.keyCount;
        if (writtenKeyCount != 0) {
            this.keyCount = 0;
            final boolean hasIntValues = in.readBoolean();
            final boolean hasObjectValues = in.readBoolean();
            final int N = 1 << this.power;
            if (hasIntValues) {
                this.keys = new int[2 * N];
                this.ivaluesShift = N;
            }
            else {
                this.keys = new int[N];
            }
            for (int i = 0; i != N; ++i) {
                this.keys[i] = -1;
            }
            if (hasObjectValues) {
                this.values = new Object[N];
            }
            for (int i = 0; i != writtenKeyCount; ++i) {
                final int key = in.readInt();
                final int index = this.insertNewKey(key);
                if (hasIntValues) {
                    final int ivalue = in.readInt();
                    this.keys[this.ivaluesShift + index] = ivalue;
                }
                if (hasObjectValues) {
                    this.values[index] = in.readObject();
                }
            }
        }
    }
}
