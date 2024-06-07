//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class JavaScriptException extends RhinoException
{
    private static final long serialVersionUID = -7666130513694669293L;
    private Object value;
    
    @Deprecated
    public JavaScriptException(final Object value) {
        this(value, "", 0);
    }
    
    public JavaScriptException(final Object value, final String sourceName, final int lineNumber) {
        this.recordErrorOrigin(sourceName, lineNumber, null, 0);
        this.value = value;
        if (value instanceof NativeError && Context.getContext().hasFeature(9)) {
            final NativeError error = (NativeError)value;
            if (!error.has("fileName", (Scriptable)error)) {
                error.put("fileName", (Scriptable)error, (Object)sourceName);
            }
            if (!error.has("lineNumber", (Scriptable)error)) {
                error.put("lineNumber", (Scriptable)error, (Object)lineNumber);
            }
            error.setStackProvider(this);
        }
    }
    
    @Override
    public String details() {
        if (this.value == null) {
            return "null";
        }
        if (this.value instanceof NativeError) {
            return this.value.toString();
        }
        try {
            return ScriptRuntime.toString(this.value);
        }
        catch (RuntimeException rte) {
            if (this.value instanceof Scriptable) {
                return ScriptRuntime.defaultObjectToString((Scriptable)this.value);
            }
            return this.value.toString();
        }
    }
    
    public Object getValue() {
        return this.value;
    }
    
    @Deprecated
    public String getSourceName() {
        return this.sourceName();
    }
    
    @Deprecated
    public int getLineNumber() {
        return this.lineNumber();
    }
}
