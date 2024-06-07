//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

final class Arguments extends IdScriptableObject
{
    private static final long serialVersionUID = 4275508002492040609L;
    private static final String FTAG = "Arguments";
    private static final int Id_callee = 1;
    private static final int Id_length = 2;
    private static final int MAX_INSTANCE_ID = 2;
    private static BaseFunction iteratorMethod;
    private Object calleeObj;
    private Object lengthObj;
    private int calleeAttr;
    private int lengthAttr;
    private NativeCall activation;
    private Object[] args;
    
    public Arguments(final NativeCall activation) {
        this.calleeAttr = 2;
        this.lengthAttr = 2;
        this.activation = activation;
        final Scriptable parent = activation.getParentScope();
        this.setParentScope(parent);
        this.setPrototype(ScriptableObject.getObjectPrototype(parent));
        final Object[] origArgs = activation.callArgs;
        if (activation.function.hasRest() && activation.function.getParamCount() <= origArgs.length) {
            final Object restObj = origArgs[origArgs.length - 1];
            if (!(restObj instanceof NativeArray)) {
                throw Kit.codeBug();
            }
            final NativeArray rest = (NativeArray)restObj;
            final Object[] restItems = rest.toArray();
            System.arraycopy(origArgs, 0, this.args = new Object[origArgs.length - 1 + restItems.length], 0, origArgs.length - 1);
            System.arraycopy(restItems, 0, this.args, origArgs.length - 1, restItems.length);
        }
        else {
            this.args = origArgs;
        }
        this.lengthObj = this.args.length;
        final NativeFunction f = activation.function;
        this.calleeObj = f;
        final int version = f.getLanguageVersion();
        this.defineProperty(SymbolKey.ITERATOR, Arguments.iteratorMethod, 2);
    }
    
    @Override
    public String getClassName() {
        return "Arguments";
    }
    
    private Object arg(final int index) {
        if (index < 0 || this.args.length <= index) {
            return Arguments.NOT_FOUND;
        }
        return this.args[index];
    }
    
    private void putIntoActivation(final int index, final Object value) {
        final String argName = this.activation.function.getParamOrVarName(index);
        this.activation.put(argName, this.activation, value);
    }
    
    private Object getFromActivation(final int index) {
        final String argName = this.activation.function.getParamOrVarName(index);
        return this.activation.get(argName, this.activation);
    }
    
    private void replaceArg(final int index, final Object value) {
        if (this.activation.syncArgumentsObj) {
            this.activation.putRaw(this.activation.function.getParamOrVarName(index), this.activation, value);
        }
        synchronized (this) {
            if (this.args == this.activation.callArgs) {
                this.args = this.args.clone();
            }
            this.args[index] = value;
        }
    }
    
    private void removeArg(final int index) {
        synchronized (this) {
            if (this.args[index] != Arguments.NOT_FOUND) {
                if (this.args == this.activation.callArgs) {
                    this.args = this.args.clone();
                }
                this.args[index] = Arguments.NOT_FOUND;
            }
        }
    }
    
    @Override
    public boolean has(final int index, final Scriptable start) {
        return this.arg(index) != Arguments.NOT_FOUND || super.has(index, start);
    }
    
    @Override
    public Object get(final int index, final Scriptable start) {
        final Object value = this.arg(index);
        if (value == Arguments.NOT_FOUND) {
            return super.get(index, start);
        }
        if (this.sharedWithActivation(index)) {
            return this.getFromActivation(index);
        }
        return value;
    }
    
    private boolean sharedWithActivation(final int index) {
        return false;
    }
    
    @Override
    public void put(final int index, final Scriptable start, final Object value) {
        if (this.arg(index) == Arguments.NOT_FOUND) {
            super.put(index, start, value);
        }
        else {
            this.replaceArg(index, value);
        }
    }
    
    @Override
    public void put(final String name, final Scriptable start, final Object value) {
        super.put(name, start, value);
    }
    
    @Override
    public void delete(final int index) {
        if (0 <= index && index < this.args.length) {
            this.removeArg(index);
        }
        super.delete(index);
    }
    
    @Override
    protected int getMaxInstanceId() {
        return 2;
    }
    
