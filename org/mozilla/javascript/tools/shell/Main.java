//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.tools.*;
import java.net.*;
import org.mozilla.javascript.commonjs.module.*;
import java.nio.charset.*;
import java.security.*;
import java.io.*;
import org.mozilla.javascript.*;
import java.lang.ref.*;
import java.util.*;

public class Main
{
    public static ShellContextFactory shellContextFactory;
    public static Global global;
    protected static ToolErrorReporter errorReporter;
    protected static int exitCode;
    private static final int EXITCODE_RUNTIME_ERROR = 3;
    private static final int EXITCODE_FILE_NOT_FOUND = 4;
    static boolean processStdin;
    static List<String> fileList;
    static List<String> modulePath;
    static String mainModule;
    static boolean sandboxed;
    public static boolean useRequire;
    static Require require;
    private static SecurityProxy securityImpl;
    private static final ScriptCache scriptCache;
    
    public static void main(final String[] args) {
        try {
            if (Boolean.getBoolean("rhino.use_java_policy_security")) {
                initJavaPolicySecuritySupport();
            }
        }
        catch (SecurityException ex) {
            ex.printStackTrace(System.err);
        }
        final int result = exec(args);
        if (result != 0) {
            System.exit(result);
        }
    }
    
    public static int exec(final String[] origArgs) {
        Main.errorReporter = new ToolErrorReporter(false, Main.global.getErr());
        Main.shellContextFactory.setErrorReporter((ErrorReporter)Main.errorReporter);
        final String[] args = processOptions(origArgs);
        if (Main.exitCode > 0) {
            return Main.exitCode;
        }
        if (Main.processStdin) {
            Main.fileList.add(null);
        }
        if (!Main.global.initialized) {
            Main.global.init((ContextFactory)Main.shellContextFactory);
        }
        final IProxy iproxy = new IProxy(1);
        iproxy.args = args;
        Main.shellContextFactory.call((ContextAction)iproxy);
        return Main.exitCode;
    }
    
    static void processFiles(final Context cx, final String[] args) {
        final Object[] array = new Object[args.length];
        System.arraycopy(args, 0, array, 0, args.length);
        final Scriptable argsObj = (Scriptable)cx.newArray((Scriptable)Main.global, array);
        Main.global.defineProperty("arguments", (Object)argsObj, 2);
        for (final String file : Main.fileList) {
            try {
                processSource(cx, file);
            }
            catch (IOException ioex) {
                Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", file, ioex.getMessage()));
                Main.exitCode = 4;
            }
            catch (RhinoException rex) {
                ToolErrorReporter.reportException(cx.getErrorReporter(), rex);
                Main.exitCode = 3;
            }
            catch (VirtualMachineError ex) {
                ex.printStackTrace();
                final String msg = ToolErrorReporter.getMessage("msg.uncaughtJSException", ex.toString());
                Context.reportError(msg);
                Main.exitCode = 3;
            }
        }
    }
    
    static void evalInlineScript(final Context cx, final String scriptText) {
        try {
            final Script script = cx.compileString(scriptText, "<command>", 1, (Object)null);
            if (script != null) {
                script.exec(cx, getShellScope());
            }
        }
        catch (RhinoException rex) {
            ToolErrorReporter.reportException(cx.getErrorReporter(), rex);
            Main.exitCode = 3;
        }
        catch (VirtualMachineError ex) {
            ex.printStackTrace();
            final String msg = ToolErrorReporter.getMessage("msg.uncaughtJSException", ex.toString());
            Context.reportError(msg);
            Main.exitCode = 3;
        }
    }
    
    public static Global getGlobal() {
        return Main.global;
    }
    
    static Scriptable getShellScope() {
        return getScope(null);
    }
    
