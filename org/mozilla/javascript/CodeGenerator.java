//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.ast.*;

class CodeGenerator extends Icode
{
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private CompilerEnvirons compilerEnv;
    private boolean itsInFunctionFlag;
    private boolean itsInTryFlag;
    private InterpreterData itsData;
    private ScriptNode scriptOrFn;
    private int iCodeTop;
    private int stackDepth;
    private int lineNumber;
    private int doubleTableTop;
    private ObjToIntMap strings;
    private int localTop;
    private int[] labelTable;
    private int labelTableTop;
    private long[] fixupTable;
    private int fixupTableTop;
    private ObjArray literalIds;
    private int exceptionTableTop;
    private static final int ECF_TAIL = 1;
    
    CodeGenerator() {
        this.strings = new ObjToIntMap(20);
        this.literalIds = new ObjArray();
    }
    
    public InterpreterData compile(final CompilerEnvirons compilerEnv, final ScriptNode tree, final String encodedSource, final boolean returnFunction) {
        this.compilerEnv = compilerEnv;
        new NodeTransformer().transform(tree, compilerEnv);
        if (returnFunction) {
            this.scriptOrFn = (ScriptNode)tree.getFunctionNode(0);
        }
        else {
            this.scriptOrFn = tree;
        }
        this.itsData = new InterpreterData(compilerEnv.getLanguageVersion(), this.scriptOrFn.getSourceName(), encodedSource, this.scriptOrFn.isInStrictMode());
        this.itsData.topLevel = true;
        if (returnFunction) {
            this.generateFunctionICode();
        }
        else {
            this.generateICodeFromTree((Node)this.scriptOrFn);
        }
        return this.itsData;
    }
    
    private void generateFunctionICode() {
        this.itsInFunctionFlag = true;
        final FunctionNode theFunction = (FunctionNode)this.scriptOrFn;
        this.itsData.itsFunctionType = theFunction.getFunctionType();
        this.itsData.itsNeedsActivation = theFunction.requiresActivation();
        if (theFunction.getFunctionName() != null) {
            this.itsData.itsName = theFunction.getName();
        }
        if (theFunction.isGenerator()) {
            this.addIcode(-62);
            this.addUint16(theFunction.getBaseLineno() & 0xFFFF);
        }
        if (theFunction.isInStrictMode()) {
            this.itsData.isStrict = true;
        }
        this.itsData.declaredAsVar = (theFunction.getParent() instanceof VariableInitializer);
        this.generateICodeFromTree(theFunction.getLastChild());
    }
    
    private void generateICodeFromTree(final Node tree) {
        this.generateNestedFunctions();
        this.generateRegExpLiterals();
        this.visitStatement(tree, 0);
        this.fixLabelGotos();
        if (this.itsData.itsFunctionType == 0) {
            this.addToken(68);
        }
        if (this.itsData.itsICode.length != this.iCodeTop) {
            final byte[] tmp = new byte[this.iCodeTop];
            System.arraycopy(this.itsData.itsICode, 0, tmp, 0, this.iCodeTop);
            this.itsData.itsICode = tmp;
        }
        if (this.strings.size() == 0) {
            this.itsData.itsStringTable = null;
        }
        else {
            this.itsData.itsStringTable = new String[this.strings.size()];
            final ObjToIntMap.Iterator iter = this.strings.newIterator();
            iter.start();
            while (!iter.done()) {
                final String str = (String)iter.getKey();
                final int index = iter.getValue();
                if (this.itsData.itsStringTable[index] != null) {
                    Kit.codeBug();
                }
                this.itsData.itsStringTable[index] = str;
                iter.next();
            }
        }
        if (this.doubleTableTop == 0) {
            this.itsData.itsDoubleTable = null;
        }
        else if (this.itsData.itsDoubleTable.length != this.doubleTableTop) {
            final double[] tmp2 = new double[this.doubleTableTop];
            System.arraycopy(this.itsData.itsDoubleTable, 0, tmp2, 0, this.doubleTableTop);
            this.itsData.itsDoubleTable = tmp2;
        }
        if (this.exceptionTableTop != 0 && this.itsData.itsExceptionTable.length != this.exceptionTableTop) {
            final int[] tmp3 = new int[this.exceptionTableTop];
            System.arraycopy(this.itsData.itsExceptionTable, 0, tmp3, 0, this.exceptionTableTop);
            this.itsData.itsExceptionTable = tmp3;
        }
        this.itsData.itsMaxVars = this.scriptOrFn.getParamAndVarCount();
        this.itsData.itsMaxFrameArray = this.itsData.itsMaxVars + this.itsData.itsMaxLocals + this.itsData.itsMaxStack;
        this.itsData.argNames = this.scriptOrFn.getParamAndVarNames();
        this.itsData.argIsConst = this.scriptOrFn.getParamAndVarConst();
        this.itsData.argCount = this.scriptOrFn.getParamCount();
        this.itsData.encodedSourceStart = this.scriptOrFn.getEncodedSourceStart();
        this.itsData.encodedSourceEnd = this.scriptOrFn.getEncodedSourceEnd();
        if (this.literalIds.size() != 0) {
            this.itsData.literalIds = this.literalIds.toArray();
        }
    }
    
