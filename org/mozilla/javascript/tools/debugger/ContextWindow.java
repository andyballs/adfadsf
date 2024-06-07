//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import org.mozilla.javascript.tools.debugger.treetable.*;

class ContextWindow extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 2306040975490228051L;
    private SwingGui debugGui;
    JComboBox<String> context;
    List<String> toolTips;
    private JTabbedPane tabs;
    private JTabbedPane tabs2;
    private MyTreeTable thisTable;
    private MyTreeTable localsTable;
    private MyTableModel tableModel;
    private Evaluator evaluator;
    private EvalTextArea cmdLine;
    JSplitPane split;
    private boolean enabled;
    
    public ContextWindow(final SwingGui debugGui) {
        this.debugGui = debugGui;
        this.enabled = false;
        final JPanel left = new JPanel();
        final JToolBar t1 = new JToolBar();
        t1.setName("Variables");
        t1.setLayout(new GridLayout());
        t1.add(left);
        final JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout());
        final JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout());
        p1.add(t1);
        final JLabel label = new JLabel("Context:");
        (this.context = new JComboBox<String>()).setLightWeightPopupEnabled(false);
        this.toolTips = Collections.synchronizedList(new ArrayList<String>());
        label.setBorder(this.context.getBorder());
        this.context.addActionListener(this);
        this.context.setActionCommand("ContextSwitch");
        final GridBagLayout layout = new GridBagLayout();
        left.setLayout(layout);
        final GridBagConstraints lc = new GridBagConstraints();
        lc.insets.left = 5;
        lc.anchor = 17;
        lc.ipadx = 5;
        layout.setConstraints(label, lc);
        left.add(label);
        final GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 0;
        c.fill = 2;
        c.anchor = 17;
        layout.setConstraints(this.context, c);
        left.add(this.context);
        (this.tabs = new JTabbedPane(3)).setPreferredSize(new Dimension(500, 300));
        this.thisTable = new MyTreeTable(new VariableModel());
        JScrollPane jsp = new JScrollPane(this.thisTable);
        jsp.getViewport().setViewSize(new Dimension(5, 2));
        this.tabs.add("this", jsp);
        (this.localsTable = new MyTreeTable(new VariableModel())).setAutoResizeMode(4);
        this.localsTable.setPreferredSize(null);
        jsp = new JScrollPane(this.localsTable);
        this.tabs.add("Locals", jsp);
        final GridBagConstraints gridBagConstraints = c;
        final GridBagConstraints gridBagConstraints2 = c;
        final double n = 1.0;
        gridBagConstraints2.weighty = n;
        gridBagConstraints.weightx = n;
        c.gridheight = 0;
        c.fill = 1;
        c.anchor = 17;
        layout.setConstraints(this.tabs, c);
        left.add(this.tabs);
        this.evaluator = new Evaluator(debugGui);
        this.cmdLine = new EvalTextArea(debugGui);
        this.tableModel = this.evaluator.tableModel;
        jsp = new JScrollPane(this.evaluator);
        final JToolBar t2 = new JToolBar();
        t2.setName("Evaluate");
        (this.tabs2 = new JTabbedPane(3)).add("Watch", jsp);
        this.tabs2.add("Evaluate", new JScrollPane(this.cmdLine));
        this.tabs2.setPreferredSize(new Dimension(500, 300));
        t2.setLayout(new GridLayout());
        t2.add(this.tabs2);
        p2.add(t2);
        this.evaluator.setAutoResizeMode(4);
        (this.split = new JSplitPane(1, p1, p2)).setOneTouchExpandable(true);
        SwingGui.setResizeWeight(this.split, 0.5);
        this.setLayout(new BorderLayout());
        this.add(this.split, "Center");
        final JToolBar finalT1 = t1;
        final JToolBar finalT2 = t2;
        final JPanel finalP1 = p1;
        final JPanel finalP2 = p2;
        final JSplitPane finalSplit = this.split;
        final JPanel finalThis = this;
        final ComponentListener clistener = new ComponentListener() {
            boolean t2Docked = true;
            
            void check(final Component comp) {
                final Component thisParent = finalThis.getParent();
                if (thisParent == null) {
                    return;
                }
                Component parent = finalT1.getParent();
                boolean leftDocked = true;
                boolean rightDocked = true;
                final boolean adjustVerticalSplit = false;
                if (parent != null) {
                    if (parent != finalP1) {
                        while (!(parent instanceof JFrame)) {
                            parent = parent.getParent();
                        }
                        final JFrame frame = (JFrame)parent;
                        debugGui.addTopLevel("Variables", frame);
                        if (!frame.isResizable()) {
                            frame.setResizable(true);
                            frame.setDefaultCloseOperation(0);
                            final WindowListener[] l = frame.getListeners(WindowListener.class);
                            frame.removeWindowListener(l[0]);
                            frame.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosing(final WindowEvent e) {
                                    ContextWindow.this.context.hidePopup();
                                    l[0].windowClosing(e);
                                }
                            });
                        }
                        leftDocked = false;
                    }
                    else {
                        leftDocked = true;
                    }
                }
                parent = finalT2.getParent();
                if (parent != null) {
                    if (parent != finalP2) {
                        while (!(parent instanceof JFrame)) {
                            parent = parent.getParent();
                        }
                        final JFrame frame = (JFrame)parent;
                        debugGui.addTopLevel("Evaluate", frame);
                        frame.setResizable(true);
                        rightDocked = false;
                    }
                    else {
                        rightDocked = true;
                    }
                }
                if (leftDocked && this.t2Docked && rightDocked && this.t2Docked) {
                    return;
                }
                this.t2Docked = rightDocked;
                final JSplitPane split = (JSplitPane)thisParent;
                if (leftDocked) {
                    if (rightDocked) {
                        finalSplit.setDividerLocation(0.5);
                    }
                    else {
                        finalSplit.setDividerLocation(1.0);
                    }
                    if (adjustVerticalSplit) {
                        split.setDividerLocation(0.66);
                    }
                }
                else if (rightDocked) {
                    finalSplit.setDividerLocation(0.0);
                    split.setDividerLocation(0.66);
                }
                else {
                    split.setDividerLocation(1.0);
                }
            }
            
            @Override
            public void componentHidden(final ComponentEvent e) {
                this.check(e.getComponent());
            }
            
            @Override
            public void componentMoved(final ComponentEvent e) {
                this.check(e.getComponent());
            }
            
            @Override
            public void componentResized(final ComponentEvent e) {
                this.check(e.getComponent());
            }
            
            @Override
            public void componentShown(final ComponentEvent e) {
                this.check(e.getComponent());
            }
        };
        p1.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(final ContainerEvent e) {
                final Component thisParent = finalThis.getParent();
                final JSplitPane split = (JSplitPane)thisParent;
                if (e.getChild() == finalT1) {
                    if (finalT2.getParent() == finalP2) {
                        finalSplit.setDividerLocation(0.5);
                    }
                    else {
                        finalSplit.setDividerLocation(1.0);
                    }
                    split.setDividerLocation(0.66);
                }
            }
            
            @Override
            public void componentRemoved(final ContainerEvent e) {
                final Component thisParent = finalThis.getParent();
                final JSplitPane split = (JSplitPane)thisParent;
                if (e.getChild() == finalT1) {
                    if (finalT2.getParent() == finalP2) {
                        finalSplit.setDividerLocation(0.0);
                        split.setDividerLocation(0.66);
                    }
                    else {
                        split.setDividerLocation(1.0);
                    }
                }
            }
        });
        t1.addComponentListener(clistener);
        t2.addComponentListener(clistener);
        this.setEnabled(false);
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        this.context.setEnabled(enabled);
        this.thisTable.setEnabled(enabled);
        this.localsTable.setEnabled(enabled);
        this.evaluator.setEnabled(enabled);
        this.cmdLine.setEnabled(enabled);
    }
    
    public void disableUpdate() {
        this.enabled = false;
    }
    
    public void enableUpdate() {
        this.enabled = true;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (!this.enabled) {
            return;
        }
        if (e.getActionCommand().equals("ContextSwitch")) {
            final Dim.ContextData contextData = this.debugGui.dim.currentContextData();
            if (contextData == null) {
                return;
            }
            final int frameIndex = this.context.getSelectedIndex();
            this.context.setToolTipText(this.toolTips.get(frameIndex));
            final int frameCount = contextData.frameCount();
            if (frameIndex >= frameCount) {
                return;
            }
            final Dim.StackFrame frame = contextData.getFrame(frameIndex);
            final Object scope = frame.scope();
            final Object thisObj = frame.thisObj();
            this.thisTable.resetTree(new VariableModel(this.debugGui.dim, thisObj));
            VariableModel scopeModel;
            if (scope != thisObj) {
                scopeModel = new VariableModel(this.debugGui.dim, scope);
            }
            else {
                scopeModel = new VariableModel();
            }
            this.localsTable.resetTree(scopeModel);
            this.debugGui.dim.contextSwitch(frameIndex);
            this.debugGui.showStopLine(frame);
            this.tableModel.updateModel();
        }
    }
}