    static Scriptable getScope(final String path) {
        if (Main.useRequire) {
            URI uri;
            if (path == null) {
                uri = new File(System.getProperty("user.dir")).toURI();
            }
            else if (SourceReader.toUrl(path) != null) {
                try {
                    uri = new URI(path);
                }
                catch (URISyntaxException x) {
                    uri = new File(path).toURI();
                }
            }
            else {
                uri = new File(path).toURI();
            }
            return (Scriptable)new ModuleScope((Scriptable)Main.global, uri, (URI)null);
        }
        return (Scriptable)Main.global;
    }
    
    public static String[] processOptions(final String[] args) {
        int i = 0;
        while (i != args.length) {
            final String arg = args[i];
            if (!arg.startsWith("-")) {
                Main.processStdin = false;
                Main.fileList.add(arg);
                Main.mainModule = arg;
                final String[] result = new String[args.length - i - 1];
                System.arraycopy(args, i + 1, result, 0, args.length - i - 1);
                return result;
            }
            String usageError = null;
            Label_0696: {
                if (arg.equals("-version")) {
                    if (++i == args.length) {
                        usageError = arg;
                        break Label_0696;
                    }
                    int version;
                    try {
                        version = Integer.parseInt(args[i]);
                    }
                    catch (NumberFormatException ex) {
                        usageError = args[i];
                        break Label_0696;
                    }
                    if (!Context.isValidLanguageVersion(version)) {
                        usageError = args[i];
                        break Label_0696;
                    }
                    Main.shellContextFactory.setLanguageVersion(version);
                }
                else if (arg.equals("-opt") || arg.equals("-O")) {
                    if (++i == args.length) {
                        usageError = arg;
                        break Label_0696;
                    }
                    int opt;
                    try {
                        opt = Integer.parseInt(args[i]);
                    }
                    catch (NumberFormatException ex) {
                        usageError = args[i];
                        break Label_0696;
                    }
                    if (opt == -2) {
                        opt = -1;
                    }
                    else if (!Context.isValidOptimizationLevel(opt)) {
                        usageError = args[i];
                        break Label_0696;
                    }
                    Main.shellContextFactory.setOptimizationLevel(opt);
                }
                else if (arg.equals("-encoding")) {
                    if (++i == args.length) {
                        usageError = arg;
                        break Label_0696;
                    }
                    final String enc = args[i];
                    Main.shellContextFactory.setCharacterEncoding(enc);
                }
                else if (arg.equals("-strict")) {
                    Main.shellContextFactory.setStrictMode(true);
                    Main.shellContextFactory.setAllowReservedKeywords(false);
                    Main.errorReporter.setIsReportingWarnings(true);
                }
                else if (arg.equals("-fatal-warnings")) {
                    Main.shellContextFactory.setWarningAsError(true);
                }
                else if (arg.equals("-e")) {
                    Main.processStdin = false;
                    if (++i == args.length) {
                        usageError = arg;
                        break Label_0696;
                    }
                    if (!Main.global.initialized) {
                        Main.global.init((ContextFactory)Main.shellContextFactory);
                    }
                    final IProxy iproxy = new IProxy(2);
                    iproxy.scriptText = args[i];
                    Main.shellContextFactory.call((ContextAction)iproxy);
                }
                else if (arg.equals("-require")) {
                    Main.useRequire = true;
                }
                else if (arg.equals("-sandbox")) {
                    Main.sandboxed = true;
                    Main.useRequire = true;
                }
                else if (arg.equals("-modules")) {
                    if (++i == args.length) {
                        usageError = arg;
                        break Label_0696;
                    }
                    if (Main.modulePath == null) {
                        Main.modulePath = new ArrayList<String>();
                    }
                    Main.modulePath.add(args[i]);
                    Main.useRequire = true;
                }
                else if (arg.equals("-w")) {
                    Main.errorReporter.setIsReportingWarnings(true);
                }
                else if (arg.equals("-f")) {
                    Main.processStdin = false;
                    if (++i == args.length) {
                        usageError = arg;
                        break Label_0696;
                    }
                    if (args[i].equals("-")) {
                        Main.fileList.add(null);
                    }
                    else {
                        Main.fileList.add(args[i]);
                        Main.mainModule = args[i];
                    }
                }
                else if (arg.equals("-sealedlib")) {
                    Main.global.setSealedStdLib(true);
                }
                else if (arg.equals("-debug")) {
                    Main.shellContextFactory.setGeneratingDebug(true);
                }
                else {
                    if (arg.equals("-?") || arg.equals("-help")) {
                        Main.global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                        Main.exitCode = 1;
                        return null;
                    }
                    usageError = arg;
                    break Label_0696;
                }
                ++i;
                continue;
            }
            Main.global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", usageError));
            Main.global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
            Main.exitCode = 1;
            return null;
        }
        return new String[0];
    }
    
