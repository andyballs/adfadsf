//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.jsc;

import org.mozilla.javascript.optimizer.*;
import org.mozilla.javascript.*;
import java.util.*;
import org.mozilla.javascript.tools.*;
import java.io.*;

public class Main
{
    private boolean printHelp;
    private ToolErrorReporter reporter;
    private CompilerEnvirons compilerEnv;
    private ClassCompiler compiler;
    private String targetName;
    private String targetPackage;
    private String destinationDir;
    private String characterEncoding;
    
    public static void main(String[] args) {
        final Main main = new Main();
        args = main.processOptions(args);
        if (args == null) {
            if (main.printHelp) {
                System.out.println(ToolErrorReporter.getMessage("msg.jsc.usage", Main.class.getName()));
                System.exit(0);
            }
            System.exit(1);
        }
        if (!main.reporter.hasReportedError()) {
            main.processSource(args);
        }
    }
    
    public Main() {
        this.reporter = new ToolErrorReporter(true);
        (this.compilerEnv = new CompilerEnvirons()).setErrorReporter((ErrorReporter)this.reporter);
        this.compiler = new ClassCompiler(this.compilerEnv);
    }
    
    public String[] processOptions(final String[] args) {
        this.targetPackage = "";
        this.compilerEnv.setGenerateDebugInfo(false);
        int i = 0;
        while (i < args.length) {
            final String arg = args[i];
            if (!arg.startsWith("-")) {
                final int tail = args.length - i;
                if (this.targetName != null && tail > 1) {
                    this.addError("msg.multiple.js.to.file", this.targetName);
                    return null;
                }
                final String[] result = new String[tail];
                for (int j = 0; j != tail; ++j) {
                    result[j] = args[i + j];
                }
                return result;
            }
            else {
                if (arg.equals("-help") || arg.equals("-h") || arg.equals("--help")) {
                    this.printHelp = true;
                    return null;
                }
                Label_0883: {
                    try {
                        if (arg.equals("-version") && ++i < args.length) {
                            final int version = Integer.parseInt(args[i]);
                            this.compilerEnv.setLanguageVersion(version);
                            break Label_0883;
                        }
                        if ((arg.equals("-opt") || arg.equals("-O")) && ++i < args.length) {
                            final int optLevel = Integer.parseInt(args[i]);
                            this.compilerEnv.setOptimizationLevel(optLevel);
                            break Label_0883;
                        }
                    }
                    catch (NumberFormatException e3) {
                        badUsage(args[i]);
                        return null;
                    }
                    if (arg.equals("-nosource")) {
                        this.compilerEnv.setGeneratingSource(false);
                    }
                    else if (arg.equals("-debug") || arg.equals("-g")) {
                        this.compilerEnv.setGenerateDebugInfo(true);
                    }
                    else if (arg.equals("-main-method-class") && ++i < args.length) {
                        this.compiler.setMainMethodClass(args[i]);
                    }
                    else if (arg.equals("-encoding") && ++i < args.length) {
                        this.characterEncoding = args[i];
                    }
                    else if (arg.equals("-o") && ++i < args.length) {
                        String name = args[i];
                        final int end = name.length();
                        if (end == 0 || !Character.isJavaIdentifierStart(name.charAt(0))) {
                            this.addError("msg.invalid.classfile.name", name);
                        }
                        else {
                            int j = 1;
                            while (j < end) {
                                final char c = name.charAt(j);
                                if (!Character.isJavaIdentifierPart(c)) {
                                    if (c == '.' && j == end - 6 && name.endsWith(".class")) {
                                        name = name.substring(0, j);
                                        break;
                                    }
                                    this.addError("msg.invalid.classfile.name", name);
                                    break;
                                }
                                else {
                                    ++j;
                                }
                            }
                            this.targetName = name;
                        }
                    }
                    else {
                        if (arg.equals("-observe-instruction-count")) {
                            this.compilerEnv.setGenerateObserverCount(true);
                        }
                        if (arg.equals("-package") && ++i < args.length) {
                            final String pkg = args[i];
                            final int end = pkg.length();
                            int j = 0;
                            while (j != end) {
                                char c = pkg.charAt(j);
                                if (Character.isJavaIdentifierStart(c)) {
                                    ++j;
                                    while (j != end) {
                                        c = pkg.charAt(j);
                                        if (!Character.isJavaIdentifierPart(c)) {
                                            break;
                                        }
                                        ++j;
                                    }
                                    if (j == end) {
                                        break;
                                    }
                                    if (c == '.' && j != end - 1) {
                                        ++j;
                                        continue;
                                    }
                                }
                                this.addError("msg.package.name", this.targetPackage);
                                return null;
                            }
                            this.targetPackage = pkg;
                        }
                        else if (arg.equals("-extends") && ++i < args.length) {
                            final String targetExtends = args[i];
                            Class<?> superClass;
                            try {
                                superClass = Class.forName(targetExtends);
                            }
                            catch (ClassNotFoundException e) {
                                throw new Error(e.toString());
                            }
                            this.compiler.setTargetExtends((Class)superClass);
                        }
                        else if (arg.equals("-implements") && ++i < args.length) {
                            final String targetImplements = args[i];
                            final StringTokenizer st = new StringTokenizer(targetImplements, ",");
                            final List<Class<?>> list = new ArrayList<Class<?>>();
                            while (st.hasMoreTokens()) {
                                final String className = st.nextToken();
                                try {
                                    list.add(Class.forName(className));
                                }
                                catch (ClassNotFoundException e2) {
                                    throw new Error(e2.toString());
                                }
                            }
                            final Class<?>[] implementsClasses = list.toArray(new Class[list.size()]);
                            this.compiler.setTargetImplements((Class[])implementsClasses);
                        }
                        else {
                            if (!arg.equals("-d") || ++i >= args.length) {
                                badUsage(arg);
                                return null;
                            }
                            this.destinationDir = args[i];
                        }
                    }
                }
                ++i;
            }
        }
        p(ToolErrorReporter.getMessage("msg.no.file"));
        return null;
    }
    
