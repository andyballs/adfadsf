//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import java.lang.reflect.*;
import java.util.*;
import org.mozilla.javascript.*;

class FlexibleCompletor implements InvocationHandler
{
    private Method completeMethod;
    private Scriptable global;
    
    FlexibleCompletor(final Class<?> completorClass, final Scriptable global) throws NoSuchMethodException {
        this.global = global;
        this.completeMethod = completorClass.getMethod("complete", String.class, Integer.TYPE, List.class);
    }
    
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) {
        if (method.equals(this.completeMethod)) {
            final int result = this.complete((String)args[0], (int)args[1], (List<String>)args[2]);
            return result;
        }
        throw new NoSuchMethodError(method.toString());
    }
    
    public int complete(final String buffer, final int cursor, final List<String> candidates) {
        int m;
        for (m = cursor - 1; m >= 0; --m) {
            final char c = buffer.charAt(m);
            if (!Character.isJavaIdentifierPart(c) && c != '.') {
                break;
            }
        }
        final String namesAndDots = buffer.substring(m + 1, cursor);
        final String[] names = namesAndDots.split("\\.", -1);
        Scriptable obj = this.global;
        for (int i = 0; i < names.length - 1; ++i) {
            final Object val = obj.get(names[i], this.global);
            if (!(val instanceof Scriptable)) {
                return buffer.length();
            }
            obj = (Scriptable)val;
        }
        final Object[] ids = (obj instanceof ScriptableObject) ? ((ScriptableObject)obj).getAllIds() : obj.getIds();
        final String lastPart = names[names.length - 1];
        for (int j = 0; j < ids.length; ++j) {
            if (ids[j] instanceof String) {
                String id = (String)ids[j];
                if (id.startsWith(lastPart)) {
                    if (obj.get(id, obj) instanceof Function) {
                        id += "(";
                    }
                    candidates.add(id);
                }
            }
        }
        return buffer.length() - lastPart.length();
    }
}
