//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.commonjs.module.provider.*;
import org.mozilla.javascript.commonjs.module.*;
import org.mozilla.javascript.tools.*;
import java.lang.reflect.*;
import org.mozilla.javascript.serialize.*;
import java.util.*;
import java.util.regex.*;
import org.mozilla.javascript.*;
import java.nio.charset.*;
import java.io.*;
import java.net.*;

public class Global extends ImporterTopLevel
{
    static final long serialVersionUID = 4029130780977538005L;
    NativeArray history;
    boolean attemptedJLineLoad;
    private ShellConsole console;
    private InputStream inStream;
    private PrintStream outStream;
    private PrintStream errStream;
    private boolean sealedStdLib;
    boolean initialized;
    private QuitAction quitAction;
    private String[] prompts;
    private HashMap<String, String> doctestCanonicalizations;
    
    public Global() {
        this.sealedStdLib = false;
        this.prompts = new String[] { "js> ", "  > " };
    }
    
    public Global(final Context cx) {
        this.sealedStdLib = false;
        this.prompts = new String[] { "js> ", "  > " };
        this.init(cx);
    }
    
    public boolean isInitialized() {
        return this.initialized;
    }
    
    public void initQuitAction(final QuitAction quitAction) {
        if (quitAction == null) {
            throw new IllegalArgumentException("quitAction is null");
        }
        if (this.quitAction != null) {
            throw new IllegalArgumentException("The method is once-call.");
        }
        this.quitAction = quitAction;
    }
    
    public void init(final ContextFactory factory) {
        factory.call(cx -> {
            this.init(cx);
            return null;
        });
    }
    
    public void init(final Context cx) {
        this.initStandardObjects(cx, this.sealedStdLib);
        final String[] names = { "defineClass", "deserialize", "doctest", "gc", "help", "load", "loadClass", "print", "quit", "readline", "readFile", "readUrl", "runCommand", "seal", "serialize", "spawn", "sync", "toint32", "version", "write" };
        this.defineFunctionProperties(names, (Class)Global.class, 2);
        Environment.defineClass((ScriptableObject)this);
        final Environment environment = new Environment((ScriptableObject)this);
        this.defineProperty("environment", (Object)environment, 2);
        this.defineProperty("history", (Object)(this.history = (NativeArray)cx.newArray((Scriptable)this, 0)), 2);
        this.initialized = true;
    }
    
    public Require installRequire(final Context cx, final List<String> modulePath, final boolean sandboxed) {
        final RequireBuilder rb = new RequireBuilder();
        rb.setSandboxed(sandboxed);
        final List<URI> uris = new ArrayList<URI>();
        if (modulePath != null) {
            for (final String path : modulePath) {
                try {
                    URI uri = new URI(path);
                    if (!uri.isAbsolute()) {
                        uri = new File(path).toURI().resolve("");
                    }
                    if (!uri.toString().endsWith("/")) {
                        uri = new URI(uri + "/");
                    }
                    uris.add(uri);
                }
                catch (URISyntaxException usx) {
                    throw new RuntimeException(usx);
                }
            }
        }
        rb.setModuleScriptProvider((ModuleScriptProvider)new SoftCachingModuleScriptProvider((ModuleSourceProvider)new UrlModuleSourceProvider((Iterable)uris, (Iterable)null)));
        final Require require = rb.createRequire(cx, (Scriptable)this);
        require.install((Scriptable)this);
        return require;
    }
    
    public static void help(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        final PrintStream out = getInstance(funObj).getOut();
        out.println(ToolErrorReporter.getMessage("msg.help"));
    }
    
    public static void gc(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        System.gc();
    }
    
    public static Object print(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        return doPrint(args, funObj, true);
    }
    
    public static Object write(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        return doPrint(args, funObj, false);
    }
    
    private static Object doPrint(final Object[] args, final Function funObj, final boolean newline) {
        final PrintStream out = getInstance(funObj).getOut();
        for (int i = 0; i < args.length; ++i) {
            if (i > 0) {
                out.print(" ");
            }
            final Object arg = args[i];
            final String s = (arg instanceof Symbol) ? arg.toString() : Context.toString(arg);
            out.print(s);
        }
        if (newline) {
            out.println();
        }
        return Context.getUndefinedValue();
    }
    
