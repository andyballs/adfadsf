//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.debug;

public interface DebuggableScript
{
    boolean isTopLevel();
    
    boolean isFunction();
    
    String getFunctionName();
    
    int getParamCount();
    
    int getParamAndVarCount();
    
    String getParamOrVarName(final int p0);
    
    String getSourceName();
    
    boolean isGeneratedScript();
    
    int[] getLineNumbers();
    
    int getFunctionCount();
    
    DebuggableScript getFunction(final int p0);
    
    DebuggableScript getParent();
}
