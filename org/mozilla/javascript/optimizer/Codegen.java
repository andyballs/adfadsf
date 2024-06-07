//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.optimizer;

import java.io.*;
import java.lang.reflect.*;
import org.mozilla.classfile.*;
import java.util.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.ast.*;

public class Codegen implements Evaluator
{
    static final String DEFAULT_MAIN_METHOD_CLASS = "org.mozilla.javascript.optimizer.OptRuntime";
    private static final String SUPER_CLASS_NAME = "org.mozilla.javascript.NativeFunction";
    static final String ID_FIELD_NAME = "_id";
    static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    private static final Object globalLock;
    public static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private ObjArray directCallTargets;
    ScriptNode[] scriptOrFnNodes;
    private ObjToIntMap scriptOrFnIndexes;
    private String mainMethodClass;
    String mainClassName;
    String mainClassSignature;
    private double[] itsConstantList;
    private int itsConstantListSize;
    
    public Codegen() {
        this.mainMethodClass = "org.mozilla.javascript.optimizer.OptRuntime";
    }
    
    public void captureStackInfo(final RhinoException ex) {
        throw new UnsupportedOperationException();
    }
    
    public String getSourcePositionFromStack(final Context cx, final int[] linep) {
        throw new UnsupportedOperationException();
    }
    
    public String getPatchedStack(final RhinoException ex, final String nativeStackTrace) {
        throw new UnsupportedOperationException();
    }
    
    public List<String> getScriptStack(final RhinoException ex) {
        throw new UnsupportedOperationException();
    }
    
    public void setEvalScriptFlag(final Script script) {
        throw new UnsupportedOperationException();
    }
    
