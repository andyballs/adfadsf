//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.ast.*;
import org.mozilla.javascript.generator.*;
import java.io.*;
import org.mozilla.javascript.debug.*;
import java.util.*;

public final class Interpreter extends Icode implements Evaluator
{
    InterpreterData itsData;
    static final int EXCEPTION_TRY_START_SLOT = 0;
    static final int EXCEPTION_TRY_END_SLOT = 1;
    static final int EXCEPTION_HANDLER_SLOT = 2;
    static final int EXCEPTION_TYPE_SLOT = 3;
    static final int EXCEPTION_LOCAL_SLOT = 4;
    static final int EXCEPTION_SCOPE_SLOT = 5;
    static final int EXCEPTION_SLOT_SIZE = 6;
    
    private static boolean compareIdata(final InterpreterData i1, final InterpreterData i2) {
        return i1 == i2 || Objects.equals(getEncodedSource(i1), getEncodedSource(i2));
    }
    
    private static CallFrame captureFrameForGenerator(final CallFrame frame) {
        frame.frozen = true;
        final CallFrame result = frame.cloneFrozen();
        frame.frozen = false;
        result.parentFrame = null;
        result.frameIndex = 0;
        return result;
    }
    
    public Object compile(final CompilerEnvirons compilerEnv, final ScriptNode tree, final String encodedSource, final boolean returnFunction) {
        final CodeGenerator cgen = new CodeGenerator();
        return this.itsData = cgen.compile(compilerEnv, tree, encodedSource, returnFunction);
    }
    
    public Script createScriptObject(final Object bytecode, final Object staticSecurityDomain) {
        if (bytecode != this.itsData) {
            Kit.codeBug();
        }
        return (Script)InterpretedFunction.createScript(this.itsData, staticSecurityDomain);
    }
    
    public void setEvalScriptFlag(final Script script) {
        ((InterpretedFunction)script).idata.evalScriptFlag = true;
    }
    
    public Function createFunctionObject(final Context cx, final Scriptable scope, final Object bytecode, final Object staticSecurityDomain) {
        if (bytecode != this.itsData) {
            Kit.codeBug();
        }
        return (Function)InterpretedFunction.createFunction(cx, scope, this.itsData, staticSecurityDomain);
    }
    
    private static int getShort(final byte[] iCode, final int pc) {
        return iCode[pc] << 8 | (iCode[pc + 1] & 0xFF);
    }
    
    private static int getIndex(final byte[] iCode, final int pc) {
        return (iCode[pc] & 0xFF) << 8 | (iCode[pc + 1] & 0xFF);
    }
    
    private static int getInt(final byte[] iCode, final int pc) {
        return iCode[pc] << 24 | (iCode[pc + 1] & 0xFF) << 16 | (iCode[pc + 2] & 0xFF) << 8 | (iCode[pc + 3] & 0xFF);
    }
    
    private static int getExceptionHandler(final CallFrame frame, final boolean onlyFinally) {
        final int[] exceptionTable = frame.idata.itsExceptionTable;
        if (exceptionTable == null) {
            return -1;
        }
        final int pc = frame.pc - 1;
        int best = -1;
        int bestStart = 0;
        int bestEnd = 0;
        for (int i = 0; i != exceptionTable.length; i += 6) {
            final int start = exceptionTable[i + 0];
            final int end = exceptionTable[i + 1];
            if (start <= pc) {
                if (pc < end) {
                    if (!onlyFinally || exceptionTable[i + 3] == 1) {
                        if (best >= 0) {
                            if (bestEnd < end) {
                                continue;
                            }
                            if (bestStart > start) {
                                Kit.codeBug();
                            }
                            if (bestEnd == end) {
                                Kit.codeBug();
                            }
                        }
                        best = i;
                        bestStart = start;
                        bestEnd = end;
                    }
                }
            }
        }
        return best;
    }
    
    static void dumpICode(final InterpreterData idata) {
    }
    
    private static int bytecodeSpan(final int bytecode) {
        switch (bytecode) {
            case -63:
            case -62:
            case 53:
            case 76: {
                return 3;
            }
            case -54:
            case -23:
            case -6:
            case 5:
            case 6:
            case 7: {
                return 3;
            }
            case -21: {
                return 5;
            }
            case 60: {
                return 2;
            }
            case -11:
            case -10:
            case -9:
            case -8:
            case -7: {
                return 2;
            }
            case -27: {
                return 3;
            }
            case -28: {
                return 5;
            }
            case -38: {
                return 2;
            }
            case -39: {
                return 3;
            }
            case -40: {
                return 5;
            }
            case -45: {
                return 2;
            }
            case -46: {
                return 3;
            }
            case -47: {
                return 5;
            }
            case -61:
            case -49:
            case -48: {
                return 2;
            }
            case -26: {
                return 3;
            }
            default: {
                if (!validBytecode(bytecode)) {
                    throw Kit.codeBug();
                }
                return 1;
            }
        }
    }
    
    static int[] getLineNumbers(final InterpreterData data) {
        final UintMap presentLines = new UintMap();
        final byte[] iCode = data.itsICode;
        int span;
        for (int iCodeLength = iCode.length, pc = 0; pc != iCodeLength; pc += span) {
            final int bytecode = iCode[pc];
            span = bytecodeSpan(bytecode);
            if (bytecode == -26) {
                if (span != 3) {
                    Kit.codeBug();
                }
                final int line = getIndex(iCode, pc + 1);
                presentLines.put(line, 0);
            }
        }
        return presentLines.getKeys();
    }
    
    public void captureStackInfo(final RhinoException ex) {
        final Context cx = Context.getCurrentContext();
        if (cx == null || cx.lastInterpreterFrame == null) {
            ex.interpreterStackInfo = null;
            ex.interpreterLineData = null;
            return;
        }
        CallFrame[] array;
        if (cx.previousInterpreterInvocations == null || cx.previousInterpreterInvocations.size() == 0) {
            array = new CallFrame[] { null };
        }
        else {
            int previousCount = cx.previousInterpreterInvocations.size();
            if (cx.previousInterpreterInvocations.peek() == cx.lastInterpreterFrame) {
                --previousCount;
            }
            array = new CallFrame[previousCount + 1];
            cx.previousInterpreterInvocations.toArray(array);
        }
        array[array.length - 1] = (CallFrame)cx.lastInterpreterFrame;
        int interpreterFrameCount = 0;
        for (int i = 0; i != array.length; ++i) {
            interpreterFrameCount += 1 + array[i].frameIndex;
        }
        final int[] linePC = new int[interpreterFrameCount];
        int linePCIndex = interpreterFrameCount;
        int j = array.length;
        while (j != 0) {
            --j;
            for (CallFrame frame = array[j]; frame != null; frame = frame.parentFrame) {
                --linePCIndex;
                linePC[linePCIndex] = frame.pcSourceLineStart;
            }
        }
        if (linePCIndex != 0) {
            Kit.codeBug();
        }
        ex.interpreterStackInfo = array;
        ex.interpreterLineData = linePC;
    }
    
    public String getSourcePositionFromStack(final Context cx, final int[] linep) {
        final CallFrame frame = (CallFrame)cx.lastInterpreterFrame;
        final InterpreterData idata = frame.idata;
        if (frame.pcSourceLineStart >= 0) {
            linep[0] = getIndex(idata.itsICode, frame.pcSourceLineStart);
        }
        else {
            linep[0] = 0;
        }
        return idata.itsSourceFile;
    }
    
    public String getPatchedStack(final RhinoException ex, final String nativeStackTrace) {
        final String tag = "org.mozilla.javascript.Interpreter.interpretLoop";
        final StringBuilder sb = new StringBuilder(nativeStackTrace.length() + 1000);
        final String lineSeparator = SecurityUtilities.getSystemProperty("line.separator");
        final CallFrame[] array = (CallFrame[])ex.interpreterStackInfo;
        final int[] linePC = ex.interpreterLineData;
        int arrayIndex = array.length;
        int linePCIndex = linePC.length;
        int offset = 0;
        while (arrayIndex != 0) {
            --arrayIndex;
            int pos = nativeStackTrace.indexOf(tag, offset);
            if (pos < 0) {
                break;
            }
            for (pos += tag.length(); pos != nativeStackTrace.length(); ++pos) {
                final char c = nativeStackTrace.charAt(pos);
                if (c == '\n') {
                    break;
                }
                if (c == '\r') {
                    break;
                }
            }
            sb.append(nativeStackTrace, offset, pos);
            offset = pos;
            for (CallFrame frame = array[arrayIndex]; frame != null; frame = frame.parentFrame) {
                if (linePCIndex == 0) {
                    Kit.codeBug();
                }
                --linePCIndex;
                final InterpreterData idata = frame.idata;
                sb.append(lineSeparator);
                sb.append("\tat script");
                if (idata.itsName != null && idata.itsName.length() != 0) {
                    sb.append('.');
                    sb.append(idata.itsName);
                }
                sb.append('(');
                sb.append(idata.itsSourceFile);
                final int pc = linePC[linePCIndex];
                if (pc >= 0) {
                    sb.append(':');
                    sb.append(getIndex(idata.itsICode, pc));
                }
                sb.append(')');
            }
        }
        sb.append(nativeStackTrace.substring(offset));
        return sb.toString();
    }
    
    public List<String> getScriptStack(final RhinoException ex) {
        final ScriptStackElement[][] stack = this.getScriptStackElements(ex);
        final List<String> list = new ArrayList<String>(stack.length);
        final String lineSeparator = SecurityUtilities.getSystemProperty("line.separator");
        for (final ScriptStackElement[] group : stack) {
            final StringBuilder sb = new StringBuilder();
            for (final ScriptStackElement elem : group) {
                elem.renderJavaStyle(sb);
                sb.append(lineSeparator);
            }
            list.add(sb.toString());
        }
        return list;
    }
    
    public ScriptStackElement[][] getScriptStackElements(final RhinoException ex) {
        if (ex.interpreterStackInfo == null) {
            return null;
        }
        final List<ScriptStackElement[]> list = new ArrayList<ScriptStackElement[]>();
        final CallFrame[] array = (CallFrame[])ex.interpreterStackInfo;
        final int[] linePC = ex.interpreterLineData;
        int arrayIndex = array.length;
        int linePCIndex = linePC.length;
        while (arrayIndex != 0) {
            --arrayIndex;
            CallFrame frame = array[arrayIndex];
            final List<ScriptStackElement> group = new ArrayList<ScriptStackElement>();
            while (frame != null) {
                if (linePCIndex == 0) {
                    Kit.codeBug();
                }
                --linePCIndex;
                final InterpreterData idata = frame.idata;
                final String fileName = idata.itsSourceFile;
                String functionName = null;
                int lineNumber = -1;
                final int pc = linePC[linePCIndex];
                if (pc >= 0) {
                    lineNumber = getIndex(idata.itsICode, pc);
                }
                if (idata.itsName != null && idata.itsName.length() != 0) {
                    functionName = idata.itsName;
                }
                frame = frame.parentFrame;
                group.add(new ScriptStackElement(fileName, functionName, lineNumber));
            }
            list.add(group.toArray(new ScriptStackElement[group.size()]));
        }
        return list.toArray(new ScriptStackElement[list.size()][]);
    }
    
