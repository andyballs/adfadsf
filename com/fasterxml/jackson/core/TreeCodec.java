//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import java.io.*;

public abstract class TreeCodec
{
    public abstract <T extends TreeNode> T readTree(final JsonParser p0) throws IOException, JsonProcessingException;
    
    public abstract void writeTree(final JsonGenerator p0, final TreeNode p1) throws IOException, JsonProcessingException;
    
    public TreeNode missingNode() {
        return null;
    }
    
    public TreeNode nullNode() {
        return null;
    }
    
    public abstract TreeNode createArrayNode();
    
    public abstract TreeNode createObjectNode();
    
    public abstract JsonParser treeAsTokens(final TreeNode p0);
}
