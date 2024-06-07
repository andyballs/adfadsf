//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.ast.*;
import java.util.*;

public class Node implements Iterable<Node>
{
    public static final int FUNCTION_PROP = 1;
    public static final int LOCAL_PROP = 2;
    public static final int LOCAL_BLOCK_PROP = 3;
    public static final int REGEXP_PROP = 4;
    public static final int CASEARRAY_PROP = 5;
    public static final int TARGETBLOCK_PROP = 6;
    public static final int VARIABLE_PROP = 7;
    public static final int ISNUMBER_PROP = 8;
    public static final int DIRECTCALL_PROP = 9;
    public static final int SPECIALCALL_PROP = 10;
    public static final int SKIP_INDEXES_PROP = 11;
    public static final int OBJECT_IDS_PROP = 12;
    public static final int INCRDECR_PROP = 13;
    public static final int CATCH_SCOPE_PROP = 14;
    public static final int LABEL_ID_PROP = 15;
    public static final int MEMBER_TYPE_PROP = 16;
    public static final int NAME_PROP = 17;
    public static final int CONTROL_BLOCK_PROP = 18;
    public static final int PARENTHESIZED_PROP = 19;
    public static final int GENERATOR_END_PROP = 20;
    public static final int DESTRUCTURING_ARRAY_LENGTH = 21;
    public static final int DESTRUCTURING_NAMES = 22;
    public static final int DESTRUCTURING_PARAMS = 23;
    public static final int JSDOC_PROP = 24;
    public static final int EXPRESSION_CLOSURE_PROP = 25;
    public static final int DESTRUCTURING_SHORTHAND = 26;
    public static final int ARROW_FUNCTION_PROP = 27;
    public static final int COMPUTED_PROP = 28;
    public static final int SPREAD_PROP = 29;
    public static final int CHAINING_PROP = 30;
    public static final int SUPER_PROP = 31;
    public static final int SPREAD_IDS_PROP = 32;
    public static final int DECORATOR_PROP = 33;
    public static final int PRIVATE_ACCESS_PROP = 34;
    public static final int EXPORT_PROP = 35;
    public static final int INITIALIZE_PROP = 36;
    public static final int PARTIAL_PROP = 37;
    public static final int BOTH = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int NON_SPECIALCALL = 0;
    public static final int SPECIALCALL_EVAL = 1;
    public static final int SPECIALCALL_WITH = 2;
    public static final int DECR_FLAG = 1;
    public static final int POST_FLAG = 2;
    public static final int PROPERTY_FLAG = 1;
    public static final int ATTRIBUTE_FLAG = 2;
    public static final int DESCENDANTS_FLAG = 4;
    private static final Node NOT_SET;
    public static final int END_UNREACHED = 0;
    public static final int END_DROPS_OFF = 1;
    public static final int END_RETURNS = 2;
    public static final int END_RETURNS_VALUE = 4;
    public static final int END_YIELDS = 8;
    protected int type;
    protected Node next;
    protected Node first;
    protected Node last;
    protected int lineno;
    protected PropListItem propListHead;
    
    public Node(final int nodeType) {
        this.type = -1;
        this.lineno = -1;
        this.type = nodeType;
    }
    
    public Node(final int nodeType, final Node child) {
        this.type = -1;
        this.lineno = -1;
        this.type = nodeType;
        this.last = child;
        this.first = child;
        child.next = null;
    }
    
    public Node(final int nodeType, final Node left, final Node right) {
        this.type = -1;
        this.lineno = -1;
        this.type = nodeType;
        this.first = left;
        this.last = right;
        left.next = right;
        right.next = null;
    }
    
    public Node(final int nodeType, final Node left, final Node mid, final Node right) {
        this.type = -1;
        this.lineno = -1;
        this.type = nodeType;
        this.first = left;
        this.last = right;
        left.next = mid;
        mid.next = right;
        right.next = null;
    }
    
    public Node(final int nodeType, final int line) {
        this.type = -1;
        this.lineno = -1;
        this.type = nodeType;
        this.lineno = line;
    }
    
    public Node(final int nodeType, final Node child, final int line) {
        this(nodeType, child);
        this.lineno = line;
    }
    
    public Node(final int nodeType, final Node left, final Node right, final int line) {
        this(nodeType, left, right);
        this.lineno = line;
    }
    