    private void generateNestedFunctions() {
        final int functionCount = this.scriptOrFn.getFunctionCount();
        if (functionCount == 0) {
            return;
        }
        final InterpreterData[] array = new InterpreterData[functionCount];
        for (int i = 0; i != functionCount; ++i) {
            final FunctionNode fn = this.scriptOrFn.getFunctionNode(i);
            final CodeGenerator gen = new CodeGenerator();
            gen.compilerEnv = this.compilerEnv;
            gen.scriptOrFn = (ScriptNode)fn;
            gen.itsData = new InterpreterData(this.itsData);
            gen.generateFunctionICode();
            array[i] = gen.itsData;
            final AstNode fnParent = fn.getParent();
            if (!(fnParent instanceof AstRoot) && !(fnParent instanceof Scope) && !(fnParent instanceof Block)) {
                gen.itsData.declaredAsFunctionExpression = true;
            }
        }
        this.itsData.itsNestedFunctions = array;
    }
    
    private void generateRegExpLiterals() {
        final int N = this.scriptOrFn.getRegexpCount();
        if (N == 0) {
            return;
        }
        final Context cx = Context.getContext();
        final RegExpProxy rep = ScriptRuntime.checkRegExpProxy(cx);
        final Object[] array = new Object[N];
        for (int i = 0; i != N; ++i) {
            final String string = this.scriptOrFn.getRegexpString(i);
            final String flags = this.scriptOrFn.getRegexpFlags(i);
            array[i] = rep.compileRegExp(cx, string, flags);
        }
        this.itsData.itsRegExpLiterals = array;
    }
    
    private void updateLineNumber(final Node node) {
        final int lineno = node.getLineno();
        if (lineno != this.lineNumber && lineno >= 0) {
            if (this.itsData.firstLinePC < 0) {
                this.itsData.firstLinePC = lineno;
            }
            this.lineNumber = lineno;
            this.addIcode(-26);
            this.addUint16(lineno & 0xFFFF);
        }
    }
    
    private RuntimeException badTree(final Node node) {
        throw new RuntimeException(node.toString());
    }
    
