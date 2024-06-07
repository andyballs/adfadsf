//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import java.net.*;
import java.io.*;
import java.util.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.debug.*;

public class Dim
{
    public static final int STEP_OVER = 0;
    public static final int STEP_INTO = 1;
    public static final int STEP_OUT = 2;
    public static final int GO = 3;
    public static final int BREAK = 4;
    public static final int EXIT = 5;
    private static final int IPROXY_DEBUG = 0;
    private static final int IPROXY_LISTEN = 1;
    private static final int IPROXY_COMPILE_SCRIPT = 2;
    private static final int IPROXY_EVAL_SCRIPT = 3;
    private static final int IPROXY_STRING_IS_COMPILABLE = 4;
    private static final int IPROXY_OBJECT_TO_STRING = 5;
    private static final int IPROXY_OBJECT_PROPERTY = 6;
    private static final int IPROXY_OBJECT_IDS = 7;
    private GuiCallback callback;
    private boolean breakFlag;
    private ScopeProvider scopeProvider;
    private SourceProvider sourceProvider;
    private int frameIndex;
    private volatile ContextData interruptedContextData;
    private ContextFactory contextFactory;
    private Object monitor;
    private Object eventThreadMonitor;
    private volatile int returnValue;
    private boolean insideInterruptLoop;
    private String evalRequest;
    private StackFrame evalFrame;
    private String evalResult;
    private boolean breakOnExceptions;
    private boolean breakOnEnter;
    private boolean breakOnReturn;
    private final Map<String, SourceInfo> urlToSourceInfo;
    private final Map<String, FunctionSource> functionNames;
    private final Map<DebuggableScript, FunctionSource> functionToSource;
    private DimIProxy listener;
    
    public Dim() {
        this.frameIndex = -1;
        this.monitor = new Object();
        this.eventThreadMonitor = new Object();
        this.returnValue = -1;
        this.urlToSourceInfo = Collections.synchronizedMap(new HashMap<String, SourceInfo>());
        this.functionNames = Collections.synchronizedMap(new HashMap<String, FunctionSource>());
        this.functionToSource = Collections.synchronizedMap(new HashMap<DebuggableScript, FunctionSource>());
    }
    
    public void setGuiCallback(final GuiCallback callback) {
        this.callback = callback;
    }
    
    public void setBreak() {
        this.breakFlag = true;
    }
    
    public void setScopeProvider(final ScopeProvider scopeProvider) {
        this.scopeProvider = scopeProvider;
    }
    
    public void setSourceProvider(final SourceProvider sourceProvider) {
        this.sourceProvider = sourceProvider;
    }
    
    public void contextSwitch(final int frameIndex) {
        this.frameIndex = frameIndex;
    }
    
    public void setBreakOnExceptions(final boolean breakOnExceptions) {
        this.breakOnExceptions = breakOnExceptions;
    }
    
    public void setBreakOnEnter(final boolean breakOnEnter) {
        this.breakOnEnter = breakOnEnter;
    }
    
    public void setBreakOnReturn(final boolean breakOnReturn) {
        this.breakOnReturn = breakOnReturn;
    }
    
    public void attachTo(final ContextFactory factory) {
        this.detach();
        (this.contextFactory = factory).addListener((ContextFactory.Listener)(this.listener = new DimIProxy(this, 1)));
    }
    
    public void detach() {
        if (this.listener != null) {
            this.contextFactory.removeListener((ContextFactory.Listener)this.listener);
            this.contextFactory = null;
            this.listener = null;
        }
    }
    
    public void dispose() {
        this.detach();
    }
    
    private FunctionSource getFunctionSource(final DebuggableScript fnOrScript) {
        FunctionSource fsource = this.functionSource(fnOrScript);
        if (fsource == null) {
            final String url = this.getNormalizedUrl(fnOrScript);
            final SourceInfo si = this.sourceInfo(url);
            if (si == null && !fnOrScript.isGeneratedScript()) {
                final String source = this.loadSource(url);
                if (source != null) {
                    DebuggableScript top = fnOrScript;
                    while (true) {
                        final DebuggableScript parent = top.getParent();
                        if (parent == null) {
                            break;
                        }
                        top = parent;
                    }
                    this.registerTopScript(top, source);
                    fsource = this.functionSource(fnOrScript);
                }
            }
        }
        return fsource;
    }
    
