//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import org.mozilla.javascript.ast.*;
import java.util.*;

public class NodeTransformer
{
    private ObjArray loops;
    private ObjArray loopEnds;
    private boolean hasFinally;
    
    public final void transform(final ScriptNode tree, final CompilerEnvirons env) {
        this.transform(tree, false, env);
    }
    
    public final void transform(final ScriptNode tree, final boolean inStrictMode, final CompilerEnvirons env) {
        boolean useStrictMode = inStrictMode;
        if (env.getLanguageVersion() >= 200 && tree.isInStrictMode()) {
            useStrictMode = true;
        }
        this.transformCompilationUnit(tree, useStrictMode);
        for (int i = 0; i != tree.getFunctionCount(); ++i) {
            final FunctionNode fn = tree.getFunctionNode(i);
            this.transform((ScriptNode)fn, useStrictMode, env);
        }
    }
    
    private void transformCompilationUnit(final ScriptNode tree, final boolean inStrictMode) {
        this.loops = new ObjArray();
        this.loopEnds = new ObjArray();
        this.hasFinally = false;
        final boolean createScopeObjects = tree.getType() != 114 || ((FunctionNode)tree).requiresActivation();
        tree.flattenSymbolTable(!createScopeObjects);
        this.transformCompilationUnit_r(tree, (Node)tree, (Scope)tree, createScopeObjects, inStrictMode);
    }
    
