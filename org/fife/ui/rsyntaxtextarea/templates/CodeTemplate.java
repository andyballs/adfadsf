//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.templates;

import java.io.*;
import org.fife.ui.rsyntaxtextarea.*;
import javax.swing.text.*;

public interface CodeTemplate extends Cloneable, Comparable<CodeTemplate>, Serializable
{
    Object clone();
    
    String getID();
    
    void invoke(final RSyntaxTextArea p0) throws BadLocationException;
}