    public Node(final int nodeType, final Node left, final Node mid, final Node right, final int line) {
        this(nodeType, left, mid, right);
        this.lineno = line;
    }
    
    public static Node newNumber(final double number) {
        final NumberLiteral n = new NumberLiteral();
        n.setNumber(number);
        return (Node)n;
    }
    
    public static Node newString(final String str) {
        return newString(42, str);
    }
    
    public static Node newString(final int type, final String str) {
        final Name name = new Name();
        name.setIdentifier(str);
        name.setType(type);
        return (Node)name;
    }
    
    public int getType() {
        return this.type;
    }
    
    public Node setType(final int type) {
        this.type = type;
        return this;
    }
    
    public String getJsDoc() {
        final Comment comment = this.getJsDocNode();
        if (comment != null) {
            return comment.getValue();
        }
        return null;
    }
    
    public Comment getJsDocNode() {
        return (Comment)this.getProp(24);
    }
    
    public void setJsDocNode(final Comment jsdocNode) {
        this.putProp(24, jsdocNode);
    }
    
    public boolean hasChildren() {
        return this.first != null;
    }
    
    public Node getFirstChild() {
        return this.first;
    }
    
    public Node getLastChild() {
        return this.last;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public Node getChildBefore(final Node child) {
        if (child == this.first) {
            return null;
        }
        Node n = this.first;
        while (n.next != child) {
            n = n.next;
            if (n == null) {
                throw new RuntimeException("node is not a child");
            }
        }
        return n;
    }
    
    public Node getLastSibling() {
        Node n;
        for (n = this; n.next != null; n = n.next) {}
        return n;
    }
    
    public void addChildToFront(final Node child) {
        child.next = this.first;
        this.first = child;
        if (this.last == null) {
            this.last = child;
        }
    }
    
    public void addChildToBack(final Node child) {
        child.next = null;
        if (this.last == null) {
            this.last = child;
            this.first = child;
            return;
        }
        this.last.next = child;
        this.last = child;
    }
    
    public void addChildrenToFront(final Node children) {
        final Node lastSib = children.getLastSibling();
        lastSib.next = this.first;
        this.first = children;
        if (this.last == null) {
            this.last = lastSib;
        }
    }
    
    public void addChildrenToBack(final Node children) {
        if (this.last != null) {
            this.last.next = children;
        }
        this.last = children.getLastSibling();
        if (this.first == null) {
            this.first = children;
        }
    }
    
    public void addChildBefore(final Node newChild, final Node node) {
        if (newChild.next != null) {
            throw new RuntimeException("newChild had siblings in addChildBefore");
        }
        if (this.first == node) {
            newChild.next = this.first;
            this.first = newChild;
            return;
        }
        final Node prev = this.getChildBefore(node);
        this.addChildAfter(newChild, prev);
    }
    
    public void addChildAfter(final Node newChild, final Node node) {
        if (newChild.next != null) {
            throw new RuntimeException("newChild had siblings in addChildAfter");
        }
        newChild.next = node.next;
        node.next = newChild;
        if (this.last == node) {
            this.last = newChild;
        }
    }
    
    public void removeChild(final Node child) {
        final Node prev = this.getChildBefore(child);
        if (prev == null) {
            this.first = this.first.next;
        }
        else {
            prev.next = child.next;
        }
        if (child == this.last) {
            this.last = prev;
        }
        child.next = null;
    }
    
    public void replaceChild(final Node child, final Node newChild) {
        newChild.next = child.next;
        if (child == this.first) {
            this.first = newChild;
        }
        else {
            final Node prev = this.getChildBefore(child);
            prev.next = newChild;
        }
        if (child == this.last) {
            this.last = newChild;
        }
        child.next = null;
    }
    
    public void replaceChildAfter(final Node prevChild, final Node newChild) {
        final Node child = prevChild.next;
        newChild.next = child.next;
        prevChild.next = newChild;
        if (child == this.last) {
            this.last = newChild;
        }
        child.next = null;
    }
    
    public void removeChildren() {
        final Node node = null;
        this.last = node;
        this.first = node;
    }
    
    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator();
    }
    
