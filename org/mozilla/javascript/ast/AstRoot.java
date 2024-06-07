//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;
import org.mozilla.javascript.*;

public class AstRoot extends ScriptNode
{
    private SortedSet<Comment> comments;
    
    public AstRoot() {
        this.type = 146;
    }
    
    public AstRoot(final int pos) {
        super(pos);
        this.type = 146;
    }
    
    public SortedSet<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(final SortedSet<Comment> comments) {
        if (comments == null) {
            this.comments = null;
        }
        else {
            if (this.comments != null) {
                this.comments.clear();
            }
            for (final Comment c : comments) {
                this.addComment(c);
            }
        }
    }
    
    public void addComment(final Comment comment) {
        this.assertNotNull((Object)comment);
        if (this.comments == null) {
            this.comments = new TreeSet<Comment>((Comparator<? super Comment>)new AstNode.PositionComparator());
        }
        this.comments.add(comment);
        comment.setParent((AstNode)this);
    }
    
    public void visitComments(final NodeVisitor visitor) {
        if (this.comments != null) {
            for (final Comment c : this.comments) {
                visitor.visit(c);
            }
        }
    }
    
    public void visitAll(final NodeVisitor visitor) {
        this.visit(visitor);
        this.visitComments(visitor);
    }
    
    @Override
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder();
        for (final Node node : this) {
            sb.append(((AstNode)node).toSource(depth));
            if (node.getType() == 166) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    public String debugPrint() {
        final AstNode.DebugPrintVisitor dpv = new AstNode.DebugPrintVisitor(new StringBuilder(1000));
        this.visitAll((NodeVisitor)dpv);
        return dpv.toString();
    }
    
    public void checkParentLinks() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokedynamic   BootstrapMethod #0, visit:()Lorg/mozilla/javascript/ast/NodeVisitor;
        //     6: invokevirtual   org/mozilla/javascript/ast/AstRoot.visit:(Lorg/mozilla/javascript/ast/NodeVisitor;)V
        //     9: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Could not infer any expression.
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
        //     at java.base/java.lang.Thread.run(Thread.java:842)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
