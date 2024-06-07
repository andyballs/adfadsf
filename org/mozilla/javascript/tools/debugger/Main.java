//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.*;
import java.io.*;
import org.mozilla.javascript.tools.shell.*;
import java.awt.*;
import org.mozilla.javascript.*;

public class Main
{
    private Dim dim;
    private SwingGui debugGui;
    
    public Main(final String title) {
        this.dim = new Dim();
        this.debugGui = new SwingGui(this.dim, title);
    }
    
    public JFrame getDebugFrame() {
        return this.debugGui;
    }
    
    public void doBreak() {
        this.dim.setBreak();
    }
    
    public void setBreakOnExceptions(final boolean value) {
        this.dim.setBreakOnExceptions(value);
        this.debugGui.getMenubar().getBreakOnExceptions().setSelected(value);
    }
    
    public void setBreakOnEnter(final boolean value) {
        this.dim.setBreakOnEnter(value);
        this.debugGui.getMenubar().getBreakOnEnter().setSelected(value);
    }
    
    public void setBreakOnReturn(final boolean value) {
        this.dim.setBreakOnReturn(value);
        this.debugGui.getMenubar().getBreakOnReturn().setSelected(value);
    }
    
    public void clearAllBreakpoints() {
        this.dim.clearAllBreakpoints();
    }
    
    public void go() {
        this.dim.go();
    }
    
    public void setScope(final Scriptable scope) {
        this.setScopeProvider(IProxy.newScopeProvider(scope));
    }
    
    public void setScopeProvider(final ScopeProvider p) {
        this.dim.setScopeProvider(p);
    }
    
    public void setSourceProvider(final SourceProvider sourceProvider) {
        this.dim.setSourceProvider(sourceProvider);
    }
    
    public void setExitAction(final Runnable r) {
        this.debugGui.setExitAction(r);
    }
    
    public InputStream getIn() {
        return this.debugGui.getConsole().getIn();
    }
    
    public PrintStream getOut() {
        return this.debugGui.getConsole().getOut();
    }
    
    public PrintStream getErr() {
        return this.debugGui.getConsole().getErr();
    }
    
    public void pack() {
        this.debugGui.pack();
    }
    
    public void setSize(final int w, final int h) {
        this.debugGui.setSize(w, h);
    }
    
    public void setVisible(final boolean flag) {
        this.debugGui.setVisible(flag);
    }
    
    public boolean isVisible() {
        return this.debugGui.isVisible();
    }
    
    public void dispose() {
        this.clearAllBreakpoints();
        this.dim.go();
        this.debugGui.dispose();
        this.dim = null;
    }
    
    public void attachTo(final ContextFactory factory) {
        this.dim.attachTo(factory);
    }
    
    public void detach() {
        this.dim.detach();
    }
    
    public static void main(final String[] args) {
        final Main main = new Main("Rhino JavaScript Debugger");
        main.doBreak();
        main.setExitAction(new IProxy(1));
        System.setIn(main.getIn());
        System.setOut(main.getOut());
        System.setErr(main.getErr());
        final Global global = org.mozilla.javascript.tools.shell.Main.getGlobal();
        global.setIn(main.getIn());
        global.setOut(main.getOut());
        global.setErr(main.getErr());
        main.attachTo(org.mozilla.javascript.tools.shell.Main.shellContextFactory);
        main.setScope((Scriptable)global);
        main.pack();
        main.setSize(600, 460);
        main.setVisible(true);
        org.mozilla.javascript.tools.shell.Main.exec(args);
    }
    
    public static Main mainEmbedded(final String title) {
        final ContextFactory factory = ContextFactory.getGlobal();
        final Global global = new Global();
        global.init(factory);
        return mainEmbedded(factory, (Scriptable)global, title);
    }
    
    public static Main mainEmbedded(final ContextFactory factory, final Scriptable scope, final String title) {
        return mainEmbeddedImpl(factory, scope, title);
    }
    
    public static Main mainEmbedded(final ContextFactory factory, final ScopeProvider scopeProvider, final String title) {
        return mainEmbeddedImpl(factory, scopeProvider, title);
    }
    
    private static Main mainEmbeddedImpl(final ContextFactory factory, final Object scopeProvider, String title) {
        if (title == null) {
            title = "Rhino JavaScript Debugger (embedded usage)";
        }
        final Main main = new Main(title);
        main.doBreak();
        main.setExitAction(new IProxy(1));
        main.attachTo(factory);
        if (scopeProvider instanceof ScopeProvider) {
            main.setScopeProvider((ScopeProvider)scopeProvider);
        }
        else {
            final Scriptable scope = (Scriptable)scopeProvider;
            if (scope instanceof Global) {
                final Global global = (Global)scope;
                global.setIn(main.getIn());
                global.setOut(main.getOut());
                global.setErr(main.getErr());
            }
            main.setScope(scope);
        }
        main.pack();
        main.setSize(600, 460);
        main.setVisible(true);
        return main;
    }
    
    @Deprecated
    public void setSize(final Dimension dimension) {
        this.debugGui.setSize(dimension.width, dimension.height);
    }
    
    @Deprecated
    public void setOptimizationLevel(final int level) {
    }
    
    @Deprecated
    public void contextEntered(final Context cx) {
        throw new IllegalStateException();
    }
    
    @Deprecated
    public void contextExited(final Context cx) {
        throw new IllegalStateException();
    }
    
    @Deprecated
    public void contextCreated(final Context cx) {
        throw new IllegalStateException();
    }
    
    @Deprecated
    public void contextReleased(final Context cx) {
        throw new IllegalStateException();
    }
    
    private static class IProxy implements Runnable, ScopeProvider
    {
        public static final int EXIT_ACTION = 1;
        public static final int SCOPE_PROVIDER = 2;
        private final int type;
        private Scriptable scope;
        
        public IProxy(final int type) {
            this.type = type;
        }
        
        public static ScopeProvider newScopeProvider(final Scriptable scope) {
            final IProxy scopeProvider = new IProxy(2);
            scopeProvider.scope = scope;
            return scopeProvider;
        }
        
        @Override
        public void run() {
            if (this.type != 1) {
                Kit.codeBug();
            }
            System.exit(0);
        }
        
        @Override
        public Scriptable getScope() {
            if (this.type != 2) {
                Kit.codeBug();
            }
            if (this.scope == null) {
                Kit.codeBug();
            }
            return this.scope;
        }
    }
}
