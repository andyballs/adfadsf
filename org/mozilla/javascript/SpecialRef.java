//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

class SpecialRef extends Ref
{
    private static final long serialVersionUID = -7521596632456797847L;
    private static final int SPECIAL_NONE = 0;
    private static final int SPECIAL_PROTO = 1;
    private static final int SPECIAL_PARENT = 2;
    private Scriptable target;
    private int type;
    private String name;
    
    private SpecialRef(final Scriptable target, final int type, final String name) {
        this.target = target;
        this.type = type;
        this.name = name;
    }
    
    static Ref createSpecial(final Context cx, final Scriptable scope, final Object object, final String name) {
        final Scriptable target = ScriptRuntime.toObjectOrNull(cx, object, scope);
        if (target == null) {
            throw ScriptRuntime.undefReadError(object, (Object)name);
        }
        int type;
        if (name.equals("__proto__")) {
            type = 1;
        }
        else {
            if (!name.equals("__parent__")) {
                throw new IllegalArgumentException(name);
            }
            type = 2;
        }
        if (!cx.hasFeature(4)) {
            type = 0;
        }
        return new SpecialRef(target, type, name);
    }
    
    public Object get(final Context cx) {
        switch (this.type) {
            case 0: {
                return ScriptRuntime.getObjectProp(this.target, this.name, cx, false);
            }
            case 1: {
                return this.target.getPrototype();
            }
            case 2: {
                return this.target.getParentScope();
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    @Deprecated
    public Object set(final Context cx, final Object value) {
        throw new IllegalStateException();
    }
    
    public Object set(final Context cx, final Scriptable scope, final Object value) {
        switch (this.type) {
            case 0: {
                return ScriptRuntime.setObjectProp(this.target, this.name, value, cx, false);
            }
            case 1:
            case 2: {
                final Scriptable obj = ScriptRuntime.toObjectOrNull(cx, value, scope);
                Label_0117: {
                    if (obj != null) {
                        Scriptable search = obj;
                        while (search != this.target) {
                            if (this.type == 1) {
                                search = search.getPrototype();
                            }
                            else {
                                search = search.getParentScope();
                            }
                            if (search == null) {
                                break Label_0117;
                            }
                        }
                        throw Context.reportRuntimeError1("msg.cyclic.value", (Object)this.name);
                    }
                }
                if (this.type == 1) {
                    this.target.setPrototype(obj);
                }
                else {
                    this.target.setParentScope(obj);
                }
                return obj;
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    public boolean has(final Context cx) {
        return this.type != 0 || ScriptRuntime.hasObjectElem(this.target, (Object)this.name, cx);
    }
    
    public boolean delete(final Context cx) {
        return this.type == 0 && ScriptRuntime.deleteObjectElem(this.target, (Object)this.name, cx);
    }
}
