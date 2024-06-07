//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.concurrent.*;
import org.mozilla.javascript.optimizer.*;

public class BaseFunction extends IdScriptableObject implements Function
{
    private static final long serialVersionUID = 5311394446546053859L;
    private static final Object FUNCTION_TAG;
    private static final int Id_length = 1;
    private static final int Id_arity = 2;
    private static final int Id_name = 3;
    private static final int Id_prototype = 4;
    private static final int Id_arguments = 5;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int Id_constructor = 1;
    private static final int Id_toString = 2;
    private static final int Id_toSource = 3;
    private static final int Id_apply = 4;
    private static final int Id_call = 5;
    private static final int Id_bind = 6;
    private static final int MAX_PROTOTYPE_ID = 6;
    private Object prototypeProperty;
    private Object argumentsObj;
    private Object forcedNewTarget;
    private Object forcedName;
    private int prototypePropertyAttributes;
    private int argumentsAttributes;
    
    public static BaseFunction wrap(final BaseFunctionLambda lambda) {
        return new BaseFunction() {
            @Override
            public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
                return lambda.call(cx, scope, thisObj, args);
            }
        };
    }
    
    public static BaseFunction wrap(final java.util.concurrent.Callable<Object> lambda) {
        return new BaseFunction() {
            @Override
            public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
                try {
                    return lambda.call();
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
    
    static void init(final Scriptable scope, final boolean sealed) {
        final BaseFunction obj = new BaseFunction();
        obj.prototypePropertyAttributes = 7;
        obj.exportAsJSClass(6, scope, sealed);
    }
    
    public BaseFunction() {
        this.argumentsObj = BaseFunction.NOT_FOUND;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
    }
    
    public BaseFunction(final Scriptable scope, final Scriptable prototype) {
        super(scope, prototype);
        this.argumentsObj = BaseFunction.NOT_FOUND;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
    }
    
    @Override
    public String getClassName() {
        return "Function";
    }
    
    @Override
    public String getTypeOf() {
        return this.avoidObjectDetection() ? "undefined" : "function";
    }
    
    @Override
    public boolean hasInstance(final Scriptable instance) {
        final Object protoProp = ScriptableObject.getProperty(this, "prototype");
        if (protoProp instanceof Scriptable) {
            return ScriptRuntime.jsDelegatesTo(instance, (Scriptable)protoProp);
        }
        throw ScriptRuntime.typeError1("msg.instanceof.bad.prototype", this.getFunctionName());
    }
    
    @Override
    protected int getMaxInstanceId() {
        return 5;
    }
    
    @Override
    protected int findInstanceIdInfo(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 4: {
                X = "name";
                id = 3;
                break;
            }
            case 5: {
                X = "arity";
                id = 2;
                break;
            }
            case 6: {
                X = "length";
                id = 1;
                break;
            }
            case 9: {
                final int c = s.charAt(0);
                if (c == 97) {
                    X = "arguments";
                    id = 5;
                    break;
                }
                if (c == 112) {
                    X = "prototype";
                    id = 4;
                    break;
                }
                break;
            }
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        if (id == 0) {
            return super.findInstanceIdInfo(s);
        }
        int attr = 0;
        switch (id) {
            case 1:
            case 3: {
                attr = 3;
                break;
            }
            case 2: {
                attr = 7;
                break;
            }
            case 4: {
                if (!this.hasPrototypeProperty()) {
                    return 0;
                }
                attr = this.prototypePropertyAttributes;
                break;
            }
            case 5: {
                attr = this.argumentsAttributes;
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
                return "length";
            }
            case 2: {
                return "arity";
            }
            case 3: {
                return "name";
            }
            case 4: {
                return "prototype";
            }
            case 5: {
                return "arguments";
            }
            default: {
                return super.getInstanceIdName(id);
            }
        }
    }
    
    @Override
    protected Object getInstanceIdValue(final int id) {
        switch (id) {
            case 1: {
                return ScriptRuntime.wrapInt(this.getLength());
            }
            case 2: {
                return ScriptRuntime.wrapInt(this.getArity());
            }
            case 3: {
                if (this.forcedName != null) {
                    return this.forcedName;
                }
                return this.getFunctionName();
            }
            case 4: {
                return this.getPrototypeProperty();
            }
            case 5: {
                return this.getArguments();
            }
            default: {
                return super.getInstanceIdValue(id);
            }
        }
    }
    
    @Override
    protected void setInstanceIdValue(final int id, final Object value) {
        switch (id) {
            case 4: {
                if ((this.prototypePropertyAttributes & 0x1) == 0x0) {
                    this.prototypeProperty = ((value != null) ? value : UniqueTag.NULL_VALUE);
                }
            }
            case 5: {
                if (value == BaseFunction.NOT_FOUND) {
                    Kit.codeBug();
                }
                if (this.defaultHas("arguments")) {
                    this.defaultPut("arguments", value);
                }
                else if ((this.argumentsAttributes & 0x1) == 0x0) {
                    this.argumentsObj = value;
                }
            }
            case 2:
            case 3: {}
            case 1: {
                this.defaultPut("length", value);
            }
            default: {
                super.setInstanceIdValue(id, value);
            }
        }
    }
    
    @Override
    protected void setInstanceIdAttributes(final int id, final int attr) {
        switch (id) {
            case 4: {
                this.prototypePropertyAttributes = attr;
            }
            case 5: {
                this.argumentsAttributes = attr;
            }
            default: {
                super.setInstanceIdAttributes(id, attr);
            }
        }
    }
    
    @Override
    protected void fillConstructorProperties(final IdFunctionObject ctor) {
        ctor.setPrototype(this);
        super.fillConstructorProperties(ctor);
    }
    
    @Override
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
                arity = 1;
                s = "toSource";
                break;
            }
            case 4: {
                arity = 2;
                s = "apply";
                break;
            }
            case 5: {
                arity = 1;
                s = "call";
                break;
            }
            case 6: {
                arity = 1;
                s = "bind";
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
        this.initPrototypeMethod(BaseFunction.FUNCTION_TAG, id, s, arity);
    }
    
    static boolean isApply(final IdFunctionObject f) {
        return f.hasTag(BaseFunction.FUNCTION_TAG) && f.methodId() == 4;
    }
    
    static boolean isApplyOrCall(final IdFunctionObject f) {
        if (f.hasTag(BaseFunction.FUNCTION_TAG)) {
            switch (f.methodId()) {
                case 4:
                case 5: {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag(BaseFunction.FUNCTION_TAG)) {
            return super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 1: {
                return jsConstructor(cx, scope, args);
            }
            case 2: {
                final BaseFunction realf = this.realFunction(thisObj, f);
                final int indent = ScriptRuntime.toInt32(args, 0);
                return realf.decompile(indent, 0);
            }
            case 3: {
                final BaseFunction realf = this.realFunction(thisObj, f);
                int indent = 0;
                int flags = 2;
                if (args.length != 0) {
                    indent = ScriptRuntime.toInt32(args[0]);
                    if (indent >= 0) {
                        flags = 0;
                    }
                    else {
                        indent = 0;
                    }
                }
                return realf.decompile(indent, flags);
            }
            case 4:
            case 5: {
                return ScriptRuntime.applyOrCall(id == 4, cx, scope, thisObj, args);
            }
            case 6: {
                if (!(thisObj instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(thisObj);
                }
                final Callable targetFunction = (Callable)thisObj;
                final int argc = args.length;
                Scriptable boundThis;
                Object[] boundArgs;
                if (argc > 0) {
                    boundThis = ScriptRuntime.toObjectOrNull(cx, args[0], scope);
                    boundArgs = new Object[argc - 1];
                    System.arraycopy(args, 1, boundArgs, 0, argc - 1);
                }
                else {
                    boundThis = null;
                    boundArgs = ScriptRuntime.emptyArgs;
                }
                return new BoundFunction(cx, scope, targetFunction, boundThis, boundArgs);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(id));
            }
        }
    }
    
    private BaseFunction realFunction(final Scriptable thisObj, final IdFunctionObject f) {
        Object x = thisObj.getDefaultValue(ScriptRuntime.FunctionClass);
        if (x instanceof Delegator) {
            x = ((Delegator)x).getDelegee();
        }
        if (x instanceof BaseFunction) {
            return (BaseFunction)x;
        }
        throw ScriptRuntime.typeError1("msg.incompat.call", f.getFunctionName());
    }
    
    public void setImmunePrototypeProperty(final Object value) {
        if ((this.prototypePropertyAttributes & 0x1) != 0x0) {
            throw new IllegalStateException();
        }
        this.prototypeProperty = ((value != null) ? value : UniqueTag.NULL_VALUE);
        this.prototypePropertyAttributes = 7;
    }
    
    protected Scriptable getClassPrototype() {
        final Object protoVal = this.getPrototypeProperty();
        if (protoVal instanceof Scriptable) {
            return (Scriptable)protoVal;
        }
        return ScriptableObject.getObjectPrototype(this);
    }
    
    @Override
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return Undefined.instance;
    }
    
    @Override
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        Scriptable result = this.createObject(cx, scope);
        if (result != null) {
            if (this.getForcedNewTarget() != null) {
                result.put("new.target", result, this.getForcedNewTarget());
                this.setForcedNewTarget(null);
            }
            else {
                result.put("new.target", result, this);
            }
            final Object val = this.call(cx, scope, result, args);
            result.delete("new.target");
            if (val instanceof Scriptable) {
                result = (Scriptable)val;
            }
        }
        else {
            final Object val = this.call(cx, scope, null, args);
            if (!(val instanceof Scriptable)) {
                throw new IllegalStateException("Bad implementaion of call as constructor, name=" + this.getFunctionName() + " in " + this.getClass().getName());
            }
            result = (Scriptable)val;
            if (result.getPrototype() == null) {
                final Scriptable proto = this.getClassPrototype();
                if (result != proto) {
                    result.setPrototype(proto);
                }
            }
            if (result.getParentScope() == null) {
                final Scriptable parent = this.getParentScope();
                if (result != parent) {
                    result.setParentScope(parent);
                }
            }
        }
        return result;
    }
    
    public boolean isCallable() {
        return true;
    }
    
    public boolean isConstructable() {
        return true;
    }
    
    public Scriptable createObject(final Context cx, final Scriptable scope) {
        final Scriptable newInstance = new NativeObject();
        newInstance.setPrototype(this.getClassPrototype());
        newInstance.setParentScope(this.getParentScope());
        return newInstance;
    }
    
    String decompile(final int indent, final int flags) {
        final StringBuilder sb = new StringBuilder();
        final boolean justbody = 0x0 != (flags & 0x1);
        if (!justbody) {
            sb.append("function ");
            sb.append(this.getFunctionName());
            sb.append("() {\n\t");
        }
        sb.append("[native code, arity=");
        sb.append(this.getArity());
        sb.append("]\n");
        if (!justbody) {
            sb.append("}\n");
        }
        return sb.toString();
    }
    
    public int getArity() {
        return 0;
    }
    
    public int getLength() {
        return 0;
    }
    
    public String getFunctionName() {
        return "";
    }
    
    protected boolean hasPrototypeProperty() {
        return this.prototypeProperty != null || this instanceof NativeFunction;
    }
    
    protected Object getPrototypeProperty() {
        Object result = this.prototypeProperty;
        if (result == null) {
            if (this instanceof NativeFunction) {
                result = this.setupDefaultPrototype();
            }
            else {
                result = Undefined.instance;
            }
        }
        else if (result == UniqueTag.NULL_VALUE) {
            result = null;
        }
        return result;
    }
    
    private synchronized Object setupDefaultPrototype() {
        if (this.prototypeProperty != null) {
            return this.prototypeProperty;
        }
        final NativeObject obj = new NativeObject();
        final int attr = 2;
        obj.defineProperty("constructor", this, 2);
        this.prototypeProperty = obj;
        final Scriptable proto = ScriptableObject.getObjectPrototype(this);
        if (proto != obj) {
            obj.setPrototype(proto);
        }
        return obj;
    }
    
    private Object getArguments() {
        final Object value = this.defaultHas("arguments") ? this.defaultGet("arguments") : this.argumentsObj;
        if (value != BaseFunction.NOT_FOUND) {
            return value;
        }
        final Context cx = Context.getContext();
        final NativeCall activation = ScriptRuntime.findFunctionActivation(cx, this);
        return (activation == null) ? null : activation.get("arguments", activation);
    }
    
    public Object getForcedName() {
        return this.forcedName;
    }
    
    public void setForcedName(final Object forcedName) {
        this.forcedName = forcedName;
    }
    
    public Object getForcedNewTarget() {
        return this.forcedNewTarget;
    }
    
    public void setForcedNewTarget(final Object forcedNewTarget) {
        this.forcedNewTarget = forcedNewTarget;
    }
    
    private static Object jsConstructor(final Context cx, final Scriptable scope, final Object[] args) {
        final int arglen = args.length;
        final StringBuilder sourceBuf = new StringBuilder();
        sourceBuf.append("function ");
        if (cx.getLanguageVersion() != 120) {
            sourceBuf.append("anonymous");
        }
        sourceBuf.append('(');
        for (int i = 0; i < arglen - 1; ++i) {
            if (i > 0) {
                sourceBuf.append(',');
            }
            sourceBuf.append(ScriptRuntime.toString(args[i]));
        }
        sourceBuf.append(") {");
        if (arglen != 0) {
            final String funBody = ScriptRuntime.toString(args[arglen - 1]);
            sourceBuf.append(funBody);
        }
        sourceBuf.append("\n}");
        final String source = sourceBuf.toString();
        final int[] linep = { 0 };
        String filename = Context.getSourcePositionFromStack(linep);
        if (filename == null) {
            filename = "<eval'ed string>";
            linep[0] = 1;
        }
        final String sourceURI = ScriptRuntime.makeUrlForGeneratedScript(false, filename, linep[0]);
        final Scriptable global = ScriptableObject.getTopLevelScope(scope);
        final ErrorReporter reporter = DefaultErrorReporter.forEval(cx.getErrorReporter());
        return cx.compileFunction(global, source, new Codegen(), reporter, sourceURI, 1, null);
    }
    
    @Override
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        switch (s.length()) {
            case 4: {
                final int c = s.charAt(0);
                if (c == 98) {
                    X = "bind";
                    id = 6;
                    break;
                }
                if (c == 99) {
                    X = "call";
                    id = 5;
                    break;
                }
                break;
            }
            case 5: {
                X = "apply";
                id = 4;
                break;
            }
            case 8: {
                final int c = s.charAt(3);
                if (c == 111) {
                    X = "toSource";
                    id = 3;
                    break;
                }
                if (c == 116) {
                    X = "toString";
                    id = 2;
                    break;
                }
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
        FUNCTION_TAG = "Function";
    }
    
    @FunctionalInterface
    interface BaseFunctionLambda
    {
        Object call(final Context p0, final Scriptable p1, final Scriptable p2, final Object[] p3);
    }
}