    private void transformCompilationUnit_r(final ScriptNode tree, final Node parent, final Scope scope, final boolean createScopeObjects, final boolean inStrictMode) {
        Node node = null;
        while (true) {
            Node previous = null;
            if (node == null) {
                node = parent.getFirstChild();
            }
            else {
                previous = node;
                node = node.getNext();
            }
            if (node == null) {
                return;
            }
            int type = node.getType();
            if (createScopeObjects && (type == 139 || type == 142 || type == 162) && node instanceof Scope) {
                final Scope newScope = (Scope)node;
                if (newScope.getSymbolTable() != null) {
                    final Node let = new Node((type == 162) ? 163 : 158);
                    final Node innerLet = new Node(158);
                    let.addChildToBack(innerLet);
                    for (final String name : newScope.getSymbolTable().keySet()) {
                        innerLet.addChildToBack(Node.newString(40, name));
                    }
                    newScope.setSymbolTable((Map)null);
                    final Node oldNode = node;
                    node = replaceCurrent(parent, previous, node, let);
                    type = node.getType();
                    let.addChildToBack(oldNode);
                }
            }
            Label_1860: {
                switch (type) {
                    case 123:
                    case 140:
                    case 142: {
                        this.loops.push(node);
                        this.loopEnds.push(((Jump)node).target);
                        break;
                    }
                    case 132: {
                        this.loops.push(node);
                        final Node leave = node.getNext();
                        if (leave.getType() != 3) {
                            Kit.codeBug();
                        }
                        this.loopEnds.push(leave);
                        break;
                    }
                    case 78: {
                        final Jump jump = (Jump)node;
                        final Node finallytarget = jump.getFinally();
                        if (finallytarget != null) {
                            this.hasFinally = true;
                            this.loops.push(node);
                            this.loopEnds.push(finallytarget);
                            break;
                        }
                        break;
                    }
                    case 3:
                    case 141: {
                        if (!this.loopEnds.isEmpty() && this.loopEnds.peek() == node) {
                            this.loopEnds.pop();
                            this.loops.pop();
                            break;
                        }
                        break;
                    }
                    case 70: {
                        final Object[] props = (Object[])node.getProp(12);
                        for (int i = 0, propsLength = props.length; i < propsLength; ++i) {
                            final Object prop = props[i];
                            if (prop instanceof Node) {
                                final Node propNode = (Node)prop;
                                if (propNode.getProp(28) != null) {
                                    final Node parentNode = new Node(138, propNode);
                                    this.transformCompilationUnit_r(tree, parentNode, scope, createScopeObjects, inStrictMode);
                                    props[i] = parentNode.first;
                                }
                            }
                        }
                        break;
                    }
                    case 76: {
                        ((FunctionNode)tree).addResumptionPoint(node);
                        break;
                    }
                    case 4: {
                        final boolean isGenerator = tree.getType() == 114 && ((FunctionNode)tree).isGenerator();
                        if (isGenerator) {
                            node.putIntProp(20, 1);
                        }
                        if (!this.hasFinally) {
                            break;
                        }
                        Node unwindBlock = null;
                        for (int j = this.loops.size() - 1; j >= 0; --j) {
                            final Node n = (Node)this.loops.get(j);
                            final int elemtype = n.getType();
                            if (elemtype == 78 || elemtype == 132) {
                                Node unwind;
                                if (elemtype == 78) {
                                    final Jump jsrnode = new Jump(145);
                                    final Node jsrtarget = ((Jump)n).getFinally();
                                    jsrnode.target = jsrtarget;
                                    unwind = (Node)jsrnode;
                                }
                                else {
                                    unwind = new Node(3);
                                }
                                if (unwindBlock == null) {
                                    unwindBlock = new Node(139, node.getLineno());
                                }
                                unwindBlock.addChildToBack(unwind);
                            }
                        }
                        if (unwindBlock == null) {
                            break;
                        }
                        Node returnNode = node;
                        final Node returnExpr = returnNode.getFirstChild();
                        node = replaceCurrent(parent, previous, node, unwindBlock);
                        if (returnExpr == null || isGenerator) {
                            unwindBlock.addChildToBack(returnNode);
                            continue;
                        }
                        final Node store = new Node(144, returnExpr);
                        unwindBlock.addChildToFront(store);
                        returnNode = new Node(68);
                        unwindBlock.addChildToBack(returnNode);
                        this.transformCompilationUnit_r(tree, store, scope, createScopeObjects, inStrictMode);
                        continue;
                    }
                    case 129:
                    case 130: {
                        final Jump jump2 = (Jump)node;
                        final Jump jumpStatement = jump2.getJumpStatement();
                        if (jumpStatement == null) {
                            Kit.codeBug();
                        }
                        int j = this.loops.size();
                        while (j != 0) {
                            --j;
                            final Node n = (Node)this.loops.get(j);
                            if (n == jumpStatement) {
                                if (type == 129) {
                                    jump2.target = jumpStatement.target;
                                }
                                else {
                                    jump2.target = jumpStatement.getContinue();
                                }
                                jump2.setType(5);
                                break Label_1860;
                            }
                            final int elemtype = n.getType();
                            if (elemtype == 132) {
                                final Node leave2 = new Node(3);
                                previous = addBeforeCurrent(parent, previous, node, leave2);
                            }
                            else {
                                if (elemtype != 78) {
                                    continue;
                                }
                                final Jump tryNode = (Jump)n;
                                final Jump jsrFinally = new Jump(145);
                                jsrFinally.target = tryNode.getFinally();
                                previous = addBeforeCurrent(parent, previous, node, (Node)jsrFinally);
                            }
                        }
                        throw Kit.codeBug();
                    }
                    case 39: {
                        this.visitCall(node, tree);
                        break;
                    }
                    case 31: {
                        this.visitNew(node, tree);
                        break;
                    }
                    case 158:
                    case 163: {
                        final Node child = node.getFirstChild();
                        if (child.getType() == 158) {
                            final boolean createWith = tree.getType() != 114 || ((FunctionNode)tree).requiresActivation();
                            node = this.visitLet(createWith, parent, previous, node);
                            break;
                        }
                    }
                    case 131:
                    case 159: {
                        final Node result = new Node(139);
                        Node cursor = node.getFirstChild();
                        while (cursor != null) {
                            Node n2 = cursor;
                            cursor = cursor.getNext();
                            if (n2.getType() == 40) {
                                if (!n2.hasChildren()) {
                                    continue;
                                }
                                final Node init = n2.getFirstChild();
                                n2.removeChild(init);
                                n2.setType(52);
                                n2 = new Node((type == 159) ? 160 : 8, n2, init);
                            }
                            else if (n2.getType() != 163) {
                                throw Kit.codeBug();
                            }
                            final Node pop = new Node(143, n2, node.getLineno());
                            result.addChildToBack(pop);
                        }
                        node = replaceCurrent(parent, previous, node, result);
                        break;
                    }
                    case 147: {
                        final Scope defining = scope.getDefiningScope(node.getString());
                        if (defining != null) {
                            node.setScope(defining);
                        }
                        break;
                    }
                    case 7:
                    case 33: {
                        Node child = node.getFirstChild();
                        if (type == 7) {
                            while (child.getType() == 27) {
                                child = child.getFirstChild();
                            }
                            if (child.getType() == 12 || child.getType() == 13) {
                                final Node first = child.getFirstChild();
                                final Node last = child.getLastChild();
                                if (first.getType() == 40 && first.getString().equals("undefined")) {
                                    child = last;
                                }
                                else if (last.getType() == 40 && last.getString().equals("undefined")) {
                                    child = first;
                                }
                            }
                        }
                        if (child.getType() == 34) {
                            child.setType(35);
                            break;
                        }
                        break;
                    }
                    case 8: {
                        if (inStrictMode) {
                            node.setType(77);
                        }
                    }
                    case 32:
                    case 40:
                    case 160: {
                        if (createScopeObjects) {
                            break;
                        }
                        Node nameSource;
                        if (type == 40) {
                            nameSource = node;
                        }
                        else {
                            nameSource = node.getFirstChild();
                            if (nameSource.getType() != 52) {
                                if (type == 32) {
                                    break;
                                }
                                throw Kit.codeBug();
                            }
                        }
                        if (nameSource.getScope() != null) {
                            break;
                        }
                        final String name2 = nameSource.getString();
                        final Scope defining2 = scope.getDefiningScope(name2);
                        if (defining2 == null) {
                            break;
                        }
                        nameSource.setScope(defining2);
                        if (type == 40) {
                            node.setType(58);
                            break;
                        }
                        if (type == 8 || type == 77) {
                            node.setType(59);
                            nameSource.setType(42);
                            break;
                        }
                        if (type == 160) {
                            node.setType(161);
                            nameSource.setType(42);
                            break;
                        }
                        if (type == 32) {
                            final Node n = new Node(47);
                            node = replaceCurrent(parent, previous, node, n);
                            break;
                        }
                        throw Kit.codeBug();
                    }
                }
            }
            this.transformCompilationUnit_r(tree, node, (node instanceof Scope) ? ((Scope)node) : scope, createScopeObjects, inStrictMode);
        }
    }
    
