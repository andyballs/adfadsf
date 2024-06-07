//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class ClassField extends InfixExpression implements ClassElement
{
    private boolean isStatic;
    private boolean isPrivate;
    private AstNode name;
    private AstNode defaultValue;
    private Object nameKey;
    private List<DecoratorNode> decorators;
    
    public ClassField(final AstNode name, final AstNode defaultValue) {
        super(name, defaultValue);
        this.isStatic = false;
        this.isPrivate = false;
        this.decorators = new ArrayList<DecoratorNode>();
        this.type = 34;
        this.name = name;
        this.defaultValue = defaultValue;
    }
    
    public void setIsStatic() {
        this.isStatic = true;
    }
    
    public boolean isStatic() {
        return this.isStatic;
    }
    
    public AstNode getName() {
        return this.name;
    }
    
    public Object getNameKey() {
        return this.nameKey;
    }
    
    public void setNameKey(final Object nameKey) {
        this.nameKey = nameKey;
    }
    
    public AstNode getDefaultValue() {
        return this.defaultValue;
    }
    
    public List<DecoratorNode> getDecorators() {
        return this.decorators;
    }
    
    public void setDecorators(final List<DecoratorNode> decorators) {
        this.decorators = decorators;
    }
    
    public boolean isPrivate() {
        return this.isPrivate;
    }
    
    public void setIsPrivate() {
        this.isPrivate = true;
    }
}