    private static void initJavaPolicySecuritySupport() {
        Throwable exObj;
        try {
            final Class<?> cl = Class.forName("org.mozilla.javascript.tools.shell.JavaPolicySecurity");
            SecurityController.initGlobal((SecurityController)(Main.securityImpl = (SecurityProxy)cl.newInstance()));
            return;
        }
        catch (ClassNotFoundException ex) {
            exObj = ex;
        }
        catch (IllegalAccessException ex2) {
            exObj = ex2;
        }
        catch (InstantiationException ex3) {
            exObj = ex3;
        }
        catch (LinkageError ex4) {
            exObj = ex4;
        }
        throw new IllegalStateException("Can not load security support: " + exObj, exObj);
    }
    
    public static void processSource(final Context cx, final String filename) throws IOException {
        if (filename == null || filename.equals("-")) {
            final Scriptable scope = getShellScope();
            final String charEnc = Main.shellContextFactory.getCharacterEncoding();
            Charset cs;
            if (charEnc != null) {
                cs = Charset.forName(charEnc);
            }
            else {
                cs = Charset.defaultCharset();
            }
            final ShellConsole console = Main.global.getConsole(cs);
            if (filename == null) {
                console.println(cx.getImplementationVersion());
            }
            int lineno = 1;
            boolean hitEOF = false;
            while (!hitEOF) {
                final String[] prompts = Main.global.getPrompts(cx);
                String prompt = null;
                if (filename == null) {
                    prompt = prompts[0];
                }
                console.flush();
                String source = "";
                while (true) {
                    String newline;
                    try {
                        newline = console.readLine(prompt);
                    }
                    catch (IOException ioe) {
                        console.println(ioe.toString());
                        break;
                    }
                    if (newline == null) {
                        hitEOF = true;
                        break;
                    }
                    source = source + newline + "\n";
                    ++lineno;
                    if (cx.stringIsCompilableUnit(source)) {
                        break;
                    }
                    prompt = prompts[1];
                }
                try {
                    if (source.isEmpty() || source.equals("\n")) {
                        continue;
                    }
                    final Script script = cx.compileString(source, "<stdin>", lineno, (Object)null);
                    if (script == null) {
                        continue;
                    }
                    final Object result = script.exec(cx, scope);
                    Label_0305: {
                        if (result != Context.getUndefinedValue()) {
                            if (result instanceof Function) {
                                if (source.trim().startsWith("function")) {
                                    break Label_0305;
                                }
                            }
                            try {
                                console.println(ScriptRuntime.toStringPretty(result));
                            }
                            catch (RhinoException rex) {
                                ToolErrorReporter.reportException(cx.getErrorReporter(), rex);
                            }
                        }
                    }
                    final NativeArray h = Main.global.history;
                    h.put((int)h.getLength(), (Scriptable)h, (Object)source);
                }
                catch (RhinoException rex2) {
                    ToolErrorReporter.reportException(cx.getErrorReporter(), rex2);
                    Main.exitCode = 3;
                }
                catch (VirtualMachineError ex) {
                    ex.printStackTrace();
                    final String msg = ToolErrorReporter.getMessage("msg.uncaughtJSException", ex.toString());
                    Context.reportError(msg);
                    Main.exitCode = 3;
                }
            }
            console.println();
            console.flush();
        }
        else if (Main.useRequire && filename.equals(Main.mainModule)) {
            Main.require.requireMain(cx, filename);
        }
        else {
            processFile(cx, getScope(filename), filename);
        }
    }
    