    public static void quit(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        final Global global = getInstance(funObj);
        if (global.quitAction != null) {
            final int exitCode = (args.length == 0) ? 0 : ScriptRuntime.toInt32(args[0]);
            global.quitAction.quit(cx, exitCode);
        }
    }
    
    public static double version(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        if (args.length > 0) {
            final double d = Context.toNumber(args[0]);
            cx.setLanguageVersion((int)d);
        }
        return cx.getLanguageVersion();
    }
    
    public static void load(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        for (final Object arg : args) {
            final String file = Context.toString(arg);
            try {
                Main.processFile(cx, thisObj, file);
            }
            catch (IOException ioex) {
                final String msg = ToolErrorReporter.getMessage("msg.couldnt.read.source", file, ioex.getMessage());
                throw Context.reportRuntimeError(msg);
            }
            catch (VirtualMachineError ex) {
                ex.printStackTrace();
                final String msg = ToolErrorReporter.getMessage("msg.uncaughtJSException", ex.toString());
                throw Context.reportRuntimeError(msg);
            }
        }
    }
    
    public static void defineClass(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class<?> clazz = getClass(args);
        if (!Scriptable.class.isAssignableFrom(clazz)) {
            throw reportRuntimeError("msg.must.implement.Scriptable");
        }
        ScriptableObject.defineClass(thisObj, (Class)clazz);
    }
    
    public static void loadClass(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IllegalAccessException, InstantiationException {
        final Class<?> clazz = getClass(args);
        if (!Script.class.isAssignableFrom(clazz)) {
            throw reportRuntimeError("msg.must.implement.Script");
        }
        final Script script = (Script)clazz.newInstance();
        script.exec(cx, thisObj);
    }
    
    private static Class<?> getClass(final Object[] args) {
        if (args.length == 0) {
            throw reportRuntimeError("msg.expected.string.arg");
        }
        final Object arg0 = args[0];
        if (arg0 instanceof Wrapper) {
            final Object wrapped = ((Wrapper)arg0).unwrap();
            if (wrapped instanceof Class) {
                return (Class<?>)wrapped;
            }
        }
        final String className = Context.toString(args[0]);
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException cnfe) {
            throw reportRuntimeError("msg.class.not.found", className);
        }
    }
    
