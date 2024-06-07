//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.lang.reflect.*;

public abstract class VMBridge
{
    static final VMBridge instance;
    
    private static VMBridge makeInstance() {
        final String[] classNames = { "org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk18.VMBridge_jdk18" };
        for (int i = 0; i != classNames.length; ++i) {
            final String className = classNames[i];
            final Class<?> cl = (Class<?>)Kit.classOrNull(className);
            if (cl != null) {
                final VMBridge bridge = (VMBridge)Kit.newInstanceOrNull((Class)cl);
                if (bridge != null) {
                    return bridge;
                }
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }
    
    protected abstract Object getThreadContextHelper();
    
    protected abstract Context getContext(final Object p0);
    
    protected abstract void setContext(final Object p0, final Context p1);
    
    protected abstract boolean tryToMakeAccessible(final AccessibleObject p0);
    
    protected abstract Object getInterfaceProxyHelper(final ContextFactory p0, final Class<?>[] p1);
    
    protected abstract Object newInterfaceProxy(final Object p0, final ContextFactory p1, final InterfaceAdapter p2, final Object p3, final Scriptable p4);
    
    static {
        instance = makeInstance();
    }
}
