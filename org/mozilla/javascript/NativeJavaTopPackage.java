//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class NativeJavaTopPackage extends NativeJavaPackage implements Function, IdFunctionCall
{
    private static final long serialVersionUID = -1455787259477709999L;
    private static final String[][] commonPackages;
    private static final Object FTAG;
    private static final int Id_getClass = 1;
    
    NativeJavaTopPackage(final ClassLoader loader) {
        super(true, "", loader);
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return this.construct(cx, scope, args);
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        ClassLoader loader = null;
        if (args.length != 0) {
            Object arg = args[0];
            if (arg instanceof Wrapper) {
                arg = ((Wrapper)arg).unwrap();
            }
            if (arg instanceof ClassLoader) {
                loader = (ClassLoader)arg;
            }
        }
        if (loader == null) {
            Context.reportRuntimeError0("msg.not.classloader");
            return null;
        }
        final NativeJavaPackage pkg = new NativeJavaPackage(true, "", loader);
        ScriptRuntime.setObjectProtoAndParent((ScriptableObject)pkg, scope);
        return (Scriptable)pkg;
    }
    
    public static void init(final Context cx, final Scriptable scope, final boolean sealed) {
        final ClassLoader loader = cx.getApplicationClassLoader();
        final NativeJavaTopPackage top = new NativeJavaTopPackage(loader);
        top.setPrototype(getObjectPrototype(scope));
        top.setParentScope(scope);
        for (int i = 0; i != NativeJavaTopPackage.commonPackages.length; ++i) {
            NativeJavaPackage parent = top;
            for (int j = 0; j != NativeJavaTopPackage.commonPackages[i].length; ++j) {
                parent = parent.forcePackage(NativeJavaTopPackage.commonPackages[i][j], scope);
            }
        }
        final IdFunctionObject getClass = new IdFunctionObject((IdFunctionCall)top, NativeJavaTopPackage.FTAG, 1, "getClass", 1, scope);
        final String[] topNames = ScriptRuntime.getTopPackageNames();
        final NativeJavaPackage[] topPackages = new NativeJavaPackage[topNames.length];
        for (int k = 0; k < topNames.length; ++k) {
            topPackages[k] = (NativeJavaPackage)top.get(topNames[k], (Scriptable)top);
        }
        final ScriptableObject global = (ScriptableObject)scope;
        if (sealed) {
            getClass.sealObject();
        }
        getClass.exportAsScopeProperty();
        global.defineProperty("Packages", top, 2);
        for (int l = 0; l < topNames.length; ++l) {
            global.defineProperty(topNames[l], topPackages[l], 2);
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (f.hasTag(NativeJavaTopPackage.FTAG) && f.methodId() == 1) {
            return this.js_getClass(cx, scope, args);
        }
        throw f.unknown();
    }
    
    private Scriptable js_getClass(final Context cx, final Scriptable scope, final Object[] args) {
        if (args.length > 0 && args[0] instanceof Wrapper) {
            Scriptable result = (Scriptable)this;
            final Class<?> cl = ((Wrapper)args[0]).unwrap().getClass();
            final String name = cl.getName();
            int offset = 0;
            while (true) {
                final int index = name.indexOf(46, offset);
                final String propName = (index == -1) ? name.substring(offset) : name.substring(offset, index);
                final Object prop = result.get(propName, result);
                if (!(prop instanceof Scriptable)) {
                    break;
                }
                result = (Scriptable)prop;
                if (index == -1) {
                    return result;
                }
                offset = index + 1;
            }
        }
        throw Context.reportRuntimeError0("msg.not.java.obj");
    }
    
    static {
        commonPackages = new String[][] { { "java", "lang", "reflect" }, { "java", "io" }, { "java", "math" }, { "java", "net" }, { "java", "util", "zip" }, { "java", "text", "resources" }, { "java", "applet" }, { "javax", "swing" } };
        FTAG = "JavaTopPackage";
    }
}