    private void visitStatement(final Node node, final int initialStackDepth) {
        final int type = node.getType();
        Node child = node.getFirstChild();
        switch (type) {
            case 114: {
                final int fnIndex = node.getExistingIntProp(1);
                final int fnType = this.scriptOrFn.getFunctionNode(fnIndex).getFunctionType();
                if (fnType == 3) {
                    this.addIndexOp(-20, fnIndex);
                }
                else if (fnType != 1) {
                    throw Kit.codeBug();
                }
                if (!this.itsInFunctionFlag) {
                    this.addIndexOp(-19, fnIndex);
                    this.stackChange(1);
                    this.addIcode(-5);
                    this.stackChange(-1);
                }
                break;
            }
            case 132:
            case 138:
            case 139:
            case 140:
            case 142: {
                this.updateLineNumber(node);
            }
            case 146: {
                while (child != null) {
                    this.visitStatement(child, initialStackDepth);
                    child = child.getNext();
                }
                break;
            }
            case 2: {
                this.visitExpression(child, 0);
                this.addToken(2);
                this.stackChange(-1);
                break;
            }
            case 3: {
                this.addToken(3);
                break;
            }
            case 151: {
                final int local = this.allocLocal();
                node.putIntProp(2, local);
                this.updateLineNumber(node);
                while (child != null) {
                    this.visitStatement(child, initialStackDepth);
                    child = child.getNext();
                }
                this.addIndexOp(-56, local);
                this.releaseLocal(local);
                break;
            }
            case 165: {
                this.addIcode(-64);
                break;
            }
            case 123: {
                this.updateLineNumber(node);
                this.visitExpression(child, 0);
                for (Jump caseNode = (Jump)child.getNext(); caseNode != null; caseNode = (Jump)caseNode.getNext()) {
                    if (caseNode.getType() != 124) {
                        throw this.badTree((Node)caseNode);
                    }
                    final Node test = caseNode.getFirstChild();
                    this.addIcode(-1);
                    this.stackChange(1);
                    this.visitExpression(test, 0);
                    this.addToken(49);
                    this.stackChange(-1);
                    this.addGoto(caseNode.target, -6);
                    this.stackChange(-1);
                }
                this.addIcode(-4);
                this.stackChange(-1);
                break;
            }
            case 141: {
                this.markTargetLabel(node);
                break;
            }
            case 6:
            case 7: {
                final Node target = ((Jump)node).target;
                this.visitExpression(child, 0);
                this.addGoto(target, type);
                this.stackChange(-1);
                break;
            }
            case 5: {
                final Node target = ((Jump)node).target;
                this.addGoto(target, type);
                break;
            }
            case 145: {
                final Node target = ((Jump)node).target;
                this.addGoto(target, -23);
                break;
            }
            case 134: {
                this.stackChange(1);
                final int finallyRegister = this.getLocalBlockRef(node);
                this.addIndexOp(-24, finallyRegister);
                this.stackChange(-1);
                while (child != null) {
                    this.visitStatement(child, initialStackDepth);
                    child = child.getNext();
                }
                this.addIndexOp(-25, finallyRegister);
                break;
            }
            case 143:
            case 144: {
                this.updateLineNumber(node);
                this.visitExpression(child, 0);
                this.addIcode((type == 143) ? -4 : -5);
                this.stackChange(-1);
                break;
            }
            case 78: {
                final Jump tryNode = (Jump)node;
                final int exceptionObjectLocal = this.getLocalBlockRef((Node)tryNode);
                final int scopeLocal = this.allocLocal();
                this.addIndexOp(-13, scopeLocal);
                final int tryStart = this.iCodeTop;
                final boolean savedFlag = this.itsInTryFlag;
                this.itsInTryFlag = true;
                while (child != null) {
                    this.visitStatement(child, initialStackDepth);
                    child = child.getNext();
                }
                this.itsInTryFlag = savedFlag;
                final Node catchTarget = tryNode.target;
                if (catchTarget != null) {
                    final int catchStartPC = this.labelTable[this.getTargetLabel(catchTarget)];
                    this.addExceptionHandler(tryStart, catchStartPC, catchStartPC, false, exceptionObjectLocal, scopeLocal);
                }
                final Node finallyTarget = tryNode.getFinally();
                if (finallyTarget != null) {
                    final int finallyStartPC = this.labelTable[this.getTargetLabel(finallyTarget)];
                    this.addExceptionHandler(tryStart, finallyStartPC, finallyStartPC, true, exceptionObjectLocal, scopeLocal);
                }
                this.addIndexOp(-56, scopeLocal);
                this.releaseLocal(scopeLocal);
                break;
            }
            case 60: {
                final int localIndex = this.getLocalBlockRef(node);
                final int scopeIndex = node.getExistingIntProp(14);
                final String name = child.getString();
                child = child.getNext();
                this.visitExpression(child, 0);
                this.addStringPrefix(name);
                this.addIndexPrefix(localIndex);
                this.addToken(60);
                this.addUint8((scopeIndex != 0) ? 1 : 0);
                this.stackChange(-1);
                break;
            }
            case 53: {
                this.updateLineNumber(node);
                this.visitExpression(child, 0);
                this.addToken(53);
                this.addUint16(this.lineNumber & 0xFFFF);
                this.stackChange(-1);
                break;
            }
            case 54: {
                this.updateLineNumber(node);
                this.addIndexOp(54, this.getLocalBlockRef(node));
                break;
            }
            case 4: {
                this.updateLineNumber(node);
                if (node.getIntProp(20, 0) != 0) {
                    this.addIcode(-63);
                    this.addUint16(this.lineNumber & 0xFFFF);
                    break;
                }
                if (child != null) {
                    this.visitExpression(child, 1);
                    this.addToken(4);
                    this.stackChange(-1);
                    break;
                }
                this.addIcode(-22);
                break;
            }
            case 68: {
                this.updateLineNumber(node);
                this.addToken(68);
                break;
            }
            case 61:
            case 62:
            case 63:
            case 64: {
                this.visitExpression(child, 0);
                this.addIndexOp(type, this.getLocalBlockRef(node));
                this.stackChange(-1);
                break;
            }
            case -62: {
                break;
            }
            default: {
                throw this.badTree(node);
            }
        }
        if (this.stackDepth != initialStackDepth) {
            throw Kit.codeBug();
        }
    }
    
