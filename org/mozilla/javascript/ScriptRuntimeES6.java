//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class ScriptRuntimeES6
{
    public static Scriptable requireObjectCoercible(final Context cx, final Scriptable val, final IdFunctionObject idFuncObj) {
        if (val == null || Undefined.isUndefined(val)) {
            throw ScriptRuntime.typeError2("msg.called.null.or.undefined", idFuncObj.getTag(), (Object)idFuncObj.getFunctionName());
        }
        return val;
    }
}
