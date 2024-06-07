//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public interface SlotMap extends Iterable<ScriptableObject.Slot>
{
    int size();
    
    boolean isEmpty();
    
    ScriptableObject.Slot get(final Object p0, final int p1, final ScriptableObject.SlotAccess p2);
    
    ScriptableObject.Slot query(final Object p0, final int p1);
    
    void addSlot(final ScriptableObject.Slot p0);
    
    void createSlot(final String p0, final ScriptableObject.Slot p1);
    
    void remove(final Object p0, final int p1);
}
