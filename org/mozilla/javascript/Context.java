//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.net.*;
import java.util.jar.*;
import java.beans.*;
import java.io.*;
import java.lang.reflect.*;
import org.mozilla.javascript.debug.*;
import org.mozilla.javascript.ast.*;
import java.util.*;

public class Context
{
    public static final int VERSION_UNKNOWN = -1;
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_1_0 = 100;
    public static final int VERSION_1_1 = 110;
    public static final int VERSION_1_2 = 120;
    public static final int VERSION_1_3 = 130;
    public static final int VERSION_1_4 = 140;
    public static final int VERSION_1_5 = 150;
    public static final int VERSION_1_6 = 160;
    public static final int VERSION_1_7 = 170;
    public static final int VERSION_1_8 = 180;
    public static final int VERSION_ES6 = 200;
    public static final int FEATURE_NON_ECMA_GET_YEAR = 1;
    public static final int FEATURE_RESERVED_KEYWORD_AS_IDENTIFIER = 2;
    public static final int FEATURE_TO_STRING_AS_SOURCE = 3;
    public static final int FEATURE_PARENT_PROTO_PROPERTIES = 4;
    @Deprecated
    public static final int FEATURE_PARENT_PROTO_PROPRTIES = 5;
    public static final int FEATURE_DYNAMIC_SCOPE = 6;
    public static final int FEATURE_STRICT_VARS = 7;
    public static final int FEATURE_STRICT_EVAL = 8;
    public static final int FEATURE_LOCATION_INFORMATION_IN_ERROR = 9;
    public static final int FEATURE_STRICT_MODE = 10;
    public static final int FEATURE_WARNING_AS_ERROR = 11;
    public static final int FEATURE_ENHANCED_JAVA_ACCESS = 12;
    public static final int FEATURE_V8_EXTENSIONS = 13;
    public static final int FEATURE_OLD_UNDEF_NULL_THIS = 14;
    public static final int FEATURE_ENUMERATE_IDS_FIRST = 15;
    public static final int FEATURE_THREAD_SAFE_OBJECTS = 16;
    public static final int FEATURE_INTEGER_WITHOUT_DECIMAL_PLACE = 17;
    public static final int FEATURE_LITTLE_ENDIAN = 18;
    public static final int EMIT_DEBUG_OUTPUT = 19;
    public static final String languageVersionProperty = "language version";
    public static final String errorReporterProperty = "error reporter";
    public static final Object[] emptyArgs;
    private static Class<?> codegenClass;
    private static Class<?> interpreterClass;
    private static String implementationVersion;
    private final ContextFactory factory;
    private boolean sealed;
    private Object sealKey;
    public Scriptable topCallScope;
    boolean isContinuationsTopCall;
    NativeCall currentActivationCall;
    BaseFunction typeErrorThrower;
    ObjToIntMap iterating;
    Object interpreterSecurityDomain;
    int version;
    private File debugOutputPath;
    private SecurityController securityController;
    private boolean hasClassShutter;
    private ClassShutter classShutter;
    private ErrorReporter errorReporter;
    RegExpProxy regExpProxy;
    private Locale locale;
    private boolean generatingDebug;
    private boolean generatingDebugChanged;
    private boolean generatingSource;
    boolean useDynamicScope;
    private int optimizationLevel;
    private int maximumInterpreterStackDepth;
    private WrapFactory wrapFactory;
    Debugger debugger;
    private Object debuggerData;
    private int enterCount;
    private Object propertyListeners;
    private Map<Object, Object> threadLocalMap;
    private ClassLoader applicationClassLoader;
    Set<String> activationNames;
    Object lastInterpreterFrame;
    ObjArray previousInterpreterInvocations;
    int instructionCount;
    int instructionThreshold;
    int scratchIndex;
    long scratchUint32;
    Scriptable scratchScriptable;
    public boolean generateObserverCount;
    boolean isTopLevelStrict;
    
    @Deprecated
    public Context() {
        this(ContextFactory.getGlobal());
    }
    
    protected Context(final ContextFactory factory) {
        this.debugOutputPath = null;
        this.generatingSource = true;
        this.generateObserverCount = false;
        if (factory == null) {
            throw new IllegalArgumentException("factory == null");
        }
        this.factory = factory;
        this.version = 0;
        this.optimizationLevel = ((Context.codegenClass != null) ? 0 : -1);
        this.maximumInterpreterStackDepth = Integer.MAX_VALUE;
    }
    
    public static Context getCurrentContext() {
        final Object helper = VMBridge.instance.getThreadContextHelper();
        return VMBridge.instance.getContext(helper);
    }
    
    public static Context enter() {
        return enter(null);
    }
    
    @Deprecated
    public static Context enter(final Context cx) {
        return enter(cx, ContextFactory.getGlobal());
    }
    
