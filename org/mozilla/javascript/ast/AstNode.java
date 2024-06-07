//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;
import java.io.*;
import org.mozilla.javascript.*;

public abstract class AstNode extends Node implements Comparable<AstNode>
{
    protected int position;
    protected int length;
    protected AstNode parent;
    protected AstNode inlineComment;
    private static Map<Integer, String> operatorNames;
    
    public AstNode() {
        super(-1);
        this.position = -1;
        this.length = 1;
    }
    
    public AstNode(final int pos) {
        this();
        this.position = pos;
    }
    
    public AstNode(final int pos, final int len) {
        this();
        this.position = pos;
        this.length = len;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(final int position) {
        this.position = position;
    }
    
    public int getAbsolutePosition() {
        int pos = this.position;
        for (AstNode parent = this.parent; parent != null; parent = parent.getParent()) {
            pos += parent.getPosition();
        }
        return pos;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setLength(final int length) {
        this.length = length;
    }
    
    public void setBounds(final int position, final int end) {
        this.setPosition(position);
        this.setLength(end - position);
    }
    
    public void setRelative(final int parentPosition) {
        this.position -= parentPosition;
    }
    
    public AstNode getParent() {
        return this.parent;
    }
    
    public void setParent(final AstNode parent) {
        if (parent == this.parent) {
            return;
        }
        if (this.parent != null) {
            this.setRelative(-this.parent.getAbsolutePosition());
        }
        if ((this.parent = parent) != null) {
            this.setRelative(parent.getAbsolutePosition());
        }
    }
    
    public void addChild(final AstNode kid) {
        this.assertNotNull(kid);
        final int end = kid.getPosition() + kid.getLength();
        this.setLength(end - this.getPosition());
        this.addChildToBack(kid);
        kid.setParent(this);
    }
    
    public AstRoot getAstRoot() {
        AstNode parent;
        for (parent = this; parent != null && !(parent instanceof AstRoot); parent = parent.getParent()) {}
        return (AstRoot)parent;
    }
    
    public abstract String toSource(final int p0);
    
    public String toSource() {
        return this.toSource(0);
    }
    
    public String makeIndent(final int indent) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            sb.append("  ");
        }
        return sb.toString();
    }
    
    public String shortName() {
        final String classname = this.getClass().getName();
        final int last = classname.lastIndexOf(".");
        return classname.substring(last + 1);
    }
    
    public static String operatorToString(final int op) {
        final String result = AstNode.operatorNames.get(op);
        if (result == null) {
            throw new IllegalArgumentException("Invalid operator: " + op);
        }
        return result;
    }
    
    public abstract void visit(final NodeVisitor p0);
    
