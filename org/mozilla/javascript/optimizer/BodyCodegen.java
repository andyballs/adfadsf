//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import org.mozilla.classfile.*;
import java.lang.invoke.*;
import org.mozilla.javascript.decorators.*;
import org.mozilla.javascript.ast.*;
import org.mozilla.javascript.*;
import java.util.*;

class BodyCodegen
{
    private static final int JAVASCRIPT_EXCEPTION = 0;
    private static final int EVALUATOR_EXCEPTION = 1;
    private static final int ECMAERROR_EXCEPTION = 2;
    private static final int THROWABLE_EXCEPTION = 3;
    private static final int FINALLY_EXCEPTION = 4;
    private static final int EXCEPTION_MAX = 5;
    private ExceptionManager exceptionManager;
    private static final String SCRIPTABLE = "Lorg/mozilla/javascript/Scriptable;";
    private static final String SCRIPTABLE_OBJECT = "Lorg/mozilla/javascript/ScriptableObject;";
    private static final String CALLABLE = "Lorg/mozilla/javascript/Callable;";
    private static final String NATIVE_FUNCTION = "Lorg/mozilla/javascript/NativeFunction;";
    private static final String FUNCTION = "Lorg/mozilla/javascript/Function;";
    private static final String REF = "Lorg/mozilla/javascript/Ref;";
    private static final String CONTEXT = "Lorg/mozilla/javascript/Context;";
    private static final String OBJECT = "Ljava/lang/Object;";
    private static final String OBJECT_ARRAY = "[Ljava/lang/Object;";
    private static final String INTEGER = "I";
    private static final String BOOLEAN = "Z";
    private static final String VOID = "V";
    private static final String LONG = "J";
    private static final String DOUBLE = "D";
    private static final String STRING = "Ljava/lang/String;";
    private static final String STRING_ARRAY = "[Ljava/lang/String;";
    static final int GENERATOR_TERMINATE = -1;
    static final int GENERATOR_START = 0;
    static final int GENERATOR_YIELD_START = 1;
    boolean currentCtorClass;
    ClassFileWriter cfw;
    Codegen codegen;
    CompilerEnvirons compilerEnv;
    ScriptNode scriptOrFn;
    public int scriptOrFnIndex;
    private int savedCodeOffset;
    private OptFunctionNode fnCurrent;
    private static final int MAX_LOCALS = 1024;
    private int[] locals;
    private short firstFreeLocal;
    private short localsMax;
    private int itsLineNumber;
    private boolean hasVarsInRegs;
    private short[] varRegisters;
    private boolean inDirectCallFunction;
    private boolean itsForcedObjectParameters;
    private int enterAreaStartLabel;
    private int epilogueLabel;
    private boolean inLocalBlock;
    private short variableObjectLocal;
    private short popvLocal;
    private short contextLocal;
    private short argsLocal;
    private short operationLocal;
    private short thisObjLocal;
    private short funObjLocal;
    private short itsZeroArgArray;
    private short itsOneArgArray;
    private short generatorStateLocal;
    private boolean isGenerator;
    private int generatorSwitch;
    private Node generatorReturnNode;
    private int maxLocals;
    private int maxStack;
    private Map<Node, FinallyReturnPoint> finallys;
    private List<Node> literals;
    
    BodyCodegen() {
        this.exceptionManager = new ExceptionManager();
        this.currentCtorClass = false;
        this.maxLocals = 0;
        this.maxStack = 0;
    }
    
