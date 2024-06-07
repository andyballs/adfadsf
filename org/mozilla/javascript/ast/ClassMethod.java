//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class ClassMethod extends InfixExpression implements ClassElement
{
    private boolean isStatic;
    private boolean isPrivate;
    private AstNode name;
    private FunctionNode function;
    private Object nameKey;
    private List<DecoratorNode> decorators;
    
    public ClassMethod(final AstNode name, final FunctionNode function) {
        super(name, function);
        this.isStatic = false;
        this.isPrivate = false;
        this.decorators = new ArrayList<DecoratorNode>();
        this.type = 168;
        this.name = name;
        this.function = function;
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
    
    public FunctionNode getFunction() {
        return this.function;
    }
    
    public void setIsGetterMethod() {
        this.type = 156;
    }
    
    public boolean isGetterMethod() {
        return this.type == 156;
    }
    
    public void setIsSetterMethod() {
        this.type = 157;
    }
    
    public boolean isSetterMethod() {
        return this.type == 157;
    }
    
    public Object getNameKey() {
        return this.nameKey;
    }
    
    public void setNameKey(final Object nameKey) {
        this.nameKey = nameKey;
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
