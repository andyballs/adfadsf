//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import javax.swing.filechooser.*;
import javax.swing.text.*;
import java.util.*;
import java.lang.reflect.*;
import org.mozilla.javascript.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingGui extends JFrame implements GuiCallback
{
    private static final long serialVersionUID = -8217029773456711621L;
    Dim dim;
    private Runnable exitAction;
    private JDesktopPane desk;
    private ContextWindow context;
    private Menubar menubar;
    private JToolBar toolBar;
    private JSInternalConsole console;
    private JSplitPane split1;
    private JLabel statusBar;
    private final Map<String, JFrame> toplevels;
    private final Map<String, FileWindow> fileWindows;
    private FileWindow currentWindow;
    JFileChooser dlg;
    private EventQueue awtEventQueue;
    
    public SwingGui(final Dim dim, final String title) {
        super(title);
        this.toplevels = Collections.synchronizedMap(new HashMap<String, JFrame>());
        this.fileWindows = Collections.synchronizedMap(new TreeMap<String, FileWindow>());
        this.dim = dim;
        this.init();
        dim.setGuiCallback((GuiCallback)this);
    }
    
    public Menubar getMenubar() {
        return this.menubar;
    }
    
    public void setExitAction(final Runnable r) {
        this.exitAction = r;
    }
    
    public JSInternalConsole getConsole() {
        return this.console;
    }
    
    public void setVisible(final boolean b) {
        super.setVisible(b);
        if (b) {
            this.console.consoleTextArea.requestFocus();
            this.context.split.setDividerLocation(0.5);
            try {
                this.console.setMaximum(true);
                this.console.setSelected(true);
                this.console.show();
                this.console.consoleTextArea.requestFocus();
            }
            catch (Exception ex) {}
        }
    }
    
    void addTopLevel(final String key, final JFrame frame) {
        if (frame != this) {
            this.toplevels.put(key, frame);
        }
    }
    
    private void init() {
        this.setJMenuBar((JMenuBar)(this.menubar = new Menubar(this)));
        this.toolBar = new JToolBar();
        final String[] toolTips = { "Break (Pause)", "Go (F5)", "Step Into (F11)", "Step Over (F7)", "Step Out (F8)" };
        int count = 0;
        JButton button;
        final JButton breakButton = button = new JButton("Break");
        button.setToolTipText("Break");
        button.setActionCommand("Break");
        button.addActionListener((ActionListener)this.menubar);
        button.setEnabled(true);
        button.setToolTipText(toolTips[count++]);
        final JButton goButton = button = new JButton("Go");
        button.setToolTipText("Go");
        button.setActionCommand("Go");
        button.addActionListener((ActionListener)this.menubar);
        button.setEnabled(false);
        button.setToolTipText(toolTips[count++]);
        final JButton stepIntoButton = button = new JButton("Step Into");
        button.setToolTipText("Step Into");
        button.setActionCommand("Step Into");
        button.addActionListener((ActionListener)this.menubar);
        button.setEnabled(false);
        button.setToolTipText(toolTips[count++]);
        final JButton stepOverButton = button = new JButton("Step Over");
        button.setToolTipText("Step Over");
        button.setActionCommand("Step Over");
        button.setEnabled(false);
        button.addActionListener((ActionListener)this.menubar);
        button.setToolTipText(toolTips[count++]);
        final JButton stepOutButton = button = new JButton("Step Out");
        button.setToolTipText("Step Out");
        button.setActionCommand("Step Out");
        button.setEnabled(false);
        button.addActionListener((ActionListener)this.menubar);
        button.setToolTipText(toolTips[count++]);
        final Dimension dim = stepOverButton.getPreferredSize();
        breakButton.setPreferredSize(dim);
        breakButton.setMinimumSize(dim);
        breakButton.setMaximumSize(dim);
        breakButton.setSize(dim);
        goButton.setPreferredSize(dim);
        goButton.setMinimumSize(dim);
        goButton.setMaximumSize(dim);
        stepIntoButton.setPreferredSize(dim);
        stepIntoButton.setMinimumSize(dim);
        stepIntoButton.setMaximumSize(dim);
        stepOverButton.setPreferredSize(dim);
        stepOverButton.setMinimumSize(dim);
        stepOverButton.setMaximumSize(dim);
        stepOutButton.setPreferredSize(dim);
        stepOutButton.setMinimumSize(dim);
        stepOutButton.setMaximumSize(dim);
        this.toolBar.add(breakButton);
        this.toolBar.add(goButton);
        this.toolBar.add(stepIntoButton);
        this.toolBar.add(stepOverButton);
        this.toolBar.add(stepOutButton);
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        this.getContentPane().add(this.toolBar, "North");
        this.getContentPane().add(contentPane, "Center");
        (this.desk = new JDesktopPane()).setPreferredSize(new Dimension(600, 300));
        this.desk.setMinimumSize(new Dimension(150, 50));
        this.desk.add((Component)(this.console = new JSInternalConsole("JavaScript Console")));
        (this.context = new ContextWindow(this)).setPreferredSize(new Dimension(600, 120));
        this.context.setMinimumSize(new Dimension(50, 50));
        (this.split1 = new JSplitPane(0, this.desk, (Component)this.context)).setOneTouchExpandable(true);
        setResizeWeight(this.split1, 0.66);
        contentPane.add(this.split1, "Center");
        (this.statusBar = new JLabel()).setText("Thread: ");
        contentPane.add(this.statusBar, "South");
        this.dlg = new JFileChooser();
        final FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(final File f) {
                if (f.isDirectory()) {
                    return true;
                }
                final String n = f.getName();
                final int i = n.lastIndexOf(46);
                if (i > 0 && i < n.length() - 1) {
                    final String ext = n.substring(i + 1).toLowerCase();
                    if (ext.equals("js")) {
                        return true;
                    }
                }
                return false;
            }
            
            @Override
            public String getDescription() {
                return "JavaScript Files (*.js)";
            }
        };
        this.dlg.addChoosableFileFilter(filter);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                SwingGui.this.exit();
            }
        });
    }
    
    private void exit() {
        if (this.exitAction != null) {
            SwingUtilities.invokeLater(this.exitAction);
        }
        this.dim.setReturnValue(5);
    }
    
    FileWindow getFileWindow(final String url) {
        if (url == null || url.equals("<stdin>")) {
            return null;
        }
        return this.fileWindows.get(url);
    }
    
    static String getShortName(final String url) {
        int lastSlash = url.lastIndexOf(47);
        if (lastSlash < 0) {
            lastSlash = url.lastIndexOf(92);
        }
        String shortName = url;
        if (lastSlash >= 0 && lastSlash + 1 < url.length()) {
            shortName = url.substring(lastSlash + 1);
        }
        return shortName;
    }
    
    void removeWindow(final FileWindow w) {
        this.fileWindows.remove(w.getUrl());
        final JMenu windowMenu = this.getWindowMenu();
        final int count = windowMenu.getItemCount();
        final JMenuItem lastItem = windowMenu.getItem(count - 1);
        final String name = getShortName(w.getUrl());
        for (int i = 5; i < count; ++i) {
            final JMenuItem item = windowMenu.getItem(i);
            if (item != null) {
                String text = item.getText();
                int pos = text.indexOf(32);
                if (text.substring(pos + 1).equals(name)) {
                    windowMenu.remove(item);
                    if (count == 6) {
                        windowMenu.remove(4);
                        break;
                    }
                    int j = i - 4;
                    while (i < count - 1) {
                        final JMenuItem thisItem = windowMenu.getItem(i);
                        if (thisItem != null) {
                            text = thisItem.getText();
                            if (text.equals("More Windows...")) {
                                break;
                            }
                            pos = text.indexOf(32);
                            thisItem.setText((char)(48 + j) + " " + text.substring(pos + 1));
                            thisItem.setMnemonic(48 + j);
                            ++j;
                        }
                        ++i;
                    }
                    if (count - 6 == 0 && lastItem != item && lastItem.getText().equals("More Windows...")) {
                        windowMenu.remove(lastItem);
                    }
                    break;
                }
            }
        }
        windowMenu.revalidate();
    }
    
    void showStopLine(final Dim.StackFrame frame) {
        final String sourceName = frame.getUrl();
        if (sourceName == null || sourceName.equals("<stdin>")) {
            if (this.console.isVisible()) {
                this.console.show();
            }
        }
        else {
            this.showFileWindow(sourceName, -1);
            final int lineNumber = frame.getLineNumber();
            final FileWindow w = this.getFileWindow(sourceName);
            if (w != null) {
                this.setFilePosition(w, lineNumber);
            }
        }
    }
    
    protected void showFileWindow(final String sourceUrl, final int lineNumber) {
        FileWindow w;
        if (sourceUrl != null) {
            w = this.getFileWindow(sourceUrl);
        }
        else {
            final JInternalFrame f = this.getSelectedFrame();
            if (f != null && f instanceof FileWindow) {
                w = (FileWindow)f;
            }
            else {
                w = this.currentWindow;
            }
        }
        if (w == null && sourceUrl != null) {
            final Dim.SourceInfo si = this.dim.sourceInfo(sourceUrl);
            this.createFileWindow(si, -1);
            w = this.getFileWindow(sourceUrl);
        }
        if (w == null) {
            return;
        }
        if (lineNumber > -1) {
            final int start = w.getPosition(lineNumber - 1);
            final int end = w.getPosition(lineNumber) - 1;
            if (start <= 0) {
                return;
            }
            w.textArea.select(start);
            w.textArea.setCaretPosition(start);
            w.textArea.moveCaretPosition(end);
        }
        try {
            if (w.isIcon()) {
                w.setIcon(false);
            }
            w.setVisible(true);
            w.moveToFront();
            w.setSelected(true);
            this.requestFocus();
            w.requestFocus();
            w.textArea.requestFocus();
        }
        catch (Exception ex) {}
    }
    
    protected void createFileWindow(final Dim.SourceInfo sourceInfo, final int line) {
        final boolean activate = true;
        final String url = sourceInfo.url();
        final FileWindow w = new FileWindow(this, sourceInfo);
        this.fileWindows.put(url, w);
        if (line != -1) {
            if (this.currentWindow != null) {
                this.currentWindow.setPosition(-1);
            }
            try {
                w.setPosition(w.textArea.getLineStartOffset(line - 1));
            }
            catch (BadLocationException exc) {
                try {
                    w.setPosition(w.textArea.getLineStartOffset(0));
                }
                catch (BadLocationException ee) {
                    w.setPosition(-1);
                }
            }
        }
        this.desk.add((Component)w);
        if (line != -1) {
            this.currentWindow = w;
        }
        this.menubar.addFile(url);
        w.setVisible(true);
        if (activate) {
            try {
                w.setMaximum(true);
                w.setSelected(true);
                w.moveToFront();
            }
            catch (Exception ex) {}
        }
    }
    
    protected boolean updateFileWindow(final Dim.SourceInfo sourceInfo) {
        final String fileName = sourceInfo.url();
        final FileWindow w = this.getFileWindow(fileName);
        if (w != null) {
            w.updateText(sourceInfo);
            w.show();
            return true;
        }
        return false;
    }
    
    private void setFilePosition(final FileWindow w, final int line) {
        final boolean activate = true;
        final JTextArea ta = (JTextArea)w.textArea;
        try {
            if (line == -1) {
                w.setPosition(-1);
                if (this.currentWindow == w) {
                    this.currentWindow = null;
                }
            }
            else {
                final int loc = ta.getLineStartOffset(line - 1);
                if (this.currentWindow != null && this.currentWindow != w) {
                    this.currentWindow.setPosition(-1);
                }
                w.setPosition(loc);
                this.currentWindow = w;
            }
        }
        catch (BadLocationException ex) {}
        if (activate) {
            if (w.isIcon()) {
                this.desk.getDesktopManager().deiconifyFrame((JInternalFrame)w);
            }
            this.desk.getDesktopManager().activateFrame((JInternalFrame)w);
            try {
                w.show();
                w.toFront();
                w.setSelected(true);
            }
            catch (Exception ex2) {}
        }
    }
    
    void enterInterruptImpl(final Dim.StackFrame lastFrame, final String threadTitle, final String alertMessage) {
        this.statusBar.setText("Thread: " + threadTitle);
        this.showStopLine(lastFrame);
        if (alertMessage != null) {
            MessageDialogWrapper.showMessageDialog((Component)this, alertMessage, "Exception in Script", 0);
        }
        this.updateEnabled(true);
        final Dim.ContextData contextData = lastFrame.contextData();
        final JComboBox<String> ctx = (JComboBox<String>)this.context.context;
        final List<String> toolTips = (List<String>)this.context.toolTips;
        this.context.disableUpdate();
        final int frameCount = contextData.frameCount();
        ctx.removeAllItems();
        ctx.setSelectedItem(null);
        toolTips.clear();
        for (int i = 0; i < frameCount; ++i) {
            final Dim.StackFrame frame = contextData.getFrame(i);
            final String url = frame.getUrl();
            final int lineNumber = frame.getLineNumber();
            String shortName = url;
            if (url.length() > 20) {
                shortName = "..." + url.substring(url.length() - 17);
            }
            String location = "\"" + shortName + "\", line " + lineNumber;
            ctx.insertItemAt(location, i);
            location = "\"" + url + "\", line " + lineNumber;
            toolTips.add(location);
        }
        this.context.enableUpdate();
        ctx.setSelectedIndex(0);
        ctx.setMinimumSize(new Dimension(50, ctx.getMinimumSize().height));
    }
    
    private JMenu getWindowMenu() {
        return this.menubar.getMenu(3);
    }
    
    private String chooseFile(final String title) {
        this.dlg.setDialogTitle(title);
        File CWD = null;
        final String dir = SecurityUtilities.getSystemProperty("user.dir");
        if (dir != null) {
            CWD = new File(dir);
        }
        if (CWD != null) {
            this.dlg.setCurrentDirectory(CWD);
        }
        final int returnVal = this.dlg.showOpenDialog(this);
        if (returnVal == 0) {
            try {
                final String result = this.dlg.getSelectedFile().getCanonicalPath();
                CWD = this.dlg.getSelectedFile().getParentFile();
                final Properties props = System.getProperties();
                props.put("user.dir", CWD.getPath());
                System.setProperties(props);
                return result;
            }
            catch (IOException ex) {}
            catch (SecurityException ex2) {}
        }
        return null;
    }
    
    private JInternalFrame getSelectedFrame() {
        final JInternalFrame[] frames = this.desk.getAllFrames();
        for (int i = 0; i < frames.length; ++i) {
            if (frames[i].isShowing()) {
                return frames[i];
            }
        }
        return frames[frames.length - 1];
    }
    
    private void updateEnabled(final boolean interrupted) {
        ((Menubar)this.getJMenuBar()).updateEnabled(interrupted);
        for (int ci = 0, cc = this.toolBar.getComponentCount(); ci < cc; ++ci) {
            boolean enableButton;
            if (ci == 0) {
                enableButton = !interrupted;
            }
            else {
                enableButton = interrupted;
            }
            this.toolBar.getComponent(ci).setEnabled(enableButton);
        }
        if (interrupted) {
            this.toolBar.setEnabled(true);
            final int state = this.getExtendedState();
            if (state == 1) {
                this.setExtendedState(0);
            }
            this.toFront();
            this.context.setEnabled(true);
        }
        else {
            if (this.currentWindow != null) {
                this.currentWindow.setPosition(-1);
            }
            this.context.setEnabled(false);
        }
    }
    
    static void setResizeWeight(final JSplitPane pane, final double weight) {
        try {
            final Method m = JSplitPane.class.getMethod("setResizeWeight", Double.TYPE);
            m.invoke(pane, new Double(weight));
        }
        catch (NoSuchMethodException ex) {}
        catch (IllegalAccessException ex2) {}
        catch (InvocationTargetException ex3) {}
    }
    
    private String readFile(final String fileName) {
        String text;
        try (final Reader r = new FileReader(fileName)) {
            text = Kit.readReader(r);
        }
        catch (IOException ex) {
            MessageDialogWrapper.showMessageDialog((Component)this, ex.getMessage(), "Error reading " + fileName, 0);
            text = null;
        }
        return text;
    }
    
    public void updateSourceText(final Dim.SourceInfo sourceInfo) {
        final RunProxy proxy = new RunProxy(this, 3);
        proxy.sourceInfo = sourceInfo;
        SwingUtilities.invokeLater((Runnable)proxy);
    }
    
    public void enterInterrupt(final Dim.StackFrame lastFrame, final String threadTitle, final String alertMessage) {
        if (SwingUtilities.isEventDispatchThread()) {
            this.enterInterruptImpl(lastFrame, threadTitle, alertMessage);
        }
        else {
            final RunProxy proxy = new RunProxy(this, 4);
            proxy.lastFrame = lastFrame;
            proxy.threadTitle = threadTitle;
            proxy.alertMessage = alertMessage;
            SwingUtilities.invokeLater((Runnable)proxy);
        }
    }
    
    public boolean isGuiEventThread() {
        return SwingUtilities.isEventDispatchThread();
    }
    
    public void dispatchNextGuiEvent() throws InterruptedException {
        EventQueue queue = this.awtEventQueue;
        if (queue == null) {
            queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
            this.awtEventQueue = queue;
        }
        final AWTEvent event = queue.getNextEvent();
        if (event instanceof ActiveEvent) {
            ((ActiveEvent)event).dispatch();
        }
        else {
            final Object source = event.getSource();
            if (source instanceof Component) {
                final Component comp = (Component)source;
                comp.dispatchEvent(event);
            }
            else if (source instanceof MenuComponent) {
                ((MenuComponent)source).dispatchEvent(event);
            }
        }
    }
    
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        int returnValue = -1;
        if (cmd.equals("Cut") || cmd.equals("Copy") || cmd.equals("Paste")) {
            final JInternalFrame f = this.getSelectedFrame();
            if (f != null && f instanceof ActionListener) {
                ((ActionListener)f).actionPerformed(e);
            }
        }
        else if (cmd.equals("Step Over")) {
            returnValue = 0;
        }
        else if (cmd.equals("Step Into")) {
            returnValue = 1;
        }
        else if (cmd.equals("Step Out")) {
            returnValue = 2;
        }
        else if (cmd.equals("Go")) {
            returnValue = 3;
        }
        else if (cmd.equals("Break")) {
            this.dim.setBreak();
        }
        else if (cmd.equals("Exit")) {
            this.exit();
        }
        else if (cmd.equals("Open")) {
            final String fileName = this.chooseFile("Select a file to compile");
            if (fileName != null) {
                final String text = this.readFile(fileName);
                if (text != null) {
                    final RunProxy proxy = new RunProxy(this, 1);
                    proxy.fileName = fileName;
                    proxy.text = text;
                    new Thread((Runnable)proxy).start();
                }
            }
        }
        else if (cmd.equals("Load")) {
            final String fileName = this.chooseFile("Select a file to execute");
            if (fileName != null) {
                final String text = this.readFile(fileName);
                if (text != null) {
                    final RunProxy proxy = new RunProxy(this, 2);
                    proxy.fileName = fileName;
                    proxy.text = text;
                    new Thread((Runnable)proxy).start();
                }
            }
        }
        else if (cmd.equals("More Windows...")) {
            final MoreWindows dlg = new MoreWindows(this, (Map)this.fileWindows, "Window", "Files");
            dlg.showDialog((Component)this);
        }
        else if (cmd.equals("Console")) {
            if (this.console.isIcon()) {
                this.desk.getDesktopManager().deiconifyFrame((JInternalFrame)this.console);
            }
            this.console.show();
            this.desk.getDesktopManager().activateFrame((JInternalFrame)this.console);
            this.console.consoleTextArea.requestFocus();
        }
        else if (!cmd.equals("Cut")) {
            if (!cmd.equals("Copy")) {
                if (!cmd.equals("Paste")) {
                    if (cmd.equals("Go to function...")) {
                        final FindFunction dlg2 = new FindFunction(this, "Go to function", "Function");
                        dlg2.showDialog((Component)this);
                    }
                    else if (cmd.equals("Go to line...")) {
                        final String s = (String)JOptionPane.showInputDialog(this, "Line number", "Go to line...", 3, null, null, null);
                        if (s == null || s.trim().length() == 0) {
                            return;
                        }
                        try {
                            final int line = Integer.parseInt(s);
                            this.showFileWindow(null, line);
                        }
                        catch (NumberFormatException ex) {}
                    }
                    else if (cmd.equals("Tile")) {
                        final JInternalFrame[] frames = this.desk.getAllFrames();
                        final int count = frames.length;
                        int rows;
                        int cols = rows = (int)Math.sqrt(count);
                        if (rows * cols < count) {
                            ++cols;
                            if (rows * cols < count) {
                                ++rows;
                            }
                        }
                        final Dimension size = this.desk.getSize();
                        final int w = size.width / cols;
                        final int h = size.height / rows;
                        int x = 0;
                        int y = 0;
                        for (int i = 0; i < rows; ++i) {
                            for (int j = 0; j < cols; ++j) {
                                final int index = i * cols + j;
                                if (index >= frames.length) {
                                    break;
                                }
                                final JInternalFrame f2 = frames[index];
                                try {
                                    f2.setIcon(false);
                                    f2.setMaximum(false);
                                }
                                catch (Exception ex2) {}
                                this.desk.getDesktopManager().setBoundsForFrame(f2, x, y, w, h);
                                x += w;
                            }
                            y += h;
                            x = 0;
                        }
                    }
                    else if (cmd.equals("Cascade")) {
                        final JInternalFrame[] frames = this.desk.getAllFrames();
                        final int count = frames.length;
                        int x2;
                        int y2 = x2 = 0;
                        int h2 = this.desk.getHeight();
                        int d = h2 / count;
                        if (d > 30) {
                            d = 30;
                        }
                        for (int k = count - 1; k >= 0; --k, x2 += d, y2 += d) {
                            final JInternalFrame f3 = frames[k];
                            try {
                                f3.setIcon(false);
                                f3.setMaximum(false);
                            }
                            catch (Exception ex3) {}
                            final Dimension dimen = f3.getPreferredSize();
                            final int w2 = dimen.width;
                            h2 = dimen.height;
                            this.desk.getDesktopManager().setBoundsForFrame(f3, x2, y2, w2, h2);
                        }
                    }
                    else {
                        final Object obj = this.getFileWindow(cmd);
                        if (obj != null) {
                            final FileWindow w3 = (FileWindow)obj;
                            try {
                                if (w3.isIcon()) {
                                    w3.setIcon(false);
                                }
                                w3.setVisible(true);
                                w3.moveToFront();
                                w3.setSelected(true);
                            }
                            catch (Exception ex4) {}
                        }
                    }
                }
            }
        }
        if (returnValue != -1) {
            this.updateEnabled(false);
            this.dim.setReturnValue(returnValue);
        }
    }
}
