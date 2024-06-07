//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

class SlotMapContainer implements SlotMap
{
    private static final int LARGE_HASH_SIZE = 2000;
    protected SlotMap map;
    
    SlotMapContainer(final int initialSize) {
        if (initialSize > 2000) {
            this.map = (SlotMap)new HashSlotMap();
        }
        else {
            this.map = (SlotMap)new EmbeddedSlotMap();
        }
    }
    
    public int size() {
        return this.map.size();
    }
    
    public int dirtySize() {
        return this.map.size();
    }
    
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    public ScriptableObject.Slot get(final Object key, final int index, final ScriptableObject.SlotAccess accessType) {
        if (accessType != ScriptableObject.SlotAccess.QUERY) {
            this.checkMapSize();
        }
        return this.map.get(key, index, accessType);
    }
    
    public ScriptableObject.Slot query(final Object key, final int index) {
        return this.map.query(key, index);
    }
    
    public void addSlot(final ScriptableObject.Slot newSlot) {
        this.checkMapSize();
        this.map.addSlot(newSlot);
    }
    
    public void createSlot(final String key, final ScriptableObject.Slot slot) {
        this.map.createSlot(key, slot);
    }
    
    public void remove(final Object key, final int index) {
        this.map.remove(key, index);
    }
    
    public Iterator<ScriptableObject.Slot> iterator() {
        return (Iterator<ScriptableObject.Slot>)this.map.iterator();
    }
    
    public long readLock() {
        return 0L;
    }
    
    public void unlockRead(final long stamp) {
    }
    
    protected void checkMapSize() {
        if (this.map instanceof EmbeddedSlotMap && this.map.size() >= 2000) {
            final SlotMap newMap = (SlotMap)new HashSlotMap();
            for (final ScriptableObject.Slot s : this.map) {
                newMap.addSlot(s);
            }
            this.map = newMap;
        }
    }
}