    private String loadSource(String sourceUrl) {
        String source = null;
        final int hash = sourceUrl.indexOf(35);
        if (hash >= 0) {
            sourceUrl = sourceUrl.substring(0, hash);
        }
        try {
            Label_0237: {
                if (sourceUrl.indexOf(58) < 0) {
                    try {
                        if (sourceUrl.startsWith("~/")) {
                            final String home = SecurityUtilities.getSystemProperty("user.home");
                            if (home != null) {
                                final String pathFromHome = sourceUrl.substring(2);
                                final File f = new File(new File(home), pathFromHome);
                                if (f.exists()) {
                                    final InputStream is = new FileInputStream(f);
                                    break Label_0237;
                                }
                            }
                        }
                        final File f2 = new File(sourceUrl);
                        if (f2.exists()) {
                            final InputStream is = new FileInputStream(f2);
                            break Label_0237;
                        }
                    }
                    catch (SecurityException ex2) {}
                    if (sourceUrl.startsWith("//")) {
                        sourceUrl = "http:" + sourceUrl;
                    }
                    else if (sourceUrl.startsWith("/")) {
                        sourceUrl = "http://127.0.0.1" + sourceUrl;
                    }
                    else {
                        sourceUrl = "http://" + sourceUrl;
                    }
                }
                final InputStream is = new URL(sourceUrl).openStream();
                try {
                    source = Kit.readReader((Reader)new InputStreamReader(is));
                }
                finally {
                    is.close();
                }
            }
        }
        catch (IOException ex) {
            System.err.println("Failed to load source from " + sourceUrl + ": " + ex);
        }
        return source;
    }
    
    private void registerTopScript(final DebuggableScript topScript, String source) {
        if (!topScript.isTopLevel()) {
            throw new IllegalArgumentException();
        }
        final String url = this.getNormalizedUrl(topScript);
        final DebuggableScript[] functions = getAllFunctions(topScript);
        if (this.sourceProvider != null) {
            final String providedSource = this.sourceProvider.getSource(topScript);
            if (providedSource != null) {
                source = providedSource;
            }
        }
        final SourceInfo sourceInfo = new SourceInfo(source, functions, url);
        synchronized (this.urlToSourceInfo) {
            final SourceInfo old = this.urlToSourceInfo.get(url);
            if (old != null) {
                sourceInfo.copyBreakpointsFrom(old);
            }
            this.urlToSourceInfo.put(url, sourceInfo);
            for (int i = 0; i != sourceInfo.functionSourcesTop(); ++i) {
                final FunctionSource fsource = sourceInfo.functionSource(i);
                final String name = fsource.name();
                if (name.length() != 0) {
                    this.functionNames.put(name, fsource);
                }
            }
        }
        synchronized (this.functionToSource) {
            for (int j = 0; j != functions.length; ++j) {
                final FunctionSource fsource2 = sourceInfo.functionSource(j);
                this.functionToSource.put(functions[j], fsource2);
            }
        }
        this.callback.updateSourceText(sourceInfo);
    }
    
    private FunctionSource functionSource(final DebuggableScript fnOrScript) {
        return this.functionToSource.get(fnOrScript);
    }
    
    public String[] functionNames() {
        synchronized (this.urlToSourceInfo) {
            return this.functionNames.keySet().toArray(new String[this.functionNames.size()]);
        }
    }
    
    public FunctionSource functionSourceByName(final String functionName) {
        return this.functionNames.get(functionName);
    }
    
    public SourceInfo sourceInfo(final String url) {
        return this.urlToSourceInfo.get(url);
    }
    
    private String getNormalizedUrl(final DebuggableScript fnOrScript) {
        String url = fnOrScript.getSourceName();
        if (url == null) {
            url = "<stdin>";
        }
        else {
            final char evalSeparator = '#';
            StringBuilder sb = null;
            final int urlLength = url.length();
            int cursor = 0;
            while (true) {
                final int searchStart = url.indexOf(evalSeparator, cursor);
                if (searchStart < 0) {
                    break;
                }
                String replace = null;
                int i;
                for (i = searchStart + 1; i != urlLength; ++i) {
                    final int c = url.charAt(i);
                    if (48 > c) {
                        break;
                    }
                    if (c > 57) {
                        break;
                    }
                }
                if (i != searchStart + 1 && "(eval)".regionMatches(0, url, i, 6)) {
                    cursor = i + 6;
                    replace = "(eval)";
                }
                if (replace == null) {
                    break;
                }
                if (sb == null) {
                    sb = new StringBuilder();
                    sb.append(url.substring(0, searchStart));
                }
                sb.append(replace);
            }
            if (sb != null) {
                if (cursor != urlLength) {
                    sb.append(url.substring(cursor));
                }
                url = sb.toString();
            }
        }
        return url;
    }
    
