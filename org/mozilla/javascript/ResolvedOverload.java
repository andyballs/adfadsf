//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

class ResolvedOverload
{
    final Class<?>[] types;
    final int index;
    
    ResolvedOverload(final Object[] args, final int index) {
        this.index = index;
        this.types = (Class<?>[])new Class[args.length];
        for (int i = 0, l = args.length; i < l; ++i) {
            Object arg = args[i];
            if (arg instanceof Wrapper) {
                arg = ((Wrapper)arg).unwrap();
            }
            this.types[i] = ((arg == null) ? null : arg.getClass());
        }
    }
    
    boolean matches(final Object[] args) {
        if (args.length != this.types.length) {
            return false;
        }
        for (int i = 0, l = args.length; i < l; ++i) {
            Object arg = args[i];
            if (arg instanceof Wrapper) {
                arg = ((Wrapper)arg).unwrap();
            }
            if (arg == null) {
                if (this.types[i] != null) {
                    return false;
                }
            }
            else if (arg.getClass() != this.types[i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof ResolvedOverload)) {
            return false;
        }
        final ResolvedOverload ovl = (ResolvedOverload)other;
        return Arrays.equals(this.types, ovl.types) && this.index == ovl.index;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.types);
    }
}
