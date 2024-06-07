//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class ClassNode extends ScriptNode
{
    private Name className;
    private AstNode extendsName;
    private FunctionNode constructor;
    private List<ClassMethod> methods;
    private List<ClassField> fields;
    private List<DecoratorNode> decorators;
    private Node parentFn;
    private Node extended;
    
    public ClassNode() {
        this.className = null;
        this.extendsName = null;
        this.constructor = null;
        this.methods = new ArrayList<ClassMethod>();
        this.fields = new ArrayList<ClassField>();
        this.decorators = new ArrayList<DecoratorNode>();
        this.parentFn = null;
        this.extended = null;
        this.type = 115;
    }
    
    public ClassNode(final int pos) {
        super(pos);
        this.className = null;
        this.extendsName = null;
        this.constructor = null;
        this.methods = new ArrayList<ClassMethod>();
        this.fields = new ArrayList<ClassField>();
        this.decorators = new ArrayList<DecoratorNode>();
        this.parentFn = null;
        this.extended = null;
        this.type = 115;
    }
    
    public ClassNode(final int pos, final Name name) {
        super(pos);
        this.className = null;
        this.extendsName = null;
        this.constructor = null;
        this.methods = new ArrayList<ClassMethod>();
        this.fields = new ArrayList<ClassField>();
        this.decorators = new ArrayList<DecoratorNode>();
        this.parentFn = null;
        this.extended = null;
        this.type = 115;
        this.className = name;
        if (name != null) {
            name.setParent((AstNode)this);
        }
    }
    
    public boolean hasPrivateSlots() {
        return this.methods.stream().anyMatch(ClassMethod::isPrivate) || this.fields.stream().anyMatch(ClassField::isPrivate);
    }
    
    public Name getClassName() {
        return this.className;
    }
    
    public void setClassName(final Name name) {
        this.className = name;
    }
    
    public void setExtendsNode(final AstNode name) {
        this.extendsName = name;
    }
    
    public AstNode getExtendsName() {
        return this.extendsName;
    }
    
    public FunctionNode getConstructor() {
        return this.constructor;
    }
    
    public void setConstructor(final FunctionNode constructor) {
        this.constructor = constructor;
    }
    
    public List<ClassMethod> getMethods() {
        return this.methods;
    }
    
    public void setMethods(final List<ClassMethod> methods) {
        this.methods = methods;
    }
    
    public List<ClassField> getFields() {
        return this.fields;
    }
    
    public void setFields(final List<ClassField> fields) {
        this.fields = fields;
    }
    
    public Node getParentFn() {
        return this.parentFn;
    }
    
    public void setParentFn(final Node parentFn) {
        this.parentFn = parentFn;
    }
    
    public Node getExtended() {
        return this.extended;
    }
    
    public void setExtended(final Node extended) {
        this.extended = extended;
    }
    
    public List<DecoratorNode> getDecorators() {
        return this.decorators;
    }
    
    public void setDecorators(final List<DecoratorNode> decorators) {
        this.decorators = decorators;
    }
}
