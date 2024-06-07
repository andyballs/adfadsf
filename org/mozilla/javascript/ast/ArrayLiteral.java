//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class ArrayLiteral extends AstNode implements DestructuringForm
{
    private static final List<AstNode> NO_ELEMS;
    private List<AstNode> elements;
    private int destructuringLength;
    private int skipCount;
    private boolean isDestructuring;
    private Map<String, AstNode> defaultValues;
    
    public ArrayLiteral() {
        this.defaultValues = new HashMap<String, AstNode>();
        this.type = 69;
    }
    
    public ArrayLiteral(final int pos) {
        super(pos);
        this.defaultValues = new HashMap<String, AstNode>();
        this.type = 69;
    }
    
    public ArrayLiteral(final int pos, final int len) {
        super(pos, len);
        this.defaultValues = new HashMap<String, AstNode>();
        this.type = 69;
    }
    
    public List<AstNode> getElements() {
        return (this.elements != null) ? this.elements : ArrayLiteral.NO_ELEMS;
    }
    
    public void setElements(final List<AstNode> elements) {
        if (elements == null) {
            this.elements = null;
        }
        else {
            if (this.elements != null) {
                this.elements.clear();
            }
            for (final AstNode e : elements) {
                this.addElement(e);
            }
        }
    }
    
    public void addElement(final AstNode element) {
        this.assertNotNull(element);
        if (this.elements == null) {
            this.elements = new ArrayList<AstNode>();
        }
        this.elements.add(element);
        element.setParent(this);
    }
    
    public int getSize() {
        return (this.elements == null) ? 0 : this.elements.size();
    }
    
    public AstNode getElement(final int index) {
        if (this.elements == null) {
            throw new IndexOutOfBoundsException("no elements");
        }
        return this.elements.get(index);
    }
    
    public int getDestructuringLength() {
        return this.destructuringLength;
    }
    
    public void setDestructuringLength(final int destructuringLength) {
        this.destructuringLength = destructuringLength;
    }
    
    @Override
    public void putDefaultValue(final String key, final AstNode value) {
        if (this.defaultValues.containsKey(key)) {
            Kit.codeBug("Default value map already contains value for key " + key);
        }
        this.defaultValues.put(key, value);
    }
    
    @Override
    public AstNode getDefaultValue(final String key) {
        if (!this.defaultValues.containsKey(key)) {
            Kit.codeBug("No default value entry for key " + key);
        }
        return this.defaultValues.get(key);
    }
    
    public int getSkipCount() {
        return this.skipCount;
    }
    
    public void setSkipCount(final int count) {
        this.skipCount = count;
    }
    
    @Override
    public void setIsDestructuring(final boolean destructuring) {
        this.isDestructuring = destructuring;
    }
    
    @Override
    public boolean isDestructuring() {
        return this.isDestructuring;
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("[");
        if (this.elements != null) {
            this.printList(this.elements, sb);
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            for (final AstNode e : this.getElements()) {
                e.visit(v);
            }
        }
    }
    
    static {
        NO_ELEMS = Collections.unmodifiableList((List<? extends AstNode>)new ArrayList<AstNode>());
    }
}
