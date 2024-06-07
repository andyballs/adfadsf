//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import java.util.*;

public interface TreeNode
{
    JsonToken asToken();
    
    JsonParser.NumberType numberType();
    
    int size();
    
    boolean isValueNode();
    
    boolean isContainerNode();
    
    boolean isMissingNode();
    
    boolean isArray();
    
    boolean isObject();
    
    TreeNode get(final String p0);
    
    TreeNode get(final int p0);
    
    TreeNode path(final String p0);
    
    TreeNode path(final int p0);
    
    Iterator<String> fieldNames();
    
    TreeNode at(final JsonPointer p0);
    
    TreeNode at(final String p0) throws IllegalArgumentException;
    
    JsonParser traverse();
    
    JsonParser traverse(final ObjectCodec p0);
}