    private void visitExpression(final Node node, final int contextFlags) {
        int type = node.getType();
        Node child = node.getFirstChild();
        final int savedStackDepth = this.stackDepth;
        switch (type) {
            case 114: {
                final int fnIndex = node.getExistingIntProp(1);
                final FunctionNode fn = this.scriptOrFn.getFunctionNode(fnIndex);
                if (fn.getFunctionType() != 2 && fn.getFunctionType() != 4) {
                    throw Kit.codeBug();
                }
                this.addIndexOp(-19, fnIndex);
                this.stackChange(1);
                break;
            }
            case 57: {
                final int localIndex = this.getLocalBlockRef(node);
                this.addIndexOp(57, localIndex);
                this.stackChange(1);
                break;
            }
            case 86: {
                for (Node lastChild = node.getLastChild(); child != lastChild; child = child.getNext()) {
                    this.visitExpression(child, 0);
                    this.addIcode(-4);
                    this.stackChange(-1);
                }
                this.visitExpression(child, contextFlags & 0x1);
                break;
            }
            case 148: {
                this.stackChange(1);
                break;
            }
            case 31:
            case 39:
            case 74: {
                if (type == 31) {
                    this.visitExpression(child, 0);
                }
                else {
                    this.generateCallFunAndThis(child);
                }
                int argCount = 0;
                while ((child = child.getNext()) != null) {
                    this.visitExpression(child, 0);
                    ++argCount;
                }
                final int callType = node.getIntProp(10, 0);
                if (type != 74 && callType != 0) {
                    this.addIndexOp(-21, argCount);
                    this.addUint8(callType);
                    this.addUint8((type == 31) ? 1 : 0);
                    this.addUint16(this.lineNumber & 0xFFFF);
                }
                else {
                    if (type == 39 && (contextFlags & 0x1) != 0x0 && !this.compilerEnv.isGenerateDebugInfo() && !this.itsInTryFlag) {
                        type = -55;
                    }
                    this.addIndexOp(type, argCount);
                }
                if (type == 31) {
                    this.stackChange(-argCount);
                }
                else {
                    this.stackChange(-1 - argCount);
                }
                if (argCount > this.itsData.itsMaxCalleeArgs) {
                    this.itsData.itsMaxCalleeArgs = argCount;
                }
                break;
            }
            case 105:
            case 106: {
                this.visitExpression(child, 0);
                this.addIcode(-1);
                this.stackChange(1);
                final int afterSecondJumpStart = this.iCodeTop;
                final int jump = (type == 106) ? 7 : 6;
                this.addGotoOp(jump);
                this.stackChange(-1);
                this.addIcode(-4);
                this.stackChange(-1);
                child = child.getNext();
                this.visitExpression(child, contextFlags & 0x1);
                this.resolveForwardGoto(afterSecondJumpStart);
                break;
            }
            case 103: {
                final Node ifThen = child.getNext();
                final Node ifElse = ifThen.getNext();
                this.visitExpression(child, 0);
                final int elseJumpStart = this.iCodeTop;
                this.addGotoOp(7);
                this.stackChange(-1);
                this.visitExpression(ifThen, contextFlags & 0x1);
                final int afterElseJumpStart = this.iCodeTop;
                this.addGotoOp(5);
                this.resolveForwardGoto(elseJumpStart);
                this.stackDepth = savedStackDepth;
                this.visitExpression(ifElse, contextFlags & 0x1);
                this.resolveForwardGoto(afterElseJumpStart);
                break;
            }
            case 34:
            case 35: {
                this.visitExpression(child, 0);
                child = child.getNext();
                this.addStringOp(type, child.getString());
                break;
            }
            case 32: {
                final boolean isName = child.getType() == 52;
                this.visitExpression(child, 0);
                child = child.getNext();
                this.visitExpression(child, 0);
                if (isName) {
                    this.addIcode(0);
                }
                else {
                    this.addToken(32);
                }
                this.stackChange(-1);
                break;
            }
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 37:
            case 49:
            case 50:
            case 55:
            case 56: {
                this.visitExpression(child, 0);
                child = child.getNext();
                this.visitExpression(child, 0);
                this.addToken(type);
                this.stackChange(-1);
                break;
            }
            case 27:
            case 28:
            case 29:
            case 30:
            case 33:
            case 136: {
                this.visitExpression(child, 0);
                if (type == 136) {
                    this.addIcode(-4);
                    this.addIcode(-50);
                    break;
                }
                this.addToken(type);
                break;
            }
            case 71:
            case 73: {
                this.visitExpression(child, 0);
                this.addToken(type);
                break;
            }
            case 36:
            case 149: {
                this.visitExpression(child, 0);
                child = child.getNext();
                final String property = child.getString();
                child = child.getNext();
                if (type == 149) {
                    this.addIcode(-1);
                    this.stackChange(1);
                    this.addStringOp(34, property);
                    this.stackChange(-1);
                }
                this.visitExpression(child, 0);
                this.addStringOp(36, property);
                this.stackChange(-1);
                break;
            }
            case 38:
            case 150: {
                this.visitExpression(child, 0);
                child = child.getNext();
                this.visitExpression(child, 0);
                child = child.getNext();
                if (type == 150) {
                    this.addIcode(-2);
                    this.stackChange(2);
                    this.addToken(37);
                    this.stackChange(-1);
                    this.stackChange(-1);
                }
                this.visitExpression(child, 0);
                this.addToken(38);
                this.stackChange(-2);
                break;
            }
            case 72:
            case 152: {
                this.visitExpression(child, 0);
                child = child.getNext();
                if (type == 152) {
                    this.addIcode(-1);
                    this.stackChange(1);
                    this.addToken(71);
                    this.stackChange(-1);
                }
                this.visitExpression(child, 0);
                this.addToken(72);
                this.stackChange(-1);
                break;
            }
            case 8:
            case 77: {
                final String name = child.getString();
                this.visitExpression(child, 0);
                child = child.getNext();
                this.visitExpression(child, 0);
                this.addStringOp(type, name);
                this.stackChange(-1);
                break;
            }
            case 160: {
                final String name = child.getString();
                this.visitExpression(child, 0);
                child = child.getNext();
                this.visitExpression(child, 0);
                this.addStringOp(-59, name);
                this.stackChange(-1);
                break;
            }
            case 147: {
                int index = -1;
                if (this.itsInFunctionFlag && !this.itsData.itsNeedsActivation) {
                    index = this.scriptOrFn.getIndexForNameNode(node);
                }
                if (index == -1) {
                    this.addStringOp(-14, node.getString());
                    this.stackChange(1);
                }
                else {
                    this.addVarOp(58, index);
                    this.stackChange(1);
                    this.addToken(33);
                }
                break;
            }
            case 40:
            case 42:
            case 52: {
                this.addStringOp(type, node.getString());
                this.stackChange(1);
                break;
            }
            case 107:
            case 108: {
                this.visitIncDec(node, child);
                break;
            }
            case 41: {
                final double num = node.getDouble();
                final int inum = (int)num;
                if (inum == num) {
                    if (inum == 0) {
                        this.addIcode(-51);
                        if (1.0 / num < 0.0) {
                            this.addToken(30);
                        }
                    }
                    else if (inum == 1) {
                        this.addIcode(-52);
                    }
                    else if ((short)inum == inum) {
                        this.addIcode(-27);
                        this.addUint16(inum & 0xFFFF);
                    }
                    else {
                        this.addIcode(-28);
                        this.addInt(inum);
                    }
                }
                else {
                    final int index2 = this.getDoubleIndex(num);
                    this.addIndexOp(41, index2);
                }
                this.stackChange(1);
                break;
            }
            case 58: {
                if (this.itsData.itsNeedsActivation) {
                    Kit.codeBug();
                }
                final int index = this.scriptOrFn.getIndexForNameNode(node);
                this.addVarOp(58, index);
                this.stackChange(1);
                break;
            }
            case 59: {
                if (this.itsData.itsNeedsActivation) {
                    Kit.codeBug();
                }
                final int index = this.scriptOrFn.getIndexForNameNode(child);
                child = child.getNext();
                this.visitExpression(child, 0);
                this.addVarOp(59, index);
                break;
            }
            case 161: {
                if (this.itsData.itsNeedsActivation) {
                    Kit.codeBug();
                }
                final int index = this.scriptOrFn.getIndexForNameNode(child);
                child = child.getNext();
                this.visitExpression(child, 0);
                this.addVarOp(161, index);
                break;
            }
            case 45:
            case 46:
            case 47:
            case 48:
            case 67: {
                this.addToken(type);
                this.stackChange(1);
                break;
            }
            case 65:
            case 66: {
                this.addIndexOp(type, this.getLocalBlockRef(node));
                this.stackChange(1);
                break;
            }
            case 51: {
                final int index = node.getExistingIntProp(4);
                this.addIndexOp(51, index);
                this.stackChange(1);
                break;
            }
            case 69:
            case 70: {
                this.visitLiteral(node, child);
                break;
            }
            case 162: {
                this.visitArrayComprehension(node, child, child.getNext());
                break;
            }
            case 75: {
                this.visitExpression(child, 0);
                this.addStringOp(type, (String)node.getProp(17));
                break;
            }
            case 76: {
                if (child != null) {
                    this.visitExpression(child, 0);
                }
                else {
                    this.addIcode(-50);
                    this.stackChange(1);
                }
                this.addToken(76);
                this.addUint16(node.getLineno() & 0xFFFF);
                break;
            }
            case 164: {
                final Node enterWith = node.getFirstChild();
                final Node with = enterWith.getNext();
                this.visitExpression(enterWith.getFirstChild(), 0);
                this.addToken(2);
                this.stackChange(-1);
                this.visitExpression(with.getFirstChild(), 0);
                this.addToken(3);
                break;
            }
            default: {
                throw this.badTree(node);
            }
        }
        if (savedStackDepth + 1 != this.stackDepth) {
            Kit.codeBug();
        }
    }
    
