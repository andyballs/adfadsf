//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.debug.*;

final class InterpretedFunction extends NativeFunction implements Script
{
    private static final long serialVersionUID = 541475680333911468L;
    InterpreterData idata;
    SecurityController securityController;
    Object securityDomain;
    
    private InterpretedFunction(final InterpreterData idata, final Object staticSecurityDomain) {
        this.idata = idata;
        final Context cx = Context.getContext();
        final SecurityController sc = cx.getSecurityController();
        Object dynamicDomain;
        if (sc != null) {
            dynamicDomain = sc.getDynamicSecurityDomain(staticSecurityDomain);
        }
        else {
            if (staticSecurityDomain != null) {
                throw new IllegalArgumentException();
            }
            dynamicDomain = null;
        }
        this.securityController = sc;
        this.securityDomain = dynamicDomain;
    }
    
    private InterpretedFunction(final InterpretedFunction parent, final int index) {
        this.idata = parent.idata.itsNestedFunctions[index];
        this.securityController = parent.securityController;
        this.securityDomain = parent.securityDomain;
    }
    
    static InterpretedFunction createScript(final InterpreterData idata, final Object staticSecurityDomain) {
        final InterpretedFunction f = new InterpretedFunction(idata, staticSecurityDomain);
        return f;
    }
    
    static InterpretedFunction createFunction(final Context cx, final Scriptable scope, final InterpreterData idata, final Object staticSecurityDomain) {
        final InterpretedFunction f = new InterpretedFunction(idata, staticSecurityDomain);
        f.initScriptFunction(cx, scope);
        return f;
    }
    
    static InterpretedFunction createFunction(final Context cx, final Scriptable scope, final InterpretedFunction parent, final int index) {
        final InterpretedFunction f = new InterpretedFunction(parent, index);
        f.initScriptFunction(cx, scope);
        return f;
    }
    
    public String getFunctionName() {
        return (this.idata.itsName == null) ? "" : this.idata.itsName;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!ScriptRuntime.hasTopCall(cx)) {
            return ScriptRuntime.doTopCall((Callable)this, cx, scope, thisObj, args, this.idata.isStrict);
        }
        return Interpreter.interpret(this, cx, scope, thisObj, args);
    }
    
    @Override
    public Object exec(final Context cx, final Scriptable scope) {
        if (!this.isScript()) {
            throw new IllegalStateException();
        }
        if (!ScriptRuntime.hasTopCall(cx)) {
            return ScriptRuntime.doTopCall((Callable)this, cx, scope, scope, ScriptRuntime.emptyArgs, this.idata.isStrict);
        }
        return Interpreter.interpret(this, cx, scope, scope, ScriptRuntime.emptyArgs);
    }
    
    public boolean isScript() {
        return this.idata.itsFunctionType == 0;
    }
    
    @Override
    public String getEncodedSource() {
        return Interpreter.getEncodedSource(this.idata);
    }
    
    @Override
    public DebuggableScript getDebuggableView() {
        return (DebuggableScript)this.idata;
    }
    
    @Override
    public Object resumeGenerator(final Context cx, final Scriptable scope, final int operation, final Object state, final Object value) {
        return Interpreter.resumeGenerator(cx, scope, operation, state, value);
    }
    
    @Override
    protected int getLanguageVersion() {
        return this.idata.languageVersion;
    }
    
    @Override
    protected int getParamCount() {
        return this.idata.argCount;
    }
    
    @Override
    protected int getParamAndVarCount() {
        return this.idata.argNames.length;
    }
    
    @Override
    protected String getParamOrVarName(final int index) {
        return this.idata.argNames[index];
    }
    
    @Override
    protected boolean getParamOrVarConst(final int index) {
        return this.idata.argIsConst[index];
    }
    
    @Override
    protected boolean isVarLexical(final int index) {
        return false;
    }
    
    boolean hasFunctionNamed(final String name) {
        for (int f = 0; f < this.idata.getFunctionCount(); ++f) {
            final InterpreterData functionData = (InterpreterData)this.idata.getFunction(f);
            if (!functionData.declaredAsFunctionExpression && name.equals(functionData.getFunctionName())) {
                return false;
            }
        }
        return true;
    }
}
