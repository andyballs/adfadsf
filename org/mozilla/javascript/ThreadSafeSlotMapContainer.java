//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.concurrent.locks.*;
import java.util.*;

class ThreadSafeSlotMapContainer extends SlotMapContainer
{
    private final StampedLock lock;
    
    ThreadSafeSlotMapContainer(final int initialSize) {
        super(initialSize);
        this.lock = new StampedLock();
    }
    
    public int size() {
        long stamp = this.lock.tryOptimisticRead();
        final int s = this.map.size();
        if (this.lock.validate(stamp)) {
            return s;
        }
        stamp = this.lock.readLock();
        try {
            return this.map.size();
        }
        finally {
            this.lock.unlockRead(stamp);
        }
    }
    
    public int dirtySize() {
        assert this.lock.isReadLocked();
        return this.map.size();
    }
    
    public boolean isEmpty() {
        long stamp = this.lock.tryOptimisticRead();
        final boolean e = this.map.isEmpty();
        if (this.lock.validate(stamp)) {
            return e;
        }
        stamp = this.lock.readLock();
        try {
            return this.map.isEmpty();
        }
        finally {
            this.lock.unlockRead(stamp);
        }
    }
    
    public ScriptableObject.Slot get(final Object key, final int index, final ScriptableObject.SlotAccess accessType) {
        final long stamp = this.lock.writeLock();
        try {
            if (accessType != ScriptableObject.SlotAccess.QUERY) {
                this.checkMapSize();
            }
            return this.map.get(key, index, accessType);
        }
        finally {
            this.lock.unlockWrite(stamp);
        }
    }
    
    public ScriptableObject.Slot query(final Object key, final int index) {
        long stamp = this.lock.tryOptimisticRead();
        final ScriptableObject.Slot s = this.map.query(key, index);
        if (this.lock.validate(stamp)) {
            return s;
        }
        stamp = this.lock.readLock();
        try {
            return this.map.query(key, index);
        }
        finally {
            this.lock.unlockRead(stamp);
        }
    }
    
    public void addSlot(final ScriptableObject.Slot newSlot) {
        final long stamp = this.lock.writeLock();
        try {
            this.checkMapSize();
            this.map.addSlot(newSlot);
        }
        finally {
            this.lock.unlockWrite(stamp);
        }
    }
    
    public void remove(final Object key, final int index) {
        final long stamp = this.lock.writeLock();
        try {
            this.map.remove(key, index);
        }
        finally {
            this.lock.unlockWrite(stamp);
        }
    }
    
    public long readLock() {
        return this.lock.readLock();
    }
    
    public void unlockRead(final long stamp) {
        this.lock.unlockRead(stamp);
    }
    
    public Iterator<ScriptableObject.Slot> iterator() {
        assert this.lock.isReadLocked();
        return (Iterator<ScriptableObject.Slot>)this.map.iterator();
    }
    
    protected void checkMapSize() {
        assert this.lock.isWriteLocked();
        super.checkMapSize();
    }
}