    public Object compile(final CompilerEnvirons compilerEnv, final ScriptNode tree, final String encodedSource, final boolean returnFunction) {
        final int serial;
        synchronized (Codegen.globalLock) {
            serial = ++Codegen.globalSerialClassCounter;
        }
        String baseName = "c";
        if (tree.getSourceName().length() > 0) {
            baseName = tree.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(baseName.charAt(0))) {
                baseName = "_" + baseName;
            }
        }
        final String mainClassName = "org.mozilla.javascript.gen." + baseName + "_" + serial;
        final byte[] mainClassBytes = this.compileToClassFile(compilerEnv, mainClassName, tree, encodedSource, returnFunction);
        final File debugOutputPath = Context.getContext().getDebugOutputPath();
        if (debugOutputPath != null) {
            final File classDir = new File(debugOutputPath, "class");
            final File jsDir = new File(debugOutputPath, "js");
            final File tokenDir = new File(debugOutputPath, "token");
            final File nodeDir = new File(debugOutputPath, "nodes");
            classDir.mkdir();
            jsDir.mkdir();
            tokenDir.mkdir();
            nodeDir.mkdir();
            final File classOutput = new File(classDir, baseName + "_" + serial + ".class");
            final File jsOutput = new File(jsDir, baseName + "_" + serial + ".txt");
            final File tokenOutput = new File(tokenDir, baseName + "_" + serial + ".txt");
            try (final FileOutputStream fos = new FileOutputStream(classOutput)) {
                fos.write(mainClassBytes);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try (final FileOutputStream fos = new FileOutputStream(jsOutput)) {
                final UintMap properties = new UintMap(1);
                properties.put(1, 4);
                final String source = Decompiler.decompile(encodedSource, 2, properties);
                fos.write(source.getBytes());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try (final FileOutputStream fos = new FileOutputStream(tokenOutput)) {
                final StringBuilder sb = new StringBuilder();
                try {
                    for (int i = 0; i < encodedSource.length(); ++i) {
                        final int token = encodedSource.charAt(i);
                        if (Token.isValidToken(encodedSource.charAt(i))) {
                            if (token == 40 || token == 42 || token == 51) {
                                sb.append(Token.typeToName(token)).append(": ");
                                i = Decompiler.printSourceString(encodedSource, i + 1, true, sb) - 1;
                                sb.append("\n");
                            }
                            else {
                                sb.append(Token.typeToName(token)).append("\n");
                            }
                        }
                    }
                }
                catch (Exception ex) {}
                fos.write(sb.toString().getBytes());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            for (int j = 0; j < this.scriptOrFnNodes.length; ++j) {
                final File outputNodes = new File(nodeDir, baseName + "_" + serial + "_" + j + ".txt");
                try (final FileOutputStream fos2 = new FileOutputStream(outputNodes)) {
                    final StringBuilder sb2 = new StringBuilder();
                    final Node root = (Node)this.scriptOrFnNodes[j];
                    this.printNodeTree(root, sb2, "");
                    fos2.write(sb2.toString().getBytes());
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return new Object[] { mainClassName, mainClassBytes };
    }
    
    private void printNodeTree(final Node root, final StringBuilder sb, final String currentIndent) {
        sb.append(currentIndent).append(Token.typeToName(root.getType())).append("\n");
        Node currentChild = root.getFirstChild();
        while (currentChild != null) {
            this.printNodeTree(currentChild, sb, currentIndent + "  ");
            currentChild = currentChild.getNext();
            if (currentChild == root.getLastChild()) {
                return;
            }
        }
    }
    
    public Script createScriptObject(final Object bytecode, final Object staticSecurityDomain) {
        final Class<?> cl = this.defineClass(bytecode, staticSecurityDomain);
        Script script;
        try {
            script = (Script)cl.newInstance();
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to instantiate compiled class:" + ex.toString());
        }
        return script;
    }
    
    public Function createFunctionObject(final Context cx, final Scriptable scope, final Object bytecode, final Object staticSecurityDomain) {
        final Class<?> cl = this.defineClass(bytecode, staticSecurityDomain);
        NativeFunction f;
        try {
            final Constructor<?> ctor = cl.getConstructors()[0];
            final Object[] initArgs = { scope, cx, 0 };
            f = (NativeFunction)ctor.newInstance(initArgs);
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to instantiate compiled class:" + ex.toString());
        }
        return (Function)f;
    }
    
    private Class<?> defineClass(final Object bytecode, final Object staticSecurityDomain) {
        final Object[] nameBytesPair = (Object[])bytecode;
        final String className = (String)nameBytesPair[0];
        final byte[] classBytes = (byte[])nameBytesPair[1];
        final ClassLoader rhinoLoader = this.getClass().getClassLoader();
        final GeneratedClassLoader loader = SecurityController.createLoader(rhinoLoader, staticSecurityDomain);
        try {
            final Class<?> cl = (Class<?>)loader.defineClass(className, classBytes);
            loader.linkClass((Class)cl);
            return cl;
        }
        catch (SecurityException | IllegalArgumentException ex2) {
            final Exception ex;
            final Exception e;
            final RuntimeException x = (RuntimeException)(e = ex);
            throw new RuntimeException("Malformed optimizer package " + e);
        }
    }
    
    public byte[] compileToClassFile(final CompilerEnvirons compilerEnv, final String mainClassName, ScriptNode scriptOrFn, final String encodedSource, final boolean returnFunction) {
        this.compilerEnv = compilerEnv;
        this.transform(scriptOrFn);
        if (returnFunction) {
            scriptOrFn = (ScriptNode)scriptOrFn.getFunctionNode(0);
        }
        this.initScriptNodesData(scriptOrFn);
        this.mainClassName = mainClassName;
        this.mainClassSignature = ClassFileWriter.classNameToSignature(mainClassName);
        return this.generateCode(encodedSource);
    }
    
    private void transform(final ScriptNode tree) {
        initOptFunctions_r(tree);
        final int optLevel = this.compilerEnv.getOptimizationLevel();
        Map<String, OptFunctionNode> possibleDirectCalls = null;
        if (optLevel > 0 && tree.getType() == 146) {
            for (int functionCount = tree.getFunctionCount(), i = 0; i != functionCount; ++i) {
                final OptFunctionNode ofn = OptFunctionNode.get(tree, i);
                if (ofn.fnode.getFunctionType() == 1) {
                    final String name = ofn.fnode.getName();
                    if (name.length() != 0) {
                        if (possibleDirectCalls == null) {
                            possibleDirectCalls = new HashMap<String, OptFunctionNode>();
                        }
                        possibleDirectCalls.put(name, ofn);
                    }
                }
            }
        }
        if (possibleDirectCalls != null) {
            this.directCallTargets = new ObjArray();
        }
        final OptTransformer ot = new OptTransformer(possibleDirectCalls, this.directCallTargets);
        ot.transform(tree, this.compilerEnv);
        if (optLevel > 0) {
            new Optimizer().optimize(tree);
        }
    }
    
    private static void initOptFunctions_r(final ScriptNode scriptOrFn) {
        for (int i = 0, N = scriptOrFn.getFunctionCount(); i != N; ++i) {
            final FunctionNode fn = scriptOrFn.getFunctionNode(i);
            new OptFunctionNode(fn);
            initOptFunctions_r((ScriptNode)fn);
        }
    }
    
    private void initScriptNodesData(final ScriptNode scriptOrFn) {
        final ObjArray x = new ObjArray();
        collectScriptNodes_r(scriptOrFn, x);
        final int count = x.size();
        x.toArray((Object[])(this.scriptOrFnNodes = new ScriptNode[count]));
        this.scriptOrFnIndexes = new ObjToIntMap(count);
        for (int i = 0; i != count; ++i) {
            this.scriptOrFnIndexes.put((Object)this.scriptOrFnNodes[i], i);
        }
    }
    
    private static void collectScriptNodes_r(final ScriptNode n, final ObjArray x) {
        x.add((Object)n);
        for (int nestedCount = n.getFunctionCount(), i = 0; i != nestedCount; ++i) {
            collectScriptNodes_r((ScriptNode)n.getFunctionNode(i), x);
        }
    }
    
    private byte[] generateCode(final String encodedSource) {
        final boolean hasScript = this.scriptOrFnNodes[0].getType() == 146;
        final boolean hasFunctions = this.scriptOrFnNodes.length > 1 || !hasScript;
        final boolean isStrictMode = this.scriptOrFnNodes[0].isInStrictMode();
        String sourceFile = null;
        if (this.compilerEnv.isGenerateDebugInfo()) {
            sourceFile = this.scriptOrFnNodes[0].getSourceName();
        }
        final ClassFileWriter cfw = new ClassFileWriter(this.mainClassName, "org.mozilla.javascript.NativeFunction", sourceFile);
        cfw.addField("_id", "I", (short)2);
        if (hasFunctions) {
            this.generateFunctionConstructor(cfw);
        }
        if (hasScript) {
            cfw.addInterface("org/mozilla/javascript/Script");
            this.generateScriptCtor(cfw);
            this.generateMain(cfw);
            this.generateExecute(cfw);
        }
        this.generateCallMethod(cfw, isStrictMode);
        this.generateResumeGenerator(cfw);
        this.generateNativeFunctionOverrides(cfw, encodedSource);
        for (int count = this.scriptOrFnNodes.length, i = 0; i != count; ++i) {
            final ScriptNode n = this.scriptOrFnNodes[i];
            final BodyCodegen bodygen = new BodyCodegen();
            bodygen.cfw = cfw;
            bodygen.codegen = this;
            bodygen.compilerEnv = this.compilerEnv;
            bodygen.scriptOrFn = n;
            bodygen.scriptOrFnIndex = i;
            if (n instanceof FunctionNode && ((FunctionNode)n).isClassConstructor()) {
                bodygen.currentCtorClass = true;
            }
            bodygen.generateBodyCode();
            if (n.getType() == 114 || n.getType() == 135) {
                final OptFunctionNode ofn = OptFunctionNode.get(n);
                this.generateFunctionInit(cfw, ofn);
                if (ofn.isTargetOfDirectCall()) {
                    this.emitDirectConstructor(cfw, ofn);
                }
            }
        }
        this.emitRegExpInit(cfw);
        this.emitConstantDudeInitializers(cfw);
        return cfw.toByteArray();
    }
    
    private void emitDirectConstructor(final ClassFileWriter cfw, final OptFunctionNode ofn) {
        cfw.startMethod(this.getDirectCtorName((ScriptNode)ofn.fnode), this.getBodyMethodSignature((ScriptNode)ofn.fnode), (short)10);
        final int argCount = ofn.fnode.getParamCount();
        final int firstLocal = 4 + argCount * 3 + 1;
        cfw.addALoad(0);
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.addInvoke(182, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        cfw.addAStore(firstLocal);
        cfw.addALoad(0);
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.addALoad(firstLocal);
        for (int i = 0; i < argCount; ++i) {
            cfw.addALoad(4 + i * 3);
            cfw.addDLoad(5 + i * 3);
        }
        cfw.addALoad(4 + argCount * 3);
        cfw.addInvoke(184, this.mainClassName, this.getBodyMethodName((ScriptNode)ofn.fnode), this.getBodyMethodSignature((ScriptNode)ofn.fnode));
        final int exitLabel = cfw.acquireLabel();
        cfw.add(89);
        cfw.add(193, "org/mozilla/javascript/Scriptable");
        cfw.add(153, exitLabel);
        cfw.add(192, "org/mozilla/javascript/Scriptable");
        cfw.add(176);
        cfw.markLabel(exitLabel);
        cfw.addALoad(firstLocal);
        cfw.add(176);
        cfw.stopMethod((short)(firstLocal + 1));
    }
    
    static boolean isGenerator(final ScriptNode node) {
        return node.getType() == 114 && ((FunctionNode)node).isGenerator();
    }
    
    private void generateResumeGenerator(final ClassFileWriter cfw) {
        boolean hasGenerators = false;
        for (int i = 0; i < this.scriptOrFnNodes.length; ++i) {
            if (isGenerator(this.scriptOrFnNodes[i])) {
                hasGenerators = true;
            }
        }
        if (!hasGenerators) {
            return;
        }
        cfw.startMethod("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short)17);
        cfw.addALoad(0);
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.addALoad(4);
        cfw.addALoad(5);
        cfw.addILoad(3);
        cfw.addLoadThis();
        cfw.add(180, cfw.getClassName(), "_id", "I");
        final int startSwitch = cfw.addTableSwitch(0, this.scriptOrFnNodes.length - 1);
        cfw.markTableSwitchDefault(startSwitch);
        final int endlabel = cfw.acquireLabel();
        for (int j = 0; j < this.scriptOrFnNodes.length; ++j) {
            final ScriptNode n = this.scriptOrFnNodes[j];
            cfw.markTableSwitchCase(startSwitch, j, 6);
            if (isGenerator(n)) {
                final String type = "(" + this.mainClassSignature + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;";
                cfw.addInvoke(184, this.mainClassName, this.getBodyMethodName(n) + "_gen", type);
                cfw.add(176);
            }
            else {
                cfw.add(167, endlabel);
            }
        }
        cfw.markLabel(endlabel);
        pushUndefined(cfw);
        cfw.add(176);
        cfw.stopMethod((short)6);
    }
    
    private void generateCallMethod(final ClassFileWriter cfw, final boolean isStrictMode) {
        cfw.startMethod("call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short)17);
        final int nonTopCallLabel = cfw.acquireLabel();
        cfw.addALoad(1);
        cfw.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        cfw.add(154, nonTopCallLabel);
        cfw.addALoad(0);
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.addALoad(3);
        cfw.addALoad(4);
        cfw.addPush(isStrictMode);
        cfw.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        cfw.add(176);
        cfw.markLabel(nonTopCallLabel);
        cfw.addALoad(0);
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.addALoad(3);
        cfw.addALoad(4);
        final int end = this.scriptOrFnNodes.length;
        final boolean generateSwitch = 2 <= end;
        int switchStart = 0;
        int switchStackTop = 0;
        if (generateSwitch) {
            cfw.addLoadThis();
            cfw.add(180, cfw.getClassName(), "_id", "I");
            switchStart = cfw.addTableSwitch(1, end - 1);
        }
        for (int i = 0; i != end; ++i) {
            final ScriptNode n = this.scriptOrFnNodes[i];
            if (generateSwitch) {
                if (i == 0) {
                    cfw.markTableSwitchDefault(switchStart);
                    switchStackTop = cfw.getStackTop();
                }
                else {
                    cfw.markTableSwitchCase(switchStart, i - 1, switchStackTop);
                }
            }
            if (n.getType() == 114) {
                final OptFunctionNode ofn = OptFunctionNode.get(n);
                final FunctionNode fnode = ofn.fnode;
                if (fnode.isClassConstructor()) {
                    final int callableLabel = cfw.acquireLabel();
                    cfw.addALoad(3);
                    cfw.addPush("new.target");
                    cfw.addInvoke(184, "org/mozilla/javascript/ScriptableObject", "hasProperty", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Z");
                    cfw.add(154, callableLabel);
                    cfw.addPush("msg.class.not.callable");
                    cfw.addInvoke(184, "org.mozilla.javascript.ScriptRuntime", "typeError0", "(Ljava/lang/String;)Lorg/mozilla/javascript/EcmaError;");
                    cfw.add(191);
                    cfw.markLabel(callableLabel);
                }
                if (fnode.isInStrictMode()) {
                    final int callableLabel = cfw.acquireLabel();
                    cfw.addALoad(3);
                    cfw.addPush("new.target");
                    cfw.addInvoke(184, "org/mozilla/javascript/ScriptableObject", "hasProperty", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Z");
                    cfw.add(154, callableLabel);
                    cfw.add(95);
                    cfw.add(87);
                    pushScriptableUndefined(cfw);
                    cfw.add(95);
                    cfw.markLabel(callableLabel);
                }
                if (ofn.isTargetOfDirectCall()) {
                    final int pcount = fnode.getParamCount();
                    if (pcount != 0) {
                        for (int p = 0; p != pcount; ++p) {
                            cfw.add(190);
                            cfw.addPush(p);
                            final int undefArg = cfw.acquireLabel();
                            final int beyond = cfw.acquireLabel();
                            cfw.add(164, undefArg);
                            cfw.addALoad(4);
                            cfw.addPush(p);
                            cfw.add(50);
                            cfw.add(167, beyond);
                            cfw.markLabel(undefArg);
                            pushUndefined(cfw);
                            cfw.markLabel(beyond);
                            cfw.adjustStackTop(-1);
                            cfw.addPush(0.0);
                            cfw.addALoad(4);
                        }
                    }
                }
            }
            cfw.addInvoke(184, this.mainClassName, this.getBodyMethodName(n), this.getBodyMethodSignature(n));
            cfw.add(176);
        }
        cfw.stopMethod((short)5);
    }
    
    private void generateMain(final ClassFileWriter cfw) {
        cfw.startMethod("main", "([Ljava/lang/String;)V", (short)9);
        cfw.add(187, cfw.getClassName());
        cfw.add(89);
        cfw.addInvoke(183, cfw.getClassName(), "<init>", "()V");
        cfw.add(42);
        cfw.addInvoke(184, this.mainMethodClass, "main", "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        cfw.add(177);
        cfw.stopMethod((short)1);
    }
    
    private void generateExecute(final ClassFileWriter cfw) {
        cfw.startMethod("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short)17);
        final int CONTEXT_ARG = 1;
        final int SCOPE_ARG = 2;
        cfw.addLoadThis();
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.add(89);
        cfw.add(1);
        cfw.addInvoke(182, cfw.getClassName(), "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        cfw.add(176);
        cfw.stopMethod((short)3);
    }
    
    private void generateScriptCtor(final ClassFileWriter cfw) {
        cfw.startMethod("<init>", "()V", (short)1);
        cfw.addLoadThis();
        cfw.addInvoke(183, "org.mozilla.javascript.NativeFunction", "<init>", "()V");
        cfw.addLoadThis();
        cfw.addPush(0);
        cfw.add(181, cfw.getClassName(), "_id", "I");
        cfw.add(177);
        cfw.stopMethod((short)1);
    }
    
    private void generateFunctionConstructor(final ClassFileWriter cfw) {
        final int SCOPE_ARG = 1;
        final int CONTEXT_ARG = 2;
        final int ID_ARG = 3;
        cfw.startMethod("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V", (short)1);
        cfw.addALoad(0);
        cfw.addInvoke(183, "org.mozilla.javascript.NativeFunction", "<init>", "()V");
        cfw.addLoadThis();
        cfw.addILoad(3);
        cfw.add(181, cfw.getClassName(), "_id", "I");
        cfw.addLoadThis();
        cfw.addALoad(2);
        cfw.addALoad(1);
        final int start = (this.scriptOrFnNodes[0].getType() == 146) ? 1 : 0;
        final int end = this.scriptOrFnNodes.length;
        if (start == end) {
            throw badTree();
        }
        final boolean generateSwitch = 2 <= end - start;
        int switchStart = 0;
        int switchStackTop = 0;
        if (generateSwitch) {
            cfw.addILoad(3);
            switchStart = cfw.addTableSwitch(start + 1, end - 1);
        }
        for (int i = start; i != end; ++i) {
            if (generateSwitch) {
                if (i == start) {
                    cfw.markTableSwitchDefault(switchStart);
                    switchStackTop = cfw.getStackTop();
                }
                else {
                    cfw.markTableSwitchCase(switchStart, i - 1 - start, switchStackTop);
                }
            }
            final OptFunctionNode ofn = OptFunctionNode.get(this.scriptOrFnNodes[i]);
            cfw.addInvoke(183, this.mainClassName, this.getFunctionInitMethodName(ofn), "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V");
            cfw.add(177);
        }
        cfw.stopMethod((short)4);
    }
    
    private void generateFunctionInit(final ClassFileWriter cfw, final OptFunctionNode ofn) {
        final int CONTEXT_ARG = 1;
        final int SCOPE_ARG = 2;
        cfw.startMethod(this.getFunctionInitMethodName(ofn), "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V", (short)18);
        cfw.addLoadThis();
        cfw.addALoad(1);
        cfw.addALoad(2);
        cfw.addInvoke(182, "org/mozilla/javascript/NativeFunction", "initScriptFunction", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V");
        if (ofn.fnode.getRegexpCount() != 0) {
            cfw.addALoad(1);
            cfw.addInvoke(184, this.mainClassName, "_reInit", "(Lorg/mozilla/javascript/Context;)V");
        }
        cfw.add(177);
        cfw.stopMethod((short)3);
    }
    
    private void generateNativeFunctionOverrides(final ClassFileWriter cfw, final String encodedSource) {
        cfw.startMethod("getLanguageVersion", "()I", (short)1);
        cfw.addPush(this.compilerEnv.getLanguageVersion());
        cfw.add(172);
        cfw.stopMethod((short)1);
        final int Do_getFunctionName = 0;
        final int Do_getParamCount = 1;
        final int Do_getParamAndVarCount = 2;
        final int Do_getParamOrVarName = 3;
        final int Do_getEncodedSource = 4;
        final int Do_getParamOrVarConst = 5;
        final int Do_construct = 6;
        final int Do_hasRest = 7;
        final int Do_isCallable = 8;
        final int Do_isVarLexical = 9;
        final int SWITCH_COUNT = 10;
        for (int methodIndex = 0; methodIndex != 10; ++methodIndex) {
            if (methodIndex != 4 || encodedSource != null) {
                short methodLocals = 0;
                switch (methodIndex) {
                    case 0: {
                        methodLocals = 1;
                        cfw.startMethod("getFunctionName", "()Ljava/lang/String;", (short)1);
                        break;
                    }
                    case 1: {
                        methodLocals = 1;
                        cfw.startMethod("getParamCount", "()I", (short)1);
                        break;
                    }
                    case 2: {
                        methodLocals = 1;
                        cfw.startMethod("getParamAndVarCount", "()I", (short)1);
                        break;
                    }
                    case 3: {
                        methodLocals = 2;
                        cfw.startMethod("getParamOrVarName", "(I)Ljava/lang/String;", (short)1);
                        break;
                    }
                    case 5: {
                        methodLocals = 3;
                        cfw.startMethod("getParamOrVarConst", "(I)Z", (short)1);
                        break;
                    }
                    case 4: {
                        methodLocals = 1;
                        cfw.startMethod("getEncodedSource", "()Ljava/lang/String;", (short)1);
                        cfw.addPush(encodedSource);
                        break;
                    }
                    case 6: {
                        methodLocals = 4;
                        cfw.startMethod("construct", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short)1);
                        break;
                    }
                    case 7: {
                        methodLocals = 1;
                        cfw.startMethod("hasRest", "()Z", (short)1);
                        break;
                    }
                    case 8: {
                        methodLocals = 1;
                        cfw.startMethod("isCallable", "()Z", (short)1);
                        break;
                    }
                    case 9: {
                        methodLocals = 2;
                        cfw.startMethod("isVarLexical", "(I)Z", (short)1);
                        break;
                    }
                    default: {
                        throw Kit.codeBug();
                    }
                }
                final int count = this.scriptOrFnNodes.length;
                int switchStart = 0;
                int switchStackTop = 0;
                if (count > 1) {
                    cfw.addLoadThis();
                    cfw.add(180, cfw.getClassName(), "_id", "I");
                    switchStart = cfw.addTableSwitch(1, count - 1);
                }
                for (int i = 0; i != count; ++i) {
                    final ScriptNode n = this.scriptOrFnNodes[i];
                    if (i == 0) {
                        if (count > 1) {
                            cfw.markTableSwitchDefault(switchStart);
                            switchStackTop = cfw.getStackTop();
                        }
                    }
                    else {
                        cfw.markTableSwitchCase(switchStart, i - 1, switchStackTop);
                    }
                    switch (methodIndex) {
                        case 0: {
                            if (n.getType() == 146) {
                                cfw.addPush("");
                            }
                            else {
                                final String name = ((FunctionNode)n).getName();
                                cfw.addPush(name);
                            }
                            cfw.add(176);
                            break;
                        }
                        case 1: {
                            cfw.addPush(n.getParamCount());
                            cfw.add(172);
                            break;
                        }
                        case 2: {
                            cfw.addPush(n.getParamAndVarCount());
                            cfw.add(172);
                            break;
                        }
                        case 3: {
                            final int paramAndVarCount = n.getParamAndVarCount();
                            if (paramAndVarCount == 0) {
                                cfw.add(1);
                                cfw.add(176);
                                break;
                            }
                            if (paramAndVarCount == 1) {
                                cfw.addPush(n.getParamOrVarName(0));
                                cfw.add(176);
                                break;
                            }
                            cfw.addILoad(1);
                            final int paramSwitchStart = cfw.addTableSwitch(1, paramAndVarCount - 1);
                            for (int j = 0; j != paramAndVarCount; ++j) {
                                if (cfw.getStackTop() != 0) {
                                    Kit.codeBug();
                                }
                                final String s = n.getParamOrVarName(j);
                                if (j == 0) {
                                    cfw.markTableSwitchDefault(paramSwitchStart);
                                }
                                else {
                                    cfw.markTableSwitchCase(paramSwitchStart, j - 1, 0);
                                }
                                cfw.addPush(s);
                                cfw.add(176);
                            }
                            break;
                        }
                        case 5: {
                            final int paramAndVarCount = n.getParamAndVarCount();
                            final boolean[] constness = n.getParamAndVarConst();
                            if (paramAndVarCount == 0) {
                                cfw.add(3);
                                cfw.add(172);
                                break;
                            }
                            if (paramAndVarCount == 1) {
                                cfw.addPush(constness[0]);
                                cfw.add(172);
                                break;
                            }
                            cfw.addILoad(1);
                            final int paramSwitchStart2 = cfw.addTableSwitch(1, paramAndVarCount - 1);
                            for (int k = 0; k != paramAndVarCount; ++k) {
                                if (cfw.getStackTop() != 0) {
                                    Kit.codeBug();
                                }
                                if (k == 0) {
                                    cfw.markTableSwitchDefault(paramSwitchStart2);
                                }
                                else {
                                    cfw.markTableSwitchCase(paramSwitchStart2, k - 1, 0);
                                }
                                cfw.addPush(constness[k]);
                                cfw.add(172);
                            }
                            break;
                        }
                        case 4: {
                            cfw.addPush(n.getEncodedSourceStart());
                            cfw.addPush(n.getEncodedSourceEnd());
                            cfw.addInvoke(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                            cfw.add(176);
                            break;
                        }
                        case 6: {
                            if (n instanceof FunctionNode && (!((FunctionNode)n).isConstructable() || ((FunctionNode)n).isGetterMethod() || ((FunctionNode)n).isSetterMethod())) {
                                cfw.addPush("msg.not.ctor");
                                cfw.addPush(((FunctionNode)n).getName());
                                cfw.addInvoke(184, "org.mozilla.javascript.ScriptRuntime", "typeError1", "(Ljava/lang/String;Ljava/lang/Object;)Lorg/mozilla/javascript/EcmaError;");
                                cfw.add(191);
                                break;
                            }
                            cfw.addALoad(0);
                            cfw.addALoad(1);
                            cfw.addALoad(2);
                            cfw.addALoad(3);
                            cfw.addInvoke(183, "org.mozilla.javascript.BaseFunction", "construct", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
                            cfw.add(176);
                            break;
                        }
                        case 7: {
                            cfw.addPush(n.hasRest());
                            cfw.add(172);
                            break;
                        }
                        case 8: {
                            if (n instanceof FunctionNode) {
                                cfw.addPush(!((FunctionNode)n).isClassConstructor());
                            }
                            else {
                                cfw.add(42);
                                cfw.addInvoke(183, "org/mozilla/javascript/BaseFunction", "isCallable", "()Z");
                            }
                            cfw.add(172);
                            break;
                        }
                        case 9: {
                            final int switchMax = n.getParamAndVarCount();
                            final boolean[] lexicals = n.getParamAndVarLexical();
                            if (switchMax == 0) {
                                cfw.addPush(false);
                                cfw.add(172);
                                break;
                            }
                            if (switchMax == 1) {
                                cfw.addPush(lexicals[0]);
                                cfw.add(172);
                                break;
                            }
                            cfw.addILoad(1);
                            final int varSwitchStart = cfw.addTableSwitch(1, switchMax - 1);
                            for (int varIndex = 0; varIndex < switchMax; ++varIndex) {
                                if (varIndex == 0) {
                                    cfw.markTableSwitchDefault(varSwitchStart);
                                }
                                else {
                                    cfw.markTableSwitchCase(varSwitchStart, varIndex - 1);
                                }
                                cfw.addPush(lexicals[varIndex]);
                                cfw.add(172);
                            }
                            break;
                        }
                        default: {
                            throw Kit.codeBug();
                        }
                    }
                }
                cfw.stopMethod(methodLocals);
            }
        }
    }
    
    private void emitRegExpInit(final ClassFileWriter cfw) {
        int totalRegCount = 0;
        for (int i = 0; i != this.scriptOrFnNodes.length; ++i) {
            totalRegCount += this.scriptOrFnNodes[i].getRegexpCount();
        }
        if (totalRegCount == 0) {
            return;
        }
        cfw.startMethod("_reInit", "(Lorg/mozilla/javascript/Context;)V", (short)10);
        cfw.addField("_reInitDone", "Z", (short)74);
        cfw.add(178, this.mainClassName, "_reInitDone", "Z");
        final int doInit = cfw.acquireLabel();
        cfw.add(153, doInit);
        cfw.add(177);
        cfw.markLabel(doInit);
        cfw.addALoad(0);
        cfw.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        cfw.addAStore(1);
        for (int j = 0; j != this.scriptOrFnNodes.length; ++j) {
            final ScriptNode n = this.scriptOrFnNodes[j];
            for (int regCount = n.getRegexpCount(), k = 0; k != regCount; ++k) {
                final String reFieldName = this.getCompiledRegexpName(n, k);
                final String reFieldType = "Ljava/lang/Object;";
                final String reString = n.getRegexpString(k);
                final String reFlags = n.getRegexpFlags(k);
                cfw.addField(reFieldName, reFieldType, (short)10);
                cfw.addALoad(1);
                cfw.addALoad(0);
                cfw.addPush(reString);
                if (reFlags == null) {
                    cfw.add(1);
                }
                else {
                    cfw.addPush(reFlags);
                }
                cfw.addInvoke(185, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                cfw.add(179, this.mainClassName, reFieldName, reFieldType);
            }
        }
        cfw.addPush(1);
        cfw.add(179, this.mainClassName, "_reInitDone", "Z");
        cfw.add(177);
        cfw.stopMethod((short)2);
    }
    
    private void emitConstantDudeInitializers(final ClassFileWriter cfw) {
        final int N = this.itsConstantListSize;
        if (N == 0) {
            return;
        }
        cfw.startMethod("<clinit>", "()V", (short)24);
        final double[] array = this.itsConstantList;
        for (int i = 0; i != N; ++i) {
            final double num = array[i];
            final String constantName = "_k" + i;
            final String constantType = getStaticConstantWrapperType(num);
            cfw.addField(constantName, constantType, (short)10);
            final int inum = (int)num;
            if (inum == num) {
                cfw.addPush(inum);
                cfw.addInvoke(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            else {
                cfw.addPush(num);
                addDoubleWrap(cfw);
            }
            cfw.add(179, this.mainClassName, constantName, constantType);
        }
        cfw.add(177);
        cfw.stopMethod((short)0);
    }
    
    void pushNumberAsObject(final ClassFileWriter cfw, final double num) {
        if (num == 0.0) {
            if (1.0 / num > 0.0) {
                cfw.add(178, "org/mozilla/javascript/optimizer/OptRuntime", "zeroObj", "Ljava/lang/Double;");
            }
            else {
                cfw.addPush(num);
                addDoubleWrap(cfw);
            }
        }
        else {
            if (num == 1.0) {
                cfw.add(178, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
                return;
            }
            if (num == -1.0) {
                cfw.add(178, "org/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
            }
            else if (Double.isNaN(num)) {
                cfw.add(178, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
            }
            else if (this.itsConstantListSize >= 2000) {
                cfw.addPush(num);
                addDoubleWrap(cfw);
            }
            else {
                final int N = this.itsConstantListSize;
                int index = 0;
                if (N == 0) {
                    this.itsConstantList = new double[64];
                }
                else {
                    double[] array;
                    for (array = this.itsConstantList; index != N && array[index] != num; ++index) {}
                    if (N == array.length) {
                        array = new double[N * 2];
                        System.arraycopy(this.itsConstantList, 0, array, 0, N);
                        this.itsConstantList = array;
                    }
                }
                if (index == N) {
                    this.itsConstantList[N] = num;
                    this.itsConstantListSize = N + 1;
                }
                final String constantName = "_k" + index;
                final String constantType = getStaticConstantWrapperType(num);
                cfw.add(178, this.mainClassName, constantName, constantType);
            }
        }
    }
    
    private static void addDoubleWrap(final ClassFileWriter cfw) {
        cfw.addInvoke(184, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }
    
    private static String getStaticConstantWrapperType(final double num) {
        final int inum = (int)num;
        if (inum == num) {
            return "Ljava/lang/Integer;";
        }
        return "Ljava/lang/Double;";
    }
    
    static void pushUndefined(final ClassFileWriter cfw) {
        cfw.add(178, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }
    
    static void pushScriptableUndefined(final ClassFileWriter cfw) {
        cfw.add(178, "org/mozilla/javascript/Undefined", "SCRIPTABLE_UNDEFINED", "Lorg/mozilla/javascript/Scriptable;");
    }
    
    int getIndex(final ScriptNode n) {
        return this.scriptOrFnIndexes.getExisting((Object)n);
    }
    
    String getDirectCtorName(final ScriptNode n) {
        return "_n" + this.getIndex(n);
    }
    
    String getBodyMethodName(final ScriptNode n) {
        return "_c_" + this.cleanName(n) + "_" + this.getIndex(n);
    }
    
    String cleanName(final ScriptNode n) {
        String result = "";
        if (n instanceof FunctionNode) {
            final Name name = ((FunctionNode)n).getFunctionName();
            if (name == null) {
                result = "anonymous";
            }
            else {
                result = name.getIdentifier();
            }
        }
        else {
            result = "script";
        }
        return result;
    }
    
    String getBodyMethodSignature(final ScriptNode n) {
        final StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.mainClassSignature);
        sb.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (n.getType() == 114) {
            final OptFunctionNode ofn = OptFunctionNode.get(n);
            if (ofn.isTargetOfDirectCall()) {
                for (int pCount = ofn.fnode.getParamCount(), i = 0; i != pCount; ++i) {
                    sb.append("Ljava/lang/Object;D");
                }
            }
        }
        sb.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return sb.toString();
    }
    
    String getFunctionInitMethodName(final OptFunctionNode ofn) {
        return "_i" + this.getIndex((ScriptNode)ofn.fnode);
    }
    
    String getCompiledRegexpName(final ScriptNode n, final int regexpIndex) {
        return "_re" + this.getIndex(n) + "_" + regexpIndex;
    }
    
    static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }
    
    public void setMainMethodClass(final String className) {
        this.mainMethodClass = className;
    }
    
    static {
        globalLock = new Object();
    }
}