    static final Context enter(Context cx, final ContextFactory factory) {
        final Object helper = VMBridge.instance.getThreadContextHelper();
        final Context old = VMBridge.instance.getContext(helper);
        if (old != null) {
            cx = old;
        }
        else {
            if (cx == null) {
                cx = factory.makeContext();
                if (cx.enterCount != 0) {
                    throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
                }
                factory.onContextCreated(cx);
                if (factory.isSealed() && !cx.isSealed()) {
                    cx.seal(null);
                }
            }
            else if (cx.enterCount != 0) {
                throw new IllegalStateException("can not use Context instance already associated with some thread");
            }
            VMBridge.instance.setContext(helper, cx);
        }
        final Context context = cx;
        ++context.enterCount;
        return cx;
    }
    
    public static void exit() {
        final Object helper = VMBridge.instance.getThreadContextHelper();
        final Context cx = VMBridge.instance.getContext(helper);
        if (cx == null) {
            throw new IllegalStateException("Calling Context.exit without previous Context.enter");
        }
        if (cx.enterCount < 1) {
            Kit.codeBug();
        }
        final Context context = cx;
        if (--context.enterCount == 0) {
            VMBridge.instance.setContext(helper, null);
            cx.factory.onContextReleased(cx);
        }
    }
    
    @Deprecated
    public static <T> T call(final ContextAction<T> action) {
        return call(ContextFactory.getGlobal(), action);
    }
    
    public static Object call(ContextFactory factory, final Callable callable, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (factory == null) {
            factory = ContextFactory.getGlobal();
        }
        return call(factory, cx -> callable.call(cx, scope, thisObj, args));
    }
    
    static <T> T call(final ContextFactory factory, final ContextAction<T> action) {
        final Context cx = enter(null, factory);
        try {
            return action.run(cx);
        }
        finally {
            exit();
        }
    }
    
    @Deprecated
    public static void addContextListener(final ContextListener listener) {
        final String DBG = "org.mozilla.javascript.tools.debugger.Main";
        if (DBG.equals(listener.getClass().getName())) {
            final Class<?> cl = listener.getClass();
            final Class<?> factoryClass = Kit.classOrNull("org.mozilla.javascript.ContextFactory");
            final Class<?>[] sig = (Class<?>[])new Class[] { factoryClass };
            final Object[] args = { ContextFactory.getGlobal() };
            try {
                final Method m = cl.getMethod("attachTo", sig);
                m.invoke(listener, args);
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return;
        }
        ContextFactory.getGlobal().addListener(listener);
    }
    
    @Deprecated
    public static void removeContextListener(final ContextListener listener) {
        ContextFactory.getGlobal().addListener(listener);
    }
    
    public final ContextFactory getFactory() {
        return this.factory;
    }
    
    public final boolean isSealed() {
        return this.sealed;
    }
    
    public final void seal(final Object sealKey) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.sealed = true;
        this.sealKey = sealKey;
    }
    
    public final void unseal(final Object sealKey) {
        if (sealKey == null) {
            throw new IllegalArgumentException();
        }
        if (this.sealKey != sealKey) {
            throw new IllegalArgumentException();
        }
        if (!this.sealed) {
            throw new IllegalStateException();
        }
        this.sealed = false;
        this.sealKey = null;
    }
    
    static void onSealedMutation() {
        throw new IllegalStateException();
    }
    
    public final int getLanguageVersion() {
        return this.version;
    }
    
    public void setLanguageVersion(final int version) {
        if (this.sealed) {
            onSealedMutation();
        }
        checkLanguageVersion(version);
        final Object listeners = this.propertyListeners;
        if (listeners != null && version != this.version) {
            this.firePropertyChangeImpl(listeners, "language version", this.version, version);
        }
        this.version = version;
    }
    
    public static boolean isValidLanguageVersion(final int version) {
        switch (version) {
            case 0:
            case 100:
            case 110:
            case 120:
            case 130:
            case 140:
            case 150:
            case 160:
            case 170:
            case 180:
            case 200: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public static void checkLanguageVersion(final int version) {
        if (isValidLanguageVersion(version)) {
            return;
        }
        throw new IllegalArgumentException("Bad language version: " + version);
    }
    
    public final String getImplementationVersion() {
        if (Context.implementationVersion == null) {
            Enumeration<URL> urls;
            try {
                urls = Context.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            }
            catch (IOException ioe) {
                return null;
            }
            while (urls.hasMoreElements()) {
                final URL metaUrl = urls.nextElement();
                InputStream is = null;
                try {
                    is = metaUrl.openStream();
                    final Manifest mf = new Manifest(is);
                    final Attributes attrs = mf.getMainAttributes();
                    if ("Mozilla Rhino".equals(attrs.getValue("Implementation-Title"))) {
                        Context.implementationVersion = "Rhino " + attrs.getValue("Implementation-Version") + " " + attrs.getValue("Built-Date").replaceAll("-", " ");
                        return Context.implementationVersion;
                    }
                }
                catch (IOException ex) {}
                finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    }
                    catch (IOException ex2) {}
                }
            }
        }
        return Context.implementationVersion;
    }
    
