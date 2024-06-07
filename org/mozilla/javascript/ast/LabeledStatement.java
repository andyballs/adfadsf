//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class LabeledStatement extends AstNode
{
    private List<Label> labels;
    private AstNode statement;
    
    public LabeledStatement() {
        this.labels = new ArrayList<Label>();
        this.type = 143;
    }
    
    public LabeledStatement(final int pos) {
        super(pos);
        this.labels = new ArrayList<Label>();
        this.type = 143;
    }
    
    public LabeledStatement(final int pos, final int len) {
        super(pos, len);
        this.labels = new ArrayList<Label>();
        this.type = 143;
    }
    
    public List<Label> getLabels() {
        return this.labels;
    }
    
    public void setLabels(final List<Label> labels) {
        this.assertNotNull((Object)labels);
        if (this.labels != null) {
            this.labels.clear();
        }
        for (final Label l : labels) {
            this.addLabel(l);
        }
    }
    
    public void addLabel(final Label label) {
        this.assertNotNull((Object)label);
        this.labels.add(label);
        label.setParent((AstNode)this);
    }
    
    public AstNode getStatement() {
        return this.statement;
    }
    
    public Label getLabelByName(final String name) {
        for (final Label label : this.labels) {
            if (name.equals(label.getName())) {
                return label;
            }
        }
        return null;
    }
    
    public void setStatement(final AstNode statement) {
        this.assertNotNull((Object)statement);
        (this.statement = statement).setParent((AstNode)this);
    }
    
    public Label getFirstLabel() {
        return this.labels.get(0);
    }
    
    public boolean hasSideEffects() {
        return true;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        for (final Label label : this.labels) {
            sb.append(label.toSource(depth));
        }
        sb.append(this.statement.toSource(depth + 1));
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            for (final AstNode label : this.labels) {
                label.visit(v);
            }
            this.statement.visit(v);
        }
    }
}