    private static DebuggableScript[] getAllFunctions(final DebuggableScript function) {
        final ObjArray functions = new ObjArray();
        collectFunctions_r(function, functions);
        final DebuggableScript[] result = new DebuggableScript[functions.size()];
        functions.toArray((Object[])result);
        return result;
    }
    
    private static void collectFunctions_r(final DebuggableScript function, final ObjArray array) {
        array.add((Object)function);
        for (int i = 0; i != function.getFunctionCount(); ++i) {
            collectFunctions_r(function.getFunction(i), array);
        }
    }
    
    public void clearAllBreakpoints() {
        for (final SourceInfo si : this.urlToSourceInfo.values()) {
            si.removeAllBreakpoints();
        }
    }
    
    private void handleBreakpointHit(final StackFrame frame, final Context cx) {
        this.breakFlag = false;
        this.interrupted(cx, frame, null);
    }
    
    private void handleExceptionThrown(final Context cx, final Throwable ex, final StackFrame frame) {
        if (this.breakOnExceptions) {
            final ContextData cd = frame.contextData();
            if (cd.lastProcessedException != ex) {
                this.interrupted(cx, frame, ex);
                cd.lastProcessedException = ex;
            }
        }
    }
    
    public ContextData currentContextData() {
        return this.interruptedContextData;
    }
    
    public void setReturnValue(final int returnValue) {
        synchronized (this.monitor) {
            this.returnValue = returnValue;
            this.monitor.notify();
        }
    }
    
    public void go() {
        synchronized (this.monitor) {
            this.returnValue = 3;
            this.monitor.notifyAll();
        }
    }
    
    public String eval(final String expr) {
        String result = "undefined";
        if (expr == null) {
            return result;
        }
        final ContextData contextData = this.currentContextData();
        if (contextData == null || this.frameIndex >= contextData.frameCount()) {
            return result;
        }
        final StackFrame frame = contextData.getFrame(this.frameIndex);
        if (contextData.eventThreadFlag) {
            final Context cx = Context.getCurrentContext();
            result = do_eval(cx, frame, expr);
        }
        else {
            synchronized (this.monitor) {
                if (this.insideInterruptLoop) {
                    this.evalRequest = expr;
                    this.evalFrame = frame;
                    this.monitor.notify();
                    do {
                        try {
                            this.monitor.wait();
                        }
                        catch (InterruptedException exc) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    } while (this.evalRequest != null);
                    result = this.evalResult;
                }
            }
        }
        return result;
    }
    
    public void compileScript(final String url, final String text) {
        final DimIProxy action = new DimIProxy(this, 2);
        action.url = url;
        action.text = text;
        action.withContext();
    }
    
    public void evalScript(final String url, final String text) {
        final DimIProxy action = new DimIProxy(this, 3);
        action.url = url;
        action.text = text;
        action.withContext();
    }
    
    public String objectToString(final Object object) {
        final DimIProxy action = new DimIProxy(this, 5);
        action.object = object;
        action.withContext();
        return action.stringResult;
    }
    
    public boolean stringIsCompilableUnit(final String str) {
        final DimIProxy action = new DimIProxy(this, 4);
        action.text = str;
        action.withContext();
        return action.booleanResult;
    }
    
    public Object getObjectProperty(final Object object, final Object id) {
        final DimIProxy action = new DimIProxy(this, 6);
        action.object = object;
        action.id = id;
        action.withContext();
        return action.objectResult;
    }
    
    public Object[] getObjectIds(final Object object) {
        final DimIProxy action = new DimIProxy(this, 7);
        action.object = object;
        action.withContext();
        return action.objectArrayResult;
    }
    
