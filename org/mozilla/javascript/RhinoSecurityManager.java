//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class RhinoSecurityManager extends SecurityManager
{
    protected Class<?> getCurrentScriptClass() {
        final Class<?>[] classContext;
        final Class<?>[] context = classContext = this.getClassContext();
        for (final Class<?> c : classContext) {
            if ((c != InterpretedFunction.class && NativeFunction.class.isAssignableFrom(c)) || PolicySecurityController.SecureCaller.class.isAssignableFrom(c)) {
                return c;
            }
        }
        return null;
    }
}
