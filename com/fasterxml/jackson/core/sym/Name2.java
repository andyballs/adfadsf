//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.sym;

public final class Name2 extends Name
{
    private final int q1;
    private final int q2;
    
    Name2(final String name, final int hash, final int quad1, final int quad2) {
        super(name, hash);
        this.q1 = quad1;
        this.q2 = quad2;
    }
    
    public boolean equals(final int quad) {
        return false;
    }
    
    public boolean equals(final int quad1, final int quad2) {
        return quad1 == this.q1 && quad2 == this.q2;
    }
    
    public boolean equals(final int quad1, final int quad2, final int q3) {
        return false;
    }
    
    public boolean equals(final int[] quads, final int qlen) {
        return qlen == 2 && quads[0] == this.q1 && quads[1] == this.q2;
    }
}
