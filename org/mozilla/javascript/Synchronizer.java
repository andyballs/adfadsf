//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class Synchronizer extends Delegator
{
    private Object syncObject;
    
    public Synchronizer(final Scriptable obj) {
        super(obj);
    }
    
    public Synchronizer(final Scriptable obj, final Object syncObject) {
        super(obj);
        this.syncObject = syncObject;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final Object sync = (this.syncObject != null) ? this.syncObject : thisObj;
        final Object o;
        synchronized (o = ((sync instanceof Wrapper) ? ((Wrapper)sync).unwrap() : sync)) {
            return ((Function)this.obj).call(cx, scope, thisObj, args);
        }
    }
}