    private static void badUsage(final String s) {
        System.err.println(ToolErrorReporter.getMessage("msg.jsc.bad.usage", Main.class.getName(), s));
    }
    
    public void processSource(final String[] filenames) {
        for (int i = 0; i != filenames.length; ++i) {
            final String filename = filenames[i];
            if (!filename.endsWith(".js")) {
                this.addError("msg.extension.not.js", filename);
                return;
            }
            final File f = new File(filename);
            final String source = this.readSource(f);
            if (source == null) {
                return;
            }
            String mainClassName = this.targetName;
            if (mainClassName == null) {
                final String name = f.getName();
                final String nojs = name.substring(0, name.length() - 3);
                mainClassName = this.getClassName(nojs);
            }
            if (this.targetPackage.length() != 0) {
                mainClassName = this.targetPackage + "." + mainClassName;
            }
            final Object[] compiled = this.compiler.compileToClassFiles(source, filename, 1, mainClassName);
            if (compiled == null || compiled.length == 0) {
                return;
            }
            File targetTopDir = null;
            if (this.destinationDir != null) {
                targetTopDir = new File(this.destinationDir);
            }
            else {
                final String parent = f.getParent();
                if (parent != null) {
                    targetTopDir = new File(parent);
                }
            }
            for (int j = 0; j != compiled.length; j += 2) {
                final String className = (String)compiled[j];
                final byte[] bytes = (byte[])compiled[j + 1];
                final File outfile = this.getOutputFile(targetTopDir, className);
                try {
                    final FileOutputStream os = new FileOutputStream(outfile);
                    try {
                        os.write(bytes);
                    }
                    finally {
                        os.close();
                    }
                }
                catch (IOException ioe) {
                    this.addFormatedError(ioe.toString());
                }
            }
        }
    }
    
    private String readSource(final File f) {
        final String absPath = f.getAbsolutePath();
        if (!f.isFile()) {
            this.addError("msg.jsfile.not.found", absPath);
            return null;
        }
        try {
            return (String)SourceReader.readFileOrUrl(absPath, true, this.characterEncoding);
        }
        catch (FileNotFoundException ex) {
            this.addError("msg.couldnt.open", absPath);
        }
        catch (IOException ioe) {
            this.addFormatedError(ioe.toString());
        }
        return null;
    }
    
    private File getOutputFile(final File parentDir, final String className) {
        String path = className.replace('.', File.separatorChar);
        path = path.concat(".class");
        final File f = new File(parentDir, path);
        final String dirPath = f.getParent();
        if (dirPath != null) {
            final File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }
        return f;
    }
    
    String getClassName(final String name) {
        final char[] s = new char[name.length() + 1];
        int j = 0;
        if (!Character.isJavaIdentifierStart(name.charAt(0))) {
            s[j++] = '_';
        }
        for (int i = 0; i < name.length(); ++i, ++j) {
            final char c = name.charAt(i);
            if (Character.isJavaIdentifierPart(c)) {
                s[j] = c;
            }
            else {
                s[j] = '_';
            }
        }
        return new String(s).trim();
    }
    
    private static void p(final String s) {
        System.out.println(s);
    }
    
    private void addError(final String messageId, final String arg) {
        String msg;
        if (arg == null) {
            msg = ToolErrorReporter.getMessage(messageId);
        }
        else {
            msg = ToolErrorReporter.getMessage(messageId, arg);
        }
        this.addFormatedError(msg);
    }
    
    private void addFormatedError(final String message) {
        this.reporter.error(message, null, -1, null, -1);
    }
}
