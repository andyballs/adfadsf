//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module;

import java.util.concurrent.*;
import java.net.*;
import java.io.*;
import org.mozilla.javascript.*;
import org.mozilla.javascript.tools.shell.*;
import java.util.*;

public class Require extends BaseFunction
{
    private static final long serialVersionUID = 1L;
    private final ModuleScriptProvider moduleScriptProvider;
    private final Scriptable nativeScope;
    private final Scriptable paths;
    private final boolean sandboxed;
    private final Script preExec;
    private final Script postExec;
    private String mainModuleId;
    private Scriptable mainExports;
    private final Map<String, Scriptable> exportedModuleInterfaces;
    private final Object loadLock;
    private static final ThreadLocal<Map<String, Scriptable>> loadingModuleInterfaces;
    
    public Require(final Context cx, final Scriptable nativeScope, final ModuleScriptProvider moduleScriptProvider, final Script preExec, final Script postExec, final boolean sandboxed) {
        this.mainModuleId = null;
        this.exportedModuleInterfaces = new ConcurrentHashMap<String, Scriptable>();
        this.loadLock = new Object();
        this.moduleScriptProvider = moduleScriptProvider;
        this.nativeScope = nativeScope;
        this.sandboxed = sandboxed;
        this.preExec = preExec;
        this.postExec = postExec;
        this.setPrototype(ScriptableObject.getFunctionPrototype(nativeScope));
        if (!sandboxed) {
            defineReadOnlyProperty((ScriptableObject)this, "paths", this.paths = cx.newArray(nativeScope, 0));
        }
        else {
            this.paths = null;
        }
    }
    
    public Scriptable requireMain(final Context cx, final String mainModuleId) {
        if (this.mainModuleId == null) {
            ModuleScript moduleScript;
            try {
                moduleScript = this.moduleScriptProvider.getModuleScript(cx, mainModuleId, (URI)null, (URI)null, this.paths);
            }
            catch (RuntimeException x) {
                throw x;
            }
            catch (Exception x2) {
                throw new RuntimeException(x2);
            }
            if (moduleScript != null) {
                this.mainExports = this.getExportedModuleInterface(cx, mainModuleId, null, null, true);
            }
            else if (!this.sandboxed) {
                URI mainUri = null;
                try {
                    mainUri = new URI(mainModuleId);
                }
                catch (URISyntaxException ex) {}
                if (mainUri == null || !mainUri.isAbsolute()) {
                    final File file = new File(mainModuleId);
                    if (!file.isFile()) {
                        throw ScriptRuntime.throwError(cx, this.nativeScope, "Module \"" + mainModuleId + "\" not found.");
                    }
                    mainUri = file.toURI();
                }
                this.mainExports = this.getExportedModuleInterface(cx, mainUri.toString(), mainUri, null, true);
            }
            this.mainModuleId = mainModuleId;
            return this.mainExports;
        }
        if (!this.mainModuleId.equals(mainModuleId)) {
            throw new IllegalStateException("Main module already set to " + this.mainModuleId);
        }
        return this.mainExports;
    }
    
    public void install(final Scriptable scope) {
        ScriptableObject.putProperty(scope, "require", this);
        Main.useRequire = true;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (args == null || args.length < 1) {
            throw ScriptRuntime.throwError(cx, scope, "require() needs one argument");
        }
        String id = (String)Context.jsToJava(args[0], String.class);
        URI uri = null;
        URI base = null;
        if (id.startsWith("./") || id.startsWith("../")) {
            if (!(thisObj instanceof ModuleScope)) {
                throw ScriptRuntime.throwError(cx, scope, "Can't resolve relative module ID \"" + id + "\" when require() is used outside of a module");
            }
            final ModuleScope moduleScope = (ModuleScope)thisObj;
            base = moduleScope.getBase();
            final URI current = moduleScope.getUri();
            uri = current.resolve(id);
            if (base == null) {
                id = uri.toString();
            }
            else {
                id = base.relativize(current).resolve(id).toString();
                if (id.charAt(0) == '.') {
                    if (this.sandboxed) {
                        throw ScriptRuntime.throwError(cx, scope, "Module \"" + id + "\" is not contained in sandbox.");
                    }
                    id = uri.toString();
                }
            }
        }
        if (uri != null) {
            final File file = new File(uri);
            if (file.isDirectory()) {
                final File indexFile = new File(file, "index.js");
                if (!indexFile.exists()) {
                    throw ScriptRuntime.typeError1("msg.import.directory.has.no.index.file", file.getAbsolutePath());
                }
                uri = indexFile.toURI();
            }
        }
        return this.getExportedModuleInterface(cx, id, uri, base, false);
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        throw ScriptRuntime.throwError(cx, scope, "require() can not be invoked as a constructor");
    }
    