    public static void serialize(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IOException {
        if (args.length < 2) {
            throw Context.reportRuntimeError("Expected an object to serialize and a filename to write the serialization to");
        }
        final Object obj = args[0];
        final String filename = Context.toString(args[1]);
        final FileOutputStream fos = new FileOutputStream(filename);
        final Scriptable scope = ScriptableObject.getTopLevelScope(thisObj);
        final ScriptableOutputStream out = new ScriptableOutputStream((OutputStream)fos, scope);
        out.writeObject(obj);
        out.close();
    }
    
    public static Object deserialize(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IOException, ClassNotFoundException {
        if (args.length < 1) {
            throw Context.reportRuntimeError("Expected a filename to read the serialization from");
        }
        final String filename = Context.toString(args[0]);
        final FileInputStream fis = new FileInputStream(filename);
        final Scriptable scope = ScriptableObject.getTopLevelScope(thisObj);
        final ObjectInputStream in = (ObjectInputStream)new ScriptableInputStream((InputStream)fis, scope);
        final Object deserialized = in.readObject();
        in.close();
        return Context.toObject(deserialized, scope);
    }
    
    public String[] getPrompts(final Context cx) {
        if (ScriptableObject.hasProperty((Scriptable)this, "prompts")) {
            final Object promptsJS = ScriptableObject.getProperty((Scriptable)this, "prompts");
            if (promptsJS instanceof Scriptable) {
                final Scriptable s = (Scriptable)promptsJS;
                if (ScriptableObject.hasProperty(s, 0) && ScriptableObject.hasProperty(s, 1)) {
                    Object elem0 = ScriptableObject.getProperty(s, 0);
                    if (elem0 instanceof Function) {
                        elem0 = ((Function)elem0).call(cx, (Scriptable)this, s, new Object[0]);
                    }
                    this.prompts[0] = Context.toString(elem0);
                    Object elem2 = ScriptableObject.getProperty(s, 1);
                    if (elem2 instanceof Function) {
                        elem2 = ((Function)elem2).call(cx, (Scriptable)this, s, new Object[0]);
                    }
                    this.prompts[1] = Context.toString(elem2);
                }
            }
        }
        return this.prompts;
    }
    
    public static Object doctest(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        if (args.length == 0) {
            return Boolean.FALSE;
        }
        final String session = Context.toString(args[0]);
        final Global global = getInstance(funObj);
        return new Integer(global.runDoctest(cx, (Scriptable)global, session, null, 0));
    }
    
    public int runDoctest(final Context cx, final Scriptable scope, final String session, final String sourceName, final int lineNumber) {
        this.doctestCanonicalizations = new HashMap<String, String>();
        final String[] lines = session.split("\r\n?|\n");
        final String prompt0 = this.prompts[0].trim();
        final String prompt2 = this.prompts[1].trim();
        int testCount = 0;
        int i;
        for (i = 0; i < lines.length && !lines[i].trim().startsWith(prompt0); ++i) {}
        while (i < lines.length) {
            String inputString = lines[i].trim().substring(prompt0.length());
            inputString += "\n";
            ++i;
            while (i < lines.length && lines[i].trim().startsWith(prompt2)) {
                inputString += lines[i].trim().substring(prompt2.length());
                inputString += "\n";
                ++i;
            }
            String expectedString = "";
            while (i < lines.length && !lines[i].trim().startsWith(prompt0)) {
                expectedString = expectedString + lines[i] + "\n";
                ++i;
            }
            final PrintStream savedOut = this.getOut();
            final PrintStream savedErr = this.getErr();
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ByteArrayOutputStream err = new ByteArrayOutputStream();
            this.setOut(new PrintStream(out));
            this.setErr(new PrintStream(err));
            String resultString = "";
            final ErrorReporter savedErrorReporter = cx.getErrorReporter();
            cx.setErrorReporter((ErrorReporter)new ToolErrorReporter(false, this.getErr()));
            try {
                ++testCount;
                final Object result = cx.evaluateString(scope, inputString, "doctest input", 1, (Object)null);
                if (result != Context.getUndefinedValue() && (!(result instanceof Function) || !inputString.trim().startsWith("function"))) {
                    resultString = Context.toString(result);
                }
            }
            catch (RhinoException e) {
                ToolErrorReporter.reportException(cx.getErrorReporter(), e);
            }
            finally {
                this.setOut(savedOut);
                this.setErr(savedErr);
                cx.setErrorReporter(savedErrorReporter);
                resultString = resultString + err.toString() + out.toString();
            }
            if (!this.doctestOutputMatches(expectedString, resultString)) {
                final String message = "doctest failure running:\n" + inputString + "expected: " + expectedString + "actual: " + resultString + "\n";
                if (sourceName != null) {
                    throw Context.reportRuntimeError(message, sourceName, lineNumber + i - 1, (String)null, 0);
                }
                throw Context.reportRuntimeError(message);
            }
        }
        return testCount;
    }
    
    private boolean doctestOutputMatches(String expected, String actual) {
        expected = expected.trim();
        actual = actual.trim().replace("\r\n", "\n");
        if (expected.equals(actual)) {
            return true;
        }
        for (final Map.Entry<String, String> entry : this.doctestCanonicalizations.entrySet()) {
            expected = expected.replace(entry.getKey(), entry.getValue());
        }
        if (expected.equals(actual)) {
            return true;
        }
        final Pattern p = Pattern.compile("@[0-9a-fA-F]+");
        final Matcher expectedMatcher = p.matcher(expected);
        final Matcher actualMatcher = p.matcher(actual);
        while (expectedMatcher.find()) {
            if (!actualMatcher.find()) {
                return false;
            }
            if (actualMatcher.start() != expectedMatcher.start()) {
                return false;
            }
            final int start = expectedMatcher.start();
            if (!expected.substring(0, start).equals(actual.substring(0, start))) {
                return false;
            }
            final String expectedGroup = expectedMatcher.group();
            final String actualGroup = actualMatcher.group();
            final String mapping = this.doctestCanonicalizations.get(expectedGroup);
            if (mapping == null) {
                this.doctestCanonicalizations.put(expectedGroup, actualGroup);
                expected = expected.replace(expectedGroup, actualGroup);
            }
            else if (!actualGroup.equals(mapping)) {
                return false;
            }
            if (expected.equals(actual)) {
                return true;
            }
        }
        return false;
    }
    
    public static Object spawn(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        final Scriptable scope = funObj.getParentScope();
        Runner runner;
        if (args.length != 0 && args[0] instanceof Function) {
            Object[] newArgs = null;
            if (args.length > 1 && args[1] instanceof Scriptable) {
                newArgs = cx.getElements((Scriptable)args[1]);
            }
            if (newArgs == null) {
                newArgs = ScriptRuntime.emptyArgs;
            }
            runner = new Runner(scope, (Function)args[0], newArgs);
        }
        else {
            if (args.length == 0 || !(args[0] instanceof Script)) {
                throw reportRuntimeError("msg.spawn.args");
            }
            runner = new Runner(scope, (Script)args[0]);
        }
        runner.factory = cx.getFactory();
        final Thread thread = new Thread(runner);
        thread.start();
        return thread;
    }
    
    public static Object sync(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        if (args.length >= 1 && args.length <= 2 && args[0] instanceof Function) {
            Object syncObject = null;
            if (args.length == 2 && args[1] != Undefined.instance) {
                syncObject = args[1];
            }
            return new Synchronizer((Scriptable)args[0], syncObject);
        }
        throw reportRuntimeError("msg.sync.args");
    }
    
    public static Object runCommand(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IOException {
        int L = args.length;
        if (L == 0 || (L == 1 && args[0] instanceof Scriptable)) {
            throw reportRuntimeError("msg.runCommand.bad.args");
        }
        File wd = null;
        InputStream in = null;
        OutputStream out = null;
        OutputStream err = null;
        ByteArrayOutputStream outBytes = null;
        ByteArrayOutputStream errBytes = null;
        Object outObj = null;
        Object errObj = null;
        String[] environment = null;
        Scriptable params = null;
        Object[] addArgs = null;
        if (args[L - 1] instanceof Scriptable) {
            params = (Scriptable)args[L - 1];
            --L;
            final Object envObj = ScriptableObject.getProperty(params, "env");
            if (envObj != Scriptable.NOT_FOUND) {
                if (envObj == null) {
                    environment = new String[0];
                }
                else {
                    if (!(envObj instanceof Scriptable)) {
                        throw reportRuntimeError("msg.runCommand.bad.env");
                    }
                    final Scriptable envHash = (Scriptable)envObj;
                    final Object[] ids = ScriptableObject.getPropertyIds(envHash);
                    environment = new String[ids.length];
                    for (int i = 0; i != ids.length; ++i) {
                        final Object keyObj = ids[i];
                        String key;
                        Object val;
                        if (keyObj instanceof String) {
                            key = (String)keyObj;
                            val = ScriptableObject.getProperty(envHash, key);
                        }
                        else {
                            final int ikey = ((Number)keyObj).intValue();
                            key = Integer.toString(ikey);
                            val = ScriptableObject.getProperty(envHash, ikey);
                        }
                        if (val == ScriptableObject.NOT_FOUND) {
                            val = Undefined.instance;
                        }
                        environment[i] = key + '=' + ScriptRuntime.toString(val);
                    }
                }
            }
            final Object wdObj = ScriptableObject.getProperty(params, "dir");
            if (wdObj != Scriptable.NOT_FOUND) {
                wd = new File(ScriptRuntime.toString(wdObj));
            }
            final Object inObj = ScriptableObject.getProperty(params, "input");
            if (inObj != Scriptable.NOT_FOUND) {
                in = toInputStream(inObj);
            }
            outObj = ScriptableObject.getProperty(params, "output");
            if (outObj != Scriptable.NOT_FOUND) {
                out = toOutputStream(outObj);
                if (out == null) {
                    outBytes = (ByteArrayOutputStream)(out = new ByteArrayOutputStream());
                }
            }
            errObj = ScriptableObject.getProperty(params, "err");
            if (errObj != Scriptable.NOT_FOUND) {
                err = toOutputStream(errObj);
                if (err == null) {
                    errBytes = (ByteArrayOutputStream)(err = new ByteArrayOutputStream());
                }
            }
            final Object addArgsObj = ScriptableObject.getProperty(params, "args");
            if (addArgsObj != Scriptable.NOT_FOUND) {
                final Scriptable s = Context.toObject(addArgsObj, getTopLevelScope(thisObj));
                addArgs = cx.getElements(s);
            }
        }
        final Global global = getInstance(funObj);
        if (out == null) {
            out = ((global != null) ? global.getOut() : System.out);
        }
        if (err == null) {
            err = ((global != null) ? global.getErr() : System.err);
        }
        final String[] cmd = new String[(addArgs == null) ? L : (L + addArgs.length)];
        for (int j = 0; j != L; ++j) {
            cmd[j] = ScriptRuntime.toString(args[j]);
        }
        if (addArgs != null) {
            for (int j = 0; j != addArgs.length; ++j) {
                cmd[L + j] = ScriptRuntime.toString(addArgs[j]);
            }
        }
        final int exitCode = runProcess(cmd, environment, wd, in, out, err);
        if (outBytes != null) {
            final String s2 = ScriptRuntime.toString(outObj) + outBytes.toString();
            ScriptableObject.putProperty(params, "output", (Object)s2);
        }
        if (errBytes != null) {
            final String s2 = ScriptRuntime.toString(errObj) + errBytes.toString();
            ScriptableObject.putProperty(params, "err", (Object)s2);
        }
        return new Integer(exitCode);
    }
    
    public static void seal(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        int i = 0;
        while (i != args.length) {
            final Object arg = args[i];
            if (!(arg instanceof ScriptableObject) || arg == Undefined.instance) {
                if (!(arg instanceof Scriptable) || arg == Undefined.instance) {
                    throw reportRuntimeError("msg.shell.seal.not.object");
                }
                throw reportRuntimeError("msg.shell.seal.not.scriptable");
            }
            else {
                ++i;
            }
        }
        for (i = 0; i != args.length; ++i) {
            final Object arg = args[i];
            ((ScriptableObject)arg).sealObject();
        }
    }
    
    public static Object readFile(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IOException {
        if (args.length == 0) {
            throw reportRuntimeError("msg.shell.readFile.bad.args");
        }
        final String path = ScriptRuntime.toString(args[0]);
        String charCoding = null;
        if (args.length >= 2) {
            charCoding = ScriptRuntime.toString(args[1]);
        }
        return readUrl(path, charCoding, true);
    }
    
    public static Object readUrl(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IOException {
        if (args.length == 0) {
            throw reportRuntimeError("msg.shell.readUrl.bad.args");
        }
        final String url = ScriptRuntime.toString(args[0]);
        String charCoding = null;
        if (args.length >= 2) {
            charCoding = ScriptRuntime.toString(args[1]);
        }
        return readUrl(url, charCoding, false);
    }
    
    public static Object toint32(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) {
        final Object arg = (args.length != 0) ? args[0] : Undefined.instance;
        if (arg instanceof Integer) {
            return arg;
        }
        return ScriptRuntime.wrapInt(ScriptRuntime.toInt32(arg));
    }
    
    private boolean loadJLine(final Charset cs) {
        if (!this.attemptedJLineLoad) {
            this.attemptedJLineLoad = true;
            this.console = ShellConsole.getConsole((Scriptable)this, cs);
        }
        return this.console != null;
    }
    
    public ShellConsole getConsole(final Charset cs) {
        if (!this.loadJLine(cs)) {
            this.console = ShellConsole.getConsole(this.getIn(), this.getErr(), cs);
        }
        return this.console;
    }
    
    public InputStream getIn() {
        if (this.inStream == null && !this.attemptedJLineLoad && this.loadJLine(Charset.defaultCharset())) {
            this.inStream = this.console.getIn();
        }
        return (this.inStream == null) ? System.in : this.inStream;
    }
    
    public void setIn(final InputStream in) {
        this.inStream = in;
    }
    
    public PrintStream getOut() {
        return (this.outStream == null) ? System.out : this.outStream;
    }
    
    public void setOut(final PrintStream out) {
        this.outStream = out;
    }
    
    public PrintStream getErr() {
        return (this.errStream == null) ? System.err : this.errStream;
    }
    
    public void setErr(final PrintStream err) {
        this.errStream = err;
    }
    
    public void setSealedStdLib(final boolean value) {
        this.sealedStdLib = value;
    }
    
    private static Global getInstance(final Function function) {
        final Scriptable scope = function.getParentScope();
        if (!(scope instanceof Global)) {
            throw reportRuntimeError("msg.bad.shell.function.scope", String.valueOf(scope));
        }
        return (Global)scope;
    }
    
    private static int runProcess(final String[] cmd, final String[] environment, final File wd, final InputStream in, final OutputStream out, final OutputStream err) throws IOException {
        Process p;
        if (environment == null) {
            p = Runtime.getRuntime().exec(cmd, null, wd);
        }
        else {
            p = Runtime.getRuntime().exec(cmd, environment, wd);
        }
        try {
            PipeThread inThread = null;
            if (in != null) {
                inThread = new PipeThread(false, in, p.getOutputStream());
                inThread.start();
            }
            else {
                p.getOutputStream().close();
            }
            PipeThread outThread = null;
            if (out != null) {
                outThread = new PipeThread(true, p.getInputStream(), out);
                outThread.start();
            }
            else {
                p.getInputStream().close();
            }
            PipeThread errThread = null;
            if (err != null) {
                errThread = new PipeThread(true, p.getErrorStream(), err);
                errThread.start();
            }
            else {
                p.getErrorStream().close();
            }
            while (true) {
                try {
                    p.waitFor();
                    if (outThread != null) {
                        outThread.join();
                    }
                    if (inThread != null) {
                        inThread.join();
                    }
                    if (errThread != null) {
                        errThread.join();
                    }
                }
                catch (InterruptedException ex) {
                    continue;
                }
                break;
            }
            return p.exitValue();
        }
        finally {
            p.destroy();
        }
    }
    
    static void pipe(final boolean fromProcess, final InputStream from, final OutputStream to) throws IOException {
        try {
            final int SIZE = 4096;
            final byte[] buffer = new byte[4096];
            while (true) {
                int n;
                if (!fromProcess) {
                    n = from.read(buffer, 0, 4096);
                }
                else {
                    try {
                        n = from.read(buffer, 0, 4096);
                    }
                    catch (IOException ex) {
                        break;
                    }
                }
                if (n < 0) {
                    break;
                }
                if (fromProcess) {
                    to.write(buffer, 0, n);
                    to.flush();
                }
                else {
                    try {
                        to.write(buffer, 0, n);
                        to.flush();
                    }
                    catch (IOException ex) {
                        break;
                    }
                }
            }
        }
        finally {
            try {
                if (fromProcess) {
                    from.close();
                }
                else {
                    to.close();
                }
            }
            catch (IOException ex2) {}
        }
    }
    
    private static InputStream toInputStream(final Object value) throws IOException {
        InputStream is = null;
        String s = null;
        if (value instanceof Wrapper) {
            final Object unwrapped = ((Wrapper)value).unwrap();
            if (unwrapped instanceof InputStream) {
                is = (InputStream)unwrapped;
            }
            else if (unwrapped instanceof byte[]) {
                is = new ByteArrayInputStream((byte[])unwrapped);
            }
            else if (unwrapped instanceof Reader) {
                s = readReader((Reader)unwrapped);
            }
            else if (unwrapped instanceof char[]) {
                s = new String((char[])unwrapped);
            }
        }
        if (is == null) {
            if (s == null) {
                s = ScriptRuntime.toString(value);
            }
            is = new ByteArrayInputStream(s.getBytes());
        }
        return is;
    }
    
    private static OutputStream toOutputStream(final Object value) {
        OutputStream os = null;
        if (value instanceof Wrapper) {
            final Object unwrapped = ((Wrapper)value).unwrap();
            if (unwrapped instanceof OutputStream) {
                os = (OutputStream)unwrapped;
            }
        }
        return os;
    }
    
    private static String readUrl(final String filePath, String charCoding, final boolean urlIsFile) throws IOException {
        InputStream is = null;
        try {
            int chunkLength;
            if (!urlIsFile) {
                final URL urlObj = new URL(filePath);
                final URLConnection uc = urlObj.openConnection();
                is = uc.getInputStream();
                chunkLength = uc.getContentLength();
                if (chunkLength <= 0) {
                    chunkLength = 1024;
                }
                if (charCoding == null) {
                    final String type = uc.getContentType();
                    if (type != null) {
                        charCoding = getCharCodingFromType(type);
                    }
                }
            }
            else {
                final File f = new File(filePath);
                if (!f.exists()) {
                    throw new FileNotFoundException("File not found: " + filePath);
                }
                if (!f.canRead()) {
                    throw new IOException("Cannot read file: " + filePath);
                }
                final long length = f.length();
                chunkLength = (int)length;
                if (chunkLength != length) {
                    throw new IOException("Too big file size: " + length);
                }
                if (chunkLength == 0) {
                    return "";
                }
                is = new FileInputStream(f);
            }
            Reader r;
            if (charCoding == null) {
                r = new InputStreamReader(is);
            }
            else {
                r = new InputStreamReader(is, charCoding);
            }
            return readReader(r, chunkLength);
        }
        finally {
            if (is != null) {
                is.close();
            }
        }
    }
    
    public static Object readline(final Context cx, final Scriptable thisObj, final Object[] args, final Function funObj) throws IOException {
        final Global self = getInstance(funObj);
        if (args.length > 0) {
            return self.console.readLine(Context.toString(args[0]));
        }
        return self.console.readLine();
    }
    
    private static String getCharCodingFromType(final String type) {
        int i = type.indexOf(59);
        if (i >= 0) {
            int end = type.length();
            ++i;
            while (i != end && type.charAt(i) <= ' ') {
                ++i;
            }
            final String charset = "charset";
            if (charset.regionMatches(true, 0, type, i, charset.length())) {
                for (i += charset.length(); i != end && type.charAt(i) <= ' '; ++i) {}
                if (i != end && type.charAt(i) == '=') {
                    ++i;
                    while (i != end && type.charAt(i) <= ' ') {
                        ++i;
                    }
                    if (i != end) {
                        while (type.charAt(end - 1) <= ' ') {
                            --end;
                        }
                        return type.substring(i, end);
                    }
                }
            }
        }
        return null;
    }
    
    private static String readReader(final Reader reader) throws IOException {
        return readReader(reader, 4096);
    }
    
    private static String readReader(final Reader reader, final int initialBufferSize) throws IOException {
        char[] buffer = new char[initialBufferSize];
        int offset = 0;
        while (true) {
            final int n = reader.read(buffer, offset, buffer.length - offset);
            if (n < 0) {
                break;
            }
            offset += n;
            if (offset != buffer.length) {
                continue;
            }
            final char[] tmp = new char[buffer.length * 2];
            System.arraycopy(buffer, 0, tmp, 0, offset);
            buffer = tmp;
        }
        return new String(buffer, 0, offset);
    }
    
    static RuntimeException reportRuntimeError(final String msgId) {
        final String message = ToolErrorReporter.getMessage(msgId);
        return (RuntimeException)Context.reportRuntimeError(message);
    }
    
    static RuntimeException reportRuntimeError(final String msgId, final String msgArg) {
        final String message = ToolErrorReporter.getMessage(msgId, msgArg);
        return (RuntimeException)Context.reportRuntimeError(message);
    }
}
