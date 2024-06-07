//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import java.nio.charset.*;
import org.mozilla.javascript.*;
import java.lang.reflect.*;
import java.io.*;

public abstract class ShellConsole
{
    private static final Class[] NO_ARG;
    private static final Class[] BOOLEAN_ARG;
    private static final Class[] STRING_ARG;
    private static final Class[] CHARSEQ_ARG;
    
    protected ShellConsole() {
    }
    
    public abstract InputStream getIn();
    
    public abstract String readLine() throws IOException;
    
    public abstract String readLine(final String p0) throws IOException;
    
    public abstract void flush() throws IOException;
    
    public abstract void print(final String p0) throws IOException;
    
    public abstract void println() throws IOException;
    
    public abstract void println(final String p0) throws IOException;
    
    private static Object tryInvoke(final Object obj, final String method, final Class[] paramTypes, final Object... args) {
        try {
            final Method m = obj.getClass().getDeclaredMethod(method, (Class<?>[])paramTypes);
            if (m != null) {
                return m.invoke(obj, args);
            }
        }
        catch (NoSuchMethodException ex) {}
        catch (IllegalArgumentException ex2) {}
        catch (IllegalAccessException ex3) {}
        catch (InvocationTargetException ex4) {}
        return null;
    }
    
    public static ShellConsole getConsole(final InputStream in, final PrintStream ps, final Charset cs) {
        return new SimpleShellConsole(in, ps, cs);
    }
    
    public static ShellConsole getConsole(final Scriptable scope, final Charset cs) {
        ClassLoader classLoader = ShellConsole.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        if (classLoader == null) {
            return null;
        }
        try {
            Class<?> readerClass = (Class<?>)Kit.classOrNull(classLoader, "jline.console.ConsoleReader");
            if (readerClass != null) {
                return getJLineShellConsoleV2(classLoader, readerClass, scope, cs);
            }
            readerClass = (Class<?>)Kit.classOrNull(classLoader, "jline.ConsoleReader");
            if (readerClass != null) {
                return getJLineShellConsoleV1(classLoader, readerClass, scope, cs);
            }
        }
        catch (NoSuchMethodException ex) {}
        catch (IllegalAccessException ex2) {}
        catch (InstantiationException ex3) {}
        catch (InvocationTargetException ex4) {}
        return null;
    }
    
