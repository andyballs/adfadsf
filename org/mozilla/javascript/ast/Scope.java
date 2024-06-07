//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;
import org.mozilla.javascript.*;

public class Scope extends Jump
{
    protected Map<String, Symbol> symbolTable;
    protected Scope parentScope;
    protected ScriptNode top;
    private List<Scope> childScopes;
    
    public Scope() {
        this.type = 139;
    }
    
    public Scope(final int pos) {
        this.type = 139;
        this.position = pos;
    }
    
    public Scope(final int pos, final int len) {
        this(pos);
        this.length = len;
    }
    
    public Scope getParentScope() {
        return this.parentScope;
    }
    
    public void setParentScope(final Scope parentScope) {
        this.parentScope = parentScope;
        this.top = (ScriptNode)((parentScope == null) ? this : parentScope.top);
    }
    
    public void clearParentScope() {
        this.parentScope = null;
    }
    
    public List<Scope> getChildScopes() {
        return this.childScopes;
    }
    
    public void addChildScope(final Scope child) {
        if (this.childScopes == null) {
            this.childScopes = new ArrayList<Scope>();
        }
        this.childScopes.add(child);
        child.setParentScope(this);
    }
    
    public void replaceWith(final Scope newScope) {
        if (this.childScopes != null) {
            for (final Scope kid : this.childScopes) {
                newScope.addChildScope(kid);
            }
            this.childScopes.clear();
            this.childScopes = null;
        }
        if (this.symbolTable != null && !this.symbolTable.isEmpty()) {
            joinScopes(this, newScope);
        }
    }
    
    public ScriptNode getTop() {
        return this.top;
    }
    
    public void setTop(final ScriptNode top) {
        this.top = top;
    }
    
    public static Scope splitScope(final Scope scope) {
        final Scope result = new Scope(scope.getType());
        result.symbolTable = scope.symbolTable;
        scope.symbolTable = null;
        result.parent = scope.parent;
        result.setParentScope(scope.getParentScope());
        result.setParentScope(result);
        scope.parent = (AstNode)result;
        result.top = scope.top;
        return result;
    }
    
    public static void joinScopes(final Scope source, final Scope dest) {
        final Map<String, Symbol> src = source.ensureSymbolTable();
        final Map<String, Symbol> dst = dest.ensureSymbolTable();
        if (!Collections.disjoint(src.keySet(), dst.keySet())) {
            codeBug();
        }
        for (final Map.Entry<String, Symbol> entry : src.entrySet()) {
            final Symbol sym = entry.getValue();
            sym.setContainingTable(dest);
            dst.put(entry.getKey(), sym);
        }
    }
    
    public Scope getDefiningScope(final String name) {
        for (Scope s = this; s != null; s = s.parentScope) {
            final Map<String, Symbol> symbolTable = s.getSymbolTable();
            if (symbolTable != null && symbolTable.containsKey(name)) {
                return s;
            }
        }
        return null;
    }
    
    public Symbol getSymbol(final String name) {
        return (this.symbolTable == null) ? null : this.symbolTable.get(name);
    }
    
    public void putSymbol(final Symbol symbol) {
        if (symbol.getName() == null) {
            throw new IllegalArgumentException("null symbol name");
        }
        this.ensureSymbolTable();
        this.symbolTable.put(symbol.getName(), symbol);
        symbol.setContainingTable(this);
        this.top.addSymbol(symbol);
    }
    
    public void setHasRest() {
        this.top.setHasRest();
    }
    
    public Map<String, Symbol> getSymbolTable() {
        return this.symbolTable;
    }
    
    public void setSymbolTable(final Map<String, Symbol> table) {
        this.symbolTable = table;
    }
    
    private Map<String, Symbol> ensureSymbolTable() {
        if (this.symbolTable == null) {
            this.symbolTable = new LinkedHashMap<String, Symbol>(5);
        }
        return this.symbolTable;
    }
    
    public List<AstNode> getStatements() {
        final List<AstNode> stmts = new ArrayList<AstNode>();
        for (Node n = this.getFirstChild(); n != null; n = n.getNext()) {
            stmts.add((AstNode)n);
        }
        return stmts;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.makeIndent(depth));
        sb.append("{\n");
        for (final Node kid : this) {
            final AstNode astNodeKid = (AstNode)kid;
            sb.append(astNodeKid.toSource(depth + 1));
            if (astNodeKid.getType() == 166) {
                sb.append("\n");
            }
        }
        sb.append(this.makeIndent(depth));
        sb.append("}\n");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            for (final Node kid : this) {
                ((AstNode)kid).visit(v);
            }
        }
    }
}
