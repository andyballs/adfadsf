//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import java.io.*;
import com.fasterxml.jackson.core.type.*;
import java.util.*;

public abstract class ObjectCodec extends TreeCodec implements Versioned
{
    protected ObjectCodec() {
    }
    
    @Override
    public abstract Version version();
    
    public abstract <T> T readValue(final JsonParser p0, final Class<T> p1) throws IOException;
    
    public abstract <T> T readValue(final JsonParser p0, final TypeReference<T> p1) throws IOException;
    
    public abstract <T> T readValue(final JsonParser p0, final ResolvedType p1) throws IOException;
    
    public abstract <T> Iterator<T> readValues(final JsonParser p0, final Class<T> p1) throws IOException;
    
    public abstract <T> Iterator<T> readValues(final JsonParser p0, final TypeReference<T> p1) throws IOException;
    
    public abstract <T> Iterator<T> readValues(final JsonParser p0, final ResolvedType p1) throws IOException;
    
    public abstract void writeValue(final JsonGenerator p0, final Object p1) throws IOException;
    
    @Override
    public abstract <T extends TreeNode> T readTree(final JsonParser p0) throws IOException;
    
    @Override
    public abstract void writeTree(final JsonGenerator p0, final TreeNode p1) throws IOException;
    
    @Override
    public abstract TreeNode createObjectNode();
    
    @Override
    public abstract TreeNode createArrayNode();
    
    @Override
    public abstract JsonParser treeAsTokens(final TreeNode p0);
    
    public abstract <T> T treeToValue(final TreeNode p0, final Class<T> p1) throws JsonProcessingException;
    
    @Deprecated
    public JsonFactory getJsonFactory() {
        return this.getFactory();
    }
    
    public JsonFactory getFactory() {
        return this.getJsonFactory();
    }
}
