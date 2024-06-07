//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

class NativeScript extends BaseFunction
{
    private static final long serialVersionUID = -6795101161980121700L;
    private static final Object SCRIPT_TAG;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_compile = 3;
    private static final int Id_exec = 4;
    private static final int MAX_PROTOTYPE_ID = 4;
    private Script script;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeScript obj = new NativeScript(null);
        obj.exportAsJSClass(4, scope, sealed);
    }
    
    private NativeScript(final Script script) {
        this.script = script;
    }
    
    public String getClassName() {
        return "Script";
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (this.script != null) {
            return this.script.exec(cx, scope);
        }
        return Undefined.instance;
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        throw Context.reportRuntimeError0("msg.script.is.not.constructor");
    }
    
    public int getLength() {
        return 0;
    }
    
    public int getArity() {
        return 0;
    }
    
    String decompile(final int indent, final int flags) {
        if (this.script instanceof NativeFunction) {
            return ((NativeFunction)this.script).decompile(indent, flags);
        }
        return super.decompile(indent, flags);
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
            case 4: {
                arity = 0;
                s = "exec";
                break;
            }
            case 3: {
                arity = 1;
                s = "compile";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeScript.SCRIPT_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeScript.SCRIPT_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                final String source = (args.length == 0) ? "" : ScriptRuntime.toString(args[0]);
                final Script script = compile(cx, source);
                final NativeScript nscript = new NativeScript(script);
                ScriptRuntime.setObjectProtoAndParent((ScriptableObject)nscript, scope);
                return nscript;
            }
            case 2: {
                final NativeScript real = realThis(thisObj, f);
                final Script realScript = real.script;
                if (realScript == null) {
                    return "";
                }
                return cx.decompileScript(realScript, 0);
            }
            case 4: {
                throw Context.reportRuntimeError1("msg.cant.call.indirect", (Object)"exec");
            }
            case 3: {
                final NativeScript real = realThis(thisObj, f);
                final String source2 = ScriptRuntime.toString(args, 0);
                real.script = compile(cx, source2);
                return real;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private static NativeScript realThis(final Scriptable thisObj, final IdFunctionObject f) {
        if (!(thisObj instanceof NativeScript)) {
            throw incompatibleCallError(f);
        }
        return (NativeScript)thisObj;
    }
    
    private static Script compile(final Context cx, final String source) {
        final int[] linep = { 0 };
        String filename = Context.getSourcePositionFromStack(linep);
        if (filename == null) {
            filename = "<Script object>";
            linep[0] = 1;
        }
        final ErrorReporter reporter = DefaultErrorReporter.forEval(cx.getErrorReporter());
        return cx.compileString(source, (Evaluator)null, reporter, filename, linep[0], (Object)null);
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 4: {
                X = "exec";
                id = 4;
                break;
            }
            case 7: {
                X = "compile";
                id = 3;
                break;
            }
            case 8: {
                X = "toString";
                id = 2;
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
    
    static {
        SCRIPT_TAG = "Script";
    }
}
