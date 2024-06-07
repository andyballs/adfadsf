//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.*;

class Runner implements Runnable, ContextAction<Object>
{
    ContextFactory factory;
    private Scriptable scope;
    private Function f;
    private Script s;
    private Object[] args;
    
    Runner(final Scriptable scope, final Function func, final Object[] args) {
        this.scope = scope;
        this.f = func;
        this.args = args;
    }
    
    Runner(final Scriptable scope, final Script script) {
        this.scope = scope;
        this.s = script;
    }
    
    @Override
    public void run() {
        this.factory.call((ContextAction)this);
    }
    
    public Object run(final Context cx) {
        if (this.f != null) {
            return this.f.call(cx, this.scope, this.scope, this.args);
        }
        return this.s.exec(cx, this.scope);
    }
}
