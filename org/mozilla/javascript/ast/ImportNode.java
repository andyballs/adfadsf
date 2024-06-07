//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.ast;

import java.util.*;

public class ImportNode extends AstNode
{
    private List<ModuleMember> namedMembers;
    private ModuleMember defaultMember;
    private ModuleMember moduleMember;
    private String filePath;
    
    public ImportNode() {
        this.namedMembers = new ArrayList<ModuleMember>();
        this.defaultMember = null;
        this.moduleMember = null;
        this.filePath = null;
        this.type = 120;
    }
    
    public List<ModuleMember> getNamedMembers() {
        return this.namedMembers;
    }
    
    public ModuleMember getDefaultMember() {
        return this.defaultMember;
    }
    
    public ModuleMember getModuleImport() {
        return this.moduleMember;
    }
    
    public void addNamedMember(final String targetName, final String scopeName) {
        this.namedMembers.add(new ModuleMember(targetName, scopeName));
    }
    
    public void setDefaultMember(final String scopeName) {
        this.defaultMember = new ModuleMember(null, scopeName);
    }
    
    public boolean hasDefaultMember() {
        return this.defaultMember != null;
    }
    
    public void setModuleMember(final String scopeName) {
        this.moduleMember = new ModuleMember(null, scopeName);
    }
    
    public boolean getModuleMember() {
        return this.moduleMember != null;
    }
    
    public String toSource(final int depth) {
        final StringBuilder sb = new StringBuilder("import ");
        if (this.getModuleMember()) {
            sb.append("* ");
            if (this.defaultMember.scopeName != null) {
                sb.append(" as ").append(this.defaultMember.scopeName);
            }
        }
        else if (this.hasDefaultMember()) {
            sb.append(this.defaultMember.scopeName);
        }
        if (!this.getModuleMember()) {
            if (this.hasDefaultMember()) {
                sb.append(",");
            }
            sb.append(" {");
            for (int i = 0, namedMemberSize = this.namedMembers.size(); i < namedMemberSize; ++i) {
                final ModuleMember imp = this.namedMembers.get(i);
                sb.append(' ').append(imp.targetName);
                if (imp.scopeName != null) {
                    sb.append(" as ").append(imp.scopeName);
                }
                if (i != namedMemberSize - 1) {
                    sb.append(',');
                }
            }
            sb.append(" } ");
        }
        sb.append("from '").append(this.filePath).append("';");
        return sb.toString();
    }
    
    public void visit(final NodeVisitor v) {
        v.visit(this);
    }
    
    public String getFilePath() {
        return this.filePath;
    }
    
    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }
    
    public static class ModuleMember
    {
        private String targetName;
        private String scopeName;
        
        public ModuleMember(final String targetName, final String scopeName) {
            this.targetName = targetName;
            this.scopeName = scopeName;
        }
        
        public String getTargetName() {
            return this.targetName;
        }
        
        public String getScopeName() {
            return this.scopeName;
        }
    }
}
