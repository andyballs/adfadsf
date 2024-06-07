//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import org.mozilla.javascript.*;
import java.util.*;

public class FunctionNode extends ScriptNode
{
    public static final int FUNCTION_STATEMENT = 1;
    public static final int FUNCTION_EXPRESSION = 2;
    public static final int FUNCTION_EXPRESSION_STATEMENT = 3;
    public static final int ARROW_FUNCTION = 4;
    private static final List<AstNode> NO_PARAMS;
    private static final Map<Integer, Node> NO_DEFAULT_PARAMS;
    private Name functionName;
    private List<AstNode> params;
    private Map<Integer, Node> defaultParams;
    private boolean hasComplexParameters;
    private AstNode body;
    private boolean isExpressionClosure;
    private boolean isConstructable;
    private ClassNode parentClass;
    private boolean isStatic;
    private boolean isPrivate;
    private Form functionForm;
    private int lp;
    private int rp;
    private int functionType;
    private boolean needsActivation;
    private boolean isGenerator;
    private List<Node> generatorResumePoints;
    private Map<Node, int[]> liveLocals;
    
    public FunctionNode() {
        this.hasComplexParameters = false;
        this.isConstructable = true;
        this.parentClass = null;
        this.isStatic = false;
        this.isPrivate = false;
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.generatorResumePoints = new ArrayList<Node>();
        this.type = 114;
    }
    
    public FunctionNode(final int pos) {
        super(pos);
        this.hasComplexParameters = false;
        this.isConstructable = true;
        this.parentClass = null;
        this.isStatic = false;
        this.isPrivate = false;
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.generatorResumePoints = new ArrayList<Node>();
        this.type = 114;
    }
    
    public FunctionNode(final int pos, final Name name) {
        super(pos);
        this.hasComplexParameters = false;
        this.isConstructable = true;
        this.parentClass = null;
        this.isStatic = false;
        this.isPrivate = false;
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.generatorResumePoints = new ArrayList<Node>();
        this.type = 114;
        this.setFunctionName(name);
    }
    
    public Name getFunctionName() {
        return this.functionName;
    }
    
    public void setFunctionName(final Name name) {
        this.functionName = name;
        if (name != null) {
            name.setParent((AstNode)this);
        }
    }
    
    public String getName() {
        return (this.functionName != null) ? this.functionName.getIdentifier() : "";
    }
    
    public List<AstNode> getParams() {
        return (this.params != null) ? this.params : FunctionNode.NO_PARAMS;
    }
    
    public boolean hasComplexParameters() {
        return this.hasComplexParameters;
    }
    
    public void setHasComplexParameters() {
        this.hasComplexParameters = true;
    }
    
    public Map<Integer, Node> getDefaultParams() {
        return (this.defaultParams != null) ? this.defaultParams : FunctionNode.NO_DEFAULT_PARAMS;
    }
    
    public void setDefaultParam(final int index, final Node transformed) {
        this.defaultParams.put(index, transformed);
    }
    
    public void setParams(final List<AstNode> params) {
        if (params == null) {
            this.params = null;
        }
        else {
            if (this.params != null) {
                this.params.clear();
            }
            for (final AstNode param : params) {
                this.addParam(param);
            }
        }
    }
    
    public void addParam(final AstNode param) {
        this.assertNotNull((Object)param);
        if (this.params == null) {
            this.params = new ArrayList<AstNode>();
        }
        this.params.add(param);
        param.setParent((AstNode)this);
    }
    
    public void addDefaultParam(final int index, final AstNode defaultParam) {
        this.assertNotNull((Object)defaultParam);
        if (this.defaultParams == null) {
            this.defaultParams = new HashMap<Integer, Node>();
        }
        this.defaultParams.put(index, (Node)defaultParam);
        defaultParam.setParent((AstNode)this);
    }
    
    public boolean isParam(final AstNode node) {
        return this.params != null && this.params.contains(node);
    }
    
    public AstNode getBody() {
        return this.body;
    }
    
    public void setBody(final AstNode body) {
        this.assertNotNull((Object)body);
        this.body = body;
        if (Boolean.TRUE.equals(body.getProp(25))) {
            this.setIsExpressionClosure(true);
        }
        final int absEnd = body.getPosition() + body.getLength();
        body.setParent((AstNode)this);
        this.setLength(absEnd - this.position);
        this.setEncodedSourceBounds(this.position, absEnd);
    }
    
    public int getLp() {
        return this.lp;
    }
    
    public void setLp(final int lp) {
        this.lp = lp;
    }
    
    public int getRp() {
        return this.rp;
    }
    
    public void setRp(final int rp) {
        this.rp = rp;
    }
    
    public void setParens(final int lp, final int rp) {
        this.lp = lp;
        this.rp = rp;
    }
    
    public boolean isExpressionClosure() {
        return this.isExpressionClosure;
    }
    
