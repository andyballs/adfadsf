//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module;

import java.io.*;
import org.mozilla.javascript.*;

public class RequireBuilder implements Serializable
{
    private static final long serialVersionUID = 1L;
    private boolean sandboxed;
    private ModuleScriptProvider moduleScriptProvider;
    private Script preExec;
    private Script postExec;
    
    public RequireBuilder() {
        this.sandboxed = true;
    }
    
    public RequireBuilder setModuleScriptProvider(final ModuleScriptProvider moduleScriptProvider) {
        this.moduleScriptProvider = moduleScriptProvider;
        return this;
    }
    
    public RequireBuilder setPostExec(final Script postExec) {
        this.postExec = postExec;
        return this;
    }
    
    public RequireBuilder setPreExec(final Script preExec) {
        this.preExec = preExec;
        return this;
    }
    
    public RequireBuilder setSandboxed(final boolean sandboxed) {
        this.sandboxed = sandboxed;
        return this;
    }
    
    public Require createRequire(final Context cx, final Scriptable globalScope) {
        return new Require(cx, globalScope, this.moduleScriptProvider, this.preExec, this.postExec, this.sandboxed);
    }
}
