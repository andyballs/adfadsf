//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import java.util.*;

public class Hashtable implements Serializable, Iterable<Entry>
{
    private static final long serialVersionUID = -7151554912419543747L;
    private final HashMap<Object, Entry> map;
    private Entry first;
    private Entry last;
    
    public Hashtable() {
        this.map = new HashMap<Object, Entry>();
        this.first = null;
        this.last = null;
    }
    
    private Entry makeDummy() {
        final Entry d = new Entry();
        d.clear();
        return d;
    }
    
    public int size() {
        return this.map.size();
    }
    
    public void put(final Object key, final Object value) {
        final Entry nv = new Entry(key, value);
        final Entry ev = this.map.putIfAbsent(nv, nv);
        if (ev == null) {
            if (this.first == null) {
                final Entry entry = nv;
                this.last = entry;
                this.first = entry;
            }
            else {
                this.last.next = nv;
                nv.prev = this.last;
                this.last = nv;
            }
        }
        else {
            ev.value = value;
        }
    }
    
    public Object get(final Object key) {
        final Entry e = new Entry(key, null);
        final Entry v = this.map.get(e);
        if (v == null) {
            return null;
        }
        return v.value;
    }
    
    public boolean has(final Object key) {
        final Entry e = new Entry(key, null);
        return this.map.containsKey(e);
    }
    
    public Object delete(final Object key) {
        final Entry e = new Entry(key, null);
        final Entry v = this.map.remove(e);
        if (v == null) {
            return null;
        }
        if (v == this.first) {
            if (v == this.last) {
                v.clear();
                v.prev = null;
            }
            else {
                this.first = v.next;
                this.first.prev = null;
                if (this.first.next != null) {
                    this.first.next.prev = this.first;
                }
            }
        }
        else {
            final Entry prev = v.prev;
            prev.next = v.next;
            v.prev = null;
            if (v.next != null) {
                v.next.prev = prev;
            }
            else {
                assert v == this.last;
                this.last = prev;
            }
        }
        return v.clear();
    }
    
    public void clear() {
        final Iterator<Entry> it = this.iterator();
        it.forEachRemaining(Entry::clear);
        if (this.first != null) {
            final Entry dummy = new Entry();
            dummy.clear();
            this.last.next = dummy;
            final Entry entry = dummy;
            this.last = entry;
            this.first = entry;
        }
        this.map.clear();
    }
    
    @Override
    public Iterator<Entry> iterator() {
        return new Iter(this.first);
    }
    
    public static final class Entry implements Serializable
    {
        private static final long serialVersionUID = 4086572107122965503L;
        protected Object key;
        protected Object value;
        protected boolean deleted;
        protected Entry next;
        protected Entry prev;
        private final int hashCode;
        
        Entry() {
            this.hashCode = 0;
        }
        
        Entry(final Object k, final Object value) {
            if (k instanceof Number && !(k instanceof Double)) {
                this.key = ((Number)k).doubleValue();
            }
            else if (k instanceof ConsString) {
                this.key = k.toString();
            }
            else {
                this.key = k;
            }
            if (this.key == null) {
                this.hashCode = 0;
            }
            else if (k.equals(ScriptRuntime.negativeZero)) {
                this.hashCode = 0;
            }
            else {
                this.hashCode = this.key.hashCode();
            }
            this.value = value;
        }
        
        public Object key() {
            return this.key;
        }
        
        public Object value() {
            return this.value;
        }
        
        Object clear() {
            final Object ret = this.value;
            this.key = Undefined.instance;
            this.value = Undefined.instance;
            this.deleted = true;
            return ret;
        }
        
        @Override
        public int hashCode() {
            return this.hashCode;
        }
        
        @Override
        public boolean equals(final Object o) {
            try {
                return ScriptRuntime.sameZero(this.key, ((Entry)o).key);
            }
            catch (ClassCastException cce) {
                return false;
            }
        }
    }
    
    private final class Iter implements Iterator<Entry>
    {
        private Entry pos;
        
        Iter(final Entry start) {
            final Entry dummy = Hashtable.this.makeDummy();
            dummy.next = start;
            this.pos = dummy;
        }
        
        private void skipDeleted() {
            while (this.pos.next != null && this.pos.next.deleted) {
                this.pos = this.pos.next;
            }
        }
        
        @Override
        public boolean hasNext() {
            this.skipDeleted();
            return this.pos != null && this.pos.next != null;
        }
        
        @Override
        public Entry next() {
            this.skipDeleted();
            if (this.pos == null || this.pos.next == null) {
                throw new NoSuchElementException();
            }
            final Entry e = this.pos.next;
            this.pos = this.pos.next;
            return e;
        }
    }
}
