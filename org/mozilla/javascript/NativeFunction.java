//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.debug.*;

public abstract class NativeFunction extends BaseFunction
{
    private static final long serialVersionUID = 8713897114082216401L;
    
    public final void initScriptFunction(final Context cx, final Scriptable scope) {
        ScriptRuntime.setFunctionProtoAndParent(this, scope);
    }
    
    final String decompile(final int indent, final int flags) {
        final String encodedSource = this.getEncodedSource();
        if (encodedSource == null) {
            return super.decompile(indent, flags);
        }
        final UintMap properties = new UintMap(1);
        properties.put(1, indent);
        return Decompiler.decompile(encodedSource, flags, properties);
    }
    
    public boolean hasRest() {
        return false;
    }
    
    public int getLength() {
        final int paramCount = this.getParamCount() - (this.hasRest() ? 1 : 0);
        if (this.getLanguageVersion() != 120) {
            return paramCount;
        }
        final Context cx = Context.getContext();
        final NativeCall activation = ScriptRuntime.findFunctionActivation(cx, (Function)this);
        if (activation == null) {
            return paramCount;
        }
        return activation.effectiveArgs.length;
    }
    
    public int getArity() {
        return this.getParamCount();
    }
    
    @Deprecated
    public String jsGet_name() {
        return this.getFunctionName();
    }
    
    public String getEncodedSource() {
        return null;
    }
    
    public DebuggableScript getDebuggableView() {
        return null;
    }
    
    public Object resumeGenerator(final Context cx, final Scriptable scope, final int operation, final Object state, final Object value) {
        throw new EvaluatorException("resumeGenerator() not implemented");
    }
    
    protected abstract int getLanguageVersion();
    
    protected abstract int getParamCount();
    
    protected abstract int getParamAndVarCount();
    
    protected abstract String getParamOrVarName(final int p0);
    
    protected boolean getParamOrVarConst(final int index) {
        return false;
    }
    
    protected abstract boolean isVarLexical(final int p0);
}
