//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.serialize;

import java.util.*;
import org.mozilla.javascript.*;
import java.io.*;

public class ScriptableOutputStream extends ObjectOutputStream
{
    private Scriptable scope;
    private Map<Object, String> table;
    
    public ScriptableOutputStream(final OutputStream out, final Scriptable scope) throws IOException {
        super(out);
        this.scope = scope;
        (this.table = new HashMap<Object, String>()).put(scope, "");
        this.enableReplaceObject(true);
        this.excludeStandardObjectNames();
    }
    
    public void excludeAllIds(final Object[] ids) {
        for (final Object id : ids) {
            if (id instanceof String && this.scope.get((String)id, this.scope) instanceof Scriptable) {
                this.addExcludedName((String)id);
            }
        }
    }
    
    public void addOptionalExcludedName(final String name) {
        final Object obj = lookupQualifiedName(this.scope, name);
        if (obj != null && obj != UniqueTag.NOT_FOUND) {
            if (!(obj instanceof Scriptable)) {
                throw new IllegalArgumentException("Object for excluded name " + name + " is not a Scriptable, it is " + obj.getClass().getName());
            }
            this.table.put(obj, name);
        }
    }
    
    public void addExcludedName(final String name) {
        final Object obj = lookupQualifiedName(this.scope, name);
        if (!(obj instanceof Scriptable)) {
            throw new IllegalArgumentException("Object for excluded name " + name + " not found.");
        }
        this.table.put(obj, name);
    }
    
    public boolean hasExcludedName(final String name) {
        return this.table.get(name) != null;
    }
    
    public void removeExcludedName(final String name) {
        this.table.remove(name);
    }
    
    public void excludeStandardObjectNames() {
        final String[] names = { "Object", "Object.prototype", "Function", "Function.prototype", "String", "String.prototype", "Math", "Array", "Array.prototype", "Error", "Error.prototype", "Number", "Number.prototype", "Date", "Date.prototype", "RegExp", "RegExp.prototype", "Script", "Script.prototype", "Continuation", "Continuation.prototype" };
        for (int i = 0; i < names.length; ++i) {
            this.addExcludedName(names[i]);
        }
        final String[] optionalNames = { "XML", "XML.prototype", "XMLList", "XMLList.prototype" };
        for (int j = 0; j < optionalNames.length; ++j) {
            this.addOptionalExcludedName(optionalNames[j]);
        }
    }
    
    static Object lookupQualifiedName(final Scriptable scope, final String qualifiedName) {
        final StringTokenizer st = new StringTokenizer(qualifiedName, ".");
        Object result = scope;
        while (st.hasMoreTokens()) {
            final String s = st.nextToken();
            result = ScriptableObject.getProperty((Scriptable)result, s);
            if (result == null) {
                break;
            }
            if (!(result instanceof Scriptable)) {
                break;
            }
        }
        return result;
    }
    
    @Override
    protected Object replaceObject(final Object obj) throws IOException {
        final String name = this.table.get(obj);
        if (name == null) {
            return obj;
        }
        return new PendingLookup(name);
    }
    
    static class PendingLookup implements Serializable
    {
        private static final long serialVersionUID = -2692990309789917727L;
        private String name;
        
        PendingLookup(final String name) {
            this.name = name;
        }
        
        String getName() {
            return this.name;
        }
    }
}