    protected void visitNew(final Node node, final ScriptNode tree) {
    }
    
    protected void visitCall(final Node node, final ScriptNode tree) {
    }
    
    protected Node visitLet(final boolean createWith, final Node parent, final Node previous, final Node scopeNode) {
        final Node vars = scopeNode.getFirstChild();
        Node body = vars.getNext();
        scopeNode.removeChild(vars);
        scopeNode.removeChild(body);
        final boolean isExpression = scopeNode.getType() == 163;
        Node result;
        if (createWith) {
            result = new Node(isExpression ? 164 : 139);
            result = replaceCurrent(parent, previous, scopeNode, result);
            final ArrayList<Object> list = new ArrayList<Object>();
            final Node objectLiteral = new Node(70);
            for (Node v = vars.getFirstChild(); v != null; v = v.getNext()) {
                Node current = v;
                if (current.getType() == 163) {
                    final List<?> destructuringNames = (List<?>)current.getProp(22);
                    final Node c = current.getFirstChild();
                    if (c.getType() != 158) {
                        throw Kit.codeBug();
                    }
                    if (isExpression) {
                        body = new Node(86, c.getNext(), body);
                    }
                    else {
                        body = new Node(139, new Node(143, c.getNext()), body);
                    }
                    if (destructuringNames != null) {
                        list.addAll(destructuringNames);
                        for (int i = 0; i < destructuringNames.size(); ++i) {
                            objectLiteral.addChildToBack(new Node(136, Node.newNumber(0.0)));
                        }
                    }
                    current = c.getFirstChild();
                }
                if (current.getType() != 40) {
                    throw Kit.codeBug();
                }
                list.add(ScriptRuntime.getIndexObject(current.getString()));
                Node init = current.getFirstChild();
                if (init == null) {
                    init = new Node(136, Node.newNumber(0.0));
                }
                objectLiteral.addChildToBack(init);
            }
            objectLiteral.putProp(12, (Object)list.toArray());
            final Node newVars = new Node(2, objectLiteral);
            result.addChildToBack(newVars);
            result.addChildToBack(new Node(132, body));
            result.addChildToBack(new Node(3));
        }
        else {
            result = new Node(isExpression ? 86 : 139);
            result = replaceCurrent(parent, previous, scopeNode, result);
            final Node newVars = new Node(86);
            for (Node v2 = vars.getFirstChild(); v2 != null; v2 = v2.getNext()) {
                Node current2 = v2;
                if (current2.getType() == 163) {
                    final Node c2 = current2.getFirstChild();
                    if (c2.getType() != 158) {
                        throw Kit.codeBug();
                    }
                    if (isExpression) {
                        body = new Node(86, c2.getNext(), body);
                    }
                    else {
                        body = new Node(139, new Node(143, c2.getNext()), body);
                    }
                    Scope.joinScopes((Scope)current2, (Scope)scopeNode);
                    current2 = c2.getFirstChild();
                }
                if (current2.getType() != 40) {
                    throw Kit.codeBug();
                }
                final Node stringNode = Node.newString(current2.getString());
                stringNode.setScope((Scope)scopeNode);
                Node init2 = current2.getFirstChild();
                if (init2 == null) {
                    init2 = new Node(136, Node.newNumber(0.0));
                }
                newVars.addChildToBack(new Node(59, stringNode, init2));
            }
            if (isExpression) {
                result.addChildToBack(newVars);
                scopeNode.setType(86);
                result.addChildToBack(scopeNode);
                scopeNode.addChildToBack(body);
                if (body instanceof Scope) {
                    final Scope scopeParent = ((Scope)body).getParentScope();
                    ((Scope)body).setParentScope((Scope)scopeNode);
                    ((Scope)scopeNode).setParentScope(scopeParent);
                }
            }
            else {
                result.addChildToBack(new Node(143, newVars));
                scopeNode.setType(139);
                result.addChildToBack(scopeNode);
                scopeNode.addChildrenToBack(body);
                if (body instanceof Scope) {
                    final Scope scopeParent = ((Scope)body).getParentScope();
                    ((Scope)body).setParentScope((Scope)scopeNode);
                    ((Scope)scopeNode).setParentScope(scopeParent);
                }
            }
        }
        return result;
    }
    
    private static Node addBeforeCurrent(final Node parent, final Node previous, final Node current, final Node toAdd) {
        if (previous == null) {
            if (current != parent.getFirstChild()) {
                Kit.codeBug();
            }
            parent.addChildToFront(toAdd);
        }
        else {
            if (current != previous.getNext()) {
                Kit.codeBug();
            }
            parent.addChildAfter(toAdd, previous);
        }
        return toAdd;
    }
    
    private static Node replaceCurrent(final Node parent, final Node previous, final Node current, final Node replacement) {
        if (previous == null) {
            if (current != parent.getFirstChild()) {
                Kit.codeBug();
            }
            parent.replaceChild(current, replacement);
        }
        else if (previous.next == current) {
            parent.replaceChildAfter(previous, replacement);
        }
        else {
            parent.replaceChild(current, replacement);
        }
        return replacement;
    }
}