    @Override
    public boolean hasSideEffects() {
        switch (this.getType()) {
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 31:
            case 32:
            case 36:
            case 38:
            case 39:
            case 53:
            case 54:
            case 59:
            case 60:
            case 68:
            case 72:
            case 73:
            case 74:
            case 76:
            case 78:
            case 79:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 107:
            case 108:
            case 114:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 139:
            case 140:
            case 141:
            case 142:
            case 144:
            case 145:
            case 149:
            case 150:
            case 151:
            case 152:
            case 158:
            case 159:
            case 163:
            case 164: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    protected void assertNotNull(final Object arg) {
        if (arg == null) {
            throw new IllegalArgumentException("arg cannot be null");
        }
    }
    
    protected <T extends AstNode> void printList(final List<T> items, final StringBuilder sb) {
        final int max = items.size();
        int count = 0;
        for (final AstNode item : items) {
            sb.append(item.toSource(0));
            if (count++ < max - 1) {
                sb.append(", ");
            }
            else {
                if (!(item instanceof EmptyExpression)) {
                    continue;
                }
                sb.append(",");
            }
        }
    }
    
    public static RuntimeException codeBug() throws RuntimeException {
        throw Kit.codeBug();
    }
    
    public FunctionNode getEnclosingFunction() {
        AstNode parent;
        for (parent = this.getParent(); parent != null && !(parent instanceof FunctionNode); parent = parent.getParent()) {}
        return (FunctionNode)parent;
    }
    
    public Scope getEnclosingScope() {
        AstNode parent;
        for (parent = this.getParent(); parent != null && !(parent instanceof Scope); parent = parent.getParent()) {}
        return (Scope)parent;
    }
    
    @Override
    public int compareTo(final AstNode other) {
        if (this.equals(other)) {
            return 0;
        }
        final int abs1 = this.getAbsolutePosition();
        final int abs2 = other.getAbsolutePosition();
        if (abs1 < abs2) {
            return -1;
        }
        if (abs2 < abs1) {
            return 1;
        }
        final int len1 = this.getLength();
        final int len2 = other.getLength();
        if (len1 < len2) {
            return -1;
        }
        if (len2 < len1) {
            return 1;
        }
        return this.hashCode() - other.hashCode();
    }
    
    public int depth() {
        return (this.parent == null) ? 0 : (1 + this.parent.depth());
    }
    
    @Override
    public int getLineno() {
        if (this.lineno != -1) {
            return this.lineno;
        }
        if (this.parent != null) {
            return this.parent.getLineno();
        }
        return -1;
    }
    
    public String debugPrint() {
        final DebugPrintVisitor dpv = new DebugPrintVisitor(new StringBuilder(1000));
        this.visit(dpv);
        return dpv.toString();
    }
    
    public AstNode getInlineComment() {
        return this.inlineComment;
    }
    
    public void setInlineComment(final AstNode inlineComment) {
        this.inlineComment = inlineComment;
    }
    
    static {
        (AstNode.operatorNames = new HashMap<Integer, String>()).put(55, "in");
        AstNode.operatorNames.put(33, "typeof");
        AstNode.operatorNames.put(56, "instanceof");
        AstNode.operatorNames.put(32, "delete");
        AstNode.operatorNames.put(86, ",");
        AstNode.operatorNames.put(104, ":");
        AstNode.operatorNames.put(105, "||");
        AstNode.operatorNames.put(106, "&&");
        AstNode.operatorNames.put(107, "++");
        AstNode.operatorNames.put(108, "--");
        AstNode.operatorNames.put(9, "|");
        AstNode.operatorNames.put(10, "^");
        AstNode.operatorNames.put(11, "&");
        AstNode.operatorNames.put(12, "==");
        AstNode.operatorNames.put(13, "!=");
        AstNode.operatorNames.put(14, "<");
        AstNode.operatorNames.put(16, ">");
        AstNode.operatorNames.put(15, "<=");
        AstNode.operatorNames.put(17, ">=");
        AstNode.operatorNames.put(18, "<<");
        AstNode.operatorNames.put(19, ">>");
        AstNode.operatorNames.put(20, ">>>");
        AstNode.operatorNames.put(21, "+");
        AstNode.operatorNames.put(22, "-");
        AstNode.operatorNames.put(23, "*");
        AstNode.operatorNames.put(26, "**");
        AstNode.operatorNames.put(24, "/");
        AstNode.operatorNames.put(25, "%");
        AstNode.operatorNames.put(27, "!");
        AstNode.operatorNames.put(28, "~");
        AstNode.operatorNames.put(29, "+");
        AstNode.operatorNames.put(30, "-");
        AstNode.operatorNames.put(49, "===");
        AstNode.operatorNames.put(50, "!==");
        AstNode.operatorNames.put(87, "=");
        AstNode.operatorNames.put(88, "|=");
        AstNode.operatorNames.put(90, "&=");
        AstNode.operatorNames.put(91, "<<=");
        AstNode.operatorNames.put(92, ">>=");
        AstNode.operatorNames.put(93, ">>>=");
        AstNode.operatorNames.put(94, "+=");
        AstNode.operatorNames.put(95, "-=");
        AstNode.operatorNames.put(96, "*=");
        AstNode.operatorNames.put(99, "**=");
        AstNode.operatorNames.put(97, "/=");
        AstNode.operatorNames.put(98, "%=");
        AstNode.operatorNames.put(89, "^=");
        AstNode.operatorNames.put(136, "void");
    }
    
    public static class PositionComparator implements Comparator<AstNode>, Serializable
    {
        private static final long serialVersionUID = 1L;
        
        @Override
        public int compare(final AstNode n1, final AstNode n2) {
            return n1.position - n2.position;
        }
    }
    
    protected static class DebugPrintVisitor implements NodeVisitor
    {
        private StringBuilder buffer;
        private static final int DEBUG_INDENT = 2;
        
        public DebugPrintVisitor(final StringBuilder buf) {
            this.buffer = buf;
        }
        
        @Override
        public String toString() {
            return this.buffer.toString();
        }
        
        private String makeIndent(final int depth) {
            final StringBuilder sb = new StringBuilder(2 * depth);
            for (int i = 0; i < 2 * depth; ++i) {
                sb.append(" ");
            }
            return sb.toString();
        }
        
        @Override
        public boolean visit(final AstNode node) {
            final int tt = node.getType();
            final String name = Token.typeToName(tt);
            this.buffer.append(node.getAbsolutePosition()).append("\t");
            this.buffer.append(this.makeIndent(node.depth()));
            this.buffer.append(name).append(" ");
            this.buffer.append(node.getPosition()).append(" ");
            this.buffer.append(node.getLength());
            if (tt == 40) {
                this.buffer.append(" ").append(((Name)node).getIdentifier());
            }
            else if (tt == 42) {
                this.buffer.append(" ").append(((StringLiteral)node).getValue(true));
            }
            this.buffer.append("\n");
            return true;
        }
    }
}
