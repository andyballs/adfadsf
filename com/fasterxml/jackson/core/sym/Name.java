//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.sym;

public abstract class Name
{
    protected final String _name;
    protected final int _hashCode;
    
    protected Name(final String name, final int hashCode) {
        this._name = name;
        this._hashCode = hashCode;
    }
    
    public String getName() {
        return this._name;
    }
    
    public abstract boolean equals(final int p0);
    
    public abstract boolean equals(final int p0, final int p1);
    
    public abstract boolean equals(final int p0, final int p1, final int p2);
    
    public abstract boolean equals(final int[] p0, final int p1);
    
    @Override
    public String toString() {
        return this._name;
    }
    
    @Override
    public final int hashCode() {
        return this._hashCode;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this;
    }
}
