//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class IdFunctionObjectES6 extends IdFunctionObject
{
    private static final long serialVersionUID = -8023088662589035261L;
    private static final int Id_length = 1;
    private static final int Id_name = 3;
    private boolean myLength;
    private boolean myName;
    
    public IdFunctionObjectES6(final IdFunctionCall idcall, final Object tag, final int id, final String name, final int arity, final Scriptable scope) {
        super(idcall, tag, id, name, arity, scope);
        this.myLength = true;
        this.myName = true;
    }
    
    protected int findInstanceIdInfo(final String s) {
        if (s.equals("length")) {
            return instanceIdInfo(3, 1);
        }
        if (s.equals("name")) {
            return instanceIdInfo(3, 3);
        }
        return super.findInstanceIdInfo(s);
    }
    
    protected Object getInstanceIdValue(final int id) {
        if (id == 1 && !this.myLength) {
            return IdFunctionObjectES6.NOT_FOUND;
        }
        if (id == 3 && !this.myName) {
            return IdFunctionObjectES6.NOT_FOUND;
        }
        return super.getInstanceIdValue(id);
    }
    
    protected void setInstanceIdValue(final int id, final Object value) {
        if (id == 1 && value == IdFunctionObjectES6.NOT_FOUND) {
            this.myLength = false;
            return;
        }
        if (id == 3 && value == IdFunctionObjectES6.NOT_FOUND) {
            this.myName = false;
            return;
        }
        super.setInstanceIdValue(id, value);
    }
}
