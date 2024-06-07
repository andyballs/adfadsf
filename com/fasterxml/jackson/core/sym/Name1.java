//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.sym;

public final class Name1 extends Name
{
    private static final Name1 EMPTY;
    private final int q;
    
    Name1(final String name, final int hash, final int quad) {
        super(name, hash);
        this.q = quad;
    }
    
    public static Name1 getEmptyName() {
        return Name1.EMPTY;
    }
    
    public boolean equals(final int quad) {
        return quad == this.q;
    }
    
    public boolean equals(final int quad1, final int quad2) {
        return quad1 == this.q && quad2 == 0;
    }
    
    public boolean equals(final int q1, final int q2, final int q3) {
        return false;
    }
    
    public boolean equals(final int[] quads, final int qlen) {
        return qlen == 1 && quads[0] == this.q;
    }
    
    static {
        EMPTY = new Name1("", 0, 0);
    }
}
