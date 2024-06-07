//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class ObjectLiteral extends AstNode implements DestructuringForm
{
    private static final List<ObjectProperty> NO_ELEMS;
    private List<ObjectProperty> elements;
    boolean isDestructuring;
    private Map<String, AstNode> defaultValues;
    
    public ObjectLiteral() {
        this.defaultValues = new HashMap<String, AstNode>();
        this.type = 70;
    }
    
    public ObjectLiteral(final int pos) {
        super(pos);
        this.defaultValues = new HashMap<String, AstNode>();
        this.type = 70;
    }
    
    public ObjectLiteral(final int pos, final int len) {
        super(pos, len);
        this.defaultValues = new HashMap<String, AstNode>();
        this.type = 70;
    }
    
    public List<ObjectProperty> getElements() {
        return (this.elements != null) ? this.elements : ObjectLiteral.NO_ELEMS;
    }
    
    public void setElements(final List<ObjectProperty> elements) {
        if (elements == null) {
            this.elements = null;
        }
        else {
            if (this.elements != null) {
                this.elements.clear();
            }
            for (final ObjectProperty o : elements) {
                this.addElement(o);
            }
        }
    }
    
    public void addElement(final ObjectProperty element) {
        this.assertNotNull((Object)element);
        if (this.elements == null) {
            this.elements = new ArrayList<ObjectProperty>();
        }
        this.elements.add(element);
        element.setParent((AstNode)this);
    }
    
    public void setIsDestructuring(final boolean destructuring) {
        this.isDestructuring = destructuring;
    }
    
    public boolean isDestructuring() {
        return this.isDestructuring;
    }
    
    public void putDefaultValue(final String key, final AstNode value) {
        if (this.defaultValues.containsKey(key)) {
            Kit.codeBug("Default value map already contains value for key " + key);
        }
        this.defaultValues.put(key, value);
    }
    
    public AstNode getDefaultValue(final String key) {
        if (!this.defaultValues.containsKey(key)) {
            Kit.codeBug("No default value entry for key " + key);
        }
        return this.defaultValues.get(key);
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("{");
        if (this.elements != null) {
            this.printList((List)this.elements, sb);
        }
        sb.append("}");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            for (final ObjectProperty prop : this.getElements()) {
                prop.visit(v);
            }
        }
    }
    
    static {
        NO_ELEMS = Collections.unmodifiableList((List<? extends ObjectProperty>)new ArrayList<ObjectProperty>());
    }
}