    public Scriptable getExportedModuleInterface(final Context cx, final String id, final URI uri, final URI base, final boolean isMain) {
        Scriptable exports = this.exportedModuleInterfaces.get(id);
        if (exports == null) {
            Map<String, Scriptable> threadLoadingModules = Require.loadingModuleInterfaces.get();
            if (threadLoadingModules != null) {
                exports = threadLoadingModules.get(id);
                if (exports != null) {
                    return exports;
                }
            }
            synchronized (this.loadLock) {
                exports = this.exportedModuleInterfaces.get(id);
                if (exports != null) {
                    return exports;
                }
                final ModuleScript moduleScript = this.getModule(cx, id, uri, base);
                if (this.sandboxed && !moduleScript.isSandboxed()) {
                    throw ScriptRuntime.throwError(cx, this.nativeScope, "Module \"" + id + "\" is not contained in sandbox.");
                }
                exports = cx.newObject(this.nativeScope);
                final boolean outermostLocked = threadLoadingModules == null;
                if (outermostLocked) {
                    threadLoadingModules = new HashMap<String, Scriptable>();
                    Require.loadingModuleInterfaces.set(threadLoadingModules);
                }
                threadLoadingModules.put(id, exports);
                try {
                    final Scriptable newExports = this.executeModuleScript(cx, id, exports, moduleScript, isMain);
                    if (exports != newExports) {
                        threadLoadingModules.put(id, newExports);
                        exports = newExports;
                    }
                }
                catch (RuntimeException e) {
                    threadLoadingModules.remove(id);
                    throw e;
                }
                finally {
                    if (outermostLocked) {
                        this.exportedModuleInterfaces.putAll(threadLoadingModules);
                        Require.loadingModuleInterfaces.set(null);
                    }
                }
            }
            return exports;
        }
        if (isMain) {
            throw new IllegalStateException("Attempt to set main module after it was loaded");
        }
        return exports;
    }
    
    private Scriptable executeModuleScript(final Context cx, final String id, final Scriptable exports, final ModuleScript moduleScript, final boolean isMain) {
        final ScriptableObject moduleObject = cx.newObject(this.nativeScope);
        final URI uri = moduleScript.getUri();
        final URI base = moduleScript.getBase();
        defineReadOnlyProperty(moduleObject, "id", id);
        if (!this.sandboxed) {
            defineReadOnlyProperty(moduleObject, "uri", uri.toString());
        }
        final Scriptable executionScope = (Scriptable)new ModuleScope(this.nativeScope, uri, base);
        executionScope.put("exports", executionScope, exports);
        executionScope.put("module", executionScope, moduleObject);
        moduleObject.put("exports", moduleObject, exports);
        this.install(executionScope);
        if (isMain) {
            defineReadOnlyProperty((ScriptableObject)this, "main", moduleObject);
        }
        executeOptionalScript(this.preExec, cx, executionScope);
        moduleScript.getScript().exec(cx, executionScope);
        executeOptionalScript(this.postExec, cx, executionScope);
        return ScriptRuntime.toObject(cx, this.nativeScope, ScriptableObject.getProperty(moduleObject, "exports"));
    }
    
    private static void executeOptionalScript(final Script script, final Context cx, final Scriptable executionScope) {
        if (script != null) {
            script.exec(cx, executionScope);
        }
    }
    
    private static void defineReadOnlyProperty(final ScriptableObject obj, final String name, final Object value) {
        ScriptableObject.putProperty(obj, name, value);
        obj.setAttributes(name, 5);
    }
    
    private ModuleScript getModule(final Context cx, final String id, final URI uri, final URI base) {
        try {
            final ModuleScript moduleScript = this.moduleScriptProvider.getModuleScript(cx, id, uri, base, this.paths);
            if (moduleScript == null) {
                throw ScriptRuntime.throwError(cx, this.nativeScope, "Module \"" + id + "\" not found.");
            }
            return moduleScript;
        }
        catch (RuntimeException e) {
            throw e;
        }
        catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }
    
    public String getFunctionName() {
        return "require";
    }
    
    public int getArity() {
        return 1;
    }
    
    public int getLength() {
        return 1;
    }
    
    static {
        loadingModuleInterfaces = new ThreadLocal<Map<String, Scriptable>>();
    }
}
