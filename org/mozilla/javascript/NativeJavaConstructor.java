//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class NativeJavaConstructor extends BaseFunction
{
    private static final long serialVersionUID = -8149253217482668463L;
    MemberBox ctor;
    
    public NativeJavaConstructor(final MemberBox ctor) {
        this.ctor = ctor;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        return NativeJavaClass.constructSpecific(cx, scope, args, this.ctor);
    }
    
    public String getFunctionName() {
        final String sig = JavaMembers.liveConnectSignature(this.ctor.argTypes);
        return "<init>".concat(sig);
    }
    
    public String toString() {
        return "[JavaConstructor " + this.ctor.getName() + "]";
    }
}
