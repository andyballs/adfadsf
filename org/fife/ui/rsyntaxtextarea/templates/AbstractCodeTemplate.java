//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.templates;

public abstract class AbstractCodeTemplate implements CodeTemplate
{
    private String id;
    
    public AbstractCodeTemplate() {
    }
    
    public AbstractCodeTemplate(final String id) {
        this.setID(id);
    }
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError("CodeTemplate implementation not Cloneable: " + this.getClass().getName());
        }
    }
    
    @Override
    public int compareTo(final CodeTemplate o) {
        if (o == null) {
            return -1;
        }
        return this.getID().compareTo(o.getID());
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof CodeTemplate && this.compareTo((CodeTemplate)obj) == 0;
    }
    
    @Override
    public String getID() {
        return this.id;
    }
    
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    
    public void setID(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        this.id = id;
    }
}
