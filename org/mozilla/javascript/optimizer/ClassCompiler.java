//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.*;
import org.mozilla.javascript.ast.*;

public class ClassCompiler
{
    private String mainMethodClassName;
    private CompilerEnvirons compilerEnv;
    private Class<?> targetExtends;
    private Class<?>[] targetImplements;
    
    public ClassCompiler(final CompilerEnvirons compilerEnv) {
        if (compilerEnv == null) {
            throw new IllegalArgumentException();
        }
        this.compilerEnv = compilerEnv;
        this.mainMethodClassName = "org.mozilla.javascript.optimizer.OptRuntime";
    }
    
    public void setMainMethodClass(final String className) {
        this.mainMethodClassName = className;
    }
    
    public String getMainMethodClass() {
        return this.mainMethodClassName;
    }
    
    public CompilerEnvirons getCompilerEnv() {
        return this.compilerEnv;
    }
    
    public Class<?> getTargetExtends() {
        return this.targetExtends;
    }
    
    public void setTargetExtends(final Class<?> extendsClass) {
        this.targetExtends = extendsClass;
    }
    
    public Class<?>[] getTargetImplements() {
        return (Class<?>[])((this.targetImplements == null) ? null : ((Class[])this.targetImplements.clone()));
    }
    
    public void setTargetImplements(final Class<?>[] implementsClasses) {
        this.targetImplements = (Class<?>[])((implementsClasses == null) ? null : ((Class[])implementsClasses.clone()));
    }
    
    protected String makeAuxiliaryClassName(final String mainClassName, final String auxMarker) {
        return mainClassName + auxMarker;
    }
    
    public Object[] compileToClassFiles(final String source, final String sourceLocation, final int lineno, final String mainClassName) {
        Parser p = new Parser(this.compilerEnv);
        AstRoot ast = p.parse(source, sourceLocation, lineno);
        IRFactory irf = new IRFactory(this.compilerEnv);
        final ScriptNode tree = irf.transformTree(ast);
        irf = null;
        ast = null;
        p = null;
        Class<?> superClass = this.getTargetExtends();
        final Class<?>[] interfaces = this.getTargetImplements();
        final boolean isPrimary = interfaces == null && superClass == null;
        String scriptClassName;
        if (isPrimary) {
            scriptClassName = mainClassName;
        }
        else {
            scriptClassName = this.makeAuxiliaryClassName(mainClassName, "1");
        }
        final Codegen codegen = new Codegen();
        codegen.setMainMethodClass(this.mainMethodClassName);
        final byte[] scriptClassBytes = codegen.compileToClassFile(this.compilerEnv, scriptClassName, tree, tree.getEncodedSource(), false);
        if (isPrimary) {
            return new Object[] { scriptClassName, scriptClassBytes };
        }
        final int functionCount = tree.getFunctionCount();
        final ObjToIntMap functionNames = new ObjToIntMap(functionCount);
        for (int i = 0; i != functionCount; ++i) {
            final FunctionNode ofn = tree.getFunctionNode(i);
            final String name = ofn.getName();
            if (name != null && name.length() != 0) {
                functionNames.put((Object)name, ofn.getParamCount());
            }
        }
        if (superClass == null) {
            superClass = ScriptRuntime.ObjectClass;
        }
        final byte[] mainClassBytes = JavaAdapter.createAdapterCode(functionNames, mainClassName, (Class)superClass, (Class[])interfaces, scriptClassName);
        return new Object[] { mainClassName, mainClassBytes, scriptClassName, scriptClassBytes };
    }
}
