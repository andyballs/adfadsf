//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;
import java.io.*;

final class NativeError extends IdScriptableObject
{
    private static final long serialVersionUID = -5338413581437645187L;
    private static final Object ERROR_TAG;
    private static final Method ERROR_DELEGATE_GET_STACK;
    private static final Method ERROR_DELEGATE_SET_STACK;
    public static final int DEFAULT_STACK_LIMIT = -1;
    private static final String STACK_HIDE_KEY = "_stackHide";
    private RhinoException stackProvider;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toSource = 3;
    private static final int ConstructorId_captureStackTrace = -1;
    private static final int MAX_PROTOTYPE_ID = 3;
    
    static void init(final Scriptable scope, final boolean sealed) {
        final NativeError obj = new NativeError();
        ScriptableObject.putProperty((Scriptable)obj, "name", "Error");
        ScriptableObject.putProperty((Scriptable)obj, "message", "");
        ScriptableObject.putProperty((Scriptable)obj, "fileName", "");
        ScriptableObject.putProperty((Scriptable)obj, "lineNumber", 0);
        obj.setAttributes("name", 2);
        obj.setAttributes("message", 2);
        obj.exportAsJSClass(3, scope, sealed);
        NativeCallSite.init((Scriptable)obj, sealed);
    }
    