    public static void processFileNoThrow(final Context cx, final Scriptable scope, final String filename) {
        try {
            processFile(cx, scope, filename);
        }
        catch (IOException ioex) {
            Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", filename, ioex.getMessage()));
            Main.exitCode = 4;
        }
        catch (RhinoException rex) {
            ToolErrorReporter.reportException(cx.getErrorReporter(), rex);
            Main.exitCode = 3;
        }
        catch (VirtualMachineError ex) {
            ex.printStackTrace();
            final String msg = ToolErrorReporter.getMessage("msg.uncaughtJSException", ex.toString());
            Context.reportError(msg);
            Main.exitCode = 3;
        }
    }
    
    public static void processFile(final Context cx, final Scriptable scope, final String filename) throws IOException {
        if (Main.securityImpl == null) {
            processFileSecure(cx, scope, filename, null);
        }
        else {
            Main.securityImpl.callProcessFileSecure(cx, scope, filename);
        }
    }
    
    static void processFileSecure(final Context cx, final Scriptable scope, final String path, final Object securityDomain) throws IOException {
        final boolean isClass = path.endsWith(".class");
        final Object source = readFileOrUrl(path, !isClass);
        final byte[] digest = getDigest(source);
        final String key = path + "_" + cx.getOptimizationLevel();
        final ScriptReference ref = Main.scriptCache.get(key, digest);
        Script script = (ref != null) ? ref.get() : null;
        if (script == null) {
            if (isClass) {
                script = loadCompiledScript(cx, path, (byte[])source, securityDomain);
            }
            else {
                String strSrc = (String)source;
                if (strSrc.length() > 0 && strSrc.charAt(0) == '#') {
                    for (int i = 1; i != strSrc.length(); ++i) {
                        final int c = strSrc.charAt(i);
                        if (c == 10 || c == 13) {
                            strSrc = strSrc.substring(i);
                            break;
                        }
                    }
                }
                script = cx.compileString(strSrc, path, 1, securityDomain);
            }
            Main.scriptCache.put(key, digest, script);
        }
        if (script != null) {
            script.exec(cx, scope);
        }
    }
    
    private static byte[] getDigest(final Object source) {
        byte[] digest = null;
        if (source != null) {
            byte[] bytes;
            if (source instanceof String) {
                try {
                    bytes = ((String)source).getBytes("UTF-8");
                }
                catch (UnsupportedEncodingException ue) {
                    bytes = ((String)source).getBytes();
                }
            }
            else {
                bytes = (byte[])source;
            }
            try {
                final MessageDigest md = MessageDigest.getInstance("MD5");
                digest = md.digest(bytes);
            }
            catch (NoSuchAlgorithmException nsa) {
                throw new RuntimeException(nsa);
            }
        }
        return digest;
    }
    
    private static Script loadCompiledScript(final Context cx, final String path, final byte[] data, final Object securityDomain) throws FileNotFoundException {
        if (data == null) {
            throw new FileNotFoundException(path);
        }
        int nameStart = path.lastIndexOf(47);
        if (nameStart < 0) {
            nameStart = 0;
        }
        else {
            ++nameStart;
        }
        int nameEnd = path.lastIndexOf(46);
        if (nameEnd < nameStart) {
            nameEnd = path.length();
        }
        final String name = path.substring(nameStart, nameEnd);
        try {
            final GeneratedClassLoader loader = SecurityController.createLoader(cx.getApplicationClassLoader(), securityDomain);
            final Class<?> clazz = (Class<?>)loader.defineClass(name, data);
            loader.linkClass((Class)clazz);
            if (!Script.class.isAssignableFrom(clazz)) {
                throw Context.reportRuntimeError("msg.must.implement.Script");
            }
            return (Script)clazz.newInstance();
        }
        catch (IllegalAccessException iaex) {
            Context.reportError(iaex.toString());
            throw new RuntimeException(iaex);
        }
        catch (InstantiationException inex) {
            Context.reportError(inex.toString());
            throw new RuntimeException(inex);
        }
    }
    
