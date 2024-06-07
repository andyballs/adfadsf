//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class ImporterTopLevel extends TopLevel
{
    private static final long serialVersionUID = -9095380847465315412L;
    private static final Object IMPORTER_TAG;
    private static final int Id_constructor = 1;
    private static final int Id_importClass = 2;
    private static final int Id_importPackage = 3;
    private static final int MAX_PROTOTYPE_ID = 3;
    private ObjArray importedPackages;
    private boolean topScopeFlag;
    
    public ImporterTopLevel() {
        this.importedPackages = new ObjArray();
    }
    
    public ImporterTopLevel(final Context cx) {
        this(cx, false);
    }
    
    public ImporterTopLevel(final Context cx, final boolean sealed) {
        this.importedPackages = new ObjArray();
        this.initStandardObjects(cx, sealed);
    }
    
    @Override
    public String getClassName() {
        return this.topScopeFlag ? "global" : "JavaImporter";
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final ImporterTopLevel obj = new ImporterTopLevel();
        obj.exportAsJSClass(3, scope, sealed);
    }
    
    public void initStandardObjects(final Context cx, final boolean sealed) {
        cx.initStandardObjects((ScriptableObject)this, sealed);
        this.topScopeFlag = true;
        final IdFunctionObject ctor = this.exportAsJSClass(3, (Scriptable)this, false);
        if (sealed) {
            ctor.sealObject();
        }
        this.delete("constructor");
    }
    
    public boolean has(final String name, final Scriptable start) {
        return super.has(name, start) || this.getPackageProperty(name, start) != ImporterTopLevel.NOT_FOUND;
    }
    
    public Object get(final String name, final Scriptable start) {
        Object result = super.get(name, start);
        if (result != ImporterTopLevel.NOT_FOUND) {
            return result;
        }
        result = this.getPackageProperty(name, start);
        return result;
    }
    
    private Object getPackageProperty(final String name, final Scriptable start) {
        Object result = ImporterTopLevel.NOT_FOUND;
        final Object[] elements;
        synchronized (this.importedPackages) {
            elements = this.importedPackages.toArray();
        }
        for (int i = 0; i < elements.length; ++i) {
            final NativeJavaPackage p = (NativeJavaPackage)elements[i];
            final Object v = p.getPkgProperty(name, start, false);
            if (v != null && !(v instanceof NativeJavaPackage)) {
                if (result != ImporterTopLevel.NOT_FOUND) {
                    throw Context.reportRuntimeError2("msg.ambig.import", (Object)result.toString(), (Object)v.toString());
                }
                result = v;
            }
        }
        return result;
    }
    
    @Deprecated
    public void importPackage(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        this.js_importPackage(args);
    }
    
    private Object js_construct(final Scriptable scope, final Object[] args) {
        final ImporterTopLevel result = new ImporterTopLevel();
        for (int i = 0; i != args.length; ++i) {
            final Object arg = args[i];
            if (arg instanceof NativeJavaClass) {
                result.importClass((NativeJavaClass)arg);
            }
            else {
                if (!(arg instanceof NativeJavaPackage)) {
                    throw Context.reportRuntimeError1("msg.not.class.not.pkg", (Object)Context.toString(arg));
                }
                result.importPackage((NativeJavaPackage)arg);
            }
        }
        result.setParentScope(scope);
        result.setPrototype((Scriptable)this);
        return result;
    }
    
    private Object js_importClass(final Object[] args) {
        for (int i = 0; i != args.length; ++i) {
            final Object arg = args[i];
            if (!(arg instanceof NativeJavaClass)) {
                throw Context.reportRuntimeError1("msg.not.class", (Object)Context.toString(arg));
            }
            this.importClass((NativeJavaClass)arg);
        }
        return Undefined.instance;
    }
    
    private Object js_importPackage(final Object[] args) {
        for (int i = 0; i != args.length; ++i) {
            final Object arg = args[i];
            if (!(arg instanceof NativeJavaPackage)) {
                throw Context.reportRuntimeError1("msg.not.pkg", (Object)Context.toString(arg));
            }
            this.importPackage((NativeJavaPackage)arg);
        }
        return Undefined.instance;
    }
    
    private void importPackage(final NativeJavaPackage pkg) {
        if (pkg == null) {
            return;
        }
        synchronized (this.importedPackages) {
            for (int j = 0; j != this.importedPackages.size(); ++j) {
                if (pkg.equals(this.importedPackages.get(j))) {
                    return;
                }
            }
            this.importedPackages.add(pkg);
        }
    }
    
    private void importClass(final NativeJavaClass cl) {
        final String s = cl.getClassObject().getName();
        final String n = s.substring(s.lastIndexOf(46) + 1);
        final Object val = this.get(n, (Scriptable)this);
        if (val != ImporterTopLevel.NOT_FOUND && val != cl) {
            throw Context.reportRuntimeError1("msg.prop.defined", (Object)n);
        }
        this.put(n, (Scriptable)this, (Object)cl);
    }
    
    protected void initPrototypeId(final int id) {
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
                s = "importClass";
                break;
            }
            case 3: {
                arity = 1;
                s = "importPackage";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(ImporterTopLevel.IMPORTER_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(ImporterTopLevel.IMPORTER_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                return this.js_construct(scope, args);
            }
            case 2: {
                return this.realThis(thisObj, f).js_importClass(args);
            }
            case 3: {
                return this.realThis(thisObj, f).js_importPackage(args);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private ImporterTopLevel realThis(final Scriptable thisObj, final IdFunctionObject f) {
        if (this.topScopeFlag) {
            return this;
        }
        if (!(thisObj instanceof ImporterTopLevel)) {
            throw incompatibleCallError(f);
        }
        return (ImporterTopLevel)thisObj;
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 11) {
            final int c = s.charAt(0);
            if (c == 99) {
                X = "constructor";
                id = 1;
            }
            else if (c == 105) {
                X = "importClass";
                id = 2;
            }
        }
        else if (s_length == 13) {
            X = "importPackage";
            id = 3;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
    
    static {
        IMPORTER_TAG = "Importer";
    }
}