    static String getEncodedSource(final InterpreterData idata) {
        if (idata.encodedSource == null) {
            return null;
        }
        return idata.encodedSource.substring(idata.encodedSourceStart, idata.encodedSourceEnd);
    }
    
    private static void initFunction(final Context cx, final Scriptable scope, final InterpretedFunction parent, final int index) {
        final InterpretedFunction fn = InterpretedFunction.createFunction(cx, scope, parent, index);
        ScriptRuntime.initFunction(cx, scope, (NativeFunction)fn, fn.idata.itsFunctionType, parent.idata.evalScriptFlag);
    }
    
    static Object interpret(final InterpretedFunction ifun, final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (!ScriptRuntime.hasTopCall(cx)) {
            Kit.codeBug();
        }
        if (cx.interpreterSecurityDomain != ifun.securityDomain) {
            final Object savedDomain = cx.interpreterSecurityDomain;
            cx.interpreterSecurityDomain = ifun.securityDomain;
            try {
                return ifun.securityController.callWithDomain(ifun.securityDomain, cx, (Callable)ifun, scope, thisObj, args);
            }
            finally {
                cx.interpreterSecurityDomain = savedDomain;
            }
        }
        final CallFrame frame = initFrame(cx, scope, thisObj, args, null, 0, args.length, ifun, null);
        frame.isContinuationsTopFrame = cx.isContinuationsTopCall;
        cx.isContinuationsTopCall = false;
        return interpretLoop(cx, frame, null);
    }
    
    public static Object resumeGenerator(final Context cx, final Scriptable scope, final int operation, final Object savedState, final Object value) {
        final CallFrame frame = (CallFrame)savedState;
        final GeneratorState generatorState = new GeneratorState(operation, value);
        if (operation == 2) {
            try {
                return interpretLoop(cx, frame, generatorState);
            }
            catch (RuntimeException e) {
                if (e != value) {
                    throw e;
                }
                return Undefined.instance;
            }
        }
        final Object result = interpretLoop(cx, frame, generatorState);
        if (generatorState.returnedException != null) {
            throw generatorState.returnedException;
        }
        return result;
    }
    
    public static Object restartContinuation(final NativeContinuation c, final Context cx, final Scriptable scope, final Object[] args) {
        if (!ScriptRuntime.hasTopCall(cx)) {
            return ScriptRuntime.doTopCall((Callable)c, cx, scope, null, args, cx.isTopLevelStrict);
        }
        Object arg;
        if (args.length == 0) {
            arg = Undefined.instance;
        }
        else {
            arg = args[0];
        }
        final CallFrame capturedFrame = (CallFrame)c.getImplementation();
        if (capturedFrame == null) {
            return arg;
        }
        final ContinuationJump cjump = new ContinuationJump(c, null);
        cjump.result = arg;
        return interpretLoop(cx, null, cjump);
    }
    
