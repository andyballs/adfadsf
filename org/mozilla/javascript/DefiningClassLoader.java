//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class DefiningClassLoader extends ClassLoader implements GeneratedClassLoader
{
    private final ClassLoader parentLoader;
    
    public DefiningClassLoader() {
        this.parentLoader = this.getClass().getClassLoader();
    }
    
    public DefiningClassLoader(final ClassLoader parentLoader) {
        this.parentLoader = parentLoader;
    }
    
    @Override
    public Class<?> defineClass(final String name, final byte[] data) {
        return super.defineClass(name, data, 0, data.length, SecurityUtilities.getProtectionDomain(this.getClass()));
    }
    
    @Override
    public void linkClass(final Class<?> cl) {
        this.resolveClass(cl);
    }
    
    public Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
        Class<?> cl = this.findLoadedClass(name);
        if (cl == null) {
            if (this.parentLoader != null) {
                cl = this.parentLoader.loadClass(name);
            }
            else {
                cl = this.findSystemClass(name);
            }
        }
        if (resolve) {
            this.resolveClass(cl);
        }
        return cl;
    }
}
