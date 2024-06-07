//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;

public class NativeSymbol extends IdScriptableObject implements Symbol
{
    private static final long serialVersionUID = -589539749749830003L;
    public static final String CLASS_NAME = "Symbol";
    public static final String TYPE_NAME = "symbol";
    private static final Object GLOBAL_TABLE_KEY;
    private static final Object OPERATOR_KEY;
    private static final Object UNARY_OPERATOR_KEY;
    private static final Object CONSTRUCTOR_SLOT;
    private final SymbolKey key;
    private final NativeSymbol symbolData;
    private static final int ConstructorId_unaryOperator = -4;
    private static final int ConstructorId_operator = -3;
    private static final int ConstructorId_keyFor = -2;
    private static final int ConstructorId_for = -1;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 4;
    private static final int SymbolId_toStringTag = 3;
    private static final int SymbolId_toPrimitive = 5;
    private static final int MAX_PROTOTYPE_ID = 5;
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final NativeSymbol obj = new NativeSymbol("");
        final ScriptableObject ctor = (ScriptableObject)obj.exportAsJSClass(5, scope, false);
        cx.putThreadLocal(NativeSymbol.CONSTRUCTOR_SLOT, (Object)Boolean.TRUE);
        try {
            createStandardSymbol(cx, scope, ctor, "iterator", SymbolKey.ITERATOR);
            createStandardSymbol(cx, scope, ctor, "species", SymbolKey.SPECIES);
            createStandardSymbol(cx, scope, ctor, "toStringTag", SymbolKey.TO_STRING_TAG);
            createStandardSymbol(cx, scope, ctor, "hasInstance", SymbolKey.HAS_INSTANCE);
            createStandardSymbol(cx, scope, ctor, "isConcatSpreadable", SymbolKey.IS_CONCAT_SPREADABLE);
            createStandardSymbol(cx, scope, ctor, "isRegExp", SymbolKey.IS_REGEXP);
            createStandardSymbol(cx, scope, ctor, "toPrimitive", SymbolKey.TO_PRIMITIVE);
            createStandardSymbol(cx, scope, ctor, "match", SymbolKey.MATCH);
            createStandardSymbol(cx, scope, ctor, "replace", SymbolKey.REPLACE);
            createStandardSymbol(cx, scope, ctor, "search", SymbolKey.SEARCH);
            createStandardSymbol(cx, scope, ctor, "split", SymbolKey.SPLIT);
            createStandardSymbol(cx, scope, ctor, "unscopables", SymbolKey.UNSCOPABLES);
        }
        finally {
            cx.removeThreadLocal(NativeSymbol.CONSTRUCTOR_SLOT);
        }
        if (sealed) {
            ctor.sealObject();
        }
    }
    
    private NativeSymbol(final String desc) {
        this.key = new SymbolKey(desc);
        this.symbolData = null;
    }
    
    public NativeSymbol(final SymbolKey key) {
        this.key = key;
        this.symbolData = this;
    }
    
    public NativeSymbol(final NativeSymbol s) {
        this.key = s.key;
        this.symbolData = s.symbolData;
    }
    
    public static NativeSymbol construct(final Context cx, final Scriptable scope, final Object[] args) {
        cx.putThreadLocal(NativeSymbol.CONSTRUCTOR_SLOT, (Object)Boolean.TRUE);
        try {
            return (NativeSymbol)cx.newObject(scope, "Symbol", args);
        }
        finally {
            cx.removeThreadLocal(NativeSymbol.CONSTRUCTOR_SLOT);
        }
    }
    
    public String getClassName() {
        return "Symbol";
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        super.fillConstructorProperties(ctor);
        this.addIdFunctionProperty((Scriptable)ctor, (Object)"Symbol", -1, "for", 1);
        this.addIdFunctionProperty((Scriptable)ctor, (Object)"Symbol", -2, "keyFor", 1);
        this.addIdFunctionProperty((Scriptable)ctor, (Object)"Symbol", -3, "operator", 1);
        this.addIdFunctionProperty((Scriptable)ctor, (Object)"Symbol", -4, "unaryOperator", 1);
    }
    
    private static void createStandardSymbol(final Context cx, final Scriptable scope, final ScriptableObject ctor, final String name, final SymbolKey key) {
        final Scriptable sym = cx.newObject(scope, "Symbol", new Object[] { name, key });
        ctor.defineProperty(name, sym, 7);
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 7) {
            X = "valueOf";
            id = 4;
        }
        else if (s_length == 8) {
            X = "toString";
            id = 2;
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
    
    protected int findPrototypeId(final Symbol key) {
        if (SymbolKey.TO_STRING_TAG.equals(key)) {
            return 3;
        }
        if (SymbolKey.TO_PRIMITIVE.equals(key)) {
            return 5;
        }
        return 0;
    }
    
    protected void initPrototypeId(final int id) {
        switch (id) {
            case 1: {
                this.initPrototypeMethod((Object)"Symbol", id, "constructor", 1);
                break;
            }
            case 2: {
                this.initPrototypeMethod((Object)"Symbol", id, "toString", 0);
                break;
            }
            case 4: {
                this.initPrototypeMethod((Object)"Symbol", id, "valueOf", 0);
                break;
            }
            case 3: {
                this.initPrototypeValue(id, (Symbol)SymbolKey.TO_STRING_TAG, (Object)"Symbol", 3);
                break;
            }
            case 5: {
                this.initPrototypeMethod((Object)"Symbol", id, (Symbol)SymbolKey.TO_PRIMITIVE, "Symbol.toPrimitive", 1);
                break;
            }
            default: {
                super.initPrototypeId(id);
                break;
            }
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag((Object)"Symbol")) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case -1: {
                return this.js_for(cx, scope, args);
            }
            case -2: {
                return this.js_keyFor(cx, scope, args);
            }
            case -3: {
                return this.js_operator(cx, args);
            }
            case -4: {
                return this.js_unaryOperator(cx, args);
            }
            case 1: {
                if (thisObj != null) {
                    return construct(cx, scope, args);
                }
                if (cx.getThreadLocal(NativeSymbol.CONSTRUCTOR_SLOT) == null) {
                    throw ScriptRuntime.typeError0("msg.no.symbol.new");
                }
                return js_constructor(args);
            }
            case 2: {
                return getSelf(thisObj).toString();
            }
            case 4:
            case 5: {
                return getSelf(thisObj).js_valueOf();
            }
            default: {
                return super.execIdCall(f, cx, scope, thisObj, args);
            }
        }
    }
    
    private static NativeSymbol getSelf(final Object thisObj) {
        try {
            return (NativeSymbol)thisObj;
        }
        catch (ClassCastException cce) {
            throw ScriptRuntime.typeError1("msg.invalid.type", thisObj.getClass().getName());
        }
    }
    
    private static NativeSymbol js_constructor(final Object[] args) {
        String desc;
        if (args.length > 0) {
            if (Undefined.instance.equals(args[0])) {
                desc = "";
            }
            else {
                desc = ScriptRuntime.toString(args[0]);
            }
        }
        else {
            desc = "";
        }
        if (args.length > 1) {
            return new NativeSymbol((SymbolKey)args[1]);
        }
        return new NativeSymbol(new SymbolKey(desc));
    }
    
    private Object js_valueOf() {
        return this.symbolData;
    }
    
    private NativeSymbol getSymbol(final Context cx, final Scriptable scope, final Object[] args, final Object mapKey) {
        final String name = (args.length > 0) ? ScriptRuntime.toString(args[0]) : ScriptRuntime.toString(Undefined.instance);
        final Map<String, NativeSymbol> table = getSymbolMap((Scriptable)this, mapKey);
        NativeSymbol ret = table.get(name);
        if (ret == null) {
            ret = construct(cx, scope, new Object[] { name });
            table.put(name, ret);
        }
        return ret;
    }
    
    private NativeSymbol js_for(final Context cx, final Scriptable scope, final Object[] args) {
        return this.getSymbol(cx, scope, args, NativeSymbol.GLOBAL_TABLE_KEY);
    }
    
    public NativeSymbol js_operator(final Context cx, final Object[] args) {
        if (args.length == 0) {
            throw ScriptRuntime.typeError("Symbol.operator requires one string argument");
        }
        return operator(cx, ScriptRuntime.toString(args[0]));
    }
    
    public NativeSymbol js_unaryOperator(final Context cx, final Object[] args) {
        if (args.length == 0) {
            throw ScriptRuntime.typeError("Symbol.unaryOperator requires one string argument");
        }
        return unaryOperator(cx, ScriptRuntime.toString(args[0]));
    }
    
    public static NativeSymbol operator(final Context cx, final String op) {
        final Map<String, NativeSymbol> table = getSymbolMap(cx.topCallScope, NativeSymbol.OPERATOR_KEY);
        NativeSymbol ret = table.get(op);
        if (ret == null) {
            ret = construct(cx, cx.topCallScope, new Object[] { op });
            table.put(op, ret);
        }
        return ret;
    }
    
    public static NativeSymbol unaryOperator(final Context cx, final String op) {
        final Map<String, NativeSymbol> table = getSymbolMap(cx.topCallScope, NativeSymbol.UNARY_OPERATOR_KEY);
        NativeSymbol ret = table.get(op);
        if (ret == null) {
            ret = construct(cx, cx.topCallScope, new Object[] { op });
            table.put(op, ret);
        }
        return ret;
    }
    
    private Object js_keyFor(final Context cx, final Scriptable scope, final Object[] args) {
        final Object s = (args.length > 0) ? args[0] : Undefined.instance;
        if (!(s instanceof NativeSymbol)) {
            throw ScriptRuntime.throwCustomError(cx, scope, "TypeError", "Not a Symbol");
        }
        final NativeSymbol sym = (NativeSymbol)s;
        final Map<String, NativeSymbol> table = this.getGlobalMap();
        for (final Map.Entry<String, NativeSymbol> e : table.entrySet()) {
            if (e.getValue().key == sym.key) {
                return e.getKey();
            }
        }
        return Undefined.instance;
    }
    
    public String toSymbolString() {
        return this.key.toSymbolString();
    }
    
    public String toString() {
        return this.key.toString();
    }
    
    private boolean isStrictMode() {
        final Context cx = Context.getCurrentContext();
        return cx != null && cx.isStrictMode();
    }
    
    public void put(final String name, final Scriptable start, final Object value) {
        if (!this.isSymbol()) {
            super.put(name, start, value);
        }
        else if (this.isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.no.assign.symbol.strict");
        }
    }
    
    public void put(final int index, final Scriptable start, final Object value) {
        if (!this.isSymbol()) {
            super.put(index, start, value);
        }
        else if (this.isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.no.assign.symbol.strict");
        }
    }
    
    public void put(final Symbol key, final Scriptable start, final Object value) {
        if (!this.isSymbol()) {
            super.put(key, start, value);
        }
        else if (this.isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.no.assign.symbol.strict");
        }
    }
    
    public boolean isSymbol() {
        return this.symbolData == this;
    }
    
    public String getTypeOf() {
        return this.isSymbol() ? "symbol" : super.getTypeOf();
    }
    
    public int hashCode() {
        return this.key.hashCode();
    }
    
    public boolean equals(final Object x) {
        return this.key.equals(x);
    }
    
    SymbolKey getKey() {
        return this.key;
    }
    
    private static Map<String, NativeSymbol> getSymbolMap(final Scriptable scope, final Object key) {
        final ScriptableObject top = (ScriptableObject)getTopLevelScope(scope);
        Map<String, NativeSymbol> map = (Map<String, NativeSymbol>)top.getAssociatedValue(key);
        if (map == null) {
            map = new HashMap<String, NativeSymbol>();
            top.associateValue(key, map);
        }
        return map;
    }
    
    private Map<String, NativeSymbol> getGlobalMap() {
        return getSymbolMap((Scriptable)this, NativeSymbol.GLOBAL_TABLE_KEY);
    }
    
    private Map<String, NativeSymbol> getOperatorMap() {
        return getSymbolMap((Scriptable)this, NativeSymbol.OPERATOR_KEY);
    }
    
    private Map<String, NativeSymbol> getUnaryOperatorMap() {
        return getSymbolMap((Scriptable)this, NativeSymbol.UNARY_OPERATOR_KEY);
    }
    
    static {
        GLOBAL_TABLE_KEY = new Object();
        OPERATOR_KEY = new Object();
        UNARY_OPERATOR_KEY = new Object();
        CONSTRUCTOR_SLOT = new Object();
    }
}
