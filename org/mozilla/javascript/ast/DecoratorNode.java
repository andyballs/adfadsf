//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.decorators.*;

public class DecoratorNode extends FunctionCall
{
    private DecoratorType decoratorType;
    
    public DecoratorNode(final int pos, final Name name) {
        super(pos);
        this.putProp(33, (Object)true);
        this.setTarget(name);
    }
    
    public DecoratorType getDecoratorType() {
        return this.decoratorType;
    }
    
    public void setDecoratorType(final DecoratorType decoratorType) {
        this.decoratorType = decoratorType;
    }
}
