//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

final class NativeBoolean extends IdScriptableObject
{
    private static final long serialVersionUID = -3716996899943880933L;
    private static final Object BOOLEAN_TAG;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toSource = 3;
    private static final int Id_valueOf = 4;
    private static final int MAX_PROTOTYPE_ID = 4;
    private boolean booleanValue;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeBoolean obj = new NativeBoolean(false);
        obj.exportAsJSClass(4, scope, sealed);
    }
    
    NativeBoolean(final boolean b) {
        this.booleanValue = b;
    }
    
    public String getClassName() {
        return "Boolean";
    }
    
    public Object getDefaultValue(final Class<?> typeHint) {
        if (typeHint == ScriptRuntime.BooleanClass) {
            return ScriptRuntime.wrapBoolean(this.booleanValue);
        }
        return super.getDefaultValue((Class)typeHint);
    }
    
    protected void initPrototypeId(final int id) {
        int arity = 0;
        String s = null;
        switch (id) {
            case 1: {
                arity = 1;
                s = "constructor";
                break;
            }
            case 2: {
                arity = 0;
                s = "toString";
                break;
            }
            case 3: {
                arity = 0;
                s = "toSource";
                break;
            }
            case 4: {
                arity = 0;
                s = "valueOf";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeBoolean.BOOLEAN_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeBoolean.BOOLEAN_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        if (id == 1) {
            final boolean b = args.length != 0 && (!(args[0] instanceof ScriptableObject) || !((ScriptableObject)args[0]).avoidObjectDetection()) && ScriptRuntime.toBoolean(args[0]);
            if (thisObj == null) {
                return new NativeBoolean(b);
            }
            return ScriptRuntime.wrapBoolean(b);
        }
        else {
            final Scriptable unwrappedThis = ScriptRuntime.unwrapProxy(thisObj);
            if (!(unwrappedThis instanceof NativeBoolean)) {
                throw incompatibleCallError(f);
            }
            final boolean value = ((NativeBoolean)unwrappedThis).booleanValue;
            switch (id) {
                case 2: {
                    return value ? "true" : "false";
                }
                case 3: {
                    return value ? "(new Boolean(true))" : "(new Boolean(false))";
                }
                case 4: {
                    return ScriptRuntime.wrapBoolean(value);
                }
                default: {
                    throw new IllegalArgumentException(String.valueOf(id));
                }
            }
        }
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 7) {
            X = "valueOf";
            id = 4;
        }
        else if (s_length == 8) {
            final int c = s.charAt(3);
            if (c == 111) {
                X = "toSource";
                id = 3;
            }
            else if (c == 116) {
                X = "toString";
                id = 2;
            }
        }
        else if (s_length == 11) {
            X = "constructor";
            id = 1;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        BOOLEAN_TAG = "Boolean";
    }
}