    public final void setDebugOutputPath(final File debugOutputPath) {
        this.setDebugOutputPath(debugOutputPath, true);
    }
    
    public final void setDebugOutputPath(final File debugOutputPath, final boolean clearFiles) {
        if (debugOutputPath.exists() && debugOutputPath.isDirectory() && clearFiles) {
            final File[] files = debugOutputPath.listFiles();
            if (files != null) {
                for (final File child : files) {
                    final File[] childFiles = child.listFiles();
                    if (childFiles != null) {
                        for (final File child2 : childFiles) {
                            child2.delete();
                        }
                        child.delete();
                    }
                }
            }
        }
        else if (!debugOutputPath.exists() && !debugOutputPath.mkdirs()) {
            throw new IllegalArgumentException("Given debug output path does not exist, and is unable to be created");
        }
        this.debugOutputPath = debugOutputPath;
    }
    
    public final File getDebugOutputPath() {
        if (!this.hasFeature(19)) {
            return null;
        }
        if (this.debugOutputPath == null) {
            throw new IllegalStateException("debugOutputPath is null despite EMITE_DEBUG_OUTPUT being enabled");
        }
        return this.debugOutputPath;
    }
    
    public final ErrorReporter getErrorReporter() {
        if (this.errorReporter == null) {
            return DefaultErrorReporter.instance;
        }
        return this.errorReporter;
    }
    
    public final ErrorReporter setErrorReporter(final ErrorReporter reporter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (reporter == null) {
            throw new IllegalArgumentException();
        }
        final ErrorReporter old = this.getErrorReporter();
        if (reporter == old) {
            return old;
        }
        final Object listeners = this.propertyListeners;
        if (listeners != null) {
            this.firePropertyChangeImpl(listeners, "error reporter", old, reporter);
        }
        this.errorReporter = reporter;
        return old;
    }
    
    public final Locale getLocale() {
        if (this.locale == null) {
            this.locale = Locale.getDefault();
        }
        return this.locale;
    }
    
    public final Locale setLocale(final Locale loc) {
        if (this.sealed) {
            onSealedMutation();
        }
        final Locale result = this.locale;
        this.locale = loc;
        return result;
    }
    