    private static String propToString(final int propType) {
        if (!Context.getContext().hasFeature(19)) {
            return null;
        }
        switch (propType) {
            case 1: {
                return "function";
            }
            case 2: {
                return "local";
            }
            case 3: {
                return "local_block";
            }
            case 4: {
                return "regexp";
            }
            case 5: {
                return "casearray";
            }
            case 6: {
                return "targetblock";
            }
            case 7: {
                return "variable";
            }
            case 8: {
                return "isnumber";
            }
            case 9: {
                return "directcall";
            }
            case 10: {
                return "specialcall";
            }
            case 11: {
                return "skip_indexes";
            }
            case 12: {
                return "object_ids_prop";
            }
            case 13: {
                return "incrdecr_prop";
            }
            case 14: {
                return "catch_scope_prop";
            }
            case 15: {
                return "label_id_prop";
            }
            case 16: {
                return "member_type_prop";
            }
            case 17: {
                return "name_prop";
            }
            case 18: {
                return "control_block_prop";
            }
            case 19: {
                return "parenthesized_prop";
            }
            case 20: {
                return "generator_end";
            }
            case 21: {
                return "destructuring_array_length";
            }
            case 22: {
                return "destructuring_names";
            }
            case 23: {
                return "destructuring_params";
            }
            case 28: {
                return "computed_prop";
            }
            case 29: {
                return "spread_prop";
            }
            case 30: {
                return "chaining_prop";
            }
            case 25: {
                return "expression_closure";
            }
            case 26: {
                return "destructuring_shorthand";
            }
            case 31: {
                return "super_prop";
            }
            case 32: {
                return "spread_ids";
            }
            case 33: {
                return "decorator";
            }
            case 34: {
                return "private_access";
            }
            case 35: {
                return "export_prop";
            }
            case 36: {
                return "initialize_prop";
            }
            case 37: {
                return "partial_prop";
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    private PropListItem lookupProperty(final int propType) {
        PropListItem x;
        for (x = this.propListHead; x != null && propType != x.type; x = x.next) {}
        return x;
    }
    
    private PropListItem ensureProperty(final int propType) {
        PropListItem item = this.lookupProperty(propType);
        if (item == null) {
            item = new PropListItem();
            item.type = propType;
            item.next = this.propListHead;
            this.propListHead = item;
        }
        return item;
    }
    
    public void removeProp(final int propType) {
        PropListItem x = this.propListHead;
        if (x != null) {
            PropListItem prev = null;
            while (x.type != propType) {
                prev = x;
                x = x.next;
                if (x == null) {
                    return;
                }
            }
            if (prev == null) {
                this.propListHead = x.next;
            }
            else {
                prev.next = x.next;
            }
        }
    }
    
    public Object getProp(final int propType) {
        final PropListItem item = this.lookupProperty(propType);
        return (item == null) ? null : item.objectValue;
    }
    
    public Object getProp(final int propType, final Object defaultValue) {
        final PropListItem item = this.lookupProperty(propType);
        return (item == null) ? defaultValue : item.objectValue;
    }
    
    public int getIntProp(final int propType, final int defaultValue) {
        final PropListItem item = this.lookupProperty(propType);
        if (item == null) {
            return defaultValue;
        }
        return item.intValue;
    }
    
    public int getExistingIntProp(final int propType) {
        final PropListItem item = this.lookupProperty(propType);
        if (item == null) {
            Kit.codeBug();
        }
        return item.intValue;
    }
    
    public void putProp(final int propType, final Object prop) {
        if (prop == null) {
            this.removeProp(propType);
        }
        else {
            final PropListItem item = this.ensureProperty(propType);
            item.objectValue = prop;
        }
    }
    
    public void putIntProp(final int propType, final int prop) {
        final PropListItem item = this.ensureProperty(propType);
        item.intValue = prop;
    }
    
    public int getLineno() {
        return this.lineno;
    }
    
    public void setLineno(final int lineno) {
        this.lineno = lineno;
    }
    
    public final double getDouble() {
        return ((NumberLiteral)this).getNumber();
    }
    
    public final void setDouble(final double number) {
        ((NumberLiteral)this).setNumber(number);
    }
    
    public final String getString() {
        return ((Name)this).getIdentifier();
    }
    
    public final void setString(final String s) {
        if (s == null) {
            Kit.codeBug();
        }
        ((Name)this).setIdentifier(s);
    }
    
    public Scope getScope() {
        if (this instanceof Name) {
            return ((Name)this).getScope();
        }
        throw Kit.codeBug();
    }
    
    public void setScope(final Scope s) {
        if (s == null) {
            throw Kit.codeBug();
        }
        if (this instanceof Name) {
            this.setScope(s);
            return;
        }
        throw Kit.codeBug();
    }
    
    public static Node newTarget() {
        return new Node(141);
    }
    
    public final int labelId() {
        if (this.type != 141 && this.type != 76) {
            Kit.codeBug();
        }
        return this.getIntProp(15, -1);
    }
    
    public void labelId(final int labelId) {
        if (this.type != 141 && this.type != 76) {
            Kit.codeBug();
        }
        this.putIntProp(15, labelId);
    }
    
    public boolean hasConsistentReturnUsage() {
        final int n = this.endCheck();
        return (n & 0x4) == 0x0 || (n & 0xB) == 0x0;
    }
    
    private int endCheckIf() {
        int rv = 0;
        final Node th = this.next;
        final Node el = ((Jump)this).target;
        rv = th.endCheck();
        if (el != null) {
            rv |= el.endCheck();
        }
        else {
            rv |= 0x1;
        }
        return rv;
    }
    
    private int endCheckSwitch() {
        final int rv = 0;
        return rv;
    }
    
    private int endCheckTry() {
        final int rv = 0;
        return rv;
    }
    
    private int endCheckLoop() {
        int rv = 0;
        Node n;
        for (n = this.first; n.next != this.last; n = n.next) {}
        if (n.type != 6) {
            return 1;
        }
        rv = ((Jump)n).target.next.endCheck();
        if (n.first.type == 48) {
            rv &= 0xFFFFFFFE;
        }
        rv |= this.getIntProp(18, 0);
        return rv;
    }
    
    private int endCheckBlock() {
        int rv = 1;
        for (Node n = this.first; (rv & 0x1) != 0x0 && n != null; rv &= 0xFFFFFFFE, rv |= n.endCheck(), n = n.next) {}
        return rv;
    }
    
    private int endCheckLabel() {
        int rv = 0;
        rv = this.next.endCheck();
        rv |= this.getIntProp(18, 0);
        return rv;
    }
    
    private int endCheckBreak() {
        final Node n = (Node)((Jump)this).getJumpStatement();
        n.putIntProp(18, 1);
        return 0;
    }
    
    private int endCheck() {
        switch (this.type) {
            case 129: {
                return this.endCheckBreak();
            }
            case 143: {
                if (this.first != null) {
                    return this.first.endCheck();
                }
                return 1;
            }
            case 76: {
                return 8;
            }
            case 53:
            case 130: {
                return 0;
            }
            case 4: {
                if (this.first != null) {
                    return 4;
                }
                return 2;
            }
            case 141: {
                if (this.next != null) {
                    return this.next.endCheck();
                }
                return 1;
            }
            case 142: {
                return this.endCheckLoop();
            }
            case 139:
            case 151: {
                if (this.first == null) {
                    return 1;
                }
                switch (this.first.type) {
                    case 140: {
                        return this.first.endCheckLabel();
                    }
                    case 7: {
                        return this.first.endCheckIf();
                    }
                    case 123: {
                        return this.first.endCheckSwitch();
                    }
                    case 78: {
                        return this.first.endCheckTry();
                    }
                    default: {
                        return this.endCheckBlock();
                    }
                }
                break;
            }
            default: {
                return 1;
            }
        }
    }
    
    public boolean hasSideEffects() {
        switch (this.type) {
            case 86:
            case 143: {
                return this.last == null || this.last.hasSideEffects();
            }
            case 103: {
                if (this.first == null || this.first.next == null || this.first.next.next == null) {
                    Kit.codeBug();
                }
                return this.first.next.hasSideEffects() && this.first.next.next.hasSideEffects();
            }
            case 105:
            case 106: {
                if (this.first == null || this.last == null) {
                    Kit.codeBug();
                }
                return this.first.hasSideEffects() || this.last.hasSideEffects();
            }
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
    
    public void resetTargets() {
        if (this.type == 134) {
            this.resetTargets_r();
        }
        else {
            Kit.codeBug();
        }
    }
    
    private void resetTargets_r() {
        if (this.type == 141 || this.type == 76) {
            this.labelId(-1);
        }
        for (Node child = this.first; child != null; child = child.next) {
            child.resetTargets_r();
        }
    }
    
    @Override
    public String toString() {
        if (Context.getCurrentContext() != null && Context.getContext().hasFeature(19)) {
            final StringBuilder sb = new StringBuilder();
            this.toString(new ObjToIntMap(), sb);
            return sb.toString();
        }
        return String.valueOf(this.type);
    }
    
    private void toString(final ObjToIntMap printIds, final StringBuilder sb) {
        sb.append(Token.name(this.type));
        if (this instanceof Name) {
            sb.append(' ');
            sb.append(this.getString());
            final Scope scope = this.getScope();
            if (scope != null) {
                sb.append("[scope: ");
                appendPrintId((Node)scope, printIds, sb);
                sb.append("]");
            }
        }
        else if (this instanceof Scope) {
            if (this instanceof ScriptNode) {
                final ScriptNode sof = (ScriptNode)this;
                if (this instanceof FunctionNode) {
                    final FunctionNode fn = (FunctionNode)this;
                    sb.append(' ');
                    sb.append(fn.getName());
                }
                sb.append(" [source name: ");
                sb.append(sof.getSourceName());
                sb.append("] [encoded source length: ");
                sb.append(sof.getEncodedSourceEnd() - sof.getEncodedSourceStart());
                sb.append("] [base line: ");
                sb.append(sof.getBaseLineno());
                sb.append("] [end line: ");
                sb.append(sof.getEndLineno());
                sb.append(']');
            }
            if (((Scope)this).getSymbolTable() != null) {
                sb.append(" [scope ");
                appendPrintId(this, printIds, sb);
                sb.append(": ");
                final Iterator<String> iter = ((Scope)this).getSymbolTable().keySet().iterator();
                while (iter.hasNext()) {
                    sb.append(iter.next());
                    sb.append(" ");
                }
                sb.append("]");
            }
        }
        else if (this instanceof Jump) {
            final Jump jump = (Jump)this;
            if (this.type == 129 || this.type == 130) {
                sb.append(" [label: ");
                appendPrintId((Node)jump.getJumpStatement(), printIds, sb);
                sb.append(']');
            }
            else if (this.type == 78) {
                final Node catchNode = jump.target;
                final Node finallyTarget = jump.getFinally();
                if (catchNode != null) {
                    sb.append(" [catch: ");
                    appendPrintId(catchNode, printIds, sb);
                    sb.append(']');
                }
                if (finallyTarget != null) {
                    sb.append(" [finally: ");
                    appendPrintId(finallyTarget, printIds, sb);
                    sb.append(']');
                }
            }
            else if (this.type == 140 || this.type == 142 || this.type == 123) {
                sb.append(" [break: ");
                appendPrintId(jump.target, printIds, sb);
                sb.append(']');
                if (this.type == 142) {
                    sb.append(" [continue: ");
                    appendPrintId(jump.getContinue(), printIds, sb);
                    sb.append(']');
                }
            }
            else {
                sb.append(" [target: ");
                appendPrintId(jump.target, printIds, sb);
                sb.append(']');
            }
        }
        else if (this.type == 41) {
            sb.append(' ');
            sb.append(this.getDouble());
        }
        else if (this.type == 141) {
            sb.append(' ');
            appendPrintId(this, printIds, sb);
        }
        if (this.lineno != -1) {
            sb.append(' ');
            sb.append(this.lineno);
        }
        for (PropListItem x = this.propListHead; x != null; x = x.next) {
            final int type = x.type;
            sb.append(" [");
            sb.append(propToString(type));
            sb.append(": ");
            StringBuilder value = null;
            Label_1024: {
                switch (type) {
                    case 6: {
                        value = new StringBuilder("target block property");
                        break;
                    }
                    case 3: {
                        value = new StringBuilder("last local block");
                        break;
                    }
                    case 8: {
                        switch (x.intValue) {
                            case 0: {
                                value = new StringBuilder("both");
                                break Label_1024;
                            }
                            case 2: {
                                value = new StringBuilder("right");
                                break Label_1024;
                            }
                            case 1: {
                                value = new StringBuilder("left");
                                break Label_1024;
                            }
                            default: {
                                throw Kit.codeBug();
                            }
                        }
                        break;
                    }
                    case 10: {
                        switch (x.intValue) {
                            case 1: {
                                value = new StringBuilder("eval");
                                break Label_1024;
                            }
                            case 2: {
                                value = new StringBuilder("with");
                                break Label_1024;
                            }
                            default: {
                                throw Kit.codeBug();
                            }
                        }
                        break;
                    }
                    case 12: {
                        final Object[] a = (Object[])x.objectValue;
                        value = new StringBuilder("[");
                        for (int i = 0; i < a.length; ++i) {
                            value.append(a[i].toString());
                            if (i + 1 < a.length) {
                                value.append(", ");
                            }
                        }
                        value.append("]");
                        break;
                    }
                    default: {
                        final Object obj = x.objectValue;
                        if (obj != null) {
                            value = new StringBuilder(obj.toString());
                            break;
                        }
                        value = new StringBuilder(String.valueOf(x.intValue));
                        break;
                    }
                }
            }
            sb.append((CharSequence)value);
            sb.append(']');
        }
    }
    
    public String toStringTree(final ScriptNode treeTop) {
        final StringBuilder sb = new StringBuilder();
        toStringTreeHelper(treeTop, this, null, 0, sb);
        return sb.toString();
    }
    
    private static void toStringTreeHelper(final ScriptNode treeTop, final Node n, ObjToIntMap printIds, final int level, final StringBuilder sb) {
        if (printIds == null) {
            printIds = new ObjToIntMap();
            generatePrintIds((Node)treeTop, printIds);
        }
        for (int i = 0; i != level; ++i) {
            sb.append("    ");
        }
        n.toString(printIds, sb);
        sb.append('\n');
        for (Node cursor = n.getFirstChild(); cursor != null; cursor = cursor.getNext()) {
            if (cursor.getType() == 114) {
                final int fnIndex = cursor.getExistingIntProp(1);
                final FunctionNode fn = treeTop.getFunctionNode(fnIndex);
                toStringTreeHelper((ScriptNode)fn, (Node)fn, null, level + 1, sb);
            }
            else {
                toStringTreeHelper(treeTop, cursor, printIds, level + 1, sb);
            }
        }
    }
    
    private static void generatePrintIds(final Node n, final ObjToIntMap map) {
        map.put(n, map.size());
        for (Node cursor = n.getFirstChild(); cursor != null; cursor = cursor.getNext()) {
            generatePrintIds(cursor, map);
        }
    }
    
    private static void appendPrintId(final Node n, final ObjToIntMap printIds, final StringBuilder sb) {
        if (n != null) {
            final int id = printIds.get(n, -1);
            sb.append('#');
            if (id != -1) {
                sb.append(id + 1);
            }
            else {
                sb.append("<not_available>");
            }
        }
    }
    
    static {
        NOT_SET = new Node(-1);
    }
    
    private static class PropListItem
    {
        PropListItem next;
        int type;
        int intValue;
        Object objectValue;
    }
    
    public class NodeIterator implements Iterator<Node>
    {
        private Node cursor;
        private Node prev;
        private Node prev2;
        private boolean removed;
        
        public NodeIterator() {
            this.prev = Node.NOT_SET;
            this.removed = false;
            this.cursor = Node.this.first;
        }
        
        @Override
        public boolean hasNext() {
            return this.cursor != null;
        }
        
        @Override
        public Node next() {
            if (this.cursor == null) {
                throw new NoSuchElementException();
            }
            this.removed = false;
            this.prev2 = this.prev;
            this.prev = this.cursor;
            this.cursor = this.cursor.next;
            return this.prev;
        }
        
        @Override
        public void remove() {
            if (this.prev == Node.NOT_SET) {
                throw new IllegalStateException("next() has not been called");
            }
            if (this.removed) {
                throw new IllegalStateException("remove() already called for current element");
            }
            if (this.prev == Node.this.first) {
                Node.this.first = this.prev.next;
            }
            else if (this.prev == Node.this.last) {
                this.prev2.next = null;
                Node.this.last = this.prev2;
            }
            else {
                this.prev2.next = this.cursor;
            }
        }
    }
}
