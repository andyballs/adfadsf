//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.proxy;

import org.mozilla.javascript.*;

public class NativeProxyRevocableObject extends BaseFunction
{
    private static final String PROXY_TAG = "Proxy";
    private final NativeProxy proxy;
    private final Function revoke;
    private static final int Id_revoke = 1;
    private static final int Id_proxy = 2;
    
    NativeProxyRevocableObject(final NativeProxy proxy, final Function revoke) {
        this.proxy = proxy;
        this.revoke = revoke;
    }
    
    protected void initPrototypeId(final int id) {
        if (id == 1) {
            this.initPrototypeMethod((Object)"Proxy", 1, "revoke", (String)null, 0);
        }
        else if (id == 2) {
            this.initPrototypeMethod((Object)"Proxy", 1, "revoke", (String)null, this.proxy.getArity());
        }
    }
    
    public Object execIdCall(final IdFunctionObject f, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!f.hasTag((Object)"Proxy")) {
            super.execIdCall(f, cx, scope, thisObj, args);
        }
        final int id = f.methodId();
        switch (id) {
            case 2: {
                return this.proxy;
            }
            case 1: {
                return this.revoke;
            }
            default: {
                return super.execIdCall(f, cx, scope, thisObj, args);
            }
        }
    }
    
    protected int findPrototypeId(final String s) {
        int id = 0;
        String X = null;
        final int s_length = s.length();
        if (s_length == 5) {
            X = "proxy";
            id = 2;
        }
        else if (s_length == 6) {
            X = "revoke";
            id = 1;
        }
        if (X != null && X != s && !X.equals(s)) {
            id = 0;
        }
        return id;
    }
}
