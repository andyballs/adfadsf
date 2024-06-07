//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.io.*;

public class NativeWeakSet extends IdScriptableObject
{
    private static final long serialVersionUID = 2065753364224029534L;
    private static final Object MAP_TAG;
    private boolean instanceOfWeakSet;
    private transient WeakHashMap<Scriptable, Boolean> map;
    private static final int Id_constructor = 1;
    private static final int Id_add = 2;
    private static final int Id_delete = 3;
    private static final int Id_has = 4;
    private static final int Id_addAll = 5;
    private static final int Id_deleteAll = 6;
    private static final int SymbolId_toStringTag = 7;
    private static final int MAX_PROTOTYPE_ID = 7;
    
    public NativeWeakSet() {
        this.instanceOfWeakSet = false;
        this.map = new WeakHashMap<Scriptable, Boolean>();
    }
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeWeakSet m = new NativeWeakSet();
        m.exportAsJSClass(7, scope, sealed);
    }
    
    public String getClassName() {
        return "WeakSet";
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeWeakSet.MAP_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                if (thisObj == null) {
                    final NativeWeakSet ns = new NativeWeakSet();
                    ns.instanceOfWeakSet = true;
                    if (args.length > 0) {
                        NativeSet.loadFromIterable(cx, scope, (ScriptableObject)ns, args[0]);
                    }
                    return ns;
                }
                throw ScriptRuntime.typeError1("msg.no.new", "WeakSet");
            }
            case 2: {
                return this.realThis(thisObj, f).js_add((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 3: {
                return this.realThis(thisObj, f).js_delete((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 4: {
                return this.realThis(thisObj, f).js_has((args.length > 0) ? args[0] : Undefined.instance);
            }
            case 5: {
                return this.realThis(thisObj, f).js_addAll(args);
            }
            case 6: {
                return this.realThis(thisObj, f).js_deleteAll(args);
            }
            default: {
                throw new IllegalArgumentException("WeakMap.prototype has no method: " + f.getFunctionName());
            }
        }
    }
    
    private Object js_add(final Object key) {
        if (!ScriptRuntime.isObject(key)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(key));
        }
        this.map.put((Scriptable)key, Boolean.TRUE);
        return this;
    }
    
    private Object js_delete(final Object key) {
        if (!ScriptRuntime.isObject(key)) {
            return false;
        }
        final Object oldVal = this.map.remove(key);
        return oldVal != null;
    }
    
    private Object js_has(final Object key) {
        if (!ScriptRuntime.isObject(key)) {
            return false;
        }
        return this.map.containsKey(key);
    }
    
    private Object js_addAll(final Object[] args) {
        for (final Object arg : args) {
            this.js_add(arg);
        }
        return this;
    }
    
    private Object js_deleteAll(final Object[] args) {
        for (final Object arg : args) {
            this.js_delete(arg);
        }
        return this;
    }
    
    private NativeWeakSet realThis(final Scriptable thisObj, final IdFunctionObject f) {
        if (thisObj == null) {
            throw incompatibleCallError(f);
        }
        try {
            final NativeWeakSet ns = (NativeWeakSet)ScriptRuntime.unwrapProxy(thisObj);
            if (!ns.instanceOfWeakSet) {
                throw incompatibleCallError(f);
            }
            return ns;
        }
        catch (ClassCastException cce) {
            throw incompatibleCallError(f);
        }
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 7) {
            this.initPrototypeValue(7, (Symbol)SymbolKey.TO_STRING_TAG, (Object)this.getClassName(), 3);
            return;
        }
        final String fnName = null;
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 0;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 1;
                s = "add";
                break;
            }
            case 3: {
                arity = 1;
                s = "delete";
                break;
            }
            case 4: {
                arity = 1;
                s = "has";
                break;
            }
            case 5: {
                arity = 0;
                s = "addAll";
                break;
            }
            case 6: {
                arity = 0;
                s = "deleteAll";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeWeakSet.MAP_TAG, id, s, fnName, arity);
    }
    
    protected int findPrototypeId(final Symbol k) {
        if (SymbolKey.TO_STRING_TAG.equals(k)) {
            return 7;
        }
        return 0;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 3: {
                final int c = s.charAt(0);
                if (c == 97) {
                    if (s.charAt(2) == 'd' && s.charAt(1) == 'd') {
                        id = 2;
                        return id;
                    }
                    break;
                }
                else {
                    if (c == 104 && s.charAt(2) == 's' && s.charAt(1) == 'a') {
                        id = 4;
                        return id;
                    }
                    break;
                }
                break;
            }
            case 6: {
                final int c = s.charAt(0);
                if (c == 97) {
                    X = "addAll";
                    id = 5;
                    break;
                }
                if (c == 100) {
                    X = "delete";
                    id = 3;
                    break;
                }
                break;
            }
            case 9: {
                X = "deleteAll";
                id = 6;
                break;
            }
            case 11: {
                X = "constructor";
                id = 1;
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    private void readObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.map = new WeakHashMap<Scriptable, Boolean>();
    }
    
    static {
        MAP_TAG = "WeakSet";
    }
}
