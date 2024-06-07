//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.*;
import java.util.*;

public class Environment extends ScriptableObject
{
    static final long serialVersionUID = -430727378460177065L;
    private Environment thePrototypeInstance;
    
    public static void defineClass(final ScriptableObject scope) {
        try {
            ScriptableObject.defineClass((Scriptable)scope, (Class)Environment.class);
        }
        catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
    
    public String getClassName() {
        return "Environment";
    }
    
    public Environment() {
        this.thePrototypeInstance = null;
        if (this.thePrototypeInstance == null) {
            this.thePrototypeInstance = this;
        }
    }
    
    public Environment(final ScriptableObject scope) {
        this.thePrototypeInstance = null;
        this.setParentScope((Scriptable)scope);
        final Object ctor = ScriptRuntime.getTopLevelProp((Scriptable)scope, "Environment");
        if (ctor != null && ctor instanceof Scriptable) {
            final Scriptable s = (Scriptable)ctor;
            this.setPrototype((Scriptable)s.get("prototype", s));
        }
    }
    
    public boolean has(final String name, final Scriptable start) {
        if (this == this.thePrototypeInstance) {
            return super.has(name, start);
        }
        return System.getProperty(name) != null;
    }
    
    public Object get(final String name, final Scriptable start) {
        if (this == this.thePrototypeInstance) {
            return super.get(name, start);
        }
        final String result = System.getProperty(name);
        if (result != null) {
            return ScriptRuntime.toObject(this.getParentScope(), (Object)result);
        }
        return Scriptable.NOT_FOUND;
    }
    
    public void put(final String name, final Scriptable start, final Object value) {
        if (this == this.thePrototypeInstance) {
            super.put(name, start, value);
        }
        else {
            System.getProperties().put(name, ScriptRuntime.toString(value));
        }
    }
    
    private Object[] collectIds() {
        final Map<Object, Object> props = System.getProperties();
        return props.keySet().toArray();
    }
    
    public Object[] getIds() {
        if (this == this.thePrototypeInstance) {
            return super.getIds();
        }
        return this.collectIds();
    }
    
    public Object[] getAllIds() {
        if (this == this.thePrototypeInstance) {
            return super.getAllIds();
        }
        return this.collectIds();
    }
}