    public final void addPropertyChangeListener(final PropertyChangeListener l) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.addListener(this.propertyListeners, l);
    }
    
    public final void removePropertyChangeListener(final PropertyChangeListener l) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.removeListener(this.propertyListeners, l);
    }
    
    final void firePropertyChange(final String property, final Object oldValue, final Object newValue) {
        final Object listeners = this.propertyListeners;
        if (listeners != null) {
            this.firePropertyChangeImpl(listeners, property, oldValue, newValue);
        }
    }
    
    private void firePropertyChangeImpl(final Object listeners, final String property, final Object oldValue, final Object newValue) {
        int i = 0;
        while (true) {
            final Object l = Kit.getListener(listeners, i);
            if (l == null) {
                break;
            }
            if (l instanceof PropertyChangeListener) {
                final PropertyChangeListener pcl = (PropertyChangeListener)l;
                pcl.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
            }
            ++i;
        }
    }
    
    public static void reportWarning(final String message, final String sourceName, final int lineno, final String lineSource, final int lineOffset) {
        final Context cx = getContext();
        if (cx.hasFeature(11)) {
            reportError(message, sourceName, lineno, lineSource, lineOffset);
        }
        else {
            cx.getErrorReporter().warning(message, sourceName, lineno, lineSource, lineOffset);
        }
    }
    
    public static void reportWarning(final String message) {
        final int[] linep = { 0 };
        final String filename = getSourcePositionFromStack(linep);
        reportWarning(message, filename, linep[0], null, 0);
    }
    
    public static void reportWarning(final String message, final Throwable t) {
        final int[] linep = { 0 };
        final String filename = getSourcePositionFromStack(linep);
        final Writer sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        pw.println(message);
        t.printStackTrace(pw);
        pw.flush();
        reportWarning(sw.toString(), filename, linep[0], null, 0);
    }
    
    public static void reportError(final String message, final String sourceName, final int lineno, final String lineSource, final int lineOffset) {
        final Context cx = getCurrentContext();
        if (cx != null) {
            cx.getErrorReporter().error(message, sourceName, lineno, lineSource, lineOffset);
            return;
        }
        throw new EvaluatorException(message, sourceName, lineno, lineSource, lineOffset);
    }
    
    public static void reportError(final String message) {
        final int[] linep = { 0 };
        final String filename = getSourcePositionFromStack(linep);
        reportError(message, filename, linep[0], null, 0);
    }
    
    public static EvaluatorException reportRuntimeError(final String message, final String sourceName, final int lineno, final String lineSource, final int lineOffset) {
        final Context cx = getCurrentContext();
        if (cx != null) {
            return cx.getErrorReporter().runtimeError(message, sourceName, lineno, lineSource, lineOffset);
        }
        throw new EvaluatorException(message, sourceName, lineno, lineSource, lineOffset);
    }
    
    static EvaluatorException reportRuntimeError0(final String messageId) {
        final String msg = ScriptRuntime.getMessage0(messageId);
        return reportRuntimeError(msg);
    }
    
    static EvaluatorException reportRuntimeError1(final String messageId, final Object arg1) {
        final String msg = ScriptRuntime.getMessage1(messageId, arg1);
        return reportRuntimeError(msg);
    }
    
    static EvaluatorException reportRuntimeError2(final String messageId, final Object arg1, final Object arg2) {
        final String msg = ScriptRuntime.getMessage2(messageId, arg1, arg2);
        return reportRuntimeError(msg);
    }
    
    static EvaluatorException reportRuntimeError3(final String messageId, final Object arg1, final Object arg2, final Object arg3) {
        final String msg = ScriptRuntime.getMessage3(messageId, arg1, arg2, arg3);
        return reportRuntimeError(msg);
    }
    
    static EvaluatorException reportRuntimeError4(final String messageId, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        final String msg = ScriptRuntime.getMessage4(messageId, arg1, arg2, arg3, arg4);
        return reportRuntimeError(msg);
    }
    
    public static EvaluatorException reportRuntimeError(final String message) {
        final int[] linep = { 0 };
        final String filename = getSourcePositionFromStack(linep);
        return reportRuntimeError(message, filename, linep[0], null, 0);
    }
    
    public final ScriptableObject initStandardObjects() {
        return this.initStandardObjects(null, false);
    }
    
    public final ScriptableObject initSafeStandardObjects() {
        return this.initSafeStandardObjects(null, false);
    }
    
    public final Scriptable initStandardObjects(final ScriptableObject scope) {
        return this.initStandardObjects(scope, false);
    }
    
    public final Scriptable initSafeStandardObjects(final ScriptableObject scope) {
        return this.initSafeStandardObjects(scope, false);
    }
    
    public ScriptableObject initStandardObjects(final ScriptableObject scope, final boolean sealed) {
        return ScriptRuntime.initStandardObjects(this, scope, sealed);
    }
    
    public ScriptableObject initSafeStandardObjects(final ScriptableObject scope, final boolean sealed) {
        return ScriptRuntime.initSafeStandardObjects(this, scope, sealed);
    }
    
    public static Object getUndefinedValue() {
        return Undefined.instance;
    }
    
    public final Object evaluateString(final Scriptable scope, final String source, final String sourceName, final int lineno, final Object securityDomain) {
        final Script script = this.compileString(source, sourceName, lineno, securityDomain);
        if (script != null) {
            return script.exec(this, scope);
        }
        return null;
    }
    
    public final Object evaluateReader(final Scriptable scope, final Reader in, final String sourceName, final int lineno, final Object securityDomain) throws IOException {
        final Script script = this.compileReader(scope, in, sourceName, lineno, securityDomain);
        if (script != null) {
            return script.exec(this, scope);
        }
        return null;
    }
    
    public Object executeScriptWithContinuations(final Script script, final Scriptable scope) throws ContinuationPending {
        if (!(script instanceof InterpretedFunction) || !((InterpretedFunction)script).isScript()) {
            throw new IllegalArgumentException("Script argument was not a script or was not created by interpreted mode ");
        }
        return this.callFunctionWithContinuations((Callable)script, scope, ScriptRuntime.emptyArgs);
    }
    
    public Object callFunctionWithContinuations(final Callable function, final Scriptable scope, final Object[] args) throws ContinuationPending {
        if (!(function instanceof InterpretedFunction)) {
            throw new IllegalArgumentException("Function argument was not created by interpreted mode ");
        }
        if (ScriptRuntime.hasTopCall(this)) {
            throw new IllegalStateException("Cannot have any pending top calls when executing a script with continuations");
        }
        this.isContinuationsTopCall = true;
        return ScriptRuntime.doTopCall(function, this, scope, scope, args, this.isTopLevelStrict);
    }
    
    public ContinuationPending captureContinuation() {
        return new ContinuationPending(Interpreter.captureContinuation(this));
    }
    
    public Object resumeContinuation(final Object continuation, final Scriptable scope, final Object functionResult) throws ContinuationPending {
        final Object[] args = { functionResult };
        return Interpreter.restartContinuation((NativeContinuation)continuation, this, scope, args);
    }
    
    public final boolean stringIsCompilableUnit(final String source) {
        boolean errorseen = false;
        final CompilerEnvirons compilerEnv = new CompilerEnvirons();
        compilerEnv.initFromContext(this);
        compilerEnv.setGeneratingSource(false);
        final Parser p = new Parser(compilerEnv, DefaultErrorReporter.instance);
        try {
            p.parse(source, null, 1);
        }
        catch (EvaluatorException ee) {
            errorseen = true;
        }
        return !errorseen || !p.eof();
    }
    
    @Deprecated
    public final Script compileReader(final Scriptable scope, final Reader in, final String sourceName, final int lineno, final Object securityDomain) throws IOException {
        return this.compileReader(in, sourceName, lineno, securityDomain);
    }
    
    public final Script compileReader(final Reader in, final String sourceName, int lineno, final Object securityDomain) throws IOException {
        if (lineno < 0) {
            lineno = 0;
        }
        return (Script)this.compileImpl(null, Kit.readReader(in), sourceName, lineno, securityDomain, false, null, null);
    }
    
    public final Script compileString(final String source, final String sourceName, int lineno, final Object securityDomain) {
        if (lineno < 0) {
            lineno = 0;
        }
        return this.compileString(source, null, null, sourceName, lineno, securityDomain);
    }
    
    final Script compileString(final String source, final Evaluator compiler, final ErrorReporter compilationErrorReporter, final String sourceName, final int lineno, final Object securityDomain) {
        try {
            return (Script)this.compileImpl(null, source, sourceName, lineno, securityDomain, false, compiler, compilationErrorReporter);
        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
    
    public final Function compileFunction(final Scriptable scope, final String source, final String sourceName, final int lineno, final Object securityDomain) {
        return this.compileFunction(scope, source, null, null, sourceName, lineno, securityDomain);
    }
    
    final Function compileFunction(final Scriptable scope, final String source, final Evaluator compiler, final ErrorReporter compilationErrorReporter, final String sourceName, final int lineno, final Object securityDomain) {
        try {
            return (Function)this.compileImpl(scope, source, sourceName, lineno, securityDomain, true, compiler, compilationErrorReporter);
        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
    
    public final String decompileScript(final Script script, final int indent) {
        final NativeFunction scriptImpl = (NativeFunction)script;
        return scriptImpl.decompile(indent, 0);
    }
    
    public final String decompileFunction(final Function fun, final int indent) {
        if (fun instanceof BaseFunction) {
            return ((BaseFunction)fun).decompile(indent, 0);
        }
        return "function " + fun.getClassName() + "() {\n\t[native code]\n}\n";
    }
    
    public final String decompileFunctionBody(final Function fun, final int indent) {
        if (fun instanceof BaseFunction) {
            final BaseFunction bf = (BaseFunction)fun;
            return bf.decompile(indent, 1);
        }
        return "[native code]\n";
    }
    
    public NativeObject newObject(final Scriptable scope) {
        final NativeObject result = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(result, scope, TopLevel.Builtins.Object);
        return result;
    }
    
    public Scriptable newObject(final Scriptable scope, final String constructorName) {
        return this.newObject(scope, constructorName, ScriptRuntime.emptyArgs);
    }
    
    public Scriptable newObject(final Scriptable scope, final String constructorName, final Object[] args) {
        return ScriptRuntime.newObject(this, scope, constructorName, args);
    }
    
    public Scriptable newArray(final Scriptable scope, final int length) {
        final NativeArray result = new NativeArray(length);
        ScriptRuntime.setBuiltinProtoAndParent(result, scope, TopLevel.Builtins.Array);
        return result;
    }
    
    public NativeArray newArray(final Scriptable scope, final Object[] elements) {
        if (elements.getClass().getComponentType() != ScriptRuntime.ObjectClass) {
            throw new IllegalArgumentException();
        }
        final NativeArray result = new NativeArray(elements);
        ScriptRuntime.setBuiltinProtoAndParent(result, scope, TopLevel.Builtins.Array);
        return result;
    }
    
    public final Object[] getElements(final Scriptable object) {
        return ScriptRuntime.getArrayElements(object);
    }
    
    public static boolean toBoolean(final Object value) {
        return ScriptRuntime.toBoolean(value);
    }
    
    public static double toNumber(final Object value) {
        return ScriptRuntime.toNumber(value);
    }
    
    public static String toString(final Object value) {
        return ScriptRuntime.toString(value);
    }
    
    public static Scriptable toObject(final Object value, final Scriptable scope) {
        return ScriptRuntime.toObject(scope, value);
    }
    
    @Deprecated
    public static Scriptable toObject(final Object value, final Scriptable scope, final Class<?> staticType) {
        return ScriptRuntime.toObject(scope, value);
    }
    
    public static Object javaToJS(final Object value, final Scriptable scope) {
        if (value instanceof String || value instanceof Number || value instanceof Boolean || value instanceof Scriptable) {
            return value;
        }
        if (value instanceof Character) {
            return String.valueOf((char)value);
        }
        final Context cx = getContext();
        return cx.getWrapFactory().wrap(cx, scope, value, null);
    }
    
    public static Object jsToJava(final Object value, final Class<?> desiredType) throws EvaluatorException {
        return NativeJavaObject.coerceTypeImpl(desiredType, value);
    }
    
    @Deprecated
    public static Object toType(final Object value, final Class<?> desiredType) throws IllegalArgumentException {
        try {
            return jsToJava(value, desiredType);
        }
        catch (EvaluatorException ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }
    
    public static RuntimeException throwAsScriptRuntimeEx(Throwable e) {
        while (e instanceof InvocationTargetException) {
            e = ((InvocationTargetException)e).getTargetException();
        }
        if (e instanceof Error) {
            final Context cx = getContext();
            if (cx == null || !cx.hasFeature(12)) {
                throw (Error)e;
            }
        }
        if (e instanceof RhinoException) {
            throw (RhinoException)e;
        }
        throw new WrappedException(e);
    }
    
    public final boolean isGeneratingDebug() {
        return this.generatingDebug;
    }
    
    public final void setGeneratingDebug(final boolean generatingDebug) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingDebugChanged = true;
        if (generatingDebug && this.getOptimizationLevel() > 0) {
            this.setOptimizationLevel(0);
        }
        this.generatingDebug = generatingDebug;
    }
    
    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }
    
    public final void setGeneratingSource(final boolean generatingSource) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingSource = generatingSource;
    }
    
    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }
    
    public final void setOptimizationLevel(int optimizationLevel) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (optimizationLevel == -2) {
            optimizationLevel = -1;
        }
        checkOptimizationLevel(optimizationLevel);
        if (Context.codegenClass == null) {
            optimizationLevel = -1;
        }
        this.optimizationLevel = optimizationLevel;
    }
    
    public static boolean isValidOptimizationLevel(final int optimizationLevel) {
        return -1 <= optimizationLevel && optimizationLevel <= 9;
    }
    
    public static void checkOptimizationLevel(final int optimizationLevel) {
        if (isValidOptimizationLevel(optimizationLevel)) {
            return;
        }
        throw new IllegalArgumentException("Optimization level outside [-1..9]: " + optimizationLevel);
    }
    
    public final int getMaximumInterpreterStackDepth() {
        return this.maximumInterpreterStackDepth;
    }
    
    public final void setMaximumInterpreterStackDepth(final int max) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.optimizationLevel != -1) {
            throw new IllegalStateException("Cannot set maximumInterpreterStackDepth when optimizationLevel != -1");
        }
        if (max < 1) {
            throw new IllegalArgumentException("Cannot set maximumInterpreterStackDepth to less than 1");
        }
        this.maximumInterpreterStackDepth = max;
    }
    
    public final void setSecurityController(final SecurityController controller) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (controller == null) {
            throw new IllegalArgumentException();
        }
        if (this.securityController != null) {
            throw new SecurityException("Can not overwrite existing SecurityController object");
        }
        if (SecurityController.hasGlobal()) {
            throw new SecurityException("Can not overwrite existing global SecurityController object");
        }
        this.securityController = controller;
    }
    
    public final synchronized void setClassShutter(final ClassShutter shutter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (shutter == null) {
            throw new IllegalArgumentException();
        }
        if (this.hasClassShutter) {
            throw new SecurityException("Cannot overwrite existing ClassShutter object");
        }
        this.classShutter = shutter;
        this.hasClassShutter = true;
    }
    
    final synchronized ClassShutter getClassShutter() {
        return this.classShutter;
    }
    
    public final synchronized ClassShutterSetter getClassShutterSetter() {
        if (this.hasClassShutter) {
            return null;
        }
        this.hasClassShutter = true;
        return new ClassShutterSetter() {
            @Override
            public void setClassShutter(final ClassShutter shutter) {
                Context.this.classShutter = shutter;
            }
            
            @Override
            public ClassShutter getClassShutter() {
                return Context.this.classShutter;
            }
        };
    }
    
    public final Object getThreadLocal(final Object key) {
        if (this.threadLocalMap == null) {
            return null;
        }
        return this.threadLocalMap.get(key);
    }
    
    public final synchronized void putThreadLocal(final Object key, final Object value) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            this.threadLocalMap = new HashMap<Object, Object>();
        }
        this.threadLocalMap.put(key, value);
    }
    
    public final void removeThreadLocal(final Object key) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            return;
        }
        this.threadLocalMap.remove(key);
    }
    
    @Deprecated
    public static void setCachingEnabled(final boolean cachingEnabled) {
    }
    
    public final void setWrapFactory(final WrapFactory wrapFactory) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (wrapFactory == null) {
            throw new IllegalArgumentException();
        }
        this.wrapFactory = wrapFactory;
    }
    
    public final WrapFactory getWrapFactory() {
        if (this.wrapFactory == null) {
            this.wrapFactory = new WrapFactory();
        }
        return this.wrapFactory;
    }
    
    public final Debugger getDebugger() {
        return this.debugger;
    }
    
    public final Object getDebuggerContextData() {
        return this.debuggerData;
    }
    
    public final void setDebugger(final Debugger debugger, final Object contextData) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.debugger = debugger;
        this.debuggerData = contextData;
    }
    
    public static DebuggableScript getDebuggableView(final Script script) {
        if (script instanceof NativeFunction) {
            return ((NativeFunction)script).getDebuggableView();
        }
        return null;
    }
    
    public boolean hasFeature(final int featureIndex) {
        final ContextFactory f = this.getFactory();
        return f.hasFeature(this, featureIndex);
    }
    
    public final int getInstructionObserverThreshold() {
        return this.instructionThreshold;
    }
    
    public final void setInstructionObserverThreshold(final int threshold) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (threshold < 0) {
            throw new IllegalArgumentException();
        }
        this.instructionThreshold = threshold;
        this.setGenerateObserverCount(threshold > 0);
    }
    
    public void setGenerateObserverCount(final boolean generateObserverCount) {
        this.generateObserverCount = generateObserverCount;
    }
    
    protected void observeInstructionCount(final int instructionCount) {
        final ContextFactory f = this.getFactory();
        f.observeInstructionCount(this, instructionCount);
    }
    
    public GeneratedClassLoader createClassLoader(final ClassLoader parent) {
        final ContextFactory f = this.getFactory();
        return f.createClassLoader(parent);
    }
    
    public final ClassLoader getApplicationClassLoader() {
        if (this.applicationClassLoader == null) {
            final ContextFactory f = this.getFactory();
            ClassLoader loader = f.getApplicationClassLoader();
            if (loader == null) {
                final ClassLoader threadLoader = Thread.currentThread().getContextClassLoader();
                if (threadLoader != null && Kit.testIfCanLoadRhinoClasses(threadLoader)) {
                    return threadLoader;
                }
                final Class<?> fClass = f.getClass();
                if (fClass != ScriptRuntime.ContextFactoryClass) {
                    loader = fClass.getClassLoader();
                }
                else {
                    loader = this.getClass().getClassLoader();
                }
            }
            this.applicationClassLoader = loader;
        }
        return this.applicationClassLoader;
    }
    
    public final void setApplicationClassLoader(final ClassLoader loader) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (loader == null) {
            this.applicationClassLoader = null;
            return;
        }
        if (!Kit.testIfCanLoadRhinoClasses(loader)) {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        }
        this.applicationClassLoader = loader;
    }
    
    public static Context getContext() {
        final Context cx = getCurrentContext();
        if (cx == null) {
            throw new RuntimeException("No Context associated with current Thread");
        }
        return cx;
    }
    
    public static Scriptable getScope() {
        return getContext().topCallScope;
    }
    
    private Object compileImpl(final Scriptable scope, final String sourceString, String sourceName, final int lineno, final Object securityDomain, final boolean returnFunction, Evaluator compiler, ErrorReporter compilationErrorReporter) throws IOException {
        if (sourceName == null) {
            sourceName = "unnamed script";
        }
        if (securityDomain != null && this.getSecurityController() == null) {
            throw new IllegalArgumentException("securityDomain should be null if setSecurityController() was never called");
        }
        if (scope == null == returnFunction) {
            Kit.codeBug();
        }
        final CompilerEnvirons compilerEnv = new CompilerEnvirons();
        compilerEnv.initFromContext(this);
        if (compilationErrorReporter == null) {
            compilationErrorReporter = compilerEnv.getErrorReporter();
        }
        final ScriptNode tree = this.parse(sourceString, sourceName, lineno, compilerEnv, compilationErrorReporter, returnFunction);
        if (compiler == null) {
            compiler = this.createCompiler();
        }
        final Object bytecode = compiler.compile(compilerEnv, tree, tree.getEncodedSource(), returnFunction);
        if (this.debugger != null) {
            if (sourceString == null) {
                Kit.codeBug();
            }
            if (!(bytecode instanceof DebuggableScript)) {
                throw new RuntimeException("NOT SUPPORTED");
            }
            final DebuggableScript dscript = (DebuggableScript)bytecode;
            notifyDebugger_r(this, dscript, sourceString);
        }
        Object result;
        if (returnFunction) {
            result = compiler.createFunctionObject(this, scope, bytecode, securityDomain);
        }
        else {
            result = compiler.createScriptObject(bytecode, securityDomain);
        }
        return result;
    }
    
    private ScriptNode parse(final String sourceString, final String sourceName, final int lineno, final CompilerEnvirons compilerEnv, final ErrorReporter compilationErrorReporter, final boolean returnFunction) throws IOException {
        final Parser p = new Parser(compilerEnv, compilationErrorReporter);
        if (returnFunction) {
            p.calledByCompileFunction = true;
        }
        if (this.isStrictMode()) {
            p.setDefaultUseStrictDirective(true);
        }
        final AstRoot ast = p.parse(sourceString, sourceName, lineno);
        if (returnFunction && (ast.getFirstChild() == null || ast.getFirstChild().getType() != 114)) {
            throw new IllegalArgumentException("compileFunction only accepts source with single JS function: " + sourceString);
        }
        final IRFactory irf = new IRFactory(compilerEnv, compilationErrorReporter);
        final ScriptNode tree = irf.transformTree(ast);
        return tree;
    }
    
    private static void notifyDebugger_r(final Context cx, final DebuggableScript dscript, final String debugSource) {
        cx.debugger.handleCompilationDone(cx, dscript, debugSource);
        for (int i = 0; i != dscript.getFunctionCount(); ++i) {
            notifyDebugger_r(cx, dscript.getFunction(i), debugSource);
        }
    }
    
    private Evaluator createCompiler() {
        Evaluator result = null;
        if (this.optimizationLevel >= 0 && Context.codegenClass != null) {
            result = (Evaluator)Kit.newInstanceOrNull(Context.codegenClass);
        }
        if (result == null) {
            result = createInterpreter();
        }
        return result;
    }
    
    static Evaluator createInterpreter() {
        return (Evaluator)Kit.newInstanceOrNull(Context.interpreterClass);
    }
    
    static String getSourcePositionFromStack(final int[] linep) {
        final Context cx = getCurrentContext();
        if (cx == null) {
            return null;
        }
        if (cx.lastInterpreterFrame != null) {
            final Evaluator evaluator = createInterpreter();
            if (evaluator != null) {
                return evaluator.getSourcePositionFromStack(cx, linep);
            }
        }
        final StackTraceElement[] stackTrace2;
        final StackTraceElement[] stackTrace = stackTrace2 = new Throwable().getStackTrace();
        for (final StackTraceElement st : stackTrace2) {
            final String file = st.getFileName();
            if (file != null && !file.endsWith(".java")) {
                final int line = st.getLineNumber();
                if (line >= 0) {
                    linep[0] = line;
                    return file;
                }
            }
        }
        return null;
    }
    
    RegExpProxy getRegExpProxy() {
        if (this.regExpProxy == null) {
            final Class<?> cl = Kit.classOrNull("org.mozilla.javascript.regexp.RegExpImpl");
            if (cl != null) {
                this.regExpProxy = (RegExpProxy)Kit.newInstanceOrNull(cl);
            }
        }
        return this.regExpProxy;
    }
    
    final boolean isVersionECMA1() {
        return this.version == 0 || this.version >= 130;
    }
    
    SecurityController getSecurityController() {
        final SecurityController global = SecurityController.global();
        if (global != null) {
            return global;
        }
        return this.securityController;
    }
    
    public final boolean isGeneratingDebugChanged() {
        return this.generatingDebugChanged;
    }
    
    public void addActivationName(final String name) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames == null) {
            this.activationNames = new HashSet<String>();
        }
        this.activationNames.add(name);
    }
    
    public final boolean isActivationNeeded(final String name) {
        return this.activationNames != null && this.activationNames.contains(name);
    }
    
    public void removeActivationName(final String name) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames != null) {
            this.activationNames.remove(name);
        }
    }
    
    public final boolean isStrictMode() {
        return this.isTopLevelStrict || (this.currentActivationCall != null && this.currentActivationCall.isStrict);
    }
    
    static {
        emptyArgs = ScriptRuntime.emptyArgs;
        Context.codegenClass = Kit.classOrNull("org.mozilla.javascript.optimizer.Codegen");
        Context.interpreterClass = Kit.classOrNull("org.mozilla.javascript.Interpreter");
    }
    
    public interface ClassShutterSetter
    {
        void setClassShutter(final ClassShutter p0);
        
        ClassShutter getClassShutter();
    }
}