    private void generateCallFunAndThis(final Node left) {
        final int type = left.getType();
        switch (type) {
            case 40: {
                final String name = left.getString();
                this.addStringOp(-15, name);
                this.stackChange(2);
                break;
            }
            case 34:
            case 37: {
                final Node target = left.getFirstChild();
                this.visitExpression(target, 0);
                final Node id = target.getNext();
                if (type == 34) {
                    final String property = id.getString();
                    this.addStringOp(-16, property);
                    this.stackChange(1);
                    break;
                }
                this.visitExpression(id, 0);
                this.addIcode(-17);
                break;
            }
            default: {
                this.visitExpression(left, 0);
                this.addIcode(-18);
                this.stackChange(1);
                break;
            }
        }
    }
    
    private void visitIncDec(final Node node, final Node child) {
        final int incrDecrMask = node.getExistingIntProp(13);
        final int childType = child.getType();
        switch (childType) {
            case 58: {
                if (this.itsData.itsNeedsActivation) {
                    Kit.codeBug();
                }
                final int i = this.scriptOrFn.getIndexForNameNode(child);
                this.addVarOp(-7, i);
                this.addUint8(incrDecrMask);
                this.stackChange(1);
                break;
            }
            case 40: {
                final String name = child.getString();
                this.addStringOp(-8, name);
                this.addUint8(incrDecrMask);
                this.stackChange(1);
                break;
            }
            case 34: {
                final Node object = child.getFirstChild();
                this.visitExpression(object, 0);
                final String property = object.getNext().getString();
                this.addStringOp(-9, property);
                this.addUint8(incrDecrMask);
                break;
            }
            case 37: {
                final Node object = child.getFirstChild();
                this.visitExpression(object, 0);
                final Node index = object.getNext();
                this.visitExpression(index, 0);
                this.addIcode(-10);
                this.addUint8(incrDecrMask);
                this.stackChange(-1);
                break;
            }
            case 71: {
                final Node ref = child.getFirstChild();
                this.visitExpression(ref, 0);
                this.addIcode(-11);
                this.addUint8(incrDecrMask);
                break;
            }
            default: {
                throw this.badTree(node);
            }
        }
    }
    