    public static InputStream getIn() {
        return getGlobal().getIn();
    }
    
    public static void setIn(final InputStream in) {
        getGlobal().setIn(in);
    }
    
    public static PrintStream getOut() {
        return getGlobal().getOut();
    }
    
    public static void setOut(final PrintStream out) {
        getGlobal().setOut(out);
    }
    
    public static PrintStream getErr() {
        return getGlobal().getErr();
    }
    
    public static void setErr(final PrintStream err) {
        getGlobal().setErr(err);
    }
    
    private static Object readFileOrUrl(final String path, final boolean convertToString) throws IOException {
        return SourceReader.readFileOrUrl(path, convertToString, Main.shellContextFactory.getCharacterEncoding());
    }
    
    static {
        Main.shellContextFactory = new ShellContextFactory();
        Main.global = new Global();
        Main.exitCode = 0;
        Main.processStdin = true;
        Main.fileList = new ArrayList<String>();
        Main.sandboxed = false;
        Main.useRequire = false;
        scriptCache = new ScriptCache(32);
        Main.global.initQuitAction((QuitAction)new IProxy(3));
    }
    
    private static class IProxy implements ContextAction<Object>, QuitAction
    {
        private static final int PROCESS_FILES = 1;
        private static final int EVAL_INLINE_SCRIPT = 2;
        private static final int SYSTEM_EXIT = 3;
        private int type;
        String[] args;
        String scriptText;
        
        IProxy(final int type) {
            this.type = type;
        }
        
        public Object run(final Context cx) {
            if (Main.useRequire) {
                Main.require = Main.global.installRequire(cx, (List)Main.modulePath, Main.sandboxed);
            }
            if (this.type == 1) {
                Main.processFiles(cx, this.args);
            }
            else {
                if (this.type != 2) {
                    throw Kit.codeBug();
                }
                Main.evalInlineScript(cx, this.scriptText);
            }
            return null;
        }
        
        public void quit(final Context cx, final int exitCode) {
            if (this.type == 3) {
                System.exit(exitCode);
                return;
            }
            throw Kit.codeBug();
        }
    }
    
    static class ScriptReference extends SoftReference<Script>
    {
        String path;
        byte[] digest;
        
        ScriptReference(final String path, final byte[] digest, final Script script, final ReferenceQueue<Script> queue) {
            super(script, queue);
            this.path = path;
            this.digest = digest;
        }
    }
    
    static class ScriptCache extends LinkedHashMap<String, ScriptReference>
    {
        private static final long serialVersionUID = -6866856136258508615L;
        ReferenceQueue<Script> queue;
        int capacity;
        
        ScriptCache(final int capacity) {
            super(capacity + 1, 2.0f, true);
            this.capacity = capacity;
            this.queue = new ReferenceQueue<Script>();
        }
        
        @Override
        protected boolean removeEldestEntry(final Map.Entry<String, ScriptReference> eldest) {
            return this.size() > this.capacity;
        }
        
        ScriptReference get(final String path, final byte[] digest) {
            ScriptReference ref;
            while ((ref = (ScriptReference)this.queue.poll()) != null) {
                this.remove(ref.path);
            }
            ref = ((LinkedHashMap<K, ScriptReference>)this).get(path);
            if (ref != null && !Arrays.equals(digest, ref.digest)) {
                this.remove(ref.path);
                ref = null;
            }
            return ref;
        }
        
        void put(final String path, final byte[] digest, final Script script) {
            this.put(path, new ScriptReference(path, digest, script, this.queue));
        }
    }
}
