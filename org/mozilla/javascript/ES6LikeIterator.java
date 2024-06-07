//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class ES6LikeIterator extends ES6Iterator
{
    private Iterator iterator;
    
    public static ES6LikeIterator from(final Context cx, final Scriptable scope, final Object target) {
        return new ES6LikeIterator(new IteratorLikeIterable(cx, scope, target));
    }
    
    ES6LikeIterator(final IteratorLikeIterable iterator) {
        this.iterator = iterator.iterator();
    }
    
    public boolean isDone(final Context cx, final Scriptable scope) {
        return !this.iterator.hasNext();
    }
    
    public Object nextValue(final Context cx, final Scriptable scope) {
        final Object o = this.iterator.next();
        return o;
    }
    
    public String getClassName() {
        return "Iterator";
    }
}
