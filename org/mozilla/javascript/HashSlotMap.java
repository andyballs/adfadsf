//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class HashSlotMap implements SlotMap
{
    private final LinkedHashMap<Object, ScriptableObject.Slot> map;
    
    public HashSlotMap() {
        this.map = new LinkedHashMap<Object, ScriptableObject.Slot>();
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    @Override
    public ScriptableObject.Slot query(final Object key, final int index) {
        final Object name = (key == null) ? String.valueOf(index) : key;
        return this.map.get(name);
    }
    
    @Override
    public ScriptableObject.Slot get(final Object key, final int index, final ScriptableObject.SlotAccess accessType) {
        final Object name = (key == null) ? String.valueOf(index) : key;
        final ScriptableObject.Slot slot = this.map.get(name);
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
        return this.createSlot(key, index, name, accessType);
    }
    
    @Override
    public void createSlot(final String key, final ScriptableObject.Slot slot) {
        this.createSlot(key, key.hashCode(), key, ScriptableObject.SlotAccess.MODIFY);
    }
    
    private ScriptableObject.Slot createSlot(final Object key, final int index, final Object name, final ScriptableObject.SlotAccess accessType) {
        final ScriptableObject.Slot slot = this.map.get(name);
        if (slot != null) {
            ScriptableObject.Slot newSlot;
            if (accessType == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER && !(slot instanceof ScriptableObject.GetterSlot)) {
                newSlot = new ScriptableObject.GetterSlot(name, slot.indexOrHash, slot.getAttributes());
            }
            else if (accessType == ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA && slot instanceof ScriptableObject.GetterSlot) {
                newSlot = new ScriptableObject.Slot(name, slot.indexOrHash, slot.getAttributes());
            }
            else {
                if (accessType == ScriptableObject.SlotAccess.MODIFY_CONST) {
                    return null;
                }
                return slot;
            }
            newSlot.setValue(slot.value);
            this.map.put(name, newSlot);
            return newSlot;
        }
        ScriptableObject.Slot newSlot = (accessType == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER) ? new ScriptableObject.GetterSlot(key, index, 0) : new ScriptableObject.Slot(key, index, 0);
        if (accessType == ScriptableObject.SlotAccess.MODIFY_CONST) {
            newSlot.setAttributes(13);
        }
        this.addSlot(newSlot);
        return newSlot;
    }
    
    @Override
    public void addSlot(final ScriptableObject.Slot newSlot) {
        final Object name = (newSlot.name == null) ? String.valueOf(newSlot.indexOrHash) : newSlot.name;
        this.map.put(name, newSlot);
    }
    
    @Override
    public void remove(final Object key, final int index) {
        final Object name = (key == null) ? String.valueOf(index) : key;
        final ScriptableObject.Slot slot = this.map.get(name);
        if (slot != null) {
            if ((slot.getAttributes() & 0x4) != 0x0) {
                final Context cx = Context.getContext();
                if (cx.isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", key);
                }
            }
            else {
                this.map.remove(name);
            }
        }
    }
    
    @Override
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.values().iterator();
    }
}