    private static Object interpretLoop(final Context cx, CallFrame frame, Object throwable) {
        final Object DBL_MRK = UniqueTag.DOUBLE_MARK;
        final Object undefined = Undefined.instance;
        final boolean instructionCounting = cx.instructionThreshold != 0;
        final int INVOCATION_COST = 100;
        final int EXCEPTION_COST = 100;
        String stringReg = null;
        int indexReg = -1;
        if (cx.lastInterpreterFrame != null) {
            if (cx.previousInterpreterInvocations == null) {
                cx.previousInterpreterInvocations = new ObjArray();
            }
            cx.previousInterpreterInvocations.push(cx.lastInterpreterFrame);
        }
        GeneratorState generatorState = null;
        if (throwable != null) {
            if (throwable instanceof GeneratorState) {
                generatorState = (GeneratorState)throwable;
                enterFrame(cx, frame, ScriptRuntime.emptyArgs, true);
                throwable = null;
            }
            else if (!(throwable instanceof ContinuationJump)) {
                Kit.codeBug();
            }
        }
        Object interpreterResult = null;
        double interpreterResultDbl = 0.0;
    Label_0124_Outer:
        while (true) {
        Label_0124:
            while (true) {
                Label_5602: {
                    try {
                        while (true) {
                            if (throwable != null) {
                                frame = processThrowable(cx, throwable, frame, indexReg, instructionCounting);
                                throwable = frame.throwable;
                                frame.throwable = null;
                            }
                            else if (generatorState == null && frame.frozen) {
                                Kit.codeBug();
                            }
                            final Object[] stack = frame.stack;
                            final double[] sDbl = frame.sDbl;
                            final Object[] vars = frame.varSource.stack;
                            final double[] varDbls = frame.varSource.sDbl;
                            final int[] varAttributes = frame.varSource.stackAttributes;
                            final byte[] iCode = frame.idata.itsICode;
                            final String[] strings = frame.idata.itsStringTable;
                            int stackTop = frame.savedStackTop;
                            cx.lastInterpreterFrame = frame;
                        Label_5518:
                            while (true) {
                                final int op = iCode[frame.pc++];
                                switch (op) {
                                    case -62: {
                                        if (!frame.frozen) {
                                            final CallFrame callFrame = frame;
                                            --callFrame.pc;
                                            final CallFrame generatorFrame = captureFrameForGenerator(frame);
                                            generatorFrame.frozen = true;
                                            final NativeGenerator generator = new NativeGenerator(frame.scope, (NativeFunction)generatorFrame.fnOrScript, (Object)generatorFrame);
                                            frame.result = generator;
                                            break Label_5518;
                                        }
                                    }
                                    case 76: {
                                        if (!frame.frozen) {
                                            return freezeGenerator(cx, frame, stackTop, generatorState);
                                        }
                                        final Object obj = thawGenerator(frame, stackTop, generatorState, op);
                                        if (obj != Scriptable.NOT_FOUND) {
                                            throwable = obj;
                                            break Label_5602;
                                        }
                                        continue Label_0124_Outer;
                                    }
                                    case -63: {
                                        frame.frozen = true;
                                        final int sourceLine = getIndex(iCode, frame.pc);
                                        generatorState.returnedException = new JavaScriptException(NativeIterator.getStopIterationObject(frame.scope), frame.idata.itsSourceFile, sourceLine);
                                        break Label_5518;
                                    }
                                    case 53: {
                                        Object value = stack[stackTop];
                                        if (value == DBL_MRK) {
                                            value = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        final int sourceLine2 = getIndex(iCode, frame.pc);
                                        throwable = new JavaScriptException(value, frame.idata.itsSourceFile, sourceLine2);
                                        break Label_5602;
                                    }
                                    case 54: {
                                        indexReg += frame.localShift;
                                        throwable = stack[indexReg];
                                        break Label_5602;
                                    }
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17: {
                                        stackTop = doCompare(frame, op, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 55:
                                    case 56: {
                                        stackTop = doInOrInstanceof(cx, op, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 12:
                                    case 13: {
                                        --stackTop;
                                        boolean valBln = doEquals(stack, sDbl, stackTop);
                                        valBln ^= (op == 13);
                                        stack[stackTop] = ScriptRuntime.wrapBoolean(valBln);
                                        continue Label_0124_Outer;
                                    }
                                    case 49:
                                    case 50: {
                                        --stackTop;
                                        boolean valBln = doShallowEquals(stack, sDbl, stackTop);
                                        valBln ^= (op == 50);
                                        stack[stackTop] = ScriptRuntime.wrapBoolean(valBln);
                                        continue Label_0124_Outer;
                                    }
                                    case 7: {
                                        if (stack_boolean(frame, stackTop--)) {
                                            final CallFrame callFrame2 = frame;
                                            callFrame2.pc += 2;
                                            continue Label_0124_Outer;
                                        }
                                        break;
                                    }
                                    case 6: {
                                        if (!stack_boolean(frame, stackTop--)) {
                                            final CallFrame callFrame3 = frame;
                                            callFrame3.pc += 2;
                                            continue Label_0124_Outer;
                                        }
                                        break;
                                    }
                                    case -6: {
                                        if (!stack_boolean(frame, stackTop--)) {
                                            final CallFrame callFrame4 = frame;
                                            callFrame4.pc += 2;
                                            continue Label_0124_Outer;
                                        }
                                        stack[stackTop--] = null;
                                        break;
                                    }
                                    case 5: {
                                        break;
                                    }
                                    case -23: {
                                        ++stackTop;
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = frame.pc + 2;
                                        break;
                                    }
                                    case -24: {
                                        if (stackTop == frame.emptyStackTop + 1) {
                                            indexReg += frame.localShift;
                                            stack[indexReg] = stack[stackTop];
                                            sDbl[indexReg] = sDbl[stackTop];
                                            --stackTop;
                                            continue Label_0124_Outer;
                                        }
                                        if (stackTop != frame.emptyStackTop) {
                                            Kit.codeBug();
                                            continue Label_0124_Outer;
                                        }
                                        continue Label_0124_Outer;
                                    }
                                    case -25: {
                                        if (instructionCounting) {
                                            addInstructionCount(cx, frame, 0);
                                        }
                                        indexReg += frame.localShift;
                                        final Object value = stack[indexReg];
                                        if (value != DBL_MRK) {
                                            throwable = value;
                                            break Label_5602;
                                        }
                                        frame.pc = (int)sDbl[indexReg];
                                        if (instructionCounting) {
                                            frame.pcPrevBranch = frame.pc;
                                            continue Label_0124_Outer;
                                        }
                                        continue Label_0124_Outer;
                                    }
                                    case -4: {
                                        stack[stackTop] = null;
                                        --stackTop;
                                        continue Label_0124_Outer;
                                    }
                                    case -5: {
                                        frame.result = stack[stackTop];
                                        frame.resultDbl = sDbl[stackTop];
                                        stack[stackTop] = null;
                                        --stackTop;
                                        continue Label_0124_Outer;
                                    }
                                    case -1: {
                                        stack[stackTop + 1] = stack[stackTop];
                                        sDbl[stackTop + 1] = sDbl[stackTop];
                                        ++stackTop;
                                        continue Label_0124_Outer;
                                    }
                                    case -2: {
                                        stack[stackTop + 1] = stack[stackTop - 1];
                                        sDbl[stackTop + 1] = sDbl[stackTop - 1];
                                        stack[stackTop + 2] = stack[stackTop];
                                        sDbl[stackTop + 2] = sDbl[stackTop];
                                        stackTop += 2;
                                        continue Label_0124_Outer;
                                    }
                                    case -3: {
                                        final Object o = stack[stackTop];
                                        stack[stackTop] = stack[stackTop - 1];
                                        stack[stackTop - 1] = o;
                                        final double d = sDbl[stackTop];
                                        sDbl[stackTop] = sDbl[stackTop - 1];
                                        sDbl[stackTop - 1] = d;
                                        continue Label_0124_Outer;
                                    }
                                    case 4: {
                                        frame.result = stack[stackTop];
                                        frame.resultDbl = sDbl[stackTop];
                                        --stackTop;
                                        break Label_5518;
                                    }
                                    case 68: {
                                        break Label_5518;
                                    }
                                    case -22: {
                                        frame.result = undefined;
                                        break Label_5518;
                                    }
                                    case 28: {
                                        final int rIntValue = stack_int32(frame, stackTop);
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = ~rIntValue;
                                        continue Label_0124_Outer;
                                    }
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 18:
                                    case 19: {
                                        stackTop = doBitOp(frame, op, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 20: {
                                        final double lDbl = stack_double(frame, stackTop - 1);
                                        final int rIntValue2 = stack_int32(frame, stackTop) & 0x1F;
                                        stack[--stackTop] = DBL_MRK;
                                        sDbl[stackTop] = (double)(ScriptRuntime.toUint32(lDbl) >>> rIntValue2);
                                        continue Label_0124_Outer;
                                    }
                                    case 29:
                                    case 30: {
                                        double rDbl = stack_double(frame, stackTop);
                                        stack[stackTop] = DBL_MRK;
                                        if (op == 30) {
                                            rDbl = -rDbl;
                                        }
                                        sDbl[stackTop] = rDbl;
                                        continue Label_0124_Outer;
                                    }
                                    case 21: {
                                        --stackTop;
                                        doAdd(stack, sDbl, stackTop, cx);
                                        continue Label_0124_Outer;
                                    }
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25: {
                                        stackTop = doArithmetic(frame, op, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 27: {
                                        stack[stackTop] = ScriptRuntime.wrapBoolean(!stack_boolean(frame, stackTop));
                                        continue Label_0124_Outer;
                                    }
                                    case 52: {
                                        stack[++stackTop] = ScriptRuntime.bind(cx, frame.scope, stringReg);
                                        continue Label_0124_Outer;
                                    }
                                    case 8:
                                    case 77: {
                                        Object rhs = stack[stackTop];
                                        if (rhs == DBL_MRK) {
                                            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        final Scriptable lhs = (Scriptable)stack[stackTop];
                                        stack[stackTop] = ((op == 8) ? ScriptRuntime.setName(lhs, rhs, cx, frame.scope, stringReg) : ScriptRuntime.strictSetName(lhs, rhs, cx, frame.scope, stringReg));
                                        continue Label_0124_Outer;
                                    }
                                    case -59: {
                                        Object rhs = stack[stackTop];
                                        if (rhs == DBL_MRK) {
                                            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        final Scriptable lhs = (Scriptable)stack[stackTop];
                                        stack[stackTop] = ScriptRuntime.setConst(lhs, rhs, cx, stringReg);
                                        continue Label_0124_Outer;
                                    }
                                    case 0:
                                    case 32: {
                                        stackTop = doDelName(cx, frame, op, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 35: {
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 == DBL_MRK) {
                                            lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.getObjectPropNoWarn(lhs2, stringReg, cx, frame.scope, false);
                                        continue Label_0124_Outer;
                                    }
                                    case 34: {
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 == DBL_MRK) {
                                            lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.getObjectProp(lhs2, stringReg, cx, frame.scope, false);
                                        continue Label_0124_Outer;
                                    }
                                    case 36: {
                                        Object rhs = stack[stackTop];
                                        if (rhs == DBL_MRK) {
                                            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        Object lhs3 = stack[stackTop];
                                        if (lhs3 == DBL_MRK) {
                                            lhs3 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.setObjectProp(lhs3, stringReg, rhs, cx, frame.scope, false);
                                        continue Label_0124_Outer;
                                    }
                                    case -9: {
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 == DBL_MRK) {
                                            lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.propIncrDecr(lhs2, stringReg, cx, frame.scope, iCode[frame.pc]);
                                        final CallFrame callFrame5 = frame;
                                        ++callFrame5.pc;
                                        continue Label_0124_Outer;
                                    }
                                    case 37: {
                                        stackTop = doGetElem(cx, frame, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 38: {
                                        stackTop = doSetElem(cx, frame, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case -10: {
                                        stackTop = doElemIncDec(cx, frame, iCode, stack, sDbl, stackTop);
                                        continue Label_0124_Outer;
                                    }
                                    case 71: {
                                        final Ref ref = (Ref)stack[stackTop];
                                        stack[stackTop] = ScriptRuntime.refGet(ref, cx);
                                        continue Label_0124_Outer;
                                    }
                                    case 72: {
                                        Object value = stack[stackTop];
                                        if (value == DBL_MRK) {
                                            value = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        final Ref ref2 = (Ref)stack[stackTop];
                                        stack[stackTop] = ScriptRuntime.refSet(ref2, value, cx, frame.scope);
                                        continue Label_0124_Outer;
                                    }
                                    case 73: {
                                        final Ref ref = (Ref)stack[stackTop];
                                        stack[stackTop] = ScriptRuntime.refDel(ref, cx);
                                        continue Label_0124_Outer;
                                    }
                                    case -11: {
                                        final Ref ref = (Ref)stack[stackTop];
                                        stack[stackTop] = ScriptRuntime.refIncrDecr(ref, cx, frame.scope, iCode[frame.pc]);
                                        final CallFrame callFrame6 = frame;
                                        ++callFrame6.pc;
                                        continue Label_0124_Outer;
                                    }
                                    case 57: {
                                        ++stackTop;
                                        indexReg += frame.localShift;
                                        stack[stackTop] = stack[indexReg];
                                        sDbl[stackTop] = sDbl[indexReg];
                                        continue Label_0124_Outer;
                                    }
                                    case -56: {
                                        indexReg += frame.localShift;
                                        stack[indexReg] = null;
                                        continue Label_0124_Outer;
                                    }
                                    case -15: {
                                        ++stackTop;
                                        stack[stackTop] = ScriptRuntime.getNameFunctionAndThis(stringReg, cx, frame.scope);
                                        ++stackTop;
                                        stack[stackTop] = ScriptRuntime.lastStoredScriptable(cx);
                                        continue Label_0124_Outer;
                                    }
                                    case -16: {
                                        Object obj = stack[stackTop];
                                        if (obj == DBL_MRK) {
                                            obj = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.getPropFunctionAndThis(obj, stringReg, cx, frame.scope);
                                        ++stackTop;
                                        stack[stackTop] = ScriptRuntime.lastStoredScriptable(cx);
                                        continue Label_0124_Outer;
                                    }
                                    case -17: {
                                        Object obj = stack[stackTop - 1];
                                        if (obj == DBL_MRK) {
                                            obj = ScriptRuntime.wrapNumber(sDbl[stackTop - 1]);
                                        }
                                        Object id = stack[stackTop];
                                        if (id == DBL_MRK) {
                                            id = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop - 1] = ScriptRuntime.getElemFunctionAndThis(obj, id, cx, frame.scope);
                                        stack[stackTop] = ScriptRuntime.lastStoredScriptable(cx);
                                        continue Label_0124_Outer;
                                    }
                                    case -18: {
                                        Object value = stack[stackTop];
                                        if (value == DBL_MRK) {
                                            value = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.getValueFunctionAndThis(value, cx);
                                        ++stackTop;
                                        stack[stackTop] = ScriptRuntime.lastStoredScriptable(cx);
                                        continue Label_0124_Outer;
                                    }
                                    case -21: {
                                        if (instructionCounting) {
                                            cx.instructionCount += 100;
                                        }
                                        stackTop = doCallSpecial(cx, frame, stack, sDbl, stackTop, iCode, indexReg);
                                        continue Label_0124_Outer;
                                    }
                                    case -55:
                                    case 39:
                                    case 74: {
                                        if (instructionCounting) {
                                            cx.instructionCount += 100;
                                        }
                                        stackTop -= 1 + indexReg;
                                        final Callable fun = (Callable)stack[stackTop];
                                        final Scriptable funThisObj = (Scriptable)stack[stackTop + 1];
                                        if (op == 74) {
                                            final Object[] outArgs = getArgsArray(stack, sDbl, stackTop + 2, indexReg);
                                            stack[stackTop] = ScriptRuntime.callRef(fun, funThisObj, outArgs, cx);
                                            continue Label_0124_Outer;
                                        }
                                        Scriptable calleeScope = frame.scope;
                                        if (frame.useActivation) {
                                            calleeScope = ScriptableObject.getTopLevelScope(frame.scope);
                                        }
                                        if (fun instanceof InterpretedFunction) {
                                            final InterpretedFunction ifun = (InterpretedFunction)fun;
                                            if (frame.fnOrScript.securityDomain == ifun.securityDomain) {
                                                CallFrame callParentFrame = frame;
                                                if (op == -55) {
                                                    callParentFrame = frame.parentFrame;
                                                    exitFrame(cx, frame, null);
                                                }
                                                final CallFrame calleeFrame = initFrame(cx, calleeScope, funThisObj, stack, sDbl, stackTop + 2, indexReg, ifun, callParentFrame);
                                                if (op != -55) {
                                                    frame.savedStackTop = stackTop;
                                                    frame.savedCallOp = op;
                                                }
                                                frame = calleeFrame;
                                                continue Label_0124;
                                            }
                                        }
                                        if (fun instanceof NativeContinuation) {
                                            final ContinuationJump cjump = new ContinuationJump((NativeContinuation)fun, frame);
                                            if (indexReg == 0) {
                                                cjump.result = undefined;
                                            }
                                            else {
                                                cjump.result = stack[stackTop + 2];
                                                cjump.resultDbl = sDbl[stackTop + 2];
                                            }
                                            throwable = cjump;
                                            break Label_5602;
                                        }
                                        if (fun instanceof IdFunctionObject) {
                                            final IdFunctionObject ifun2 = (IdFunctionObject)fun;
                                            if (NativeContinuation.isContinuationConstructor(ifun2)) {
                                                frame.stack[stackTop] = captureContinuation(cx, frame.parentFrame, false);
                                                continue Label_0124_Outer;
                                            }
                                            if (BaseFunction.isApplyOrCall(ifun2)) {
                                                final Callable applyCallable = ScriptRuntime.getCallable(funThisObj);
                                                if (applyCallable instanceof InterpretedFunction) {
                                                    final InterpretedFunction iApplyCallable = (InterpretedFunction)applyCallable;
                                                    if (frame.fnOrScript.securityDomain == iApplyCallable.securityDomain) {
                                                        frame = initFrameForApplyOrCall(cx, frame, indexReg, stack, sDbl, stackTop, op, calleeScope, ifun2, iApplyCallable);
                                                        continue Label_0124;
                                                    }
                                                }
                                            }
                                        }
                                        cx.lastInterpreterFrame = frame;
                                        frame.savedCallOp = op;
                                        stack[frame.savedStackTop = stackTop] = fun.call(cx, calleeScope, funThisObj, getArgsArray(stack, sDbl, stackTop + 2, indexReg));
                                        continue Label_0124_Outer;
                                    }
                                    case 31: {
                                        if (instructionCounting) {
                                            cx.instructionCount += 100;
                                        }
                                        stackTop -= indexReg;
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 instanceof InterpretedFunction) {
                                            final InterpretedFunction f = (InterpretedFunction)lhs2;
                                            if (frame.fnOrScript.securityDomain == f.securityDomain) {
                                                final Scriptable newInstance = f.createObject(cx, frame.scope);
                                                final CallFrame calleeFrame2 = initFrame(cx, frame.scope, newInstance, stack, sDbl, stackTop + 1, indexReg, f, frame);
                                                stack[stackTop] = newInstance;
                                                frame.savedStackTop = stackTop;
                                                frame.savedCallOp = op;
                                                frame = calleeFrame2;
                                                continue Label_0124;
                                            }
                                        }
                                        if (!(lhs2 instanceof Function)) {
                                            if (lhs2 == DBL_MRK) {
                                                lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                            }
                                            throw ScriptRuntime.notFunctionError(lhs2);
                                        }
                                        final Function fun2 = (Function)lhs2;
                                        if (fun2 instanceof IdFunctionObject) {
                                            final IdFunctionObject ifun3 = (IdFunctionObject)fun2;
                                            if (NativeContinuation.isContinuationConstructor(ifun3)) {
                                                frame.stack[stackTop] = captureContinuation(cx, frame.parentFrame, false);
                                                continue Label_0124_Outer;
                                            }
                                        }
                                        final Object[] outArgs = getArgsArray(stack, sDbl, stackTop + 1, indexReg);
                                        stack[stackTop] = fun2.construct(cx, frame.scope, outArgs);
                                        continue Label_0124_Outer;
                                    }
                                    case 33: {
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 == DBL_MRK) {
                                            lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.typeof(lhs2);
                                        continue Label_0124_Outer;
                                    }
                                    case -14: {
                                        stack[++stackTop] = ScriptRuntime.typeofName(frame.scope, stringReg);
                                        continue Label_0124_Outer;
                                    }
                                    case 42: {
                                        stack[++stackTop] = stringReg;
                                        continue Label_0124_Outer;
                                    }
                                    case -27: {
                                        ++stackTop;
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = getShort(iCode, frame.pc);
                                        final CallFrame callFrame7 = frame;
                                        callFrame7.pc += 2;
                                        continue Label_0124_Outer;
                                    }
                                    case -28: {
                                        ++stackTop;
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = getInt(iCode, frame.pc);
                                        final CallFrame callFrame8 = frame;
                                        callFrame8.pc += 4;
                                        continue Label_0124_Outer;
                                    }
                                    case 41: {
                                        ++stackTop;
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = frame.idata.itsDoubleTable[indexReg];
                                        continue Label_0124_Outer;
                                    }
                                    case 40: {
                                        stack[++stackTop] = ScriptRuntime.name(cx, frame.scope, stringReg);
                                        continue Label_0124_Outer;
                                    }
                                    case -8: {
                                        stack[++stackTop] = ScriptRuntime.nameIncrDecr(frame.scope, stringReg, cx, iCode[frame.pc]);
                                        final CallFrame callFrame9 = frame;
                                        ++callFrame9.pc;
                                        continue Label_0124_Outer;
                                    }
                                    case -61: {
                                        indexReg = iCode[frame.pc++];
                                    }
                                    case 161: {
                                        stackTop = doSetConstVar(frame, stack, sDbl, stackTop, vars, varDbls, varAttributes, indexReg);
                                        continue Label_0124_Outer;
                                    }
                                    case -49: {
                                        indexReg = iCode[frame.pc++];
                                    }
                                    case 59: {
                                        stackTop = doSetVar(frame, stack, sDbl, stackTop, vars, varDbls, varAttributes, indexReg);
                                        continue Label_0124_Outer;
                                    }
                                    case -48: {
                                        indexReg = iCode[frame.pc++];
                                    }
                                    case 58: {
                                        stackTop = doGetVar(frame, stack, sDbl, stackTop, vars, varDbls, indexReg);
                                        continue Label_0124_Outer;
                                    }
                                    case -7: {
                                        stackTop = doVarIncDec(cx, frame, stack, sDbl, stackTop, vars, varDbls, varAttributes, indexReg);
                                        continue Label_0124_Outer;
                                    }
                                    case -51: {
                                        ++stackTop;
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = 0.0;
                                        continue Label_0124_Outer;
                                    }
                                    case -52: {
                                        ++stackTop;
                                        stack[stackTop] = DBL_MRK;
                                        sDbl[stackTop] = 1.0;
                                        continue Label_0124_Outer;
                                    }
                                    case 45: {
                                        stack[++stackTop] = null;
                                        continue Label_0124_Outer;
                                    }
                                    case 46: {
                                        stack[++stackTop] = frame.thisObj;
                                        continue Label_0124_Outer;
                                    }
                                    case 67: {
                                        stack[++stackTop] = frame.fnOrScript;
                                        continue Label_0124_Outer;
                                    }
                                    case 47: {
                                        stack[++stackTop] = Boolean.FALSE;
                                        continue Label_0124_Outer;
                                    }
                                    case 48: {
                                        stack[++stackTop] = Boolean.TRUE;
                                        continue Label_0124_Outer;
                                    }
                                    case -50: {
                                        stack[++stackTop] = undefined;
                                        continue Label_0124_Outer;
                                    }
                                    case 2: {
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 == DBL_MRK) {
                                            lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        frame.scope = ScriptRuntime.enterWith(lhs2, cx, frame.scope);
                                        continue Label_0124_Outer;
                                    }
                                    case 3: {
                                        frame.scope = ScriptRuntime.leaveWith(frame.scope);
                                        continue Label_0124_Outer;
                                    }
                                    case 60: {
                                        --stackTop;
                                        indexReg += frame.localShift;
                                        final boolean afterFirstScope = frame.idata.itsICode[frame.pc] != 0;
                                        final Throwable caughtException = (Throwable)stack[stackTop + 1];
                                        Scriptable lastCatchScope;
                                        if (!afterFirstScope) {
                                            lastCatchScope = null;
                                        }
                                        else {
                                            lastCatchScope = (Scriptable)stack[indexReg];
                                        }
                                        stack[indexReg] = ScriptRuntime.newCatchScope(caughtException, lastCatchScope, stringReg, cx, frame.scope);
                                        final CallFrame callFrame10 = frame;
                                        ++callFrame10.pc;
                                        continue Label_0124_Outer;
                                    }
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 64: {
                                        Object lhs2 = stack[stackTop];
                                        if (lhs2 == DBL_MRK) {
                                            lhs2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        indexReg += frame.localShift;
                                        final int enumType = (op == 61) ? 0 : ((op == 62) ? 1 : ((op == 64) ? 6 : 2));
                                        stack[indexReg] = ScriptRuntime.enumInit(lhs2, cx, frame.scope, enumType);
                                        continue Label_0124_Outer;
                                    }
                                    case 65:
                                    case 66: {
                                        indexReg += frame.localShift;
                                        final Object val = stack[indexReg];
                                        ++stackTop;
                                        stack[stackTop] = ((op == 65) ? ScriptRuntime.enumNext(val) : ScriptRuntime.enumId(val, cx));
                                        continue Label_0124_Outer;
                                    }
                                    case 75: {
                                        Object obj = stack[stackTop];
                                        if (obj == DBL_MRK) {
                                            obj = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        stack[stackTop] = ScriptRuntime.specialRef(obj, stringReg, cx, frame.scope);
                                        continue Label_0124_Outer;
                                    }
                                    case -12: {
                                        indexReg += frame.localShift;
                                        frame.scope = (Scriptable)stack[indexReg];
                                        continue Label_0124_Outer;
                                    }
                                    case -13: {
                                        indexReg += frame.localShift;
                                        stack[indexReg] = frame.scope;
                                        continue Label_0124_Outer;
                                    }
                                    case -19: {
                                        final InterpretedFunction fn = InterpretedFunction.createFunction(cx, frame.scope, frame.fnOrScript, indexReg);
                                        if (fn.idata.itsFunctionType == 4) {
                                            stack[++stackTop] = new ArrowFunction(cx, frame.scope, (Callable)fn, frame.thisObj);
                                            continue Label_0124_Outer;
                                        }
                                        stack[++stackTop] = fn;
                                        continue Label_0124_Outer;
                                    }
                                    case -20: {
                                        initFunction(cx, frame.scope, frame.fnOrScript, indexReg);
                                        continue Label_0124_Outer;
                                    }
                                    case 51: {
                                        final Object re = frame.idata.itsRegExpLiterals[indexReg];
                                        stack[++stackTop] = ScriptRuntime.wrapRegExp(cx, frame.scope, re);
                                        continue Label_0124_Outer;
                                    }
                                    case -29: {
                                        ++stackTop;
                                        stack[stackTop] = new int[indexReg];
                                        ++stackTop;
                                        stack[stackTop] = new Object[indexReg];
                                        sDbl[stackTop] = 0.0;
                                        continue Label_0124_Outer;
                                    }
                                    case -30: {
                                        Object value2 = stack[stackTop];
                                        if (value2 == DBL_MRK) {
                                            value2 = ScriptRuntime.wrapNumber(sDbl[stackTop]);
                                        }
                                        --stackTop;
                                        final int i = (int)sDbl[stackTop];
                                        ((Object[])stack[stackTop])[i] = value2;
                                        sDbl[stackTop] = i + 1;
                                        continue Label_0124_Outer;
                                    }
                                    case -57: {
                                        final Object value2 = stack[stackTop];
                                        --stackTop;
                                        final int i = (int)sDbl[stackTop];
                                        ((Object[])stack[stackTop])[i] = value2;
                                        ((int[])stack[stackTop - 1])[i] = -1;
                                        sDbl[stackTop] = i + 1;
                                        continue Label_0124_Outer;
                                    }
                                    case -58: {
                                        final Object value2 = stack[stackTop];
                                        --stackTop;
                                        final int i = (int)sDbl[stackTop];
                                        ((Object[])stack[stackTop])[i] = value2;
                                        ((int[])stack[stackTop - 1])[i] = 1;
                                        sDbl[stackTop] = i + 1;
                                        continue Label_0124_Outer;
                                    }
                                    case -31:
                                    case 69:
                                    case 70: {
                                        final Object[] data = (Object[])stack[stackTop];
                                        --stackTop;
                                        final int[] getterSetters = (int[])stack[stackTop];
                                        Object val2;
                                        if (op == 70) {
                                            final Object[] ids = (Object[])frame.idata.literalIds[indexReg];
                                            val2 = ScriptRuntime.newObjectLiteral(ids, data, getterSetters, cx, frame.scope);
                                        }
                                        else {
                                            int[] skipIndexces = null;
                                            if (op == -31) {
                                                skipIndexces = (int[])frame.idata.literalIds[indexReg];
                                            }
                                            val2 = ScriptRuntime.newArrayLiteral(data, skipIndexces, cx, frame.scope);
                                        }
                                        stack[stackTop] = val2;
                                        continue Label_0124_Outer;
                                    }
                                    case -64:
                                    case -54:
                                    case -53: {
                                        if (frame.debuggerFrame != null) {
                                            frame.debuggerFrame.onDebuggerStatement(cx);
                                            continue Label_0124_Outer;
                                        }
                                        continue Label_0124_Outer;
                                    }
                                    case -26: {
                                        frame.pcSourceLineStart = frame.pc;
                                        if (frame.debuggerFrame != null) {
                                            final int line = getIndex(iCode, frame.pc);
                                            frame.debuggerFrame.onLineChange(cx, line);
                                        }
                                        final CallFrame callFrame11 = frame;
                                        callFrame11.pc += 2;
                                        continue Label_0124_Outer;
                                    }
                                    case -32: {
                                        indexReg = 0;
                                        continue Label_0124_Outer;
                                    }
                                    case -33: {
                                        indexReg = 1;
                                        continue Label_0124_Outer;
                                    }
                                    case -34: {
                                        indexReg = 2;
                                        continue Label_0124_Outer;
                                    }
                                    case -35: {
                                        indexReg = 3;
                                        continue Label_0124_Outer;
                                    }
                                    case -36: {
                                        indexReg = 4;
                                        continue Label_0124_Outer;
                                    }
                                    case -37: {
                                        indexReg = 5;
                                        continue Label_0124_Outer;
                                    }
                                    case -38: {
                                        indexReg = (0xFF & iCode[frame.pc]);
                                        final CallFrame callFrame12 = frame;
                                        ++callFrame12.pc;
                                        continue Label_0124_Outer;
                                    }
                                    case -39: {
                                        indexReg = getIndex(iCode, frame.pc);
                                        final CallFrame callFrame13 = frame;
                                        callFrame13.pc += 2;
                                        continue Label_0124_Outer;
                                    }
                                    case -40: {
                                        indexReg = getInt(iCode, frame.pc);
                                        final CallFrame callFrame14 = frame;
                                        callFrame14.pc += 4;
                                        continue Label_0124_Outer;
                                    }
                                    case -41: {
                                        stringReg = strings[0];
                                        continue Label_0124_Outer;
                                    }
                                    case -42: {
                                        stringReg = strings[1];
                                        continue Label_0124_Outer;
                                    }
                                    case -43: {
                                        stringReg = strings[2];
                                        continue Label_0124_Outer;
                                    }
                                    case -44: {
                                        stringReg = strings[3];
                                        continue Label_0124_Outer;
                                    }
                                    case -45: {
                                        stringReg = strings[0xFF & iCode[frame.pc]];
                                        final CallFrame callFrame15 = frame;
                                        ++callFrame15.pc;
                                        continue Label_0124_Outer;
                                    }
                                    case -46: {
                                        stringReg = strings[getIndex(iCode, frame.pc)];
                                        final CallFrame callFrame16 = frame;
                                        callFrame16.pc += 2;
                                        continue Label_0124_Outer;
                                    }
                                    case -47: {
                                        stringReg = strings[getInt(iCode, frame.pc)];
                                        final CallFrame callFrame17 = frame;
                                        callFrame17.pc += 4;
                                        continue Label_0124_Outer;
                                    }
                                    default: {
                                        dumpICode(frame.idata);
                                        throw new RuntimeException("Unknown icode : " + op + " @ pc : " + (frame.pc - 1));
                                    }
                                }
                                if (instructionCounting) {
                                    addInstructionCount(cx, frame, 2);
                                }
                                final int offset = getShort(iCode, frame.pc);
                                if (offset != 0) {
                                    final CallFrame callFrame18 = frame;
                                    callFrame18.pc += offset - 1;
                                }
                                else {
                                    frame.pc = frame.idata.longJumps.getExistingInt(frame.pc);
                                }
                                if (instructionCounting) {
                                    frame.pcPrevBranch = frame.pc;
                                }
                            }
                            exitFrame(cx, frame, null);
                            interpreterResult = frame.result;
                            interpreterResultDbl = frame.resultDbl;
                            if (frame.parentFrame == null) {
                                break Label_0124_Outer;
                            }
                            frame = frame.parentFrame;
                            if (frame.frozen) {
                                frame = frame.cloneFrozen();
                            }
                            setCallResult(frame, interpreterResult, interpreterResultDbl);
                            interpreterResult = null;
                        }
                    }
                    catch (Throwable ex) {
                        if (throwable != null) {
                            ex.printStackTrace(System.err);
                            throw new IllegalStateException();
                        }
                        throwable = ex;
                    }
                }
                if (throwable == null) {
                    Kit.codeBug();
                }
                final int EX_CATCH_STATE = 2;
                final int EX_FINALLY_STATE = 1;
                final int EX_NO_JS_STATE = 0;
                ContinuationJump cjump2 = null;
                int exState;
                if (generatorState != null && generatorState.operation == 2 && throwable == generatorState.value) {
                    exState = 1;
                }
                else if (throwable instanceof JavaScriptException) {
                    exState = 2;
                }
                else if (throwable instanceof EcmaError) {
                    exState = 2;
                }
                else if (throwable instanceof EvaluatorException) {
                    exState = 2;
                }
                else if (throwable instanceof ContinuationPending) {
                    exState = 0;
                }
                else if (throwable instanceof RuntimeException) {
                    exState = (cx.hasFeature(12) ? 2 : 1);
                }
                else if (throwable instanceof Error) {
                    exState = (cx.hasFeature(12) ? 2 : 0);
                }
                else if (throwable instanceof ContinuationJump) {
                    exState = 1;
                    cjump2 = (ContinuationJump)throwable;
                }
                else {
                    exState = (cx.hasFeature(12) ? 2 : 1);
                }
                if (instructionCounting) {
                    try {
                        addInstructionCount(cx, frame, 100);
                    }
                    catch (RuntimeException ex2) {
                        throwable = ex2;
                        exState = 1;
                    }
                    catch (Error ex3) {
                        throwable = ex3;
                        cjump2 = null;
                        exState = 0;
                    }
                }
                if (frame.debuggerFrame != null && throwable instanceof RuntimeException) {
                    final RuntimeException rex = (RuntimeException)throwable;
                    try {
                        frame.debuggerFrame.onExceptionThrown(cx, (Throwable)rex);
                    }
                    catch (Throwable ex4) {
                        throwable = ex4;
                        cjump2 = null;
                        exState = 0;
                    }
                }
                do {
                    if (exState != 0) {
                        final boolean onlyFinally = exState != 2;
                        indexReg = getExceptionHandler(frame, onlyFinally);
                        if (indexReg >= 0) {
                            continue Label_0124;
                        }
                    }
                    exitFrame(cx, frame, throwable);
                    frame = frame.parentFrame;
                    if (frame == null) {
                        if (cjump2 == null) {
                            break Label_0124_Outer;
                        }
                        if (cjump2.branchFrame != null) {
                            Kit.codeBug();
                        }
                        if (cjump2.capturedFrame != null) {
                            indexReg = -1;
                            continue Label_0124;
                        }
                        interpreterResult = cjump2.result;
                        interpreterResultDbl = cjump2.resultDbl;
                        throwable = null;
                        break Label_0124_Outer;
                    }
                } while (cjump2 == null || cjump2.branchFrame != frame);
                indexReg = -1;
                continue Label_0124;
            }
        }
        if (cx.previousInterpreterInvocations != null && cx.previousInterpreterInvocations.size() != 0) {
            cx.lastInterpreterFrame = cx.previousInterpreterInvocations.pop();
        }
        else {
            cx.lastInterpreterFrame = null;
            cx.previousInterpreterInvocations = null;
        }
        if (throwable == null) {
            return (interpreterResult != DBL_MRK) ? interpreterResult : ScriptRuntime.wrapNumber(interpreterResultDbl);
        }
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException)throwable;
        }
        throw (Error)throwable;
    }
    
    private static int doInOrInstanceof(final Context cx, final int op, final Object[] stack, final double[] sDbl, int stackTop) {
        Object rhs = stack[stackTop];
        if (rhs == UniqueTag.DOUBLE_MARK) {
            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        --stackTop;
        Object lhs = stack[stackTop];
        if (lhs == UniqueTag.DOUBLE_MARK) {
            lhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        boolean valBln;
        if (op == 55) {
            valBln = ScriptRuntime.in(lhs, rhs, cx);
        }
        else {
            valBln = ScriptRuntime.instanceOf(lhs, rhs, cx);
        }
        stack[stackTop] = ScriptRuntime.wrapBoolean(valBln);
        return stackTop;
    }
    
    private static int doCompare(final CallFrame frame, final int op, final Object[] stack, final double[] sDbl, int stackTop) {
        --stackTop;
        final Object rhs = stack[stackTop + 1];
        final Object lhs = stack[stackTop];
        boolean valBln = false;
        Label_0256: {
            double rDbl;
            double lDbl;
            if (rhs == UniqueTag.DOUBLE_MARK) {
                rDbl = sDbl[stackTop + 1];
                lDbl = stack_double(frame, stackTop);
            }
            else if (lhs == UniqueTag.DOUBLE_MARK) {
                rDbl = ScriptRuntime.toNumber(rhs);
                lDbl = sDbl[stackTop];
            }
            else {
                switch (op) {
                    case 17: {
                        valBln = ScriptRuntime.cmp_LE(rhs, lhs);
                        break Label_0256;
                    }
                    case 15: {
                        valBln = ScriptRuntime.cmp_LE(lhs, rhs);
                        break Label_0256;
                    }
                    case 16: {
                        valBln = ScriptRuntime.cmp_LT(rhs, lhs);
                        break Label_0256;
                    }
                    case 14: {
                        valBln = ScriptRuntime.cmp_LT(lhs, rhs);
                        break Label_0256;
                    }
                    default: {
                        throw Kit.codeBug();
                    }
                }
            }
            switch (op) {
                case 17: {
                    valBln = (lDbl >= rDbl);
                    break;
                }
                case 15: {
                    valBln = (lDbl <= rDbl);
                    break;
                }
                case 16: {
                    valBln = (lDbl > rDbl);
                    break;
                }
                case 14: {
                    valBln = (lDbl < rDbl);
                    break;
                }
                default: {
                    throw Kit.codeBug();
                }
            }
        }
        stack[stackTop] = ScriptRuntime.wrapBoolean(valBln);
        return stackTop;
    }
    
    private static int doBitOp(final CallFrame frame, final int op, final Object[] stack, final double[] sDbl, int stackTop) {
        int lIntValue = stack_int32(frame, stackTop - 1);
        final int rIntValue = stack_int32(frame, stackTop);
        stack[--stackTop] = UniqueTag.DOUBLE_MARK;
        switch (op) {
            case 11: {
                lIntValue &= rIntValue;
                break;
            }
            case 9: {
                lIntValue |= rIntValue;
                break;
            }
            case 10: {
                lIntValue ^= rIntValue;
                break;
            }
            case 18: {
                lIntValue <<= rIntValue;
                break;
            }
            case 19: {
                lIntValue >>= rIntValue;
                break;
            }
        }
        sDbl[stackTop] = lIntValue;
        return stackTop;
    }
    
    private static int doDelName(final Context cx, final CallFrame frame, final int op, final Object[] stack, final double[] sDbl, int stackTop) {
        Object rhs = stack[stackTop];
        if (rhs == UniqueTag.DOUBLE_MARK) {
            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        --stackTop;
        Object lhs = stack[stackTop];
        if (lhs == UniqueTag.DOUBLE_MARK) {
            lhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        stack[stackTop] = ScriptRuntime.delete(lhs, rhs, cx, frame.scope, op == 0);
        return stackTop;
    }
    
    private static int doGetElem(final Context cx, final CallFrame frame, final Object[] stack, final double[] sDbl, int stackTop) {
        --stackTop;
        Object lhs = stack[stackTop];
        if (lhs == UniqueTag.DOUBLE_MARK) {
            lhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        final Object id = stack[stackTop + 1];
        Object value;
        if (id != UniqueTag.DOUBLE_MARK) {
            value = ScriptRuntime.getObjectElem(lhs, id, cx, frame.scope);
        }
        else {
            final double d = sDbl[stackTop + 1];
            value = ScriptRuntime.getObjectIndex(lhs, d, cx, frame.scope);
        }
        stack[stackTop] = value;
        return stackTop;
    }
    
    private static int doSetElem(final Context cx, final CallFrame frame, final Object[] stack, final double[] sDbl, int stackTop) {
        stackTop -= 2;
        Object rhs = stack[stackTop + 2];
        if (rhs == UniqueTag.DOUBLE_MARK) {
            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop + 2]);
        }
        Object lhs = stack[stackTop];
        if (lhs == UniqueTag.DOUBLE_MARK) {
            lhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        final Object id = stack[stackTop + 1];
        Object value;
        if (id != UniqueTag.DOUBLE_MARK) {
            value = ScriptRuntime.setObjectElem(lhs, id, rhs, cx, frame.scope);
        }
        else {
            final double d = sDbl[stackTop + 1];
            value = ScriptRuntime.setObjectIndex(lhs, d, rhs, cx, frame.scope);
        }
        stack[stackTop] = value;
        return stackTop;
    }
    
    private static int doElemIncDec(final Context cx, final CallFrame frame, final byte[] iCode, final Object[] stack, final double[] sDbl, int stackTop) {
        Object rhs = stack[stackTop];
        if (rhs == UniqueTag.DOUBLE_MARK) {
            rhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        --stackTop;
        Object lhs = stack[stackTop];
        if (lhs == UniqueTag.DOUBLE_MARK) {
            lhs = ScriptRuntime.wrapNumber(sDbl[stackTop]);
        }
        stack[stackTop] = ScriptRuntime.elemIncrDecr(lhs, rhs, cx, frame.scope, iCode[frame.pc]);
        ++frame.pc;
        return stackTop;
    }
    
    private static int doCallSpecial(final Context cx, final CallFrame frame, final Object[] stack, final double[] sDbl, int stackTop, final byte[] iCode, final int indexReg) {
        final int callType = iCode[frame.pc] & 0xFF;
        final boolean isNew = iCode[frame.pc + 1] != 0;
        final int sourceLine = getIndex(iCode, frame.pc + 2);
        if (isNew) {
            stackTop -= indexReg;
            Object function = stack[stackTop];
            if (function == UniqueTag.DOUBLE_MARK) {
                function = ScriptRuntime.wrapNumber(sDbl[stackTop]);
            }
            final Object[] outArgs = getArgsArray(stack, sDbl, stackTop + 1, indexReg);
            stack[stackTop] = ScriptRuntime.newSpecial(cx, function, outArgs, frame.scope, callType);
        }
        else {
            stackTop -= 1 + indexReg;
            final Scriptable functionThis = (Scriptable)stack[stackTop + 1];
            final Callable function2 = (Callable)stack[stackTop];
            final Object[] outArgs2 = getArgsArray(stack, sDbl, stackTop + 2, indexReg);
            stack[stackTop] = ScriptRuntime.callSpecial(cx, function2, functionThis, outArgs2, frame.scope, frame.thisObj, callType, frame.idata.itsSourceFile, sourceLine);
        }
        frame.pc += 4;
        return stackTop;
    }
    
    private static int doSetConstVar(final CallFrame frame, final Object[] stack, final double[] sDbl, final int stackTop, final Object[] vars, final double[] varDbls, final int[] varAttributes, final int indexReg) {
        if (!frame.useActivation) {
            if ((varAttributes[indexReg] & 0x1) == 0x0) {
                throw Context.reportRuntimeError1("msg.var.redecl", (Object)frame.idata.argNames[indexReg]);
            }
            if ((varAttributes[indexReg] & 0x8) != 0x0) {
                vars[indexReg] = stack[stackTop];
                varAttributes[indexReg] &= 0xFFFFFFF7;
                varAttributes[indexReg] |= 0x10;
                varDbls[indexReg] = sDbl[stackTop];
            }
        }
        else {
            Object val = stack[stackTop];
            if (val == UniqueTag.DOUBLE_MARK) {
                val = ScriptRuntime.wrapNumber(sDbl[stackTop]);
            }
            final String stringReg = frame.idata.argNames[indexReg];
            if (!(frame.scope instanceof ConstProperties)) {
                throw Kit.codeBug();
            }
            final ConstProperties cp = (ConstProperties)frame.scope;
            cp.putConst(stringReg, frame.scope, val);
        }
        return stackTop;
    }
    
    private static int doSetVar(final CallFrame frame, final Object[] stack, final double[] sDbl, final int stackTop, final Object[] vars, final double[] varDbls, final int[] varAttributes, final int indexReg) {
        if (!frame.useActivation) {
            if ((varAttributes[indexReg] & 0x1) != 0x0) {
                throw ScriptRuntime.typeError1("msg.modify.readonly", frame.idata.argNames[indexReg]);
            }
            vars[indexReg] = stack[stackTop];
            varDbls[indexReg] = sDbl[stackTop];
        }
        else {
            Object val = stack[stackTop];
            if (val == UniqueTag.DOUBLE_MARK) {
                val = ScriptRuntime.wrapNumber(sDbl[stackTop]);
            }
            final String stringReg = frame.idata.argNames[indexReg];
            frame.scope.put(stringReg, frame.scope, val);
        }
        return stackTop;
    }
    
    private static int doGetVar(final CallFrame frame, final Object[] stack, final double[] sDbl, int stackTop, final Object[] vars, final double[] varDbls, final int indexReg) {
        ++stackTop;
        if (!frame.useActivation) {
            stack[stackTop] = vars[indexReg];
            sDbl[stackTop] = varDbls[indexReg];
        }
        else {
            final String stringReg = frame.idata.argNames[indexReg];
            stack[stackTop] = frame.scope.get(stringReg, frame.scope);
        }
        return stackTop;
    }
    
    private static int doVarIncDec(final Context cx, final CallFrame frame, final Object[] stack, final double[] sDbl, int stackTop, final Object[] vars, final double[] varDbls, final int[] varAttributes, final int indexReg) {
        ++stackTop;
        final int incrDecrMask = frame.idata.itsICode[frame.pc];
        if (!frame.useActivation) {
            final Object varValue = vars[indexReg];
            double d;
            if (varValue == UniqueTag.DOUBLE_MARK) {
                d = varDbls[indexReg];
            }
            else {
                d = ScriptRuntime.toNumber(varValue);
            }
            final double d2 = ((incrDecrMask & 0x1) == 0x0) ? (d + 1.0) : (d - 1.0);
            final boolean post = (incrDecrMask & 0x2) != 0x0;
            if ((varAttributes[indexReg] & 0x1) == 0x0) {
                if (varValue != UniqueTag.DOUBLE_MARK) {
                    vars[indexReg] = UniqueTag.DOUBLE_MARK;
                }
                varDbls[indexReg] = d2;
                stack[stackTop] = UniqueTag.DOUBLE_MARK;
                sDbl[stackTop] = (post ? d : d2);
            }
            else if (post && varValue != UniqueTag.DOUBLE_MARK) {
                stack[stackTop] = varValue;
            }
            else {
                stack[stackTop] = UniqueTag.DOUBLE_MARK;
                sDbl[stackTop] = (post ? d : d2);
            }
        }
        else {
            final String varName = frame.idata.argNames[indexReg];
            stack[stackTop] = ScriptRuntime.nameIncrDecr(frame.scope, varName, cx, incrDecrMask);
        }
        ++frame.pc;
        return stackTop;
    }
    
    private static boolean doEquals(final Object[] stack, final double[] sDbl, final int stackTop) {
        final Object rhs = stack[stackTop + 1];
        final Object lhs = stack[stackTop];
        if (rhs == UniqueTag.DOUBLE_MARK) {
            if (lhs == UniqueTag.DOUBLE_MARK) {
                return sDbl[stackTop] == sDbl[stackTop + 1];
            }
            return ScriptRuntime.eqNumber(sDbl[stackTop + 1], lhs);
        }
        else {
            if (lhs == UniqueTag.DOUBLE_MARK) {
                return ScriptRuntime.eqNumber(sDbl[stackTop], rhs);
            }
            return ScriptRuntime.eq(lhs, rhs);
        }
    }
    
    private static boolean doShallowEquals(final Object[] stack, final double[] sDbl, final int stackTop) {
        final Object rhs = stack[stackTop + 1];
        final Object lhs = stack[stackTop];
        final Object DBL_MRK = UniqueTag.DOUBLE_MARK;
        double rdbl;
        double ldbl;
        if (rhs == DBL_MRK) {
            rdbl = sDbl[stackTop + 1];
            if (lhs == DBL_MRK) {
                ldbl = sDbl[stackTop];
            }
            else {
                if (!(lhs instanceof Number)) {
                    return false;
                }
                ldbl = ((Number)lhs).doubleValue();
            }
        }
        else {
            if (lhs != DBL_MRK) {
                return ScriptRuntime.shallowEq(lhs, rhs);
            }
            ldbl = sDbl[stackTop];
            if (!(rhs instanceof Number)) {
                return false;
            }
            rdbl = ((Number)rhs).doubleValue();
        }
        return ldbl == rdbl;
    }
    
    private static CallFrame processThrowable(final Context cx, Object throwable, CallFrame frame, final int indexReg, final boolean instructionCounting) {
        if (indexReg >= 0) {
            if (frame.frozen) {
                frame = frame.cloneFrozen();
            }
            final int[] table = frame.idata.itsExceptionTable;
            frame.pc = table[indexReg + 2];
            if (instructionCounting) {
                frame.pcPrevBranch = frame.pc;
            }
            frame.savedStackTop = frame.emptyStackTop;
            final int scopeLocal = frame.localShift + table[indexReg + 5];
            final int exLocal = frame.localShift + table[indexReg + 4];
            frame.scope = (Scriptable)frame.stack[scopeLocal];
            frame.stack[exLocal] = throwable;
            throwable = null;
        }
        else {
            final ContinuationJump cjump = (ContinuationJump)throwable;
            throwable = null;
            if (cjump.branchFrame != frame) {
                Kit.codeBug();
            }
            if (cjump.capturedFrame == null) {
                Kit.codeBug();
            }
            int rewindCount = cjump.capturedFrame.frameIndex + 1;
            if (cjump.branchFrame != null) {
                rewindCount -= cjump.branchFrame.frameIndex;
            }
            int enterCount = 0;
            CallFrame[] enterFrames = null;
            CallFrame x = cjump.capturedFrame;
            for (int i = 0; i != rewindCount; ++i) {
                if (!x.frozen) {
                    Kit.codeBug();
                }
                if (x.useActivation) {
                    if (enterFrames == null) {
                        enterFrames = new CallFrame[rewindCount - i];
                    }
                    enterFrames[enterCount] = x;
                    ++enterCount;
                }
                x = x.parentFrame;
            }
            while (enterCount != 0) {
                --enterCount;
                x = enterFrames[enterCount];
                enterFrame(cx, x, ScriptRuntime.emptyArgs, true);
            }
            frame = cjump.capturedFrame.cloneFrozen();
            setCallResult(frame, cjump.result, cjump.resultDbl);
        }
        frame.throwable = throwable;
        return frame;
    }
    
    private static Object freezeGenerator(final Context cx, final CallFrame frame, final int stackTop, final GeneratorState generatorState) {
        if (generatorState.operation == 2) {
            throw ScriptRuntime.typeError0("msg.yield.closing");
        }
        frame.frozen = true;
        frame.result = frame.stack[stackTop];
        frame.resultDbl = frame.sDbl[stackTop];
        frame.savedStackTop = stackTop;
        --frame.pc;
        ScriptRuntime.exitActivationFunction(cx);
        return (frame.result != UniqueTag.DOUBLE_MARK) ? frame.result : ScriptRuntime.wrapNumber(frame.resultDbl);
    }
    
    private static Object thawGenerator(final CallFrame frame, final int stackTop, final GeneratorState generatorState, final int op) {
        frame.frozen = false;
        final int sourceLine = getIndex(frame.idata.itsICode, frame.pc);
        frame.pc += 2;
        if (generatorState.operation == 1) {
            return new JavaScriptException(generatorState.value, frame.idata.itsSourceFile, sourceLine);
        }
        if (generatorState.operation == 2) {
            return generatorState.value;
        }
        if (generatorState.operation != 0) {
            throw Kit.codeBug();
        }
        if (op == 76) {
            frame.stack[stackTop] = generatorState.value;
        }
        return Scriptable.NOT_FOUND;
    }
    
    private static CallFrame initFrameForApplyOrCall(final Context cx, CallFrame frame, final int indexReg, final Object[] stack, final double[] sDbl, final int stackTop, final int op, final Scriptable calleeScope, final IdFunctionObject ifun, final InterpretedFunction iApplyCallable) {
        Scriptable applyThis;
        if (indexReg != 0) {
            Object obj = stack[stackTop + 2];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(sDbl[stackTop + 2]);
            }
            applyThis = ScriptRuntime.toObjectOrNull(cx, obj, frame.scope);
        }
        else {
            applyThis = null;
        }
        if (applyThis == null) {
            applyThis = ScriptRuntime.getTopCallScope(cx);
        }
        if (op == -55) {
            exitFrame(cx, frame, null);
            frame = frame.parentFrame;
        }
        else {
            frame.savedStackTop = stackTop;
            frame.savedCallOp = op;
        }
        CallFrame calleeFrame;
        if (BaseFunction.isApply(ifun)) {
            final Object[] callArgs = (indexReg < 2) ? ScriptRuntime.emptyArgs : ScriptRuntime.createArrFromArrayLike(cx, stack[stackTop + 3]);
            calleeFrame = initFrame(cx, calleeScope, applyThis, callArgs, null, 0, callArgs.length, iApplyCallable, frame);
        }
        else {
            for (int i = 1; i < indexReg; ++i) {
                stack[stackTop + 1 + i] = stack[stackTop + 2 + i];
                sDbl[stackTop + 1 + i] = sDbl[stackTop + 2 + i];
            }
            final int argCount = (indexReg < 2) ? 0 : (indexReg - 1);
            calleeFrame = initFrame(cx, calleeScope, applyThis, stack, sDbl, stackTop + 2, argCount, iApplyCallable, frame);
        }
        return calleeFrame;
    }
    
    private static CallFrame initFrame(final Context cx, final Scriptable callerScope, final Scriptable thisObj, final Object[] args, final double[] argsDbl, final int argShift, final int argCount, final InterpretedFunction fnOrScript, final CallFrame parentFrame) {
        final CallFrame frame = new CallFrame(cx, thisObj, fnOrScript, parentFrame);
        frame.initializeArgs(cx, callerScope, args, argsDbl, argShift, argCount);
        enterFrame(cx, frame, args, false);
        return frame;
    }
    
    private static void enterFrame(final Context cx, final CallFrame frame, final Object[] args, final boolean continuationRestart) {
        final boolean usesActivation = frame.idata.itsNeedsActivation;
        final boolean isDebugged = frame.debuggerFrame != null;
        if (usesActivation || isDebugged) {
            Scriptable scope = frame.scope;
            if (scope == null) {
                Kit.codeBug();
            }
            else if (continuationRestart) {
                while (scope instanceof NativeWith) {
                    scope = scope.getParentScope();
                    if (scope == null || (frame.parentFrame != null && frame.parentFrame.scope == scope)) {
                        Kit.codeBug();
                        break;
                    }
                }
            }
            if (isDebugged) {
                frame.debuggerFrame.onEnter(cx, scope, frame.thisObj, args);
            }
            if (usesActivation) {
                ScriptRuntime.enterActivationFunction(cx, scope);
            }
        }
    }
    
    private static void exitFrame(final Context cx, final CallFrame frame, final Object throwable) {
        if (frame.idata.itsNeedsActivation) {
            ScriptRuntime.exitActivationFunction(cx);
        }
        if (frame.debuggerFrame != null) {
            try {
                if (throwable instanceof Throwable) {
                    frame.debuggerFrame.onExit(cx, true, throwable);
                }
                else {
                    final ContinuationJump cjump = (ContinuationJump)throwable;
                    Object result;
                    if (cjump == null) {
                        result = frame.result;
                    }
                    else {
                        result = cjump.result;
                    }
                    if (result == UniqueTag.DOUBLE_MARK) {
                        double resultDbl;
                        if (cjump == null) {
                            resultDbl = frame.resultDbl;
                        }
                        else {
                            resultDbl = cjump.resultDbl;
                        }
                        result = ScriptRuntime.wrapNumber(resultDbl);
                    }
                    frame.debuggerFrame.onExit(cx, false, result);
                }
            }
            catch (Throwable ex) {
                System.err.println("RHINO USAGE WARNING: onExit terminated with exception");
                ex.printStackTrace(System.err);
            }
        }
    }
    
    private static void setCallResult(final CallFrame frame, final Object callResult, final double callResultDbl) {
        if (frame.savedCallOp == 39) {
            frame.stack[frame.savedStackTop] = callResult;
            frame.sDbl[frame.savedStackTop] = callResultDbl;
        }
        else if (frame.savedCallOp == 31) {
            if (callResult instanceof Scriptable) {
                frame.stack[frame.savedStackTop] = callResult;
            }
        }
        else {
            Kit.codeBug();
        }
        frame.savedCallOp = 0;
    }
    
    public static NativeContinuation captureContinuation(final Context cx) {
        if (cx.lastInterpreterFrame == null || !(cx.lastInterpreterFrame instanceof CallFrame)) {
            throw new IllegalStateException("Interpreter frames not found");
        }
        return captureContinuation(cx, (CallFrame)cx.lastInterpreterFrame, true);
    }
    
    private static NativeContinuation captureContinuation(final Context cx, final CallFrame frame, final boolean requireContinuationsTopFrame) {
        final NativeContinuation c = new NativeContinuation();
        ScriptRuntime.setObjectProtoAndParent((ScriptableObject)c, ScriptRuntime.getTopCallScope(cx));
        CallFrame x = frame;
        CallFrame outermost = frame;
        while (x != null && !x.frozen) {
            x.frozen = true;
            for (int i = x.savedStackTop + 1; i != x.stack.length; ++i) {
                x.stack[i] = null;
                x.stackAttributes[i] = 0;
            }
            if (x.savedCallOp == 39) {
                x.stack[x.savedStackTop] = null;
            }
            else if (x.savedCallOp != 31) {
                Kit.codeBug();
            }
            outermost = x;
            x = x.parentFrame;
        }
        if (requireContinuationsTopFrame) {
            while (outermost.parentFrame != null) {
                outermost = outermost.parentFrame;
            }
            if (!outermost.isContinuationsTopFrame) {
                throw new IllegalStateException("Cannot capture continuation from JavaScript code not called directly by executeScriptWithContinuations or callFunctionWithContinuations");
            }
        }
        c.initImplementation(frame);
        return c;
    }
    
    private static int stack_int32(final CallFrame frame, final int i) {
        final Object x = frame.stack[i];
        if (x == UniqueTag.DOUBLE_MARK) {
            return ScriptRuntime.toInt32(frame.sDbl[i]);
        }
        return ScriptRuntime.toInt32(x);
    }
    
    private static double stack_double(final CallFrame frame, final int i) {
        final Object x = frame.stack[i];
        if (x != UniqueTag.DOUBLE_MARK) {
            return ScriptRuntime.toNumber(x);
        }
        return frame.sDbl[i];
    }
    
    private static boolean stack_boolean(final CallFrame frame, final int i) {
        final Object x = frame.stack[i];
        if (x == Boolean.TRUE) {
            return true;
        }
        if (x == Boolean.FALSE) {
            return false;
        }
        if (x == UniqueTag.DOUBLE_MARK) {
            final double d = frame.sDbl[i];
            return !Double.isNaN(d) && d != 0.0;
        }
        if (x == null || x == Undefined.instance) {
            return false;
        }
        if (x instanceof Number) {
            final double d = ((Number)x).doubleValue();
            return !Double.isNaN(d) && d != 0.0;
        }
        if (x instanceof Boolean) {
            return (boolean)x;
        }
        return ScriptRuntime.toBoolean(x);
    }
    
    private static void doAdd(final Object[] stack, final double[] sDbl, final int stackTop, final Context cx) {
        Object rhs = stack[stackTop + 1];
        Object lhs = stack[stackTop];
        double d;
        boolean leftRightOrder;
        if (rhs == UniqueTag.DOUBLE_MARK) {
            d = sDbl[stackTop + 1];
            if (lhs == UniqueTag.DOUBLE_MARK) {
                sDbl[stackTop] += d;
                return;
            }
            leftRightOrder = true;
        }
        else {
            if (lhs != UniqueTag.DOUBLE_MARK) {
                if (lhs instanceof Scriptable || rhs instanceof Scriptable) {
                    stack[stackTop] = ScriptRuntime.add(lhs, rhs, cx);
                }
                else if (lhs instanceof CharSequence || rhs instanceof CharSequence) {
                    final CharSequence lstr = ScriptRuntime.toCharSequence(lhs);
                    final CharSequence rstr = ScriptRuntime.toCharSequence(rhs);
                    stack[stackTop] = new ConsString(lstr, rstr);
                }
                else {
                    final double lDbl = (lhs instanceof Number) ? ((Number)lhs).doubleValue() : ScriptRuntime.toNumber(lhs);
                    final double rDbl = (rhs instanceof Number) ? ((Number)rhs).doubleValue() : ScriptRuntime.toNumber(rhs);
                    stack[stackTop] = UniqueTag.DOUBLE_MARK;
                    sDbl[stackTop] = lDbl + rDbl;
                }
                return;
            }
            d = sDbl[stackTop];
            lhs = rhs;
            leftRightOrder = false;
        }
        if (lhs instanceof Scriptable) {
            rhs = ScriptRuntime.wrapNumber(d);
            if (!leftRightOrder) {
                final Object tmp = lhs;
                lhs = rhs;
                rhs = tmp;
            }
            stack[stackTop] = ScriptRuntime.add(lhs, rhs, cx);
        }
        else if (lhs instanceof CharSequence) {
            final CharSequence lstr = (CharSequence)lhs;
            final CharSequence rstr = ScriptRuntime.toCharSequence(d);
            if (leftRightOrder) {
                stack[stackTop] = new ConsString(lstr, rstr);
            }
            else {
                stack[stackTop] = new ConsString(rstr, lstr);
            }
        }
        else {
            final double lDbl = (lhs instanceof Number) ? ((Number)lhs).doubleValue() : ScriptRuntime.toNumber(lhs);
            stack[stackTop] = UniqueTag.DOUBLE_MARK;
            sDbl[stackTop] = lDbl + d;
        }
    }
    
    private static int doArithmetic(final CallFrame frame, final int op, final Object[] stack, final double[] sDbl, int stackTop) {
        final double rDbl = stack_double(frame, stackTop);
        --stackTop;
        double lDbl = stack_double(frame, stackTop);
        stack[stackTop] = UniqueTag.DOUBLE_MARK;
        switch (op) {
            case 22: {
                lDbl -= rDbl;
                break;
            }
            case 23: {
                lDbl *= rDbl;
                break;
            }
            case 24: {
                lDbl /= rDbl;
                break;
            }
            case 25: {
                lDbl %= rDbl;
                break;
            }
        }
        sDbl[stackTop] = lDbl;
        return stackTop;
    }
    
    private static Object[] getArgsArray(final Object[] stack, final double[] sDbl, int shift, final int count) {
        if (count == 0) {
            return ScriptRuntime.emptyArgs;
        }
        final Object[] args = new Object[count];
        for (int i = 0; i != count; ++i, ++shift) {
            Object val = stack[shift];
            if (val == UniqueTag.DOUBLE_MARK) {
                val = ScriptRuntime.wrapNumber(sDbl[shift]);
            }
            args[i] = val;
        }
        return args;
    }
    
    private static void addInstructionCount(final Context cx, final CallFrame frame, final int extra) {
        cx.instructionCount += frame.pc - frame.pcPrevBranch + extra;
        if (cx.instructionCount > cx.instructionThreshold) {
            cx.observeInstructionCount(cx.instructionCount);
            cx.instructionCount = 0;
        }
    }
    
    private static class CallFrame implements Cloneable, Serializable
    {
        private static final long serialVersionUID = -2843792508994958978L;
        CallFrame parentFrame;
        int frameIndex;
        boolean frozen;
        final InterpretedFunction fnOrScript;
        final InterpreterData idata;
        Object[] stack;
        int[] stackAttributes;
        double[] sDbl;
        final CallFrame varSource;
        final int localShift;
        final int emptyStackTop;
        final DebugFrame debuggerFrame;
        final boolean useActivation;
        boolean isContinuationsTopFrame;
        final Scriptable thisObj;
        Object result;
        double resultDbl;
        int pc;
        int pcPrevBranch;
        int pcSourceLineStart;
        Scriptable scope;
        int savedStackTop;
        int savedCallOp;
        Object throwable;
        
        CallFrame(final Context cx, final Scriptable thisObj, final InterpretedFunction fnOrScript, final CallFrame parentFrame) {
            this.idata = fnOrScript.idata;
            this.debuggerFrame = ((cx.debugger != null) ? cx.debugger.getFrame(cx, (DebuggableScript)this.idata) : null);
            this.useActivation = (this.debuggerFrame != null || this.idata.itsNeedsActivation);
            this.emptyStackTop = this.idata.itsMaxVars + this.idata.itsMaxLocals - 1;
            this.fnOrScript = fnOrScript;
            this.varSource = this;
            this.localShift = this.idata.itsMaxVars;
            this.thisObj = thisObj;
            this.parentFrame = parentFrame;
            this.frameIndex = ((parentFrame == null) ? 0 : (parentFrame.frameIndex + 1));
            if (this.frameIndex > cx.getMaximumInterpreterStackDepth()) {
                throw Context.reportRuntimeError("Exceeded maximum stack depth");
            }
            this.result = Undefined.instance;
            this.pcSourceLineStart = this.idata.firstLinePC;
            this.savedStackTop = this.emptyStackTop;
        }
        
        void initializeArgs(final Context cx, final Scriptable callerScope, Object[] args, double[] argsDbl, int argShift, final int argCount) {
            if (this.useActivation) {
                if (argsDbl != null) {
                    args = getArgsArray(args, argsDbl, argShift, argCount);
                }
                argShift = 0;
                argsDbl = null;
            }
            if (this.idata.itsFunctionType != 0) {
                this.scope = this.fnOrScript.getParentScope();
                if (this.useActivation) {
                    if (this.idata.itsFunctionType == 4) {
                        this.scope = ScriptRuntime.createArrowFunctionActivation((NativeFunction)this.fnOrScript, this.scope, args, this.idata.isStrict, false);
                    }
                    else {
                        this.scope = ScriptRuntime.createFunctionActivation((NativeFunction)this.fnOrScript, this.scope, args, this.idata.isStrict, false);
                    }
                }
            }
            else {
                this.scope = callerScope;
                ScriptRuntime.initScript((NativeFunction)this.fnOrScript, this.thisObj, cx, this.scope);
            }
            if (this.idata.itsNestedFunctions != null) {
                if (this.idata.itsFunctionType != 0 && !this.idata.itsNeedsActivation) {
                    Kit.codeBug();
                }
                for (int i = 0; i < this.idata.itsNestedFunctions.length; ++i) {
                    final InterpreterData fdata = this.idata.itsNestedFunctions[i];
                    if (fdata.itsFunctionType == 1) {
                        initFunction(cx, this.scope, this.fnOrScript, i);
                    }
                }
            }
            final int maxFrameArray = this.idata.itsMaxFrameArray;
            if (maxFrameArray != this.emptyStackTop + this.idata.itsMaxStack + 1) {
                Kit.codeBug();
            }
            this.stack = new Object[maxFrameArray];
            this.stackAttributes = new int[maxFrameArray];
            this.sDbl = new double[maxFrameArray];
            for (int varCount = this.idata.getParamAndVarCount(), j = 0; j < varCount; ++j) {
                if (this.idata.getParamOrVarConst(j)) {
                    this.stackAttributes[j] = 13;
                }
            }
            int definedArgs = this.idata.argCount;
            if (definedArgs > argCount) {
                definedArgs = argCount;
            }
            System.arraycopy(args, argShift, this.stack, 0, definedArgs);
            if (argsDbl != null) {
                System.arraycopy(argsDbl, argShift, this.sDbl, 0, definedArgs);
            }
            for (int k = definedArgs; k != this.idata.itsMaxVars; ++k) {
                this.stack[k] = Undefined.instance;
            }
        }
        
        CallFrame cloneFrozen() {
            if (!this.frozen) {
                Kit.codeBug();
            }
            CallFrame copy;
            try {
                copy = (CallFrame)this.clone();
            }
            catch (CloneNotSupportedException ex) {
                throw new IllegalStateException();
            }
            copy.stack = this.stack.clone();
            copy.stackAttributes = this.stackAttributes.clone();
            copy.sDbl = this.sDbl.clone();
            copy.frozen = false;
            return copy;
        }
        
        @Override
        public boolean equals(final Object other) {
            if (other instanceof CallFrame) {
                final Context cx = Context.enter();
                try {
                    if (ScriptRuntime.hasTopCall(cx)) {
                        return this.equalsInTopScope(other);
                    }
                    final Scriptable top = ScriptableObject.getTopLevelScope(this.scope);
                    return (boolean)ScriptRuntime.doTopCall((c, scope, thisObj, args) -> this.equalsInTopScope(other), cx, top, top, ScriptRuntime.emptyArgs, this.isStrictTopFrame());
                }
                finally {
                    Context.exit();
                }
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            int depth = 0;
            CallFrame f = this;
            int h = 0;
            do {
                h = 31 * (31 * h + f.pc) + f.idata.icodeHashCode();
                f = f.parentFrame;
            } while (f != null && depth++ < 8);
            return h;
        }
        
        private boolean equalsInTopScope(final Object other) {
            return (boolean)EqualObjectGraphs.withThreadLocal(eq -> equals(this, (CallFrame)other, eq));
        }
        
        private boolean isStrictTopFrame() {
            CallFrame f = this;
            while (true) {
                final CallFrame p = f.parentFrame;
                if (p == null) {
                    break;
                }
                f = p;
            }
            return f.idata.isStrict;
        }
        
        private static boolean equals(CallFrame f1, CallFrame f2, final EqualObjectGraphs equal) {
            while (f1 != f2) {
                if (f1 == null || f2 == null) {
                    return false;
                }
                if (!f1.fieldsEqual(f2, equal)) {
                    return false;
                }
                f1 = f1.parentFrame;
                f2 = f2.parentFrame;
            }
            return true;
        }
        
        private boolean fieldsEqual(final CallFrame other, final EqualObjectGraphs equal) {
            return this.frameIndex == other.frameIndex && this.pc == other.pc && compareIdata(this.idata, other.idata) && equal.equalGraphs((Object)this.varSource.stack, (Object)other.varSource.stack) && Arrays.equals(this.varSource.sDbl, other.varSource.sDbl) && equal.equalGraphs((Object)this.thisObj, (Object)other.thisObj) && equal.equalGraphs((Object)this.fnOrScript, (Object)other.fnOrScript) && equal.equalGraphs((Object)this.scope, (Object)other.scope);
        }
    }
    
    private static final class ContinuationJump implements Serializable
    {
        private static final long serialVersionUID = 7687739156004308247L;
        CallFrame capturedFrame;
        CallFrame branchFrame;
        Object result;
        double resultDbl;
        
        ContinuationJump(final NativeContinuation c, final CallFrame current) {
            this.capturedFrame = (CallFrame)c.getImplementation();
            if (this.capturedFrame == null || current == null) {
                this.branchFrame = null;
            }
            else {
                CallFrame chain1 = this.capturedFrame;
                CallFrame chain2 = current;
                int diff = chain1.frameIndex - chain2.frameIndex;
                if (diff != 0) {
                    if (diff < 0) {
                        chain1 = current;
                        chain2 = this.capturedFrame;
                        diff = -diff;
                    }
                    do {
                        chain1 = chain1.parentFrame;
                    } while (--diff != 0);
                    if (chain1.frameIndex != chain2.frameIndex) {
                        Kit.codeBug();
                    }
                }
                while (chain1 != chain2 && chain1 != null) {
                    chain1 = chain1.parentFrame;
                    chain2 = chain2.parentFrame;
                }
                this.branchFrame = chain1;
                if (this.branchFrame != null && !this.branchFrame.frozen) {
                    Kit.codeBug();
                }
            }
        }
    }
    
    static class GeneratorState
    {
        int operation;
        Object value;
        RuntimeException returnedException;
        
        GeneratorState(final int operation, final Object value) {
            this.operation = operation;
            this.value = value;
        }
    }
}
