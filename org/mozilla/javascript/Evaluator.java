//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.ast.*;
import java.util.*;

public interface Evaluator
{
    Object compile(final CompilerEnvirons p0, final ScriptNode p1, final String p2, final boolean p3);
    
    Function createFunctionObject(final Context p0, final Scriptable p1, final Object p2, final Object p3);
    
    Script createScriptObject(final Object p0, final Object p1);
    
    void captureStackInfo(final RhinoException p0);
    
    String getSourcePositionFromStack(final Context p0, final int[] p1);
    
    String getPatchedStack(final RhinoException p0, final String p1);
    
    List<String> getScriptStack(final RhinoException p0);
    
    void setEvalScriptFlag(final Script p0);
}