    private void visitLiteral(final Node node, Node child) {
        final int type = node.getType();
        Object[] propertyIds = null;
        int count;
        if (type == 69) {
            count = 0;
            for (Node n = child; n != null; n = n.getNext()) {
                ++count;
            }
        }
        else {
            if (type != 70) {
                throw this.badTree(node);
            }
            propertyIds = (Object[])node.getProp(12);
            count = propertyIds.length;
        }
        this.addIndexOp(-29, count);
        this.stackChange(2);
        while (child != null) {
            final int childType = child.getType();
            if (childType == 156) {
                this.visitExpression(child.getFirstChild(), 0);
                this.addIcode(-57);
            }
            else if (childType == 157) {
                this.visitExpression(child.getFirstChild(), 0);
                this.addIcode(-58);
            }
            else if (childType == 168) {
                this.visitExpression(child.getFirstChild(), 0);
                this.addIcode(-30);
            }
            else {
                this.visitExpression(child, 0);
                this.addIcode(-30);
            }
            this.stackChange(-1);
            child = child.getNext();
        }
        if (type == 69) {
            final int[] skipIndexes = (int[])node.getProp(11);
            if (skipIndexes == null) {
                this.addToken(69);
            }
            else {
                final int index = this.literalIds.size();
                this.literalIds.add(skipIndexes);
                this.addIndexOp(-31, index);
            }
        }
        else {
            final int index2 = this.literalIds.size();
            this.literalIds.add(propertyIds);
            this.addIndexOp(70, index2);
        }
        this.stackChange(-1);
    }
    
    private void visitArrayComprehension(final Node node, final Node initStmt, final Node expr) {
        this.visitStatement(initStmt, this.stackDepth);
        this.visitExpression(expr, 0);
    }
    
    private int getLocalBlockRef(final Node node) {
        final Node localBlock = (Node)node.getProp(3);
        return localBlock.getExistingIntProp(2);
    }
    
    private int getTargetLabel(final Node target) {
        int label = target.labelId();
        if (label != -1) {
            return label;
        }
        label = this.labelTableTop;
        if (this.labelTable == null || label == this.labelTable.length) {
            if (this.labelTable == null) {
                this.labelTable = new int[32];
            }
            else {
                final int[] tmp = new int[this.labelTable.length * 2];
                System.arraycopy(this.labelTable, 0, tmp, 0, label);
                this.labelTable = tmp;
            }
        }
        this.labelTableTop = label + 1;
        this.labelTable[label] = -1;
        target.labelId(label);
        return label;
    }
    
