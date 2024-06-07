//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.optimizer.*;
import java.io.*;
import org.mozilla.javascript.decorators.*;
import java.util.function.*;
import java.util.stream.*;
import org.mozilla.javascript.ast.*;
import java.util.*;

public final class IRFactory extends Parser
{
    private static final int LOOP_DO_WHILE = 0;
    private static final int LOOP_WHILE = 1;
    private static final int LOOP_FOR = 2;
    private static final int ALWAYS_TRUE_BOOLEAN = 1;
    private static final int ALWAYS_FALSE_BOOLEAN = -1;
    private Decompiler decompiler;
    public static Object GENERATED_SUPER;
    
    public IRFactory() {
        this.decompiler = new Decompiler();
    }
    
    public IRFactory(final CompilerEnvirons env) {
        this(env, env.getErrorReporter());
    }
    
    public IRFactory(final CompilerEnvirons env, final ErrorReporter errorReporter) {
        super(env, errorReporter);
        this.decompiler = new Decompiler();
    }
    
    public ScriptNode transformTree(final AstRoot root) {
        this.currentScriptOrFn = (ScriptNode)root;
        this.inUseStrictDirective = root.isInStrictMode();
        final int sourceStartOffset = this.decompiler.getCurrentOffset();
        final ScriptNode script = (ScriptNode)this.transform((AstNode)root);
        final int sourceEndOffset = this.decompiler.getCurrentOffset();
        script.setEncodedSourceBounds(sourceStartOffset, sourceEndOffset);
        if (this.compilerEnv.isGeneratingSource()) {
            script.setEncodedSource(this.decompiler.getEncodedSource());
        }
        String baseName = "c";
        if (script.getSourceName().length() > 0) {
            baseName = script.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(baseName.charAt(0))) {
                baseName = "_" + baseName;
            }
        }
        final String mainClassName = "org.mozilla.javascript.gen." + baseName + "_" + (Codegen.globalSerialClassCounter + 1);
        final File debugOutputPath = Context.getContext().getDebugOutputPath();
        if (debugOutputPath != null) {
            final File irDir = new File(debugOutputPath, "ir");
            irDir.mkdirs();
            final File outputIR = new File(irDir, mainClassName + ".txt");
            try (final FileOutputStream fos = new FileOutputStream(outputIR)) {
                fos.write(script.toStringTree(script).getBytes());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.decompiler = null;
        return script;
    }
    
    public Node transform(final AstNode node) {
        switch (node.getType()) {
            case 69: {
                return this.transformArrayLiteral((ArrayLiteral)node);
            }
            case 139: {
                return this.transformBlock(node);
            }
            case 129: {
                return this.transformBreak((BreakStatement)node);
            }
            case 39: {
                return this.transformFunctionCall((FunctionCall)node);
            }
            case 115: {
                return this.transformClass((ClassNode)node);
            }
            case 130: {
                return this.transformContinue((ContinueStatement)node);
            }
            case 125: {
                final Assignment assignment = (Assignment)node;
                final Node left = this.transform(assignment.getLeft());
                final Node right = this.transform(assignment.getRight());
                return new Node(125, left, right);
            }
            case 127: {
                return this.transformDoLoop((DoLoop)node);
            }
            case 120:
            case 138: {
                return (Node)node;
            }
            case 119: {
                return this.transformExport((ExportNode)node);
            }
            case 128: {
                if (node instanceof ForInLoop) {
                    return this.transformForInLoop((ForInLoop)node);
                }
                return this.transformForLoop((ForLoop)node);
            }
            case 114: {
                return this.transformFunction((FunctionNode)node);
            }
            case 167: {
                return this.transformGenExpr((GeneratorExpression)node);
            }
            case 37: {
                return this.transformElementGet((ElementGet)node);
            }
            case 34: {
                return this.transformPropertyGet((PropertyGet)node);
            }
            case 103: {
                return this.transformCondExpr((ConditionalExpression)node);
            }
            case 121: {
                return this.transformIf((IfStatement)node);
            }
            case 45:
            case 46:
            case 47:
            case 48:
            case 165: {
                return this.transformLiteral(node);
            }
            case 40: {
                return this.transformName((Name)node);
            }
            case 41: {
                return this.transformNumber((NumberLiteral)node);
            }
            case 31: {
                return this.transformNewExpr((NewExpression)node);
            }
            case 70: {
                return this.transformObjectLiteral((ObjectLiteral)node);
            }
            case 51: {
                return this.transformRegExp((RegExpLiteral)node);
            }
            case 4: {
                return this.transformReturn((ReturnStatement)node);
            }
            case 146: {
                return this.transformScript((ScriptNode)node);
            }
            case 42: {
                return this.transformString((StringLiteral)node);
            }
            case 43: {
                return this.transformTemplate((TemplateLiteral)node);
            }
            case 123: {
                return this.transformSwitch((SwitchStatement)node);
            }
            case 53: {
                if (node instanceof ThrowStatement) {
                    return this.transformThrow((ThrowStatement)node);
                }
                return this.transformThrowExpr((UnaryExpression)node);
            }
            case 78: {
                return this.transformTry((TryStatement)node);
            }
            case 126: {
                return this.transformWhileLoop((WhileLoop)node);
            }
            case 132: {
                return this.transformWith((WithStatement)node);
            }
            case 76: {
                return this.transformYield((Yield)node);
            }
            default: {
                if (node instanceof ExpressionStatement) {
                    return this.transformExprStmt((ExpressionStatement)node);
                }
                if (node instanceof Assignment) {
                    return this.transformAssignment((Assignment)node);
                }
                if (node instanceof UnaryExpression) {
                    return this.transformUnary((UnaryExpression)node);
                }
                if (node instanceof InfixExpression) {
                    return this.transformInfix((InfixExpression)node);
                }
                if (node instanceof VariableDeclaration) {
                    return this.transformVariables((VariableDeclaration)node);
                }
                if (node instanceof ParenthesizedExpression) {
                    return this.transformParenExpr((ParenthesizedExpression)node);
                }
                if (node instanceof LabeledStatement) {
                    return this.transformLabeledStatement((LabeledStatement)node);
                }
                if (node instanceof LetNode) {
                    return this.transformLetNode((LetNode)node);
                }
                if (node instanceof DecoratorNode) {
                    return this.transformDecoratorNode((DecoratorNode)node);
                }
                if (node instanceof DecoratorDeclarationNode) {
                    return (Node)this.transformDecoratorDeclaration((DecoratorDeclarationNode)node);
                }
                throw new IllegalArgumentException("Can't transform: " + node);
            }
        }
    }
    
    private Node transformArrayLiteral(final ArrayLiteral node) {
        if (node.isDestructuring()) {
            return (Node)node;
        }
        this.decompiler.addToken(80);
        final List<AstNode> elems = (List<AstNode>)node.getElements();
        final Node array = new Node(69);
        List<Integer> skipIndexes = null;
        final boolean spreading = node.getProp(29) != null;
        for (int i = 0; i < elems.size(); ++i) {
            final AstNode elem = elems.get(i);
            if (elem.getType() != 138) {
                final Node transformed = this.transform(elem);
                if (elem.getProp(29) != null) {
                    transformed.putProp(29, true);
                }
                array.addChildToBack(transformed);
            }
            else {
                if (spreading) {
                    array.addChildToBack((Node)elem);
                    continue;
                }
                if (skipIndexes == null) {
                    skipIndexes = new ArrayList<Integer>();
                }
                skipIndexes.add(i);
            }
            if (i < elems.size() - 1) {
                this.decompiler.addToken(86);
            }
        }
        if (node.getProp(29) != null) {
            this.decompiler.addToken(110);
            array.putProp(29, true);
        }
        this.decompiler.addToken(81);
        array.putIntProp(21, node.getDestructuringLength());
        if (skipIndexes != null) {
            final int[] skips = new int[skipIndexes.size()];
            for (int j = 0; j < skipIndexes.size(); ++j) {
                skips[j] = skipIndexes.get(j);
            }
            array.putProp(11, skips);
        }
        return array;
    }
    
    private Node transformAssignment(final Assignment node) {
        final AstNode left = this.removeParens(node.getLeft());
        Node target = null;
        if (this.isDestructuring((Node)left)) {
            this.decompile(left);
            target = (Node)left;
        }
        else {
            target = this.transform(left);
        }
        this.decompiler.addToken(node.getType());
        return this.createAssignment(node.getType(), target, this.transform(node.getRight()));
    }
    
    private Node transformBlock(final AstNode node) {
        if (node instanceof Scope) {
            this.pushScope((Scope)node);
        }
        try {
            final List<Node> kids = new ArrayList<Node>();
            for (final Node kid : node) {
                kids.add(this.transform((AstNode)kid));
            }
            node.removeChildren();
            for (final Node kid : kids) {
                node.addChildToBack(kid);
            }
            return (Node)node;
        }
        finally {
            if (node instanceof Scope) {
                this.popScope();
            }
        }
    }
    
    private Node transformBreak(final BreakStatement node) {
        this.decompiler.addToken(129);
        if (node.getBreakLabel() != null) {
            this.decompiler.addName(node.getBreakLabel().getIdentifier());
        }
        this.decompiler.addEOL(79);
        return (Node)node;
    }
    
    private Node transformCondExpr(final ConditionalExpression node) {
        final Node test = this.transform(node.getTestExpression());
        this.decompiler.addToken(103);
        final Node ifTrue = this.transform(node.getTrueExpression());
        this.decompiler.addToken(104);
        final Node ifFalse = this.transform(node.getFalseExpression());
        return this.createCondExpr(test, ifTrue, ifFalse);
    }
    
    private Node transformContinue(final ContinueStatement node) {
        this.decompiler.addToken(130);
        if (node.getLabel() != null) {
            this.decompiler.addName(node.getLabel().getIdentifier());
        }
        this.decompiler.addEOL(79);
        return (Node)node;
    }
    
    private Node transformDoLoop(final DoLoop loop) {
        loop.setType(142);
        this.pushScope((Scope)loop);
        try {
            this.decompiler.addToken(127);
            this.decompiler.addEOL(82);
            final Node body = this.transform(loop.getBody());
            this.decompiler.addToken(83);
            this.decompiler.addToken(126);
            this.decompiler.addToken(84);
            final Node cond = this.transform(loop.getCondition());
            this.decompiler.addToken(85);
            this.decompiler.addEOL(79);
            return this.createLoop((Jump)loop, 0, body, cond, null, null);
        }
        finally {
            this.popScope();
        }
    }
    
    private Node transformExport(final ExportNode node) {
        if (node.getExportedValue() != null) {
            node.addChildToBack(this.transform(node.getExportedValue()));
        }
        return (Node)node;
    }
    
    private Node transformElementGet(final ElementGet node) {
        final Node target = this.transform(node.getTarget());
        final boolean chained = node.getProp(30) != null;
        if (chained) {
            this.decompiler.addToken(111);
        }
        this.decompiler.addToken(80);
        final Node element = this.transform(node.getElement());
        this.decompiler.addToken(81);
        final Node newNode = new Node(37, target, element);
        if (chained) {
            newNode.putProp(30, true);
        }
        return newNode;
    }
    
    private Node transformExprStmt(final ExpressionStatement node) {
        final Node expr = this.transform(node.getExpression());
        this.decompiler.addEOL(79);
        return new Node(node.getType(), expr, node.getLineno());
    }
    
    private Node transformForInLoop(final ForInLoop loop) {
        this.decompiler.addToken(128);
        this.decompiler.addToken(84);
        loop.setType(142);
        this.pushScope((Scope)loop);
        try {
            int declType = -1;
            final AstNode iter = loop.getIterator();
            if (iter instanceof VariableDeclaration) {
                declType = iter.getType();
            }
            final Node lhs = this.transform(iter);
            if (loop.isForOf()) {
                this.decompiler.addName("of ");
            }
            else {
                this.decompiler.addToken(55);
            }
            final Node obj = this.transform(loop.getIteratedObject());
            this.decompiler.addToken(85);
            this.decompiler.addEOL(82);
            final Node body = this.transform(loop.getBody());
            this.decompiler.addEOL(83);
            return this.createForIn(declType, (Node)loop, lhs, obj, body, loop.isForOf());
        }
        finally {
            this.popScope();
        }
    }
    
    private Node transformForLoop(final ForLoop loop) {
        this.decompiler.addToken(128);
        this.decompiler.addToken(84);
        loop.setType(142);
        final Scope savedScope = this.currentScope;
        this.currentScope = (Scope)loop;
        try {
            final Node init = this.transform(loop.getInitializer());
            this.decompiler.addToken(79);
            final Node test = this.transform(loop.getCondition());
            this.decompiler.addToken(79);
            final Node incr = this.transform(loop.getIncrement());
            this.decompiler.addToken(85);
            this.decompiler.addEOL(82);
            final Node body = this.transform(loop.getBody());
            this.decompiler.addEOL(83);
            return this.createFor((Scope)loop, init, test, incr, body);
        }
        finally {
            this.currentScope = savedScope;
        }
    }
    
    private void transformDestructuringParams(final Node root) {
        for (Node child = root.first; child != null; child = child.next) {
            if (child.type == 125) {
                final Node newChild = this.transform((AstNode)child.last);
                child.replaceChild(child.last, newChild);
            }
            else if (child.getProp(28) != null) {
                final Node newChild = this.transform((AstNode)child);
                root.replaceChild(child, newChild);
            }
            else {
                this.transformDestructuringParams(child);
            }
        }
    }
    
    private Node transformFunction(final FunctionNode fn) {
        final int functionType = fn.getFunctionType();
        final int start = this.decompiler.markFunctionStart(functionType);
        final int index = this.currentScriptOrFn.addFunction(fn);
        final PerFunctionVariables savedVars = new PerFunctionVariables(fn);
        try {
            this.decompileFunctionHeader(fn);
            final Node destructuring = (Node)fn.getProp(23);
            if (destructuring != null) {
                this.transformDestructuringParams(destructuring);
            }
            fn.removeProp(23);
            final int lineno = fn.getBody().getLineno();
            ++this.nestingOfFunction;
            final Node body = this.transform(fn.getBody());
            if (!fn.isExpressionClosure()) {
                this.decompiler.addToken(83);
            }
            if (fn instanceof DecoratorDeclarationNode) {
                for (final DecoratorNode dn2 : ((DecoratorDeclarationNode)fn).getDecoratorNodes()) {
                    this.transformDecoratorNode(dn2);
                }
            }
            final List<AstNode> initializers = (List<AstNode>)fn.getProp(36);
            if (initializers != null) {
                for (final AstNode initializer : initializers) {
                    if (initializer instanceof ClassNode) {
                        final List<Node> dns = (List<Node>)((ClassNode)initializer).getDecorators().stream().filter(dn -> dn.getDecoratorType() == DecoratorType.INITIALIZE).map(this::transformDecoratorNode).collect(Collectors.toList());
                        initializer.putProp(33, (Object)dns);
                    }
                    else {
                        if (!(initializer instanceof ClassElement)) {
                            throw Kit.codeBug();
                        }
                        final List<Node> dns = (List<Node>)((ClassElement)initializer).getDecorators().stream().filter(dn -> dn.getDecoratorType() == DecoratorType.INITIALIZE).map(this::transformDecoratorNode).collect(Collectors.toList());
                        initializer.putProp(33, (Object)dns);
                    }
                }
            }
            fn.setEncodedSourceBounds(start, this.decompiler.markFunctionEnd(start));
            if (functionType != 2 && !fn.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (destructuring != null) {
                body.addChildToFront(new Node(143, destructuring, lineno));
            }
            final int syntheticType = fn.getFunctionType();
            final Node pn = this.initFunction(fn, index, body, syntheticType);
            return pn;
        }
        finally {
            --this.nestingOfFunction;
            savedVars.restore();
        }
    }
    
    private DecoratorDeclarationNode transformDecoratorDeclaration(final DecoratorDeclarationNode node) {
        node.setBody((AstNode)new Block());
        node.setFunctionType(1);
        final List<DecoratorNode> dns = (List<DecoratorNode>)node.getDecoratorNodes();
        if (dns.stream().anyMatch(it -> it.getDecoratorType() == DecoratorType.NUMERICTEMPLATE) && dns.size() != 1) {
            throw ScriptRuntime.typeError("User-defined decorator cannot contain @numericTemplate with any other decorator");
        }
        this.transformFunction((FunctionNode)node);
        return node;
    }
    
    private Node transformDecoratorNode(final DecoratorNode dn) {
        for (final AstNode arg : dn.getArguments()) {
            dn.addChildToBack(this.transform(arg));
        }
        return (Node)dn;
    }
    
    private Node transformClass(final ClassNode node) {
        if (node.getExtendsName() != null) {
            node.setExtended(this.transform(node.getExtendsName()));
        }
        FunctionNode fn = node.getConstructor();
        if (fn == null) {
            fn = new FunctionNode();
            final Block body = new Block();
            if (node.getExtended() != null) {
                final FunctionCall superCall = new FunctionCall();
                final Name superName = new Name();
                superName.setString("super");
                superName.putProp(31, IRFactory.GENERATED_SUPER);
                superCall.setTarget((AstNode)superName);
                final ExpressionStatement expr = new ExpressionStatement((AstNode)superCall);
                body.addStatement((AstNode)expr);
            }
            fn.setBody((AstNode)body);
        }
        fn.setFunctionName(node.getClassName());
        fn.setFunctionType(2);
        fn.setParentClass(node);
        List<Node> decorators = new ArrayList<Node>();
        for (final DecoratorNode dn2 : node.getDecorators()) {
            if (dn2.getDecoratorType() == DecoratorType.INITIALIZE) {
                continue;
            }
            decorators.add(this.transformDecoratorNode(dn2));
        }
        final List<AstNode> initializers = (List<AstNode>)node.getMethods().stream().filter(cm -> cm.getDecorators().stream().anyMatch(dn -> dn.getDecoratorType() == DecoratorType.INITIALIZE)).collect(Collectors.toList());
        initializers.addAll((Collection<? extends AstNode>)node.getFields().stream().filter(cf -> cf.getDecorators().stream().anyMatch(dn -> dn.getDecoratorType() == DecoratorType.INITIALIZE)).collect(Collectors.toList()));
        if (node.getDecorators().stream().anyMatch(dn -> dn.getDecoratorType() == DecoratorType.INITIALIZE)) {
            initializers.add((AstNode)node);
        }
        node.putProp(33, (Object)decorators);
        fn.putProp(36, (Object)initializers);
        final Node transformedFn = this.transform((AstNode)fn);
        node.addChildToBack(transformedFn);
        node.setParentFn(transformedFn);
        for (final ClassMethod cm2 : node.getMethods()) {
            cm2.setNameKey(this.getPropKey((Node)cm2.getName()));
            cm2.addChildToBack(this.transform((AstNode)cm2.getFunction()));
            decorators = new ArrayList<Node>();
            for (final DecoratorNode dn3 : cm2.getDecorators()) {
                if (dn3.getDecoratorType() == DecoratorType.INITIALIZE) {
                    continue;
                }
                decorators.add(this.transformDecoratorNode(dn3));
            }
            cm2.putProp(33, (Object)decorators);
            node.addChildToBack((Node)cm2);
        }
        ScriptNode currentScriptTemp = null;
        for (final ClassField cp : node.getFields()) {
            if (!cp.isStatic()) {
                currentScriptTemp = this.currentScriptOrFn;
                this.currentScriptOrFn = (ScriptNode)fn;
            }
            cp.setNameKey(this.getPropKey((Node)cp.getName()));
            cp.addChildToBack(this.transform(cp.getDefaultValue()));
            if (!cp.isStatic()) {
                this.currentScriptOrFn = currentScriptTemp;
                currentScriptTemp = null;
            }
            decorators = new ArrayList<Node>();
            for (final DecoratorNode dn4 : cp.getDecorators()) {
                if (dn4.getDecoratorType() == DecoratorType.INITIALIZE) {
                    continue;
                }
                decorators.add(this.transformDecoratorNode(dn4));
            }
            cp.putProp(33, (Object)decorators);
            node.addChildToBack((Node)cp);
        }
        return (Node)node;
    }
    
    private Node transformFunctionCall(final FunctionCall node) {
        final Node call = this.createCallOrNew(39, this.transform(node.getTarget()));
        if (node.getProp(30) != null) {
            call.putProp(30, node.getProp(30));
        }
        else if (node.getProp(29) != null) {
            call.putProp(29, node.getProp(29));
        }
        if (node.getProp(34) != null) {
            call.putProp(34, true);
        }
        call.setLineno(node.getLineno());
        this.decompiler.addToken(84);
        final List<AstNode> args = (List<AstNode>)node.getArguments();
        for (int i = 0; i < args.size(); ++i) {
            final AstNode arg = args.get(i);
            if (arg.getType() == 103 && arg instanceof EmptyExpression) {
                call.putProp(37, true);
                call.addChildToBack((Node)arg);
                this.decompiler.addToken(103);
            }
            else {
                final Node child = this.transform(arg);
                if (arg.getProp(29) != null) {
                    child.putProp(29, true);
                }
                call.addChildToBack(child);
                if (i < args.size() - 1) {
                    this.decompiler.addToken(86);
                }
            }
        }
        this.decompiler.addToken(85);
        return call;
    }
    
    private Node transformGenExpr(final GeneratorExpression node) {
        final FunctionNode fn = new FunctionNode();
        fn.setSourceName(this.currentScriptOrFn.getNextTempName());
        fn.setIsGenerator();
        fn.setFunctionType(2);
        fn.setRequiresActivation();
        final int functionType = fn.getFunctionType();
        final int start = this.decompiler.markFunctionStart(functionType);
        this.decompileFunctionHeader(fn);
        final int index = this.currentScriptOrFn.addFunction(fn);
        final PerFunctionVariables savedVars = new PerFunctionVariables(fn);
        Node pn;
        try {
            final Node destructuring = (Node)fn.getProp(23);
            fn.removeProp(23);
            final int lineno = node.lineno;
            ++this.nestingOfFunction;
            final Node body = this.genExprTransformHelper(node);
            if (!fn.isExpressionClosure()) {
                this.decompiler.addToken(83);
            }
            fn.setEncodedSourceBounds(start, this.decompiler.markFunctionEnd(start));
            if (functionType != 2 && !fn.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (destructuring != null) {
                body.addChildToFront(new Node(143, destructuring, lineno));
            }
            final int syntheticType = fn.getFunctionType();
            pn = this.initFunction(fn, index, body, syntheticType);
        }
        finally {
            --this.nestingOfFunction;
            savedVars.restore();
        }
        final Node call = this.createCallOrNew(39, pn);
        call.setLineno(node.getLineno());
        this.decompiler.addToken(84);
        this.decompiler.addToken(85);
        return call;
    }
    
    private Node genExprTransformHelper(final GeneratorExpression node) {
        this.decompiler.addToken(84);
        final int lineno = node.getLineno();
        Node expr = this.transform(node.getResult());
        final List<GeneratorExpressionLoop> loops = (List<GeneratorExpressionLoop>)node.getLoops();
        final int numLoops = loops.size();
        final Node[] iterators = new Node[numLoops];
        final Node[] iteratedObjs = new Node[numLoops];
        for (int i = 0; i < numLoops; ++i) {
            final GeneratorExpressionLoop acl = loops.get(i);
            this.decompiler.addName(" ");
            this.decompiler.addToken(128);
            this.decompiler.addToken(84);
            final AstNode iter = acl.getIterator();
            String name = null;
            if (iter.getType() == 40) {
                name = iter.getString();
                this.decompiler.addName(name);
            }
            else {
                this.decompile(iter);
                name = this.currentScriptOrFn.getNextTempName();
                this.defineSymbol(84, name, false);
                expr = this.createBinary(86, this.createAssignment(87, (Node)iter, this.createName(name)), expr);
            }
            final Node init = this.createName(name);
            this.defineSymbol(158, name, false);
            iterators[i] = init;
            if (acl.isForOf()) {
                this.decompiler.addName("of ");
            }
            else {
                this.decompiler.addToken(55);
            }
            iteratedObjs[i] = this.transform(acl.getIteratedObject());
            this.decompiler.addToken(85);
        }
        final Node yield = new Node(76, expr, node.getLineno());
        Node body = new Node(143, yield, lineno);
        if (node.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(121);
            this.decompiler.addToken(84);
            body = this.createIf(this.transform(node.getFilter()), body, null, lineno);
            this.decompiler.addToken(85);
        }
        int pushed = 0;
        try {
            for (int j = numLoops - 1; j >= 0; --j) {
                final GeneratorExpressionLoop acl2 = loops.get(j);
                final Scope loop = this.createLoopNode(null, acl2.getLineno());
                this.pushScope(loop);
                ++pushed;
                body = this.createForIn(158, (Node)loop, iterators[j], iteratedObjs[j], body, acl2.isForOf());
            }
        }
        finally {
            for (int k = 0; k < pushed; ++k) {
                this.popScope();
            }
        }
        this.decompiler.addToken(85);
        return body;
    }
    
    private Node transformIf(final IfStatement n) {
        this.decompiler.addToken(121);
        this.decompiler.addToken(84);
        final Node cond = this.transform(n.getCondition());
        this.decompiler.addToken(85);
        this.decompiler.addEOL(82);
        final Node ifTrue = this.transform(n.getThenPart());
        Node ifFalse = null;
        if (n.getElsePart() != null) {
            this.decompiler.addToken(83);
            this.decompiler.addToken(122);
            this.decompiler.addEOL(82);
            ifFalse = this.transform(n.getElsePart());
        }
        this.decompiler.addEOL(83);
        return this.createIf(cond, ifTrue, ifFalse, n.getLineno());
    }
    
    private Node transformInfix(final InfixExpression node) {
        final Node left = this.transform(node.getLeft());
        this.decompiler.addToken(node.getType());
        final Node right = this.transform(node.getRight());
        return this.createBinary(node.getType(), left, right);
    }
    
    private Node transformLabeledStatement(final LabeledStatement ls) {
        final Label label = ls.getFirstLabel();
        final List<Label> labels = (List<Label>)ls.getLabels();
        this.decompiler.addName(label.getName());
        if (labels.size() > 1) {
            for (final Label lb : labels.subList(1, labels.size())) {
                this.decompiler.addEOL(104);
                this.decompiler.addName(lb.getName());
            }
        }
        if (ls.getStatement().getType() == 139) {
            this.decompiler.addToken(70);
            this.decompiler.addEOL(82);
        }
        else {
            this.decompiler.addEOL(104);
        }
        final Node statement = this.transform(ls.getStatement());
        if (ls.getStatement().getType() == 139) {
            this.decompiler.addEOL(83);
        }
        final Node breakTarget = Node.newTarget();
        final Node block = new Node(139, (Node)label, statement, breakTarget);
        label.target = breakTarget;
        return block;
    }
    
    private Node transformLetNode(final LetNode node) {
        this.pushScope((Scope)node);
        try {
            this.decompiler.addToken(158);
            this.decompiler.addToken(84);
            final Node vars = this.transformVariableInitializers(node.getVariables());
            this.decompiler.addToken(85);
            node.addChildToBack(vars);
            final boolean letExpr = node.getType() == 163;
            if (node.getBody() != null) {
                if (letExpr) {
                    this.decompiler.addName(" ");
                }
                else {
                    this.decompiler.addEOL(82);
                }
                node.addChildToBack(this.transform(node.getBody()));
                if (!letExpr) {
                    this.decompiler.addEOL(83);
                }
            }
            return (Node)node;
        }
        finally {
            this.popScope();
        }
    }
    
    private Node transformLiteral(final AstNode node) {
        this.decompiler.addToken(node.getType());
        return (Node)node;
    }
    
    private Node transformName(final Name node) {
        if (node.getParent() != null && node.getParent().getProp(33) != null) {
            node.putProp(33, (Object)true);
            this.decompiler.addToken(153);
        }
        this.decompiler.addName(node.getIdentifier());
        return (Node)node;
    }
    
    private Node transformNewExpr(final NewExpression node) {
        this.decompiler.addToken(31);
        final Node nx = this.createCallOrNew(31, this.transform(node.getTarget()));
        nx.setLineno(node.getLineno());
        final List<AstNode> args = (List<AstNode>)node.getArguments();
        this.decompiler.addToken(84);
        for (int i = 0; i < args.size(); ++i) {
            final AstNode arg = args.get(i);
            nx.addChildToBack(this.transform(arg));
            if (i < args.size() - 1) {
                this.decompiler.addToken(86);
            }
        }
        this.decompiler.addToken(85);
        if (node.getInitializer() != null) {
            nx.addChildToBack(this.transformObjectLiteral(node.getInitializer()));
        }
        return nx;
    }
    
    private Node transformNumber(final NumberLiteral node) {
        this.decompiler.addNumber(node.getNumber());
        final DecoratorNode dn = node.getDecoratorNode();
        if (dn != null) {
            this.transformDecoratorNode(dn);
        }
        return (Node)node;
    }
    
    private Node transformObjectLiteral(final ObjectLiteral node) {
        if (node.isDestructuring()) {
            return (Node)node;
        }
        this.decompiler.addToken(82);
        final List<ObjectProperty> elems = (List<ObjectProperty>)node.getElements();
        final Node object = new Node(70);
        Object[] properties;
        int[] spreadIndices;
        if (elems.isEmpty()) {
            properties = ScriptRuntime.emptyArgs;
            spreadIndices = new int[0];
        }
        else {
            final int size = elems.size();
            int nonSpreadIndex = 0;
            int spreadIndex = 0;
            properties = new Object[(int)elems.stream().filter(it -> it.getSpread() == null).count()];
            spreadIndices = new int[elems.size() - properties.length];
            for (final ObjectProperty prop : elems) {
                if (prop.isGetterMethod()) {
                    this.decompiler.addToken(156);
                }
                else if (prop.isSetterMethod()) {
                    this.decompiler.addToken(157);
                }
                else if (prop.isNormalMethod()) {
                    this.decompiler.addToken(168);
                }
                final AstNode spread = prop.getSpread();
                if (spread == null) {
                    properties[nonSpreadIndex++] = this.getPropKey((Node)prop.getLeft());
                    if (!prop.isMethod()) {
                        this.decompiler.addToken(70);
                    }
                    Node right = this.transform(prop.getRight());
                    if (prop.isGetterMethod()) {
                        right = this.createUnary(156, right);
                    }
                    else if (prop.isSetterMethod()) {
                        right = this.createUnary(157, right);
                    }
                    else if (prop.isNormalMethod()) {
                        right = this.createUnary(168, right);
                    }
                    object.addChildToBack(right);
                    if (nonSpreadIndex >= size) {
                        continue;
                    }
                    this.decompiler.addToken(86);
                }
                else {
                    spreadIndices[spreadIndex] = nonSpreadIndex + spreadIndex;
                    ++spreadIndex;
                    final Node transformed = this.transform(spread);
                    object.addChildToBack(transformed);
                }
            }
        }
        this.decompiler.addToken(83);
        object.putProp(12, properties);
        object.putProp(32, spreadIndices);
        return object;
    }
    
    private Object getPropKey(final Node id) {
        Object key;
        if (id.getProp(28) != null) {
            key = this.transform((AstNode)id);
            this.decompiler.addToken(80);
            this.decompile((AstNode)id);
            this.decompiler.addToken(81);
        }
        else if (id instanceof Name) {
            if (id.getProp(29) != null) {
                this.decompiler.addToken(110);
                key = id;
            }
            else {
                final String s = ((Name)id).getIdentifier();
                this.decompiler.addName(s);
                key = ScriptRuntime.getIndexObject(s);
            }
        }
        else if (id instanceof StringLiteral) {
            final String s = ((StringLiteral)id).getValue();
            this.decompiler.addString(s);
            key = ScriptRuntime.getIndexObject(s);
        }
        else {
            if (!(id instanceof NumberLiteral)) {
                throw Kit.codeBug();
            }
            final double n = ((NumberLiteral)id).getNumber();
            this.decompiler.addNumber(n);
            key = ScriptRuntime.getIndexObject(n);
        }
        return key;
    }
    
    private Node transformParenExpr(final ParenthesizedExpression node) {
        AstNode expr = node.getExpression();
        this.decompiler.addToken(84);
        int count = 1;
        while (expr instanceof ParenthesizedExpression) {
            this.decompiler.addToken(84);
            ++count;
            expr = ((ParenthesizedExpression)expr).getExpression();
        }
        final Node result = this.transform(expr);
        for (int i = 0; i < count; ++i) {
            this.decompiler.addToken(85);
        }
        result.putProp(19, Boolean.TRUE);
        return result;
    }
    
    private Node transformPropertyGet(final PropertyGet node) {
        final Node target = this.transform(node.getTarget());
        final String name = node.getProperty().getIdentifier();
        if (node.getProp(30) != null) {
            this.decompiler.addToken(111);
        }
        else {
            this.decompiler.addToken(109);
        }
        if (node.getProp(34) != null) {
            this.decompiler.addToken(170);
        }
        this.decompiler.addName(name);
        return this.createPropertyGet(target, name, (Node)node);
    }
    
    private Node transformRegExp(final RegExpLiteral node) {
        this.decompiler.addRegexp(node.getValue(), node.getFlags());
        this.currentScriptOrFn.addRegExp(node);
        return (Node)node;
    }
    
    private Node transformReturn(final ReturnStatement node) {
        final boolean expClosure = Boolean.TRUE.equals(node.getProp(25));
        final boolean isArrow = Boolean.TRUE.equals(node.getProp(27));
        if (expClosure) {
            if (!isArrow) {
                this.decompiler.addName(" ");
            }
        }
        else {
            this.decompiler.addToken(4);
        }
        final AstNode rv = node.getReturnValue();
        final Node value = (rv == null) ? null : this.transform(rv);
        if (!expClosure) {
            this.decompiler.addEOL(79);
        }
        return (rv == null) ? new Node(4, node.getLineno()) : new Node(4, value, node.getLineno());
    }
    
    private Node transformScript(final ScriptNode node) {
        this.decompiler.addToken(146);
        if (this.currentScope != null) {
            Kit.codeBug();
        }
        this.currentScope = (Scope)node;
        final Node body = new Node(139);
        for (final Node kid : node) {
            body.addChildToBack(this.transform((AstNode)kid));
        }
        node.removeChildren();
        final Node children = body.getFirstChild();
        if (children != null) {
            node.addChildrenToBack(children);
        }
        return (Node)node;
    }
    
    private Node transformString(final StringLiteral node) {
        final boolean spread = node.getProp(29) != null;
        if (spread) {
            this.decompiler.addToken(110);
        }
        this.decompiler.addString(node.getValue());
        if (spread) {
            final Node array = new Node(69);
            array.putProp(29, true);
            final String str = node.getValue();
            int index = 0;
            while (index < str.length()) {
                final int newIndex = str.offsetByCodePoints(index, 1);
                final String value = str.substring(index, newIndex);
                index = newIndex;
                final StringLiteral sl = new StringLiteral();
                sl.setValue(value);
                array.addChildToBack(this.transformString(sl));
            }
            return array;
        }
        return Node.newString(node.getValue());
    }
    
    private Node transformTemplate(final TemplateLiteral lit) {
        final AstNode target = lit.getTarget();
        if (target != null) {
            lit.setTransformedTarget(this.transform(target));
        }
        for (final AstNode part : lit.getElements()) {
            lit.addChildToBack(this.transform(part));
        }
        return (Node)lit;
    }
    
    private Node transformSwitch(final SwitchStatement node) {
        this.decompiler.addToken(123);
        this.decompiler.addToken(84);
        final Node switchExpr = this.transform(node.getExpression());
        this.decompiler.addToken(85);
        node.addChildToBack(switchExpr);
        final Node block = new Node(139, (Node)node, node.getLineno());
        this.decompiler.addEOL(82);
        for (final SwitchCase sc : node.getCases()) {
            final AstNode expr = sc.getExpression();
            Node caseExpr = null;
            if (expr != null) {
                this.decompiler.addToken(124);
                caseExpr = this.transform(expr);
            }
            else {
                this.decompiler.addToken(125);
            }
            this.decompiler.addEOL(104);
            final List<AstNode> stmts = (List<AstNode>)sc.getStatements();
            final Node body = (Node)new Block();
            if (stmts != null) {
                for (final AstNode kid : stmts) {
                    body.addChildToBack(this.transform(kid));
                }
            }
            this.addSwitchCase(block, caseExpr, body);
        }
        this.decompiler.addEOL(83);
        this.closeSwitch(block);
        return block;
    }
    
    private Node transformThrowExpr(final UnaryExpression node) {
        this.decompiler.addToken(53);
        final Node value = this.transform(node.getOperand());
        return new Node(53, value, node.getLineno());
    }
    
    private Node transformThrow(final ThrowStatement node) {
        this.decompiler.addToken(53);
        final Node value = this.transform(node.getExpression());
        this.decompiler.addEOL(79);
        return new Node(53, value, node.getLineno());
    }
    
    private Node transformTry(final TryStatement node) {
        this.decompiler.addToken(78);
        this.decompiler.addEOL(82);
        final Node tryBlock = this.transform(node.getTryBlock());
        this.decompiler.addEOL(83);
        final Node catchBlocks = (Node)new Block();
        for (final CatchClause cc : node.getCatchClauses()) {
            this.decompiler.addToken(133);
            this.decompiler.addToken(84);
            final String varName = cc.getVarName().getIdentifier();
            this.decompiler.addName(varName);
            this.decompiler.addToken(85);
            this.decompiler.addEOL(82);
            final Node body = this.transform((AstNode)cc.getBody());
            this.decompiler.addEOL(83);
            catchBlocks.addChildToBack(this.createCatch(varName, body, cc.getLineno()));
        }
        Node finallyBlock = null;
        if (node.getFinallyBlock() != null) {
            this.decompiler.addToken(134);
            this.decompiler.addEOL(82);
            finallyBlock = this.transform(node.getFinallyBlock());
            this.decompiler.addEOL(83);
        }
        return this.createTryCatchFinally(tryBlock, catchBlocks, finallyBlock, node.getLineno());
    }
    
    private Node transformUnary(final UnaryExpression node) {
        final int type = node.getType();
        if (node.isPrefix()) {
            this.decompiler.addToken(type);
        }
        final Node child = this.transform(node.getOperand());
        if (node.isPostfix()) {
            this.decompiler.addToken(type);
        }
        if (type == 107 || type == 108) {
            return this.createIncDec(type, node.isPostfix(), child);
        }
        return this.createUnary(type, child);
    }
    
    private Node transformVariables(final VariableDeclaration node) {
        this.decompiler.addToken(node.getType());
        this.transformVariableInitializers(node);
        final AstNode parent = node.getParent();
        if (!(parent instanceof Loop) && !(parent instanceof LetNode)) {
            this.decompiler.addEOL(79);
        }
        return (Node)node;
    }
    
    private Node transformVariableInitializers(final VariableDeclaration node) {
        final List<VariableInitializer> vars = (List<VariableInitializer>)node.getVariables();
        final int size = vars.size();
        int i = 0;
        for (final VariableInitializer var : vars) {
            final AstNode target = var.getTarget();
            final AstNode init = var.getInitializer();
            Node left = null;
            if (var.isDestructuring()) {
                this.decompile(target);
                left = (Node)target;
            }
            else {
                left = this.transform(target);
            }
            Node right = null;
            if (init != null) {
                this.decompiler.addToken(87);
                right = this.transform(init);
            }
            if (var.isDestructuring()) {
                if (right == null) {
                    node.addChildToBack(left);
                }
                else {
                    final Node d = this.createDestructuringAssignment(node.getType(), left, right);
                    node.addChildToBack(d);
                }
            }
            else {
                if (right != null) {
                    left.addChildToBack(right);
                }
                node.addChildToBack(left);
            }
            if (i++ < size - 1) {
                this.decompiler.addToken(86);
            }
        }
        return (Node)node;
    }
    
    private Node transformWhileLoop(final WhileLoop loop) {
        this.decompiler.addToken(126);
        loop.setType(142);
        this.pushScope((Scope)loop);
        try {
            this.decompiler.addToken(84);
            final Node cond = this.transform(loop.getCondition());
            this.decompiler.addToken(85);
            this.decompiler.addEOL(82);
            final Node body = this.transform(loop.getBody());
            this.decompiler.addEOL(83);
            return this.createLoop((Jump)loop, 1, body, cond, null, null);
        }
        finally {
            this.popScope();
        }
    }
    
    private Node transformWith(final WithStatement node) {
        this.decompiler.addToken(132);
        this.decompiler.addToken(84);
        final Node expr = this.transform(node.getExpression());
        this.decompiler.addToken(85);
        this.decompiler.addEOL(82);
        final Node stmt = this.transform(node.getStatement());
        this.decompiler.addEOL(83);
        return this.createWith(expr, stmt, node.getLineno());
    }
    
    private Node transformYield(final Yield node) {
        this.decompiler.addToken(76);
        final Node kid = (node.getValue() == null) ? null : this.transform(node.getValue());
        if (kid != null) {
            return new Node(76, kid, node.getLineno());
        }
        return new Node(76, node.getLineno());
    }
    
    private void addSwitchCase(final Node switchBlock, final Node caseExpression, final Node statements) {
        if (switchBlock.getType() != 139) {
            throw Kit.codeBug();
        }
        final Jump switchNode = (Jump)switchBlock.getFirstChild();
        if (switchNode.getType() != 123) {
            throw Kit.codeBug();
        }
        final Node gotoTarget = Node.newTarget();
        if (caseExpression != null) {
            final Jump caseNode = new Jump(124, caseExpression);
            caseNode.target = gotoTarget;
            switchNode.addChildToBack((Node)caseNode);
        }
        else {
            switchNode.setDefault(gotoTarget);
        }
        switchBlock.addChildToBack(gotoTarget);
        switchBlock.addChildToBack(statements);
    }
    
    private void closeSwitch(final Node switchBlock) {
        if (switchBlock.getType() != 139) {
            throw Kit.codeBug();
        }
        final Jump switchNode = (Jump)switchBlock.getFirstChild();
        if (switchNode.getType() != 123) {
            throw Kit.codeBug();
        }
        final Node switchBreakTarget = Node.newTarget();
        switchNode.target = switchBreakTarget;
        Node defaultTarget = switchNode.getDefault();
        if (defaultTarget == null) {
            defaultTarget = switchBreakTarget;
        }
        switchBlock.addChildAfter((Node)this.makeJump(5, defaultTarget), (Node)switchNode);
        switchBlock.addChildToBack(switchBreakTarget);
    }
    
    private Node createExprStatementNoReturn(final Node expr, final int lineno) {
        return new Node(143, expr, lineno);
    }
    
    private Node createString(final String string) {
        return Node.newString(string);
    }
    
    private Node createCatch(final String varName, final Node stmts, final int lineno) {
        return new Node(133, this.createName(varName), stmts, lineno);
    }
    
    private Node initFunction(final FunctionNode fnNode, final int functionIndex, final Node statements, final int functionType) {
        fnNode.setFunctionType(functionType);
        fnNode.addChildToBack(statements);
        final int functionCount = fnNode.getFunctionCount();
        if (functionCount != 0) {
            fnNode.setRequiresActivation();
        }
        if (functionType == 2) {
            final Name name = fnNode.getFunctionName();
            if (name != null && name.length() != 0 && fnNode.getSymbol(name.getIdentifier()) == null) {
                fnNode.putSymbol(new Symbol(114, name.getIdentifier()));
                final Node setFn = new Node(143, new Node(8, Node.newString(52, name.getIdentifier()), new Node(67)));
                statements.addChildrenToFront(setFn);
            }
        }
        final Node lastStmt = statements.getLastChild();
        if (lastStmt == null || lastStmt.getType() != 4) {
            statements.addChildToBack(new Node(4));
        }
        final Node result = Node.newString(114, fnNode.getName());
        result.putIntProp(1, functionIndex);
        return result;
    }
    
    private Scope createLoopNode(final Node loopLabel, final int lineno) {
        final Scope result = this.createScopeNode(142, lineno);
        if (loopLabel != null) {
            ((Jump)loopLabel).setLoop((Jump)result);
        }
        return result;
    }
    
    private Node createFor(final Scope loop, final Node init, final Node test, final Node incr, final Node body) {
        if (init.getType() == 158) {
            final Scope let = Scope.splitScope(loop);
            let.setType(158);
            let.addChildrenToBack(init);
            let.addChildToBack(this.createLoop((Jump)loop, 2, body, test, new Node(138), incr));
            return (Node)let;
        }
        return this.createLoop((Jump)loop, 2, body, test, init, incr);
    }
    
    private Node createLoop(final Jump loop, final int loopType, final Node body, Node cond, Node init, Node incr) {
        final Node bodyTarget = Node.newTarget();
        final Node condTarget = Node.newTarget();
        if (loopType == 2 && cond.getType() == 138) {
            cond = new Node(48);
        }
        final Jump IFEQ = new Jump(6, cond);
        IFEQ.target = bodyTarget;
        final Node breakTarget = Node.newTarget();
        loop.addChildToBack(bodyTarget);
        loop.addChildrenToBack(body);
        if (loopType == 1 || loopType == 2) {
            loop.addChildrenToBack(new Node(138, loop.getLineno()));
        }
        loop.addChildToBack(condTarget);
        loop.addChildToBack((Node)IFEQ);
        loop.addChildToBack(breakTarget);
        loop.target = breakTarget;
        Node continueTarget = condTarget;
        if (loopType == 1 || loopType == 2) {
            loop.addChildToFront((Node)this.makeJump(5, condTarget));
            if (loopType == 2) {
                final int initType = init.getType();
                if (initType != 138) {
                    if (initType != 131 && initType != 158 && initType != 159) {
                        init = new Node(143, init);
                    }
                    loop.addChildToFront(init);
                }
                final Node incrTarget = Node.newTarget();
                loop.addChildAfter(incrTarget, body);
                if (incr.getType() != 138) {
                    incr = new Node(143, incr);
                    loop.addChildAfter(incr, incrTarget);
                }
                continueTarget = incrTarget;
            }
        }
        loop.setContinue(continueTarget);
        return (Node)loop;
    }
    
    private Node createForIn(final int declType, Node loop, final Node lhs, final Node obj, final Node body, final boolean isForOf) {
        int destructuring = -1;
        int destructuringLen = 0;
        int type = lhs.getType();
        Node lvalue;
        if (type == 131 || type == 158 || type == 159) {
            final Node kid = lhs.getLastChild();
            final int kidType = kid.getType();
            if (kidType == 69 || kidType == 70) {
                destructuring = (type = kidType);
                lvalue = kid;
                destructuringLen = 0;
                if (kid instanceof ArrayLiteral) {
                    destructuringLen = ((ArrayLiteral)kid).getDestructuringLength();
                }
            }
            else {
                if (kidType != 40) {
                    this.reportError("msg.bad.for.in.lhs");
                    return null;
                }
                lvalue = Node.newString(40, kid.getString());
            }
        }
        else if (type == 69 || type == 70) {
            destructuring = type;
            lvalue = lhs;
            destructuringLen = 0;
            if (lhs instanceof ArrayLiteral) {
                destructuringLen = ((ArrayLiteral)lhs).getDestructuringLength();
            }
        }
        else {
            lvalue = this.makeReference(lhs);
            if (lvalue == null) {
                this.reportError("msg.bad.for.in.lhs");
                return null;
            }
        }
        final Node localBlock = new Node(151);
        final int initType = isForOf ? 64 : ((destructuring != -1) ? 63 : 61);
        final Node init = new Node(initType, obj);
        init.putProp(3, localBlock);
        final Node cond = new Node(65);
        cond.putProp(3, localBlock);
        final Node id = new Node(66);
        id.putProp(3, localBlock);
        final Node newBody = new Node(139);
        Node assign;
        if (destructuring != -1) {
            assign = this.createDestructuringAssignment(declType, lvalue, id);
            if (!isForOf && (destructuring == 70 || destructuringLen != 2)) {
                this.reportError("msg.bad.for.in.destruct");
            }
        }
        else {
            assign = this.simpleAssignment(lvalue, id);
        }
        newBody.addChildToBack(new Node(143, assign));
        newBody.addChildToBack(body);
        loop = this.createLoop((Jump)loop, 1, newBody, cond, null, null);
        loop.addChildToFront(init);
        if (type == 131 || type == 158 || type == 159) {
            loop.addChildToFront(lhs);
        }
        localBlock.addChildToBack(loop);
        return localBlock;
    }
    
    private Node createTryCatchFinally(final Node tryBlock, final Node catchBlocks, final Node finallyBlock, final int lineno) {
        final boolean hasFinally = finallyBlock != null && (finallyBlock.getType() != 139 || finallyBlock.hasChildren());
        if (tryBlock.getType() == 139 && !tryBlock.hasChildren() && !hasFinally) {
            return tryBlock;
        }
        final boolean hasCatch = catchBlocks.hasChildren();
        if (!hasFinally && !hasCatch) {
            return tryBlock;
        }
        final Node handlerBlock = new Node(151);
        final Jump pn = new Jump(78, tryBlock, lineno);
        pn.putProp(3, (Object)handlerBlock);
        if (hasCatch) {
            final Node endCatch = Node.newTarget();
            pn.addChildToBack((Node)this.makeJump(5, endCatch));
            final Node catchTarget = Node.newTarget();
            pn.addChildToBack(pn.target = catchTarget);
            final Node catchScopeBlock = new Node(151);
            Node cb = catchBlocks.getFirstChild();
            boolean hasDefault = false;
            for (int scopeIndex = 0; cb != null; cb = cb.getNext(), ++scopeIndex) {
                final int catchLineNo = cb.getLineno();
                final Node name = cb.getFirstChild();
                final Node catchStatement = name.getNext();
                cb.removeChild(name);
                cb.removeChild(catchStatement);
                catchStatement.addChildToBack(new Node(3));
                catchStatement.addChildToBack((Node)this.makeJump(5, endCatch));
                hasDefault = true;
                final Node catchScope = new Node(60, name, this.createUseLocal(handlerBlock));
                catchScope.putProp(3, catchScopeBlock);
                catchScope.putIntProp(14, scopeIndex);
                catchScopeBlock.addChildToBack(catchScope);
                catchScopeBlock.addChildToBack(this.createWith(this.createUseLocal(catchScopeBlock), catchStatement, catchLineNo));
            }
            pn.addChildToBack(catchScopeBlock);
            if (!hasDefault) {
                final Node rethrow = new Node(54);
                rethrow.putProp(3, handlerBlock);
                pn.addChildToBack(rethrow);
            }
            pn.addChildToBack(endCatch);
        }
        if (hasFinally) {
            final Node finallyTarget = Node.newTarget();
            pn.setFinally(finallyTarget);
            pn.addChildToBack((Node)this.makeJump(145, finallyTarget));
            final Node finallyEnd = Node.newTarget();
            pn.addChildToBack((Node)this.makeJump(5, finallyEnd));
            pn.addChildToBack(finallyTarget);
            final Node fBlock = new Node(134, finallyBlock);
            fBlock.putProp(3, handlerBlock);
            pn.addChildToBack(fBlock);
            pn.addChildToBack(finallyEnd);
        }
        handlerBlock.addChildToBack((Node)pn);
        return handlerBlock;
    }
    
    private Node createWith(final Node obj, final Node body, final int lineno) {
        this.setRequiresActivation();
        final Node result = new Node(139, lineno);
        result.addChildToBack(new Node(2, obj));
        final Node bodyNode = new Node(132, body, lineno);
        result.addChildrenToBack(bodyNode);
        result.addChildToBack(new Node(3));
        return result;
    }
    
    private Node createIf(final Node cond, final Node ifTrue, final Node ifFalse, final int lineno) {
        final int condStatus = isAlwaysDefinedBoolean(cond);
        if (condStatus == 1) {
            return ifTrue;
        }
        if (condStatus != -1) {
            final Node result = new Node(139, lineno);
            final Node ifNotTarget = Node.newTarget();
            final Jump IFNE = new Jump(7, cond);
            IFNE.target = ifNotTarget;
            result.addChildToBack((Node)IFNE);
            result.addChildrenToBack(ifTrue);
            if (ifFalse != null) {
                final Node endTarget = Node.newTarget();
                result.addChildToBack((Node)this.makeJump(5, endTarget));
                result.addChildToBack(ifNotTarget);
                result.addChildrenToBack(ifFalse);
                result.addChildToBack(endTarget);
            }
            else {
                result.addChildToBack(ifNotTarget);
            }
            return result;
        }
        if (ifFalse != null) {
            return ifFalse;
        }
        return new Node(139, lineno);
    }
    
    private Node createCondExpr(final Node cond, final Node ifTrue, final Node ifFalse) {
        final int condStatus = isAlwaysDefinedBoolean(cond);
        if (condStatus == 1) {
            return ifTrue;
        }
        if (condStatus == -1) {
            return ifFalse;
        }
        return new Node(103, cond, ifTrue, ifFalse);
    }
    
    private Node createUnary(final int nodeType, final Node child) {
        final int childType = child.getType();
        switch (nodeType) {
            case 32: {
                Node n;
                if (childType == 40) {
                    child.setType(52);
                    final Node left = child;
                    final Node right = Node.newString(child.getString());
                    n = new Node(nodeType, left, right);
                }
                else if (childType == 34 || childType == 37) {
                    final Node left = child.getFirstChild();
                    final Node right = child.getLastChild();
                    child.removeChild(left);
                    child.removeChild(right);
                    n = new Node(nodeType, left, right);
                }
                else if (childType == 71) {
                    final Node ref = child.getFirstChild();
                    child.removeChild(ref);
                    n = new Node(73, ref);
                }
                else {
                    n = new Node(nodeType, new Node(48), child);
                }
                return n;
            }
            case 33: {
                if (childType == 40) {
                    child.setType(147);
                    return child;
                }
                break;
            }
            case 28: {
                if (childType == 41) {
                    final int value = ScriptRuntime.toInt32(child.getDouble());
                    child.setDouble(~value);
                    return child;
                }
                break;
            }
            case 30: {
                if (childType == 41) {
                    child.setDouble(-child.getDouble());
                    return child;
                }
                break;
            }
            case 27: {
                final int status = isAlwaysDefinedBoolean(child);
                if (status == 0) {
                    break;
                }
                int type;
                if (status == 1) {
                    type = 47;
                }
                else {
                    type = 48;
                }
                if (childType == 48 || childType == 47) {
                    child.setType(type);
                    return child;
                }
                return new Node(type);
            }
        }
        return new Node(nodeType, child);
    }
    
    private Node createCallOrNew(final int nodeType, final Node child) {
        int type = 0;
        if (child.getType() == 40) {
            final String name = child.getString();
            if (name.equals("eval")) {
                type = 1;
            }
            else if (name.equals("With")) {
                type = 2;
            }
        }
        else if (child.getType() == 34) {
            final String name = child.getLastChild().getString();
            if (name.equals("eval")) {
                type = 1;
            }
        }
        final Node node = new Node(nodeType, child);
        if (type != 0) {
            this.setRequiresActivation();
            node.putIntProp(10, type);
        }
        return node;
    }
    
    private Node createIncDec(final int nodeType, final boolean post, Node child) {
        child = this.makeReference(child);
        final int childType = child.getType();
        switch (childType) {
            case 34:
            case 37:
            case 40:
            case 71: {
                final Node n = new Node(nodeType, child);
                int incrDecrMask = 0;
                if (nodeType == 108) {
                    incrDecrMask |= 0x1;
                }
                if (post) {
                    incrDecrMask |= 0x2;
                }
                n.putIntProp(13, incrDecrMask);
                return n;
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    private Node createPropertyGet(final Node target, final String name, final Node parent) {
        if (target == null) {
            return this.createName(name);
        }
        this.checkActivationName(name, 34);
        if (ScriptRuntime.isSpecialProperty(name)) {
            final Node ref = new Node(75, target);
            ref.putProp(17, name);
            return new Node(71, ref);
        }
        final Node node = new Node(34, target, Node.newString(name));
        if (parent != null && parent.getProp(30) != null) {
            node.putProp(30, true);
        }
        if (parent != null && parent.getProp(34) != null) {
            node.putProp(34, true);
        }
        return node;
    }
    
    private Node createBinary(final int nodeType, final Node left, final Node right) {
        switch (nodeType) {
            case 21: {
                if (left.type == 42) {
                    String s2;
                    if (right.type == 42) {
                        s2 = right.getString();
                    }
                    else {
                        if (right.type != 41) {
                            break;
                        }
                        s2 = ScriptRuntime.numberToString(right.getDouble(), 10);
                    }
                    final String s3 = left.getString();
                    left.setString(s3.concat(s2));
                    return left;
                }
                if (left.type != 41) {
                    break;
                }
                if (right.type == 41) {
                    left.setDouble(left.getDouble() + right.getDouble());
                    return left;
                }
                if (right.type == 42) {
                    final String s4 = ScriptRuntime.numberToString(left.getDouble(), 10);
                    final String s5 = right.getString();
                    right.setString(s4.concat(s5));
                    return right;
                }
                break;
            }
            case 22: {
                if (left.type == 41) {
                    final double ld = left.getDouble();
                    if (right.type == 41) {
                        left.setDouble(ld - right.getDouble());
                        return left;
                    }
                    if (ld == 0.0) {
                        return new Node(30, right);
                    }
                    break;
                }
                else {
                    if (right.type == 41 && right.getDouble() == 0.0) {
                        return new Node(29, left);
                    }
                    break;
                }
                break;
            }
            case 23: {
                if (left.type == 41) {
                    final double ld = left.getDouble();
                    if (right.type == 41) {
                        left.setDouble(ld * right.getDouble());
                        return left;
                    }
                    if (ld == 1.0) {
                        return new Node(29, right);
                    }
                    break;
                }
                else {
                    if (right.type == 41 && right.getDouble() == 1.0) {
                        return new Node(29, left);
                    }
                    break;
                }
                break;
            }
            case 24: {
                if (right.type != 41) {
                    break;
                }
                final double rd = right.getDouble();
                if (left.type == 41) {
                    left.setDouble(left.getDouble() / rd);
                    return left;
                }
                if (rd == 1.0) {
                    return new Node(29, left);
                }
                break;
            }
            case 106: {
                final int leftStatus = isAlwaysDefinedBoolean(left);
                if (leftStatus == -1) {
                    return left;
                }
                if (leftStatus == 1) {
                    return right;
                }
                break;
            }
            case 105: {
                final int leftStatus = isAlwaysDefinedBoolean(left);
                if (leftStatus == 1) {
                    return left;
                }
                if (leftStatus == -1) {
                    return right;
                }
                break;
            }
        }
        return new Node(nodeType, left, right);
    }
    
    private Node createAssignment(final int assignType, Node left, final Node right) {
        Node ref = this.makeReference(left);
        if (ref == null) {
            if (left.getType() != 69 && left.getType() != 70) {
                this.reportError("msg.bad.assign.left");
                return right;
            }
            if (assignType != 87) {
                this.reportError("msg.bad.destruct.op");
                return right;
            }
            return this.createDestructuringAssignment(-1, left, right);
        }
        else {
            left = ref;
            int assignOp = 0;
            switch (assignType) {
                case 87: {
                    return this.simpleAssignment(left, right);
                }
                case 88: {
                    assignOp = 9;
                    break;
                }
                case 89: {
                    assignOp = 10;
                    break;
                }
                case 90: {
                    assignOp = 11;
                    break;
                }
                case 91: {
                    assignOp = 18;
                    break;
                }
                case 92: {
                    assignOp = 19;
                    break;
                }
                case 93: {
                    assignOp = 20;
                    break;
                }
                case 94: {
                    assignOp = 21;
                    break;
                }
                case 95: {
                    assignOp = 22;
                    break;
                }
                case 96: {
                    assignOp = 23;
                    break;
                }
                case 99: {
                    assignOp = 26;
                    break;
                }
                case 97: {
                    assignOp = 24;
                    break;
                }
                case 98: {
                    assignOp = 25;
                    break;
                }
                case 101: {
                    assignOp = 106;
                    break;
                }
                case 100: {
                    assignOp = 105;
                    break;
                }
                case 102: {
                    assignOp = 113;
                    break;
                }
                default: {
                    throw Kit.codeBug();
                }
            }
            final int nodeType = left.getType();
            switch (nodeType) {
                case 40: {
                    final Node op = new Node(assignOp, left, right);
                    final Node lvalueLeft = Node.newString(52, left.getString());
                    return new Node(8, lvalueLeft, op);
                }
                case 34:
                case 37: {
                    final Node obj = left.getFirstChild();
                    final Node id = left.getLastChild();
                    final int type = (nodeType == 34) ? 149 : 150;
                    final Node opLeft = new Node(148);
                    final Node op2 = new Node(assignOp, opLeft, right);
                    return new Node(type, obj, id, op2);
                }
                case 71: {
                    ref = left.getFirstChild();
                    this.checkMutableReference(ref);
                    final Node opLeft2 = new Node(148);
                    final Node op3 = new Node(assignOp, opLeft2, right);
                    return new Node(152, ref, op3);
                }
                default: {
                    throw Kit.codeBug();
                }
            }
        }
    }
    
    private Node createUseLocal(final Node localBlock) {
        if (151 != localBlock.getType()) {
            throw Kit.codeBug();
        }
        final Node result = new Node(57);
        result.putProp(3, localBlock);
        return result;
    }
    
    private Jump makeJump(final int type, final Node target) {
        final Jump n = new Jump(type);
        n.target = target;
        return n;
    }
    
    private Node makeReference(final Node node) {
        final int type = node.getType();
        switch (type) {
            case 34:
            case 37:
            case 40:
            case 71: {
                return node;
            }
            case 39: {
                node.setType(74);
                return new Node(71, node);
            }
            default: {
                return null;
            }
        }
    }
    
    private static int isAlwaysDefinedBoolean(final Node node) {
        switch (node.getType()) {
            case 45:
            case 47: {
                return -1;
            }
            case 48: {
                return 1;
            }
            case 41: {
                final double num = node.getDouble();
                if (!Double.isNaN(num) && num != 0.0) {
                    return 1;
                }
                return -1;
            }
            default: {
                return 0;
            }
        }
    }
    
    boolean isDestructuring(final Node n) {
        return n instanceof DestructuringForm && ((DestructuringForm)n).isDestructuring();
    }
    
    void decompileFunctionHeader(final FunctionNode fn) {
        if (fn.getFunctionName() != null) {
            this.decompiler.addName(fn.getName());
        }
        final boolean isArrow = fn.getFunctionType() == 4;
        final boolean noParen = isArrow && fn.getLp() == -1;
        if (!noParen) {
            this.decompiler.addToken(84);
        }
        final List<AstNode> params = (List<AstNode>)fn.getParams();
        final Map<Integer, Node> defaultParams = (Map<Integer, Node>)fn.getDefaultParams();
        for (int i = 0; i < params.size(); ++i) {
            this.decompile(params.get(i));
            if (defaultParams.containsKey(i)) {
                this.decompiler.addToken(87);
                final AstNode node = (AstNode)defaultParams.get(i);
                final Node transformed = this.transform(node);
                fn.setDefaultParam(i, transformed);
                fn.addChildrenToBack(transformed);
            }
            if (i < params.size() - 1) {
                this.decompiler.addToken(86);
            }
        }
        if (!noParen) {
            this.decompiler.addToken(85);
        }
        if (isArrow) {
            this.decompiler.addToken(169);
        }
        if (!fn.isExpressionClosure()) {
            this.decompiler.addEOL(82);
        }
    }
    
    void decompile(final AstNode node) {
        switch (node.getType()) {
            case 69: {
                this.decompileArrayLiteral((ArrayLiteral)node);
                break;
            }
            case 70: {
                this.decompileObjectLiteral((ObjectLiteral)node);
                break;
            }
            case 42: {
                this.decompiler.addString(((StringLiteral)node).getValue());
                break;
            }
            case 40: {
                this.decompiler.addName(((Name)node).getIdentifier());
                break;
            }
            case 41: {
                this.decompiler.addNumber(((NumberLiteral)node).getNumber());
                break;
            }
            case 34: {
                this.decompilePropertyGet((PropertyGet)node);
            }
            case 37: {
                this.decompileElementGet((ElementGet)node);
                break;
            }
            case 46: {
                this.decompiler.addToken(node.getType());
                break;
            }
        }
    }
    
    void decompileArrayLiteral(final ArrayLiteral node) {
        this.decompiler.addToken(80);
        final List<AstNode> elems = (List<AstNode>)node.getElements();
        for (int size = elems.size(), i = 0; i < size; ++i) {
            final AstNode elem = elems.get(i);
            if (elem.getType() == 87) {
                final Assignment assignment = (Assignment)elem;
                this.decompile(assignment.getLeft());
                this.decompiler.addToken(87);
                this.decompile(assignment.getRight());
            }
            else {
                this.decompile(elem);
            }
            if (i < size - 1) {
                this.decompiler.addToken(86);
            }
        }
        this.decompiler.addToken(81);
    }
    
    void decompileObjectLiteral(final ObjectLiteral node) {
        this.decompiler.addToken(82);
        final List<ObjectProperty> props = (List<ObjectProperty>)node.getElements();
        for (int size = props.size(), i = 0; i < size; ++i) {
            final ObjectProperty prop = props.get(i);
            final boolean destructuringShorthand = Boolean.TRUE.equals(prop.getProp(26));
            final AstNode spread = prop.getSpread();
            if (spread != null) {
                this.decompiler.addToken(110);
                this.decompile(spread);
            }
            else {
                this.decompile(prop.getLeft());
                if (!destructuringShorthand) {
                    this.decompiler.addToken(104);
                    this.decompile(prop.getRight());
                }
            }
            if (i < size - 1) {
                this.decompiler.addToken(86);
            }
        }
        this.decompiler.addToken(83);
    }
    
    void decompilePropertyGet(final PropertyGet node) {
        this.decompile(node.getTarget());
        this.decompiler.addToken(109);
        this.decompile((AstNode)node.getProperty());
    }
    
    void decompileElementGet(final ElementGet node) {
        this.decompile(node.getTarget());
        this.decompiler.addToken(80);
        this.decompile(node.getElement());
        this.decompiler.addToken(81);
    }
    
    static {
        IRFactory.GENERATED_SUPER = new Object();
    }
}
