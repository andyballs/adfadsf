//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;
import org.mozilla.javascript.decorators.*;
import org.mozilla.javascript.tools.shell.*;
import java.util.*;
import org.mozilla.javascript.ast.*;

public class Parser
{
    public static final int ARGC_LIMIT = 65536;
    static final int CLEAR_TI_MASK = 65535;
    static final int TI_AFTER_EOL = 65536;
    static final int TI_CHECK_LABEL = 131072;
    private static final int PROP_ENTRY = 1;
    private static final int GET_ENTRY = 2;
    private static final int SET_ENTRY = 4;
    private static final int METHOD_ENTRY = 8;
    private static final int GENERATOR_ENTRY = 16;
    private static final int FIELD_ENTRY = 32;
    protected int nestingOfFunction;
    protected boolean inUseStrictDirective;
    protected boolean insideClass;
    private Set<String> privateClassIdentifiers;
    private Map<String, TokenStream.TokenPosition> accessedPrivateClassIdentifiers;
    CompilerEnvirons compilerEnv;
    boolean calledByCompileFunction;
    ScriptNode currentScriptOrFn;
    Scope currentScope;
    private int scopeNesting;
    private ErrorReporter errorReporter;
    private IdeErrorReporter errorCollector;
    private String sourceURI;
    private char[] sourceChars;
    private boolean parseFinished;
    private TokenStream ts;
    private int currentFlaggedToken;
    private int currentToken;
    private int syntaxErrorCount;
    private List<Comment> scannedComments;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    private boolean inDestructuringAssignment;
    private boolean assumeDestructuring;
    private int endFlags;
    private boolean inForInit;
    private Map<String, LabeledStatement> labelSet;
    private List<Loop> loopSet;
    private List<Jump> loopAndSwitchSet;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private int prevNameTokenLineno;
    private boolean defaultUseStrictDirective;
    
    public Parser() {
        this(new CompilerEnvirons());
    }
    
    public Parser(final CompilerEnvirons compilerEnv) {
        this(compilerEnv, compilerEnv.getErrorReporter());
    }
    
