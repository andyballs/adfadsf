//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.serialize;

import java.io.*;
import org.mozilla.javascript.*;

public class ScriptableInputStream extends ObjectInputStream
{
    private Scriptable scope;
    private ClassLoader classLoader;
    
    public ScriptableInputStream(final InputStream in, final Scriptable scope) throws IOException {
        super(in);
        this.scope = scope;
        this.enableResolveObject(true);
        final Context cx = Context.getCurrentContext();
        if (cx != null) {
            this.classLoader = cx.getApplicationClassLoader();
        }
    }
    
    @Override
    protected Class<?> resolveClass(final ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        final String name = desc.getName();
        if (this.classLoader != null) {
            try {
                return this.classLoader.loadClass(name);
            }
            catch (ClassNotFoundException ex) {}
        }
        return super.resolveClass(desc);
    }
    
    @Override
    protected Object resolveObject(Object obj) throws IOException {
        if (obj instanceof ScriptableOutputStream.PendingLookup) {
            final String name = ((ScriptableOutputStream.PendingLookup)obj).getName();
            obj = ScriptableOutputStream.lookupQualifiedName(this.scope, name);
            if (obj == Scriptable.NOT_FOUND) {
                throw new IOException("Object " + name + " not found upon deserialization.");
            }
        }
        else if (obj instanceof UniqueTag) {
            obj = ((UniqueTag)obj).readResolve();
        }
        else if (obj instanceof Undefined) {
            obj = ((Undefined)obj).readResolve();
        }
        return obj;
    }
}
