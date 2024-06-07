//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.decorators;

import org.mozilla.javascript.*;

public enum DecoratorType
{
    WRAP((Class<? extends Decorator>)WrapDecorator.class), 
    REGISTER((Class<? extends Decorator>)RegisterDecorator.class), 
    INITIALIZE((Class<? extends Decorator>)InitializeDecorator.class), 
    NUMERICTEMPLATE((Class<? extends Decorator>)NumericTemplateDecorator.class), 
    USER_DEFINED((Class<? extends Decorator>)null);
    
    private Class<? extends Decorator> decoratorClass;
    
    private DecoratorType(final Class<? extends Decorator> decoratorClass) {
        this.decoratorClass = decoratorClass;
    }
    
    public Class<? extends Decorator> getDecoratorClass() {
        return this.decoratorClass;
    }
    
    public boolean shouldTrigger(final DecoratorType type) {
        return type == DecoratorType.USER_DEFINED || this == type;
    }
    
    public static DecoratorType fromDecorator(String decorator) {
        decorator = decorator.replaceAll("@", "");
        for (final DecoratorType type : values()) {
            if (type.name().toLowerCase().equals(decorator.toLowerCase())) {
                return type;
            }
        }
        return DecoratorType.USER_DEFINED;
    }
    
    public static void init(final Scriptable scope) {
        WrapDecorator.init(scope);
        RegisterDecorator.init(scope);
        InitializeDecorator.init(scope);
        NumericTemplateDecorator.init(scope);
    }
}