    static NativeError make(final Context cx, final Scriptable scope, final IdFunctionObject ctorObj, final Object[] args) {
        final Scriptable proto = (Scriptable)ctorObj.get("prototype", (Scriptable)ctorObj);
        final NativeError obj = new NativeError();
        obj.setPrototype(proto);
        obj.setParentScope(scope);
        final int arglen = args.length;
        if (arglen >= 1) {
            if (args[0] != Undefined.instance) {
                ScriptableObject.putProperty((Scriptable)obj, "message", ScriptRuntime.toString(args[0]));
            }
            if (arglen >= 2) {
                ScriptableObject.putProperty((Scriptable)obj, "fileName", args[1]);
                if (arglen >= 3) {
                    final int line = ScriptRuntime.toInt32(args[2]);
                    ScriptableObject.putProperty((Scriptable)obj, "lineNumber", line);
                }
            }
        }
        return obj;
    }
    
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        this.addIdFunctionProperty((Scriptable)ctor, NativeError.ERROR_TAG, -1, "captureStackTrace", 2);
        final ProtoProps protoProps = new ProtoProps();
        this.associateValue((Object)"_ErrorPrototypeProps", (Object)protoProps);
        ctor.defineProperty("stackTraceLimit", (Object)protoProps, ProtoProps.GET_STACK_LIMIT, ProtoProps.SET_STACK_LIMIT, 0);
        ctor.defineProperty("prepareStackTrace", (Object)protoProps, ProtoProps.GET_PREPARE_STACK, ProtoProps.SET_PREPARE_STACK, 0);
        super.fillConstructorProperties(ctor);
    }
    
    public String getClassName() {
        return "Error";
    }
    
    public String toString() {
        final Object toString = js_toString((Scriptable)this);
        return (String)((toString instanceof String) ? toString : super.toString());
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
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(NativeError.ERROR_TAG, id, s, arity);
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(NativeError.ERROR_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                return make(cx, scope, f, args);
            }
            case 2: {
                return js_toString(thisObj);
            }
            case 3: {
                return js_toSource(cx, scope, thisObj);
            }
            case -1: {
                js_captureStackTrace(cx, thisObj, args);
                return Undefined.instance;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    public void setStackProvider(final RhinoException re) {
        if (this.stackProvider == null) {
            this.stackProvider = re;
            this.defineProperty("stack", (Object)this, NativeError.ERROR_DELEGATE_GET_STACK, NativeError.ERROR_DELEGATE_SET_STACK, 2);
        }
    }
    
    public Object getStackDelegated(final Scriptable target) {
        if (this.stackProvider == null) {
            return NativeError.NOT_FOUND;
        }
        int limit = -1;
        Function prepare = null;
        final NativeError cons = (NativeError)this.getPrototype();
        final ProtoProps pp = (ProtoProps)cons.getAssociatedValue((Object)"_ErrorPrototypeProps");
        if (pp != null) {
            limit = pp.getStackTraceLimit();
            prepare = pp.getPrepareStackTrace();
        }
        final String hideFunc = (String)this.getAssociatedValue((Object)"_stackHide");
        final ScriptStackElement[] stack = this.stackProvider.getScriptStack(limit, hideFunc);
        Object value;
        if (prepare == null) {
            value = RhinoException.formatStackTrace(stack, this.stackProvider.details());
        }
        else {
            value = this.callPrepareStack(prepare, stack);
        }
        this.setStackDelegated(target, value);
        return value;
    }
    
    public void setStackDelegated(final Scriptable target, final Object value) {
        target.delete("stack");
        this.stackProvider = null;
        target.put("stack", target, value);
    }
    
    private Object callPrepareStack(final Function prepare, final ScriptStackElement[] stack) {
        final Context cx = Context.getCurrentContext();
        final Object[] elts = new Object[stack.length];
        for (int i = 0; i < stack.length; ++i) {
            final NativeCallSite site = (NativeCallSite)cx.newObject((Scriptable)this, "CallSite");
            site.setElement(stack[i]);
            elts[i] = site;
        }
        final Scriptable eltArray = (Scriptable)cx.newArray((Scriptable)this, elts);
        return prepare.call(cx, (Scriptable)prepare, (Scriptable)this, new Object[] { this, eltArray });
    }
    
    private static Object js_toString(final Scriptable thisObj) {
        Object name = ScriptableObject.getProperty(thisObj, "name");
        if (name == NativeError.NOT_FOUND || name == Undefined.instance) {
            name = "Error";
        }
        else {
            name = ScriptRuntime.toString(name);
        }
        Object msg = ScriptableObject.getProperty(thisObj, "message");
        if (msg == NativeError.NOT_FOUND || msg == Undefined.instance) {
            msg = "";
        }
        else {
            msg = ScriptRuntime.toString(msg);
        }
        if (name.toString().length() == 0) {
            return msg;
        }
        if (msg.toString().length() == 0) {
            return name;
        }
        return name + ": " + msg;
    }
    
    private static String js_toSource(final Context cx, final Scriptable scope, final Scriptable thisObj) {
        Object name = ScriptableObject.getProperty(thisObj, "name");
        Object message = ScriptableObject.getProperty(thisObj, "message");
        Object fileName = ScriptableObject.getProperty(thisObj, "fileName");
        final Object lineNumber = ScriptableObject.getProperty(thisObj, "lineNumber");
        final StringBuilder sb = new StringBuilder();
        sb.append("(new ");
        if (name == NativeError.NOT_FOUND) {
            name = Undefined.instance;
        }
        sb.append(ScriptRuntime.toString(name));
        sb.append("(");
        if (message != NativeError.NOT_FOUND || fileName != NativeError.NOT_FOUND || lineNumber != NativeError.NOT_FOUND) {
            if (message == NativeError.NOT_FOUND) {
                message = "";
            }
            sb.append(ScriptRuntime.uneval(cx, scope, message));
            if (fileName != NativeError.NOT_FOUND || lineNumber != NativeError.NOT_FOUND) {
                sb.append(", ");
                if (fileName == NativeError.NOT_FOUND) {
                    fileName = "";
                }
                sb.append(ScriptRuntime.uneval(cx, scope, fileName));
                if (lineNumber != NativeError.NOT_FOUND) {
                    final int line = ScriptRuntime.toInt32(lineNumber);
                    if (line != 0) {
                        sb.append(", ");
                        sb.append(ScriptRuntime.toString(line));
                    }
                }
            }
        }
        sb.append("))");
        return sb.toString();
    }
    
    private static void js_captureStackTrace(final Context cx, final Scriptable thisObj, final Object[] args) {
        final ScriptableObject obj = (ScriptableObject)ScriptRuntime.toObjectOrNull(cx, args[0], thisObj);
        Function func = null;
        if (args.length > 1) {
            func = (Function)ScriptRuntime.toObjectOrNull(cx, args[1], thisObj);
        }
        final NativeError err = (NativeError)cx.newObject(thisObj, "Error");
        err.setStackProvider((RhinoException)new EvaluatorException("[object Object]"));
        if (func != null) {
            final Object funcName = func.get("name", (Scriptable)func);
            if (funcName != null && !Undefined.instance.equals(funcName)) {
                err.associateValue((Object)"_stackHide", (Object)Context.toString(funcName));
            }
        }
        obj.defineProperty("stack", err, NativeError.ERROR_DELEGATE_GET_STACK, NativeError.ERROR_DELEGATE_SET_STACK, 0);
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 8) {
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
        ERROR_TAG = "Error";
        try {
            ERROR_DELEGATE_GET_STACK = NativeError.class.getMethod("getStackDelegated", Scriptable.class);
            ERROR_DELEGATE_SET_STACK = NativeError.class.getMethod("setStackDelegated", Scriptable.class, Object.class);
        }
        catch (NoSuchMethodException nsm) {
            throw new RuntimeException(nsm);
        }
    }
    
    private static final class ProtoProps implements Serializable
    {
        static final String KEY = "_ErrorPrototypeProps";
        static final Method GET_STACK_LIMIT;
        static final Method SET_STACK_LIMIT;
        static final Method GET_PREPARE_STACK;
        static final Method SET_PREPARE_STACK;
        private static final long serialVersionUID = 1907180507775337939L;
        private int stackTraceLimit;
        private Function prepareStackTrace;
        
        private ProtoProps() {
            this.stackTraceLimit = -1;
        }
        
        public Object getStackTraceLimit(final Scriptable thisObj) {
            if (this.stackTraceLimit >= 0) {
                return this.stackTraceLimit;
            }
            return Double.POSITIVE_INFINITY;
        }
        
        public int getStackTraceLimit() {
            return this.stackTraceLimit;
        }
        
        public void setStackTraceLimit(final Scriptable thisObj, final Object value) {
            final double limit = Context.toNumber(value);
            if (Double.isNaN(limit) || Double.isInfinite(limit)) {
                this.stackTraceLimit = -1;
            }
            else {
                this.stackTraceLimit = (int)limit;
            }
        }
        
        public Object getPrepareStackTrace(final Scriptable thisObj) {
            final Object ps = this.getPrepareStackTrace();
            return (ps == null) ? Undefined.instance : ps;
        }
        
        public Function getPrepareStackTrace() {
            return this.prepareStackTrace;
        }
        
        public void setPrepareStackTrace(final Scriptable thisObj, final Object value) {
            if (value == null || Undefined.instance.equals(value)) {
                this.prepareStackTrace = null;
            }
            else if (value instanceof Function) {
                this.prepareStackTrace = (Function)value;
            }
        }
        
        static {
            try {
                GET_STACK_LIMIT = ProtoProps.class.getMethod("getStackTraceLimit", Scriptable.class);
                SET_STACK_LIMIT = ProtoProps.class.getMethod("setStackTraceLimit", Scriptable.class, Object.class);
                GET_PREPARE_STACK = ProtoProps.class.getMethod("getPrepareStackTrace", Scriptable.class);
                SET_PREPARE_STACK = ProtoProps.class.getMethod("setPrepareStackTrace", Scriptable.class, Object.class);
            }
            catch (NoSuchMethodException nsm) {
                throw new RuntimeException(nsm);
            }
        }
    }
}
