//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public interface Scriptable
{
    public static final Object NOT_FOUND = UniqueTag.NOT_FOUND;
    
    String getClassName();
    
    Object get(final String p0, final Scriptable p1, final boolean p2);
    
    default Object get(final String name, final Scriptable start) {
        return this.get(name, start, false);
    }
    
    Object get(final int p0, final Scriptable p1);
    
    boolean has(final String p0, final Scriptable p1);
    
    boolean has(final int p0, final Scriptable p1);
    
    void put(final String p0, final Scriptable p1, final Object p2, final boolean p3);
    
    default void put(final String name, final Scriptable start, final Object value) {
        this.put(name, start, value, false);
    }
    
    void put(final int p0, final Scriptable p1, final Object p2);
    
    void declare(final String p0, final Scriptable p1);
    
    void declareConst(final String p0, final Scriptable p1);
    
    void delete(final String p0);
    
    void delete(final int p0);
    
    Scriptable getPrototype();
    
    void setPrototype(final Scriptable p0);
    
    Scriptable getParentScope();
    
    void setParentScope(final Scriptable p0);
    
    Object[] getIds();
    
    Object getDefaultValue(final Class<?> p0);
    
    boolean hasInstance(final Scriptable p0);
}
