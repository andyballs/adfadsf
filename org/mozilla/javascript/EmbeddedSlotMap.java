//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class EmbeddedSlotMap implements SlotMap
{
    private ScriptableObject.Slot[] slots;
    private ScriptableObject.Slot firstAdded;
    private ScriptableObject.Slot lastAdded;
    private int count;
    private static final int INITIAL_SLOT_SIZE = 4;
    
    @Override
    public int size() {
        return this.count;
    }
    
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    @Override
    public Iterator<ScriptableObject.Slot> iterator() {
        return new Iter(this.firstAdded);
    }
    
    @Override
    public ScriptableObject.Slot query(final Object key, final int index) {
        if (this.slots == null) {
            return null;
        }
        final int indexOrHash = (key != null) ? key.hashCode() : index;
        final int slotIndex = getSlotIndex(this.slots.length, indexOrHash);
        for (ScriptableObject.Slot slot = this.slots[slotIndex]; slot != null; slot = slot.next) {
            final Object skey = slot.name;
            if (indexOrHash == slot.indexOrHash && Objects.equals(key, skey)) {
                return slot;
            }
        }
        return null;
    }
    
    @Override
    public ScriptableObject.Slot get(final Object key, final int index, final ScriptableObject.SlotAccess accessType) {
        if (this.slots == null && accessType == ScriptableObject.SlotAccess.QUERY) {
            return null;
        }
        final int indexOrHash = (key != null) ? key.hashCode() : index;
        ScriptableObject.Slot slot = null;
        if (this.slots != null) {
            final int slotIndex = getSlotIndex(this.slots.length, indexOrHash);
            for (slot = this.slots[slotIndex]; slot != null; slot = slot.next) {
                final Object skey = slot.name;
                if (indexOrHash == slot.indexOrHash && Objects.equals(key, skey)) {
                    break;
                }
            }
            switch (accessType) {
                case QUERY: {
                    return slot;
                }
                case MODIFY:
                case MODIFY_CONST: {
                    if (slot != null) {
                        return slot;
                    }
                    break;
                }
                case MODIFY_GETTER_SETTER: {
                    if (slot instanceof ScriptableObject.GetterSlot) {
                        return slot;
                    }
                    break;
                }
                case CONVERT_ACCESSOR_TO_DATA: {
                    if (!(slot instanceof ScriptableObject.GetterSlot)) {
                        return slot;
                    }
                    break;
                }
            }
        }
        return this.createSlot(key, indexOrHash, accessType, slot);
    }
    
    @Override
    public void createSlot(final String key, final ScriptableObject.Slot slot) {
        final ScriptableObject.SlotAccess accessType = ((slot.getAttributes() & 0x8) == 0x0) ? ScriptableObject.SlotAccess.MODIFY : ScriptableObject.SlotAccess.MODIFY_CONST;
        this.createSlot(key, key.hashCode(), accessType, null);
    }
    
    private ScriptableObject.Slot createSlot(final Object key, final int indexOrHash, final ScriptableObject.SlotAccess accessType, final ScriptableObject.Slot existingSlot) {
        if (this.count == 0) {
            this.slots = new ScriptableObject.Slot[4];
        }
        else if (existingSlot != null) {
            final int insertPos = getSlotIndex(this.slots.length, indexOrHash);
            ScriptableObject.Slot slot;
            ScriptableObject.Slot prev;
            for (prev = (slot = this.slots[insertPos]); slot != null && (slot.indexOrHash != indexOrHash || !Objects.equals(key, slot.name)); slot = slot.next) {
                prev = slot;
            }
            if (slot != null) {
                ScriptableObject.Slot newSlot;
                if (accessType == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER && !(slot instanceof ScriptableObject.GetterSlot)) {
                    newSlot = new ScriptableObject.GetterSlot(key, indexOrHash, slot.getAttributes());
                }
                else if (accessType == ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA && slot instanceof ScriptableObject.GetterSlot) {
                    newSlot = new ScriptableObject.Slot(key, indexOrHash, slot.getAttributes());
                }
                else {
                    if (accessType == ScriptableObject.SlotAccess.MODIFY_CONST) {
                        return null;
                    }
                    return slot;
                }
                newSlot.setValue(slot.value);
                newSlot.next = slot.next;
                if (slot == this.firstAdded) {
                    this.firstAdded = newSlot;
                }
                else {
                    ScriptableObject.Slot ps;
                    for (ps = this.firstAdded; ps != null && ps.orderedNext != slot; ps = ps.orderedNext) {}
                    if (ps != null) {
                        ps.orderedNext = newSlot;
                    }
                }
                newSlot.orderedNext = slot.orderedNext;
                if (slot == this.lastAdded) {
                    this.lastAdded = newSlot;
                }
                if (prev == slot) {
                    this.slots[insertPos] = newSlot;
                }
                else {
                    prev.next = newSlot;
                }
                return newSlot;
            }
        }
        if (4 * (this.count + 1) > 3 * this.slots.length) {
            final ScriptableObject.Slot[] newSlots = new ScriptableObject.Slot[this.slots.length * 2];
            this.copyTable(this.slots, newSlots);
            this.slots = newSlots;
        }
        final ScriptableObject.Slot newSlot2 = (accessType == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER) ? new ScriptableObject.GetterSlot(key, indexOrHash, 0) : new ScriptableObject.Slot(key, indexOrHash, 0);
        if (accessType == ScriptableObject.SlotAccess.MODIFY_CONST) {
            newSlot2.setAttributes(13);
        }
        this.insertNewSlot(newSlot2);
        return newSlot2;
    }
    
    @Override
    public void addSlot(final ScriptableObject.Slot newSlot) {
        if (this.slots == null) {
            this.slots = new ScriptableObject.Slot[4];
        }
        this.insertNewSlot(newSlot);
    }
    
    private void insertNewSlot(final ScriptableObject.Slot newSlot) {
        ++this.count;
        if (this.lastAdded != null) {
            this.lastAdded.orderedNext = newSlot;
        }
        if (this.firstAdded == null) {
            this.firstAdded = newSlot;
        }
        this.lastAdded = newSlot;
        this.addKnownAbsentSlot(this.slots, newSlot);
    }
    
    @Override
    public void remove(final Object key, final int index) {
        final int indexOrHash = (key != null) ? key.hashCode() : index;
        if (this.count != 0) {
            final int slotIndex = getSlotIndex(this.slots.length, indexOrHash);
            ScriptableObject.Slot slot;
            ScriptableObject.Slot prev;
            for (prev = (slot = this.slots[slotIndex]); slot != null; slot = slot.next) {
                if (slot.indexOrHash == indexOrHash) {
                    if (slot.name == key) {
                        break;
                    }
                    if (key != null && key.equals(slot.name)) {
                        break;
                    }
                }
                prev = slot;
            }
            if (slot != null) {
                if ((slot.getAttributes() & 0x4) != 0x0) {
                    final Context cx = Context.getContext();
                    if (cx.isStrictMode()) {
                        throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", key);
                    }
                }
                else {
                    --this.count;
                    if (prev == slot) {
                        this.slots[slotIndex] = slot.next;
                    }
                    else {
                        prev.next = slot.next;
                    }
                    if (slot == this.firstAdded) {
                        prev = null;
                        this.firstAdded = slot.orderedNext;
                    }
                    else {
                        for (prev = this.firstAdded; prev.orderedNext != slot; prev = prev.orderedNext) {}
                        prev.orderedNext = slot.orderedNext;
                    }
                    if (slot == this.lastAdded) {
                        this.lastAdded = prev;
                    }
                }
            }
        }
    }
    
    private void copyTable(final ScriptableObject.Slot[] oldSlots, final ScriptableObject.Slot[] newSlots) {
        for (ScriptableObject.Slot slot : oldSlots) {
            while (slot != null) {
                final ScriptableObject.Slot nextSlot = slot.next;
                slot.next = null;
                this.addKnownAbsentSlot(newSlots, slot);
                slot = nextSlot;
            }
        }
    }
    
    private void addKnownAbsentSlot(final ScriptableObject.Slot[] addSlots, final ScriptableObject.Slot slot) {
        final int insertPos = getSlotIndex(addSlots.length, slot.indexOrHash);
        final ScriptableObject.Slot old = addSlots[insertPos];
        addSlots[insertPos] = slot;
        slot.next = old;
    }
    
    private static int getSlotIndex(final int tableSize, final int indexOrHash) {
        return indexOrHash & tableSize - 1;
    }
    
    private static final class Iter implements Iterator<ScriptableObject.Slot>
    {
        private ScriptableObject.Slot next;
        
        Iter(final ScriptableObject.Slot slot) {
            this.next = slot;
        }
        
        @Override
        public boolean hasNext() {
            return this.next != null;
        }
        
        @Override
        public ScriptableObject.Slot next() {
            final ScriptableObject.Slot ret = this.next;
            this.next = this.next.orderedNext;
            return ret;
        }
    }
}
