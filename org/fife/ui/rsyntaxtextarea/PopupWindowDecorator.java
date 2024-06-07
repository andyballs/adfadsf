//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.*;

public abstract class PopupWindowDecorator
{
    private static PopupWindowDecorator decorator;
    
    public abstract void decorate(final JWindow p0);
    
    public static PopupWindowDecorator get() {
        return PopupWindowDecorator.decorator;
    }
    
    public static void set(final PopupWindowDecorator decorator) {
        PopupWindowDecorator.decorator = decorator;
    }
}