    @Override
    protected int findInstanceIdInfo(final String s) {
        int id = 0;
        String X = null;
        if (s.length() == 6) {
            final int c = s.charAt(0);
            if (c == 99) {
                X = "callee";
                id = 1;
            }
            else if (c == 108) {
                X = "length";
                id = 2;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        final Context cx = Context.getContext();
        if (cx.isStrictMode() && id == 1) {
            return super.findInstanceIdInfo(s);
        }
        if (id == 0) {
            return super.findInstanceIdInfo(s);
        }
        int attr = 0;
        switch (id) {
            case 1: {
                attr = this.calleeAttr;
                break;
            }
            case 2: {
                attr = this.lengthAttr;
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        return IdScriptableObject.instanceIdInfo(attr, id);
    }
    
    @Override
    protected String getInstanceIdName(final int id) {
        switch (id) {
            case 1: {
                return "callee";
            }
            case 2: {
                return "length";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    protected Object getInstanceIdValue(final int id) {
        switch (id) {
            case 1: {
                return this.calleeObj;
            }
            case 2: {
                return this.lengthObj;
            }
            default: {
                return super.getInstanceIdValue(id);
            }
        }
    }
    
    @Override
    protected void setInstanceIdValue(final int id, final Object value) {
        switch (id) {
            case 1: {
                this.calleeObj = value;
            }
            case 2: {
                this.lengthObj = value;
            }
            default: {
                super.setInstanceIdValue(id, value);
            }
        }
    }
    
    @Override
    protected void setInstanceIdAttributes(final int id, final int attr) {
        switch (id) {
            case 1: {
                this.calleeAttr = attr;
            }
            case 2: {
                this.lengthAttr = attr;
            }
            default: {
                super.setInstanceIdAttributes(id, attr);
            }
        }
    }
    
    @Override
    public Object[] getIds(final boolean getNonEnumerable, final boolean getSymbols) {
        Object[] ids = super.getIds(getNonEnumerable, getSymbols);
        if (this.args.length != 0) {
            final boolean[] present = new boolean[this.args.length];
            int extraCount = this.args.length;
            for (int i = 0; i != ids.length; ++i) {
                final Object id = ids[i];
                if (id instanceof Integer) {
                    final int index = (int)id;
                    if (0 <= index && index < this.args.length && !present[index]) {
                        present[index] = true;
                        --extraCount;
                    }
                }
            }
            if (!getNonEnumerable) {
                for (int i = 0; i < present.length; ++i) {
                    if (!present[i] && super.has(i, this)) {
                        present[i] = true;
                        --extraCount;
                    }
                }
            }
            if (extraCount != 0) {
                final Object[] tmp = new Object[extraCount + ids.length];
                System.arraycopy(ids, 0, tmp, extraCount, ids.length);
                ids = tmp;
                int offset = 0;
                for (int j = 0; j != this.args.length; ++j) {
                    if (!present[j]) {
                        ids[offset] = j;
                        ++offset;
                    }
                }
                if (offset != extraCount) {
                    Kit.codeBug();
                }
            }
        }
        return ids;
    }
    
    @Override
    public ScriptableObject getOwnPropertyDescriptor(final Context cx, final Object id) {
        if (id instanceof Scriptable) {
            return super.getOwnPropertyDescriptor(cx, id);
        }
        final double d = ScriptRuntime.toNumber(id);
        final int index = (int)d;
        if (d != index) {
            return super.getOwnPropertyDescriptor(cx, id);
        }
        Object value = this.arg(index);
        if (value == Arguments.NOT_FOUND) {
            return super.getOwnPropertyDescriptor(cx, id);
        }
        if (this.sharedWithActivation(index)) {
            value = this.getFromActivation(index);
        }
        if (super.has(index, this)) {
            final ScriptableObject desc = super.getOwnPropertyDescriptor(cx, id);
            desc.put("value", desc, value);
            return desc;
        }
        Scriptable scope = this.getParentScope();
        if (scope == null) {
            scope = this;
        }
        return ScriptableObject.buildDataDescriptor(scope, value, 0);
    }
    
    @Override
    protected void defineOwnProperty(final Context cx, final Object id, final ScriptableObject desc, final boolean checkValid) {
        super.defineOwnProperty(cx, id, desc, checkValid);
        final double d = ScriptRuntime.toNumber(id);
        final int index = (int)d;
        if (d != index) {
            return;
        }
        final Object value = this.arg(index);
        if (value == Arguments.NOT_FOUND) {
            return;
        }
        if (this.isAccessorDescriptor(desc)) {
            this.removeArg(index);
            return;
        }
        final Object newValue = ScriptableObject.getProperty(desc, "value");
        if (newValue == Arguments.NOT_FOUND) {
            return;
        }
        this.replaceArg(index, newValue);
        if (ScriptableObject.isFalse(ScriptableObject.getProperty(desc, "writable"))) {
            this.removeArg(index);
        }
    }
    
    void defineAttributesForStrictMode() {
        final Context cx = Context.getContext();
        if (!cx.isStrictMode()) {
            return;
        }
        this.setGetterOrSetter("callee", 0, new ThrowTypeError("callee"), true);
        this.setGetterOrSetter("callee", 0, new ThrowTypeError("callee"), false);
        this.calleeObj = null;
    }
    
    static {
        Arguments.iteratorMethod = new BaseFunction() {
            private static final long serialVersionUID = 4239122318596177391L;
            
            @Override
            public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
                return new NativeArrayIterator(scope, thisObj, NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS);
            }
        };
    }
    
    private static class ThrowTypeError extends BaseFunction
    {
        private static final long serialVersionUID = -744615873947395749L;
        private String propertyName;
        
        ThrowTypeError(final String propertyName) {
            this.propertyName = propertyName;
        }
        
        @Override
        public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
            throw ScriptRuntime.typeError1("msg.arguments.not.access.strict", this.propertyName);
        }
    }
}
