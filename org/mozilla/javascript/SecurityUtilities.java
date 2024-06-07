//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.security.*;

public class SecurityUtilities
{
    public static String getSystemProperty(final String name) {
        return AccessController.doPrivileged((PrivilegedAction<String>)new PrivilegedAction<String>() {
            @Override
            public String run() {
                return System.getProperty(name);
            }
        });
    }
    
    public static ProtectionDomain getProtectionDomain(final Class<?> clazz) {
        return AccessController.doPrivileged((PrivilegedAction<ProtectionDomain>)new PrivilegedAction<ProtectionDomain>() {
            @Override
            public ProtectionDomain run() {
                return clazz.getProtectionDomain();
            }
        });
    }
    
    public static ProtectionDomain getScriptProtectionDomain() {
        final SecurityManager securityManager = System.getSecurityManager();
        if (securityManager instanceof RhinoSecurityManager) {
            return AccessController.doPrivileged((PrivilegedAction<ProtectionDomain>)new PrivilegedAction<ProtectionDomain>() {
                @Override
                public ProtectionDomain run() {
                    final Class<?> c = (Class<?>)((RhinoSecurityManager)securityManager).getCurrentScriptClass();
                    return (c == null) ? null : c.getProtectionDomain();
                }
            });
        }
        return null;
    }
}