    private static JLineShellConsoleV1 getJLineShellConsoleV1(final ClassLoader classLoader, final Class<?> readerClass, final Scriptable scope, final Charset cs) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final Constructor<?> c = readerClass.getConstructor((Class<?>[])new Class[0]);
        final Object reader = c.newInstance(new Object[0]);
        tryInvoke(reader, "setBellEnabled", ShellConsole.BOOLEAN_ARG, Boolean.FALSE);
        final Class<?> completorClass = (Class<?>)Kit.classOrNull(classLoader, "jline.Completor");
        final Object completor = Proxy.newProxyInstance(classLoader, new Class[] { completorClass }, (InvocationHandler)new FlexibleCompletor((Class)completorClass, scope));
        tryInvoke(reader, "addCompletor", new Class[] { completorClass }, completor);
        return new JLineShellConsoleV1(reader, cs);
    }
    
    private static JLineShellConsoleV2 getJLineShellConsoleV2(final ClassLoader classLoader, final Class<?> readerClass, final Scriptable scope, final Charset cs) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final Constructor<?> c = readerClass.getConstructor((Class<?>[])new Class[0]);
        final Object reader = c.newInstance(new Object[0]);
        tryInvoke(reader, "setBellEnabled", ShellConsole.BOOLEAN_ARG, Boolean.FALSE);
        final Class<?> completorClass = (Class<?>)Kit.classOrNull(classLoader, "jline.console.completer.Completer");
        final Object completor = Proxy.newProxyInstance(classLoader, new Class[] { completorClass }, (InvocationHandler)new FlexibleCompletor((Class)completorClass, scope));
        tryInvoke(reader, "addCompleter", new Class[] { completorClass }, completor);
        return new JLineShellConsoleV2(reader, cs);
    }
    
    static {
        NO_ARG = new Class[0];
        BOOLEAN_ARG = new Class[] { Boolean.TYPE };
        STRING_ARG = new Class[] { String.class };
        CHARSEQ_ARG = new Class[] { CharSequence.class };
    }
    
    private static class JLineShellConsoleV1 extends ShellConsole
    {
        private final Object reader;
        private final InputStream in;
        
        JLineShellConsoleV1(final Object reader, final Charset cs) {
            this.reader = reader;
            this.in = new ConsoleInputStream(this, cs);
        }
        
        @Override
        public InputStream getIn() {
            return this.in;
        }
        
        @Override
        public String readLine() throws IOException {
            return (String)tryInvoke(this.reader, "readLine", ShellConsole.NO_ARG, new Object[0]);
        }
        
        @Override
        public String readLine(final String prompt) throws IOException {
            return (String)tryInvoke(this.reader, "readLine", ShellConsole.STRING_ARG, prompt);
        }
        
        @Override
        public void flush() throws IOException {
            tryInvoke(this.reader, "flushConsole", ShellConsole.NO_ARG, new Object[0]);
        }
        
        @Override
        public void print(final String s) throws IOException {
            tryInvoke(this.reader, "printString", ShellConsole.STRING_ARG, s);
        }
        
        @Override
        public void println() throws IOException {
            tryInvoke(this.reader, "printNewline", ShellConsole.NO_ARG, new Object[0]);
        }
        
        @Override
        public void println(final String s) throws IOException {
            tryInvoke(this.reader, "printString", ShellConsole.STRING_ARG, s);
            tryInvoke(this.reader, "printNewline", ShellConsole.NO_ARG, new Object[0]);
        }
    }
    
    private static class JLineShellConsoleV2 extends ShellConsole
    {
        private final Object reader;
        private final InputStream in;
        
        JLineShellConsoleV2(final Object reader, final Charset cs) {
            this.reader = reader;
            this.in = new ConsoleInputStream(this, cs);
        }
        
        @Override
        public InputStream getIn() {
            return this.in;
        }
        
        @Override
        public String readLine() throws IOException {
            return (String)tryInvoke(this.reader, "readLine", ShellConsole.NO_ARG, new Object[0]);
        }
        
        @Override
        public String readLine(final String prompt) throws IOException {
            return (String)tryInvoke(this.reader, "readLine", ShellConsole.STRING_ARG, prompt);
        }
        
        @Override
        public void flush() throws IOException {
            tryInvoke(this.reader, "flush", ShellConsole.NO_ARG, new Object[0]);
        }
        
        @Override
        public void print(final String s) throws IOException {
            tryInvoke(this.reader, "print", ShellConsole.CHARSEQ_ARG, s);
        }
        
        @Override
        public void println() throws IOException {
            tryInvoke(this.reader, "println", ShellConsole.NO_ARG, new Object[0]);
        }
        
        @Override
        public void println(final String s) throws IOException {
            tryInvoke(this.reader, "println", ShellConsole.CHARSEQ_ARG, s);
        }
    }
    
    private static class ConsoleInputStream extends InputStream
    {
        private static final byte[] EMPTY;
        private final ShellConsole console;
        private final Charset cs;
        private byte[] buffer;
        private int cursor;
        private boolean atEOF;
        
        public ConsoleInputStream(final ShellConsole console, final Charset cs) {
            this.buffer = ConsoleInputStream.EMPTY;
            this.cursor = -1;
            this.atEOF = false;
            this.console = console;
            this.cs = cs;
        }
        
        @Override
        public synchronized int read(final byte[] b, final int off, final int len) throws IOException {
            if (b == null) {
                throw new NullPointerException();
            }
            if (off < 0 || len < 0 || len > b.length - off) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return 0;
            }
            if (!this.ensureInput()) {
                return -1;
            }
            int n = Math.min(len, this.buffer.length - this.cursor);
            for (int i = 0; i < n; ++i) {
                b[off + i] = this.buffer[this.cursor + i];
            }
            if (n < len) {
                b[off + n++] = 10;
            }
            this.cursor += n;
            return n;
        }
        
        @Override
        public synchronized int read() throws IOException {
            if (!this.ensureInput()) {
                return -1;
            }
            if (this.cursor == this.buffer.length) {
                ++this.cursor;
                return 10;
            }
            return this.buffer[this.cursor++];
        }
        
        private boolean ensureInput() throws IOException {
            if (this.atEOF) {
                return false;
            }
            if (this.cursor < 0 || this.cursor > this.buffer.length) {
                if (this.readNextLine() == -1) {
                    this.atEOF = true;
                    return false;
                }
                this.cursor = 0;
            }
            return true;
        }
        
        private int readNextLine() throws IOException {
            final String line = this.console.readLine(null);
            if (line != null) {
                this.buffer = line.getBytes(this.cs);
                return this.buffer.length;
            }
            this.buffer = ConsoleInputStream.EMPTY;
            return -1;
        }
        
        static {
            EMPTY = new byte[0];
        }
    }
    
    private static class SimpleShellConsole extends ShellConsole
    {
        private final InputStream in;
        private final PrintWriter out;
        private final BufferedReader reader;
        
        SimpleShellConsole(final InputStream in, final PrintStream ps, final Charset cs) {
            this.in = in;
            this.out = new PrintWriter(ps);
            this.reader = new BufferedReader(new InputStreamReader(in, cs));
        }
        
        @Override
        public InputStream getIn() {
            return this.in;
        }
        
        @Override
        public String readLine() throws IOException {
            return this.reader.readLine();
        }
        
        @Override
        public String readLine(final String prompt) throws IOException {
            if (prompt != null) {
                this.out.write(prompt);
                this.out.flush();
            }
            return this.reader.readLine();
        }
        
        @Override
        public void flush() throws IOException {
            this.out.flush();
        }
        
        @Override
        public void print(final String s) throws IOException {
            this.out.print(s);
        }
        
        @Override
        public void println() throws IOException {
            this.out.println();
        }
        
        @Override
        public void println(final String s) throws IOException {
            this.out.println(s);
        }
    }
}