    private void markTargetLabel(final Node target) {
        final int label = this.getTargetLabel(target);
        if (this.labelTable[label] != -1) {
            Kit.codeBug();
        }
        this.labelTable[label] = this.iCodeTop;
    }
    
    private void addGoto(final Node target, final int gotoOp) {
        final int label = this.getTargetLabel(target);
        if (label >= this.labelTableTop) {
            Kit.codeBug();
        }
        final int targetPC = this.labelTable[label];
        if (targetPC != -1) {
            this.addBackwardGoto(gotoOp, targetPC);
        }
        else {
            final int gotoPC = this.iCodeTop;
            this.addGotoOp(gotoOp);
            final int top = this.fixupTableTop;
            if (this.fixupTable == null || top == this.fixupTable.length) {
                if (this.fixupTable == null) {
                    this.fixupTable = new long[40];
                }
                else {
                    final long[] tmp = new long[this.fixupTable.length * 2];
                    System.arraycopy(this.fixupTable, 0, tmp, 0, top);
                    this.fixupTable = tmp;
                }
            }
            this.fixupTableTop = top + 1;
            this.fixupTable[top] = ((long)label << 32 | (long)gotoPC);
        }
    }
    
    private void fixLabelGotos() {
        for (int i = 0; i < this.fixupTableTop; ++i) {
            final long fixup = this.fixupTable[i];
            final int label = (int)(fixup >> 32);
            final int jumpSource = (int)fixup;
            final int pc = this.labelTable[label];
            if (pc == -1) {
                throw Kit.codeBug();
            }
            this.resolveGoto(jumpSource, pc);
        }
        this.fixupTableTop = 0;
    }
    
    private void addBackwardGoto(final int gotoOp, final int jumpPC) {
        final int fromPC = this.iCodeTop;
        if (fromPC <= jumpPC) {
            throw Kit.codeBug();
        }
        this.addGotoOp(gotoOp);
        this.resolveGoto(fromPC, jumpPC);
    }
    
    private void resolveForwardGoto(final int fromPC) {
        if (this.iCodeTop < fromPC + 3) {
            throw Kit.codeBug();
        }
        this.resolveGoto(fromPC, this.iCodeTop);
    }
    
    private void resolveGoto(final int fromPC, final int jumpPC) {
        int offset = jumpPC - fromPC;
        if (0 <= offset && offset <= 2) {
            throw Kit.codeBug();
        }
        final int offsetSite = fromPC + 1;
        if (offset != (short)offset) {
            if (this.itsData.longJumps == null) {
                this.itsData.longJumps = new UintMap();
            }
            this.itsData.longJumps.put(offsetSite, jumpPC);
            offset = 0;
        }
        final byte[] array = this.itsData.itsICode;
        array[offsetSite] = (byte)(offset >> 8);
        array[offsetSite + 1] = (byte)offset;
    }
    
    private void addToken(final int token) {
        if (!Icode.validTokenCode(token)) {
            throw Kit.codeBug();
        }
        this.addUint8(token);
    }
    
    private void addIcode(final int icode) {
        if (!Icode.validIcode(icode)) {
            throw Kit.codeBug();
        }
        this.addUint8(icode & 0xFF);
    }
    
    private void addUint8(final int value) {
        if ((value & 0xFFFFFF00) != 0x0) {
            throw Kit.codeBug();
        }
        byte[] array = this.itsData.itsICode;
        final int top = this.iCodeTop;
        if (top == array.length) {
            array = this.increaseICodeCapacity(1);
        }
        array[top] = (byte)value;
        this.iCodeTop = top + 1;
    }
    
    private void addUint16(final int value) {
        if ((value & 0xFFFF0000) != 0x0) {
            throw Kit.codeBug();
        }
        byte[] array = this.itsData.itsICode;
        final int top = this.iCodeTop;
        if (top + 2 > array.length) {
            array = this.increaseICodeCapacity(2);
        }
        array[top] = (byte)(value >>> 8);
        array[top + 1] = (byte)value;
        this.iCodeTop = top + 2;
    }
    
    private void addInt(final int i) {
        byte[] array = this.itsData.itsICode;
        final int top = this.iCodeTop;
        if (top + 4 > array.length) {
            array = this.increaseICodeCapacity(4);
        }
        array[top] = (byte)(i >>> 24);
        array[top + 1] = (byte)(i >>> 16);
        array[top + 2] = (byte)(i >>> 8);
        array[top + 3] = (byte)i;
        this.iCodeTop = top + 4;
    }
    
    private int getDoubleIndex(final double num) {
        final int index = this.doubleTableTop;
        if (index == 0) {
            this.itsData.itsDoubleTable = new double[64];
        }
        else if (this.itsData.itsDoubleTable.length == index) {
            final double[] na = new double[index * 2];
            System.arraycopy(this.itsData.itsDoubleTable, 0, na, 0, index);
            this.itsData.itsDoubleTable = na;
        }
        this.itsData.itsDoubleTable[index] = num;
        this.doubleTableTop = index + 1;
        return index;
    }
    