    private Object getObjectPropertyImpl(final Context cx, final Object object, final Object id) {
        final Scriptable scriptable = (Scriptable)object;
        Object result;
        if (id instanceof String) {
            final String name = (String)id;
            if (name.equals("this")) {
                result = scriptable;
            }
            else if (name.equals("__proto__")) {
                result = scriptable.getPrototype();
            }
            else if (name.equals("__parent__")) {
                result = scriptable.getParentScope();
            }
            else {
                result = ScriptableObject.getProperty(scriptable, name);
                if (result == ScriptableObject.NOT_FOUND) {
                    result = Undefined.instance;
                }
            }
        }
        else {
            final int index = (int)id;
            result = ScriptableObject.getProperty(scriptable, index);
            if (result == ScriptableObject.NOT_FOUND) {
                result = Undefined.instance;
            }
        }
        return result;
    }
    
    private Object[] getObjectIdsImpl(final Context cx, final Object object) {
        if (!(object instanceof Scriptable) || object == Undefined.instance) {
            return Context.emptyArgs;
        }
        final Scriptable scriptable = (Scriptable)object;
        Object[] ids;
        if (scriptable instanceof DebuggableObject) {
            ids = ((DebuggableObject)scriptable).getAllIds();
        }
        else {
            ids = scriptable.getIds();
        }
        final Scriptable proto = scriptable.getPrototype();
        final Scriptable parent = scriptable.getParentScope();
        int extra = 0;
        if (proto != null) {
            ++extra;
        }
        if (parent != null) {
            ++extra;
        }
        if (extra != 0) {
            final Object[] tmp = new Object[extra + ids.length];
            System.arraycopy(ids, 0, tmp, extra, ids.length);
            ids = tmp;
            extra = 0;
            if (proto != null) {
                ids[extra++] = "__proto__";
            }
            if (parent != null) {
                ids[extra++] = "__parent__";
            }
        }
        return ids;
    }
    
