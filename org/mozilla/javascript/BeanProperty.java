//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

class BeanProperty
{
    MemberBox getter;
    MemberBox setter;
    NativeJavaMethod setters;
    
    BeanProperty(final MemberBox getter, final MemberBox setter, final NativeJavaMethod setters) {
        this.getter = getter;
        this.setter = setter;
        this.setters = setters;
    }
}
