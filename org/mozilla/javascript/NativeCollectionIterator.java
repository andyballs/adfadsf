//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.io.*;

public class NativeCollectionIterator extends ES6Iterator
{
    private static final long serialVersionUID = 7094840979404373443L;
    private String className;
    private Type type;
    private transient Iterator<Hashtable.Entry> iterator;
    
    static void init(final ScriptableObject scope, final String tag, final boolean sealed) {
        ES6Iterator.init(scope, sealed, (IdScriptableObject)new NativeCollectionIterator(tag), tag);
    }
    
    public NativeCollectionIterator(final String tag) {
        this.iterator = Collections.emptyIterator();
        this.className = tag;
        this.iterator = Collections.emptyIterator();
        this.type = Type.BOTH;
    }
    
    public NativeCollectionIterator(final Scriptable scope, final String className, final Type type, final Iterator<Hashtable.Entry> iterator) {
        super(scope, className);
        this.iterator = Collections.emptyIterator();
        this.className = className;
        this.iterator = iterator;
        this.type = type;
    }
    
    public String getClassName() {
        return this.className;
    }
    
    public boolean isDone(final Context cx, final Scriptable scope) {
        return !this.iterator.hasNext();
    }
    
    public Object nextValue(final Context cx, final Scriptable scope) {
        final Hashtable.Entry e = this.iterator.next();
        switch (this.type) {
            case KEYS: {
                return e.key;
            }
            case VALUES: {
                return e.value;
            }
            case BOTH: {
                return cx.newArray(scope, new Object[] { e.key, e.value });
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    private void readObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.className = (String)stream.readObject();
        this.type = (Type)stream.readObject();
        this.iterator = Collections.emptyIterator();
    }
    
    private void writeObject(final ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.className);
        stream.writeObject(this.type);
    }
    
    enum Type
    {
        KEYS, 
        VALUES, 
        BOTH;
    }
}
