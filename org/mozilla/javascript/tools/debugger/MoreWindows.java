//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.debugger;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class MoreWindows extends JDialog implements ActionListener
{
    private static final long serialVersionUID = 5177066296457377546L;
    private String value;
    private JList<String> list;
    private SwingGui swingGui;
    private JButton setButton;
    private JButton cancelButton;
    
    MoreWindows(final SwingGui frame, final Map<String, FileWindow> fileWindows, final String title, final String labelText) {
        super(frame, title, true);
        this.swingGui = frame;
        this.cancelButton = new JButton("Cancel");
        this.setButton = new JButton("Select");
        this.cancelButton.addActionListener(this);
        this.setButton.addActionListener(this);
        this.getRootPane().setDefaultButton(this.setButton);
        this.list = new JList<String>(new DefaultListModel<String>());
        final DefaultListModel<String> model = (DefaultListModel<String>)(DefaultListModel)this.list.getModel();
        model.clear();
        for (final String data : fileWindows.keySet()) {
            model.addElement(data);
        }
        this.list.setSelectedIndex(0);
        this.setButton.setEnabled(true);
        this.list.setSelectionMode(1);
        this.list.addMouseListener(new MouseHandler());
        final JScrollPane listScroller = new JScrollPane(this.list);
        listScroller.setPreferredSize(new Dimension(320, 240));
        listScroller.setMinimumSize(new Dimension(250, 80));
        listScroller.setAlignmentX(0.0f);
        final JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, 1));
        final JLabel label = new JLabel(labelText);
        label.setLabelFor(this.list);
        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0, 5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        final JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, 0));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(this.cancelButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(this.setButton);
        final Container contentPane = this.getContentPane();
        contentPane.add(listPane, "Center");
        contentPane.add(buttonPane, "South");
        this.pack();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent ke) {
                final int code = ke.getKeyCode();
                if (code == 27) {
                    ke.consume();
                    MoreWindows.this.value = null;
                    MoreWindows.this.setVisible(false);
                }
            }
        });
    }
    
    public String showDialog(final Component comp) {
        this.value = null;
        this.setLocationRelativeTo(comp);
        this.setVisible(true);
        return this.value;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final String cmd = e.getActionCommand();
        if (cmd.equals("Cancel")) {
            this.setVisible(false);
            this.value = null;
        }
        else if (cmd.equals("Select")) {
            this.value = this.list.getSelectedValue();
            this.setVisible(false);
            this.swingGui.showFileWindow(this.value, -1);
        }
    }
    
    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(final MouseEvent e) {
            if (e.getClickCount() == 2) {
                MoreWindows.this.setButton.doClick();
            }
        }
    }
}