    private void interrupted(final Context cx, final StackFrame frame, final Throwable scriptException) {
        final ContextData contextData = frame.contextData();
        final boolean eventThreadFlag = this.callback.isGuiEventThread();
        contextData.eventThreadFlag = eventThreadFlag;
        boolean recursiveEventThreadCall = false;
        Label_0100: {
            synchronized (this.eventThreadMonitor) {
                if (eventThreadFlag) {
                    if (this.interruptedContextData != null) {
                        recursiveEventThreadCall = true;
                        break Label_0100;
                    }
                }
                else {
                    while (this.interruptedContextData != null) {
                        try {
                            this.eventThreadMonitor.wait();
                            continue;
                        }
                        catch (InterruptedException exc) {
                            return;
                        }
                        break;
                    }
                }
                this.interruptedContextData = contextData;
            }
        }
        if (recursiveEventThreadCall) {
            return;
        }
        if (this.interruptedContextData == null) {
            Kit.codeBug();
        }
        try {
            final int frameCount = contextData.frameCount();
            this.frameIndex = frameCount - 1;
            final String threadTitle = Thread.currentThread().toString();
            String alertMessage;
            if (scriptException == null) {
                alertMessage = null;
            }
            else {
                alertMessage = scriptException.toString();
            }
            int returnValue = -1;
            if (!eventThreadFlag) {
                synchronized (this.monitor) {
                    if (this.insideInterruptLoop) {
                        Kit.codeBug();
                    }
                    this.insideInterruptLoop = true;
                    this.evalRequest = null;
                    this.returnValue = -1;
                    this.callback.enterInterrupt(frame, threadTitle, alertMessage);
                    try {
                        while (true) {
                            try {
                                this.monitor.wait();
                            }
                            catch (InterruptedException exc2) {
                                Thread.currentThread().interrupt();
                                break;
                            }
                            if (this.evalRequest != null) {
                                this.evalResult = null;
                                try {
                                    this.evalResult = do_eval(cx, this.evalFrame, this.evalRequest);
                                }
                                finally {
                                    this.evalRequest = null;
                                    this.evalFrame = null;
                                    this.monitor.notify();
                                }
                            }
                            else {
                                if (this.returnValue != -1) {
                                    returnValue = this.returnValue;
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    finally {
                        this.insideInterruptLoop = false;
                    }
                }
            }
            else {
                this.returnValue = -1;
                this.callback.enterInterrupt(frame, threadTitle, alertMessage);
                while (this.returnValue == -1) {
                    try {
                        this.callback.dispatchNextGuiEvent();
                    }
                    catch (InterruptedException ex) {}
                }
                returnValue = this.returnValue;
            }
            switch (returnValue) {
                case 0: {
                    contextData.breakNextLine = true;
                    contextData.stopAtFrameDepth = contextData.frameCount();
                    break;
                }
                case 1: {
                    contextData.breakNextLine = true;
                    contextData.stopAtFrameDepth = -1;
                    break;
                }
                case 2: {
                    if (contextData.frameCount() > 1) {
                        contextData.breakNextLine = true;
                        contextData.stopAtFrameDepth = contextData.frameCount() - 1;
                        break;
                    }
                    break;
                }
            }
        }
        finally {
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
            }
        }
    }
    
    private static String do_eval(final Context cx, final StackFrame frame, final String expr) {
        final Debugger saved_debugger = cx.getDebugger();
        final Object saved_data = cx.getDebuggerContextData();
        final int saved_level = cx.getOptimizationLevel();
        cx.setDebugger((Debugger)null, (Object)null);
        cx.setOptimizationLevel(-1);
        cx.setGeneratingDebug(false);
        String resultString;
        try {
            final Callable script = (Callable)cx.compileString(expr, "", 0, (Object)null);
            final Object result = script.call(cx, frame.scope, frame.thisObj, ScriptRuntime.emptyArgs);
            if (result == Undefined.instance) {
                resultString = "";
            }
            else {
                resultString = ScriptRuntime.toString(result);
            }
        }
        catch (Exception exc) {
            resultString = exc.getMessage();
        }
        finally {
            cx.setGeneratingDebug(true);
            cx.setOptimizationLevel(saved_level);
            cx.setDebugger(saved_debugger, saved_data);
        }
        if (resultString == null) {
            resultString = "null";
        }
        return resultString;
    }
    
    private static class DimIProxy implements ContextAction, ContextFactory.Listener, Debugger
    {
        private Dim dim;
        private int type;
        private String url;
        private String text;
        private Object object;
        private Object id;
        private boolean booleanResult;
        private String stringResult;
        private Object objectResult;
        private Object[] objectArrayResult;
        
        private DimIProxy(final Dim dim, final int type) {
            this.dim = dim;
            this.type = type;
        }
        
        public Object run(final Context cx) {
            switch (this.type) {
                case 2: {
                    cx.compileString(this.text, this.url, 1, (Object)null);
                    break;
                }
                case 3: {
                    Scriptable scope = null;
                    if (this.dim.scopeProvider != null) {
                        scope = this.dim.scopeProvider.getScope();
                    }
                    if (scope == null) {
                        scope = (Scriptable)new ImporterTopLevel(cx);
                    }
                    cx.evaluateString(scope, this.text, this.url, 1, (Object)null);
                    break;
                }
                case 4: {
                    this.booleanResult = cx.stringIsCompilableUnit(this.text);
                    break;
                }
                case 5: {
                    if (this.object == Undefined.instance) {
                        this.stringResult = "undefined";
                        break;
                    }
                    if (this.object == null) {
                        this.stringResult = "null";
                        break;
                    }
                    if (this.object instanceof NativeCall) {
                        this.stringResult = "[object Call]";
                        break;
                    }
                    this.stringResult = Context.toString(this.object);
                    break;
                }
                case 6: {
                    this.objectResult = this.dim.getObjectPropertyImpl(cx, this.object, this.id);
                    break;
                }
                case 7: {
                    this.objectArrayResult = this.dim.getObjectIdsImpl(cx, this.object);
                    break;
                }
                default: {
                    throw Kit.codeBug();
                }
            }
            return null;
        }
        
        private void withContext() {
            this.dim.contextFactory.call((ContextAction)this);
        }
        
        public void contextCreated(final Context cx) {
            if (this.type != 1) {
                Kit.codeBug();
            }
            final ContextData contextData = new ContextData();
            final Debugger debugger = (Debugger)new DimIProxy(this.dim, 0);
            cx.setDebugger(debugger, (Object)contextData);
            cx.setGeneratingDebug(true);
            cx.setOptimizationLevel(-1);
        }
        
        public void contextReleased(final Context cx) {
            if (this.type != 1) {
                Kit.codeBug();
            }
        }
        
        public DebugFrame getFrame(final Context cx, final DebuggableScript fnOrScript) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            final FunctionSource item = this.dim.getFunctionSource(fnOrScript);
            if (item == null) {
                return null;
            }
            return (DebugFrame)new StackFrame(cx, this.dim, item);
        }
        
        public void handleCompilationDone(final Context cx, final DebuggableScript fnOrScript, final String source) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            if (!fnOrScript.isTopLevel()) {
                return;
            }
            this.dim.registerTopScript(fnOrScript, source);
        }
    }
    
    public static class ContextData
    {
        private ObjArray frameStack;
        private boolean breakNextLine;
        private int stopAtFrameDepth;
        private boolean eventThreadFlag;
        private Throwable lastProcessedException;
        
        public ContextData() {
            this.frameStack = new ObjArray();
            this.stopAtFrameDepth = -1;
        }
        
        public static ContextData get(final Context cx) {
            return (ContextData)cx.getDebuggerContextData();
        }
        
        public int frameCount() {
            return this.frameStack.size();
        }
        
        public StackFrame getFrame(final int frameNumber) {
            final int num = this.frameStack.size() - frameNumber - 1;
            return (StackFrame)this.frameStack.get(num);
        }
        
        private void pushFrame(final StackFrame frame) {
            this.frameStack.push((Object)frame);
        }
        
        private void popFrame() {
            this.frameStack.pop();
        }
    }
    
    public static class StackFrame implements DebugFrame
    {
        private Dim dim;
        private ContextData contextData;
        private Scriptable scope;
        private Scriptable thisObj;
        private FunctionSource fsource;
        private boolean[] breakpoints;
        private int lineNumber;
        
        private StackFrame(final Context cx, final Dim dim, final FunctionSource fsource) {
            this.dim = dim;
            this.contextData = ContextData.get(cx);
            this.fsource = fsource;
            this.breakpoints = fsource.sourceInfo().breakpoints;
            this.lineNumber = fsource.firstLine();
        }
        
        public void onEnter(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
            this.contextData.pushFrame(this);
            this.scope = scope;
            this.thisObj = thisObj;
            if (this.dim.breakOnEnter) {
                this.dim.handleBreakpointHit(this, cx);
            }
        }
        
        public void onLineChange(final Context cx, final int lineno) {
            this.lineNumber = lineno;
            if (!this.breakpoints[lineno] && !this.dim.breakFlag) {
                boolean lineBreak = this.contextData.breakNextLine;
                if (lineBreak && this.contextData.stopAtFrameDepth >= 0) {
                    lineBreak = (this.contextData.frameCount() <= this.contextData.stopAtFrameDepth);
                }
                if (!lineBreak) {
                    return;
                }
                this.contextData.stopAtFrameDepth = -1;
                this.contextData.breakNextLine = false;
            }
            this.dim.handleBreakpointHit(this, cx);
        }
        
        public void onExceptionThrown(final Context cx, final Throwable exception) {
            this.dim.handleExceptionThrown(cx, exception, this);
        }
        
        public void onExit(final Context cx, final boolean byThrow, final Object resultOrException) {
            if (this.dim.breakOnReturn && !byThrow) {
                this.dim.handleBreakpointHit(this, cx);
            }
            this.contextData.popFrame();
        }
        
        public void onDebuggerStatement(final Context cx) {
            this.dim.handleBreakpointHit(this, cx);
        }
        
        public SourceInfo sourceInfo() {
            return this.fsource.sourceInfo();
        }
        
        public ContextData contextData() {
            return this.contextData;
        }
        
        public Object scope() {
            return this.scope;
        }
        
        public Object thisObj() {
            return this.thisObj;
        }
        
        public String getUrl() {
            return this.fsource.sourceInfo().url();
        }
        
        public int getLineNumber() {
            return this.lineNumber;
        }
        
        public String getFunctionName() {
            return this.fsource.name();
        }
    }
    
    public static class FunctionSource
    {
        private SourceInfo sourceInfo;
        private int firstLine;
        private String name;
        
        private FunctionSource(final SourceInfo sourceInfo, final int firstLine, final String name) {
            if (name == null) {
                throw new IllegalArgumentException();
            }
            this.sourceInfo = sourceInfo;
            this.firstLine = firstLine;
            this.name = name;
        }
        
        public SourceInfo sourceInfo() {
            return this.sourceInfo;
        }
        
        public int firstLine() {
            return this.firstLine;
        }
        
        public String name() {
            return this.name;
        }
    }
    
    public static class SourceInfo
    {
        private static final boolean[] EMPTY_BOOLEAN_ARRAY;
        private String source;
        private String url;
        private boolean[] breakableLines;
        private boolean[] breakpoints;
        private FunctionSource[] functionSources;
        
        private SourceInfo(final String source, final DebuggableScript[] functions, final String normilizedUrl) {
            this.source = source;
            this.url = normilizedUrl;
            final int N = functions.length;
            final int[][] lineArrays = new int[N][];
            for (int i = 0; i != N; ++i) {
                lineArrays[i] = functions[i].getLineNumbers();
            }
            int minAll = 0;
            int maxAll = -1;
            final int[] firstLines = new int[N];
            for (int j = 0; j != N; ++j) {
                final int[] lines = lineArrays[j];
                if (lines == null || lines.length == 0) {
                    firstLines[j] = -1;
                }
                else {
                    int min;
                    int max = min = lines[0];
                    for (int k = 1; k != lines.length; ++k) {
                        final int line = lines[k];
                        if (line < min) {
                            min = line;
                        }
                        else if (line > max) {
                            max = line;
                        }
                    }
                    firstLines[j] = min;
                    if (minAll > maxAll) {
                        minAll = min;
                        maxAll = max;
                    }
                    else {
                        if (min < minAll) {
                            minAll = min;
                        }
                        if (max > maxAll) {
                            maxAll = max;
                        }
                    }
                }
            }
            if (minAll > maxAll) {
                this.breakableLines = SourceInfo.EMPTY_BOOLEAN_ARRAY;
                this.breakpoints = SourceInfo.EMPTY_BOOLEAN_ARRAY;
            }
            else {
                if (minAll < 0) {
                    throw new IllegalStateException(String.valueOf(minAll));
                }
                final int linesTop = maxAll + 1;
                this.breakableLines = new boolean[linesTop];
                this.breakpoints = new boolean[linesTop];
                for (int l = 0; l != N; ++l) {
                    final int[] lines2 = lineArrays[l];
                    if (lines2 != null && lines2.length != 0) {
                        for (int m = 0; m != lines2.length; ++m) {
                            final int line2 = lines2[m];
                            this.breakableLines[line2] = true;
                        }
                    }
                }
            }
            this.functionSources = new FunctionSource[N];
            for (int j = 0; j != N; ++j) {
                String name = functions[j].getFunctionName();
                if (name == null) {
                    name = "";
                }
                this.functionSources[j] = new FunctionSource(this, firstLines[j], name);
            }
        }
        
        public String source() {
            return this.source;
        }
        
        public String url() {
            return this.url;
        }
        
        public int functionSourcesTop() {
            return this.functionSources.length;
        }
        
        public FunctionSource functionSource(final int i) {
            return this.functionSources[i];
        }
        
        private void copyBreakpointsFrom(final SourceInfo old) {
            int end = old.breakpoints.length;
            if (end > this.breakpoints.length) {
                end = this.breakpoints.length;
            }
            for (int line = 0; line != end; ++line) {
                if (old.breakpoints[line]) {
                    this.breakpoints[line] = true;
                }
            }
        }
        
        public boolean breakableLine(final int line) {
            return line < this.breakableLines.length && this.breakableLines[line];
        }
        
        public boolean breakpoint(final int line) {
            if (!this.breakableLine(line)) {
                throw new IllegalArgumentException(String.valueOf(line));
            }
            return line < this.breakpoints.length && this.breakpoints[line];
        }
        
        public boolean breakpoint(final int line, final boolean value) {
            if (!this.breakableLine(line)) {
                throw new IllegalArgumentException(String.valueOf(line));
            }
            boolean changed;
            synchronized (this.breakpoints) {
                if (this.breakpoints[line] != value) {
                    this.breakpoints[line] = value;
                    changed = true;
                }
                else {
                    changed = false;
                }
            }
            return changed;
        }
        
        public void removeAllBreakpoints() {
            synchronized (this.breakpoints) {
                for (int line = 0; line != this.breakpoints.length; ++line) {
                    this.breakpoints[line] = false;
                }
            }
        }
        
        static {
            EMPTY_BOOLEAN_ARRAY = new boolean[0];
        }
    }
}
