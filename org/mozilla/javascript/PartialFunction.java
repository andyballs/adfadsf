//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.util.stream.*;

public class PartialFunction extends ArrowFunction
{
    List<Integer> partialIndices;
    Object[] appliedObjects;
    
    public PartialFunction(final Context cx, final Scriptable scope, final Callable targetFunction, final Scriptable boundThis, final int[] partialIndices, final Object[] appliedObjects) {
        super(cx, scope, targetFunction, boundThis);
        this.partialIndices = Arrays.stream(partialIndices).boxed().collect((Collector<? super Integer, ?, List<Integer>>)Collectors.toList());
        this.appliedObjects = appliedObjects;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] oldArgs) {
        final Scriptable callThis = (this.boundThis != null) ? this.boundThis : ScriptRuntime.getTopCallScope(cx);
        final Object[] newArgs = new Object[this.partialIndices.size() + this.appliedObjects.length];
        int appliedIndex = 0;
        int oldArgsIndex = 0;
        for (int i = 0; i < newArgs.length; ++i) {
            final int indexOf = this.partialIndices.indexOf(i);
            if (indexOf == -1) {
                newArgs[i] = this.appliedObjects[appliedIndex++];
            }
            else {
                newArgs[i] = oldArgs[oldArgsIndex++];
            }
        }
        return this.targetFunction.call(cx, scope, callThis, newArgs);
    }
}
