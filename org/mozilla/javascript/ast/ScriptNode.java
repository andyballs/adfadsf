//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class ScriptNode extends Scope
{
    private int encodedSourceStart;
    private int encodedSourceEnd;
    private String sourceName;
    private String encodedSource;
    private int endLineno;
    private List<FunctionNode> functions;
    private List<RegExpLiteral> regexps;
    private List<FunctionNode> EMPTY_LIST;
    private List<Symbol> symbols;
    private int paramCount;
    private boolean hasRest;
    private String[] variableNames;
    private boolean[] isConsts;
    private boolean[] isLexical;
    private Object compilerData;
    private int tempNumber;
    private boolean inStrictMode;
    
    public ScriptNode() {
        this.encodedSourceStart = -1;
        this.encodedSourceEnd = -1;
        this.endLineno = -1;
        this.EMPTY_LIST = Collections.emptyList();
        this.symbols = new ArrayList<Symbol>(4);
        this.paramCount = 0;
        this.hasRest = false;
        this.tempNumber = 0;
        this.top = this;
        this.type = 146;
    }
    
    public ScriptNode(final int pos) {
        super(pos);
        this.encodedSourceStart = -1;
        this.encodedSourceEnd = -1;
        this.endLineno = -1;
        this.EMPTY_LIST = Collections.emptyList();
        this.symbols = new ArrayList<Symbol>(4);
        this.paramCount = 0;
        this.hasRest = false;
        this.tempNumber = 0;
        this.top = this;
        this.type = 146;
    }
    
    public String getSourceName() {
        return this.sourceName;
    }
    
    public void setSourceName(final String sourceName) {
        this.sourceName = sourceName;
    }
    
    public int getEncodedSourceStart() {
        return this.encodedSourceStart;
    }
    
    public void setEncodedSourceStart(final int start) {
        this.encodedSourceStart = start;
    }
    
    public int getEncodedSourceEnd() {
        return this.encodedSourceEnd;
    }
    
    public void setEncodedSourceEnd(final int end) {
        this.encodedSourceEnd = end;
    }
    
    public void setEncodedSourceBounds(final int start, final int end) {
        this.encodedSourceStart = start;
        this.encodedSourceEnd = end;
    }
    
    public void setEncodedSource(final String encodedSource) {
        this.encodedSource = encodedSource;
    }
    
    public String getEncodedSource() {
        return this.encodedSource;
    }
    
    public int getBaseLineno() {
        return this.lineno;
    }
    
    public void setBaseLineno(final int lineno) {
        if (lineno < 0 || this.lineno >= 0) {
            codeBug();
        }
        this.lineno = lineno;
    }
    
    public int getEndLineno() {
        return this.endLineno;
    }
    
    public void setEndLineno(final int lineno) {
        if (lineno < 0 || this.endLineno >= 0) {
            codeBug();
        }
        this.endLineno = lineno;
    }
    
    public int getFunctionCount() {
        return (this.functions == null) ? 0 : this.functions.size();
    }
    
    public FunctionNode getFunctionNode(final int i) {
        if (this.functions == null) {
            throw Kit.codeBug("FunctionNode requested from Node that has no attached functions");
        }
        return this.functions.get(i);
    }
    
    public List<FunctionNode> getFunctions() {
        return (this.functions == null) ? this.EMPTY_LIST : this.functions;
    }
    
    public int addFunction(final FunctionNode fnNode) {
        if (fnNode == null) {
            codeBug();
        }
        if (this.functions == null) {
            this.functions = new ArrayList<FunctionNode>();
        }
        this.functions.add(fnNode);
        return this.functions.size() - 1;
    }
    
    public int getRegexpCount() {
        return (this.regexps == null) ? 0 : this.regexps.size();
    }
    
    public String getRegexpString(final int index) {
        return this.regexps.get(index).getValue();
    }
    
    public String getRegexpFlags(final int index) {
        return this.regexps.get(index).getFlags();
    }
    
    public void addRegExp(final RegExpLiteral re) {
        if (re == null) {
            codeBug();
        }
        if (this.regexps == null) {
            this.regexps = new ArrayList<RegExpLiteral>();
        }
        this.regexps.add(re);
        re.putIntProp(4, this.regexps.size() - 1);
    }
    
    public int getIndexForNameNode(final Node nameNode) {
        if (this.variableNames == null) {
            codeBug();
        }
        final Scope node = nameNode.getScope();
        final Symbol symbol = (node == null) ? null : node.getSymbol(((Name)nameNode).getIdentifier());
        return (symbol == null) ? -1 : symbol.getIndex();
    }
    
    public String getParamOrVarName(final int index) {
        if (this.variableNames == null) {
            codeBug();
        }
        return this.variableNames[index];
    }
    
    public int getParamCount() {
        return this.paramCount;
    }
    
    public int getParamAndVarCount() {
        if (this.variableNames == null) {
            codeBug();
        }
        return this.symbols.size();
    }
    
    public String[] getParamAndVarNames() {
        if (this.variableNames == null) {
            codeBug();
        }
        return this.variableNames;
    }
    
    public boolean[] getParamAndVarConst() {
        if (this.variableNames == null) {
            codeBug();
        }
        return this.isConsts;
    }
    
    public boolean[] getParamAndVarLexical() {
        if (this.variableNames == null) {
            codeBug();
        }
        return this.isLexical;
    }
    
    void addSymbol(final Symbol symbol) {
        if (this.variableNames != null) {
            codeBug();
        }
        if (symbol.getDeclType() == 84) {
            ++this.paramCount;
        }
        this.symbols.add(symbol);
    }
    
    public List<Symbol> getSymbols() {
        return this.symbols;
    }
    
    public void setSymbols(final List<Symbol> symbols) {
        this.symbols = symbols;
    }
    
    public void setHasRest() {
        this.hasRest = true;
    }
    
    public boolean hasRest() {
        return this.hasRest;
    }
    
    public void flattenSymbolTable(final boolean flattenAllTables) {
        if (!flattenAllTables) {
            final List<Symbol> newSymbols = new ArrayList<Symbol>();
            if (this.symbolTable != null) {
                for (int i = 0; i < this.symbols.size(); ++i) {
                    final Symbol symbol = this.symbols.get(i);
                    if (symbol.getContainingTable() == this) {
                        newSymbols.add(symbol);
                    }
                }
            }
            this.symbols = newSymbols;
        }
        this.variableNames = new String[this.symbols.size()];
        this.isConsts = new boolean[this.symbols.size()];
        this.isLexical = new boolean[this.symbols.size()];
        for (int j = 0; j < this.symbols.size(); ++j) {
            final Symbol symbol2 = this.symbols.get(j);
            this.variableNames[j] = symbol2.getName();
            final int declType = symbol2.getDeclType();
            this.isConsts[j] = (declType == 159);
            this.isLexical[j] = (declType == 159 || declType == 158 || declType == 115 || declType == 84);
            symbol2.setIndex(j);
        }
    }
    
    public Object getCompilerData() {
        return this.compilerData;
    }
    
    public void setCompilerData(final Object data) {
        this.assertNotNull(data);
        if (this.compilerData != null) {
            throw new IllegalStateException();
        }
        this.compilerData = data;
    }
    
    public String getNextTempName() {
        return "$" + this.tempNumber++;
    }
    
    public void setInStrictMode(final boolean inStrictMode) {
        this.inStrictMode = inStrictMode;
    }
    
    public boolean isInStrictMode() {
        return this.inStrictMode;
    }
    
    public void visit(final NodeVisitor v) {
        if (v.visit((AstNode)this)) {
            for (final Node kid : this) {
                ((AstNode)kid).visit(v);
            }
        }
    }
}
