//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.io.*;

public class Kit
{
    public static Class<?> classOrNull(final String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException ex) {}
        catch (SecurityException ex2) {}
        catch (LinkageError linkageError) {}
        catch (IllegalArgumentException ex3) {}
        return null;
    }
    
    public static Class<?> classOrNull(final ClassLoader loader, final String className) {
        try {
            return loader.loadClass(className);
        }
        catch (ClassNotFoundException ex) {}
        catch (SecurityException ex2) {}
        catch (LinkageError linkageError) {}
        catch (IllegalArgumentException ex3) {}
        return null;
    }
    
    static Object newInstanceOrNull(final Class<?> cl) {
        try {
            return cl.newInstance();
        }
        catch (SecurityException ex) {}
        catch (LinkageError linkageError) {}
        catch (InstantiationException ex2) {}
        catch (IllegalAccessException ex3) {}
        return null;
    }
    
    static boolean testIfCanLoadRhinoClasses(final ClassLoader loader) {
        final Class<?> testClass = ScriptRuntime.ContextFactoryClass;
        final Class<?> x = classOrNull(loader, testClass.getName());
        return x == testClass;
    }
    
    public static int xDigitToInt(int c, final int accumulator) {
        if (c <= 57) {
            c -= 48;
            if (0 <= c) {
                return accumulator << 4 | c;
            }
        }
        else if (c <= 70) {
            if (65 <= c) {
                c -= 55;
                return accumulator << 4 | c;
            }
        }
        else if (c <= 102 && 97 <= c) {
            c -= 87;
            return accumulator << 4 | c;
        }
        return -1;
    }
    
    public static Object addListener(Object bag, final Object listener) {
        if (listener == null) {
            throw new IllegalArgumentException();
        }
        if (listener instanceof Object[]) {
            throw new IllegalArgumentException();
        }
        if (bag == null) {
            bag = listener;
        }
        else if (!(bag instanceof Object[])) {
            bag = new Object[] { bag, listener };
        }
        else {
            final Object[] array = (Object[])bag;
            final int L = array.length;
            if (L < 2) {
                throw new IllegalArgumentException();
            }
            final Object[] tmp = new Object[L + 1];
            System.arraycopy(array, 0, tmp, 0, L);
            tmp[L] = listener;
            bag = tmp;
        }
        return bag;
    }
    
    public static Object removeListener(Object bag, final Object listener) {
        if (listener == null) {
            throw new IllegalArgumentException();
        }
        if (listener instanceof Object[]) {
            throw new IllegalArgumentException();
        }
        if (bag == listener) {
            bag = null;
        }
        else if (bag instanceof Object[]) {
            final Object[] array = (Object[])bag;
            final int L = array.length;
            if (L < 2) {
                throw new IllegalArgumentException();
            }
            if (L == 2) {
                if (array[1] == listener) {
                    bag = array[0];
                }
                else if (array[0] == listener) {
                    bag = array[1];
                }
            }
            else {
                int i = L;
                do {
                    --i;
                    if (array[i] == listener) {
                        final Object[] tmp = new Object[L - 1];
                        System.arraycopy(array, 0, tmp, 0, i);
                        System.arraycopy(array, i + 1, tmp, i, L - (i + 1));
                        bag = tmp;
                        break;
                    }
                } while (i != 0);
            }
        }
        return bag;
    }
    
    public static Object getListener(final Object bag, final int index) {
        if (index == 0) {
            if (bag == null) {
                return null;
            }
            if (!(bag instanceof Object[])) {
                return bag;
            }
            final Object[] array = (Object[])bag;
            if (array.length < 2) {
                throw new IllegalArgumentException();
            }
            return array[0];
        }
        else if (index == 1) {
            if (bag instanceof Object[]) {
                final Object[] array = (Object[])bag;
                return array[1];
            }
            if (bag == null) {
                throw new IllegalArgumentException();
            }
            return null;
        }
        else {
            final Object[] array = (Object[])bag;
            final int L = array.length;
            if (L < 2) {
                throw new IllegalArgumentException();
            }
            if (index == L) {
                return null;
            }
            return array[index];
        }
    }
    
    static Object initHash(final Map<Object, Object> h, final Object key, Object initialValue, final boolean override) {
        synchronized (h) {
            final Object current = h.get(key);
            if (current == null || override) {
                h.put(key, initialValue);
            }
            else {
                initialValue = current;
            }
        }
        return initialValue;
    }
    
    public static Object makeHashKeyFromPair(final Object key1, final Object key2) {
        if (key1 == null) {
            throw new IllegalArgumentException();
        }
        if (key2 == null) {
            throw new IllegalArgumentException();
        }
        return new ComplexKey(key1, key2);
    }
    
    public static String readReader(final Reader reader) throws IOException {
        try (final BufferedReader in = new BufferedReader(reader)) {
            final char[] cbuf = new char[1024];
            final StringBuilder sb = new StringBuilder(1024);
            int bytes_read;
            while ((bytes_read = in.read(cbuf, 0, 1024)) != -1) {
                sb.append(cbuf, 0, bytes_read);
            }
            return sb.toString();
        }
    }
    
    public static byte[] readStream(final InputStream is, final int initialBufferCapacity) throws IOException {
        if (initialBufferCapacity <= 0) {
            throw new IllegalArgumentException("Bad initialBufferCapacity: " + initialBufferCapacity);
        }
        byte[] buffer = new byte[initialBufferCapacity];
        int cursor = 0;
        while (true) {
            final int n = is.read(buffer, cursor, buffer.length - cursor);
            if (n < 0) {
                break;
            }
            cursor += n;
            if (cursor != buffer.length) {
                continue;
            }
            final byte[] tmp = new byte[buffer.length * 2];
            System.arraycopy(buffer, 0, tmp, 0, cursor);
            buffer = tmp;
        }
        if (cursor != buffer.length) {
            final byte[] tmp2 = new byte[cursor];
            System.arraycopy(buffer, 0, tmp2, 0, cursor);
            buffer = tmp2;
        }
        return buffer;
    }
    
    public static RuntimeException codeBug() throws RuntimeException {
        final RuntimeException ex = new IllegalStateException("FAILED ASSERTION");
        ex.printStackTrace(System.err);
        throw ex;
    }
    
    public static RuntimeException codeBug(String msg) throws RuntimeException {
        msg = "FAILED ASSERTION: " + msg;
        final RuntimeException ex = new IllegalStateException(msg);
        ex.printStackTrace(System.err);
        throw ex;
    }
    
    private static final class ComplexKey
    {
        private Object key1;
        private Object key2;
        private int hash;
        
        ComplexKey(final Object key1, final Object key2) {
            this.key1 = key1;
            this.key2 = key2;
        }
        
        @Override
        public boolean equals(final Object anotherObj) {
            if (!(anotherObj instanceof ComplexKey)) {
                return false;
            }
            final ComplexKey another = (ComplexKey)anotherObj;
            return this.key1.equals(another.key1) && this.key2.equals(another.key2);
        }
        
        @Override
        public int hashCode() {
            if (this.hash == 0) {
                this.hash = (this.key1.hashCode() ^ this.key2.hashCode());
            }
            return this.hash;
        }
    }
}