    public Parser(final CompilerEnvirons compilerEnv, final ErrorReporter errorReporter) {
        this.privateClassIdentifiers = new HashSet<String>();
        this.accessedPrivateClassIdentifiers = new HashMap<String, TokenStream.TokenPosition>();
        this.scopeNesting = 0;
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnv;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter)errorReporter;
        }
    }
    
    private static boolean nowAllSet(final int before, final int after, final int mask) {
        return (before & mask) != mask && (after & mask) == mask;
    }
    
    void addStrictWarning(final String messageId, final String messageArg) {
        int beg = -1;
        int end = -1;
        if (this.ts != null) {
            beg = this.ts.tokenBeg;
            end = this.ts.tokenEnd - this.ts.tokenBeg;
        }
        this.addStrictWarning(messageId, messageArg, beg, end);
    }
    
    void addStrictWarning(final String messageId, final String messageArg, final int position, final int length) {
        if (this.compilerEnv.isStrictMode()) {
            this.addWarning(messageId, messageArg, position, length);
        }
    }
    
    void addWarning(final String messageId, final String messageArg) {
        int beg = -1;
        int end = -1;
        if (this.ts != null) {
            beg = this.ts.tokenBeg;
            end = this.ts.tokenEnd - this.ts.tokenBeg;
        }
        this.addWarning(messageId, messageArg, beg, end);
    }
    
    void addWarning(final String messageId, final int position, final int length) {
        this.addWarning(messageId, null, position, length);
    }
    
    void addWarning(final String messageId, final String messageArg, final int position, final int length) {
        final String message = this.lookupMessage(messageId, messageArg);
        if (this.compilerEnv.reportWarningAsError()) {
            this.addError(messageId, messageArg, position, length);
        }
        else if (this.errorCollector != null) {
            this.errorCollector.warning(message, this.sourceURI, position, length);
        }
        else {
            this.errorReporter.warning(message, this.sourceURI, this.ts.getLineno(), this.ts.getLine(), this.ts.getOffset());
        }
    }
    
    void addError(final String messageId) {
        this.addError(messageId, null, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }
    
    void addError(final String messageId, final int c) {
        final String messageArg = Character.toString((char)c);
        this.addError(messageId, messageArg, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }
    
    void addError(final String messageId, final String messageArg, final int position, final int length) {
        ++this.syntaxErrorCount;
        final String message = this.lookupMessage(messageId, messageArg);
        if (this.errorCollector != null) {
            this.errorCollector.error(message, this.sourceURI, position, length);
        }
        else {
            int lineno = 1;
            int offset = 1;
            String line = "";
            if (this.ts != null) {
                lineno = this.ts.getLineno();
                line = this.ts.getLine();
                offset = this.ts.getOffset();
            }
            this.errorReporter.error(message, this.sourceURI, lineno, line, offset);
        }
    }
    
    private void addStrictWarning(final String messageId, final String messageArg, final int position, final int length, final int line, final String lineSource, final int lineOffset) {
        if (this.compilerEnv.isStrictMode()) {
            this.addWarning(messageId, messageArg, position, length, line, lineSource, lineOffset);
        }
    }
    
    private void addWarning(final String messageId, final String messageArg, final int position, final int length, final int line, final String lineSource, final int lineOffset) {
        final String message = this.lookupMessage(messageId, messageArg);
        if (this.compilerEnv.reportWarningAsError()) {
            this.addError(messageId, messageArg, position, length, line, lineSource, lineOffset);
        }
        else if (this.errorCollector != null) {
            this.errorCollector.warning(message, this.sourceURI, position, length);
        }
        else {
            this.errorReporter.warning(message, this.sourceURI, line, lineSource, lineOffset);
        }
    }
    
    private void addError(final String messageId, final String messageArg, final int position, final int length, final int line, final String lineSource, final int lineOffset) {
        ++this.syntaxErrorCount;
        final String message = this.lookupMessage(messageId, messageArg);
        if (this.errorCollector != null) {
            this.errorCollector.error(message, this.sourceURI, position, length);
        }
        else {
            this.errorReporter.error(message, this.sourceURI, line, lineSource, lineOffset);
        }
    }
    
    String lookupMessage(final String messageId) {
        return this.lookupMessage(messageId, null);
    }
    
    String lookupMessage(final String messageId, final String messageArg) {
        return (messageArg == null) ? ScriptRuntime.getMessage0(messageId) : ScriptRuntime.getMessage1(messageId, messageArg);
    }
    
    void reportError(final String messageId) {
        this.reportError(messageId, null);
    }
    
    void reportError(final String messageId, final String messageArg) {
        if (this.ts == null) {
            this.addError(messageId, messageArg, 1, 1);
        }
        else {
            this.addError(messageId, messageArg, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
        }
    }
    
    void reportError(final String messageId, final int position, final int length) {
        this.addError(messageId, null, position, length);
    }
    
    private int getNodeEnd(final AstNode n) {
        return n.getPosition() + n.getLength();
    }
    
    private void recordComment(final int lineno, final String comment) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList<Comment>();
        }
        final Comment commentNode = new Comment(this.ts.tokenBeg, this.ts.getTokenLength(), this.ts.commentType, comment);
        if (this.ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            (this.currentJsDocComment = new Comment(this.ts.tokenBeg, this.ts.getTokenLength(), this.ts.commentType, comment)).setLineno(lineno);
        }
        commentNode.setLineno(lineno);
        this.scannedComments.add(commentNode);
    }
    
    private Comment getAndResetJsDoc() {
        final Comment saved = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return saved;
    }
    
    private int getNumberOfEols(final String comment) {
        int lines = 0;
        for (int i = comment.length() - 1; i >= 0; --i) {
            if (comment.charAt(i) == '\n') {
                ++lines;
            }
        }
        return lines;
    }
    
    private int peekToken() throws IOException {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.ts.getLineno();
        int tt = this.ts.getToken();
        boolean sawEOL = false;
        while (tt == 1 || tt == 166) {
            if (tt == 1) {
                ++lineno;
                sawEOL = true;
                tt = this.ts.getToken();
            }
            else {
                if (this.compilerEnv.isRecordingComments()) {
                    final String comment = this.ts.getAndResetCurrentComment();
                    this.recordComment(lineno, comment);
                    lineno += this.getNumberOfEols(comment);
                    break;
                }
                tt = this.ts.getToken();
            }
        }
        this.currentToken = tt;
        this.currentFlaggedToken = (tt | (sawEOL ? 65536 : 0));
        return this.currentToken;
    }
    
    private int peekFlaggedToken() throws IOException {
        this.peekToken();
        return this.currentFlaggedToken;
    }
    
    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }
    
    private int nextToken() throws IOException {
        final int tt = this.peekToken();
        this.consumeToken();
        return tt;
    }
    
    private boolean matchToken(final int toMatch) throws IOException {
        int tt;
        for (tt = this.peekToken(); tt == 166; tt = this.peekToken()) {
            this.consumeToken();
        }
        if (tt != toMatch) {
            return false;
        }
        this.consumeToken();
        return true;
    }
    
    private int peekTokenOrEOL() throws IOException {
        int tt = this.peekToken();
        if ((this.currentFlaggedToken & 0x10000) != 0x0) {
            tt = 1;
        }
        return tt;
    }
    
    private boolean mustMatchToken(final int toMatch, final String messageId) throws IOException {
        return this.mustMatchToken(toMatch, messageId, this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
    }
    
    private boolean mustMatchToken(final int toMatch, final String msgId, final int pos, final int len) throws IOException {
        if (this.matchToken(toMatch)) {
            return true;
        }
        this.reportError(msgId, pos, len);
        return false;
    }
    
    public boolean eof() {
        return this.ts.eof();
    }
    
    boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }
    
    void pushScope(final Scope scope) {
        ++this.scopeNesting;
        final Scope parent = scope.getParentScope();
        if (parent != null) {
            if (parent != this.currentScope) {
                this.codeBug();
            }
        }
        else {
            this.currentScope.addChildScope(scope);
        }
        this.currentScope = scope;
    }
    
    void popScope() {
        this.currentScope = this.currentScope.getParentScope();
        --this.scopeNesting;
    }
    
    private void enterLoop(final Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList<Loop>();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList<Jump>();
        }
        this.loopAndSwitchSet.add((Jump)loop);
        this.pushScope((Scope)loop);
        if (this.currentLabel != null) {
            this.currentLabel.setStatement((AstNode)loop);
            this.currentLabel.getFirstLabel().setLoop((Jump)loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }
    
    private void exitLoop() {
        final Loop loop = this.loopSet.remove(this.loopSet.size() - 1);
        this.loopAndSwitchSet.remove(this.loopAndSwitchSet.size() - 1);
        if (loop.getParent() != null) {
            loop.setRelative(loop.getParent().getPosition());
        }
        this.popScope();
    }
    
    private void enterSwitch(final SwitchStatement node) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList<Jump>();
        }
        this.loopAndSwitchSet.add((Jump)node);
    }
    
    private void exitSwitch() {
        this.loopAndSwitchSet.remove(this.loopAndSwitchSet.size() - 1);
    }
    
    public AstRoot parse(final String sourceString, final String sourceURI, final int lineno) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        this.sourceURI = sourceURI;
        if (this.compilerEnv.isIdeMode()) {
            this.sourceChars = sourceString.toCharArray();
        }
        this.ts = new TokenStream(this, null, sourceString, lineno);
        try {
            return this.parse();
        }
        catch (IOException iox) {
            throw new IllegalStateException();
        }
        finally {
            this.parseFinished = true;
        }
    }
    
    @Deprecated
    public AstRoot parse(final Reader sourceReader, final String sourceURI, final int lineno) throws IOException {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        if (this.compilerEnv.isIdeMode()) {
            return this.parse(Kit.readReader(sourceReader), sourceURI, lineno);
        }
        try {
            this.sourceURI = sourceURI;
            this.ts = new TokenStream(this, sourceReader, null, lineno);
            return this.parse();
        }
        finally {
            this.parseFinished = true;
        }
    }
    
    private AstRoot parse() throws IOException {
        final int pos = 0;
        final AstRoot astRoot;
        final AstRoot root = astRoot = new AstRoot(pos);
        this.currentScriptOrFn = (ScriptNode)astRoot;
        this.currentScope = (Scope)astRoot;
        final int baseLineno = this.ts.lineno;
        int end = pos;
        boolean inDirectivePrologue = true;
        final boolean savedStrictMode = this.inUseStrictDirective;
        this.inUseStrictDirective = this.defaultUseStrictDirective;
        Label_0061: {
            if (!this.inUseStrictDirective) {
                break Label_0061;
            }
            root.setInStrictMode(true);
            try {
                while (true) {
                    final int tt = this.peekToken();
                    if (tt <= 0) {
                        break;
                    }
                    AstNode n = null;
                    Label_0203: {
                        if (tt == 114) {
                            this.consumeToken();
                            try {
                                n = (AstNode)this.function(this.calledByCompileFunction ? 2 : 1);
                                break Label_0203;
                            }
                            catch (ParserException e) {
                                break;
                            }
                        }
                        if (tt == 166) {
                            n = (AstNode)this.scannedComments.get(this.scannedComments.size() - 1);
                            this.consumeToken();
                        }
                        else {
                            n = this.statement();
                            if (inDirectivePrologue) {
                                final String directive = this.getDirective(n);
                                if (directive == null) {
                                    inDirectivePrologue = false;
                                }
                                else if (directive.equals("use strict")) {
                                    root.setInStrictMode(this.inUseStrictDirective = true);
                                }
                            }
                        }
                    }
                    end = this.getNodeEnd(n);
                    root.addChildToBack((Node)n);
                    n.setParent((AstNode)root);
                }
            }
            catch (StackOverflowError ex) {
                final String msg = this.lookupMessage("msg.too.deep.parser.recursion");
                if (!this.compilerEnv.isIdeMode()) {
                    throw Context.reportRuntimeError(msg, this.sourceURI, this.ts.lineno, (String)null, 0);
                }
            }
            finally {
                this.inUseStrictDirective = savedStrictMode;
            }
        }
        if (this.syntaxErrorCount != 0) {
            String msg2 = String.valueOf(this.syntaxErrorCount);
            msg2 = this.lookupMessage("msg.got.syntax.errors", msg2);
            if (!this.compilerEnv.isIdeMode()) {
                throw this.errorReporter.runtimeError(msg2, this.sourceURI, baseLineno, (String)null, 0);
            }
        }
        if (this.scannedComments != null) {
            final int last = this.scannedComments.size() - 1;
            end = Math.max(end, this.getNodeEnd((AstNode)this.scannedComments.get(last)));
            for (final Comment c : this.scannedComments) {
                root.addComment(c);
            }
        }
        root.setLength(end - pos);
        root.setSourceName(this.sourceURI);
        root.setBaseLineno(baseLineno);
        root.setEndLineno(this.ts.lineno);
        return root;
    }
    
    private AstNode parseFunctionBody(final int type, final FunctionNode fnNode) throws IOException {
        boolean isExpressionClosure = false;
        if (!this.matchToken(82)) {
            if (this.compilerEnv.getLanguageVersion() < 180 && type != 4) {
                this.reportError("msg.no.brace.body");
            }
            else {
                isExpressionClosure = true;
            }
        }
        final boolean isArrow = type == 4;
        ++this.nestingOfFunction;
        final int pos = this.ts.tokenBeg;
        final Block pn = new Block(pos);
        boolean inDirectivePrologue = true;
        final boolean savedStrictMode = this.inUseStrictDirective;
        pn.setLineno(this.ts.lineno);
        try {
            if (isExpressionClosure) {
                final AstNode returnValue = this.assignExpr();
                final ReturnStatement n = new ReturnStatement(returnValue.getPosition(), returnValue.getLength(), returnValue);
                n.putProp(25, (Object)Boolean.TRUE);
                pn.putProp(25, (Object)Boolean.TRUE);
                if (isArrow) {
                    n.putProp(27, (Object)Boolean.TRUE);
                }
                pn.addStatement((AstNode)n);
            }
            else {
            Label_0240:
                while (true) {
                    final int tt = this.peekToken();
                    AstNode n2 = null;
                    switch (tt) {
                        case -1:
                        case 0:
                        case 83: {
                            break Label_0240;
                        }
                        case 166: {
                            this.consumeToken();
                            n2 = (AstNode)this.scannedComments.get(this.scannedComments.size() - 1);
                            break;
                        }
                        case 114: {
                            this.consumeToken();
                            n2 = (AstNode)this.function(1);
                            break;
                        }
                        default: {
                            n2 = this.statement();
                            if (!inDirectivePrologue) {
                                break;
                            }
                            final String directive = this.getDirective(n2);
                            if (directive == null) {
                                inDirectivePrologue = false;
                                break;
                            }
                            if (!directive.equals("use strict")) {
                                break;
                            }
                            if (fnNode.hasComplexParameters()) {
                                this.reportError("msg.complex.params.in.strict");
                            }
                            fnNode.setInStrictMode(this.inUseStrictDirective = true);
                            if (!savedStrictMode) {
                                this.setRequiresActivation();
                                break;
                            }
                            break;
                        }
                    }
                    pn.addStatement(n2);
                }
            }
        }
        catch (ParserException ex) {}
        finally {
            --this.nestingOfFunction;
            this.inUseStrictDirective = savedStrictMode;
        }
        int end = this.ts.tokenEnd;
        this.getAndResetJsDoc();
        if (!isExpressionClosure && this.mustMatchToken(83, "msg.no.brace.after.body")) {
            end = this.ts.tokenEnd;
        }
        pn.setLength(end - pos);
        return (AstNode)pn;
    }
    
    private String getDirective(final AstNode n) {
        if (n instanceof ExpressionStatement) {
            final AstNode e = ((ExpressionStatement)n).getExpression();
            if (e instanceof StringLiteral) {
                return ((StringLiteral)e).getValue();
            }
        }
        return null;
    }
    
    private ClassNode classExpr(final List<DecoratorNode> classDecorators) throws IOException {
        final Set<String> prevPrivateClassIdentifiers = this.privateClassIdentifiers;
        final Map<String, TokenStream.TokenPosition> prevAccessedPrivateClassIdentifiers = this.accessedPrivateClassIdentifiers;
        this.privateClassIdentifiers = new HashSet<String>();
        this.accessedPrivateClassIdentifiers = new HashMap<String, TokenStream.TokenPosition>();
        this.insideClass = true;
        final ClassNode cls = new ClassNode(this.ts.tokenBeg);
        cls.setDecorators((List)classDecorators);
        if (this.matchToken(40)) {
            final Name name = this.createNameNode();
            this.defineSymbol(115, name.getIdentifier());
            cls.setClassName(name);
        }
        if (this.matchToken(116)) {
            final AstNode extendsName = this.memberExpr(true);
            cls.setExtendsNode(extendsName);
        }
        this.mustMatchToken(82, "msg.class.missing.lc");
        final Set<String> getterNames = new HashSet<String>();
        final Set<String> setterNames = new HashSet<String>();
        final List<ClassMethod> classMethods = new ArrayList<ClassMethod>();
        final List<ClassField> classProperties = new ArrayList<ClassField>();
        while (true) {
            if (!this.matchToken(79)) {
                if (this.matchToken(1)) {
                    continue;
                }
                String propertyName = null;
                int entryKind = 1;
                int tt = this.peekToken();
                final Comment jsdocNode = this.getAndResetJsDoc();
                if (tt == 166) {
                    this.consumeToken();
                    tt = this.peekUntilNonComment(tt);
                }
                if (tt == 83) {
                    this.consumeToken();
                    break;
                }
                final List<DecoratorNode> decorators = new ArrayList<DecoratorNode>();
                while (this.matchToken(153)) {
                    decorators.add(this.decorator(false, false));
                }
                final boolean isStatic = this.matchToken(117);
                boolean isPrivate = this.matchToken(170);
                AstNode pname = this.objliteralProperty();
                final int pos = this.ts.tokenBeg;
                if (pname == null && this.peekToken() != 23) {
                    this.reportError("msg.bad.prop");
                    break;
                }
                propertyName = this.ts.getString();
                final int peeked = this.peekToken();
                if (peeked == 84) {
                    entryKind = 8;
                }
                else if (peeked == 23) {
                    entryKind = 16;
                    this.consumeToken();
                }
                else if (peeked == 79 || peeked == 87) {
                    entryKind = 32;
                }
                else if (pname.getType() == 40) {
                    if ("get".equals(propertyName)) {
                        entryKind = 2;
                    }
                    else if ("set".equals(propertyName)) {
                        entryKind = 4;
                    }
                    if (entryKind != 1) {
                        isPrivate = this.matchToken(170);
                    }
                }
                if (entryKind == 2 || entryKind == 4 || entryKind == 16) {
                    pname = this.objliteralProperty();
                    if (pname == null) {
                        this.reportError("msg.bad.prop");
                    }
                    this.consumeToken();
                }
                if (pname == null) {
                    throw Kit.codeBug();
                }
                propertyName = this.ts.getString();
                if (entryKind == 32) {
                    if ("constructor".equals(propertyName)) {
                        this.reportError("msg.class.ctor.as.field");
                    }
                    if (decorators.stream().anyMatch(it -> DecoratorType.WRAP == it.getDecoratorType())) {
                        this.reportError("msg.decorator.wrap.on.field");
                    }
                    AstNode defaultValue = null;
                    final int token = this.peekTokenOrEOL();
                    if (token == 87) {
                        this.consumeToken();
                        defaultValue = this.expr();
                    }
                    else if (token != 79 && token != 1) {
                        throw Kit.codeBug();
                    }
                    if (defaultValue == null) {
                        defaultValue = (AstNode)new Name(this.ts.tokenBeg, "undefined");
                    }
                    final ClassField cp = new ClassField(pname, defaultValue);
                    if (isStatic) {
                        cp.setIsStatic();
                    }
                    if (isPrivate) {
                        cp.setIsPrivate();
                        this.privateClassIdentifiers.add(((Name)cp.getName()).getIdentifier());
                    }
                    cp.setLength(this.getNodeEnd(defaultValue) - pos);
                    cp.setDecorators((List)decorators);
                    classProperties.add(cp);
                }
                else {
                    final FunctionNode fn = this.function(2, entryKind);
                    final Name name2 = fn.getFunctionName();
                    if (name2 != null && name2.length() != 0) {
                        this.reportError("msg.bad.prop");
                    }
                    if (pname instanceof Name) {
                        fn.setFunctionName((Name)pname);
                    }
                    pname.setJsDocNode(jsdocNode);
                    if (isStatic) {
                        fn.setStatic(true);
                    }
                    if (isPrivate) {
                        fn.setPrivate(true);
                        this.privateClassIdentifiers.add(fn.getName());
                    }
                    final ClassMethod cm = new ClassMethod(pname, fn);
                    cm.setDecorators((List)decorators);
                    switch (entryKind) {
                        case 2: {
                            fn.setFunctionIsGetterMethod();
                            cm.setIsGetterMethod();
                            break;
                        }
                        case 4: {
                            fn.setFunctionIsSetterMethod();
                            cm.setIsSetterMethod();
                            break;
                        }
                        case 8: {
                            fn.setFunctionIsNormalMethod();
                            break;
                        }
                    }
                    if (isStatic) {
                        cm.setIsStatic();
                    }
                    if (isPrivate) {
                        cm.setIsPrivate();
                    }
                    final int end = this.getNodeEnd((AstNode)fn);
                    cm.setLength(end - pos);
                    if ("constructor".equals(propertyName)) {
                        cls.setConstructor(fn);
                    }
                    else {
                        classMethods.add(cm);
                    }
                }
                if (this.inUseStrictDirective && propertyName != null) {
                    switch (entryKind) {
                        case 1:
                        case 8: {
                            getterNames.add(propertyName);
                            setterNames.add(propertyName);
                            break;
                        }
                        case 2: {
                            getterNames.add(propertyName);
                            break;
                        }
                        case 4: {
                            setterNames.add(propertyName);
                            break;
                        }
                    }
                }
                this.getAndResetJsDoc();
            }
        }
        for (final Map.Entry<String, TokenStream.TokenPosition> en : this.accessedPrivateClassIdentifiers.entrySet()) {
            if (!this.privateClassIdentifiers.contains(en.getKey())) {
                final TokenStream.TokenPosition pos2 = en.getValue();
                this.addError("msg.unknown.private.ident", en.getKey(), pos2.start, pos2.length, pos2.lineno, pos2.line, pos2.colno);
                break;
            }
        }
        cls.setFields((List)classProperties);
        cls.setMethods((List)classMethods);
        this.insideClass = false;
        this.privateClassIdentifiers = prevPrivateClassIdentifiers;
        this.accessedPrivateClassIdentifiers = prevAccessedPrivateClassIdentifiers;
        return cls;
    }
    
    private void parseFunctionParams(final FunctionNode fnNode, final boolean isObjectSetterFunction) throws IOException {
        if (this.matchToken(85)) {
            fnNode.setRp(this.ts.tokenBeg - fnNode.getPosition());
            return;
        }
        final VariableDeclaration vd = this.variables(84, this.ts.tokenEnd, false, true, isObjectSetterFunction);
        final List<VariableInitializer> variables = (List<VariableInitializer>)vd.getVariables();
        final Node destructuringNode = new Node(86);
        final Map<String, VariableInitializer> destructVars = new HashMap<String, VariableInitializer>();
        for (int i1 = 0, variablesSize = variables.size(); i1 < variablesSize; ++i1) {
            final VariableInitializer variable = variables.get(i1);
            final AstNode target = variable.getTarget();
            final AstNode initializer = variable.getInitializer();
            fnNode.addParam(target);
            if (initializer != null) {
                fnNode.addDefaultParam(i1, initializer);
                fnNode.setHasComplexParameters();
            }
            if (variable.isDestructuring()) {
                final String tempName = this.currentScriptOrFn.getNextTempName();
                this.defineSymbol(84, tempName, false);
                destructVars.put(tempName, variable);
                fnNode.setHasComplexParameters();
            }
            if (target.getProp(29) != null) {
                fnNode.setHasComplexParameters();
            }
        }
        for (final Map.Entry<String, VariableInitializer> destructure : destructVars.entrySet()) {
            final Node assign = this.createDestructuringAssignment(158, (Node)destructure.getValue().getTarget(), this.createName(destructure.getKey()));
            destructuringNode.addChildToBack(assign);
        }
        if (destructuringNode.hasChildren()) {
            fnNode.putProp(23, (Object)destructuringNode);
        }
        if (this.mustMatchToken(85, "msg.no.paren.after.parms")) {
            fnNode.setRp(this.ts.tokenBeg - fnNode.getPosition());
        }
    }
    
    private FunctionNode function(final int type) throws IOException {
        return this.function(type, 0);
    }
    
    private FunctionNode function(final int type, final int objEntryKind) throws IOException {
        final int syntheticType = type;
        final int baseLineno = this.ts.lineno;
        final int functionSourceStart = this.ts.tokenBeg;
        Name name = null;
        boolean generator = objEntryKind == 16;
        if (this.matchToken(23)) {
            generator = true;
        }
        if (this.matchToken(40)) {
            name = this.createNameNode(true, 40);
            if (this.inUseStrictDirective) {
                final String id = name.getIdentifier();
                if ("eval".equals(id) || "arguments".equals(id)) {
                    this.reportError("msg.bad.id.strict", id);
                }
            }
            if (!this.matchToken(84)) {
                this.mustMatchToken(84, "msg.no.paren.parms");
            }
        }
        else if (!this.matchToken(84)) {
            this.mustMatchToken(84, "msg.no.paren.parms");
        }
        final int lpPos = (this.currentToken == 84) ? this.ts.tokenBeg : -1;
        if (syntheticType != 2 && name != null && name.length() > 0) {
            this.defineSymbol(114, name.getIdentifier());
        }
        final FunctionNode fnNode = new FunctionNode(functionSourceStart, name);
        fnNode.setFunctionType(type);
        if (generator) {
            fnNode.setIsGenerator();
        }
        if (lpPos != -1) {
            fnNode.setLp(lpPos - functionSourceStart);
        }
        fnNode.setJsDocNode(this.getAndResetJsDoc());
        final PerFunctionVariables savedVars = new PerFunctionVariables(fnNode);
        try {
            this.parseFunctionParams(fnNode, objEntryKind == 4);
            fnNode.setBody(this.parseFunctionBody(type, fnNode));
            fnNode.setEncodedSourceBounds(functionSourceStart, this.ts.tokenEnd);
            fnNode.setLength(this.ts.tokenEnd - functionSourceStart);
            if (this.compilerEnv.isStrictMode() && !fnNode.getBody().hasConsistentReturnUsage()) {
                final String msg = (name != null && name.length() > 0) ? "msg.no.return.value" : "msg.anon.no.return.value";
                this.addStrictWarning(msg, (name == null) ? "" : name.getIdentifier());
            }
        }
        finally {
            savedVars.restore();
        }
        fnNode.setSourceName(this.sourceURI);
        fnNode.setBaseLineno(baseLineno);
        fnNode.setEndLineno(this.ts.lineno);
        if (this.compilerEnv.isIdeMode()) {
            fnNode.setParentScope(this.currentScope);
        }
        return fnNode;
    }
    
    private AstNode arrowFunction(final AstNode params) throws IOException {
        final int baseLineno = this.ts.lineno;
        final int functionSourceStart = (params != null) ? params.getPosition() : -1;
        final FunctionNode fnNode = new FunctionNode(functionSourceStart);
        fnNode.setFunctionType(4);
        fnNode.setJsDocNode(this.getAndResetJsDoc());
        final Map<String, Node> destructuring = new HashMap<String, Node>();
        final Set<String> paramNames = new HashSet<String>();
        final PerFunctionVariables savedVars = new PerFunctionVariables(fnNode);
        try {
            if (params instanceof ParenthesizedExpression) {
                fnNode.setParens(0, params.getLength());
                final AstNode p = ((ParenthesizedExpression)params).getExpression();
                if (!(p instanceof EmptyExpression)) {
                    this.arrowFunctionParams(fnNode, p, destructuring, paramNames);
                }
            }
            else {
                this.arrowFunctionParams(fnNode, params, destructuring, paramNames);
            }
            if (!destructuring.isEmpty()) {
                final Node destructuringNode = new Node(86);
                for (final Map.Entry<String, Node> param : destructuring.entrySet()) {
                    final Node assign = this.createDestructuringAssignment(131, param.getValue(), this.createName(param.getKey()));
                    destructuringNode.addChildToBack(assign);
                }
                fnNode.putProp(23, (Object)destructuringNode);
            }
            fnNode.setBody(this.parseFunctionBody(4, fnNode));
            fnNode.setEncodedSourceBounds(functionSourceStart, this.ts.tokenEnd);
            fnNode.setLength(this.ts.tokenEnd - functionSourceStart);
        }
        finally {
            savedVars.restore();
        }
        if (fnNode.isGenerator()) {
            this.reportError("msg.arrowfunction.generator");
            return (AstNode)this.makeErrorNode();
        }
        fnNode.setSourceName(this.sourceURI);
        fnNode.setBaseLineno(baseLineno);
        fnNode.setEndLineno(this.ts.lineno);
        return (AstNode)fnNode;
    }
    
    private void arrowFunctionParams(final FunctionNode fnNode, final AstNode params, final Map<String, Node> destructuring, final Set<String> paramNames) {
        if (params instanceof ArrayLiteral || params instanceof ObjectLiteral) {
            this.markDestructuring(params);
            fnNode.addParam(params);
            final String pname = this.currentScriptOrFn.getNextTempName();
            this.defineSymbol(84, pname, false);
            destructuring.put(pname, (Node)params);
        }
        else if (params instanceof InfixExpression && params.getType() == 86) {
            this.arrowFunctionParams(fnNode, ((InfixExpression)params).getLeft(), destructuring, paramNames);
            this.arrowFunctionParams(fnNode, ((InfixExpression)params).getRight(), destructuring, paramNames);
        }
        else if (params instanceof Name) {
            fnNode.addParam(params);
            final String paramName = ((Name)params).getIdentifier();
            this.defineSymbol(84, paramName);
            if (this.inUseStrictDirective) {
                if ("eval".equals(paramName) || "arguments".equals(paramName)) {
                    this.reportError("msg.bad.id.strict", paramName);
                }
                if (paramNames.contains(paramName)) {
                    this.reportError("msg.dup.param.strict", paramName);
                }
                paramNames.add(paramName);
            }
        }
        else if (params instanceof Assignment) {
            final int index = fnNode.getParams().size();
            final AstNode target = ((Assignment)params).getLeft();
            fnNode.addParam(target);
            if (target instanceof Name) {
                fnNode.addDefaultParam(index, ((Assignment)params).getRight());
                this.defineSymbol(84, ((Name)target).getIdentifier());
                fnNode.setHasComplexParameters();
            }
            else if (target instanceof ArrayLiteral || target instanceof ObjectLiteral) {
                this.reportError("msg.arrowfn.destructuring.unsupported");
            }
        }
        else {
            this.reportError("msg.no.parm", params.getPosition(), params.getLength());
            fnNode.addParam((AstNode)this.makeErrorNode());
        }
    }
    
    private AstNode statements(final AstNode parent) throws IOException {
        if (this.currentToken != 82 && !this.compilerEnv.isIdeMode()) {
            this.codeBug();
        }
        final int pos = this.ts.tokenBeg;
        final AstNode block = (AstNode)((parent != null) ? parent : new Block(pos));
        block.setLineno(this.ts.lineno);
        int tt;
        while ((tt = this.peekToken()) > 0 && tt != 83) {
            block.addChild(this.statement());
        }
        block.setLength(this.ts.tokenBeg - pos);
        return block;
    }
    
    private AstNode statements() throws IOException {
        return this.statements(null);
    }
    
    private ConditionData condition() throws IOException {
        final ConditionData data = new ConditionData();
        if (this.mustMatchToken(84, "msg.no.paren.cond")) {
            data.lp = this.ts.tokenBeg;
        }
        data.condition = this.expr();
        if (this.mustMatchToken(85, "msg.no.paren.after.cond")) {
            data.rp = this.ts.tokenBeg;
        }
        if (data.condition instanceof Assignment) {
            this.addStrictWarning("msg.equal.as.assign", "", data.condition.getPosition(), data.condition.getLength());
        }
        return data;
    }
    
    private AstNode statement() throws IOException {
        final int pos = this.ts.tokenBeg;
        try {
            final AstNode pn = this.statementHelper();
            if (pn != null) {
                if (this.compilerEnv.isStrictMode() && !pn.hasSideEffects()) {
                    int beg = pn.getPosition();
                    beg = Math.max(beg, this.lineBeginningFor(beg));
                    this.addStrictWarning((pn instanceof EmptyStatement) ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", beg, this.nodeEnd(pn) - beg);
                }
                final int ntt = this.peekToken();
                if (ntt == 166 && pn.getLineno() == this.scannedComments.get(this.scannedComments.size() - 1).getLineno()) {
                    pn.setInlineComment((AstNode)this.scannedComments.get(this.scannedComments.size() - 1));
                    this.consumeToken();
                }
                return pn;
            }
        }
        catch (ParserException ex) {}
    Label_0212:
        while (true) {
            final int tt = this.peekTokenOrEOL();
            this.consumeToken();
            switch (tt) {
                case -1:
                case 0:
                case 1:
                case 79: {
                    break Label_0212;
                }
                default: {
                    continue;
                }
            }
        }
        return (AstNode)new EmptyStatement(pos, this.ts.tokenBeg - pos);
    }
    
    private AstNode statementHelper() throws IOException {
        if (this.currentLabel != null && this.currentLabel.getStatement() != null) {
            this.currentLabel = null;
        }
        final int tt = this.peekToken();
        AstNode pn = null;
        switch (tt) {
            case 121: {
                return (AstNode)this.ifStatement();
            }
            case 123: {
                return (AstNode)this.switchStatement();
            }
            case 126: {
                return (AstNode)this.whileLoop();
            }
            case 127: {
                return (AstNode)this.doLoop();
            }
            case 128: {
                return (AstNode)this.forLoop();
            }
            case 78: {
                return (AstNode)this.tryStatement();
            }
            case 53: {
                pn = (AstNode)this.throwStatement();
                break;
            }
            case 135: {
                this.consumeToken();
                pn = (AstNode)this.decoratorDeclaration();
                break;
            }
            case 129: {
                pn = (AstNode)this.breakStatement();
                break;
            }
            case 130: {
                pn = (AstNode)this.continueStatement();
                break;
            }
            case 132: {
                if (this.inUseStrictDirective) {
                    this.reportError("msg.no.with.strict");
                }
                return (AstNode)this.withStatement();
            }
            case 131:
            case 159: {
                this.consumeToken();
                final int lineno = this.ts.lineno;
                pn = (AstNode)this.variables(this.currentToken, this.ts.tokenBeg, true);
                pn.setLineno(lineno);
                break;
            }
            case 158: {
                pn = this.letStatement();
                if (pn instanceof VariableDeclaration && this.peekToken() == 79) {
                    break;
                }
                return pn;
            }
            case 4:
            case 76: {
                pn = this.returnOrYield(tt, false);
                break;
            }
            case 165: {
                this.consumeToken();
                pn = (AstNode)new KeywordLiteral(this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg, tt);
                pn.setLineno(this.ts.lineno);
                break;
            }
            case 82: {
                return this.block();
            }
            case -1: {
                this.consumeToken();
                return (AstNode)this.makeErrorNode();
            }
            case 79: {
                this.consumeToken();
                final int pos = this.ts.tokenBeg;
                pn = (AstNode)new EmptyStatement(pos, this.ts.tokenEnd - pos);
                pn.setLineno(this.ts.lineno);
                return pn;
            }
            case 114: {
                this.consumeToken();
                return (AstNode)this.function(3);
            }
            case 120: {
                if (!Main.useRequire) {
                    this.reportError("msg.modules.not.supported");
                }
                this.consumeToken();
                pn = this.importStatement();
                break;
            }
            case 119: {
                if (!Main.useRequire) {
                    this.reportError("msg.modules.not.supported");
                }
                this.consumeToken();
                pn = this.exportStatement();
                break;
            }
            case 40: {
                pn = this.nameOrLabel();
                if (pn instanceof ExpressionStatement) {
                    break;
                }
                return pn;
            }
            case 166: {
                pn = (AstNode)this.scannedComments.get(this.scannedComments.size() - 1);
                return pn;
            }
            default: {
                final int lineno = this.ts.lineno;
                pn = (AstNode)new ExpressionStatement(this.expr(), !this.insideFunction());
                pn.setLineno(lineno);
                break;
            }
        }
        this.autoInsertSemicolon(pn);
        return pn;
    }
    
    private AstNode importStatement() throws IOException {
        if (this.scopeNesting != 0) {
            this.reportError("msg.import.top.level");
        }
        final ImportNode in = new ImportNode();
        boolean hasTargets;
        if (this.matchToken(23)) {
            hasTargets = true;
            this.peekToken();
            if (!"as".equals(this.ts.getString())) {
                this.reportError("msg.import.expected.as");
            }
            this.consumeToken();
            this.mustMatchToken(40, "msg.import.missing.alias");
            final String target = this.createNameNode().getIdentifier();
            in.setModuleMember(target);
            this.consumeToken();
        }
        else {
            boolean hasDefault = false;
            boolean defaultComma = false;
            if (this.matchToken(125)) {
                this.reportError("msg.import.invalid.default");
            }
            boolean decorator = this.matchToken(153);
            if (this.matchToken(40)) {
                String defaultImport = this.createNameNode().getIdentifier();
                if (decorator) {
                    defaultImport = "@" + defaultImport;
                }
                this.consumeToken();
                in.setDefaultMember(defaultImport);
                hasDefault = true;
                defaultComma = this.matchToken(86);
            }
            final boolean hasNamedImports = this.matchToken(82);
            if (hasDefault && defaultComma != hasNamedImports) {
                this.reportError(defaultComma ? "msg.import.unexpected.comma" : "msg.import.missing.comma");
            }
            if (hasNamedImports) {
                while (!this.matchToken(83)) {
                    decorator = this.matchToken(153);
                    String targetName;
                    if (this.matchToken(40)) {
                        targetName = this.createNameNode().getIdentifier();
                        if (decorator) {
                            targetName = "@" + targetName;
                        }
                    }
                    else {
                        if (!this.matchToken(125)) {
                            this.reportError("msg.import.malformed.name");
                            return (AstNode)this.makeErrorNode();
                        }
                        targetName = "default";
                    }
                    String scopeName = null;
                    if (this.matchToken(40)) {
                        if (!"as".equals(this.ts.getString())) {
                            this.reportError("msg.import.expected.as");
                        }
                        if (this.matchToken(125)) {
                            this.reportError("msg.import.invalid.default");
                        }
                        decorator = this.matchToken(153);
                        this.mustMatchToken(40, "msg.import.missing.alias");
                        scopeName = this.createNameNode().getIdentifier();
                        if (decorator) {
                            scopeName = "@" + scopeName;
                        }
                    }
                    this.matchToken(86);
                    in.addNamedMember(targetName, scopeName);
                }
            }
            hasTargets = (hasNamedImports || hasDefault);
        }
        this.peekToken();
        if (hasTargets) {
            if (!"from".equals(this.ts.getString())) {
                this.reportError("msg.import.missing.file.path");
            }
            this.consumeToken();
        }
        this.mustMatchToken(42, "msg.import.missing.file.path");
        in.setFilePath(this.ts.getString());
        return (AstNode)in;
    }
    
    private void validateDefaultExport(final AstNode node) {
        if (!(node instanceof FunctionNode) && !(node instanceof ClassNode) && !(node instanceof ConditionalExpression) && !(node instanceof Assignment)) {
            this.reportError("msg.export.invalid.default.export");
        }
    }
    
    private void validateExport(final AstNode node) {
        if (!(node instanceof VariableDeclaration) && !(node instanceof FunctionNode) && !(node instanceof ClassNode)) {
            this.reportError("msg.export.invalid.export");
        }
        if ((node instanceof FunctionNode && ((FunctionNode)node).getFunctionName() == null) || (node instanceof ClassNode && ((ClassNode)node).getClassName() == null)) {
            this.reportError("msg.export.no.identifier");
        }
    }
    
    private AstNode exportStatement() throws IOException {
        if (this.scopeNesting != 0) {
            this.reportError("msg.export.top.level");
        }
        final ExportNode en = new ExportNode();
        en.setType(119);
        if (this.matchToken(125)) {
            AstNode exportTarget;
            if (this.matchToken(114)) {
                exportTarget = (AstNode)this.function(2);
            }
            else if (this.matchToken(115)) {
                exportTarget = (AstNode)this.classExpr(Collections.emptyList());
            }
            else {
                exportTarget = this.assignExpr();
                if (exportTarget instanceof Name && "from".equals(((Name)exportTarget).getIdentifier())) {
                    if (this.matchToken(42)) {
                        en.addNamedMember("default", "default");
                        en.setFilePath(this.ts.getString());
                        exportTarget = null;
                    }
                }
                else if (exportTarget == null) {
                    this.reportError("msg.export.invalid.default.export");
                }
            }
            if (exportTarget != null) {
                en.setExportedValue(exportTarget);
            }
        }
        else if (this.matchToken(23)) {
            this.mustMatchToken(40, "msg.export.unexpected.char.after.wildcard");
            if (!"from".equals(this.ts.getString())) {
                this.reportError("msg.export.unexpected.char.after.wildcard");
            }
            this.mustMatchToken(42, "msg.export.star.missing.file.path");
            en.setFilePath(this.ts.getString());
        }
        else if (this.matchToken(82)) {
            do {
                boolean decorator = this.matchToken(153);
                String target;
                if (this.matchToken(125)) {
                    target = "default";
                }
                else {
                    this.mustMatchToken(40, "msg.export.missing.identifier");
                    target = this.createNameNode().getIdentifier();
                }
                if (decorator) {
                    target = "@" + target;
                }
                String scope = null;
                this.consumeToken();
                this.peekToken();
                if ("as".equals(this.ts.getString())) {
                    this.consumeToken();
                    decorator = this.matchToken(153);
                    if (this.matchToken(40)) {
                        scope = this.createNameNode().getIdentifier();
                        if (decorator) {
                            scope = "@" + scope;
                        }
                    }
                    else if (this.matchToken(125)) {
                        if (decorator) {
                            this.reportError("msg.export.invalid.default");
                        }
                        scope = "default";
                    }
                    else {
                        this.reportError("msg.export.unexpected.token");
                        this.consumeToken();
                    }
                }
                en.addNamedMember(target, scope);
            } while (this.matchToken(86));
            this.mustMatchToken(83, "msg.export.missing.rc");
            if (this.matchToken(40)) {
                if (!"from".equals(this.ts.getString())) {
                    this.reportError("msg.export.missing.from");
                }
                this.mustMatchToken(42, "");
                en.setFilePath(this.ts.getString());
            }
        }
        else if (this.matchToken(114)) {
            final FunctionNode fn = this.function(3);
            if (fn.getName() == null) {
                this.reportError("msg.export.inline.requires.name");
                return (AstNode)this.makeErrorNode();
            }
            en.setExportedValue((AstNode)fn, fn.getFunctionName().getIdentifier());
        }
        else if (this.matchToken(115)) {
            final ClassNode cn = this.classExpr(Collections.emptyList());
            if (cn.getClassName() == null) {
                this.reportError("msg.export.inline.requires.name");
                return (AstNode)this.makeErrorNode();
            }
            en.setExportedValue((AstNode)cn, cn.getClassName().getIdentifier());
        }
        else if (this.matchToken(135)) {
            final DecoratorDeclarationNode ddn = this.decoratorDeclaration();
            en.setExportedValue((AstNode)ddn, ddn.getName());
        }
        else {
            int token = -1;
            if (this.matchToken(131)) {
                token = 131;
            }
            else if (this.matchToken(158)) {
                token = 158;
            }
            else if (this.matchToken(159)) {
                token = 159;
            }
            if (token == -1) {
                this.reportError("msg.export.inline.requires.name");
                return (AstNode)this.makeErrorNode();
            }
            final VariableDeclaration decl = this.variables(token, this.ts.tokenBeg, false);
            en.setExportedValue((AstNode)decl, (String)null);
        }
        return (AstNode)en;
    }
    
    private void autoInsertSemicolon(final AstNode pn) throws IOException {
        final int ttFlagged = this.peekFlaggedToken();
        final int pos = pn.getPosition();
        switch (ttFlagged & 0xFFFF) {
            case 79: {
                this.consumeToken();
                pn.setLength(this.ts.tokenEnd - pos);
                break;
            }
            case -1:
            case 0:
            case 83: {
                this.warnMissingSemi(pos, Math.max(pos + 1, this.nodeEnd(pn)));
                break;
            }
            default: {
                if ((ttFlagged & 0x10000) == 0x0) {
                    this.reportError("msg.no.semi.stmt");
                    break;
                }
                this.warnMissingSemi(pos, this.nodeEnd(pn));
                break;
            }
        }
    }
    
    private IfStatement ifStatement() throws IOException {
        if (this.currentToken != 121) {
            this.codeBug();
        }
        this.consumeToken();
        final int pos = this.ts.tokenBeg;
        final int lineno = this.ts.lineno;
        int elsePos = -1;
        final IfStatement pn = new IfStatement(pos);
        final ConditionData data = this.condition();
        final AstNode ifTrue = this.getNextStatementAfterInlineComments((AstNode)pn, true);
        AstNode ifFalse = null;
        if (this.matchToken(122)) {
            final int tt = this.peekToken();
            if (tt == 166) {
                pn.setElseKeyWordInlineComment((AstNode)this.scannedComments.get(this.scannedComments.size() - 1));
                this.consumeToken();
            }
            elsePos = this.ts.tokenBeg - pos;
            ifFalse = this.statement();
            this.validateSingleStatementContext(ifFalse);
        }
        final int end = this.getNodeEnd((ifFalse != null) ? ifFalse : ifTrue);
        pn.setLength(end - pos);
        pn.setCondition(data.condition);
        pn.setParens(data.lp - pos, data.rp - pos);
        pn.setThenPart(ifTrue);
        pn.setElsePart(ifFalse);
        pn.setElsePosition(elsePos);
        pn.setLineno(lineno);
        return pn;
    }
    
    private SwitchStatement switchStatement() throws IOException {
        if (this.currentToken != 123) {
            this.codeBug();
        }
        this.consumeToken();
        final int pos = this.ts.tokenBeg;
        final SwitchStatement pn = new SwitchStatement(pos);
        if (this.mustMatchToken(84, "msg.no.paren.switch")) {
            pn.setLp(this.ts.tokenBeg - pos);
        }
        pn.setLineno(this.ts.lineno);
        final AstNode discriminant = this.expr();
        pn.setExpression(discriminant);
        this.enterSwitch(pn);
        try {
            if (this.mustMatchToken(85, "msg.no.paren.after.switch")) {
                pn.setRp(this.ts.tokenBeg - pos);
            }
            this.mustMatchToken(82, "msg.no.brace.switch");
            boolean hasDefault = false;
        Label_0476:
            while (true) {
                int tt = this.nextToken();
                final int casePos = this.ts.tokenBeg;
                final int caseLineno = this.ts.lineno;
                AstNode caseExpression = null;
                switch (tt) {
                    case 83: {
                        pn.setLength(this.ts.tokenEnd - pos);
                        break Label_0476;
                    }
                    case 124: {
                        caseExpression = this.expr();
                        this.mustMatchToken(104, "msg.no.colon.case");
                        break;
                    }
                    case 125: {
                        if (hasDefault) {
                            this.reportError("msg.double.switch.default");
                        }
                        hasDefault = true;
                        this.mustMatchToken(104, "msg.no.colon.case");
                        break;
                    }
                    case 166: {
                        final AstNode n = (AstNode)this.scannedComments.get(this.scannedComments.size() - 1);
                        pn.addChild(n);
                        continue;
                    }
                    default: {
                        this.reportError("msg.bad.switch");
                        break Label_0476;
                    }
                }
                final SwitchCase caseNode = new SwitchCase(casePos);
                caseNode.setExpression(caseExpression);
                caseNode.setLength(this.ts.tokenEnd - pos);
                caseNode.setLineno(caseLineno);
                while ((tt = this.peekToken()) != 83 && tt != 124 && tt != 125 && tt != 0) {
                    if (tt == 166) {
                        final Comment inlineComment = this.scannedComments.get(this.scannedComments.size() - 1);
                        if (caseNode.getInlineComment() == null && inlineComment.getLineno() == caseNode.getLineno()) {
                            caseNode.setInlineComment((AstNode)inlineComment);
                        }
                        else {
                            caseNode.addStatement((AstNode)inlineComment);
                        }
                        this.consumeToken();
                    }
                    else {
                        final AstNode nextStmt = this.statement();
                        caseNode.addStatement(nextStmt);
                    }
                }
                pn.addCase(caseNode);
            }
        }
        finally {
            this.exitSwitch();
        }
        return pn;
    }
    
    private WhileLoop whileLoop() throws IOException {
        if (this.currentToken != 126) {
            this.codeBug();
        }
        this.consumeToken();
        final int pos = this.ts.tokenBeg;
        final WhileLoop pn = new WhileLoop(pos);
        pn.setLineno(this.ts.lineno);
        this.enterLoop((Loop)pn);
        try {
            final ConditionData data = this.condition();
            pn.setCondition(data.condition);
            pn.setParens(data.lp - pos, data.rp - pos);
            final AstNode body = this.getNextStatementAfterInlineComments((AstNode)pn, true);
            pn.setLength(this.getNodeEnd(body) - pos);
            pn.setBody(body);
        }
        finally {
            this.exitLoop();
        }
        return pn;
    }
    
    private DoLoop doLoop() throws IOException {
        if (this.currentToken != 127) {
            this.codeBug();
        }
        this.consumeToken();
        final int pos = this.ts.tokenBeg;
        final DoLoop pn = new DoLoop(pos);
        pn.setLineno(this.ts.lineno);
        this.enterLoop((Loop)pn);
        int end;
        try {
            final AstNode body = this.getNextStatementAfterInlineComments((AstNode)pn, true);
            this.mustMatchToken(126, "msg.no.while.do");
            pn.setWhilePosition(this.ts.tokenBeg - pos);
            final ConditionData data = this.condition();
            pn.setCondition(data.condition);
            pn.setParens(data.lp - pos, data.rp - pos);
            end = this.getNodeEnd(body);
            pn.setBody(body);
        }
        finally {
            this.exitLoop();
        }
        if (this.matchToken(79)) {
            end = this.ts.tokenEnd;
        }
        pn.setLength(end - pos);
        return pn;
    }
    
    private int peekUntilNonComment(int tt) throws IOException {
        while (tt == 166) {
            this.consumeToken();
            tt = this.peekToken();
        }
        return tt;
    }
    
    private AstNode getNextStatementAfterInlineComments(final AstNode pn, final boolean checkSingleStatementContext) throws IOException {
        AstNode body = this.statement();
        if (166 == body.getType()) {
            final AstNode commentNode = body;
            body = this.statement();
            if (pn != null) {
                pn.setInlineComment(commentNode);
            }
            else {
                body.setInlineComment(commentNode);
            }
        }
        if (checkSingleStatementContext) {
            this.validateSingleStatementContext(body);
        }
        return body;
    }
    
    private void validateSingleStatementContext(final AstNode node) {
        if (node instanceof Scope) {
            return;
        }
        if (node instanceof ExpressionStatement && node.getType() == 144) {
            final AstNode expr = ((ExpressionStatement)node).getExpression();
            if (expr instanceof ClassNode) {
                this.reportError("msg.single.statement.context", "classes");
            }
        }
        else if (node instanceof VariableDeclaration) {
            final int type = node.getType();
            if (type == 158 || type == 159) {
                this.reportError("msg.single.statement.context", "lexical declaration");
            }
        }
    }
    
    private Loop forLoop() throws IOException {
        if (this.currentToken != 128) {
            this.codeBug();
        }
        this.consumeToken();
        final int forPos = this.ts.tokenBeg;
        final int lineno = this.ts.lineno;
        boolean isForIn = false;
        boolean isForOf = false;
        final int eachPos = -1;
        int inPos = -1;
        int lp = -1;
        int rp = -1;
        AstNode incr = null;
        final Scope tempScope = new Scope();
        this.pushScope(tempScope);
        Loop pn;
        try {
            if (this.mustMatchToken(84, "msg.no.paren.for")) {
                lp = this.ts.tokenBeg - forPos;
            }
            final int tt = this.peekToken();
            final AstNode init = this.forLoopInit(tt);
            AstNode cond;
            if (this.matchToken(55)) {
                isForIn = true;
                inPos = this.ts.tokenBeg - forPos;
                cond = this.expr();
            }
            else if (this.compilerEnv.getLanguageVersion() >= 200 && this.matchToken(40) && "of".equals(this.ts.getString())) {
                isForOf = true;
                inPos = this.ts.tokenBeg - forPos;
                cond = this.expr();
            }
            else {
                this.mustMatchToken(79, "msg.no.semi.for");
                if (this.peekToken() == 79) {
                    cond = (AstNode)new EmptyExpression(this.ts.tokenBeg, 1);
                    cond.setLineno(this.ts.lineno);
                }
                else {
                    cond = this.expr();
                }
                this.mustMatchToken(79, "msg.no.semi.for.cond");
                final int tmpPos = this.ts.tokenEnd;
                if (this.peekToken() == 85) {
                    incr = (AstNode)new EmptyExpression(tmpPos, 1);
                    incr.setLineno(this.ts.lineno);
                }
                else {
                    incr = this.expr();
                }
            }
            if (this.mustMatchToken(85, "msg.no.paren.for.ctrl")) {
                rp = this.ts.tokenBeg - forPos;
            }
            if (isForIn || isForOf) {
                final ForInLoop fis = new ForInLoop(forPos);
                if (init instanceof VariableDeclaration) {
                    final VariableDeclaration decl = (VariableDeclaration)init;
                    if (decl.getVariables().size() > 1) {
                        this.reportError("msg.mult.index");
                    }
                    if (this.inUseStrictDirective && decl.getVariables().get(0).hasExplicitInitializer()) {
                        this.reportError("msg.for.in.assignment.in.strict.mode");
                    }
                }
                fis.setIterator(init);
                fis.setIteratedObject(cond);
                fis.setInPosition(inPos);
                fis.setEachPosition(eachPos);
                fis.setIsForOf(isForOf);
                pn = (Loop)fis;
            }
            else {
                final ForLoop fl = new ForLoop(forPos);
                fl.setInitializer(init);
                fl.setCondition(cond);
                fl.setIncrement(incr);
                pn = (Loop)fl;
            }
            this.currentScope.replaceWith((Scope)pn);
            this.popScope();
            this.enterLoop(pn);
            try {
                final AstNode body = this.getNextStatementAfterInlineComments((AstNode)pn, true);
                pn.setLength(this.getNodeEnd(body) - forPos);
                pn.setBody(body);
            }
            finally {
                this.exitLoop();
            }
        }
        finally {
            if (this.currentScope == tempScope) {
                this.popScope();
            }
        }
        pn.setParens(lp, rp);
        pn.setLineno(lineno);
        return pn;
    }
    
    private AstNode forLoopInit(final int tt) throws IOException {
        try {
            this.inForInit = true;
            AstNode init;
            if (tt == 79) {
                init = (AstNode)new EmptyExpression(this.ts.tokenBeg, 1);
                init.setLineno(this.ts.lineno);
            }
            else if (tt == 131 || tt == 158 || tt == 159) {
                this.consumeToken();
                init = (AstNode)this.variables(tt, this.ts.tokenBeg, false);
            }
            else {
                init = this.expr();
                this.markDestructuring(init);
            }
            return init;
        }
        finally {
            this.inForInit = false;
        }
    }
    
    private TryStatement tryStatement() throws IOException {
        if (this.currentToken != 78) {
            this.codeBug();
        }
        this.consumeToken();
        final Comment jsdocNode = this.getAndResetJsDoc();
        final int tryPos = this.ts.tokenBeg;
        final int lineno = this.ts.lineno;
        int finallyPos = -1;
        final TryStatement pn = new TryStatement(tryPos);
        int lctt = this.peekToken();
        if (lctt == 166) {
            final Comment commentNode = this.scannedComments.get(this.scannedComments.size() - 1);
            pn.setInlineComment((AstNode)commentNode);
            this.consumeToken();
            lctt = this.peekToken();
        }
        if (lctt != 82) {
            this.reportError("msg.no.brace.try");
        }
        final AstNode tryBlock = this.getNextStatementAfterInlineComments((AstNode)pn, false);
        int tryEnd = this.getNodeEnd(tryBlock);
        List<CatchClause> clauses = null;
        final boolean sawDefaultCatch = false;
        final int peek = this.peekToken();
        if (peek == 133) {
            while (this.matchToken(133)) {
                final int catchLineNum = this.ts.lineno;
                if (sawDefaultCatch) {
                    this.reportError("msg.catch.unreachable");
                }
                final int catchPos = this.ts.tokenBeg;
                int lp = -1;
                int rp = -1;
                final int guardPos = -1;
                if (this.mustMatchToken(84, "msg.no.paren.catch")) {
                    lp = this.ts.tokenBeg;
                }
                this.mustMatchToken(40, "msg.bad.catchcond");
                final Name varName = this.createNameNode();
                final Comment jsdocNodeForName = this.getAndResetJsDoc();
                if (jsdocNodeForName != null) {
                    varName.setJsDocNode(jsdocNodeForName);
                }
                final String varNameString = varName.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(varNameString) || "arguments".equals(varNameString))) {
                    this.reportError("msg.bad.id.strict", varNameString);
                }
                if (this.mustMatchToken(85, "msg.bad.catchcond")) {
                    rp = this.ts.tokenBeg;
                }
                this.mustMatchToken(82, "msg.no.brace.catchblock");
                final Block catchBlock = (Block)this.statements();
                tryEnd = this.getNodeEnd((AstNode)catchBlock);
                final CatchClause catchNode = new CatchClause(catchPos);
                catchNode.setVarName(varName);
                catchNode.setBody(catchBlock);
                catchNode.setParens(lp, rp);
                catchNode.setLineno(catchLineNum);
                if (this.mustMatchToken(83, "msg.no.brace.after.body")) {
                    tryEnd = this.ts.tokenEnd;
                }
                catchNode.setLength(tryEnd - catchPos);
                if (clauses == null) {
                    clauses = new ArrayList<CatchClause>();
                }
                clauses.add(catchNode);
            }
        }
        else if (peek != 134) {
            this.mustMatchToken(134, "msg.try.no.catchfinally");
        }
        AstNode finallyBlock = null;
        if (this.matchToken(134)) {
            finallyPos = this.ts.tokenBeg;
            finallyBlock = this.statement();
            tryEnd = this.getNodeEnd(finallyBlock);
        }
        pn.setLength(tryEnd - tryPos);
        pn.setTryBlock(tryBlock);
        pn.setCatchClauses((List)clauses);
        pn.setFinallyBlock(finallyBlock);
        if (finallyPos != -1) {
            pn.setFinallyPosition(finallyPos - tryPos);
        }
        pn.setLineno(lineno);
        if (jsdocNode != null) {
            pn.setJsDocNode(jsdocNode);
        }
        return pn;
    }
    
    private ThrowStatement throwStatement() throws IOException {
        if (this.currentToken != 53) {
            this.codeBug();
        }
        this.consumeToken();
        final int pos = this.ts.tokenBeg;
        final int lineno = this.ts.lineno;
        if (this.peekTokenOrEOL() == 1) {
            this.reportError("msg.bad.throw.eol");
        }
        final AstNode expr = this.expr();
        final ThrowStatement pn = new ThrowStatement(pos, expr);
        pn.setLineno(lineno);
        return pn;
    }
    
    private LabeledStatement matchJumpLabelName() throws IOException {
        LabeledStatement label = null;
        if (this.peekTokenOrEOL() == 40) {
            this.consumeToken();
            if (this.labelSet != null) {
                label = this.labelSet.get(this.ts.getString());
            }
            if (label == null) {
                this.reportError("msg.undef.label");
            }
        }
        return label;
    }
    
    private BreakStatement breakStatement() throws IOException {
        if (this.currentToken != 129) {
            this.codeBug();
        }
        this.consumeToken();
        final int lineno = this.ts.lineno;
        final int pos = this.ts.tokenBeg;
        int end = this.ts.tokenEnd;
        Name breakLabel = null;
        if (this.peekTokenOrEOL() == 40) {
            breakLabel = this.createNameNode();
            end = this.getNodeEnd((AstNode)breakLabel);
        }
        final LabeledStatement labels = this.matchJumpLabelName();
        Jump breakTarget = (Jump)((labels == null) ? null : labels.getFirstLabel());
        if (breakTarget == null && breakLabel == null) {
            if (this.loopAndSwitchSet == null || this.loopAndSwitchSet.size() == 0) {
                this.reportError("msg.bad.break", pos, end - pos);
            }
            else {
                breakTarget = this.loopAndSwitchSet.get(this.loopAndSwitchSet.size() - 1);
            }
        }
        final BreakStatement pn = new BreakStatement(pos, end - pos);
        pn.setBreakLabel(breakLabel);
        if (breakTarget != null) {
            pn.setBreakTarget(breakTarget);
        }
        pn.setLineno(lineno);
        return pn;
    }
    
    private ContinueStatement continueStatement() throws IOException {
        if (this.currentToken != 130) {
            this.codeBug();
        }
        this.consumeToken();
        final int lineno = this.ts.lineno;
        final int pos = this.ts.tokenBeg;
        int end = this.ts.tokenEnd;
        Name label = null;
        if (this.peekTokenOrEOL() == 40) {
            label = this.createNameNode();
            end = this.getNodeEnd((AstNode)label);
        }
        final LabeledStatement labels = this.matchJumpLabelName();
        Loop target = null;
        if (labels == null && label == null) {
            if (this.loopSet == null || this.loopSet.size() == 0) {
                this.reportError("msg.continue.outside");
            }
            else {
                target = this.loopSet.get(this.loopSet.size() - 1);
            }
        }
        else {
            if (labels == null || !(labels.getStatement() instanceof Loop)) {
                this.reportError("msg.continue.nonloop", pos, end - pos);
            }
            target = ((labels == null) ? null : ((Loop)labels.getStatement()));
        }
        final ContinueStatement pn = new ContinueStatement(pos, end - pos);
        if (target != null) {
            pn.setTarget(target);
        }
        pn.setLabel(label);
        pn.setLineno(lineno);
        return pn;
    }
    
    private WithStatement withStatement() throws IOException {
        if (this.currentToken != 132) {
            this.codeBug();
        }
        this.consumeToken();
        final Comment withComment = this.getAndResetJsDoc();
        final int lineno = this.ts.lineno;
        final int pos = this.ts.tokenBeg;
        int lp = -1;
        int rp = -1;
        if (this.mustMatchToken(84, "msg.no.paren.with")) {
            lp = this.ts.tokenBeg;
        }
        final AstNode obj = this.expr();
        if (this.mustMatchToken(85, "msg.no.paren.after.with")) {
            rp = this.ts.tokenBeg;
        }
        final WithStatement pn = new WithStatement(pos);
        final AstNode body = this.getNextStatementAfterInlineComments((AstNode)pn, true);
        pn.setLength(this.getNodeEnd(body) - pos);
        pn.setJsDocNode(withComment);
        pn.setExpression(obj);
        pn.setStatement(body);
        pn.setParens(lp, rp);
        pn.setLineno(lineno);
        return pn;
    }
    
    private AstNode letStatement() throws IOException {
        if (this.currentToken != 158) {
            this.codeBug();
        }
        this.consumeToken();
        final int lineno = this.ts.lineno;
        final int pos = this.ts.tokenBeg;
        AstNode pn;
        if (this.peekToken() == 84) {
            pn = this.let(true, pos);
        }
        else {
            pn = (AstNode)this.variables(158, pos, true);
        }
        pn.setLineno(lineno);
        return pn;
    }
    
    private AstNode returnOrYield(final int tt, final boolean exprContext) throws IOException {
        if (!this.insideFunction()) {
            this.reportError((tt == 4) ? "msg.bad.return" : "msg.bad.yield");
        }
        this.consumeToken();
        final int lineno = this.ts.lineno;
        final int pos = this.ts.tokenBeg;
        int end = this.ts.tokenEnd;
        AstNode e = null;
        switch (this.peekTokenOrEOL()) {
            case -1:
            case 0:
            case 1:
            case 76:
            case 79:
            case 81:
            case 83:
            case 85: {
                break;
            }
            default: {
                e = this.expr();
                end = this.getNodeEnd(e);
                break;
            }
        }
        final int before = this.endFlags;
        AstNode ret;
        if (tt == 4) {
            this.endFlags |= ((e == null) ? 2 : 4);
            ret = (AstNode)new ReturnStatement(pos, end - pos, e);
            if (nowAllSet(before, this.endFlags, 6)) {
                this.addStrictWarning("msg.return.inconsistent", "", pos, end - pos);
            }
        }
        else {
            if (!this.insideFunction()) {
                this.reportError("msg.bad.yield");
            }
            if (!(this.currentScriptOrFn instanceof FunctionNode) || !((FunctionNode)this.currentScriptOrFn).isGenerator()) {
                this.reportError("msg.bad.yield.fn.type");
                return (AstNode)this.makeErrorNode();
            }
            this.endFlags |= 0x8;
            ret = (AstNode)new Yield(pos, end - pos, e);
            this.setRequiresActivation();
            if (!exprContext) {
                ret = (AstNode)new ExpressionStatement(ret);
            }
        }
        ret.setLineno(lineno);
        return ret;
    }
    
    private AstNode block() throws IOException {
        if (this.currentToken != 82) {
            this.codeBug();
        }
        this.consumeToken();
        final int pos = this.ts.tokenBeg;
        final Scope block = new Scope(pos);
        block.setLineno(this.ts.lineno);
        this.pushScope(block);
        try {
            this.statements((AstNode)block);
            this.mustMatchToken(83, "msg.no.brace.block");
            block.setLength(this.ts.tokenEnd - pos);
            return (AstNode)block;
        }
        finally {
            this.popScope();
        }
    }
    
    private DecoratorDeclarationNode decoratorDeclaration() throws IOException {
        this.mustMatchToken(153, "msg.decorator.declaration.missing.at");
        this.mustMatchToken(40, "msg.decorator.declaration.missing.name");
        final Name name = this.createNameNode();
        name.setIdentifier("@" + name.getIdentifier());
        this.consumeToken();
        final DecoratorDeclarationNode dn = new DecoratorDeclarationNode();
        dn.setFunctionName(name);
        final PerFunctionVariables savedVars = new PerFunctionVariables((FunctionNode)dn);
        try {
            if (this.peekToken() == 84) {
                this.consumeToken();
                this.parseFunctionParams((FunctionNode)dn, false);
                dn.setSourceName(this.sourceURI);
            }
            this.mustMatchToken(82, "msg.decorator.declaration.missing.lc");
            while (this.peekToken() == 153) {
                dn.addDecoratorNode(this.decorator(true, false));
            }
        }
        finally {
            savedVars.restore();
        }
        this.mustMatchToken(83, "msg.decorator.declaration.missing.rc");
        return dn;
    }
    
    private AstNode decoratedExpr() throws IOException {
        final List<DecoratorNode> decorators = new ArrayList<DecoratorNode>();
        for (int tt = this.peekToken(); tt == 153; tt = this.peekToken()) {
            decorators.add(this.decorator(false, false));
        }
        AstNode expr = this.statement();
        if (expr instanceof ExpressionStatement) {
            expr = ((ExpressionStatement)expr).getExpression();
        }
        if (!(expr instanceof ClassNode)) {
            this.reportError("msg.decorator.invalid.usage");
            return (AstNode)this.makeErrorNode();
        }
        ((ClassNode)expr).setDecorators((List)decorators);
        return expr;
    }
    
    private DecoratorNode decorator(final boolean declaration, final boolean numericLiteral) throws IOException {
        this.consumeToken();
        this.peekToken();
        final Name name = this.createNameNode();
        name.setIdentifier("@" + name.getIdentifier());
        this.consumeToken();
        final DecoratorNode dn = new DecoratorNode(this.ts.tokenBeg, name);
        dn.setDecoratorType(DecoratorType.fromDecorator(name.getIdentifier()));
        if (this.peekToken() == 84) {
            final AstNode node = this.memberExprTail(true, (AstNode)dn);
            if (!(node instanceof FunctionCall)) {
                throw this.codeBug();
            }
            dn.setArguments(((FunctionCall)node).getArguments());
        }
        if (!numericLiteral) {
            final int peeked = this.peekToken();
            if (peeked == 79) {
                this.reportError("msg.decorator.semi");
                this.peekToken();
            }
            if (!declaration && !this.insideClass && peeked != 115 && peeked != 153 && peeked != 119) {
                this.reportError("msg.decorator.invalid.usage");
            }
        }
        return dn;
    }
    
    private void recordLabel(final Label label, final LabeledStatement bundle) throws IOException {
        if (this.peekToken() != 104) {
            this.codeBug();
        }
        this.consumeToken();
        final String name = label.getName();
        if (this.labelSet == null) {
            this.labelSet = new HashMap<String, LabeledStatement>();
        }
        else {
            final LabeledStatement ls = this.labelSet.get(name);
            if (ls != null) {
                if (this.compilerEnv.isIdeMode()) {
                    final Label dup = ls.getLabelByName(name);
                    this.reportError("msg.dup.label", dup.getAbsolutePosition(), dup.getLength());
                }
                this.reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        bundle.addLabel(label);
        this.labelSet.put(name, bundle);
    }
    
    private AstNode nameOrLabel() throws IOException {
        if (this.currentToken != 40) {
            throw this.codeBug();
        }
        final int pos = this.ts.tokenBeg;
        this.currentFlaggedToken |= 0x20000;
        AstNode expr = this.expr();
        if (expr.getType() != 140) {
            final AstNode n = (AstNode)new ExpressionStatement(expr, !this.insideFunction());
            n.lineno = expr.lineno;
            return n;
        }
        final LabeledStatement bundle = new LabeledStatement(pos);
        this.recordLabel((Label)expr, bundle);
        bundle.setLineno(this.ts.lineno);
        AstNode stmt = null;
        while (this.peekToken() == 40) {
            this.currentFlaggedToken |= 0x20000;
            expr = this.expr();
            if (expr.getType() != 140) {
                stmt = (AstNode)new ExpressionStatement(expr, !this.insideFunction());
                this.autoInsertSemicolon(stmt);
                break;
            }
            this.recordLabel((Label)expr, bundle);
        }
        try {
            this.currentLabel = bundle;
            if (stmt == null) {
                stmt = this.statementHelper();
                final int ntt = this.peekToken();
                if (ntt == 166 && stmt.getLineno() == this.scannedComments.get(this.scannedComments.size() - 1).getLineno()) {
                    stmt.setInlineComment((AstNode)this.scannedComments.get(this.scannedComments.size() - 1));
                    this.consumeToken();
                }
            }
        }
        finally {
            this.currentLabel = null;
            for (final Label lb : bundle.getLabels()) {
                this.labelSet.remove(lb.getName());
            }
        }
        bundle.setLength((stmt.getParent() == null) ? (this.getNodeEnd(stmt) - pos) : this.getNodeEnd(stmt));
        bundle.setStatement(stmt);
        return (AstNode)bundle;
    }
    
    private VariableDeclaration variables(final int declType, final int pos, final boolean isStatement) throws IOException {
        return this.variables(declType, pos, isStatement, false, false);
    }
    
    private VariableDeclaration variables(final int declType, final int pos, final boolean isStatement, final boolean isFunctionParams, final boolean isObjectSetterFunction) throws IOException {
        final VariableDeclaration pn = new VariableDeclaration(pos);
        pn.setType(declType);
        pn.setLineno(this.ts.lineno);
        final Comment varjsdocNode = this.getAndResetJsDoc();
        if (varjsdocNode != null) {
            pn.setJsDocNode(varjsdocNode);
        }
        int end;
        do {
            AstNode destructuring = null;
            Name name = null;
            int tt = this.peekToken();
            final int kidPos = this.ts.tokenBeg;
            end = this.ts.tokenEnd;
            boolean rest = false;
            if (tt == 80 || tt == 82) {
                destructuring = this.destructuringPrimaryExpr();
                end = this.getNodeEnd(destructuring);
                if (!(destructuring instanceof DestructuringForm)) {
                    this.reportError("msg.bad.assign.left", kidPos, end - kidPos);
                }
                this.markDestructuring(destructuring);
            }
            else {
                if (this.matchToken(110)) {
                    if (isObjectSetterFunction) {
                        this.reportError("msg.setter.rest");
                    }
                    rest = true;
                }
                tt = this.peekToken();
                if (this.inUseStrictDirective) {
                    this.mustMatchToken(40, "msg.bad.var");
                    name = this.createNameNode();
                }
                else {
                    if (this.compilerEnv.isReservedKeywordAsIdentifier()) {
                        final boolean isKeyword = TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), false);
                        final boolean isSafeKeyword = Token.keywordToName(tt) == null;
                        if (isKeyword && isSafeKeyword) {
                            name = this.createNameNode();
                            this.consumeToken();
                        }
                    }
                    if (name == null) {
                        this.mustMatchToken(40, "msg.bad.var");
                        name = this.createNameNode();
                    }
                }
                name.setLineno(this.ts.getLineno());
                if (rest) {
                    name.putProp(29, (Object)true);
                    this.currentScope.setHasRest();
                }
                if (this.inUseStrictDirective) {
                    final String id = this.ts.getString();
                    if ("eval".equals(id) || "arguments".equals(this.ts.getString())) {
                        this.reportError("msg.bad.id.strict", id);
                    }
                }
                this.defineSymbol(declType, this.ts.getString(), this.inForInit);
            }
            final int lineno = this.ts.lineno;
            final Comment jsdocNode = this.getAndResetJsDoc();
            AstNode init = null;
            if (this.matchToken(87)) {
                if (rest) {
                    this.reportError("msg.rest.no.defaults");
                }
                init = this.assignExpr();
                end = this.getNodeEnd(init);
            }
            final VariableInitializer vi = new VariableInitializer(kidPos, end - kidPos);
            if (destructuring != null) {
                if (init == null && !this.inForInit && !isFunctionParams) {
                    this.reportError("msg.destruct.assign.no.init");
                }
                vi.setTarget(destructuring);
            }
            else {
                vi.setTarget((AstNode)name);
            }
            if (declType == 158 && init == null) {
                vi.setInitializer((AstNode)new Name(this.ts.tokenBeg, "undefined"));
            }
            else {
                vi.setInitializer(init);
            }
            if (init != null) {
                vi.setHasExplicitInitializer();
            }
            vi.setType(declType);
            vi.setJsDocNode(jsdocNode);
            vi.setLineno(lineno);
            pn.addVariable(vi);
            if (!this.matchToken(86)) {
                break;
            }
            if (rest) {
                this.reportError("msg.rest.not.last");
            }
        } while (this.peekToken() != 85 || !isFunctionParams);
        pn.setLength(end - pos);
        pn.setIsStatement(isStatement);
        return pn;
    }
    
    private AstNode let(final boolean isStatement, final int pos) throws IOException {
        final LetNode pn = new LetNode(pos);
        pn.setLineno(this.ts.lineno);
        if (this.mustMatchToken(84, "msg.no.paren.after.let")) {
            pn.setLp(this.ts.tokenBeg - pos);
        }
        this.pushScope((Scope)pn);
        try {
            final VariableDeclaration vars = this.variables(158, this.ts.tokenBeg, isStatement);
            pn.setVariables(vars);
            if (this.mustMatchToken(85, "msg.no.paren.let")) {
                pn.setRp(this.ts.tokenBeg - pos);
            }
            if (isStatement && this.peekToken() == 82) {
                this.consumeToken();
                final int beg = this.ts.tokenBeg;
                final AstNode stmt = this.statements();
                this.mustMatchToken(83, "msg.no.curly.let");
                stmt.setLength(this.ts.tokenEnd - beg);
                pn.setLength(this.ts.tokenEnd - pos);
                pn.setBody(stmt);
                pn.setType(158);
            }
            else {
                final AstNode expr = this.expr();
                pn.setLength(this.getNodeEnd(expr) - pos);
                pn.setBody(expr);
                if (isStatement) {
                    final ExpressionStatement es = new ExpressionStatement((AstNode)pn, !this.insideFunction());
                    es.setLineno(pn.getLineno());
                    return (AstNode)es;
                }
            }
        }
        finally {
            this.popScope();
        }
        return (AstNode)pn;
    }
    
    private void defineSymbol(final int declType, final String name) {
        this.defineSymbol(declType, name, false);
    }
    
    void defineSymbol(final int declType, final String name, final boolean ignoreNotInBlock) {
        if (name == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            }
            this.codeBug();
        }
        final Scope definingScope = this.currentScope.getDefiningScope(name);
        final Symbol symbol = (definingScope != null) ? definingScope.getSymbol(name) : null;
        final int symDeclType = (symbol != null) ? symbol.getDeclType() : -1;
        if (symbol != null) {
            if (definingScope == this.currentScope) {
                if (symDeclType == 159) {
                    this.reportError("msg.const.redecl", name);
                    return;
                }
                if (symDeclType == 158) {
                    this.reportError("msg.let.redecl", name);
                    return;
                }
                if (symDeclType == 115) {
                    this.reportError("msg.class.redecl", name);
                    return;
                }
            }
            else if (symDeclType == 114 && (declType == 115 || declType == 159 || declType == 158)) {
                this.reportError("msg.func.redecl", name);
                return;
            }
        }
        switch (declType) {
            case 158: {
                if (!ignoreNotInBlock && (this.currentScope.getType() == 121 || this.currentScope instanceof Loop)) {
                    this.reportError("msg.let.decl.not.in.block");
                    return;
                }
                this.currentScope.putSymbol(new Symbol(declType, name));
            }
            case 115:
            case 159: {
                this.currentScope.putSymbol(new Symbol(declType, name));
            }
            case 114:
            case 131: {
                if (symbol != null) {
                    if (symDeclType == 131) {
                        this.addStrictWarning("msg.var.redecl", name);
                    }
                    else if (symDeclType == 84) {
                        this.addStrictWarning("msg.var.hides.arg", name);
                    }
                }
                else {
                    this.currentScriptOrFn.putSymbol(new Symbol(declType, name));
                }
            }
            case 84: {
                if (symbol != null) {
                    this.addWarning("msg.dup.parms", name);
                }
                this.currentScriptOrFn.putSymbol(new Symbol(declType, name));
            }
            default: {
                throw this.codeBug();
            }
        }
    }
    
    private AstNode expr() throws IOException {
        AstNode pn = this.assignExpr();
        final int pos = pn.getPosition();
        while (this.matchToken(86)) {
            final int opPos = this.ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !pn.hasSideEffects()) {
                this.addStrictWarning("msg.no.side.effects", "", pos, this.nodeEnd(pn) - pos);
            }
            if (this.peekToken() == 76) {
                this.reportError("msg.yield.parenthesized");
            }
            pn = (AstNode)new InfixExpression(86, pn, this.assignExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode assignExpr() throws IOException {
        int tt = this.peekToken();
        if (tt == 76) {
            this.consumeToken();
            return (AstNode)new Yield(this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg, this.assignExpr());
        }
        AstNode pn = this.condExpr();
        boolean hasEOL = false;
        tt = this.peekTokenOrEOL();
        if (tt == 1) {
            hasEOL = true;
            tt = this.peekToken();
        }
        if (87 <= tt && tt <= 102) {
            if (this.inDestructuringAssignment && tt != 87) {
                this.reportError("msg.destruct.assign.wrong.operator");
            }
            this.consumeToken();
            final Comment jsdocNode = this.getAndResetJsDoc();
            this.markDestructuring(pn);
            final int opPos = this.ts.tokenBeg;
            if (pn instanceof Name) {
                final Name lhs = (Name)pn;
                final String name = lhs.getString();
                if (name.equals("new.target")) {
                    this.reportError("msg.bad.assign.left");
                }
                final Scope definingScope = this.currentScope.getDefiningScope(name);
                if (definingScope != null) {
                    final Symbol definedSymbol = definingScope.getSymbol(name);
                    if (definedSymbol != null && definedSymbol.getDeclType() == 159) {
                        this.reportError("msg.const.inval.assign", name);
                    }
                }
            }
            pn = (AstNode)new Assignment(tt, pn, this.assignExpr(), opPos);
            if (jsdocNode != null) {
                pn.setJsDocNode(jsdocNode);
            }
        }
        else if (tt == 79) {
            if (this.currentJsDocComment != null) {
                pn.setJsDocNode(this.getAndResetJsDoc());
            }
        }
        else if (!hasEOL && tt == 169) {
            this.consumeToken();
            pn = this.arrowFunction(pn);
        }
        return pn;
    }
    
    private AstNode condExpr() throws IOException {
        AstNode pn = this.pipelineExpr(null);
        if (this.matchToken(103)) {
            final int line = this.ts.lineno;
            final int qmarkPos = this.ts.tokenBeg;
            int colonPos = -1;
            final boolean wasInForInit = this.inForInit;
            this.inForInit = false;
            AstNode ifTrue;
            try {
                ifTrue = this.assignExpr();
            }
            finally {
                this.inForInit = wasInForInit;
            }
            if (this.mustMatchToken(104, "msg.no.colon.cond")) {
                colonPos = this.ts.tokenBeg;
            }
            final AstNode ifFalse = this.assignExpr();
            final int beg = pn.getPosition();
            final int len = this.getNodeEnd(ifFalse) - beg;
            final ConditionalExpression ce = new ConditionalExpression(beg, len);
            ce.setLineno(line);
            ce.setTestExpression(pn);
            ce.setTrueExpression(ifTrue);
            ce.setFalseExpression(ifFalse);
            ce.setQuestionMarkPosition(qmarkPos - beg);
            ce.setColonPosition(colonPos - beg);
            pn = (AstNode)ce;
        }
        return pn;
    }
    
    private AstNode pipelineExpr(final AstNode previousPipeline) throws IOException {
        AstNode pn = (previousPipeline == null) ? this.shortCircuitExpr(null) : previousPipeline;
        if (this.matchToken(112)) {
            final int opPos = this.ts.tokenBeg;
            final FunctionCall fc = new FunctionCall(opPos);
            AstNode target = this.orExpr();
            if (this.peekToken() == 169) {
                this.consumeToken();
                target = this.arrowFunction(target);
            }
            fc.setTarget(target);
            fc.setArguments((List)Collections.singletonList(pn));
            pn = this.pipelineExpr((AstNode)fc);
        }
        return pn;
    }
    
    private AstNode shortCircuitExpr(final AstNode previousShortCircuit) throws IOException {
        AstNode pn = (previousShortCircuit == null) ? this.orExpr() : previousShortCircuit;
        if (this.matchToken(113)) {
            final int opPos = this.ts.tokenBeg;
            pn = (AstNode)new InfixExpression(113, pn, this.orExpr(), opPos);
            pn = this.shortCircuitExpr(pn);
        }
        return pn;
    }
    
    private AstNode orExpr() throws IOException {
        AstNode pn = this.andExpr();
        if (this.matchToken(105)) {
            final int opPos = this.ts.tokenBeg;
            pn = (AstNode)new InfixExpression(105, pn, this.orExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode andExpr() throws IOException {
        AstNode pn = this.bitOrExpr();
        if (this.matchToken(106)) {
            final int opPos = this.ts.tokenBeg;
            pn = (AstNode)new InfixExpression(106, pn, this.andExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode bitOrExpr() throws IOException {
        AstNode pn = this.bitXorExpr();
        while (this.matchToken(9)) {
            final int opPos = this.ts.tokenBeg;
            pn = (AstNode)new InfixExpression(9, pn, this.bitXorExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode bitXorExpr() throws IOException {
        AstNode pn = this.bitAndExpr();
        while (this.matchToken(10)) {
            final int opPos = this.ts.tokenBeg;
            pn = (AstNode)new InfixExpression(10, pn, this.bitAndExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode bitAndExpr() throws IOException {
        AstNode pn = this.eqExpr();
        while (this.matchToken(11)) {
            final int opPos = this.ts.tokenBeg;
            pn = (AstNode)new InfixExpression(11, pn, this.eqExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode eqExpr() throws IOException {
        AstNode pn = this.relExpr();
        while (true) {
            final int tt = this.peekToken();
            final int opPos = this.ts.tokenBeg;
            switch (tt) {
                case 12:
                case 13:
                case 49:
                case 50: {
                    this.consumeToken();
                    int parseToken = tt;
                    if (this.compilerEnv.getLanguageVersion() == 120) {
                        if (tt == 12) {
                            parseToken = 49;
                        }
                        else if (tt == 13) {
                            parseToken = 50;
                        }
                    }
                    pn = (AstNode)new InfixExpression(parseToken, pn, this.relExpr(), opPos);
                    continue;
                }
                default: {
                    return pn;
                }
            }
        }
    }
    
    private AstNode relExpr() throws IOException {
        AstNode pn = this.shiftExpr();
    Label_0108:
        while (true) {
            final int tt = this.peekToken();
            final int opPos = this.ts.tokenBeg;
            switch (tt) {
                case 55: {
                    if (this.inForInit) {
                        break Label_0108;
                    }
                }
                case 14:
                case 15:
                case 16:
                case 17:
                case 56: {
                    this.consumeToken();
                    pn = (AstNode)new InfixExpression(tt, pn, this.shiftExpr(), opPos);
                    continue;
                }
                default: {
                    break Label_0108;
                }
            }
        }
        return pn;
    }
    
    private AstNode shiftExpr() throws IOException {
        AstNode pn = this.addExpr();
        while (true) {
            final int tt = this.peekToken();
            final int opPos = this.ts.tokenBeg;
            switch (tt) {
                case 18:
                case 19:
                case 20: {
                    this.consumeToken();
                    pn = (AstNode)new InfixExpression(tt, pn, this.addExpr(), opPos);
                    continue;
                }
                default: {
                    return pn;
                }
            }
        }
    }
    
    private AstNode addExpr() throws IOException {
        AstNode pn = this.mulExpr();
        while (true) {
            final int tt = this.peekToken();
            final int opPos = this.ts.tokenBeg;
            if (tt != 21 && tt != 22) {
                break;
            }
            this.consumeToken();
            pn = (AstNode)new InfixExpression(tt, pn, this.mulExpr(), opPos);
        }
        return pn;
    }
    
    private AstNode mulExpr() throws IOException {
        AstNode pn = this.expExpr();
        while (true) {
            final int tt = this.peekToken();
            final int opPos = this.ts.tokenBeg;
            switch (tt) {
                case 23:
                case 24:
                case 25: {
                    this.consumeToken();
                    pn = (AstNode)new InfixExpression(tt, pn, this.unaryExpr(), opPos);
                    continue;
                }
                default: {
                    return pn;
                }
            }
        }
    }
    
    private AstNode expExpr() throws IOException {
        AstNode pn = this.unaryExpr();
        while (true) {
            final int tt = this.peekToken();
            final int opPos = this.ts.tokenBeg;
            if (tt != 26) {
                return pn;
            }
            if (pn instanceof UnaryExpression) {
                this.reportError("msg.exp.unparenthesized");
                return (AstNode)this.makeErrorNode();
            }
            this.consumeToken();
            pn = (AstNode)new InfixExpression(tt, pn, this.unaryExpr(), opPos);
        }
    }
    
    private AstNode unaryExpr() throws IOException {
        int tt = this.peekToken();
        if (tt == 166) {
            this.consumeToken();
            tt = this.peekUntilNonComment(tt);
        }
        final int line = this.ts.lineno;
        switch (tt) {
            case 27:
            case 28:
            case 32:
            case 33:
            case 53:
            case 136: {
                this.consumeToken();
                final AstNode node = (AstNode)new UnaryExpression(tt, this.ts.tokenBeg, this.unaryExpr());
                node.setLineno(line);
                return node;
            }
            case 21: {
                this.consumeToken();
                final AstNode node = (AstNode)new UnaryExpression(29, this.ts.tokenBeg, this.unaryExpr());
                node.setLineno(line);
                return node;
            }
            case 22: {
                this.consumeToken();
                final AstNode node = (AstNode)new UnaryExpression(30, this.ts.tokenBeg, this.unaryExpr());
                node.setLineno(line);
                return node;
            }
            case 107:
            case 108: {
                this.consumeToken();
                final UnaryExpression expr = new UnaryExpression(tt, this.ts.tokenBeg, this.memberExpr(true));
                expr.setLineno(line);
                this.checkBadIncDec(expr);
                return (AstNode)expr;
            }
            case -1: {
                this.consumeToken();
                return (AstNode)this.makeErrorNode();
            }
            default: {
                final AstNode pn = this.memberExpr(true);
                tt = this.peekTokenOrEOL();
                if (tt != 107 && tt != 108) {
                    return pn;
                }
                this.consumeToken();
                final UnaryExpression uexpr = new UnaryExpression(tt, this.ts.tokenBeg, pn, true);
                uexpr.setLineno(line);
                this.checkBadIncDec(uexpr);
                return (AstNode)uexpr;
            }
        }
    }
    
    private List<AstNode> argumentList(final boolean allowPartial) throws IOException {
        if (this.matchToken(85)) {
            return null;
        }
        final List<AstNode> result = new ArrayList<AstNode>();
        final boolean wasInForInit = this.inForInit;
        this.inForInit = false;
        try {
            do {
                final int tt = this.peekToken();
                if (tt == 85) {
                    break;
                }
                if (tt == 76) {
                    this.reportError("msg.yield.parenthesized");
                }
                AstNode en;
                if (tt == 103) {
                    if (!allowPartial) {
                        this.reportError("msg.partial.application.with.new");
                    }
                    this.consumeToken();
                    en = (AstNode)new EmptyExpression();
                    en.setType(103);
                }
                else {
                    en = this.assignExpr();
                }
                result.add(en);
            } while (this.matchToken(86));
        }
        finally {
            this.inForInit = wasInForInit;
        }
        this.mustMatchToken(85, "msg.no.paren.arg");
        return result;
    }
    
    private AstNode memberExpr(final boolean allowCallSyntax) throws IOException {
        int tt = this.peekToken();
        final int lineno = this.ts.lineno;
        boolean spread = false;
        if (tt == 110) {
            spread = true;
            this.consumeToken();
            tt = this.peekToken();
        }
        AstNode pn;
        if (tt != 31) {
            pn = this.primaryExpr();
        }
        else {
            this.consumeToken();
            if (this.matchToken(109)) {
                this.mustMatchToken(40, "Expected identifier");
                final Name name = this.createNameNode();
                if (!name.getString().equals("target")) {
                    this.reportError("msg.new.not.target");
                }
                if (!this.insideFunction()) {
                    this.reportError("msg.new.target.not.within.function");
                }
                return (AstNode)new Name(this.ts.tokenBeg, "new.target");
            }
            final int pos = this.ts.tokenBeg;
            final NewExpression nx = new NewExpression(pos);
            final AstNode target = this.memberExpr(false);
            int end = this.getNodeEnd(target);
            nx.setTarget(target);
            if (this.matchToken(84)) {
                final int lp = this.ts.tokenBeg;
                final List<AstNode> args = this.argumentList(false);
                if (args != null && args.size() > 65536) {
                    this.reportError("msg.too.many.constructor.args");
                }
                final int rp = this.ts.tokenBeg;
                end = this.ts.tokenEnd;
                if (args != null) {
                    nx.setArguments((List)args);
                }
                nx.setParens(lp - pos, rp - pos);
            }
            if (this.matchToken(82)) {
                final ObjectLiteral initializer = this.objectLiteral();
                end = this.getNodeEnd((AstNode)initializer);
                nx.setInitializer(initializer);
            }
            nx.setLength(end - pos);
            pn = (AstNode)nx;
        }
        pn.setLineno(lineno);
        final AstNode tail = (pn instanceof ClassNode) ? pn : this.memberExprTail(allowCallSyntax, pn);
        if (spread) {
            if (tail == null) {
                throw Kit.codeBug();
            }
            tail.putProp(29, (Object)true);
        }
        return tail;
    }
    
    private AstNode memberExprTail(final boolean allowCallSyntax, AstNode pn) throws IOException {
        if (pn == null) {
            this.codeBug();
        }
        while (true) {
            if (this.peekToken() == 111) {
                this.consumeToken();
                final int nextToken = this.peekToken();
                if (nextToken == 80) {
                    pn = this.matchElementGet(pn);
                }
                else if (nextToken == 84) {
                    final AstNode returned = this.matchFunctionCall(pn, allowCallSyntax);
                    if (returned == null) {
                        break;
                    }
                    pn = returned;
                }
                else if (nextToken == 40) {
                    pn = this.matchPropertyAccess(pn, true);
                }
                else if (nextToken == 166) {
                    final int currentFlagToken = this.currentFlaggedToken;
                    this.peekUntilNonComment(nextToken);
                    this.currentFlaggedToken = (((this.currentFlaggedToken & 0x10000) != 0x0) ? this.currentFlaggedToken : currentFlagToken);
                }
                else {
                    if (nextToken != 170) {
                        break;
                    }
                    this.reportError("msg.optional.chaining.private.ident");
                }
                pn.putProp(30, (Object)true);
            }
            else {
                final int nextToken = this.peekToken();
                if (nextToken == 43) {
                    this.consumeToken();
                    pn = this.templateLiteral(pn);
                }
                else if (nextToken == 80) {
                    pn = this.matchElementGet(pn);
                }
                else if (nextToken == 84) {
                    final AstNode returned = this.matchFunctionCall(pn, allowCallSyntax);
                    if (returned == null) {
                        break;
                    }
                    pn = returned;
                }
                else if (nextToken == 109) {
                    pn = this.matchPropertyAccess(pn, false);
                }
                else {
                    if (nextToken != 166) {
                        break;
                    }
                    final int currentFlagToken = this.currentFlaggedToken;
                    this.peekUntilNonComment(nextToken);
                    this.currentFlaggedToken = (((this.currentFlaggedToken & 0x10000) != 0x0) ? this.currentFlaggedToken : currentFlagToken);
                }
            }
        }
        return pn;
    }
    
    private AstNode matchPropertyAccess(AstNode pn, final boolean chaining) throws IOException {
        final int lineno = this.ts.lineno;
        pn = this.propertyAccess(chaining ? 111 : 109, pn);
        pn.setLineno(lineno);
        return pn;
    }
    
    private AstNode matchElementGet(final AstNode pn) throws IOException {
        final int pos = pn.getPosition();
        this.consumeToken();
        final int lb = this.ts.tokenBeg;
        int rb = -1;
        final int lineno = this.ts.lineno;
        final AstNode expr = this.expr();
        int end = this.getNodeEnd(expr);
        if (this.mustMatchToken(81, "msg.no.bracket.index")) {
            rb = this.ts.tokenBeg;
            end = this.ts.tokenEnd;
        }
        final ElementGet g = new ElementGet(pos, end - pos);
        g.setTarget(pn);
        g.setElement(expr);
        g.setParens(lb, rb);
        g.setLineno(lineno);
        return (AstNode)g;
    }
    
    private AstNode matchFunctionCall(final AstNode pn, final boolean allowCallSyntax) throws IOException {
        if (!allowCallSyntax) {
            return null;
        }
        final int pos = pn.getPosition();
        final int lineno = this.ts.lineno;
        this.consumeToken();
        this.checkCallRequiresActivation(pn);
        final FunctionCall f = new FunctionCall(pos);
        f.setTarget(pn);
        f.setLineno(lineno);
        f.setLp(this.ts.tokenBeg - pos);
        final List<AstNode> args = this.argumentList(true);
        if (args != null && args.size() > 65536) {
            this.reportError("msg.too.many.function.args");
        }
        f.setArguments((List)args);
        f.setRp(this.ts.tokenBeg - pos);
        f.setLength(this.ts.tokenEnd - pos);
        return (AstNode)f;
    }
    
    private AstNode propertyAccess(int tt, final AstNode pn) throws IOException {
        if (pn == null) {
            this.codeBug();
        }
        final int memberTypeFlags = 0;
        final int lineno = this.ts.lineno;
        final int dotPos = this.ts.tokenBeg;
        if (tt != 111) {
            this.consumeToken();
        }
        else {
            tt = 109;
        }
        boolean isPrivateAccess = false;
        if (this.matchToken(170)) {
            if (!this.insideClass) {
                this.reportError("msg.class.illegal.private.access");
                return (AstNode)this.makeErrorNode();
            }
            isPrivateAccess = true;
        }
        final int maybeName = this.nextToken();
        if (maybeName != 40 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective))) {
            this.reportError("msg.no.name.after.dot");
        }
        final Name name = this.createNameNode(true, 34);
        final PropertyGet pg = new PropertyGet(pn, name, dotPos);
        if (isPrivateAccess) {
            if (!this.accessedPrivateClassIdentifiers.containsKey(name.getIdentifier())) {
                this.accessedPrivateClassIdentifiers.put(name.getIdentifier(), this.ts.getPosition());
            }
            pg.putProp(34, (Object)true);
        }
        pg.setLineno(lineno);
        return (AstNode)pg;
    }
    
    private AstNode destructuringPrimaryExpr() throws IOException, ParserException {
        try {
            this.inDestructuringAssignment = true;
            return this.primaryExpr();
        }
        finally {
            this.inDestructuringAssignment = false;
        }
    }
    
    private AstNode primaryExpr() throws IOException {
        final int ttFlagged = this.peekFlaggedToken();
        final int tt = ttFlagged & 0xFFFF;
        AstNode pn = null;
        final List<DecoratorNode> decorators = new ArrayList<DecoratorNode>();
        switch (tt) {
            case 153: {
                return this.decoratedExpr();
            }
            case 114: {
                this.consumeToken();
                pn = (AstNode)this.function(2);
                break;
            }
            case 115: {
                this.consumeToken();
                pn = (AstNode)this.classExpr(decorators);
                break;
            }
            case 80: {
                this.consumeToken();
                pn = this.arrayLiteral();
                break;
            }
            case 82: {
                this.consumeToken();
                pn = (AstNode)this.objectLiteral();
                break;
            }
            case 158: {
                this.consumeToken();
                pn = this.let(false, this.ts.tokenBeg);
                break;
            }
            case 84: {
                this.consumeToken();
                pn = this.parenExpr();
                break;
            }
            case 118: {
                this.consumeToken();
                pn = this.name(ttFlagged, tt);
                pn.putProp(31, (Object)true);
                break;
            }
            case 40: {
                this.consumeToken();
                pn = this.name(ttFlagged, tt);
                break;
            }
            case 41: {
                this.consumeToken();
                String s = this.ts.getString();
                if (this.inUseStrictDirective && this.ts.isNumberOldOctal()) {
                    this.reportError("msg.no.old.octal.strict");
                }
                if (this.ts.isNumberBinary()) {
                    s = "0b" + s;
                }
                if (this.ts.isNumberOldOctal()) {
                    s = "0" + s;
                }
                if (this.ts.isNumberOctal()) {
                    s = "0o" + s;
                }
                if (this.ts.isNumberHex()) {
                    s = "0x" + s;
                }
                pn = (AstNode)new NumberLiteral(this.ts.tokenBeg, s, this.ts.getNumber());
                if (this.matchToken(153)) {
                    final DecoratorNode dn = this.decorator(false, true);
                    ((NumberLiteral)pn).setDecoratorNode(dn);
                    break;
                }
                break;
            }
            case 42: {
                this.consumeToken();
                pn = (AstNode)this.createStringLiteral();
                break;
            }
            case 24:
            case 97: {
                this.consumeToken();
                this.ts.readRegExp(tt);
                final int pos = this.ts.tokenBeg;
                final int end = this.ts.tokenEnd;
                final RegExpLiteral re = new RegExpLiteral(pos, end - pos);
                re.setValue(this.ts.getString());
                re.setFlags(this.ts.readAndClearRegExpFlags());
                pn = (AstNode)re;
                break;
            }
            case 43: {
                this.consumeToken();
                pn = this.templateLiteral(null);
                break;
            }
            case 45:
            case 46:
            case 47:
            case 48: {
                this.consumeToken();
                final int pos = this.ts.tokenBeg;
                final int end = this.ts.tokenEnd;
                pn = (AstNode)new KeywordLiteral(pos, end - pos, tt);
                break;
            }
            case 137: {
                this.consumeToken();
                if (this.compilerEnv.isReservedKeywordAsIdentifier() && TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    pn = this.name(ttFlagged, tt);
                    break;
                }
                this.reportError("msg.reserved.id", this.ts.getString());
                break;
            }
            case -1: {
                this.consumeToken();
                break;
            }
            case 0: {
                this.consumeToken();
                this.reportError("msg.unexpected.eof");
                break;
            }
            default: {
                this.consumeToken();
                this.reportError("msg.syntax");
                break;
            }
        }
        return pn;
    }
    
    private AstNode templateLiteral(final AstNode target) throws IOException {
        int token = this.peekToken();
        final TemplateLiteral lit = new TemplateLiteral();
        while (token != 43) {
            if (token == 42) {
                final String str = this.ts.getString();
                if (!str.equals("")) {
                    lit.addString(str);
                }
                this.consumeToken();
            }
            else if (token == 44) {
                this.consumeToken();
                lit.addExpr(this.expr());
            }
            else {
                if (token != 83) {
                    throw Kit.codeBug();
                }
                this.ts.setTemplateExprFinished();
                this.consumeToken();
            }
            token = this.peekToken();
        }
        this.consumeToken();
        lit.setRawElements(this.ts.getRawLiterals());
        lit.setTarget(target);
        return (AstNode)lit;
    }
    
    private AstNode parenExpr() throws IOException {
        final boolean wasInForInit = this.inForInit;
        this.inForInit = false;
        try {
            Comment jsdocNode = this.getAndResetJsDoc();
            final int lineno = this.ts.lineno;
            final int begin = this.ts.tokenBeg;
            final AstNode e = (AstNode)((this.peekToken() == 85) ? new EmptyExpression(begin) : this.expr());
            if (this.peekToken() == 128) {
                return this.generatorExpression(e, begin);
            }
            this.mustMatchToken(85, "msg.no.paren");
            if (this.peekToken() == 87) {
                this.reportError("msg.bad.assign.left");
            }
            if (e.getType() == 138 && this.peekToken() != 169) {
                this.reportError("msg.syntax");
                return (AstNode)this.makeErrorNode();
            }
            final int length = this.ts.tokenEnd - begin;
            final ParenthesizedExpression pn = new ParenthesizedExpression(begin, length, e);
            pn.setLineno(lineno);
            if (jsdocNode == null) {
                jsdocNode = this.getAndResetJsDoc();
            }
            if (jsdocNode != null) {
                pn.setJsDocNode(jsdocNode);
            }
            return (AstNode)pn;
        }
        finally {
            this.inForInit = wasInForInit;
        }
    }
    
    private AstNode name(final int ttFlagged, final int tt) throws IOException {
        final String nameString = this.ts.getString();
        final int namePos = this.ts.tokenBeg;
        final int nameLineno = this.ts.lineno;
        if (0x0 != (ttFlagged & 0x20000) && this.peekToken() == 104) {
            final Label label = new Label(namePos, this.ts.tokenEnd - namePos);
            label.setName(nameString);
            label.setLineno(this.ts.lineno);
            return (AstNode)label;
        }
        this.saveNameTokenData(namePos, nameString, nameLineno);
        return (AstNode)this.createNameNode(true, 40);
    }
    
    private AstNode arrayLiteral() throws IOException {
        if (this.currentToken != 80) {
            this.codeBug();
        }
        final int pos = this.ts.tokenBeg;
        int end = this.ts.tokenEnd;
        final List<AstNode> elements = new ArrayList<AstNode>();
        final ArrayLiteral pn = new ArrayLiteral(pos);
        boolean after_lb_or_comma = true;
        int afterComma = -1;
        int skipCount = 0;
        while (true) {
            final int tt = this.peekToken();
            if (tt == 86) {
                this.consumeToken();
                afterComma = this.ts.tokenEnd;
                if (!after_lb_or_comma) {
                    after_lb_or_comma = true;
                }
                else {
                    elements.add((AstNode)new EmptyExpression(this.ts.tokenBeg, 1));
                    ++skipCount;
                }
            }
            else if (tt == 166) {
                this.consumeToken();
            }
            else if (tt == 81) {
                this.consumeToken();
                end = this.ts.tokenEnd;
                pn.setDestructuringLength(elements.size() + (after_lb_or_comma ? 1 : 0));
                pn.setSkipCount(skipCount);
                if (afterComma != -1) {
                    this.warnTrailingComma(pos, elements, afterComma);
                    break;
                }
                break;
            }
            else if (tt == 110) {
                this.consumeToken();
                final AstNode expr = this.assignExpr();
                if (this.inDestructuringAssignment && expr instanceof Assignment) {
                    this.reportError("msg.rest.no.defaults");
                }
                expr.putProp(29, (Object)true);
                elements.add(expr);
                after_lb_or_comma = (0 != 0);
                afterComma = -1;
                if (!this.inDestructuringAssignment || this.peekToken() != 86) {
                    continue;
                }
                this.reportError("msg.rest.not.last");
            }
            else {
                if (tt == 0) {
                    this.reportError("msg.no.bracket.arg");
                    break;
                }
                if (!after_lb_or_comma) {
                    this.reportError("msg.no.bracket.arg");
                }
                elements.add(this.assignExpr());
                after_lb_or_comma = (0 != 0);
                afterComma = -1;
            }
        }
        for (final AstNode e : elements) {
            pn.addElement(e);
        }
        pn.setLength(end - pos);
        return (AstNode)pn;
    }
    
    private AstNode generatorExpression(final AstNode result, final int pos) throws IOException {
        final List<GeneratorExpressionLoop> loops = new ArrayList<GeneratorExpressionLoop>();
        while (this.peekToken() == 128) {
            loops.add(this.generatorExpressionLoop());
        }
        int ifPos = -1;
        ConditionData data = null;
        if (this.peekToken() == 121) {
            this.consumeToken();
            ifPos = this.ts.tokenBeg - pos;
            data = this.condition();
        }
        this.mustMatchToken(85, "msg.no.paren.let");
        final GeneratorExpression pn = new GeneratorExpression(pos, this.ts.tokenEnd - pos);
        pn.setResult(result);
        pn.setLoops((List)loops);
        if (data != null) {
            pn.setIfPosition(ifPos);
            pn.setFilter(data.condition);
            pn.setFilterLp(data.lp - pos);
            pn.setFilterRp(data.rp - pos);
        }
        return (AstNode)pn;
    }
    
    private GeneratorExpressionLoop generatorExpressionLoop() throws IOException {
        if (this.nextToken() != 128) {
            this.codeBug();
        }
        final int pos = this.ts.tokenBeg;
        int lp = -1;
        int rp = -1;
        int inPos = -1;
        final GeneratorExpressionLoop pn = new GeneratorExpressionLoop(pos);
        this.pushScope((Scope)pn);
        try {
            if (this.mustMatchToken(84, "msg.no.paren.for")) {
                lp = this.ts.tokenBeg - pos;
            }
            AstNode iter = null;
            switch (this.peekToken()) {
                case 80:
                case 82: {
                    iter = this.destructuringPrimaryExpr();
                    this.markDestructuring(iter);
                    break;
                }
                case 40: {
                    this.consumeToken();
                    iter = (AstNode)this.createNameNode();
                    break;
                }
                default: {
                    this.reportError("msg.bad.var");
                    break;
                }
            }
            if (iter.getType() == 40) {
                this.defineSymbol(158, this.ts.getString(), true);
            }
            if (this.mustMatchToken(55, "msg.in.after.for.name")) {
                inPos = this.ts.tokenBeg - pos;
            }
            final AstNode obj = this.expr();
            if (this.mustMatchToken(85, "msg.no.paren.for.ctrl")) {
                rp = this.ts.tokenBeg - pos;
            }
            pn.setLength(this.ts.tokenEnd - pos);
            pn.setIterator(iter);
            pn.setIteratedObject(obj);
            pn.setInPosition(inPos);
            pn.setParens(lp, rp);
            return pn;
        }
        finally {
            this.popScope();
        }
    }
    
    private ObjectLiteral objectLiteral() throws IOException {
        final int pos = this.ts.tokenBeg;
        final int lineno = this.ts.lineno;
        int afterComma = -1;
        final List<ObjectProperty> elems = new ArrayList<ObjectProperty>();
        Set<String> getterNames = null;
        Set<String> setterNames = null;
        boolean seenProto = false;
        if (this.inUseStrictDirective) {
            getterNames = new HashSet<String>();
            setterNames = new HashSet<String>();
        }
        final Comment objJsdocNode = this.getAndResetJsDoc();
        while (true) {
            String propertyName = null;
            int entryKind = 1;
            int tt = this.peekToken();
            final Comment jsdocNode = this.getAndResetJsDoc();
            if (tt == 166) {
                this.consumeToken();
                tt = this.peekUntilNonComment(tt);
            }
            if (tt == 83) {
                if (afterComma != -1) {
                    this.warnTrailingComma(pos, elems, afterComma);
                    break;
                }
                break;
            }
            else {
                AstNode pname = this.objliteralProperty();
                if (pname == null && this.peekToken() != 23) {
                    this.reportError("msg.bad.prop");
                }
                else {
                    propertyName = this.ts.getString();
                    if ("__proto__".equals(propertyName)) {
                        if (seenProto) {
                            this.reportError("msg.object.multiple.proto");
                        }
                        else {
                            seenProto = true;
                        }
                    }
                    final int ppos = this.ts.tokenBeg;
                    final int peeked = this.peekToken();
                    if (peeked != 86 && peeked != 104 && peeked != 83 && peeked != 87) {
                        if (peeked == 84) {
                            entryKind = 8;
                        }
                        else if (peeked == 23) {
                            entryKind = 16;
                            this.consumeToken();
                        }
                        else if (pname.getType() == 40) {
                            if ("get".equals(propertyName)) {
                                entryKind = 2;
                            }
                            else if ("set".equals(propertyName)) {
                                entryKind = 4;
                            }
                        }
                        if (entryKind == 2 || entryKind == 4 || entryKind == 16) {
                            pname = this.objliteralProperty();
                            if (pname == null) {
                                this.reportError("msg.bad.prop");
                            }
                            this.consumeToken();
                        }
                        if (pname == null) {
                            propertyName = null;
                        }
                        else {
                            propertyName = this.ts.getString();
                            final ObjectProperty objectProp = this.methodDefinition(ppos, pname, entryKind);
                            pname.setJsDocNode(jsdocNode);
                            elems.add(objectProp);
                        }
                    }
                    else {
                        pname.setJsDocNode(jsdocNode);
                        elems.add(this.plainProperty(pname, tt));
                    }
                }
                if (this.inUseStrictDirective && propertyName != null) {
                    switch (entryKind) {
                        case 1:
                        case 8: {
                            getterNames.add(propertyName);
                            setterNames.add(propertyName);
                            break;
                        }
                        case 2: {
                            getterNames.add(propertyName);
                            break;
                        }
                        case 4: {
                            setterNames.add(propertyName);
                            break;
                        }
                    }
                }
                this.getAndResetJsDoc();
                if (!this.matchToken(86)) {
                    break;
                }
                afterComma = this.ts.tokenEnd;
            }
        }
        this.mustMatchToken(83, "msg.no.brace.prop");
        if (this.assumeDestructuring) {
            if (this.peekToken() != 87) {
                this.reportError("msg.unexpected.object.init");
            }
            this.assumeDestructuring = false;
            this.inDestructuringAssignment = false;
        }
        final ObjectLiteral pn = new ObjectLiteral(pos, this.ts.tokenEnd - pos);
        if (objJsdocNode != null) {
            pn.setJsDocNode(objJsdocNode);
        }
        pn.setElements((List)elems);
        pn.setLineno(lineno);
        return pn;
    }
    
    private AstNode objliteralProperty() throws IOException {
        final int tt = this.peekToken();
        AstNode pname = null;
        switch (tt) {
            case 40: {
                pname = (AstNode)this.createNameNode();
                this.consumeToken();
                break;
            }
            case 42: {
                pname = (AstNode)this.createStringLiteral();
                this.consumeToken();
                break;
            }
            case 41: {
                pname = (AstNode)new NumberLiteral(this.ts.tokenBeg, this.ts.getString(), this.ts.getNumber());
                this.consumeToken();
                break;
            }
            case 80: {
                this.consumeToken();
                pname = this.assignExpr();
                pname.putProp(28, (Object)true);
                if (!this.matchToken(81)) {
                    this.reportError("msg.bad.object.init");
                }
                this.consumeToken();
                break;
            }
            case 110: {
                this.consumeToken();
                pname = this.memberExpr(true);
                pname.putProp(29, (Object)true);
                break;
            }
            default: {
                if (this.compilerEnv.isReservedKeywordAsIdentifier() && TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    pname = (AstNode)this.createNameNode();
                    this.consumeToken();
                    break;
                }
                return null;
            }
        }
        return pname;
    }
    
    private ObjectProperty plainProperty(final AstNode property, final int ptt) throws IOException {
        final int tt = this.peekToken();
        if (ptt == 110) {
            if (tt != 86 && tt != 83) {
                this.reportError("msg.obj.spread.extra");
            }
            final ObjectProperty pn = new ObjectProperty();
            pn.setSpread(property);
            return pn;
        }
        if ((tt == 86 || tt == 83 || tt == 87) && ptt == 40 && this.compilerEnv.getLanguageVersion() >= 180) {
            if (!this.inDestructuringAssignment) {
                if (tt == 87) {
                    this.assumeDestructuring = true;
                    this.inDestructuringAssignment = true;
                }
                else {
                    if (property.getProp(28) == null) {
                        final AstNode nn = (AstNode)new Name(property.getPosition(), property.getString());
                        final ObjectProperty pn2 = new ObjectProperty();
                        pn2.setLeftAndRight(property, nn);
                        return pn2;
                    }
                    this.reportError("msg.bad.object.init");
                }
            }
            final AstNode nn = (AstNode)new Name(property.getPosition(), property.getString());
            final ObjectProperty pn2 = new ObjectProperty();
            pn2.putProp(26, (Object)Boolean.TRUE);
            if (tt == 87) {
                this.consumeToken();
                final AstNode exp = this.condExpr();
                pn2.setDefaultValue(exp);
            }
            pn2.setLeftAndRight(property, nn);
            return pn2;
        }
        this.mustMatchToken(104, "msg.no.colon.prop");
        final ObjectProperty pn = new ObjectProperty();
        pn.setOperatorPosition(this.ts.tokenBeg);
        final AstNode exp2 = this.assignExpr();
        if (exp2 instanceof Assignment) {
            final Assignment as = (Assignment)exp2;
            pn.setLeftAndRight(property, as.getLeft());
            pn.setDefaultValue(as.getRight());
        }
        else {
            pn.setLeftAndRight(property, exp2);
        }
        return pn;
    }
    
    private ObjectProperty methodDefinition(final int pos, final AstNode propName, final int entryKind) throws IOException {
        final FunctionNode fn = this.function(2, entryKind);
        final Name name = fn.getFunctionName();
        if (name != null && name.length() != 0) {
            this.reportError("msg.bad.prop");
        }
        final ObjectProperty pn = new ObjectProperty(pos);
        switch (entryKind) {
            case 2: {
                pn.setIsGetterMethod();
                fn.setFunctionIsGetterMethod();
                break;
            }
            case 4: {
                pn.setIsSetterMethod();
                fn.setFunctionIsSetterMethod();
                break;
            }
            case 8: {
                pn.setIsNormalMethod();
                fn.setFunctionIsNormalMethod();
                break;
            }
        }
        final int end = this.getNodeEnd((AstNode)fn);
        pn.setLeft(propName);
        pn.setRight((AstNode)fn);
        pn.setLength(end - pos);
        return pn;
    }
    
    private Name createNameNode() {
        return this.createNameNode(false, 40);
    }
    
    private Name createNameNode(final boolean checkActivation, final int token) {
        int beg = this.ts.tokenBeg;
        String s = this.ts.getString();
        int lineno = this.ts.lineno;
        if (!"".equals(this.prevNameTokenString)) {
            beg = this.prevNameTokenStart;
            s = this.prevNameTokenString;
            lineno = this.prevNameTokenLineno;
            this.prevNameTokenStart = 0;
            this.prevNameTokenString = "";
            this.prevNameTokenLineno = 0;
        }
        if (s == null) {
            if (this.compilerEnv.isIdeMode()) {
                s = "";
            }
            else {
                this.codeBug();
            }
        }
        final Name name = new Name(beg, s);
        name.setLineno(lineno);
        if (checkActivation) {
            this.checkActivationName(s, token);
        }
        return name;
    }
    
    private StringLiteral createStringLiteral() {
        final int pos = this.ts.tokenBeg;
        final int end = this.ts.tokenEnd;
        final StringLiteral s = new StringLiteral(pos, end - pos);
        s.setLineno(this.ts.lineno);
        s.setValue(this.ts.getString());
        s.setQuoteCharacter(this.ts.getQuoteChar());
        return s;
    }
    
    protected void checkActivationName(final String name, final int token) {
        if (!this.insideFunction()) {
            return;
        }
        boolean activation = false;
        if ("arguments".equals(name) && ((FunctionNode)this.currentScriptOrFn).getFunctionType() != 4) {
            activation = true;
        }
        else if (this.compilerEnv.getActivationNames() != null && this.compilerEnv.getActivationNames().contains(name)) {
            activation = true;
        }
        else if ("length".equals(name) && token == 34 && this.compilerEnv.getLanguageVersion() == 120) {
            activation = true;
        }
        if (activation) {
            this.setRequiresActivation();
        }
    }
    
    protected void setRequiresActivation() {
        if (this.insideFunction()) {
            ((FunctionNode)this.currentScriptOrFn).setRequiresActivation();
        }
    }
    
    private void checkCallRequiresActivation(final AstNode pn) {
        if ((pn.getType() == 40 && "eval".equals(((Name)pn).getIdentifier())) || (pn.getType() == 34 && "eval".equals(((PropertyGet)pn).getProperty().getIdentifier()))) {
            this.setRequiresActivation();
        }
    }
    
    protected void setIsGenerator() {
        if (this.insideFunction()) {
            ((FunctionNode)this.currentScriptOrFn).setIsGenerator();
        }
    }
    
    private void checkBadIncDec(final UnaryExpression expr) {
        final AstNode op = this.removeParens(expr.getOperand());
        final int tt = op.getType();
        if (tt != 40 && tt != 34 && tt != 37 && tt != 71 && tt != 39) {
            this.reportError((expr.getType() == 107) ? "msg.bad.incr" : "msg.bad.decr");
        }
    }
    
    private ErrorNode makeErrorNode() {
        final ErrorNode pn = new ErrorNode(this.ts.tokenBeg, this.ts.tokenEnd - this.ts.tokenBeg);
        pn.setLineno(this.ts.lineno);
        return pn;
    }
    
    private int nodeEnd(final AstNode node) {
        return node.getPosition() + node.getLength();
    }
    
    private void saveNameTokenData(final int pos, final String name, final int lineno) {
        this.prevNameTokenStart = pos;
        this.prevNameTokenString = name;
        this.prevNameTokenLineno = lineno;
    }
    
    private int lineBeginningFor(int pos) {
        if (this.sourceChars == null) {
            return -1;
        }
        if (pos <= 0) {
            return 0;
        }
        final char[] buf = this.sourceChars;
        if (pos >= buf.length) {
            pos = buf.length - 1;
        }
        while (--pos >= 0) {
            final char c = buf[pos];
            if (ScriptRuntime.isJSLineTerminator(c)) {
                return pos + 1;
            }
        }
        return 0;
    }
    
    private void warnMissingSemi(final int pos, final int end) {
        if (this.compilerEnv.isStrictMode()) {
            final int[] linep = new int[2];
            final String line = this.ts.getLine(end, linep);
            final int beg = this.compilerEnv.isIdeMode() ? Math.max(pos, end - linep[1]) : pos;
            if (line != null) {
                this.addStrictWarning("msg.missing.semi", "", beg, end - beg, linep[0], line, linep[1]);
            }
            else {
                this.addStrictWarning("msg.missing.semi", "", beg, end - beg);
            }
        }
    }
    
    private void warnTrailingComma(int pos, final List<?> elems, final int commaPos) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!elems.isEmpty()) {
                pos = ((AstNode)elems.get(0)).getPosition();
            }
            pos = Math.max(pos, this.lineBeginningFor(commaPos));
            this.addWarning("msg.extra.trailing.comma", pos, commaPos - pos);
        }
    }
    
    Node createDestructuringAssignment(final int type, final Node left, final Node right) {
        final String tempName = this.currentScriptOrFn.getNextTempName();
        final Node result = this.destructuringAssignmentHelper(type, left, right, tempName);
        final Node comma = result.getLastChild();
        comma.addChildToBack(this.createName(tempName));
        return result;
    }
    
    Node destructuringAssignmentHelper(final int variableType, final Node left, final Node right, final String tempName) {
        final Scope result = this.createScopeNode(163, left.getLineno());
        result.addChildToFront(new Node(158, this.createName(40, tempName, right)));
        try {
            this.pushScope(result);
            this.defineSymbol(158, tempName, true);
        }
        finally {
            this.popScope();
        }
        final Node comma = new Node(86);
        result.addChildToBack(comma);
        final List<String> destructuringNames = new ArrayList<String>();
        boolean empty = true;
        switch (left.getType()) {
            case 69: {
                empty = this.destructuringArray((ArrayLiteral)left, right, variableType, tempName, comma, destructuringNames);
                break;
            }
            case 70: {
                empty = this.destructuringObject((ObjectLiteral)left, variableType, tempName, comma, destructuringNames);
                break;
            }
            case 34:
            case 37: {
                switch (variableType) {
                    case 131:
                    case 158:
                    case 159: {
                        this.reportError("msg.bad.assign.left");
                        break;
                    }
                }
                comma.addChildToBack(this.simpleAssignment(left, this.createName(tempName)));
                break;
            }
            default: {
                this.reportError("msg.bad.assign.left");
                break;
            }
        }
        if (empty) {
            comma.addChildToBack(this.createNumber(0.0));
        }
        result.putProp(22, (Object)destructuringNames);
        return (Node)result;
    }
    
    boolean destructuringArray(final ArrayLiteral left, final Node right, final int variableType, final String tempName, final Node parent, final List<String> destructuringNames) {
        boolean empty = true;
        final int setOp = (variableType == 159) ? 160 : 8;
        int index = 0;
        for (final AstNode n : left.getElements()) {
            if (n.getType() == 138) {
                ++index;
            }
            else {
                Node rightElem = new Node(37, this.createName(tempName), this.createNumber(index));
                if (n.getProp(29) != null) {
                    rightElem.putProp(29, (Object)new Object[] { index, right });
                }
                if (n.getType() == 40) {
                    final String name = n.getString();
                    parent.addChildToBack(new Node(setOp, this.createName(52, name, null), rightElem));
                    if (variableType != -1) {
                        this.defineSymbol(variableType, name, true);
                        destructuringNames.add(name);
                    }
                }
                else if (n.getType() == 87) {
                    final Assignment assignment = (Assignment)n;
                    final String name2 = assignment.getLeft().getString();
                    final Node defaultExpr = (Node)((this instanceof IRFactory) ? ((IRFactory)this).transform(assignment.getRight()) : assignment.getRight());
                    rightElem = new Node(125, rightElem, defaultExpr);
                    parent.addChildToBack(new Node(setOp, this.createName(52, name2, null), rightElem));
                    if (variableType != -1) {
                        this.defineSymbol(variableType, name2, true);
                        destructuringNames.add(name2);
                    }
                }
                else {
                    parent.addChildToBack(this.destructuringAssignmentHelper(variableType, (Node)n, rightElem, this.currentScriptOrFn.getNextTempName()));
                }
                ++index;
                empty = false;
            }
        }
        return empty;
    }
    
    boolean destructuringObject(final ObjectLiteral node, final int variableType, final String tempName, final Node parent, final List<String> destructuringNames) {
        boolean empty = true;
        final int setOp = (variableType == 159) ? 160 : 8;
        final List<Object> alreadyTaken = new ArrayList<Object>();
        for (final ObjectProperty prop : node.getElements()) {
            int lineno = 0;
            if (this.ts != null) {
                lineno = this.ts.lineno;
            }
            final AstNode spread = prop.getSpread();
            Node rightElem;
            if (spread != null) {
                final Node s = Node.newString(((Name)spread).getIdentifier());
                rightElem = new Node(110, this.createName(tempName), s);
                rightElem.putProp(32, (Object)alreadyTaken.toArray());
            }
            else {
                final AstNode id = prop.getLeft();
                if (id.getProp(28) != null) {
                    if (this instanceof IRFactory) {
                        final Node s2 = ((IRFactory)this).transform(id);
                        rightElem = new Node(37, this.createName(tempName), s2);
                    }
                    else {
                        rightElem = new Node(37, this.createName(tempName), (Node)id);
                    }
                }
                else if (id.getProp(29) != null) {
                    final Node s2 = Node.newString(((Name)id).getIdentifier());
                    rightElem = new Node(110, this.createName(tempName), s2);
                    rightElem.putProp(32, (Object)alreadyTaken.toArray());
                }
                else if (id instanceof Name) {
                    final Node s2 = Node.newString(((Name)id).getIdentifier());
                    alreadyTaken.add(((Name)id).getIdentifier());
                    rightElem = new Node(34, this.createName(tempName), s2);
                }
                else if (id instanceof StringLiteral) {
                    final Node s2 = Node.newString(((StringLiteral)id).getValue());
                    alreadyTaken.add(((StringLiteral)id).getValue());
                    rightElem = new Node(34, this.createName(tempName), s2);
                }
                else {
                    if (!(id instanceof NumberLiteral)) {
                        throw this.codeBug();
                    }
                    final Node s2 = this.createNumber((int)((NumberLiteral)id).getNumber());
                    alreadyTaken.add((int)((NumberLiteral)id).getNumber());
                    rightElem = new Node(37, this.createName(tempName), s2);
                }
            }
            rightElem.setLineno(lineno);
            final AstNode value = (spread != null) ? spread : prop.getRight();
            final AstNode defaultValue = prop.getDefaultValue();
            if (defaultValue != null) {
                final Node defaultExpr = (Node)((this instanceof IRFactory) ? ((IRFactory)this).transform(defaultValue) : defaultValue);
                rightElem = new Node(125, rightElem, defaultExpr);
            }
            if (value.getType() == 40) {
                final String name = ((Name)value).getIdentifier();
                parent.addChildToBack(new Node(setOp, this.createName(52, name, null), rightElem));
                if (variableType != -1) {
                    this.defineSymbol(variableType, name, true);
                    destructuringNames.add(name);
                }
            }
            else {
                parent.addChildToBack(this.destructuringAssignmentHelper(variableType, (Node)value, rightElem, this.currentScriptOrFn.getNextTempName()));
            }
            empty = false;
        }
        return empty;
    }
    
    protected Node createName(final String name) {
        this.checkActivationName(name, 40);
        return Node.newString(40, name);
    }
    
    protected Node createName(final int type, final String name, final Node child) {
        final Node result = this.createName(name);
        result.setType(type);
        if (child != null) {
            result.addChildToBack(child);
        }
        return result;
    }
    
    protected Node createNumber(final double number) {
        return Node.newNumber(number);
    }
    
    protected Scope createScopeNode(final int token, final int lineno) {
        final Scope scope = new Scope();
        scope.setType(token);
        scope.setLineno(lineno);
        return scope;
    }
    
    protected Node simpleAssignment(final Node left, final Node right) {
        final int nodeType = left.getType();
        switch (nodeType) {
            case 40: {
                final String name = ((Name)left).getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(name) || "arguments".equals(name))) {
                    this.reportError("msg.bad.id.strict", name);
                }
                left.setType(52);
                return new Node(8, left, right);
            }
            case 34:
            case 37: {
                final boolean isPrivate = left.getProp(34) != null;
                Node obj;
                Node id;
                if (left instanceof PropertyGet) {
                    obj = (Node)((PropertyGet)left).getTarget();
                    id = (Node)((PropertyGet)left).getProperty();
                }
                else if (left instanceof ElementGet) {
                    obj = (Node)((ElementGet)left).getTarget();
                    id = (Node)((ElementGet)left).getElement();
                }
                else {
                    obj = left.getFirstChild();
                    id = left.getLastChild();
                }
                int type;
                if (nodeType == 34) {
                    type = 36;
                    id.setType(42);
                }
                else {
                    type = 38;
                }
                final Node node = new Node(type, obj, id, right);
                if (isPrivate) {
                    node.putProp(34, (Object)true);
                }
                return node;
            }
            case 71: {
                final Node ref = left.getFirstChild();
                this.checkMutableReference(ref);
                return new Node(72, ref, right);
            }
            default: {
                throw this.codeBug();
            }
        }
    }
    
    protected void checkMutableReference(final Node n) {
        final int memberTypeFlags = n.getIntProp(16, 0);
        if ((memberTypeFlags & 0x4) != 0x0) {
            this.reportError("msg.bad.assign.left");
        }
    }
    
    protected AstNode removeParens(AstNode node) {
        while (node instanceof ParenthesizedExpression) {
            node = ((ParenthesizedExpression)node).getExpression();
        }
        return node;
    }
    
    void markDestructuring(final AstNode node) {
        if (node instanceof DestructuringForm) {
            ((DestructuringForm)node).setIsDestructuring(true);
        }
        else if (node instanceof ParenthesizedExpression) {
            this.markDestructuring(((ParenthesizedExpression)node).getExpression());
        }
    }
    
    private RuntimeException codeBug() throws RuntimeException {
        throw Kit.codeBug("ts.cursor=" + this.ts.cursor + ", ts.tokenBeg=" + this.ts.tokenBeg + ", currentToken=" + this.currentToken);
    }
    
    public void setDefaultUseStrictDirective(final boolean useStrict) {
        this.defaultUseStrictDirective = useStrict;
    }
    
    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }
    
    private static class ParserException extends RuntimeException
    {
        private static final long serialVersionUID = 5882582646773765630L;
    }
    
    private static class ConditionData
    {
        AstNode condition;
        int lp;
        int rp;
        
        private ConditionData() {
            this.lp = -1;
            this.rp = -1;
        }
    }
    
    protected class PerFunctionVariables
    {
        private ScriptNode savedCurrentScriptOrFn;
        private Scope savedCurrentScope;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Loop> savedLoopSet;
        private List<Jump> savedLoopAndSwitchSet;
        
        PerFunctionVariables(final FunctionNode fnNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = (ScriptNode)fnNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = (Scope)fnNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }
        
        void restore() {
            Parser.this.currentScriptOrFn = this.savedCurrentScriptOrFn;
            Parser.this.currentScope = this.savedCurrentScope;
            Parser.this.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }
}