    void generateBodyCode() {
        this.isGenerator = Codegen.isGenerator(this.scriptOrFn);
        this.initBodyGeneration();
        if (this.isGenerator) {
            final String type = "(" + this.codegen.mainClassSignature + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;";
            this.cfw.startMethod(this.codegen.getBodyMethodName(this.scriptOrFn) + "_gen", type, (short)10);
        }
        else {
            this.cfw.startMethod(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short)10);
        }
        this.generatePrologue();
        Node treeTop;
        if (this.fnCurrent != null && !(this.scriptOrFn instanceof DecoratorDeclarationNode)) {
            treeTop = this.scriptOrFn.getLastChild();
        }
        else {
            treeTop = (Node)this.scriptOrFn;
        }
        this.generateStatement(treeTop);
        this.generateEpilogue();
        this.cfw.stopMethod((short)(this.localsMax + 1));
        if (this.isGenerator) {
            this.generateGenerator();
        }
        if (this.literals != null) {
            for (int i = 0; i < this.literals.size(); ++i) {
                final Node node = this.literals.get(i);
                final int type2 = node.getType();
                switch (type2) {
                    case 70: {
                        this.generateObjectLiteralFactory(node, i + 1);
                        break;
                    }
                    case 69: {
                        this.generateArrayLiteralFactory(node, i + 1);
                        break;
                    }
                    default: {
                        Kit.codeBug(Token.typeToName(type2));
                        break;
                    }
                }
            }
        }
    }
    
    private void generateGenerator() {
        this.cfw.startMethod(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short)10);
        this.initBodyGeneration();
        final short firstFreeLocal = this.firstFreeLocal;
        this.firstFreeLocal = (short)(firstFreeLocal + 1);
        this.argsLocal = firstFreeLocal;
        this.localsMax = this.firstFreeLocal;
        if (this.fnCurrent != null) {
            this.cfw.addALoad((int)this.funObjLocal);
            this.cfw.addInvoke(185, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.addAStore((int)this.variableObjectLocal);
        }
        this.cfw.addALoad((int)this.funObjLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addALoad((int)this.argsLocal);
        this.cfw.addPush(this.scriptOrFn.isInStrictMode());
        this.cfw.addPush(false);
        this.addScriptRuntimeInvoke("createFunctionActivation", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "Z", "Z");
        this.cfw.addAStore((int)this.variableObjectLocal);
        this.cfw.add(187, this.codegen.mainClassName);
        this.cfw.add(89);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addPush(this.scriptOrFnIndex);
        this.cfw.addInvoke(183, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        this.generateNestedFunctionInits();
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addALoad((int)this.thisObjLocal);
        this.cfw.addLoadConstant(this.maxLocals);
        this.cfw.addLoadConstant(this.maxStack);
        this.addOptRuntimeInvoke("createNativeGenerator", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "I", "I");
        this.cfw.add(176);
        this.cfw.stopMethod((short)(this.localsMax + 1));
    }
    
    private void generateNestedFunctionInits() {
        for (int functionCount = this.scriptOrFn.getFunctionCount(), i = 0; i != functionCount; ++i) {
            final OptFunctionNode ofn = OptFunctionNode.get(this.scriptOrFn, i);
            if (ofn.fnode.getFunctionType() == 1) {
                this.visitFunction(ofn, 1);
            }
        }
    }
    
    private void initBodyGeneration() {
        this.varRegisters = null;
        if (this.scriptOrFn.getType() == 114 || this.scriptOrFn.getType() == 135) {
            this.fnCurrent = OptFunctionNode.get(this.scriptOrFn);
            this.hasVarsInRegs = !this.fnCurrent.fnode.requiresActivation();
            if (this.hasVarsInRegs) {
                final int n = this.fnCurrent.fnode.getParamAndVarCount();
                if (n != 0) {
                    this.varRegisters = new short[n];
                }
            }
            this.inDirectCallFunction = this.fnCurrent.isTargetOfDirectCall();
            if (this.inDirectCallFunction && !this.hasVarsInRegs) {
                Codegen.badTree();
            }
        }
        else {
            this.fnCurrent = null;
            this.hasVarsInRegs = false;
            this.inDirectCallFunction = false;
        }
        this.locals = new int[1024];
        this.funObjLocal = 0;
        this.contextLocal = 1;
        this.variableObjectLocal = 2;
        this.thisObjLocal = 3;
        this.localsMax = 4;
        this.firstFreeLocal = 4;
        this.popvLocal = -1;
        this.argsLocal = -1;
        this.itsZeroArgArray = -1;
        this.itsOneArgArray = -1;
        this.epilogueLabel = -1;
        this.enterAreaStartLabel = -1;
        this.generatorStateLocal = -1;
    }
    
    private void generatePrologue() {
        if (this.inDirectCallFunction) {
            final int directParameterCount = this.scriptOrFn.getParamCount();
            if (this.firstFreeLocal != 4) {
                Kit.codeBug();
            }
            for (int i = 0; i != directParameterCount; ++i) {
                this.varRegisters[i] = this.firstFreeLocal;
                this.firstFreeLocal += 3;
            }
            if (!this.fnCurrent.getParameterNumberContext()) {
                this.itsForcedObjectParameters = true;
                for (int i = 0; i != directParameterCount; ++i) {
                    final short reg = this.varRegisters[i];
                    this.cfw.addALoad((int)reg);
                    this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    final int isObjectLabel = this.cfw.acquireLabel();
                    this.cfw.add(166, isObjectLabel);
                    this.cfw.addDLoad(reg + 1);
                    this.addDoubleWrap();
                    this.cfw.addAStore((int)reg);
                    this.cfw.markLabel(isObjectLabel);
                }
            }
        }
        if (this.currentCtorClass) {
            final ClassNode cls = ((FunctionNode)this.scriptOrFn).getParentClass();
            Node child = cls.getFirstChild().getNext();
            while (child != null) {
                List<DecoratorNode> decorators;
                if (child instanceof ClassElement) {
                    decorators = (List<DecoratorNode>)((ClassElement)child).getDecorators();
                }
                else {
                    if (!(child instanceof ClassNode)) {
                        throw Kit.codeBug();
                    }
                    decorators = (List<DecoratorNode>)((ClassNode)child).getDecorators();
                }
                if (!decorators.isEmpty()) {
                    for (final DecoratorNode dn : decorators) {
                        if (dn.getDecoratorType() != DecoratorType.INITIALIZE && dn.getDecoratorType() != DecoratorType.USER_DEFINED) {
                            continue;
                        }
                        if (dn.getDecoratorType() == DecoratorType.INITIALIZE && child instanceof ClassField && ((ClassField)child).isStatic()) {
                            throw ScriptRuntime.typeError0("msg.decorator.initialize.on.static.field");
                        }
                        final Name decorator = (Name)dn.getTarget();
                        this.generateExpression((Node)decorator, child);
                        this.cfw.add(192, "org/mozilla/javascript/BaseFunction");
                        if (child instanceof ClassElement) {
                            this.cfw.addALoad((int)this.thisObjLocal);
                            this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
                            this.cfw.add(178, "org/mozilla/javascript/decorators/Decorator", "NAME_KEY", "Ljava/lang/Object;");
                            final Object targetName = ((ClassElement)child).getNameKey();
                            if (targetName instanceof String) {
                                this.cfw.addPush((String)targetName);
                            }
                            else if (targetName instanceof Integer) {
                                this.cfw.addPush((int)targetName);
                            }
                            else {
                                if (!(targetName instanceof Node)) {
                                    throw Kit.codeBug((targetName == null) ? "null" : targetName.getClass().getSimpleName());
                                }
                                this.generateExpression((Node)targetName, child);
                            }
                            this.cfw.addPush(true);
                            this.cfw.addInvoke(182, "org/mozilla/javascript/ScriptableObject", "associateValue", "(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;");
                            this.cfw.add(87);
                        }
                        if (child instanceof ClassField && !((ClassField)child).isStatic()) {
                            this.cfw.addALoad((int)this.thisObjLocal);
                            this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
                            this.cfw.add(178, "org/mozilla/javascript/decorators/Decorator", "VALUE_KEY", "Ljava/lang/Object;");
                            final Node targetValue = child.getFirstChild();
                            this.generateExpression(targetValue, child);
                            this.cfw.addPush(true);
                            this.cfw.addInvoke(182, "org/mozilla/javascript/ScriptableObject", "associateValue", "(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;");
                            this.cfw.add(87);
                        }
                        this.cfw.addALoad((int)this.contextLocal);
                        this.cfw.addALoad((int)this.variableObjectLocal);
                        this.cfw.addALoad((int)this.thisObjLocal);
                        this.cfw.addPush(4);
                        this.cfw.add(189, "java/lang/Object");
                        this.cfw.add(89);
                        this.cfw.addPush(0);
                        this.cfw.addALoad((int)this.thisObjLocal);
                        this.cfw.add(83);
                        this.cfw.add(89);
                        this.cfw.addPush(1);
                        this.generateDecoratorDescriptor(child);
                        this.generateIntegerWrap();
                        this.cfw.add(83);
                        this.cfw.add(89);
                        this.cfw.addPush(2);
                        this.cfw.add(178, "org/mozilla/javascript/decorators/DecoratorType", DecoratorType.INITIALIZE.name(), "Lorg/mozilla/javascript/decorators/DecoratorType;");
                        this.cfw.add(83);
                        final List<Node> args = new ArrayList<Node>();
                        for (Node ch = dn.getFirstChild(); ch != null; ch = ch.getNext()) {
                            args.add(ch);
                        }
                        this.cfw.add(89);
                        this.cfw.addPush(3);
                        this.cfw.addPush(args.size());
                        this.cfw.add(189, "java/lang/Object");
                        for (int j = 0; j < args.size(); ++j) {
                            this.cfw.add(89);
                            this.cfw.addPush(j);
                            final Node ch2 = args.get(j);
                            this.generateExpression(ch2, child);
                            this.cfw.add(83);
                        }
                        this.cfw.add(83);
                        this.cfw.addInvoke(182, "org/mozilla/javascript/BaseFunction", "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
                    }
                }
                if (child instanceof ClassField && !((ClassField)child).isStatic()) {
                    final int L1 = this.cfw.acquireLabel();
                    this.cfw.addALoad((int)this.thisObjLocal);
                    this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
                    this.cfw.add(178, "org/mozilla/javascript/decorators/Decorator", "HAS_INITIALIZE", "Ljava/lang/Object;");
                    this.cfw.addInvoke(182, "org/mozilla/javascript/ScriptableObject", "getAssociatedValue", "(Ljava/lang/Object;)Ljava/lang/Object;");
                    this.cfw.add(192, "java/lang/Boolean");
                    this.cfw.add(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
                    this.cfw.add(165, L1);
                    final ClassField cp = (ClassField)child;
                    final Node defaultValue = cp.getFirstChild();
                    final Object name = cp.getNameKey();
                    this.cfw.addALoad((int)this.thisObjLocal);
                    if (name instanceof String) {
                        this.cfw.addPush((String)name);
                    }
                    else if (name instanceof Node) {
                        final Node nameNode = (Node)name;
                        this.generateExpression(nameNode, (Node)cls);
                    }
                    else {
                        this.cfw.addPush((int)name);
                        this.addScriptRuntimeInvoke("wrapInt", "Ljava/lang/Integer;", "I");
                    }
                    this.generateExpression(defaultValue, (Node)cls);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addPush(cp.isPrivate());
                    this.addScriptRuntimeInvoke("addClassProperty", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Z");
                    this.cfw.addAStore((int)this.thisObjLocal);
                    this.cfw.markLabel(L1);
                    child = child.getNext();
                }
                else {
                    if (child instanceof ClassNode) {
                        break;
                    }
                    child = child.getNext();
                    if (child != null) {
                        continue;
                    }
                    child = (Node)cls;
                }
            }
        }
        if (this.fnCurrent != null) {
            this.cfw.addALoad((int)this.funObjLocal);
            this.cfw.addInvoke(185, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.addAStore((int)this.variableObjectLocal);
        }
        final short firstFreeLocal = this.firstFreeLocal;
        this.firstFreeLocal = (short)(firstFreeLocal + 1);
        this.argsLocal = firstFreeLocal;
        this.localsMax = this.firstFreeLocal;
        if (this.isGenerator) {
            final short firstFreeLocal2 = this.firstFreeLocal;
            this.firstFreeLocal = (short)(firstFreeLocal2 + 1);
            this.operationLocal = firstFreeLocal2;
            this.localsMax = this.firstFreeLocal;
            this.cfw.addALoad((int)this.thisObjLocal);
            final short firstFreeLocal3 = this.firstFreeLocal;
            this.firstFreeLocal = (short)(firstFreeLocal3 + 1);
            this.generatorStateLocal = firstFreeLocal3;
            this.localsMax = this.firstFreeLocal;
            this.cfw.add(192, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState");
            this.cfw.add(89);
            this.cfw.addAStore((int)this.generatorStateLocal);
            this.cfw.add(180, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "thisObj", "Lorg/mozilla/javascript/Scriptable;");
            this.cfw.addAStore((int)this.thisObjLocal);
            if (this.epilogueLabel == -1) {
                this.epilogueLabel = this.cfw.acquireLabel();
            }
            final List<Node> targets = (List<Node>)((FunctionNode)this.scriptOrFn).getResumptionPoints();
            this.generateGetGeneratorResumptionPoint();
            this.generatorSwitch = this.cfw.addTableSwitch(0, targets.size() + 0);
            this.generateCheckForThrowOrClose(-1, false, 0);
        }
        if (this.fnCurrent == null && this.scriptOrFn.getRegexpCount() != 0) {
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addInvoke(184, this.codegen.mainClassName, "_reInit", "(Lorg/mozilla/javascript/Context;)V");
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            this.saveCurrentCodeOffset();
        }
        if (this.hasVarsInRegs) {
            int paramCount = this.scriptOrFn.getParamCount();
            if (paramCount > 0 && !this.inDirectCallFunction) {
                this.cfw.addALoad((int)this.argsLocal);
                this.cfw.add(190);
                this.cfw.addPush(paramCount);
                final int label = this.cfw.acquireLabel();
                this.cfw.add(162, label);
                this.cfw.addALoad((int)this.argsLocal);
                this.cfw.addPush(paramCount);
                this.addScriptRuntimeInvoke("padArguments", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "I");
                this.cfw.addAStore((int)this.argsLocal);
                this.cfw.markLabel(label);
            }
            paramCount = this.fnCurrent.fnode.getParamCount();
            final int varCount = this.fnCurrent.fnode.getParamAndVarCount();
            final boolean[] constDeclarations = this.fnCurrent.fnode.getParamAndVarConst();
            final List<AstNode> params = (List<AstNode>)this.fnCurrent.fnode.getParams();
            final Map<Integer, Node> defaultParams = (Map<Integer, Node>)this.fnCurrent.fnode.getDefaultParams();
            this.generateParameterTDZChecks(params, defaultParams);
            short firstUndefVar = -1;
            for (int k = 0; k != varCount; ++k) {
                short reg2 = -1;
                if (k < paramCount) {
                    if (!this.inDirectCallFunction) {
                        reg2 = this.getNewWordLocal();
                        if (params.get(k).getProp(29) != null) {
                            this.cfw.addALoad((int)this.argsLocal);
                            this.cfw.addPush(k);
                            this.cfw.addALoad((int)this.contextLocal);
                            this.cfw.addALoad((int)this.variableObjectLocal);
                            this.addScriptRuntimeInvoke("getRestParams", "Ljava/lang/Object;", "[Ljava/lang/Object;", "I", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                        }
                        else {
                            this.cfw.addALoad((int)this.argsLocal);
                            this.cfw.addPush(k);
                            this.cfw.add(50);
                            if (defaultParams.containsKey(k)) {
                                final int label2 = this.cfw.acquireLabel();
                                final Node defaultParam = defaultParams.get(k);
                                if (defaultParam.getType() == 53) {
                                    this.cfw.addALoad((int)this.argsLocal);
                                    this.cfw.addPush(k);
                                    this.cfw.add(50);
                                    this.cfw.addInvoke(184, "org/mozilla/javascript/Undefined", "isUndefined", "(Ljava/lang/Object;)Z");
                                    this.cfw.add(153, label2);
                                }
                                else {
                                    this.cfw.add(89);
                                    this.cfw.addInvoke(184, "org/mozilla/javascript/Undefined", "isUndefined", "(Ljava/lang/Object;)Z");
                                    this.cfw.add(153, label2);
                                    this.cfw.add(87);
                                }
                                this.generateExpression(defaultParam, (Node)this.fnCurrent.fnode);
                                this.cfw.markLabel(label2);
                            }
                        }
                        this.cfw.addAStore((int)reg2);
                    }
                }
                else if (this.fnCurrent.isNumberVar(k)) {
                    reg2 = this.getNewWordPairLocal(constDeclarations[k]);
                    this.cfw.addPush(0.0);
                    this.cfw.addDStore((int)reg2);
                }
                else {
                    reg2 = this.getNewWordLocal(constDeclarations[k]);
                    if (firstUndefVar == -1) {
                        Codegen.pushUndefined(this.cfw);
                        firstUndefVar = reg2;
                    }
                    else {
                        this.cfw.addALoad((int)firstUndefVar);
                    }
                    this.cfw.addAStore((int)reg2);
                }
                if (reg2 >= 0) {
                    if (constDeclarations[k]) {
                        this.cfw.addPush(0);
                        this.cfw.addIStore(reg2 + (this.fnCurrent.isNumberVar(k) ? 2 : 1));
                    }
                    this.varRegisters[k] = reg2;
                }
                if (this.compilerEnv.isGenerateDebugInfo()) {
                    final String name2 = this.fnCurrent.fnode.getParamOrVarName(k);
                    final String type = this.fnCurrent.isNumberVar(k) ? "D" : "Ljava/lang/Object;";
                    final int startPC = this.cfw.getCurrentCodeOffset();
                    if (reg2 < 0) {
                        reg2 = this.varRegisters[k];
                    }
                    this.cfw.addVariableDescriptor(name2, type, startPC, (int)reg2);
                }
            }
            return;
        }
        if (this.isGenerator) {
            return;
        }
        boolean isArrow = false;
        if (this.scriptOrFn instanceof FunctionNode) {
            isArrow = (((FunctionNode)this.scriptOrFn).getFunctionType() == 4);
        }
        String debugVariableName;
        if (this.fnCurrent != null) {
            final String methodName = isArrow ? "createArrowFunctionActivation" : "createFunctionActivation";
            debugVariableName = "activation";
            this.cfw.addALoad((int)this.funObjLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.argsLocal);
            if (this.fnCurrent.fnode instanceof DecoratorDeclarationNode) {
                this.cfw.addPush(3);
                this.cfw.add(50);
                this.cfw.add(192, "[Ljava/lang/Object;");
            }
            final boolean spread = this.fnCurrent.fnode.getParams().stream().anyMatch(param -> param.getProp(29) != null);
            if (spread) {
                this.cfw.addPush(this.fnCurrent.fnode.getParams().size() - 1);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("paramsToRestParams", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "I", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
            }
            final int paramCount2 = this.fnCurrent.fnode.getParamCount();
            final Map<Integer, Node> defaultParams2 = (Map<Integer, Node>)this.fnCurrent.fnode.getDefaultParams();
            if (!defaultParams2.isEmpty()) {
                int max = -1;
                for (final int key : defaultParams2.keySet()) {
                    if (key > max) {
                        max = key;
                    }
                }
                this.cfw.add(89);
                this.cfw.addPush(max + 1);
                this.addScriptRuntimeInvoke("lengthenObjArray", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "I");
                final int array = this.getNewWordLocal();
                this.cfw.addAStore(array);
                for (int l = 0; l < paramCount2; ++l) {
                    if (defaultParams2.containsKey(l)) {
                        final int label3 = this.cfw.acquireLabel();
                        this.cfw.addALoad(array);
                        this.cfw.addPush(l);
                        this.cfw.add(50);
                        this.cfw.addInvoke(184, "org/mozilla/javascript/Undefined", "isUndefined", "(Ljava/lang/Object;)Z");
                        this.cfw.add(153, label3);
                        if (defaultParams2.get(l).getType() == 53) {
                            this.generateExpression(defaultParams2.get(l), (Node)this.fnCurrent.fnode);
                        }
                        else {
                            this.cfw.addALoad(array);
                            this.cfw.addPush(l);
                            this.generateExpression(defaultParams2.get(l), (Node)this.fnCurrent.fnode);
                            this.cfw.add(83);
                        }
                        this.cfw.markLabel(label3);
                    }
                }
                this.cfw.addALoad(array);
                this.cfw.addPush(this.scriptOrFn.isInStrictMode());
                this.cfw.addPush(false);
                this.addScriptRuntimeInvoke(methodName, "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "Z", "Z");
            }
            else {
                final boolean hasDefaults = this.fnCurrent.fnode.getParams().stream().anyMatch(ast -> ast.getType() == 69);
                this.cfw.addPush(this.scriptOrFn.isInStrictMode());
                this.cfw.addPush(!hasDefaults && !this.scriptOrFn.hasRest());
                this.addScriptRuntimeInvoke(methodName, "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "Z", "Z");
            }
            this.cfw.addAStore((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.addScriptRuntimeInvoke("enterActivationFunction", "V", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
        }
        else {
            debugVariableName = "global";
            this.cfw.addALoad((int)this.funObjLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.addScriptRuntimeInvoke("initScript", "V", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
        }
        this.enterAreaStartLabel = this.cfw.acquireLabel();
        this.epilogueLabel = this.cfw.acquireLabel();
        this.cfw.markLabel(this.enterAreaStartLabel);
        this.generateNestedFunctionInits();
        if (this.compilerEnv.isGenerateDebugInfo()) {
            this.cfw.addVariableDescriptor(debugVariableName, "Lorg/mozilla/javascript/Scriptable;", this.cfw.getCurrentCodeOffset(), (int)this.variableObjectLocal);
        }
        if (this.fnCurrent == null) {
            this.popvLocal = this.getNewWordLocal();
            Codegen.pushUndefined(this.cfw);
            this.cfw.addAStore((int)this.popvLocal);
            final int linenum = this.scriptOrFn.getEndLineno();
            if (linenum != -1) {
                this.cfw.addLineNumberEntry((short)linenum);
            }
        }
        else {
            if (this.fnCurrent.itsContainsCalls0) {
                this.itsZeroArgArray = this.getNewWordLocal();
                this.cfw.add(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
                this.cfw.addAStore((int)this.itsZeroArgArray);
            }
            if (this.fnCurrent.itsContainsCalls1) {
                this.itsOneArgArray = this.getNewWordLocal();
                this.cfw.addPush(1);
                this.cfw.add(189, "java/lang/Object");
                this.cfw.addAStore((int)this.itsOneArgArray);
            }
        }
    }
    
    private void generateGetGeneratorResumptionPoint() {
        this.cfw.addALoad((int)this.generatorStateLocal);
        this.cfw.add(180, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }
    
    private void generateSetGeneratorResumptionPoint(final int nextState) {
        this.cfw.addALoad((int)this.generatorStateLocal);
        this.cfw.addLoadConstant(nextState);
        this.cfw.add(181, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }
    
    private void generateGenGetStack() {
        this.cfw.addALoad((int)this.generatorStateLocal);
        this.addOptRuntimeInvoke("getGeneratorStackState", "[Ljava/lang/Object;", "Ljava/lang/Object;");
    }
    
    private void generateEpilogue() {
        if (this.compilerEnv.isGenerateObserverCount()) {
            this.addInstructionCount();
        }
        if (this.isGenerator) {
            final Map<Node, int[]> liveLocals = (Map<Node, int[]>)((FunctionNode)this.scriptOrFn).getLiveLocals();
            if (liveLocals != null) {
                final List<Node> nodes = (List<Node>)((FunctionNode)this.scriptOrFn).getResumptionPoints();
                for (int i = 0; i < nodes.size(); ++i) {
                    final Node node = nodes.get(i);
                    final int[] live = liveLocals.get(node);
                    if (live != null) {
                        this.cfw.markTableSwitchCase(this.generatorSwitch, this.getNextGeneratorState(node));
                        this.generateGetGeneratorLocalsState();
                        for (int j = 0; j < live.length; ++j) {
                            this.cfw.add(89);
                            this.cfw.addLoadConstant(j);
                            this.cfw.add(50);
                            this.cfw.addAStore(live[j]);
                        }
                        this.cfw.add(87);
                        this.cfw.add(167, this.getTargetLabel(node));
                    }
                }
            }
            if (this.finallys != null) {
                for (final Node n : this.finallys.keySet()) {
                    if (n.getType() == 134) {
                        final FinallyReturnPoint ret = this.finallys.get(n);
                        this.cfw.markLabel(ret.tableLabel, (short)1);
                        final int startSwitch = this.cfw.addTableSwitch(0, ret.jsrPoints.size() - 1);
                        int c = 0;
                        this.cfw.markTableSwitchDefault(startSwitch);
                        for (int k = 0; k < ret.jsrPoints.size(); ++k) {
                            this.cfw.markTableSwitchCase(startSwitch, c);
                            this.cfw.add(167, (int)ret.jsrPoints.get(k));
                            ++c;
                        }
                    }
                }
            }
        }
        if (this.epilogueLabel != -1) {
            this.cfw.markLabel(this.epilogueLabel);
        }
        if (this.hasVarsInRegs && !this.isGenerator) {
            if (this.currentCtorClass) {
                this.addScriptRuntimeInvoke("endClassCtor", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;");
            }
            this.cfw.add(176);
        }
        else if (this.isGenerator) {
            final int state = ((FunctionNode)this.scriptOrFn).getResumptionPoints().size();
            this.generateGeneratorReturnObject(this.generatorReturnNode, true);
            this.generateSetGeneratorResumptionPoint(state + 1);
            this.cfw.add(176);
            this.generateCheckForThrowOrClose(-1, false, null);
            this.generateGeneratorReturnObject((Node)null, true);
            this.generateSetGeneratorResumptionPoint(-1);
            this.cfw.add(176);
        }
        else if (this.fnCurrent == null) {
            this.cfw.addALoad((int)this.popvLocal);
            this.cfw.add(176);
        }
        else {
            this.generateActivationExit();
            this.cfw.add(176);
            final int finallyHandler = this.cfw.acquireLabel();
            this.cfw.markHandler(finallyHandler);
            final short exceptionObject = this.getNewWordLocal();
            this.cfw.addAStore((int)exceptionObject);
            this.generateActivationExit();
            this.cfw.addALoad((int)exceptionObject);
            this.releaseWordLocal(exceptionObject);
            this.cfw.add(191);
            this.cfw.addExceptionHandler(this.enterAreaStartLabel, this.epilogueLabel, finallyHandler, (String)null);
        }
    }
    
    private void generateGeneratorReturnObject(final Runnable value, final boolean isDone) {
        this.cfw.addPush(2);
        this.cfw.add(189, "java/lang/Object");
        this.cfw.add(89);
        this.cfw.addPush(0);
        this.cfw.addPush("value");
        this.cfw.add(83);
        this.cfw.add(89);
        this.cfw.addPush(1);
        this.cfw.addPush("done");
        this.cfw.add(83);
        this.cfw.addPush(2);
        this.cfw.add(189, "java/lang/Object");
        this.cfw.add(89);
        this.cfw.addPush(0);
        value.run();
        this.cfw.add(83);
        this.cfw.add(89);
        this.cfw.addPush(1);
        if (isDone) {
            this.cfw.add(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        }
        else {
            this.cfw.add(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        }
        this.cfw.add(83);
        this.cfw.add(1);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.addScriptRuntimeInvoke("newObjectLiteral", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "[I", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
    }
    
    private void generateGeneratorReturnObject(final Node node, final boolean isDone) {
        final Node returnVal;
        this.generateGeneratorReturnObject(() -> {
            returnVal = ((node == null) ? null : node.getFirstChild());
            if (returnVal == null) {
                Codegen.pushUndefined(this.cfw);
            }
            else {
                this.generateExpression(returnVal, node);
            }
        }, isDone);
    }
    
    private void generateGetGeneratorLocalsState() {
        this.cfw.addALoad((int)this.generatorStateLocal);
        this.addOptRuntimeInvoke("getGeneratorLocalsState", "[Ljava/lang/Object;", "Ljava/lang/Object;");
    }
    
    private void generateActivationExit() {
        if (this.fnCurrent == null || this.hasVarsInRegs) {
            throw Kit.codeBug();
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.addScriptRuntimeInvoke("exitActivationFunction", "V", "Lorg/mozilla/javascript/Context;");
    }
    
    private void generateStatement(final Node node) {
        this.updateLineNumber(node);
        final int type = node.getType();
        Node child = node.getFirstChild();
        switch (type) {
            case 132:
            case 138:
            case 139:
            case 140:
            case 142:
            case 146: {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount(1);
                }
                while (child != null) {
                    this.generateStatement(child);
                    child = child.getNext();
                }
                break;
            }
            case 151: {
                final boolean prevLocal = this.inLocalBlock;
                this.inLocalBlock = true;
                final int local = this.getNewWordLocal();
                if (this.isGenerator) {
                    this.cfw.add(1);
                    this.cfw.addAStore(local);
                }
                node.putIntProp(2, local);
                while (child != null) {
                    this.generateStatement(child);
                    child = child.getNext();
                }
                this.releaseWordLocal((short)local);
                node.removeProp(2);
                this.inLocalBlock = prevLocal;
                break;
            }
            case 119: {
                final ExportNode en = (ExportNode)node;
                if (en.isDefaultExport()) {
                    this.generateExpression(en.getFirstChild(), (Node)en);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke("handleExport", "V", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;");
                    break;
                }
                if (en.getExportedValue() != null) {
                    final AstNode ast = en.getExportedValue();
                    final String identifier = en.getIdentifier();
                    final Node value = en.getFirstChild();
                    if (!(ast instanceof VariableDeclaration) && identifier == null) {
                        throw Codegen.badTree();
                    }
                    this.generateStatement(value);
                    if (ast instanceof VariableDeclaration) {
                        final List<VariableInitializer> variables = (List<VariableInitializer>)((VariableDeclaration)ast).getVariables();
                        final AstNode name;
                        variables.forEach(var -> {
                            name = var.getTarget();
                            if (!(name instanceof Name)) {
                                throw Codegen.badTree();
                            }
                            else {
                                this.cfw.addPush(((Name)name).getIdentifier());
                                this.cfw.add(89);
                                this.cfw.addALoad((int)this.variableObjectLocal);
                                this.addScriptRuntimeInvoke("handleExport", "V", "Ljava/lang/String;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Scriptable;");
                                return;
                            }
                        });
                        break;
                    }
                    this.cfw.addPush(identifier);
                    this.cfw.add(89);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke("handleExport", "V", "Ljava/lang/String;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Scriptable;");
                    break;
                }
                else {
                    final String filePath = en.getFilePath();
                    if (filePath != null && en.getNamedMembers().size() == 0) {
                        this.generateRequireCall(filePath);
                        this.cfw.add(192, "org/mozilla/javascript/Scriptable");
                        this.cfw.addALoad((int)this.variableObjectLocal);
                        this.addScriptRuntimeInvoke("handleExport", "V", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;");
                        break;
                    }
                    for (final ImportNode.ModuleMember namedImport : en.getNamedMembers()) {
                        final String target = namedImport.getTargetName();
                        String scope = namedImport.getScopeName();
                        if (scope == null) {
                            scope = target;
                        }
                        this.cfw.addPush(target);
                        this.cfw.addPush(scope);
                        if (filePath != null) {
                            this.generateRequireCall(filePath);
                        }
                        this.cfw.addALoad((int)this.variableObjectLocal);
                        if (filePath == null) {
                            this.addScriptRuntimeInvoke("handleExport", "V", "Ljava/lang/String;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Scriptable;");
                        }
                        else {
                            this.addScriptRuntimeInvoke("handleExport", "V", "Ljava/lang/String;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;");
                        }
                    }
                    break;
                }
                break;
            }
            case 120: {
                final ImportNode in = (ImportNode)node;
                this.generateRequireCall(in.getFilePath());
                final int namedCount = in.getNamedMembers().size();
                this.cfw.addPush(namedCount);
                this.cfw.add(189, "java/lang/Object");
                final List<ImportNode.ModuleMember> namedImports = (List<ImportNode.ModuleMember>)in.getNamedMembers();
                for (int i = 0, namedImportsSize = namedImports.size(); i < namedImportsSize; ++i) {
                    final ImportNode.ModuleMember namedImport2 = namedImports.get(i);
                    this.cfw.add(89);
                    this.cfw.addPush(i);
                    this.cfw.addPush(2);
                    this.cfw.add(189, "java/lang/String");
                    this.cfw.add(89);
                    this.cfw.addPush(0);
                    final String target2 = namedImport2.getTargetName();
                    this.cfw.addPush(target2);
                    this.cfw.add(83);
                    this.cfw.add(89);
                    this.cfw.addPush(1);
                    String scope2 = namedImport2.getScopeName();
                    if (scope2 == null) {
                        scope2 = target2;
                    }
                    this.cfw.addPush(scope2);
                    this.cfw.add(83);
                    this.cfw.add(83);
                }
                final ImportNode.ModuleMember defaultImport = in.getDefaultMember();
                if (defaultImport == null) {
                    this.cfw.add(1);
                }
                else {
                    this.cfw.addPush(defaultImport.getScopeName());
                }
                final ImportNode.ModuleMember moduleImport = in.getModuleImport();
                if (moduleImport == null) {
                    this.cfw.add(1);
                }
                else {
                    this.cfw.addPush(moduleImport.getScopeName());
                }
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("handleImport", "V", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Ljava/lang/String;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Scriptable;");
                break;
            }
            case 135: {
                if (this.fnCurrent != null) {
                    this.visitDecoratorDeclaration((DecoratorDeclarationNode)node);
                    break;
                }
                break;
            }
            case 114: {
                final int fnIndex = node.getExistingIntProp(1);
                final OptFunctionNode ofn = OptFunctionNode.get(this.scriptOrFn, fnIndex);
                final int t = ofn.fnode.getFunctionType();
                if (t == 3 || node.getProp(33) != null) {
                    this.visitFunction(ofn, t);
                    break;
                }
                if (t != 1) {
                    throw Codegen.badTree();
                }
                break;
            }
            case 115: {
                this.visitClass((ClassNode)node);
                break;
            }
            case 78: {
                this.visitTryCatchFinally((Jump)node, child);
                break;
            }
            case 60: {
                this.cfw.setStackTop((short)0);
                final int local2 = this.getLocalBlockRegister(node);
                final int scopeIndex = node.getExistingIntProp(14);
                final String name2 = child.getString();
                child = child.getNext();
                this.generateExpression(child, node);
                if (scopeIndex == 0) {
                    this.cfw.add(1);
                }
                else {
                    this.cfw.addALoad(local2);
                }
                this.cfw.addPush(name2);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("newCatchScope", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Throwable;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                this.cfw.addAStore(local2);
                break;
            }
            case 53: {
                this.generateExpression(child, node);
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount();
                }
                this.generateThrowJavaScriptException();
                break;
            }
            case 54: {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount();
                }
                this.cfw.addALoad(this.getLocalBlockRegister(node));
                this.cfw.add(191);
                break;
            }
            case 4:
            case 68: {
                if (!this.isGenerator) {
                    if (child != null) {
                        this.generateExpression(child, node);
                        if (this.currentCtorClass) {
                            this.cfw.addALoad((int)this.thisObjLocal);
                            this.addScriptRuntimeInvoke("coerceClassCtorReturnValue", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;");
                        }
                    }
                    else if (type == 4) {
                        if (!this.currentCtorClass) {
                            Codegen.pushUndefined(this.cfw);
                        }
                        else {
                            this.cfw.addALoad((int)this.thisObjLocal);
                        }
                    }
                    else {
                        if (this.popvLocal < 0) {
                            throw Codegen.badTree();
                        }
                        this.cfw.addALoad((int)this.popvLocal);
                    }
                }
                this.generatorReturnNode = node;
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount();
                }
                if (this.epilogueLabel == -1) {
                    if (!this.hasVarsInRegs) {
                        throw Codegen.badTree();
                    }
                    this.epilogueLabel = this.cfw.acquireLabel();
                }
                this.cfw.add(167, this.epilogueLabel);
                break;
            }
            case 123: {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount();
                }
                this.visitSwitch((Jump)node, child);
                break;
            }
            case 2: {
                this.generateExpression(child, node);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("enterWith", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                this.cfw.addAStore((int)this.variableObjectLocal);
                this.incReferenceWordLocal(this.variableObjectLocal);
                break;
            }
            case 3: {
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("leaveWith", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;");
                this.cfw.addAStore((int)this.variableObjectLocal);
                this.decReferenceWordLocal(this.variableObjectLocal);
                break;
            }
            case 61:
            case 62:
            case 63:
            case 64: {
                this.generateExpression(child, node);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                final int enumType = (type == 61) ? 0 : ((type == 62) ? 1 : ((type == 64) ? 6 : 2));
                this.cfw.addPush(enumType);
                this.addScriptRuntimeInvoke("enumInit", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "I");
                this.cfw.addAStore(this.getLocalBlockRegister(node));
                break;
            }
            case 143: {
                if (child.getType() == 59) {
                    this.visitSetVar(child, child.getFirstChild(), false);
                    break;
                }
                if (child.getType() == 161) {
                    this.visitSetConstVar(child, child.getFirstChild(), false);
                    break;
                }
                if (child.getType() == 76) {
                    this.generateYieldPoint(child, false);
                    break;
                }
                this.generateExpression(child, node);
                if (node.getIntProp(8, -1) != -1) {
                    this.cfw.add(88);
                    break;
                }
                this.cfw.add(87);
                break;
            }
            case 144: {
                this.generateExpression(child, node);
                if (this.popvLocal < 0) {
                    this.popvLocal = this.getNewWordLocal();
                }
                this.cfw.addAStore((int)this.popvLocal);
                break;
            }
            case 141: {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount();
                }
                final int label = this.getTargetLabel(node);
                this.cfw.markLabel(label);
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.saveCurrentCodeOffset();
                }
                break;
            }
            case 5:
            case 6:
            case 7:
            case 145: {
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.addInstructionCount();
                }
                this.visitGoto((Jump)node, type, child);
                break;
            }
            case 134: {
                if (!this.isGenerator) {
                    break;
                }
                if (this.compilerEnv.isGenerateObserverCount()) {
                    this.saveCurrentCodeOffset();
                }
                this.cfw.setStackTop((short)1);
                final int finallyRegister = this.getNewWordLocal();
                final int finallyStart = this.cfw.acquireLabel();
                final int finallyEnd = this.cfw.acquireLabel();
                this.cfw.markLabel(finallyStart);
                this.generateIntegerWrap();
                this.cfw.addAStore(finallyRegister);
                while (child != null) {
                    this.generateStatement(child);
                    child = child.getNext();
                }
                this.cfw.addALoad(finallyRegister);
                this.cfw.add(192, "java/lang/Integer");
                this.generateIntegerUnwrap();
                final FinallyReturnPoint ret = this.finallys.get(node);
                ret.tableLabel = this.cfw.acquireLabel();
                this.cfw.add(167, ret.tableLabel);
                this.cfw.setStackTop((short)0);
                this.releaseWordLocal((short)finallyRegister);
                this.cfw.markLabel(finallyEnd);
                break;
            }
            case 165: {
                break;
            }
            default: {
                throw Codegen.badTree();
            }
        }
    }
    
    private void generateIntegerWrap() {
        this.cfw.addInvoke(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    }
    
    private void generateIntegerUnwrap() {
        this.cfw.addInvoke(182, "java/lang/Integer", "intValue", "()I");
    }
    
    private void generateBooleanWrap() {
        this.cfw.addInvoke(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
    }
    
    private void generateThrowJavaScriptException() {
        this.cfw.add(187, "org/mozilla/javascript/JavaScriptException");
        this.cfw.add(90);
        this.cfw.add(95);
        this.cfw.addPush(this.scriptOrFn.getSourceName());
        this.cfw.addPush(this.itsLineNumber);
        this.cfw.addInvoke(183, "org/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
        this.cfw.add(191);
    }
    
    private void generateParameterTDZChecks(final List<AstNode> params, final Map<Integer, Node> defaultParams) {
        final int paramsSize = params.size();
        for (final Map.Entry<Integer, Node> en : defaultParams.entrySet()) {
            final int paramIndex = en.getKey();
            final Node defaultParam = en.getValue();
            for (int i = paramIndex; i < paramsSize; ++i) {
                final AstNode param = params.get(i);
                if (Name.sameIdentifier((Node)param, defaultParam)) {
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.cfw.addPush("ReferenceError");
                    this.cfw.addPush("can't access lexical declaration '" + ((Name)defaultParam).getIdentifier() + "' before initialization");
                    this.addScriptRuntimeInvoke("throwCustomError", "Lorg/mozilla/javascript/JavaScriptException;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;", "Ljava/lang/String;");
                    this.cfw.add(191);
                }
            }
        }
    }
    
    private int getNextGeneratorState(final Node node) {
        final int nodeIndex = ((FunctionNode)this.scriptOrFn).getResumptionPoints().indexOf(node);
        return nodeIndex + 1;
    }
    
    private void generateExpression(final Node node, final Node parent) {
        final int type = node.getType();
        Node child = node.getFirstChild();
        Label_4196: {
            switch (type) {
                case 148: {
                    break;
                }
                case 53: {
                    this.generateExpression(child, node);
                    if (this.compilerEnv.isGenerateObserverCount()) {
                        this.addInstructionCount();
                    }
                    this.generateThrowJavaScriptException();
                    Codegen.pushUndefined(this.cfw);
                    break;
                }
                case 114: {
                    if (this.fnCurrent == null && parent.getType() == 146) {
                        break;
                    }
                    final int fnIndex = node.getExistingIntProp(1);
                    final OptFunctionNode ofn = OptFunctionNode.get(this.scriptOrFn, fnIndex);
                    final int t = ofn.fnode.getFunctionType();
                    if (t != 2 && t != 4) {
                        throw Codegen.badTree();
                    }
                    this.visitFunction(ofn, t);
                    break;
                }
                case 115: {
                    this.visitClass((ClassNode)node);
                    break;
                }
                case 40: {
                    if (node.getString().equals("new.target") && this.scriptOrFn.getType() == 114) {
                        this.cfw.addLoadThis();
                        this.cfw.addALoad((int)this.thisObjLocal);
                        this.addScriptRuntimeInvoke("getNewTarget", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;");
                        break;
                    }
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.cfw.addPush(node.getString());
                    this.addScriptRuntimeInvoke("name", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
                    break;
                }
                case 31:
                case 39: {
                    final int specialType = node.getIntProp(10, 0);
                    if (specialType == 0) {
                        final OptFunctionNode target = (OptFunctionNode)node.getProp(9);
                        if (target != null) {
                            this.visitOptimizedCall(node, target, type, child);
                        }
                        else if (type == 39) {
                            this.visitStandardCall(node, child);
                        }
                        else {
                            this.visitStandardNew(node, child);
                        }
                        break;
                    }
                    this.visitSpecialCall(node, type, specialType, child);
                    break;
                }
                case 74: {
                    this.generateFunctionAndThisObj(child, node);
                    child = child.getNext();
                    this.generateCallArgArray(node, child, false);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.addScriptRuntimeInvoke("callRef", "Lorg/mozilla/javascript/Ref;", "Lorg/mozilla/javascript/Callable;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;");
                    break;
                }
                case 41: {
                    final double num = node.getDouble();
                    if (node.getIntProp(8, -1) != -1) {
                        this.cfw.addPush(num);
                    }
                    else {
                        this.codegen.pushNumberAsObject(this.cfw, num);
                    }
                    final DecoratorNode dn = ((NumberLiteral)node).getDecoratorNode();
                    if (dn != null) {
                        final List<DecoratorNode> dnList = new ArrayList<DecoratorNode>();
                        dnList.add(dn);
                        this.generateApplyDecorator(node, dnList, DecoratorType.NUMERICTEMPLATE);
                        break;
                    }
                    break;
                }
                case 43: {
                    final TemplateLiteral lit = (TemplateLiteral)node;
                    final Node target2 = lit.getTransformedTarget();
                    if (target2 == null) {
                        this.cfw.addPush(lit.getElements().size());
                        this.cfw.add(189, "java/lang/Object");
                        int index = 0;
                        for (final Node element : node) {
                            this.cfw.add(89);
                            this.cfw.addPush(index);
                            this.generateExpression(element, node);
                            this.cfw.add(83);
                            ++index;
                        }
                        this.addScriptRuntimeInvoke("templateConcat", "Ljava/lang/Object;", "[Ljava/lang/Object;");
                        break;
                    }
                    this.cfw.addPush(lit.getElements().size());
                    this.cfw.add(189, "java/lang/Object");
                    int arrayIndex = 0;
                    final List<Node> exprs = new ArrayList<Node>();
                    int i = 0;
                    for (final Node element2 : lit) {
                        if (lit.isExpr(i)) {
                            exprs.add(element2);
                        }
                        else {
                            this.cfw.add(89);
                            this.cfw.addPush(arrayIndex++);
                            this.generateExpression(element2, node);
                            this.cfw.add(83);
                        }
                        ++i;
                    }
                    final int boundary = arrayIndex;
                    for (final Node element3 : exprs) {
                        this.cfw.add(89);
                        this.cfw.addPush(arrayIndex++);
                        this.generateExpression(element3, node);
                        this.cfw.add(83);
                    }
                    this.cfw.addPush(boundary);
                    final String[] rawStrings = lit.getRawElements();
                    this.cfw.addPush(rawStrings.length);
                    this.cfw.add(189, "java/lang/Object");
                    for (int i2 = 0, rawStringsLength = rawStrings.length; i2 < rawStringsLength; ++i2) {
                        final String rawString = rawStrings[i2];
                        this.cfw.add(89);
                        this.cfw.addPush(i2);
                        this.cfw.addPush(rawString);
                        this.cfw.add(83);
                    }
                    this.generateExpression(target2, node);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.cfw.addALoad((int)this.thisObjLocal);
                    final ClassFileWriter.MHandle bootstrap = new ClassFileWriter.MHandle((byte)6, "org/mozilla/javascript/optimizer/InvokeDynamicSupport", "bootstrapCallWithTemplateLiteral", MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class).toMethodDescriptorString());
                    this.cfw.addInvokeDynamic("callWithTemplateLiteral", "([Ljava/lang/Object;I[Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", bootstrap, new Object[0]);
                    break;
                }
                case 42: {
                    this.cfw.addPush(node.getString());
                    break;
                }
                case 46: {
                    this.cfw.addALoad((int)this.thisObjLocal);
                    break;
                }
                case 67: {
                    this.cfw.add(42);
                    break;
                }
                case 45: {
                    this.cfw.add(1);
                    break;
                }
                case 48: {
                    this.cfw.add(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
                    break;
                }
                case 47: {
                    this.cfw.add(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
                    break;
                }
                case 51: {
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    final int j = node.getExistingIntProp(4);
                    this.cfw.add(178, this.codegen.mainClassName, this.codegen.getCompiledRegexpName(this.scriptOrFn, j), "Ljava/lang/Object;");
                    this.cfw.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "wrapRegExp", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
                    break;
                }
                case 86: {
                    for (Node next = child.getNext(); next != null; next = next.getNext()) {
                        this.generateExpression(child, node);
                        this.cfw.add(87);
                        child = next;
                    }
                    this.generateExpression(child, node);
                    break;
                }
                case 65:
                case 66: {
                    final int local = this.getLocalBlockRegister(node);
                    this.cfw.addALoad(local);
                    if (type == 65) {
                        this.addScriptRuntimeInvoke("enumNext", "Ljava/lang/Boolean;", "Ljava/lang/Object;");
                        break;
                    }
                    this.cfw.addALoad((int)this.contextLocal);
                    this.addScriptRuntimeInvoke("enumId", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;");
                    break;
                }
                case 69: {
                    this.visitArrayLiteral(node, child, false);
                    break;
                }
                case 70: {
                    this.visitObjectLiteral(node, child, false);
                    break;
                }
                case 136: {
                    this.generateExpression(child, node);
                    this.cfw.add(87);
                    Codegen.pushUndefined(this.cfw);
                    break;
                }
                case 33: {
                    this.generateExpression(child, node);
                    this.addScriptRuntimeInvoke("typeof", "Ljava/lang/String;", "Ljava/lang/Object;");
                    break;
                }
                case 147: {
                    this.visitTypeofname(node);
                    break;
                }
                case 107:
                case 108: {
                    this.visitIncDec(node);
                    break;
                }
                case 105:
                case 106: {
                    this.generateExpression(child, node);
                    this.cfw.add(89);
                    this.addScriptRuntimeInvoke("toBoolean", "Z", "Ljava/lang/Object;");
                    final int falseTarget = this.cfw.acquireLabel();
                    if (type == 106) {
                        this.cfw.add(153, falseTarget);
                    }
                    else {
                        this.cfw.add(154, falseTarget);
                    }
                    this.cfw.add(87);
                    this.generateExpression(child.getNext(), node);
                    this.cfw.markLabel(falseTarget);
                    break;
                }
                case 103: {
                    final Node ifThen = child.getNext();
                    final Node ifElse = ifThen.getNext();
                    this.generateExpression(child, node);
                    this.addScriptRuntimeInvoke("toBoolean", "Z", "Ljava/lang/Object;");
                    final int elseTarget = this.cfw.acquireLabel();
                    this.cfw.add(153, elseTarget);
                    final short stack = this.cfw.getStackTop();
                    this.generateExpression(ifThen, node);
                    final int afterHook = this.cfw.acquireLabel();
                    this.cfw.add(167, afterHook);
                    this.cfw.markLabel(elseTarget, stack);
                    this.generateExpression(ifElse, node);
                    this.cfw.markLabel(afterHook);
                    break;
                }
                case 21: {
                    this.generateExpression(child, node);
                    this.generateExpression(child.getNext(), node);
                    switch (node.getIntProp(8, -1)) {
                        case 0: {
                            this.cfw.add(99);
                            break Label_4196;
                        }
                        case 1: {
                            this.addOptRuntimeInvoke("add", "Ljava/lang/Object;", "D", "Ljava/lang/Object;");
                            break Label_4196;
                        }
                        case 2: {
                            this.addOptRuntimeInvoke("add", "Ljava/lang/Object;", "Ljava/lang/Object;", "D");
                            break Label_4196;
                        }
                        default: {
                            if (child.getType() == 42) {
                                this.addScriptRuntimeInvoke("add", "Ljava/lang/CharSequence;", "Ljava/lang/CharSequence;", "Ljava/lang/Object;");
                                break Label_4196;
                            }
                            if (child.getNext().getType() == 42) {
                                this.addScriptRuntimeInvoke("add", "Ljava/lang/CharSequence;", "Ljava/lang/Object;", "Ljava/lang/CharSequence;");
                                break Label_4196;
                            }
                            this.cfw.addALoad((int)this.contextLocal);
                            this.addScriptRuntimeInvoke("add", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;");
                            break Label_4196;
                        }
                    }
                    break;
                }
                case 9:
                case 10:
                case 11:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30: {
                    this.visitOperator(node, child, type);
                    break;
                }
                case 155: {
                    this.generateExpression(child, node);
                    this.addObjectToDouble();
                    break;
                }
                case 154: {
                    int prop = -1;
                    if (child.getType() == 41) {
                        prop = child.getIntProp(8, -1);
                    }
                    if (prop != -1) {
                        child.removeProp(8);
                        this.generateExpression(child, node);
                        child.putIntProp(8, prop);
                        break;
                    }
                    this.generateExpression(child, node);
                    this.addDoubleWrap();
                    break;
                }
                case 55:
                case 56: {
                    final int trueGOTO = this.cfw.acquireLabel();
                    final int falseGOTO = this.cfw.acquireLabel();
                    this.visitIfJumpRelOp(node, child, trueGOTO, falseGOTO);
                    this.addJumpedBooleanWrap(trueGOTO, falseGOTO);
                    break;
                }
                case 12:
                case 13:
                case 49:
                case 50: {
                    final int trueGOTO = this.cfw.acquireLabel();
                    final int falseGOTO = this.cfw.acquireLabel();
                    this.visitIfJumpEqOp(node, child, trueGOTO, falseGOTO);
                    this.addJumpedBooleanWrap(trueGOTO, falseGOTO);
                    break;
                }
                case 34:
                case 35: {
                    this.visitGetProp(node, child);
                    break;
                }
                case 37: {
                    final Object spread = node.getProp(29);
                    if (child.getProp(31) != null) {
                        this.generateExpression(child.getNext(), node);
                        this.cfw.addALoad((int)this.thisObjLocal);
                        this.cfw.addALoad((int)this.funObjLocal);
                        this.addScriptRuntimeInvoke("accessSuper", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;");
                        return;
                    }
                    if (spread != null) {
                        final int startIndex = (int)((Object[])spread)[0];
                        final Node right = (Node)((Object[])spread)[1];
                        this.cfw.addALoad((int)this.contextLocal);
                        this.cfw.addALoad((int)this.variableObjectLocal);
                        this.cfw.addPush(startIndex);
                        this.generateExpression(right, node);
                        this.addScriptRuntimeInvoke("handleRestDestructure", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "I", "Ljava/lang/Object;");
                        break;
                    }
                    this.generateExpression(child, node);
                    this.generateExpression(child.getNext(), node);
                    this.cfw.addALoad((int)this.contextLocal);
                    final String prefix = (node.getProp(30) != null) ? "optionalGet" : "get";
                    if (node.getIntProp(8, -1) != -1) {
                        this.addScriptRuntimeInvoke(prefix + "ObjectIndex", "Ljava/lang/Object;", "Ljava/lang/Object;", "D", "Lorg/mozilla/javascript/Context;");
                        break;
                    }
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke(prefix + "ObjectElem", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                    break;
                }
                case 110: {
                    final Object[] alreadyTaken = (Object[])node.getProp(32);
                    if (alreadyTaken == null) {
                        throw new RuntimeException("Unexpected Token.SPREAD without spread_ids");
                    }
                    this.generateExpression(child, node);
                    this.addNewObjectArray(alreadyTaken.length);
                    for (int k = 0; k < alreadyTaken.length; ++k) {
                        final Object taken = alreadyTaken[k];
                        this.cfw.add(89);
                        this.cfw.addPush(k);
                        if (taken instanceof String) {
                            this.cfw.addPush((String)taken);
                        }
                        else {
                            if (!(taken instanceof Integer)) {
                                throw new RuntimeException("Unknown constant: " + taken);
                            }
                            this.cfw.addPush((int)taken);
                        }
                        this.cfw.add(83);
                    }
                    this.addScriptRuntimeInvoke("handleObjectRest", "Ljava/lang/Object;", "Ljava/lang/Object;", "[Ljava/lang/Object;");
                    break;
                }
                case 71: {
                    this.generateExpression(child, node);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.addScriptRuntimeInvoke("refGet", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Ref;", "Lorg/mozilla/javascript/Context;");
                    break;
                }
                case 58: {
                    this.visitGetVar(node);
                    break;
                }
                case 59: {
                    this.visitSetVar(node, child, true);
                    break;
                }
                case 8: {
                    this.visitSetName(node, child);
                    break;
                }
                case 77: {
                    this.visitStrictSetName(node, child);
                    break;
                }
                case 160: {
                    this.visitSetConst(node, child);
                    break;
                }
                case 161: {
                    this.visitSetConstVar(node, child, true);
                    break;
                }
                case 36:
                case 149: {
                    this.visitSetProp(type, node, child);
                    break;
                }
                case 38:
                case 150: {
                    this.visitSetElem(type, node, child);
                    break;
                }
                case 72:
                case 152: {
                    this.generateExpression(child, node);
                    child = child.getNext();
                    if (type == 152) {
                        this.cfw.add(89);
                        this.cfw.addALoad((int)this.contextLocal);
                        this.addScriptRuntimeInvoke("refGet", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Ref;", "Lorg/mozilla/javascript/Context;");
                    }
                    this.generateExpression(child, node);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke("refSet", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Ref;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                    break;
                }
                case 73: {
                    this.generateExpression(child, node);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.addScriptRuntimeInvoke("refDel", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Ref;", "Lorg/mozilla/javascript/Context;");
                    break;
                }
                case 32: {
                    final boolean isName = child.getType() == 52;
                    this.generateExpression(child, node);
                    child = child.getNext();
                    this.generateExpression(child, node);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addPush(isName);
                    this.addScriptRuntimeInvoke("delete", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Z");
                    break;
                }
                case 52: {
                    while (child != null) {
                        this.generateExpression(child, node);
                        child = child.getNext();
                    }
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.cfw.addPush(node.getString());
                    this.addScriptRuntimeInvoke("bind", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
                    break;
                }
                case 57: {
                    this.cfw.addALoad(this.getLocalBlockRegister(node));
                    break;
                }
                case 75: {
                    final String special = (String)node.getProp(17);
                    this.generateExpression(child, node);
                    this.cfw.addPush(special);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke("specialRef", "Lorg/mozilla/javascript/Ref;", "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                    break;
                }
                case 76: {
                    this.generateYieldPoint(node, true);
                    break;
                }
                case 164: {
                    final Node with = child.getNext();
                    final Node leaveWith = with.getNext();
                    this.generateStatement(child);
                    this.generateExpression(with.getFirstChild(), with);
                    this.generateStatement(leaveWith);
                    break;
                }
                case 162: {
                    final Node expr = child.getNext();
                    this.generateStatement(child);
                    this.generateExpression(expr, node);
                    break;
                }
                case 125: {
                    this.generateExpression(child, node);
                    this.generateExpression(child.getNext(), node);
                    this.addScriptRuntimeInvoke("mixDefaultArgument", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;");
                    break;
                }
                case 113: {
                    final int endOfIf = this.cfw.acquireLabel();
                    this.generateExpression(child, node);
                    this.cfw.add(89);
                    this.addScriptRuntimeInvoke("isNullOrUndefined", "Z", "Ljava/lang/Object;");
                    this.cfw.add(153, endOfIf);
                    this.cfw.add(87);
                    this.generateExpression(child.getNext(), node);
                    this.cfw.markLabel(endOfIf);
                    break;
                }
                case 138: {
                    if (parent.getType() != 69 && parent.getProp(29) == null) {
                        throw new RuntimeException("Unexpected node type " + type);
                    }
                    Codegen.pushUndefined(this.cfw);
                    break;
                }
                default: {
                    throw new RuntimeException("Unexpected node type " + type);
                }
            }
        }
    }
    
    private void generateYieldPoint(final Node node, final boolean exprContext) {
        final int top = this.cfw.getStackTop();
        this.maxStack = Math.max(this.maxStack, top);
        if (top != 0) {
            this.generateGenGetStack();
            for (int i = 0; i < top; ++i) {
                this.cfw.add(90);
                this.cfw.add(95);
                this.cfw.addLoadConstant(i);
                this.cfw.add(95);
                this.cfw.add(83);
            }
            this.cfw.add(87);
        }
        final int nextState = this.getNextGeneratorState(node);
        this.generateGeneratorReturnObject(node, false);
        this.generateSetGeneratorResumptionPoint(nextState);
        final boolean hasLocals = this.generateSaveLocals(node);
        this.cfw.add(176);
        if (nextState != ((FunctionNode)this.scriptOrFn).getResumptionPoints().size() + 1) {
            this.generateCheckForThrowOrClose(this.getTargetLabel(node), hasLocals, nextState);
        }
        if (top != 0) {
            this.generateGenGetStack();
            for (int j = 0; j < top; ++j) {
                this.cfw.add(89);
                this.cfw.addLoadConstant(top - j - 1);
                this.cfw.add(50);
                this.cfw.add(95);
            }
            this.cfw.add(87);
        }
        if (exprContext) {
            this.cfw.addALoad((int)this.argsLocal);
        }
    }
    
    private void generateCheckForThrowOrClose(final int label, final boolean hasLocals, final Object nextState) {
        final int throwLabel = this.cfw.acquireLabel();
        final int closeLabel = this.cfw.acquireLabel();
        this.cfw.markLabel(throwLabel);
        this.cfw.addALoad((int)this.argsLocal);
        this.generateThrowJavaScriptException();
        this.cfw.markLabel(closeLabel);
        this.generateGeneratorReturnObject(() -> this.cfw.addALoad((int)this.argsLocal), true);
        this.generateSetGeneratorResumptionPoint(-1);
        this.cfw.add(176);
        if (nextState == null) {
            this.cfw.markTableSwitchDefault(this.generatorSwitch);
        }
        if (label != -1) {
            this.cfw.markLabel(label);
        }
        if (!hasLocals && nextState != null) {
            this.cfw.markTableSwitchCase(this.generatorSwitch, (int)nextState);
        }
        this.cfw.addILoad((int)this.operationLocal);
        this.cfw.addLoadConstant(2);
        this.cfw.add(159, closeLabel);
        this.cfw.addILoad((int)this.operationLocal);
        this.cfw.addLoadConstant(1);
        this.cfw.add(159, throwLabel);
    }
    
    private void generateIfJump(final Node node, final Node parent, final int trueLabel, final int falseLabel) {
        final int type = node.getType();
        Node child = node.getFirstChild();
        switch (type) {
            case 27: {
                this.generateIfJump(child, node, falseLabel, trueLabel);
                break;
            }
            case 105:
            case 106: {
                final int interLabel = this.cfw.acquireLabel();
                if (type == 106) {
                    this.generateIfJump(child, node, interLabel, falseLabel);
                }
                else {
                    this.generateIfJump(child, node, trueLabel, interLabel);
                }
                this.cfw.markLabel(interLabel);
                child = child.getNext();
                this.generateIfJump(child, node, trueLabel, falseLabel);
                break;
            }
            case 14:
            case 15:
            case 16:
            case 17:
            case 55:
            case 56: {
                this.visitIfJumpRelOp(node, child, trueLabel, falseLabel);
                break;
            }
            case 12:
            case 13:
            case 49:
            case 50: {
                this.visitIfJumpEqOp(node, child, trueLabel, falseLabel);
                break;
            }
            default: {
                this.generateExpression(node, parent);
                this.addScriptRuntimeInvoke("toBoolean", "Z", "Ljava/lang/Object;");
                this.cfw.add(154, trueLabel);
                this.cfw.add(167, falseLabel);
                break;
            }
        }
    }
    
    private void visitDecoratorDeclaration(final DecoratorDeclarationNode node) {
        boolean hasInitialize = false;
        final int descriptor = this.getNewWordLocal();
        this.cfw.addALoad((int)this.argsLocal);
        this.cfw.addPush(1);
        this.cfw.add(50);
        this.cfw.addAStore(descriptor);
        for (final DecoratorNode dn : node.getDecoratorNodes()) {
            if (dn.getDecoratorType() == DecoratorType.INITIALIZE) {
                hasInitialize = true;
                final int L1 = this.cfw.acquireLabel();
                this.cfw.addALoad(descriptor);
                this.cfw.add(192, "java/lang/Integer");
                this.generateIntegerUnwrap();
                this.cfw.addPush(Decorator.FIELD);
                this.cfw.add(126);
                this.cfw.add(153, L1);
                this.cfw.addALoad(descriptor);
                this.cfw.add(192, "java/lang/Integer");
                this.generateIntegerUnwrap();
                this.cfw.addPush(Decorator.STATIC);
                this.cfw.add(126);
                this.cfw.add(153, L1);
                this.cfw.addPush("msg.decorator.initialize.on.static.field");
                this.addScriptRuntimeInvoke("typeError0", "Lorg/mozilla/javascript/EcmaError;", "Ljava/lang/String;");
                this.cfw.add(191);
                this.cfw.markLabel(L1);
            }
            this.generateExpression((Node)dn.getTarget(), (Node)node);
            this.cfw.add(192, "org/mozilla/javascript/BaseFunction");
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.argsLocal);
            this.cfw.add(89);
            this.cfw.addPush(3);
            final List<Node> args = new ArrayList<Node>();
            for (Node ch = dn.getFirstChild(); ch != null; ch = ch.getNext()) {
                args.add(ch);
            }
            this.cfw.addPush(args.size());
            this.cfw.add(189, "java/lang/Object");
            for (int i = 0, argsSize = args.size(); i < argsSize; ++i) {
                final Node arg = args.get(i);
                this.cfw.add(89);
                this.cfw.addPush(i);
                this.generateExpression(arg, (Node)node);
                this.cfw.add(83);
            }
            this.cfw.add(83);
            this.cfw.addInvoke(182, "org/mozilla/javascript/BaseFunction", "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
            this.cfw.addALoad((int)this.argsLocal);
            this.cfw.add(95);
            this.cfw.addPush(0);
            this.cfw.add(95);
            this.cfw.add(83);
        }
        final int skipAssociate = this.cfw.acquireLabel();
        this.cfw.addALoad((int)this.argsLocal);
        this.cfw.addPush(0);
        this.cfw.add(50);
        this.cfw.add(89);
        this.cfw.add(193, "org/mozilla/javascript/ScriptableObject");
        this.cfw.add(153, skipAssociate);
        this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
        this.cfw.add(89);
        this.cfw.add(178, "org/mozilla/javascript/decorators/Decorator", "HAS_INITIALIZE", "Ljava/lang/Object;");
        this.cfw.addPush(hasInitialize);
        this.generateBooleanWrap();
        this.cfw.addPush(true);
        this.cfw.addInvoke(182, "org/mozilla/javascript/ScriptableObject", "associateValue", "(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;");
        this.cfw.add(87);
        this.cfw.markLabel(skipAssociate);
    }
    
    private void visitClass(final ClassNode cls) {
        Node child = cls.getFirstChild();
        this.generateExpression(child, (Node)cls);
        child = child.getNext();
        if (cls.getExtended() != null) {
            this.generateExpression(cls.getExtended(), (Node)cls);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.addScriptRuntimeInvoke("setClassExtends", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
        }
        while (child != null) {
            if (child instanceof ClassMethod) {
                final ClassMethod cm = (ClassMethod)child;
                final Node method = cm.getFirstChild();
                final Object name = cm.getNameKey();
                if (name instanceof String) {
                    this.cfw.addPush((String)name);
                }
                else if (name instanceof Node) {
                    final Node node = (Node)name;
                    this.generateExpression(node, (Node)cls);
                }
                else {
                    this.cfw.addPush((int)name);
                    this.addScriptRuntimeInvoke("wrapInt", "Ljava/lang/Integer;", "I");
                }
                this.generateExpression(method, (Node)cls);
                this.generateApplyDecorator(child, (List<DecoratorNode>)cm.getProp(33), DecoratorType.WRAP);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addPush(!cm.isStatic());
                this.cfw.addPush(cm.isGetterMethod() ? 2 : (cm.isSetterMethod() ? 1 : 0));
                this.cfw.addPush(cm.isPrivate());
                this.addScriptRuntimeInvoke("addClassMethod", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Z", "I", "Z");
                child = child.getNext();
            }
            else {
                if (!(child instanceof ClassField)) {
                    continue;
                }
                final ClassField cp = (ClassField)child;
                final Node defaultValue = cp.getFirstChild();
                final Object name = cp.getNameKey();
                this.generateApplyDecorator(child, (List<DecoratorNode>)cp.getProp(33), DecoratorType.WRAP);
                if (!cp.isStatic()) {
                    child = child.getNext();
                }
                else {
                    if (name instanceof String) {
                        this.cfw.addPush((String)name);
                    }
                    else if (name instanceof Node) {
                        final Node node = (Node)name;
                        this.generateExpression(node, (Node)cls);
                    }
                    else {
                        this.cfw.addPush((int)name);
                        this.addScriptRuntimeInvoke("wrapInt", "Ljava/lang/Integer;", "I");
                    }
                    this.generateExpression(defaultValue, (Node)cls);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addPush(cp.isPrivate());
                    this.addScriptRuntimeInvoke("addClassProperty", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Z");
                    child = child.getNext();
                }
            }
        }
        this.generateApplyDecorator(cls.getFirstChild(), (List<DecoratorNode>)cls.getProp(33), DecoratorType.WRAP);
        final int skipInit = this.cfw.acquireLabel();
        this.cfw.add(89);
        this.cfw.add(193, "org/mozilla/javascript/NativeFunction");
        this.cfw.add(153, skipInit);
        this.cfw.add(89);
        this.cfw.add(192, "org/mozilla/javascript/NativeFunction");
        this.cfw.addPush(1);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addALoad((int)this.contextLocal);
        this.addOptRuntimeInvoke("initFunction", "V", "Lorg/mozilla/javascript/NativeFunction;", "I", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;");
        final int skipManualScope = this.cfw.acquireLabel();
        this.cfw.add(167, skipManualScope);
        this.cfw.markLabel(skipInit);
        final Name className = cls.getClassName();
        if (className != null) {
            final int tmp = this.getNewWordLocal(true);
            this.cfw.addAStore(tmp);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addPush(className.getIdentifier());
            this.addScriptRuntimeInvoke("bind", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
            this.cfw.addALoad(tmp);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addPush(cls.getClassName().getIdentifier());
            this.addScriptRuntimeInvoke("setName", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
        }
        this.cfw.markLabel(skipManualScope);
        for (child = cls.getFirstChild(); child != null; child = child.getNext()) {
            if (child instanceof ClassMethod) {
                final ClassMethod cm2 = (ClassMethod)child;
                this.generateApplyDecorator(child, (List<DecoratorNode>)cm2.getProp(33), DecoratorType.REGISTER);
            }
            else if (child instanceof ClassField) {
                final ClassField cp2 = (ClassField)child;
                this.generateApplyDecorator(child, (List<DecoratorNode>)cp2.getProp(33), DecoratorType.REGISTER);
            }
        }
        this.generateApplyDecorator(cls.getFirstChild(), (List<DecoratorNode>)cls.getProp(33), DecoratorType.REGISTER);
    }
    
    private void generateDecoratorDescriptor(final Node node) {
        int descriptor = 0;
        if (node instanceof ClassElement) {
            final ClassElement ce = (ClassElement)node;
            if (ce.isStatic()) {
                descriptor |= Decorator.STATIC;
            }
            if (ce.isPrivate()) {
                descriptor |= Decorator.PRIVATE;
            }
            else {
                descriptor |= Decorator.PUBLIC;
            }
            if (node instanceof ClassMethod) {
                descriptor |= Decorator.METHOD;
            }
            else {
                descriptor |= Decorator.FIELD;
            }
        }
        else {
            descriptor |= Decorator.CLASS;
        }
        this.cfw.addPush(descriptor);
    }
    
    private void generateApplyDecorator(final Node node, final List<DecoratorNode> decoratorNodes, final DecoratorType decoratorType) {
        for (final DecoratorNode dn : decoratorNodes) {
            final DecoratorType type = dn.getDecoratorType();
            if (!decoratorType.shouldTrigger(type)) {
                continue;
            }
            final int target = this.getNewWordLocal();
            this.cfw.addAStore(target);
            if (node instanceof ClassElement) {
                this.cfw.addALoad(target);
                this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
                this.cfw.add(178, "org/mozilla/javascript/decorators/Decorator", "NAME_KEY", "Ljava/lang/Object;");
                final Object targetName = ((ClassElement)node).getNameKey();
                if (targetName instanceof String) {
                    this.cfw.addPush((String)targetName);
                }
                else if (targetName instanceof Integer) {
                    this.cfw.addPush((int)targetName);
                }
                else {
                    if (!(targetName instanceof Node)) {
                        throw Kit.codeBug((targetName == null) ? "null" : targetName.getClass().getSimpleName());
                    }
                    this.generateExpression((Node)targetName, node);
                }
                this.cfw.addPush(true);
                this.cfw.addInvoke(182, "org/mozilla/javascript/ScriptableObject", "associateValue", "(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;");
                this.cfw.add(87);
            }
            final Name decorator = (Name)dn.getTarget();
            this.generateExpression((Node)decorator, node);
            this.cfw.add(192, "org/mozilla/javascript/BaseFunction");
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addPush(4);
            this.cfw.add(189, "java/lang/Object");
            this.cfw.add(89);
            this.cfw.addPush(0);
            this.cfw.addALoad(target);
            this.cfw.add(83);
            this.cfw.add(89);
            this.cfw.addPush(1);
            this.generateDecoratorDescriptor(node);
            this.generateIntegerWrap();
            this.cfw.add(83);
            this.cfw.add(89);
            this.cfw.addPush(2);
            this.cfw.add(178, "org/mozilla/javascript/decorators/DecoratorType", decoratorType.name(), "Lorg/mozilla/javascript/decorators/DecoratorType;");
            this.cfw.add(83);
            final List<Node> args = new ArrayList<Node>();
            for (Node ch = dn.getFirstChild(); ch != null; ch = ch.getNext()) {
                args.add(ch);
            }
            this.cfw.add(89);
            this.cfw.addPush(3);
            this.cfw.addPush(args.size());
            this.cfw.add(189, "java/lang/Object");
            for (int i = 0; i < args.size(); ++i) {
                this.cfw.add(89);
                this.cfw.addPush(i);
                final Node ch2 = args.get(i);
                this.generateExpression(ch2, node);
                this.cfw.add(83);
            }
            this.cfw.add(83);
            this.cfw.addInvoke(182, "org/mozilla/javascript/BaseFunction", "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
    }
    
    private void generateDebugCall() {
        this.addScriptRuntimeInvoke("debug", "V", "Ljava/lang/Object;");
    }
    
    private void generateRequireCall(final String filePath) {
        this.cfw.addPush(1);
        this.cfw.add(189, "java/lang/Object");
        this.cfw.add(89);
        this.cfw.addPush(0);
        this.cfw.addPush(filePath);
        this.cfw.add(83);
        this.cfw.addPush("require");
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.addOptRuntimeInvoke("callName", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
    }
    
    private void visitFunction(final OptFunctionNode ofn, final int functionType) {
        final int fnIndex = this.codegen.getIndex((ScriptNode)ofn.fnode);
        this.cfw.add(187, this.codegen.mainClassName);
        this.cfw.add(89);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addPush(fnIndex);
        this.cfw.addInvoke(183, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        if (functionType == 4) {
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.addOptRuntimeInvoke("bindThis", "Lorg/mozilla/javascript/Function;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;");
        }
        if (functionType == 2 || functionType == 4) {
            return;
        }
        this.cfw.addPush(functionType);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addALoad((int)this.contextLocal);
        this.addOptRuntimeInvoke("initFunction", "V", "Lorg/mozilla/javascript/NativeFunction;", "I", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;");
    }
    
    private int getTargetLabel(final Node target) {
        int labelId = target.labelId();
        if (labelId == -1) {
            labelId = this.cfw.acquireLabel();
            target.labelId(labelId);
        }
        return labelId;
    }
    
    private void visitGoto(final Jump node, final int type, final Node child) {
        final Node target = node.target;
        if (type == 6 || type == 7) {
            if (child == null) {
                throw Codegen.badTree();
            }
            final int targetLabel = this.getTargetLabel(target);
            final int fallThruLabel = this.cfw.acquireLabel();
            if (type == 6) {
                this.generateIfJump(child, (Node)node, targetLabel, fallThruLabel);
            }
            else {
                this.generateIfJump(child, (Node)node, fallThruLabel, targetLabel);
            }
            this.cfw.markLabel(fallThruLabel);
        }
        else if (type == 145) {
            if (this.isGenerator) {
                this.addGotoWithReturn(target);
            }
            else {
                this.inlineFinally(target);
            }
        }
        else {
            this.addGoto(target, 167);
        }
    }
    
    private void addGotoWithReturn(final Node target) {
        final FinallyReturnPoint ret = this.finallys.get(target);
        this.cfw.addLoadConstant(ret.jsrPoints.size());
        this.addGoto(target, 167);
        this.cfw.add(87);
        final int retLabel = this.cfw.acquireLabel();
        this.cfw.markLabel(retLabel);
        ret.jsrPoints.add(retLabel);
    }
    
    private void generateArrayLiteralFactory(final Node node, final int count) {
        final String methodName = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + count;
        this.initBodyGeneration();
        final short firstFreeLocal = this.firstFreeLocal;
        this.firstFreeLocal = (short)(firstFreeLocal + 1);
        this.argsLocal = firstFreeLocal;
        this.localsMax = this.firstFreeLocal;
        this.cfw.startMethod(methodName, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short)2);
        this.visitArrayLiteral(node, node.getFirstChild(), true);
        this.cfw.add(176);
        this.cfw.stopMethod((short)(this.localsMax + 1));
    }
    
    private void generateObjectLiteralFactory(final Node node, final int count) {
        final String methodName = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + count;
        this.initBodyGeneration();
        final short firstFreeLocal = this.firstFreeLocal;
        this.firstFreeLocal = (short)(firstFreeLocal + 1);
        this.argsLocal = firstFreeLocal;
        this.localsMax = this.firstFreeLocal;
        this.cfw.startMethod(methodName, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short)2);
        this.visitObjectLiteral(node, node.getFirstChild(), true);
        this.cfw.add(176);
        this.cfw.stopMethod((short)(this.localsMax + 1));
    }
    
    private void visitArrayLiteral(final Node node, Node child, final boolean topLevel) {
        int count = 0;
        for (Node cursor = child; cursor != null; cursor = cursor.getNext()) {
            ++count;
        }
        if (!topLevel && (count > 10 || this.cfw.getCurrentCodeOffset() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock) {
            if (this.literals == null) {
                this.literals = new LinkedList<Node>();
            }
            this.literals.add(node);
            final String methodName = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.addALoad((int)this.funObjLocal);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.argsLocal);
            this.cfw.addInvoke(182, this.codegen.mainClassName, methodName, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            for (int i = 0; i != count; ++i) {
                this.generateExpression(child, node);
                child = child.getNext();
            }
            this.addNewObjectArray(count);
            for (int i = 0; i != count; ++i) {
                this.cfw.add(90);
                this.cfw.add(95);
                this.cfw.addPush(count - i - 1);
                this.cfw.add(95);
                this.cfw.add(83);
            }
        }
        else {
            final ArgGroups groups = this.populateArgGroups(child);
            if (groups.isSpread.size() > 0) {
                this.addNewObjectArray(groups.groupCount());
                this.generateArgArray(node, groups);
            }
            else {
                this.addNewObjectArray(count);
                for (int j = 0; j != count; ++j) {
                    this.cfw.add(89);
                    this.cfw.addPush(j);
                    this.generateExpression(child, node);
                    this.cfw.add(83);
                    child = child.getNext();
                }
            }
        }
        final int[] skipIndexes = (int[])node.getProp(11);
        if (skipIndexes == null) {
            this.cfw.add(1);
            this.cfw.add(3);
        }
        else {
            this.cfw.addPush(OptRuntime.encodeIntArray(skipIndexes));
            this.cfw.addPush(skipIndexes.length);
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.addOptRuntimeInvoke("newArrayLiteral", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "Ljava/lang/String;", "I", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
    }
    
    private void addLoadPropertyIds(final Object[] properties, final int[] spreadIndices, final Node parent) {
        final int count = properties.length + spreadIndices.length;
        this.addNewObjectArray(count);
        int propIndex = 0;
        int i = 0;
    Label_0019:
        while (i != count) {
            this.cfw.add(89);
            this.cfw.addPush(i);
            while (true) {
                for (final int j : spreadIndices) {
                    if (i == j) {
                        this.cfw.add(1);
                        this.cfw.add(83);
                        ++i;
                        continue Label_0019;
                    }
                }
                final Object id = properties[propIndex++];
                if (id instanceof String) {
                    this.cfw.addPush((String)id);
                }
                else if (id instanceof Node) {
                    final Node node = (Node)id;
                    this.generateExpression(node, parent);
                }
                else {
                    this.cfw.addPush((int)id);
                    this.addScriptRuntimeInvoke("wrapInt", "Ljava/lang/Integer;", "I");
                }
                this.cfw.add(83);
                continue;
            }
        }
    }
    
    private void addLoadPropertyValues(final Node node, Node child, final int count) {
        if (this.isGenerator) {
            for (int i = 0; i != count; ++i) {
                final int childType = child.getType();
                if (childType == 156 || childType == 157 || childType == 168) {
                    this.generateExpression(child.getFirstChild(), node);
                }
                else {
                    this.generateExpression(child, node);
                }
                child = child.getNext();
            }
            this.addNewObjectArray(count);
            for (int i = 0; i != count; ++i) {
                this.cfw.add(90);
                this.cfw.add(95);
                this.cfw.addPush(count - i - 1);
                this.cfw.add(95);
                this.cfw.add(83);
            }
        }
        else {
            this.addNewObjectArray(count);
            Node child2 = child;
            for (int j = 0; j != count; ++j) {
                this.cfw.add(89);
                this.cfw.addPush(j);
                final boolean spread = child2.getProp(29) != null;
                final int childType2 = child2.getType();
                if (childType2 == 156 || childType2 == 157 || childType2 == 168) {
                    if (spread) {
                        throw Kit.codeBug("Unexpected spread on an object method");
                    }
                    this.generateExpression(child2.getFirstChild(), node);
                }
                else {
                    this.generateExpression(child2, node);
                }
                this.cfw.add(83);
                child2 = child2.getNext();
            }
        }
    }
    
    private void visitObjectLiteral(final Node node, final Node child, final boolean topLevel) {
        final Object[] properties = (Object[])node.getProp(12);
        final int[] spreadIndices = (int[])node.getProp(32, (Object)new int[0]);
        final int count = properties.length;
        if (!topLevel && (count > 10 || this.cfw.getCurrentCodeOffset() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock) {
            if (this.literals == null) {
                this.literals = new LinkedList<Node>();
            }
            this.literals.add(node);
            final String methodName = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.addALoad((int)this.funObjLocal);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.argsLocal);
            this.cfw.addInvoke(182, this.codegen.mainClassName, methodName, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            this.addLoadPropertyValues(node, child, count + spreadIndices.length);
            this.addLoadPropertyIds(properties, spreadIndices, node);
            this.cfw.add(95);
        }
        else {
            this.addLoadPropertyIds(properties, spreadIndices, node);
            this.addLoadPropertyValues(node, child, count + spreadIndices.length);
        }
        boolean hasGetterSetters = false;
        Node child2 = child;
        for (int i = 0; i != count; ++i) {
            final int childType = child2.getType();
            if (childType == 156 || childType == 157) {
                hasGetterSetters = true;
                break;
            }
            child2 = child2.getNext();
        }
        if (hasGetterSetters) {
            this.cfw.addPush(count);
            this.cfw.add(188, 10);
            child2 = child;
            for (int i = 0; i != count; ++i) {
                this.cfw.add(89);
                this.cfw.addPush(i);
                final int childType = child2.getType();
                if (childType == 156) {
                    this.cfw.add(2);
                }
                else if (childType == 157) {
                    this.cfw.add(4);
                }
                else {
                    this.cfw.add(3);
                }
                this.cfw.add(79);
                child2 = child2.getNext();
            }
        }
        else {
            this.cfw.add(1);
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.addScriptRuntimeInvoke("newObjectLiteral", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "[I", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
    }
    
    private void visitSpecialCall(final Node node, final int type, final int specialType, Node child) {
        this.cfw.addALoad((int)this.contextLocal);
        if (type == 31) {
            this.generateExpression(child, node);
        }
        else {
            this.generateFunctionAndThisObj(child, node);
        }
        child = child.getNext();
        this.generateCallArgArray(node, child, false);
        String methodName;
        String[] callSignature;
        if (type == 31) {
            methodName = "newObjectSpecial";
            callSignature = new String[] { "Lorg/mozilla/javascript/Context;", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "I" };
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addPush(specialType);
        }
        else {
            methodName = "callSpecial";
            callSignature = new String[] { "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Callable;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "I", "Ljava/lang/String;", "I" };
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addPush(specialType);
            final String sourceName = this.scriptOrFn.getSourceName();
            this.cfw.addPush((sourceName == null) ? "" : sourceName);
            this.cfw.addPush(this.itsLineNumber);
        }
        this.addOptRuntimeInvoke(methodName, "Ljava/lang/Object;", callSignature);
    }
    
    private void visitStandardCall(final Node node, final Node child) {
        if (node.getType() != 39) {
            throw Codegen.badTree();
        }
        final boolean isPrivate = child.getProp(34) != null;
        final boolean isPartial = node.getProp(37) != null;
        if (isPartial) {
            this.cfw.add(187, "org/mozilla/javascript/PartialFunction");
            this.cfw.add(89);
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
        }
        final Node firstArgChild = child.getNext();
        final int childType = child.getType();
        String methodName;
        String[] signature;
        if (firstArgChild == null) {
            if (childType == 40) {
                if (child.getProp(31) != null) {
                    final boolean isReturned = node.getNext() != null && node.getNext().getType() == 4;
                    if (child.getProp(31) == IRFactory.GENERATED_SUPER) {
                        this.cfw.addALoad((int)this.argsLocal);
                    }
                    else {
                        this.cfw.add(1);
                    }
                    this.cfw.addPush(isReturned);
                    this.cfw.addALoad((int)this.funObjLocal);
                    this.cfw.addALoad((int)this.thisObjLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.addScriptRuntimeInvoke("callSuper", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Z", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;");
                    if (!isReturned) {
                        this.cfw.add(89);
                        this.cfw.addAStore((int)this.thisObjLocal);
                    }
                    return;
                }
                final String name = child.getString();
                this.cfw.addPush(name);
                methodName = "callName0";
                signature = new String[] { "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
            }
            else if (childType == 34) {
                final Node propTarget = child.getFirstChild();
                final Node id = propTarget.getNext();
                if (propTarget.getProp(31) != null) {
                    this.generateExpression(id, node);
                    this.cfw.add(1);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.cfw.addALoad((int)this.thisObjLocal);
                    this.cfw.addALoad((int)this.funObjLocal);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.addScriptRuntimeInvoke("callSuperProp", "Ljava/lang/Object;", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Context;");
                    return;
                }
                this.generateExpression(propTarget, node);
                final String property = id.getString();
                this.cfw.addPush(property);
                if (child.getProp(30) != null) {
                    methodName = "optionalAccessCallProp0";
                }
                else if (node.getProp(30) != null) {
                    methodName = "optionalCallProp0";
                }
                else if (isPrivate) {
                    methodName = "privateCallProp0";
                }
                else {
                    methodName = "callProp0";
                }
                signature = new String[] { "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
            }
            else {
                if (childType == 35) {
                    throw Kit.codeBug();
                }
                if (node.getProp(30) != null) {
                    this.generateExpression(child, node);
                    methodName = "optionalCall0";
                    signature = new String[] { "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
                }
                else {
                    this.generateFunctionAndThisObj(child, node, isPrivate);
                    methodName = "call0";
                    signature = new String[] { "Lorg/mozilla/javascript/Callable;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
                }
            }
        }
        else if (childType == 40) {
            if (isPartial) {
                this.generateExpression(child, node);
                this.cfw.addALoad((int)this.thisObjLocal);
            }
            this.generateCallArgArray(node, firstArgChild, false);
            if (isPartial) {
                this.cfw.addInvoke(183, "org/mozilla/javascript/PartialFunction", "<init>", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[I[Ljava/lang/Object;)V");
                this.cfw.add(192, "java/lang/Object");
                return;
            }
            final String name = child.getString();
            if (child.getProp(31) != null) {
                final boolean isReturned2 = node.getNext() != null && node.getNext().getType() == 4;
                this.cfw.addPush(isReturned2);
                this.cfw.addALoad((int)this.funObjLocal);
                this.cfw.addALoad((int)this.thisObjLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addALoad((int)this.contextLocal);
                this.addScriptRuntimeInvoke("callSuper", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Z", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;");
                if (!isReturned2) {
                    this.cfw.add(89);
                    this.cfw.addAStore((int)this.thisObjLocal);
                }
                return;
            }
            this.cfw.addPush(name);
            methodName = "callName";
            signature = new String[] { "[Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
        }
        else {
            if (isPartial) {
                this.generateFunctionAndThisObj(child, node, isPrivate);
                this.generateCallArgArray(node, firstArgChild, false);
                this.cfw.addInvoke(183, "org/mozilla/javascript/PartialFunction", "<init>", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[I[Ljava/lang/Object;)V");
                this.cfw.add(192, "java/lang/Object");
                return;
            }
            int argCount = 0;
            for (Node arg = firstArgChild; arg != null; arg = arg.getNext()) {
                if (arg.getProp(29) != null) {
                    argCount = -1;
                    break;
                }
                ++argCount;
            }
            if (child.getFirstChild() != null && child.getFirstChild().getProp(31) != null) {
                this.generateExpression(child.getLastChild(), node);
                this.generateCallArgArray(node, firstArgChild, false);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addALoad((int)this.thisObjLocal);
                this.cfw.addALoad((int)this.funObjLocal);
                this.cfw.addALoad((int)this.contextLocal);
                this.addScriptRuntimeInvoke("callSuperProp", "Ljava/lang/Object;", "Ljava/lang/Object;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;", "Lorg/mozilla/javascript/Context;");
                return;
            }
            if (child.getProp(30) != null) {
                final Node prop = child.getFirstChild();
                this.generateExpression(prop, child);
                final String property = prop.getNext().getString();
                this.cfw.addPush(property);
                this.generateCallArgArray(node, firstArgChild, false);
                methodName = "optionalAccessCallN";
                signature = new String[] { "Ljava/lang/Object;", "Ljava/lang/String;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
            }
            else if (node.getProp(30) != null) {
                if (child.getType() == 40) {
                    final Node prop = child.getFirstChild();
                    this.generateExpression(prop, child);
                    final String property = prop.getNext().getString();
                    this.cfw.addPush(property);
                    this.generateCallArgArray(node, firstArgChild, false);
                    methodName = "optionalCallPropN";
                    signature = new String[] { "Ljava/lang/Object;", "Ljava/lang/String;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
                }
                else {
                    this.generateExpression(child, node);
                    this.generateCallArgArray(node, firstArgChild, false);
                    methodName = "optionalCallN";
                    signature = new String[] { "Ljava/lang/Object;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
                }
            }
            else if (argCount == 1) {
                this.generateFunctionAndThisObj(child, node, isPrivate);
                this.generateExpression(firstArgChild, node);
                methodName = "call1";
                signature = new String[] { "Lorg/mozilla/javascript/Callable;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
            }
            else if (argCount == 2) {
                this.generateFunctionAndThisObj(child, node, isPrivate);
                this.generateExpression(firstArgChild, node);
                this.generateExpression(firstArgChild.getNext(), node);
                methodName = "call2";
                signature = new String[] { "Lorg/mozilla/javascript/Callable;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
            }
            else {
                this.generateFunctionAndThisObj(child, node, isPrivate);
                this.generateCallArgArray(node, firstArgChild, false);
                methodName = "callN";
                signature = new String[] { "Lorg/mozilla/javascript/Callable;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;" };
            }
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.addOptRuntimeInvoke(methodName, "Ljava/lang/Object;", signature);
    }
    
    private void visitStandardNew(final Node node, final Node child) {
        if (node.getType() != 31) {
            throw Codegen.badTree();
        }
        final Node firstArgChild = child.getNext();
        this.generateExpression(child, node);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.generateCallArgArray(node, firstArgChild, false);
        this.addScriptRuntimeInvoke("newObject", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;");
    }
    
    private void visitOptimizedCall(final Node node, final OptFunctionNode target, final int type, final Node child) {
        final Node firstArgChild = child.getNext();
        final String className = this.codegen.mainClassName;
        short thisObjLocal = 0;
        if (type == 31) {
            this.generateExpression(child, node);
        }
        else {
            this.generateFunctionAndThisObj(child, node);
            thisObjLocal = this.getNewWordLocal();
            this.cfw.addAStore((int)thisObjLocal);
        }
        final int beyond = this.cfw.acquireLabel();
        final int regularCall = this.cfw.acquireLabel();
        this.cfw.add(89);
        this.cfw.add(193, className);
        this.cfw.add(153, regularCall);
        this.cfw.add(192, className);
        this.cfw.add(89);
        this.cfw.add(180, className, "_id", "I");
        this.cfw.addPush(this.codegen.getIndex((ScriptNode)target.fnode));
        this.cfw.add(160, regularCall);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        if (type == 31) {
            this.cfw.add(1);
        }
        else {
            this.cfw.addALoad((int)thisObjLocal);
        }
        for (Node argChild = firstArgChild; argChild != null; argChild = argChild.getNext()) {
            final int dcp_register = this.nodeIsDirectCallParameter(argChild);
            if (dcp_register >= 0) {
                this.cfw.addALoad(dcp_register);
                this.cfw.addDLoad(dcp_register + 1);
            }
            else if (argChild.getIntProp(8, -1) == 0) {
                this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                this.generateExpression(argChild, node);
            }
            else {
                this.generateExpression(argChild, node);
                this.cfw.addPush(0.0);
            }
        }
        this.cfw.add(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        this.cfw.addInvoke(184, this.codegen.mainClassName, (type == 31) ? this.codegen.getDirectCtorName((ScriptNode)target.fnode) : this.codegen.getBodyMethodName((ScriptNode)target.fnode), this.codegen.getBodyMethodSignature((ScriptNode)target.fnode));
        this.cfw.add(167, beyond);
        this.cfw.markLabel(regularCall);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        if (type != 31) {
            this.cfw.addALoad((int)thisObjLocal);
            this.releaseWordLocal(thisObjLocal);
        }
        this.generateCallArgArray(node, firstArgChild, true);
        if (type == 31) {
            this.addScriptRuntimeInvoke("newObject", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "[Ljava/lang/Object;");
        }
        else {
            this.cfw.addInvoke(185, "org/mozilla/javascript/Callable", "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
        this.cfw.markLabel(beyond);
    }
    
    private ArgGroups populateArgGroups(final Node argChild) {
        final ArgGroups groups = new ArgGroups();
        boolean wasSpread = false;
        for (Node child = argChild; child != null; child = child.getNext()) {
            final boolean isSpread = child.getProp(29) != null;
            if ((isSpread || (!isSpread && wasSpread)) && child != argChild) {
                groups.crossBoundary();
            }
            wasSpread = isSpread;
            groups.put(child, isSpread);
        }
        return groups;
    }
    
    private void generateArgArray(final Node parent, final ArgGroups groups) {
        for (int i = 0; i < groups.groupCount(); ++i) {
            final List<Node> group = groups.groups.get(i);
            final boolean isSpread = groups.isSpread.contains(i);
            this.cfw.add(89);
            this.cfw.addPush(i);
            if (isSpread) {
                if (group.size() != 1) {
                    throw Kit.codeBug();
                }
                this.generateExpression(group.get(0), parent);
            }
            else {
                this.addNewObjectArray(group.size());
                for (int i2 = 0; i2 < group.size(); ++i2) {
                    this.cfw.add(89);
                    this.cfw.addPush(i2);
                    final Node groupChild = group.get(i2);
                    this.generateExpression(groupChild, parent);
                    this.cfw.add(83);
                }
            }
            this.cfw.add(83);
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.addScriptRuntimeInvoke("combineSpreadArgs", "[Ljava/lang/Object;", "[Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
    }
    
    private void generateCallArgArray(final Node node, Node argChild, final boolean directCall) {
        final ArgGroups groups = this.populateArgGroups(argChild);
        if (groups.isPartial.size() > 0) {
            this.cfw.addPush(groups.isPartial.size());
            this.cfw.add(188, 10);
            int i = 0;
            for (final int partialIndex : groups.isPartial) {
                this.cfw.add(89);
                this.cfw.addPush(i);
                this.cfw.addPush(partialIndex);
                this.cfw.add(79);
                ++i;
            }
        }
        if (groups.totalArgs == 1 && this.itsOneArgArray >= 0) {
            this.cfw.addALoad((int)this.itsOneArgArray);
        }
        else if (groups.isSpread.size() > 0) {
            this.addNewObjectArray(groups.groupCount());
        }
        else {
            this.addNewObjectArray(groups.totalArgs - groups.isPartial.size());
        }
        if (groups.isSpread.size() > 0) {
            this.generateArgArray(node, groups);
            return;
        }
        for (int i = 0; i < groups.totalArgs - groups.isPartial.size(); ++i) {
            if (argChild.getType() == 103 && argChild instanceof EmptyExpression) {
                argChild = argChild.getNext();
                --i;
            }
            else {
                if (!this.isGenerator) {
                    this.cfw.add(89);
                    this.cfw.addPush(i);
                }
                if (!directCall) {
                    this.generateExpression(argChild, node);
                }
                else {
                    final int dcp_register = this.nodeIsDirectCallParameter(argChild);
                    if (dcp_register >= 0) {
                        this.dcpLoadAsObject(dcp_register);
                    }
                    else {
                        this.generateExpression(argChild, node);
                        final int childNumberFlag = argChild.getIntProp(8, -1);
                        if (childNumberFlag == 0) {
                            this.addDoubleWrap();
                        }
                    }
                }
                if (this.isGenerator) {
                    final short tempLocal = this.getNewWordLocal();
                    this.cfw.addAStore((int)tempLocal);
                    this.cfw.add(192, "[Ljava/lang/Object;");
                    this.cfw.add(89);
                    this.cfw.addPush(i);
                    this.cfw.addALoad((int)tempLocal);
                    this.releaseWordLocal(tempLocal);
                }
                this.cfw.add(83);
                argChild = argChild.getNext();
            }
        }
    }
    
    private void generateFunctionAndThisObj(final Node node, final Node parent) {
        this.generateFunctionAndThisObj(node, parent, false);
    }
    
    private void generateFunctionAndThisObj(final Node node, final Node parent, final boolean isPrivate) {
        final int type = node.getType();
        switch (node.getType()) {
            case 35: {
                throw Kit.codeBug();
            }
            case 34:
            case 37: {
                final Node target = node.getFirstChild();
                this.generateExpression(target, node);
                short objLocal = 0;
                if (isPrivate) {
                    objLocal = this.getNewWordLocal();
                    this.cfw.add(89);
                    this.cfw.addAStore((int)objLocal);
                }
                final Node id = target.getNext();
                if (isPrivate) {
                    this.cfw.addALoad((int)objLocal);
                    this.addOptRuntimeInvoke("optionalPrivateToggle", "V", "Ljava/lang/Object;");
                }
                if (type == 34) {
                    final String property = id.getString();
                    this.cfw.addPush(property);
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke("getPropFunctionAndThis", "Lorg/mozilla/javascript/Callable;", "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                }
                else {
                    this.generateExpression(id, node);
                    if (node.getIntProp(8, -1) != -1) {
                        this.addDoubleWrap();
                    }
                    this.cfw.addALoad((int)this.contextLocal);
                    this.cfw.addALoad((int)this.variableObjectLocal);
                    this.addScriptRuntimeInvoke("getElemFunctionAndThis", "Lorg/mozilla/javascript/Callable;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                }
                if (isPrivate) {
                    this.cfw.addALoad((int)objLocal);
                    this.addOptRuntimeInvoke("optionalPrivateToggle", "V", "Ljava/lang/Object;");
                    break;
                }
                break;
            }
            case 40: {
                final String name = node.getString();
                this.cfw.addPush(name);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("getNameFunctionAndThis", "Lorg/mozilla/javascript/Callable;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
                break;
            }
            default: {
                this.generateExpression(node, parent);
                this.cfw.addALoad((int)this.contextLocal);
                this.addScriptRuntimeInvoke("getValueFunctionAndThis", "Lorg/mozilla/javascript/Callable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;");
                break;
            }
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.addScriptRuntimeInvoke("lastStoredScriptable", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/Context;");
    }
    
    private void updateLineNumber(final Node node) {
        this.itsLineNumber = node.getLineno();
        if (this.itsLineNumber == -1) {
            return;
        }
        this.cfw.addLineNumberEntry((short)this.itsLineNumber);
    }
    
    private void visitTryCatchFinally(final Jump node, Node child) {
        final short savedVariableObject = this.getNewWordLocal();
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addAStore((int)savedVariableObject);
        final int startLabel = this.cfw.acquireLabel();
        this.cfw.markLabel(startLabel, (short)0);
        final Node catchTarget = node.target;
        final Node finallyTarget = node.getFinally();
        final int[] handlerLabels = new int[5];
        this.exceptionManager.pushExceptionInfo(node);
        if (catchTarget != null) {
            handlerLabels[0] = this.cfw.acquireLabel();
            handlerLabels[1] = this.cfw.acquireLabel();
            handlerLabels[2] = this.cfw.acquireLabel();
            final Context cx = Context.getCurrentContext();
            if (cx != null && cx.hasFeature(12)) {
                handlerLabels[3] = this.cfw.acquireLabel();
            }
        }
        if (finallyTarget != null) {
            handlerLabels[4] = this.cfw.acquireLabel();
        }
        this.exceptionManager.setHandlers(handlerLabels, startLabel);
        if (this.isGenerator && finallyTarget != null) {
            final FinallyReturnPoint ret = new FinallyReturnPoint();
            if (this.finallys == null) {
                this.finallys = new HashMap<Node, FinallyReturnPoint>();
            }
            this.finallys.put(finallyTarget, ret);
            this.finallys.put(finallyTarget.getNext(), ret);
        }
        while (child != null) {
            if (child == catchTarget) {
                final int catchLabel = this.getTargetLabel(catchTarget);
                this.exceptionManager.removeHandler(0, catchLabel);
                this.exceptionManager.removeHandler(1, catchLabel);
                this.exceptionManager.removeHandler(2, catchLabel);
                this.exceptionManager.removeHandler(3, catchLabel);
            }
            this.generateStatement(child);
            child = child.getNext();
        }
        final int realEnd = this.cfw.acquireLabel();
        this.cfw.add(167, realEnd);
        final int exceptionLocal = this.getLocalBlockRegister((Node)node);
        if (catchTarget != null) {
            final int catchLabel2 = catchTarget.labelId();
            this.generateCatchBlock(0, savedVariableObject, catchLabel2, exceptionLocal, handlerLabels[0]);
            this.generateCatchBlock(1, savedVariableObject, catchLabel2, exceptionLocal, handlerLabels[1]);
            this.generateCatchBlock(2, savedVariableObject, catchLabel2, exceptionLocal, handlerLabels[2]);
            final Context cx2 = Context.getCurrentContext();
            if (cx2 != null && cx2.hasFeature(12)) {
                this.generateCatchBlock(3, savedVariableObject, catchLabel2, exceptionLocal, handlerLabels[3]);
            }
        }
        if (finallyTarget != null) {
            final int finallyHandler = this.cfw.acquireLabel();
            final int finallyEnd = this.cfw.acquireLabel();
            this.cfw.markHandler(finallyHandler);
            if (!this.isGenerator) {
                this.cfw.markLabel(handlerLabels[4]);
            }
            this.cfw.addAStore(exceptionLocal);
            this.cfw.addALoad((int)savedVariableObject);
            this.cfw.addAStore((int)this.variableObjectLocal);
            final int finallyLabel = finallyTarget.labelId();
            if (this.isGenerator) {
                this.addGotoWithReturn(finallyTarget);
            }
            else {
                this.inlineFinally(finallyTarget, handlerLabels[4], finallyEnd);
            }
            this.cfw.addALoad(exceptionLocal);
            if (this.isGenerator) {
                this.cfw.add(192, "java/lang/Throwable");
            }
            this.cfw.add(191);
            this.cfw.markLabel(finallyEnd);
            if (this.isGenerator) {
                this.cfw.addExceptionHandler(startLabel, finallyLabel, finallyHandler, (String)null);
            }
        }
        this.releaseWordLocal(savedVariableObject);
        this.cfw.markLabel(realEnd);
        if (!this.isGenerator) {
            this.exceptionManager.popExceptionInfo();
        }
    }
    
    private void generateCatchBlock(final int exceptionType, final short savedVariableObject, final int catchLabel, final int exceptionLocal, int handler) {
        if (handler == 0) {
            handler = this.cfw.acquireLabel();
        }
        this.cfw.markHandler(handler);
        this.cfw.addAStore(exceptionLocal);
        this.cfw.addALoad((int)savedVariableObject);
        this.cfw.addAStore((int)this.variableObjectLocal);
        this.cfw.add(167, catchLabel);
    }
    
    private String exceptionTypeToName(final int exceptionType) {
        if (exceptionType == 0) {
            return "org/mozilla/javascript/JavaScriptException";
        }
        if (exceptionType == 1) {
            return "org/mozilla/javascript/EvaluatorException";
        }
        if (exceptionType == 2) {
            return "org/mozilla/javascript/EcmaError";
        }
        if (exceptionType == 3) {
            return "java/lang/Throwable";
        }
        if (exceptionType == 4) {
            return null;
        }
        throw Kit.codeBug();
    }
    
    private void inlineFinally(final Node finallyTarget, final int finallyStart, final int finallyEnd) {
        final Node fBlock = this.getFinallyAtTarget(finallyTarget);
        fBlock.resetTargets();
        Node child = fBlock.getFirstChild();
        this.exceptionManager.markInlineFinallyStart(fBlock, finallyStart);
        while (child != null) {
            this.generateStatement(child);
            child = child.getNext();
        }
        this.exceptionManager.markInlineFinallyEnd(fBlock, finallyEnd);
    }
    
    private void inlineFinally(final Node finallyTarget) {
        final int finallyStart = this.cfw.acquireLabel();
        final int finallyEnd = this.cfw.acquireLabel();
        this.cfw.markLabel(finallyStart);
        this.inlineFinally(finallyTarget, finallyStart, finallyEnd);
        this.cfw.markLabel(finallyEnd);
    }
    
    private Node getFinallyAtTarget(final Node node) {
        if (node == null) {
            return null;
        }
        if (node.getType() == 134) {
            return node;
        }
        if (node.getType() == 141) {
            final Node fBlock = node.getNext();
            if (fBlock != null && fBlock.getType() == 134) {
                return fBlock;
            }
        }
        throw Kit.codeBug("bad finally target");
    }
    
    private boolean generateSaveLocals(final Node node) {
        int count = 0;
        for (int i = 0; i < this.firstFreeLocal; ++i) {
            if (this.locals[i] != 0) {
                ++count;
            }
        }
        if (count == 0) {
            ((FunctionNode)this.scriptOrFn).addLiveLocals(node, (int[])null);
            return false;
        }
        this.maxLocals = Math.max(this.maxLocals, count);
        final int[] ls = new int[count];
        int s = 0;
        for (int j = 0; j < this.firstFreeLocal; ++j) {
            if (this.locals[j] != 0) {
                ls[s] = j;
                ++s;
            }
        }
        ((FunctionNode)this.scriptOrFn).addLiveLocals(node, ls);
        this.generateGetGeneratorLocalsState();
        for (int j = 0; j < count; ++j) {
            this.cfw.add(89);
            this.cfw.addLoadConstant(j);
            this.cfw.addALoad(ls[j]);
            this.cfw.add(83);
        }
        this.cfw.add(87);
        return true;
    }
    
    private void visitSwitch(final Jump switchNode, final Node child) {
        this.generateExpression(child, (Node)switchNode);
        final short selector = this.getNewWordLocal();
        this.cfw.addAStore((int)selector);
        for (Jump caseNode = (Jump)child.getNext(); caseNode != null; caseNode = (Jump)caseNode.getNext()) {
            if (caseNode.getType() != 124) {
                throw Codegen.badTree();
            }
            final Node test = caseNode.getFirstChild();
            this.generateExpression(test, (Node)caseNode);
            this.cfw.addALoad((int)selector);
            this.addScriptRuntimeInvoke("shallowEq", "Z", "Ljava/lang/Object;", "Ljava/lang/Object;");
            this.addGoto(caseNode.target, 154);
        }
        this.releaseWordLocal(selector);
    }
    
    private void visitTypeofname(final Node node) {
        if (this.hasVarsInRegs) {
            final int varIndex = this.fnCurrent.fnode.getIndexForNameNode(node);
            if (varIndex >= 0) {
                if (this.fnCurrent.isNumberVar(varIndex)) {
                    this.cfw.addPush("number");
                }
                else if (this.varIsDirectCallParameter(varIndex)) {
                    final int dcp_register = this.varRegisters[varIndex];
                    this.cfw.addALoad(dcp_register);
                    this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    final int isNumberLabel = this.cfw.acquireLabel();
                    this.cfw.add(165, isNumberLabel);
                    final short stack = this.cfw.getStackTop();
                    this.cfw.addALoad(dcp_register);
                    this.addScriptRuntimeInvoke("typeof", "Ljava/lang/String;", "Ljava/lang/Object;");
                    final int beyond = this.cfw.acquireLabel();
                    this.cfw.add(167, beyond);
                    this.cfw.markLabel(isNumberLabel, stack);
                    this.cfw.addPush("number");
                    this.cfw.markLabel(beyond);
                }
                else {
                    this.cfw.addALoad((int)this.varRegisters[varIndex]);
                    this.addScriptRuntimeInvoke("typeof", "Ljava/lang/String;", "Ljava/lang/Object;");
                }
                return;
            }
        }
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addPush(node.getString());
        this.addScriptRuntimeInvoke("typeofName", "Ljava/lang/String;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
    }
    
    private void saveCurrentCodeOffset() {
        this.savedCodeOffset = this.cfw.getCurrentCodeOffset();
    }
    
    private void addInstructionCount() {
        final int count = this.cfw.getCurrentCodeOffset() - this.savedCodeOffset;
        this.addInstructionCount(Math.max(count, 1));
    }
    
    private void addInstructionCount(final int count) {
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addPush(count);
        this.addScriptRuntimeInvoke("addInstructionCount", "V", "Lorg/mozilla/javascript/Context;", "I");
    }
    
    private void visitIncDec(final Node node) {
        final int incrDecrMask = node.getExistingIntProp(13);
        final Node child = node.getFirstChild();
        switch (child.getType()) {
            case 58: {
                if (!this.hasVarsInRegs) {
                    Kit.codeBug();
                }
                final boolean post = (incrDecrMask & 0x2) != 0x0;
                final int varIndex = this.fnCurrent.getVarIndex(child);
                final short reg = this.varRegisters[varIndex];
                final boolean[] constDeclarations = this.fnCurrent.fnode.getParamAndVarConst();
                if (constDeclarations[varIndex]) {
                    if (node.getIntProp(8, -1) != -1) {
                        final int offset = this.varIsDirectCallParameter(varIndex) ? 1 : 0;
                        this.cfw.addDLoad(reg + offset);
                        if (!post) {
                            this.cfw.addPush(1.0);
                            if ((incrDecrMask & 0x1) == 0x0) {
                                this.cfw.add(99);
                            }
                            else {
                                this.cfw.add(103);
                            }
                        }
                        break;
                    }
                    if (this.varIsDirectCallParameter(varIndex)) {
                        this.dcpLoadAsObject(reg);
                    }
                    else {
                        this.cfw.addALoad((int)reg);
                    }
                    if (post) {
                        this.cfw.add(89);
                        this.addObjectToDouble();
                        this.cfw.add(88);
                        break;
                    }
                    this.addObjectToDouble();
                    this.cfw.addPush(1.0);
                    if ((incrDecrMask & 0x1) == 0x0) {
                        this.cfw.add(99);
                    }
                    else {
                        this.cfw.add(103);
                    }
                    this.addDoubleWrap();
                    break;
                }
                else {
                    if (node.getIntProp(8, -1) != -1) {
                        final int offset = this.varIsDirectCallParameter(varIndex) ? 1 : 0;
                        this.cfw.addDLoad(reg + offset);
                        if (post) {
                            this.cfw.add(92);
                        }
                        this.cfw.addPush(1.0);
                        if ((incrDecrMask & 0x1) == 0x0) {
                            this.cfw.add(99);
                        }
                        else {
                            this.cfw.add(103);
                        }
                        if (!post) {
                            this.cfw.add(92);
                        }
                        this.cfw.addDStore(reg + offset);
                        break;
                    }
                    if (this.varIsDirectCallParameter(varIndex)) {
                        this.dcpLoadAsObject(reg);
                    }
                    else {
                        this.cfw.addALoad((int)reg);
                    }
                    this.addObjectToDouble();
                    if (post) {
                        this.cfw.add(92);
                    }
                    this.cfw.addPush(1.0);
                    if ((incrDecrMask & 0x1) == 0x0) {
                        this.cfw.add(99);
                    }
                    else {
                        this.cfw.add(103);
                    }
                    this.addDoubleWrap();
                    if (!post) {
                        this.cfw.add(89);
                    }
                    this.cfw.addAStore((int)reg);
                    if (post) {
                        this.addDoubleWrap();
                        break;
                    }
                    break;
                }
                break;
            }
            case 40: {
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addPush(child.getString());
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addPush(incrDecrMask);
                this.addScriptRuntimeInvoke("nameIncrDecr", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "I");
                break;
            }
            case 35: {
                throw Kit.codeBug();
            }
            case 34: {
                final Node getPropChild = child.getFirstChild();
                this.generateExpression(getPropChild, node);
                this.generateExpression(getPropChild.getNext(), node);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addPush(incrDecrMask);
                this.addScriptRuntimeInvoke("propIncrDecr", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "I");
                break;
            }
            case 37: {
                final Node elemChild = child.getFirstChild();
                this.generateExpression(elemChild, node);
                this.generateExpression(elemChild.getNext(), node);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addPush(incrDecrMask);
                if (elemChild.getNext().getIntProp(8, -1) != -1) {
                    this.addOptRuntimeInvoke("elemIncrDecr", "Ljava/lang/Object;", "Ljava/lang/Object;", "D", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "I");
                    break;
                }
                this.addScriptRuntimeInvoke("elemIncrDecr", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "I");
                break;
            }
            case 71: {
                final Node refChild = child.getFirstChild();
                this.generateExpression(refChild, node);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addPush(incrDecrMask);
                this.addScriptRuntimeInvoke("refIncrDecr", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Ref;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "I");
                break;
            }
            default: {
                Codegen.badTree();
                break;
            }
        }
    }
    
    private static boolean isArithmeticNode(final Node node) {
        final int type = node.getType();
        return type == 22 || type == 25 || type == 24 || type == 23;
    }
    
    private void visitOperator(final Node node, final Node child, final int op) {
        boolean unary = false;
        switch (op) {
            case 27:
            case 28:
            case 29:
            case 30:
            case 33: {
                unary = true;
                break;
            }
        }
        this.generateExpression(child, node);
        if (!unary) {
            this.generateExpression(child.getNext(), node);
        }
        this.cfw.addPush(op);
        this.cfw.addALoad((int)this.contextLocal);
        if (unary) {
            this.addScriptRuntimeInvoke("unaryOperator", "Ljava/lang/Object;", "Ljava/lang/Object;", "I", "Lorg/mozilla/javascript/Context;");
        }
        else {
            this.addScriptRuntimeInvoke("binaryOperator", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "I", "Lorg/mozilla/javascript/Context;");
        }
    }
    
    private int nodeIsDirectCallParameter(final Node node) {
        if (node.getType() == 58 && this.inDirectCallFunction && !this.itsForcedObjectParameters) {
            final int varIndex = this.fnCurrent.getVarIndex(node);
            if (this.fnCurrent.isParameter(varIndex)) {
                return this.varRegisters[varIndex];
            }
        }
        return -1;
    }
    
    private boolean varIsDirectCallParameter(final int varIndex) {
        return this.fnCurrent.isParameter(varIndex) && this.inDirectCallFunction && !this.itsForcedObjectParameters;
    }
    
    private void genSimpleCompare(final int type, final int trueGOTO, final int falseGOTO) {
        if (trueGOTO == -1) {
            throw Codegen.badTree();
        }
        switch (type) {
            case 15: {
                this.cfw.add(152);
                this.cfw.add(158, trueGOTO);
                break;
            }
            case 17: {
                this.cfw.add(151);
                this.cfw.add(156, trueGOTO);
                break;
            }
            case 14: {
                this.cfw.add(152);
                this.cfw.add(155, trueGOTO);
                break;
            }
            case 16: {
                this.cfw.add(151);
                this.cfw.add(157, trueGOTO);
                break;
            }
            default: {
                throw Codegen.badTree();
            }
        }
        if (falseGOTO != -1) {
            this.cfw.add(167, falseGOTO);
        }
    }
    
    private void visitIfJumpRelOp(final Node node, final Node child, final int trueGOTO, final int falseGOTO) {
        if (trueGOTO == -1 || falseGOTO == -1) {
            throw Codegen.badTree();
        }
        final int type = node.getType();
        final Node rChild = child.getNext();
        if (type == 56 || type == 55) {
            this.generateExpression(child, node);
            this.generateExpression(rChild, node);
            this.cfw.addALoad((int)this.contextLocal);
            this.addScriptRuntimeInvoke((type == 56) ? "instanceOf" : "in", "Z", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;");
            this.cfw.add(154, trueGOTO);
            this.cfw.add(167, falseGOTO);
            return;
        }
        final int childNumberFlag = node.getIntProp(8, -1);
        final int left_dcp_register = this.nodeIsDirectCallParameter(child);
        final int right_dcp_register = this.nodeIsDirectCallParameter(rChild);
        if (childNumberFlag != -1) {
            if (childNumberFlag != 2) {
                this.generateExpression(child, node);
            }
            else if (left_dcp_register != -1) {
                this.dcpLoadAsNumber(left_dcp_register);
            }
            else {
                this.generateExpression(child, node);
                this.addObjectToDouble();
            }
            if (childNumberFlag != 1) {
                this.generateExpression(rChild, node);
            }
            else if (right_dcp_register != -1) {
                this.dcpLoadAsNumber(right_dcp_register);
            }
            else {
                this.generateExpression(rChild, node);
                this.addObjectToDouble();
            }
            this.genSimpleCompare(type, trueGOTO, falseGOTO);
        }
        else {
            if (left_dcp_register != -1 && right_dcp_register != -1) {
                final short stack = this.cfw.getStackTop();
                final int leftIsNotNumber = this.cfw.acquireLabel();
                this.cfw.addALoad(left_dcp_register);
                this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                this.cfw.add(166, leftIsNotNumber);
                this.cfw.addDLoad(left_dcp_register + 1);
                this.dcpLoadAsNumber(right_dcp_register);
                this.genSimpleCompare(type, trueGOTO, falseGOTO);
                if (stack != this.cfw.getStackTop()) {
                    throw Codegen.badTree();
                }
                this.cfw.markLabel(leftIsNotNumber);
                final int rightIsNotNumber = this.cfw.acquireLabel();
                this.cfw.addALoad(right_dcp_register);
                this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                this.cfw.add(166, rightIsNotNumber);
                this.cfw.addALoad(left_dcp_register);
                this.addObjectToDouble();
                this.cfw.addDLoad(right_dcp_register + 1);
                this.genSimpleCompare(type, trueGOTO, falseGOTO);
                if (stack != this.cfw.getStackTop()) {
                    throw Codegen.badTree();
                }
                this.cfw.markLabel(rightIsNotNumber);
                this.cfw.addALoad(left_dcp_register);
                this.cfw.addALoad(right_dcp_register);
            }
            else {
                this.generateExpression(child, node);
                this.generateExpression(rChild, node);
            }
            if (type == 17 || type == 16) {
                this.cfw.add(95);
            }
            final String routine = (type == 14 || type == 16) ? "cmp_LT" : "cmp_LE";
            this.addScriptRuntimeInvoke(routine, "Z", "Ljava/lang/Object;", "Ljava/lang/Object;");
            this.cfw.add(154, trueGOTO);
            this.cfw.add(167, falseGOTO);
        }
    }
    
    private void visitIfJumpEqOp(final Node node, Node child, int trueGOTO, int falseGOTO) {
        if (trueGOTO == -1 || falseGOTO == -1) {
            throw Codegen.badTree();
        }
        final short stackInitial = this.cfw.getStackTop();
        final int type = node.getType();
        final Node rChild = child.getNext();
        if (child.getType() == 45 || rChild.getType() == 45) {
            if (child.getType() == 45) {
                child = rChild;
            }
            this.generateExpression(child, node);
            if (type == 49 || type == 50) {
                final int testCode = (type == 49) ? 198 : 199;
                this.cfw.add(testCode, trueGOTO);
            }
            else {
                if (type != 12) {
                    if (type != 13) {
                        throw Codegen.badTree();
                    }
                    final int tmp = trueGOTO;
                    trueGOTO = falseGOTO;
                    falseGOTO = tmp;
                }
                this.cfw.add(89);
                final int undefCheckLabel = this.cfw.acquireLabel();
                this.cfw.add(199, undefCheckLabel);
                final short stack = this.cfw.getStackTop();
                this.cfw.add(87);
                this.cfw.add(167, trueGOTO);
                this.cfw.markLabel(undefCheckLabel, stack);
                Codegen.pushUndefined(this.cfw);
                this.cfw.add(165, trueGOTO);
            }
            this.cfw.add(167, falseGOTO);
        }
        else {
            final int child_dcp_register = this.nodeIsDirectCallParameter(child);
            if (child_dcp_register != -1 && rChild.getType() == 154) {
                final Node convertChild = rChild.getFirstChild();
                if (convertChild.getType() == 41) {
                    this.cfw.addALoad(child_dcp_register);
                    this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    final int notNumbersLabel = this.cfw.acquireLabel();
                    this.cfw.add(166, notNumbersLabel);
                    this.cfw.addDLoad(child_dcp_register + 1);
                    this.cfw.addPush(convertChild.getDouble());
                    this.cfw.add(151);
                    if (type == 12) {
                        this.cfw.add(153, trueGOTO);
                    }
                    else {
                        this.cfw.add(154, trueGOTO);
                    }
                    this.cfw.add(167, falseGOTO);
                    this.cfw.markLabel(notNumbersLabel);
                }
            }
            this.generateExpression(child, node);
            this.generateExpression(rChild, node);
            String name = null;
            int testCode2 = 0;
            switch (type) {
                case 12: {
                    name = "eq";
                    testCode2 = 154;
                    break;
                }
                case 13: {
                    name = "eq";
                    testCode2 = 153;
                    break;
                }
                case 49: {
                    name = "shallowEq";
                    testCode2 = 154;
                    break;
                }
                case 50: {
                    name = "shallowEq";
                    testCode2 = 153;
                    break;
                }
                default: {
                    throw Codegen.badTree();
                }
            }
            this.addScriptRuntimeInvoke(name, "Z", "Ljava/lang/Object;", "Ljava/lang/Object;");
            this.cfw.add(testCode2, trueGOTO);
            this.cfw.add(167, falseGOTO);
        }
        if (stackInitial != this.cfw.getStackTop()) {
            throw Codegen.badTree();
        }
    }
    
    private void visitSetName(final Node node, Node child) {
        final String name = node.getFirstChild().getString();
        while (child != null) {
            this.generateExpression(child, node);
            child = child.getNext();
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addPush(name);
        this.addScriptRuntimeInvoke("setName", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
    }
    
    private void visitStrictSetName(final Node node, Node child) {
        final String name = node.getFirstChild().getString();
        while (child != null) {
            this.generateExpression(child, node);
            child = child.getNext();
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addPush(name);
        this.addScriptRuntimeInvoke("strictSetName", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;");
    }
    
    private void visitSetConst(final Node node, Node child) {
        final String name = node.getFirstChild().getString();
        while (child != null) {
            this.generateExpression(child, node);
            child = child.getNext();
        }
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addPush(name);
        this.addScriptRuntimeInvoke("setConst", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Ljava/lang/String;");
    }
    
    private void visitGetVar(final Node node) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        final int varIndex = this.fnCurrent.getVarIndex(node);
        final short reg = this.varRegisters[varIndex];
        if (this.varIsDirectCallParameter(varIndex)) {
            if (node.getIntProp(8, -1) != -1) {
                this.dcpLoadAsNumber(reg);
            }
            else {
                this.dcpLoadAsObject(reg);
            }
        }
        else if (this.fnCurrent.isNumberVar(varIndex)) {
            this.cfw.addDLoad((int)reg);
        }
        else {
            this.cfw.addALoad((int)reg);
        }
    }
    
    private void visitSetVar(final Node node, final Node child, final boolean needValue) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        final int varIndex = this.fnCurrent.getVarIndex(node);
        this.generateExpression(child.getNext(), node);
        final boolean isNumber = node.getIntProp(8, -1) != -1;
        final short reg = this.varRegisters[varIndex];
        final boolean[] constDeclarations = this.fnCurrent.fnode.getParamAndVarConst();
        if (constDeclarations[varIndex]) {
            if (!needValue) {
                if (isNumber) {
                    this.cfw.add(88);
                }
                else {
                    this.cfw.add(87);
                }
            }
        }
        else if (this.varIsDirectCallParameter(varIndex)) {
            if (isNumber) {
                if (needValue) {
                    this.cfw.add(92);
                }
                this.cfw.addALoad((int)reg);
                this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                final int isNumberLabel = this.cfw.acquireLabel();
                final int beyond = this.cfw.acquireLabel();
                this.cfw.add(165, isNumberLabel);
                final short stack = this.cfw.getStackTop();
                this.addDoubleWrap();
                this.cfw.addAStore((int)reg);
                this.cfw.add(167, beyond);
                this.cfw.markLabel(isNumberLabel, stack);
                this.cfw.addDStore(reg + 1);
                this.cfw.markLabel(beyond);
            }
            else {
                if (needValue) {
                    this.cfw.add(89);
                }
                this.cfw.addAStore((int)reg);
            }
        }
        else {
            final boolean isNumberVar = this.fnCurrent.isNumberVar(varIndex);
            if (isNumber) {
                if (isNumberVar) {
                    this.cfw.addDStore((int)reg);
                    if (needValue) {
                        this.cfw.addDLoad((int)reg);
                    }
                }
                else {
                    if (needValue) {
                        this.cfw.add(92);
                    }
                    this.addDoubleWrap();
                    this.cfw.addAStore((int)reg);
                }
            }
            else {
                if (isNumberVar) {
                    Kit.codeBug();
                }
                this.cfw.addAStore((int)reg);
                if (needValue) {
                    this.cfw.addALoad((int)reg);
                }
            }
        }
    }
    
    private void visitSetConstVar(final Node node, final Node child, final boolean needValue) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        final int varIndex = this.fnCurrent.getVarIndex(node);
        this.generateExpression(child.getNext(), node);
        final boolean isNumber = node.getIntProp(8, -1) != -1;
        final short reg = this.varRegisters[varIndex];
        final int beyond = this.cfw.acquireLabel();
        final int noAssign = this.cfw.acquireLabel();
        if (isNumber) {
            this.cfw.addILoad(reg + 2);
            this.cfw.add(154, noAssign);
            final short stack = this.cfw.getStackTop();
            this.cfw.addPush(1);
            this.cfw.addIStore(reg + 2);
            this.cfw.addDStore((int)reg);
            if (needValue) {
                this.cfw.addDLoad((int)reg);
                this.cfw.markLabel(noAssign, stack);
            }
            else {
                this.cfw.add(167, beyond);
                this.cfw.markLabel(noAssign, stack);
                this.cfw.add(88);
            }
        }
        else {
            this.cfw.addILoad(reg + 1);
            this.cfw.add(154, noAssign);
            final short stack = this.cfw.getStackTop();
            this.cfw.addPush(1);
            this.cfw.addIStore(reg + 1);
            this.cfw.addAStore((int)reg);
            if (needValue) {
                this.cfw.addALoad((int)reg);
                this.cfw.markLabel(noAssign, stack);
            }
            else {
                this.cfw.add(167, beyond);
                this.cfw.markLabel(noAssign, stack);
                this.cfw.add(87);
            }
        }
        this.cfw.markLabel(beyond);
    }
    
    private void visitGetProp(final Node node, final Node child) {
        final boolean isPrivate = node.getProp(34) != null;
        if (child.getProp(31) != null) {
            this.generateExpression(child.getNext(), node);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.funObjLocal);
            this.addScriptRuntimeInvoke("accessSuper", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;");
            return;
        }
        this.generateExpression(child, node);
        short objLocal = 0;
        if (isPrivate) {
            this.cfw.add(89);
            this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
            objLocal = this.getNewWordLocal();
            this.cfw.addAStore((int)objLocal);
        }
        final Node nameChild = child.getNext();
        this.generateExpression(nameChild, node);
        if (node.getType() == 35) {
            this.cfw.addALoad((int)this.contextLocal);
            this.cfw.addALoad((int)this.variableObjectLocal);
            this.cfw.addPush(isPrivate);
            this.addScriptRuntimeInvoke("getObjectPropNoWarn", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Z");
        }
        else {
            final String methodName = (node.getProp(30) != null) ? "optionalGetObjectProp" : "getObjectProp";
            final int childType = child.getType();
            if (childType == 46 && nameChild.getType() == 42) {
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addPush(isPrivate);
                this.addScriptRuntimeInvoke(methodName, "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Z");
            }
            else {
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addPush(isPrivate);
                this.addScriptRuntimeInvoke(methodName, "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Z");
            }
        }
    }
    
    private void visitSetProp(final int type, final Node node, Node child) {
        final boolean isPrivate = node.getProp(34) != null;
        final Node objectChild = child;
        final boolean isSuper = objectChild.getProp(31) != null;
        if (!isSuper) {
            this.generateExpression(child, node);
        }
        short objLocal = 0;
        if (isPrivate) {
            this.cfw.add(89);
            this.cfw.add(192, "org/mozilla/javascript/ScriptableObject");
            objLocal = this.getNewWordLocal();
            this.cfw.addAStore((int)objLocal);
        }
        child = child.getNext();
        if (type == 149) {
            this.cfw.add(89);
        }
        final Node nameChild = child;
        this.generateExpression(child, node);
        child = child.getNext();
        if (type == 149) {
            this.cfw.add(90);
            if (objectChild.getType() == 46 && nameChild.getType() == 42) {
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addPush(isPrivate);
                this.addScriptRuntimeInvoke("getObjectProp", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Z");
            }
            else {
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.cfw.addPush(isPrivate);
                this.addScriptRuntimeInvoke("getObjectProp", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/String;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Z");
            }
        }
        if (isSuper) {
            this.generateExpression(child, node);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.funObjLocal);
            this.addScriptRuntimeInvoke("setSuperProp", "Ljava/lang/Object;", "Ljava/lang/String;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;");
            return;
        }
        this.generateExpression(child, node);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        this.cfw.addPush(isPrivate);
        this.addScriptRuntimeInvoke("setObjectProp", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/String;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;", "Z");
    }
    
    private void visitSetElem(final int type, final Node node, Node child) {
        final boolean isSuper = child.getProp(31) != null;
        if (isSuper) {
            child = child.getNext();
            this.generateExpression(child, node);
            child = child.getNext();
            this.generateExpression(child, node);
            this.cfw.addALoad((int)this.thisObjLocal);
            this.cfw.addALoad((int)this.funObjLocal);
            this.addScriptRuntimeInvoke("setSuperElem", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Scriptable;", "Lorg/mozilla/javascript/NativeFunction;");
            return;
        }
        this.generateExpression(child, node);
        child = child.getNext();
        if (type == 150) {
            this.cfw.add(89);
        }
        this.generateExpression(child, node);
        child = child.getNext();
        final boolean indexIsNumber = node.getIntProp(8, -1) != -1;
        if (type == 150) {
            if (indexIsNumber) {
                this.cfw.add(93);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("getObjectIndex", "Ljava/lang/Object;", "Ljava/lang/Object;", "D", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
            }
            else {
                this.cfw.add(90);
                this.cfw.addALoad((int)this.contextLocal);
                this.cfw.addALoad((int)this.variableObjectLocal);
                this.addScriptRuntimeInvoke("getObjectElem", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
            }
        }
        this.generateExpression(child, node);
        this.cfw.addALoad((int)this.contextLocal);
        this.cfw.addALoad((int)this.variableObjectLocal);
        if (indexIsNumber) {
            this.addScriptRuntimeInvoke("setObjectIndex", "Ljava/lang/Object;", "Ljava/lang/Object;", "D", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
        }
        else {
            this.addScriptRuntimeInvoke("setObjectElem", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Ljava/lang/Object;", "Lorg/mozilla/javascript/Context;", "Lorg/mozilla/javascript/Scriptable;");
        }
    }
    
    private int getLocalBlockRegister(final Node node) {
        final Node localBlock = (Node)node.getProp(3);
        return localBlock.getExistingIntProp(2);
    }
    
    private void dcpLoadAsNumber(final int dcp_register) {
        this.cfw.addALoad(dcp_register);
        this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        final int isNumberLabel = this.cfw.acquireLabel();
        this.cfw.add(165, isNumberLabel);
        final short stack = this.cfw.getStackTop();
        this.cfw.addALoad(dcp_register);
        this.addObjectToDouble();
        final int beyond = this.cfw.acquireLabel();
        this.cfw.add(167, beyond);
        this.cfw.markLabel(isNumberLabel, stack);
        this.cfw.addDLoad(dcp_register + 1);
        this.cfw.markLabel(beyond);
    }
    
    private void dcpLoadAsObject(final int dcp_register) {
        this.cfw.addALoad(dcp_register);
        this.cfw.add(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        final int isNumberLabel = this.cfw.acquireLabel();
        this.cfw.add(165, isNumberLabel);
        final short stack = this.cfw.getStackTop();
        this.cfw.addALoad(dcp_register);
        final int beyond = this.cfw.acquireLabel();
        this.cfw.add(167, beyond);
        this.cfw.markLabel(isNumberLabel, stack);
        this.cfw.addDLoad(dcp_register + 1);
        this.addDoubleWrap();
        this.cfw.markLabel(beyond);
    }
    
    private void addGoto(final Node target, final int jumpcode) {
        final int targetLabel = this.getTargetLabel(target);
        this.cfw.add(jumpcode, targetLabel);
    }
    
    private void addObjectToDouble() {
        this.addScriptRuntimeInvoke("toNumber", "D", "Ljava/lang/Object;");
    }
    
    private void addNewObjectArray(final int size) {
        if (size == 0) {
            if (this.itsZeroArgArray >= 0) {
                this.cfw.addALoad((int)this.itsZeroArgArray);
            }
            else {
                this.cfw.add(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
            }
        }
        else {
            this.cfw.addPush(size);
            this.cfw.add(189, "java/lang/Object");
        }
    }
    
    private void addScriptRuntimeInvoke(final String methodName, final String returnValue, final String... args) {
        this.cfw.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", methodName, "(" + String.join("", (CharSequence[])args) + ")" + returnValue);
    }
    
    private void addOptRuntimeInvoke(final String methodName, final String returnValue, final String... args) {
        this.cfw.addInvoke(184, "org/mozilla/javascript/optimizer/OptRuntime", methodName, "(" + String.join("", (CharSequence[])args) + ")" + returnValue);
    }
    
    private void addJumpedBooleanWrap(final int trueLabel, final int falseLabel) {
        this.cfw.markLabel(falseLabel);
        final int skip = this.cfw.acquireLabel();
        this.cfw.add(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        this.cfw.add(167, skip);
        this.cfw.markLabel(trueLabel);
        this.cfw.add(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        this.cfw.markLabel(skip);
        this.cfw.adjustStackTop(-1);
    }
    
    private void addDoubleWrap() {
        this.addOptRuntimeInvoke("wrapDouble", "Ljava/lang/Double;", "D");
    }
    
    private short getNewWordPairLocal(final boolean isConst) {
        return this.getNewWordIntern(isConst ? 3 : 2);
    }
    
    private short getNewWordLocal(final boolean isConst) {
        return this.getNewWordIntern(isConst ? 2 : 1);
    }
    
    private short getNewWordLocal() {
        return this.getNewWordIntern(1);
    }
    
    private short getNewWordIntern(final int count) {
        assert count >= 1 && count <= 3;
        final int[] locals = this.locals;
        int result = -1;
        if (count > 1) {
            int i = this.firstFreeLocal;
        Label_0042:
            while (i + count <= 1024) {
                for (int j = 0; j < count; ++j) {
                    if (locals[i + j] != 0) {
                        i += j + 1;
                        continue Label_0042;
                    }
                }
                result = i;
                break;
            }
        }
        else {
            result = this.firstFreeLocal;
        }
        if (result != -1) {
            locals[result] = 1;
            if (count > 1) {
                locals[result + 1] = 1;
            }
            if (count > 2) {
                locals[result + 2] = 1;
            }
            if (result != this.firstFreeLocal) {
                return (short)result;
            }
            for (int i = result + count; i < 1024; ++i) {
                if (locals[i] == 0) {
                    this.firstFreeLocal = (short)i;
                    if (this.localsMax < this.firstFreeLocal) {
                        this.localsMax = this.firstFreeLocal;
                    }
                    return (short)result;
                }
            }
        }
        throw Context.reportRuntimeError("Program too complex (out of locals)");
    }
    
    private void incReferenceWordLocal(final short local) {
        final int[] locals = this.locals;
        ++locals[local];
    }
    
    private void decReferenceWordLocal(final short local) {
        final int[] locals = this.locals;
        --locals[local];
    }
    
    private void releaseWordLocal(final short local) {
        if (local < this.firstFreeLocal) {
            this.firstFreeLocal = local;
        }
        this.locals[local] = 0;
    }
    
    static class ArgGroups
    {
        public List<List<Node>> groups;
        public Set<Integer> isSpread;
        public Set<Integer> isPartial;
        public int totalArgs;
        private int cursor;
        
        ArgGroups() {
            this.groups = new ArrayList<List<Node>>();
            this.isSpread = new HashSet<Integer>();
            this.isPartial = new HashSet<Integer>();
            this.cursor = 0;
            this.groups.add(new ArrayList<Node>());
        }
        
        public void put(final Node node, final boolean isSpread) {
            ++this.totalArgs;
            if (node.getType() == 103 && node instanceof EmptyExpression) {
                this.isPartial.add(this.totalArgs - 1);
                return;
            }
            this.groups.get(this.cursor).add(node);
            if (isSpread) {
                this.isSpread.add(this.cursor);
            }
        }
        
        public void crossBoundary() {
            ++this.cursor;
            this.groups.add(new ArrayList<Node>());
        }
        
        public int groupCount() {
            return this.groups.size();
        }
    }
    
    private class ExceptionManager
    {
        private LinkedList<ExceptionInfo> exceptionInfo;
        
        ExceptionManager() {
            this.exceptionInfo = new LinkedList<ExceptionInfo>();
        }
        
        void pushExceptionInfo(final Jump node) {
            final Node fBlock = BodyCodegen.this.getFinallyAtTarget(node.getFinally());
            final ExceptionInfo ei = new ExceptionInfo(node, fBlock);
            this.exceptionInfo.add(ei);
        }
        
        void addHandler(final int exceptionType, final int handlerLabel, final int startLabel) {
            final ExceptionInfo top = this.getTop();
            top.handlerLabels[exceptionType] = handlerLabel;
            top.exceptionStarts[exceptionType] = startLabel;
        }
        
        void setHandlers(final int[] handlerLabels, final int startLabel) {
            for (int i = 0; i < handlerLabels.length; ++i) {
                if (handlerLabels[i] != 0) {
                    this.addHandler(i, handlerLabels[i], startLabel);
                }
            }
        }
        
        int removeHandler(final int exceptionType, final int endLabel) {
            final ExceptionInfo top = this.getTop();
            if (top.handlerLabels[exceptionType] != 0) {
                final int handlerLabel = top.handlerLabels[exceptionType];
                this.endCatch(top, exceptionType, endLabel);
                top.handlerLabels[exceptionType] = 0;
                return handlerLabel;
            }
            return 0;
        }
        
        void popExceptionInfo() {
            this.exceptionInfo.removeLast();
        }
        
        void markInlineFinallyStart(final Node finallyBlock, final int finallyStart) {
            final ListIterator<ExceptionInfo> iter = this.exceptionInfo.listIterator(this.exceptionInfo.size());
            while (iter.hasPrevious()) {
                final ExceptionInfo ei = iter.previous();
                for (int i = 0; i < 5; ++i) {
                    if (ei.handlerLabels[i] != 0 && ei.currentFinally == null) {
                        this.endCatch(ei, i, finallyStart);
                        ei.exceptionStarts[i] = 0;
                        ei.currentFinally = finallyBlock;
                    }
                }
                if (ei.finallyBlock == finallyBlock) {
                    break;
                }
            }
        }
        
        void markInlineFinallyEnd(final Node finallyBlock, final int finallyEnd) {
            final ListIterator<ExceptionInfo> iter = this.exceptionInfo.listIterator(this.exceptionInfo.size());
            while (iter.hasPrevious()) {
                final ExceptionInfo ei = iter.previous();
                for (int i = 0; i < 5; ++i) {
                    if (ei.handlerLabels[i] != 0 && ei.currentFinally == finallyBlock) {
                        ei.exceptionStarts[i] = finallyEnd;
                        ei.currentFinally = null;
                    }
                }
                if (ei.finallyBlock == finallyBlock) {
                    break;
                }
            }
        }
        
        private void endCatch(final ExceptionInfo ei, final int exceptionType, final int catchEnd) {
            if (ei.exceptionStarts[exceptionType] == 0) {
                throw new IllegalStateException("bad exception start");
            }
            final int currentStart = ei.exceptionStarts[exceptionType];
            final int currentStartPC = BodyCodegen.this.cfw.getLabelPC(currentStart);
            final int catchEndPC = BodyCodegen.this.cfw.getLabelPC(catchEnd);
            if (currentStartPC != catchEndPC) {
                BodyCodegen.this.cfw.addExceptionHandler(ei.exceptionStarts[exceptionType], catchEnd, ei.handlerLabels[exceptionType], BodyCodegen.this.exceptionTypeToName(exceptionType));
            }
        }
        
        private ExceptionInfo getTop() {
            return this.exceptionInfo.getLast();
        }
        
        private class ExceptionInfo
        {
            Node finallyBlock;
            int[] handlerLabels;
            int[] exceptionStarts;
            Node currentFinally;
            
            ExceptionInfo(final Jump node, final Node finallyBlock) {
                this.finallyBlock = finallyBlock;
                this.handlerLabels = new int[5];
                this.exceptionStarts = new int[5];
                this.currentFinally = null;
            }
        }
    }
    
    static class FinallyReturnPoint
    {
        public List<Integer> jsrPoints;
        public int tableLabel;
        
        FinallyReturnPoint() {
            this.jsrPoints = new ArrayList<Integer>();
            this.tableLabel = 0;
        }
    }
}