    private void addGotoOp(final int gotoOp) {
        byte[] array = this.itsData.itsICode;
        final int top = this.iCodeTop;
        if (top + 3 > array.length) {
            array = this.increaseICodeCapacity(3);
        }
        array[top] = (byte)gotoOp;
        this.iCodeTop = top + 1 + 2;
    }
    
    private void addVarOp(final int op, final int varIndex) {
        switch (op) {
            case 161: {
                if (varIndex < 128) {
                    this.addIcode(-61);
                    this.addUint8(varIndex);
                    return;
                }
                this.addIndexOp(-60, varIndex);
            }
            case 58:
            case 59: {
                if (varIndex < 128) {
                    this.addIcode((op == 58) ? -48 : -49);
                    this.addUint8(varIndex);
                    return;
                }
            }
            case -7: {
                this.addIndexOp(op, varIndex);
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    private void addStringOp(final int op, final String str) {
        this.addStringPrefix(str);
        if (Icode.validIcode(op)) {
            this.addIcode(op);
        }
        else {
            this.addToken(op);
        }
    }
    
    private void addIndexOp(final int op, final int index) {
        this.addIndexPrefix(index);
        if (Icode.validIcode(op)) {
            this.addIcode(op);
        }
        else {
            this.addToken(op);
        }
    }
    
    private void addStringPrefix(final String str) {
        int index = this.strings.get(str, -1);
        if (index == -1) {
            index = this.strings.size();
            this.strings.put(str, index);
        }
        if (index < 4) {
            this.addIcode(-41 - index);
        }
        else if (index <= 255) {
            this.addIcode(-45);
            this.addUint8(index);
        }
        else if (index <= 65535) {
            this.addIcode(-46);
            this.addUint16(index);
        }
        else {
            this.addIcode(-47);
            this.addInt(index);
        }
    }
    
    private void addIndexPrefix(final int index) {
        if (index < 0) {
            Kit.codeBug();
        }
        if (index < 6) {
            this.addIcode(-32 - index);
        }
        else if (index <= 255) {
            this.addIcode(-38);
            this.addUint8(index);
        }
        else if (index <= 65535) {
            this.addIcode(-39);
            this.addUint16(index);
        }
        else {
            this.addIcode(-40);
            this.addInt(index);
        }
    }
    
    private void addExceptionHandler(final int icodeStart, final int icodeEnd, final int handlerStart, final boolean isFinally, final int exceptionObjectLocal, final int scopeLocal) {
        final int top = this.exceptionTableTop;
        int[] table = this.itsData.itsExceptionTable;
        if (table == null) {
            if (top != 0) {
                Kit.codeBug();
            }
            table = new int[12];
            this.itsData.itsExceptionTable = table;
        }
        else if (table.length == top) {
            table = new int[table.length * 2];
            System.arraycopy(this.itsData.itsExceptionTable, 0, table, 0, top);
            this.itsData.itsExceptionTable = table;
        }
        table[top + 0] = icodeStart;
        table[top + 1] = icodeEnd;
        table[top + 2] = handlerStart;
        table[top + 3] = (isFinally ? 1 : 0);
        table[top + 4] = exceptionObjectLocal;
        table[top + 5] = scopeLocal;
        this.exceptionTableTop = top + 6;
    }
    
    private byte[] increaseICodeCapacity(final int extraSize) {
        int capacity = this.itsData.itsICode.length;
        final int top = this.iCodeTop;
        if (top + extraSize <= capacity) {
            throw Kit.codeBug();
        }
        capacity *= 2;
        if (top + extraSize > capacity) {
            capacity = top + extraSize;
        }
        final byte[] array = new byte[capacity];
        System.arraycopy(this.itsData.itsICode, 0, array, 0, top);
        return this.itsData.itsICode = array;
    }
    
    private void stackChange(final int change) {
        if (change <= 0) {
            this.stackDepth += change;
        }
        else {
            final int newDepth = this.stackDepth + change;
            if (newDepth > this.itsData.itsMaxStack) {
                this.itsData.itsMaxStack = newDepth;
            }
            this.stackDepth = newDepth;
        }
    }
    
    private int allocLocal() {
        final int localSlot = this.localTop;
        ++this.localTop;
        if (this.localTop > this.itsData.itsMaxLocals) {
            this.itsData.itsMaxLocals = this.localTop;
        }
        return localSlot;
    }
    
    private void releaseLocal(final int localSlot) {
        --this.localTop;
        if (localSlot != this.localTop) {
            Kit.codeBug();
        }
    }
}