    public void setIsExpressionClosure(final boolean isExpressionClosure) {
        this.isExpressionClosure = isExpressionClosure;
    }
    
    public boolean isConstructable() {
        return this.isConstructable;
    }
    
    public void setConstructable(final boolean constructable) {
        this.isConstructable = constructable;
    }
    
    public boolean isClassConstructor() {
        return this.parentClass != null;
    }
    
    public ClassNode getParentClass() {
        return this.parentClass;
    }
    
    public void setParentClass(final ClassNode classConstructor) {
        this.parentClass = classConstructor;
    }
    
    public boolean isStatic() {
        return this.isStatic;
    }
    
    public void setStatic(final boolean aStatic) {
        this.isStatic = aStatic;
    }
    
    public boolean isPrivate() {
        return this.isPrivate;
    }
    
    public void setPrivate(final boolean aPrivate) {
        this.isPrivate = aPrivate;
    }
    
    public boolean requiresActivation() {
        return this.needsActivation;
    }
    
    public void setRequiresActivation() {
        this.needsActivation = true;
    }
    
    public boolean isGenerator() {
        return this.isGenerator;
    }
    
    public void setIsGenerator() {
        this.isConstructable = false;
        this.isGenerator = true;
    }
    
    public void addResumptionPoint(final Node target) {
        this.generatorResumePoints.add(target);
    }
    
    public List<Node> getResumptionPoints() {
        return this.generatorResumePoints;
    }
    
    public Map<Node, int[]> getLiveLocals() {
        return this.liveLocals;
    }
    
    public void addLiveLocals(final Node node, final int[] locals) {
        if (this.liveLocals == null) {
            this.liveLocals = new HashMap<Node, int[]>();
        }
        this.liveLocals.put(node, locals);
    }
    
    @Override
    public int addFunction(final FunctionNode fnNode) {
        final int result = super.addFunction(fnNode);
        if (this.getFunctionCount() > 0) {
            this.needsActivation = true;
        }
        return result;
    }
    
    public int getFunctionType() {
        return this.functionType;
    }
    
    public void setFunctionType(final int type) {
        this.functionType = type;
    }
    
    public boolean isMethod() {
        return this.functionForm == Form.GETTER || this.functionForm == Form.SETTER || this.functionForm == Form.METHOD;
    }
    
    public boolean isGetterMethod() {
        return this.functionForm == Form.GETTER;
    }
    
    public boolean isSetterMethod() {
        return this.functionForm == Form.SETTER;
    }
    
    public boolean isNormalMethod() {
        return this.functionForm == Form.METHOD;
    }
    
    public void setFunctionIsGetterMethod() {
        this.functionForm = Form.GETTER;
    }
    
    public void setFunctionIsSetterMethod() {
        this.functionForm = Form.SETTER;
    }
    
    public void setFunctionIsNormalMethod() {
        this.functionForm = Form.METHOD;
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        final boolean isArrow = this.functionType == 4;
        if (!this.isMethod()) {
            sb.append(this.makeIndent(depth));
            if (!isArrow) {
                sb.append("function");
            }
        }
        if (this.functionName != null) {
            sb.append(" ");
            sb.append(this.functionName.toSource(0));
        }
        if (this.params == null) {
            sb.append("() ");
        }
        else if (isArrow && this.lp == -1) {
            this.printList((List)this.params, sb);
            sb.append(" ");
        }
        else {
            sb.append("(");
            this.printList((List)this.params, sb);
            sb.append(") ");
        }
        if (isArrow) {
            sb.append("=> ");
        }
        if (this.isExpressionClosure) {
            AstNode body = this.getBody();
            if (body.getLastChild() instanceof ReturnStatement) {
                body = ((ReturnStatement)body.getLastChild()).getReturnValue();
                sb.append(body.toSource(0));
                if (this.functionType == 1) {
                    sb.append(";");
                }
            }
            else {
                sb.append(" ");
                sb.append(body.toSource(0));
            }
        }
        else {
            sb.append(this.getBody().toSource(depth).trim());
        }
        if (this.functionType == 1 || this.isMethod()) {
            sb.append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public void visit(final NodeVisitor v) {
        if (v.visit(this)) {
            if (this.functionName != null) {
                this.functionName.visit(v);
            }
            for (final AstNode param : this.getParams()) {
                param.visit(v);
            }
            this.getBody().visit(v);
        }
    }
    
    static {
        NO_PARAMS = Collections.unmodifiableList((List<? extends AstNode>)new ArrayList<AstNode>());
        NO_DEFAULT_PARAMS = Collections.unmodifiableMap((Map<? extends Integer, ? extends Node>)new HashMap<Integer, Node>());
    }
    
    public enum Form
    {
        FUNCTION, 
        GETTER, 
        SETTER, 
        METHOD;
    }
}
